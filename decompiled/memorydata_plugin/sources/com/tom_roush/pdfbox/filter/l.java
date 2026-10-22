package com.tom_roush.pdfbox.filter;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes6.dex */
final class l extends j {
    l() {
    }

    private void a(InputStream r7, OutputStream r8) {
        byte[] r6 = new byte[2048];
        r7.read();
        r7.read();
        int r0 = r7.read(r6);
        if (r0 <= 0) goto L25;
        Inflater r1 = new Inflater(true);
        r1.setInput(r6, 0, r0);
        byte[] r2 = new byte[1024];
        boolean r4 = false;
    L27:
        int r5 = r1.inflate(r2);     // Catch: Throwable -> L16 DataFormatException -> L18
        if (r5 != 0) goto L7;
        if (r1.finished() == true) goto L21;
        if (r1.needsDictionary() == true) goto L21;
        if (r7.available() == 0) goto L21;
        r1.setInput(r6, 0, r7.read(r6));     // Catch: Throwable -> L16
    L21:
        r1.end();
        goto L25
    L7:
        r8.write(r2, 0, r5);     // Catch: Throwable -> L16
        r4 = true;
        goto L27
    L18:
        e = move-exception;
        if (r4 == false) goto L22;
        Log.w("PdfBox-Android", "FlateFilter: premature end of stream due to a DataFormatException");     // Catch: Throwable -> L16
        goto L21
    L22:
        throw e;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r1.end();
        throw th;
    L25:
        r8.flush();
    }

    @Override // com.tom_roush.pdfbox.filter.j
    public i a(InputStream r1, OutputStream r2, com.tom_roush.pdfbox.a.d r3, int r4) {
        a(r1, p.a(r2, a(r3, r4)));     // Catch: DataFormatException -> L6
        return new i(r3);
    L6:
        e = move-exception;
        Log.e("PdfBox-Android", "FlateFilter: stop reading corrupt stream due to a DataFormatException");
        throw new IOException(e);
    }
}
