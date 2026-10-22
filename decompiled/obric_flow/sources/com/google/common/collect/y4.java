package com.google.common.collect;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class y4 extends n4 {
    public final Comparator d;
    public Object[] e;
    public int f;

    public y4(Comparator r5) {
        this.f9087b = null;
        r5.getClass();
        this.d = r5;
        this.e = new Object[4];
        this.f = 0;
    }

    @Override // com.google.common.collect.n4
    public final /* bridge */ /* synthetic */ n4 B0(Object r5) {
        F0(r5);
        return this;
    }

    @Override // com.google.common.collect.n4
    public final /* bridge */ /* synthetic */ ImmutableSet C0() {
        return G0();
    }

    @Override // com.google.common.collect.n4
    public final n4 D0(n4 r5) {
        int r10 = 0;
        if (this.f9088c == false) goto L5;
        E0();
        this.f9088c = false;
    L5:
        y4 r11 = (y4) r5;
    L7:
        if (r10 >= r11.f) goto L9;
        F0(r11.e[r10]);
        r10 = r10 + 1;
        goto L7
    L9:
        return this;
    }

    @Override // com.google.common.collect.n4
    public final void E0() {
        Object[] r5 = this.e;
        this.e = Arrays.copyOf(r5, r5.length);
    }

    public final void F0(Object r5) {
        r5.getClass();
        if (this.f9088c == false) goto L6;
        E0();
        this.f9088c = false;
    L6:
        if (this.f != this.e.length) goto L10;
        H0();
        int r10 = this.f;
        int r11 = p7.B(r10, r10 + 1);
        Object[] r12 = this.e;
        if (r11 <= r12.length) goto L10;
        this.e = Arrays.copyOf(r12, r11);
    L10:
        Object[] r13 = this.e;
        int r14 = this.f;
        this.f = r14 + 1;
        r13[r14] = r5;
    }

    public final ImmutableSortedSet G0() {
        H0();
        int r5 = this.f;
        Comparator r10 = this.d;
        if (r5 == 0) goto L5;
        this.f9088c = true;
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(this.e, this.f), r10);
    L5:
        return ImmutableSortedSet.emptySet(r10);
    }

    public final void H0() {
        int r5 = this.f;
        if (r5 != 0) goto L5;
        return;
    L5:
        Object[] r10 = this.e;
        Comparator r11 = this.d;
        Arrays.sort(r10, 0, r5, r11);
        int r12 = 1;
        int r13 = 1;
    L6:
        int r14 = this.f;
        if (r12 >= r14) goto L15;
        Object[] r15 = this.e;
        int r16 = r11.compare(r15[r13 - 1], r15[r12]);
        if (r16 >= 0) goto L11;
        Object[] r17 = this.e;
        r17[r13] = r17[r12];
        r13 = r13 + 1;
    L12:
        r12 = r12 + 1;
        goto L6
    L11:
        if (r16 <= 0) goto L12;
        String r18 = String.valueOf(r11);
        throw new AssertionError(androidx.room.jarjarred.org.antlr.runtime.a.m(r18.length() + 48, "Comparator ", r18, " compare method violates its contract"));
    L15:
        Arrays.fill(this.e, r13, r14, null);
        this.f = r13;
    }

    @Override // com.google.common.collect.n4, com.google.common.collect.p7
    public final /* bridge */ /* synthetic */ p7 g(Object r5) {
        F0(r5);
        return this;
    }
}
