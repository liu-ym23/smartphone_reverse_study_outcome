package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class LL1Loop extends Choice {
    public int blockStartStateNumber;

    @ModelElement
    public List<SrcOp> iteration;
    public int loopBackStateNumber;

    @ModelElement
    public OutputModelObject loopExpr;

    public LL1Loop(OutputModelFactory r5, GrammarAST r10, List<CodeBlockForAlt> r11) {
        super(r5, r10, r11);
    }

    public SrcOp addCodeForLoopLookaheadTempVar(IntervalSet r5) {
        TestSetInline r10 = addCodeForLookaheadTempVar(r5);
        if (r10 == null) goto L5;
        addIterationOp(new CaptureNextTokenType(this.factory, r10.varName));
    L5:
        return r10;
    }

    public void addIterationOp(SrcOp r5) {
        if (this.iteration != null) goto L5;
        this.iteration = new ArrayList();
    L5:
        this.iteration.add(r5);
    }
}
