package com.bytedance.ai.bridge.method.system;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.Location;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL$OpenMapAppParamModel;", "Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL$OpenMapAppResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "OpenMapAppParamModel", "OpenMapAppResultModel", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsOpenMapAppMethodIDL extends CoreAIBridgeMethod<OpenMapAppParamModel, OpenMapAppResultModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL$OpenMapAppParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "from", "Lcom/bytedance/ai/bridge/service/Location;", "getFrom", "()Lcom/bytedance/ai/bridge/service/Location;", "to", "getTo", "method", "", "getMethod", "()Ljava/lang/String;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OpenMapAppParamModel extends ParamModel {
        @AIBridgeParamField(keyPath = "from", required = false)
        Location getFrom();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = "driving", type = DefaultType.STRING), keyPath = "method", required = false)
        String getMethod();

        @AIBridgeParamField(keyPath = "to", required = true)
        Location getTo();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/AbsOpenMapAppMethodIDL$OpenMapAppResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "", "userAction", "getUserAction", "()Ljava/lang/String;", "setUserAction", "(Ljava/lang/String;)V", "", "openResult", "getOpenResult", "()Z", "setOpenResult", "(Z)V", "", "mapsAvailable", "getMapsAvailable", "()Ljava/util/List;", "setMapsAvailable", "(Ljava/util/List;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OpenMapAppResultModel extends ResultModel {
        List<String> getMapsAvailable();

        boolean getOpenResult();

        String getUserAction();

        @AIBridgeParamField(keyPath = "mapsAvailable", required = true)
        void setMapsAvailable(List<String> r5);

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), keyPath = "openResult", required = true)
        void setOpenResult(boolean r5);

        @AIBridgeParamField(keyPath = "userAction", required = true)
        void setUserAction(String r5);
    }

    public AbsOpenMapAppMethodIDL() {
        this.name = "applet.openMapApp";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
