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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL$OpenPageParamModel;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL$OpenPageResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "altNames", "", "getAltNames", "()Ljava/util/List;", "OpenPageParamModel", "OpenPageResultModel", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsOpenPageMethodIDL extends CoreAIBridgeMethod<OpenPageParamModel, OpenPageResultModel> {
    private final List<String> altNames;
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL$OpenPageParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "appletId", "", "getAppletId", "()Ljava/lang/String;", "pageId", "getPageId", "context", "Lcom/google/gson/JsonObject;", "getContext", "()Lcom/google/gson/JsonObject;", "pageData", "getPageData", "mode", "getMode", "pageSettings", "getPageSettings", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OpenPageParamModel extends ParamModel {
        @AIBridgeParamField(keyPath = "appletId", required = false)
        String getAppletId();

        @AIBridgeParamField(keyPath = "context", required = true)
        JsonObject getContext();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = OpenPageMethod.APP_FULL, type = DefaultType.STRING), keyPath = "mode", required = false)
        String getMode();

        @AIBridgeParamField(keyPath = "pageData", required = false)
        String getPageData();

        @AIBridgeParamField(keyPath = "pageId", required = true)
        String getPageId();

        @AIBridgeParamField(keyPath = "pageSettings", required = false)
        JsonObject getPageSettings();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R&\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\t@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsOpenPageMethodIDL$OpenPageResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "", "viewId", "getViewId", "()Ljava/lang/String;", "setViewId", "(Ljava/lang/String;)V", "", "floatingShowResult", "getFloatingShowResult", "()Ljava/lang/Integer;", "setFloatingShowResult", "(Ljava/lang/Integer;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OpenPageResultModel extends ResultModel {
        Integer getFloatingShowResult();

        String getViewId();

        @AIBridgeParamField(keyPath = "floatingShowResult", required = true)
        void setFloatingShowResult(Integer r5);

        @AIBridgeParamField(keyPath = "viewId", required = true)
        void setViewId(String r5);
    }

    public AbsOpenPageMethodIDL() {
        this.name = "applet.openPage";
        this.altNames = CollectionsKt.listOf("doubao.openPage");
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public List<String> getAltNames() {
        return this.altNames;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
