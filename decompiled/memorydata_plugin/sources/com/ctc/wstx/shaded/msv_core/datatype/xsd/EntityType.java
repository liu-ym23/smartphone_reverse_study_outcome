package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class EntityType extends BuiltinAtomicType {
    private static final long serialVersionUID = 1;
    public static final EntityType theInstance = null;

    static {
        theInstance = new EntityType();
    }

    private EntityType() {
        super("ENTITY");
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        if (((com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")).b(r2) == false) goto L5;
        return r2;
    L5:
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean checkFormat(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        return ((com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")).b(r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r2, com.ctc.wstx.shaded.msv_core.datatype.c r3) {
        com.ctc.wstx.shaded.msv_core.datatype.c r1 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return NcnameType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return String.class;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean isContextDependent() {
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int isFacetApplicable(String r1) {
        if (r1.equals(XSDatatype.FACET_LENGTH) == false) goto L5;
        return 0;
    L5:
        if (r1.equals(XSDatatype.FACET_MINLENGTH) == false) goto L7;
        return 0;
    L7:
        if (r1.equals(XSDatatype.FACET_MAXLENGTH) == false) goto L9;
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
}
