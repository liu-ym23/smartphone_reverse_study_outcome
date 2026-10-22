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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL$SlardarConfigModel;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL$EmptyMessageModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "SlardarConfigModel", "EmptyMessageModel", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsInitConfigMethodIDL extends CoreAIBridgeMethod<SlardarConfigModel, EmptyMessageModel> {
    private final String name;

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface EmptyMessageModel extends ResultModel {
    }

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\"\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/hybridMonitor/AbsInitConfigMethodIDL$SlardarConfigModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "bid", "", "getBid", "()Ljava/lang/String;", LynxMonitorService.KEY_PID, "getPid", "env", "getEnv", "release", "getRelease", "context", "", "", "getContext", "()Ljava/util/Map;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface SlardarConfigModel extends ParamModel {
        @AIBridgeParamField(keyPath = "bid", required = false)
        String getBid();

        @AIBridgeParamField(keyPath = "context", required = false)
        Map<String, Object> getContext();

        @AIBridgeParamField(keyPath = "env", required = false)
        String getEnv();

        @AIBridgeParamField(keyPath = LynxMonitorService.KEY_PID, required = false)
        String getPid();

        @AIBridgeParamField(keyPath = "release", required = false)
        String getRelease();
    }

    public AbsInitConfigMethodIDL() {
        this.name = "hybridMonitor.initConfig";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
