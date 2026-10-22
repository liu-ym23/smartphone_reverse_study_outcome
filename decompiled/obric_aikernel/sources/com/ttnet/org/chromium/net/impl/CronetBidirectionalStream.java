package com.ttnet.org.chromium.net.impl;

import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
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

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
@VisibleForTesting
public class CronetBidirectionalStream extends ExperimentalBidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final VersionSafeCallbacks.BidirectionalStreamCallback mCallback;
    private final boolean mDelayRequestHeadersUntilFirstFlush;
    private boolean mEndOfStreamWritten;
    private CronetException mException;
    private final Executor mExecutor;
    private LinkedList<ByteBuffer> mFlushData;
    private final String mInitialMethod;
    private final int mInitialPriority;
    private final String mInitialUrl;
    private RequestFinishedInfo.Metrics mMetrics;
    private long mNativeStream;
    private final Object mNativeStreamLock;
    private final long mNetworkHandle;
    private Runnable mOnDestroyedCallbackForTesting;
    private OnReadCompletedRunnable mOnReadCompletedTask;
    private LinkedList<ByteBuffer> mPendingData;
    private int mReadState;
    private final Collection<Object> mRequestAnnotations;
    private final CronetUrlRequestContext mRequestContext;
    private final String[] mRequestHeaders;
    private boolean mRequestHeadersSent;
    private UrlResponseInfoImpl mResponseInfo;
    private final int mTrafficStatsTag;
    private final boolean mTrafficStatsTagSet;
    private final int mTrafficStatsUid;
    private final boolean mTrafficStatsUidSet;
    private int mWriteState;

    interface Natives {
        long createBidirectionalStream(CronetBidirectionalStream r10, long r11, boolean r12, boolean r13, int r14, boolean r15, int r16, long r17);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        void destroy(long r10, CronetBidirectionalStream r11, boolean r12);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        boolean readData(long r10, CronetBidirectionalStream r11, ByteBuffer r12, int r13, int r14);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        void sendRequestHeaders(long r10, CronetBidirectionalStream r11);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        int start(long r10, CronetBidirectionalStream r11, String r12, int r13, String r14, String[] r15, boolean r16);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        boolean writevData(long r10, CronetBidirectionalStream r11, ByteBuffer[] r12, int[] r13, int[] r14, boolean r15);
    }

    private final class OnReadCompletedRunnable implements Runnable {
        ByteBuffer mByteBuffer;
        boolean mEndOfStream;
        final /* synthetic */ CronetBidirectionalStream this$0;

        private OnReadCompletedRunnable(CronetBidirectionalStream r10) {
            this.this$0 = r10;
        }

        /* synthetic */ OnReadCompletedRunnable(CronetBidirectionalStream r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer r10 = this.mByteBuffer;     // Catch: Exception -> L22
            this.mByteBuffer = null;     // Catch: Exception -> L22
            Object r11 = CronetBidirectionalStream.access$000(this.this$0);     // Catch: Exception -> L22
            monitor-enter(r11);     // Catch: Exception -> L22
        L19:
            th = move-exception;
            throw th;     // Catch: Exception -> L22
        L5:
            if (CronetBidirectionalStream.access$100(this.this$0) == false) goto L8;
            monitor-exit(r11);     // Catch: Throwable -> L19
            return;
        L8:
            boolean r12 = false;
            if (this.mEndOfStream == false) goto L13;
            CronetBidirectionalStream.access$202(this.this$0, 4);     // Catch: Throwable -> L19
            if (CronetBidirectionalStream.access$300(this.this$0) != 10) goto L14;
            r12 = true;
        L14:
            monitor-exit(r11);     // Catch: Throwable -> L19
            VersionSafeCallbacks.BidirectionalStreamCallback r13 = CronetBidirectionalStream.access$500(this.this$0);     // Catch: Exception -> L22
            CronetBidirectionalStream r14 = this.this$0;     // Catch: Exception -> L22
            r13.onReadCompleted(r14, CronetBidirectionalStream.access$400(r14), r10, this.mEndOfStream);     // Catch: Exception -> L22
            if (r12 == false) goto L27;
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
    }

    private final class OnWriteCompletedRunnable implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean mEndOfStream;
        final /* synthetic */ CronetBidirectionalStream this$0;

        OnWriteCompletedRunnable(CronetBidirectionalStream r10, ByteBuffer r11, boolean r12) {
            this.this$0 = r10;
            this.mByteBuffer = r11;
            this.mEndOfStream = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            ByteBuffer r10 = this.mByteBuffer;     // Catch: Exception -> L21
            this.mByteBuffer = null;     // Catch: Exception -> L21
            Object r11 = CronetBidirectionalStream.access$000(this.this$0);     // Catch: Exception -> L21
            monitor-enter(r11);     // Catch: Exception -> L21
        L18:
            th = move-exception;
            throw th;     // Catch: Exception -> L21
        L5:
            if (CronetBidirectionalStream.access$100(this.this$0) == false) goto L8;
            monitor-exit(r11);     // Catch: Throwable -> L18
            return;
        L8:
            boolean r12 = false;
            if (this.mEndOfStream == false) goto L13;
            CronetBidirectionalStream.access$302(this.this$0, 10);     // Catch: Throwable -> L18
            if (CronetBidirectionalStream.access$200(this.this$0) != 4) goto L13;
            r12 = true;
        L13:
            monitor-exit(r11);     // Catch: Throwable -> L18
            VersionSafeCallbacks.BidirectionalStreamCallback r13 = CronetBidirectionalStream.access$500(this.this$0);     // Catch: Exception -> L21
            CronetBidirectionalStream r14 = this.this$0;     // Catch: Exception -> L21
            r13.onWriteCompleted(r14, CronetBidirectionalStream.access$400(r14), r10, this.mEndOfStream);     // Catch: Exception -> L21
            if (r12 == false) goto L26;
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
    private @interface State {
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

    static {
    }

    CronetBidirectionalStream(CronetUrlRequestContext r10, String r11, int r12, BidirectionalStream.Callback r13, Executor r14, String r15, List<Map.Entry<String, String>> r16, boolean r17, Collection<Object> r18, boolean r19, int r110, boolean r111, int r112, long r113) {
        this.mNativeStreamLock = new Object();
        this.mReadState = 0;
        this.mWriteState = 0;
        this.mRequestContext = r10;
        this.mInitialUrl = r11;
        this.mInitialPriority = convertStreamPriority(r12);
        this.mCallback = new VersionSafeCallbacks.BidirectionalStreamCallback(r13);
        this.mExecutor = r14;
        this.mInitialMethod = r15;
        this.mRequestHeaders = stringsFromHeaderList(r16);
        this.mDelayRequestHeadersUntilFirstFlush = r17;
        this.mPendingData = new LinkedList();
        this.mFlushData = new LinkedList();
        this.mRequestAnnotations = r18;
        this.mTrafficStatsTagSet = r19;
        this.mTrafficStatsTag = r110;
        this.mTrafficStatsUidSet = r111;
        this.mTrafficStatsUid = r112;
        this.mNetworkHandle = r113;
    }

    static /* synthetic */ Object access$000(CronetBidirectionalStream r10) {
        return r10.mNativeStreamLock;
    }

    static /* synthetic */ boolean access$100(CronetBidirectionalStream r10) {
        return r10.isDoneLocked();
    }

    static /* synthetic */ String access$1000(CronetBidirectionalStream r10) {
        return r10.mInitialMethod;
    }

    static /* synthetic */ boolean access$1100(String r10) {
        return doesMethodAllowWriteData(r10);
    }

    static /* synthetic */ void access$1200(CronetBidirectionalStream r10, CronetException r11) {
        r10.failWithExceptionOnExecutor(r11);
    }

    static /* synthetic */ int access$200(CronetBidirectionalStream r10) {
        return r10.mReadState;
    }

    static /* synthetic */ int access$202(CronetBidirectionalStream r10, int r11) {
        r10.mReadState = r11;
        return r11;
    }

    static /* synthetic */ int access$300(CronetBidirectionalStream r10) {
        return r10.mWriteState;
    }

    static /* synthetic */ int access$302(CronetBidirectionalStream r10, int r11) {
        r10.mWriteState = r11;
        return r11;
    }

    static /* synthetic */ UrlResponseInfoImpl access$400(CronetBidirectionalStream r10) {
        return r10.mResponseInfo;
    }

    static /* synthetic */ VersionSafeCallbacks.BidirectionalStreamCallback access$500(CronetBidirectionalStream r10) {
        return r10.mCallback;
    }

    static /* synthetic */ void access$600(CronetBidirectionalStream r10) {
        r10.maybeOnSucceededOnExecutor();
    }

    static /* synthetic */ void access$700(CronetBidirectionalStream r10, Exception r11) {
        r10.onCallbackException(r11);
    }

    static /* synthetic */ boolean access$900(CronetBidirectionalStream r10) {
        return r10.mRequestHeadersSent;
    }

    static /* synthetic */ boolean access$902(CronetBidirectionalStream r10, boolean r11) {
        r10.mRequestHeadersSent = r11;
        return r11;
    }

    private static int convertStreamPriority(int r10) {
        if (r10 != 0) goto L5;
        return 1;
    L5:
        if (r10 != 1) goto L7;
        return 2;
    L7:
        if (r10 != 2) goto L9;
        return 3;
    L9:
        if (r10 == 3) goto L15;
        if (r10 != 4) goto L14;
        return 5;
    L14:
        throw new IllegalArgumentException("Invalid stream priority.");
    L15:
        return 4;
    }

    private void destroyNativeStreamLocked(boolean r10) {
        Log.i(CronetUrlRequestContext.LOG_TAG, "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.mNativeStream != 0) goto L5;
        return;
    L5:
        CronetBidirectionalStreamJni.get().destroy(this.mNativeStream, this, r10);
        this.mRequestContext.onRequestDestroyed();
        this.mNativeStream = 0;
        Runnable r11 = this.mOnDestroyedCallbackForTesting;
        if (r11 == null) goto L9;
        r11.run();
        return;
    }

    private static boolean doesMethodAllowWriteData(String r10) {
        if (r10.equals("GET") == false) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals("HEAD") == true) goto L7;
        return true;
    }

    private void failWithException(final CronetException r10) {
        postTaskToExecutor(new AnonymousClass5(this, r10));
    }

    private void failWithExceptionOnExecutor(CronetException r10) {
        this.mException = r10;
        Object r11 = this.mNativeStreamLock;
        monitor-enter(r11);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L15
        return;
    L8:
        this.mWriteState = 6;     // Catch: Throwable -> L15
        this.mReadState = 6;     // Catch: Throwable -> L15
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        this.mCallback.onFailed(this, this.mResponseInfo, r10);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception notifying of failed request", new Object[]{e});
    }

    private static ArrayList<Map.Entry<String, String>> headersListFromStrings(String[] r10) {
        ArrayList<Map.Entry<String, String>> r11 = new ArrayList(r10.length / 2);
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11.add(new AbstractMap.SimpleImmutableEntry(r10[r12], r10[r12 + 1]));
        r12 = r12 + 2;
        goto L4
    L6:
        return r11;
    }

    private boolean isDoneLocked() {
        if (this.mReadState != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mNativeStream != 0) goto L7;
        return true;
    }

    private void maybeOnSucceededOnExecutor() {
        Object r10 = this.mNativeStreamLock;
        monitor-enter(r10);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L9;
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L9:
        if (this.mWriteState == 10) goto L11;
    L20:
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.mReadState != 4) goto L20;
        this.mWriteState = 7;     // Catch: Throwable -> L22
        this.mReadState = 7;     // Catch: Throwable -> L22
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L22
        monitor-exit(r10);     // Catch: Throwable -> L22
        this.mCallback.onSucceeded(this, this.mResponseInfo);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onSucceeded method", new Object[]{e});
    }

    private void onCallbackException(Exception r10) {
        CallbackExceptionImpl r11 = new CallbackExceptionImpl("CalledByNative method has thrown an exception", r10);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", new Object[]{r10});
        failWithExceptionOnExecutor(r11);
    }

    @CalledByNative
    private void onCanceled() {
        postTaskToExecutor(new AnonymousClass4(this));
    }

    @CalledByNative
    private void onError(int r10, int r11, int r12, String r13, long r14) {
        UrlResponseInfoImpl r15 = this.mResponseInfo;
        if (r15 == null) goto L6;
        r15.setReceivedByteCount(r14);
    L6:
        if (r10 != 10) goto L8;
    L11:
        failWithException(new QuicExceptionImpl("Exception in BidirectionalStream: " + r13, r10, r11, r12));
        return;
    L8:
        if (r10 == 3) goto L11;
        failWithException(new BidirectionalStreamNetworkException("Exception in BidirectionalStream: " + r13, r10, r11));
    }

    @CalledByNative
    private void onMetricsCollected(long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, long r76, boolean r78, long r79, long r81, String r83, long r84) {
        Object r10 = this.mNativeStreamLock;
        monitor-enter(r10);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mMetrics != null) goto L17;
        CronetMetrics r11 = new CronetMetrics(r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r79, r81, -1, r83, r84, 0, "", "", 0, 0, -1, false, false);     // Catch: Throwable -> L18
        this.mMetrics = r11;     // Catch: Throwable -> L18
        int r12 = this.mReadState;     // Catch: Throwable -> L18
        if (r12 != 7) goto L10;
        int r13 = 0;
    L13:
        int r57 = r13;
        RequestFinishedInfoImpl r14 = new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, r11, r57, this.mResponseInfo, this.mException);     // Catch: Throwable -> L18
        this.mRequestContext.reportRequestFinished(r14);     // Catch: Throwable -> L18
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L10:
        if (r12 != 5) goto L12;
        r13 = 2;
        goto L13
    L12:
        r13 = 1;
        goto L13
    L17:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L18
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer r10, int r11, int r12, int r13, long r14) {
        this.mResponseInfo.setReceivedByteCount(r14);
        if (r10.position() == r12) goto L5;
    L19:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r10.limit() != r13) goto L19;
        if (r11 < 0) goto L17;
        int r15 = r12 + r11;
        if (r15 > r13) goto L17;
        r10.position(r15);
        OnReadCompletedRunnable r16 = this.mOnReadCompletedTask;
        r16.mByteBuffer = r10;
        if (r11 != 0) goto L14;
        boolean r17 = true;
    L15:
        r16.mEndOfStream = r17;
        postTaskToExecutor(r16);
        return;
    L14:
        r17 = false;
    L17:
        failWithException(new CronetExceptionImpl("Invalid number of bytes read", null));
    }

    @CalledByNative
    private void onResponseHeadersReceived(int r10, String r11, String[] r12, long r13) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(r10, r11, r12, r13);     // Catch: Exception -> L5
        postTaskToExecutor(new AnonymousClass2(this));
        return;
    L5:
        failWithException(new CronetExceptionImpl("Cannot prepare ResponseInfo", null));
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] r10) {
        final UrlResponseInfoImpl.HeaderBlockImpl r11 = new UrlResponseInfoImpl.HeaderBlockImpl(headersListFromStrings(r10));
        postTaskToExecutor(new AnonymousClass3(this, r11));
    }

    @CalledByNative
    private void onStreamReady(final boolean r10) {
        postTaskToExecutor(new AnonymousClass1(this, r10));
    }

    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] r10, int[] r11, int[] r12, boolean r13) {
        Object r14 = this.mNativeStreamLock;
        monitor-enter(r14);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r14);     // Catch: Throwable -> L29
        return;
    L8:
        this.mWriteState = 8;     // Catch: Throwable -> L29
        if (this.mFlushData.isEmpty() == true) goto L11;
        sendFlushDataLocked();     // Catch: Throwable -> L29
    L11:
        monitor-exit(r14);     // Catch: Throwable -> L29
        int r15 = 0;
    L14:
        if (r15 >= r10.length) goto L38;
        ByteBuffer r16 = r10[r15];
        if (r16.position() != r11[r15]) goto L27;
        if (r16.limit() != r12[r15]) goto L27;
        r16.position(r16.limit());
        boolean r17 = true;
        if (r13 == true) goto L23;
    L25:
        r17 = false;
    L26:
        postTaskToExecutor(new OnWriteCompletedRunnable(this, r16, r17));
        r15 = r15 + 1;
        goto L14
    L23:
        if (r15 != (r10.length - 1)) goto L25;
    L27:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during write", null));
        return;
    }

    private void postTaskToExecutor(Runnable r10) {
        this.mExecutor.execute(r10);     // Catch: RejectedExecutionException -> L4
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
        int r10 = this.mFlushData.size();
        ByteBuffer[] r11 = new ByteBuffer[r10];
        int[] r12 = new int[r10];
        int[] r13 = new int[r10];
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L5;
        ByteBuffer r15 = this.mFlushData.poll();
        r11[r14] = r15;
        r12[r14] = r15.position();
        r13[r14] = r15.limit();
        r14 = r14 + 1;
        goto L3
    L5:
        this.mWriteState = 9;
        this.mRequestHeadersSent = true;
        Natives r16 = CronetBidirectionalStreamJni.get();
        long r17 = this.mNativeStream;
        if (this.mEndOfStreamWritten == true) goto L8;
    L10:
        boolean r18 = false;
    L12:
        if (r16.writevData(r17, this, r11, r12, r13, r18) == false) goto L14;
        return;
    L14:
        this.mWriteState = 8;
        throw new IllegalArgumentException("Unable to call native writev.");
    L8:
        if (this.mPendingData.isEmpty() == false) goto L10;
        r18 = true;
        goto L12
    }

    private static String[] stringsFromHeaderList(List<Map.Entry<String, String>> r10) {
        String[] r11 = new String[r10.size() * 2];
        Iterator<Map.Entry<String, String>> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, String> r14 = r12.next();
        int r15 = r13 + 1;
        r11[r13] = r14.getKey();
        r13 = r15 + 1;
        r11[r15] = r14.getValue();
        goto L4
    L6:
        return r11;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void cancel() {
        Object r10 = this.mNativeStreamLock;
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
        if (this.mReadState == 0) goto L12;
        this.mWriteState = 5;     // Catch: Throwable -> L14
        this.mReadState = 5;     // Catch: Throwable -> L14
        destroyNativeStreamLocked(true);     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void flush() {
        Object r10 = this.mNativeStreamLock;
        monitor-enter(r10);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == true) goto L31;
        int r11 = this.mWriteState;     // Catch: Throwable -> L33
        if (r11 == 8) goto L11;
        if (r11 != 9) goto L31;
    L11:
        if (this.mPendingData.isEmpty() == false) goto L22;
        if (this.mFlushData.isEmpty() == false) goto L22;
        if (this.mRequestHeadersSent == true) goto L19;
        this.mRequestHeadersSent = true;     // Catch: Throwable -> L33
        CronetBidirectionalStreamJni.get().sendRequestHeaders(this.mNativeStream, this);     // Catch: Throwable -> L33
        if (doesMethodAllowWriteData(this.mInitialMethod) == true) goto L19;
        this.mWriteState = 10;     // Catch: Throwable -> L33
    L19:
        monitor-exit(r10);     // Catch: Throwable -> L33
        return;
    L22:
        if (this.mPendingData.isEmpty() == true) goto L25;
        this.mFlushData.addAll(this.mPendingData);     // Catch: Throwable -> L33
        this.mPendingData.clear();     // Catch: Throwable -> L33
    L25:
        if (this.mWriteState != 9) goto L28;
        monitor-exit(r10);     // Catch: Throwable -> L33
        return;
    L28:
        sendFlushDataLocked();     // Catch: Throwable -> L33
        monitor-exit(r10);     // Catch: Throwable -> L33
        return;
    L31:
        monitor-exit(r10);     // Catch: Throwable -> L33
    }

    @VisibleForTesting
    public List<ByteBuffer> getFlushDataForTesting() {
        Object r10 = this.mNativeStreamLock;
        monitor-enter(r10);
        LinkedList r11 = new LinkedList();     // Catch: Throwable -> L10
        Iterator<ByteBuffer> r12 = this.mFlushData.iterator();     // Catch: Throwable -> L10
    L6:
        if (r12.hasNext() == false) goto L8;
        r11.add(r12.next().asReadOnlyBuffer());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L10:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public List<ByteBuffer> getPendingDataForTesting() {
        Object r10 = this.mNativeStreamLock;
        monitor-enter(r10);
        LinkedList r11 = new LinkedList();     // Catch: Throwable -> L10
        Iterator<ByteBuffer> r12 = this.mPendingData.iterator();     // Catch: Throwable -> L10
    L6:
        if (r12.hasNext() == false) goto L8;
        r11.add(r12.next().asReadOnlyBuffer());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public boolean isDone() {
        Object r10 = this.mNativeStreamLock;
        monitor-enter(r10);
        boolean r11 = isDoneLocked();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void read(ByteBuffer r11) {
        Object r10 = this.mNativeStreamLock;
        monitor-enter(r10);
        Preconditions.checkHasRemaining(r11);     // Catch: Throwable -> L21
        Preconditions.checkDirect(r11);     // Catch: Throwable -> L21
        if (this.mReadState != 2) goto L20;
        if (isDoneLocked() == false) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L21
        return;
    L11:
        if (this.mOnReadCompletedTask != null) goto L13;
        this.mOnReadCompletedTask = new OnReadCompletedRunnable(this, null);     // Catch: Throwable -> L21
    L13:
        this.mReadState = 3;     // Catch: Throwable -> L21
        if (CronetBidirectionalStreamJni.get().readData(this.mNativeStream, this, r11, r11.position(), r11.limit()) == false) goto L17;
        monitor-exit(r10);     // Catch: Throwable -> L21
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
    public void setOnDestroyedCallbackForTesting(Runnable r10) {
        this.mOnDestroyedCallbackForTesting = r10;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void start() {
        Object r10 = this.mNativeStreamLock;
        monitor-enter(r10);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.mReadState != 0) goto L30;
        Natives r11 = CronetBidirectionalStreamJni.get();     // Catch: RuntimeException -> L26 Throwable -> L31
        long r12 = this.mRequestContext.getUrlRequestContextAdapter();     // Catch: RuntimeException -> L26 Throwable -> L31
        if (this.mDelayRequestHeadersUntilFirstFlush == true) goto L10;
        boolean r13 = true;
    L11:
        this.mNativeStream = r11.createBidirectionalStream(this, r12, r13, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mNetworkHandle);     // Catch: RuntimeException -> L26 Throwable -> L31
        this.mRequestContext.onRequestStarted();     // Catch: RuntimeException -> L26 Throwable -> L31
        Natives r14 = CronetBidirectionalStreamJni.get();     // Catch: RuntimeException -> L26 Throwable -> L31
        long r15 = this.mNativeStream;     // Catch: RuntimeException -> L26 Throwable -> L31
        String r16 = this.mInitialUrl;     // Catch: RuntimeException -> L26 Throwable -> L31
        int r17 = this.mInitialPriority;     // Catch: RuntimeException -> L26 Throwable -> L31
        String r18 = this.mInitialMethod;     // Catch: RuntimeException -> L26 Throwable -> L31
        String[] r19 = this.mRequestHeaders;     // Catch: RuntimeException -> L26 Throwable -> L31
        if (doesMethodAllowWriteData(r18) == true) goto L14;
        boolean r110 = true;
    L15:
        int r20 = r14.start(r15, this, r16, r17, r18, r19, r110);     // Catch: RuntimeException -> L26 Throwable -> L31
        if (r20 == (-1)) goto L25;
        if (r20 > 0) goto L21;
        this.mWriteState = 1;     // Catch: RuntimeException -> L26 Throwable -> L31
        this.mReadState = 1;     // Catch: RuntimeException -> L26 Throwable -> L31
        monitor-exit(r10);     // Catch: Throwable -> L31
        return;
    L21:
        int r21 = r20 - 1;
        throw new IllegalArgumentException("Invalid header " + this.mRequestHeaders[r21] + "=" + this.mRequestHeaders[r21 + 1]);     // Catch: RuntimeException -> L26 Throwable -> L31
    L25:
        throw new IllegalArgumentException("Invalid http method " + this.mInitialMethod);     // Catch: RuntimeException -> L26 Throwable -> L31
    L14:
        r110 = false;
        goto L15
    L10:
        r13 = false;
    L26:
        e = move-exception;
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L31
        throw e;     // Catch: Throwable -> L31
    L30:
        throw new IllegalStateException("Stream is already started.");     // Catch: Throwable -> L31
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void write(ByteBuffer r10, boolean r11) {
        Object r12 = this.mNativeStreamLock;
        monitor-enter(r12);
        Preconditions.checkDirect(r10);     // Catch: Throwable -> L23
        if (r10.hasRemaining() == true) goto L11;
        if (r11 == true) goto L11;
        throw new IllegalArgumentException("Empty buffer before end of stream.");     // Catch: Throwable -> L23
    L11:
        if (this.mEndOfStreamWritten == true) goto L22;
        if (isDoneLocked() == false) goto L16;
        monitor-exit(r12);     // Catch: Throwable -> L23
        return;
    L16:
        this.mPendingData.add(r10);     // Catch: Throwable -> L23
        if (r11 == false) goto L19;
        this.mEndOfStreamWritten = true;     // Catch: Throwable -> L23
    L19:
        monitor-exit(r12);     // Catch: Throwable -> L23
        return;
    L22:
        throw new IllegalArgumentException("Write after writing end of stream.");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }
}
