package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Action;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v implements Action {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ zy0.c b;

    public v(JSONObject r1, zy0.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        this.a.put("count_down", 0);
        xy0.a<?> r0 = this.b.g();
        if (r0 == null) goto L5;
        r0.sendJsEvent("H5_webcastNotification", this.a);
    L5:
        int r1 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.a("ttlive_red_packet", "anim native is ready, ts: " + System.currentTimeMillis());
    }
}
