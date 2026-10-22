package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public final class CronetWebsocketConnection extends TTWebsocketConnection {
    private static final String TAG = "CronetWebsocketConnection";
    private int mAppId;
    private String mAppKey;
    private String mAppToken;
    private int mAppVersion;
    private final TTWebsocketConnection.Callback mCallback;
    private long mDeviceId;
    private final Executor mExecutor;
    private int mFpid;
    private Map<String, String> mHeaders;
    private long mInstallId;
    private Map<String, String> mParams;
    private final CronetUrlRequestContext mRequestContext;
    private String mSessionId;
    private boolean mSharedConnection;
    private AtomicInteger mState;
    private List<String> mUrlList;
    private boolean mUseFrontier;
    private long mWebsocketAdapter;
    private final Object mWebsocketAdapterLock;

    interface Natives {
        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void addGetParam(long r10, CronetWebsocketConnection r11, String r12, String r13);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void addHeader(long r10, CronetWebsocketConnection r11, String r12, String r13);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void addUrl(long r10, CronetWebsocketConnection r11, String r12);

        long createWebsocketConnectionAdapter(CronetWebsocketConnection r10, long r11);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void destroy(long r10, CronetWebsocketConnection r11);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void sendBinary(long r10, CronetWebsocketConnection r11, ByteBuffer r12);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void sendText(long r10, CronetWebsocketConnection r11, String r12);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void startWithFrontier(long r10, CronetWebsocketConnection r11, int r12, String r13, long r14, int r15, long r16, String r17, int r18, String r19, boolean r110);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void startWithWSChannel(long r10, CronetWebsocketConnection r11, boolean r12);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void stop(long r10, CronetWebsocketConnection r11);
    }

    static {
    }

    CronetWebsocketConnection(CronetUrlRequestContext r10, TTWebsocketConnection.Callback r11, Executor r12, List<String> r13, int r14, String r15, long r16, int r17, long r18, String r19, int r110, String r111, Map<String, String> r112, Map<String, String> r113, boolean r20) {
        this.mUseFrontier = true;
        this.mWebsocketAdapterLock = new Object();
        this.mState = new AtomicInteger(-1);
        this.mRequestContext = r10;
        this.mCallback = r11;
        this.mExecutor = r12;
        this.mUrlList = r13;
        this.mAppId = r14;
        this.mAppKey = r15;
        this.mDeviceId = r16;
        this.mFpid = r17;
        this.mInstallId = r18;
        this.mSessionId = r19;
        this.mAppVersion = r110;
        this.mAppToken = r111;
        this.mParams = r112;
        this.mHeaders = r113;
        this.mSharedConnection = r20;
    }

    CronetWebsocketConnection(CronetUrlRequestContext r10, TTWebsocketConnection.Callback r11, Executor r12, List<String> r13, Map<String, String> r14, Map<String, String> r15, boolean r16) {
        this.mUseFrontier = true;
        this.mWebsocketAdapterLock = new Object();
        this.mState = new AtomicInteger(-1);
        this.mRequestContext = r10;
        this.mCallback = r11;
        this.mExecutor = r12;
        this.mUrlList = r13;
        this.mParams = r14;
        this.mHeaders = r15;
        this.mSharedConnection = r16;
        this.mUseFrontier = false;
    }

    static /* synthetic */ TTWebsocketConnection.Callback access$000(CronetWebsocketConnection r10) {
        return r10.mCallback;
    }

    static /* synthetic */ String access$100() {
        return TAG;
    }

    private ByteBuffer clone(ByteBuffer r10) {
        ByteBuffer r11 = ByteBuffer.allocate(r10.capacity());
        r10.rewind();
        r11.put(r10);
        r11.flip();
        return r11;
    }

    @CalledByNative
    private void onConnectionError(final int r10, final String r11, final String r12) {
        Log.d(TAG, "onConnectionError: " + r12, new Object[0]);
        this.mState.set(r10);
        postTaskToExecutor(new AnonymousClass2(this, r10, r11, r12));
    }

    @CalledByNative
    private void onConnectionStateChanged(final int r10, final String r11) {
        Log.d(TAG, "onConnectionStateChanged: state = " + r10 + ", url = " + r11, new Object[0]);
        this.mState.set(r10);
        postTaskToExecutor(new AnonymousClass1(this, r10, r11));
    }

    @CalledByNative
    private void onFeedbackLog(final String r10) {
        Log.v(TAG, "OnFeedbackLog", new Object[0]);
        postTaskToExecutor(new AnonymousClass4(this, r10));
    }

    @CalledByNative
    private void onMessageReceived(ByteBuffer r10, final int r11) {
        Log.v(TAG, "onMessageReceived", new Object[0]);
        final ByteBuffer r12 = clone(r10);
        postTaskToExecutor(new AnonymousClass3(this, r12, r11));
    }

    @CalledByNative
    private void onTrafficChanged(final String r12, final long r13, final long r15, final boolean r17) {
        Log.v(TAG, "OnTrafficChanged", new Object[0]);
        postTaskToExecutor(new AnonymousClass5(this, r12, r13, r15, r17));
    }

    private void postTaskToExecutor(Runnable r10) {
        this.mExecutor.execute(r10);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Exception posting task to executor", new Object[]{e});
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void asyncSendBinary(ByteBuffer r10) {
        Object r11 = this.mWebsocketAdapterLock;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        CronetWebsocketConnectionJni.get().sendBinary(this.mWebsocketAdapter, this, r10);     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void asyncSendText(String r10) {
        Object r11 = this.mWebsocketAdapterLock;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        CronetWebsocketConnectionJni.get().sendText(this.mWebsocketAdapter, this, r10);     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void destroyConnection() {
        Object r10 = this.mWebsocketAdapterLock;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        CronetWebsocketConnectionJni.get().destroy(this.mWebsocketAdapter, this);     // Catch: Throwable -> L11
        this.mWebsocketAdapter = 0;     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public boolean isConnected() {
        if (this.mState.get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void startConnection() {
        Object r15 = this.mWebsocketAdapterLock;
        monitor-enter(r15);
    L31:
        th = th;
    L33:
        monitor-exit(r15);     // Catch: Throwable -> L35
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L7;
        this.mWebsocketAdapter = CronetWebsocketConnectionJni.get().createWebsocketConnectionAdapter(this, this.mRequestContext.getUrlRequestContextAdapter());     // Catch: Throwable -> L31
    L7:
        Iterator<String> r10 = this.mUrlList.iterator();     // Catch: Throwable -> L31
    L9:
        if (r10.hasNext() == false) goto L11;
        String r11 = r10.next();     // Catch: Throwable -> L31
        CronetWebsocketConnectionJni.get().addUrl(this.mWebsocketAdapter, this, r11);     // Catch: Throwable -> L31
        goto L9
    L11:
        Map<String, String> r12 = this.mParams;     // Catch: Throwable -> L31
        if (r12 == null) goto L17;
        Iterator<Map.Entry<String, String>> r13 = r12.entrySet().iterator();     // Catch: Throwable -> L31
    L15:
        if (r13.hasNext() == false) goto L17;
        Map.Entry<String, String> r14 = r13.next();     // Catch: Throwable -> L31
        CronetWebsocketConnectionJni.get().addGetParam(this.mWebsocketAdapter, this, r14.getKey(), r14.getValue());     // Catch: Throwable -> L31
    L17:
        Map<String, String> r16 = this.mHeaders;     // Catch: Throwable -> L31
        if (r16 == null) goto L24;
        Iterator<Map.Entry<String, String>> r17 = r16.entrySet().iterator();     // Catch: Throwable -> L31
    L21:
        if (r17.hasNext() == false) goto L24;
        Map.Entry<String, String> r18 = r17.next();     // Catch: Throwable -> L31
        CronetWebsocketConnectionJni.get().addHeader(this.mWebsocketAdapter, this, r18.getKey(), r18.getValue());     // Catch: Throwable -> L31
    L24:
        if (this.mUseFrontier == false) goto L28;
        CronetWebsocketConnectionJni.get().startWithFrontier(this.mWebsocketAdapter, this, this.mAppId, this.mAppKey, this.mDeviceId, this.mFpid, this.mInstallId, this.mSessionId, this.mAppVersion, this.mAppToken, this.mSharedConnection);     // Catch: Throwable -> L35
    L29:
        monitor-exit(r15);     // Catch: Throwable -> L35
        return;
    L28:
        CronetWebsocketConnectionJni.get().startWithWSChannel(this.mWebsocketAdapter, this, this.mSharedConnection);     // Catch: Throwable -> L35
    L35:
        th = th;
        goto L33
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void stopConnection() {
        Object r10 = this.mWebsocketAdapterLock;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        CronetWebsocketConnectionJni.get().stop(this.mWebsocketAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }
}
