package com.tom_roush.pdfbox.contentstream.operator;

import android.util.Log;
import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.pdmodel.graphics.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class a extends c {
    public a() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "Do";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(b r3, List<com.tom_roush.pdfbox.a.b> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == true) goto L27;
        com.tom_roush.pdfbox.a.b r6 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r5.get(0), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, i.class) == true) goto L7;
        return;
    L7:
        i r7 = (i) ZeusTransformUtils.preCheckCast(r6, i.class, "com.obric.memorydata.plugin");
        if (this.f16096a.getResources().e(r7) == false) goto L10;
        return;
    L10:
        d r8 = this.f16096a.getResources().f(r7);
        if (ZeusTransformUtils.instanceOf(r8, com.tom_roush.pdfbox.pdmodel.graphics.c.a.class) == true) goto L28;
        return;
    L28:
        this.f16096a.k();     // Catch: Throwable -> L22
        if (this.f16096a.j() <= 50) goto L18;
        Log.e("PdfBox-Android", "recursion is too deep, skipping form XObject");     // Catch: Throwable -> L22
        this.f16096a.l();
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r8, com.tom_roush.pdfbox.pdmodel.graphics.c.b.class) == false) goto L20;
        this.f16096a.a((com.tom_roush.pdfbox.pdmodel.graphics.c.b) ZeusTransformUtils.preCheckCast(r8, com.tom_roush.pdfbox.pdmodel.graphics.c.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
    L21:
        this.f16096a.l();
        return;
    L20:
        this.f16096a.a((com.tom_roush.pdfbox.pdmodel.graphics.c.a) ZeusTransformUtils.preCheckCast(r8, com.tom_roush.pdfbox.pdmodel.graphics.c.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.f16096a.l();
        throw th;
    L27:
        throw new MissingOperandException(r3, r5);
    }
}
