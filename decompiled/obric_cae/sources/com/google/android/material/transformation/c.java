package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import o9.d;

/* JADX INFO: loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f5184a;

    public c(d r8) {
        this.f5184a = r8;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r8) {
        d r10 = this.f5184a;
        d.C0130d r11 = r10.getRevealInfo();
        r11.f9768c = Float.MAX_VALUE;
        r10.setRevealInfo(r11);
    }
}
