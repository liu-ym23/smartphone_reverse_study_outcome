package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z0 extends AnimatorListenerAdapter {
    public final /* synthetic */ Pair a;
    public final /* synthetic */ float b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ((ViewGroup) this.a.getFirst()).setTranslationY(this.b);
        super.onAnimationEnd(r3);
    }

    public z0(Pair r1, float r2) {
        this.a = r1;
        this.b = r2;
    }
}
