package com.ctc.wstx.shaded.msv_core.grammar.relax;

import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ElementRules extends ReferenceExp {
    private static final long serialVersionUID = 1;
    public boolean exported;
    public final RELAXModule ownerModule;

    public ElementRules(String r1, RELAXModule r2) {
        super(r1);
        this.exported = false;
        this.ownerModule = r2;
    }

    public void addElementRule(ExpressionPool r2, ElementRule r3) {
        r3.parent = this;
        if (this.exp != null) goto L5;
        this.exp = r3;
        return;
    L5:
        this.exp = r2.createChoice(this.exp, r3);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp, com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean calcEpsilonReducibility() {
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp, com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        return false;
    }

    public boolean isExported() {
        return this.exported;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public Expression visit(c r3) {
        return ((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public Object visit(a r3) {
        return ((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public void visit(d r3) {
        ((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean visit(b r3) {
        return ((b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin")).a(this);
    }
}
