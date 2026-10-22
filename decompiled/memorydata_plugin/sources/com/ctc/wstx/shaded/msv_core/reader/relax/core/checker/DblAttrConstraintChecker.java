package com.ctc.wstx.shaded.msv_core.reader.relax.core.checker;

import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.ChoiceExp;
import com.ctc.wstx.shaded.msv_core.grammar.ConcurExp;
import com.ctc.wstx.shaded.msv_core.grammar.DataExp;
import com.ctc.wstx.shaded.msv_core.grammar.ElementExp;
import com.ctc.wstx.shaded.msv_core.grammar.InterleaveExp;
import com.ctc.wstx.shaded.msv_core.grammar.ListExp;
import com.ctc.wstx.shaded.msv_core.grammar.MixedExp;
import com.ctc.wstx.shaded.msv_core.grammar.OneOrMoreExp;
import com.ctc.wstx.shaded.msv_core.grammar.OtherExp;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import com.ctc.wstx.shaded.msv_core.grammar.SequenceExp;
import com.ctc.wstx.shaded.msv_core.grammar.SimpleNameClass;
import com.ctc.wstx.shaded.msv_core.grammar.ValueExp;
import com.ctc.wstx.shaded.msv_core.grammar.relax.AttPoolClause;
import com.ctc.wstx.shaded.msv_core.grammar.relax.ElementRules;
import com.ctc.wstx.shaded.msv_core.grammar.relax.HedgeRules;
import com.ctc.wstx.shaded.msv_core.grammar.relax.TagClause;
import com.ctc.wstx.shaded.msv_core.grammar.relax.d;
import com.ctc.wstx.shaded.msv_core.util.StringPair;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class DblAttrConstraintChecker implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f3623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ReferenceExp f3624b;

    private static final class Eureka extends RuntimeException {
        final StringPair name;

        Eureka(StringPair r1) {
            this.name = r1;
        }
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a() {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(AttributeExp r3) {
        if (ZeusTransformUtils.instanceOf(r3.nameClass, SimpleNameClass.class) == false) goto L9;
        SimpleNameClass r4 = (SimpleNameClass) ZeusTransformUtils.preCheckCast(r3.nameClass, SimpleNameClass.class, "com.obric.memorydata.plugin");
        StringPair r0 = new StringPair(r4.namespaceURI, r4.localName);
        if (this.f3623a.containsKey(r0) == true) goto L8;
        this.f3623a.put(r0, this.f3624b);
        return;
    L8:
        throw new Eureka(r0);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ChoiceExp r2) {
        r2.exp1.visit(this);
        r2.exp2.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ConcurExp r1) {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(DataExp r1) {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ElementExp r1) {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(InterleaveExp r1) {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ListExp r1) {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(MixedExp r1) {
        r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(OneOrMoreExp r1) {
        r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(OtherExp r1) {
        r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ReferenceExp r1) {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(SequenceExp r2) {
        r2.exp1.visit(this);
        r2.exp2.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ValueExp r1) {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.relax.d
    public void a(AttPoolClause r2) {
        ReferenceExp r0 = this.f3624b;
        this.f3624b = r2;
        r2.exp.visit(this);
        this.f3624b = r0;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.relax.d
    public void a(ElementRules r1) {
        r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.relax.d
    public void a(HedgeRules r1) {
        r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.relax.d
    public void a(TagClause r1) {
        r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void b() {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void c() {
    }
}
