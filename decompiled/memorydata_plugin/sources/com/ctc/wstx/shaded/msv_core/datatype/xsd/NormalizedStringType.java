package com.ctc.wstx.shaded.msv_core.datatype.xsd;

/* JADX INFO: loaded from: classes2.dex */
public class NormalizedStringType extends StringType {
    private static final long serialVersionUID = 1;
    public static final NormalizedStringType theInstance = null;

    static {
        theInstance = new NormalizedStringType("normalizedString", true);
    }

    public NormalizedStringType(String r2, boolean r3) {
        super(r2, WhiteSpaceProcessor.theReplace, r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.StringType, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public XSDatatype getBaseType() {
        return StringType.theInstance;
    }
}
