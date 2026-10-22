package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialBottomContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private final float maxScaleXDistance;
    private final float maxScaleYDistance;

    public MaterialBottomContainerBackHelper(@NonNull View r5) {
        super(r5);
        Resources r10 = r5.getResources();
        this.maxScaleXDistance = r10.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.maxScaleYDistance = r10.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    private Animator createResetScaleAnimator() {
        AnimatorSet r5 = new AnimatorSet();
        r5.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{1.0f}), ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{1.0f})});
        V r10 = this.view;
        if ((r10 instanceof ViewGroup) == false) goto L8;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = 0;
    L6:
        if (r12 >= r11.getChildCount()) goto L8;
        r5.playTogether(new Animator[]{ObjectAnimator.ofFloat(r11.getChildAt(r12), View.SCALE_Y, new float[]{1.0f})});
        r12 = r12 + 1;
    L8:
        r5.setInterpolator(new FastOutSlowInInterpolator());
        return r5;
    }

    public void cancelBackProgress() {
        if (super.onCancelBackProgress() != null) goto L5;
        return;
    L5:
        Animator r5 = createResetScaleAnimator();
        r5.setDuration(this.cancelDuration);
        r5.start();
    }

    public void finishBackProgressNotPersistent(@NonNull BackEventCompat r10, @Nullable Animator.AnimatorListener r11) {
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Y, new float[]{this.view.getScaleY() * this.view.getHeight()});
        r5.setInterpolator(new FastOutSlowInInterpolator());
        r5.setDuration(AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, r10.getProgress()));
        r5.addListener(new AnonymousClass1(this));
        if (r11 == null) goto L5;
        r5.addListener(r11);
    L5:
        r5.start();
    }

    public void finishBackProgressPersistent(@NonNull BackEventCompat r5, @Nullable Animator.AnimatorListener r10) {
        Animator r11 = createResetScaleAnimator();
        r11.setDuration(AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, r5.getProgress()));
        if (r10 == null) goto L5;
        r11.addListener(r10);
    L5:
        r11.start();
    }

    public void startBackProgress(@NonNull BackEventCompat r5) {
        super.onStartBackProgress(r5);
    }

    public void updateBackProgress(@NonNull BackEventCompat r5) {
        if (super.onUpdateBackProgress(r5) != null) goto L5;
        return;
    L5:
        updateBackProgress(r5.getProgress());
    }

    @VisibleForTesting
    public void updateBackProgress(float r10) {
        float r11 = interpolateProgress(r10);
        float r5 = this.view.getWidth();
        float r12 = this.view.getHeight();
        if (r5 > 0.0f) goto L5;
        return;
    L5:
        if (r12 <= 0.0f) goto L22;
        float r13 = this.maxScaleXDistance / r5;
        float r14 = this.maxScaleYDistance / r12;
        float r15 = 1.0f - AnimationUtils.lerp(0.0f, r13, r11);
        float r16 = 1.0f - AnimationUtils.lerp(0.0f, r14, r11);
        this.view.setScaleX(r15);
        this.view.setPivotY(r12);
        this.view.setScaleY(r16);
        V r17 = this.view;
        if ((r17 instanceof ViewGroup) == false) goto L21;
        ViewGroup r18 = (ViewGroup) r17;
        int r19 = 0;
    L11:
        if (r19 >= r18.getChildCount()) goto L23;
        View r20 = r18.getChildAt(r19);
        r20.setPivotY(-r20.getTop());
        if (r16 == 0.0f) goto L15;
        float r21 = r15 / r16;
    L16:
        r20.setScaleY(r21);
        r19 = r19 + 1;
        goto L11
    L15:
        r21 = 1.0f;
        goto L16
    L23:
        return;
    L21:
        return;
    }
}
