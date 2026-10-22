package com.bytedance.android.livesdk.gift.fastgift;

import android.animation.Animator;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k extends o12.b {
    public final /* synthetic */ FastGiftViewV3 a;
    public final /* synthetic */ View b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public k(FastGiftViewV3 r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "animation");
        this.b.setVisibility(8);
        this.a.A.notifyRecommendTurningFinished();
    }
}
