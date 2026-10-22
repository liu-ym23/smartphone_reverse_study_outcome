package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f4768b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d.g f4769m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d f4770n;

    public b(d r8, boolean r10, a r11) {
        this.f4770n = r8;
        this.f4768b = r10;
        this.f4769m = r11;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r8) {
        this.f4767a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        d r10 = this.f4770n;
        r10.f4789m = 0;
        r10.f4783g = null;
        if (this.f4767a == true) goto L12;
        boolean r11 = this.f4768b;
        if (r11 == false) goto L7;
        int r12 = 8;
    L8:
        r10.f4793q.b(r12, r11);
        d.g r13 = this.f4769m;
        if (r13 == null) goto L13;
        a r14 = (a) r13;
        r14.f4765a.a(r14.f4766b);
        return;
    L13:
        return;
    L7:
        r12 = 4;
        goto L8
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r8) {
        d r10 = this.f4770n;
        r10.f4793q.b(0, this.f4768b);
        r10.f4789m = 1;
        r10.f4783g = r8;
        this.f4767a = false;
    }
}
