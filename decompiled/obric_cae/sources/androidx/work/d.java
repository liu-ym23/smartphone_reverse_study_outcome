package androidx.work;

import android.net.Uri;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f2807i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f2808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f2813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f2814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<b> f2815h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n f2816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f2817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f2818c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinkedHashSet f2819d;

        public a() {
            this.f2816a = n.f2932a;
            this.f2817b = -1;
            this.f2818c = -1;
            this.f2819d = new LinkedHashSet();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f2820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2821b;

        public b(boolean r8, Uri r10) {
            this.f2820a = r10;
            this.f2821b = r8;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if (r8 == null) goto L8;
            Class<?> r10 = r8.getClass();
        L10:
            if (he.i.a(b.class, r10) == true) goto L12;
            return false;
        L12:
            he.i.d(r8, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            b r11 = (b) r8;
            if (he.i.a(this.f2820a, r11.f2820a) == true) goto L16;
            return false;
        L16:
            if (this.f2821b == r11.f2821b) goto L18;
            return false;
        L18:
            return true;
        L8:
            r10 = null;
            goto L10
        }

        public final int hashCode() {
            int r8 = this.f2820a.hashCode() * 31;
            return Boolean.hashCode(this.f2821b) + r8;
        }
    }

    static {
        f2807i = new d(0);
    }

    public d() {
        this(0);
    }

    public final long a() {
        return this.f2814g;
    }

    public final long b() {
        return this.f2813f;
    }

    public final Set<b> c() {
        return this.f2815h;
    }

    public final n d() {
        return this.f2808a;
    }

    public final boolean e() {
        return this.f2811d;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
        return false;
    L8:
        if (he.i.a(d.class, r8.getClass()) == false) goto L34;
        d r10 = (d) r8;
        if (this.f2809b == r10.f2809b) goto L14;
        return false;
    L14:
        if (this.f2810c == r10.f2810c) goto L17;
        return false;
    L17:
        if (this.f2811d == r10.f2811d) goto L20;
        return false;
    L20:
        if (this.f2812e == r10.f2812e) goto L23;
        return false;
    L23:
        if (this.f2813f == r10.f2813f) goto L26;
        return false;
    L26:
        if (this.f2814g == r10.f2814g) goto L29;
        return false;
    L29:
        if (this.f2808a == r10.f2808a) goto L32;
        return false;
    L32:
        return he.i.a(this.f2815h, r10.f2815h);
    L34:
        return false;
    }

    public final boolean f() {
        return this.f2809b;
    }

    public final boolean g() {
        return this.f2810c;
    }

    public final boolean h() {
        return this.f2812e;
    }

    public final int hashCode() {
        int r8 = ((((((((this.f2808a.hashCode() * 31) + (this.f2809b ? 1 : 0)) * 31) + (this.f2810c ? 1 : 0)) * 31) + (this.f2811d ? 1 : 0)) * 31) + (this.f2812e ? 1 : 0)) * 31;
        long r10 = this.f2813f;
        int r11 = (r8 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = this.f2814g;
        int r13 = this.f2815h.hashCode();
        return r13 + ((r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31);
    }

    public /* synthetic */ d(int r12) {
        this(n.f2932a, false, false, false, false, -1, -1, yd.m.f14121a);
    }

    public d(n r8, boolean r10, boolean r11, boolean r12, boolean r13, long r14, long r15, Set<b> r16) {
        he.i.f(r8, "requiredNetworkType");
        he.i.f(r16, "contentUriTriggers");
        this.f2808a = r8;
        this.f2809b = r10;
        this.f2810c = r11;
        this.f2811d = r12;
        this.f2812e = r13;
        this.f2813f = r14;
        this.f2814g = r15;
        this.f2815h = r16;
    }
}
