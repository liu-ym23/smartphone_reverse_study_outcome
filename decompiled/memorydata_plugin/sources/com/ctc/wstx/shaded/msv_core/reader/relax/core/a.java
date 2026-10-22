package com.ctc.wstx.shaded.msv_core.reader.relax.core;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.b;
import com.ctc.wstx.shaded.msv_core.grammar.relax.EmptyStringType;
import com.ctc.wstx.shaded.msv_core.grammar.relax.NoneType;
import com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.XSDatatypeExp;
import com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.j;
import com.ctc.wstx.shaded.msv_core.util.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.ctc.wstx.shaded.msv_core.reader.relax.a implements j {
    protected static com.ctc.wstx.shaded.msv.org_isorelax.verifier.a f;
    private final Map g;

    static {
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.datatype.xsd.j
    public XSDatatypeExp a(String r4) {
        XSDatatypeExp r0 = (XSDatatypeExp) ZeusTransformUtils.preCheckCast(this.g.get(r4), XSDatatypeExp.class, "com.obric.memorydata.plugin");     // Catch: DatatypeException -> L7
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new XSDatatypeExp(b.a(r4), this.c);
    L7:
        XSDatatype r1 = c(r4);
        if (r4.equals("none") == false) goto L11;
        r1 = NoneType.theInstance;
    L11:
        if (r4.equals("emptyString") == false) goto L13;
        r1 = EmptyStringType.theInstance;
    L13:
        if (r1 != null) goto L16;
        a("GrammarReader.UndefinedDataType", r4);
        r1 = NoneType.theInstance;
    L16:
        return new XSDatatypeExp(r1, this.c);
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.relax.a, com.ctc.wstx.shaded.msv_core.reader.d
    public String a(String r1, Object[] r2) {
        return super.a(r1, r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.d
    public boolean a(c r2) {
        if ("http://www.xml.gr.jp/xmlns/relaxCore".equals(r2.f3641a) == true) goto L6;
        return false;
    L6:
        if (r2.f3642b.equals("annotation") == false) goto L8;
        return false;
    L8:
        return true;
    }
}
