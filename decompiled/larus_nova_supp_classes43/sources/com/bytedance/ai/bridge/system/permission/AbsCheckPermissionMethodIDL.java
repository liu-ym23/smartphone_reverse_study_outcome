package com.bytedance.ai.bridge.system.permission;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\n\u000b\f\rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/system/permission/AbsCheckPermissionMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/system/permission/AbsCheckPermissionMethodIDL$PermissionParamModel;", "Lcom/bytedance/ai/bridge/system/permission/AbsCheckPermissionMethodIDL$PermissionResultModel;", "<init>", "()V", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "getName", "()Ljava/lang/String;", "PermissionParamModel", "PermissionResultModel", "PermissionName", "PermissionStatus", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCheckPermissionMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/system/permission/AbsCheckPermissionMethodIDL$PermissionName;", "", "<init>", "(Ljava/lang/String;I)V", "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "READ_CALENDAR", "WRITE_CALENDAR", "CALENDAR", "NOTIFICATION", "LOCATION", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PermissionName extends Enum<PermissionName> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ PermissionName[] $VALUES = null;

        @SerializedName("calendar")
        public static final PermissionName CALENDAR = null;

        @SerializedName("camera")
        public static final PermissionName CAMERA = null;

        @SerializedName(com.bytedance.android.ec.core.event.a.KEY_LOCATION)
        public static final PermissionName LOCATION = null;

        @SerializedName("microphone")
        public static final PermissionName MICROPHONE = null;

        @SerializedName("notification")
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

        public static EnumEntries<PermissionName> getEntries() {
            return $ENTRIES;
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
            PermissionName[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static PermissionName[] values() {
            return (PermissionName[]) $VALUES.clone();
        }

        public static PermissionName valueOf(String r1) {
            return (PermissionName) r27.a.a(PermissionName.class, r1);
        }

        private PermissionName(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/system/permission/AbsCheckPermissionMethodIDL$PermissionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DENIED", "PERMITTED", "UNDETERMINED", "RESTRICTED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

        public static EnumEntries<PermissionStatus> getEntries() {
            return $ENTRIES;
        }

        static {
            DENIED = new PermissionStatus("DENIED", 0);
            PERMITTED = new PermissionStatus("PERMITTED", 1);
            UNDETERMINED = new PermissionStatus("UNDETERMINED", 2);
            RESTRICTED = new PermissionStatus("RESTRICTED", 3);
            PermissionStatus[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static PermissionStatus[] values() {
            return (PermissionStatus[]) $VALUES.clone();
        }

        public static PermissionStatus valueOf(String r1) {
            return (PermissionStatus) r27.a.a(PermissionStatus.class, r1);
        }

        private PermissionStatus(String r1, int r10) {
            super(r1, r10);
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "permission", required = true)
        PermissionName getPermission();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = com.bytedance.android.ec.core.event.a.KEY_STATUS, required = true)
        void setStatus(PermissionStatus r1);
    }

    public AbsCheckPermissionMethodIDL() {
        this.a = "applet.checkPermission";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.a;
    }
}
