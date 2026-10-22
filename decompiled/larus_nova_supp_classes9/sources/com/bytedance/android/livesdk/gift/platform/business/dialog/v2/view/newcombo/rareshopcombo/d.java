package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ GiftRareShopComboHeatHelper a;

    public d(GiftRareShopComboHeatHelper r1) {
        this.a = r1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        GiftRareShopComboHeatHelper r3 = this.a;
        Animator r0 = r3.a;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.a(r0);
    L5:
        r3.c.setValue(Boolean.FALSE);
    }
}
