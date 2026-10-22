package com.bytedance.android.livesdk.clearscreen.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.bytedance.android.livesdk.clearscreen.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends AnimatorListenerAdapter {
    public final /* synthetic */ i a;
    public final /* synthetic */ ClearScreenUtils b;
    public final /* synthetic */ boolean c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        if (this.c == true) goto L5;
        this.a.e(8);
    L5:
        this.b.l = 0;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        if (this.c == false) goto L6;
        this.a.e(0);
        return;
    }

    public c(i r1, ClearScreenUtils r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
