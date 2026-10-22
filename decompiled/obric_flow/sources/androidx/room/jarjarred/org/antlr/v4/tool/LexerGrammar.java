package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.MultiMap;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarRootAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LexerGrammar extends Grammar {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String DEFAULT_MODE_NAME = "DEFAULT_MODE";
    public Grammar implicitLexerOwner;
    public MultiMap<String, Rule> modes;

    public LexerGrammar(Tool r5, GrammarRootAST r10) {
        super(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.Grammar
    public boolean defineRule(Rule r5) {
        if (super.defineRule(r5) == true) goto L7;
        return false;
    L7:
        if (this.modes != null) goto L9;
        this.modes = new MultiMap();
    L9:
        this.modes.map(r5.mode, r5);
        return true;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.Grammar
    public boolean undefineRule(Rule r5) {
        if (super.undefineRule(r5) == true) goto L6;
        return false;
    L6:
        ((List) this.modes.get(r5.mode)).remove(r5);
        return true;
    }

    public LexerGrammar(String r5) throws RecognitionException {
        super(r5);
    }

    public LexerGrammar(String r5, ANTLRToolListener r10) throws RecognitionException {
        super(r5, r10);
    }

    public LexerGrammar(String r5, String r10, ANTLRToolListener r11) throws RecognitionException {
        super(r5, r10, r11);
    }
}
