package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class UnsignedByteType extends ShortType {
    private static final long serialVersionUID = 1;
    public static final UnsignedByteType theInstance = null;
    private static final short upperBound = 255;

    static {
        theInstance = new UnsignedByteType();
    }

    private UnsignedByteType() {
        super("unsignedByte", createRangeFacet(UnsignedShortType.theInstance, null, new Short(255)));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.ShortType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        Short r2 = (Short) ZeusTransformUtils.preCheckCast(super._createValue(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")), Short.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L14
        if (r2 != null) goto L7;
        return null;
    L7:
        if (r2.shortValue() >= 0) goto L9;
        return null;
    L9:
        if (r2.shortValue() <= 255) goto L13;
        return null;
    L13:
        return r2;
    L14:
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.ShortType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return UnsignedShortType.theInstance;
    }
}
