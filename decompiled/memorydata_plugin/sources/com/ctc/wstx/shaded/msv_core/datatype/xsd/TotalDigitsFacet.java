package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TotalDigitsFacet extends DataTypeWithLexicalConstraintFacet {
    private static final long serialVersionUID = 1;
    public final int precision;

    public TotalDigitsFacet(String r7, String r8, XSDatatypeImpl r9, int r10, boolean r11) {
        super(r7, r8, r9, XSDatatype.FACET_TOTALDIGITS, r11);
        this.precision = r10;
        DataTypeWithFacet r12 = r9.getFacetObject(XSDatatype.FACET_TOTALDIGITS);
        if (r12 != null) goto L5;
        return;
    L5:
        if (((TotalDigitsFacet) ZeusTransformUtils.preCheckCast(r12, TotalDigitsFacet.class, "com.obric.memorydata.plugin")).precision < r10) goto L8;
        return;
    L8:
        throw new DatatypeException(localize(XSDatatypeImpl.ERR_LOOSENED_FACET, XSDatatype.FACET_TOTALDIGITS, r12.displayName()));
    }

    public static int countPrecision(String r11) {
        int r0 = r11.length();
        boolean r6 = true;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        boolean r7 = false;
    L3:
        if (r3 >= r0) goto L23;
        char r8 = r11.charAt(r3);
        if (r8 != '.') goto L8;
        r7 = true;
        r6 = false;
    L8:
        if (r6 == false) goto L14;
        if ('1' > r8) goto L21;
        if (r8 > '9') goto L21;
        r4 = r4 + 1;
        r6 = false;
    L21:
        r3 = r3 + 1;
        goto L3
    L14:
        if (r7 == false) goto L17;
        if (r8 != '0') goto L17;
        r5 = r5 + 1;
    L18:
        if ('0' > r8) goto L21;
        if (r8 > '9') goto L21;
        r4 = r4 + 1;
    L17:
        r5 = 0;
        goto L18
    L23:
        return r4 - r5;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DataTypeWithLexicalConstraintFacet
    public boolean checkLexicalConstraint(String r1) {
        if (countPrecision(r1) > this.precision) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.DataTypeWithFacet
    public void diagnoseByFacet(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r5 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        int r6 = countPrecision(r3);
        if (r6 > this.precision) goto L6;
        return;
    L6:
        throw new DatatypeException(-1, localize(XSDatatypeImpl.ERR_TOO_MUCH_PRECISION, new Integer(r6), new Integer(this.precision)));
    }
}
