package com.google.common.collect;

import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class y9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f9233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9235c;
    public long d;
    public int e;
    public y9 f;
    public y9 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public y9 f9236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public y9 f9237i;

    public y9(Object r5, int r10) {
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        com.google.common.base.b0.i(r11);
        this.f9233a = r5;
        this.f9234b = r10;
        this.d = r10;
        this.f9235c = 1;
        this.e = 1;
        this.f = null;
        this.g = null;
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final y9 a(Comparator r10, Object r11, int r12, int[] r13) {
        int r5 = r10.compare(r11, this.f9233a);
        boolean r14 = true;
        if (r5 >= 0) goto L16;
        y9 r15 = this.f;
        if (r15 != null) goto L8;
        r13[0] = 0;
        b(r12, r11);
        return this;
    L8:
        int r16 = r15.e;
        y9 r17 = r15.a(r10, r11, r12, r13);
        this.f = r17;
        if (r13[0] != 0) goto L11;
        this.f9235c++;
    L11:
        this.d += (long) r12;
        if (r17.e != r16) goto L15;
        return this;
    L15:
        return h();
    L16:
        if (r5 <= 0) goto L29;
        y9 r18 = this.g;
        if (r18 != null) goto L21;
        r13[0] = 0;
        c(r12, r11);
        return this;
    L21:
        int r19 = r18.e;
        y9 r20 = r18.a(r10, r11, r12, r13);
        this.g = r20;
        if (r13[0] != 0) goto L24;
        this.f9235c++;
    L24:
        this.d += (long) r12;
        if (r20.e != r19) goto L28;
        return this;
    L28:
        return h();
    L29:
        int r21 = this.f9234b;
        r13[0] = r21;
        long r22 = r12;
        if ((((long) r21) + r22) <= 2147483647L) goto L33;
        r14 = false;
    L33:
        com.google.common.base.b0.i(r14);
        this.f9234b += r12;
        this.d += r22;
        return this;
    }

    public final void b(int r5, Object r10) {
        this.f = new y9(r10, r5);
        y9 r11 = this.f9236h;
        Objects.requireNonNull(r11);
        TreeMultiset.access$1800(r11, this.f, this);
        this.e = Math.max(2, this.e);
        this.f9235c++;
        this.d += (long) r5;
    }

    public final void c(int r5, Object r10) {
        y9 r11 = new y9(r10, r5);
        this.g = r11;
        y9 r12 = this.f9237i;
        Objects.requireNonNull(r12);
        TreeMultiset.access$1800(this, r11, r12);
        this.e = Math.max(2, this.e);
        this.f9235c++;
        this.d += (long) r5;
    }

    public final y9 d(Comparator r5, Object r10) {
        int r11 = r5.compare(r10, this.f9233a);
        if (r11 >= 0) goto L9;
        y9 r12 = this.f;
        if (r12 != null) goto L8;
        return this;
    L8:
        return (y9) com.google.common.base.b0.y(r12.d(r5, r10), this);
    L9:
        if (r11 != 0) goto L11;
        return this;
    L11:
        y9 r13 = this.g;
        if (r13 != null) goto L15;
        return null;
    L15:
        return r13.d(r5, r10);
    }

    public final int e(Comparator r5, Object r10) {
        int r11 = r5.compare(r10, this.f9233a);
        if (r11 >= 0) goto L9;
        y9 r12 = this.f;
        if (r12 != null) goto L8;
        return 0;
    L8:
        return r12.e(r5, r10);
    L9:
        if (r11 <= 0) goto L16;
        y9 r13 = this.g;
        if (r13 != null) goto L14;
        return 0;
    L14:
        return r13.e(r5, r10);
    L16:
        return this.f9234b;
    }

    public final y9 f() {
        int r5 = this.f9234b;
        this.f9234b = 0;
        y9 r10 = this.f9236h;
        Objects.requireNonNull(r10);
        y9 r11 = this.f9237i;
        Objects.requireNonNull(r11);
        TreeMultiset.access$1900(r10, r11);
        y9 r12 = this.f;
        if (r12 == null) goto L5;
        y9 r13 = this.g;
        if (r13 != null) goto L10;
        return r12;
    L10:
        if (r12.e < r13.e) goto L13;
        y9 r14 = this.f9236h;
        Objects.requireNonNull(r14);
        r14.f = this.f.l(r14);
        r14.g = this.g;
        r14.f9235c = this.f9235c - 1;
        r14.d = this.d - ((long) r5);
        return r14.h();
    L13:
        y9 r15 = this.f9237i;
        Objects.requireNonNull(r15);
        r15.g = this.g.m(r15);
        r15.f = this.f;
        r15.f9235c = this.f9235c - 1;
        r15.d = this.d - ((long) r5);
        return r15.h();
    L5:
        return this.g;
    }

    public final y9 g(Comparator r5, Object r10) {
        int r11 = r5.compare(r10, this.f9233a);
        if (r11 <= 0) goto L9;
        y9 r12 = this.g;
        if (r12 != null) goto L8;
        return this;
    L8:
        return (y9) com.google.common.base.b0.y(r12.g(r5, r10), this);
    L9:
        if (r11 != 0) goto L11;
        return this;
    L11:
        y9 r13 = this.f;
        if (r13 != null) goto L15;
        return null;
    L15:
        return r13.g(r5, r10);
    }

    public final y9 h() {
        y9 r5 = this.f;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        y9 r12 = this.g;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = r11 - r13;
        if (r14 != (-2)) goto L13;
        Objects.requireNonNull(r12);
        y9 r15 = this.g;
        y9 r16 = r15.f;
        if (r16 != null) goto L32;
        int r17 = 0;
    L33:
        y9 r18 = r15.g;
        if (r18 == null) goto L38;
        r10 = r18.e;
    L38:
        if ((r17 - r10) <= 0) goto L41;
        this.g = r15.o();
    L41:
        return n();
    L32:
        r17 = r16.e;
        goto L33
    L13:
        if (r14 == 2) goto L16;
        j();
        return this;
    L16:
        Objects.requireNonNull(r5);
        y9 r19 = this.f;
        y9 r20 = r19.f;
        if (r20 != null) goto L19;
        int r21 = 0;
    L20:
        y9 r22 = r19.g;
        if (r22 == null) goto L25;
        r10 = r22.e;
    L25:
        if ((r21 - r10) >= 0) goto L28;
        this.f = r19.n();
    L28:
        return o();
    L19:
        r21 = r20.e;
        goto L20
    L9:
        r13 = r12.e;
        goto L10
    L5:
        r11 = r5.e;
        goto L6
    }

    public final void i() {
        this.f9235c = TreeMultiset.distinctElements(this.g) + (TreeMultiset.distinctElements(this.f) + 1);
        long r5 = this.f9234b;
        y9 r10 = this.f;
        long r11 = 0;
        if (r10 != null) goto L5;
        long r12 = 0;
    L6:
        long r13 = r12 + r5;
        y9 r14 = this.g;
        if (r14 == null) goto L10;
        r11 = r14.d;
    L10:
        this.d = r11 + r13;
        j();
        return;
    L5:
        r12 = r10.d;
        goto L6
    }

    public final void j() {
        y9 r5 = this.f;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        y9 r12 = this.g;
        if (r12 == null) goto L10;
        r10 = r12.e;
    L10:
        this.e = Math.max(r11, r10) + 1;
        return;
    L5:
        r11 = r5.e;
        goto L6
    }

    public final y9 k(Comparator r5, Object r10, int r11, int[] r12) {
        int r13 = r5.compare(r10, this.f9233a);
        if (r13 >= 0) goto L17;
        y9 r14 = this.f;
        if (r14 != null) goto L8;
        r12[0] = 0;
        return this;
    L8:
        this.f = r14.k(r5, r10, r11, r12);
        int r15 = r12[0];
        if (r15 <= 0) goto L13;
        if (r11 < r15) goto L12;
        this.f9235c--;
        this.d -= (long) r15;
        goto L13
    L12:
        this.d -= (long) r11;
    L13:
        if (r15 != 0) goto L16;
        return this;
    L16:
        return h();
    L17:
        if (r13 <= 0) goto L29;
        y9 r16 = this.g;
        if (r16 != null) goto L22;
        r12[0] = 0;
        return this;
    L22:
        this.g = r16.k(r5, r10, r11, r12);
        int r17 = r12[0];
        if (r17 <= 0) goto L28;
        if (r11 < r17) goto L26;
        this.f9235c--;
        this.d -= (long) r17;
        goto L28
    L26:
        this.d -= (long) r11;
    L28:
        return h();
    L29:
        int r18 = this.f9234b;
        r12[0] = r18;
        if (r11 >= r18) goto L32;
        this.f9234b = r18 - r11;
        this.d -= (long) r11;
        return this;
    L32:
        return f();
    }

    public final y9 l(y9 r5) {
        y9 r10 = this.g;
        if (r10 == null) goto L5;
        this.g = r10.l(r5);
        this.f9235c--;
        this.d -= (long) r5.f9234b;
        return h();
    L5:
        return this.f;
    }

    public final y9 m(y9 r5) {
        y9 r10 = this.f;
        if (r10 == null) goto L5;
        this.f = r10.m(r5);
        this.f9235c--;
        this.d -= (long) r5.f9234b;
        return h();
    L5:
        return this.g;
    }

    public final y9 n() {
        if (this.g == null) goto L5;
        boolean r5 = true;
    L6:
        com.google.common.base.b0.t(r5);
        y9 r10 = this.g;
        this.g = r10.f;
        r10.f = this;
        r10.d = this.d;
        r10.f9235c = this.f9235c;
        i();
        r10.j();
        return r10;
    L5:
        r5 = false;
        goto L6
    }

    public final y9 o() {
        if (this.f == null) goto L5;
        boolean r5 = true;
    L6:
        com.google.common.base.b0.t(r5);
        y9 r10 = this.f;
        this.f = r10.g;
        r10.g = this;
        r10.d = this.d;
        r10.f9235c = this.f9235c;
        i();
        r10.j();
        return r10;
    L5:
        r5 = false;
        goto L6
    }

    public final y9 p(Comparator r10, Object r11, int r12, int r13, int[] r14) {
        int r5 = r10.compare(r11, this.f9233a);
        if (r5 >= 0) goto L22;
        y9 r15 = this.f;
        if (r15 != null) goto L11;
        r14[0] = 0;
        if (r12 != 0) goto L10;
        if (r13 <= 0) goto L10;
        b(r13, r11);
    L10:
        return this;
    L11:
        this.f = r15.p(r10, r11, r12, r13, r14);
        int r16 = r14[0];
        if (r16 != r12) goto L21;
        if (r13 != 0) goto L16;
        if (r16 == 0) goto L16;
        this.f9235c--;
    L19:
        this.d += (long) (r13 - r16);
    L16:
        if (r13 <= 0) goto L19;
        if (r16 != 0) goto L19;
        this.f9235c++;
    L21:
        return h();
    L22:
        if (r5 <= 0) goto L41;
        y9 r17 = this.g;
        if (r17 != null) goto L30;
        r14[0] = 0;
        if (r12 != 0) goto L29;
        if (r13 <= 0) goto L29;
        c(r13, r11);
    L29:
        return this;
    L30:
        this.g = r17.p(r10, r11, r12, r13, r14);
        int r18 = r14[0];
        if (r18 != r12) goto L40;
        if (r13 != 0) goto L35;
        if (r18 == 0) goto L35;
        this.f9235c--;
    L38:
        this.d += (long) (r13 - r18);
    L35:
        if (r13 <= 0) goto L38;
        if (r18 != 0) goto L38;
        this.f9235c++;
    L40:
        return h();
    L41:
        int r19 = this.f9234b;
        r14[0] = r19;
        if (r12 != r19) goto L47;
        if (r13 == 0) goto L45;
        this.d += (long) (r13 - r19);
        this.f9234b = r13;
        goto L47
    L45:
        return f();
    L47:
        return this;
    }

    public final y9 q(Comparator r5, Object r10, int r11, int[] r12) {
        int r13 = r5.compare(r10, this.f9233a);
        if (r13 >= 0) goto L21;
        y9 r14 = this.f;
        if (r14 != null) goto L10;
        r12[0] = 0;
        if (r11 <= 0) goto L9;
        b(r11, r10);
    L9:
        return this;
    L10:
        this.f = r14.q(r5, r10, r11, r12);
        if (r11 == 0) goto L13;
    L15:
        if (r11 > 0) goto L17;
    L19:
        this.d += (long) (r11 - r12[0]);
        return h();
    L17:
        if (r12[0] != 0) goto L19;
        this.f9235c++;
        goto L19
    L13:
        if (r12[0] == 0) goto L15;
        this.f9235c--;
        goto L19
    L21:
        if (r13 <= 0) goto L39;
        y9 r15 = this.g;
        if (r15 != null) goto L28;
        r12[0] = 0;
        if (r11 <= 0) goto L27;
        c(r11, r10);
    L27:
        return this;
    L28:
        this.g = r15.q(r5, r10, r11, r12);
        if (r11 == 0) goto L31;
    L33:
        if (r11 > 0) goto L35;
    L37:
        this.d += (long) (r11 - r12[0]);
        return h();
    L35:
        if (r12[0] != 0) goto L37;
        this.f9235c++;
        goto L37
    L31:
        if (r12[0] == 0) goto L33;
        this.f9235c--;
        goto L37
    L39:
        int r16 = this.f9234b;
        r12[0] = r16;
        if (r11 == 0) goto L42;
        this.d += (long) (r11 - r16);
        this.f9234b = r11;
        return this;
    L42:
        return f();
    }

    public final String toString() {
        int r5 = this.f9234b;
        return new Multisets$ImmutableEntry(this.f9233a, r5).toString();
    }

    public y9() {
        this.f9233a = null;
        this.f9234b = 1;
    }
}
