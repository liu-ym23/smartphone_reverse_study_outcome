package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.Animator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements Animator.AnimatorListener {
    public final /* synthetic */ d a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    public g(d r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        this.a.c = true;
    }
}
