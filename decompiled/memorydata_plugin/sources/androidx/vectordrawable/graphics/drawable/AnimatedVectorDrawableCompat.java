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
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        public AnimatedVectorDrawableCompatState(Context r4, AnimatedVectorDrawableCompatState r5, Drawable.Callback r6, Resources r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Drawable.Callback r9 = (Drawable.Callback) ZeusTransformUtils.wrapperContextForParams(r6, Drawable.Callback.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L19;
            this.mChangingConfigurations = r5.mChangingConfigurations;
            VectorDrawableCompat r10 = r5.mVectorDrawable;
            int r0 = 0;
            if (r10 == null) goto L11;
            Drawable.ConstantState r11 = r10.getConstantState();
            if (r7 == null) goto L9;
            Drawable r12 = r11.newDrawable(r7);
        L10:
            this.mVectorDrawable = (VectorDrawableCompat) ZeusTransformUtils.preCheckCast(r12, VectorDrawableCompat.class, "com.obric.memorydata.plugin");
            VectorDrawableCompat r13 = (VectorDrawableCompat) ZeusTransformUtils.preCheckCast(this.mVectorDrawable.mutate(), VectorDrawableCompat.class, "com.obric.memorydata.plugin");
            this.mVectorDrawable = r13;
            r13.setCallback(r9);
            this.mVectorDrawable.setBounds(r5.mVectorDrawable.getBounds());
            this.mVectorDrawable.setAllowCaching(false);
            goto L11
        L9:
            r12 = r11.newDrawable();
        L11:
            ArrayList<Animator> r14 = r5.mAnimators;
            if (r14 == null) goto L20;
            int r15 = r14.size();
            this.mAnimators = new ArrayList(r15);
            this.mTargetNameMap = new ArrayMap(r15);
        L14:
            if (r0 >= r15) goto L16;
            Animator r16 = (Animator) ZeusTransformUtils.preCheckCast(r5.mAnimators.get(r0), Animator.class, "com.obric.memorydata.plugin");
            Animator r17 = r16.clone();
            String r18 = (String) ZeusTransformUtils.preCheckCast(r5.mTargetNameMap.get(r16), String.class, "com.obric.memorydata.plugin");
            r17.setTarget(this.mVectorDrawable.getTargetByName(r18));
            this.mAnimators.add(r17);
            this.mTargetNameMap.put(r17, r18);
            r0 = r0 + 1;
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
        public Drawable newDrawable(Resources r1) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public void setupAnimatorSet() {
            if (this.mAnimatorSet != null) goto L5;
            this.mAnimatorSet = new AnimatorSet();
        L5:
            this.mAnimatorSet.playTogether(this.mAnimators);
        }
    }

    private static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState r1) {
            this.mDelegateState = r1;
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
            AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat();
            r0.mDelegateDrawable = this.mDelegateState.newDrawable();
            r0.mDelegateDrawable.setCallback(r0.mCallback);
            return r0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2) {
            AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat();
            r0.mDelegateDrawable = this.mDelegateState.newDrawable(r2);
            r0.mDelegateDrawable.setCallback(r0.mCallback);
            return r0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2, Resources.Theme r3) {
            AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat();
            r0.mDelegateDrawable = this.mDelegateState.newDrawable(r2, r3);
            r0.mDelegateDrawable.setCallback(r0.mCallback);
            return r0;
        }
    }

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null, null);
    }

    private AnimatedVectorDrawableCompat(Context r3, AnimatedVectorDrawableCompatState r4, Resources r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mArgbEvaluator = null;
        this.mAnimatorListener = null;
        this.mAnimationCallbacks = null;
        Drawable.Callback r0 = new AnonymousClass1(this);
        this.mCallback = r0;
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        this.mAnimatedVectorState = r4;
        return;
    L5:
        this.mAnimatedVectorState = new AnimatedVectorDrawableCompatState(r6, r4, r0, r5);
    }

    public static void clearAnimationCallbacks(Drawable r3) {
        if (ZeusTransformUtils.instanceOf(r3, Animatable.class) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L8;
        ((AnimatedVectorDrawable) ZeusTransformUtils.preCheckCast(r3, AnimatedVectorDrawable.class, "com.obric.memorydata.plugin")).clearAnimationCallbacks();
        return;
    L8:
        ((AnimatedVectorDrawableCompat) ZeusTransformUtils.preCheckCast(r3, AnimatedVectorDrawableCompat.class, "com.obric.memorydata.plugin")).clearAnimationCallbacks();
    }

    public static AnimatedVectorDrawableCompat create(Context r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L21;
        AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat(r9);
        r0.mDelegateDrawable = ResourcesCompat.getDrawable(ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin"), r8, r9.getTheme());
        r0.mDelegateDrawable.setCallback(r0.mCallback);
        r0.mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(r0.mDelegateDrawable.getConstantState());
        return r0;
    L21:
        XmlResourceParser r10 = ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin").getXml(r8);     // Catch: Throwable -> L18
        AttributeSet r2 = Xml.asAttributeSet(r10);     // Catch: Throwable -> L18
    L8:
        int r4 = r10.next();     // Catch: Throwable -> L18
        if (r4 == 2) goto L13;
        if (r4 != 1) goto L8;
    L13:
        if (r4 != 2) goto L17;
        return createFromXmlInner(r9, ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin"), r10, r2, r9.getTheme());
    L17:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L18
    L18:
        e = move-exception;
        Log.e(LOGTAG, "parser error", e);
        return null;
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context r2, Resources r3, XmlPullParser r4, AttributeSet r5, Resources.Theme r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r8 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        AnimatedVectorDrawableCompat r0 = new AnimatedVectorDrawableCompat(r7);
        r0.inflate(r3, r8, r9, r6);
        return r0;
    }

    public static void registerAnimationCallback(Drawable r3, Animatable2Compat.AnimationCallback r4) {
        if (r3 == null) goto L13;
        if (r4 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, Animatable.class) == true) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L11;
        registerPlatformCallback((AnimatedVectorDrawable) ZeusTransformUtils.preCheckCast(r3, AnimatedVectorDrawable.class, "com.obric.memorydata.plugin"), r4);
        return;
    L11:
        ((AnimatedVectorDrawableCompat) ZeusTransformUtils.preCheckCast(r3, AnimatedVectorDrawableCompat.class, "com.obric.memorydata.plugin")).registerAnimationCallback(r4);
        return;
    }

    private static void registerPlatformCallback(AnimatedVectorDrawable r0, Animatable2Compat.AnimationCallback r1) {
        r0.registerAnimationCallback(r1.getPlatformCallback());
    }

    private void removeAnimatorSetListener() {
        if (this.mAnimatorListener == null) goto L6;
        this.mAnimatedVectorState.mAnimatorSet.removeListener(this.mAnimatorListener);
        this.mAnimatorListener = null;
        return;
    }

    private void setupAnimatorsForTarget(String r3, Animator r4) {
        r4.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(r3));
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        setupColorAnimator(r4);
    L6:
        if (this.mAnimatedVectorState.mAnimators != null) goto L8;
        AnimatedVectorDrawableCompatState r0 = this.mAnimatedVectorState;
        r0.mAnimators = new ArrayList();
        AnimatedVectorDrawableCompatState r1 = this.mAnimatedVectorState;
        r1.mTargetNameMap = new ArrayMap();
    L8:
        this.mAnimatedVectorState.mAnimators.add(r4);
        this.mAnimatedVectorState.mTargetNameMap.put(r4, r3);
    }

    private void setupColorAnimator(Animator r6) {
        if (ZeusTransformUtils.instanceOf(r6, AnimatorSet.class) == false) goto L11;
        ArrayList<Animator> r0 = ((AnimatorSet) ZeusTransformUtils.preCheckCast(r6, AnimatorSet.class, "com.obric.memorydata.plugin")).getChildAnimations();
        if (r0 == null) goto L11;
        int r2 = 0;
    L8:
        if (r2 >= r0.size()) goto L11;
        setupColorAnimator((Animator) ZeusTransformUtils.preCheckCast(r0.get(r2), Animator.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
    L11:
        if (ZeusTransformUtils.instanceOf(r6, ObjectAnimator.class) == false) goto L22;
        ObjectAnimator r7 = (ObjectAnimator) ZeusTransformUtils.preCheckCast(r6, ObjectAnimator.class, "com.obric.memorydata.plugin");
        String r1 = r7.getPropertyName();
        if ("fillColor".equals(r1) == true) goto L17;
        if ("strokeColor".equals(r1) == true) goto L17;
        return;
    L17:
        if (this.mArgbEvaluator != null) goto L19;
        this.mArgbEvaluator = new android.animation.ArgbEvaluator();
    L19:
        r7.setEvaluator(this.mArgbEvaluator);
        return;
    }

    public static boolean unregisterAnimationCallback(Drawable r3, Animatable2Compat.AnimationCallback r4) {
        if (r3 == null) goto L15;
        if (r4 == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r3, Animatable.class) == true) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT < 24) goto L14;
        return unregisterPlatformCallback((AnimatedVectorDrawable) ZeusTransformUtils.preCheckCast(r3, AnimatedVectorDrawable.class, "com.obric.memorydata.plugin"), r4);
    L14:
        return ((AnimatedVectorDrawableCompat) ZeusTransformUtils.preCheckCast(r3, AnimatedVectorDrawableCompat.class, "com.obric.memorydata.plugin")).unregisterAnimationCallback(r4);
    L15:
        return false;
    }

    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable r0, Animatable2Compat.AnimationCallback r1) {
        return r0.unregisterAnimationCallback(r1.getPlatformCallback());
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r2) {
        if (this.mDelegateDrawable == null) goto L6;
        DrawableCompat.applyTheme(this.mDelegateDrawable, r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.mDelegateDrawable != null) goto L5;
        return false;
    L5:
        return DrawableCompat.canApplyTheme(this.mDelegateDrawable);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        if (this.mDelegateDrawable == null) goto L6;
        ((AnimatedVectorDrawable) ZeusTransformUtils.preCheckCast(this.mDelegateDrawable, AnimatedVectorDrawable.class, "com.obric.memorydata.plugin")).clearAnimationCallbacks();
        return;
    L6:
        removeAnimatorSetListener();
        ArrayList<Animatable2Compat.AnimationCallback> r2 = this.mAnimationCallbacks;
        if (r2 != null) goto L9;
        return;
    L9:
        r2.clear();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.draw(r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.draw(r2);
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted() == false) goto L10;
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.mDelegateDrawable == null) goto L7;
        return DrawableCompat.getAlpha(this.mDelegateDrawable);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.mDelegateDrawable != null) goto L5;
        int r0 = super.getChangingConfigurations();
        return this.mAnimatedVectorState.mChangingConfigurations | r0;
    L5:
        return this.mDelegateDrawable.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        if (this.mDelegateDrawable == null) goto L7;
        return DrawableCompat.getColorFilter(this.mDelegateDrawable);
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
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.getIntrinsicHeight();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.getIntrinsicWidth();
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
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.getOpacity();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect r1) {
        return super.getPadding(r1);
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
    public void inflate(Resources r3, XmlPullParser r4, AttributeSet r5) {
        inflate(r3, (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r7, XmlPullParser r8, AttributeSet r9, Resources.Theme r10) {
        XmlPullParser r11 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r8, XmlPullParser.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        if (this.mDelegateDrawable == null) goto L6;
        DrawableCompat.inflate(this.mDelegateDrawable, r7, r11, r12, r10);
        return;
    L6:
        int r0 = r11.getEventType();
        int r1 = r11.getDepth() + 1;
    L7:
        if (r0 == 1) goto L33;
        if (r11.getDepth() >= r1) goto L13;
        if (r0 == 3) goto L33;
    L13:
        if (r0 != 2) goto L32;
        String r2 = r11.getName();
        if (ANIMATED_VECTOR.equals(r2) == false) goto L24;
        TypedArray r3 = TypedArrayUtils.obtainAttributes(r7, r10, r12, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
        int r4 = r3.getResourceId(0, 0);
        if (r4 == 0) goto L22;
        VectorDrawableCompat r5 = VectorDrawableCompat.create(r7, r4, r10);
        r5.setAllowCaching(false);
        r5.setCallback(this.mCallback);
        if (this.mAnimatedVectorState.mVectorDrawable == null) goto L21;
        this.mAnimatedVectorState.mVectorDrawable.setCallback(null);
    L21:
        this.mAnimatedVectorState.mVectorDrawable = r5;
    L22:
        r3.recycle();
        goto L32
    L24:
        if ("target".equals(r2) == false) goto L32;
        r3 = r7.obtainAttributes(r12, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
        String r6 = r3.getString(0);
        int r13 = r3.getResourceId(1, 0);
        if (r13 == 0) goto L22;
        Context r14 = this.mContext;
        if (r14 == null) goto L30;
        setupAnimatorsForTarget(r6, AnimatorInflaterCompat.loadAnimator(r14, r13));
        goto L22
    L30:
        r3.recycle();
        throw new IllegalStateException("Context can't be null when inflating animators");
    L32:
        r0 = r11.next();
    L33:
        this.mAnimatedVectorState.setupAnimatorSet();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.mDelegateDrawable == null) goto L7;
        return DrawableCompat.isAutoMirrored(this.mDelegateDrawable);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        if (this.mDelegateDrawable == null) goto L7;
        return ((AnimatedVectorDrawable) ZeusTransformUtils.preCheckCast(this.mDelegateDrawable, AnimatedVectorDrawable.class, "com.obric.memorydata.plugin")).isRunning();
    L7:
        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.isStateful();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mDelegateDrawable == null) goto L5;
        this.mDelegateDrawable.mutate();
    L5:
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r2) {
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.setBounds(r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setBounds(r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public boolean onLevelChange(int r2) {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.setLevel(r2);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r2) {
        if (this.mDelegateDrawable == null) goto L7;
        return this.mDelegateDrawable.setState(r2);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.setState(r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback r3) {
        if (this.mDelegateDrawable == null) goto L6;
        registerPlatformCallback((AnimatedVectorDrawable) ZeusTransformUtils.preCheckCast(this.mDelegateDrawable, AnimatedVectorDrawable.class, "com.obric.memorydata.plugin"), r3);
        return;
    L6:
        if (r3 != null) goto L9;
        return;
    L9:
        if (this.mAnimationCallbacks != null) goto L12;
        this.mAnimationCallbacks = new ArrayList();
    L12:
        if (this.mAnimationCallbacks.contains(r3) == false) goto L14;
        return;
    L14:
        this.mAnimationCallbacks.add(r3);
        if (this.mAnimatorListener != null) goto L17;
        this.mAnimatorListener = new AnonymousClass2(this);
    L17:
        this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.setAlpha(r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r2) {
        if (this.mDelegateDrawable == null) goto L6;
        DrawableCompat.setAutoMirrored(this.mDelegateDrawable, r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int r1) {
        super.setChangingConfigurations(r1);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int r1, PorterDuff.Mode r2) {
        super.setColorFilter(r1, r2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        if (this.mDelegateDrawable == null) goto L6;
        this.mDelegateDrawable.setColorFilter(r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean r1) {
        super.setFilterBitmap(r1);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float r1, float r2) {
        super.setHotspot(r1, r2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int r1, int r2, int r3, int r4) {
        super.setHotspotBounds(r1, r2, r3, r4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] r1) {
        return super.setState(r1);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r2) {
        if (this.mDelegateDrawable == null) goto L6;
        DrawableCompat.setTint(this.mDelegateDrawable, r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTint(r2);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r2) {
        if (this.mDelegateDrawable == null) goto L6;
        DrawableCompat.setTintList(this.mDelegateDrawable, r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTintList(r2);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r2) {
        if (this.mDelegateDrawable == null) goto L6;
        DrawableCompat.setTintMode(this.mDelegateDrawable, r2);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r2, boolean r3) {
        if (this.mDelegateDrawable != null) goto L5;
        this.mAnimatedVectorState.mVectorDrawable.setVisible(r2, r3);
        return super.setVisible(r2, r3);
    L5:
        return this.mDelegateDrawable.setVisible(r2, r3);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.mDelegateDrawable == null) goto L7;
        ((AnimatedVectorDrawable) ZeusTransformUtils.preCheckCast(this.mDelegateDrawable, AnimatedVectorDrawable.class, "com.obric.memorydata.plugin")).start();
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
        if (this.mDelegateDrawable == null) goto L6;
        ((AnimatedVectorDrawable) ZeusTransformUtils.preCheckCast(this.mDelegateDrawable, AnimatedVectorDrawable.class, "com.obric.memorydata.plugin")).stop();
        return;
    L6:
        this.mAnimatedVectorState.mAnimatorSet.end();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback r4) {
        if (this.mDelegateDrawable == null) goto L5;
        unregisterPlatformCallback((AnimatedVectorDrawable) ZeusTransformUtils.preCheckCast(this.mDelegateDrawable, AnimatedVectorDrawable.class, "com.obric.memorydata.plugin"), r4);
    L5:
        ArrayList<Animatable2Compat.AnimationCallback> r0 = this.mAnimationCallbacks;
        if (r0 == null) goto L13;
        if (r4 == null) goto L15;
        boolean r5 = r0.remove(r4);
        if (this.mAnimationCallbacks.size() != 0) goto L12;
        removeAnimatorSetListener();
    L12:
        return r5;
    L15:
        return false;
    L13:
        return false;
    }
}
