package com.obric.audio.enroll.ui.fragment;

import android.animation.Animator;
import android.view.View;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d0 implements Animator.AnimatorListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        FLogger.a.i("EnrollStageView", "animator cancel");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        FLogger.a.i("EnrollStageView", "animator end");
        this.a.setVisibility(8);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        this.b.setVisibility(0);
    }

    public d0(View r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
