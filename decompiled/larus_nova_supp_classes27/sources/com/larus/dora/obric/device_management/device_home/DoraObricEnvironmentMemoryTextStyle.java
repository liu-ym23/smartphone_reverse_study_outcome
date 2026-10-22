package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryTextStyle;", "", "<init>", "(Ljava/lang/String;I)V", "RUNNING", "PAUSED", "HEADPHONE", "DISABLED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricEnvironmentMemoryTextStyle extends Enum<DoraObricEnvironmentMemoryTextStyle> {
    public static final DoraObricEnvironmentMemoryTextStyle DISABLED = null;
    public static final DoraObricEnvironmentMemoryTextStyle HEADPHONE = null;
    public static final DoraObricEnvironmentMemoryTextStyle PAUSED = null;
    public static final DoraObricEnvironmentMemoryTextStyle RUNNING = null;
    public static final /* synthetic */ DoraObricEnvironmentMemoryTextStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricEnvironmentMemoryTextStyle> getEntries() {
        return b;
    }

    static {
        DoraObricEnvironmentMemoryTextStyle r0 = new DoraObricEnvironmentMemoryTextStyle("RUNNING", 0);
        RUNNING = r0;
        DoraObricEnvironmentMemoryTextStyle r1 = new DoraObricEnvironmentMemoryTextStyle("PAUSED", 1);
        PAUSED = r1;
        DoraObricEnvironmentMemoryTextStyle r3 = new DoraObricEnvironmentMemoryTextStyle("HEADPHONE", 2);
        HEADPHONE = r3;
        DoraObricEnvironmentMemoryTextStyle r5 = new DoraObricEnvironmentMemoryTextStyle("DISABLED", 3);
        DISABLED = r5;
        DoraObricEnvironmentMemoryTextStyle[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DoraObricEnvironmentMemoryTextStyle[] values() {
        return (DoraObricEnvironmentMemoryTextStyle[]) a.clone();
    }

    public static DoraObricEnvironmentMemoryTextStyle valueOf(String r1) {
        return (DoraObricEnvironmentMemoryTextStyle) r27.a.a(DoraObricEnvironmentMemoryTextStyle.class, r1);
    }

    public DoraObricEnvironmentMemoryTextStyle(String r1, int r2) {
        super(r1, r2);
    }
}
