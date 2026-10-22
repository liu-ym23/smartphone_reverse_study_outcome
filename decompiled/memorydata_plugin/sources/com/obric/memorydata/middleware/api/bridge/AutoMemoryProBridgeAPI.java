package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000fH\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nH\u0096\u0001J!\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/AutoMemoryProBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IAutoMemoryProBridgeAPI;", "<init>", "()V", "getImageFilterEnable", "", "isAutoMemoryProEnabled", "onAutoMemoryProClientEvaluationStats", "", "data", "", "onAutoMemoryProExtractFinish", "onAutoMemoryProV2CollectionFinish", "onAutoMemoryProV2ExtractFinish", "onCreateAutoMemoryRule", "", "title", Params.CONTENT, "onDeleteCollectionRule", "ruleId", "onUpdateCollectionRule", "resolveAutoMemoryIconKey", "semanticKey", "oldIconKey", "stableSeed", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryProBridgeAPI implements IAutoMemoryProBridgeAPI {
    public static final AutoMemoryProBridgeAPI INSTANCE = null;
    private final /* synthetic */ IAutoMemoryProBridgeAPI $$delegate_0;

    static {
        INSTANCE = new AutoMemoryProBridgeAPI();
    }

    private AutoMemoryProBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IAutoMemoryProBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IAutoMemoryProBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IAutoMemoryProBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public boolean getImageFilterEnable() {
        return this.$$delegate_0.getImageFilterEnable();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public boolean isAutoMemoryProEnabled() {
        return this.$$delegate_0.isAutoMemoryProEnabled();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public void onAutoMemoryProClientEvaluationStats(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.onAutoMemoryProClientEvaluationStats(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public void onAutoMemoryProExtractFinish(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.onAutoMemoryProExtractFinish(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public void onAutoMemoryProV2CollectionFinish(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.onAutoMemoryProV2CollectionFinish(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public void onAutoMemoryProV2ExtractFinish(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.onAutoMemoryProV2ExtractFinish(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public long onCreateAutoMemoryRule(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        return this.$$delegate_0.onCreateAutoMemoryRule(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public boolean onDeleteCollectionRule(long r1) {
        return this.$$delegate_0.onDeleteCollectionRule(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public boolean onUpdateCollectionRule(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
        return this.$$delegate_0.onUpdateCollectionRule(r2, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAutoMemoryProBridgeAPI
    public String resolveAutoMemoryIconKey(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "semanticKey");
        Intrinsics.checkNotNullParameter(r3, "oldIconKey");
        Intrinsics.checkNotNullParameter(r4, "stableSeed");
        return this.$$delegate_0.resolveAutoMemoryIconKey(r2, r3, r4);
    }
}
