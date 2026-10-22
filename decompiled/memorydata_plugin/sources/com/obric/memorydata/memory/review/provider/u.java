package com.obric.memorydata.memory.review.provider;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.dao.MemoryTraceReportDao;
import com.obric.memorydata.database.entity.dh;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J(\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J*\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0016\u0010\"\u001a\u00020\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bH\u0016J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/DaoMemoryTraceReportLocalDataSource;", "Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportLocalDataSource;", "dao", "Lcom/obric/memorydata/database/dao/MemoryTraceReportDao;", "<init>", "(Lcom/obric/memorydata/database/dao/MemoryTraceReportDao;)V", "insert", "", "entity", "Lcom/obric/memorydata/database/entity/MemoryTraceReportEntity;", "markTriggeredByLogId", "", "logId", "", "triggerTime", "queryTriggeredPending", "", "pendingBeforeTime", "retryBeforeTime", "limit", "queryUnfinishedByLogId", "claimForUpload", "", OaidModel.KEY_ID, "expectedStatus", "expectedLastReportTime", "claimTime", "updateMergedTriggered", "reportData", "reportStatus", "lastReportTime", "updateReportResult", "lastError", "deleteById", "deleteByIds", "ids", "deleteOversizedReportData", "maxReportDataBytes", "deleteOversizedReportDataByLogId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class u implements ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MemoryTraceReportDao f10471a;

    /* JADX WARN: Multi-variable type inference failed */
    public u() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public u(MemoryTraceReportDao r3) {
        MemoryTraceReportDao r4 = (MemoryTraceReportDao) ZeusTransformUtils.wrapperContextForParams(r3, MemoryTraceReportDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "dao");
        this.f10471a = r4;
    }

    public /* synthetic */ u(MemoryTraceReportDao r2, int r3, DefaultConstructorMarker r4) {
        MemoryTraceReportDao r5 = (MemoryTraceReportDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryTraceReportDao.class, "com.obric.memorydata.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMemoryTraceReportDao();
    L5:
        this(r5);
    }

    @Override // com.obric.memorydata.memory.review.provider.ao
    public int a(int r1) {
        return this.f10471a.deleteOversizedReportData(r1);
    }

    @Override // com.obric.memorydata.memory.review.provider.ao
    public int a(long r1) {
        return this.f10471a.deleteById(r1);
    }

    @Override // com.obric.memorydata.memory.review.provider.ao
    public int a(long r9, String r11, String r12, long r13) {
        Intrinsics.checkNotNullParameter(r11, "reportData");
        Intrinsics.checkNotNullParameter(r12, "reportStatus");
        return this.f10471a.updateMergedTriggered(r9, r11, r12, r13);
    }

    @Override // com.obric.memorydata.memory.review.provider.ao
    public int a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "logId");
        return this.f10471a.deleteOversizedReportDataByLogId(r2, r3);
    }

    @Override // com.obric.memorydata.memory.review.provider.ao
    public int a(List<Long> r3) {
        List<Long> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "ids");
        if (r4.isEmpty() == false) goto L7;
        return 0;
    L7:
        return this.f10471a.deleteByIds(r4);
    }

    @Override // com.obric.memorydata.memory.review.provider.ao
    public List<dh> a(long r9, long r11, int r13) {
        return this.f10471a.queryTriggeredPending(MemoryTraceReportStatus.SUCCESS.getKey(), MemoryTraceReportStatus.PENDING.getKey(), r9, r11, r13);
    }

    @Override // com.obric.memorydata.memory.review.provider.ao
    public List<dh> a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "logId");
        return this.f10471a.queryUnfinishedByLogId(r3, MemoryTraceReportStatus.SUCCESS.getKey(), MemoryTraceReportStatus.UPLOADING.getKey());
    }

    @Override // com.obric.memorydata.memory.review.provider.ao
    public boolean a(long r11, String r13, long r14, long r16) {
        Intrinsics.checkNotNullParameter(r13, "expectedStatus");
        if (this.f10471a.claimForUpload(r11, r13, r14, MemoryTraceReportStatus.UPLOADING.getKey(), r16) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.memorydata.memory.review.provider.ao
    public int b(long r9, String r11, String r12, long r13) {
        Intrinsics.checkNotNullParameter(r11, "reportStatus");
        return this.f10471a.updateReportResult(r9, r11, r12, r13);
    }

    @Override // com.obric.memorydata.memory.review.provider.ao
    public long insert(dh r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        return this.f10471a.insert(r2);
    }
}
