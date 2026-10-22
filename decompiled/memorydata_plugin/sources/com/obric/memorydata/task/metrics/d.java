package com.obric.memorydata.task.metrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\f\u001a\u00020\r*\u00020\rH\u0002\u001a\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¨\u0006\u0011"}, d2 = {"accumulate", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsTotals;", "observation", "Lcom/obric/memorydata/task/metrics/IndexPowerObservation;", "durationMs", "", "toSamples", "", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricSample;", "windowStartUtcMs", "windowEndUtcMs", "snapshotAtMs", "sanitized", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsState;", "saturatedAdd", "left", "right", "task_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class d {
    public static final /* synthetic */ long a(long r0, long r2) {
        return b(r0, r2);
    }

    public static final /* synthetic */ h a(h r0) {
        return b(r0);
    }

    private static final k a(k r28) {
        return r28.a(Math.max(0, r28.a()), RangesKt.coerceIn(r28.b(), 0, Math.max(0, r28.a())), Math.max(0, r28.c()), RangesKt.coerceIn(r28.d(), 0, Math.max(0, r28.c())), Math.max(0, r28.e()), RangesKt.coerceIn(r28.f(), 0, Math.max(0, r28.e())), Math.max(0, r28.g()), RangesKt.coerceIn(r28.h(), 0, Math.max(0, r28.g())));
    }

    public static final /* synthetic */ k a(k r0, l r1, long r2) {
        return b(r0, r1, r2);
    }

    public static final /* synthetic */ List a(k r0, long r1, long r3, long r5) {
        return b(r0, r1, r3, r5);
    }

    private static final long b(long r4, long r6) {
        if (r6 > 0) goto L7;
        return Math.max(0, r4);
    L7:
        if (r4 <= (Long.MAX_VALUE - r6)) goto L10;
        return Long.MAX_VALUE;
    L10:
        return r4 + r6;
    }

    private static final h b(h r12) {
        Long r0 = r12.b();
        Map<Long, k> r1 = r12.a();
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<Long, k>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        long r5 = ((Number) ZeusTransformUtils.preCheckCast(r4.getKey(), Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r0 != null) goto L8;
    L11:
        boolean r6 = true;
    L12:
        if (r6 == false) goto L4;
        r2.put(r4.getKey(), r4.getValue());
        goto L4
    L8:
        if (r5 > r0.longValue()) goto L11;
        r6 = false;
        goto L12
    L14:
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r7.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r7.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r9.hasNext() == false) goto L19;
        Object r10 = r9.next();
        r8.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r10, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), a((k) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r10, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), k.class, "com.obric.memorydata.plugin")));
        goto L16
    L19:
        return h.a(r12, r8, null, null, null, 14, null);
    }

    private static final k b(k r33, l r34, long r35) {
        Long r0 = Long.valueOf(r35);
        ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue();
        boolean r3 = true;
        if (r34.a() == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        long r2 = r0.longValue();
    L12:
        Long r10 = Long.valueOf(r35);
        ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r34.b() == null) goto L15;
        boolean r11 = true;
    L16:
        if (r11 == true) goto L19;
        r10 = null;
    L19:
        if (r10 == null) goto L21;
        long r12 = r10.longValue();
    L22:
        Long r13 = Long.valueOf(r35);
        ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r34.c() == true) goto L25;
    L27:
        boolean r14 = false;
    L28:
        if (r14 == true) goto L31;
        r13 = null;
    L31:
        if (r13 == null) goto L33;
        long r15 = r13.longValue();
    L34:
        Long r16 = Long.valueOf(r35);
        ((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r34.d() == true) goto L37;
    L39:
        boolean r17 = false;
    L40:
        if (r17 == true) goto L43;
        r16 = null;
    L43:
        if (r16 == null) goto L45;
        long r18 = r16.longValue();
    L46:
        long r19 = b(r33.a(), r2);
        long r4 = r33.b();
        Long r7 = Long.valueOf(r35);
        ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (Intrinsics.areEqual(r34.a(), true) == true) goto L50;
        r7 = null;
    L50:
        if (r7 == null) goto L52;
        long r8 = r7.longValue();
    L53:
        long r110 = b(r4, r8);
        long r21 = b(r33.c(), r12);
        long r5 = r33.d();
        Long r9 = Long.valueOf(r35);
        ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (Intrinsics.areEqual(r34.b(), true) == true) goto L57;
        r9 = null;
    L57:
        if (r9 == null) goto L59;
        long r20 = r9.longValue();
    L60:
        long r23 = b(r5, r20);
        long r25 = b(r33.e(), r15);
        long r6 = r33.f();
        Long r22 = Long.valueOf(r35);
        ((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r34.c() == true) goto L63;
    L65:
        boolean r24 = false;
    L66:
        if (r24 == true) goto L69;
        r22 = null;
    L69:
        if (r22 == null) goto L71;
        long r26 = r22.longValue();
    L72:
        long r27 = b(r6, r26);
        long r29 = b(r33.g(), r18);
        long r28 = r33.h();
        Long r30 = Long.valueOf(r35);
        ((Number) ZeusTransformUtils.preCheckCast(r30, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r34.d() == true) goto L75;
    L77:
        r3 = false;
    L78:
        if (r3 == false) goto L80;
        Long r31 = r30;
    L81:
        if (r31 == null) goto L83;
        long r32 = r31.longValue();
    L85:
        return r33.a(r19, r110, r21, r23, r25, r27, r29, b(r28, r32));
    L83:
        r32 = 0;
        goto L85
    L80:
        r31 = null;
        goto L81
    L75:
        if (Intrinsics.areEqual(r34.b(), false) == false) goto L77;
    L71:
        r26 = 0;
        goto L72
    L63:
        if (Intrinsics.areEqual(r34.a(), false) == false) goto L65;
        r24 = true;
        goto L66
    L59:
        r20 = 0;
        goto L60
    L52:
        r8 = 0;
        goto L53
    L45:
        r18 = 0;
        goto L46
    L37:
        if (r34.b() == null) goto L39;
        r17 = true;
        goto L40
    L33:
        r15 = 0;
        goto L34
    L25:
        if (r34.a() == null) goto L27;
        r14 = true;
        goto L28
    L21:
        r12 = 0;
        goto L22
    L15:
        r11 = false;
        goto L16
    L11:
        r2 = 0;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    private static final List<a> b(k r25, long r26, long r28, long r30) {
        return CollectionsKt.listOf(new a[]{new a(2, r26, r28, r30, IndexPowerTaskType.FAST, r25.a(), r25.b(), r25.e(), r25.f()), new a(2, r26, r28, r30, IndexPowerTaskType.SLOW, r25.c(), r25.d(), r25.g(), r25.h())});
    }
}
