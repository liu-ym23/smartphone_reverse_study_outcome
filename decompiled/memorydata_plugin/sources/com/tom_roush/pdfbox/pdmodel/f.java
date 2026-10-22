package com.tom_roush.pdfbox.pdmodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class f implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f16213b;

    public f(d r1, com.tom_roush.pdfbox.a.d r2) {
        this.f16213b = r1;
        this.f16212a = r2;
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16212a;
    }

    public b b() {
        com.tom_roush.pdfbox.a.d r0 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(this.f16212a.a(com.tom_roush.pdfbox.a.i.bJ), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(this.f16213b.a().a(com.tom_roush.pdfbox.a.i.bJ), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
    L5:
        if (r0 != null) goto L9;
        return null;
    L9:
        return new b(r0);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }
}
