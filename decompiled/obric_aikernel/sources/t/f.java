package t;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f12889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f12890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f12891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f12892d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long[] f12893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f12894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f12895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile long f12896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile long f12897i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Thread f12898j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile Runnable f12899k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static HandlerThread f12900l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Handler f12901m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static Object f12902n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f12903o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static Runnable f12904p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static com.bytedance.monitor.collector.a f12905q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static Runnable f12906r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static C0295f f12907s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static C0295f f12908t;

    static class a extends com.bytedance.monitor.collector.a {
        a() {
        }

        @Override // com.bytedance.monitor.collector.a
        public void b(String r10, Message r11) {
            super.b(r10, r11);
            f.l();
        }

        @Override // com.bytedance.monitor.collector.a
        public void c(String r10) {
            super.c(r10);
            f.k();
        }

        @Override // com.bytedance.monitor.collector.a
        public boolean d() {
            if (f.a() == null) goto L6;
            f.a().run();
            f.b(null);
        L6:
            if (f.c() >= 1) goto L10;
            return false;
        L10:
            return true;
        }
    }

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
        L16:
        L15:
            return;
        L3:
            if (f.m() == true) goto L7;
            if (f.c() <= (-1)) goto L7;
            f.o(f.p() - f.q());     // Catch: InterruptedException -> L15
            f.o(f.n() & 8796093022207L);     // Catch: InterruptedException -> L15
            SystemClock.sleep(5);     // Catch: InterruptedException -> L15
        L7:
            Object r10 = f.r();     // Catch: InterruptedException -> L15
            monitor-enter(r10);     // Catch: InterruptedException -> L15
            f.r().wait();     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L15
        }
    }

    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.s();
        }
    }

    static class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.d().removeCallbacksAndMessages(null);
            com.bytedance.monitor.collector.h.p(f.f());
            f.g().quit();
            f.h(null);
        }
    }

    static class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r10 = f.i();
            monitor-enter(r10);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (f.c() != Integer.MAX_VALUE) goto L7;
        L8:
            f.e(-2);     // Catch: Throwable -> L11
            f.j(true);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r10);     // Catch: Throwable -> L11
            return;
        L7:
            if (f.c() != 1) goto L9;
            goto L8
        }
    }

    /* JADX INFO: renamed from: t.f$f, reason: collision with other inner class name */
    public static final class C0295f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f12910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private C0295f f12911c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private C0295f f12912d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f12913e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f12914f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f12915g;

        public C0295f(int r10) {
            this.f12913e = true;
            this.f12909a = r10;
        }

        static /* synthetic */ C0295f a(C0295f r10) {
            return r10.f12912d;
        }

        static /* synthetic */ C0295f b(C0295f r10, C0295f r11) {
            r10.f12912d = r11;
            return r11;
        }

        static /* synthetic */ C0295f c(C0295f r10) {
            return r10.f12911c;
        }

        static /* synthetic */ C0295f d(C0295f r10, C0295f r11) {
            r10.f12911c = r11;
            return r11;
        }

        static /* synthetic */ long e(C0295f r10) {
            return r10.f12915g;
        }

        static /* synthetic */ long f(C0295f r10, long r11) {
            r10.f12915g = r11;
            return r11;
        }

        public String toString() {
            return "index:" + this.f12909a + ",\tisValid:" + this.f12913e + " source:" + this.f12914f;
        }
    }

    static {
        f12889a = new f();
        f12890b = Integer.MAX_VALUE;
        f12891c = false;
        Object r10 = new Object();
        f12892d = r10;
        f12893e = null;
        f12894f = 0;
        f12895g = false;
        f12896h = B();
        f12897i = f12896h;
        f12898j = Looper.getMainLooper().getThread();
        f12899k = null;
        f12900l = F();
        f12901m = new Handler(f12900l.getLooper());
        f12902n = new Object();
        f12903o = false;
        f12904p = null;
        f12905q = new a();
        f12906r = new b();
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        f12890b = -4;
        f12891c = true;
    L17:
        f12901m.postDelayed(new c(), 15000);
        return;
    L5:
        f12893e = new long[600000];
        if (f12890b != Integer.MAX_VALUE) goto L16;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f12890b != Integer.MAX_VALUE) goto L11;
        M();     // Catch: Throwable -> L13
        f12890b = 1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L13
    L16:
        G(1048574, 0);
        I("EvilMethodTracer#message_0", com.bytedance.monitor.collector.a.f2242b);
        goto L17
    }

    public f() {
    }

    private static long B() {
        return SystemClock.uptimeMillis();
    }

    public static long C() {
        return f12897i;
    }

    public static f E() {
        return f12889a;
    }

    private static HandlerThread F() {
        HandlerThread r10 = new HandlerThread("trace_time_update_thread");
        r10.start();
        return r10;
    }

    public static void G(int r10, long r11) {
        if (f12891c == false) goto L6;
        return;
    L6:
        if (r10 < 1048575) goto L9;
        return;
    L9:
        if (Thread.currentThread() == f12898j) goto L11;
        return;
    L11:
        if (f12895g == false) goto L13;
        return;
    L13:
        f12895g = true;
        if (r11 == 0) goto L16;
        f12896h = r11 - f12897i;
        f12896h &= 8796093022207L;
    L16:
        long r12 = ((((long) r10) << 43) | Long.MIN_VALUE) | f12896h;
        long[] r13 = f12893e;
        int r14 = f12894f;
        r13[r14] = r12;
        int r15 = r14 + 1;
        f12894f = r15;
        if (r15 != 600000) goto L19;
        f12894f = 0;
    L19:
        f12895g = false;
        C0295f r16 = f12908t;
        if (r16 != null) goto L23;
        return;
    L23:
        if (r16.f12909a != f12894f) goto L30;
        C0295f r17 = C0295f.a(r16);
        f12908t = r17;
        if (r17 == null) goto L27;
        C0295f.d(r17, null);
        return;
    L27:
        f12907s = null;
        return;
    }

    public static C0295f I(String r10, long r11) {
        if (f12907s != null) goto L9;
        C0295f r12 = new C0295f(f12894f);
        f12907s = r12;
        if (r11 > 0) goto L7;
        r11 = SystemClock.uptimeMillis();
    L7:
        C0295f.f(r12, r11);
        C0295f r13 = f12907s;
        r13.f12914f = r10;
        f12908t = r13;
        return r13;
    L9:
        C0295f r14 = new C0295f(f12894f);
        if (r11 > 0) goto L12;
        r11 = SystemClock.uptimeMillis();
    L12:
        C0295f.f(r14, r11);
        r14.f12914f = r10;
        C0295f.d(r14, f12907s);
        C0295f r15 = f12907s;
        r15.f12910b = r14.f12909a - 1;
        C0295f.b(r15, r14);
        f12907s = r14;
        return r14;
    }

    public static void J(int r10, long r11) {
        if (f12891c == false) goto L6;
        return;
    L6:
        if (r10 < 1048575) goto L9;
        return;
    L9:
        if (Thread.currentThread() == f12898j) goto L11;
        return;
    L11:
        if (r11 == 0) goto L13;
        f12896h = r11 - f12897i;
        f12896h &= 8796093022207L;
    L13:
        long r12 = ((((long) r10) << 43) | 0) | f12896h;
        long[] r13 = f12893e;
        int r14 = f12894f;
        r13[r14] = r12;
        int r15 = r14 + 1;
        f12894f = r15;
        if (r15 != 600000) goto L16;
        f12894f = 0;
    L16:
        C0295f r16 = f12908t;
        if (r16 != null) goto L19;
        return;
    L19:
        if (r16.f12909a != f12894f) goto L27;
        C0295f r17 = C0295f.a(r16);
        f12908t = r17;
        if (r17 == null) goto L23;
        C0295f.d(r17, null);
        return;
    L23:
        f12907s = null;
        return;
    }

    private static void M() {
        f12896h = B() - f12897i;
        f12901m.removeCallbacksAndMessages(null);
        f12901m.postDelayed(f12906r, 5);
        Handler r10 = f12901m;
        e r11 = new e();
        f12904p = r11;
        r10.postDelayed(r11, 15000);
        com.bytedance.monitor.collector.h.k(f12905q);
    }

    private static void N() {
        Object r10 = f12892d;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f12890b != Integer.MAX_VALUE) goto L7;
    L8:
        f12890b = -3;     // Catch: Throwable -> L11
        f12891c = true;     // Catch: Throwable -> L11
        f12899k = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L7:
        if (f12890b != (-4)) goto L9;
        goto L8
    }

    static /* synthetic */ Runnable a() {
        return f12899k;
    }

    static /* synthetic */ Runnable b(Runnable r10) {
        f12899k = r10;
        return r10;
    }

    static /* synthetic */ int c() {
        return f12890b;
    }

    static /* synthetic */ Handler d() {
        return f12901m;
    }

    static /* synthetic */ int e(int r10) {
        f12890b = r10;
        return r10;
    }

    static /* synthetic */ com.bytedance.monitor.collector.a f() {
        return f12905q;
    }

    static /* synthetic */ HandlerThread g() {
        return f12900l;
    }

    static /* synthetic */ long[] h(long[] r10) {
        f12893e = r10;
        return r10;
    }

    static /* synthetic */ Object i() {
        return f12892d;
    }

    static /* synthetic */ boolean j(boolean r10) {
        f12891c = r10;
        return r10;
    }

    static /* synthetic */ void k() {
        y();
    }

    static /* synthetic */ void l() {
        z();
    }

    static /* synthetic */ boolean m() {
        return f12903o;
    }

    static /* synthetic */ long n() {
        return f12896h;
    }

    static /* synthetic */ long o(long r10) {
        f12896h = r10;
        return r10;
    }

    static /* synthetic */ long p() {
        return B();
    }

    static /* synthetic */ long q() {
        return f12897i;
    }

    static /* synthetic */ Object r() {
        return f12902n;
    }

    static /* synthetic */ void s() {
        N();
    }

    private long[] v(long r10, long r11) {
        C0295f r12 = f12907s;
        if (r12 == null) goto L19;
        C0295f r13 = f12908t;
        if (r13 == null) goto L28;
    L7:
        if (r12 == r13) goto L14;
        if (C0295f.e(C0295f.c(r12)) > r11) goto L10;
        if (C0295f.e(C0295f.a(r13)) >= r10) goto L14;
        r13 = C0295f.a(r13);
        goto L7
    L10:
        r12 = C0295f.c(r12);
    L14:
        int r14 = r12.f12910b;
        if (r14 != 0) goto L18;
        r14 = f12894f - 1;
    L18:
        return u(r13.f12909a, r14);
    L28:
        return null;
    L19:
        return null;
    }

    private static void y() {
        f12896h = com.bytedance.monitor.collector.a.f2242b - f12897i;
        f12903o = false;
        Object r10 = f12902n;
        monitor-enter(r10);
        f12902n.notify();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void z() {
        f12903o = true;
    }

    public String A(long[] r10, long r11) {
        if (r10 != null) goto L5;
        return "";
    L5:
        LinkedList r12 = new LinkedList();
        k4.a.j(r10, r12, true, r11);
        k4.a.l(r12, 1);
        StringBuilder r13 = new StringBuilder();
        k4.a.g(r12, r13);
        return r13.toString();
    }

    public String D(long r10, long r11) {
        long r12 = SystemClock.uptimeMillis();
        return A(v(r10, r11), r12);
    }

    public boolean H() {
        if (f12890b < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void K() {
        Object r10 = f12892d;
        monitor-enter(r10);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f12890b < 2) goto L7;
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L7:
        if (f12890b < (-2)) goto L13;
        f12901m.removeCallbacks(f12904p);     // Catch: Throwable -> L15
        if (f12893e == null) goto L12;
        f12890b = 2;     // Catch: Throwable -> L15
        f12891c = false;     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("MethodCollector sBuffer == null");     // Catch: Throwable -> L15
    }

    public void L() {
        Object r10 = f12892d;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f12890b != 2) goto L7;
        f12890b = -1;     // Catch: Throwable -> L9
        f12891c = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L9
    }

    public long[] t() {
        C0295f r10 = f12907s;     // Catch: Throwable -> L15
        if (r10 == null) goto L14;
        C0295f r11 = f12908t;     // Catch: Throwable -> L15
        if (r11 == null) goto L14;
        if (r10 == r11) goto L14;
        int r12 = r10.f12910b;     // Catch: Throwable -> L15
        if (r12 != 0) goto L12;
        r12 = f12894f - 1;     // Catch: Throwable -> L15
    L12:
        return u(r11.f12909a, r12);
    L14:
        return null;
    }

    public long[] u(int r10, int r11) {
        long[] r12 = new long[0];
        int r13 = Math.max(0, r10);
        int r14 = Math.max(0, r11);
        if (r14 <= r13) goto L5;
        int r15 = (r14 - r13) + 1;
        long[] r16 = new long[r15];
        System.arraycopy(f12893e, r13, r16, 0, r15);
        return r16;
    L5:
        if (r14 >= r13) goto L9;
        int r17 = r14 + 1;
        long[] r18 = f12893e;
        long[] r19 = new long[(r18.length - r13) + r17];
        System.arraycopy(r18, r13, r19, 0, r18.length - r13);
        long[] r20 = f12893e;
        System.arraycopy(r20, 0, r19, r20.length - r13, r17);
        return r19;
    L9:
        return r12;
    }

    public long[] w(C0295f r10) {
        return x(r10, new C0295f(f12894f - 1));
    }

    public long[] x(C0295f r10, C0295f r11) {
        if (f12890b != (-3)) goto L6;
        return null;
    L6:
        long[] r12 = new long[0];
        if (r10.f12913e == false) goto L13;
        if (r11.f12913e == false) goto L13;
        return u(r10.f12909a - 1, r11.f12909a);
    L13:
        return r12;
    }
}
