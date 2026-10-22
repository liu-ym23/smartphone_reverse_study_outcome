package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import android.animation.Animator;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f11681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f11682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f11683c;
    public final /* synthetic */ boolean d;

    public n(p r5, float r10, float r11, boolean r12) {
        this.f11681a = r5;
        this.f11682b = r10;
        this.f11683c = r11;
        this.d = r12;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        float r10 = this.f11683c;
        boolean r11 = this.d;
        this.f11681a.l(this.f11682b, r10, r11);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r5) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
    }
}
