package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class FloatType extends FloatingNumberType {
    private static final long serialVersionUID = 1;
    public static final FloatType theInstance = null;

    static {
        theInstance = new FloatType();
    }

    private FloatType() {
        super(TypedValues.Custom.S_FLOAT);
    }

    public static Float load(String r2) {
        if (r2.equals("NaN") == false) goto L8;
        return new Float(Float.NaN);
    L8:
        if (r2.equals("INF") == false) goto L12;
        return new Float(Float.POSITIVE_INFINITY);
    L12:
        if (r2.equals("-INF") == false) goto L16;
        return new Float(Float.NEGATIVE_INFINITY);
    L16:
        if (r2.length() == 0) goto L24;
        if (isDigitOrPeriodOrSign(r2.charAt(0)) == false) goto L24;
        if (isDigitOrPeriodOrSign(r2.charAt(r2.length() - 1)) == false) goto L24;
        return Float.valueOf(r2);
    L24:
        return null;
    }

    public static String save(Float r2) {
        float r0 = r2.floatValue();
        if (Float.isNaN(r0) == false) goto L7;
        return "NaN";
    L7:
        if (r0 != Float.POSITIVE_INFINITY) goto L11;
        return "INF";
    L11:
        if (r0 != Float.NEGATIVE_INFINITY) goto L15;
        return "-INF";
    L15:
        return r2.toString();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return load(r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r2, com.ctc.wstx.shaded.msv_core.datatype.c r3) {
        com.ctc.wstx.shaded.msv_core.datatype.c r1 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, Float.class) == false) goto L7;
        return save((Float) ZeusTransformUtils.preCheckCast(r2, Float.class, "com.obric.memorydata.plugin"));
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return Float.class;
    }
}
