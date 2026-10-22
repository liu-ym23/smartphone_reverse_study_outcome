package com.ctc.wstx.shaded.msv_core.datatype.xsd;

/* JADX INFO: loaded from: classes2.dex */
public class IDREFType extends NcnameType {
    private static final long serialVersionUID = 1;
    public static final IDREFType theInstance = null;

    static {
        theInstance = new IDREFType();
    }

    public IDREFType() {
        super("IDREF");
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl, com.ctc.wstx.shaded.msv.relaxng_datatype.a
    public int getIdType() {
        return 2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.BuiltinAtomicType
    public Object readResolve() {
        return theInstance;
    }
}
