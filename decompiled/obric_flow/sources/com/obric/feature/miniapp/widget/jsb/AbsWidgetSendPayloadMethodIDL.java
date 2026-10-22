package com.obric.feature.miniapp.widget.jsb;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetSendPayloadMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetSendPayloadMethodIDL$WidgetSendPayloadParamsModel;", "Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetSendPayloadMethodIDL$WidgetSendPayloadResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "WidgetSendPayloadParamsModel", "WidgetSendPayloadResultModel", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsWidgetSendPayloadMethodIDL extends CoreAIBridgeMethod<WidgetSendPayloadParamsModel, WidgetSendPayloadResultModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetSendPayloadMethodIDL$WidgetSendPayloadParamsModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "payload", "", "getPayload", "()Ljava/lang/String;", "waitForResult", "", "getWaitForResult", "()Z", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface WidgetSendPayloadParamsModel extends ParamModel {
        @AIBridgeParamField(keyPath = "payload")
        String getPayload();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), keyPath = "waitForResult")
        boolean getWaitForResult();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R&\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetSendPayloadMethodIDL$WidgetSendPayloadResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "", "result", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface WidgetSendPayloadResultModel extends ResultModel {
        String getResult();

        @AIBridgeParamField(keyPath = "result", required = true)
        void setResult(String r5);
    }

    public AbsWidgetSendPayloadMethodIDL() {
        this.name = "obric.widget.sendPayload";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
