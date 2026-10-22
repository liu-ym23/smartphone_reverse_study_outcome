package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ e a;

    public c(j r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        e r3 = this.a;
        if (r3 == null) goto L6;
        r3.b();
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        e r3 = this.a;
        if (r3 == null) goto L6;
        r3.a();
        return;
    }
}
