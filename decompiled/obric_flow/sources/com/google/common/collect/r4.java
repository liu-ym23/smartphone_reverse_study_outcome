package com.google.common.collect;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f9145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9146b;

    public r4(int r5) {
        this.f9145a = new Object[r5];
        this.f9146b = 0;
    }

    public abstract r4 a(Object r5);

    public final void b(Object r5) {
        int r10 = this.f9146b + 1;
        Object[] r11 = this.f9145a;
        if (r10 <= r11.length) goto L5;
        int r12 = p7.B(r11.length, r10);
        this.f9145a = Arrays.copyOf(this.f9145a, r12);
    L5:
        Object[] r13 = this.f9145a;
        int r14 = this.f9146b;
        this.f9146b = r14 + 1;
        r13[r14] = r5;
    }

    public abstract ImmutableSet c();

    public abstract r4 d();

    public r4 e() {
        return this;
    }

    public r4(r4 r5) {
        Object[] r10 = r5.f9145a;
        this.f9145a = Arrays.copyOf(r10, r10.length);
        this.f9146b = r5.f9146b;
    }
}
