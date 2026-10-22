package com.bytedance.ai.bridge.system.permission;

import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\f\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionParamModel;", "Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "PermissionParamModel", "PermissionResultModel", "PermissionName", "PermissionStatus", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsRequestPermissionMethodIDL extends CoreAIBridgeMethod<PermissionParamModel, PermissionResultModel> {
    private final String name;

    @Keep
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionName;", "", "<init>", "(Ljava/lang/String;I)V", "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "READ_CALENDAR", "WRITE_CALENDAR", "CALENDAR", "NOTIFICATION", "LOCATION", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum PermissionName extends Enum<PermissionName> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PermissionName[] $VALUES = null;

        @SerializedName("calendar")
        public static final PermissionName CALENDAR = null;

        @SerializedName("camera")
        public static final PermissionName CAMERA = null;

        @SerializedName("location")
        public static final PermissionName LOCATION = null;

        @SerializedName("microphone")
        public static final PermissionName MICROPHONE = null;

        @SerializedName(Constant.NOTIFICATION)
        public static final PermissionName NOTIFICATION = null;

        @SerializedName("photoalbum")
        public static final PermissionName PHOTOALBUM = null;

        @SerializedName("read_calendar")
        public static final PermissionName READ_CALENDAR = null;

        @SerializedName("vibrate")
        public static final PermissionName VIBRATE = null;

        @SerializedName("write_calendar")
        public static final PermissionName WRITE_CALENDAR = null;

        private static final /* synthetic */ PermissionName[] $values() {
            return new PermissionName[]{CAMERA, MICROPHONE, PHOTOALBUM, VIBRATE, READ_CALENDAR, WRITE_CALENDAR, CALENDAR, NOTIFICATION, LOCATION};
        }

        static {
            CAMERA = new PermissionName("CAMERA", 0);
            MICROPHONE = new PermissionName("MICROPHONE", 1);
            PHOTOALBUM = new PermissionName("PHOTOALBUM", 2);
            VIBRATE = new PermissionName("VIBRATE", 3);
            READ_CALENDAR = new PermissionName("READ_CALENDAR", 4);
            WRITE_CALENDAR = new PermissionName("WRITE_CALENDAR", 5);
            CALENDAR = new PermissionName("CALENDAR", 6);
            NOTIFICATION = new PermissionName("NOTIFICATION", 7);
            LOCATION = new PermissionName("LOCATION", 8);
            PermissionName[] r5 = $values();
            $VALUES = r5;
            $ENTRIES = EnumEntriesKt.enumEntries(r5);
        }

        private PermissionName(String r5, int r10) {
            super(r5, r10);
        }

        public static EnumEntries<PermissionName> getEntries() {
            return $ENTRIES;
        }

        public static PermissionName valueOf(String r5) {
            return (PermissionName) Enum.valueOf(PermissionName.class, r5);
        }

        public static PermissionName[] values() {
            return (PermissionName[]) $VALUES.clone();
        }
    }

    @AIBridgeParamModel
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionParamModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ParamModel;", "permission", "Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionName;", "getPermission", "()Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionName;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PermissionParamModel extends ParamModel {
        @AIBridgeParamField(keyPath = "permission", required = true)
        PermissionName getPermission();
    }

    @AIBridgeResultModel
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@gX¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionResultModel;", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "value", "Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionStatus;", NotificationCompat.CATEGORY_STATUS, "getStatus", "()Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionStatus;", "setStatus", "(Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionStatus;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface PermissionResultModel extends ResultModel {
        PermissionStatus getStatus();

        @AIBridgeParamField(keyPath = NotificationCompat.CATEGORY_STATUS, required = true)
        void setStatus(PermissionStatus r5);
    }

    @Keep
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DENIED", "PERMITTED", "UNDETERMINED", "RESTRICTED", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum PermissionStatus extends Enum<PermissionStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PermissionStatus[] $VALUES = null;

        @SerializedName("denied")
        public static final PermissionStatus DENIED = null;

        @SerializedName("permitted")
        public static final PermissionStatus PERMITTED = null;

        @SerializedName("restricted")
        public static final PermissionStatus RESTRICTED = null;

        @SerializedName("undetermined")
        public static final PermissionStatus UNDETERMINED = null;

        private static final /* synthetic */ PermissionStatus[] $values() {
            return new PermissionStatus[]{DENIED, PERMITTED, UNDETERMINED, RESTRICTED};
        }

        static {
            DENIED = new PermissionStatus("DENIED", 0);
            PERMITTED = new PermissionStatus("PERMITTED", 1);
            UNDETERMINED = new PermissionStatus("UNDETERMINED", 2);
            RESTRICTED = new PermissionStatus("RESTRICTED", 3);
            PermissionStatus[] r5 = $values();
            $VALUES = r5;
            $ENTRIES = EnumEntriesKt.enumEntries(r5);
        }

        private PermissionStatus(String r5, int r10) {
            super(r5, r10);
        }

        public static EnumEntries<PermissionStatus> getEntries() {
            return $ENTRIES;
        }

        public static PermissionStatus valueOf(String r5) {
            return (PermissionStatus) Enum.valueOf(PermissionStatus.class, r5);
        }

        public static PermissionStatus[] values() {
            return (PermissionStatus[]) $VALUES.clone();
        }
    }

    public AbsRequestPermissionMethodIDL() {
        this.name = "applet.requestPermission";
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
