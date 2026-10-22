package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ UgcGiftSaleDialog a;

    public l(UgcGiftSaleDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        com.bytedance.android.livesdk.gift.platform.core.preview.j.c.setValue(null, com.bytedance.android.livesdk.gift.platform.core.preview.j.a[1], Boolean.FALSE);
        final View r6 = this.a.t;
        if (r6 == null) goto L6;
        ValueAnimator r0 = ValueAnimator.ofInt(new int[]{r6.getHeight(), 0});
        r0.setDuration(500);
        r0.addUpdateListener(new k(r6));
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.c.c(r0, new UgcGiftSaleDialog$$special$$inlined$apply$lambda$5(r6));
        r0.start();
        return;
    }
}
