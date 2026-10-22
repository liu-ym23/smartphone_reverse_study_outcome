package com.bytedance.ai.jsb;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethodIDL$SetIsNeedAliveParam;", "Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethodIDL$AISetIsNeedAliveResultModal;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "SetIsNeedAliveParam", "AISetIsNeedAliveResultModal", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AISetIsNeedAliveMethodIDL extends CoreAIBridgeMethod<SetIsNeedAliveParam, AISetIsNeedAliveResultModal> {
    private final String name;

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethodIDL$AISetIsNeedAliveResultModal;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "", "time", "getTime", "()I", "setTime", "(I)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface AISetIsNeedAliveResultModal extends ResultModel {
        int getTime();

        @AIBridgeParamField(keyPath = "time", required = true)
        void setTime(int r5);
    }

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/jsb/AISetIsNeedAliveMethodIDL$SetIsNeedAliveParam;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "time", "", "getTime", "()Ljava/lang/Integer;", "isNeedAlive", "", "()Z", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface SetIsNeedAliveParam extends ParamModel {
        @AIBridgeParamField(keyPath = "time", required = false)
        Integer getTime();

        @AIBridgeParamField(keyPath = "isNeedAlive", required = true)
        boolean isNeedAlive();
    }

    public AISetIsNeedAliveMethodIDL() {
        this.name = "applet.setIsNeedAlive";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
