package uw0;

import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.order.j;
import com.bytedance.android.live.recharge.panel.g;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tw0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements b {
    public final k a;

    @Override // uw0.b
    public final com.bytedance.android.live.recharge.order.k a(com.bytedance.android.live.recharge.order.k r8) {
        Intrinsics.checkNotNullParameter(r8, "orderOptions");
        String r0 = this.a.getScene();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r3 = r0;
        if (r3.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return r8;
    L11:
        j r2 = r8.a;
        JSONObject r4 = com.bytedance.android.live.recharge.core.f.h(RechargeServices.b()).I(r3);
        if (r4 == null) goto L14;
        r2.put("create_pay_type", DataType.TRUE);
        r2.put("caijing_pay_params", r4.toString());
    L14:
        String r5 = com.bytedance.android.live.recharge.core.f.b(RechargeServices.b()).Y0();
        if (r5 == null) goto L17;
        r2.put("sdk_version", r5);
    L17:
        this.a.V2();
        JsonObject r6 = new JsonObject();
        com.bytedance.android.live.recharge.panel.context.c r7 = g.a();
        if (r7 == null) goto L22;
        com.bytedance.android.live.revenue.common.reactive.e<i> r9 = r7.g();
        if (r9 == null) goto L22;
        i r10 = r9.getValue();
    L22:
        r2.put("continue_pay_info", r6.toString());
        return com.bytedance.android.live.recharge.order.k.a(r8, null, r3, null, null, 8189);
    L8:
        r1 = false;
        goto L9
    }

    public d(k r2, com.bytedance.android.live.recharge.deal.f r3) {
        Intrinsics.checkNotNullParameter(r2, "option");
        Intrinsics.checkNotNullParameter(r3, "deal");
        this.a = r2;
    }
}
