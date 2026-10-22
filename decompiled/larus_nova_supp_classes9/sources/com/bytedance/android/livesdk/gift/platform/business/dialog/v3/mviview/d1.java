package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d1 extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;

    public d1(ViewGroup r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ViewGroup r0 = this.a;
        if (r0 == null) goto L5;
        r0.setAlpha(1.0f);
    L5:
        ViewGroup r1 = this.a;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        super.onAnimationEnd(r3);
    }
}
