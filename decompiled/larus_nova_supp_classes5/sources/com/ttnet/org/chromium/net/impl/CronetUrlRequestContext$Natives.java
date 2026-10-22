package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface CronetUrlRequestContext$Natives {
    @NativeClassQualifiedName("CronetContextAdapter")
    void addClientOpaqueData(long r1, CronetUrlRequestContext r3, String[] r4, byte[] r5, byte[] r6, long r7, long r9);

    void addPkp(long r1, String r3, byte[][] r4, boolean r5, long r6);

    void addQuicHint(long r1, String r3, int r4, int r5);

    @NativeClassQualifiedName("CronetContextAdapter")
    void addSamplingSetting(long r1, CronetUrlRequestContext r3, TTSamplingSettingProvider.TTSlaSamplingSetting r4);

    @NativeClassQualifiedName("CronetContextAdapter")
    void clearClientOpaqueData(long r1, CronetUrlRequestContext r3);

    @NativeClassQualifiedName("CronetContextAdapter")
    void configureNetworkQualityEstimatorForTesting(long r1, CronetUrlRequestContext r3, boolean r4, boolean r5, boolean r6);

    @NativeClassQualifiedName("CronetContextAdapter")
    void controlHttpDNSConfig(long r1, CronetUrlRequestContext r3, boolean r4, boolean r5, boolean r6);

    long createRequestContextAdapter(long r1);

    long createRequestContextConfig(String r1, String r2, boolean r3, String r4, boolean r5, boolean r6, boolean r7, int r8, long r9, String r11, long r12, boolean r14, boolean r15, int r16);

    @NativeClassQualifiedName("CronetContextAdapter")
    void destroy(long r1, CronetUrlRequestContext r3);

    @NativeClassQualifiedName("CronetContextAdapter")
    void enableTTBizHttpDns(long r1, CronetUrlRequestContext r3, boolean r4, String r5, String r6, String r7, boolean r8, String r9);

    byte[] getHistogramDeltas();

    long[] getOpaqueFuncAddress();

    void initALogFuncAddr(long r1);

    @NativeClassQualifiedName("CronetContextAdapter")
    void initRequestContextOnInitThread(long r1, CronetUrlRequestContext r3);

    @NativeClassQualifiedName("CronetContextAdapter")
    void parseTNCConfigFromSystemHTTPRequest(long r1, CronetUrlRequestContext r3, String r4, String r5, String r6, String r7, String r8, String r9);

    @NativeClassQualifiedName("CronetContextAdapter")
    void preconnectUrl(long r1, CronetUrlRequestContext r3, String r4, int r5, String r6);

    @NativeClassQualifiedName("CronetContextAdapter")
    void provideRTTObservations(long r1, CronetUrlRequestContext r3, boolean r4);

    @NativeClassQualifiedName("CronetContextAdapter")
    void provideThroughputObservations(long r1, CronetUrlRequestContext r3, boolean r4);

    @NativeClassQualifiedName("CronetContextAdapter")
    void removeClientOpaqueData(long r1, CronetUrlRequestContext r3, String r4);

    @NativeClassQualifiedName("CronetContextAdapter")
    void reportNetDiagnosisUserLog(long r1, CronetUrlRequestContext r3, String r4);

    @NativeClassQualifiedName("CronetContextAdapter")
    void runInBackGround(long r1, CronetUrlRequestContext r3, boolean r4);

    @NativeClassQualifiedName("CronetContextAdapter")
    void setAlogFuncAddr(long r1, CronetUrlRequestContext r3, long r4);

    @NativeClassQualifiedName("CronetContextAdapter")
    void setAppStartUpState(long r1, CronetUrlRequestContext r3, int r4);

    void setClientOpaqueData(long r1, String[] r3, byte[] r4, byte[] r5);

    @NativeClassQualifiedName("CronetContextAdapter")
    void setCookieInitCompleted(long r1, CronetUrlRequestContext r3);

    @NativeClassQualifiedName("CronetContextAdapter")
    void setHostResolverRules(long r1, CronetUrlRequestContext r3, String r4);

    int setMinLogLevel(int r1);

    @NativeClassQualifiedName("CronetContextAdapter")
    void setProxy(long r1, CronetUrlRequestContext r3, String r4);

    @NativeClassQualifiedName("CronetContextAdapter")
    void setRouteSelectionBestHost(long r1, CronetUrlRequestContext r3, String r4, String r5);

    void setTTNetInitConfig(long r1, int r3, boolean r4, boolean r5, String r6, String r7, String r8, boolean r9, String r10, String r11, byte[][] r12, TTThreadConfigInfoProvider.ThreadConfigInfo[] r13, boolean r14, boolean r15, boolean r16, String r17, TTAppInfoProvider.AppInfo r18, long r19, boolean r21, boolean r22, boolean r23, TTSamplingSettingProvider.TTSlaSamplingSetting r24, boolean r25, String r26, int r27);

    @NativeClassQualifiedName("CronetContextAdapter")
    void setZstdFuncAddr(long r1, CronetUrlRequestContext r3, long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18);

    @NativeClassQualifiedName("CronetContextAdapter")
    boolean skipLogging(long r1, CronetUrlRequestContext r3);

    @NativeClassQualifiedName("CronetContextAdapter")
    void startNetLogToDisk(long r1, CronetUrlRequestContext r3, String r4, boolean r5, int r6);

    @NativeClassQualifiedName("CronetContextAdapter")
    boolean startNetLogToFile(long r1, CronetUrlRequestContext r3, String r4, boolean r5);

    @NativeClassQualifiedName("CronetContextAdapter")
    void startThrottle(long r1, CronetUrlRequestContext r3, String[] r4, int r5, long r6);

    @NativeClassQualifiedName("CronetContextAdapter")
    void stopNetLog(long r1, CronetUrlRequestContext r3);

    @NativeClassQualifiedName("CronetContextAdapter")
    void stopThrottle(long r1, CronetUrlRequestContext r3, String[] r4, int r5);

    @NativeClassQualifiedName("CronetContextAdapter")
    void triggerTNCRequestByUser(long r1, CronetUrlRequestContext r3, boolean r4);

    @NativeClassQualifiedName("CronetContextAdapter")
    void tryStartNetDetect(long r1, CronetUrlRequestContext r3, String[] r4, int r5, int r6);

    @NativeClassQualifiedName("CronetContextAdapter")
    void ttDnsResolve(long r1, CronetUrlRequestContext r3, String r4, int r5, String r6, String r7);

    @NativeClassQualifiedName("CronetContextAdapter")
    void ttUrlDispatch(long r1, CronetUrlRequestContext r3, URLDispatch r4, String r5, boolean r6);

    @NativeClassQualifiedName("CronetContextAdapter")
    void updateStoreRegionFromServer(long r1, CronetUrlRequestContext r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14);
}
