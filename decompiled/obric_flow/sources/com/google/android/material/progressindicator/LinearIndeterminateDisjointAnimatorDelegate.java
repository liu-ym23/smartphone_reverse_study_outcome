package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<LinearIndeterminateDisjointAnimatorDelegate, Float> ANIMATION_FRACTION = null;
    private static final int[] DELAY_TO_MOVE_SEGMENT_ENDS = null;
    private static final int[] DURATION_TO_MOVE_SEGMENT_ENDS = null;
    private static final int TOTAL_DURATION_IN_MS = 1800;
    private float animationFraction;
    private ObjectAnimator animator;
    Animatable2Compat.AnimationCallback animatorCompleteCallback;
    private final BaseProgressIndicatorSpec baseSpec;
    private ObjectAnimator completeEndAnimator;
    private boolean dirtyColors;
    private int indicatorColorIndex;
    private final Interpolator[] interpolatorArray;

    static {
        DURATION_TO_MOVE_SEGMENT_ENDS = new int[]{533, 567, 850, 750};
        DELAY_TO_MOVE_SEGMENT_ENDS = new int[]{1267, 1000, 333, 0};
        final Class<Float> r5 = Float.class;
        final String r10 = "animationFraction";
        ANIMATION_FRACTION = new AnonymousClass3(r5, r10);
    }

    public LinearIndeterminateDisjointAnimatorDelegate(@NonNull Context r10, @NonNull LinearProgressIndicatorSpec r11) {
        super(2);
        this.indicatorColorIndex = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = r11;
        this.interpolatorArray = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(r10, R.anim.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(r10, R.anim.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(r10, R.anim.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(r10, R.anim.linear_indeterminate_line2_tail_interpolator)};
    }

    public static /* synthetic */ int access$000(LinearIndeterminateDisjointAnimatorDelegate r5) {
        return r5.indicatorColorIndex;
    }

    public static /* synthetic */ int access$002(LinearIndeterminateDisjointAnimatorDelegate r5, int r10) {
        r5.indicatorColorIndex = r10;
        return r10;
    }

    public static /* synthetic */ BaseProgressIndicatorSpec access$100(LinearIndeterminateDisjointAnimatorDelegate r5) {
        return r5.baseSpec;
    }

    public static /* synthetic */ boolean access$202(LinearIndeterminateDisjointAnimatorDelegate r5, boolean r10) {
        r5.dirtyColors = r10;
        return r10;
    }

    public static /* synthetic */ float access$300(LinearIndeterminateDisjointAnimatorDelegate r5) {
        return r5.getAnimationFraction();
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator != null) goto L6;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{0.0f, 1.0f});
        this.animator = r5;
        r5.setDuration(1800);
        this.animator.setInterpolator(null);
        this.animator.setRepeatCount(-1);
        this.animator.addListener(new AnonymousClass1(this));
    L6:
        if (this.completeEndAnimator != null) goto L9;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, new float[]{1.0f});
        this.completeEndAnimator = r10;
        r10.setDuration(1800);
        this.completeEndAnimator.setInterpolator(null);
        this.completeEndAnimator.addListener(new AnonymousClass2(this));
        return;
    }

    private void maybeUpdateSegmentColors() {
        if (this.dirtyColors == false) goto L11;
        Iterator<DrawingDelegate.ActiveIndicator> r5 = this.activeIndicators.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        DrawingDelegate.ActiveIndicator r10 = r5.next();
        r10.color = this.baseSpec.indicatorColors[this.indicatorColorIndex];
        goto L6
    L8:
        this.dirtyColors = false;
        return;
    }

    private void updateSegmentPositions(int r10) {
        int r5 = 0;
    L4:
        if (r5 >= this.activeIndicators.size()) goto L6;
        DrawingDelegate.ActiveIndicator r11 = this.activeIndicators.get(r5);
        int[] r12 = DELAY_TO_MOVE_SEGMENT_ENDS;
        int r13 = r5 * 2;
        int r14 = r12[r13];
        int[] r15 = DURATION_TO_MOVE_SEGMENT_ENDS;
        float r16 = getFractionInRange(r10, r14, r15[r13]);
        r11.startFraction = MathUtils.clamp(this.interpolatorArray[r13].getInterpolation(r16), 0.0f, 1.0f);
        int r17 = r13 + 1;
        float r18 = getFractionInRange(r10, r12[r17], r15[r17]);
        r11.endFraction = MathUtils.clamp(this.interpolatorArray[r17].getInterpolation(r18), 0.0f, 1.0f);
        r5 = r5 + 1;
        goto L4
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
        if (r5.isRunning() == true) goto L13;
        cancelAnimatorImmediately();
        if (this.drawable.isVisible() == false) goto L12;
        this.completeEndAnimator.setFloatValues(new float[]{this.animationFraction, 1.0f});
        this.completeEndAnimator.setDuration((long) ((1.0f - this.animationFraction) * 1800.0f));
        this.completeEndAnimator.start();
        return;
    L12:
        return;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    @VisibleForTesting
    public void resetPropertiesForNewStart() {
        this.indicatorColorIndex = 0;
        Iterator<DrawingDelegate.ActiveIndicator> r5 = this.activeIndicators.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        DrawingDelegate.ActiveIndicator r10 = r5.next();
        r10.color = this.baseSpec.indicatorColors[0];
        goto L4
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    @VisibleForTesting
    public void setAnimationFraction(float r5) {
        this.animationFraction = r5;
        updateSegmentPositions((int) (r5 * 1800.0f));
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
        this.animatorCompleteCallback = null;
    }
}
