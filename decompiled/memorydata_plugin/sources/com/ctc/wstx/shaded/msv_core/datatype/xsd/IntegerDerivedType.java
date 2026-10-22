package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
abstract class IntegerDerivedType extends BuiltinAtomicType implements a {
    private static final long serialVersionUID = -7353993842821534786L;
    private final XSDatatypeImpl baseFacets;

    public IntegerDerivedType(String r1, XSDatatypeImpl r2) {
        super(r1);
        this.baseFacets = r2;
    }

    public static XSDatatypeImpl createRangeFacet(XSDatatypeImpl r13, Number r14, Number r15) {
        if (r14 != null) goto L11;
        XSDatatypeImpl r10 = r13;
    L5:
        if (r15 == null) goto L10;
        return new MaxInclusiveFacet(null, null, r10, r15, false);
    L9:
        throw new InternalError();
    L10:
        return r10;
    L11:
        r10 = new MinInclusiveFacet(null, null, r13, r14, false);     // Catch: DatatypeException -> L8
        goto L5
    }

    public static String removeOptionalPlus(String r4) {
        if (r4.length() > 1) goto L5;
    L17:
        return r4;
    L5:
        if (r4.charAt(0) != '+') goto L17;
        String r5 = r4.substring(1);
        char r0 = r5.charAt(0);
        if ('0' > r0) goto L13;
        if (r0 > '9') goto L13;
        return r5;
    L13:
        if ('.' != r0) goto L16;
        return r5;
    L16:
        throw new NumberFormatException();
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
    public String convertToLexicalValue(Object r2, com.ctc.wstx.shaded.msv_core.datatype.c r3) {
        com.ctc.wstx.shaded.msv_core.datatype.c r1 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, Number.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r2, IntegerValueType.class) == true) goto L10;
        throw new IllegalArgumentException("invalid value type:" + r2.getClass().toString());
    L10:
        return r2.toString();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public DataTypeWithFacet getFacetObject(String r1) {
        return this.baseFacets.getFacetObject(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int isFacetApplicable(String r1) {
        if (r1.equals(XSDatatype.FACET_TOTALDIGITS) == false) goto L5;
        return 0;
    L5:
        if (r1.equals(XSDatatype.FACET_PATTERN) == false) goto L7;
        return 0;
    L7:
        if (r1.equals(XSDatatype.FACET_WHITESPACE) == false) goto L9;
        return 0;
    L9:
        if (r1.equals(XSDatatype.FACET_ENUMERATION) == false) goto L11;
        return 0;
    L11:
        if (r1.equals(XSDatatype.FACET_MAXINCLUSIVE) == false) goto L13;
        return 0;
    L13:
        if (r1.equals(XSDatatype.FACET_MININCLUSIVE) == false) goto L15;
        return 0;
    L15:
        if (r1.equals(XSDatatype.FACET_MAXEXCLUSIVE) == false) goto L17;
        return 0;
    L17:
        if (r1.equals(XSDatatype.FACET_MINEXCLUSIVE) == false) goto L20;
        return 0;
    L20:
        if (r1.equals(XSDatatype.FACET_FRACTIONDIGITS) == false) goto L23;
        return -1;
    L23:
        return -2;
    }
}
