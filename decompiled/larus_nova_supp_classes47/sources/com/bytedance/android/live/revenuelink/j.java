package com.bytedance.android.live.revenuelink;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revenue.common.b0;
import com.bytedance.android.live.revenuelink.withroom.LinkStoreService;
import com.bytedance.android.scope.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j implements f {
    public final com.bytedance.android.live.revenuelink.withroom.a a;

    public j(LinkStoreService r1) {
        this.a = r1;
    }

    public static void a(JSONObject r3) {
        if (r3 == null) goto L5;
        int r0 = com.bytedance.android.live.revenuelink.utils.a.a;
        r3.put("device_radio", Float.valueOf(((Number) b0.d.getValue(null, b0.a[2])).floatValue()));
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.f
    public final boolean X(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        return ((ArrayList) g11.a.f.getValue(null, g11.a.a[4])).contains(r4);
    }

    public final void b(JSONObject r4) {
        cy0.e.a.getClass();
        cy0.j r1 = cy0.e.a.a;
        m.e.getClass();
        Object r0 = m.b(r1).b(wh6.a.class);
        Intrinsics.checkNotNull(r0);
        wh6.a r2 = (com.bytedance.live.kmp.core.c) r0;
        if (r4 == null) goto L5;
        r4.put("update_version_code", r2.getUpdateVersionCode());
    L5:
        if (r4 == null) goto L7;
        r4.put("version_code", r2.getVersionCode());
    L7:
        if (r4 == null) goto L9;
        r4.put("app_id", r2.getAppId());
    L9:
        if (r4 == null) goto L22;
        com.bytedance.android.live.revenuelink.withroom.a r3 = this.a;
        if (r3 == null) goto L13;
        com.bytedance.android.live.revenuelink.rtc.f r5 = r3.m0();
    L14:
        if (r5 == null) goto L19;
        com.bytedance.android.live.revenuelink.rtc.i r6 = r5.getRtcManager();
        if (r6 == null) goto L19;
        String r7 = r6.O();
        if (r7 == null) goto L19;
    L20:
        r4.put("rtc_channel_id", r7);
        return;
    L19:
        r7 = "";
        goto L20
    L13:
        r5 = null;
        goto L14
    }

    @Override // com.bytedance.android.live.revenuelink.f
    public final void b0(String r12, LiveTracingMonitorKt.EventModule r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r12, "event");
        Intrinsics.checkNotNullParameter(r13, "module");
        if (g11.a.a() == true) goto L5;
        return;
    L5:
        b(r14);
        JSONObject r0 = new JSONObject();
        a(r0);
        l.a(this.a, k.a(r12, r13, new HashMap(), 0, null, null, 0, 120), new JSONObject(), r0, r14);
    }

    @Override // com.bytedance.android.live.revenuelink.f
    public final void Z(String r14, LiveTracingMonitorKt.EventModule r15, Map<String, Object> r16, JSONObject r17, long r18) {
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r15, "module");
        Intrinsics.checkNotNullParameter(r16, "index");
        if (g11.a.a() == true) goto L5;
        return;
    L5:
        b(r17);
        JSONObject r2 = new JSONObject();
        a(r2);
        l.a(this.a, k.a(r14, r15, r16, 0, null, null, r18, 56), new JSONObject(), r2, r17);
    }

    @Override // com.bytedance.android.live.revenuelink.f
    public final void a0(String r14, LiveTracingMonitorKt.EventModule r15, String r16, Map<String, Object> r17, JSONObject r18, long r19) {
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r15, "module");
        Intrinsics.checkNotNullParameter(r17, "index");
        if (g11.a.a() == true) goto L5;
        return;
    L5:
        b(r18);
        JSONObject r2 = new JSONObject();
        a(r2);
        l.a(this.a, k.a(r14, r15, r17, 0, null, r16, r19, 24), new JSONObject(), r2, r18);
    }

    @Override // com.bytedance.android.live.revenuelink.f
    public final void c0(String r14, LiveTracingMonitorKt.EventModule r15, int r16, String r17, Map<String, Object> r18, JSONObject r19) {
        Intrinsics.checkNotNullParameter(r14, "event");
        Intrinsics.checkNotNullParameter(r15, "module");
        Intrinsics.checkNotNullParameter(r18, "index");
        if (g11.a.a() == true) goto L5;
        return;
    L5:
        b(r19);
        JSONObject r2 = new JSONObject();
        a(r2);
        l.a(this.a, k.a(r14, r15, r18, r16, r17, null, 0, 96), new JSONObject(), r2, r19);
    }

    @Override // com.bytedance.android.live.revenuelink.f
    public final void Y(String r13, LiveTracingMonitorKt.EventModule r14, int r15, String r16, Map<String, Object> r17, JSONObject r18, JSONObject r19, JSONObject r20) {
        Intrinsics.checkNotNullParameter(r13, "event");
        Intrinsics.checkNotNullParameter(r14, "module");
        Intrinsics.checkNotNullParameter(r17, "index");
        Intrinsics.checkNotNullParameter(r18, "extra");
        if (g11.a.a() == true) goto L5;
        return;
    L5:
        b(r18);
        a(r20);
        l.a(this.a, k.a(r13, r14, r17, r15, r16, null, 0, 96), r19, r20, r18);
    }
}
