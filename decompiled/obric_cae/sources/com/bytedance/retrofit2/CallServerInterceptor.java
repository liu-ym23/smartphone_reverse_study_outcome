package com.bytedance.retrofit2;

import android.os.SystemClock;
import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class CallServerInterceptor<T> implements Interceptor, IMetricsCollect, IRequestInfo {
    private volatile boolean mCanceled;
    private Throwable mCreationFailure;
    private volatile boolean mExecuted;
    private Request mOriginalRequest;
    private volatile SsCall mRawCall;
    private final ServiceMethod<T> mServiceMethod;
    private volatile long mThrottleNetSpeed;

    public CallServerInterceptor(ServiceMethod<T> r8) {
        this.mServiceMethod = r8;
    }

    private SsCall createRawCall(ExpandCallback r8, Request r10) {
        return this.mServiceMethod.clientProvider.get().newSsCall(r10);
    }

    private Response executeCall(SsCall r8, RetrofitMetrics r10) {
        if (r10 == null) goto L5;
        r10.executeCallStartTime = SystemClock.uptimeMillis();
    L5:
        return r8.execute();
    }

    public void cancel() {
        this.mCanceled = true;
        if (this.mRawCall == null) goto L6;
        this.mRawCall.cancel();
        return;
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        if ((this.mRawCall instanceof IMetricsCollect) == false) goto L6;
        ((IMetricsCollect) this.mRawCall).doCollect();
        return;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        if ((this.mRawCall instanceof IRequestInfo) == false) goto L7;
        ((IRequestInfo) this.mRawCall).getRequestInfo();
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r10) {
        RetrofitMetrics r8 = r10.metrics();
        if (r8 == null) goto L5;
        r8.callServerInterceptorTime = System.currentTimeMillis();
    L5:
        Long r11 = Long.valueOf(SystemClock.uptimeMillis());
        this.mOriginalRequest = r10.request();
        monitor-enter(this);
    L55:
        th = move-exception;
        throw th;
    L8:
        if (this.mExecuted == true) goto L54;
        this.mExecuted = true;     // Catch: Throwable -> L55
        monitor-exit(this);     // Catch: Throwable -> L55
        Throwable r12 = this.mCreationFailure;
        if (r12 != null) goto L14;
        this.mOriginalRequest.setMetrics(r8);
        if (this.mServiceMethod.cacheServer == null) goto L24;
        if (r8 == null) goto L23;
        r8.requestInterceptDuration.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r11.longValue()));
    L23:
        Response r13 = this.mServiceMethod.cacheServer.getCacheResponse(this.mOriginalRequest);
    L25:
        if (r13 == null) goto L59;
    L49:
        long r14 = SystemClock.uptimeMillis();
        SsResponse<T> r15 = parseResponse(r13, r8);
        if (r8 == null) goto L52;
        r8.responseInterceptDuration.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r14));
    L52:
        return r15;
    L59:
        this.mRawCall = createRawCall(null, this.mOriginalRequest);     // Catch: Throwable -> L39 Throwable -> L46
        if (this.mThrottleNetSpeed <= 0) goto L30;
        this.mRawCall.setThrottleNetSpeed(this.mThrottleNetSpeed);     // Catch: Throwable -> L39 Throwable -> L46
    L30:
        if (this.mCanceled == false) goto L32;
        this.mRawCall.cancel();
    L32:
        if (r8 == null) goto L34;
        r8.requestInterceptDuration.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r11.longValue()));
    L34:
        r13 = executeCall(this.mRawCall, r8);
        ICacheServer r16 = this.mServiceMethod.cacheServer;
        if (r16 == null) goto L49;
        Response r17 = r16.putCacheResponse(this.mOriginalRequest, r13);
        if (r17 == null) goto L49;
        r13 = r17;
    L46:
        e = move-exception;
        this.mCreationFailure = e;
        throw e;
    L39:
        th = move-exception;
        this.mCreationFailure = th;
        if ((th instanceof Exception) == false) goto L45;
        throw th;
    L45:
        throw new Exception(th);
    L24:
        r13 = null;
        goto L25
    L14:
        if ((r12 instanceof IOException) == false) goto L18;
        throw ((IOException) r12);
    L18:
        throw new Exception(this.mCreationFailure);
    L54:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L55
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r8 = this.mExecuted;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    public SsResponse<T> parseResponse(Response r8, RetrofitMetrics r10) {
        if (r8 == null) goto L25;
        TypedInput r11 = r8.getBody();
        int r12 = r8.getStatus();
        if (r12 < 200) goto L23;
        if (r12 >= 300) goto L23;
        if (r12 == 204) goto L21;
        if (r12 == 205) goto L21;
        if (r10 == null) goto L15;
        r10.toResponseStartTime = SystemClock.uptimeMillis();
    L15:
        T r13 = this.mServiceMethod.toResponse(r11);
        if (r10 == null) goto L19;
        r10.toResponseEndTime = SystemClock.uptimeMillis();
    L19:
        return SsResponse.success(r13, r8);
    L21:
        return SsResponse.success(null, r8);
    L23:
        return SsResponse.error(r11, r8);
    L25:
        throw new IOException("SsResponse is null");
    }

    public Request request() {
        return this.mOriginalRequest;
    }

    public synchronized void resetExecuted() {
        monitor-enter(this);
        this.mExecuted = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean setThrottleNetSpeed(long r8) {
        this.mThrottleNetSpeed = r8;
        if (this.mRawCall != null) goto L5;
        return false;
    L5:
        return this.mRawCall.setThrottleNetSpeed(r8);
    }
}
