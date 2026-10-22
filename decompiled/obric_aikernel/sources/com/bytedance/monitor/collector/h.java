package com.bytedance.monitor.collector;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f2320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Printer f2321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.bytedance.apm.block.j f2322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CopyOnWriteArrayList<com.bytedance.monitor.collector.a> f2323d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static com.bytedance.monitor.collector.a f2324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static com.bytedance.monitor.collector.a f2325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile c f2326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f2327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f2328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f2329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f2330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f2331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static Printer f2332m;

    static class a implements Printer {
        a() {
        }

        @Override // android.util.Printer
        public void println(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L5;
            return;
        L5:
            boolean r11 = false;
            if (r10.charAt(0) != '>') goto L13;
            if (o.f2382b == false) goto L10;
            com.bytedance.apm.block.k.e(r10);
            return;
        L10:
            r11 = true;
        L11:
            h.d(r11, r10, null);
            return;
        L13:
            if (r10.charAt(0) == '<') goto L15;
            return;
        L15:
            if (o.f2382b == false) goto L11;
            com.bytedance.apm.block.k.f(r10, null);
        }
    }

    static class b implements com.bytedance.apm.block.j {
        b() {
        }

        @Override // com.bytedance.apm.block.j
        public void messageDispatchStarting(String r10) {
            h.d(true, r10, null);
        }

        @Override // com.bytedance.apm.block.j
        public void messageDispatched(String r10, Message r11) {
            h.d(false, r10, r11);
        }
    }

    public interface c {
        void a(long r10);
    }

    static {
        f2323d = new CopyOnWriteArrayList();
        f2327h = false;
        f2328i = 0;
        f2329j = 0;
    }

    public static void a() {
        if (f2320a == false) goto L24;
        if (f2330k == true) goto L24;
        if (f2325f != null) goto L24;
        if (o0.c.e(LogTypeName.MONITOR_TYPE_BLOCK) == false) goto L12;
        return;
    L12:
        if (Build.VERSION.SDK_INT < 24) goto L30;
        b();
        if (j() == true) goto L17;
        com.bytedance.common.utility.d.g(f2321b);
    L21:
        f2330k = true;
        return;
    L17:
        if (com.bytedance.apm.d.D() == false) goto L19;
        Logger.i("LooperMonitor", "enable Looper Observer monitor.");
    L19:
        com.bytedance.apm.block.k.i(f2322c);
        goto L21
    L30:
        return;
    L24:
        if (f2330k == true) goto L26;
        return;
    L26:
        if (f2331l == true) goto L32;
        b();
        return;
    }

    public static void b() {
        if (f2320a == true) goto L5;
        return;
    L5:
        if (f2331l == false) goto L7;
        return;
    L7:
        if (o.f2383c == true) goto L10;
        return;
    L10:
        if (j() == false) goto L18;
        List<com.bytedance.apm.block.j> r10 = com.bytedance.apm.block.k.c();
        if (r10 == null) goto L29;
        if (r10.size() != 1) goto L29;
        if (r10.get(0) != f2322c) goto L29;
        com.bytedance.apm.block.k.j();
    L27:
        f2331l = true;
    L29:
        if (com.bytedance.apm.d.D() == false) goto L34;
        Logger.i("LooperMonitor", "enable Looper Observer block.");
        return;
    L34:
        return;
    L18:
        List<Printer> r11 = com.bytedance.common.utility.d.e();
        if (r11 == null) goto L29;
        if (r11.size() != 1) goto L29;
        if (r11.get(0) != f2321b) goto L29;
        Printer r12 = f();
        f2332m = r12;
        if (r12 == null) goto L29;
        Looper.getMainLooper().setMessageLogging(null);
        goto L27
    }

    public static void c() {
        if (f2320a == true) goto L5;
        return;
    L5:
        if (f2330k == false) goto L8;
        return;
    L8:
        if (t.e.B().F() == true) goto L10;
        return;
    L10:
        int r10 = t.e.B().C();
        if (f2323d.isEmpty() == false) goto L18;
        if (r10 == 0) goto L14;
        return;
    L14:
        if (f2325f != null) goto L20;
        a();
        return;
    L20:
        return;
    }

    public static void d(boolean r10, String r11, Message r12) {
        long r13 = System.nanoTime();
        com.bytedance.monitor.collector.a.f2242b = r13 / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        com.bytedance.monitor.collector.a.f2243c = SystemClock.currentThreadTimeMillis();
        if (r10 == false) goto L9;
        com.bytedance.monitor.collector.a r14 = f2325f;
        if (r14 == null) goto L9;
        if (r14.d() == false) goto L9;
        f2325f.c(r11);
    L9:
        if (r10 == false) goto L57;
        com.bytedance.monitor.collector.a r15 = f2324e;
        if (r15 == null) goto L57;
        if (r15.d() == false) goto L57;
        f2324e.c(r11);
    L57:
        CopyOnWriteArrayList<com.bytedance.monitor.collector.a> r16 = f2323d;     // Catch: Exception -> L56
        int r17 = 0;
    L17:
        if (r17 >= r16.size()) goto L35;
        com.bytedance.monitor.collector.a r18 = r16.get(r17);     // Catch: Exception -> L56
        if (r18 != null) goto L22;
    L30:
        if (r10 == true) goto L34;
        if (r18.f2244a == false) goto L34;
        r18.b("", null);     // Catch: Exception -> L56
    L34:
        r17 = r17 + 1;
        goto L17
    L22:
        if (r18.d() == false) goto L30;
        if (r10 == false) goto L28;
        if (r18.f2244a == true) goto L34;
        r18.c(r11);     // Catch: Exception -> L56
        goto L34
    L28:
        if (r18.f2244a == false) goto L34;
        r18.b(r11, r12);     // Catch: Exception -> L56
    L35:
        if (r10 == true) goto L41;
        com.bytedance.monitor.collector.a r19 = f2324e;
        if (r19 == null) goto L41;
        if (r19.d() == false) goto L41;
        f2324e.b("", null);
    L41:
        if (r10 == true) goto L48;
        com.bytedance.monitor.collector.a r20 = f2325f;
        if (r20 == null) goto L48;
        if (r20.d() == false) goto L48;
        f2325f.b("", null);
    L48:
        if (f2327h == false) goto L67;
        f2328i += System.nanoTime() - r13;
        int r21 = f2329j;
        f2329j = r21 + 1;
        if (r21 >= 1000) goto L52;
        return;
    L52:
        if (f2326g == null) goto L54;
        f2326g.a(f2328i);
    L54:
        f2329j = 0;
        f2328i = 0;
        f2327h = false;
        return;
    }

    public static void e(boolean r10) {
        f2327h = r10;
    }

    private static Printer f() {
        Field r10 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return (Printer) r10.get(Looper.getMainLooper());
    L4:
        return null;
    }

    public static int g() {
        return f2323d.size();
    }

    public static void h() {
        if (o.f2381a == false) goto L6;
        return;
    L6:
        if (f2320a == false) goto L8;
        return;
    L8:
        f2320a = true;
        f2321b = new a();
        f2322c = new b();
        if (o.f2382b == true) goto L11;
    L19:
        i();
        return;
    L11:
        if (com.bytedance.apm.block.k.d(f2321b) == false) goto L19;
        if (com.bytedance.apm.d.D() == false) goto L16;
        Logger.i("LooperMonitor", "enable Looper Observer monitor.");
    L16:
        if (com.bytedance.apm.block.k.f780b == false) goto L18;
        i();
    L18:
        com.bytedance.apm.block.k.a(f2322c);
    }

    public static void i() {
        com.bytedance.common.utility.d.f();
        com.bytedance.common.utility.d.c(f2321b);
    }

    private static boolean j() {
        if (o.f2382b == true) goto L5;
    L9:
        return false;
    L5:
        if (com.bytedance.apm.block.k.d(f2321b) == false) goto L9;
        if (com.bytedance.apm.block.k.f780b == true) goto L9;
        return true;
    }

    public static void k(com.bytedance.monitor.collector.a r10) {
        CopyOnWriteArrayList<com.bytedance.monitor.collector.a> r11 = f2323d;
        monitor-enter(r11);
        if (r10 != null) goto L15;
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        if (r11.contains(r10) == true) goto L10;
        r11.add(r10);     // Catch: Throwable -> L12
        if (t.e.B().F() == false) goto L10;
        n();     // Catch: Throwable -> L12
        goto L10
    }

    public static void l(com.bytedance.monitor.collector.a r10) {
        f2324e = r10;
    }

    public static void m(c r10) {
        f2326g = r10;
    }

    public static void n() {
        if (f2320a == true) goto L5;
        return;
    L5:
        if (f2330k == false) goto L17;
        o(false);
        if (j() == true) goto L10;
        i();
    L14:
        f2330k = false;
        return;
    L10:
        if (com.bytedance.apm.d.D() == false) goto L12;
        Logger.i("LooperMonitor", "enable Looper Observer monitor.");
    L12:
        com.bytedance.apm.block.k.a(f2322c);
        goto L14
    }

    public static void o(boolean r10) {
        if (f2320a == true) goto L5;
        return;
    L5:
        if (f2331l == true) goto L7;
        return;
    L7:
        if (o.f2383c == true) goto L10;
        return;
    L10:
        if (j() == false) goto L14;
        if (r10 == false) goto L14;
        return;
    L14:
        if (j() == false) goto L17;
        com.bytedance.apm.block.k.b();
    L20:
        if (com.bytedance.apm.d.D() == false) goto L22;
        Logger.i("LooperMonitor", "enable Looper Observer unblock.");
    L22:
        f2331l = false;
        return;
    L17:
        if (f2332m == null) goto L20;
        Looper.getMainLooper().setMessageLogging(f2332m);
        goto L20
    }

    public static void p(com.bytedance.monitor.collector.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        CopyOnWriteArrayList<com.bytedance.monitor.collector.a> r11 = f2323d;
        monitor-enter(r11);
        r11.remove(r10);     // Catch: Throwable -> L17
        if (t.e.B().F() == true) goto L9;
    L15:
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L9:
        if (r11.isEmpty() == false) goto L15;
        if (t.e.B().C() != 0) goto L15;
        if (f2325f != null) goto L15;
        a();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }
}
