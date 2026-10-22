package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.obric.aikernel.sdk.ext.Params;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\u000bH&J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H&¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IAutoMemoryProBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "onAutoMemoryProExtractFinish", "", "data", "", "onCreateAutoMemoryRule", "", "title", Params.CONTENT, "onUpdateCollectionRule", "", "ruleId", "onDeleteCollectionRule", "onAutoMemoryProV2ExtractFinish", "onAutoMemoryProV2CollectionFinish", "onAutoMemoryProClientEvaluationStats", "getImageFilterEnable", "isAutoMemoryProEnabled", "resolveAutoMemoryIconKey", "semanticKey", "oldIconKey", "stableSeed", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAutoMemoryProBridgeAPI extends IService {
    boolean getImageFilterEnable();

    boolean isAutoMemoryProEnabled();

    void onAutoMemoryProClientEvaluationStats(String r1);

    void onAutoMemoryProExtractFinish(String r1);

    void onAutoMemoryProV2CollectionFinish(String r1);

    void onAutoMemoryProV2ExtractFinish(String r1);

    long onCreateAutoMemoryRule(String r1, String r2);

    boolean onDeleteCollectionRule(long r1);

    boolean onUpdateCollectionRule(long r1, String r3);

    String resolveAutoMemoryIconKey(String r1, String r2, String r3);
}
