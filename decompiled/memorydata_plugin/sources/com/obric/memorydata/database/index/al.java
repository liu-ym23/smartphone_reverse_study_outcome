package com.obric.memorydata.database.index;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.bh;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\n2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\r2\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0004\u0012\u00020\u00140\rH\u0000\u001a|\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012<\u0010\u0017\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\n0\u0018H\u0002\u001a\u000e\u0010\u001a\u001a\u00020\u001b*\u0004\u0018\u00010\u001cH\u0002¨\u0006\u001d"}, d2 = {"scanCoverageOwner", "", "ownerDbType", "", "ownerStore", "Lcom/obric/memorydata/database/index/OwnerStore;", "policyVersion", "", "pageSize", "supportedEntityTypes", "", "unknownPolicyEntityTypes", "rawReader", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "entityType", "Lcom/obric/memorydata/database/index/CoverageRawReader;", "consumePage", "Lcom/obric/memorydata/database/index/CoverageEntityState;", "", "readCoverageOwnerPageInTransaction", "minRawDbId", "readRawPage", "Lkotlin/Function2;", "Lcom/obric/memorydata/database/SimpleEntityData;", "toCoverageCompletion", "Lcom/obric/memorydata/database/index/CoverageCompletion;", "Lcom/obric/memorydata/database/entity/EntityIndexLifecycleEntity;", "database_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class al {
    public static final long a(final String r12, final av r13, final int r14, final int r15, List<Integer> r16, List<Integer> r17, Function1<? super Integer, j> r18, Function1<? super List<f>, Unit> r19) {
        final List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        final Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "ownerDbType");
        Intrinsics.checkNotNullParameter(r13, "ownerStore");
        Intrinsics.checkNotNullParameter(r3, "supportedEntityTypes");
        Intrinsics.checkNotNullParameter(r4, "unknownPolicyEntityTypes");
        Intrinsics.checkNotNullParameter(r5, "rawReader");
        Intrinsics.checkNotNullParameter(r10, "consumePage");
        if ((!r13.a().inTransaction()) == false) goto L7;
        return ((Number) ZeusTransformUtils.preCheckCast(r13.a().runInTransaction(new $$Lambda$al$d6fzPG21rSv7qAzh08L1NFc9bzY(r3, r4, r5, r12, r13, r14, r15, r10)), Number.class, "com.obric.memorydata.plugin")).longValue();
    L7:
        throw new IllegalStateException("coverage owner scan owns its transaction".toString());
    }

    private static final CoverageCompletion a(bh r2) {
        if (r2 == null) goto L4;
        Integer r3 = Integer.valueOf(r2.m());
    L6:
        if (r3 == null) goto L12;
        if (r3.intValue() != 2) goto L12;
        return CoverageCompletion.COMPLETE;
    L12:
        if (r3 == null) goto L18;
        if (r3.intValue() != 1) goto L18;
        return CoverageCompletion.INCOMPLETE;
    L18:
        return CoverageCompletion.UNKNOWN;
    L4:
        r3 = null;
        goto L6
    }

    private static final Long a(List r17, List r18, Function1 r19, String r20, av r21, int r22, int r23, Function1 r24) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Function1 r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        long r6 = 0;
        if (r1.hasNext() == false) goto L9;
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r1.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        j r16 = (j) ZeusTransformUtils.preCheckCast(r3.invoke(Integer.valueOf(r5)), j.class, "com.obric.memorydata.plugin");
        long r13 = 0;
    L6:
        List<f> r7 = a(r20, r21, r5, r22, r23, r13, r16.a());
        r4.invoke(r7);
        if (r7.size() < r23) goto L3;
        r13 = ((f) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r7), f.class, "com.obric.memorydata.plugin")).a();
        goto L6
    L9:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r8.hasNext() == false) goto L14;
        r6 = r6 + ((Number) ZeusTransformUtils.preCheckCast(((j) ZeusTransformUtils.preCheckCast(r3.invoke(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.memorydata.plugin")).intValue())), j.class, "com.obric.memorydata.plugin")).b().invoke(), Number.class, "com.obric.memorydata.plugin")).longValue();
        goto L11
    L14:
        return Long.valueOf(r6);
    }

    private static final List<f> a(String r18, av r19, int r20, int r21, int r22, long r23, Function2<? super Integer, ? super Long, ? extends List<com.obric.memorydata.database.b>> r25) {
        Function2 r0 = (Function2) ZeusTransformUtils.wrapperContextForParams(r25, Function2.class, "com.obric.memorydata.plugin");
        if (r19.a().inTransaction() == false) goto L49;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0.invoke(Integer.valueOf(r22), Long.valueOf(r23)), List.class, "com.obric.memorydata.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r3.add(Long.valueOf(((com.obric.memorydata.database.b) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.database.b.class, "com.obric.memorydata.plugin")).a()));
        goto L6
    L8:
        List<Long> r5 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == false) goto L11;
        Map r11 = MapsKt.emptyMap();
    L17:
        if (r5.isEmpty() == false) goto L19;
        Set r6 = SetsKt.emptySet();
    L20:
        Set r12 = r6;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r7.iterator();
    L22:
        if (r14.hasNext() == false) goto L47;
        com.obric.memorydata.database.b r8 = (com.obric.memorydata.database.b) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.memorydata.database.b.class, "com.obric.memorydata.plugin");
        bh r9 = (bh) ZeusTransformUtils.preCheckCast(r11.get(Long.valueOf(r8.a())), bh.class, "com.obric.memorydata.plugin");
        boolean r10 = r12.contains(Long.valueOf(r8.a()));
        if (r9 == null) goto L32;
        if (r9.h() == r21) goto L28;
    L30:
        boolean r15 = false;
    L33:
        long r16 = r8.a();
        if (r9 != null) goto L38;
        if (r10 == false) goto L37;
        CoverageCompletion r17 = CoverageCompletion.INCOMPLETE;
    L41:
        CoverageCompletion r110 = r17;
        if (r9 != null) goto L44;
        boolean r111 = true;
    L45:
        r13.add(new f(r18, r16, r20, r110, r10, r15, r111));
        goto L22
    L44:
        r111 = false;
        goto L45
    L37:
        r17 = CoverageCompletion.COMPLETE;
        goto L41
    L38:
        if (r15 == true) goto L40;
        r17 = CoverageCompletion.UNKNOWN;
        goto L41
    L40:
        r17 = a(r9);
        goto L41
    L28:
        if (r9.i() != r8.b()) goto L30;
    L32:
        r15 = true;
        goto L33
    L47:
        return (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
    L19:
        r6 = (Set) ZeusTransformUtils.preCheckCast(CollectionsKt.toHashSet((Iterable) ZeusTransformUtils.preCheckCast(r19.b().queryPendingRawDbIds(r5, r20), Iterable.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin");
        goto L20
    L11:
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r19.c().queryByRawDbIds(r5, r20), Iterable.class, "com.obric.memorydata.plugin");
        Map r26 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r24, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r27 = r24.iterator();
    L13:
        if (r27.hasNext() == false) goto L15;
        Object r28 = r27.next();
        r26.put(Long.valueOf(((bh) ZeusTransformUtils.preCheckCast(r28, bh.class, "com.obric.memorydata.plugin")).a()), r28);
        goto L13
    L15:
        r11 = r26;
        goto L17
    L49:
        throw new IllegalStateException("coverage page must belong to its owner snapshot".toString());
    }

    public static /* synthetic */ Long lambda$d6fzPG21rSv7qAzh08L1NFc9bzY(List r0, List r1, Function1 r2, String r3, av r4, int r5, int r6, Function1 r7) {
        return a(r0, r1, r2, r3, r4, r5, r6, r7);
    }
}
