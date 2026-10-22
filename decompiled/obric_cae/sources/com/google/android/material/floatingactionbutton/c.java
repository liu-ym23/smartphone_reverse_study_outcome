package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f4771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d.g f4772b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d f4773m;

    public c(d r8, boolean r10, a r11) {
        this.f4773m = r8;
        this.f4771a = r10;
        this.f4772b = r11;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        d r10 = this.f4773m;
        r10.f4789m = 0;
        r10.f4783g = null;
        d.g r11 = this.f4772b;
        if (r11 == null) goto L6;
        ((a) r11).f4765a.b();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r8) {
        d r10 = this.f4773m;
        r10.f4793q.b(0, this.f4771a);
        r10.f4789m = 2;
        r10.f4783g = r8;
    }
}
