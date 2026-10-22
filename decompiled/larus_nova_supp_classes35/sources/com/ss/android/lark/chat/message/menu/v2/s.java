package com.ss.android.lark.chat.message.menu.v2;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class s implements Animator.AnimatorListener {
    public final /* synthetic */ MessageActionPanel a;
    public final /* synthetic */ a b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Function0<Unit> d;
    public final /* synthetic */ Function0<Unit> e;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        MessageActionPanel r3 = this.a;
        r3.Q = false;
        r3.R.invoke();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.a.setDragEnable(true);
        if (this.c == true) goto L5;
        this.b.b.setVisibility(8);
    L5:
        this.e.invoke();
        MessageActionPanel r3 = this.a;
        r3.Q = false;
        r3.R.invoke();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.Q = true;
        this.b.a.setDragEnable(false);
        if (this.c == false) goto L5;
        this.b.b.setVisibility(0);
    L5:
        this.d.invoke();
    }

    public s(MessageActionPanel r1, a r2, boolean r3, Function0<Unit> r4, Function0<Unit> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
