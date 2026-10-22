package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes2.dex */
public class NegativeIntegerType extends IntegerType {
    private static final long serialVersionUID = 1;
    public static final NegativeIntegerType theInstance = null;

    static {
        theInstance = new NegativeIntegerType();
    }

    private NegativeIntegerType() {
        super("negativeInteger", createRangeFacet(NonPositiveIntegerType.theInstance, null, IntegerValueType.create(StructuredDataId.RESERVED)));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.IntegerType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        Object r2 = super._createValue(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin"));
        if (r2 != null) goto L5;
        return null;
    L5:
        IntegerValueType r5 = (IntegerValueType) ZeusTransformUtils.preCheckCast(r2, IntegerValueType.class, "com.obric.memorydata.plugin");
        if (r5.isNegative() == true) goto L8;
        return null;
    L8:
        return r5;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.IntegerType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return NonPositiveIntegerType.theInstance;
    }
}
