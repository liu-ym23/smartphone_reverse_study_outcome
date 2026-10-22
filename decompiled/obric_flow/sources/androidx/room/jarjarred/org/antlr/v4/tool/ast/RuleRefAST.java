package androidx.room.jarjarred.org.antlr.v4.tool.ast;

import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;

/* JADX INFO: loaded from: classes.dex */
public class RuleRefAST extends GrammarASTWithOptions implements RuleElementAST {
    public RuleRefAST(RuleRefAST r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree dupNode() {
        return dupNode();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST
    public Object visit(GrammarASTVisitor r5) {
        return r5.visit(this);
    }

    public RuleRefAST(Token r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ GrammarAST dupNode() {
        return dupNode();
    }

    public RuleRefAST(int r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ GrammarASTWithOptions dupNode() {
        return dupNode();
    }

    public RuleRefAST(int r5, Token r10) {
        super(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public RuleRefAST dupNode() {
        RuleRefAST r5 = new RuleRefAST(this);
        Token r10 = this.token;
        r5.token = r10;
        this.token = new CommonToken(r10);
        return r5;
    }
}
