package androidx.room.jarjarred.org.antlr.v4.runtime.tree;

import androidx.room.jarjarred.org.antlr.v4.runtime.Parser;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext;

/* JADX INFO: loaded from: classes.dex */
public interface ParseTree extends SyntaxTree {
    <T> T accept(ParseTreeVisitor<? extends T> r5);

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    ParseTree getChild(int r5);

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.Tree
    ParseTree getParent();

    String getText();

    void setParent(RuleContext r5);

    String toStringTree(Parser r5);
}
