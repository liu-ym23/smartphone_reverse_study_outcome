package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {
    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = "AnimatedVDCompat";
    private static final String TARGET = "target";
    private AnimatedVectorDrawableCompatState mAnimatedVectorState;
    ArrayList<Animatable2Compat.AnimationCallback> mAnimationCallbacks;
    private Animator.AnimatorListener mAnimatorListener;
    private android.animation.ArgbEvaluator mArgbEvaluator;
    AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
    final Drawable.Callback mCallback;
    private Context mContext;

    public static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {
        AnimatorSet mAnimatorSet;
        ArrayList<Animator> mAnimators;
        int mChangingConfigurations;
        ArrayMap<Animator, String> mTargetNameMap;
        VectorDrawableCompat mVectorDrawable;

        public AnimatedVectorDrawableCompatState(Context r5, AnimatedVectorDrawableCompatState r10, Drawable.Callback r11, Resources r12) {
            if (r10 == null) goto L19;
            this.mChangingConfigurations = r10.mChangingConfigurations;
            VectorDrawableCompat r13 = r10.mVectorDrawable;
            int r14 = 0;
            if (r13 == null) goto L11;
            Drawable.ConstantState r15 = r13.getConstantState();
            if (r12 == null) goto L9;
            this.mVectorDrawable = (VectorDrawableCompat) r15.newDrawable(r12);
        L10:
            VectorDrawableCompat r16 = (VectorDrawableCompat) this.mVectorDrawable.mutate();
            this.mVectorDrawable = r16;
            r16.setCallback(r11);
            this.mVectorDrawable.setBounds(r10.mVectorDrawable.getBounds());
            this.mVectorDrawable.setAllowCaching(false);
            goto L11
        L9:
            this.mVectorDrawable = (VectorDrawableCompat) r15.newDrawable();
        L11:
            ArrayList<Animator> r17 = r10.mAnimators;
            if (r17 == null) goto L20;
            int r18 = r17.size();
            this.mAnimators = new ArrayList(r18);
            this.mTargetNameMap = new ArrayMap(r18);
        L14:
            if (r14 >= r18) goto L16;
            Animator r19 = r10.mAnimators.get(r14);
            Animator r20 = r19.clone();
            String r21 = r10.mTargetNameMap.get(r19);
            r20.setTarget(this.mVectorDrawable.getTargetByName(r21));
            this.mAnimators.add(r20);
            this.mTargetNameMap.put(r20, r21);
            r14 = r14 + 1;
            goto L14
        L16:
            setupAnimatorSet();
            return;
        L20:
            return;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public void setupAnimatorSet() {
            if (this.mAnimatorSet != null) goto L5;
            this.mAnimatorSet = new AnimatorSet();
        L5:
            this.mAnimatorSet.playTogether(this.mAnimators);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r5) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    @RequiresApi(24)
    public static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState r5) {
            this.mDelegateState = r5;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat r5 = new AnimatedVectorDrawableCompat();
            Drawable r10 = this.mDelegateState.newDrawable();
            r5.mDelegateDrawable = r10;
            r10.setCallback(r5.mCallback);
            return r5;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r5) {
            AnimatedVectorDrawableCompat r10 = new AnimatedVectorDrawableCompat();
            Drawable r11 = this.mDelegateState.newDrawable(r5);
            r10.mDelegateDrawable = r11;
            r11.setCallback(r10.mCallback);
            return r10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r5, Resources.Theme r10) {
            AnimatedVectorDrawableCompat r11 = new AnimatedVectorDrawableCompat();
            Drawable r12 = this.mDelegateState.newDrawable(r5, r10);
            r11.mDelegateDrawable = r12;
            r12.setCallback(r11.mCallback);
            return r11;
        }
    }

    public AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    @Nullable
    public static AnimatedVectorDrawableCompat create(@NonNull Context r5, @DrawableRes int r10) {
        AnimatedVectorDrawableCompat r11 = new AnimatedVectorDrawableCompat(r5);
        Drawable r12 = ResourcesCompat.getDrawable(r5.getResources(), r10, r5.getTheme());
        r11.mDelegateDrawable = r12;
        r12.setCallback(r11.mCallback);
        r11.mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(r11.mDelegateDrawable.getConstantState());
        return r11;
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context r5, Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat r14 = new AnimatedVectorDrawableCompat(r5);
        r14.inflate(r10, r11, r12, r13);
        return r14;
    }

    @RequiresApi(23)
    private static void registerPlatformCallback(@NonNull AnimatedVectorDrawable r5, @NonNull Animatable2Compat.AnimationCallback r10) {
        r5.registerAnimationCallback(r10.getPlatformCallback());
    }

    private void removeAnimatorSetListener() {
        Animator.AnimatorListener r5 = this.mAnimatorListener;
        if (r5 == null) goto L6;
        this.mAnimatedVectorState.mAnimatorSet.removeListener(r5);
        this.mAnimatorListener = null;
        return;
    }

    private void setupAnimatorsForTarget(String r5, Animator r10) {
        r10.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(r5));
        AnimatedVectorDrawableCompatState r11 = this.mAnimatedVectorState;
        if (r11.mAnimators != null) goto L5;
        r11.mAnimators = new ArrayList();
        AnimatedVectorDrawableCompatState r12 = this.mAnimatedVectorState;
        r12.mTargetNameMap = new ArrayMap();
    L5:
        this.mAnimatedVectorState.mAnimators.add(r10);
        this.mAnimatedVectorState.mTargetNameMap.put(r10, r5);
    }

    private void setupColorAnimator(Animator r5) {
        if ((r5 instanceof AnimatorSet) == false) goto L11;
        ArrayList<Animator> r10 = ((AnimatorSet) r5).getChildAnimations();
        if (r10 == null) goto L11;
        int r11 = 0;
    L8:
        if (r11 >= r10.size()) goto L11;
        setupColorAnimator(r10.get(r11));
        r11 = r11 + 1;
    L11:
        if ((r5 instanceof ObjectAnimator) == false) goto L22;
        ObjectAnimator r12 = (ObjectAnimator) r5;
        String r13 = r12.getPropertyName();
        if ("fillColor".equals(r13) == true) goto L17;
        if ("strokeColor".equals(r13) == true) goto L17;
        return;
    L17:
        if (this.mArgbEvaluator != null) goto L19;
        this.mArgbEvaluator = new android.animation.ArgbEvaluator();
    L19:
        r12.setEvaluator(this.mArgbEvaluator);
        return;
    }

    @RequiresApi(23)
    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable r5, Animatable2Compat.AnimationCallback r10) {
        return r5.unregisterAnimationCallback(r10.getPlatformCallback());
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        DrawableCompat.applyTheme(r10, r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 != null) goto L5;
        return false;
    L5:
        return DrawableCompat.canApplyTheme(r5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L6;
        ((AnimatedVectorDrawable) r5).clearAnimationCallbacks();
        return;
    L6:
        removeAnimatorSetListener();
        ArrayList<Animatable2Compat.AnimationCallback> r10 = this.mAnimationCallbacks;
        if (r10 != null) goto L9;
        return;
    L9:
        r10.clear();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        r10.draw(r5);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.draw(r5);
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted() == false) goto L10;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return DrawableCompat.getAlpha(r5);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 != null) goto L5;
        int r10 = super.getChangingConfigurations();
        return this.mAnimatedVectorState.mChangingConfigurations | r10;
    L5:
        return r5.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return DrawableCompat.getColorFilter(r5);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) goto L5;
        return null;
    L5:
        return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return r5.getIntrinsicHeight();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return r5.getIntrinsicWidth();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return r5.getOpacity();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect r5) {
        return super.getPadding(r5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) throws XmlPullParserException, IOException {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L6;
        DrawableCompat.inflate(r5, r10, r11, r12, r13);
        return;
    L6:
        int r14 = r11.getEventType();
        int r15 = r11.getDepth() + 1;
    L7:
        if (r14 == 1) goto L34;
        if (r11.getDepth() >= r15) goto L13;
        if (r14 == 3) goto L34;
    L13:
        if (r14 != 2) goto L33;
        String r16 = r11.getName();
        if (ANIMATED_VECTOR.equals(r16) == false) goto L24;
        TypedArray r17 = TypedArrayUtils.obtainAttributes(r10, r13, r12, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
        int r18 = r17.getResourceId(0, 0);
        if (r18 == 0) goto L22;
        VectorDrawableCompat r19 = VectorDrawableCompat.create(r10, r18, r13);
        r19.setAllowCaching(false);
        r19.setCallback(this.mCallback);
        VectorDrawableCompat r20 = this.mAnimatedVectorState.mVectorDrawable;
        if (r20 == null) goto L21;
        r20.setCallback(null);
    L21:
        this.mAnimatedVectorState.mVectorDrawable = r19;
    L22:
        r17.recycle();
        goto L33
    L24:
        if (TARGET.equals(r16) == false) goto L33;
        TypedArray r21 = r10.obtainAttributes(r12, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
        String r22 = r21.getString(0);
        int r23 = r21.getResourceId(1, 0);
        if (r23 == 0) goto L32;
        Context r24 = this.mContext;
        if (r24 == null) goto L30;
        setupAnimatorsForTarget(r22, AnimatorInflaterCompat.loadAnimator(r24, r23));
        goto L32
    L30:
        r21.recycle();
        throw new IllegalStateException("Context can't be null when inflating animators");
    L32:
        r21.recycle();
    L33:
        r14 = r11.next();
    L34:
        this.mAnimatedVectorState.setupAnimatorSet();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return DrawableCompat.isAutoMirrored(r5);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return ((AnimatedVectorDrawable) r5).isRunning();
    L7:
        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        return r5.isStateful();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L5;
        r5.mutate();
    L5:
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        r10.setBounds(r5);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setBounds(r5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public boolean onLevelChange(int r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.setLevel(r5);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.setState(r5);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.setState(r5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        registerPlatformCallback((AnimatedVectorDrawable) r10, r5);
        return;
    L6:
        if (r5 != null) goto L9;
        return;
    L9:
        if (this.mAnimationCallbacks != null) goto L12;
        this.mAnimationCallbacks = new ArrayList();
    L12:
        if (this.mAnimationCallbacks.contains(r5) == false) goto L14;
        return;
    L14:
        this.mAnimationCallbacks.add(r5);
        if (this.mAnimatorListener != null) goto L17;
        this.mAnimatorListener = new AnonymousClass2(this);
    L17:
        this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        r10.setAlpha(r5);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        DrawableCompat.setAutoMirrored(r10, r5);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(r5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int r5) {
        super.setChangingConfigurations(r5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int r5, PorterDuff.Mode r10) {
        super.setColorFilter(r5, r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean r5) {
        super.setFilterBitmap(r5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float r5, float r10) {
        super.setHotspot(r5, r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int r5, int r10, int r11, int r12) {
        super.setHotspotBounds(r5, r10, r11, r12);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] r5) {
        return super.setState(r5);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        DrawableCompat.setTint(r10, r5);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTint(r5);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        DrawableCompat.setTintList(r10, r5);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTintList(r5);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        DrawableCompat.setTintMode(r10, r5);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(r5);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r5, boolean r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 != null) goto L5;
        this.mAnimatedVectorState.mVectorDrawable.setVisible(r5, r10);
        return super.setVisible(r5, r10);
    L5:
        return r11.setVisible(r5, r10);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L7;
        ((AnimatedVectorDrawable) r5).start();
        return;
    L7:
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted() == false) goto L9;
        return;
    L9:
        this.mAnimatedVectorState.mAnimatorSet.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable r5 = this.mDelegateDrawable;
        if (r5 == null) goto L6;
        ((AnimatedVectorDrawable) r5).stop();
        return;
    L6:
        this.mAnimatedVectorState.mAnimatorSet.end();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L5;
        unregisterPlatformCallback((AnimatedVectorDrawable) r10, r5);
    L5:
        ArrayList<Animatable2Compat.AnimationCallback> r11 = this.mAnimationCallbacks;
        if (r11 == null) goto L13;
        if (r5 == null) goto L15;
        boolean r12 = r11.remove(r5);
        if (this.mAnimationCallbacks.size() != 0) goto L12;
        removeAnimatorSetListener();
    L12:
        return r12;
    L15:
        return false;
    L13:
        return false;
    }

    private AnimatedVectorDrawableCompat(@Nullable Context r5) {
        this(r5, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r5) {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        r10.setColorFilter(r5);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(r5);
    }

    private AnimatedVectorDrawableCompat(@Nullable Context r5, @Nullable AnimatedVectorDrawableCompatState r10, @Nullable Resources r11) {
        this.mArgbEvaluator = null;
        this.mAnimatorListener = null;
        this.mAnimationCallbacks = null;
        Drawable.Callback r12 = new AnonymousClass1(this);
        this.mCallback = r12;
        this.mContext = r5;
        if (r10 == null) goto L5;
        this.mAnimatedVectorState = r10;
        return;
    L5:
        this.mAnimatedVectorState = new AnimatedVectorDrawableCompatState(r5, r10, r12, r11);
    }

    public static void clearAnimationCallbacks(Drawable r5) {
        if ((r5 instanceof Animatable) == true) goto L5;
        return;
    L5:
        ((AnimatedVectorDrawable) r5).clearAnimationCallbacks();
    }

    public static boolean unregisterAnimationCallback(Drawable r5, Animatable2Compat.AnimationCallback r10) {
        if (r5 == null) goto L11;
        if (r10 == null) goto L11;
        if ((r5 instanceof Animatable) == true) goto L10;
        return false;
    L10:
        return unregisterPlatformCallback((AnimatedVectorDrawable) r5, r10);
    L11:
        return false;
    }

    public static void registerAnimationCallback(Drawable r5, Animatable2Compat.AnimationCallback r10) {
        if (r5 == null) goto L10;
        if (r10 != null) goto L6;
        return;
    L6:
        if ((r5 instanceof Animatable) == true) goto L8;
        return;
    L8:
        registerPlatformCallback((AnimatedVectorDrawable) r5, r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r5, XmlPullParser r10, AttributeSet r11) throws XmlPullParserException, IOException {
        inflate(r5, r10, r11, null);
    }
}
