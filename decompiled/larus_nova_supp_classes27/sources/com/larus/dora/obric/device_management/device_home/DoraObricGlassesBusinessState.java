package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesBusinessState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "RECORDING", "INTERPRETING", "VIDEO_RECORDING", "VIDEO_CALL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGlassesBusinessState extends Enum<DoraObricGlassesBusinessState> {
    public static final DoraObricGlassesBusinessState IDLE = null;
    public static final DoraObricGlassesBusinessState INTERPRETING = null;
    public static final DoraObricGlassesBusinessState RECORDING = null;
    public static final DoraObricGlassesBusinessState VIDEO_CALL = null;
    public static final DoraObricGlassesBusinessState VIDEO_RECORDING = null;
    public static final /* synthetic */ DoraObricGlassesBusinessState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DoraObricGlassesBusinessState> getEntries() {
        return b;
    }

    static {
        DoraObricGlassesBusinessState r0 = new DoraObricGlassesBusinessState("IDLE", 0);
        IDLE = r0;
        DoraObricGlassesBusinessState r1 = new DoraObricGlassesBusinessState("RECORDING", 1);
        RECORDING = r1;
        DoraObricGlassesBusinessState r3 = new DoraObricGlassesBusinessState("INTERPRETING", 2);
        INTERPRETING = r3;
        DoraObricGlassesBusinessState r5 = new DoraObricGlassesBusinessState("VIDEO_RECORDING", 3);
        VIDEO_RECORDING = r5;
        DoraObricGlassesBusinessState r7 = new DoraObricGlassesBusinessState("VIDEO_CALL", 4);
        VIDEO_CALL = r7;
        DoraObricGlassesBusinessState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static DoraObricGlassesBusinessState[] values() {
        return (DoraObricGlassesBusinessState[]) a.clone();
    }

    public static DoraObricGlassesBusinessState valueOf(String r1) {
        return (DoraObricGlassesBusinessState) r27.a.a(DoraObricGlassesBusinessState.class, r1);
    }

    public DoraObricGlassesBusinessState(String r1, int r2) {
        super(r1, r2);
    }
}
