package com.ss.android.lark.officesdk.minutes.api.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeHardwareStateType;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CONNECTING", "BT_CONNECTING", "PARTIAL_CONNECTED", "CONNECTED", "DISCONNECTED", "FAILED", "OTHER", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmOfficeHardwareStateType extends Enum<MmOfficeHardwareStateType> {
    public static final MmOfficeHardwareStateType BT_CONNECTING = null;
    public static final MmOfficeHardwareStateType CONNECTED = null;
    public static final MmOfficeHardwareStateType CONNECTING = null;
    public static final MmOfficeHardwareStateType DISCONNECTED = null;
    public static final MmOfficeHardwareStateType FAILED = null;
    public static final MmOfficeHardwareStateType IDLE = null;
    public static final MmOfficeHardwareStateType OTHER = null;
    public static final MmOfficeHardwareStateType PARTIAL_CONNECTED = null;
    public static final /* synthetic */ MmOfficeHardwareStateType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmOfficeHardwareStateType> getEntries() {
        return b;
    }

    static {
        MmOfficeHardwareStateType r0 = new MmOfficeHardwareStateType("IDLE", 0);
        IDLE = r0;
        MmOfficeHardwareStateType r1 = new MmOfficeHardwareStateType("CONNECTING", 1);
        CONNECTING = r1;
        MmOfficeHardwareStateType r3 = new MmOfficeHardwareStateType("BT_CONNECTING", 2);
        BT_CONNECTING = r3;
        MmOfficeHardwareStateType r5 = new MmOfficeHardwareStateType("PARTIAL_CONNECTED", 3);
        PARTIAL_CONNECTED = r5;
        MmOfficeHardwareStateType r7 = new MmOfficeHardwareStateType("CONNECTED", 4);
        CONNECTED = r7;
        MmOfficeHardwareStateType r9 = new MmOfficeHardwareStateType("DISCONNECTED", 5);
        DISCONNECTED = r9;
        MmOfficeHardwareStateType r11 = new MmOfficeHardwareStateType("FAILED", 6);
        FAILED = r11;
        MmOfficeHardwareStateType r13 = new MmOfficeHardwareStateType("OTHER", 7);
        OTHER = r13;
        MmOfficeHardwareStateType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static MmOfficeHardwareStateType[] values() {
        return (MmOfficeHardwareStateType[]) a.clone();
    }

    public static MmOfficeHardwareStateType valueOf(String r1) {
        return (MmOfficeHardwareStateType) r27.a.a(MmOfficeHardwareStateType.class, r1);
    }

    public MmOfficeHardwareStateType(String r1, int r2) {
        super(r1, r2);
    }
}
