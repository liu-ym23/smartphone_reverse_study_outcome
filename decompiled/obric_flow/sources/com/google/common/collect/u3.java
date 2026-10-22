package com.google.common.collect;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class u3 extends p7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f9179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9180c;
    public boolean d;

    public u3(int r5) {
        this.f9179b = new Object[r5];
        this.f9180c = 0;
    }

    public final void B0(Object r5) {
        r5.getClass();
        E0(this.f9180c + 1);
        Object[] r10 = this.f9179b;
        int r11 = this.f9180c;
        this.f9180c = r11 + 1;
        r10[r11] = r5;
    }

    public final void C0(ImmutableList r5) {
        r5.getClass();
        int r10 = this.f9180c;
        E0(r5.size() + r10);
        this.f9180c = r5.copyIntoArray(this.f9179b, this.f9180c);
    }

    public final ImmutableList D0() {
        this.d = true;
        return ImmutableList.asImmutableList(this.f9179b, this.f9180c);
    }

    public final void E0(int r5) {
        Object[] r10 = this.f9179b;
        if (r10.length >= r5) goto L6;
        this.f9179b = Arrays.copyOf(r10, p7.B(r10.length, r5));
        this.d = false;
        return;
    L6:
        if (this.d == false) goto L10;
        this.f9179b = Arrays.copyOf(r10, r10.length);
        this.d = false;
        return;
    }

    @Override // com.google.common.collect.p7
    public final /* bridge */ /* synthetic */ p7 g(Object r5) {
        B0(r5);
        return this;
    }
}
