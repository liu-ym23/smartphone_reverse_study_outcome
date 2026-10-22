package com.ss.android.lark.inline.ai.ui;

import android.animation.Animator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements Animator.AnimatorListener {
    public final /* synthetic */ InlineAIDragView a;
    public final /* synthetic */ boolean b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        InlineAIDragView.b(this.a);
        if (this.b == false) goto L9;
        InlineAIDragView r3 = this.a;
        if (r3.A == false) goto L7;
        r3.e.c();
        return;
    L7:
        r3.e.onClose();
        return;
    }

    public h(InlineAIDragView r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
