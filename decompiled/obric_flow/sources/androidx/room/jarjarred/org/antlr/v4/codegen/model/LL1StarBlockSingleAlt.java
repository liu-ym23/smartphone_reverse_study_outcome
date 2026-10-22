package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopEntryState;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LL1StarBlockSingleAlt extends LL1Loop {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public LL1StarBlockSingleAlt(OutputModelFactory r5, GrammarAST r10, List<CodeBlockForAlt> r11) {
        super(r5, r10, r11);
        StarLoopEntryState r12 = (StarLoopEntryState) r10.atnState;
        this.loopBackStateNumber = r12.loopBackState.stateNumber;
        this.decision = r12.decision;
        IntervalSet[] r13 = r5.getGrammar().decisionLOOK.get(this.decision);
        IntervalSet r14 = r13[0];
        IntervalSet r15 = r13[1];
        this.loopExpr = addCodeForLoopLookaheadTempVar(r14);
    }
}
