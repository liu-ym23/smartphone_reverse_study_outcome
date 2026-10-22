package com.bytedance.android.live.recharge.trace.session;

import com.bytedance.android.live.revenue.common.t0;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import cy0.e;
import cy0.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import mz0.i;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final u0 a;
    public final Map<String, List<b>> b;
    public boolean c;
    public final Map<String, String> d;

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.trace.session.a$a, reason: collision with other inner class name */
    public static final class C0076a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r3v19, types: [com.bytedance.android.live.recharge.trace.session.RechargePanelSession$writeMetrics$1] */
    public final void a() {
        this.c = true;
        u0 r0 = u0.f;
        u0 r1 = t0.b().b(this.a);
        final LinkedHashMap r2 = new LinkedHashMap();
        r2.put("session_duration", String.valueOf(r1.a));
        r2.putAll(this.d);
        ArrayList r3 = new ArrayList();
        Iterator r4 = ((LinkedHashMap) this.b).keySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L17;
        String r5 = (String) r4.next();
        LinkedHashMap r6 = (LinkedHashMap) this.b;
        Object r7 = r6.get(r5);
        if (r7 != null) goto L8;
        r7 = new ArrayList();
        r6.put(r5, r7);
    L8:
        List r8 = (List) r7;
        Iterator r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        b r10 = (b) r9.next();
        r2.put(r10.b, String.valueOf(r10.c.b(this.a).a));
        goto L10
    L12:
        CollectionsKt.addAll(r3, r8);
        final LinkedHashMap r12 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r3, 10)), 16));
        Iterator r13 = r3.iterator();
    L14:
        if (r13.hasNext() == false) goto L16;
        b r14 = (b) r13.next();
        Pair r15 = TuplesKt.to(r14.b, r14);
        r12.put(r15.getFirst(), r15.getSecond());
        goto L14
    L16:
        ?? r16 = new RechargePanelSession$writeMetrics$1(r12, r2);
        c r17 = d.b;
        c r18 = d.c;
        r16.invoke(r17, r18);
        c r19 = d.h;
        r16.invoke(r18, r19);
        c r20 = d.j;
        r16.invoke(r19, r20);
        c r22 = d.e;
        r16.invoke(r17, r22);
        r16.invoke(r19, r22);
        r16.invoke(r20, r22);
        goto L4
    L17:
        jy0.b.a("Recharge/RechargePanelSession", CollectionsKt.joinToString$default(r2.entrySet(), "\n", null, null, 0, null, RechargePanelSession$uploadEvents$2.INSTANCE, 30, null));
        n r23 = new n();
        Map<String, String> r24 = r23.a;
        Intrinsics.checkNotNullParameter(r24, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r24.putAll(r2);
        m r25 = new m();
        r25.b(LogCommon.ROOM);
        r25.b(LogCommon.PAGE_SOURCE_LOG);
        List<Object> r26 = r23.b;
        ArrayList r27 = (ArrayList) r26;
        r27.addAll(r25.a);
        e.a.getClass();
        j r28 = e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r29 = com.bytedance.android.scope.m.b(r28).a(Reflection.getOrCreateKotlinClass(i.class));
        Intrinsics.checkNotNull(r29);
        ((i) ((f80.a) r29)).w3("livesdk_rd_recharge_duration_v2", r23.a, r23.b);
        ((LinkedHashMap) this.b).clear();
        jy0.b.d("Recharge/RechargePanelSession", "session closed");
    }

    public a() {
        u0 r0 = u0.f;
        this.a = t0.b();
        this.b = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    public final void b(b r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (this.c == false) goto L5;
        return;
    L5:
        jy0.b.a("Recharge/RechargePanelSession", "reportEvent: " + r4);
        String r0 = r4.a;
        LinkedHashMap r1 = (LinkedHashMap) this.b;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L8;
        r2 = new ArrayList();
        r1.put(r0, r2);
    L8:
        ((List) r2).add(r4);
    }

    public final void c(c r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        r4.getClass();
        String r1 = r4.a;
        String r5 = r4.b;
        u0 r2 = u0.f;
        b(new b(r1, r5, t0.b()));
    }
}
