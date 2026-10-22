package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ExpressionPool;
import com.ctc.wstx.shaded.msv_core.grammar.Grammar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.MessageFormat;
import java.util.ResourceBundle;

/* JADX INFO: loaded from: classes2.dex */
public class p implements com.ctc.wstx.shaded.msv_core.verifier.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Expression f3668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExpressionPool f3669b;
    protected final q c;
    protected final h d;
    protected final b e;
    protected final d f;
    protected final c g;
    protected final f h;
    protected final m i;
    public final g j;

    public p(Expression r7, ExpressionPool r8) {
        this.f3668a = r7;
        this.f3669b = r8;
        this.c = new q(r8);
        this.e = new b(this);
        this.g = new c(r8);
        this.f = new d(r8);
        this.h = new f(r8);
        this.d = new h(r8);
        this.i = new m();
        this.j = new g(this, null, null, null, null);
    }

    public p(Grammar r3) {
        Grammar r4 = (Grammar) ZeusTransformUtils.wrapperContextForParams(r3, Grammar.class, "com.obric.memorydata.plugin");
        this(r4.getTopLevel(), r4.getPool());
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.c
    public com.ctc.wstx.shaded.msv_core.verifier.b a() {
        return new r(this, this.f3668a, null, Expression.epsilon);
    }

    public final String a(String r3, Object r4) {
        return a(r3, new Object[]{r4});
    }

    public final String a(String r3, Object r4, Object r5) {
        return a(r3, new Object[]{r4, r5});
    }

    public String a(String r1, Object[] r2) {
        return MessageFormat.format(ResourceBundle.getBundle("com.ctc.wstx.shaded.msv_core.verifier.regexp.Messages").getString(r1), r2);
    }
}
