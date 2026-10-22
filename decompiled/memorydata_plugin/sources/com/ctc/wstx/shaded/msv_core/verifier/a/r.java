package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;

/* JADX INFO: loaded from: classes2.dex */
public class r extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Expression f3672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ElementExp f3673b;

    public r(p r2, Expression r3, ElementExp r4, Expression r5) {
        if (r4 != null) goto L4;
        boolean r0 = true;
    L5:
        super(r2, r3, r0);
        this.f3672a = r5;
        this.f3673b = r4;
        return;
    L4:
        r0 = r4.ignoreUndeclaredAttributes;
        goto L5
    }
}
