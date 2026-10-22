package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeDeviceCardType;", "", "<init>", "(Ljava/lang/String;I)V", "GLASSES", "EARBUDS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceHomeDeviceCardType extends Enum<DoraObricDeviceHomeDeviceCardType> {
    public static final DoraObricDeviceHomeDeviceCardType EARBUDS = null;
    public static final DoraObricDeviceHomeDeviceCardType GLASSES = null;
    public static final /* synthetic */ DoraObricDeviceHomeDeviceCardType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricDeviceHomeDeviceCardType> getEntries() {
        return b;
    }

    static {
        DoraObricDeviceHomeDeviceCardType r0 = new DoraObricDeviceHomeDeviceCardType("GLASSES", 0);
        GLASSES = r0;
        DoraObricDeviceHomeDeviceCardType r1 = new DoraObricDeviceHomeDeviceCardType("EARBUDS", 1);
        EARBUDS = r1;
        DoraObricDeviceHomeDeviceCardType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DoraObricDeviceHomeDeviceCardType[] values() {
        return (DoraObricDeviceHomeDeviceCardType[]) a.clone();
    }

    public static DoraObricDeviceHomeDeviceCardType valueOf(String r1) {
        return (DoraObricDeviceHomeDeviceCardType) r27.a.a(DoraObricDeviceHomeDeviceCardType.class, r1);
    }

    public DoraObricDeviceHomeDeviceCardType(String r1, int r2) {
        super(r1, r2);
    }
}
