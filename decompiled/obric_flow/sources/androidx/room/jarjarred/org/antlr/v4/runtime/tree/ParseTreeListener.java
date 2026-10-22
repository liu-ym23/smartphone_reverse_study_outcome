package androidx.room.jarjarred.org.antlr.v4.runtime.tree;

import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;

/* JADX INFO: loaded from: classes.dex */
public interface ParseTreeListener {
    void enterEveryRule(ParserRuleContext r5);

    void exitEveryRule(ParserRuleContext r5);

    void visitErrorNode(ErrorNode r5);

    void visitTerminal(TerminalNode r5);
}
