package com.larus.power.state.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/power/state/api/PowerMetricSource;", "", "<init>", "(Ljava/lang/String;I)V", "UNITM_EFFECTIVE", "UNITM_BATTERY", "ANDROID_THERMAL", "BATTERY_MANAGER", "ANDROID_POWER_MANAGER", "APM_CPU", "ACTIVITY_MANAGER", "LINUX_SYSFS", "COMPOSITE", "UNKNOWN", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum PowerMetricSource extends Enum<PowerMetricSource> {
    public static final PowerMetricSource ACTIVITY_MANAGER = null;
    public static final PowerMetricSource ANDROID_POWER_MANAGER = null;
    public static final PowerMetricSource ANDROID_THERMAL = null;
    public static final PowerMetricSource APM_CPU = null;
    public static final PowerMetricSource BATTERY_MANAGER = null;
    public static final PowerMetricSource COMPOSITE = null;
    public static final PowerMetricSource LINUX_SYSFS = null;
    public static final PowerMetricSource UNITM_BATTERY = null;
    public static final PowerMetricSource UNITM_EFFECTIVE = null;
    public static final PowerMetricSource UNKNOWN = null;
    public static final /* synthetic */ PowerMetricSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PowerMetricSource> getEntries() {
        return b;
    }

    static {
        PowerMetricSource r0 = new PowerMetricSource("UNITM_EFFECTIVE", 0);
        UNITM_EFFECTIVE = r0;
        PowerMetricSource r1 = new PowerMetricSource("UNITM_BATTERY", 1);
        UNITM_BATTERY = r1;
        PowerMetricSource r3 = new PowerMetricSource("ANDROID_THERMAL", 2);
        ANDROID_THERMAL = r3;
        PowerMetricSource r5 = new PowerMetricSource("BATTERY_MANAGER", 3);
        BATTERY_MANAGER = r5;
        PowerMetricSource r7 = new PowerMetricSource("ANDROID_POWER_MANAGER", 4);
        ANDROID_POWER_MANAGER = r7;
        PowerMetricSource r9 = new PowerMetricSource("APM_CPU", 5);
        APM_CPU = r9;
        PowerMetricSource r11 = new PowerMetricSource("ACTIVITY_MANAGER", 6);
        ACTIVITY_MANAGER = r11;
        PowerMetricSource r13 = new PowerMetricSource("LINUX_SYSFS", 7);
        LINUX_SYSFS = r13;
        PowerMetricSource r15 = new PowerMetricSource("COMPOSITE", 8);
        COMPOSITE = r15;
        PowerMetricSource r14 = new PowerMetricSource("UNKNOWN", 9);
        UNKNOWN = r14;
        PowerMetricSource[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static PowerMetricSource[] values() {
        return (PowerMetricSource[]) a.clone();
    }

    public static PowerMetricSource valueOf(String r1) {
        return (PowerMetricSource) a.a(PowerMetricSource.class, r1);
    }

    public PowerMetricSource(String r1, int r2) {
        super(r1, r2);
    }
}
