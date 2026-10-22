package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LexerFile extends OutputFile {
    public String exportMacro;
    public boolean genListener;
    public String genPackage;
    public boolean genVisitor;

    @ModelElement
    public Lexer lexer;

    @ModelElement
    public Map<String, Action> namedActions;

    public LexerFile(OutputModelFactory r5, String r10) {
        super(r5, r10);
        this.namedActions = buildNamedActions(r5.getGrammar());
        this.genPackage = r5.getGrammar().tool.genPackage;
        this.exportMacro = r5.getGrammar().getOptionString("exportMacro");
        this.genListener = r5.getGrammar().tool.gen_listener;
        this.genVisitor = r5.getGrammar().tool.gen_visitor;
    }
}
