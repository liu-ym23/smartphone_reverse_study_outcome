package com.obric.memorydata.task.metrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BE\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JL\u0010\u0019\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/obric/memorydata/task/metrics/IndexPowerMetricsState;", "", "buckets", "", "", "Lcom/obric/memorydata/task/metrics/IndexPowerMetricsTotals;", "lastAttemptedWindowStartUtcMs", "pendingWindowStartUtcMs", "pendingReportedTaskTypes", "", "Lcom/obric/memorydata/task/metrics/IndexPowerTaskType;", "<init>", "(Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Set;)V", "getBuckets", "()Ljava/util/Map;", "getLastAttemptedWindowStartUtcMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPendingWindowStartUtcMs", "getPendingReportedTaskTypes", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Set;)Lcom/obric/memorydata/task/metrics/IndexPowerMetricsState;", "equals", "", "other", "hashCode", "", "toString", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Long, k> f12945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f12946b;
    private final Long c;
    private final Set<IndexPowerTaskType> d;

    public h() {
        this(null, null, null, null, 15, null);
    }

    public h(Map<Long, k> r3, Long r4, Long r5, Set<? extends IndexPowerTaskType> r6) {
        Map<Long, k> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Set<IndexPowerTaskType> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "buckets");
        Intrinsics.checkNotNullParameter(r8, "pendingReportedTaskTypes");
        this.f12945a = r7;
        this.f12946b = r4;
        this.c = r5;
        this.d = r8;
    }

    public /* synthetic */ h(Map r2, Long r3, Long r4, Set r5, int r6, DefaultConstructorMarker r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = MapsKt.emptyMap();
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r9 = SetsKt.emptySet();
    L14:
        this(r8, r3, r4, r9);
    }

    public static /* synthetic */ h a(h r1, Map r2, Long r3, Long r4, Set r5, int r6, Object r7) {
        Map<Long, k> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Set<IndexPowerTaskType> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = r1.f12945a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.f12946b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.c;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r9 = r1.d;
    L15:
        return r1.a(r8, r3, r4, r9);
    }

    public final h a(Map<Long, k> r2, Long r3, Long r4, Set<? extends IndexPowerTaskType> r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "buckets");
        Intrinsics.checkNotNullParameter(r6, "pendingReportedTaskTypes");
        return new h(r1, r3, r4, r6);
    }

    public final Map<Long, k> a() {
        return this.f12945a;
    }

    public final Long b() {
        return this.f12946b;
    }

    public final Long c() {
        return this.c;
    }

    public final Set<IndexPowerTaskType> d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12945a, r6.f12945a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f12946b, r6.f12946b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.f12945a.hashCode() * 31;
        Long r1 = this.f12946b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + this.d.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "IndexPowerMetricsState(buckets=" + this.f12945a + ", lastAttemptedWindowStartUtcMs=" + this.f12946b + ", pendingWindowStartUtcMs=" + this.c + ", pendingReportedTaskTypes=" + this.d + ')';
    }
}
