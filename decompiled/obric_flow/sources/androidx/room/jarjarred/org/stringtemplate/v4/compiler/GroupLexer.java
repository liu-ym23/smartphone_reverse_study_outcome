package androidx.room.jarjarred.org.stringtemplate.v4.compiler;

import androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer;
import androidx.room.jarjarred.org.antlr.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.DFA;
import androidx.room.jarjarred.org.antlr.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedSetException;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedTokenException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorType;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class GroupLexer extends Lexer {
    public static final int ANONYMOUS_TEMPLATE = 4;
    public static final int BIGSTRING = 5;
    public static final int BIGSTRING_NO_NL = 6;
    public static final int COMMENT = 7;
    static final short[] DFA8_accept = null;
    static final String DFA8_acceptS = "\u0002\uffff\u0001\u0002\u0001\u0003\u0001\uffff\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\uffff\u0001\u000b\u0001\f\u0001\r\u0003\uffff\u0001\u0013\u0001\u0014\u0001\uffff\u0001\u0017\u0001\uffff\u0001\u001a\u0002\uffff\u0001\n\u0001\t\u0003\uffff\u0001\u0015\u0001\u0016\u0001\u0018\u0001\u0019\u000e\uffff\u0001\u0004\u0005\uffff\u0001\u0001\u0002\uffff\u0001\u0010\u0005\uffff\u0001\u0012\u0001\u000e\u0006\uffff\u0001\u000f\u0001\u0011";
    static final short[] DFA8_eof = null;
    static final String DFA8_eofS = "H\uffff";
    static final short[] DFA8_eot = null;
    static final String DFA8_eotS = "\u0001\uffff\u0001\u0010\u0002\uffff\u0001\u0010\u0004\uffff\u0001\u0019\u0003\uffff\u0003\u0010\u0006\uffff\u0002\u0010\u0002\uffff\u0003\u0010\u0004\uffff\u0007\u0010\u0001/\u0005\u0010\u00015\u0001\uffff\u0002\u0010\u00018\u0002\u0010\u0001\uffff\u0002\u0010\u0001\uffff\u0001\u0010\u0001>\u0001?\u0002\u0010\u0002\uffff\u0004\u0010\u0001F\u0001G\u0002\uffff";
    static final char[] DFA8_max = null;
    static final String DFA8_maxS = "\u0001{\u0001a\u0002\uffff\u0001r\u0004\uffff\u0001:\u0003\uffff\u0001e\u0001r\u0001m\u0002\uffff\u0001<\u0001\uffff\u0001/\u0001\uffff\u0001l\u0001u\u0002\uffff\u0001l\u0001o\u0001p\u0004\uffff\u0001s\u0001e\u0001a\u0001i\u0001u\u0001o\u0001e\u0001z\u0001u\u0001m\u0001p\u0001e\u0001r\u0001z\u0001\uffff\u0001l\u0001i\u0001z\u0001m\u0001t\u0001\uffff\u0002t\u0001\uffff\u0001e\u0002z\u0001e\u0001n\u0002\uffff\u0001r\u0001t\u0002s\u0002z\u0002\uffff";
    static final char[] DFA8_min = null;
    static final String DFA8_minS = "\u0001\t\u0001a\u0002\uffff\u0001r\u0004\uffff\u0001:\u0003\uffff\u0001e\u0001r\u0001m\u0002\uffff\u0001%\u0001\uffff\u0001*\u0001\uffff\u0001l\u0001u\u0002\uffff\u0001f\u0001o\u0001p\u0004\uffff\u0001s\u0001e\u0001a\u0001i\u0001u\u0001l\u0001e\u0001-\u0001u\u0001m\u0001p\u0001e\u0001r\u0001-\u0001\uffff\u0001l\u0001i\u0001-\u0001m\u0001t\u0001\uffff\u0002t\u0001\uffff\u0001e\u0002-\u0001e\u0001n\u0002\uffff\u0001r\u0001t\u0002s\u0002-\u0002\uffff";
    static final short[] DFA8_special = null;
    static final String DFA8_specialS = "H\uffff}>";
    static final short[][] DFA8_transition = null;
    static final String[] DFA8_transitionS = null;
    public static final int EOF = -1;
    public static final int FALSE = 8;
    public static final int ID = 9;
    public static final int LBRACK = 10;
    public static final int LINE_COMMENT = 11;
    public static final int RBRACK = 12;
    public static final int STRING = 13;
    public static final int TRUE = 14;
    public static final int T__16 = 16;
    public static final int T__17 = 17;
    public static final int T__18 = 18;
    public static final int T__19 = 19;
    public static final int T__20 = 20;
    public static final int T__21 = 21;
    public static final int T__22 = 22;
    public static final int T__23 = 23;
    public static final int T__24 = 24;
    public static final int T__25 = 25;
    public static final int T__26 = 26;
    public static final int T__27 = 27;
    public static final int T__28 = 28;
    public static final int T__29 = 29;
    public static final int WS = 15;
    protected DFA8 dfa8;
    public STGroup group;

    public class DFA8 extends DFA {
        final /* synthetic */ GroupLexer this$0;

        public DFA8(GroupLexer r5, BaseRecognizer r10) {
            this.this$0 = r5;
            this.recognizer = r10;
            this.decisionNumber = 8;
            this.eot = GroupLexer.DFA8_eot;
            this.eof = GroupLexer.DFA8_eof;
            this.min = GroupLexer.DFA8_min;
            this.max = GroupLexer.DFA8_max;
            this.accept = GroupLexer.DFA8_accept;
            this.special = GroupLexer.DFA8_special;
            this.transition = GroupLexer.DFA8_transition;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.DFA
        public String getDescription() {
            return "1:1: Tokens : ( FALSE | LBRACK | RBRACK | TRUE | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | ID | STRING | BIGSTRING_NO_NL | BIGSTRING | ANONYMOUS_TEMPLATE | COMMENT | LINE_COMMENT | WS );";
        }
    }

    static {
        String[] r5 = {"\u0002\u0015\u0002\uffff\u0001\u0015\u0012\uffff\u0001\u0015\u0001\uffff\u0001\u0011\u0005\uffff\u0001\u0005\u0001\u0006\u0002\uffff\u0001\u0007\u0001\uffff\u0001\b\u0001\u0014\n\uffff\u0001\t\u0001\n\u0001\u0012\u0001\u000b\u0002\uffff\u0001\f\u001a\u0010\u0001\u0002\u0001\uffff\u0001\u0003\u0001\uffff\u0001\u0010\u0001\uffff\u0003\u0010\u0001\r\u0001\u0010\u0001\u0001\u0001\u000e\u0001\u0010\u0001\u000f\n\u0010\u0001\u0004\u0006\u0010\u0001\u0013", "\u0001\u0016", "", "", "\u0001\u0017", "", "", "", "", "\u0001\u0018", "", "", "", "\u0001\u001a", "\u0001\u001b", "\u0001\u001c", "", "", "\u0001\u001d\u0016\uffff\u0001\u001e", "", "\u0001\u001f\u0004\uffff\u0001 ", "", "\u0001!", "\u0001\"", "", "", "\u0001#\u0005\uffff\u0001$", "\u0001%", "\u0001&", "", "", "", "", "\u0001'", "\u0001(", "\u0001)", "\u0001*", "\u0001+", "\u0001,\u0002\uffff\u0001-", "\u0001.", "\u0001\u0010\u0002\uffff\n\u0010\u0007\uffff\u001a\u0010\u0004\uffff\u0001\u0010\u0001\uffff\u001a\u0010", "\u00010", "\u00011", "\u00012", "\u00013", "\u00014", "\u0001\u0010\u0002\uffff\n\u0010\u0007\uffff\u001a\u0010\u0004\uffff\u0001\u0010\u0001\uffff\u001a\u0010", "", "\u00016", "\u00017", "\u0001\u0010\u0002\uffff\n\u0010\u0007\uffff\u001a\u0010\u0004\uffff\u0001\u0010\u0001\uffff\u001a\u0010", "\u00019", "\u0001:", "", "\u0001;", "\u0001<", "", "\u0001=", "\u0001\u0010\u0002\uffff\n\u0010\u0007\uffff\u001a\u0010\u0004\uffff\u0001\u0010\u0001\uffff\u001a\u0010", "\u0001\u0010\u0002\uffff\n\u0010\u0007\uffff\u001a\u0010\u0004\uffff\u0001\u0010\u0001\uffff\u001a\u0010", "\u0001@", "\u0001A", "", "", "\u0001B", "\u0001C", "\u0001D", "\u0001E", "\u0001\u0010\u0002\uffff\n\u0010\u0007\uffff\u001a\u0010\u0004\uffff\u0001\u0010\u0001\uffff\u001a\u0010", "\u0001\u0010\u0002\uffff\n\u0010\u0007\uffff\u001a\u0010\u0004\uffff\u0001\u0010\u0001\uffff\u001a\u0010", "", ""};
        DFA8_transitionS = r5;
        DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
        DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
        DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
        DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
        DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
        DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
        int r10 = r5.length;
        DFA8_transition = new short[r10][];
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        DFA8_transition[r11] = DFA.unpackEncodedString(DFA8_transitionS[r11]);
        r11 = r11 + 1;
        goto L3
    }

    public GroupLexer() {
        this.dfa8 = new DFA8(this, this);
    }

    public Lexer[] getDelegates() {
        return new Lexer[0];
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getGrammarFileName() {
        return "org\\stringtemplate\\v4\\compiler\\Group.g";
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Lexer, androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer, androidx.room.jarjarred.org.antlr.runtime.TokenSource
    public String getSourceName() {
        return new File(super.getSourceName()).getName();
    }

    public final void mANONYMOUS_TEMPLATE() throws RecognitionException {
        match(123);
        CommonToken r5 = new CommonToken(this.input, 4, 0, getCharIndex(), getCharIndex());
        STGroup r10 = this.group;
        STLexer r11 = new STLexer(r10.errMgr, this.input, r5, r10.delimiterStartChar, r10.delimiterStopChar);
        r11.subtemplateDepth = 1;
        Token r12 = r11.nextToken();
    L4:
        if (r11.subtemplateDepth >= 1) goto L8;
        if (r12.getType() != 21) goto L8;
    L10:
        RecognizerSharedState r13 = this.state;
        r13.type = 4;
        r13.channel = 0;
        return;
    L8:
        if (r12.getType() == (-1)) goto L9;
        r12 = r11.nextToken();
        goto L4
    L9:
        MismatchedTokenException r14 = new MismatchedTokenException(125, this.input);
        this.group.errMgr.groupLexerError(ErrorType.SYNTAX_ERROR, getSourceName(), r14, "missing final '}' in {...} anonymous template");
        goto L10
    }

    public final void mBIGSTRING() throws RecognitionException {
        match("<<");
    L3:
        int r5 = this.input.LA(1);
        char r10 = 4;
        if (r5 != 62) goto L13;
        int r11 = this.input.LA(2);
        if (r11 == 62) goto L29;
        if (r11 < 0) goto L10;
        if (r11 > 61) goto L10;
    L28:
        r10 = 3;
    L10:
        if (r11 < 63) goto L29;
        if (r11 <= 65535) goto L28;
    L29:
        if (r10 != 1) goto L31;
        match(92);
        match(62);
        goto L3
    L31:
        if (r10 != 2) goto L32;
        match(92);
        if (this.input.LA(1) < 0) goto L51;
        if (this.input.LA(1) > 61) goto L51;
    L54:
        this.input.consume();
    L51:
        if (this.input.LA(1) < 63) goto L55;
        if (this.input.LA(1) <= 65535) goto L54;
    L55:
        MismatchedSetException r12 = new MismatchedSetException(null, this.input);
        recover(r12);
        throw r12;
    L32:
        if (r10 != 3) goto L33;
        if (this.input.LA(1) < 0) goto L40;
        if (this.input.LA(1) > 91) goto L40;
    L43:
        this.input.consume();
    L40:
        if (this.input.LA(1) < 93) goto L44;
        if (this.input.LA(1) <= 65535) goto L43;
    L44:
        MismatchedSetException r13 = new MismatchedSetException(null, this.input);
        recover(r13);
        throw r13;
    L33:
        match(">>");
        setText(Misc.replaceEscapedRightAngle(getText()));
        RecognizerSharedState r14 = this.state;
        r14.type = 5;
        r14.channel = 0;
        return;
    L13:
        if (r5 != 92) goto L22;
        int r15 = this.input.LA(2);
        if (r15 != 62) goto L17;
        r10 = 1;
        goto L29
    L17:
        if (r15 < 0) goto L19;
        if (r15 > 61) goto L19;
    L21:
        r10 = 2;
    L19:
        if (r15 < 63) goto L29;
        if (r15 > 65535) goto L29;
    L22:
        if (r5 < 0) goto L24;
        if (r5 <= 61) goto L28;
    L24:
        if (r5 < 63) goto L26;
        if (r5 <= 91) goto L28;
    L26:
        if (r5 < 93) goto L29;
        if (r5 > 65535) goto L29;
        goto L28
    }

    public final void mBIGSTRING_NO_NL() throws RecognitionException {
        match("<%");
    L3:
        int r5 = this.input.LA(1);
        if (r5 != 37) goto L15;
        int r10 = this.input.LA(2);
        if (r10 == 62) goto L22;
        if (r10 < 0) goto L12;
        if (r10 > 61) goto L12;
    L21:
        matchAny();
    L12:
        if (r10 < 63) goto L22;
        if (r10 <= 65535) goto L21;
    L22:
        match("%>");
        setText(getText().replaceAll("%\\\\>", "%>"));
        RecognizerSharedState r11 = this.state;
        r11.type = 6;
        r11.channel = 0;
        return;
    L15:
        if (r5 < 0) goto L19;
        if (r5 <= 36) goto L21;
    L19:
        if (r5 < 38) goto L22;
        if (r5 > 65535) goto L22;
        goto L22
    }

    public final void mCOMMENT() throws RecognitionException {
        match("/*");
    L3:
        int r5 = this.input.LA(1);
        if (r5 != 42) goto L15;
        int r10 = this.input.LA(2);
        if (r10 == 47) goto L22;
        if (r10 < 0) goto L12;
        if (r10 > 46) goto L12;
    L21:
        matchAny();
    L12:
        if (r10 < 48) goto L22;
        if (r10 <= 65535) goto L21;
    L22:
        match("*/");
        skip();
        RecognizerSharedState r11 = this.state;
        r11.type = 7;
        r11.channel = 0;
        return;
    L15:
        if (r5 < 0) goto L19;
        if (r5 <= 41) goto L21;
    L19:
        if (r5 < 43) goto L22;
        if (r5 > 65535) goto L22;
        goto L22
    }

    public final void mFALSE() throws RecognitionException {
        match("false");
        RecognizerSharedState r5 = this.state;
        r5.type = 8;
        r5.channel = 0;
    }

    public final void mID() throws RecognitionException {
        if (this.input.LA(1) < 65) goto L7;
        if (this.input.LA(1) > 90) goto L7;
    L15:
        this.input.consume();
    L16:
        int r5 = this.input.LA(1);
        if (r5 == 45) goto L29;
        if (r5 < 48) goto L20;
        if (r5 <= 57) goto L29;
    L20:
        if (r5 < 65) goto L22;
        if (r5 <= 90) goto L29;
    L22:
        if (r5 == 95) goto L29;
        if (r5 < 97) goto L26;
        if (r5 <= 122) goto L29;
    L26:
        RecognizerSharedState r11 = this.state;
        r11.type = 9;
        r11.channel = 0;
        return;
    L29:
        if (this.input.LA(1) == 45) goto L47;
        if (this.input.LA(1) < 48) goto L35;
        if (this.input.LA(1) <= 57) goto L47;
    L35:
        if (this.input.LA(1) < 65) goto L39;
        if (this.input.LA(1) <= 90) goto L47;
    L39:
        if (this.input.LA(1) == 95) goto L47;
        if (this.input.LA(1) < 97) goto L45;
        if (this.input.LA(1) <= 122) goto L47;
    L45:
        MismatchedSetException r10 = new MismatchedSetException(null, this.input);
        recover(r10);
        throw r10;
    L47:
        this.input.consume();
    L7:
        if (this.input.LA(1) == 95) goto L15;
        if (this.input.LA(1) >= 97) goto L11;
    L13:
        MismatchedSetException r12 = new MismatchedSetException(null, this.input);
        recover(r12);
        throw r12;
    L11:
        if (this.input.LA(1) > 122) goto L13;
        goto L13
    }

    public final void mLBRACK() throws RecognitionException {
        match(91);
        RecognizerSharedState r5 = this.state;
        r5.type = 10;
        r5.channel = 0;
    }

    public final void mLINE_COMMENT() throws RecognitionException {
        match("//");
    L3:
        int r5 = this.input.LA(1);
        if (r5 < 0) goto L6;
        if (r5 > 9) goto L6;
    L11:
        if (this.input.LA(1) < 0) goto L15;
        if (this.input.LA(1) > 9) goto L15;
    L22:
        this.input.consume();
    L15:
        if (this.input.LA(1) < 11) goto L19;
        if (this.input.LA(1) <= 12) goto L22;
    L19:
        if (this.input.LA(1) < 14) goto L23;
        if (this.input.LA(1) <= 65535) goto L22;
    L23:
        MismatchedSetException r10 = new MismatchedSetException(null, this.input);
        recover(r10);
        throw r10;
    L6:
        if (r5 < 11) goto L8;
        if (r5 <= 12) goto L11;
    L8:
        if (r5 < 14) goto L26;
        if (r5 <= 65535) goto L11;
    L26:
        if (this.input.LA(1) != 13) goto L28;
        match(13);
    L28:
        match(10);
        skip();
        RecognizerSharedState r11 = this.state;
        r11.type = 11;
        r11.channel = 0;
    }

    public final void mRBRACK() throws RecognitionException {
        match(93);
        RecognizerSharedState r5 = this.state;
        r5.type = 12;
        r5.channel = 0;
    }

    public final void mSTRING() throws RecognitionException {
        match(34);
    L3:
        int r5 = this.input.LA(1);
        char r16 = 5;
        if (r5 != 92) goto L14;
        int r10 = this.input.LA(2);
        if (r10 != 34) goto L8;
        r16 = 1;
    L13:
        char r11 = r16;
    L25:
        if (r11 != 1) goto L27;
        match(92);
        match(34);
        goto L3
    L27:
        if (r11 != 2) goto L29;
        match(92);
        if (this.input.LA(1) < 0) goto L58;
        if (this.input.LA(1) > 33) goto L58;
    L61:
        this.input.consume();
    L58:
        if (this.input.LA(1) < 35) goto L62;
        if (this.input.LA(1) <= 65535) goto L61;
    L62:
        MismatchedSetException r12 = new MismatchedSetException(null, this.input);
        recover(r12);
        throw r12;
    L29:
        if (r11 != 3) goto L30;
        this.group.errMgr.groupLexerError(ErrorType.SYNTAX_ERROR, getSourceName(), new NoViableAltException("", 0, 0, this.input), "\\n in string");
        match(10);
        goto L3
    L30:
        if (r11 != 4) goto L31;
        if (this.input.LA(1) < 0) goto L38;
        if (this.input.LA(1) > 9) goto L38;
    L49:
        this.input.consume();
    L38:
        if (this.input.LA(1) < 11) goto L42;
        if (this.input.LA(1) <= 33) goto L49;
    L42:
        if (this.input.LA(1) < 35) goto L46;
        if (this.input.LA(1) <= 91) goto L49;
    L46:
        if (this.input.LA(1) < 93) goto L50;
        if (this.input.LA(1) <= 65535) goto L49;
    L50:
        MismatchedSetException r13 = new MismatchedSetException(null, this.input);
        recover(r13);
        throw r13;
    L31:
        match(34);
        setText(getText().replaceAll("\\\\\"", "\""));
        RecognizerSharedState r14 = this.state;
        r14.type = 13;
        r14.channel = 0;
        return;
    L8:
        if (r10 < 0) goto L10;
        if (r10 > 33) goto L10;
    L12:
        r16 = 2;
    L10:
        if (r10 < 35) goto L13;
        if (r10 > 65535) goto L13;
    L14:
        if (r5 != 10) goto L16;
        r11 = 3;
        goto L25
    L16:
        if (r5 < 0) goto L18;
        if (r5 > 9) goto L18;
    L24:
        r11 = 4;
    L18:
        if (r5 < 11) goto L20;
        if (r5 <= 33) goto L24;
    L20:
        if (r5 < 35) goto L22;
        if (r5 <= 91) goto L24;
    L22:
        if (r5 < 93) goto L13;
        if (r5 > 65535) goto L13;
        goto L13
    }

    public final void mTRUE() throws RecognitionException {
        match("true");
        RecognizerSharedState r5 = this.state;
        r5.type = 14;
        r5.channel = 0;
    }

    public final void mT__16() throws RecognitionException {
        match(40);
        RecognizerSharedState r5 = this.state;
        r5.type = 16;
        r5.channel = 0;
    }

    public final void mT__17() throws RecognitionException {
        match(41);
        RecognizerSharedState r5 = this.state;
        r5.type = 17;
        r5.channel = 0;
    }

    public final void mT__18() throws RecognitionException {
        match(44);
        RecognizerSharedState r5 = this.state;
        r5.type = 18;
        r5.channel = 0;
    }

    public final void mT__19() throws RecognitionException {
        match(46);
        RecognizerSharedState r5 = this.state;
        r5.type = 19;
        r5.channel = 0;
    }

    public final void mT__20() throws RecognitionException {
        match(58);
        RecognizerSharedState r5 = this.state;
        r5.type = 20;
        r5.channel = 0;
    }

    public final void mT__21() throws RecognitionException {
        match("::=");
        RecognizerSharedState r5 = this.state;
        r5.type = 21;
        r5.channel = 0;
    }

    public final void mT__22() throws RecognitionException {
        match(59);
        RecognizerSharedState r5 = this.state;
        r5.type = 22;
        r5.channel = 0;
    }

    public final void mT__23() throws RecognitionException {
        match(61);
        RecognizerSharedState r5 = this.state;
        r5.type = 23;
        r5.channel = 0;
    }

    public final void mT__24() throws RecognitionException {
        match(64);
        RecognizerSharedState r5 = this.state;
        r5.type = 24;
        r5.channel = 0;
    }

    public final void mT__25() throws RecognitionException {
        match("default");
        RecognizerSharedState r5 = this.state;
        r5.type = 25;
        r5.channel = 0;
    }

    public final void mT__26() throws RecognitionException {
        match("delimiters");
        RecognizerSharedState r5 = this.state;
        r5.type = 26;
        r5.channel = 0;
    }

    public final void mT__27() throws RecognitionException {
        match("group");
        RecognizerSharedState r5 = this.state;
        r5.type = 27;
        r5.channel = 0;
    }

    public final void mT__28() throws RecognitionException {
        match("implements");
        RecognizerSharedState r5 = this.state;
        r5.type = 28;
        r5.channel = 0;
    }

    public final void mT__29() throws RecognitionException {
        match("import");
        RecognizerSharedState r5 = this.state;
        r5.type = 29;
        r5.channel = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Lexer
    public void mTokens() throws RecognitionException {
        switch(this.dfa8.predict(this.input)) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L18;
            case 14: goto L17;
            case 15: goto L16;
            case 16: goto L15;
            case 17: goto L14;
            case 18: goto L13;
            case 19: goto L12;
            case 20: goto L11;
            case 21: goto L10;
            case 22: goto L9;
            case 23: goto L8;
            case 24: goto L7;
            case 25: goto L6;
            case 26: goto L5;
            default: goto L57;
        };
    L5:
        mWS();
        return;
    L6:
        mLINE_COMMENT();
        return;
    L7:
        mCOMMENT();
        return;
    L8:
        mANONYMOUS_TEMPLATE();
        return;
    L9:
        mBIGSTRING();
        return;
    L10:
        mBIGSTRING_NO_NL();
        return;
    L11:
        mSTRING();
        return;
    L12:
        mID();
        return;
    L13:
        mT__29();
        return;
    L14:
        mT__28();
        return;
    L15:
        mT__27();
        return;
    L16:
        mT__26();
        return;
    L17:
        mT__25();
        return;
    L18:
        mT__24();
        return;
    L19:
        mT__23();
        return;
    L20:
        mT__22();
        return;
    L21:
        mT__21();
        return;
    L22:
        mT__20();
        return;
    L23:
        mT__19();
        return;
    L24:
        mT__18();
        return;
    L25:
        mT__17();
        return;
    L26:
        mT__16();
        return;
    L27:
        mTRUE();
        return;
    L28:
        mRBRACK();
        return;
    L29:
        mLBRACK();
        return;
    L30:
        mFALSE();
        return;
    }

    public final void mWS() throws RecognitionException {
        if (this.input.LA(1) < 9) goto L7;
        if (this.input.LA(1) > 10) goto L7;
    L13:
        this.input.consume();
        skip();
        RecognizerSharedState r5 = this.state;
        r5.type = 15;
        r5.channel = 0;
        return;
    L7:
        if (this.input.LA(1) == 13) goto L13;
        if (this.input.LA(1) == 32) goto L13;
        MismatchedSetException r10 = new MismatchedSetException(null, this.input);
        recover(r10);
        throw r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Lexer, androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void reportError(RecognitionException r5) {
        if ((r5 instanceof NoViableAltException) == false) goto L6;
        String r10 = "invalid character '" + ((char) this.input.LA(1)) + "'";
    L11:
        this.group.errMgr.groupSyntaxError(ErrorType.SYNTAX_ERROR, getSourceName(), r5, r10);
        return;
    L6:
        if ((r5 instanceof MismatchedTokenException) == true) goto L8;
    L10:
        r10 = getErrorMessage(r5, getTokenNames());
        goto L11
    L8:
        if (((MismatchedTokenException) r5).expecting != 34) goto L10;
        r10 = "unterminated string";
        goto L11
    }

    public GroupLexer(CharStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public GroupLexer(CharStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.dfa8 = new DFA8(this, this);
    }
}
