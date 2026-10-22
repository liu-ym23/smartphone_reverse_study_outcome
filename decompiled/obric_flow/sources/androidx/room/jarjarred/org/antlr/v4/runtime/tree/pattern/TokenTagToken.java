package androidx.room.jarjarred.org.antlr.v4.runtime.tree.pattern;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.CommonToken;

/* JADX INFO: loaded from: classes.dex */
public class TokenTagToken extends CommonToken {
    private final String label;
    private final String tokenName;

    public TokenTagToken(String r5, int r10) {
        this(r5, r10, null);
    }

    public final String getLabel() {
        return this.label;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.CommonToken, androidx.room.jarjarred.org.antlr.v4.runtime.Token
    public String getText() {
        if (this.label == null) goto L7;
        StringBuilder r5 = new StringBuilder("<");
        r5.append(this.label);
        r5.append(":");
        return j0.q(r5, this.tokenName, ">");
    L7:
        return j0.q(new StringBuilder("<"), this.tokenName, ">");
    }

    public final String getTokenName() {
        return this.tokenName;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.CommonToken
    public String toString() {
        return this.tokenName + ":" + this.type;
    }

    public TokenTagToken(String r5, int r10, String r11) {
        super(r10);
        this.tokenName = r5;
        this.label = r11;
    }
}
