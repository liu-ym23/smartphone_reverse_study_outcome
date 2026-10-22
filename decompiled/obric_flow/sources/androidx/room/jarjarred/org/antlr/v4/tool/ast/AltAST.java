package androidx.room.jarjarred.org.antlr.v4.tool.ast;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleAltInfo;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;

/* JADX INFO: loaded from: classes.dex */
public class AltAST extends GrammarASTWithOptions {
    public Alternative alt;
    public GrammarAST altLabel;
    public LeftRecursiveRuleAltInfo leftRecursiveAltInfo;

    public AltAST(AltAST r5) {
        super(r5);
        this.alt = r5.alt;
        this.altLabel = r5.altLabel;
        this.leftRecursiveAltInfo = r5.leftRecursiveAltInfo;
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

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions, androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public AltAST dupNode() {
        return new AltAST(this);
    }

    public AltAST(Token r5) {
        super(r5);
    }

    public AltAST(int r5) {
        super(r5);
    }

    public AltAST(int r5, Token r10) {
        super(r5, r10);
    }

    public AltAST(int r5, Token r10, String r11) {
        super(r5, r10, r11);
    }
}
