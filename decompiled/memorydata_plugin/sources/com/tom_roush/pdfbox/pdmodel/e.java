package com.tom_roush.pdfbox.pdmodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class e implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16194a;

    public e(com.tom_roush.pdfbox.a.d r1) {
        this.f16194a = r1;
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16194a;
    }

    public com.tom_roush.pdfbox.pdmodel.interactive.b.a.a a(String r2) {
        com.tom_roush.pdfbox.a.b r1 = this.f16194a.a(r2);
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.a.class) == false) goto L7;
        return com.tom_roush.pdfbox.pdmodel.interactive.b.a.a.a(r1);
    L7:
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.d.class) == false) goto L12;
        com.tom_roush.pdfbox.a.d r3 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        if (r3.m(com.tom_roush.pdfbox.a.i.br) == true) goto L11;
        return null;
    L11:
        return com.tom_roush.pdfbox.pdmodel.interactive.b.a.a.a(r3.a(com.tom_roush.pdfbox.a.i.br));
    L12:
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }
}
