package com.bytedance.android.live.recharge.widget;

import android.view.View;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z implements View.OnClickListener {
    public final /* synthetic */ RechargeTopWidget a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public z(RechargeTopWidget r1, String r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        final RechargeTopWidget r8 = this.a;
        String r0 = this.b;
        int r1 = this.c;
        if (r8.isAlive() == false) goto L10;
        zy0.d r2 = com.bytedance.android.live.recharge.util.h.b(((Widget) r8).context, UriProtector.parse((String) com.bytedance.android.live.recharge.util.g.d.getValue(null, com.bytedance.android.live.recharge.util.g.a[2])));
        if (r2 == null) goto L11;
        r8.h.getPopUpOrHideRechargePageEvent().onNext(Boolean.TRUE);
        HybridDialogImpl r3 = (HybridDialogImpl) r2;
        r3.m1(new RechargeTopWidget$showExchangeDialog$1(r8));
        int r4 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.h("livesdk_exchange_diamond_click", r8.g, r0, r1);
        return;
    L11:
        return;
    }
}
