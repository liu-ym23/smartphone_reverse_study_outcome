package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

/* JADX INFO: loaded from: classes2.dex */
public abstract class XMLSchemaTypeExp extends RedefinableExp {
    public static final int EXTENSION = 2;
    public static final int RESTRICTION = 1;
    private static final long serialVersionUID = 1;

    XMLSchemaTypeExp(String r1) {
        super(r1);
    }

    public abstract int getBlock();
}
