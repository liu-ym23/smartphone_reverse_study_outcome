package androidx.room.jarjarred.org.antlr.v4.tool.ast;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActionAST extends GrammarASTWithOptions implements RuleElementAST {
    public List<Token> chunks;
    public AttributeResolver resolver;

    public ActionAST(ActionAST r5) {
        super(r5);
        this.resolver = r5.resolver;
        this.chunks = r5.chunks;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree dupNode() {
        return dupNode();
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

    public ActionAST(Token r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public ActionAST dupNode() {
        return new ActionAST(this);
    }

    public ActionAST(int r5) {
        super(r5);
    }

    public ActionAST(int r5, Token r10) {
        super(r5, r10);
    }
}
