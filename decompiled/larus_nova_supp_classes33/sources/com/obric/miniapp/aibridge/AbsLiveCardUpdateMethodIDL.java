package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/obric/miniapp/aibridge/AbsLiveCardUpdateMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/obric/miniapp/aibridge/AbsLiveCardUpdateMethodIDL$UpdateParamModel;", "Lcom/obric/miniapp/aibridge/AbsLiveCardUpdateMethodIDL$UpdateResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "UpdateParamModel", "UpdateResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsLiveCardUpdateMethodIDL extends CoreAIBridgeMethod<a, b> {

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "collapseTemplateData", required = false)
        JSONObject getCollapseTemplateData();

        @AIBridgeParamField(keyPath = "expandTemplateData", required = false)
        JSONObject getExpandTemplateData();

        @AIBridgeParamField(keyPath = "flags", required = false)
        List<String> getFlags();

        @AIBridgeParamField(keyPath = "mode", required = false)
        String getMode();

        @AIBridgeParamField(keyPath = "sessionKey", required = true)
        String getSessionKey();

        @AIBridgeParamField(keyPath = "trace", required = false)
        JSONObject getTrace();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "error", required = false)
        void setError(JSONObject r1);

        @AIBridgeParamField(keyPath = "ok", required = true)
        void setOk(boolean r1);

        @AIBridgeParamField(keyPath = "sessionKey", required = true)
        void setSessionKey(String r1);

        @AIBridgeParamField(keyPath = "sessionTag", required = false)
        void setSessionTag(String r1);
    }

    public final String getName() {
        return "applet.livecardUpdate";
    }

    public AbsLiveCardUpdateMethodIDL() {
    }
}
