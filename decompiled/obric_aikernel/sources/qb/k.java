package qb;

import androidx.annotation.Nullable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f12499a = "k";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f12500b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f12501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f12502d;

    static {
        f12500b = new ConcurrentHashMap();
        f12501c = null;
        f12502d = false;
    }

    public k() {
    }

    @Nullable
    public static <T> T a(Class<T> r10) {
        if (f12502d == true) goto L6;
        b("com.ss.android.socialbase.downloader.service.DownloadServiceLoader");
    L6:
        return (T) f12500b.get(r10);
    }

    private static void b(String r10) {
        monitor-enter(k.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f12502d == false) goto L9;
        monitor-exit(k.class);     // Catch: Throwable -> L16
        return;
    L9:
        if (e(r10) == false) goto L13;
        f12502d = true;     // Catch: Throwable -> L16
        monitor-exit(k.class);     // Catch: Throwable -> L16
        return;
    L13:
        d(o.class, new o.a());     // Catch: Throwable -> L16
        d(n.class, new n.a());     // Catch: Throwable -> L16
        d(l.class, new l.a());     // Catch: Throwable -> L16
        d(t.class, new t.a());     // Catch: Throwable -> L16
        d(q.class, new q.a());     // Catch: Throwable -> L16
        d(s.class, new s.a());     // Catch: Throwable -> L16
        d(r.class, new r.a());     // Catch: Throwable -> L16
        d(u.class, new u.a());     // Catch: Throwable -> L16
        d(p.class, new p.a());     // Catch: Throwable -> L16
        d(m.class, new m.a());     // Catch: Throwable -> L16
        lb.a.c(f12499a, "loadDefaultService", "Run");     // Catch: Throwable -> L16
        f12502d = true;     // Catch: Throwable -> L16
        monitor-exit(k.class);     // Catch: Throwable -> L16
    }

    public static void c(jb.p r10) {
        if (r10 == null) goto L9;
        r10.load();
        String r11 = f12501c;
        if (r11 != null) goto L6;
        boolean r12 = true;
    L7:
        r10.defaultLoadCallback(r12, r11);
        return;
    L6:
        r12 = false;
        goto L7
    }

    public static <T> void d(Class<T> r10, T r11) {
        f12500b.put(r10, r11);
    }

    protected static boolean e(String r10) {
        Class<?> r11 = Class.forName(r10);     // Catch: Throwable -> L8
        r11.getMethod("load", new Class[0]).invoke(r11.newInstance(), new Object[0]);     // Catch: Throwable -> L8
        if (lb.a.a() == false) goto L13;
        lb.a.b(f12499a, "runLoad", "Run load :" + r10 + " success");     // Catch: Throwable -> L8
        return true;
    L13:
        return true;
    L8:
        th = move-exception;
        f12501c = th.toString();
        lb.a.c(f12499a, "runLoad", "Run load :" + r10 + "fail, " + th.toString());
        th.printStackTrace();
        return false;
    }

    public static void f() {
        f12502d = true;
    }
}
