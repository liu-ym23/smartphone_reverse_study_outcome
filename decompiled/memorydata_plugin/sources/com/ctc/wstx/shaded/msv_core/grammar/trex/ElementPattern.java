package com.ctc.wstx.shaded.msv_core.grammar.trex;

import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.NameClass;

/* JADX INFO: loaded from: classes2.dex */
public class ElementPattern extends ElementExp {
    private static final long serialVersionUID = 1;
    public final NameClass nameClass;

    public ElementPattern(NameClass r2, Expression r3) {
        super(r3, false);
        this.nameClass = r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.ElementExp
    public final NameClass getNameClass() {
        return this.nameClass;
    }
}
