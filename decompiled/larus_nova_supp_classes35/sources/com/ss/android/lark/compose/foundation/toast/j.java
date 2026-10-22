package com.ss.android.lark.compose.foundation.toast;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements Animator.AnimatorListener {
    public final /* synthetic */ Animator.AnimatorListener a;
    public final /* synthetic */ i b;
    public final /* synthetic */ Function0<Unit> c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.b.c = null;
        Function0<Unit> r0 = this.c;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        Animator.AnimatorListener r1 = this.a;
        if (r1 == null) goto L9;
        r1.onAnimationCancel(r3);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.b.c = null;
        Function0<Unit> r0 = this.c;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        Animator.AnimatorListener r1 = this.a;
        if (r1 == null) goto L9;
        r1.onAnimationEnd(r3);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Animator.AnimatorListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onAnimationRepeat(r2);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        Animator.AnimatorListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onAnimationStart(r2);
        return;
    }

    public j(Animator.AnimatorListener r1, i r2, Function0<Unit> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
