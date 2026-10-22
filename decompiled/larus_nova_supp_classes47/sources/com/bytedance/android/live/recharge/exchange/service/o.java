package com.bytedance.android.live.recharge.exchange.service;

import com.bytedance.android.live.revenue.common.v;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ ExchangeStatusService a;

    public o(ExchangeStatusService r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Map<String, Object> r4 = ((wy0.g) r3).getData();
        Object r0 = null;
        if (r4 == null) goto L5;
        Object r5 = r4.get("enable");
    L7:
        if ((r5 instanceof Boolean) == false) goto L10;
        r0 = r5;
    L10:
        Boolean r1 = (Boolean) r0;
        int r6 = v.a;
        v.e("ttlive_exchange", "receive auto exchange switch changed,enable: " + r1);
        if (r1 == null) goto L14;
        this.a.a().updateExchangeStatus(r1.booleanValue());
        return;
    L14:
        return;
    L5:
        r5 = null;
        goto L7
    }
}
