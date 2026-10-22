package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x<T> implements Consumer {
    public final /* synthetic */ Ref.LongRef a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ zy0.c c;

    public x(Ref.LongRef r1, JSONObject r2, zy0.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        long r0 = this.a.element;
        if (r8 != null) goto L6;
    L7:
        boolean r1 = true;
    L9:
        Ref.LongRef r2 = this.a;
        if (r8 == null) goto L12;
        long r4 = r8.longValue();
    L13:
        r2.element = r4;
        if (r1 == true) goto L19;
        if (r8 != null) goto L18;
        return;
    L18:
        if (r8.longValue() == 0) goto L19;
        return;
    L19:
        if (r8 != null) goto L22;
    L24:
        this.b.put("count_down", r8.longValue());
        xy0.a<?> r9 = this.c.g();
        if (r9 == null) goto L29;
        r9.sendJsEvent("H5_webcastNotification", this.b);
        return;
    L29:
        return;
    L22:
        if (r8.longValue() != 0) goto L24;
        int r3 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.a("ttlive_red_packet", "interval native is ready, ts: " + System.currentTimeMillis());
        goto L24
    L12:
        r4 = 0;
        goto L13
    L6:
        if (r0 != r8.longValue()) goto L7;
        r1 = false;
        goto L9
    }
}
