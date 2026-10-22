package com.tom_roush.pdfbox.contentstream.operator.state;

import com.tom_roush.pdfbox.a.k;
import com.tom_roush.pdfbox.contentstream.operator.MissingOperandException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class e extends com.tom_roush.pdfbox.contentstream.operator.c {
    public e() {
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public String a() {
        return "Tm";
    }

    @Override // com.tom_roush.pdfbox.contentstream.operator.c
    public void a(com.tom_roush.pdfbox.contentstream.operator.b r13, List<com.tom_roush.pdfbox.a.b> r14) {
        List<com.tom_roush.pdfbox.a.b> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        if (r15.size() < 6) goto L10;
        if (a(r15, k.class) == true) goto L7;
        return;
    L7:
        k r16 = (k) ZeusTransformUtils.preCheckCast(r15.get(0), k.class, "com.obric.memorydata.plugin");
        k r0 = (k) ZeusTransformUtils.preCheckCast(r15.get(1), k.class, "com.obric.memorydata.plugin");
        k r2 = (k) ZeusTransformUtils.preCheckCast(r15.get(2), k.class, "com.obric.memorydata.plugin");
        k r3 = (k) ZeusTransformUtils.preCheckCast(r15.get(3), k.class, "com.obric.memorydata.plugin");
        k r4 = (k) ZeusTransformUtils.preCheckCast(r15.get(4), k.class, "com.obric.memorydata.plugin");
        k r17 = (k) ZeusTransformUtils.preCheckCast(r15.get(5), k.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.util.c r1 = new com.tom_roush.pdfbox.util.c(r16.a(), r0.a(), r2.a(), r3.a(), r4.a(), r17.a());
        this.f16096a.b(r1);
        this.f16096a.a(r1.b());
        return;
    L10:
        throw new MissingOperandException(r13, r15);
    }
}
