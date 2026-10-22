package com.bytedance.ai.bridge.sqliteop;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL$ExecuteSqliteActionParamsModel;", "Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL$ExecuteSqliteActionResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "ExecuteSqliteActionParamsModel", "ExecuteSqliteActionResultModel", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsExecuteSqliteActionMethodIDL extends CoreAIBridgeMethod<ExecuteSqliteActionParamsModel, ExecuteSqliteActionResultModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL$ExecuteSqliteActionParamsModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "dbName", "", "getDbName", "()Ljava/lang/String;", "action", "getAction", "actionParams", "", "", "getActionParams", "()Ljava/util/Map;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ExecuteSqliteActionParamsModel extends ParamModel {
        @AIBridgeParamField(keyPath = "action", required = true)
        String getAction();

        @AIBridgeParamField(keyPath = "actionParams", required = false)
        Map<String, Object> getActionParams();

        @AIBridgeParamField(keyPath = "dbName", required = true)
        String getDbName();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R>\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL$ExecuteSqliteActionResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "", "", "", "extraInfo", "getExtraInfo", "()Ljava/util/Map;", "setExtraInfo", "(Ljava/util/Map;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ExecuteSqliteActionResultModel extends ResultModel {
        Map<String, Object> getExtraInfo();

        @AIBridgeParamField(keyPath = "extraInfo", required = false)
        void setExtraInfo(Map<String, ? extends Object> r5);
    }

    public AbsExecuteSqliteActionMethodIDL() {
        this.name = "applet.sqlite.execute";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
