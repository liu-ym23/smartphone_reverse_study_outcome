package com.bytedance.applog.priority;

import com.bytedance.applog.b;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.log.n;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.common.utility.NetworkUtils;
import com.ss.android.common.applog.e0;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import nx3.d;
import nx3.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class PriorityCallbackImpl implements PriorityCallback {
    private static final List<String> loggerTags = null;
    private final b appLogInstance;

    static {
        loggerTags = Collections.singletonList("PriorityCallbackImpl");
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String getHeaderJson() {
        this.appLogInstance.t0.g(0, loggerTags, "****** priority callback get header json...", new Object[0]);
        JSONObject r0 = this.appLogInstance.getHeader();
        if (r0 != null) goto L6;
        return null;
    L6:
        e0.b r1 = this.appLogInstance.q;
        if (r1 == null) goto L10;
        r1.a(r0);
    L10:
        return r0.toString();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public Object getOpaquePayloadJson() {
        return this.appLogInstance.R1();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isMonitorEnabled() {
        return this.appLogInstance.W.a.b;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableFast(this.appLogInstance.getContext());
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isStageEnabled() {
        return this.appLogInstance.W.g();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String isolateKey() {
        DataIsolateKey r0 = this.appLogInstance.d0;
        if (this.appLogInstance.c0 == false) goto L6;
        if (r0 == null) goto L6;
        return r0.getKey();
    L6:
        return "";
    }

    public PriorityCallbackImpl(b r1) {
        this.appLogInstance = r1;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean allowIsolateReport(String r1, String r2) {
        this.appLogInstance.getClass();
        boolean r3 = this.appLogInstance.c0;
        return true;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorError(String r3, String r4) {
        if (isMonitorEnabled() == true) goto L5;
        return;
    L5:
        this.appLogInstance.W.h(r3, new Throwable(r4), true);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorIncreaseStats(String r2, int r3) {
        this.appLogInstance.W.c(r2, r3);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void printLog(int r4, String r5) {
        if (this.appLogInstance.T1() == true) goto L6;
        return;
    L6:
        if (r4 != 2) goto L8;
        this.appLogInstance.t0.g(0, loggerTags, r5, new Object[0]);
        return;
    L8:
        if (r4 != 3) goto L10;
        this.appLogInstance.t0.f(0, loggerTags, r5, new Object[0]);
        return;
    L10:
        if (r4 == 4) goto L12;
        this.appLogInstance.t0.k(0, loggerTags, r5, new Object[0]);
        return;
    L12:
        this.appLogInstance.t0.s(loggerTags, r5, null, new Object[0]);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public PriorityHttpResponse doHttpPost(String r13, byte[] r14, Pair<String, String> r15) {
        long r2 = System.currentTimeMillis();
        b r4 = this.appLogInstance;
        n r5 = r4.t0;
        List<String> r6 = loggerTags;
        Object[] r7 = new Object[2];
        r7[0] = r13;
        if (r4.T1() == false) goto L5;
        Object r8 = new String(r14);
    L6:
        r7[1] = r8;
        r5.g(0, r6, "****** priority callback do http post, url: {}, buffer: {}", r7);
        HashMap r9 = new HashMap();
        if (this.appLogInstance.Z == null) goto L13;
        com.bytedance.applog.e r10 = this.appLogInstance.Z.a(r14);     // Catch: Throwable -> L10
        r14 = r10.a;     // Catch: Throwable -> L10
        r9.putAll(r10.c);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.appLogInstance.t0.s(loggerTags, "****** log compress toBytes failed", th, new Object[0]);
        this.appLogInstance.W.b(StatsCountKeys.COMPRESS_ERROR_COUNT, 1);
    L13:
        if (this.appLogInstance.v == false) goto L16;
        r14 = this.appLogInstance.f.c.c(r14);
        r9.remove("Content-Encoding");
        r9.put("Content-Type", "application/octet-stream;tt-data=a");
    L16:
        if (this.appLogInstance.c0 == false) goto L18;
        this.appLogInstance.getClass();
    L18:
        b r11 = this.appLogInstance;
        String r12 = r11.e.a(r11.getContext(), r13);
        if (r15 == null) goto L27;
        byte[] r16 = this.appLogInstance.getNetClient().postStream(r12, r14, r9);     // Catch: Throwable -> L33
        byte[] r17 = d.b(r16, (String) r15.getFirst(), (String) r15.getSecond());     // Catch: Throwable -> L33
        if (r17 != null) goto L23;
    L26:
        String r18 = new String(r16);     // Catch: Throwable -> L33
    L29:
        if (k.h(r18) == false) goto L31;
        PriorityHttpResponse r19 = new PriorityHttpResponse(200, "", r18);     // Catch: Throwable -> L33
    L39:
        this.appLogInstance.t0.k(0, loggerTags, "****** priority request cost {}ms", new Object[]{Long.valueOf(System.currentTimeMillis() - r2)});
        return r19;
    L31:
        r19 = new PriorityHttpResponse(0, "response empty", null);     // Catch: Throwable -> L33
        goto L39
    L23:
        if (r17.length == 0) goto L26;
        r18 = new String(d.f(r17));     // Catch: Throwable -> L33
        goto L29
    L27:
        r18 = this.appLogInstance.getNetClient().post(r12, r14, r9);     // Catch: Throwable -> L33
    L33:
        th = move-exception;
    L41:
        th = move-exception;
        throw th;
    L35:
        if ((th instanceof RangersHttpException) == false) goto L37;
        RangersHttpException r110 = th;     // Catch: Throwable -> L41
        int r20 = r110.getResponseCode();     // Catch: Throwable -> L41
        String r111 = r110.getMessage();     // Catch: Throwable -> L41
        this.appLogInstance.t0.s(loggerTags, "****** send resultCode: " + r20, th, new Object[0]);     // Catch: Throwable -> L41
        r19 = new PriorityHttpResponse(r20, r111, null);     // Catch: Throwable -> L41
    L38:
        this.appLogInstance.W.h("send priority log error, url: " + r13, new Throwable(r19.toString()), true);     // Catch: Throwable -> L41
        goto L39
    L37:
        r19 = new PriorityHttpResponse(0, th.toString(), null);     // Catch: Throwable -> L41
        goto L38
    L5:
        r8 = Integer.valueOf(r14.length);
        goto L6
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorLatency(int r8, int r9, int r10) {
        if (isMonitorEnabled() == true) goto L5;
        return;
    L5:
        ex3.e r0 = this.appLogInstance.W;
        StageEventType r11 = StageEventType.fromLabel(r9);
        ex3.b r1 = r0.a;
        if (r1.b == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L15;
        n.w().k(8, ex3.e.m, "onLatency {} -> {}", new Object[]{Integer.valueOf(r8), Integer.valueOf(r10)});
        r0.e.b(r8, r11, r10);
        return;
    L15:
        return;
    L8:
        if (r1.f == false) goto L10;
        r2 = true;
        goto L11
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorStage(String r12, String r13, int r14, int r15, String r16, String r17, long r18) {
        if (isStageEnabled() == true) goto L5;
        return;
    L5:
        ex3.e r2 = this.appLogInstance.W;
        EventStage r5 = EventStage.fromLabel(r12);
        StageEventType r10 = StageEventType.fromLabel(r15);
        if (r2.g() == false) goto L10;
        r2.n(r13, r14, r5, r16, r17, r18, r10);
        return;
    }
}
