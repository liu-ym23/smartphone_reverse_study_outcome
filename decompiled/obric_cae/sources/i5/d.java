package i5;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, d> f8275b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class, Object> f8276a;

    static {
        f8275b = new ConcurrentHashMap();
    }

    public d() {
        this.f8276a = new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r8, String r10) {
        d r11 = f8275b.get(r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        return (T) r11.f8276a.get(r8);
    }

    public static <T> void b(Class<T> r8, T r10, String r11) {
        ConcurrentHashMap<String, d> r12 = f8275b;
        d r13 = r12.get(r11);
        if (r13 != null) goto L5;
        r13 = new d();
        r12.put(r11, r13);
    L5:
        r13.f8276a.put(r8, r10);
    }
}
