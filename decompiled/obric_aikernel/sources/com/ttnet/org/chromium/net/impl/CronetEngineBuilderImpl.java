package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ICronetEngineBuilder;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CronetEngineBuilderImpl extends ICronetEngineBuilder {
    private static final Pattern INVALID_PKP_HOST_NAME = null;
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String JAVA_CRONET_IMPL_CLASS = "com.ttnet.org.chromium.net.impl.JavaCronetEngine";
    private static final String NATIVE_CRONET_IMPL_CLASS = "com.ttnet.org.chromium.net.impl.CronetUrlRequestContext";
    private static String TAG;
    private long mALogFuncAddr;
    private TTAppInfoProvider mAppInfoProvider;
    private TTAppInfoProvider.AppInfo mAppInfoSubset;
    private TTMonitorProvider mAppMonitorProvider;
    private int mAppSecurityLevel;
    private final Context mApplicationContext;
    private String mBoeJson;
    private boolean mBoeProxyEnabled;
    private boolean mBrotiEnabled;
    private TTThreadConfigInfoProvider.Callback mCallback;
    private Map<String[], Pair<byte[], byte[]>> mClientOpaqueData;
    private String mCronetSoPath;
    private boolean mDisableCache;
    private TTEventListener mEventListener;
    private String mExperimentalOptions;
    private String mGetDomainDefaultJSON;
    private boolean mHttp2Enabled;
    private long mHttpCacheMaxSize;
    private HttpCacheMode mHttpCacheMode;
    private boolean mHttpDnsEnabled;
    private boolean mIsMainProcess;
    private boolean mLazyInitIPC;
    private boolean mListenAppStateIndependently;
    protected long mMockCertVerifier;
    private boolean mNetworkQualityEstimatorEnabled;
    private ArrayList<byte[]> mOpaqueData;
    private boolean mOptInit;
    private boolean mOptNqeDefault;
    private boolean mOptNqePersist;
    private final List<Pkp> mPkps;
    private String mProcessName;
    private String mProxyConfig;
    private boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    private boolean mQuicEnabled;
    private final List<QuicHint> mQuicHints;
    private TTSamplingSettingProvider.TTSlaSamplingSetting mSlaSamplingSetting;
    private String mStoragePath;
    private String mStoreIdcRuleJson;
    private long mTTNetInitStart;
    private ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> mThreadConfigInfoList;
    private int mThreadPriority;
    private boolean mTncSecureModeEnabled;
    private String mUserAgent;
    private boolean mVerboseLogEnabled;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode = null;

        static {
            int[] r10 = new int[HttpCacheMode.values().length];
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode = r10;
            r10[HttpCacheMode.DISABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[HttpCacheMode.DISK_NO_HTTP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[HttpCacheMode.DISK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[HttpCacheMode.MEMORY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @VisibleForTesting
    static final enum HttpCacheMode extends Enum<HttpCacheMode> {
        private static final /* synthetic */ HttpCacheMode[] $VALUES = null;
        public static final HttpCacheMode DISABLED = null;
        public static final HttpCacheMode DISK = null;
        public static final HttpCacheMode DISK_NO_HTTP = null;
        public static final HttpCacheMode MEMORY = null;
        private final boolean mContentCacheEnabled;
        private final int mType;

        static {
            HttpCacheMode r10 = new HttpCacheMode("DISABLED", 0, 0, false);
            DISABLED = r10;
            HttpCacheMode r11 = new HttpCacheMode("DISK", 1, 1, true);
            DISK = r11;
            HttpCacheMode r12 = new HttpCacheMode("DISK_NO_HTTP", 2, 1, false);
            DISK_NO_HTTP = r12;
            HttpCacheMode r13 = new HttpCacheMode("MEMORY", 3, 2, true);
            MEMORY = r13;
            $VALUES = new HttpCacheMode[]{r10, r11, r12, r13};
        }

        private HttpCacheMode(String r10, int r11, int r12, boolean r13) {
            super(r10, r11);
            this.mContentCacheEnabled = r13;
            this.mType = r12;
        }

        @VisibleForTesting
        static HttpCacheMode fromPublicBuilderCacheMode(int r10) {
            if (r10 == 0) goto L18;
            if (r10 == 1) goto L16;
            if (r10 == 2) goto L14;
            if (r10 != 3) goto L12;
            return DISK;
        L12:
            throw new IllegalArgumentException("Unknown public builder cache mode");
        L14:
            return DISK_NO_HTTP;
        L16:
            return MEMORY;
        L18:
            return DISABLED;
        }

        public static HttpCacheMode valueOf(String r10) {
            return (HttpCacheMode) Enum.valueOf(HttpCacheMode.class, r10);
        }

        public static HttpCacheMode[] values() {
            return (HttpCacheMode[]) $VALUES.clone();
        }

        int getType() {
            return this.mType;
        }

        boolean isContentCacheEnabled() {
            return this.mContentCacheEnabled;
        }

        int toPublicBuilderCacheMode() {
            int r10 = AnonymousClass1.$SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[ordinal()];
            if (r10 == 1) goto L14;
            int r11 = 2;
            if (r10 == 2) goto L13;
            r11 = 3;
            if (r10 == 3) goto L13;
            if (r10 != 4) goto L12;
            return 1;
        L12:
            throw new IllegalArgumentException("Unknown internal builder cache mode");
        L13:
            return r11;
        L14:
            return 0;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpCacheSetting {
    }

    public static class Pkp {
        final Date mExpirationDate;
        final byte[][] mHashes;
        final String mHost;
        final boolean mIncludeSubdomains;

        Pkp(String r10, byte[][] r11, boolean r12, Date r13) {
            this.mHost = r10;
            this.mHashes = r11;
            this.mIncludeSubdomains = r12;
            this.mExpirationDate = r13;
        }
    }

    public static class QuicHint {
        final int mAlternatePort;
        final String mHost;
        final int mPort;

        QuicHint(String r10, int r11, int r12) {
            this.mHost = r10;
            this.mPort = r11;
            this.mAlternatePort = r12;
        }
    }

    static {
        INVALID_PKP_HOST_NAME = Pattern.compile("^[0-9\\.]*$");
    }

    public CronetEngineBuilderImpl(Context r10, boolean r11) {
        this.mQuicHints = new LinkedList();
        this.mPkps = new LinkedList();
        this.mThreadPriority = 20;
        this.mApplicationContext = r10.getApplicationContext();
        enableQuic(true);
        enableHttp2(true);
        enableBrotli(false);
        enableHttpCache(0, 0);
        enableNetworkQualityEstimator(false);
        enablePublicKeyPinningBypassForLocalTrustAnchors(true);
        enableHttpDns(false);
        listenAppStateIndependently(false);
        if (r11 == true) goto L5;
        String r12 = CronetEngineBuilderImpl.class.getSimpleName();
    L6:
        TAG = r12;
        return;
    L5:
        r12 = "CronetEngineBuilderImpl";
        goto L6
    }

    private static String validateHostNameForPinningAndConvert(String r10) {
        boolean r11 = INVALID_PKP_HOST_NAME.matcher(r10).matches();     // Catch: IllegalArgumentException -> L4
    L6:
        if (r11 == true) goto L17;
        if (r10.length() > 255) goto L15;
        return IDN.toASCII(r10, 2);
    L13:
        throw new IllegalArgumentException("Hostname " + r10 + " is illegal. The name of the host does not comply with RFC 1122 and RFC 1123.");
    L15:
        throw new IllegalArgumentException("Hostname " + r10 + " is too long. The name of the host does not comply with RFC 1122 and RFC 1123.");
    L17:
        throw new IllegalArgumentException("Hostname " + r10 + " is illegal. A hostname should not consist of digits and/or dots only.");
    L4:
        r11 = false;
        goto L6
    }

    TTAppInfoProvider.AppInfo TTAppInfoSubset() {
        return this.mAppInfoSubset;
    }

    long aLogFuncAddr() {
        return this.mALogFuncAddr;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addPublicKeyPins(String r10, Set r11, boolean r12, Date r13) {
        return addPublicKeyPins(r10, r11, r12, r13);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl addPublicKeyPins(String r10, Set<byte[]> r11, boolean r12, Date r13) {
        Objects.requireNonNull(r10, "The hostname cannot be null");
        Objects.requireNonNull(r11, "The set of SHA256 pins cannot be null");
        Objects.requireNonNull(r13, "The pin expiration date cannot be null");
        String r14 = validateHostNameForPinningAndConvert(r10);
        HashMap r15 = new HashMap();
        Iterator<byte[]> r16 = r11.iterator();
    L4:
        if (r16.hasNext() == false) goto L12;
        byte[] r17 = r16.next();
        if (r17 == null) goto L11;
        if (r17.length != 32) goto L11;
        r15.put(Base64.encodeToString(r17, 0), r17);
    L11:
        throw new IllegalArgumentException("Public key pin is invalid");
    L12:
        this.mPkps.add(new Pkp(r14, (byte[][]) r15.values().toArray(new byte[r15.size()][]), r12, r13));
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addQuicHint(String r10, int r11, int r12) {
        return addQuicHint(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl addQuicHint(String r10, int r11, int r12) {
        if (r10.contains("/") == true) goto L7;
        this.mQuicHints.add(new QuicHint(r10, r11, r12));
        return this;
    L7:
        throw new IllegalArgumentException("Illegal QUIC Hint Host: " + r10);
    }

    boolean boeProxyEnabled() {
        return this.mBoeProxyEnabled;
    }

    boolean brotliEnabled() {
        return this.mBrotiEnabled;
    }

    boolean cacheDisabled() {
        return !this.mHttpCacheMode.isContentCacheEnabled();
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBoeProxy(boolean r10) {
        return enableBoeProxy(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableBoeProxy(boolean r10) {
        this.mBoeProxyEnabled = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBrotli(boolean r10) {
        return enableBrotli(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableBrotli(boolean r10) {
        this.mBrotiEnabled = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttp2(boolean r10) {
        return enableHttp2(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttp2(boolean r10) {
        this.mHttp2Enabled = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpCache(int r10, long r11) {
        return enableHttpCache(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttpCache(int r10, long r11) {
        HttpCacheMode r12 = HttpCacheMode.fromPublicBuilderCacheMode(r10);
        if (r12.getType() == 1) goto L5;
    L9:
        this.mHttpCacheMode = r12;
        this.mHttpCacheMaxSize = r11;
        return this;
    L5:
        if (storagePath() != null) goto L9;
        throw new IllegalArgumentException("Storage path must be set");
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpDns(boolean r10) {
        return enableHttpDns(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttpDns(boolean r10) {
        this.mHttpDnsEnabled = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableNetworkQualityEstimator(boolean r10) {
        return enableNetworkQualityEstimator(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableNetworkQualityEstimator(boolean r10) {
        this.mNetworkQualityEstimatorEnabled = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r10) {
        return enablePublicKeyPinningBypassForLocalTrustAnchors(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r10) {
        this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableQuic(boolean r10) {
        return enableQuic(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableQuic(boolean r10) {
        this.mQuicEnabled = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableSdch(boolean r10) {
        return enableSdch(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableSdch(boolean r10) {
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableTncSecureMode(boolean r10) {
        return enableTncSecureMode(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableTncSecureMode(boolean r10) {
        this.mTncSecureModeEnabled = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableVerboseLog() {
        return enableVerboseLog();
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableVerboseLog() {
        this.mVerboseLogEnabled = true;
        return this;
    }

    public String experimentalOptions() {
        return this.mExperimentalOptions;
    }

    TTAppInfoProvider getAppInfoProvider() {
        return this.mAppInfoProvider;
    }

    TTMonitorProvider getAppMonitorProvider() {
        return this.mAppMonitorProvider;
    }

    int getAppSecurityLevel() {
        return this.mAppSecurityLevel;
    }

    String getBypassBOEJSON() {
        return this.mBoeJson;
    }

    Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        return this.mClientOpaqueData;
    }

    Context getContext() {
        return this.mApplicationContext;
    }

    public String getCronetSoPath() {
        return this.mCronetSoPath;
    }

    String getDefaultQuicUserAgentId() {
        if (this.mQuicEnabled == true) goto L7;
        return "";
    L7:
        return UserAgent.getQuicUserAgentIdFrom(this.mApplicationContext);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public String getDefaultUserAgent() {
        return UserAgent.from(this.mApplicationContext);
    }

    TTEventListener getEventListener() {
        return this.mEventListener;
    }

    String getGetDomainDefaultJSON() {
        return this.mGetDomainDefaultJSON;
    }

    boolean getListenAppStateIndependently() {
        return this.mListenAppStateIndependently;
    }

    ArrayList<byte[]> getOpaqueData() {
        return this.mOpaqueData;
    }

    String getProxyConfig() {
        return this.mProxyConfig;
    }

    String getStoreIdcRuleJSON() {
        return this.mStoreIdcRuleJson;
    }

    @VisibleForTesting
    String getUserAgent() {
        return this.mUserAgent;
    }

    @VisibleForTesting
    boolean http2Enabled() {
        return this.mHttp2Enabled;
    }

    long httpCacheMaxSize() {
        return this.mHttpCacheMaxSize;
    }

    @VisibleForTesting
    int httpCacheMode() {
        return this.mHttpCacheMode.getType();
    }

    boolean httpDnsEnabled() {
        return this.mHttpDnsEnabled;
    }

    boolean isMainProcess() {
        return this.mIsMainProcess;
    }

    boolean lazyInitIPC() {
        return this.mLazyInitIPC;
    }

    VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder listenAppStateIndependently(boolean r10) {
        return listenAppStateIndependently(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl listenAppStateIndependently(boolean r10) {
        this.mListenAppStateIndependently = r10;
        return this;
    }

    long mockCertVerifier() {
        return this.mMockCertVerifier;
    }

    @VisibleForTesting
    boolean networkQualityEstimatorEnabled() {
        return this.mNetworkQualityEstimatorEnabled;
    }

    boolean optInit() {
        return this.mOptInit;
    }

    boolean optNqeDefault() {
        return this.mOptNqeDefault;
    }

    boolean optNqePersist() {
        return this.mOptNqePersist;
    }

    String processName() {
        return this.mProcessName;
    }

    int publicBuilderHttpCacheMode() {
        return this.mHttpCacheMode.toPublicBuilderCacheMode();
    }

    @VisibleForTesting
    boolean publicKeyPinningBypassForLocalTrustAnchorsEnabled() {
        return this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    }

    List<Pkp> publicKeyPins() {
        return this.mPkps;
    }

    @VisibleForTesting
    boolean quicEnabled() {
        return this.mQuicEnabled;
    }

    List<QuicHint> quicHints() {
        return this.mQuicHints;
    }

    TTSamplingSettingProvider.TTSlaSamplingSetting samplingSetting() {
        return this.mSlaSamplingSetting;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setALogFuncAddr(long r10) {
        return setALogFuncAddr(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setALogFuncAddr(long r10) {
        this.mALogFuncAddr = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppInfoProvider(TTAppInfoProvider r10) {
        return setAppInfoProvider(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppInfoProvider(TTAppInfoProvider r10) {
        this.mAppInfoProvider = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppMonitorProvider(TTMonitorProvider r10) {
        return setAppMonitorProvider(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppMonitorProvider(TTMonitorProvider r10) {
        this.mAppMonitorProvider = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppSecurityLevel(int r10) {
        return setAppSecurityLevel(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppSecurityLevel(int r10) {
        this.mAppSecurityLevel = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setBypassBOEJSON(String r10) {
        return setBypassBOEJSON(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setBypassBOEJSON(String r10) {
        this.mBoeJson = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setClientOpaqueData(Map r10) {
        return setClientOpaqueData(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r10) {
        this.mClientOpaqueData = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setCronetSoPath(String r10) {
        this.mCronetSoPath = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setEventListener(TTEventListener r10) {
        return setEventListener(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setEventListener(TTEventListener r10) {
        this.mEventListener = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setExperimentalOptions(String r10) {
        return setExperimentalOptions(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setExperimentalOptions(String r10) {
        this.mExperimentalOptions = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setGetDomainDefaultJSON(String r10) {
        return setGetDomainDefaultJSON(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setGetDomainDefaultJSON(String r10) {
        this.mGetDomainDefaultJSON = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setIsMainProcess(boolean r10) {
        return setIsMainProcess(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setIsMainProcess(boolean r10) {
        this.mIsMainProcess = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLazyInitIPC(boolean r10) {
        return setLazyInitIPC(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLazyInitIPC(boolean r10) {
        this.mLazyInitIPC = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r10) {
        return setLibraryLoader(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLibraryLoader(CronetEngine.Builder.LibraryLoader r10) {
        return this;
    }

    @VisibleForTesting
    public CronetEngineBuilderImpl setMockCertVerifierForTesting(long r10) {
        this.mMockCertVerifier = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOpaqueData(ArrayList r10) {
        return setOpaqueData(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOpaqueData(ArrayList<byte[]> r10) {
        this.mOpaqueData = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOptInit(boolean r10) {
        return setOptInit(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOptInit(boolean r10) {
        this.mOptInit = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOptNqeInit(boolean r10, boolean r11) {
        return setOptNqeInit(r10, r11);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOptNqeInit(boolean r10, boolean r11) {
        this.mOptNqeDefault = r10;
        this.mOptNqePersist = r11;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setProcessName(String r10) {
        return setProcessName(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setProcessName(String r10) {
        this.mProcessName = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setProxyConfig(String r10) {
        return setProxyConfig(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setProxyConfig(String r10) {
        this.mProxyConfig = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r10) {
        return setSlaSamplingSetting(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r10) {
        this.mSlaSamplingSetting = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoragePath(String r10) {
        return setStoragePath(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStoragePath(String r10) {
        File r11 = new File(r10);
        if (r11.exists() == true) goto L10;
        if (r11.mkdirs() == true) goto L10;
        throw new IllegalArgumentException("create Storage path failed");
    L10:
        if (r11.isDirectory() == false) goto L14;
        this.mStoragePath = r10;
        return this;
    L14:
        throw new IllegalArgumentException("Storage path must be set to existing directory");
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoreIdcRuleJSON(String r10) {
        return setStoreIdcRuleJSON(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStoreIdcRuleJSON(String r10) {
        this.mStoreIdcRuleJson = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r10) {
        return setTTAppInfoColdStartSubset(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r10) {
        this.mAppInfoSubset = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTTNetInitStart(long r10) {
        return setTTNetInitStart(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setTTNetInitStart(long r10) {
        this.mTTNetInitStart = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r10) {
        return setThreadConfigCallbackImpl(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r10) {
        this.mCallback = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadConfigInfoList(ArrayList r10) {
        return setThreadConfigInfoList(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r10) {
        this.mThreadConfigInfoList = r10;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadPriority(int r10) {
        return setThreadPriority(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadPriority(int r10) {
        if (r10 > 19) goto L9;
        if (r10 < (-20)) goto L9;
        this.mThreadPriority = r10;
        return this;
    L9:
        throw new IllegalArgumentException("Thread priority invalid");
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setUserAgent(String r10) {
        return setUserAgent(r10);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setUserAgent(String r10) {
        this.mUserAgent = r10;
        return this;
    }

    @VisibleForTesting
    String storagePath() {
        return this.mStoragePath;
    }

    TTThreadConfigInfoProvider.Callback threadConfigCallbackImpl() {
        return this.mCallback;
    }

    ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> threadConfigInfoList() {
        return this.mThreadConfigInfoList;
    }

    @VisibleForTesting
    int threadPriority(int r10) {
        int r11 = this.mThreadPriority;
        if (r11 != 20) goto L6;
        return r10;
    L6:
        return r11;
    }

    boolean tncSecureModeEnabled() {
        return this.mTncSecureModeEnabled;
    }

    long ttnetInitStart() {
        return this.mTTNetInitStart;
    }

    boolean verboseLogEnabled() {
        return this.mVerboseLogEnabled;
    }
}
