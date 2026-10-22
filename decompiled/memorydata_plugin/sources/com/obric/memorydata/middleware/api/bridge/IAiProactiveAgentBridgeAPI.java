package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IAiProactiveAgentBridgeAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "getAiProactiveArtifactProtocolVersion", "", "materializeAiProactiveArtifact", "", "requestJson", "getAiProactiveProgressProtocolVersion", "reportAiProactiveAgentProgress", "", "progressJson", "refreshAiProactive", "", "refreshTypes", "", "startAiProactiveEcaListening", "stopAiProactiveEcaListening", "startSpellProactiveEcaListening", "stopSpellProactiveEcaListening", "notifySpellProactiveTrigger", InfoRequestQPSOptTraceLogger.REASON, "conditionJson", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IAiProactiveAgentBridgeAPI extends IService {
    int getAiProactiveArtifactProtocolVersion();

    int getAiProactiveProgressProtocolVersion();

    String materializeAiProactiveArtifact(String r1);

    boolean notifySpellProactiveTrigger(String r1, String r2);

    void refreshAiProactive(List<String> r1);

    boolean reportAiProactiveAgentProgress(String r1);

    boolean startAiProactiveEcaListening();

    boolean startSpellProactiveEcaListening();

    boolean stopAiProactiveEcaListening();

    boolean stopSpellProactiveEcaListening();
}
