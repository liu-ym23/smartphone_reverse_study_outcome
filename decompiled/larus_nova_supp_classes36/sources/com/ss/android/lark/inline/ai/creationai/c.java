package com.ss.android.lark.inline.ai.creationai;

import android.animation.Animator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Animator.AnimatorListener {
    public final /* synthetic */ CreationAIDragView a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    public c(CreationAIDragView r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Runnable r3 = this.a.T;
        if (r3 == null) goto L5;
        r3.run();
    L5:
        this.a.T = null;
    }
}
