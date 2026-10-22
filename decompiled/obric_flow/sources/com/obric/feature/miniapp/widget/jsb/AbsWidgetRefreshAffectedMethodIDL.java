package com.obric.feature.miniapp.widget.jsb;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetRefreshAffectedMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetRefreshAffectedMethodIDL$WidgetRefreshAffectedParamsModel;", "Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetRefreshAffectedMethodIDL$WidgetRefreshAffectedResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "WidgetRefreshAffectedParamsModel", "WidgetRefreshAffectedResultModel", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsWidgetRefreshAffectedMethodIDL extends CoreAIBridgeMethod<WidgetRefreshAffectedParamsModel, WidgetRefreshAffectedResultModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048gX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetRefreshAffectedMethodIDL$WidgetRefreshAffectedParamsModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "changedDomains", "", "", "getChangedDomains", "()Ljava/util/List;", "reason", "getReason", "()Ljava/lang/String;", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface WidgetRefreshAffectedParamsModel extends ParamModel {
        @AIBridgeParamField(keyPath = "changedDomains", required = true)
        List<String> getChangedDomains();

        @AIBridgeParamField(keyPath = "reason", required = false)
        String getReason();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\n0\t@gX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/AbsWidgetRefreshAffectedMethodIDL$WidgetRefreshAffectedResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "", "acceptedCount", "getAcceptedCount", "()I", "setAcceptedCount", "(I)V", "", "", "updatedWidgetIds", "getUpdatedWidgetIds", "()Ljava/util/List;", "setUpdatedWidgetIds", "(Ljava/util/List;)V", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface WidgetRefreshAffectedResultModel extends ResultModel {
        int getAcceptedCount();

        List<String> getUpdatedWidgetIds();

        @AIBridgeParamField(keyPath = "acceptedCount", required = true)
        void setAcceptedCount(int r5);

        @AIBridgeParamField(keyPath = "updatedWidgetIds", required = true)
        void setUpdatedWidgetIds(List<String> r5);
    }

    public AbsWidgetRefreshAffectedMethodIDL() {
        this.name = "obric.widget.refreshAffected";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
