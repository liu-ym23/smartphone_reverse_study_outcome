package com.ctc.wstx.shaded.msv_core.grammar.a;

import com.ctc.wstx.shaded.msv_core.grammar.AttributeExp;
import com.ctc.wstx.shaded.msv_core.grammar.BinaryExp;
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
import com.ctc.wstx.shaded.msv_core.grammar.ValueExp;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements com.ctc.wstx.shaded.msv_core.grammar.f {
    public b() {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a() {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(AttributeExp r1) {
        r1.exp.visit(this);
    }

    public void a(BinaryExp r2) {
        r2.exp1.visit(this);
        r2.exp2.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ChoiceExp r1) {
        a(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ConcurExp r1) {
        a(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(DataExp r1) {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ElementExp r1) {
        r1.contentModel.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(InterleaveExp r1) {
        a(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ListExp r1) {
        r1.exp.visit(this);
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
        r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(SequenceExp r1) {
        a(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void a(ValueExp r1) {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void b() {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.f
    public void c() {
    }
}
