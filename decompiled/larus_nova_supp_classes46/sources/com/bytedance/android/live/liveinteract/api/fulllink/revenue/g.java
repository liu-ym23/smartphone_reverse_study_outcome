package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static final MultiLinkEventModule a = null;

    static {
        a = MultiLinkEventModule.PAID_LINK_MIC;
    }

    public static long b(long r5) {
        if (r5 > 0) goto L5;
        return 0;
    L5:
        if (r5 < System.currentTimeMillis()) goto L7;
        return 0;
    L7:
        return System.currentTimeMillis() - r5;
    }

    public static void c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "requestPage");
        JSONObject r3 = new JSONObject();
        r3.put("request_page", r10);
        nd0.c.p(nd0.c.a, LinkMonitorData.OpenNormalPaidApplyPanel, r3, a, 0, null, false, null, 120);
    }

    public static void a(int r9, int r10) {
        JSONObject r2 = new JSONObject();
        r2.put("mode", r10);
        r2.put("state", r9);
        nd0.c.p(nd0.c.a, LinkMonitorData.AddPriceButtonClick, r2, a, 0, null, false, null, 120);
    }
}
