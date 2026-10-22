package com.tom_roush.pdfbox.filter;

import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
final class c extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f16099a = null;

    static {
        f16099a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    c() {
    }

    private boolean a(int r1) {
        if (r1 != 0) goto L4;
    L15:
        return true;
    L4:
        if (r1 == 9) goto L15;
        if (r1 == 10) goto L15;
        if (r1 == 12) goto L15;
        if (r1 == 13) goto L15;
        if (r1 == 32) goto L15;
        return false;
    }

    private boolean b(int r1) {
        if (r1 != 62) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.tom_roush.pdfbox.filter.j
    public i a(InputStream r8, OutputStream r9, com.tom_roush.pdfbox.a.d r10, int r11) {
    L2:
        int r12 = r8.read();
        if (r12 == (-1)) goto L24;
    L5:
        if (a(r12) == false) goto L7;
        r12 = r8.read();
        goto L5
    L7:
        if (r12 == (-1)) goto L24;
        if (b(r12) == true) goto L24;
        int[] r1 = f16099a;
        if (r1[r12] != (-1)) goto L14;
        Log.e("PdfBox-Android", "Invalid hex, int: " + r12 + " char: " + ((char) r12));
    L14:
        int r13 = r1[r12] * 16;
        int r2 = r8.read();
        if (r2 == (-1)) goto L23;
        if (b(r2) == true) goto L23;
        if (r1[r2] != (-1)) goto L22;
        Log.e("PdfBox-Android", "Invalid hex, int: " + r2 + " char: " + ((char) r2));
    L22:
        r9.write(r13 + r1[r2]);
    L23:
        r9.write(r13);
    L24:
        r9.flush();
        return new i(r10);
    }
}
