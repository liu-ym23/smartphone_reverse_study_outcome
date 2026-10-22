package com.bytedance.applog.priority;

import android.webkit.ValueCallback;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006¢\u0006\u0002\u0010\nJ\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J4\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0007H\u0016J8\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0018J\n\u0010!\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\n\u0010%\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u00182\b\u0010)\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010*\u001a\u00020'2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010+\u001a\u00020,H\u0016J \u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020,H\u0016JH\u00101\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u00010\u00182\b\u00103\u001a\u0004\u0018\u00010\u00182\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u00010\u00182\b\u00105\u001a\u0004\u0018\u00010\u00182\u0006\u00106\u001a\u00020\bH\u0016J\u001a\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020,2\b\u00109\u001a\u0004\u0018\u00010\u0018H\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006:"}, d2 = {"Lcom/bytedance/applog/priority/NativePriorityCallbackImpl;", "Lcom/bytedance/applog/priority/PriorityCallback;", "priorityCallback", "logger", "Lcom/bytedance/applog/log/AbsLogger;", "onHttpCallback", "Landroid/webkit/ValueCallback;", "Lkotlin/Pair;", "", "Lcom/bytedance/applog/priority/PriorityHttpResponse;", "(Lcom/bytedance/applog/priority/PriorityCallback;Lcom/bytedance/applog/log/AbsLogger;Landroid/webkit/ValueCallback;)V", "httpThreadPool", "Ljava/util/concurrent/ExecutorService;", "getHttpThreadPool", "()Ljava/util/concurrent/ExecutorService;", "getLogger", "()Lcom/bytedance/applog/log/AbsLogger;", "getOnHttpCallback", "()Landroid/webkit/ValueCallback;", "getPriorityCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "allowIsolateReport", "", "key", "", EventBody.KEY_VALUE, "doHttpPost", "url", "buffer", "", "keyIv", "reqId", "iv", "getHeaderJson", "isMonitorEnabled", "isNetworkAvailable", "isStageEnabled", "isolateKey", "monitorError", "", "s", "stackInfo", "monitorIncreaseStats", CommonConsts.COUNT_TYPE, "", "monitorLatency", "groupId", "eventType", "delaySeconds", "monitorStage", "stage", "priorityName", "event", "monitorId", "localTimeMs", "printLog", "level", "message", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NativePriorityCallbackImpl implements PriorityCallback {
    private final ExecutorService httpThreadPool;
    private final com.bytedance.applog.log.a logger;
    private final ValueCallback<Pair<Long, PriorityHttpResponse>> onHttpCallback;
    private final PriorityCallback priorityCallback;

    public NativePriorityCallbackImpl(PriorityCallback r3, com.bytedance.applog.log.a r4, ValueCallback<Pair<Long, PriorityHttpResponse>> r5) {
        PriorityCallback r6 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r3, PriorityCallback.class, "com.obric.memorydata.plugin");
        com.bytedance.applog.log.a r7 = (com.bytedance.applog.log.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.applog.log.a.class, "com.obric.memorydata.plugin");
        ValueCallback<Pair<Long, PriorityHttpResponse>> r8 = (ValueCallback) ZeusTransformUtils.wrapperContextForParams(r5, ValueCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "priorityCallback");
        Intrinsics.checkNotNullParameter(r7, "logger");
        Intrinsics.checkNotNullParameter(r8, "onHttpCallback");
        this.priorityCallback = r6;
        this.logger = r7;
        this.onHttpCallback = r8;
        ExecutorService r9 = Executors.newFixedThreadPool(3);
        Intrinsics.checkNotNullExpressionValue(r9, "newFixedThreadPool(3)");
        this.httpThreadPool = r9;
    }

    /* JADX INFO: renamed from: doHttpPost$lambda-0, reason: not valid java name */
    private static final void m76doHttpPost$lambda0(NativePriorityCallbackImpl r4, String r5, String r6, String r7, byte[] r8, final long r9) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        r4.logger.a("NativePriorityCallbackImpl:doHttpPost", (Function0) ZeusTransformUtils.preCheckCast(new NativePriorityCallbackImpl$doHttpPost$2$1(r9), Function0.class, "com.obric.memorydata.plugin"));
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L18;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L13;
    L14:
        r1 = true;
    L15:
        if (r1 == true) goto L18;
        Pair<String, String> r10 = TuplesKt.to(r5, r6);
    L19:
        r4.onHttpCallback.onReceiveValue(new Pair(Long.valueOf(r9), r4.priorityCallback.doHttpPost(r7, r8, r10)));
        return;
    L13:
        if (r3.length() != 0) goto L15;
    L18:
        r10 = null;
        goto L19
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static /* synthetic */ void lambda$TNApqfXjshTokCeKAreS697qpeM(NativePriorityCallbackImpl r0, String r1, String r2, String r3, byte[] r4, long r5) {
        m76doHttpPost$lambda0(r0, r1, r2, r3, r4, r5);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean allowIsolateReport(String r1, String r2) {
        return this.priorityCallback.allowIsolateReport(r1, r2);
    }

    public final PriorityHttpResponse doHttpPost(final String r11, final long r12, final byte[] r14, final String r15, final String r16) {
        this.httpThreadPool.submit(new $$Lambda$NativePriorityCallbackImpl$TNApqfXjshTokCeKAreS697qpeM(this, r15, r16, r11, r14, r12));
        return new PriorityHttpResponse(200, "", "");
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public PriorityHttpResponse doHttpPost(final String r1, byte[] r2, Pair<String, String> r3) {
        this.logger.a("NativePriorityCallbackImpl", (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r1), Function0.class, "com.obric.memorydata.plugin"));
        return null;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String getHeaderJson() {
        return this.priorityCallback.getHeaderJson();
    }

    public final ExecutorService getHttpThreadPool() {
        return this.httpThreadPool;
    }

    public final com.bytedance.applog.log.a getLogger() {
        return this.logger;
    }

    public final ValueCallback<Pair<Long, PriorityHttpResponse>> getOnHttpCallback() {
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
    public void monitorError(String r1, String r2) {
        this.priorityCallback.monitorError(r1, r2);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorIncreaseStats(String r1, int r2) {
        this.priorityCallback.monitorIncreaseStats(r1, r2);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorLatency(int r1, int r2, int r3) {
        this.priorityCallback.monitorLatency(r1, r2, r3);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorStage(String r10, String r11, int r12, int r13, String r14, String r15, long r16) {
        this.priorityCallback.monitorStage(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void printLog(int r1, String r2) {
    }
}
