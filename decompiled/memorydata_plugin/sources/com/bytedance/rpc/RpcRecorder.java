package com.bytedance.rpc;

import android.os.Handler;
import com.bytedance.rpc.internal.TimeoutMonitor;
import com.bytedance.rpc.transport.TransportRequest;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RpcRecorder {
    private RpcException mLastException;
    List<RpcException> mLatestFailureReasons;
    long mRequestFinishedTime;
    private long mRequestReceivedTime;
    long mRequestSerializeTime;
    private long mRequestTransformTime;
    private RpcRequest mRpcRequest;
    private TimeoutMonitor mTimeoutMonitor;
    private TransportRequest mTransportRequest;

    RpcRecorder(RpcRequest r1) {
        this.mRpcRequest = r1;
    }

    void cancel() {
        stopWatchTimeout();
        this.mTimeoutMonitor = null;
    }

    void clear() {
        this.mRpcRequest = null;
        List<RpcException> r1 = this.mLatestFailureReasons;
        if (r1 == null) goto L6;
        r1.clear();
        this.mLatestFailureReasons = null;
    L6:
        if (this.mTransportRequest == null) goto L8;
        this.mTransportRequest = null;
    L8:
        TimeoutMonitor r2 = this.mTimeoutMonitor;
        if (r2 == null) goto L12;
        r2.cancel();
        this.mTimeoutMonitor = null;
        return;
    }

    public RpcException getLastException() {
        return this.mLastException;
    }

    public long getRequestFinishedTime() {
        return this.mRequestFinishedTime;
    }

    public long getRequestReceivedTime() {
        return this.mRequestReceivedTime;
    }

    public long getRequestSerializeTime() {
        return this.mRequestSerializeTime;
    }

    public long getRequestTransformTime() {
        return this.mRequestTransformTime;
    }

    public int getRetriedTimes() {
        List<RpcException> r0 = this.mLatestFailureReasons;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public RpcRequest getRpcRequest() {
        return this.mRpcRequest;
    }

    public TransportRequest getTransportRequest() {
        return this.mTransportRequest;
    }

    public boolean isAsyncRequest() {
        return this.mRpcRequest.isAsyncRequest();
    }

    public boolean isCanceled() {
        if (this.mTimeoutMonitor == null) goto L5;
    L7:
        return false;
    L5:
        if (this.mRequestReceivedTime <= 0) goto L7;
        return true;
    }

    TransportRequest recordRequest(TransportRequest r3) {
        this.mTransportRequest = r3;
        this.mRequestTransformTime = System.currentTimeMillis();
        return r3;
    }

    public void setLastException(RpcException r2) {
        if (r2 == null) goto L18;
        this.mLastException = r2;
        if (this.mLatestFailureReasons != null) goto L14;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mLatestFailureReasons != null) goto L9;
        this.mLatestFailureReasons = new ArrayList();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    L14:
        this.mLatestFailureReasons.add(r2);
        return;
    }

    void stopWatchTimeout() {
        TimeoutMonitor r0 = this.mTimeoutMonitor;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    void updateRequest(RpcRequest r1) {
        this.mRpcRequest = r1;
    }

    void watchTimeout(Handler r9, int r10) {
        int r6 = this.mRpcRequest.getRequestId();
        long r3 = this.mRpcRequest.getRpcInvokeContext().getMonitorTimeout();
        stopWatchTimeout();
        this.mRequestReceivedTime = System.currentTimeMillis();
        TimeoutMonitor r0 = new TimeoutMonitor(r9, r3, r10, r6, false);
        this.mTimeoutMonitor = r0;
        r0.entry();
    }
}
