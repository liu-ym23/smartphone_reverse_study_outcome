package com.obric.cae.smartNetwork.trafficMonitor;

/* JADX INFO: loaded from: classes2.dex */
public class TrafficMonitorUtil {
    public static final String ACTION_TRAFFIC_WARNING = "com.obric.security.action.TRAFFIC_HIGH_CONSUMPTION_WARNING";
    public static final String ACTION_TRAFFIC_WARNING_SECURITY = "com.obric.security.permission.TRAFFIC_HIGH_CONSUMPTION_WARNING";
    public static final String EXTRA_SUB_ID = "subId";
    private static final long INTERVAL_10MIN = 600000;
    private static final long INTERVAL_1MIN = 60000;
    private static final long INTERVAL_2H = 7200000;
    private static final long INTERVAL_30MIN = 1800000;
    private static final long INTERVAL_5MIN = 300000;
    public static final int MONITOR_TYPE_10MIN = 3;
    public static final int MONITOR_TYPE_1MIN = 1;
    public static final int MONITOR_TYPE_2H = 5;
    public static final int MONITOR_TYPE_30MIN = 4;
    public static final int MONITOR_TYPE_5MIN = 2;
    public static final int THRESHOLD_1GB = 1024;
    public static final int THRESHOLD_2GB = 2048;
    public static final int THRESHOLD_3GB = 3072;
    public static final int THRESHOLD_500MB = 500;
    public static final int THRESHOLD_5GB = 5120;

    public TrafficMonitorUtil() {
    }

    public static long getTrafficMonitorInterval(int r8) {
        if (r8 != 1) goto L5;
        return 60000;
    L5:
        if (r8 != 2) goto L7;
        return 300000;
    L7:
        if (r8 != 3) goto L9;
        return 600000;
    L9:
        if (r8 != 4) goto L11;
        return INTERVAL_30MIN;
    L11:
        if (r8 == 5) goto L14;
        return 0;
    L14:
        return INTERVAL_2H;
    }
}
