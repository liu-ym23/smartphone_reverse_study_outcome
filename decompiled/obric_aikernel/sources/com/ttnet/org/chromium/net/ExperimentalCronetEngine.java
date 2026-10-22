package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ExperimentalCronetEngine extends CronetEngine {
    public static final int CONNECTION_METRIC_UNKNOWN = -1;
    public static final int EFFECTIVE_CONNECTION_TYPE_2G = 3;
    public static final int EFFECTIVE_CONNECTION_TYPE_3G = 4;
    public static final int EFFECTIVE_CONNECTION_TYPE_4G = 5;
    public static final int EFFECTIVE_CONNECTION_TYPE_OFFLINE = 1;
    public static final int EFFECTIVE_CONNECTION_TYPE_SLOW_2G = 2;
    public static final int EFFECTIVE_CONNECTION_TYPE_UNKNOWN = 0;
    public static final int PACKET_LOSS_PROTOCOL_QUIC = 1;
    public static final int PACKET_LOSS_PROTOCOL_TCP = 0;
    public static final long UNBIND_NETWORK_HANDLE = -1;

    public static class Builder extends CronetEngine.Builder {
        public Builder(Context r10, boolean r11) {
            super(r10, r11);
        }

        public Builder(ICronetEngineBuilder r10) {
            super(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder addPublicKeyPins(String r10, Set r11, boolean r12, Date r13) {
            return addPublicKeyPins(r10, r11, r12, r13);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder addPublicKeyPins(String r10, Set<byte[]> r11, boolean r12, Date r13) {
            super.addPublicKeyPins(r10, r11, r12, r13);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder addQuicHint(String r10, int r11, int r12) {
            return addQuicHint(r10, r11, r12);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder addQuicHint(String r10, int r11, int r12) {
            super.addQuicHint(r10, r11, r12);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine build() {
            return build();
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public ExperimentalCronetEngine build() {
            return this.mBuilderDelegate.build();
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableBoeProxy(boolean r10) {
            return enableBoeProxy(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableBoeProxy(boolean r10) {
            super.enableBoeProxy(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableHttp2(boolean r10) {
            return enableHttp2(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableHttp2(boolean r10) {
            super.enableHttp2(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableHttpCache(int r10, long r11) {
            return enableHttpCache(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableHttpCache(int r10, long r11) {
            super.enableHttpCache(r10, r11);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableHttpDns(boolean r10) {
            return enableHttpDns(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableHttpDns(boolean r10) {
            super.enableHttpDns(r10);
            return this;
        }

        public Builder enableNetworkQualityEstimator(boolean r10) {
            this.mBuilderDelegate.enableNetworkQualityEstimator(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r10) {
            return enablePublicKeyPinningBypassForLocalTrustAnchors(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r10) {
            super.enablePublicKeyPinningBypassForLocalTrustAnchors(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableQuic(boolean r10) {
            return enableQuic(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableQuic(boolean r10) {
            super.enableQuic(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableSdch(boolean r10) {
            return enableSdch(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableSdch(boolean r10) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableTncSecureMode(boolean r10) {
            return enableTncSecureMode(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableTncSecureMode(boolean r10) {
            super.enableTncSecureMode(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableVerboseLog() {
            return enableVerboseLog();
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableVerboseLog() {
            super.enableVerboseLog();
            return this;
        }

        @VisibleForTesting
        public ICronetEngineBuilder getBuilderDelegate() {
            return this.mBuilderDelegate;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder listenAppStateIndependently(boolean r10) {
            return listenAppStateIndependently(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder listenAppStateIndependently(boolean r10) {
            super.listenAppStateIndependently(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setALogFuncAddr(long r10) {
            return setALogFuncAddr(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setALogFuncAddr(long r10) {
            super.setALogFuncAddr(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setAppInfoProvider(TTAppInfoProvider r10) {
            return setAppInfoProvider(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setAppInfoProvider(TTAppInfoProvider r10) {
            super.setAppInfoProvider(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setAppMonitorProvider(TTMonitorProvider r10) {
            return setAppMonitorProvider(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setAppMonitorProvider(TTMonitorProvider r10) {
            super.setAppMonitorProvider(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setAppSecurityLevel(int r10) {
            return setAppSecurityLevel(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setAppSecurityLevel(int r10) {
            super.setAppSecurityLevel(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setBypassBOEJSON(String r10) {
            return setBypassBOEJSON(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setBypassBOEJSON(String r10) {
            super.setBypassBOEJSON(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setClientOpaqueData(Map r10) {
            return setClientOpaqueData(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r10) {
            super.setClientOpaqueData(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setEventListener(TTEventListener r10) {
            return setEventListener(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setEventListener(TTEventListener r10) {
            super.setEventListener(r10);
            return this;
        }

        public Builder setExperimentalOptions(String r10) {
            this.mBuilderDelegate.setExperimentalOptions(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setGetDomainDefaultJSON(String r10) {
            return setGetDomainDefaultJSON(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setGetDomainDefaultJSON(String r10) {
            super.setGetDomainDefaultJSON(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setIsMainProcess(boolean r10) {
            return setIsMainProcess(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setIsMainProcess(boolean r10) {
            super.setIsMainProcess(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setLazyInitIPC(boolean r10) {
            return setLazyInitIPC(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setLazyInitIPC(boolean r10) {
            super.setLazyInitIPC(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setLibraryLoader(CronetEngine.Builder.LibraryLoader r10) {
            return setLibraryLoader(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setLibraryLoader(CronetEngine.Builder.LibraryLoader r10) {
            super.setLibraryLoader(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setOpaqueData(ArrayList r10) {
            return setOpaqueData(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setOpaqueData(ArrayList<byte[]> r10) {
            super.setOpaqueData(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setOptInit(boolean r10) {
            return setOptInit(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setOptInit(boolean r10) {
            super.setOptInit(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setOptNqeInit(boolean r10, boolean r11) {
            return setOptNqeInit(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setOptNqeInit(boolean r10, boolean r11) {
            super.setOptNqeInit(r10, r11);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setProcessName(String r10) {
            return setProcessName(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setProcessName(String r10) {
            super.setProcessName(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setProxyConfig(String r10) {
            return setProxyConfig(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setProxyConfig(String r10) {
            super.setProxyConfig(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r10) {
            return setSlaSamplingSetting(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r10) {
            super.setSlaSamplingSetting(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setStoragePath(String r10) {
            return setStoragePath(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setStoragePath(String r10) {
            super.setStoragePath(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setStoreIdcRuleJSON(String r10) {
            return setStoreIdcRuleJSON(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setStoreIdcRuleJSON(String r10) {
            super.setStoreIdcRuleJSON(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r10) {
            return setTTAppInfoColdStartSubset(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r10) {
            super.setTTAppInfoColdStartSubset(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setTTNetInitStart(long r10) {
            return setTTNetInitStart(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setTTNetInitStart(long r10) {
            super.setTTNetInitStart(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r10) {
            return setThreadConfigCallbackImpl(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r10) {
            super.setThreadConfigCallbackImpl(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setThreadConfigInfoList(ArrayList r10) {
            return setThreadConfigInfoList(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r10) {
            super.setThreadConfigInfoList(r10);
            return this;
        }

        public Builder setThreadPriority(int r10) {
            this.mBuilderDelegate.setThreadPriority(r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setUserAgent(String r10) {
            return setUserAgent(r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setUserAgent(String r10) {
            super.setUserAgent(r10);
            return this;
        }
    }

    public ExperimentalCronetEngine() {
    }

    public void addClientOpaqueData(String[] r10, byte[] r11, byte[] r12, long r13, long r14) {
    }

    public void addRequestFinishedListener(RequestFinishedInfo.Listener r10) {
    }

    public void addRttListener(NetworkQualityRttListener r10) {
    }

    public void addSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r10) {
    }

    public void addThroughputListener(NetworkQualityThroughputListener r10) {
    }

    public void bindBigCore(int r10) {
    }

    public void bindLittleCore(int r10) {
    }

    public void bindToNetwork(long r10) {
    }

    public void clearClientOpaqueData() {
    }

    public void configureNetworkQualityEstimatorForTesting(boolean r10, boolean r11, boolean r12) {
    }

    public void enableTTBizHttpDns(boolean r10, String r11, String r12, String r13, boolean r14, String r15) {
    }

    public double getDownstreamPacketLossRate(int r10) {
        return -1.0d;
    }

    public double getDownstreamPacketLossRateVariance(int r10) {
        return -1.0d;
    }

    public int getDownstreamThroughputKbps() {
        return -1;
    }

    public int getEffectiveConnectionType() {
        return 0;
    }

    public int getEffectiveHttpRtt() {
        return -1;
    }

    public int getEffectiveRxThroughput() {
        return -1;
    }

    public int getEffectiveTransportRtt() {
        return -1;
    }

    public Map<String, int[]> getGroupRttEstimates() {
        return new HashMap();
    }

    public int getHttpRttMs() {
        return -1;
    }

    public int getNetworkQualityLevel() {
        return 0;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public List<Long> getOpaqueFuncAddress() {
        return null;
    }

    public int getTransportRttMs() {
        return -1;
    }

    public double getUpstreamPacketLossRate(int r10) {
        return -1.0d;
    }

    public double getUpstreamPacketLossRateVariance(int r10) {
        return -1.0d;
    }

    public abstract ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String r10, BidirectionalStream.Callback r11, Executor r12);

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public abstract ExperimentalUrlRequest.Builder newUrlRequestBuilder(String r10, UrlRequest.Callback r11, Executor r12);

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r10, UrlRequest.Callback r11, Executor r12) {
        return newUrlRequestBuilder(r10, r11, r12);
    }

    public void notifySwitchToMultiNetwork(boolean r10) {
    }

    public void notifyTNCConfigUpdated(String r10, String r11, String r12, String r13, String r14, String r15) {
    }

    public URLConnection openConnection(URL r10, Proxy r11) {
        return r10.openConnection(r11);
    }

    public void preconnectUrl(String r10, int r11, Map<String, String> r12) {
    }

    public void registerAppInfoProvider(TTAppInfoProvider r10) {
    }

    public void registerAppMonitorProvider(TTMonitorProvider r10) {
    }

    public void registerEventListener(TTEventListener r10) {
    }

    public void removeClientOpaqueData(String r10) {
    }

    public void removeRequestFinishedListener(RequestFinishedInfo.Listener r10) {
    }

    public void removeRttListener(NetworkQualityRttListener r10) {
    }

    public void removeThroughputListener(NetworkQualityThroughputListener r10) {
    }

    public void reportNetDiagnosisUserLog(String r10) {
    }

    public void resetCoreBind(int r10) {
    }

    public void runInBackGround(boolean r10) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setAlogFuncAddr(long r10) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setAppStartUpState(int r10) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setCookieInitCompleted() {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setHostResolverRules(String r10) {
    }

    public void setHttpDnsForTesting(boolean r10, boolean r11, boolean r12) {
    }

    public void setProxy(String r10) {
    }

    public void setRouteSelectionBestHost(String r10, String r11) {
    }

    public void setZstdFuncAddr(long r10, long r11, long r12, long r13, long r14, long r15, long r16, long r17) {
    }

    public void startNetLogToDisk(String r10, boolean r11, int r12) {
    }

    public void startThrottle(String[] r10, int r11, long r12) {
    }

    public void stopThrottle(String[] r10, int r11) {
    }

    public void triggerGetDomain(boolean r10) {
    }

    public void triggerWiFiToCellularByThirdParty() {
    }

    public void tryStartNetDetect(String[] r10, int r11, int r12) {
    }

    public void ttDnsResolve(String r10, int r11, String r12, Map<String, String> r13) {
    }

    public Map<String, String> ttUrlDispatch(String r10, int r11, boolean r12) {
        return null;
    }

    public void updateStoreRegionFromServer(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110) {
    }
}
