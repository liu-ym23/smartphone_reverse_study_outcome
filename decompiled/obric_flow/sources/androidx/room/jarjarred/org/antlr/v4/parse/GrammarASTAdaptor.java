package androidx.room.jarjarred.org.antlr.v4.parse;

import androidx.room.jarjarred.org.antlr.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeAdaptor;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTErrorNode;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;

/* JADX INFO: loaded from: classes.dex */
public class GrammarASTAdaptor extends CommonTreeAdaptor {
    CharStream input;

    public GrammarASTAdaptor() {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeAdaptor, androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object create(Token r5) {
        return new GrammarAST(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeAdaptor, androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object dupNode(Object r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return ((GrammarAST) r5).dupNode();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTreeAdaptor, androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object errorNode(TokenStream r5, Token r10, Token r11, RecognitionException r12) {
        return new GrammarASTErrorNode(r5, r10, r11, r12);
    }

    public GrammarASTAdaptor(CharStream r5) {
        this.input = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTreeAdaptor, androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor
    public Object create(int r5, String r10) {
        if (r5 != 94) goto L6;
        CommonTree r11 = new RuleAST(new CommonToken(r5, r10));
    L9:
        r11.token.setInputStream(this.input);
        return r11;
    L6:
        if (r5 != 62) goto L8;
        r11 = new TerminalAST(new CommonToken(r5, r10));
        goto L9
    L8:
        r11 = (GrammarAST) super.create(r5, r10);
        goto L9
    }
}
