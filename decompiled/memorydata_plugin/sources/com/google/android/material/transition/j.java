package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f4260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f4261b;
    private float c;
    private float d;
    private boolean e;
    private boolean f;

    public j() {
        this(true);
    }

    public j(boolean r3) {
        this.f4260a = 1.0f;
        this.f4261b = 1.1f;
        this.c = 0.8f;
        this.d = 1.0f;
        this.f = true;
        this.e = r3;
    }

    private static Animator a(final View r9, float r10, float r11) {
        final float r0 = r9.getScaleX();
        final float r1 = r9.getScaleY();
        ObjectAnimator r12 = ObjectAnimator.ofPropertyValuesHolder(r9, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{r0 * r10, r0 * r11}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{r10 * r1, r11 * r1})});
        r12.addListener(new AnonymousClass1(r9, r0, r1));
        return r12;
    }

    @Override // com.google.android.material.transition.m
    public Animator a(ViewGroup r1, View r2) {
        if (this.e == false) goto L7;
        float r3 = this.c;
        float r0 = this.d;
    L6:
        return a(r2, r3, r0);
    L7:
        r3 = this.f4261b;
        r0 = this.f4260a;
        goto L6
    }

    public void a(float r1) {
        this.f4261b = r1;
    }

    public void a(boolean r1) {
        this.f = r1;
    }

    @Override // com.google.android.material.transition.m
    public Animator b(ViewGroup r1, View r2) {
        if (this.f == true) goto L7;
        return null;
    L7:
        if (this.e == false) goto L11;
        float r3 = this.f4260a;
        float r0 = this.f4261b;
    L10:
        return a(r2, r3, r0);
    L11:
        r3 = this.d;
        r0 = this.c;
        goto L10
    }

    public void b(float r1) {
        this.c = r1;
    }
}
