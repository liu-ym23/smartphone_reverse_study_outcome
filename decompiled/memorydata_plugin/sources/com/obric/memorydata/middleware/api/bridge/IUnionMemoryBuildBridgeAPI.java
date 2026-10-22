package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H&J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH&J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fH&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H&J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H&¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IUnionMemoryBuildBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "onSemanticMemoryBuildResult", "", "data", "", "onSemanticMemoryBuildResultV2", "onUserInsightResult", "onUserPersonaResult", "onSemanticTypeSummaryResult", "onSemanticMemoryProcessed", "ids", "onSemanticMemoryPersonaProcessed", "failbackIndexMemoryEntity", "entityIds", "", "clearScreenObservation", "", "onEpisodicMemoryBuildResult", "commitUpgrade", "payload", "recordUpgradeFailure", "finishRebuild", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IUnionMemoryBuildBridgeAPI extends IService {
    void clearScreenObservation(List<Long> r1);

    String commitUpgrade(String r1);

    void failbackIndexMemoryEntity(List<String> r1);

    String finishRebuild(String r1);

    String onEpisodicMemoryBuildResult(String r1);

    void onSemanticMemoryBuildResult(String r1);

    String onSemanticMemoryBuildResultV2(String r1);

    void onSemanticMemoryPersonaProcessed(String r1);

    void onSemanticMemoryProcessed(String r1);

    void onSemanticTypeSummaryResult(String r1);

    void onUserInsightResult(String r1);

    void onUserPersonaResult(String r1);

    String recordUpgradeFailure(String r1);
}
