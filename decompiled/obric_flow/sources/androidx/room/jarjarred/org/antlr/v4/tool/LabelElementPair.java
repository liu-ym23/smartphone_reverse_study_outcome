package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;

/* JADX INFO: loaded from: classes.dex */
public class LabelElementPair {
    public static final BitSet tokenTypeForTokens = null;
    public GrammarAST element;
    public GrammarAST label;
    public LabelType type;

    static {
        BitSet r5 = new BitSet();
        tokenTypeForTokens = r5;
        r5.add(66);
        r5.add(62);
        r5.add(100);
    }

    public LabelElementPair(Grammar r5, GrammarAST r10, GrammarAST r11, int r12) {
        this.label = r10;
        this.element = r11;
        if (r11.getFirstDescendantWithType(tokenTypeForTokens) == null) goto L8;
        if (r12 != 10) goto L6;
        this.type = LabelType.TOKEN_LABEL;
    L13:
        if (r5.isLexer() == true) goto L15;
        return;
    L15:
        if (r11.getFirstDescendantWithType(62) == null) goto L20;
        if (r12 != 10) goto L21;
        this.type = LabelType.LEXER_STRING_LABEL;
        return;
    L21:
        return;
    L20:
        return;
    L6:
        this.type = LabelType.TOKEN_LIST_LABEL;
        goto L13
    L8:
        if (r11.getFirstDescendantWithType(57) == null) goto L13;
        if (r12 != 10) goto L11;
        this.type = LabelType.RULE_LABEL;
        goto L13
    L11:
        this.type = LabelType.RULE_LIST_LABEL;
        goto L13
    }

    public String toString() {
        return this.label.getText() + " " + this.type + " " + this.element.toString();
    }
}
