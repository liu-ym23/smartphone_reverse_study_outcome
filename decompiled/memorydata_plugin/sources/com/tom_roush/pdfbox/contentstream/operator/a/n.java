package com.tom_roush.pdfbox.contentstream.operator.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class n extends com.tom_roush.pdfbox.contentstream.operator.c {
    public n() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "TJ";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r2, List<com.tom_roush.pdfbox.a.b> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        com.tom_roush.pdfbox.a.b r5 = (com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r4.get(0), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.a.class) == true) goto L9;
        return;
    L9:
        if (this.f16096a.i() != null) goto L11;
        return;
    L11:
        com.tom_roush.pdfbox.a.a r6 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        this.f16096a.a(r6);
    }
}
