package com.google.common.collect;

import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class p4 extends r4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f9119c;

    public p4(r4 r5) {
        super(r5);
        this.f9119c = p7.Y(this.f9146b);
        int r10 = 0;
    L4:
        if (r10 >= this.f9146b) goto L6;
        HashSet r11 = this.f9119c;
        Object r12 = this.f9145a[r10];
        Objects.requireNonNull(r12);
        r11.add(r12);
        r10 = r10 + 1;
        goto L4
    }

    @Override // com.google.common.collect.r4
    public final r4 a(Object r5) {
        r5.getClass();
        if (this.f9119c.add(r5) == false) goto L5;
        b(r5);
    L5:
        return this;
    }

    @Override // com.google.common.collect.r4
    public final ImmutableSet c() {
        int r5 = this.f9146b;
        if (r5 == 0) goto L11;
        if (r5 != 1) goto L7;
        Object r10 = this.f9145a[0];
        Objects.requireNonNull(r10);
        return ImmutableSet.of(r10);
    L7:
        return new JdkBackedImmutableSet(this.f9119c, ImmutableList.asImmutableList(this.f9145a, this.f9146b));
    L11:
        return ImmutableSet.of();
    }

    @Override // com.google.common.collect.r4
    public final r4 d() {
        return new p4(this);
    }
}
