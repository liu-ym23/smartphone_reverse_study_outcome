package androidx.room.jarjarred.org.antlr.v4.runtime;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class BufferedTokenStream implements TokenStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected boolean fetchedEOF;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected int f654p;
    protected TokenSource tokenSource;
    protected List<Token> tokens;

    public BufferedTokenStream(TokenSource r5) {
        this.tokens = new ArrayList(100);
        this.f654p = -1;
        if (r5 == null) goto L7;
        this.tokenSource = r5;
        return;
    L7:
        throw new NullPointerException("tokenSource cannot be null");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int LA(int r5) {
        return LT(r5).getType();
    }

    public Token LB(int r5) {
        int r10 = this.f654p;
        if ((r10 - r5) >= 0) goto L7;
        return null;
    L7:
        return this.tokens.get(r10 - r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public Token LT(int r5) {
        lazyInit();
        if (r5 != 0) goto L6;
        return null;
    L6:
        if (r5 < 0) goto L8;
        int r10 = (this.f654p + r5) - 1;
        sync(r10);
        if (r10 < this.tokens.size()) goto L14;
        return (Token) j0.e(this.tokens, 1);
    L14:
        return this.tokens.get(r10);
    L8:
        return LB(-r5);
    }

    public int adjustSeekIndex(int r5) {
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public void consume() {
        int r5 = this.f654p;
        if (r5 < 0) goto L13;
        if (this.fetchedEOF == false) goto L10;
        if (r5 >= (this.tokens.size() - 1)) goto L13;
    L15:
        if (sync(this.f654p + 1) == false) goto L20;
        this.f654p = adjustSeekIndex(this.f654p + 1);
        return;
    L20:
        return;
    L10:
        if (r5 < this.tokens.size()) goto L15;
    L13:
        if (LA(1) != (-1)) goto L15;
        throw new IllegalStateException("cannot consume EOF");
    }

    public int fetch(int r5) {
        int r10 = 0;
        if (this.fetchedEOF == false) goto L5;
        return 0;
    L5:
        if (r10 >= r5) goto L14;
        Token r11 = this.tokenSource.nextToken();
        if ((r11 instanceof WritableToken) == false) goto L9;
        ((WritableToken) r11).setTokenIndex(this.tokens.size());
    L9:
        this.tokens.add(r11);
        if (r11.getType() == (-1)) goto L11;
        r10 = r10 + 1;
        goto L5
    L11:
        this.fetchedEOF = true;
        return r10 + 1;
    L14:
        return r5;
    }

    public void fill() {
        lazyInit();
    L4:
        if (fetch(1000) >= 1000) goto L4;
    }

    public List<Token> filterForChannel(int r5, int r10, int r11) {
        ArrayList r12 = new ArrayList();
    L3:
        if (r5 > r10) goto L14;
        Token r13 = this.tokens.get(r5);
        if (r11 != (-1)) goto L10;
        if (r13.getChannel() == 0) goto L12;
        r12.add(r13);
    L12:
        r5 = r5 + 1;
        goto L3
    L10:
        if (r13.getChannel() != r11) goto L12;
        r12.add(r13);
        goto L12
    L14:
        if (r12.size() != 0) goto L17;
        return null;
    L17:
        return r12;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public Token get(int r5) {
        if (r5 >= 0) goto L4;
    L7:
        StringBuilder r10 = j0.s(r5, "token index ", " out of range 0..");
        r10.append(this.tokens.size() - 1);
        throw new IndexOutOfBoundsException(r10.toString());
    L4:
        if (r5 >= this.tokens.size()) goto L7;
        return this.tokens.get(r5);
    }

    public List<Token> getHiddenTokensToLeft(int r5, int r10) {
        lazyInit();
        if (r5 >= 0) goto L5;
    L14:
        StringBuilder r11 = new StringBuilder();
        r11.append(r5);
        r11.append(" not in 0..");
        r11.append(this.tokens.size() - 1);
        throw new IndexOutOfBoundsException(r11.toString());
    L5:
        if (r5 >= this.tokens.size()) goto L14;
        if (r5 != 0) goto L9;
        return null;
    L9:
        int r12 = r5 - 1;
        int r13 = previousTokenOnChannel(r12, 0);
        if (r13 != r12) goto L13;
        return null;
    L13:
        return filterForChannel(r13 + 1, r12, r10);
    }

    public List<Token> getHiddenTokensToRight(int r5, int r10) {
        lazyInit();
        if (r5 >= 0) goto L5;
    L11:
        StringBuilder r11 = new StringBuilder();
        r11.append(r5);
        r11.append(" not in 0..");
        r11.append(this.tokens.size() - 1);
        throw new IndexOutOfBoundsException(r11.toString());
    L5:
        if (r5 >= this.tokens.size()) goto L11;
        int r12 = r5 + 1;
        int r13 = nextTokenOnChannel(r12, 0);
        if (r13 != (-1)) goto L10;
        r13 = size() - 1;
    L10:
        return filterForChannel(r12, r13, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public String getSourceName() {
        return this.tokenSource.getSourceName();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public String getText() {
        return getText(Interval.of(0, size() - 1));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public TokenSource getTokenSource() {
        return this.tokenSource;
    }

    public List<Token> getTokens() {
        return this.tokens;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int index() {
        return this.f654p;
    }

    public final void lazyInit() {
        if (this.f654p != (-1)) goto L6;
        setup();
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int mark() {
        return 0;
    }

    public int nextTokenOnChannel(int r5, int r10) {
        sync(r5);
        if (r5 >= size()) goto L5;
        Token r11 = this.tokens.get(r5);
    L7:
        Token r12 = r11;
        if (r12.getChannel() == r10) goto L13;
        if (r12.getType() == (-1)) goto L11;
        r5 = r5 + 1;
        sync(r5);
        r11 = this.tokens.get(r5);
        goto L7
    L11:
        return r5;
    L13:
        return r5;
    L5:
        return size() - 1;
    }

    public int previousTokenOnChannel(int r5, int r10) {
        sync(r5);
        if (r5 >= size()) goto L5;
    L6:
        if (r5 < 0) goto L13;
        Token r11 = this.tokens.get(r5);
        if (r11.getType() == (-1)) goto L13;
        if (r11.getChannel() == r10) goto L13;
        r5 = r5 - 1;
    L13:
        return r5;
    L5:
        return size() - 1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public void release(int r5) {
    }

    @Deprecated
    public void reset() {
        seek(0);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public void seek(int r5) {
        lazyInit();
        this.f654p = adjustSeekIndex(r5);
    }

    public void setTokenSource(TokenSource r5) {
        this.tokenSource = r5;
        this.tokens.clear();
        this.f654p = -1;
        this.fetchedEOF = false;
    }

    public void setup() {
        sync(0);
        this.f654p = adjustSeekIndex(0);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.IntStream
    public int size() {
        return this.tokens.size();
    }

    public boolean sync(int r5) {
        int r10 = (r5 - this.tokens.size()) + 1;
        if (r10 > 0) goto L5;
        return true;
    L5:
        if (fetch(r10) >= r10) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public String getText(Interval r10) {
        int r5 = r10.f665a;
        int r11 = r10.f666b;
        if (r5 < 0) goto L17;
        if (r11 < 0) goto L21;
        fill();
        if (r11 < this.tokens.size()) goto L9;
        r11 = this.tokens.size() - 1;
    L9:
        StringBuilder r12 = new StringBuilder();
    L10:
        if (r5 > r11) goto L16;
        Token r13 = this.tokens.get(r5);
        if (r13.getType() == (-1)) goto L16;
        r12.append(r13.getText());
        r5 = r5 + 1;
    L16:
        return r12.toString();
    L21:
        return "";
    L17:
        return "";
    }

    public List<Token> getTokens(int r5, int r10) {
        return getTokens(r5, r10, null);
    }

    public List<Token> getTokens(int r5, int r10, Set<Integer> r11) {
        lazyInit();
        if (r5 >= 0) goto L5;
    L25:
        StringBuilder r12 = j0.v("start ", r5, r10, " or stop ", " not in 0..");
        r12.append(this.tokens.size() - 1);
        throw new IndexOutOfBoundsException(r12.toString());
    L5:
        if (r10 >= this.tokens.size()) goto L25;
        if (r10 < 0) goto L25;
        if (r5 >= this.tokens.size()) goto L25;
        if (r5 <= r10) goto L12;
        return null;
    L12:
        ArrayList r13 = new ArrayList();
    L13:
        if (r5 > r10) goto L21;
        Token r14 = this.tokens.get(r5);
        if (r11 != null) goto L17;
    L18:
        r13.add(r14);
    L19:
        r5 = r5 + 1;
        goto L13
    L17:
        if (r11.contains(Integer.valueOf(r14.getType())) == false) goto L19;
    L21:
        if (r13.isEmpty() == false) goto L24;
        return null;
    L24:
        return r13;
    }

    public List<Token> getHiddenTokensToLeft(int r5) {
        return getHiddenTokensToLeft(r5, -1);
    }

    public List<Token> getHiddenTokensToRight(int r5) {
        return getHiddenTokensToRight(r5, -1);
    }

    public List<Token> get(int r5, int r10) {
        if (r5 < 0) goto L14;
        if (r10 < 0) goto L19;
        lazyInit();
        ArrayList r11 = new ArrayList();
        if (r10 < this.tokens.size()) goto L8;
        r10 = this.tokens.size() - 1;
    L8:
        if (r5 > r10) goto L13;
        Token r12 = this.tokens.get(r5);
        if (r12.getType() == (-1)) goto L13;
        r11.add(r12);
        r5 = r5 + 1;
    L13:
        return r11;
    L19:
        return null;
    L14:
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public String getText(RuleContext r5) {
        return getText(r5.getSourceInterval());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream
    public String getText(Token r5, Token r10) {
        if (r5 == null) goto L6;
        if (r10 != null) goto L5;
        return "";
    L5:
        return getText(Interval.of(r5.getTokenIndex(), r10.getTokenIndex()));
    L6:
        return "";
    }

    public List<Token> getTokens(int r5, int r10, int r11) {
        HashSet r12 = new HashSet(r11);
        r12.add(Integer.valueOf(r11));
        return getTokens(r5, r10, r12);
    }
}
