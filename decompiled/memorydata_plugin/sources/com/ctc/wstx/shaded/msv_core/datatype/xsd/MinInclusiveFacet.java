package com.ctc.wstx.shaded.msv_core.datatype.xsd;

/* JADX INFO: loaded from: classes2.dex */
public class MinInclusiveFacet extends RangeFacet {
    private static final long serialVersionUID = 1;

    public MinInclusiveFacet(String r8, String r9, XSDatatypeImpl r10, Object r11, boolean r12) {
        super(r8, r9, r10, XSDatatype.FACET_MININCLUSIVE, r11, r12);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.RangeFacet
    public final boolean rangeCheck(int r1) {
        if (r1 == (-1)) goto L7;
        if (r1 == 0) goto L7;
        return false;
    L7:
        return true;
    }
}
