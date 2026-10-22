package com.ctc.wstx.shaded.msv_core.relaxns.verifier;

import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.relaxns.grammar.DeclImpl;
import com.ctc.wstx.shaded.msv_core.verifier.a.j;
import com.ctc.wstx.shaded.msv_core.verifier.a.p;

/* JADX INFO: loaded from: classes2.dex */
public class c extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final DeclImpl[] f3635a;

    private c(p r2, Expression r3, Expression[] r4, DeclImpl[] r5) {
        super(r2, r3, r4, false);
        this.f3635a = r5;
    }

    public c(p r3, DeclImpl[] r4) {
        this(r3, a(r3.f3669b, r4), a(r4), r4);
    }

    private static Expression a(ExpressionPool r3, DeclImpl[] r4) {
        Expression r0 = Expression.nullSet;
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L6;
        r0 = r3.createChoice(r0, r4[r1].exp);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private static Expression[] a(DeclImpl[] r3) {
        Expression[] r0 = new Expression[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0[r1] = r3[r1].exp;
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
