package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class UnsignedShortType extends IntType {
    private static final long serialVersionUID = 1;
    public static final UnsignedShortType theInstance = null;
    private static final int upperBound = 65535;

    static {
        theInstance = new UnsignedShortType();
    }

    private UnsignedShortType() {
        super("unsignedShort", createRangeFacet(UnsignedIntType.theInstance, null, new Integer(65535)));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.IntType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(super._createValue(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")), Integer.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L14
        if (r2 != null) goto L7;
        return null;
    L7:
        if (r2.intValue() >= 0) goto L9;
        return null;
    L9:
        if (r2.intValue() <= 65535) goto L13;
        return null;
    L13:
        return r2;
    L14:
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.IntType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public XSDatatype getBaseType() {
        return UnsignedIntType.theInstance;
    }
}
