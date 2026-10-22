package com.bytedance.ai.bridge.hybridMonitor;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL$CustomEventDataModel;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL$EmptyMessageModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "CustomEventDataModel", "EmptyMessageModel", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsCustomReportMethodIDL extends CoreAIBridgeMethod<CustomEventDataModel, EmptyMessageModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R$\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL$CustomEventDataModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "eventName", "", "getEventName", "()Ljava/lang/String;", LynxMonitorService.KEY_METRICS, "", "", "getMetrics", "()Ljava/util/Map;", "category", "getCategory", "level", "", "getLevel", "()Ljava/lang/Integer;", "extra", "", "getExtra", "bid", "getBid", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface CustomEventDataModel extends ParamModel {
        @AIBridgeParamField(keyPath = "bid", required = false)
        String getBid();

        @AIBridgeParamField(keyPath = "category", required = false)
        Map<String, String> getCategory();

        @AIBridgeParamField(keyPath = "eventName", required = true)
        String getEventName();

        @AIBridgeParamField(keyPath = "extra", required = false)
        Map<String, Object> getExtra();

        @AIBridgeParamField(keyPath = "level", required = false)
        Integer getLevel();

        @AIBridgeParamField(keyPath = LynxMonitorService.KEY_METRICS, required = false)
        Map<String, Double> getMetrics();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface EmptyMessageModel extends ResultModel {
    }

    public AbsCustomReportMethodIDL() {
        this.name = "hybridMonitor.customReport";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
