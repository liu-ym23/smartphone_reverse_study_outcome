package e8;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, Object> f7196a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, a<?>> f7197b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, b> f7198c = null;

    static {
        f7196a = new ConcurrentHashMap();
        f7197b = new ConcurrentHashMap();
        f7198c = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r8) {
        ConcurrentHashMap<Class, Object> r10 = f7196a;
        T r11 = (T) r10.get(r8);
        if (r11 != null) goto L36;
        monitor-enter(r8);
        T r12 = (T) r10.get(r8);
        if (r12 == null) goto L9;
        monitor-exit(r8);     // Catch: Throwable -> L33
        return r12;
    L9:
        ConcurrentHashMap<Class, a<?>> r13 = f7197b;     // Catch: Throwable -> L33
        a<?> r14 = r13.get(r8);     // Catch: Throwable -> L33
        if (r14 == null) goto L39;
        T r15 = (T) r14.a();
        r13.remove(r8);     // Catch: Throwable -> L33
        if (r15 == null) goto L39;
        r10.put(r8, r15);     // Catch: Throwable -> L33
        ConcurrentHashMap<Class, b> r16 = f7198c;     // Catch: Throwable -> L33
        b r17 = r16.get(r8);     // Catch: Throwable -> L33
        if (r17 == null) goto L16;
        r17.a();     // Catch: Throwable -> L33
        r16.remove(r8);     // Catch: Throwable -> L33
    L16:
        monitor-exit(r8);     // Catch: Throwable -> L33
        return r15;
    L39:
        Object r18 = Class.forName(String.format("%s__ServiceProxy", new Object[]{r8.getName()})).newInstance();     // Catch: Throwable -> L37
        if ((r18 instanceof IServiceProxy) == false) goto L23;
        Object r19 = ((IServiceProxy) r18).newInstance();     // Catch: Throwable -> L37
    L24:
        r11 = (T) r19;
        if (r11 == null) goto L31;
        f7196a.put(r8, r11);     // Catch: Throwable -> L33
        ConcurrentHashMap<Class, b> r20 = f7198c;     // Catch: Throwable -> L33
        b r21 = r20.get(r8);     // Catch: Throwable -> L33
        if (r21 == null) goto L29;
        r21.a();     // Catch: Throwable -> L33
        r20.remove(r8);     // Catch: Throwable -> L33
    L29:
        monitor-exit(r8);     // Catch: Throwable -> L33
        return r11;
    L31:
        monitor-exit(r8);     // Catch: Throwable -> L33
    L23:
        r19 = null;
    L33:
        th = move-exception;
        throw th;
    L36:
        return r11;
    }
}
