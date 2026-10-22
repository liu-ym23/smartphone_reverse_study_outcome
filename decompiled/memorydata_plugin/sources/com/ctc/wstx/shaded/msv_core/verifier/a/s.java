package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.XSDatatype;
import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.BinaryExp;
import com.ctc.wstx.shaded.msv_core.grammar.ChoiceExp;
import com.ctc.wstx.shaded.msv_core.grammar.ConcurExp;
import com.ctc.wstx.shaded.msv_core.grammar.DataExp;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.InterleaveExp;
import com.ctc.wstx.shaded.msv_core.grammar.ListExp;
import com.ctc.wstx.shaded.msv_core.grammar.MixedExp;
import com.ctc.wstx.shaded.msv_core.grammar.OneOrMoreExp;
import com.ctc.wstx.shaded.msv_core.grammar.OtherExp;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.ctc.wstx.shaded.msv_core.grammar.SequenceExp;
import com.ctc.wstx.shaded.msv_core.grammar.ValueExp;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class s implements com.ctc.wstx.shaded.msv_core.grammar.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final s f3674a = null;

    static {
        f3674a = new s();
    }

    public s() {
    }

    public static int a(Expression r1) {
        Object r2 = r1.visit(f3674a);
        if (r2 != "anyString") goto L7;
        return 1;
    L7:
        if (r2 != "noString") goto L10;
        return 0;
    L10:
        return 2;
    }

    private Object a(BinaryExp r2) {
        Object r0 = r2.exp1.visit(this);
        Object r1 = r2.exp2.visit(this);
        if (r0 != "anyString") goto L7;
        if (r1 != "anyString") goto L7;
        return "anyString";
    L7:
        if (r0 != "noString") goto L10;
        if (r1 != "noString") goto L12;
        return "noString";
    L12:
        return "someString";
    L10:
        return "someString";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a() {
        return "noString";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(AttributeExp r1) {
        return "noString";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(ChoiceExp r1) {
        return a(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(ConcurExp r2) {
        Object r0 = r2.exp1.visit(this);
        Object r1 = r2.exp2.visit(this);
        if (r0 != "anyString") goto L7;
        if (r1 != "anyString") goto L7;
        return "anyString";
    L7:
        if (r0 == "noString") goto L12;
        if (r1 == "noString") goto L12;
        return "someString";
    L12:
        return "noString";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(DataExp r2) {
        if (r2.except == Expression.nullSet) goto L5;
        return "someString";
    L5:
        if (ZeusTransformUtils.instanceOf(r2.dt, XSDatatype.class) == true) goto L7;
        return "someString";
    L7:
        if (((XSDatatype) ZeusTransformUtils.preCheckCast(r2.dt, XSDatatype.class, "com.obric.memorydata.plugin")).isAlwaysValid() == false) goto L13;
        return "anyString";
    L13:
        return "someString";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(ElementExp r1) {
        return "noString";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(InterleaveExp r1) {
        return a(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(ListExp r1) {
        return "someString";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(MixedExp r1) {
        return "anyString";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(OneOrMoreExp r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(OtherExp r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(ReferenceExp r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(SequenceExp r2) {
        if (r2.exp1.isEpsilonReducible() == true) goto L7;
        return r2.exp1.visit(this);
    L7:
        return a(r2);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(ValueExp r1) {
        return "someString";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object b() {
        return "noString";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object c() {
        return "anyString";
    }
}
