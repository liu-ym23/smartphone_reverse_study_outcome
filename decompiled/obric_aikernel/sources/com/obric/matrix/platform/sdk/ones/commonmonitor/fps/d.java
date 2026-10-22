package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import androidx.core.util.Pools;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f5866n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Pools.SynchronizedPool<d> f5867o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f5868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f5869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f5874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f5875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f5876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f5877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f5878k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f5879l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f5880m;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final d a() {
            d r10 = (d) d.a().acquire();
            if (r10 == null) goto L5;
            return r10;
        L5:
            return new d(0.0d, 0, 0, 0, 0, 0, 0, 0, 0.0d, 0, 0, 0, 0, 8191, null);
        }
    }

    static {
        f5866n = new a(null);
        f5867o = new Pools.SynchronizedPool(5);
    }

    public d() {
        this(0.0d, 0, 0, 0, 0, 0, 0, 0, 0.0d, 0, 0, 0, 0, 8191, null);
    }

    public d(double r10, long r11, int r12, int r13, int r14, int r15, int r16, int r17, double r18, int r19, int r110, int r111, int r112) {
        this.f5868a = r10;
        this.f5869b = r11;
        this.f5870c = r12;
        this.f5871d = r13;
        this.f5872e = r14;
        this.f5873f = r15;
        this.f5874g = r16;
        this.f5875h = r17;
        this.f5876i = r18;
        this.f5877j = r19;
        this.f5878k = r110;
        this.f5879l = r111;
        this.f5880m = r112;
    }

    public /* synthetic */ d(double r17, long r19, int r21, int r22, int r23, int r24, int r25, int r26, double r27, int r29, int r30, int r31, int r32, int r33, DefaultConstructorMarker r34) {
        double r10 = 0.0d;
        if ((r33 & 1) == 0) goto L5;
        double r11 = 0.0d;
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r12 = 0;
    L11:
        if ((r33 & 4) == 0) goto L13;
        int r13 = 0;
    L15:
        if ((r33 & 8) == 0) goto L17;
        int r14 = 0;
    L19:
        if ((r33 & 16) == 0) goto L21;
        int r15 = 0;
    L23:
        if ((r33 & 32) == 0) goto L25;
        int r16 = 0;
    L27:
        if ((r33 & 64) == 0) goto L29;
        int r18 = 0;
    L31:
        if ((r33 & 128) == 0) goto L33;
        int r110 = 0;
    L35:
        if ((r33 & 256) != 0) goto L39;
        r10 = r27;
    L39:
        if ((r33 & 512) == 0) goto L41;
        int r111 = 0;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        int r112 = 0;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        int r20 = 0;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        int r28 = 0;
    L54:
        this(r11, r12, r13, r14, r15, r16, r18, r110, r10, r111, r112, r20, r28);
        return;
    L53:
        r28 = r32;
        goto L54
    L49:
        r20 = r31;
        goto L51
    L45:
        r112 = r30;
        goto L47
    L41:
        r111 = r29;
        goto L43
    L33:
        r110 = r26;
        goto L35
    L29:
        r18 = r25;
        goto L31
    L25:
        r16 = r24;
        goto L27
    L21:
        r15 = r23;
        goto L23
    L17:
        r14 = r22;
        goto L19
    L13:
        r13 = r21;
        goto L15
    L9:
        r12 = r19;
        goto L11
    L5:
        r11 = r17;
        goto L7
    }

    public static final /* synthetic */ Pools.SynchronizedPool a() {
        return f5867o;
    }

    public final int b() {
        return this.f5880m;
    }

    public final int c() {
        return this.f5878k;
    }

    public final int d() {
        return this.f5879l;
    }

    public final double e() {
        return this.f5876i;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Intrinsics.areEqual(Double.valueOf(this.f5868a), Double.valueOf(r11.f5868a)) == true) goto L12;
        return false;
    L12:
        if (this.f5869b == r11.f5869b) goto L15;
        return false;
    L15:
        if (this.f5870c == r11.f5870c) goto L18;
        return false;
    L18:
        if (this.f5871d == r11.f5871d) goto L21;
        return false;
    L21:
        if (this.f5872e == r11.f5872e) goto L24;
        return false;
    L24:
        if (this.f5873f == r11.f5873f) goto L27;
        return false;
    L27:
        if (this.f5874g == r11.f5874g) goto L30;
        return false;
    L30:
        if (this.f5875h == r11.f5875h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(Double.valueOf(this.f5876i), Double.valueOf(r11.f5876i)) == true) goto L36;
        return false;
    L36:
        if (this.f5877j == r11.f5877j) goto L39;
        return false;
    L39:
        if (this.f5878k == r11.f5878k) goto L42;
        return false;
    L42:
        if (this.f5879l == r11.f5879l) goto L45;
        return false;
    L45:
        if (this.f5880m == r11.f5880m) goto L47;
        return false;
    L47:
        return true;
    }

    public final double f() {
        return this.f5868a;
    }

    public final void g() {
        this.f5868a = 0.0d;
        this.f5876i = 0.0d;
        this.f5878k = 0;
        this.f5879l = 0;
        this.f5880m = 0;
        this.f5877j = 0;
        this.f5869b = 0;
        this.f5870c = 0;
        this.f5871d = 0;
        this.f5872e = 0;
        this.f5873f = 0;
        this.f5874g = 0;
        this.f5875h = 0;
        f5867o.release(this);
    }

    public final void h(int r10) {
        this.f5874g = r10;
    }

    public int hashCode() {
        return (((((((((((((((((((((((Double.hashCode(this.f5868a) * 31) + Long.hashCode(this.f5869b)) * 31) + Integer.hashCode(this.f5870c)) * 31) + Integer.hashCode(this.f5871d)) * 31) + Integer.hashCode(this.f5872e)) * 31) + Integer.hashCode(this.f5873f)) * 31) + Integer.hashCode(this.f5874g)) * 31) + Integer.hashCode(this.f5875h)) * 31) + Double.hashCode(this.f5876i)) * 31) + Integer.hashCode(this.f5877j)) * 31) + Integer.hashCode(this.f5878k)) * 31) + Integer.hashCode(this.f5879l)) * 31) + Integer.hashCode(this.f5880m);
    }

    public final void i(int r10) {
        this.f5875h = r10;
    }

    public final void j(int r10) {
        this.f5880m = r10;
    }

    public final void k(int r10) {
        this.f5878k = r10;
    }

    public final void l(int r10) {
        this.f5879l = r10;
    }

    public final void m(double r10) {
        this.f5876i = r10;
    }

    public final void n(long r10) {
        this.f5869b = r10;
    }

    public final void o(int r10) {
        this.f5872e = r10;
    }

    public final void p(int r10) {
        this.f5873f = r10;
    }

    public final void q(double r10) {
        this.f5868a = r10;
    }

    public final void r(int r10) {
        this.f5877j = r10;
    }

    public final void s(int r10) {
        this.f5870c = r10;
    }

    public final void t(int r10) {
        this.f5871d = r10;
    }

    public String toString() {
        return "FpsBean(fps=" + this.f5868a + ", duration=" + this.f5869b + ", startX=" + this.f5870c + ", startY=" + this.f5871d + ", endX=" + this.f5872e + ", endY=" + this.f5873f + ", distantX=" + this.f5874g + ", distantY=" + this.f5875h + ", dropRate=" + this.f5876i + ", frameCount=" + this.f5877j + ", drop3=" + this.f5878k + ", drop7=" + this.f5879l + ", drop25=" + this.f5880m + ')';
    }
}
