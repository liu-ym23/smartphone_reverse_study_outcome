package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e1 extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;

    public e1(ViewGroup r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.setAlpha(1.0f);
        this.a.setVisibility(0);
        super.onAnimationEnd(r3);
    }
}
