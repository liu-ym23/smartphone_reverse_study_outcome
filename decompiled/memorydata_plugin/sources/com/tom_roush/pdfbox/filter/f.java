package com.tom_roush.pdfbox.filter;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
final class f extends j {
    f() {
    }

    @Override // com.tom_roush.pdfbox.filter.j
    public i a(InputStream r3, OutputStream r4, com.tom_roush.pdfbox.a.d r5, int r6) {
        com.tom_roush.pdfbox.a.i r2 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r5.a(com.tom_roush.pdfbox.a.i.fh), com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L9:
        new m().a(r3, r4, r5, r6);
        return new i(r5);
    L5:
        if (r2.equals(com.tom_roush.pdfbox.a.i.dL) == true) goto L9;
        throw new IOException("Unsupported crypt filter " + r2.a());
    }
}
