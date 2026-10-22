package com.tom_roush.pdfbox.pdmodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class d implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f16193b;

    public d(c r3) {
        this.f16193b = r3;
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        this.f16192a = r0;
        r0.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.au);
        r3.a().f().a(com.tom_roush.pdfbox.a.i.gY, r0);
    }

    public d(c r1, com.tom_roush.pdfbox.a.d r2) {
        this.f16193b = r1;
        this.f16192a = r2;
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16192a;
    }

    public com.tom_roush.pdfbox.pdmodel.interactive.b.a.c a(com.tom_roush.pdfbox.pdmodel.interactive.b.a.b r4) {
        f r0 = c();
        if (r0 == null) goto L7;
        b r1 = r0.b();
        if (r1 == null) goto L7;
        com.tom_roush.pdfbox.pdmodel.interactive.b.a.c r2 = (com.tom_roush.pdfbox.pdmodel.interactive.b.a.c) ZeusTransformUtils.preCheckCast(r1.a(r4.a()), com.tom_roush.pdfbox.pdmodel.interactive.b.a.c.class, "com.obric.memorydata.plugin");
    L8:
        if (r2 != null) goto L13;
        e r3 = d();
        if (r3 != null) goto L12;
        return r2;
    L12:
        return (com.tom_roush.pdfbox.pdmodel.interactive.b.a.c) ZeusTransformUtils.preCheckCast(r3.a(r4.a()), com.tom_roush.pdfbox.pdmodel.interactive.b.a.c.class, "com.obric.memorydata.plugin");
    L13:
        return r2;
    L7:
        r2 = null;
        goto L8
    }

    public h b() {
        return new h((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(this.f16192a.a(com.tom_roush.pdfbox.a.i.ga), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"), this.f16193b);
    }

    public f c() {
        com.tom_roush.pdfbox.a.d r0 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(this.f16192a.a(com.tom_roush.pdfbox.a.i.fi), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return null;
    L6:
        return new f(this, r0);
    }

    public e d() {
        com.tom_roush.pdfbox.a.d r2 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(this.f16192a.a(com.tom_roush.pdfbox.a.i.bJ), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return new e(r2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }
}
