package com.bytedance.android.live.recharge.widget;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y implements View.OnClickListener {
    public final /* synthetic */ RechargeTopWidget a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    public y(RechargeTopWidget r1, String r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        final RechargeTopWidget r6 = this.a;
        r6.getClass();
        String r0 = (String) com.bytedance.android.live.recharge.utils.j.f.getValue(null, com.bytedance.android.live.recharge.utils.j.a[4]);
        if (r6.isAlive() == true) goto L5;
    L10:
        int r7 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.h("livesdk_exchange_diamond_click", this.a.g, this.b, this.c);
        return;
    L5:
        if (TextUtils.isEmpty(r0) == true) goto L10;
        HybridDialogImpl r1 = ((vy0.b) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(((Widget) r6).context, UriProtector.parse(r0), null);
        if (r1 == null) goto L10;
        r6.h.getPopUpOrHideRechargePageEvent().onNext(Boolean.TRUE);
        r1.m1(new RechargeTopWidget$openCashExchangeDialog$1(r6));
        goto L10
    }
}
