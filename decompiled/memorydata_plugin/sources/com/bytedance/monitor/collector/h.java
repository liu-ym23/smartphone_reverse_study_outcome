package com.bytedance.monitor.collector;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import com.bytedance.apm6.perf.base.model.LogTypeName;
import com.bytedance.common.utility.Logger;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f2859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Printer f2860b;
    private static com.bytedance.apm.block.j c;
    private static final CopyOnWriteArrayList<com.bytedance.monitor.collector.a> d = null;
    private static com.bytedance.monitor.collector.a e;
    private static com.bytedance.monitor.collector.a f;
    private static volatile a g;
    private static volatile boolean h;
    private static long i;
    private static int j;
    private static boolean k;
    private static boolean l;
    private static Printer m;

    public interface a {
        void a(long r1);
    }

    static {
        d = new CopyOnWriteArrayList();
        h = false;
        i = 0;
        j = 0;
    }

    public static void a() {
        if (o.f2877a == false) goto L6;
        return;
    L6:
        if (f2859a == false) goto L8;
        return;
    L8:
        f2859a = true;
        f2860b = new AnonymousClass1();
        c = new AnonymousClass2();
        if (o.f2878b == true) goto L11;
    L19:
        b();
        return;
    L11:
        if (com.bytedance.apm.block.k.a(f2860b) == false) goto L19;
        if (com.bytedance.apm.b.k() == false) goto L16;
        Logger.i("LooperMonitor", "enable Looper Observer monitor.");
    L16:
        if (com.bytedance.apm.block.k.f1234a == false) goto L18;
        b();
    L18:
        com.bytedance.apm.block.k.a(c);
    }

    public static void a(com.bytedance.monitor.collector.a r0) {
        e = r0;
    }

    public static void a(a r2) {
        g = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
    }

    public static void a(boolean r0) {
        h = r0;
    }

    public static void a(boolean r10, String r11, Message r12) {
        long r1 = System.nanoTime();
        com.bytedance.monitor.collector.a.f2831b = r1 / TimeUtils.NANOSECONDS_PER_MILLISECOND;
        com.bytedance.monitor.collector.a.c = SystemClock.currentThreadTimeMillis();
        if (r10 == false) goto L9;
        com.bytedance.monitor.collector.a r3 = f;
        if (r3 == null) goto L9;
        if (r3.a() == false) goto L9;
        f.a(r11);
    L9:
        if (r10 == false) goto L57;
        com.bytedance.monitor.collector.a r4 = e;
        if (r4 == null) goto L57;
        if (r4.a() == false) goto L57;
        e.a(r11);
    L57:
        CopyOnWriteArrayList<com.bytedance.monitor.collector.a> r5 = d;     // Catch: Exception -> L56
        int r6 = 0;
    L17:
        if (r6 >= r5.size()) goto L35;
        com.bytedance.monitor.collector.a r7 = (com.bytedance.monitor.collector.a) ZeusTransformUtils.preCheckCast(r5.get(r6), com.bytedance.monitor.collector.a.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L56
        if (r7 != null) goto L22;
    L30:
        if (r10 == true) goto L34;
        if (r7.d == false) goto L34;
        r7.a("", null);     // Catch: Exception -> L56
    L34:
        r6 = r6 + 1;
        goto L17
    L22:
        if (r7.a() == false) goto L30;
        if (r10 == false) goto L28;
        if (r7.d == true) goto L34;
        r7.a(r11);     // Catch: Exception -> L56
        goto L34
    L28:
        if (r7.d == false) goto L34;
        r7.a(r11, r12);     // Catch: Exception -> L56
    L35:
        if (r10 == true) goto L41;
        com.bytedance.monitor.collector.a r13 = e;
        if (r13 == null) goto L41;
        if (r13.a() == false) goto L41;
        e.a("", null);
    L41:
        if (r10 == true) goto L48;
        com.bytedance.monitor.collector.a r14 = f;
        if (r14 == null) goto L48;
        if (r14.a() == false) goto L48;
        f.a("", null);
    L48:
        if (h == false) goto L67;
        i += System.nanoTime() - r1;
        int r15 = j;
        j = r15 + 1;
        if (r15 >= 1000) goto L52;
        return;
    L52:
        if (g == null) goto L54;
        g.a(i);
    L54:
        j = 0;
        i = 0;
        h = false;
        return;
    }

    public static void b() {
        com.bytedance.common.utility.e.a();
        com.bytedance.common.utility.e.a(f2860b);
    }

    public static void b(com.bytedance.monitor.collector.a r2) {
        CopyOnWriteArrayList<com.bytedance.monitor.collector.a> r0 = d;
        monitor-enter(r0);
        if (r2 != null) goto L15;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        if (r0.contains(r2) == true) goto L10;
        r0.add(r2);     // Catch: Throwable -> L12
        if (com.bytedance.apm.block.a.f.a().j() == false) goto L10;
        f();     // Catch: Throwable -> L12
        goto L10
    }

    public static void b(boolean r1) {
        if (f2859a == true) goto L5;
        return;
    L5:
        if (l == true) goto L7;
        return;
    L7:
        if (o.c == true) goto L10;
        return;
    L10:
        if (h() == false) goto L14;
        if (r1 == false) goto L14;
        return;
    L14:
        if (h() == false) goto L17;
        com.bytedance.apm.block.k.b();
    L20:
        if (com.bytedance.apm.b.k() == false) goto L22;
        Logger.i("LooperMonitor", "enable Looper Observer unblock.");
    L22:
        l = false;
        return;
    L17:
        if (m == null) goto L20;
        Looper.getMainLooper().setMessageLogging(m);
        goto L20
    }

    public static void c() {
        if (f2859a == false) goto L24;
        if (k == true) goto L24;
        if (f != null) goto L24;
        if (com.bytedance.apm.j.c.e(LogTypeName.MONITOR_TYPE_BLOCK) == false) goto L12;
        return;
    L12:
        if (Build.VERSION.SDK_INT < 24) goto L30;
        d();
        if (h() == true) goto L17;
        com.bytedance.common.utility.e.b(f2860b);
    L21:
        k = true;
        return;
    L17:
        if (com.bytedance.apm.b.k() == false) goto L19;
        Logger.i("LooperMonitor", "enable Looper Observer monitor.");
    L19:
        com.bytedance.apm.block.k.b(c);
        goto L21
    L30:
        return;
    L24:
        if (k == true) goto L26;
        return;
    L26:
        if (l == true) goto L32;
        d();
        return;
    }

    public static void c(com.bytedance.monitor.collector.a r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        CopyOnWriteArrayList<com.bytedance.monitor.collector.a> r0 = d;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L17
        if (com.bytedance.apm.block.a.f.a().j() == true) goto L9;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L9:
        if (r0.isEmpty() == false) goto L15;
        if (com.bytedance.apm.block.a.f.a().f() != 0) goto L15;
        if (f != null) goto L15;
        c();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static void d() {
        if (f2859a == true) goto L5;
        return;
    L5:
        if (l == false) goto L7;
        return;
    L7:
        if (o.c == true) goto L10;
        return;
    L10:
        if (h() == false) goto L18;
        List<com.bytedance.apm.block.j> r0 = com.bytedance.apm.block.k.c();
        if (r0 == null) goto L29;
        if (r0.size() != 1) goto L29;
        if (r0.get(0) != c) goto L29;
        com.bytedance.apm.block.k.a();
    L27:
        l = true;
    L29:
        if (com.bytedance.apm.b.k() == false) goto L34;
        Logger.i("LooperMonitor", "enable Looper Observer block.");
        return;
    L34:
        return;
    L18:
        List<Printer> r1 = com.bytedance.common.utility.e.b();
        if (r1 == null) goto L29;
        if (r1.size() != 1) goto L29;
        if (r1.get(0) != f2860b) goto L29;
        Printer r2 = i();
        m = r2;
        if (r2 == null) goto L29;
        Looper.getMainLooper().setMessageLogging(null);
        goto L27
    }

    public static int e() {
        return d.size();
    }

    public static void f() {
        if (f2859a == true) goto L5;
        return;
    L5:
        if (k == false) goto L17;
        b(false);
        if (h() == true) goto L10;
        b();
    L14:
        k = false;
        return;
    L10:
        if (com.bytedance.apm.b.k() == false) goto L12;
        Logger.i("LooperMonitor", "enable Looper Observer monitor.");
    L12:
        com.bytedance.apm.block.k.a(c);
        goto L14
    }

    public static void g() {
        if (f2859a == true) goto L5;
        return;
    L5:
        if (k == false) goto L8;
        return;
    L8:
        if (com.bytedance.apm.block.a.f.a().j() == true) goto L10;
        return;
    L10:
        int r0 = com.bytedance.apm.block.a.f.a().f();
        if (d.isEmpty() == false) goto L18;
        if (r0 == 0) goto L14;
        return;
    L14:
        if (f != null) goto L20;
        c();
        return;
    L20:
        return;
    }

    private static boolean h() {
        if (o.f2878b == true) goto L5;
    L9:
        return false;
    L5:
        if (com.bytedance.apm.block.k.a(f2860b) == false) goto L9;
        if (com.bytedance.apm.block.k.f1234a == true) goto L9;
        return true;
    }

    private static Printer i() {
        Field r1 = ZeusTransformUtils.forName("android.os.Looper", "com.obric.memorydata.plugin").getDeclaredField("mLogging");     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        return (Printer) ZeusTransformUtils.preCheckCast(r1.get(Looper.getMainLooper()), Printer.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }
}
