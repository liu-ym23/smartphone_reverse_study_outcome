package com.bytedance.ai.bridge.message;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/message/AbsDispatchActionDirectiveMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/message/AbsDispatchActionDirectiveMethodIDL$ActionDirectiveModel;", "Lcom/bytedance/ai/bridge/message/AbsDispatchActionDirectiveMethodIDL$EmptyMessageModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "ActionDirectiveModel", "EmptyMessageModel", "ActionType", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDispatchActionDirectiveMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/message/AbsDispatchActionDirectiveMethodIDL$ActionType;", "", "<init>", "(Ljava/lang/String;I)V", "BUTTON_CLICK", "OPTION_SELECT", "FORM_SUBMIT", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ActionType extends Enum<ActionType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ActionType[] $VALUES = null;

        @SerializedName("button_click")
        public static final ActionType BUTTON_CLICK = null;

        @SerializedName("form_submit")
        public static final ActionType FORM_SUBMIT = null;

        @SerializedName("option_select")
        public static final ActionType OPTION_SELECT = null;

        private static final /* synthetic */ ActionType[] $values() {
            return new ActionType[]{BUTTON_CLICK, OPTION_SELECT, FORM_SUBMIT};
        }

        public static EnumEntries<ActionType> getEntries() {
            return $ENTRIES;
        }

        static {
            BUTTON_CLICK = new ActionType("BUTTON_CLICK", 0);
            OPTION_SELECT = new ActionType("OPTION_SELECT", 1);
            FORM_SUBMIT = new ActionType("FORM_SUBMIT", 2);
            ActionType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) r27.a.a(ActionType.class, r1);
        }

        private ActionType(String r1, int r10) {
            super(r1, r10);
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "actionDescribe", required = true)
        String getActionDescribe();

        @AIBridgeParamField(keyPath = "actionType", required = true)
        ActionType getActionType();

        @AIBridgeParamField(keyPath = "expectedAction", required = true)
        String getExpectedAction();

        @AIBridgeParamField(keyPath = "responseHint", required = false)
        String getResponseHint();

        @AIBridgeParamField(keyPath = "toolName", required = false)
        String getToolName();

        @AIBridgeParamField(keyPath = "toolParams", required = false)
        Map<String, String> getToolParams();

        @AIBridgeParamField(keyPath = "widgetInstanceId", required = true)
        String getWidgetInstanceId();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
    }

    public AbsDispatchActionDirectiveMethodIDL() {
        this.a = "doubao.dispatchActionDirective";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
