package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNConfigSet;

/* JADX INFO: loaded from: classes.dex */
public class NoViableAltException extends RecognitionException {
    private final ATNConfigSet deadEndConfigs;
    private final Token startToken;

    public NoViableAltException(Parser r10) {
        this(r10, r10.getInputStream(), r10.getCurrentToken(), r10.getCurrentToken(), null, r10._ctx);
    }

    public ATNConfigSet getDeadEndConfigs() {
        return this.deadEndConfigs;
    }

    public Token getStartToken() {
        return this.startToken;
    }

    public NoViableAltException(Parser r5, TokenStream r10, Token r11, Token r12, ATNConfigSet r13, ParserRuleContext r14) {
        super(r5, r10, r14);
        this.deadEndConfigs = r13;
        this.startToken = r11;
        setOffendingToken(r12);
    }
}
