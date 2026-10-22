package com.bytedance.android.livesdk.gift.platform.business.tray;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends AnimatorListenerAdapter {
    public final /* synthetic */ GiftTrayWidget a;
    public final /* synthetic */ View b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ViewUtilsKt.e(this.b);
        this.a.g = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        ViewUtilsKt.f(this.b);
    }

    public i(GiftTrayWidget r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
