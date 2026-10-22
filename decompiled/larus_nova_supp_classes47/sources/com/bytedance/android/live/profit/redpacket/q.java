package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ zy0.c a;

    public q(zy0.b r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "RedEnvelopeEndUpdate");
        r0.put("boxId", ((String) r4).toString());
        xy0.a<?> r5 = this.a.g();
        if (r5 == null) goto L6;
        r5.sendJsEvent("H5_webcastNotification", r0);
        return;
    }
}
