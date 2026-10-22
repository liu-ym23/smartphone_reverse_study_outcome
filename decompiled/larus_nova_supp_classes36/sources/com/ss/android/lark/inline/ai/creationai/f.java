package com.ss.android.lark.inline.ai.creationai;

import android.animation.Animator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Animator.AnimatorListener {
    public final /* synthetic */ CreationAIDragView a;
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
        CreationAIDragView.b(this.a);
        if (this.b == false) goto L9;
        CreationAIDragView r3 = this.a;
        if (r3.B == false) goto L7;
        r3.e.c();
        return;
    L7:
        r3.e.onClose();
        return;
    }

    public f(CreationAIDragView r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
