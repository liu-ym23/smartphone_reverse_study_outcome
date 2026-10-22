package com.bytedance.monitor.collector;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static b f2349o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static volatile boolean f2350p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static volatile k f2351q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.bytedance.monitor.collector.b> f2352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f2353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f2354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f2355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f2356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f2357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BinderMonitor f2359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private l f2360i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f2361j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private g f2362k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d f2363l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private e f2364m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected q0.e f2365n;

    class a implements t4.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f2366c;

        a(k r10) {
            this.f2366c = r10;
        }

        @Override // t4.d
        public void onActivityCreated(Activity r10, Bundle r11) {
        }

        @Override // t4.d
        public void onActivityPause(Activity r10) {
        }

        @Override // t4.d
        public void onActivityResume(Activity r10) {
        }

        @Override // t4.d
        public void onActivityStarted(Activity r10) {
        }

        @Override // t4.d
        public void onBackground(Activity r10) {
            this.f2366c.D();
        }

        @Override // t4.d
        public void onChange(Activity r10, Fragment r11) {
        }

        @Override // t4.d
        public void onFront(Activity r10) {
            this.f2366c.C();
        }
    }

    public interface b {
        void loadLibrary(String r10);
    }

    static {
    }

    private k() {
        this.f2353b = false;
        this.f2354c = false;
        this.f2355d = false;
        this.f2356e = false;
        this.f2357f = false;
        this.f2352a = new CopyOnWriteArrayList();
        ActivityLifeObserver.getInstance().register(new a(this));
    }

    public static k n() {
        if (f2351q != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2351q != null) goto L9;
        f2351q = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return f2351q;
    }

    public static boolean t() {
        return f2350p;
    }

    public static synchronized boolean u(Context r10) {
        monitor-enter(k.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f2350p == true) goto L11;
        b r11 = f2349o;     // Catch: Throwable -> L14
        if (r11 == null) goto L9;
        r11.loadLibrary("monitorcollector-lib");     // Catch: Throwable -> L14
        f2350p = true;     // Catch: Throwable -> L14
    L10:
        ByteHook.init();     // Catch: Throwable -> L14
        goto L11
    L9:
        f2350p = y3.b.c(r10, "monitorcollector-lib");     // Catch: Throwable -> L14
    L11:
        boolean r12 = f2350p;     // Catch: Throwable -> L14
        monitor-exit(k.class);
        return r12;
    }

    public void A() {
        int r10 = 0;
    L4:
        if (r10 >= this.f2352a.size()) goto L6;
        this.f2352a.get(r10).d();
        r10 = r10 + 1;
        goto L4
    L6:
        this.f2354c = true;
    }

    public synchronized void B(long r10, boolean r11) {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(true);     // Catch: Throwable -> L9
        if (f2350p == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.enableLockAll(r10, r11);     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public void C() {
        if (this.f2364m != null) goto L5;
        return;
    L5:
        if (this.f2357f == false) goto L9;
        this.f2364m.start();
        return;
    }

    public void D() {
        if (this.f2364m != null) goto L5;
        return;
    L5:
        if (this.f2357f == false) goto L9;
        this.f2364m.stop();
        return;
    }

    public synchronized boolean E(j r10) {
        monitor-enter(this);
    L42:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.apm.d.D() == false) goto L8;
        Log.i("PerfMonitorManager", "PerfMonitorManager update config:\n " + r10);     // Catch: Throwable -> L42
        b(true);     // Catch: Throwable -> L42
    L8:
        if (t() == true) goto L11;
        monitor-exit(this);
        return false;
    L11:
        this.f2357f = r10.f();     // Catch: Throwable -> L42
        e r11 = this.f2364m;     // Catch: Throwable -> L42
        if (r11 == null) goto L21;
        if (this.f2356e == false) goto L16;
    L18:
        boolean r12 = false;
    L19:
        r11.b(r12);     // Catch: Throwable -> L42
        goto L21
    L16:
        if (this.f2357f == false) goto L18;
        r12 = true;
    L21:
        if (this.f2360i != null) goto L24;
        this.f2360i = new l(r10.b());     // Catch: Throwable -> L42
    L24:
        if (r10.d() == false) goto L30;
        if (this.f2359h != null) goto L28;
        this.f2359h = new BinderMonitor(r10.b());     // Catch: Throwable -> L42
    L28:
        this.f2359h.j();     // Catch: Throwable -> L42
    L30:
        if (r10.c() == false) goto L36;
        if (this.f2361j != null) goto L34;
        this.f2361j = new c(r10.b());     // Catch: Throwable -> L42
    L34:
        this.f2361j.i(r10.a());     // Catch: Throwable -> L42
    L36:
        if (r10.e() == true) goto L38;
    L40:
        monitor-exit(this);
        return true;
    L38:
        if (this.f2362k != null) goto L40;
        this.f2362k = new g(r10.b(), false);     // Catch: Throwable -> L42
        goto L40
    }

    public void a(com.bytedance.monitor.collector.b r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.f2352a.contains(r10) == true) goto L10;
        this.f2352a.add(r10);
        if (this.f2354c == false) goto L11;
        r10.d();
        return;
    L11:
        return;
    }

    void b(boolean r10) {
        if (f2350p == true) goto L5;
        return;
    L5:
        MonitorJni.doSetDebugMode(r10);     // Catch: Throwable -> L7
        return;
    }

    public long c() {
        if (this.f2358g == true) goto L7;
        return com.bytedance.apm.util.b.b();
    L7:
        if (t() == true) goto L12;
        return 0;
    L12:
        return MonitorJni.doGetAppCpuTime();
    L14:
        return 0;
    }

    @Nullable
    public List<BinderMonitor.a> d() {
        BinderMonitor r10 = this.f2359h;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.k();
    }

    public JSONObject e() {
        JSONObject r10 = new JSONObject();
        int r11 = 0;
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        return r10;
    L4:
        if (r11 >= this.f2352a.size()) goto L9;
        Pair<String, ?> r12 = this.f2352a.get(r11).a();     // Catch: Exception -> L7
        r10.put((String) r12.first, r12.second);     // Catch: Exception -> L7
        r11 = r11 + 1;
        goto L10
    }

    public JSONObject f(long r10, long r11) {
        return g(r10, r11, false);
    }

    public JSONObject g(long r10, long r11, boolean r12) {
        JSONObject r13 = new JSONObject();
        int r14 = 0;
    L4:
        if (r14 >= this.f2352a.size()) goto L12;
        com.bytedance.monitor.collector.b r15 = this.f2352a.get(r14);     // Catch: Exception -> L13
        if (r12 == true) goto L8;
    L10:
        Pair<String, ?> r16 = r15.b(r10, r11);     // Catch: Exception -> L13
        r13.put((String) r16.first, r16.second);     // Catch: Exception -> L13
        goto L11
    L8:
        if ((r15 instanceof g) == false) goto L10;
    L11:
        r14 = r14 + 1;
        goto L4
    L12:
        return r13;
    }

    public String h(int r10) {
        return MonitorJni.doDumpNativeStack(r10);
    }

    public String i(long r10, long r11) {
        if (this.f2364m != null) goto L5;
        return null;
    L5:
        if (this.f2356e == false) goto L8;
        return null;
    L8:
        return this.f2364m.a(r10, r11);
    }

    public ThreadStatInfo j(int r10, int r11) {
        return MonitorJni.getThreadStatInfo(r10, r11);
    }

    public long k(int r10) {
        if (this.f2358g == true) goto L7;
        return com.bytedance.apm.util.b.o();
    L7:
        if (t() == true) goto L12;
        return 0;
    L12:
        return MonitorJni.getTotalCPUTimeByTimeInStat(r10);
    L11:
        return 0;
    }

    public synchronized void l() {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(false);     // Catch: Throwable -> L9
        if (f2350p == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.disableLock();     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public g.InterfaceC0066g m() {
        g r10 = this.f2362k;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.f2254f;
    }

    public g.i o() {
        g r10 = this.f2362k;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.E();
    }

    public d.a p() {
        d r10 = this.f2363l;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.a();
    }

    public int q(int r10) {
        return MonitorJni.getProcCGroup(r10);
    }

    public q0.e r() {
        return this.f2365n;
    }

    public synchronized void s(Context r10, @NonNull j r11) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f2353b == false) goto L12;
        if (com.bytedance.apm.d.D() == false) goto L8;
        Log.w("PerfMonitorManager", "PerfMonitorManager init twice? " + r11, new Throwable());     // Catch: Throwable -> L16
    L8:
        E(r11);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L12:
        if (u(r10) == false) goto L14;
        l.i();     // Catch: Throwable -> L16
        E(r11);     // Catch: Throwable -> L16
        this.f2353b = true;     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
    }

    public void v() {
        this.f2355d = true;
    }

    public boolean w(String r10, int[] r11, Object[] r12, long[] r13, float[] r14) {
        return MonitorJni.readProcFile(r10, r11, r12, r13, r14);
    }

    public void x(int r10) {
        if (this.f2355d == false) goto L10;
        Iterator<com.bytedance.monitor.collector.b> r11 = this.f2352a.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        com.bytedance.monitor.collector.b r12 = r11.next();
        if (r12 == null) goto L6;
        r12.c(r10);
        goto L6
    L16:
        return;
    }

    public void y(boolean r10) {
        this.f2358g = r10;
    }

    public void z(boolean r10) {
        this.f2356e = r10;
    }
}
