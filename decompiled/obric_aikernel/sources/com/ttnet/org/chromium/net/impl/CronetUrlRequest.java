package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNIAdditionalImport;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
@JNIAdditionalImport({VersionSafeCallbacks.class})
@JNINamespace("cronet")
@VisibleForTesting
public final class CronetUrlRequest extends UrlRequestBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long mAddCookieCostUs;
    private final boolean mAllowDirectExecutor;
    private String mAuthCertPassword;
    private String mAuthCertUsername;
    private final VersionSafeCallbacks.UrlRequestCallback mCallback;
    private final int mCronetEngineId;
    private String mCronetMapKey;
    private final boolean mDisableCache;
    private final boolean mDisableConnectionMigration;
    private CronetException mException;
    private final Executor mExecutor;
    private String mFinalUrl;
    private int mFinishedReason;
    private final int mIdempotency;
    private String mInitialMethod;
    private final String mInitialUrl;
    private final CronetLogger mLogger;
    private CronetMetrics mMetrics;
    private final long mNetworkHandle;
    private Runnable mOnDestroyedCallbackForTesting;
    private OnReadCompletedRunnable mOnReadCompletedTask;
    private final int mPriority;
    private boolean mQuicConnectionMigrationAttempted;
    private boolean mQuicConnectionMigrationSuccessful;
    private final Collection<Object> mRequestAnnotations;
    private final CronetUrlRequestContext mRequestContext;
    private int mRequestCookieSource;
    private final VersionSafeCallbacks.RequestFinishedInfoListener mRequestFinishedListener;
    private int mRequestFlag;
    private final HeadersList mRequestHeaders;
    private String mRequestLog;
    private int mRequestTimeout;
    private int mRequestTypeFlags;
    private UrlResponseInfoImpl mResponseInfo;
    private long mSaveCookieCostUs;
    private int mSocketConnectTimeout;
    private int mSocketReadTimeout;
    private int mSocketWriteTimeout;
    private boolean mStarted;
    private long mThrottleNetSpeed;
    private final int mTrafficStatsTag;
    private final boolean mTrafficStatsTagSet;
    private final int mTrafficStatsUid;
    private final boolean mTrafficStatsUidSet;
    private CronetUploadDataStream mUploadDataStream;
    private final List<String> mUrlChain;
    private long mUrlRequestAdapter;
    private final Object mUrlRequestAdapterLock;
    private boolean mWaitingOnRead;
    private boolean mWaitingOnRedirect;

    @VisibleForTesting
    static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        HeadersList() {
        }
    }

    interface Natives {
        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void abortWhenUploadException(long r10, CronetUrlRequest r11);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void addRequestCookieHeader(long r10, CronetUrlRequest r11, String r12, String r13);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean addRequestHeader(long r10, CronetUrlRequest r11, String r12, String r13);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void appTimeout(long r10, CronetUrlRequest r11);

        long createRequestAdapter(CronetUrlRequest r10, long r11, String r12, int r13, int r14, boolean r15, boolean r16, boolean r17, int r18, boolean r19, int r110, int r111, long r112);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void destroy(long r10, CronetUrlRequest r11, boolean r12);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void followDeferredRedirect(long r10, CronetUrlRequest r11);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void getStatus(long r10, CronetUrlRequest r11, VersionSafeCallbacks.UrlRequestStatusListener r12);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean readData(long r10, CronetUrlRequest r11, ByteBuffer r12, int r13, int r14);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void removeRequestCookieHeader(long r10, CronetUrlRequest r11);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setAuthCredentials(long r10, CronetUrlRequest r11, String r12, String r13);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean setHttpMethod(long r10, CronetUrlRequest r11, String r12);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setRequestTimeout(long r10, CronetUrlRequest r11, int r12);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setRequestTypeFlags(long r10, CronetUrlRequest r11, int r12);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setSocketTimeout(long r10, CronetUrlRequest r11, int r12, int r13, int r14);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setThrottleNetSpeed(long r10, CronetUrlRequest r11, long r12);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void start(long r10, CronetUrlRequest r11);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void stopRedirect(long r10, CronetUrlRequest r11);
    }

    private final class OnReadCompletedRunnable implements Runnable {
        ByteBuffer mByteBuffer;
        final /* synthetic */ CronetUrlRequest this$0;

        private OnReadCompletedRunnable(CronetUrlRequest r10) {
            this.this$0 = r10;
        }

        /* synthetic */ OnReadCompletedRunnable(CronetUrlRequest r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.checkCallingThread();
            ByteBuffer r10 = this.mByteBuffer;
            this.mByteBuffer = null;
            Object r11 = CronetUrlRequest.access$000(this.this$0);     // Catch: Exception -> L16
            monitor-enter(r11);     // Catch: Exception -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Exception -> L16
        L6:
            if (CronetUrlRequest.access$100(this.this$0) == false) goto L9;
            monitor-exit(r11);     // Catch: Throwable -> L13
            return;
        L9:
            CronetUrlRequest.access$202(this.this$0, true);     // Catch: Throwable -> L13
            monitor-exit(r11);     // Catch: Throwable -> L13
            VersionSafeCallbacks.UrlRequestCallback r12 = CronetUrlRequest.access$400(this.this$0);     // Catch: Exception -> L16
            CronetUrlRequest r13 = this.this$0;     // Catch: Exception -> L16
            r12.onReadCompleted(r13, CronetUrlRequest.access$300(r13), r10);     // Catch: Exception -> L16
            return;
        L16:
            e = move-exception;
            CronetUrlRequest.access$500(this.this$0, e);
        }
    }

    static {
    }

    CronetUrlRequest(CronetUrlRequestContext r10, String r11, int r12, UrlRequest.Callback r13, Executor r14, Collection<Object> r15, boolean r16, boolean r17, boolean r18, boolean r19, int r110, boolean r20, int r21, RequestFinishedInfo.Listener r22, int r23, long r24) {
        this.mUrlRequestAdapterLock = new Object();
        ArrayList r25 = new ArrayList();
        this.mUrlChain = r25;
        this.mRequestHeaders = new HeadersList();
        Objects.requireNonNull(r11, "URL is required");
        Objects.requireNonNull(r13, "Listener is required");
        Objects.requireNonNull(r14, "Executor is required");
        this.mAllowDirectExecutor = r18;
        this.mRequestContext = r10;
        this.mCronetEngineId = r10.getCronetEngineId();
        this.mLogger = r10.getCronetLogger();
        this.mInitialUrl = r11;
        r25.add(r11);
        this.mPriority = convertRequestPriority(r12);
        this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(r13);
        this.mExecutor = r14;
        this.mRequestAnnotations = r15;
        this.mDisableCache = r16;
        this.mDisableConnectionMigration = r17;
        this.mTrafficStatsTagSet = r19;
        this.mTrafficStatsTag = r110;
        this.mTrafficStatsUidSet = r20;
        this.mTrafficStatsUid = r21;
        if (r22 == null) goto L5;
        VersionSafeCallbacks.RequestFinishedInfoListener r26 = new VersionSafeCallbacks.RequestFinishedInfoListener(r22);
    L6:
        this.mRequestFinishedListener = r26;
        this.mIdempotency = convertIdempotency(r23);
        this.mNetworkHandle = r24;
        return;
    L5:
        r26 = null;
        goto L6
    }

    static /* synthetic */ Object access$000(CronetUrlRequest r10) {
        return r10.mUrlRequestAdapterLock;
    }

    static /* synthetic */ boolean access$100(CronetUrlRequest r10) {
        return r10.isDoneLocked();
    }

    static /* synthetic */ boolean access$1002(CronetUrlRequest r10, boolean r11) {
        r10.mWaitingOnRedirect = r11;
        return r11;
    }

    static /* synthetic */ void access$1200(CronetUrlRequest r10, int r11) {
        r10.destroyRequestAdapterLocked(r11);
    }

    static /* synthetic */ CronetException access$1300(CronetUrlRequest r10) {
        return r10.mException;
    }

    static /* synthetic */ VersionSafeCallbacks.RequestFinishedInfoListener access$1400(CronetUrlRequest r10) {
        return r10.mRequestFinishedListener;
    }

    static /* synthetic */ boolean access$202(CronetUrlRequest r10, boolean r11) {
        r10.mWaitingOnRead = r11;
        return r11;
    }

    static /* synthetic */ UrlResponseInfoImpl access$300(CronetUrlRequest r10) {
        return r10.mResponseInfo;
    }

    static /* synthetic */ VersionSafeCallbacks.UrlRequestCallback access$400(CronetUrlRequest r10) {
        return r10.mCallback;
    }

    static /* synthetic */ void access$500(CronetUrlRequest r10, Exception r11) {
        r10.onCallbackException(r11);
    }

    static /* synthetic */ CronetUploadDataStream access$600(CronetUrlRequest r10) {
        return r10.mUploadDataStream;
    }

    static /* synthetic */ long access$700(CronetUrlRequest r10) {
        return r10.mUrlRequestAdapter;
    }

    static /* synthetic */ void access$800(CronetUrlRequest r10) {
        r10.startInternalLocked();
    }

    static /* synthetic */ void access$900(CronetUrlRequest r10) {
        r10.maybeReportMetrics();
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
        Map<String, String> r15 = this.mRequestContext.onCallToAddSecurityFactor(r10, r12);
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

    @RequiresApi(26)
    private CronetLogger.CronetTrafficInfo buildCronetTrafficInfo() {
        UrlResponseInfoImpl r10 = this.mResponseInfo;
        boolean r11 = false;
        if (r10 == null) goto L5;
        Map<String, List<String>> r12 = r10.getAllHeaders();
        String r13 = this.mResponseInfo.getNegotiatedProtocol();
        String r15 = r13;
        int r14 = this.mResponseInfo.getHttpStatusCode();
        r11 = this.mResponseInfo.wasCached();
    L6:
        long r16 = this.mMetrics.getSentByteCount().longValue();
        if (r11 == true) goto L9;
    L11:
        long r17 = estimateHeadersSizeInBytes(this.mRequestHeaders);
        long r18 = Math.max(0, r16 - r17);
    L12:
        long r19 = this.mMetrics.getReceivedByteCount().longValue();
        if (r11 == true) goto L15;
    L17:
        long r20 = estimateHeadersSizeInBytes(r12);
        long r110 = Math.max(0, r19 - r20);
    L19:
        if (this.mMetrics.getRequestStart() != null) goto L21;
    L23:
        Duration r21 = Duration.ofSeconds(0);
    L24:
        Duration r111 = r21;
        if (this.mMetrics.getRequestStart() != null) goto L27;
    L29:
        Duration r22 = Duration.ofSeconds(0);
    L31:
        return new CronetLogger.CronetTrafficInfo(r17, r18, r20, r110, r14, r111, r22, r15, this.mQuicConnectionMigrationAttempted, this.mQuicConnectionMigrationSuccessful);
    L27:
        if (this.mMetrics.getRequestEnd() == null) goto L29;
        r22 = Duration.ofMillis(this.mMetrics.getRequestEnd().getTime() - this.mMetrics.getRequestStart().getTime());
        goto L31
    L21:
        if (this.mMetrics.getResponseStart() == null) goto L23;
        r21 = Duration.ofMillis(this.mMetrics.getResponseStart().getTime() - this.mMetrics.getRequestStart().getTime());
        goto L24
    L15:
        if (r19 != 0) goto L17;
        r20 = 0;
        r110 = 0;
        goto L19
    L9:
        if (r16 != 0) goto L11;
        r17 = 0;
        r18 = 0;
        goto L12
    L5:
        r12 = Collections.emptyMap();
        r14 = 0;
        r15 = "";
        goto L6
    }

    private void checkNotStarted() {
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L11;
        if (isDoneLocked() == true) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L11:
        throw new IllegalStateException("Request is already started.");     // Catch: Throwable -> L12
    }

    private static int convertIdempotency(int r10) {
        int r11 = 1;
        if (r10 == 1) goto L8;
        r11 = 2;
        if (r10 == 2) goto L8;
        return 0;
    L8:
        return r11;
    }

    private static int convertRequestPriority(int r10) {
        if (r10 != 0) goto L5;
        return 1;
    L5:
        if (r10 == 1) goto L14;
        if (r10 != 2) goto L8;
        return 3;
    L8:
        if (r10 == 4) goto L10;
        return 4;
    L10:
        return 5;
    L14:
        return 2;
    }

    private void destroyRequestAdapterLocked(int r10) {
        this.mFinishedReason = r10;
        if (this.mUrlRequestAdapter != 0) goto L5;
        return;
    L5:
        this.mRequestContext.onRequestDestroyed();
        Natives r11 = CronetUrlRequestJni.get();
        long r12 = this.mUrlRequestAdapter;
        if (r10 != 2) goto L8;
        boolean r13 = true;
    L9:
        r11.destroy(r12, this, r13);
        this.mUrlRequestAdapter = 0;
        return;
    L8:
        r13 = false;
        goto L9
    }

    @VisibleForTesting
    static long estimateHeadersSizeInBytes(HeadersList r10) {
        long r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, String>> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L14;
        Map.Entry<String, String> r13 = r12.next();
        String r14 = r13.getKey();
        if (r14 == null) goto L12;
        r11 = r11 + ((long) r14.length());
    L12:
        if (r13.getValue() == null) goto L7;
        r11 = r11 + ((long) r13.getValue().length());
        goto L7
    L14:
        return r11;
    }

    @VisibleForTesting
    static long estimateHeadersSizeInBytes(Map<String, List<String>> r10) {
        long r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, List<String>>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<String, List<String>> r13 = r12.next();
        String r14 = r13.getKey();
        if (r14 == null) goto L12;
        r11 = r11 + ((long) r14.length());
    L12:
        if (r13.getValue() == null) goto L7;
        Iterator<String> r15 = r13.getValue().iterator();
    L16:
        if (r15.hasNext() == false) goto L7;
        r11 = r11 + ((long) r15.next().length());
        goto L16
    L18:
        return r11;
    }

    private void failWithException(final CronetException r10) {
        Object r11 = this.mUrlRequestAdapterLock;
        monitor-enter(r11);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L16
        return;
    L8:
        this.mException = r10;     // Catch: Throwable -> L16
        destroyRequestAdapterLocked(1);     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
        this.mExecutor.execute(new AnonymousClass3(this, r10));     // Catch: RejectedExecutionException -> L13
        return;
    L13:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
    }

    private RequestFinishedInfo getRequestFinishedInfo() {
        return new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mFinishedReason, this.mResponseInfo, this.mException);
    }

    private boolean isDoneLocked() {
        if (this.mStarted == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L7;
        return true;
    }

    private int mapUrlRequestErrorToApiErrorCode(int r10) {
        switch(r10) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L9;
            case 10: goto L7;
            case 11: goto L5;
            default: goto L3;
        };
    L3:
        Log.e(CronetUrlRequestContext.LOG_TAG, "Unknown error code: " + r10, new Object[0]);
        return r10;
    L5:
        return 11;
    L7:
        return 10;
    L9:
        return 9;
    L11:
        return 8;
    L13:
        return 7;
    L15:
        return 6;
    L17:
        return 5;
    L19:
        return 4;
    L21:
        return 3;
    L23:
        return 2;
    L25:
        return 1;
    }

    private void maybeReportMetrics() {
        if (this.mMetrics != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L17;
    L10:
        final RequestFinishedInfoImpl r10 = new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mFinishedReason, this.mResponseInfo, this.mException);
        this.mRequestContext.reportRequestFinished(r10);
        VersionSafeCallbacks.RequestFinishedInfoListener r11 = this.mRequestFinishedListener;
        if (r11 == null) goto L22;
        r11.getExecutor().execute(new AnonymousClass11(this, r10));     // Catch: RejectedExecutionException -> L14
        return;
    L14:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        return;
    L22:
        return;
    L17:
        this.mLogger.logCronetTrafficInfo(this.mCronetEngineId, buildCronetTrafficInfo());     // Catch: RuntimeException -> L8
    L8:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Error while trying to log CronetTrafficInfo: ", new Object[]{e});
        goto L10
    }

    private void onCallbackException(Exception r10) {
        CallbackExceptionImpl r11 = new CallbackExceptionImpl("Exception received from UrlRequest.Callback", r10);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", new Object[]{r10});
        failWithException(r11);
    }

    @CalledByNative
    private void onCanceled() {
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        postTaskToExecutor(new AnonymousClass7(this));
    }

    @CalledByNative
    private void onError(int r10, int r11, int r12, String r13, long r14) {
        UrlResponseInfoImpl r15 = this.mResponseInfo;
        if (r15 == null) goto L5;
        r15.setReceivedByteCount(r14);
    L5:
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        if (r10 != 10) goto L8;
    L11:
        failWithException(new QuicExceptionImpl("Exception in CronetUrlRequest: " + r13, r10, r11, r12));
        return;
    L8:
        if (r10 == 3) goto L11;
        failWithException(new NetworkExceptionImpl("Exception in CronetUrlRequest: " + r13, mapUrlRequestErrorToApiErrorCode(r10), r11));
    }

    @CalledByNative
    private void onMetricsCollected(long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, long r75, long r77, boolean r79, long r80, long r82, long r84, String r86, long r87, long r89, String r91, String r92, String r93, String r94, boolean r95, boolean r96, boolean r97, boolean r98) {
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mMetrics != null) goto L11;
        this.mMetrics = new CronetMetrics(r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r73, r75, r77, r79, r80, r82, r84, r86, r87, r89, r91, r92, this.mAddCookieCostUs, this.mSaveCookieCostUs, this.mRequestCookieSource, r95, r96);     // Catch: Throwable -> L12
        this.mRequestLog = r94;     // Catch: Throwable -> L12
        this.mFinalUrl = r93;     // Catch: Throwable -> L12
        this.mCallback.onRequestLogCollected(r94, getRequestFinishedInfo());     // Catch: Throwable -> L12
        this.mQuicConnectionMigrationAttempted = r97;     // Catch: Throwable -> L12
        this.mQuicConnectionMigrationSuccessful = r98;     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        final RequestFinishedInfo r11 = getRequestFinishedInfo();
        postTaskToExecutor(new AnonymousClass9(this, r11));
        this.mRequestContext.reportRequestFinished(r11);
        return;
    L11:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L12
    }

    @CalledByNative
    private void onNativeAdapterDestroyed() {
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
        Runnable r11 = this.mOnDestroyedCallbackForTesting;     // Catch: Throwable -> L18
        if (r11 == null) goto L8;
        r11.run();     // Catch: Throwable -> L18
    L8:
        if (this.mException != null) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L18
        this.mExecutor.execute(new AnonymousClass10(this));     // Catch: RejectedExecutionException -> L15
        return;
    L15:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer r10, int r11, int r12, int r13, long r14) {
        this.mResponseInfo.setReceivedByteCount(r14);
        AnonymousClass1 r15 = null;
        if (r10.position() == r12) goto L5;
    L12:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r10.limit() != r13) goto L12;
        if (this.mOnReadCompletedTask != null) goto L10;
        this.mOnReadCompletedTask = new OnReadCompletedRunnable(this, r15);
    L10:
        r10.position(r12 + r11);
        OnReadCompletedRunnable r16 = this.mOnReadCompletedTask;
        r16.mByteBuffer = r10;
        postTaskToExecutor(r16);
    }

    @CalledByNative
    private void onRedirectReceived(final String r12, int r13, String r14, String[] r15, boolean r16, String r17, String r18, long r19, final String r21) {
        final UrlResponseInfoImpl r10 = prepareResponseInfoOnNetworkThread(r13, r14, r15, r16, r17, r18, r19);
        this.mUrlChain.add(r12);
        postTaskToExecutor(new AnonymousClass4(this, r10, r12, r21));
    }

    @CalledByNative
    private void onResponseStarted(int r10, String r11, String[] r12, boolean r13, String r14, String r15, long r16, final String r17) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(r10, r11, r12, r13, r14, r15, r16);
        postTaskToExecutor(new AnonymousClass5(this, r17));
    }

    @CalledByNative
    private void onStatus(final VersionSafeCallbacks.UrlRequestStatusListener r10, final int r11) {
        postTaskToExecutor(new AnonymousClass8(this, r10, r11));
    }

    @CalledByNative
    private void onSucceeded(long r10) {
        this.mResponseInfo.setReceivedByteCount(r10);
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        postTaskToExecutor(new AnonymousClass6(this));
    }

    private void postTaskToExecutor(Runnable r10) {
        this.mExecutor.execute(r10);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        failWithException(new CronetExceptionImpl("Exception posting task to executor", e));
    }

    private UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int r12, String r13, String[] r14, boolean r15, String r16, String r17, long r18) {
        HeadersList r10 = new HeadersList();
        int r11 = 0;
    L4:
        if (r11 >= r14.length) goto L7;
        r10.add(new AbstractMap.SimpleImmutableEntry(r14[r11], r14[r11 + 1]));
        r11 = r11 + 2;
        goto L4
    L7:
        return new UrlResponseInfoImpl(new ArrayList(this.mUrlChain), r12, r13, r10, r15, r16, r17, r18);
    }

    private void startInternalLocked() {
        String r10 = this.mCronetMapKey;
        if (r10 == null) goto L5;
        CronetUrlRequestMapping.AddRequest(r10, this);
    L5:
        CronetUrlRequestJni.get().start(this.mUrlRequestAdapter, this);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void AddRequestCookieHeader(String r10, String r11) {
        Object r12 = this.mUrlRequestAdapterLock;
        monitor-enter(r12);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r12);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().addRequestCookieHeader(this.mUrlRequestAdapter, this, r10, r11);     // Catch: Throwable -> L11
        monitor-exit(r12);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void RemoveRequestCookieHeader() {
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().removeRequestCookieHeader(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void addHeader(String r10, String r11) {
        checkNotStarted();
        Objects.requireNonNull(r10, "Invalid header name.");
        Objects.requireNonNull(r11, "Invalid header value.");
        this.mRequestHeaders.add(new AbstractMap.SimpleImmutableEntry(r10, r11));
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void appTimeout() {
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().appTimeout(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void cancel() {
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mStarted == false) goto L12;
        destroyRequestAdapterLocked(2);     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
    }

    void checkCallingThread() {
        if (this.mAllowDirectExecutor == false) goto L5;
        return;
    L5:
        if (this.mRequestContext.isNetworkThread(Thread.currentThread()) == true) goto L8;
        return;
    L8:
        throw new InlineExecutionProhibitedException();
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void followRedirect() {
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mWaitingOnRedirect == false) goto L14;
        this.mWaitingOnRedirect = false;     // Catch: Throwable -> L15
        if (isDoneLocked() == false) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L10:
        CronetUrlRequestJni.get().followDeferredRedirect(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L14:
        throw new IllegalStateException("No redirect to follow.");     // Catch: Throwable -> L15
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getFinalUrl() {
        return this.mFinalUrl;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getRequestLog() {
        return this.mRequestLog;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void getStatus(UrlRequest.StatusListener r10) {
        final VersionSafeCallbacks.UrlRequestStatusListener r11 = new VersionSafeCallbacks.UrlRequestStatusListener(r10);
        Object r12 = this.mUrlRequestAdapterLock;
        monitor-enter(r12);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter == 0) goto L9;
        CronetUrlRequestJni.get().getStatus(this.mUrlRequestAdapter, this, r11);     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        return;
    L9:
        monitor-exit(r12);     // Catch: Throwable -> L12
        postTaskToExecutor(new AnonymousClass2(this, r11));
    }

    @VisibleForTesting
    public long getUrlRequestAdapterForTesting() {
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
        long r11 = this.mUrlRequestAdapter;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public boolean isDone() {
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
        boolean r11 = isDoneLocked();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    void onUploadException(Throwable r10) {
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in upload method", new Object[]{r10});
        Object r11 = this.mUrlRequestAdapterLock;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().abortWhenUploadException(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void read(ByteBuffer r10) {
        Preconditions.checkHasRemaining(r10);
        Preconditions.checkDirect(r10);
        Object r11 = this.mUrlRequestAdapterLock;
        monitor-enter(r11);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mWaitingOnRead == false) goto L17;
        this.mWaitingOnRead = false;     // Catch: Throwable -> L18
        if (isDoneLocked() == false) goto L11;
        monitor-exit(r11);     // Catch: Throwable -> L18
        return;
    L11:
        if (CronetUrlRequestJni.get().readData(this.mUrlRequestAdapter, this, r10, r10.position(), r10.limit()) == false) goto L14;
        monitor-exit(r11);     // Catch: Throwable -> L18
        return;
    L14:
        this.mWaitingOnRead = true;     // Catch: Throwable -> L18
        throw new IllegalArgumentException("Unable to call native read");     // Catch: Throwable -> L18
    L17:
        throw new IllegalStateException("Unexpected read attempt.");     // Catch: Throwable -> L18
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAddCookieCostUs(long r10) {
        this.mAddCookieCostUs = r10;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAuthCredentials(String r10, String r11) {
        this.mAuthCertUsername = r10;
        this.mAuthCertPassword = r11;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setHttpMethod(String r10) {
        checkNotStarted();
        Objects.requireNonNull(r10, "Method is required.");
        this.mInitialMethod = r10;
    }

    @VisibleForTesting
    public void setOnDestroyedCallbackForTesting(Runnable r10) {
        Object r11 = this.mUrlRequestAdapterLock;
        monitor-enter(r11);
        this.mOnDestroyedCallbackForTesting = r10;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public void setOnDestroyedUploadCallbackForTesting(Runnable r10) {
        this.mUploadDataStream.setOnDestroyedCallbackForTesting(r10);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestCookieSource(int r10) {
        this.mRequestCookieSource = r10;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestFlag(int r10) {
        this.mRequestFlag = r10;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setRequestTimeout(int r10) {
        this.mRequestTimeout = r10;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestTypeFlags(int r10) {
        this.mRequestTypeFlags = r10 | this.mRequestTypeFlags;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setSaveCookieCostUs(long r10) {
        this.mSaveCookieCostUs = r10;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketConnectTimeout(int r10) {
        this.mSocketConnectTimeout = r10;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketReadTimeout(int r10) {
        this.mSocketReadTimeout = r10;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketWriteTimeout(int r10) {
        this.mSocketWriteTimeout = r10;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setThrottleNetSpeed(long r10) {
        Object r11 = this.mUrlRequestAdapterLock;
        monitor-enter(r11);
        this.mThrottleNetSpeed = r10;     // Catch: Throwable -> L9
        if (this.mUrlRequestAdapter == 0) goto L7;
        CronetUrlRequestJni.get().setThrottleNetSpeed(this.mUrlRequestAdapter, this, r10);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider r10, Executor r11) {
        Objects.requireNonNull(r10, "Invalid UploadDataProvider.");
        if (this.mInitialMethod != null) goto L5;
        this.mInitialMethod = CloudConfig.REQUEST_TYPE_POST;
    L5:
        this.mUploadDataStream = new CronetUploadDataStream(r10, r11, this);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void start() {
        Object r14 = this.mUrlRequestAdapterLock;
        monitor-enter(r14);
        checkNotStarted();     // Catch: Throwable -> L75
    L88:
    L84:
        final CronetUrlRequest r10 = this;
        r10.mUrlRequestAdapter = CronetUrlRequestJni.get().createRequestAdapter(this, this.mRequestContext.getUrlRequestContextAdapter(), this.mInitialUrl, this.mPriority, this.mRequestFlag, this.mDisableCache, this.mDisableConnectionMigration, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mIdempotency, this.mNetworkHandle);     // Catch: RuntimeException -> L62 Throwable -> L79
        r10.mRequestContext.onRequestStarted();     // Catch: RuntimeException -> L62 Throwable -> L79
        if (r10.mInitialMethod != null) goto L14;
    L18:
        Iterator<Map.Entry<String, String>> r11 = r10.mRequestHeaders.iterator();     // Catch: RuntimeException -> L62 Throwable -> L79
        boolean r13 = false;
    L20:
        if (r11.hasNext() == false) goto L36;
        Map.Entry<String, String> r12 = r11.next();     // Catch: RuntimeException -> L62 Throwable -> L79
        if (r12.getKey().equalsIgnoreCase(NetConst.KEY_CONTENT_TYPE) == false) goto L27;
        if (r12.getValue().isEmpty() == true) goto L27;
        r13 = true;
    L27:
        if (r12.getKey().equalsIgnoreCase("Tt-Map-Key") == false) goto L32;
        if (r12.getValue().isEmpty() == true) goto L32;
        r10.mCronetMapKey = r12.getValue();     // Catch: RuntimeException -> L62 Throwable -> L79
    L32:
        if (CronetUrlRequestJni.get().addRequestHeader(r10.mUrlRequestAdapter, this, r12.getKey(), r12.getValue()) == true) goto L20;
        throw new IllegalArgumentException("Invalid header " + r12.getKey() + "=" + r12.getValue());     // Catch: RuntimeException -> L62 Throwable -> L79
    L36:
        CronetUrlRequestJni.get().setSocketTimeout(r10.mUrlRequestAdapter, this, r10.mSocketConnectTimeout, r10.mSocketReadTimeout, r10.mSocketWriteTimeout);     // Catch: RuntimeException -> L62 Throwable -> L79
        CronetUrlRequestJni.get().setRequestTimeout(r10.mUrlRequestAdapter, r10, r10.mRequestTimeout);     // Catch: RuntimeException -> L62 Throwable -> L79
        if (r10.mThrottleNetSpeed <= 0) goto L40;
        CronetUrlRequestJni.get().setThrottleNetSpeed(r10.mUrlRequestAdapter, this, r10.mThrottleNetSpeed);     // Catch: RuntimeException -> L62 Throwable -> L79
    L40:
        if (r10.mRequestTypeFlags <= 0) goto L43;
        CronetUrlRequestJni.get().setRequestTypeFlags(r10.mUrlRequestAdapter, r10, r10.mRequestTypeFlags);     // Catch: RuntimeException -> L62 Throwable -> L79
    L43:
        if (r10.mAuthCertUsername != null) goto L45;
    L47:
        CronetUploadDataStream r15 = r10.mUploadDataStream;     // Catch: RuntimeException -> L62 Throwable -> L79
        if (r15 == null) goto L59;
        int r16 = 1;
        if (r13 == false) goto L57;
        r10.mStarted = true;     // Catch: RuntimeException -> L54 Throwable -> L79
        r15.postTaskToExecutor(new AnonymousClass1(r10));     // Catch: RuntimeException -> L54 Throwable -> L79
        monitor-exit(r14);     // Catch: Throwable -> L79
        return;
    L57:
        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");     // Catch: RuntimeException -> L54 Throwable -> L79
    L54:
        e = e;
    L73:
        r10.destroyRequestAdapterLocked(r16);     // Catch: Throwable -> L79
        throw e;     // Catch: Throwable -> L79
    L59:
        r10.mStarted = true;     // Catch: Throwable -> L79
        startInternalLocked();     // Catch: Throwable -> L79
        monitor-exit(r14);     // Catch: Throwable -> L79
        return;
    L45:
        if (r10.mAuthCertPassword == null) goto L47;
        CronetUrlRequestJni.get().setAuthCredentials(r10.mUrlRequestAdapter, this, r10.mAuthCertUsername, r10.mAuthCertPassword);     // Catch: RuntimeException -> L62 Throwable -> L79
        goto L47
    L14:
        if (CronetUrlRequestJni.get().setHttpMethod(r10.mUrlRequestAdapter, r10, r10.mInitialMethod) == true) goto L18;
        throw new IllegalArgumentException("Invalid http method " + r10.mInitialMethod);     // Catch: RuntimeException -> L62 Throwable -> L79
    L62:
        e = e;
    L72:
        r16 = 1;
    L64:
        e = e;
        r16 = 1;
        r10 = this;
    L68:
        e = e;
        r10 = this;
    L66:
        th = th;
        Object r17 = r14;
    L77:
        monitor-exit(r17);     // Catch: Throwable -> L79
        throw th;
    L70:
        e = e;
        r10 = this;
    L79:
        th = th;
    L75:
        th = th;
        r17 = r14;
        goto L77
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void stopRedirect() {
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().stopRedirect(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }
}
