package com.ctc.wstx.shaded.msv_core.relaxns.grammar.relax;

import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.OtherExp;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.ctc.wstx.shaded.msv_core.grammar.SimpleNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.relax.AttPoolClause;
import com.ctc.wstx.shaded.msv_core.grammar.relax.ElementRules;
import com.ctc.wstx.shaded.msv_core.grammar.relax.HedgeRules;
import com.ctc.wstx.shaded.msv_core.grammar.relax.RELAXModule;
import com.ctc.wstx.shaded.msv_core.grammar.relax.TagClause;
import com.ctc.wstx.shaded.msv_core.grammar.relax.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class a extends com.ctc.wstx.shaded.msv_core.grammar.b implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3631b;

    a(ExpressionPool r1) {
        super(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(AttributeExp r4) {
        if (ZeusTransformUtils.instanceOf(r4.nameClass, SimpleNameClass.class) == true) goto L5;
        return r4;
    L5:
        SimpleNameClass r0 = (SimpleNameClass) ZeusTransformUtils.preCheckCast(r4.nameClass, SimpleNameClass.class, "com.obric.memorydata.plugin");
        if (r0.namespaceURI.equals("") == true) goto L9;
        return r4;
    L9:
        return this.f3593a.createAttribute(new SimpleNameClass(this.f3631b, r0.localName), r4.exp);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ElementExp r1) {
        throw new Error();
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(OtherExp r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ReferenceExp r1) {
        throw new Error();
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.relax.c
    public Expression a(AttPoolClause r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.relax.c
    public Expression a(ElementRules r1) {
        throw new Error();
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.relax.c
    public Expression a(HedgeRules r1) {
        throw new Error();
    }

    public Expression a(RELAXModule r1, Expression r2) {
        this.f3631b = r1.targetNamespace;
        return r2.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.relax.c
    public Expression a(TagClause r1) {
        throw new Error();
    }
}
