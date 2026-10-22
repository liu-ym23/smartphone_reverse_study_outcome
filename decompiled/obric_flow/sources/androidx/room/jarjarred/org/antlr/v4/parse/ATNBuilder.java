package androidx.room.jarjarred.org.antlr.v4.parse;

import androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer;
import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.runtime.DFA;
import androidx.room.jarjarred.org.antlr.runtime.EarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedSetException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeParser;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeRuleReturnScope;
import androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.PredAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ATNBuilder extends TreeParser {
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
    static final short[] DFA10_accept = null;
    static final String DFA10_acceptS = "\u0001\uffff\u0001\u0001\u0003\uffff\u0001\u0002\u0001\u0003\u000e\uffff";
    static final short[] DFA10_eof = null;
    static final String DFA10_eofS = "\u0015\uffff";
    static final short[] DFA10_eot = null;
    static final String DFA10_eotS = "\u0015\uffff";
    static final char[] DFA10_max = null;
    static final String DFA10_maxS = "\u0001W\u0001\uffff\u0001\u0002\u0001d\u0001\u0002\u0002\uffff\u0002\u001c\u0001\u0002\u0001d\u0001\u001c\u0001>\u0004\u0003\u0004\u001c";
    static final char[] DFA10_min = null;
    static final String DFA10_minS = "\u0001J\u0001\uffff\u0001\u0002\u0001\u0004\u0001\u0002\u0002\uffff\u0002\u0003\u0001\u0002\u0001\u0004\u0001\u001c\u0001\u0004\b\u0003";
    static final short[] DFA10_special = null;
    static final String DFA10_specialS = "\u0015\uffff}>";
    static final short[][] DFA10_transition = null;
    static final String[] DFA10_transitionS = null;
    public static final int DOC_COMMENT = 18;
    public static final int DOLLAR = 19;
    public static final int DOT = 20;
    public static final int ELEMENT_OPTIONS = 82;
    public static final int EOF = -1;
    public static final int EPSILON = 83;
    public static final int ERRCHAR = 21;
    public static final int ESC_SEQ = 22;
    public static final int FINALLY = 23;
    public static final BitSet FOLLOW_ACTION_in_element490 = null;
    public static final BitSet FOLLOW_ACTION_in_element519 = null;
    public static final BitSet FOLLOW_ACTION_in_elementOption1198 = null;
    public static final BitSet FOLLOW_ALT_in_alternative289 = null;
    public static final BitSet FOLLOW_ALT_in_alternative314 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleref959 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleref982 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_terminal1100 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption1172 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption1183 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption1194 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption1205 = null;
    public static final BitSet FOLLOW_ASSIGN_in_labeledElement626 = null;
    public static final BitSet FOLLOW_BLOCK_in_block209 = null;
    public static final BitSet FOLLOW_BLOCK_in_ruleBlock89 = null;
    public static final BitSet FOLLOW_CLOSURE_in_subrule682 = null;
    public static final BitSet FOLLOW_DOT_in_atom840 = null;
    public static final BitSet FOLLOW_DOT_in_atom854 = null;
    public static final BitSet FOLLOW_ELEMENT_OPTIONS_in_elementOptions1151 = null;
    public static final BitSet FOLLOW_ELEMENT_OPTIONS_in_ruleref963 = null;
    public static final BitSet FOLLOW_EPSILON_in_alternative294 = null;
    public static final BitSet FOLLOW_ID_in_atom842 = null;
    public static final BitSet FOLLOW_ID_in_atom856 = null;
    public static final BitSet FOLLOW_ID_in_elementOption1166 = null;
    public static final BitSet FOLLOW_ID_in_elementOption1174 = null;
    public static final BitSet FOLLOW_ID_in_elementOption1176 = null;
    public static final BitSet FOLLOW_ID_in_elementOption1185 = null;
    public static final BitSet FOLLOW_ID_in_elementOption1196 = null;
    public static final BitSet FOLLOW_ID_in_elementOption1207 = null;
    public static final BitSet FOLLOW_ID_in_labeledElement628 = null;
    public static final BitSet FOLLOW_ID_in_labeledElement645 = null;
    public static final BitSet FOLLOW_ID_in_lexerCommand395 = null;
    public static final BitSet FOLLOW_ID_in_lexerCommand413 = null;
    public static final BitSet FOLLOW_INT_in_elementOption1209 = null;
    public static final BitSet FOLLOW_LEXER_ACTION_CALL_in_lexerCommand393 = null;
    public static final BitSet FOLLOW_LEXER_ALT_ACTION_in_alternative263 = null;
    public static final BitSet FOLLOW_LEXER_CHAR_SET_in_element570 = null;
    public static final BitSet FOLLOW_LEXER_CHAR_SET_in_setElement813 = null;
    public static final BitSet FOLLOW_NOT_in_astOperand603 = null;
    public static final BitSet FOLLOW_NOT_in_element553 = null;
    public static final BitSet FOLLOW_OPTIONAL_in_subrule668 = null;
    public static final BitSet FOLLOW_OPTIONS_in_block213 = null;
    public static final BitSet FOLLOW_OPTIONS_in_ruleBlock105 = null;
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_labeledElement643 = null;
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_subrule696 = null;
    public static final BitSet FOLLOW_RANGE_in_range1035 = null;
    public static final BitSet FOLLOW_RANGE_in_setElement794 = null;
    public static final BitSet FOLLOW_RULE_REF_in_ruleref1001 = null;
    public static final BitSet FOLLOW_RULE_REF_in_ruleref957 = null;
    public static final BitSet FOLLOW_RULE_REF_in_ruleref980 = null;
    public static final BitSet FOLLOW_SEMPRED_in_element504 = null;
    public static final BitSet FOLLOW_SEMPRED_in_element536 = null;
    public static final BitSet FOLLOW_SET_in_blockSet742 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_elementOption1187 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_range1039 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_range1043 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement766 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement783 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement798 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement802 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal1069 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal1084 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement775 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement788 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal1098 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal1114 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal1130 = null;
    public static final BitSet FOLLOW_WILDCARD_in_atom871 = null;
    public static final BitSet FOLLOW_WILDCARD_in_atom886 = null;
    public static final BitSet FOLLOW_alternative_in_alternative267 = null;
    public static final BitSet FOLLOW_alternative_in_block224 = null;
    public static final BitSet FOLLOW_alternative_in_ruleBlock131 = null;
    public static final BitSet FOLLOW_atom_in_astOperand590 = null;
    public static final BitSet FOLLOW_atom_in_element464 = null;
    public static final BitSet FOLLOW_blockSet_in_astOperand605 = null;
    public static final BitSet FOLLOW_blockSet_in_atom899 = null;
    public static final BitSet FOLLOW_blockSet_in_element557 = null;
    public static final BitSet FOLLOW_block_in_dummy63 = null;
    public static final BitSet FOLLOW_block_in_subrule670 = null;
    public static final BitSet FOLLOW_block_in_subrule684 = null;
    public static final BitSet FOLLOW_block_in_subrule698 = null;
    public static final BitSet FOLLOW_block_in_subrule708 = null;
    public static final BitSet FOLLOW_elementOption_in_elementOptions1153 = null;
    public static final BitSet FOLLOW_elementOptions_in_alternative291 = null;
    public static final BitSet FOLLOW_elementOptions_in_alternative316 = null;
    public static final BitSet FOLLOW_element_in_alternative322 = null;
    public static final BitSet FOLLOW_element_in_labeledElement630 = null;
    public static final BitSet FOLLOW_element_in_labeledElement647 = null;
    public static final BitSet FOLLOW_labeledElement_in_element454 = null;
    public static final BitSet FOLLOW_lexerCommandExpr_in_lexerCommand397 = null;
    public static final BitSet FOLLOW_lexerCommand_in_lexerCommands360 = null;
    public static final BitSet FOLLOW_lexerCommands_in_alternative269 = null;
    public static final BitSet FOLLOW_range_in_atom828 = null;
    public static final BitSet FOLLOW_ruleref_in_atom858 = null;
    public static final BitSet FOLLOW_ruleref_in_atom929 = null;
    public static final BitSet FOLLOW_setElement_in_blockSet745 = null;
    public static final BitSet FOLLOW_subrule_in_element476 = null;
    public static final BitSet FOLLOW_terminal_in_atom844 = null;
    public static final BitSet FOLLOW_terminal_in_atom914 = null;
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
    protected DFA10 dfa10;
    ATNFactory factory;

    public class DFA10 extends DFA {
        final /* synthetic */ ATNBuilder this$0;

        public DFA10(ATNBuilder r5, BaseRecognizer r10) {
            this.this$0 = r5;
            this.recognizer = r10;
            this.decisionNumber = 10;
            this.eot = ATNBuilder.DFA10_eot;
            this.eof = ATNBuilder.DFA10_eof;
            this.min = ATNBuilder.DFA10_min;
            this.max = ATNBuilder.DFA10_max;
            this.accept = ATNBuilder.DFA10_accept;
            this.special = ATNBuilder.DFA10_special;
            this.transition = ATNBuilder.DFA10_transition;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.DFA
        public String getDescription() {
            return "103:1: alternative returns [ATNFactory.Handle p] : ( ^( LEXER_ALT_ACTION a= alternative lexerCommands ) | ^( ALT ( elementOptions )? EPSILON ) | ^( ALT ( elementOptions )? (e= element )+ ) );";
        }
    }

    public static class atom_return extends TreeRuleReturnScope {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public ATNFactory.Handle f646p;

        public atom_return() {
        }
    }

    public static class blockSet_return extends TreeRuleReturnScope {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public ATNFactory.Handle f647p;

        public blockSet_return() {
        }
    }

    public static class element_return extends TreeRuleReturnScope {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public ATNFactory.Handle f648p;

        public element_return() {
        }
    }

    public static class lexerCommandExpr_return extends TreeRuleReturnScope {
        public lexerCommandExpr_return() {
        }
    }

    public static class setElement_return extends TreeRuleReturnScope {
        public setElement_return() {
        }
    }

    public static class subrule_return extends TreeRuleReturnScope {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public ATNFactory.Handle f649p;

        public subrule_return() {
        }
    }

    public static class terminal_return extends TreeRuleReturnScope {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public ATNFactory.Handle f650p;

        public terminal_return() {
        }
    }

    static {
        tokenNames = new String[]{Grammar.INVALID_RULE_NAME, "<EOR>", "<DOWN>", "<UP>", "ACTION", "ACTION_CHAR_LITERAL", "ACTION_ESC", "ACTION_STRING_LITERAL", "ARG_ACTION", "ARG_OR_CHARSET", "ASSIGN", "AT", "CATCH", "CHANNELS", "COLON", "COLONCOLON", "COMMA", "COMMENT", "DOC_COMMENT", "DOLLAR", "DOT", "ERRCHAR", "ESC_SEQ", "FINALLY", "FRAGMENT", "GRAMMAR", "GT", "HEX_DIGIT", "ID", "IMPORT", "INT", "LEXER", "LEXER_CHAR_SET", "LOCALS", "LPAREN", "LT", "MODE", "NESTED_ACTION", "NLCHARS", "NOT", "NameChar", "NameStartChar", "OPTIONS", "OR", "PARSER", "PLUS", "PLUS_ASSIGN", "POUND", "PRIVATE", "PROTECTED", "PUBLIC", "QUESTION", "RANGE", "RARROW", "RBRACE", "RETURNS", "RPAREN", "RULE_REF", "SEMI", "SEMPRED", "SRC", "STAR", "STRING_LITERAL", "SYNPRED", "THROWS", "TOKENS_SPEC", "TOKEN_REF", "TREE_GRAMMAR", "UNICODE_ESC", "UNICODE_EXTENDED_ESC", "UnicodeBOM", "WS", "WSCHARS", "WSNLCHARS", "ALT", "ALTLIST", "ARG", "ARGLIST", "BLOCK", "CHAR_RANGE", "CLOSURE", "COMBINED", "ELEMENT_OPTIONS", "EPSILON", "INITACTION", "LABEL", "LEXER_ACTION_CALL", "LEXER_ALT_ACTION", "LIST", "OPTIONAL", "POSITIVE_CLOSURE", "PREC_RULE", "RESULT", "RET", "RULE", "RULEACTIONS", "RULEMODIFIERS", "RULES", "SET", "TEMPLATE", "WILDCARD"};
        String[] r5 = {"\u0001\u0002\f\uffff\u0001\u0001", "", "\u0001\u0003", "\u0001\u0006\u0005\uffff\u0001\u0006\t\uffff\u0001\u0006\u000b\uffff\u0001\u0006\u0006\uffff\u0001\u0006\u0006\uffff\u0001\u0006\u0005\uffff\u0001\u0006\u0004\uffff\u0001\u0006\u0001\uffff\u0001\u0006\u0002\uffff\u0001\u0006\u0003\uffff\u0001\u0006\u000b\uffff\u0001\u0006\u0001\uffff\u0001\u0006\u0001\uffff\u0001\u0004\u0001\u0005\u0005\uffff\u0002\u0006\u0007\uffff\u0001\u0006\u0001\uffff\u0001\u0006", "\u0001\u0007", "", "", "\u0001\n\u0006\uffff\u0001\t\u0011\uffff\u0001\b", "\u0001\n\u0006\uffff\u0001\t\u0011\uffff\u0001\b", "\u0001\u000b", "\u0001\u0006\u0005\uffff\u0001\u0006\t\uffff\u0001\u0006\u000b\uffff\u0001\u0006\u0006\uffff\u0001\u0006\u0006\uffff\u0001\u0006\u0005\uffff\u0001\u0006\u0004\uffff\u0001\u0006\u0001\uffff\u0001\u0006\u0002\uffff\u0001\u0006\u0003\uffff\u0001\u0006\u000b\uffff\u0001\u0006\u0001\uffff\u0001\u0006\u0002\uffff\u0001\u0005\u0005\uffff\u0002\u0006\u0007\uffff\u0001\u0006\u0001\uffff\u0001\u0006", "\u0001\f", "\u0001\u000f\u0017\uffff\u0001\r\u0001\uffff\u0001\u0010\u001f\uffff\u0001\u000e", "\u0001\u0011", "\u0001\u0012", "\u0001\u0013", "\u0001\u0014", "\u0001\n\u0006\uffff\u0001\t\u0011\uffff\u0001\b", "\u0001\n\u0006\uffff\u0001\t\u0011\uffff\u0001\b", "\u0001\n\u0006\uffff\u0001\t\u0011\uffff\u0001\b", "\u0001\n\u0006\uffff\u0001\t\u0011\uffff\u0001\b"};
        DFA10_transitionS = r5;
        DFA10_eot = DFA.unpackEncodedString("\u0015\uffff");
        DFA10_eof = DFA.unpackEncodedString("\u0015\uffff");
        DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
        DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
        DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
        DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
        int r10 = r5.length;
        DFA10_transition = new short[r10][];
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        DFA10_transition[r11] = DFA.unpackEncodedString(DFA10_transitionS[r11]);
        r11 = r11 + 1;
        goto L3
    L5:
        FOLLOW_block_in_dummy63 = new BitSet(new long[]{2});
        FOLLOW_BLOCK_in_ruleBlock89 = new BitSet(new long[]{4});
        FOLLOW_OPTIONS_in_ruleBlock105 = new BitSet(new long[]{4});
        FOLLOW_alternative_in_ruleBlock131 = new BitSet(new long[]{8, 8389632});
        FOLLOW_BLOCK_in_block209 = new BitSet(new long[]{4});
        FOLLOW_OPTIONS_in_block213 = new BitSet(new long[]{4});
        FOLLOW_alternative_in_block224 = new BitSet(new long[]{8, 8389632});
        FOLLOW_LEXER_ALT_ACTION_in_alternative263 = new BitSet(new long[]{4});
        FOLLOW_alternative_in_alternative267 = new BitSet(new long[]{268435456, 4194304});
        FOLLOW_lexerCommands_in_alternative269 = new BitSet(new long[]{8});
        FOLLOW_ALT_in_alternative289 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_alternative291 = new BitSet(new long[]{0, 524288});
        FOLLOW_EPSILON_in_alternative294 = new BitSet(new long[]{8});
        FOLLOW_ALT_in_alternative314 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_alternative316 = new BitSet(new long[]{5336836481230046224L, 86000091140L});
        FOLLOW_element_in_alternative322 = new BitSet(new long[]{5336836481230046232L, 86000091140L});
        FOLLOW_lexerCommand_in_lexerCommands360 = new BitSet(new long[]{268435458, 4194304});
        FOLLOW_LEXER_ACTION_CALL_in_lexerCommand393 = new BitSet(new long[]{4});
        FOLLOW_ID_in_lexerCommand395 = new BitSet(new long[]{1342177280});
        FOLLOW_lexerCommandExpr_in_lexerCommand397 = new BitSet(new long[]{8});
        FOLLOW_ID_in_lexerCommand413 = new BitSet(new long[]{2});
        FOLLOW_labeledElement_in_element454 = new BitSet(new long[]{2});
        FOLLOW_atom_in_element464 = new BitSet(new long[]{2});
        FOLLOW_subrule_in_element476 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_element490 = new BitSet(new long[]{2});
        FOLLOW_SEMPRED_in_element504 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_element519 = new BitSet(new long[]{4});
        FOLLOW_SEMPRED_in_element536 = new BitSet(new long[]{4});
        FOLLOW_NOT_in_element553 = new BitSet(new long[]{4});
        FOLLOW_blockSet_in_element557 = new BitSet(new long[]{8});
        FOLLOW_LEXER_CHAR_SET_in_element570 = new BitSet(new long[]{2});
        FOLLOW_atom_in_astOperand590 = new BitSet(new long[]{2});
        FOLLOW_NOT_in_astOperand603 = new BitSet(new long[]{4});
        FOLLOW_blockSet_in_astOperand605 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_labeledElement626 = new BitSet(new long[]{4});
        FOLLOW_ID_in_labeledElement628 = new BitSet(new long[]{5336836481230046224L, 86000091140L});
        FOLLOW_element_in_labeledElement630 = new BitSet(new long[]{8});
        FOLLOW_PLUS_ASSIGN_in_labeledElement643 = new BitSet(new long[]{4});
        FOLLOW_ID_in_labeledElement645 = new BitSet(new long[]{5336836481230046224L, 86000091140L});
        FOLLOW_element_in_labeledElement647 = new BitSet(new long[]{8});
        FOLLOW_OPTIONAL_in_subrule668 = new BitSet(new long[]{4});
        FOLLOW_block_in_subrule670 = new BitSet(new long[]{8});
        FOLLOW_CLOSURE_in_subrule682 = new BitSet(new long[]{4});
        FOLLOW_block_in_subrule684 = new BitSet(new long[]{8});
        FOLLOW_POSITIVE_CLOSURE_in_subrule696 = new BitSet(new long[]{4});
        FOLLOW_block_in_subrule698 = new BitSet(new long[]{8});
        FOLLOW_block_in_subrule708 = new BitSet(new long[]{2});
        FOLLOW_SET_in_blockSet742 = new BitSet(new long[]{4});
        FOLLOW_setElement_in_blockSet745 = new BitSet(new long[]{4616189622349725704L, 4});
        FOLLOW_STRING_LITERAL_in_setElement766 = new BitSet(new long[]{4});
        FOLLOW_TOKEN_REF_in_setElement775 = new BitSet(new long[]{4});
        FOLLOW_STRING_LITERAL_in_setElement783 = new BitSet(new long[]{2});
        FOLLOW_TOKEN_REF_in_setElement788 = new BitSet(new long[]{2});
        FOLLOW_RANGE_in_setElement794 = new BitSet(new long[]{4});
        FOLLOW_STRING_LITERAL_in_setElement798 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_setElement802 = new BitSet(new long[]{8});
        FOLLOW_LEXER_CHAR_SET_in_setElement813 = new BitSet(new long[]{2});
        FOLLOW_range_in_atom828 = new BitSet(new long[]{2});
        FOLLOW_DOT_in_atom840 = new BitSet(new long[]{4});
        FOLLOW_ID_in_atom842 = new BitSet(new long[]{4611686018427387904L, 4});
        FOLLOW_terminal_in_atom844 = new BitSet(new long[]{8});
        FOLLOW_DOT_in_atom854 = new BitSet(new long[]{4});
        FOLLOW_ID_in_atom856 = new BitSet(new long[]{144115188075855872L});
        FOLLOW_ruleref_in_atom858 = new BitSet(new long[]{8});
        FOLLOW_WILDCARD_in_atom871 = new BitSet(new long[]{4});
        FOLLOW_WILDCARD_in_atom886 = new BitSet(new long[]{2});
        FOLLOW_blockSet_in_atom899 = new BitSet(new long[]{2});
        FOLLOW_terminal_in_atom914 = new BitSet(new long[]{2});
        FOLLOW_ruleref_in_atom929 = new BitSet(new long[]{2});
        FOLLOW_RULE_REF_in_ruleref957 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_ruleref959 = new BitSet(new long[]{0, 262144});
        FOLLOW_ELEMENT_OPTIONS_in_ruleref963 = new BitSet(new long[]{4});
        FOLLOW_RULE_REF_in_ruleref980 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_ruleref982 = new BitSet(new long[]{8});
        FOLLOW_RULE_REF_in_ruleref1001 = new BitSet(new long[]{2});
        FOLLOW_RANGE_in_range1035 = new BitSet(new long[]{4});
        FOLLOW_STRING_LITERAL_in_range1039 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_range1043 = new BitSet(new long[]{8});
        FOLLOW_STRING_LITERAL_in_terminal1069 = new BitSet(new long[]{4});
        FOLLOW_STRING_LITERAL_in_terminal1084 = new BitSet(new long[]{2});
        FOLLOW_TOKEN_REF_in_terminal1098 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_terminal1100 = new BitSet(new long[]{-16, 137438953471L});
        FOLLOW_TOKEN_REF_in_terminal1114 = new BitSet(new long[]{4});
        FOLLOW_TOKEN_REF_in_terminal1130 = new BitSet(new long[]{2});
        FOLLOW_ELEMENT_OPTIONS_in_elementOptions1151 = new BitSet(new long[]{4});
        FOLLOW_elementOption_in_elementOptions1153 = new BitSet(new long[]{268436488});
        FOLLOW_ID_in_elementOption1166 = new BitSet(new long[]{2});
        FOLLOW_ASSIGN_in_elementOption1172 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption1174 = new BitSet(new long[]{268435456});
        FOLLOW_ID_in_elementOption1176 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption1183 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption1185 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_elementOption1187 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption1194 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption1196 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_elementOption1198 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption1205 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption1207 = new BitSet(new long[]{1073741824});
        FOLLOW_INT_in_elementOption1209 = new BitSet(new long[]{8});
    }

    public ATNBuilder(TreeNodeStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public final ATNFactory.Handle alternative() throws RecognitionException {
        ArrayList r5 = new ArrayList();
        int r10 = this.dfa10.predict(this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r10 != 1) goto L6;
        match(this.input, 87, FOLLOW_LEXER_ALT_ACTION_in_alternative263);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_alternative_in_alternative267);     // Catch: Throwable -> L12 RecognitionException -> L14
        ATNFactory.Handle r11 = alternative();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_lexerCommands_in_alternative269);     // Catch: Throwable -> L12 RecognitionException -> L14
        ATNFactory.Handle r12 = lexerCommands();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        return this.factory.lexerAltCommands(r11, r12);
    L6:
        if (r10 == 2) goto L61;
        if (r10 != 3) goto L74;
        match(this.input, 74, FOLLOW_ALT_in_alternative314);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (this.input.LA(1) != 82) goto L16;
        pushFollow(FOLLOW_elementOptions_in_alternative316);     // Catch: Throwable -> L12 RecognitionException -> L14
        elementOptions();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
    L16:
        int r13 = 0;
    L17:
        int r14 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r14 != 4) goto L20;
    L56:
        pushFollow(FOLLOW_element_in_alternative322);     // Catch: Throwable -> L12 RecognitionException -> L14
        element_return r15 = element();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r15 == null) goto L59;
        ATNFactory.Handle r16 = r15.f648p;     // Catch: Throwable -> L12 RecognitionException -> L14
    L60:
        r5.add(r16);     // Catch: Throwable -> L12 RecognitionException -> L14
        r13 = r13 + 1;     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L17
    L59:
        r16 = null;
        goto L60
    L20:
        if (r14 == 10) goto L56;
        if (r14 == 20) goto L56;
        if (r14 == 32) goto L56;
        if (r14 == 39) goto L56;
        if (r14 == 46) goto L56;
        if (r14 == 52) goto L56;
        if (r14 == 57) goto L56;
        if (r14 == 59) goto L56;
        if (r14 == 62) goto L56;
        if (r14 == 66) goto L56;
        if (r14 == 78) goto L56;
        if (r14 == 80) goto L56;
        if (r14 < 89) goto L48;
        if (r14 <= 90) goto L56;
    L48:
        if (r14 == 98) goto L56;
        if (r14 == 100) goto L56;
        if (r13 < 1) goto L55;
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        return this.factory.alt(r5);
    L55:
        throw new EarlyExitException(9, this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
    L74:
        return null;
    L61:
        match(this.input, 74, FOLLOW_ALT_in_alternative289);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (this.input.LA(1) != 82) goto L64;
        pushFollow(FOLLOW_elementOptions_in_alternative291);     // Catch: Throwable -> L12 RecognitionException -> L14
        elementOptions();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
    L64:
        GrammarAST r17 = (GrammarAST) match(this.input, 83, FOLLOW_EPSILON_in_alternative294);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        return this.factory.epsilon(r17);
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public final ATNFactory.Handle astOperand() throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r5 != 20) goto L6;
    L26:
        char r10 = 1;
    L27:
        if (r10 == 1) goto L33;
        if (r10 != 2) goto L41;
        match(this.input, 39, FOLLOW_NOT_in_astOperand603);     // Catch: Throwable -> L22 RecognitionException -> L24
        match(this.input, 2, null);     // Catch: Throwable -> L22 RecognitionException -> L24
        pushFollow(FOLLOW_blockSet_in_astOperand605);     // Catch: Throwable -> L22 RecognitionException -> L24
        blockSet_return r11 = blockSet(true);     // Catch: Throwable -> L22 RecognitionException -> L24
        this.state._fsp--;     // Catch: Throwable -> L22 RecognitionException -> L24
        match(this.input, 3, null);     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r11 != null) goto L43;
        return null;
    L43:
        return r11.f647p;
    L41:
        return null;
    L33:
        pushFollow(FOLLOW_atom_in_astOperand590);     // Catch: Throwable -> L22 RecognitionException -> L24
        atom_return r12 = atom();     // Catch: Throwable -> L22 RecognitionException -> L24
        this.state._fsp--;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r12 != null) goto L45;
        return null;
    L45:
        return r12.f646p;
    L6:
        if (r5 == 52) goto L26;
        if (r5 == 57) goto L26;
        if (r5 == 62) goto L26;
        if (r5 == 66) goto L26;
        if (r5 == 98) goto L26;
        if (r5 == 100) goto L26;
        if (r5 != 39) goto L21;
        r10 = 2;
        goto L27
    L21:
        throw new NoViableAltException("", 14, 0, this.input);     // Catch: Throwable -> L22 RecognitionException -> L24
    L24:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L22:
        th = move-exception;
        throw th;
    }

    public final atom_return atom() throws RecognitionException {
        atom_return r5 = new atom_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L52 RecognitionException -> L54
        if (r10 == 20) goto L64;
        if (r10 == 52) goto L62;
        if (r10 == 57) goto L61;
        if (r10 == 62) goto L60;
        if (r10 == 66) goto L60;
        if (r10 == 98) goto L59;
        if (r10 != 100) goto L58;
        int r11 = this.input.LA(2);     // Catch: Throwable -> L52 RecognitionException -> L54
        if (r11 != 2) goto L18;
        char r12 = 4;
    L84:
        ATNFactory.Handle r13 = null;
        switch(r12) {
            case 1: goto L103;
            case 2: goto L99;
            case 3: goto L98;
            case 4: goto L97;
            case 5: goto L96;
            case 6: goto L92;
            case 7: goto L88;
            case 8: goto L87;
            default: goto L123;
        };     // Catch: Throwable -> L52 RecognitionException -> L54
    L87:
        pushFollow(FOLLOW_ruleref_in_atom929);     // Catch: Throwable -> L52 RecognitionException -> L54
        ATNFactory.Handle r14 = ruleref();     // Catch: Throwable -> L52 RecognitionException -> L54
        this.state._fsp--;     // Catch: Throwable -> L52 RecognitionException -> L54
        r5.f646p = r14;     // Catch: Throwable -> L52 RecognitionException -> L54
        goto L123
    L88:
        pushFollow(FOLLOW_terminal_in_atom914);     // Catch: Throwable -> L52 RecognitionException -> L54
        terminal_return r15 = terminal();     // Catch: Throwable -> L52 RecognitionException -> L54
        this.state._fsp--;     // Catch: Throwable -> L52 RecognitionException -> L54
        if (r15 == null) goto L91;
        r13 = r15.f650p;     // Catch: Throwable -> L52 RecognitionException -> L54
    L91:
        r5.f646p = r13;     // Catch: Throwable -> L52 RecognitionException -> L54
        goto L123
    L92:
        pushFollow(FOLLOW_blockSet_in_atom899);     // Catch: Throwable -> L52 RecognitionException -> L54
        blockSet_return r16 = blockSet(false);     // Catch: Throwable -> L52 RecognitionException -> L54
        this.state._fsp--;     // Catch: Throwable -> L52 RecognitionException -> L54
        if (r16 == null) goto L95;
        r13 = r16.f647p;     // Catch: Throwable -> L52 RecognitionException -> L54
    L95:
        r5.f646p = r13;     // Catch: Throwable -> L52 RecognitionException -> L54
        goto L123
    L96:
        match(this.input, 100, FOLLOW_WILDCARD_in_atom886);     // Catch: Throwable -> L52 RecognitionException -> L54
        r5.f646p = this.factory.wildcard((GrammarAST) r5.start);     // Catch: Throwable -> L52 RecognitionException -> L54
        goto L123
    L97:
        match(this.input, 100, FOLLOW_WILDCARD_in_atom871);     // Catch: Throwable -> L52 RecognitionException -> L54
        match(this.input, 2, null);     // Catch: Throwable -> L52 RecognitionException -> L54
        matchAny(this.input);     // Catch: Throwable -> L52 RecognitionException -> L54
        match(this.input, 3, null);     // Catch: Throwable -> L52 RecognitionException -> L54
        r5.f646p = this.factory.wildcard((GrammarAST) r5.start);     // Catch: Throwable -> L52 RecognitionException -> L54
        goto L123
    L98:
        match(this.input, 20, FOLLOW_DOT_in_atom854);     // Catch: Throwable -> L52 RecognitionException -> L54
        match(this.input, 2, null);     // Catch: Throwable -> L52 RecognitionException -> L54
        match(this.input, 28, FOLLOW_ID_in_atom856);     // Catch: Throwable -> L52 RecognitionException -> L54
        pushFollow(FOLLOW_ruleref_in_atom858);     // Catch: Throwable -> L52 RecognitionException -> L54
        ATNFactory.Handle r17 = ruleref();     // Catch: Throwable -> L52 RecognitionException -> L54
        this.state._fsp--;     // Catch: Throwable -> L52 RecognitionException -> L54
        match(this.input, 3, null);     // Catch: Throwable -> L52 RecognitionException -> L54
        r5.f646p = r17;     // Catch: Throwable -> L52 RecognitionException -> L54
        goto L123
    L99:
        match(this.input, 20, FOLLOW_DOT_in_atom840);     // Catch: Throwable -> L52 RecognitionException -> L54
        match(this.input, 2, null);     // Catch: Throwable -> L52 RecognitionException -> L54
        match(this.input, 28, FOLLOW_ID_in_atom842);     // Catch: Throwable -> L52 RecognitionException -> L54
        pushFollow(FOLLOW_terminal_in_atom844);     // Catch: Throwable -> L52 RecognitionException -> L54
        terminal_return r18 = terminal();     // Catch: Throwable -> L52 RecognitionException -> L54
        this.state._fsp--;     // Catch: Throwable -> L52 RecognitionException -> L54
        match(this.input, 3, null);     // Catch: Throwable -> L52 RecognitionException -> L54
        if (r18 == null) goto L102;
        r13 = r18.f650p;     // Catch: Throwable -> L52 RecognitionException -> L54
    L102:
        r5.f646p = r13;     // Catch: Throwable -> L52 RecognitionException -> L54
        goto L123
    L103:
        pushFollow(FOLLOW_range_in_atom828);     // Catch: Throwable -> L52 RecognitionException -> L54
        ATNFactory.Handle r19 = range();     // Catch: Throwable -> L52 RecognitionException -> L54
        this.state._fsp--;     // Catch: Throwable -> L52 RecognitionException -> L54
        r5.f646p = r19;     // Catch: Throwable -> L52 RecognitionException -> L54
    L123:
        return r5;
    L18:
        if (r11 == (-1)) goto L56;
        if (r11 < 3) goto L21;
        if (r11 <= 4) goto L56;
    L21:
        if (r11 == 10) goto L56;
        if (r11 == 20) goto L56;
        if (r11 == 32) goto L56;
        if (r11 == 39) goto L56;
        if (r11 == 46) goto L56;
        if (r11 == 52) goto L56;
        if (r11 == 57) goto L56;
        if (r11 == 59) goto L56;
        if (r11 == 62) goto L56;
        if (r11 == 66) goto L56;
        if (r11 == 78) goto L56;
        if (r11 == 80) goto L56;
        if (r11 >= 89) goto L42;
    L43:
        if (r11 == 98) goto L56;
        if (r11 == 100) goto L56;
        int r20 = this.input.mark();     // Catch: Throwable -> L52 RecognitionException -> L54
        this.input.consume();     // Catch: Throwable -> L49
        throw new NoViableAltException("", 19, 3, this.input);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        this.input.rewind(r20);     // Catch: Throwable -> L52 RecognitionException -> L54
        throw th;     // Catch: Throwable -> L52 RecognitionException -> L54
    L42:
        if (r11 > 90) goto L43;
    L56:
        r12 = 5;
        goto L84
    L58:
        throw new NoViableAltException("", 19, 0, this.input);     // Catch: Throwable -> L52 RecognitionException -> L54
    L59:
        r12 = 6;
    L60:
        r12 = 7;
        goto L84
    L61:
        r12 = '\b';
        goto L84
    L62:
        r12 = 1;
        goto L84
    L64:
        if (this.input.LA(2) == 2) goto L66;
        int r21 = this.input.mark();     // Catch: Throwable -> L52 RecognitionException -> L54
        this.input.consume();     // Catch: Throwable -> L118
        throw new NoViableAltException("", 19, 2, this.input);     // Catch: Throwable -> L118
    L118:
        th = move-exception;
        this.input.rewind(r21);     // Catch: Throwable -> L52 RecognitionException -> L54
        throw th;     // Catch: Throwable -> L52 RecognitionException -> L54
    L66:
        if (this.input.LA(3) != 28) goto L104;
        int r22 = this.input.LA(4);     // Catch: Throwable -> L52 RecognitionException -> L54
        if (r22 == 62) goto L83;
        if (r22 == 66) goto L83;
        if (r22 != 57) goto L73;
        r12 = 3;
        goto L84
    L73:
        int r23 = this.input.mark();     // Catch: Throwable -> L52 RecognitionException -> L54
        int r110 = 0;
    L75:
        if (r110 >= 3) goto L80;
        this.input.consume();     // Catch: Throwable -> L77
        r110 = r110 + 1;     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        this.input.rewind(r23);     // Catch: Throwable -> L52 RecognitionException -> L54
        throw th;     // Catch: Throwable -> L52 RecognitionException -> L54
    L80:
        throw new NoViableAltException("", 19, 10, this.input);     // Catch: Throwable -> L77
    L83:
        r12 = 2;
        goto L84
    L104:
        int r24 = this.input.mark();     // Catch: Throwable -> L52 RecognitionException -> L54
        int r111 = 0;
    L107:
        if (r111 >= 2) goto L112;
        this.input.consume();     // Catch: Throwable -> L109
        r111 = r111 + 1;     // Catch: Throwable -> L109
    L109:
        th = move-exception;
        this.input.rewind(r24);     // Catch: Throwable -> L52 RecognitionException -> L54
        throw th;     // Catch: Throwable -> L52 RecognitionException -> L54
    L112:
        throw new NoViableAltException("", 19, 7, this.input);     // Catch: Throwable -> L109
    L54:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L52:
        th = move-exception;
        throw th;
    }

    public final ATNFactory.Handle block(GrammarAST r10) throws RecognitionException {
        ArrayList r5 = new ArrayList();
        GrammarAST r11 = (GrammarAST) match(this.input, 78, FOLLOW_BLOCK_in_block209);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(this.input, 2, null);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (this.input.LA(1) != 42) goto L18;
        match(this.input, 42, FOLLOW_OPTIONS_in_block213);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (this.input.LA(1) != 2) goto L18;
        match(this.input, 2, null);     // Catch: Throwable -> L13 RecognitionException -> L15
    L8:
        int r12 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r12 < 4) goto L17;
        if (r12 > 100) goto L17;
        matchAny(this.input);     // Catch: Throwable -> L13 RecognitionException -> L15
    L17:
        match(this.input, 3, null);     // Catch: Throwable -> L13 RecognitionException -> L15
    L18:
        int r13 = 0;
    L19:
        int r14 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r14 != 74) goto L22;
    L28:
        pushFollow(FOLLOW_alternative_in_block224);     // Catch: Throwable -> L13 RecognitionException -> L15
        ATNFactory.Handle r15 = alternative();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.add(r15);     // Catch: Throwable -> L13 RecognitionException -> L15
        r13 = r13 + 1;
        goto L19
    L22:
        if (r14 == 87) goto L28;
        if (r13 < 1) goto L27;
        match(this.input, 3, null);     // Catch: Throwable -> L13 RecognitionException -> L15
        return this.factory.block((BlockAST) r11, r10, r5);
    L27:
        throw new EarlyExitException(6, this.input);     // Catch: Throwable -> L13 RecognitionException -> L15
    L15:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public final blockSet_return blockSet(boolean r10) throws RecognitionException {
        blockSet_return r5 = new blockSet_return();
        r5.start = this.input.LT(1);
        ArrayList r11 = new ArrayList();
        match(this.input, 98, FOLLOW_SET_in_blockSet742);     // Catch: Throwable -> L15 RecognitionException -> L17
        match(this.input, 2, null);     // Catch: Throwable -> L15 RecognitionException -> L17
        int r12 = 0;
    L4:
        int r13 = this.input.LA(1);     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r13 != 32) goto L7;
    L21:
        pushFollow(FOLLOW_setElement_in_blockSet745);     // Catch: Throwable -> L15 RecognitionException -> L17
        setElement_return r14 = setElement();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r14 == null) goto L24;
        GrammarAST r15 = (GrammarAST) r14.start;     // Catch: Throwable -> L15 RecognitionException -> L17
    L25:
        r11.add(r15);     // Catch: Throwable -> L15 RecognitionException -> L17
        r12 = r12 + 1;
        goto L4
    L24:
        r15 = null;
        goto L25
    L7:
        if (r13 == 52) goto L21;
        if (r13 == 62) goto L21;
        if (r13 == 66) goto L21;
        if (r12 < 1) goto L20;
        match(this.input, 3, null);     // Catch: Throwable -> L15 RecognitionException -> L17
        r5.f647p = this.factory.set((GrammarAST) r5.start, r11, r10);     // Catch: Throwable -> L15 RecognitionException -> L17
    L29:
        return r5;
    L20:
        throw new EarlyExitException(17, this.input);     // Catch: Throwable -> L15 RecognitionException -> L17
    L17:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L15:
        th = move-exception;
        throw th;
    }

    public final void dummy() throws RecognitionException {
        pushFollow(FOLLOW_block_in_dummy63);     // Catch: Throwable -> L4 RecognitionException -> L6
        block(null);     // Catch: Throwable -> L4 RecognitionException -> L6
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

    public final element_return element() throws RecognitionException {
        element_return r5 = new element_return();
        r5.start = this.input.LT(1);
    L10:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L115:
        return r5;
    L8:
        th = move-exception;
        throw th;
    L5:
        switch(this.input.LA(1)) {
            case 4: goto L54;
            case 10: goto L53;
            case 20: goto L52;
            case 32: goto L51;
            case 39: goto L50;
            case 46: goto L53;
            case 52: goto L52;
            case 57: goto L52;
            case 59: goto L13;
            case 62: goto L52;
            case 66: goto L52;
            case 78: goto L12;
            case 80: goto L12;
            case 89: goto L12;
            case 90: goto L12;
            case 98: goto L52;
            case 100: goto L52;
            default: goto L7;
        };
    L12:
        char r10 = 3;
    L91:
        ATNFactory.Handle r11 = null;
        switch(r10) {
            case 1: goto L111;
            case 2: goto L107;
            case 3: goto L103;
            case 4: goto L102;
            case 5: goto L101;
            case 6: goto L100;
            case 7: goto L99;
            case 8: goto L95;
            case 9: goto L94;
            default: goto L115;
        };     // Catch: Throwable -> L8 RecognitionException -> L10
    L94:
        match(this.input, 32, FOLLOW_LEXER_CHAR_SET_in_element570);     // Catch: Throwable -> L8 RecognitionException -> L10
        r5.f648p = this.factory.charSetLiteral((GrammarAST) r5.start);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L115
    L95:
        match(this.input, 39, FOLLOW_NOT_in_element553);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        pushFollow(FOLLOW_blockSet_in_element557);     // Catch: Throwable -> L8 RecognitionException -> L10
        blockSet_return r12 = blockSet(true);     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r12 == null) goto L98;
        r11 = r12.f647p;     // Catch: Throwable -> L8 RecognitionException -> L10
    L98:
        r5.f648p = r11;     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L115
    L99:
        GrammarAST r13 = (GrammarAST) match(this.input, 59, FOLLOW_SEMPRED_in_element536);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        matchAny(this.input);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        r5.f648p = this.factory.sempred((PredAST) r13);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L115
    L100:
        GrammarAST r14 = (GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_element519);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        matchAny(this.input);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        r5.f648p = this.factory.action((ActionAST) r14);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L115
    L101:
        r5.f648p = this.factory.sempred((PredAST) ((GrammarAST) match(this.input, 59, FOLLOW_SEMPRED_in_element504)));     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L115
    L102:
        r5.f648p = this.factory.action((ActionAST) ((GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_element490)));     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L115
    L103:
        pushFollow(FOLLOW_subrule_in_element476);     // Catch: Throwable -> L8 RecognitionException -> L10
        subrule_return r15 = subrule();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r15 == null) goto L106;
        r11 = r15.f649p;     // Catch: Throwable -> L8 RecognitionException -> L10
    L106:
        r5.f648p = r11;     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L115
    L107:
        pushFollow(FOLLOW_atom_in_element464);     // Catch: Throwable -> L8 RecognitionException -> L10
        atom_return r16 = atom();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r16 == null) goto L110;
        r11 = r16.f646p;     // Catch: Throwable -> L8 RecognitionException -> L10
    L110:
        r5.f648p = r11;     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L115
    L111:
        pushFollow(FOLLOW_labeledElement_in_element454);     // Catch: Throwable -> L8 RecognitionException -> L10
        ATNFactory.Handle r17 = labeledElement();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        r5.f648p = r17;     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L115
    L13:
        int r18 = this.input.LA(2);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r18 != 2) goto L16;
        r10 = 7;
        goto L91
    L16:
        if (r18 < 3) goto L18;
        if (r18 > 4) goto L18;
    L49:
        r10 = 5;
    L18:
        if (r18 == 10) goto L49;
        if (r18 == 20) goto L49;
        if (r18 == 32) goto L49;
        if (r18 == 39) goto L49;
        if (r18 == 46) goto L49;
        if (r18 == 52) goto L49;
        if (r18 == 57) goto L49;
        if (r18 == 59) goto L49;
        if (r18 == 62) goto L49;
        if (r18 == 66) goto L49;
        if (r18 == 78) goto L49;
        if (r18 == 80) goto L49;
        if (r18 < 89) goto L39;
        if (r18 <= 90) goto L49;
    L39:
        if (r18 == 98) goto L49;
        if (r18 == 100) goto L49;
        int r19 = this.input.mark();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.input.consume();     // Catch: Throwable -> L46
        throw new NoViableAltException("", 13, 5, this.input);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        this.input.rewind(r19);     // Catch: Throwable -> L8 RecognitionException -> L10
        throw th;     // Catch: Throwable -> L8 RecognitionException -> L10
    L50:
        r10 = '\b';
        goto L91
    L51:
        r10 = '\t';
        goto L91
    L52:
        r10 = 2;
        goto L91
    L53:
        r10 = 1;
        goto L91
    L54:
        int r20 = this.input.LA(2);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r20 != 2) goto L57;
        r10 = 6;
        goto L91
    L57:
        if (r20 < 3) goto L59;
        if (r20 > 4) goto L59;
    L90:
        r10 = 4;
    L59:
        if (r20 == 10) goto L90;
        if (r20 == 20) goto L90;
        if (r20 == 32) goto L90;
        if (r20 == 39) goto L90;
        if (r20 == 46) goto L90;
        if (r20 == 52) goto L90;
        if (r20 == 57) goto L90;
        if (r20 == 59) goto L90;
        if (r20 == 62) goto L90;
        if (r20 == 66) goto L90;
        if (r20 == 78) goto L90;
        if (r20 == 80) goto L90;
        if (r20 < 89) goto L80;
        if (r20 <= 90) goto L90;
    L80:
        if (r20 == 98) goto L90;
        if (r20 == 100) goto L90;
        int r21 = this.input.mark();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.input.consume();     // Catch: Throwable -> L87
        throw new NoViableAltException("", 13, 4, this.input);     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        this.input.rewind(r21);     // Catch: Throwable -> L8 RecognitionException -> L10
        throw th;     // Catch: Throwable -> L8 RecognitionException -> L10
    L7:
        throw new NoViableAltException("", 13, 0, this.input);     // Catch: Throwable -> L8 RecognitionException -> L10
    }

    public final void elementOption() throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L26 RecognitionException -> L28
        if (r5 != 28) goto L6;
        char r10 = 1;
    L34:
        if (r10 != 1) goto L36;
        match(this.input, 28, FOLLOW_ID_in_elementOption1166);     // Catch: Throwable -> L26 RecognitionException -> L28
        return;
    L36:
        if (r10 == 2) goto L44;
        if (r10 == 3) goto L43;
        if (r10 == 4) goto L42;
        if (r10 != 5) goto L75;
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption1205);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 2, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 28, FOLLOW_ID_in_elementOption1207);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 30, FOLLOW_INT_in_elementOption1209);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 3, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        return;
    L75:
        return;
    L42:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption1194);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 2, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 28, FOLLOW_ID_in_elementOption1196);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 4, FOLLOW_ACTION_in_elementOption1198);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 3, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        return;
    L43:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption1183);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 2, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 28, FOLLOW_ID_in_elementOption1185);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_elementOption1187);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 3, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        return;
    L44:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption1172);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 2, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 28, FOLLOW_ID_in_elementOption1174);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 28, FOLLOW_ID_in_elementOption1176);     // Catch: Throwable -> L26 RecognitionException -> L28
        match(this.input, 3, null);     // Catch: Throwable -> L26 RecognitionException -> L28
        return;
    L6:
        int r11 = 0;
        if (r5 != 10) goto L62;
        if (this.input.LA(2) == 2) goto L11;
        int r12 = this.input.mark();     // Catch: Throwable -> L26 RecognitionException -> L28
        this.input.consume();     // Catch: Throwable -> L58
        throw new NoViableAltException("", 26, 2, this.input);     // Catch: Throwable -> L58
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
        throw new NoViableAltException("", 26, 4, this.input);     // Catch: Throwable -> L20
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
        throw new NoViableAltException("", 26, 3, this.input);     // Catch: Throwable -> L49
    L62:
        throw new NoViableAltException("", 26, 0, this.input);     // Catch: Throwable -> L26 RecognitionException -> L28
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
        match(this.input, 82, FOLLOW_ELEMENT_OPTIONS_in_elementOptions1151);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (this.input.LA(1) != 2) goto L25;
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
    L5:
        int r5 = this.input.LA(1);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r5 == 10) goto L15;
        if (r5 == 28) goto L15;
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
    L26:
        return;
    L15:
        pushFollow(FOLLOW_elementOption_in_elementOptions1153);     // Catch: Throwable -> L11 RecognitionException -> L13
        elementOption();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L5
    L25:
        return;
    L13:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public TreeParser[] getDelegates() {
        return new TreeParser[0];
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getGrammarFileName() {
        return "androidx/room/jarjarred/org/antlr/v4/parse/ATNBuilder.g";
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String[] getTokenNames() {
        return tokenNames;
    }

    public final ATNFactory.Handle labeledElement() throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r5 != 10) goto L6;
        char r10 = 1;
    L9:
        if (r10 == 1) goto L21;
        if (r10 != 2) goto L32;
        match(this.input, 46, FOLLOW_PLUS_ASSIGN_in_labeledElement643);     // Catch: Throwable -> L15 RecognitionException -> L17
        match(this.input, 2, null);     // Catch: Throwable -> L15 RecognitionException -> L17
        match(this.input, 28, FOLLOW_ID_in_labeledElement645);     // Catch: Throwable -> L15 RecognitionException -> L17
        pushFollow(FOLLOW_element_in_labeledElement647);     // Catch: Throwable -> L15 RecognitionException -> L17
        element_return r11 = element();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        match(this.input, 3, null);     // Catch: Throwable -> L15 RecognitionException -> L17
        ATNFactory r12 = this.factory;     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r11 == null) goto L19;
        ATNFactory.Handle r13 = r11.f648p;     // Catch: Throwable -> L15 RecognitionException -> L17
    L33:
        return r12.listLabel(r13);
    L19:
        r13 = null;
        goto L33
    L32:
        return null;
    L21:
        match(this.input, 10, FOLLOW_ASSIGN_in_labeledElement626);     // Catch: Throwable -> L15 RecognitionException -> L17
        match(this.input, 2, null);     // Catch: Throwable -> L15 RecognitionException -> L17
        match(this.input, 28, FOLLOW_ID_in_labeledElement628);     // Catch: Throwable -> L15 RecognitionException -> L17
        pushFollow(FOLLOW_element_in_labeledElement630);     // Catch: Throwable -> L15 RecognitionException -> L17
        element_return r14 = element();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        match(this.input, 3, null);     // Catch: Throwable -> L15 RecognitionException -> L17
        ATNFactory r15 = this.factory;     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r14 == null) goto L24;
        ATNFactory.Handle r16 = r14.f648p;     // Catch: Throwable -> L15 RecognitionException -> L17
    L34:
        return r15.label(r16);
    L24:
        r16 = null;
        goto L34
    L6:
        if (r5 != 46) goto L27;
        r10 = 2;
        goto L9
    L27:
        throw new NoViableAltException("", 15, 0, this.input);     // Catch: Throwable -> L15 RecognitionException -> L17
    L17:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public final ATNFactory.Handle lexerCommand() throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r5 != 86) goto L6;
        char r10 = 1;
    L8:
        if (r10 == 1) goto L16;
        if (r10 == 2) goto L28;
        return null;
    L28:
        return this.factory.lexerCommand((GrammarAST) match(this.input, 28, FOLLOW_ID_in_lexerCommand413));
    L16:
        match(this.input, 86, FOLLOW_LEXER_ACTION_CALL_in_lexerCommand393);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        GrammarAST r11 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_lexerCommand395);     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_lexerCommandExpr_in_lexerCommand397);     // Catch: Throwable -> L12 RecognitionException -> L14
        lexerCommandExpr_return r12 = lexerCommandExpr();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        ATNFactory r13 = this.factory;     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r12 == null) goto L19;
        GrammarAST r14 = (GrammarAST) r12.start;     // Catch: Throwable -> L12 RecognitionException -> L14
    L29:
        return r13.lexerCallCommand(r11, r14);
    L19:
        r14 = null;
        goto L29
    L6:
        if (r5 != 28) goto L22;
        r10 = 2;
        goto L8
    L22:
        throw new NoViableAltException("", 12, 0, this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L12:
        th = move-exception;
        throw th;
    }

    public final lexerCommandExpr_return lexerCommandExpr() throws RecognitionException {
        lexerCommandExpr_return r5 = new lexerCommandExpr_return();
        r5.start = this.input.LT(1);
    L12:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L18:
        return r5;
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.input.LA(1) != 28) goto L6;
    L14:
        this.input.consume();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state.errorRecovery = false;     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L18
    L6:
        if (this.input.LA(1) == 30) goto L14;
        throw new MismatchedSetException(null, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    }

    public final ATNFactory.Handle lexerCommands() throws RecognitionException {
        ArrayList r5 = new ArrayList();
        int r10 = 0;
    L23:
        int r11 = this.input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r11 != 28) goto L6;
    L16:
        pushFollow(FOLLOW_lexerCommand_in_lexerCommands360);     // Catch: Throwable -> L10 RecognitionException -> L12
        ATNFactory.Handle r12 = lexerCommand();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state._fsp--;     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r12 == null) goto L19;
        r5.add(r12);     // Catch: Throwable -> L10 RecognitionException -> L12
    L19:
        r10 = r10 + 1;
        goto L23
    L6:
        if (r11 == 86) goto L16;
        if (r10 < 1) goto L15;
        return this.factory.alt(r5);
    L15:
        throw new EarlyExitException(11, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    L12:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L10:
        th = move-exception;
        throw th;
    }

    public final ATNFactory.Handle range() throws RecognitionException {
        match(this.input, 52, FOLLOW_RANGE_in_range1035);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 2, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r5 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_range1039);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r10 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_range1043);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 3, null);     // Catch: Throwable -> L5 RecognitionException -> L7
    L14:
        return this.factory.range(r5, r10);
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L5:
        th = move-exception;
        throw th;
    }

    public final ATNFactory.Handle ruleBlock(GrammarAST r11) throws RecognitionException {
        ArrayList r5 = new ArrayList();
        this.factory.setCurrentOuterAlt(1);
        GrammarAST r10 = (GrammarAST) match(this.input, 78, FOLLOW_BLOCK_in_ruleBlock89);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(this.input, 2, null);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (this.input.LA(1) != 42) goto L18;
        match(this.input, 42, FOLLOW_OPTIONS_in_ruleBlock105);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (this.input.LA(1) != 2) goto L18;
        match(this.input, 2, null);     // Catch: Throwable -> L13 RecognitionException -> L15
    L8:
        int r12 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r12 < 4) goto L17;
        if (r12 > 100) goto L17;
        matchAny(this.input);     // Catch: Throwable -> L13 RecognitionException -> L15
    L17:
        match(this.input, 3, null);     // Catch: Throwable -> L13 RecognitionException -> L15
    L18:
        int r13 = 0;
        int r14 = 1;
    L19:
        int r15 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r15 != 74) goto L22;
    L28:
        pushFollow(FOLLOW_alternative_in_ruleBlock131);     // Catch: Throwable -> L13 RecognitionException -> L15
        ATNFactory.Handle r16 = alternative();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.add(r16);     // Catch: Throwable -> L13 RecognitionException -> L15
        r14 = r14 + 1;     // Catch: Throwable -> L13 RecognitionException -> L15
        this.factory.setCurrentOuterAlt(r14);     // Catch: Throwable -> L13 RecognitionException -> L15
        r13 = r13 + 1;
        goto L19
    L22:
        if (r15 == 87) goto L28;
        if (r13 < 1) goto L27;
        match(this.input, 3, null);     // Catch: Throwable -> L13 RecognitionException -> L15
        return this.factory.block((BlockAST) r10, r11, r5);
    L27:
        throw new EarlyExitException(3, this.input);     // Catch: Throwable -> L13 RecognitionException -> L15
    L15:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public final ATNFactory.Handle ruleref() throws RecognitionException {
    L23:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return null;
    L21:
        th = move-exception;
        throw th;
    L4:
        int r5 = 0;
        if (this.input.LA(1) != 57) goto L106;
        int r10 = this.input.LA(2);     // Catch: Throwable -> L21 RecognitionException -> L23
        if (r10 != 2) goto L40;
        int r11 = this.input.LA(3);     // Catch: Throwable -> L21 RecognitionException -> L23
        if (r11 == 3) goto L29;
        if (r11 == 8) goto L25;
        if (r11 == 82) goto L27;
        int r12 = this.input.mark();     // Catch: Throwable -> L21 RecognitionException -> L23
    L13:
        if (r5 >= 2) goto L18;
        this.input.consume();     // Catch: Throwable -> L15
        r5 = r5 + 1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.input.rewind(r12);     // Catch: Throwable -> L21 RecognitionException -> L23
        throw th;     // Catch: Throwable -> L21 RecognitionException -> L23
    L18:
        throw new NoViableAltException("", 23, 2, this.input);     // Catch: Throwable -> L15
    L27:
        char r13 = 1;
    L81:
        if (r13 == 1) goto L93;
        if (r13 == 2) goto L86;
        if (r13 == 3) goto L122;
        return null;
    L122:
        return this.factory.ruleRef((GrammarAST) match(this.input, 57, FOLLOW_RULE_REF_in_ruleref1001));
    L86:
        GrammarAST r14 = (GrammarAST) match(this.input, 57, FOLLOW_RULE_REF_in_ruleref980);     // Catch: Throwable -> L21 RecognitionException -> L23
        if (this.input.LA(1) != 2) goto L123;
        match(this.input, 2, null);     // Catch: Throwable -> L21 RecognitionException -> L23
        if (this.input.LA(1) != 8) goto L91;
        match(this.input, 8, FOLLOW_ARG_ACTION_in_ruleref982);     // Catch: Throwable -> L21 RecognitionException -> L23
    L91:
        match(this.input, 3, null);     // Catch: Throwable -> L21 RecognitionException -> L23
    L123:
        return this.factory.ruleRef(r14);
    L93:
        GrammarAST r15 = (GrammarAST) match(this.input, 57, FOLLOW_RULE_REF_in_ruleref957);     // Catch: Throwable -> L21 RecognitionException -> L23
        match(this.input, 2, null);     // Catch: Throwable -> L21 RecognitionException -> L23
        if (this.input.LA(1) != 8) goto L96;
        match(this.input, 8, FOLLOW_ARG_ACTION_in_ruleref959);     // Catch: Throwable -> L21 RecognitionException -> L23
    L96:
        match(this.input, 82, FOLLOW_ELEMENT_OPTIONS_in_ruleref963);     // Catch: Throwable -> L21 RecognitionException -> L23
        if (this.input.LA(1) != 2) goto L104;
        match(this.input, 2, null);     // Catch: Throwable -> L21 RecognitionException -> L23
    L99:
        int r16 = this.input.LA(1);     // Catch: Throwable -> L21 RecognitionException -> L23
        if (r16 < 4) goto L103;
        if (r16 > 100) goto L103;
        matchAny(this.input);     // Catch: Throwable -> L21 RecognitionException -> L23
    L103:
        match(this.input, 3, null);     // Catch: Throwable -> L21 RecognitionException -> L23
    L104:
        match(this.input, 3, null);     // Catch: Throwable -> L21 RecognitionException -> L23
        return this.factory.ruleRef(r15);
    L25:
        int r17 = this.input.LA(4);     // Catch: Throwable -> L21 RecognitionException -> L23
        if (r17 == 82) goto L27;
        if (r17 == 3) goto L29;
        int r18 = this.input.mark();     // Catch: Throwable -> L21 RecognitionException -> L23
    L31:
        if (r5 >= 3) goto L36;
        this.input.consume();     // Catch: Throwable -> L33
        r5 = r5 + 1;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        this.input.rewind(r18);     // Catch: Throwable -> L21 RecognitionException -> L23
        throw th;     // Catch: Throwable -> L21 RecognitionException -> L23
    L36:
        throw new NoViableAltException("", 23, 4, this.input);     // Catch: Throwable -> L33
    L29:
        r13 = 2;
        goto L81
    L40:
        if (r10 == (-1)) goto L80;
        if (r10 < 3) goto L44;
        if (r10 <= 4) goto L80;
    L44:
        if (r10 == 10) goto L80;
        if (r10 == 20) goto L80;
        if (r10 == 32) goto L80;
        if (r10 == 39) goto L80;
        if (r10 == 46) goto L80;
        if (r10 == 52) goto L80;
        if (r10 == 57) goto L80;
        if (r10 == 59) goto L80;
        if (r10 == 62) goto L80;
        if (r10 == 66) goto L80;
        if (r10 == 78) goto L80;
        if (r10 == 80) goto L80;
        if (r10 < 89) goto L71;
        if (r10 <= 90) goto L80;
    L71:
        if (r10 == 98) goto L80;
        if (r10 == 100) goto L80;
        int r19 = this.input.mark();     // Catch: Throwable -> L21 RecognitionException -> L23
        this.input.consume();     // Catch: Throwable -> L77
        throw new NoViableAltException("", 23, 1, this.input);     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        this.input.rewind(r19);     // Catch: Throwable -> L21 RecognitionException -> L23
        throw th;     // Catch: Throwable -> L21 RecognitionException -> L23
    L80:
        r13 = 3;
        goto L81
    L106:
        throw new NoViableAltException("", 23, 0, this.input);     // Catch: Throwable -> L21 RecognitionException -> L23
    }

    public final setElement_return setElement() throws RecognitionException {
        setElement_return r5 = new setElement_return();
        char r10 = 1;
        r5.start = this.input.LT(1);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L25 RecognitionException -> L27
        if (r11 == 32) goto L50;
        if (r11 != 52) goto L8;
        char r12 = 5;
    L52:
        switch(r12) {
            case 1: goto L59;
            case 2: goto L58;
            case 3: goto L57;
            case 4: goto L56;
            case 5: goto L55;
            case 6: goto L54;
            default: goto L63;
        };     // Catch: Throwable -> L25 RecognitionException -> L27
    L54:
        match(this.input, 32, FOLLOW_LEXER_CHAR_SET_in_setElement813);     // Catch: Throwable -> L25 RecognitionException -> L27
        goto L63
    L55:
        match(this.input, 52, FOLLOW_RANGE_in_setElement794);     // Catch: Throwable -> L25 RecognitionException -> L27
        match(this.input, 2, null);     // Catch: Throwable -> L25 RecognitionException -> L27
        GrammarAST r13 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement798);     // Catch: Throwable -> L25 RecognitionException -> L27
        GrammarAST r14 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement802);     // Catch: Throwable -> L25 RecognitionException -> L27
        match(this.input, 3, null);     // Catch: Throwable -> L25 RecognitionException -> L27
        goto L63
    L56:
        match(this.input, 66, FOLLOW_TOKEN_REF_in_setElement788);     // Catch: Throwable -> L25 RecognitionException -> L27
        goto L63
    L57:
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement783);     // Catch: Throwable -> L25 RecognitionException -> L27
        goto L63
    L58:
        match(this.input, 66, FOLLOW_TOKEN_REF_in_setElement775);     // Catch: Throwable -> L25 RecognitionException -> L27
        match(this.input, 2, null);     // Catch: Throwable -> L25 RecognitionException -> L27
        matchAny(this.input);     // Catch: Throwable -> L25 RecognitionException -> L27
        match(this.input, 3, null);     // Catch: Throwable -> L25 RecognitionException -> L27
        goto L63
    L59:
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement766);     // Catch: Throwable -> L25 RecognitionException -> L27
        match(this.input, 2, null);     // Catch: Throwable -> L25 RecognitionException -> L27
        matchAny(this.input);     // Catch: Throwable -> L25 RecognitionException -> L27
        match(this.input, 3, null);     // Catch: Throwable -> L25 RecognitionException -> L27
    L63:
        return r5;
    L8:
        if (r11 == 62) goto L32;
        if (r11 != 66) goto L31;
        int r15 = this.input.LA(2);     // Catch: Throwable -> L25 RecognitionException -> L27
        if (r15 != 2) goto L13;
        r12 = 2;
        goto L52
    L13:
        if (r15 == 3) goto L29;
        if (r15 == 32) goto L29;
        if (r15 == 52) goto L29;
        if (r15 == 62) goto L29;
        if (r15 == 66) goto L29;
        int r16 = this.input.mark();     // Catch: Throwable -> L25 RecognitionException -> L27
        this.input.consume();     // Catch: Throwable -> L22
        throw new NoViableAltException("", 18, 2, this.input);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.input.rewind(r16);     // Catch: Throwable -> L25 RecognitionException -> L27
        throw th;     // Catch: Throwable -> L25 RecognitionException -> L27
    L29:
        r12 = 4;
        goto L52
    L31:
        throw new NoViableAltException("", 18, 0, this.input);     // Catch: Throwable -> L25 RecognitionException -> L27
    L32:
        int r17 = this.input.LA(2);     // Catch: Throwable -> L25 RecognitionException -> L27
        if (r17 == 2) goto L48;
        if (r17 == 3) goto L47;
        if (r17 == 32) goto L47;
        if (r17 == 52) goto L47;
        if (r17 == 62) goto L47;
        if (r17 == 66) goto L47;
        int r18 = this.input.mark();     // Catch: Throwable -> L25 RecognitionException -> L27
        this.input.consume();     // Catch: Throwable -> L44
        throw new NoViableAltException("", 18, 1, this.input);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        this.input.rewind(r18);     // Catch: Throwable -> L25 RecognitionException -> L27
        throw th;     // Catch: Throwable -> L25 RecognitionException -> L27
    L47:
        r10 = 3;
    L48:
        r12 = r10;
        goto L52
    L50:
        r12 = 6;
    L27:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L25:
        th = move-exception;
        throw th;
    }

    public final subrule_return subrule() throws RecognitionException {
        subrule_return r5 = new subrule_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r10 == 78) goto L17;
        if (r10 == 80) goto L16;
        if (r10 == 89) goto L15;
        if (r10 != 90) goto L10;
        char r11 = 3;
    L19:
        if (r11 == 1) goto L27;
        if (r11 == 2) goto L26;
        if (r11 == 3) goto L25;
        if (r11 != 4) goto L31;
        pushFollow(FOLLOW_block_in_subrule708);     // Catch: Throwable -> L11 RecognitionException -> L13
        ATNFactory.Handle r12 = block(null);     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.f649p = r12;     // Catch: Throwable -> L11 RecognitionException -> L13
    L31:
        return r5;
    L25:
        match(this.input, 90, FOLLOW_POSITIVE_CLOSURE_in_subrule696);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        pushFollow(FOLLOW_block_in_subrule698);     // Catch: Throwable -> L11 RecognitionException -> L13
        ATNFactory.Handle r13 = block((GrammarAST) r5.start);     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.f649p = r13;     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L31
    L26:
        match(this.input, 80, FOLLOW_CLOSURE_in_subrule682);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        pushFollow(FOLLOW_block_in_subrule684);     // Catch: Throwable -> L11 RecognitionException -> L13
        ATNFactory.Handle r14 = block((GrammarAST) r5.start);     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.f649p = r14;     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L31
    L27:
        match(this.input, 89, FOLLOW_OPTIONAL_in_subrule668);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        pushFollow(FOLLOW_block_in_subrule670);     // Catch: Throwable -> L11 RecognitionException -> L13
        ATNFactory.Handle r15 = block((GrammarAST) r5.start);     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.f649p = r15;     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L31
    L10:
        throw new NoViableAltException("", 16, 0, this.input);     // Catch: Throwable -> L11 RecognitionException -> L13
    L15:
        r11 = 1;
        goto L19
    L16:
        r11 = 2;
        goto L19
    L17:
        r11 = 4;
    L13:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L11:
        th = move-exception;
        throw th;
    }

    public final terminal_return terminal() throws RecognitionException {
        terminal_return r5 = new terminal_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L43 RecognitionException -> L45
        if (r10 != 62) goto L49;
        int r11 = this.input.LA(2);     // Catch: Throwable -> L43 RecognitionException -> L45
        if (r11 != 2) goto L9;
        char r12 = 1;
    L128:
        if (r12 == 1) goto L139;
        if (r12 == 2) goto L138;
        if (r12 == 3) goto L137;
        if (r12 != 4) goto L133;
        match(this.input, 66, FOLLOW_TOKEN_REF_in_terminal1114);     // Catch: Throwable -> L43 RecognitionException -> L45
        match(this.input, 2, null);     // Catch: Throwable -> L43 RecognitionException -> L45
        matchAny(this.input);     // Catch: Throwable -> L43 RecognitionException -> L45
        match(this.input, 3, null);     // Catch: Throwable -> L43 RecognitionException -> L45
        r5.f650p = this.factory.tokenRef((TerminalAST) ((GrammarAST) r5.start));     // Catch: Throwable -> L43 RecognitionException -> L45
    L144:
        return r5;
    L133:
        if (r12 != 5) goto L144;
        match(this.input, 66, FOLLOW_TOKEN_REF_in_terminal1130);     // Catch: Throwable -> L43 RecognitionException -> L45
        r5.f650p = this.factory.tokenRef((TerminalAST) ((GrammarAST) r5.start));     // Catch: Throwable -> L43 RecognitionException -> L45
        goto L144
    L137:
        match(this.input, 66, FOLLOW_TOKEN_REF_in_terminal1098);     // Catch: Throwable -> L43 RecognitionException -> L45
        match(this.input, 2, null);     // Catch: Throwable -> L43 RecognitionException -> L45
        match(this.input, 8, FOLLOW_ARG_ACTION_in_terminal1100);     // Catch: Throwable -> L43 RecognitionException -> L45
        matchAny(this.input);     // Catch: Throwable -> L43 RecognitionException -> L45
        match(this.input, 3, null);     // Catch: Throwable -> L43 RecognitionException -> L45
        r5.f650p = this.factory.tokenRef((TerminalAST) ((GrammarAST) r5.start));     // Catch: Throwable -> L43 RecognitionException -> L45
        goto L144
    L138:
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_terminal1084);     // Catch: Throwable -> L43 RecognitionException -> L45
        r5.f650p = this.factory.stringLiteral((TerminalAST) ((GrammarAST) r5.start));     // Catch: Throwable -> L43 RecognitionException -> L45
        goto L144
    L139:
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_terminal1069);     // Catch: Throwable -> L43 RecognitionException -> L45
        match(this.input, 2, null);     // Catch: Throwable -> L43 RecognitionException -> L45
        matchAny(this.input);     // Catch: Throwable -> L43 RecognitionException -> L45
        match(this.input, 3, null);     // Catch: Throwable -> L43 RecognitionException -> L45
        r5.f650p = this.factory.stringLiteral((TerminalAST) ((GrammarAST) r5.start));     // Catch: Throwable -> L43 RecognitionException -> L45
        goto L144
    L9:
        if (r11 == (-1)) goto L47;
        if (r11 < 3) goto L12;
        if (r11 <= 4) goto L47;
    L12:
        if (r11 == 10) goto L47;
        if (r11 == 20) goto L47;
        if (r11 == 32) goto L47;
        if (r11 == 39) goto L47;
        if (r11 == 46) goto L47;
        if (r11 == 52) goto L47;
        if (r11 == 57) goto L47;
        if (r11 == 59) goto L47;
        if (r11 == 62) goto L47;
        if (r11 == 66) goto L47;
        if (r11 == 78) goto L47;
        if (r11 == 80) goto L47;
        if (r11 < 89) goto L33;
        if (r11 <= 90) goto L47;
    L33:
        if (r11 == 98) goto L47;
        if (r11 == 100) goto L47;
        int r13 = this.input.mark();     // Catch: Throwable -> L43 RecognitionException -> L45
        this.input.consume();     // Catch: Throwable -> L40
        throw new NoViableAltException("", 24, 1, this.input);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        this.input.rewind(r13);     // Catch: Throwable -> L43 RecognitionException -> L45
        throw th;     // Catch: Throwable -> L43 RecognitionException -> L45
    L47:
        r12 = 2;
        goto L128
    L49:
        if (r10 != 66) goto L141;
        int r14 = this.input.LA(2);     // Catch: Throwable -> L43 RecognitionException -> L45
        if (r14 != 2) goto L91;
        int r15 = this.input.LA(3);     // Catch: Throwable -> L43 RecognitionException -> L45
        if (r15 != 8) goto L72;
        int r16 = this.input.LA(4);     // Catch: Throwable -> L43 RecognitionException -> L45
        if (r16 >= 4) goto L57;
    L59:
        if (r16 < 2) goto L62;
        if (r16 > 3) goto L62;
    L79:
        char r17 = 4;
    L80:
        r12 = r17;
    L62:
        int r18 = this.input.mark();     // Catch: Throwable -> L43 RecognitionException -> L45
        int r19 = 0;
    L64:
        if (r19 >= 3) goto L69;
        this.input.consume();     // Catch: Throwable -> L66
        r19 = r19 + 1;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        this.input.rewind(r18);     // Catch: Throwable -> L43 RecognitionException -> L45
        throw th;     // Catch: Throwable -> L43 RecognitionException -> L45
    L69:
        throw new NoViableAltException("", 24, 7, this.input);     // Catch: Throwable -> L66
    L57:
        if (r16 > 100) goto L59;
        r17 = 3;
        goto L80
    L72:
        if (r15 < 4) goto L76;
        if (r15 <= 7) goto L79;
    L76:
        if (r15 >= 9) goto L78;
    L81:
        int r20 = this.input.mark();     // Catch: Throwable -> L43 RecognitionException -> L45
        int r110 = 0;
    L83:
        if (r110 >= 2) goto L88;
        this.input.consume();     // Catch: Throwable -> L85
        r110 = r110 + 1;     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        this.input.rewind(r20);     // Catch: Throwable -> L43 RecognitionException -> L45
        throw th;     // Catch: Throwable -> L43 RecognitionException -> L45
    L88:
        throw new NoViableAltException("", 24, 5, this.input);     // Catch: Throwable -> L85
    L78:
        if (r15 > 100) goto L81;
    L91:
        if (r14 == (-1)) goto L126;
        if (r14 < 3) goto L94;
        if (r14 <= 4) goto L126;
    L94:
        if (r14 == 10) goto L126;
        if (r14 == 20) goto L126;
        if (r14 == 32) goto L126;
        if (r14 == 39) goto L126;
        if (r14 == 46) goto L126;
        if (r14 == 52) goto L126;
        if (r14 == 57) goto L126;
        if (r14 == 59) goto L126;
        if (r14 == 62) goto L126;
        if (r14 == 66) goto L126;
        if (r14 == 78) goto L126;
        if (r14 == 80) goto L126;
        if (r14 < 89) goto L116;
        if (r14 <= 90) goto L126;
    L116:
        if (r14 == 98) goto L126;
        if (r14 == 100) goto L126;
        int r21 = this.input.mark();     // Catch: Throwable -> L43 RecognitionException -> L45
        this.input.consume();     // Catch: Throwable -> L123
        throw new NoViableAltException("", 24, 2, this.input);     // Catch: Throwable -> L123
    L123:
        th = move-exception;
        this.input.rewind(r21);     // Catch: Throwable -> L43 RecognitionException -> L45
        throw th;     // Catch: Throwable -> L43 RecognitionException -> L45
    L126:
        r12 = 5;
        goto L128
    L141:
        throw new NoViableAltException("", 24, 0, this.input);     // Catch: Throwable -> L43 RecognitionException -> L45
    L45:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L43:
        th = move-exception;
        throw th;
    }

    public ATNBuilder(TreeNodeStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.dfa10 = new DFA10(this, this);
    }

    public ATNBuilder(TreeNodeStream r5, ATNFactory r10) {
        this(r5);
        this.factory = r10;
    }
}
