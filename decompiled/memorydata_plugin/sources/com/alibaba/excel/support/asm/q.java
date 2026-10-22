package com.alibaba.excel.support.asm;

import kotlin.UShort;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final q f328a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    short f329b;
    int c;
    short d;
    short e;
    short f;
    short g;
    n h;
    q i;
    k j;
    q k;
    private short l;
    private int[] m;
    private int[] n;

    static {
        f328a = new q();
    }

    public q() {
    }

    private void a(int r7, int r8, int r9) {
        if (this.n != null) goto L5;
        this.n = new int[6];
    L5:
        int[] r0 = this.n;
        int r3 = r0[0];
        if ((r3 + 2) < r0.length) goto L8;
        int[] r1 = new int[r0.length + 6];
        System.arraycopy(r0, 0, r1, 0, r0.length);
        this.n = r1;
    L8:
        int[] r6 = this.n;
        int r4 = r3 + 1;
        r6[r4] = r7;
        int r5 = r4 + 1;
        r6[r5] = r8 | r9;
        r6[0] = r5;
    }

    private q b(q r3) {
        k r0 = this.j;
    L3:
        if (r0 == null) goto L15;
        if ((this.f329b & 16) != 0) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L14;
        if (r0.f319b.k != null) goto L14;
        r0.f319b.k = r3;
        r3 = r0.f319b;
    L14:
        r0 = r0.c;
        goto L3
    L7:
        if (r0 != this.j.c) goto L9;
        r1 = true;
        goto L10
    L15:
        return r3;
    }

    final q a() {
        n r0 = this.h;
        if (r0 != null) goto L6;
        return this;
    L6:
        return r0.f322a;
    }

    final void a(int r6) {
        if (this.l != 0) goto L6;
        this.l = (short) r6;
        return;
    L6:
        if (this.m != null) goto L8;
        this.m = new int[4];
    L8:
        int[] r0 = this.m;
        int r3 = r0[0] + 1;
        r0[0] = r3;
        if (r3 < r0.length) goto L11;
        int[] r1 = new int[r0.length + 4];
        System.arraycopy(r0, 0, r1, 0, r0.length);
        this.m = r1;
    L11:
        this.m[r3] = r6;
    }

    final void a(d r3, int r4, boolean r5) {
        if ((this.f329b & 4) == 0) goto L5;
        int r2 = this.c - r4;
        if (r5 == false) goto L11;
        r3.c(r2);
        return;
    L11:
        r3.b(r2);
        return;
    L5:
        if (r5 == false) goto L7;
        a(r4, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING, r3.f309b);
        r3.c(-1);
        return;
    L7:
        a(r4, SQLiteDatabase.CREATE_IF_NECESSARY, r3.f309b);
        r3.b(-1);
    }

    final void a(q r7) {
        q r0 = f328a;
        this.k = r0;
    L4:
        if (this == f328a) goto L12;
        q r1 = this.k;
        this.k = r0;
        if ((this.f329b & 64) == 0) goto L10;
        if (this.g == r7.g) goto L10;
        this.j = new k(this.e, r7.j.f319b, this.j);
    L10:
        r0 = this;
        q this = this.b(r1);
    L12:
        if (r0 == f328a) goto L14;
        q r6 = r0.k;
        r0.k = null;
        r0 = r6;
        goto L12
    }

    final void a(r r3, boolean r4) {
        r3.a(this);
        if (r4 == false) goto L12;
        short r5 = this.l;
        if (r5 == 0) goto L14;
        r3.b(r5 & UShort.MAX_VALUE, this);
        if (this.m == null) goto L15;
        int r6 = 1;
    L9:
        int[] r0 = this.m;
        if (r6 > r0[0]) goto L16;
        r3.b(r0[r6], this);
        r6 = r6 + 1;
        goto L9
    L16:
        return;
    L15:
        return;
    L14:
        return;
    }

    final void a(short r3) {
        this.k = f328a;
    L4:
        if (this == f328a) goto L9;
        q r0 = this.k;
        this.k = null;
        if (this.g == 0) goto L7;
        q this = r0;
        goto L4
    L7:
        this.g = r3;
        this = this.b(r0);
        goto L4
    }

    final boolean a(byte[] r8, int r9) {
        this.f329b = (short) (this.f329b | 4);
        this.c = r9;
        int[] r0 = this.n;
        boolean r1 = false;
        if (r0 != null) goto L5;
        return false;
    L5:
        int r2 = r0[0];
    L6:
        if (r2 <= 0) goto L21;
        int[] r3 = this.n;
        int r4 = r3[r2 - 1];
        int r5 = r3[r2];
        int r6 = r9 - r4;
        int r7 = 268435455 & r5;
        if ((r5 & (-268435456)) == 268435456) goto L10;
        int r10 = r7 + 1;
        r8[r7] = (byte) (r6 >>> 24);
        int r11 = r10 + 1;
        r8[r10] = (byte) (r6 >>> 16);
        r8[r11] = (byte) (r6 >>> 8);
        r8[r11 + 1] = (byte) r6;
    L20:
        r2 = r2 - 2;
        goto L6
    L10:
        if (r6 >= (-32768)) goto L12;
    L13:
        int r12 = r8[r4] & 255;
        if (r12 >= 198) goto L16;
        r8[r4] = (byte) (r12 + 49);
    L17:
        r1 = true;
    L18:
        r8[r7] = (byte) (r6 >>> 8);
        r8[r7 + 1] = (byte) r6;
        goto L20
    L16:
        r8[r4] = (byte) (r12 + 20);
        goto L17
    L12:
        if (r6 <= 32767) goto L18;
    L21:
        return r1;
    }

    public String toString() {
        return com.tom_roush.pdfbox.pdmodel.a.d.i.u + System.identityHashCode(this);
    }
}
