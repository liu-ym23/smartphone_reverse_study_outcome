package com.bytedance.apm.trace.fps;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.apm.block.a.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final Long s = null;
    private static final Long t = null;
    private static com.bytedance.apm.block.a.b u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1468b;
    private com.bytedance.apm.block.a.b.a c;
    private b.d d;
    private b.e e;
    private volatile b.c f;
    private volatile b.f g;
    private volatile b.InterfaceC0095b h;
    private LinkedList<Integer> i;
    private HashMap<String, String> j;
    private float k;
    private float l;
    private float m;
    private float n;
    private long o;
    private long p;
    private a q;
    private WindowManager r;
    private final boolean v;
    private final JSONObject w;

    private class a extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f1472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f1473b;
        private int c;

        public a(c r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.f1472a = r3;
            super(r5);
            this.f1473b = -1;
            this.c = 0;
        }

        static /* synthetic */ int a(a r0, int r1) {
            r0.c = r1;
            return r1;
        }

        static /* synthetic */ long a(a r0, long r1) {
            r0.f1473b = r1;
            return r1;
        }

        @Override // android.view.View
        public void onDraw(Canvas r5) {
            if (this.f1473b != (-1)) goto L5;
            this.f1473b = SystemClock.elapsedRealtime();
            int r6 = 0;
        L6:
            this.c = r6;
            if (c.l(this.f1472a) == null) goto L9;
            c.l(this.f1472a).a(SystemClock.elapsedRealtime());
        L9:
            long r0 = SystemClock.elapsedRealtime() - this.f1473b;
            if (r0 <= c.d().longValue()) goto L16;
            double r2 = (((double) this.c) / r0) * c.e().longValue();
            if (c.m(this.f1472a) == null) goto L14;
            c.m(this.f1472a).a(r2);
        L14:
            com.bytedance.apm.trace.fps.a.a().a(c.n(this.f1472a), c.f(this.f1472a), (float) r2);
            c.o(this.f1472a);
            return;
        L16:
            return;
        L5:
            r6 = this.c + 1;
            goto L6
        }
    }

    static {
        s = 200L;
        t = 1000L;
    }

    public c(String r4, boolean r5, JSONObject r6) {
        this.f1468b = false;
        this.c = new com.bytedance.apm.block.a.b.a();
        this.e = null;
        this.j = new HashMap();
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.f1467a = r4;
        this.v = r5;
        this.w = r6;
        this.i = new LinkedList();
        if (Build.VERSION.SDK_INT >= 16) goto L6;
        this.r = (WindowManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin");
        this.q = new a(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        return;
    }

    static /* synthetic */ int a(int r0, float r1) {
        return b(r0, r1);
    }

    private void a(long r2, long r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.i.isEmpty() == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        int r3 = (this.p > 0 ? 1 : (this.p == 0 ? 0 : -1));
        this.p = 0;     // Catch: Throwable -> L11
        final LinkedList<Integer> r5 = this.i;     // Catch: Throwable -> L11
        this.i = new LinkedList();     // Catch: Throwable -> L11
        final com.bytedance.apm.block.a.b.a r6 = this.c;     // Catch: Throwable -> L11
        this.c = new com.bytedance.apm.block.a.b.a();     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        final HashMap r7 = new HashMap();
        r7.putAll(this.j);
        com.bytedance.apm.l.b.a().a(new AnonymousClass2(this, r5, r7, r6));
    }

    static /* synthetic */ void a(c r2, Map r3, float r4) {
        r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), r4);
    }

    private void a(Map<String, String> r4, float r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        b.d r0 = this.d;
        if (r0 == null) goto L5;
        r0.a(r5);
    L5:
        com.bytedance.apm.trace.fps.a.a().a(r6, this.f1467a, r5);
    }

    static /* synthetic */ boolean a(c r0) {
        return r0.f1468b;
    }

    private static int b(int r1, float r2) {
        return r1 / ((int) (r2 * 100.0f));
    }

    static /* synthetic */ a b(c r0) {
        return r0.q;
    }

    static /* synthetic */ b.c c(c r0) {
        return r0.f;
    }

    static /* synthetic */ b.InterfaceC0095b d(c r0) {
        return r0.h;
    }

    static /* synthetic */ Long d() {
        return s;
    }

    static /* synthetic */ b.f e(c r0) {
        return r0.g;
    }

    static /* synthetic */ Long e() {
        return t;
    }

    static /* synthetic */ String f(c r0) {
        return r0.f1467a;
    }

    private void f() {
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
    }

    static /* synthetic */ float g(c r0) {
        return r0.k;
    }

    private boolean g() {
        return com.bytedance.apm.j.c.a("fps", this.f1467a);
    }

    static /* synthetic */ float h(c r0) {
        return r0.l;
    }

    private boolean h() {
        return com.bytedance.apm.j.c.a("fps_drop", this.f1467a);
    }

    static /* synthetic */ float i(c r0) {
        return r0.m;
    }

    private void i() {
        if (u == null) goto L6;
        this.f1468b = true;
        u.a(this);
        return;
    }

    static /* synthetic */ float j(c r0) {
        return r0.n;
    }

    private void j() {
        com.bytedance.apm.block.a.b r0 = u;
        if (r0 == null) goto L9;
        r0.b(this);
        if (this.f1468b == true) goto L7;
        return;
    L7:
        a(this.o, SystemClock.uptimeMillis());
        this.f1468b = false;
        return;
    }

    static /* synthetic */ JSONObject k(c r0) {
        return r0.w;
    }

    private void k() {
        a.a(this.q, -1);
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams(-2, -2, 2005, 0, -3);
        r0.gravity = 51;
        r0.flags = 24;
        r0.height = 1;
        r0.width = 1;
        this.r.removeView(this.q);     // Catch: Exception -> L6
    L4:
        this.r.addView(this.q, r0);
        this.q.postDelayed(new AnonymousClass1(this), 10);
    }

    static /* synthetic */ b.e l(c r0) {
        return r0.e;
    }

    private void l() {
        if (this.f1468b == true) goto L10;
        return;
    L10:
        this.r.removeView(this.q);     // Catch: Exception -> L9
        a.a(this.q, -1);     // Catch: Exception -> L9
        a.a(this.q, 0);     // Catch: Exception -> L9
    L7:
        this.f1468b = false;
    }

    static /* synthetic */ b.d m(c r0) {
        return r0.d;
    }

    static /* synthetic */ HashMap n(c r0) {
        return r0.j;
    }

    static /* synthetic */ void o(c r0) {
        r0.l();
    }

    public void a() {
        if (this.f1468b == false) goto L6;
        return;
    L6:
        if (this.v == false) goto L8;
    L10:
        f();
        if (Build.VERSION.SDK_INT >= 16) goto L13;
        k();
    L14:
        this.o = SystemClock.uptimeMillis();
        this.f1468b = true;
        return;
    L13:
        i();
        b.a(this.f1467a);
        goto L14
    L8:
        if (c() == true) goto L10;
    }

    public void a(long r3) {
        if (r3 >= 0) goto L5;
        return;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.i.size() <= 20000) goto L9;
        this.i.poll();     // Catch: Throwable -> L12
    L9:
        this.i.add(Integer.valueOf(((int) r3) * 100));     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    }

    public void a(b.c r3) {
        this.f = (b.c) ZeusTransformUtils.wrapperContextForParams(r3, b.c.class, "com.obric.memorydata.plugin");
    }

    public void a(b.d r3) {
        this.d = (b.d) ZeusTransformUtils.wrapperContextForParams(r3, b.d.class, "com.obric.memorydata.plugin");
    }

    public synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (Build.VERSION.SDK_INT >= 16) goto L8;
        monitor-exit(this);
        return;
    L8:
        j();     // Catch: Throwable -> L11
        b.b(this.f1467a);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public boolean c() {
        if (f.a().j() == false) goto L13;
        if (com.bytedance.apm.b.c() == true) goto L7;
        return false;
    L7:
        if (h() == true) goto L11;
        if (g() == true) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (com.bytedance.apm.b.c() == true) goto L19;
        if (h() == true) goto L19;
        if (g() == true) goto L19;
        return false;
    L19:
        return true;
    }
}
