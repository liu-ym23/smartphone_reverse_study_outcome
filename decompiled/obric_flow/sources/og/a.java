package og;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f20567a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f20568b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f20569c = null;

    static {
        f20567a = new ConcurrentHashMap();
        f20568b = new ConcurrentHashMap();
        f20569c = new ConcurrentHashMap();
    }

    public static Object a(Class r5) {
        ConcurrentHashMap r10 = f20567a;
        Object r11 = r10.get(r5);
        if (r11 == null) goto L5;
    L30:
        return r11;
    L5:
        monitor-enter(a.class);
    L24:
        th = move-exception;
        throw th;
    L7:
        if (f20568b.get(r5) != null) goto L27;
        monitor-exit(a.class);     // Catch: Throwable -> L24
        monitor-enter(r5);
        r11 = b(r5);     // Catch: Throwable -> L16
        if (r11 == null) goto L20;
        r10.put(r5, r11);     // Catch: Throwable -> L16
        if (f20569c.get(r5) != null) goto L19;
        monitor-exit(r5);     // Catch: Throwable -> L16
        return r11;
    L19:
        throw new ClassCastException();     // Catch: Throwable -> L16
    L20:
        monitor-exit(r5);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L27:
        throw new ClassCastException();     // Catch: Throwable -> L24
    }

    public static Object b(Class r5) {
        monitor-enter(r5);
        monitor-exit(r5);     // Catch: Throwable -> L20
        Object r10 = Class.forName(r5.getName().concat("__ServiceProxy")).newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11 ClassNotFoundException -> L13
        if ((r10 instanceof IServiceProxy) == false) goto L27;
        return ((IServiceProxy) r10).newInstance();
    L27:
        return null;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    L20:
        th = move-exception;
        throw th;
    }
}
