package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RedefinableExp extends ReferenceExp {
    private static final long serialVersionUID = 1;

    public RedefinableExp(String r1) {
        super(r1);
    }

    public abstract RedefinableExp getClone();

    public void redefine(RedefinableExp r3) {
        if (getClass() != r3.getClass()) goto L9;
        if (this.name.equals(r3.name) == false) goto L9;
        this.exp = r3.exp;
        return;
    L9:
        throw new IllegalArgumentException();
    }
}
