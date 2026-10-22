package com.obric.memorydata.middleware.api.bridge;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001c\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J(\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0005H&J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H&J:\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u0005H&J8\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0005H&J8\u0010 \u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0005H&J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u0003H&J \u0010%\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0005H&J\u0018\u0010'\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0005H&J \u0010(\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003H&J\u0010\u0010*\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0003H&J\u0010\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u0003H&J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0003H&¨\u0006."}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IAuditoryBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "queryRecordData", "", "startTimestampSeconds", "", "endTimestampSeconds", "queryRecordDataPage", TypedValues.CycleType.S_WAVE_OFFSET, "", "limit", "queryHotwords", "accountScope", "getCachedHotwords", "prepareUploadWav", "taskId", "manifestJson", "deleteUploadBundle", "", "cleanupUploadBundles", "olderThanMs", "persistTaskAndCursor", "taskJson", "expectedLastFileEndMs", "transitionTask", "expectedStatus", "targetStatus", "tosKey", "updatedAt", "markTaskRetry", "retryCount", "errorCode", "finishTask", "terminalStatus", "terminalAt", "recordTaskRequestEvent", "eventJson", "finalizeTaskTelemetry", "nowMs", "finalizePendingTaskTelemetry", "commitL0Result", "resultJson", "countTasks", "removeScheduledTask", "taskRequestId", "clearAccountData", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAuditoryBridgeAPI extends IService {
    int cleanupUploadBundles(long r1);

    boolean clearAccountData(String r1);

    String commitL0Result(String r1, String r2, String r3);

    int countTasks(String r1);

    boolean deleteUploadBundle(String r1);

    String finalizePendingTaskTelemetry(String r1, long r2);

    String finalizeTaskTelemetry(String r1, String r2, long r3);

    boolean finishTask(String r1, String r2, String r3, String r4, String r5, long r6);

    String getCachedHotwords(String r1);

    boolean markTaskRetry(String r1, String r2, String r3, int r4, String r5, long r6);

    boolean persistTaskAndCursor(String r1, long r2);

    String prepareUploadWav(String r1, String r2, String r3);

    String queryHotwords(String r1, int r2);

    String queryRecordData(long r1, long r3);

    String queryRecordDataPage(long r1, long r3, int r5, int r6);

    boolean recordTaskRequestEvent(String r1);

    boolean removeScheduledTask(String r1);

    boolean transitionTask(String r1, String r2, String r3, String r4, String r5, long r6);
}
