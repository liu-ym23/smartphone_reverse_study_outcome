package com.bytedance.retrofit2;

import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.IInterceptorProperty;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class SsHttpCall<T> implements Call<T>, IMetricsCollect, IRequestInfo {
    private static ICustomInterceptorControl sCustomInterceptorControl;
    private static IHttpCallPriorityControl sPriorityControl;
    private static IRequestFlagHandler sRequestFlagHandler;
    private static IHttpCallThrottleControl sThrottleControl;
    private final Object[] args;
    private final CallServerInterceptor callServerInterceptor;
    private Request delayRequest;
    private final RetrofitMetrics metrics;
    private Request originalRequest;
    private Throwable requestException;
    private final RequestFactory<T> requestFactory;

    class AsyncRequestRunnable implements SsRunnable {
        private final Callback<T> callback;
        private final ExpandCallback expandCallback;
        final /* synthetic */ SsHttpCall this$0;

        AsyncRequestRunnable(SsHttpCall r3, Callback<T> r4) {
            Callback<T> r5 = (Callback) ZeusTransformUtils.wrapperContextForParams(r4, Callback.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.callback = r5;
            if (ZeusTransformUtils.instanceOf(r5, ExpandCallback.class) == false) goto L5;
            ExpandCallback r6 = (ExpandCallback) ZeusTransformUtils.preCheckCast(r5, ExpandCallback.class, "com.obric.memorydata.plugin");
        L6:
            this.expandCallback = r6;
            return;
        L5:
            r6 = null;
            goto L6
        }

        private void callFailure(Throwable r2) {
            this.callback.onFailure(this.this$0, r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        private void callSuccess(SsResponse<T> r3) {
            this.callback.onResponse(this.this$0, r3);     // Catch: Throwable -> L6
            ExpandCallback r0 = this.expandCallback;     // Catch: Throwable -> L6
            if (r0 == null) goto L11;
            r0.onAsyncResponse(this.this$0, r3);     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public int getRequestDelayTime() {
            return 0;
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public RetrofitMetrics getRetrofitMetrics() {
            return this.this$0.getRetrofitMetrics();
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public boolean isStreaming() {
            return SsHttpCall.access$800(this.this$0).booleanValue();
        }

        @Override // com.bytedance.retrofit2.SsRunnable
        public int priority() {
            if (SsHttpCall.access$400() == null) goto L9;
            int r0 = SsHttpCall.access$400().getPriorityInContext(SsHttpCall.access$500(this.this$0));
            if (r0 == (-999)) goto L9;
        L6:
            SsHttpCall.access$000(this.this$0).setPriorityLevel(r0);
            return r0;
        L9:
            if (SsHttpCall.access$600() != null) goto L11;
        L13:
            Request r1 = SsHttpCall.access$500(this.this$0);
            SsHttpCall r3 = this.this$0;
            if (r1 == null) goto L18;
            return SsHttpCall.access$500(r3).getPriorityLevel();
        L18:
            return SsHttpCall.access$700(r3).priorityLevel;
        L11:
            if (SsHttpCall.access$500(this.this$0) == null) goto L13;
            r0 = SsHttpCall.access$600().getPriority(SsHttpCall.access$500(this.this$0).getPath(), SsHttpCall.access$700(this.this$0).priorityLevel);
            goto L6
        }

        @Override // java.lang.Runnable
        public void run() {
            SsHttpCall.access$000(this.this$0).requestRealStart();     // Catch: Throwable -> L15
            SsResponse r0 = this.this$0.getResponseWithInterceptorChain();     // Catch: Throwable -> L15
            if (SsHttpCall.access$200() == null) goto L6;
            SsHttpCall.access$200().notifyRequestCompleted(SsHttpCall.access$300(this.this$0));
        L6:
            SsHttpCall.access$000(this.this$0).bizReceiveResponseHeader();
            SsHttpCall.access$000(this.this$0).enqueueCallbackStart();
        L12:
            th = move-exception;
            SsHttpCall.access$000(this.this$0).enqueueCallbackEnd();
            throw th;
        L8:
            if (SsHttpCall.access$100(this.this$0) == null) goto L10;
            callFailure(SsHttpCall.access$100(this.this$0));     // Catch: Throwable -> L12
        L53:
        L11:
            SsHttpCall.access$000(this.this$0).enqueueCallbackEnd();
            SsHttpCall.access$000(this.this$0).markRetrofitLayerLogCollected();
            return;
        L10:
            callSuccess(r0);     // Catch: Throwable -> L12
        L15:
            th = move-exception;
            SsHttpCall.access$102(this.this$0, th);     // Catch: Throwable -> L31
            RetrofitLayerMetrics.Misc r2 = SsHttpCall.access$000(this.this$0).retrofit.misc;     // Catch: Throwable -> L31
            r2.requestException = new WeakReference(th);     // Catch: Throwable -> L31
            if (SsHttpCall.access$200() == null) goto L21;
            SsHttpCall.access$200().notifyRequestCompleted(SsHttpCall.access$300(this.this$0));
        L21:
            SsHttpCall.access$000(this.this$0).bizReceiveResponseHeader();
            SsHttpCall.access$000(this.this$0).enqueueCallbackStart();
        L28:
            th = move-exception;
            SsHttpCall.access$000(this.this$0).enqueueCallbackEnd();
            throw th;
        L23:
            if (SsHttpCall.access$100(this.this$0) == null) goto L25;
            callFailure(SsHttpCall.access$100(this.this$0));     // Catch: Throwable -> L28
        L50:
            goto L11
        L25:
            callSuccess(null);     // Catch: Throwable -> L28
        L31:
            th = move-exception;
            if (SsHttpCall.access$200() == null) goto L35;
            SsHttpCall.access$200().notifyRequestCompleted(SsHttpCall.access$300(this.this$0));
        L35:
            SsHttpCall.access$000(this.this$0).bizReceiveResponseHeader();
            SsHttpCall.access$000(this.this$0).enqueueCallbackStart();
        L42:
            th = move-exception;
            SsHttpCall.access$000(this.this$0).enqueueCallbackEnd();
            throw th;
        L37:
            if (SsHttpCall.access$100(this.this$0) == null) goto L39;
            callFailure(SsHttpCall.access$100(this.this$0));     // Catch: Throwable -> L42
        L40:
            SsHttpCall.access$000(this.this$0).enqueueCallbackEnd();
            SsHttpCall.access$000(this.this$0).markRetrofitLayerLogCollected();
            throw th;
        L39:
            callSuccess(null);     // Catch: Throwable -> L42
            goto L40
        }
    }

    public interface ICustomInterceptorControl {
        List<Interceptor> getInterceptors(Request r1, List<Interceptor> r2);
    }

    public interface IHttpCallPriorityControl {
        int getPriority(String r1, int r2);
    }

    public interface IRequestFlagHandler {
        int getPriorityInContext(Request r1);

        Request handleFlag(Request r1);

        boolean shouldBypassInterceptor(Request r1);

        boolean shouldUseCustomInterceptor(Request r1);
    }

    SsHttpCall(RequestFactory<T> r2, Object[] r3) {
        this.delayRequest = null;
        this.requestException = null;
        this.requestFactory = r2;
        this.args = r3;
        this.callServerInterceptor = new CallServerInterceptor(r2);
        RetrofitMetrics r4 = r2.getRetrofitMetrics().cloneMetrics();
        this.metrics = r4;
        r4.bizInvokeRetrofitRequestInterfaceEnd();
    }

    static /* synthetic */ RetrofitMetrics access$000(SsHttpCall r0) {
        return r0.metrics;
    }

    static /* synthetic */ Throwable access$100(SsHttpCall r0) {
        return r0.requestException;
    }

    static /* synthetic */ Throwable access$102(SsHttpCall r0, Throwable r1) {
        r0.requestException = r1;
        return r1;
    }

    static /* synthetic */ IHttpCallThrottleControl access$200() {
        return sThrottleControl;
    }

    static /* synthetic */ Request access$300(SsHttpCall r0) {
        return r0.delayRequest;
    }

    static /* synthetic */ IRequestFlagHandler access$400() {
        return sRequestFlagHandler;
    }

    static /* synthetic */ Request access$500(SsHttpCall r0) {
        return r0.originalRequest;
    }

    static /* synthetic */ IHttpCallPriorityControl access$600() {
        return sPriorityControl;
    }

    static /* synthetic */ RequestFactory access$700(SsHttpCall r0) {
        return r0.requestFactory;
    }

    static /* synthetic */ Boolean access$800(SsHttpCall r0) {
        return r0.isStreaming();
    }

    private Request addDebugMetricsInfoToRequest(Request r5) {
        if (r5.getMetrics().stateDelayTime < 0) goto L6;
        Request.Builder r4 = r5.newBuilder();
        ArrayList r0 = new ArrayList();
        r0.addAll(r5.getHeaders());
        r0.add(new Header("state-delay", String.valueOf(r5.getMetrics().stateDelayTime)));
        r4.headers(r0);
        return r4.build();
    L6:
        return r5;
    }

    private static void appendBypassPureModeInterceptors(List<Interceptor> r3, List<Interceptor> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L23;
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L24;
        Interceptor r0 = (Interceptor) ZeusTransformUtils.preCheckCast(r7.next(), Interceptor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, IInterceptorProperty.class) == false) goto L9;
        if (((IInterceptorProperty) ZeusTransformUtils.preCheckCast(r0, IInterceptorProperty.class, "com.obric.memorydata.plugin")).shouldRunInPureMode() == false) goto L9;
        r5.add(r0);
        goto L9
    L24:
        return;
    }

    private List<Interceptor> constructInterceptorList() {
        LinkedList r0 = new LinkedList();
        IRequestFlagHandler r1 = sRequestFlagHandler;
        if (r1 == null) goto L6;
        this.originalRequest = r1.handleFlag(this.originalRequest);
    L6:
        if (sCustomInterceptorControl == null) goto L15;
        IRequestFlagHandler r2 = sRequestFlagHandler;
        if (r2 == null) goto L15;
        if (r2.shouldUseCustomInterceptor(this.originalRequest) == false) goto L15;
        List<Interceptor> r3 = sCustomInterceptorControl.getInterceptors(this.originalRequest, this.requestFactory.interceptors);
        if (r3 != null) goto L17;
    L21:
        r0.add(this.callServerInterceptor);
        return r0;
    L17:
        r0.addAll(r3);
    L15:
        if (shouldAddInterceptors(this.originalRequest) == false) goto L19;
        r3 = this.requestFactory.interceptors;
        goto L17
    L19:
        if (this.originalRequest.isPureRequest() == false) goto L21;
        appendBypassPureModeInterceptors(r0, this.requestFactory.interceptors);
        goto L21
    }

    private synchronized void ensureOriginalRequestCreated() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.originalRequest == null) goto L22;
        monitor-exit(this);
        return;
    L22:
        this.metrics.toRequestStart();     // Catch: IOException -> L16 Throwable -> L19
        this.originalRequest = this.requestFactory.toRequest(null, this.args);     // Catch: IOException -> L16 Throwable -> L19
        this.metrics.toRequestEnd();     // Catch: IOException -> L16 Throwable -> L19
        Request r0 = this.originalRequest;     // Catch: IOException -> L16 Throwable -> L19
        if (r0 == null) goto L15;
        r0.setMetrics(this.metrics);     // Catch: IOException -> L16 Throwable -> L19
        if (Logger.debug() == false) goto L12;
        Logger.d("ToRequestLog", "originalRequest build success, path: " + this.originalRequest.getPath());     // Catch: IOException -> L16 Throwable -> L19
    L12:
        monitor-exit(this);
        return;
    L15:
        throw new RuntimeException("Unable to create request.");     // Catch: IOException -> L16 Throwable -> L19
    L16:
        e = move-exception;
        throw new RuntimeException("Unable to create request.", e);     // Catch: Throwable -> L19
    }

    private Boolean isStreaming() {
        return Boolean.valueOf(this.requestFactory.isResponseStreaming);
    }

    public static void setCustomInterceptorControl(ICustomInterceptorControl r2) {
        sCustomInterceptorControl = (ICustomInterceptorControl) ZeusTransformUtils.wrapperContextForParams(r2, ICustomInterceptorControl.class, "com.obric.memorydata.plugin");
    }

    public static void setPriorityControl(IHttpCallPriorityControl r2) {
        sPriorityControl = (IHttpCallPriorityControl) ZeusTransformUtils.wrapperContextForParams(r2, IHttpCallPriorityControl.class, "com.obric.memorydata.plugin");
    }

    public static void setRequestFlagHandler(IRequestFlagHandler r2) {
        sRequestFlagHandler = (IRequestFlagHandler) ZeusTransformUtils.wrapperContextForParams(r2, IRequestFlagHandler.class, "com.obric.memorydata.plugin");
    }

    public static void setThrottleControl(IHttpCallThrottleControl r2) {
        sThrottleControl = (IHttpCallThrottleControl) ZeusTransformUtils.wrapperContextForParams(r2, IHttpCallThrottleControl.class, "com.obric.memorydata.plugin");
    }

    private boolean shouldAddInterceptors(Request r3) {
        if (r3.isPureRequest() == false) goto L5;
        return false;
    L5:
        IRequestFlagHandler r2 = sRequestFlagHandler;
        if (r2 == null) goto L10;
        if (r2.shouldBypassInterceptor(r3) == false) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.retrofit2.Call
    public void cancel() {
        CallServerInterceptor r0 = this.callServerInterceptor;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Deprecated
    public void cancelNormalRequest(boolean r1, Throwable r2, boolean r3) {
        CallServerInterceptor r0 = this.callServerInterceptor;
        if (r0 == null) goto L6;
        r0.cancelNormalRequest(r1, r2, r3);
        return;
    }

    @Override // com.bytedance.retrofit2.Call
    public /* bridge */ /* synthetic */ Call clone() {
        return clone();
    }

    @Override // com.bytedance.retrofit2.Call
    public SsHttpCall<T> clone() {
        return new SsHttpCall(this.requestFactory, this.args);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m115clone() {
        return clone();
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
    }

    @Override // com.bytedance.retrofit2.Call
    public void enqueue(Callback<T> r5) {
        Callback r6 = (Callback) ZeusTransformUtils.wrapperContextForParams(r5, Callback.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r6, "callback == null");
        if (isExecuted() == true) goto L36;
        this.metrics.ssHttpCallApiStart(true);
        AsyncRequestRunnable r0 = new AsyncRequestRunnable(this, r6);
        ensureOriginalRequestCreated();     // Catch: Throwable -> L17
        IHttpCallThrottleControl r1 = sThrottleControl;     // Catch: Throwable -> L17
        if (r1 == null) goto L13;
        Request r2 = r1.setOriginalRequestProperties(this.originalRequest);     // Catch: Throwable -> L17
        this.originalRequest = r2;     // Catch: Throwable -> L17
        this.delayRequest = r2;     // Catch: Throwable -> L17
        if (sThrottleControl.maybeDropRequestOrAsyncDelay(r2, this.requestFactory.httpExecutor, r0) == false) goto L13;
        this.metrics.ssHttpCallApiEnd();
        if (this.requestException == null) goto L42;
        this.metrics.markNetworkKernelLogCollected();
        this.metrics.markRetrofitLayerLogCollected();
        return;
    L42:
        return;
    L13:
        this.requestFactory.httpExecutor.execute(r0);     // Catch: Throwable -> L17
        this.metrics.ssHttpCallApiEnd();
        if (this.requestException == null) goto L26;
    L16:
        this.metrics.markNetworkKernelLogCollected();
        this.metrics.markRetrofitLayerLogCollected();
        return;
    L26:
        return;
    L17:
        th = move-exception;
        this.requestException = th;     // Catch: Throwable -> L30
        th.printStackTrace();     // Catch: Throwable -> L30
        RetrofitLayerMetrics.Misc r3 = this.metrics.retrofit.misc;     // Catch: Throwable -> L30
        r3.requestException = new WeakReference(th);     // Catch: Throwable -> L30
        this.metrics.enqueueCallbackStart();     // Catch: Throwable -> L30
        r6.onFailure(this, th);     // Catch: Throwable -> L27
        this.metrics.enqueueCallbackEnd();     // Catch: Throwable -> L30
        IHttpCallThrottleControl r7 = sThrottleControl;     // Catch: Throwable -> L30
        if (r7 == null) goto L23;
        r7.notifyRequestCompleted(this.delayRequest);     // Catch: Throwable -> L30
    L23:
        this.metrics.ssHttpCallApiEnd();
        if (this.requestException != null) goto L16;
        return;
    L27:
        th = move-exception;
        this.metrics.enqueueCallbackEnd();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        this.metrics.ssHttpCallApiEnd();
        if (this.requestException == null) goto L34;
        this.metrics.markNetworkKernelLogCollected();
        this.metrics.markRetrofitLayerLogCollected();
    L34:
        throw th;
    L36:
        throw new IllegalStateException("Already executed.");
    }

    @Override // com.bytedance.retrofit2.Call
    @Deprecated
    public SsResponse<T> execute() {
        this.metrics.ssHttpCallApiStart(false);
        ensureOriginalRequestCreated();
        IHttpCallThrottleControl r0 = sThrottleControl;     // Catch: Throwable -> L12
        if (r0 == null) goto L6;
        Request r1 = r0.setOriginalRequestProperties(this.originalRequest);     // Catch: Throwable -> L12
        this.originalRequest = r1;     // Catch: Throwable -> L12
        this.delayRequest = r1;     // Catch: Throwable -> L12
        sThrottleControl.maybeDropRequestOrBlockingDelay(r1);     // Catch: Throwable -> L12
    L6:
        this.metrics.requestRealStart();     // Catch: Throwable -> L12
        SsResponse<T> r2 = getResponseWithInterceptorChain();     // Catch: Throwable -> L12
        IHttpCallThrottleControl r3 = sThrottleControl;
        if (r3 == null) goto L10;
        r3.notifyRequestCompleted(this.delayRequest);
    L10:
        this.metrics.bizReceiveResponseHeader();
        this.metrics.ssHttpCallApiEnd();
        this.metrics.markRetrofitLayerLogCollected();
        return r2;
    L12:
        th = move-exception;
        this.requestException = th;     // Catch: Throwable -> L15
        RetrofitLayerMetrics.Misc r4 = this.metrics.retrofit.misc;     // Catch: Throwable -> L15
        r4.requestException = new WeakReference(th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        IHttpCallThrottleControl r5 = sThrottleControl;
        if (r5 == null) goto L19;
        r5.notifyRequestCompleted(this.delayRequest);
    L19:
        this.metrics.bizReceiveResponseHeader();
        this.metrics.ssHttpCallApiEnd();
        this.metrics.markRetrofitLayerLogCollected();
        throw th;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        CallServerInterceptor r0 = this.callServerInterceptor;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getRequestInfo();
    }

    SsResponse getResponseWithInterceptorChain() {
        if (Logger.debug() == false) goto L5;
        Logger.d("SsHttpCall", "real send " + this.originalRequest.getPath());
    L5:
        List<Interceptor> r0 = constructInterceptorList();
        if (Logger.debug() == false) goto L8;
        this.originalRequest = addDebugMetricsInfoToRequest(this.originalRequest);
    L8:
        RealInterceptorChain r1 = new RealInterceptorChain(r0, 0, this.originalRequest, this);
        if (RealInterceptorChain.isProceedWithoutHookEnabled() == false) goto L11;
        SsResponse r2 = r1.proceedWithoutHook(this.originalRequest);
    L12:
        r2.setRetrofitMetrics(this.metrics);
        return r2;
    L11:
        r2 = r1.proceed(this.originalRequest);
        goto L12
    }

    public RetrofitMetrics getRetrofitMetrics() {
        return this.metrics;
    }

    @Override // com.bytedance.retrofit2.Call
    public boolean isCanceled() {
        CallServerInterceptor r0 = this.callServerInterceptor;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCanceled() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.retrofit2.Call
    public synchronized boolean isExecuted() {
        monitor-enter(this);
        CallServerInterceptor r0 = this.callServerInterceptor;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        if (r0.isExecuted() == false) goto L8;
        boolean r1 = true;
    L9:
        monitor-exit(this);
        return r1;
    L8:
        r1 = false;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.retrofit2.Call
    public Request request() {
        CallServerInterceptor r0 = this.callServerInterceptor;
        if (r0 == null) goto L7;
        Request r1 = r0.request();
        if (r1 == null) goto L7;
        return r1;
    L7:
        ensureOriginalRequestCreated();
        return this.originalRequest;
    }

    public boolean setThrottleNetSpeed(long r1) {
        CallServerInterceptor r0 = this.callServerInterceptor;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.setThrottleNetSpeed(r1);
    }

    public T toResponseBody(TypedInput r3) {
        TypedInput r4 = (TypedInput) ZeusTransformUtils.wrapperContextForParams(r3, TypedInput.class, "com.obric.memorydata.plugin");
        return this.requestFactory.toResponse(r4);
    }
}
