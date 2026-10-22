package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.BlockStartState;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AltBlock extends Choice {
    public AltBlock(OutputModelFactory r5, GrammarAST r10, List<CodeBlockForAlt> r11) {
        super(r5, r10, r11);
        this.decision = ((BlockStartState) r10.atnState).decision;
    }
}
