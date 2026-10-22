package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialSideContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private final float maxScaleXDistanceGrow;
    private final float maxScaleXDistanceShrink;
    private final float maxScaleYDistance;

    public MaterialSideContainerBackHelper(@NonNull View r5) {
        super(r5);
        Resources r10 = r5.getResources();
        this.maxScaleXDistanceShrink = r10.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.maxScaleXDistanceGrow = r10.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.maxScaleYDistance = r10.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    private boolean checkAbsoluteGravity(@GravityInt int r5, @GravityInt int r10) {
        if ((GravityCompat.getAbsoluteGravity(r5, ViewCompat.getLayoutDirection(this.view)) & r10) != r10) goto L5;
        return true;
    L5:
        return false;
    }

    private int getEdgeMargin(boolean r5) {
        ViewGroup.LayoutParams r10 = this.view.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        if (r5 == false) goto L8;
        return r11.leftMargin;
    L8:
        return r11.rightMargin;
    L9:
        return 0;
    }

    public void cancelBackProgress() {
        if (super.onCancelBackProgress() != null) goto L5;
        return;
    L5:
        AnimatorSet r5 = new AnimatorSet();
        r5.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{1.0f}), ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{1.0f})});
        V r10 = this.view;
        if ((r10 instanceof ViewGroup) == false) goto L11;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = 0;
    L9:
        if (r12 >= r11.getChildCount()) goto L11;
        r5.playTogether(new Animator[]{ObjectAnimator.ofFloat(r11.getChildAt(r12), View.SCALE_Y, new float[]{1.0f})});
        r12 = r12 + 1;
    L11:
        r5.setDuration(this.cancelDuration);
        r5.start();
    }

    public void finishBackProgress(@NonNull BackEventCompat r10, @GravityInt final int r11, @Nullable Animator.AnimatorListener r12, @Nullable ValueAnimator.AnimatorUpdateListener r13) {
        if (r10.getSwipeEdge() != 0) goto L5;
        final boolean r5 = true;
    L6:
        boolean r14 = checkAbsoluteGravity(r11, 3);
        float r15 = (this.view.getScaleX() * this.view.getWidth()) + getEdgeMargin(r14);
        V r16 = this.view;
        Property r17 = View.TRANSLATION_X;
        if (r14 == false) goto L9;
        r15 = -r15;
    L9:
        ObjectAnimator r18 = ObjectAnimator.ofFloat(r16, r17, new float[]{r15});
        if (r13 == null) goto L12;
        r18.addUpdateListener(r13);
    L12:
        r18.setInterpolator(new FastOutSlowInInterpolator());
        r18.setDuration(AnimationUtils.lerp(this.hideDurationMax, this.hideDurationMin, r10.getProgress()));
        r18.addListener(new AnonymousClass1(this, r5, r11));
        if (r12 == null) goto L15;
        r18.addListener(r12);
    L15:
        r18.start();
        return;
    L5:
        r5 = false;
        goto L6
    }

    public void startBackProgress(@NonNull BackEventCompat r5) {
        super.onStartBackProgress(r5);
    }

    public void updateBackProgress(@NonNull BackEventCompat r5, @GravityInt int r10) {
        if (super.onUpdateBackProgress(r5) != null) goto L6;
        return;
    L6:
        if (r5.getSwipeEdge() != 0) goto L8;
        boolean r11 = true;
    L9:
        updateBackProgress(r5.getProgress(), r11, r10);
        return;
    L8:
        r11 = false;
        goto L9
    }

    @VisibleForTesting
    public void updateBackProgress(float r10, boolean r11, @GravityInt int r12) {
        float r13 = interpolateProgress(r10);
        boolean r14 = checkAbsoluteGravity(r12, 3);
        int r5 = 0;
        if (r11 != r14) goto L5;
        boolean r15 = true;
    L6:
        int r16 = this.view.getWidth();
        int r17 = this.view.getHeight();
        float r18 = r16;
        if (r18 <= 0.0f) goto L36;
        float r19 = r17;
        if (r19 <= 0.0f) goto L41;
        float r20 = this.maxScaleXDistanceShrink / r18;
        float r21 = this.maxScaleXDistanceGrow / r18;
        float r22 = this.maxScaleYDistance / r19;
        V r23 = this.view;
        if (r14 == false) goto L14;
        r18 = 0.0f;
    L14:
        r23.setPivotX(r18);
        if (r15 == true) goto L18;
        r21 = -r20;
    L18:
        float r24 = AnimationUtils.lerp(0.0f, r21, r13);
        float r25 = r24 + 1.0f;
        this.view.setScaleX(r25);
        float r110 = 1.0f - AnimationUtils.lerp(0.0f, r22, r13);
        this.view.setScaleY(r110);
        V r26 = this.view;
        if ((r26 instanceof ViewGroup) == false) goto L40;
        ViewGroup r27 = (ViewGroup) r26;
    L22:
        if (r5 >= r27.getChildCount()) goto L42;
        View r28 = r27.getChildAt(r5);
        if (r14 == false) goto L26;
        float r29 = r28.getWidth() + (r16 - r28.getRight());
    L27:
        r28.setPivotX(r29);
        r28.setPivotY(-r28.getTop());
        if (r15 == false) goto L30;
        float r30 = 1.0f - r24;
    L32:
        if (r110 == 0.0f) goto L34;
        float r31 = (r25 / r110) * r30;
    L35:
        r28.setScaleX(r30);
        r28.setScaleY(r31);
        r5 = r5 + 1;
        goto L22
    L34:
        r31 = 1.0f;
        goto L35
    L30:
        r30 = 1.0f;
        goto L32
    L26:
        r29 = -r28.getLeft();
        goto L27
    L42:
        return;
    L40:
        return;
    L41:
        return;
    L36:
        return;
    L5:
        r15 = false;
        goto L6
    }
}
