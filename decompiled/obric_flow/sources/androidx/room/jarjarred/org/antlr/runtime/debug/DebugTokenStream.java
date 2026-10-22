package androidx.room.jarjarred.org.antlr.runtime.debug;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenSource;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;

/* JADX INFO: loaded from: classes.dex */
public class DebugTokenStream implements TokenStream {
    protected DebugEventListener dbg;
    protected boolean initialStreamState;
    public TokenStream input;
    protected int lastMarker;

    public DebugTokenStream(TokenStream r5, DebugEventListener r10) {
        this.initialStreamState = true;
        this.input = r5;
        setDebugListener(r10);
        r5.LT(1);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int LA(int r5) {
        if (this.initialStreamState == false) goto L5;
        consumeInitialHiddenTokens();
    L5:
        this.dbg.LT(r5, this.input.LT(r5));
        return this.input.LA(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public Token LT(int r5) {
        if (this.initialStreamState == false) goto L5;
        consumeInitialHiddenTokens();
    L5:
        this.dbg.LT(r5, this.input.LT(r5));
        return this.input.LT(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void consume() {
        if (this.initialStreamState == false) goto L5;
        consumeInitialHiddenTokens();
    L5:
        int r5 = this.input.index();
        Token r10 = this.input.LT(1);
        this.input.consume();
        int r11 = this.input.index();
        this.dbg.consumeToken(r10);
        int r12 = r5 + 1;
        if (r11 <= r12) goto L9;
    L7:
        if (r12 >= r11) goto L11;
        this.dbg.consumeHiddenToken(this.input.get(r12));
        r12 = r12 + 1;
        goto L7
    L11:
        return;
    }

    public void consumeInitialHiddenTokens() {
        int r5 = this.input.index();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L5;
        this.dbg.consumeHiddenToken(this.input.get(r10));
        r10 = r10 + 1;
        goto L3
    L5:
        this.initialStreamState = false;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public Token get(int r5) {
        return this.input.get(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public String getSourceName() {
        return getTokenSource().getSourceName();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public TokenSource getTokenSource() {
        return this.input.getTokenSource();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int index() {
        return this.input.index();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int mark() {
        int r5 = this.input.mark();
        this.lastMarker = r5;
        this.dbg.mark(r5);
        return this.lastMarker;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public int range() {
        return this.input.range();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void release(int r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void rewind(int r5) {
        this.dbg.rewind(r5);
        this.input.rewind(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void seek(int r5) {
        this.input.seek(r5);
    }

    public void setDebugListener(DebugEventListener r5) {
        this.dbg = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int size() {
        return this.input.size();
    }

    public String toString() {
        return this.input.toString();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public String toString(int r5, int r10) {
        return this.input.toString(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void rewind() {
        this.dbg.rewind();
        this.input.rewind(this.lastMarker);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public String toString(Token r5, Token r10) {
        return this.input.toString(r5, r10);
    }
}
