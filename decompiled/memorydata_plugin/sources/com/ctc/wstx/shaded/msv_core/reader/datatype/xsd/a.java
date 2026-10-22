package com.ctc.wstx.shaded.msv_core.reader.datatype.xsd;

import com.bytedance.crash.entity.EventBody;
import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.ctc.wstx.shaded.msv_core.reader.a {
    public static final Set f = null;

    static {
        f = d();
    }

    public a() {
    }

    private static Set d() {
        HashSet r0 = new HashSet();
        r0.add(XSDatatype.FACET_LENGTH);
        r0.add(XSDatatype.FACET_MINLENGTH);
        r0.add(XSDatatype.FACET_MAXLENGTH);
        r0.add(XSDatatype.FACET_PATTERN);
        r0.add(XSDatatype.FACET_ENUMERATION);
        r0.add(XSDatatype.FACET_MAXINCLUSIVE);
        r0.add(XSDatatype.FACET_MININCLUSIVE);
        r0.add(XSDatatype.FACET_MAXEXCLUSIVE);
        r0.add(XSDatatype.FACET_MINEXCLUSIVE);
        r0.add(XSDatatype.FACET_WHITESPACE);
        r0.add(XSDatatype.FACET_FRACTIONDIGITS);
        r0.add(XSDatatype.FACET_TOTALDIGITS);
        return r0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.reader.i
    public void c() {
        super.c();
        String r0 = this.c.a(EventBody.KEY_VALUE);
        if (r0 != null) goto L10;
        this.f3622b.a("GrammarReader.MissingAttribute", this.c.f3642b, EventBody.KEY_VALUE);
        return;
    L10:
        ((b) ZeusTransformUtils.preCheckCast(this.f3621a, b.class, "com.obric.memorydata.plugin")).b().a(this.c.f3642b, r0, "true".equals(this.c.a("fixed")), this.f3622b);     // Catch: DatatypeException -> L7
        return;
    L7:
        e = move-exception;
        this.f3622b.a(e, "GrammarReader.BadType", e.getMessage());
    }
}
