package com.larus.drive.sdk.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/drive/sdk/api/DrivePickerScene;", "", "<init>", "(Ljava/lang/String;I)V", "FINDER", "FILE_SELECTOR", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DrivePickerScene extends Enum<DrivePickerScene> {
    public static final DrivePickerScene FILE_SELECTOR = null;
    public static final DrivePickerScene FINDER = null;
    public static final /* synthetic */ DrivePickerScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DrivePickerScene> getEntries() {
        return b;
    }

    static {
        DrivePickerScene r0 = new DrivePickerScene("FINDER", 0);
        FINDER = r0;
        DrivePickerScene r1 = new DrivePickerScene("FILE_SELECTOR", 1);
        FILE_SELECTOR = r1;
        DrivePickerScene[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DrivePickerScene[] values() {
        return (DrivePickerScene[]) a.clone();
    }

    public static DrivePickerScene valueOf(String r1) {
        return (DrivePickerScene) a.a(DrivePickerScene.class, r1);
    }

    public DrivePickerScene(String r1, int r2) {
        super(r1, r2);
    }
}
