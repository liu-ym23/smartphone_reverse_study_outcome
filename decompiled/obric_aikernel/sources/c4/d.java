package c4;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f633a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, a<?>> f634b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, c> f635c = null;

    static {
        f633a = new ConcurrentHashMap();
        f634b = new ConcurrentHashMap();
        f635c = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r10) {
        ConcurrentHashMap<Class, Object> r11 = f633a;
        T r12 = (T) r11.get(r10);
        if (r12 != null) goto L33;
        monitor-enter(r10);
        T r13 = (T) r11.get(r10);
        if (r13 == null) goto L9;
        monitor-exit(r10);     // Catch: Throwable -> L30
        return r13;
    L9:
        ConcurrentHashMap<Class, a<?>> r14 = f634b;     // Catch: Throwable -> L30
        a<?> r15 = r14.get(r10);     // Catch: Throwable -> L30
        if (r15 == null) goto L35;
        T r16 = (T) r15.create();
        r14.remove(r10);     // Catch: Throwable -> L30
        if (r16 == null) goto L35;
        b(r10, r16);     // Catch: Throwable -> L30
        monitor-exit(r10);     // Catch: Throwable -> L30
        return r16;
    L35:
        T r17 = (T) b.a(r10);
        if (r17 == null) goto L23;
        b(r10, r17);     // Catch: Exception -> L21 Throwable -> L30
        monitor-exit(r10);     // Catch: Throwable -> L30
        return r17;
    L23:
        r12 = (T) e(r10);
        if (r12 == null) goto L28;
        b(r10, r12);     // Catch: Throwable -> L30
        monitor-exit(r10);     // Catch: Throwable -> L30
        return r12;
    L28:
        monitor-exit(r10);     // Catch: Throwable -> L30
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L33:
        return r12;
    }

    private static <T> void b(Class<T> r10, T r11) {
        f633a.put(r10, r11);
        ConcurrentHashMap<Class, c> r12 = f635c;
        c r13 = r12.get(r10);
        if (r13 == null) goto L6;
        r13.onServiceLoaded(r11);
        r12.remove(r10);
        return;
    }

    public static <T> void c(Class<T> r10, a<T> r11) {
        f634b.put(r10, r11);
    }

    public static <T> void d(Class<T> r10, T r11) {
        f633a.put(r10, r11);
    }

    private static <T> T e(Class<T> r10) {
        Object r11 = Class.forName(String.format("%s__ServiceProxy", new Object[]{r10.getName()})).newInstance();     // Catch: Throwable -> L9
        if ((r11 instanceof IServiceProxy) == false) goto L7;
        return (T) ((IServiceProxy) r11).newInstance();
    L7:
        return null;
    L12:
        return null;
    }
}
