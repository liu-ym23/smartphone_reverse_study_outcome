package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.Animator;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements Animator.AnimatorListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ int c;

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
        d r3 = this.a;
        r3.c = false;
        r3.f = null;
        if (this.b.element == true) goto L6;
        r3.b.invoke(Integer.valueOf(this.c));
        return;
    }

    public f(d r1, Ref.BooleanRef r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
