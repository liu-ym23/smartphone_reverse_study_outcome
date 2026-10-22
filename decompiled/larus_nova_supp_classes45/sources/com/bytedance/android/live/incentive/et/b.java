package com.bytedance.android.live.incentive.et;

import com.bytedance.android.live.incentive.exchange.e;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.i;
import mz0.m;
import mz0.n;
import mz0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public static final void a(String r4, e r5, Function1<? super o, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r6, "eventPropertyBuilder");
        n r0 = new n();
        m r1 = new m();
        r1.b(LogCommon.ROOM);
        r1.b(LogCommon.PAGE_SOURCE_LOG);
        List r2 = r0.b;
        ArrayList r3 = (ArrayList) r2;
        r3.addAll(r1.a);
        if (r5 == null) goto L5;
        Map r7 = r0.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter("_exchange_session_id", "key");
        Intrinsics.checkNotNullParameter(null, "value");
        r7.put("_exchange_session_id", null);
    L5:
        r6.invoke(new o(r0.a));
        cy0.e.a.getClass();
        j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r9);
        ((f80.a) r9).w3(r4, r0.a, r0.b);
    }

    public static final void b(o r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$set");
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        r1.a(r2, r3);
    }
}
