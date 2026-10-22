package com.bytedance.android.livesdk.gift.fastgift;

import android.content.Context;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends com.bytedance.android.livesdk.gift.platform.business.l {
    public long e;

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final void w() {
        super.w();
        if ((System.currentTimeMillis() - this.e) <= 3000) goto L6;
        boolean r0 = com.bytedance.android.livesdk.gift.platform.core.d0.a;
        String r2 = com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_fast_gift_show_status");
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        EventModule r1 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r1, "eventModule");
        String r3 = r1.getValue();
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter("status_code", "key");
        Intrinsics.checkNotNullParameter(1, "value");
        r5.put("status_code", 1);
        Intrinsics.checkNotNullParameter("status", "key");
        Intrinsics.checkNotNullParameter(1, "value");
        r5.put("status", 1);
        cy0.e.a.getClass();
        cy0.j r4 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r4).b(n97.a.class);
        Intrinsics.checkNotNull(r8);
        ((com.bytedance.live.kmp.core.c) r8).g(r2, r3, "bussiness_api_call", r5, r6, r7);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.l, com.bytedance.android.livesdk.gift.platform.business.h
    public final void k(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.k(r3);
        this.e = System.currentTimeMillis();
    }

    public b(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
    }
}
