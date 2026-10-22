package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.rareshopcombo;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GiftRareShopComboHeatHelper a;

    public b(GiftRareShopComboHeatHelper r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        Boolean r3 = (Boolean) this.a.d.getValue();
        Boolean r0 = Boolean.FALSE;
        if ((!Intrinsics.areEqual(r3, r0)) == false) goto L6;
        this.a.d.setValue(r0);
        return;
    }
}
