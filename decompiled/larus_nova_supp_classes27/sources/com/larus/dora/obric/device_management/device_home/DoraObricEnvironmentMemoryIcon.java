package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryIcon;", "", "<init>", "(Ljava/lang/String;I)V", "RUNNING", "PAUSED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryIcon extends Enum<DoraObricEnvironmentMemoryIcon> {
    public static final DoraObricEnvironmentMemoryIcon PAUSED = null;
    public static final DoraObricEnvironmentMemoryIcon RUNNING = null;
    public static final /* synthetic */ DoraObricEnvironmentMemoryIcon[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryIcon> getEntries() {
        return b;
    }

    static {
        DoraObricEnvironmentMemoryIcon r0 = new DoraObricEnvironmentMemoryIcon("RUNNING", 0);
        RUNNING = r0;
        DoraObricEnvironmentMemoryIcon r1 = new DoraObricEnvironmentMemoryIcon("PAUSED", 1);
        PAUSED = r1;
        DoraObricEnvironmentMemoryIcon[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DoraObricEnvironmentMemoryIcon[] values() {
        return (DoraObricEnvironmentMemoryIcon[]) a.clone();
    }

    public static DoraObricEnvironmentMemoryIcon valueOf(String r1) {
        return (DoraObricEnvironmentMemoryIcon) r27.a.a(DoraObricEnvironmentMemoryIcon.class, r1);
    }

    public DoraObricEnvironmentMemoryIcon(String r1, int r2) {
        super(r1, r2);
    }
}
