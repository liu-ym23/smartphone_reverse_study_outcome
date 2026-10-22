package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.revenue.common.r0;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r8, long r9, Throwable r12) {
        String r2 = RechargeMonitorService.TTLIVE_CHARGE_CHARGE_PACKAGE_API.getServiceName();
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r6, "metric");
        int r10 = !r8 ? 1 : 0;
        r6.put("status_code", String.valueOf(r10));
        r7.put("status_code", String.valueOf(r10));
        Intrinsics.checkNotNullParameter(r7, "map");
        Long r13 = Long.valueOf(r9);
        Intrinsics.checkNotNullParameter(Constants.Keys.duration, "key");
        Intrinsics.checkNotNullParameter(r13, "value");
        r7.put(Constants.Keys.duration, r13);
        if (r12 == null) goto L8;
        Integer r14 = Integer.valueOf(r0.a(r12));
        Intrinsics.checkNotNullParameter("error_code", "key");
        Intrinsics.checkNotNullParameter(r14, "value");
        r7.put("error_code", r14);
        String r15 = r12.getMessage();
        if (r15 != null) goto L7;
        r15 = r12.toString();
    L7:
        Intrinsics.checkNotNullParameter("error_msg", "key");
        Intrinsics.checkNotNullParameter(r15, "value");
        r7.put("error_msg", r15);
    L8:
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).b(n97.a.class);
        Intrinsics.checkNotNull(r17);
        ((com.bytedance.live.kmp.core.c) r17).g(r2, "revenue", "bussiness_api_call", r5, r6, r7);
    }

    public static void b(boolean r9, RechargeMonitorService r10, Map r12, Throwable r13) {
        Intrinsics.checkNotNullParameter(r10, "service");
        Intrinsics.checkNotNullParameter(r12, "extra");
        if (r12 == null) goto L11;
        if (r13 == null) goto L11;
        r12.put("error_code", Integer.valueOf(r0.a(r13)));
        String r1 = r13.getMessage();
        if (r1 != null) goto L10;
        r1 = r13.toString();
    L10:
        r12.put("error_msg", r1);
    L11:
        String r3 = r10.getServiceName();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        Intrinsics.checkNotNullParameter(r8, "extra");
        Intrinsics.checkNotNullParameter(r7, "metric");
        int r14 = !r9 ? 1 : 0;
        r7.put("status_code", String.valueOf(r14));
        r8.put("status_code", String.valueOf(r14));
        Intrinsics.checkNotNullParameter(r8, "map");
        Iterator r15 = r12.entrySet().iterator();
    L13:
        if (r15.hasNext() == false) goto L15;
        Map.Entry r16 = (Map.Entry) r15.next();
        String r17 = (String) r16.getKey();
        String r18 = r16.getValue().toString();
        Intrinsics.checkNotNullParameter(r17, "key");
        Intrinsics.checkNotNullParameter(r18, "value");
        r8.put(r17, r18);
        goto L13
    L15:
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r19).b(n97.a.class);
        Intrinsics.checkNotNull(r20);
        ((com.bytedance.live.kmp.core.c) r20).g(r3, "revenue", "bussiness_api_call", r6, r7, r8);
    }
}
