package com.bytedance.android.ec.core.monitor;

import com.bytedance.android.ec.sdk.ECSdk;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k {
    public static final Map<String, String> a = null;

    public k() {
    }

    static {
        a = new LinkedHashMap();
    }

    public static com.bytedance.android.ec.monitor.duration.d a() {
        Intrinsics.checkNotNullParameter("ec_perf_duration_anchor_v3_detail", "business");
        String r0 = b("ec_perf_duration_anchor_v3_detail");
        if (r0 != null) goto L7;
        return null;
    L7:
        return com.bytedance.android.ec.monitor.duration.i.a.get(r0);
    }

    public static String b(String r10) {
        Map<String, String> r0 = a;
        String r1 = (String) ((LinkedHashMap) r0).get(r10);
        if (r1 != null) goto L5;
        r1 = com.bytedance.android.ec.monitor.duration.i.a.create(r10);
    L5:
        r0.put(r10, r1);
        return (String) ((LinkedHashMap) r0).get(r10);
    }

    public static void c(JSONObject r10) {
        int r0 = ECSdk.a;
        pi.b r1 = (pi.b) ECSdk.a(pi.b.class);
        if (r1 == null) goto L6;
        r1.monitorEvent("ec_perf_page_show_sku_panel", r10, null, null);
        return;
    }

    public static void d(JSONObject r10) {
        int r0 = ECSdk.a;
        pi.b r1 = (pi.b) ECSdk.a(pi.b.class);
        if (r1 == null) goto L6;
        r1.monitorEvent("ec_perf_page_start_sku_panel", r10, null, null);
        return;
    }

    public static void e(String r10) {
        Intrinsics.checkNotNullParameter("ec_perf_duration_sku_panel", "business");
        Intrinsics.checkNotNullParameter(r10, "key");
        String r0 = b("ec_perf_duration_sku_panel");
        if (r0 == null) goto L8;
        com.bytedance.android.ec.monitor.duration.d r1 = com.bytedance.android.ec.monitor.duration.i.a.get(r0);
        if (r1 == null) goto L9;
        r1.a(r10);
        return;
    L9:
        return;
    }

    public static void f(String r10, com.bytedance.android.ec.monitor.duration.h r11) {
        Intrinsics.checkNotNullParameter(r10, "business");
        String r0 = b(r10);
        if (r0 == null) goto L11;
        com.bytedance.android.ec.monitor.duration.d r1 = com.bytedance.android.ec.monitor.duration.i.a.get(r0);
        if (r1 == null) goto L9;
        if (r11 == null) goto L8;
        r1.e(r11);
    L8:
        r1.report();
    L9:
        String r12 = a.remove(r10);
        return;
    }
}
