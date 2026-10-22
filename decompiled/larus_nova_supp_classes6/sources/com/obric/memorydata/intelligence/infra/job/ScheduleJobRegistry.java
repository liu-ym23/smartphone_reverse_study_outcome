package com.obric.memorydata.intelligence.infra.job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ScheduleJobRegistry {
    private static IScheduleJobDelegate sDelegate;

    public ScheduleJobRegistry() {
    }

    public static void unregisterDelegate() {
        sDelegate = null;
    }

    public static IScheduleJobDelegate getDelegate() {
        return sDelegate;
    }

    public static void registerDelegate(IScheduleJobDelegate r0) {
        sDelegate = r0;
    }
}
