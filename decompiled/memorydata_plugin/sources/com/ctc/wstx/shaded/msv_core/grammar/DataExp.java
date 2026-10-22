package com.ctc.wstx.shaded.msv_core.grammar;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.ctc.wstx.shaded.msv_core.util.StringPair;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class DataExp extends Expression implements a {
    private static final long serialVersionUID = 1;
    public final com.ctc.wstx.shaded.msv.relaxng_datatype.a dt;
    public final Expression except;
    public final StringPair name;

    public DataExp(com.ctc.wstx.shaded.msv.relaxng_datatype.a r3, StringPair r4, Expression r5) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.a r6 = (com.ctc.wstx.shaded.msv.relaxng_datatype.a) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.a.class, "com.obric.memorydata.plugin");
        super(r6.hashCode() + r5.hashCode());
        this.dt = r6;
        this.name = r4;
        this.except = r5;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean calcEpsilonReducibility() {
        XSDatatype r0 = (XSDatatype) ZeusTransformUtils.preCheckCast(this.dt, XSDatatype.class, "com.obric.memorydata.plugin");
        if (this.except == Expression.nullSet) goto L5;
        return false;
    L5:
        if (r0.isAlwaysValid() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final int calcHashCode() {
        return this.dt.hashCode() + this.except.hashCode();
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean equals(Object r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getClass() == getClass()) goto L8;
        return false;
    L8:
        DataExp r5 = (DataExp) ZeusTransformUtils.preCheckCast(r4, DataExp.class, "com.obric.memorydata.plugin");
        if (this.except == r5.except) goto L12;
        return false;
    L12:
        return r5.dt.equals(this.dt);
    }

    public StringPair getName() {
        return this.name;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.a
    public com.ctc.wstx.shaded.msv.relaxng_datatype.a getType() {
        return this.dt;
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
