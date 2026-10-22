package com.tom_roush.pdfbox.contentstream.operator.a;

import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class f extends com.tom_roush.pdfbox.contentstream.operator.c {
    public f() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "Tc";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r3, List<com.tom_roush.pdfbox.a.b> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == true) goto L9;
        Object r6 = r5.get(r5.size() - 1);
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.k.class) == false) goto L10;
        this.f16096a.g().b().a(((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a());
        return;
    L10:
        return;
    L9:
        throw new MissingOperandException(r3, r5);
    }
}
