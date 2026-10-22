package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ErrorType extends BuiltinAtomicType {
    private static final long serialVersionUID = 1;
    public static final ErrorType theInstance = null;

    static {
        theInstance = new ErrorType();
    }

    public ErrorType() {
        super("error");
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r4 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return this;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public boolean checkFormat(String r1, com.ctc.wstx.shaded.msv.relaxng_datatype.e r2) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r0 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public String convertToLexicalValue(Object r1, com.ctc.wstx.shaded.msv_core.datatype.c r2) {
        com.ctc.wstx.shaded.msv_core.datatype.c r0 = (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r2, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin");
        return "";
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public XSDatatype getBaseType() {
        return SimpleURType.theInstance;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public Class getJavaObjectType() {
        return getClass();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public int isFacetApplicable(String r1) {
        return 0;
    }
}
