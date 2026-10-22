package com.larus.drive.biz.impl.view.fileselect;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/drive/biz/impl/view/fileselect/DriveSelectActionType;", "", "<init>", "(Ljava/lang/String;I)V", "ASK_AI", "SHARE", "DOWNLOAD", "RENAME", "MOVE", "DELETE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveSelectActionType extends Enum<DriveSelectActionType> {
    public static final DriveSelectActionType ASK_AI = null;
    public static final DriveSelectActionType DELETE = null;
    public static final DriveSelectActionType DOWNLOAD = null;
    public static final DriveSelectActionType MOVE = null;
    public static final DriveSelectActionType RENAME = null;
    public static final DriveSelectActionType SHARE = null;
    public static final /* synthetic */ DriveSelectActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DriveSelectActionType> getEntries() {
        return b;
    }

    static {
        DriveSelectActionType r0 = new DriveSelectActionType("ASK_AI", 0);
        ASK_AI = r0;
        DriveSelectActionType r1 = new DriveSelectActionType("SHARE", 1);
        SHARE = r1;
        DriveSelectActionType r3 = new DriveSelectActionType("DOWNLOAD", 2);
        DOWNLOAD = r3;
        DriveSelectActionType r5 = new DriveSelectActionType("RENAME", 3);
        RENAME = r5;
        DriveSelectActionType r7 = new DriveSelectActionType("MOVE", 4);
        MOVE = r7;
        DriveSelectActionType r9 = new DriveSelectActionType("DELETE", 5);
        DELETE = r9;
        DriveSelectActionType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static DriveSelectActionType[] values() {
        return (DriveSelectActionType[]) a.clone();
    }

    public static DriveSelectActionType valueOf(String r1) {
        return (DriveSelectActionType) a.a(DriveSelectActionType.class, r1);
    }

    public DriveSelectActionType(String r1, int r2) {
        super(r1, r2);
    }
}
