package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;

/* JADX INFO: loaded from: classes.dex */
public class ThrowRecognitionException extends SrcOp {
    public int decision;
    public int grammarCharPosInLine;
    public String grammarFile;
    public int grammarLine;

    public ThrowRecognitionException(OutputModelFactory r5, GrammarAST r10, IntervalSet r11) {
        super(r5, r10);
        this.grammarLine = r10.getLine();
        this.grammarLine = r10.getCharPositionInLine();
        this.grammarFile = r5.getGrammar().fileName;
    }
}
