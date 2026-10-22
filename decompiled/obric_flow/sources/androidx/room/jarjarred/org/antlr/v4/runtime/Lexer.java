package androidx.room.jarjarred.org.antlr.v4.runtime;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LexerATNSimulator;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntegerStack;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class Lexer extends Recognizer<Integer, LexerATNSimulator> implements TokenSource {
    public static final int DEFAULT_MODE = 0;
    public static final int DEFAULT_TOKEN_CHANNEL = 0;
    public static final int HIDDEN = 1;
    public static final int MAX_CHAR_VALUE = 1114111;
    public static final int MIN_CHAR_VALUE = 0;
    public static final int MORE = -2;
    public static final int SKIP = -3;
    public int _channel;
    protected TokenFactory<?> _factory;
    public boolean _hitEOF;
    public CharStream _input;
    public int _mode;
    public final IntegerStack _modeStack;
    public String _text;
    public Token _token;
    protected Pair<TokenSource, CharStream> _tokenFactorySourcePair;
    public int _tokenStartCharIndex;
    public int _tokenStartCharPositionInLine;
    public int _tokenStartLine;
    public int _type;

    public Lexer() {
        this._factory = CommonTokenFactory.DEFAULT;
        this._tokenStartCharIndex = -1;
        this._modeStack = new IntegerStack();
        this._mode = 0;
    }

    public void emit(Token r5) {
        this._token = r5;
    }

    public Token emitEOF() {
        int r10 = getCharPositionInLine();
        Token r5 = this._factory.create(this._tokenFactorySourcePair, -1, null, 0, this._input.index(), this._input.index() - 1, getLine(), r10);
        emit(r5);
        return r5;
    }

    public List<? extends Token> getAllTokens() {
        ArrayList r5 = new ArrayList();
        Token r10 = nextToken();
    L4:
        if (r10.getType() == (-1)) goto L6;
        r5.add(r10);
        r10 = nextToken();
        goto L4
    L6:
        return r5;
    }

    public int getChannel() {
        return this._channel;
    }

    public String[] getChannelNames() {
        return null;
    }

    public String getCharErrorDisplay(int r5) {
        return j0.k("'", getErrorDisplay(r5), "'");
    }

    public int getCharIndex() {
        return this._input.index();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public int getCharPositionInLine() {
        return getInterpreter().getCharPositionInLine();
    }

    public String getErrorDisplay(String r5) {
        StringBuilder r10 = new StringBuilder();
        char[] r11 = r5.toCharArray();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r10.append(getErrorDisplay(r11[r13]));
        r13 = r13 + 1;
        goto L3
    L6:
        return r10.toString();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer, androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public /* bridge */ /* synthetic */ IntStream getInputStream() {
        return getInputStream();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public int getLine() {
        return getInterpreter().getLine();
    }

    public String[] getModeNames() {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public String getSourceName() {
        return this._input.getSourceName();
    }

    public String getText() {
        String r5 = this._text;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return getInterpreter().getText(this._input);
    }

    public Token getToken() {
        return this._token;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer, androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public TokenFactory<? extends Token> getTokenFactory() {
        return this._factory;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    @Deprecated
    public String[] getTokenNames() {
        return null;
    }

    public int getType() {
        return this._type;
    }

    public void mode(int r5) {
        this._mode = r5;
    }

    public void more() {
        this._type = -2;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public Token nextToken() {
        CharStream r5 = this._input;
        if (r5 == null) goto L39;
        int r10 = r5.mark();
    L40:
    L10:
        th = move-exception;
        this._input.release(r10);
        throw th;
    L6:
        if (this._hitEOF == true) goto L7;
        this._token = null;     // Catch: Throwable -> L10
        this._channel = 0;     // Catch: Throwable -> L10
        this._tokenStartCharIndex = this._input.index();     // Catch: Throwable -> L10
        this._tokenStartCharPositionInLine = getInterpreter().getCharPositionInLine();     // Catch: Throwable -> L10
        this._tokenStartLine = getInterpreter().getLine();     // Catch: Throwable -> L10
        this._text = null;     // Catch: Throwable -> L10
    L14:
        this._type = 0;     // Catch: Throwable -> L10
        int r11 = getInterpreter().match(this._input, this._mode);     // Catch: Throwable -> L10 LexerNoViableAltException -> L18
    L21:
        if (this._input.LA(1) != (-1)) goto L24;
        this._hitEOF = true;     // Catch: Throwable -> L10
    L24:
        if (this._type != 0) goto L26;
        this._type = r11;     // Catch: Throwable -> L10
    L26:
        int r12 = this._type;     // Catch: Throwable -> L10
        if (r12 == (-3)) goto L40;
        if (r12 == (-2)) goto L14;
        if (this._token != null) goto L34;
        emit();     // Catch: Throwable -> L10
    L34:
        Token r13 = this._token;     // Catch: Throwable -> L10
    L8:
        this._input.release(r10);
        return r13;
    L18:
        e = move-exception;
        notifyListeners(e);     // Catch: Throwable -> L10
        recover(e);     // Catch: Throwable -> L10
        r11 = -3;
        goto L21
    L7:
        emitEOF();     // Catch: Throwable -> L10
        r13 = this._token;     // Catch: Throwable -> L10
        goto L8
    L39:
        throw new IllegalStateException("nextToken requires a non-null input stream.");
    }

    public void notifyListeners(LexerNoViableAltException r10) {
        CharStream r5 = this._input;
        getErrorListenerDispatch().syntaxError(this, null, this._tokenStartLine, this._tokenStartCharPositionInLine, "token recognition error at: '" + getErrorDisplay(r5.getText(Interval.of(this._tokenStartCharIndex, r5.index()))) + "'", r10);
    }

    public int popMode() {
        if (this._modeStack.isEmpty() == true) goto L7;
        mode(this._modeStack.pop());
        return this._mode;
    L7:
        throw new EmptyStackException();
    }

    public void pushMode(int r5) {
        this._modeStack.push(this._mode);
        mode(r5);
    }

    public void recover(LexerNoViableAltException r5) {
        if (this._input.LA(1) == (-1)) goto L6;
        getInterpreter().consume(this._input);
        return;
    }

    public void reset() {
        CharStream r5 = this._input;
        if (r5 == null) goto L5;
        r5.seek(0);
    L5:
        this._token = null;
        this._type = 0;
        this._channel = 0;
        this._tokenStartCharIndex = -1;
        this._tokenStartCharPositionInLine = -1;
        this._tokenStartLine = -1;
        this._text = null;
        this._hitEOF = false;
        this._mode = 0;
        this._modeStack.clear();
        getInterpreter().reset();
    }

    public void setChannel(int r5) {
        this._channel = r5;
    }

    public void setCharPositionInLine(int r5) {
        getInterpreter().setCharPositionInLine(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public void setInputStream(IntStream r5) {
        this._input = null;
        this._tokenFactorySourcePair = new Pair(this, null);
        reset();
        CharStream r10 = (CharStream) r5;
        this._input = r10;
        this._tokenFactorySourcePair = new Pair(this, r10);
    }

    public void setLine(int r5) {
        getInterpreter().setLine(r5);
    }

    public void setText(String r5) {
        this._text = r5;
    }

    public void setToken(Token r5) {
        this._token = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer, androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public void setTokenFactory(TokenFactory<?> r5) {
        this._factory = r5;
    }

    public void setType(int r5) {
        this._type = r5;
    }

    public void skip() {
        this._type = -3;
    }

    public Token emit() {
        Token r5 = this._factory.create(this._tokenFactorySourcePair, this._type, this._text, this._channel, this._tokenStartCharIndex, getCharIndex() - 1, this._tokenStartLine, this._tokenStartCharPositionInLine);
        emit(r5);
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer, androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public CharStream getInputStream() {
        return this._input;
    }

    public void recover(RecognitionException r5) {
        this._input.consume();
    }

    public String getErrorDisplay(int r5) {
        String r10 = String.valueOf((char) r5);
        if (r5 != (-1)) goto L5;
        return "<EOF>";
    L5:
        if (r5 != 13) goto L7;
        return "\\r";
    L7:
        if (r5 != 9) goto L9;
        return "\\t";
    L9:
        if (r5 != 10) goto L19;
        return "\\n";
    L19:
        return r10;
    }

    public Lexer(CharStream r5) {
        this._factory = CommonTokenFactory.DEFAULT;
        this._tokenStartCharIndex = -1;
        this._modeStack = new IntegerStack();
        this._mode = 0;
        this._input = r5;
        this._tokenFactorySourcePair = new Pair(this, r5);
    }
}
