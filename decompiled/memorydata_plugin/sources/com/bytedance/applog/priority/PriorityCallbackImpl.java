package com.bytedance.applog.priority;

import android.content.Context;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.log.j;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.util.o;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.common.utility.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PriorityCallbackImpl implements PriorityCallback {
    private static final List<String> loggerTags = null;
    private final com.bytedance.applog.b appLogInstance;

    static {
        loggerTags = Collections.singletonList("PriorityCallbackImpl");
    }

    public PriorityCallbackImpl(com.bytedance.applog.b r1) {
        this.appLogInstance = r1;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean allowIsolateReport(String r3, String r4) {
        com.bytedance.applog.isolate.b r0 = this.appLogInstance.U();
        if (this.appLogInstance.S() == false) goto L10;
        if (r0 == null) goto L10;
        DataIsolateKey r2 = DataIsolateKey.fromKey(r3);
        if (r2 != null) goto L9;
        return true;
    L9:
        return r0.a(r2, r4);
    L10:
        return true;
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public PriorityHttpResponse doHttpPost(String r12, byte[] r13, Pair<String, String> r14) {
        long r0 = System.currentTimeMillis();
        j r2 = this.appLogInstance.aA();
        List<String> r3 = loggerTags;
        Object[] r4 = new Object[2];
        r4[0] = r12;
        if (this.appLogInstance.aN() == false) goto L5;
        Object r6 = new String(r13);
    L6:
        r4[1] = r6;
        r2.a(r3, "****** priority callback do http post, url: {}, buffer: {}", r4);
        HashMap r5 = new HashMap();
        if (this.appLogInstance.Z() == null) goto L13;
        com.bytedance.applog.d r7 = this.appLogInstance.Z().a(r13);     // Catch: Throwable -> L10
        r13 = r7.a();     // Catch: Throwable -> L10
        r5.putAll(r7.c());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.appLogInstance.aA().a(loggerTags, "****** log compress toBytes failed", th, new Object[0]);
        this.appLogInstance.ab().a(StatsCountKeys.COMPRESS_ERROR_COUNT);
    L13:
        if (this.appLogInstance.k() == false) goto L16;
        r13 = this.appLogInstance.aw().a().b(r13);
        r5.remove(NetConst.KEY_CONTENT_ENCODING);
        r5.put(NetConst.KEY_CONTENT_TYPE, "application/octet-stream;tt-data=a");
    L16:
        if (this.appLogInstance.S() == false) goto L20;
        com.bytedance.applog.isolate.b r8 = this.appLogInstance.U();
        if (r8 == null) goto L21;
        r8.a();
    L21:
        String r9 = this.appLogInstance.av().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.appLogInstance.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r12);
        if (r14 == null) goto L30;
        byte[] r15 = this.appLogInstance.v().postStream(r9, r13, r5);     // Catch: Throwable -> L37
        byte[] r16 = com.bytedance.applog.util.f.a(r15, (String) ZeusTransformUtils.preCheckCast(r14.getFirst(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r14.getSecond(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L37
        if (r16 != null) goto L26;
    L29:
        String r17 = new String(r15);     // Catch: Throwable -> L37
    L32:
        if (o.a(r17) == false) goto L34;
        PriorityHttpResponse r18 = new PriorityHttpResponse(200, "", r17);     // Catch: Throwable -> L37
    L35:
        if (r8 == null) goto L45;
    L36:
        r8.b();
    L45:
        this.appLogInstance.aA().b(loggerTags, "****** priority request cost {}ms", new Object[]{Long.valueOf(System.currentTimeMillis() - r0)});
        return r18;
    L34:
        r18 = new PriorityHttpResponse(0, "response empty", null);     // Catch: Throwable -> L37
        goto L35
    L26:
        if (r16.length == 0) goto L29;
        r17 = new String(com.bytedance.applog.util.f.c(r16));     // Catch: Throwable -> L37
        goto L32
    L30:
        r17 = this.appLogInstance.v().post(r9, r13, r5);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
    L47:
        th = move-exception;
        if (r8 == null) goto L50;
        r8.b();
    L50:
        throw th;
    L39:
        if (ZeusTransformUtils.instanceOf(th, RangersHttpException.class) == false) goto L41;
        RangersHttpException r19 = (RangersHttpException) ZeusTransformUtils.preCheckCast(th, RangersHttpException.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        int r10 = r19.getResponseCode();     // Catch: Throwable -> L47
        String r110 = r19.getMessage();     // Catch: Throwable -> L47
        this.appLogInstance.aA().a(loggerTags, "****** send resultCode: " + r10, th, new Object[0]);     // Catch: Throwable -> L47
        r18 = new PriorityHttpResponse(r10, r110, null);     // Catch: Throwable -> L47
    L42:
        this.appLogInstance.ab().a("send priority log error, url: " + r12, new Throwable(r18.toString()));     // Catch: Throwable -> L47
        if (r8 == null) goto L45;
    L41:
        r18 = new PriorityHttpResponse(0, th.toString(), null);     // Catch: Throwable -> L47
        goto L42
    L20:
        r8 = null;
        goto L21
    L5:
        r6 = Integer.valueOf(r13.length);
        goto L6
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String getHeaderJson() {
        this.appLogInstance.aA().a(loggerTags, "****** priority callback get header json...", new Object[0]);
        JSONObject r0 = this.appLogInstance.w();
        if (r0 != null) goto L6;
        return null;
    L6:
        com.bytedance.applog.i r4 = this.appLogInstance.z();
        if (r4 == null) goto L10;
        r4.a(r0);
    L10:
        return r0.toString();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isMonitorEnabled() {
        return this.appLogInstance.ab().c();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isNetworkAvailable() {
        return NetworkUtils.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.appLogInstance.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public boolean isStageEnabled() {
        return this.appLogInstance.ab().d();
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public String isolateKey() {
        DataIsolateKey r0 = this.appLogInstance.T();
        if (this.appLogInstance.S() == false) goto L6;
        if (r0 == null) goto L6;
        return r0.getKey();
    L6:
        return "";
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorError(String r2, String r3) {
        if (isMonitorEnabled() == true) goto L5;
        return;
    L5:
        this.appLogInstance.ab().a(r2, new Throwable(r3));
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorIncreaseStats(String r1, int r2) {
        this.appLogInstance.ab().a(r1, r2);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorLatency(int r2, int r3, int r4) {
        if (isMonitorEnabled() == true) goto L5;
        return;
    L5:
        this.appLogInstance.ab().a(r2, StageEventType.fromLabel(r3), r4);
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void monitorStage(String r12, String r13, int r14, int r15, String r16, String r17, long r18) {
        if (isStageEnabled() == true) goto L5;
        return;
    L5:
        com.bytedance.applog.monitor.b.a(this.appLogInstance.ab(), EventStage.fromLabel(r12), new com.bytedance.applog.monitor.v3.h(r13, r14, r16, r17, r18, StageEventType.fromLabel(r15)));
    }

    @Override // com.bytedance.applog.priority.PriorityCallback
    public void printLog(int r3, String r4) {
        if (this.appLogInstance.aN() == true) goto L6;
        return;
    L6:
        if (r3 != 2) goto L8;
        this.appLogInstance.aA().a(loggerTags, r4, new Object[0]);
        return;
    L8:
        if (r3 == 3) goto L13;
        j r2 = this.appLogInstance.aA();
        if (r3 == 4) goto L12;
        r2.b(loggerTags, r4, new Object[0]);
        return;
    L12:
        r2.d(loggerTags, r4, new Object[0]);
        return;
    L13:
        this.appLogInstance.aA().c(loggerTags, r4, new Object[0]);
    }
}
