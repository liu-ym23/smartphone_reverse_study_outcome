package androidx.room.jarjarred.org.antlr.v4.tool.ast;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;

/* JADX INFO: loaded from: classes.dex */
public class RuleAST extends GrammarASTWithOptions {
    public RuleAST(RuleAST r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree dupNode() {
        return dupNode();
    }

    public ActionAST getLexerAction() {
        Tree r5 = getFirstChildWithType(78);
        if (r5.getChildCount() != 1) goto L8;
        Tree r10 = r5.getChild(0);
        Tree r11 = r10.getChild(r10.getChildCount() - 1);
        if (r11.getType() == 4) goto L7;
        return null;
    L7:
        return (ActionAST) r11;
    L8:
        return null;
    }

    public String getRuleName() {
        GrammarAST r5 = (GrammarAST) getChild(0);
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getText();
    }

    public boolean isLexerRule() {
        String r5 = getRuleName();
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (Grammar.isTokenName(r5) == false) goto L7;
        return true;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST
    public Object visit(GrammarASTVisitor r5) {
        return r5.visit(this);
    }

    public RuleAST(Token r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ GrammarAST dupNode() {
        return dupNode();
    }

    public RuleAST(int r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ GrammarASTWithOptions dupNode() {
        return dupNode();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public RuleAST dupNode() {
        return new RuleAST(this);
    }
}
