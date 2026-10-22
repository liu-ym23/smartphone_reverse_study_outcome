package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PlusBlockStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PlusLoopbackState;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PlusBlock extends Loop {

    @ModelElement
    public ThrowNoViableAlt error;

    public PlusBlock(OutputModelFactory r5, GrammarAST r10, List<CodeBlockForAlt> r11) {
        super(r5, r10, r11);
        PlusBlockStartState r12 = (PlusBlockStartState) ((BlockAST) r10.getChild(0)).atnState;
        PlusLoopbackState r13 = r12.loopBackState;
        int r14 = r13.stateNumber;
        this.stateNumber = r14;
        this.blockStartStateNumber = r12.stateNumber;
        this.loopBackStateNumber = r14;
        this.error = getThrowNoViableAlt(r5, r10, null);
        this.decision = r13.decision;
    }
}
