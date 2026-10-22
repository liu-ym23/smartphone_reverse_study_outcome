package g;

import androidx.annotation.WorkerThread;
import com.bytedance.apm.d;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y.e;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f8883a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f8884b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f8885c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f8886d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f8887e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f8888f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f8889g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f8890h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f8891i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f8892j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static long f8893k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static long f8894l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static long f8895m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static boolean f8896n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f8897o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static long f8898p = 15000;

    /* JADX INFO: renamed from: g.a$a, reason: collision with other inner class name */
    static class RunnableC0169a implements Runnable {
        RunnableC0169a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.j();
        }
    }

    static {
    }

    public static JSONArray a() {
        JSONArray r10 = new JSONArray();
        JSONObject r11 = new JSONObject();
        r11.put("module_name", "base");
        r11.put("span_name", "app_constructor");
        r11.put(CommonConsts.APM_INNER_EVENT_COST_START, f8883a);
        r11.put("end", f8884b);
        JSONObject r12 = new JSONObject();
        r12.put("module_name", "base");
        r12.put("span_name", "app_attachBaseContext");
        r12.put(CommonConsts.APM_INNER_EVENT_COST_START, f8885c);
        r12.put("end", f8886d);
        JSONObject r13 = new JSONObject();
        r13.put("module_name", "base");
        r13.put("span_name", "app_onCreate");
        r13.put(CommonConsts.APM_INNER_EVENT_COST_START, f8887e);
        r13.put("end", f8888f);
        JSONObject r14 = new JSONObject();
        r14.put("module_name", "base");
        r14.put("span_name", "activity_onCreate");
        r14.put(CommonConsts.APM_INNER_EVENT_COST_START, f8889g);
        r14.put("end", f8890h);
        JSONObject r15 = new JSONObject();
        r15.put("module_name", "base");
        r15.put("span_name", "activity_onResume");
        r15.put(CommonConsts.APM_INNER_EVENT_COST_START, f8893k);
        r15.put("end", f8894l);
        JSONObject r16 = new JSONObject();
        r16.put("module_name", "base");
        r16.put("span_name", "activity_onStart");
        r16.put(CommonConsts.APM_INNER_EVENT_COST_START, f8891i);
        r16.put("end", f8892j);
        if (f8895m <= 0) goto L5;
        JSONObject r17 = new JSONObject();
        r17.put("module_name", "base");
        r17.put("span_name", "activity_onWindowFocusChanged");
        r17.put(CommonConsts.APM_INNER_EVENT_COST_START, f8895m);
        r10.put(r17);
    L5:
        r10.put(r11);
        r10.put(r12);
        r10.put(r13);
        r10.put(r14);
        r10.put(r15);
        r10.put(r16);
        return r10;
    }

    public static void b(long r10, long r11, long r12, long r13, long r14, long r15) {
        c0.a.b().d("assignAppTime: " + f8888f);
        f8883a = r10;
        f8884b = r11;
        f8885c = r12;
        f8886d = r13;
        f8887e = r14;
        f8888f = r15;
        d.N(r10);
    }

    public static void c() {
        c0.a.b().d("onCreateEnd " + f8889g + " " + f8890h);
        if (f8890h == 0) goto L5;
        return;
    L5:
        if (f8896n == false) goto L9;
        f8890h = System.currentTimeMillis();
        return;
    }

    public static void d(String r11) {
        c0.a r10 = c0.a.b();
        StringBuilder r12 = new StringBuilder();
        r12.append(r11);
        r12.append(" onCreateStart ");
        r12.append(f8889g);
        r12.append(" ");
        boolean r13 = false;
        if ((f8889g - f8888f) >= 800) goto L5;
        boolean r14 = true;
    L6:
        r12.append(r14);
        r10.d(r12.toString());
        if (f8889g != 0) goto L15;
        f8889g = System.currentTimeMillis();
        c0.a r15 = c0.a.b();
        StringBuilder r16 = new StringBuilder();
        r16.append(r11);
        r16.append(" onCreateStart ");
        r16.append(f8889g);
        r16.append("  ");
        r16.append(f8888f);
        r16.append(" ");
        if ((f8889g - f8888f) >= 800) goto L11;
        r13 = true;
    L11:
        r16.append(r13);
        r15.d(r16.toString());
        if ((f8889g - f8888f) >= 800) goto L16;
        f8896n = true;
        f8897o = r11;
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r14 = false;
        goto L6
    }

    public static void e() {
        c0.a.b().d("onResumeEnd " + f8893k + " " + f8894l);
        if (f8894l == 0) goto L5;
        return;
    L5:
        if (f8896n == false) goto L9;
        f8894l = System.currentTimeMillis();
        return;
    }

    public static void f(String r10) {
        c0.a.b().d(r10 + " onResume " + f8893k);
        if (f8893k == 0) goto L5;
        return;
    L5:
        if (f8896n == false) goto L9;
        f8893k = System.currentTimeMillis();
        return;
    }

    public static void g(String r10) {
        c0.a.b().d("onStartEnd " + f8891i + " " + f8892j);
        if (f8892j == 0) goto L5;
        return;
    L5:
        if (f8896n == false) goto L9;
        f8892j = System.currentTimeMillis();
        return;
    }

    public static void h(String r10) {
        c0.a.b().d(r10 + " onStart " + f8891i);
        if (f8891i == 0) goto L5;
        return;
    L5:
        if (f8896n == false) goto L9;
        f8891i = System.currentTimeMillis();
        return;
    }

    public static void i(String r10) {
        c0.a.b().d("OnWindowFocusChanged " + r10 + " " + f8895m + " " + f8887e + " " + f8896n);
        if (f8895m == 0) goto L5;
    L9:
        q0.b.f().i(new RunnableC0169a());
        return;
    L5:
        if (f8887e <= 0) goto L9;
        if (f8896n == false) goto L9;
        f8895m = System.currentTimeMillis();
        f8897o = r10;
        f8896n = false;
        goto L9
    }

    @WorkerThread
    public static void j() {
        if (d.u() != (-1)) goto L6;
        c0.a.b().d("auto launch mode not init");     // Catch: JSONException -> L16
        return;
    L6:
        long r10 = f8895m - f8883a;     // Catch: JSONException -> L16
        if (r10 > 0) goto L9;
        return;
    L9:
        if (r10 > f8898p) goto L19;
        JSONArray r11 = a();     // Catch: JSONException -> L16
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L16
        r12.put(ActivityLifecycle.NAME, "launch_stats");     // Catch: JSONException -> L16
        r12.put(CommonConsts.APM_INNER_EVENT_COST_START, f8883a);     // Catch: JSONException -> L16
        r12.put("end", f8895m);     // Catch: JSONException -> L16
        r12.put("spans", r11);     // Catch: JSONException -> L16
        r12.put("collect_from", 1);     // Catch: JSONException -> L16
        r12.put("page_name", f8897o);     // Catch: JSONException -> L16
        r12.put(CrashBody.LAUNCH_MODE, d.u());     // Catch: JSONException -> L16
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L16
        r13.put("trace", r12);     // Catch: JSONException -> L16
        if (d.D() == false) goto L14;
        c0.a.b().d("auto span: " + r12);     // Catch: JSONException -> L16
    L14:
        x.a.p().e(new e("start_trace", "", null, null, r13));     // Catch: JSONException -> L16
        return;
    L19:
        return;
    }

    public static void k(long r10) {
        f8898p = r10;
    }
}
