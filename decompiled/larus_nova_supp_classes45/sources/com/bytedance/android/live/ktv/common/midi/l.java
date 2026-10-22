package com.bytedance.android.live.ktv.common.midi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l extends AnimatorListenerAdapter {
    public final /* synthetic */ m a;
    public final /* synthetic */ String b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.b.clearAnimation();
        this.a.c.clearAnimation();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        this.a.a.setText(this.b);
    }

    public l(m r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
