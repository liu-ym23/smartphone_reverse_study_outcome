package i2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f8105a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f8106b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f8107c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long[] f8108d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f8109e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f8110f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile long f8111g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile long f8112h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Thread f8113i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile Runnable f8114j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HandlerThread f8115k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Handler f8116l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Object f8117m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f8118n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static d f8119o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f8120p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b f8121q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static C0090e f8122r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static C0090e f8123s;

    public static class a extends a8.a {
        @Override // a8.a
        public final void a() {
            this.f120a = false;
            e.f8118n = true;
        }

        @Override // a8.a
        public final void b(String r8) {
            this.f120a = true;
            e.f8111g = a8.a.f118b - e.f8112h;
            e.f8118n = false;
            Object r10 = e.f8117m;
            monitor-enter(r10);
            r10.notify();     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // a8.a
        public final boolean c() {
            if (e.f8114j == null) goto L6;
            e.f8114j.run();
            e.f8114j = null;
        L6:
            if (e.f8105a >= 1) goto L10;
            return false;
        L10:
            return true;
        }
    }

    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
        L16:
        L15:
            return;
        L3:
            if (e.f8118n == true) goto L7;
            if (e.f8105a <= (-1)) goto L7;
            e.f8111g = SystemClock.uptimeMillis() - e.f8112h;     // Catch: InterruptedException -> L15
            e.f8111g &= 8796093022207L;     // Catch: InterruptedException -> L15
            SystemClock.sleep(5);     // Catch: InterruptedException -> L15
        L7:
            Object r8 = e.f8117m;     // Catch: InterruptedException -> L15
            monitor-enter(r8);     // Catch: InterruptedException -> L15
            r8.wait();     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L15
        }
    }

    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            Object r8 = e.f8107c;
            monitor-enter(r8);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (e.f8105a != Integer.MAX_VALUE) goto L7;
        L8:
            e.f8105a = -3;     // Catch: Throwable -> L11
            e.f8106b = true;     // Catch: Throwable -> L11
            e.f8114j = new f();     // Catch: Throwable -> L11
        L9:
            monitor-exit(r8);     // Catch: Throwable -> L11
            return;
        L7:
            if (e.f8105a != (-4)) goto L9;
            goto L8
        }
    }

    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            Object r8 = e.f8107c;
            monitor-enter(r8);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (e.f8105a != Integer.MAX_VALUE) goto L7;
        L8:
            e.f8105a = -2;     // Catch: Throwable -> L13
            e.f8106b = true;     // Catch: Throwable -> L13
        L9:
            monitor-exit(r8);     // Catch: Throwable -> L13
            return;
        L7:
            if (e.f8105a != 1) goto L9;
            goto L8
        }
    }

    /* JADX INFO: renamed from: i2.e$e, reason: collision with other inner class name */
    public static final class C0090e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C0090e f8126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C0090e f8127d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8128e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f8129f;

        public C0090e(int r8) {
            this.f8124a = r8;
        }

        public final String toString() {
            return "index:" + this.f8124a + ",\tisValid:true source:" + this.f8128e;
        }
    }

    static {
        Object r8 = new Object();
        f8107c = r8;
        f8108d = new long[600000];
        f8111g = SystemClock.uptimeMillis();
        f8112h = f8111g;
        f8113i = Looper.getMainLooper().getThread();
        f8114j = null;
        HandlerThread r10 = new HandlerThread("trace_time_update_thread");
        r10.start();
        f8115k = r10;
        Handler r11 = new Handler(r10.getLooper());
        f8116l = r11;
        f8117m = new Object();
        f8118n = false;
        f8119o = null;
        f8120p = new a();
        f8121q = new b();
        if (f8105a != Integer.MAX_VALUE) goto L13;
        monitor-enter(r8);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (f8105a != Integer.MAX_VALUE) goto L8;
        g();     // Catch: Throwable -> L10
        f8105a = 1;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
    L13:
        c(1048574, 0);
        d(a8.a.f118b, "EvilMethodTracer#message_0");
        r11.postDelayed(new c(), SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME);
    }

    public static long[] a(int r8, int r10) {
        long[] r11 = new long[0];
        int r12 = Math.max(0, r8);
        int r13 = Math.max(0, r10);
        if (r13 <= r12) goto L5;
        int r14 = (r13 - r12) + 1;
        long[] r15 = new long[r14];
        System.arraycopy(f8108d, r12, r15, 0, r14);
        return r15;
    L5:
        if (r13 >= r12) goto L9;
        int r16 = r13 + 1;
        long[] r17 = f8108d;
        long[] r18 = new long[(r17.length - r12) + r16];
        System.arraycopy(r17, r12, r18, 0, r17.length - r12);
        long[] r19 = f8108d;
        System.arraycopy(r19, 0, r18, r19.length - r12, r16);
        return r18;
    L9:
        return r11;
    }

    public static String b(long r8, long[] r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        LinkedList r11 = new LinkedList();
        g8.b.f(r10, r11, r8);
        ListIterator r12 = r11.listIterator(r11.size());
    L7:
        if (r12.hasPrevious() == false) goto L13;
        g r13 = (g) r12.previous();
        if (r13 == null) goto L7;
        if (r13.f8131b >= 1) goto L7;
        r12.remove();
        goto L7
    L13:
        StringBuilder r14 = new StringBuilder();
        g8.b.e(r11, r14);
        return r14.toString();
    }

    public static void c(int r8, long r10) {
        if (f8106b == false) goto L6;
        return;
    L6:
        if (r8 < 1048575) goto L9;
        return;
    L9:
        if (Thread.currentThread() == f8113i) goto L11;
        return;
    L11:
        if (f8110f == false) goto L13;
        return;
    L13:
        f8110f = true;
        if (r10 == 0) goto L16;
        f8111g = r10 - f8112h;
        f8111g &= 8796093022207L;
    L16:
        long r11 = ((((long) r8) << 43) | Long.MIN_VALUE) | f8111g;
        long[] r12 = f8108d;
        int r13 = f8109e;
        r12[r13] = r11;
        int r14 = r13 + 1;
        f8109e = r14;
        if (r14 != 600000) goto L19;
        f8109e = 0;
    L19:
        f8110f = false;
        C0090e r15 = f8123s;
        if (r15 != null) goto L23;
        return;
    L23:
        if (r15.f8124a != f8109e) goto L30;
        C0090e r16 = r15.f8127d;
        f8123s = r16;
        if (r16 == null) goto L27;
        r16.f8126c = null;
        return;
    L27:
        f8122r = null;
        return;
    }

    public static C0090e d(long r8, String r10) {
        if (f8122r != null) goto L9;
        C0090e r11 = new C0090e(f8109e);
        f8122r = r11;
        if (r8 > 0) goto L7;
        r8 = SystemClock.uptimeMillis();
    L7:
        r11.f8129f = r8;
        C0090e r12 = f8122r;
        r12.f8128e = r10;
        f8123s = r12;
        return r12;
    L9:
        int r13 = f8109e;
        C0090e r14 = new C0090e(r13);
        if (r8 > 0) goto L12;
        r8 = SystemClock.uptimeMillis();
    L12:
        r14.f8129f = r8;
        r14.f8128e = r10;
        C0090e r15 = f8122r;
        r14.f8126c = r15;
        r15.f8125b = r13 - 1;
        r15.f8127d = r14;
        f8122r = r14;
        return r14;
    }

    public static void e(int r8, long r10) {
        if (f8106b == false) goto L6;
        return;
    L6:
        if (r8 < 1048575) goto L9;
        return;
    L9:
        if (Thread.currentThread() == f8113i) goto L11;
        return;
    L11:
        if (r10 == 0) goto L13;
        f8111g = r10 - f8112h;
        f8111g &= 8796093022207L;
    L13:
        long r11 = ((((long) r8) << 43) | 0) | f8111g;
        long[] r12 = f8108d;
        int r13 = f8109e;
        r12[r13] = r11;
        int r14 = r13 + 1;
        f8109e = r14;
        if (r14 != 600000) goto L16;
        f8109e = 0;
    L16:
        C0090e r15 = f8123s;
        if (r15 != null) goto L19;
        return;
    L19:
        if (r15.f8124a != f8109e) goto L27;
        C0090e r16 = r15.f8127d;
        f8123s = r16;
        if (r16 == null) goto L23;
        r16.f8126c = null;
        return;
    L23:
        f8122r = null;
        return;
    }

    public static void f() {
        Object r8 = f8107c;
        monitor-enter(r8);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f8105a < 2) goto L7;
    L13:
        monitor-exit(r8);     // Catch: Throwable -> L15
        return;
    L7:
        if (f8105a < (-2)) goto L13;
        f8116l.removeCallbacks(f8119o);     // Catch: Throwable -> L15
        if (f8108d == null) goto L12;
        f8105a = 2;     // Catch: Throwable -> L15
        f8106b = false;     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("MethodCollector sBuffer == null");     // Catch: Throwable -> L15
    }

    public static void g() {
        f8111g = SystemClock.uptimeMillis() - f8112h;
        Handler r8 = f8116l;
        r8.removeCallbacksAndMessages(null);
        r8.postDelayed(f8121q, 5);
        d r10 = new d();
        f8119o = r10;
        r8.postDelayed(r10, SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME);
        a r11 = f8120p;
        CopyOnWriteArrayList<a8.a> r12 = a8.e.f123c;
        monitor-enter(r12);
        if (r11 != null) goto L13;
    L8:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        if (r12.contains(r11) == true) goto L8;
        r12.add(r11);     // Catch: Throwable -> L10
        i2.b.f8089k.getClass();     // Catch: Throwable -> L10
        goto L8
    }
}
