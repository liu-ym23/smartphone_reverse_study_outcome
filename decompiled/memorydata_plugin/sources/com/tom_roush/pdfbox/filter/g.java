package com.tom_roush.pdfbox.filter;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
final class g extends j {
    g() {
    }

    @Override // com.tom_roush.pdfbox.filter.j
    public i a(InputStream r7, OutputStream r8, com.tom_roush.pdfbox.a.d r9, int r10) {
        return a(r7, r8, r9, r10, h.f16105a);
    }

    @Override // com.tom_roush.pdfbox.filter.j
    public i a(InputStream r1, OutputStream r2, com.tom_roush.pdfbox.a.d r3, int r4, h r5) {
        com.tom_roush.pdfbox.io.a.a(r1, r2);
        return new i(r3);
    }
}
