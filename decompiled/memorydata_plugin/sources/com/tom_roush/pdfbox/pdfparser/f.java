package com.tom_roush.pdfbox.pdfparser;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class f extends b {
    public f(com.tom_roush.pdfbox.io.g r3, String r4, InputStream r5, String r6, com.tom_roush.pdfbox.io.i r7) {
        com.tom_roush.pdfbox.io.g r8 = (com.tom_roush.pdfbox.io.g) ZeusTransformUtils.wrapperContextForParams(r3, com.tom_roush.pdfbox.io.g.class, "com.obric.memorydata.plugin");
        super(r8, r4, r5, r6);
        this.g = r8.b();
        a(r7);
    }

    private void a(com.tom_roush.pdfbox.io.i r4) {
        String r0 = System.getProperty("com.tom_roush.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange");
        if (r0 != null) goto L9;
    L7:
        this.c = new com.tom_roush.pdfbox.a.e(r4);
        return;
    L9:
        g(Integer.parseInt(r0));     // Catch: NumberFormatException -> L6
    L6:
        Log.w("PdfBox-Android", "System property com.tom_roush.pdfbox.pdfparser.nonSequentialPDFParser.eofLookupRange does not contain an integer value, but: '" + r0 + "'");
        goto L7
    }

    public com.tom_roush.pdfbox.pdmodel.c A() {
        com.tom_roush.pdfbox.pdmodel.c r0 = new com.tom_roush.pdfbox.pdmodel.c(x(), this.d, z());
        r0.a(y());
        return r0;
    }

    public void B() {
        com.tom_roush.pdfbox.a.d r0 = r();
        com.tom_roush.pdfbox.a.b r1 = d(r0);
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.d.class) == false) goto L19;
        com.tom_roush.pdfbox.a.d r2 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        if (t() == true) goto L7;
    L9:
        a(r2, (com.tom_roush.pdfbox.a.i[]) ZeusTransformUtils.preCheckCast(null, com.tom_roush.pdfbox.a.i[].class, "com.obric.memorydata.plugin"));
        com.tom_roush.pdfbox.a.b r3 = r0.a(com.tom_roush.pdfbox.a.i.dV);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.d.class) == false) goto L12;
        a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"), (com.tom_roush.pdfbox.a.i[]) ZeusTransformUtils.preCheckCast(null, com.tom_roush.pdfbox.a.i[].class, "com.obric.memorydata.plugin"));
    L12:
        b(r2);
        if (ZeusTransformUtils.instanceOf(r2.a(com.tom_roush.pdfbox.a.i.ga), com.tom_roush.pdfbox.a.d.class) == false) goto L17;
        this.c.a();
        this.h = true;
        return;
    L17:
        throw new IOException("Page tree root must be a dictionary");
    L7:
        if (r2.m(com.tom_roush.pdfbox.a.i.iz) == true) goto L9;
        r2.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.au);
        goto L9
    L19:
        throw new IOException("Expected root dictionary, but got this: " + r1);
    }

    public void C() {
    L13:
        th = move-exception;
        if (this.c == null) goto L17;
        com.tom_roush.pdfbox.io.a.a(this.c);
        this.c = null;
    L17:
        throw th;
    L3:
        if (v() == true) goto L10;
        if (w() == true) goto L10;
        throw new IOException("Error: Header doesn't contain versioninfo");     // Catch: Throwable -> L13
    L10:
        if (this.h == true) goto L19;
        B();     // Catch: Throwable -> L13
        return;
    }
}
