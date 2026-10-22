package com.bytedance.android.live.multilink.impl;

import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventType;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v2 {
    public static final void a(String r10, String r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r10, "eventType");
        Intrinsics.checkNotNullParameter(r11, "eventTypeValue");
        Intrinsics.checkNotNullParameter(r12, "extra");
        nd0.c.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "eventType");
        Intrinsics.checkNotNullParameter(r11, "eventTypeValue");
        Intrinsics.checkNotNullParameter(r12, "extra");
        MultiLinkEventModule r0 = nd0.c.l();
        MultiLinkEventType r13 = nd0.c.n(r10);
        BaseMonitor.add(r12, nd0.c.u(r13), r11);
        od0.c.a(r12);
        int r14 = rd0.b.a;
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "extra");
        Intrinsics.checkNotNullParameter(r8, "metric");
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r12, "jsonObject");
        Map r15 = JsonUtil.jsonObjectToMap(r12);
        Intrinsics.checkNotNullParameter(r15, "value");
        Iterator r16 = r15.entrySet().iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        Map.Entry r17 = (Map.Entry) r16.next();
        r9.put((String) r17.getKey(), r17.getValue());
        goto L4
    L6:
        String r5 = r0.getName();
        Intrinsics.checkNotNullParameter(r5, "eventModuleString");
        String r6 = r13.getName();
        Intrinsics.checkNotNullParameter(r6, "eventTypeString");
        cy0.e.a.getClass();
        cy0.j r18 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r19 = com.bytedance.android.scope.m.b(r18).b(n97.a.class);
        Intrinsics.checkNotNull(r19);
        ((com.bytedance.live.kmp.core.c) r19).g("ttlive_av_monitor", r5, r6, r7, r8, r9);
    }
}
