package com.ctc.wstx.shaded.msv_core.datatype.xsd;

/* JADX INFO: loaded from: classes2.dex */
public class TokenType extends StringType {
    private static final long serialVersionUID = 1;
    public static final TokenType theInstance = null;

    static {
        theInstance = new TokenType("token", true);
    }

    public TokenType(String r2, boolean r3) {
        super(r2, WhiteSpaceProcessor.theCollapse, r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.StringType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public XSDatatype getBaseType() {
        return NormalizedStringType.theInstance;
    }
}
