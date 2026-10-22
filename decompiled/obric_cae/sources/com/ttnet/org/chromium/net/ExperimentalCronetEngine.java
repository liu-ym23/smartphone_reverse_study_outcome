package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Pair;
import java.net.InetAddress;
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

    public static class Builder extends CronetEngine.Builder {
        public Builder(Context r8) {
            super(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder addPublicKeyPins(String r8, Set r10, boolean r11, Date r12) {
            return addPublicKeyPins(r8, r10, r11, r12);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder addQuicHint(String r8, int r10, int r11) {
            return addQuicHint(r8, r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine build() {
            return build();
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableBoeProxy(boolean r8) {
            return enableBoeProxy(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableHttp2(boolean r8) {
            return enableHttp2(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableHttpCache(int r8, long r10) {
            return enableHttpCache(r8, r10);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableHttpDns(boolean r8) {
            return enableHttpDns(r8);
        }

        public Builder enableNetworkQualityEstimator(boolean r8) {
            this.mBuilderDelegate.enableNetworkQualityEstimator(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r8) {
            return enablePublicKeyPinningBypassForLocalTrustAnchors(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableQuic(boolean r8) {
            return enableQuic(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableSdch(boolean r8) {
            return enableSdch(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder enableVerboseLog() {
            return enableVerboseLog();
        }

        public ICronetEngineBuilder getBuilderDelegate() {
            return this.mBuilderDelegate;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder listenAppStateIndependently(boolean r8) {
            return listenAppStateIndependently(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setALogFuncAddr(long r8) {
            return setALogFuncAddr(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setAppInfoProvider(TTAppInfoProvider r8) {
            return setAppInfoProvider(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setAppMonitorProvider(TTMonitorProvider r8) {
            return setAppMonitorProvider(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setBypassBOEJSON(String r8) {
            return setBypassBOEJSON(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setClientOpaqueData(Map r8) {
            return setClientOpaqueData(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setEventListener(TTEventListener r8) {
            return setEventListener(r8);
        }

        public Builder setExperimentalOptions(String r8) {
            this.mBuilderDelegate.setExperimentalOptions(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setGetDomainDefaultJSON(String r8) {
            return setGetDomainDefaultJSON(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setLibraryLoader(CronetEngine.Builder.LibraryLoader r8) {
            return setLibraryLoader(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setOpaqueData(ArrayList r8) {
            return setOpaqueData(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setProxyConfig(String r8) {
            return setProxyConfig(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setStoragePath(String r8) {
            return setStoragePath(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setStoreIdcRuleJSON(String r8) {
            return setStoreIdcRuleJSON(r8);
        }

        public Builder setThreadPriority(int r8) {
            this.mBuilderDelegate.setThreadPriority(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public /* bridge */ /* synthetic */ CronetEngine.Builder setUserAgent(String r8) {
            return setUserAgent(r8);
        }

        public Builder(ICronetEngineBuilder r8) {
            super(r8);
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder addPublicKeyPins(String r8, Set<byte[]> r10, boolean r11, Date r12) {
            super.addPublicKeyPins(r8, r10, r11, r12);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder addQuicHint(String r8, int r10, int r11) {
            super.addQuicHint(r8, r10, r11);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public ExperimentalCronetEngine build() {
            return this.mBuilderDelegate.build();
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableBoeProxy(boolean r8) {
            super.enableBoeProxy(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableHttp2(boolean r8) {
            super.enableHttp2(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableHttpCache(int r8, long r10) {
            super.enableHttpCache(r8, r10);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableHttpDns(boolean r8) {
            super.enableHttpDns(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r8) {
            super.enablePublicKeyPinningBypassForLocalTrustAnchors(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableQuic(boolean r8) {
            super.enableQuic(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableSdch(boolean r8) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder enableVerboseLog() {
            super.enableVerboseLog();
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder listenAppStateIndependently(boolean r8) {
            super.listenAppStateIndependently(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setALogFuncAddr(long r8) {
            super.setALogFuncAddr(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setAppInfoProvider(TTAppInfoProvider r8) {
            super.setAppInfoProvider(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setAppMonitorProvider(TTMonitorProvider r8) {
            super.setAppMonitorProvider(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setBypassBOEJSON(String r8) {
            super.setBypassBOEJSON(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r8) {
            super.setClientOpaqueData(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setEventListener(TTEventListener r8) {
            super.setEventListener(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setGetDomainDefaultJSON(String r8) {
            super.setGetDomainDefaultJSON(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setLibraryLoader(CronetEngine.Builder.LibraryLoader r8) {
            super.setLibraryLoader(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setOpaqueData(ArrayList<byte[]> r8) {
            super.setOpaqueData(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setProxyConfig(String r8) {
            super.setProxyConfig(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setStoragePath(String r8) {
            super.setStoragePath(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setStoreIdcRuleJSON(String r8) {
            super.setStoreIdcRuleJSON(r8);
            return this;
        }

        @Override // com.ttnet.org.chromium.net.CronetEngine.Builder
        public Builder setUserAgent(String r8) {
            super.setUserAgent(r8);
            return this;
        }
    }

    public ExperimentalCronetEngine() {
    }

    public void addClientOpaqueData(String[] r8, byte[] r10, byte[] r11) {
    }

    public void addRequestFinishedListener(RequestFinishedInfo.Listener r8) {
    }

    public void addRttListener(NetworkQualityRttListener r8) {
    }

    public void addThroughputListener(NetworkQualityThroughputListener r8) {
    }

    public void clearClientOpaqueData() {
    }

    public void configureNetworkQualityEstimatorForTesting(boolean r8, boolean r10, boolean r11) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public List<InetAddress> dnsLookup(String r8) {
        return null;
    }

    public void enableTTBizHttpDns(boolean r8, String r10, String r11, String r12, boolean r13, String r14) {
    }

    public double getDownstreamPacketLossRate(int r8) {
        return -1.0d;
    }

    public double getDownstreamPacketLossRateVariance(int r8) {
        return -1.0d;
    }

    public int getDownstreamThroughputKbps() {
        return -1;
    }

    public int getEffectiveConnectionType() {
        return 0;
    }

    public Map<String, int[]> getGroupRttEstimates() {
        return new HashMap();
    }

    public int getHttpRttMs() {
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public List<Long> getOpaqueFuncAddress() {
        return null;
    }

    public int getTransportRttMs() {
        return -1;
    }

    public double getUpstreamPacketLossRate(int r8) {
        return -1.0d;
    }

    public double getUpstreamPacketLossRateVariance(int r8) {
        return -1.0d;
    }

    public abstract ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String r8, BidirectionalStream.Callback r10, Executor r11);

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public abstract ExperimentalUrlRequest.Builder newUrlRequestBuilder(String r8, UrlRequest.Callback r10, Executor r11);

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r8, UrlRequest.Callback r10, Executor r11) {
        return newUrlRequestBuilder(r8, r10, r11);
    }

    public void notifySwitchToMultiNetwork(boolean r8) {
    }

    public void notifyTNCConfigUpdated(String r8, String r10, String r11, String r12, String r13, String r14) {
    }

    public URLConnection openConnection(URL r8, Proxy r10) {
        return r8.openConnection(r10);
    }

    public void preconnectUrl(String r8, int r10) {
    }

    public void registerAppInfoProvider(TTAppInfoProvider r8) {
    }

    public void registerAppMonitorProvider(TTMonitorProvider r8) {
    }

    public void registerEventListener(TTEventListener r8) {
    }

    public void removeClientOpaqueData(String r8) {
    }

    public void removeRequestFinishedListener(RequestFinishedInfo.Listener r8) {
    }

    public void removeRttListener(NetworkQualityRttListener r8) {
    }

    public void removeThroughputListener(NetworkQualityThroughputListener r8) {
    }

    public void reportNetDiagnosisUserLog(String r8) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setAlogFuncAddr(long r8) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setAppStartUpState(int r8) {
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void setHostResolverRules(String r8) {
    }

    public void setHttpDnsForTesting(boolean r8, boolean r10, boolean r11) {
    }

    public void setProxy(String r8) {
    }

    public void startNetLogToDisk(String r8, boolean r10, int r11) {
    }

    public void tiggerWiFiToCellularByThirdParty() {
    }

    public void triggerGetDomain(boolean r8) {
    }

    public void tryStartNetDetect(String[] r8, int r10, int r11) {
    }

    public void ttDnsResolve(String r8, int r10, String r11) {
    }

    public Map<String, String> ttUrlDispatch(String r8) {
        return null;
    }

    public void updateStoreRegionFromServer(String r8, String r10, String r11, String r12, String r13, String r14, String r15, String r16) {
    }
}
