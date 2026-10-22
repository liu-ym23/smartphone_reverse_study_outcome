package com.ttnet.org.chromium.net.impl;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNIAdditionalImport;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import defpackage.a;
import defpackage.b;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@JNIAdditionalImport({VersionSafeCallbacks.class})
@JNINamespace("cronet")
public final class CronetUrlRequest extends UrlRequestBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean mAllowDirectExecutor;
    private final VersionSafeCallbacks.UrlRequestCallback mCallback;
    private String mCronetMapKey;
    private final boolean mDisableCache;
    private final boolean mDisableConnectionMigration;
    private CronetException mException;
    private final Executor mExecutor;
    private int mFinishedReason;
    private String mInitialMethod;
    private final String mInitialUrl;
    private CronetMetrics mMetrics;

    @GuardedBy("mUrlRequestAdapterLock")
    private Runnable mOnDestroyedCallbackForTesting;
    private OnReadCompletedRunnable mOnReadCompletedTask;
    private final int mPriority;
    private final Collection<Object> mRequestAnnotations;
    private final CronetUrlRequestContext mRequestContext;
    private final VersionSafeCallbacks.RequestFinishedInfoListener mRequestFinishedListener;
    private int mRequestFlag;
    private final HeadersList mRequestHeaders;
    private String mRequestLog;
    private int mRequestTimeout;
    private UrlResponseInfoImpl mResponseInfo;
    private int mSocketConnectTimeout;
    private int mSocketReadTimeout;
    private int mSocketWriteTimeout;

    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mStarted;
    private long mThrottleNetSpeed;
    private final int mTrafficStatsTag;
    private final boolean mTrafficStatsTagSet;
    private final int mTrafficStatsUid;
    private final boolean mTrafficStatsUidSet;
    private CronetUploadDataStream mUploadDataStream;
    private final List<String> mUrlChain;

    @GuardedBy("mUrlRequestAdapterLock")
    private long mUrlRequestAdapter;
    private final Object mUrlRequestAdapterLock;

    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mWaitingOnRead;

    @GuardedBy("mUrlRequestAdapterLock")
    private boolean mWaitingOnRedirect;

    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        private HeadersList() {
        }

        public /* synthetic */ HeadersList(AnonymousClass1 r8) {
            this();
        }
    }

    public final class OnReadCompletedRunnable implements Runnable {
        ByteBuffer mByteBuffer;
        final /* synthetic */ CronetUrlRequest this$0;

        private OnReadCompletedRunnable(CronetUrlRequest r8) {
            this.this$0 = r8;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.checkCallingThread();
            ByteBuffer r8 = this.mByteBuffer;
            this.mByteBuffer = null;
            Object r10 = CronetUrlRequest.access$100(this.this$0);     // Catch: Exception -> L16
            monitor-enter(r10);     // Catch: Exception -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Exception -> L16
        L6:
            if (CronetUrlRequest.access$200(this.this$0) == false) goto L9;
            monitor-exit(r10);     // Catch: Throwable -> L13
            return;
        L9:
            CronetUrlRequest.access$302(this.this$0, true);     // Catch: Throwable -> L13
            monitor-exit(r10);     // Catch: Throwable -> L13
            VersionSafeCallbacks.UrlRequestCallback r11 = CronetUrlRequest.access$500(this.this$0);     // Catch: Exception -> L16
            CronetUrlRequest r12 = this.this$0;     // Catch: Exception -> L16
            r11.onReadCompleted(r12, CronetUrlRequest.access$400(r12), r8);     // Catch: Exception -> L16
            return;
        L16:
            e = move-exception;
            CronetUrlRequest.access$600(this.this$0, e);
        }

        public /* synthetic */ OnReadCompletedRunnable(CronetUrlRequest r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CronetUrlRequest(CronetUrlRequestContext r10, String r11, int r12, UrlRequest.Callback r13, Executor r14, Collection<Object> r15, boolean r16, boolean r17, boolean r18, boolean r19, int r110, boolean r20, int r21, RequestFinishedInfo.Listener r22) {
        this.mUrlRequestAdapterLock = new Object();
        ArrayList r8 = new ArrayList();
        this.mUrlChain = r8;
        VersionSafeCallbacks.RequestFinishedInfoListener r23 = null;
        this.mRequestHeaders = new HeadersList(0 == true ? 1 : 0);
        if (r11 == null) goto L16;
        if (r13 == null) goto L14;
        if (r14 == null) goto L12;
        this.mAllowDirectExecutor = r18;
        this.mRequestContext = r10;
        this.mInitialUrl = r11;
        r8.add(r11);
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
        if (r22 == null) goto L9;
        r23 = new VersionSafeCallbacks.RequestFinishedInfoListener(r22);
    L9:
        this.mRequestFinishedListener = r23;
        return;
    L12:
        throw new NullPointerException("Executor is required");
    L14:
        throw new NullPointerException("Listener is required");
    L16:
        throw new NullPointerException("URL is required");
    }

    public static /* synthetic */ Object access$100(CronetUrlRequest r8) {
        return r8.mUrlRequestAdapterLock;
    }

    public static /* synthetic */ void access$1000(CronetUrlRequest r8) {
        r8.maybeReportMetrics();
    }

    public static /* synthetic */ boolean access$1102(CronetUrlRequest r8, boolean r10) {
        r8.mWaitingOnRedirect = r10;
        return r10;
    }

    public static /* synthetic */ void access$1300(CronetUrlRequest r8, int r10) {
        r8.destroyRequestAdapterLocked(r10);
    }

    public static /* synthetic */ VersionSafeCallbacks.RequestFinishedInfoListener access$1400(CronetUrlRequest r8) {
        return r8.mRequestFinishedListener;
    }

    public static /* synthetic */ boolean access$200(CronetUrlRequest r8) {
        return r8.isDoneLocked();
    }

    public static /* synthetic */ boolean access$302(CronetUrlRequest r8, boolean r10) {
        r8.mWaitingOnRead = r10;
        return r10;
    }

    public static /* synthetic */ UrlResponseInfoImpl access$400(CronetUrlRequest r8) {
        return r8.mResponseInfo;
    }

    public static /* synthetic */ VersionSafeCallbacks.UrlRequestCallback access$500(CronetUrlRequest r8) {
        return r8.mCallback;
    }

    public static /* synthetic */ void access$600(CronetUrlRequest r8, Exception r10) {
        r8.onCallbackException(r10);
    }

    public static /* synthetic */ CronetUploadDataStream access$700(CronetUrlRequest r8) {
        return r8.mUploadDataStream;
    }

    public static /* synthetic */ long access$800(CronetUrlRequest r8) {
        return r8.mUrlRequestAdapter;
    }

    public static /* synthetic */ void access$900(CronetUrlRequest r8) {
        r8.startInternalLocked();
    }

    @CalledByNative
    private String[] addSecurityFactor(String r8, String[] r10) {
        HashMap r11 = new HashMap();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r10.length) goto L6;
        r11.put(r10[r13].toLowerCase(Locale.US), r10[r13 + 1]);
        r13 = r13 + 2;
        goto L4
    L6:
        Map<String, String> r14 = this.mRequestContext.onCallToAddSecurityFactor(r8, r11);
        if (r14 != null) goto L10;
        return null;
    L10:
        String[] r15 = new String[r14.size() * 2];
        Iterator<Map.Entry<String, String>> r16 = r14.entrySet().iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        Map.Entry<String, String> r17 = r16.next();
        r15[r12] = r17.getKey();
        r15[r12 + 1] = r17.getValue();
        r12 = r12 + 2;
        goto L12
    L14:
        return r15;
    }

    private void checkNotStarted() {
        Object r8 = this.mUrlRequestAdapterLock;
        monitor-enter(r8);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L11;
        if (isDoneLocked() == true) goto L11;
        monitor-exit(r8);     // Catch: Throwable -> L12
        return;
    L11:
        throw new IllegalStateException("Request is already started.");     // Catch: Throwable -> L12
    }

    private static int convertRequestPriority(int r8) {
        if (r8 != 0) goto L5;
        return 1;
    L5:
        if (r8 == 1) goto L14;
        if (r8 != 2) goto L8;
        return 3;
    L8:
        if (r8 == 4) goto L10;
        return 4;
    L10:
        return 5;
    L14:
        return 2;
    }

    @GuardedBy("mUrlRequestAdapterLock")
    private void destroyRequestAdapterLocked(int r8) {
        this.mFinishedReason = r8;
        if (this.mUrlRequestAdapter != 0) goto L5;
        return;
    L5:
        this.mRequestContext.onRequestDestroyed();
        long r10 = this.mUrlRequestAdapter;
        if (r8 != 2) goto L8;
        boolean r11 = true;
    L9:
        nativeDestroy(r10, r11);
        this.mUrlRequestAdapter = 0;
        return;
    L8:
        r11 = false;
        goto L9
    }

    private void failWithException(final CronetException r8) {
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L16
        return;
    L8:
        this.mException = r8;     // Catch: Throwable -> L16
        destroyRequestAdapterLocked(1);     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        Runnable r11 = new AnonymousClass3(this, r8);
        this.mExecutor.execute(r11);     // Catch: RejectedExecutionException -> L13
        return;
    L13:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
    }

    private RequestFinishedInfo getRequestFinishedInfo() {
        return new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mFinishedReason, this.mResponseInfo, this.mException);
    }

    @GuardedBy("mUrlRequestAdapterLock")
    private boolean isDoneLocked() {
        if (this.mStarted == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L7;
        return true;
    }

    private int mapUrlRequestErrorToApiErrorCode(int r8) {
        switch(r8) {
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
        Log.e(CronetUrlRequestContext.LOG_TAG, a.d("Unknown error code: ", r8), new Object[0]);
        return r8;
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
        CronetMetrics r8 = this.mMetrics;
        if (r8 == null) goto L13;
        final RequestFinishedInfoImpl r10 = new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, r8, this.mFinishedReason, this.mResponseInfo, this.mException);
        this.mRequestContext.reportRequestFinished(r10);
        VersionSafeCallbacks.RequestFinishedInfoListener r11 = this.mRequestFinishedListener;
        if (r11 == null) goto L14;
        r11.getExecutor().execute(new AnonymousClass10(this, r10));     // Catch: RejectedExecutionException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        return;
    L14:
        return;
    }

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native void nativeAbortWhenUploadException(long r8);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native void nativeAddRequestCookieHeader(long r8, String r10, String r11);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native boolean nativeAddRequestHeader(long r8, String r10, String r11);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native void nativeAppTimeout(long r8);

    private native long nativeCreateRequestAdapter(long r8, String r10, int r11, int r12, boolean r13, boolean r14, boolean r15, boolean r16, int r17, boolean r18, int r19);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native void nativeDestroy(long r8, boolean r10);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native void nativeFollowDeferredRedirect(long r8);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native void nativeGetStatus(long r8, VersionSafeCallbacks.UrlRequestStatusListener r10);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native boolean nativeReadData(long r8, ByteBuffer r10, int r11, int r12);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native void nativeRemoveRequestCookieHeader(long r8);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native boolean nativeSetHttpMethod(long r8, String r10);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native void nativeSetRequestTimeout(long r8, int r10);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native void nativeSetSocketTimeout(long r8, int r10, int r11, int r12);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native void nativeSetThrottleNetSpeed(long r8, long r10);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native void nativeStart(long r8);

    @NativeClassQualifiedName("CronetURLRequestAdapter")
    private native void nativeStopRedirect(long r8);

    private void onCallbackException(Exception r8) {
        CallbackExceptionImpl r10 = new CallbackExceptionImpl("Exception received from UrlRequest.Callback", r8);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", new Object[]{r8});
        failWithException(r10);
    }

    @CalledByNative
    private void onCanceled() {
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        postTaskToExecutor(new AnonymousClass7(this));
    }

    @CalledByNative
    private void onError(int r8, int r10, int r11, String r12, long r13) {
        UrlResponseInfoImpl r14 = this.mResponseInfo;
        if (r14 == null) goto L5;
        r14.setReceivedByteCount(r13);
    L5:
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        if (r8 != 10) goto L8;
    L11:
        failWithException(new QuicExceptionImpl(b.c("Exception in CronetUrlRequest: ", r12), r8, r10, r11));
        return;
    L8:
        if (r8 == 3) goto L11;
        int r15 = mapUrlRequestErrorToApiErrorCode(r8);
        failWithException(new NetworkExceptionImpl(b.c("Exception in CronetUrlRequest: ", r12), r15, r10));
    }

    @CalledByNative
    private void onMetricsCollected(long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, boolean r72, long r73, long r75, long r77, String r79, long r80, long r82, String r84, String r85, String r86) {
        Object r8 = this.mUrlRequestAdapterLock;
        monitor-enter(r8);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mMetrics != null) goto L11;
        this.mMetrics = new CronetMetrics(r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r73, r75, r77, r79, r80, r82, r84, r85);     // Catch: Throwable -> L12
        this.mRequestLog = r86;     // Catch: Throwable -> L12
        this.mCallback.onRequestLogCollected(r86, getRequestFinishedInfo());     // Catch: Throwable -> L12
        monitor-exit(r8);     // Catch: Throwable -> L12
        final RequestFinishedInfo r10 = getRequestFinishedInfo();
        postTaskToExecutor(new AnonymousClass9(this, r10));
        this.mRequestContext.reportRequestFinished(r10);
        return;
    L11:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L12
    }

    @CalledByNative
    private void onNativeAdapterDestroyed() {
        Object r8 = this.mUrlRequestAdapterLock;
        monitor-enter(r8);
        Runnable r10 = this.mOnDestroyedCallbackForTesting;     // Catch: Throwable -> L13
        if (r10 == null) goto L8;
        r10.run();     // Catch: Throwable -> L13
    L8:
        if (this.mException != null) goto L11;
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer r8, int r10, int r11, int r12, long r13) {
        this.mResponseInfo.setReceivedByteCount(r13);
        AnonymousClass1 r14 = null;
        if (r8.position() == r11) goto L5;
    L12:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r8.limit() != r12) goto L12;
        if (this.mOnReadCompletedTask != null) goto L10;
        this.mOnReadCompletedTask = new OnReadCompletedRunnable(this, r14);
    L10:
        r8.position(r11 + r10);
        OnReadCompletedRunnable r15 = this.mOnReadCompletedTask;
        r15.mByteBuffer = r8;
        postTaskToExecutor(r15);
    }

    @CalledByNative
    private void onRedirectReceived(final String r12, int r13, String r14, String[] r15, boolean r16, String r17, String r18, long r19) {
        final UrlResponseInfoImpl r8 = prepareResponseInfoOnNetworkThread(r13, r14, r15, r16, r17, r18, r19);
        this.mUrlChain.add(r12);
        postTaskToExecutor(new AnonymousClass4(this, r8, r12));
    }

    @CalledByNative
    private void onResponseStarted(int r8, String r10, String[] r11, boolean r12, String r13, String r14, long r15, final String r16) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(r8, r10, r11, r12, r13, r14, r15);
        postTaskToExecutor(new AnonymousClass5(this, r16));
    }

    @CalledByNative
    private void onStatus(final VersionSafeCallbacks.UrlRequestStatusListener r8, final int r10) {
        postTaskToExecutor(new AnonymousClass8(this, r8, r10));
    }

    @CalledByNative
    private void onSucceeded(long r8) {
        this.mResponseInfo.setReceivedByteCount(r8);
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        postTaskToExecutor(new AnonymousClass6(this));
    }

    private void postTaskToExecutor(Runnable r8) {
        this.mExecutor.execute(r8);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        failWithException(new CronetExceptionImpl("Exception posting task to executor", e));
    }

    private UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int r12, String r13, String[] r14, boolean r15, String r16, String r17, long r18) {
        HeadersList r8 = new HeadersList(null);
        int r10 = 0;
    L4:
        if (r10 >= r14.length) goto L7;
        r8.add(new AbstractMap.SimpleImmutableEntry(r14[r10], r14[r10 + 1]));
        r10 = r10 + 2;
        goto L4
    L7:
        return new UrlResponseInfoImpl(new ArrayList(this.mUrlChain), r12, r13, r8, r15, r16, r17, r18);
    }

    @GuardedBy("mUrlRequestAdapterLock")
    private void startInternalLocked() {
        String r8 = this.mCronetMapKey;
        if (r8 == null) goto L5;
        CronetUrlRequestMapping.AddRequest(r8, this);
    L5:
        nativeStart(this.mUrlRequestAdapter);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void AddRequestCookieHeader(String r8, String r10) {
        Object r11 = this.mUrlRequestAdapterLock;
        monitor-enter(r11);
        long r12 = this.mUrlRequestAdapter;     // Catch: Throwable -> L11
        if (r12 != 0) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        nativeAddRequestCookieHeader(r12, r8, r10);     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void RemoveRequestCookieHeader() {
        Object r8 = this.mUrlRequestAdapterLock;
        monitor-enter(r8);
        long r10 = this.mUrlRequestAdapter;     // Catch: Throwable -> L11
        if (r10 != 0) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        nativeRemoveRequestCookieHeader(r10);     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void addHeader(String r8, String r10) {
        checkNotStarted();
        if (r8 == null) goto L10;
        if (r10 == null) goto L8;
        this.mRequestHeaders.add(new AbstractMap.SimpleImmutableEntry(r8, r10));
        return;
    L8:
        throw new NullPointerException("Invalid header value.");
    L10:
        throw new NullPointerException("Invalid header name.");
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    @GuardedBy("mUrlRequestAdapterLock")
    public void appTimeout() {
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        Object r8 = this.mUrlRequestAdapterLock;
        monitor-enter(r8);
        long r10 = this.mUrlRequestAdapter;     // Catch: Throwable -> L11
        if (r10 != 0) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        nativeAppTimeout(r10);     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void cancel() {
        Object r8 = this.mUrlRequestAdapterLock;
        monitor-enter(r8);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L12:
        monitor-exit(r8);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mStarted == false) goto L12;
        destroyRequestAdapterLocked(2);     // Catch: Throwable -> L14
        monitor-exit(r8);     // Catch: Throwable -> L14
    }

    public void checkCallingThread() {
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
        Object r8 = this.mUrlRequestAdapterLock;
        monitor-enter(r8);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mWaitingOnRedirect == false) goto L14;
        this.mWaitingOnRedirect = false;     // Catch: Throwable -> L15
        if (isDoneLocked() == false) goto L10;
        monitor-exit(r8);     // Catch: Throwable -> L15
        return;
    L10:
        nativeFollowDeferredRedirect(this.mUrlRequestAdapter);     // Catch: Throwable -> L15
        monitor-exit(r8);     // Catch: Throwable -> L15
        return;
    L14:
        throw new IllegalStateException("No redirect to follow.");     // Catch: Throwable -> L15
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getRequestLog() {
        return this.mRequestLog;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void getStatus(UrlRequest.StatusListener r8) {
        final VersionSafeCallbacks.UrlRequestStatusListener r10 = new VersionSafeCallbacks.UrlRequestStatusListener(r8);
        Object r11 = this.mUrlRequestAdapterLock;
        monitor-enter(r11);
        long r12 = this.mUrlRequestAdapter;     // Catch: Throwable -> L12
        if (r12 == 0) goto L9;
        nativeGetStatus(r12, r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L12
        postTaskToExecutor(new AnonymousClass2(this, r10));
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public long getUrlRequestAdapterForTesting() {
        Object r8 = this.mUrlRequestAdapterLock;
        monitor-enter(r8);
        long r10 = this.mUrlRequestAdapter;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public boolean isDone() {
        Object r8 = this.mUrlRequestAdapterLock;
        monitor-enter(r8);
        boolean r10 = isDoneLocked();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public void onUploadException(Throwable r8) {
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in upload method", new Object[]{r8});
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
        long r11 = this.mUrlRequestAdapter;     // Catch: Throwable -> L11
        if (r11 != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        nativeAbortWhenUploadException(r11);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void read(ByteBuffer r8) {
        Preconditions.checkHasRemaining(r8);
        Preconditions.checkDirect(r8);
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mWaitingOnRead == false) goto L17;
        this.mWaitingOnRead = false;     // Catch: Throwable -> L18
        if (isDoneLocked() == false) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L11:
        if (nativeReadData(this.mUrlRequestAdapter, r8, r8.position(), r8.limit()) == false) goto L14;
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L14:
        this.mWaitingOnRead = true;     // Catch: Throwable -> L18
        throw new IllegalArgumentException("Unable to call native read");     // Catch: Throwable -> L18
    L17:
        throw new IllegalStateException("Unexpected read attempt.");     // Catch: Throwable -> L18
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setHttpMethod(String r8) {
        checkNotStarted();
        if (r8 == null) goto L7;
        this.mInitialMethod = r8;
        return;
    L7:
        throw new NullPointerException("Method is required.");
    }

    @VisibleForTesting
    public void setOnDestroyedCallbackForTesting(Runnable r8) {
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
        this.mOnDestroyedCallbackForTesting = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public void setOnDestroyedUploadCallbackForTesting(Runnable r8) {
        this.mUploadDataStream.setOnDestroyedCallbackForTesting(r8);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestFlag(int r8) {
        this.mRequestFlag = r8;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setRequestTimeout(int r8) {
        this.mRequestTimeout = r8;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketConnectTimeout(int r8) {
        this.mSocketConnectTimeout = r8;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketReadTimeout(int r8) {
        this.mSocketReadTimeout = r8;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketWriteTimeout(int r8) {
        this.mSocketWriteTimeout = r8;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setThrottleNetSpeed(long r8) {
        Object r10 = this.mUrlRequestAdapterLock;
        monitor-enter(r10);
        this.mThrottleNetSpeed = r8;     // Catch: Throwable -> L9
        long r11 = this.mUrlRequestAdapter;     // Catch: Throwable -> L9
        if (r11 == 0) goto L7;
        nativeSetThrottleNetSpeed(r11, r8);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider r8, Executor r10) {
        if (r8 == null) goto L9;
        if (this.mInitialMethod != null) goto L6;
        this.mInitialMethod = HttpMethodContrants.POST;
    L6:
        this.mUploadDataStream = new CronetUploadDataStream(r8, r10, this);
        return;
    L9:
        throw new NullPointerException("Invalid UploadDataProvider.");
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void start() {
        Object r15 = this.mUrlRequestAdapterLock;
        monitor-enter(r15);
        checkNotStarted();     // Catch: Throwable -> L64
        long r8 = this.mRequestContext.getUrlRequestContextAdapter();     // Catch: RuntimeException -> L60 Throwable -> L64
        String r10 = this.mInitialUrl;     // Catch: RuntimeException -> L60 Throwable -> L64
        int r11 = this.mPriority;     // Catch: RuntimeException -> L60 Throwable -> L64
        int r12 = this.mRequestFlag;     // Catch: RuntimeException -> L60 Throwable -> L64
        boolean r13 = this.mDisableCache;     // Catch: RuntimeException -> L60 Throwable -> L64
        boolean r14 = this.mDisableConnectionMigration;     // Catch: RuntimeException -> L60 Throwable -> L64
        if (this.mRequestContext.hasRequestFinishedListener() == false) goto L9;
    L12:
        boolean r16 = true;
    L13:
        this.mUrlRequestAdapter = nativeCreateRequestAdapter(r8, r10, r11, r12, r13, r14, r16, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid);     // Catch: RuntimeException -> L58 Throwable -> L64
        this.mRequestContext.onRequestStarted();     // Catch: RuntimeException -> L58 Throwable -> L64
        String r17 = this.mInitialMethod;     // Catch: RuntimeException -> L58 Throwable -> L64
        if (r17 != null) goto L18;
    L22:
        Iterator<Map.Entry<String, String>> r18 = this.mRequestHeaders.iterator();     // Catch: RuntimeException -> L58 Throwable -> L64
        boolean r19 = false;
    L24:
        if (r18.hasNext() == false) goto L40;
        Map.Entry<String, String> r20 = r18.next();     // Catch: RuntimeException -> L58 Throwable -> L64
        if (r20.getKey().equalsIgnoreCase("Content-Type") == false) goto L31;
        if (r20.getValue().isEmpty() == true) goto L31;
        r19 = true;
    L31:
        if (r20.getKey().equalsIgnoreCase("Tt-Map-Key") == false) goto L36;
        if (r20.getValue().isEmpty() == true) goto L36;
        this.mCronetMapKey = r20.getValue();     // Catch: RuntimeException -> L58 Throwable -> L64
    L36:
        if (nativeAddRequestHeader(this.mUrlRequestAdapter, r20.getKey(), r20.getValue()) == true) goto L24;
        throw new IllegalArgumentException("Invalid header " + r20.getKey() + "=" + r20.getValue());     // Catch: RuntimeException -> L58 Throwable -> L64
    L40:
        nativeSetSocketTimeout(this.mUrlRequestAdapter, this.mSocketConnectTimeout, this.mSocketReadTimeout, this.mSocketWriteTimeout);     // Catch: RuntimeException -> L58 Throwable -> L64
        nativeSetRequestTimeout(this.mUrlRequestAdapter, this.mRequestTimeout);     // Catch: RuntimeException -> L58 Throwable -> L64
        long r21 = this.mThrottleNetSpeed;     // Catch: RuntimeException -> L58 Throwable -> L64
        if (r21 <= 0) goto L43;
        nativeSetThrottleNetSpeed(this.mUrlRequestAdapter, r21);     // Catch: RuntimeException -> L58 Throwable -> L64
    L43:
        CronetUploadDataStream r22 = this.mUploadDataStream;     // Catch: RuntimeException -> L58 Throwable -> L64
        if (r22 == null) goto L55;
        int r23 = 1;
        if (r19 == false) goto L53;
        this.mStarted = true;     // Catch: RuntimeException -> L50 Throwable -> L64
        r22.postTaskToExecutor(new AnonymousClass1(this));     // Catch: RuntimeException -> L50 Throwable -> L64
        monitor-exit(r15);     // Catch: Throwable -> L64
        return;
    L53:
        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");     // Catch: RuntimeException -> L50 Throwable -> L64
    L50:
        e = e;
    L62:
        destroyRequestAdapterLocked(r23);     // Catch: Throwable -> L64
        throw e;     // Catch: Throwable -> L64
    L55:
        this.mStarted = true;     // Catch: Throwable -> L64
        startInternalLocked();     // Catch: Throwable -> L64
        monitor-exit(r15);     // Catch: Throwable -> L64
        return;
    L18:
        if (nativeSetHttpMethod(this.mUrlRequestAdapter, r17) == true) goto L22;
        throw new IllegalArgumentException("Invalid http method " + this.mInitialMethod);     // Catch: RuntimeException -> L58 Throwable -> L64
    L58:
        e = e;
        r23 = 1;
        goto L62
    L9:
        if (this.mRequestFinishedListener != null) goto L12;
        r16 = false;
    L60:
        e = e;
        r23 = 1;
    L64:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    @GuardedBy("mUrlRequestAdapterLock")
    public void stopRedirect() {
        Object r8 = this.mUrlRequestAdapterLock;
        monitor-enter(r8);
        long r10 = this.mUrlRequestAdapter;     // Catch: Throwable -> L11
        if (r10 != 0) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        nativeStopRedirect(r10);     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
