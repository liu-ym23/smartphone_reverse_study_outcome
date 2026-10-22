package com.bytedance.ai.bridge.system.ui;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ShowModalParamModel;", "Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ShowModalResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "ShowModalParamModel", "ShowModalResultModel", "ModalAction", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsShowModalMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ModalAction;", "", "<init>", "(Ljava/lang/String;I)V", "CANCEL", "CONFIRM", "MASK", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ModalAction extends Enum<ModalAction> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ModalAction[] $VALUES = null;

        @SerializedName("cancel")
        public static final ModalAction CANCEL = null;

        @SerializedName(com.bytedance.android.ec.core.event.a.VALUE_CLICK_CONFIRM)
        public static final ModalAction CONFIRM = null;

        @SerializedName("mask")
        public static final ModalAction MASK = null;

        private static final /* synthetic */ ModalAction[] $values() {
            return new ModalAction[]{CANCEL, CONFIRM, MASK};
        }

        public static EnumEntries<ModalAction> getEntries() {
            return $ENTRIES;
        }

        static {
            CANCEL = new ModalAction("CANCEL", 0);
            CONFIRM = new ModalAction("CONFIRM", 1);
            MASK = new ModalAction("MASK", 2);
            ModalAction[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static ModalAction[] values() {
            return (ModalAction[]) $VALUES.clone();
        }

        public static ModalAction valueOf(String r1) {
            return (ModalAction) r27.a.a(ModalAction.class, r1);
        }

        private ModalAction(String r1, int r10) {
            super(r1, r10);
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "cancelColor", required = false)
        String getCancelColor();

        @AIBridgeParamField(keyPath = "cancelText", required = false)
        String getCancelText();

        @AIBridgeParamField(keyPath = "confirmColor", required = false)
        String getConfirmColor();

        @AIBridgeParamField(keyPath = "confirmText", required = false)
        String getConfirmText();

        @AIBridgeParamField(keyPath = "content", required = false)
        String getContent();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = false, type = DefaultType.BOOL), keyPath = "editable", required = false)
        boolean getEditable();

        @AIBridgeParamField(keyPath = "placeholderText", required = false)
        String getPlaceholderText();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), keyPath = "showCancel", required = false)
        boolean getShowCancel();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), keyPath = "tapMaskToDismiss", required = false)
        boolean getTapMaskToDismiss();

        @AIBridgeParamField(keyPath = "title", required = false)
        String getTitle();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "action", required = true)
        void setAction(ModalAction r1);

        @AIBridgeParamField(keyPath = "content", required = false)
        void setContent(String r1);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean mustRunInMain() {
        return true;
    }

    public AbsShowModalMethodIDL() {
        this.a = "doubao.showModal";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
