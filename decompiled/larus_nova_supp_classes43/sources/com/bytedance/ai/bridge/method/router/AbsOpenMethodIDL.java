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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenParamModel;", "Lcom/bytedance/ai/bridge/method/router/AbsOpenMethodIDL$OpenResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "Companion", "OpenParamModel", "OpenResultModel", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsOpenMethodIDL extends CoreAIBridgeMethod<b, c> {
    public final String a;

    public static final class a {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), keyPath = "replace", required = false)
        boolean getReplace();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = "onlyCloseAfterOpenSucceed", type = DefaultType.STRING), keyPath = "replaceType", required = false)
        String getReplaceType();

        @AIBridgeParamField(keyPath = com.bytedance.android.ec.core.event.a.KEY_SCHEMA, required = true)
        String getSchema();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), keyPath = "useSysBrowser", required = false)
        boolean getUseSysBrowser();
    }

    @AIBridgeResultModel
    public interface c extends ResultModel {
    }

    static {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsOpenMethodIDL() {
        this.a = "applet.open";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
