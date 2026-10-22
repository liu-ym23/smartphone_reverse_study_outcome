package com.bytedance.android.live.revlink.impl.multianchor.profit;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revenuelink.f;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.utils.e;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends e {
    public static final /* synthetic */ int e = 0;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.multianchor.profit.a$a, reason: collision with other inner class name */
    public static final class C0150a {
    }

    static {
    }

    public final void m(Throwable r2) {
        if (k() == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        if (r2 == null) goto L8;
        e.l(r2, r0);
        o("manual_clear_link_score_failed", r0);
        return;
    L8:
        o("manual_clear_link_score_success", r0);
    }

    public final void n(boolean r3, Throwable r4) {
        if (k() == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        y50.b.a.e(r0, "show_score", r3);
        if (r4 == null) goto L8;
        e.l(r4, r0);
        o("manual_switch_link_score_status_failed", r0);
        return;
    L8:
        o("manual_switch_link_score_status_success", r0);
    }

    public final void o(String r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r12, "event");
        Intrinsics.checkNotNullParameter(r13, "params");
        g(r13);
        c(r13);
        y50.b.a.d(r13, "event", r12);
        JSONObject r9 = new JSONObject();
        JSONObject r10 = new JSONObject();
        HashMap r7 = new HashMap();
        r7.put("android_event_key", r12);
        com.bytedance.android.live.revlink.impl.global.c r0 = this.d;
        if (r0 == null) goto L5;
        f r1 = r0.getRevenueLinkTraceMonitor();
    L6:
        f r2 = r1;
        if (r2 == null) goto L10;
        r2.Y(r12, LiveTracingMonitorKt.EventModule.MULTI_LINKER, 0, null, r7, r13, r9, r10);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public a(ld.a r1, com.bytedance.android.livesdk.revenue.service.room.c r2, LinkFakeGlobalService r3) {
        super(r1, r2, r3);
    }
}
