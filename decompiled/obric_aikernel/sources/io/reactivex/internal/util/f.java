package io.reactivex.internal.util;

/* JADX INFO: loaded from: classes2.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final float f9689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f9690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f9691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f9692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    T[] f9693e;

    public f() {
        this(16, 0.75f);
    }

    public f(int r10, float r11) {
        this.f9689a = r11;
        int r12 = g.a(r10);
        this.f9690b = r12 - 1;
        this.f9692d = (int) (r11 * r12);
        this.f9693e = (T[]) new Object[r12];
    }

    static int c(int r10) {
        int r11 = r10 * (-1640531527);
        return r11 ^ (r11 >>> 16);
    }

    public boolean a(T r10) {
        T[] r11 = this.f9693e;
        int r12 = this.f9690b;
        int r13 = c(r10.hashCode()) & r12;
        T r14 = r11[r13];
        if (r14 != null) goto L5;
    L13:
        r11[r13] = r10;
        int r15 = this.f9691c + 1;
        this.f9691c = r15;
        if (r15 < this.f9692d) goto L16;
        d();
    L16:
        return true;
    L5:
        if (r14.equals(r10) == false) goto L7;
        return false;
    L7:
        r13 = (r13 + 1) & r12;
        T r16 = r11[r13];
        if (r16 == null) goto L13;
        if (r16.equals(r10) == false) goto L7;
        return false;
    }

    public Object[] b() {
        return this.f9693e;
    }

    void d() {
        T[] r10 = this.f9693e;
        int r11 = r10.length;
        int r12 = r11 << 1;
        int r13 = r12 - 1;
        T[] r14 = (T[]) new Object[r12];
        int r15 = this.f9691c;
    L3:
        int r16 = r15 - 1;
        if (r15 == 0) goto L13;
    L5:
        r11 = r11 - 1;
        if (r10[r11] == null) goto L5;
        int r17 = c(r10[r11].hashCode()) & r13;
        if (r14[r17] == null) goto L12;
    L10:
        r17 = (r17 + 1) & r13;
        if (r14[r17] != null) goto L10;
    L12:
        r14[r17] = r10[r11];
        r15 = r16;
        goto L3
    L13:
        this.f9690b = r13;
        this.f9692d = (int) (r12 * this.f9689a);
        this.f9693e = r14;
    }

    public boolean e(T r10) {
        T[] r11 = this.f9693e;
        int r12 = this.f9690b;
        int r13 = c(r10.hashCode()) & r12;
        T r14 = r11[r13];
        if (r14 != null) goto L6;
        return false;
    L6:
        if (r14.equals(r10) == true) goto L8;
    L9:
        r13 = (r13 + 1) & r12;
        T r15 = r11[r13];
        if (r15 == null) goto L11;
        if (r15.equals(r10) == false) goto L9;
        return f(r13, r11, r12);
    L11:
        return false;
    L8:
        return f(r13, r11, r12);
    }

    boolean f(int r10, T[] r11, int r12) {
        this.f9691c--;
    L3:
        int r13 = r10 + 1;
    L4:
        int r14 = r13 & r12;
        T r15 = r11[r14];
        if (r15 == null) goto L6;
        int r16 = c(r15.hashCode()) & r12;
        if (r10 > r14) goto L13;
        if (r10 >= r16) goto L15;
        if (r16 > r14) goto L15;
    L16:
        r13 = r14 + 1;
    L15:
        r11[r10] = r15;
        r10 = r14;
        goto L3
    L13:
        if (r10 < r16) goto L16;
        if (r16 <= r14) goto L16;
    L6:
        r11[r10] = null;
        return true;
    }

    public int g() {
        return this.f9691c;
    }
}
