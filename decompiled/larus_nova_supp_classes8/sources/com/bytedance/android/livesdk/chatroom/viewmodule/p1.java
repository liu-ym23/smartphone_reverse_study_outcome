package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p1 extends AnimatorListenerAdapter {
    public final /* synthetic */ s1 a;

    public p1(s1 r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
        super.onAnimationCancel(r1);
        r1.removeAllListeners();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        super.onAnimationEnd(r2);
        this.a.f(150);
    }
}
