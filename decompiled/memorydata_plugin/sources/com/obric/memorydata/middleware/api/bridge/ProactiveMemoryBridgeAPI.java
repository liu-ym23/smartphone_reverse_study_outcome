package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/ProactiveMemoryBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IProactiveMemoryBridgeAPI;", "<init>", "()V", "onEpisodicTopicMemoryResult", "", "data", "", "logId", "onProactivePortraitResult", "onScreenObservationResult", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveMemoryBridgeAPI implements IProactiveMemoryBridgeAPI {
    public static final ProactiveMemoryBridgeAPI INSTANCE = null;
    private final /* synthetic */ IProactiveMemoryBridgeAPI $$delegate_0;

    static {
        INSTANCE = new ProactiveMemoryBridgeAPI();
    }

    private ProactiveMemoryBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IProactiveMemoryBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IProactiveMemoryBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IProactiveMemoryBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IProactiveMemoryBridgeAPI
    public void onEpisodicTopicMemoryResult(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "logId");
        this.$$delegate_0.onEpisodicTopicMemoryResult(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IProactiveMemoryBridgeAPI
    public void onProactivePortraitResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.onProactivePortraitResult(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IProactiveMemoryBridgeAPI
    public void onScreenObservationResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.onScreenObservationResult(r2);
    }
}
