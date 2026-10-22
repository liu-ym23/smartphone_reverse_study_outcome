package com.tom_roush.pdfbox.filter;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
final class m extends j {
    m() {
    }

    @Override // com.tom_roush.pdfbox.filter.j
    public i a(InputStream r1, OutputStream r2, com.tom_roush.pdfbox.a.d r3, int r4) {
        com.tom_roush.pdfbox.io.a.a(r1, r2);
        r2.flush();
        return new i(r3);
    }
}
