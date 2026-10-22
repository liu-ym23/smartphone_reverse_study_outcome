package com.obric.oui.orecyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f13801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f13802c;
    public final /* synthetic */ ViewPropertyAnimator d;
    public final /* synthetic */ i e;

    public /* synthetic */ d(i r5, x0 r10, View r11, ViewPropertyAnimator r12, int r13) {
        this.f13800a = r13;
        this.e = r5;
        this.f13801b = r10;
        this.f13802c = r11;
        this.d = r12;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r5) {
        switch(this.f13800a) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.onAnimationCancel(r5);
        return;
    L6:
        View r10 = this.f13802c;
        r10.setAlpha(1.0f);
        r10.animate().setInterpolator(i.s);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        switch(this.f13800a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.d.setListener(null);
        x0 r10 = this.f13801b;
        i r11 = this.e;
        r11.c(r10);
        r11.f13828o.remove(r10);
        this.f13802c.animate().setInterpolator(i.s);
        r11.i();
        return;
    L6:
        this.d.setListener(null);
        View r12 = this.f13802c;
        r12.setAlpha(1.0f);
        x0 r13 = this.f13801b;
        i r14 = this.e;
        r14.c(r13);
        r14.f13830q.remove(r13);
        r12.animate().setInterpolator(i.s);
        r14.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        switch(this.f13800a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.e.getClass();
        return;
    L6:
        this.e.getClass();
        this.f13802c.animate().setInterpolator(i.s);
    }
}
