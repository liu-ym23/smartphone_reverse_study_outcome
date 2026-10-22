package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import java.net.InetAddress;
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
        protected final ICronetEngineBuilder mBuilderDelegate;

        public static abstract class LibraryLoader {
            public LibraryLoader() {
            }

            public abstract void loadLibrary(String r8);
        }

        public Builder(Context r8) {
            this(createBuilderDelegate(r8));
        }

        public static int compareVersions(String r8, String r10) {
            if (r8 == null) goto L20;
            if (r10 == null) goto L20;
            String[] r11 = r8.split("\\.");
            String[] r12 = r10.split("\\.");
            int r13 = 0;
        L6:
            if (r13 >= r11.length) goto L18;
            if (r13 >= r12.length) goto L18;
            int r14 = Integer.parseInt(r11[r13]);     // Catch: NumberFormatException -> L14
            int r15 = Integer.parseInt(r12[r13]);     // Catch: NumberFormatException -> L14
            if (r14 != r15) goto L11;
            r13 = r13 + 1;
            goto L6
        L11:
            return Integer.signum(r14 - r15);
        L14:
            e = move-exception;
            throw new IllegalArgumentException("Unable to convert version segments into integers: " + r11[r13] + " & " + r12[r13], e);
        L18:
            return Integer.signum(r11.length - r12.length);
        L20:
            throw new IllegalArgumentException("The input values cannot be null");
        }

        private static ICronetEngineBuilder createBuilderDelegate(Context r8) {
            CronetProvider r10 = getEnabledCronetProviders(r8, new ArrayList(CronetProvider.getAllProviders(r8))).get(0);
            if (Log.isLoggable(CronetEngine.access$000(), 3) == false) goto L6;
            Log.d(CronetEngine.access$000(), String.format("Using '%s' provider for creating CronetEngine.Builder.", new Object[]{r10}));
        L6:
            return r10.createBuilder().mBuilderDelegate;
        }

        public static List<CronetProvider> getEnabledCronetProviders(Context r8, List<CronetProvider> r10) {
            if (r10.size() == 0) goto L17;
            Iterator<CronetProvider> r11 = r10.iterator();
        L6:
            if (r11.hasNext() == false) goto L11;
            if (r11.next().isEnabled() == true) goto L6;
            r11.remove();
            goto L6
        L11:
            if (r10.size() == 0) goto L15;
            Collections.sort(r10, new AnonymousClass1());
            return r10;
        L15:
            throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
        L17:
            throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
        }

        public Builder addPublicKeyPins(String r8, Set<byte[]> r10, boolean r11, Date r12) {
            this.mBuilderDelegate.addPublicKeyPins(r8, r10, r11, r12);
            return this;
        }

        public Builder addQuicHint(String r8, int r10, int r11) {
            this.mBuilderDelegate.addQuicHint(r8, r10, r11);
            return this;
        }

        public CronetEngine build() {
            return this.mBuilderDelegate.build();
        }

        public Builder enableBoeProxy(boolean r8) {
            this.mBuilderDelegate.enableBoeProxy(r8);
            return this;
        }

        public Builder enableBrotli(boolean r8) {
            this.mBuilderDelegate.enableBrotli(r8);
            return this;
        }

        public Builder enableHttp2(boolean r8) {
            this.mBuilderDelegate.enableHttp2(r8);
            return this;
        }

        public Builder enableHttpCache(int r8, long r10) {
            this.mBuilderDelegate.enableHttpCache(r8, r10);
            return this;
        }

        public Builder enableHttpDns(boolean r8) {
            this.mBuilderDelegate.enableHttpDns(r8);
            return this;
        }

        public Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r8) {
            this.mBuilderDelegate.enablePublicKeyPinningBypassForLocalTrustAnchors(r8);
            return this;
        }

        public Builder enableQuic(boolean r8) {
            this.mBuilderDelegate.enableQuic(r8);
            return this;
        }

        @Deprecated
        public Builder enableSdch(boolean r8) {
            return this;
        }

        public Builder enableVerboseLog() {
            this.mBuilderDelegate.enableVerboseLog();
            return this;
        }

        public String getDefaultUserAgent() {
            return this.mBuilderDelegate.getDefaultUserAgent();
        }

        public Builder listenAppStateIndependently(boolean r8) {
            this.mBuilderDelegate.listenAppStateIndependently(r8);
            return this;
        }

        public Builder setALogFuncAddr(long r8) {
            this.mBuilderDelegate.setALogFuncAddr(r8);
            return this;
        }

        public Builder setAppInfoProvider(TTAppInfoProvider r8) {
            this.mBuilderDelegate.setAppInfoProvider(r8);
            return this;
        }

        public Builder setAppMonitorProvider(TTMonitorProvider r8) {
            this.mBuilderDelegate.setAppMonitorProvider(r8);
            return this;
        }

        public Builder setBypassBOEJSON(String r8) {
            this.mBuilderDelegate.setBypassBOEJSON(r8);
            return this;
        }

        public Builder setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r8) {
            this.mBuilderDelegate.setClientOpaqueData(r8);
            return this;
        }

        public Builder setCronetSoPath(String r8) {
            this.mBuilderDelegate.setCronetSoPath(r8);
            return this;
        }

        public Builder setEventListener(TTEventListener r8) {
            this.mBuilderDelegate.setEventListener(r8);
            return this;
        }

        public Builder setGetDomainDefaultJSON(String r8) {
            this.mBuilderDelegate.setGetDomainDefaultJSON(r8);
            return this;
        }

        public Builder setLibraryLoader(LibraryLoader r8) {
            this.mBuilderDelegate.setLibraryLoader(r8);
            return this;
        }

        public Builder setOpaqueData(ArrayList<byte[]> r8) {
            this.mBuilderDelegate.setOpaqueData(r8);
            return this;
        }

        public Builder setProxyConfig(String r8) {
            this.mBuilderDelegate.setProxyConfig(r8);
            return this;
        }

        public Builder setStoragePath(String r8) {
            this.mBuilderDelegate.setStoragePath(r8);
            return this;
        }

        public Builder setStoreIdcRuleJSON(String r8) {
            this.mBuilderDelegate.setStoreIdcRuleJSON(r8);
            return this;
        }

        public Builder setUserAgent(String r8) {
            this.mBuilderDelegate.setUserAgent(r8);
            return this;
        }

        public Builder(ICronetEngineBuilder r8) {
            this.mBuilderDelegate = r8;
        }
    }

    public CronetEngine() {
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public abstract TTMpaService createTTMpaService();

    public abstract URLStreamHandlerFactory createURLStreamHandlerFactory();

    public abstract List<InetAddress> dnsLookup(String r8);

    public abstract byte[] getGlobalMetricsDeltas();

    public abstract List<Long> getOpaqueFuncAddress();

    public abstract String getVersionString();

    public abstract TTNetDiagnosisRequest.Builder newNetDiagnosisRequestBuilder(TTNetDiagnosisRequest.Callback r8, Executor r10);

    public abstract UrlRequest.Builder newUrlRequestBuilder(String r8, UrlRequest.Callback r10, Executor r11);

    public abstract TTWebsocketConnection.Builder newWebsocketConnectionBuilder(TTWebsocketConnection.Callback r8, Executor r10);

    public abstract URLConnection openConnection(URL r8);

    public abstract void setAlogFuncAddr(long r8);

    public abstract void setAppStartUpState(int r8);

    public abstract void setHostResolverRules(String r8);

    public abstract void shutdown();

    public abstract void startNetLogToFile(String r8, boolean r10);

    public abstract void stopNetLog();
}
