package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class UnsignedLongType extends IntegerType {
    private static final long serialVersionUID = 1;
    public static final UnsignedLongType theInstance = null;
    private static final IntegerValueType upperBound = null;

    static {
        theInstance = new UnsignedLongType();
        upperBound = IntegerValueType.create("18446744073709551615");
    }

    private UnsignedLongType() {
        super("unsignedLong", createRangeFacet(NonNegativeIntegerType.theInstance, null, IntegerValueType.create("18446744073709551615")));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.IntegerType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        IntegerValueType r4 = IntegerValueType.create(r2);
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.isNonNegative() == true) goto L9;
        return null;
    L9:
        if (upperBound.compareTo(r4) >= 0) goto L11;
        return null;
    L11:
        return r4;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.IntegerType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return NonNegativeIntegerType.theInstance;
    }
}
