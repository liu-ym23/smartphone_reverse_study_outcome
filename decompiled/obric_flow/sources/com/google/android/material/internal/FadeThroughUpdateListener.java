package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class FadeThroughUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    private final float[] alphas;

    @Nullable
    private final View fadeInView;

    @Nullable
    private final View fadeOutView;

    public FadeThroughUpdateListener(@Nullable View r5, @Nullable View r10) {
        this.fadeOutView = r5;
        this.fadeInView = r10;
        this.alphas = new float[2];
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator r5) {
        FadeThroughUtils.calculateFadeOutAndInAlphas(((Float) r5.getAnimatedValue()).floatValue(), this.alphas);
        View r10 = this.fadeOutView;
        if (r10 == null) goto L5;
        r10.setAlpha(this.alphas[0]);
    L5:
        View r11 = this.fadeInView;
        if (r11 == null) goto L9;
        r11.setAlpha(this.alphas[1]);
        return;
    }
}
