package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemory;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "DISABLED", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemory extends Enum<DoraObricEnvironmentMemory> {
    public static final DoraObricEnvironmentMemory DISABLED = null;
    public static final DoraObricEnvironmentMemory ENABLED = null;
    public static final DoraObricEnvironmentMemory UNKNOWN = null;
    public static final /* synthetic */ DoraObricEnvironmentMemory[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricEnvironmentMemory> getEntries() {
        return b;
    }

    static {
        DoraObricEnvironmentMemory r0 = new DoraObricEnvironmentMemory("ENABLED", 0);
        ENABLED = r0;
        DoraObricEnvironmentMemory r1 = new DoraObricEnvironmentMemory("DISABLED", 1);
        DISABLED = r1;
        DoraObricEnvironmentMemory r3 = new DoraObricEnvironmentMemory("UNKNOWN", 2);
        UNKNOWN = r3;
        DoraObricEnvironmentMemory[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoraObricEnvironmentMemory[] values() {
        return (DoraObricEnvironmentMemory[]) a.clone();
    }

    public static DoraObricEnvironmentMemory valueOf(String r1) {
        return (DoraObricEnvironmentMemory) r27.a.a(DoraObricEnvironmentMemory.class, r1);
    }

    public DoraObricEnvironmentMemory(String r1, int r2) {
        super(r1, r2);
    }
}
