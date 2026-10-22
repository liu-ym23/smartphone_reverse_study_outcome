package com.ttnet.org.chromium.net.impl;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.util.Log;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import defpackage.a;
import defpackage.b;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
final class JavaUrlRequest extends UrlRequestBase {
    private static final int DEFAULT_CHUNK_LENGTH = 8192;
    private static final int DEFAULT_UPLOAD_BUFFER_SIZE = 8192;
    private static final String TAG = "JavaUrlRequest";
    private static final String USER_AGENT = "User-Agent";
    private static final String X_ANDROID = "X-Android";
    private static final String X_ANDROID_SELECTED_TRANSPORT = "X-Android-Selected-Transport";
    private volatile int mAdditionalStatusDetails;
    private final boolean mAllowDirectExecutor;
    private final AsyncUrlRequestCallback mCallbackAsync;
    private String mCurrentUrl;
    private HttpURLConnection mCurrentUrlConnection;
    private final Executor mExecutor;
    private String mInitialMethod;
    private OutputStreamDataSink mOutputStreamDataSink;
    private String mPendingRedirectUrl;
    private final Map<String, String> mRequestHeaders;
    private ReadableByteChannel mResponseChannel;
    private final AtomicReference<Integer> mState;
    private VersionSafeCallbacks.UploadDataProviderWrapper mUploadDataProvider;
    private Executor mUploadExecutor;
    private final AtomicBoolean mUploadProviderClosed;
    private final List<String> mUrlChain;
    private UrlResponseInfoImpl mUrlResponseInfo;
    private final String mUserAgent;

    public final class AsyncUrlRequestCallback {
        final VersionSafeCallbacks.UrlRequestCallback mCallback;
        final Executor mFallbackExecutor;
        final Executor mUserExecutor;
        final /* synthetic */ JavaUrlRequest this$0;

        public AsyncUrlRequestCallback(JavaUrlRequest r8, UrlRequest.Callback r10, Executor r11) {
            this.this$0 = r8;
            this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(r10);
            if (JavaUrlRequest.access$3300(r8) == false) goto L5;
            this.mUserExecutor = r11;
            this.mFallbackExecutor = null;
            return;
        L5:
            this.mUserExecutor = new DirectPreventingExecutor(r11);
            this.mFallbackExecutor = r11;
        }

        public void execute(CheckedRunnable r8) {
            this.mUserExecutor.execute(JavaUrlRequest.access$3400(this.this$0, r8));     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            JavaUrlRequest.access$3500(this.this$0, new CronetExceptionImpl("Exception posting task to executor", e));
        }

        public void onCanceled(final UrlResponseInfo r8) {
            JavaUrlRequest.access$3600(this.this$0);
            this.mUserExecutor.execute(new AnonymousClass5(this, r8));
        }

        public void onFailed(final UrlResponseInfo r8, final CronetException r10) {
            JavaUrlRequest.access$3600(this.this$0);
            Runnable r11 = new AnonymousClass7(this, r8, r10);
            this.mUserExecutor.execute(r11);     // Catch: InlineExecutionProhibitedException -> L5
            return;
        L5:
            Executor r12 = this.mFallbackExecutor;
            if (r12 == null) goto L11;
            r12.execute(r11);
            return;
        }

        public void onReadCompleted(final UrlResponseInfo r8, final ByteBuffer r10) {
            execute(new AnonymousClass4(this, r8, r10));
        }

        public void onRedirectReceived(final UrlResponseInfo r8, final String r10) {
            execute(new AnonymousClass2(this, r8, r10));
        }

        public void onResponseStarted(UrlResponseInfo r8) {
            execute(new AnonymousClass3(this));
        }

        public void onSucceeded(final UrlResponseInfo r8) {
            this.mUserExecutor.execute(new AnonymousClass6(this, r8));
        }

        public void sendStatus(final VersionSafeCallbacks.UrlRequestStatusListener r8, final int r10) {
            this.mUserExecutor.execute(new AnonymousClass1(this, r8, r10));
        }
    }

    public interface CheckedRunnable {
        void run();
    }

    public static final class DirectPreventingExecutor implements Executor {
        private final Executor mDelegate;

        public static final class InlineCheckingRunnable implements Runnable {
            private Thread mCallingThread;
            private final Runnable mCommand;
            private InlineExecutionProhibitedException mExecutedInline;

            private InlineCheckingRunnable(Runnable r8, Thread r10) {
                this.mCommand = r8;
                this.mCallingThread = r10;
            }

            public static /* synthetic */ InlineExecutionProhibitedException access$3800(InlineCheckingRunnable r8) {
                return r8.mExecutedInline;
            }

            public static /* synthetic */ Thread access$3902(InlineCheckingRunnable r8, Thread r10) {
                r8.mCallingThread = r10;
                return r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (Thread.currentThread() != this.mCallingThread) goto L6;
                this.mExecutedInline = new InlineExecutionProhibitedException();
                return;
            L6:
                this.mCommand.run();
            }

            public /* synthetic */ InlineCheckingRunnable(Runnable r8, Thread r10, AnonymousClass1 r11) {
                this(r8, r10);
            }
        }

        public DirectPreventingExecutor(Executor r8) {
            this.mDelegate = r8;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r8) {
            InlineCheckingRunnable r10 = new InlineCheckingRunnable(r8, Thread.currentThread(), null);
            this.mDelegate.execute(r10);
            if (InlineCheckingRunnable.access$3800(r10) != null) goto L7;
            InlineCheckingRunnable.access$3902(r10, null);
            return;
        L7:
            throw InlineCheckingRunnable.access$3800(r10);
        }
    }

    public final class OutputStreamDataSink extends UploadDataSink {
        ByteBuffer mBuffer;
        final Executor mExecutor;
        WritableByteChannel mOutputChannel;
        final AtomicBoolean mOutputChannelClosed;
        final AtomicReference<Integer> mSinkState;
        long mTotalBytes;
        final VersionSafeCallbacks.UploadDataProviderWrapper mUploadProvider;
        final HttpURLConnection mUrlConnection;
        OutputStream mUrlConnectionOutputStream;
        final Executor mUserUploadExecutor;
        long mWrittenBytes;
        final /* synthetic */ JavaUrlRequest this$0;

        public OutputStreamDataSink(final JavaUrlRequest r8, final Executor r10, Executor r11, HttpURLConnection r12, VersionSafeCallbacks.UploadDataProviderWrapper r13) {
            this.this$0 = r8;
            this.mSinkState = new AtomicReference(3);
            this.mOutputChannelClosed = new AtomicBoolean(false);
            this.mUserUploadExecutor = new AnonymousClass1(this, r8, r10);
            this.mExecutor = r11;
            this.mUrlConnection = r12;
            this.mUploadProvider = r13;
        }

        public static /* synthetic */ void access$500(OutputStreamDataSink r8, CheckedRunnable r10) {
            r8.executeOnUploadExecutor(r10);
        }

        private void executeOnUploadExecutor(CheckedRunnable r8) {
            this.mUserUploadExecutor.execute(JavaUrlRequest.access$800(this.this$0, r8));     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            JavaUrlRequest.access$400(this.this$0, e);
        }

        public void closeOutputChannel() {
            if (this.mOutputChannel != null) goto L5;
            return;
        L5:
            if (this.mOutputChannelClosed.compareAndSet(false, true) == false) goto L9;
            this.mOutputChannel.close();
            return;
        }

        public void finish() {
            closeOutputChannel();
            JavaUrlRequest.access$900(this.this$0);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataSink
        public void onReadError(Exception r8) {
            JavaUrlRequest.access$400(this.this$0, r8);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataSink
        @SuppressLint({"DefaultLocale"})
        public void onReadSucceeded(final boolean r8) {
            AtomicReference<Integer> r10 = this.mSinkState;
            boolean r11 = false;
        L4:
            if (r10.compareAndSet(0, 2) == true) goto L5;
            if (r10.get() == 0) goto L4;
        L8:
            if (r11 == false) goto L12;
            this.mExecutor.execute(JavaUrlRequest.access$600(this.this$0, new AnonymousClass2(this, r8)));
            return;
        L12:
            throw new IllegalStateException("Not expecting a read result, expecting: " + this.mSinkState.get());
        L5:
            r11 = true;
            goto L8
        }

        @Override // com.ttnet.org.chromium.net.UploadDataSink
        public void onRewindError(Exception r8) {
            JavaUrlRequest.access$400(this.this$0, r8);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataSink
        public void onRewindSucceeded() {
            AtomicReference<Integer> r8 = this.mSinkState;
            boolean r10 = true;
        L4:
            if (r8.compareAndSet(1, 2) == true) goto L9;
            if (r8.get() == 1) goto L4;
            r10 = false;
        L9:
            if (r10 == false) goto L13;
            startRead();
            return;
        L13:
            throw new IllegalStateException("Not expecting a read result");
        }

        public void start(final boolean r8) {
            executeOnUploadExecutor(new AnonymousClass4(this, r8));
        }

        public void startRead() {
            this.mExecutor.execute(JavaUrlRequest.access$600(this.this$0, new AnonymousClass3(this)));
        }
    }

    public static final class SerializingExecutor implements Executor {
        private final Runnable mRunTasks;

        @GuardedBy("mTaskQueue")
        private boolean mRunning;

        @GuardedBy("mTaskQueue")
        private final ArrayDeque<Runnable> mTaskQueue;
        private final Executor mUnderlyingExecutor;

        public SerializingExecutor(Executor r8) {
            this.mRunTasks = new AnonymousClass1(this);
            this.mTaskQueue = new ArrayDeque();
            this.mUnderlyingExecutor = r8;
        }

        public static /* synthetic */ ArrayDeque access$000(SerializingExecutor r8) {
            return r8.mTaskQueue;
        }

        public static /* synthetic */ boolean access$100(SerializingExecutor r8) {
            return r8.mRunning;
        }

        public static /* synthetic */ boolean access$102(SerializingExecutor r8, boolean r10) {
            r8.mRunning = r10;
            return r10;
        }

        public static /* synthetic */ Runnable access$200(SerializingExecutor r8) {
            return r8.mRunTasks;
        }

        public static /* synthetic */ Executor access$300(SerializingExecutor r8) {
            return r8.mUnderlyingExecutor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r8) {
            ArrayDeque<Runnable> r10 = this.mTaskQueue;
            monitor-enter(r10);
            this.mTaskQueue.addLast(r8);     // Catch: Throwable -> L10
            this.mUnderlyingExecutor.execute(this.mRunTasks);     // Catch: RejectedExecutionException -> L7 Throwable -> L10
        L8:
            monitor-exit(r10);     // Catch: Throwable -> L10
            return;
        L7:
            this.mTaskQueue.removeLast();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SinkState {
        public static final int AWAITING_READ_RESULT = 0;
        public static final int AWAITING_REWIND_RESULT = 1;
        public static final int NOT_STARTED = 3;
        public static final int UPLOADING = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int AWAITING_FOLLOW_REDIRECT = 3;
        public static final int AWAITING_READ = 4;
        public static final int CANCELLED = 8;
        public static final int COMPLETE = 7;
        public static final int ERROR = 6;
        public static final int NOT_STARTED = 0;
        public static final int READING = 5;
        public static final int REDIRECT_RECEIVED = 2;
        public static final int STARTED = 1;
    }

    public JavaUrlRequest(UrlRequest.Callback r11, final Executor r12, Executor r13, String r14, String r15, boolean r16, boolean r17, int r18, final boolean r19, final int r20) {
        this.mRequestHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.mUrlChain = new ArrayList();
        this.mState = new AtomicReference(0);
        this.mUploadProviderClosed = new AtomicBoolean(false);
        this.mAdditionalStatusDetails = -1;
        if (r14 == null) goto L20;
        if (r11 == null) goto L18;
        if (r12 == null) goto L16;
        if (r13 == null) goto L14;
        this.mAllowDirectExecutor = r16;
        this.mCallbackAsync = new AsyncUrlRequestCallback(this, r11, r13);
        if (r17 == false) goto L10;
        final int r8 = r18;
    L11:
        this.mExecutor = new SerializingExecutor(new AnonymousClass1(this, r12, r8, r19, r20));
        this.mCurrentUrl = r14;
        this.mUserAgent = r15;
        return;
    L10:
        r8 = TrafficStats.getThreadStatsTag();
        goto L11
    L14:
        throw new NullPointerException("userExecutor is required");
    L16:
        throw new NullPointerException("Executor is required");
    L18:
        throw new NullPointerException("Listener is required");
    L20:
        throw new NullPointerException("URL is required");
    }

    public static /* synthetic */ String access$1000(JavaUrlRequest r8) {
        return r8.mCurrentUrl;
    }

    public static /* synthetic */ String access$1002(JavaUrlRequest r8, String r10) {
        r8.mCurrentUrl = r10;
        return r10;
    }

    public static /* synthetic */ List access$1100(JavaUrlRequest r8) {
        return r8.mUrlChain;
    }

    public static /* synthetic */ void access$1200(JavaUrlRequest r8) {
        r8.fireOpenConnection();
    }

    public static /* synthetic */ String access$1300(JavaUrlRequest r8) {
        return r8.mPendingRedirectUrl;
    }

    public static /* synthetic */ String access$1302(JavaUrlRequest r8, String r10) {
        r8.mPendingRedirectUrl = r10;
        return r10;
    }

    public static /* synthetic */ HttpURLConnection access$1400(JavaUrlRequest r8) {
        return r8.mCurrentUrlConnection;
    }

    public static /* synthetic */ HttpURLConnection access$1402(JavaUrlRequest r8, HttpURLConnection r10) {
        r8.mCurrentUrlConnection = r10;
        return r10;
    }

    public static /* synthetic */ UrlResponseInfoImpl access$1500(JavaUrlRequest r8) {
        return r8.mUrlResponseInfo;
    }

    public static /* synthetic */ UrlResponseInfoImpl access$1502(JavaUrlRequest r8, UrlResponseInfoImpl r10) {
        r8.mUrlResponseInfo = r10;
        return r10;
    }

    public static /* synthetic */ void access$1600(JavaUrlRequest r8, Map r10) {
        r8.fireRedirectReceived(r10);
    }

    public static /* synthetic */ void access$1700(JavaUrlRequest r8) {
        r8.fireCloseUploadDataProvider();
    }

    public static /* synthetic */ ReadableByteChannel access$1800(JavaUrlRequest r8) {
        return r8.mResponseChannel;
    }

    public static /* synthetic */ ReadableByteChannel access$1802(JavaUrlRequest r8, ReadableByteChannel r10) {
        r8.mResponseChannel = r10;
        return r10;
    }

    public static /* synthetic */ AsyncUrlRequestCallback access$1900(JavaUrlRequest r8) {
        return r8.mCallbackAsync;
    }

    public static /* synthetic */ VersionSafeCallbacks.UploadDataProviderWrapper access$2000(JavaUrlRequest r8) {
        return r8.mUploadDataProvider;
    }

    public static /* synthetic */ void access$2100(JavaUrlRequest r8, int r10, int r11, Runnable r12) {
        r8.transitionStates(r10, r11, r12);
    }

    public static /* synthetic */ AtomicReference access$2200(JavaUrlRequest r8) {
        return r8.mState;
    }

    public static /* synthetic */ Map access$2300(JavaUrlRequest r8) {
        return r8.mRequestHeaders;
    }

    public static /* synthetic */ String access$2400(JavaUrlRequest r8) {
        return r8.mUserAgent;
    }

    public static /* synthetic */ String access$2500(JavaUrlRequest r8) {
        return r8.mInitialMethod;
    }

    public static /* synthetic */ String access$2502(JavaUrlRequest r8, String r10) {
        r8.mInitialMethod = r10;
        return r10;
    }

    public static /* synthetic */ OutputStreamDataSink access$2600(JavaUrlRequest r8) {
        return r8.mOutputStreamDataSink;
    }

    public static /* synthetic */ OutputStreamDataSink access$2602(JavaUrlRequest r8, OutputStreamDataSink r10) {
        r8.mOutputStreamDataSink = r10;
        return r10;
    }

    public static /* synthetic */ Executor access$2700(JavaUrlRequest r8) {
        return r8.mUploadExecutor;
    }

    public static /* synthetic */ Executor access$2800(JavaUrlRequest r8) {
        return r8.mExecutor;
    }

    public static /* synthetic */ void access$2900(JavaUrlRequest r8, Throwable r10) {
        r8.enterCronetErrorState(r10);
    }

    public static /* synthetic */ void access$3000(JavaUrlRequest r8, Throwable r10) {
        r8.enterUserErrorState(r10);
    }

    public static /* synthetic */ void access$3100(JavaUrlRequest r8, int r10, ByteBuffer r11) {
        r8.processReadResult(r10, r11);
    }

    public static /* synthetic */ String access$3200() {
        return TAG;
    }

    public static /* synthetic */ boolean access$3300(JavaUrlRequest r8) {
        return r8.mAllowDirectExecutor;
    }

    public static /* synthetic */ Runnable access$3400(JavaUrlRequest r8, CheckedRunnable r10) {
        return r8.userErrorSetting(r10);
    }

    public static /* synthetic */ void access$3500(JavaUrlRequest r8, CronetException r10) {
        r8.enterErrorState(r10);
    }

    public static /* synthetic */ void access$3600(JavaUrlRequest r8) {
        r8.closeResponseChannel();
    }

    public static /* synthetic */ void access$400(JavaUrlRequest r8, Throwable r10) {
        r8.enterUploadErrorState(r10);
    }

    public static /* synthetic */ Runnable access$600(JavaUrlRequest r8, CheckedRunnable r10) {
        return r8.errorSetting(r10);
    }

    public static /* synthetic */ int access$702(JavaUrlRequest r8, int r10) {
        r8.mAdditionalStatusDetails = r10;
        return r10;
    }

    public static /* synthetic */ Runnable access$800(JavaUrlRequest r8, CheckedRunnable r10) {
        return r8.uploadErrorSetting(r10);
    }

    public static /* synthetic */ void access$900(JavaUrlRequest r8) {
        r8.fireGetHeaders();
    }

    private void checkNotStarted() {
        int r8 = this.mState.get().intValue();
        if (r8 != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException(a.d("Request is already started. State is: ", r8));
    }

    private void closeResponseChannel() {
        this.mExecutor.execute(new AnonymousClass13(this));
    }

    private void enterCronetErrorState(Throwable r8) {
        enterErrorState(new CronetExceptionImpl("System error", r8));
    }

    private void enterErrorState(CronetException r8) {
        if (setTerminalState(6) == false) goto L6;
        fireDisconnect();
        fireCloseUploadDataProvider();
        this.mCallbackAsync.onFailed(this.mUrlResponseInfo, r8);
        return;
    }

    private void enterUploadErrorState(Throwable r8) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UploadDataProvider", r8));
    }

    private void enterUserErrorState(Throwable r8) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UrlRequest.Callback", r8));
    }

    private Runnable errorSetting(final CheckedRunnable r8) {
        return new AnonymousClass8(this, r8);
    }

    private void fireCloseUploadDataProvider() {
        if (this.mUploadDataProvider != null) goto L5;
        return;
    L5:
        if (this.mUploadProviderClosed.compareAndSet(false, true) == false) goto L14;
        this.mUploadExecutor.execute(uploadErrorSetting(new AnonymousClass5(this)));     // Catch: RejectedExecutionException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "Exception when closing uploadDataProvider", e);
        return;
    }

    private void fireDisconnect() {
        this.mExecutor.execute(new AnonymousClass12(this));
    }

    private void fireGetHeaders() {
        this.mAdditionalStatusDetails = 13;
        this.mExecutor.execute(errorSetting(new AnonymousClass4(this)));
    }

    private void fireOpenConnection() {
        this.mExecutor.execute(errorSetting(new AnonymousClass7(this)));
    }

    private void fireRedirectReceived(final Map<String, List<String>> r8) {
        transitionStates(1, 2, new AnonymousClass6(this, r8));
    }

    private boolean isValidHeaderName(String r8) {
        int r10 = 0;
    L4:
        if (r10 >= r8.length()) goto L23;
        char r11 = r8.charAt(r10);
        if (r11 == ',') goto L22;
        if (r11 == '/') goto L22;
        if (r11 == '{') goto L22;
        if (r11 == '}') goto L22;
        switch(r11) {
            case 39: goto L22;
            case 40: goto L22;
            case 41: goto L22;
            default: goto L14;
        };
    L14:
        switch(r11) {
            case 58: goto L22;
            case 59: goto L22;
            case 60: goto L22;
            case 61: goto L22;
            case 62: goto L22;
            case 63: goto L22;
            case 64: goto L22;
            default: goto L15;
        };
    L15:
        switch(r11) {
            case 91: goto L22;
            case 92: goto L22;
            case 93: goto L22;
            default: goto L17;
        };
    L17:
        if (Character.isISOControl(r11) == true) goto L22;
        if (Character.isWhitespace(r11) == true) goto L22;
        r10 = r10 + 1;
    L22:
        return false;
    L23:
        return true;
    }

    private void processReadResult(int r8, ByteBuffer r10) {
        if (r8 == (-1)) goto L5;
        this.mCallbackAsync.onReadCompleted(this.mUrlResponseInfo, r10);
        return;
    L5:
        ReadableByteChannel r11 = this.mResponseChannel;
        if (r11 == null) goto L9;
        r11.close();
    L9:
        if (a.l(this.mState, 5, 7) == false) goto L13;
        fireDisconnect();
        this.mCallbackAsync.onSucceeded(this.mUrlResponseInfo);
        return;
    }

    private boolean setTerminalState(int r8) {
    L2:
        int r10 = this.mState.get().intValue();
        if (r10 == 0) goto L20;
        boolean r11 = false;
        if (r10 == 6) goto L18;
        if (r10 == 7) goto L18;
        if (r10 == 8) goto L18;
        AtomicReference<Integer> r12 = this.mState;
        Integer r13 = Integer.valueOf(r10);
        Integer r14 = Integer.valueOf(r8);
    L12:
        if (r12.compareAndSet(r13, r14) == true) goto L13;
        if (r12.get() == r13) goto L12;
    L16:
        if (r11 == false) goto L2;
        return true;
    L13:
        r11 = true;
    L18:
        return false;
    L20:
        throw new IllegalStateException("Can't enter error state before start");
    }

    private void transitionStates(int r8, int r10, Runnable r11) {
        AtomicReference<Integer> r12 = this.mState;
        Integer r13 = Integer.valueOf(r8);
        Integer r14 = Integer.valueOf(r10);
    L4:
        if (r12.compareAndSet(r13, r14) == true) goto L5;
        if (r12.get() == r13) goto L4;
        boolean r15 = false;
    L9:
        if (r15 == true) goto L17;
        int r16 = this.mState.get().intValue();
        if (r16 != 8) goto L13;
        return;
    L13:
        if (r16 != 6) goto L16;
        return;
    L16:
        throw new IllegalStateException("Invalid state transition - expected " + r8 + " but was " + r16);
    L17:
        r11.run();
        return;
    L5:
        r15 = true;
        goto L9
    }

    private Runnable uploadErrorSetting(final CheckedRunnable r8) {
        return new AnonymousClass10(this, r8);
    }

    private Runnable userErrorSetting(final CheckedRunnable r8) {
        return new AnonymousClass9(this, r8);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void AddRequestCookieHeader(String r8, String r10) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void RemoveRequestCookieHeader() {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void addHeader(String r8, String r10) {
        checkNotStarted();
        if (isValidHeaderName(r8) == false) goto L12;
        if (r10.contains("\r\n") == true) goto L12;
        if (this.mRequestHeaders.containsKey(r8) == false) goto L9;
        this.mRequestHeaders.remove(r8);
    L9:
        this.mRequestHeaders.put(r8, r10);
        return;
    L12:
        throw new IllegalArgumentException(b.e("Invalid header ", r8, "=", r10));
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void cancel() {
        int r8 = this.mState.getAndSet(8).intValue();
        if (r8 != 1) goto L5;
    L13:
        fireDisconnect();
        fireCloseUploadDataProvider();
        this.mCallbackAsync.onCanceled(this.mUrlResponseInfo);
        return;
    L5:
        if (r8 == 2) goto L13;
        if (r8 == 3) goto L13;
        if (r8 == 4) goto L13;
        if (r8 == 5) goto L13;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void followRedirect() {
        transitionStates(3, 1, new AnonymousClass3(this));
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getRequestLog() {
        return "";
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void getStatus(UrlRequest.StatusListener r8) {
        int r10 = this.mState.get().intValue();
        int r11 = this.mAdditionalStatusDetails;
        switch(r10) {
            case 0: goto L8;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            default: goto L5;
        };
    L6:
        r11 = 14;
        goto L9
    L7:
        r11 = 0;
        goto L9
    L8:
        r11 = -1;
    L9:
        this.mCallbackAsync.sendStatus(new VersionSafeCallbacks.UrlRequestStatusListener(r8), r11);
        return;
    L5:
        throw new IllegalStateException(a.d("Switch is exhaustive: ", r10));
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public boolean isDone() {
        int r8 = this.mState.get().intValue();
        if (r8 != 7) goto L5;
    L10:
        return true;
    L5:
        if (r8 == 6) goto L10;
        if (r8 == 8) goto L10;
        return false;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void read(final ByteBuffer r8) {
        Preconditions.checkDirect(r8);
        Preconditions.checkHasRemaining(r8);
        transitionStates(4, 5, new AnonymousClass11(this, r8));
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setHttpMethod(String r8) {
        checkNotStarted();
        if (r8 == null) goto L26;
        if (HttpMethodContrants.OPTIONS.equalsIgnoreCase(r8) == false) goto L7;
    L23:
        this.mInitialMethod = r8;
        return;
    L7:
        if (HttpMethodContrants.GET.equalsIgnoreCase(r8) == true) goto L23;
        if (HttpMethodContrants.HEAD.equalsIgnoreCase(r8) == true) goto L23;
        if (HttpMethodContrants.POST.equalsIgnoreCase(r8) == true) goto L23;
        if (HttpMethodContrants.PUT.equalsIgnoreCase(r8) == true) goto L23;
        if (HttpMethodContrants.DELETE.equalsIgnoreCase(r8) == true) goto L23;
        if ("TRACE".equalsIgnoreCase(r8) == true) goto L23;
        if (HttpMethodContrants.PATCH.equalsIgnoreCase(r8) == true) goto L23;
        throw new IllegalArgumentException("Invalid http method ".concat(r8));
    L26:
        throw new NullPointerException("Method is required.");
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setRequestTimeout(int r8) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketConnectTimeout(int r8) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketReadTimeout(int r8) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketWriteTimeout(int r8) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setThrottleNetSpeed(long r8) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider r8, Executor r10) {
        if (r8 == null) goto L16;
        if (this.mRequestHeaders.containsKey("Content-Type") == false) goto L14;
        checkNotStarted();
        if (this.mInitialMethod != null) goto L8;
        this.mInitialMethod = HttpMethodContrants.POST;
    L8:
        this.mUploadDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(r8);
        if (this.mAllowDirectExecutor == false) goto L11;
        this.mUploadExecutor = r10;
        return;
    L11:
        this.mUploadExecutor = new DirectPreventingExecutor(r10);
        return;
    L14:
        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
    L16:
        throw new NullPointerException("Invalid UploadDataProvider.");
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void start() {
        this.mAdditionalStatusDetails = 10;
        transitionStates(0, 1, new AnonymousClass2(this));
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void stopRedirect() {
    }
}
