package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NonPositiveIntegerType extends IntegerType {
    private static final long serialVersionUID = 1;
    public static final NonPositiveIntegerType theInstance = null;

    static {
        theInstance = new NonPositiveIntegerType();
    }

    private NonPositiveIntegerType() {
        super("nonPositiveInteger", createRangeFacet(IntegerType.theInstance, null, IntegerValueType.create("0")));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.IntegerType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        Object r2 = super._createValue(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin"));
        if (r2 != null) goto L5;
        return null;
    L5:
        IntegerValueType r5 = (IntegerValueType) ZeusTransformUtils.preCheckCast(r2, IntegerValueType.class, "com.obric.memorydata.plugin");
        if (r5.isNonPositive() == true) goto L8;
        return null;
    L8:
        return r5;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.IntegerType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return IntegerType.theInstance;
    }
}
