package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f13807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f13808c;
    public final /* synthetic */ View d;
    public final /* synthetic */ i e;

    public /* synthetic */ f(i r5, g r10, ViewPropertyAnimator r11, View r12, int r13) {
        this.f13806a = r13;
        this.e = r5;
        this.f13807b = r10;
        this.f13808c = r11;
        this.d = r12;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        switch(this.f13806a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f13808c.setListener(null);
        View r10 = this.d;
        r10.setAlpha(1.0f);
        r10.setTranslationX(0.0f);
        r10.setTranslationY(0.0f);
        g r11 = this.f13807b;
        x0 r12 = r11.f13812b;
        i r13 = this.e;
        r13.c(r12);
        r13.f13831r.remove(r11.f13812b);
        r13.i();
        return;
    L6:
        this.f13808c.setListener(null);
        View r14 = this.d;
        r14.setAlpha(1.0f);
        r14.setTranslationX(0.0f);
        r14.setTranslationY(0.0f);
        g r15 = this.f13807b;
        x0 r16 = r15.f13811a;
        i r17 = this.e;
        r17.c(r16);
        r17.f13831r.remove(r15.f13811a);
        r17.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        switch(this.f13806a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        x0 r10 = this.f13807b.f13812b;
        this.e.getClass();
        return;
    L6:
        x0 r11 = this.f13807b.f13811a;
        this.e.getClass();
    }
}
