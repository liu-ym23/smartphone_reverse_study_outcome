package com.bytedance.apm.battery;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.BatteryAgent;
import com.bytedance.apm.battery.d.g;
import com.bytedance.apm.battery.d.h;
import com.bytedance.apm.battery.d.i;
import com.bytedance.apm.battery.d.j;
import com.bytedance.apm.battery.d.k;
import com.bytedance.apm.battery.d.l;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.util.n;
import com.bytedance.apm.util.s;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.crash.dumper.Scraps;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm.h.a implements com.bytedance.apm.battery.e.a.InterfaceC0086a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f1113a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, l> f1114b;
    private volatile long c;
    private volatile boolean d;
    private volatile boolean e;
    private volatile long f;
    private volatile long h;
    private volatile long i;
    private List<String> j;
    private boolean k;
    private volatile boolean l;
    private int m;
    private String n;
    private String[] o;
    private List<String> p;
    private String q;
    private HashMap<Integer, s> r;
    private HashMap<Integer, s> s;
    private long t;
    private HashMap<String, Integer> u;
    private boolean v;
    private final com.bytedance.monitor.util.thread.d w;
    private final com.bytedance.monitor.util.thread.d x;

    /* JADX INFO: renamed from: com.bytedance.apm.battery.a$a, reason: collision with other inner class name */
    private static final class C0081a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f1123a = null;

        static {
            f1123a = new a(null);
        }

        static /* synthetic */ a a() {
            return f1123a;
        }
    }

    static {
        f1113a = new Object();
    }

    private a() {
        this.f1114b = new ConcurrentHashMap();
        this.c = -1;
        this.e = false;
        this.h = 30;
        this.i = -1;
        this.m = 32;
        this.o = new String[2];
        this.p = new ArrayList();
        this.r = new HashMap();
        this.s = new HashMap();
        this.u = new HashMap();
        this.w = new AnonymousClass5(this);
        this.x = new AnonymousClass7(this);
        this.g = Scraps.BATTERY;
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ long a(a r0, long r1) {
        r0.i = r1;
        return r1;
    }

    public static a a() {
        return C0081a.a();
    }

    private void a(String r3) {
        if (r() == false) goto L5;
        return;
    L5:
        com.bytedance.apm.e.a.b("APM-Battery", "ToFront:" + r3);
        com.bytedance.apm.battery.c.a.a().a(r3);
        com.bytedance.apm.l.b.a().b(new AnonymousClass2(this));
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.n();
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.v = r1;
        return r1;
    }

    static /* synthetic */ Map b(a r0) {
        return r0.f1114b;
    }

    private void b(long r14) {
        if (this.d == false) goto L5;
    L11:
        String r2 = "cpu_monitor_function_front_threshold";
        if (this.u.containsKey("cpu_monitor_function_front_threshold") == false) goto L14;
    L13:
        int r0 = ((Integer) ZeusTransformUtils.preCheckCast(this.u.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L15:
        Map<String, BatteryAgent.a> r1 = BatteryAgent.filterResultAndClear((((long) r0) * r14) / 100);
        if (c(r14) == false) goto L45;
        JSONObject r3 = new JSONObject();
        int r4 = 0;
        boolean r5 = true;
        if (r1 != null) goto L20;
    L26:
        boolean r6 = false;
    L28:
        if (this.s.isEmpty() == true) goto L38;
        ArrayList r7 = new ArrayList(this.s.values());
        Collections.sort(r7, new AnonymousClass6(this));
        JSONArray r8 = new JSONArray();
        int r9 = 100;
        if (this.u.containsKey("cpu_monitor_thread_count") == false) goto L33;
        r9 = ((Integer) ZeusTransformUtils.preCheckCast(this.u.get("cpu_monitor_thread_count"), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L33:
        if (r4 >= Math.min(r7.size(), r9)) goto L37;
        s r10 = (s) ZeusTransformUtils.preCheckCast(r7.get(r4), s.class, "com.obric.memorydata.plugin");
        if (r10.c <= 0) goto L37;
        JSONObject r11 = new JSONObject();
        r4 = r4 + 1;
        r11.putOpt("rank", Integer.valueOf(r4));
        r11.putOpt(LBSLightLocationTraceLogger.THREAD_NAME, r10.f1501b);
        r11.putOpt("cpu_cost", Long.valueOf(r10.c));
        r8.put(r11);
    L37:
        r3.putOpt("threads", r8);
    L39:
        if (r5 == false) goto L45;
        if (this.d == false) goto L43;
        String r12 = com.bytedance.apm.battery.c.a.a().b();
    L44:
        JSONObject r13 = new JSONObject();
        r13.putOpt(MemoryInfoSectionEditActivity.KIND_SCENE, r12);
        JSONObject r15 = new JSONObject();
        r15.putOpt("stay_duration", Long.valueOf(r14));
        com.bytedance.apm.e.a.b("APM-BatteryLocal", "scene:" + r12 + " stayDuration:" + r14 + " data:" + r3);
        com.bytedance.apm.a.a("monitor_expend_function", r13, r15, r3);
        goto L45
    L43:
        r12 = TraceCons.METRIC_BACKGROUND;
        goto L44
    L38:
        r5 = r6;
        goto L39
    L20:
        if (r1.isEmpty() == true) goto L26;
        JSONArray r16 = new JSONArray();
        Iterator<Map.Entry<String, BatteryAgent.a>> r17 = r1.entrySet().iterator();
    L23:
        if (r17.hasNext() == false) goto L25;
        Map.Entry r18 = (Map.Entry) ZeusTransformUtils.preCheckCast(r17.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        JSONObject r19 = new JSONObject();
        r19.putOpt("method", r18.getKey());
        r19.putOpt("exe_count", Integer.valueOf(((BatteryAgent.a) ZeusTransformUtils.preCheckCast(r18.getValue(), BatteryAgent.a.class, "com.obric.memorydata.plugin")).a()));
        r19.putOpt("cpu_cost", Integer.valueOf(((BatteryAgent.a) ZeusTransformUtils.preCheckCast(r18.getValue(), BatteryAgent.a.class, "com.obric.memorydata.plugin")).b()));
        r16.put(r19);
        goto L23
    L25:
        r3.putOpt("functions", r16);
        r6 = true;
    L45:
        o();
        return;
    L14:
        r0 = 5;
        goto L15
    L5:
        if (TextUtils.isEmpty(this.q) == false) goto L11;
        r2 = "cpu_monitor_function_background_threshold";
        if (this.u.containsKey("cpu_monitor_function_background_threshold") == true) goto L13;
        r0 = 2;
        goto L15
    }

    static /* synthetic */ boolean b(a r0, boolean r1) {
        return r0.c(r1);
    }

    private boolean c(long r7) {
        if (this.d == false) goto L12;
        int r0 = 20;
        if (this.u.containsKey("cpu_monitor_front_valid_duration") == false) goto L8;
        r0 = ((Integer) ZeusTransformUtils.preCheckCast(this.u.get("cpu_monitor_front_valid_duration"), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L8:
        if (r7 <= (r0 * 1000)) goto L11;
        return true;
    L11:
        return false;
    L12:
        int r1 = 60;
        if (this.u.containsKey("cpu_monitor_background_duration") == false) goto L16;
        r1 = ((Integer) ZeusTransformUtils.preCheckCast(this.u.get("cpu_monitor_background_duration"), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L16:
        if (r7 <= (r1 * 1000)) goto L19;
        return true;
    L19:
        return false;
    }

    static /* synthetic */ boolean c(a r0) {
        return r0.e;
    }

    static /* synthetic */ boolean c(a r0, boolean r1) {
        r0.d = r1;
        return r1;
    }

    private boolean c(boolean r19) {
        long r1 = SystemClock.elapsedRealtime();
        long r3 = r1 - this.c;
        if (r3 <= 2000) goto L5;
        boolean r5 = true;
    L6:
        boolean r14 = r5;
        if (this.c == (-1)) goto L14;
        if (r14 == false) goto L14;
        boolean r17 = r14;
        com.bytedance.apm.battery.c.a.a().a(new com.bytedance.apm.c.a(this.d, System.currentTimeMillis(), "ground_record", this.v, r3, this.q));
        if (this.d == false) goto L16;
        if (r3 <= 7200000) goto L16;
        HashMap r6 = new HashMap();
        r6.put("duration", String.valueOf(r3));
        com.bytedance.services.apm.api.a.a("BatterErrorDuration", r6);
    L16:
        if (this.c == (-1)) goto L21;
        if (r19 == false) goto L21;
        if (q() == false) goto L21;
        b(r3);
    L21:
        this.c = r1;
        return r17;
    L14:
        r17 = r14;
        goto L16
    L5:
        r5 = false;
        goto L6
    }

    static /* synthetic */ long d(a r2) {
        return r2.i;
    }

    static /* synthetic */ long e(a r2) {
        return r2.h;
    }

    static /* synthetic */ void f(a r0) {
        r0.p();
    }

    static /* synthetic */ boolean g(a r0) {
        return r0.d;
    }

    static /* synthetic */ HashMap h(a r0) {
        return r0.u;
    }

    static /* synthetic */ com.bytedance.monitor.util.thread.d i(a r0) {
        return r0.x;
    }

    static /* synthetic */ Object i() {
        return f1113a;
    }

    private void m() {
        if (r() == false) goto L5;
        return;
    L5:
        com.bytedance.apm.e.a.b("APM-Battery", "ToBack");
        com.bytedance.apm.battery.c.a.a().a(ActivityLifeObserver.getInstance().getTopActivityClassName());
        com.bytedance.apm.l.b.a().b(new AnonymousClass3(this));
    }

    private boolean n() {
        return c(false);
    }

    private void o() {
        this.r.clear();
        this.s.clear();
        LinkedList<s> r0 = com.bytedance.apm.util.b.b(Process.myPid());
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L13;
        Iterator<s> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        s r2 = (s) ZeusTransformUtils.preCheckCast(r1.next(), s.class, "com.obric.memorydata.plugin");
        this.r.put(Integer.valueOf(r2.f1500a), r2);
        goto L9
    L14:
        return;
    }

    private void p() {
        if (this.r.isEmpty() == false) goto L5;
        return;
    L5:
        LinkedList<s> r0 = com.bytedance.apm.util.b.b(Process.myPid());
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isEmpty() == true) goto L31;
        Iterator<s> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L32;
        s r2 = (s) ZeusTransformUtils.preCheckCast(r1.next(), s.class, "com.obric.memorydata.plugin");
        boolean r3 = this.r.containsKey(Integer.valueOf(r2.f1500a));
        long r4 = r2.c;
        if (r3 == false) goto L17;
        r4 = r4 - ((s) ZeusTransformUtils.preCheckCast(this.r.get(Integer.valueOf(r2.f1500a)), s.class, "com.obric.memorydata.plugin")).c;
    L17:
        if (r4 <= 0) goto L12;
        long r5 = (long) ((r4 / this.t) * 1000.0d);
        if (this.s.containsKey(Integer.valueOf(r2.f1500a)) == true) goto L20;
        this.s.put(Integer.valueOf(r2.f1500a), new s(r2.f1500a, r2.f1501b, r5));
        goto L12
    L20:
        ((s) ZeusTransformUtils.preCheckCast(this.s.get(Integer.valueOf(r2.f1500a)), s.class, "com.obric.memorydata.plugin")).a(r5);
        goto L12
    L32:
        return;
    }

    private boolean q() {
        if (BatteryAgent.hasHook() == false) goto L5;
        return true;
    L5:
        if (this.u.containsKey("monitor_enable") == true) goto L7;
    L9:
        return false;
    L7:
        if (((Integer) ZeusTransformUtils.preCheckCast(this.u.get("monitor_enable"), Integer.class, "com.obric.memorydata.plugin")).intValue() != 1) goto L9;
        return true;
    }

    private boolean r() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L8:
        return true;
    L5:
        if (Build.VERSION.SDK_INT > this.m) goto L8;
        return false;
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void a(Activity r3) {
        super.a((Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin"));
        m();
    }

    @Override // com.bytedance.apm.h.a
    public void a(JSONObject r13) {
        this.f = r13.optLong("battery_record_interval", 10);
        this.h = r13.optLong("battery_report_interval", 30);
        int r0 = r13.optInt(SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD, 0);
        boolean r2 = true;
        if (r0 == 1) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.e = r3;
        this.m = r13.optInt("support_max_api_level", this.m);
        if (com.bytedance.apm.b.k() == false) goto L12;
        com.bytedance.apm.e.e.a(com.bytedance.apm.e.b.f1308b, new String[]{"mRecordInterval:" + this.f + ",mBatteryCollectEnabled" + r0});
    L12:
        if (this.e == true) goto L17;
        if (this.k == true) goto L17;
        this.f1114b.clear();
        ActivityLifeObserver.getInstance().unregister(this);
        com.bytedance.apm.battery.e.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this);
    L20:
        if (r13.optInt("trace_enable", 0) == 1) goto L23;
        r2 = false;
    L23:
        this.l = r2;
        if (this.l == false) goto L26;
        com.bytedance.apm.battery.a.a.a(r13.optLong("max_single_wake_lock_hold_time_second", 120) * 1000);
        com.bytedance.apm.battery.a.a.a(r13.optInt("max_total_wake_lock_acquire_count", 5));
        com.bytedance.apm.battery.a.a.b(r13.optLong("max_total_wake_lock_hold_time_second", 240) * 1000);
        com.bytedance.apm.battery.a.a.b(r13.optInt("max_wake_up_alarm_invoke_count", 5));
        com.bytedance.apm.battery.a.a.c(r13.optInt("max_normal_alarm_invoke_count", 10));
        com.bytedance.apm.battery.a.a.c(r13.optLong("max_single_loc_request_time_second", 120) * 1000);
        com.bytedance.apm.battery.a.a.d(r13.optInt("max_total_loc_request_count", 5));
        com.bytedance.apm.battery.a.a.d(r13.optLong("max_total_loc_request_time_second", 240) * 1000);
    L26:
        JSONObject r1 = r13.optJSONObject("cpu_monitor_config");
        if (r1 == null) goto L37;
        Iterator<String> r4 = r1.keys();
    L30:
        if (r4.hasNext() == false) goto L37;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        if ("monitor_enable".equals(r5) == true) goto L33;
        int r6 = r1.optInt(r5, 0);
        if (r6 <= 0) goto L30;
        this.u.put(r5, Integer.valueOf(r6));
        goto L30
    L33:
        this.u.put(r5, Integer.valueOf(r1.optInt(r5, 0)));
    L37:
        this.j = n.b(r13, "scene_black_list");
        if (q() == false) goto L49;
        com.bytedance.apm.l.b.a().b(this.x);
        o();
        return;
    L49:
        return;
    L17:
        if (r13.optInt("battery_net_for_all_interface_enable", 0) != 1) goto L20;
        this.f1114b.put("traffic_all_interface", new i());
        goto L20
    L5:
        if (this.f <= 0) goto L7;
        r3 = true;
        goto L8
    }

    public void a(boolean r1) {
        this.k = r1;
        j();
    }

    @Override // com.bytedance.apm.h.a
    public void b() {
        if (r() == false) goto L5;
        return;
    L5:
        com.bytedance.apm.e.a.b("APM-Battery", "Battery init process" + com.bytedance.apm.b.e());
        this.d = ActivityLifeObserver.getInstance().isForeground();
        this.o[1] = ActivityLifeObserver.getInstance().getTopActivityClassName();
        this.t = com.bytedance.apm.util.b.a(100);
        this.v = com.bytedance.apm.battery.e.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this);
        com.bytedance.apm.battery.d.d r3 = new com.bytedance.apm.battery.d.d();
        g r5 = new g();
        k r6 = new k();
        com.bytedance.apm.battery.b.a r7 = new com.bytedance.apm.battery.b.a();     // Catch: Throwable -> L8
        r7.a(NotificationCompat.CATEGORY_ALARM, r3);     // Catch: Throwable -> L8
        r7.a("location", r5);     // Catch: Throwable -> L8
        r7.a("power", r6);     // Catch: Throwable -> L8
        r7.a();     // Catch: Throwable -> L8
        this.f1114b.put(NotificationCompat.CATEGORY_ALARM, r3);     // Catch: Throwable -> L8
        this.f1114b.put("location", r5);     // Catch: Throwable -> L8
        this.f1114b.put("power", r6);     // Catch: Throwable -> L8
    L10:
        com.bytedance.apm.battery.d.f r0 = new com.bytedance.apm.battery.d.f();
        j r1 = new j();
        h r2 = new h();
        com.bytedance.apm.battery.d.e r4 = new com.bytedance.apm.battery.d.e();
        this.f1114b.put("cpu_active_time", r0);
        this.f1114b.put("traffic", r1);
        this.f1114b.put("traffic_packets", r2);
        this.f1114b.put("battery_consume", r4);
        this.i = SystemClock.elapsedRealtime();
        return;
    L8:
        th = move-exception;
        com.bytedance.apm.e.a.a("APM-Battery", "SYSTEM_SERVICE_FETCHERS hook failed: " + th.getMessage());
        goto L10
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void b(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        super.b(r4);
        this.n = r4.getClass().getName();
        a(ActivityLifeObserver.getInstance().getTopActivityClassName());
    }

    @Override // com.bytedance.apm.battery.e.a.InterfaceC0086a
    public void b(final boolean r3) {
        if (this.f1114b.isEmpty() == false) goto L5;
        return;
    L5:
        com.bytedance.apm.battery.c.a.a().a(ActivityLifeObserver.getInstance().getTopActivityClassName());
        com.bytedance.apm.l.b.a().b(new AnonymousClass1(this, r3));
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.apm.api.d
    public void c(Activity r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.memorydata.plugin");
        super.c(r6);
        String[] r0 = this.o;
        r0[0] = r0[1];
        r0[1] = r6.getClass().getName();
        if (TextUtils.equals(r6.getClass().getName(), this.n) == false) goto L5;
    L7:
        this.n = null;
        return;
    L5:
        if (TextUtils.isEmpty(this.o[0]) == true) goto L7;
        a(this.o[0]);
        goto L7
    }

    @Override // com.bytedance.apm.h.a
    public boolean c() {
        return false;
    }

    @Override // com.bytedance.apm.h.a
    public long d() {
        return this.f * 60000;
    }

    @Override // com.bytedance.apm.h.a
    public void e() {
        if (r() == false) goto L5;
        return;
    L5:
        if (this.f1114b.isEmpty() == true) goto L13;
        com.bytedance.apm.e.a.b("APM-Battery", "OnTimer");
        long r0 = d();
        if (r0 <= 0) goto L10;
        com.bytedance.apm.l.b.a().b(this.w, r0);
    L10:
        com.bytedance.apm.battery.c.a.a().a(ActivityLifeObserver.getInstance().getTopActivityClassName());
        com.bytedance.apm.l.b.a().b(new AnonymousClass4(this));
        return;
    }

    public Map<String, l> f() {
        return this.f1114b;
    }

    public boolean g() {
        return this.l;
    }

    public String h() {
        return this.q;
    }

    @Override // com.bytedance.apm.h.a, com.bytedance.services.slardar.config.a
    public void onReady() {
        super.onReady();
        if (com.bytedance.apm.b.f() == true) goto L5;
        return;
    L5:
        if (this.e == false) goto L9;
        com.bytedance.apm.battery.c.a.a().a(true);
        this.i = SystemClock.elapsedRealtime();
        return;
    }
}
