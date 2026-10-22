package androidx.room.jarjarred.org.antlr.runtime;

import androidx.room.jarjarred.org.antlr.runtime.misc.LookaheadStream;

/* JADX INFO: loaded from: classes.dex */
public class UnbufferedTokenStream extends LookaheadStream<Token> implements TokenStream {
    protected int channel;
    protected int tokenIndex;
    protected TokenSource tokenSource;

    public UnbufferedTokenStream(TokenSource r5) {
        this.tokenIndex = 0;
        this.channel = 0;
        this.tokenSource = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int LA(int r5) {
        return LT(r5).getType();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.misc.LookaheadStream, androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public /* bridge */ /* synthetic */ Token LT(int r5) {
        return (Token) super.LT(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public Token get(int r5) {
        throw new UnsupportedOperationException("Absolute token indexes are meaningless in an unbuffered stream");
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public String getSourceName() {
        return this.tokenSource.getSourceName();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public TokenSource getTokenSource() {
        return this.tokenSource;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.misc.LookaheadStream
    public /* bridge */ /* synthetic */ boolean isEOF(Token r5) {
        return isEOF2(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.misc.LookaheadStream
    public /* bridge */ /* synthetic */ Token nextElement() {
        return nextElement();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public String toString(int r5, int r10) {
        return "n/a";
    }

    /* JADX INFO: renamed from: isEOF, reason: avoid collision after fix types in other method */
    public boolean isEOF2(Token r5) {
        if (r5.getType() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.room.jarjarred.org.antlr.runtime.misc.LookaheadStream
    public Token nextElement() {
        Token r5 = this.tokenSource.nextToken();
        int r10 = this.tokenIndex;
        this.tokenIndex = r10 + 1;
        r5.setTokenIndex(r10);
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public String toString(Token r5, Token r10) {
        return "n/a";
    }
}
