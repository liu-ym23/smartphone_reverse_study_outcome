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

    public abstract ICronetEngineBuilder addPublicKeyPins(String r10, Set<byte[]> r11, boolean r12, Date r13);

    public abstract ICronetEngineBuilder addQuicHint(String r10, int r11, int r12);

    public abstract ExperimentalCronetEngine build();

    public abstract ICronetEngineBuilder enableBoeProxy(boolean r10);

    public ICronetEngineBuilder enableBrotli(boolean r10) {
        return this;
    }

    public abstract ICronetEngineBuilder enableHttp2(boolean r10);

    public abstract ICronetEngineBuilder enableHttpCache(int r10, long r11);

    public abstract ICronetEngineBuilder enableHttpDns(boolean r10);

    public ICronetEngineBuilder enableNetworkQualityEstimator(boolean r10) {
        return this;
    }

    public abstract ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r10);

    public abstract ICronetEngineBuilder enableQuic(boolean r10);

    public abstract ICronetEngineBuilder enableSdch(boolean r10);

    public abstract ICronetEngineBuilder enableTncSecureMode(boolean r10);

    public abstract ICronetEngineBuilder enableVerboseLog();

    public abstract String getDefaultUserAgent();

    public abstract ICronetEngineBuilder listenAppStateIndependently(boolean r10);

    public abstract ICronetEngineBuilder setALogFuncAddr(long r10);

    public abstract ICronetEngineBuilder setAppInfoProvider(TTAppInfoProvider r10);

    public abstract ICronetEngineBuilder setAppMonitorProvider(TTMonitorProvider r10);

    public abstract ICronetEngineBuilder setAppSecurityLevel(int r10);

    public abstract ICronetEngineBuilder setBypassBOEJSON(String r10);

    public abstract ICronetEngineBuilder setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r10);

    public abstract ICronetEngineBuilder setCronetSoPath(String r10);

    public abstract ICronetEngineBuilder setEventListener(TTEventListener r10);

    public abstract ICronetEngineBuilder setExperimentalOptions(String r10);

    public abstract ICronetEngineBuilder setGetDomainDefaultJSON(String r10);

    public abstract ICronetEngineBuilder setIsMainProcess(boolean r10);

    public abstract ICronetEngineBuilder setLazyInitIPC(boolean r10);

    public abstract ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r10);

    public abstract ICronetEngineBuilder setOpaqueData(ArrayList<byte[]> r10);

    public abstract ICronetEngineBuilder setOptInit(boolean r10);

    public abstract ICronetEngineBuilder setOptNqeInit(boolean r10, boolean r11);

    public abstract ICronetEngineBuilder setProcessName(String r10);

    public abstract ICronetEngineBuilder setProxyConfig(String r10);

    public abstract ICronetEngineBuilder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r10);

    public abstract ICronetEngineBuilder setStoragePath(String r10);

    public abstract ICronetEngineBuilder setStoreIdcRuleJSON(String r10);

    public abstract ICronetEngineBuilder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r10);

    public abstract ICronetEngineBuilder setTTNetInitStart(long r10);

    public abstract ICronetEngineBuilder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r10);

    public abstract ICronetEngineBuilder setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r10);

    public ICronetEngineBuilder setThreadPriority(int r10) {
        return this;
    }

    public abstract ICronetEngineBuilder setUserAgent(String r10);
}
