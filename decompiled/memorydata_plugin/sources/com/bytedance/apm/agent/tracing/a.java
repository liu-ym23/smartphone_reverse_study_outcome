package com.bytedance.apm.agent.tracing;

import com.bytedance.apm.data.a.e;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f1094b = 0;
    private static long c = 0;
    private static long d = 0;
    private static long e = 0;
    private static long f = 0;
    private static long g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static long k = 0;
    private static long l = 0;
    private static long m = 0;
    private static long n = 0;
    private static boolean o = false;
    private static long p = 15000;

    static {
    }

    public static void a() {
        com.bytedance.apm.launch.a.a().b("onCreateEnd " + h + " " + i);
        if (i == 0) goto L5;
        return;
    L5:
        if (o == false) goto L9;
        i = System.currentTimeMillis();
        return;
    }

    public static void a(long r4, long r6, long r8, long r10, long r12, long r14) {
        com.bytedance.apm.launch.a.a().b("assignAppTime: " + g);
        f1094b = r4;
        c = r6;
        d = r8;
        e = r10;
        f = r12;
        g = r14;
        com.bytedance.apm.b.b(r4);
    }

    public static void a(String r11) {
        com.bytedance.apm.launch.a r0 = com.bytedance.apm.launch.a.a();
        StringBuilder r1 = new StringBuilder().append(r11).append(" onCreateStart ").append(h).append(" ");
        boolean r5 = false;
        if ((h - g) >= 800) goto L5;
        boolean r4 = true;
    L6:
        r0.b(r1.append(r4).toString());
        if (h != 0) goto L15;
        h = System.currentTimeMillis();
        com.bytedance.apm.launch.a r2 = com.bytedance.apm.launch.a.a();
        StringBuilder r3 = new StringBuilder().append(r11).append(" onCreateStart ").append(h).append("  ").append(g).append(" ");
        if ((h - g) >= 800) goto L11;
        r5 = true;
    L11:
        r2.b(r3.append(r5).toString());
        if ((h - g) >= 800) goto L16;
        o = true;
        f1093a = r11;
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public static void b() {
        com.bytedance.apm.launch.a.a().b("onResumeEnd " + l + " " + m);
        if (m == 0) goto L5;
        return;
    L5:
        if (o == false) goto L9;
        m = System.currentTimeMillis();
        return;
    }

    public static void b(String r4) {
        com.bytedance.apm.launch.a.a().b(r4 + " onStart " + j);
        if (j == 0) goto L5;
        return;
    L5:
        if (o == false) goto L9;
        j = System.currentTimeMillis();
        return;
    }

    public static JSONArray c() {
        JSONArray r0 = new JSONArray();
        JSONObject r1 = new JSONObject();
        r1.put("module_name", "base");
        r1.put("span_name", "app_constructor");
        r1.put(CommonConsts.APM_INNER_EVENT_COST_START, f1094b);
        r1.put("end", c);
        JSONObject r5 = new JSONObject();
        r5.put("module_name", "base");
        r5.put("span_name", "app_attachBaseContext");
        r5.put(CommonConsts.APM_INNER_EVENT_COST_START, d);
        r5.put("end", e);
        JSONObject r6 = new JSONObject();
        r6.put("module_name", "base");
        r6.put("span_name", "app_onCreate");
        r6.put(CommonConsts.APM_INNER_EVENT_COST_START, f);
        r6.put("end", g);
        JSONObject r9 = new JSONObject();
        r9.put("module_name", "base");
        r9.put("span_name", "activity_onCreate");
        r9.put(CommonConsts.APM_INNER_EVENT_COST_START, h);
        r9.put("end", i);
        JSONObject r10 = new JSONObject();
        r10.put("module_name", "base");
        r10.put("span_name", "activity_onResume");
        r10.put(CommonConsts.APM_INNER_EVENT_COST_START, l);
        r10.put("end", m);
        JSONObject r11 = new JSONObject();
        r11.put("module_name", "base");
        r11.put("span_name", "activity_onStart");
        r11.put(CommonConsts.APM_INNER_EVENT_COST_START, j);
        r11.put("end", k);
        if (n <= 0) goto L5;
        JSONObject r8 = new JSONObject();
        r8.put("module_name", "base");
        r8.put("span_name", "activity_onWindowFocusChanged");
        r8.put(CommonConsts.APM_INNER_EVENT_COST_START, n);
        r0.put(r8);
    L5:
        r0.put(r1);
        r0.put(r5);
        r0.put(r6);
        r0.put(r9);
        r0.put(r10);
        r0.put(r11);
        return r0;
    }

    public static void c(String r4) {
        com.bytedance.apm.launch.a.a().b("onStartEnd " + j + " " + k);
        if (k == 0) goto L5;
        return;
    L5:
        if (o == false) goto L9;
        k = System.currentTimeMillis();
        return;
    }

    public static void d() {
        if (com.bytedance.apm.b.j() != (-1)) goto L6;
        com.bytedance.apm.launch.a.a().b("auto launch mode not init");     // Catch: JSONException -> L16
        return;
    L6:
        long r0 = n - f1094b;     // Catch: JSONException -> L16
        if (r0 > 0) goto L9;
        return;
    L9:
        if (r0 > p) goto L19;
        JSONArray r1 = c();     // Catch: JSONException -> L16
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L16
        r2.put(ActivityLifecycle.NAME, "launch_stats");     // Catch: JSONException -> L16
        r2.put(CommonConsts.APM_INNER_EVENT_COST_START, f1094b);     // Catch: JSONException -> L16
        r2.put("end", n);     // Catch: JSONException -> L16
        r2.put("spans", r1);     // Catch: JSONException -> L16
        r2.put("collect_from", 1);     // Catch: JSONException -> L16
        r2.put("page_name", f1093a);     // Catch: JSONException -> L16
        r2.put(CrashBody.LAUNCH_MODE, com.bytedance.apm.b.j());     // Catch: JSONException -> L16
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L16
        r8.put("trace", r2);     // Catch: JSONException -> L16
        if (com.bytedance.apm.b.k() == false) goto L14;
        com.bytedance.apm.launch.a.a().b("auto span: " + r2);     // Catch: JSONException -> L16
    L14:
        com.bytedance.apm.data.pipeline.a.b().a(new e("start_trace", "", null, null, r8));     // Catch: JSONException -> L16
        return;
    L19:
        return;
    }

    public static void d(String r4) {
        com.bytedance.apm.launch.a.a().b(r4 + " onResume " + l);
        if (l == 0) goto L5;
        return;
    L5:
        if (o == false) goto L9;
        l = System.currentTimeMillis();
        return;
    }

    public static void e(String r5) {
        com.bytedance.apm.launch.a.a().b("OnWindowFocusChanged " + r5 + " " + n + " " + f + " " + o);
        if (n == 0) goto L5;
    L9:
        com.bytedance.apm.l.b.a().a(new AnonymousClass1());
        return;
    L5:
        if (f <= 0) goto L9;
        if (o == false) goto L9;
        n = System.currentTimeMillis();
        f1093a = r5;
        o = false;
        goto L9
    }
}
