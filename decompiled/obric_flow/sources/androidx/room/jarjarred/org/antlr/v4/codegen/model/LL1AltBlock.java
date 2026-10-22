package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.DecisionState;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LL1AltBlock extends LL1Choice {
    public LL1AltBlock(OutputModelFactory r5, GrammarAST r10, List<CodeBlockForAlt> r11) {
        super(r5, r10, r11);
        this.decision = ((DecisionState) r10.atnState).decision;
        IntervalSet[] r12 = r5.getGrammar().decisionLOOK.get(this.decision);
        this.altLook = getAltLookaheadAsStringLists(r12);
        this.error = getThrowNoViableAlt(r5, r10, IntervalSet.or(r12));
    }
}
