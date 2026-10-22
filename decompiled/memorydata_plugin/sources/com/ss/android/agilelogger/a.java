package com.ss.android.agilelogger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.alog.Alog;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.ss.android.agilelogger.utils.FormatUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f14994a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f14995b = 3;
    private static volatile boolean c = false;
    private static volatile Set<String> d = null;
    private static volatile boolean e = false;
    private static volatile c f;
    private static volatile List<d> g;
    private static ScheduledExecutorService h;
    private static Alog i;
    private static ArrayList<WeakReference<Alog>> j;
    private static ExecutorService k;
    private static HandlerThread l;
    private static Handler m;
    private static boolean n;
    private static Object o;
    private static final ThreadLocal<Long> p = null;

    /* JADX INFO: renamed from: com.ss.android.agilelogger.a$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14998a = null;

        static {
            int[] r0 = new int[FormatUtils.TYPE.values().length];
            f14998a = r0;
            r0[FormatUtils.TYPE.MSG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f14998a[FormatUtils.TYPE.STACKTRACE_STR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f14998a[FormatUtils.TYPE.BORDER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f14998a[FormatUtils.TYPE.JSON.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f14998a[FormatUtils.TYPE.BUNDLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f14998a[FormatUtils.TYPE.INTENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f14998a[FormatUtils.TYPE.THROWABLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f14998a[FormatUtils.TYPE.THREAD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f14998a[FormatUtils.TYPE.STACKTRACE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.agilelogger.a$a, reason: collision with other inner class name */
    private static class C0804a {
        private static final Object j = null;
        private static C0804a k;
        private static int l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f15006b;
        public String c;
        public Throwable d;
        public FormatUtils.TYPE e;
        public Object f;
        public long g;
        public long h;
        public C0804a i;

        static {
            j = new Object();
        }

        private C0804a() {
            this.e = null;
        }

        public static C0804a a() {
            Object r0 = j;
            monitor-enter(r0);
            C0804a r1 = k;     // Catch: Throwable -> L12
            if (r1 == null) goto L9;
            k = r1.i;     // Catch: Throwable -> L12
            r1.i = null;     // Catch: Throwable -> L12
            l--;     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return new C0804a();
        L12:
            th = move-exception;
            throw th;
        }

        public void b() {
            this.f15006b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = -1;
            this.h = 0;
            this.i = null;
            Object r0 = j;
            monitor-enter(r0);
            int r1 = l;     // Catch: Throwable -> L9
            if (r1 >= 50) goto L7;
            this.i = k;     // Catch: Throwable -> L9
            k = this;     // Catch: Throwable -> L9
            l = r1 + 1;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    static {
        g = new ArrayList();
        h = null;
        i = null;
        j = new ArrayList();
        k = null;
        n = false;
        o = new Object();
        p = new AnonymousClass1();
    }

    static /* synthetic */ int a(int r0) {
        return b(r0);
    }

    public static List<String> a(long r7, long r9) {
        ArrayList r0 = new ArrayList();
        File[] r8 = com.bytedance.android.alog.d.a(null, null, r7 * 1000, r9 * 1000);     // Catch: Exception -> L8
        int r10 = r8.length;     // Catch: Exception -> L8
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L7;
        r0.add(r8[r11].getAbsolutePath());     // Catch: Exception -> L8
        r11 = r11 + 1;
    L7:
        return r0;
    }

    private static void a(int r6, String r7, String r8) {
        a(r6, r7, r8, null, null, null);
    }

    private static void a(final int r13, final String r14, final String r15, final Throwable r16, final FormatUtils.TYPE r17, final Object r18) {
        final long r7 = g();
        final long r9 = System.currentTimeMillis();
        k.execute(new AnonymousClass3(r13, r17, r16, r15, r18, r14, r7, r9));
    }

    public static void a(com.bytedance.android.alog.c r2) {
        Alog.a((com.bytedance.android.alog.c) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.android.alog.c.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(C0804a r0) {
        b(r0);
    }

    public static void a(c r2) {
        f = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
    }

    public static void a(d r2) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
        g.add(r3);
    }

    private static void a(f r4) {
        switch(AnonymousClass4.f14998a[r4.e.ordinal()]) {
            case 1: goto L15;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        String r0 = "";
    L16:
        r4.d = r0;
        return;
    L5:
        r0 = FormatUtils.a(r4.e, (StackTraceElement[]) ZeusTransformUtils.preCheckCast((StackTraceElement[]) ZeusTransformUtils.preCheckCast(r4.f, StackTraceElement[].class, "com.obric.memorydata.plugin"), StackTraceElement[].class, "com.obric.memorydata.plugin"));
        goto L16
    L6:
        r0 = FormatUtils.a(r4.e, (Thread) ZeusTransformUtils.preCheckCast(r4.f, Thread.class, "com.obric.memorydata.plugin"));
        goto L16
    L7:
        r0 = FormatUtils.a(r4.e, (Throwable) ZeusTransformUtils.preCheckCast(r4.f, Throwable.class, "com.obric.memorydata.plugin"));
        goto L16
    L8:
        r0 = FormatUtils.a(r4.e, (Intent) ZeusTransformUtils.preCheckCast(r4.f, Intent.class, "com.obric.memorydata.plugin"));
        goto L16
    L9:
        r0 = FormatUtils.a(r4.e, (Bundle) ZeusTransformUtils.preCheckCast(r4.f, Bundle.class, "com.obric.memorydata.plugin"));
        goto L16
    L10:
        r0 = FormatUtils.a(r4.e, (String) ZeusTransformUtils.preCheckCast(r4.f, String.class, "com.obric.memorydata.plugin"));
        goto L16
    L15:
        r0 = (String) ZeusTransformUtils.preCheckCast(r4.f, String.class, "com.obric.memorydata.plugin");
        goto L16
    L12:
        if (r4.g != null) goto L14;
        r0 = com.ss.android.agilelogger.utils.c.a((Throwable) ZeusTransformUtils.preCheckCast(r4.f, Throwable.class, "com.obric.memorydata.plugin"));
        goto L16
    L14:
        r0 = r4.g + com.ss.android.agilelogger.utils.c.a((Throwable) ZeusTransformUtils.preCheckCast(r4.f, Throwable.class, "com.obric.memorydata.plugin"));
        goto L16
    }

    public static void a(String r3, String r4) {
        if (a(2, r3) == false) goto L37;
        b r1 = f14994a;
        if (r1 != null) goto L7;
    L12:
        b r2 = f14994a;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = g.a();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = i;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.a(r3, r4);
        return;
    L35:
        com.bytedance.android.alog.d.a(r3, r4);
        return;
    L28:
        if (m == null) goto L31;
        b(2, r3, r4);
        return;
    L23:
        if (k == null) goto L26;
        a(2, r3, r4);
        return;
    L15:
        if (r2.n() == false) goto L20;
        if (m == null) goto L20;
        b(2, r3, r4);
        return;
    L7:
        if (r1.n() == false) goto L12;
        if (k == null) goto L12;
        a(2, r3, r4);
        return;
    }

    public static void a(String r8, String r9, Throwable r10) {
        if (a(5, r8) == false) goto L37;
        b r0 = f14994a;
        if (r0 != null) goto L7;
    L12:
        b r1 = f14994a;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = g.a();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        String r11 = r9 + "\n" + com.ss.android.agilelogger.utils.c.a(r10);
        Alog r12 = i;
        if (r12 == null) goto L35;
        if (r2 == false) goto L35;
        r12.d(r8, r11);
        return;
    L35:
        com.bytedance.android.alog.d.d(r8, r11);
        return;
    L28:
        if (m == null) goto L31;
        b(5, r8, r9, r10, null, null);
        return;
    L23:
        if (k == null) goto L26;
        a(5, r8, r9, r10, null, null);
        return;
    L15:
        if (r1.n() == false) goto L20;
        if (m == null) goto L20;
        b(5, r8, r9, r10, null, null);
        return;
    L7:
        if (r0.n() == false) goto L12;
        if (k == null) goto L12;
        a(5, r8, r9, r10, null, null);
        return;
    }

    static /* synthetic */ void a(Queue r2) {
        b((Queue) ZeusTransformUtils.wrapperContextForParams(r2, Queue.class, "com.obric.memorydata.plugin"));
    }

    public static void a(boolean r1) {
        c = r1;
        com.bytedance.android.alog.d.a(c);
        Alog r2 = i;
        if (r2 == null) goto L6;
        r2.a(c);
        return;
    }

    public static boolean a() {
        return e;
    }

    public static boolean a(int r2, String r3) {
        if (r2 >= f14995b) goto L5;
        return false;
    L5:
        Set<String> r4 = d;
        if (r4 != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return true;
    L10:
        if (r4.contains(r3) == false) goto L15;
        return false;
    L15:
        return true;
    }

    public static boolean a(b r11) {
        boolean r0 = false;
        if (r11 != null) goto L5;
        return false;
    L5:
        f14994a = r11;
        Alog.a(new e());     // Catch: Throwable -> L95
        Object r1 = o;
        monitor-enter(r1);
    L92:
        th = move-exception;
        throw th;
    L10:
        if (n == false) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L92
        return false;
    L13:
        n = true;     // Catch: Throwable -> L92
        monitor-exit(r1);     // Catch: Throwable -> L92
        f14995b = r11.i();
        boolean r2 = g.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        boolean r3 = r11.l();
        if (r3 == false) goto L18;
    L21:
        boolean r4 = false;
    L22:
        boolean r5 = r11.m();
        boolean r6 = r11.p();
        if (r2 == true) goto L25;
        r11.b((int) (r11.b() * r11.c()));
    L25:
        Alog.a r7 = new Alog.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a("default").a(b(r11.i())).a(c).b(r11.f()).b(r11.d());
        int r8 = r11.b();
        if (r4 == false) goto L28;
        r8 = (r8 / 3) * 2;
    L28:
        Alog.a r9 = r7.c(r8).d(r11.a()).c(r11.e());
        if (r2 == false) goto L31;
        int r10 = r11.q() * 1024;
    L32:
        Alog.a r12 = r9.e(r10);
        if (r2 == false) goto L35;
        int r13 = (r11.q() * 3) * 1024;
    L36:
        Alog.a r14 = r12.f(r13).a(Alog.Mode.SAFE).a(Alog.TimeFormat.RAW).a(Alog.PrefixFormat.LEGACY);
        if (r11.g() == false) goto L39;
        Alog.Compress r15 = Alog.Compress.ZSTD;
    L40:
        Alog.a r16 = r14.a(r15);
        if (r11.h() == false) goto L43;
        Alog.SymCrypt r17 = Alog.SymCrypt.TEA_16;
    L44:
        Alog.a r18 = r16.a(r17);
        if (r11.h() == false) goto L47;
        Alog.AsymCrypt r19 = Alog.AsymCrypt.EC_SECP256K1;
    L48:
        com.bytedance.android.alog.d.a(r18.a(r19).d(r11.j()).b(r11.o()).a());
        if (r3 == false) goto L55;
        if (r5 == true) goto L52;
        if (r2 == false) goto L55;
    L52:
        if (r6 == false) goto L54;
        k = Executors.newSingleThreadExecutor(new AnonymousClass5());
        goto L55
    L54:
        HandlerThread r20 = new HandlerThread("Alog_main_delegate");
        l = r20;
        r20.start();
        final Looper r21 = l.getLooper();
        m = new AnonymousClass6(r21);
    L55:
        if (r4 == false) goto L69;
        Alog.a r22 = new Alog.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a("main").a(b(r11.i())).a(c).b(r11.f()).b(r11.d() / 2).c(r11.b() / 3).d(r11.a()).c(r11.e()).e(32768).f(98304).a(Alog.Mode.SAFE).a(Alog.TimeFormat.RAW).a(Alog.PrefixFormat.LEGACY);
        if (r11.g() == false) goto L59;
        Alog.Compress r23 = Alog.Compress.ZSTD;
    L60:
        Alog.a r24 = r22.a(r23);
        if (r11.h() == false) goto L63;
        Alog.SymCrypt r25 = Alog.SymCrypt.TEA_16;
    L64:
        Alog.a r26 = r24.a(r25);
        if (r11.h() == false) goto L67;
        Alog.AsymCrypt r27 = Alog.AsymCrypt.EC_SECP256K1;
    L68:
        i = r26.a(r27).d(r11.j()).b(r11.o()).a();
        goto L69
    L67:
        r27 = Alog.AsymCrypt.NONE;
        goto L68
    L63:
        r25 = Alog.SymCrypt.NONE;
        goto L64
    L59:
        r23 = Alog.Compress.NONE;
    L69:
        final String r28 = r11.e();
        final String r110 = r11.f();
        final Queue<f> r29 = null;
        if (f == null) goto L77;
        Queue<f> r30 = f.a();
        if (r30 != null) goto L74;
    L76:
        r29 = r30;
        goto L77
    L74:
        if (r30.size() != 0) goto L76;
    L77:
        if (r29 == null) goto L79;
    L80:
        Runnable r31 = new AnonymousClass7(r29, r28, r110);
        ScheduledExecutorService r32 = h;
        if (r32 != null) goto L83;
        new Thread(r31, "_ALOG_OPT_").start();
    L84:
        r0 = true;
    L85:
        if (r0 == true) goto L90;
        ScheduledExecutorService r33 = h;
        if (r33 != null) goto L89;
        new Timer("_ALOG_OPT_").schedule(new AnonymousClass8(r28, r110), SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME);
        goto L90
    L89:
        r33.schedule(new AnonymousClass9(r28, r110), 15, TimeUnit.SECONDS);
    L90:
        e = true;
        return true;
    L83:
        r32.execute(r31);
        goto L84
    L79:
        if (b().size() <= 0) goto L85;
    L47:
        r19 = Alog.AsymCrypt.NONE;
        goto L48
    L43:
        r17 = Alog.SymCrypt.NONE;
        goto L44
    L39:
        r15 = Alog.Compress.NONE;
        goto L40
    L35:
        r13 = 65536;
        goto L36
    L31:
        r10 = 32768;
        goto L32
    L18:
        if (r11.k() == false) goto L21;
        if (r2 == false) goto L21;
        r4 = true;
    L95:
        return false;
    }

    private static int b(int r0) {
        return r0 - 2;
    }

    public static List<d> b() {
        return g;
    }

    private static void b(int r6, String r7, String r8) {
        b(r6, r7, r8, null, null, null);
    }

    private static void b(int r1, String r2, String r3, Throwable r4, FormatUtils.TYPE r5, Object r6) {
        C0804a r0 = C0804a.a();
        r0.f15005a = r1;
        r0.f15006b = r2;
        r0.c = r3;
        r0.d = r4;
        r0.e = r5;
        r0.f = r6;
        r0.g = g();
        r0.h = System.currentTimeMillis();
        Message r7 = Message.obtain();
        r7.what = 1;
        r7.obj = r0;
        m.sendMessage(r7);
    }

    private static void b(C0804a r8) {
        int r1 = b(r8.f15005a);
        String r2 = "";
        if (r8.e != null) goto L13;
        if (r8.d != null) goto L8;
        String r0 = r8.c;
    L16:
        String r3 = r0;
    L36:
        com.bytedance.android.alog.d.a(r1, r8.f15006b, r3, r8.g, r8.h);
        r8.b();
        return;
    L8:
        if (r8.c == null) goto L11;
        r2 = r8.c + "\n";
    L11:
        r0 = r2 + com.ss.android.agilelogger.utils.c.a(r8.d);
        goto L16
    L13:
        if (r8.e != FormatUtils.TYPE.BORDER) goto L18;
        FormatUtils.TYPE r4 = FormatUtils.TYPE.BORDER;
    L15:
        r0 = FormatUtils.a(r4, r8.c);
        goto L16
    L18:
        if (r8.e != FormatUtils.TYPE.JSON) goto L21;
        r4 = FormatUtils.TYPE.JSON;
        goto L15
    L21:
        if (r8.e != FormatUtils.TYPE.BUNDLE) goto L24;
        r0 = FormatUtils.a(FormatUtils.TYPE.BUNDLE, (Bundle) ZeusTransformUtils.preCheckCast(r8.f, Bundle.class, "com.obric.memorydata.plugin"));
        goto L16
    L24:
        if (r8.e != FormatUtils.TYPE.INTENT) goto L27;
        r0 = FormatUtils.a(FormatUtils.TYPE.INTENT, (Intent) ZeusTransformUtils.preCheckCast(r8.f, Intent.class, "com.obric.memorydata.plugin"));
        goto L16
    L27:
        if (r8.e != FormatUtils.TYPE.THROWABLE) goto L30;
        r0 = FormatUtils.a(FormatUtils.TYPE.THROWABLE, (Throwable) ZeusTransformUtils.preCheckCast(r8.f, Throwable.class, "com.obric.memorydata.plugin"));
        goto L16
    L30:
        if (r8.e != FormatUtils.TYPE.THREAD) goto L33;
        r0 = FormatUtils.a(FormatUtils.TYPE.THREAD, (Thread) ZeusTransformUtils.preCheckCast(r8.f, Thread.class, "com.obric.memorydata.plugin"));
        goto L16
    L33:
        if (r8.e != FormatUtils.TYPE.STACKTRACE) goto L35;
        r0 = FormatUtils.a(FormatUtils.TYPE.STACKTRACE, (StackTraceElement[]) ZeusTransformUtils.preCheckCast((StackTraceElement[]) ZeusTransformUtils.preCheckCast(r8.f, StackTraceElement[].class, "com.obric.memorydata.plugin"), StackTraceElement[].class, "com.obric.memorydata.plugin"));
        goto L16
    L35:
        r3 = "";
        goto L36
    }

    public static void b(String r3, String r4) {
        if (a(3, r3) == false) goto L37;
        b r1 = f14994a;
        if (r1 != null) goto L7;
    L12:
        b r2 = f14994a;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = g.a();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = i;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.b(r3, r4);
        return;
    L35:
        com.bytedance.android.alog.d.b(r3, r4);
        return;
    L28:
        if (m == null) goto L31;
        b(3, r3, r4);
        return;
    L23:
        if (k == null) goto L26;
        a(3, r3, r4);
        return;
    L15:
        if (r2.n() == false) goto L20;
        if (m == null) goto L20;
        b(3, r3, r4);
        return;
    L7:
        if (r1.n() == false) goto L12;
        if (k == null) goto L12;
        a(3, r3, r4);
        return;
    }

    public static void b(String r8, String r9, Throwable r10) {
        if (a(6, r8) == false) goto L37;
        b r0 = f14994a;
        if (r0 != null) goto L7;
    L12:
        b r1 = f14994a;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = g.a();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        String r11 = r9 + "\n" + com.ss.android.agilelogger.utils.c.a(r10);
        Alog r12 = i;
        if (r12 == null) goto L35;
        if (r2 == false) goto L35;
        r12.e(r8, r11);
        return;
    L35:
        com.bytedance.android.alog.d.e(r8, r11);
        return;
    L28:
        if (m == null) goto L31;
        b(6, r8, r9, r10, null, null);
        return;
    L23:
        if (k == null) goto L26;
        a(6, r8, r9, r10, null, null);
        return;
    L15:
        if (r1.n() == false) goto L20;
        if (m == null) goto L20;
        b(6, r8, r9, r10, null, null);
        return;
    L7:
        if (r0.n() == false) goto L12;
        if (k == null) goto L12;
        a(6, r8, r9, r10, null, null);
        return;
    }

    private static void b(Queue<f> r4) {
        Iterator r5 = ((Queue) ZeusTransformUtils.wrapperContextForParams(r4, Queue.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r5.next(), f.class, "com.obric.memorydata.plugin");
        if (a(r0.f15012b, r0.c) == false) goto L4;
        a(r0);
        com.bytedance.android.alog.d.b(b(r0.f15012b), r0.c, r0.d);
        goto L4
    }

    public static void c() {
        ExecutorService r0 = k;
        if (r0 == null) goto L5;
        r0.execute(new AnonymousClass12());
    L8:
        com.bytedance.android.alog.d.a();
        Alog r1 = i;
        if (r1 == null) goto L11;
        r1.b();
    L11:
        Iterator<WeakReference<Alog>> r2 = j.iterator();
    L13:
        if (r2.hasNext() == false) goto L20;
        WeakReference r3 = (WeakReference) ZeusTransformUtils.preCheckCast(r2.next(), WeakReference.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L13;
        Alog r4 = (Alog) ZeusTransformUtils.preCheckCast(r3.get(), Alog.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        r4.b();
        goto L13
    L20:
        return;
    L5:
        Handler r5 = m;
        if (r5 == null) goto L8;
        r5.sendEmptyMessage(2);
        goto L8
    }

    public static void c(String r3, String r4) {
        if (a(4, r3) == false) goto L37;
        b r1 = f14994a;
        if (r1 != null) goto L7;
    L12:
        b r2 = f14994a;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = g.a();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = i;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.c(r3, r4);
        return;
    L35:
        com.bytedance.android.alog.d.c(r3, r4);
        return;
    L28:
        if (m == null) goto L31;
        b(4, r3, r4);
        return;
    L23:
        if (k == null) goto L26;
        a(4, r3, r4);
        return;
    L15:
        if (r2.n() == false) goto L20;
        if (m == null) goto L20;
        b(4, r3, r4);
        return;
    L7:
        if (r1.n() == false) goto L12;
        if (k == null) goto L12;
        a(4, r3, r4);
        return;
    }

    public static void d() {
        ExecutorService r0 = k;
        if (r0 == null) goto L5;
        r0.execute(new AnonymousClass2());
    L5:
        Handler r1 = m;
        if (r1 == null) goto L8;
        r1.sendEmptyMessage(2);
    L8:
        com.bytedance.android.alog.d.b();
        Alog r2 = i;
        if (r2 == null) goto L11;
        r2.c();
    L11:
        Iterator<WeakReference<Alog>> r3 = j.iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        Alog r4 = (Alog) ZeusTransformUtils.preCheckCast(((WeakReference) ZeusTransformUtils.preCheckCast(r3.next(), WeakReference.class, "com.obric.memorydata.plugin")).get(), Alog.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        r4.c();
        goto L13
    }

    public static void d(String r3, String r4) {
        if (a(5, r3) == false) goto L37;
        b r1 = f14994a;
        if (r1 != null) goto L7;
    L12:
        b r2 = f14994a;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = g.a();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = i;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.d(r3, r4);
        return;
    L35:
        com.bytedance.android.alog.d.d(r3, r4);
        return;
    L28:
        if (m == null) goto L31;
        b(5, r3, r4);
        return;
    L23:
        if (k == null) goto L26;
        a(5, r3, r4);
        return;
    L15:
        if (r2.n() == false) goto L20;
        if (m == null) goto L20;
        b(5, r3, r4);
        return;
    L7:
        if (r1.n() == false) goto L12;
        if (k == null) goto L12;
        a(5, r3, r4);
        return;
    }

    public static long e() {
        return com.bytedance.android.alog.d.c();
    }

    public static void e(String r3, String r4) {
        if (a(6, r3) == false) goto L37;
        b r1 = f14994a;
        if (r1 != null) goto L7;
    L12:
        b r2 = f14994a;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = g.a();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = i;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.e(r3, r4);
        return;
    L35:
        com.bytedance.android.alog.d.e(r3, r4);
        return;
    L28:
        if (m == null) goto L31;
        b(6, r3, r4);
        return;
    L23:
        if (k == null) goto L26;
        a(6, r3, r4);
        return;
    L15:
        if (r2.n() == false) goto L20;
        if (m == null) goto L20;
        b(6, r3, r4);
        return;
    L7:
        if (r1.n() == false) goto L12;
        if (k == null) goto L12;
        a(6, r3, r4);
        return;
    }

    static /* synthetic */ c f() {
        return f;
    }

    static /* synthetic */ void f(String r0, String r1) {
        g(r0, r1);
    }

    private static long g() {
        return ((Long) ZeusTransformUtils.preCheckCast(p.get(), Long.class, "com.obric.memorydata.plugin")).longValue();
    }

    private static void g(String r4, String r5) {
        File r0 = new File(r4);
        int r1 = 0;
        if (r0.exists() == false) goto L9;
        File[] r6 = r0.listFiles(new AnonymousClass10());
        if (r6 == null) goto L9;
        int r2 = r6.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        r6[r3].delete();
        r3 = r3 + 1;
    L9:
        File r7 = new File(r5);
        if (r7.exists() == false) goto L16;
        File[] r8 = r7.listFiles(new AnonymousClass11());
        if (r8 == null) goto L19;
        int r9 = r8.length;
    L14:
        if (r1 >= r9) goto L20;
        r8[r1].delete();
        r1 = r1 + 1;
        goto L14
    L20:
        return;
    L19:
        return;
    }
}
