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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/obric/miniapp/aibridge/AbsShowDatePickerMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/obric/miniapp/aibridge/AbsShowDatePickerMethodIDL$ShowDatePickerParamModel;", "Lcom/obric/miniapp/aibridge/AbsShowDatePickerMethodIDL$ShowDatePickerResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "ShowDatePickerParamModel", "ShowDatePickerResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsShowDatePickerMethodIDL extends CoreAIBridgeMethod<a, b> {

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "customOptions", required = false)
        List<String> getCustomOptions();

        @AIBridgeParamField(keyPath = "defaultValue", required = false)
        JSONObject getDefaultValue();

        @AIBridgeParamField(keyPath = "height", required = false)
        String getHeight();

        @AIBridgeParamField(keyPath = "maxTimestamp", required = false)
        Long getMaxTimestamp();

        @AIBridgeParamField(keyPath = "minTimestamp", required = false)
        Long getMinTimestamp();

        @AIBridgeParamField(keyPath = "showTimeLabels", required = false)
        String getShowTimeLabels();

        @AIBridgeParamField(keyPath = "title", required = false)
        String getTitle();

        @AIBridgeParamField(keyPath = "type", required = true)
        String getType();

        @AIBridgeParamField(keyPath = "width", required = false)
        String getWidth();

        @AIBridgeParamField(keyPath = "yearRange", required = false)
        JSONObject getYearRange();

        @AIBridgeParamField(keyPath = "is24Hour", required = false)
        String is24Hour();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "cancelled", required = true)
        void setCancelled(boolean r1);

        @AIBridgeParamField(keyPath = "selections", required = false)
        void setSelections(JSONObject r1);

        @AIBridgeParamField(keyPath = "value", required = false)
        void setValue(JSONObject r1);
    }

    public final String getName() {
        return "applet.showDatePicker";
    }

    public AbsShowDatePickerMethodIDL() {
    }
}
