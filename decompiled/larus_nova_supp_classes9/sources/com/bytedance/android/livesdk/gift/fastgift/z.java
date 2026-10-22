package com.bytedance.android.livesdk.gift.fastgift;

import android.animation.Animator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z extends o12.b {
    public final /* synthetic */ FastGiftViewV3 a;

    public z(FastGiftViewV3 r1) {
        this.a = r1;
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.p.setVisibility(8);
        this.a.a(2131388219).setVisibility(8);
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.p.setVisibility(8);
        this.a.a(2131388219).setVisibility(8);
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.p.setVisibility(0);
        this.a.a(2131388219).setVisibility(0);
    }
}
