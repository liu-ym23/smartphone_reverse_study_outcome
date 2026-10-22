package com.ttnet.org.chromium.net.impl;

import android.os.ConditionVariable;
import android.os.Process;
import android.util.Pair;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.ObserverList;
import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.base.annotations.UsedByReflection;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.NetworkQualityRttListener;
import com.ttnet.org.chromium.net.NetworkQualityThroughputListener;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.TTMpaService;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.ttnet.org.chromium.net.urlconnection.CronetURLStreamHandlerFactory;
import defpackage.a;
import defpackage.b;
import java.io.File;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@JNINamespace("cronet")
@UsedByReflection("CronetEngine.java")
public class CronetUrlRequestContext extends CronetEngineBase {
    private static final int LOG_DEBUG = -1;
    private static final int LOG_NONE = 3;
    static final String LOG_TAG = "CronetUrlRequestContext";
    private static final int LOG_VERBOSE = -2;

    @GuardedBy("sInUseStoragePaths")
    private static final HashSet<String> sInUseStoragePaths = null;
    private final AtomicInteger mActiveRequestCount;
    private TTAppInfoProvider mAppInfoProvider;
    private TTMonitorProvider mAppMonitorProvider;

    @GuardedBy("mNetworkQualityLock")
    private double[] mDownstreamPacketLossRate;

    @GuardedBy("mNetworkQualityLock")
    private double[] mDownstreamPacketLossRateVariance;

    @GuardedBy("mNetworkQualityLock")
    private int mDownstreamThroughputKbps;

    @GuardedBy("mNetworkQualityLock")
    private int mEffectiveConnectionType;
    private TTEventListener mEventListener;
    private final Object mFinishedListenerLock;

    @GuardedBy("mFinishedListenerLock")
    private final Map<RequestFinishedInfo.Listener, VersionSafeCallbacks.RequestFinishedInfoListener> mFinishedListenerMap;

    @GuardedBy("mNetworkQualityLock")
    private int[] mGroupHttpRttMs;

    @GuardedBy("mNetworkQualityLock")
    private int[] mGroupTransportRttMs;

    @GuardedBy("mNetworkQualityLock")
    private int mHttpRttMs;
    private final String mInUseStoragePath;
    private final ConditionVariable mInitCompleted;

    @GuardedBy("mLock")
    private boolean mIsLogging;
    private boolean mListenAppStateIndependently;
    private final Object mLock;
    private final boolean mNetworkQualityEstimatorEnabled;
    private final Object mNetworkQualityLock;
    private Thread mNetworkThread;

    @GuardedBy("mNetworkQualityLock")
    private final ObserverList<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> mRttListenerList;
    private volatile ConditionVariable mStopNetLogCompleted;

    @GuardedBy("mNetworkQualityLock")
    private final ObserverList<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> mThroughputListenerList;

    @GuardedBy("mNetworkQualityLock")
    private int mTransportRttMs;

    @GuardedBy("mNetworkQualityLock")
    private double[] mUpstreamPacketLossRate;

    @GuardedBy("mNetworkQualityLock")
    private double[] mUpstreamPacketLossRateVariance;

    @GuardedBy("mLock")
    private long mUrlRequestContextAdapter;

    @GuardedBy("mNetworkQualityLock")
    private String[] mWatchingGroups;

    static {
        sInUseStoragePaths = new HashSet();
    }

    @UsedByReflection("CronetEngine.java")
    public CronetUrlRequestContext(CronetEngineBuilderImpl r8) {
        Object r10 = new Object();
        this.mLock = r10;
        this.mInitCompleted = new ConditionVariable(false);
        this.mActiveRequestCount = new AtomicInteger(0);
        this.mNetworkQualityLock = new Object();
        this.mFinishedListenerLock = new Object();
        this.mEffectiveConnectionType = 0;
        this.mHttpRttMs = -1;
        this.mTransportRttMs = -1;
        this.mDownstreamThroughputKbps = -1;
        this.mUpstreamPacketLossRate = new double[]{-1.0d, -1.0d};
        this.mUpstreamPacketLossRateVariance = new double[]{-1.0d, -1.0d};
        this.mDownstreamPacketLossRate = new double[]{-1.0d, -1.0d};
        this.mDownstreamPacketLossRateVariance = new double[]{-1.0d, -1.0d};
        this.mRttListenerList = new ObserverList();
        this.mThroughputListenerList = new ObserverList();
        this.mFinishedListenerMap = new HashMap();
        this.mNetworkQualityEstimatorEnabled = r8.networkQualityEstimatorEnabled();
        CronetLibraryLoader.ensureInitialized(r8.getContext(), r8);
        nativeSetMinLogLevel(getLoggingLevel());
        if (r8.httpCacheMode() != 1) goto L16;
        String r11 = r8.storagePath();
        this.mInUseStoragePath = r11;
        HashSet<String> r12 = sInUseStoragePaths;
        monitor-enter(r12);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (r12.add(r11) == false) goto L11;
        monitor-exit(r12);     // Catch: Throwable -> L14
    L17:
        this.mAppInfoProvider = r8.getAppInfoProvider();
        this.mAppMonitorProvider = r8.getAppMonitorProvider();
        this.mEventListener = r8.getEventListener();
        this.mListenAppStateIndependently = r8.getListenAppStateIndependently();
        monitor-enter(r10);
        long r13 = nativeCreateRequestContextAdapter(createNativeUrlRequestContextConfig(r8));     // Catch: Throwable -> L26
        this.mUrlRequestContextAdapter = r13;     // Catch: Throwable -> L26
        if (r13 == 0) goto L25;
        monitor-exit(r10);     // Catch: Throwable -> L26
        CronetLibraryLoader.postToInitThread(new AnonymousClass1(this));
        return;
    L25:
        throw new NullPointerException("Context Adapter creation failed.");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L11:
        throw new IllegalStateException("Disk cache storage path already in use");     // Catch: Throwable -> L14
    L16:
        this.mInUseStoragePath = null;
        goto L17
    }

    public static /* synthetic */ boolean access$000(CronetUrlRequestContext r8) {
        return r8.mListenAppStateIndependently;
    }

    public static /* synthetic */ Object access$100(CronetUrlRequestContext r8) {
        return r8.mLock;
    }

    public static /* synthetic */ long access$200(CronetUrlRequestContext r8) {
        return r8.mUrlRequestContextAdapter;
    }

    public static /* synthetic */ void access$300(CronetUrlRequestContext r8, long r10) {
        r8.nativeInitRequestContextOnInitThread(r10);
    }

    @GuardedBy("mLock")
    private void checkHaveAdapter() {
        if (haveRequestContextAdapter() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Engine is shut down.");
    }

    private static int convertConnectionTypeToApiValue(int r8) {
        if (r8 == 0) goto L17;
        int r10 = 1;
        if (r8 == 1) goto L16;
        r10 = 2;
        if (r8 == 2) goto L16;
        r10 = 3;
        if (r8 == 3) goto L16;
        r10 = 4;
        if (r8 == 4) goto L16;
        if (r8 != 5) goto L15;
        return 5;
    L15:
        throw new RuntimeException(a.d("Internal Error: Illegal EffectiveConnectionType value ", r8));
    L16:
        return r10;
    L17:
        return 0;
    }

    @VisibleForTesting
    public static long createNativeUrlRequestContextConfig(CronetEngineBuilderImpl r27) {
        String r8 = "";
        File r10 = r27.getContext().getFilesDir();     // Catch: Throwable -> L41
        if (r10 == null) goto L6;
        r8 = r10.getAbsolutePath();     // Catch: Throwable -> L41
    L6:
        String r11 = r27.getUserAgent();
        String r12 = r27.storagePath();
        boolean r13 = r27.quicEnabled();
        String r14 = r27.getDefaultQuicUserAgentId();
        boolean r15 = r27.http2Enabled();
        boolean r16 = r27.brotliEnabled();
        boolean r17 = r27.cacheDisabled();
        int r18 = r27.httpCacheMode();
        long r19 = r27.httpCacheMaxSize();
        String r110 = r27.experimentalOptions();
        long r111 = r27.mockCertVerifier();
        boolean r112 = r27.networkQualityEstimatorEnabled();
        boolean r113 = r27.publicKeyPinningBypassForLocalTrustAnchorsEnabled();
        boolean r114 = r27.httpDnsEnabled();
        boolean r115 = r27.verboseLogEnabled();
        long r20 = nativeCreateRequestContextConfig(r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r8, r27.threadPriority(0));
        Iterator<CronetEngineBuilderImpl.QuicHint> r21 = r27.quicHints().iterator();
    L8:
        if (r21.hasNext() == false) goto L10;
        CronetEngineBuilderImpl.QuicHint r22 = r21.next();
        nativeAddQuicHint(r20, r22.mHost, r22.mPort, r22.mAlternatePort);
        goto L8
    L10:
        Iterator<CronetEngineBuilderImpl.Pkp> r23 = r27.publicKeyPins().iterator();
    L12:
        if (r23.hasNext() == false) goto L14;
        CronetEngineBuilderImpl.Pkp r24 = r23.next();
        nativeAddPkp(r20, r24.mHost, r24.mHashes, r24.mIncludeSubdomains, r24.mExpirationDate.getTime());
        goto L12
    L14:
        String r25 = r27.getGetDomainDefaultJSON();
        if (r25 == null) goto L17;
        nativeSetGetDomainDefaultJSON(r20, r25);
    L17:
        ArrayList<byte[]> r26 = r27.getOpaqueData();
        if (r26 != null) goto L20;
    L22:
        Map<String[], Pair<byte[], byte[]>> r28 = r27.getClientOpaqueData();
        if (r28 != null) goto L25;
    L30:
        String r29 = r27.getBypassBOEJSON();
        if (r29 == null) goto L33;
        nativeSetBypassBOEJSON(r20, r29);
    L33:
        String r30 = r27.getStoreIdcRuleJSON();
        if (r30 == null) goto L36;
        nativeSetStoreIdcRuleJSON(r20, r30);
    L36:
        String r31 = r27.getProxyConfig();
        if (r31 == null) goto L39;
        nativeSetProxyConfig(r20, r31);
    L39:
        nativeEnableBoeProxy(r20, r27.boeProxyEnabled());
        nativeInitALogFuncAddr(r27.aLogFuncAddr());
        return r20;
    L25:
        if (r28.isEmpty() == true) goto L30;
        Iterator<Map.Entry<String[], Pair<byte[], byte[]>>> r32 = r28.entrySet().iterator();
    L28:
        if (r32.hasNext() == false) goto L30;
        Map.Entry<String[], Pair<byte[], byte[]>> r33 = r32.next();
        nativeSetClientOpaqueData(r20, r33.getKey(), (byte[]) r33.getValue().first, (byte[]) r33.getValue().second);
        goto L28
    L20:
        if (r26.isEmpty() == true) goto L22;
        nativeSetOpaqueData(r20, (byte[][]) r26.toArray(new byte[r26.size()][]));
        goto L22
    }

    private int getLoggingLevel() {
        String r8 = LOG_TAG;
        if (Log.isLoggable(r8, 2) == false) goto L6;
        return -2;
    L6:
        if (Log.isLoggable(r8, 3) == false) goto L9;
        return -1;
    L9:
        return 3;
    }

    @CalledByNative
    private void handleApiResult(boolean r37, String r38, String r39, String r40, long r41, long r43, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, boolean r61, long r62, long r64, String r66, String r67, String r68, int r69, int r70, String r71) {
        TTMonitorProvider r8 = this.mAppMonitorProvider;
        if (r8 == null) goto L6;
        r8.handleApiResult(r37, r38, r39, r40, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r61, r62, r64, r66, r67, r68, r69, r70, r71);
        return;
    }

    private void handleProtocolException(int r8) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L12;
        if (r8 != 0) goto L6;
        return;
    L6:
        if (r8 != 1) goto L9;
        return;
    L9:
        throw new IllegalStateException(a.d("Error protocol: ", r8));
    L12:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @GuardedBy("mLock")
    private boolean haveRequestContextAdapter() {
        if (this.mUrlRequestContextAdapter == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @CalledByNative
    private void initNetworkThread() {
        this.mNetworkThread = Thread.currentThread();
        Thread.currentThread().setName("ChromiumNet" + Process.getThreadPriority(0));
        this.mEventListener.onCronetBootSucceed();
    }

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeAddClientOpaqueData(long r8, String[] r10, byte[] r11, byte[] r12);

    private static native void nativeAddPkp(long r8, String r10, byte[][] r11, boolean r12, long r13);

    private static native void nativeAddQuicHint(long r8, String r10, int r11, int r12);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeClearClientOpaqueData(long r8);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeConfigureNetworkQualityEstimatorForTesting(long r8, boolean r10, boolean r11, boolean r12);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeControlHttpDNSConfig(long r8, boolean r10, boolean r11, boolean r12);

    private static native long nativeCreateRequestContextAdapter(long r8);

    private static native long nativeCreateRequestContextConfig(String r8, String r10, boolean r11, String r12, boolean r13, boolean r14, boolean r15, int r16, long r17, String r18, long r19, boolean r110, boolean r111, boolean r112, boolean r113, String r114, int r115);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeDestroy(long r8);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeDnsLookup(long r8, DnsQuery r10);

    private static native void nativeEnableBoeProxy(long r8, boolean r10);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeEnableTTBizHttpDns(long r8, boolean r10, String r11, String r12, String r13, boolean r14, String r15);

    private static native byte[] nativeGetHistogramDeltas();

    private static native long[] nativeGetOpaqueFuncAddress();

    private static native void nativeInitALogFuncAddr(long r8);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeInitRequestContextOnInitThread(long r8);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeNotifySwitchToMultiNetwork(long r8, boolean r10);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeNotifyTNCConfigUpdated(long r8, String r10, String r11, String r12, String r13, String r14, String r15);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    public static native void nativePreconnectUrl(long r8, String r10, int r11);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeProvideRTTObservations(long r8, boolean r10);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeProvideThroughputObservations(long r8, boolean r10);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeRemoveClientOpaqueData(long r8, String r10);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeReportNetDiagnosisUserLog(long r8, String r10);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeSetAlogFuncAddr(long r8, long r10);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeSetAppStartUpState(long r8, int r10);

    private static native void nativeSetBypassBOEJSON(long r8, String r10);

    private static native void nativeSetClientOpaqueData(long r8, String[] r10, byte[] r11, byte[] r12);

    private static native void nativeSetGetDomainDefaultJSON(long r8, String r10);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeSetHostResolverRules(long r8, String r10);

    private static native int nativeSetMinLogLevel(int r8);

    private static native void nativeSetOpaqueData(long r8, byte[][] r10);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeSetProxy(long r8, String r10);

    private static native void nativeSetProxyConfig(long r8, String r10);

    private static native void nativeSetStoreIdcRuleJSON(long r8, String r10);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeStartNetLogToDisk(long r8, String r10, boolean r11, int r12);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native boolean nativeStartNetLogToFile(long r8, String r10, boolean r11);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeStopNetLog(long r8);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeTTDnsResolve(long r8, String r10, int r11, String r12);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    public static native void nativeTTUrlDispatch(long r8, URLDispatch r10, String r11);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeTiggerWiFiToCellularByThirdParty(long r8);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeTriggerGetDomain(long r8, boolean r10);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeTryStartNetDetect(long r8, String[] r10, int r11, int r12);

    @NativeClassQualifiedName("CronetURLRequestContextAdapter")
    private native void nativeUpdateStoreRegionFromServer(long r8, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17);

    @CalledByNative
    private void onClientIPChanged(String r8) {
        TTEventListener r10 = this.mEventListener;
        if (r10 == null) goto L6;
        r10.onClientIPChanged(r8);
        return;
    }

    @CalledByNative
    private void onColdStartFinish() {
        TTEventListener r8 = this.mEventListener;
        if (r8 == null) goto L6;
        r8.onColdStartFinish();
        return;
    }

    @CalledByNative
    private void onContextInitCompleted(long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74) {
        this.mInitCompleted.open();
        TTEventListener r8 = this.mEventListener;
        if (r8 == null) goto L6;
        r8.onContextInitCompleted(r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74);
        return;
    }

    @CalledByNative
    private void onDnsLookupComplete(final DnsQuery r8, int r10, String[] r11) {
        r8.setResult(r10, r11);
        r8.resume(new AnonymousClass2(this, r8));
    }

    @CalledByNative
    private void onEffectiveConnectionTypeChanged(int r8) {
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        this.mEffectiveConnectionType = r8;     // Catch: Throwable -> L9
        TTEventListener r11 = this.mEventListener;     // Catch: Throwable -> L9
        if (r11 == null) goto L7;
        r11.onEffectiveConnectionTypeChanged(r8);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private TTAppInfoProvider.AppInfo onGetAppInfo() {
        TTAppInfoProvider r8 = this.mAppInfoProvider;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getAppInfo();
    }

    @CalledByNative
    private void onMultiNetworkStateChanged(int r8, int r10) {
        TTEventListener r11 = this.mEventListener;
        if (r11 == null) goto L6;
        r11.onMultiNetworkStateChanged(r8, r10);
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
        TTEventListener r8 = this.mEventListener;     // Catch: Throwable -> L15
        if (r8 == null) goto L13;
        r8.onPacketLossComputed(r12, r13, r15, r17, r19);     // Catch: Throwable -> L15
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
    private void onRTTOrThroughputEstimatesComputed(int r8, int r10, int r11, String[] r12, int[] r13, int[] r14) {
        Object r15 = this.mNetworkQualityLock;
        monitor-enter(r15);
        this.mHttpRttMs = r8;     // Catch: Throwable -> L9
        this.mTransportRttMs = r10;     // Catch: Throwable -> L9
        this.mDownstreamThroughputKbps = r11;     // Catch: Throwable -> L9
        this.mWatchingGroups = r12;     // Catch: Throwable -> L9
        this.mGroupTransportRttMs = r13;     // Catch: Throwable -> L9
        this.mGroupHttpRttMs = r14;     // Catch: Throwable -> L9
        TTEventListener r16 = this.mEventListener;     // Catch: Throwable -> L9
        if (r16 == null) goto L7;
        r16.onRTTOrThroughputEstimatesComputed(r8, r10, r11);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r15);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onRttObservation(final int r12, final long r13, final int r15) {
        Object r8 = this.mNetworkQualityLock;
        monitor-enter(r8);
        Iterator<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> r10 = this.mRttListenerList.iterator();     // Catch: Throwable -> L10
    L6:
        if (r10.hasNext() == false) goto L8;
        final VersionSafeCallbacks.NetworkQualityRttListenerWrapper r11 = r10.next();     // Catch: Throwable -> L10
        Runnable r14 = new AnonymousClass4(this, r11, r12, r13, r15);     // Catch: Throwable -> L10
        postObservationTaskToExecutor(r11.getExecutor(), r14);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onSendAppMonitorEvent(String r8, String r10) {
        TTMonitorProvider r11 = this.mAppMonitorProvider;
        if (r11 == null) goto L6;
        r11.sendAppMonitorEvent(r8, r10);
        return;
    }

    @CalledByNative
    private void onServerConfigUpdated(String r8, String r10) {
        TTEventListener r11 = this.mEventListener;
        if (r11 == null) goto L6;
        r11.onServerConfigUpdated(r8, r10);
        return;
    }

    @CalledByNative
    private void onStoreIdcChanged(String r8, String r10, String r11) {
        TTEventListener r12 = this.mEventListener;
        if (r12 == null) goto L6;
        r12.onStoreIdcChanged(r8, r10, r11);
        return;
    }

    @CalledByNative
    private void onTNCUpdateFailed(String[] r8, String r10) {
        TTEventListener r11 = this.mEventListener;
        if (r11 == null) goto L6;
        r11.onTNCUpdateFailed(r8, r10);
        return;
    }

    @CalledByNative
    private void onTTDnsResolveResult(String r11, String r12, int r13, int r14, int r15, String[] r16, String r17) {
        int r8 = r16.length;
        ArrayList r10 = new ArrayList(r16.length);
        Collections.addAll(r10, r16);
        TTEventListener r18 = this.mEventListener;
        if (r18 == null) goto L6;
        r18.onTTDnsResolveResult(r11, r12, r13, r14, r15, r10, r17);
        return;
    }

    @CalledByNative
    private void onTTNetDetectInfoChanged(String r8) {
        TTEventListener r10 = this.mEventListener;
        if (r10 == null) goto L6;
        r10.onTTNetDetectInfoChanged(r8);
        return;
    }

    @CalledByNative
    private void onThroughputObservation(final int r12, final long r13, final int r15) {
        Object r8 = this.mNetworkQualityLock;
        monitor-enter(r8);
        Iterator<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> r10 = this.mThroughputListenerList.iterator();     // Catch: Throwable -> L10
    L6:
        if (r10.hasNext() == false) goto L8;
        final VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper r11 = r10.next();     // Catch: Throwable -> L10
        Runnable r14 = new AnonymousClass5(this, r11, r12, r13, r15);     // Catch: Throwable -> L10
        postObservationTaskToExecutor(r11.getExecutor(), r14);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onUrlDispatchComplete(final URLDispatch r8, String r10, String r11, String r12) {
        r8.setResult(r10, r11, r12);
        r8.resume(new AnonymousClass3(this, r8));
    }

    private static void postObservationTaskToExecutor(Executor r8, Runnable r10) {
        r8.execute(r10);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(LOG_TAG, "Exception posting task to executor", new Object[]{e});
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addClientOpaqueData(String[] r8, byte[] r10, byte[] r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        nativeAddClientOpaqueData(this.mUrlRequestContextAdapter, r8, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRequestFinishedListener(RequestFinishedInfo.Listener r8) {
        Object r10 = this.mFinishedListenerLock;
        monitor-enter(r10);
        this.mFinishedListenerMap.put(r8, new VersionSafeCallbacks.RequestFinishedInfoListener(r8));     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRttListener(NetworkQualityRttListener r8) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L23;
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.mRttListenerList.isEmpty() == false) goto L16;
        Object r11 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r11);     // Catch: Throwable -> L19
        checkHaveAdapter();     // Catch: Throwable -> L13
        nativeProvideRTTObservations(this.mUrlRequestContextAdapter, true);     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L16:
        this.mRttListenerList.addObserver(new VersionSafeCallbacks.NetworkQualityRttListenerWrapper(r8));     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L23:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addThroughputListener(NetworkQualityThroughputListener r8) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L23;
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.mThroughputListenerList.isEmpty() == false) goto L16;
        Object r11 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r11);     // Catch: Throwable -> L19
        checkHaveAdapter();     // Catch: Throwable -> L13
        nativeProvideThroughputObservations(this.mUrlRequestContextAdapter, true);     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L16:
        this.mThroughputListenerList.addObserver(new VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper(r8));     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L23:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void clearClientOpaqueData() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        nativeClearClientOpaqueData(this.mUrlRequestContextAdapter);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    @VisibleForTesting
    public void configureNetworkQualityEstimatorForTesting(boolean r8, boolean r10, boolean r11) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L13;
        Object r12 = this.mLock;
        monitor-enter(r12);
        checkHaveAdapter();     // Catch: Throwable -> L9
        nativeConfigureNetworkQualityEstimatorForTesting(this.mUrlRequestContextAdapter, r8, r10, r11);     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public ExperimentalBidirectionalStream createBidirectionalStream(String r18, BidirectionalStream.Callback r19, Executor r20, String r21, List<Map.Entry<String, String>> r22, int r23, boolean r24, Collection<Object> r25, boolean r26, int r27, boolean r28, int r29) {
        Object r15 = this.mLock;
        monitor-enter(r15);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetBidirectionalStream r16 = new CronetBidirectionalStream(this, r18, r23, r19, r20, r21, r22, r24, r25, r26, r27, r28, r29);     // Catch: Throwable -> L7
        monitor-exit(r15);     // Catch: Throwable -> L7
        return r16;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTNetDiagnosisRequest createNetDiagnosisRequest(TTNetDiagnosisRequest.Callback r10, Executor r11, int r12, List<String> r13, int r14, int r15) {
        return new TTCronetNetExpRequest(this, r10, r11, r12, r13, r14, r15);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String r19, UrlRequest.Callback r20, Executor r21, int r22, Collection<Object> r23, boolean r24, boolean r25, boolean r26, boolean r27, int r28, boolean r29, int r30, RequestFinishedInfo.Listener r31) {
        Object r15 = this.mLock;
        monitor-enter(r15);
        checkHaveAdapter();     // Catch: Throwable -> L9
        CronetUrlRequest r16 = new CronetUrlRequest(this, r19, r22, r20, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31);     // Catch: Throwable -> L13
        monitor-exit(r15);     // Catch: Throwable -> L13
        return r16;
    L13:
        th = th;
    L11:
        monitor-exit(r15);     // Catch: Throwable -> L13
        throw th;
    L9:
        th = th;
        goto L11
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

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public List<InetAddress> dnsLookup(String r8) {
        DnsQuery r10 = new DnsQuery(r8);
        Object r11 = this.mLock;
        monitor-enter(r11);
        checkHaveAdapter();     // Catch: Throwable -> L8
        nativeDnsLookup(this.mUrlRequestContextAdapter, r10);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        r10.waitResult();
        return r10.getResult();
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void enableTTBizHttpDns(boolean r12, String r13, String r14, String r15, boolean r16, String r17) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        nativeEnableTTBizHttpDns(this.mUrlRequestContextAdapter, r12, r13, r14, r15, r16, r17);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getDownstreamPacketLossRate(int r8) {
        handleProtocolException(r8);
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        double r11 = this.mUpstreamPacketLossRate[r8];     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getDownstreamPacketLossRateVariance(int r8) {
        handleProtocolException(r8);
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        double r11 = this.mDownstreamPacketLossRateVariance[r8];     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getDownstreamThroughputKbps() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r8 = this.mNetworkQualityLock;
        monitor-enter(r8);
        int r10 = this.mDownstreamThroughputKbps;     // Catch: Throwable -> L12
        if (r10 != (-1)) goto L10;
        r10 = -1;
    L10:
        monitor-exit(r8);     // Catch: Throwable -> L12
        return r10;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveConnectionType() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L13;
        Object r8 = this.mNetworkQualityLock;
        monitor-enter(r8);
        int r10 = this.mEffectiveConnectionType;     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
        return r10;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public byte[] getGlobalMetricsDeltas() {
        return nativeGetHistogramDeltas();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public Map<String, int[]> getGroupRttEstimates() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L20;
        HashMap r8 = new HashMap();
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.mWatchingGroups != null) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L16
        return r8;
    L10:
        int r11 = 0;
    L11:
        String[] r12 = this.mWatchingGroups;     // Catch: Throwable -> L16
        if (r11 >= r12.length) goto L14;
        r8.put(r12[r11], new int[]{this.mGroupTransportRttMs[r11], this.mGroupHttpRttMs[r11]});     // Catch: Throwable -> L16
        r11 = r11 + 1;     // Catch: Throwable -> L16
        goto L11
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L16
        return r8;
    L20:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getHttpRttMs() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r8 = this.mNetworkQualityLock;
        monitor-enter(r8);
        int r10 = this.mHttpRttMs;     // Catch: Throwable -> L12
        if (r10 != (-1)) goto L10;
        r10 = -1;
    L10:
        monitor-exit(r8);     // Catch: Throwable -> L12
        return r10;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public List<Long> getOpaqueFuncAddress() {
        ArrayList r8 = new ArrayList();
        Object r10 = this.mLock;
        monitor-enter(r10);
        long[] r11 = nativeGetOpaqueFuncAddress();     // Catch: Throwable -> L9
        int r12 = r11.length;     // Catch: Throwable -> L9
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        r8.add(Long.valueOf(r11[r13]));     // Catch: Throwable -> L9
        r13 = r13 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r8;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getTransportRttMs() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r8 = this.mNetworkQualityLock;
        monitor-enter(r8);
        int r10 = this.mTransportRttMs;     // Catch: Throwable -> L12
        if (r10 != (-1)) goto L10;
        r10 = -1;
    L10:
        monitor-exit(r8);     // Catch: Throwable -> L12
        return r10;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getUpstreamPacketLossRate(int r8) {
        handleProtocolException(r8);
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        double r11 = this.mUpstreamPacketLossRate[r8];     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getUpstreamPacketLossRateVariance(int r8) {
        handleProtocolException(r8);
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
        double r11 = this.mUpstreamPacketLossRateVariance[r8];     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public long getUrlRequestContextAdapter() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        checkHaveAdapter();     // Catch: Throwable -> L7
        long r10 = this.mUrlRequestContextAdapter;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public String getVersionString() {
        return "Cronet/" + ImplVersion.getCronetVersionWithLastChange();
    }

    public boolean hasRequestFinishedListener() {
        Object r8 = this.mFinishedListenerLock;
        monitor-enter(r8);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mFinishedListenerMap.isEmpty() == true) goto L7;
        boolean r10 = true;
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
        return r10;
    L7:
        r10 = false;
        goto L8
    }

    public boolean isNetworkThread(Thread r8) {
        if (r8 != this.mNetworkThread) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String r8, BidirectionalStream.Callback r10, Executor r11) {
        return new BidirectionalStreamBuilderImpl(r8, r10, r11, this);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void notifySwitchToMultiNetwork(boolean r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        nativeNotifySwitchToMultiNetwork(this.mUrlRequestContextAdapter, r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void notifyTNCConfigUpdated(String r12, String r13, String r14, String r15, String r16, String r17) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        nativeNotifyTNCConfigUpdated(this.mUrlRequestContextAdapter, r12, r13, r14, r15, r16, r17);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<String, String> onCallToAddSecurityFactor(String r8, Map<String, String> r10) {
        TTEventListener r11 = this.mEventListener;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.onCallToAddSecurityFactor(r8, r10);
    }

    public void onRequestDestroyed() {
        this.mActiveRequestCount.decrementAndGet();
    }

    public void onRequestStarted() {
        this.mActiveRequestCount.incrementAndGet();
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL r8) {
        return openConnection(r8, Proxy.NO_PROXY);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void preconnectUrl(String r8, int r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        checkHaveAdapter();     // Catch: Throwable -> L7
        nativePreconnectUrl(this.mUrlRequestContextAdapter, r8, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppInfoProvider(TTAppInfoProvider r8) {
        this.mAppInfoProvider = r8;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppMonitorProvider(TTMonitorProvider r8) {
        this.mAppMonitorProvider = r8;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerEventListener(TTEventListener r8) {
        this.mEventListener = r8;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeClientOpaqueData(String r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        nativeRemoveClientOpaqueData(this.mUrlRequestContextAdapter, r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRequestFinishedListener(RequestFinishedInfo.Listener r8) {
        Object r10 = this.mFinishedListenerLock;
        monitor-enter(r10);
        this.mFinishedListenerMap.remove(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRttListener(NetworkQualityRttListener r8) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L24;
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.mRttListenerList.removeObserver(new VersionSafeCallbacks.NetworkQualityRttListenerWrapper(r8)) == true) goto L9;
    L18:
        monitor-exit(r10);     // Catch: Throwable -> L20
        return;
    L9:
        if (this.mRttListenerList.isEmpty() == false) goto L18;
        Object r11 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r11);     // Catch: Throwable -> L20
        checkHaveAdapter();     // Catch: Throwable -> L15
        nativeProvideRTTObservations(this.mUrlRequestContextAdapter, false);     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L24:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeThroughputListener(NetworkQualityThroughputListener r8) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L24;
        Object r10 = this.mNetworkQualityLock;
        monitor-enter(r10);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.mThroughputListenerList.removeObserver(new VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper(r8)) == true) goto L9;
    L18:
        monitor-exit(r10);     // Catch: Throwable -> L20
        return;
    L9:
        if (this.mThroughputListenerList.isEmpty() == false) goto L18;
        Object r11 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r11);     // Catch: Throwable -> L20
        checkHaveAdapter();     // Catch: Throwable -> L15
        nativeProvideThroughputObservations(this.mUrlRequestContextAdapter, false);     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L24:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void reportNetDiagnosisUserLog(String r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        nativeReportNetDiagnosisUserLog(this.mUrlRequestContextAdapter, r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void reportRequestFinished(final RequestFinishedInfo r8) {
        Object r10 = this.mFinishedListenerLock;
        monitor-enter(r10);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mFinishedListenerMap.isEmpty() == false) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L8:
        ArrayList r11 = new ArrayList(this.mFinishedListenerMap.values());     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        Iterator r12 = r11.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        final VersionSafeCallbacks.RequestFinishedInfoListener r13 = (VersionSafeCallbacks.RequestFinishedInfoListener) r12.next();
        Runnable r14 = new AnonymousClass6(this, r13, r8);
        postObservationTaskToExecutor(r13.getExecutor(), r14);
        goto L12
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setAlogFuncAddr(long r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        checkHaveAdapter();     // Catch: Throwable -> L7
        Log.e(LOG_TAG, "Set alog func addr: " + r8, new Object[0]);     // Catch: Throwable -> L7
        nativeSetAlogFuncAddr(this.mUrlRequestContextAdapter, r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setAppStartUpState(int r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        nativeSetAppStartUpState(this.mUrlRequestContextAdapter, r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setHostResolverRules(String r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        checkHaveAdapter();     // Catch: Throwable -> L7
        nativeSetHostResolverRules(this.mUrlRequestContextAdapter, r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setHttpDnsForTesting(boolean r8, boolean r10, boolean r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        nativeControlHttpDNSConfig(this.mUrlRequestContextAdapter, r8, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setProxy(String r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        nativeSetProxy(this.mUrlRequestContextAdapter, r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void shutdown() {
        if (this.mInUseStoragePath == null) goto L12;
        HashSet<String> r8 = sInUseStoragePaths;
        monitor-enter(r8);
        r8.remove(this.mInUseStoragePath);     // Catch: Throwable -> L9
        monitor-exit(r8);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        Object r10 = this.mLock;
        monitor-enter(r10);
        checkHaveAdapter();     // Catch: Throwable -> L35
        if (this.mActiveRequestCount.get() != 0) goto L34;
        if (Thread.currentThread() == this.mNetworkThread) goto L32;
        monitor-exit(r10);     // Catch: Throwable -> L35
        this.mInitCompleted.block();
        stopNetLog();
        Object r11 = this.mLock;
        monitor-enter(r11);
    L28:
        th = move-exception;
        throw th;
    L22:
        if (haveRequestContextAdapter() == true) goto L25;
        monitor-exit(r11);     // Catch: Throwable -> L28
        return;
    L25:
        nativeDestroy(this.mUrlRequestContextAdapter);     // Catch: Throwable -> L28
        this.mUrlRequestContextAdapter = 0;     // Catch: Throwable -> L28
        monitor-exit(r11);     // Catch: Throwable -> L28
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
    public void startNetLogToDisk(String r8, boolean r10, int r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        checkHaveAdapter();     // Catch: Throwable -> L7
        nativeStartNetLogToDisk(this.mUrlRequestContextAdapter, r8, r10, r11);     // Catch: Throwable -> L7
        this.mIsLogging = true;     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void startNetLogToFile(String r8, boolean r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        checkHaveAdapter();     // Catch: Throwable -> L11
        if (nativeStartNetLogToFile(this.mUrlRequestContextAdapter, r8, r10) == false) goto L10;
        this.mIsLogging = true;     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L10:
        throw new RuntimeException("Unable to start NetLog");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void stopNetLog() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsLogging == true) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L12
        return;
    L8:
        checkHaveAdapter();     // Catch: Throwable -> L12
        this.mStopNetLogCompleted = new ConditionVariable();     // Catch: Throwable -> L12
        nativeStopNetLog(this.mUrlRequestContextAdapter);     // Catch: Throwable -> L12
        this.mIsLogging = false;     // Catch: Throwable -> L12
        monitor-exit(r8);     // Catch: Throwable -> L12
        this.mStopNetLogCompleted.block();
    }

    @CalledByNative
    public void stopNetLogCompleted() {
        this.mStopNetLogCompleted.open();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void tiggerWiFiToCellularByThirdParty() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        nativeTiggerWiFiToCellularByThirdParty(this.mUrlRequestContextAdapter);     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void triggerGetDomain(boolean r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        nativeTriggerGetDomain(this.mUrlRequestContextAdapter, r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void tryStartNetDetect(String[] r8, int r10, int r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        nativeTryStartNetDetect(this.mUrlRequestContextAdapter, r8, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void ttDnsResolve(String r8, int r10, String r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        nativeTTDnsResolve(this.mUrlRequestContextAdapter, r8, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public Map<String, String> ttUrlDispatch(String r8) {
        URLDispatch r10 = new URLDispatch(r8);
        Object r11 = this.mLock;
        monitor-enter(r11);
        checkHaveAdapter();     // Catch: Throwable -> L8
        nativeTTUrlDispatch(this.mUrlRequestContextAdapter, r10, r8);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        r10.waitResult();
        HashMap r12 = new HashMap();
        r12.put(URLDispatch.KEY_FINAL_URL, r10.getFinalUrl());
        r12.put(URLDispatch.KEY_EPOCH, r10.getEpoch());
        r12.put(URLDispatch.KEY_ETAG, r10.getEtag());
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void updateStoreRegionFromServer(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        nativeUpdateStoreRegionFromServer(this.mUrlRequestContextAdapter, r14, r15, r16, r17, r18, r19, r20, r21);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r10, Executor r11, List<String> r12, Map<String, String> r13, Map<String, String> r14, boolean r15) {
        return new CronetWebsocketConnection(this, r10, r11, r12, r13, r14, r15);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public URLConnection openConnection(URL r8, Proxy r10) {
        if (r10.type() != Proxy.Type.DIRECT) goto L14;
        String r11 = r8.getProtocol();
        if ("http".equals(r11) == true) goto L12;
        if (LocationInfoConst.HTTPS.equals(r11) == true) goto L12;
        throw new UnsupportedOperationException(b.c("Unexpected protocol:", r11));
    L12:
        return new CronetHttpURLConnection(r8, this);
    L14:
        throw new UnsupportedOperationException();
    }
}
