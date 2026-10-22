package com.ctc.wstx.shaded.msv_core.datatype.xsd;

/* JADX INFO: loaded from: classes2.dex */
public final class FinalComponent extends Proxy {
    private static final long serialVersionUID = 1;
    private final int finalValue;

    public FinalComponent(XSDatatypeImpl r3, int r4) {
        this(r3.getNamespaceUri(), r3.getName(), r3, r4);
    }

    public FinalComponent(String r1, String r2, XSDatatypeImpl r3, int r4) {
        super(r1, r2, r3);
        this.finalValue = r4;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.Proxy, com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public boolean isFinal(int r2) {
        if ((this.finalValue & r2) == 0) goto L7;
        return true;
    L7:
        return super.isFinal(r2);
    }
}
