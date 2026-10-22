package com.obric.memorydata.database.index;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ?\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0002¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0002R\u000e\u0010\u0018\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardBacklogAggregator;", "", "<init>", "()V", "aggregate", "", "Lcom/obric/memorydata/database/index/BacklogMetric;", "snapshotAtMs", "", "rows", "Lcom/obric/memorydata/database/index/BacklogPendingRow;", "supportedEntityTypes", "", "", EventBody.KEY_METRIC, TypedValues.Custom.S_DIMENSION, "Lcom/obric/memorydata/database/index/BacklogDimension;", "entityType", "buildType", "", "(Lcom/obric/memorydata/database/index/BacklogDimension;Ljava/lang/Integer;Ljava/lang/String;JLjava/util/List;)Lcom/obric/memorydata/database/index/BacklogMetric;", "ageBucket", "Lcom/obric/memorydata/database/index/BacklogAgeBucket;", "startedAtMs", "HOUR_MS", "DAY_MS", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ab f9325a = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin")).getFirst(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin")).getFirst(), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f9326a;

        public b(Comparator r3) {
            this.f9326a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f9326a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin")).getSecond(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin")).getSecond(), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f9325a = new ab();
    }

    private ab() {
    }

    private final BacklogAgeBucket a(long r3, long r5) {
        if (r5 > 0) goto L5;
        return null;
    L5:
        if (r5 > r3) goto L65;
        long r4 = r3 - r5;
        boolean r0 = true;
        if (0 <= r4) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L16;
        return BacklogAgeBucket.LT_1H;
    L16:
        if (ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS <= r4) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == false) goto L24;
        return BacklogAgeBucket.H1_TO_6H;
    L24:
        if (21600000 <= r4) goto L26;
    L28:
        boolean r7 = false;
    L29:
        if (r7 == false) goto L32;
        return BacklogAgeBucket.H6_TO_24H;
    L32:
        if (WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS <= r4) goto L34;
    L36:
        boolean r8 = false;
    L37:
        if (r8 == false) goto L40;
        return BacklogAgeBucket.D1_TO_3D;
    L40:
        if (259200000 <= r4) goto L42;
    L44:
        boolean r9 = false;
    L45:
        if (r9 == false) goto L48;
        return BacklogAgeBucket.D3_TO_7D;
    L48:
        if (WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS <= r4) goto L50;
    L52:
        r0 = false;
    L53:
        if (r0 == false) goto L56;
        return BacklogAgeBucket.D7_TO_30D;
    L56:
        return BacklogAgeBucket.GE_30D;
    L50:
        if (r4 >= 2592000000L) goto L52;
    L42:
        if (r4 >= WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS) goto L44;
        r9 = true;
        goto L45
    L34:
        if (r4 >= 259200000) goto L36;
        r8 = true;
        goto L37
    L26:
        if (r4 >= WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L28;
        r7 = true;
        goto L29
    L18:
        if (r4 >= 21600000) goto L20;
        r6 = true;
        goto L21
    L10:
        if (r4 >= ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) goto L12;
        r2 = true;
        goto L13
    L65:
        return null;
    }

    private final com.obric.memorydata.database.index.b a(BacklogDimension r17, Integer r18, String r19, long r20, List<d> r22) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(BacklogAgeBucket.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16));
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Object r5 = r4.next();
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");
        BacklogAgeBucket r8 = (BacklogAgeBucket) ZeusTransformUtils.preCheckCast(r5, BacklogAgeBucket.class, "com.obric.memorydata.plugin");
        r7.put(r5, 0L);
        goto L4
    L6:
        Map r13 = MapsKt.toMutableMap((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin"));
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        long r14 = 0;
    L8:
        if (r6.hasNext() == false) goto L14;
        BacklogAgeBucket r9 = f9325a.a(r20, ((d) ZeusTransformUtils.preCheckCast(r6.next(), d.class, "com.obric.memorydata.plugin")).e());
        if (r9 == null) goto L11;
        r13.put(r9, Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r13, r9), Number.class, "com.obric.memorydata.plugin")).longValue() + 1));
        goto L8
    L11:
        r14 = r14 + 1;
        goto L8
    L14:
        return new com.obric.memorydata.database.index.b(r17, r18, r19, r0.size(), r13, r14);
    }

    public final List<com.obric.memorydata.database.index.b> a(long r20, List<d> r22, Set<Integer> r23) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r23, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "rows");
        Intrinsics.checkNotNullParameter(r2, "supportedEntityTypes");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        HashSet r4 = new HashSet();
        ArrayList r5 = new ArrayList();
        Iterator r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r7 = r6.next();
        d r8 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin");
        if (r4.add(new Triple(r8.a(), Integer.valueOf(r8.c()), Long.valueOf(r8.b()))) == false) goto L4;
        r5.add(r7);
        goto L4
    L8:
        List<d> r9 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        HashSet r10 = new HashSet();
        ArrayList r11 = new ArrayList();
        Iterator r12 = r1.iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        Object r13 = r12.next();
        d r14 = (d) ZeusTransformUtils.preCheckCast(r13, d.class, "com.obric.memorydata.plugin");
        if (r10.add(CollectionsKt.listOf(new String[]{r14.a(), String.valueOf(r14.c()), String.valueOf(r14.b()), r14.d()})) == false) goto L10;
        r11.add(r13);
        goto L10
    L14:
        List r15 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
        List r16 = CollectionsKt.createListBuilder();
        r16.add(f9325a.a(BacklogDimension.OVERALL, null, null, r20, r9));
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L16:
        if (r19.hasNext() == false) goto L21;
        Object r21 = r19.next();
        Integer r24 = Integer.valueOf(((d) ZeusTransformUtils.preCheckCast(r21, d.class, "com.obric.memorydata.plugin")).c());
        Object r25 = r18.get(r24);
        if (r25 != null) goto L20;
        r25 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r18.put(r24, r25);
    L20:
        ((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin")).add(r21);
        goto L16
    L21:
        Iterator r26 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(SetsKt.plus(r2, (Iterable) ZeusTransformUtils.preCheckCast(r18.keySet(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r26.hasNext() == false) goto L28;
        int r27 = ((Number) ZeusTransformUtils.preCheckCast(r26.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        ab r110 = f9325a;
        BacklogDimension r111 = BacklogDimension.ENTITY_TYPE;
        Integer r112 = Integer.valueOf(r27);
        List<d> r28 = (List) ZeusTransformUtils.preCheckCast(r18.get(Integer.valueOf(r27)), List.class, "com.obric.memorydata.plugin");
        if (r28 != null) goto L27;
        r28 = CollectionsKt.emptyList();
    L27:
        r16.add(r110.a(r111, r112, null, r20, r28));
        goto L23
    L28:
        Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Map r30 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r31 = r29.iterator();
    L30:
        if (r31.hasNext() == false) goto L35;
        Object r32 = r31.next();
        d r33 = (d) ZeusTransformUtils.preCheckCast(r32, d.class, "com.obric.memorydata.plugin");
        Pair r34 = TuplesKt.to(Integer.valueOf(r33.c()), r33.d());
        Object r35 = r30.get(r34);
        if (r35 != null) goto L34;
        r35 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r30.put(r34, r35);
    L34:
        ((List) ZeusTransformUtils.preCheckCast(r35, List.class, "com.obric.memorydata.plugin")).add(r32);
        goto L30
    L35:
        Iterator r36 = ((Map) ZeusTransformUtils.preCheckCast(MapsKt.toSortedMap(r30, (Comparator) ZeusTransformUtils.preCheckCast(new b((Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L37:
        if (r36.hasNext() == false) goto L40;
        Map.Entry r37 = (Map.Entry) ZeusTransformUtils.preCheckCast(r36.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Pair r38 = (Pair) ZeusTransformUtils.preCheckCast(r37.getKey(), Pair.class, "com.obric.memorydata.plugin");
        List<d> r113 = (List) ZeusTransformUtils.preCheckCast(r37.getValue(), List.class, "com.obric.memorydata.plugin");
        ab r39 = f9325a;
        BacklogDimension r40 = BacklogDimension.BUILD_TYPE;
        Integer r41 = (Integer) ZeusTransformUtils.preCheckCast(r38.getFirst(), Integer.class, "com.obric.memorydata.plugin");
        String r42 = (String) ZeusTransformUtils.preCheckCast(r38.getSecond(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r113);
        r16.add(r39.a(r40, r41, r42, r20, r113));
        goto L37
    L40:
        return CollectionsKt.build(r16);
    }
}
