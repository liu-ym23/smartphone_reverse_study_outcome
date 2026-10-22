package com.bytedance.android.live.broadcastgame.opengame.utils;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public a(RoundCornerConstraintLayout r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        View r0 = this.a;
        Object r3 = r2.getAnimatedValue();
        if (r3 == null) goto L7;
        a1.k(r0, ((Integer) r3).intValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
