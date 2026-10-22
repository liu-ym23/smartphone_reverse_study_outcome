package com.bytedance.retrofit2;

import ai.c;
import ai.f;
import ai.g;
import ai.i0;
import ai.l0;
import ai.m0;
import ai.n;
import ai.n0;
import ai.o;
import ai.o0;
import ai.p0;
import ai.q0;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.retrofit2.client.Request;
import fi.i;
import h.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SsHttpCall<T> implements c, n, o {
    private static o0 sReqLevelControl;
    private static p0 sThrottleControl;
    private long appCallTime;
    private final Object[] args;
    private final f callServerInterceptor;
    private int mReqControlLevel;
    private Request originalRequest;
    private Throwable preBuildURLException;
    private final l0 serviceMethod;

    public SsHttpCall(l0 r5, Object[] r10) {
        this.mReqControlLevel = -1;
        this.serviceMethod = r5;
        this.args = r10;
        this.callServerInterceptor = new f(r5);
    }

    public static /* synthetic */ Throwable access$000(SsHttpCall r5) {
        return r5.preBuildURLException;
    }

    public static /* synthetic */ Throwable access$002(SsHttpCall r5, Throwable r10) {
        r5.preBuildURLException = r10;
        return r10;
    }

    public static /* synthetic */ Request access$100(SsHttpCall r5) {
        return r5.originalRequest;
    }

    public static /* synthetic */ Request access$102(SsHttpCall r5, Request r10) {
        r5.originalRequest = r10;
        return r10;
    }

    public static /* synthetic */ Object[] access$200(SsHttpCall r5) {
        return r5.args;
    }

    public static /* synthetic */ l0 access$300(SsHttpCall r5) {
        return r5.serviceMethod;
    }

    public static /* synthetic */ o0 access$400() {
        return null;
    }

    public static /* synthetic */ int access$500(SsHttpCall r5) {
        return r5.mReqControlLevel;
    }

    public static /* synthetic */ p0 access$600() {
        return sThrottleControl;
    }

    public static void setReqLevelControl(o0 r5) {
    }

    public static void setThrottleControl(p0 r5) {
        sThrottleControl = r5;
    }

    @Override // ai.c
    public void cancel() {
        f r5 = this.callServerInterceptor;
        if (r5 == null) goto L8;
        r5.d = true;
        if (r5.f205b == null) goto L9;
        r5.f205b.cancel();
        return;
    L9:
        return;
    }

    @Override // ai.c
    public /* bridge */ /* synthetic */ c clone() {
        return clone();
    }

    @Override // ai.n
    public void doCollect() {
        f r5 = this.callServerInterceptor;
        if (r5 == null) goto L6;
        r5.doCollect();
        return;
    }

    public void enqueue(g r5) {
        i0 r10 = this.serviceMethod.f279t;
        r10.f225m = SystemClock.uptimeMillis();
        this.appCallTime = System.currentTimeMillis();
        if (r5 == null) goto L33;
        f r11 = this.callServerInterceptor;
        if (r11 == null) goto L16;
        monitor-enter(r11);
        boolean r12 = r11.f;     // Catch: Throwable -> L13
        monitor-exit(r11);
        if (r12 == false) goto L16;
        throw new IllegalStateException("Already executed.");
    L13:
        th = move-exception;
        throw th;
    L16:
        l0 r13 = this.serviceMethod;
        a r14 = r13.d;
        m0 r15 = new m0(this, r10);
        this.originalRequest = r13.b(this.args);     // Catch: IOException -> L19
    L21:
        p0 r16 = sThrottleControl;
        if (r16 != null) goto L24;
    L30:
        r14.execute(r15);
        return;
    L24:
        if (r16.a() == true) goto L28;
        if (sThrottleControl.d() == false) goto L30;
    L28:
        if (this.mReqControlLevel != (-1)) goto L30;
        r14.execute(new n0(this, r14, r15));
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L33:
        throw new NullPointerException("callback == null");
    }

    @Override // ai.c
    public q0 execute() throws Exception {
        i0 r5 = this.serviceMethod.f279t;
        r5.f226n = SystemClock.uptimeMillis();
        this.appCallTime = System.currentTimeMillis();
        r5.f229q = SystemClock.uptimeMillis();
        this.originalRequest = this.serviceMethod.b(this.args);
        r5.f230r = SystemClock.uptimeMillis();
        p0 r10 = sThrottleControl;
        if (r10 == null) goto L28;
        if (this.mReqControlLevel != (-1)) goto L28;
        int r11 = 0;
        if (r10.a() == false) goto L14;
        Request r12 = this.originalRequest;
        if (r12 != null) goto L11;
    L26:
        long r13 = r11;
        r5.f227o = r13;
        Thread.sleep(r13);
        goto L28
    L11:
        if (TextUtils.isEmpty(r12.getPath()) == true) goto L26;
        r11 = sThrottleControl.e(this.originalRequest.getPath());
        goto L26
    L14:
        if (sThrottleControl.d() == false) goto L26;
        Request r14 = this.originalRequest;
        if (r14 == null) goto L26;
        List<bi.c> r15 = r14.headers("x-tt-request-tag");
        if (r15 != null) goto L20;
    L24:
        String r16 = "";
    L25:
        r11 = sThrottleControl.c(this.originalRequest.getUrl(), r16);
        goto L26
    L20:
        if (r15.size() < 1) goto L24;
        if (TextUtils.isEmpty(r15.get(0).f916b) == true) goto L24;
        r16 = r15.get(0).f916b;
    L28:
        return getResponseWithInterceptorChain();
    }

    @Override // ai.o
    public Object getRequestInfo() {
        f r5 = this.callServerInterceptor;
        if (r5 == null) goto L5;
        r5.getRequestInfo();
    L5:
        return null;
    }

    public q0 getResponseWithInterceptorChain() throws Exception {
        i0 r10 = this.serviceMethod.f279t;
        r10.f228p = SystemClock.uptimeMillis();
        LinkedList r5 = new LinkedList();
        r5.addAll(this.serviceMethod.f267c);
        r5.add(this.callServerInterceptor);
        r10.f = this.appCallTime;
        r10.g = System.currentTimeMillis();
        this.originalRequest.setMetrics(r10);
        Request r11 = this.originalRequest;
        return new com.bumptech.glide.load.engine.bitmap_recycle.f(r5, 0, r11, this, r10).g(r11);
    }

    public i0 getRetrofitMetrics() {
        return this.serviceMethod.f279t;
    }

    @Override // ai.c
    public boolean isCanceled() {
        f r5 = this.callServerInterceptor;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.d == false) goto L7;
        return true;
    }

    public synchronized boolean isExecuted() {
        monitor-enter(this);
        f r5 = this.callServerInterceptor;     // Catch: Throwable -> L16
        if (r5 == null) goto L13;
        monitor-enter(r5);     // Catch: Throwable -> L16
        boolean r10 = r5.f;     // Catch: Throwable -> L10
        monitor-exit(r5);     // Catch: Throwable -> L16
        if (r10 == false) goto L13;
        boolean r11 = true;
    L14:
        monitor-exit(this);
        return r11;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L13:
        r11 = false;
    L16:
        th = move-exception;
        throw th;
    }

    public Request request() {
        f r5 = this.callServerInterceptor;
        if (r5 == null) goto L8;
        Request r10 = r5.f206c;
        if (r10 == null) goto L8;
        return r10;
    L8:
        if (this.originalRequest != null) goto L19;
        i0 r11 = this.serviceMethod.f279t;     // Catch: IOException -> L11 RuntimeException -> L13
        r11.f229q = SystemClock.uptimeMillis();     // Catch: IOException -> L11 RuntimeException -> L13
        this.originalRequest = this.serviceMethod.b(this.args);     // Catch: IOException -> L11 RuntimeException -> L13
        r11.f230r = SystemClock.uptimeMillis();     // Catch: IOException -> L11 RuntimeException -> L13
    L11:
        e = move-exception;
        throw new RuntimeException("Unable to create request.", e);
    L13:
        e = move-exception;
        throw e;
    L19:
        return this.originalRequest;
    }

    public boolean setThrottleNetSpeed(long r5) {
        f r10 = this.callServerInterceptor;
        if (r10 == null) goto L8;
        r10.g = r5;
        if (r10.f205b != null) goto L7;
        return false;
    L7:
        return r10.f205b.a(r5);
    L8:
        return false;
    }

    public T toResponseBody(i r5) throws IOException {
        return (T) this.serviceMethod.f271k.convert(r5);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m89clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // ai.c
    public SsHttpCall<T> clone() {
        return new SsHttpCall(this.serviceMethod, this.args);
    }
}
