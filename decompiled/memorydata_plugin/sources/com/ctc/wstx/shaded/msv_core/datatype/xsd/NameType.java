package com.ctc.wstx.shaded.msv_core.datatype.xsd;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NameType extends TokenType {
    private static final long serialVersionUID = 1;
    public static final NameType theInstance = null;

    static {
        theInstance = new NameType();
    }

    private NameType() {
        super("Name", false);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.StringType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl
    public Object _createValue(String r2, com.ctc.wstx.shaded.msv.relaxng_datatype.e r3) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.e r1 = (com.ctc.wstx.shaded.msv.relaxng_datatype.e) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.e.class, "com.obric.memorydata.plugin");
        if (f.a(r2) == false) goto L5;
        return r2;
    L5:
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.TokenType, com.ctc.wstx.shaded.msv_core.datatype.xsd.StringType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final XSDatatype getBaseType() {
        return TokenType.theInstance;
    }
}
