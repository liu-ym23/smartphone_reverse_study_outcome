package com.facebook.cache.disk;

/* JADX INFO: loaded from: classes2.dex */
public class SettableCacheEvent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f7640b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static SettableCacheEvent f7641c;
    public static int d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SettableCacheEvent f7642a;

    static {
        f7640b = new Object();
    }

    public SettableCacheEvent() {
    }

    public static SettableCacheEvent a() {
        Object r5 = f7640b;
        monitor-enter(r5);
        SettableCacheEvent r10 = f7641c;     // Catch: Throwable -> L9
        if (r10 == null) goto L11;
        f7641c = r10.f7642a;     // Catch: Throwable -> L9
        r10.f7642a = null;     // Catch: Throwable -> L9
        d--;     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r10;
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return new SettableCacheEvent();
    L9:
        th = move-exception;
        throw th;
    }

    public final void b() {
        Object r5 = f7640b;
        monitor-enter(r5);
        int r10 = d;     // Catch: Throwable -> L9
        if (r10 >= 5) goto L12;
        d = r10 + 1;     // Catch: Throwable -> L9
        SettableCacheEvent r11 = f7641c;     // Catch: Throwable -> L9
        if (r11 == null) goto L11;
        this.f7642a = r11;     // Catch: Throwable -> L9
    L11:
        f7641c = this;     // Catch: Throwable -> L9
    L12:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
