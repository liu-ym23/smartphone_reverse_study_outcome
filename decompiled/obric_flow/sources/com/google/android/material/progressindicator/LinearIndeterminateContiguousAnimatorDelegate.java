package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class LinearIndeterminateContiguousAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<LinearIndeterminateContiguousAnimatorDelegate, Float> ANIMATION_FRACTION = null;
    private static final int DURATION_PER_CYCLE_IN_MS = 333;
    private static final int TOTAL_DURATION_IN_MS = 667;
    private float animationFraction;
    private ObjectAnimator animator;
    private final BaseProgressIndicatorSpec baseSpec;
    private boolean dirtyColors;
    private FastOutSlowInInterpolator interpolator;
    private int newIndicatorColorIndex;

    static {
        final Class<Float> r5 = Float.class;
        final String r10 = "animationFraction";
        ANIMATION_FRACTION = new AnonymousClass2(r5, r10);
    }

    public LinearIndeterminateContiguousAnimatorDelegate(@NonNull LinearProgressIndicatorSpec r5) {
        super(3);
        this.newIndicatorColorIndex = 1;
        this.baseSpec = r5;
        this.interpolator = new FastOutSlowInInterpolator();
    }

    public static /* synthetic */ int access$000(LinearIndeterminateContiguousAnimatorDelegate r5) {
        return r5.newIndicatorColorIndex;
    }

    public static /* synthetic */ int access$002(LinearIndeterminateContiguousAnimatorDelegate r5, int r10) {
        r5.newIndicatorColorIndex = r10;
        return r10;
    }

    public static /* synthetic */ BaseProgressIndicatorSpec access$100(LinearIndeterminateContiguousAnimatorDelegate r5) {
        return r5.baseSpec;
    }

    public static /* synthetic */ boolean access$202(LinearIndeterminateContiguousAnimatorDelegate r5, boolean r10) {
        r5.dirtyColors = r10;
        return r10;
    }

    public static /* synthetic */ float access$300(LinearIndeterminateContiguousAnimatorDelegate r5) {
        return r5.getAnimationFraction();
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator != null) goto L6;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
        this.animator = r5;
        r5.setDuration(333);
        this.animator.setInterpolator(null);
        this.animator.setRepeatCount(-1);
        this.animator.addListener(new AnonymousClass1(this));
        return;
    }

    private void maybeUpdateSegmentColors() {
        if (this.dirtyColors == true) goto L5;
        return;
    L5:
        if (this.activeIndicators.get(1).endFraction >= 1.0f) goto L9;
        DrawingDelegate.ActiveIndicator r5 = this.activeIndicators.get(2);
        r5.color = this.activeIndicators.get(1).color;
        DrawingDelegate.ActiveIndicator r10 = this.activeIndicators.get(1);
        r10.color = this.activeIndicators.get(0).color;
        DrawingDelegate.ActiveIndicator r11 = this.activeIndicators.get(0);
        r11.color = this.baseSpec.indicatorColors[this.newIndicatorColorIndex];
        this.dirtyColors = false;
        return;
    }

    private void updateSegmentPositions(int r5) {
        this.activeIndicators.get(0).startFraction = 0.0f;
        float r10 = getFractionInRange(r5, 0, TOTAL_DURATION_IN_MS);
        DrawingDelegate.ActiveIndicator r11 = this.activeIndicators.get(0);
        DrawingDelegate.ActiveIndicator r12 = this.activeIndicators.get(1);
        float r13 = this.interpolator.getInterpolation(r10);
        r12.startFraction = r13;
        r11.endFraction = r13;
        DrawingDelegate.ActiveIndicator r14 = this.activeIndicators.get(1);
        DrawingDelegate.ActiveIndicator r15 = this.activeIndicators.get(2);
        FastOutSlowInInterpolator r16 = this.interpolator;
        float r17 = r16.getInterpolation(r10 + 0.49925038f);
        r15.startFraction = r17;
        r14.endFraction = r17;
        this.activeIndicators.get(2).endFraction = 1.0f;
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
    public void registerAnimatorsCompleteCallback(@Nullable Animatable2Compat.AnimationCallback r5) {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void requestCancelAnimatorAfterCurrentCycle() {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    @VisibleForTesting
    public void resetPropertiesForNewStart() {
        this.dirtyColors = true;
        this.newIndicatorColorIndex = 1;
        Iterator<DrawingDelegate.ActiveIndicator> r5 = this.activeIndicators.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        DrawingDelegate.ActiveIndicator r10 = r5.next();
        BaseProgressIndicatorSpec r11 = this.baseSpec;
        r10.color = r11.indicatorColors[0];
        r10.gapSize = r11.indicatorTrackGapSize / 2;
        goto L4
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    @VisibleForTesting
    public void setAnimationFraction(float r5) {
        this.animationFraction = r5;
        updateSegmentPositions((int) (r5 * 333.0f));
        maybeUpdateSegmentColors();
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
    }
}
