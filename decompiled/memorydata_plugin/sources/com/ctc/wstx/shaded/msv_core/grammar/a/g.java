package com.ctc.wstx.shaded.msv_core.grammar.a;

import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.OtherExp;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.ctc.wstx.shaded.msv_core.grammar.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f3592b;
    private final boolean c;

    public g(ExpressionPool r1, boolean r2) {
        super(r1);
        this.f3592b = new HashSet();
        this.c = r2;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(AttributeExp r3) {
        Expression r0 = r3.exp.visit(this);
        if (r0 != Expression.nullSet) goto L7;
        return Expression.nullSet;
    L7:
        return this.f3593a.createAttribute(r3.nameClass, r0);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ElementExp r2) {
        if (this.c == true) goto L6;
        return r2;
    L6:
        if (this.f3592b.contains(r2) == true) goto L9;
        this.f3592b.add(r2);
        r2.contentModel = r2.contentModel.visit(this);
    L9:
        if (r2.contentModel == Expression.nullSet) goto L11;
        return r2;
    L11:
        return Expression.nullSet;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(OtherExp r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.e
    public Expression a(ReferenceExp r1) {
        return r1.exp.visit(this);
    }
}
