package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ActionChunk;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ActionText;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ParserFile extends OutputFile {

    @ModelElement
    public ActionChunk contextSuperClass;
    public String exportMacro;
    public boolean genListener;
    public String genPackage;
    public boolean genVisitor;
    public String grammarName;

    @ModelElement
    public Map<String, Action> namedActions;

    @ModelElement
    public Parser parser;

    public ParserFile(OutputModelFactory r5, String r10) {
        super(r5, r10);
        Grammar r11 = r5.getGrammar();
        this.namedActions = buildNamedActions(r5.getGrammar());
        this.genPackage = r11.tool.genPackage;
        this.exportMacro = r5.getGrammar().getOptionString("exportMacro");
        Tool r12 = r11.tool;
        this.genListener = r12.gen_listener;
        this.genVisitor = r12.gen_visitor;
        this.grammarName = r11.name;
        if (r11.getOptionString("contextSuperClass") == null) goto L6;
        this.contextSuperClass = new ActionText(null, r11.getOptionString("contextSuperClass"));
        return;
    }
}
