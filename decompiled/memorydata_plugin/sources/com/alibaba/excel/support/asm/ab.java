package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f303b;

    ab(byte[] r1, int r2) {
        this.f302a = r1;
        this.f303b = r2;
    }

    static void a(ab r2, d r3) {
        if (r2 != null) goto L4;
        r3.a(0);
        return;
    L4:
        byte[] r0 = r2.f302a;
        int r4 = r2.f303b;
        r3.a(r0, r4, (r0[r4] * 2) + 1);
    }

    public int a() {
        return this.f302a[this.f303b];
    }

    public int a(int r2) {
        return this.f302a[(this.f303b + (r2 * 2)) + 1];
    }

    public int b(int r2) {
        return this.f302a[(this.f303b + (r2 * 2)) + 2];
    }

    public String toString() {
        int r0 = a();
        StringBuilder r1 = new StringBuilder(r0 * 2);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L21;
        int r3 = a(r2);
        if (r3 != 0) goto L7;
        char r4 = '[';
    L18:
        r1.append(r4);
    L19:
        r2 = r2 + 1;
        goto L3
    L7:
        if (r3 != 1) goto L9;
        r4 = '.';
        goto L18
    L9:
        if (r3 != 2) goto L11;
        r4 = '*';
        goto L18
    L11:
        if (r3 != 3) goto L14;
        r1.append(b(r2)).append(';');
        goto L19
    L14:
        throw new AssertionError();
    L21:
        return r1.toString();
    }
}
