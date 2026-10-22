package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopEntryState;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StarBlock extends Loop {
    public String loopLabel;

    public StarBlock(OutputModelFactory r5, GrammarAST r10, List<CodeBlockForAlt> r11) {
        super(r5, r10, r11);
        this.loopLabel = r5.getGenerator().getTarget().getLoopLabel(r10);
        StarLoopEntryState r12 = (StarLoopEntryState) r10.atnState;
        this.loopBackStateNumber = r12.loopBackState.stateNumber;
        this.decision = r12.decision;
    }
}
