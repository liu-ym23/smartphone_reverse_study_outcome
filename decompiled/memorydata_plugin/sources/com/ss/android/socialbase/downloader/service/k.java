package com.ss.android.socialbase.downloader.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15646a = "k";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f15647b = null;
    private static String c;
    private static volatile boolean d;

    static {
        f15647b = new ConcurrentHashMap();
        c = null;
        d = false;
    }

    public k() {
    }

    public static <T> T a(Class<T> r1) {
        if (d == true) goto L6;
        b("com.ss.android.socialbase.downloader.service.DownloadServiceLoader");
    L6:
        return (T) f15647b.get(r1);
    }

    public static void a() {
        d = true;
    }

    public static void a(com.ss.android.socialbase.downloader.downloader.o r2) {
        com.ss.android.socialbase.downloader.downloader.o r3 = (com.ss.android.socialbase.downloader.downloader.o) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.downloader.o.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        r3.load();
        String r0 = c;
        if (r0 != null) goto L7;
        boolean r1 = true;
    L8:
        r3.defaultLoadCallback(r1, r0);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public static <T> void a(Class<T> r1, T r2) {
        f15647b.put(r1, r2);
    }

    public static boolean a(String r6) {
        Class r3 = ZeusTransformUtils.forName(r6, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        r3.getMethod("load", new Class[0]).invoke(r3.newInstance(), new Object[0]);     // Catch: Throwable -> L8
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L13;
        com.ss.android.socialbase.downloader.e.a.a(f15646a, "runLoad", "Run load :" + r6 + " success");     // Catch: Throwable -> L8
        return true;
    L13:
        return true;
    L8:
        th = move-exception;
        c = th.toString();
        com.ss.android.socialbase.downloader.e.a.b(f15646a, "runLoad", "Run load :" + r6 + "fail, " + th.toString());
        th.printStackTrace();
        return false;
    }

    private static void b(String r4) {
        monitor-enter(k.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (d == false) goto L9;
        monitor-exit(k.class);     // Catch: Throwable -> L16
        return;
    L9:
        if (a(r4) == false) goto L13;
        d = true;     // Catch: Throwable -> L16
        monitor-exit(k.class);     // Catch: Throwable -> L16
        return;
    L13:
        a(o.class, new o.a());     // Catch: Throwable -> L16
        a(n.class, new n.a());     // Catch: Throwable -> L16
        a(l.class, new l.a());     // Catch: Throwable -> L16
        a(t.class, new t.a());     // Catch: Throwable -> L16
        a(q.class, new q.a());     // Catch: Throwable -> L16
        a(s.class, new s.a());     // Catch: Throwable -> L16
        a(r.class, new r.a());     // Catch: Throwable -> L16
        a(u.class, new u.a());     // Catch: Throwable -> L16
        a(p.class, new p.a());     // Catch: Throwable -> L16
        a(m.class, new m.a());     // Catch: Throwable -> L16
        com.ss.android.socialbase.downloader.e.a.b(f15646a, "loadDefaultService", "Run");     // Catch: Throwable -> L16
        d = true;     // Catch: Throwable -> L16
        monitor-exit(k.class);     // Catch: Throwable -> L16
    }
}
