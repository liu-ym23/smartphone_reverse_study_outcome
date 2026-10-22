package com.google.common.math;

import com.google.common.base.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: com.google.common.math.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final double f4747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final double f4748b;

        private a(double r1, double r3) {
            this.f4747a = r1;
            this.f4748b = r3;
        }

        /* synthetic */ a(double r1, double r3, AnonymousClass1 r5) {
            this(r1, r3);
        }

        public d a(double r5) {
            n.a(!Double.isNaN(r5));
            if (com.google.common.math.b.b(r5) == false) goto L7;
            return new c(r5, this.f4748b - (this.f4747a * r5));
        L7:
            return new C0203d(this.f4747a);
        }
    }

    private static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f4749a = null;

        static {
            f4749a = new b();
        }

        private b() {
        }

        public String toString() {
            return "NaN";
        }
    }

    private static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final double f4750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final double f4751b;
        d c;

        c(double r1, double r3) {
            this.f4750a = r1;
            this.f4751b = r3;
            this.c = null;
        }

        public String toString() {
            return String.format("y = %g * x + %g", new Object[]{Double.valueOf(this.f4750a), Double.valueOf(this.f4751b)});
        }
    }

    /* JADX INFO: renamed from: com.google.common.math.d$d, reason: collision with other inner class name */
    private static final class C0203d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final double f4752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        d f4753b;

        C0203d(double r1) {
            this.f4752a = r1;
            this.f4753b = null;
        }

        public String toString() {
            return String.format("x = %g", new Object[]{Double.valueOf(this.f4752a)});
        }
    }

    public d() {
    }

    public static a a(double r7, double r9) {
        if (com.google.common.math.b.b(r7) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        n.a(r0);
        return new a(r7, r9, null);
    L5:
        if (com.google.common.math.b.b(r9) == false) goto L7;
        r0 = true;
        goto L8
    }

    public static d a() {
        return b.f4749a;
    }

    public static d a(double r1) {
        n.a(com.google.common.math.b.b(r1));
        return new C0203d(r1);
    }

    public static d b(double r3) {
        n.a(com.google.common.math.b.b(r3));
        return new c(0.0d, r3);
    }
}
