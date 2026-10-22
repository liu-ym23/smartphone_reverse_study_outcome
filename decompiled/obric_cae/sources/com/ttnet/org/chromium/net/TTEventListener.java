package com.ttnet.org.chromium.net;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTEventListener {
    public TTEventListener() {
    }

    public abstract void handleApiResult(boolean r8, String r10, String r11, String r12, long r13, long r14, long r15, long r16, long r17, long r18, long r19, long r110, long r21, long r23, boolean r25, long r26, long r28, String r30, String r31, String r32, int r33, int r34, String r35);

    public abstract Map<String, String> onCallToAddSecurityFactor(String r8, Map<String, String> r10);

    public abstract void onClientIPChanged(String r8);

    public abstract void onColdStartFinish();

    public abstract void onContextInitCompleted(long r8, long r10, long r11, long r12, long r13, long r14, long r15, long r16, long r17, long r19, long r21, long r23, long r25, long r27, long r29, long r31, long r33, long r35);

    public abstract void onCronetBootSucceed();

    public abstract void onEffectiveConnectionTypeChanged(int r8);

    public abstract void onMultiNetworkStateChanged(int r8, int r10);

    public abstract void onPacketLossComputed(int r8, double r10, double r11, double r12, double r13);

    public abstract void onRTTOrThroughputEstimatesComputed(int r8, int r10, int r11);

    public abstract void onServerConfigUpdated(String r8, String r10);

    public abstract void onStoreIdcChanged(String r8, String r10, String r11);

    public abstract void onTNCUpdateFailed(String[] r8, String r10);

    public abstract void onTTDnsResolveResult(String r8, String r10, int r11, int r12, int r13, List<String> r14, String r15);

    public abstract void onTTNetDetectInfoChanged(String r8);
}
