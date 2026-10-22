package com.google.common.base;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t f4306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4307b;
    private long c;
    private long d;

    /* JADX INFO: renamed from: com.google.common.base.p$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4308a = null;

        static {
            int[] r0 = new int[TimeUnit.values().length];
            f4308a = r0;
            r0[TimeUnit.NANOSECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f4308a[TimeUnit.MICROSECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f4308a[TimeUnit.MILLISECONDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f4308a[TimeUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f4308a[TimeUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f4308a[TimeUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f4308a[TimeUnit.DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    p() {
        this.f4306a = t.b();
    }

    public static p a() {
        return new p();
    }

    private static TimeUnit a(long r4) {
        if (TimeUnit.DAYS.convert(r4, TimeUnit.NANOSECONDS) <= 0) goto L7;
        return TimeUnit.DAYS;
    L7:
        if (TimeUnit.HOURS.convert(r4, TimeUnit.NANOSECONDS) <= 0) goto L11;
        return TimeUnit.HOURS;
    L11:
        if (TimeUnit.MINUTES.convert(r4, TimeUnit.NANOSECONDS) <= 0) goto L15;
        return TimeUnit.MINUTES;
    L15:
        if (TimeUnit.SECONDS.convert(r4, TimeUnit.NANOSECONDS) <= 0) goto L19;
        return TimeUnit.SECONDS;
    L19:
        if (TimeUnit.MILLISECONDS.convert(r4, TimeUnit.NANOSECONDS) <= 0) goto L23;
        return TimeUnit.MILLISECONDS;
    L23:
        if (TimeUnit.MICROSECONDS.convert(r4, TimeUnit.NANOSECONDS) <= 0) goto L27;
        return TimeUnit.MICROSECONDS;
    L27:
        return TimeUnit.NANOSECONDS;
    }

    public static p b() {
        return new p().c();
    }

    private static String b(TimeUnit r1) {
        switch(AnonymousClass1.f4308a[r1.ordinal()]) {
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return "d";
    L8:
        return com.loc.o.g;
    L10:
        return "min";
    L12:
        return "s";
    L14:
        return "ms";
    L16:
        return "μs";
    L18:
        return "ns";
    L5:
        throw new AssertionError();
    }

    private long e() {
        if (this.f4307b == false) goto L6;
        return (this.f4306a.a() - this.d) + this.c;
    L6:
        return this.c;
    }

    public long a(TimeUnit r3) {
        return r3.convert(e(), TimeUnit.NANOSECONDS);
    }

    public p c() {
        n.b(!this.f4307b, "This stopwatch is already running.");
        this.f4307b = true;
        this.d = this.f4306a.a();
        return this;
    }

    public p d() {
        long r0 = this.f4306a.a();
        n.b(this.f4307b, "This stopwatch is already stopped.");
        this.f4307b = false;
        this.c += r0 - this.d;
        return this;
    }

    public String toString() {
        long r0 = e();
        TimeUnit r5 = a(r0);
        return m.a(r0 / TimeUnit.NANOSECONDS.convert(1, r5)) + " " + b(r5);
    }
}
