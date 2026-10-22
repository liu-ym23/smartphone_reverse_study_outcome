package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class IntegerType extends IntegerDerivedType {
    private static final long serialVersionUID = 1;
    public static final IntegerType theInstance = null;

    static {
        theInstance = new IntegerType(TypedValues.Custom.S_INT, new FractionDigitsFacet(null, null, NumberType.theInstance, 0, true));     // Catch: DatatypeException -> L4
        return;
    L5:
        throw new InternalError();
    }

    public IntegerType(String r1, XSDatatypeImpl r2) {
        super(r1, r2);
    }

    public static BigInteger load(String r1) {
        IntegerValueType r2 = IntegerValueType.create(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new BigInteger(r2.toString());
    }

    public static String save(BigInteger r0) {
        return r0.toString();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.ConcreteType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createJavaObject(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        IntegerValueType r2 = (IntegerValueType) ZeusTransformUtils.preCheckCast(_createValue(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")), IntegerValueType.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return new BigInteger(r2.toString());
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return IntegerValueType.create(r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.IntegerDerivedType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public /* synthetic */ String convertToLexicalValue(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        return super.convertToLexicalValue(r3, (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public XSDatatype getBaseType() {
        return NumberType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.IntegerDerivedType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public /* bridge */ /* synthetic */ DataTypeWithFacet getFacetObject(String r1) {
        return super.getFacetObject(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return BigInteger.class;
    }
}
