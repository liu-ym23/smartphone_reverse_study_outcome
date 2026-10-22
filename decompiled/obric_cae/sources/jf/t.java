package jf;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static s f8877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f8878b;

    public t() {
    }

    public static void a(s r8) {
        if (r8.f8875f != null) goto L22;
        if (r8.f8876g != null) goto L22;
        if (r8.f8873d == false) goto L10;
        return;
    L10:
        monitor-enter(t.class);
        long r10 = f8878b + 8192;     // Catch: Throwable -> L18
        if (r10 <= 65536) goto L15;
        monitor-exit(t.class);     // Catch: Throwable -> L18
        return;
    L15:
        f8878b = r10;     // Catch: Throwable -> L18
        r8.f8875f = f8877a;     // Catch: Throwable -> L18
        r8.f8872c = 0;     // Catch: Throwable -> L18
        r8.f8871b = 0;     // Catch: Throwable -> L18
        f8877a = r8;     // Catch: Throwable -> L18
        monitor-exit(t.class);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L22:
        throw new IllegalArgumentException();
    }

    public static s b() {
        monitor-enter(t.class);
        s r8 = f8877a;     // Catch: Throwable -> L12
        if (r8 == null) goto L9;
        f8877a = r8.f8875f;     // Catch: Throwable -> L12
        r8.f8875f = null;     // Catch: Throwable -> L12
        f8878b -= 8192;     // Catch: Throwable -> L12
        monitor-exit(t.class);     // Catch: Throwable -> L12
        return r8;
    L9:
        monitor-exit(t.class);     // Catch: Throwable -> L12
        return new s();
    L12:
        th = move-exception;
        throw th;
    }
}
