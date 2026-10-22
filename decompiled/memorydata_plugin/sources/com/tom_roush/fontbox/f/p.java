package com.tom_roush.fontbox.f;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public class p extends af {
    private o[] c;

    p(ah r1) {
        super(r1);
    }

    @Override // com.tom_roush.fontbox.f.af
    void a(ah r6, ad r7) {
        int r8 = r7.d();
        if (r8 == 0) goto L5;
        r8 = (r8 << 16) | r7.d();
    L5:
        int r0 = 0;
        if (r8 != 0) goto L8;
        int r2 = r7.d();
    L11:
        if (r2 <= 0) goto L15;
        this.c = new o[r2];
    L13:
        if (r0 >= r2) goto L15;
        o r3 = new o();
        r3.a(r7, r8);
        this.c[r0] = r3;
        r0 = r0 + 1;
    L15:
        this.f15974a = true;
        return;
    L8:
        if (r8 != 1) goto L10;
        r2 = (int) r7.k();
        goto L11
    L10:
        Log.d("PdfBox-Android", "Skipped kerning table due to an unsupported kerning table version: " + r8);
        r2 = 0;
        goto L11
    }
}
