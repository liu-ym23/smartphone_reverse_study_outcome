package com.ctc.wstx.shaded.msv_core.grammar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Expression implements Serializable {
    public static final Expression anyString = null;
    public static final Expression epsilon = null;
    public static final Expression nullSet = null;
    private static final long serialVersionUID = -569561418606215601L;
    private transient int cachedHashCode;
    private Boolean epsilonReducibility;
    private Expression expandedExp;
    public transient Object verifierTag;

    private static class AnyStringExpression extends Expression {
        private static final long serialVersionUID = 1;

        AnyStringExpression() {
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public boolean calcEpsilonReducibility() {
            return true;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public final int calcHashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public Object readResolve() {
            return Expression.anyString;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public Expression visit(e r2) {
            return ((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin")).c();
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public Object visit(c r2) {
            return ((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin")).c();
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public void visit(f r2) {
            ((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin")).c();
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public boolean visit(d r2) {
            return ((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin")).c();
        }
    }

    private static class EpsilonExpression extends Expression {
        private static final long serialVersionUID = 1;

        EpsilonExpression() {
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public boolean calcEpsilonReducibility() {
            return true;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public final int calcHashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public Object readResolve() {
            return Expression.epsilon;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public Expression visit(e r2) {
            return ((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin")).a();
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public Object visit(c r2) {
            return ((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin")).a();
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public void visit(f r2) {
            ((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin")).a();
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public boolean visit(d r2) {
            return ((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin")).a();
        }
    }

    private static class NullSetExpression extends Expression {
        private static final long serialVersionUID = 1;

        NullSetExpression() {
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public boolean calcEpsilonReducibility() {
            return false;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public final int calcHashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public boolean equals(Object r1) {
            if (this != r1) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public Object readResolve() {
            return Expression.nullSet;
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public Expression visit(e r2) {
            return ((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin")).b();
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public Object visit(c r2) {
            return ((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin")).b();
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public void visit(f r2) {
            ((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin")).b();
        }

        @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
        public boolean visit(d r2) {
            return ((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin")).b();
        }
    }

    static {
        epsilon = new EpsilonExpression();
        nullSet = new NullSetExpression();
        anyString = new AnyStringExpression();
    }

    public Expression() {
        this.expandedExp = null;
        this.verifierTag = null;
        this.cachedHashCode = System.identityHashCode(this);
    }

    public Expression(int r2) {
        this.expandedExp = null;
        this.verifierTag = null;
        setHashCode(r2);
    }

    public static int hashCode(Object r0, int r1) {
        return r0.hashCode() + r1;
    }

    public static int hashCode(Object r0, Object r1, int r2) {
        return (r0.hashCode() + r1.hashCode()) + r2;
    }

    private final void setHashCode(int r2) {
        this.cachedHashCode = r2 ^ getClass().hashCode();
    }

    public abstract boolean calcEpsilonReducibility();

    public abstract int calcHashCode();

    public abstract boolean equals(Object r1);

    public Expression getExpandedExp(ExpressionPool r3) {
        if (this.expandedExp != null) goto L6;
        this.expandedExp = visit(new com.ctc.wstx.shaded.msv_core.grammar.a.g(r3, false));
    L6:
        return this.expandedExp;
    }

    public final int hashCode() {
        return this.cachedHashCode;
    }

    public boolean isEpsilonReducible() {
        if (this.epsilonReducibility != null) goto L10;
        if (calcEpsilonReducibility() == false) goto L7;
        Boolean r0 = Boolean.TRUE;
    L8:
        this.epsilonReducibility = r0;
        goto L10
    L7:
        r0 = Boolean.FALSE;
    L10:
        return this.epsilonReducibility.booleanValue();
    }

    public final Expression peelOccurence() {
        if (ZeusTransformUtils.instanceOf(this, ChoiceExp.class) == false) goto L13;
        ChoiceExp r0 = (ChoiceExp) ZeusTransformUtils.preCheckCast(this, ChoiceExp.class, "com.obric.memorydata.plugin");
        Expression r2 = r0.exp1;
        Expression r3 = epsilon;
        if (r2 != r3) goto L10;
        Expression r4 = r0.exp2;
    L8:
        return r4.peelOccurence();
    L10:
        if (r0.exp2 != r3) goto L13;
        r4 = r0.exp1;
    L13:
        if (ZeusTransformUtils.instanceOf(this, OneOrMoreExp.class) == false) goto L15;
        r4 = ((OneOrMoreExp) ZeusTransformUtils.preCheckCast(this, OneOrMoreExp.class, "com.obric.memorydata.plugin")).exp;
        goto L8
    L15:
        return this;
    }

    public Object readResolve() {
        setHashCode(calcHashCode());
        return this;
    }

    public abstract Expression visit(e r1);

    public Expression visit(com.ctc.wstx.shaded.msv_core.grammar.relax.c r3) {
        return visit((com.ctc.wstx.shaded.msv_core.grammar.relax.c) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv_core.grammar.relax.c.class, "com.obric.memorydata.plugin"));
    }

    public abstract Object visit(c r1);

    public Object visit(com.ctc.wstx.shaded.msv_core.grammar.relax.a r3) {
        return visit((com.ctc.wstx.shaded.msv_core.grammar.relax.a) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv_core.grammar.relax.a.class, "com.obric.memorydata.plugin"));
    }

    public abstract void visit(f r1);

    public void visit(com.ctc.wstx.shaded.msv_core.grammar.relax.d r3) {
        visit((com.ctc.wstx.shaded.msv_core.grammar.relax.d) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv_core.grammar.relax.d.class, "com.obric.memorydata.plugin"));
    }

    public abstract boolean visit(d r1);

    public boolean visit(com.ctc.wstx.shaded.msv_core.grammar.relax.b r3) {
        return visit((com.ctc.wstx.shaded.msv_core.grammar.relax.b) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv_core.grammar.relax.b.class, "com.obric.memorydata.plugin"));
    }
}
