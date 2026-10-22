package androidx.room.jarjarred.org.antlr.v4.parse;

import androidx.room.jarjarred.org.antlr.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.EarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.FailedPredicateException;
import androidx.room.jarjarred.org.antlr.runtime.IntStream;
import androidx.room.jarjarred.org.antlr.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedSetException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class ActionSplitter extends Lexer {
    public static final int ATTR = 4;
    public static final int ATTR_VALUE_EXPR = 5;
    public static final int COMMENT = 6;
    public static final int EOF = -1;
    public static final int ID = 7;
    public static final int LINE_COMMENT = 8;
    public static final int NONLOCAL_ATTR = 9;
    public static final int QUALIFIED_ATTR = 10;
    public static final int SET_ATTR = 11;
    public static final int SET_NONLOCAL_ATTR = 12;
    public static final int TEXT = 13;
    public static final int WS = 14;
    ActionSplitterListener delegate;

    public ActionSplitter(CharStream r5, ActionSplitterListener r10) {
        this(r5, new RecognizerSharedState());
        this.delegate = r10;
    }

    private boolean isIDStartChar(int r5) {
        if (r5 != 95) goto L5;
    L8:
        return true;
    L5:
        if (Character.isLetter(r5) == true) goto L8;
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public boolean alreadyParsedRule(IntStream r5, int r10) {
        if (this.state.backtracking > 1) goto L5;
        return false;
    L5:
        return super.alreadyParsedRule(r5, r10);
    }

    public List<Token> getActionTokens() {
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

    public Lexer[] getDelegates() {
        return new Lexer[0];
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getGrammarFileName() {
        return "androidx/room/jarjarred/org/antlr/v4/parse/ActionSplitter.g";
    }

    public final void mATTR() throws RecognitionException {
        match(36);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = getCharIndex();
        int r10 = getLine();
        int r11 = getCharPositionInLine();
        mID();
        if (this.state.failed == false) goto L8;
        return;
    L8:
        CommonToken r12 = new CommonToken(this.input, 0, 0, r5, getCharIndex() - 1);
        r12.setLine(r10);
        r12.setCharPositionInLine(r11);
        if (this.state.backtracking != 1) goto L11;
        this.delegate.attr(getText(), r12);
    L11:
        RecognizerSharedState r13 = this.state;
        r13.type = 4;
        r13.channel = 0;
    }

    public final void mATTR_VALUE_EXPR() throws RecognitionException {
        if (this.input.LA(1) < 0) goto L7;
        if (this.input.LA(1) > 60) goto L7;
    L10:
        this.input.consume();
        this.state.failed = false;
    L11:
        int r5 = this.input.LA(1);
        if (r5 < 0) goto L14;
        if (r5 > 58) goto L14;
    L17:
        if (this.input.LA(1) < 0) goto L21;
        if (this.input.LA(1) > 58) goto L21;
    L24:
        this.input.consume();
        this.state.failed = false;
    L21:
        if (this.input.LA(1) < 60) goto L25;
        if (this.input.LA(1) <= 65535) goto L24;
    L25:
        RecognizerSharedState r10 = this.state;
        if (r10.backtracking <= 0) goto L29;
        r10.failed = true;
        return;
    L29:
        MismatchedSetException r11 = new MismatchedSetException(null, this.input);
        recover(r11);
        throw r11;
    L14:
        if (r5 < 60) goto L31;
        if (r5 <= 65535) goto L17;
        return;
    L31:
        return;
    L7:
        if (this.input.LA(1) >= 62) goto L9;
    L32:
        RecognizerSharedState r12 = this.state;
        if (r12.backtracking <= 0) goto L36;
        r12.failed = true;
        return;
    L36:
        MismatchedSetException r13 = new MismatchedSetException(null, this.input);
        recover(r13);
        throw r13;
    L9:
        if (this.input.LA(1) > 65535) goto L32;
        goto L10
    }

    public final void mCOMMENT() throws RecognitionException {
        match("/*");
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        if (r5 != 42) goto L17;
        int r10 = this.input.LA(2);
        if (r10 == 47) goto L26;
        if (r10 < 0) goto L14;
        if (r10 > 46) goto L14;
    L23:
        matchAny();
        if (this.state.failed == false) goto L5;
        return;
    L14:
        if (r10 < 48) goto L26;
        if (r10 <= 65535) goto L23;
    L26:
        match("*/");
        RecognizerSharedState r11 = this.state;
        if (r11.failed == false) goto L30;
        return;
    L30:
        if (r11.backtracking != 1) goto L32;
        this.delegate.text(getText());
    L32:
        RecognizerSharedState r12 = this.state;
        r12.type = 6;
        r12.channel = 0;
        return;
    L17:
        if (r5 < 0) goto L21;
        if (r5 <= 41) goto L23;
    L21:
        if (r5 < 43) goto L26;
        if (r5 > 65535) goto L26;
        goto L23
    }

    public final void mID() throws RecognitionException {
        if (this.input.LA(1) < 65) goto L7;
        if (this.input.LA(1) > 90) goto L7;
    L19:
        this.input.consume();
        this.state.failed = false;
    L20:
        int r5 = this.input.LA(1);
        if (r5 < 48) goto L23;
        if (r5 > 57) goto L23;
    L31:
        if (this.input.LA(1) < 48) goto L35;
        if (this.input.LA(1) > 57) goto L35;
    L51:
        this.input.consume();
        this.state.failed = false;
    L35:
        if (this.input.LA(1) < 65) goto L39;
        if (this.input.LA(1) <= 90) goto L51;
    L39:
        if (this.input.LA(1) == 95) goto L51;
        if (this.input.LA(1) < 97) goto L45;
        if (this.input.LA(1) <= 122) goto L51;
    L45:
        RecognizerSharedState r10 = this.state;
        if (r10.backtracking <= 0) goto L49;
        r10.failed = true;
        return;
    L49:
        MismatchedSetException r11 = new MismatchedSetException(null, this.input);
        recover(r11);
        throw r11;
    L23:
        if (r5 < 65) goto L25;
        if (r5 <= 90) goto L31;
    L25:
        if (r5 == 95) goto L31;
        if (r5 < 97) goto L29;
        if (r5 <= 122) goto L31;
        return;
    L29:
        return;
    L7:
        if (this.input.LA(1) == 95) goto L19;
        if (this.input.LA(1) >= 97) goto L11;
    L13:
        RecognizerSharedState r12 = this.state;
        if (r12.backtracking <= 0) goto L17;
        r12.failed = true;
        return;
    L17:
        MismatchedSetException r13 = new MismatchedSetException(null, this.input);
        recover(r13);
        throw r13;
    L11:
        if (this.input.LA(1) > 122) goto L13;
        goto L13
    }

    public final void mLINE_COMMENT() throws RecognitionException {
        match("//");
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = this.input.LA(1);
        if (r5 < 0) goto L8;
        if (r5 > 9) goto L8;
    L13:
        if (this.input.LA(1) < 0) goto L17;
        if (this.input.LA(1) > 9) goto L17;
    L24:
        this.input.consume();
        this.state.failed = false;
    L17:
        if (this.input.LA(1) < 11) goto L21;
        if (this.input.LA(1) <= 12) goto L24;
    L21:
        if (this.input.LA(1) < 14) goto L25;
        if (this.input.LA(1) <= 65535) goto L24;
    L25:
        RecognizerSharedState r10 = this.state;
        if (r10.backtracking <= 0) goto L29;
        r10.failed = true;
        return;
    L29:
        MismatchedSetException r11 = new MismatchedSetException(null, this.input);
        recover(r11);
        throw r11;
    L8:
        if (r5 < 11) goto L10;
        if (r5 <= 12) goto L13;
    L10:
        if (r5 < 14) goto L32;
        if (r5 <= 65535) goto L13;
    L32:
        if (this.input.LA(1) != 13) goto L36;
        match(13);
        if (this.state.failed == false) goto L36;
        return;
    L36:
        match(10);
        RecognizerSharedState r12 = this.state;
        if (r12.failed == false) goto L40;
        return;
    L40:
        if (r12.backtracking != 1) goto L42;
        this.delegate.text(getText());
    L42:
        RecognizerSharedState r13 = this.state;
        r13.type = 8;
        r13.channel = 0;
    }

    public final void mNONLOCAL_ATTR() throws RecognitionException {
        match(36);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = getCharIndex();
        int r10 = getLine();
        int r11 = getCharPositionInLine();
        mID();
        if (this.state.failed == false) goto L8;
        return;
    L8:
        CommonToken r12 = new CommonToken(this.input, 0, 0, r5, getCharIndex() - 1);
        r12.setLine(r10);
        r12.setCharPositionInLine(r11);
        match("::");
        if (this.state.failed == false) goto L11;
        return;
    L11:
        int r13 = getCharIndex();
        int r14 = getLine();
        int r15 = getCharPositionInLine();
        mID();
        if (this.state.failed == false) goto L14;
        return;
    L14:
        CommonToken r16 = new CommonToken(this.input, 0, 0, r13, getCharIndex() - 1);
        r16.setLine(r14);
        r16.setCharPositionInLine(r15);
        if (this.state.backtracking != 1) goto L17;
        this.delegate.nonLocalAttr(getText(), r12, r16);
    L17:
        RecognizerSharedState r17 = this.state;
        r17.type = 9;
        r17.channel = 0;
    }

    public final void mQUALIFIED_ATTR() throws RecognitionException {
        match(36);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = getCharIndex();
        int r10 = getLine();
        int r11 = getCharPositionInLine();
        mID();
        if (this.state.failed == false) goto L8;
        return;
    L8:
        CommonToken r12 = new CommonToken(this.input, 0, 0, r5, getCharIndex() - 1);
        r12.setLine(r10);
        r12.setCharPositionInLine(r11);
        match(46);
        if (this.state.failed == false) goto L11;
        return;
    L11:
        int r13 = getCharIndex();
        int r14 = getLine();
        int r15 = getCharPositionInLine();
        mID();
        if (this.state.failed == false) goto L14;
        return;
    L14:
        CommonToken r16 = new CommonToken(this.input, 0, 0, r13, getCharIndex() - 1);
        r16.setLine(r14);
        r16.setCharPositionInLine(r15);
        if (this.input.LA(1) != 40) goto L23;
        RecognizerSharedState r17 = this.state;
        if (r17.backtracking <= 0) goto L21;
        r17.failed = true;
        return;
    L21:
        throw new FailedPredicateException(this.input, "QUALIFIED_ATTR", "input.LA(1)!='('");
    L23:
        if (this.state.backtracking != 1) goto L25;
        this.delegate.qualifiedAttr(getText(), r12, r16);
    L25:
        RecognizerSharedState r18 = this.state;
        r18.type = 10;
        r18.channel = 0;
    }

    public final void mSET_ATTR() throws RecognitionException {
        match(36);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = getCharIndex();
        int r10 = getLine();
        int r11 = getCharPositionInLine();
        mID();
        if (this.state.failed == false) goto L8;
        return;
    L8:
        CommonToken r12 = new CommonToken(this.input, 0, 0, r5, getCharIndex() - 1);
        r12.setLine(r10);
        r12.setCharPositionInLine(r11);
        int r13 = this.input.LA(1);
        if (r13 < 9) goto L13;
        if (r13 > 10) goto L13;
    L16:
        mWS();
        if (this.state.failed == false) goto L19;
        return;
    L19:
        match(61);
        if (this.state.failed == false) goto L22;
        return;
    L22:
        int r14 = getCharIndex();
        int r15 = getLine();
        int r16 = getCharPositionInLine();
        mATTR_VALUE_EXPR();
        if (this.state.failed == false) goto L25;
        return;
    L25:
        CommonToken r17 = new CommonToken(this.input, 0, 0, r14, getCharIndex() - 1);
        r17.setLine(r15);
        r17.setCharPositionInLine(r16);
        match(59);
        RecognizerSharedState r18 = this.state;
        if (r18.failed == false) goto L29;
        return;
    L29:
        if (r18.backtracking != 1) goto L31;
        this.delegate.setAttr(getText(), r12, r17);
    L31:
        RecognizerSharedState r19 = this.state;
        r19.type = 11;
        r19.channel = 0;
        return;
    L13:
        if (r13 == 13) goto L16;
        if (r13 != 32) goto L19;
        goto L16
    }

    public final void mSET_NONLOCAL_ATTR() throws RecognitionException {
        match(36);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        int r5 = getCharIndex();
        int r10 = getLine();
        int r11 = getCharPositionInLine();
        mID();
        if (this.state.failed == false) goto L8;
        return;
    L8:
        CommonToken r12 = new CommonToken(this.input, 0, 0, r5, getCharIndex() - 1);
        r12.setLine(r10);
        r12.setCharPositionInLine(r11);
        match("::");
        if (this.state.failed == false) goto L11;
        return;
    L11:
        int r13 = getCharIndex();
        int r14 = getLine();
        int r15 = getCharPositionInLine();
        mID();
        if (this.state.failed == false) goto L14;
        return;
    L14:
        CommonToken r16 = new CommonToken(this.input, 0, 0, r13, getCharIndex() - 1);
        r16.setLine(r14);
        r16.setCharPositionInLine(r15);
        int r17 = this.input.LA(1);
        if (r17 < 9) goto L19;
        if (r17 > 10) goto L19;
    L22:
        mWS();
        if (this.state.failed == false) goto L25;
        return;
    L25:
        match(61);
        if (this.state.failed == false) goto L28;
        return;
    L28:
        int r18 = getCharIndex();
        int r19 = getLine();
        int r20 = getCharPositionInLine();
        mATTR_VALUE_EXPR();
        if (this.state.failed == false) goto L31;
        return;
    L31:
        CommonToken r110 = new CommonToken(this.input, 0, 0, r18, getCharIndex() - 1);
        r110.setLine(r19);
        r110.setCharPositionInLine(r20);
        match(59);
        RecognizerSharedState r21 = this.state;
        if (r21.failed == false) goto L35;
        return;
    L35:
        if (r21.backtracking != 1) goto L37;
        this.delegate.setNonLocalAttr(getText(), r12, r16, r110);
    L37:
        RecognizerSharedState r111 = this.state;
        r111.type = 12;
        r111.channel = 0;
        return;
    L19:
        if (r17 == 13) goto L22;
        if (r17 != 32) goto L25;
        goto L22
    }

    public final void mTEXT() throws RecognitionException {
        StringBuilder r5 = new StringBuilder();
        int r10 = 0;
    L3:
        int r11 = this.input.LA(1);
        if (r11 < 0) goto L6;
        if (r11 > 35) goto L6;
    L10:
        char r12 = 1;
    L27:
        if (r12 == 1) goto L82;
        if (r12 == 2) goto L76;
        if (r12 == 3) goto L56;
        if (r12 != 4) goto L31;
        if (isIDStartChar(this.input.LA(2)) == true) goto L44;
        match(36);
        RecognizerSharedState r13 = this.state;
        if (r13.failed == true) goto L52;
        if (r13.backtracking != 1) goto L97;
        r5.append(Typography.dollar);
    L97:
        r10 = r10 + 1;
        goto L3
    L52:
        return;
    L44:
        RecognizerSharedState r14 = this.state;
        if (r14.backtracking <= 0) goto L49;
        r14.failed = true;
        return;
    L49:
        throw new FailedPredicateException(this.input, "TEXT", "!isIDStartChar(input.LA(2))");
    L31:
        if (r10 < 1) goto L36;
        RecognizerSharedState r15 = this.state;
        r15.type = 13;
        r15.channel = 0;
        if (r15.backtracking != 1) goto L121;
        this.delegate.text(r5.toString());
        return;
    L121:
        return;
    L36:
        RecognizerSharedState r16 = this.state;
        if (r16.backtracking <= 0) goto L41;
        r16.failed = true;
        return;
    L41:
        throw new EarlyExitException(6, this.input);
    L56:
        match(92);
        if (this.state.failed == true) goto L58;
        int r17 = this.input.LA(1);
        if (this.input.LA(1) < 0) goto L64;
        if (this.input.LA(1) > 35) goto L64;
    L67:
        this.input.consume();
        RecognizerSharedState r18 = this.state;
        r18.failed = false;
        if (r18.backtracking != 1) goto L97;
        r5.append('\\');
        r5.append((char) r17);
    L64:
        if (this.input.LA(1) < 37) goto L70;
        if (this.input.LA(1) <= 65535) goto L67;
    L70:
        RecognizerSharedState r19 = this.state;
        if (r19.backtracking <= 0) goto L74;
        r19.failed = true;
        return;
    L74:
        MismatchedSetException r20 = new MismatchedSetException(null, this.input);
        recover(r20);
        throw r20;
    L58:
        return;
    L76:
        match("\\$");
        RecognizerSharedState r21 = this.state;
        if (r21.failed == true) goto L78;
        if (r21.backtracking != 1) goto L97;
        r5.append(Typography.dollar);
        goto L97
    L78:
        return;
    L82:
        int r22 = this.input.LA(1);
        if (this.input.LA(1) < 0) goto L87;
        if (this.input.LA(1) > 35) goto L87;
    L94:
        this.input.consume();
        RecognizerSharedState r23 = this.state;
        r23.failed = false;
        if (r23.backtracking != 1) goto L97;
        r5.append((char) r22);
    L87:
        if (this.input.LA(1) < 37) goto L91;
        if (this.input.LA(1) <= 91) goto L94;
    L91:
        if (this.input.LA(1) < 93) goto L98;
        if (this.input.LA(1) <= 65535) goto L94;
    L98:
        RecognizerSharedState r24 = this.state;
        if (r24.backtracking <= 0) goto L102;
        r24.failed = true;
        return;
    L102:
        MismatchedSetException r25 = new MismatchedSetException(null, this.input);
        recover(r25);
        throw r25;
    L6:
        if (r11 < 37) goto L8;
        if (r11 <= 91) goto L10;
    L8:
        if (r11 < 93) goto L11;
        if (r11 <= 65535) goto L10;
    L11:
        char r110 = 5;
        if (r11 != 92) goto L22;
        int r26 = this.input.LA(2);
        if (r26 != 36) goto L16;
        r110 = 2;
    L21:
        r12 = r110;
        goto L27
    L16:
        if (r26 < 0) goto L18;
        if (r26 > 35) goto L18;
    L20:
        r110 = 3;
    L18:
        if (r26 < 37) goto L21;
        if (r26 > 65535) goto L21;
    L22:
        if (r11 != 36) goto L21;
        if (isIDStartChar(this.input.LA(2)) == true) goto L21;
        r12 = 4;
        goto L27
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Lexer
    public void mTokens() throws RecognitionException {
        char r5 = 1;
        int r10 = this.input.LA(1);
        char r11 = '\b';
        if (r10 != 47) goto L13;
        this.input.LA(2);
        if (synpred1_ActionSplitter() == false) goto L8;
    L11:
        r11 = r5;
    L53:
        switch(r11) {
            case 1: goto L69;
            case 2: goto L67;
            case 3: goto L65;
            case 4: goto L63;
            case 5: goto L61;
            case 6: goto L59;
            case 7: goto L57;
            case 8: goto L55;
            default: goto L54;
        };
    L54:
        return;
    L55:
        mTEXT();
        boolean r12 = this.state.failed;
        return;
    L57:
        mATTR();
        boolean r13 = this.state.failed;
        return;
    L59:
        mSET_ATTR();
        boolean r14 = this.state.failed;
        return;
    L61:
        mQUALIFIED_ATTR();
        boolean r15 = this.state.failed;
        return;
    L63:
        mNONLOCAL_ATTR();
        boolean r16 = this.state.failed;
        return;
    L65:
        mSET_NONLOCAL_ATTR();
        boolean r17 = this.state.failed;
        return;
    L67:
        mLINE_COMMENT();
        boolean r18 = this.state.failed;
        return;
    L69:
        mCOMMENT();
        boolean r19 = this.state.failed;
        return;
    L8:
        if (synpred2_ActionSplitter() == false) goto L10;
        r5 = 2;
        goto L11
    L10:
        r5 = '\b';
        goto L11
    L13:
        if (r10 != 36) goto L42;
        this.input.LA(2);
        if (synpred3_ActionSplitter() == false) goto L18;
        r11 = 3;
        goto L53
    L18:
        if (synpred4_ActionSplitter() == false) goto L21;
        r11 = 4;
        goto L53
    L21:
        if (synpred5_ActionSplitter() == false) goto L24;
        r11 = 5;
        goto L53
    L24:
        if (synpred6_ActionSplitter() == false) goto L27;
        r11 = 6;
        goto L53
    L27:
        if (synpred7_ActionSplitter() == false) goto L30;
        r11 = 7;
        goto L53
    L30:
        if (isIDStartChar(this.input.LA(2)) == false) goto L53;
        RecognizerSharedState r20 = this.state;
        if (r20.backtracking <= 0) goto L36;
        r20.failed = true;
        return;
    L36:
        int r21 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L39
        throw new NoViableAltException("", 10, 2, this.input);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        this.input.rewind(r21);
        throw th;
    L42:
        if (r10 < 0) goto L46;
        if (r10 <= 35) goto L53;
    L46:
        if (r10 < 37) goto L50;
        if (r10 <= 46) goto L53;
    L50:
        if (r10 >= 48) goto L52;
    L71:
        RecognizerSharedState r22 = this.state;
        if (r22.backtracking <= 0) goto L76;
        r22.failed = true;
        return;
    L76:
        throw new NoViableAltException("", 10, 0, this.input);
    L52:
        if (r10 > 65535) goto L71;
        goto L53
    }

    public final void mWS() throws RecognitionException {
        int r5 = 0;
    L3:
        int r10 = this.input.LA(1);
        if (r10 < 9) goto L6;
        if (r10 > 10) goto L6;
    L18:
        if (this.input.LA(1) < 9) goto L22;
        if (this.input.LA(1) > 10) goto L22;
    L32:
        this.input.consume();
        this.state.failed = false;
        r5 = r5 + 1;
    L22:
        if (this.input.LA(1) == 13) goto L32;
        if (this.input.LA(1) == 32) goto L32;
        RecognizerSharedState r11 = this.state;
        if (r11.backtracking <= 0) goto L30;
        r11.failed = true;
        return;
    L30:
        MismatchedSetException r12 = new MismatchedSetException(null, this.input);
        recover(r12);
        throw r12;
    L6:
        if (r10 == 13) goto L18;
        if (r10 == 32) goto L18;
        if (r5 < 1) goto L11;
        return;
    L11:
        RecognizerSharedState r13 = this.state;
        if (r13.backtracking <= 0) goto L16;
        r13.failed = true;
        return;
    L16:
        throw new EarlyExitException(9, this.input);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void memoize(IntStream r5, int r10, int r11) {
        if (this.state.backtracking <= 1) goto L6;
        super.memoize(r5, r10, r11);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Lexer, androidx.room.jarjarred.org.antlr.runtime.TokenSource
    public Token nextToken() {
    L3:
        if (this.input.LA(1) == (-1)) goto L4;
        RecognizerSharedState r5 = this.state;
        r5.token = null;
        r5.channel = 0;
        r5.tokenStartCharIndex = this.input.index();
        RecognizerSharedState r10 = this.state;
        r10.tokenStartCharPositionInLine = this.input.getCharPositionInLine();
        RecognizerSharedState r11 = this.state;
        r11.tokenStartLine = this.input.getLine();
        this.state.text = null;
        int r12 = this.input.mark();     // Catch: RecognitionException -> L10
        RecognizerSharedState r13 = this.state;     // Catch: RecognitionException -> L10
        r13.backtracking = 1;     // Catch: RecognitionException -> L10
        r13.failed = false;     // Catch: RecognitionException -> L10
        this.mTokens();     // Catch: RecognitionException -> L10
        RecognizerSharedState r14 = this.state;     // Catch: RecognitionException -> L10
        r14.backtracking = 0;     // Catch: RecognitionException -> L10
        if (r14.failed == true) goto L9;
        this.emit();     // Catch: RecognitionException -> L10
        return this.state.token;
    L9:
        this.input.rewind(r12);     // Catch: RecognitionException -> L10
        this.input.consume();     // Catch: RecognitionException -> L10
    L10:
        e = move-exception;
        this.reportError(e);
        this.recover(e);
        goto L3
    L4:
        CharStream r15 = this.input;
        CommonToken r16 = new CommonToken(r15, -1, 0, r15.index(), this.input.index());
        r16.setLine(this.getLine());
        r16.setCharPositionInLine(this.getCharPositionInLine());
        return r16;
    }

    public final boolean synpred1_ActionSplitter() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred1_ActionSplitter_fragment();     // Catch: RecognitionException -> L5
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

    public final void synpred1_ActionSplitter_fragment() throws RecognitionException {
        mCOMMENT();
        boolean r5 = this.state.failed;
    }

    public final boolean synpred2_ActionSplitter() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred2_ActionSplitter_fragment();     // Catch: RecognitionException -> L5
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

    public final void synpred2_ActionSplitter_fragment() throws RecognitionException {
        mLINE_COMMENT();
        boolean r5 = this.state.failed;
    }

    public final boolean synpred3_ActionSplitter() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred3_ActionSplitter_fragment();     // Catch: RecognitionException -> L5
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

    public final void synpred3_ActionSplitter_fragment() throws RecognitionException {
        mSET_NONLOCAL_ATTR();
        boolean r5 = this.state.failed;
    }

    public final boolean synpred4_ActionSplitter() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred4_ActionSplitter_fragment();     // Catch: RecognitionException -> L5
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

    public final void synpred4_ActionSplitter_fragment() throws RecognitionException {
        mNONLOCAL_ATTR();
        boolean r5 = this.state.failed;
    }

    public final boolean synpred5_ActionSplitter() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred5_ActionSplitter_fragment();     // Catch: RecognitionException -> L5
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

    public final void synpred5_ActionSplitter_fragment() throws RecognitionException {
        mQUALIFIED_ATTR();
        boolean r5 = this.state.failed;
    }

    public final boolean synpred6_ActionSplitter() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred6_ActionSplitter_fragment();     // Catch: RecognitionException -> L5
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

    public final void synpred6_ActionSplitter_fragment() throws RecognitionException {
        mSET_ATTR();
        boolean r5 = this.state.failed;
    }

    public final boolean synpred7_ActionSplitter() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred7_ActionSplitter_fragment();     // Catch: RecognitionException -> L5
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

    public final void synpred7_ActionSplitter_fragment() throws RecognitionException {
        mATTR();
        boolean r5 = this.state.failed;
    }

    public ActionSplitter() {
    }

    public ActionSplitter(CharStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public ActionSplitter(CharStream r5, RecognizerSharedState r10) {
        super(r5, r10);
    }
}
