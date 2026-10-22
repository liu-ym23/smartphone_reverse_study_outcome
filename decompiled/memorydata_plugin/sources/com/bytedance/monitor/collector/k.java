package com.bytedance.monitor.collector;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm6.perf.base.model.ThreadStatInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile boolean f2867a = false;
    private static a c;
    private static volatile k d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.bytedance.apm.l.e f2868b;
    private final List<b> e;
    private volatile boolean f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile boolean i;
    private volatile boolean j;
    private volatile boolean k;
    private volatile boolean l;
    private boolean m;
    private boolean n;
    private BinderMonitor o;
    private l p;
    private c q;
    private g r;
    private d s;
    private e t;
    private j u;

    public interface a {
        void a(String r1);
    }

    static {
    }

    private k() {
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.e = new CopyOnWriteArrayList();
        ActivityLifeObserver.getInstance().register(new AnonymousClass1(this));
    }

    public static k a() {
        if (d != null) goto L15;
        monitor-enter(k.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new k();     // Catch: Throwable -> L11
    L9:
        monitor-exit(k.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public static synchronized boolean a(Context r3) {
        monitor-enter(k.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (f2867a == true) goto L11;
        a r1 = c;     // Catch: Throwable -> L14
        if (r1 == null) goto L9;
        r1.a("monitorcollector-lib");     // Catch: Throwable -> L14
        f2867a = true;     // Catch: Throwable -> L14
    L10:
        ByteHook.init();     // Catch: Throwable -> L14
        goto L11
    L9:
        f2867a = com.bytedance.monitor.util.a.b.a(r4, "monitorcollector-lib");     // Catch: Throwable -> L14
    L11:
        boolean r5 = f2867a;     // Catch: Throwable -> L14
        monitor-exit(k.class);
        return r5;
    L14:
        th = move-exception;
        throw th;
    }

    public static boolean b() {
        return f2867a;
    }

    public ThreadStatInfo a(int r1, int r2) {
        return MonitorJni.getThreadStatInfo(r1, r2);
    }

    public JSONObject a(long r7, long r9) {
        return a(r7, r9, false);
    }

    public JSONObject a(long r7, long r9, boolean r11) {
        JSONObject r1 = new JSONObject();
        int r2 = 0;
    L4:
        if (r2 >= this.e.size()) goto L12;
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.e.get(r2), b.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        if (r11 == true) goto L8;
    L10:
        Pair<String, ?> r4 = r3.dumpInfosRange(r7, r9);     // Catch: Exception -> L13
        r1.put((String) ZeusTransformUtils.preCheckCast(r4.first, String.class, "com.obric.memorydata.plugin"), r4.second);     // Catch: Exception -> L13
        goto L11
    L8:
        if (ZeusTransformUtils.instanceOf(r3, g.class) == false) goto L10;
    L11:
        r2 = r2 + 1;
        goto L4
    L12:
        return r1;
    }

    public void a(int r4) {
        if (this.i == false) goto L10;
        Iterator<b> r3 = this.e.iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.refreshConfig(r4);
        goto L6
    L16:
        return;
    }

    public synchronized void a(long r2, boolean r4) {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(true);     // Catch: Throwable -> L9
        if (f2867a == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.enableLockAll(r2, r4);     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void a(Context r3, j r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (this.f == false) goto L12;
        if (com.bytedance.apm.b.k() == false) goto L8;
        Log.w("PerfMonitorManager", "PerfMonitorManager init twice? " + r4, new Throwable());     // Catch: Throwable -> L16
    L8:
        a(r4);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L12:
        if (a(r5) == false) goto L14;
        l.a();     // Catch: Throwable -> L16
        a(r4);     // Catch: Throwable -> L16
        this.f = true;     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public void a(b r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.e.contains(r2) == true) goto L10;
        this.e.add(r2);
        if (this.g == false) goto L11;
        r2.start();
        return;
    L11:
        return;
    }

    public void a(boolean r1) {
        this.n = r1;
    }

    public synchronized boolean a(j r6) {
        monitor-enter(this);
        this.u = r6;     // Catch: Throwable -> L42
        if (com.bytedance.apm.b.k() == false) goto L8;
        Log.i("PerfMonitorManager", "PerfMonitorManager update config:\n " + r6);     // Catch: Throwable -> L42
        c(true);     // Catch: Throwable -> L42
    L8:
        if (b() == true) goto L11;
        monitor-exit(this);
        return false;
    L11:
        this.k = r6.d();     // Catch: Throwable -> L42
        e r0 = this.t;     // Catch: Throwable -> L42
        if (r0 == null) goto L21;
        if (this.j == false) goto L16;
    L18:
        boolean r3 = false;
    L19:
        r0.a(r3);     // Catch: Throwable -> L42
        goto L21
    L16:
        if (this.k == false) goto L18;
        r3 = true;
    L21:
        if (this.p != null) goto L24;
        this.p = new l(r6.f());     // Catch: Throwable -> L42
    L24:
        if (r6.b() == false) goto L30;
        if (this.o != null) goto L28;
        this.o = new BinderMonitor(r6.f());     // Catch: Throwable -> L42
    L28:
        this.o.enable();     // Catch: Throwable -> L42
    L30:
        if (r6.a() == false) goto L36;
        if (this.q != null) goto L34;
        this.q = new c(r6.f());     // Catch: Throwable -> L42
    L34:
        this.q.a(r6.e());     // Catch: Throwable -> L42
    L36:
        if (r6.c() == true) goto L38;
    L40:
        monitor-exit(this);
        return true;
    L38:
        if (this.r != null) goto L40;
        this.r = new g(r6.f(), false);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }

    public boolean a(String r1, int[] r2, Object[] r3, long[] r4, float[] r5) {
        return MonitorJni.readProcFile(r1, r2, r3, r4, r5);
    }

    public long b(int r3) {
        if (this.n == true) goto L7;
        return com.bytedance.apm.util.b.b();
    L7:
        if (b() == true) goto L12;
        return 0;
    L12:
        return MonitorJni.getTotalCPUTimeByTimeInStat(r3);
    L11:
        return 0;
    }

    public String b(long r2, long r4) {
        if (this.t != null) goto L5;
        return null;
    L5:
        if (this.j == false) goto L8;
        return null;
    L8:
        return this.t.a(r2, r4);
    }

    public void b(boolean r1) {
        this.j = r1;
    }

    public int c(int r1) {
        return MonitorJni.getProcCGroup(r1);
    }

    void c(boolean r1) {
        if (f2867a == true) goto L5;
        return;
    L5:
        MonitorJni.doSetDebugMode(r1);     // Catch: Throwable -> L7
        return;
    }

    public boolean c() {
        return this.f;
    }

    public String d(int r1) {
        return MonitorJni.doDumpNativeStack(r1);
    }

    public void d() {
        this.i = true;
    }

    public d.a e() {
        d r0 = this.s;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public void f() {
        if (this.t != null) goto L5;
        return;
    L5:
        if (this.k == false) goto L9;
        this.t.a();
        return;
    }

    public void g() {
        if (this.t != null) goto L5;
        return;
    L5:
        if (this.k == false) goto L9;
        this.t.b();
        return;
    }

    public void h() {
        int r0 = 0;
    L4:
        if (r0 >= this.e.size()) goto L6;
        ((b) ZeusTransformUtils.preCheckCast(this.e.get(r0), b.class, "com.obric.memorydata.plugin")).start();
        r0 = r0 + 1;
        goto L4
    L6:
        this.g = true;
    }

    public com.bytedance.apm.l.e i() {
        return this.f2868b;
    }

    public synchronized void j() {
        monitor-enter(this);
        LockMonitorManager.setOpenFetchStack(false);     // Catch: Throwable -> L9
        if (f2867a == true) goto L13;
    L7:
        monitor-exit(this);
        return;
    L13:
        MonitorJni.disableLock();     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        throw th;
    }

    public List<BinderMonitor.a> k() {
        BinderMonitor r0 = this.o;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getBinderInfoListCopy();
    }

    public JSONObject l() {
        JSONObject r1 = new JSONObject();
        int r2 = 0;
    L10:
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        return r1;
    L4:
        if (r2 >= this.e.size()) goto L9;
        Pair<String, ?> r3 = ((b) ZeusTransformUtils.preCheckCast(this.e.get(r2), b.class, "com.obric.memorydata.plugin")).dumpInfo();     // Catch: Exception -> L7
        r1.put((String) ZeusTransformUtils.preCheckCast(r3.first, String.class, "com.obric.memorydata.plugin"), r3.second);     // Catch: Exception -> L7
        r2 = r2 + 1;
        goto L10
    }

    public long m() {
        if (this.n == true) goto L7;
        return com.bytedance.apm.util.b.d();
    L7:
        if (b() == true) goto L12;
        return 0;
    L12:
        return MonitorJni.doGetAppCpuTime();
    L14:
        return 0;
    }

    public g.c n() {
        g r0 = this.r;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.f2840a;
    }

    public g.e o() {
        g r0 = this.r;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.b();
    }
}
