package com.ctc.wstx.shaded.msv_core.reader.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class d extends h {
    protected final String f;
    protected final String g;

    public d(String r1, String r2) {
        this.f = r1;
        this.g = r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.h
    public XSDatatypeExp a(XSDatatypeExp r3) {
        return XSDatatypeExp.makeList(this.f, this.g, r3, this.f3622b);
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.h
    public com.ctc.wstx.shaded.msv_core.reader.i a(com.ctc.wstx.shaded.msv_core.util.c r3) {
        if (this.c.f3641a.equals(r3.f3641a) == true) goto L6;
        return null;
    L6:
        if (r3.f3642b.equals("annotation") == false) goto L10;
        return new com.ctc.wstx.shaded.msv_core.reader.g();
    L10:
        if (r3.f3642b.equals("simpleType") == true) goto L12;
        return null;
    L12:
        return new f();
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.g, com.ctc.wstx.shaded.msv_core.reader.h
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.h, com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.l
    public /* bridge */ /* synthetic */ void b(XSDatatypeExp r1) {
        super.b(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.i
    public void c() {
        super.c();
        String r0 = this.c.a("itemType");
        if (r0 == null) goto L6;
        b(((j) ZeusTransformUtils.preCheckCast(this.f3622b, j.class, "com.obric.memorydata.plugin")).a(r0));
        return;
    }
}
