package com.bytedance.retrofit2;

import android.util.Log;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.ttnet.TTInternalInterceptor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CallServerInterceptor<T> implements IMetricsCollect, IRequestInfo, TTInternalInterceptor {
    private volatile boolean mCanceled;
    private Throwable mCreationFailure;
    private volatile boolean mExecuted;
    private Request mOriginalRequest;
    private volatile SsCall mRawCall;
    private final RequestFactory<T> mRequestFactory;
    private volatile long mThrottleNetSpeed;

    public CallServerInterceptor(RequestFactory<T> r1) {
        this.mRequestFactory = r1;
    }

    private SsCall createRawCall(Request r1) {
        return this.mRequestFactory.clientProvider.get().newSsCall(r1);
    }

    private Response executeCall(SsCall r2) {
        return ((SsCall) ZeusTransformUtils.wrapperContextForParams(r2, SsCall.class, "com.obric.memorydata.plugin")).execute();
    }

    public void cancel() {
        this.mCanceled = true;
        if (this.mRawCall == null) goto L6;
        this.mRawCall.cancel();
        return;
    }

    public void cancelNormalRequest(boolean r1, Throwable r2, boolean r3) {
        cancel();
        this.mCanceled = r1;
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        if (ZeusTransformUtils.instanceOf(this.mRawCall, IRequestInfo.class) == true) goto L5;
        return null;
    L5:
        return ((IRequestInfo) ZeusTransformUtils.preCheckCast(this.mRawCall, IRequestInfo.class, "com.obric.memorydata.plugin")).getRequestInfo();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r7) {
        Request r8 = ((Interceptor.Chain) ZeusTransformUtils.wrapperContextForParams(r7, Interceptor.Chain.class, "com.obric.memorydata.plugin")).request();
        this.mOriginalRequest = r8;
        r8.getMetrics().callServerInterceptorStart();
        this.mOriginalRequest.getMetrics().setPriorityLevel(this.mOriginalRequest.getPriorityLevel());
        RetrofitMetrics r9 = this.mOriginalRequest.getMetrics();
        r9.requestPriorityLevel = this.mOriginalRequest.getRequestPriorityLevel();
        monitor-enter(this);
    L60:
        th = move-exception;
        throw th;
    L5:
        if (this.mExecuted == true) goto L59;
        this.mExecuted = true;     // Catch: Throwable -> L60
        monitor-exit(this);     // Catch: Throwable -> L60
        Throwable r0 = this.mCreationFailure;
        if (r0 != null) goto L11;
        Response r1 = null;
        if (this.mRequestFactory.cacheServer == null) goto L19;
        r1 = this.mRequestFactory.cacheServer.getCacheResponse(this.mOriginalRequest);
    L19:
        if (r1 == null) goto L22;
        this.mOriginalRequest.getMetrics().recordInterceptorRequestEnd();
        this.mOriginalRequest.getMetrics().lowestInterceptorRequestEnd();
    L22:
        if (r1 == null) goto L66;
    L53:
        List<Header> r10 = r1.headers("content-encoding");
        if (r10 == null) goto L57;
        RetrofitMetrics r2 = this.mOriginalRequest.getMetrics();
        r2.responseCompressType = ((Header) ZeusTransformUtils.preCheckCast(r10.get(0), Header.class, "com.obric.memorydata.plugin")).getValue();
    L57:
        return parseResponse(r1, this.mOriginalRequest.getMetrics());
    L66:
        this.mRawCall = createRawCall(this.mOriginalRequest);     // Catch: Throwable -> L43 Throwable -> L50
        if (this.mThrottleNetSpeed <= 0) goto L27;
        this.mRawCall.setThrottleNetSpeed(this.mThrottleNetSpeed);     // Catch: Throwable -> L43 Throwable -> L50
    L27:
        if (this.mCanceled == false) goto L29;
        this.mRawCall.cancel();
    L29:
        List<Header> r3 = this.mOriginalRequest.headers("content-encoding");
        if (r3 != null) goto L32;
    L63:
        this.mOriginalRequest.getMetrics().recordInterceptorRequestEnd();     // Catch: Throwable -> L40
        this.mOriginalRequest.getMetrics().lowestInterceptorRequestEnd();     // Catch: Throwable -> L40
        this.mOriginalRequest.getMetrics().executeSsCallStart();     // Catch: Throwable -> L40
        r1 = executeCall(this.mRawCall);     // Catch: Throwable -> L40
        this.mOriginalRequest.getMetrics().executeSsCallEnd();
        this.mOriginalRequest.getMetrics().lowestInterceptorResponseStart();
        this.mOriginalRequest.getMetrics().recordInterceptorResponseStart(this);
        this.mOriginalRequest.getMetrics().retrofit.misc.executeSsCallSuccess = true;
        if (this.mRequestFactory.cacheServer == null) goto L53;
        Response r11 = this.mRequestFactory.cacheServer.putCacheResponse(this.mOriginalRequest, r1);
        if (r11 == null) goto L53;
        r1 = r11;
    L40:
        th = move-exception;
        this.mOriginalRequest.getMetrics().executeSsCallEnd();
        this.mOriginalRequest.getMetrics().lowestInterceptorResponseStart();
        this.mOriginalRequest.getMetrics().recordInterceptorResponseStart(this);
        throw th;
    L32:
        if (r3.size() <= 0) goto L63;
        RetrofitMetrics r4 = this.mOriginalRequest.getMetrics();
        r4.requestCompressType = ((Header) ZeusTransformUtils.preCheckCast(this.mOriginalRequest.headers("content-encoding").get(0), Header.class, "com.obric.memorydata.plugin")).getValue();
    L50:
        e = move-exception;
        this.mCreationFailure = e;
        throw e;
    L43:
        th = move-exception;
        this.mCreationFailure = th;
        if (ZeusTransformUtils.instanceOf(th, Exception.class) == false) goto L49;
        throw ((Exception) ZeusTransformUtils.preCheckCast(th, Exception.class, "com.obric.memorydata.plugin"));
    L49:
        throw new Exception(th);
    L11:
        if (ZeusTransformUtils.instanceOf(r0, IOException.class) == false) goto L15;
        throw ((IOException) ZeusTransformUtils.preCheckCast(this.mCreationFailure, IOException.class, "com.obric.memorydata.plugin"));
    L15:
        throw new Exception(this.mCreationFailure);
    L59:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L60
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r0 = this.mExecuted;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    SsResponse<T> parseResponse(Response r4, RetrofitMetrics r5) {
        if (r4 == null) goto L36;
        TypedInput r0 = r4.getBody();
        int r1 = r4.getStatus();
        if (r1 < 200) goto L34;
        if (r1 >= 300) goto L34;
        if (r1 == 204) goto L32;
        if (r1 == 205) goto L32;
        if (r5 == null) goto L38;
        r5.toSsResponseStart();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r5 == null) goto L29;
        r5.responseConvertSuccess = false;
    L29:
        Log.i("ToResponseLog", "toResponse failed");
        throw th;
    L38:
        T r3 = this.mRequestFactory.toResponse(r0);     // Catch: Throwable -> L23
        if (r5 == null) goto L22;
        r5.toSsResponseEnd();     // Catch: Throwable -> L16
    L22:
        return SsResponse.success(r3, r4);
    L23:
        th = move-exception;
        if (r5 == null) goto L26;
        r5.toSsResponseEnd();     // Catch: Throwable -> L16
    L26:
        throw th;     // Catch: Throwable -> L16
    L32:
        return SsResponse.success(null, r4);
    L34:
        return SsResponse.error(r0, r4);
    L36:
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

    public boolean setThrottleNetSpeed(long r2) {
        this.mThrottleNetSpeed = r2;
        if (this.mRawCall != null) goto L5;
        return false;
    L5:
        return this.mRawCall.setThrottleNetSpeed(r2);
    }
}
