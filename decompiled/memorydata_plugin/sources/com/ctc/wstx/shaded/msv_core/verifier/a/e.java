package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;

/* JADX INFO: loaded from: classes2.dex */
final class e extends g {
    private Expression g;

    e(p r1, String r2, String r3, String r4, u r5) {
        super(r1, r2, r3, r4, r5);
        this.g = Expression.nullSet;
    }

    Expression a() {
        return this.g;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.a.g, com.ctc.wstx.shaded.msv_core.verifier.a.v
    public boolean a(AttributeExp r4) {
        if (r4.nameClass.accepts(this.f3652a, this.f3653b) == true) goto L7;
        return false;
    L7:
        if (this.e.c.a(r4.exp, this.d).isEpsilonReducible() == true) goto L11;
        this.g = this.e.f3669b.createChoice(this.g, r4.exp);
        return true;
    L11:
        return true;
    }
}
