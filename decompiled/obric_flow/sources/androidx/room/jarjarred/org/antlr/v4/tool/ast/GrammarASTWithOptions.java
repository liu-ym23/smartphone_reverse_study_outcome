package androidx.room.jarjarred.org.antlr.v4.tool.ast;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.v4.misc.CharSupport;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class GrammarASTWithOptions extends GrammarAST {
    protected Map<String, GrammarAST> options;

    public GrammarASTWithOptions(GrammarASTWithOptions r5) {
        super(r5);
        this.options = r5.options;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree dupNode() {
        return dupNode();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public abstract GrammarASTWithOptions dupNode();

    public int getNumberOfOptions() {
        Map<String, GrammarAST> r5 = this.options;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.size();
    }

    public GrammarAST getOptionAST(String r5) {
        Map<String, GrammarAST> r10 = this.options;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.get(r5);
    }

    public String getOptionString(String r5) {
        GrammarAST r10 = getOptionAST(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        if ((r10 instanceof ActionAST) == true) goto L9;
        String r11 = r10.getText();
        if (r11.startsWith("'") == false) goto L13;
    L14:
        String r12 = CharSupport.getStringFromGrammarStringLiteral(r11);
        if (r12 != null) goto L19;
        Grammar r13 = this.g;
        r13.tool.errMgr.grammarError(ErrorType.INVALID_ESCAPE_SEQUENCE, r13.fileName, r10.getToken(), new Object[]{r10.getText()});
        return "";
    L19:
        return r12;
    L13:
        if (r11.startsWith("\"") == true) goto L14;
        return r11;
    L9:
        return r10.getText();
    }

    public Map<String, GrammarAST> getOptions() {
        Map<String, GrammarAST> r5 = this.options;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return Collections.emptyMap();
    }

    public void setOption(String r5, GrammarAST r10) {
        if (this.options != null) goto L5;
        this.options = new HashMap();
    L5:
        this.options.put(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ GrammarAST dupNode() {
        return dupNode();
    }

    public GrammarASTWithOptions(Token r5) {
        super(r5);
    }

    public GrammarASTWithOptions(int r5) {
        super(r5);
    }

    public GrammarASTWithOptions(int r5, Token r10) {
        super(r5, r10);
    }

    public GrammarASTWithOptions(int r5, Token r10, String r11) {
        super(r5, r10, r11);
    }
}
