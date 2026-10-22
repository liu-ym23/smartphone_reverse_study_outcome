package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryLabel;", "", "<init>", "(Ljava/lang/String;I)V", "ON", "OFF", "UNAVAILABLE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryLabel extends Enum<DoraObricEnvironmentMemoryLabel> {
    public static final DoraObricEnvironmentMemoryLabel OFF = null;
    public static final DoraObricEnvironmentMemoryLabel ON = null;
    public static final DoraObricEnvironmentMemoryLabel UNAVAILABLE = null;
    public static final /* synthetic */ DoraObricEnvironmentMemoryLabel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryLabel> getEntries() {
        return b;
    }

    static {
        DoraObricEnvironmentMemoryLabel r0 = new DoraObricEnvironmentMemoryLabel("ON", 0);
        ON = r0;
        DoraObricEnvironmentMemoryLabel r1 = new DoraObricEnvironmentMemoryLabel("OFF", 1);
        OFF = r1;
        DoraObricEnvironmentMemoryLabel r3 = new DoraObricEnvironmentMemoryLabel("UNAVAILABLE", 2);
        UNAVAILABLE = r3;
        DoraObricEnvironmentMemoryLabel[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoraObricEnvironmentMemoryLabel[] values() {
        return (DoraObricEnvironmentMemoryLabel[]) a.clone();
    }

    public static DoraObricEnvironmentMemoryLabel valueOf(String r1) {
        return (DoraObricEnvironmentMemoryLabel) r27.a.a(DoraObricEnvironmentMemoryLabel.class, r1);
    }

    public DoraObricEnvironmentMemoryLabel(String r1, int r2) {
        super(r1, r2);
    }
}
