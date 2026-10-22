package com.ctc.wstx.shaded.msv_core.reader.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes2.dex */
public class i extends g implements l {
    protected final String f;
    protected final String g;
    private final ArrayList h;

    public i(String r2, String r3) {
        this.h = new ArrayList();
        this.f = r2;
        this.g = r3;
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

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.l
    public void b(XSDatatypeExp r1) {
        this.h.add(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.i
    public void c() {
        super.c();
        String r0 = this.c.a("memberTypes");
        if (r0 == null) goto L8;
        StringTokenizer r1 = new StringTokenizer(r0);
    L6:
        if (r1.hasMoreTokens() == false) goto L10;
        b(((j) ZeusTransformUtils.preCheckCast(this.f3622b, j.class, "com.obric.memorydata.plugin")).a(r1.nextToken()));
        goto L6
    L10:
        return;
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.g
    public final XSDatatypeExp f() {
        return XSDatatypeExp.makeUnion(this.f, this.g, this.h, this.f3622b);
    }
}
