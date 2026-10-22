package com.larus.common_ui.floatwindow.view;

import android.animation.Animator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n0 implements Animator.AnimatorListener {
    public final /* synthetic */ m0 a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    public n0(m0 r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        m0 r3 = this.a;
        r3.i = SingleFloatWindowState.MAXIMIZE;
    }
}
