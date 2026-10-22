package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;

/* JADX INFO: loaded from: classes.dex */
public class Sync extends SrcOp {
    public int decision;

    public Sync(OutputModelFactory r5, GrammarAST r10, IntervalSet r11, int r12, String r13) {
        super(r5, r10);
        this.decision = r12;
    }
}
