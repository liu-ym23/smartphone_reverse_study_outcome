package com.ttnet.org.chromium.net;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class TTEventListener {
    public TTEventListener() {
    }

    public abstract Map<String, String> onCallToAddSecurityFactor(String r1, Map<String, String> r2);

    public abstract void onClientIPChanged(String r1);

    public abstract void onColdStartFinish();

    public abstract void onContextInitCompleted(long r1, long r3, long r5, long r7, long r9, long r11, long r13, long r15, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31);

    public abstract void onCronetBootSucceed();

    public abstract void onDropReasonChanged(boolean r1, List<Integer> r2);

    public abstract void onEffectiveConnectionTypeChanged(int r1);

    public abstract void onMultiNetworkStateChanged(int r1, int r2);

    public abstract void onNetworkQualityLevelChanged(int r1);

    public abstract void onNetworkQualityRttAndThroughputNotified(int r1, int r2, int r3);

    public abstract void onNetworkQualityTypeChangedV3(int r1);

    public abstract void onPacketLossComputed(int r1, double r2, double r4, double r6, double r8);

    public abstract void onPublicIPsChanged(List<String> r1, List<String> r2);

    public abstract void onRTTOrThroughputEstimatesComputed(int r1, int r2, int r3);

    public abstract String onRequestInterceptorJava(String r1, Map<String, String> r2);

    public abstract String onRequestInterceptorToStart(String r1, Map<String, String> r2, List<String> r3);

    public abstract String onResponseInterceptorToStart(String r1, Map<String, List<String>> r2, int r3);

    public abstract void onServerConfigUpdated(String r1, String r2, String r3);

    public abstract void onStoreIdcChanged(String r1, String r2, String r3, String r4, String r5, String r6);

    public abstract void onTLBDecompressFail();

    public abstract void onTNCUpdateFailed(String[] r1, String r2);

    public abstract void onTTDnsResolveResult(String r1, String r2, int r3, int r4, int r5, List<String> r6, String r7);

    public abstract void onTTNetDetectInfoChanged(String r1);

    public abstract void onTncRequestSucceeded(boolean r1, boolean r2, int r3);

    public abstract void onUserSpecifiedNetworkEnabled(boolean r1);

    public abstract void onWiFiToCellStateChanged(int r1, int r2);
}
