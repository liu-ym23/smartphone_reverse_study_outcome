package com.ctc.wstx.shaded.msv_core.grammar.trex.typed;

import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.NameClass;
import com.ctc.wstx.shaded.msv_core.grammar.trex.ElementPattern;

/* JADX INFO: loaded from: classes2.dex */
public class TypedElementPattern extends ElementPattern {
    private static final long serialVersionUID = 1;
    public final String label;

    public TypedElementPattern(NameClass r1, Expression r2, String r3) {
        super(r1, r2);
        this.label = r3;
    }
}
