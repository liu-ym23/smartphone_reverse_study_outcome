package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryToastType;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "TEMPORARY_OVERRIDE", "UNAVAILABLE", "SWITCH_OPEN_NETWORK_ERROR", "NONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryToastType extends Enum<DoraObricEnvironmentMemoryToastType> {
    public static final DoraObricEnvironmentMemoryToastType ENABLED = null;
    public static final DoraObricEnvironmentMemoryToastType NONE = null;
    public static final DoraObricEnvironmentMemoryToastType SWITCH_OPEN_NETWORK_ERROR = null;
    public static final DoraObricEnvironmentMemoryToastType TEMPORARY_OVERRIDE = null;
    public static final DoraObricEnvironmentMemoryToastType UNAVAILABLE = null;
    public static final /* synthetic */ DoraObricEnvironmentMemoryToastType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryToastType> getEntries() {
        return b;
    }

    static {
        DoraObricEnvironmentMemoryToastType r0 = new DoraObricEnvironmentMemoryToastType("ENABLED", 0);
        ENABLED = r0;
        DoraObricEnvironmentMemoryToastType r1 = new DoraObricEnvironmentMemoryToastType("TEMPORARY_OVERRIDE", 1);
        TEMPORARY_OVERRIDE = r1;
        DoraObricEnvironmentMemoryToastType r3 = new DoraObricEnvironmentMemoryToastType("UNAVAILABLE", 2);
        UNAVAILABLE = r3;
        DoraObricEnvironmentMemoryToastType r5 = new DoraObricEnvironmentMemoryToastType("SWITCH_OPEN_NETWORK_ERROR", 3);
        SWITCH_OPEN_NETWORK_ERROR = r5;
        DoraObricEnvironmentMemoryToastType r7 = new DoraObricEnvironmentMemoryToastType("NONE", 4);
        NONE = r7;
        DoraObricEnvironmentMemoryToastType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static DoraObricEnvironmentMemoryToastType[] values() {
        return (DoraObricEnvironmentMemoryToastType[]) a.clone();
    }

    public static DoraObricEnvironmentMemoryToastType valueOf(String r1) {
        return (DoraObricEnvironmentMemoryToastType) r27.a.a(DoraObricEnvironmentMemoryToastType.class, r1);
    }

    public DoraObricEnvironmentMemoryToastType(String r1, int r2) {
        super(r1, r2);
    }
}
