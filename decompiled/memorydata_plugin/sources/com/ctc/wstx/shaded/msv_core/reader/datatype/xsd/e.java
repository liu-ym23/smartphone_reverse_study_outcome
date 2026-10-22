package com.ctc.wstx.shaded.msv_core.reader.datatype.xsd;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.StringType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class e extends h implements b {
    protected final String f;
    protected final String g;
    protected k h;

    public e(String r1, String r2) {
        this.f = r1;
        this.g = r2;
    }

    private void g() {
        this.h = this.i.createIncubator();
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.h
    public XSDatatypeExp a(XSDatatypeExp r2) {
        return this.h.a(this.f, this.g);
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.h
    public com.ctc.wstx.shaded.msv_core.reader.i a(com.ctc.wstx.shaded.msv_core.util.c r4) {
        if (this.c.f3641a.equals(r4.f3641a) == true) goto L6;
        return null;
    L6:
        if (r4.f3642b.equals("annotation") == false) goto L10;
        return new com.ctc.wstx.shaded.msv_core.reader.g();
    L10:
        if (r4.f3642b.equals("simpleType") == false) goto L14;
        return new f();
    L14:
        if (a.f.contains(r4.f3642b) == true) goto L16;
        return null;
    L16:
        if (this.h != null) goto L19;
        this.f3622b.a("GrammarReader.MissingAttribute", "restriction", "base");
        b(new XSDatatypeExp(StringType.theInstance, this.f3622b.c));
    L19:
        return new a();
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.g, com.ctc.wstx.shaded.msv_core.reader.h
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.b
    public final k b() {
        return this.h;
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.h, com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.l
    public void b(XSDatatypeExp r1) {
        super.b(r1);
        g();
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.i
    public void c() {
        super.c();
        String r0 = this.c.a("base");
        if (r0 == null) goto L6;
        b(((j) ZeusTransformUtils.preCheckCast(this.f3622b, j.class, "com.obric.memorydata.plugin")).a(r0));
        return;
    }
}
