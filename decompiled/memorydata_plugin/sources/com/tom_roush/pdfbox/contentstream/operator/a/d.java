package com.tom_roush.pdfbox.contentstream.operator.a;

import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class d extends com.tom_roush.pdfbox.contentstream.operator.c {
    public d() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return com.tom_roush.pdfbox.pdmodel.a.d.i.B;
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r4, List<com.tom_roush.pdfbox.a.b> r5) {
        List<com.tom_roush.pdfbox.a.b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6.size() < 2) goto L10;
        com.tom_roush.pdfbox.a.b r7 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r6.get(1), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, com.tom_roush.pdfbox.a.k.class) == true) goto L7;
        return;
    L7:
        com.tom_roush.pdfbox.a.k r8 = (com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r7, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        r0.add(new com.tom_roush.pdfbox.a.f(-r8.a()));
        this.f16096a.a("TL", r0);
        this.f16096a.a("Td", r6);
        return;
    L10:
        throw new MissingOperandException(r4, r6);
    }
}
