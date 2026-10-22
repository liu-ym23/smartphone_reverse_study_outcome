package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceCardClickAction;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "OPEN_SETTINGS", "OPEN_MODE_SHEET", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceCardClickAction extends Enum<DoraObricDeviceCardClickAction> {
    public static final DoraObricDeviceCardClickAction NONE = null;
    public static final DoraObricDeviceCardClickAction OPEN_MODE_SHEET = null;
    public static final DoraObricDeviceCardClickAction OPEN_SETTINGS = null;
    public static final /* synthetic */ DoraObricDeviceCardClickAction[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricDeviceCardClickAction> getEntries() {
        return b;
    }

    static {
        DoraObricDeviceCardClickAction r0 = new DoraObricDeviceCardClickAction("NONE", 0);
        NONE = r0;
        DoraObricDeviceCardClickAction r1 = new DoraObricDeviceCardClickAction("OPEN_SETTINGS", 1);
        OPEN_SETTINGS = r1;
        DoraObricDeviceCardClickAction r3 = new DoraObricDeviceCardClickAction("OPEN_MODE_SHEET", 2);
        OPEN_MODE_SHEET = r3;
        DoraObricDeviceCardClickAction[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoraObricDeviceCardClickAction[] values() {
        return (DoraObricDeviceCardClickAction[]) a.clone();
    }

    public static DoraObricDeviceCardClickAction valueOf(String r1) {
        return (DoraObricDeviceCardClickAction) r27.a.a(DoraObricDeviceCardClickAction.class, r1);
    }

    public DoraObricDeviceCardClickAction(String r1, int r2) {
        super(r1, r2);
    }
}
