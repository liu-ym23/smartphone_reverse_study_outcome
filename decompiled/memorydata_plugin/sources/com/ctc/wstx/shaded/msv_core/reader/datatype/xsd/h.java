package com.ctc.wstx.shaded.msv_core.reader.datatype.xsd;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.StringType;

/* JADX INFO: loaded from: classes2.dex */
abstract class h extends g implements l {
    protected XSDatatypeExp i;

    h() {
    }

    public XSDatatypeExp a(XSDatatypeExp r1) {
        return r1;
    }

    public void b(XSDatatypeExp r2) {
        if (this.i == null) goto L5;
        this.f3622b.d("GrammarReader.Abstract.MoreThanOneChildType");
        return;
    L5:
        this.i = r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.g
    public final XSDatatypeExp f() {
        XSDatatypeExp r0 = this.i;
        if (r0 != null) goto L7;
        this.f3622b.d("GrammarReader.Abstract.MissingChildType");
        return new XSDatatypeExp(StringType.theInstance, this.f3622b.c);
    L7:
        return a(r0);
    }
}
