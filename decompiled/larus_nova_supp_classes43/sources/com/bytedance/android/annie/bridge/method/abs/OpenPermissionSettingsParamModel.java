package com.bytedance.android.annie.bridge.method.abs;

import com.bytedance.android.annie.bridge.method.util.EnumJsonAdapter;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/OpenPermissionSettingsParamModel;", "", "Lcom/bytedance/android/annie/bridge/method/abs/OpenPermissionSettingsParamModel$Permission;", "permission", "Lcom/bytedance/android/annie/bridge/method/abs/OpenPermissionSettingsParamModel$Permission;", "a", "()Lcom/bytedance/android/annie/bridge/method/abs/OpenPermissionSettingsParamModel$Permission;", "setPermission", "(Lcom/bytedance/android/annie/bridge/method/abs/OpenPermissionSettingsParamModel$Permission;)V", "<init>", "()V", "Permission", "PermissionAdapter", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class OpenPermissionSettingsParamModel {

    @SerializedName("permission")
    @JsonAdapter(PermissionAdapter.class)
    private Permission permission;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/OpenPermissionSettingsParamModel$Permission;", "", "", "toString", "Companion", "a", "Camera", "Microphone", "PhotoAlbum", "Vibrate", "Notification", "Location", "Calendar", "ReadCalendar", "WriteCalendar", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Permission extends Enum<Permission> {
        public static final Permission Calendar = null;
        public static final Permission Camera = null;
        public static final a Companion = null;
        public static final Permission Location = null;
        public static final Permission Microphone = null;
        public static final Permission Notification = null;
        public static final Permission PhotoAlbum = null;
        public static final Permission ReadCalendar = null;
        public static final Permission Vibrate = null;
        public static final Permission WriteCalendar = null;
        public static final /* synthetic */ Permission[] a = null;

        public static final class a {
            public a() {
            }
        }

        public static Permission valueOf(String r1) {
            return (Permission) r27.a.a(Permission.class, r1);
        }

        public static Permission[] values() {
            return (Permission[]) a.clone();
        }

        static {
            Permission r0 = new Permission("Camera", 0);
            Camera = r0;
            Permission r1 = new Permission("Microphone", 1);
            Microphone = r1;
            Permission r10 = new Permission("PhotoAlbum", 2);
            PhotoAlbum = r10;
            Permission r11 = new Permission("Vibrate", 3);
            Vibrate = r11;
            Permission r12 = new Permission("Notification", 4);
            Notification = r12;
            Permission r13 = new Permission("Location", 5);
            Location = r13;
            Permission r14 = new Permission("Calendar", 6);
            Calendar = r14;
            Permission r15 = new Permission("ReadCalendar", 7);
            ReadCalendar = r15;
            Permission r16 = new Permission("WriteCalendar", 8);
            WriteCalendar = r16;
            a = new Permission[]{r0, r1, r10, r11, r12, r13, r14, r15, r16};
            Companion = new a();
        }

        @Override // java.lang.Enum
        public String toString() {
            if (this != Camera) goto L6;
            return "camera";
        L6:
            if (this != Microphone) goto L9;
            return "microphone";
        L9:
            if (this != PhotoAlbum) goto L12;
            return "photoAlbum";
        L12:
            if (this != Vibrate) goto L15;
            return "vibrate";
        L15:
            if (this != Notification) goto L18;
            return "notification";
        L18:
            if (this != Location) goto L21;
            return com.bytedance.android.ec.core.event.a.KEY_LOCATION;
        L21:
            if (this != Calendar) goto L24;
            return "calendar";
        L24:
            if (this != ReadCalendar) goto L27;
            return "read_calendar";
        L27:
            if (this != WriteCalendar) goto L29;
            return "write_calendar";
        L29:
            return "";
        }

        public Permission(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/OpenPermissionSettingsParamModel$PermissionAdapter;", "Lcom/bytedance/android/annie/bridge/method/util/EnumJsonAdapter;", "Lcom/bytedance/android/annie/bridge/method/abs/OpenPermissionSettingsParamModel$Permission;", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class PermissionAdapter extends EnumJsonAdapter<Permission> {
        public PermissionAdapter() {
        }

        public final Object read(JsonReader r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            if (r10.peek() != JsonToken.NULL) goto L7;
            r10.nextNull();
            return null;
        L7:
            String r11 = r10.nextString();
            Permission.Companion.getClass();
            Intrinsics.checkNotNullParameter(r11, "permission");
            if (StringsKt.equals(r11, "camera", true) == false) goto L11;
            return Permission.Camera;
        L11:
            if (StringsKt.equals(r11, "microphone", true) == false) goto L14;
            return Permission.Microphone;
        L14:
            if (StringsKt.equals(r11, "photoAlbum", true) == false) goto L17;
            return Permission.PhotoAlbum;
        L17:
            if (StringsKt.equals(r11, "vibrate", true) == false) goto L20;
            return Permission.Vibrate;
        L20:
            if (StringsKt.equals(r11, "notification", true) == false) goto L23;
            return Permission.Notification;
        L23:
            if (StringsKt.equals(r11, a.KEY_LOCATION, true) == false) goto L26;
            return Permission.Location;
        L26:
            if (StringsKt.equals(r11, "calendar", true) == false) goto L29;
            return Permission.Calendar;
        L29:
            if (StringsKt.equals(r11, "read_calendar", true) == false) goto L32;
            return Permission.ReadCalendar;
        L32:
            if (StringsKt.equals(r11, "write_calendar", true) == true) goto L34;
            return null;
        L34:
            return Permission.WriteCalendar;
        }
    }

    public OpenPermissionSettingsParamModel() {
    }

    public final Permission a() {
        return this.permission;
    }
}
