package r0;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.launch.evil.LaunchSleepDetector;
import com.bytedance.apm6.perf.base.CommonDataAssembly;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.monitor.collector.k;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t.f;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f12537f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, b0.b> f12540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f12541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f12542e;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c0.e.b f12543c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f12544g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f12545h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f12546i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ e f12547j;

        a(e r10, c0.e.b r11, int r12, String r13, String r14) {
            this.f12547j = r10;
            this.f12543c = r11;
            this.f12544g = r12;
            this.f12545h = r13;
            this.f12546i = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.a(this.f12547j) == false) goto L9;
            long r10 = com.bytedance.apm.launch.evil.a.a();
            if (r10 == 0) goto L9;
            c0.e.b r11 = this.f12543c;
            if (r11 == null) goto L9;
            r11.M(r10);
        L9:
            e r12 = this.f12547j;
            e.c(r12, this.f12544g, this.f12545h, this.f12546i, e.b(r12), this.f12543c);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long[] f12548c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f12549g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f12550h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f12551i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f12552j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f12553k;

        b(e r10, long[] r11, long r12, long r13, long r14, int r15, String r16) {
            this.f12548c = r11;
            this.f12549g = r12;
            this.f12550h = r13;
            this.f12551i = r14;
            this.f12552j = r15;
            this.f12553k = r16;
        }

        @Override // java.lang.Runnable
        public void run() {
            String r10 = f.E().A(this.f12548c, this.f12549g);     // Catch: Throwable -> L8
            if (TextUtils.isEmpty(r10) == false) goto L6;
            return;
        L6:
            long r11 = this.f12550h - this.f12551i;     // Catch: Throwable -> L8
            JSONObject r12 = k.n().e();     // Catch: Throwable -> L8
            JSONObject r13 = new JSONObject();     // Catch: Throwable -> L8
            r13.put("is_main_process", com.bytedance.apm.d.I());     // Catch: Throwable -> L8
            r13.put("block_duration", r11);     // Catch: Throwable -> L8
            r13.put("stack", r10);     // Catch: Throwable -> L8
            r13.put("stack_key", "1048574\n");     // Catch: Throwable -> L8
            r13.put("scene", "launchTrace");     // Catch: Throwable -> L8
            r13.put("cost_time", r11);     // Catch: Throwable -> L8
            r13.put("method_time", r11);     // Catch: Throwable -> L8
            r13.put("message", "launchTrace");     // Catch: Throwable -> L8
            r13.put(Constants.EVENT_TYPE, "lag_drop_frame");     // Catch: Throwable -> L8
            JSONObject r14 = PerfFilterManager.getInstance().getPerfFiltersJson(true);     // Catch: Throwable -> L8
            r14.put("crash_section", com.bytedance.apm.d.C(System.currentTimeMillis()));     // Catch: Throwable -> L8
            r14.put("trace_type", "launchTrace");     // Catch: Throwable -> L8
            r14.put("launchMode", String.valueOf(this.f12552j));     // Catch: Throwable -> L8
            r14.put("customLaunchMode", this.f12553k);     // Catch: Throwable -> L8
            r13.put("custom", r12);     // Catch: Throwable -> L8
            r13.put("filters", r14);     // Catch: Throwable -> L8
            x.a.p().e(new y.d(LogTypeName.MONITOR_TYPE_DROP_FRAME_STACK, r13));     // Catch: Throwable -> L8
            return;
        }
    }

    static {
    }

    public e(String r10, String r11) {
        this.f12540c = new ConcurrentHashMap(4);
        if ("start_trace".equals(r10) == false) goto L5;
    L9:
        this.f12541d = r10;
        this.f12542e = r11;
        return;
    L5:
        if ("page_load_trace".equals(r10) == true) goto L9;
        throw new IllegalStateException("Please add TraceServiceName support on TraceState#reportAsync");
    }

    static /* synthetic */ boolean a(e r10) {
        return r10.i();
    }

    static /* synthetic */ long b(e r10) {
        return r10.f12539b;
    }

    static /* synthetic */ void c(e r10, int r11, String r12, String r13, long r14, c0.e.b r15) {
        r10.j(r11, r12, r13, r14, r15);
    }

    @RequiresApi(api = 18)
    private void g(int r12, String r13, String r14, long r15, long r17) {
        if (r12 == (-1)) goto L5;
    L11:
        this.f12539b = System.currentTimeMillis();
        if (r17 <= 0) goto L14;
        this.f12539b = this.f12538a + r17;
    L14:
        long r10 = this.f12539b - this.f12538a;
        if (r15 > 0) goto L17;
    L19:
        c0.e.b r11 = null;
        if (i() == false) goto L22;
        r11 = c0.b.a(r10);
    L22:
        c0.e.b r16 = r11;
        if (i() == false) goto L30;
        if (l4.a.f10882s == false) goto L30;
        if (f12537f == false) goto L30;
        f12537f = false;
        k(r12, r13, this.f12538a, this.f12539b);
    L30:
        if (i() == true) goto L32;
    L41:
        q0.b.f().i(new a(this, r16, r12, r13, r14));
        if (i() == false) goto L47;
        LaunchSleepDetector.a();
        return;
    L47:
        return;
    L32:
        if (c0.a.b().c().b() == false) goto L41;
        if (com.bytedance.apm.internal.a.d(8) == false) goto L41;
        JSONObject r18 = new JSONObject();
        r18.put("is_launch_lock", true);     // Catch: JSONException -> L38
    L40:
        LockMonitorManager.endLockDetect(r18);
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L17:
        if (r10 <= r15) goto L19;
        return;
    L5:
        if (r13.isEmpty() == false) goto L11;
        if (com.bytedance.apm.d.D() == false) goto L11;
        throw new IllegalArgumentException("Launch mode is both none");
    }

    private boolean i() {
        return "start_trace".equals(this.f12541d);
    }

    private void j(int r19, String r20, String r21, long r22, @Nullable c0.e.b r24) {
        JSONArray r10 = new JSONArray();
        int r11 = 2;
        char r12 = 1;
    L29:
        e = move-exception;
        e.printStackTrace();
    L31:
        ConcurrentHashMap<String, b0.b> r13 = this.f12540c;
        if (r13 == null) goto L34;
        r13.clear();
    L34:
        JSONObject r14 = new JSONObject();
        r14.put(ActivityLifecycle.NAME, this.f12542e);     // Catch: JSONException -> L61
        r14.put("page_type", this.f12542e);     // Catch: JSONException -> L61
        r14.put(CommonConsts.APM_INNER_EVENT_COST_START, this.f12538a);     // Catch: JSONException -> L61
        r14.put("end", r22);     // Catch: JSONException -> L61
        r14.put("spans", r10);     // Catch: JSONException -> L61
        r14.put("collect_from", 2);     // Catch: JSONException -> L61
        r14.put("page_name", r21);     // Catch: JSONException -> L61
        if (r19 == (-1)) goto L39;
        r14.put(CrashBody.LAUNCH_MODE, r19);     // Catch: JSONException -> L61
    L39:
        if (r20.isEmpty() == true) goto L42;
        r14.put("custom_launch_mode", r20);     // Catch: JSONException -> L61
    L42:
        if (e0.a.e() == false) goto L45;
        e0.a.b("AppStartStats", r14.toString());     // Catch: JSONException -> L61
    L45:
        if (i() == true) goto L47;
    L50:
        JSONObject r15 = new JSONObject();
        r15.put("trace", r14);     // Catch: JSONException -> L63
        if (r24 == null) goto L56;
        JSONObject r16 = c0.b.c(r24);     // Catch: JSONException -> L63
        if (r16 == null) goto L56;
        r15.put("perf_data", r16);     // Catch: JSONException -> L63
    L56:
        y.e r17 = new y.e(this.f12541d, "", null, null, r15);
        CommonDataAssembly.wrapFilters(r17, false);
        if (com.bytedance.apm.d.D() == false) goto L59;
        com.bytedance.apm.util.k.a("AppStartStats", "reportAsync: " + r15);
    L59:
        x.a.p().e(r17);
        return;
    L47:
        if (c0.a.b().a().b() == false) goto L50;
        JSONObject r18 = new JSONObject();
        com.bytedance.apm.util.d.k().f(r18, true);
        com.bytedance.apm.util.d.k().b(r18, true);
        r14.put("device_info_data", r18);     // Catch: Throwable -> L62
        goto L50
    L4:
        if (TextUtils.equals(r21, g.a.f8897o) == false) goto L6;
        r10 = g.a.a();     // Catch: JSONException -> L29
    L6:
        ConcurrentHashMap<String, b0.b> r23 = this.f12540c;     // Catch: JSONException -> L29
        if (r23 == null) goto L31;
        if (r23.isEmpty() == true) goto L31;
        Iterator<Map.Entry<String, b0.b>> r25 = this.f12540c.entrySet().iterator();     // Catch: JSONException -> L29
    L11:
        if (r25.hasNext() == false) goto L31;
        Map.Entry<String, b0.b> r110 = r25.next();     // Catch: JSONException -> L29
        String r111 = r110.getKey();     // Catch: JSONException -> L29
        b0.b r112 = r110.getValue();     // Catch: JSONException -> L29
        if (r112.f505b == 0) goto L11;
        JSONObject r113 = new JSONObject();     // Catch: JSONException -> L29
        String[] r114 = r111.split("#");     // Catch: JSONException -> L29
        if (r114.length != r11) goto L25;
        if ("page_load_trace".equals(this.f12541d) == false) goto L22;
        r113.put(ActivityLifecycle.NAME, r114[r12]);     // Catch: JSONException -> L29
    L27:
        r113.put(CommonConsts.APM_INNER_EVENT_COST_START, r112.f504a);     // Catch: JSONException -> L29
        r113.put("end", r112.f505b);     // Catch: JSONException -> L29
        r113.put("thread", r112.f506c);     // Catch: JSONException -> L29
        r10.put(r113);     // Catch: JSONException -> L29
        r11 = 2;
        r12 = 1;
        goto L11
    L22:
        r113.put("module_name", r114[0]);     // Catch: JSONException -> L29
        String r115 = r114[1];     // Catch: JSONException -> L29
    L23:
        r113.put("span_name", r115);     // Catch: JSONException -> L29
        goto L27
    L25:
        if (r114.length != 1) goto L27;
        r115 = r114[0];     // Catch: JSONException -> L29
        goto L23
    }

    private void k(int r14, String r15, long r16, long r18) {
        long[] r10 = f.E().t();
        long r11 = SystemClock.uptimeMillis();
        if (r10 == null) goto L6;
        q0.b.f().i(new b(this, r10, r11, r18, r16, r14, r15));
        return;
    }

    public void d() {
        this.f12540c.clear();
    }

    public void e(String r10, String r11) {
        b0.b r12 = this.f12540c.get(r10 + "#" + r11);
        if (r12 != null) goto L5;
        return;
    L5:
        r12.a(System.currentTimeMillis(), Thread.currentThread().getName());
        this.f12540c.put(r10 + "#" + r11, r12);
    }

    public void f(int r10, String r11, long r12, long r13) {
        g(r10, "", r11, r12, r13);
    }

    public long h() {
        return this.f12538a;
    }

    public void l(String r10, String r11) {
        m(r10, r11, false);
    }

    public void m(String r10, String r11, boolean r12) {
        if (this.f12540c.get(r10 + "#" + r11) == null) goto L5;
        if (r12 == true) goto L5;
        return;
    L5:
        b0.b r13 = new b0.b(System.currentTimeMillis());
        this.f12540c.put(r10 + "#" + r11, r13);
    }

    public void n() {
        this.f12538a = System.currentTimeMillis();
    }
}
