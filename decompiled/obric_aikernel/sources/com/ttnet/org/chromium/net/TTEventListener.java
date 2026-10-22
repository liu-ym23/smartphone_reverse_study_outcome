package com.ttnet.org.chromium.net;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTEventListener {
    public TTEventListener() {
    }

    public abstract void handleApiResult(boolean r10, String r11, String r12, String r13, long r14, long r15, long r16, long r17, long r18, long r19, long r110, long r111, long r21, long r23, boolean r25, long r26, long r28, String r30, String r31, String r32, int r33, int r34, String r35);

    public abstract boolean handleApiSample(String r10, String r11);

    public abstract Map<String, String> onCallToAddSecurityFactor(String r10, Map<String, String> r11);

    public abstract void onClientIPChanged(String r10);

    public abstract void onColdStartFinish();

    public abstract void onContextInitCompleted(long r10, long r11, long r12, long r13, long r14, long r15, long r16, long r17, long r18, long r19, long r21, long r23, long r25, long r27, long r29, long r31);

    public abstract void onCronetBootSucceed();

    public abstract void onDropReasonChanged(boolean r10, List<Integer> r11);

    public abstract void onEffectiveConnectionTypeChanged(int r10);

    public abstract void onMultiNetStateChanged(int r10, int r11);

    public abstract void onMultiNetworkStateChanged(int r10, int r11);

    public abstract void onNetworkQualityLevelChanged(int r10);

    public abstract void onNetworkQualityRttAndThroughputNotified(int r10, int r11, int r12);

    public abstract void onNetworkQualityTypeChangedV3(int r10);

    public abstract void onPacketLossComputed(int r10, double r11, double r12, double r13, double r14);

    public abstract void onPublicIPsChanged(List<String> r10, List<String> r11);

    public abstract void onRTTOrThroughputEstimatesComputed(int r10, int r11, int r12);

    public abstract String onRequestInterceptorToStart(String r10, Map<String, String> r11, List<String> r12);

    public abstract String onResponseInterceptorToStart(String r10, Map<String, List<String>> r11, int r12);

    public abstract void onServerConfigUpdated(String r10, String r11, String r12);

    public abstract void onStoreIdcChanged(String r10, String r11, String r12, String r13, String r14, String r15);

    public abstract void onTLBDecompressFail();

    public abstract void onTNCUpdateFailed(String[] r10, String r11);

    public abstract void onTTDnsResolveResult(String r10, String r11, int r12, int r13, int r14, List<String> r15, String r16);

    public abstract void onTTNetDetectInfoChanged(String r10);

    public abstract void onUserSpecifiedNetworkEnabled(boolean r10);
}
