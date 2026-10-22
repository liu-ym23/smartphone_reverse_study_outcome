package androidx.room.jarjarred.org.stringtemplate.v4.compiler;

import androidx.room.jarjarred.org.antlr.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedTokenException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenSource;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorManager;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class STLexer implements TokenSource {
    public static final int AND = 30;
    public static final int AT = 33;
    public static final int BANG = 10;
    public static final int COLON = 13;
    public static final int COMMA = 18;
    public static final int COMMENT = 37;
    public static final int DOT = 19;
    public static final int ELLIPSIS = 11;
    public static final int ELSE = 5;
    public static final int ELSEIF = 6;
    public static final int ENDIF = 7;
    public static final char EOF = 65535;
    public static final int EOF_TYPE = -1;
    public static final int EQUALS = 12;
    public static final int FALSE = 36;
    public static final int ID = 25;
    public static final int IF = 4;
    public static final int INDENT = 31;
    public static final int LBRACK = 16;
    public static final int LCURLY = 20;
    public static final int LDELIM = 23;
    public static final int LPAREN = 14;
    public static final int NEWLINE = 32;
    public static final int OR = 29;
    public static final int PIPE = 28;
    public static final int RBRACK = 17;
    public static final int RCURLY = 21;
    public static final int RDELIM = 24;
    public static final int REGION_END = 34;
    public static final int RPAREN = 15;
    public static final int SEMI = 9;
    public static final Token SKIP = null;
    public static final int STRING = 26;
    public static final int SUPER = 8;
    public static final int TEXT = 22;
    public static final int TRUE = 35;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    char f679c;
    char delimiterStartChar;
    char delimiterStopChar;
    ErrorManager errMgr;
    CharStream input;
    boolean scanningInsideExpr;
    int startCharIndex;
    int startCharPositionInLine;
    int startLine;
    public int subtemplateDepth;
    Token templateToken;
    List<Token> tokens;

    public static class STToken extends CommonToken {
        public STToken(CharStream r10, int r11, int r12, int r13) {
            super(r10, r11, 0, r12, r13);
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.CommonToken
        public String toString() {
            if (this.channel <= 0) goto L5;
            String r5 = ",channel=" + this.channel;
        L6:
            String r10 = getText();
            if (r10 == null) goto L9;
            String r11 = Misc.replaceEscapes(r10);
        L10:
            int r12 = this.type;
            if (r12 != (-1)) goto L13;
            String r13 = "EOF";
        L14:
            StringBuilder r14 = new StringBuilder("[@");
            r14.append(getTokenIndex());
            r14.append(",");
            r14.append(this.start);
            r14.append(":");
            a.D(r14, this.stop, "='", r11, "',<");
            androidx.constraintlayout.motion.widget.a.C(r14, r13, ">", r5, ",");
            r14.append(this.line);
            r14.append(":");
            r14.append(getCharPositionInLine());
            r14.append("]");
            return r14.toString();
        L13:
            r13 = STParser.tokenNames[r12];
            goto L14
        L9:
            r11 = "<no text>";
            goto L10
        L5:
            r5 = "";
            goto L6
        }

        public STToken(int r5, String r10) {
            super(r5, r10);
        }
    }

    static {
        SKIP = new STToken(-1, "<skip>");
    }

    public STLexer(CharStream r10) {
        this(STGroup.DEFAULT_ERR_MGR, r10, null, Typography.less, Typography.greater);
    }

    public static boolean isIDLetter(char r5) {
        if (r5 < 'a') goto L7;
        if (r5 > 'z') goto L7;
    L20:
        return true;
    L7:
        if (r5 < 'A') goto L11;
        if (r5 <= 'Z') goto L20;
    L11:
        if (r5 < '0') goto L15;
        if (r5 <= '9') goto L20;
    L15:
        if (r5 == '_') goto L20;
        if (r5 == '/') goto L20;
        return false;
    }

    public static boolean isIDStartLetter(char r5) {
        return isIDLetter(r5);
    }

    public static boolean isUnicodeLetter(char r5) {
        if (r5 < 'a') goto L7;
        if (r5 > 'f') goto L7;
    L14:
        return true;
    L7:
        if (r5 < 'A') goto L11;
        if (r5 <= 'F') goto L14;
    L11:
        if (r5 >= '0') goto L13;
    L15:
        return false;
    L13:
        if (r5 > '9') goto L15;
        goto L14
    }

    public static boolean isWS(char r5) {
        if (r5 != ' ') goto L5;
    L12:
        return true;
    L5:
        if (r5 == '\t') goto L12;
        if (r5 == '\n') goto L12;
        if (r5 == '\r') goto L12;
        return false;
    }

    public static String str(int r5) {
        if (r5 != 65535) goto L7;
        return "<EOF>";
    L7:
        return String.valueOf((char) r5);
    }

    public Token COMMENT() {
        match('!');
    L4:
        if (this.f679c != '!') goto L8;
        if (this.input.LA(2) != this.delimiterStopChar) goto L8;
    L10:
        consume();
        consume();
        return newToken(37);
    L8:
        if (this.f679c == 65535) goto L9;
        consume();
        goto L4
    L9:
        MismatchedTokenException r5 = new MismatchedTokenException(33, this.input);
        r5.line = this.input.getLine();
        r5.charPositionInLine = this.input.getCharPositionInLine();
        this.errMgr.lexerError(this.input.getSourceName(), "Nonterminated comment starting at " + this.startLine + ":" + this.startCharPositionInLine + ": '!" + this.delimiterStopChar + "' missing", this.templateToken, r5);
        goto L10
    }

    public Token ESCAPE() {
        this.startCharIndex = this.input.index();
        this.startCharPositionInLine = this.input.getCharPositionInLine();
        consume();
        char r5 = this.f679c;
        if (r5 != 'u') goto L7;
        return UNICODE();
    L7:
        if (r5 != ' ') goto L9;
        String r10 = " ";
    L21:
        consume();
        Token r11 = newToken(22, r10, this.input.getCharPositionInLine() - 2);
        match(this.delimiterStopChar);
        return r11;
    L9:
        if (r5 != '\\') goto L11;
        LINEBREAK();
        return SKIP;
    L11:
        if (r5 != 'n') goto L13;
        r10 = "\n";
        goto L21
    L13:
        if (r5 == 't') goto L16;
        NoViableAltException r12 = new NoViableAltException("", 0, 0, this.input);
        this.errMgr.lexerError(this.input.getSourceName(), "invalid escaped char: '" + str(this.f679c) + "'", this.templateToken, r12);
        consume();
        match(this.delimiterStopChar);
        return SKIP;
    L16:
        r10 = Profiler.DATA_SEP;
        goto L21
    }

    public void LINEBREAK() {
        match('\\');
        match(this.delimiterStopChar);
    L3:
        char r5 = this.f679c;
        if (r5 == ' ') goto L22;
        if (r5 == '\t') goto L22;
        if (r5 != 65535) goto L13;
        RecognitionException r10 = new RecognitionException(this.input);
        r10.line = this.input.getLine();
        r10.charPositionInLine = this.input.getCharPositionInLine();
        this.errMgr.lexerError(this.input.getSourceName(), "Missing newline after newline escape <\\\\>", this.templateToken, r10);
        return;
    L13:
        if (r5 != '\r') goto L15;
        consume();
    L15:
        match('\n');
    L16:
        char r11 = this.f679c;
        if (r11 == ' ') goto L21;
        if (r11 == '\t') goto L21;
        return;
    L21:
        consume();
    L22:
        consume();
        goto L3
    }

    public Token UNICODE() {
        consume();
        if (isUnicodeLetter(this.f679c) == true) goto L5;
        NoViableAltException r5 = new NoViableAltException("", 0, 0, this.input);
        this.errMgr.lexerError(this.input.getSourceName(), "invalid unicode char: '" + str(this.f679c) + "'", this.templateToken, r5);
    L5:
        char r10 = this.f679c;
        consume();
        if (isUnicodeLetter(this.f679c) == true) goto L8;
        NoViableAltException r11 = new NoViableAltException("", 0, 0, this.input);
        this.errMgr.lexerError(this.input.getSourceName(), "invalid unicode char: '" + str(this.f679c) + "'", this.templateToken, r11);
    L8:
        char r12 = this.f679c;
        consume();
        if (isUnicodeLetter(this.f679c) == true) goto L11;
        NoViableAltException r13 = new NoViableAltException("", 0, 0, this.input);
        this.errMgr.lexerError(this.input.getSourceName(), "invalid unicode char: '" + str(this.f679c) + "'", this.templateToken, r13);
    L11:
        char r14 = this.f679c;
        consume();
        if (isUnicodeLetter(this.f679c) == true) goto L14;
        NoViableAltException r15 = new NoViableAltException("", 0, 0, this.input);
        this.errMgr.lexerError(this.input.getSourceName(), "invalid unicode char: '" + str(this.f679c) + "'", this.templateToken, r15);
    L14:
        Token r16 = newToken(22, String.valueOf((char) Integer.parseInt(new String(new char[]{r10, r12, r14, this.f679c}), 16)), this.input.getCharPositionInLine() - 6);
        consume();
        match(this.delimiterStopChar);
        return r16;
    }

    public void WS() {
    L2:
        char r5 = this.f679c;
        if (r5 == ' ') goto L12;
        if (r5 == '\t') goto L12;
        if (r5 == '\n') goto L12;
        if (r5 == '\r') goto L12;
        return;
    L12:
        consume();
        goto L2
    }

    public Token _nextToken() {
    L2:
        this.startCharIndex = this.input.index();
        this.startLine = this.input.getLine();
        this.startCharPositionInLine = this.input.getCharPositionInLine();
        if (this.f679c == 65535) goto L5;
        if (this.scanningInsideExpr == false) goto L9;
        Token r5 = inside();
    L11:
        if (r5 == SKIP) goto L2;
        return r5;
    L9:
        r5 = outside();
        goto L11
    L5:
        return newToken(-1);
    }

    public void consume() {
        this.input.consume();
        this.f679c = (char) this.input.LA(1);
    }

    public void emit(Token r5) {
        this.tokens.add(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenSource
    public String getSourceName() {
        return "no idea";
    }

    public Token inside() {
    L2:
        char r5 = this.f679c;
        if (r5 == '\t') goto L119;
        if (r5 == '\n') goto L119;
        if (r5 == '\r') goto L119;
        if (r5 == '&') goto L117;
        if (r5 == ',') goto L115;
        if (r5 == '.') goto L107;
        if (r5 == '=') goto L105;
        if (r5 == '@') goto L95;
        if (r5 == '[') goto L93;
        if (r5 == ']') goto L91;
        if (r5 == '(') goto L89;
        if (r5 == ')') goto L87;
        if (r5 == ':') goto L85;
        if (r5 == ';') goto L83;
        if (r5 == '{') goto L82;
        if (r5 == '|') goto L79;
        switch(r5) {
            case 32: goto L119;
            case 33: goto L77;
            case 34: goto L76;
            default: goto L36;
        };
    L36:
        if (r5 == this.delimiterStopChar) goto L37;
        if (isIDStartLetter(r5) == true) goto L41;
        NoViableAltException r10 = new NoViableAltException("", 0, 0, this.input);
        r10.line = this.startLine;
        r10.charPositionInLine = this.startCharPositionInLine;
        this.errMgr.lexerError(this.input.getSourceName(), "invalid character '" + str(this.f679c) + "'", this.templateToken, r10);
        if (this.f679c == 65535) goto L73;
        consume();
        goto L2
    L73:
        return newToken(-1);
    L41:
        Token r11 = mID();
        String r12 = r11.getText();
        if (r12.equals("if") == false) goto L46;
        return newToken(4);
    L46:
        if (r12.equals("endif") == false) goto L50;
        return newToken(7);
    L50:
        if (r12.equals("else") == false) goto L54;
        return newToken(5);
    L54:
        if (r12.equals("elseif") == false) goto L58;
        return newToken(6);
    L58:
        if (r12.equals("super") == false) goto L62;
        return newToken(8);
    L62:
        if (r12.equals("true") == false) goto L66;
        return newToken(35);
    L66:
        if (r12.equals("false") == true) goto L68;
        return r11;
    L68:
        return newToken(36);
    L37:
        consume();
        this.scanningInsideExpr = false;
        return newToken(24);
    L76:
        return mSTRING();
    L77:
        consume();
        return newToken(10);
    L79:
        consume();
        match('|');
        return newToken(29);
    L82:
        return subTemplate();
    L83:
        consume();
        return newToken(9);
    L85:
        consume();
        return newToken(13);
    L87:
        consume();
        return newToken(15);
    L89:
        consume();
        return newToken(14);
    L91:
        consume();
        return newToken(17);
    L93:
        consume();
        return newToken(16);
    L95:
        consume();
        if (this.f679c != 'e') goto L104;
        if (this.input.LA(2) != 110) goto L104;
        if (this.input.LA(3) != 100) goto L104;
        consume();
        consume();
        consume();
        return newToken(34);
    L104:
        return newToken(33);
    L105:
        consume();
        return newToken(12);
    L107:
        consume();
        if (this.input.LA(1) != 46) goto L114;
        if (this.input.LA(2) != 46) goto L114;
        consume();
        match('.');
        return newToken(11);
    L114:
        return newToken(19);
    L115:
        consume();
        return newToken(18);
    L117:
        consume();
        match(Typography.amp);
        return newToken(30);
    L119:
        consume();
        return SKIP;
    }

    public Token mID() {
        this.startCharIndex = this.input.index();
        this.startLine = this.input.getLine();
        this.startCharPositionInLine = this.input.getCharPositionInLine();
        consume();
    L4:
        if (isIDLetter(this.f679c) == false) goto L7;
        consume();
        goto L4
    L7:
        return newToken(25);
    }

    public Token mSTRING() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.f679c);
        consume();
        boolean r10 = false;
    L3:
        char r11 = this.f679c;
        if (r11 == '\"') goto L21;
        if (r11 == '\\') goto L7;
        r5.append(r11);
        consume();
        if (this.f679c != 65535) goto L3;
        MismatchedTokenException r12 = new MismatchedTokenException(34, this.input);
        r12.line = this.input.getLine();
        r12.charPositionInLine = this.input.getCharPositionInLine();
        this.errMgr.lexerError(this.input.getSourceName(), "EOF in string", this.templateToken, r12);
        goto L21
    L7:
        consume();
        char r13 = this.f679c;
        if (r13 != 'n') goto L10;
        r5.append('\n');
    L17:
        consume();
        r10 = true;
        goto L3
    L10:
        if (r13 != 'r') goto L12;
        r5.append('\r');
        goto L17
    L12:
        if (r13 == 't') goto L14;
        r5.append(r13);
        goto L17
    L14:
        r5.append('\t');
    L21:
        r5.append(this.f679c);
        consume();
        if (r10 == false) goto L26;
        return newToken(26, r5.toString());
    L26:
        return newToken(26);
    }

    public Token mTEXT() {
        StringBuilder r5 = new StringBuilder();
        boolean r10 = false;
    L3:
        char r11 = this.f679c;
        if (r11 == 65535) goto L32;
        if (r11 == this.delimiterStartChar) goto L32;
        if (r11 == '\r') goto L32;
        if (r11 == '\n') goto L32;
        if (r11 != '}') goto L18;
        if (this.subtemplateDepth > 0) goto L32;
    L18:
        if (r11 == '\\') goto L20;
        r5.append(r11);
        consume();
        goto L3
    L20:
        if (this.input.LA(2) == 92) goto L21;
        if (this.input.LA(2) == this.delimiterStartChar) goto L29;
        if (this.input.LA(2) == 125) goto L29;
        r5.append(this.f679c);
        consume();
    L29:
        consume();
        r5.append(this.f679c);
        consume();
    L22:
        r10 = true;
        goto L3
    L21:
        consume();
        consume();
        r5.append('\\');
    L32:
        if (r10 == false) goto L36;
        return newToken(22, r5.toString());
    L36:
        return newToken(22);
    }

    public void match(char r10) {
        if (this.f679c == r10) goto L5;
        NoViableAltException r5 = new NoViableAltException("", 0, 0, this.input);
        this.errMgr.lexerError(this.input.getSourceName(), "expecting '" + r10 + "', found '" + str(this.f679c) + "'", this.templateToken, r5);
    L5:
        consume();
    }

    public Token newToken(int r5) {
        CharStream r10 = this.input;
        STToken r11 = new STToken(r10, r5, this.startCharIndex, r10.index() - 1);
        r11.setLine(this.startLine);
        r11.setCharPositionInLine(this.startCharPositionInLine);
        return r11;
    }

    public Token newTokenFromPreviousChar(int r5) {
        CharStream r10 = this.input;
        STToken r11 = new STToken(r10, r5, r10.index() - 1, this.input.index() - 1);
        r11.setLine(this.input.getLine());
        r11.setCharPositionInLine(this.input.getCharPositionInLine() - 1);
        return r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.TokenSource
    public Token nextToken() {
        if (this.tokens.size() <= 0) goto L6;
        return this.tokens.remove(0);
    L6:
        return _nextToken();
    }

    public Token outside() {
        if (this.input.getCharPositionInLine() != 0) goto L18;
        char r5 = this.f679c;
        if (r5 == ' ') goto L7;
        if (r5 != '\t') goto L18;
    L7:
        char r10 = this.f679c;
        if (r10 == ' ') goto L17;
        if (r10 == '\t') goto L17;
        if (r10 == 65535) goto L16;
        return newToken(31);
    L16:
        return newToken(22);
    L17:
        consume();
    L18:
        char r11 = this.f679c;
        if (r11 != this.delimiterStartChar) goto L31;
        consume();
        char r12 = this.f679c;
        if (r12 != '!') goto L25;
        return COMMENT();
    L25:
        if (r12 == '\\') goto L27;
        this.scanningInsideExpr = true;
        return newToken(23);
    L27:
        return ESCAPE();
    L31:
        if (r11 != '\r') goto L35;
        consume();
        consume();
        return newToken(32);
    L35:
        if (r11 != '\n') goto L39;
        consume();
        return newToken(32);
    L39:
        if (r11 != '}') goto L45;
        int r13 = this.subtemplateDepth;
        if (r13 <= 0) goto L45;
        this.scanningInsideExpr = true;
        this.subtemplateDepth = r13 - 1;
        consume();
        return newTokenFromPreviousChar(21);
    L45:
        return mTEXT();
    }

    public Token subTemplate() {
        this.subtemplateDepth++;
        int r5 = this.input.mark();
        int r10 = this.startCharIndex;
        int r11 = this.startLine;
        int r12 = this.startCharPositionInLine;
        ArrayList r13 = new ArrayList();
        consume();
        Token r14 = newTokenFromPreviousChar(20);
        WS();
        r13.add(mID());
        WS();
    L4:
        if (this.f679c != ',') goto L6;
        consume();
        r13.add(newTokenFromPreviousChar(18));
        WS();
        r13.add(mID());
        WS();
        goto L4
    L6:
        WS();
        if (this.f679c != '|') goto L17;
        consume();
        r13.add(newTokenFromPreviousChar(28));
        if (isWS(this.f679c) == false) goto L11;
        consume();
    L11:
        Iterator r15 = r13.iterator();
    L13:
        if (r15.hasNext() == false) goto L15;
        emit((Token) r15.next());
        goto L13
    L15:
        this.input.release(r5);
        this.scanningInsideExpr = false;
        this.startCharIndex = r10;
        this.startLine = r11;
        this.startCharPositionInLine = r12;
        return r14;
    L17:
        this.input.rewind(r5);
        this.startCharIndex = r10;
        this.startLine = r11;
        this.startCharPositionInLine = r12;
        consume();
        this.scanningInsideExpr = false;
        return r14;
    }

    public STLexer(ErrorManager r10, CharStream r11, Token r12) {
        this(r10, r11, r12, Typography.less, Typography.greater);
    }

    public STLexer(ErrorManager r5, CharStream r10, Token r11, char r12, char r13) {
        this.delimiterStartChar = Typography.less;
        this.delimiterStopChar = Typography.greater;
        this.scanningInsideExpr = false;
        this.subtemplateDepth = 0;
        this.tokens = new ArrayList();
        this.errMgr = r5;
        this.input = r10;
        this.f679c = (char) r10.LA(1);
        this.templateToken = r11;
        this.delimiterStartChar = r12;
        this.delimiterStopChar = r13;
    }

    public Token newToken(int r5, String r10, int r11) {
        STToken r12 = new STToken(r5, r10);
        r12.setStartIndex(this.startCharIndex);
        r12.setStopIndex(this.input.index() - 1);
        r12.setLine(this.input.getLine());
        r12.setCharPositionInLine(r11);
        return r12;
    }

    public Token newToken(int r5, String r10) {
        STToken r11 = new STToken(r5, r10);
        r11.setStartIndex(this.startCharIndex);
        r11.setStopIndex(this.input.index() - 1);
        r11.setLine(this.startLine);
        r11.setCharPositionInLine(this.startCharPositionInLine);
        return r11;
    }
}
