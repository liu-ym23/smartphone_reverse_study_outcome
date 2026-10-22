package k8;

import m8.b;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f8973a = false;

    public a() {
    }

    public static q8.a a() {
        if (f8973a == false) goto L19;
        if (q8.a.f10197a != null) goto L17;
        monitor-enter(q8.a.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (q8.a.f10197a != null) goto L11;
        q8.a.f10197a = new q8.a();     // Catch: Throwable -> L13
    L11:
        monitor-exit(q8.a.class);     // Catch: Throwable -> L13
    L17:
        return q8.a.f10197a;
    L19:
        throw new IllegalStateException("Privacy SDK not initialized. Please call PrivacySdk.init(...) during app startup.");
    }

    public static void b(m8.a r8, b r10) {
        if (f8973a == false) goto L5;
        return;
    L5:
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8973a == true) goto L9;
        l6.a.f9154w = r8;     // Catch: Throwable -> L11
        p8.b.a().f9950a = r10;     // Catch: Throwable -> L11
        f8973a = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    }
}
