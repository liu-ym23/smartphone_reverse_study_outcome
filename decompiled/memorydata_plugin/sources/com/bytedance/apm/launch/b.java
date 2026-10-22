package com.bytedance.apm.launch;

import com.bytedance.apm.util.s;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1417a = false;

    static {
    }

    public static e.a a(long r2) {
        if (f1417a == false) goto L5;
        return null;
    L5:
        f1417a = true;
        if (a.a().b().a() == true) goto L9;
        return null;
    L9:
        if (com.bytedance.apm.internal.a.b(4) == true) goto L12;
        return null;
    L12:
        return e.a(r2);
    }

    public static JSONArray a(List<s> r15, long r16, long r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        JSONArray r2 = new JSONArray();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        s r3 = (s) ZeusTransformUtils.preCheckCast(r1.next(), s.class, "com.obric.memorydata.plugin");
        JSONObject r4 = new JSONObject();
        r4.put(ActivityLifecycle.NAME, r3.f1501b);
        r4.put("utm", r3.e);
        r4.put("stm", r3.f);
        r4.put("duration", r3.h);
        r4.put("usage_for_t_duration", String.format("%.5f", new Object[]{Float.valueOf(r3.d)}));
        r4.put("usage_for_p_duration", String.format("%.5f", new Object[]{Float.valueOf((r3.c * 1.0f) / r16)}));
        r4.put("usage_for_p_cpu", String.format("%.5f", new Object[]{Float.valueOf((r3.c * 1.0f) / r18)}));
        if (com.bytedance.apm.b.k() == false) goto L8;
        Logger.i("LaunchPerfData", "packThreadItem: " + r4);
    L8:
        r2.put(r4);
        goto L4
    L9:
        return r2;
    }

    public static JSONObject a(e.a r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
    L71:
        th = move-exception;
        th.printStackTrace();
        a.a().a(th.getLocalizedMessage());
        return null;
    L7:
        if (r11.b() == (-1)) goto L10;
        r2.put("launch_perf_gc_count", r11.b());     // Catch: Throwable -> L71
    L10:
        if (r11.c() == (-1)) goto L13;
        r2.put("launch_perf_gc_time", r11.c());     // Catch: Throwable -> L71
    L13:
        if (r11.d() == (-1)) goto L16;
        r2.put("launch_perf_block_gc_count", r11.d());     // Catch: Throwable -> L71
    L16:
        if (r11.e() == (-1)) goto L19;
        r2.put("launch_perf_block_gc_time", r11.e());     // Catch: Throwable -> L71
    L19:
        if (r11.f() == (-1.0d)) goto L22;
        r2.put("launch_perf_iowait_time", r11.f());     // Catch: Throwable -> L71
    L22:
        if (r11.g() == (-1.0d)) goto L25;
        r2.put("launch_perf_runnable_time", r11.g());     // Catch: Throwable -> L71
    L25:
        if (r11.h() == (-1.0d)) goto L28;
        r2.put("launch_perf_sleep_time", r11.h());     // Catch: Throwable -> L71
    L28:
        if (r11.i() == (-1)) goto L31;
        r2.put("launch_perf_minfor_fault", r11.i());     // Catch: Throwable -> L71
    L31:
        if (r11.j() == (-1)) goto L34;
        r2.put("launch_perf_major_fault", r11.j());     // Catch: Throwable -> L71
    L34:
        if (r11.l() == (-1.0d)) goto L37;
        r2.put("launch_perf_cpu_time", r11.l());     // Catch: Throwable -> L71
    L37:
        if (r11.m() == (-1)) goto L40;
        r2.put("launch_perf_voluntary_switches", r11.m());     // Catch: Throwable -> L71
    L40:
        if (r11.n() == (-1)) goto L43;
        r2.put("launch_perf_involuntary_switches", r11.n());     // Catch: Throwable -> L71
    L43:
        if (r11.k() == (-1)) goto L46;
        r2.put("launch_perf_all_thread_count", r11.k());     // Catch: Throwable -> L71
    L46:
        if (r11.o() == (-1)) goto L49;
        r2.put("launch_perf_lock_time", r11.o());     // Catch: Throwable -> L71
    L49:
        if (r11.p() == (-1)) goto L51;
        r2.put("launch_perf_binder_time", r11.p());     // Catch: Throwable -> L71
    L51:
        r1.put("list_data", r2);     // Catch: Throwable -> L71
        List<String> r3 = r11.a();     // Catch: Throwable -> L71
        if (r3 == null) goto L61;
        if (r3.isEmpty() == true) goto L61;
        JSONArray r4 = new JSONArray();     // Catch: Throwable -> L71
        Iterator<String> r5 = r3.iterator();     // Catch: Throwable -> L71
    L57:
        if (r5.hasNext() == false) goto L59;
        r4.put((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L71
        goto L57
    L59:
        r1.put("current_thread_list", r4);     // Catch: Throwable -> L71
    L61:
        if (r11.q() > 0) goto L63;
    L69:
        a.a().b("perf data: " + r1);     // Catch: Throwable -> L71
        return r1;
    L63:
        if (r11.r() <= 0) goto L69;
        if (r11.s() == null) goto L69;
        if (r11.s().size() <= 0) goto L69;
        r1.put("process_cpu_time", r11.q());     // Catch: Throwable -> L71
        r1.put("process_duration", r11.r());     // Catch: Throwable -> L71
        r1.put("thread_cpu_info", a(r11.s(), r11.r(), r11.q()));     // Catch: Throwable -> L71
        goto L69
    }
}
