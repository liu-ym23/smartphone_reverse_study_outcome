package com.bytedance.ai.bridge.openApp;

import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppRequestModel;", "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "OpenAppRequestModel", "OpenAppResultModel", "OpenAppStatus", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsOpenAppMethodIDL extends CoreAIBridgeMethod<OpenAppRequestModel, OpenAppResultModel> {
    private final String name;

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppRequestModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", LynxResourceModule.URI_KEY, "", "getUri", "()Ljava/lang/String;", "targetPackage", "getTargetPackage", "fallbackUrl", "getFallbackUrl", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OpenAppRequestModel extends ParamModel {
        @AIBridgeParamField(keyPath = "fallbackUrl", required = false)
        String getFallbackUrl();

        @AIBridgeParamField(keyPath = "targetPackage", required = false)
        String getTargetPackage();

        @AIBridgeParamField(keyPath = LynxResourceModule.URI_KEY, required = true)
        String getUri();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\t@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppStatus;", NotificationCompat.CATEGORY_STATUS, "getStatus", "()Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppStatus;", "setStatus", "(Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppStatus;)V", "", "message", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OpenAppResultModel extends ResultModel {
        String getMessage();

        OpenAppStatus getStatus();

        @AIBridgeParamField(keyPath = "message", required = false)
        void setMessage(String r5);

        @AIBridgeParamField(keyPath = NotificationCompat.CATEGORY_STATUS, required = true)
        void setStatus(OpenAppStatus r5);
    }

    @Keep
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/openApp/AbsOpenAppMethodIDL$OpenAppStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DEEP_LINK", "MARKET", "BROWSER", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum OpenAppStatus extends Enum<OpenAppStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ OpenAppStatus[] $VALUES = null;

        @SerializedName("browser")
        public static final OpenAppStatus BROWSER = null;

        @SerializedName("deep_link")
        public static final OpenAppStatus DEEP_LINK = null;

        @SerializedName("market")
        public static final OpenAppStatus MARKET = null;

        private static final /* synthetic */ OpenAppStatus[] $values() {
            return new OpenAppStatus[]{DEEP_LINK, MARKET, BROWSER};
        }

        static {
            DEEP_LINK = new OpenAppStatus("DEEP_LINK", 0);
            MARKET = new OpenAppStatus("MARKET", 1);
            BROWSER = new OpenAppStatus("BROWSER", 2);
            OpenAppStatus[] r5 = $values();
            $VALUES = r5;
            $ENTRIES = EnumEntriesKt.enumEntries(r5);
        }

        private OpenAppStatus(String r5, int r10) {
            super(r5, r10);
        }

        public static EnumEntries<OpenAppStatus> getEntries() {
            return $ENTRIES;
        }

        public static OpenAppStatus valueOf(String r5) {
            return (OpenAppStatus) Enum.valueOf(OpenAppStatus.class, r5);
        }

        public static OpenAppStatus[] values() {
            return (OpenAppStatus[]) $VALUES.clone();
        }
    }

    public AbsOpenAppMethodIDL() {
        this.name = "applet.openApp";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public String getName() {
        return this.name;
    }
}
