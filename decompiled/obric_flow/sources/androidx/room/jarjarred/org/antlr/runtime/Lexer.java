package androidx.room.jarjarred.org.antlr.runtime;

import ai.j0;

/* JADX INFO: loaded from: classes.dex */
public abstract class Lexer extends BaseRecognizer implements TokenSource {
    protected CharStream input;

    public Lexer() {
    }

    public void emit(Token r5) {
        this.state.token = r5;
    }

    public String getCharErrorDisplay(int r5) {
        String r10 = String.valueOf((char) r5);
        if (r5 != (-1)) goto L5;
        r10 = "<EOF>";
    L16:
        return j0.k("'", r10, "'");
    L5:
        if (r5 != 13) goto L7;
        r10 = "\\r";
        goto L16
    L7:
        if (r5 != 9) goto L9;
        r10 = "\\t";
        goto L16
    L9:
        if (r5 != 10) goto L16;
        r10 = "\\n";
        goto L16
    }

    public int getCharIndex() {
        return this.input.index();
    }

    public int getCharPositionInLine() {
        return this.input.getCharPositionInLine();
    }

    public CharStream getCharStream() {
        return this.input;
    }

    public Token getEOFToken() {
        CharStream r5 = this.input;
        CommonToken r10 = new CommonToken(r5, -1, 0, r5.index(), this.input.index());
        r10.setLine(getLine());
        r10.setCharPositionInLine(getCharPositionInLine());
        return r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getErrorMessage(RecognitionException r5, String[] r10) {
        if ((r5 instanceof MismatchedTokenException) == false) goto L6;
        return "mismatched character " + getCharErrorDisplay(r5.f626c) + " expecting " + getCharErrorDisplay(((MismatchedTokenException) r5).expecting);
    L6:
        if ((r5 instanceof NoViableAltException) == false) goto L9;
        return "no viable alternative at character " + getCharErrorDisplay(r5.f626c);
    L9:
        if ((r5 instanceof EarlyExitException) == false) goto L12;
        return "required (...)+ loop did not match anything at character " + getCharErrorDisplay(r5.f626c);
    L12:
        if ((r5 instanceof MismatchedNotSetException) == false) goto L15;
        return "mismatched character " + getCharErrorDisplay(r5.f626c) + " expecting set " + ((MismatchedNotSetException) r5).expecting;
    L15:
        if ((r5 instanceof MismatchedSetException) == false) goto L18;
        return "mismatched character " + getCharErrorDisplay(r5.f626c) + " expecting set " + ((MismatchedSetException) r5).expecting;
    L18:
        if ((r5 instanceof MismatchedRangeException) == false) goto L21;
        MismatchedRangeException r11 = (MismatchedRangeException) r5;
        return "mismatched character " + getCharErrorDisplay(r5.f626c) + " expecting set " + getCharErrorDisplay(r11.f624a) + ".." + getCharErrorDisplay(r11.f625b);
    L21:
        return super.getErrorMessage(r5, r10);
    }

    public int getLine() {
        return this.input.getLine();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer, androidx.room.jarjarred.org.antlr.runtime.TokenSource
    public String getSourceName() {
        return this.input.getSourceName();
    }

    public String getText() {
        RecognizerSharedState r5 = this.state;
        String r10 = r5.text;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return this.input.substring(r5.tokenStartCharIndex, getCharIndex() - 1);
    }

    public abstract void mTokens() throws RecognitionException;

    public void match(String r10) throws MismatchedTokenException {
        int r5 = 0;
    L4:
        if (r5 >= r10.length()) goto L14;
        if (this.input.LA(1) != r10.charAt(r5)) goto L7;
        r5 = r5 + 1;
        this.input.consume();
        this.state.failed = false;
        goto L4
    L7:
        RecognizerSharedState r11 = this.state;
        if (r11.backtracking <= 0) goto L11;
        r11.failed = true;
        return;
    L11:
        MismatchedTokenException r12 = new MismatchedTokenException(r10.charAt(r5), this.input);
        recover(r12);
        throw r12;
    }

    public void matchAny() {
        this.input.consume();
    }

    public void matchRange(int r5, int r10) throws MismatchedRangeException {
        if (this.input.LA(1) >= r5) goto L5;
    L9:
        RecognizerSharedState r11 = this.state;
        if (r11.backtracking <= 0) goto L13;
        r11.failed = true;
        return;
    L13:
        MismatchedRangeException r12 = new MismatchedRangeException(r5, r10, this.input);
        recover(r12);
        throw r12;
    L5:
        if (this.input.LA(1) > r10) goto L9;
        this.input.consume();
        this.state.failed = false;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenSource
    public Token nextToken() {
    L2:
        RecognizerSharedState r5 = this.state;
        r5.token = null;
        r5.channel = 0;
        r5.tokenStartCharIndex = this.input.index();
        RecognizerSharedState r10 = this.state;
        r10.tokenStartCharPositionInLine = this.input.getCharPositionInLine();
        RecognizerSharedState r11 = this.state;
        r11.tokenStartLine = this.input.getLine();
        this.state.text = null;
        if (this.input.LA(1) == (-1)) goto L5;
        this.mTokens();     // Catch: RecognitionException -> L9 MismatchedTokenException -> L11 MismatchedRangeException -> L13
        Token r12 = this.state.token;     // Catch: RecognitionException -> L9 MismatchedTokenException -> L11 MismatchedRangeException -> L13
        if (r12 == null) goto L8;
        if (r12 == Token.SKIP_TOKEN) goto L2;
    L18:
    L19:
        return this.state.token;
    L8:
        this.emit();     // Catch: RecognitionException -> L9 MismatchedTokenException -> L11 MismatchedRangeException -> L13
    L13:
        e = move-exception;
        this.reportError(e);
    L11:
        e = move-exception;
        this.reportError(e);
    L9:
        e = move-exception;
        this.reportError(e);
        this.recover(e);
        goto L2
    L5:
        return this.getEOFToken();
    }

    public void recover(RecognitionException r5) {
        this.input.consume();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void reportError(RecognitionException r5) {
        displayRecognitionError(getTokenNames(), r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void reset() {
        super.reset();
        CharStream r5 = this.input;
        if (r5 == null) goto L5;
        r5.seek(0);
    L5:
        RecognizerSharedState r10 = this.state;
        if (r10 != null) goto L8;
        return;
    L8:
        r10.token = null;
        r10.type = 0;
        r10.channel = 0;
        r10.tokenStartCharIndex = -1;
        r10.tokenStartCharPositionInLine = -1;
        r10.tokenStartLine = -1;
        r10.text = null;
    }

    public void setCharStream(CharStream r5) {
        this.input = null;
        reset();
        this.input = r5;
    }

    public void setText(String r5) {
        this.state.text = r5;
    }

    public void skip() {
        RecognizerSharedState r5 = this.state;
        r5.token = Token.SKIP_TOKEN;
    }

    public void traceIn(String r5, int r10) {
        super.traceIn(r5, r10, ((char) this.input.LT(1)) + " line=" + getLine() + ":" + getCharPositionInLine());
    }

    public void traceOut(String r5, int r10) {
        super.traceOut(r5, r10, ((char) this.input.LT(1)) + " line=" + getLine() + ":" + getCharPositionInLine());
    }

    public Lexer(CharStream r5) {
        this.input = r5;
    }

    public Token emit() {
        CharStream r5 = this.input;
        RecognizerSharedState r10 = this.state;
        CommonToken r11 = new CommonToken(r5, r10.type, r10.channel, r10.tokenStartCharIndex, getCharIndex() - 1);
        r11.setLine(this.state.tokenStartLine);
        r11.setText(this.state.text);
        r11.setCharPositionInLine(this.state.tokenStartCharPositionInLine);
        emit(r11);
        return r11;
    }

    public Lexer(CharStream r5, RecognizerSharedState r10) {
        super(r10);
        this.input = r5;
    }

    public void match(int r5) throws MismatchedTokenException {
        if (this.input.LA(1) == r5) goto L10;
        RecognizerSharedState r10 = this.state;
        if (r10.backtracking <= 0) goto L8;
        r10.failed = true;
        return;
    L8:
        MismatchedTokenException r11 = new MismatchedTokenException(r5, this.input);
        recover(r11);
        throw r11;
    L10:
        this.input.consume();
        this.state.failed = false;
    }
}
