package com.larus.bmhome.chat.model.strategy.block;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/chat/model/strategy/block/PermissionType;", "", "permissionName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPermissionName", "()Ljava/lang/String;", "PERMISSION_TYPE_UNSPECIFIED", "FINE_LOCATION", "COARSE_LOCATION", "ALWAYS_BACKGROUND_LOCATION", "RECORD_AUDIO", "BLUETOOTH", "CAMERA", "WRITE_CONTACTS", "CALENDAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum PermissionType extends Enum<PermissionType> {
    public static final PermissionType ALWAYS_BACKGROUND_LOCATION = null;
    public static final PermissionType BLUETOOTH = null;
    public static final PermissionType CALENDAR = null;
    public static final PermissionType CAMERA = null;
    public static final PermissionType COARSE_LOCATION = null;
    public static final PermissionType FINE_LOCATION = null;
    public static final PermissionType PERMISSION_TYPE_UNSPECIFIED = null;
    public static final PermissionType RECORD_AUDIO = null;
    public static final PermissionType WRITE_CONTACTS = null;
    public static final /* synthetic */ PermissionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String permissionName;

    public static EnumEntries<PermissionType> getEntries() {
        return b;
    }

    static {
        PermissionType r0 = new PermissionType("PERMISSION_TYPE_UNSPECIFIED", 0, "ACCESS_UNSPECIFIED");
        PERMISSION_TYPE_UNSPECIFIED = r0;
        PermissionType r1 = new PermissionType("FINE_LOCATION", 1, "ACCESS_FINE_LOCATION");
        FINE_LOCATION = r1;
        PermissionType r2 = new PermissionType("COARSE_LOCATION", 2, "ACCESS_COARSE_LOCATION");
        COARSE_LOCATION = r2;
        PermissionType r4 = new PermissionType("ALWAYS_BACKGROUND_LOCATION", 3, "ACCESS_BACKGROUND_LOCATION");
        ALWAYS_BACKGROUND_LOCATION = r4;
        PermissionType r6 = new PermissionType("RECORD_AUDIO", 4, "RECORD_AUDIO");
        RECORD_AUDIO = r6;
        PermissionType r8 = new PermissionType("BLUETOOTH", 5, "BLUETOOTH");
        BLUETOOTH = r8;
        PermissionType r11 = new PermissionType("CAMERA", 6, "CAMERA");
        CAMERA = r11;
        PermissionType r13 = new PermissionType("WRITE_CONTACTS", 7, "WRITE_CONTACTS");
        WRITE_CONTACTS = r13;
        PermissionType r15 = new PermissionType("CALENDAR", 8, "CALENDAR");
        CALENDAR = r15;
        PermissionType[] r14 = {r0, r1, r2, r4, r6, r8, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static PermissionType[] values() {
        return (PermissionType[]) a.clone();
    }

    public final String getPermissionName() {
        return this.permissionName;
    }

    public static PermissionType valueOf(String r1) {
        return (PermissionType) r27.a.a(PermissionType.class, r1);
    }

    public PermissionType(String r1, int r2, String r3) {
        super(r1, r2);
        this.permissionName = r3;
    }
}
