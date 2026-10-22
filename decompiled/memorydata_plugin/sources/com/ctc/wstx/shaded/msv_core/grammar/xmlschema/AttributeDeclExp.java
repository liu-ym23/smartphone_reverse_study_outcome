package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;

/* JADX INFO: loaded from: classes2.dex */
public class AttributeDeclExp extends ReferenceExp {
    private static final long serialVersionUID = 1;
    public AttributeExp self;

    public AttributeDeclExp(String r1) {
        super(r1);
    }

    public void set(AttributeExp r1) {
        this.self = r1;
        this.exp = r1;
    }
}
