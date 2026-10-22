package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickSearchEntrance;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftSearchConfigData;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s0 implements View.OnClickListener {
    public final /* synthetic */ GiftSearchConfigData a;
    public final /* synthetic */ GiftMVITabView b;

    public s0(GiftSearchConfigData r1, GiftMVITabView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        zz0.g r5 = com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class);
        Context r0 = this.b.getContext();
        String r1 = this.a.getSchema();
        if (r1 != null) goto L5;
        r1 = BuildConfig.FLAVOR;
    L5:
        r5.S2(r0, r1);
        if (this.a.getCloseGiftPanel() == false) goto L9;
        this.b.o(new ClickSearchEntrance(false, this.a.getCloseGiftPanel()));
        return;
    }
}
