package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardCoverageAccumulator;", "", "policyVersion", "", "supportedEntityTypes", "", "snapshotAtMs", "", "<init>", "(ILjava/util/Set;J)V", "overall", "Lcom/obric/memorydata/database/index/IndexDashboardCoverageAccumulator$MutableCoverageCounts;", "byEntityType", "", "addPage", "", "rows", "", "Lcom/obric/memorydata/database/index/CoverageEntityState;", "build", "Lcom/obric/memorydata/database/index/CoverageMetric;", "unknownPolicyEntityCount", "MutableCoverageCounts", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9332b;
    private final a c;
    private final Map<Integer, a> d;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J/\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardCoverageAccumulator$MutableCoverageCounts;", "", "<init>", "()V", "expected", "", "completed", "incomplete", "unknown", "unknownPolicyMismatch", "unknownState", "historicalLifecycleMissing", "pending", "add", "", "row", "Lcom/obric/memorydata/database/index/CoverageEntityState;", "toMetric", "Lcom/obric/memorydata/database/index/CoverageMetric;", "policyVersion", "", "entityType", "unknownPolicyEntityCount", "snapshotAtMs", "(ILjava/lang/Integer;Ljava/lang/Long;J)Lcom/obric/memorydata/database/index/CoverageMetric;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f9333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f9334b;
        private long c;
        private long d;
        private long e;
        private long f;
        private long g;
        private long h;

        public a() {
        }

        public final h a(int r25, Integer r26, Long r27, long r28) {
            return new h(r25, r26, this.f9333a, this.f9334b, this.c, this.d, this.e, this.f, this.g, this.h, r27, r28);
        }

        public final void a(f r5) {
            Intrinsics.checkNotNullParameter(r5, "row");
            this.f9333a++;
            if (r5.f() == false) goto L6;
            this.g++;
        L6:
            if (r5.e() == true) goto L9;
            this.d++;
            this.e++;
        L21:
            if (r5.d() == false) goto L24;
            this.h++;
            return;
        L24:
            return;
        L9:
            if (r5.f() == false) goto L15;
            if (r5.c() != CoverageCompletion.COMPLETE) goto L13;
        L12:
            this.f9334b++;
        L13:
            this.c++;
            goto L21
        L15:
            if (r5.c() != CoverageCompletion.UNKNOWN) goto L18;
            this.d++;
            this.f++;
            goto L21
        L18:
            if (r5.c() != CoverageCompletion.COMPLETE) goto L13;
            goto L13
        }
    }

    public ae(int r3, Set<Integer> r4, long r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "supportedEntityTypes");
        this.f9331a = r3;
        this.f9332b = r5;
        this.c = new a();
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashMap r8 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16));
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Object r10 = r9.next();
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin");
        ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).intValue();
        r11.put(r10, new a());
        goto L4
    L6:
        this.d = MapsKt.toMutableMap((Map) ZeusTransformUtils.preCheckCast(r8, Map.class, "com.obric.memorydata.plugin"));
    }

    public final List<h> a(long r10) {
        if (this.f9331a > 0) goto L5;
        return null;
    L5:
        if (r10 < 0) goto L16;
        List r0 = CollectionsKt.createListBuilder();
        r0.add(this.c.a(this.f9331a, null, Long.valueOf(r10), this.f9332b));
        Iterator r11 = ((Map) ZeusTransformUtils.preCheckCast(MapsKt.toSortedMap(this.d), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L12;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r12.getKey(), Integer.class, "com.obric.memorydata.plugin");
        r0.add(((a) ZeusTransformUtils.preCheckCast(r12.getValue(), a.class, "com.obric.memorydata.plugin")).a(this.f9331a, r5, null, this.f9332b));
        goto L9
    L12:
        return CollectionsKt.build(r0);
    L16:
        return null;
    }

    public final void a(List<f> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "rows");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r8.next(), f.class, "com.obric.memorydata.plugin");
        this.c.a(r0);
        Map<Integer, a> r2 = this.d;
        Integer r3 = Integer.valueOf(r0.b());
        a r4 = r2.get(r3);
        if (r4 != null) goto L8;
        r4 = new a();
        r2.put(r3, r4);
    L8:
        ((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin")).a(r0);
        goto L4
    }
}
