package com.bytedance.dataplatform;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Map<String, Object> f2258a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static k f2259b;
    private static volatile c c;
    private static volatile Future d;
    private static volatile boolean e;
    private static volatile boolean f;
    private static volatile boolean g;
    private static String h;
    private static Object i;
    private static g j;
    private static Map<String, String> k;
    private static Set<String> l;
    private static boolean m;
    private static boolean n;
    private static final Map<String, String> o = null;

    static {
        f2258a = new ConcurrentHashMap();
        e = false;
        f = false;
        g = false;
        i = new Object();
        k = new ConcurrentHashMap();
        l = new ConcurrentSkipListSet();
        m = false;
        n = false;
        o = new ConcurrentHashMap();
    }

    static /* synthetic */ c a(c r0) {
        c = r0;
        return r0;
    }

    public static g a() {
        return j;
    }

    static /* synthetic */ k a(k r2) {
        k r3 = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin");
        f2259b = r3;
        return r3;
    }

    public static void a(Application r8, final String r9, final boolean r10, k r11, j r12, h r13, i r14) {
        final Application r1 = (Application) ZeusTransformUtils.wrapperContextForParams(r8, Application.class, "com.obric.memorydata.plugin");
        final k r7 = (k) ZeusTransformUtils.wrapperContextForParams(r11, k.class, "com.obric.memorydata.plugin");
        final j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r12, j.class, "com.obric.memorydata.plugin");
        final h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r13, h.class, "com.obric.memorydata.plugin");
        final i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r14, i.class, "com.obric.memorydata.plugin");
        b.f2250b.a(r1);
        if (e == true) goto L15;
        Object r15 = i;
        monitor-enter(r15);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (e == true) goto L9;
        d = l.a(new AnonymousClass1(r1, r9, r10, r4, r5, r6, r7));     // Catch: Throwable -> L12
        e = true;     // Catch: Throwable -> L12
        f = true;     // Catch: Throwable -> L12
    L9:
        i.notifyAll();     // Catch: Throwable -> L12
        monitor-exit(r15);     // Catch: Throwable -> L12
        return;
    L15:
        if (r7 == null) goto L21;
        f2259b = r7;
        e.a(r1, r7, r4, c);
        return;
    }

    public static void a(com.bytedance.dataplatform.a.b r2, boolean r3, boolean r4) {
        com.bytedance.dataplatform.a.a.a((com.bytedance.dataplatform.a.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.dataplatform.a.b.class, "com.obric.memorydata.plugin"), r3, r4);
    }

    public static void a(g r2) {
        j = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
    }

    public static void a(String r1) {
        if (g == false) goto L5;
        c.a(r1);
        return;
    L5:
        h = r1;
    }

    static /* synthetic */ boolean a(boolean r0) {
        g = r0;
        return r0;
    }

    public static void b() {
        m = true;
    }

    public static void c() {
        h();
        c.a(null);
    }

    static /* synthetic */ Map d() {
        return k;
    }

    static /* synthetic */ Set e() {
        return l;
    }

    static /* synthetic */ c f() {
        return c;
    }

    static /* synthetic */ String g() {
        return h;
    }

    private static void h() {
        if ((e | f) == true) goto L18;
        if (m == false) goto L18;
        Object r0 = i;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L10:
        if ((e | f) == false) goto L29;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        goto L18
    L29:
        i.wait(10000);     // Catch: InterruptedException -> L26 Throwable -> L14
    L18:
        if (d == null) goto L25;
        d.get();     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        throw new RuntimeException(e);
    L25:
        throw new RuntimeException("ExperimentManager has not been init");
    }
}
