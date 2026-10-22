package com.bytedance.android.livesdk.gift.platform.business.tray;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends AnimatorListenerAdapter {
    public final /* synthetic */ GiftTrayWidget a;
    public final /* synthetic */ View b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.setAlpha(1.0f);
        this.a.f = null;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.setAlpha(0.0f);
        ViewUtilsKt.f(this.b);
    }

    public j(GiftTrayWidget r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
