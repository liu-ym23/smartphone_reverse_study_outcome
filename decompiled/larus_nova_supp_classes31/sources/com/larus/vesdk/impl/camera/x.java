package com.larus.vesdk.impl.camera;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class x extends AnimatorListenerAdapter {
    public final /* synthetic */ VeCameraImpl a;
    public final /* synthetic */ float b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        VeCameraImpl r5 = this.a;
        r5.q = false;
        pq9.b r0 = r5.n;
        if (r0 == null) goto L6;
        r0.c(r5.x(), (float) Math.floor(this.b));
        return;
    }

    public x(VeCameraImpl r1, float r2) {
        this.a = r1;
        this.b = r2;
    }
}
