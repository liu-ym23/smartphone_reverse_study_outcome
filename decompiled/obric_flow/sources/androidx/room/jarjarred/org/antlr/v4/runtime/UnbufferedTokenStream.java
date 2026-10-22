package androidx.room.jarjarred.org.antlr.v4.runtime;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class UnbufferedTokenStream<T extends Token> implements TokenStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected int currentTokenIndex;
    protected Token lastToken;
    protected Token lastTokenBufferStart;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f658n;
    protected int numMarkers;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f659p;
    protected TokenSource tokenSource;
    protected Token[] tokens;

    public UnbufferedTokenStream(TokenSource r5) {
        this(r5, 256);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int LA(int r5) {
        return LT(r5).getType();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public Token LT(int r5) {
        if (r5 == (-1)) goto L5;
        sync(r5);
        int r10 = (this.f659p + r5) - 1;
        if (r10 < 0) goto L15;
        int r11 = this.f658n;
        if (r10 < r11) goto L13;
        return this.tokens[r11 - 1];
    L13:
        return this.tokens[r10];
    L15:
        throw new IndexOutOfBoundsException(j0.h(r5, "LT(", ") gives negative index"));
    L5:
        return this.lastToken;
    }

    public void add(Token r5) {
        int r10 = this.f658n;
        Token[] r11 = this.tokens;
        if (r10 < r11.length) goto L6;
        this.tokens = (Token[]) Arrays.copyOf(r11, r11.length * 2);
    L6:
        if ((r5 instanceof WritableToken) == false) goto L8;
        ((WritableToken) r5).setTokenIndex(getBufferStartIndex() + this.f658n);
    L8:
        Token[] r12 = this.tokens;
        int r13 = this.f658n;
        this.f658n = r13 + 1;
        r12[r13] = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public void consume() {
        if (LA(1) == (-1)) goto L12;
        Token[] r5 = this.tokens;
        int r10 = this.f659p;
        Token r11 = r5[r10];
        this.lastToken = r11;
        if (r10 == (this.f658n - 1)) goto L7;
    L9:
        this.f659p++;
        this.currentTokenIndex++;
        sync(1);
        return;
    L7:
        if (this.numMarkers != 0) goto L9;
        this.f658n = 0;
        this.f659p = -1;
        this.lastTokenBufferStart = r11;
        goto L9
    L12:
        throw new IllegalStateException("cannot consume EOF");
    }

    public int fill(int r5) {
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L10;
        int r11 = this.f658n;
        if (r11 <= 0) goto L9;
        if (this.tokens[r11 - 1].getType() != (-1)) goto L9;
        return r10;
    L9:
        add(this.tokenSource.nextToken());
        r10 = r10 + 1;
        goto L3
    L10:
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public Token get(int r10) {
        int r5 = getBufferStartIndex();
        if (r10 >= r5) goto L5;
    L8:
        StringBuilder r11 = j0.v("get(", r10, r5, ") outside buffer: ", "..");
        r11.append(r5 + this.f658n);
        throw new IndexOutOfBoundsException(r11.toString());
    L5:
        if (r10 >= (this.f658n + r5)) goto L8;
        return this.tokens[r10 - r5];
    }

    public final int getBufferStartIndex() {
        return this.currentTokenIndex - this.f659p;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public String getSourceName() {
        return this.tokenSource.getSourceName();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public String getText() {
        return "";
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public TokenSource getTokenSource() {
        return this.tokenSource;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int index() {
        return this.currentTokenIndex;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int mark() {
        int r5 = this.numMarkers;
        if (r5 != 0) goto L5;
        this.lastTokenBufferStart = this.lastToken;
    L5:
        int r10 = (-r5) - 1;
        this.numMarkers = r5 + 1;
        return r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public void release(int r5) {
        int r10 = this.numMarkers;
        if (r5 != (-r10)) goto L12;
        int r11 = r10 - 1;
        this.numMarkers = r11;
        if (r11 != 0) goto L13;
        int r12 = this.f659p;
        if (r12 <= 0) goto L9;
        Token[] r13 = this.tokens;
        System.arraycopy(r13, r12, r13, 0, this.f658n - r12);
        this.f658n -= this.f659p;
        this.f659p = 0;
    L9:
        this.lastTokenBufferStart = this.lastToken;
        return;
    L13:
        return;
    L12:
        throw new IllegalStateException("release() called with an invalid marker.");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public void seek(int r10) {
        int r5 = this.currentTokenIndex;
        if (r10 != r5) goto L5;
        return;
    L5:
        if (r10 <= r5) goto L7;
        sync(r10 - r5);
        r10 = Math.min(r10, (getBufferStartIndex() + this.f658n) - 1);
    L7:
        int r11 = getBufferStartIndex();
        int r12 = r10 - r11;
        if (r12 < 0) goto L19;
        if (r12 >= this.f658n) goto L16;
        this.f659p = r12;
        this.currentTokenIndex = r10;
        if (r12 != 0) goto L14;
        this.lastToken = this.lastTokenBufferStart;
        return;
    L14:
        this.lastToken = this.tokens[r12 - 1];
        return;
    L16:
        StringBuilder r13 = j0.v("seek to index outside buffer: ", r10, r11, " not in ", "..");
        r13.append(r11 + this.f658n);
        throw new UnsupportedOperationException(r13.toString());
    L19:
        throw new IllegalArgumentException(j0.g(r10, "cannot seek to negative index "));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int size() {
        throw new UnsupportedOperationException("Unbuffered stream cannot know its size");
    }

    public void sync(int r5) {
        int r10 = (((this.f659p + r5) - 1) - this.f658n) + 1;
        if (r10 <= 0) goto L6;
        fill(r10);
        return;
    }

    public UnbufferedTokenStream(TokenSource r5, int r10) {
        this.f659p = 0;
        this.numMarkers = 0;
        this.currentTokenIndex = 0;
        this.tokenSource = r5;
        this.tokens = new Token[r10];
        this.f658n = 0;
        fill(1);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public String getText(RuleContext r5) {
        return getText(r5.getSourceInterval());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public String getText(Token r5, Token r10) {
        return getText(Interval.of(r5.getTokenIndex(), r10.getTokenIndex()));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public String getText(Interval r5) {
        int r10 = getBufferStartIndex();
        int r11 = (this.tokens.length + r10) - 1;
        int r12 = r5.f665a;
        int r13 = r5.f666b;
        if (r12 < r10) goto L11;
        if (r13 > r11) goto L11;
        int r14 = r12 - r10;
        int r15 = r13 - r10;
        StringBuilder r16 = new StringBuilder();
    L6:
        if (r14 > r15) goto L9;
        r16.append(this.tokens[r14].getText());
        r14 = r14 + 1;
        goto L6
    L9:
        return r16.toString();
    L11:
        throw new UnsupportedOperationException("interval " + r5 + " not in token buffer window: " + r10 + ".." + r11);
    }
}
