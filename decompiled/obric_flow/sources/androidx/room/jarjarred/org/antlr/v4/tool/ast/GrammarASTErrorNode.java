package androidx.room.jarjarred.org.antlr.v4.tool.ast;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonErrorNode;

/* JADX INFO: loaded from: classes.dex */
public class GrammarASTErrorNode extends GrammarAST {
    CommonErrorNode delegate;

    public GrammarASTErrorNode(TokenStream r5, Token r10, Token r11, RecognitionException r12) {
        this.delegate = new CommonErrorNode(r5, r10, r11, r12);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public String getText() {
        return this.delegate.getText();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public int getType() {
        return this.delegate.getType();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public boolean isNil() {
        return this.delegate.isNil();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
    public String toString() {
        return this.delegate.toString();
    }
}
