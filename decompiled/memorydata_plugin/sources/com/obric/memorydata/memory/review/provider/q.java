package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.database.dao.AuditoryAsrTaskDao;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.dao.RawObservationDao;
import com.obric.memorydata.database.entity.AuditoryAsrTaskEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/DaoAudioMemoryTranscriptDataSource;", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptDataSource;", "episodicMemoryDao", "Lcom/obric/memorydata/database/dao/EpisodicMemoryDao;", "rawObservationDao", "Lcom/obric/memorydata/database/dao/RawObservationDao;", "auditoryAsrTaskDao", "Lcom/obric/memorydata/database/dao/AuditoryAsrTaskDao;", "<init>", "(Lcom/obric/memorydata/database/dao/EpisodicMemoryDao;Lcom/obric/memorydata/database/dao/RawObservationDao;Lcom/obric/memorydata/database/dao/AuditoryAsrTaskDao;)V", "queryAudioMemory", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "recordId", "", "queryRawObservations", "", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "rawObservationIds", "", "queryAuditoryAudioUrl", "taskId", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f10466a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EpisodicMemoryDao f10467b;
    private final RawObservationDao c;
    private final AuditoryAsrTaskDao d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/DaoAudioMemoryTranscriptDataSource$Companion;", "", "<init>", "()V", "RAW_OBSERVATION_QUERY_BATCH_SIZE", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10466a = new a(null);
    }

    public q() {
        this(null, null, null, 7, null);
    }

    public q(EpisodicMemoryDao r3, RawObservationDao r4, AuditoryAsrTaskDao r5) {
        EpisodicMemoryDao r6 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r3, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
        RawObservationDao r7 = (RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r4, RawObservationDao.class, "com.obric.memorydata.plugin");
        AuditoryAsrTaskDao r8 = (AuditoryAsrTaskDao) ZeusTransformUtils.wrapperContextForParams(r5, AuditoryAsrTaskDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "episodicMemoryDao");
        Intrinsics.checkNotNullParameter(r7, "rawObservationDao");
        Intrinsics.checkNotNullParameter(r8, "auditoryAsrTaskDao");
        this.f10467b = r6;
        this.c = r7;
        this.d = r8;
    }

    public /* synthetic */ q(EpisodicMemoryDao r2, RawObservationDao r3, AuditoryAsrTaskDao r4, int r5, DefaultConstructorMarker r6) {
        EpisodicMemoryDao r7 = (EpisodicMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryDao.class, "com.obric.memorydata.plugin");
        RawObservationDao r8 = (RawObservationDao) ZeusTransformUtils.wrapperContextForParams(r3, RawObservationDao.class, "com.obric.memorydata.plugin");
        AuditoryAsrTaskDao r9 = (AuditoryAsrTaskDao) ZeusTransformUtils.wrapperContextForParams(r4, AuditoryAsrTaskDao.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao();
    L9:
        if ((r5 & 4) == 0) goto L11;
        r9 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryAsrTaskDao();
    L11:
        this(r7, r8, r9);
    }

    @Override // com.obric.memorydata.memory.review.provider.f
    public EpisodicMemoryEntity a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "recordId");
        EpisodicMemoryEntity r2 = this.f10467b.queryByEntityId(r3);
        if (r2 == null) goto L11;
        if (r2.getProductType() != 1006) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return r2;
    L7:
        r0 = false;
    L11:
        return null;
    }

    @Override // com.obric.memorydata.memory.review.provider.f
    public List<RawObservationEntity> a(List<Long> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "rawObservationIds");
        if (r6.isEmpty() == true) goto L5;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"), 300), Iterable.class, "com.obric.memorydata.plugin");
        RawObservationDao r4 = this.c;
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L11;
        CollectionsKt.addAll(r0, (Iterable) ZeusTransformUtils.preCheckCast(r4.queryByIds((List) ZeusTransformUtils.preCheckCast(r8.next(), List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L8
    L11:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.memory.review.provider.f
    public String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        AuditoryAsrTaskEntity r1 = this.d.queryByTaskId(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getTosKey();
    }
}
