package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class UnsignedIntType extends LongType {
    private static final long serialVersionUID = 1;
    public static final UnsignedIntType theInstance = null;
    private static final long upperBound = 4294967295L;

    static {
        theInstance = new UnsignedIntType();
    }

    private UnsignedIntType() {
        super("unsignedInt", createRangeFacet(UnsignedLongType.theInstance, null, new Long(upperBound)));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.LongType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e r5) {
        Long r3 = (Long) ZeusTransformUtils.preCheckCast(super._createValue(r4, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r5, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")), Long.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L14
        if (r3 != null) goto L7;
        return null;
    L7:
        if (r3.longValue() >= 0) goto L9;
        return null;
    L9:
        if (r3.longValue() <= upperBound) goto L13;
        return null;
    L13:
        return r3;
    L14:
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.LongType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return UnsignedLongType.theInstance;
    }
}
