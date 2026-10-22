package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.util.Pair;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ICronetEngineBuilder;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import defpackage.b;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CronetEngineBuilderImpl extends ICronetEngineBuilder {
    private static final Pattern INVALID_PKP_HOST_NAME = null;
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String JAVA_CRONET_IMPL_CLASS = "com.ttnet.org.chromium.net.impl.JavaCronetEngine";
    private static final String NATIVE_CRONET_IMPL_CLASS = "com.ttnet.org.chromium.net.impl.CronetUrlRequestContext";
    private static final String TAG = "CronetEngineBuilderImpl";
    private long mALogFuncAddr;
    private TTAppInfoProvider mAppInfoProvider;
    private TTMonitorProvider mAppMonitorProvider;
    private final Context mApplicationContext;
    private String mBoeJson;
    private boolean mBoeProxyEnabled;
    private boolean mBrotiEnabled;
    private Map<String[], Pair<byte[], byte[]>> mClientOpaqueData;
    private String mCronetSoPath;
    private boolean mDisableCache;
    private TTEventListener mEventListener;
    private String mExperimentalOptions;
    private String mGetDomainDefaultJSON;
    private boolean mHttp2Enabled;
    private long mHttpCacheMaxSize;
    private int mHttpCacheMode;
    private boolean mHttpDnsEnabled;
    private boolean mListenAppStateIndependently;
    protected long mMockCertVerifier;
    private boolean mNetworkQualityEstimatorEnabled;
    private ArrayList<byte[]> mOpaqueData;
    private final List<Pkp> mPkps;
    private String mProxyConfig;
    private boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    private boolean mQuicEnabled;
    private final List<QuicHint> mQuicHints;
    private String mStoragePath;
    private String mStoreIdcRuleJson;
    private int mThreadPriority;
    private String mUserAgent;
    private boolean mVerboseLogEnabled;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpCacheSetting {
    }

    public static class Pkp {
        final Date mExpirationDate;
        final byte[][] mHashes;
        final String mHost;
        final boolean mIncludeSubdomains;

        public Pkp(String r8, byte[][] r10, boolean r11, Date r12) {
            this.mHost = r8;
            this.mHashes = r10;
            this.mIncludeSubdomains = r11;
            this.mExpirationDate = r12;
        }
    }

    public static class QuicHint {
        final int mAlternatePort;
        final String mHost;
        final int mPort;

        public QuicHint(String r8, int r10, int r11) {
            this.mHost = r8;
            this.mPort = r10;
            this.mAlternatePort = r11;
        }
    }

    static {
        INVALID_PKP_HOST_NAME = Pattern.compile("^[0-9\\.]*$");
    }

    public CronetEngineBuilderImpl(Context r8) {
        this.mQuicHints = new LinkedList();
        this.mPkps = new LinkedList();
        this.mThreadPriority = 20;
        this.mApplicationContext = r8.getApplicationContext();
        enableQuic(false);
        enableHttp2(true);
        enableBrotli(false);
        enableHttpCache(0, 0);
        enableNetworkQualityEstimator(false);
        enablePublicKeyPinningBypassForLocalTrustAnchors(true);
        enableHttpDns(false);
        listenAppStateIndependently(false);
    }

    private static String validateHostNameForPinningAndConvert(String r8) {
        if (INVALID_PKP_HOST_NAME.matcher(r8).matches() == true) goto L14;
        if (r8.length() > 255) goto L12;
        return IDN.toASCII(r8, 2);
    L10:
        throw new IllegalArgumentException(b.d("Hostname ", r8, " is illegal. The name of the host does not comply with RFC 1122 and RFC 1123."));
    L12:
        throw new IllegalArgumentException(b.d("Hostname ", r8, " is too long. The name of the host does not comply with RFC 1122 and RFC 1123."));
    L14:
        throw new IllegalArgumentException(b.d("Hostname ", r8, " is illegal. A hostname should not consist of digits and/or dots only."));
    }

    public long aLogFuncAddr() {
        return this.mALogFuncAddr;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addPublicKeyPins(String r8, Set r10, boolean r11, Date r12) {
        return addPublicKeyPins(r8, r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addQuicHint(String r8, int r10, int r11) {
        return addQuicHint(r8, r10, r11);
    }

    public boolean boeProxyEnabled() {
        return this.mBoeProxyEnabled;
    }

    public boolean brotliEnabled() {
        return this.mBrotiEnabled;
    }

    public boolean cacheDisabled() {
        return this.mDisableCache;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBoeProxy(boolean r8) {
        return enableBoeProxy(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBrotli(boolean r8) {
        return enableBrotli(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttp2(boolean r8) {
        return enableHttp2(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpCache(int r8, long r10) {
        return enableHttpCache(r8, r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpDns(boolean r8) {
        return enableHttpDns(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableNetworkQualityEstimator(boolean r8) {
        return enableNetworkQualityEstimator(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r8) {
        return enablePublicKeyPinningBypassForLocalTrustAnchors(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableQuic(boolean r8) {
        return enableQuic(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableSdch(boolean r8) {
        return enableSdch(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableVerboseLog() {
        return enableVerboseLog();
    }

    public String experimentalOptions() {
        return this.mExperimentalOptions;
    }

    public TTAppInfoProvider getAppInfoProvider() {
        return this.mAppInfoProvider;
    }

    public TTMonitorProvider getAppMonitorProvider() {
        return this.mAppMonitorProvider;
    }

    public String getBypassBOEJSON() {
        return this.mBoeJson;
    }

    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        return this.mClientOpaqueData;
    }

    public Context getContext() {
        return this.mApplicationContext;
    }

    public String getCronetSoPath() {
        return this.mCronetSoPath;
    }

    public String getDefaultQuicUserAgentId() {
        if (this.mQuicEnabled == true) goto L7;
        return "";
    L7:
        return UserAgent.getQuicUserAgentIdFrom(this.mApplicationContext);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public String getDefaultUserAgent() {
        return UserAgent.from(this.mApplicationContext);
    }

    public TTEventListener getEventListener() {
        return this.mEventListener;
    }

    public String getGetDomainDefaultJSON() {
        return this.mGetDomainDefaultJSON;
    }

    public boolean getListenAppStateIndependently() {
        return this.mListenAppStateIndependently;
    }

    public ArrayList<byte[]> getOpaqueData() {
        return this.mOpaqueData;
    }

    public String getProxyConfig() {
        return this.mProxyConfig;
    }

    public String getStoreIdcRuleJSON() {
        return this.mStoreIdcRuleJson;
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public boolean http2Enabled() {
        return this.mHttp2Enabled;
    }

    public long httpCacheMaxSize() {
        return this.mHttpCacheMaxSize;
    }

    public int httpCacheMode() {
        return this.mHttpCacheMode;
    }

    public boolean httpDnsEnabled() {
        return this.mHttpDnsEnabled;
    }

    public VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder listenAppStateIndependently(boolean r8) {
        return listenAppStateIndependently(r8);
    }

    public long mockCertVerifier() {
        return this.mMockCertVerifier;
    }

    public boolean networkQualityEstimatorEnabled() {
        return this.mNetworkQualityEstimatorEnabled;
    }

    public boolean publicKeyPinningBypassForLocalTrustAnchorsEnabled() {
        return this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    }

    public List<Pkp> publicKeyPins() {
        return this.mPkps;
    }

    public boolean quicEnabled() {
        return this.mQuicEnabled;
    }

    public List<QuicHint> quicHints() {
        return this.mQuicHints;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setALogFuncAddr(long r8) {
        return setALogFuncAddr(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppInfoProvider(TTAppInfoProvider r8) {
        return setAppInfoProvider(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppMonitorProvider(TTMonitorProvider r8) {
        return setAppMonitorProvider(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setBypassBOEJSON(String r8) {
        return setBypassBOEJSON(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setClientOpaqueData(Map r8) {
        return setClientOpaqueData(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setCronetSoPath(String r8) {
        this.mCronetSoPath = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setEventListener(TTEventListener r8) {
        return setEventListener(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setExperimentalOptions(String r8) {
        return setExperimentalOptions(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setGetDomainDefaultJSON(String r8) {
        return setGetDomainDefaultJSON(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r8) {
        return setLibraryLoader(r8);
    }

    public CronetEngineBuilderImpl setMockCertVerifierForTesting(long r8) {
        this.mMockCertVerifier = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOpaqueData(ArrayList r8) {
        return setOpaqueData(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setProxyConfig(String r8) {
        return setProxyConfig(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoragePath(String r8) {
        return setStoragePath(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoreIdcRuleJSON(String r8) {
        return setStoreIdcRuleJSON(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadPriority(int r8) {
        return setThreadPriority(r8);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setUserAgent(String r8) {
        return setUserAgent(r8);
    }

    public String storagePath() {
        return this.mStoragePath;
    }

    public int threadPriority(int r8) {
        int r10 = this.mThreadPriority;
        if (r10 != 20) goto L6;
        return r8;
    L6:
        return r10;
    }

    public boolean verboseLogEnabled() {
        return this.mVerboseLogEnabled;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl addPublicKeyPins(String r8, Set<byte[]> r10, boolean r11, Date r12) {
        if (r8 == null) goto L22;
        if (r10 == null) goto L20;
        if (r12 == null) goto L18;
        String r13 = validateHostNameForPinningAndConvert(r8);
        HashSet r14 = new HashSet(r10.size());
        Iterator<byte[]> r15 = r10.iterator();
    L7:
        if (r15.hasNext() == false) goto L15;
        byte[] r16 = r15.next();
        if (r16 == null) goto L14;
        if (r16.length != 32) goto L14;
        r14.add(r16);
    L14:
        throw new IllegalArgumentException("Public key pin is invalid");
    L15:
        this.mPkps.add(new Pkp(r13, (byte[][]) r14.toArray(new byte[r14.size()][]), r11, r12));
        return this;
    L18:
        throw new NullPointerException("The pin expiration date cannot be null");
    L20:
        throw new NullPointerException("The set of SHA256 pins cannot be null");
    L22:
        throw new NullPointerException("The hostname cannot be null");
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl addQuicHint(String r8, int r10, int r11) {
        if (r8.contains("/") == true) goto L7;
        this.mQuicHints.add(new QuicHint(r8, r10, r11));
        return this;
    L7:
        throw new IllegalArgumentException("Illegal QUIC Hint Host: ".concat(r8));
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableBoeProxy(boolean r8) {
        this.mBoeProxyEnabled = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableBrotli(boolean r8) {
        this.mBrotiEnabled = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttp2(boolean r8) {
        this.mHttp2Enabled = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttpCache(int r8, long r10) {
        if (r8 == 3) goto L12;
        if (r8 == 2) goto L12;
        if (storagePath() == null) goto L14;
        throw new IllegalArgumentException("Storage path must not be set");
    L14:
        if (r8 == 0) goto L18;
        if (r8 == 2) goto L18;
        boolean r11 = false;
    L19:
        this.mDisableCache = r11;
        this.mHttpCacheMaxSize = r10;
        if (r8 == 0) goto L29;
        if (r8 == 1) goto L28;
        if (r8 == 2) goto L27;
        if (r8 == 3) goto L27;
        throw new IllegalArgumentException("Unknown cache mode");
    L27:
        this.mHttpCacheMode = 1;
    L30:
        return this;
    L28:
        this.mHttpCacheMode = 2;
        goto L30
    L29:
        this.mHttpCacheMode = 0;
    L18:
        r11 = true;
    L12:
        if (storagePath() != null) goto L14;
        throw new IllegalArgumentException("Storage path must be set");
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttpDns(boolean r8) {
        this.mHttpDnsEnabled = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableNetworkQualityEstimator(boolean r8) {
        this.mNetworkQualityEstimatorEnabled = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r8) {
        this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableQuic(boolean r8) {
        this.mQuicEnabled = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableSdch(boolean r8) {
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableVerboseLog() {
        this.mVerboseLogEnabled = true;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl listenAppStateIndependently(boolean r8) {
        this.mListenAppStateIndependently = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setALogFuncAddr(long r8) {
        this.mALogFuncAddr = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppInfoProvider(TTAppInfoProvider r8) {
        this.mAppInfoProvider = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppMonitorProvider(TTMonitorProvider r8) {
        this.mAppMonitorProvider = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setBypassBOEJSON(String r8) {
        this.mBoeJson = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r8) {
        this.mClientOpaqueData = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setEventListener(TTEventListener r8) {
        this.mEventListener = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setExperimentalOptions(String r8) {
        this.mExperimentalOptions = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setGetDomainDefaultJSON(String r8) {
        this.mGetDomainDefaultJSON = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLibraryLoader(CronetEngine.Builder.LibraryLoader r8) {
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOpaqueData(ArrayList<byte[]> r8) {
        this.mOpaqueData = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setProxyConfig(String r8) {
        this.mProxyConfig = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStoragePath(String r8) {
        File r10 = new File(r8);
        if (r10.exists() == true) goto L10;
        if (r10.mkdirs() == true) goto L10;
        throw new IllegalArgumentException("create Storage path failed");
    L10:
        if (r10.isDirectory() == false) goto L14;
        this.mStoragePath = r8;
        return this;
    L14:
        throw new IllegalArgumentException("Storage path must be set to existing directory");
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStoreIdcRuleJSON(String r8) {
        this.mStoreIdcRuleJson = r8;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadPriority(int r8) {
        if (r8 > 19) goto L9;
        if (r8 < (-20)) goto L9;
        this.mThreadPriority = r8;
        return this;
    L9:
        throw new IllegalArgumentException("Thread priority invalid");
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setUserAgent(String r8) {
        this.mUserAgent = r8;
        return this;
    }
}
