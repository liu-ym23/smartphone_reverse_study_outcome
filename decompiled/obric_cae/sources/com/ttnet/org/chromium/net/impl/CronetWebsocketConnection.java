package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import defpackage.b;
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

    public CronetWebsocketConnection(CronetUrlRequestContext r8, TTWebsocketConnection.Callback r10, Executor r11, List<String> r12, int r13, String r14, long r15, int r16, long r17, String r18, int r19, String r110, Map<String, String> r111, Map<String, String> r112, boolean r20) {
        this.mUseFrontier = true;
        this.mWebsocketAdapterLock = new Object();
        this.mState = new AtomicInteger(-1);
        this.mRequestContext = r8;
        this.mCallback = r10;
        this.mExecutor = r11;
        this.mUrlList = r12;
        this.mAppId = r13;
        this.mAppKey = r14;
        this.mDeviceId = r15;
        this.mFpid = r16;
        this.mInstallId = r17;
        this.mSessionId = r18;
        this.mAppVersion = r19;
        this.mAppToken = r110;
        this.mParams = r111;
        this.mHeaders = r112;
        this.mSharedConnection = r20;
    }

    public static /* synthetic */ TTWebsocketConnection.Callback access$000(CronetWebsocketConnection r8) {
        return r8.mCallback;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    private ByteBuffer clone(ByteBuffer r8) {
        ByteBuffer r10 = ByteBuffer.allocate(r8.capacity());
        r8.rewind();
        r10.put(r8);
        r10.flip();
        return r10;
    }

    @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
    private native void nativeAddGetParam(long r8, String r10, String r11);

    @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
    private native void nativeAddHeader(long r8, String r10, String r11);

    @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
    private native void nativeAddUrl(long r8, String r10);

    private native long nativeCreateWebsocketConnectionAdapter(long r8);

    @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
    private native void nativeDestroy(long r8);

    @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
    private native void nativeSendBinary(long r8, ByteBuffer r10);

    @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
    private native void nativeSendText(long r8, String r10);

    @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
    private native void nativeStartWithFrontier(long r8, int r10, String r11, long r12, int r13, long r14, String r15, int r16, String r17, boolean r18);

    @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
    private native void nativeStartWithWSChannel(long r8, boolean r10);

    @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
    private native void nativeStop(long r8);

    @CalledByNative
    private void onConnectionError(final int r8, final String r10, final String r11) {
        Log.e(TAG, b.c("onConnectionError: ", r11), new Object[0]);
        this.mState.set(r8);
        postTaskToExecutor(new AnonymousClass2(this, r8, r10, r11));
    }

    @CalledByNative
    private void onConnectionStateChanged(final int r8, final String r10) {
        this.mState.set(r8);
        postTaskToExecutor(new AnonymousClass1(this, r8, r10));
    }

    @CalledByNative
    private void onFeedbackLog(final String r8) {
        postTaskToExecutor(new AnonymousClass4(this, r8));
    }

    @CalledByNative
    private void onMessageReceived(ByteBuffer r8, final int r10) {
        final ByteBuffer r11 = clone(r8);
        postTaskToExecutor(new AnonymousClass3(this, r11, r10));
    }

    @CalledByNative
    private void onTrafficChanged(final String r10, final long r11, final long r13, final boolean r15) {
        postTaskToExecutor(new AnonymousClass5(this, r10, r11, r13, r15));
    }

    private void postTaskToExecutor(Runnable r8) {
        this.mExecutor.execute(r8);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "Exception posting task to executor", new Object[]{e});
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void asyncSendBinary(ByteBuffer r8) {
        Object r10 = this.mWebsocketAdapterLock;
        monitor-enter(r10);
        long r11 = this.mWebsocketAdapter;     // Catch: Throwable -> L11
        if (r11 != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        nativeSendBinary(r11, r8);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void asyncSendText(String r8) {
        Object r10 = this.mWebsocketAdapterLock;
        monitor-enter(r10);
        long r11 = this.mWebsocketAdapter;     // Catch: Throwable -> L11
        if (r11 != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        nativeSendText(r11, r8);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void destroyConnection() {
        Object r8 = this.mWebsocketAdapterLock;
        monitor-enter(r8);
        long r10 = this.mWebsocketAdapter;     // Catch: Throwable -> L11
        if (r10 != 0) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        nativeDestroy(r10);     // Catch: Throwable -> L11
        this.mWebsocketAdapter = 0;     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
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
    L29:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L7;
        this.mWebsocketAdapter = nativeCreateWebsocketConnectionAdapter(this.mRequestContext.getUrlRequestContextAdapter());     // Catch: Throwable -> L29
    L7:
        Iterator<String> r8 = this.mUrlList.iterator();     // Catch: Throwable -> L29
    L9:
        if (r8.hasNext() == false) goto L11;
        String r10 = r8.next();     // Catch: Throwable -> L29
        nativeAddUrl(this.mWebsocketAdapter, r10);     // Catch: Throwable -> L29
        goto L9
    L11:
        Map<String, String> r11 = this.mParams;     // Catch: Throwable -> L29
        if (r11 == null) goto L17;
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();     // Catch: Throwable -> L29
    L15:
        if (r12.hasNext() == false) goto L17;
        Map.Entry<String, String> r13 = r12.next();     // Catch: Throwable -> L29
        nativeAddGetParam(this.mWebsocketAdapter, r13.getKey(), r13.getValue());     // Catch: Throwable -> L29
    L17:
        Map<String, String> r14 = this.mHeaders;     // Catch: Throwable -> L29
        if (r14 == null) goto L24;
        Iterator<Map.Entry<String, String>> r16 = r14.entrySet().iterator();     // Catch: Throwable -> L29
    L21:
        if (r16.hasNext() == false) goto L24;
        Map.Entry<String, String> r17 = r16.next();     // Catch: Throwable -> L29
        nativeAddHeader(this.mWebsocketAdapter, r17.getKey(), r17.getValue());     // Catch: Throwable -> L29
    L24:
        if (this.mUseFrontier == false) goto L26;
        nativeStartWithFrontier(this.mWebsocketAdapter, this.mAppId, this.mAppKey, this.mDeviceId, this.mFpid, this.mInstallId, this.mSessionId, this.mAppVersion, this.mAppToken, this.mSharedConnection);     // Catch: Throwable -> L29
    L27:
        monitor-exit(r15);     // Catch: Throwable -> L29
        return;
    L26:
        nativeStartWithWSChannel(this.mWebsocketAdapter, this.mSharedConnection);     // Catch: Throwable -> L29
        goto L27
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void stopConnection() {
        Object r8 = this.mWebsocketAdapterLock;
        monitor-enter(r8);
        long r10 = this.mWebsocketAdapter;     // Catch: Throwable -> L11
        if (r10 != 0) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        nativeStop(r10);     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public CronetWebsocketConnection(CronetUrlRequestContext r8, TTWebsocketConnection.Callback r10, Executor r11, List<String> r12, Map<String, String> r13, Map<String, String> r14, boolean r15) {
        this.mUseFrontier = true;
        this.mWebsocketAdapterLock = new Object();
        this.mState = new AtomicInteger(-1);
        this.mRequestContext = r8;
        this.mCallback = r10;
        this.mExecutor = r11;
        this.mUrlList = r12;
        this.mParams = r13;
        this.mHeaders = r14;
        this.mSharedConnection = r15;
        this.mUseFrontier = false;
    }
}
