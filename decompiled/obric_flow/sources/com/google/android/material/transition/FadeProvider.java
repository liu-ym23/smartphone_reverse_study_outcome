package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: loaded from: classes2.dex */
public final class FadeProvider implements VisibilityAnimatorProvider {
    private float incomingEndThreshold;

    public FadeProvider() {
        this.incomingEndThreshold = 1.0f;
    }

    private static Animator createFadeAnimator(final View r10, final float r11, final float r12, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) final float r13, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) final float r14, final float r15) {
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r5.addUpdateListener(new AnonymousClass1(r10, r11, r12, r13, r14));
        r5.addListener(new AnonymousClass2(r10, r15));
        return r5;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup r10, @NonNull View r11) {
        if (r11.getAlpha() != 0.0f) goto L6;
        float r12 = 1.0f;
    L5:
        float r5 = r12;
        return createFadeAnimator(r11, 0.0f, r5, 0.0f, this.incomingEndThreshold, r5);
    L6:
        r12 = r11.getAlpha();
        goto L5
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup r10, @NonNull View r11) {
        if (r11.getAlpha() != 0.0f) goto L6;
        float r12 = 1.0f;
    L5:
        float r5 = r12;
        return createFadeAnimator(r11, r5, 0.0f, 0.0f, 1.0f, r5);
    L6:
        r12 = r11.getAlpha();
        goto L5
    }

    public float getIncomingEndThreshold() {
        return this.incomingEndThreshold;
    }

    public void setIncomingEndThreshold(float r5) {
        this.incomingEndThreshold = r5;
    }
}
