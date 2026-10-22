package com.tom_roush.pdfbox.pdmodel.interactive.annotation;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16290a;

    public a() {
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        this.f16290a = r0;
        r0.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.u);
    }

    public a(com.tom_roush.pdfbox.a.d r2) {
        this.f16290a = r2;
        com.tom_roush.pdfbox.a.b r1 = r2.a(com.tom_roush.pdfbox.a.i.iz);
        if (r1 != null) goto L6;
        r2.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.u);
        return;
    L6:
        if (com.tom_roush.pdfbox.a.i.u.equals(r1) == true) goto L10;
        Log.w("PdfBox-Android", "Annotation has type " + r1 + ", further mayhem may follow");
        return;
    }

    public static a a(com.tom_roush.pdfbox.a.b r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.d.class) == false) goto L58;
        com.tom_roush.pdfbox.a.d r4 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        String r0 = r4.g(com.tom_roush.pdfbox.a.i.hT);
        if ("FileAttachment".equals(r0) == false) goto L8;
        return new b(r4);
    L8:
        if ("Line".equals(r0) == false) goto L11;
        return new c(r4);
    L11:
        if (com.tom_roush.pdfbox.pdmodel.a.d.i.L.equals(r0) == false) goto L14;
        return new d(r4);
    L14:
        if ("Popup".equals(r0) == false) goto L17;
        return new f(r4);
    L17:
        if ("Stamp".equals(r0) == false) goto L20;
        return new g(r4);
    L20:
        if (com.tom_roush.pdfbox.pdmodel.a.d.e.i.equals(r0) == true) goto L56;
        if (com.tom_roush.pdfbox.pdmodel.a.d.e.c.equals(r0) == true) goto L56;
        if ("Text".equals(r0) == false) goto L28;
        return new i(r4);
    L28:
        if ("Highlight".equals(r0) == true) goto L68;
        if (com.tom_roush.pdfbox.pdmodel.a.d.d.Q.equals(r0) == true) goto L68;
        if ("Squiggly".equals(r0) == true) goto L68;
        if ("StrikeOut".equals(r0) == true) goto L68;
        if ("Widget".equals(r0) == false) goto L40;
        return new l(r4);
    L40:
        if ("FreeText".equals(r0) == true) goto L67;
        if ("Polygon".equals(r0) == true) goto L67;
        if ("PolyLine".equals(r0) == true) goto L67;
        if ("Caret".equals(r0) == true) goto L67;
        if ("Ink".equals(r0) == true) goto L67;
        if ("Sound".equals(r0) == true) goto L67;
        k r1 = new k(r4);
        Log.d("PdfBox-Android", "Unknown or unsupported annotation subtype " + r0);
        return r1;
    L67:
        return new e(r4);
    L68:
        return new j(r4);
    L56:
        return new h(r4);
    L58:
        throw new IOException("Error: Unknown annotation type " + r3);
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16290a;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }

    public boolean equals(Object r3) {
        if (r3 != this) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L11;
        return false;
    L11:
        return ((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin")).a().equals(a());
    }

    public int hashCode() {
        return this.f16290a.hashCode();
    }
}
