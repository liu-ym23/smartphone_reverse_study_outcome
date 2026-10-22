package com.bytedance.android.livesdk.gift.fastgift;

import android.animation.Animator;
import com.bytedance.android.livesdk.widget.CircleProgressViewV3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends o12.b {
    public final /* synthetic */ FastGiftViewV3 a;

    public f(FastGiftViewV3 r1) {
        this.a = r1;
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        CircleProgressViewV3 r3 = this.a.a(2131370135);
        if (r3 == null) goto L6;
        r3.setVisibility(8);
        return;
    }
}
