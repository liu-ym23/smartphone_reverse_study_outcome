package androidx.room.jarjarred.org.antlr.v4.tool.ast;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GrammarRootAST extends GrammarASTWithOptions {
    public static final Map<String, String> defaultOptions = null;
    public Map<String, String> cmdLineOptions;
    public String fileName;
    public int grammarType;
    public boolean hasErrors;
    public final TokenStream tokenStream;

    static {
        HashMap r5 = new HashMap();
        defaultOptions = r5;
        r5.put("language", CodeGenerator.DEFAULT_LANGUAGE);
    }

    public GrammarRootAST(GrammarRootAST r5) {
        super(r5);
        this.grammarType = r5.grammarType;
        this.hasErrors = r5.hasErrors;
        this.tokenStream = r5.tokenStream;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree dupNode() {
        return dupNode();
    }

    public String getGrammarName() {
        Tree r5 = getChild(0);
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getText();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions
    public String getOptionString(String r5) {
        Map<String, String> r10 = this.cmdLineOptions;
        if (r10 != null) goto L5;
    L8:
        String r11 = super.getOptionString(r5);
        if (r11 == null) goto L11;
        return r11;
    L11:
        return defaultOptions.get(r5);
    L5:
        if (r10.containsKey(r5) == false) goto L8;
        return this.cmdLineOptions.get(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST
    public Object visit(GrammarASTVisitor r5) {
        return r5.visit(this);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ GrammarAST dupNode() {
        return dupNode();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ GrammarASTWithOptions dupNode() {
        return dupNode();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public GrammarRootAST dupNode() {
        return new GrammarRootAST(this);
    }

    public GrammarRootAST(Token r5, TokenStream r10) {
        super(r5);
        if (r10 == null) goto L7;
        this.tokenStream = r10;
        return;
    L7:
        throw new NullPointerException("tokenStream");
    }

    public GrammarRootAST(int r5, Token r10, TokenStream r11) {
        super(r5, r10);
        if (r11 == null) goto L7;
        this.tokenStream = r11;
        return;
    L7:
        throw new NullPointerException("tokenStream");
    }

    public GrammarRootAST(int r5, Token r10, String r11, TokenStream r12) {
        super(r5, r10, r11);
        if (r12 == null) goto L7;
        this.tokenStream = r12;
        return;
    L7:
        throw new NullPointerException("tokenStream");
    }
}
