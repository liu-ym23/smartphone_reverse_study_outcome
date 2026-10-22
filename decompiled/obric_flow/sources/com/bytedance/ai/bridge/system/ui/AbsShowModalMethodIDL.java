package com.bytedance.ai.bridge.system.ui;

import androidx.annotation.Keep;
import cn.nubia.neopush.commons.Constant;
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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ShowModalParamModel;", "Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ShowModalResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "ShowModalParamModel", "ShowModalResultModel", "ModalAction", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsShowModalMethodIDL extends CoreAIBridgeMethod<ShowModalParamModel, ShowModalResultModel> {
    private final String name;

    @Keep
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ModalAction;", "", "<init>", "(Ljava/lang/String;I)V", "CANCEL", "CONFIRM", "MASK", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum ModalAction extends Enum<ModalAction> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ ModalAction[] $VALUES = null;

        @SerializedName("cancel")
        public static final ModalAction CANCEL = null;

        @SerializedName("confirm")
        public static final ModalAction CONFIRM = null;

        @SerializedName("mask")
        public static final ModalAction MASK = null;

        private static final /* synthetic */ ModalAction[] $values() {
            return new ModalAction[]{CANCEL, CONFIRM, MASK};
        }

        static {
            CANCEL = new ModalAction("CANCEL", 0);
            CONFIRM = new ModalAction("CONFIRM", 1);
            MASK = new ModalAction("MASK", 2);
            ModalAction[] r5 = $values();
            $VALUES = r5;
            $ENTRIES = EnumEntriesKt.enumEntries(r5);
        }

        private ModalAction(String r5, int r10) {
            super(r5, r10);
        }

        public static EnumEntries<ModalAction> getEntries() {
            return $ENTRIES;
        }

        public static ModalAction valueOf(String r5) {
            return (ModalAction) Enum.valueOf(ModalAction.class, r5);
        }

        public static ModalAction[] values() {
            return (ModalAction[]) $VALUES.clone();
        }
    }

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\bg\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\t8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ShowModalParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", Constant.TITLE, "", "getTitle", "()Ljava/lang/String;", "content", "getContent", "showCancel", "", "getShowCancel", "()Z", "cancelText", "getCancelText", "confirmText", "getConfirmText", "tapMaskToDismiss", "getTapMaskToDismiss", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ShowModalParamModel extends ParamModel {
        @AIBridgeParamField(keyPath = "cancelText", required = false)
        String getCancelText();

        @AIBridgeParamField(keyPath = "confirmText", required = false)
        String getConfirmText();

        @AIBridgeParamField(keyPath = "content", required = true)
        String getContent();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), keyPath = "showCancel", required = false)
        boolean getShowCancel();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(boolValue = true, type = DefaultType.BOOL), keyPath = "tapMaskToDismiss", required = false)
        boolean getTapMaskToDismiss();

        @AIBridgeParamField(keyPath = Constant.TITLE, required = false)
        String getTitle();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ShowModalResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ModalAction;", "action", "getAction", "()Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ModalAction;", "setAction", "(Lcom/bytedance/ai/bridge/system/ui/AbsShowModalMethodIDL$ModalAction;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ShowModalResultModel extends ResultModel {
        ModalAction getAction();

        @AIBridgeParamField(keyPath = "action", required = true)
        void setAction(ModalAction r5);
    }

    public AbsShowModalMethodIDL() {
        this.name = "applet.showModal";
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
