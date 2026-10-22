package com.tom_roush.fontbox.f;

import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class z extends af {
    private float c;
    private float d;
    private short e;
    private short f;
    private long g;
    private long h;
    private long i;
    private long j;
    private long k;
    private String[] l;

    z(ah r1) {
        super(r1);
        this.l = null;
    }

    public String a(int r2) {
        if (r2 < 0) goto L10;
        String[] r1 = this.l;
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r2 < r1.length) goto L9;
        return null;
    L9:
        return r1[r2];
    L10:
        return null;
    }

    @Override // com.tom_roush.fontbox.f.af
    void a(ah r12, ad r13) {
        this.c = r13.h();
        this.d = r13.h();
        this.e = r13.e();
        this.f = r13.e();
        this.g = r13.k();
        this.h = r13.k();
        this.i = r13.k();
        this.j = r13.k();
        this.k = r13.k();
        float r0 = this.c;
        int r2 = 0;
        if (r0 != 1.0f) goto L6;
        this.l = new String[258];
        System.arraycopy(al.f15980a, 0, this.l, 0, 258);
    L54:
        this.f15974a = true;
        return;
    L6:
        if (r0 != 2.0f) goto L36;
        int r14 = r13.d();
        int[] r1 = new int[r14];
        this.l = new String[r14];
        int r3 = Integer.MIN_VALUE;
        int r6 = 0;
    L9:
        if (r6 >= r14) goto L14;
        int r8 = r13.d();
        r1[r6] = r8;
        if (r8 > 32767) goto L13;
        r3 = Math.max(r3, r8);
    L13:
        r6 = r6 + 1;
        goto L9
    L14:
        String[] r7 = null;
        if (r3 < 258) goto L25;
        int r4 = (r3 - 258) + 1;
        r7 = new String[r4];
        int r9 = 0;
    L17:
        if (r9 >= r4) goto L25;
        r7[r9] = r13.a(r13.j());     // Catch: IOException -> L21
        r9 = r9 + 1;
    L21:
        e = move-exception;
        Log.w("PdfBox-Android", "Error reading names in PostScript table at entry " + r9 + " of " + r4 + ", setting remaining entries to .notdef", e);
    L23:
        if (r9 >= r4) goto L25;
        r7[r9] = ".notdef";
        r9 = r9 + 1;
    L25:
        if (r2 >= r14) goto L54;
        int r15 = r1[r2];
        if (r15 < 0) goto L30;
        if (r15 >= 258) goto L30;
        this.l[r2] = al.f15980a[r15];
    L34:
        r2 = r2 + 1;
    L30:
        if (r15 < 258) goto L33;
        if (r15 > 32767) goto L33;
        this.l[r2] = r7[r15 - 258];
    L33:
        this.l[r2] = ".undefined";
        goto L34
    L36:
        if (r0 != 2.5f) goto L52;
        int r16 = r12.u();
        int[] r5 = new int[r16];
        int r10 = 0;
    L38:
        if (r10 >= r16) goto L40;
        int r11 = r10 + 1;
        r5[r10] = r13.i() + r11;
        r10 = r11;
        goto L38
    L40:
        this.l = new String[r16];
    L42:
        if (r2 >= this.l.length) goto L54;
        int r17 = r5[r2];
        if (r17 < 0) goto L49;
        if (r17 >= 258) goto L49;
        String r18 = al.f15980a[r17];
        if (r18 == null) goto L50;
        this.l[r2] = r18;
    L50:
        r2 = r2 + 1;
    L49:
        Log.d("PdfBox-Android", "incorrect glyph name index " + r17 + ", valid numbers 0..258");
        goto L50
    L52:
        if (r0 != 3.0f) goto L54;
        Log.d("PdfBox-Android", "No PostScript name information is provided for the font " + this.f15975b.b());
        goto L54
    }

    public String[] a() {
        return this.l;
    }
}
