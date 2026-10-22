package com.obric.memorydata.memory.review.provider;

import com.bytedance.crash.AppDataCenter;
import com.obric.memorydata.database.dao.RawObservationDao;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0007H\u0016J.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u00072\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0007H\u0016J\u0016\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J4\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u00020\t0\u0007\"\u0004\b\u0000\u0010\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryReviewRawObservationRepository;", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewRawObservationStore;", "rawObservationDao", "Lcom/obric/memorydata/database/dao/RawObservationDao;", "<init>", "(Lcom/obric/memorydata/database/dao/RawObservationDao;)V", "queryScreenEvidenceMap", "", "", "Lcom/obric/memorydata/memory/review/provider/RawObservationEvidence;", "rawObservationIdsByEntityId", "", "", "querySnapshotEvidenceMap", "rawObservationIdsBySnapshotId", "queryEvidence", "rawObservationIds", "queryEvidenceMap", "K", "rawObservationIdsByOwner", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ak implements al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RawObservationDao f10416a;

    /* JADX WARN: Multi-variable type inference failed */
    public ak() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ak(RawObservationDao r3) {
        RawObservationDao r4 = (RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r3, RawObservationDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "rawObservationDao");
        this.f10416a = r4;
    }

    public /* synthetic */ ak(RawObservationDao r2, int r3, DefaultConstructorMarker r4) {
        RawObservationDao r5 = (RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r2, RawObservationDao.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao();
    L5:
        this(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <K> Map<K, ay> c(Map<K, ? extends List<Long>> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r13.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r14.hasNext() == false) goto L15;
        Object r2 = r14.next();
        Object r4 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r3.iterator();
    L7:
        if (r6.hasNext() == false) goto L14;
        Object r7 = r6.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L11;
        boolean r8 = true;
    L12:
        if (r8 == false) goto L7;
        r5.add(r7);
        goto L7
    L11:
        r8 = false;
        goto L12
    L14:
        r0.put(r4, CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")));
        goto L4
    L15:
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator r1 = r0.entrySet().iterator();
    L17:
        if (r1.hasNext() == false) goto L21;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9.getValue(), List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L17;
        r15.put(r9.getKey(), r9.getValue());
        goto L17
    L21:
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(r15, Map.class, "com.obric.memorydata.plugin");
        if (r16.isEmpty() == true) goto L24;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(this.f10416a.queryByIds(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.flatten((Iterable) ZeusTransformUtils.preCheckCast(r16.values(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"))), Iterable.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r17 = r11.iterator();
    L27:
        if (r17.hasNext() == false) goto L29;
        Object r18 = r17.next();
        r10.put(Long.valueOf(((RawObservationEntity) ZeusTransformUtils.preCheckCast(r18, RawObservationEntity.class, "com.obric.memorydata.plugin")).getId()), r18);
        goto L27
    L29:
        AppDataCenter r19 = (Map<K, ay>) ((Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r16.size())), Map.class, "com.obric.memorydata.plugin"));
        Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r16.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L31:
        if (r110.hasNext() == false) goto L39;
        Object r20 = r110.next();
        Object r21 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r20, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        List r22 = (List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r20, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin");
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.memorydata.plugin");
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r25 = r23.iterator();
    L34:
        if (r25.hasNext() == false) goto L38;
        RawObservationEntity r26 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r10.get(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r25.next(), Number.class, "com.obric.memorydata.plugin")).longValue())), RawObservationEntity.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L34;
        r24.add(r26);
        goto L34
    L38:
        r19.put(r21, new ay(r22, (List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.memorydata.plugin")));
        goto L31
    L39:
        return r19;
    L24:
        return MapsKt.emptyMap();
    }

    @Override // com.obric.memorydata.memory.review.provider.al
    public ay a(List<Long> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "rawObservationIds");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Object r2 = r11.next();
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        r3 = false;
        goto L9
    L11:
        List<Long> r12 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r12.isEmpty() == true) goto L14;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(this.f10416a.queryByIds(r12), Iterable.class, "com.obric.memorydata.plugin");
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r7, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r13 = r7.iterator();
    L17:
        if (r13.hasNext() == false) goto L19;
        Object r4 = r13.next();
        r1.put(Long.valueOf(((RawObservationEntity) ZeusTransformUtils.preCheckCast(r4, RawObservationEntity.class, "com.obric.memorydata.plugin")).getId()), r4);
        goto L17
    L19:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L21:
        if (r15.hasNext() == false) goto L26;
        RawObservationEntity r6 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r1.get(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r15.next(), Number.class, "com.obric.memorydata.plugin")).longValue())), RawObservationEntity.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L21;
        r5.add(r6);
        goto L21
    L26:
        return new ay(r12, (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"));
    L14:
        return new ay(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    @Override // com.obric.memorydata.memory.review.provider.al
    public Map<String, ay> a(Map<String, ? extends List<Long>> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "rawObservationIdsByEntityId");
        return c(r4);
    }

    @Override // com.obric.memorydata.memory.review.provider.al
    public Map<Long, ay> b(Map<Long, ? extends List<Long>> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "rawObservationIdsBySnapshotId");
        return c(r4);
    }
}
