package com.google.common.collect;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class n4 extends p7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r4 f9087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9088c;

    public n4(int r5) {
        if (r5 <= 0) goto L5;
        this.f9087b = new q4(r5);
        return;
    L5:
        this.f9087b = o4.f9101c;
    }

    public n4 B0(Object r5) {
        Objects.requireNonNull(this.f9087b);
        r5.getClass();
        if (this.f9088c == false) goto L5;
        E0();
        this.f9088c = false;
    L5:
        this.f9087b = this.f9087b.a(r5);
        return this;
    }

    public ImmutableSet C0() {
        Objects.requireNonNull(this.f9087b);
        this.f9088c = true;
        r4 r5 = this.f9087b.e();
        this.f9087b = r5;
        return r5.c();
    }

    public n4 D0(n4 r5) {
        Objects.requireNonNull(this.f9087b);
        Objects.requireNonNull(r5.f9087b);
        int r10 = 0;
        if (this.f9088c == false) goto L5;
        E0();
        this.f9088c = false;
    L5:
        r4 r11 = this.f9087b;
        r4 r12 = r5.f9087b;
        r11.getClass();
    L7:
        if (r10 >= r12.f9146b) goto L9;
        Object r13 = r12.f9145a[r10];
        Objects.requireNonNull(r13);
        r11 = r11.a(r13);
        r10 = r10 + 1;
        goto L7
    L9:
        this.f9087b = r11;
        return this;
    }

    public void E0() {
        Objects.requireNonNull(this.f9087b);
        this.f9087b = this.f9087b.d();
    }

    @Override // com.google.common.collect.p7
    public /* bridge */ /* synthetic */ p7 g(Object r5) {
        return B0(r5);
    }
}
