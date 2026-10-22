package com.ctc.wstx.shaded.msv_core.verifier.a;

import com.ctc.wstx.shaded.msv.relaxng_datatype.DatatypeException;
import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.ChoiceExp;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.NameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NamespaceNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.NotNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.SimpleNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.ValueExp;
import com.ctc.wstx.shaded.msv_core.grammar.relax.NoneType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n implements com.ctc.wstx.shaded.msv_core.verifier.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Expression f3662a;
    protected final p c;
    protected final boolean d;

    public n(p r1, Expression r2, boolean r3) {
        this.c = r1;
        this.f3662a = r2;
        this.d = r3;
    }

    private String a(com.ctc.wstx.shaded.msv_core.grammar.a r2, u r3) {
        ((com.ctc.wstx.shaded.msv_core.grammar.a) ZeusTransformUtils.wrapperContextForParams(r2, com.ctc.wstx.shaded.msv_core.grammar.a.class, "com.obric.memorydata.plugin")).getType().checkValid(r3.f3677b, r3.c);     // Catch: DatatypeException -> L6
        return null;
    L6:
        e = move-exception;
        return e.getMessage();
    }

    private String a(com.ctc.wstx.shaded.msv_core.util.c r12) {
        h r0 = this.c.d;
        int r2 = 0;
        if (r0.a(this.f3662a, r12, false).f3656a != Expression.nullSet) goto L7;
        return this.c.a("Diagnosis.ElementNotAllowed", r12.c);
    L7:
        if (r0.f() == false) goto L9;
        return null;
    L9:
        HashSet r1 = new HashSet();
        ElementExp[] r4 = r0.d();
        int r3 = r0.e();
        boolean r5 = false;
        String r6 = null;
    L11:
        if (r2 >= r3) goto L33;
        if (r4[r2].contentModel.getExpandedExp(this.c.f3669b) == Expression.nullSet) goto L31;
        NameClass r8 = r4[r2].getNameClass();
        if (ZeusTransformUtils.instanceOf(r8, SimpleNameClass.class) == false) goto L23;
        SimpleNameClass r7 = (SimpleNameClass) ZeusTransformUtils.preCheckCast(r8, SimpleNameClass.class, "com.obric.memorydata.plugin");
        if (r7.localName.equals(r12.f3642b) == false) goto L20;
        r6 = r7.namespaceURI;
    L20:
        p r9 = this.c;
        String r10 = r8.toString();
        String r11 = "Diagnosis.SimpleNameClass";
    L21:
        r1.add(r9.a(r11, r10));
        goto L31
    L23:
        if (ZeusTransformUtils.instanceOf(r8, NamespaceNameClass.class) == false) goto L26;
        r9 = this.c;
        r10 = ((NamespaceNameClass) ZeusTransformUtils.preCheckCast(r8, NamespaceNameClass.class, "com.obric.memorydata.plugin")).namespaceURI;
        r11 = "Diagnosis.NamespaceNameClass";
        goto L21
    L26:
        if (ZeusTransformUtils.instanceOf(r8, NotNameClass.class) == false) goto L30;
        NameClass r13 = ((NotNameClass) ZeusTransformUtils.preCheckCast(r8, NotNameClass.class, "com.obric.memorydata.plugin")).child;
        if (ZeusTransformUtils.instanceOf(r13, NamespaceNameClass.class) == false) goto L30;
        r9 = this.c;
        r10 = ((NamespaceNameClass) ZeusTransformUtils.preCheckCast(r13, NamespaceNameClass.class, "com.obric.memorydata.plugin")).namespaceURI;
        r11 = "Diagnosis.NotNamespaceNameClass";
    L30:
        r5 = true;
    L31:
        r2 = r2 + 1;
        goto L11
    L33:
        if (r1.size() != 0) goto L35;
        return null;
    L35:
        if (r6 == null) goto L43;
        int r14 = r1.size();
        p r15 = this.c;
        String r16 = r12.f3642b;
        if (r14 != 1) goto L41;
        return r15.a("Diagnosis.BadTagName.WrongNamespace", r16, r6);
    L41:
        return r15.a("Diagnosis.BadTagName.ProbablyWrongNamespace", r16, r6);
    L43:
        return this.c.a("Diagnosis.BadTagName.WrapUp", r12.c, a(r1, r5, "Diagnosis.BadTagName.Separator", "Diagnosis.BadTagName.More"));
    }

    private String a(e r9) {
        Expression r0 = r9.a();
        if (ZeusTransformUtils.instanceOf(r0, com.ctc.wstx.shaded.msv_core.grammar.a.class) == false) goto L14;
        com.ctc.wstx.shaded.msv_core.grammar.a r1 = (com.ctc.wstx.shaded.msv_core.grammar.a) ZeusTransformUtils.preCheckCast(r0, com.ctc.wstx.shaded.msv_core.grammar.a.class, "com.obric.memorydata.plugin");
        if (r1.getType() == NoneType.theInstance) goto L7;
        String r2 = a(r1, r9.d);
        if (r2 != null) goto L12;
        return null;
    L12:
        return this.c.a("Diagnosis.BadAttributeValue.DataType", r9.c, r2);
    L7:
        return this.c.a("Diagnosis.UndeclaredAttribute", r9.c);
    L14:
        if (ZeusTransformUtils.instanceOf(r0, ChoiceExp.class) == false) goto L28;
        HashSet r3 = new HashSet();
        Expression[] r4 = ((ChoiceExp) ZeusTransformUtils.preCheckCast(r0, ChoiceExp.class, "com.obric.memorydata.plugin")).getChildren();
        int r5 = 0;
        boolean r6 = false;
    L17:
        if (r5 >= r4.length) goto L24;
        if (ZeusTransformUtils.instanceOf(r4[r5], ValueExp.class) == false) goto L21;
        r3.add(((ValueExp) ZeusTransformUtils.preCheckCast(r4[r5], ValueExp.class, "com.obric.memorydata.plugin")).value.toString());
    L22:
        r5 = r5 + 1;
        goto L17
    L21:
        r6 = true;
        goto L22
    L24:
        if (r3.size() != 0) goto L27;
        return null;
    L27:
        return this.c.a("Diagnosis.BadAttributeValue.WrapUp", r9.c, a(r3, r6, "Diagnosis.BadAttributeValue.Separator", "Diagnosis.BadAttributeValue.More"));
    L28:
        return null;
    }

    private String a(u r9) {
        t r0 = new t(r9);
        Expression r1 = this.c.c.a(this.f3662a, r0);
        if (r1 == Expression.nullSet) goto L5;
        this.f3662a = this.c.f3669b.createChoice(this.f3662a, r1);
        if (r0.f3675a.size() != 1) goto L23;
        com.ctc.wstx.shaded.msv_core.grammar.a r2 = (com.ctc.wstx.shaded.msv_core.grammar.a) ZeusTransformUtils.preCheckCast(r0.f3675a.iterator().next(), com.ctc.wstx.shaded.msv_core.grammar.a.class, "com.obric.memorydata.plugin");
        r2.getType().checkValid(r0.f3677b, r0.c);     // Catch: DatatypeException -> L16
        if (ZeusTransformUtils.instanceOf(r2, ValueExp.class) == false) goto L15;
        ValueExp r3 = (ValueExp) ZeusTransformUtils.preCheckCast(r2, ValueExp.class, "com.obric.memorydata.plugin");     // Catch: DatatypeException -> L16
        if (r3.dt.sameValue(r3.value, r3.dt.createValue(r0.f3677b, r0.c)) == true) goto L15;
        return this.c.a("Diagnosis.BadLiteral.IncorrectValue", r3.value.toString(), r9.f3677b.trim());
    L15:
        return null;
    L16:
        e = move-exception;
        if (e.getMessage() == null) goto L22;
        return e.getMessage();
    L22:
        return this.c.a("Diagnosis.BadLiteral.Generic", r9.f3677b.trim());
    L23:
        HashSet r4 = new HashSet();
        boolean r5 = false;
        Iterator r6 = r0.f3675a.iterator();
    L25:
        if (r6.hasNext() == false) goto L31;
        com.ctc.wstx.shaded.msv_core.grammar.a r7 = (com.ctc.wstx.shaded.msv_core.grammar.a) ZeusTransformUtils.preCheckCast(r6.next(), com.ctc.wstx.shaded.msv_core.grammar.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, ValueExp.class) == true) goto L28;
        r5 = true;
        goto L25
    L28:
        r4.add(((ValueExp) ZeusTransformUtils.preCheckCast(r7, ValueExp.class, "com.obric.memorydata.plugin")).value.toString());
        goto L25
    L31:
        if (r4.size() != 0) goto L34;
        return null;
    L34:
        return this.c.a("Diagnosis.BadLiteral.WrapUp", a(r4, r5, "Diagnosis.BadLiteral.Separator", "Diagnosis.BadLiteral.More"), r9.f3677b.trim());
    L5:
        return this.c.a("Diagnosis.StringNotAllowed", r9.f3677b.trim());
    }

    private String a(List r5, boolean r6, String r7, String r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        String r10 = this.c.a(r7, null);
        Collections.sort(r9, new AnonymousClass1(this));
        String r0 = "";
        int r2 = 0;
    L4:
        if (r2 >= r9.size()) goto L9;
        if (r0.length() == 0) goto L8;
        r0 = r0 + r10;
    L8:
        r0 = r0 + r9.get(r2);
        r2 = r2 + 1;
        goto L4
    L9:
        if (r6 == true) goto L11;
        return r0;
    L11:
        return r0 + this.c.a(r8, null);
    }

    private String a(Set r3, boolean r4, String r5, String r6) {
        return a(new Vector((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin")), r4, r5, r6);
    }

    private final com.ctc.wstx.shaded.msv_core.verifier.b b() {
        h.a r0 = this.c.d.a(this.f3662a, null, false);
        Expression r1 = this.c.f3669b.createChoice(this.f3662a, this.c.c.a(this.f3662a, a.f3648a));
        Expression r2 = r0.f3656a;
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L6;
        System.out.println("content model of recovery acceptor:" + com.ctc.wstx.shaded.msv_core.grammar.a.a.a(r2));
        System.out.println("continuation of recovery acceptor:" + com.ctc.wstx.shaded.msv_core.grammar.a.a.b(r1));
    L6:
        return a(r2, r1, null, 0);
    }

    private String b(com.ctc.wstx.shaded.msv_core.util.c r8) {
        Expression r0 = this.f3662a.visit(this.c.g);
        if (r0.isEpsilonReducible() == true) goto L34;
        HashSet r1 = new HashSet();
        boolean r2 = false;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, ChoiceExp.class) == false) goto L13;
        ChoiceExp r3 = (ChoiceExp) ZeusTransformUtils.preCheckCast(r0, ChoiceExp.class, "com.obric.memorydata.plugin");
        NameClass r4 = ((AttributeExp) ZeusTransformUtils.preCheckCast(r3.exp2, AttributeExp.class, "com.obric.memorydata.plugin")).nameClass;
        if (ZeusTransformUtils.instanceOf(r4, SimpleNameClass.class) == false) goto L10;
        r1.add(r4.toString());
    L11:
        r0 = r3.exp1;
        goto L6
    L10:
        r2 = true;
        goto L11
    L13:
        if (r0 != Expression.nullSet) goto L16;
        return null;
    L16:
        if (ZeusTransformUtils.instanceOf(r0, AttributeExp.class) == false) goto L32;
        NameClass r5 = ((AttributeExp) ZeusTransformUtils.preCheckCast(r0, AttributeExp.class, "com.obric.memorydata.plugin")).nameClass;
        if (ZeusTransformUtils.instanceOf(r5, SimpleNameClass.class) == false) goto L20;
        r1.add(r5.toString());
    L22:
        if (r1.size() != 0) goto L25;
        return null;
    L25:
        if (r1.size() != 1) goto L30;
        if (r2 == true) goto L30;
        return this.c.a("Diagnosis.MissingAttribute.Simple", r8.c, r1.iterator().next());
    L30:
        return this.c.a("Diagnosis.MissingAttribute.WrapUp", r8.c, a(r1, r2, "Diagnosis.MissingAttribute.Separator", "Diagnosis.MissingAttribute.More"));
    L20:
        r2 = true;
        goto L22
    L32:
        throw new Error(r0.toString());
    L34:
        throw new Error();
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.b
    public int a() {
        o r0 = (o) ZeusTransformUtils.preCheckCast(this.f3662a.verifierTag, o.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        Expression r1 = this.f3662a;
        o r2 = new o();
        r1.verifierTag = r2;
        r0 = r2;
    L6:
        if (r0.f3664a != (-1)) goto L9;
        r0.f3664a = s.a(this.f3662a);
    L9:
        return r0.f3664a;
    }

    public abstract com.ctc.wstx.shaded.msv_core.verifier.b a(Expression r1, Expression r2, ElementExp[] r3, int r4);

    @Override // com.ctc.wstx.shaded.msv_core.verifier.b
    public com.ctc.wstx.shaded.msv_core.verifier.b a(com.ctc.wstx.shaded.msv_core.util.c r5, com.ctc.wstx.shaded.msv_core.util.d r6) {
        h r0 = this.c.d;
        h.a r1 = r0.a(this.f3662a, r5);
        if (r1.f3656a != Expression.nullSet) goto L5;
        if (r6 != null) goto L16;
        return null;
    L16:
        r6.f3643a = a(r5);
        if (r6.f3643a != null) goto L20;
        r6.f3643a = this.c.a("Diagnosis.BadTagName.Generic", r5.c);
    L20:
        return b();
    L5:
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L12;
        System.out.println("accept start tag <" + r5.c + ">. combined content pattern is");
        System.out.println(com.ctc.wstx.shaded.msv_core.grammar.a.a.a(r1.f3656a));
        if (r1.f3657b == null) goto L9;
        PrintStream r7 = System.out;
        String r8 = "continuation is:\n" + com.ctc.wstx.shaded.msv_core.grammar.a.a.a(r1.f3657b);
    L10:
        r7.println(r8);
        goto L12
    L9:
        r7 = System.out;
        r8 = "no continuation";
    L12:
        return a(r1.f3656a, r1.f3657b, r0.d(), r0.e());
    }

    public final boolean a(Expression r3, com.ctc.wstx.shaded.msv_core.util.d r4) {
        if (r3 != Expression.nullSet) goto L5;
        return false;
    L5:
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L7;
        System.out.println("stepForwardByCont. :  " + com.ctc.wstx.shaded.msv_core.grammar.a.a.a(r3));
    L7:
        this.f3662a = r3;
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.b
    public boolean a(com.ctc.wstx.shaded.msv_core.util.d r2) {
        if (r2 != null) goto L6;
        return this.f3662a.isEpsilonReducible();
    L6:
        if (this.f3662a.isEpsilonReducible() == false) goto L9;
        return true;
    L9:
        r2.f3643a = c();
        return false;
    }

    public boolean a(g r6, com.ctc.wstx.shaded.msv_core.util.d r7) {
        Expression r0 = this.c.e.a(this.f3662a, r6, this.d);
        if (r0 == Expression.nullSet) goto L8;
        this.f3662a = r0;
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L7;
        System.out.println("-- residual after :" + com.ctc.wstx.shaded.msv_core.grammar.a.a.a(r0));
    L7:
        return true;
    L8:
        if (r7 != null) goto L11;
        return false;
    L11:
        e r1 = r6.b();
        Expression r2 = this.c.e.a(this.f3662a, r1, this.d);
        if (r2 != Expression.nullSet) goto L19;
        Expression r3 = this.f3662a;
        Expression r4 = Expression.nullSet;
        p r5 = this.c;
        if (r3 != r4) goto L16;
        String r8 = r5.a("Diagnosis.ContentModelIsNullset", null);
    L17:
        r7.f3643a = r8;
        return true;
    L16:
        r8 = r5.a("Diagnosis.UndeclaredAttribute", r6.c);
        goto L17
    L19:
        r7.f3643a = a(r1);
        if (r7.f3643a != null) goto L22;
        r7.f3643a = this.c.a("Diagnosis.BadAttributeValue.Generic", r6.c);
    L22:
        this.f3662a = r2;
        return true;
    }

    public boolean a(v r5, com.ctc.wstx.shaded.msv_core.util.d r6) {
        Expression r0 = this.c.c.a(this.f3662a, r5);
        if (com.ctc.wstx.shaded.msv_core.a.a.a.f3552a == false) goto L6;
        System.out.println("residual of stepForward(" + r5 + ")");
        System.out.print(com.ctc.wstx.shaded.msv_core.grammar.a.a.a(this.f3662a));
        System.out.print("   ->   ");
        System.out.println(com.ctc.wstx.shaded.msv_core.grammar.a.a.a(r0));
    L6:
        if (r0 != Expression.nullSet) goto L13;
        if (r6 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, u.class) == false) goto L16;
        r6.f3643a = a((u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.memorydata.plugin"));
        return false;
    L16:
        return false;
    L13:
        this.f3662a = r0;
        return true;
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.b
    public boolean a(String r3, com.ctc.wstx.shaded.msv_core.grammar.g r4, com.ctc.wstx.shaded.msv_core.util.d r5, com.ctc.wstx.shaded.msv_core.util.a r6) {
        com.ctc.wstx.shaded.msv_core.grammar.g r7 = (com.ctc.wstx.shaded.msv_core.grammar.g) ZeusTransformUtils.wrapperContextForParams(r4, com.ctc.wstx.shaded.msv_core.grammar.g.class, "com.obric.memorydata.plugin");
        return a(new u(this.c, r3, r7, r6), r5);
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.b
    public final boolean a(String r4, String r5, String r6, String r7, com.ctc.wstx.shaded.msv_core.grammar.g r8, com.ctc.wstx.shaded.msv_core.util.d r9, com.ctc.wstx.shaded.msv_core.util.a r10) {
        com.ctc.wstx.shaded.msv_core.grammar.g r11 = (com.ctc.wstx.shaded.msv_core.grammar.g) ZeusTransformUtils.wrapperContextForParams(r8, com.ctc.wstx.shaded.msv_core.grammar.g.class, "com.obric.memorydata.plugin");
        this.c.j.a(r4, r5, r6, new u(this.c, r7, r11, r10));
        return a(this.c.j, r9);
    }

    @Override // com.ctc.wstx.shaded.msv_core.verifier.b
    public boolean b(com.ctc.wstx.shaded.msv_core.util.c r4, com.ctc.wstx.shaded.msv_core.util.d r5) {
        Expression r0 = this.c.f.a(this.f3662a);
        if (r0 == Expression.nullSet) goto L6;
        this.f3662a = r0;
        return true;
    L6:
        if (r5 != null) goto L10;
        return false;
    L10:
        if (this.f3662a != Expression.nullSet) goto L13;
        String r6 = this.c.a("Diagnosis.ContentModelIsNullset", null);
    L12:
        r5.f3643a = r6;
    L16:
        this.f3662a = this.f3662a.visit(this.c.h);
        return true;
    L13:
        r5.f3643a = b(r4);
        if (r5.f3643a != null) goto L16;
        r6 = this.c.a("Diagnosis.MissingAttribute.Generic", r4.c);
        goto L12
    }

    public String c() {
        h r0 = this.c.d;
        int r3 = 0;
        r0.a(this.f3662a, null, false);
        HashSet r1 = new HashSet();
        ElementExp[] r4 = r0.d();
        int r2 = r0.e();
        boolean r5 = false;
    L3:
        if (r3 >= r2) goto L19;
        NameClass r6 = r4[r3].getNameClass();
        if (ZeusTransformUtils.instanceOf(r6, SimpleNameClass.class) == false) goto L9;
        p r7 = this.c;
        String r8 = r6.toString();
        String r9 = "Diagnosis.SimpleNameClass";
    L7:
        r1.add(r7.a(r9, r8));
    L17:
        r3 = r3 + 1;
        goto L3
    L9:
        if (ZeusTransformUtils.instanceOf(r6, NamespaceNameClass.class) == false) goto L12;
        r7 = this.c;
        r8 = ((NamespaceNameClass) ZeusTransformUtils.preCheckCast(r6, NamespaceNameClass.class, "com.obric.memorydata.plugin")).namespaceURI;
        r9 = "Diagnosis.NamespaceNameClass";
        goto L7
    L12:
        if (ZeusTransformUtils.instanceOf(r6, NotNameClass.class) == false) goto L16;
        NameClass r10 = ((NotNameClass) ZeusTransformUtils.preCheckCast(r6, NotNameClass.class, "com.obric.memorydata.plugin")).child;
        if (ZeusTransformUtils.instanceOf(r10, NamespaceNameClass.class) == false) goto L16;
        r7 = this.c;
        r8 = ((NamespaceNameClass) ZeusTransformUtils.preCheckCast(r10, NamespaceNameClass.class, "com.obric.memorydata.plugin")).namespaceURI;
        r9 = "Diagnosis.NotNamespaceNameClass";
    L16:
        r5 = true;
        goto L17
    L19:
        if (r1.size() != 0) goto L22;
        return null;
    L22:
        return this.c.a("Diagnosis.UncompletedContent.WrapUp", null, a(r1, r5, "Diagnosis.UncompletedContent.Separator", "Diagnosis.UncompletedContent.More"));
    }
}
