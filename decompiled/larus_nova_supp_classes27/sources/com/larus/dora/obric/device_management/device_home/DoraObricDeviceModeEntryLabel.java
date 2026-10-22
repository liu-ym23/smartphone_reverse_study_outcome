package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeEntryLabel;", "", "<init>", "(Ljava/lang/String;I)V", "ASSISTANT", "HEADPHONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceModeEntryLabel extends Enum<DoraObricDeviceModeEntryLabel> {
    public static final DoraObricDeviceModeEntryLabel ASSISTANT = null;
    public static final DoraObricDeviceModeEntryLabel HEADPHONE = null;
    public static final /* synthetic */ DoraObricDeviceModeEntryLabel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricDeviceModeEntryLabel> getEntries() {
        return b;
    }

    static {
        DoraObricDeviceModeEntryLabel r0 = new DoraObricDeviceModeEntryLabel("ASSISTANT", 0);
        ASSISTANT = r0;
        DoraObricDeviceModeEntryLabel r1 = new DoraObricDeviceModeEntryLabel("HEADPHONE", 1);
        HEADPHONE = r1;
        DoraObricDeviceModeEntryLabel[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DoraObricDeviceModeEntryLabel[] values() {
        return (DoraObricDeviceModeEntryLabel[]) a.clone();
    }

    public static DoraObricDeviceModeEntryLabel valueOf(String r1) {
        return (DoraObricDeviceModeEntryLabel) r27.a.a(DoraObricDeviceModeEntryLabel.class, r1);
    }

    public DoraObricDeviceModeEntryLabel(String r1, int r2) {
        super(r1, r2);
    }
}
