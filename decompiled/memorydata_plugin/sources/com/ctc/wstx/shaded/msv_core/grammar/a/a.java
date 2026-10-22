package com.ctc.wstx.shaded.msv_core.grammar.a;

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
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.ctc.wstx.shaded.msv_core.grammar.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3586a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3587b = null;
    public static final a c = null;
    protected final int d;

    static {
        f3586a = new a(1);
        f3587b = new a(2);
        c = new a(3);
    }

    public a(int r1) {
        this.d = r1;
    }

    public static String a(Expression r2) {
        return (String) ZeusTransformUtils.preCheckCast(r2.visit(f3587b), String.class, "com.obric.memorydata.plugin");
    }

    public static String b(Expression r2) {
        return (String) ZeusTransformUtils.preCheckCast(r2.visit(c), String.class, "com.obric.memorydata.plugin");
    }

    public static boolean c(Expression r1) {
        return ZeusTransformUtils.instanceOf(r1, BinaryExp.class);
    }

    private Object d(Expression r4) {
        if (ZeusTransformUtils.instanceOf(r4, OneOrMoreExp.class) == false) goto L11;
        OneOrMoreExp r5 = (OneOrMoreExp) ZeusTransformUtils.preCheckCast(r4, OneOrMoreExp.class, "com.obric.memorydata.plugin");
        if (c(r5.exp) == false) goto L9;
        StringBuilder r3 = new StringBuilder().append("(").append(r5.exp.visit(this));
        String r6 = ")*";
    L8:
        return r3.append(r6).toString();
    L9:
        r3 = new StringBuilder().append(r5.exp.visit(this));
        r6 = "*";
        goto L8
    L11:
        if (c(r4) == false) goto L13;
        r3 = new StringBuilder().append("(").append(r4.visit(this));
        r6 = ")?";
        goto L8
    L13:
        r3 = new StringBuilder().append(r4.visit(this));
        r6 = "?";
        goto L8
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a() {
        return "#epsilon";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(AttributeExp r3) {
        return "@" + r3.nameClass.toString() + "<" + r3.exp.visit(this) + ">";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(ChoiceExp r3) {
        if (r3.exp1 != Expression.epsilon) goto L7;
        return d(r3.exp2);
    L7:
        if (r3.exp2 != Expression.epsilon) goto L11;
        return d(r3.exp1);
    L11:
        return a(r3, "|");
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(ConcurExp r2) {
        return a(r2, "&");
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(DataExp r2) {
        return "$" + r2.name.localName;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(ElementExp r3) {
        if ((this.d & 2) == 0) goto L7;
        return r3.getNameClass().toString();
    L7:
        return r3.getNameClass().toString() + "<" + r3.contentModel.visit(this) + ">";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(InterleaveExp r2) {
        return a(r2, "^");
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(ListExp r3) {
        return "list[" + r3.exp.visit(this) + "]";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(MixedExp r3) {
        return "mixed[" + r3.exp.visit(this) + "]";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(OneOrMoreExp r3) {
        if (c(r3.exp) == false) goto L7;
        StringBuilder r2 = new StringBuilder().append("(").append(r3.exp.visit(this));
        String r4 = ")+";
    L6:
        return r2.append(r4).toString();
    L7:
        r2 = new StringBuilder().append(r3.exp.visit(this));
        r4 = Marker.ANY_NON_NULL_MARKER;
        goto L6
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(OtherExp r3) {
        return r3.printName() + "[" + r3.exp.visit(this) + "]";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(ReferenceExp r3) {
        if ((this.d & 1) == 0) goto L7;
        StringBuilder r2 = new StringBuilder().append("{%").append(r3.name);
        String r4 = "}";
    L6:
        return r2.append(r4).toString();
    L7:
        r2 = new StringBuilder().append("(").append(r3.exp.visit(this));
        r4 = ")";
        goto L6
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(SequenceExp r2) {
        return a(r2, ",");
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object a(ValueExp r2) {
        return "$$" + r2.value;
    }

    public String a(BinaryExp r6, String r7) {
        if (r6.exp1.getClass() != r6.getClass()) goto L5;
    L8:
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.exp1.visit(this), String.class, "com.obric.memorydata.plugin");
    L9:
        String r8 = r0 + r7;
        if (c(r6.exp2) == true) goto L12;
        StringBuilder r5 = new StringBuilder().append(r8).append(r6.exp2.visit(this));
    L14:
        return r5.toString();
    L12:
        r5 = new StringBuilder().append(r8).append("(").append(r6.exp2.visit(this)).append(")");
        goto L14
    L5:
        if (c(r6.exp1) == false) goto L8;
        r0 = "(" + r6.exp1.visit(this) + ")";
        goto L9
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object b() {
        return "#nullSet";
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public Object c() {
        return "<anyString>";
    }
}
