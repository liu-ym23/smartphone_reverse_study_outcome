package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PlusBlockStartState;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LL1PlusBlockSingleAlt extends LL1Loop {
    public LL1PlusBlockSingleAlt(OutputModelFactory r5, GrammarAST r10, List<CodeBlockForAlt> r11) {
        super(r5, r10, r11);
        ATNState r12 = ((BlockAST) r10.getChild(0)).atnState;
        PlusBlockStartState r13 = (PlusBlockStartState) r12;
        this.stateNumber = r13.loopBackState.stateNumber;
        this.blockStartStateNumber = r13.stateNumber;
        this.decision = ((PlusBlockStartState) r12).loopBackState.decision;
        this.loopExpr = addCodeForLoopLookaheadTempVar(r5.getGrammar().decisionLOOK.get(this.decision)[0]);
    }
}
