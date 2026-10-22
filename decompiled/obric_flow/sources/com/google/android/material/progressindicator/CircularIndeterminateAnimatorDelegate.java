package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.ArgbEvaluatorCompat;

/* JADX INFO: loaded from: classes2.dex */
final class CircularIndeterminateAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<CircularIndeterminateAnimatorDelegate, Float> ANIMATION_FRACTION = null;
    private static final Property<CircularIndeterminateAnimatorDelegate, Float> COMPLETE_END_FRACTION = null;
    private static final int CONSTANT_ROTATION_DEGREES = 1520;
    private static final int[] DELAY_TO_COLLAPSE_IN_MS = null;
    private static final int[] DELAY_TO_EXPAND_IN_MS = null;
    private static final int[] DELAY_TO_FADE_IN_MS = null;
    private static final int DURATION_TO_COLLAPSE_IN_MS = 667;
    private static final int DURATION_TO_COMPLETE_END_IN_MS = 333;
    private static final int DURATION_TO_EXPAND_IN_MS = 667;
    private static final int DURATION_TO_FADE_IN_MS = 333;
    private static final int EXTRA_DEGREES_PER_CYCLE = 250;
    private static final int TAIL_DEGREES_OFFSET = -20;
    private static final int TOTAL_CYCLES = 4;
    private static final int TOTAL_DURATION_IN_MS = 5400;
    private float animationFraction;
    private ObjectAnimator animator;
    Animatable2Compat.AnimationCallback animatorCompleteCallback;
    private final BaseProgressIndicatorSpec baseSpec;
    private ObjectAnimator completeEndAnimator;
    private float completeEndFraction;
    private int indicatorColorIndexOffset;
    private final FastOutSlowInInterpolator interpolator;

    static {
        DELAY_TO_EXPAND_IN_MS = new int[]{0, 1350, 2700, 4050};
        DELAY_TO_COLLAPSE_IN_MS = new int[]{667, 2017, 3367, 4717};
        DELAY_TO_FADE_IN_MS = new int[]{1000, 2350, 3700, 5050};
        final String r5 = "animationFraction";
        final Class<Float> r10 = Float.class;
        ANIMATION_FRACTION = new AnonymousClass3(r10, r5);
        final String r11 = "completeEndFraction";
        COMPLETE_END_FRACTION = new AnonymousClass4(r10, r11);
    }

    public CircularIndeterminateAnimatorDelegate(@NonNull CircularProgressIndicatorSpec r5) {
        super(1);
        this.indicatorColorIndexOffset = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = r5;
        this.interpolator = new FastOutSlowInInterpolator();
    }

    public static /* synthetic */ int access$000(CircularIndeterminateAnimatorDelegate r5) {
        return r5.indicatorColorIndexOffset;
    }

    public static /* synthetic */ int access$002(CircularIndeterminateAnimatorDelegate r5, int r10) {
        r5.indicatorColorIndexOffset = r10;
        return r10;
    }

    public static /* synthetic */ BaseProgressIndicatorSpec access$100(CircularIndeterminateAnimatorDelegate r5) {
        return r5.baseSpec;
    }

    public static /* synthetic */ float access$200(CircularIndeterminateAnimatorDelegate r5) {
        return r5.getAnimationFraction();
    }

    public static /* synthetic */ float access$300(CircularIndeterminateAnimatorDelegate r5) {
        return r5.getCompleteEndFraction();
    }

    public static /* synthetic */ void access$400(CircularIndeterminateAnimatorDelegate r5, float r10) {
        r5.setCompleteEndFraction(r10);
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    private float getCompleteEndFraction() {
        return this.completeEndFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator != null) goto L6;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
        this.animator = r5;
        r5.setDuration(5400);
        this.animator.setInterpolator(null);
        this.animator.setRepeatCount(-1);
        this.animator.addListener(new AnonymousClass1(this));
    L6:
        if (this.completeEndAnimator != null) goto L9;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this, COMPLETE_END_FRACTION, new float[]{0.0f, 1.0f});
        this.completeEndAnimator = r10;
        r10.setDuration(333);
        this.completeEndAnimator.setInterpolator(this.interpolator);
        this.completeEndAnimator.addListener(new AnonymousClass2(this));
        return;
    }

    private void maybeUpdateSegmentColors(int r10) {
        int r5 = 0;
    L4:
        if (r5 >= 4) goto L16;
        float r11 = getFractionInRange(r10, DELAY_TO_FADE_IN_MS[r5], 333);
        if (r11 < 0.0f) goto L10;
        if (r11 > 1.0f) goto L10;
        int r12 = r5 + this.indicatorColorIndexOffset;
        int[] r13 = this.baseSpec.indicatorColors;
        int r14 = r12 % r13.length;
        int r15 = (r14 + 1) % r13.length;
        int r16 = r13[r14];
        int r17 = r13[r15];
        float r18 = this.interpolator.getInterpolation(r11);
        this.activeIndicators.get(0).color = ArgbEvaluatorCompat.getInstance().evaluate2(r18, Integer.valueOf(r16), Integer.valueOf(r17)).intValue();
        return;
    L10:
        r5 = r5 + 1;
        goto L4
    }

    private void setCompleteEndFraction(float r5) {
        this.completeEndFraction = r5;
    }

    private void updateSegmentPositions(int r10) {
        int r5 = 0;
        DrawingDelegate.ActiveIndicator r11 = this.activeIndicators.get(0);
        float r12 = this.animationFraction;
        r11.startFraction = (r12 * 1520.0f) - 20.0f;
        r11.endFraction = r12 * 1520.0f;
    L4:
        if (r5 >= 4) goto L6;
        float r13 = getFractionInRange(r10, DELAY_TO_EXPAND_IN_MS[r5], 667);
        r11.endFraction = (this.interpolator.getInterpolation(r13) * 250.0f) + r11.endFraction;
        float r14 = getFractionInRange(r10, DELAY_TO_COLLAPSE_IN_MS[r5], 667);
        r11.startFraction = (this.interpolator.getInterpolation(r14) * 250.0f) + r11.startFraction;
        r5 = r5 + 1;
        goto L4
    L6:
        float r15 = r11.startFraction;
        float r16 = r11.endFraction;
        r11.startFraction = (((r16 - r15) * this.completeEndFraction) + r15) / 360.0f;
        r11.endFraction = r16 / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void cancelAnimatorImmediately() {
        ObjectAnimator r5 = this.animator;
        if (r5 == null) goto L6;
        r5.cancel();
        return;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void invalidateSpecValues() {
        resetPropertiesForNewStart();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void registerAnimatorsCompleteCallback(@NonNull Animatable2Compat.AnimationCallback r5) {
        this.animatorCompleteCallback = r5;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void requestCancelAnimatorAfterCurrentCycle() {
        ObjectAnimator r5 = this.completeEndAnimator;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isRunning() == false) goto L8;
        return;
    L8:
        if (this.drawable.isVisible() == false) goto L10;
        this.completeEndAnimator.start();
        return;
    L10:
        cancelAnimatorImmediately();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    @VisibleForTesting
    public void resetPropertiesForNewStart() {
        this.indicatorColorIndexOffset = 0;
        DrawingDelegate.ActiveIndicator r5 = this.activeIndicators.get(0);
        r5.color = this.baseSpec.indicatorColors[0];
        this.completeEndFraction = 0.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    @VisibleForTesting
    public void setAnimationFraction(float r5) {
        this.animationFraction = r5;
        int r10 = (int) (r5 * 5400.0f);
        updateSegmentPositions(r10);
        maybeUpdateSegmentColors(r10);
        this.drawable.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void unregisterAnimatorsCompleteCallback() {
        this.animatorCompleteCallback = null;
    }
}
