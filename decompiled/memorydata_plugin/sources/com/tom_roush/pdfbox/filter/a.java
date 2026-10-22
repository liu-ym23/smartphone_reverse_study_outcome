package com.tom_roush.pdfbox.filter;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
final class a extends j {
    a() {
    }

    @Override // com.tom_roush.pdfbox.filter.j
    public i a(InputStream r1, OutputStream r2, com.tom_roush.pdfbox.a.d r3, int r4) {
        b r5 = new b(r1);     // Catch: Throwable -> L9
        com.tom_roush.pdfbox.io.a.a(r5, r2);     // Catch: Throwable -> L7
        r2.flush();     // Catch: Throwable -> L7
        com.tom_roush.pdfbox.io.a.a(r5);
        return new i(r3);
    L7:
        Throwable th = th;
    L11:
        com.tom_roush.pdfbox.io.a.a(r5);
        throw th;
    L9:
        th = move-exception;
        r5 = null;
        th = th;
        goto L11
    }
}
