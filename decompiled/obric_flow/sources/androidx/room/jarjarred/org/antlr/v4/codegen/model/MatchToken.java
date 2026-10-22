package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.Decl;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MatchToken extends RuleElement implements LabeledOp {
    public List<Decl> labels;
    public String name;
    public int ttype;

    public MatchToken(OutputModelFactory r5, TerminalAST r10) {
        super(r5, r10);
        this.labels = new ArrayList();
        Grammar r11 = r5.getGrammar();
        CodeGenerator r12 = r5.getGenerator();
        this.ttype = r11.getTokenType(r10.getText());
        this.name = r12.getTarget().getTokenTypeAsTargetLabel(r11, this.ttype);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.model.LabeledOp
    public List<Decl> getLabels() {
        return this.labels;
    }

    public MatchToken(OutputModelFactory r5, GrammarAST r10) {
        super(r5, r10);
        this.labels = new ArrayList();
    }
}
