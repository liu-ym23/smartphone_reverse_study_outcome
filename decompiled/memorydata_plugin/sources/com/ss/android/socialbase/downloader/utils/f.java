package com.ss.android.socialbase.downloader.utils;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f15654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f15655b;
    private int c;
    private int d;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.utils.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f15656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f15657b;
        a c;
        a d;

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }
    }

    public f() {
        this.d = 10;
    }

    private a a() {
        int r0 = this.c;
        AnonymousClass1 r2 = null;
        if (r0 < this.d) goto L10;
        a r1 = this.f15655b;
        if (r1 == null) goto L10;
        a r3 = r1.d;
        r1.d = null;
        this.f15655b = r3;
        if (r3 == null) goto L9;
        r3.c = null;
    L9:
        return r1;
    L10:
        this.c = r0 + 1;
        return new a(r2);
    }

    private a a(long r7) {
        a r6 = this.f15654a;
        a r0 = null;
    L3:
        if (r6 == null) goto L7;
        if (r6.f15657b <= r7) goto L7;
        r0 = r6;
        r6 = r6.c;
    L7:
        if (r6 == null) goto L13;
        if (r0 == null) goto L13;
        if (r6 == r0) goto L13;
        if ((r7 - r6.f15657b) >= (r0.f15657b - r7)) goto L13;
        return r6;
    L13:
        return r0;
    }

    public boolean a(long r7, long r9) {
        monitor-enter(this);
        a r0 = this.f15654a;     // Catch: Throwable -> L26
        if (r0 != null) goto L6;
    L20:
        a r2 = a();     // Catch: Throwable -> L26
        r2.f15656a = r7;     // Catch: Throwable -> L26
        r2.f15657b = r9;     // Catch: Throwable -> L26
        if (r0 == null) goto L23;
        r2.c = r0;     // Catch: Throwable -> L26
        r0.d = r2;     // Catch: Throwable -> L26
    L23:
        this.f15654a = r2;     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return true;
    L6:
        if (r7 < r0.f15656a) goto L18;
        if (r9 < r0.f15657b) goto L18;
        a r3 = r0.c;     // Catch: Throwable -> L26
        if (r3 == null) goto L20;
        if ((r9 - r3.f15657b) >= 1000) goto L20;
        r0.f15656a = r7;     // Catch: Throwable -> L26
        r0.f15657b = r9;     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return true;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L26
        return false;
    L26:
        th = move-exception;
        throw th;
    }

    public long b(long r8, long r10) {
        monitor-enter(this);
        a r0 = this.f15654a;     // Catch: Throwable -> L20
        if (r0 != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L20
        return -1;
    L7:
        a r9 = a(r8);     // Catch: Throwable -> L20
        if (r9 != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L20
        return -1;
    L11:
        long r3 = r0.f15656a - r9.f15656a;     // Catch: Throwable -> L20
        long r11 = r10 - r9.f15657b;     // Catch: Throwable -> L20
        if (r3 >= 0) goto L14;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return -1;
    L14:
        if (r11 <= 0) goto L18;
        long r4 = r3 / r11;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return r4;
    L20:
        th = move-exception;
        throw th;
    }
}
