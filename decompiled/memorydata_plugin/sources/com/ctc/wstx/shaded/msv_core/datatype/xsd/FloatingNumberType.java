package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
abstract class FloatingNumberType extends BuiltinAtomicType implements a {
    private static final long serialVersionUID = -224134863141700384L;

    public FloatingNumberType(String r1) {
        super(r1);
    }

    public static boolean isDigitOrPeriodOrSign(char r2) {
        if ('0' > r2) goto L8;
        if (r2 > '9') goto L8;
        return true;
    L8:
        if (r2 != '+') goto L10;
    L16:
        return true;
    L10:
        if (r2 == '-') goto L16;
        if (r2 == '.') goto L16;
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final boolean checkFormat(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        if (_createValue(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.a
    public final int compare(Object r2, Object r3) {
        int r1 = ((Comparable) ZeusTransformUtils.preCheckCast(r2, Comparable.class, "com.obric.memorydata.plugin")).compareTo(r3);
        if (r1 >= 0) goto L6;
        return -1;
    L6:
        if (r1 <= 0) goto L9;
        return 1;
    L9:
        return 0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int isFacetApplicable(String r1) {
        if (r1.equals(XSDatatype.FACET_PATTERN) == false) goto L5;
        return 0;
    L5:
        if (r1.equals(XSDatatype.FACET_ENUMERATION) == false) goto L7;
        return 0;
    L7:
        if (r1.equals(XSDatatype.FACET_WHITESPACE) == false) goto L9;
        return 0;
    L9:
        if (r1.equals(XSDatatype.FACET_MAXINCLUSIVE) == false) goto L11;
        return 0;
    L11:
        if (r1.equals(XSDatatype.FACET_MININCLUSIVE) == false) goto L13;
        return 0;
    L13:
        if (r1.equals(XSDatatype.FACET_MAXEXCLUSIVE) == false) goto L15;
        return 0;
    L15:
        if (r1.equals(XSDatatype.FACET_MINEXCLUSIVE) == true) goto L26;
        return -2;
    L26:
        return 0;
    }
}
