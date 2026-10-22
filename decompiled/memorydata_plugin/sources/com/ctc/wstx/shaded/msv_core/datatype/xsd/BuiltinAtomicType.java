package com.ctc.wstx.shaded.msv_core.datatype.xsd;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BuiltinAtomicType extends ConcreteType {
    private static final long serialVersionUID = 1;

    public BuiltinAtomicType(String r2) {
        this(r2, WhiteSpaceProcessor.theCollapse);
    }

    public BuiltinAtomicType(String r2, WhiteSpaceProcessor r3) {
        super("http://www.w3.org/2001/XMLSchema", r2, r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final String displayName() {
        return getName();
    }

    @Override // com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype
    public final int getVariety() {
        return 1;
    }

    public Object readResolve() {
        String r0 = getName();
        if (r0 == null) goto L9;
        return b.a(r0);
    L10:
        return this;
    L9:
        return this;
    }
}
