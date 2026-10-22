package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y0 extends AnimatorListenerAdapter {
    public final /* synthetic */ Pair a;

    public y0(Pair r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ((ViewGroup) this.a.getFirst()).setVisibility(8);
        ((BaseGiftMVIViewChildNode) this.a.getSecond()).p(8);
        ((ViewGroup) this.a.getFirst()).setAlpha(1.0f);
        super.onAnimationEnd(r3);
    }
}
