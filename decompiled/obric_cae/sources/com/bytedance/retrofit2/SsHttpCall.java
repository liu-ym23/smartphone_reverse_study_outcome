package com.bytedance.retrofit2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class SsHttpCall<T> implements Call<T>, IMetricsCollect, IRequestInfo {
    private static IHttpCallReqLevelControl sReqLevelControl;
    private static IHttpCallThrottleControl sThrottleControl;
    private long appCallTime;
    private final Object[] args;
    private final CallServerInterceptor callServerInterceptor;
    private int mReqControlLevel;
    private Request originalRequest;
    private Throwable preBuildURLException;
    private final ServiceMethod<T> serviceMethod;

    public interface IHttpCallReqLevelControl {
        int getRequestLevel(String r8);

        boolean isReqLevelControllerEnable();

        boolean maybeAddP1AsyncRequest(Executor r8, Runnable r10);

        void notifyRequestBack(int r8);

        void p1WaitP0Done();
    }

    public interface IHttpCallThrottleControl {
        int getDelayTimeByApp(String r8);

        int getDispatchDelayTime(String r8, String r10);

        boolean isAppDelayHandleEnable();

        boolean isDispatchDelayEnabled();
    }

    public SsHttpCall(ServiceMethod<T> r8, Object[] r10) {
        this.mReqControlLevel = -1;
        this.serviceMethod = r8;
        this.args = r10;
        this.callServerInterceptor = new CallServerInterceptor(r8);
    }

    public static /* synthetic */ Throwable access$000(SsHttpCall r8) {
        return r8.preBuildURLException;
    }

    public static /* synthetic */ Throwable access$002(SsHttpCall r8, Throwable r10) {
        r8.preBuildURLException = r10;
        return r10;
    }

    public static /* synthetic */ Request access$100(SsHttpCall r8) {
        return r8.originalRequest;
    }

    public static /* synthetic */ Request access$102(SsHttpCall r8, Request r10) {
        r8.originalRequest = r10;
        return r10;
    }

    public static /* synthetic */ Object[] access$200(SsHttpCall r8) {
        return r8.args;
    }

    public static /* synthetic */ ServiceMethod access$300(SsHttpCall r8) {
        return r8.serviceMethod;
    }

    public static /* synthetic */ IHttpCallReqLevelControl access$400() {
        return sReqLevelControl;
    }

    public static /* synthetic */ int access$500(SsHttpCall r8) {
        return r8.mReqControlLevel;
    }

    public static /* synthetic */ IHttpCallThrottleControl access$600() {
        return sThrottleControl;
    }

    public static void setReqLevelControl(IHttpCallReqLevelControl r8) {
        sReqLevelControl = r8;
    }

    public static void setThrottleControl(IHttpCallThrottleControl r8) {
        sThrottleControl = r8;
    }

    @Override // com.bytedance.retrofit2.Call
    public void cancel() {
        CallServerInterceptor r8 = this.callServerInterceptor;
        if (r8 == null) goto L6;
        r8.cancel();
        return;
    }

    @Override // com.bytedance.retrofit2.Call
    public /* bridge */ /* synthetic */ Call clone() {
        return clone();
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        CallServerInterceptor r8 = this.callServerInterceptor;
        if (r8 == null) goto L6;
        r8.doCollect();
        return;
    }

    @Override // com.bytedance.retrofit2.Call
    public void enqueue(final Callback<T> r8) {
        final RetrofitMetrics r10 = this.serviceMethod.getRetrofitMetrics();
        r10.enqueueTime = SystemClock.uptimeMillis();
        this.appCallTime = System.currentTimeMillis();
        if (r8 == null) goto L49;
        CallServerInterceptor r11 = this.callServerInterceptor;
        if (r11 != null) goto L7;
    L11:
        final Executor r12 = this.serviceMethod.httpExecutor;
        if ((r8 instanceof ExpandCallback) == false) goto L14;
        final ExpandCallback r13 = (ExpandCallback) r8;
    L15:
        final SsRunnable r14 = new AnonymousClass1(this, r10, r13, r8);
        this.originalRequest = this.serviceMethod.toRequest(null, this.args);     // Catch: IOException -> L18
    L20:
        IHttpCallReqLevelControl r15 = sReqLevelControl;
        if (r15 != null) goto L23;
    L37:
        IHttpCallThrottleControl r16 = sThrottleControl;
        if (r16 != null) goto L40;
    L46:
        r12.execute(r14);
        return;
    L40:
        if (r16.isAppDelayHandleEnable() == true) goto L44;
        if (sThrottleControl.isDispatchDelayEnabled() == false) goto L46;
    L44:
        if (this.mReqControlLevel != (-1)) goto L46;
        r12.execute(new AnonymousClass2(this, r13, r12, r14));
        return;
    L23:
        if (r15.isReqLevelControllerEnable() == false) goto L37;
        Request r17 = this.originalRequest;
        if (r17 == null) goto L37;
        if (TextUtils.isEmpty(r17.getPath()) == true) goto L37;
        int r18 = sReqLevelControl.getRequestLevel(this.originalRequest.getPath());
        this.mReqControlLevel = r18;
        if (r18 != 2) goto L33;
        cancel();
        r8.onFailure(this, new IOException("Canceled by Requset Controller"));
        return;
    L33:
        if (r18 != 1) goto L37;
        if (sReqLevelControl.maybeAddP1AsyncRequest(r12, r14) == false) goto L37;
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L14:
        r13 = null;
        goto L15
    L7:
        if (r11.isExecuted() == false) goto L11;
        throw new IllegalStateException("Already executed.");
    L49:
        throw new NullPointerException("callback == null");
    }

    @Override // com.bytedance.retrofit2.Call
    public SsResponse<T> execute() {
        RetrofitMetrics r8 = this.serviceMethod.getRetrofitMetrics();
        r8.executeTime = SystemClock.uptimeMillis();
        this.appCallTime = System.currentTimeMillis();
        r8.toRequestStartTime = SystemClock.uptimeMillis();
        this.originalRequest = this.serviceMethod.toRequest(null, this.args);
        r8.toRequestEndTime = SystemClock.uptimeMillis();
        IHttpCallReqLevelControl r10 = sReqLevelControl;
        if (r10 != null) goto L5;
    L16:
        IHttpCallThrottleControl r11 = sThrottleControl;
        if (r11 != null) goto L19;
    L39:
        SsResponse<T> r12 = getResponseWithInterceptorChain();
        IHttpCallReqLevelControl r13 = sReqLevelControl;
        if (r13 != null) goto L42;
    L44:
        return r12;
    L42:
        if (r13.isReqLevelControllerEnable() == false) goto L44;
        sReqLevelControl.notifyRequestBack(this.mReqControlLevel);
        goto L44
    L19:
        if (this.mReqControlLevel != (-1)) goto L39;
        int r14 = 0;
        if (r11.isAppDelayHandleEnable() == false) goto L28;
        Request r15 = this.originalRequest;
        if (r15 != null) goto L25;
    L38:
        long r16 = r14;
        r8.dispatchDelayTime = r16;
        Thread.sleep(r16);
        goto L39
    L25:
        if (TextUtils.isEmpty(r15.getPath()) == true) goto L38;
        r14 = sThrottleControl.getDelayTimeByApp(this.originalRequest.getPath());
        goto L38
    L28:
        if (sThrottleControl.isDispatchDelayEnabled() == false) goto L38;
        List<Header> r17 = this.originalRequest.headers("x-tt-request-tag");
        if (r17 != null) goto L32;
    L36:
        String r18 = "";
    L37:
        r14 = sThrottleControl.getDispatchDelayTime(this.originalRequest.getUrl(), r18);
        goto L38
    L32:
        if (r17.size() < 1) goto L36;
        if (TextUtils.isEmpty(r17.get(0).getValue()) == true) goto L36;
        r18 = r17.get(0).getValue();
        goto L37
    L5:
        if (r10.isReqLevelControllerEnable() == false) goto L16;
        Request r19 = this.originalRequest;
        if (r19 == null) goto L16;
        if (TextUtils.isEmpty(r19.getPath()) == true) goto L16;
        int r20 = sReqLevelControl.getRequestLevel(this.originalRequest.getPath());
        this.mReqControlLevel = r20;
        if (r20 == 2) goto L14;
        if (r20 != 1) goto L16;
        sReqLevelControl.p1WaitP0Done();
        goto L16
    L14:
        cancel();
        throw new IOException("Canceled by Requset Controller");
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        CallServerInterceptor r8 = this.callServerInterceptor;
        if (r8 != null) goto L5;
        return null;
    L5:
        return r8.getRequestInfo();
    }

    public SsResponse getResponseWithInterceptorChain() {
        RetrofitMetrics r8 = this.serviceMethod.getRetrofitMetrics();
        r8.responseChainTime = SystemClock.uptimeMillis();
        LinkedList r10 = new LinkedList();
        r10.addAll(this.serviceMethod.interceptors);
        r10.add(this.callServerInterceptor);
        r8.appLevelRequestStart = this.appCallTime;
        r8.beforeAllInterceptors = System.currentTimeMillis();
        this.originalRequest.setMetrics(r8);
        SsResponse r11 = new RealInterceptorChain(r10, 0, this.originalRequest, this, r8).proceed(this.originalRequest);
        r11.setRetrofitMetrics(r8);
        return r11;
    }

    public RetrofitMetrics getRetrofitMetrics() {
        return this.serviceMethod.getRetrofitMetrics();
    }

    @Override // com.bytedance.retrofit2.Call
    public boolean isCanceled() {
        CallServerInterceptor r8 = this.callServerInterceptor;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.isCanceled() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.retrofit2.Call
    public synchronized boolean isExecuted() {
        monitor-enter(this);
        CallServerInterceptor r8 = this.callServerInterceptor;     // Catch: Throwable -> L11
        if (r8 == null) goto L8;
        if (r8.isExecuted() == false) goto L8;
        boolean r10 = true;
    L9:
        monitor-exit(this);
        return r10;
    L8:
        r10 = false;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.retrofit2.Call
    public Request request() {
        CallServerInterceptor r8 = this.callServerInterceptor;
        if (r8 == null) goto L8;
        Request r10 = r8.request();
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (this.originalRequest != null) goto L17;
        RetrofitMetrics r11 = this.serviceMethod.getRetrofitMetrics();     // Catch: IOException -> L11 RuntimeException -> L14
        r11.toRequestStartTime = SystemClock.uptimeMillis();     // Catch: IOException -> L11 RuntimeException -> L14
        this.originalRequest = this.serviceMethod.toRequest(null, this.args);     // Catch: IOException -> L11 RuntimeException -> L14
        r11.toRequestEndTime = SystemClock.uptimeMillis();     // Catch: IOException -> L11 RuntimeException -> L14
    L11:
        e = move-exception;
        throw new RuntimeException("Unable to create request.", e);
    L14:
        e = move-exception;
        throw e;
    L17:
        return this.originalRequest;
    }

    public boolean setThrottleNetSpeed(long r8) {
        CallServerInterceptor r10 = this.callServerInterceptor;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.setThrottleNetSpeed(r8);
    }

    public T toResponseBody(TypedInput r8) {
        return this.serviceMethod.toResponse(r8);
    }

    @Override // com.bytedance.retrofit2.Call
    public SsHttpCall<T> clone() {
        return new SsHttpCall(this.serviceMethod, this.args);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m5clone() {
        return clone();
    }
}
