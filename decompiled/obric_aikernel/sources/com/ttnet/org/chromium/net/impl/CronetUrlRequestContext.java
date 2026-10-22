package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import android.os.ConditionVariable;
import android.os.Process;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.ObserverList;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.NetworkQualityRttListener;
import com.ttnet.org.chromium.net.NetworkQualityThroughputListener;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.TTMpaService;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.ttnet.org.chromium.net.urlconnection.CronetURLStreamHandlerFactory;
import java.io.File;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
@UsedByReflection("CronetEngine.java")
@VisibleForTesting
public class CronetUrlRequestContext extends CronetEngineBase {
    private static final int LOG_DEBUG = -1;
    private static final int LOG_NONE = 3;
    static final String LOG_TAG = "CronetUrlRequestContext";
    private static final int LOG_VERBOSE = -2;
    private static final HashSet<String> sInUseStoragePaths = null;
    private final AtomicInteger mActiveRequestCount;
    private TTAppInfoProvider mAppInfoProvider;
    private TTMonitorProvider mAppMonitorProvider;
    private final int mCronetEngineId;
    private double[] mDownstreamPacketLossRate;
    private double[] mDownstreamPacketLossRateVariance;
    private int mDownstreamThroughputKbps;
    private int mEffectiveConnectionType;
    private int mEffectiveHrttMs;
    private int mEffectiveRxThroughputKbps;
    private int mEffectiveTrttMs;
    private TTEventListener mEventListener;
    private final Object mFinishedListenerLock;
    private final Map<RequestFinishedInfo.Listener, VersionSafeCallbacks.RequestFinishedInfoListener> mFinishedListenerMap;
    private int[] mGroupHttpRttMs;
    private int[] mGroupTransportRttMs;
    private int mHttpRttMs;
    private final String mInUseStoragePath;
    private final ConditionVariable mInitCompleted;
    private boolean mIsLogging;
    private boolean mIsStoppingNetLog;
    private boolean mListenAppStateIndependently;
    private final Object mLock;
    private final CronetLogger mLogger;
    private long mNetworkHandle;
    private final boolean mNetworkQualityEstimatorEnabled;
    private final Object mNetworkQualityLevelLock;
    private final Object mNetworkQualityLock;
    private Thread mNetworkThread;
    private int mNql;
    private final ObserverList<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> mRttListenerList;
    private final boolean mSkipLogging;
    private final ConditionVariable mStopNetLogCompleted;
    private TTThreadConfigInfoProvider.Callback mThreadConfigCallback;
    private Map<TTThreadConfigInfoProvider.ThreadType, TTThreadConfigInfoProvider.BindCore> mThreadTypeBindCoreMap;
    private final Object mThreadTypeIdLock;
    private Map<TTThreadConfigInfoProvider.ThreadType, Integer> mThreadTypeIdMap;
    private final ObserverList<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> mThroughputListenerList;
    private int mTransportRttMs;
    private double[] mUpstreamPacketLossRate;
    private double[] mUpstreamPacketLossRateVariance;
    private long mUrlRequestContextAdapter;
    private String[] mWatchingGroups;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.CronetUrlRequestContext$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore = null;

        static {
            int[] r10 = new int[TTThreadConfigInfoProvider.BindCore.values().length];
            $SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore = r10;
            r10[TTThreadConfigInfoProvider.BindCore.BIG_CORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore[TTThreadConfigInfoProvider.BindCore.LITTLE_CORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore[TTThreadConfigInfoProvider.BindCore.CANCEL_BIND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    interface Natives {
        @NativeClassQualifiedName("CronetContextAdapter")
        void addClientOpaqueData(long r10, CronetUrlRequestContext r11, String[] r12, byte[] r13, byte[] r14, long r15, long r16);

        void addPkp(long r10, String r11, byte[][] r12, boolean r13, long r14);

        void addQuicHint(long r10, String r11, int r12, int r13);

        @NativeClassQualifiedName("CronetContextAdapter")
        void addSamplingSetting(long r10, CronetUrlRequestContext r11, TTSamplingSettingProvider.TTSlaSamplingSetting r12);

        @NativeClassQualifiedName("CronetContextAdapter")
        void clearClientOpaqueData(long r10, CronetUrlRequestContext r11);

        @NativeClassQualifiedName("CronetContextAdapter")
        void configureNetworkQualityEstimatorForTesting(long r10, CronetUrlRequestContext r11, boolean r12, boolean r13, boolean r14);

        @NativeClassQualifiedName("CronetContextAdapter")
        void controlHttpDNSConfig(long r10, CronetUrlRequestContext r11, boolean r12, boolean r13, boolean r14);

        long createRequestContextAdapter(long r10);

        long createRequestContextConfig(String r10, String r11, boolean r12, String r13, boolean r14, boolean r15, boolean r16, int r17, long r18, String r19, long r110, boolean r111, boolean r112, int r113);

        @NativeClassQualifiedName("CronetContextAdapter")
        void destroy(long r10, CronetUrlRequestContext r11);

        @NativeClassQualifiedName("CronetContextAdapter")
        void enableTTBizHttpDns(long r10, CronetUrlRequestContext r11, boolean r12, String r13, String r14, String r15, boolean r16, String r17);

        byte[] getHistogramDeltas();

        long[] getOpaqueFuncAddress();

        void initALogFuncAddr(long r10);

        @NativeClassQualifiedName("CronetContextAdapter")
        void initRequestContextOnInitThread(long r10, CronetUrlRequestContext r11);

        @NativeClassQualifiedName("CronetContextAdapter")
        void notifySwitchToMultiNetwork(long r10, CronetUrlRequestContext r11, boolean r12);

        @NativeClassQualifiedName("CronetContextAdapter")
        void parseTNCConfigFromSystemHTTPRequest(long r10, CronetUrlRequestContext r11, String r12, String r13, String r14, String r15, String r16, String r17);

        @NativeClassQualifiedName("CronetContextAdapter")
        void preconnectUrl(long r10, CronetUrlRequestContext r11, String r12, int r13, String r14);

        @NativeClassQualifiedName("CronetContextAdapter")
        void provideRTTObservations(long r10, CronetUrlRequestContext r11, boolean r12);

        @NativeClassQualifiedName("CronetContextAdapter")
        void provideThroughputObservations(long r10, CronetUrlRequestContext r11, boolean r12);

        @NativeClassQualifiedName("CronetContextAdapter")
        void removeClientOpaqueData(long r10, CronetUrlRequestContext r11, String r12);

        @NativeClassQualifiedName("CronetContextAdapter")
        void reportNetDiagnosisUserLog(long r10, CronetUrlRequestContext r11, String r12);

        @NativeClassQualifiedName("CronetContextAdapter")
        void runInBackGround(long r10, CronetUrlRequestContext r11, boolean r12);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setAlogFuncAddr(long r10, CronetUrlRequestContext r11, long r12);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setAppStartUpState(long r10, CronetUrlRequestContext r11, int r12);

        void setClientOpaqueData(long r10, String[] r11, byte[] r12, byte[] r13);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setCookieInitCompleted(long r10, CronetUrlRequestContext r11);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setHostResolverRules(long r10, CronetUrlRequestContext r11, String r12);

        int setMinLogLevel(int r10);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setProxy(long r10, CronetUrlRequestContext r11, String r12);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setRouteSelectionBestHost(long r10, CronetUrlRequestContext r11, String r12, String r13);

        void setTTNetInitConfig(long r10, int r11, boolean r12, boolean r13, String r14, String r15, String r16, boolean r17, String r18, String r19, byte[][] r110, TTThreadConfigInfoProvider.ThreadConfigInfo[] r111, boolean r112, boolean r113, boolean r114, String r115, TTAppInfoProvider.AppInfo r116, long r117, boolean r21, boolean r22, boolean r23, TTSamplingSettingProvider.TTSlaSamplingSetting r24);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setZstdFuncAddr(long r10, CronetUrlRequestContext r11, long r12, long r13, long r14, long r15, long r16, long r17, long r18, long r19);

        @NativeClassQualifiedName("CronetContextAdapter")
        boolean skipLogging(long r10, CronetUrlRequestContext r11);

        @NativeClassQualifiedName("CronetContextAdapter")
        void startNetLogToDisk(long r10, CronetUrlRequestContext r11, String r12, boolean r13, int r14);

        @NativeClassQualifiedName("CronetContextAdapter")
        boolean startNetLogToFile(long r10, CronetUrlRequestContext r11, String r12, boolean r13);

        @NativeClassQualifiedName("CronetContextAdapter")
        void startThrottle(long r10, CronetUrlRequestContext r11, String[] r12, int r13, long r14);

        @NativeClassQualifiedName("CronetContextAdapter")
        void stopNetLog(long r10, CronetUrlRequestContext r11);

        @NativeClassQualifiedName("CronetContextAdapter")
        void stopThrottle(long r10, CronetUrlRequestContext r11, String[] r12, int r13);

        @NativeClassQualifiedName("CronetContextAdapter")
        void triggerTNCRequestByUser(long r10, CronetUrlRequestContext r11, boolean r12);

        @NativeClassQualifiedName("CronetContextAdapter")
        void triggerWiFiToCellularByThirdParty(long r10, CronetUrlRequestContext r11);

        @NativeClassQualifiedName("CronetContextAdapter")
        void tryStartNetDetect(long r10, CronetUrlRequestContext r11, String[] r12, int r13, int r14);

        @NativeClassQualifiedName("CronetContextAdapter")
        void ttDnsResolve(long r10, CronetUrlRequestContext r11, String r12, int r13, String r14, String r15);

        @NativeClassQualifiedName("CronetContextAdapter")
        void ttUrlDispatch(long r10, CronetUrlRequestContext r11, URLDispatch r12, String r13, boolean r14);

        @NativeClassQualifiedName("CronetContextAdapter")
        void updateStoreRegionFromServer(long r10, CronetUrlRequestContext r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110, String r111, String r112);
    }

    static {
        sInUseStoragePaths = new HashSet();
    }

    @UsedByReflection("CronetEngine.java")
    public CronetUrlRequestContext(CronetEngineBuilderImpl r10) {
        Object r11 = new Object();
        this.mLock = r11;
        this.mInitCompleted = new ConditionVariable(false);
        this.mActiveRequestCount = new AtomicInteger(0);
        this.mNetworkQualityLock = new Object();
        this.mFinishedListenerLock = new Object();
        this.mEffectiveConnectionType = 0;
        this.mHttpRttMs = -1;
        this.mTransportRttMs = -1;
        this.mDownstreamThroughputKbps = -1;
        ObserverList<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> r12 = new ObserverList();
        this.mRttListenerList = r12;
        ObserverList<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> r13 = new ObserverList();
        this.mThroughputListenerList = r13;
        this.mFinishedListenerMap = new HashMap();
        this.mNetworkQualityLevelLock = new Object();
        this.mEffectiveHrttMs = -1;
        this.mEffectiveTrttMs = -1;
        this.mEffectiveRxThroughputKbps = -1;
        this.mUpstreamPacketLossRate = new double[]{-1.0d, -1.0d};
        this.mUpstreamPacketLossRateVariance = new double[]{-1.0d, -1.0d};
        this.mDownstreamPacketLossRate = new double[]{-1.0d, -1.0d};
        this.mDownstreamPacketLossRateVariance = new double[]{-1.0d, -1.0d};
        Object r14 = new Object();
        this.mThreadTypeIdLock = r14;
        this.mThreadTypeIdMap = new HashMap();
        this.mThreadTypeBindCoreMap = new HashMap();
        this.mStopNetLogCompleted = new ConditionVariable();
        this.mNetworkHandle = -1;
        this.mCronetEngineId = hashCode();
        r12.disableThreadAsserts();
        r13.disableThreadAsserts();
        this.mNetworkQualityEstimatorEnabled = r10.networkQualityEstimatorEnabled();
        CronetLibraryLoader.ensureInitialized(r10.getContext(), r10);
        CronetUrlRequestContextJni.get().setMinLogLevel(getLoggingLevel());
        if (r10.httpCacheMode() != 1) goto L16;
        String r15 = r10.storagePath();
        this.mInUseStoragePath = r15;
        HashSet<String> r16 = sInUseStoragePaths;
        monitor-enter(r16);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (r16.add(r15) == false) goto L11;
        monitor-exit(r16);     // Catch: Throwable -> L14
    L17:
        this.mAppInfoProvider = r10.getAppInfoProvider();
        this.mAppMonitorProvider = r10.getAppMonitorProvider();
        this.mEventListener = r10.getEventListener();
        this.mListenAppStateIndependently = r10.getListenAppStateIndependently();
        monitor-enter(r14);
        this.mThreadConfigCallback = r10.threadConfigCallbackImpl();     // Catch: Throwable -> L41
        monitor-exit(r14);     // Catch: Throwable -> L41
        monitor-enter(r11);
        long r17 = CronetUrlRequestContextJni.get().createRequestContextAdapter(createNativeUrlRequestContextConfig(r10));     // Catch: Throwable -> L38
        this.mUrlRequestContextAdapter = r17;     // Catch: Throwable -> L38
        if (r17 == 0) goto L37;
        boolean r18 = CronetUrlRequestContextJni.get().skipLogging(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L38
        this.mSkipLogging = r18;     // Catch: Throwable -> L38
        monitor-exit(r11);     // Catch: Throwable -> L38
        if (r18 == false) goto L28;
        CronetLogger r19 = CronetLoggerFactory.createNoOpLogger();
    L29:
        this.mLogger = r19;
        this.mLogger.logCronetEngineCreation(getCronetEngineId(), new CronetLogger.CronetEngineBuilderInfo(r10), buildCronetVersion(), getCronetSource());     // Catch: RuntimeException -> L32
    L34:
        CronetLibraryLoader.postToInitThread(new AnonymousClass1(this));
        return;
    L32:
        e = move-exception;
        Log.e(LOG_TAG, "Error while trying to log CronetEngine creation: ", new Object[]{e});
        goto L34
    L28:
        r19 = CronetLoggerFactory.createLogger(r10.getContext(), getCronetSource());
        goto L29
    L37:
        throw new NullPointerException("Context Adapter creation failed.");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    L41:
        th = move-exception;
        throw th;
    L11:
        throw new IllegalStateException("Disk cache storage path already in use");     // Catch: Throwable -> L14
    L16:
        this.mInUseStoragePath = null;
        goto L17
    }

    static /* synthetic */ boolean access$000(CronetUrlRequestContext r10) {
        return r10.mListenAppStateIndependently;
    }

    static /* synthetic */ Object access$100(CronetUrlRequestContext r10) {
        return r10.mLock;
    }

    static /* synthetic */ long access$200(CronetUrlRequestContext r10) {
        return r10.mUrlRequestContextAdapter;
    }

    @CalledByNative
    private String[] addSecurityFactor(String r10, String[] r11) {
        HashMap r12 = new HashMap();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r14 >= r11.length) goto L6;
        r12.put(r11[r14].toLowerCase(Locale.US), r11[r14 + 1]);
        r14 = r14 + 2;
        goto L4
    L6:
        Map<String, String> r15 = onCallToAddSecurityFactor(r10, r12);
        if (r15 != null) goto L10;
        return null;
    L10:
        String[] r16 = new String[r15.size() * 2];
        Iterator<Map.Entry<String, String>> r17 = r15.entrySet().iterator();
    L12:
        if (r17.hasNext() == false) goto L14;
        Map.Entry<String, String> r18 = r17.next();
        r16[r13] = r18.getKey();
        r16[r13 + 1] = r18.getValue();
        r13 = r13 + 2;
        goto L12
    L14:
        return r16;
    }

    private CronetLogger.CronetVersion buildCronetVersion() {
        return new CronetLogger.CronetVersion(getVersionString().split("/")[1].split("@")[0]);
    }

    private void checkHaveAdapter() {
        if (haveRequestContextAdapter() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Engine is shut down.");
    }

    private String constructControlHeaders(Map<String, String> r10) {
        String r11 = "";
        if (r10 == null) goto L12;
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L12;
        Map.Entry<String, String> r13 = r12.next();
        String r14 = r13.getKey();
        String r15 = r13.getValue();
        if (r14.isEmpty() == true) goto L6;
        if (r15.isEmpty() == true) goto L6;
        r11 = r14 + ":" + r15 + "\r\n" + r11;
    L12:
        return r11;
    }

    private static int convertConnectionTypeToApiValue(int r10) {
        if (r10 == 0) goto L17;
        int r11 = 1;
        if (r10 == 1) goto L16;
        r11 = 2;
        if (r10 == 2) goto L16;
        r11 = 3;
        if (r10 == 3) goto L16;
        r11 = 4;
        if (r10 == 4) goto L16;
        if (r10 != 5) goto L15;
        return 5;
    L15:
        throw new RuntimeException("Internal Error: Illegal EffectiveConnectionType value " + r10);
    L16:
        return r11;
    L17:
        return 0;
    }

    @VisibleForTesting
    public static long createNativeUrlRequestContextConfig(CronetEngineBuilderImpl r35) {
        String r10 = "";
        File r11 = r35.getContext().getFilesDir();     // Catch: Throwable -> L40
        if (r11 == null) goto L6;
        r10 = r11.getAbsolutePath();     // Catch: Throwable -> L40
    L6:
        String r12 = r10;
        long r33 = CronetUrlRequestContextJni.get().createRequestContextConfig(r35.getUserAgent(), r35.storagePath(), r35.quicEnabled(), r35.getDefaultQuicUserAgentId(), r35.http2Enabled(), r35.brotliEnabled(), r35.cacheDisabled(), r35.httpCacheMode(), r35.httpCacheMaxSize(), r35.experimentalOptions(), r35.mockCertVerifier(), r35.networkQualityEstimatorEnabled(), r35.publicKeyPinningBypassForLocalTrustAnchorsEnabled(), r35.threadPriority(0));
        if (r33 == 0) goto L39;
        Iterator<CronetEngineBuilderImpl.QuicHint> r13 = r35.quicHints().iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        CronetEngineBuilderImpl.QuicHint r14 = r13.next();
        CronetUrlRequestContextJni.get().addQuicHint(r33, r14.mHost, r14.mPort, r14.mAlternatePort);
        goto L10
    L12:
        Iterator<CronetEngineBuilderImpl.Pkp> r15 = r35.publicKeyPins().iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        CronetEngineBuilderImpl.Pkp r16 = r15.next();
        CronetUrlRequestContextJni.get().addPkp(r33, r16.mHost, r16.mHashes, r16.mIncludeSubdomains, r16.mExpirationDate.getTime());
        goto L14
    L16:
        ArrayList<byte[]> r17 = r35.getOpaqueData();
        if (r17 != null) goto L19;
    L21:
        byte[][] r18 = null;
    L22:
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r19 = r35.threadConfigInfoList();
        if (r19 != null) goto L25;
    L27:
        TTThreadConfigInfoProvider.ThreadConfigInfo[] r110 = null;
    L28:
        CronetUrlRequestContextJni.get().setTTNetInitConfig(r33, r35.getAppSecurityLevel(), r35.httpDnsEnabled(), r35.verboseLogEnabled(), r12, r35.getProxyConfig(), r35.getGetDomainDefaultJSON(), r35.boeProxyEnabled(), r35.getBypassBOEJSON(), r35.getStoreIdcRuleJSON(), r18, r110, r35.tncSecureModeEnabled(), r35.isMainProcess(), r35.lazyInitIPC(), r35.processName(), r35.TTAppInfoSubset(), r35.ttnetInitStart(), r35.optInit(), r35.optNqeDefault(), r35.optNqePersist(), r35.samplingSetting());
        Map<String[], Pair<byte[], byte[]>> r20 = r35.getClientOpaqueData();
        if (r20 != null) goto L31;
    L36:
        CronetUrlRequestContextJni.get().initALogFuncAddr(r35.aLogFuncAddr());
        return r33;
    L31:
        if (r20.isEmpty() == true) goto L36;
        Iterator<Map.Entry<String[], Pair<byte[], byte[]>>> r21 = r20.entrySet().iterator();
    L34:
        if (r21.hasNext() == false) goto L36;
        Map.Entry<String[], Pair<byte[], byte[]>> r22 = r21.next();
        CronetUrlRequestContextJni.get().setClientOpaqueData(r33, r22.getKey(), (byte[]) r22.getValue().first, (byte[]) r22.getValue().second);
        goto L34
    L25:
        if (r19.isEmpty() == true) goto L27;
        r110 = (TTThreadConfigInfoProvider.ThreadConfigInfo[]) r19.toArray(new TTThreadConfigInfoProvider.ThreadConfigInfo[r19.size()]);
        goto L28
    L19:
        if (r17.isEmpty() == true) goto L21;
        r18 = (byte[][]) r17.toArray(new byte[r17.size()][]);
        goto L22
    L39:
        throw new IllegalArgumentException("Experimental options parsing failed.");
    }

    static CronetLogger.CronetSource getCronetSource() {
        if (CronetEngine.class.getClassLoader().equals(CronetUrlRequest.class.getClassLoader()) == false) goto L6;
        return CronetLogger.CronetSource.CRONET_SOURCE_STATICALLY_LINKED;
    L6:
        return CronetLogger.CronetSource.CRONET_SOURCE_PLAY_SERVICES;
    }

    private int getLoggingLevel() {
        String r10 = LOG_TAG;
        if (Log.isLoggable(r10, 2) == false) goto L6;
        return -2;
    L6:
        if (Log.isLoggable(r10, 3) == false) goto L10;
        return -1;
    L10:
        return 3;
    }

    @CalledByNative
    private void handleApiResult(boolean r37, String r38, String r39, String r40, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, boolean r61, long r62, long r64, String r66, String r67, String r68, int r69, int r70, String r71) {
        TTMonitorProvider r10 = this.mAppMonitorProvider;
        if (r10 == null) goto L6;
        r10.handleApiResult(r37, r38, r39, r40, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r62, r64, r66, r67, r68, r69, r70, r71);
        return;
    }

    @CalledByNative
    private boolean handleApiSample(String r10, String r11) {
        TTMonitorProvider r12 = this.mAppMonitorProvider;
        if (r12 != null) goto L5;
        return false;
    L5:
        return r12.handleApiSample(r10, r11);
    }

    private void handleProtocolException(int r10) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L12;
        if (r10 != 0) goto L6;
        return;
    L6:
        if (r10 != 1) goto L9;
        return;
    L9:
        throw new IllegalStateException("Error protocol: " + r10);
    L12:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    private boolean haveRequestContextAdapter() {
        if (this.mUrlRequestContextAdapter == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @CalledByNative
    private void initNetworkThread() {
        this.mNetworkThread = Thread.currentThread();
        this.mInitCompleted.open();
        Thread.currentThread().setName("ChromiumNet" + Process.getThreadPriority(0));
        TTEventListener r10 = this.mEventListener;
        if (r10 == null) goto L6;
        r10.onCronetBootSucceed();
        return;
    }

    @CalledByNative
    private void onClientIPChanged(String r10) {
        TTEventListener r11 = this.mEventListener;
        if (r11 == null) goto L6;
        r11.onClientIPChanged(r10);
        return;
    }

    @CalledByNative
    private void onColdStartFinish() {
        TTEventListener r10 = this.mEventListener;
        if (r10 == null) goto L6;
        r10.onColdStartFinish();
        return;
    }

    @CalledByNative
    private void onContextInitCompleted(long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, String r68, String r69) {
        TTCronetInitTimingInfo.sNativeInitTimingJson = r68;
        TTCronetInitTimingInfo.sABTest = r69;
        this.mInitCompleted.open();
        TTEventListener r10 = this.mEventListener;
        if (r10 == null) goto L6;
        r10.onContextInitCompleted(r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66);
        return;
    }

    @CalledByNative
    private void onDropReasonChanged(boolean r10, int[] r11) {
        if (this.mEventListener == null) goto L9;
        List<Integer> r12 = new ArrayList();
        if (r11 == null) goto L7;
        r12 = (List) Arrays.stream(r11).boxed().collect(Collectors.toList());
    L7:
        this.mEventListener.onDropReasonChanged(r10, r12);
        return;
    }

    @CalledByNative
    private void onEffectiveConnectionTypeChanged(int r10) {
        Object r11 = this.mNetworkQualityLock;
        monitor-enter(r11);
        this.mEffectiveConnectionType = r10;     // Catch: Throwable -> L9
        TTEventListener r12 = this.mEventListener;     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        r12.onEffectiveConnectionTypeChanged(r10);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private TTAppInfoProvider.AppInfo onGetAppInfo() {
        TTAppInfoProvider r10 = this.mAppInfoProvider;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getAppInfo();
    }

    @CalledByNative
    private void onGroupRTTOrThroughputEstimatesComputed(String[] r10, int[] r11, int[] r12) {
        Object r13 = this.mNetworkQualityLock;
        monitor-enter(r13);
        this.mWatchingGroups = r10;     // Catch: Throwable -> L7
        this.mGroupTransportRttMs = r11;     // Catch: Throwable -> L7
        this.mGroupHttpRttMs = r12;     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onMultiNetStateChanged(int r10, int r11) {
        TTEventListener r12 = this.mEventListener;
        if (r12 == null) goto L6;
        r12.onMultiNetStateChanged(r10, r11);
        return;
    }

    @CalledByNative
    private void onNQLChanged(int r10) {
        Object r11 = this.mNetworkQualityLevelLock;
        monitor-enter(r11);
        this.mNql = r10;     // Catch: Throwable -> L9
        TTEventListener r12 = this.mEventListener;     // Catch: Throwable -> L9
        if (r12 == null) goto L7;
        r12.onNetworkQualityLevelChanged(r10);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onNetworkQualityRttAndThroughputNotified(int r10, int r11, int r12) {
        Object r13 = this.mNetworkQualityLevelLock;
        monitor-enter(r13);
        this.mEffectiveHrttMs = r10;     // Catch: Throwable -> L9
        this.mEffectiveTrttMs = r11;     // Catch: Throwable -> L9
        this.mEffectiveRxThroughputKbps = r12;     // Catch: Throwable -> L9
        TTEventListener r14 = this.mEventListener;     // Catch: Throwable -> L9
        if (r14 == null) goto L7;
        r14.onNetworkQualityRttAndThroughputNotified(r10, r11, r12);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r13);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onNetworkQualityTypeChangedV3(int r10) {
        TTEventListener r11 = this.mEventListener;
        if (r11 == null) goto L6;
        r11.onNetworkQualityTypeChangedV3(r10);
        return;
    }

    @CalledByNative
    private void onPacketLossComputed(int r12, double r13, double r15, double r17, double r19) {
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        if (r12 != 0) goto L6;
    L10:
        this.mUpstreamPacketLossRate[r12] = r13;     // Catch: Throwable -> L15
        this.mUpstreamPacketLossRateVariance[r12] = r15;     // Catch: Throwable -> L15
        this.mDownstreamPacketLossRate[r12] = r17;     // Catch: Throwable -> L15
        this.mDownstreamPacketLossRateVariance[r12] = r19;     // Catch: Throwable -> L15
        TTEventListener r11 = this.mEventListener;     // Catch: Throwable -> L15
        if (r11 == null) goto L13;
        r11.onPacketLossComputed(r12, r13, r15, r17, r19);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L6:
        if (r12 == 1) goto L10;
        Log.e(LOG_TAG, "Error protocol from native. Protocol: " + r12, new Object[0]);     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onPublicIPsChanged(String[] r10, String[] r11) {
        if (this.mEventListener == null) goto L6;
        ArrayList r12 = new ArrayList(r10.length);
        ArrayList r13 = new ArrayList(r11.length);
        Collections.addAll(r12, r10);
        Collections.addAll(r13, r11);
        this.mEventListener.onPublicIPsChanged(r12, r13);
        return;
    }

    @CalledByNative
    private void onRTTOrThroughputEstimatesComputed(int r10, int r11, int r12) {
        Object r13 = this.mNetworkQualityLock;
        monitor-enter(r13);
        this.mHttpRttMs = r10;     // Catch: Throwable -> L9
        this.mTransportRttMs = r11;     // Catch: Throwable -> L9
        this.mDownstreamThroughputKbps = r12;     // Catch: Throwable -> L9
        TTEventListener r14 = this.mEventListener;     // Catch: Throwable -> L9
        if (r14 == null) goto L7;
        r14.onRTTOrThroughputEstimatesComputed(r10, r11, r12);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r13);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onRttObservation(final int r12, final long r13, final int r15) {
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        Iterator<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> r11 = this.mRttListenerList.iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L8;
        final VersionSafeCallbacks.NetworkQualityRttListenerWrapper r14 = r11.next();     // Catch: Throwable -> L10
        Runnable r16 = new AnonymousClass3(this, r14, r12, r13, r15);     // Catch: Throwable -> L10
        postObservationTaskToExecutor(r14.getExecutor(), r16);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onSendAppMonitorEvent(String r10, String r11) {
        TTMonitorProvider r12 = this.mAppMonitorProvider;
        if (r12 == null) goto L6;
        r12.sendAppMonitorEvent(r10, r11);
        return;
    }

    @CalledByNative
    private void onStoreIdcChanged(String r10, String r11, String r12, String r13, String r14, String r15) {
        TTEventListener r16 = this.mEventListener;
        if (r16 == null) goto L6;
        r16.onStoreIdcChanged(r10, r11, r12, r13, r14, r15);
        return;
    }

    @CalledByNative
    private void onTLBDecompressFail() {
        TTEventListener r10 = this.mEventListener;
        if (r10 == null) goto L6;
        r10.onTLBDecompressFail();
        return;
    }

    @CalledByNative
    private void onTNCConfigChanged(String r10, String r11, String r12) {
        TTEventListener r13 = this.mEventListener;
        if (r13 == null) goto L6;
        r13.onServerConfigUpdated(r10, r11, r12);
        return;
    }

    @CalledByNative
    private void onTNCUpdateFailed(String[] r10, String r11) {
        TTEventListener r12 = this.mEventListener;
        if (r12 == null) goto L6;
        r12.onTNCUpdateFailed(r10, r11);
        return;
    }

    @CalledByNative
    private void onTTDnsResolveResult(String r13, String r14, int r15, int r16, int r17, String[] r18, String r19) {
        Log.d(LOG_TAG, " onTTDnsResolveResult, uuid: " + r13 + " host: " + r14 + " ret: " + r15 + " ips: " + r18.length, new Object[0]);
        ArrayList r10 = new ArrayList(r18.length);
        Collections.addAll(r10, r18);
        TTEventListener r11 = this.mEventListener;
        if (r11 == null) goto L6;
        r11.onTTDnsResolveResult(r13, r14, r15, r16, r17, r10, r19);
        return;
    }

    @CalledByNative
    private void onTTNetDetectInfoChanged(String r10) {
        TTEventListener r11 = this.mEventListener;
        if (r11 == null) goto L6;
        r11.onTTNetDetectInfoChanged(r10);
        return;
    }

    @CalledByNative
    private void onThreadIdChanged(int[] r10) {
        Object r11 = this.mThreadTypeIdLock;
        monitor-enter(r11);
        int r12 = 0;
    L29:
    L26:
        th = move-exception;
        throw th;
    L6:
        if (r12 >= (r10.length - 1)) goto L24;
        TTThreadConfigInfoProvider.ThreadType r13 = TTThreadConfigInfoProvider.ThreadType.values()[r10[r12]];     // Catch: Throwable -> L26
        int r14 = r10[r12 + 1];     // Catch: Throwable -> L26
        this.mThreadTypeIdMap.put(r13, Integer.valueOf(r14));     // Catch: Throwable -> L26
        if (this.mThreadTypeBindCoreMap.containsKey(r13) == true) goto L11;
    L23:
        r12 = r12 + 2;     // Catch: Throwable -> L26
        goto L29
    L11:
        if (this.mThreadConfigCallback == null) goto L23;
        int r15 = AnonymousClass6.$SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore[this.mThreadTypeBindCoreMap.get(r13).ordinal()];     // Catch: Throwable -> L26
        if (r15 != 1) goto L16;
        this.mThreadConfigCallback.bindBigCore(r14);     // Catch: Throwable -> L26
        goto L23
    L16:
        if (r15 != 2) goto L18;
        this.mThreadConfigCallback.bindLittleCore(r14);     // Catch: Throwable -> L26
        goto L23
    L18:
        if (r15 != 3) goto L23;
        this.mThreadConfigCallback.resetCoreBind(r14);     // Catch: Throwable -> L26
        goto L23
    L24:
        monitor-exit(r11);     // Catch: Throwable -> L26
    }

    @CalledByNative
    private void onThroughputObservation(final int r12, final long r13, final int r15) {
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        Iterator<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> r11 = this.mThroughputListenerList.iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L8;
        final VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper r14 = r11.next();     // Catch: Throwable -> L10
        Runnable r16 = new AnonymousClass4(this, r14, r12, r13, r15);     // Catch: Throwable -> L10
        postObservationTaskToExecutor(r14.getExecutor(), r16);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onUrlDispatchComplete(final URLDispatch r10, String r11, String r12, String r13, String r14) {
        r10.setResult(r11, r12, r13, r14);
        r10.resume(new AnonymousClass2(this, r10));
    }

    @CalledByNative
    private void onUserSpecifiedNetworkEnabled(boolean r10) {
        TTEventListener r11 = this.mEventListener;
        if (r11 == null) goto L6;
        r11.onUserSpecifiedNetworkEnabled(r10);
        return;
    }

    @CalledByNative
    private void onWiFiToCellStateChanged(int r10, int r11) {
        TTEventListener r12 = this.mEventListener;
        if (r12 == null) goto L6;
        r12.onMultiNetworkStateChanged(r10, r11);
        return;
    }

    private static void postObservationTaskToExecutor(Executor r10, Runnable r11) {
        r10.execute(r11);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(LOG_TAG, "Exception posting task to executor", new Object[]{e});
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addClientOpaqueData(String[] r14, byte[] r15, byte[] r16, long r17, long r19) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        CronetUrlRequestContextJni.get().addClientOpaqueData(this.mUrlRequestContextAdapter, this, r14, r15, r16, r17, r19);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRequestFinishedListener(RequestFinishedInfo.Listener r10) {
        Object r11 = this.mFinishedListenerLock;
        monitor-enter(r11);
        this.mFinishedListenerMap.put(r10, new VersionSafeCallbacks.RequestFinishedInfoListener(r10));     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRttListener(NetworkQualityRttListener r10) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L23;
        Object r11 = this.mNetworkQualityLock;
        monitor-enter(r11);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.mRttListenerList.isEmpty() == false) goto L16;
        Object r12 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r12);     // Catch: Throwable -> L19
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetUrlRequestContextJni.get().provideRTTObservations(this.mUrlRequestContextAdapter, this, true);     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L16:
        this.mRttListenerList.addObserver(new VersionSafeCallbacks.NetworkQualityRttListenerWrapper(r10));     // Catch: Throwable -> L19
        monitor-exit(r11);     // Catch: Throwable -> L19
        return;
    L23:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().addSamplingSetting(this.mUrlRequestContextAdapter, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addThroughputListener(NetworkQualityThroughputListener r10) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L23;
        Object r11 = this.mNetworkQualityLock;
        monitor-enter(r11);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.mThroughputListenerList.isEmpty() == false) goto L16;
        Object r12 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r12);     // Catch: Throwable -> L19
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetUrlRequestContextJni.get().provideThroughputObservations(this.mUrlRequestContextAdapter, this, true);     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L16:
        this.mThroughputListenerList.addObserver(new VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper(r10));     // Catch: Throwable -> L19
        monitor-exit(r11);     // Catch: Throwable -> L19
        return;
    L23:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindBigCore(int r10) {
        Object r11 = this.mThreadTypeIdLock;
        monitor-enter(r11);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadConfigCallback != null) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.ThreadType r12 = TTThreadConfigInfoProvider.ThreadType.values()[r10];     // Catch: Throwable -> L16
        if (this.mThreadTypeIdMap.containsKey(r12) == false) goto L13;
        this.mThreadConfigCallback.bindBigCore(this.mThreadTypeIdMap.get(r12).intValue());     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
        return;
    L13:
        this.mThreadTypeBindCoreMap.put(r12, TTThreadConfigInfoProvider.BindCore.BIG_CORE);     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindLittleCore(int r10) {
        Object r11 = this.mThreadTypeIdLock;
        monitor-enter(r11);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadConfigCallback != null) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.ThreadType r12 = TTThreadConfigInfoProvider.ThreadType.values()[r10];     // Catch: Throwable -> L16
        if (this.mThreadTypeIdMap.containsKey(r12) == false) goto L13;
        this.mThreadConfigCallback.bindLittleCore(this.mThreadTypeIdMap.get(r12).intValue());     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
        return;
    L13:
        this.mThreadTypeBindCoreMap.put(r12, TTThreadConfigInfoProvider.BindCore.LITTLE_CORE);     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindToNetwork(long r10) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        this.mNetworkHandle = r10;
        return;
    L7:
        throw new UnsupportedOperationException("The multi-network API is available starting from Android Marshmallow");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void clearClientOpaqueData() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        CronetUrlRequestContextJni.get().clearClientOpaqueData(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    @VisibleForTesting
    public void configureNetworkQualityEstimatorForTesting(boolean r10, boolean r11, boolean r12) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L13;
        Object r13 = this.mLock;
        monitor-enter(r13);
        checkHaveAdapter();     // Catch: Throwable -> L9
        CronetUrlRequestContextJni.get().configureNetworkQualityEstimatorForTesting(this.mUrlRequestContextAdapter, this, r10, r11, r12);     // Catch: Throwable -> L9
        monitor-exit(r13);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    protected ExperimentalBidirectionalStream createBidirectionalStream(String r20, BidirectionalStream.Callback r21, Executor r22, String r23, List<Map.Entry<String, String>> r24, int r25, boolean r26, Collection<Object> r27, boolean r28, int r29, boolean r30, int r31, long r32) {
        if (r32 != (-1)) goto L5;
        long r15 = this.mNetworkHandle;
    L6:
        Object r14 = this.mLock;
        monitor-enter(r14);
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetBidirectionalStream r17 = new CronetBidirectionalStream(this, r20, r25, r21, r22, r23, r24, r26, r27, r28, r29, r30, r31, r15);     // Catch: Throwable -> L17
        monitor-exit(r14);     // Catch: Throwable -> L17
        return r17;
    L13:
        th = th;
    L15:
        monitor-exit(r14);     // Catch: Throwable -> L17
        throw th;
    L17:
        th = th;
        goto L15
    L5:
        r15 = r32;
        goto L6
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    protected TTNetDiagnosisRequest createNetDiagnosisRequest(TTNetDiagnosisRequest.Callback r11, Executor r12, int r13, List<String> r14, int r15, int r16, int r17) {
        return new TTCronetNetExpRequest(this, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String r22, UrlRequest.Callback r23, Executor r24, int r25, Collection<Object> r26, boolean r27, boolean r28, boolean r29, boolean r30, int r31, boolean r32, int r33, RequestFinishedInfo.Listener r34, int r35, long r36) {
        if (r36 != (-1)) goto L5;
        long r17 = this.mNetworkHandle;
    L6:
        Object r15 = this.mLock;
        monitor-enter(r15);
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetUrlRequest r19 = new CronetUrlRequest(this, r22, r25, r23, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r17);     // Catch: Throwable -> L17
        monitor-exit(r15);     // Catch: Throwable -> L17
        return r19;
    L17:
        th = th;
    L15:
        monitor-exit(r15);     // Catch: Throwable -> L17
        throw th;
    L13:
        th = th;
        goto L15
    L5:
        r17 = r36;
        goto L6
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTMpaService createTTMpaService() {
        return new TTCronetMpaService(this);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLStreamHandlerFactory createURLStreamHandlerFactory() {
        return new CronetURLStreamHandlerFactory(this);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r20, Executor r21, List<String> r22, int r23, String r24, long r25, int r27, long r28, String r30, int r31, String r32, Map<String, String> r33, Map<String, String> r34, boolean r35) {
        return new CronetWebsocketConnection(this, r20, r21, r22, r23, r24, r25, r27, r28, r30, r31, r32, r33, r34, r35);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r10, Executor r11, List<String> r12, Map<String, String> r13, Map<String, String> r14, boolean r15) {
        return new CronetWebsocketConnection(this, r10, r11, r12, r13, r14, r15);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void enableTTBizHttpDns(boolean r13, String r14, String r15, String r16, boolean r17, String r18) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        CronetUrlRequestContextJni.get().enableTTBizHttpDns(this.mUrlRequestContextAdapter, this, r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    int getCronetEngineId() {
        return this.mCronetEngineId;
    }

    CronetLogger getCronetLogger() {
        return this.mLogger;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getDownstreamPacketLossRate(int r10) {
        handleProtocolException(r10);
        Object r11 = this.mNetworkQualityLock;
        monitor-enter(r11);
        double r12 = this.mUpstreamPacketLossRate[r10];     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getDownstreamPacketLossRateVariance(int r10) {
        handleProtocolException(r10);
        Object r11 = this.mNetworkQualityLock;
        monitor-enter(r11);
        double r12 = this.mDownstreamPacketLossRateVariance[r10];     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getDownstreamThroughputKbps() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        int r11 = this.mDownstreamThroughputKbps;     // Catch: Throwable -> L12
        if (r11 != (-1)) goto L10;
        r11 = -1;
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return r11;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveConnectionType() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L13;
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        int r11 = this.mEffectiveConnectionType;     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r11;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveHttpRtt() {
        Object r10 = this.mNetworkQualityLevelLock;
        monitor-enter(r10);
        int r11 = this.mEffectiveHrttMs;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveRxThroughput() {
        Object r10 = this.mNetworkQualityLevelLock;
        monitor-enter(r10);
        int r11 = this.mEffectiveRxThroughputKbps;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveTransportRtt() {
        Object r10 = this.mNetworkQualityLevelLock;
        monitor-enter(r10);
        int r11 = this.mEffectiveTrttMs;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public byte[] getGlobalMetricsDeltas() {
        return CronetUrlRequestContextJni.get().getHistogramDeltas();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public Map<String, int[]> getGroupRttEstimates() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L20;
        HashMap r10 = new HashMap();
        Object r11 = this.mNetworkQualityLock;
        monitor-enter(r11);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.mWatchingGroups != null) goto L10;
        monitor-exit(r11);     // Catch: Throwable -> L16
        return r10;
    L10:
        int r12 = 0;
    L11:
        String[] r13 = this.mWatchingGroups;     // Catch: Throwable -> L16
        if (r12 >= r13.length) goto L14;
        r10.put(r13[r12], new int[]{this.mGroupTransportRttMs[r12], this.mGroupHttpRttMs[r12]});     // Catch: Throwable -> L16
        r12 = r12 + 1;     // Catch: Throwable -> L16
        goto L11
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L16
        return r10;
    L20:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getHttpRttMs() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        int r11 = this.mHttpRttMs;     // Catch: Throwable -> L12
        if (r11 != (-1)) goto L10;
        r11 = -1;
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return r11;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getNetworkQualityLevel() {
        Object r10 = this.mNetworkQualityLevelLock;
        monitor-enter(r10);
        int r11 = this.mNql;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public List<Long> getOpaqueFuncAddress() {
        ArrayList r10 = new ArrayList();
        Object r11 = this.mLock;
        monitor-enter(r11);
        long[] r12 = CronetUrlRequestContextJni.get().getOpaqueFuncAddress();     // Catch: Throwable -> L9
        int r13 = r12.length;     // Catch: Throwable -> L9
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L7;
        r10.add(Long.valueOf(r12[r14]));     // Catch: Throwable -> L9
        r14 = r14 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return r10;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getTransportRttMs() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        int r11 = this.mTransportRttMs;     // Catch: Throwable -> L12
        if (r11 != (-1)) goto L10;
        r11 = -1;
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return r11;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getUpstreamPacketLossRate(int r10) {
        handleProtocolException(r10);
        Object r11 = this.mNetworkQualityLock;
        monitor-enter(r11);
        double r12 = this.mUpstreamPacketLossRate[r10];     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getUpstreamPacketLossRateVariance(int r10) {
        handleProtocolException(r10);
        Object r11 = this.mNetworkQualityLock;
        monitor-enter(r11);
        double r12 = this.mUpstreamPacketLossRateVariance[r10];     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public long getUrlRequestContextAdapter() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        checkHaveAdapter();     // Catch: Throwable -> L7
        long r11 = this.mUrlRequestContextAdapter;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public String getVersionString() {
        return "Cronet/" + ImplVersion.getCronetVersionWithLastChange();
    }

    boolean hasRequestFinishedListener() {
        Object r10 = this.mFinishedListenerLock;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mFinishedListenerMap.isEmpty() == true) goto L7;
        boolean r11 = true;
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L7:
        r11 = false;
        goto L8
    }

    public boolean isNetworkThread(Thread r10) {
        if (r10 != this.mNetworkThread) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String r10, BidirectionalStream.Callback r11, Executor r12) {
        return new BidirectionalStreamBuilderImpl(r10, r11, r12, this);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase, com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r10, UrlRequest.Callback r11, Executor r12) {
        return super.newUrlRequestBuilder(r10, r11, r12);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void notifySwitchToMultiNetwork(boolean r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        CronetUrlRequestContextJni.get().notifySwitchToMultiNetwork(this.mUrlRequestContextAdapter, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void notifyTNCConfigUpdated(String r13, String r14, String r15, String r16, String r17, String r18) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        CronetUrlRequestContextJni.get().parseTNCConfigFromSystemHTTPRequest(this.mUrlRequestContextAdapter, this, r13, r14, r15, r16, r17, r18);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    Map<String, String> onCallToAddSecurityFactor(String r10, Map<String, String> r11) {
        TTEventListener r12 = this.mEventListener;
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.onCallToAddSecurityFactor(r10, r11);
    }

    void onRequestDestroyed() {
        this.mActiveRequestCount.decrementAndGet();
    }

    @CalledByNative
    String onRequestInterceptorToStart(String r10, String[] r11, String[] r12) {
        if (this.mEventListener != null) goto L6;
        return null;
    L6:
        HashMap r13 = new HashMap();
        int r14 = 0;
        int r15 = 0;
    L8:
        if (r15 >= r11.length) goto L10;
        r13.put(r11[r15].toLowerCase(Locale.US), r11[r15 + 1]);
        r15 = r15 + 2;
        goto L8
    L10:
        ArrayList r16 = new ArrayList();
    L12:
        if (r14 >= r12.length) goto L15;
        r16.add(r12[r14]);
        r14 = r14 + 1;
        goto L12
    L15:
        return this.mEventListener.onRequestInterceptorToStart(r10, r13, r16);
    }

    void onRequestStarted() {
        this.mActiveRequestCount.incrementAndGet();
    }

    @CalledByNative
    String onResponseInterceptorToStart(String r10, String[] r11, int r12) {
        if (this.mEventListener != null) goto L6;
        return null;
    L6:
        ArrayList r13 = new ArrayList();
        int r14 = 0;
    L8:
        if (r14 >= r11.length) goto L10;
        r13.add(new AbstractMap.SimpleImmutableEntry(r11[r14].toLowerCase(Locale.US), r11[r14 + 1]));
        r14 = r14 + 2;
        goto L8
    L10:
        TreeMap r15 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator r16 = r13.iterator();
    L12:
        if (r16.hasNext() == false) goto L18;
        Map.Entry r17 = (Map.Entry) r16.next();
        ArrayList r18 = new ArrayList();
        if (r15.containsKey(r17.getKey()) == false) goto L16;
        r18.addAll((Collection) r15.get(r17.getKey()));
    L16:
        r18.add((String) r17.getValue());
        r15.put((String) r17.getKey(), Collections.unmodifiableList(r18));
        goto L12
    L18:
        return this.mEventListener.onResponseInterceptorToStart(r10, r15, r12);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL r10) {
        return openConnection(r10, Proxy.NO_PROXY);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public URLConnection openConnection(URL r10, Proxy r11) {
        return openConnection(r10, r11, false);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL r10, Proxy r11, boolean r12) {
        if (r11.type() != Proxy.Type.DIRECT) goto L14;
        String r13 = r10.getProtocol();
        if ("http".equals(r13) == true) goto L12;
        if ("https".equals(r13) == true) goto L12;
        throw new UnsupportedOperationException("Unexpected protocol:" + r13);
    L12:
        return new CronetHttpURLConnection(r10, this, r12);
    L14:
        throw new UnsupportedOperationException();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void preconnectUrl(String r10, int r11, Map<String, String> r12) {
        Object r13 = this.mLock;
        monitor-enter(r13);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().preconnectUrl(this.mUrlRequestContextAdapter, this, r10, r11, constructControlHeaders(r12));     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppInfoProvider(TTAppInfoProvider r10) {
        this.mAppInfoProvider = r10;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppMonitorProvider(TTMonitorProvider r10) {
        this.mAppMonitorProvider = r10;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerEventListener(TTEventListener r10) {
        this.mEventListener = r10;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeClientOpaqueData(String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        CronetUrlRequestContextJni.get().removeClientOpaqueData(this.mUrlRequestContextAdapter, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRequestFinishedListener(RequestFinishedInfo.Listener r10) {
        Object r11 = this.mFinishedListenerLock;
        monitor-enter(r11);
        this.mFinishedListenerMap.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRttListener(NetworkQualityRttListener r10) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L24;
        Object r11 = this.mNetworkQualityLock;
        monitor-enter(r11);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.mRttListenerList.removeObserver(new VersionSafeCallbacks.NetworkQualityRttListenerWrapper(r10)) == true) goto L9;
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L20
        return;
    L9:
        if (this.mRttListenerList.isEmpty() == false) goto L18;
        Object r12 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r12);     // Catch: Throwable -> L20
        checkHaveAdapter();     // Catch: Throwable -> L15
        CronetUrlRequestContextJni.get().provideRTTObservations(this.mUrlRequestContextAdapter, this, false);     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L24:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeThroughputListener(NetworkQualityThroughputListener r10) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L24;
        Object r11 = this.mNetworkQualityLock;
        monitor-enter(r11);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.mThroughputListenerList.removeObserver(new VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper(r10)) == true) goto L9;
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L20
        return;
    L9:
        if (this.mThroughputListenerList.isEmpty() == false) goto L18;
        Object r12 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r12);     // Catch: Throwable -> L20
        checkHaveAdapter();     // Catch: Throwable -> L15
        CronetUrlRequestContextJni.get().provideThroughputObservations(this.mUrlRequestContextAdapter, this, false);     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L24:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void reportNetDiagnosisUserLog(String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        CronetUrlRequestContextJni.get().reportNetDiagnosisUserLog(this.mUrlRequestContextAdapter, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void reportRequestFinished(final RequestFinishedInfo r10) {
        Object r11 = this.mFinishedListenerLock;
        monitor-enter(r11);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mFinishedListenerMap.isEmpty() == false) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L15
        return;
    L8:
        ArrayList r12 = new ArrayList(this.mFinishedListenerMap.values());     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        Iterator r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        final VersionSafeCallbacks.RequestFinishedInfoListener r14 = (VersionSafeCallbacks.RequestFinishedInfoListener) r13.next();
        Runnable r15 = new AnonymousClass5(this, r14, r10);
        postObservationTaskToExecutor(r14.getExecutor(), r15);
        goto L12
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void resetCoreBind(int r10) {
        Object r11 = this.mThreadTypeIdLock;
        monitor-enter(r11);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadConfigCallback != null) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.ThreadType r12 = TTThreadConfigInfoProvider.ThreadType.values()[r10];     // Catch: Throwable -> L16
        if (this.mThreadTypeIdMap.containsKey(r12) == false) goto L13;
        this.mThreadConfigCallback.resetCoreBind(this.mThreadTypeIdMap.get(r12).intValue());     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
        return;
    L13:
        this.mThreadTypeBindCoreMap.put(r12, TTThreadConfigInfoProvider.BindCore.CANCEL_BIND);     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void runInBackGround(boolean r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        CronetUrlRequestContextJni.get().runInBackGround(this.mUrlRequestContextAdapter, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setAlogFuncAddr(long r11) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        checkHaveAdapter();     // Catch: Throwable -> L7
        Log.e(LOG_TAG, "Set alog func addr: " + r11, new Object[0]);     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().setAlogFuncAddr(this.mUrlRequestContextAdapter, this, r11);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setAppStartUpState(int r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        CronetUrlRequestContextJni.get().setAppStartUpState(this.mUrlRequestContextAdapter, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setCookieInitCompleted() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        CronetUrlRequestContextJni.get().setCookieInitCompleted(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setHostResolverRules(String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().setHostResolverRules(this.mUrlRequestContextAdapter, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setHttpDnsForTesting(boolean r10, boolean r11, boolean r12) {
        Object r13 = this.mLock;
        monitor-enter(r13);
        CronetUrlRequestContextJni.get().controlHttpDNSConfig(this.mUrlRequestContextAdapter, this, r10, r11, r12);     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setProxy(String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        CronetUrlRequestContextJni.get().setProxy(this.mUrlRequestContextAdapter, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setRouteSelectionBestHost(String r10, String r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        CronetUrlRequestContextJni.get().setRouteSelectionBestHost(this.mUrlRequestContextAdapter, this, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setZstdFuncAddr(long r23, long r25, long r27, long r29, long r31, long r33, long r35, long r37) {
        Object r15 = this.mLock;
        monitor-enter(r15);
        checkHaveAdapter();     // Catch: Throwable -> L9
        CronetUrlRequestContextJni.get().setZstdFuncAddr(this.mUrlRequestContextAdapter, this, r23, r25, r27, r29, r31, r33, r35, r37);     // Catch: Throwable -> L13
        monitor-exit(r15);     // Catch: Throwable -> L13
        return;
    L9:
        th = th;
    L11:
        monitor-exit(r15);     // Catch: Throwable -> L13
        throw th;
    L13:
        th = th;
        goto L11
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void shutdown() {
        if (this.mInUseStoragePath == null) goto L12;
        HashSet<String> r10 = sInUseStoragePaths;
        monitor-enter(r10);
        r10.remove(this.mInUseStoragePath);     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        Object r11 = this.mLock;
        monitor-enter(r11);
        checkHaveAdapter();     // Catch: Throwable -> L35
        if (this.mActiveRequestCount.get() != 0) goto L34;
        if (Thread.currentThread() == this.mNetworkThread) goto L32;
        monitor-exit(r11);     // Catch: Throwable -> L35
        this.mInitCompleted.block();
        stopNetLog();
        Object r12 = this.mLock;
        monitor-enter(r12);
    L28:
        th = move-exception;
        throw th;
    L22:
        if (haveRequestContextAdapter() == true) goto L25;
        monitor-exit(r12);     // Catch: Throwable -> L28
        return;
    L25:
        CronetUrlRequestContextJni.get().destroy(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L28
        this.mUrlRequestContextAdapter = 0;     // Catch: Throwable -> L28
        monitor-exit(r12);     // Catch: Throwable -> L28
        return;
    L32:
        throw new IllegalThreadStateException("Cannot shutdown from network thread.");     // Catch: Throwable -> L35
    L34:
        throw new IllegalStateException("Cannot shutdown with active requests.");     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void startNetLogToDisk(String r10, boolean r11, int r12) {
        Object r13 = this.mLock;
        monitor-enter(r13);
        checkHaveAdapter();     // Catch: Throwable -> L11
        if (this.mIsLogging == false) goto L8;
        monitor-exit(r13);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestContextJni.get().startNetLogToDisk(this.mUrlRequestContextAdapter, this, r10, r11, r12);     // Catch: Throwable -> L11
        this.mIsLogging = true;     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void startNetLogToFile(String r10, boolean r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        checkHaveAdapter();     // Catch: Throwable -> L15
        if (this.mIsLogging == false) goto L9;
        monitor-exit(r12);     // Catch: Throwable -> L15
        return;
    L9:
        if (CronetUrlRequestContextJni.get().startNetLogToFile(this.mUrlRequestContextAdapter, this, r10, r11) == false) goto L14;
        this.mIsLogging = true;     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
        return;
    L14:
        throw new RuntimeException("Unable to start NetLog");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void startThrottle(String[] r10, int r11, long r12) {
        Object r13 = this.mLock;
        monitor-enter(r13);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().startThrottle(this.mUrlRequestContextAdapter, this, r10, r11, r12);     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void stopNetLog() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        checkHaveAdapter();     // Catch: Throwable -> L22
        if (this.mIsLogging == true) goto L7;
    L20:
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L7:
        if (this.mIsStoppingNetLog == true) goto L20;
        CronetUrlRequestContextJni.get().stopNetLog(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L22
        this.mIsStoppingNetLog = true;     // Catch: Throwable -> L22
        monitor-exit(r10);     // Catch: Throwable -> L22
        this.mStopNetLogCompleted.block();
        this.mStopNetLogCompleted.close();
        Object r11 = this.mLock;
        monitor-enter(r11);
        this.mIsStoppingNetLog = false;     // Catch: Throwable -> L17
        this.mIsLogging = false;     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    public void stopNetLogCompleted() {
        this.mStopNetLogCompleted.open();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void stopThrottle(String[] r10, int r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().stopThrottle(this.mUrlRequestContextAdapter, this, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void triggerGetDomain(boolean r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        CronetUrlRequestContextJni.get().triggerTNCRequestByUser(this.mUrlRequestContextAdapter, this, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void triggerWiFiToCellularByThirdParty() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        CronetUrlRequestContextJni.get().triggerWiFiToCellularByThirdParty(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void tryStartNetDetect(String[] r10, int r11, int r12) {
        Object r13 = this.mLock;
        monitor-enter(r13);
        CronetUrlRequestContextJni.get().tryStartNetDetect(this.mUrlRequestContextAdapter, this, r10, r11, r12);     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void ttDnsResolve(String r10, int r11, String r12, Map<String, String> r13) {
        Object r14 = this.mLock;
        monitor-enter(r14);
        CronetUrlRequestContextJni.get().ttDnsResolve(this.mUrlRequestContextAdapter, this, r10, r11, r12, constructControlHeaders(r13));     // Catch: Throwable -> L7
        monitor-exit(r14);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public Map<String, String> ttUrlDispatch(String r10, int r11, boolean r12) {
        URLDispatch r13 = new URLDispatch(r10);
        Object r14 = this.mLock;
        monitor-enter(r14);
        checkHaveAdapter();     // Catch: Throwable -> L8
        CronetUrlRequestContextJni.get().ttUrlDispatch(this.mUrlRequestContextAdapter, this, r13, r10, r12);     // Catch: Throwable -> L8
        monitor-exit(r14);     // Catch: Throwable -> L8
        r13.waitResult(r11);
        HashMap r15 = new HashMap();
        r15.put(URLDispatch.KEY_FINAL_URL, r13.getFinalUrl());
        r15.put(URLDispatch.KEY_EPOCH, r13.getEpoch());
        r15.put(URLDispatch.KEY_ETAG, r13.getEtag());
        r15.put(URLDispatch.KEY_TTNET_ORIGIN_HOST, r13.getTTNetOriginHost());
        return r15;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void updateStoreRegionFromServer(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28) {
        Object r15 = this.mLock;
        monitor-enter(r15);
        CronetUrlRequestContextJni.get().updateStoreRegionFromServer(this.mUrlRequestContextAdapter, this, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);     // Catch: Throwable -> L13
        monitor-exit(r15);     // Catch: Throwable -> L13
        return;
    L9:
        th = th;
    L11:
        monitor-exit(r15);     // Catch: Throwable -> L13
        throw th;
    L13:
        th = th;
        goto L11
    }
}
