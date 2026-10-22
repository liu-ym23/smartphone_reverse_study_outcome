package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ n0 a;
    public final /* synthetic */ zy0.c b;

    public p(n0 r1, zy0.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        RedPacketState r8 = (RedPacketState) r7;
        String r2 = null;
        if ((r8 instanceof RedPacketState.Empty) == false) goto L12;
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "RedEnvelopeEndUpdate");
        n0 r4 = this.a;
        if (r4 == null) goto L7;
        String r5 = r4.d;
    L8:
        r0.put("boxId", String.valueOf(r5));
        xy0.a<?> r6 = this.b.g();
        if (r6 == null) goto L12;
        r6.sendJsEvent("H5_webcastNotification", r0);
        goto L12
    L7:
        r5 = null;
    L12:
        if ((r8 instanceof RedPacketState.Expired) == false) goto L20;
        JSONObject r9 = new JSONObject();
        r9.put("eventName", "RedEnvelopeTimeOutUpdate");
        n0 r1 = this.a;
        if (r1 == null) goto L16;
        r2 = r1.d;
    L16:
        r9.put("box_id", String.valueOf(r2));
        xy0.a<?> r3 = this.b.g();
        if (r3 == null) goto L21;
        r3.sendJsEvent("H5_webcastNotification", r9);
        return;
    L21:
        return;
    }
}
