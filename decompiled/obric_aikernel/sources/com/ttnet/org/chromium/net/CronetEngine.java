package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CronetEngine {
    private static final String TAG = "CronetEngine";

    public static class Builder {
        public static final int HTTP_CACHE_DISABLED = 0;
        public static final int HTTP_CACHE_DISK = 3;
        public static final int HTTP_CACHE_DISK_NO_HTTP = 2;
        public static final int HTTP_CACHE_IN_MEMORY = 1;
        private static final String TAG = "CronetEngine.Builder";
        protected final ICronetEngineBuilder mBuilderDelegate;

        public static abstract class LibraryLoader {
            public LibraryLoader() {
            }

            public abstract void loadLibrary(String r10);
        }

        public Builder(Context r10, boolean r11) {
            this(createBuilderDelegate(r10, r11));
        }

        public Builder(ICronetEngineBuilder r10) {
            this.mBuilderDelegate = r10;
        }

        @VisibleForTesting
        static int compareVersions(String r10, String r11) {
            if (r10 == null) goto L20;
            if (r11 == null) goto L20;
            String[] r12 = r10.split("\\.");
            String[] r13 = r11.split("\\.");
            int r14 = 0;
        L6:
            if (r14 >= r12.length) goto L18;
            if (r14 >= r13.length) goto L18;
            int r15 = Integer.parseInt(r12[r14]);     // Catch: NumberFormatException -> L14
            int r16 = Integer.parseInt(r13[r14]);     // Catch: NumberFormatException -> L14
            if (r15 != r16) goto L11;
            r14 = r14 + 1;
            goto L6
        L11:
            return Integer.signum(r15 - r16);
        L14:
            e = move-exception;
            throw new IllegalArgumentException("Unable to convert version segments into integers: " + r12[r14] + " & " + r13[r14], e);
        L18:
            return Integer.signum(r12.length - r13.length);
        L20:
            throw new IllegalArgumentException("The input values cannot be null");
        }

        private static ICronetEngineBuilder createBuilderDelegate(Context r10, boolean r11) {
            CronetProvider r12 = getEnabledCronetProviders(r10, new ArrayList(CronetProvider.getAllProviders(r10))).get(0);
            if (Log.isLoggable(TAG, 3) == false) goto L6;
            Log.d(TAG, String.format("Using '%s' provider for creating CronetEngine.Builder.", new Object[]{r12}));
        L6:
            return r12.createBuilder(r11).mBuilderDelegate;
        }

        @VisibleForTesting
        static List<CronetProvider> getEnabledCronetProviders(Context r10, List<CronetProvider> r11) {
            if (r11.size() == 0) goto L17;
            Iterator<CronetProvider> r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L11;
            if (r12.next().isEnabled() == true) goto L6;
            r12.remove();
            goto L6
        L11:
            if (r11.size() == 0) goto L15;
            Collections.sort(r11, new AnonymousClass1());
            return r11;
        L15:
            throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
        L17:
            throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
        }

        public Builder addPublicKeyPins(String r10, Set<byte[]> r11, boolean r12, Date r13) {
            this.mBuilderDelegate.addPublicKeyPins(r10, r11, r12, r13);
            return this;
        }

        public Builder addQuicHint(String r10, int r11, int r12) {
            this.mBuilderDelegate.addQuicHint(r10, r11, r12);
            return this;
        }

        public CronetEngine build() {
            return this.mBuilderDelegate.build();
        }

        public Builder enableBoeProxy(boolean r10) {
            this.mBuilderDelegate.enableBoeProxy(r10);
            return this;
        }

        public Builder enableBrotli(boolean r10) {
            this.mBuilderDelegate.enableBrotli(r10);
            return this;
        }

        public Builder enableHttp2(boolean r10) {
            this.mBuilderDelegate.enableHttp2(r10);
            return this;
        }

        public Builder enableHttpCache(int r10, long r11) {
            this.mBuilderDelegate.enableHttpCache(r10, r11);
            return this;
        }

        public Builder enableHttpDns(boolean r10) {
            this.mBuilderDelegate.enableHttpDns(r10);
            return this;
        }

        public Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r10) {
            this.mBuilderDelegate.enablePublicKeyPinningBypassForLocalTrustAnchors(r10);
            return this;
        }

        public Builder enableQuic(boolean r10) {
            this.mBuilderDelegate.enableQuic(r10);
            return this;
        }

        @Deprecated
        public Builder enableSdch(boolean r10) {
            return this;
        }

        public Builder enableTncSecureMode(boolean r10) {
            this.mBuilderDelegate.enableTncSecureMode(r10);
            return this;
        }

        public Builder enableVerboseLog() {
            this.mBuilderDelegate.enableVerboseLog();
            return this;
        }

        public String getDefaultUserAgent() {
            return this.mBuilderDelegate.getDefaultUserAgent();
        }

        public Builder listenAppStateIndependently(boolean r10) {
            this.mBuilderDelegate.listenAppStateIndependently(r10);
            return this;
        }

        public Builder setALogFuncAddr(long r10) {
            this.mBuilderDelegate.setALogFuncAddr(r10);
            return this;
        }

        public Builder setAppInfoProvider(TTAppInfoProvider r10) {
            this.mBuilderDelegate.setAppInfoProvider(r10);
            return this;
        }

        public Builder setAppMonitorProvider(TTMonitorProvider r10) {
            this.mBuilderDelegate.setAppMonitorProvider(r10);
            return this;
        }

        public Builder setAppSecurityLevel(int r10) {
            this.mBuilderDelegate.setAppSecurityLevel(r10);
            return this;
        }

        public Builder setBypassBOEJSON(String r10) {
            this.mBuilderDelegate.setBypassBOEJSON(r10);
            return this;
        }

        public Builder setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r10) {
            this.mBuilderDelegate.setClientOpaqueData(r10);
            return this;
        }

        public Builder setCronetSoPath(String r10) {
            this.mBuilderDelegate.setCronetSoPath(r10);
            return this;
        }

        public Builder setEventListener(TTEventListener r10) {
            this.mBuilderDelegate.setEventListener(r10);
            return this;
        }

        public Builder setGetDomainDefaultJSON(String r10) {
            this.mBuilderDelegate.setGetDomainDefaultJSON(r10);
            return this;
        }

        public Builder setIsMainProcess(boolean r10) {
            this.mBuilderDelegate.setIsMainProcess(r10);
            return this;
        }

        public Builder setLazyInitIPC(boolean r10) {
            this.mBuilderDelegate.setLazyInitIPC(r10);
            return this;
        }

        public Builder setLibraryLoader(LibraryLoader r10) {
            this.mBuilderDelegate.setLibraryLoader(r10);
            return this;
        }

        public Builder setOpaqueData(ArrayList<byte[]> r10) {
            this.mBuilderDelegate.setOpaqueData(r10);
            return this;
        }

        public Builder setOptInit(boolean r10) {
            this.mBuilderDelegate.setOptInit(r10);
            return this;
        }

        public Builder setOptNqeInit(boolean r10, boolean r11) {
            this.mBuilderDelegate.setOptNqeInit(r10, r11);
            return this;
        }

        public Builder setProcessName(String r10) {
            this.mBuilderDelegate.setProcessName(r10);
            return this;
        }

        public Builder setProxyConfig(String r10) {
            this.mBuilderDelegate.setProxyConfig(r10);
            return this;
        }

        public Builder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r10) {
            this.mBuilderDelegate.setSlaSamplingSetting(r10);
            return this;
        }

        public Builder setStoragePath(String r10) {
            this.mBuilderDelegate.setStoragePath(r10);
            return this;
        }

        public Builder setStoreIdcRuleJSON(String r10) {
            this.mBuilderDelegate.setStoreIdcRuleJSON(r10);
            return this;
        }

        public Builder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r10) {
            this.mBuilderDelegate.setTTAppInfoColdStartSubset(r10);
            return this;
        }

        public Builder setTTNetInitStart(long r10) {
            this.mBuilderDelegate.setTTNetInitStart(r10);
            return this;
        }

        public Builder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r10) {
            this.mBuilderDelegate.setThreadConfigCallbackImpl(r10);
            return this;
        }

        public Builder setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r10) {
            this.mBuilderDelegate.setThreadConfigInfoList(r10);
            return this;
        }

        public Builder setUserAgent(String r10) {
            this.mBuilderDelegate.setUserAgent(r10);
            return this;
        }
    }

    static {
    }

    public CronetEngine() {
    }

    public abstract TTMpaService createTTMpaService();

    public abstract URLStreamHandlerFactory createURLStreamHandlerFactory();

    public abstract byte[] getGlobalMetricsDeltas();

    public abstract List<Long> getOpaqueFuncAddress();

    public abstract String getVersionString();

    public abstract TTNetDiagnosisRequest.Builder newNetDiagnosisRequestBuilder(TTNetDiagnosisRequest.Callback r10, Executor r11);

    public abstract UrlRequest.Builder newUrlRequestBuilder(String r10, UrlRequest.Callback r11, Executor r12);

    public abstract TTWebsocketConnection.Builder newWebsocketConnectionBuilder(TTWebsocketConnection.Callback r10, Executor r11);

    public abstract URLConnection openConnection(URL r10);

    public abstract URLConnection openConnection(URL r10, Proxy r11, boolean r12);

    public abstract void setAlogFuncAddr(long r10);

    public abstract void setAppStartUpState(int r10);

    public abstract void setCookieInitCompleted();

    public abstract void setHostResolverRules(String r10);

    public abstract void shutdown();

    public abstract void startNetLogToFile(String r10, boolean r11);

    public abstract void stopNetLog();
}
