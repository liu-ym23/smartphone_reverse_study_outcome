package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4244a;

    public d() {
        this.f4244a = 1.0f;
    }

    private static Animator a(final View r8, final float r9, final float r10, final float r11, final float r12, final float r13) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.addUpdateListener(new AnonymousClass1(r8, r9, r10, r11, r12));
        r0.addListener(new AnonymousClass2(r8, r13));
        return r0;
    }

    @Override // com.google.android.material.transition.m
    public Animator a(ViewGroup r7, View r8) {
        if (r8.getAlpha() != 0.0f) goto L5;
        float r9 = 1.0f;
    L6:
        float r5 = r9;
        return a(r8, 0.0f, r5, 0.0f, this.f4244a, r5);
    L5:
        r9 = r8.getAlpha();
        goto L6
    }

    public void a(float r1) {
        this.f4244a = r1;
    }

    @Override // com.google.android.material.transition.m
    public Animator b(ViewGroup r7, View r8) {
        if (r8.getAlpha() != 0.0f) goto L5;
        float r6 = 1.0f;
    L6:
        float r5 = r6;
        return a(r8, r5, 0.0f, 0.0f, 1.0f, r5);
    L5:
        r6 = r8.getAlpha();
        goto L6
    }
}
