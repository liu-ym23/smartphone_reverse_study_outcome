package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.JniStaticTestMocker;
import com.ttnet.org.chromium.base.NativeLibraryLoadedStatus;
import com.ttnet.org.chromium.base.annotations.CheckDiscard;
import com.ttnet.org.chromium.base.natives.GEN_JNI;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;

/* JADX INFO: loaded from: classes2.dex */
@CheckDiscard("crbug.com/993421")
class CronetUrlRequestContextJni implements CronetUrlRequestContext.Natives {
    public static final JniStaticTestMocker<CronetUrlRequestContext.Natives> TEST_HOOKS = null;
    private static CronetUrlRequestContext.Natives testInstance;

    static {
        TEST_HOOKS = new AnonymousClass1();
    }

    CronetUrlRequestContextJni() {
    }

    static /* synthetic */ CronetUrlRequestContext.Natives access$002(CronetUrlRequestContext.Natives r10) {
        testInstance = r10;
        return r10;
    }

    public static CronetUrlRequestContext.Natives get() {
        if (GEN_JNI.TESTING_ENABLED == false) goto L12;
        CronetUrlRequestContext.Natives r10 = testInstance;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (GEN_JNI.REQUIRE_MOCK == false) goto L12;
        throw new UnsupportedOperationException("No mock found for the native implementation for com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives. The current configuration requires all native implementations to have a mock instance.");
    L12:
        NativeLibraryLoadedStatus.checkLoaded(false);
        return new CronetUrlRequestContextJni();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addClientOpaqueData(long r10, CronetUrlRequestContext r11, String[] r12, byte[] r13, byte[] r14, long r15, long r16) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addClientOpaqueData(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addPkp(long r10, String r11, byte[][] r12, boolean r13, long r14) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addPkp(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addQuicHint(long r10, String r11, int r12, int r13) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addQuicHint(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void addSamplingSetting(long r10, CronetUrlRequestContext r11, TTSamplingSettingProvider.TTSlaSamplingSetting r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_addSamplingSetting(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void clearClientOpaqueData(long r10, CronetUrlRequestContext r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_clearClientOpaqueData(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void configureNetworkQualityEstimatorForTesting(long r10, CronetUrlRequestContext r11, boolean r12, boolean r13, boolean r14) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_configureNetworkQualityEstimatorForTesting(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void controlHttpDNSConfig(long r10, CronetUrlRequestContext r11, boolean r12, boolean r13, boolean r14) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_controlHttpDNSConfig(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long createRequestContextAdapter(long r10) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextAdapter(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long createRequestContextConfig(String r10, String r11, boolean r12, String r13, boolean r14, boolean r15, boolean r16, int r17, long r18, String r19, long r110, boolean r111, boolean r112, int r113) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_createRequestContextConfig(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void destroy(long r10, CronetUrlRequestContext r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_destroy(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void enableTTBizHttpDns(long r10, CronetUrlRequestContext r11, boolean r12, String r13, String r14, String r15, boolean r16, String r17) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_enableTTBizHttpDns(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public byte[] getHistogramDeltas() {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getHistogramDeltas();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public long[] getOpaqueFuncAddress() {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_getOpaqueFuncAddress();
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void initALogFuncAddr(long r10) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initALogFuncAddr(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void initRequestContextOnInitThread(long r10, CronetUrlRequestContext r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_initRequestContextOnInitThread(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void notifySwitchToMultiNetwork(long r10, CronetUrlRequestContext r11, boolean r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_notifySwitchToMultiNetwork(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void parseTNCConfigFromSystemHTTPRequest(long r10, CronetUrlRequestContext r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_parseTNCConfigFromSystemHTTPRequest(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void preconnectUrl(long r10, CronetUrlRequestContext r11, String r12, int r13, String r14) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_preconnectUrl(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void provideRTTObservations(long r10, CronetUrlRequestContext r11, boolean r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideRTTObservations(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void provideThroughputObservations(long r10, CronetUrlRequestContext r11, boolean r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_provideThroughputObservations(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void removeClientOpaqueData(long r10, CronetUrlRequestContext r11, String r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_removeClientOpaqueData(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void reportNetDiagnosisUserLog(long r10, CronetUrlRequestContext r11, String r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_reportNetDiagnosisUserLog(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void runInBackGround(long r10, CronetUrlRequestContext r11, boolean r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_runInBackGround(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setAlogFuncAddr(long r10, CronetUrlRequestContext r11, long r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAlogFuncAddr(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setAppStartUpState(long r10, CronetUrlRequestContext r11, int r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setAppStartUpState(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setClientOpaqueData(long r10, String[] r11, byte[] r12, byte[] r13) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setClientOpaqueData(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setCookieInitCompleted(long r10, CronetUrlRequestContext r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setCookieInitCompleted(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setHostResolverRules(long r10, CronetUrlRequestContext r11, String r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setHostResolverRules(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public int setMinLogLevel(int r10) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setMinLogLevel(r10);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setProxy(long r10, CronetUrlRequestContext r11, String r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setProxy(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setRouteSelectionBestHost(long r10, CronetUrlRequestContext r11, String r12, String r13) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setRouteSelectionBestHost(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setTTNetInitConfig(long r10, int r11, boolean r12, boolean r13, String r14, String r15, String r16, boolean r17, String r18, String r19, byte[][] r110, TTThreadConfigInfoProvider.ThreadConfigInfo[] r111, boolean r112, boolean r113, boolean r114, String r115, TTAppInfoProvider.AppInfo r116, long r117, boolean r21, boolean r22, boolean r23, TTSamplingSettingProvider.TTSlaSamplingSetting r24) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setTTNetInitConfig(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r21, r22, r23, r24);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void setZstdFuncAddr(long r10, CronetUrlRequestContext r11, long r12, long r13, long r14, long r15, long r16, long r17, long r18, long r19) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_setZstdFuncAddr(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public boolean skipLogging(long r10, CronetUrlRequestContext r11) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_skipLogging(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void startNetLogToDisk(long r10, CronetUrlRequestContext r11, String r12, boolean r13, int r14) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToDisk(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public boolean startNetLogToFile(long r10, CronetUrlRequestContext r11, String r12, boolean r13) {
        return GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startNetLogToFile(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void startThrottle(long r10, CronetUrlRequestContext r11, String[] r12, int r13, long r14) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_startThrottle(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void stopNetLog(long r10, CronetUrlRequestContext r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopNetLog(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void stopThrottle(long r10, CronetUrlRequestContext r11, String[] r12, int r13) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_stopThrottle(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void triggerTNCRequestByUser(long r10, CronetUrlRequestContext r11, boolean r12) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_triggerTNCRequestByUser(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void triggerWiFiToCellularByThirdParty(long r10, CronetUrlRequestContext r11) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_triggerWiFiToCellularByThirdParty(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void tryStartNetDetect(long r10, CronetUrlRequestContext r11, String[] r12, int r13, int r14) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_tryStartNetDetect(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void ttDnsResolve(long r10, CronetUrlRequestContext r11, String r12, int r13, String r14, String r15) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttDnsResolve(r10, r11, r12, r13, r14, r15);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void ttUrlDispatch(long r10, CronetUrlRequestContext r11, URLDispatch r12, String r13, boolean r14) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_ttUrlDispatch(r10, r11, r12, r13, r14);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetUrlRequestContext.Natives
    public void updateStoreRegionFromServer(long r10, CronetUrlRequestContext r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110, String r111, String r112) {
        GEN_JNI.com_ttnet_org_chromium_net_impl_CronetUrlRequestContext_updateStoreRegionFromServer(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112);
    }
}
