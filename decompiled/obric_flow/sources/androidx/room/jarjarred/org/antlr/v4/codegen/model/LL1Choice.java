package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class LL1Choice extends Choice {
    public List<String[]> altLook;

    @ModelElement
    public ThrowNoViableAlt error;

    public LL1Choice(OutputModelFactory r5, GrammarAST r10, List<CodeBlockForAlt> r11) {
        super(r5, r10, r11);
    }
}
