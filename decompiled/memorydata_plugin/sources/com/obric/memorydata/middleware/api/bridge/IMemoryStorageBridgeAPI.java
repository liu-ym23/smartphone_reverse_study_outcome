package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.news.common.service.manager.IService;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u0016\u0010\u0012\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H&J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u001aH&J\b\u0010\u001e\u001a\u00020\u000bH&J \u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H&¨\u0006#"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IMemoryStorageBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "insertSemanticEntity", "", "payload", "updateSemanticEntity", "commitSemanticBatch", "commitConsumerOutput", "supersedeMemoryProcessSources", "", "deleteSemanticEntity", "", "entityId", "insertEpisodicEntity", "updateEpisodicEntity", "deleteEpisodicEntity", "upsertRuleEpisodicMemory", "rebuildEntityIndex", "batchRebuildEntityIndex", "entityIds", "", "querySemanticByKeyPhrase", "keyPhrase", "limit", "queryEpisodicByEntityId", "triggerGlobalIndex", "", InfoRequestQPSOptTraceLogger.REASON, "showMemoryIsland", "showScreenshotEffect", "isMemoryTraceReportEnabled", "reportMemoryTraceOps", "logId", AILabCheckPermissionTask.KEY_SOURCE, "memoryOpsJson", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IMemoryStorageBridgeAPI extends IService {
    boolean batchRebuildEntityIndex(List<String> r1);

    String commitConsumerOutput(String r1);

    String commitSemanticBatch(String r1);

    boolean deleteEpisodicEntity(String r1);

    boolean deleteSemanticEntity(String r1);

    String insertEpisodicEntity(String r1);

    String insertSemanticEntity(String r1);

    boolean isMemoryTraceReportEnabled();

    String queryEpisodicByEntityId(String r1);

    String querySemanticByKeyPhrase(String r1, int r2);

    boolean rebuildEntityIndex(String r1);

    boolean reportMemoryTraceOps(String r1, String r2, String r3);

    void showMemoryIsland(String r1);

    void showScreenshotEffect();

    int supersedeMemoryProcessSources(String r1);

    void triggerGlobalIndex(String r1);

    String updateEpisodicEntity(String r1);

    String updateSemanticEntity(String r1);

    String upsertRuleEpisodicMemory(String r1);
}
