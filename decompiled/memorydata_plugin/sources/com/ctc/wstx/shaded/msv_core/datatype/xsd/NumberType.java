package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class NumberType extends BuiltinAtomicType implements a {
    private static final long serialVersionUID = 1;
    private static final BigInteger the10 = null;
    public static final NumberType theInstance = null;

    static {
        theInstance = new NumberType();
        the10 = new BigInteger("10");
    }

    private NumberType() {
        super("decimal");
    }

    public static BigDecimal load(String r6) {
    L18:
        return null;
    L4:
        if (r6.length() != 0) goto L7;
        return null;
    L7:
        if (r6.charAt(0) != '+') goto L9;
        r6 = r6.substring(1);     // Catch: NumberFormatException -> L18
    L9:
        BigDecimal r2 = new BigDecimal(r6);     // Catch: NumberFormatException -> L18
    L10:
        if (r2.scale() <= 0) goto L17;
        BigInteger[] r7 = r2.unscaledValue().divideAndRemainder(the10);     // Catch: NumberFormatException -> L18
        if (r7[1].equals(BigInteger.ZERO) == false) goto L17;
        r2 = new BigDecimal(r7[0], r2.scale() - 1);     // Catch: NumberFormatException -> L18
    L17:
        return r2;
    }

    public static String save(Object r2) {
        return ((BigDecimal) ZeusTransformUtils.preCheckCast(r2, BigDecimal.class, "com.obric.memorydata.plugin")).toString();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        if (checkFormat(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")) == true) goto L7;
        return null;
    L7:
        return load(r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean checkFormat(String r8, com.ctc.wstx.shaded.msv.relaxng_datatype.e r9) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r7 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r9, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        int r10 = r8.length();
        if (r10 != 0) goto L5;
        return false;
    L5:
        char r0 = r8.charAt(0);
        if (r0 != '-') goto L8;
    L11:
        boolean r1 = false;
        int r2 = 1;
    L13:
        if (r2 >= r10) goto L22;
        int r5 = r2 + 1;
        char r3 = r8.charAt(r2);
        if ('0' > r3) goto L19;
        if (r3 > '9') goto L19;
        r1 = true;
        r2 = r5;
    L19:
        if (r3 != '.') goto L21;
        r2 = r5;
        goto L22
    L21:
        return false;
    L22:
        if (r2 >= r10) goto L28;
        int r4 = r2 + 1;
        char r6 = r8.charAt(r2);
        if ('0' > r6) goto L27;
        if (r6 > '9') goto L27;
        r2 = r4;
        r1 = true;
    L27:
        return false;
    L28:
        return r1;
    L8:
        if (r0 == '+') goto L11;
        r2 = 0;
        r1 = false;
        goto L13
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
        if (ZeusTransformUtils.instanceOf(r2, BigDecimal.class) == false) goto L7;
        return r2.toString();
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return BigDecimal.class;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int isFacetApplicable(String r1) {
        if (r1.equals(XSDatatype.FACET_TOTALDIGITS) == false) goto L5;
        return 0;
    L5:
        if (r1.equals(XSDatatype.FACET_FRACTIONDIGITS) == false) goto L7;
        return 0;
    L7:
        if (r1.equals(XSDatatype.FACET_PATTERN) == false) goto L9;
        return 0;
    L9:
        if (r1.equals(XSDatatype.FACET_ENUMERATION) == false) goto L11;
        return 0;
    L11:
        if (r1.equals(XSDatatype.FACET_WHITESPACE) == false) goto L13;
        return 0;
    L13:
        if (r1.equals(XSDatatype.FACET_MAXINCLUSIVE) == false) goto L15;
        return 0;
    L15:
        if (r1.equals(XSDatatype.FACET_MININCLUSIVE) == false) goto L17;
        return 0;
    L17:
        if (r1.equals(XSDatatype.FACET_MAXEXCLUSIVE) == false) goto L19;
        return 0;
    L19:
        if (r1.equals(XSDatatype.FACET_MINEXCLUSIVE) == true) goto L32;
        return -2;
    L32:
        return 0;
    }
}
