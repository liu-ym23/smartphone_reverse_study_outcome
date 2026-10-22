package com.ss.android.lark.keyboard.ime;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class r implements Animator.AnimatorListener {
    public final /* synthetic */ ImeWrapper a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        ImeWrapper r6 = this.a;
        ImeWrapper.P(r6, r6.w + 1);
        b r7 = b.a;
        final int r1 = this.b;
        final int r2 = this.c;
        final ImeWrapper r3 = this.a;
        Function0<String> r0 = new ImeWrapper$startCompatInsetsAnimation$1$1$1(r1, r2, r3);
        r7.getClass();
        b.a("ImeWrapper", r0);
    }

    public r(ImeWrapper r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
