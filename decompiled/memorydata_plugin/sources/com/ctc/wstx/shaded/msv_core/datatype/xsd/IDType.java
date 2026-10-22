package com.ctc.wstx.shaded.msv_core.datatype.xsd;

/* JADX INFO: loaded from: classes2.dex */
public class IDType extends NcnameType {
    private static final long serialVersionUID = 1;
    public static final IDType theInstance = null;

    static {
        theInstance = new IDType();
    }

    public IDType() {
        super("ID");
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatypeImpl, com.ctc.wstx.shaded.msv.relaxng_datatype.a
    public int getIdType() {
        return 1;
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.BuiltinAtomicType
    public Object readResolve() {
        return theInstance;
    }
}
