package com.bytedance.ai.bridge.method.router;

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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000f\u0010\u0011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenParamModel;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenResultModel;", "<init>", "()V", "", "mustRunInMain", "()Z", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Companion", "com/bytedance/ai/bridge/method/router/a", "OpenParamModel", "OpenResultModel", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsOpenMethodIDL extends CoreAIBridgeMethod<OpenParamModel, OpenResultModel> {
    public static final a Companion = null;
    public static final String PARAM_KEY_USE_SYS_BROWSER = "useSysBrowser";
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fR\u0014\u0010\u0005\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "", "getSchema", "()Ljava/lang/String;", "schema", "", "getReplace", "()Z", "replace", "getUseSysBrowser", AbsOpenMethodIDL.PARAM_KEY_USE_SYS_BROWSER, "getReplaceType", "replaceType", "Companion", "com/bytedance/ai/bridge/method/router/b", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OpenParamModel extends ParamModel {
        public static final b Companion = null;
        public static final String OPEN_REPLACE_TYPE_ALWAYS_CLOSE_AFTER_OPEN = "alwaysCloseAfterOpen";
        public static final String OPEN_REPLACE_TYPE_ALWAYS_CLOSE_BEFORE_OPEN = "alwaysCloseBeforeOpen";
        public static final String OPEN_REPLACE_TYPE_ONLY_CLOSE_AFTER_OPEN_SUCCEED = "onlyCloseAfterOpenSucceed";

        static {
            Companion = b.f1949a;
        }

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), keyPath = "replace", required = false)
        boolean getReplace();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = OPEN_REPLACE_TYPE_ONLY_CLOSE_AFTER_OPEN_SUCCEED, type = DefaultType.STRING), keyPath = "replaceType", required = false)
        String getReplaceType();

        @AIBridgeParamField(keyPath = "schema", required = true)
        String getSchema();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), keyPath = AbsOpenMethodIDL.PARAM_KEY_USE_SYS_BROWSER, required = false)
        boolean getUseSysBrowser();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OpenResultModel extends ResultModel {
    }

    static {
        Companion = new a();
    }

    public AbsOpenMethodIDL() {
        this.name = "applet.open";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }
}
