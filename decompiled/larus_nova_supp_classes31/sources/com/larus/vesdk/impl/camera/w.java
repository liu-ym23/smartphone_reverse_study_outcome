package com.larus.vesdk.impl.camera;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w extends AnimatorListenerAdapter {
    public final /* synthetic */ VeCameraImpl a;
    public final /* synthetic */ float b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        VeCameraImpl r4 = this.a;
        r4.q = false;
        pq9.b r0 = r4.n;
        if (r0 == null) goto L6;
        r0.c(r4.x(), this.b);
        return;
    }

    public w(VeCameraImpl r1, float r2) {
        this.a = r1;
        this.b = r2;
    }
}
