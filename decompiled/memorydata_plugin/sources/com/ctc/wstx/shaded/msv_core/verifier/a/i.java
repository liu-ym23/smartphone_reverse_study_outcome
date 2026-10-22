package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ElementExp[] f3658a;

    public i(p r2, Expression r3, ElementExp[] r4) {
        this(r2, r3, a(r4, r2.f3669b), r4);
    }

    public i(p r2, Expression r3, Expression[] r4, ElementExp[] r5) {
        super(r2, r3, r4, r5[0].ignoreUndeclaredAttributes);
        this.f3658a = r5;
    }

    private static Expression[] a(ElementExp[] r3, ExpressionPool r4) {
        Expression[] r0 = new Expression[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0[r1] = r3[r1].contentModel.getExpandedExp(r4);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public final ElementExp[] b() {
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= this.f3659b.length) goto L9;
        if (this.f3659b[r1].isEpsilonReducible() == false) goto L8;
        r2 = r2 + 1;
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        if (r2 == 0) goto L11;
        ElementExp[] r3 = new ElementExp[r2];
        int r4 = 0;
    L14:
        if (r0 >= this.f3659b.length) goto L19;
        if (this.f3659b[r0].isEpsilonReducible() == false) goto L18;
        r3[r4] = this.f3658a[r0];
        r4 = r4 + 1;
    L18:
        r0 = r0 + 1;
        goto L14
    L19:
        return r3;
    L11:
        return new ElementExp[0];
    }
}
