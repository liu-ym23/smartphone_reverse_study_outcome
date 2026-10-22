package com.bytedance.android.live.broadcastgame.xplay.floatwindow;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements Animator.AnimatorListener {
    public final /* synthetic */ XplayFloatWindowView.ViewHolder a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ boolean c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animator");
        this.b.invoke();
        if (this.c == true) goto L6;
        this.a.d.setVisibility(8);
        this.a.r = false;
        return;
    }

    public f(XplayFloatWindowView.ViewHolder r1, Function0 r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
