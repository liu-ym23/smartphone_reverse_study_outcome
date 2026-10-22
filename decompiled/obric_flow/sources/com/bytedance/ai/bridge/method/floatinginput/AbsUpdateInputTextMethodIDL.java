package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.event.MessageIndication;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputTextMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputTextMethodIDL$UpdateInputTextParamModal;", "Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputTextMethodIDL$UpdateInputTextResultModal;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "UpdateInputTextParamModal", "UpdateInputTextResultModal", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsUpdateInputTextMethodIDL extends CoreAIBridgeMethod<UpdateInputTextParamModal, UpdateInputTextResultModal> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputTextMethodIDL$UpdateInputTextParamModal;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", MessageIndication.CONTENT_TYPE_TEXT, "", "getText", "()Ljava/lang/String;", "mode", "getMode", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface UpdateInputTextParamModal extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = "replace", type = DefaultType.STRING), keyPath = "mode", required = false)
        String getMode();

        @AIBridgeParamField(keyPath = MessageIndication.CONTENT_TYPE_TEXT, required = true)
        String getText();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/floatinginput/AbsUpdateInputTextMethodIDL$UpdateInputTextResultModal;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface UpdateInputTextResultModal extends ResultModel {
    }

    public AbsUpdateInputTextMethodIDL() {
        this.name = "applet.updateInputValue";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
