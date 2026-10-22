package com.bytedance.ai.bridge.method.datamanager;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/method/datamanager/AbsSetStorageMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsSetStorageMethodIDL$SetStorageParam;", "Lcom/bytedance/ai/bridge/method/datamanager/AbsSetStorageMethodIDL$SetStorageResultModal;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "SetStorageParam", "SetStorageResultModal", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsSetStorageMethodIDL extends CoreAIBridgeMethod<SetStorageParam, SetStorageResultModal> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/datamanager/AbsSetStorageMethodIDL$SetStorageParam;", "Lcom/bytedance/ai/bridge/method/datamanager/StorageInputParam;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface SetStorageParam extends StorageInputParam {
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/datamanager/AbsSetStorageMethodIDL$SetStorageResultModal;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface SetStorageResultModal extends ResultModel {
    }

    public AbsSetStorageMethodIDL() {
        this.name = "applet.setStorageItem";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
