package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;

/* JADX INFO: loaded from: classes.dex */
public class MatchNotSet extends MatchSet {
    public String varName;

    public MatchNotSet(OutputModelFactory r5, GrammarAST r10) {
        super(r5, r10);
        this.varName = "_la";
    }
}
