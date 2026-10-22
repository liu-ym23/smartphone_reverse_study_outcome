package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceModeEntryProduct;", "", "<init>", "(Ljava/lang/String;I)V", "G1", "G2", "G_AIR", "G_PIN", "UNSUPPORTED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricDeviceModeEntryProduct extends Enum<DoraObricDeviceModeEntryProduct> {
    public static final DoraObricDeviceModeEntryProduct G1 = null;
    public static final DoraObricDeviceModeEntryProduct G2 = null;
    public static final DoraObricDeviceModeEntryProduct G_AIR = null;
    public static final DoraObricDeviceModeEntryProduct G_PIN = null;
    public static final DoraObricDeviceModeEntryProduct UNSUPPORTED = null;
    public static final /* synthetic */ DoraObricDeviceModeEntryProduct[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricDeviceModeEntryProduct> getEntries() {
        return b;
    }

    static {
        DoraObricDeviceModeEntryProduct r0 = new DoraObricDeviceModeEntryProduct("G1", 0);
        G1 = r0;
        DoraObricDeviceModeEntryProduct r1 = new DoraObricDeviceModeEntryProduct("G2", 1);
        G2 = r1;
        DoraObricDeviceModeEntryProduct r3 = new DoraObricDeviceModeEntryProduct("G_AIR", 2);
        G_AIR = r3;
        DoraObricDeviceModeEntryProduct r5 = new DoraObricDeviceModeEntryProduct("G_PIN", 3);
        G_PIN = r5;
        DoraObricDeviceModeEntryProduct r7 = new DoraObricDeviceModeEntryProduct("UNSUPPORTED", 4);
        UNSUPPORTED = r7;
        DoraObricDeviceModeEntryProduct[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static DoraObricDeviceModeEntryProduct[] values() {
        return (DoraObricDeviceModeEntryProduct[]) a.clone();
    }

    public static DoraObricDeviceModeEntryProduct valueOf(String r1) {
        return (DoraObricDeviceModeEntryProduct) r27.a.a(DoraObricDeviceModeEntryProduct.class, r1);
    }

    public DoraObricDeviceModeEntryProduct(String r1, int r2) {
        super(r1, r2);
    }
}
