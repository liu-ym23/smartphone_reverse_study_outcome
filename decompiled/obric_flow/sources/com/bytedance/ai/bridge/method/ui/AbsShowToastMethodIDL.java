package com.bytedance.ai.bridge.method.ui;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/AbsShowToastMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/ui/AbsShowToastMethodIDL$ShowToastParamModel;", "Lcom/bytedance/ai/bridge/method/ui/AbsShowToastMethodIDL$ShowToastResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "ShowToastParamModel", "ShowToastResultModel", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsShowToastMethodIDL extends CoreAIBridgeMethod<ShowToastParamModel, ShowToastResultModel> {

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\n\bg\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011R\u0014\u0010\u0005\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/AbsShowToastMethodIDL$ShowToastParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "", "getMessage", "()Ljava/lang/String;", "message", "getType", "type", "", "getDuration", "()Ljava/lang/Number;", "duration", "getIcon", "icon", "getCustomIcon", "customIcon", "Companion", "com/bytedance/ai/bridge/method/ui/a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ShowToastParamModel extends ParamModel {
        public static final a Companion = null;
        public static final String ShowToastIconError = "error";
        public static final String ShowToastIconSuccess = "success";
        public static final String ShowToastIconWarn = "warn";
        public static final String ShowToastTypeError = "error";
        public static final String ShowToastTypeSuccess = "success";

        static {
            Companion = a.f2023a;
        }

        @AIBridgeParamField(keyPath = "customIcon", required = false)
        String getCustomIcon();

        @AIBridgeParamField(keyPath = "duration", required = false)
        Number getDuration();

        @AIBridgeParamField(keyPath = "icon", required = false)
        String getIcon();

        @AIBridgeParamField(keyPath = "message", required = true)
        String getMessage();

        @AIBridgeParamField(keyPath = "type", required = false)
        String getType();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/AbsShowToastMethodIDL$ShowToastResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ShowToastResultModel extends ResultModel {
    }

    public AbsShowToastMethodIDL() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return "applet.showToast";
    }
}
