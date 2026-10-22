package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void b(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "param");
        mz0.n r0 = new mz0.n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r1.putAll(r3);
        mz0.m r4 = new mz0.m();
        r4.b(LogCommon.LIVE_SHARE_LOG);
        r4.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r2 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r2, "pageSourceLog");
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(r2.a);
        List r7 = r0.b;
        ArrayList r8 = (ArrayList) r7;
        r8.addAll(r4.a);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((f80.a) r10).w3("livesdk_face_gift_send_intercept", r0.a, r0.b);
    }

    @JvmStatic
    public static final void c(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "param");
        mz0.n r0 = new mz0.n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r1.putAll(r3);
        mz0.m r4 = new mz0.m();
        r4.b(LogCommon.LIVE_SHARE_LOG);
        r4.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r2 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r2, "pageSourceLog");
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(r2.a);
        List r7 = r0.b;
        ArrayList r8 = (ArrayList) r7;
        r8.addAll(r4.a);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((f80.a) r10).w3("livesdk_face_gift_render_result", r0.a, r0.b);
    }

    @JvmStatic
    public static final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "transactionId");
        Intrinsics.checkNotNullParameter(r3, "errorMsg");
        Pair[] r0 = {TuplesKt.to("traceId", r2), TuplesKt.to("err_msg", r3)};
        LinkedHashMap r4 = new LinkedHashMap();
        MapsKt.putAll(r4, r0);
        mz0.n r5 = new mz0.n();
        Map r1 = r5.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r1.putAll(r4);
        mz0.m r6 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r7 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r7, "pageSourceLog");
        ((ArrayList) r6.a).add(r7.a);
        r6.b(LogCommon.ROOM);
        ((ArrayList) r5.b).addAll(r6.a);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((f80.a) r9).w3("livesdk_effect_play_error", r5.a, r5.b);
    }
}
