package com.obric.cae.smartNetwork.networkRateLimit;

import android.util.EventsUtils;
import com.obric.cae.log.CaeLog;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkRateLimitReport {
    private static final int NETWORK_RATE_LIMIT_EVENT_FEATURE_ID = 113;
    private static final String TAG = "NetworkRateLimitReport";

    public static class ReportCommonData {
        int backgroundAppRate;
        boolean foregroundAppIsInWhitelist;
        String foregroundAppPkgName;
        int foregroundAppRate;
        int foregroundAppRttAverage;
        String ifName;
        int maxBandwidthEstimatedValue;
        int rateCtrlUidNumber;
        float temperature;

        public ReportCommonData() {
        }
    }

    public NetworkRateLimitReport() {
    }

    private void reportNetworkRateLimitEvent(NetworkRateLimitProto r8) {
        if (r8 != null) goto L17;
        CaeLog.w(TAG, "reportNetworkRateLimitEvent: networkRateLimitData is null");
        return;
    L17:
        NetworkRateLimitProto.Builder r10 = NetworkRateLimitProto.newBuilder();     // Catch: Exception -> L14
        if (r8.hasNetworkRateLimitData() == false) goto L10;
        r10.setNetworkRateLimitData(r8.getNetworkRateLimitData());     // Catch: Exception -> L14
    L10:
        if (r8.hasNetworkRateLimitCancelData() == false) goto L12;
        r10.setNetworkRateLimitCancelData(r8.getNetworkRateLimitCancelData());     // Catch: Exception -> L14
    L12:
        NetworkRateLimitProto r11 = r10.build();     // Catch: Exception -> L14
        CaeLog.i(TAG, "reportNetworkRateLimitEvent: " + r11.toString());     // Catch: Exception -> L14
        EventsUtils.writePbEvent(System.currentTimeMillis(), 113, r11.toByteArray());     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        CaeLog.e(TAG, "reportNetworkRateLimitEvent failed: " + e.getMessage(), e);
    }

    public void reportRateLimitCancelEvent(ReportCommonData r8) {
        CaeLog.i(TAG, "call reportRateLimitCancelEvent");
        reportNetworkRateLimitEvent(NetworkRateLimitProto.newBuilder().setNetworkRateLimitCancelData(NetworkRateLimitCancelData.newBuilder().setCommonData(CommonData.newBuilder().setIfName(r8.ifName).setRateCtrlUidNumber(r8.rateCtrlUidNumber).setTemperature(r8.temperature).setMaxBandwidthEstimatedValue(r8.maxBandwidthEstimatedValue).setForegroundAppPkgName(r8.foregroundAppPkgName).setForegroundAppIsInWhitelist(r8.foregroundAppIsInWhitelist).setForegroundAppRate(r8.foregroundAppRate).setForegroundAppRttAverage(r8.foregroundAppRttAverage).setBackgroundAppRate(r8.backgroundAppRate).build()).build()).build());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "reportCompleteCancelData failed: " + e.getMessage(), e);
    }

    public void reportRateLimitEvent(int r8, ReportCommonData r10) {
        defpackage.a.i("call reportRateLimitEvent: strategyType = ", r8, TAG);
        reportNetworkRateLimitEvent(NetworkRateLimitProto.newBuilder().setNetworkRateLimitData(NetworkRateLimitData.newBuilder().setStrategyType(r8).setCommonData(CommonData.newBuilder().setIfName(r10.ifName).setRateCtrlUidNumber(r10.rateCtrlUidNumber).setTemperature(r10.temperature).setMaxBandwidthEstimatedValue(r10.maxBandwidthEstimatedValue).setForegroundAppPkgName(r10.foregroundAppPkgName).setForegroundAppIsInWhitelist(r10.foregroundAppIsInWhitelist).setForegroundAppRate(r10.foregroundAppRate).setForegroundAppRttAverage(r10.foregroundAppRttAverage).setBackgroundAppRate(r10.backgroundAppRate).build()).build()).build());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "reportCompleteRateLimitData failed: " + e.getMessage(), e);
    }
}
