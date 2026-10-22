package com.obric.cae.statusReport.network;

import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.qoe.WiFiQoEParam;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkReportUtil {
    public static final int CAE_HANDOVER_EVENT_FEATURE_ID = 95;
    public static final int CELL_DISABLED = 4;
    public static final int CELL_ENABLED = 3;
    public static final int INTERVENTION_REPORT_EVENT_DELAY = 2000;
    private static final double MAX_ABSOLUTE_RTT = 200.0d;
    private static final double MAX_RETRY_RATE = 5.0d;
    private static final double MAX_RETRY_RATE_INCREASE = 1.0d;
    private static final double MAX_RTT_DEGRADATION = 0.8d;
    public static final int SOLUTION_TYPE_CLUSTER_SWITCH = 3;
    public static final int SOLUTION_TYPE_RL_SWITCH = 2;
    public static final int SOLUTION_TYPE_RULE_SWITCH = 1;
    public static final int SWITCH_REPORT_EVENT_DELAY = 30000;
    private static final String TAG = "NetworkReportUtil";
    public static final int WIFI_DISABLED = 2;
    public static final int WIFI_ENABLED = 1;

    public NetworkReportUtil() {
    }

    private static boolean checkRTTAcceptable(double r8, double r10) {
        if (r10 > (r8 * MAX_RTT_DEGRADATION)) goto L5;
        boolean r11 = true;
    L7:
        if (r10 > MAX_ABSOLUTE_RTT) goto L9;
        boolean r12 = true;
    L10:
        if (r11 == false) goto L14;
        if (r12 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r12 = false;
        goto L10
    L5:
        r11 = false;
        goto L7
    }

    private static boolean checkReliabilityAcceptable(double r8, double r10) {
        if (r10 > MAX_RETRY_RATE) goto L5;
        boolean r11 = true;
    L7:
        if (r10 > (r8 * MAX_RETRY_RATE_INCREASE)) goto L9;
        boolean r12 = true;
    L10:
        if (r11 == false) goto L14;
        if (r12 == false) goto L14;
        return true;
    L14:
        return false;
    L9:
        r12 = false;
        goto L10
    L5:
        r11 = false;
        goto L7
    }

    public static boolean isGoodHandover(NetworkQoECollect.QoEInfo r8, NetworkQoECollect.QoEInfo r10) {
        if (r8 == null) goto L11;
        if (r10 == null) goto L11;
        boolean r11 = checkRTTAcceptable(r8.getTcpAverageRtt(), r10.getTcpAverageRtt());
        boolean r12 = checkReliabilityAcceptable(r8.getTcpRetryRate(), r10.getTcpRetryRate());
        if (r11 == false) goto L13;
        if (r12 == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L11:
        CaeLog.i(TAG, "isGoodHandover: invalid input parameters");
        return false;
    }

    public static boolean isWiFiQoEParamValid(WiFiQoEParam r8) {
        if (r8 != null) goto L4;
    L8:
        return false;
    L4:
        if (r8.getRxThroughput() <= 0) goto L8;
        if (r8.getTxThroughput() <= 0) goto L8;
        return true;
    }
}
