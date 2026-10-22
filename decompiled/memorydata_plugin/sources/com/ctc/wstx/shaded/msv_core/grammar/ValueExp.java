package com.ctc.wstx.shaded.msv_core.grammar;

import com.ctc.wstx.shaded.msv_core.util.StringPair;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class ValueExp extends Expression implements a {
    private static final long serialVersionUID = 1;
    public final com.ctc.wstx.shaded.msv.relaxng_datatype.a dt;
    public final StringPair name;
    public final Object value;

    public ValueExp(com.ctc.wstx.shaded.msv.relaxng_datatype.a r3, StringPair r4, Object r5) {
        com.ctc.wstx.shaded.msv.relaxng_datatype.a r6 = (com.ctc.wstx.shaded.msv.relaxng_datatype.a) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.shaded.msv.relaxng_datatype.a.class, "com.obric.memorydata.plugin");
        super(r6.hashCode() + r6.valueHashCode(r5));
        this.dt = r6;
        this.name = r4;
        this.value = r5;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean calcEpsilonReducibility() {
        return false;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public final int calcHashCode() {
        return this.dt.hashCode() + this.dt.valueHashCode(this.value);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.Expression
    public boolean equals(Object r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getClass() == getClass()) goto L8;
        return false;
    L8:
        ValueExp r5 = (ValueExp) ZeusTransformUtils.preCheckCast(r4, ValueExp.class, "com.obric.memorydata.plugin");
        if (r5.dt.equals(this.dt) == true) goto L12;
        return false;
    L12:
        return this.dt.sameValue(this.value, r5.value);
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
