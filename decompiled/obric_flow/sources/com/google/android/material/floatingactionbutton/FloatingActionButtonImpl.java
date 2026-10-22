package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class FloatingActionButtonImpl {
    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final long ELEVATION_ANIM_DELAY = 100;
    static final long ELEVATION_ANIM_DURATION = 100;
    static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = null;
    static final int[] EMPTY_STATE_SET = null;
    static final int[] ENABLED_STATE_SET = null;
    static final int[] FOCUSED_ENABLED_STATE_SET = null;
    private static final int HIDE_ANIM_DURATION_ATTR = 0;
    private static final int HIDE_ANIM_EASING_ATTR = 0;
    private static final float HIDE_ICON_SCALE = 0.4f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.4f;
    static final int[] HOVERED_ENABLED_STATE_SET = null;
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = null;
    static final int[] PRESSED_ENABLED_STATE_SET = null;
    static final float SHADOW_MULTIPLIER = 1.5f;
    private static final int SHOW_ANIM_DURATION_ATTR = 0;
    private static final int SHOW_ANIM_EASING_ATTR = 0;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    private static final float SPEC_HIDE_ICON_SCALE = 0.0f;
    private static final float SPEC_HIDE_SCALE = 0.0f;
    private int animState;

    @Nullable
    BorderDrawable borderDrawable;

    @Nullable
    Drawable contentBackground;

    @Nullable
    private Animator currentAnimator;
    float elevation;
    boolean ensureMinTouchTargetSize;
    private ArrayList<Animator.AnimatorListener> hideListeners;

    @Nullable
    private MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    private float imageMatrixScale;
    private int maxImageSize;
    int minTouchTargetSize;

    @Nullable
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    float pressedTranslationZ;

    @Nullable
    Drawable rippleDrawable;
    private float rotation;
    boolean shadowPaddingEnabled;
    final ShadowViewDelegate shadowViewDelegate;

    @Nullable
    ShapeAppearanceModel shapeAppearance;

    @Nullable
    MaterialShapeDrawable shapeDrawable;
    private ArrayList<Animator.AnimatorListener> showListeners;

    @Nullable
    private MotionSpec showMotionSpec;

    @NonNull
    private final StateListAnimator stateListAnimator;
    private final Matrix tmpMatrix;
    private final Rect tmpRect;
    private final RectF tmpRectF1;
    private final RectF tmpRectF2;
    private ArrayList<InternalTransformationCallback> transformationCallbacks;
    final FloatingActionButton view;

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$5, reason: invalid class name */
    public class AnonymousClass5 implements TypeEvaluator<Float> {
        FloatEvaluator floatEvaluator;
        final /* synthetic */ FloatingActionButtonImpl this$0;

        public AnonymousClass5(FloatingActionButtonImpl r5) {
            this.this$0 = r5;
            this.floatEvaluator = new FloatEvaluator();
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Float evaluate(float r5, Float r10, Float r11) {
            return evaluate2(r5, r10, r11);
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public Float evaluate2(float r5, Float r10, Float r11) {
            float r12 = this.floatEvaluator.evaluate(r5, r10, r11).floatValue();
            if (r12 >= 0.1f) goto L6;
            r12 = 0.0f;
        L6:
            return Float.valueOf(r12);
        }
    }

    public class DisabledElevationAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        public DisabledElevationAnimation(FloatingActionButtonImpl r5) {
            this.this$0 = r5;
            super(r5, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            return 0.0f;
        }
    }

    public class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        public ElevateToHoveredFocusedTranslationZAnimation(FloatingActionButtonImpl r5) {
            this.this$0 = r5;
            super(r5, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            FloatingActionButtonImpl r5 = this.this$0;
            return r5.elevation + r5.hoveredFocusedTranslationZ;
        }
    }

    public class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        public ElevateToPressedTranslationZAnimation(FloatingActionButtonImpl r5) {
            this.this$0 = r5;
            super(r5, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            FloatingActionButtonImpl r5 = this.this$0;
            return r5.elevation + r5.pressedTranslationZ;
        }
    }

    public interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    public interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    public class ResetElevationAnimation extends ShadowAnimatorImpl {
        final /* synthetic */ FloatingActionButtonImpl this$0;

        public ResetElevationAnimation(FloatingActionButtonImpl r5) {
            this.this$0 = r5;
            super(r5, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            return this.this$0.elevation;
        }
    }

    public abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private float shadowSizeEnd;
        private float shadowSizeStart;
        final /* synthetic */ FloatingActionButtonImpl this$0;
        private boolean validValues;

        private ShadowAnimatorImpl(FloatingActionButtonImpl r5) {
            this.this$0 = r5;
        }

        public abstract float getTargetShadowSize();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r5) {
            this.this$0.updateShapeElevation((int) this.shadowSizeEnd);
            this.validValues = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator r5) {
            if (this.validValues == true) goto L9;
            MaterialShapeDrawable r10 = this.this$0.shapeDrawable;
            if (r10 != null) goto L7;
            float r11 = 0.0f;
        L8:
            this.shadowSizeStart = r11;
            this.shadowSizeEnd = getTargetShadowSize();
            this.validValues = true;
            goto L9
        L7:
            r11 = r10.getElevation();
        L9:
            FloatingActionButtonImpl r12 = this.this$0;
            float r13 = this.shadowSizeStart;
            r12.updateShapeElevation((int) ((r5.getAnimatedFraction() * (this.shadowSizeEnd - r13)) + r13));
        }

        public /* synthetic */ ShadowAnimatorImpl(FloatingActionButtonImpl r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    static {
        ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        SHOW_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
        SHOW_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
        HIDE_ANIM_DURATION_ATTR = R.attr.motionDurationMedium1;
        HIDE_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;
        PRESSED_ENABLED_STATE_SET = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        HOVERED_FOCUSED_ENABLED_STATE_SET = new int[]{android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
        FOCUSED_ENABLED_STATE_SET = new int[]{android.R.attr.state_focused, android.R.attr.state_enabled};
        HOVERED_ENABLED_STATE_SET = new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled};
        ENABLED_STATE_SET = new int[]{android.R.attr.state_enabled};
        EMPTY_STATE_SET = new int[0];
    }

    public FloatingActionButtonImpl(FloatingActionButton r5, ShadowViewDelegate r10) {
        this.shadowPaddingEnabled = true;
        this.imageMatrixScale = 1.0f;
        this.animState = 0;
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpMatrix = new Matrix();
        this.view = r5;
        this.shadowViewDelegate = r10;
        StateListAnimator r11 = new StateListAnimator();
        this.stateListAnimator = r11;
        r11.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation(this)));
        r11.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        r11.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        r11.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation(this)));
        r11.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation(this)));
        r11.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation(this)));
        this.rotation = r5.getRotation();
    }

    public static /* synthetic */ int access$002(FloatingActionButtonImpl r5, int r10) {
        r5.animState = r10;
        return r10;
    }

    public static /* synthetic */ Animator access$102(FloatingActionButtonImpl r5, Animator r10) {
        r5.currentAnimator = r10;
        return r10;
    }

    public static /* synthetic */ float access$202(FloatingActionButtonImpl r5, float r10) {
        r5.imageMatrixScale = r10;
        return r10;
    }

    public static /* synthetic */ void access$300(FloatingActionButtonImpl r5, float r10, Matrix r11) {
        r5.calculateImageMatrixFromScale(r10, r11);
    }

    private void calculateImageMatrixFromScale(float r10, @NonNull Matrix r11) {
        r11.reset();
        Drawable r5 = this.view.getDrawable();
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.maxImageSize == 0) goto L9;
        RectF r12 = this.tmpRectF1;
        RectF r13 = this.tmpRectF2;
        r12.set(0.0f, 0.0f, r5.getIntrinsicWidth(), r5.getIntrinsicHeight());
        int r14 = this.maxImageSize;
        r13.set(0.0f, 0.0f, r14, r14);
        r11.setRectToRect(r12, r13, Matrix.ScaleToFit.CENTER);
        int r15 = this.maxImageSize;
        r11.postScale(r10, r10, r15 / 2.0f, r15 / 2.0f);
        return;
    }

    @NonNull
    private AnimatorSet createAnimator(@NonNull MotionSpec r10, float r11, float r12, float r13) {
        ArrayList r5 = new ArrayList();
        ObjectAnimator r14 = ObjectAnimator.ofFloat(this.view, View.ALPHA, new float[]{r11});
        r10.getTiming("opacity").apply(r14);
        r5.add(r14);
        ObjectAnimator r15 = ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{r12});
        r10.getTiming("scale").apply(r15);
        workAroundOreoBug(r15);
        r5.add(r15);
        ObjectAnimator r16 = ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{r12});
        r10.getTiming("scale").apply(r16);
        workAroundOreoBug(r16);
        r5.add(r16);
        calculateImageMatrixFromScale(r13, this.tmpMatrix);
        ObjectAnimator r17 = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new AnonymousClass3(this), new Matrix[]{new Matrix(this.tmpMatrix)});
        r10.getTiming("iconScale").apply(r17);
        r5.add(r17);
        AnimatorSet r18 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r18, r5);
        return r18;
    }

    private AnimatorSet createDefaultAnimator(final float r16, final float r17, final float r18, int r19, int r20) {
        AnimatorSet r11 = new AnimatorSet();
        ArrayList r12 = new ArrayList();
        ValueAnimator r13 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        final float r5 = this.view.getAlpha();
        final float r10 = this.view.getScaleX();
        final float r14 = this.view.getScaleY();
        final float r15 = this.imageMatrixScale;
        final Matrix r21 = new Matrix(this.tmpMatrix);
        r13.addUpdateListener(new AnonymousClass4(this, r5, r16, r10, r17, r14, r15, r18, r21));
        r12.add(r13);
        AnimatorSetCompat.playTogether(r11, r12);
        r11.setDuration(MotionUtils.resolveThemeDuration(this.view.getContext(), r19, this.view.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        r11.setInterpolator(MotionUtils.resolveThemeInterpolator(this.view.getContext(), r20, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return r11;
    }

    @NonNull
    private ValueAnimator createElevationAnimator(@NonNull ShadowAnimatorImpl r5) {
        ValueAnimator r10 = new ValueAnimator();
        r10.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        r10.setDuration(100);
        r10.addListener(r5);
        r10.addUpdateListener(r5);
        r10.setFloatValues(new float[]{0.0f, 1.0f});
        return r10;
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener getOrCreatePreDrawListener() {
        if (this.preDrawListener != null) goto L6;
        this.preDrawListener = new AnonymousClass6(this);
    L6:
        return this.preDrawListener;
    }

    private boolean shouldAnimateVisibilityChange() {
        if (ViewCompat.isLaidOut(this.view) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.view.isInEditMode() == true) goto L7;
        return true;
    }

    private void workAroundOreoBug(ObjectAnimator r5) {
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener r5) {
        if (this.hideListeners != null) goto L5;
        this.hideListeners = new ArrayList();
    L5:
        this.hideListeners.add(r5);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener r5) {
        if (this.showListeners != null) goto L5;
        this.showListeners = new ArrayList();
    L5:
        this.showListeners.add(r5);
    }

    public void addTransformationCallback(@NonNull InternalTransformationCallback r5) {
        if (this.transformationCallbacks != null) goto L5;
        this.transformationCallbacks = new ArrayList();
    L5:
        this.transformationCallbacks.add(r5);
    }

    public MaterialShapeDrawable createShapeDrawable() {
        return new MaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
    }

    @Nullable
    public final Drawable getContentBackground() {
        return this.contentBackground;
    }

    public float getElevation() {
        return this.elevation;
    }

    public boolean getEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    @Nullable
    public final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    public void getPadding(@NonNull Rect r5) {
        int r10 = getTouchTargetPadding();
        if (this.shadowPaddingEnabled == false) goto L5;
        float r11 = getElevation() + this.pressedTranslationZ;
    L6:
        int r12 = Math.max(r10, (int) Math.ceil(r11));
        int r13 = Math.max(r10, (int) Math.ceil(r11 * SHADOW_MULTIPLIER));
        r5.set(r12, r13, r12, r13);
        return;
    L5:
        r11 = 0.0f;
        goto L6
    }

    public float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    @Nullable
    public final ShapeAppearanceModel getShapeAppearance() {
        return this.shapeAppearance;
    }

    @Nullable
    public final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public int getTouchTargetPadding() {
        if (this.ensureMinTouchTargetSize == true) goto L5;
        return 0;
    L5:
        return Math.max((this.minTouchTargetSize - this.view.getSizeDimension()) / 2, 0);
    }

    public void hide(@Nullable final InternalVisibilityChangedListener r10, final boolean r11) {
        if (isOrWillBeHidden() == false) goto L5;
        return;
    L5:
        Animator r5 = this.currentAnimator;
        if (r5 == null) goto L9;
        r5.cancel();
    L9:
        if (shouldAnimateVisibilityChange() == false) goto L21;
        MotionSpec r12 = this.hideMotionSpec;
        if (r12 == null) goto L13;
        AnimatorSet r13 = createAnimator(r12, 0.0f, 0.0f, 0.0f);
    L14:
        r13.addListener(new AnonymousClass1(this, r11, r10));
        ArrayList<Animator.AnimatorListener> r14 = this.hideListeners;
        if (r14 == null) goto L20;
        Iterator<Animator.AnimatorListener> r15 = r14.iterator();
    L18:
        if (r15.hasNext() == false) goto L20;
        r13.addListener(r15.next());
    L20:
        r13.start();
        return;
    L13:
        r13 = createDefaultAnimator(0.0f, 0.4f, 0.4f, HIDE_ANIM_DURATION_ATTR, HIDE_ANIM_EASING_ATTR);
        goto L14
    L21:
        FloatingActionButton r16 = this.view;
        if (r11 == false) goto L24;
        int r17 = 8;
    L25:
        r16.internalSetVisibility(r17, r11);
        if (r10 == null) goto L31;
        r10.onHidden();
        return;
    L31:
        return;
    L24:
        r17 = 4;
        goto L25
    }

    public void initializeBackgroundDrawable(ColorStateList r5, @Nullable PorterDuff.Mode r10, ColorStateList r11, int r12) {
        MaterialShapeDrawable r13 = createShapeDrawable();
        this.shapeDrawable = r13;
        r13.setTintList(r5);
        if (r10 == null) goto L5;
        this.shapeDrawable.setTintMode(r10);
    L5:
        this.shapeDrawable.setShadowColor(-12303292);
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        RippleDrawableCompat r14 = new RippleDrawableCompat(this.shapeDrawable.getShapeAppearanceModel());
        r14.setTintList(RippleUtils.sanitizeRippleDrawableColor(r11));
        this.rippleDrawable = r14;
        this.contentBackground = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.shapeDrawable), r14});
    }

    public boolean isOrWillBeHidden() {
        if (this.view.getVisibility() != 0) goto L9;
        if (this.animState == 1) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.animState != 2) goto L11;
        return false;
    L11:
        return true;
    }

    public boolean isOrWillBeShown() {
        if (this.view.getVisibility() == 0) goto L9;
        if (this.animState == 2) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (this.animState != 1) goto L11;
        return false;
    L11:
        return true;
    }

    public void jumpDrawableToCurrentState() {
        this.stateListAnimator.jumpToCurrentState();
    }

    public void onAttachedToWindow() {
        MaterialShapeDrawable r5 = this.shapeDrawable;
        if (r5 == null) goto L6;
        MaterialShapeUtils.setParentAbsoluteElevation(this.view, r5);
    L6:
        if (requirePreDrawListener() == false) goto L9;
        this.view.getViewTreeObserver().addOnPreDrawListener(getOrCreatePreDrawListener());
        return;
    }

    public void onCompatShadowChanged() {
    }

    public void onDetachedFromWindow() {
        ViewTreeObserver r5 = this.view.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener r10 = this.preDrawListener;
        if (r10 == null) goto L6;
        r5.removeOnPreDrawListener(r10);
        this.preDrawListener = null;
        return;
    }

    public void onDrawableStateChanged(int[] r5) {
        this.stateListAnimator.setState(r5);
    }

    public void onElevationsChanged(float r5, float r10, float r11) {
        jumpDrawableToCurrentState();
        updatePadding();
        updateShapeElevation(r5);
    }

    public void onPaddingUpdated(@NonNull Rect r10) {
        Preconditions.checkNotNull(this.contentBackground, "Didn't initialize content background");
        if (shouldAddPadding() == false) goto L5;
        InsetDrawable r5 = new InsetDrawable(this.contentBackground, r10.left, r10.top, r10.right, r10.bottom);
        this.shadowViewDelegate.setBackgroundDrawable(r5);
        return;
    L5:
        this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
    }

    public void onPreDraw() {
        float r5 = this.view.getRotation();
        if (this.rotation == r5) goto L6;
        this.rotation = r5;
        updateFromViewRotation();
        return;
    }

    public void onScaleChanged() {
        ArrayList<InternalTransformationCallback> r5 = this.transformationCallbacks;
        if (r5 == null) goto L8;
        Iterator<InternalTransformationCallback> r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        r10.next().onScaleChanged();
        goto L6
    L10:
        return;
    }

    public void onTranslationChanged() {
        ArrayList<InternalTransformationCallback> r5 = this.transformationCallbacks;
        if (r5 == null) goto L8;
        Iterator<InternalTransformationCallback> r10 = r5.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        r10.next().onTranslationChanged();
        goto L6
    L10:
        return;
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener r5) {
        ArrayList<Animator.AnimatorListener> r10 = this.hideListeners;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.remove(r5);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener r5) {
        ArrayList<Animator.AnimatorListener> r10 = this.showListeners;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.remove(r5);
    }

    public void removeTransformationCallback(@NonNull InternalTransformationCallback r5) {
        ArrayList<InternalTransformationCallback> r10 = this.transformationCallbacks;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.remove(r5);
    }

    public boolean requirePreDrawListener() {
        return true;
    }

    public void setBackgroundTintList(@Nullable ColorStateList r5) {
        MaterialShapeDrawable r10 = this.shapeDrawable;
        if (r10 == null) goto L5;
        r10.setTintList(r5);
    L5:
        BorderDrawable r11 = this.borderDrawable;
        if (r11 == null) goto L9;
        r11.setBorderTint(r5);
        return;
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode r5) {
        MaterialShapeDrawable r10 = this.shapeDrawable;
        if (r10 == null) goto L6;
        r10.setTintMode(r5);
        return;
    }

    public final void setElevation(float r5) {
        if (this.elevation == r5) goto L6;
        this.elevation = r5;
        onElevationsChanged(r5, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        return;
    }

    public void setEnsureMinTouchTargetSize(boolean r5) {
        this.ensureMinTouchTargetSize = r5;
    }

    public final void setHideMotionSpec(@Nullable MotionSpec r5) {
        this.hideMotionSpec = r5;
    }

    public final void setHoveredFocusedTranslationZ(float r5) {
        if (this.hoveredFocusedTranslationZ == r5) goto L6;
        this.hoveredFocusedTranslationZ = r5;
        onElevationsChanged(this.elevation, r5, this.pressedTranslationZ);
        return;
    }

    public final void setImageMatrixScale(float r5) {
        this.imageMatrixScale = r5;
        Matrix r10 = this.tmpMatrix;
        calculateImageMatrixFromScale(r5, r10);
        this.view.setImageMatrix(r10);
    }

    public final void setMaxImageSize(int r5) {
        if (this.maxImageSize == r5) goto L6;
        this.maxImageSize = r5;
        updateImageMatrixScale();
        return;
    }

    public void setMinTouchTargetSize(int r5) {
        this.minTouchTargetSize = r5;
    }

    public final void setPressedTranslationZ(float r5) {
        if (this.pressedTranslationZ == r5) goto L6;
        this.pressedTranslationZ = r5;
        onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, r5);
        return;
    }

    public void setRippleColor(@Nullable ColorStateList r5) {
        Drawable r10 = this.rippleDrawable;
        if (r10 == null) goto L6;
        DrawableCompat.setTintList(r10, RippleUtils.sanitizeRippleDrawableColor(r5));
        return;
    }

    public void setShadowPaddingEnabled(boolean r5) {
        this.shadowPaddingEnabled = r5;
        updatePadding();
    }

    public final void setShapeAppearance(@NonNull ShapeAppearanceModel r5) {
        this.shapeAppearance = r5;
        MaterialShapeDrawable r10 = this.shapeDrawable;
        if (r10 == null) goto L5;
        r10.setShapeAppearanceModel(r5);
    L5:
        Object r11 = this.rippleDrawable;
        if ((r11 instanceof Shapeable) == false) goto L8;
        ((Shapeable) r11).setShapeAppearanceModel(r5);
    L8:
        BorderDrawable r12 = this.borderDrawable;
        if (r12 == null) goto L12;
        r12.setShapeAppearanceModel(r5);
        return;
    }

    public final void setShowMotionSpec(@Nullable MotionSpec r5) {
        this.showMotionSpec = r5;
    }

    public boolean shouldAddPadding() {
        return true;
    }

    public final boolean shouldExpandBoundsForA11y() {
        if (this.ensureMinTouchTargetSize == true) goto L5;
    L8:
        return true;
    L5:
        if (this.view.getSizeDimension() >= this.minTouchTargetSize) goto L8;
        return false;
    }

    public void show(@Nullable final InternalVisibilityChangedListener r10, final boolean r11) {
        if (isOrWillBeShown() == false) goto L5;
        return;
    L5:
        Animator r5 = this.currentAnimator;
        if (r5 == null) goto L9;
        r5.cancel();
    L9:
        if (this.showMotionSpec != null) goto L11;
        boolean r12 = true;
    L13:
        if (shouldAnimateVisibilityChange() == true) goto L15;
        this.view.internalSetVisibility(0, r11);
        this.view.setAlpha(1.0f);
        this.view.setScaleY(1.0f);
        this.view.setScaleX(1.0f);
        setImageMatrixScale(1.0f);
        if (r10 == null) goto L45;
        r10.onShown();
        return;
    L45:
        return;
    L15:
        if (this.view.getVisibility() == 0) goto L28;
        float r13 = 0.0f;
        this.view.setAlpha(0.0f);
        FloatingActionButton r14 = this.view;
        if (r12 == false) goto L19;
        float r15 = 0.4f;
    L20:
        r14.setScaleY(r15);
        FloatingActionButton r16 = this.view;
        if (r12 == false) goto L23;
        float r17 = 0.4f;
    L24:
        r16.setScaleX(r17);
        if (r12 == false) goto L27;
        r13 = 0.4f;
    L27:
        setImageMatrixScale(r13);
        goto L28
    L23:
        r17 = 0.0f;
        goto L24
    L19:
        r15 = 0.0f;
    L28:
        MotionSpec r18 = this.showMotionSpec;
        if (r18 == null) goto L31;
        AnimatorSet r19 = createAnimator(r18, 1.0f, 1.0f, 1.0f);
    L32:
        r19.addListener(new AnonymousClass2(this, r11, r10));
        ArrayList<Animator.AnimatorListener> r20 = this.showListeners;
        if (r20 == null) goto L38;
        Iterator<Animator.AnimatorListener> r21 = r20.iterator();
    L36:
        if (r21.hasNext() == false) goto L38;
        r19.addListener(r21.next());
    L38:
        r19.start();
        return;
    L31:
        r19 = createDefaultAnimator(1.0f, 1.0f, 1.0f, SHOW_ANIM_DURATION_ATTR, SHOW_ANIM_EASING_ATTR);
        goto L32
    L11:
        r12 = false;
        goto L13
    }

    public void updateFromViewRotation() {
        MaterialShapeDrawable r5 = this.shapeDrawable;
        if (r5 == null) goto L6;
        r5.setShadowCompatRotation((int) this.rotation);
        return;
    }

    public final void updateImageMatrixScale() {
        setImageMatrixScale(this.imageMatrixScale);
    }

    public final void updatePadding() {
        Rect r5 = this.tmpRect;
        getPadding(r5);
        onPaddingUpdated(r5);
        this.shadowViewDelegate.setShadowPadding(r5.left, r5.top, r5.right, r5.bottom);
    }

    public void updateShapeElevation(float r5) {
        MaterialShapeDrawable r10 = this.shapeDrawable;
        if (r10 == null) goto L6;
        r10.setElevation(r5);
        return;
    }
}
