package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.QuantifierAST;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Loop extends Choice {
    public int blockStartStateNumber;
    public final int exitAlt;

    @ModelElement
    public List<SrcOp> iteration;
    public int loopBackStateNumber;

    /* JADX WARN: Multi-variable type inference failed */
    public Loop(OutputModelFactory r5, GrammarAST r10, List<CodeBlockForAlt> r11) {
        super(r5, r10, r11);
        int r12 = 1;
        if ((r10 instanceof QuantifierAST) == true) goto L5;
    L7:
        r12 = 1 + r11.size();
    L8:
        this.exitAlt = r12;
        return;
    L5:
        if (((QuantifierAST) r10).isGreedy() == true) goto L7;
        goto L7
    }

    public void addIterationOp(SrcOp r5) {
        if (this.iteration != null) goto L5;
        this.iteration = new ArrayList();
    L5:
        this.iteration.add(r5);
    }
}
