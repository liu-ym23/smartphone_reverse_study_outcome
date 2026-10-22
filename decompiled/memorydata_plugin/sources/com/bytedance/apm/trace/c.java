package com.bytedance.apm.trace;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.block.a.g;
import com.bytedance.apm.launch.e;
import com.bytedance.apm.launch.evil.LaunchSleepDetector;
import com.bytedance.apm.util.d;
import com.bytedance.apm.util.j;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1446a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1447b;
    private long c;
    private final ConcurrentHashMap<String, com.bytedance.apm.c.b> d;
    private final String e;
    private final String f;

    static {
    }

    public c(String r3, String r4) {
        this.d = new ConcurrentHashMap(4);
        if ("start_trace".equals(r3) == false) goto L5;
    L9:
        this.e = r3;
        this.f = r4;
        return;
    L5:
        if ("page_load_trace".equals(r3) == true) goto L9;
        throw new IllegalStateException("Please add TraceServiceName support on TraceState#reportAsync");
    }

    private void a(final int r12, final String r13, final String r14, long r15, long r17) {
        if (r12 == (-1)) goto L5;
    L11:
        this.c = System.currentTimeMillis();
        if (r17 <= 0) goto L14;
        this.c = this.f1447b + r17;
    L14:
        long r2 = this.c - this.f1447b;
        if (r15 > 0) goto L17;
    L19:
        e.a r0 = null;
        if (d() == false) goto L22;
        r0 = com.bytedance.apm.launch.b.a(r2);
    L22:
        final e.a r10 = r0;
        if (d() == false) goto L30;
        if (com.bytedance.perf.monitor.a.f2971b == false) goto L30;
        if (f1446a == false) goto L30;
        f1446a = false;
        b(r12, r13, this.f1447b, this.c);
    L30:
        if (d() == true) goto L32;
    L41:
        com.bytedance.apm.l.b.a().a(new AnonymousClass1(this, r10, r12, r13, r14));
        if (d() == false) goto L47;
        LaunchSleepDetector.a();
        return;
    L47:
        return;
    L32:
        if (com.bytedance.apm.launch.a.a().c().a() == false) goto L41;
        if (com.bytedance.apm.internal.a.b(8) == false) goto L41;
        JSONObject r1 = new JSONObject();
        r1.put("is_launch_lock", true);     // Catch: JSONException -> L38
    L40:
        LockMonitorManager.endLockDetect(r1);
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L17:
        if (r2 <= r15) goto L19;
        return;
    L5:
        if (r13.isEmpty() == false) goto L11;
        if (com.bytedance.apm.b.k() == false) goto L11;
        throw new IllegalArgumentException("Launch mode is both none");
    }

    private void a(int r19, String r20, String r21, long r22, e.a r24) {
        String r0 = "com.obric.memorydata.plugin";
        JSONArray r8 = new JSONArray();
        int r9 = 2;
    L29:
        e = move-exception;
        e.printStackTrace();
    L31:
        ConcurrentHashMap<String, com.bytedance.apm.c.b> r1 = this.d;
        if (r1 == null) goto L34;
        r1.clear();
    L34:
        JSONObject r2 = new JSONObject();
        r2.put(ActivityLifecycle.NAME, this.f);     // Catch: JSONException -> L61
        r2.put("page_type", this.f);     // Catch: JSONException -> L61
        r2.put(CommonConsts.APM_INNER_EVENT_COST_START, this.f1447b);     // Catch: JSONException -> L61
        r2.put("end", r22);     // Catch: JSONException -> L61
        r2.put("spans", r8);     // Catch: JSONException -> L61
        r2.put("collect_from", 2);     // Catch: JSONException -> L61
        r2.put("page_name", r21);     // Catch: JSONException -> L61
        if (r19 == (-1)) goto L39;
        r2.put(CrashBody.LAUNCH_MODE, r19);     // Catch: JSONException -> L61
    L39:
        if (r20.isEmpty() == true) goto L42;
        r2.put("custom_launch_mode", r20);     // Catch: JSONException -> L61
    L42:
        if (com.bytedance.apm.e.a.a() == false) goto L45;
        com.bytedance.apm.e.a.c("AppStartStats", r2.toString());     // Catch: JSONException -> L61
    L45:
        if (d() == true) goto L47;
    L50:
        JSONObject r3 = new JSONObject();
        r3.put("trace", r2);     // Catch: JSONException -> L63
        if (r24 == null) goto L56;
        JSONObject r4 = com.bytedance.apm.launch.b.a(r24);     // Catch: JSONException -> L63
        if (r4 == null) goto L56;
        r3.put("perf_data", r4);     // Catch: JSONException -> L63
    L56:
        com.bytedance.apm.data.a.e r5 = new com.bytedance.apm.data.a.e(this.e, "", null, null, r3);
        CommonDataAssembly.wrapFilters(r5, false);
        if (com.bytedance.apm.b.k() == false) goto L59;
        j.a("AppStartStats", "reportAsync: " + r3);
    L59:
        com.bytedance.apm.data.pipeline.a.b().a(r5);
        return;
    L47:
        if (com.bytedance.apm.launch.a.a().b().c() == false) goto L50;
        JSONObject r6 = new JSONObject();
        d.a().a(r6, true);
        d.a().b(r6, true);
        r2.put("device_info_data", r6);     // Catch: Throwable -> L62
        goto L50
    L4:
        if (TextUtils.equals(r21, com.bytedance.apm.agent.tracing.a.f1093a) == false) goto L6;
        r8 = com.bytedance.apm.agent.tracing.a.c();     // Catch: JSONException -> L29
    L6:
        ConcurrentHashMap<String, com.bytedance.apm.c.b> r12 = this.d;     // Catch: JSONException -> L29
        if (r12 == null) goto L31;
        if (r12.isEmpty() == true) goto L31;
        Iterator<Map.Entry<String, com.bytedance.apm.c.b>> r13 = this.d.entrySet().iterator();     // Catch: JSONException -> L29
    L11:
        if (r13.hasNext() == false) goto L31;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, r0);     // Catch: JSONException -> L29
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, r0);     // Catch: JSONException -> L29
        com.bytedance.apm.c.b r16 = (com.bytedance.apm.c.b) ZeusTransformUtils.preCheckCast(r14.getValue(), com.bytedance.apm.c.b.class, r0);     // Catch: JSONException -> L29
        if (r16.f1247b == 0) goto L11;
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L29
        String[] r11 = r15.split("#");     // Catch: JSONException -> L29
        if (r11.length == r9) goto L20;
        String r17 = r0;
        if (r11.length != 1) goto L27;
        String r7 = r11[0];     // Catch: JSONException -> L29
    L23:
        r10.put("span_name", r7);     // Catch: JSONException -> L29
    L27:
        r10.put(CommonConsts.APM_INNER_EVENT_COST_START, r16.f1246a);     // Catch: JSONException -> L29
        r10.put("end", r16.f1247b);     // Catch: JSONException -> L29
        r10.put("thread", r16.c);     // Catch: JSONException -> L29
        r8.put(r10);     // Catch: JSONException -> L29
        r0 = r17;
        r9 = 2;
        goto L11
    L20:
        if ("page_load_trace".equals(this.e) == false) goto L22;
        r10.put(ActivityLifecycle.NAME, r11[1]);     // Catch: JSONException -> L29
        r17 = r0;
        goto L27
    L22:
        r17 = r0;
        r10.put("module_name", r11[0]);     // Catch: JSONException -> L29
        r7 = r11[1];     // Catch: JSONException -> L29
        goto L23
    }

    static /* synthetic */ void a(c r0, int r1, String r2, String r3, long r4, e.a r6) {
        r0.a(r1, r2, r3, r4, r6);
    }

    static /* synthetic */ boolean a(c r0) {
        return r0.d();
    }

    static /* synthetic */ long b(c r2) {
        return r2.c;
    }

    private void b(final int r14, final String r15, final long r16, final long r18) {
        final long[] r3 = g.a().e();
        final long r4 = SystemClock.uptimeMillis();
        if (r3 == null) goto L6;
        com.bytedance.apm.l.b.a().a(new AnonymousClass2(this, r3, r4, r18, r16, r14, r15));
        return;
    }

    private boolean d() {
        return "start_trace".equals(this.e);
    }

    public long a() {
        return this.f1447b;
    }

    public void a(int r9, String r10, long r11, long r13) {
        a(r9, "", r10, r11, r13);
    }

    public void a(String r2, String r3) {
        a(r2, r3, false);
    }

    public void a(String r5, String r6, boolean r7) {
        if (((com.bytedance.apm.c.b) ZeusTransformUtils.preCheckCast(this.d.get(r5 + "#" + r6), com.bytedance.apm.c.b.class, "com.obric.memorydata.plugin")) == null) goto L5;
        if (r7 == true) goto L5;
        return;
    L5:
        this.d.put(r5 + "#" + r6, new com.bytedance.apm.c.b(System.currentTimeMillis()));
    }

    public void b() {
        this.f1447b = System.currentTimeMillis();
    }

    public void b(String r6, String r7) {
        com.bytedance.apm.c.b r0 = (com.bytedance.apm.c.b) ZeusTransformUtils.preCheckCast(this.d.get(r6 + "#" + r7), com.bytedance.apm.c.b.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(System.currentTimeMillis(), Thread.currentThread().getName());
        this.d.put(r6 + "#" + r7, r0);
    }

    public void c() {
        this.d.clear();
    }
}
