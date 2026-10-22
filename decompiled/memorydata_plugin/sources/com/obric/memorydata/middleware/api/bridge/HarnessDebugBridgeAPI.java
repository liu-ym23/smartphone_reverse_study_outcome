package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/HarnessDebugBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IHarnessDebugBridgeAPI;", "<init>", "()V", "collectLog", "", "data", "", "getBridgeReplay", "getEventReplay", "getLLMMock", Params.PROMPT, "getLLMReplay", "prepareCase", "", "saveBridgeCall", "saveCaseInput", "saveCaseResult", "saveEvent", "saveLLMCall", "saveTrace", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HarnessDebugBridgeAPI implements IHarnessDebugBridgeAPI {
    public static final HarnessDebugBridgeAPI INSTANCE = null;
    private final /* synthetic */ IHarnessDebugBridgeAPI $$delegate_0;

    static {
        INSTANCE = new HarnessDebugBridgeAPI();
    }

    private HarnessDebugBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IHarnessDebugBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IHarnessDebugBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IHarnessDebugBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public void collectLog(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.collectLog(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public String getBridgeReplay(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return this.$$delegate_0.getBridgeReplay(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public String getEventReplay(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return this.$$delegate_0.getEventReplay(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public String getLLMMock(String r2) {
        Intrinsics.checkNotNullParameter(r2, Params.PROMPT);
        return this.$$delegate_0.getLLMMock(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public String getLLMReplay(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return this.$$delegate_0.getLLMReplay(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public boolean prepareCase(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return this.$$delegate_0.prepareCase(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public boolean saveBridgeCall(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return this.$$delegate_0.saveBridgeCall(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public boolean saveCaseInput(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return this.$$delegate_0.saveCaseInput(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public boolean saveCaseResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return this.$$delegate_0.saveCaseResult(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public boolean saveEvent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return this.$$delegate_0.saveEvent(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public boolean saveLLMCall(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        return this.$$delegate_0.saveLLMCall(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IHarnessDebugBridgeAPI
    public void saveTrace(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.$$delegate_0.saveTrace(r2);
    }
}
