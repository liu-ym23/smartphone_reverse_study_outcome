package com.bytedance.applog.monitor.v3.impl;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum LatencyMonitor$EventLatencyScope extends Enum<LatencyMonitor$EventLatencyScope> {
    public static final /* synthetic */ LatencyMonitor$EventLatencyScope[] a = null;
    public static final LatencyMonitor$EventLatencyScope l_0_1 = null;
    public static final LatencyMonitor$EventLatencyScope l_0_60 = null;
    public static final LatencyMonitor$EventLatencyScope l_10_20 = null;
    public static final LatencyMonitor$EventLatencyScope l_120_ = null;
    public static final LatencyMonitor$EventLatencyScope l_1_10 = null;
    public static final LatencyMonitor$EventLatencyScope l_20_30 = null;
    public static final LatencyMonitor$EventLatencyScope l_30_40 = null;
    public static final LatencyMonitor$EventLatencyScope l_40_50 = null;
    public static final LatencyMonitor$EventLatencyScope l_50_60 = null;
    public static final LatencyMonitor$EventLatencyScope l_60_120 = null;

    static {
        LatencyMonitor$EventLatencyScope r0 = new LatencyMonitor$EventLatencyScope("l_0_60", 0);
        l_0_60 = r0;
        LatencyMonitor$EventLatencyScope r1 = new LatencyMonitor$EventLatencyScope("l_0_1", 1);
        l_0_1 = r1;
        LatencyMonitor$EventLatencyScope r3 = new LatencyMonitor$EventLatencyScope("l_1_10", 2);
        l_1_10 = r3;
        LatencyMonitor$EventLatencyScope r5 = new LatencyMonitor$EventLatencyScope("l_10_20", 3);
        l_10_20 = r5;
        LatencyMonitor$EventLatencyScope r7 = new LatencyMonitor$EventLatencyScope("l_20_30", 4);
        l_20_30 = r7;
        LatencyMonitor$EventLatencyScope r9 = new LatencyMonitor$EventLatencyScope("l_30_40", 5);
        l_30_40 = r9;
        LatencyMonitor$EventLatencyScope r11 = new LatencyMonitor$EventLatencyScope("l_40_50", 6);
        l_40_50 = r11;
        LatencyMonitor$EventLatencyScope r13 = new LatencyMonitor$EventLatencyScope("l_50_60", 7);
        l_50_60 = r13;
        LatencyMonitor$EventLatencyScope r15 = new LatencyMonitor$EventLatencyScope("l_60_120", 8);
        l_60_120 = r15;
        LatencyMonitor$EventLatencyScope r14 = new LatencyMonitor$EventLatencyScope("l_120_", 9);
        l_120_ = r14;
        a = new LatencyMonitor$EventLatencyScope[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
    }

    public static LatencyMonitor$EventLatencyScope[] values() {
        return (LatencyMonitor$EventLatencyScope[]) a.clone();
    }

    public static LatencyMonitor$EventLatencyScope valueOf(String r1) {
        return (LatencyMonitor$EventLatencyScope) a.a(LatencyMonitor$EventLatencyScope.class, r1);
    }

    public LatencyMonitor$EventLatencyScope(String r1, int r2) {
        super(r1, r2);
    }
}
