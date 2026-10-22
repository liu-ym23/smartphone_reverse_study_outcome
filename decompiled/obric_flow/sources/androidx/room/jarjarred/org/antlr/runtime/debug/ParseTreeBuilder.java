package androidx.room.jarjarred.org.antlr.runtime.debug;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.ParseTree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class ParseTreeBuilder extends BlankDebugEventListener {
    public static final String EPSILON_PAYLOAD = "<epsilon>";
    int backtracking;
    Stack<ParseTree> callStack;
    List<Token> hiddenTokens;

    public ParseTreeBuilder(String r5) {
        this.callStack = new Stack();
        this.hiddenTokens = new ArrayList();
        this.backtracking = 0;
        this.callStack.push(create("<grammar " + r5 + ">"));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeHiddenToken(Token r5) {
        if (this.backtracking <= 0) goto L5;
        return;
    L5:
        this.hiddenTokens.add(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeToken(Token r5) {
        if (this.backtracking <= 0) goto L5;
        return;
    L5:
        ParseTree r10 = this.callStack.peek();
        ParseTree r11 = create(r5);
        r11.hiddenTokens = this.hiddenTokens;
        this.hiddenTokens = new ArrayList();
        r10.addChild(r11);
    }

    public ParseTree create(Object r5) {
        return new ParseTree(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterDecision(int r5, boolean r10) {
        this.backtracking++;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterRule(String r5, String r10) {
        if (this.backtracking <= 0) goto L5;
        return;
    L5:
        ParseTree r11 = this.callStack.peek();
        ParseTree r12 = create(r10);
        r11.addChild(r12);
        this.callStack.push(r12);
    }

    public ParseTree epsilonNode() {
        return create(EPSILON_PAYLOAD);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitDecision(int r5) {
        this.backtracking--;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitRule(String r5, String r10) {
        if (this.backtracking <= 0) goto L5;
        return;
    L5:
        ParseTree r11 = this.callStack.peek();
        if (r11.getChildCount() != 0) goto L8;
        r11.addChild(epsilonNode());
    L8:
        this.callStack.pop();
    }

    public ParseTree getTree() {
        return this.callStack.elementAt(0);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void recognitionException(RecognitionException r5) {
        if (this.backtracking <= 0) goto L5;
        return;
    L5:
        this.callStack.peek().addChild(create(r5));
    }
}
