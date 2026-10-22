package com.google.common.collect;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class q4 extends r4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f9131c;
    public int d;
    public int e;
    public int f;

    public q4(int r5) {
        super(r5);
        this.f9131c = null;
        this.d = 0;
        this.e = 0;
    }

    public static Object[] h(int r10, int r11, Object[] r12) {
        Object[] r5 = new Object[r10];
        int r13 = r10 - 1;
        int r14 = 0;
    L3:
        if (r14 >= r11) goto L9;
        Object r15 = r12[r14];
        Objects.requireNonNull(r15);
        int r16 = p7.n0(r15.hashCode());
    L5:
        int r17 = r16 & r13;
        if (r5[r17] == null) goto L7;
        r16 = r16 + 1;
        goto L5
    L7:
        r5[r17] = r15;
        r14 = r14 + 1;
        goto L3
    L9:
        return r5;
    }

    @Override // com.google.common.collect.r4
    public final r4 a(Object r5) {
        r5.getClass();
        if (this.f9131c != null) goto L11;
        if (this.f9146b != 0) goto L8;
        b(r5);
        return this;
    L8:
        f(this.f9145a.length);
        Object r10 = this.f9145a[0];
        this.f9146b--;
        return g(r10).a(r5);
    L11:
        return g(r5);
    }

    @Override // com.google.common.collect.r4
    public final ImmutableSet c() {
        int r5 = this.f9146b;
        if (r5 == 0) goto L15;
        if (r5 == 1) goto L12;
        Object[] r10 = this.f9145a;
        if (r5 == r10.length) goto L10;
        r10 = Arrays.copyOf(r10, r5);
    L10:
        int r11 = this.f;
        Object[] r12 = this.f9131c;
        Objects.requireNonNull(r12);
        return new RegularImmutableSet(r10, r11, r12, this.f9131c.length - 1);
    L12:
        Object r13 = this.f9145a[0];
        Objects.requireNonNull(r13);
        return ImmutableSet.of(r13);
    L15:
        return ImmutableSet.of();
    }

    @Override // com.google.common.collect.r4
    public final r4 d() {
        q4 r5 = new q4(this);
        Object[] r10 = this.f9131c;
        if (r10 != null) goto L5;
        Object[] r11 = null;
    L6:
        r5.f9131c = r11;
        r5.d = this.d;
        r5.e = this.e;
        r5.f = this.f;
        return r5;
    L5:
        r11 = (Object[]) r10.clone();
        goto L6
    }

    @Override // com.google.common.collect.r4
    public final r4 e() {
        if (this.f9131c != null) goto L5;
        return this;
    L5:
        int r5 = ImmutableSet.chooseTableSize(this.f9146b);
        if ((r5 * 2) >= this.f9131c.length) goto L8;
        this.f9131c = h(r5, this.f9146b, this.f9145a);
        this.d = com.lynx.tasm.utils.g.k(r5, RoundingMode.UNNECESSARY) * 13;
        this.e = (int) (((double) r5) * 0.7d);
    L8:
        Object[] r10 = this.f9131c;
        int r11 = com.lynx.tasm.utils.g.k(r10.length, RoundingMode.UNNECESSARY) * 13;
        int r12 = r10.length - 1;
        int r13 = 0;
        int r14 = 0;
    L10:
        if (r13 >= r10.length) goto L36;
        if (r13 != r14) goto L19;
        if (r10[r13] != null) goto L19;
        r14 = r13 + r11;
        if (r10[(r14 - 1) & r12] == null) goto L18;
        r14 = r13 + 1;
    L18:
        r13 = r14;
    L19:
        int r15 = r13 + r11;
        int r16 = r15 - 1;
    L20:
        if (r16 < r14) goto L26;
        if (r10[r16 & r12] == null) goto L23;
        r16 = r16 - 1;
        goto L20
    L23:
        r14 = r15;
        r13 = r16 + 1;
        goto L10
    L26:
        return new p4(this);
    L36:
        return this;
    }

    public final void f(int r5) {
        Object[] r10 = this.f9131c;
        if (r10 != null) goto L6;
        int r11 = ImmutableSet.chooseTableSize(r5);
        this.f9131c = new Object[r11];
    L10:
        this.d = com.lynx.tasm.utils.g.k(r11, RoundingMode.UNNECESSARY) * 13;
        this.e = (int) (((double) r11) * 0.7d);
        return;
    L6:
        if (r5 > this.e) goto L8;
        return;
    L8:
        if (r10.length >= 1073741824) goto L13;
        r11 = r10.length * 2;
        Object[] r12 = this.f9145a;
        this.f9131c = h(r11, this.f9146b, r12);
        goto L10
    }

    public final r4 g(Object r10) {
        Objects.requireNonNull(this.f9131c);
        int r5 = r10.hashCode();
        int r11 = p7.n0(r5);
        int r12 = this.f9131c.length - 1;
        int r13 = r11;
    L4:
        if ((r13 - r11) >= this.d) goto L13;
        int r14 = r13 & r12;
        Object r15 = this.f9131c[r14];
        if (r15 == null) goto L7;
        if (r15.equals(r10) == true) goto L11;
        r13 = r13 + 1;
        goto L4
    L11:
        return this;
    L7:
        b(r10);
        this.f9131c[r14] = r10;
        this.f += r5;
        f(this.f9146b);
        return this;
    L13:
        p4 r16 = new p4(this);
        r16.a(r10);
        return r16;
    }
}
