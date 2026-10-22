package androidx.room.jarjarred.org.antlr.v4.runtime;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ListTokenSource implements TokenSource {
    private TokenFactory<?> _factory;
    protected Token eofToken;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f655i;
    private final String sourceName;
    protected final List<? extends Token> tokens;

    public ListTokenSource(List<? extends Token> r5) {
        this(r5, null);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public int getCharPositionInLine() {
        if (this.f655i < this.tokens.size()) goto L5;
        Token r5 = this.eofToken;
        if (r5 == null) goto L11;
        return r5.getCharPositionInLine();
    L11:
        if (this.tokens.size() <= 0) goto L20;
        Token r10 = (Token) j0.e(this.tokens, 1);
        String r11 = r10.getText();
        if (r11 == null) goto L18;
        int r12 = r11.lastIndexOf(10);
        if (r12 < 0) goto L18;
        return (r11.length() - r12) - 1;
    L18:
        int r13 = r10.getCharPositionInLine();
        return ((r10.getStopIndex() + r13) - r10.getStartIndex()) + 1;
    L20:
        return 0;
    L5:
        return this.tokens.get(this.f655i).getCharPositionInLine();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public CharStream getInputStream() {
        if (this.f655i < this.tokens.size()) goto L5;
        Token r5 = this.eofToken;
        if (r5 == null) goto L11;
        return r5.getInputStream();
    L11:
        if (this.tokens.size() > 0) goto L13;
        return null;
    L13:
        return ((Token) j0.e(this.tokens, 1)).getInputStream();
    L5:
        return this.tokens.get(this.f655i).getInputStream();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public int getLine() {
        if (this.f655i < this.tokens.size()) goto L5;
        Token r5 = this.eofToken;
        if (r5 == null) goto L11;
        return r5.getLine();
    L11:
        if (this.tokens.size() <= 0) goto L22;
        Token r10 = (Token) j0.e(this.tokens, 1);
        int r11 = r10.getLine();
        String r12 = r10.getText();
        if (r12 == null) goto L21;
        int r13 = 0;
    L16:
        if (r13 >= r12.length()) goto L21;
        if (r12.charAt(r13) != '\n') goto L20;
        r11 = r11 + 1;
    L20:
        r13 = r13 + 1;
    L21:
        return r11;
    L22:
        return 1;
    L5:
        return this.tokens.get(this.f655i).getLine();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public String getSourceName() {
        String r5 = this.sourceName;
        if (r5 == null) goto L5;
        return r5;
    L5:
        CharStream r10 = getInputStream();
        if (r10 != null) goto L8;
        return "List";
    L8:
        return r10.getSourceName();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public TokenFactory<?> getTokenFactory() {
        return this._factory;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public Token nextToken() {
        if (this.f655i >= this.tokens.size()) goto L5;
        Token r5 = this.tokens.get(this.f655i);
        if (this.f655i == (this.tokens.size() - 1)) goto L18;
    L20:
        this.f655i++;
        return r5;
    L18:
        if (r5.getType() != (-1)) goto L20;
        this.eofToken = r5;
        goto L20
    L5:
        if (this.eofToken != null) goto L14;
        if (this.tokens.size() <= 0) goto L11;
        int r10 = ((Token) j0.e(this.tokens, 1)).getStopIndex();
        if (r10 == (-1)) goto L11;
        int r11 = r10 + 1;
    L12:
        this.eofToken = this._factory.create(new Pair(this, getInputStream()), -1, "EOF", 0, r11, Math.max(-1, r11 - 1), getLine(), getCharPositionInLine());
    L11:
        r11 = -1;
    L14:
        return this.eofToken;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public void setTokenFactory(TokenFactory<?> r5) {
        this._factory = r5;
    }

    public ListTokenSource(List<? extends Token> r5, String r10) {
        this._factory = CommonTokenFactory.DEFAULT;
        if (r5 == null) goto L7;
        this.tokens = r5;
        this.sourceName = r10;
        return;
    L7:
        throw new NullPointerException("tokens cannot be null");
    }
}
