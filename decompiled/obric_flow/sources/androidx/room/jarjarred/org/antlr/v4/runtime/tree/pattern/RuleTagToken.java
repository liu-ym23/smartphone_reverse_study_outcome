package androidx.room.jarjarred.org.antlr.v4.runtime.tree.pattern;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource;

/* JADX INFO: loaded from: classes.dex */
public class RuleTagToken implements Token {
    private final int bypassTokenType;
    private final String label;
    private final String ruleName;

    public RuleTagToken(String r5, int r10) {
        this(r5, r10, null);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getChannel() {
        return 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getCharPositionInLine() {
        return -1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public CharStream getInputStream() {
        return null;
    }

    public final String getLabel() {
        return this.label;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getLine() {
        return 0;
    }

    public final String getRuleName() {
        return this.ruleName;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getStartIndex() {
        return -1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getStopIndex() {
        return -1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public String getText() {
        if (this.label == null) goto L7;
        StringBuilder r5 = new StringBuilder("<");
        r5.append(this.label);
        r5.append(":");
        return j0.q(r5, this.ruleName, ">");
    L7:
        return j0.q(new StringBuilder("<"), this.ruleName, ">");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getTokenIndex() {
        return -1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public TokenSource getTokenSource() {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public int getType() {
        return this.bypassTokenType;
    }

    public String toString() {
        return this.ruleName + ":" + this.bypassTokenType;
    }

    public RuleTagToken(String r5, int r10, String r11) {
        if (r5 == null) goto L9;
        if (r5.isEmpty() == true) goto L9;
        this.ruleName = r5;
        this.bypassTokenType = r10;
        this.label = r11;
        return;
    L9:
        throw new IllegalArgumentException("ruleName cannot be null or empty.");
    }
}
