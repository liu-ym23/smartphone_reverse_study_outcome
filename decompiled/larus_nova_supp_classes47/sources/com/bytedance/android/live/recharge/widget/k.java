package com.bytedance.android.live.recharge.widget;

import android.view.View;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.config.GemExchangeCouponConfig;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ RechargeCouponBarWidget a;
    public final /* synthetic */ GemExchangeCouponConfig b;
    public final /* synthetic */ com.bytedance.android.live.recharge.deal.i c;

    public k(RechargeCouponBarWidget r1, GemExchangeCouponConfig r2, com.bytedance.android.live.recharge.deal.i r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        u6 r10 = new u6(this.b.getScheme());
        Iterator<T> r0 = this.c.c().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.android.live.recharge.deal.u) r1).b != this.c.d()) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.android.live.recharge.deal.u r2 = (com.bytedance.android.live.recharge.deal.u) r1;
        if (r2 == null) goto L15;
        String r4 = String.valueOf(r2.c);
    L16:
        if (r4 != null) goto L18;
        r4 = "";
    L18:
        r10.b("default_diamond_amount", r4);
        r10.b("open_from", "2");
        this.a.l = ((vy0.b) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(((Widget) this.a).context, r10.c(), null);
        int r12 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.f("livesdk_recharge_vou_entrance_click", "", "", "", MapsKt.mapOf(TuplesKt.to("is_geted", DataType.FALSE)), this.a.g);
        return;
    L15:
        r4 = null;
        goto L16
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }
}
