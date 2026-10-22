package androidx.room.jarjarred.org.antlr.v4.codegen;

import androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer;
import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.runtime.DFA;
import androidx.room.jarjarred.org.antlr.runtime.EarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeParser;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeRuleReturnScope;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Choice;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.CodeBlockForAlt;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.PlusBlock;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.SrcOp;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.StarBlock;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes.dex */
public class SourceGenTriggers extends TreeParser {
    public static final int ACTION = 4;
    public static final int ACTION_CHAR_LITERAL = 5;
    public static final int ACTION_ESC = 6;
    public static final int ACTION_STRING_LITERAL = 7;
    public static final int ALT = 74;
    public static final int ALTLIST = 75;
    public static final int ARG = 76;
    public static final int ARGLIST = 77;
    public static final int ARG_ACTION = 8;
    public static final int ARG_OR_CHARSET = 9;
    public static final int ASSIGN = 10;
    public static final int AT = 11;
    public static final int BLOCK = 78;
    public static final int CATCH = 12;
    public static final int CHANNELS = 13;
    public static final int CHAR_RANGE = 79;
    public static final int CLOSURE = 80;
    public static final int COLON = 14;
    public static final int COLONCOLON = 15;
    public static final int COMBINED = 81;
    public static final int COMMA = 16;
    public static final int COMMENT = 17;
    static final short[] DFA7_accept = null;
    static final String DFA7_acceptS = "\u0004\uffff\u0001\u0001\u0001\u0002\u000e\uffff";
    static final short[] DFA7_eof = null;
    static final String DFA7_eofS = "\u0014\uffff";
    static final short[] DFA7_eot = null;
    static final String DFA7_eotS = "\u0014\uffff";
    static final char[] DFA7_max = null;
    static final String DFA7_maxS = "\u0001J\u0001\u0002\u0001d\u0001\u0002\u0002\uffff\u0002\u001c\u0001\u0002\u0001d\u0001\u001c\u0001>\u0004\u0003\u0004\u001c";
    static final char[] DFA7_min = null;
    static final String DFA7_minS = "\u0001J\u0001\u0002\u0001\u0004\u0001\u0002\u0002\uffff\u0001\n\u0001\u0003\u0001\u0002\u0001\u0004\u0001\u001c\u0001\u0004\b\u0003";
    static final short[] DFA7_special = null;
    static final String DFA7_specialS = "\u0014\uffff}>";
    static final short[][] DFA7_transition = null;
    static final String[] DFA7_transitionS = null;
    public static final int DOC_COMMENT = 18;
    public static final int DOLLAR = 19;
    public static final int DOT = 20;
    public static final int ELEMENT_OPTIONS = 82;
    public static final int EOF = -1;
    public static final int EPSILON = 83;
    public static final int ERRCHAR = 21;
    public static final int ESC_SEQ = 22;
    public static final int FINALLY = 23;
    public static final BitSet FOLLOW_ACTION_in_element282 = null;
    public static final BitSet FOLLOW_ACTION_in_element311 = null;
    public static final BitSet FOLLOW_ACTION_in_elementOption904 = null;
    public static final BitSet FOLLOW_ALT_in_alt191 = null;
    public static final BitSet FOLLOW_ALT_in_alt212 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleref687 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_terminal782 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption868 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption884 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption900 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption916 = null;
    public static final BitSet FOLLOW_ASSIGN_in_labeledElement347 = null;
    public static final BitSet FOLLOW_ASSIGN_in_labeledElement379 = null;
    public static final BitSet FOLLOW_BLOCK_in_block84 = null;
    public static final BitSet FOLLOW_CLOSURE_in_subrule441 = null;
    public static final BitSet FOLLOW_DOT_in_atom567 = null;
    public static final BitSet FOLLOW_DOT_in_atom579 = null;
    public static final BitSet FOLLOW_ELEMENT_OPTIONS_in_elementOptions836 = null;
    public static final BitSet FOLLOW_EPSILON_in_alt217 = null;
    public static final BitSet FOLLOW_ID_in_atom569 = null;
    public static final BitSet FOLLOW_ID_in_atom581 = null;
    public static final BitSet FOLLOW_ID_in_elementOption857 = null;
    public static final BitSet FOLLOW_ID_in_elementOption870 = null;
    public static final BitSet FOLLOW_ID_in_elementOption872 = null;
    public static final BitSet FOLLOW_ID_in_elementOption886 = null;
    public static final BitSet FOLLOW_ID_in_elementOption902 = null;
    public static final BitSet FOLLOW_ID_in_elementOption918 = null;
    public static final BitSet FOLLOW_ID_in_labeledElement349 = null;
    public static final BitSet FOLLOW_ID_in_labeledElement366 = null;
    public static final BitSet FOLLOW_ID_in_labeledElement381 = null;
    public static final BitSet FOLLOW_ID_in_labeledElement398 = null;
    public static final BitSet FOLLOW_INT_in_elementOption920 = null;
    public static final BitSet FOLLOW_NOT_in_atom538 = null;
    public static final BitSet FOLLOW_OPTIONAL_in_subrule421 = null;
    public static final BitSet FOLLOW_OPTIONS_in_block88 = null;
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_labeledElement364 = null;
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_labeledElement396 = null;
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_subrule456 = null;
    public static final BitSet FOLLOW_RANGE_in_range718 = null;
    public static final BitSet FOLLOW_RULE_REF_in_ruleref685 = null;
    public static final BitSet FOLLOW_SEMPRED_in_element297 = null;
    public static final BitSet FOLLOW_SEMPRED_in_element325 = null;
    public static final BitSet FOLLOW_SET_in_blockSet506 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_elementOption888 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_range722 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_range726 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal751 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal766 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal780 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal796 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal812 = null;
    public static final BitSet FOLLOW_WILDCARD_in_atom594 = null;
    public static final BitSet FOLLOW_WILDCARD_in_atom613 = null;
    public static final BitSet FOLLOW_alt_in_alternative161 = null;
    public static final BitSet FOLLOW_alternative_in_block109 = null;
    public static final BitSet FOLLOW_atom_in_atom542 = null;
    public static final BitSet FOLLOW_atom_in_blockSet508 = null;
    public static final BitSet FOLLOW_atom_in_element257 = null;
    public static final BitSet FOLLOW_atom_in_labeledElement351 = null;
    public static final BitSet FOLLOW_atom_in_labeledElement368 = null;
    public static final BitSet FOLLOW_blockSet_in_atom661 = null;
    public static final BitSet FOLLOW_block_in_dummy61 = null;
    public static final BitSet FOLLOW_block_in_labeledElement383 = null;
    public static final BitSet FOLLOW_block_in_labeledElement400 = null;
    public static final BitSet FOLLOW_block_in_subrule425 = null;
    public static final BitSet FOLLOW_block_in_subrule445 = null;
    public static final BitSet FOLLOW_block_in_subrule460 = null;
    public static final BitSet FOLLOW_block_in_subrule476 = null;
    public static final BitSet FOLLOW_elementOption_in_elementOptions838 = null;
    public static final BitSet FOLLOW_elementOptions_in_alt193 = null;
    public static final BitSet FOLLOW_elementOptions_in_alt214 = null;
    public static final BitSet FOLLOW_elementOptions_in_element313 = null;
    public static final BitSet FOLLOW_elementOptions_in_element327 = null;
    public static final BitSet FOLLOW_elementOptions_in_ruleref690 = null;
    public static final BitSet FOLLOW_element_in_alt198 = null;
    public static final BitSet FOLLOW_labeledElement_in_element246 = null;
    public static final BitSet FOLLOW_range_in_atom552 = null;
    public static final BitSet FOLLOW_ruleref_in_atom583 = null;
    public static final BitSet FOLLOW_ruleref_in_atom649 = null;
    public static final BitSet FOLLOW_subrule_in_element267 = null;
    public static final BitSet FOLLOW_terminal_in_atom571 = null;
    public static final BitSet FOLLOW_terminal_in_atom632 = null;
    public static final int FRAGMENT = 24;
    public static final int GRAMMAR = 25;
    public static final int GT = 26;
    public static final int HEX_DIGIT = 27;
    public static final int ID = 28;
    public static final int IMPORT = 29;
    public static final int INITACTION = 84;
    public static final int INT = 30;
    public static final int LABEL = 85;
    public static final int LEXER = 31;
    public static final int LEXER_ACTION_CALL = 86;
    public static final int LEXER_ALT_ACTION = 87;
    public static final int LEXER_CHAR_SET = 32;
    public static final int LIST = 88;
    public static final int LOCALS = 33;
    public static final int LPAREN = 34;
    public static final int LT = 35;
    public static final int MODE = 36;
    public static final int NESTED_ACTION = 37;
    public static final int NLCHARS = 38;
    public static final int NOT = 39;
    public static final int NameChar = 40;
    public static final int NameStartChar = 41;
    public static final int OPTIONAL = 89;
    public static final int OPTIONS = 42;
    public static final int OR = 43;
    public static final int PARSER = 44;
    public static final int PLUS = 45;
    public static final int PLUS_ASSIGN = 46;
    public static final int POSITIVE_CLOSURE = 90;
    public static final int POUND = 47;
    public static final int PREC_RULE = 91;
    public static final int PRIVATE = 48;
    public static final int PROTECTED = 49;
    public static final int PUBLIC = 50;
    public static final int QUESTION = 51;
    public static final int RANGE = 52;
    public static final int RARROW = 53;
    public static final int RBRACE = 54;
    public static final int RESULT = 92;
    public static final int RET = 93;
    public static final int RETURNS = 55;
    public static final int RPAREN = 56;
    public static final int RULE = 94;
    public static final int RULEACTIONS = 95;
    public static final int RULEMODIFIERS = 96;
    public static final int RULES = 97;
    public static final int RULE_REF = 57;
    public static final int SEMI = 58;
    public static final int SEMPRED = 59;
    public static final int SET = 98;
    public static final int SRC = 60;
    public static final int STAR = 61;
    public static final int STRING_LITERAL = 62;
    public static final int SYNPRED = 63;
    public static final int TEMPLATE = 99;
    public static final int THROWS = 64;
    public static final int TOKENS_SPEC = 65;
    public static final int TOKEN_REF = 66;
    public static final int TREE_GRAMMAR = 67;
    public static final int UNICODE_ESC = 68;
    public static final int UNICODE_EXTENDED_ESC = 69;
    public static final int UnicodeBOM = 70;
    public static final int WILDCARD = 100;
    public static final int WS = 71;
    public static final int WSCHARS = 72;
    public static final int WSNLCHARS = 73;
    public static final String[] tokenNames = null;
    public OutputModelController controller;
    protected DFA7 dfa7;
    public boolean hasLookaheadBlock;

    public class DFA7 extends DFA {
        final /* synthetic */ SourceGenTriggers this$0;

        public DFA7(SourceGenTriggers r5, BaseRecognizer r10) {
            this.this$0 = r5;
            this.recognizer = r10;
            this.decisionNumber = 7;
            this.eot = SourceGenTriggers.DFA7_eot;
            this.eof = SourceGenTriggers.DFA7_eof;
            this.min = SourceGenTriggers.DFA7_min;
            this.max = SourceGenTriggers.DFA7_max;
            this.accept = SourceGenTriggers.DFA7_accept;
            this.special = SourceGenTriggers.DFA7_special;
            this.transition = SourceGenTriggers.DFA7_transition;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.DFA
        public String getDescription() {
            return "89:1: alt[boolean outerMost] returns [CodeBlockForAlt altCodeBlock, List<SrcOp> ops] : ( ^( ALT ( elementOptions )? ( element )+ ) | ^( ALT ( elementOptions )? EPSILON ) );";
        }
    }

    public static class alt_return extends TreeRuleReturnScope {
        public CodeBlockForAlt altCodeBlock;
        public List<SrcOp> ops;

        public alt_return() {
        }
    }

    public static class alternative_return extends TreeRuleReturnScope {
        public CodeBlockForAlt altCodeBlock;
        public List<SrcOp> ops;

        public alternative_return() {
        }
    }

    static {
        tokenNames = new String[]{Grammar.INVALID_RULE_NAME, "<EOR>", "<DOWN>", "<UP>", "ACTION", "ACTION_CHAR_LITERAL", "ACTION_ESC", "ACTION_STRING_LITERAL", "ARG_ACTION", "ARG_OR_CHARSET", "ASSIGN", "AT", "CATCH", "CHANNELS", "COLON", "COLONCOLON", "COMMA", "COMMENT", "DOC_COMMENT", "DOLLAR", "DOT", "ERRCHAR", "ESC_SEQ", "FINALLY", "FRAGMENT", "GRAMMAR", "GT", "HEX_DIGIT", "ID", "IMPORT", "INT", "LEXER", "LEXER_CHAR_SET", "LOCALS", "LPAREN", "LT", "MODE", "NESTED_ACTION", "NLCHARS", "NOT", "NameChar", "NameStartChar", "OPTIONS", "OR", "PARSER", "PLUS", "PLUS_ASSIGN", "POUND", "PRIVATE", "PROTECTED", "PUBLIC", "QUESTION", "RANGE", "RARROW", "RBRACE", "RETURNS", "RPAREN", "RULE_REF", "SEMI", "SEMPRED", "SRC", "STAR", "STRING_LITERAL", "SYNPRED", "THROWS", "TOKENS_SPEC", "TOKEN_REF", "TREE_GRAMMAR", "UNICODE_ESC", "UNICODE_EXTENDED_ESC", "UnicodeBOM", "WS", "WSCHARS", "WSNLCHARS", "ALT", "ALTLIST", "ARG", "ARGLIST", "BLOCK", "CHAR_RANGE", "CLOSURE", "COMBINED", "ELEMENT_OPTIONS", "EPSILON", "INITACTION", "LABEL", "LEXER_ACTION_CALL", "LEXER_ALT_ACTION", "LIST", "OPTIONAL", "POSITIVE_CLOSURE", "PREC_RULE", "RESULT", "RET", "RULE", "RULEACTIONS", "RULEMODIFIERS", "RULES", "SET", "TEMPLATE", "WILDCARD"};
        String[] r5 = {"\u0001\u0001", "\u0001\u0002", "\u0001\u0004\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0001\uffff\u0001\u0003\u0001\u0005\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u0006", "", "", "\u0001\b\u0011\uffff\u0001\u0007", "\u0001\t\u0006\uffff\u0001\b\u0011\uffff\u0001\u0007", "\u0001\n", "\u0001\u0004\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0005\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u000b", "\u0001\u000e\u0017\uffff\u0001\f\u0001\uffff\u0001\u000f\u001f\uffff\u0001\r", "\u0001\u0010", "\u0001\u0011", "\u0001\u0012", "\u0001\u0013", "\u0001\t\u0006\uffff\u0001\b\u0011\uffff\u0001\u0007", "\u0001\t\u0006\uffff\u0001\b\u0011\uffff\u0001\u0007", "\u0001\t\u0006\uffff\u0001\b\u0011\uffff\u0001\u0007", "\u0001\t\u0006\uffff\u0001\b\u0011\uffff\u0001\u0007"};
        DFA7_transitionS = r5;
        DFA7_eot = DFA.unpackEncodedString("\u0014\uffff");
        DFA7_eof = DFA.unpackEncodedString("\u0014\uffff");
        DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
        DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
        DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
        DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
        int r10 = r5.length;
        DFA7_transition = new short[r10][];
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        DFA7_transition[r11] = DFA.unpackEncodedString(DFA7_transitionS[r11]);
        r11 = r11 + 1;
        goto L3
    L5:
        FOLLOW_block_in_dummy61 = new BitSet(new long[]{2});
        FOLLOW_BLOCK_in_block84 = new BitSet(new long[]{4});
        FOLLOW_OPTIONS_in_block88 = new BitSet(new long[]{4});
        FOLLOW_alternative_in_block109 = new BitSet(new long[]{8, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_alt_in_alternative161 = new BitSet(new long[]{2});
        FOLLOW_ALT_in_alt191 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_alt193 = new BitSet(new long[]{5336836476935078928L, 86000091140L});
        FOLLOW_element_in_alt198 = new BitSet(new long[]{5336836476935078936L, 86000091140L});
        FOLLOW_ALT_in_alt212 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_alt214 = new BitSet(new long[]{0, 524288});
        FOLLOW_EPSILON_in_alt217 = new BitSet(new long[]{8});
        FOLLOW_labeledElement_in_element246 = new BitSet(new long[]{2});
        FOLLOW_atom_in_element257 = new BitSet(new long[]{2});
        FOLLOW_subrule_in_element267 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_element282 = new BitSet(new long[]{2});
        FOLLOW_SEMPRED_in_element297 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_element311 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_element313 = new BitSet(new long[]{8});
        FOLLOW_SEMPRED_in_element325 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_element327 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_labeledElement347 = new BitSet(new long[]{4});
        FOLLOW_ID_in_labeledElement349 = new BitSet(new long[]{4760305355887476736L, 85899345924L});
        FOLLOW_atom_in_labeledElement351 = new BitSet(new long[]{8});
        FOLLOW_PLUS_ASSIGN_in_labeledElement364 = new BitSet(new long[]{4});
        FOLLOW_ID_in_labeledElement366 = new BitSet(new long[]{4760305355887476736L, 85899345924L});
        FOLLOW_atom_in_labeledElement368 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_labeledElement379 = new BitSet(new long[]{4});
        FOLLOW_ID_in_labeledElement381 = new BitSet(new long[]{0, Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_block_in_labeledElement383 = new BitSet(new long[]{8});
        FOLLOW_PLUS_ASSIGN_in_labeledElement396 = new BitSet(new long[]{4});
        FOLLOW_ID_in_labeledElement398 = new BitSet(new long[]{0, Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_block_in_labeledElement400 = new BitSet(new long[]{8});
        FOLLOW_OPTIONAL_in_subrule421 = new BitSet(new long[]{4});
        FOLLOW_block_in_subrule425 = new BitSet(new long[]{8});
        FOLLOW_CLOSURE_in_subrule441 = new BitSet(new long[]{4});
        FOLLOW_block_in_subrule445 = new BitSet(new long[]{8});
        FOLLOW_POSITIVE_CLOSURE_in_subrule456 = new BitSet(new long[]{4});
        FOLLOW_block_in_subrule460 = new BitSet(new long[]{8});
        FOLLOW_block_in_subrule476 = new BitSet(new long[]{2});
        FOLLOW_SET_in_blockSet506 = new BitSet(new long[]{4});
        FOLLOW_atom_in_blockSet508 = new BitSet(new long[]{4760305355887476744L, 85899345924L});
        FOLLOW_NOT_in_atom538 = new BitSet(new long[]{4});
        FOLLOW_atom_in_atom542 = new BitSet(new long[]{8});
        FOLLOW_range_in_atom552 = new BitSet(new long[]{2});
        FOLLOW_DOT_in_atom567 = new BitSet(new long[]{4});
        FOLLOW_ID_in_atom569 = new BitSet(new long[]{4611686018427387904L, 4});
        FOLLOW_terminal_in_atom571 = new BitSet(new long[]{8});
        FOLLOW_DOT_in_atom579 = new BitSet(new long[]{4});
        FOLLOW_ID_in_atom581 = new BitSet(new long[]{144115188075855872L});
        FOLLOW_ruleref_in_atom583 = new BitSet(new long[]{8});
        FOLLOW_WILDCARD_in_atom594 = new BitSet(new long[]{4});
        FOLLOW_WILDCARD_in_atom613 = new BitSet(new long[]{2});
        FOLLOW_terminal_in_atom632 = new BitSet(new long[]{2});
        FOLLOW_ruleref_in_atom649 = new BitSet(new long[]{2});
        FOLLOW_blockSet_in_atom661 = new BitSet(new long[]{2});
        FOLLOW_RULE_REF_in_ruleref685 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_ruleref687 = new BitSet(new long[]{8, 262144});
        FOLLOW_elementOptions_in_ruleref690 = new BitSet(new long[]{8});
        FOLLOW_RANGE_in_range718 = new BitSet(new long[]{4});
        FOLLOW_STRING_LITERAL_in_range722 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_range726 = new BitSet(new long[]{8});
        FOLLOW_STRING_LITERAL_in_terminal751 = new BitSet(new long[]{4});
        FOLLOW_STRING_LITERAL_in_terminal766 = new BitSet(new long[]{2});
        FOLLOW_TOKEN_REF_in_terminal780 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_terminal782 = new BitSet(new long[]{-16, 137438953471L});
        FOLLOW_TOKEN_REF_in_terminal796 = new BitSet(new long[]{4});
        FOLLOW_TOKEN_REF_in_terminal812 = new BitSet(new long[]{2});
        FOLLOW_ELEMENT_OPTIONS_in_elementOptions836 = new BitSet(new long[]{4});
        FOLLOW_elementOption_in_elementOptions838 = new BitSet(new long[]{268436488});
        FOLLOW_ID_in_elementOption857 = new BitSet(new long[]{2});
        FOLLOW_ASSIGN_in_elementOption868 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption870 = new BitSet(new long[]{268435456});
        FOLLOW_ID_in_elementOption872 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption884 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption886 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_elementOption888 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption900 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption902 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_elementOption904 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption916 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption918 = new BitSet(new long[]{1073741824});
        FOLLOW_INT_in_elementOption920 = new BitSet(new long[]{8});
    }

    public SourceGenTriggers(TreeNodeStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public final alt_return alt(boolean r11) throws RecognitionException {
        alt_return r5 = new alt_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        AltAST r12 = (AltAST) r10;
        if (r11 == false) goto L65;
        this.controller.setCurrentOuterMostAlt(r12.alt);
    L65:
        int r13 = this.dfa7.predict(this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r13 == 1) goto L17;
        if (r13 != 2) goto L64;
        match(this.input, 74, FOLLOW_ALT_in_alt212);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (this.input.LA(1) != 82) goto L16;
        pushFollow(FOLLOW_elementOptions_in_alt214);     // Catch: Throwable -> L12 RecognitionException -> L14
        elementOptions();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
    L16:
        match(this.input, 83, FOLLOW_EPSILON_in_alt217);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        OutputModelController r14 = this.controller;     // Catch: Throwable -> L12 RecognitionException -> L14
        r5.altCodeBlock = r14.epsilon(r14.getCurrentOuterMostAlt(), r11);     // Catch: Throwable -> L12 RecognitionException -> L14
    L64:
        return r5;
    L17:
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L12 RecognitionException -> L14
        OutputModelController r16 = this.controller;     // Catch: Throwable -> L12 RecognitionException -> L14
        CodeBlockForAlt r17 = r16.alternative(r16.getCurrentOuterMostAlt(), r11);     // Catch: Throwable -> L12 RecognitionException -> L14
        r5.altCodeBlock = r17;     // Catch: Throwable -> L12 RecognitionException -> L14
        r5.ops = r15;     // Catch: Throwable -> L12 RecognitionException -> L14
        r17.ops = r15;     // Catch: Throwable -> L12 RecognitionException -> L14
        this.controller.setCurrentBlock(r17);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 74, FOLLOW_ALT_in_alt191);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (this.input.LA(1) != 82) goto L20;
        pushFollow(FOLLOW_elementOptions_in_alt193);     // Catch: Throwable -> L12 RecognitionException -> L14
        elementOptions();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
    L20:
        int r18 = 0;
    L21:
        int r19 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r19 != 4) goto L24;
    L58:
        pushFollow(FOLLOW_element_in_alt198);     // Catch: Throwable -> L12 RecognitionException -> L14
        List<? extends SrcOp> r20 = element();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r20 == null) goto L61;
        r15.addAll(r20);     // Catch: Throwable -> L12 RecognitionException -> L14
    L61:
        r18 = r18 + 1;
        goto L21
    L24:
        if (r19 == 10) goto L58;
        if (r19 == 20) goto L58;
        if (r19 == 39) goto L58;
        if (r19 == 46) goto L58;
        if (r19 == 52) goto L58;
        if (r19 == 57) goto L58;
        if (r19 == 59) goto L58;
        if (r19 == 62) goto L58;
        if (r19 == 66) goto L58;
        if (r19 == 78) goto L58;
        if (r19 == 80) goto L58;
        if (r19 < 89) goto L50;
        if (r19 <= 90) goto L58;
    L50:
        if (r19 == 98) goto L58;
        if (r19 == 100) goto L58;
        if (r18 < 1) goto L57;
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L64
    L57:
        throw new EarlyExitException(5, this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L12:
        th = move-exception;
        throw th;
    }

    public final alternative_return alternative() throws RecognitionException {
        alternative_return r5 = new alternative_return();
        r5.start = this.input.LT(1);
        boolean r10 = inContext("RULE BLOCK");
        pushFollow(FOLLOW_alt_in_alternative161);     // Catch: Throwable -> L6 RecognitionException -> L8
        alt_return r11 = alt(r10);     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        List<SrcOp> r12 = null;
        if (r11 == null) goto L10;
        CodeBlockForAlt r13 = r11.altCodeBlock;     // Catch: Throwable -> L6 RecognitionException -> L8
    L11:
        r5.altCodeBlock = r13;     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r11 == null) goto L14;
        r12 = r11.ops;     // Catch: Throwable -> L6 RecognitionException -> L8
    L14:
        r5.ops = r12;     // Catch: Throwable -> L6 RecognitionException -> L8
        this.controller.finishAlternative(r13, r12, r10);     // Catch: Throwable -> L6 RecognitionException -> L8
    L18:
        return r5;
    L10:
        r13 = null;
    L8:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L6:
        th = move-exception;
        throw th;
    }

    public final List<SrcOp> atom(GrammarAST r17, boolean r18) throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L49 RecognitionException -> L51
        if (r5 == 20) goto L61;
        if (r5 != 39) goto L8;
        char r10 = 1;
    L83:
        switch(r10) {
            case 1: goto L95;
            case 2: goto L94;
            case 3: goto L92;
            case 4: goto L91;
            case 5: goto L90;
            case 6: goto L138;
            case 7: goto L88;
            case 8: goto L87;
            case 9: goto L85;
            default: goto L140;
        };     // Catch: Throwable -> L49 RecognitionException -> L51
    L85:
        pushFollow(FOLLOW_blockSet_in_atom661);     // Catch: Throwable -> L49 RecognitionException -> L51
        List<SrcOp> r11 = blockSet(r17, r18);     // Catch: Throwable -> L49 RecognitionException -> L51
        this.state._fsp--;     // Catch: Throwable -> L49 RecognitionException -> L51
    L137:
        return r11;
    L87:
        pushFollow(FOLLOW_ruleref_in_atom649);     // Catch: Throwable -> L49 RecognitionException -> L51
        r11 = ruleref(r17);     // Catch: Throwable -> L49 RecognitionException -> L51
        this.state._fsp--;     // Catch: Throwable -> L49 RecognitionException -> L51
        goto L137
    L88:
        pushFollow(FOLLOW_terminal_in_atom632);     // Catch: Throwable -> L49 RecognitionException -> L51
        r11 = terminal(r17);     // Catch: Throwable -> L49 RecognitionException -> L51
        this.state._fsp--;     // Catch: Throwable -> L49 RecognitionException -> L51
        goto L137
    L90:
        GrammarAST r12 = (GrammarAST) match(this.input, 100, FOLLOW_WILDCARD_in_atom594);     // Catch: Throwable -> L49 RecognitionException -> L51
        match(this.input, 2, null);     // Catch: Throwable -> L49 RecognitionException -> L51
        matchAny(this.input);     // Catch: Throwable -> L49 RecognitionException -> L51
        match(this.input, 3, null);     // Catch: Throwable -> L49 RecognitionException -> L51
        return this.controller.wildcard(r12, r17);
    L91:
        match(this.input, 20, FOLLOW_DOT_in_atom579);     // Catch: Throwable -> L49 RecognitionException -> L51
        match(this.input, 2, null);     // Catch: Throwable -> L49 RecognitionException -> L51
        match(this.input, 28, FOLLOW_ID_in_atom581);     // Catch: Throwable -> L49 RecognitionException -> L51
        pushFollow(FOLLOW_ruleref_in_atom583);     // Catch: Throwable -> L49 RecognitionException -> L51
        ruleref(r17);     // Catch: Throwable -> L49 RecognitionException -> L51
        this.state._fsp--;     // Catch: Throwable -> L49 RecognitionException -> L51
        match(this.input, 3, null);     // Catch: Throwable -> L49 RecognitionException -> L51
        goto L140
    L92:
        match(this.input, 20, FOLLOW_DOT_in_atom567);     // Catch: Throwable -> L49 RecognitionException -> L51
        match(this.input, 2, null);     // Catch: Throwable -> L49 RecognitionException -> L51
        match(this.input, 28, FOLLOW_ID_in_atom569);     // Catch: Throwable -> L49 RecognitionException -> L51
        pushFollow(FOLLOW_terminal_in_atom571);     // Catch: Throwable -> L49 RecognitionException -> L51
        terminal(r17);     // Catch: Throwable -> L49 RecognitionException -> L51
        this.state._fsp--;     // Catch: Throwable -> L49 RecognitionException -> L51
        match(this.input, 3, null);     // Catch: Throwable -> L49 RecognitionException -> L51
        goto L140
    L94:
        pushFollow(FOLLOW_range_in_atom552);     // Catch: Throwable -> L49 RecognitionException -> L51
        r11 = range(r17);     // Catch: Throwable -> L49 RecognitionException -> L51
        this.state._fsp--;     // Catch: Throwable -> L49 RecognitionException -> L51
        goto L137
    L95:
        match(this.input, 39, FOLLOW_NOT_in_atom538);     // Catch: Throwable -> L49 RecognitionException -> L51
        match(this.input, 2, null);     // Catch: Throwable -> L49 RecognitionException -> L103
        pushFollow(FOLLOW_atom_in_atom542);     // Catch: Throwable -> L49 RecognitionException -> L51
        r11 = atom(r17, true);     // Catch: Throwable -> L49 RecognitionException -> L51
        this.state._fsp--;     // Catch: Throwable -> L49 RecognitionException -> L51
        match(this.input, 3, null);     // Catch: Throwable -> L49 RecognitionException -> L101
    L103:
        e = e;
        List<SrcOp> r13 = null;
    L121:
        reportError(e);
        recover(this.input, e);
        return r13;
    L140:
        return null;
    L138:
        return this.controller.wildcard((GrammarAST) match(this.input, 100, FOLLOW_WILDCARD_in_atom613), r17);
    L8:
        if (r5 == 52) goto L59;
        if (r5 == 57) goto L58;
        if (r5 == 62) goto L57;
        if (r5 == 66) goto L57;
        if (r5 == 98) goto L56;
        if (r5 != 100) goto L55;
        int r14 = this.input.LA(2);     // Catch: Throwable -> L49 RecognitionException -> L51
        if (r14 != 2) goto L18;
        r10 = 5;
        goto L83
    L18:
        if (r14 < 3) goto L21;
        if (r14 > 4) goto L21;
    L53:
        r10 = 6;
    L21:
        if (r14 == 10) goto L53;
        if (r14 == 20) goto L53;
        if (r14 == 39) goto L53;
        if (r14 == 46) goto L53;
        if (r14 == 52) goto L53;
        if (r14 == 57) goto L53;
        if (r14 == 59) goto L53;
        if (r14 == 62) goto L53;
        if (r14 == 66) goto L53;
        if (r14 == 78) goto L53;
        if (r14 == 80) goto L53;
        if (r14 >= 89) goto L39;
    L40:
        if (r14 == 98) goto L53;
        if (r14 == 100) goto L53;
        int r15 = this.input.mark();     // Catch: Throwable -> L49 RecognitionException -> L51
        this.input.consume();     // Catch: Throwable -> L46
        throw new NoViableAltException("", 13, 4, this.input);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        this.input.rewind(r15);     // Catch: Throwable -> L49 RecognitionException -> L51
        throw th;     // Catch: Throwable -> L49 RecognitionException -> L51
    L39:
        if (r14 <= 90) goto L53;
    L55:
        throw new NoViableAltException("", 13, 0, this.input);     // Catch: Throwable -> L49 RecognitionException -> L51
    L56:
        r10 = '\t';
    L57:
        r10 = 7;
        goto L83
    L58:
        r10 = '\b';
        goto L83
    L59:
        r10 = 2;
        goto L83
    L61:
        int r16 = 0;
        if (this.input.LA(2) == 2) goto L64;
        int r19 = this.input.mark();     // Catch: Throwable -> L49 RecognitionException -> L101
        this.input.consume();     // Catch: Throwable -> L117
        throw new NoViableAltException("", 13, 3, this.input);     // Catch: Throwable -> L117
    L117:
        th = move-exception;
        this.input.rewind(r19);     // Catch: Throwable -> L49 RecognitionException -> L101
        throw th;     // Catch: Throwable -> L49 RecognitionException -> L101
    L64:
        if (this.input.LA(3) != 28) goto L105;
        int r20 = this.input.LA(4);     // Catch: Throwable -> L49 RecognitionException -> L51
        if (r20 == 62) goto L82;
        if (r20 == 66) goto L82;
        if (r20 != 57) goto L71;
        r10 = 4;
        goto L83
    L71:
        int r21 = this.input.mark();     // Catch: Throwable -> L49 RecognitionException -> L51
        int r22 = 0;
    L74:
        if (r22 >= 3) goto L79;
        this.input.consume();     // Catch: Throwable -> L76
        r22 = r22 + 1;     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        this.input.rewind(r21);     // Catch: Throwable -> L49 RecognitionException -> L51
        throw th;     // Catch: Throwable -> L49 RecognitionException -> L51
    L79:
        throw new NoViableAltException("", 13, 11, this.input);     // Catch: Throwable -> L76
    L82:
        r10 = 3;
        goto L83
    L105:
        int r23 = this.input.mark();     // Catch: Throwable -> L49 RecognitionException -> L101
    L106:
        if (r16 >= 2) goto L111;
        this.input.consume();     // Catch: Throwable -> L108
        r16 = r16 + 1;     // Catch: Throwable -> L108
    L108:
        th = move-exception;
        this.input.rewind(r23);     // Catch: Throwable -> L49 RecognitionException -> L101
        throw th;     // Catch: Throwable -> L49 RecognitionException -> L101
    L111:
        throw new NoViableAltException("", 13, 8, this.input);     // Catch: Throwable -> L108
    L101:
        e = e;
    L51:
        e = e;
        r13 = null;
    L49:
        th = move-exception;
        throw th;
    }

    public final List<? extends SrcOp> block(GrammarAST r11, GrammarAST r12) throws RecognitionException {
        GrammarAST r5 = (GrammarAST) match(this.input, 78, FOLLOW_BLOCK_in_block84);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (this.input.LA(1) != 42) goto L19;
        match(this.input, 42, FOLLOW_OPTIONS_in_block88);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        int r10 = 0;
    L6:
        int r13 = this.input.LA(1);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r13 < 4) goto L15;
        if (r13 > 100) goto L15;
        matchAny(this.input);     // Catch: Throwable -> L11 RecognitionException -> L13
        r10 = r10 + 1;     // Catch: Throwable -> L11 RecognitionException -> L13
    L15:
        if (r10 < 1) goto L18;
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L19
    L18:
        throw new EarlyExitException(1, this.input);     // Catch: Throwable -> L11 RecognitionException -> L13
    L19:
        ArrayList r14 = new ArrayList();     // Catch: Throwable -> L11 RecognitionException -> L13
        int r15 = 0;
    L21:
        if (this.input.LA(1) != 74) goto L27;
        pushFollow(FOLLOW_alternative_in_block109);     // Catch: Throwable -> L11 RecognitionException -> L13
        alternative_return r16 = alternative();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r16 == null) goto L25;
        CodeBlockForAlt r17 = r16.altCodeBlock;     // Catch: Throwable -> L11 RecognitionException -> L13
    L26:
        r14.add(r17);     // Catch: Throwable -> L11 RecognitionException -> L13
        r15 = r15 + 1;     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L21
    L25:
        r17 = null;
        goto L26
    L27:
        if (r15 < 1) goto L44;
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r14.size() != 1) goto L32;
        if (r12 != null) goto L32;
        return r14;
    L32:
        if (r12 != null) goto L35;
        List<SrcOp> r18 = DefaultOutputModelFactory.list(new SrcOp[]{this.controller.getChoiceBlock((BlockAST) r5, r14, r11)});     // Catch: Throwable -> L11 RecognitionException -> L13
    L54:
        return r18;
    L35:
        Choice r19 = this.controller.getEBNFBlock(r12, r14);     // Catch: Throwable -> L11 RecognitionException -> L13
        boolean r110 = this.hasLookaheadBlock;     // Catch: Throwable -> L11 RecognitionException -> L13
        if ((r19 instanceof PlusBlock) == false) goto L38;
    L41:
        boolean r20 = true;
    L42:
        this.hasLookaheadBlock = r110 | r20;     // Catch: Throwable -> L11 RecognitionException -> L13
        r18 = DefaultOutputModelFactory.list(new SrcOp[]{r19});     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L54
    L38:
        if ((r19 instanceof StarBlock) == true) goto L41;
        r20 = false;
        goto L42
    L44:
        throw new EarlyExitException(3, this.input);     // Catch: Throwable -> L11 RecognitionException -> L13
    L13:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public final List<SrcOp> blockSet(GrammarAST r10, boolean r11) throws RecognitionException {
        GrammarAST r5 = (GrammarAST) match(this.input, 98, FOLLOW_SET_in_blockSet506);     // Catch: Throwable -> L22 RecognitionException -> L24
        match(this.input, 2, null);     // Catch: Throwable -> L22 RecognitionException -> L24
        int r12 = 0;
    L4:
        int r13 = this.input.LA(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r13 != 20) goto L7;
    L28:
        pushFollow(FOLLOW_atom_in_blockSet508);     // Catch: Throwable -> L22 RecognitionException -> L24
        atom(r10, r11);     // Catch: Throwable -> L22 RecognitionException -> L24
        this.state._fsp--;     // Catch: Throwable -> L22 RecognitionException -> L24
        r12 = r12 + 1;
        goto L4
    L7:
        if (r13 == 39) goto L28;
        if (r13 == 52) goto L28;
        if (r13 == 57) goto L28;
        if (r13 == 62) goto L28;
        if (r13 == 66) goto L28;
        if (r13 == 98) goto L28;
        if (r13 == 100) goto L28;
        if (r12 < 1) goto L27;
        match(this.input, 3, null);     // Catch: Throwable -> L22 RecognitionException -> L24
        return this.controller.set(r5, r10, r11);
    L27:
        throw new EarlyExitException(12, this.input);     // Catch: Throwable -> L22 RecognitionException -> L24
    L24:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L22:
        th = move-exception;
        throw th;
    }

    public final void dummy() throws RecognitionException {
        pushFollow(FOLLOW_block_in_dummy61);     // Catch: Throwable -> L4 RecognitionException -> L6
        block(null, null);     // Catch: Throwable -> L4 RecognitionException -> L6
        this.state._fsp--;     // Catch: Throwable -> L4 RecognitionException -> L6
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List<? extends androidx.room.jarjarred.org.antlr.v4.codegen.model.SrcOp>] */
    /* JADX WARN: Type inference failed for: r2v74 */
    public final List<? extends SrcOp> element() throws RecognitionException {
    L10:
        e = e;
        ?? r5 = 0;
    L99:
        reportError(e);
        recover(this.input, e);
        return r5;
    L8:
        th = move-exception;
        throw th;
    L4:
        char r10 = '\n';
        char r11 = '\n';
        r11 = '\n';
        char r12 = '\n';
        r12 = '\n';
        r12 = '\n';
        r12 = '\n';
        r12 = '\n';
        r12 = '\n';
        r12 = '\n';
        r12 = '\n';
        r12 = '\n';
        r12 = '\n';
        r11 = '\n';
        r11 = '\n';
        r11 = '\n';
        r10 = '\n';
        r10 = '\n';
        r10 = '\n';
        r10 = '\n';
        r10 = '\n';
        r10 = '\n';
        r10 = '\n';
        r10 = '\n';
        r10 = '\n';
        switch(this.input.LA(1)) {
            case 4: goto L49;
            case 10: goto L48;
            case 20: goto L47;
            case 39: goto L47;
            case 46: goto L48;
            case 52: goto L47;
            case 57: goto L47;
            case 59: goto L13;
            case 62: goto L47;
            case 66: goto L47;
            case 78: goto L12;
            case 80: goto L12;
            case 89: goto L12;
            case 90: goto L12;
            case 98: goto L47;
            case 100: goto L47;
            default: goto L7;
        };
    L12:
        char r13 = 3;
    L107:
        switch(r13) {
            case 1: goto L96;
            case 2: goto L91;
            case 3: goto L89;
            case 4: goto L113;
            case 5: goto L112;
            case 6: goto L86;
            case 7: goto L85;
            default: goto L109;
        };     // Catch: Throwable -> L8 RecognitionException -> L10
    L85:
        GrammarAST r14 = (GrammarAST) match(this.input, 59, FOLLOW_SEMPRED_in_element325);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        pushFollow(FOLLOW_elementOptions_in_element327);     // Catch: Throwable -> L8 RecognitionException -> L10
        elementOptions();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        return this.controller.sempred((ActionAST) r14);
    L86:
        GrammarAST r15 = (GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_element311);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        pushFollow(FOLLOW_elementOptions_in_element313);     // Catch: Throwable -> L8 RecognitionException -> L10
        elementOptions();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        return this.controller.action((ActionAST) r15);
    L89:
        pushFollow(FOLLOW_subrule_in_element267);     // Catch: Throwable -> L8 RecognitionException -> L10
        List<? extends SrcOp> r16 = subrule();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
    L114:
        return r16;
    L91:
        pushFollow(FOLLOW_atom_in_element257);     // Catch: Throwable -> L8 RecognitionException -> L10
        r11 = 0;
        r16 = atom(null, false);     // Catch: Throwable -> L8 RecognitionException -> L94
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L94
    L106:
        goto L114
    L96:
        r11 = 0;
        pushFollow(FOLLOW_labeledElement_in_element246);     // Catch: Throwable -> L8 RecognitionException -> L94
        r16 = labeledElement();     // Catch: Throwable -> L8 RecognitionException -> L94
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L94
        goto L106
    L109:
        return null;
    L112:
        return this.controller.sempred((ActionAST) ((GrammarAST) match(this.input, 59, FOLLOW_SEMPRED_in_element297)));
    L113:
        return this.controller.action((ActionAST) ((GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_element282)));
    L94:
        e = e;
        r5 = r11;
        goto L99
    L13:
        int r17 = this.input.LA(2);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r17 != 2) goto L16;
        r13 = 7;
        goto L107
    L16:
        if (r17 < 3) goto L18;
        if (r17 > 4) goto L18;
    L46:
        r13 = 5;
        r11 = r12;
    L18:
        if (r17 == 10) goto L46;
        if (r17 == 20) goto L46;
        if (r17 == 39) goto L46;
        if (r17 == 46) goto L46;
        if (r17 == 52) goto L46;
        if (r17 == 57) goto L46;
        if (r17 == 59) goto L46;
        if (r17 == 62) goto L46;
        if (r17 == 66) goto L46;
        r12 = 'N';
        if (r17 == 78) goto L46;
        r12 = 'P';
        if (r17 == 80) goto L46;
        if (r17 < 89) goto L35;
        r12 = 'Z';
        if (r17 <= 90) goto L46;
    L35:
        r12 = 'b';
        if (r17 == 98) goto L46;
        r12 = 'd';
        if (r17 == 100) goto L46;
        int r18 = this.input.mark();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.input.consume();     // Catch: Throwable -> L43
        throw new NoViableAltException("", 8, 5, this.input);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        this.input.rewind(r18);     // Catch: Throwable -> L8 RecognitionException -> L10
        throw th;     // Catch: Throwable -> L8 RecognitionException -> L10
    L47:
        r13 = 2;
        goto L107
    L48:
        r13 = 1;
        goto L107
    L49:
        int r19 = this.input.LA(2);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r19 != 2) goto L52;
        r13 = 6;
        goto L107
    L52:
        if (r19 < 3) goto L54;
        if (r19 > 4) goto L54;
    L82:
        r13 = 4;
        r11 = r10;
    L54:
        if (r19 == 10) goto L82;
        if (r19 == 20) goto L82;
        if (r19 == 39) goto L82;
        if (r19 == 46) goto L82;
        if (r19 == 52) goto L82;
        if (r19 == 57) goto L82;
        if (r19 == 59) goto L82;
        if (r19 == 62) goto L82;
        if (r19 == 66) goto L82;
        r10 = 'N';
        if (r19 == 78) goto L82;
        r10 = 'P';
        if (r19 == 80) goto L82;
        if (r19 < 89) goto L71;
        r10 = 'Z';
        if (r19 <= 90) goto L82;
    L71:
        r10 = 'b';
        if (r19 == 98) goto L82;
        r10 = 'd';
        if (r19 == 100) goto L82;
        int r20 = this.input.mark();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.input.consume();     // Catch: Throwable -> L79
        throw new NoViableAltException("", 8, 4, this.input);     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        this.input.rewind(r20);     // Catch: Throwable -> L8 RecognitionException -> L10
        throw th;     // Catch: Throwable -> L8 RecognitionException -> L10
    L7:
        throw new NoViableAltException("", 8, 0, this.input);     // Catch: Throwable -> L8 RecognitionException -> L10
    }

    public final void elementOption() throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L26 RecognitionException -> L28
        if (r5 != 28) goto L6;
        char r10 = 1;
    L34:
        if (r10 != 1) goto L36;
        match(this.input, 28, FOLLOW_ID_in_elementOption857);     // Catch: Throwable -> L26 RecognitionException -> L28
        return;
    L36:
        if (r10 == 2) goto L44;
        if (r10 == 3) goto L43;
        if (r10 == 4) goto L42;
        if (r10 != 5) goto L75;
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption916);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 2, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 28, FOLLOW_ID_in_elementOption918);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 30, FOLLOW_INT_in_elementOption920);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 3, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        return;
    L75:
        return;
    L42:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption900);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 2, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 28, FOLLOW_ID_in_elementOption902);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 4, FOLLOW_ACTION_in_elementOption904);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 3, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        return;
    L43:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption884);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 2, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 28, FOLLOW_ID_in_elementOption886);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_elementOption888);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 3, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        return;
    L44:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption868);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 2, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 28, FOLLOW_ID_in_elementOption870);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 28, FOLLOW_ID_in_elementOption872);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 3, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        return;
    L6:
        int r11 = 0;
        if (r5 != 10) goto L62;
        if (this.input.LA(2) == 2) goto L11;
        int r12 = this.input.mark();     // Catch: Throwable -> L26 RecognitionException -> L28
        this.input.consume();     // Catch: Throwable -> L58
        throw new NoViableAltException("", 18, 2, this.input);     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        this.input.rewind(r12);     // Catch: Throwable -> L26 RecognitionException -> L28
        throw th;     // Catch: Throwable -> L26 RecognitionException -> L28
    L11:
        if (this.input.LA(3) != 28) goto L46;
        int r13 = this.input.LA(4);     // Catch: Throwable -> L26 RecognitionException -> L28
        if (r13 == 4) goto L33;
        if (r13 == 28) goto L32;
        if (r13 == 30) goto L31;
        if (r13 == 62) goto L30;
        int r14 = this.input.mark();     // Catch: Throwable -> L26 RecognitionException -> L28
    L18:
        if (r11 >= 3) goto L23;
        this.input.consume();     // Catch: Throwable -> L20
        r11 = r11 + 1;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        this.input.rewind(r14);     // Catch: Throwable -> L26 RecognitionException -> L28
        throw th;     // Catch: Throwable -> L26 RecognitionException -> L28
    L23:
        throw new NoViableAltException("", 18, 4, this.input);     // Catch: Throwable -> L20
    L30:
        r10 = 3;
        goto L34
    L31:
        r10 = 5;
        goto L34
    L32:
        r10 = 2;
        goto L34
    L33:
        r10 = 4;
        goto L34
    L46:
        int r15 = this.input.mark();     // Catch: Throwable -> L26 RecognitionException -> L28
    L47:
        if (r11 >= 2) goto L52;
        this.input.consume();     // Catch: Throwable -> L49
        r11 = r11 + 1;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        this.input.rewind(r15);     // Catch: Throwable -> L26 RecognitionException -> L28
        throw th;     // Catch: Throwable -> L26 RecognitionException -> L28
    L52:
        throw new NoViableAltException("", 18, 3, this.input);     // Catch: Throwable -> L49
    L62:
        throw new NoViableAltException("", 18, 0, this.input);     // Catch: Throwable -> L26 RecognitionException -> L28
    L28:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public final void elementOptions() throws RecognitionException {
        match(this.input, 82, FOLLOW_ELEMENT_OPTIONS_in_elementOptions836);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(this.input, 2, null);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r5 = 0;
    L3:
        int r10 = this.input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r10 != 10) goto L6;
    L16:
        pushFollow(FOLLOW_elementOption_in_elementOptions838);     // Catch: Throwable -> L10 RecognitionException -> L12
        elementOption();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state._fsp--;     // Catch: Throwable -> L10 RecognitionException -> L12
        r5 = r5 + 1;
        goto L3
    L6:
        if (r10 == 28) goto L16;
        if (r5 < 1) goto L15;
        match(this.input, 3, null);     // Catch: Throwable -> L10 RecognitionException -> L12
        return;
    L15:
        throw new EarlyExitException(17, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    L12:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public TreeParser[] getDelegates() {
        return new TreeParser[0];
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getGrammarFileName() {
        return "androidx/room/jarjarred/org/antlr/v4/codegen/SourceGenTriggers.g";
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String[] getTokenNames() {
        return tokenNames;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List<? extends androidx.room.jarjarred.org.antlr.v4.codegen.model.SrcOp>] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final List<? extends SrcOp> labeledElement() throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L33 RecognitionException -> L35
        ?? r10 = 100;
        if (r5 != 10) goto L56;
        if (this.input.LA(2) == 2) goto L9;
        int r11 = this.input.mark();     // Catch: Throwable -> L33 RecognitionException -> L35
        this.input.consume();     // Catch: Throwable -> L52
        throw new NoViableAltException("", 9, 1, this.input);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        this.input.rewind(r11);     // Catch: Throwable -> L33 RecognitionException -> L35
        throw th;     // Catch: Throwable -> L33 RecognitionException -> L35
    L9:
        if (this.input.LA(3) != 28) goto L39;
        int r12 = this.input.LA(4);     // Catch: Throwable -> L33 RecognitionException -> L35
        if (r12 == 20) goto L37;
        if (r12 == 39) goto L37;
        if (r12 == 52) goto L37;
        if (r12 == 57) goto L37;
        if (r12 == 62) goto L37;
        if (r12 == 66) goto L37;
        if (r12 == 98) goto L37;
        if (r12 == 100) goto L37;
        if (r12 != 78) goto L23;
        char r13 = 3;
    L85:
        if (r13 == 1) goto L94;
        if (r13 == 2) goto L93;
        if (r13 == 3) goto L92;
        if (r13 != 4) goto L145;
        match(this.input, 46, FOLLOW_PLUS_ASSIGN_in_labeledElement396);     // Catch: Throwable -> L33 RecognitionException -> L35
        match(this.input, 2, null);     // Catch: Throwable -> L33 RecognitionException -> L35
        GrammarAST r14 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_labeledElement398);     // Catch: Throwable -> L33 RecognitionException -> L35
        pushFollow(FOLLOW_block_in_labeledElement400);     // Catch: Throwable -> L33 RecognitionException -> L35
        List<? extends SrcOp> r15 = block(r14, null);     // Catch: Throwable -> L33 RecognitionException -> L35
        this.state._fsp--;     // Catch: Throwable -> L33 RecognitionException -> L35
        match(this.input, 3, null);     // Catch: Throwable -> L33 RecognitionException -> L35
    L146:
        return r15;
    L145:
        return null;
    L92:
        match(this.input, 10, FOLLOW_ASSIGN_in_labeledElement379);     // Catch: Throwable -> L33 RecognitionException -> L35
        match(this.input, 2, null);     // Catch: Throwable -> L33 RecognitionException -> L35
        GrammarAST r16 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_labeledElement381);     // Catch: Throwable -> L33 RecognitionException -> L35
        pushFollow(FOLLOW_block_in_labeledElement383);     // Catch: Throwable -> L33 RecognitionException -> L35
        r15 = block(r16, null);     // Catch: Throwable -> L33 RecognitionException -> L35
        this.state._fsp--;     // Catch: Throwable -> L33 RecognitionException -> L35
        match(this.input, 3, null);     // Catch: Throwable -> L33 RecognitionException -> L35
        goto L146
    L93:
        match(this.input, 46, FOLLOW_PLUS_ASSIGN_in_labeledElement364);     // Catch: Throwable -> L33 RecognitionException -> L35
        match(this.input, 2, null);     // Catch: Throwable -> L33 RecognitionException -> L35
        GrammarAST r17 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_labeledElement366);     // Catch: Throwable -> L33 RecognitionException -> L35
        pushFollow(FOLLOW_atom_in_labeledElement368);     // Catch: Throwable -> L33 RecognitionException -> L35
        r15 = atom(r17, false);     // Catch: Throwable -> L33 RecognitionException -> L35
        this.state._fsp--;     // Catch: Throwable -> L33 RecognitionException -> L35
        match(this.input, 3, null);     // Catch: Throwable -> L33 RecognitionException -> L35
        goto L146
    L94:
        match(this.input, 10, FOLLOW_ASSIGN_in_labeledElement347);     // Catch: Throwable -> L33 RecognitionException -> L35
        match(this.input, 2, null);     // Catch: Throwable -> L33 RecognitionException -> L102
        GrammarAST r18 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_labeledElement349);     // Catch: Throwable -> L33 RecognitionException -> L35
        pushFollow(FOLLOW_atom_in_labeledElement351);     // Catch: Throwable -> L33 RecognitionException -> L35
        r15 = atom(r18, false);     // Catch: Throwable -> L33 RecognitionException -> L35
        this.state._fsp--;     // Catch: Throwable -> L33 RecognitionException -> L35
        match(this.input, 3, null);     // Catch: Throwable -> L33 RecognitionException -> L100
    L102:
        e = e;
        r10 = 0;
    L123:
        reportError(e);
        recover(this.input, e);
        return r10;
    L23:
        int r19 = this.input.mark();     // Catch: Throwable -> L33 RecognitionException -> L35
        int r20 = 0;
    L25:
        if (r20 >= 3) goto L30;
        this.input.consume();     // Catch: Throwable -> L27
        r20 = r20 + 1;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        this.input.rewind(r19);     // Catch: Throwable -> L33 RecognitionException -> L35
        throw th;     // Catch: Throwable -> L33 RecognitionException -> L35
    L30:
        throw new NoViableAltException("", 9, 5, this.input);     // Catch: Throwable -> L27
    L37:
        r13 = 1;
        goto L85
    L39:
        int r21 = this.input.mark();     // Catch: Throwable -> L33 RecognitionException -> L35
        int r22 = 0;
    L41:
        if (r22 >= 2) goto L46;
        this.input.consume();     // Catch: Throwable -> L43
        r22 = r22 + 1;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        this.input.rewind(r21);     // Catch: Throwable -> L33 RecognitionException -> L35
        throw th;     // Catch: Throwable -> L33 RecognitionException -> L35
    L46:
        throw new NoViableAltException("", 9, 3, this.input);     // Catch: Throwable -> L43
    L56:
        if (r5 != 46) goto L121;
        if (this.input.LA(2) == 2) goto L60;
        int r23 = this.input.mark();     // Catch: Throwable -> L33 RecognitionException -> L100
        this.input.consume();     // Catch: Throwable -> L117
        throw new NoViableAltException("", 9, 2, this.input);     // Catch: Throwable -> L117
    L117:
        th = move-exception;
        this.input.rewind(r23);     // Catch: Throwable -> L33 RecognitionException -> L100
        throw th;     // Catch: Throwable -> L33 RecognitionException -> L100
    L60:
        if (this.input.LA(3) != 28) goto L104;
        int r24 = this.input.LA(4);     // Catch: Throwable -> L33 RecognitionException -> L35
        if (r24 == 20) goto L84;
        if (r24 == 39) goto L84;
        if (r24 == 52) goto L84;
        if (r24 == 57) goto L84;
        if (r24 == 62) goto L84;
        if (r24 == 66) goto L84;
        if (r24 == 98) goto L84;
        if (r24 == 100) goto L84;
        if (r24 != 78) goto L74;
        r13 = 4;
        goto L85
    L74:
        int r25 = this.input.mark();     // Catch: Throwable -> L33 RecognitionException -> L35
        int r26 = 0;
    L76:
        if (r26 >= 3) goto L81;
        this.input.consume();     // Catch: Throwable -> L78
        r26 = r26 + 1;     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        this.input.rewind(r25);     // Catch: Throwable -> L33 RecognitionException -> L35
        throw th;     // Catch: Throwable -> L33 RecognitionException -> L35
    L81:
        throw new NoViableAltException("", 9, 6, this.input);     // Catch: Throwable -> L78
    L84:
        r13 = 2;
        goto L85
    L104:
        int r27 = this.input.mark();     // Catch: Throwable -> L33 RecognitionException -> L100
        int r110 = 0;
    L106:
        if (r110 >= 2) goto L111;
        this.input.consume();     // Catch: Throwable -> L108
        r110 = r110 + 1;     // Catch: Throwable -> L108
    L108:
        th = move-exception;
        this.input.rewind(r27);     // Catch: Throwable -> L33 RecognitionException -> L100
        throw th;     // Catch: Throwable -> L33 RecognitionException -> L100
    L111:
        throw new NoViableAltException("", 9, 4, this.input);     // Catch: Throwable -> L108
    L121:
        throw new NoViableAltException("", 9, 0, this.input);     // Catch: Throwable -> L33 RecognitionException -> L100
    L100:
        e = e;
    L33:
        th = move-exception;
        throw th;
    L35:
        e = e;
        r10 = 0;
        goto L123
    }

    public final List<SrcOp> range(GrammarAST r5) throws RecognitionException {
        match(this.input, 52, FOLLOW_RANGE_in_range718);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 2, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r10 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_range722);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r11 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_range726);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 3, null);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return null;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L5:
        th = move-exception;
        throw th;
    }

    public final List<SrcOp> ruleref(GrammarAST r10) throws RecognitionException {
        GrammarAST r5 = (GrammarAST) match(this.input, 57, FOLLOW_RULE_REF_in_ruleref685);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this.input.LA(1) != 2) goto L17;
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this.input.LA(1) != 8) goto L12;
        GrammarAST r11 = (GrammarAST) match(this.input, 8, FOLLOW_ARG_ACTION_in_ruleref687);     // Catch: Throwable -> L8 RecognitionException -> L10
    L14:
        if (this.input.LA(1) != 82) goto L16;
        pushFollow(FOLLOW_elementOptions_in_ruleref690);     // Catch: Throwable -> L8 RecognitionException -> L10
        elementOptions();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
    L16:
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
    L18:
    L25:
        return this.controller.ruleRef(r5, r10, r11);
    L12:
        r11 = null;
        goto L14
    L17:
        r11 = null;
    L10:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    public final List<? extends SrcOp> subrule() throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r5 == 78) goto L18;
        if (r5 == 80) goto L17;
        if (r5 == 89) goto L16;
        if (r5 == 90) goto L17;
        throw new NoViableAltException("", 11, 0, this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
    L16:
        char r10 = 1;
    L19:
        if (r10 == 1) goto L45;
        if (r10 == 2) goto L25;
        if (r10 != 3) goto L51;
        pushFollow(FOLLOW_block_in_subrule476);     // Catch: Throwable -> L12 RecognitionException -> L14
        List<? extends SrcOp> r11 = block(null, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
    L52:
        return r11;
    L51:
        return null;
    L25:
        int r12 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r12 != 80) goto L28;
        char r13 = 1;
    L30:
        if (r13 == 1) goto L34;
        if (r13 == 2) goto L33;
        GrammarAST r14 = null;
        List<? extends SrcOp> r15 = null;
    L35:
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L12 RecognitionException -> L14
        SrcOp r17 = r15.get(0);     // Catch: Throwable -> L12 RecognitionException -> L14
        CodeBlockForAlt r18 = new CodeBlockForAlt(this.controller.delegate);     // Catch: Throwable -> L12 RecognitionException -> L14
        r18.addOp(r17);     // Catch: Throwable -> L12 RecognitionException -> L14
        r16.add(r18);     // Catch: Throwable -> L12 RecognitionException -> L14
        Choice r19 = this.controller.getEBNFBlock(r14, r16);     // Catch: Throwable -> L12 RecognitionException -> L14
        boolean r20 = this.hasLookaheadBlock;     // Catch: Throwable -> L12 RecognitionException -> L14
        if ((r19 instanceof PlusBlock) == false) goto L38;
    L41:
        boolean r21 = true;
    L42:
        this.hasLookaheadBlock = r20 | r21;     // Catch: Throwable -> L12 RecognitionException -> L14
        return DefaultOutputModelFactory.list(new SrcOp[]{r19});
    L38:
        if ((r19 instanceof StarBlock) == true) goto L41;
        r21 = false;
        goto L42
    L33:
        r14 = (GrammarAST) match(this.input, 90, FOLLOW_POSITIVE_CLOSURE_in_subrule456);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_block_in_subrule460);     // Catch: Throwable -> L12 RecognitionException -> L14
        r15 = block(null, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L35
    L34:
        r14 = (GrammarAST) match(this.input, 80, FOLLOW_CLOSURE_in_subrule441);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_block_in_subrule445);     // Catch: Throwable -> L12 RecognitionException -> L14
        r15 = block(null, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L35
    L28:
        if (r12 != 90) goto L44;
        r13 = 2;
        goto L30
    L44:
        throw new NoViableAltException("", 10, 0, this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
    L45:
        GrammarAST r22 = (GrammarAST) match(this.input, 89, FOLLOW_OPTIONAL_in_subrule421);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_block_in_subrule425);     // Catch: Throwable -> L12 RecognitionException -> L14
        r11 = block(null, r22);     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
    L17:
        r10 = 2;
        goto L19
    L18:
        r10 = 3;
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List<androidx.room.jarjarred.org.antlr.v4.codegen.model.SrcOp>] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    public final List<SrcOp> terminal(GrammarAST r17) throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L39 RecognitionException -> L41
        ?? r10 = 4;
        if (r5 != 62) goto L45;
        int r11 = this.input.LA(2);     // Catch: Throwable -> L39 RecognitionException -> L41
        if (r11 != 2) goto L9;
        char r12 = 1;
    L117:
        if (r12 == 1) goto L128;
        if (r12 == 2) goto L154;
        if (r12 == 3) goto L126;
        if (r12 != 4) goto L122;
        GrammarAST r13 = (GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_terminal796);     // Catch: Throwable -> L39 RecognitionException -> L41
        match(this.input, 2, null);     // Catch: Throwable -> L39 RecognitionException -> L41
        matchAny(this.input);     // Catch: Throwable -> L39 RecognitionException -> L41
        match(this.input, 3, null);     // Catch: Throwable -> L39 RecognitionException -> L41
        return this.controller.tokenRef(r13, r17, null);
    L122:
        if (r12 == 5) goto L151;
        return null;
    L151:
        return this.controller.tokenRef((GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_terminal812), r17, null);
    L126:
        GrammarAST r14 = (GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_terminal780);     // Catch: Throwable -> L39 RecognitionException -> L41
        match(this.input, 2, null);     // Catch: Throwable -> L39 RecognitionException -> L41
        GrammarAST r15 = (GrammarAST) match(this.input, 8, FOLLOW_ARG_ACTION_in_terminal782);     // Catch: Throwable -> L39 RecognitionException -> L41
        matchAny(this.input);     // Catch: Throwable -> L39 RecognitionException -> L41
        match(this.input, 3, null);     // Catch: Throwable -> L39 RecognitionException -> L41
        return this.controller.tokenRef(r14, r17, r15);
    L154:
        return this.controller.stringRef((GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_terminal766), r17);
    L128:
        GrammarAST r16 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_terminal751);     // Catch: Throwable -> L39 RecognitionException -> L41
        match(this.input, 2, null);     // Catch: Throwable -> L39 RecognitionException -> L131
        matchAny(this.input);     // Catch: Throwable -> L39 RecognitionException -> L131
        match(this.input, 3, null);     // Catch: Throwable -> L39 RecognitionException -> L131
        return this.controller.stringRef(r16, r17);
    L9:
        if (r11 < 3) goto L11;
        if (r11 > 4) goto L11;
    L43:
        r12 = 2;
    L11:
        if (r11 == 10) goto L43;
        if (r11 == 20) goto L43;
        if (r11 == 39) goto L43;
        if (r11 == 46) goto L43;
        if (r11 == 52) goto L43;
        if (r11 == 57) goto L43;
        if (r11 == 59) goto L43;
        if (r11 == 62) goto L43;
        if (r11 == 66) goto L43;
        if (r11 == 78) goto L43;
        if (r11 == 80) goto L43;
        if (r11 < 89) goto L29;
        if (r11 <= 90) goto L43;
    L29:
        if (r11 == 98) goto L43;
        if (r11 == 100) goto L43;
        int r18 = this.input.mark();     // Catch: Throwable -> L39 RecognitionException -> L41
        this.input.consume();     // Catch: Throwable -> L36
        throw new NoViableAltException("", 16, 1, this.input);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        this.input.rewind(r18);     // Catch: Throwable -> L39 RecognitionException -> L41
        throw th;     // Catch: Throwable -> L39 RecognitionException -> L41
    L45:
        int r19 = 0;
        if (r5 != 66) goto L134;
        int r20 = this.input.LA(2);     // Catch: Throwable -> L39 RecognitionException -> L41
        if (r20 != 2) goto L85;
        int r21 = this.input.LA(3);     // Catch: Throwable -> L39 RecognitionException -> L41
        if (r21 != 8) goto L68;
        int r22 = this.input.LA(4);     // Catch: Throwable -> L39 RecognitionException -> L41
        if (r22 >= 4) goto L54;
    L56:
        if (r22 < 2) goto L59;
        if (r22 > 3) goto L59;
    L58:
        r12 = 4;
    L59:
        int r23 = this.input.mark();     // Catch: Throwable -> L39 RecognitionException -> L41
    L60:
        if (r19 >= 3) goto L65;
        this.input.consume();     // Catch: Throwable -> L62
        r19 = r19 + 1;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        this.input.rewind(r23);     // Catch: Throwable -> L39 RecognitionException -> L41
        throw th;     // Catch: Throwable -> L39 RecognitionException -> L41
    L65:
        throw new NoViableAltException("", 16, 7, this.input);     // Catch: Throwable -> L62
    L54:
        if (r22 > 100) goto L56;
        r12 = 3;
        goto L117
    L68:
        if (r21 < 4) goto L72;
        if (r21 <= 7) goto L58;
    L72:
        if (r21 >= 9) goto L74;
    L76:
        int r24 = this.input.mark();     // Catch: Throwable -> L39 RecognitionException -> L41
    L77:
        if (r19 >= 2) goto L82;
        this.input.consume();     // Catch: Throwable -> L79
        r19 = r19 + 1;     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        this.input.rewind(r24);     // Catch: Throwable -> L39 RecognitionException -> L41
        throw th;     // Catch: Throwable -> L39 RecognitionException -> L41
    L82:
        throw new NoViableAltException("", 16, 5, this.input);     // Catch: Throwable -> L79
    L74:
        if (r21 > 100) goto L76;
    L85:
        if (r20 < 3) goto L87;
        if (r20 > 4) goto L87;
    L116:
        r12 = 5;
    L87:
        if (r20 == 10) goto L116;
        if (r20 == 20) goto L116;
        if (r20 == 39) goto L116;
        if (r20 == 46) goto L116;
        if (r20 == 52) goto L116;
        if (r20 == 57) goto L116;
        if (r20 == 59) goto L116;
        if (r20 == 62) goto L116;
        if (r20 == 66) goto L116;
        if (r20 == 78) goto L116;
        if (r20 == 80) goto L116;
        if (r20 < 89) goto L106;
        if (r20 <= 90) goto L116;
    L106:
        if (r20 == 98) goto L116;
        if (r20 == 100) goto L116;
        int r25 = this.input.mark();     // Catch: Throwable -> L39 RecognitionException -> L41
        this.input.consume();     // Catch: Throwable -> L113
        throw new NoViableAltException("", 16, 2, this.input);     // Catch: Throwable -> L113
    L113:
        th = move-exception;
        this.input.rewind(r25);     // Catch: Throwable -> L39 RecognitionException -> L41
        throw th;     // Catch: Throwable -> L39 RecognitionException -> L41
    L134:
        throw new NoViableAltException("", 16, 0, this.input);     // Catch: Throwable -> L39 RecognitionException -> L131
    L131:
        e = e;
    L136:
        reportError(e);
        recover(this.input, e);
        return r10;
    L41:
        e = e;
        r10 = 0;
    L39:
        th = move-exception;
        throw th;
    }

    public SourceGenTriggers(TreeNodeStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.dfa7 = new DFA7(this, this);
    }

    public SourceGenTriggers(TreeNodeStream r5, OutputModelController r10) {
        this(r5);
        this.controller = r10;
    }
}
