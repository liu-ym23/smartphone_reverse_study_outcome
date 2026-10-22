package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Process;
import android.util.Pair;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.ObserverList;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("cronet")
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
            int[] r0 = new int[TTThreadConfigInfoProvider.BindCore.values().length];
            $SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore = r0;
            r0[TTThreadConfigInfoProvider.BindCore.BIG_CORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore[TTThreadConfigInfoProvider.BindCore.LITTLE_CORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore[TTThreadConfigInfoProvider.BindCore.CANCEL_BIND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    interface Natives {
        @NativeClassQualifiedName("CronetContextAdapter")
        void addClientOpaqueData(long r1, CronetUrlRequestContext r3, String[] r4, byte[] r5, byte[] r6, long r7, long r9);

        void addPkp(long r1, String r3, byte[][] r4, boolean r5, long r6);

        void addQuicHint(long r1, String r3, int r4, int r5);

        @NativeClassQualifiedName("CronetContextAdapter")
        void addSamplingSetting(long r1, CronetUrlRequestContext r3, TTSamplingSettingProvider.TTSlaSamplingSetting r4);

        @NativeClassQualifiedName("CronetContextAdapter")
        void clearClientOpaqueData(long r1, CronetUrlRequestContext r3);

        @NativeClassQualifiedName("CronetContextAdapter")
        void configureNetworkQualityEstimatorForTesting(long r1, CronetUrlRequestContext r3, boolean r4, boolean r5, boolean r6);

        @NativeClassQualifiedName("CronetContextAdapter")
        void controlHttpDNSConfig(long r1, CronetUrlRequestContext r3, boolean r4, boolean r5, boolean r6);

        long createRequestContextAdapter(long r1);

        long createRequestContextConfig(String r1, String r2, boolean r3, String r4, boolean r5, boolean r6, boolean r7, int r8, long r9, String r11, long r12, boolean r14, boolean r15, int r16);

        @NativeClassQualifiedName("CronetContextAdapter")
        void destroy(long r1, CronetUrlRequestContext r3);

        @NativeClassQualifiedName("CronetContextAdapter")
        void enableTTBizHttpDns(long r1, CronetUrlRequestContext r3, boolean r4, String r5, String r6, String r7, boolean r8, String r9);

        byte[] getHistogramDeltas();

        long[] getOpaqueFuncAddress();

        void initALogFuncAddr(long r1);

        @NativeClassQualifiedName("CronetContextAdapter")
        void initRequestContextOnInitThread(long r1, CronetUrlRequestContext r3);

        @NativeClassQualifiedName("CronetContextAdapter")
        void parseTNCConfigFromSystemHTTPRequest(long r1, CronetUrlRequestContext r3, String r4, String r5, String r6, String r7, String r8, String r9);

        @NativeClassQualifiedName("CronetContextAdapter")
        void preconnectUrl(long r1, CronetUrlRequestContext r3, String r4, int r5, String r6);

        @NativeClassQualifiedName("CronetContextAdapter")
        void provideRTTObservations(long r1, CronetUrlRequestContext r3, boolean r4);

        @NativeClassQualifiedName("CronetContextAdapter")
        void provideThroughputObservations(long r1, CronetUrlRequestContext r3, boolean r4);

        @NativeClassQualifiedName("CronetContextAdapter")
        void removeClientOpaqueData(long r1, CronetUrlRequestContext r3, String r4);

        @NativeClassQualifiedName("CronetContextAdapter")
        void reportNetDiagnosisUserLog(long r1, CronetUrlRequestContext r3, String r4);

        @NativeClassQualifiedName("CronetContextAdapter")
        void runInBackGround(long r1, CronetUrlRequestContext r3, boolean r4);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setAlogFuncAddr(long r1, CronetUrlRequestContext r3, long r4);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setAppStartUpState(long r1, CronetUrlRequestContext r3, int r4);

        void setClientOpaqueData(long r1, String[] r3, byte[] r4, byte[] r5);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setCookieInitCompleted(long r1, CronetUrlRequestContext r3);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setHostResolverRules(long r1, CronetUrlRequestContext r3, String r4);

        int setMinLogLevel(int r1);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setProxy(long r1, CronetUrlRequestContext r3, String r4);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setRouteSelectionBestHost(long r1, CronetUrlRequestContext r3, String r4, String r5);

        void setTTNetInitConfig(long r1, int r3, boolean r4, boolean r5, String r6, String r7, String r8, boolean r9, String r10, String r11, byte[][] r12, TTThreadConfigInfoProvider.ThreadConfigInfo[] r13, boolean r14, boolean r15, boolean r16, String r17, TTAppInfoProvider.AppInfo r18, long r19, boolean r21, boolean r22, boolean r23, TTSamplingSettingProvider.TTSlaSamplingSetting r24, boolean r25, String r26);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setZstdFuncAddr(long r1, CronetUrlRequestContext r3, long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18);

        @NativeClassQualifiedName("CronetContextAdapter")
        boolean skipLogging(long r1, CronetUrlRequestContext r3);

        @NativeClassQualifiedName("CronetContextAdapter")
        void startNetLogToDisk(long r1, CronetUrlRequestContext r3, String r4, boolean r5, int r6);

        @NativeClassQualifiedName("CronetContextAdapter")
        boolean startNetLogToFile(long r1, CronetUrlRequestContext r3, String r4, boolean r5);

        @NativeClassQualifiedName("CronetContextAdapter")
        void startThrottle(long r1, CronetUrlRequestContext r3, String[] r4, int r5, long r6);

        @NativeClassQualifiedName("CronetContextAdapter")
        void stopNetLog(long r1, CronetUrlRequestContext r3);

        @NativeClassQualifiedName("CronetContextAdapter")
        void stopThrottle(long r1, CronetUrlRequestContext r3, String[] r4, int r5);

        @NativeClassQualifiedName("CronetContextAdapter")
        void triggerTNCRequestByUser(long r1, CronetUrlRequestContext r3, boolean r4);

        @NativeClassQualifiedName("CronetContextAdapter")
        void tryStartNetDetect(long r1, CronetUrlRequestContext r3, String[] r4, int r5, int r6);

        @NativeClassQualifiedName("CronetContextAdapter")
        void ttDnsResolve(long r1, CronetUrlRequestContext r3, String r4, int r5, String r6, String r7);

        @NativeClassQualifiedName("CronetContextAdapter")
        void ttUrlDispatch(long r1, CronetUrlRequestContext r3, URLDispatch r4, String r5, boolean r6);

        @NativeClassQualifiedName("CronetContextAdapter")
        void updateStoreRegionFromServer(long r1, CronetUrlRequestContext r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14);
    }

    static {
        sInUseStoragePaths = new HashSet();
    }

    public CronetUrlRequestContext(CronetEngineBuilderImpl r10) {
        Object r0 = new Object();
        this.mLock = r0;
        this.mInitCompleted = new ConditionVariable(false);
        this.mActiveRequestCount = new AtomicInteger(0);
        this.mNetworkQualityLock = new Object();
        this.mFinishedListenerLock = new Object();
        this.mEffectiveConnectionType = 0;
        this.mHttpRttMs = -1;
        this.mTransportRttMs = -1;
        this.mDownstreamThroughputKbps = -1;
        ObserverList<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> r3 = new ObserverList();
        this.mRttListenerList = r3;
        ObserverList<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> r4 = new ObserverList();
        this.mThroughputListenerList = r4;
        this.mFinishedListenerMap = new HashMap();
        this.mNetworkQualityLevelLock = new Object();
        this.mEffectiveHrttMs = -1;
        this.mEffectiveTrttMs = -1;
        this.mEffectiveRxThroughputKbps = -1;
        this.mUpstreamPacketLossRate = new double[]{-1.0d, -1.0d};
        this.mUpstreamPacketLossRateVariance = new double[]{-1.0d, -1.0d};
        this.mDownstreamPacketLossRate = new double[]{-1.0d, -1.0d};
        this.mDownstreamPacketLossRateVariance = new double[]{-1.0d, -1.0d};
        Object r1 = new Object();
        this.mThreadTypeIdLock = r1;
        this.mThreadTypeIdMap = new HashMap();
        this.mThreadTypeBindCoreMap = new HashMap();
        this.mStopNetLogCompleted = new ConditionVariable();
        this.mNetworkHandle = -1;
        this.mCronetEngineId = hashCode();
        r3.disableThreadAsserts();
        r4.disableThreadAsserts();
        this.mNetworkQualityEstimatorEnabled = r10.networkQualityEstimatorEnabled();
        CronetLibraryLoader.ensureInitialized((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r10);
        CronetUrlRequestContextJni.get().setMinLogLevel(getLoggingLevel());
        if (r10.httpCacheMode() != 1) goto L16;
        String r5 = r10.storagePath();
        this.mInUseStoragePath = r5;
        HashSet<String> r6 = sInUseStoragePaths;
        monitor-enter(r6);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (r6.add(r5) == false) goto L11;
        monitor-exit(r6);     // Catch: Throwable -> L14
    L17:
        this.mAppInfoProvider = r10.getAppInfoProvider();
        this.mAppMonitorProvider = r10.getAppMonitorProvider();
        this.mEventListener = r10.getEventListener();
        this.mListenAppStateIndependently = r10.getListenAppStateIndependently();
        monitor-enter(r1);
        this.mThreadConfigCallback = r10.threadConfigCallbackImpl();     // Catch: Throwable -> L41
        monitor-exit(r1);     // Catch: Throwable -> L41
        monitor-enter(r0);
        long r7 = CronetUrlRequestContextJni.get().createRequestContextAdapter(createNativeUrlRequestContextConfig(r10));     // Catch: Throwable -> L38
        this.mUrlRequestContextAdapter = r7;     // Catch: Throwable -> L38
        if (r7 == 0) goto L37;
        boolean r2 = CronetUrlRequestContextJni.get().skipLogging(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L38
        this.mSkipLogging = r2;     // Catch: Throwable -> L38
        monitor-exit(r0);     // Catch: Throwable -> L38
        if (r2 == false) goto L28;
        CronetLogger r8 = CronetLoggerFactory.createNoOpLogger();
    L29:
        this.mLogger = r8;
        this.mLogger.logCronetEngineCreation(getCronetEngineId(), new CronetLogger.CronetEngineBuilderInfo(r10), buildCronetVersion(), getCronetSource());     // Catch: RuntimeException -> L32
    L34:
        CronetLibraryLoader.postToInitThread(new AnonymousClass1(this));
        return;
    L32:
        e = move-exception;
        Log.e(LOG_TAG, "Error while trying to log CronetEngine creation: ", new Object[]{e});
        goto L34
    L28:
        r8 = CronetLoggerFactory.createLogger((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), getCronetSource());
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

    static /* synthetic */ boolean access$000(CronetUrlRequestContext r0) {
        return r0.mListenAppStateIndependently;
    }

    static /* synthetic */ Object access$100(CronetUrlRequestContext r0) {
        return r0.mLock;
    }

    static /* synthetic */ long access$200(CronetUrlRequestContext r2) {
        return r2.mUrlRequestContextAdapter;
    }

    private String[] addSecurityFactor(String r6, String[] r7) {
        HashMap r0 = new HashMap();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L6;
        r0.put(r7[r2].toLowerCase(Locale.US), r7[r2 + 1]);
        r2 = r2 + 2;
        goto L4
    L6:
        Map<String, String> r5 = onCallToAddSecurityFactor(r6, r0);
        if (r5 != null) goto L10;
        return null;
    L10:
        String[] r8 = new String[r5.size() * 2];
        Iterator<Map.Entry<String, String>> r9 = r5.entrySet().iterator();
    L12:
        if (r9.hasNext() == false) goto L14;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r8[r1] = (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.memorydata.plugin");
        r8[r1 + 1] = (String) ZeusTransformUtils.preCheckCast(r10.getValue(), String.class, "com.obric.memorydata.plugin");
        r1 = r1 + 2;
        goto L12
    L14:
        return r8;
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

    private String constructControlHeaders(Map<String, String> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        String r6 = "";
        if (r4 == null) goto L12;
        Iterator r7 = r4.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin");
        if (r2.isEmpty() == true) goto L6;
        if (r3.isEmpty() == true) goto L6;
        r6 = r2 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r3 + "\r\n" + r6;
    L12:
        return r6;
    }

    private static int convertConnectionTypeToApiValue(int r3) {
        if (r3 == 0) goto L17;
        int r0 = 1;
        if (r3 == 1) goto L16;
        r0 = 2;
        if (r3 == 2) goto L16;
        r0 = 3;
        if (r3 == 3) goto L16;
        r0 = 4;
        if (r3 == 4) goto L16;
        if (r3 != 5) goto L15;
        return 5;
    L15:
        throw new RuntimeException("Internal Error: Illegal EffectiveConnectionType value " + r3);
    L16:
        return r0;
    L17:
        return 0;
    }

    public static long createNativeUrlRequestContextConfig(CronetEngineBuilderImpl r37) {
        String r2 = "";
        File r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r37.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir();     // Catch: Throwable -> L40
        if (r3 == null) goto L6;
        r2 = r3.getAbsolutePath();     // Catch: Throwable -> L40
    L6:
        String r9 = r2;
        long r35 = CronetUrlRequestContextJni.get().createRequestContextConfig(r37.getUserAgent(), r37.storagePath(), r37.quicEnabled(), r37.getDefaultQuicUserAgentId(), r37.http2Enabled(), r37.brotliEnabled(), r37.cacheDisabled(), r37.httpCacheMode(), r37.httpCacheMaxSize(), r37.experimentalOptions(), r37.mockCertVerifier(), r37.networkQualityEstimatorEnabled(), r37.publicKeyPinningBypassForLocalTrustAnchorsEnabled(), r37.threadPriority(0));
        if (r35 == 0) goto L39;
        Iterator<CronetEngineBuilderImpl.QuicHint> r4 = r37.quicHints().iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        CronetEngineBuilderImpl.QuicHint r5 = (CronetEngineBuilderImpl.QuicHint) ZeusTransformUtils.preCheckCast(r4.next(), CronetEngineBuilderImpl.QuicHint.class, "com.obric.memorydata.plugin");
        CronetUrlRequestContextJni.get().addQuicHint(r35, r5.mHost, r5.mPort, r5.mAlternatePort);
        goto L10
    L12:
        Iterator<CronetEngineBuilderImpl.Pkp> r6 = r37.publicKeyPins().iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        CronetEngineBuilderImpl.Pkp r7 = (CronetEngineBuilderImpl.Pkp) ZeusTransformUtils.preCheckCast(r6.next(), CronetEngineBuilderImpl.Pkp.class, "com.obric.memorydata.plugin");
        CronetUrlRequestContextJni.get().addPkp(r35, r7.mHost, r7.mHashes, r7.mIncludeSubdomains, r7.mExpirationDate.getTime());
        goto L14
    L16:
        ArrayList<byte[]> r8 = r37.getOpaqueData();
        if (r8 != null) goto L19;
    L21:
        byte[][] r15 = null;
    L22:
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r10 = r37.threadConfigInfoList();
        if (r10 != null) goto L25;
    L27:
        TTThreadConfigInfoProvider.ThreadConfigInfo[] r16 = null;
    L28:
        CronetUrlRequestContextJni.get().setTTNetInitConfig(r35, r37.getAppSecurityLevel(), r37.httpDnsEnabled(), r37.verboseLogEnabled(), r9, r37.getProxyConfig(), r37.getGetDomainDefaultJSON(), r37.boeProxyEnabled(), r37.getBypassBOEJSON(), r37.getStoreIdcRuleJSON(), r15, r16, r37.tncSecureModeEnabled(), r37.isMainProcess(), r37.lazyInitIPC(), r37.processName(), r37.TTAppInfoSubset(), r37.ttnetInitStart(), r37.optInit(), r37.optNqeDefault(), r37.optNqePersist(), r37.samplingSetting(), r37.optStack(), r37.threadStackInitReason());
        Map<String[], Pair<byte[], byte[]>> r11 = r37.getClientOpaqueData();
        if (r11 != null) goto L31;
    L36:
        CronetUrlRequestContextJni.get().initALogFuncAddr(r37.aLogFuncAddr());
        return r35;
    L31:
        if (r11.isEmpty() == true) goto L36;
        Iterator<Map.Entry<String[], Pair<byte[], byte[]>>> r12 = r11.entrySet().iterator();
    L34:
        if (r12.hasNext() == false) goto L36;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        CronetUrlRequestContextJni.get().setClientOpaqueData(r35, (String[]) ZeusTransformUtils.preCheckCast(r13.getKey(), String[].class, "com.obric.memorydata.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r13.getValue(), Pair.class, "com.obric.memorydata.plugin")).first, byte[].class, "com.obric.memorydata.plugin"), (byte[]) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r13.getValue(), Pair.class, "com.obric.memorydata.plugin")).second, byte[].class, "com.obric.memorydata.plugin"));
        goto L34
    L25:
        if (r10.isEmpty() == true) goto L27;
        r16 = (TTThreadConfigInfoProvider.ThreadConfigInfo[]) ZeusTransformUtils.preCheckCast(r10.toArray(new TTThreadConfigInfoProvider.ThreadConfigInfo[r10.size()]), TTThreadConfigInfoProvider.ThreadConfigInfo[].class, "com.obric.memorydata.plugin");
        goto L28
    L19:
        if (r8.isEmpty() == true) goto L21;
        r15 = (byte[][]) ZeusTransformUtils.preCheckCast(r8.toArray(new byte[r8.size()][]), byte[][].class, "com.obric.memorydata.plugin");
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
        String r2 = LOG_TAG;
        if (Log.isLoggable(r2, 2) == false) goto L6;
        return -2;
    L6:
        if (Log.isLoggable(r2, 3) == false) goto L10;
        return -1;
    L10:
        return 3;
    }

    private void handleApiResult(boolean r37, String r38, String r39, String r40, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, boolean r61, long r62, long r64, String r66, String r67, String r68, int r69, int r70, String r71) {
        TTMonitorProvider r0 = this.mAppMonitorProvider;
        if (r0 == null) goto L6;
        r0.handleApiResult(r37, r38, r39, r40, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r62, r64, r66, r67, r68, r69, r70, r71);
        return;
    }

    private boolean handleApiSample(String r1, String r2) {
        TTMonitorProvider r0 = this.mAppMonitorProvider;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.handleApiSample(r1, r2);
    }

    private void handleProtocolException(int r3) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L12;
        if (r3 != 0) goto L6;
        return;
    L6:
        if (r3 != 1) goto L9;
        return;
    L9:
        throw new IllegalStateException("Error protocol: " + r3);
    L12:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    private boolean haveRequestContextAdapter() {
        if (this.mUrlRequestContextAdapter == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void initNetworkThread() {
        this.mNetworkThread = Thread.currentThread();
        this.mInitCompleted.open();
        Thread.currentThread().setName("ChromiumNet" + Process.getThreadPriority(0));
        TTEventListener r3 = this.mEventListener;
        if (r3 == null) goto L6;
        r3.onCronetBootSucceed();
        return;
    }

    private void onClientIPChanged(String r1) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onClientIPChanged(r1);
        return;
    }

    private void onColdStartFinish() {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onColdStartFinish();
        return;
    }

    private void onContextInitCompleted(long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, String r68, String r69) {
        TTCronetInitTimingInfo.sNativeInitTimingJson = r68;
        TTCronetInitTimingInfo.sABTest = r69;
        this.mInitCompleted.open();
        TTEventListener r2 = this.mEventListener;
        if (r2 == null) goto L6;
        r2.onContextInitCompleted(r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66);
        return;
    }

    private void onDropReasonChanged(boolean r3, int[] r4) {
        if (this.mEventListener == null) goto L9;
        List<Integer> r0 = new ArrayList();
        if (r4 == null) goto L7;
        r0 = (List) ZeusTransformUtils.preCheckCast(Arrays.stream(r4).boxed().collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
    L7:
        this.mEventListener.onDropReasonChanged(r3, r0);
        return;
    }

    private void onEffectiveConnectionTypeChanged(int r2) {
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        this.mEffectiveConnectionType = r2;     // Catch: Throwable -> L9
        TTEventListener r1 = this.mEventListener;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onEffectiveConnectionTypeChanged(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private TTAppInfoProvider.AppInfo onGetAppInfo() {
        TTAppInfoProvider r0 = this.mAppInfoProvider;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAppInfo();
    }

    private void onGroupRTTOrThroughputEstimatesComputed(String[] r2, int[] r3, int[] r4) {
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        this.mWatchingGroups = r2;     // Catch: Throwable -> L7
        this.mGroupTransportRttMs = r3;     // Catch: Throwable -> L7
        this.mGroupHttpRttMs = r4;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onMultiNetworkStateChanged(int r1, int r2) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onMultiNetworkStateChanged(r1, r2);
        return;
    }

    private void onNQLChanged(int r2) {
        Object r0 = this.mNetworkQualityLevelLock;
        monitor-enter(r0);
        this.mNql = r2;     // Catch: Throwable -> L9
        TTEventListener r1 = this.mEventListener;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onNetworkQualityLevelChanged(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onNetworkQualityRttAndThroughputNotified(int r2, int r3, int r4) {
        Object r0 = this.mNetworkQualityLevelLock;
        monitor-enter(r0);
        this.mEffectiveHrttMs = r2;     // Catch: Throwable -> L9
        this.mEffectiveTrttMs = r3;     // Catch: Throwable -> L9
        this.mEffectiveRxThroughputKbps = r4;     // Catch: Throwable -> L9
        TTEventListener r1 = this.mEventListener;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onNetworkQualityRttAndThroughputNotified(r2, r3, r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onNetworkQualityTypeChangedV3(int r1) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onNetworkQualityTypeChangedV3(r1);
        return;
    }

    private void onPacketLossComputed(int r12, double r13, double r15, double r17, double r19) {
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        if (r12 != 0) goto L6;
    L10:
        this.mUpstreamPacketLossRate[r12] = r13;     // Catch: Throwable -> L15
        this.mUpstreamPacketLossRateVariance[r12] = r15;     // Catch: Throwable -> L15
        this.mDownstreamPacketLossRate[r12] = r17;     // Catch: Throwable -> L15
        this.mDownstreamPacketLossRateVariance[r12] = r19;     // Catch: Throwable -> L15
        TTEventListener r0 = this.mEventListener;     // Catch: Throwable -> L15
        if (r0 == null) goto L13;
        r0.onPacketLossComputed(r12, r13, r15, r17, r19);     // Catch: Throwable -> L15
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

    private void onPublicIPsChanged(String[] r4, String[] r5) {
        if (this.mEventListener == null) goto L6;
        ArrayList r0 = new ArrayList(r4.length);
        ArrayList r1 = new ArrayList(r5.length);
        Collections.addAll(r0, r4);
        Collections.addAll(r1, r5);
        this.mEventListener.onPublicIPsChanged(r0, r1);
        return;
    }

    private void onRTTOrThroughputEstimatesComputed(int r2, int r3, int r4) {
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        this.mHttpRttMs = r2;     // Catch: Throwable -> L9
        this.mTransportRttMs = r3;     // Catch: Throwable -> L9
        this.mDownstreamThroughputKbps = r4;     // Catch: Throwable -> L9
        TTEventListener r1 = this.mEventListener;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onRTTOrThroughputEstimatesComputed(r2, r3, r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onRttObservation(final int r12, final long r13, final int r15) {
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        Iterator<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> r1 = this.mRttListenerList.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        final VersionSafeCallbacks.NetworkQualityRttListenerWrapper r2 = (VersionSafeCallbacks.NetworkQualityRttListenerWrapper) ZeusTransformUtils.preCheckCast(r1.next(), VersionSafeCallbacks.NetworkQualityRttListenerWrapper.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Runnable r10 = new AnonymousClass3(this, r2, r12, r13, r15);     // Catch: Throwable -> L10
        postObservationTaskToExecutor(r2.getExecutor(), r10);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void onSendAppMonitorEvent(String r1, String r2) {
        TTMonitorProvider r0 = this.mAppMonitorProvider;
        if (r0 == null) goto L6;
        r0.sendAppMonitorEvent(r1, r2);
        return;
    }

    private void onStoreIdcChanged(String r8, String r9, String r10, String r11, String r12, String r13) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onStoreIdcChanged(r8, r9, r10, r11, r12, r13);
        return;
    }

    private void onTLBDecompressFail() {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onTLBDecompressFail();
        return;
    }

    private void onTNCConfigChanged(String r1, String r2, String r3) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onServerConfigUpdated(r1, r2, r3);
        return;
    }

    private void onTNCRequestSucceeded(boolean r1, boolean r2, int r3) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onTncRequestSucceeded(r1, r2, r3);
        return;
    }

    private void onTNCUpdateFailed(String[] r1, String r2) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onTNCUpdateFailed(r1, r2);
        return;
    }

    private void onTTDnsResolveResult(String r12, String r13, int r14, int r15, int r16, String[] r17, String r18) {
        Log.d(LOG_TAG, " onTTDnsResolveResult, uuid: " + r12 + " host: " + r13 + " ret: " + r14 + " ips: " + r17.length, new Object[0]);
        ArrayList r9 = new ArrayList(r17.length);
        Collections.addAll(r9, r17);
        TTEventListener r3 = this.mEventListener;
        if (r3 == null) goto L6;
        r3.onTTDnsResolveResult(r12, r13, r14, r15, r16, r9, r18);
        return;
    }

    private void onTTNetDetectInfoChanged(String r1) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onTTNetDetectInfoChanged(r1);
        return;
    }

    private void onThreadIdChanged(int[] r9) {
        Object r0 = this.mThreadTypeIdLock;
        monitor-enter(r0);
        int r1 = 0;
    L29:
    L26:
        th = move-exception;
        throw th;
    L6:
        if (r1 >= (r9.length - 1)) goto L24;
        TTThreadConfigInfoProvider.ThreadType r2 = TTThreadConfigInfoProvider.ThreadType.values()[r9[r1]];     // Catch: Throwable -> L26
        int r4 = r9[r1 + 1];     // Catch: Throwable -> L26
        this.mThreadTypeIdMap.put(r2, Integer.valueOf(r4));     // Catch: Throwable -> L26
        if (this.mThreadTypeBindCoreMap.containsKey(r2) == true) goto L11;
    L23:
        r1 = r1 + 2;     // Catch: Throwable -> L26
        goto L29
    L11:
        if (this.mThreadConfigCallback == null) goto L23;
        int r3 = AnonymousClass6.$SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore[((TTThreadConfigInfoProvider.BindCore) ZeusTransformUtils.preCheckCast(this.mThreadTypeBindCoreMap.get(r2), TTThreadConfigInfoProvider.BindCore.class, "com.obric.memorydata.plugin")).ordinal()];     // Catch: Throwable -> L26
        if (r3 != 1) goto L16;
        this.mThreadConfigCallback.bindBigCore(r4);     // Catch: Throwable -> L26
        goto L23
    L16:
        if (r3 != 2) goto L18;
        this.mThreadConfigCallback.bindLittleCore(r4);     // Catch: Throwable -> L26
        goto L23
    L18:
        if (r3 != 3) goto L23;
        this.mThreadConfigCallback.resetCoreBind(r4);     // Catch: Throwable -> L26
        goto L23
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L26
    }

    private void onThroughputObservation(final int r12, final long r13, final int r15) {
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        Iterator<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> r1 = this.mThroughputListenerList.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        final VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper r2 = (VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper) ZeusTransformUtils.preCheckCast(r1.next(), VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Runnable r10 = new AnonymousClass4(this, r2, r12, r13, r15);     // Catch: Throwable -> L10
        postObservationTaskToExecutor(r2.getExecutor(), r10);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void onUrlDispatchComplete(final URLDispatch r1, String r2, String r3, String r4, String r5) {
        r1.setResult(r2, r3, r4, r5);
        r1.resume(new AnonymousClass2(this, r1));
    }

    private void onUserSpecifiedNetworkEnabled(boolean r1) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onUserSpecifiedNetworkEnabled(r1);
        return;
    }

    private void onWiFiToCellStateChanged(int r1, int r2) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onWiFiToCellStateChanged(r1, r2);
        return;
    }

    private static void postObservationTaskToExecutor(Executor r2, Runnable r3) {
        ((Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin")).execute((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
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
    public void addRequestFinishedListener(RequestFinishedInfo.Listener r3) {
        Object r0 = this.mFinishedListenerLock;
        monitor-enter(r0);
        this.mFinishedListenerMap.put(r3, new VersionSafeCallbacks.RequestFinishedInfoListener(r3));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRttListener(NetworkQualityRttListener r7) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L23;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.mRttListenerList.isEmpty() == false) goto L16;
        Object r1 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r1);     // Catch: Throwable -> L19
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetUrlRequestContextJni.get().provideRTTObservations(this.mUrlRequestContextAdapter, this, true);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L16:
        this.mRttListenerList.addObserver(new VersionSafeCallbacks.NetworkQualityRttListenerWrapper(r7));     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L23:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().addSamplingSetting(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addThroughputListener(NetworkQualityThroughputListener r7) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L23;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.mThroughputListenerList.isEmpty() == false) goto L16;
        Object r1 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r1);     // Catch: Throwable -> L19
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetUrlRequestContextJni.get().provideThroughputObservations(this.mUrlRequestContextAdapter, this, true);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L16:
        this.mThroughputListenerList.addObserver(new VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper(r7));     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L23:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindBigCore(int r4) {
        Object r0 = this.mThreadTypeIdLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadConfigCallback != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.ThreadType r5 = TTThreadConfigInfoProvider.ThreadType.values()[r4];     // Catch: Throwable -> L16
        if (this.mThreadTypeIdMap.containsKey(r5) == false) goto L13;
        this.mThreadConfigCallback.bindBigCore(((Integer) ZeusTransformUtils.preCheckCast(this.mThreadTypeIdMap.get(r5), Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L13:
        this.mThreadTypeBindCoreMap.put(r5, TTThreadConfigInfoProvider.BindCore.BIG_CORE);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindLittleCore(int r4) {
        Object r0 = this.mThreadTypeIdLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadConfigCallback != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.ThreadType r5 = TTThreadConfigInfoProvider.ThreadType.values()[r4];     // Catch: Throwable -> L16
        if (this.mThreadTypeIdMap.containsKey(r5) == false) goto L13;
        this.mThreadConfigCallback.bindLittleCore(((Integer) ZeusTransformUtils.preCheckCast(this.mThreadTypeIdMap.get(r5), Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L13:
        this.mThreadTypeBindCoreMap.put(r5, TTThreadConfigInfoProvider.BindCore.LITTLE_CORE);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindToNetwork(long r3) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        this.mNetworkHandle = r3;
        return;
    L7:
        throw new UnsupportedOperationException("The multi-network API is available starting from Android Marshmallow");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void clearClientOpaqueData() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().clearClientOpaqueData(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void configureNetworkQualityEstimatorForTesting(boolean r9, boolean r10, boolean r11) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L13;
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L9
        CronetUrlRequestContextJni.get().configureNetworkQualityEstimatorForTesting(this.mUrlRequestContextAdapter, this, r9, r10, r11);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public ExperimentalBidirectionalStream createBidirectionalStream(String r20, BidirectionalStream.Callback r21, Executor r22, String r23, List<Map.Entry<String, String>> r24, int r25, boolean r26, Collection<Object> r27, boolean r28, int r29, boolean r30, int r31, long r32) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r22, Executor.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.wrapperContextForParams(r27, Collection.class, "com.obric.memorydata.plugin");
        if (r32 != (-1)) goto L5;
        long r15 = this.mNetworkHandle;
    L6:
        Object r14 = this.mLock;
        monitor-enter(r14);
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetBidirectionalStream r17 = new CronetBidirectionalStream(this, r20, r25, r21, r6, r23, r8, r26, r10, r28, r29, r30, r31, r15);     // Catch: Throwable -> L17
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
    public TTNetDiagnosisRequest createNetDiagnosisRequest(TTNetDiagnosisRequest.Callback r12, Executor r13, int r14, List<String> r15, int r16, int r17, int r18) {
        return new TTCronetNetExpRequest(this, (TTNetDiagnosisRequest.Callback) ZeusTransformUtils.wrapperContextForParams(r12, TTNetDiagnosisRequest.Callback.class, "com.obric.memorydata.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r13, Executor.class, "com.obric.memorydata.plugin"), r14, (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin"), r16, r17, r18);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String r22, UrlRequest.Callback r23, Executor r24, int r25, Collection<Object> r26, boolean r27, boolean r28, boolean r29, boolean r30, int r31, boolean r32, int r33, RequestFinishedInfo.Listener r34, int r35, long r36) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r24, Executor.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r26, Collection.class, "com.obric.memorydata.plugin");
        if (r36 != (-1)) goto L5;
        long r17 = this.mNetworkHandle;
    L6:
        Object r15 = this.mLock;
        monitor-enter(r15);
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetUrlRequest r19 = new CronetUrlRequest(this, r22, r25, r23, r6, r7, r27, r28, r29, r30, r31, r32, r33, r34, r35, r17);     // Catch: Throwable -> L17
        monitor-exit(r15);     // Catch: Throwable -> L17
        return r19;
    L13:
        th = th;
    L15:
        monitor-exit(r15);     // Catch: Throwable -> L17
        throw th;
    L17:
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
        return new CronetWebsocketConnection(this, r20, (Executor) ZeusTransformUtils.wrapperContextForParams(r21, Executor.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin"), r23, r24, r25, r27, r28, r30, r31, r32, (Map) ZeusTransformUtils.wrapperContextForParams(r33, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r34, Map.class, "com.obric.memorydata.plugin"), r35);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r11, Executor r12, List<String> r13, Map<String, String> r14, Map<String, String> r15, boolean r16) {
        return new CronetWebsocketConnection(this, r11, (Executor) ZeusTransformUtils.wrapperContextForParams(r12, Executor.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin"), r16);
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
    public double getDownstreamPacketLossRate(int r2) {
        handleProtocolException(r2);
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        double r1 = this.mUpstreamPacketLossRate[r2];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getDownstreamPacketLossRateVariance(int r2) {
        handleProtocolException(r2);
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        double r1 = this.mDownstreamPacketLossRateVariance[r2];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getDownstreamThroughputKbps() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        int r2 = this.mDownstreamThroughputKbps;     // Catch: Throwable -> L12
        if (r2 != (-1)) goto L10;
        r2 = -1;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveConnectionType() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L13;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        int r1 = this.mEffectiveConnectionType;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveHttpRtt() {
        Object r0 = this.mNetworkQualityLevelLock;
        monitor-enter(r0);
        int r1 = this.mEffectiveHrttMs;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveRxThroughput() {
        Object r0 = this.mNetworkQualityLevelLock;
        monitor-enter(r0);
        int r1 = this.mEffectiveRxThroughputKbps;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveTransportRtt() {
        Object r0 = this.mNetworkQualityLevelLock;
        monitor-enter(r0);
        int r1 = this.mEffectiveTrttMs;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
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
        HashMap r0 = new HashMap();
        Object r1 = this.mNetworkQualityLock;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.mWatchingGroups != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r0;
    L10:
        int r3 = 0;
    L11:
        String[] r4 = this.mWatchingGroups;     // Catch: Throwable -> L16
        if (r3 >= r4.length) goto L14;
        r0.put(r4[r3], new int[]{this.mGroupTransportRttMs[r3], this.mGroupHttpRttMs[r3]});     // Catch: Throwable -> L16
        r3 = r3 + 1;     // Catch: Throwable -> L16
        goto L11
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r0;
    L20:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getHttpRttMs() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        int r2 = this.mHttpRttMs;     // Catch: Throwable -> L12
        if (r2 != (-1)) goto L10;
        r2 = -1;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getNetworkQualityLevel() {
        Object r0 = this.mNetworkQualityLevelLock;
        monitor-enter(r0);
        int r1 = this.mNql;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public List<Long> getOpaqueFuncAddress() {
        ArrayList r0 = new ArrayList();
        Object r6 = this.mLock;
        monitor-enter(r6);
        long[] r1 = CronetUrlRequestContextJni.get().getOpaqueFuncAddress();     // Catch: Throwable -> L9
        int r2 = r1.length;     // Catch: Throwable -> L9
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        r0.add(Long.valueOf(r1[r3]));     // Catch: Throwable -> L9
        r3 = r3 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r6);     // Catch: Throwable -> L9
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getTransportRttMs() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        int r2 = this.mTransportRttMs;     // Catch: Throwable -> L12
        if (r2 != (-1)) goto L10;
        r2 = -1;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getUpstreamPacketLossRate(int r2) {
        handleProtocolException(r2);
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        double r1 = this.mUpstreamPacketLossRate[r2];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getUpstreamPacketLossRateVariance(int r2) {
        handleProtocolException(r2);
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        double r1 = this.mUpstreamPacketLossRateVariance[r2];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public long getUrlRequestContextAdapter() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        long r1 = this.mUrlRequestContextAdapter;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public String getVersionString() {
        return "Cronet/" + ImplVersion.getCronetVersionWithLastChange();
    }

    boolean hasRequestFinishedListener() {
        Object r0 = this.mFinishedListenerLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mFinishedListenerMap.isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public boolean isNetworkThread(Thread r1) {
        if (r1 != this.mNetworkThread) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String r3, BidirectionalStream.Callback r4, Executor r5) {
        return new BidirectionalStreamBuilderImpl(r3, r4, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin"), this);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase, com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r3, UrlRequest.Callback r4, Executor r5) {
        return super.newUrlRequestBuilder(r3, r4, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin"));
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

    Map<String, String> onCallToAddSecurityFactor(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        TTEventListener r2 = this.mEventListener;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.onCallToAddSecurityFactor(r3, r5);
    }

    void onRequestDestroyed() {
        this.mActiveRequestCount.decrementAndGet();
    }

    String onRequestInterceptorJava(String r6, String[] r7) {
        if (this.mEventListener != null) goto L6;
        return null;
    L6:
        HashMap r0 = new HashMap();
        if (r7 == null) goto L13;
        int r1 = 0;
    L9:
        int r2 = r1 + 1;
        if (r2 >= r7.length) goto L13;
        r0.put(r7[r1].toLowerCase(Locale.US), r7[r2]);
        r1 = r1 + 2;
    L13:
        return this.mEventListener.onRequestInterceptorJava(r6, r0);
    }

    String onRequestInterceptorToStart(String r6, String[] r7, String[] r8) {
        if (this.mEventListener != null) goto L6;
        return null;
    L6:
        HashMap r0 = new HashMap();
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r2 >= r7.length) goto L10;
        r0.put(r7[r2].toLowerCase(Locale.US), r7[r2 + 1]);
        r2 = r2 + 2;
        goto L8
    L10:
        ArrayList r9 = new ArrayList();
    L12:
        if (r1 >= r8.length) goto L15;
        r9.add(r8[r1]);
        r1 = r1 + 1;
        goto L12
    L15:
        return this.mEventListener.onRequestInterceptorToStart(r6, r0, r9);
    }

    void onRequestStarted() {
        this.mActiveRequestCount.incrementAndGet();
    }

    String onResponseInterceptorToStart(String r7, String[] r8, int r9) {
        if (this.mEventListener != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L8:
        if (r1 >= r8.length) goto L10;
        r0.add(new AbstractMap.SimpleImmutableEntry(r8[r1].toLowerCase(Locale.US), r8[r1 + 1]));
        r1 = r1 + 2;
        goto L8
    L10:
        TreeMap r10 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator r2 = r0.iterator();
    L12:
        if (r2.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ArrayList r4 = new ArrayList();
        if (r10.containsKey(r3.getKey()) == false) goto L16;
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r10.get(r3.getKey()), Collection.class, "com.obric.memorydata.plugin"));
    L16:
        r4.add((String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.memorydata.plugin"));
        r10.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), Collections.unmodifiableList(r4));
        goto L12
    L18:
        return this.mEventListener.onResponseInterceptorToStart(r7, r10, r9);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL r2) {
        return openConnection(r2, Proxy.NO_PROXY);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public URLConnection openConnection(URL r2, Proxy r3) {
        return openConnection(r2, r3, false);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL r2, Proxy r3, boolean r4) {
        if (r3.type() != Proxy.Type.DIRECT) goto L14;
        String r5 = r2.getProtocol();
        if ("http".equals(r5) == true) goto L12;
        if (LocationInfoConst.HTTPS.equals(r5) == true) goto L12;
        throw new UnsupportedOperationException("Unexpected protocol:" + r5);
    L12:
        return new CronetHttpURLConnection(r2, this, r4);
    L14:
        throw new UnsupportedOperationException();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void preconnectUrl(String r9, int r10, Map<String, String> r11) {
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().preconnectUrl(this.mUrlRequestContextAdapter, this, r9, r10, constructControlHeaders(r12));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppInfoProvider(TTAppInfoProvider r1) {
        this.mAppInfoProvider = r1;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppMonitorProvider(TTMonitorProvider r1) {
        this.mAppMonitorProvider = r1;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerEventListener(TTEventListener r1) {
        this.mEventListener = r1;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeClientOpaqueData(String r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().removeClientOpaqueData(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRequestFinishedListener(RequestFinishedInfo.Listener r2) {
        Object r0 = this.mFinishedListenerLock;
        monitor-enter(r0);
        this.mFinishedListenerMap.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRttListener(NetworkQualityRttListener r6) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L24;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.mRttListenerList.removeObserver(new VersionSafeCallbacks.NetworkQualityRttListenerWrapper(r6)) == true) goto L9;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L9:
        if (this.mRttListenerList.isEmpty() == false) goto L18;
        Object r7 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r7);     // Catch: Throwable -> L20
        checkHaveAdapter();     // Catch: Throwable -> L15
        CronetUrlRequestContextJni.get().provideRTTObservations(this.mUrlRequestContextAdapter, this, false);     // Catch: Throwable -> L15
        monitor-exit(r7);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L24:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeThroughputListener(NetworkQualityThroughputListener r6) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L24;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.mThroughputListenerList.removeObserver(new VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper(r6)) == true) goto L9;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L9:
        if (this.mThroughputListenerList.isEmpty() == false) goto L18;
        Object r7 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r7);     // Catch: Throwable -> L20
        checkHaveAdapter();     // Catch: Throwable -> L15
        CronetUrlRequestContextJni.get().provideThroughputObservations(this.mUrlRequestContextAdapter, this, false);     // Catch: Throwable -> L15
        monitor-exit(r7);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L24:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void reportNetDiagnosisUserLog(String r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().reportNetDiagnosisUserLog(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void reportRequestFinished(final RequestFinishedInfo r5) {
        Object r0 = this.mFinishedListenerLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mFinishedListenerMap.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        ArrayList r1 = new ArrayList(this.mFinishedListenerMap.values());     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        final VersionSafeCallbacks.RequestFinishedInfoListener r3 = (VersionSafeCallbacks.RequestFinishedInfoListener) ZeusTransformUtils.preCheckCast(r2.next(), VersionSafeCallbacks.RequestFinishedInfoListener.class, "com.obric.memorydata.plugin");
        Runnable r4 = new AnonymousClass5(this, r3, r5);
        postObservationTaskToExecutor(r3.getExecutor(), r4);
        goto L12
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void resetCoreBind(int r4) {
        Object r0 = this.mThreadTypeIdLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadConfigCallback != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.ThreadType r5 = TTThreadConfigInfoProvider.ThreadType.values()[r4];     // Catch: Throwable -> L16
        if (this.mThreadTypeIdMap.containsKey(r5) == false) goto L13;
        this.mThreadConfigCallback.resetCoreBind(((Integer) ZeusTransformUtils.preCheckCast(this.mThreadTypeIdMap.get(r5), Integer.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L13:
        this.mThreadTypeBindCoreMap.put(r5, TTThreadConfigInfoProvider.BindCore.CANCEL_BIND);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void runInBackGround(boolean r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().runInBackGround(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setAlogFuncAddr(long r11) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        Log.e(LOG_TAG, "Set alog func addr: " + r11, new Object[0]);     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().setAlogFuncAddr(this.mUrlRequestContextAdapter, this, r11);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setAppStartUpState(int r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().setAppStartUpState(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setCookieInitCompleted() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().setCookieInitCompleted(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setHostResolverRules(String r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().setHostResolverRules(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setHttpDnsForTesting(boolean r9, boolean r10, boolean r11) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().controlHttpDNSConfig(this.mUrlRequestContextAdapter, this, r9, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setProxy(String r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().setProxy(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setRouteSelectionBestHost(String r8, String r9) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().setRouteSelectionBestHost(this.mUrlRequestContextAdapter, this, r8, r9);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
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
        HashSet<String> r0 = sInUseStoragePaths;
        monitor-enter(r0);
        r0.remove(this.mInUseStoragePath);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        Object r1 = this.mLock;
        monitor-enter(r1);
        checkHaveAdapter();     // Catch: Throwable -> L35
        if (this.mActiveRequestCount.get() != 0) goto L34;
        if (Thread.currentThread() == this.mNetworkThread) goto L32;
        monitor-exit(r1);     // Catch: Throwable -> L35
        this.mInitCompleted.block();
        stopNetLog();
        Object r2 = this.mLock;
        monitor-enter(r2);
    L28:
        th = move-exception;
        throw th;
    L22:
        if (haveRequestContextAdapter() == true) goto L25;
        monitor-exit(r2);     // Catch: Throwable -> L28
        return;
    L25:
        CronetUrlRequestContextJni.get().destroy(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L28
        this.mUrlRequestContextAdapter = 0;     // Catch: Throwable -> L28
        monitor-exit(r2);     // Catch: Throwable -> L28
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
    public void startNetLogToDisk(String r9, boolean r10, int r11) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L11
        if (this.mIsLogging == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestContextJni.get().startNetLogToDisk(this.mUrlRequestContextAdapter, this, r9, r10, r11);     // Catch: Throwable -> L11
        this.mIsLogging = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void startNetLogToFile(String r8, boolean r9) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L15
        if (this.mIsLogging == false) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L9:
        if (CronetUrlRequestContextJni.get().startNetLogToFile(this.mUrlRequestContextAdapter, this, r8, r9) == false) goto L14;
        this.mIsLogging = true;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L14:
        throw new RuntimeException("Unable to start NetLog");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void startThrottle(String[] r10, int r11, long r12) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().startThrottle(this.mUrlRequestContextAdapter, this, r10, r11, r12);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void stopNetLog() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L22
        if (this.mIsLogging == true) goto L7;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L7:
        if (this.mIsStoppingNetLog == true) goto L20;
        CronetUrlRequestContextJni.get().stopNetLog(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L22
        this.mIsStoppingNetLog = true;     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        this.mStopNetLogCompleted.block();
        this.mStopNetLogCompleted.close();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mIsStoppingNetLog = false;     // Catch: Throwable -> L17
        this.mIsLogging = false;     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        throw th;
    }

    public void stopNetLogCompleted() {
        this.mStopNetLogCompleted.open();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void stopThrottle(String[] r8, int r9) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().stopThrottle(this.mUrlRequestContextAdapter, this, r8, r9);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void triggerGetDomain(boolean r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().triggerTNCRequestByUser(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void tryStartNetDetect(String[] r9, int r10, int r11) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().tryStartNetDetect(this.mUrlRequestContextAdapter, this, r9, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void ttDnsResolve(String r10, int r11, String r12, Map<String, String> r13) {
        Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().ttDnsResolve(this.mUrlRequestContextAdapter, this, r10, r11, r12, constructControlHeaders(r14));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public Map<String, String> ttUrlDispatch(String r10, int r11, boolean r12) {
        URLDispatch r7 = new URLDispatch(r10);
        Object r8 = this.mLock;
        monitor-enter(r8);
        checkHaveAdapter();     // Catch: Throwable -> L8
        CronetUrlRequestContextJni.get().ttUrlDispatch(this.mUrlRequestContextAdapter, this, r7, r10, r12);     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        r7.waitResult(r11);
        HashMap r9 = new HashMap();
        r9.put(URLDispatch.KEY_FINAL_URL, r7.getFinalUrl());
        r9.put(URLDispatch.KEY_EPOCH, r7.getEpoch());
        r9.put(URLDispatch.KEY_ETAG, r7.getEtag());
        r9.put(URLDispatch.KEY_TTNET_ORIGIN_HOST, r7.getTTNetOriginHost());
        return r9;
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
