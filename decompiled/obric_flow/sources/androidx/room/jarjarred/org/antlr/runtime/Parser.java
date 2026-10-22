package androidx.room.jarjarred.org.antlr.runtime;

import ai.j0;

/* JADX INFO: loaded from: classes.dex */
public class Parser extends BaseRecognizer {
    public TokenStream input;

    public Parser(TokenStream r5) {
        setTokenStream(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public Object getCurrentInputSymbol(IntStream r5) {
        return ((TokenStream) r5).LT(1);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public Object getMissingSymbol(IntStream r5, RecognitionException r10, int r11, BitSet r12) {
        if (r11 != (-1)) goto L5;
        String r13 = "<missing EOF>";
    L6:
        CommonToken r14 = new CommonToken(r11, r13);
        TokenStream r15 = (TokenStream) r5;
        Token r16 = r15.LT(1);
        if (r16.getType() != (-1)) goto L9;
        r16 = r15.LT(-1);
    L9:
        r14.line = r16.getLine();
        r14.charPositionInLine = r16.getCharPositionInLine();
        r14.channel = 0;
        r14.input = r16.getInputStream();
        return r14;
    L5:
        r13 = j0.q(new StringBuilder("<missing "), getTokenNames()[r11], ">");
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer, androidx.room.jarjarred.org.antlr.runtime.TokenSource
    public String getSourceName() {
        return this.input.getSourceName();
    }

    public TokenStream getTokenStream() {
        return this.input;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void reset() {
        super.reset();
        TokenStream r5 = this.input;
        if (r5 == null) goto L6;
        r5.seek(0);
        return;
    }

    public void setTokenStream(TokenStream r5) {
        this.input = null;
        reset();
        this.input = r5;
    }

    public void traceIn(String r5, int r10) {
        super.traceIn(r5, r10, this.input.LT(1));
    }

    public void traceOut(String r5, int r10) {
        super.traceOut(r5, r10, this.input.LT(1));
    }

    public Parser(TokenStream r5, RecognizerSharedState r10) {
        super(r10);
        this.input = r5;
    }
}
