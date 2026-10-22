package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class DoubleType extends FloatingNumberType {
    private static final long serialVersionUID = 1;
    public static final DoubleType theInstance = null;

    static {
        theInstance = new DoubleType();
    }

    private DoubleType() {
        super("double");
    }

    public static Double load(String r3) {
        if (r3.equals("NaN") == false) goto L8;
        return new Double(Double.NaN);
    L8:
        if (r3.equals("INF") == false) goto L12;
        return new Double(Double.POSITIVE_INFINITY);
    L12:
        if (r3.equals("-INF") == false) goto L16;
        return new Double(Double.NEGATIVE_INFINITY);
    L16:
        if (r3.length() == 0) goto L24;
        if (isDigitOrPeriodOrSign(r3.charAt(0)) == false) goto L24;
        if (isDigitOrPeriodOrSign(r3.charAt(r3.length() - 1)) == false) goto L24;
        return Double.valueOf(r3);
    L24:
        return null;
    }

    public static String save(Double r4) {
        double r0 = r4.doubleValue();
        if (Double.isNaN(r0) == false) goto L7;
        return "NaN";
    L7:
        if (r0 != Double.POSITIVE_INFINITY) goto L11;
        return "INF";
    L11:
        if (r0 != Double.NEGATIVE_INFINITY) goto L15;
        return "-INF";
    L15:
        return r4.toString();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return load(r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r2, com.ctc.wstx.shaded.msv_core.datatype.c r3) {
        com.ctc.wstx.shaded.msv_core.datatype.c r1 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, Double.class) == false) goto L7;
        return save((Double) ZeusTransformUtils.preCheckCast(r2, Double.class, "com.obric.memorydata.plugin"));
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return Double.class;
    }
}
