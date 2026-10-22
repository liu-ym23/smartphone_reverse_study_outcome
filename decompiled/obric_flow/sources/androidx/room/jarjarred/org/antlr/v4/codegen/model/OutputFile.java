package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class OutputFile extends OutputModelObject {
    public final String ANTLRVersion;
    public final String InputSymbolType;
    public final String TokenLabelType;
    public final String fileName;
    public final String grammarFileName;

    public OutputFile(OutputModelFactory r5, String r10) {
        super(r5);
        this.fileName = r10;
        Grammar r11 = r5.getGrammar();
        this.grammarFileName = r11.fileName;
        this.ANTLRVersion = Tool.VERSION;
        String r12 = r11.getOptionString("TokenLabelType");
        this.TokenLabelType = r12;
        this.InputSymbolType = r12;
    }

    public Map<String, Action> buildNamedActions(Grammar r10) {
        HashMap r5 = new HashMap();
        Iterator<String> r11 = r10.namedActions.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        String r12 = r11.next();
        ActionAST r13 = r10.namedActions.get(r12);
        r5.put(r12, new Action(this.factory, r13));
        goto L4
    L6:
        return r5;
    }
}
