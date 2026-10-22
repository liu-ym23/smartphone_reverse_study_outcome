package com.google.android.material.textfield;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5018b;

    public /* synthetic */ b(Object r8, int r10) {
        this.f5017a = r10;
        this.f5018b = r8;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r8) {
        int r10 = this.f5017a;
        Object r11 = this.f5018b;
        switch(r10) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        l r12 = (l) r11;
        r12.getClass();
        float r13 = ((Float) r8.getAnimatedValue()).floatValue();
        r12.f5075d.setAlpha(r13);
        return;
    L7:
        f r14 = (f) r11;
        r14.getClass();
        float r15 = ((Float) r8.getAnimatedValue()).floatValue();
        r14.f5075d.setAlpha(r15);
        return;
    L9:
        ((ac.e) r11).f(r8, "press anim");
    }
}
