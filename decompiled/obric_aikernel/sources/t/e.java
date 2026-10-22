package t;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.core.ILifecycle;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.monitor.collector.k;
import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e implements ILifecycle {
    private static com.bytedance.apm.block.a A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final e f12838y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static boolean f12839z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f12840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t.d f12841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f12842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.bytedance.apm.block.a> f12843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f12845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f12846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f12847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Object f12848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Object[] f12849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long[] f12850k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Method f12851l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Choreographer f12852m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f12853n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final q0.d f12854o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    Runnable f12855p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final q0.e f12856q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private HashMap<String, Window.OnFrameMetricsAvailableListener> f12857r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f12858s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f12859t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f12860u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f12861v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f12862w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private g f12863x;

    class a extends com.bytedance.monitor.collector.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f12864d;

        a(e r10) {
            this.f12864d = r10;
        }

        @Override // com.bytedance.monitor.collector.a
        public void b(String r10, Message r11) {
            super.b(r10, r11);
            e.j(this.f12864d);
        }

        @Override // com.bytedance.monitor.collector.a
        public void c(String r10) {
            super.c(r10);
            e.b(this.f12864d, r10);
        }

        @Override // com.bytedance.monitor.collector.a
        public boolean d() {
            return e.a(this.f12864d);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f12865c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f12866g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e f12867h;

        b(e r10, long r11, long r12) {
            this.f12867h = r10;
            this.f12865c = r11;
            this.f12866g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r10 = e.k(this.f12867h).iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((com.bytedance.apm.block.a) r10.next()).e(ActivityLifeObserver.getInstance().getTopActivityClassName(), this.f12865c, this.f12866g);
            goto L4
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f12868c;

        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ c f12869c;

            a(c r10) {
                this.f12869c = r10;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f12869c.f12868c.A();     // Catch: Throwable -> L4
                return;
            }
        }

        c(e r10) {
            this.f12868c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12868c.f12855p = new a(this);     // Catch: Exception -> L31
            e r10 = this.f12868c;     // Catch: Exception -> L31
            e.m(r10, e.o(r10, e.n(r10), "mLock"));     // Catch: Exception -> L31
            if (e.l(this.f12868c) != null) goto L6;
            e r11 = this.f12868c;     // Catch: Exception -> L31
            e.m(r11, e.p(r11, e.n(r11), "mLock"));     // Catch: Exception -> L31
        L6:
            e r12 = this.f12868c;     // Catch: Exception -> L31
            e.r(r12, (Object[]) e.o(r12, e.n(r12), "mCallbackQueues"));     // Catch: Exception -> L31
            if (e.q(this.f12868c) != null) goto L9;
            e r13 = this.f12868c;     // Catch: Exception -> L31
            e.r(r13, (Object[]) e.p(r13, e.n(r13), "mCallbackQueues"));     // Catch: Exception -> L31
        L9:
            int r14 = Build.VERSION.SDK_INT;     // Catch: Exception -> L31
            if (r14 != 28) goto L13;
            e r15 = this.f12868c;     // Catch: Exception -> L31
            e.t(r15, (long[]) e.p(r15, e.p(r15, e.n(r15), "mFrameInfo"), "mFrameInfo"));     // Catch: Exception -> L31
        L18:
            if (e.s(this.f12868c) != null) goto L22;
            if (r14 <= 22) goto L22;
            t4.a.a("FrameInfoIsNull");     // Catch: Exception -> L31
        L22:
            if (e.l(this.f12868c) != null) goto L25;
            t4.a.a("CallbackQueueLockIsNull");     // Catch: Exception -> L31
        L25:
            if (e.q(this.f12868c) != null) goto L27;
            t4.a.a("callbackQueuesIsNull");     // Catch: Exception -> L31
        L27:
            e r16 = this.f12868c;     // Catch: Exception -> L31
            e.c(r16, e.d(r16, e.q(r16)[0], "addCallbackLocked", new Class[]{Long.TYPE, Object.class, Object.class}));     // Catch: Exception -> L31
            if (r14 < 16) goto L36;
            e r17 = this.f12868c;     // Catch: Exception -> L31
            e.e(r17, r17.f12855p);     // Catch: Exception -> L31
            return;
        L36:
            return;
        L13:
            if (r14 <= 28) goto L15;
            e r18 = this.f12868c;     // Catch: Exception -> L31
            e.t(r18, (long[]) e.p(r18, e.p(r18, e.n(r18), "mFrameInfo"), "frameInfo"));     // Catch: Exception -> L31
            goto L18
        L15:
            if (r14 <= 22) goto L18;
            e r19 = this.f12868c;     // Catch: Exception -> L31
            e.t(r19, (long[]) e.o(r19, e.o(r19, e.n(r19), "mFrameInfo"), "mFrameInfo"));     // Catch: Exception -> L31
        L31:
            e = move-exception;
            t4.a.d(e, "MainThreadMonitor_fullFps");
        }
    }

    class d extends h {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f12870g;

        d(e r10, Window.Callback r11) {
            this.f12870g = r10;
            super(r11);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent r10) {
            if (e.f(this.f12870g) == true) goto L6;
            this.f12870g.f12841b.a(r10.getEventTime());
        L6:
            return this.f12921c.dispatchKeyEvent(r10);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent r10) {
            if (e.f(this.f12870g) == true) goto L6;
            this.f12870g.f12841b.a(r10.getEventTime());
        L6:
            return this.f12921c.dispatchTouchEvent(r10);
        }
    }

    /* JADX INFO: renamed from: t.e$e, reason: collision with other inner class name */
    class WindowOnFrameMetricsAvailableListenerC0294e implements Window.OnFrameMetricsAvailableListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f12872b;

        /* JADX INFO: renamed from: t.e$e$a */
        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f12873c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ long f12874g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f12875h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ WindowOnFrameMetricsAvailableListenerC0294e f12876i;

            a(WindowOnFrameMetricsAvailableListenerC0294e r10, long r11, long r12, int r13) {
                this.f12876i = r10;
                this.f12873c = r11;
                this.f12874g = r12;
                this.f12875h = r13;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f12873c == 0) goto L5;
                return;
            L5:
                if (e.i() != null) goto L7;
            L9:
                Iterator r10 = e.k(this.f12876i.f12872b).iterator();
            L11:
                if (r10.hasNext() == false) goto L16;
                ((com.bytedance.apm.block.a) r10.next()).g(this.f12876i.f12871a, this.f12874g, this.f12875h);
                goto L11
            L16:
                return;
            L7:
                if (this.f12876i.f12872b.f12862w == false) goto L9;
                e.i().g(this.f12876i.f12871a, this.f12874g, this.f12875h);
            }
        }

        /* JADX INFO: renamed from: t.e$e$b */
        class b implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ FrameMetrics f12877c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f12878g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ WindowOnFrameMetricsAvailableListenerC0294e f12879h;

            b(WindowOnFrameMetricsAvailableListenerC0294e r10, FrameMetrics r11, int r12) {
                this.f12879h = r10;
                this.f12877c = r11;
                this.f12878g = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f12877c.getMetric(9) == 0) goto L5;
                return;
            L5:
                if (e.i() != null) goto L7;
            L9:
                Iterator r10 = e.k(this.f12879h.f12872b).iterator();
            L11:
                if (r10.hasNext() == false) goto L16;
                ((com.bytedance.apm.block.a) r10.next()).h(this.f12879h.f12871a, this.f12877c, this.f12878g);
                goto L11
            L16:
                return;
            L7:
                if (this.f12879h.f12872b.f12862w == false) goto L9;
                e.i().h(this.f12879h.f12871a, this.f12877c, this.f12878g);
            }
        }

        WindowOnFrameMetricsAvailableListenerC0294e(e r10, String r11) {
            this.f12872b = r10;
            this.f12871a = r11;
        }

        @Override // android.view.Window.OnFrameMetricsAvailableListener
        public void onFrameMetricsAvailable(Window r13, FrameMetrics r14, int r15) {
            if (e.g(this.f12872b) == false) goto L10;
            long r10 = (((((r14.getMetric(0) + r14.getMetric(1)) + r14.getMetric(2)) + r14.getMetric(3)) + r14.getMetric(4)) + r14.getMetric(5)) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
            long r11 = r14.getMetric(9);
            if (r11 == 0) goto L7;
        L9:
            this.f12872b.f12854o.b(new a(this, r11, r10, r15));
            return;
        L7:
            if (e.h(this.f12872b) == null) goto L9;
            e.h(this.f12872b).a(r14);
            goto L9
        L10:
            FrameMetrics r12 = new FrameMetrics(r14);
            if (r12.getMetric(9) == 0) goto L13;
        L15:
            this.f12872b.f12854o.b(new b(this, r12, r15));
            return;
        L13:
            if (e.h(this.f12872b) == null) goto L15;
            e.h(this.f12872b).a(r12);
            goto L15
        }
    }

    class f implements Window.OnFrameMetricsAvailableListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12880a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f12881b;

        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f12882c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ long f12883g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f12884h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ f f12885i;

            a(f r10, long r11, long r12, int r13) {
                this.f12885i = r10;
                this.f12882c = r11;
                this.f12883g = r12;
                this.f12884h = r13;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f12882c == 0) goto L5;
                return;
            L5:
                if (e.i() != null) goto L7;
            L9:
                Iterator r10 = e.k(this.f12885i.f12881b).iterator();
            L11:
                if (r10.hasNext() == false) goto L16;
                ((com.bytedance.apm.block.a) r10.next()).g(this.f12885i.f12880a, this.f12883g, this.f12884h);
                goto L11
            L16:
                return;
            L7:
                if (this.f12885i.f12881b.f12862w == false) goto L9;
                e.i().g(this.f12885i.f12880a, this.f12883g, this.f12884h);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ FrameMetrics f12886c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f12887g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ f f12888h;

            b(f r10, FrameMetrics r11, int r12) {
                this.f12888h = r10;
                this.f12886c = r11;
                this.f12887g = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f12886c.getMetric(9) == 0) goto L5;
                return;
            L5:
                if (e.i() != null) goto L7;
            L9:
                Iterator r10 = e.k(this.f12888h.f12881b).iterator();
            L11:
                if (r10.hasNext() == false) goto L16;
                ((com.bytedance.apm.block.a) r10.next()).h(this.f12888h.f12880a, this.f12886c, this.f12887g);
                goto L11
            L16:
                return;
            L7:
                if (this.f12888h.f12881b.f12862w == false) goto L9;
                e.i().h(this.f12888h.f12880a, this.f12886c, this.f12887g);
            }
        }

        f(e r10, String r11) {
            this.f12881b = r10;
            this.f12880a = r11;
        }

        @Override // android.view.Window.OnFrameMetricsAvailableListener
        public void onFrameMetricsAvailable(Window r12, FrameMetrics r13, int r14) {
            if (e.g(this.f12881b) == false) goto L5;
            long r10 = (((((r13.getMetric(0) + r13.getMetric(1)) + r13.getMetric(2)) + r13.getMetric(3)) + r13.getMetric(4)) + r13.getMetric(5)) / TimeUtils.NANOSECONDS_PER_MILLISECOND;
            long r11 = r13.getMetric(9);
            this.f12881b.f12854o.b(new a(this, r11, r10, r14));
            return;
        L5:
            FrameMetrics r15 = new FrameMetrics(r13);
            this.f12881b.f12854o.b(new b(this, r15, r14));
        }
    }

    public interface g {
        void a(FrameMetrics r10);
    }

    static {
        f12838y = new e();
    }

    private e() {
        this.f12841b = new t.d();
        this.f12842c = new long[4];
        this.f12843d = new CopyOnWriteArrayList();
        this.f12844e = false;
        this.f12845f = false;
        this.f12846g = false;
        this.f12847h = false;
        this.f12853n = false;
        this.f12854o = new q0.d("looper_monitor");
        this.f12856q = new q0.e("looper_monitor");
        this.f12857r = new HashMap();
        this.f12858s = -1;
    }

    public static e B() {
        return f12838y;
    }

    private boolean G() {
        if (this.f12845f == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return true;
    }

    private Method J(Object r10, String r11, Class<?>... r12) {
        Method r13 = r10.getClass().getDeclaredMethod(r11, r12);     // Catch: Exception -> L4
        r13.setAccessible(true);     // Catch: Exception -> L4
        return r13;
    L4:
        return null;
    }

    public static Method K(Class r10, String r11, Class<?>... r12) {
        Method r13 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r10, new Object[]{r11, r12});     // Catch: Exception -> L4
        r13.setAccessible(true);     // Catch: Exception -> L4
        return r13;
    L4:
        return null;
    }

    private <T> T L(Object r10, String r11) {
        Field r12 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r10.getClass(), new Object[]{r11});     // Catch: Exception -> L4
        r12.setAccessible(true);     // Catch: Exception -> L4
        return (T) r12.get(r10);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private <T> T M(Object r10, String r11) {
        Field r12 = r10.getClass().getDeclaredField(r11);     // Catch: Exception -> L4
        r12.setAccessible(true);     // Catch: Exception -> L4
        return (T) r12.get(r10);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    static /* synthetic */ boolean a(e r10) {
        return r10.f12840a;
    }

    static /* synthetic */ void b(e r10, String r11) {
        r10.w(r11);
    }

    static /* synthetic */ Method c(e r10, Method r11) {
        r10.f12851l = r11;
        return r11;
    }

    static /* synthetic */ Method d(e r10, Object r11, String r12, Class[] r13) {
        return r10.J(r11, r12, r13);
    }

    static /* synthetic */ void e(e r10, Runnable r11) {
        r10.u(r11);
    }

    static /* synthetic */ boolean f(e r10) {
        return r10.f12847h;
    }

    static /* synthetic */ boolean g(e r10) {
        return r10.f12860u;
    }

    static /* synthetic */ g h(e r10) {
        return r10.f12863x;
    }

    static /* synthetic */ com.bytedance.apm.block.a i() {
        return A;
    }

    static /* synthetic */ void j(e r10) {
        r10.x();
    }

    static /* synthetic */ List k(e r10) {
        return r10.f12843d;
    }

    static /* synthetic */ Object l(e r10) {
        return r10.f12848i;
    }

    static /* synthetic */ Object m(e r10, Object r11) {
        r10.f12848i = r11;
        return r11;
    }

    static /* synthetic */ Choreographer n(e r10) {
        return r10.f12852m;
    }

    static /* synthetic */ Object o(e r10, Object r11, String r12) {
        return r10.M(r11, r12);
    }

    static /* synthetic */ Object p(e r10, Object r11, String r12) {
        return r10.L(r11, r12);
    }

    static /* synthetic */ Object[] q(e r10) {
        return r10.f12849j;
    }

    static /* synthetic */ Object[] r(e r10, Object[] r11) {
        r10.f12849j = r11;
        return r11;
    }

    static /* synthetic */ long[] s(e r10) {
        return r10.f12850k;
    }

    static /* synthetic */ long[] t(e r10, long[] r11) {
        r10.f12850k = r11;
        return r11;
    }

    private synchronized void u(Runnable r10) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.f12840a == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f12853n == false) goto L31;
        monitor-exit(this);
        return;
    L31:
        Object r11 = this.f12848i;     // Catch: Exception -> L26 Throwable -> L23
        monitor-enter(r11);     // Catch: Exception -> L26 Throwable -> L23
        Method r12 = this.f12851l;     // Catch: Throwable -> L18
        if (r12 == null) goto L16;
        r12.invoke(this.f12849j[0], new Object[]{-1L, r10, null});     // Catch: Throwable -> L18
        this.f12853n = true;     // Catch: Throwable -> L18
    L16:
        monitor-exit(r11);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Exception -> L26 Throwable -> L23
    L21:
        monitor-exit(this);
    }

    private void w(String r10) {
        this.f12847h = true;
        long[] r11 = this.f12842c;
        int r12 = 0;
        r11[0] = com.bytedance.monitor.collector.a.f2242b;
        r11[2] = com.bytedance.monitor.collector.a.f2243c;
        List<com.bytedance.apm.block.a> r13 = this.f12843d;
        int r14 = r13.size();
    L3:
        if (r12 >= r14) goto L8;
        com.bytedance.apm.block.a r15 = r13.get(r12);
        if (r15.f() == true) goto L7;
        r15.c(r10);
    L7:
        r12 = r12 + 1;
        goto L3
    }

    private void x() {
        boolean r14 = this.f12846g;
        if (G() == true) goto L5;
    L15:
        long[] r10 = this.f12842c;
        r10[1] = com.bytedance.monitor.collector.a.f2242b;
        r10[3] = com.bytedance.monitor.collector.a.f2243c;
        List<com.bytedance.apm.block.a> r11 = this.f12843d;
        int r12 = r11.size();
        int r13 = 0;
    L16:
        if (r13 >= r12) goto L22;
        com.bytedance.apm.block.a r15 = r11.get(r13);
        if (r15.f() == false) goto L20;
        long[] r16 = this.f12842c;
        boolean r19 = r14;
        r15.d(r16[0], r16[2], r16[1], r16[3], r19);
    L21:
        r13 = r13 + 1;
        r14 = r19;
        goto L16
    L20:
        r19 = r14;
        goto L21
    L22:
        this.f12841b.c();
        this.f12847h = false;
        return;
    L5:
        if (this.f12846g == false) goto L15;
        z();
        long r17 = com.bytedance.monitor.collector.a.f2242b;
        long r18 = this.f12858s;
        if (this.f12850k == null) goto L13;
        if (k.n().m() == null) goto L11;
        k.n().m().a(this.f12850k);
    L11:
        t.c.c().b(this.f12850k, r17);
    L13:
        if (Build.VERSION.SDK_INT >= 24) goto L15;
        this.f12854o.b(new b(this, r18, r17));
        goto L15
    }

    private void y() {
        this.f12846g = true;
    }

    private void z() {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        u(this.f12855p);
    L5:
        this.f12846g = false;
    }

    public void A() {
        int r10 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L17
        if (r10 <= 22) goto L13;
        long[] r11 = this.f12850k;     // Catch: Throwable -> L17
        if (r11 != null) goto L10;
        long r12 = com.bytedance.monitor.collector.a.f2242b;     // Catch: Throwable -> L17
    L8:
        this.f12858s = r12;     // Catch: Throwable -> L17
        y();     // Catch: Throwable -> L17
        this.f12853n = false;
        return;
    L10:
        if (r10 < 31) goto L12;
        r12 = r11[2] / TimeUtils.NANOSECONDS_PER_MILLISECOND;     // Catch: Throwable -> L17
        goto L8
    L12:
        r12 = r11[1] / TimeUtils.NANOSECONDS_PER_MILLISECOND;     // Catch: Throwable -> L17
        goto L8
    L13:
        r12 = com.bytedance.monitor.collector.a.f2242b;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.f12853n = false;
        throw th;
    }

    public int C() {
        int r10 = this.f12843d.size();
        boolean r11 = o0.c.e(LogTypeName.MONITOR_TYPE_BLOCK);
        if (E() == false) goto L7;
        if (r11 == false) goto L6;
        return r10;
    L6:
        return r10 - 1;
    L7:
        return r10;
    }

    @TargetApi(16)
    public void D() {
        if (this.f12859t == false) goto L6;
        return;
    L6:
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L10;
        ActivityLifeObserver.getInstance().register(this);
        com.bytedance.monitor.collector.h.h();
        com.bytedance.monitor.collector.h.l(new a(this));
        this.f12859t = true;
        return;
    L10:
        throw new AssertionError("must be init in main thread!");
    }

    public boolean E() {
        return f12839z;
    }

    public boolean F() {
        return this.f12862w;
    }

    public synchronized void H() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.apm.d.J() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f12859t == false) goto L20;
        if (this.f12840a == true) goto L13;
        this.f12840a = true;     // Catch: Throwable -> L21
    L13:
        if (G() == true) goto L15;
    L17:
        monitor-exit(this);
        return;
    L15:
        if (Build.VERSION.SDK_INT < 16) goto L17;
        u(this.f12855p);     // Catch: Throwable -> L21
        goto L17
    L20:
        throw new RuntimeException("never init!");     // Catch: Throwable -> L21
    }

    public synchronized void I() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.apm.d.I() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.f12859t == false) goto L15;
        if (this.f12840a == false) goto L12;
        this.f12840a = false;     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L15:
        throw new RuntimeException("MainThreadMonitor is never init!");     // Catch: Throwable -> L16
    }

    public void N(com.bytedance.apm.block.a r10) {
        this.f12843d.remove(r10);
        if (this.f12862w == false) goto L10;
        if (C() == 0) goto L7;
        return;
    L7:
        if (com.bytedance.monitor.collector.h.g() != 0) goto L14;
        com.bytedance.monitor.collector.h.a();
        return;
    L14:
        return;
    L10:
        if (this.f12843d.isEmpty() == false) goto L16;
        I();
        return;
    }

    public void O() {
        f12839z = true;
    }

    public void P(boolean r10) {
        this.f12861v = r10;
    }

    public void Q(boolean r10) {
        this.f12860u = r10;
    }

    public void R(boolean r10) {
        this.f12862w = r10;
    }

    public void S(boolean r10) {
        this.f12844e = r10;
    }

    public void T(com.bytedance.apm.block.a r10) {
        A = r10;
    }

    public void U(boolean r10) {
        this.f12845f = r10;
    }

    public void V() {
        this.f12854o.c();
        this.f12856q.k();
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onActivityCreated(Activity r10, Bundle r11) {
        Window r12 = r10.getWindow();     // Catch: Exception -> L16
        int r13 = Build.VERSION.SDK_INT;     // Catch: Exception -> L16
        if (r13 < 23) goto L5;
        r12.setCallback(new d(this, r12.getCallback()));     // Catch: Exception -> L16
    L5:
        String r14 = r10.getClass().getName();     // Catch: Exception -> L16
        String r15 = r10.toString();     // Catch: Exception -> L16
        com.bytedance.monitor.collector.h.c();     // Catch: Exception -> L16
        if (this.f12844e == false) goto L9;
        return;
    L9:
        if (r13 >= 24) goto L11;
        return;
    L11:
        if (this.f12856q.e() == false) goto L20;
        WindowOnFrameMetricsAvailableListenerC0294e r16 = new WindowOnFrameMetricsAvailableListenerC0294e(this, r14);     // Catch: Exception -> L16
        this.f12857r.put(r15, r16);     // Catch: Exception -> L16
        if (this.f12861v == true) goto L21;
        r12.addOnFrameMetricsAvailableListener(r16, this.f12856q.f12446d);     // Catch: Exception -> L16
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onActivityDestroyed(Activity r10) {
        if (Build.VERSION.SDK_INT < 24) goto L11;
        Window.OnFrameMetricsAvailableListener r11 = this.f12857r.remove(r10.toString());     // Catch: Exception -> L8
        if (r11 == null) goto L12;
        r10.getWindow().removeOnFrameMetricsAvailableListener(r11);     // Catch: Exception -> L8
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onActivityResumed(Activity r10) {
        if (this.f12844e == true) goto L19;
        return;
    L19:
        if (Build.VERSION.SDK_INT < 24) goto L21;
        Window r11 = r10.getWindow();     // Catch: Exception -> L18
        String r12 = r10.getClass().getName();     // Catch: Exception -> L18
        String r13 = r10.toString();     // Catch: Exception -> L18
        HashMap<String, Window.OnFrameMetricsAvailableListener> r14 = this.f12857r;     // Catch: Exception -> L18
        if (r14 == null) goto L13;
        if (r14.containsKey(r13) == false) goto L13;
        return;
    L13:
        if (this.f12856q.e() == false) goto L22;
        f r15 = new f(this, r12);     // Catch: Exception -> L18
        this.f12857r.put(r13, r15);     // Catch: Exception -> L18
        if (this.f12861v == true) goto L23;
        r11.addOnFrameMetricsAvailableListener(r15, this.f12856q.f12446d);     // Catch: Exception -> L18
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onBackground(Activity r10) {
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onFront(Activity r10) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return;
    L5:
        if (this.f12852m == null) goto L8;
        return;
    L8:
        if (G() == false) goto L16;
        this.f12852m = Choreographer.getInstance();     // Catch: Exception -> L12
    L10:
        q0.b.f().i(new c(this));
        return;
    }

    public void v(com.bytedance.apm.block.a r10) {
        if (this.f12840a == true) goto L6;
        H();
    L6:
        if (this.f12843d.contains(r10) == true) goto L11;
        this.f12843d.add(r10);
        if (this.f12862w == false) goto L12;
        com.bytedance.monitor.collector.h.n();
        return;
    L12:
        return;
    }
}
