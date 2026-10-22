package com.tom_roush.pdfbox.contentstream.operator.a;

import android.util.Log;
import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class g extends com.tom_roush.pdfbox.contentstream.operator.c {
    public g() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "Tf";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r4, List<com.tom_roush.pdfbox.a.b> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6.size() < 2) goto L16;
        com.tom_roush.pdfbox.a.b r7 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r6.get(0), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.b r8 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r6.get(1), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, com.tom_roush.pdfbox.a.i.class) == true) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r8, com.tom_roush.pdfbox.a.k.class) == true) goto L10;
        return;
    L10:
        com.tom_roush.pdfbox.a.i r9 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r7, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        this.f16096a.g().b().e(((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r8, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a());
        com.tom_roush.pdfbox.pdmodel.font.p r10 = this.f16096a.getResources().a(r9);
        if (r10 != null) goto L13;
        Log.w("PdfBox-Android", "font '" + r9.a() + "' not found in resources");
    L13:
        this.f16096a.g().b().a(r10);
        return;
    L16:
        throw new MissingOperandException(r4, r6);
    }
}
