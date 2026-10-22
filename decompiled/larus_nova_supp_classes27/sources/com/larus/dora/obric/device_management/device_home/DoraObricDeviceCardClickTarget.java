package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceCardClickTarget;", "", "<init>", "(Ljava/lang/String;I)V", "CARD", "MODE_ENTRY", "SETTINGS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceCardClickTarget extends Enum<DoraObricDeviceCardClickTarget> {
    public static final DoraObricDeviceCardClickTarget CARD = null;
    public static final DoraObricDeviceCardClickTarget MODE_ENTRY = null;
    public static final DoraObricDeviceCardClickTarget SETTINGS = null;
    public static final /* synthetic */ DoraObricDeviceCardClickTarget[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricDeviceCardClickTarget> getEntries() {
        return b;
    }

    static {
        DoraObricDeviceCardClickTarget r0 = new DoraObricDeviceCardClickTarget("CARD", 0);
        CARD = r0;
        DoraObricDeviceCardClickTarget r1 = new DoraObricDeviceCardClickTarget("MODE_ENTRY", 1);
        MODE_ENTRY = r1;
        DoraObricDeviceCardClickTarget r3 = new DoraObricDeviceCardClickTarget("SETTINGS", 2);
        SETTINGS = r3;
        DoraObricDeviceCardClickTarget[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoraObricDeviceCardClickTarget[] values() {
        return (DoraObricDeviceCardClickTarget[]) a.clone();
    }

    public static DoraObricDeviceCardClickTarget valueOf(String r1) {
        return (DoraObricDeviceCardClickTarget) r27.a.a(DoraObricDeviceCardClickTarget.class, r1);
    }

    public DoraObricDeviceCardClickTarget(String r1, int r2) {
        super(r1, r2);
    }
}
