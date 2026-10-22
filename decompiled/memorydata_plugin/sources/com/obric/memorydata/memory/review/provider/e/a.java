package com.obric.memorydata.memory.review.provider.e;

import com.obric.capabilitykit.common.Ext;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.es;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.review.model.MemoryReviewFeedbackState;
import com.obric.memorydata.memory.review.model.MemoryReviewModule;
import com.obric.memorydata.memory.review.model.b;
import com.obric.memorydata.memory.review.model.d;
import com.obric.memorydata.memory.review.model.f;
import com.obric.memorydata.memory.review.model.g;
import com.obric.memorydata.memory.review.model.h;
import com.obric.memorydata.memory.review.provider.ae;
import com.obric.memorydata.memory.review.provider.ah;
import com.obric.memorydata.memory.review.provider.ak;
import com.obric.memorydata.memory.review.provider.al;
import com.obric.memorydata.memory.review.provider.ay;
import com.obric.memorydata.memory.review.provider.az;
import com.obric.memorydata.memory.review.provider.n;
import com.obric.memorydata.memory.review.provider.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/screenmemory/ScreenMemoryReviewProvider;", "Lcom/obric/memorydata/memory/review/provider/BaseMemoryReviewDataProvider;", "dao", "Lcom/obric/memorydata/database/dao/EpisodicMemoryDao;", "feedbackStore", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;", "rawObservationStore", "Lcom/obric/memorydata/memory/review/provider/MemoryReviewRawObservationStore;", "<init>", "(Lcom/obric/memorydata/database/dao/EpisodicMemoryDao;Lcom/obric/memorydata/memory/review/provider/MemoryReviewFeedbackStore;Lcom/obric/memorydata/memory/review/provider/MemoryReviewRawObservationStore;)V", "getPage", "Lcom/obric/memorydata/memory/review/model/MemoryReviewPage;", Ext.KEY_REQUEST, "Lcom/obric/memorydata/memory/review/model/MemoryReviewPageRequest;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0514a f10451a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EpisodicMemoryDao f10452b;
    private final ah c;
    private final al d;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.review.provider.e.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/screenmemory/ScreenMemoryReviewProvider$Companion;", "", "<init>", "()V", "FIRST_CURSOR_ENTITY_ID", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0514a {
        private C0514a() {
        }

        public /* synthetic */ C0514a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10451a = new C0514a(null);
    }

    public a() {
        this(null, null, null, 7, null);
    }

    public a(EpisodicMemoryDao r3, ah r4, al r5) {
        EpisodicMemoryDao r6 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r3, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
        ah r7 = (ah) ZeusTransformUtils.wrapperContextForParams(r4, ah.class, "com.obric.memorydata.plugin");
        al r8 = (al) ZeusTransformUtils.wrapperContextForParams(r5, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "dao");
        Intrinsics.checkNotNullParameter(r7, "feedbackStore");
        Intrinsics.checkNotNullParameter(r8, "rawObservationStore");
        super(MemoryReviewModule.SCREEN_MEMORY, r7);
        this.f10452b = r6;
        this.c = r7;
        this.d = r8;
    }

    public /* synthetic */ a(EpisodicMemoryDao r10, ah r11, al r12, int r13, DefaultConstructorMarker r14) {
        EpisodicMemoryDao r15 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r10, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
        ah r16 = (ah) ZeusTransformUtils.wrapperContextForParams(r11, ah.class, "com.obric.memorydata.plugin");
        al r17 = (al) ZeusTransformUtils.wrapperContextForParams(r12, al.class, "com.obric.memorydata.plugin");
        if ((r13 & 1) == 0) goto L6;
        r15 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao();
    L6:
        if ((r13 & 2) == 0) goto L9;
        r16 = (ah) ZeusTransformUtils.preCheckCast(new ae(null, null, null, null, null, 31, null), ah.class, "com.obric.memorydata.plugin");
    L9:
        if ((r13 & 4) == 0) goto L11;
        r17 = (al) ZeusTransformUtils.preCheckCast(new ak(null, 1, null), al.class, "com.obric.memorydata.plugin");
    L11:
        this(r15, r16, r17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.memorydata.memory.review.provider.n, com.obric.memorydata.memory.review.provider.z
    public f a(g r28) {
        Intrinsics.checkNotNullParameter(r28, Ext.KEY_REQUEST);
        int r1 = r28.e();
        b r3 = com.obric.memorydata.memory.review.model.a.f10381a.a(r28.b());
        EpisodicMemoryDao r4 = this.f10452b;
        long r5 = r28.c();
        long r7 = r28.d();
        if (r3 == null) goto L5;
        long r9 = r3.b();
    L6:
        if (r3 == null) goto L9;
        String r6 = r3.c();
        if (r6 == null) goto L9;
    L10:
        List<EpisodicMemoryEntity> r8 = r4.queryScreenMemoryReviewPage(r5, r7, r9, r6, r1 + 1);
        List r10 = CollectionsKt.take((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), r1);
        ah r11 = this.c;
        MemoryReviewModule r12 = a();
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r13.iterator();
    L12:
        if (r15.hasNext() == false) goto L14;
        r14.add(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r15.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L12
    L14:
        Map<String, d> r16 = r11.a(r12, (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"));
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r17, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L16:
        if (r19.hasNext() == false) goto L18;
        EpisodicMemoryEntity r110 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r19.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        Pair r111 = TuplesKt.to(r110.getEntityId(), az.f10433a.a(r110.getSourceRawRefIds()));
        r18.put(r111.getFirst(), r111.getSecond());
        goto L16
    L18:
        Map<String, ay> r20 = this.d.a(r18);
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r112 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r22 = r21.iterator();
    L20:
        if (r22.hasNext() == false) goto L22;
        r112.add(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r22.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L20
    L22:
        List<String> r23 = (List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.memorydata.plugin");
        if (r23.isEmpty() == false) goto L25;
        Map r24 = MapsKt.emptyMap();
    L30:
        Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r25, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r25.iterator();
    L32:
        if (r26.hasNext() == false) goto L51;
        EpisodicMemoryEntity r114 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r26.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        ay r115 = (ay) ZeusTransformUtils.preCheckCast(r20.get(r114.getEntityId()), ay.class, "com.obric.memorydata.plugin");
        w r116 = w.f10473a;
        es r117 = (es) ZeusTransformUtils.preCheckCast(r24.get(r114.getEntityId()), es.class, "com.obric.memorydata.plugin");
        if (r115 == null) goto L36;
        List<Long> r118 = r115.a();
    L37:
        if (r118 != null) goto L39;
        r118 = CollectionsKt.emptyList();
    L39:
        if (r115 == null) goto L41;
        List<RawObservationEntity> r119 = r115.b();
    L42:
        if (r119 != null) goto L44;
        List<RawObservationEntity> r120 = CollectionsKt.emptyList();
    L45:
        d r0 = (d) ZeusTransformUtils.preCheckCast(r16.get(r114.getEntityId()), d.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L49;
        MemoryReviewFeedbackState r2 = r0.a();
        if (r2 == null) goto L49;
    L50:
        List<Long> r121 = r118;
        r113.add(r116.a(r114, r117, r121, r120, r2));
    L49:
        r2 = MemoryReviewFeedbackState.PENDING;
        goto L50
    L44:
        r120 = r119;
        goto L45
    L41:
        r119 = null;
        goto L42
    L36:
        r118 = null;
        goto L37
    L51:
        List<h> r122 = (List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.memorydata.plugin");
        if (r8.size() <= r1) goto L54;
        boolean r27 = true;
    L55:
        boolean r29 = r27;
        EpisodicMemoryEntity r30 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r10), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        f.a r123 = f.f10389a;
        MemoryReviewModule r124 = a();
        long r125 = r28.c();
        long r31 = r28.d();
        if (r29 == false) goto L59;
        if (r30 == null) goto L59;
        String r126 = com.obric.memorydata.memory.review.model.a.f10381a.a(r28.d(), r30.getModifyTime(), r30.getEntityId());
    L61:
        return r123.a(r124, r125, r31, r122, r16, r126, r29);
    L59:
        r126 = null;
        goto L61
    L54:
        r27 = false;
        goto L55
    L25:
        Iterable r32 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveEpisodicRelevantDataDao().queryByEpisodicIds(r23), Iterable.class, "com.obric.memorydata.plugin");
        Map r33 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r32, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r34 = r32.iterator();
    L27:
        if (r34.hasNext() == false) goto L29;
        Object r127 = r34.next();
        r33.put(((es) ZeusTransformUtils.preCheckCast(r127, es.class, "com.obric.memorydata.plugin")).b(), r127);
        goto L27
    L29:
        r24 = r33;
    L9:
        r6 = "\uffff";
        goto L10
    L5:
        r9 = Long.MAX_VALUE;
        goto L6
    }
}
