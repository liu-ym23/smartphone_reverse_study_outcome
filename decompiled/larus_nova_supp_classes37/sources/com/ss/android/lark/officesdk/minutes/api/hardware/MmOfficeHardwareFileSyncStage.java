package com.ss.android.lark.officesdk.minutes.api.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeHardwareFileSyncStage;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "TRANSFERRING", "UPLOADING", "PROCESSING", "COMPLETED", "FAILED", "CANCELLED", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmOfficeHardwareFileSyncStage extends Enum<MmOfficeHardwareFileSyncStage> {
    public static final MmOfficeHardwareFileSyncStage CANCELLED = null;
    public static final MmOfficeHardwareFileSyncStage COMPLETED = null;
    public static final MmOfficeHardwareFileSyncStage FAILED = null;
    public static final MmOfficeHardwareFileSyncStage PROCESSING = null;
    public static final MmOfficeHardwareFileSyncStage TRANSFERRING = null;
    public static final MmOfficeHardwareFileSyncStage UNKNOWN = null;
    public static final MmOfficeHardwareFileSyncStage UPLOADING = null;
    public static final /* synthetic */ MmOfficeHardwareFileSyncStage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmOfficeHardwareFileSyncStage> getEntries() {
        return b;
    }

    static {
        MmOfficeHardwareFileSyncStage r0 = new MmOfficeHardwareFileSyncStage("UNKNOWN", 0);
        UNKNOWN = r0;
        MmOfficeHardwareFileSyncStage r1 = new MmOfficeHardwareFileSyncStage("TRANSFERRING", 1);
        TRANSFERRING = r1;
        MmOfficeHardwareFileSyncStage r3 = new MmOfficeHardwareFileSyncStage("UPLOADING", 2);
        UPLOADING = r3;
        MmOfficeHardwareFileSyncStage r5 = new MmOfficeHardwareFileSyncStage("PROCESSING", 3);
        PROCESSING = r5;
        MmOfficeHardwareFileSyncStage r7 = new MmOfficeHardwareFileSyncStage("COMPLETED", 4);
        COMPLETED = r7;
        MmOfficeHardwareFileSyncStage r9 = new MmOfficeHardwareFileSyncStage("FAILED", 5);
        FAILED = r9;
        MmOfficeHardwareFileSyncStage r11 = new MmOfficeHardwareFileSyncStage("CANCELLED", 6);
        CANCELLED = r11;
        MmOfficeHardwareFileSyncStage[] r13 = {r0, r1, r3, r5, r7, r9, r11};
        a = r13;
        b = EnumEntriesKt.enumEntries(r13);
    }

    public static MmOfficeHardwareFileSyncStage[] values() {
        return (MmOfficeHardwareFileSyncStage[]) a.clone();
    }

    public static MmOfficeHardwareFileSyncStage valueOf(String r1) {
        return (MmOfficeHardwareFileSyncStage) r27.a.a(MmOfficeHardwareFileSyncStage.class, r1);
    }

    public MmOfficeHardwareFileSyncStage(String r1, int r2) {
        super(r1, r2);
    }
}
