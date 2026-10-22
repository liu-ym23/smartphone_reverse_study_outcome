package m3;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, Object> f9258a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, a<?>> f9259b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, b> f9260c = null;

    static {
        f9258a = new ConcurrentHashMap();
        f9259b = new ConcurrentHashMap();
        f9260c = new ConcurrentHashMap();
    }

    public c() {
    }

    public static <T> T a(Class<T> r8) {
        ConcurrentHashMap<Class, Object> r10 = f9258a;
        T r11 = (T) r10.get(r8);
        if (r11 == null) goto L5;
    L20:
        return r11;
    L5:
        monitor-enter(c.class);
        ConcurrentHashMap<Class, a<?>> r12 = f9259b;     // Catch: Throwable -> L17
        a<?> r13 = r12.get(r8);     // Catch: Throwable -> L17
        if (r13 == null) goto L15;
        r11 = (T) r13.a();
        r12.remove(r8);     // Catch: Throwable -> L17
        if (r11 == null) goto L15;
        r10.put(r8, r11);     // Catch: Throwable -> L17
        ConcurrentHashMap<Class, b> r14 = f9260c;     // Catch: Throwable -> L17
        b r15 = r14.get(r8);     // Catch: Throwable -> L17
        if (r15 == null) goto L13;
        r15.a();     // Catch: Throwable -> L17
        r14.remove(r8);     // Catch: Throwable -> L17
    L13:
        monitor-exit(c.class);     // Catch: Throwable -> L17
        return r11;
    L15:
        monitor-exit(c.class);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }
}
