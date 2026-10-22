package com.bytedance.android.live.liveinteract.videotalk.quickinteract.interactView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g extends AnimatorListenerAdapter {
    public final /* synthetic */ f a;
    public final /* synthetic */ String b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.b.clearAnimation();
        this.a.c.clearAnimation();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        this.a.a.setText(this.b);
        f r4 = this.a;
        String r0 = this.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r4.d = r0;
    }

    public g(f r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
