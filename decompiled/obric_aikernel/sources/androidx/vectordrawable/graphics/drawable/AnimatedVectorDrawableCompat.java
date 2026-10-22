package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
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

    private static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {
        AnimatorSet mAnimatorSet;
        ArrayList<Animator> mAnimators;
        int mChangingConfigurations;
        ArrayMap<Animator, String> mTargetNameMap;
        VectorDrawableCompat mVectorDrawable;

        public AnimatedVectorDrawableCompatState(Context r10, AnimatedVectorDrawableCompatState r11, Drawable.Callback r12, Resources r13) {
            if (r11 == null) goto L19;
            this.mChangingConfigurations = r11.mChangingConfigurations;
            VectorDrawableCompat r14 = r11.mVectorDrawable;
            int r15 = 0;
            if (r14 == null) goto L11;
            Drawable.ConstantState r16 = r14.getConstantState();
            if (r13 == null) goto L9;
            Drawable r17 = r16.newDrawable(r13);
        L10:
            this.mVectorDrawable = (VectorDrawableCompat) r17;
            VectorDrawableCompat r18 = (VectorDrawableCompat) this.mVectorDrawable.mutate();
            this.mVectorDrawable = r18;
            r18.setCallback(r12);
            this.mVectorDrawable.setBounds(r11.mVectorDrawable.getBounds());
            this.mVectorDrawable.setAllowCaching(false);
            goto L11
        L9:
            r17 = r16.newDrawable();
        L11:
            ArrayList<Animator> r19 = r11.mAnimators;
            if (r19 == null) goto L20;
            int r20 = r19.size();
            this.mAnimators = new ArrayList(r20);
            this.mTargetNameMap = new ArrayMap(r20);
        L14:
            if (r15 >= r20) goto L16;
            Animator r21 = r11.mAnimators.get(r15);
            Animator r22 = r21.clone();
            String r23 = r11.mTargetNameMap.get(r21);
            r22.setTarget(this.mVectorDrawable.getTargetByName(r23));
            this.mAnimators.add(r22);
            this.mTargetNameMap.put(r22, r23);
            r15 = r15 + 1;
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

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r10) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public void setupAnimatorSet() {
            if (this.mAnimatorSet != null) goto L5;
            this.mAnimatorSet = new AnimatorSet();
        L5:
            this.mAnimatorSet.playTogether(this.mAnimators);
        }
    }

    @RequiresApi(24)
    private static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState r10) {
            this.mDelegateState = r10;
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
            AnimatedVectorDrawableCompat r10 = new AnimatedVectorDrawableCompat();
            Drawable r11 = this.mDelegateState.newDrawable();
            r10.mDelegateDrawable = r11;
            r11.setCallback(r10.mCallback);
            return r10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r10) {
            AnimatedVectorDrawableCompat r11 = new AnimatedVectorDrawableCompat();
            Drawable r12 = this.mDelegateState.newDrawable(r10);
            r11.mDelegateDrawable = r12;
            r12.setCallback(r11.mCallback);
            return r11;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r10, Resources.Theme r11) {
            AnimatedVectorDrawableCompat r12 = new AnimatedVectorDrawableCompat();
            Drawable r13 = this.mDelegateState.newDrawable(r10, r11);
            r12.mDelegateDrawable = r13;
            r13.setCallback(r12.mCallback);
            return r12;
        }
    }

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(@Nullable Context r10) {
        this(r10, null, null);
    }

    private AnimatedVectorDrawableCompat(@Nullable Context r10, @Nullable AnimatedVectorDrawableCompatState r11, @Nullable Resources r12) {
        this.mArgbEvaluator = null;
        this.mAnimatorListener = null;
        this.mAnimationCallbacks = null;
        Drawable.Callback r13 = new AnonymousClass1(this);
        this.mCallback = r13;
        this.mContext = r10;
        if (r11 == null) goto L5;
        this.mAnimatedVectorState = r11;
        return;
    L5:
        this.mAnimatedVectorState = new AnimatedVectorDrawableCompatState(r10, r11, r13, r12);
    }

    public static void clearAnimationCallbacks(Drawable r10) {
        if ((r10 instanceof Animatable) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L8;
        ((AnimatedVectorDrawable) r10).clearAnimationCallbacks();
        return;
    L8:
        ((AnimatedVectorDrawableCompat) r10).clearAnimationCallbacks();
    }

    @Nullable
    public static AnimatedVectorDrawableCompat create(@NonNull Context r10, @DrawableRes int r11) {
        if (Build.VERSION.SDK_INT < 24) goto L21;
        AnimatedVectorDrawableCompat r12 = new AnimatedVectorDrawableCompat(r10);
        Drawable r13 = ResourcesCompat.getDrawable(r10.getResources(), r11, r10.getTheme());
        r12.mDelegateDrawable = r13;
        r13.setCallback(r12.mCallback);
        r12.mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(r12.mDelegateDrawable.getConstantState());
        return r12;
    L21:
        XmlResourceParser r14 = r10.getResources().getXml(r11);     // Catch: Throwable -> L18
        AttributeSet r15 = Xml.asAttributeSet(r14);     // Catch: Throwable -> L18
    L8:
        int r16 = r14.next();     // Catch: Throwable -> L18
        if (r16 == 2) goto L13;
        if (r16 != 1) goto L8;
    L13:
        if (r16 != 2) goto L17;
        return createFromXmlInner(r10, r10.getResources(), r14, r15, r10.getTheme());
    L17:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L18
    L18:
        e = move-exception;
        Log.e(LOGTAG, "parser error", e);
        return null;
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context r10, Resources r11, XmlPullParser r12, AttributeSet r13, Resources.Theme r14) {
        AnimatedVectorDrawableCompat r15 = new AnimatedVectorDrawableCompat(r10);
        r15.inflate(r11, r12, r13, r14);
        return r15;
    }

    public static void registerAnimationCallback(Drawable r10, Animatable2Compat.AnimationCallback r11) {
        if (r10 == null) goto L13;
        if (r11 != null) goto L6;
        return;
    L6:
        if ((r10 instanceof Animatable) == true) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L11;
        registerPlatformCallback((AnimatedVectorDrawable) r10, r11);
        return;
    L11:
        ((AnimatedVectorDrawableCompat) r10).registerAnimationCallback(r11);
        return;
    }

    @RequiresApi(23)
    private static void registerPlatformCallback(@NonNull AnimatedVectorDrawable r10, @NonNull Animatable2Compat.AnimationCallback r11) {
        r10.registerAnimationCallback(r11.getPlatformCallback());
    }

    private void removeAnimatorSetListener() {
        Animator.AnimatorListener r10 = this.mAnimatorListener;
        if (r10 == null) goto L6;
        this.mAnimatedVectorState.mAnimatorSet.removeListener(r10);
        this.mAnimatorListener = null;
        return;
    }

    private void setupAnimatorsForTarget(String r10, Animator r11) {
        r11.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(r10));
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        setupColorAnimator(r11);
    L5:
        AnimatedVectorDrawableCompatState r12 = this.mAnimatedVectorState;
        if (r12.mAnimators != null) goto L8;
        r12.mAnimators = new ArrayList();
        AnimatedVectorDrawableCompatState r13 = this.mAnimatedVectorState;
        r13.mTargetNameMap = new ArrayMap();
    L8:
        this.mAnimatedVectorState.mAnimators.add(r11);
        this.mAnimatedVectorState.mTargetNameMap.put(r11, r10);
    }

    private void setupColorAnimator(Animator r10) {
        if ((r10 instanceof AnimatorSet) == false) goto L11;
        ArrayList<Animator> r11 = ((AnimatorSet) r10).getChildAnimations();
        if (r11 == null) goto L11;
        int r12 = 0;
    L8:
        if (r12 >= r11.size()) goto L11;
        setupColorAnimator(r11.get(r12));
        r12 = r12 + 1;
    L11:
        if ((r10 instanceof ObjectAnimator) == false) goto L22;
        ObjectAnimator r13 = (ObjectAnimator) r10;
        String r14 = r13.getPropertyName();
        if ("fillColor".equals(r14) == true) goto L17;
        if ("strokeColor".equals(r14) == true) goto L17;
        return;
    L17:
        if (this.mArgbEvaluator != null) goto L19;
        this.mArgbEvaluator = new android.animation.ArgbEvaluator();
    L19:
        r13.setEvaluator(this.mArgbEvaluator);
        return;
    }

    public static boolean unregisterAnimationCallback(Drawable r10, Animatable2Compat.AnimationCallback r11) {
        if (r10 == null) goto L15;
        if (r11 == null) goto L15;
        if ((r10 instanceof Animatable) == true) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT < 24) goto L14;
        return unregisterPlatformCallback((AnimatedVectorDrawable) r10, r11);
    L14:
        return ((AnimatedVectorDrawableCompat) r10).unregisterAnimationCallback(r11);
    L15:
        return false;
    }

    @RequiresApi(23)
    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable r10, Animatable2Compat.AnimationCallback r11) {
        return r10.unregisterAnimationCallback(r11.getPlatformCallback());
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        DrawableCompat.applyTheme(r11, r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 != null) goto L5;
        return false;
    L5:
        return DrawableCompat.canApplyTheme(r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        ((AnimatedVectorDrawable) r10).clearAnimationCallbacks();
        return;
    L6:
        removeAnimatorSetListener();
        ArrayList<Animatable2Compat.AnimationCallback> r11 = this.mAnimationCallbacks;
        if (r11 != null) goto L9;
        return;
    L9:
        r11.clear();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.draw(r10);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.draw(r10);
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted() == false) goto L10;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return DrawableCompat.getAlpha(r10);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 != null) goto L5;
        int r11 = super.getChangingConfigurations();
        return this.mAnimatedVectorState.mChangingConfigurations | r11;
    L5:
        return r10.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return DrawableCompat.getColorFilter(r10);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) goto L5;
        return null;
    L5:
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return null;
    L7:
        return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.getIntrinsicHeight();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.getIntrinsicWidth();
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
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.getOpacity();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect r10) {
        return super.getPadding(r10);
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
    public void inflate(Resources r10, XmlPullParser r11, AttributeSet r12) {
        inflate(r10, r11, r12, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        Drawable r14 = this.mDelegateDrawable;
        if (r14 == null) goto L6;
        DrawableCompat.inflate(r14, r10, r11, r12, r13);
        return;
    L6:
        int r15 = r11.getEventType();
        int r16 = r11.getDepth() + 1;
    L7:
        if (r15 == 1) goto L33;
        if (r11.getDepth() >= r16) goto L13;
        if (r15 == 3) goto L33;
    L13:
        if (r15 != 2) goto L32;
        String r17 = r11.getName();
        if (ANIMATED_VECTOR.equals(r17) == false) goto L24;
        TypedArray r18 = TypedArrayUtils.obtainAttributes(r10, r13, r12, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
        int r19 = r18.getResourceId(0, 0);
        if (r19 == 0) goto L22;
        VectorDrawableCompat r20 = VectorDrawableCompat.create(r10, r19, r13);
        r20.setAllowCaching(false);
        r20.setCallback(this.mCallback);
        VectorDrawableCompat r21 = this.mAnimatedVectorState.mVectorDrawable;
        if (r21 == null) goto L21;
        r21.setCallback(null);
    L21:
        this.mAnimatedVectorState.mVectorDrawable = r20;
    L22:
        r18.recycle();
        goto L32
    L24:
        if ("target".equals(r17) == false) goto L32;
        r18 = r10.obtainAttributes(r12, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
        String r22 = r18.getString(0);
        int r23 = r18.getResourceId(1, 0);
        if (r23 == 0) goto L22;
        Context r24 = this.mContext;
        if (r24 == null) goto L30;
        setupAnimatorsForTarget(r22, AnimatorInflaterCompat.loadAnimator(r24, r23));
        goto L22
    L30:
        r18.recycle();
        throw new IllegalStateException("Context can't be null when inflating animators");
    L32:
        r15 = r11.next();
    L33:
        this.mAnimatedVectorState.setupAnimatorSet();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return DrawableCompat.isAutoMirrored(r10);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return ((AnimatedVectorDrawable) r10).isRunning();
    L7:
        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        return r10.isStateful();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L5;
        r10.mutate();
    L5:
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.setBounds(r10);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setBounds(r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L7;
        return r11.setLevel(r10);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(r10);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L7;
        return r11.setState(r10);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.setState(r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        registerPlatformCallback((AnimatedVectorDrawable) r11, r10);
        return;
    L6:
        if (r10 != null) goto L9;
        return;
    L9:
        if (this.mAnimationCallbacks != null) goto L12;
        this.mAnimationCallbacks = new ArrayList();
    L12:
        if (this.mAnimationCallbacks.contains(r10) == false) goto L14;
        return;
    L14:
        this.mAnimationCallbacks.add(r10);
        if (this.mAnimatorListener != null) goto L17;
        this.mAnimatorListener = new AnonymousClass2(this);
    L17:
        this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.setAlpha(r10);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        DrawableCompat.setAutoMirrored(r11, r10);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int r10) {
        super.setChangingConfigurations(r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int r10, PorterDuff.Mode r11) {
        super.setColorFilter(r10, r11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        r11.setColorFilter(r10);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean r10) {
        super.setFilterBitmap(r10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float r10, float r11) {
        super.setHotspot(r10, r11);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int r10, int r11, int r12, int r13) {
        super.setHotspotBounds(r10, r11, r12, r13);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] r10) {
        return super.setState(r10);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        DrawableCompat.setTint(r11, r10);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTint(r10);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        DrawableCompat.setTintList(r11, r10);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTintList(r10);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L6;
        DrawableCompat.setTintMode(r11, r10);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r10, boolean r11) {
        Drawable r12 = this.mDelegateDrawable;
        if (r12 != null) goto L5;
        this.mAnimatedVectorState.mVectorDrawable.setVisible(r10, r11);
        return super.setVisible(r10, r11);
    L5:
        return r12.setVisible(r10, r11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L7;
        ((AnimatedVectorDrawable) r10).start();
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
        Drawable r10 = this.mDelegateDrawable;
        if (r10 == null) goto L6;
        ((AnimatedVectorDrawable) r10).stop();
        return;
    L6:
        this.mAnimatedVectorState.mAnimatorSet.end();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        Drawable r11 = this.mDelegateDrawable;
        if (r11 == null) goto L5;
        unregisterPlatformCallback((AnimatedVectorDrawable) r11, r10);
    L5:
        ArrayList<Animatable2Compat.AnimationCallback> r12 = this.mAnimationCallbacks;
        if (r12 == null) goto L13;
        if (r10 == null) goto L15;
        boolean r13 = r12.remove(r10);
        if (this.mAnimationCallbacks.size() != 0) goto L12;
        removeAnimatorSetListener();
    L12:
        return r13;
    L15:
        return false;
    L13:
        return false;
    }
}
