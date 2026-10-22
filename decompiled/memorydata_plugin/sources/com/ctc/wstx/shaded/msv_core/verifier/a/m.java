package com.ctc.wstx.shaded.msv_core.verifier.a;

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
import com.ctc.wstx.shaded.msv_core.grammar.ValueExp;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class m implements com.ctc.wstx.shaded.msv_core.grammar.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Collection f3661a;

    public m() {
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a() {
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(AttributeExp r1) {
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(ChoiceExp r2) {
        r2.exp1.visit(this);
        r2.exp2.visit(this);
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(ConcurExp r2) {
        r2.exp1.visit(this);
        r2.exp2.visit(this);
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(DataExp r1) {
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(ElementExp r1) {
        this.f3661a.add(r1);
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(InterleaveExp r2) {
        r2.exp1.visit(this);
        r2.exp2.visit(this);
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(ListExp r1) {
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(MixedExp r1) {
        r1.exp.visit(this);
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(OneOrMoreExp r1) {
        r1.exp.visit(this);
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(OtherExp r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(ReferenceExp r1) {
        return r1.exp.visit(this);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(SequenceExp r2) {
        r2.exp1.visit(this);
        if (r2.exp1.isEpsilonReducible() == false) goto L7;
        r2.exp2.visit(this);
        return null;
    L7:
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object a(ValueExp r1) {
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object b() {
        return null;
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.c
    public final Object c() {
        return null;
    }
}
