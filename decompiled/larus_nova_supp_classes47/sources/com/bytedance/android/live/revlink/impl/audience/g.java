package com.bytedance.android.live.revlink.impl.audience;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends com.bytedance.android.live.revlink.impl.multianchor.utils.e {
    public long e;
    public long f;

    public static final class a {
    }

    static {
    }

    public g(ld.a r1, com.bytedance.android.livesdk.revenue.service.room.c r2, LinkFakeGlobalService r3) {
        super(r1, r2, r3);
    }

    public static void m(g r7, String r8, JSONObject r9, int r10, int r12, String r13, int r14) {
        if ((r14 & 8) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r14 & 16) == 0) goto L9;
        r13 = "";
    L9:
        String r4 = r13;
        r7.e(r9);
        com.bytedance.android.live.revenuelink.f r0 = null;
        jy0.b.f("ttlive_revlink_sei", r8 + ": scene=" + r10 + " code=" + r3 + " msg=" + r4 + " extra=" + r9, null, 4);
        HashMap r5 = new HashMap();
        r5.put("android_event_key", r8);
        com.bytedance.android.live.revlink.impl.global.c r15 = r7.d;
        if (r15 == null) goto L12;
        r0 = r15.getRevenueLinkTraceMonitor();
    L12:
        if (r0 != null) goto L14;
        return;
    L14:
        if (r10 != 7) goto L16;
        LiveTracingMonitorKt.EventModule r16 = LiveTracingMonitorKt.EventModule.MULTI_LINKER;
    L17:
        r0.c0("ttlive_pk_business_api_call", r16, r3, r4, r5, r9);
        return;
    L16:
        r16 = LiveTracingMonitorKt.EventModule.PK;
        goto L17
    L5:
        r3 = r12;
        goto L7
    }
}
