package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL$CreateWidgetParamModel;", "Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL$CreateWidgetResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "CreateWidgetParamModel", "CreateWidgetResultModel", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsCreateWidgetMethodIDL extends CoreAIBridgeMethod<CreateWidgetParamModel, CreateWidgetResultModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00138gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL$CreateWidgetParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "widgetId", "", "getWidgetId", "()Ljava/lang/String;", "widgetName", "getWidgetName", "widgetData", "getWidgetData", "context", "Lcom/google/gson/JsonObject;", "getContext", "()Lcom/google/gson/JsonObject;", "suggests", "", "getSuggests", "()Ljava/util/List;", "extra", "", "getExtra", "()Ljava/util/Map;", "suggestsV2", "getSuggestsV2", "afterBotReply", "", "getAfterBotReply", "()Ljava/lang/Boolean;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface CreateWidgetParamModel extends ParamModel {
        @AIBridgeParamField(keyPath = "afterBotReply", required = false)
        Boolean getAfterBotReply();

        @AIBridgeParamField(keyPath = "context", required = true)
        JsonObject getContext();

        @AIBridgeParamField(keyPath = "extra", required = false)
        Map<String, String> getExtra();

        @AIBridgeParamField(keyPath = "suggests", required = false)
        List<String> getSuggests();

        @AIBridgeParamField(keyPath = "suggestsV2", required = false)
        List<String> getSuggestsV2();

        @AIBridgeParamField(keyPath = "widgetData", required = false)
        String getWidgetData();

        @AIBridgeParamField(keyPath = "widgetId", required = true)
        String getWidgetId();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = "", type = DefaultType.STRING), keyPath = "widgetName", required = false)
        String getWidgetName();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsCreateWidgetMethodIDL$CreateWidgetResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface CreateWidgetResultModel extends ResultModel {
    }

    public AbsCreateWidgetMethodIDL() {
        this.name = "applet.createWidget";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
