package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public class ByteType extends IntegerDerivedType {
    private static final long serialVersionUID = 1;
    public static final ByteType theInstance = null;

    static {
        theInstance = new ByteType();
    }

    private ByteType() {
        super("byte", createRangeFacet(ShortType.theInstance, new Byte((byte) -128), new Byte(ByteCompanionObject.MAX_VALUE)));
    }

    public static Byte load(String r1) {
        return new Byte(removeOptionalPlus(r1));
    L4:
        return null;
    }

    public static String save(Byte r0) {
        return r0.toString();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return load(r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.IntegerDerivedType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public /* synthetic */ String convertToLexicalValue(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        return super.convertToLexicalValue(r3, (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return ShortType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.IntegerDerivedType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public /* bridge */ /* synthetic */ DataTypeWithFacet getFacetObject(String r1) {
        return super.getFacetObject(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return Byte.class;
    }
}
