package com.ss.android.socialbase.downloader.utils;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f8335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f8336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8338d;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f8339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f8340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        b f8341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        b f8342d;

        private b() {
        }

        /* synthetic */ b(a r10) {
            this();
        }
    }

    public f() {
        this.f8338d = 10;
    }

    private b a(long r10) {
        b r11 = this.f8335a;
        b r12 = null;
    L3:
        if (r11 == null) goto L7;
        if (r11.f8340b <= r10) goto L7;
        r12 = r11;
        r11 = r11.f8341c;
    L7:
        if (r11 == null) goto L13;
        if (r12 == null) goto L13;
        if (r11 == r12) goto L13;
        if ((r10 - r11.f8340b) >= (r12.f8340b - r10)) goto L13;
        return r11;
    L13:
        return r12;
    }

    private b d() {
        int r10 = this.f8337c;
        a r11 = null;
        if (r10 < this.f8338d) goto L10;
        b r12 = this.f8336b;
        if (r12 == null) goto L10;
        b r13 = r12.f8342d;
        r12.f8342d = null;
        this.f8336b = r13;
        if (r13 == null) goto L9;
        r13.f8341c = null;
    L9:
        return r12;
    L10:
        this.f8337c = r10 + 1;
        return new b(r11);
    }

    public long b(long r10, long r11) {
        monitor-enter(this);
        b r12 = this.f8335a;     // Catch: Throwable -> L20
        if (r12 != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L20
        return -1;
    L7:
        b r13 = a(r10);     // Catch: Throwable -> L20
        if (r13 != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L20
        return -1;
    L11:
        long r14 = r12.f8339a - r13.f8339a;     // Catch: Throwable -> L20
        long r15 = r11 - r13.f8340b;     // Catch: Throwable -> L20
        if (r14 >= 0) goto L14;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return -1;
    L14:
        if (r15 <= 0) goto L18;
        long r16 = r14 / r15;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return r16;
    L20:
        th = move-exception;
        throw th;
    }

    public boolean c(long r10, long r11) {
        monitor-enter(this);
        b r12 = this.f8335a;     // Catch: Throwable -> L26
        if (r12 != null) goto L6;
    L20:
        b r13 = d();     // Catch: Throwable -> L26
        r13.f8339a = r10;     // Catch: Throwable -> L26
        r13.f8340b = r11;     // Catch: Throwable -> L26
        if (r12 == null) goto L23;
        r13.f8341c = r12;     // Catch: Throwable -> L26
        r12.f8342d = r13;     // Catch: Throwable -> L26
    L23:
        this.f8335a = r13;     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return true;
    L6:
        if (r10 < r12.f8339a) goto L18;
        if (r11 < r12.f8340b) goto L18;
        b r14 = r12.f8341c;     // Catch: Throwable -> L26
        if (r14 == null) goto L20;
        if ((r11 - r14.f8340b) >= 1000) goto L20;
        r12.f8339a = r10;     // Catch: Throwable -> L26
        r12.f8340b = r11;     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return true;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L26
        return false;
    L26:
        th = move-exception;
        throw th;
    }
}
