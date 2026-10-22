package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularRevealCompat {
    private CircularRevealCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator createCircularReveal(@NonNull CircularRevealWidget r5, float r10, float r11, float r12) {
        ObjectAnimator r13 = ObjectAnimator.ofObject(r5, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(r10, r11, r12)});
        CircularRevealWidget.RevealInfo r14 = r5.getRevealInfo();
        if (r14 == null) goto L7;
        Animator r15 = ViewAnimationUtils.createCircularReveal((View) r5, (int) r10, (int) r11, r14.radius, r12);
        AnimatorSet r16 = new AnimatorSet();
        r16.playTogether(new Animator[]{r13, r15});
        return r16;
    L7:
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    @NonNull
    public static Animator.AnimatorListener createCircularRevealListener(@NonNull final CircularRevealWidget r5) {
        return new AnonymousClass1(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator createCircularReveal(CircularRevealWidget r5, float r10, float r11, float r12, float r13) {
        ObjectAnimator r14 = ObjectAnimator.ofObject(r5, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(r10, r11, r12), new CircularRevealWidget.RevealInfo(r10, r11, r13)});
        Animator r15 = ViewAnimationUtils.createCircularReveal((View) r5, (int) r10, (int) r11, r12, r13);
        AnimatorSet r16 = new AnimatorSet();
        r16.playTogether(new Animator[]{r14, r15});
        return r16;
    }
}
