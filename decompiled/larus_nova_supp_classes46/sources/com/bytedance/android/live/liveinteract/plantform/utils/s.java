package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s {
    public long a;
    public long b;
    public int c;
    public long d;
    public boolean e;

    public s() {
    }

    public final void a() {
        if (this.d != 0) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis() - this.d;
        if (this.a != 0) goto L8;
        this.a = r0;
    L8:
        this.b += r0;
        this.d = 0;
        this.e = false;
    }

    public final void b() {
        a();
        long r0 = this.a;
        if (r0 <= 0) goto L5;
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        JSONObject r8 = new JSONObject();
        r8.put("duration", r0);
        nd0.c.o(nd0.c.a, LinkMonitorData.ANCHOR_FIRST_ZERO_LINK_DURATION, r8, 0, null, false, 28);
        this.a = 0;
    L5:
        long r1 = this.b;
        if (r1 <= 0) goto L9;
        TalkRoomBusinessFullLinkMonitor r5 = TalkRoomBusinessFullLinkMonitor.a;
        int r6 = this.c;
        r5.getClass();
        JSONObject r9 = new JSONObject();
        r9.put("zero_link_count", r6);
        r9.put("duration", r1);
        nd0.c.o(nd0.c.a, LinkMonitorData.ANCHOR_TOTAL_ZERO_LINK_DURATION, r9, 0, null, false, 28);
        this.b = 0;
        this.c = 0;
        return;
    }

    public final void c() {
        this.d = System.currentTimeMillis();
        this.e = true;
        this.c++;
    }
}
