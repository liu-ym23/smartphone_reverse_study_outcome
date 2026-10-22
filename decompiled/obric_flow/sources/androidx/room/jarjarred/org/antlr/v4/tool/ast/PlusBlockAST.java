package androidx.room.jarjarred.org.antlr.v4.tool.ast;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;

/* JADX INFO: loaded from: classes.dex */
public class PlusBlockAST extends GrammarAST implements RuleElementAST, QuantifierAST {
    private final boolean _greedy;

    public PlusBlockAST(PlusBlockAST r5) {
        super(r5);
        this._greedy = r5._greedy;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ Tree dupNode() {
        return dupNode();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.QuantifierAST
    public boolean isGreedy() {
        return this._greedy;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST
    public Object visit(GrammarASTVisitor r5) {
        return r5.visit(this);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public /* bridge */ /* synthetic */ GrammarAST dupNode() {
        return dupNode();
    }

    public PlusBlockAST(int r5, Token r10, Token r11) {
        super(r5, r10);
        if (r11 != null) goto L5;
        boolean r12 = true;
    L6:
        this._greedy = r12;
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST, androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public PlusBlockAST dupNode() {
        return new PlusBlockAST(this);
    }
}
