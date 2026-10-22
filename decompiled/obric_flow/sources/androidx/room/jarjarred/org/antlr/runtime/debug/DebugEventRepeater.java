package androidx.room.jarjarred.org.antlr.runtime.debug;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;

/* JADX INFO: loaded from: classes.dex */
public class DebugEventRepeater implements DebugEventListener {
    protected DebugEventListener listener;

    public DebugEventRepeater(DebugEventListener r5) {
        this.listener = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void LT(int r5, Token r10) {
        this.listener.LT(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void addChild(Object r5, Object r10) {
        this.listener.addChild(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void becomeRoot(Object r5, Object r10) {
        this.listener.becomeRoot(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void beginBacktrack(int r5) {
        this.listener.beginBacktrack(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void beginResync() {
        this.listener.beginResync();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void commence() {
        this.listener.commence();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeHiddenToken(Token r5) {
        this.listener.consumeHiddenToken(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeNode(Object r5) {
        this.listener.consumeNode(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeToken(Token r5) {
        this.listener.consumeToken(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void createNode(Object r5) {
        this.listener.createNode(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void endBacktrack(int r5, boolean r10) {
        this.listener.endBacktrack(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void endResync() {
        this.listener.endResync();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterAlt(int r5) {
        this.listener.enterAlt(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterDecision(int r5, boolean r10) {
        this.listener.enterDecision(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterRule(String r5, String r10) {
        this.listener.enterRule(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterSubRule(int r5) {
        this.listener.enterSubRule(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void errorNode(Object r5) {
        this.listener.errorNode(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitDecision(int r5) {
        this.listener.exitDecision(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitRule(String r5, String r10) {
        this.listener.exitRule(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitSubRule(int r5) {
        this.listener.exitSubRule(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void location(int r5, int r10) {
        this.listener.location(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void mark(int r5) {
        this.listener.mark(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void nilNode(Object r5) {
        this.listener.nilNode(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void recognitionException(RecognitionException r5) {
        this.listener.recognitionException(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void rewind(int r5) {
        this.listener.rewind(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void semanticPredicate(boolean r5, String r10) {
        this.listener.semanticPredicate(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void setTokenBoundaries(Object r5, int r10, int r11) {
        this.listener.setTokenBoundaries(r5, r10, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void terminate() {
        this.listener.terminate();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void LT(int r5, Object r10) {
        this.listener.LT(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void createNode(Object r5, Token r10) {
        this.listener.createNode(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void rewind() {
        this.listener.rewind();
    }
}
