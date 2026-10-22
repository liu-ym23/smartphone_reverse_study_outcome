package com.tom_roush.pdfbox.contentstream.operator.a;

import android.util.Log;
import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class c extends com.tom_roush.pdfbox.contentstream.operator.c {
    public c() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "Td";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r10, List<com.tom_roush.pdfbox.a.b> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if (r12.size() < 2) goto L17;
        com.tom_roush.pdfbox.util.c r13 = this.f16096a.h();
        if (r13 != null) goto L8;
        Log.w("PdfBox-Android", "TextLineMatrix is null, " + a() + " operator will be ignored");
        return;
    L8:
        com.tom_roush.pdfbox.a.b r0 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r12.get(0), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.b r14 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r12.get(1), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.k.class) == true) goto L12;
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r14, com.tom_roush.pdfbox.a.k.class) == true) goto L14;
        return;
    L14:
        r13.a(new com.tom_roush.pdfbox.util.c(1.0f, 0.0f, 0.0f, 1.0f, ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a(), ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r14, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a()));
        this.f16096a.b(r13.b());
        return;
    L17:
        throw new MissingOperandException(r10, r12);
    }
}
