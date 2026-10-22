package com.obric.memorydata.memory.review.provider;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.dh;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H&J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\b\u001a\u00020\tH&J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H&J(\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0003H&J*\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0003H&J\u0016\u0010\u001e\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H&J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0007H&¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportLocalDataSource;", "", "insert", "", "entity", "Lcom/obric/memorydata/database/entity/MemoryTraceReportEntity;", "markTriggeredByLogId", "", "logId", "", "triggerTime", "queryTriggeredPending", "", "pendingBeforeTime", "retryBeforeTime", "limit", "queryUnfinishedByLogId", "claimForUpload", "", OaidModel.KEY_ID, "expectedStatus", "expectedLastReportTime", "claimTime", "updateMergedTriggered", "reportData", "reportStatus", "lastReportTime", "updateReportResult", "lastError", "deleteById", "deleteByIds", "ids", "deleteOversizedReportData", "maxReportDataBytes", "deleteOversizedReportDataByLogId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ao {
    int a(int r1);

    int a(long r1);

    int a(long r1, String r3, String r4, long r5);

    int a(String r1, int r2);

    int a(List<Long> r1);

    List<dh> a(long r1, long r3, int r5);

    List<dh> a(String r1);

    boolean a(long r1, String r3, long r4, long r6);

    int b(long r1, String r3, String r4, long r5);

    long insert(dh r1);
}
