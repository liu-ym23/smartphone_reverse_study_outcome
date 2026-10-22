package com.tom_roush.pdfbox.pdmodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class j extends com.tom_roush.pdfbox.pdmodel.common.f<com.tom_roush.pdfbox.pdmodel.a.a.g> {
    public j() {
    }

    public j(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    public com.tom_roush.pdfbox.pdmodel.a.a.g a(com.tom_roush.pdfbox.a.b r3) {
        return new com.tom_roush.pdfbox.pdmodel.a.a.g((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.f
    public com.tom_roush.pdfbox.pdmodel.common.f<com.tom_roush.pdfbox.pdmodel.a.a.g> a(com.tom_roush.pdfbox.a.d r1) {
        return new j(r1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.f
    public /* synthetic */ com.tom_roush.pdfbox.pdmodel.common.c b(com.tom_roush.pdfbox.a.b r1) {
        return a(r1);
    }
}
