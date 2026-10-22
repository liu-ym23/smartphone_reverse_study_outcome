package com.ss.ugc.live.barrage.controller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends AnimatorListenerAdapter {
    public final /* synthetic */ AbsBarrageController a;
    public final /* synthetic */ Ref.IntRef b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        super.onAnimationEnd(r2);
        if (this.b.element >= 5) goto L8;
        AbsBarrageController r3 = this.a;
        r3.l();
        AbsBarrageController.m = true;
        r3.n();
        if (r3.f().isRunning() == false) goto L9;
        r3.f().cancel();
        return;
    L9:
        return;
    }

    public b(AbsBarrageController r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }
}
