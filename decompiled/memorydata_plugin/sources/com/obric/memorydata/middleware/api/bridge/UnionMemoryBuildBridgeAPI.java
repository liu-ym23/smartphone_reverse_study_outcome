package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0001J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0017\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096\u0001¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/UnionMemoryBuildBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IUnionMemoryBuildBridgeAPI;", "<init>", "()V", "clearScreenObservation", "", "ids", "", "", "commitUpgrade", "", "payload", "failbackIndexMemoryEntity", "entityIds", "finishRebuild", "onEpisodicMemoryBuildResult", "data", "onSemanticMemoryBuildResult", "onSemanticMemoryBuildResultV2", "onSemanticMemoryPersonaProcessed", "onSemanticMemoryProcessed", "onSemanticTypeSummaryResult", "onUserInsightResult", "onUserPersonaResult", "recordUpgradeFailure", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnionMemoryBuildBridgeAPI implements IUnionMemoryBuildBridgeAPI {
    public static final UnionMemoryBuildBridgeAPI INSTANCE = null;
    private final /* synthetic */ IUnionMemoryBuildBridgeAPI $$delegate_0;

    static {
        INSTANCE = new UnionMemoryBuildBridgeAPI();
    }

    private UnionMemoryBuildBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IUnionMemoryBuildBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IUnionMemoryBuildBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IUnionMemoryBuildBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void clearScreenObservation(List<Long> r3) {
        List<Long> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "ids");
        this.$$delegate_0.clearScreenObservation(r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public String commitUpgrade(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return this.$$delegate_0.commitUpgrade(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void failbackIndexMemoryEntity(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "entityIds");
        this.$$delegate_0.failbackIndexMemoryEntity(r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public String finishRebuild(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return this.$$delegate_0.finishRebuild(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public String onEpisodicMemoryBuildResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return this.$$delegate_0.onEpisodicMemoryBuildResult(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void onSemanticMemoryBuildResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.onSemanticMemoryBuildResult(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public String onSemanticMemoryBuildResultV2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return this.$$delegate_0.onSemanticMemoryBuildResultV2(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void onSemanticMemoryPersonaProcessed(String r2) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        this.$$delegate_0.onSemanticMemoryPersonaProcessed(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void onSemanticMemoryProcessed(String r2) {
        Intrinsics.checkNotNullParameter(r2, "ids");
        this.$$delegate_0.onSemanticMemoryProcessed(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void onSemanticTypeSummaryResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.onSemanticTypeSummaryResult(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void onUserInsightResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.onUserInsightResult(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public void onUserPersonaResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.onUserPersonaResult(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IUnionMemoryBuildBridgeAPI
    public String recordUpgradeFailure(String r2) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        return this.$$delegate_0.recordUpgradeFailure(r2);
    }
}
