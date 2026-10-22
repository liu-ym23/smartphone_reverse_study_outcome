package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialMainContainerBackHelper extends MaterialBackAnimationHelper<View> {
    private static final float MIN_SCALE = 0.9f;

    @Nullable
    private Integer expandedCornerSize;

    @Nullable
    private Rect initialHideFromClipBounds;

    @Nullable
    private Rect initialHideToClipBounds;
    private float initialTouchY;
    private final float maxTranslationY;
    private final float minEdgeGap;

    public MaterialMainContainerBackHelper(@NonNull View r5) {
        super(r5);
        Resources r10 = r5.getResources();
        this.minEdgeGap = r10.getDimension(R.dimen.m3_back_progress_main_container_min_edge_gap);
        this.maxTranslationY = r10.getDimension(R.dimen.m3_back_progress_main_container_max_translation_y);
    }

    public static /* synthetic */ void a(ClippableRoundedCornerLayout r5, ValueAnimator r10) {
        lambda$createCornerAnimator$0(r5, r10);
    }

    @NonNull
    private ValueAnimator createCornerAnimator(ClippableRoundedCornerLayout r5) {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{r5.getCornerRadius(), getExpandedCornerSize()});
        r10.addUpdateListener(new b(r5, 0));
        return r10;
    }

    @NonNull
    private AnimatorSet createResetScaleAndTranslationAnimator(@Nullable final View r11) {
        AnimatorSet r5 = new AnimatorSet();
        r5.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.view, View.SCALE_X, new float[]{1.0f}), ObjectAnimator.ofFloat(this.view, View.SCALE_Y, new float[]{1.0f}), ObjectAnimator.ofFloat(this.view, View.TRANSLATION_X, new float[]{0.0f}), ObjectAnimator.ofFloat(this.view, View.TRANSLATION_Y, new float[]{0.0f})});
        r5.addListener(new AnonymousClass1(this, r11));
        return r5;
    }

    private int getMaxDeviceCornerRadius() {
        WindowInsets r5 = this.view.getRootWindowInsets();
        if (r5 != null) goto L5;
        return 0;
    L5:
        return Math.max(Math.max(getRoundedCornerRadius(r5, 0), getRoundedCornerRadius(r5, 1)), Math.max(getRoundedCornerRadius(r5, 3), getRoundedCornerRadius(r5, 2)));
    }

    @RequiresApi(31)
    private int getRoundedCornerRadius(WindowInsets r5, int r10) {
        RoundedCorner r11 = r5.getRoundedCorner(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.getRadius();
    }

    private boolean isAtTopOfScreen() {
        int[] r5 = new int[2];
        this.view.getLocationOnScreen(r5);
        if (r5[1] == 0) goto L7;
        return false;
    L7:
        return true;
    }

    private static /* synthetic */ void lambda$createCornerAnimator$0(ClippableRoundedCornerLayout r5, ValueAnimator r10) {
        r5.updateCornerRadius(((Float) r10.getAnimatedValue()).floatValue());
    }

    private void resetInitialValues() {
        this.initialTouchY = 0.0f;
        this.initialHideToClipBounds = null;
        this.initialHideFromClipBounds = null;
    }

    public void cancelBackProgress(@Nullable View r5) {
        if (super.onCancelBackProgress() != null) goto L5;
        return;
    L5:
        AnimatorSet r10 = createResetScaleAndTranslationAnimator(r5);
        V r11 = this.view;
        if ((r11 instanceof ClippableRoundedCornerLayout) == false) goto L8;
        r10.playTogether(new Animator[]{createCornerAnimator((ClippableRoundedCornerLayout) r11)});
    L8:
        r10.setDuration(this.cancelDuration);
        r10.start();
        resetInitialValues();
    }

    public void finishBackProgress(long r5, @Nullable View r10) {
        AnimatorSet r11 = createResetScaleAndTranslationAnimator(r10);
        r11.setDuration(r5);
        r11.start();
        resetInitialValues();
    }

    public int getExpandedCornerSize() {
        if (this.expandedCornerSize != null) goto L10;
        if (isAtTopOfScreen() == false) goto L7;
        int r5 = getMaxDeviceCornerRadius();
    L8:
        this.expandedCornerSize = Integer.valueOf(r5);
        goto L10
    L7:
        r5 = 0;
    L10:
        return this.expandedCornerSize.intValue();
    }

    @Nullable
    public Rect getInitialHideFromClipBounds() {
        return this.initialHideFromClipBounds;
    }

    @Nullable
    public Rect getInitialHideToClipBounds() {
        return this.initialHideToClipBounds;
    }

    public void startBackProgress(@NonNull BackEventCompat r5, @Nullable View r10) {
        super.onStartBackProgress(r5);
        startBackProgress(r5.getTouchY(), r10);
    }

    public void updateBackProgress(@NonNull BackEventCompat r5, @Nullable View r10, float r11) {
        if (super.onUpdateBackProgress(r5) != null) goto L5;
        return;
    L5:
        if (r10 == null) goto L10;
        if (r10.getVisibility() == 4) goto L10;
        r10.setVisibility(4);
    L10:
        if (r5.getSwipeEdge() != 0) goto L12;
        boolean r12 = true;
    L13:
        updateBackProgress(r5.getProgress(), r12, r5.getTouchY(), r11);
        return;
    L12:
        r12 = false;
        goto L13
    }

    @VisibleForTesting
    public void startBackProgress(float r5, @Nullable View r10) {
        this.initialHideToClipBounds = ViewUtils.calculateRectFromBounds(this.view);
        if (r10 == null) goto L5;
        this.initialHideFromClipBounds = ViewUtils.calculateOffsetRectFromBounds(this.view, r10);
    L5:
        this.initialTouchY = r5;
    }

    @VisibleForTesting
    public void updateBackProgress(float r10, boolean r11, float r12, float r13) {
        float r14 = interpolateProgress(r10);
        float r5 = this.view.getWidth();
        float r15 = this.view.getHeight();
        if (r5 > 0.0f) goto L5;
        return;
    L5:
        if (r15 <= 0.0f) goto L17;
        float r16 = AnimationUtils.lerp(1.0f, MIN_SCALE, r14);
        float r17 = AnimationUtils.lerp(0.0f, Math.max(0.0f, ((r5 - (MIN_SCALE * r5)) / 2.0f) - this.minEdgeGap), r14);
        if (r11 == false) goto L10;
        int r18 = 1;
    L11:
        float r19 = r17 * r18;
        float r20 = Math.min(Math.max(0.0f, ((r15 - (r16 * r15)) / 2.0f) - this.minEdgeGap), this.maxTranslationY);
        float r21 = r12 - this.initialTouchY;
        float r22 = Math.abs(r21) / r15;
        float r23 = AnimationUtils.lerp(0.0f, r20, r22) * Math.signum(r21);
        this.view.setScaleX(r16);
        this.view.setScaleY(r16);
        this.view.setTranslationX(r19);
        this.view.setTranslationY(r23);
        V r24 = this.view;
        if ((r24 instanceof ClippableRoundedCornerLayout) == false) goto L16;
        ((ClippableRoundedCornerLayout) r24).updateCornerRadius(AnimationUtils.lerp(getExpandedCornerSize(), r13, r14));
        return;
    L16:
        return;
    L10:
        r18 = -1;
        goto L11
    }
}
