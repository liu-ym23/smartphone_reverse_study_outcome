package r7;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f21696a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f21697b = null;

    static {
        f21696a = new ConcurrentHashMap();
        f21697b = new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public static Object a(Class r5) {
        Object r10 = f21696a.get(r5);
        if (r10 == null) goto L5;
    L16:
        return r10;
    L5:
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (f21697b.get(r5) != null) goto L13;
        monitor-exit(a.class);     // Catch: Throwable -> L10
        goto L16
    L13:
        throw new ClassCastException();     // Catch: Throwable -> L10
    }
}
