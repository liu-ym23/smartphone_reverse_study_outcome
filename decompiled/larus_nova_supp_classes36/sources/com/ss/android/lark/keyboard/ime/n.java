package com.ss.android.lark.keyboard.ime;

import android.animation.Animator;
import android.animation.ValueAnimator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements Animator.AnimatorListener {
    public final /* synthetic */ ImeWrapper a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ ValueAnimator c;

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
        ImeWrapper r3 = this.a;
        ImeWrapper.P(r3, r3.w - 1);
        this.b.invoke(Float.valueOf(1000.0f));
        this.a.setTranslationY(0.0f);
        this.a.A.remove(this.c);
    }

    public n(ImeWrapper r1, Function1 r2, ValueAnimator r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
