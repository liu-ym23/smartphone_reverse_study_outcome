package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class IdentityConstraint implements Serializable {
    private static final long serialVersionUID = 1;
    public final Field[] fields;
    public final String localName;
    public final String namespaceURI;
    public final XPath[] selectors;

    public IdentityConstraint(String r1, String r2, XPath[] r3, Field[] r4) {
        this.namespaceURI = r1;
        this.localName = r2;
        this.selectors = r3;
        this.fields = r4;
    }
}
