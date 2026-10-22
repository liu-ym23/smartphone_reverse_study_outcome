package com.bytedance.android.livesdk.dynamicstrategy.impl.nfa;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.log.k0;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
    }

    public static void d(String r1) {
        Intrinsics.checkNotNullParameter(r1, "info");
        ALogger.i("StrategyCepNfa_timer", r1);
    }

    public static void b(String r1, Map r2) {
        k0.o().j(r1, r2);
    }

    public static void c(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r5, "patternName");
        Intrinsics.checkNotNullParameter(r6, "reason");
        b("StrategyCepNfa_pattern", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", r3), TuplesKt.to("event_name", r4), TuplesKt.to("pattern_name", r5), TuplesKt.to("reason", r6)}));
    }

    public static void a(String r3, String r4, long r5, long r7, String r9) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r9, "reason");
        b("StrategyCepNfa_flow_remove", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("room_id", r3), TuplesKt.to("nfa_name", r4), TuplesKt.to("startTime", Long.valueOf(r5)), TuplesKt.to("lastTime", Long.valueOf(r7)), TuplesKt.to("reason", r9)}));
    }
}
