package com.lynx.tasm.base;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f10126b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f10127a;

    public static f a() {
        if (f10126b != null) goto L16;
        monitor-enter(f.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f10126b != null) goto L11;
        f r5 = new f();     // Catch: Throwable -> L9
        r5.f10127a = false;     // Catch: Throwable -> L9
        f10126b = r5;     // Catch: Throwable -> L9
    L11:
        monitor-exit(f.class);     // Catch: Throwable -> L9
    L16:
        return f10126b;
    }

    public void b() {
        if (this.f10127a == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Already released");
    }
}
