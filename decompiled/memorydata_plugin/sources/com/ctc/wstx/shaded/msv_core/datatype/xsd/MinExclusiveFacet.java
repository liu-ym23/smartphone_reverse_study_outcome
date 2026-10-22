package com.ctc.wstx.shaded.msv_core.datatype.xsd;

/* JADX INFO: loaded from: classes2.dex */
public class MinExclusiveFacet extends RangeFacet {
    private static final long serialVersionUID = 1;

    public MinExclusiveFacet(String r8, String r9, XSDatatypeImpl r10, Object r11, boolean r12) {
        super(r8, r9, r10, XSDatatype.FACET_MINEXCLUSIVE, r11, r12);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.RangeFacet
    public final boolean rangeCheck(int r1) {
        if (r1 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }
}
