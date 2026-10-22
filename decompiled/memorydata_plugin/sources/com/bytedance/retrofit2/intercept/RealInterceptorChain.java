package com.bytedance.retrofit2.intercept;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallServerInterceptor;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RealInterceptorChain implements Interceptor.Chain {
    private static volatile boolean proceedWithoutHookEnabled = false;
    private static boolean sLogObjectRefineEnabled = false;
    private final Call call;
    private int calls;
    private final int index;
    private final List<Interceptor> interceptors;
    private final Request prevRequest;

    static {
    }

    public RealInterceptorChain(List<Interceptor> r3, int r4, Request r5, Call r6) {
        List<Interceptor> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Call r8 = (Call) ZeusTransformUtils.wrapperContextForParams(r6, Call.class, "com.obric.memorydata.plugin");
        this.interceptors = r7;
        this.index = r4;
        this.prevRequest = r5;
        this.call = r8;
    }

    public static boolean isProceedWithoutHookEnabled() {
        return proceedWithoutHookEnabled;
    }

    public static void setLogObjectRefineEnabled(boolean r0) {
        sLogObjectRefineEnabled = r0;
    }

    public static void setProceedWithoutHookEnabled(boolean r0) {
        proceedWithoutHookEnabled = r0;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public RetrofitMetrics metrics() {
        return this.prevRequest.getMetrics();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public SsResponse proceed(Request r8) {
        r8.setMetrics(this.prevRequest.getMetrics());
        if (r8.getMetrics() == null) goto L6;
        r8.getMetrics().recordInterceptorRequestEnd();
    L6:
        if (this.index >= this.interceptors.size()) goto L58;
        int r0 = this.calls + 1;
        this.calls = r0;
        if (r0 <= 1) goto L15;
        Iterator<Interceptor> r1 = this.interceptors.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        Interceptor r3 = (Interceptor) ZeusTransformUtils.preCheckCast(r1.next(), Interceptor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, CallServerInterceptor.class) == false) goto L11;
        ((CallServerInterceptor) ZeusTransformUtils.preCheckCast(r3, CallServerInterceptor.class, "com.obric.memorydata.plugin")).resetExecuted();
    L15:
        RealInterceptorChain r2 = new RealInterceptorChain(this.interceptors, this.index + 1, r8, this.call);
        Interceptor r4 = (Interceptor) ZeusTransformUtils.preCheckCast(this.interceptors.get(this.index), Interceptor.class, "com.obric.memorydata.plugin");
        if (sLogObjectRefineEnabled == true) goto L23;
        StringBuilder r5 = new StringBuilder().append("interceptor = ");
        if (r4 == null) goto L20;
        String r6 = r4.toString();
    L21:
        RetrofitLogger.d("RealInterceptorChain", r5.append(r6).append(" url = ").append(r8.getUrl()).toString());
        goto L23
    L20:
        r6 = "";
    L23:
        if (r4 == null) goto L56;
        if (r8.getMetrics() == null) goto L60;
        r8.getMetrics().recordInterceptorRequestStart(r4);
        r8.getMetrics().beforeInterceptorExecute(r4);
    L60:
        SsResponse r7 = r4.intercept(r2);     // Catch: Throwable -> L43 Exception -> L45
        if (r7 == null) goto L42;
        if (r7.raw() == null) goto L40;
        if (r8.getMetrics() == null) goto L38;
        r8.getMetrics().recordInterceptorResponseEnd(null);
        if (this.index <= 0) goto L37;
        r8.getMetrics().recordInterceptorResponseStart((Interceptor) ZeusTransformUtils.preCheckCast(this.interceptors.get(this.index - 1), Interceptor.class, "com.obric.memorydata.plugin"));
    L37:
        request().getMetrics().afterInterceptorExecute(null);
    L38:
        return r7;
    L40:
        throw new IllegalStateException("interceptor " + r4 + " returned a ssResponse with no body");     // Catch: Throwable -> L43 Exception -> L45
    L42:
        throw new NullPointerException("interceptor " + r4 + " returned null");     // Catch: Throwable -> L43 Exception -> L45
    L45:
        e = move-exception;
        throw e;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if (r8.getMetrics() == null) goto L54;
        r8.getMetrics().recordInterceptorResponseEnd(null);
        if (this.index <= 0) goto L53;
        r8.getMetrics().recordInterceptorResponseStart((Interceptor) ZeusTransformUtils.preCheckCast(this.interceptors.get(this.index - 1), Interceptor.class, "com.obric.memorydata.plugin"));
    L53:
        request().getMetrics().afterInterceptorExecute(null);
    L54:
        throw th;
    L56:
        throw new NullPointerException("interceptor " + this.index + " is null");
    L58:
        throw new AssertionError();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public SsResponse proceedWithoutHook(Request r8) {
        r8.setMetrics(this.prevRequest.getMetrics());
        if (r8.getMetrics() == null) goto L6;
        r8.getMetrics().recordInterceptorRequestEnd();
    L6:
        if (this.index >= this.interceptors.size()) goto L58;
        int r0 = this.calls + 1;
        this.calls = r0;
        if (r0 <= 1) goto L15;
        Iterator<Interceptor> r1 = this.interceptors.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        Interceptor r3 = (Interceptor) ZeusTransformUtils.preCheckCast(r1.next(), Interceptor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, CallServerInterceptor.class) == false) goto L11;
        ((CallServerInterceptor) ZeusTransformUtils.preCheckCast(r3, CallServerInterceptor.class, "com.obric.memorydata.plugin")).resetExecuted();
    L15:
        RealInterceptorChain r2 = new RealInterceptorChain(this.interceptors, this.index + 1, r8, this.call);
        Interceptor r4 = (Interceptor) ZeusTransformUtils.preCheckCast(this.interceptors.get(this.index), Interceptor.class, "com.obric.memorydata.plugin");
        if (sLogObjectRefineEnabled == true) goto L23;
        StringBuilder r5 = new StringBuilder().append("interceptor = ");
        if (r4 == null) goto L20;
        String r6 = r4.toString();
    L21:
        RetrofitLogger.d("RealInterceptorChain", r5.append(r6).append(" url = ").append(r8.getUrl()).toString());
        goto L23
    L20:
        r6 = "";
    L23:
        if (r4 == null) goto L56;
        if (r8.getMetrics() == null) goto L60;
        r8.getMetrics().recordInterceptorRequestStart(r4);
        r8.getMetrics().beforeInterceptorExecute(r4);
    L60:
        SsResponse r7 = r4.intercept(r2);     // Catch: Throwable -> L43 Exception -> L45
        if (r7 == null) goto L42;
        if (r7.raw() == null) goto L40;
        if (r8.getMetrics() == null) goto L38;
        r8.getMetrics().recordInterceptorResponseEnd(null);
        if (this.index <= 0) goto L37;
        r8.getMetrics().recordInterceptorResponseStart((Interceptor) ZeusTransformUtils.preCheckCast(this.interceptors.get(this.index - 1), Interceptor.class, "com.obric.memorydata.plugin"));
    L37:
        request().getMetrics().afterInterceptorExecute(null);
    L38:
        return r7;
    L40:
        throw new IllegalStateException("interceptor " + r4 + " returned a ssResponse with no body");     // Catch: Throwable -> L43 Exception -> L45
    L42:
        throw new NullPointerException("interceptor " + r4 + " returned null");     // Catch: Throwable -> L43 Exception -> L45
    L45:
        e = move-exception;
        throw e;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if (r8.getMetrics() == null) goto L54;
        r8.getMetrics().recordInterceptorResponseEnd(null);
        if (this.index <= 0) goto L53;
        r8.getMetrics().recordInterceptorResponseStart((Interceptor) ZeusTransformUtils.preCheckCast(this.interceptors.get(this.index - 1), Interceptor.class, "com.obric.memorydata.plugin"));
    L53:
        request().getMetrics().afterInterceptorExecute(null);
    L54:
        throw th;
    L56:
        throw new NullPointerException("interceptor " + this.index + " is null");
    L58:
        throw new AssertionError();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public Request request() {
        return this.prevRequest;
    }
}
