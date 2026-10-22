package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public final class r {
    static l a(com.tom_roush.pdfbox.a.d r3, y r4) {
        com.tom_roush.pdfbox.a.i r0 = r3.b(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.dc);
        if (com.tom_roush.pdfbox.a.i.dc.equals(r0) == false) goto L15;
        com.tom_roush.pdfbox.a.i r1 = r3.b(com.tom_roush.pdfbox.a.i.hT);
        if (com.tom_roush.pdfbox.a.i.aG.equals(r1) == false) goto L9;
        return new m(r3, r4);
    L9:
        if (com.tom_roush.pdfbox.a.i.aH.equals(r1) == false) goto L13;
        return new n(r3, r4);
    L13:
        throw new IOException("Invalid font type: " + r0);
    L15:
        throw new IOException("Expected 'Font' dictionary but found '" + r0.a() + "'");
    }

    public static p a(com.tom_roush.pdfbox.a.d r1) {
        return a(r1, null);
    }

    public static p a(com.tom_roush.pdfbox.a.d r6, com.tom_roush.pdfbox.pdmodel.k r7) {
        com.tom_roush.pdfbox.pdmodel.k r8 = (com.tom_roush.pdfbox.pdmodel.k) ZeusTransformUtils.wrapperContextForParams(r7, com.tom_roush.pdfbox.pdmodel.k.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.i r0 = r6.b(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.dc);
        if (com.tom_roush.pdfbox.a.i.dc.equals(r0) == true) goto L5;
        Log.e("PdfBox-Android", "Expected 'Font' dictionary but found '" + r0.a() + "'");
    L5:
        com.tom_roush.pdfbox.a.i r1 = r6.b(com.tom_roush.pdfbox.a.i.hT);
        if (com.tom_roush.pdfbox.a.i.iB.equals(r1) == false) goto L16;
        com.tom_roush.pdfbox.a.b r9 = r6.a(com.tom_roush.pdfbox.a.i.de);
        if (ZeusTransformUtils.instanceOf(r9, com.tom_roush.pdfbox.a.d.class) == false) goto L14;
        if (((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r9, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin")).m(com.tom_roush.pdfbox.a.i.di) == false) goto L14;
        return new z(r6);
    L14:
        return new aa(r6);
    L16:
        if (com.tom_roush.pdfbox.a.i.fd.equals(r1) == false) goto L26;
        com.tom_roush.pdfbox.a.b r10 = r6.a(com.tom_roush.pdfbox.a.i.de);
        if (ZeusTransformUtils.instanceOf(r10, com.tom_roush.pdfbox.a.d.class) == false) goto L24;
        if (((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r10, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin")).m(com.tom_roush.pdfbox.a.i.di) == false) goto L24;
        return new z(r6);
    L24:
        return new t(r6);
    L26:
        if (com.tom_roush.pdfbox.a.i.iv.equals(r1) == false) goto L30;
        return new x(r6);
    L30:
        if (com.tom_roush.pdfbox.a.i.iC.equals(r1) == false) goto L34;
        return new ad(r6, r8);
    L34:
        if (com.tom_roush.pdfbox.a.i.iA.equals(r1) == false) goto L38;
        return new y(r6);
    L38:
        if (com.tom_roush.pdfbox.a.i.aG.equals(r1) == true) goto L46;
        if (com.tom_roush.pdfbox.a.i.aH.equals(r1) == true) goto L44;
        Log.w("PdfBox-Android", "Invalid font subtype '" + r1 + "'");
        return new aa(r6);
    L44:
        throw new IOException("Type 2 descendant font not allowed");
    L46:
        throw new IOException("Type 0 descendant font not allowed");
    }
}
