package y3;

import android.app.Application;
import i4.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long[] f13929e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f13930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f13932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13933d;

    static {
        f13929e = new long[]{180000, 180000, 360000, 360000, 540000, 540000, 720000, 720000};
    }

    public a(c r8) {
        this.f13930a = r8;
    }

    public final long a(int r8) {
        long r10 = b();
        if (r10 > System.currentTimeMillis()) goto L26;
        monitor-enter(this);
        boolean r11 = c(r8);     // Catch: Throwable -> L15
        this.f13933d = System.currentTimeMillis();     // Catch: Throwable -> L13
        if (r11 == false) goto L10;
        this.f13931b = 0;     // Catch: Throwable -> L13
    L11:
        this.f13930a.f13937m.H.e(d() + " worked: {}", new Object[]{Boolean.valueOf(r11)});     // Catch: Throwable -> L13
    L18:
        r10 = b();     // Catch: Throwable -> L13
        monitor-exit(this);
        goto L26
    L10:
        this.f13931b++;     // Catch: Throwable -> L13
        goto L11
    L13:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        this.f13930a.f13937m.H.i(null, "work failed", th, new Object[0]);     // Catch: Throwable -> L21
        this.f13933d = System.currentTimeMillis();     // Catch: Throwable -> L13
        this.f13931b++;     // Catch: Throwable -> L13
        this.f13930a.f13937m.H.e(d() + " worked: {}", new Object[]{Boolean.FALSE});     // Catch: Throwable -> L13
        goto L18
    L21:
        th = move-exception;
        this.f13933d = System.currentTimeMillis();     // Catch: Throwable -> L13
        this.f13931b++;     // Catch: Throwable -> L13
        this.f13930a.f13937m.H.e(d() + " worked: {}", new Object[]{Boolean.FALSE});     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L26:
        return r10;
    }

    public final long b() {
        long r8 = g();
        if (f() == false) goto L16;
        Application r10 = this.f13930a.f13937m.f11402j;
        r5.e.a(r10);
        if ((System.currentTimeMillis() - r5.e.f11505d) <= r5.e.f11504c) goto L7;
        r5.e.f11502a = r5.e.d(r10);
        r5.e.f11505d = System.currentTimeMillis();
    L7:
        r5.e.a r11 = r5.e.f11502a;
        r11.getClass();
        if (r11 != r5.e.a.f11506b) goto L10;
    L12:
        boolean r12 = false;
    L13:
        if (r12 == true) goto L16;
        this.f13930a.f13937m.H.b("checkWorkTime {} network not available, will try again next interval!", new Object[]{d()});
        this.f13930a.f13937m.f11417y.b(k.S, 1);
    L22:
        return this.f13933d + r8;
    L10:
        if (r11 == r5.e.a.f11507m) goto L12;
        r12 = true;
    L16:
        if (this.f13932c == false) goto L18;
        r8 = 0;
        this.f13933d = 0;
        this.f13932c = false;
        goto L22
    L18:
        int r13 = this.f13931b;
        if (r13 <= 0) goto L22;
        long[] r14 = e();
        r8 = r14[(r13 - 1) % r14.length];
        goto L22
    }

    public abstract boolean c(int r8);

    public abstract String d();

    public abstract long[] e();

    public abstract boolean f();

    public abstract long g();
}
