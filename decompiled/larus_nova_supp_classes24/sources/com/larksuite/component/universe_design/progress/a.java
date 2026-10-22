package com.larksuite.component.universe_design.progress;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;
import z08.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements Animator.AnimatorListener {
    public final /* synthetic */ UDProgress a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public a(UDProgress r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        UDProgress r3 = this.a;
        b r0 = r3.b;
        r0.f = r3.getProgress();
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        UDProgress r3 = this.a;
        b r0 = r3.b;
        r0.f = r3.getProgress();
        this.a.getOnChangedListener();
    }
}
