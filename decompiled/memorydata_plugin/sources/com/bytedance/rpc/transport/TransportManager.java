package com.bytedance.rpc.transport;

import com.bytedance.rpc.RpcConfig;
import com.bytedance.rpc.RpcContext;
import com.bytedance.rpc.RpcRecorder;
import com.bytedance.rpc.internal.TypeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TransportManager {
    private volatile TransportClient mClient;
    private RpcContext mContext;
    private final Object mLock;
    private TransportClientFactory mTransportFactory;
    private volatile TransportClient mWebSocketClient;

    public TransportManager(RpcContext r2) {
        this.mLock = new Byte[0];
        this.mContext = r2;
        this.mTransportFactory = defaultTransportFactory();
    }

    private TransportClientFactory defaultTransportFactory() {
        Object r2 = TypeUtils.instance("com.bytedance.rpc.transport.TTNetTransportClientFactory");
        if (ZeusTransformUtils.instanceOf(r2, TransportClientFactory.class) == true) goto L5;
        return null;
    L5:
        return (TransportClientFactory) ZeusTransformUtils.preCheckCast(r2, TransportClientFactory.class, "com.obric.memorydata.plugin");
    }

    private TransportClient getTransportClient(boolean r4) {
        if (r4 == false) goto L20;
        if (this.mWebSocketClient != null) goto L18;
        Object r5 = this.mLock;
        monitor-enter(r5);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.mWebSocketClient != null) goto L12;
        TransportClientFactory r0 = this.mTransportFactory;     // Catch: Throwable -> L14
        if (r0 == null) goto L12;
        this.mWebSocketClient = r0.create(this.mContext, true);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r5);     // Catch: Throwable -> L14
    L18:
        return this.mWebSocketClient;
    L20:
        if (this.mClient != null) goto L34;
        Object r6 = this.mLock;
        monitor-enter(r6);
    L30:
        th = move-exception;
        throw th;
    L24:
        if (this.mClient != null) goto L28;
        TransportClientFactory r1 = this.mTransportFactory;     // Catch: Throwable -> L30
        if (r1 == null) goto L28;
        this.mClient = r1.create(this.mContext, false);     // Catch: Throwable -> L30
    L28:
        monitor-exit(r6);     // Catch: Throwable -> L30
    L34:
        return this.mClient;
    }

    private boolean isWebSocketRequired(RpcRecorder r1) {
        return false;
    }

    public TransportClient getTransport(RpcRecorder r1) {
        TransportClient r0 = getTransportClient(isWebSocketRequired(r1));
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new RuntimeException("transport client should not null , check your TransportFactory again.");
    }

    public boolean isRetryTransportAllowed(RpcRecorder r1) {
        return false;
    }

    public void setTransportFactory(TransportClientFactory r3) {
        TransportClientFactory r4 = (TransportClientFactory) ZeusTransformUtils.wrapperContextForParams(r3, TransportClientFactory.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L18;
        Object r0 = this.mLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.mClient != null) goto L14;
        if (this.mWebSocketClient != null) goto L14;
        this.mTransportFactory = r4;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L14:
        throw new RuntimeException("using transport client, not allow to change TransportClientFactory.");     // Catch: Throwable -> L15
    }

    public void updateConfig(RpcConfig r1) {
    }
}
