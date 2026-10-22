package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class FractionDigitsFacet extends DataTypeWithLexicalConstraintFacet {
    private static final long serialVersionUID = 1;
    public final int scale;

    public FractionDigitsFacet(String r7, String r8, XSDatatypeImpl r9, int r10, boolean r11) {
        super(r7, r8, r9, XSDatatype.FACET_FRACTIONDIGITS, r11);
        this.scale = r10;
        DataTypeWithFacet r12 = r9.getFacetObject(XSDatatype.FACET_FRACTIONDIGITS);
        if (r12 != null) goto L5;
        return;
    L5:
        if (((FractionDigitsFacet) ZeusTransformUtils.preCheckCast(r12, FractionDigitsFacet.class, "com.obric.memorydata.plugin")).scale < r10) goto L8;
        return;
    L8:
        throw new DatatypeException(localize(XSDatatypeImpl.ERR_LOOSENED_FACET, XSDatatype.FACET_FRACTIONDIGITS, r12.displayName()));
    }

    public static final int countScale(String r8) {
        int r0 = r8.length();
        boolean r1 = true;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r3 >= r0) goto L19;
        char r6 = r8.charAt(r3);
        if (r1 == false) goto L10;
        if (r6 != '.') goto L17;
        r1 = false;
    L17:
        r3 = r3 + 1;
        goto L3
    L10:
        if (r6 != '0') goto L12;
        r5 = r5 + 1;
    L13:
        if ('0' > r6) goto L17;
        if (r6 > '9') goto L17;
        r4 = r4 + 1;
        goto L17
    L12:
        r5 = 0;
        goto L13
    L19:
        return r4 - r5;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DataTypeWithLexicalConstraintFacet
    public boolean checkLexicalConstraint(String r1) {
        if (countScale(r1) > this.scale) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DataTypeWithFacet
    public void diagnoseByFacet(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        int r6 = countScale(r3);
        if (r6 > this.scale) goto L6;
        return;
    L6:
        throw new DatatypeException(-1, localize(XSDatatypeImpl.ERR_TOO_MUCH_SCALE, new Integer(r6), new Integer(this.scale)));
    }
}
