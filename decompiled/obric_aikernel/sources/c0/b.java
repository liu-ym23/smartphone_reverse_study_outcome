package c0;

import com.bytedance.apm.util.v;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f577a = false;

    static {
    }

    public static e.b a(long r10) {
        if (f577a == false) goto L5;
        return null;
    L5:
        f577a = true;
        if (a.b().a().d() == true) goto L9;
        return null;
    L9:
        if (com.bytedance.apm.internal.a.d(4) == true) goto L12;
        return null;
    L12:
        return e.c(r10);
    }

    public static JSONArray b(List<v> r11, long r12, long r14) {
        JSONArray r10 = new JSONArray();
        Iterator<v> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        v r15 = r13.next();
        JSONObject r16 = new JSONObject();
        r16.put(ActivityLifecycle.NAME, r15.f1150b);
        r16.put("utm", r15.f1153e);
        r16.put("stm", r15.f1154f);
        r16.put("duration", r15.f1155g);
        r16.put("usage_for_t_duration", String.format("%.5f", new Object[]{Float.valueOf(r15.f1152d)}));
        r16.put("usage_for_p_duration", String.format("%.5f", new Object[]{Float.valueOf((r15.f1151c * 1.0f) / r12)}));
        r16.put("usage_for_p_cpu", String.format("%.5f", new Object[]{Float.valueOf((r15.f1151c * 1.0f) / r14)}));
        if (com.bytedance.apm.d.D() == false) goto L8;
        Logger.i("LaunchPerfData", "packThreadItem: " + r16);
    L8:
        r10.put(r16);
        goto L4
    L9:
        return r10;
    }

    public static JSONObject c(e.b r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        JSONObject r10 = new JSONObject();
        JSONObject r12 = new JSONObject();
    L71:
        th = move-exception;
        th.printStackTrace();
        a.b().e(th.getLocalizedMessage());
        return null;
    L7:
        if (r11.y() == (-1)) goto L10;
        r12.put("launch_perf_gc_count", r11.y());     // Catch: Throwable -> L71
    L10:
        if (r11.z() == (-1)) goto L13;
        r12.put("launch_perf_gc_time", r11.z());     // Catch: Throwable -> L71
    L13:
        if (r11.v() == (-1)) goto L16;
        r12.put("launch_perf_block_gc_count", r11.v());     // Catch: Throwable -> L71
    L16:
        if (r11.w() == (-1)) goto L19;
        r12.put("launch_perf_block_gc_time", r11.w());     // Catch: Throwable -> L71
    L19:
        if (r11.B() == (-1.0d)) goto L22;
        r12.put("launch_perf_iowait_time", r11.B());     // Catch: Throwable -> L71
    L22:
        if (r11.I() == (-1.0d)) goto L25;
        r12.put("launch_perf_runnable_time", r11.I());     // Catch: Throwable -> L71
    L25:
        if (r11.J() == (-1.0d)) goto L28;
        r12.put("launch_perf_sleep_time", r11.J());     // Catch: Throwable -> L71
    L28:
        if (r11.F() == (-1)) goto L31;
        r12.put("launch_perf_minfor_fault", r11.F());     // Catch: Throwable -> L71
    L31:
        if (r11.E() == (-1)) goto L34;
        r12.put("launch_perf_major_fault", r11.E());     // Catch: Throwable -> L71
    L34:
        if (r11.x() == (-1.0d)) goto L37;
        r12.put("launch_perf_cpu_time", r11.x());     // Catch: Throwable -> L71
    L37:
        if (r11.L() == (-1)) goto L40;
        r12.put("launch_perf_voluntary_switches", r11.L());     // Catch: Throwable -> L71
    L40:
        if (r11.A() == (-1)) goto L43;
        r12.put("launch_perf_involuntary_switches", r11.A());     // Catch: Throwable -> L71
    L43:
        if (r11.t() == (-1)) goto L46;
        r12.put("launch_perf_all_thread_count", r11.t());     // Catch: Throwable -> L71
    L46:
        if (r11.D() == (-1)) goto L49;
        r12.put("launch_perf_lock_time", r11.D());     // Catch: Throwable -> L71
    L49:
        if (r11.u() == (-1)) goto L51;
        r12.put("launch_perf_binder_time", r11.u());     // Catch: Throwable -> L71
    L51:
        r10.put("list_data", r12);     // Catch: Throwable -> L71
        List<String> r13 = r11.C();     // Catch: Throwable -> L71
        if (r13 == null) goto L61;
        if (r13.isEmpty() == true) goto L61;
        JSONArray r14 = new JSONArray();     // Catch: Throwable -> L71
        Iterator<String> r15 = r13.iterator();     // Catch: Throwable -> L71
    L57:
        if (r15.hasNext() == false) goto L59;
        r14.put(r15.next());     // Catch: Throwable -> L71
        goto L57
    L59:
        r10.put("current_thread_list", r14);     // Catch: Throwable -> L71
    L61:
        if (r11.G() > 0) goto L63;
    L69:
        a.b().d("perf data: " + r10);     // Catch: Throwable -> L71
        return r10;
    L63:
        if (r11.H() <= 0) goto L69;
        if (r11.K() == null) goto L69;
        if (r11.K().size() <= 0) goto L69;
        r10.put("process_cpu_time", r11.G());     // Catch: Throwable -> L71
        r10.put("process_duration", r11.H());     // Catch: Throwable -> L71
        r10.put("thread_cpu_info", b(r11.K(), r11.H(), r11.G()));     // Catch: Throwable -> L71
        goto L69
    }
}
