package com.ss.android.lark.keyboard.ime;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q implements Animator.AnimatorListener {
    public final /* synthetic */ ImeWrapper a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r1) {
    }

    public q(ImeWrapper r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        ImeWrapper r4 = this.a;
        ImeWrapper.P(r4, r4.w - 1);
        b r5 = b.a;
        final ImeWrapper r1 = this.a;
        Function0<String> r0 = new ImeWrapper$startCompatInsetsAnimation$1$3$1(r1);
        r5.getClass();
        b.a("ImeWrapper", r0);
        ImeWrapper r6 = this.a;
        if (r6.m == false) goto L9;
        r6.m = false;
        f r7 = (f) r6.t.acquire();
        if (r7 != null) goto L7;
        r7 = new f();
    L7:
        r7.a(this.a.n);
        this.a.S(r7, false);
        this.a.t.release(r7);
        return;
    }
}
