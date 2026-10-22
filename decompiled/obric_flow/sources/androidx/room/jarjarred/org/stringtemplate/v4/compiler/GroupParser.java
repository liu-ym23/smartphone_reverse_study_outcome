package androidx.room.jarjarred.org.stringtemplate.v4.compiler;

import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.runtime.FailedPredicateException;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedSetException;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedTokenException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.Parser;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorType;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes.dex */
public class GroupParser extends Parser {
    public static final int ANONYMOUS_TEMPLATE = 4;
    public static final int BIGSTRING = 5;
    public static final int BIGSTRING_NO_NL = 6;
    public static final int COMMENT = 7;
    public static final int EOF = -1;
    public static final int FALSE = 8;
    public static final BitSet FOLLOW_16_in_templateDef325 = null;
    public static final BitSet FOLLOW_16_in_templateDef337 = null;
    public static final BitSet FOLLOW_17_in_templateDef327 = null;
    public static final BitSet FOLLOW_17_in_templateDef341 = null;
    public static final BitSet FOLLOW_18_in_delimiters256 = null;
    public static final BitSet FOLLOW_18_in_dictPairs616 = null;
    public static final BitSet FOLLOW_18_in_dictPairs624 = null;
    public static final BitSet FOLLOW_18_in_formalArgs466 = null;
    public static final BitSet FOLLOW_18_in_oldStyleHeader187 = null;
    public static final BitSet FOLLOW_19_in_group125 = null;
    public static final BitSet FOLLOW_19_in_groupName228 = null;
    public static final BitSet FOLLOW_19_in_templateDef319 = null;
    public static final BitSet FOLLOW_20_in_defaultValuePair662 = null;
    public static final BitSet FOLLOW_20_in_keyValuePair680 = null;
    public static final BitSet FOLLOW_20_in_oldStyleHeader168 = null;
    public static final BitSet FOLLOW_21_in_dictDef553 = null;
    public static final BitSet FOLLOW_21_in_templateDef352 = null;
    public static final BitSet FOLLOW_21_in_templateDef432 = null;
    public static final BitSet FOLLOW_22_in_oldStyleHeader201 = null;
    public static final BitSet FOLLOW_23_in_formalArg492 = null;
    public static final BitSet FOLLOW_23_in_formalArg512 = null;
    public static final BitSet FOLLOW_24_in_templateDef313 = null;
    public static final BitSet FOLLOW_25_in_defaultValuePair660 = null;
    public static final BitSet FOLLOW_26_in_delimiters250 = null;
    public static final BitSet FOLLOW_27_in_oldStyleHeader162 = null;
    public static final BitSet FOLLOW_28_in_oldStyleHeader182 = null;
    public static final BitSet FOLLOW_29_in_group101 = null;
    public static final BitSet FOLLOW_29_in_group111 = null;
    public static final BitSet FOLLOW_ANONYMOUS_TEMPLATE_in_keyValue716 = null;
    public static final BitSet FOLLOW_BIGSTRING_NO_NL_in_keyValue708 = null;
    public static final BitSet FOLLOW_BIGSTRING_NO_NL_in_templateDef395 = null;
    public static final BitSet FOLLOW_BIGSTRING_in_keyValue699 = null;
    public static final BitSet FOLLOW_BIGSTRING_in_templateDef383 = null;
    public static final BitSet FOLLOW_EOF_in_group145 = null;
    public static final BitSet FOLLOW_FALSE_in_keyValue743 = null;
    public static final BitSet FOLLOW_ID_in_dictDef551 = null;
    public static final BitSet FOLLOW_ID_in_formalArg486 = null;
    public static final BitSet FOLLOW_ID_in_group122 = null;
    public static final BitSet FOLLOW_ID_in_group127 = null;
    public static final BitSet FOLLOW_ID_in_groupName223 = null;
    public static final BitSet FOLLOW_ID_in_groupName232 = null;
    public static final BitSet FOLLOW_ID_in_keyValue768 = null;
    public static final BitSet FOLLOW_ID_in_oldStyleHeader164 = null;
    public static final BitSet FOLLOW_ID_in_oldStyleHeader170 = null;
    public static final BitSet FOLLOW_ID_in_oldStyleHeader184 = null;
    public static final BitSet FOLLOW_ID_in_oldStyleHeader189 = null;
    public static final BitSet FOLLOW_ID_in_templateDef317 = null;
    public static final BitSet FOLLOW_ID_in_templateDef323 = null;
    public static final BitSet FOLLOW_ID_in_templateDef335 = null;
    public static final BitSet FOLLOW_ID_in_templateDef430 = null;
    public static final BitSet FOLLOW_ID_in_templateDef436 = null;
    public static final BitSet FOLLOW_LBRACK_in_dict587 = null;
    public static final BitSet FOLLOW_LBRACK_in_formalArg516 = null;
    public static final BitSet FOLLOW_LBRACK_in_keyValue753 = null;
    public static final BitSet FOLLOW_RBRACK_in_dict592 = null;
    public static final BitSet FOLLOW_RBRACK_in_formalArg518 = null;
    public static final BitSet FOLLOW_RBRACK_in_keyValue755 = null;
    public static final BitSet FOLLOW_STRING_in_delimiters254 = null;
    public static final BitSet FOLLOW_STRING_in_delimiters260 = null;
    public static final BitSet FOLLOW_STRING_in_group103 = null;
    public static final BitSet FOLLOW_STRING_in_keyValue723 = null;
    public static final BitSet FOLLOW_STRING_in_keyValuePair678 = null;
    public static final BitSet FOLLOW_STRING_in_templateDef368 = null;
    public static final BitSet FOLLOW_TRUE_in_keyValue733 = null;
    public static final BitSet FOLLOW_def_in_group139 = null;
    public static final BitSet FOLLOW_defaultValuePair_in_dictPairs626 = null;
    public static final BitSet FOLLOW_defaultValuePair_in_dictPairs637 = null;
    public static final BitSet FOLLOW_delimiters_in_group91 = null;
    public static final BitSet FOLLOW_dictDef_in_def289 = null;
    public static final BitSet FOLLOW_dictPairs_in_dict589 = null;
    public static final BitSet FOLLOW_dict_in_dictDef555 = null;
    public static final BitSet FOLLOW_formalArg_in_formalArgs462 = null;
    public static final BitSet FOLLOW_formalArg_in_formalArgs468 = null;
    public static final BitSet FOLLOW_formalArgs_in_templateDef339 = null;
    public static final BitSet FOLLOW_keyValuePair_in_dictPairs607 = null;
    public static final BitSet FOLLOW_keyValuePair_in_dictPairs618 = null;
    public static final BitSet FOLLOW_keyValue_in_defaultValuePair664 = null;
    public static final BitSet FOLLOW_keyValue_in_keyValuePair682 = null;
    public static final BitSet FOLLOW_oldStyleHeader_in_group86 = null;
    public static final BitSet FOLLOW_set_in_formalArg496 = null;
    public static final BitSet FOLLOW_templateDef_in_def284 = null;
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
    public static final String[] tokenNames = null;
    protected Stack<formalArgs_scope> formalArgs_stack;
    public STGroup group;

    public static class formalArgs_scope {
        boolean hasOptionalParameter;

        public formalArgs_scope() {
        }
    }

    static {
        tokenNames = new String[]{Grammar.INVALID_RULE_NAME, "<EOR>", "<DOWN>", "<UP>", "ANONYMOUS_TEMPLATE", "BIGSTRING", "BIGSTRING_NO_NL", "COMMENT", "FALSE", "ID", "LBRACK", "LINE_COMMENT", "RBRACK", "STRING", "TRUE", "WS", "'('", "')'", "','", "'.'", "':'", "'::='", "';'", "'='", "'@'", "'default'", "'delimiters'", "'group'", "'implements'", "'import'"};
        FOLLOW_oldStyleHeader_in_group86 = new BitSet(new long[]{620757504});
        FOLLOW_delimiters_in_group91 = new BitSet(new long[]{553648640});
        FOLLOW_29_in_group101 = new BitSet(new long[]{8192});
        FOLLOW_STRING_in_group103 = new BitSet(new long[]{553648640});
        FOLLOW_29_in_group111 = new BitSet(new long[]{512});
        FOLLOW_ID_in_group122 = new BitSet(new long[]{554172928});
        FOLLOW_19_in_group125 = new BitSet(new long[]{512});
        FOLLOW_ID_in_group127 = new BitSet(new long[]{554172928});
        FOLLOW_def_in_group139 = new BitSet(new long[]{16777728});
        FOLLOW_EOF_in_group145 = new BitSet(new long[]{2});
        FOLLOW_27_in_oldStyleHeader162 = new BitSet(new long[]{512});
        FOLLOW_ID_in_oldStyleHeader164 = new BitSet(new long[]{273678336});
        FOLLOW_20_in_oldStyleHeader168 = new BitSet(new long[]{512});
        FOLLOW_ID_in_oldStyleHeader170 = new BitSet(new long[]{272629760});
        FOLLOW_28_in_oldStyleHeader182 = new BitSet(new long[]{512});
        FOLLOW_ID_in_oldStyleHeader184 = new BitSet(new long[]{4456448});
        FOLLOW_18_in_oldStyleHeader187 = new BitSet(new long[]{512});
        FOLLOW_ID_in_oldStyleHeader189 = new BitSet(new long[]{4456448});
        FOLLOW_22_in_oldStyleHeader201 = new BitSet(new long[]{2});
        FOLLOW_ID_in_groupName223 = new BitSet(new long[]{524290});
        FOLLOW_19_in_groupName228 = new BitSet(new long[]{512});
        FOLLOW_ID_in_groupName232 = new BitSet(new long[]{524290});
        FOLLOW_26_in_delimiters250 = new BitSet(new long[]{8192});
        FOLLOW_STRING_in_delimiters254 = new BitSet(new long[]{262144});
        FOLLOW_18_in_delimiters256 = new BitSet(new long[]{8192});
        FOLLOW_STRING_in_delimiters260 = new BitSet(new long[]{2});
        FOLLOW_templateDef_in_def284 = new BitSet(new long[]{2});
        FOLLOW_dictDef_in_def289 = new BitSet(new long[]{2});
        FOLLOW_24_in_templateDef313 = new BitSet(new long[]{512});
        FOLLOW_ID_in_templateDef317 = new BitSet(new long[]{524288});
        FOLLOW_19_in_templateDef319 = new BitSet(new long[]{512});
        FOLLOW_ID_in_templateDef323 = new BitSet(new long[]{65536});
        FOLLOW_16_in_templateDef325 = new BitSet(new long[]{131072});
        FOLLOW_17_in_templateDef327 = new BitSet(new long[]{2097152});
        FOLLOW_ID_in_templateDef335 = new BitSet(new long[]{65536});
        FOLLOW_16_in_templateDef337 = new BitSet(new long[]{131584});
        FOLLOW_formalArgs_in_templateDef339 = new BitSet(new long[]{131072});
        FOLLOW_17_in_templateDef341 = new BitSet(new long[]{2097152});
        FOLLOW_21_in_templateDef352 = new BitSet(new long[]{8290});
        FOLLOW_STRING_in_templateDef368 = new BitSet(new long[]{2});
        FOLLOW_BIGSTRING_in_templateDef383 = new BitSet(new long[]{2});
        FOLLOW_BIGSTRING_NO_NL_in_templateDef395 = new BitSet(new long[]{2});
        FOLLOW_ID_in_templateDef430 = new BitSet(new long[]{2097152});
        FOLLOW_21_in_templateDef432 = new BitSet(new long[]{512});
        FOLLOW_ID_in_templateDef436 = new BitSet(new long[]{2});
        FOLLOW_formalArg_in_formalArgs462 = new BitSet(new long[]{262146});
        FOLLOW_18_in_formalArgs466 = new BitSet(new long[]{512});
        FOLLOW_formalArg_in_formalArgs468 = new BitSet(new long[]{262146});
        FOLLOW_ID_in_formalArg486 = new BitSet(new long[]{8388610});
        FOLLOW_23_in_formalArg492 = new BitSet(new long[]{24848});
        FOLLOW_set_in_formalArg496 = new BitSet(new long[]{2});
        FOLLOW_23_in_formalArg512 = new BitSet(new long[]{RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_LBRACK_in_formalArg516 = new BitSet(new long[]{4096});
        FOLLOW_RBRACK_in_formalArg518 = new BitSet(new long[]{2});
        FOLLOW_ID_in_dictDef551 = new BitSet(new long[]{2097152});
        FOLLOW_21_in_dictDef553 = new BitSet(new long[]{RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_dict_in_dictDef555 = new BitSet(new long[]{2});
        FOLLOW_LBRACK_in_dict587 = new BitSet(new long[]{33562624});
        FOLLOW_dictPairs_in_dict589 = new BitSet(new long[]{4096});
        FOLLOW_RBRACK_in_dict592 = new BitSet(new long[]{2});
        FOLLOW_keyValuePair_in_dictPairs607 = new BitSet(new long[]{262146});
        FOLLOW_18_in_dictPairs616 = new BitSet(new long[]{8192});
        FOLLOW_keyValuePair_in_dictPairs618 = new BitSet(new long[]{262146});
        FOLLOW_18_in_dictPairs624 = new BitSet(new long[]{33554432});
        FOLLOW_defaultValuePair_in_dictPairs626 = new BitSet(new long[]{2});
        FOLLOW_defaultValuePair_in_dictPairs637 = new BitSet(new long[]{2});
        FOLLOW_25_in_defaultValuePair660 = new BitSet(new long[]{1048576});
        FOLLOW_20_in_defaultValuePair662 = new BitSet(new long[]{26480});
        FOLLOW_keyValue_in_defaultValuePair664 = new BitSet(new long[]{2});
        FOLLOW_STRING_in_keyValuePair678 = new BitSet(new long[]{1048576});
        FOLLOW_20_in_keyValuePair680 = new BitSet(new long[]{26480});
        FOLLOW_keyValue_in_keyValuePair682 = new BitSet(new long[]{2});
        FOLLOW_BIGSTRING_in_keyValue699 = new BitSet(new long[]{2});
        FOLLOW_BIGSTRING_NO_NL_in_keyValue708 = new BitSet(new long[]{2});
        FOLLOW_ANONYMOUS_TEMPLATE_in_keyValue716 = new BitSet(new long[]{2});
        FOLLOW_STRING_in_keyValue723 = new BitSet(new long[]{2});
        FOLLOW_TRUE_in_keyValue733 = new BitSet(new long[]{2});
        FOLLOW_FALSE_in_keyValue743 = new BitSet(new long[]{2});
        FOLLOW_LBRACK_in_keyValue753 = new BitSet(new long[]{4096});
        FOLLOW_RBRACK_in_keyValue755 = new BitSet(new long[]{2});
        FOLLOW_ID_in_keyValue768 = new BitSet(new long[]{2});
    }

    public GroupParser(TokenStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public final void def(String r10) throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L23 RecognitionException -> L44
        if (r5 != 24) goto L7;
    L6:
        char r11 = 1;
    L19:
        if (r11 == 1) goto L25;
        if (r11 != 2) goto L52;
        pushFollow(FOLLOW_dictDef_in_def289);     // Catch: Throwable -> L23 RecognitionException -> L44
        dictDef();     // Catch: Throwable -> L23 RecognitionException -> L44
        this.state._fsp--;     // Catch: Throwable -> L23 RecognitionException -> L44
        return;
    L52:
        return;
    L25:
        pushFollow(FOLLOW_templateDef_in_def284);     // Catch: Throwable -> L23 RecognitionException -> L44
        templateDef(r10);     // Catch: Throwable -> L23 RecognitionException -> L44
        this.state._fsp--;     // Catch: Throwable -> L23 RecognitionException -> L44
        return;
    L7:
        int r12 = 0;
        if (r5 != 9) goto L42;
        int r13 = this.input.LA(2);     // Catch: Throwable -> L23 RecognitionException -> L44
        if (r13 == 16) goto L6;
        if (r13 != 21) goto L35;
        int r14 = this.input.LA(3);     // Catch: Throwable -> L23 RecognitionException -> L44
        if (r14 == 9) goto L6;
        if (r14 != 10) goto L26;
        r11 = 2;
        goto L19
    L26:
        int r15 = this.input.mark();     // Catch: Throwable -> L23 RecognitionException -> L44
    L27:
        if (r12 >= 2) goto L32;
        this.input.consume();     // Catch: Throwable -> L29
        r12 = r12 + 1;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        this.input.rewind(r15);     // Catch: Throwable -> L23 RecognitionException -> L44
        throw th;     // Catch: Throwable -> L23 RecognitionException -> L44
    L32:
        throw new NoViableAltException("", 10, 3, this.input);     // Catch: Throwable -> L29
    L35:
        int r16 = this.input.mark();     // Catch: Throwable -> L23 RecognitionException -> L44
        this.input.consume();     // Catch: Throwable -> L38
        throw new NoViableAltException("", 10, 2, this.input);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        this.input.rewind(r16);     // Catch: Throwable -> L23 RecognitionException -> L44
        throw th;     // Catch: Throwable -> L23 RecognitionException -> L44
    L42:
        throw new NoViableAltException("", 10, 0, this.input);     // Catch: Throwable -> L23 RecognitionException -> L44
    L44:
        this.state.lastErrorIndex = this.input.index();
        error("garbled template definition starting at '" + this.input.LT(1).getText() + "'");
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final void defaultValuePair(Map<String, Object> r5) throws RecognitionException {
        match(this.input, 25, FOLLOW_25_in_defaultValuePair660);     // Catch: Throwable -> L4 RecognitionException -> L6
        match(this.input, 20, FOLLOW_20_in_defaultValuePair662);     // Catch: Throwable -> L4 RecognitionException -> L6
        pushFollow(FOLLOW_keyValue_in_defaultValuePair664);     // Catch: Throwable -> L4 RecognitionException -> L6
        Object r10 = keyValue();     // Catch: Throwable -> L4 RecognitionException -> L6
        this.state._fsp--;     // Catch: Throwable -> L4 RecognitionException -> L6
        r5.put("default", r10);     // Catch: Throwable -> L4 RecognitionException -> L6
    L13:
        return;
    L6:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L4:
        th = move-exception;
        throw th;
    }

    public final void delimiters() throws RecognitionException {
        match(this.input, 26, FOLLOW_26_in_delimiters250);     // Catch: Throwable -> L4 RecognitionException -> L6
        Token r5 = (Token) match(this.input, 13, FOLLOW_STRING_in_delimiters254);     // Catch: Throwable -> L4 RecognitionException -> L6
        match(this.input, 18, FOLLOW_18_in_delimiters256);     // Catch: Throwable -> L4 RecognitionException -> L6
        Token r10 = (Token) match(this.input, 13, FOLLOW_STRING_in_delimiters260);     // Catch: Throwable -> L4 RecognitionException -> L6
        STGroup r11 = this.group;     // Catch: Throwable -> L4 RecognitionException -> L6
        r11.delimiterStartChar = r5.getText().charAt(1);     // Catch: Throwable -> L4 RecognitionException -> L6
        STGroup r12 = this.group;     // Catch: Throwable -> L4 RecognitionException -> L6
        r12.delimiterStopChar = r10.getText().charAt(1);     // Catch: Throwable -> L4 RecognitionException -> L6
    L13:
        return;
    L6:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L4:
        th = move-exception;
        throw th;
    }

    public final Map<String, Object> dict() throws RecognitionException {
        HashMap r5 = new HashMap();
        match(this.input, 10, FOLLOW_LBRACK_in_dict587);     // Catch: Throwable -> L5 RecognitionException -> L7
        pushFollow(FOLLOW_dictPairs_in_dict589);     // Catch: Throwable -> L5 RecognitionException -> L7
        dictPairs(r5);     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 12, FOLLOW_RBRACK_in_dict592);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L5:
        th = move-exception;
        throw th;
    }

    public final void dictDef() throws RecognitionException {
        Token r5 = (Token) match(this.input, 9, FOLLOW_ID_in_dictDef551);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 21, FOLLOW_21_in_dictDef553);     // Catch: Throwable -> L5 RecognitionException -> L7
        pushFollow(FOLLOW_dict_in_dictDef555);     // Catch: Throwable -> L5 RecognitionException -> L7
        Map<String, Object> r10 = dict();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        STGroup r11 = this.group;     // Catch: Throwable -> L5 RecognitionException -> L7
        String r12 = null;
        if (r5 == null) goto L9;
        String r13 = r5.getText();     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        if (r11.rawGetDictionary(r13) == null) goto L13;
        this.group.errMgr.compileTimeError(ErrorType.MAP_REDEFINITION, null, r5);     // Catch: Throwable -> L5 RecognitionException -> L7
        return;
    L13:
        STGroup r14 = this.group;     // Catch: Throwable -> L5 RecognitionException -> L7
        if (r5 == null) goto L16;
        String r15 = r5.getText();     // Catch: Throwable -> L5 RecognitionException -> L7
    L18:
        if (r14.rawGetTemplate(r15) == null) goto L20;
        this.group.errMgr.compileTimeError(ErrorType.TEMPLATE_REDEFINITION_AS_MAP, null, r5);     // Catch: Throwable -> L5 RecognitionException -> L7
        return;
    L20:
        STGroup r16 = this.group;     // Catch: Throwable -> L5 RecognitionException -> L7
        if (r5 == null) goto L23;
        r12 = r5.getText();     // Catch: Throwable -> L5 RecognitionException -> L7
    L23:
        r16.defineDictionary(r12, r10);     // Catch: Throwable -> L5 RecognitionException -> L7
        return;
    L16:
        r15 = null;
        goto L18
    L9:
        r13 = null;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L5:
        th = move-exception;
        throw th;
    }

    public final void dictPairs(Map<String, Object> r10) throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L27
        if (r5 != 13) goto L7;
        char r11 = 1;
    L9:
        if (r11 == 1) goto L15;
        if (r11 != 2) goto L32;
        pushFollow(FOLLOW_defaultValuePair_in_dictPairs637);     // Catch: Throwable -> L13 RecognitionException -> L27
        defaultValuePair(r10);     // Catch: Throwable -> L13 RecognitionException -> L27
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L27
        return;
    L32:
        return;
    L15:
        pushFollow(FOLLOW_keyValuePair_in_dictPairs607);     // Catch: Throwable -> L13 RecognitionException -> L27
        keyValuePair(r10);     // Catch: Throwable -> L13 RecognitionException -> L27
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L27
    L17:
        if (this.input.LA(1) != 18) goto L22;
        if (this.input.LA(2) != 13) goto L22;
        match(this.input, 18, FOLLOW_18_in_dictPairs616);     // Catch: Throwable -> L13 RecognitionException -> L27
        pushFollow(FOLLOW_keyValuePair_in_dictPairs618);     // Catch: Throwable -> L13 RecognitionException -> L27
        keyValuePair(r10);     // Catch: Throwable -> L13 RecognitionException -> L27
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L27
    L22:
        if (this.input.LA(1) != 18) goto L34;
        match(this.input, 18, FOLLOW_18_in_dictPairs624);     // Catch: Throwable -> L13 RecognitionException -> L27
        pushFollow(FOLLOW_defaultValuePair_in_dictPairs626);     // Catch: Throwable -> L13 RecognitionException -> L27
        defaultValuePair(r10);     // Catch: Throwable -> L13 RecognitionException -> L27
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L27
        return;
    L34:
        return;
    L7:
        if (r5 != 25) goto L25;
        r11 = 2;
        goto L9
    L25:
        throw new NoViableAltException("", 19, 0, this.input);     // Catch: Throwable -> L13 RecognitionException -> L27
    L27:
        error("missing dictionary entry at '" + this.input.LT(1).getText() + "'");
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public void displayRecognitionError(String[] r5, RecognitionException r10) {
        String r11 = getErrorMessage(r10, r5);
        this.group.errMgr.groupSyntaxError(ErrorType.SYNTAX_ERROR, getSourceName(), r10, r11);
    }

    public void error(String r5) {
        NoViableAltException r10 = new NoViableAltException("", 0, 0, this.input);
        this.group.errMgr.groupSyntaxError(ErrorType.SYNTAX_ERROR, getSourceName(), r10, r5);
        recover(this.input, null);
    }

    public final void formalArg(List<FormalArgument> r17) throws RecognitionException {
        Token r5 = (Token) match(this.input, 9, FOLLOW_ID_in_formalArg486);     // Catch: Throwable -> L20 RecognitionException -> L22
        int r10 = this.input.LA(1);     // Catch: Throwable -> L20 RecognitionException -> L22
        if (r10 != 23) goto L26;
        int r11 = this.input.LA(2);     // Catch: Throwable -> L20 RecognitionException -> L22
        if (r11 == 4) goto L24;
        if (r11 == 8) goto L24;
        if (r11 < 13) goto L12;
        if (r11 <= 14) goto L24;
    L12:
        if (r11 != 10) goto L14;
        char r12 = 2;
    L30:
        String r13 = null;
        if (r12 == 1) goto L40;
        if (r12 == 2) goto L39;
        if (r12 == 3) goto L36;
    L38:
        Token r14 = null;
    L53:
        if (r5 == null) goto L55;
        r13 = r5.getText();     // Catch: Throwable -> L20 RecognitionException -> L22
    L55:
        r17.add(new FormalArgument(r13, r14));     // Catch: Throwable -> L20 RecognitionException -> L22
        return;
    L36:
        if (this.formalArgs_stack.peek().hasOptionalParameter == false) goto L38;
        this.group.errMgr.compileTimeError(ErrorType.REQUIRED_PARAMETER_AFTER_OPTIONAL, null, r5);     // Catch: Throwable -> L20 RecognitionException -> L22
        goto L38
    L39:
        match(this.input, 23, FOLLOW_23_in_formalArg512);     // Catch: Throwable -> L20 RecognitionException -> L22
        r14 = (Token) match(this.input, 10, FOLLOW_LBRACK_in_formalArg516);     // Catch: Throwable -> L20 RecognitionException -> L22
        match(this.input, 12, FOLLOW_RBRACK_in_formalArg518);     // Catch: Throwable -> L20 RecognitionException -> L22
        this.formalArgs_stack.peek().hasOptionalParameter = true;     // Catch: Throwable -> L20 RecognitionException -> L22
        goto L53
    L40:
        match(this.input, 23, FOLLOW_23_in_formalArg492);     // Catch: Throwable -> L20 RecognitionException -> L22
        r14 = this.input.LT(1);     // Catch: Throwable -> L20 RecognitionException -> L22
        if (this.input.LA(1) != 4) goto L43;
    L51:
        this.input.consume();     // Catch: Throwable -> L20 RecognitionException -> L22
        this.state.errorRecovery = false;     // Catch: Throwable -> L20 RecognitionException -> L22
        this.formalArgs_stack.peek().hasOptionalParameter = true;     // Catch: Throwable -> L20 RecognitionException -> L22
        goto L53
    L43:
        if (this.input.LA(1) == 8) goto L51;
        if (this.input.LA(1) < 13) goto L50;
        if (this.input.LA(1) <= 14) goto L51;
    L50:
        throw new MismatchedSetException(null, this.input);     // Catch: Throwable -> L20 RecognitionException -> L22
    L14:
        int r15 = this.input.mark();     // Catch: Throwable -> L20 RecognitionException -> L22
        this.input.consume();     // Catch: Throwable -> L17
        throw new NoViableAltException("", 16, 1, this.input);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.input.rewind(r15);     // Catch: Throwable -> L20 RecognitionException -> L22
        throw th;     // Catch: Throwable -> L20 RecognitionException -> L22
    L24:
        r12 = 1;
        goto L30
    L26:
        if (r10 < 17) goto L57;
        if (r10 > 18) goto L57;
        r12 = 3;
    L57:
        throw new NoViableAltException("", 16, 0, this.input);     // Catch: Throwable -> L20 RecognitionException -> L22
    L22:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final List<FormalArgument> formalArgs() throws RecognitionException {
        this.formalArgs_stack.push(new formalArgs_scope());
        ArrayList r5 = new ArrayList();
        this.formalArgs_stack.peek().hasOptionalParameter = false;
        int r10 = this.input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r10 != 9) goto L15;
        pushFollow(FOLLOW_formalArg_in_formalArgs462);     // Catch: Throwable -> L10 RecognitionException -> L12
        formalArg(r5);     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state._fsp--;     // Catch: Throwable -> L10 RecognitionException -> L12
    L7:
        if (this.input.LA(1) != 18) goto L16;
        match(this.input, 18, FOLLOW_18_in_formalArgs466);     // Catch: Throwable -> L10 RecognitionException -> L12
        pushFollow(FOLLOW_formalArg_in_formalArgs468);     // Catch: Throwable -> L10 RecognitionException -> L12
        formalArg(r5);     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state._fsp--;     // Catch: Throwable -> L10 RecognitionException -> L12
    L16:
        this.formalArgs_stack.pop();
        return r5;
    L15:
        if (r10 == 17) goto L16;
        throw new NoViableAltException("", 15, 0, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    L10:
        th = move-exception;
        this.formalArgs_stack.pop();
        throw th;
    L12:
        e = move-exception;
        reportError(e);     // Catch: Throwable -> L10
        recover(this.input, e);     // Catch: Throwable -> L10
        goto L16
    }

    public Parser[] getDelegates() {
        return new Parser[0];
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getGrammarFileName() {
        return "org\\stringtemplate\\v4\\compiler\\Group.g";
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.Parser, androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer, androidx.room.jarjarred.org.antlr.runtime.TokenSource
    public String getSourceName() {
        return new File(super.getSourceName()).getName();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String[] getTokenNames() {
        return tokenNames;
    }

    public final void group(STGroup r10, String r11) throws RecognitionException {
        ((GroupLexer) this.input.getTokenSource()).group = r10;
        this.group = r10;
    L8:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.input.LA(1) != 27) goto L11;
        pushFollow(FOLLOW_oldStyleHeader_in_group86);     // Catch: Throwable -> L6 RecognitionException -> L8
        oldStyleHeader();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
    L11:
        if (this.input.LA(1) != 26) goto L14;
        pushFollow(FOLLOW_delimiters_in_group91);     // Catch: Throwable -> L6 RecognitionException -> L8
        delimiters();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
    L14:
        if (this.input.LA(1) != 29) goto L20;
        int r5 = this.input.LA(2);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r5 != 13) goto L18;
        char r12 = 1;
    L21:
        if (r12 != 1) goto L22;
        match(this.input, 29, FOLLOW_29_in_group101);     // Catch: Throwable -> L6 RecognitionException -> L8
        r10.importTemplates((Token) match(this.input, 13, FOLLOW_STRING_in_group103));     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L14
    L22:
        if (r12 != 2) goto L23;
        match(this.input, 29, FOLLOW_29_in_group111);     // Catch: Throwable -> L6 RecognitionException -> L8
        reportError(new MismatchedTokenException(13, this.input));     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 9, FOLLOW_ID_in_group122);     // Catch: Throwable -> L6 RecognitionException -> L8
    L32:
        if (this.input.LA(1) != 19) goto L14;
        match(this.input, 19, FOLLOW_19_in_group125);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 9, FOLLOW_ID_in_group127);     // Catch: Throwable -> L6 RecognitionException -> L8
    L23:
        int r13 = this.input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r13 == 9) goto L29;
        if (r13 == 24) goto L29;
        match(this.input, -1, FOLLOW_EOF_in_group145);     // Catch: Throwable -> L6 RecognitionException -> L8
    L51:
        return;
    L29:
        pushFollow(FOLLOW_def_in_group139);     // Catch: Throwable -> L6 RecognitionException -> L8
        def(r11);     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L23
    L18:
        if (r5 != 9) goto L20;
        r12 = 2;
    L20:
        r12 = 3;
        goto L21
    }

    public final String groupName() throws RecognitionException {
        Token r5 = (Token) match(this.input, 9, FOLLOW_ID_in_groupName223);     // Catch: Throwable -> L5 RecognitionException -> L7
        if (r5 == null) goto L9;
        r5.getText();     // Catch: Throwable -> L5 RecognitionException -> L7
    L9:
        if (this.input.LA(1) != 19) goto L27;
        match(this.input, 19, FOLLOW_19_in_groupName228);     // Catch: Throwable -> L5 RecognitionException -> L7
        Token r10 = (Token) match(this.input, 9, FOLLOW_ID_in_groupName232);     // Catch: Throwable -> L5 RecognitionException -> L7
        if (r10 == null) goto L9;
        r10.getText();     // Catch: Throwable -> L5 RecognitionException -> L7
        goto L9
    L27:
        return null;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L5:
        th = move-exception;
        throw th;
    }

    public final Object keyValue() throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L22 RecognitionException -> L44
        if (r5 != 5) goto L7;
        char r10 = 1;
    L24:
        switch(r10) {
            case 1: goto L55;
            case 2: goto L54;
            case 3: goto L53;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            case 7: goto L31;
            case 8: goto L27;
            default: goto L47;
        };     // Catch: Throwable -> L22 RecognitionException -> L44
    L31:
        match(this.input, 10, FOLLOW_LBRACK_in_keyValue753);     // Catch: Throwable -> L22 RecognitionException -> L44
        match(this.input, 12, FOLLOW_RBRACK_in_keyValue755);     // Catch: Throwable -> L22 RecognitionException -> L44
        return Collections.emptyList();
    L32:
        match(this.input, 8, FOLLOW_FALSE_in_keyValue743);     // Catch: Throwable -> L22 RecognitionException -> L44
        return Boolean.FALSE;
    L33:
        match(this.input, 14, FOLLOW_TRUE_in_keyValue733);     // Catch: Throwable -> L22 RecognitionException -> L44
        return Boolean.TRUE;
    L34:
        Token r11 = (Token) match(this.input, 13, FOLLOW_STRING_in_keyValue723);     // Catch: Throwable -> L22 RecognitionException -> L44
        if (r11 == null) goto L37;
        String r12 = r11.getText();     // Catch: Throwable -> L22 RecognitionException -> L44
    L52:
        return Misc.replaceEscapes(Misc.strip(r12, 1));
    L37:
        r12 = null;
        goto L52
    L47:
        return null;
    L27:
        if (this.input.LT(1).getText().equals(STGroup.DICT_KEY) == false) goto L30;
        match(this.input, 9, FOLLOW_ID_in_keyValue768);     // Catch: Throwable -> L22 RecognitionException -> L44
        return STGroup.DICT_KEY;
    L30:
        throw new FailedPredicateException(this.input, "keyValue", "input.LT(1).getText().equals(\"key\")");     // Catch: Throwable -> L22 RecognitionException -> L44
    L53:
        return this.group.createSingleton((Token) match(this.input, 4, FOLLOW_ANONYMOUS_TEMPLATE_in_keyValue716));
    L54:
        return this.group.createSingleton((Token) match(this.input, 6, FOLLOW_BIGSTRING_NO_NL_in_keyValue708));
    L55:
        return this.group.createSingleton((Token) match(this.input, 5, FOLLOW_BIGSTRING_in_keyValue699));
    L7:
        if (r5 != 6) goto L9;
        r10 = 2;
        goto L24
    L9:
        if (r5 != 4) goto L11;
        r10 = 3;
        goto L24
    L11:
        if (r5 != 13) goto L13;
        r10 = 4;
        goto L24
    L13:
        if (r5 != 14) goto L15;
        r10 = 5;
        goto L24
    L15:
        if (r5 != 8) goto L17;
        r10 = 6;
        goto L24
    L17:
        if (r5 != 10) goto L19;
        r10 = 7;
        goto L24
    L19:
        if (r5 != 9) goto L21;
        this.input.LT(1).getText().equals(STGroup.DICT_KEY);     // Catch: Throwable -> L22 RecognitionException -> L44
    L21:
        r10 = '\b';
    L44:
        error("missing value for key at '" + this.input.LT(1).getText() + "'");
        return null;
    L22:
        th = move-exception;
        throw th;
    }

    public final void keyValuePair(Map<String, Object> r10) throws RecognitionException {
        Token r5 = (Token) match(this.input, 13, FOLLOW_STRING_in_keyValuePair678);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 20, FOLLOW_20_in_keyValuePair680);     // Catch: Throwable -> L5 RecognitionException -> L7
        pushFollow(FOLLOW_keyValue_in_keyValuePair682);     // Catch: Throwable -> L5 RecognitionException -> L7
        Object r11 = keyValue();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        if (r5 == null) goto L9;
        String r12 = r5.getText();     // Catch: Throwable -> L5 RecognitionException -> L7
    L10:
        r10.put(Misc.replaceEscapes(Misc.strip(r12, 1)), r11);     // Catch: Throwable -> L5 RecognitionException -> L7
    L17:
        return;
    L9:
        r12 = null;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L5:
        th = move-exception;
        throw th;
    }

    public final void oldStyleHeader() throws RecognitionException {
        match(this.input, 27, FOLLOW_27_in_oldStyleHeader162);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 9, FOLLOW_ID_in_oldStyleHeader164);     // Catch: Throwable -> L5 RecognitionException -> L7
        if (this.input.LA(1) != 20) goto L10;
        match(this.input, 20, FOLLOW_20_in_oldStyleHeader168);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 9, FOLLOW_ID_in_oldStyleHeader170);     // Catch: Throwable -> L5 RecognitionException -> L7
    L10:
        if (this.input.LA(1) != 28) goto L15;
        match(this.input, 28, FOLLOW_28_in_oldStyleHeader182);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 9, FOLLOW_ID_in_oldStyleHeader184);     // Catch: Throwable -> L5 RecognitionException -> L7
    L13:
        if (this.input.LA(1) != 18) goto L15;
        match(this.input, 18, FOLLOW_18_in_oldStyleHeader187);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 9, FOLLOW_ID_in_oldStyleHeader189);     // Catch: Throwable -> L5 RecognitionException -> L7
    L15:
        match(this.input, 22, FOLLOW_22_in_oldStyleHeader201);     // Catch: Throwable -> L5 RecognitionException -> L7
    L23:
        return;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L5:
        th = move-exception;
        throw th;
    }

    public final void templateDef(String r24) throws RecognitionException {
        int r5 = 1;
        int r10 = this.input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
        String r11 = "";
        int r12 = 0;
        if (r10 != 24) goto L7;
    L6:
        char r13 = 1;
    L13:
        if (r13 == 1) goto L21;
        if (r13 != 2) goto L108;
        Token r14 = (Token) match(this.input, 9, FOLLOW_ID_in_templateDef430);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 21, FOLLOW_21_in_templateDef432);     // Catch: Throwable -> L17 RecognitionException -> L19
        this.group.defineTemplateAlias(r14, (Token) match(this.input, 9, FOLLOW_ID_in_templateDef436));     // Catch: Throwable -> L17 RecognitionException -> L19
        return;
    L108:
        return;
    L21:
        int r15 = this.input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r15 != 24) goto L24;
        char r16 = 1;
    L27:
        if (r16 == 1) goto L32;
        if (r16 == 2) goto L31;
        Token r17 = null;
        Token r21 = null;
    L30:
        List<FormalArgument> r22 = null;
    L33:
        match(this.input, 21, FOLLOW_21_in_templateDef352);     // Catch: Throwable -> L17 RecognitionException -> L19
        Token r19 = this.input.LT(1);     // Catch: Throwable -> L17 RecognitionException -> L19
        int r18 = this.input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r18 == (-1)) goto L45;
        if (r18 == 9) goto L45;
        if (r18 == 13) goto L44;
        if (r18 == 24) goto L45;
        if (r18 == 5) goto L43;
        if (r18 != 6) goto L42;
        char r20 = 3;
    L46:
        if (r20 != 1) goto L48;
        Token r23 = (Token) match(this.input, 13, FOLLOW_STRING_in_templateDef368);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r23 != null) goto L65;
    L52:
        r11 = null;
    L66:
        if (r21 == null) goto L68;
        r12 = r21.getTokenIndex();     // Catch: Throwable -> L17 RecognitionException -> L19
    L68:
        if (r12 < 0) goto L110;
        String r25 = Misc.strip(r11, r5);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r21 == null) goto L72;
        String r26 = r21.getText();     // Catch: Throwable -> L17 RecognitionException -> L19
    L74:
        if (r24.length() <= 0) goto L80;
        StringBuilder r27 = new StringBuilder();     // Catch: Throwable -> L17 RecognitionException -> L19
        r27.append(r24);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r21 == null) goto L78;
        String r28 = r21.getText();     // Catch: Throwable -> L17 RecognitionException -> L19
    L79:
        r27.append(r28);     // Catch: Throwable -> L17 RecognitionException -> L19
        r26 = r27.toString();     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L80
    L78:
        r28 = null;
    L80:
        String r110 = r26;
        if (r17 == null) goto L83;
        String r111 = r17.getText();     // Catch: Throwable -> L17 RecognitionException -> L19
    L84:
        if (r111 != null) goto L86;
    L90:
        String r112 = r111;
    L91:
        this.group.defineTemplateOrRegion(r110, r112, r19, r25, r21, r22);     // Catch: Throwable -> L17 RecognitionException -> L19
        return;
    L86:
        if (r111.length() <= 0) goto L90;
        if (r24.length() <= 0) goto L90;
        r112 = r24.concat(r111);     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L91
    L83:
        r111 = null;
        goto L84
    L72:
        r26 = null;
        goto L74
    L110:
        return;
    L65:
        r11 = r23.getText();     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L66
    L48:
        if (r20 == 2) goto L60;
        if (r20 == 3) goto L54;
        if (r20 == 4) goto L53;
        r5 = 0;
        goto L52
    L53:
        String r29 = "missing template at '" + this.input.LT(1).getText() + "'";     // Catch: Throwable -> L17 RecognitionException -> L19
        this.group.errMgr.groupSyntaxError(ErrorType.SYNTAX_ERROR, getSourceName(), new NoViableAltException("", 0, 0, this.input), r29);     // Catch: Throwable -> L17 RecognitionException -> L19
        r5 = 0;
        goto L66
    L54:
        Token r30 = (Token) match(this.input, 6, FOLLOW_BIGSTRING_NO_NL_in_templateDef395);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r30 == null) goto L58;
        String r31 = r30.getText();     // Catch: Throwable -> L17 RecognitionException -> L19
    L57:
        r11 = r31;
    L59:
        r5 = 2;
    L58:
        r11 = null;
        goto L59
    L60:
        Token r32 = (Token) match(this.input, 5, FOLLOW_BIGSTRING_in_templateDef383);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r32 == null) goto L58;
        r31 = r32.getText();     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L57
    L42:
        throw new NoViableAltException("", 12, 0, this.input);     // Catch: Throwable -> L17 RecognitionException -> L19
    L43:
        r20 = 2;
        goto L46
    L44:
        r20 = 1;
    L45:
        r20 = 4;
        goto L46
    L31:
        Token r33 = (Token) match(this.input, 9, FOLLOW_ID_in_templateDef335);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 16, FOLLOW_16_in_templateDef337);     // Catch: Throwable -> L17 RecognitionException -> L19
        pushFollow(FOLLOW_formalArgs_in_templateDef339);     // Catch: Throwable -> L17 RecognitionException -> L19
        List<FormalArgument> r34 = formalArgs();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 17, FOLLOW_17_in_templateDef341);     // Catch: Throwable -> L17 RecognitionException -> L19
        r21 = r33;
        r22 = r34;
        r17 = null;
        goto L33
    L32:
        match(this.input, 24, FOLLOW_24_in_templateDef313);     // Catch: Throwable -> L17 RecognitionException -> L19
        r17 = (Token) match(this.input, 9, FOLLOW_ID_in_templateDef317);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 19, FOLLOW_19_in_templateDef319);     // Catch: Throwable -> L17 RecognitionException -> L19
        Token r113 = (Token) match(this.input, 9, FOLLOW_ID_in_templateDef323);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 16, FOLLOW_16_in_templateDef325);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 17, FOLLOW_17_in_templateDef327);     // Catch: Throwable -> L17 RecognitionException -> L19
        r21 = r113;
        goto L30
    L24:
        if (r15 != 9) goto L93;
        r16 = 2;
        goto L27
    L93:
        throw new NoViableAltException("", 11, 0, this.input);     // Catch: Throwable -> L17 RecognitionException -> L19
    L7:
        if (r10 != 9) goto L101;
        int r35 = this.input.LA(2);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r35 == 16) goto L6;
        if (r35 != 21) goto L94;
        r13 = 2;
        goto L13
    L94:
        int r36 = this.input.mark();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.input.consume();     // Catch: Throwable -> L97
        throw new NoViableAltException("", 13, 2, this.input);     // Catch: Throwable -> L97
    L97:
        th = move-exception;
        this.input.rewind(r36);     // Catch: Throwable -> L17 RecognitionException -> L19
        throw th;     // Catch: Throwable -> L17 RecognitionException -> L19
    L101:
        throw new NoViableAltException("", 13, 0, this.input);     // Catch: Throwable -> L17 RecognitionException -> L19
    L19:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public GroupParser(TokenStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.formalArgs_stack = new Stack();
    }
}
