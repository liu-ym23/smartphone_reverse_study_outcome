package com.tom_roush.pdfbox.pdmodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class b extends com.tom_roush.pdfbox.pdmodel.common.f<com.tom_roush.pdfbox.pdmodel.interactive.b.a.c> {
    public b() {
    }

    public b(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.f
    public com.tom_roush.pdfbox.pdmodel.common.f<com.tom_roush.pdfbox.pdmodel.interactive.b.a.c> a(com.tom_roush.pdfbox.a.d r1) {
        return new b(r1);
    }

    public com.tom_roush.pdfbox.pdmodel.interactive.b.a.c a(com.tom_roush.pdfbox.a.b r2) {
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.d.class) == false) goto L6;
        r2 = ((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin")).a(com.tom_roush.pdfbox.a.i.br);
    L6:
        return (com.tom_roush.pdfbox.pdmodel.interactive.b.a.c) ZeusTransformUtils.preCheckCast(com.tom_roush.pdfbox.pdmodel.interactive.b.a.a.a(r2), com.tom_roush.pdfbox.pdmodel.interactive.b.a.c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.f
    public /* synthetic */ com.tom_roush.pdfbox.pdmodel.common.c b(com.tom_roush.pdfbox.a.b r1) {
        return a(r1);
    }
}
