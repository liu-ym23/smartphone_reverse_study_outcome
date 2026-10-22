package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
abstract class BinaryBaseType extends BuiltinAtomicType implements c {
    private static final long serialVersionUID = -6355125980881791215L;

    BinaryBaseType(String r1) {
        super(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.ConcreteType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createJavaObject(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        BinaryValueType r2 = (BinaryValueType) ZeusTransformUtils.preCheckCast(createValue(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")), BinaryValueType.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.rawData;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.c
    public final int countLength(Object r2) {
        return ((BinaryValueType) ZeusTransformUtils.preCheckCast(r2, BinaryValueType.class, "com.obric.memorydata.plugin")).rawData.length;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return byte[].class;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int isFacetApplicable(String r1) {
        if (r1.equals(XSDatatype.FACET_LENGTH) == false) goto L5;
        return 0;
    L5:
        if (r1.equals(XSDatatype.FACET_MAXLENGTH) == false) goto L7;
        return 0;
    L7:
        if (r1.equals(XSDatatype.FACET_MINLENGTH) == false) goto L9;
        return 0;
    L9:
        if (r1.equals(XSDatatype.FACET_PATTERN) == false) goto L11;
        return 0;
    L11:
        if (r1.equals(XSDatatype.FACET_WHITESPACE) == false) goto L13;
        return 0;
    L13:
        if (r1.equals(XSDatatype.FACET_ENUMERATION) == true) goto L23;
        return -2;
    L23:
        return 0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.ConcreteType, com.ctc.wstx.shaded.msv_core.datatype.a
    public abstract String serializeJavaObject(Object r1, com.ctc.wstx.shaded.msv_core.datatype.c r2);
}
