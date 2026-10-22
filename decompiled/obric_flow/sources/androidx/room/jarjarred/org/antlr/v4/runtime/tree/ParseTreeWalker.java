package androidx.room.jarjarred.org.antlr.v4.runtime.tree;

import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;

/* JADX INFO: loaded from: classes.dex */
public class ParseTreeWalker {
    public static final ParseTreeWalker DEFAULT = null;

    static {
        DEFAULT = new ParseTreeWalker();
    }

    public ParseTreeWalker() {
    }

    public void enterRule(ParseTreeListener r5, RuleNode r10) {
        ParserRuleContext r11 = (ParserRuleContext) r10.getRuleContext();
        r5.enterEveryRule(r11);
        r11.enterRule(r5);
    }

    public void exitRule(ParseTreeListener r5, RuleNode r10) {
        ParserRuleContext r11 = (ParserRuleContext) r10.getRuleContext();
        r11.exitRule(r5);
        r5.exitEveryRule(r11);
    }

    public void walk(ParseTreeListener r5, ParseTree r10) {
        if ((r10 instanceof ErrorNode) == false) goto L7;
        r5.visitErrorNode((ErrorNode) r10);
        return;
    L7:
        if ((r10 instanceof TerminalNode) == false) goto L10;
        r5.visitTerminal((TerminalNode) r10);
        return;
    L10:
        RuleNode r11 = (RuleNode) r10;
        enterRule(r5, r11);
        int r12 = r11.getChildCount();
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L13;
        walk(r5, r11.getChild(r13));
        r13 = r13 + 1;
        goto L11
    L13:
        exitRule(r5, r11);
    }
}
