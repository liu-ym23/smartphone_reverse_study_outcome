package com.bytedance.apm.trace.fps;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.apm.block.h;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static boolean c = false;
    private static final Long q = null;
    private static final Long r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f1460b;
    private d d;
    private c e;
    private com.bytedance.apm.trace.fps.c f;
    private e g;
    private Choreographer.FrameCallback h;
    private LinkedList<Integer> i;
    private HashMap<String, String> j;
    private float k;
    private float l;
    private float m;
    private float n;
    private a o;
    private WindowManager p;
    private boolean s;
    private final JSONObject t;
    private long u;
    private long v;
    private int w;

    private class a extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f1466b;
        private int c;

        public a(b r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.f1465a = r3;
            super(r5);
            this.f1466b = -1;
            this.c = 0;
        }

        static /* synthetic */ int a(a r0, int r1) {
            r0.c = r1;
            return r1;
        }

        static /* synthetic */ long a(a r0, long r1) {
            r0.f1466b = r1;
            return r1;
        }

        @Override // android.view.View
        public void onDraw(Canvas r5) {
            if (this.f1466b != (-1)) goto L5;
            this.f1466b = SystemClock.elapsedRealtime();
            int r6 = 0;
        L6:
            this.c = r6;
            if (b.d(this.f1465a) == null) goto L9;
            b.d(this.f1465a).a(SystemClock.elapsedRealtime());
        L9:
            long r0 = SystemClock.elapsedRealtime() - this.f1466b;
            if (r0 <= b.e().longValue()) goto L16;
            double r2 = (((double) this.c) / r0) * b.f().longValue();
            if (b.n(this.f1465a) == null) goto L14;
            b.n(this.f1465a).a(r2);
        L14:
            com.bytedance.apm.trace.fps.a.a().a(b.o(this.f1465a), b.h(this.f1465a), (float) r2);
            b.p(this.f1465a);
            return;
        L16:
            return;
        L5:
            r6 = this.c + 1;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.trace.fps.b$b, reason: collision with other inner class name */
    public interface InterfaceC0095b {
        void a(long r1, int r3);
    }

    public interface c {
        void a(JSONObject r1);
    }

    public interface d {
        void a(double r1);
    }

    public interface e {
        void a(long r1);
    }

    public interface f {
        void a(JSONObject r1, int r2);
    }

    static {
        q = 200L;
        r = 1000L;
    }

    public b(String r2, boolean r3) {
        this(r2, r3, null);
    }

    public b(String r4, boolean r5, JSONObject r6) {
        this.f1460b = false;
        this.g = null;
        this.j = new HashMap();
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = null;
        this.p = null;
        this.u = -1;
        this.v = -1;
        this.w = 0;
        this.t = r6;
        if (c == false) goto L6;
        this.f = new com.bytedance.apm.trace.fps.c(r4, r5, r6);
        return;
    L6:
        this.f1459a = r4;
        this.s = r5;
        this.i = new LinkedList();
        if (Build.VERSION.SDK_INT >= 16) goto L10;
        this.p = (WindowManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window"), WindowManager.class, "com.obric.memorydata.plugin");
        this.o = new a(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        return;
    }

    static /* synthetic */ int a(int r0, float r1) {
        return b(r0, r1);
    }

    static /* synthetic */ long a(b r0, long r1) {
        r0.u = r1;
        return r1;
    }

    private void a(long r5, long r7) {
        if (this.v > 0) goto L5;
        return;
    L5:
        long r8 = r7 - r5;
        if ((r8 / TimeUtils.NANOSECONDS_PER_MILLISECOND) > 0) goto L8;
        return;
    L8:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L10:
        if (this.i.size() <= 20000) goto L12;
        this.i.poll();     // Catch: Throwable -> L15
    L12:
        this.i.add(Integer.valueOf(((int) r8) / 10000));     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
    }

    static /* synthetic */ void a(b r0, long r1, long r3) {
        r0.a(r1, r3);
    }

    public static void a(String r0) {
        h.a(r0);
    }

    static /* synthetic */ boolean a(b r0) {
        return r0.f1460b;
    }

    private static int b(int r1, float r2) {
        int r3 = (int) (r2 * 100.0f);
        return ((r1 + (r3 - 1)) / r3) - 1;
    }

    static /* synthetic */ long b(b r0, long r1) {
        r0.v = r1;
        return r1;
    }

    static /* synthetic */ a b(b r0) {
        return r0.o;
    }

    public static void b(String r0) {
        h.b(r0);
    }

    static /* synthetic */ long c(b r2) {
        return r2.u;
    }

    static /* synthetic */ e d(b r0) {
        return r0.g;
    }

    public static String d() {
        return h.a();
    }

    static /* synthetic */ int e(b r1) {
        int r0 = r1.w + 1;
        r1.w = r0;
        return r0;
    }

    static /* synthetic */ Long e() {
        return q;
    }

    static /* synthetic */ long f(b r2) {
        return r2.v;
    }

    static /* synthetic */ Long f() {
        return r;
    }

    static /* synthetic */ c g(b r0) {
        return r0.e;
    }

    private void g() {
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
    }

    static /* synthetic */ String h(b r0) {
        return r0.f1459a;
    }

    private boolean h() {
        return com.bytedance.apm.j.c.a("fps", this.f1459a);
    }

    static /* synthetic */ float i(b r0) {
        return r0.k;
    }

    private boolean i() {
        return com.bytedance.apm.j.c.a("fps_drop", this.f1459a);
    }

    static /* synthetic */ float j(b r0) {
        return r0.l;
    }

    private void j() {
        monitor-enter(this);
        this.i.clear();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        n();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ float k(b r0) {
        return r0.m;
    }

    private void k() {
        if (this.f1460b == true) goto L5;
        return;
    L5:
        o();
        if (this.h == null) goto L8;
        Choreographer.getInstance().removeFrameCallback(this.h);
    L8:
        p();
        this.f1460b = false;
    }

    static /* synthetic */ float l(b r0) {
        return r0.n;
    }

    private void l() {
        a.a(this.o, -1);
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams(-2, -2, 2005, 0, -3);
        r0.gravity = 51;
        r0.flags = 24;
        r0.height = 1;
        r0.width = 1;
        this.p.removeView(this.o);     // Catch: Exception -> L6
    L4:
        this.p.addView(this.o, r0);
        this.o.postDelayed(new AnonymousClass1(this), 10);
    }

    static /* synthetic */ JSONObject m(b r0) {
        return r0.t;
    }

    private void m() {
        if (this.f1460b == true) goto L10;
        return;
    L10:
        this.p.removeView(this.o);     // Catch: Exception -> L9
        a.a(this.o, -1);     // Catch: Exception -> L9
        a.a(this.o, 0);     // Catch: Exception -> L9
    L7:
        this.f1460b = false;
    }

    static /* synthetic */ d n(b r0) {
        return r0.d;
    }

    private void n() {
        this.u = -1;
        this.v = -1;
        this.w = 0;
        this.h = new AnonymousClass2(this);
        Choreographer.getInstance().postFrameCallback(this.h);     // Catch: Exception -> L5
        return;
    L5:
        this.f1460b = false;
        this.u = -1;
        this.v = -1;
        this.w = 0;
        this.h = null;
    }

    static /* synthetic */ HashMap o(b r0) {
        return r0.j;
    }

    private void o() {
        long r0 = this.v - this.u;
        if (r0 <= 0) goto L12;
        int r2 = this.w;
        if (r2 <= 1) goto L13;
        long r3 = (((((long) (r2 - 1)) * 1000) * 1000) * 1000) / r0;
        d r1 = this.d;
        if (r1 == null) goto L10;
        r1.a(r3);
    L10:
        com.bytedance.apm.trace.fps.a.a().a(this.j, this.f1459a, r3);
        return;
    L13:
        return;
    }

    private void p() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.i.isEmpty() == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        final LinkedList<Integer> r0 = this.i;     // Catch: Throwable -> L11
        this.i = new LinkedList();     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        com.bytedance.apm.l.b.a().a(new AnonymousClass3(this, r0));
    }

    static /* synthetic */ void p(b r0) {
        r0.m();
    }

    public void a() {
        com.bytedance.apm.trace.fps.c r0 = this.f;
        if (r0 == null) goto L7;
        r0.a();
        return;
    L7:
        if (this.f1460b == false) goto L10;
        return;
    L10:
        if (this.s == false) goto L12;
    L14:
        g();
        if (Build.VERSION.SDK_INT >= 16) goto L17;
        l();
    L18:
        this.f1460b = true;
        return;
    L17:
        j();
        a(this.f1459a);
        goto L18
    L12:
        if (c() == true) goto L14;
    }

    public void a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        com.bytedance.apm.trace.fps.c r0 = this.f;
        if (r0 == null) goto L5;
        r0.a(r4);
    L5:
        this.e = r4;
    }

    public void a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        com.bytedance.apm.trace.fps.c r0 = this.f;
        if (r0 == null) goto L5;
        r0.a(r4);
    L5:
        this.d = r4;
    }

    public synchronized void b() {
        monitor-enter(this);
        com.bytedance.apm.trace.fps.c r0 = this.f;     // Catch: Throwable -> L16
        if (r0 == null) goto L10;
        r0.b();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L10:
        if (Build.VERSION.SDK_INT >= 16) goto L13;
        monitor-exit(this);
        return;
    L13:
        k();     // Catch: Throwable -> L16
        b(this.f1459a);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public boolean c() {
        if (com.bytedance.apm.b.c() == true) goto L5;
    L9:
        return false;
    L5:
        if (i() == false) goto L7;
    L8:
        return true;
    L7:
        if (h() == false) goto L9;
        goto L8
    }
}
