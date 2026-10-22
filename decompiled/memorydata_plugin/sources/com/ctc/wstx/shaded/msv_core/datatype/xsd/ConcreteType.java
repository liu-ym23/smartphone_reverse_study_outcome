package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ConcreteType extends XSDatatypeImpl {
    private static final long serialVersionUID = 1;

    public ConcreteType(String r2, String r3) {
        this(r2, r3, WhiteSpaceProcessor.theCollapse);
    }

    public ConcreteType(String r1, String r2, WhiteSpaceProcessor r3) {
        super(r1, r2, r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public void _checkValid(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        if (checkFormat(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin")) == false) goto L6;
        return;
    L6:
        throw new DatatypeException(-1, localize(XSDatatypeImpl.ERR_INAPPROPRIATE_FOR_TYPE, r3, getName()));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createJavaObject(String r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e r4) {
        return _createValue(r3, (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public final ConcreteType getConcreteType() {
        return this;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public boolean isFinal(int r1) {
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.a
    public String serializeJavaObject(Object r3, com.ctc.wstx.shaded.msv_core.datatype.c r4) {
        String r5 = convertToLexicalValue(r3, (com.ctc.wstx.shaded.msv_core.datatype.c) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.datatype.c.class, "com.obric.memorydata.plugin"));
        if (isValid(r5, serializedValueChecker) == true) goto L6;
        return null;
    L6:
        return r5;
    }
}
