package com.bytedance.ai.ex.widget.jsb;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/ex/widget/jsb/AbsCreateWidgetMethodMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/ex/widget/jsb/AbsCreateWidgetMethodMethodIDL$CreateWidgetMethodParamModel;", "Lcom/bytedance/ai/ex/widget/jsb/AbsCreateWidgetMethodMethodIDL$CreateWidgetMethodResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "CreateWidgetMethodParamModel", "CreateWidgetMethodResultModel", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsCreateWidgetMethodMethodIDL extends CoreAIBridgeMethod<CreateWidgetMethodParamModel, CreateWidgetMethodResultModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/ex/widget/jsb/AbsCreateWidgetMethodMethodIDL$CreateWidgetMethodParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "packageId", "", "getPackageId", "()Ljava/lang/String;", "widgetId", "getWidgetId", "widgetData", "getWidgetData", "height", "", "getHeight", "()Ljava/lang/Integer;", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface CreateWidgetMethodParamModel extends ParamModel {
        @AIBridgeParamField(keyPath = "height", required = false)
        Integer getHeight();

        @AIBridgeParamField(keyPath = "packageId", required = true)
        String getPackageId();

        @AIBridgeParamField(keyPath = "widgetData", required = false)
        String getWidgetData();

        @AIBridgeParamField(keyPath = "widgetId", required = true)
        String getWidgetId();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/ex/widget/jsb/AbsCreateWidgetMethodMethodIDL$CreateWidgetMethodResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface CreateWidgetMethodResultModel extends ResultModel {
    }

    public AbsCreateWidgetMethodMethodIDL() {
        this.name = "obric.createWidget";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
