package androidx.room.jarjarred.org.antlr.v4.parse;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer;
import androidx.room.jarjarred.org.antlr.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.CommonTokenStream;
import androidx.room.jarjarred.org.antlr.runtime.DFA;
import androidx.room.jarjarred.org.antlr.runtime.EarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.FailedPredicateException;
import androidx.room.jarjarred.org.antlr.runtime.IntStream;
import androidx.room.jarjarred.org.antlr.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedSetException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.gui.TestRig;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import java.io.PrintStream;

/* JADX INFO: loaded from: classes.dex */
public class ANTLRLexer extends Lexer {
    public static final int ACTION = 4;
    public static final int ACTION_CHAR_LITERAL = 5;
    public static final int ACTION_ESC = 6;
    public static final int ACTION_STRING_LITERAL = 7;
    public static final int ARG_ACTION = 8;
    public static final int ARG_OR_CHARSET = 9;
    public static final int ASSIGN = 10;
    public static final int AT = 11;
    public static final int CATCH = 12;
    public static final int CHANNELS = 13;
    public static final int COLON = 14;
    public static final int COLONCOLON = 15;
    public static final int COMMA = 16;
    public static final int COMMENT = 17;
    public static final int COMMENTS_CHANNEL = 2;
    static final short[] DFA2_accept = null;
    static final String DFA2_acceptS = "\u0002\uffff\u0001\u0002\u000e\uffff\u0001\u0001\u0003\uffff\u0001\u0001\u0004\uffff";
    static final short[] DFA2_eof = null;
    static final String DFA2_eofS = "\u001a\uffff";
    static final short[] DFA2_eot = null;
    static final String DFA2_eotS = "\u0002\u0002\u0001\uffff\u000e\u0002\u0001\uffff\u0003\u0002\u0001\uffff\u0002\u0002\u0002\uffff";
    static final char[] DFA2_max = null;
    static final String DFA2_maxS = "\u0001 \u0001$\u0001\uffff\u0001A\u0001N\u0001T\u0001L\u0001R\u0001s\u0001r\u0001c\u0001 \u0001\"\u0003\uffff\u0001 \u0001\uffff\u0003\uffff\u0001\uffff\u00019\u0001\uffff\u0002\u0000";
    static final char[] DFA2_min = null;
    static final String DFA2_minS = "\u0001 \u0001$\u0001\uffff\u0001A\u0001N\u0001T\u0001L\u0001R\u0001s\u0001r\u0001c\u0002\t\u0003\u0000\u0001\t\u0001\uffff\u0003\u0000\u0001\uffff\u0001\t\u0003\u0000";
    static final short[] DFA2_special = null;
    static final String DFA2_specialS = "\r\uffff\u0001\u0004\u0001\u0005\u0001\u0002\u0002\uffff\u0001\u0000\u0001\u0007\u0001\u0003\u0002\uffff\u0001\u0001\u0001\u0006\u0001\b}>";
    static final short[][] DFA2_transition = null;
    static final String[] DFA2_transitionS = null;
    static final short[] DFA35_accept = null;
    static final String DFA35_acceptS = "\u0001\uffff\u0001\u0001\u0001\uffff\u0001\u0003\u000b\uffff\u0001\u0018\u0001\u0019\u0001\u001a\u0001\u001b\u0001\uffff\u0001\u001d\u0001\u001e\u0001\uffff\u0001 \u0001\"\u0001\uffff\u0001%\u0001&\u0001\uffff\u0001)\u0001*\u0001+\u0001,\u0001-\u0001.\u0001/\u00010\u00011\u00012\u0001\u0001\u0002\u0002\u0001\u0003\u0001\uffff\u0001-\u0010\uffff\u0001\u0017\u0001\u0016\u0001\u0018\u0001\u0019\u0001\u001a\u0001\u001b\u0001\u001c\u0001\u001d\u0001\u001e\u0001!\u0001\u001f\u0001 \u0001\"\u0001$\u0001#\u0001%\u0001&\u0001(\u0001'\u0001)\u0001*\u0001+\u0001,\u0001.\u0001/\u00010\u00011&\uffff\u0001\f\u000f\uffff\u0001\u0015\u0005\uffff\u0001\u0013\u0003\uffff\u0001\t\b\uffff\u0001\u0005\u0001\uffff\u0001\u0012\u0001\uffff\u0001\u0007\u0002\uffff\u0001\u0011\u0001\n\u0002\uffff\u0001\u000e\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0014\u0001\uffff\u0001\u000f\u0001\u000b\u0001\u0010\u0001\uffff\u0001\u0006\u0001\b\u0002\uffff\u0001\r\u0001\uffff";
    static final short[] DFA35_eof = null;
    static final String DFA35_eofS = "¿\uffff";
    static final short[] DFA35_eot = null;
    static final String DFA35_eotS = "\u0002\uffff\u0001&\u0001\uffff\n,\u0001>\u0004\uffff\u0001&\u0002\uffff\u0001G\u0002\uffff\u0001K\u0002\uffff\u0001O\u000e\uffff\u0001,\u0001\uffff\u0010,\u001b\uffff#,\u0001\u008e\u0002,\u0001\uffff\u0003,\u0001\u0094\u0003,\u0001\u0098\u0007,\u0001\uffff\u0003,\u0001£\u0001,\u0001\uffff\u0001¥\u0002,\u0001\uffff\u0001¨\u0001©\u0002,\u0001¬\u0003,\u0001\uffff\u0001,\u0001\uffff\u0001,\u0001\uffff\u0001,\u0001³\u0002\uffff\u0001,\u0001µ\u0001\uffff\u0001¶\u0001·\u0001\uffff\u0002,\u0001º\u0001\uffff\u0001,\u0003\uffff\u0001,\u0002\uffff\u0001½\u0001,\u0001\uffff\u0001~";
    static final char[] DFA35_max = null;
    static final String DFA35_maxS = "\u0001\uffff\u0001\uffff\u0001\uffff\u0001\uffff\u0001p\u0001r\u0001h\u0001m\u0001r\u0001o\u0001u\u0001r\u0001e\u0001o\u0001:\u0004\uffff\u0001>\u0002\uffff\u0001>\u0002\uffff\u0001=\u0002\uffff\u0001.\u000e\uffff\u0001t\u0001\uffff\u0001k\u0001e\u0001r\u0001a\u0001t\u0001p\u0001a\u0001n\u0001x\u0001c\u0001r\u0001o\u0001b\u0001a\u0001t\u0001d\u001b\uffff\u0001i\u0002e\u0001o\u0001n\u0001c\u0001o\u0001g\u0001a\u0001e\u0001a\u0001s\u0001t\u0001v\u0001l\u0001m\u0001u\u0001e\u0001o\u0001n\u0001g\u0001w\u0001n\u0001h\u0001r\u0001m\u0001l\u0001r\u0001l\u0002e\u0001a\u0001i\u0001m\u0001r\u0001�\u0001n\u0001s\u0001\uffff\u0001r\u0001s\u0001e\u0001�\u0001t\u0001e\u0001l\u0001�\u0001s\u0001r\u0001c\u0001t\u0001c\u0001a\u0001n\u0001\uffff\u0001s\u0001{\u0001a\u0001�\u0001l\u0001\uffff\u0001�\u0001n\u0001y\u0001\uffff\u0002�\u0001t\u0001e\u0001�\u0001r\u0001s\u0001{\u0001\uffff\u0001m\u0001\uffff\u0001s\u0001\uffff\u0001t\u0001�\u0002\uffff\u0001e\u0001�\u0001\uffff\u0002�\u0001\uffff\u0001m\u0001{\u0001�\u0001\uffff\u0001d\u0003\uffff\u0001a\u0002\uffff\u0001�\u0001r\u0001\uffff\u0001�";
    static final char[] DFA35_min = null;
    static final String DFA35_minS = "\u0001\u0000\u0001\uffff\u0001\u0000\u0001\uffff\u0001p\u0001h\u0001a\u0001m\u0001i\u0001e\u0001a\u0001r\u0001e\u0001o\u0001:\u0004\uffff\u0001>\u0002\uffff\u0001>\u0002\uffff\u0001=\u0002\uffff\u0001.\u000e\uffff\u0001t\u0001\uffff\u0001k\u0001e\u0001r\u0001a\u0001t\u0001p\u0001a\u0001n\u0001x\u0001c\u0001r\u0001i\u0001b\u0001a\u0001t\u0001d\u001b\uffff\u0001i\u0002e\u0001o\u0001n\u0001c\u0001o\u0001g\u0001a\u0001e\u0001a\u0001s\u0001t\u0001v\u0001l\u0001m\u0001u\u0001e\u0001o\u0001n\u0001\t\u0001w\u0001n\u0001h\u0001r\u0001m\u0001l\u0001r\u0001l\u0002e\u0001a\u0001i\u0001m\u0001r\u00010\u0001n\u0001s\u0001\uffff\u0001r\u0001s\u0001e\u00010\u0001t\u0001e\u0001l\u00010\u0001s\u0001r\u0001c\u0001t\u0001c\u0001a\u0001n\u0001\uffff\u0001s\u0001\t\u0001a\u00010\u0001l\u0001\uffff\u00010\u0001n\u0001y\u0001\uffff\u00020\u0001t\u0001e\u00010\u0001r\u0001s\u0001\t\u0001\uffff\u0001m\u0001\uffff\u0001s\u0001\uffff\u0001t\u00010\u0002\uffff\u0001e\u00010\u0001\uffff\u00020\u0001\uffff\u0001m\u0001\t\u00010\u0001\uffff\u0001d\u0003\uffff\u0001a\u0002\uffff\u00010\u0001r\u0001\uffff\u00010";
    static final short[] DFA35_special = null;
    static final String DFA35_specialS = "\u0001\u0001\u0001\uffff\u0001\u0000¼\uffff}>";
    static final short[][] DFA35_transition = null;
    static final String[] DFA35_transitionS = null;
    public static final int DOC_COMMENT = 18;
    public static final int DOLLAR = 19;
    public static final int DOT = 20;
    public static final int EOF = -1;
    public static final int ERRCHAR = 21;
    public static final int ESC_SEQ = 22;
    public static final int FINALLY = 23;
    public static final int FRAGMENT = 24;
    public static final int GRAMMAR = 25;
    public static final int GT = 26;
    public static final int HEX_DIGIT = 27;
    public static final int ID = 28;
    public static final int IMPORT = 29;
    public static final int INT = 30;
    public static final int LEXER = 31;
    public static final int LEXER_CHAR_SET = 32;
    public static final int LOCALS = 33;
    public static final int LPAREN = 34;
    public static final int LT = 35;
    public static final int MODE = 36;
    public static final int NESTED_ACTION = 37;
    public static final int NLCHARS = 38;
    public static final int NOT = 39;
    public static final int NameChar = 40;
    public static final int NameStartChar = 41;
    public static final int OPTIONS = 42;
    public static final int OR = 43;
    public static final int PARSER = 44;
    public static final int PLUS = 45;
    public static final int PLUS_ASSIGN = 46;
    public static final int POUND = 47;
    public static final int PRIVATE = 48;
    public static final int PROTECTED = 49;
    public static final int PUBLIC = 50;
    public static final int QUESTION = 51;
    public static final int RANGE = 52;
    public static final int RARROW = 53;
    public static final int RBRACE = 54;
    public static final int RETURNS = 55;
    public static final int RPAREN = 56;
    public static final int RULE_REF = 57;
    public static final int SEMI = 58;
    public static final int SEMPRED = 59;
    public static final int SRC = 60;
    public static final int STAR = 61;
    public static final int STRING_LITERAL = 62;
    public static final int SYNPRED = 63;
    public static final int THROWS = 64;
    public static final int TOKENS_SPEC = 65;
    public static final int TOKEN_REF = 66;
    public static final int TREE_GRAMMAR = 67;
    public static final int UNICODE_ESC = 68;
    public static final int UNICODE_EXTENDED_ESC = 69;
    public static final int UnicodeBOM = 70;
    public static final int WS = 71;
    public static final int WSCHARS = 72;
    public static final int WSNLCHARS = 73;
    protected DFA2 dfa2;
    protected DFA35 dfa35;
    public boolean isLexerRule;
    public CommonTokenStream tokens;

    public class DFA2 extends DFA {
        final /* synthetic */ ANTLRLexer this$0;

        public DFA2(ANTLRLexer r5, BaseRecognizer r10) {
            this.this$0 = r5;
            this.recognizer = r10;
            this.decisionNumber = 2;
            this.eot = ANTLRLexer.DFA2_eot;
            this.eof = ANTLRLexer.DFA2_eof;
            this.min = ANTLRLexer.DFA2_min;
            this.max = ANTLRLexer.DFA2_max;
            this.accept = ANTLRLexer.DFA2_accept;
            this.special = ANTLRLexer.DFA2_special;
            this.transition = ANTLRLexer.DFA2_transition;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.DFA
        public String getDescription() {
            return "216:13: ( ( ' $ANTLR' )=> ' $ANTLR' SRC | (~ ( NLCHARS ) )* )";
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.DFA
        public int specialStateTransition(int r17, IntStream r18) throws NoViableAltException {
            switch(r17) {
                case 0: goto L199;
                case 1: goto L154;
                case 2: goto L127;
                case 3: goto L100;
                case 4: goto L73;
                case 5: goto L46;
                case 6: goto L39;
                case 7: goto L12;
                case 8: goto L5;
                default: goto L236;
            };
        L5:
            r18.LA(1);
            int r5 = r18.index();
            r18.rewind();
            if (this.this$0.synpred1_ANTLRLexer() == false) goto L8;
            int r10 = 21;
        L9:
            r18.seek(r5);
            if (r10 < 0) goto L236;
            return r10;
        L8:
            r10 = 2;
            goto L9
        L12:
            int r11 = r18.LA(1);
            int r12 = r18.index();
            r18.rewind();
            if (r11 != 34) goto L15;
            int r13 = 18;
        L36:
            r18.seek(r12);
            if (r13 < 0) goto L236;
            return r13;
        L15:
            if (r11 != 92) goto L17;
            r13 = 19;
            goto L36
        L17:
            if (r11 < 0) goto L19;
            if (r11 > 9) goto L19;
        L27:
            r13 = 20;
        L19:
            if (r11 < 11) goto L21;
            if (r11 <= 12) goto L27;
        L21:
            if (r11 < 14) goto L23;
            if (r11 <= 33) goto L27;
        L23:
            if (r11 < 35) goto L25;
            if (r11 <= 91) goto L27;
        L25:
            if (r11 < 93) goto L29;
            if (r11 <= 65535) goto L27;
        L29:
            if (r11 == 10) goto L33;
            if (r11 == 13) goto L33;
        L35:
            r13 = 2;
        L33:
            if (this.this$0.synpred1_ANTLRLexer() == false) goto L35;
            r13 = 21;
            goto L36
        L39:
            r18.LA(1);
            int r14 = r18.index();
            r18.rewind();
            if (this.this$0.synpred1_ANTLRLexer() == false) goto L42;
            int r15 = 21;
        L43:
            r18.seek(r14);
            if (r15 < 0) goto L236;
            return r15;
        L42:
            r15 = 2;
            goto L43
        L46:
            int r16 = r18.LA(1);
            int r19 = r18.index();
            r18.rewind();
            if (r16 != 34) goto L49;
            int r20 = 18;
        L70:
            r18.seek(r19);
            if (r20 < 0) goto L236;
            return r20;
        L49:
            if (r16 != 92) goto L51;
            r20 = 19;
            goto L70
        L51:
            if (r16 < 0) goto L53;
            if (r16 > 9) goto L53;
        L61:
            r20 = 20;
        L53:
            if (r16 < 11) goto L55;
            if (r16 <= 12) goto L61;
        L55:
            if (r16 < 14) goto L57;
            if (r16 <= 33) goto L61;
        L57:
            if (r16 < 35) goto L59;
            if (r16 <= 91) goto L61;
        L59:
            if (r16 < 93) goto L63;
            if (r16 <= 65535) goto L61;
        L63:
            if (r16 == 10) goto L67;
            if (r16 == 13) goto L67;
        L69:
            r20 = 2;
        L67:
            if (this.this$0.synpred1_ANTLRLexer() == false) goto L69;
            r20 = 21;
            goto L70
        L73:
            int r110 = r18.LA(1);
            int r21 = r18.index();
            r18.rewind();
            if (r110 != 92) goto L76;
            int r22 = 14;
        L97:
            r18.seek(r21);
            if (r22 < 0) goto L236;
            return r22;
        L76:
            if (r110 < 0) goto L78;
            if (r110 > 9) goto L78;
        L86:
            r22 = 15;
        L78:
            if (r110 < 11) goto L80;
            if (r110 <= 12) goto L86;
        L80:
            if (r110 < 14) goto L82;
            if (r110 <= 33) goto L86;
        L82:
            if (r110 < 35) goto L84;
            if (r110 <= 91) goto L86;
        L84:
            if (r110 < 93) goto L87;
            if (r110 <= 65535) goto L86;
        L87:
            if (r110 != 34) goto L90;
            r22 = 16;
            goto L97
        L90:
            if (r110 == 10) goto L94;
            if (r110 == 13) goto L94;
        L96:
            r22 = 2;
        L94:
            if (this.this$0.synpred1_ANTLRLexer() == false) goto L96;
            r22 = 17;
            goto L97
        L100:
            int r111 = r18.LA(1);
            int r23 = r18.index();
            r18.rewind();
            if (r111 != 34) goto L103;
            int r24 = 16;
        L124:
            r18.seek(r23);
            if (r24 < 0) goto L236;
            return r24;
        L103:
            if (r111 != 92) goto L105;
            r24 = 14;
            goto L124
        L105:
            if (r111 < 0) goto L107;
            if (r111 > 9) goto L107;
        L115:
            r24 = 15;
        L107:
            if (r111 < 11) goto L109;
            if (r111 <= 12) goto L115;
        L109:
            if (r111 < 14) goto L111;
            if (r111 <= 33) goto L115;
        L111:
            if (r111 < 35) goto L113;
            if (r111 <= 91) goto L115;
        L113:
            if (r111 < 93) goto L117;
            if (r111 <= 65535) goto L115;
        L117:
            if (r111 == 10) goto L121;
            if (r111 == 13) goto L121;
        L123:
            r24 = 2;
        L121:
            if (this.this$0.synpred1_ANTLRLexer() == false) goto L123;
            r24 = 17;
            goto L124
        L127:
            int r112 = r18.LA(1);
            int r25 = r18.index();
            r18.rewind();
            if (r112 != 34) goto L130;
            int r26 = 16;
        L151:
            r18.seek(r25);
            if (r26 < 0) goto L236;
            return r26;
        L130:
            if (r112 != 92) goto L132;
            r26 = 14;
            goto L151
        L132:
            if (r112 < 0) goto L134;
            if (r112 > 9) goto L134;
        L142:
            r26 = 15;
        L134:
            if (r112 < 11) goto L136;
            if (r112 <= 12) goto L142;
        L136:
            if (r112 < 14) goto L138;
            if (r112 <= 33) goto L142;
        L138:
            if (r112 < 35) goto L140;
            if (r112 <= 91) goto L142;
        L140:
            if (r112 < 93) goto L144;
            if (r112 <= 65535) goto L142;
        L144:
            if (r112 == 10) goto L148;
            if (r112 == 13) goto L148;
        L150:
            r26 = 2;
        L148:
            if (this.this$0.synpred1_ANTLRLexer() == false) goto L150;
            r26 = 17;
            goto L151
        L154:
            int r113 = r18.LA(1);
            int r27 = r18.index();
            r18.rewind();
            if (r113 != 34) goto L157;
            int r28 = 16;
        L196:
            r18.seek(r27);
            if (r28 < 0) goto L236;
            return r28;
        L157:
            if (r113 != 92) goto L160;
            r28 = 14;
            goto L196
        L160:
            if (r113 >= 48) goto L162;
        L164:
            if (r113 == 9) goto L195;
            if (r113 == 12) goto L195;
            if (r113 == 32) goto L195;
            if (r113 >= 0) goto L171;
        L172:
            if (r113 == 11) goto L194;
            if (r113 >= 14) goto L175;
        L176:
            if (r113 == 33) goto L194;
            if (r113 < 35) goto L181;
            if (r113 <= 47) goto L194;
        L181:
            if (r113 < 58) goto L183;
            if (r113 <= 91) goto L194;
        L183:
            if (r113 < 93) goto L187;
            if (r113 <= 65535) goto L194;
        L187:
            if (r113 == 10) goto L191;
            if (r113 == 13) goto L191;
        L193:
            r28 = 2;
        L191:
            if (this.this$0.synpred1_ANTLRLexer() == false) goto L193;
            r28 = 17;
            goto L196
        L175:
            if (r113 > 31) goto L176;
        L194:
            r28 = 15;
            goto L196
        L171:
            if (r113 <= 8) goto L194;
        L195:
            r28 = 23;
            goto L196
        L162:
            if (r113 > 57) goto L164;
            r28 = 25;
            goto L196
        L199:
            int r114 = r18.LA(1);
            int r29 = r18.index();
            r18.rewind();
            if (r114 != 34) goto L202;
            int r30 = 16;
        L232:
            r18.seek(r29);
            if (r30 < 0) goto L236;
            return r30;
        L202:
            if (r114 != 92) goto L204;
            r30 = 14;
            goto L232
        L204:
            if (r114 == 9) goto L231;
            if (r114 == 12) goto L231;
            if (r114 == 32) goto L231;
            if (r114 >= 0) goto L211;
        L212:
            if (r114 == 11) goto L230;
            if (r114 >= 14) goto L215;
        L216:
            if (r114 == 33) goto L230;
            if (r114 < 35) goto L219;
            if (r114 <= 91) goto L230;
        L219:
            if (r114 < 93) goto L223;
            if (r114 <= 65535) goto L230;
        L223:
            if (r114 == 10) goto L227;
            if (r114 == 13) goto L227;
        L229:
            r30 = 2;
        L227:
            if (this.this$0.synpred1_ANTLRLexer() == false) goto L229;
            r30 = 17;
            goto L232
        L215:
            if (r114 > 31) goto L216;
        L230:
            r30 = 15;
            goto L232
        L211:
            if (r114 <= 8) goto L230;
        L231:
            r30 = 23;
        L236:
            if (ANTLRLexer.access$000(this.this$0).backtracking <= 0) goto L239;
            ANTLRLexer.access$100(this.this$0).failed = true;
            return -1;
        L239:
            NoViableAltException r31 = new NoViableAltException(getDescription(), 2, r17, r18);
            error(r31);
            throw r31;
        }
    }

    public class DFA35 extends DFA {
        final /* synthetic */ ANTLRLexer this$0;

        public DFA35(ANTLRLexer r5, BaseRecognizer r10) {
            this.this$0 = r5;
            this.recognizer = r10;
            this.decisionNumber = 35;
            this.eot = ANTLRLexer.DFA35_eot;
            this.eof = ANTLRLexer.DFA35_eof;
            this.min = ANTLRLexer.DFA35_min;
            this.max = ANTLRLexer.DFA35_max;
            this.accept = ANTLRLexer.DFA35_accept;
            this.special = ANTLRLexer.DFA35_special;
            this.transition = ANTLRLexer.DFA35_transition;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.DFA
        public String getDescription() {
            return "1:1: Tokens : ( COMMENT | ARG_OR_CHARSET | ACTION | OPTIONS | TOKENS_SPEC | CHANNELS | IMPORT | FRAGMENT | LEXER | PARSER | GRAMMAR | TREE_GRAMMAR | PROTECTED | PUBLIC | PRIVATE | RETURNS | LOCALS | THROWS | CATCH | FINALLY | MODE | COLON | COLONCOLON | COMMA | SEMI | LPAREN | RPAREN | RARROW | LT | GT | ASSIGN | QUESTION | SYNPRED | STAR | PLUS | PLUS_ASSIGN | OR | DOLLAR | DOT | RANGE | AT | POUND | NOT | RBRACE | ID | INT | STRING_LITERAL | WS | UnicodeBOM | ERRCHAR );";
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.DFA
        public int specialStateTransition(int r17, IntStream r18) throws NoViableAltException {
            int r5 = 41;
            if (r17 == 0) goto L256;
            if (r17 != 1) goto L278;
            int r10 = r18.LA(1);
            if (r10 != 47) goto L10;
            int r11 = 1;
        L254:
            if (r11 < 0) goto L278;
            return r11;
        L10:
            if (r10 != 91) goto L13;
            r11 = 2;
            goto L254
        L13:
            if (r10 != 123) goto L16;
            r11 = 3;
            goto L254
        L16:
            if (r10 != 111) goto L19;
            r11 = 4;
            goto L254
        L19:
            if (r10 != 116) goto L22;
            r11 = 5;
            goto L254
        L22:
            if (r10 != 99) goto L25;
            r11 = 6;
            goto L254
        L25:
            if (r10 != 105) goto L27;
            r11 = 7;
            goto L254
        L27:
            int r12 = 8;
            if (r10 != 102) goto L31;
        L29:
            r11 = r12;
            goto L254
        L31:
            if (r10 != 108) goto L34;
            r11 = 9;
            goto L254
        L34:
            if (r10 != 112) goto L37;
            r11 = 10;
            goto L254
        L37:
            if (r10 != 103) goto L40;
            r11 = 11;
            goto L254
        L40:
            if (r10 != 114) goto L43;
            r11 = 12;
            goto L254
        L43:
            if (r10 != 109) goto L46;
            r11 = 13;
            goto L254
        L46:
            if (r10 != 58) goto L49;
            r11 = 14;
            goto L254
        L49:
            if (r10 != 44) goto L52;
            r11 = 15;
            goto L254
        L52:
            if (r10 != 59) goto L54;
            r11 = 16;
            goto L254
        L54:
            if (r10 != 40) goto L56;
            r11 = 17;
            goto L254
        L56:
            if (r10 != 41) goto L59;
            r11 = 18;
            goto L254
        L59:
            if (r10 != 45) goto L62;
            r11 = 19;
            goto L254
        L62:
            if (r10 != 60) goto L65;
            r11 = 20;
            goto L254
        L65:
            if (r10 != 62) goto L68;
            r11 = 21;
            goto L254
        L68:
            if (r10 != 61) goto L71;
            r11 = 22;
            goto L254
        L71:
            if (r10 != 63) goto L74;
            r11 = 23;
            goto L254
        L74:
            if (r10 != 42) goto L77;
            r11 = 24;
            goto L254
        L77:
            if (r10 != 43) goto L80;
            r11 = 25;
            goto L254
        L80:
            if (r10 != 124) goto L83;
            r11 = 26;
            goto L254
        L83:
            if (r10 != 36) goto L86;
            r11 = 27;
            goto L254
        L86:
            if (r10 != 46) goto L89;
            r11 = 28;
            goto L254
        L89:
            if (r10 != 64) goto L91;
            r11 = 29;
            goto L254
        L91:
            if (r10 != 35) goto L94;
            r11 = 30;
            goto L254
        L94:
            if (r10 != 126) goto L97;
            r11 = 31;
            goto L254
        L97:
            if (r10 != 125) goto L100;
            r11 = 32;
            goto L254
        L100:
            if (r10 < 65) goto L104;
            if (r10 > 90) goto L104;
        L253:
            r11 = 33;
        L104:
            if (r10 < 97) goto L108;
            if (r10 <= 98) goto L253;
        L108:
            if (r10 < 100) goto L112;
            if (r10 <= 101) goto L253;
        L112:
            if (r10 == 104) goto L253;
            if (r10 < 106) goto L118;
            if (r10 <= 107) goto L253;
        L118:
            if (r10 == 110) goto L253;
            if (r10 == 113) goto L253;
            if (r10 == 115) goto L253;
            if (r10 < 117) goto L128;
            if (r10 <= 122) goto L253;
        L128:
            if (r10 < 192) goto L132;
            if (r10 <= 214) goto L253;
        L132:
            if (r10 < 216) goto L136;
            if (r10 <= 246) goto L253;
        L136:
            if (r10 < 248) goto L140;
            if (r10 <= 767) goto L253;
        L140:
            if (r10 < 880) goto L144;
            if (r10 <= 893) goto L253;
        L144:
            if (r10 < 895) goto L148;
            if (r10 <= 8191) goto L253;
        L148:
            if (r10 < 8204) goto L152;
            if (r10 <= 8205) goto L253;
        L152:
            if (r10 < 8304) goto L156;
            if (r10 <= 8591) goto L253;
        L156:
            if (r10 < 11264) goto L160;
            if (r10 <= 12271) goto L253;
        L160:
            if (r10 < 12289) goto L164;
            if (r10 <= 55295) goto L253;
        L164:
            if (r10 < 63744) goto L168;
            if (r10 <= 64975) goto L253;
        L168:
            if (r10 < 65008) goto L172;
            if (r10 <= 65278) goto L253;
        L172:
            if (r10 >= 65280) goto L174;
        L176:
            r11 = 34;
            if (r10 < 48) goto L182;
            if (r10 <= 57) goto L254;
        L182:
            if (r10 != 39) goto L184;
            r11 = 35;
            goto L254
        L184:
            if (r10 < 9) goto L186;
            if (r10 > 10) goto L186;
        L189:
            r11 = 36;
        L186:
            if (r10 < 12) goto L188;
            if (r10 <= 13) goto L189;
        L188:
            if (r10 == 32) goto L189;
            if (r10 != 65279) goto L193;
            r11 = 37;
            goto L254
        L193:
            if (r10 < 0) goto L197;
            if (r10 > 8) goto L197;
        L196:
            r12 = 38;
        L197:
            if (r10 == 11) goto L196;
            if (r10 < 14) goto L200;
            if (r10 <= 31) goto L196;
        L200:
            if (r10 < 33) goto L202;
            if (r10 <= 34) goto L196;
        L202:
            r12 = 38;
            if (r10 < 37) goto L206;
            if (r10 <= 38) goto L29;
        L206:
            if (r10 < 92) goto L210;
            if (r10 <= 96) goto L29;
        L210:
            if (r10 < 127) goto L214;
            if (r10 <= 191) goto L29;
        L214:
            if (r10 == 215) goto L29;
            if (r10 == 247) goto L29;
            if (r10 < 768) goto L222;
            if (r10 <= 879) goto L29;
        L222:
            if (r10 == 894) goto L29;
            if (r10 < 8192) goto L228;
            if (r10 <= 8203) goto L29;
        L228:
            if (r10 < 8206) goto L232;
            if (r10 <= 8303) goto L29;
        L232:
            if (r10 < 8592) goto L236;
            if (r10 <= 11263) goto L29;
        L236:
            if (r10 < 12272) goto L240;
            if (r10 <= 12288) goto L29;
        L240:
            if (r10 < 55296) goto L244;
            if (r10 <= 63743) goto L29;
        L244:
            if (r10 < 64976) goto L248;
            if (r10 <= 65007) goto L29;
        L248:
            if (r10 >= 65534) goto L250;
        L252:
            r11 = -1;
            goto L254
        L250:
            if (r10 > 65535) goto L252;
        L174:
            if (r10 > 65533) goto L176;
        L278:
            if (ANTLRLexer.access$200(this.this$0).backtracking <= 0) goto L281;
            ANTLRLexer.access$300(this.this$0).failed = true;
            return -1;
        L281:
            NoViableAltException r13 = new NoViableAltException(getDescription(), 35, r17, r18);
            error(r13);
            throw r13;
        L256:
            int r14 = r18.LA(1);
            int r15 = r18.index();
            r18.rewind();
            if (r14 < 0) goto L259;
            if (r14 > 9) goto L259;
        L264:
            boolean r16 = this.this$0.isLexerRule;
            if (r16 == false) goto L267;
            if (r16 == true) goto L267;
        L268:
            if (r14 == 10) goto L271;
            if (r14 == 13) goto L271;
        L273:
            r5 = 38;
        L274:
            r18.seek(r15);
            if (r5 < 0) goto L278;
            return r5;
        L271:
            if (this.this$0.isLexerRule == true) goto L273;
        L267:
            r5 = 40;
        L259:
            if (r14 < 11) goto L261;
            if (r14 <= 12) goto L264;
        L261:
            if (r14 < 14) goto L268;
            if (r14 > 65535) goto L268;
            goto L264
        }
    }

    static {
        String[] r5 = {"\u0001\u0001", "\u0001\u0003", "", "\u0001\u0004", "\u0001\u0005", "\u0001\u0006", "\u0001\u0007", "\u0001\b", "\u0001\t", "\u0001\n", "\u0001\u000b", "\u0001\f\u0002\uffff\u0001\f\u0013\uffff\u0001\f", "\u0001\f\u0002\uffff\u0001\f\u0013\uffff\u0001\f\u0001\uffff\u0001\r", "\n\u000f\u0001\u0011\u0002\u000f\u0001\u0011\u0014\u000f\u0001\u00109\u000f\u0001\u000eﾣ\u000f", "\n\u0014\u0001\u0015\u0002\u0014\u0001\u0015\u0014\u0014\u0001\u00129\u0014\u0001\u0013ﾣ\u0014", "\n\u000f\u0001\u0011\u0002\u000f\u0001\u0011\u0014\u000f\u0001\u00109\u000f\u0001\u000eﾣ\u000f", "\u0001\u0016\u0002\uffff\u0001\u0016\u0013\uffff\u0001\u0016", "", "\t\u000f\u0001\u0017\u0001\u0011\u0001\u000f\u0001\u0017\u0001\u0011\u0012\u000f\u0001\u0017\u0001\u000f\u0001\u00109\u000f\u0001\u000eﾣ\u000f", "\n\u0014\u0001\u0015\u0002\u0014\u0001\u0015\u0014\u0014\u0001\u00129\u0014\u0001\u0013ﾣ\u0014", "\n\u000f\u0001\u0011\u0002\u000f\u0001\u0011\u0014\u000f\u0001\u00109\u000f\u0001\u000eﾣ\u000f", "", "\u0001\u0016\u0002\uffff\u0001\u0016\u0013\uffff\u0001\u0016\u000f\uffff\n\u0018", "\t\u000f\u0001\u0017\u0001\u0011\u0001\u000f\u0001\u0017\u0001\u0011\u0012\u000f\u0001\u0017\u0001\u000f\u0001\u0010\r\u000f\n\u0019\"\u000f\u0001\u000eﾣ\u000f", "\u0001\uffff", "\u0001\uffff"};
        DFA2_transitionS = r5;
        DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
        DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
        DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
        DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
        DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
        DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
        int r10 = r5.length;
        DFA2_transition = new short[r10][];
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        DFA2_transition[r12] = DFA.unpackEncodedString(DFA2_transitionS[r12]);
        r12 = r12 + 1;
        goto L3
    L5:
        String[] r13 = {"\t&\u0002$\u0001&\u0002$\u0012&\u0001$\u0002&\u0001\u001e\u0001\u001b\u0002&\u0001#\u0001\u0011\u0001\u0012\u0001\u0018\u0001\u0019\u0001\u000f\u0001\u0013\u0001\u001c\u0001\u0001\n\"\u0001\u000e\u0001\u0010\u0001\u0014\u0001\u0016\u0001\u0015\u0001\u0017\u0001\u001d\u001a!\u0001\u0002\u0005&\u0002!\u0001\u0006\u0002!\u0001\b\u0001\u000b\u0001!\u0001\u0007\u0002!\u0001\t\u0001\r\u0001!\u0001\u0004\u0001\n\u0001!\u0001\f\u0001!\u0001\u0005\u0006!\u0001\u0003\u0001\u001a\u0001 \u0001\u001fA&\u0017!\u0001&\u001f!\u0001&Ȉ!p&\u000e!\u0001&ᲁ!\f&\u0002!b&Ġ!ੰ&ϰ!\u0011&ꟿ!℀&Ӑ! &ď!\u0001%þ!\u0002&", "", "\n(\u0001)\u0002(\u0001)\ufff2(", "", "\u0001+", "\u0001/\u0006\uffff\u0001-\u0002\uffff\u0001.", "\u00011\u0006\uffff\u00010", "\u00012", "\u00014\b\uffff\u00013", "\u00015\t\uffff\u00016", "\u00017\u0010\uffff\u00018\u0002\uffff\u00019", "\u0001:", "\u0001;", "\u0001<", "\u0001=", "", "", "", "", "\u0001C", "", "", "\u0001F", "", "", "\u0001J", "", "", "\u0001N", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "\u0001X", "", "\u0001Y", "\u0001Z", "\u0001[", "\u0001\\", "\u0001]", "\u0001^", "\u0001_", "\u0001`", "\u0001a", "\u0001b", "\u0001c", "\u0001e\u0005\uffff\u0001d", "\u0001f", "\u0001g", "\u0001h", "\u0001i", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "\u0001j", "\u0001k", "\u0001l", "\u0001m", "\u0001n", "\u0001o", "\u0001p", "\u0001q", "\u0001r", "\u0001s", "\u0001t", "\u0001u", "\u0001v", "\u0001w", "\u0001x", "\u0001y", "\u0001z", "\u0001{", "\u0001|", "\u0001}", "\u0002~\u0001\uffff\u0002~\u0012\uffff\u0001~F\uffff\u0001\u007f", "\u0001\u0080", "\u0001\u0081", "\u0001\u0082", "\u0001\u0083", "\u0001\u0084", "\u0001\u0085", "\u0001\u0086", "\u0001\u0087", "\u0001\u0088", "\u0001\u0089", "\u0001\u008a", "\u0001\u008b", "\u0001\u008c", "\u0001\u008d", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "\u0001\u008f", "\u0001\u0090", "", "\u0001\u0091", "\u0001\u0092", "\u0001\u0093", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "\u0001\u0095", "\u0001\u0096", "\u0001\u0097", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "\u0001\u0099", "\u0001\u009a", "\u0001\u009b", "\u0001\u009c", "\u0001\u009d", "\u0001\u009e", "\u0001\u009f", "", "\u0001 ", "\u0002¡\u0001\uffff\u0002¡\u0012\uffff\u0001¡Z\uffff\u0001¡", "\u0001¢", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "\u0001¤", "", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "\u0001¦", "\u0001§", "", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "\u0001ª", "\u0001«", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "\u0001\u00ad", "\u0001®", "\u0002¯\u0001\uffff\u0002¯\u0012\uffff\u0001¯Z\uffff\u0001¯", "", "\u0001°", "", "\u0001±", "", "\u0001²", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "", "", "\u0001´", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "", "\u0001¸", "\u0002¹\u0001\uffff\u0002¹\u0012\uffff\u0001¹Z\uffff\u0001¹", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "", "\u0001»", "", "", "", "\u0001¼", "", "", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,", "\u0001¾", "", "\n,\u0007\uffff\u001a,\u0004\uffff\u0001,\u0001\uffff\u001a,<\uffff\u0001,\b\uffff\u0017,\u0001\uffff\u001f,\u0001\uffffʆ,\u0001\uffffᲁ,\f\uffff\u0002,1\uffff\u0002,/\uffffĠ,ੰ\uffffϰ,\u0011\uffffꟿ,℀\uffffӐ, \uffffď,\u0001\uffffþ,"};
        DFA35_transitionS = r13;
        DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
        DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
        DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
        DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
        DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
        DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
        int r14 = r13.length;
        DFA35_transition = new short[r14][];
    L6:
        if (r11 >= r14) goto L8;
        DFA35_transition[r11] = DFA.unpackEncodedString(DFA35_transitionS[r11]);
        r11 = r11 + 1;
        goto L6
    }

    public ANTLRLexer() {
        this.isLexerRule = false;
        this.dfa2 = new DFA2(this, this);
        this.dfa35 = new DFA35(this, this);
    }

    public static /* synthetic */ RecognizerSharedState access$000(ANTLRLexer r5) {
        return r5.state;
    }

    public static /* synthetic */ RecognizerSharedState access$100(ANTLRLexer r5) {
        return r5.state;
    }

    public static /* synthetic */ RecognizerSharedState access$200(ANTLRLexer r5) {
        return r5.state;
    }

    public static /* synthetic */ RecognizerSharedState access$300(ANTLRLexer r5) {
        return r5.state;
    }

    public Lexer[] getDelegates() {
        return new Lexer[0];
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getGrammarFileName() {
        return "androidx/room/jarjarred/org/antlr/v4/parse/ANTLRLexer.g";
    }

    public Token getRuleOrSubruleStartToken() {
        CommonTokenStream r5 = this.tokens;
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = r5.index();
        int r11 = this.tokens.size();
        if (r10 < r11) goto L8;
        r10 = r11 - 1;
    L8:
        if (r10 < 0) goto L20;
        if (r10 >= r11) goto L20;
        int r12 = this.tokens.get(r10).getType();
        if (r12 == 34) goto L19;
        if (r12 == 66) goto L19;
        if (r12 == 57) goto L19;
        r10 = r10 - 1;
    L19:
        return this.tokens.get(r10);
    L20:
        return null;
    }

    public void grammarError(ErrorType r5, Token r10, Object... r11) {
    }

    public final void mACTION() throws RecognitionException {
        mNESTED_ACTION();
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = 4;
        if (this.input.LA(1) != 63) goto L55;
        match(63);
        RecognizerSharedState r10 = this.state;
        if (r10.failed == false) goto L11;
        return;
    L11:
        if (r10.backtracking != 0) goto L13;
        r5 = 59;
    L13:
        int r11 = this.input.LA(1);
        if (r11 < 9) goto L16;
        if (r11 > 10) goto L16;
    L20:
        if (synpred4_ANTLRLexer() == true) goto L26;
    L23:
        if (r11 != 61) goto L55;
        if (synpred4_ANTLRLexer() == false) goto L55;
    L26:
        int r12 = this.input.LA(1);
        if (r12 < 9) goto L29;
        if (r12 > 10) goto L29;
    L33:
        if (this.input.LA(1) < 9) goto L37;
        if (this.input.LA(1) > 10) goto L37;
    L42:
        this.input.consume();
        this.state.failed = false;
    L37:
        if (this.input.LA(1) < 12) goto L41;
        if (this.input.LA(1) <= 13) goto L42;
    L41:
        if (this.input.LA(1) == 32) goto L42;
        RecognizerSharedState r13 = this.state;
        if (r13.backtracking <= 0) goto L47;
        r13.failed = true;
        return;
    L47:
        MismatchedSetException r14 = new MismatchedSetException(null, this.input);
        recover(r14);
        throw r14;
    L29:
        if (r12 < 12) goto L31;
        if (r12 <= 13) goto L33;
    L31:
        if (r12 == 32) goto L33;
        match("=>");
        RecognizerSharedState r15 = this.state;
        if (r15.failed == false) goto L53;
        return;
    L53:
        if (r15.backtracking != 0) goto L55;
        CommonToken r16 = new CommonToken(this.input, r15.type, r15.channel, r15.tokenStartCharIndex, getCharIndex() - 1);
        r16.setLine(this.state.tokenStartLine);
        r16.setText(this.state.text);
        r16.setCharPositionInLine(this.state.tokenStartCharPositionInLine);
        grammarError(ErrorType.V3_GATED_SEMPRED, r16, new Object[0]);
    L16:
        if (r11 < 12) goto L18;
        if (r11 <= 13) goto L20;
    L18:
        if (r11 != 32) goto L23;
    L55:
        RecognizerSharedState r17 = this.state;
        r17.type = r5;
        r17.channel = 0;
    }

    public final void mACTION_CHAR_LITERAL() throws RecognitionException {
        match(39);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        char r10 = 3;
        if (r5 != 92) goto L40;
        int r11 = this.input.LA(2);
        if (r11 != 39) goto L27;
        int r12 = this.input.LA(3);
        if (r12 == 39) goto L12;
    L14:
        if (r12 == 92) goto L16;
    L18:
        if (r12 < 0) goto L20;
        if (r12 > 38) goto L20;
    L25:
        if (synpred5_ANTLRLexer() == true) goto L13;
    L46:
        r10 = 2;
    L47:
        if (r10 != 1) goto L48;
        mACTION_ESC();
        if (this.state.failed == false) goto L5;
        return;
    L48:
        if (r10 != 2) goto L49;
        if (this.input.LA(1) < 0) goto L56;
        if (this.input.LA(1) > 38) goto L56;
    L59:
        this.input.consume();
        this.state.failed = false;
    L56:
        if (this.input.LA(1) < 40) goto L60;
        if (this.input.LA(1) <= 65535) goto L59;
    L60:
        RecognizerSharedState r13 = this.state;
        if (r13.backtracking <= 0) goto L64;
        r13.failed = true;
        return;
    L64:
        MismatchedSetException r14 = new MismatchedSetException(null, this.input);
        recover(r14);
        throw r14;
    L49:
        match(39);
        boolean r15 = this.state.failed;
        return;
    L13:
        r10 = 1;
    L20:
        if (r12 < 40) goto L22;
        if (r12 <= 91) goto L25;
    L22:
        if (r12 < 93) goto L46;
        if (r12 > 65535) goto L46;
    L16:
        if (synpred5_ANTLRLexer() == false) goto L18;
    L12:
        if (synpred5_ANTLRLexer() == false) goto L14;
    L27:
        if (r11 != 92) goto L31;
        this.input.LA(3);
        if (synpred5_ANTLRLexer() == false) goto L46;
    L31:
        if (r11 < 0) goto L33;
        if (r11 > 38) goto L33;
    L37:
        this.input.LA(3);
        if (synpred5_ANTLRLexer() == false) goto L46;
    L33:
        if (r11 < 40) goto L35;
        if (r11 <= 91) goto L37;
    L35:
        if (r11 < 93) goto L47;
        if (r11 > 65535) goto L47;
    L40:
        if (r5 < 0) goto L42;
        if (r5 <= 38) goto L46;
    L42:
        if (r5 < 40) goto L44;
        if (r5 <= 91) goto L46;
    L44:
        if (r5 < 93) goto L47;
        if (r5 > 65535) goto L47;
        goto L46
    }

    public final void mACTION_ESC() throws RecognitionException {
        match(92);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        matchAny();
        boolean r5 = this.state.failed;
    }

    public final void mACTION_STRING_LITERAL() throws RecognitionException {
        match(34);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        char r10 = 3;
        if (r5 != 92) goto L40;
        int r11 = this.input.LA(2);
        if (r11 != 34) goto L27;
        int r12 = this.input.LA(3);
        if (r12 == 34) goto L12;
    L14:
        if (r12 == 92) goto L16;
    L18:
        if (r12 < 0) goto L20;
        if (r12 > 33) goto L20;
    L25:
        if (synpred6_ANTLRLexer() == true) goto L13;
    L46:
        r10 = 2;
    L47:
        if (r10 != 1) goto L48;
        mACTION_ESC();
        if (this.state.failed == false) goto L5;
        return;
    L48:
        if (r10 != 2) goto L49;
        if (this.input.LA(1) < 0) goto L56;
        if (this.input.LA(1) > 33) goto L56;
    L59:
        this.input.consume();
        this.state.failed = false;
    L56:
        if (this.input.LA(1) < 35) goto L60;
        if (this.input.LA(1) <= 65535) goto L59;
    L60:
        RecognizerSharedState r13 = this.state;
        if (r13.backtracking <= 0) goto L64;
        r13.failed = true;
        return;
    L64:
        MismatchedSetException r14 = new MismatchedSetException(null, this.input);
        recover(r14);
        throw r14;
    L49:
        match(34);
        boolean r15 = this.state.failed;
        return;
    L13:
        r10 = 1;
    L20:
        if (r12 < 35) goto L22;
        if (r12 <= 91) goto L25;
    L22:
        if (r12 < 93) goto L46;
        if (r12 > 65535) goto L46;
    L16:
        if (synpred6_ANTLRLexer() == false) goto L18;
    L12:
        if (synpred6_ANTLRLexer() == false) goto L14;
    L27:
        if (r11 != 92) goto L31;
        this.input.LA(3);
        if (synpred6_ANTLRLexer() == false) goto L46;
    L31:
        if (r11 < 0) goto L33;
        if (r11 > 33) goto L33;
    L37:
        this.input.LA(3);
        if (synpred6_ANTLRLexer() == false) goto L46;
    L33:
        if (r11 < 35) goto L35;
        if (r11 <= 91) goto L37;
    L35:
        if (r11 < 93) goto L47;
        if (r11 > 65535) goto L47;
    L40:
        if (r5 < 0) goto L42;
        if (r5 <= 33) goto L46;
    L42:
        if (r5 < 35) goto L44;
        if (r5 <= 91) goto L46;
    L44:
        if (r5 < 93) goto L47;
        if (r5 > 65535) goto L47;
        goto L46
    }

    public final void mARG_ACTION() throws RecognitionException {
        match(91);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        if (r5 != 91) goto L9;
        char r10 = 1;
    L34:
        if (r10 != 1) goto L35;
        mARG_ACTION();
        if (this.state.failed == false) goto L5;
        return;
    L35:
        if (r10 != 2) goto L36;
        mACTION_STRING_LITERAL();
        if (this.state.failed == false) goto L5;
        return;
    L36:
        if (r10 != 3) goto L37;
        mACTION_CHAR_LITERAL();
        if (this.state.failed == false) goto L5;
        return;
    L37:
        if (r10 != 4) goto L38;
        if (this.input.LA(1) < 0) goto L45;
        if (this.input.LA(1) > 90) goto L45;
    L57:
        this.input.consume();
        this.state.failed = false;
    L45:
        if (this.input.LA(1) == 92) goto L57;
        if (this.input.LA(1) < 94) goto L51;
        if (this.input.LA(1) <= 65535) goto L57;
    L51:
        RecognizerSharedState r11 = this.state;
        if (r11.backtracking <= 0) goto L55;
        r11.failed = true;
        return;
    L55:
        MismatchedSetException r12 = new MismatchedSetException(null, this.input);
        recover(r12);
        throw r12;
    L38:
        match(93);
        boolean r13 = this.state.failed;
        return;
    L9:
        if (r5 != 34) goto L14;
        this.input.LA(2);
        if (synpred2_ANTLRLexer() == false) goto L33;
        r10 = 2;
    L33:
        r10 = 4;
        goto L34
    L14:
        if (r5 != 39) goto L18;
        this.input.LA(2);
        if (synpred3_ANTLRLexer() == false) goto L33;
        r10 = 3;
        goto L34
    L18:
        if (r5 < 0) goto L22;
        if (r5 <= 33) goto L33;
    L22:
        if (r5 < 35) goto L26;
        if (r5 <= 38) goto L33;
    L26:
        if (r5 < 40) goto L28;
        if (r5 <= 90) goto L33;
    L28:
        if (r5 == 92) goto L33;
        if (r5 < 94) goto L32;
        if (r5 <= 65535) goto L33;
    L32:
        r10 = 5;
        goto L34
    }

    public final void mARG_OR_CHARSET() throws RecognitionException {
        if (this.input.LA(1) != 91) goto L11;
        boolean r5 = this.isLexerRule;
        if (r5 == false) goto L7;
        if (r5 == false) goto L11;
    L7:
        this.input.LA(2);
        boolean r10 = this.isLexerRule;
        if (r10 == false) goto L10;
        char r11 = 1;
    L23:
        if (r11 == 1) goto L41;
        if (r11 == 2) goto L27;
    L54:
        int r12 = 9;
    L55:
        RecognizerSharedState r13 = this.state;
        r13.type = r12;
        r13.channel = 0;
        return;
    L27:
        if (this.isLexerRule == false) goto L34;
        RecognizerSharedState r14 = this.state;
        if (r14.backtracking <= 0) goto L33;
        r14.failed = true;
        return;
    L33:
        throw new FailedPredicateException(this.input, "ARG_OR_CHARSET", "!isLexerRule");
    L34:
        mARG_ACTION();
        RecognizerSharedState r15 = this.state;
        if (r15.failed == false) goto L38;
        return;
    L38:
        if (r15.backtracking != 0) goto L54;
        String r16 = getText();
        setText(r16.substring(1, r16.length() - 1));
        r12 = 8;
        goto L55
    L41:
        if (this.isLexerRule == true) goto L48;
        RecognizerSharedState r17 = this.state;
        if (r17.backtracking <= 0) goto L47;
        r17.failed = true;
        return;
    L47:
        throw new FailedPredicateException(this.input, "ARG_OR_CHARSET", "isLexerRule");
    L48:
        mLEXER_CHAR_SET();
        RecognizerSharedState r18 = this.state;
        if (r18.failed == false) goto L52;
        return;
    L52:
        if (r18.backtracking != 0) goto L54;
        r12 = 32;
        goto L55
    L10:
        if (r10 == false) goto L11;
        RecognizerSharedState r19 = this.state;
        if (r19.backtracking <= 0) goto L16;
        r19.failed = true;
        return;
    L16:
        int r20 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L19
        throw new NoViableAltException("", 7, 1, this.input);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.input.rewind(r20);
        throw th;
    L11:
        r11 = 2;
        goto L23
    }

    public final void mASSIGN() throws RecognitionException {
        match(61);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 10;
        r5.channel = 0;
    }

    public final void mAT() throws RecognitionException {
        match(64);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 11;
        r5.channel = 0;
    }

    public final void mCATCH() throws RecognitionException {
        match("catch");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 12;
        r5.channel = 0;
    }

    public final void mCHANNELS() throws RecognitionException {
        match("channels");
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        if (r5 < 9) goto L8;
        if (r5 > 10) goto L8;
    L12:
        if (this.input.LA(1) < 9) goto L16;
        if (this.input.LA(1) > 10) goto L16;
    L21:
        this.input.consume();
        this.state.failed = false;
    L16:
        if (this.input.LA(1) < 12) goto L20;
        if (this.input.LA(1) <= 13) goto L21;
    L20:
        if (this.input.LA(1) == 32) goto L21;
        RecognizerSharedState r10 = this.state;
        if (r10.backtracking <= 0) goto L26;
        r10.failed = true;
        return;
    L26:
        MismatchedSetException r11 = new MismatchedSetException(null, this.input);
        recover(r11);
        throw r11;
    L8:
        if (r5 < 12) goto L10;
        if (r5 <= 13) goto L12;
    L10:
        if (r5 == 32) goto L12;
        match(123);
        RecognizerSharedState r12 = this.state;
        if (r12.failed == false) goto L31;
        return;
    L31:
        r12.type = 13;
        r12.channel = 0;
    }

    public final void mCOLON() throws RecognitionException {
        match(58);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L6;
        return;
    L6:
        if (r5.backtracking != 0) goto L15;
        Token r10 = getRuleOrSubruleStartToken();
        if (r10 == null) goto L15;
        if (r10.getType() != 57) goto L13;
        this.isLexerRule = false;
        goto L15
    L13:
        if (r10.getType() != 66) goto L15;
        this.isLexerRule = true;
    L15:
        RecognizerSharedState r11 = this.state;
        r11.type = 14;
        r11.channel = 0;
    }

    public final void mCOLONCOLON() throws RecognitionException {
        match("::");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 15;
        r5.channel = 0;
    }

    public final void mCOMMA() throws RecognitionException {
        match(44);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 16;
        r5.channel = 0;
    }

    public final void mCOMMENT() throws RecognitionException {
        int r5 = this.state.tokenStartLine;
        getCharPositionInLine();
        match(47);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r10 = this.input.LA(1);
        int r11 = 2;
        if (r10 == 42) goto L10;
        if (r10 == 47) goto L9;
        char r12 = 3;
    L11:
        int r13 = 17;
        if (r12 == 1) goto L77;
        if (r12 == 2) goto L17;
        if (r12 != 3) goto L116;
        int r14 = this.state.backtracking;
    L116:
        RecognizerSharedState r15 = this.state;
        if (r15.backtracking == 0) goto L120;
        r11 = 0;
    L120:
        r15.type = r13;
        r15.channel = r11;
        return;
    L17:
        match(42);
        if (this.state.failed == false) goto L21;
        return;
    L21:
        if (this.input.LA(1) != 42) goto L38;
        this.input.LA(2);
        if (this.input.LA(2) == 47) goto L38;
        if (this.input.LA(2) != 47) goto L32;
        RecognizerSharedState r16 = this.state;
        if (r16.backtracking <= 0) goto L31;
        r16.failed = true;
        return;
    L31:
        throw new FailedPredicateException(this.input, "COMMENT", " input.LA(2) != '/'");
    L32:
        match(42);
        RecognizerSharedState r17 = this.state;
        if (r17.failed == false) goto L36;
        return;
    L36:
        if (r17.backtracking != 0) goto L38;
        r13 = 18;
    L38:
        int r18 = this.input.LA(1);
        if (r18 == 42) goto L41;
        if (r18 < 0) goto L51;
        if (r18 > 41) goto L51;
    L54:
        if (this.input.LA(1) == 42) goto L56;
    L63:
        matchAny();
        if (this.state.failed == false) goto L38;
        return;
    L56:
        if (this.input.LA(2) != 47) goto L63;
        RecognizerSharedState r19 = this.state;
        if (r19.backtracking <= 0) goto L62;
        r19.failed = true;
        return;
    L62:
        throw new FailedPredicateException(this.input, "COMMENT", "    !(input.LA(1) == '*' && input.LA(2) == '/') ");
    L51:
        if (r18 < 43) goto L67;
        if (r18 <= 65535) goto L54;
    L67:
        if (this.input.LA(1) != 42) goto L69;
        char r20 = 1;
    L70:
        if (r20 == 1) goto L74;
        if (r20 != 2) goto L116;
        int r21 = this.state.backtracking;
        goto L116
    L74:
        match("*/");
        if (this.state.failed == false) goto L116;
        return;
    L69:
        r20 = 2;
        goto L70
    L41:
        if (this.input.LA(2) != 47) goto L54;
        this.input.LA(3);
        if (this.input.LA(1) != 42) goto L54;
        if (this.input.LA(2) == 47) goto L67;
    L77:
        match(47);
        if (this.state.failed == false) goto L80;
        return;
    L80:
        int r22 = this.dfa2.predict(this.input);
        if (r22 == 1) goto L110;
        if (r22 != 2) goto L116;
    L84:
        int r23 = this.input.LA(1);
        if (r23 < 0) goto L87;
        if (r23 > 9) goto L87;
    L92:
        if (this.input.LA(1) < 0) goto L96;
        if (this.input.LA(1) > 9) goto L96;
    L103:
        this.input.consume();
        this.state.failed = false;
    L96:
        if (this.input.LA(1) < 11) goto L100;
        if (this.input.LA(1) <= 12) goto L103;
    L100:
        if (this.input.LA(1) < 14) goto L104;
        if (this.input.LA(1) <= 65535) goto L103;
    L104:
        RecognizerSharedState r24 = this.state;
        if (r24.backtracking <= 0) goto L108;
        r24.failed = true;
        return;
    L108:
        MismatchedSetException r25 = new MismatchedSetException(null, this.input);
        recover(r25);
        throw r25;
    L87:
        if (r23 < 11) goto L89;
        if (r23 <= 12) goto L92;
    L89:
        if (r23 < 14) goto L116;
        if (r23 > 65535) goto L116;
    L110:
        match(" $ANTLR");
        if (this.state.failed == false) goto L113;
        return;
    L113:
        mSRC();
        if (this.state.failed == false) goto L116;
        return;
    L9:
        r12 = 1;
        goto L11
    L10:
        r12 = 2;
        goto L11
    }

    public final void mDOC_COMMENT() throws RecognitionException {
    }

    public final void mDOLLAR() throws RecognitionException {
        match(36);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 19;
        r5.channel = 0;
    }

    public final void mDOT() throws RecognitionException {
        match(46);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 20;
        r5.channel = 0;
    }

    public final void mERRCHAR() throws RecognitionException {
        matchAny();
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L6;
        return;
    L6:
        if (r5.backtracking != 0) goto L8;
        CommonToken r10 = new CommonToken(this.input, r5.type, r5.channel, r5.tokenStartCharIndex, getCharIndex() - 1);
        r10.setLine(this.state.tokenStartLine);
        r10.setText(this.state.text);
        r10.setCharPositionInLine(this.state.tokenStartCharPositionInLine);
        grammarError(ErrorType.SYNTAX_ERROR, r10, new Object[]{getTokenErrorDisplay(r10) + " came as a complete surprise to me"});
        this.state.syntaxErrors++;
        skip();
    L8:
        RecognizerSharedState r11 = this.state;
        r11.type = 21;
        r11.channel = 0;
    }

    public final void mESC_SEQ() throws RecognitionException {
        match(92);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        if (r5 != 98) goto L8;
        char r10 = 1;
    L57:
        switch(r10) {
            case 1: goto L116;
            case 2: goto L114;
            case 3: goto L112;
            case 4: goto L110;
            case 5: goto L108;
            case 6: goto L106;
            case 7: goto L104;
            case 8: goto L102;
            case 9: goto L100;
            case 10: goto L60;
            default: goto L119;
        };
    L100:
        mUNICODE_EXTENDED_ESC();
        boolean r11 = this.state.failed;
        return;
    L102:
        mUNICODE_ESC();
        boolean r12 = this.state.failed;
        return;
    L104:
        match(92);
        boolean r13 = this.state.failed;
        return;
    L106:
        match(39);
        boolean r14 = this.state.failed;
        return;
    L108:
        match(114);
        boolean r15 = this.state.failed;
        return;
    L110:
        match(102);
        boolean r16 = this.state.failed;
        return;
    L112:
        match(110);
        boolean r17 = this.state.failed;
        return;
    L114:
        match(116);
        boolean r18 = this.state.failed;
        return;
    L116:
        match(98);
        boolean r19 = this.state.failed;
        return;
    L119:
        return;
    L60:
        if (this.input.LA(1) < 0) goto L64;
        if (this.input.LA(1) > 38) goto L64;
    L96:
        this.input.consume();
        RecognizerSharedState r20 = this.state;
        r20.failed = false;
        if (r20.backtracking != 0) goto L118;
        CommonToken r21 = new CommonToken(this.input, r20.type, r20.channel, getCharIndex() - 2, getCharIndex() - 1);
        r21.setText(r21.getText());
        r21.setLine(this.input.getLine());
        r21.setCharPositionInLine(this.input.getCharPositionInLine() - 2);
        grammarError(ErrorType.INVALID_ESCAPE_SEQUENCE, r21, new Object[]{this.input.substring(getCharIndex() - 2, getCharIndex() - 1)});
        return;
    L118:
        return;
    L64:
        if (this.input.LA(1) < 40) goto L68;
        if (this.input.LA(1) <= 91) goto L96;
    L68:
        if (this.input.LA(1) < 93) goto L72;
        if (this.input.LA(1) <= 97) goto L96;
    L72:
        if (this.input.LA(1) < 99) goto L76;
        if (this.input.LA(1) <= 101) goto L96;
    L76:
        if (this.input.LA(1) < 103) goto L80;
        if (this.input.LA(1) <= 109) goto L96;
    L80:
        if (this.input.LA(1) < 111) goto L84;
        if (this.input.LA(1) <= 113) goto L96;
    L84:
        if (this.input.LA(1) == 115) goto L96;
        if (this.input.LA(1) >= 118) goto L88;
    L90:
        RecognizerSharedState r22 = this.state;
        if (r22.backtracking <= 0) goto L94;
        r22.failed = true;
        return;
    L94:
        MismatchedSetException r23 = new MismatchedSetException(null, this.input);
        recover(r23);
        throw r23;
    L88:
        if (this.input.LA(1) > 65535) goto L90;
    L8:
        if (r5 != 116) goto L10;
        r10 = 2;
        goto L57
    L10:
        if (r5 != 110) goto L12;
        r10 = 3;
        goto L57
    L12:
        if (r5 != 102) goto L14;
        r10 = 4;
        goto L57
    L14:
        if (r5 != 114) goto L16;
        r10 = 5;
        goto L57
    L16:
        if (r5 != 39) goto L18;
        r10 = 6;
        goto L57
    L18:
        if (r5 != 92) goto L21;
        r10 = 7;
        goto L57
    L21:
        if (r5 == 117) goto L23;
        if (r5 < 0) goto L28;
        if (r5 > 38) goto L28;
    L56:
        r10 = '\n';
    L28:
        if (r5 < 40) goto L30;
        if (r5 <= 91) goto L56;
    L30:
        if (r5 < 93) goto L32;
        if (r5 <= 97) goto L56;
    L32:
        if (r5 < 99) goto L36;
        if (r5 <= 101) goto L56;
    L36:
        if (r5 < 103) goto L40;
        if (r5 <= 109) goto L56;
    L40:
        if (r5 < 111) goto L44;
        if (r5 <= 113) goto L56;
    L44:
        if (r5 == 115) goto L56;
        if (r5 >= 118) goto L48;
    L50:
        RecognizerSharedState r24 = this.state;
        if (r24.backtracking <= 0) goto L55;
        r24.failed = true;
        return;
    L55:
        throw new NoViableAltException("", 28, 0, this.input);
    L48:
        if (r5 > 65535) goto L50;
    L23:
        if (this.input.LA(2) != 123) goto L25;
        r10 = '\t';
        goto L57
    L25:
        r10 = '\b';
        goto L57
    }

    public final void mFINALLY() throws RecognitionException {
        match("finally");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 23;
        r5.channel = 0;
    }

    public final void mFRAGMENT() throws RecognitionException {
        match("fragment");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 24;
        r5.channel = 0;
    }

    public final void mGRAMMAR() throws RecognitionException {
        match("grammar");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 25;
        r5.channel = 0;
    }

    public final void mGT() throws RecognitionException {
        match(62);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 26;
        r5.channel = 0;
    }

    public final void mHEX_DIGIT() throws RecognitionException {
        if (this.input.LA(1) < 48) goto L7;
        if (this.input.LA(1) > 57) goto L7;
    L14:
        this.input.consume();
        this.state.failed = false;
        return;
    L7:
        if (this.input.LA(1) < 65) goto L11;
        if (this.input.LA(1) <= 70) goto L14;
    L11:
        if (this.input.LA(1) >= 97) goto L13;
    L16:
        RecognizerSharedState r5 = this.state;
        if (r5.backtracking <= 0) goto L20;
        r5.failed = true;
        return;
    L20:
        MismatchedSetException r10 = new MismatchedSetException(null, this.input);
        recover(r10);
        throw r10;
    L13:
        if (this.input.LA(1) > 102) goto L16;
        goto L14
    }

    public final void mID() throws RecognitionException {
        int r5 = getCharIndex();
        int r10 = getLine();
        int r11 = getCharPositionInLine();
        mNameStartChar();
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r12 = 1;
        CommonToken r13 = new CommonToken(this.input, 0, 0, r5, getCharIndex() - 1);
        r13.setLine(r10);
        r13.setCharPositionInLine(r11);
    L6:
        int r14 = this.input.LA(r12);
        int r15 = 57;
        if (r14 < 48) goto L9;
        if (r14 > 57) goto L9;
    L69:
        if (this.input.LA(1) < 48) goto L73;
        if (this.input.LA(1) > 57) goto L73;
    L139:
        this.input.consume();
        this.state.failed = false;
        r12 = 1;
    L73:
        if (this.input.LA(1) < 65) goto L77;
        if (this.input.LA(1) <= 90) goto L139;
    L77:
        if (this.input.LA(1) == 95) goto L139;
        if (this.input.LA(1) < 97) goto L83;
        if (this.input.LA(1) <= 122) goto L139;
    L83:
        if (this.input.LA(1) == 183) goto L139;
        if (this.input.LA(1) < 192) goto L89;
        if (this.input.LA(1) <= 214) goto L139;
    L89:
        if (this.input.LA(1) < 216) goto L93;
        if (this.input.LA(1) <= 246) goto L139;
    L93:
        if (this.input.LA(1) < 248) goto L97;
        if (this.input.LA(1) <= 893) goto L139;
    L97:
        if (this.input.LA(1) < 895) goto L101;
        if (this.input.LA(1) <= 8191) goto L139;
    L101:
        if (this.input.LA(1) < 8204) goto L105;
        if (this.input.LA(1) <= 8205) goto L139;
    L105:
        if (this.input.LA(1) < 8255) goto L109;
        if (this.input.LA(1) <= 8256) goto L139;
    L109:
        if (this.input.LA(1) < 8304) goto L113;
        if (this.input.LA(1) <= 8591) goto L139;
    L113:
        if (this.input.LA(1) < 11264) goto L117;
        if (this.input.LA(1) <= 12271) goto L139;
    L117:
        if (this.input.LA(1) < 12289) goto L121;
        if (this.input.LA(1) <= 55295) goto L139;
    L121:
        if (this.input.LA(1) < 63744) goto L125;
        if (this.input.LA(1) <= 64975) goto L139;
    L125:
        if (this.input.LA(1) < 65008) goto L129;
        if (this.input.LA(1) <= 65278) goto L139;
    L129:
        if (this.input.LA(1) < 65280) goto L133;
        if (this.input.LA(1) <= 65533) goto L139;
    L133:
        RecognizerSharedState r16 = this.state;
        if (r16.backtracking <= 0) goto L137;
        r16.failed = true;
        return;
    L137:
        MismatchedSetException r17 = new MismatchedSetException(null, this.input);
        recover(r17);
        throw r17;
    L9:
        if (r14 < 65) goto L11;
        if (r14 <= 90) goto L69;
    L11:
        if (r14 == 95) goto L69;
        if (r14 < 97) goto L14;
        if (r14 <= 122) goto L69;
    L14:
        if (r14 == 183) goto L69;
        if (r14 < 192) goto L17;
        if (r14 <= 214) goto L69;
    L17:
        if (r14 < 216) goto L20;
        if (r14 <= 246) goto L69;
    L20:
        if (r14 < 248) goto L24;
        if (r14 <= 893) goto L69;
    L24:
        if (r14 < 895) goto L28;
        if (r14 <= 8191) goto L69;
    L28:
        if (r14 < 8204) goto L32;
        if (r14 <= 8205) goto L69;
    L32:
        if (r14 < 8255) goto L36;
        if (r14 <= 8256) goto L69;
    L36:
        if (r14 < 8304) goto L40;
        if (r14 <= 8591) goto L69;
    L40:
        if (r14 < 11264) goto L44;
        if (r14 <= 12271) goto L69;
    L44:
        if (r14 < 12289) goto L48;
        if (r14 <= 55295) goto L69;
    L48:
        if (r14 < 63744) goto L52;
        if (r14 <= 64975) goto L69;
    L52:
        if (r14 < 65008) goto L56;
        if (r14 <= 65278) goto L69;
    L56:
        if (r14 < 65280) goto L61;
        if (r14 <= 65533) goto L69;
    L61:
        if (this.state.backtracking == 0) goto L63;
        r15 = 28;
    L66:
        RecognizerSharedState r18 = this.state;
        r18.type = r15;
        r18.channel = 0;
        return;
    L63:
        if (Grammar.isTokenName(r13.getText()) == false) goto L66;
        r15 = 66;
        goto L66
    }

    public final void mIMPORT() throws RecognitionException {
        match("import");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 29;
        r5.channel = 0;
    }

    public final void mINT() throws RecognitionException {
        int r5 = 0;
    L3:
        int r10 = this.input.LA(1);
        if (r10 < 48) goto L18;
        if (r10 > 57) goto L18;
        if (this.input.LA(1) < 48) goto L12;
        if (this.input.LA(1) > 57) goto L12;
        this.input.consume();
        this.state.failed = false;
        r5 = r5 + 1;
    L12:
        RecognizerSharedState r11 = this.state;
        if (r11.backtracking <= 0) goto L16;
        r11.failed = true;
        return;
    L16:
        MismatchedSetException r12 = new MismatchedSetException(null, this.input);
        recover(r12);
        throw r12;
    L18:
        if (r5 < 1) goto L21;
        RecognizerSharedState r13 = this.state;
        r13.type = 30;
        r13.channel = 0;
        return;
    L21:
        RecognizerSharedState r14 = this.state;
        if (r14.backtracking <= 0) goto L26;
        r14.failed = true;
        return;
    L26:
        throw new EarlyExitException(22, this.input);
    }

    public final void mLEXER() throws RecognitionException {
        match("lexer");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 31;
        r5.channel = 0;
    }

    public final void mLEXER_CHAR_SET() throws RecognitionException {
        match(91);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        if (r5 != 92) goto L8;
        char r10 = 1;
    L19:
        if (r10 != 1) goto L20;
        match(92);
        if (this.state.failed == true) goto L48;
        if (this.input.LA(1) < 0) goto L54;
        if (this.input.LA(1) > 9) goto L54;
    L61:
        this.input.consume();
        this.state.failed = false;
    L54:
        if (this.input.LA(1) < 11) goto L58;
        if (this.input.LA(1) <= 12) goto L61;
    L58:
        if (this.input.LA(1) < 14) goto L62;
        if (this.input.LA(1) <= 65535) goto L61;
    L62:
        RecognizerSharedState r11 = this.state;
        if (r11.backtracking <= 0) goto L66;
        r11.failed = true;
        return;
    L66:
        MismatchedSetException r12 = new MismatchedSetException(null, this.input);
        recover(r12);
        throw r12;
    L48:
        return;
    L20:
        if (r10 != 2) goto L21;
        if (this.input.LA(1) < 0) goto L28;
        if (this.input.LA(1) > 9) goto L28;
    L39:
        this.input.consume();
        this.state.failed = false;
    L28:
        if (this.input.LA(1) < 11) goto L32;
        if (this.input.LA(1) <= 12) goto L39;
    L32:
        if (this.input.LA(1) < 14) goto L36;
        if (this.input.LA(1) <= 91) goto L39;
    L36:
        if (this.input.LA(1) < 94) goto L40;
        if (this.input.LA(1) <= 65535) goto L39;
    L40:
        RecognizerSharedState r13 = this.state;
        if (r13.backtracking <= 0) goto L44;
        r13.failed = true;
        return;
    L44:
        MismatchedSetException r14 = new MismatchedSetException(null, this.input);
        recover(r14);
        throw r14;
    L21:
        match(93);
        boolean r15 = this.state.failed;
        return;
    L8:
        if (r5 < 0) goto L10;
        if (r5 > 9) goto L10;
    L16:
        r10 = 2;
    L10:
        if (r5 < 11) goto L12;
        if (r5 <= 12) goto L16;
    L12:
        if (r5 < 14) goto L14;
        if (r5 <= 91) goto L16;
    L14:
        if (r5 < 94) goto L17;
        if (r5 <= 65535) goto L16;
    L17:
        r10 = 3;
        goto L19
    }

    public final void mLOCALS() throws RecognitionException {
        match("locals");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 33;
        r5.channel = 0;
    }

    public final void mLPAREN() throws RecognitionException {
        match(40);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 34;
        r5.channel = 0;
    }

    public final void mLT() throws RecognitionException {
        match(60);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 35;
        r5.channel = 0;
    }

    public final void mMODE() throws RecognitionException {
        match("mode");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 36;
        r5.channel = 0;
    }

    public final void mNESTED_ACTION() throws RecognitionException {
        int r5 = getLine();
        int r10 = getCharPositionInLine();
        int r11 = 123;
        match(123);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r12 = this.input.LA(1);
        if (r12 != r11) goto L9;
        char r13 = 1;
    L38:
        switch(r13) {
            case 1: goto L98;
            case 2: goto L95;
            case 3: goto L92;
            case 4: goto L89;
            case 5: goto L86;
            case 6: goto L53;
            default: goto L40;
        };
    L86:
        mACTION_ESC();
        if (this.state.failed == false) goto L101;
        return;
    L101:
        r11 = 123;
        goto L5
    L89:
        mACTION_STRING_LITERAL();
        if (this.state.failed == false) goto L101;
        return;
    L92:
        mCOMMENT();
        if (this.state.failed == false) goto L101;
        return;
    L95:
        mACTION_CHAR_LITERAL();
        if (this.state.failed == false) goto L101;
        return;
    L98:
        mNESTED_ACTION();
        if (this.state.failed == false) goto L101;
        return;
    L53:
        if (this.input.LA(1) < 0) goto L57;
        if (this.input.LA(1) > 33) goto L57;
    L85:
        this.input.consume();
        this.state.failed = false;
    L57:
        if (this.input.LA(1) < 35) goto L61;
        if (this.input.LA(1) <= 38) goto L85;
    L61:
        if (this.input.LA(1) < 40) goto L65;
        if (this.input.LA(1) <= 46) goto L85;
    L65:
        if (this.input.LA(1) < 48) goto L69;
        if (this.input.LA(1) <= 91) goto L85;
    L69:
        if (this.input.LA(1) < 93) goto L73;
        if (this.input.LA(1) <= 122) goto L85;
    L73:
        if (this.input.LA(1) == 124) goto L85;
        if (this.input.LA(1) < 126) goto L79;
        if (this.input.LA(1) <= 65535) goto L85;
    L79:
        RecognizerSharedState r14 = this.state;
        if (r14.backtracking <= 0) goto L83;
        r14.failed = true;
        return;
    L83:
        MismatchedSetException r15 = new MismatchedSetException(null, this.input);
        recover(r15);
        throw r15;
    L40:
        if (this.input.LA(1) != 125) goto L42;
        char r16 = 1;
    L43:
        if (r16 == 1) goto L50;
        if (r16 == 2) goto L47;
        return;
    L47:
        if (this.state.backtracking != 0) goto L116;
        PrintStream r17 = System.out;
        StringBuilder r18 = j0.s(r5, "Block starting  at line ", " offset ");
        r18.append(r10 + 1);
        r18.append(" contains imbalanced {} or is missing a }");
        r17.println(r18.toString());
        return;
    L116:
        return;
    L50:
        match(125);
        boolean r19 = this.state.failed;
        return;
    L42:
        r16 = 2;
        goto L43
    L9:
        if (r12 != 39) goto L12;
        r13 = 2;
        goto L38
    L12:
        if (r12 != 47) goto L15;
        r13 = 3;
        goto L38
    L15:
        if (r12 != 34) goto L18;
        r13 = 4;
        goto L38
    L18:
        if (r12 != 92) goto L20;
        r13 = 5;
        goto L38
    L20:
        if (r12 < 0) goto L22;
        if (r12 > 33) goto L22;
    L37:
        r13 = 6;
    L22:
        if (r12 < 35) goto L24;
        if (r12 <= 38) goto L37;
    L24:
        if (r12 < 40) goto L26;
        if (r12 <= 46) goto L37;
    L26:
        if (r12 < 48) goto L28;
        if (r12 <= 91) goto L37;
    L28:
        if (r12 < 93) goto L30;
        if (r12 <= 122) goto L37;
    L30:
        if (r12 == 124) goto L37;
        if (r12 >= 126) goto L34;
    L36:
        r13 = 7;
        goto L38
    L34:
        if (r12 > 65535) goto L36;
        goto L36
    }

    public final void mNLCHARS() throws RecognitionException {
        if (this.input.LA(1) != 10) goto L5;
    L13:
        this.input.consume();
        this.state.failed = false;
        return;
    L5:
        if (this.input.LA(1) == 13) goto L13;
        RecognizerSharedState r5 = this.state;
        if (r5.backtracking <= 0) goto L11;
        r5.failed = true;
        return;
    L11:
        MismatchedSetException r10 = new MismatchedSetException(null, this.input);
        recover(r10);
        throw r10;
    }

    public final void mNOT() throws RecognitionException {
        match(126);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 39;
        r5.channel = 0;
    }

    public final void mNameChar() throws RecognitionException {
        if (this.input.LA(1) < 48) goto L7;
        if (this.input.LA(1) > 57) goto L7;
    L73:
        this.input.consume();
        this.state.failed = false;
        return;
    L7:
        if (this.input.LA(1) < 65) goto L11;
        if (this.input.LA(1) <= 90) goto L73;
    L11:
        if (this.input.LA(1) == 95) goto L73;
        if (this.input.LA(1) < 97) goto L17;
        if (this.input.LA(1) <= 122) goto L73;
    L17:
        if (this.input.LA(1) == 183) goto L73;
        if (this.input.LA(1) < 192) goto L23;
        if (this.input.LA(1) <= 214) goto L73;
    L23:
        if (this.input.LA(1) < 216) goto L27;
        if (this.input.LA(1) <= 246) goto L73;
    L27:
        if (this.input.LA(1) < 248) goto L31;
        if (this.input.LA(1) <= 893) goto L73;
    L31:
        if (this.input.LA(1) < 895) goto L35;
        if (this.input.LA(1) <= 8191) goto L73;
    L35:
        if (this.input.LA(1) < 8204) goto L39;
        if (this.input.LA(1) <= 8205) goto L73;
    L39:
        if (this.input.LA(1) < 8255) goto L43;
        if (this.input.LA(1) <= 8256) goto L73;
    L43:
        if (this.input.LA(1) < 8304) goto L47;
        if (this.input.LA(1) <= 8591) goto L73;
    L47:
        if (this.input.LA(1) < 11264) goto L51;
        if (this.input.LA(1) <= 12271) goto L73;
    L51:
        if (this.input.LA(1) < 12289) goto L55;
        if (this.input.LA(1) <= 55295) goto L73;
    L55:
        if (this.input.LA(1) < 63744) goto L59;
        if (this.input.LA(1) <= 64975) goto L73;
    L59:
        if (this.input.LA(1) < 65008) goto L63;
        if (this.input.LA(1) <= 65278) goto L73;
    L63:
        if (this.input.LA(1) >= 65280) goto L65;
    L67:
        RecognizerSharedState r5 = this.state;
        if (r5.backtracking <= 0) goto L71;
        r5.failed = true;
        return;
    L71:
        MismatchedSetException r10 = new MismatchedSetException(null, this.input);
        recover(r10);
        throw r10;
    L65:
        if (this.input.LA(1) > 65533) goto L67;
        goto L67
    }

    public final void mNameStartChar() throws RecognitionException {
        if (this.input.LA(1) < 65) goto L7;
        if (this.input.LA(1) > 90) goto L7;
    L58:
        this.input.consume();
        this.state.failed = false;
        return;
    L7:
        if (this.input.LA(1) < 97) goto L11;
        if (this.input.LA(1) <= 122) goto L58;
    L11:
        if (this.input.LA(1) < 192) goto L15;
        if (this.input.LA(1) <= 214) goto L58;
    L15:
        if (this.input.LA(1) < 216) goto L19;
        if (this.input.LA(1) <= 246) goto L58;
    L19:
        if (this.input.LA(1) < 248) goto L23;
        if (this.input.LA(1) <= 767) goto L58;
    L23:
        if (this.input.LA(1) < 880) goto L27;
        if (this.input.LA(1) <= 893) goto L58;
    L27:
        if (this.input.LA(1) < 895) goto L31;
        if (this.input.LA(1) <= 8191) goto L58;
    L31:
        if (this.input.LA(1) < 8204) goto L35;
        if (this.input.LA(1) <= 8205) goto L58;
    L35:
        if (this.input.LA(1) < 8304) goto L39;
        if (this.input.LA(1) <= 8591) goto L58;
    L39:
        if (this.input.LA(1) < 11264) goto L43;
        if (this.input.LA(1) <= 12271) goto L58;
    L43:
        if (this.input.LA(1) < 12289) goto L47;
        if (this.input.LA(1) <= 55295) goto L58;
    L47:
        if (this.input.LA(1) < 63744) goto L51;
        if (this.input.LA(1) <= 64975) goto L58;
    L51:
        if (this.input.LA(1) < 65008) goto L55;
        if (this.input.LA(1) <= 65278) goto L58;
    L55:
        if (this.input.LA(1) >= 65280) goto L57;
    L60:
        RecognizerSharedState r5 = this.state;
        if (r5.backtracking <= 0) goto L64;
        r5.failed = true;
        return;
    L64:
        MismatchedSetException r10 = new MismatchedSetException(null, this.input);
        recover(r10);
        throw r10;
    L57:
        if (this.input.LA(1) > 65533) goto L60;
        goto L58
    }

    public final void mOPTIONS() throws RecognitionException {
        match("options");
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        if (r5 < 9) goto L8;
        if (r5 > 10) goto L8;
    L12:
        if (this.input.LA(1) < 9) goto L16;
        if (this.input.LA(1) > 10) goto L16;
    L21:
        this.input.consume();
        this.state.failed = false;
    L16:
        if (this.input.LA(1) < 12) goto L20;
        if (this.input.LA(1) <= 13) goto L21;
    L20:
        if (this.input.LA(1) == 32) goto L21;
        RecognizerSharedState r10 = this.state;
        if (r10.backtracking <= 0) goto L26;
        r10.failed = true;
        return;
    L26:
        MismatchedSetException r11 = new MismatchedSetException(null, this.input);
        recover(r11);
        throw r11;
    L8:
        if (r5 < 12) goto L10;
        if (r5 <= 13) goto L12;
    L10:
        if (r5 == 32) goto L12;
        match(123);
        RecognizerSharedState r12 = this.state;
        if (r12.failed == false) goto L31;
        return;
    L31:
        r12.type = 42;
        r12.channel = 0;
    }

    public final void mOR() throws RecognitionException {
        match(124);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 43;
        r5.channel = 0;
    }

    public final void mPARSER() throws RecognitionException {
        match("parser");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 44;
        r5.channel = 0;
    }

    public final void mPLUS() throws RecognitionException {
        match(43);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 45;
        r5.channel = 0;
    }

    public final void mPLUS_ASSIGN() throws RecognitionException {
        match("+=");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 46;
        r5.channel = 0;
    }

    public final void mPOUND() throws RecognitionException {
        match(35);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 47;
        r5.channel = 0;
    }

    public final void mPRIVATE() throws RecognitionException {
        match("private");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 48;
        r5.channel = 0;
    }

    public final void mPROTECTED() throws RecognitionException {
        match("protected");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 49;
        r5.channel = 0;
    }

    public final void mPUBLIC() throws RecognitionException {
        match("public");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 50;
        r5.channel = 0;
    }

    public final void mQUESTION() throws RecognitionException {
        match(63);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 51;
        r5.channel = 0;
    }

    public final void mRANGE() throws RecognitionException {
        match("..");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 52;
        r5.channel = 0;
    }

    public final void mRARROW() throws RecognitionException {
        match("->");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 53;
        r5.channel = 0;
    }

    public final void mRBRACE() throws RecognitionException {
        match(125);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 54;
        r5.channel = 0;
    }

    public final void mRETURNS() throws RecognitionException {
        match("returns");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 55;
        r5.channel = 0;
    }

    public final void mRPAREN() throws RecognitionException {
        match(41);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 56;
        r5.channel = 0;
    }

    public final void mSEMI() throws RecognitionException {
        match(59);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 58;
        r5.channel = 0;
    }

    public final void mSRC() throws RecognitionException {
        match("src");
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = 0;
    L6:
        int r10 = this.input.LA(1);
        if (r10 == 9) goto L54;
        if (r10 == 12) goto L54;
        if (r10 == 32) goto L54;
        if (r5 < 1) goto L47;
        int r12 = getCharIndex();
        int r11 = getLine();
        int r13 = getCharPositionInLine();
        mACTION_STRING_LITERAL();
        if (this.state.failed == false) goto L15;
        return;
    L15:
        CommonToken r14 = new CommonToken(this.input, 0, 0, r12, getCharIndex() - 1);
        r14.setLine(r11);
        r14.setCharPositionInLine(r13);
        int r15 = 0;
    L16:
        int r16 = this.input.LA(1);
        if (r16 == 9) goto L34;
        if (r16 == 12) goto L34;
        if (r16 == 32) goto L34;
        if (r15 < 1) goto L27;
        int r17 = getCharIndex();
        int r18 = getLine();
        int r19 = getCharPositionInLine();
        mINT();
        if (this.state.failed == false) goto L25;
        return;
    L25:
        CommonToken r20 = new CommonToken(this.input, 0, 0, r17, getCharIndex() - 1);
        r20.setLine(r18);
        r20.setCharPositionInLine(r19);
        int r110 = this.state.backtracking;
        return;
    L27:
        RecognizerSharedState r21 = this.state;
        if (r21.backtracking <= 0) goto L32;
        r21.failed = true;
        return;
    L32:
        throw new EarlyExitException(24, this.input);
    L34:
        if (this.input.LA(1) == 9) goto L46;
        if (this.input.LA(1) == 12) goto L46;
        if (this.input.LA(1) == 32) goto L46;
        RecognizerSharedState r22 = this.state;
        if (r22.backtracking <= 0) goto L44;
        r22.failed = true;
        return;
    L44:
        MismatchedSetException r23 = new MismatchedSetException(null, this.input);
        recover(r23);
        throw r23;
    L46:
        this.input.consume();
        this.state.failed = false;
        r15 = r15 + 1;
        goto L16
    L47:
        RecognizerSharedState r24 = this.state;
        if (r24.backtracking <= 0) goto L52;
        r24.failed = true;
        return;
    L52:
        throw new EarlyExitException(23, this.input);
    L54:
        if (this.input.LA(1) == 9) goto L66;
        if (this.input.LA(1) == 12) goto L66;
        if (this.input.LA(1) == 32) goto L66;
        RecognizerSharedState r25 = this.state;
        if (r25.backtracking <= 0) goto L64;
        r25.failed = true;
        return;
    L64:
        MismatchedSetException r26 = new MismatchedSetException(null, this.input);
        recover(r26);
        throw r26;
    L66:
        this.input.consume();
        this.state.failed = false;
        r5 = r5 + 1;
        goto L6
    }

    public final void mSTAR() throws RecognitionException {
        match(42);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 61;
        r5.channel = 0;
    }

    public final void mSTRING_LITERAL() throws RecognitionException {
        match(39);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        if (r5 < 0) goto L8;
        if (r5 > 9) goto L8;
    L14:
        int r10 = this.input.LA(1);
        if (r10 != 92) goto L17;
        char r11 = 1;
    L28:
        if (r11 != 1) goto L29;
        mESC_SEQ();
        if (this.state.failed == false) goto L5;
        return;
    L29:
        if (r11 != 2) goto L5;
        if (this.input.LA(1) < 0) goto L36;
        if (this.input.LA(1) > 9) goto L36;
    L51:
        this.input.consume();
        this.state.failed = false;
    L36:
        if (this.input.LA(1) < 11) goto L40;
        if (this.input.LA(1) <= 12) goto L51;
    L40:
        if (this.input.LA(1) < 14) goto L44;
        if (this.input.LA(1) <= 38) goto L51;
    L44:
        if (this.input.LA(1) < 40) goto L48;
        if (this.input.LA(1) <= 91) goto L51;
    L48:
        if (this.input.LA(1) < 93) goto L52;
        if (this.input.LA(1) <= 65535) goto L51;
    L52:
        RecognizerSharedState r12 = this.state;
        if (r12.backtracking <= 0) goto L56;
        r12.failed = true;
        return;
    L56:
        MismatchedSetException r13 = new MismatchedSetException(null, this.input);
        recover(r13);
        throw r13;
    L17:
        if (r10 < 0) goto L19;
        if (r10 > 9) goto L19;
    L27:
        r11 = 2;
    L19:
        if (r10 < 11) goto L21;
        if (r10 <= 12) goto L27;
    L21:
        if (r10 < 14) goto L23;
        if (r10 <= 38) goto L27;
    L23:
        if (r10 < 40) goto L25;
        if (r10 <= 91) goto L27;
    L25:
        if (r10 < 93) goto L61;
        if (r10 <= 65535) goto L27;
    L61:
        RecognizerSharedState r14 = this.state;
        if (r14.backtracking <= 0) goto L66;
        r14.failed = true;
        return;
    L66:
        throw new NoViableAltException("", 25, 0, this.input);
    L8:
        if (r5 < 11) goto L10;
        if (r5 <= 12) goto L14;
    L10:
        if (r5 < 14) goto L12;
        if (r5 <= 38) goto L14;
    L12:
        if (r5 < 40) goto L68;
        if (r5 <= 65535) goto L14;
    L68:
        if (this.input.LA(1) != 39) goto L70;
        char r15 = 1;
    L71:
        if (r15 == 1) goto L77;
        if (r15 != 2) goto L80;
        RecognizerSharedState r16 = this.state;
        if (r16.backtracking != 0) goto L80;
        CommonToken r17 = new CommonToken(this.input, r16.type, r16.channel, r16.tokenStartCharIndex, getCharIndex() - 1);
        r17.setLine(this.state.tokenStartLine);
        r17.setText(this.state.text);
        r17.setCharPositionInLine(this.state.tokenStartCharPositionInLine);
        grammarError(ErrorType.UNTERMINATED_STRING_LITERAL, r17, new Object[0]);
    L80:
        RecognizerSharedState r18 = this.state;
        r18.type = 62;
        r18.channel = 0;
        return;
    L77:
        match(39);
        if (this.state.failed == false) goto L80;
        return;
    L70:
        r15 = 2;
        goto L71
    }

    public final void mSYNPRED() throws RecognitionException {
        match("=>");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        int r10 = 0;
        if (r5.backtracking != 0) goto L8;
        CommonToken r11 = new CommonToken(this.input, r5.type, r5.channel, r5.tokenStartCharIndex, getCharIndex() - 1);
        r11.setLine(this.state.tokenStartLine);
        r11.setText(this.state.text);
        r11.setCharPositionInLine(this.state.tokenStartCharPositionInLine);
        grammarError(ErrorType.V3_SYNPRED, r11, new Object[0]);
        r10 = 99;
    L8:
        RecognizerSharedState r12 = this.state;
        r12.type = 63;
        r12.channel = r10;
    }

    public final void mTHROWS() throws RecognitionException {
        match("throws");
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L5;
        return;
    L5:
        r5.type = 64;
        r5.channel = 0;
    }

    public final void mTOKENS_SPEC() throws RecognitionException {
        match(TestRig.LEXER_START_RULE_NAME);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        if (r5 < 9) goto L8;
        if (r5 > 10) goto L8;
    L12:
        if (this.input.LA(1) < 9) goto L16;
        if (this.input.LA(1) > 10) goto L16;
    L21:
        this.input.consume();
        this.state.failed = false;
    L16:
        if (this.input.LA(1) < 12) goto L20;
        if (this.input.LA(1) <= 13) goto L21;
    L20:
        if (this.input.LA(1) == 32) goto L21;
        RecognizerSharedState r10 = this.state;
        if (r10.backtracking <= 0) goto L26;
        r10.failed = true;
        return;
    L26:
        MismatchedSetException r11 = new MismatchedSetException(null, this.input);
        recover(r11);
        throw r11;
    L8:
        if (r5 < 12) goto L10;
        if (r5 <= 13) goto L12;
    L10:
        if (r5 == 32) goto L12;
        match(123);
        RecognizerSharedState r12 = this.state;
        if (r12.failed == false) goto L31;
        return;
    L31:
        r12.type = 65;
        r12.channel = 0;
    }

    public final void mTREE_GRAMMAR() throws RecognitionException {
        match("tree");
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        if (r5 < 9) goto L8;
        if (r5 > 10) goto L8;
    L12:
        if (this.input.LA(1) < 9) goto L16;
        if (this.input.LA(1) > 10) goto L16;
    L21:
        this.input.consume();
        this.state.failed = false;
    L16:
        if (this.input.LA(1) < 12) goto L20;
        if (this.input.LA(1) <= 13) goto L21;
    L20:
        if (this.input.LA(1) == 32) goto L21;
        RecognizerSharedState r10 = this.state;
        if (r10.backtracking <= 0) goto L26;
        r10.failed = true;
        return;
    L26:
        MismatchedSetException r11 = new MismatchedSetException(null, this.input);
        recover(r11);
        throw r11;
    L8:
        if (r5 < 12) goto L10;
        if (r5 <= 13) goto L12;
    L10:
        if (r5 == 32) goto L12;
        match("grammar");
        RecognizerSharedState r12 = this.state;
        if (r12.failed == false) goto L31;
        return;
    L31:
        r12.type = 67;
        r12.channel = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Lexer
    public void mTokens() throws RecognitionException {
        switch(this.dfa35.predict(this.input)) {
            case 1: goto L103;
            case 2: goto L101;
            case 3: goto L99;
            case 4: goto L97;
            case 5: goto L95;
            case 6: goto L93;
            case 7: goto L91;
            case 8: goto L89;
            case 9: goto L87;
            case 10: goto L85;
            case 11: goto L83;
            case 12: goto L81;
            case 13: goto L79;
            case 14: goto L77;
            case 15: goto L75;
            case 16: goto L73;
            case 17: goto L71;
            case 18: goto L69;
            case 19: goto L67;
            case 20: goto L65;
            case 21: goto L63;
            case 22: goto L61;
            case 23: goto L59;
            case 24: goto L57;
            case 25: goto L55;
            case 26: goto L53;
            case 27: goto L51;
            case 28: goto L49;
            case 29: goto L47;
            case 30: goto L45;
            case 31: goto L43;
            case 32: goto L41;
            case 33: goto L39;
            case 34: goto L37;
            case 35: goto L35;
            case 36: goto L33;
            case 37: goto L31;
            case 38: goto L29;
            case 39: goto L27;
            case 40: goto L25;
            case 41: goto L23;
            case 42: goto L21;
            case 43: goto L19;
            case 44: goto L17;
            case 45: goto L15;
            case 46: goto L13;
            case 47: goto L11;
            case 48: goto L9;
            case 49: goto L7;
            case 50: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        mERRCHAR();
        boolean r5 = this.state.failed;
        return;
    L7:
        mUnicodeBOM();
        boolean r10 = this.state.failed;
        return;
    L9:
        mWS();
        boolean r11 = this.state.failed;
        return;
    L11:
        mSTRING_LITERAL();
        boolean r12 = this.state.failed;
        return;
    L13:
        mINT();
        boolean r13 = this.state.failed;
        return;
    L15:
        mID();
        boolean r14 = this.state.failed;
        return;
    L17:
        mRBRACE();
        boolean r15 = this.state.failed;
        return;
    L19:
        mNOT();
        boolean r16 = this.state.failed;
        return;
    L21:
        mPOUND();
        boolean r17 = this.state.failed;
        return;
    L23:
        mAT();
        boolean r18 = this.state.failed;
        return;
    L25:
        mRANGE();
        boolean r19 = this.state.failed;
        return;
    L27:
        mDOT();
        boolean r20 = this.state.failed;
        return;
    L29:
        mDOLLAR();
        boolean r21 = this.state.failed;
        return;
    L31:
        mOR();
        boolean r22 = this.state.failed;
        return;
    L33:
        mPLUS_ASSIGN();
        boolean r23 = this.state.failed;
        return;
    L35:
        mPLUS();
        boolean r24 = this.state.failed;
        return;
    L37:
        mSTAR();
        boolean r25 = this.state.failed;
        return;
    L39:
        mSYNPRED();
        boolean r26 = this.state.failed;
        return;
    L41:
        mQUESTION();
        boolean r27 = this.state.failed;
        return;
    L43:
        mASSIGN();
        boolean r28 = this.state.failed;
        return;
    L45:
        mGT();
        boolean r29 = this.state.failed;
        return;
    L47:
        mLT();
        boolean r30 = this.state.failed;
        return;
    L49:
        mRARROW();
        boolean r31 = this.state.failed;
        return;
    L51:
        mRPAREN();
        boolean r32 = this.state.failed;
        return;
    L53:
        mLPAREN();
        boolean r33 = this.state.failed;
        return;
    L55:
        mSEMI();
        boolean r34 = this.state.failed;
        return;
    L57:
        mCOMMA();
        boolean r35 = this.state.failed;
        return;
    L59:
        mCOLONCOLON();
        boolean r36 = this.state.failed;
        return;
    L61:
        mCOLON();
        boolean r37 = this.state.failed;
        return;
    L63:
        mMODE();
        boolean r38 = this.state.failed;
        return;
    L65:
        mFINALLY();
        boolean r39 = this.state.failed;
        return;
    L67:
        mCATCH();
        boolean r40 = this.state.failed;
        return;
    L69:
        mTHROWS();
        boolean r41 = this.state.failed;
        return;
    L71:
        mLOCALS();
        boolean r42 = this.state.failed;
        return;
    L73:
        mRETURNS();
        boolean r43 = this.state.failed;
        return;
    L75:
        mPRIVATE();
        boolean r44 = this.state.failed;
        return;
    L77:
        mPUBLIC();
        boolean r45 = this.state.failed;
        return;
    L79:
        mPROTECTED();
        boolean r46 = this.state.failed;
        return;
    L81:
        mTREE_GRAMMAR();
        boolean r47 = this.state.failed;
        return;
    L83:
        mGRAMMAR();
        boolean r48 = this.state.failed;
        return;
    L85:
        mPARSER();
        boolean r49 = this.state.failed;
        return;
    L87:
        mLEXER();
        boolean r50 = this.state.failed;
        return;
    L89:
        mFRAGMENT();
        boolean r51 = this.state.failed;
        return;
    L91:
        mIMPORT();
        boolean r52 = this.state.failed;
        return;
    L93:
        mCHANNELS();
        boolean r53 = this.state.failed;
        return;
    L95:
        mTOKENS_SPEC();
        boolean r54 = this.state.failed;
        return;
    L97:
        mOPTIONS();
        boolean r55 = this.state.failed;
        return;
    L99:
        mACTION();
        boolean r56 = this.state.failed;
        return;
    L101:
        mARG_OR_CHARSET();
        boolean r57 = this.state.failed;
        return;
    L103:
        mCOMMENT();
        boolean r58 = this.state.failed;
    }

    public final void mUNICODE_ESC() throws RecognitionException {
        match(117);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        if (r5 < 48) goto L8;
        if (r5 > 57) goto L8;
    L12:
        mHEX_DIGIT();
        RecognizerSharedState r10 = this.state;
        if (r10.failed == false) goto L16;
        return;
    L16:
        if (r10.backtracking != 0) goto L18;
        int r11 = 1;
    L19:
        int r12 = this.input.LA(1);
        if (r12 < 48) goto L22;
        if (r12 > 57) goto L22;
    L26:
        mHEX_DIGIT();
        RecognizerSharedState r13 = this.state;
        if (r13.failed == false) goto L30;
        return;
    L30:
        if (r13.backtracking != 0) goto L32;
        r11 = r11 + 1;
    L32:
        int r14 = this.input.LA(1);
        if (r14 < 48) goto L35;
        if (r14 > 57) goto L35;
    L39:
        mHEX_DIGIT();
        RecognizerSharedState r15 = this.state;
        if (r15.failed == false) goto L43;
        return;
    L43:
        if (r15.backtracking != 0) goto L45;
        r11 = r11 + 1;
    L45:
        int r16 = this.input.LA(1);
        if (r16 < 48) goto L48;
        if (r16 > 57) goto L48;
    L52:
        mHEX_DIGIT();
        RecognizerSharedState r17 = this.state;
        if (r17.failed == false) goto L56;
        return;
    L56:
        if (r17.backtracking != 0) goto L60;
        r11 = r11 + 1;
    L60:
        if (this.state.backtracking == 0) goto L62;
        return;
    L62:
        if (r11 >= 4) goto L69;
        Interval r18 = Interval.of((getCharIndex() - 2) - r11, getCharIndex());
        CharStream r19 = this.input;
        int r20 = r18.f666b;
        if (r19.substring(r20, r20).codePointAt(0) != 39) goto L66;
        r18.f666b--;
    L66:
        String r21 = this.input.substring(r18.f665a, r18.f666b);
        CharStream r22 = this.input;
        RecognizerSharedState r23 = this.state;
        CommonToken r24 = new CommonToken(r22, r23.type, r23.channel, r18.f665a, r18.f666b);
        r24.setLine(this.input.getLine());
        r24.setCharPositionInLine((this.input.getCharPositionInLine() - r11) - 2);
        grammarError(ErrorType.INVALID_ESCAPE_SEQUENCE, r24, new Object[]{r21});
        return;
    L69:
        return;
    L48:
        if (r16 < 65) goto L50;
        if (r16 <= 70) goto L52;
    L50:
        if (r16 < 97) goto L60;
        if (r16 > 102) goto L60;
    L35:
        if (r14 < 65) goto L37;
        if (r14 <= 70) goto L39;
    L37:
        if (r14 < 97) goto L60;
        if (r14 > 102) goto L60;
    L22:
        if (r12 < 65) goto L24;
        if (r12 <= 70) goto L26;
    L24:
        if (r12 < 97) goto L60;
        if (r12 > 102) goto L60;
    L18:
        r11 = 0;
    L8:
        if (r5 < 65) goto L10;
        if (r5 <= 70) goto L12;
    L10:
        if (r5 < 97) goto L58;
        if (r5 <= 102) goto L12;
    L58:
        r11 = 0;
        goto L60
    }

    public final void mUNICODE_EXTENDED_ESC() throws RecognitionException {
        match("u{");
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = 0;
    L6:
        int r10 = this.input.LA(1);
        if (r10 < 48) goto L9;
        if (r10 > 57) goto L9;
    L14:
        if (this.input.LA(1) < 48) goto L18;
        if (this.input.LA(1) > 57) goto L18;
    L25:
        this.input.consume();
        this.state.failed = false;
        r5 = r5 + 1;
    L18:
        if (this.input.LA(1) < 65) goto L22;
        if (this.input.LA(1) <= 70) goto L25;
    L22:
        if (this.input.LA(1) < 97) goto L26;
        if (this.input.LA(1) <= 102) goto L25;
    L26:
        RecognizerSharedState r11 = this.state;
        if (r11.backtracking <= 0) goto L30;
        r11.failed = true;
        return;
    L30:
        MismatchedSetException r12 = new MismatchedSetException(null, this.input);
        recover(r12);
        throw r12;
    L9:
        if (r10 < 65) goto L11;
        if (r10 <= 70) goto L14;
    L11:
        if (r10 < 97) goto L32;
        if (r10 <= 102) goto L14;
    L32:
        if (r5 < 1) goto L42;
        match(125);
        RecognizerSharedState r13 = this.state;
        if (r13.failed == false) goto L37;
        return;
    L37:
        if (r13.backtracking != 0) goto L55;
        int r14 = getCharIndex();
        RecognizerSharedState r15 = this.state;
        int r16 = r15.tokenStartCharIndex;
        int r17 = (r14 - r16) - 6;
        if (r17 <= 6) goto L56;
        CommonToken r18 = new CommonToken(this.input, r15.type, r15.channel, r16, getCharIndex() - 1);
        r18.setText(r18.getText());
        r18.setLine(this.input.getLine());
        r18.setCharPositionInLine(this.input.getCharPositionInLine() - r17);
        grammarError(ErrorType.INVALID_ESCAPE_SEQUENCE, r18, new Object[]{this.input.substring(this.state.tokenStartCharIndex, getCharIndex() - 1)});
        return;
    L56:
        return;
    L55:
        return;
    L42:
        RecognizerSharedState r19 = this.state;
        if (r19.backtracking <= 0) goto L47;
        r19.failed = true;
        return;
    L47:
        throw new EarlyExitException(33, this.input);
    }

    public final void mUnicodeBOM() throws RecognitionException {
        match(65279);
        RecognizerSharedState r5 = this.state;
        if (r5.failed == false) goto L6;
        return;
    L6:
        if (r5.backtracking != 0) goto L8;
        skip();
    L8:
        RecognizerSharedState r10 = this.state;
        r10.type = 70;
        r10.channel = 0;
    }

    public final void mWS() throws RecognitionException {
        int r5 = 0;
        int r10 = 0;
    L3:
        int r11 = this.input.LA(1);
        if (r11 < 9) goto L6;
        if (r11 > 10) goto L6;
    L10:
        if (this.input.LA(1) < 9) goto L14;
        if (this.input.LA(1) > 10) goto L14;
    L19:
        this.input.consume();
        this.state.failed = false;
        r10 = r10 + 1;
    L14:
        if (this.input.LA(1) < 12) goto L18;
        if (this.input.LA(1) <= 13) goto L19;
    L18:
        if (this.input.LA(1) == 32) goto L19;
        RecognizerSharedState r12 = this.state;
        if (r12.backtracking <= 0) goto L24;
        r12.failed = true;
        return;
    L24:
        MismatchedSetException r13 = new MismatchedSetException(null, this.input);
        recover(r13);
        throw r13;
    L6:
        if (r11 < 12) goto L8;
        if (r11 <= 13) goto L10;
    L8:
        if (r11 == 32) goto L10;
        if (r10 < 1) goto L32;
        RecognizerSharedState r14 = this.state;
        if (r14.backtracking != 0) goto L30;
        r5 = 99;
    L30:
        r14.type = 71;
        r14.channel = r5;
        return;
    L32:
        RecognizerSharedState r15 = this.state;
        if (r15.backtracking <= 0) goto L37;
        r15.failed = true;
        return;
    L37:
        throw new EarlyExitException(34, this.input);
    }

    public final void mWSCHARS() throws RecognitionException {
        if (this.input.LA(1) != 9) goto L5;
    L15:
        this.input.consume();
        this.state.failed = false;
        return;
    L5:
        if (this.input.LA(1) == 12) goto L15;
        if (this.input.LA(1) == 32) goto L15;
        RecognizerSharedState r5 = this.state;
        if (r5.backtracking <= 0) goto L13;
        r5.failed = true;
        return;
    L13:
        MismatchedSetException r10 = new MismatchedSetException(null, this.input);
        recover(r10);
        throw r10;
    }

    public final void mWSNLCHARS() throws RecognitionException {
        if (this.input.LA(1) < 9) goto L7;
        if (this.input.LA(1) > 10) goto L7;
    L12:
        this.input.consume();
        this.state.failed = false;
        return;
    L7:
        if (this.input.LA(1) < 12) goto L11;
        if (this.input.LA(1) <= 13) goto L12;
    L11:
        if (this.input.LA(1) == 32) goto L12;
        RecognizerSharedState r5 = this.state;
        if (r5.backtracking <= 0) goto L18;
        r5.failed = true;
        return;
    L18:
        MismatchedSetException r10 = new MismatchedSetException(null, this.input);
        recover(r10);
        throw r10;
    }

    public final boolean synpred1_ANTLRLexer() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred1_ANTLRLexer_fragment();     // Catch: RecognitionException -> L5
    L7:
        boolean r10 = !this.state.failed;
        this.input.rewind(r5);
        RecognizerSharedState r11 = this.state;
        r11.backtracking--;
        r11.failed = false;
        return r10;
    L5:
        e = move-exception;
        System.err.println("impossible: " + e);
        goto L7
    }

    public final void synpred1_ANTLRLexer_fragment() throws RecognitionException {
        match(" $ANTLR");
        boolean r5 = this.state.failed;
    }

    public final boolean synpred2_ANTLRLexer() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred2_ANTLRLexer_fragment();     // Catch: RecognitionException -> L5
    L7:
        boolean r10 = !this.state.failed;
        this.input.rewind(r5);
        RecognizerSharedState r11 = this.state;
        r11.backtracking--;
        r11.failed = false;
        return r10;
    L5:
        e = move-exception;
        System.err.println("impossible: " + e);
        goto L7
    }

    public final void synpred2_ANTLRLexer_fragment() throws RecognitionException {
        match(34);
        boolean r5 = this.state.failed;
    }

    public final boolean synpred3_ANTLRLexer() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred3_ANTLRLexer_fragment();     // Catch: RecognitionException -> L5
    L7:
        boolean r10 = !this.state.failed;
        this.input.rewind(r5);
        RecognizerSharedState r11 = this.state;
        r11.backtracking--;
        r11.failed = false;
        return r10;
    L5:
        e = move-exception;
        System.err.println("impossible: " + e);
        goto L7
    }

    public final void synpred3_ANTLRLexer_fragment() throws RecognitionException {
        match(39);
        boolean r5 = this.state.failed;
    }

    public final boolean synpred4_ANTLRLexer() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred4_ANTLRLexer_fragment();     // Catch: RecognitionException -> L5
    L7:
        boolean r10 = !this.state.failed;
        this.input.rewind(r5);
        RecognizerSharedState r11 = this.state;
        r11.backtracking--;
        r11.failed = false;
        return r10;
    L5:
        e = move-exception;
        System.err.println("impossible: " + e);
        goto L7
    }

    public final void synpred4_ANTLRLexer_fragment() throws RecognitionException {
    L2:
        int r5 = this.input.LA(1);
        if (r5 < 9) goto L5;
        if (r5 > 10) goto L5;
    L9:
        if (this.input.LA(1) < 9) goto L13;
        if (this.input.LA(1) > 10) goto L13;
    L18:
        this.input.consume();
        this.state.failed = false;
    L13:
        if (this.input.LA(1) < 12) goto L17;
        if (this.input.LA(1) <= 13) goto L18;
    L17:
        if (this.input.LA(1) == 32) goto L18;
        RecognizerSharedState r10 = this.state;
        if (r10.backtracking <= 0) goto L23;
        r10.failed = true;
        return;
    L23:
        MismatchedSetException r11 = new MismatchedSetException(null, this.input);
        recover(r11);
        throw r11;
    L5:
        if (r5 < 12) goto L7;
        if (r5 <= 13) goto L9;
    L7:
        if (r5 == 32) goto L9;
        match("=>");
        boolean r12 = this.state.failed;
    }

    public final boolean synpred5_ANTLRLexer() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred5_ANTLRLexer_fragment();     // Catch: RecognitionException -> L5
    L7:
        boolean r10 = !this.state.failed;
        this.input.rewind(r5);
        RecognizerSharedState r11 = this.state;
        r11.backtracking--;
        r11.failed = false;
        return r10;
    L5:
        e = move-exception;
        System.err.println("impossible: " + e);
        goto L7
    }

    public final void synpred5_ANTLRLexer_fragment() throws RecognitionException {
        match(92);
        boolean r5 = this.state.failed;
    }

    public final boolean synpred6_ANTLRLexer() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred6_ANTLRLexer_fragment();     // Catch: RecognitionException -> L5
    L7:
        boolean r10 = !this.state.failed;
        this.input.rewind(r5);
        RecognizerSharedState r11 = this.state;
        r11.backtracking--;
        r11.failed = false;
        return r10;
    L5:
        e = move-exception;
        System.err.println("impossible: " + e);
        goto L7
    }

    public final void synpred6_ANTLRLexer_fragment() throws RecognitionException {
        match(92);
        boolean r5 = this.state.failed;
    }

    public ANTLRLexer(CharStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public ANTLRLexer(CharStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.isLexerRule = false;
        this.dfa2 = new DFA2(this, this);
        this.dfa35 = new DFA35(this, this);
    }
}
