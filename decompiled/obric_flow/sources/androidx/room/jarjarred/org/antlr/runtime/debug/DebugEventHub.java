package androidx.room.jarjarred.org.antlr.runtime.debug;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DebugEventHub implements DebugEventListener {
    protected List<DebugEventListener> listeners;

    public DebugEventHub(DebugEventListener r5) {
        ArrayList r10 = new ArrayList();
        this.listeners = r10;
        r10.add(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void LT(int r5, Token r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.listeners.size()) goto L6;
        this.listeners.get(r11).LT(r5, r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void addChild(Object r5, Object r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.listeners.size()) goto L6;
        this.listeners.get(r11).addChild(r5, r10);
        r11 = r11 + 1;
        goto L4
    }

    public void addListener(DebugEventListener r5) {
        this.listeners.add(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void becomeRoot(Object r5, Object r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.listeners.size()) goto L6;
        this.listeners.get(r11).becomeRoot(r5, r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void beginBacktrack(int r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).beginBacktrack(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void beginResync() {
        int r5 = 0;
    L4:
        if (r5 >= this.listeners.size()) goto L6;
        this.listeners.get(r5).beginResync();
        r5 = r5 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void commence() {
        int r5 = 0;
    L4:
        if (r5 >= this.listeners.size()) goto L6;
        this.listeners.get(r5).commence();
        r5 = r5 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeHiddenToken(Token r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).consumeHiddenToken(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeNode(Object r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).consumeNode(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeToken(Token r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).consumeToken(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void createNode(Object r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).createNode(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void endBacktrack(int r5, boolean r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.listeners.size()) goto L6;
        this.listeners.get(r11).endBacktrack(r5, r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void endResync() {
        int r5 = 0;
    L4:
        if (r5 >= this.listeners.size()) goto L6;
        this.listeners.get(r5).endResync();
        r5 = r5 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterAlt(int r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).enterAlt(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterDecision(int r5, boolean r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.listeners.size()) goto L6;
        this.listeners.get(r11).enterDecision(r5, r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterRule(String r5, String r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.listeners.size()) goto L6;
        this.listeners.get(r11).enterRule(r5, r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterSubRule(int r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).enterSubRule(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void errorNode(Object r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).errorNode(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitDecision(int r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).exitDecision(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitRule(String r5, String r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.listeners.size()) goto L6;
        this.listeners.get(r11).exitRule(r5, r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitSubRule(int r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).exitSubRule(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void location(int r5, int r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.listeners.size()) goto L6;
        this.listeners.get(r11).location(r5, r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void mark(int r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).mark(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void nilNode(Object r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).nilNode(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void recognitionException(RecognitionException r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).recognitionException(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void rewind(int r5) {
        int r10 = 0;
    L4:
        if (r10 >= this.listeners.size()) goto L6;
        this.listeners.get(r10).rewind(r5);
        r10 = r10 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void semanticPredicate(boolean r5, String r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.listeners.size()) goto L6;
        this.listeners.get(r11).semanticPredicate(r5, r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void setTokenBoundaries(Object r5, int r10, int r11) {
        int r12 = 0;
    L4:
        if (r12 >= this.listeners.size()) goto L6;
        this.listeners.get(r12).setTokenBoundaries(r5, r10, r11);
        r12 = r12 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void terminate() {
        int r5 = 0;
    L4:
        if (r5 >= this.listeners.size()) goto L6;
        this.listeners.get(r5).terminate();
        r5 = r5 + 1;
        goto L4
    }

    public DebugEventHub(DebugEventListener r5, DebugEventListener r10) {
        ArrayList r11 = new ArrayList();
        this.listeners = r11;
        r11.add(r5);
        this.listeners.add(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void LT(int r5, Object r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.listeners.size()) goto L6;
        this.listeners.get(r11).LT(r5, r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void createNode(Object r5, Token r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.listeners.size()) goto L6;
        this.listeners.get(r11).createNode(r5, r10);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void rewind() {
        int r5 = 0;
    L4:
        if (r5 >= this.listeners.size()) goto L6;
        this.listeners.get(r5).rewind();
        r5 = r5 + 1;
        goto L4
    }
}
