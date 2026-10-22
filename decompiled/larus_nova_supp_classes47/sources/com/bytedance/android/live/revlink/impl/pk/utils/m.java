package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public final JSONObject a;
    public long b;
    public long c;
    public long d;
    public int e;

    public final void b() {
        if (this.b != 0) goto L5;
        return;
    L5:
        if (this.c == 0) goto L13;
        long r0 = System.currentTimeMillis();
        this.d = r0;
        this.a.put("draw_time", r0 - this.c);
        long r1 = this.d - this.b;
        if (this.e != 0) goto L12;
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_pk_performance_fetch_invite_list_time", 0, r1, this.a);
        this.b = 0;
        this.c = 0;
        return;
    L12:
        return;
    }

    public m() {
        this.a = new JSONObject();
    }

    public final void c() {
        this.b = System.currentTimeMillis();
    }

    public final void a(int r9) {
        long r0 = System.currentTimeMillis();
        this.c = r0;
        long r2 = this.b;
        if (r2 != 0) goto L5;
        return;
    L5:
        this.a.put("reqeust_time", r0 - r2);
        this.e = r9;
        if (r9 != 1) goto L9;
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_pk_performance_fetch_invite_list_time", 1, this.a);
        this.b = 0;
        return;
    }
}
