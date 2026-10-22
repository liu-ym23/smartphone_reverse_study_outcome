package com.ss.android.lark.chat.message.menu.v2;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c0 implements Animator.AnimatorListener {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ b0 b;
    public final /* synthetic */ float c;
    public final /* synthetic */ int d;

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
    public final void onAnimationEnd(Animator r4) {
        this.a.invoke();
        b0 r5 = this.b;
        float r0 = r5.g + (this.c - this.d);
        r5.g = r0;
        r5.c.setTranslationY(r5.n - r0);
    }

    public c0(Function0 r1, b0 r2, float r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
