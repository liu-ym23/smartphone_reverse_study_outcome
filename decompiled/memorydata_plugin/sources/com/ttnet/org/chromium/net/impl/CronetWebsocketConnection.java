package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
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
        void addGetParam(long r1, CronetWebsocketConnection r3, String r4, String r5);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void addHeader(long r1, CronetWebsocketConnection r3, String r4, String r5);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void addUrl(long r1, CronetWebsocketConnection r3, String r4);

        long createWebsocketConnectionAdapter(CronetWebsocketConnection r1, long r2);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void destroy(long r1, CronetWebsocketConnection r3);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void sendBinary(long r1, CronetWebsocketConnection r3, ByteBuffer r4);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void sendText(long r1, CronetWebsocketConnection r3, String r4);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void startWithFrontier(long r1, CronetWebsocketConnection r3, int r4, String r5, long r6, int r8, long r9, String r11, int r12, String r13, boolean r14);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void startWithWSChannel(long r1, CronetWebsocketConnection r3, boolean r4);

        @NativeClassQualifiedName("CronetWebsocketConnectionAdapter")
        void stop(long r1, CronetWebsocketConnection r3);
    }

    static {
    }

    CronetWebsocketConnection(CronetUrlRequestContext r8, TTWebsocketConnection.Callback r9, Executor r10, List<String> r11, int r12, String r13, long r14, int r16, long r17, String r19, int r20, String r21, Map<String, String> r22, Map<String, String> r23, boolean r24) {
        Executor r1 = (Executor) ZeusTransformUtils.wrapperContextForParams(r10, Executor.class, "com.obric.memorydata.plugin");
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
        this.mUseFrontier = true;
        this.mWebsocketAdapterLock = new Object();
        this.mState = new AtomicInteger(-1);
        this.mRequestContext = r8;
        this.mCallback = r9;
        this.mExecutor = r1;
        this.mUrlList = r3;
        this.mAppId = r12;
        this.mAppKey = r13;
        this.mDeviceId = r14;
        this.mFpid = r16;
        this.mInstallId = r17;
        this.mSessionId = r19;
        this.mAppVersion = r20;
        this.mAppToken = r21;
        this.mParams = r4;
        this.mHeaders = r2;
        this.mSharedConnection = r24;
    }

    CronetWebsocketConnection(CronetUrlRequestContext r3, TTWebsocketConnection.Callback r4, Executor r5, List<String> r6, Map<String, String> r7, Map<String, String> r8, boolean r9) {
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Map<String, String> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Map<String, String> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        this.mUseFrontier = true;
        this.mWebsocketAdapterLock = new Object();
        this.mState = new AtomicInteger(-1);
        this.mRequestContext = r3;
        this.mCallback = r4;
        this.mExecutor = r10;
        this.mUrlList = r11;
        this.mParams = r12;
        this.mHeaders = r13;
        this.mSharedConnection = r9;
        this.mUseFrontier = false;
    }

    static /* synthetic */ TTWebsocketConnection.Callback access$000(CronetWebsocketConnection r0) {
        return r0.mCallback;
    }

    static /* synthetic */ String access$100() {
        return TAG;
    }

    private ByteBuffer clone(ByteBuffer r1) {
        ByteBuffer r0 = ByteBuffer.allocate(r1.capacity());
        r1.rewind();
        r0.put(r1);
        r0.flip();
        return r0;
    }

    private void onConnectionError(final int r4, final String r5, final String r6) {
        Log.d(TAG, "onConnectionError: " + r6, new Object[0]);
        this.mState.set(r4);
        postTaskToExecutor(new AnonymousClass2(this, r4, r5, r6));
    }

    private void onConnectionStateChanged(final int r4, final String r5) {
        Log.d(TAG, "onConnectionStateChanged: state = " + r4 + ", url = " + r5, new Object[0]);
        this.mState.set(r4);
        postTaskToExecutor(new AnonymousClass1(this, r4, r5));
    }

    private void onFeedbackLog(final String r4) {
        Log.v(TAG, "OnFeedbackLog", new Object[0]);
        postTaskToExecutor(new AnonymousClass4(this, r4));
    }

    private void onMessageReceived(ByteBuffer r4, final int r5) {
        Log.v(TAG, "onMessageReceived", new Object[0]);
        final ByteBuffer r6 = clone(r4);
        postTaskToExecutor(new AnonymousClass3(this, r6, r5));
    }

    private void onTrafficChanged(final String r12, final long r13, final long r15, final boolean r17) {
        Log.v(TAG, "OnTrafficChanged", new Object[0]);
        postTaskToExecutor(new AnonymousClass5(this, r12, r13, r15, r17));
    }

    private void postTaskToExecutor(Runnable r3) {
        this.mExecutor.execute((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Exception posting task to executor", new Object[]{e});
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void asyncSendBinary(ByteBuffer r6) {
        Object r0 = this.mWebsocketAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetWebsocketConnectionJni.get().sendBinary(this.mWebsocketAdapter, this, r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void asyncSendText(String r6) {
        Object r0 = this.mWebsocketAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetWebsocketConnectionJni.get().sendText(this.mWebsocketAdapter, this, r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void destroyConnection() {
        Object r0 = this.mWebsocketAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetWebsocketConnectionJni.get().destroy(this.mWebsocketAdapter, this);     // Catch: Throwable -> L11
        this.mWebsocketAdapter = 0;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
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
    L35:
        th = th;
    L33:
        monitor-exit(r15);     // Catch: Throwable -> L35
        throw th;
    L31:
        th = th;
        goto L33
    L5:
        if (this.mWebsocketAdapter != 0) goto L7;
        this.mWebsocketAdapter = CronetWebsocketConnectionJni.get().createWebsocketConnectionAdapter(this, this.mRequestContext.getUrlRequestContextAdapter());     // Catch: Throwable -> L31
    L7:
        Iterator<String> r1 = this.mUrlList.iterator();     // Catch: Throwable -> L31
    L9:
        if (r1.hasNext() == false) goto L11;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        CronetWebsocketConnectionJni.get().addUrl(this.mWebsocketAdapter, this, r2);     // Catch: Throwable -> L31
        goto L9
    L11:
        Map<String, String> r3 = this.mParams;     // Catch: Throwable -> L31
        if (r3 == null) goto L17;
        Iterator<Map.Entry<String, String>> r7 = r3.entrySet().iterator();     // Catch: Throwable -> L31
    L15:
        if (r7.hasNext() == false) goto L17;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        CronetWebsocketConnectionJni.get().addGetParam(this.mWebsocketAdapter, this, (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r4.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L31
    L17:
        Map<String, String> r5 = this.mHeaders;     // Catch: Throwable -> L31
        if (r5 == null) goto L24;
        Iterator<Map.Entry<String, String>> r8 = r5.entrySet().iterator();     // Catch: Throwable -> L31
    L21:
        if (r8.hasNext() == false) goto L24;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        CronetWebsocketConnectionJni.get().addHeader(this.mWebsocketAdapter, this, (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L31
    L24:
        if (this.mUseFrontier == false) goto L28;
        CronetWebsocketConnectionJni.get().startWithFrontier(this.mWebsocketAdapter, this, this.mAppId, this.mAppKey, this.mDeviceId, this.mFpid, this.mInstallId, this.mSessionId, this.mAppVersion, this.mAppToken, this.mSharedConnection);     // Catch: Throwable -> L35
    L29:
        monitor-exit(r15);     // Catch: Throwable -> L35
        return;
    L28:
        CronetWebsocketConnectionJni.get().startWithWSChannel(this.mWebsocketAdapter, this, this.mSharedConnection);     // Catch: Throwable -> L35
        goto L29
    }

    @Override // com.ttnet.org.chromium.net.TTWebsocketConnection
    public void stopConnection() {
        Object r0 = this.mWebsocketAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mWebsocketAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetWebsocketConnectionJni.get().stop(this.mWebsocketAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }
}
