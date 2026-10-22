package com.ctc.wstx.shaded.msv_core.datatype.xsd;

/* JADX INFO: loaded from: classes2.dex */
public class MaxInclusiveFacet extends RangeFacet {
    private static final long serialVersionUID = 1;

    public MaxInclusiveFacet(String r8, String r9, XSDatatypeImpl r10, Object r11, boolean r12) {
        super(r8, r9, r10, XSDatatype.FACET_MAXINCLUSIVE, r11, r12);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.RangeFacet
    public final boolean rangeCheck(int r1) {
        if (r1 == 1) goto L8;
        if (r1 == 0) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }
}
