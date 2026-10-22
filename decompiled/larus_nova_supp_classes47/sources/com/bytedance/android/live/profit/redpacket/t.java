package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ RedPacketHybridService a;
    public final /* synthetic */ zy0.c b;

    public t(RedPacketHybridService r1, zy0.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        l1 r5 = (l1) r4;
        if (this.a.c().isShowing() == false) goto L9;
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "SurpriseRedEnvelopeResult");
        r0.put("surpriseResult", GsonProtectorUtils.toJson(GsonHelper.get(), r5));
        xy0.a<?> r1 = this.b.g();
        if (r1 == null) goto L7;
        r1.sendJsEvent("H5_webcastNotification", r0);
    L7:
        int r2 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("RedPacketHybridService", "send js event, receiveResults: " + GsonProtectorUtils.toJson(GsonHelper.get(), r5));
        return;
    }
}
