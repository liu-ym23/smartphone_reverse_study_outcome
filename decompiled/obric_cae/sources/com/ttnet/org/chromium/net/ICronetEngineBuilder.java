package com.ttnet.org.chromium.net;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ICronetEngineBuilder {
    public ICronetEngineBuilder() {
    }

    public abstract ICronetEngineBuilder addPublicKeyPins(String r8, Set<byte[]> r10, boolean r11, Date r12);

    public abstract ICronetEngineBuilder addQuicHint(String r8, int r10, int r11);

    public abstract ExperimentalCronetEngine build();

    public abstract ICronetEngineBuilder enableBoeProxy(boolean r8);

    public ICronetEngineBuilder enableBrotli(boolean r8) {
        return this;
    }

    public abstract ICronetEngineBuilder enableHttp2(boolean r8);

    public abstract ICronetEngineBuilder enableHttpCache(int r8, long r10);

    public abstract ICronetEngineBuilder enableHttpDns(boolean r8);

    public ICronetEngineBuilder enableNetworkQualityEstimator(boolean r8) {
        return this;
    }

    public abstract ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r8);

    public abstract ICronetEngineBuilder enableQuic(boolean r8);

    public abstract ICronetEngineBuilder enableSdch(boolean r8);

    public abstract ICronetEngineBuilder enableVerboseLog();

    public abstract String getDefaultUserAgent();

    public abstract ICronetEngineBuilder listenAppStateIndependently(boolean r8);

    public abstract ICronetEngineBuilder setALogFuncAddr(long r8);

    public abstract ICronetEngineBuilder setAppInfoProvider(TTAppInfoProvider r8);

    public abstract ICronetEngineBuilder setAppMonitorProvider(TTMonitorProvider r8);

    public abstract ICronetEngineBuilder setBypassBOEJSON(String r8);

    public abstract ICronetEngineBuilder setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r8);

    public abstract ICronetEngineBuilder setCronetSoPath(String r8);

    public abstract ICronetEngineBuilder setEventListener(TTEventListener r8);

    public abstract ICronetEngineBuilder setExperimentalOptions(String r8);

    public abstract ICronetEngineBuilder setGetDomainDefaultJSON(String r8);

    public abstract ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r8);

    public abstract ICronetEngineBuilder setOpaqueData(ArrayList<byte[]> r8);

    public abstract ICronetEngineBuilder setProxyConfig(String r8);

    public abstract ICronetEngineBuilder setStoragePath(String r8);

    public abstract ICronetEngineBuilder setStoreIdcRuleJSON(String r8);

    public ICronetEngineBuilder setThreadPriority(int r8) {
        return this;
    }

    public abstract ICronetEngineBuilder setUserAgent(String r8);
}
