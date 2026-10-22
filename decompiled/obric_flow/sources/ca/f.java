package ca;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static volatile f d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a6.a f1160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicBoolean f1161c;

    public static f a() {
        if (d != null) goto L16;
        monitor-enter(f.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L11;
        f r5 = new f();     // Catch: Throwable -> L9
        r5.f1160b = new a6.a(r5, 14);     // Catch: Throwable -> L9
        r5.f1159a = 30000;     // Catch: Throwable -> L9
        r5.f1161c = new AtomicBoolean(false);     // Catch: Throwable -> L9
        d = r5;     // Catch: Throwable -> L9
    L11:
        monitor-exit(f.class);     // Catch: Throwable -> L9
    L16:
        return d;
    }
}
