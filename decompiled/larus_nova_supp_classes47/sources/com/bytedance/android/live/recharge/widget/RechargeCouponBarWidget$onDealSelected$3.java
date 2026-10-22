package com.bytedance.android.live.recharge.widget;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RechargeCouponBarWidget$onDealSelected$3 implements View.OnClickListener {
    public final /* synthetic */ RechargeCouponBarWidget a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.android.live.recharge.deal.f c;

    public RechargeCouponBarWidget$onDealSelected$3(RechargeCouponBarWidget r1, String r2, com.bytedance.android.live.recharge.deal.f r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (by0.b.a(this.b) == false) goto L12;
        u6 r8 = new u6(this.b);
        u6 r0 = r8.d("url");
        r0.b("deal_id", String.valueOf(this.c.b()));
        r0.b("price", String.valueOf(this.c.g()));
        Uri r9 = UriProtector.parse(r8.toString());
        RechargeCouponBarWidget r1 = this.a;
        HybridDialogImpl r3 = null;
        HybridDialogImpl r10 = ((vy0.b) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(((Widget) this.a).context, r9, null);
        if (r10 == null) goto L10;
        r10.l1(new RechargeCouponBarWidget$onDealSelected$3$$special$$inlined$apply$lambda$1(this));
        xy0.a<?> r2 = r10.g();
        if (r2 == null) goto L9;
        r2.load();
    L9:
        Unit r4 = Unit.INSTANCE;
        r3 = r10;
    L10:
        r1.l = r3;
        int r12 = com.bytedance.android.live.recharge.utils.m.a;
        com.bytedance.android.live.recharge.utils.m.f("livesdk_recharge_vou_entrance_click", "", "", "", MapsKt.mapOf(TuplesKt.to("is_geted", DataType.TRUE)), this.a.g);
        return;
    }
}
