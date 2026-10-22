package androidx.room.jarjarred.org.antlr.v4.runtime.tree;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntegerStack;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public class IterativeParseTreeWalker extends ParseTreeWalker {
    public IterativeParseTreeWalker() {
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.tree.ParseTreeWalker
    public void walk(ParseTreeListener r10, ParseTree r11) {
        ArrayDeque r5 = new ArrayDeque();
        IntegerStack r12 = new IntegerStack();
    L3:
        int r13 = 0;
    L4:
        if (r11 == null) goto L27;
        if ((r11 instanceof ErrorNode) == false) goto L9;
        r10.visitErrorNode((ErrorNode) r11);
    L13:
        if (r11.getChildCount() > 0) goto L14;
    L16:
        if ((r11 instanceof RuleNode) == false) goto L19;
        exitRule(r10, (RuleNode) r11);
    L19:
        if (r5.isEmpty() == true) goto L20;
        r13 = r13 + 1;
        r11 = ((ParseTree) r5.peek()).getChild(r13);
        if (r11 != null) goto L4;
        r11 = (ParseTree) r5.pop();
        r13 = r12.pop();
        if (r11 != null) goto L16;
    L20:
        r11 = null;
        goto L3
    L14:
        r5.push(r11);
        r12.push(r13);
        r11 = r11.getChild(0);
        goto L3
    L9:
        if ((r11 instanceof TerminalNode) == false) goto L11;
        r10.visitTerminal((TerminalNode) r11);
        goto L13
    L11:
        enterRule(r10, (RuleNode) r11);
        goto L13
    }
}
