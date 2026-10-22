package com.ss.android.lark.keyboard.ime;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.ss.android.lark.log.Log;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements Animator.AnimatorListener {
    public final /* synthetic */ Ref.BooleanRef a;
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
        Log.d("ImeWrapper", "doOnEndIgnoreCancel: updateStateOnAnimEnd is " + this.a.element);
        if (this.a.element == false) goto L6;
        this.b.invoke(this.c);
        return;
    }

    public l(Ref.BooleanRef r1, Function1 r2, ValueAnimator r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
