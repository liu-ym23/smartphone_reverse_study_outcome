package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeIndicator;", "", "<init>", "(Ljava/lang/String;I)V", "ASSISTANT_MEMORY_OFF", "ASSISTANT_MEMORY_ON", "HEADPHONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceModeIndicator extends Enum<DoraObricDeviceModeIndicator> {
    public static final DoraObricDeviceModeIndicator ASSISTANT_MEMORY_OFF = null;
    public static final DoraObricDeviceModeIndicator ASSISTANT_MEMORY_ON = null;
    public static final DoraObricDeviceModeIndicator HEADPHONE = null;
    public static final /* synthetic */ DoraObricDeviceModeIndicator[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricDeviceModeIndicator> getEntries() {
        return b;
    }

    static {
        DoraObricDeviceModeIndicator r0 = new DoraObricDeviceModeIndicator("ASSISTANT_MEMORY_OFF", 0);
        ASSISTANT_MEMORY_OFF = r0;
        DoraObricDeviceModeIndicator r1 = new DoraObricDeviceModeIndicator("ASSISTANT_MEMORY_ON", 1);
        ASSISTANT_MEMORY_ON = r1;
        DoraObricDeviceModeIndicator r3 = new DoraObricDeviceModeIndicator("HEADPHONE", 2);
        HEADPHONE = r3;
        DoraObricDeviceModeIndicator[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoraObricDeviceModeIndicator[] values() {
        return (DoraObricDeviceModeIndicator[]) a.clone();
    }

    public static DoraObricDeviceModeIndicator valueOf(String r1) {
        return (DoraObricDeviceModeIndicator) r27.a.a(DoraObricDeviceModeIndicator.class, r1);
    }

    public DoraObricDeviceModeIndicator(String r1, int r2) {
        super(r1, r2);
    }
}
