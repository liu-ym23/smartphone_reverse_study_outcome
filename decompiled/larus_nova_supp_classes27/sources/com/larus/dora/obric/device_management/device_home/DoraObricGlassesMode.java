package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesMode;", "", "<init>", "(Ljava/lang/String;I)V", "ASSISTANT", "HEADPHONE", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGlassesMode extends Enum<DoraObricGlassesMode> {
    public static final DoraObricGlassesMode ASSISTANT = null;
    public static final DoraObricGlassesMode HEADPHONE = null;
    public static final DoraObricGlassesMode UNKNOWN = null;
    public static final /* synthetic */ DoraObricGlassesMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricGlassesMode> getEntries() {
        return b;
    }

    static {
        DoraObricGlassesMode r0 = new DoraObricGlassesMode("ASSISTANT", 0);
        ASSISTANT = r0;
        DoraObricGlassesMode r1 = new DoraObricGlassesMode("HEADPHONE", 1);
        HEADPHONE = r1;
        DoraObricGlassesMode r3 = new DoraObricGlassesMode("UNKNOWN", 2);
        UNKNOWN = r3;
        DoraObricGlassesMode[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static DoraObricGlassesMode[] values() {
        return (DoraObricGlassesMode[]) a.clone();
    }

    public static DoraObricGlassesMode valueOf(String r1) {
        return (DoraObricGlassesMode) r27.a.a(DoraObricGlassesMode.class, r1);
    }

    public DoraObricGlassesMode(String r1, int r2) {
        super(r1, r2);
    }
}
