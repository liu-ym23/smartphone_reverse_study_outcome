package com.bytedance.ai.bridge.system.vibrate;

import androidx.annotation.Keep;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.ex.widget.WidgetView;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\f\r\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateShortParamModel;", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$EmptyMessageModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "VibrateShortParamModel", "EmptyMessageModel", "VibrateType", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsVibrateShortMethodIDL extends CoreAIBridgeMethod<VibrateShortParamModel, EmptyMessageModel> {
    private final String name;

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$EmptyMessageModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface EmptyMessageModel extends ResultModel {
    }

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateShortParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "type", "Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateType;", "getType", "()Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateType;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface VibrateShortParamModel extends ParamModel {
        @AIBridgeParamField(keyPath = "type", required = true)
        VibrateType getType();
    }

    @Keep
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/system/vibrate/AbsVibrateShortMethodIDL$VibrateType;", "", "<init>", "(Ljava/lang/String;I)V", "HEAVY", "MEDIUM", "LIGHT", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum VibrateType extends Enum<VibrateType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ VibrateType[] $VALUES = null;

        @SerializedName("heavy")
        public static final VibrateType HEAVY = null;

        @SerializedName(WidgetView.UI_MODE_LIGHT)
        public static final VibrateType LIGHT = null;

        @SerializedName("medium")
        public static final VibrateType MEDIUM = null;

        private static final /* synthetic */ VibrateType[] $values() {
            return new VibrateType[]{HEAVY, MEDIUM, LIGHT};
        }

        static {
            HEAVY = new VibrateType("HEAVY", 0);
            MEDIUM = new VibrateType("MEDIUM", 1);
            LIGHT = new VibrateType("LIGHT", 2);
            VibrateType[] r5 = $values();
            $VALUES = r5;
            $ENTRIES = EnumEntriesKt.enumEntries(r5);
        }

        private VibrateType(String r5, int r10) {
            super(r5, r10);
        }

        public static EnumEntries<VibrateType> getEntries() {
            return $ENTRIES;
        }

        public static VibrateType valueOf(String r5) {
            return (VibrateType) Enum.valueOf(VibrateType.class, r5);
        }

        public static VibrateType[] values() {
            return (VibrateType[]) $VALUES.clone();
        }
    }

    public AbsVibrateShortMethodIDL() {
        this.name = "doubao.vibrateShort";
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
