package com.alibaba.excel.support.asm;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    c f305b;
    private byte[] c;

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c[] f307b;

        a() {
            this.f307b = new c[6];
        }

        private boolean b(c r5) {
            int r1 = 0;
        L4:
            if (r1 >= this.f306a) goto L10;
            if (this.f307b[r1].f304a.equals(r5.f304a) == true) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        private void c(c r5) {
            int r0 = this.f306a;
            c[] r1 = this.f307b;
            if (r0 < r1.length) goto L5;
            c[] r2 = new c[r1.length + 6];
            System.arraycopy(r1, 0, r2, 0, r0);
            this.f307b = r2;
        L5:
            c[] r3 = this.f307b;
            int r4 = this.f306a;
            this.f306a = r4 + 1;
            r3[r4] = r5;
        }

        void a(c r2) {
        L2:
            if (r2 == null) goto L7;
            if (b(r2) == true) goto L6;
            c(r2);
        L6:
            r2 = r2.f305b;
            goto L2
        }

        c[] a() {
            int r0 = this.f306a;
            c[] r1 = new c[r0];
            System.arraycopy(this.f307b, 0, r1, 0, r0);
            return r1;
        }
    }

    public c(String r1) {
        this.f304a = r1;
    }

    static int a(z r2, int r3, int r4) {
        if ((r3 & 4096) != 0) goto L5;
    L7:
        int r0 = 0;
    L8:
        if (r4 == 0) goto L11;
        r2.c("Signature");
        r0 = r0 + 8;
    L11:
        if ((r3 & 131072) == 0) goto L14;
        r2.c("Deprecated");
        return r0 + 6;
    L14:
        return r0;
    L5:
        if (r2.b() >= 49) goto L7;
        r2.c("Synthetic");
        r0 = 6;
        goto L8
    }

    static void a(z r3, int r4, int r5, d r6) {
        if ((r4 & 4096) != 0) goto L5;
    L7:
        if (r5 == 0) goto L10;
        r6.b(r3.c("Signature")).c(2).b(r5);
    L10:
        if ((r4 & 131072) == 0) goto L13;
        r6.b(r3.c("Deprecated")).c(0);
        return;
    L13:
        return;
    L5:
        if (r3.b() >= 49) goto L7;
        r6.b(r3.c("Synthetic")).c(0);
        goto L7
    }

    final int a(z r7) {
        return a(r7, null, 0, -1, -1);
    }

    final int a(z r9, byte[] r10, int r11, int r12, int r13) {
        g r6 = r9.f341a;
        int r7 = 0;
    L3:
        if (this == null) goto L5;
        r9.c(this.f304a);
        r7 = r7 + (this.a(r6, r10, r11, r12, r13).f309b + 6);
        c this = this.f305b;
        goto L3
    L5:
        return r7;
    }

    public c a(e r1, int r2, int r3, char[] r4, int r5, q[] r6) {
        c r7 = new c(this.f304a);
        r7.c = new byte[r3];
        System.arraycopy(r1.c, r2, r7.c, 0, r3);
        return r7;
    }

    public d a(g r1, byte[] r2, int r3, int r4, int r5) {
        return new d(this.c);
    }

    final void a(z r8, d r9) {
        a(r8, null, 0, -1, -1, r9);
    }

    final void a(z r8, byte[] r9, int r10, int r11, int r12, d r13) {
        g r6 = r8.f341a;
    L3:
        if (this == null) goto L5;
        d r0 = this.a(r6, r9, r10, r11, r12);
        r13.b(r8.c(this.f304a)).c(r0.f309b);
        r13.a(r0.f308a, 0, r0.f309b);
        c this = this.f305b;
        goto L3
    }

    public boolean a() {
        return false;
    }

    final int b() {
        int r0 = 0;
    L3:
        if (this == null) goto L5;
        r0 = r0 + 1;
        c this = this.f305b;
        goto L3
    L5:
        return r0;
    }
}
