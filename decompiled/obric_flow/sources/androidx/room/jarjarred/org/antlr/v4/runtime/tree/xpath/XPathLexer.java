package androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath;

import androidx.room.jarjarred.org.antlr.v4.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.LexerNoViableAltException;
import androidx.room.jarjarred.org.antlr.v4.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary;
import androidx.room.jarjarred.org.antlr.v4.runtime.VocabularyImpl;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LexerGrammar;

/* JADX INFO: loaded from: classes.dex */
public class XPathLexer extends Lexer {
    public static final int ANYWHERE = 3;
    public static final int BANG = 6;
    public static final int ID = 7;
    public static final int ROOT = 4;
    public static final int RULE_REF = 2;
    public static final int STRING = 8;
    public static final int TOKEN_REF = 1;
    public static final Vocabulary VOCABULARY = null;
    public static final int WILDCARD = 5;
    private static final String[] _LITERAL_NAMES = null;
    private static final String[] _SYMBOLIC_NAMES = null;
    public static String[] modeNames;
    public static final String[] ruleNames = null;

    @Deprecated
    public static final String[] tokenNames = null;
    protected int charPositionInLine;
    protected int line;

    static {
        modeNames = new String[]{LexerGrammar.DEFAULT_MODE_NAME};
        ruleNames = new String[]{"ANYWHERE", "ROOT", "WILDCARD", "BANG", "ID", "NameChar", "NameStartChar", "STRING"};
        String[] r5 = {null, null, null, "'//'", "'/'", "'*'", "'!'"};
        _LITERAL_NAMES = r5;
        String[] r10 = {null, "TOKEN_REF", "RULE_REF", "ANYWHERE", "ROOT", "WILDCARD", "BANG", "ID", "STRING"};
        _SYMBOLIC_NAMES = r10;
        VOCABULARY = new VocabularyImpl(r5, r10);
        tokenNames = new String[r10.length];
        int r11 = 0;
    L3:
        String[] r12 = tokenNames;
        if (r11 >= r12.length) goto L12;
        Vocabulary r13 = VOCABULARY;
        String r14 = r13.getLiteralName(r11);
        r12[r11] = r14;
        if (r14 != null) goto L9;
        r12[r11] = r13.getSymbolicName(r11);
    L9:
        if (r12[r11] != null) goto L11;
        r12[r11] = Grammar.INVALID_TOKEN_NAME;
    L11:
        r11 = r11 + 1;
        goto L3
    }

    public XPathLexer(CharStream r5) {
        super(r5);
        this.line = 1;
        this.charPositionInLine = 0;
    }

    public void consume() {
        if (this._input.LA(1) != 10) goto L5;
        this.line++;
        this.charPositionInLine = 0;
    L6:
        this._input.consume();
        return;
    L5:
        this.charPositionInLine++;
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public ATN getATN() {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Lexer, androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public int getCharPositionInLine() {
        return this.charPositionInLine;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public String getGrammarFileName() {
        return "XPathLexer.g4";
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Lexer
    public String[] getModeNames() {
        return modeNames;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Lexer, androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    public boolean isNameChar(int r5) {
        return Character.isUnicodeIdentifierPart(r5);
    }

    public boolean isNameStartChar(int r5) {
        return Character.isUnicodeIdentifierStart(r5);
    }

    public String matchID() {
        int r5 = this._input.index();
        consume();
    L4:
        if (isNameChar(this._input.LA(1)) == false) goto L6;
        consume();
        goto L4
    L6:
        CharStream r10 = this._input;
        return r10.getText(Interval.of(r5, r10.index() - 1));
    }

    public String matchString() {
        int r5 = this._input.index();
        consume();
    L4:
        if (this._input.LA(1) == 39) goto L6;
        consume();
        goto L4
    L6:
        consume();
        CharStream r10 = this._input;
        return r10.getText(Interval.of(r5, r10.index() - 1));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Lexer, androidx.room.jarjarred.org.antlr.v4.runtime.TokenSource
    public Token nextToken() {
        this._tokenStartCharIndex = this._input.index();
        CommonToken r5 = null;
    L3:
        if (r5 != null) goto L32;
        int r10 = this._input.LA(1);
        if (r10 == (-1)) goto L31;
        if (r10 != 33) goto L9;
        consume();
        r5 = new CommonToken(6, XPath.NOT);
        goto L3
    L9:
        if (r10 == 39) goto L27;
        if (r10 != 42) goto L13;
        consume();
        r5 = new CommonToken(5, XPath.WILDCARD);
        goto L3
    L13:
        if (r10 != 47) goto L15;
        consume();
        if (this._input.LA(1) == 47) goto L24;
        r5 = new CommonToken(4, "/");
        goto L3
    L24:
        consume();
        r5 = new CommonToken(3, "//");
        goto L3
    L15:
        if (isNameStartChar(this._input.LA(1)) == false) goto L21;
        String r11 = matchID();
        if (Character.isUpperCase(r11.charAt(0)) == true) goto L18;
        CommonToken r12 = new CommonToken(2, r11);
    L28:
        r5 = r12;
        goto L3
    L18:
        r5 = new CommonToken(1, r11);
        goto L3
    L21:
        throw new LexerNoViableAltException(this, this._input, this._tokenStartCharIndex, null);
    L27:
        r12 = new CommonToken(8, matchString());
        goto L28
    L31:
        return new CommonToken(-1, "<EOF>");
    L32:
        r5.setStartIndex(this._tokenStartCharIndex);
        r5.setCharPositionInLine(this._tokenStartCharIndex);
        r5.setLine(this.line);
        return r5;
    }
}
