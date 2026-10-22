package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0096\u0001J\u0019\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0096\u0001J!\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\bH\u0096\u0001J\t\u0010\u001e\u001a\u00020\u001dH\u0096\u0001J\u0011\u0010\u001f\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\bH\u0096\u0001J\u0011\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\bH\u0096\u0001J\u0011\u0010\"\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0096\u0001J\u0011\u0010#\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0096\u0001J\u0011\u0010$\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0096\u0001¨\u0006%"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/MemoryStorageBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IMemoryStorageBridgeAPI;", "<init>", "()V", "batchRebuildEntityIndex", "", "entityIds", "", "", "commitConsumerOutput", "payload", "commitSemanticBatch", "deleteEpisodicEntity", "entityId", "deleteSemanticEntity", "insertEpisodicEntity", "insertSemanticEntity", "isMemoryTraceReportEnabled", "queryEpisodicByEntityId", "querySemanticByKeyPhrase", "keyPhrase", "limit", "", "rebuildEntityIndex", "reportMemoryTraceOps", "logId", AILabCheckPermissionTask.KEY_SOURCE, "memoryOpsJson", "showMemoryIsland", "", "showScreenshotEffect", "supersedeMemoryProcessSources", "triggerGlobalIndex", InfoRequestQPSOptTraceLogger.REASON, "updateEpisodicEntity", "updateSemanticEntity", "upsertRuleEpisodicMemory", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryStorageBridgeAPI implements IMemoryStorageBridgeAPI {
    public static final MemoryStorageBridgeAPI INSTANCE = null;
    private final /* synthetic */ IMemoryStorageBridgeAPI $$delegate_0;

    static {
        INSTANCE = new MemoryStorageBridgeAPI();
    }

    private MemoryStorageBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IMemoryStorageBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IMemoryStorageBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IMemoryStorageBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public boolean batchRebuildEntityIndex(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "entityIds");
        return this.$$delegate_0.batchRebuildEntityIndex(r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String commitConsumerOutput(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return this.$$delegate_0.commitConsumerOutput(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String commitSemanticBatch(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return this.$$delegate_0.commitSemanticBatch(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public boolean deleteEpisodicEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        return this.$$delegate_0.deleteEpisodicEntity(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public boolean deleteSemanticEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        return this.$$delegate_0.deleteSemanticEntity(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String insertEpisodicEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return this.$$delegate_0.insertEpisodicEntity(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String insertSemanticEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return this.$$delegate_0.insertSemanticEntity(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public boolean isMemoryTraceReportEnabled() {
        return this.$$delegate_0.isMemoryTraceReportEnabled();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String queryEpisodicByEntityId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        return this.$$delegate_0.queryEpisodicByEntityId(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String querySemanticByKeyPhrase(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "keyPhrase");
        return this.$$delegate_0.querySemanticByKeyPhrase(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public boolean rebuildEntityIndex(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        return this.$$delegate_0.rebuildEntityIndex(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public boolean reportMemoryTraceOps(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "logId");
        Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r4, "memoryOpsJson");
        return this.$$delegate_0.reportMemoryTraceOps(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public void showMemoryIsland(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        this.$$delegate_0.showMemoryIsland(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public void showScreenshotEffect() {
        this.$$delegate_0.showScreenshotEffect();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public int supersedeMemoryProcessSources(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return this.$$delegate_0.supersedeMemoryProcessSources(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public void triggerGlobalIndex(String r2) {
        Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
        this.$$delegate_0.triggerGlobalIndex(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String updateEpisodicEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return this.$$delegate_0.updateEpisodicEntity(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String updateSemanticEntity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return this.$$delegate_0.updateSemanticEntity(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IMemoryStorageBridgeAPI
    public String upsertRuleEpisodicMemory(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return this.$$delegate_0.upsertRuleEpisodicMemory(r2);
    }
}
