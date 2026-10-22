package com.larus.bmhome.resource.access;

import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e0 {
    public static final Set<ResourceTraceResult> a = null;

    public e0() {
    }

    static {
        a = SetsKt.setOf(new ResourceTraceResult[]{ResourceTraceResult.READY, ResourceTraceResult.FAILED});
    }

    public static void b(f r11, h0 r12, ResourceTraceStage r13, ResourceTraceResult r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "task");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "stage");
        Intrinsics.checkNotNullParameter(r14, "result");
        if (r13 == ResourceTraceStage.TASK_LIFECYCLE) goto L5;
    L7:
        boolean r3 = false;
    L8:
        long r5 = 0;
        if (r3 == false) goto L11;
        r11.getClass();
        r5 = RangesKt.coerceAtLeast(System.currentTimeMillis() - r11.f, 0);
    L11:
        if (r3 == false) goto L13;
        Map r4 = MapsKt.mapOf(TuplesKt.to("e2e_cost_ms", String.valueOf(r5)));
    L14:
        String r7 = r13.getValue();
        String r9 = r14.getValue();
        long r6 = r5;
        t r0 = a(r11, r12, "pipeline", r7, r6, r9, r15, r4);
        u.a.getClass();
        u.b(r0);
        return;
    L13:
        r4 = MapsKt.emptyMap();
        goto L14
    L5:
        if (a.contains(r14) == false) goto L7;
        r3 = true;
        goto L8
    }

    public static void c(f r10, h0 r11, l0 r12, long r13, ResourceTraceResult r15, String r16, Map r17) {
        Intrinsics.checkNotNullParameter(r10, "task");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "node");
        Intrinsics.checkNotNullParameter(r15, "result");
        Intrinsics.checkNotNullParameter(r17, "attributes");
        t r0 = a(r10, r11, r12.getKey(), r12.d().name(), r13, r15.getValue(), r16, r17);
        u.a.getClass();
        u.b(r0);
    }

    public static t a(f r27, h0 r28, String r29, String r30, long r31, String r33, String r34, Map r35) {
        f0 r2 = r28.h;
        if (r2 == null) goto L5;
        Map<String, String> r3 = r2.f;
    L6:
        if (r3 != null) goto L8;
        r3 = MapsKt.emptyMap();
    L8:
        Map<? extends String, ? extends String> r4 = MapsKt.plus(MapsKt.plus(r3, r28.b()), r35);
        r27.getClass();
        Intrinsics.checkNotNullParameter(r4, "attributes");
        if (r4.isEmpty() == true) goto L12;
        r27.i.putAll(r4);
    L12:
        String r5 = r27.a;
        x r6 = r28.a.a;
        ResourceInputType r7 = r28.c.getType();
        w r0 = r28.a;
        ResourceMediaType r8 = r0.c;
        String r9 = r0.d.a;
        String r15 = (String) r4.get("remote_policy_version");
        String r16 = (String) r4.get("route_decision");
        String r17 = (String) r4.get("route_reason");
        String r1 = (String) r4.get("cache_hit");
        if (r1 != null) goto L16;
        r1 = (String) r4.get("cache_stage");
    L16:
        return new t(r5, r6, r7, r8, r9, r29, r30, r31, r33, r34, r15, r16, r17, r1, (String) r4.get("sdk_route"), (String) r4.get("remote_resolve"), null, null, null, r4, 458752);
    L5:
        r3 = null;
        goto L6
    }
}
