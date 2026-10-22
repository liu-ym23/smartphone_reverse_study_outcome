package com.bytedance.android.live.recharge.trace;

import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.scope.m;
import cy0.j;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r10, JSONObject r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r12, "category");
        Intrinsics.checkNotNullParameter(r13, "extra");
        j01.d.b(r12, "status", 0);
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "extra");
        Intrinsics.checkNotNullParameter(r8, "metric");
        EventModule r14 = EventModule.RECHARGE;
        Intrinsics.checkNotNullParameter(r14, "eventModule");
        String r5 = r14.getValue();
        Intrinsics.checkNotNullParameter(r9, "map");
        Iterator<String> r15 = r13.keys();
    L4:
        if (r15.hasNext() == false) goto L6;
        String r0 = r15.next();
        Object r1 = r13.get(r0);
        Intrinsics.checkNotNullParameter(r0, "key");
        Intrinsics.checkNotNullParameter(r1, "value");
        r9.put(r0, r1);
        goto L4
    L6:
        cy0.e.a.getClass();
        j r16 = cy0.e.a.a;
        m.e.getClass();
        Object r17 = m.b(r16).b(n97.a.class);
        Intrinsics.checkNotNull(r17);
        ((com.bytedance.live.kmp.core.c) r17).g(r10, r5, "bussiness_api_call", r7, r8, r9);
    }
}
