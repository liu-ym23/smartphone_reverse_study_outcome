package w98;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final /* synthetic */ int p = 0;
    public final long a;
    public final int b;
    public final int c;
    public final Object d;
    public int e;
    public long f;
    public long g;
    public long h;
    public int i;
    public long j;
    public int k;
    public int l;
    public long m;
    public final LinkedHashMap<Long, b> n;
    public boolean o;

    public static final class a {
    }

    public static final class b {
        public final long a;
        public boolean b;
        public boolean c;
        public boolean d;

        public b(long r1) {
            this.a = r1;
            this.b = false;
            this.c = false;
            this.d = false;
        }
    }

    static {
    }

    public final int a() {
        Object r0 = this.d;
        monitor-enter(r0);
        int r1 = this.k;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final int b() {
        Object r0 = this.d;
        monitor-enter(r0);
        long r1 = this.g;     // Catch: Throwable -> L11
        int r3 = this.e;     // Catch: Throwable -> L11
        if (r3 <= 0) goto L8;
        int r2 = (int) (r1 / ((long) r3));
    L9:
        monitor-exit(r0);
        return r2;
    L8:
        r2 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    public final int c() {
        Object r0 = this.d;
        monitor-enter(r0);
        long r1 = this.m;     // Catch: Throwable -> L11
        int r3 = this.l;     // Catch: Throwable -> L11
        if (r3 <= 0) goto L8;
        int r2 = (int) (r1 / ((long) r3));
    L9:
        monitor-exit(r0);
        return r2;
    L8:
        r2 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    public final int d() {
        Object r0 = this.d;
        monitor-enter(r0);
        long r1 = this.h;     // Catch: Throwable -> L11
        int r3 = this.e;     // Catch: Throwable -> L11
        if (r3 <= 0) goto L8;
        int r2 = (int) (r1 / ((long) r3));
    L9:
        monitor-exit(r0);
        return r2;
    L8:
        r2 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    public final int e() {
        Object r0 = this.d;
        monitor-enter(r0);
        long r1 = this.j;     // Catch: Throwable -> L11
        int r3 = this.k;     // Catch: Throwable -> L11
        if (r3 <= 0) goto L8;
        int r2 = (int) (r1 / ((long) r3));
    L9:
        monitor-exit(r0);
        return r2;
    L8:
        r2 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    public final int f() {
        Object r0 = this.d;
        monitor-enter(r0);
        int r1 = this.l;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final int g() {
        Object r0 = this.d;
        monitor-enter(r0);
        int r1 = this.e;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final int h() {
        Object r0 = this.d;
        monitor-enter(r0);
        int r1 = this.i;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public d(long r1, int r3) {
        this.a = r1;
        this.b = r3;
        this.c = 100;
        this.d = new Object();
        this.n = new LinkedHashMap();
    }
}
