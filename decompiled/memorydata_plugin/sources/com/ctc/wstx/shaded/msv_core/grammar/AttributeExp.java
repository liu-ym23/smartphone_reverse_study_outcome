package com.ctc.wstx.shaded.msv_core.grammar;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class AttributeExp extends Expression {
    private static final long serialVersionUID = 1;
    public final Expression exp;
    public final NameClass nameClass;

    public AttributeExp(NameClass r3, Expression r4) {
        super(r3.hashCode() + r4.hashCode());
        this.nameClass = r3;
        this.exp = r4;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean calcEpsilonReducibility() {
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final int calcHashCode() {
        return this.nameClass.hashCode() + this.exp.hashCode();
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean equals(Object r4) {
        if (r4.getClass() == AttributeExp.class) goto L5;
        return false;
    L5:
        AttributeExp r5 = (AttributeExp) ZeusTransformUtils.preCheckCast(r4, AttributeExp.class, "com.obric.memorydata.plugin");
        if (r5.nameClass.equals(this.nameClass) == true) goto L8;
        return false;
    L8:
        if (r5.exp.equals(this.exp) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public final Expression getContentModel() {
        return this.exp;
    }

    public final NameClass getNameClass() {
        return this.nameClass;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public Expression visit(e r3) {
        return ((e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public Object visit(c r3) {
        return ((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public void visit(f r3) {
        ((f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin")).a(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean visit(d r3) {
        return ((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin")).a(this);
    }
}
