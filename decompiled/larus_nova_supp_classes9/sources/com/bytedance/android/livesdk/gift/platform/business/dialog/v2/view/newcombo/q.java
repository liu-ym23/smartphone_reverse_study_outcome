package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q extends AnimatorListenerAdapter {
    public final /* synthetic */ GiftComboProgressBar a;

    public q(GiftComboProgressBar r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        GiftComboProgressBar r6 = this.a;
        Animator r0 = r6.r;
        if (r0 == null) goto L5;
        c.a(r0);
    L5:
        Animator r1 = r6.t;
        if (r1 != null) goto L8;
    L10:
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{r6.s, 0.0f});
        r2.setDuration(1300);
        r2.setStartDelay(0);
        r2.addUpdateListener(new l(r6));
        r2.addListener(new m(r6));
        Unit r3 = Unit.INSTANCE;
        r6.t = r2;
        r2.start();
        return;
    L8:
        if (r1.isRunning() != true) goto L10;
    }
}
