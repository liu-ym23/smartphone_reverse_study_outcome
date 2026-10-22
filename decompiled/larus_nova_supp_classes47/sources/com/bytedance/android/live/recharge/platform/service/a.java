package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements com.bytedance.android.scope.o, com.bytedance.android.live.recharge.order.e {
    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void c(com.bytedance.android.live.recharge.order.f.b r4) {
        Intrinsics.checkNotNullParameter(r4, "order");
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        JSONObject r5 = r4.g.j;
        if (r5.has("multi_stream_log_pb") == true) goto L12;
        com.bytedance.android.livesdk.revenue.service.room.b r2 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class);
        if (r0 == null) goto L7;
        DataCenter r1 = r0.getDataCenter();
    L8:
        String r3 = r2.Ub(r1);
        if (r3 == null) goto L13;
        r5.put("multi_stream_log_pb", r3);
        return;
    L13:
        return;
    L7:
        r1 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void a(Order r2, com.bytedance.android.live.recharge.order.f.b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "order");
        Intrinsics.checkNotNullParameter(r3, "handle");
        throw new UnsupportedOperationException();
    }
}
