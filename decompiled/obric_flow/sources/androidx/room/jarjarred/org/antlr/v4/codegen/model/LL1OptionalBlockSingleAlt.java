package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.DecisionState;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LL1OptionalBlockSingleAlt extends LL1Choice {

    @ModelElement
    public SrcOp expr;

    @ModelElement
    public List<SrcOp> followExpr;

    public LL1OptionalBlockSingleAlt(OutputModelFactory r5, GrammarAST r10, List<CodeBlockForAlt> r11) {
        super(r5, r10, r11);
        this.decision = ((DecisionState) r10.atnState).decision;
        IntervalSet[] r12 = r5.getGrammar().decisionLOOK.get(this.decision);
        this.altLook = getAltLookaheadAsStringLists(r12);
        IntervalSet r13 = r12[0];
        IntervalSet r14 = r12[1];
        this.error = getThrowNoViableAlt(r5, r10, r13.or(r14));
        this.expr = addCodeForLookaheadTempVar(r13);
        this.followExpr = r5.getLL1Test(r14, r10);
    }
}
