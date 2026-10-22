package com.bytedance.apm.block.a;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.Window;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.monitor.collector.k;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.bytedance.apm.core.c {
    private static final f u = null;
    private static boolean w;
    private static com.bytedance.apm.block.a z;
    private a A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f1196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.bytedance.apm.l.d f1197b;
    Runnable c;
    final com.bytedance.apm.l.e d;
    public boolean e;
    private volatile boolean f;
    private long[] g;
    private final List<com.bytedance.apm.block.a> h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private Object m;
    private Object[] n;
    private long[] o;
    private Method p;
    private Choreographer q;
    private boolean r;
    private HashMap<String, Window.OnFrameMetricsAvailableListener> s;
    private long t;
    private boolean v;
    private boolean x;
    private boolean y;

    public interface a {
        void a(FrameMetrics r1);
    }

    static {
        u = new f();
    }

    private f() {
        this.f1196a = new e();
        this.g = new long[4];
        this.h = new CopyOnWriteArrayList();
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.r = false;
        this.f1197b = new com.bytedance.apm.l.d("looper_monitor");
        this.d = new com.bytedance.apm.l.e("looper_monitor");
        this.s = new HashMap();
        this.t = -1;
    }

    public static f a() {
        return u;
    }

    static /* synthetic */ Object a(f r0, Object r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ Object a(f r0, Object r1, String r2) {
        return r0.a(r1, r2);
    }

    private <T> T a(Object r1, String r2) {
        Field r0 = r1.getClass().getDeclaredField(r2);     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return (T) r0.get(r1);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    static /* synthetic */ Method a(f r0, Object r1, String r2, Class[] r3) {
        return r0.a(r1, r2, r3);
    }

    static /* synthetic */ Method a(f r0, Method r1) {
        r0.p = r1;
        return r1;
    }

    public static Method a(Class r7, String r8, Class<?>... r9) {
        Method r10 = (Method) ZeusTransformUtils.preCheckCast(Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9}), Method.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return r10;
    L4:
        return null;
    }

    private Method a(Object r1, String r2, Class<?>... r3) {
        Method r0 = r1.getClass().getDeclaredMethod(r2, r3);     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return r0;
    L4:
        return null;
    }

    static /* synthetic */ void a(f r2, Runnable r3) {
        r2.a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(f r0, String r1) {
        r0.a(r1);
    }

    private synchronized void a(Runnable r8) {
        monitor-enter(this);
        Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (this.f == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.r == false) goto L27;
        monitor-exit(this);
        return;
    L27:
        Object r0 = this.m;     // Catch: Exception -> L26 Throwable -> L23
        monitor-enter(r0);     // Catch: Exception -> L26 Throwable -> L23
        Method r1 = this.p;     // Catch: Throwable -> L18
        if (r1 == null) goto L16;
        r1.invoke(this.n[0], new Object[]{-1L, r9, null});     // Catch: Throwable -> L18
        this.r = true;     // Catch: Throwable -> L18
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Exception -> L26 Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    private void a(String r6) {
        this.l = true;
        int r3 = 0;
        this.g[0] = com.bytedance.monitor.collector.a.f2831b;
        this.g[2] = com.bytedance.monitor.collector.a.c;
        List<com.bytedance.apm.block.a> r5 = this.h;
        int r0 = r5.size();
    L3:
        if (r3 >= r0) goto L8;
        com.bytedance.apm.block.a r1 = (com.bytedance.apm.block.a) ZeusTransformUtils.preCheckCast(r5.get(r3), com.bytedance.apm.block.a.class, "com.obric.memorydata.plugin");
        if (r1.a() == true) goto L7;
        r1.a(r6);
    L7:
        r3 = r3 + 1;
        goto L3
    }

    static /* synthetic */ boolean a(f r0) {
        return r0.f;
    }

    static /* synthetic */ long[] a(f r0, long[] r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ Object[] a(f r0, Object[] r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ Object b(f r0, Object r1, String r2) {
        return r0.b(r1, r2);
    }

    private <T> T b(Object r6, String r7) {
        Field r5 = (Field) ZeusTransformUtils.preCheckCast(Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6.getClass(), new Object[]{r7}), Field.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L4
        r5.setAccessible(true);     // Catch: Exception -> L4
        return (T) r5.get(r6);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    static /* synthetic */ void b(f r0) {
        r0.m();
    }

    static /* synthetic */ List c(f r0) {
        return r0.h;
    }

    static /* synthetic */ Choreographer d(f r0) {
        return r0.q;
    }

    static /* synthetic */ Object e(f r0) {
        return r0.m;
    }

    static /* synthetic */ Object[] f(f r0) {
        return r0.n;
    }

    static /* synthetic */ long[] g(f r0) {
        return r0.o;
    }

    static /* synthetic */ boolean h(f r0) {
        return r0.l;
    }

    static /* synthetic */ boolean i(f r0) {
        return r0.x;
    }

    static /* synthetic */ a j(f r0) {
        return r0.A;
    }

    static /* synthetic */ com.bytedance.apm.block.a k() {
        return z;
    }

    private boolean l() {
        if (this.j == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return true;
    }

    private void m() {
        boolean r14 = this.k;
        if (l() == true) goto L5;
    L15:
        this.g[1] = com.bytedance.monitor.collector.a.f2831b;
        this.g[3] = com.bytedance.monitor.collector.a.c;
        List<com.bytedance.apm.block.a> r0 = this.h;
        int r1 = r0.size();
        int r5 = 0;
    L16:
        if (r5 >= r1) goto L22;
        com.bytedance.apm.block.a r7 = (com.bytedance.apm.block.a) ZeusTransformUtils.preCheckCast(r0.get(r5), com.bytedance.apm.block.a.class, "com.obric.memorydata.plugin");
        if (r7.a() == false) goto L20;
        long[] r8 = this.g;
        boolean r19 = r14;
        r7.a(r8[0], r8[2], r8[1], r8[3], r19);
    L21:
        r5 = r5 + 1;
        r14 = r19;
        goto L16
    L20:
        r19 = r14;
        goto L21
    L22:
        this.f1196a.a();
        this.l = false;
        return;
    L5:
        if (this.k == false) goto L15;
        o();
        final long r4 = com.bytedance.monitor.collector.a.f2831b;
        final long r2 = this.t;
        if (this.o == null) goto L13;
        if (k.a().n() == null) goto L11;
        k.a().n().a(this.o);
    L11:
        d.a().a(this.o, r4);
    L13:
        if (Build.VERSION.SDK_INT >= 24) goto L15;
        this.f1197b.a(new AnonymousClass2(this, r2, r4));
        goto L15
    }

    private void n() {
        this.k = true;
    }

    private void o() {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        a(this.c);
    L5:
        this.k = false;
    }

    @Override // com.bytedance.apm.core.c
    public void a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return;
    L5:
        if (this.q == null) goto L8;
        return;
    L8:
        if (l() == false) goto L16;
        this.q = Choreographer.getInstance();     // Catch: Exception -> L12
    L10:
        com.bytedance.apm.l.b.a().a(new AnonymousClass3(this));
        return;
    }

    @Override // com.bytedance.apm.core.c
    public void a(Activity r4, Bundle r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        Window r7 = ZeusTransformUtils.getWindow(r6, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        if (Build.VERSION.SDK_INT < 23) goto L6;
        final Window.Callback r1 = r7.getCallback();     // Catch: Exception -> L17
        r7.setCallback(new AnonymousClass4(this, r1));     // Catch: Exception -> L17
    L6:
        final String r0 = r6.getClass().getName();     // Catch: Exception -> L17
        String r8 = r6.toString();     // Catch: Exception -> L17
        com.bytedance.monitor.collector.h.g();     // Catch: Exception -> L17
        if (this.i == false) goto L10;
        return;
    L10:
        if (Build.VERSION.SDK_INT >= 24) goto L12;
        return;
    L12:
        if (this.d.b() == false) goto L21;
        Window.OnFrameMetricsAvailableListener r2 = new AnonymousClass5(this, r0);     // Catch: Exception -> L17
        this.s.put(r8, r2);     // Catch: Exception -> L17
        if (this.y == true) goto L22;
        r7.addOnFrameMetricsAvailableListener(r2, this.d.f1409a);     // Catch: Exception -> L17
        return;
    L22:
        return;
    L21:
        return;
    }

    public void a(com.bytedance.apm.block.a r2) {
        if (this.f == true) goto L6;
        g();
    L6:
        if (this.h.contains(r2) == true) goto L11;
        this.h.add(r2);
        if (this.e == false) goto L12;
        com.bytedance.monitor.collector.h.f();
        return;
    L12:
        return;
    }

    public void b() {
        this.f1197b.a();
        this.d.a();
    }

    @Override // com.bytedance.apm.core.c
    public void b(Activity r2) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }

    public void b(com.bytedance.apm.block.a r2) {
        this.h.remove(r2);
        if (this.e == false) goto L10;
        if (f() == 0) goto L7;
        return;
    L7:
        if (com.bytedance.monitor.collector.h.e() != 0) goto L14;
        com.bytedance.monitor.collector.h.c();
        return;
    L14:
        return;
    L10:
        if (this.h.isEmpty() == false) goto L16;
        h();
        return;
    }

    public void c() {
        if (this.v == false) goto L6;
        return;
    L6:
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L10;
        ActivityLifeObserver.getInstance().register(this);
        com.bytedance.monitor.collector.h.a();
        com.bytedance.monitor.collector.h.a(new AnonymousClass1(this));
        this.v = true;
        return;
    L10:
        throw new AssertionError("must be init in main thread!");
    }

    @Override // com.bytedance.apm.core.c
    public void c(Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 24) goto L12;
        Window.OnFrameMetricsAvailableListener r3 = (Window.OnFrameMetricsAvailableListener) ZeusTransformUtils.preCheckCast(this.s.remove(r5.toString()), Window.OnFrameMetricsAvailableListener.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L9
        if (r3 == null) goto L13;
        ZeusTransformUtils.getWindow(r5, "com.obric.memorydata.plugin").removeOnFrameMetricsAvailableListener(r3);     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    }

    public void d() {
        w = true;
    }

    @Override // com.bytedance.apm.core.c
    public void d(Activity r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        if (this.i == true) goto L19;
        return;
    L19:
        if (Build.VERSION.SDK_INT < 24) goto L21;
        Window r0 = ZeusTransformUtils.getWindow(r5, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
        final String r1 = r5.getClass().getName();     // Catch: Exception -> L18
        String r6 = r5.toString();     // Catch: Exception -> L18
        HashMap<String, Window.OnFrameMetricsAvailableListener> r2 = this.s;     // Catch: Exception -> L18
        if (r2 == null) goto L13;
        if (r2.containsKey(r6) == false) goto L13;
        return;
    L13:
        if (this.d.b() == false) goto L22;
        Window.OnFrameMetricsAvailableListener r3 = new AnonymousClass6(this, r1);     // Catch: Exception -> L18
        this.s.put(r6, r3);     // Catch: Exception -> L18
        if (this.y == true) goto L23;
        r0.addOnFrameMetricsAvailableListener(r3, this.d.f1409a);     // Catch: Exception -> L18
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    public boolean e() {
        return w;
    }

    public int f() {
        int r0 = this.h.size();
        boolean r1 = com.bytedance.apm.j.c.e(LogTypeName.MONITOR_TYPE_BLOCK);
        if (e() == false) goto L7;
        if (r1 == false) goto L6;
        return r0;
    L6:
        return r0 - 1;
    L7:
        return r0;
    }

    public synchronized void g() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.apm.b.g() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.v == false) goto L20;
        if (this.f == true) goto L13;
        this.f = true;     // Catch: Throwable -> L21
    L13:
        if (l() == true) goto L15;
    L17:
        monitor-exit(this);
        return;
    L15:
        if (Build.VERSION.SDK_INT < 16) goto L17;
        a(this.c);     // Catch: Throwable -> L21
        goto L17
    L20:
        throw new RuntimeException("never init!");     // Catch: Throwable -> L21
    }

    public synchronized void h() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.apm.b.f() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.v == false) goto L15;
        if (this.f == false) goto L12;
        this.f = false;     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L15:
        throw new RuntimeException("MainThreadMonitor is never init!");     // Catch: Throwable -> L16
    }

    public void i() {
    L17:
        th = move-exception;
        this.r = false;
        throw th;
    L4:
        if (Build.VERSION.SDK_INT > 22) goto L6;
        long r1 = com.bytedance.monitor.collector.a.f2831b;     // Catch: Throwable -> L17
    L8:
        this.t = r1;     // Catch: Throwable -> L17
        n();     // Catch: Throwable -> L17
        this.r = false;
        return;
    L6:
        if (this.o != null) goto L10;
        r1 = com.bytedance.monitor.collector.a.f2831b;     // Catch: Throwable -> L17
        goto L8
    L10:
        if (Build.VERSION.SDK_INT < 31) goto L12;
        r1 = this.o[2] / TimeUtils.NANOSECONDS_PER_MILLISECOND;     // Catch: Throwable -> L17
        goto L8
    L12:
        r1 = this.o[1] / TimeUtils.NANOSECONDS_PER_MILLISECOND;     // Catch: Throwable -> L17
        goto L8
    }

    public boolean j() {
        return this.e;
    }
}
