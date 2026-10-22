package com.tom_roush.pdfbox.pdmodel.encryption;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class e implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l f16199b;

    public e() {
        this.f16198a = new com.tom_roush.pdfbox.a.d();
    }

    public e(com.tom_roush.pdfbox.a.d r2) {
        this.f16198a = r2;
        this.f16199b = m.f16209a.a(c());
    }

    public d a(com.tom_roush.pdfbox.a.i r3) {
        com.tom_roush.pdfbox.a.b r2 = this.f16198a.a(com.tom_roush.pdfbox.a.i.az);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.d.class) == false) goto L8;
        com.tom_roush.pdfbox.a.b r4 = ((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin")).a(r3);
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.d.class) == true) goto L7;
        return null;
    L7:
        return new d((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    L8:
        return null;
    }

    public l a() {
        l r0 = this.f16199b;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IOException("No security handler for filter " + c());
    }

    public com.tom_roush.pdfbox.a.d b() {
        return this.f16198a;
    }

    public final String c() {
        return this.f16198a.g(com.tom_roush.pdfbox.a.i.cT);
    }

    public int d() {
        return this.f16198a.b(com.tom_roush.pdfbox.a.i.iM, 0);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return b();
    }

    public int f() {
        return this.f16198a.b(com.tom_roush.pdfbox.a.i.ew, 40);
    }

    public int g() {
        return this.f16198a.b(com.tom_roush.pdfbox.a.i.gG, 0);
    }

    public byte[] h() {
        com.tom_roush.pdfbox.a.o r2 = (com.tom_roush.pdfbox.a.o) ZeusTransformUtils.preCheckCast(this.f16198a.a(com.tom_roush.pdfbox.a.i.ft), com.tom_roush.pdfbox.a.o.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.b();
    }

    public byte[] i() {
        com.tom_roush.pdfbox.a.o r2 = (com.tom_roush.pdfbox.a.o) ZeusTransformUtils.preCheckCast(this.f16198a.a(com.tom_roush.pdfbox.a.i.iD), com.tom_roush.pdfbox.a.o.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.b();
    }

    public byte[] j() {
        com.tom_roush.pdfbox.a.o r2 = (com.tom_roush.pdfbox.a.o) ZeusTransformUtils.preCheckCast(this.f16198a.a(com.tom_roush.pdfbox.a.i.fB), com.tom_roush.pdfbox.a.o.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.b();
    }

    public byte[] k() {
        com.tom_roush.pdfbox.a.o r2 = (com.tom_roush.pdfbox.a.o) ZeusTransformUtils.preCheckCast(this.f16198a.a(com.tom_roush.pdfbox.a.i.iE), com.tom_roush.pdfbox.a.o.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.b();
    }

    public int l() {
        return this.f16198a.b(com.tom_roush.pdfbox.a.i.fV, 0);
    }

    public boolean m() {
        com.tom_roush.pdfbox.a.b r2 = this.f16198a.a(com.tom_roush.pdfbox.a.i.cE);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.c.class) == true) goto L7;
        return true;
    L7:
        return ((com.tom_roush.pdfbox.a.c) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.c.class, "com.obric.memorydata.plugin")).a();
    }

    public d n() {
        return a(com.tom_roush.pdfbox.a.i.hF);
    }

    public d o() {
        return a(com.tom_roush.pdfbox.a.i.bB);
    }

    public com.tom_roush.pdfbox.a.i p() {
        com.tom_roush.pdfbox.a.i r2 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(this.f16198a.a(com.tom_roush.pdfbox.a.i.hI), com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return com.tom_roush.pdfbox.a.i.dL;
    }

    public com.tom_roush.pdfbox.a.i q() {
        com.tom_roush.pdfbox.a.i r2 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(this.f16198a.a(com.tom_roush.pdfbox.a.i.hJ), com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return com.tom_roush.pdfbox.a.i.dL;
    }

    public byte[] r() {
        com.tom_roush.pdfbox.a.o r2 = (com.tom_roush.pdfbox.a.o) ZeusTransformUtils.preCheckCast(this.f16198a.a(com.tom_roush.pdfbox.a.i.gm), com.tom_roush.pdfbox.a.o.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.b();
    }
}
