package com.obric.memorydata.middleware.api.bridge;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0096\u0001J!\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0096\u0001J9\u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0001J9\u0010\u001a\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0007H\u0096\u0001J!\u0010 \u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0096\u0001J\u0019\u0010\"\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0096\u0001J)\u0010'\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u000bH\u0096\u0001J;\u0010-\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0096\u0001¨\u00060"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/AuditoryBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IAuditoryBridgeAPI;", "<init>", "()V", "cleanupUploadBundles", "", "olderThanMs", "", "clearAccountData", "", "accountScope", "", "commitL0Result", "taskId", "resultJson", "countTasks", "deleteUploadBundle", "finalizePendingTaskTelemetry", "nowMs", "finalizeTaskTelemetry", "finishTask", "expectedStatus", "terminalStatus", "errorCode", "terminalAt", "getCachedHotwords", "markTaskRetry", "retryCount", "updatedAt", "persistTaskAndCursor", "taskJson", "expectedLastFileEndMs", "prepareUploadWav", "manifestJson", "queryHotwords", "limit", "queryRecordData", "startTimestampSeconds", "endTimestampSeconds", "queryRecordDataPage", TypedValues.CycleType.S_WAVE_OFFSET, "recordTaskRequestEvent", "eventJson", "removeScheduledTask", "taskRequestId", "transitionTask", "targetStatus", "tosKey", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AuditoryBridgeAPI implements IAuditoryBridgeAPI {
    public static final AuditoryBridgeAPI INSTANCE = null;
    private final /* synthetic */ IAuditoryBridgeAPI $$delegate_0;

    static {
        INSTANCE = new AuditoryBridgeAPI();
    }

    private AuditoryBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IAuditoryBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IAuditoryBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IAuditoryBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public int cleanupUploadBundles(long r1) {
        return this.$$delegate_0.cleanupUploadBundles(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean clearAccountData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "accountScope");
        return this.$$delegate_0.clearAccountData(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String commitL0Result(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "accountScope");
        Intrinsics.checkNotNullParameter(r4, "resultJson");
        return this.$$delegate_0.commitL0Result(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public int countTasks(String r2) {
        Intrinsics.checkNotNullParameter(r2, "accountScope");
        return this.$$delegate_0.countTasks(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean deleteUploadBundle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        return this.$$delegate_0.deleteUploadBundle(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String finalizePendingTaskTelemetry(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "accountScope");
        return this.$$delegate_0.finalizePendingTaskTelemetry(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String finalizeTaskTelemetry(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "accountScope");
        return this.$$delegate_0.finalizeTaskTelemetry(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean finishTask(String r10, String r11, String r12, String r13, String r14, long r15) {
        Intrinsics.checkNotNullParameter(r10, "taskId");
        Intrinsics.checkNotNullParameter(r11, "accountScope");
        Intrinsics.checkNotNullParameter(r12, "expectedStatus");
        Intrinsics.checkNotNullParameter(r13, "terminalStatus");
        Intrinsics.checkNotNullParameter(r14, "errorCode");
        return this.$$delegate_0.finishTask(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String getCachedHotwords(String r2) {
        Intrinsics.checkNotNullParameter(r2, "accountScope");
        return this.$$delegate_0.getCachedHotwords(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean markTaskRetry(String r10, String r11, String r12, int r13, String r14, long r15) {
        Intrinsics.checkNotNullParameter(r10, "taskId");
        Intrinsics.checkNotNullParameter(r11, "accountScope");
        Intrinsics.checkNotNullParameter(r12, "expectedStatus");
        Intrinsics.checkNotNullParameter(r14, "errorCode");
        return this.$$delegate_0.markTaskRetry(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean persistTaskAndCursor(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "taskJson");
        return this.$$delegate_0.persistTaskAndCursor(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String prepareUploadWav(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        Intrinsics.checkNotNullParameter(r3, "accountScope");
        Intrinsics.checkNotNullParameter(r4, "manifestJson");
        return this.$$delegate_0.prepareUploadWav(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String queryHotwords(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "accountScope");
        return this.$$delegate_0.queryHotwords(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String queryRecordData(long r1, long r3) {
        return this.$$delegate_0.queryRecordData(r1, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public String queryRecordDataPage(long r8, long r10, int r12, int r13) {
        return this.$$delegate_0.queryRecordDataPage(r8, r10, r12, r13);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean recordTaskRequestEvent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventJson");
        return this.$$delegate_0.recordTaskRequestEvent(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean removeScheduledTask(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequestId");
        return this.$$delegate_0.removeScheduledTask(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAuditoryBridgeAPI
    public boolean transitionTask(String r10, String r11, String r12, String r13, String r14, long r15) {
        Intrinsics.checkNotNullParameter(r10, "taskId");
        Intrinsics.checkNotNullParameter(r11, "accountScope");
        Intrinsics.checkNotNullParameter(r12, "expectedStatus");
        Intrinsics.checkNotNullParameter(r13, "targetStatus");
        return this.$$delegate_0.transitionTask(r10, r11, r12, r13, r14, r15);
    }
}
