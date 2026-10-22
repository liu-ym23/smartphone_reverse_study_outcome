package com.bytedance.ai.bridge.method.system.permission;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0019\b\u0002\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/permission/Permission;", "", "permission", "", "", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "getPermission", "()Ljava/util/List;", "CAMERA", "MICROPHONE", "PHOTOALBUM", "VIBRATE", "READ_CALENDAR", "WRITE_CALENDAR", "CALENDAR", "NOTIFICATION", "LOCATION", "UNKNOWN", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Permission extends Enum<Permission> {
    public static final Permission CALENDAR = null;
    public static final Permission CAMERA = null;
    public static final a Companion = null;
    public static final Permission LOCATION = null;
    public static final Permission MICROPHONE = null;
    public static final Permission NOTIFICATION = null;
    public static final Permission PHOTOALBUM = null;
    public static final Permission READ_CALENDAR = null;
    public static final Permission UNKNOWN = null;
    public static final Permission VIBRATE = null;
    public static final Permission WRITE_CALENDAR = null;
    public static final /* synthetic */ Permission[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final List<String> permission;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<Permission> getEntries() {
        return b;
    }

    static {
        Permission r0 = new Permission("CAMERA", 0, CollectionsKt.listOf("android.permission.CAMERA"));
        CAMERA = r0;
        Permission r1 = new Permission("MICROPHONE", 1, CollectionsKt.listOf("android.permission.RECORD_AUDIO"));
        MICROPHONE = r1;
        Permission r10 = new Permission("PHOTOALBUM", 2, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}));
        PHOTOALBUM = r10;
        Permission r11 = new Permission("VIBRATE", 3, CollectionsKt.listOf("android.permission.VIBRATE"));
        VIBRATE = r11;
        Permission r12 = new Permission("READ_CALENDAR", 4, CollectionsKt.listOf("android.permission.READ_CALENDAR"));
        READ_CALENDAR = r12;
        Permission r13 = new Permission("WRITE_CALENDAR", 5, CollectionsKt.listOf("android.permission.WRITE_CALENDAR"));
        WRITE_CALENDAR = r13;
        Permission r14 = new Permission("CALENDAR", 6, CollectionsKt.listOf(new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"}));
        CALENDAR = r14;
        Permission r15 = new Permission("NOTIFICATION", 7, CollectionsKt.listOf(""));
        NOTIFICATION = r15;
        Permission r16 = new Permission("LOCATION", 8, CollectionsKt.listOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}));
        LOCATION = r16;
        Permission r17 = new Permission("UNKNOWN", 9, CollectionsKt.listOf(null));
        UNKNOWN = r17;
        Permission[] r18 = {r0, r1, r10, r11, r12, r13, r14, r15, r16, r17};
        a = r18;
        b = EnumEntriesKt.enumEntries(r18);
        Companion = new a();
    }

    public static Permission[] values() {
        return (Permission[]) a.clone();
    }

    public final List<String> getPermission() {
        return this.permission;
    }

    public static Permission valueOf(String r1) {
        return (Permission) r27.a.a(Permission.class, r1);
    }

    public Permission(String r1, int r10, List r11) {
        super(r1, r10);
        this.permission = r11;
    }
}
