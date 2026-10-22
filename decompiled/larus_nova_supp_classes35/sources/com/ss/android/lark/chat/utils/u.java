package com.ss.android.lark.chat.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u {
    public c a;
    public b b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;

    public static final class a {
        public static final u a = null;

        static {
            a = new u();
        }
    }

    public interface b {
        void a();
    }

    public interface c {
        void a();

        void b();

        void c();

        void d(int[] r1);

        a1 e(boolean r1);
    }

    public final void a() {
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = 0;
        c();
        monitor-enter(this);
        this.b = null;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void c() {
        monitor-enter(this);
        c r0 = this.a;     // Catch: Throwable -> L10
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        r0.a();     // Catch: Throwable -> L10
        this.a = null;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void e() {
        monitor-enter(this);
        b r0 = this.b;     // Catch: Throwable -> L10
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        r0.a();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public u() {
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = 0;
    }

    public final synchronized a1 b(boolean r3) {
        monitor-enter(this);
        c r0 = this.a;     // Catch: Throwable -> L14
        if (r0 != null) goto L6;
    L11:
        monitor-exit(this);
        return null;
    L6:
        if (this.c == false) goto L11;
        a1 r4 = r0.e(r3);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r4;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(b r1) {
        monitor-enter(this);
        this.b = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
