package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends AnimatorListenerAdapter {
    public final /* synthetic */ FollowMVIView a;

    public e(FollowMVIView r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        FollowMVIView r4 = this.a;
        r4.o(new eu0.u(r4.r));
    }
}
