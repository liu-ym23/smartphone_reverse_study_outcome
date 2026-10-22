package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public final class PatternFacet extends DataTypeWithLexicalConstraintFacet {
    private static final long serialVersionUID = 1;
    private transient com.ctc.wstx.shaded.msv_core.datatype.xsd.a.a[] exps;
    public final String[] patterns;

    public PatternFacet(String r8, String r9, XSDatatypeImpl r10, d r11) {
        super(r8, r9, r10, XSDatatype.FACET_PATTERN, r11.a(XSDatatype.FACET_PATTERN));
        Vector r12 = r11.c(XSDatatype.FACET_PATTERN);
        this.patterns = (String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r12.toArray(new String[r12.size()]), String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin");
        compileRegExps();     // Catch: ParseException -> L5
        return;
    L5:
        e = move-exception;
        throw new DatatypeException(localize(XSDatatypeImpl.ERR_PARSE_ERROR, e.getMessage()));
    }

    private void compileRegExps() {
        this.exps = new com.ctc.wstx.shaded.msv_core.datatype.xsd.a.a[this.patterns.length];
        com.ctc.wstx.shaded.msv_core.datatype.xsd.a.b r0 = com.ctc.wstx.shaded.msv_core.datatype.xsd.a.b.a();
        int r1 = 0;
    L3:
        com.ctc.wstx.shaded.msv_core.datatype.xsd.a.a[] r2 = this.exps;
        if (r1 >= r2.length) goto L6;
        r2[r1] = r0.a(this.patterns[r1]);
        r1 = r1 + 1;
        goto L3
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        compileRegExps();     // Catch: ParseException -> L5
        return;
    L5:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DataTypeWithLexicalConstraintFacet
    public final boolean checkLexicalConstraint(String r5) {
        monitor-enter(this);
        int r1 = 0;
    L17:
        com.ctc.wstx.shaded.msv_core.datatype.xsd.a.a[] r2 = this.exps;     // Catch: Throwable -> L14
        if (r1 >= r2.length) goto L12;
        if (r2[r1].a(r5) == true) goto L8;
        r1 = r1 + 1;     // Catch: Throwable -> L14
        goto L17
    L8:
        monitor-exit(this);     // Catch: Throwable -> L14
        return true;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DataTypeWithFacet
    public void diagnoseByFacet(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        if (checkLexicalConstraint(r3) == false) goto L6;
        return;
    L6:
        if (this.exps.length != 1) goto L10;
        throw new DatatypeException(-1, localize(XSDatatypeImpl.ERR_PATTERN_1, this.patterns[0]));
    L10:
        throw new DatatypeException(-1, localize(XSDatatypeImpl.ERR_PATTERN_MANY));
    }

    public com.ctc.wstx.shaded.msv_core.datatype.xsd.a.a[] getRegExps() {
        return this.exps;
    }
}
