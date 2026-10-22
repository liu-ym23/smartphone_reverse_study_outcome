package com.tom_roush.pdfbox.contentstream.operator.a;

import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class p extends com.tom_roush.pdfbox.contentstream.operator.c {
    public p() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "\"";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r5, List<com.tom_roush.pdfbox.a.b> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7.size() < 3) goto L7;
        this.f16096a.a("Tw", r7.subList(0, 1));
        this.f16096a.a("Tc", r7.subList(1, 2));
        this.f16096a.a("'", r7.subList(2, 3));
        return;
    L7:
        throw new MissingOperandException(r5, r7);
    }
}
