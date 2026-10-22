package com.ss.android.lark.chat.message.menu.v2.popup;

import android.animation.Animator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements Animator.AnimatorListener {
    public final /* synthetic */ PopupMenuMainContent a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    public j(PopupMenuMainContent r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        PopupMenuMainContent r3 = this.a;
        r3.e = false;
        r3.invalidate();
    }
}
