package com.bytedance.ai.bridge.device.deviceInfo;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/device/deviceInfo/AbsGetDeviceInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/device/deviceInfo/AbsGetDeviceInfoMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/device/deviceInfo/AbsGetDeviceInfoMethodIDL$GetDeviceInfoResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "EmptyMessageModel", "GetDeviceInfoResultModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetDeviceInfoMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "abi", required = false)
        void setAbi(String r1);

        @AIBridgeParamField(keyPath = "benchmarkLevel", required = true)
        void setBenchmarkLevel(double r1);

        @AIBridgeParamField(keyPath = com.bytedance.android.ec.core.event.a.VALUE_BRAND, required = true)
        void setBrand(String r1);

        @AIBridgeParamField(keyPath = "cpuType", required = false)
        void setCpuType(String r1);

        @AIBridgeParamField(keyPath = "deviceAbi", required = false)
        void setDeviceAbi(String r1);

        @AIBridgeParamField(keyPath = "memorySize", required = true)
        void setMemorySize(String r1);

        @AIBridgeParamField(keyPath = "model", required = true)
        void setModel(String r1);

        @AIBridgeParamField(keyPath = com.bytedance.android.ec.core.event.a.KEY_PLATFORM, required = true)
        void setPlatform(String r1);

        @AIBridgeParamField(keyPath = "system", required = true)
        void setSystem(String r1);
    }

    public AbsGetDeviceInfoMethodIDL() {
        this.a = "doubao.getDeviceInfo";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
