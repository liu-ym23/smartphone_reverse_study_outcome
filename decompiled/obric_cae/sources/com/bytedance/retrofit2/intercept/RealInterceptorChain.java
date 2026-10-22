package com.bytedance.retrofit2.intercept;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallServerInterceptor;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RealInterceptorChain implements Interceptor.Chain {
    private final Call call;
    private int calls;
    private final int index;
    private final List<Interceptor> interceptors;
    private RetrofitMetrics metrics;
    private final Request request;

    public RealInterceptorChain(List<Interceptor> r8, int r10, Request r11, Call r12, RetrofitMetrics r13) {
        this.interceptors = r8;
        this.index = r10;
        this.request = r11;
        this.call = r12;
        this.metrics = r13;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public RetrofitMetrics metrics() {
        return this.metrics;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public SsResponse proceed(Request r10) {
        if (this.index >= this.interceptors.size()) goto L26;
        int r8 = this.calls + 1;
        this.calls = r8;
        if (r8 <= 1) goto L12;
        Iterator<Interceptor> r11 = this.interceptors.iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        Interceptor r12 = r11.next();
        if ((r12 instanceof CallServerInterceptor) == false) goto L8;
        ((CallServerInterceptor) r12).resetExecuted();
    L12:
        RealInterceptorChain r13 = new RealInterceptorChain(this.interceptors, this.index + 1, r10, this.call, this.metrics);
        Interceptor r14 = this.interceptors.get(this.index);
        StringBuilder r15 = new StringBuilder("interceptor = ");
        if (r14 == null) goto L15;
        String r16 = r14.toString();
    L16:
        r15.append(r16);
        r15.append(" url = ");
        r15.append(r10.getUrl());
        RetrofitLogger.d("RealInterceptorChain", r15.toString());
        SsResponse r17 = r14.intercept(r13);
        if (r17 == null) goto L24;
        if (r17.raw() == null) goto L22;
        return r17;
    L22:
        throw new IllegalStateException("interceptor " + r14 + " returned a ssResponse with no body");
    L24:
        throw new NullPointerException("interceptor " + r14 + " returned null");
    L15:
        r16 = "";
        goto L16
    L26:
        throw new AssertionError();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public Request request() {
        return this.request;
    }
}
