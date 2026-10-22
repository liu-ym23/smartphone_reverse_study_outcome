package com.ctc.wstx.shaded.msv_core.util;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f3639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3640b;

    public Object a() {
        Object[] r0 = this.f3639a;
        int r1 = this.f3640b - 1;
        this.f3640b = r1;
        return r0[r1];
    }

    public void a(Object r5) {
        Object[] r0 = this.f3639a;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r1 = this.f3640b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        r0[r1] = r5;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.f3640b = r1 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return;
    L4:
        Object[] r2 = this.f3639a;
        Object[] r3 = new Object[r2.length * 2];
        System.arraycopy(r2, 0, r3, 0, r2.length);
        this.f3639a = r3;
        int r4 = this.f3640b;
        this.f3640b = r4 + 1;
        r3[r4] = r5;
    }

    public Object b() {
        return this.f3639a[this.f3640b - 1];
    }

    public int c() {
        return this.f3640b;
    }
}
