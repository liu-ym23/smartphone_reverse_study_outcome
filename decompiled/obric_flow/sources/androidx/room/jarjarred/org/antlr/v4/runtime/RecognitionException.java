package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;

/* JADX INFO: loaded from: classes.dex */
public class RecognitionException extends RuntimeException {
    private final RuleContext ctx;
    private final IntStream input;
    private int offendingState;
    private Token offendingToken;
    private final Recognizer<?, ?> recognizer;

    public RecognitionException(Recognizer<?, ?> r5, IntStream r10, ParserRuleContext r11) {
        this.offendingState = -1;
        this.recognizer = r5;
        this.input = r10;
        this.ctx = r11;
        if (r5 == null) goto L6;
        this.offendingState = r5.getState();
        return;
    }

    public RuleContext getCtx() {
        return this.ctx;
    }

    public IntervalSet getExpectedTokens() {
        Recognizer<?, ?> r5 = this.recognizer;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getATN().getExpectedTokens(this.offendingState, this.ctx);
    }

    public IntStream getInputStream() {
        return this.input;
    }

    public int getOffendingState() {
        return this.offendingState;
    }

    public Token getOffendingToken() {
        return this.offendingToken;
    }

    public Recognizer<?, ?> getRecognizer() {
        return this.recognizer;
    }

    public final void setOffendingState(int r5) {
        this.offendingState = r5;
    }

    public final void setOffendingToken(Token r5) {
        this.offendingToken = r5;
    }

    public RecognitionException(String r5, Recognizer<?, ?> r10, IntStream r11, ParserRuleContext r12) {
        super(r5);
        this.offendingState = -1;
        this.recognizer = r10;
        this.input = r11;
        this.ctx = r12;
        if (r10 == null) goto L6;
        this.offendingState = r10.getState();
        return;
    }
}
