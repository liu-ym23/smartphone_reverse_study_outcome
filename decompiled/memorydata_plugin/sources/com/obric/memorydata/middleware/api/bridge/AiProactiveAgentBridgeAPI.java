package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0096\u0001J\u0017\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\bH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0015\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0016\u001a\u00020\u000bH\u0096\u0001J\t\u0010\u0017\u001a\u00020\u000bH\u0096\u0001¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/AiProactiveAgentBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IAiProactiveAgentBridgeAPI;", "<init>", "()V", "getAiProactiveArtifactProtocolVersion", "", "getAiProactiveProgressProtocolVersion", "materializeAiProactiveArtifact", "", "requestJson", "notifySpellProactiveTrigger", "", InfoRequestQPSOptTraceLogger.REASON, "conditionJson", "refreshAiProactive", "", "refreshTypes", "", "reportAiProactiveAgentProgress", "progressJson", "startAiProactiveEcaListening", "startSpellProactiveEcaListening", "stopAiProactiveEcaListening", "stopSpellProactiveEcaListening", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AiProactiveAgentBridgeAPI implements IAiProactiveAgentBridgeAPI {
    public static final AiProactiveAgentBridgeAPI INSTANCE = null;
    private final /* synthetic */ IAiProactiveAgentBridgeAPI $$delegate_0;

    static {
        INSTANCE = new AiProactiveAgentBridgeAPI();
    }

    private AiProactiveAgentBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IAiProactiveAgentBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IAiProactiveAgentBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IAiProactiveAgentBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public int getAiProactiveArtifactProtocolVersion() {
        return this.$$delegate_0.getAiProactiveArtifactProtocolVersion();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public int getAiProactiveProgressProtocolVersion() {
        return this.$$delegate_0.getAiProactiveProgressProtocolVersion();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public String materializeAiProactiveArtifact(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requestJson");
        return this.$$delegate_0.materializeAiProactiveArtifact(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public boolean notifySpellProactiveTrigger(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r3, "conditionJson");
        return this.$$delegate_0.notifySpellProactiveTrigger(r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public void refreshAiProactive(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "refreshTypes");
        this.$$delegate_0.refreshAiProactive(r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public boolean reportAiProactiveAgentProgress(String r2) {
        Intrinsics.checkNotNullParameter(r2, "progressJson");
        return this.$$delegate_0.reportAiProactiveAgentProgress(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public boolean startAiProactiveEcaListening() {
        return this.$$delegate_0.startAiProactiveEcaListening();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public boolean startSpellProactiveEcaListening() {
        return this.$$delegate_0.startSpellProactiveEcaListening();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public boolean stopAiProactiveEcaListening() {
        return this.$$delegate_0.stopAiProactiveEcaListening();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public boolean stopSpellProactiveEcaListening() {
        return this.$$delegate_0.stopSpellProactiveEcaListening();
    }
}
