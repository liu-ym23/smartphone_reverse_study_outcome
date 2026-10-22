package com.ss.android.lark.officesdk.minutes.api.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/MmOfficeHardwareDeviceColor;", "", "<init>", "(Ljava/lang/String;I)V", "BLACK", "WHITE", "TITANIUM", "UNKNOWN", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final enum MmOfficeHardwareDeviceColor extends Enum<MmOfficeHardwareDeviceColor> {
    public static final MmOfficeHardwareDeviceColor BLACK = null;
    public static final MmOfficeHardwareDeviceColor TITANIUM = null;
    public static final MmOfficeHardwareDeviceColor UNKNOWN = null;
    public static final MmOfficeHardwareDeviceColor WHITE = null;
    public static final /* synthetic */ MmOfficeHardwareDeviceColor[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MmOfficeHardwareDeviceColor> getEntries() {
        return b;
    }

    static {
        MmOfficeHardwareDeviceColor r0 = new MmOfficeHardwareDeviceColor("BLACK", 0);
        BLACK = r0;
        MmOfficeHardwareDeviceColor r1 = new MmOfficeHardwareDeviceColor("WHITE", 1);
        WHITE = r1;
        MmOfficeHardwareDeviceColor r3 = new MmOfficeHardwareDeviceColor("TITANIUM", 2);
        TITANIUM = r3;
        MmOfficeHardwareDeviceColor r5 = new MmOfficeHardwareDeviceColor("UNKNOWN", 3);
        UNKNOWN = r5;
        MmOfficeHardwareDeviceColor[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static MmOfficeHardwareDeviceColor[] values() {
        return (MmOfficeHardwareDeviceColor[]) a.clone();
    }

    public static MmOfficeHardwareDeviceColor valueOf(String r1) {
        return (MmOfficeHardwareDeviceColor) r27.a.a(MmOfficeHardwareDeviceColor.class, r1);
    }

    public MmOfficeHardwareDeviceColor(String r1, int r2) {
        super(r1, r2);
    }
}
