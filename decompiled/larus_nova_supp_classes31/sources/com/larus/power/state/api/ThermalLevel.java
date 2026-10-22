package com.larus.power.state.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/power/state/api/ThermalLevel;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "LIGHT", "MODERATE", "SEVERE", "CRITICAL", "EMERGENCY", "SHUTDOWN", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum ThermalLevel extends Enum<ThermalLevel> {
    public static final ThermalLevel CRITICAL = null;
    public static final ThermalLevel EMERGENCY = null;
    public static final ThermalLevel LIGHT = null;
    public static final ThermalLevel MODERATE = null;
    public static final ThermalLevel NONE = null;
    public static final ThermalLevel SEVERE = null;
    public static final ThermalLevel SHUTDOWN = null;
    public static final ThermalLevel UNKNOWN = null;
    public static final /* synthetic */ ThermalLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ThermalLevel> getEntries() {
        return b;
    }

    static {
        ThermalLevel r0 = new ThermalLevel("NONE", 0);
        NONE = r0;
        ThermalLevel r1 = new ThermalLevel("LIGHT", 1);
        LIGHT = r1;
        ThermalLevel r3 = new ThermalLevel("MODERATE", 2);
        MODERATE = r3;
        ThermalLevel r5 = new ThermalLevel("SEVERE", 3);
        SEVERE = r5;
        ThermalLevel r7 = new ThermalLevel("CRITICAL", 4);
        CRITICAL = r7;
        ThermalLevel r9 = new ThermalLevel("EMERGENCY", 5);
        EMERGENCY = r9;
        ThermalLevel r11 = new ThermalLevel("SHUTDOWN", 6);
        SHUTDOWN = r11;
        ThermalLevel r13 = new ThermalLevel("UNKNOWN", 7);
        UNKNOWN = r13;
        ThermalLevel[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r15;
        b = EnumEntriesKt.enumEntries(r15);
    }

    public static ThermalLevel[] values() {
        return (ThermalLevel[]) a.clone();
    }

    public static ThermalLevel valueOf(String r1) {
        return (ThermalLevel) a.a(ThermalLevel.class, r1);
    }

    public ThermalLevel(String r1, int r2) {
        super(r1, r2);
    }
}
