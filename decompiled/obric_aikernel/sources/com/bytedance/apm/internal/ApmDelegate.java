package com.bytedance.apm.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.impl.ApmAgentServiceImpl;
import com.bytedance.apm.impl.LaunchTraceImpl;
import com.bytedance.apm.util.m;
import com.bytedance.apm.util.u;
import com.bytedance.apm6.Apm6;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.consumer.slardar.send.LogReportController;
import com.bytedance.apm6.disk.DiskCollector;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.crash.NpthApi;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.monitor.collector.o;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.bytedance.services.slardar.config.IConfigManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ApmDelegate implements u4.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static long f961u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static boolean f962v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static boolean f963w;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private u.b f964c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private r0.a f965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private u.c f966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private d0.b f967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private t4.e f968j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private SlardarConfigManagerImpl f969k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f970l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile boolean f971m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile boolean f972n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f973o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Set<t4.i> f974p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f975q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<String> f976r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<String> f977s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<String> f978t;

    class a implements Runnable {
        a(ApmDelegate r10) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.monitor.collector.h.h();
        }
    }

    class b implements c4.a<IApmAgent> {
        b(ApmDelegate r10) {
        }

        public IApmAgent a() {
            return new ApmAgentServiceImpl();
        }

        @Override // c4.a
        public /* bridge */ /* synthetic */ IApmAgent create() {
            return a();
        }
    }

    class c implements c4.a<ILaunchTrace> {
        c(ApmDelegate r10) {
        }

        public ILaunchTrace a() {
            return new LaunchTraceImpl();
        }

        @Override // c4.a
        public /* bridge */ /* synthetic */ ILaunchTrace create() {
            return a();
        }
    }

    class d implements c4.a<t4.j> {
        d(ApmDelegate r10) {
        }

        public t4.j a() {
            return new com.bytedance.apm.l();
        }

        @Override // c4.a
        public /* bridge */ /* synthetic */ t4.j create() {
            return a();
        }
    }

    class e implements c4.a<t4.k> {
        e(ApmDelegate r10) {
        }

        public t4.k a() {
            return (t4.k) ServiceManager.getService(t4.k.class);
        }

        @Override // c4.a
        public /* bridge */ /* synthetic */ t4.k create() {
            return a();
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u.b f979c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f980g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Runnable f981h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ ApmDelegate f982i;

        f(ApmDelegate r10, u.b r11, Context r12, Runnable r13) {
            this.f982i = r10;
            this.f979c = r11;
            this.f980g = r12;
            this.f981h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApmDelegate.a(this.f982i).registerConfigListener(ApmDelegate.j());
            r0.c.f(this.f979c.l());
            r0.c.g(this.f979c.k());
            com.bytedance.apm.internal.a.e(this.f980g);
            com.bytedance.apm.d.x();
            if (ApmDelegate.b(this.f982i) == false) goto L17;
            t.e.B().V();
            com.bytedance.monitor.collector.j.a r10 = new com.bytedance.monitor.collector.j.a();
            com.bytedance.monitor.collector.j.a r11 = r10.g(com.bytedance.apm.internal.a.a());
            if (com.bytedance.apm.internal.a.a() != 0) goto L7;
        L9:
            boolean r12 = false;
        L10:
            com.bytedance.monitor.collector.j.a r13 = r11.i(r12);
            if (this.f979c.r() == true) goto L13;
        L15:
            boolean r14 = false;
        L16:
            r13.j(r14).m(com.bytedance.apm.internal.a.d(64)).k(false).l(!ApmDelegate.c(this.f982i).v()).n(com.bytedance.apm.internal.a.c());
            com.bytedance.monitor.collector.k.n().s(com.bytedance.apm.d.g(), r10.h());
            com.bytedance.monitor.collector.k.n().A();
            com.bytedance.monitor.collector.k.n().y(ApmDelegate.c(this.f982i).t());
        L18:
            com.bytedance.apm.block.g.a().d();
            Runnable r15 = this.f981h;
            if (r15 == null) goto L22;
            r15.run();
        L22:
            if (com.bytedance.apm.d.D() == false) goto L29;
            DoctorManager r16 = DoctorManager.getInstance();
            if (ApmDelegate.b(this.f982i) == false) goto L26;
            String r17 = "APM_INIT_ASYNC";
        L27:
            r16.b(r17, "done");
            return;
        L26:
            r17 = "APM_INIT_ASYNC_OTHER_PROCESS";
            goto L27
        L29:
            return;
        L13:
            if (com.bytedance.apm.internal.a.d(2) == false) goto L15;
            r14 = true;
            goto L16
        L7:
            if (com.bytedance.apm.internal.a.d(2) == false) goto L9;
            r12 = true;
            goto L10
        L17:
            com.bytedance.monitor.collector.k.u(com.bytedance.apm.d.g());
            goto L18
        }
    }

    static class g implements DoctorManager.ApmListener {
        g() {
        }

        private void a(String r10, String r11, boolean r12) {
            int r13 = (4000 - r10.length()) - 5;
            if (r11.length() > r13) goto L9;
            String[] r14 = new String[2];
            if (r12 == false) goto L7;
            r14[0] = r10;
            r14[1] = " " + r11;
            e0.e.c("APM-Doctor-Log", r14);
            return;
        L7:
            r14[0] = r10;
            r14[1] = " " + r11;
            e0.e.d("APM-Doctor-Log", r14);
            return;
        L9:
            int r15 = 0;
        L11:
            if (r15 >= r11.length()) goto L21;
            int r16 = r15 + r13;
            if (r16 >= r11.length()) goto L15;
            String r17 = r11.substring(r15, r16);
        L16:
            String[] r18 = new String[2];
            if (r12 == false) goto L19;
            r18[0] = r10;
            r18[1] = " " + r17;
            e0.e.c("APM-Doctor-Log", r18);
        L20:
            r15 = r16;
            goto L11
        L19:
            r18[0] = r10;
            r18[1] = " " + r17;
            e0.e.d("APM-Doctor-Log", r18);
            goto L20
        L15:
            r17 = r11.substring(r15);
            goto L16
        }

        @Override // com.bytedance.apm.doctor.DoctorManager.ApmListener
        public void onDataEvent(int r10, String r11, JSONObject r12) {
            if (TextUtils.equals(r11, "DATA_CACHE") == false) goto L5;
            return;
        L5:
            if (TextUtils.equals(r11, "DATA_SEND_END") == false) goto L7;
            return;
        L7:
            if (TextUtils.equals(r11, "DATA_SEND_RESPONSE") == false) goto L10;
            return;
        L10:
            if (TextUtils.equals(r11, "DATA_RECEIVE") == true) goto L12;
        L14:
            a("onDataEvent[" + r10 + "] " + r11 + " [service:" + r12.optString("service") + "|logType:" + r12.optString("log_type") + "] = ", r12.toString(), r11.contains("ERROR"));
            return;
        L12:
            if (r12.optJSONObject("DATA_DOCTOR").optBoolean("DATA_SAMPLE") == true) goto L14;
            r11 = "DATA_NOT_SAMPLED";
            goto L14
        }

        @Override // com.bytedance.apm.doctor.DoctorManager.ApmListener
        public void onEvent(String r10, String r11) {
            a("onEvent key=" + r10, r11, false);
        }
    }

    class h implements l4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t.b f983a;

        h(ApmDelegate r10, t.b r11) {
            this.f983a = r11;
        }

        @Override // l4.b
        public void a(long r10, boolean r11) {
            this.f983a.l(r10, r11);
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ApmDelegate f984c;

        i(ApmDelegate r10) {
            this.f984c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApmDelegate.d(this.f984c);
        }
    }

    class j implements com.bytedance.apm.k.b {
        j(ApmDelegate r10) {
        }

        @Override // com.bytedance.apm.k.b
        public void a(Throwable r10, String r11) {
            t4.a.f(5, r10, r11, false);
        }

        @Override // com.bytedance.apm.k.b
        public void ensureNotReachHere(String r10) {
            t4.a.a(r10);
        }

        @Override // com.bytedance.apm.k.b
        public void ensureNotReachHere(Throwable r10, String r11) {
            t4.a.d(r10, r11);
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ApmDelegate f985c;

        class a implements IQueryParams {
            a(k r10) {
            }

            @Override // com.bytedance.apm.core.IQueryParams
            public Map<String, String> getQueryParams() {
                return com.bytedance.apm.d.y();
            }
        }

        k(ApmDelegate r10) {
            this.f985c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApmDelegate.a(this.f985c).initParams(ApmDelegate.e(this.f985c).B(), new a(this), ApmDelegate.e(this.f985c).u());
            if (ApmDelegate.e(this.f985c).C() == true) goto L5;
        L7:
            ApmDelegate.a(this.f985c).fetchConfig();
            return;
        L5:
            if (com.bytedance.apm.d.I() == false) goto L7;
            ApmDelegate.a(this.f985c).forceUpdateFromRemote(null, null);
        }
    }

    private static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ApmDelegate f986a = null;

        static {
            f986a = new ApmDelegate(null);
        }

        static /* synthetic */ ApmDelegate a() {
            return f986a;
        }
    }

    private ApmDelegate() {
        this.f975q = false;
    }

    /* synthetic */ ApmDelegate(f r10) {
        this();
    }

    private void B() {
        com.bytedance.apm.internal.b.a();
        com.bytedance.apm.d.k0(System.currentTimeMillis());
        com.bytedance.apm.d.g0(this.f966h.s());
        Monitor.registerInterceptor(this.f966h.o());
        g();
        o0.c.g(new n0.a());
        com.bytedance.apm.k.e().f(new j(this));
        com.bytedance.apm.d.T(this.f966h.m());
        com.bytedance.apm.d.S(this.f966h.i());
        com.bytedance.apm.d.U(this.f966h.n());
        com.bytedance.apm.d.h0(this.f966h.t());
        com.bytedance.apm.d.i0(this.f966h.u());
        com.bytedance.apm.d.M(this.f966h.b());
        this.f968j = this.f966h.j();
        this.f974p = this.f966h.y();
        s();
        h0.a.b().a(this.f966h.c());
        x.a.p().j();
        x.d.v().j();
        x.d.v().K(this.f966h.q());
        i.a.a(com.bytedance.apm.d.g(), this.f964c.c());
        q();
        long r10 = this.f966h.h();
        k r11 = new k(this);
        if (r10 > 0) goto L5;
        q0.b.f().i(r11);
    L7:
        if (com.bytedance.apm.d.D() == false) goto L10;
        e0.a.d("apm_debug", "delayRequestSeconds:" + r10);
    L10:
        if (this.f973o == false) goto L12;
        f();
    L12:
        o(com.bytedance.apm.d.g());
        t4.l r12 = new t4.l();
        r12.b(this.f966h.g());
        v(r12);
        A();
        q0.b.f().h(this.f966h.l());
        t(this.f966h);
        d0.b r13 = this.f966h.d();
        this.f967i = r13;
        if (r13 == null) goto L15;
        r13.a();
    L15:
        g.a.j();
        c4.d.d(IHttpService.class, new AnonymousClass7(this));
        if (com.bytedance.apm.d.D() == false) goto L23;
        DoctorManager r14 = DoctorManager.getInstance();
        if (this.f973o == false) goto L20;
        String r15 = "APM_START";
    L21:
        r14.b(r15, this.f966h.toString());
        goto L23
    L20:
        r15 = "APM_START_OTHER_PROCESS";
    L23:
        if (e0.a.c() == null) goto L26;
        e0.a.c().i("apm_debug", "APM_START");
        return;
    L26:
        return;
    L5:
        q0.b.f().j(r11, 1000 * r10);
        goto L7
    }

    private void C() {
        long r10 = System.nanoTime();     // Catch: Throwable -> L6
        ApmContext.setNtpTimeService(this.f966h.r());     // Catch: Throwable -> L6
        B();     // Catch: Throwable -> L6
        if (this.f973o == false) goto L20;
        com.bytedance.apm.d.j0(System.nanoTime() - r10);     // Catch: Throwable -> L6
        y();     // Catch: Throwable -> L6
        return;
    L20:
        return;
    L6:
        th = move-exception;
        if (com.bytedance.apm.d.D() == false) goto L11;
        th.printStackTrace();
        DoctorManager.getInstance().b("APM_START_ERROR", u.a(th));
    L11:
        if (e0.a.c() == null) goto L18;
        e0.a.c().i("apm_debug", "APM_START_ERROR:" + u.a(th));
    L18:
        q0.b.f().o();     // Catch: Throwable -> L15
        return;
    }

    static /* synthetic */ SlardarConfigManagerImpl a(ApmDelegate r10) {
        return r10.f969k;
    }

    static /* synthetic */ boolean b(ApmDelegate r10) {
        return r10.f973o;
    }

    static /* synthetic */ u.b c(ApmDelegate r10) {
        return r10.f964c;
    }

    static /* synthetic */ void d(ApmDelegate r10) {
        r10.C();
    }

    static /* synthetic */ u.c e(ApmDelegate r10) {
        return r10.f966h;
    }

    @WorkerThread
    private void f() {
        String r10 = com.bytedance.apm.internal.b.a().d("update_version_code");
        String r11 = com.bytedance.apm.d.k().optString("update_version_code");
        if (TextUtils.equals(r10, r11) == true) goto L5;
        com.bytedance.apm.d.f0(1);
        com.bytedance.apm.internal.b.a().g("update_version_code", r11);
        return;
    L5:
        com.bytedance.apm.d.f0(2);
    }

    private void g() {
        if (com.bytedance.apm.util.j.b(this.f966h.u()) == false) goto L8;
        if (com.bytedance.apm.util.j.b(this.f976r) == true) goto L8;
        this.f966h.K(this.f976r);
    L8:
        if (com.bytedance.apm.util.j.b(this.f966h.g()) == false) goto L13;
        if (com.bytedance.apm.util.j.b(this.f977s) == true) goto L13;
        this.f966h.I(this.f977s);
    L13:
        if (com.bytedance.apm.util.j.b(this.f966h.k()) == true) goto L15;
        return;
    L15:
        if (com.bytedance.apm.util.j.b(this.f978t) == true) goto L19;
        this.f966h.J(this.f978t);
        return;
    }

    private void initEvilMethodTraceInject() {
    }

    private static void initTraceEvilMethod() {
        l4.a.m(f961u);
        l4.a.n(f962v);
        l4.a.f10881r = true;
        t.e.B().D();
        t.f.E().K();
        new l4.a(f963w).p();
        com.bytedance.monitor.collector.k.n().z(true);
    }

    public static ApmDelegate j() {
        return l.a();
    }

    private void o(Context r10) {
        Set<t4.i> r11 = this.f974p;
        if (r11 != null) goto L5;
        return;
    L5:
        Iterator<t4.i> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        r12.next().init(r10);     // Catch: Throwable -> L12
        goto L7
    }

    private void p() {
        if (this.f975q == false) goto L5;
        return;
    L5:
        this.f975q = true;
        q0.a.a().post(new a(this));
        com.bytedance.apm.block.b r10 = new com.bytedance.apm.block.b();
        r10.k(this.f966h.f());
        r10.n(this.f966h.H());
        r10.l(this.f966h.D());
        r10.j(this.f966h.e());
        r10.i();
        if (ActivityLifeObserver.getInstance().isForeground() == false) goto L8;
        r10.o();
    L8:
        r10.m(this.f964c.w());
    }

    private static void q() {
        String r10 = NpthApi.getByTraceID();     // Catch: Throwable -> L6
        if (TextUtils.isEmpty(r10) == true) goto L11;
        com.bytedance.apm.d.k().put("bytrace_id", r10);     // Catch: Throwable -> L6
        com.bytedance.apm.d.k().put("pid", String.valueOf(Process.myPid()));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private void r(Application r10) {
    }

    private void s() {
        MemoryCollector.getInstance().initGCInfo();
        if (this.f973o == false) goto L5;
        i0.f r10 = new i0.f();
        r10.Q(this.f966h.v());
        r10.d();
    L5:
        l0.g.q(this.f966h.x());
        DiskCollector.getInstance().setDiskCheckListener(this.f966h.v());
        MemoryCollector.getInstance().registerReachTopListener(this.f966h.p());
        if (this.f966h.G() == true) goto L8;
        return;
    L8:
        if (this.f966h.A() == true) goto L12;
        p();
        return;
    }

    private void t(@NonNull u.c r10) {
        List<String> r11 = r10.g();
        if (com.bytedance.apm.util.j.b(r11) == true) goto L15;
        int r12 = 0;
        String r13 = new URL(r11.get(0)).getHost();     // Catch: MalformedURLException -> L19
        m0.a.b(r13);     // Catch: MalformedURLException -> L19
        m0.a.a(r13);     // Catch: MalformedURLException -> L19
        p000j.a.a(r13);     // Catch: MalformedURLException -> L19
    L6:
        ArrayList r14 = new ArrayList(2);
        int r15 = r11.size();
    L7:
        if (r12 >= r15) goto L14;
        String r16 = new URL(r11.get(r12)).getHost();     // Catch: Exception -> L20
        if (TextUtils.isEmpty(r16) == true) goto L13;
        if (r16.indexOf(46) <= 0) goto L13;
        r14.add(ReportConsts.HTTPS + r16 + "/monitor/collect/batch/");     // Catch: Exception -> L20
    L13:
        r12 = r12 + 1;
        goto L7
    L14:
        LogReportController.getInstance().setDefaultReportUrlList(r14);
    L15:
        LogReportController.getInstance().setTraceReportUrlList(v.a.f13154c);
        LogReportController.getInstance().setDefaultExceptionUrlList(v.a.f13155d);
        LogReportController.getInstance().setDefaultExceptionUrlList(r10.k());
        List<String> r17 = r10.w();
        if (com.bytedance.apm.util.j.b(r17) == true) goto L29;
        LogReportController.getInstance().setTraceReportUrlList(r17);
        return;
    }

    private static void w() {
        if (com.bytedance.apm.d.D() == true) goto L5;
        return;
    L5:
        DoctorManager.getInstance().registerApmListener(new g());
    }

    private void x() {
        SlardarConfigManagerImpl r10 = new SlardarConfigManagerImpl();
        this.f969k = r10;
        r10.registerConfigListener(this);
        c4.d.d(IConfigManager.class, this.f969k);
        c4.d.c(IApmAgent.class, new b(this));
        c4.d.c(ILaunchTrace.class, new c(this));
        c4.d.c(t4.j.class, new d(this));
        c4.d.c(t4.k.class, new e(this));
    }

    @WorkerThread
    private void y() {
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L4
        r10.put(CommonConsts.APM_INNER_EVENT_COST_INIT, com.bytedance.apm.d.m());     // Catch: JSONException -> L4
        r10.put("init_finish", com.bytedance.apm.d.n());     // Catch: JSONException -> L4
        r10.put("init_step2", com.bytedance.apm.d.o());     // Catch: JSONException -> L4
        r10.put("init_step3", com.bytedance.apm.d.p());     // Catch: JSONException -> L4
        r10.put("init_step4", com.bytedance.apm.d.q());     // Catch: JSONException -> L4
        r10.put("init_step5", com.bytedance.apm.d.r());     // Catch: JSONException -> L4
        r10.put(CommonConsts.APM_INNER_EVENT_COST_START, com.bytedance.apm.d.A());     // Catch: JSONException -> L4
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L4
        r11.put("is_main_process", this.f973o);     // Catch: JSONException -> L4
        com.bytedance.apm.c.h(CommonConsts.APM_INNER_EVENT_COST, r11, r10, null);     // Catch: JSONException -> L4
        return;
    }

    public void A() {
        Set<t4.i> r10 = this.f974p;
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator<t4.i> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        r11.next().start();     // Catch: Throwable -> L12
        goto L7
    }

    public u.b h() {
        u.b r10 = this.f964c;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return u.b.a().F();
    }

    public t4.e i() {
        return this.f968j;
    }

    public boolean k(String r10) {
        if (this.f970l == false) goto L9;
        SlardarConfigManagerImpl r11 = this.f969k;
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.getLogTypeSwitch(r10);
    L9:
        return false;
    }

    public boolean l(String r10) {
        if (this.f970l == false) goto L9;
        SlardarConfigManagerImpl r11 = this.f969k;
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.getMetricTypeSwitch(r10);
    L9:
        return false;
    }

    public boolean m(String r10) {
        if (this.f970l == false) goto L9;
        SlardarConfigManagerImpl r11 = this.f969k;
        if (r11 != null) goto L8;
        return false;
    L8:
        return r11.getServiceSwitch(r10);
    L9:
        return false;
    }

    public void n(@NonNull Context r10, @NonNull u.b r11) {
        if (this.f971m == true) goto L34;
        long r12 = System.nanoTime();
        this.f971m = true;
        com.bytedance.apm.d.B();
        com.bytedance.apm.d.b0(System.currentTimeMillis());
        com.bytedance.apm.d.c0(System.currentTimeMillis() - SystemClock.uptimeMillis());
        this.f964c = r11;
        m.d(r11.f());
        r0.a r13 = this.f965g;
        if (r13 == null) goto L7;
        this.f964c.C(r13);
    L7:
        w.a.n(r11.d());
        w.a.o(r11.z());
        CommonEventDeliverer.setReportFullException(r11.z());
        Application r14 = com.bytedance.apm.util.a.a(r10);
        com.bytedance.apm.d.O(r14);
        ActivityLifeObserver.init(r14);
        com.bytedance.apm.d.W(System.nanoTime() - r12);
        x();
        w();
        com.bytedance.apm.d.X(System.nanoTime() - r12);
        com.bytedance.apm.d.x();
        com.bytedance.apm.d.P(r11.j());
        this.f973o = com.bytedance.apm.d.I();
        Runnable r15 = Apm6.init(r10);
        com.bytedance.apm.d.Y(System.nanoTime() - r12);
        q0.b.f().i(new f(this, r11, r10, r15));
        com.bytedance.apm.d.Z(System.nanoTime() - r12);
        if (this.f973o == false) goto L23;
        k0.a.a(r14, this.f964c.b());
        if (r11.B() == false) goto L12;
        new r0.d().k(r11.i(), true);
    L12:
        AutoPageTraceHelper.d(r11.i());
        g.a.k(r11.h());
        r(r14);
        f963w = r11.y();
        f961u = r11.e();
        f962v = r11.A();
        t.b.o(r11.n());
        boolean r16 = r11.x();
        boolean r17 = r11.q();
        t.e.B().D();
        t.e.B().S(r11.o());
        t.e.B().Q(r11.t());
        t.e.B().P(r11.s());
        t.e.B().R(r11.v());
        o.f2383c = this.f964c.u();
        if (r16 == false) goto L21;
        if (r17 == true) goto L21;
        t.b r18 = new t.b();
        com.bytedance.apm.trace.fps.c.F(r18);
        l4.a.l(new h(this, r18));
        if (Build.VERSION.SDK_INT >= 24) goto L18;
    L19:
        t.e.B().v(r18);
    L20:
        t.e.B().T(r18);
        goto L21
    L18:
        if (this.f964c.v() == true) goto L20;
    L21:
        initEvilMethodTraceInject();
        com.bytedance.apm.launch.evil.b.a();
        c0.a.b().f(r11.g());
        com.bytedance.apm.d.V(System.nanoTime() - r12);
        com.bytedance.apm.d.R(r11.p());
        com.bytedance.apm.d.l0(r11.D());
    L23:
        if (com.bytedance.apm.d.D() == false) goto L30;
        DoctorManager r19 = DoctorManager.getInstance();
        if (this.f973o == false) goto L27;
        String r20 = "APM_INIT";
    L28:
        r19.b(r20, r11.toString());
        goto L30
    L27:
        r20 = "APM_INIT_OTHER_PROCESS";
    L30:
        if (e0.a.c() == null) goto L32;
        e0.a.c().i("apm_debug", "apm_init");
    L32:
        com.bytedance.apm.d.e0(true);
        com.bytedance.apm.d.a0(System.nanoTime() - r12);
        return;
    }

    @Override // u4.a
    public void onReady() {
        boolean r10 = true;
        this.f970l = true;
        d0.b r11 = this.f967i;
        if (r11 == null) goto L5;
        r11.onReady();
    L5:
        JSONObject r12 = this.f969k.getConfig();
        if (this.f973o == false) goto L14;
        new i0.h().d();
        if (com.bytedance.apm.util.i.f(r12, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, "traffic", SlardarSettingsConstants.PERF_KEY_ENABLE_COLLECT) != 1) goto L10;
        boolean r13 = true;
    L11:
        if (r13 == false) goto L14;
        l0.g.o().d();
        goto L14
    L10:
        r13 = false;
    L14:
        if (this.f966h.F() == false) goto L40;
        if (com.bytedance.apm.util.i.f(r12, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, Scraps.BATTERY, SlardarSettingsConstants.PERF_KEY_ENABLE_UPLOAD) != 1) goto L18;
        boolean r14 = true;
    L19:
        if (r14 == false) goto L21;
        k.e.b();
    L21:
        if (r14 == false) goto L23;
    L24:
        k.e.a(this.f966h.z());
    L26:
        if (com.bytedance.apm.util.i.f(r12, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, Scraps.BATTERY, "power_monitor_enable") != 1) goto L28;
        boolean r15 = true;
    L29:
        if (r15 == false) goto L32;
        k.e.d();
    L32:
        if (com.bytedance.apm.util.i.f(r12, SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, Scraps.BATTERY, "temperature_enable_upload") == 1) goto L35;
        r10 = false;
    L35:
        if (r10 == false) goto L37;
    L38:
        k.e.c(this.f966h.E());
        goto L40
    L37:
        if (this.f966h.E() == false) goto L40;
    L28:
        r15 = false;
        goto L29
    L23:
        if (this.f966h.z() == false) goto L26;
    L18:
        r14 = false;
    L40:
        if (this.f966h.A() == true) goto L42;
        return;
    L42:
        if (i0.c.a().d(LogTypeName.MONITOR_TYPE_BLOCK) == false) goto L46;
        p();
        return;
    }

    @Override // u4.a
    public void onRefresh(JSONObject r10, boolean r11) {
        JSONObject r12 = r10.optJSONObject(SlardarSettingsConstants.SETTING_GENERAL);
        if (r12 == null) goto L6;
        r12.optBoolean("enable_active_upload_alog", true);
        return;
    }

    public boolean u() {
        return this.f971m;
    }

    public void v(t4.l r10) {
        Set<t4.i> r11 = this.f974p;
        if (r11 != null) goto L5;
        return;
    L5:
        Iterator<t4.i> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        r12.next().notifyParams(r10);     // Catch: Throwable -> L12
        goto L7
    }

    public void z(@NonNull u.c r10) {
        if (e0.a.c() == null) goto L6;
        e0.a.c().i("apm_debug", CommonConsts.APM_INNER_EVENT_COST_START);     // Catch: Exception -> L17
    L6:
        if (this.f971m == false) goto L16;
        if (r10 == null) goto L14;
        if (this.f972n == false) goto L11;
        return;
    L11:
        q0.b.f().n();
        this.f972n = true;
        this.f966h = r10;
        q0.b.f().i(new i(this));
        return;
    L14:
        throw new IllegalArgumentException("startConfig must not be allowed");
    L16:
        throw new IllegalArgumentException("You must call Apm.getInstance().init() on Application.onCreate from version 5.x.x, pls call init() before start().");
    }
}
