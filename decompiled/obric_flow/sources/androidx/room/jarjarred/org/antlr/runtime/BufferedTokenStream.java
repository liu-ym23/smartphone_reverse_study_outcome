package androidx.room.jarjarred.org.antlr.runtime;

import ai.j0;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class BufferedTokenStream implements TokenStream {
    protected int lastMarker;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f621p;
    protected int range;
    protected TokenSource tokenSource;
    protected List<Token> tokens;

    public BufferedTokenStream() {
        this.tokens = new ArrayList(100);
        this.f621p = -1;
        this.range = -1;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int LA(int r5) {
        return LT(r5).getType();
    }

    public Token LB(int r5) {
        int r10 = this.f621p;
        if ((r10 - r5) >= 0) goto L7;
        return null;
    L7:
        return this.tokens.get(r10 - r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public Token LT(int r5) {
        if (this.f621p != (-1)) goto L5;
        setup();
    L5:
        if (r5 != 0) goto L8;
        return null;
    L8:
        if (r5 < 0) goto L10;
        int r10 = (this.f621p + r5) - 1;
        sync(r10);
        if (r10 < this.tokens.size()) goto L16;
        return (Token) j0.e(this.tokens, 1);
    L16:
        if (r10 <= this.range) goto L19;
        this.range = r10;
    L19:
        return this.tokens.get(r10);
    L10:
        return LB(-r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void consume() {
        if (this.f621p != (-1)) goto L5;
        setup();
    L5:
        int r5 = this.f621p + 1;
        this.f621p = r5;
        sync(r5);
    }

    public void fetch(int r5) {
        int r10 = 1;
    L3:
        if (r10 > r5) goto L8;
        Token r11 = this.tokenSource.nextToken();
        r11.setTokenIndex(this.tokens.size());
        this.tokens.add(r11);
        if (r11.getType() == (-1)) goto L11;
        r10 = r10 + 1;
        goto L3
    L11:
        return;
    }

    public void fill() {
        if (this.f621p != (-1)) goto L6;
        setup();
    L6:
        if (this.tokens.get(this.f621p).getType() != (-1)) goto L8;
        return;
    L8:
        int r5 = this.f621p + 1;
        sync(r5);
    L10:
        if (this.tokens.get(r5).getType() == (-1)) goto L12;
        r5 = r5 + 1;
        sync(r5);
        goto L10
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public Token get(int r5) {
        if (r5 >= 0) goto L4;
    L7:
        StringBuilder r10 = j0.s(r5, "token index ", " out of range 0..");
        r10.append(this.tokens.size() - 1);
        throw new NoSuchElementException(r10.toString());
    L4:
        if (r5 >= this.tokens.size()) goto L7;
        return this.tokens.get(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public String getSourceName() {
        return this.tokenSource.getSourceName();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public TokenSource getTokenSource() {
        return this.tokenSource;
    }

    public List<? extends Token> getTokens() {
        return this.tokens;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int index() {
        return this.f621p;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int mark() {
        if (this.f621p != (-1)) goto L5;
        setup();
    L5:
        int r5 = index();
        this.lastMarker = r5;
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public int range() {
        return this.range;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void release(int r5) {
    }

    public void reset() {
        this.f621p = 0;
        this.lastMarker = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void rewind(int r5) {
        seek(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void seek(int r5) {
        this.f621p = r5;
    }

    public void setTokenSource(TokenSource r5) {
        this.tokenSource = r5;
        this.tokens.clear();
        this.f621p = -1;
    }

    public void setup() {
        sync(0);
        this.f621p = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public int size() {
        return this.tokens.size();
    }

    public void sync(int r5) {
        int r10 = (r5 - this.tokens.size()) + 1;
        if (r10 <= 0) goto L6;
        fetch(r10);
        return;
    }

    public String toString() {
        if (this.f621p != (-1)) goto L5;
        setup();
    L5:
        fill();
        return toString(0, this.tokens.size() - 1);
    }

    public List<? extends Token> getTokens(int r5, int r10) {
        return getTokens(r5, r10, null);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.IntStream
    public void rewind() {
        seek(this.lastMarker);
    }

    public List<? extends Token> getTokens(int r5, int r10, BitSet r11) {
        if (this.f621p != (-1)) goto L6;
        setup();
    L6:
        if (r10 < this.tokens.size()) goto L8;
        r10 = this.tokens.size() - 1;
    L8:
        if (r5 >= 0) goto L11;
        r5 = 0;
    L11:
        if (r5 <= r10) goto L13;
        return null;
    L13:
        ArrayList r12 = new ArrayList();
    L14:
        if (r5 > r10) goto L22;
        Token r13 = this.tokens.get(r5);
        if (r11 != null) goto L18;
    L19:
        r12.add(r13);
    L20:
        r5 = r5 + 1;
        goto L14
    L18:
        if (r11.member(r13.getType()) == false) goto L20;
    L22:
        if (r12.isEmpty() == false) goto L25;
        return null;
    L25:
        return r12;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public String toString(int r5, int r10) {
        if (r5 < 0) goto L19;
        if (r10 >= 0) goto L6;
        return null;
    L6:
        if (this.f621p != (-1)) goto L9;
        setup();
    L9:
        if (r10 < this.tokens.size()) goto L11;
        r10 = this.tokens.size() - 1;
    L11:
        StringBuilder r11 = new StringBuilder();
    L12:
        if (r5 > r10) goto L18;
        Token r12 = this.tokens.get(r5);
        if (r12.getType() == (-1)) goto L18;
        r11.append(r12.getText());
        r5 = r5 + 1;
    L18:
        return r11.toString();
    L19:
        return null;
    }

    public BufferedTokenStream(TokenSource r5) {
        this.tokens = new ArrayList(100);
        this.f621p = -1;
        this.range = -1;
        this.tokenSource = r5;
    }

    public List<? extends Token> get(int r5, int r10) {
        if (r5 < 0) goto L17;
        if (r10 >= 0) goto L6;
        return null;
    L6:
        if (this.f621p != (-1)) goto L8;
        setup();
    L8:
        ArrayList r11 = new ArrayList();
        if (r10 < this.tokens.size()) goto L11;
        r10 = this.tokens.size() - 1;
    L11:
        if (r5 > r10) goto L16;
        Token r12 = this.tokens.get(r5);
        if (r12.getType() == (-1)) goto L16;
        r11.add(r12);
        r5 = r5 + 1;
    L16:
        return r11;
    L17:
        return null;
    }

    public List<? extends Token> getTokens(int r5, int r10, List<Integer> r11) {
        return getTokens(r5, r10, new BitSet(r11));
    }

    public List<? extends Token> getTokens(int r5, int r10, int r11) {
        return getTokens(r5, r10, BitSet.of(r11));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenStream
    public String toString(Token r5, Token r10) {
        if (r5 == null) goto L6;
        if (r10 != null) goto L5;
        return null;
    L5:
        return toString(r5.getTokenIndex(), r10.getTokenIndex());
    L6:
        return null;
    }
}
