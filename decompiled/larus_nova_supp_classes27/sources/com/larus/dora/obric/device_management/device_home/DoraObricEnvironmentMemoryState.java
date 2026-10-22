package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryState;", "", "<init>", "(Ljava/lang/String;I)V", "WORKING", "OFF", "UNAVAILABLE", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryState extends Enum<DoraObricEnvironmentMemoryState> {
    public static final DoraObricEnvironmentMemoryState OFF = null;
    public static final DoraObricEnvironmentMemoryState UNAVAILABLE = null;
    public static final DoraObricEnvironmentMemoryState UNKNOWN = null;
    public static final DoraObricEnvironmentMemoryState WORKING = null;
    public static final /* synthetic */ DoraObricEnvironmentMemoryState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryState> getEntries() {
        return b;
    }

    static {
        DoraObricEnvironmentMemoryState r0 = new DoraObricEnvironmentMemoryState("WORKING", 0);
        WORKING = r0;
        DoraObricEnvironmentMemoryState r1 = new DoraObricEnvironmentMemoryState("OFF", 1);
        OFF = r1;
        DoraObricEnvironmentMemoryState r3 = new DoraObricEnvironmentMemoryState("UNAVAILABLE", 2);
        UNAVAILABLE = r3;
        DoraObricEnvironmentMemoryState r5 = new DoraObricEnvironmentMemoryState("UNKNOWN", 3);
        UNKNOWN = r5;
        DoraObricEnvironmentMemoryState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DoraObricEnvironmentMemoryState[] values() {
        return (DoraObricEnvironmentMemoryState[]) a.clone();
    }

    public static DoraObricEnvironmentMemoryState valueOf(String r1) {
        return (DoraObricEnvironmentMemoryState) r27.a.a(DoraObricEnvironmentMemoryState.class, r1);
    }

    public DoraObricEnvironmentMemoryState(String r1, int r2) {
        super(r1, r2);
    }
}
