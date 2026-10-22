package com.ctc.wstx.shaded.msv_core.grammar.relax;

import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.NameClass;

/* JADX INFO: loaded from: classes2.dex */
public class ElementRule extends ElementExp {
    private static final long serialVersionUID = 1;
    public final Expression attributeFreeContentModel;
    public final TagClause clause;
    protected ElementRules parent;

    public ElementRule(ExpressionPool r2, TagClause r3, Expression r4) {
        super(r2.createSequence(r3, r4), true);
        this.clause = r3;
        this.attributeFreeContentModel = r4;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.ElementExp
    public final NameClass getNameClass() {
        return this.clause.nameClass;
    }

    public ElementRules getParent() {
        return this.parent;
    }
}
