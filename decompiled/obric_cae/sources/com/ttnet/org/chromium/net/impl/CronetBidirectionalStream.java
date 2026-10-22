package com.ttnet.org.chromium.net.impl;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import defpackage.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@JNINamespace("cronet")
public class CronetBidirectionalStream extends ExperimentalBidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final VersionSafeCallbacks.BidirectionalStreamCallback mCallback;
    private final boolean mDelayRequestHeadersUntilFirstFlush;

    @GuardedBy("mNativeStreamLock")
    private boolean mEndOfStreamWritten;
    private CronetException mException;
    private final Executor mExecutor;

    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> mFlushData;
    private final String mInitialMethod;
    private final int mInitialPriority;
    private final String mInitialUrl;

    @GuardedBy("mNativeStreamLock")
    private RequestFinishedInfo.Metrics mMetrics;

    @GuardedBy("mNativeStreamLock")
    private long mNativeStream;
    private final Object mNativeStreamLock;
    private Runnable mOnDestroyedCallbackForTesting;
    private OnReadCompletedRunnable mOnReadCompletedTask;

    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> mPendingData;

    @GuardedBy("mNativeStreamLock")
    private int mReadState;
    private final Collection<Object> mRequestAnnotations;
    private final CronetUrlRequestContext mRequestContext;
    private final String[] mRequestHeaders;

    @GuardedBy("mNativeStreamLock")
    private boolean mRequestHeadersSent;
    private UrlResponseInfoImpl mResponseInfo;
    private final int mTrafficStatsTag;
    private final boolean mTrafficStatsTagSet;
    private final int mTrafficStatsUid;
    private final boolean mTrafficStatsUidSet;

    @GuardedBy("mNativeStreamLock")
    private int mWriteState;

    public final class OnReadCompletedRunnable implements Runnable {
        ByteBuffer mByteBuffer;
        boolean mEndOfStream;
        final /* synthetic */ CronetBidirectionalStream this$0;

        private OnReadCompletedRunnable(CronetBidirectionalStream r8) {
            this.this$0 = r8;
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer r8 = this.mByteBuffer;     // Catch: Exception -> L22
            this.mByteBuffer = null;     // Catch: Exception -> L22
            Object r10 = CronetBidirectionalStream.access$000(this.this$0);     // Catch: Exception -> L22
            monitor-enter(r10);     // Catch: Exception -> L22
        L19:
            th = move-exception;
            throw th;     // Catch: Exception -> L22
        L5:
            if (CronetBidirectionalStream.access$100(this.this$0) == false) goto L8;
            monitor-exit(r10);     // Catch: Throwable -> L19
            return;
        L8:
            boolean r11 = false;
            if (this.mEndOfStream == false) goto L13;
            CronetBidirectionalStream.access$202(this.this$0, 4);     // Catch: Throwable -> L19
            if (CronetBidirectionalStream.access$300(this.this$0) != 10) goto L14;
            r11 = true;
        L14:
            monitor-exit(r10);     // Catch: Throwable -> L19
            VersionSafeCallbacks.BidirectionalStreamCallback r12 = CronetBidirectionalStream.access$500(this.this$0);     // Catch: Exception -> L22
            CronetBidirectionalStream r13 = this.this$0;     // Catch: Exception -> L22
            r12.onReadCompleted(r13, CronetBidirectionalStream.access$400(r13), r8, this.mEndOfStream);     // Catch: Exception -> L22
            if (r11 == false) goto L27;
            CronetBidirectionalStream.access$600(this.this$0);     // Catch: Exception -> L22
            return;
        L27:
            return;
        L13:
            CronetBidirectionalStream.access$202(this.this$0, 2);     // Catch: Throwable -> L19
        L22:
            e = move-exception;
            CronetBidirectionalStream.access$700(this.this$0, e);
        }

        public /* synthetic */ OnReadCompletedRunnable(CronetBidirectionalStream r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public final class OnWriteCompletedRunnable implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean mEndOfStream;
        final /* synthetic */ CronetBidirectionalStream this$0;

        public OnWriteCompletedRunnable(CronetBidirectionalStream r8, ByteBuffer r10, boolean r11) {
            this.this$0 = r8;
            this.mByteBuffer = r10;
            this.mEndOfStream = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer r8 = this.mByteBuffer;     // Catch: Exception -> L21
            this.mByteBuffer = null;     // Catch: Exception -> L21
            Object r10 = CronetBidirectionalStream.access$000(this.this$0);     // Catch: Exception -> L21
            monitor-enter(r10);     // Catch: Exception -> L21
        L18:
            th = move-exception;
            throw th;     // Catch: Exception -> L21
        L5:
            if (CronetBidirectionalStream.access$100(this.this$0) == false) goto L8;
            monitor-exit(r10);     // Catch: Throwable -> L18
            return;
        L8:
            boolean r11 = false;
            if (this.mEndOfStream == false) goto L13;
            CronetBidirectionalStream.access$302(this.this$0, 10);     // Catch: Throwable -> L18
            if (CronetBidirectionalStream.access$200(this.this$0) != 4) goto L13;
            r11 = true;
        L13:
            monitor-exit(r10);     // Catch: Throwable -> L18
            VersionSafeCallbacks.BidirectionalStreamCallback r12 = CronetBidirectionalStream.access$500(this.this$0);     // Catch: Exception -> L21
            CronetBidirectionalStream r13 = this.this$0;     // Catch: Exception -> L21
            r12.onWriteCompleted(r13, CronetBidirectionalStream.access$400(r13), r8, this.mEndOfStream);     // Catch: Exception -> L21
            if (r11 == false) goto L26;
            CronetBidirectionalStream.access$600(this.this$0);     // Catch: Exception -> L21
            return;
        L26:
            return;
        L21:
            e = move-exception;
            CronetBidirectionalStream.access$700(this.this$0, e);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int CANCELED = 5;
        public static final int ERROR = 6;
        public static final int NOT_STARTED = 0;
        public static final int READING = 3;
        public static final int READING_DONE = 4;
        public static final int STARTED = 1;
        public static final int SUCCESS = 7;
        public static final int WAITING_FOR_FLUSH = 8;
        public static final int WAITING_FOR_READ = 2;
        public static final int WRITING = 9;
        public static final int WRITING_DONE = 10;
    }

    public CronetBidirectionalStream(CronetUrlRequestContext r8, String r10, int r11, BidirectionalStream.Callback r12, Executor r13, String r14, List<Map.Entry<String, String>> r15, boolean r16, Collection<Object> r17, boolean r18, int r19, boolean r110, int r111) {
        this.mNativeStreamLock = new Object();
        this.mReadState = 0;
        this.mWriteState = 0;
        this.mRequestContext = r8;
        this.mInitialUrl = r10;
        this.mInitialPriority = convertStreamPriority(r11);
        this.mCallback = new VersionSafeCallbacks.BidirectionalStreamCallback(r12);
        this.mExecutor = r13;
        this.mInitialMethod = r14;
        this.mRequestHeaders = stringsFromHeaderList(r15);
        this.mDelayRequestHeadersUntilFirstFlush = r16;
        this.mPendingData = new LinkedList();
        this.mFlushData = new LinkedList();
        this.mRequestAnnotations = r17;
        this.mTrafficStatsTagSet = r18;
        this.mTrafficStatsTag = r19;
        this.mTrafficStatsUidSet = r110;
        this.mTrafficStatsUid = r111;
    }

    public static /* synthetic */ Object access$000(CronetBidirectionalStream r8) {
        return r8.mNativeStreamLock;
    }

    public static /* synthetic */ boolean access$100(CronetBidirectionalStream r8) {
        return r8.isDoneLocked();
    }

    public static /* synthetic */ String access$1000(CronetBidirectionalStream r8) {
        return r8.mInitialMethod;
    }

    public static /* synthetic */ boolean access$1100(String r8) {
        return doesMethodAllowWriteData(r8);
    }

    public static /* synthetic */ void access$1200(CronetBidirectionalStream r8, CronetException r10) {
        r8.failWithExceptionOnExecutor(r10);
    }

    public static /* synthetic */ int access$200(CronetBidirectionalStream r8) {
        return r8.mReadState;
    }

    public static /* synthetic */ int access$202(CronetBidirectionalStream r8, int r10) {
        r8.mReadState = r10;
        return r10;
    }

    public static /* synthetic */ int access$300(CronetBidirectionalStream r8) {
        return r8.mWriteState;
    }

    public static /* synthetic */ int access$302(CronetBidirectionalStream r8, int r10) {
        r8.mWriteState = r10;
        return r10;
    }

    public static /* synthetic */ UrlResponseInfoImpl access$400(CronetBidirectionalStream r8) {
        return r8.mResponseInfo;
    }

    public static /* synthetic */ VersionSafeCallbacks.BidirectionalStreamCallback access$500(CronetBidirectionalStream r8) {
        return r8.mCallback;
    }

    public static /* synthetic */ void access$600(CronetBidirectionalStream r8) {
        r8.maybeOnSucceededOnExecutor();
    }

    public static /* synthetic */ void access$700(CronetBidirectionalStream r8, Exception r10) {
        r8.onCallbackException(r10);
    }

    public static /* synthetic */ boolean access$900(CronetBidirectionalStream r8) {
        return r8.mRequestHeadersSent;
    }

    public static /* synthetic */ boolean access$902(CronetBidirectionalStream r8, boolean r10) {
        r8.mRequestHeadersSent = r10;
        return r10;
    }

    private static int convertStreamPriority(int r8) {
        if (r8 != 0) goto L5;
        return 1;
    L5:
        if (r8 != 1) goto L7;
        return 2;
    L7:
        if (r8 != 2) goto L9;
        return 3;
    L9:
        if (r8 == 3) goto L15;
        if (r8 != 4) goto L14;
        return 5;
    L14:
        throw new IllegalArgumentException("Invalid stream priority.");
    L15:
        return 4;
    }

    @GuardedBy("mNativeStreamLock")
    private void destroyNativeStreamLocked(boolean r8) {
        Log.i(CronetUrlRequestContext.LOG_TAG, "destroyNativeStreamLocked " + toString(), new Object[0]);
        long r10 = this.mNativeStream;
        if (r10 != 0) goto L5;
        return;
    L5:
        nativeDestroy(r10, r8);
        this.mRequestContext.onRequestDestroyed();
        this.mNativeStream = 0;
        Runnable r11 = this.mOnDestroyedCallbackForTesting;
        if (r11 == null) goto L9;
        r11.run();
        return;
    }

    private static boolean doesMethodAllowWriteData(String r8) {
        if (r8.equals(HttpMethodContrants.GET) == false) goto L5;
    L7:
        return false;
    L5:
        if (r8.equals(HttpMethodContrants.HEAD) == true) goto L7;
        return true;
    }

    private void failWithException(final CronetException r8) {
        postTaskToExecutor(new AnonymousClass5(this, r8));
    }

    private void failWithExceptionOnExecutor(CronetException r8) {
        this.mException = r8;
        Object r10 = this.mNativeStreamLock;
        monitor-enter(r10);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L8:
        this.mWriteState = 6;     // Catch: Throwable -> L15
        this.mReadState = 6;     // Catch: Throwable -> L15
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L15
        monitor-exit(r10);     // Catch: Throwable -> L15
        this.mCallback.onFailed(this, this.mResponseInfo, r8);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception notifying of failed request", new Object[]{e});
    }

    private static ArrayList<Map.Entry<String, String>> headersListFromStrings(String[] r8) {
        ArrayList<Map.Entry<String, String>> r10 = new ArrayList(r8.length / 2);
        int r11 = 0;
    L4:
        if (r11 >= r8.length) goto L6;
        r10.add(new AbstractMap.SimpleImmutableEntry(r8[r11], r8[r11 + 1]));
        r11 = r11 + 2;
        goto L4
    L6:
        return r10;
    }

    @GuardedBy("mNativeStreamLock")
    private boolean isDoneLocked() {
        if (this.mReadState != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mNativeStream != 0) goto L7;
        return true;
    }

    private void maybeOnSucceededOnExecutor() {
        Object r8 = this.mNativeStreamLock;
        monitor-enter(r8);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L9;
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L9:
        if (this.mWriteState == 10) goto L11;
    L20:
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.mReadState != 4) goto L20;
        this.mWriteState = 7;     // Catch: Throwable -> L22
        this.mReadState = 7;     // Catch: Throwable -> L22
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L22
        monitor-exit(r8);     // Catch: Throwable -> L22
        this.mCallback.onSucceeded(this, this.mResponseInfo);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onSucceeded method", new Object[]{e});
    }

    private native long nativeCreateBidirectionalStream(long r8, boolean r10, boolean r11, boolean r12, int r13, boolean r14, int r15);

    @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
    private native void nativeDestroy(long r8, boolean r10);

    @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
    private native boolean nativeReadData(long r8, ByteBuffer r10, int r11, int r12);

    @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
    private native void nativeSendRequestHeaders(long r8);

    @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
    private native int nativeStart(long r8, String r10, int r11, String r12, String[] r13, boolean r14);

    @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
    private native boolean nativeWritevData(long r8, ByteBuffer[] r10, int[] r11, int[] r12, boolean r13);

    private void onCallbackException(Exception r8) {
        CallbackExceptionImpl r10 = new CallbackExceptionImpl("CalledByNative method has thrown an exception", r8);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", new Object[]{r8});
        failWithExceptionOnExecutor(r10);
    }

    @CalledByNative
    private void onCanceled() {
        postTaskToExecutor(new AnonymousClass4(this));
    }

    @CalledByNative
    private void onError(int r8, int r10, int r11, String r12, long r13) {
        UrlResponseInfoImpl r14 = this.mResponseInfo;
        if (r14 == null) goto L6;
        r14.setReceivedByteCount(r13);
    L6:
        if (r8 != 10) goto L8;
    L11:
        failWithException(new QuicExceptionImpl(b.c("Exception in BidirectionalStream: ", r12), r8, r10, r11));
        return;
    L8:
        if (r8 == 3) goto L11;
        failWithException(new BidirectionalStreamNetworkException(b.c("Exception in BidirectionalStream: ", r12), r8, r10));
    }

    @CalledByNative
    private void onMetricsCollected(long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, long r65, long r67, long r69, boolean r71, long r72, long r74, String r76, long r77) {
        Object r8 = this.mNativeStreamLock;
        monitor-enter(r8);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mMetrics != null) goto L17;
        CronetMetrics r10 = new CronetMetrics(r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r67, r69, r71, r72, r74, -1, r76, r77, 0, "", "");     // Catch: Throwable -> L18
        this.mMetrics = r10;     // Catch: Throwable -> L18
        int r11 = this.mReadState;     // Catch: Throwable -> L18
        if (r11 != 7) goto L10;
        int r12 = 0;
    L13:
        int r410 = r12;
        RequestFinishedInfoImpl r13 = new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, r10, r410, this.mResponseInfo, this.mException);     // Catch: Throwable -> L18
        this.mRequestContext.reportRequestFinished(r13);     // Catch: Throwable -> L18
        monitor-exit(r8);     // Catch: Throwable -> L18
        return;
    L10:
        if (r11 != 5) goto L12;
        r12 = 2;
        goto L13
    L12:
        r12 = 1;
        goto L13
    L17:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L18
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer r8, int r10, int r11, int r12, long r13) {
        this.mResponseInfo.setReceivedByteCount(r13);
        if (r8.position() == r11) goto L5;
    L19:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r8.limit() != r12) goto L19;
        if (r10 < 0) goto L17;
        int r14 = r11 + r10;
        if (r14 > r12) goto L17;
        r8.position(r14);
        OnReadCompletedRunnable r15 = this.mOnReadCompletedTask;
        r15.mByteBuffer = r8;
        if (r10 != 0) goto L14;
        boolean r16 = true;
    L15:
        r15.mEndOfStream = r16;
        postTaskToExecutor(r15);
        return;
    L14:
        r16 = false;
    L17:
        failWithException(new CronetExceptionImpl("Invalid number of bytes read", null));
    }

    @CalledByNative
    private void onResponseHeadersReceived(int r8, String r10, String[] r11, long r12) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(r8, r10, r11, r12);     // Catch: Exception -> L5
        postTaskToExecutor(new AnonymousClass2(this));
        return;
    L5:
        failWithException(new CronetExceptionImpl("Cannot prepare ResponseInfo", null));
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] r8) {
        final UrlResponseInfoImpl.HeaderBlockImpl r10 = new UrlResponseInfoImpl.HeaderBlockImpl(headersListFromStrings(r8));
        postTaskToExecutor(new AnonymousClass3(this, r10));
    }

    @CalledByNative
    private void onStreamReady(final boolean r8) {
        postTaskToExecutor(new AnonymousClass1(this, r8));
    }

    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] r8, int[] r10, int[] r11, boolean r12) {
        Object r13 = this.mNativeStreamLock;
        monitor-enter(r13);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r13);     // Catch: Throwable -> L29
        return;
    L8:
        this.mWriteState = 8;     // Catch: Throwable -> L29
        if (this.mFlushData.isEmpty() == true) goto L11;
        sendFlushDataLocked();     // Catch: Throwable -> L29
    L11:
        monitor-exit(r13);     // Catch: Throwable -> L29
        int r14 = 0;
    L14:
        if (r14 >= r8.length) goto L38;
        ByteBuffer r15 = r8[r14];
        if (r15.position() != r10[r14]) goto L27;
        if (r15.limit() != r11[r14]) goto L27;
        r15.position(r15.limit());
        if (r12 == false) goto L25;
        boolean r16 = true;
        if (r14 != (r8.length - 1)) goto L25;
    L26:
        postTaskToExecutor(new OnWriteCompletedRunnable(this, r15, r16));
        r14 = r14 + 1;
    L25:
        r16 = false;
    L27:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during write", null));
        return;
    }

    private void postTaskToExecutor(Runnable r8) {
        this.mExecutor.execute(r8);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        monitor-enter(this.mNativeStreamLock);
        this.mWriteState = 6;     // Catch: Throwable -> L11
        this.mReadState = 6;     // Catch: Throwable -> L11
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int r12, String r13, String[] r14, long r15) {
        return new UrlResponseInfoImpl(Arrays.asList(new String[]{this.mInitialUrl}), r12, "", headersListFromStrings(r14), false, r13, null, r15);
    }

    private void sendFlushDataLocked() {
        int r8 = this.mFlushData.size();
        ByteBuffer[] r10 = new ByteBuffer[r8];
        int[] r11 = new int[r8];
        int[] r12 = new int[r8];
        int r13 = 0;
    L3:
        if (r13 >= r8) goto L5;
        ByteBuffer r14 = this.mFlushData.poll();
        r10[r13] = r14;
        r11[r13] = r14.position();
        r12[r13] = r14.limit();
        r13 = r13 + 1;
        goto L3
    L5:
        this.mWriteState = 9;
        this.mRequestHeadersSent = true;
        long r15 = this.mNativeStream;
        if (this.mEndOfStreamWritten == true) goto L8;
    L10:
        boolean r16 = false;
    L12:
        if (nativeWritevData(r15, r10, r11, r12, r16) == false) goto L14;
        return;
    L14:
        this.mWriteState = 8;
        throw new IllegalArgumentException("Unable to call native writev.");
    L8:
        if (this.mPendingData.isEmpty() == false) goto L10;
        r16 = true;
        goto L12
    }

    private static String[] stringsFromHeaderList(List<Map.Entry<String, String>> r8) {
        String[] r10 = new String[r8.size() * 2];
        Iterator<Map.Entry<String, String>> r11 = r8.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<String, String> r13 = r11.next();
        int r14 = r12 + 1;
        r10[r12] = r13.getKey();
        r12 = r14 + 1;
        r10[r14] = r13.getValue();
        goto L4
    L6:
        return r10;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void cancel() {
        Object r8 = this.mNativeStreamLock;
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
        if (this.mReadState == 0) goto L12;
        this.mWriteState = 5;     // Catch: Throwable -> L14
        this.mReadState = 5;     // Catch: Throwable -> L14
        destroyNativeStreamLocked(true);     // Catch: Throwable -> L14
        monitor-exit(r8);     // Catch: Throwable -> L14
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void flush() {
        Object r8 = this.mNativeStreamLock;
        monitor-enter(r8);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == true) goto L31;
        int r10 = this.mWriteState;     // Catch: Throwable -> L33
        if (r10 == 8) goto L11;
        if (r10 != 9) goto L31;
    L11:
        if (this.mPendingData.isEmpty() == false) goto L22;
        if (this.mFlushData.isEmpty() == false) goto L22;
        if (this.mRequestHeadersSent == true) goto L19;
        this.mRequestHeadersSent = true;     // Catch: Throwable -> L33
        nativeSendRequestHeaders(this.mNativeStream);     // Catch: Throwable -> L33
        if (doesMethodAllowWriteData(this.mInitialMethod) == true) goto L19;
        this.mWriteState = 10;     // Catch: Throwable -> L33
    L19:
        monitor-exit(r8);     // Catch: Throwable -> L33
        return;
    L22:
        if (this.mPendingData.isEmpty() == true) goto L25;
        this.mFlushData.addAll(this.mPendingData);     // Catch: Throwable -> L33
        this.mPendingData.clear();     // Catch: Throwable -> L33
    L25:
        if (this.mWriteState != 9) goto L28;
        monitor-exit(r8);     // Catch: Throwable -> L33
        return;
    L28:
        sendFlushDataLocked();     // Catch: Throwable -> L33
        monitor-exit(r8);     // Catch: Throwable -> L33
        return;
    L31:
        monitor-exit(r8);     // Catch: Throwable -> L33
    }

    @VisibleForTesting
    public List<ByteBuffer> getFlushDataForTesting() {
        Object r8 = this.mNativeStreamLock;
        monitor-enter(r8);
        LinkedList r10 = new LinkedList();     // Catch: Throwable -> L10
        Iterator<ByteBuffer> r11 = this.mFlushData.iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.add(r11.next().asReadOnlyBuffer());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
        return r10;
    L10:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public List<ByteBuffer> getPendingDataForTesting() {
        Object r8 = this.mNativeStreamLock;
        monitor-enter(r8);
        LinkedList r10 = new LinkedList();     // Catch: Throwable -> L10
        Iterator<ByteBuffer> r11 = this.mPendingData.iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.add(r11.next().asReadOnlyBuffer());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
        return r10;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public boolean isDone() {
        Object r8 = this.mNativeStreamLock;
        monitor-enter(r8);
        boolean r10 = isDoneLocked();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void read(ByteBuffer r10) {
        Object r8 = this.mNativeStreamLock;
        monitor-enter(r8);
        Preconditions.checkHasRemaining(r10);     // Catch: Throwable -> L21
        Preconditions.checkDirect(r10);     // Catch: Throwable -> L21
        if (this.mReadState != 2) goto L20;
        if (isDoneLocked() == false) goto L11;
        monitor-exit(r8);     // Catch: Throwable -> L21
        return;
    L11:
        if (this.mOnReadCompletedTask != null) goto L13;
        this.mOnReadCompletedTask = new OnReadCompletedRunnable(this, null);     // Catch: Throwable -> L21
    L13:
        this.mReadState = 3;     // Catch: Throwable -> L21
        if (nativeReadData(this.mNativeStream, r10, r10.position(), r10.limit()) == false) goto L17;
        monitor-exit(r8);     // Catch: Throwable -> L21
        return;
    L17:
        this.mReadState = 2;     // Catch: Throwable -> L21
        throw new IllegalArgumentException("Unable to call native read");     // Catch: Throwable -> L21
    L20:
        throw new IllegalStateException("Unexpected read attempt.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public void setOnDestroyedCallbackForTesting(Runnable r8) {
        this.mOnDestroyedCallbackForTesting = r8;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void start() {
        Object r8 = this.mNativeStreamLock;
        monitor-enter(r8);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.mReadState != 0) goto L30;
        long r10 = this.mRequestContext.getUrlRequestContextAdapter();     // Catch: RuntimeException -> L26 Throwable -> L31
        if (this.mDelayRequestHeadersUntilFirstFlush == true) goto L10;
        boolean r11 = true;
    L11:
        this.mNativeStream = nativeCreateBidirectionalStream(r10, r11, this.mRequestContext.hasRequestFinishedListener(), this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid);     // Catch: RuntimeException -> L26 Throwable -> L31
        this.mRequestContext.onRequestStarted();     // Catch: RuntimeException -> L26 Throwable -> L31
        long r12 = this.mNativeStream;     // Catch: RuntimeException -> L26 Throwable -> L31
        String r13 = this.mInitialUrl;     // Catch: RuntimeException -> L26 Throwable -> L31
        int r14 = this.mInitialPriority;     // Catch: RuntimeException -> L26 Throwable -> L31
        String r15 = this.mInitialMethod;     // Catch: RuntimeException -> L26 Throwable -> L31
        String[] r16 = this.mRequestHeaders;     // Catch: RuntimeException -> L26 Throwable -> L31
        if (doesMethodAllowWriteData(r15) == true) goto L14;
        boolean r17 = true;
    L15:
        int r18 = nativeStart(r12, r13, r14, r15, r16, r17);     // Catch: RuntimeException -> L26 Throwable -> L31
        if (r18 == (-1)) goto L25;
        if (r18 > 0) goto L21;
        this.mWriteState = 1;     // Catch: RuntimeException -> L26 Throwable -> L31
        this.mReadState = 1;     // Catch: RuntimeException -> L26 Throwable -> L31
        monitor-exit(r8);     // Catch: Throwable -> L31
        return;
    L21:
        int r19 = r18 - 1;
        throw new IllegalArgumentException("Invalid header " + this.mRequestHeaders[r19] + "=" + this.mRequestHeaders[r19 + 1]);     // Catch: RuntimeException -> L26 Throwable -> L31
    L25:
        throw new IllegalArgumentException("Invalid http method " + this.mInitialMethod);     // Catch: RuntimeException -> L26 Throwable -> L31
    L14:
        r17 = false;
        goto L15
    L10:
        r11 = false;
    L26:
        e = move-exception;
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L31
        throw e;     // Catch: Throwable -> L31
    L30:
        throw new IllegalStateException("Stream is already started.");     // Catch: Throwable -> L31
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void write(ByteBuffer r8, boolean r10) {
        Object r11 = this.mNativeStreamLock;
        monitor-enter(r11);
        Preconditions.checkDirect(r8);     // Catch: Throwable -> L23
        if (r8.hasRemaining() == true) goto L11;
        if (r10 == true) goto L11;
        throw new IllegalArgumentException("Empty buffer before end of stream.");     // Catch: Throwable -> L23
    L11:
        if (this.mEndOfStreamWritten == true) goto L22;
        if (isDoneLocked() == false) goto L16;
        monitor-exit(r11);     // Catch: Throwable -> L23
        return;
    L16:
        this.mPendingData.add(r8);     // Catch: Throwable -> L23
        if (r10 == false) goto L19;
        this.mEndOfStreamWritten = true;     // Catch: Throwable -> L23
    L19:
        monitor-exit(r11);     // Catch: Throwable -> L23
        return;
    L22:
        throw new IllegalArgumentException("Write after writing end of stream.");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }
}
