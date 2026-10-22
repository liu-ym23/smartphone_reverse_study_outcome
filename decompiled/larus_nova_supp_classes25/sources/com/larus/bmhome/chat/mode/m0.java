package com.larus.bmhome.chat.mode;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0 extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ l0 b;
    public final /* synthetic */ float c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        int r4 = this.a;
        l0 r0 = this.b;
        if (r4 == r0.v) goto L5;
        return;
    L5:
        r0.u = false;
        float r5 = this.c;
        r0.s = r5;
        r0.b(r5, Integer.valueOf(r0.o));
        this.b.h.setAlpha(1.0f);
    }

    public m0(int r1, l0 r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
