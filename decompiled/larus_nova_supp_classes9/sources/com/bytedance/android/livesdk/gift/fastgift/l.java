package com.bytedance.android.livesdk.gift.fastgift;

import android.animation.Animator;
import com.bytedance.android.livesdk.widget.CircleProgressViewV3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends o12.b {
    public final /* synthetic */ FastGiftViewV3 a;
    public final /* synthetic */ CircleProgressViewV3 b;

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.setVisibility(8);
        this.a.A.notifyRecommendCountDownFinished();
    }

    public l(FastGiftViewV3 r1, CircleProgressViewV3 r2) {
        this.a = r1;
        this.b = r2;
    }
}
