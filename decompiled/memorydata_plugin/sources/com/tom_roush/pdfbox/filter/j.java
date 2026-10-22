package com.tom_roush.pdfbox.filter;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public abstract class j {
    public j() {
    }

    public com.tom_roush.pdfbox.a.d a(com.tom_roush.pdfbox.a.d r3, int r4) {
        com.tom_roush.pdfbox.a.b r2 = r3.a(com.tom_roush.pdfbox.a.i.cL, com.tom_roush.pdfbox.a.i.cT);
        com.tom_roush.pdfbox.a.b r5 = r3.a(com.tom_roush.pdfbox.a.i.ci, com.tom_roush.pdfbox.a.i.by);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.i.class) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.d.class) == false) goto L9;
        return (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
    L9:
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.a.class) == true) goto L11;
    L18:
        if (r5 != null) goto L20;
    L25:
        return new com.tom_roush.pdfbox.a.d();
    L20:
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.a.class) == true) goto L25;
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.a.class) == true) goto L25;
        Log.e("PdfBox-Android", "Expected DecodeParams to be an Array or Dictionary but found " + r5.getClass().getName());
        goto L25
    L11:
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.a.class) == false) goto L18;
        com.tom_roush.pdfbox.a.a r6 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r4 >= r6.b()) goto L25;
        com.tom_roush.pdfbox.a.b r7 = r6.a(r4);
        if (ZeusTransformUtils.instanceOf(r7, com.tom_roush.pdfbox.a.d.class) == false) goto L25;
        return (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r7, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
    }

    public abstract i a(InputStream r1, OutputStream r2, com.tom_roush.pdfbox.a.d r3, int r4);

    public i a(InputStream r1, OutputStream r2, com.tom_roush.pdfbox.a.d r3, int r4, h r5) {
        return a(r1, r2, r3, r4);
    }
}
