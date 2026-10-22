package com.tom_roush.pdfbox.contentstream.operator.a;

import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class h extends com.tom_roush.pdfbox.contentstream.operator.c {
    public h() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "Tz";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r3, List<com.tom_roush.pdfbox.a.b> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == true) goto L10;
        com.tom_roush.pdfbox.a.b r6 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r5.get(0), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.k.class) == true) goto L7;
        return;
    L7:
        com.tom_roush.pdfbox.a.k r7 = (com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin");
        this.f16096a.g().b().c(r7.a());
        return;
    L10:
        throw new MissingOperandException(r3, r5);
    }
}
