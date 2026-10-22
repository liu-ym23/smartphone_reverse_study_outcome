package a1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.bytedance.applog.collector.Collector;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorState;
import com.bytedance.applog.n;
import com.bytedance.applog.o;
import com.bytedance.applog.util.BlockHelper;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.OnResetListener;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import l1.h;
import o1.m;
import o1.p;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements Handler.Callback, Comparator<l1.a> {
    private static final List<String> E = null;
    private volatile c1.e A;
    private volatile m1.c B;
    private volatile int C;
    private final g1.a D;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w0.d f16c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Looper f17g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bytedance.applog.c f18h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final g1.b f19i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a1.b f20j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ArrayList<l1.a> f21k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile l1.b f22l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final g1.c f23m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile Handler f24n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<a1.d> f25o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final a1.e f26p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private o f27q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Handler f28r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f29s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile boolean f30t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final ArrayList<a1.a> f31u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    volatile boolean f32v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private volatile long f33w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final List<e> f34x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile c1.a f35y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile n.a f36z;

    class a implements w0.b.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f37a;

        a(c r10) {
            this.f37a = r10;
        }

        @Override // w0.b.g
        public void a(JSONObject r10, InstallInfo r11) {
            c r12 = this.f37a;
            c.b(r12, c.a(r12) | 4);
            c.c(this.f37a).n(r10);
            this.f37a.s().P().t(c.d(), "bdinstall onUpdate", new Object[0]);
        }

        @Override // w0.b.g
        public void b(JSONObject r10, InstallInfo r11) {
            c r12 = this.f37a;
            c.b(r12, c.a(r12) | 2);
            c.c(this.f37a).n(r10);
            this.f37a.s().P().t(c.d(), "bdinstall onLoad", new Object[0]);
        }
    }

    class b implements b1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f38a;

        b(c r10) {
            this.f38a = r10;
        }

        @Override // b1.b
        public void a(Thread r10, Throwable r11) {
            this.f38a.L(null, false);
        }
    }

    /* JADX INFO: renamed from: a1.c$c, reason: collision with other inner class name */
    class C0000c implements f1.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f39a;

        C0000c(c r10) {
            this.f39a = r10;
        }

        @Override // f1.e.b
        public Object a() {
            JSONObject r10 = new JSONObject();
            r10.put("appId", c.e(this.f39a).getAppId());     // Catch: Throwable -> L5
            r10.put("isMainProcess", c.f(this.f39a).D());     // Catch: Throwable -> L5
        L4:
            return r10;
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f40c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f41g;

        d(c r10, List r11) {
            this.f41g = r10;
            this.f40c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            h1.b r10 = c.f(this.f41g).p(0);
            String[] r11 = this.f41g.s().s().b(this.f41g, true, r10);
            c.g(this.f41g, this.f40c, r10, r11);
        }
    }

    abstract class e<T> {
        protected abstract void a();
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f42a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        OnResetListener f43b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f44c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        CountDownLatch f45d;

        private f() {
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<l1.g> f46a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<l1.g> f47b;

        public g() {
            this.f46a = new ArrayList();
            this.f47b = new ArrayList();
        }
    }

    static {
        E = Collections.singletonList("Engine");
    }

    public c(com.bytedance.applog.c r10, g1.b r11, g1.c r12, w0.d r13, com.bytedance.applog.d r14, g1.a r15) {
        this.f21k = new ArrayList(32);
        this.f31u = new ArrayList(4);
        this.f34x = new ArrayList();
        this.C = 0;
        this.f18h = r10;
        this.f19i = r11;
        r11.L(this);
        this.f23m = r12;
        this.D = r15;
        this.f26p = new a1.e(this);
        this.f16c = r13;
        String r16 = s().getAppId();
        HandlerThread r17 = new HandlerThread("bd_tracker_w:" + r16);
        r17.start();
        Handler r18 = new Handler(r17.getLooper(), this);
        this.f28r = r18;
        HandlerThread r19 = new HandlerThread("bd_tracker_n:" + r16);
        r19.start();
        Looper r20 = r19.getLooper();
        this.f17g = r20;
        r13.a(r11, E().b(), r20, r14);
        if (r10.f0() == false) goto L6;
        this.A = c1.e.e(this, com.bytedance.applog.b.b(r10, "sampling_list"));
    L6:
        if (r11.c() == false) goto L8;
        this.f30t = true;
        r18.sendEmptyMessage(1);
        r18.sendEmptyMessageDelayed(2, 200);
    L8:
        r18.sendEmptyMessage(10);
        if (r11.q().p() == null) goto L14;
        if (r11.D() == true) goto L14;
        this.f36z = r11.q().p();
    L14:
        if (s().h0() == true) goto L16;
        return;
    L16:
        if (com.bytedance.applog.b.d(s()) == false) goto L20;
        r18.sendEmptyMessageDelayed(24, WorkRequest.MIN_BACKOFF_MILLIS);
        return;
    }

    private List<a1.d> B() {
        ArrayList r10 = new ArrayList();
        h1.a r11 = this.f19i.o();
        if (r11 != null) goto L5;
    L15:
        boolean r12 = false;
    L16:
        if (r12 == true) goto L18;
        r10.add(new a1.d(this));
    L18:
        return r10;
    L5:
        if (r11.e() == false) goto L15;
        Iterator<h1.b> r13 = r11.b().values().iterator();
    L8:
        if (r13.hasNext() == false) goto L14;
        h1.b r14 = r13.next();
        if (r14 == null) goto L8;
        if (r14.f() == 0) goto L8;
        r10.add(new a1.d(this, r14));
        goto L8
    L14:
        r12 = true;
        goto L16
    }

    private void F(boolean r10) {
        if (s().c0() == true) goto L6;
        s().P().t(E, "[Task] Background session task is not enabled, isResume = {} will not work!", new Object[]{Boolean.valueOf(r10)});
        return;
    L6:
        m1.c r11 = u();
        if (r10 == false) goto L9;
        r11.D();
        return;
    L9:
        r11.C();
    }

    private void G(h r10) {
        if (s().c0() == true) goto L5;
        return;
    L5:
        m1.c r11 = u();
        if (r10.G() == false) goto L8;
        r11.B(r10.f10828g, r10.f10830i);
        return;
    L8:
        r11.A(r10.f10828g, r10.f10830i);
    }

    private void H(List<l1.a> r10, h1.b r11, String[] r12) {
        W(r12, r11, r10, E().a());
    }

    private void I(int r10) {
        if (r10 > 0) goto L4;
        return;
    L4:
        if ((r10 % 500) != 0) goto L8;
        s().R().h(MonitorKey.engine, MonitorState.engine_event_cache_overflow);
        return;
    }

    private void J(MonitorState r10, int r11) {
        s().R().j(MonitorKey.event_v3, r10, r11);
        s().R().j(MonitorKey.real_event, r10, r11);
    }

    private void K(List<l1.a> r14) {
        if (s().G().a(2) == false) goto L5;
        return;
    L5:
        Iterator<l1.a> r15 = r14.iterator();
    L7:
        if (r15.hasNext() == false) goto L27;
        l1.a r10 = r15.next();
        if ((r10 instanceof l1.c) == true) goto L11;
        JSONObject r11 = null;
        if ((r10 instanceof l1.e) == true) goto L14;
        if ((r10 instanceof l1.d) == false) goto L7;
        l1.d r12 = (l1.d) r10;     // Catch: Throwable -> L25
        d1.a r13 = s().G();     // Catch: Throwable -> L25
        String r16 = r12.E();     // Catch: Throwable -> L25
        if (r12.l() == null) goto L23;
        r11 = new JSONObject(r12.l());     // Catch: Throwable -> L25
    L23:
        r13.d(2, r16, r11);     // Catch: Throwable -> L25
        goto L7
    L14:
        l1.e r17 = (l1.e) r10;     // Catch: Throwable -> L25
        d1.a r18 = s().G();     // Catch: Throwable -> L25
        String r19 = r17.F();     // Catch: Throwable -> L25
        if (r17.l() == null) goto L17;
        r11 = new JSONObject(r17.l());     // Catch: Throwable -> L25
    L17:
        r18.c(2, r19, r11);     // Catch: Throwable -> L25
        goto L7
    L11:
        l1.c r20 = (l1.c) r10;     // Catch: Throwable -> L25
        s().G().b(2, r20.f10857z, r20.A, r20.B, r20.D, r20.E, r20.C);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        s().P().v(4, "notify event observer before process failed", th, new Object[0]);
        goto L7
    }

    private void O() {
        File r10 = w().getDatabasePath(v().q().l());
        if (r10 == null) goto L6;
        s().R().o(MonitorKey.database, MonitorState.init, r10.length());
        return;
    }

    private void P(ArrayList<l1.a> r11) {
        Collections.sort(r11, this);
        ArrayList<l1.a> r10 = new ArrayList(r11.size());
        h1.a r12 = this.f19i.o();
        Iterator<l1.a> r13 = r11.iterator();
        boolean r14 = false;
        boolean r15 = false;
        boolean r16 = false;
        boolean r17 = false;
    L3:
        int r18 = 1;
        if (r13.hasNext() == false) goto L21;
        l1.a r19 = r13.next();
        boolean r20 = this.f26p.n(r19, r10);
        boolean r21 = a1.e.l(r19);
        if (r20 == false) goto L10;
        if (r21 == false) goto L10;
        r16 = true;
    L10:
        if ((r19 instanceof h) == true) goto L12;
        if ((r19 instanceof l1.e) == true) goto L17;
        if ((r19 instanceof a1.e.a) == false) goto L3;
        r17 = true;
        goto L3
    L17:
        ((l1.e) r19).H(r12);
        goto L3
    L12:
        if (s().c0() == false) goto L14;
        this.f28r.obtainMessage(23, r19).sendToTarget();
    L14:
        r14 = true;
        r15 = r21;
        goto L3
    L21:
        h(r10);
        r(r10);
        x().E(r10);
        if (r14 == false) goto L28;
        if (r15 == false) goto L26;
        this.f28r.removeMessages(7);
        goto L28
    L26:
        this.f28r.sendEmptyMessageDelayed(7, t());
    L28:
        if (r16 == true) goto L34;
        if (r17 == true) goto L34;
        if (this.f24n == null) goto L56;
        this.f24n.removeMessages(6);
        Message r22 = this.f24n.obtainMessage(6);
        r22.arg1 = 2;
        this.f24n.sendMessage(r22);
        return;
    L56:
        return;
    L34:
        if (r16 == true) goto L37;
        r18 = 3;
    L37:
        a0(this.f25o, r18);
        List<a1.d> r23 = this.f25o;
        if (r23 != null) goto L40;
        return;
    L40:
        if (r23.isEmpty() == false) goto L42;
        return;
    L42:
        if ((2 & this.C) != 0) goto L60;
        s().R().h(MonitorKey.engine, MonitorState.bdinstall_lost_header_ready_callback);
        Bundle r110 = new Bundle();
        r110.putInt("engine_state", this.C);
        this.f18h.n0("bdinstall_lost_callback", r110);
        return;
    }

    private boolean Q(String[] r12, h1.b r13, List<l1.a> r14, Map<String, String> r15) {
        JSONObject r10 = m.a(this.f23m.e());
        if (r12.length <= 0) goto L31;
        l1.g r11 = l1.g.T(this.f18h, r14, r10, r13);
        n1.a r16 = null;
        s().r().n(null, r11, r13);
        if (r13 == null) goto L7;
        r16 = r13.b();
    L7:
        int r17 = r14.size();
        if (r16 != null) goto L10;
    L14:
        byte[] r18 = r11.f10864z;
        if (r18 != null) goto L17;
    L30:
        MonitorState r19 = MonitorState.f_send_check;
    L12:
        J(r19, r17);
        return false;
    L17:
        if (r18.length <= 0) goto L30;
        int r110 = s().r().k(r12, r11.f10864z, this, r11.N(), r11.S, r11.T, r15);
        r11.B = r110;
        if (r110 != 200) goto L22;
        this.f29s = 0;
        boolean r111 = true;
        J(MonitorState.success, r17);
        if (this.f23m.k() == true) goto L32;
        J(MonitorState.f_device_none, r17);
    L32:
        s().P().o(E, "sendRealTime, " + r111, new Object[0]);
        return r111;
    L22:
        if (k1.a.a(r110) == false) goto L24;
        this.f29s = System.currentTimeMillis();
    L24:
        J(MonitorState.f_net, r17);
        if (r13 == null) goto L31;
        r13.a(r110);
        goto L31
    L10:
        if (r16.a(8) == false) goto L14;
        r19 = MonitorState.f_backoff_ratio;
    L31:
        r111 = false;
        goto L32
    }

    private void U(String r10, h r11) {
        a0(this.f25o, 10);
        if (r11 != null) goto L7;
        r11 = s().x();
        if (r11 == null) goto L7;
        r11 = (h) r11.b();
    L7:
        ArrayList<l1.a> r12 = new ArrayList();
        long r13 = System.currentTimeMillis();
        if (r11 == null) goto L14;
        long r14 = r13 - r11.f10828g;
        r11.x(r13);
        if (r14 >= 0) goto L13;
        r14 = 0;
    L13:
        r11.f10865z = r14;
        r11.D = this.f26p.e();
        this.f26p.a(r11);
        r12.add(r11);
    L14:
        o(r10);
        if (r11 == null) goto L21;
        h r15 = (h) r11.b();
        r15.x(r13 + 1);
        r15.f10865z = -1;
        l1.f r16 = this.f26p.p(r15, r12, true);
        if (r16 == null) goto L19;
        r16.C = this.f26p.e();
    L19:
        this.f26p.a(r15);
        r12.add(r15);
    L21:
        if (r12.isEmpty() == true) goto L23;
        x().E(r12);
    L23:
        a0(this.f25o, 10);
    }

    private void V(Iterator<l1.a> r10, List<c1.d> r11, String r12, MonitorKey r13, String r14, String r15) {
        Iterator<c1.d> r16 = r11.iterator();
    L4:
        if (r16.hasNext() == false) goto L12;
        if (r16.next().a(r13, r14, r15) == false) goto L4;
        r10.remove();
        return;
    }

    private void W(String[] r10, h1.b r11, List<l1.a> r12, Map<String, String> r13) {
        if (Q(r10, r11, r12, r13) == true) goto L5;
        this.f28r.obtainMessage(8, r12).sendToTarget();
        return;
    L5:
        x().s(r12);
    }

    private void Z(a1.a r10, int r11) {
        if (this.f24n == null) goto L12;
        if (r10 == null) goto L13;
        r10.k();
        if (Looper.myLooper() == this.f24n.getLooper()) goto L8;
        this.f24n.removeMessages(6);
        Message r12 = this.f24n.obtainMessage(6);
        r12.arg1 = r11;
        this.f24n.sendMessage(r12);
        return;
    L8:
        if (r10.h() == true) goto L14;
        r10.a(r11);
        return;
    L14:
        return;
    L13:
        return;
    }

    static /* synthetic */ int a(c r10) {
        return r10.C;
    }

    private void a0(List<? extends a1.a> r10, int r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L11;
        Iterator<? extends a1.a> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        Z(r12.next(), r11);
        goto L7
    L12:
        return;
    }

    static /* synthetic */ int b(c r10, int r11) {
        r10.C = r11;
        return r11;
    }

    static /* synthetic */ g1.c c(c r10) {
        return r10.f23m;
    }

    static /* synthetic */ List d() {
        return E;
    }

    static /* synthetic */ com.bytedance.applog.c e(c r10) {
        return r10.f18h;
    }

    static /* synthetic */ g1.b f(c r10) {
        return r10.f19i;
    }

    static /* synthetic */ void g(c r10, List r11, h1.b r12, String[] r13) {
        r10.H(r11, r12, r13);
    }

    private void h(ArrayList<l1.a> r10) {
        if (o1.h.d(this.f18h.getAppId()) == false) goto L10;
        Iterator<l1.a> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        l1.a r12 = r11.next();
        String r13 = o1.h.b(r12);
        if (r13 == null) goto L6;
        JSONArray r14 = new JSONArray();
        JSONObject r15 = r12.z();
        r15.remove("$$EVENT_LOCAL_ID");
        r14.put(r15);
        o1.h.e(this.f18h.getAppId(), r13, r14);
        goto L6
    L16:
        return;
    }

    private void i() {
        if (this.f23m.f() == this.f23m.h()) goto L5;
    L10:
        a1.b r10 = this.f20j;
        if (r10 == null) goto L14;
        r10.k();
    L14:
        if (v().q().O() == false) goto L19;
        c1.a r11 = c1.a.f(s(), com.bytedance.applog.b.b(s(), "sp_filter_name"), null);
    L16:
        R(r11);
        return;
    L19:
        return;
    L5:
        if (TextUtils.equals(this.f19i.r(), this.f19i.g()) == false) goto L10;
        if (v().q().O() == false) goto L18;
        r11 = c1.a.e(s(), com.bytedance.applog.b.b(s(), "sp_filter_name"));
        goto L16
    }

    private void k() {
        Env r10 = E().b();
        Env r11 = new Env(r10.getConfig(), r10.isI18n(), r10.isBoe(), r10.isChildMode());
        this.f16c.clearAndSetEnv(r11);
    }

    private void l(boolean r10) {
        Env r11 = E().b();
        Env r12 = new Env(r11.getConfig(), r11.isI18n(), r11.isBoe(), r10);
        this.f16c.clearInstallInfoWhenSwitchChildMode(r12);
        x().g();
        ArrayList<l1.a> r13 = new ArrayList();
        h r14 = s().x();
        if (r14 == null) goto L5;
        r14 = (h) r14.b();
    L5:
        if (r14 == null) goto L7;
        r14.x(System.currentTimeMillis());
        r14.f10865z = -1;
        this.f26p.p(r14, r13, true);
        this.f26p.a(r14);
        r13.add(r14);
    L9:
        if (r13.isEmpty() == true) goto L12;
        x().E(r13);
        return;
    L12:
        return;
    L7:
        this.f26p.p(null, r13, false);
        goto L9
    }

    private void m(long r10, OnResetListener r11) {
        Env r12 = E().b();
        Env r13 = new Env(r12.getConfig(), r12.isI18n(), r12.isBoe(), r12.isChildMode());
        this.f16c.resetAndReInstall(w(), r13, r10, r11);
    }

    private void n(boolean r10, long r11, OnResetListener r12) {
        Env r13 = E().b();
        Env r14 = new Env(r13.getConfig(), r13.isI18n(), r13.isBoe(), r10);
        this.f16c.resetInstallInfoWhenSwitchChildMode(w(), r14, r11, r12);
    }

    private void o(String r10) {
        this.f16c.c((Application) w(), r10);
    }

    private void q(ArrayList<l1.a> r10) {
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        List<c1.d> r11 = z();
        if (r11.isEmpty() == false) goto L8;
        return;
    L8:
        String r12 = s().getDid();
        Iterator<l1.a> r13 = r10.iterator();
    L10:
        if (r13.hasNext() == false) goto L21;
        l1.a r14 = r13.next();
        if ((r14 instanceof l1.e) == true) goto L13;
        if ((r14 instanceof l1.c) == true) goto L17;
        if ((r14 instanceof l1.d) == false) goto L10;
        MonitorKey r15 = MonitorKey.log_data;
        String r16 = ((l1.d) r14).l();
        String r17 = "log_data";
    L14:
        V(r13, r11, r12, r15, r17, r16);
        goto L10
    L17:
        l1.c r18 = (l1.c) r14;
        r15 = MonitorKey.event;
        r17 = r18.A;
        r16 = r18.C;
        goto L14
    L13:
        l1.e r19 = (l1.e) r14;
        r17 = r19.F();
        r16 = r19.l();
        r15 = MonitorKey.event_v3;
        goto L14
    }

    private void r(List<l1.a> r10) {
        if (this.f23m.j() == true) goto L5;
        return;
    L5:
        if ((System.currentTimeMillis() - this.f29s) < VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER) goto L13;
        ArrayList<l1.a> r11 = this.f19i.e(r10);
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.size() <= 0) goto L15;
        m1.e.d().f(new d(this, r11));
        s().R().j(MonitorKey.real_event, MonitorState.init, r11.size());
        return;
    L15:
        return;
    }

    private List<c1.d> z() {
        ArrayList r10 = new ArrayList();
        c1.a r11 = s().F();
        if (r11 == null) goto L5;
        r10.add(r11);
    L5:
        boolean r12 = v().q().O();
        c1.a r13 = this.f35y;
        if (r12 == false) goto L10;
        if (r13 == null) goto L10;
        r10.add(r13);
    L10:
        if (s().f0() == false) goto L14;
        c1.e r14 = this.A;
        if (r14 == null) goto L14;
        r10.add(r14);
    L14:
        return r10;
    }

    public c1.e A() {
        return this.A;
    }

    public a1.e C() {
        return this.f26p;
    }

    public String D() {
        return this.f26p.d();
    }

    public o E() {
        if (this.f27q != null) goto L8;
        o r10 = v().q().D();
        this.f27q = r10;
        if (r10 != null) goto L8;
        this.f27q = o1.o.a(0);
    L8:
        return this.f27q;
    }

    public void L(String[] r10, boolean r11) {
        ArrayList<l1.a> r12 = this.f21k;
        monitor-enter(r12);
        ArrayList<l1.a> r13 = (ArrayList) this.f21k.clone();     // Catch: Throwable -> L60
        this.f21k.clear();     // Catch: Throwable -> L60
        monitor-exit(r12);     // Catch: Throwable -> L60
        if (r10 == null) goto L20;
        r13.ensureCapacity(r13.size() + r10.length);
        int r14 = r10.length;
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L20;
        l1.a r16 = l1.a.g(r10[r15]);
        if (r16 == null) goto L19;
        if (p.m(r16.j()) == true) goto L16;
    L18:
        r13.add(r16);
        goto L19
    L16:
        if (p.f(s().getAppId(), r16.j()) == true) goto L18;
    L19:
        r15 = r15 + 1;
    L20:
        K(r13);
        q(r13);
        boolean r17 = this.f19i.d(r13);
        if (this.f18h.k0() == false) goto L27;
        if (this.f18h.d0() == true) goto L27;
        s().P().t(E, "not process events in tourist mode", new Object[0]);
        return;
    L27:
        if (r13.size() > 0) goto L29;
    L53:
        if (r11 == true) goto L55;
        return;
    L55:
        if (this.f19i.D() == false) goto L74;
        long r18 = System.currentTimeMillis();
        if (Math.abs(r18 - this.f33w) <= WorkRequest.MIN_BACKOFF_MILLIS) goto L75;
        this.f33w = r18;
        a0(this.f25o, 4);
        return;
    L75:
        return;
    L74:
        return;
    L29:
        if (this.f19i.D() == false) goto L39;
        if (r17 == false) goto L32;
    L38:
        P(r13);
        goto L53
    L32:
        if (r13.size() > 100) goto L38;
        Iterator<l1.a> r19 = r13.iterator();
    L36:
        if (r19.hasNext() == false) goto L53;
        M(r19.next());
        goto L36
    L39:
        Intent r20 = new Intent(w(), Collector.class);
        int r21 = r13.size();
        String[] r22 = new String[r21];
        int r23 = 0;
        int r24 = 0;
    L40:
        if (r23 >= r21) goto L42;
        r22[r23] = r13.get(r23).y().toString();
        r24 = r24 + r22[r23].length();
        r23 = r23 + 1;
        goto L40
    L42:
        boolean r25 = true;
        if (r24 >= 307200) goto L45;
    L51:
        if (r25 == false) goto L53;
        r20.putExtra("K_DATA", r22);
        w().sendBroadcast(r20);
        goto L53
    L45:
        if (this.f36z == null) goto L51;
        r25 = this.f36z.a(r22);     // Catch: Throwable -> L48
    L50:
        s().P().m(E, "IPC over 300k", new Object[0]);
    L48:
        th = move-exception;
        s().P().g(E, "check ipc data", new Object[]{th});
    L60:
        th = move-exception;
        throw th;
    }

    public void M(l1.a r10) {
        if (r10.f10828g != 0) goto L5;
        s().P().m(E, "receive zero ts", new Object[0]);
    L5:
        ArrayList<l1.a> r11 = this.f21k;
        monitor-enter(r11);
        int r12 = this.f21k.size();     // Catch: Throwable -> L31
        this.f21k.add(r10);     // Catch: Throwable -> L31
        monitor-exit(r11);     // Catch: Throwable -> L31
        boolean r13 = r10 instanceof h;
        if (s().g0() == false) goto L21;
        if (r13 == false) goto L13;
    L18:
        this.f28r.removeMessages(4);
    L19:
        this.f28r.sendEmptyMessage(4);
    L29:
        I(this.f21k.size());
        return;
    L13:
        if (((r12 + 1) % s().u()) == 0) goto L18;
        if (this.f28r.hasMessages(4) == true) goto L29;
        Handler r14 = this.f28r;
        long r15 = s().v();
    L28:
        r14.sendEmptyMessageDelayed(4, r15);
        goto L29
    L21:
        if ((r12 % 5) == 0) goto L23;
        if (r13 == false) goto L29;
    L23:
        this.f28r.removeMessages(4);
        if (r12 != 0) goto L19;
        if (r13 == true) goto L19;
        r14 = this.f28r;
        r15 = 200;
    L31:
        th = move-exception;
        throw th;
    }

    public void N(String[] r10) {
        this.f28r.removeMessages(4);
        this.f28r.obtainMessage(4, r10).sendToTarget();
    }

    public void R(c1.a r10) {
        this.f35y = r10;
    }

    public void S(c1.e r10) {
        this.A = r10;
    }

    public void T() {
        if (this.f30t == true) goto L6;
        this.f30t = true;
        this.f28r.sendEmptyMessage(1);
        this.f28r.sendEmptyMessageDelayed(2, 200);
        return;
    }

    public void X(h1.b r10, int r11) {
        List<a1.d> r12 = this.f25o;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.isEmpty() == true) goto L12;
        Iterator<a1.d> r13 = this.f25o.iterator();
    L8:
        if (r13.hasNext() == false) goto L13;
        r13.next().s(r10, r11);
        goto L8
    L13:
        return;
    }

    public void Y() {
        if (this.f24n == null) goto L6;
        this.f24n.sendEmptyMessage(17);
        return;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(l1.a r10, l1.a r11) {
        return j(r10, r11);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        if (r10.what == 1) goto L6;
        BlockHelper.tryBlock();
    L6:
        switch(r10.what) {
            case 1: goto L105;
            case 2: goto L92;
            case 3: goto L84;
            case 4: goto L83;
            case 5: goto L7;
            case 6: goto L54;
            case 7: goto L46;
            case 8: goto L39;
            case 9: goto L7;
            case 10: goto L31;
            case 11: goto L7;
            case 12: goto L30;
            case 13: goto L7;
            case 14: goto L29;
            case 15: goto L7;
            case 16: goto L28;
            case 17: goto L27;
            case 18: goto L24;
            case 19: goto L21;
            case 20: goto L18;
            case 21: goto L15;
            case 22: goto L12;
            case 23: goto L9;
            case 24: goto L8;
            default: goto L7;
        };
    L7:
        s().P().g(E, "Not support message type", new Object[0]);
    L109:
        return true;
    L8:
        v0.b.d(s(), x());
        v0.b.c(s(), x());
        goto L109
    L9:
        Object r11 = r10.obj;
        if ((r11 instanceof h) == false) goto L109;
        G((h) r11);
        goto L109
    L12:
        Object r12 = r10.obj;
        if ((r12 instanceof Boolean) == false) goto L109;
        F(((Boolean) r12).booleanValue());
        goto L109
    L15:
        f r13 = (f) r10.obj;
        k();
        CountDownLatch r14 = r13.f45d;
        if (r14 == null) goto L109;
    L26:
        r14.countDown();
        goto L109
    L18:
        f r15 = (f) r10.obj;
        m(r15.f44c, r15.f43b);
        r14 = r15.f45d;
        if (r14 == null) goto L109;
    L21:
        f r16 = (f) r10.obj;
        n(r16.f42a, r16.f44c, r16.f43b);
        r14 = r16.f45d;
        if (r14 == null) goto L109;
    L24:
        f r17 = (f) r10.obj;
        l(r17.f42a);
        r14 = r17.f45d;
        if (r14 == null) goto L109;
    L27:
        this.f31u.removeAll(this.f25o);
        List<a1.d> r18 = B();
        this.f25o = r18;
        this.f31u.addAll(0, r18);
        goto L109
    L28:
        p((g) r10.obj);
        goto L109
    L29:
        L(null, true);
        goto L109
    L30:
        Object[] r19 = (Object[]) r10.obj;
        U((String) r19[0], (h) r19[1]);
        goto L109
    L31:
        ArrayList<l1.a> r20 = this.f21k;
        monitor-enter(r20);
        int r110 = this.D.c(this.f21k);     // Catch: Throwable -> L36
        monitor-exit(r20);     // Catch: Throwable -> L36
        s().P().o(E, "dump cache data count: " + r110, new Object[0]);
        L(this.D.d(), false);
    L36:
        th = move-exception;
        throw th;
    L39:
        ArrayList<l1.a> r111 = (ArrayList) r10.obj;
        Iterator<l1.a> r21 = r111.iterator();
    L41:
        if (r21.hasNext() == false) goto L45;
        l1.a r22 = r21.next();
        if (r22.p() != 0) goto L41;
        r22.w(-1);
        goto L41
    L45:
        x().E(r111);
        goto L109
    L46:
        s().P().o(E, "Terminate created", new Object[0]);
        ArrayList<l1.a> r23 = this.f21k;
        monitor-enter(r23);
        this.f21k.add(a1.e.h());     // Catch: Throwable -> L51
        monitor-exit(r23);     // Catch: Throwable -> L51
        L(null, false);
    L51:
        th = move-exception;
        throw th;
    L54:
        this.f24n.removeMessages(6);
        long r24 = this.f19i.n();
        if (this.f19i.q().W() == true) goto L57;
    L58:
        long r25 = Long.MAX_VALUE;
        Iterator<a1.a> r26 = this.f31u.iterator();
    L60:
        if (r26.hasNext() == false) goto L66;
        a1.a r27 = r26.next();
        if (r27.h() == true) goto L60;
        long r28 = r27.a(r10.arg1);
        if (r28 >= r25) goto L60;
        r25 = r28;
        goto L60
    L66:
        r24 = r25 - System.currentTimeMillis();
    L67:
        Message r112 = this.f24n.obtainMessage(6);
        r112.arg1 = 2;
        this.f24n.sendMessageDelayed(r112, r24);
        if (this.f34x.size() <= 0) goto L109;
        List<e> r113 = this.f34x;
        monitor-enter(r113);
        Iterator<e> r29 = this.f34x.iterator();     // Catch: Throwable -> L80
    L73:
        if (r29.hasNext() == false) goto L77;
        e r30 = r29.next();     // Catch: Throwable -> L80
        if (r30 == null) goto L73;
        r30.a();     // Catch: Throwable -> L80
        goto L73
    L77:
        this.f34x.clear();     // Catch: Throwable -> L80
        monitor-exit(r113);     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        throw th;
    L57:
        if (this.f26p.k() == false) goto L67;
    L83:
        L((String[]) r10.obj, false);
        goto L109
    L84:
        this.C |= 16;
        if (s().g0() == false) goto L88;
        b1.a.b().a(new b(this));
    L88:
        if (TextUtils.isEmpty(E().e()) == true) goto L90;
        a1.b r114 = new a1.b(this);
        this.f20j = r114;
        this.f31u.add(r114);
    L90:
        List<a1.d> r115 = B();
        this.f25o = r115;
        this.f31u.addAll(r115);
        i();
        this.f24n.removeMessages(6);
        this.f24n.sendEmptyMessage(6);
        O();
        f1.m.d("start_end", new C0000c(this));
        goto L109
    L105:
        this.C |= 1;
        if (this.f19i.D() == false) goto L108;
        this.f16c.b();
        this.f16c.d(new a(this));
    L108:
        f1.g r116 = s().P();
        List<String> r31 = E;
        r116.t(r31, "start bdinstall service begin", new Object[0]);
        this.f16c.start();
        s().P().t(r31, "start bdinstall service end", new Object[0]);
        goto L109
    L92:
        if (this.f19i.D() == false) goto L109;
        if (this.f23m.j() == false) goto L99;
        this.C |= 8;
        this.f24n = new Handler(this.f17g, this);
        this.f24n.sendEmptyMessage(3);
        if (this.f21k.size() <= 0) goto L98;
        this.f28r.removeMessages(4);
        this.f28r.sendEmptyMessageDelayed(4, 1000);
    L98:
        s().P().t(E, "net handler start work", new Object[0]);
        goto L109
    L99:
        this.f28r.removeMessages(2);
        JSONObject r117 = new JSONObject();
        if (this.f16c.getCurrentHeader(r117) == true) goto L102;
    L104:
        this.f28r.sendEmptyMessageDelayed(2, 1000);
        goto L109
    L102:
        if (this.f23m.l(r117) == false) goto L104;
        this.f23m.n(r117);
        this.f28r.sendEmptyMessage(2);
        goto L109
    }

    public int j(l1.a r10, l1.a r11) {
        long r12 = r10.f10828g - r11.f10828g;
        if (r12 >= 0) goto L6;
        return -1;
    L6:
        if (r12 <= 0) goto L9;
        return 1;
    L9:
        return 0;
    }

    public void p(g r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.f46a.isEmpty() == true) goto L6;
    L7:
        x().J(r10.f46a, r10.f47b);
        s().R().n(r10.f46a, r10.f47b);
        return;
    L6:
        if (r10.f47b.isEmpty() == false) goto L7;
    }

    public com.bytedance.applog.c s() {
        return this.f18h;
    }

    public long t() {
        if (s().j0() == false) goto L6;
        return 500;
    L6:
        return v().x();
    }

    public m1.c u() {
        if (this.B != null) goto L15;
        monitor-enter(this);
        m1.c r10 = this.B;     // Catch: Throwable -> L11
        if (r10 != null) goto L8;
        r10 = new m1.c(s(), x(), this.f23m);     // Catch: Throwable -> L11
    L8:
        this.B = r10;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return this.B;
    }

    public g1.b v() {
        return this.f19i;
    }

    public Context w() {
        return s().w();
    }

    public l1.b x() {
        if (this.f22l != null) goto L15;
        monitor-enter(this);
        l1.b r10 = this.f22l;     // Catch: Throwable -> L11
        if (r10 != null) goto L8;
        r10 = new l1.b(this, v().q().l());     // Catch: Throwable -> L11
    L8:
        this.f22l = r10;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return this.f22l;
    }

    public g1.c y() {
        return this.f23m;
    }
}
