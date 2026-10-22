package wd;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile b f13099d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f13100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f13101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13102c;

    public b() {
        this.f13100a = new AtomicBoolean(false);
        this.f13101b = new AtomicBoolean(false);
        this.f13102c = -999;
    }

    public static b c() {
        if (f13099d != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f13099d != null) goto L9;
        f13099d = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f13099d;
    }

    public final void a(a r8) {
        if (b() == true) goto L6;
        return;
    L6:
        throw null;
    }

    public final boolean b() {
        if (this.f13101b.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f13100a.get() == false) goto L7;
        return true;
    }
}
