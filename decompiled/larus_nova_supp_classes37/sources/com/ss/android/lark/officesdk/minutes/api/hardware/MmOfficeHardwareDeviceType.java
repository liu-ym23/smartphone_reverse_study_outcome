package com.ss.android.lark.officesdk.minutes.api.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeHardwareDeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "D3200", "D1204", "UNKNOWN", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmOfficeHardwareDeviceType extends Enum<MmOfficeHardwareDeviceType> {
    public static final MmOfficeHardwareDeviceType D1204 = null;
    public static final MmOfficeHardwareDeviceType D3200 = null;
    public static final MmOfficeHardwareDeviceType UNKNOWN = null;
    public static final /* synthetic */ MmOfficeHardwareDeviceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmOfficeHardwareDeviceType> getEntries() {
        return b;
    }

    static {
        MmOfficeHardwareDeviceType r0 = new MmOfficeHardwareDeviceType("D3200", 0);
        D3200 = r0;
        MmOfficeHardwareDeviceType r1 = new MmOfficeHardwareDeviceType("D1204", 1);
        D1204 = r1;
        MmOfficeHardwareDeviceType r3 = new MmOfficeHardwareDeviceType("UNKNOWN", 2);
        UNKNOWN = r3;
        MmOfficeHardwareDeviceType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MmOfficeHardwareDeviceType[] values() {
        return (MmOfficeHardwareDeviceType[]) a.clone();
    }

    public static MmOfficeHardwareDeviceType valueOf(String r1) {
        return (MmOfficeHardwareDeviceType) r27.a.a(MmOfficeHardwareDeviceType.class, r1);
    }

    public MmOfficeHardwareDeviceType(String r1, int r2) {
        super(r1, r2);
    }
}
