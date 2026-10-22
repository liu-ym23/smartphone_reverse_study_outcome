package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x0 f13803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f13805c;
    public final /* synthetic */ int d;
    public final /* synthetic */ ViewPropertyAnimator e;
    public final /* synthetic */ i f;

    public e(i r5, x0 r10, int r11, View r12, int r13, ViewPropertyAnimator r14) {
        this.f = r5;
        this.f13803a = r10;
        this.f13804b = r11;
        this.f13805c = r12;
        this.d = r13;
        this.e = r14;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        int r10 = this.f13804b;
        View r11 = this.f13805c;
        if (r10 == 0) goto L6;
        r11.setTranslationX(0.0f);
    L6:
        if (this.d == 0) goto L9;
        r11.setTranslationY(0.0f);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        this.e.setListener(null);
        i r10 = this.f;
        x0 r11 = this.f13803a;
        r10.c(r11);
        r10.f13829p.remove(r11);
        r10.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        this.f.getClass();
    }
}
