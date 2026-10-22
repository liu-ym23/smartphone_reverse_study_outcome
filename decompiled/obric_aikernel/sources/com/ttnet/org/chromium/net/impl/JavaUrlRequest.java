package com.ttnet.org.chromium.net.impl;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.UrlResponseInfo;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.time.Duration;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
final class JavaUrlRequest extends UrlRequestBase {
    private static final int DEFAULT_CHUNK_LENGTH = 8192;
    private static final String TAG = "JavaUrlRequest";
    private static final String USER_AGENT = "User-Agent";
    private static final String X_ANDROID = "X-Android";
    private static final String X_ANDROID_SELECTED_TRANSPORT = "X-Android-Selected-Transport";
    private volatile int mAdditionalStatusDetails;
    private final boolean mAllowDirectExecutor;
    private final AsyncUrlRequestCallback mCallbackAsync;
    private final int mCronetEngineId;
    private String mCurrentUrl;
    private HttpURLConnection mCurrentUrlConnection;
    private final Executor mExecutor;
    private String mInitialMethod;
    private final CronetLogger mLogger;
    private OutputStreamDataSink mOutputStreamDataSink;
    private String mPendingRedirectUrl;
    private final Map<String, String> mRequestHeaders;

    @Nullable
    private ReadableByteChannel mResponseChannel;
    private final AtomicInteger mState;
    private VersionSafeCallbacks.UploadDataProviderWrapper mUploadDataProvider;
    private Executor mUploadExecutor;
    private final AtomicBoolean mUploadProviderClosed;
    private final List<String> mUrlChain;
    private UrlResponseInfoImpl mUrlResponseInfo;
    private final String mUserAgent;

    private final class AsyncUrlRequestCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final VersionSafeCallbacks.UrlRequestCallback mCallback;
        final Executor mFallbackExecutor;
        final Executor mUserExecutor;
        final /* synthetic */ JavaUrlRequest this$0;

        static {
        }

        AsyncUrlRequestCallback(JavaUrlRequest r10, UrlRequest.Callback r11, Executor r12) {
            this.this$0 = r10;
            this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(r11);
            if (JavaUrlRequest.access$3200(r10) == false) goto L5;
            this.mUserExecutor = r12;
            this.mFallbackExecutor = null;
            return;
        L5:
            this.mUserExecutor = new JavaUrlRequestUtils.DirectPreventingExecutor(r12);
            this.mFallbackExecutor = r12;
        }

        static /* synthetic */ void access$3900(AsyncUrlRequestCallback r10) {
            r10.maybeReportMetrics();
        }

        @RequiresApi(26)
        private CronetLogger.CronetTrafficInfo buildCronetTrafficInfo() {
            if (JavaUrlRequest.access$1400(this.this$0) == null) goto L5;
            Map<String, List<String>> r10 = JavaUrlRequest.access$1400(this.this$0).getAllHeaders();
            String r11 = JavaUrlRequest.access$1400(this.this$0).getNegotiatedProtocol();
            int r12 = JavaUrlRequest.access$1400(this.this$0).getHttpStatusCode();
            boolean r13 = JavaUrlRequest.access$1400(this.this$0).wasCached();
            String r15 = r11;
            int r14 = r12;
        L7:
            if (r13 == false) goto L9;
            long r16 = 0;
            long r17 = 0;
        L10:
            if (r13 == false) goto L12;
            long r18 = 0;
            long r19 = 0;
        L17:
            return new CronetLogger.CronetTrafficInfo(r16, r17, r19, r18, r14, Duration.ofSeconds(0), Duration.ofSeconds(0), r15, false, false);
        L12:
            r19 = JavaUrlRequest.estimateHeadersSizeInBytesList(r10);
            if (r10.containsKey("Content-Length") == false) goto L15;
            r18 = JavaUrlRequest.access$3500(r10.get("Content-Length").get(0));
            goto L17
        L15:
            r18 = -1;
            goto L17
        L9:
            r16 = JavaUrlRequest.estimateHeadersSizeInBytes(JavaUrlRequest.access$2200(this.this$0));
            r17 = -1;
            goto L10
        L5:
            r10 = Collections.emptyMap();
            r13 = false;
            r14 = 0;
            r15 = "";
            goto L7
        }

        private void maybeReportMetrics() {
            if (Build.VERSION.SDK_INT < 26) goto L11;
            JavaUrlRequest.access$3700(this.this$0).logCronetTrafficInfo(JavaUrlRequest.access$3600(this.this$0), buildCronetTrafficInfo());     // Catch: RuntimeException -> L6
            return;
        L6:
            e = move-exception;
            Log.e(JavaUrlRequest.access$3100(), "Error while trying to log CronetTrafficInfo: ", e);
            return;
        }

        void execute(JavaUrlRequestUtils.CheckedRunnable r10) {
            this.mUserExecutor.execute(JavaUrlRequest.access$3300(this.this$0, r10));     // Catch: RejectedExecutionException -> L4
            return;
        L4:
            e = move-exception;
            JavaUrlRequest.access$3400(this.this$0, new CronetExceptionImpl("Exception posting task to executor", e));
        }

        void onCanceled(final UrlResponseInfo r10) {
            JavaUrlRequest.access$3800(this.this$0);
            this.mUserExecutor.execute(new AnonymousClass5(this, r10));
        }

        void onFailed(final UrlResponseInfo r10, final CronetException r11) {
            JavaUrlRequest.access$3800(this.this$0);
            Runnable r12 = new AnonymousClass7(this, r10, r11);
            this.mUserExecutor.execute(r12);     // Catch: InlineExecutionProhibitedException -> L5
            return;
        L5:
            Executor r13 = this.mFallbackExecutor;
            if (r13 == null) goto L11;
            r13.execute(r12);
            return;
        }

        void onReadCompleted(final UrlResponseInfo r10, final ByteBuffer r11) {
            execute(new AnonymousClass4(this, r10, r11));
        }

        void onRedirectReceived(final UrlResponseInfo r10, final String r11) {
            execute(new AnonymousClass2(this, r10, r11));
        }

        void onResponseStarted(UrlResponseInfo r10) {
            execute(new AnonymousClass3(this));
        }

        void onSucceeded(final UrlResponseInfo r10) {
            this.mUserExecutor.execute(new AnonymousClass6(this, r10));
        }

        void sendStatus(final VersionSafeCallbacks.UrlRequestStatusListener r10, final int r11) {
            this.mUserExecutor.execute(new AnonymousClass1(this, r10, r11));
        }
    }

    private final class OutputStreamDataSink extends JavaUploadDataSinkBase {
        private WritableByteChannel mOutputChannel;
        private final AtomicBoolean mOutputChannelClosed;
        private final HttpURLConnection mUrlConnection;
        private OutputStream mUrlConnectionOutputStream;
        final /* synthetic */ JavaUrlRequest this$0;

        OutputStreamDataSink(JavaUrlRequest r10, Executor r11, Executor r12, HttpURLConnection r13, VersionSafeCallbacks.UploadDataProviderWrapper r14) {
            this.this$0 = r10;
            super(r11, r12, r14);
            this.mOutputChannelClosed = new AtomicBoolean(false);
            this.mUrlConnection = r13;
        }

        void closeOutputChannel() {
            if (this.mOutputChannel != null) goto L5;
            return;
        L5:
            if (this.mOutputChannelClosed.compareAndSet(false, true) == false) goto L9;
            this.mOutputChannel.close();
            return;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void finish() {
            closeOutputChannel();
            JavaUrlRequest.access$500(this.this$0);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected Runnable getErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable r10) {
            return JavaUrlRequest.access$600(this.this$0, r10);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected Runnable getUploadErrorSettingRunnable(JavaUrlRequestUtils.CheckedRunnable r10) {
            return JavaUrlRequest.access$700(this.this$0, r10);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void initializeRead() {
            if (this.mOutputChannel != null) goto L6;
            JavaUrlRequest.access$402(this.this$0, 10);
            this.mUrlConnection.setDoOutput(true);
            this.mUrlConnection.connect();
            JavaUrlRequest.access$402(this.this$0, 12);
            OutputStream r10 = this.mUrlConnection.getOutputStream();
            this.mUrlConnectionOutputStream = r10;
            this.mOutputChannel = Channels.newChannel(r10);
            return;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void initializeStart(long r10) {
            HttpURLConnection r11 = this.mUrlConnection;
            if (r10 <= 0) goto L5;
            r11.setFixedLengthStreamingMode(r10);
            return;
        L5:
            r11.setChunkedStreamingMode(8192);
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected int processSuccessfulRead(ByteBuffer r10) {
            int r11 = 0;
        L4:
            if (r10.hasRemaining() == false) goto L6;
            r11 = r11 + this.mOutputChannel.write(r10);
            goto L4
        L6:
            this.mUrlConnectionOutputStream.flush();
            return r11;
        }

        @Override // com.ttnet.org.chromium.net.impl.JavaUploadDataSinkBase
        protected void processUploadError(Throwable r10) {
            JavaUrlRequest.access$800(this.this$0, r10);
        }
    }

    private static final class SerializingExecutor implements Executor {
        private final Runnable mRunTasks;
        private boolean mRunning;
        private final ArrayDeque<Runnable> mTaskQueue;
        private final Executor mUnderlyingExecutor;

        SerializingExecutor(Executor r10) {
            this.mRunTasks = new AnonymousClass1(this);
            this.mTaskQueue = new ArrayDeque();
            this.mUnderlyingExecutor = r10;
        }

        static /* synthetic */ ArrayDeque access$000(SerializingExecutor r10) {
            return r10.mTaskQueue;
        }

        static /* synthetic */ boolean access$100(SerializingExecutor r10) {
            return r10.mRunning;
        }

        static /* synthetic */ boolean access$102(SerializingExecutor r10, boolean r11) {
            r10.mRunning = r11;
            return r11;
        }

        static /* synthetic */ Runnable access$200(SerializingExecutor r10) {
            return r10.mRunTasks;
        }

        static /* synthetic */ Executor access$300(SerializingExecutor r10) {
            return r10.mUnderlyingExecutor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r10) {
            ArrayDeque<Runnable> r11 = this.mTaskQueue;
            monitor-enter(r11);
            this.mTaskQueue.addLast(r10);     // Catch: Throwable -> L10
            this.mUnderlyingExecutor.execute(this.mRunTasks);     // Catch: RejectedExecutionException -> L7 Throwable -> L10
        L8:
            monitor-exit(r11);     // Catch: Throwable -> L10
            return;
        L7:
            this.mTaskQueue.removeLast();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    JavaUrlRequest(JavaCronetEngine r11, UrlRequest.Callback r12, final Executor r13, Executor r14, String r15, String r16, boolean r17, boolean r18, int r19, final boolean r20, final int r21) {
        this.mRequestHeaders = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        this.mUrlChain = new ArrayList();
        this.mState = new AtomicInteger(0);
        this.mUploadProviderClosed = new AtomicBoolean(false);
        this.mAdditionalStatusDetails = -1;
        Objects.requireNonNull(r15, "URL is required");
        Objects.requireNonNull(r12, "Listener is required");
        Objects.requireNonNull(r13, "Executor is required");
        Objects.requireNonNull(r14, "userExecutor is required");
        this.mAllowDirectExecutor = r17;
        this.mCallbackAsync = new AsyncUrlRequestCallback(this, r12, r14);
        if (r18 == false) goto L5;
        int r10 = r19;
    L6:
        final int r22 = r10;
        this.mExecutor = new SerializingExecutor(new AnonymousClass1(this, r13, r22, r20, r21));
        this.mCronetEngineId = r11.getCronetEngineId();
        this.mLogger = r11.getCronetLogger();
        this.mCurrentUrl = r15;
        this.mUserAgent = r16;
        return;
    L5:
        r10 = TrafficStats.getThreadStatsTag();
        goto L6
    }

    static /* synthetic */ List access$1000(JavaUrlRequest r10) {
        return r10.mUrlChain;
    }

    static /* synthetic */ void access$1100(JavaUrlRequest r10) {
        r10.fireOpenConnection();
    }

    static /* synthetic */ String access$1200(JavaUrlRequest r10) {
        return r10.mPendingRedirectUrl;
    }

    static /* synthetic */ String access$1202(JavaUrlRequest r10, String r11) {
        r10.mPendingRedirectUrl = r11;
        return r11;
    }

    static /* synthetic */ HttpURLConnection access$1300(JavaUrlRequest r10) {
        return r10.mCurrentUrlConnection;
    }

    static /* synthetic */ HttpURLConnection access$1302(JavaUrlRequest r10, HttpURLConnection r11) {
        r10.mCurrentUrlConnection = r11;
        return r11;
    }

    static /* synthetic */ UrlResponseInfoImpl access$1400(JavaUrlRequest r10) {
        return r10.mUrlResponseInfo;
    }

    static /* synthetic */ UrlResponseInfoImpl access$1402(JavaUrlRequest r10, UrlResponseInfoImpl r11) {
        r10.mUrlResponseInfo = r11;
        return r11;
    }

    static /* synthetic */ void access$1500(JavaUrlRequest r10, String r11) {
        r10.fireRedirectReceived(r11);
    }

    static /* synthetic */ void access$1600(JavaUrlRequest r10) {
        r10.fireCloseUploadDataProvider();
    }

    static /* synthetic */ ReadableByteChannel access$1700(JavaUrlRequest r10) {
        return r10.mResponseChannel;
    }

    static /* synthetic */ ReadableByteChannel access$1702(JavaUrlRequest r10, ReadableByteChannel r11) {
        r10.mResponseChannel = r11;
        return r11;
    }

    static /* synthetic */ AsyncUrlRequestCallback access$1800(JavaUrlRequest r10) {
        return r10.mCallbackAsync;
    }

    static /* synthetic */ VersionSafeCallbacks.UploadDataProviderWrapper access$1900(JavaUrlRequest r10) {
        return r10.mUploadDataProvider;
    }

    static /* synthetic */ void access$2000(JavaUrlRequest r10, int r11, int r12, Runnable r13) {
        r10.transitionStates(r11, r12, r13);
    }

    static /* synthetic */ AtomicInteger access$2100(JavaUrlRequest r10) {
        return r10.mState;
    }

    static /* synthetic */ Map access$2200(JavaUrlRequest r10) {
        return r10.mRequestHeaders;
    }

    static /* synthetic */ String access$2300(JavaUrlRequest r10) {
        return r10.mUserAgent;
    }

    static /* synthetic */ String access$2400(JavaUrlRequest r10) {
        return r10.mInitialMethod;
    }

    static /* synthetic */ String access$2402(JavaUrlRequest r10, String r11) {
        r10.mInitialMethod = r11;
        return r11;
    }

    static /* synthetic */ OutputStreamDataSink access$2500(JavaUrlRequest r10) {
        return r10.mOutputStreamDataSink;
    }

    static /* synthetic */ OutputStreamDataSink access$2502(JavaUrlRequest r10, OutputStreamDataSink r11) {
        r10.mOutputStreamDataSink = r11;
        return r11;
    }

    static /* synthetic */ Executor access$2600(JavaUrlRequest r10) {
        return r10.mUploadExecutor;
    }

    static /* synthetic */ Executor access$2700(JavaUrlRequest r10) {
        return r10.mExecutor;
    }

    static /* synthetic */ void access$2800(JavaUrlRequest r10, Throwable r11) {
        r10.enterCronetErrorState(r11);
    }

    static /* synthetic */ void access$2900(JavaUrlRequest r10, Throwable r11) {
        r10.enterUserErrorState(r11);
    }

    static /* synthetic */ void access$3000(JavaUrlRequest r10, int r11, ByteBuffer r12) {
        r10.processReadResult(r11, r12);
    }

    static /* synthetic */ String access$3100() {
        return TAG;
    }

    static /* synthetic */ boolean access$3200(JavaUrlRequest r10) {
        return r10.mAllowDirectExecutor;
    }

    static /* synthetic */ Runnable access$3300(JavaUrlRequest r10, JavaUrlRequestUtils.CheckedRunnable r11) {
        return r10.userErrorSetting(r11);
    }

    static /* synthetic */ void access$3400(JavaUrlRequest r10, CronetException r11) {
        r10.enterErrorState(r11);
    }

    static /* synthetic */ long access$3500(String r10) {
        return parseContentLengthString(r10);
    }

    static /* synthetic */ int access$3600(JavaUrlRequest r10) {
        return r10.mCronetEngineId;
    }

    static /* synthetic */ CronetLogger access$3700(JavaUrlRequest r10) {
        return r10.mLogger;
    }

    static /* synthetic */ void access$3800(JavaUrlRequest r10) {
        r10.closeResponseChannel();
    }

    static /* synthetic */ int access$402(JavaUrlRequest r10, int r11) {
        r10.mAdditionalStatusDetails = r11;
        return r11;
    }

    static /* synthetic */ void access$500(JavaUrlRequest r10) {
        r10.fireGetHeaders();
    }

    static /* synthetic */ Runnable access$600(JavaUrlRequest r10, JavaUrlRequestUtils.CheckedRunnable r11) {
        return r10.errorSetting(r11);
    }

    static /* synthetic */ Runnable access$700(JavaUrlRequest r10, JavaUrlRequestUtils.CheckedRunnable r11) {
        return r10.uploadErrorSetting(r11);
    }

    static /* synthetic */ void access$800(JavaUrlRequest r10, Throwable r11) {
        r10.enterUploadErrorState(r11);
    }

    static /* synthetic */ String access$900(JavaUrlRequest r10) {
        return r10.mCurrentUrl;
    }

    static /* synthetic */ String access$902(JavaUrlRequest r10, String r11) {
        r10.mCurrentUrl = r11;
        return r11;
    }

    private void checkNotStarted() {
        int r10 = this.mState.get();
        if (r10 != 0) goto L6;
        return;
    L6:
        throw new IllegalStateException("Request is already started. State is: " + r10);
    }

    private void closeResponseChannel() {
        this.mExecutor.execute(new AnonymousClass13(this));
    }

    private void enterCronetErrorState(Throwable r10) {
        enterErrorState(new CronetExceptionImpl("System error", r10));
    }

    private void enterErrorState(CronetException r10) {
        if (setTerminalState(6) == false) goto L6;
        fireDisconnect();
        fireCloseUploadDataProvider();
        this.mCallbackAsync.onFailed(this.mUrlResponseInfo, r10);
        return;
    }

    private void enterUploadErrorState(Throwable r10) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UploadDataProvider", r10));
    }

    private void enterUserErrorState(Throwable r10) {
        enterErrorState(new CallbackExceptionImpl("Exception received from UrlRequest.Callback", r10));
    }

    private Runnable errorSetting(final JavaUrlRequestUtils.CheckedRunnable r10) {
        return new AnonymousClass8(this, r10);
    }

    @VisibleForTesting
    static long estimateHeadersSizeInBytes(Map<String, String> r10) {
        long r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L14;
        Map.Entry<String, String> r13 = r12.next();
        String r14 = r13.getKey();
        if (r14 == null) goto L11;
        r11 = r11 + ((long) r14.length());
    L11:
        String r15 = r13.getValue();
        if (r15 == null) goto L7;
        r11 = r11 + ((long) r15.length());
        goto L7
    L14:
        return r11;
    }

    @VisibleForTesting
    static long estimateHeadersSizeInBytesList(Map<String, List<String>> r10) {
        long r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, List<String>>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L20;
        Map.Entry<String, List<String>> r13 = r12.next();
        String r14 = r13.getKey();
        if (r14 == null) goto L12;
        r11 = r11 + ((long) r14.length());
    L12:
        if (r13.getValue() == null) goto L7;
        Iterator<String> r15 = r13.getValue().iterator();
    L16:
        if (r15.hasNext() == false) goto L7;
        String r16 = r15.next();
        if (r16 == null) goto L16;
        r11 = r11 + ((long) r16.length());
        goto L16
    L20:
        return r11;
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

    private void fireRedirectReceived(final String r10) {
        transitionStates(1, 2, new AnonymousClass6(this, r10));
    }

    private boolean isValidHeaderName(String r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L23;
        char r12 = r10.charAt(r11);
        if (r12 == ',') goto L22;
        if (r12 == '/') goto L22;
        if (r12 == '{') goto L22;
        if (r12 == '}') goto L22;
        switch(r12) {
            case 39: goto L22;
            case 40: goto L22;
            case 41: goto L22;
            default: goto L14;
        };
    L14:
        switch(r12) {
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
        switch(r12) {
            case 91: goto L22;
            case 92: goto L22;
            case 93: goto L22;
            default: goto L17;
        };
    L17:
        if (Character.isISOControl(r12) == true) goto L22;
        if (Character.isWhitespace(r12) == true) goto L22;
        r11 = r11 + 1;
    L22:
        return false;
    L23:
        return true;
    }

    private static long parseContentLengthString(String r10) {
        return Long.parseLong(r10);
    L4:
        return 0;
    }

    private void processReadResult(int r10, ByteBuffer r11) {
        if (r10 == (-1)) goto L5;
        this.mCallbackAsync.onReadCompleted(this.mUrlResponseInfo, r11);
        return;
    L5:
        ReadableByteChannel r12 = this.mResponseChannel;
        if (r12 == null) goto L9;
        r12.close();
    L9:
        if (this.mState.compareAndSet(5, 7) == false) goto L13;
        fireDisconnect();
        this.mCallbackAsync.onSucceeded(this.mUrlResponseInfo);
        return;
    }

    private boolean setTerminalState(int r10) {
    L2:
        int r11 = this.mState.get();
        if (r11 == 0) goto L17;
        if (r11 == 6) goto L14;
        if (r11 == 7) goto L24;
        if (r11 == 8) goto L25;
        if (this.mState.compareAndSet(r11, r10) == false) goto L2;
        return true;
    L25:
        return false;
    L24:
        return false;
    L14:
        return false;
    L17:
        throw new IllegalStateException("Can't enter error state before start");
    }

    private void transitionStates(int r10, int r11, Runnable r12) {
        if (this.mState.compareAndSet(r10, r11) == true) goto L11;
        int r13 = this.mState.get();
        if (r13 != 8) goto L7;
        return;
    L7:
        if (r13 != 6) goto L10;
        return;
    L10:
        throw new IllegalStateException("Invalid state transition - expected " + r10 + " but was " + r13);
    L11:
        r12.run();
    }

    private Runnable uploadErrorSetting(final JavaUrlRequestUtils.CheckedRunnable r10) {
        return new AnonymousClass10(this, r10);
    }

    private Runnable userErrorSetting(final JavaUrlRequestUtils.CheckedRunnable r10) {
        return new AnonymousClass9(this, r10);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void AddRequestCookieHeader(String r10, String r11) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void RemoveRequestCookieHeader() {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void addHeader(String r10, String r11) {
        checkNotStarted();
        if (isValidHeaderName(r10) == false) goto L12;
        if (r11.contains("\r\n") == true) goto L12;
        if (this.mRequestHeaders.containsKey(r10) == false) goto L9;
        this.mRequestHeaders.remove(r10);
    L9:
        this.mRequestHeaders.put(r10, r11);
        return;
    L12:
        throw new IllegalArgumentException("Invalid header " + r10 + "=" + r11);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void cancel() {
        int r10 = this.mState.getAndSet(8);
        if (r10 != 1) goto L5;
    L13:
        fireDisconnect();
        fireCloseUploadDataProvider();
        this.mCallbackAsync.onCanceled(this.mUrlResponseInfo);
        return;
    L5:
        if (r10 == 2) goto L13;
        if (r10 == 3) goto L13;
        if (r10 == 4) goto L13;
        if (r10 == 5) goto L13;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void followRedirect() {
        transitionStates(3, 1, new AnonymousClass3(this));
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getFinalUrl() {
        return "";
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getRequestLog() {
        return "";
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void getStatus(UrlRequest.StatusListener r10) {
        int r11 = this.mState.get();
        int r12 = this.mAdditionalStatusDetails;
        switch(r11) {
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
        r12 = 14;
        goto L9
    L7:
        r12 = 0;
        goto L9
    L8:
        r12 = -1;
    L9:
        this.mCallbackAsync.sendStatus(new VersionSafeCallbacks.UrlRequestStatusListener(r10), r12);
        return;
    L5:
        throw new IllegalStateException("Switch is exhaustive: " + r11);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public boolean isDone() {
        int r10 = this.mState.get();
        if (r10 != 7) goto L5;
    L10:
        return true;
    L5:
        if (r10 == 6) goto L10;
        if (r10 == 8) goto L10;
        return false;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void read(final ByteBuffer r10) {
        Preconditions.checkDirect(r10);
        Preconditions.checkHasRemaining(r10);
        transitionStates(4, 5, new AnonymousClass11(this, r10));
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAddCookieCostUs(long r10) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAuthCredentials(String r10, String r11) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setHttpMethod(String r10) {
        checkNotStarted();
        Objects.requireNonNull(r10, "Method is required.");
        if ("OPTIONS".equalsIgnoreCase(r10) == false) goto L5;
    L21:
        this.mInitialMethod = r10;
        return;
    L5:
        if ("GET".equalsIgnoreCase(r10) == true) goto L21;
        if ("HEAD".equalsIgnoreCase(r10) == true) goto L21;
        if (CloudConfig.REQUEST_TYPE_POST.equalsIgnoreCase(r10) == true) goto L21;
        if ("PUT".equalsIgnoreCase(r10) == true) goto L21;
        if ("DELETE".equalsIgnoreCase(r10) == true) goto L21;
        if ("TRACE".equalsIgnoreCase(r10) == true) goto L21;
        if ("PATCH".equalsIgnoreCase(r10) == true) goto L21;
        throw new IllegalArgumentException("Invalid http method " + r10);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestCookieSource(int r10) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setRequestTimeout(int r10) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestTypeFlags(int r10) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setSaveCookieCostUs(long r10) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketConnectTimeout(int r10) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketReadTimeout(int r10) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketWriteTimeout(int r10) {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setThrottleNetSpeed(long r10) {
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider r10, Executor r11) {
        Objects.requireNonNull(r10, "Invalid UploadDataProvider.");
        if (this.mRequestHeaders.containsKey(NetConst.KEY_CONTENT_TYPE) == false) goto L13;
        checkNotStarted();
        if (this.mInitialMethod != null) goto L7;
        this.mInitialMethod = CloudConfig.REQUEST_TYPE_POST;
    L7:
        this.mUploadDataProvider = new VersionSafeCallbacks.UploadDataProviderWrapper(r10);
        if (this.mAllowDirectExecutor == false) goto L10;
        this.mUploadExecutor = r11;
        return;
    L10:
        this.mUploadExecutor = new JavaUrlRequestUtils.DirectPreventingExecutor(r11);
        return;
    L13:
        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");
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
