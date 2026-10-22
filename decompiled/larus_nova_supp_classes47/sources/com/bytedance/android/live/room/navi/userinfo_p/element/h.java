package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h extends AnimatorListenerAdapter {
    public final /* synthetic */ UserInfoFlipTabElement a;

    public h(UserInfoFlipTabElement r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ViewGroup r3 = this.a.n;
        if (r3 == null) goto L5;
        r3.setAlpha(1.0f);
    L5:
        ViewGroup r4 = this.a.n;
        if (r4 == null) goto L8;
        r4.setVisibility(8);
    L8:
        ViewGroup r5 = this.a.m;
        if (r5 == null) goto L12;
        r5.setVisibility(0);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ViewGroup r3 = this.a.n;
        if (r3 == null) goto L5;
        r3.setAlpha(1.0f);
    L5:
        ViewGroup r4 = this.a.n;
        if (r4 == null) goto L8;
        r4.setVisibility(8);
    L8:
        ViewGroup r5 = this.a.m;
        if (r5 == null) goto L12;
        r5.setVisibility(0);
        return;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationStart(r2);
    }
}
