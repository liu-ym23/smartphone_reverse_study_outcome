package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f3664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map f3665b;
    final Map c;
    Expression d;

    protected static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ElementExp f3666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Expression f3667b;

        public a(ElementExp r1, Expression r2) {
            this.f3666a = r1;
            this.f3667b = r2;
        }
    }

    o() {
        this.f3664a = -1;
        this.f3665b = new Hashtable();
        this.c = new Hashtable();
    }
}
