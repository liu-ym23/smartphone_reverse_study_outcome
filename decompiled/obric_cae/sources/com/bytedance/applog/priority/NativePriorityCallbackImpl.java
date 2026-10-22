package com.bytedance.applog.priority;

import android.webkit.ValueCallback;
import androidx.annotation.Keep;
import he.i;
import he.j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import xd.d;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class NativePriorityCallbackImpl implements PriorityCallback {
    private final ExecutorService httpThreadPool;
    private final c4.a logger;
    private final ValueCallback<d<Long, PriorityHttpResponse>> onHttpCallback;
    private final PriorityCallback priorityCallback;

    public static final class a extends j implements ge.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3778a;

        public a(String r8) {
            this.f3778a = r8;
            super(0);
        }

        @Override // ge.a
        public final String f() {
            return "[NativePriorityCallbackImpl] native doHttpPost submitted with url: " + this.f3778a + '!';
        }
    }

    public static final class b extends j implements ge.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f3779a;

        public b(long r8) {
            this.f3779a = r8;
            super(0);
        }

        @Override // ge.a
        public final String f() {
            return "native doHttpPost[reqId] submitted with req_id: " + this.f3779a + '!';
        }
    }

    public NativePriorityCallbackImpl(PriorityCallback r8, c4.a r10, ValueCallback<d<Long, PriorityHttpResponse>> r11) {
        i.f(r8, "priorityCallback");
        i.f(r10, "logger");
        i.f(r11, "onHttpCallback");
        this.priorityCallback = r8;
        this.logger = r10;
        this.onHttpCallback = r11;
        ExecutorService r12 = Executors.newFixedThreadPool(3);
        i.e(r12, "newFixedThreadPool(3)");
        this.httpThreadPool = r12;
    }

    public static /* synthetic */ void a(NativePriorityCallbackImpl r8, String r10, String r11, String r12, byte[] r13, long r14) {
        m0doHttpPost$lambda0(r8, r10, r11, r12, r13, r14);
    }

    /* JADX INFO: renamed from: doHttpPost$lambda-0, reason: not valid java name */
    private static final void m0doHttpPost$lambda0(NativePriorityCallbackImpl r8, String r10, String r11, String r12, byte[] r13, long r14) {
        i.f(r8, "this$0");
        r8.logger.a("NativePriorityCallbackImpl:doHttpPost", new b(r14));
        boolean r15 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r16 = true;
    L9:
        if (r16 == true) goto L17;
        if (r11 != null) goto L12;
    L13:
        r15 = true;
    L14:
        if (r15 == true) goto L17;
        d<String, String> r17 = new d(r10, r11);
    L18:
        r8.onHttpCallback.onReceiveValue(new d(Long.valueOf(r14), r8.priorityCallback.doHttpPost(r12, r13, r17)));
        return;
    L12:
        if (r11.length() != 0) goto L14;
    L17:
        r17 = null;
        goto L18
    L5:
        if (r10.length() == 0) goto L8;
        r16 = false;
        goto L9
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean allowIsolateReport(String r8, String r10) {
        return this.priorityCallback.allowIsolateReport(r8, r10);
    }

    public final PriorityHttpResponse doHttpPost(final String r11, final long r12, final byte[] r14, final String r15, final String r16) {
        this.httpThreadPool.submit(new m4.d(this, r15, r16, r11, r14, r12));
        return new PriorityHttpResponse(200, "", "");
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String getHeaderJson() {
        return this.priorityCallback.getHeaderJson();
    }

    public final ExecutorService getHttpThreadPool() {
        return this.httpThreadPool;
    }

    public final c4.a getLogger() {
        return this.logger;
    }

    public final ValueCallback<d<Long, PriorityHttpResponse>> getOnHttpCallback() {
        return this.onHttpCallback;
    }

    public final PriorityCallback getPriorityCallback() {
        return this.priorityCallback;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isMonitorEnabled() {
        return this.priorityCallback.isMonitorEnabled();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isNetworkAvailable() {
        return this.priorityCallback.isNetworkAvailable();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isStageEnabled() {
        return this.priorityCallback.isStageEnabled();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String isolateKey() {
        return this.priorityCallback.isolateKey();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorError(String r8, String r10) {
        this.priorityCallback.monitorError(r8, r10);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorIncreaseStats(String r8, int r10) {
        this.priorityCallback.monitorIncreaseStats(r8, r10);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorLatency(int r8, int r10, int r11) {
        this.priorityCallback.monitorLatency(r8, r10, r11);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorStage(String r10, String r11, int r12, int r13, String r14, String r15, long r16) {
        this.priorityCallback.monitorStage(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void printLog(int r8, String r10) {
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public PriorityHttpResponse doHttpPost(String r8, byte[] r10, d<String, String> r11) {
        this.logger.a("NativePriorityCallbackImpl", new a(r8));
        return null;
    }
}
