package androidx.room.jarjarred.org.antlr.v4.parse;

import androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer;
import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.runtime.DFA;
import androidx.room.jarjarred.org.antlr.runtime.EarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.FailedPredicateException;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedSetException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeParser;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeRuleReturnScope;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes.dex */
public class LeftRecursiveRuleWalker extends TreeParser {
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
    static final short[] DFA11_accept = null;
    static final String DFA11_acceptS = "\u0004\uffff\u0001\u0001\u0005\uffff\u0001\u0002M\uffff";
    static final short[] DFA11_eof = null;
    static final String DFA11_eofS = "X\uffff";
    static final short[] DFA11_eot = null;
    static final String DFA11_eotS = "X\uffff";
    static final char[] DFA11_max = null;
    static final String DFA11_maxS = "\u0001d\u0002\u0002\u0001d\u0001\uffff\u0002\u001c\u0003d\u0001\uffff\u0002d\u0002R\u0002\u0003\u0002\u0002\u0002d\u0002\u001c\u0003d\u0001\u001c\u0001\u0002\u0001\u0003\u0001\u001c\u0001\u0002\u0001\u0003\u0002R\u0001\u001c\u0001d\u0001\u001c\u0001d\u0002\u0002\u0002>\u0002\u001c\b\u0003\u0001\u001c\u0001\u0002\u0001\u0003\u0001\u001c\u0001\u0002\u0001\u0003\t\u001c\u0001d\u0001\u001c\u0001d\u0002>\b\u0003\b\u001c";
    static final char[] DFA11_min = null;
    static final String DFA11_minS = "\u0001\u0004\u0003\u0002\u0001\uffff\u0002\u001c\u0002\u0002\u0001\u0003\u0001\uffff\u0002\u0004\u0002R\u0004\u0002\u0004\u0003\u0002\u0002\u0002\u0003\u0001\u0002\u0002\u0003\u0001\u0002\u0001\u0003\u0002R\u0001\u001c\u0001\u0003\u0001\u001c\u0001\u0003\u0002\u0002\u0002\u0004\u000b\u0003\u0001\u0002\u0002\u0003\u0001\u0002\t\u0003\u0001\u001c\u0001\u0003\u0001\u001c\u0001\u0003\u0002\u0004\u0010\u0003";
    static final short[] DFA11_special = null;
    static final String DFA11_specialS = "X\uffff}>";
    static final short[][] DFA11_transition = null;
    static final String[] DFA11_transitionS = null;
    static final short[] DFA14_accept = null;
    static final String DFA14_acceptS = "\u0004\uffff\u0001\u0001\u0005\uffff\u0001\u0002M\uffff";
    static final short[] DFA14_eof = null;
    static final String DFA14_eofS = "X\uffff";
    static final short[] DFA14_eot = null;
    static final String DFA14_eotS = "X\uffff";
    static final char[] DFA14_max = null;
    static final String DFA14_maxS = "\u0001d\u0002\u0002\u0001d\u0001\uffff\u0002\u001c\u0003d\u0001\uffff\u0002d\u0002R\u0002\u0003\u0002\u0002\u0002d\u0002\u001c\u0003d\u0001\u001c\u0001\u0002\u0001\u0003\u0001\u001c\u0001\u0002\u0001\u0003\u0002R\u0001\u001c\u0001d\u0001\u001c\u0001d\u0002\u0002\u0002>\u0002\u001c\b\u0003\u0001\u001c\u0001\u0002\u0001\u0003\u0001\u001c\u0001\u0002\u0001\u0003\t\u001c\u0001d\u0001\u001c\u0001d\u0002>\b\u0003\b\u001c";
    static final char[] DFA14_min = null;
    static final String DFA14_minS = "\u0001\u0004\u0003\u0002\u0001\uffff\u0002\u001c\u0002\u0002\u0001\u0003\u0001\uffff\u0002\u0004\u0002R\u0004\u0002\u0004\u0003\u0002\u0002\u0002\u0003\u0001\u0002\u0002\u0003\u0001\u0002\u0001\u0003\u0002R\u0001\u001c\u0001\u0003\u0001\u001c\u0001\u0003\u0002\u0002\u0002\u0004\u000b\u0003\u0001\u0002\u0002\u0003\u0001\u0002\t\u0003\u0001\u001c\u0001\u0003\u0001\u001c\u0001\u0003\u0002\u0004\u0010\u0003";
    static final short[] DFA14_special = null;
    static final String DFA14_specialS = "X\uffff}>";
    static final short[][] DFA14_transition = null;
    static final String[] DFA14_transitionS = null;
    public static final int DOC_COMMENT = 18;
    public static final int DOLLAR = 19;
    public static final int DOT = 20;
    public static final int ELEMENT_OPTIONS = 82;
    public static final int EOF = -1;
    public static final int EPSILON = 83;
    public static final int ERRCHAR = 21;
    public static final int ESC_SEQ = 22;
    public static final int FINALLY = 23;
    public static final BitSet FOLLOW_ACTION_in_block1179 = null;
    public static final BitSet FOLLOW_ACTION_in_elementOption921 = null;
    public static final BitSet FOLLOW_ACTION_in_epsilonElement1038 = null;
    public static final BitSet FOLLOW_ACTION_in_epsilonElement1054 = null;
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler220 = null;
    public static final BitSet FOLLOW_ACTION_in_finallyClause235 = null;
    public static final BitSet FOLLOW_ACTION_in_rec_rule156 = null;
    public static final BitSet FOLLOW_ALT_in_alternative1199 = null;
    public static final BitSet FOLLOW_ALT_in_binary541 = null;
    public static final BitSet FOLLOW_ALT_in_nonLeftRecur671 = null;
    public static final BitSet FOLLOW_ALT_in_prefix579 = null;
    public static final BitSet FOLLOW_ALT_in_suffix630 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1223 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler218 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_rec_rule117 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_rec_rule96 = null;
    public static final BitSet FOLLOW_ASSIGN_in_element978 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption885 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption901 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption917 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption933 = null;
    public static final BitSet FOLLOW_ASSIGN_in_recurse693 = null;
    public static final BitSet FOLLOW_ASSIGN_in_token740 = null;
    public static final BitSet FOLLOW_AT_in_rec_rule152 = null;
    public static final BitSet FOLLOW_BLOCK_in_block1177 = null;
    public static final BitSet FOLLOW_BLOCK_in_ruleBlock290 = null;
    public static final BitSet FOLLOW_CATCH_in_exceptionHandler216 = null;
    public static final BitSet FOLLOW_CLOSURE_in_ebnf1139 = null;
    public static final BitSet FOLLOW_DOT_in_atom1286 = null;
    public static final BitSet FOLLOW_ELEMENT_OPTIONS_in_elementOptions853 = null;
    public static final BitSet FOLLOW_EPSILON_in_epsilonElement1048 = null;
    public static final BitSet FOLLOW_FINALLY_in_finallyClause233 = null;
    public static final BitSet FOLLOW_ID_in_atom1288 = null;
    public static final BitSet FOLLOW_ID_in_element980 = null;
    public static final BitSet FOLLOW_ID_in_element991 = null;
    public static final BitSet FOLLOW_ID_in_elementOption874 = null;
    public static final BitSet FOLLOW_ID_in_elementOption887 = null;
    public static final BitSet FOLLOW_ID_in_elementOption889 = null;
    public static final BitSet FOLLOW_ID_in_elementOption903 = null;
    public static final BitSet FOLLOW_ID_in_elementOption919 = null;
    public static final BitSet FOLLOW_ID_in_elementOption935 = null;
    public static final BitSet FOLLOW_ID_in_rec_rule154 = null;
    public static final BitSet FOLLOW_ID_in_recurse695 = null;
    public static final BitSet FOLLOW_ID_in_recurse706 = null;
    public static final BitSet FOLLOW_ID_in_token742 = null;
    public static final BitSet FOLLOW_ID_in_token757 = null;
    public static final BitSet FOLLOW_INT_in_elementOption937 = null;
    public static final BitSet FOLLOW_LOCALS_in_rec_rule115 = null;
    public static final BitSet FOLLOW_NOT_in_element958 = null;
    public static final BitSet FOLLOW_OPTIONAL_in_ebnf1123 = null;
    public static final BitSet FOLLOW_OPTIONS_in_rec_rule135 = null;
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_element989 = null;
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_recurse704 = null;
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_token755 = null;
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf1155 = null;
    public static final BitSet FOLLOW_RANGE_in_element967 = null;
    public static final BitSet FOLLOW_RETURNS_in_rec_rule92 = null;
    public static final BitSet FOLLOW_RULE_REF_in_atom1221 = null;
    public static final BitSet FOLLOW_RULE_REF_in_element1017 = null;
    public static final BitSet FOLLOW_RULE_REF_in_rec_rule76 = null;
    public static final BitSet FOLLOW_RULE_REF_in_recurseNoLabel726 = null;
    public static final BitSet FOLLOW_RULE_in_rec_rule72 = null;
    public static final BitSet FOLLOW_SEMPRED_in_epsilonElement1043 = null;
    public static final BitSet FOLLOW_SEMPRED_in_epsilonElement1063 = null;
    public static final BitSet FOLLOW_SET_in_element1003 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom1238 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom1246 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_elementOption905 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement1078 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement1095 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_token771 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_token792 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_atom1255 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_atom1263 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement1087 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement1100 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_token809 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_token823 = null;
    public static final BitSet FOLLOW_WILDCARD_in_atom1272 = null;
    public static final BitSet FOLLOW_WILDCARD_in_atom1280 = null;
    public static final BitSet FOLLOW_alternative_in_block1182 = null;
    public static final BitSet FOLLOW_atom_in_element952 = null;
    public static final BitSet FOLLOW_atom_in_element969 = null;
    public static final BitSet FOLLOW_atom_in_element971 = null;
    public static final BitSet FOLLOW_binary_in_outerAlternative362 = null;
    public static final BitSet FOLLOW_binary_in_synpred1_LeftRecursiveRuleWalker348 = null;
    public static final BitSet FOLLOW_block_in_ebnf1111 = null;
    public static final BitSet FOLLOW_block_in_ebnf1125 = null;
    public static final BitSet FOLLOW_block_in_ebnf1141 = null;
    public static final BitSet FOLLOW_block_in_ebnf1157 = null;
    public static final BitSet FOLLOW_ebnf_in_element1022 = null;
    public static final BitSet FOLLOW_elementOption_in_elementOptions855 = null;
    public static final BitSet FOLLOW_elementOptions_in_alternative1201 = null;
    public static final BitSet FOLLOW_elementOptions_in_atom1226 = null;
    public static final BitSet FOLLOW_elementOptions_in_atom1240 = null;
    public static final BitSet FOLLOW_elementOptions_in_atom1257 = null;
    public static final BitSet FOLLOW_elementOptions_in_atom1274 = null;
    public static final BitSet FOLLOW_elementOptions_in_binary543 = null;
    public static final BitSet FOLLOW_elementOptions_in_epsilonElement1056 = null;
    public static final BitSet FOLLOW_elementOptions_in_epsilonElement1065 = null;
    public static final BitSet FOLLOW_elementOptions_in_nonLeftRecur673 = null;
    public static final BitSet FOLLOW_elementOptions_in_prefix581 = null;
    public static final BitSet FOLLOW_elementOptions_in_setElement1080 = null;
    public static final BitSet FOLLOW_elementOptions_in_setElement1089 = null;
    public static final BitSet FOLLOW_elementOptions_in_suffix632 = null;
    public static final BitSet FOLLOW_elementOptions_in_token794 = null;
    public static final BitSet FOLLOW_elementOptions_in_token811 = null;
    public static final BitSet FOLLOW_element_in_alternative1204 = null;
    public static final BitSet FOLLOW_element_in_atom1290 = null;
    public static final BitSet FOLLOW_element_in_binary548 = null;
    public static final BitSet FOLLOW_element_in_element960 = null;
    public static final BitSet FOLLOW_element_in_element982 = null;
    public static final BitSet FOLLOW_element_in_element993 = null;
    public static final BitSet FOLLOW_element_in_nonLeftRecur676 = null;
    public static final BitSet FOLLOW_element_in_prefix587 = null;
    public static final BitSet FOLLOW_element_in_suffix637 = null;
    public static final BitSet FOLLOW_epsilonElement_in_binary553 = null;
    public static final BitSet FOLLOW_epsilonElement_in_element1027 = null;
    public static final BitSet FOLLOW_epsilonElement_in_prefix595 = null;
    public static final BitSet FOLLOW_exceptionGroup_in_rec_rule179 = null;
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup197 = null;
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup200 = null;
    public static final BitSet FOLLOW_nonLeftRecur_in_outerAlternative515 = null;
    public static final BitSet FOLLOW_outerAlternative_in_ruleBlock303 = null;
    public static final BitSet FOLLOW_prefix_in_outerAlternative418 = null;
    public static final BitSet FOLLOW_prefix_in_synpred2_LeftRecursiveRuleWalker404 = null;
    public static final BitSet FOLLOW_recurseNoLabel_in_recurse697 = null;
    public static final BitSet FOLLOW_recurseNoLabel_in_recurse708 = null;
    public static final BitSet FOLLOW_recurseNoLabel_in_recurse714 = null;
    public static final BitSet FOLLOW_recurse_in_binary546 = null;
    public static final BitSet FOLLOW_recurse_in_binary551 = null;
    public static final BitSet FOLLOW_recurse_in_prefix593 = null;
    public static final BitSet FOLLOW_recurse_in_suffix635 = null;
    public static final BitSet FOLLOW_ruleBlock_in_rec_rule172 = null;
    public static final BitSet FOLLOW_ruleModifier_in_rec_rule83 = null;
    public static final BitSet FOLLOW_setElement_in_element1005 = null;
    public static final BitSet FOLLOW_suffix_in_outerAlternative474 = null;
    public static final BitSet FOLLOW_suffix_in_synpred3_LeftRecursiveRuleWalker460 = null;
    public static final BitSet FOLLOW_token_in_token746 = null;
    public static final BitSet FOLLOW_token_in_token761 = null;
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
    private int currentOuterAltNumber;
    protected DFA11 dfa11;
    protected DFA14 dfa14;
    public int numAlts;
    private String ruleName;

    public class DFA11 extends DFA {
        final /* synthetic */ LeftRecursiveRuleWalker this$0;

        public DFA11(LeftRecursiveRuleWalker r5, BaseRecognizer r10) {
            this.this$0 = r5;
            this.recognizer = r10;
            this.decisionNumber = 11;
            this.eot = LeftRecursiveRuleWalker.DFA11_eot;
            this.eof = LeftRecursiveRuleWalker.DFA11_eof;
            this.min = LeftRecursiveRuleWalker.DFA11_min;
            this.max = LeftRecursiveRuleWalker.DFA11_max;
            this.accept = LeftRecursiveRuleWalker.DFA11_accept;
            this.special = LeftRecursiveRuleWalker.DFA11_special;
            this.transition = LeftRecursiveRuleWalker.DFA11_transition;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.DFA
        public String getDescription() {
            return "()* loopback of 124:35: ( element )*";
        }
    }

    public class DFA14 extends DFA {
        final /* synthetic */ LeftRecursiveRuleWalker this$0;

        public DFA14(LeftRecursiveRuleWalker r5, BaseRecognizer r10) {
            this.this$0 = r5;
            this.recognizer = r10;
            this.decisionNumber = 14;
            this.eot = LeftRecursiveRuleWalker.DFA14_eot;
            this.eof = LeftRecursiveRuleWalker.DFA14_eof;
            this.min = LeftRecursiveRuleWalker.DFA14_min;
            this.max = LeftRecursiveRuleWalker.DFA14_max;
            this.accept = LeftRecursiveRuleWalker.DFA14_accept;
            this.special = LeftRecursiveRuleWalker.DFA14_special;
            this.transition = LeftRecursiveRuleWalker.DFA14_transition;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.DFA
        public String getDescription() {
            return "()+ loopback of 130:4: ( element )+";
        }
    }

    public static class outerAlternative_return extends TreeRuleReturnScope {
        public boolean isLeftRec;

        public outerAlternative_return() {
        }
    }

    public static class ruleBlock_return extends TreeRuleReturnScope {
        public boolean isLeftRec;

        public ruleBlock_return() {
        }
    }

    static {
        tokenNames = new String[]{Grammar.INVALID_RULE_NAME, "<EOR>", "<DOWN>", "<UP>", "ACTION", "ACTION_CHAR_LITERAL", "ACTION_ESC", "ACTION_STRING_LITERAL", "ARG_ACTION", "ARG_OR_CHARSET", "ASSIGN", "AT", "CATCH", "CHANNELS", "COLON", "COLONCOLON", "COMMA", "COMMENT", "DOC_COMMENT", "DOLLAR", "DOT", "ERRCHAR", "ESC_SEQ", "FINALLY", "FRAGMENT", "GRAMMAR", "GT", "HEX_DIGIT", "ID", "IMPORT", "INT", "LEXER", "LEXER_CHAR_SET", "LOCALS", "LPAREN", "LT", "MODE", "NESTED_ACTION", "NLCHARS", "NOT", "NameChar", "NameStartChar", "OPTIONS", "OR", "PARSER", "PLUS", "PLUS_ASSIGN", "POUND", "PRIVATE", "PROTECTED", "PUBLIC", "QUESTION", "RANGE", "RARROW", "RBRACE", "RETURNS", "RPAREN", "RULE_REF", "SEMI", "SEMPRED", "SRC", "STAR", "STRING_LITERAL", "SYNPRED", "THROWS", "TOKENS_SPEC", "TOKEN_REF", "TREE_GRAMMAR", "UNICODE_ESC", "UNICODE_EXTENDED_ESC", "UnicodeBOM", "WS", "WSCHARS", "WSNLCHARS", "ALT", "ALTLIST", "ARG", "ARGLIST", "BLOCK", "CHAR_RANGE", "CLOSURE", "COMBINED", "ELEMENT_OPTIONS", "EPSILON", "INITACTION", "LABEL", "LEXER_ACTION_CALL", "LEXER_ALT_ACTION", "LIST", "OPTIONAL", "POSITIVE_CLOSURE", "PREC_RULE", "RESULT", "RET", "RULE", "RULEACTIONS", "RULEMODIFIERS", "RULES", "SET", "TEMPLATE", "WILDCARD"};
        String[] r5 = {"\u0001\u0004\u0005\uffff\u0001\u0001\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0002\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0003\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u0005", "\u0001\u0006", "\u0001\u0004\u0001\n\u0001\u0007\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\b\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\t\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "", "\u0001\u000b", "\u0001\f", "\u0001\r\u0001\n\u0001\u0007\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\b\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\t\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u000e\u0001\n\u0001\u0007\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\b\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\t\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\n\u0001\u0007\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\b\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\t\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "", "\u0001\u0004\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u000f\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u0004\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0010\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u0011", "\u0001\u0012", "\u0001\u0004\u0001\u0013", "\u0001\u0004\u0001\u0014", "\u0001\u0015", "\u0001\u0016", "\u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u001c\u0006\uffff\u0001\u001b\u0011\uffff\u0001\u001a", "\u0001\u001f\u0006\uffff\u0001\u001e\u0011\uffff\u0001\u001d", "\u0001 \u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001!\u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u001c\u0006\uffff\u0001\u001b\u0011\uffff\u0001\u001a", "\u0001\"", "\u0001#", "\u0001\u001f\u0006\uffff\u0001\u001e\u0011\uffff\u0001\u001d", "\u0001$", "\u0001%", "\u0001&", "\u0001'", "\u0001(", "\u0001\n\u0001\u0007\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\b\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\t\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001)", "\u0001\n\u0001\u0007\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\b\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\t\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001*", "\u0001+", "\u0001.\u0017\uffff\u0001,\u0001\uffff\u0001/\u001f\uffff\u0001-", "\u00012\u0017\uffff\u00010\u0001\uffff\u00013\u001f\uffff\u00011", "\u00016\u0006\uffff\u00015\u0011\uffff\u00014", "\u00019\u0006\uffff\u00018\u0011\uffff\u00017", "\u0001:", "\u0001;", "\u0001<", "\u0001=", "\u0001>", "\u0001?", "\u0001@", "\u0001A", "\u00016\u0006\uffff\u00015\u0011\uffff\u00014", "\u0001B", "\u0001C", "\u00019\u0006\uffff\u00018\u0011\uffff\u00017", "\u0001D", "\u0001E", "\u0001\u001c\u0006\uffff\u0001\u001b\u0011\uffff\u0001\u001a", "\u0001\u001c\u0006\uffff\u0001\u001b\u0011\uffff\u0001\u001a", "\u0001\u001c\u0006\uffff\u0001\u001b\u0011\uffff\u0001\u001a", "\u0001\u001c\u0006\uffff\u0001\u001b\u0011\uffff\u0001\u001a", "\u0001\u001f\u0006\uffff\u0001\u001e\u0011\uffff\u0001\u001d", "\u0001\u001f\u0006\uffff\u0001\u001e\u0011\uffff\u0001\u001d", "\u0001\u001f\u0006\uffff\u0001\u001e\u0011\uffff\u0001\u001d", "\u0001\u001f\u0006\uffff\u0001\u001e\u0011\uffff\u0001\u001d", "\u0001F", "\u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001G", "\u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001J\u0017\uffff\u0001H\u0001\uffff\u0001K\u001f\uffff\u0001I", "\u0001N\u0017\uffff\u0001L\u0001\uffff\u0001O\u001f\uffff\u0001M", "\u0001P", "\u0001Q", "\u0001R", "\u0001S", "\u0001T", "\u0001U", "\u0001V", "\u0001W", "\u00016\u0006\uffff\u00015\u0011\uffff\u00014", "\u00016\u0006\uffff\u00015\u0011\uffff\u00014", "\u00016\u0006\uffff\u00015\u0011\uffff\u00014", "\u00016\u0006\uffff\u00015\u0011\uffff\u00014", "\u00019\u0006\uffff\u00018\u0011\uffff\u00017", "\u00019\u0006\uffff\u00018\u0011\uffff\u00017", "\u00019\u0006\uffff\u00018\u0011\uffff\u00017", "\u00019\u0006\uffff\u00018\u0011\uffff\u00017"};
        DFA11_transitionS = r5;
        DFA11_eot = DFA.unpackEncodedString("X\uffff");
        DFA11_eof = DFA.unpackEncodedString("X\uffff");
        DFA11_min = DFA.unpackEncodedStringToUnsignedChars("\u0001\u0004\u0003\u0002\u0001\uffff\u0002\u001c\u0002\u0002\u0001\u0003\u0001\uffff\u0002\u0004\u0002R\u0004\u0002\u0004\u0003\u0002\u0002\u0002\u0003\u0001\u0002\u0002\u0003\u0001\u0002\u0001\u0003\u0002R\u0001\u001c\u0001\u0003\u0001\u001c\u0001\u0003\u0002\u0002\u0002\u0004\u000b\u0003\u0001\u0002\u0002\u0003\u0001\u0002\t\u0003\u0001\u001c\u0001\u0003\u0001\u001c\u0001\u0003\u0002\u0004\u0010\u0003");
        DFA11_max = DFA.unpackEncodedStringToUnsignedChars("\u0001d\u0002\u0002\u0001d\u0001\uffff\u0002\u001c\u0003d\u0001\uffff\u0002d\u0002R\u0002\u0003\u0002\u0002\u0002d\u0002\u001c\u0003d\u0001\u001c\u0001\u0002\u0001\u0003\u0001\u001c\u0001\u0002\u0001\u0003\u0002R\u0001\u001c\u0001d\u0001\u001c\u0001d\u0002\u0002\u0002>\u0002\u001c\b\u0003\u0001\u001c\u0001\u0002\u0001\u0003\u0001\u001c\u0001\u0002\u0001\u0003\t\u001c\u0001d\u0001\u001c\u0001d\u0002>\b\u0003\b\u001c");
        DFA11_accept = DFA.unpackEncodedString("\u0004\uffff\u0001\u0001\u0005\uffff\u0001\u0002M\uffff");
        DFA11_special = DFA.unpackEncodedString("X\uffff}>");
        int r10 = r5.length;
        DFA11_transition = new short[r10][];
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        DFA11_transition[r11] = DFA.unpackEncodedString(DFA11_transitionS[r11]);
        r11 = r11 + 1;
        goto L3
    L5:
        String[] r12 = {"\u0001\u0004\u0005\uffff\u0001\u0001\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0002\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0003\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u0005", "\u0001\u0006", "\u0001\u0004\u0001\n\u0001\u0007\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\b\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\t\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "", "\u0001\u000b", "\u0001\f", "\u0001\r\u0001\n\u0001\u0007\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\b\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\t\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u000e\u0001\n\u0001\u0007\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\b\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\t\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\n\u0001\u0007\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\b\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\t\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "", "\u0001\u0004\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u000f\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u0004\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0010\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u0011", "\u0001\u0012", "\u0001\u0004\u0001\u0013", "\u0001\u0004\u0001\u0014", "\u0001\u0015", "\u0001\u0016", "\u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u001c\u0006\uffff\u0001\u001b\u0011\uffff\u0001\u001a", "\u0001\u001f\u0006\uffff\u0001\u001e\u0011\uffff\u0001\u001d", "\u0001 \u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001!\u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u001c\u0006\uffff\u0001\u001b\u0011\uffff\u0001\u001a", "\u0001\"", "\u0001#", "\u0001\u001f\u0006\uffff\u0001\u001e\u0011\uffff\u0001\u001d", "\u0001$", "\u0001%", "\u0001&", "\u0001'", "\u0001(", "\u0001\n\u0001\u0007\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\b\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\t\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001)", "\u0001\n\u0001\u0007\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\b\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\t\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001*", "\u0001+", "\u0001.\u0017\uffff\u0001,\u0001\uffff\u0001/\u001f\uffff\u0001-", "\u00012\u0017\uffff\u00010\u0001\uffff\u00013\u001f\uffff\u00011", "\u00016\u0006\uffff\u00015\u0011\uffff\u00014", "\u00019\u0006\uffff\u00018\u0011\uffff\u00017", "\u0001:", "\u0001;", "\u0001<", "\u0001=", "\u0001>", "\u0001?", "\u0001@", "\u0001A", "\u00016\u0006\uffff\u00015\u0011\uffff\u00014", "\u0001B", "\u0001C", "\u00019\u0006\uffff\u00018\u0011\uffff\u00017", "\u0001D", "\u0001E", "\u0001\u001c\u0006\uffff\u0001\u001b\u0011\uffff\u0001\u001a", "\u0001\u001c\u0006\uffff\u0001\u001b\u0011\uffff\u0001\u001a", "\u0001\u001c\u0006\uffff\u0001\u001b\u0011\uffff\u0001\u001a", "\u0001\u001c\u0006\uffff\u0001\u001b\u0011\uffff\u0001\u001a", "\u0001\u001f\u0006\uffff\u0001\u001e\u0011\uffff\u0001\u001d", "\u0001\u001f\u0006\uffff\u0001\u001e\u0011\uffff\u0001\u001d", "\u0001\u001f\u0006\uffff\u0001\u001e\u0011\uffff\u0001\u001d", "\u0001\u001f\u0006\uffff\u0001\u001e\u0011\uffff\u0001\u001d", "\u0001F", "\u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001G", "\u0001\n\u0001\u0017\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0018\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0019\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001J\u0017\uffff\u0001H\u0001\uffff\u0001K\u001f\uffff\u0001I", "\u0001N\u0017\uffff\u0001L\u0001\uffff\u0001O\u001f\uffff\u0001M", "\u0001P", "\u0001Q", "\u0001R", "\u0001S", "\u0001T", "\u0001U", "\u0001V", "\u0001W", "\u00016\u0006\uffff\u00015\u0011\uffff\u00014", "\u00016\u0006\uffff\u00015\u0011\uffff\u00014", "\u00016\u0006\uffff\u00015\u0011\uffff\u00014", "\u00016\u0006\uffff\u00015\u0011\uffff\u00014", "\u00019\u0006\uffff\u00018\u0011\uffff\u00017", "\u00019\u0006\uffff\u00018\u0011\uffff\u00017", "\u00019\u0006\uffff\u00018\u0011\uffff\u00017", "\u00019\u0006\uffff\u00018\u0011\uffff\u00017"};
        DFA14_transitionS = r12;
        DFA14_eot = DFA.unpackEncodedString("X\uffff");
        DFA14_eof = DFA.unpackEncodedString("X\uffff");
        DFA14_min = DFA.unpackEncodedStringToUnsignedChars("\u0001\u0004\u0003\u0002\u0001\uffff\u0002\u001c\u0002\u0002\u0001\u0003\u0001\uffff\u0002\u0004\u0002R\u0004\u0002\u0004\u0003\u0002\u0002\u0002\u0003\u0001\u0002\u0002\u0003\u0001\u0002\u0001\u0003\u0002R\u0001\u001c\u0001\u0003\u0001\u001c\u0001\u0003\u0002\u0002\u0002\u0004\u000b\u0003\u0001\u0002\u0002\u0003\u0001\u0002\t\u0003\u0001\u001c\u0001\u0003\u0001\u001c\u0001\u0003\u0002\u0004\u0010\u0003");
        DFA14_max = DFA.unpackEncodedStringToUnsignedChars("\u0001d\u0002\u0002\u0001d\u0001\uffff\u0002\u001c\u0003d\u0001\uffff\u0002d\u0002R\u0002\u0003\u0002\u0002\u0002d\u0002\u001c\u0003d\u0001\u001c\u0001\u0002\u0001\u0003\u0001\u001c\u0001\u0002\u0001\u0003\u0002R\u0001\u001c\u0001d\u0001\u001c\u0001d\u0002\u0002\u0002>\u0002\u001c\b\u0003\u0001\u001c\u0001\u0002\u0001\u0003\u0001\u001c\u0001\u0002\u0001\u0003\t\u001c\u0001d\u0001\u001c\u0001d\u0002>\b\u0003\b\u001c");
        DFA14_accept = DFA.unpackEncodedString("\u0004\uffff\u0001\u0001\u0005\uffff\u0001\u0002M\uffff");
        DFA14_special = DFA.unpackEncodedString("X\uffff}>");
        int r13 = r12.length;
        DFA14_transition = new short[r13][];
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L8;
        DFA14_transition[r14] = DFA.unpackEncodedString(DFA14_transitionS[r14]);
        r14 = r14 + 1;
        goto L6
    L8:
        FOLLOW_RULE_in_rec_rule72 = new BitSet(new long[]{4});
        FOLLOW_RULE_REF_in_rec_rule76 = new BitSet(new long[]{38003528492386304L, Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_ruleModifier_in_rec_rule83 = new BitSet(new long[]{36033203655411712L, Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_RETURNS_in_rec_rule92 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_rec_rule96 = new BitSet(new long[]{8});
        FOLLOW_LOCALS_in_rec_rule115 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_rec_rule117 = new BitSet(new long[]{8});
        FOLLOW_OPTIONS_in_rec_rule135 = new BitSet(new long[]{4});
        FOLLOW_AT_in_rec_rule152 = new BitSet(new long[]{4});
        FOLLOW_ID_in_rec_rule154 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_rec_rule156 = new BitSet(new long[]{8});
        FOLLOW_ruleBlock_in_rec_rule172 = new BitSet(new long[]{8392712});
        FOLLOW_exceptionGroup_in_rec_rule179 = new BitSet(new long[]{8});
        FOLLOW_exceptionHandler_in_exceptionGroup197 = new BitSet(new long[]{8392706});
        FOLLOW_finallyClause_in_exceptionGroup200 = new BitSet(new long[]{2});
        FOLLOW_CATCH_in_exceptionHandler216 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_exceptionHandler218 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_exceptionHandler220 = new BitSet(new long[]{8});
        FOLLOW_FINALLY_in_finallyClause233 = new BitSet(new long[]{4});
        FOLLOW_ACTION_in_finallyClause235 = new BitSet(new long[]{8});
        FOLLOW_BLOCK_in_ruleBlock290 = new BitSet(new long[]{4});
        FOLLOW_outerAlternative_in_ruleBlock303 = new BitSet(new long[]{8, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_binary_in_outerAlternative362 = new BitSet(new long[]{2});
        FOLLOW_prefix_in_outerAlternative418 = new BitSet(new long[]{2});
        FOLLOW_suffix_in_outerAlternative474 = new BitSet(new long[]{2});
        FOLLOW_nonLeftRecur_in_outerAlternative515 = new BitSet(new long[]{2});
        FOLLOW_ALT_in_binary541 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_binary543 = new BitSet(new long[]{144185556820034560L});
        FOLLOW_recurse_in_binary546 = new BitSet(new long[]{5336836476935078928L, 86000615428L});
        FOLLOW_element_in_binary548 = new BitSet(new long[]{5336836476935078928L, 86000615428L});
        FOLLOW_recurse_in_binary551 = new BitSet(new long[]{576460752303423512L, 524288});
        FOLLOW_epsilonElement_in_binary553 = new BitSet(new long[]{576460752303423512L, 524288});
        FOLLOW_ALT_in_prefix579 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_prefix581 = new BitSet(new long[]{5336836476935078928L, 86000615428L});
        FOLLOW_element_in_prefix587 = new BitSet(new long[]{5336836476935078928L, 86000615428L});
        FOLLOW_recurse_in_prefix593 = new BitSet(new long[]{576460752303423512L, 524288});
        FOLLOW_epsilonElement_in_prefix595 = new BitSet(new long[]{576460752303423512L, 524288});
        FOLLOW_ALT_in_suffix630 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_suffix632 = new BitSet(new long[]{144185556820034560L});
        FOLLOW_recurse_in_suffix635 = new BitSet(new long[]{5336836476935078928L, 86000615428L});
        FOLLOW_element_in_suffix637 = new BitSet(new long[]{5336836476935078936L, 86000615428L});
        FOLLOW_ALT_in_nonLeftRecur671 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_nonLeftRecur673 = new BitSet(new long[]{5336836476935078928L, 86000615428L});
        FOLLOW_element_in_nonLeftRecur676 = new BitSet(new long[]{5336836476935078936L, 86000615428L});
        FOLLOW_ASSIGN_in_recurse693 = new BitSet(new long[]{4});
        FOLLOW_ID_in_recurse695 = new BitSet(new long[]{144115188075855872L});
        FOLLOW_recurseNoLabel_in_recurse697 = new BitSet(new long[]{8});
        FOLLOW_PLUS_ASSIGN_in_recurse704 = new BitSet(new long[]{4});
        FOLLOW_ID_in_recurse706 = new BitSet(new long[]{144115188075855872L});
        FOLLOW_recurseNoLabel_in_recurse708 = new BitSet(new long[]{8});
        FOLLOW_recurseNoLabel_in_recurse714 = new BitSet(new long[]{2});
        FOLLOW_RULE_REF_in_recurseNoLabel726 = new BitSet(new long[]{2});
        FOLLOW_ASSIGN_in_token740 = new BitSet(new long[]{4});
        FOLLOW_ID_in_token742 = new BitSet(new long[]{4611756387171566592L, 4});
        FOLLOW_token_in_token746 = new BitSet(new long[]{8});
        FOLLOW_PLUS_ASSIGN_in_token755 = new BitSet(new long[]{4});
        FOLLOW_ID_in_token757 = new BitSet(new long[]{4611756387171566592L, 4});
        FOLLOW_token_in_token761 = new BitSet(new long[]{8});
        FOLLOW_STRING_LITERAL_in_token771 = new BitSet(new long[]{2});
        FOLLOW_STRING_LITERAL_in_token792 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_token794 = new BitSet(new long[]{8});
        FOLLOW_TOKEN_REF_in_token809 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_token811 = new BitSet(new long[]{8});
        FOLLOW_TOKEN_REF_in_token823 = new BitSet(new long[]{2});
        FOLLOW_ELEMENT_OPTIONS_in_elementOptions853 = new BitSet(new long[]{4});
        FOLLOW_elementOption_in_elementOptions855 = new BitSet(new long[]{268436488});
        FOLLOW_ID_in_elementOption874 = new BitSet(new long[]{2});
        FOLLOW_ASSIGN_in_elementOption885 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption887 = new BitSet(new long[]{268435456});
        FOLLOW_ID_in_elementOption889 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption901 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption903 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_elementOption905 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption917 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption919 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_elementOption921 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption933 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption935 = new BitSet(new long[]{1073741824});
        FOLLOW_INT_in_elementOption937 = new BitSet(new long[]{8});
        FOLLOW_atom_in_element952 = new BitSet(new long[]{2});
        FOLLOW_NOT_in_element958 = new BitSet(new long[]{4});
        FOLLOW_element_in_element960 = new BitSet(new long[]{8});
        FOLLOW_RANGE_in_element967 = new BitSet(new long[]{4});
        FOLLOW_atom_in_element969 = new BitSet(new long[]{4755801206504292352L, 68719476740L});
        FOLLOW_atom_in_element971 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_element978 = new BitSet(new long[]{4});
        FOLLOW_ID_in_element980 = new BitSet(new long[]{5336836476935078928L, 86000615428L});
        FOLLOW_element_in_element982 = new BitSet(new long[]{8});
        FOLLOW_PLUS_ASSIGN_in_element989 = new BitSet(new long[]{4});
        FOLLOW_ID_in_element991 = new BitSet(new long[]{5336836476935078928L, 86000615428L});
        FOLLOW_element_in_element993 = new BitSet(new long[]{8});
        FOLLOW_SET_in_element1003 = new BitSet(new long[]{4});
        FOLLOW_setElement_in_element1005 = new BitSet(new long[]{4611686018427387912L, 4});
        FOLLOW_RULE_REF_in_element1017 = new BitSet(new long[]{2});
        FOLLOW_ebnf_in_element1022 = new BitSet(new long[]{2});
        FOLLOW_epsilonElement_in_element1027 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_epsilonElement1038 = new BitSet(new long[]{2});
        FOLLOW_SEMPRED_in_epsilonElement1043 = new BitSet(new long[]{2});
        FOLLOW_EPSILON_in_epsilonElement1048 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_epsilonElement1054 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_epsilonElement1056 = new BitSet(new long[]{8});
        FOLLOW_SEMPRED_in_epsilonElement1063 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_epsilonElement1065 = new BitSet(new long[]{8});
        FOLLOW_STRING_LITERAL_in_setElement1078 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_setElement1080 = new BitSet(new long[]{8});
        FOLLOW_TOKEN_REF_in_setElement1087 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_setElement1089 = new BitSet(new long[]{8});
        FOLLOW_STRING_LITERAL_in_setElement1095 = new BitSet(new long[]{2});
        FOLLOW_TOKEN_REF_in_setElement1100 = new BitSet(new long[]{2});
        FOLLOW_block_in_ebnf1111 = new BitSet(new long[]{2});
        FOLLOW_OPTIONAL_in_ebnf1123 = new BitSet(new long[]{4});
        FOLLOW_block_in_ebnf1125 = new BitSet(new long[]{8});
        FOLLOW_CLOSURE_in_ebnf1139 = new BitSet(new long[]{4});
        FOLLOW_block_in_ebnf1141 = new BitSet(new long[]{8});
        FOLLOW_POSITIVE_CLOSURE_in_ebnf1155 = new BitSet(new long[]{4});
        FOLLOW_block_in_ebnf1157 = new BitSet(new long[]{8});
        FOLLOW_BLOCK_in_block1177 = new BitSet(new long[]{4});
        FOLLOW_ACTION_in_block1179 = new BitSet(new long[]{0, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_alternative_in_block1182 = new BitSet(new long[]{8, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_ALT_in_alternative1199 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_alternative1201 = new BitSet(new long[]{5336836476935078928L, 86000615428L});
        FOLLOW_element_in_alternative1204 = new BitSet(new long[]{5336836476935078936L, 86000615428L});
        FOLLOW_RULE_REF_in_atom1221 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_atom1223 = new BitSet(new long[]{8, 262144});
        FOLLOW_elementOptions_in_atom1226 = new BitSet(new long[]{8});
        FOLLOW_STRING_LITERAL_in_atom1238 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_atom1240 = new BitSet(new long[]{8});
        FOLLOW_STRING_LITERAL_in_atom1246 = new BitSet(new long[]{2});
        FOLLOW_TOKEN_REF_in_atom1255 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_atom1257 = new BitSet(new long[]{8});
        FOLLOW_TOKEN_REF_in_atom1263 = new BitSet(new long[]{2});
        FOLLOW_WILDCARD_in_atom1272 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_atom1274 = new BitSet(new long[]{8});
        FOLLOW_WILDCARD_in_atom1280 = new BitSet(new long[]{2});
        FOLLOW_DOT_in_atom1286 = new BitSet(new long[]{4});
        FOLLOW_ID_in_atom1288 = new BitSet(new long[]{5336836476935078928L, 86000615428L});
        FOLLOW_element_in_atom1290 = new BitSet(new long[]{8});
        FOLLOW_binary_in_synpred1_LeftRecursiveRuleWalker348 = new BitSet(new long[]{2});
        FOLLOW_prefix_in_synpred2_LeftRecursiveRuleWalker404 = new BitSet(new long[]{2});
        FOLLOW_suffix_in_synpred3_LeftRecursiveRuleWalker460 = new BitSet(new long[]{2});
    }

    public LeftRecursiveRuleWalker(TreeNodeStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public final void alternative() throws RecognitionException {
        match(this.input, 74, FOLLOW_ALT_in_alternative1199);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L9;
        return;
    L9:
        if (this.input.LA(1) != 82) goto L13;
        pushFollow(FOLLOW_elementOptions_in_alternative1201);
        elementOptions();
        RecognizerSharedState r5 = this.state;
        r5._fsp--;
        if (r5.failed == false) goto L13;
        return;
    L13:
        int r10 = 0;
    L14:
        int r11 = this.input.LA(1);
        if (r11 != 4) goto L17;
    L58:
        pushFollow(FOLLOW_element_in_alternative1204);
        element();
        RecognizerSharedState r12 = this.state;
        r12._fsp--;
        if (r12.failed == true) goto L60;
        r10 = r10 + 1;
        goto L14
    L60:
        return;
    L17:
        if (r11 == 10) goto L58;
        if (r11 == 20) goto L58;
        if (r11 == 39) goto L58;
        if (r11 == 46) goto L58;
        if (r11 == 52) goto L58;
        if (r11 == 57) goto L58;
        if (r11 == 59) goto L58;
        if (r11 == 62) goto L58;
        if (r11 == 66) goto L58;
        if (r11 == 78) goto L58;
        if (r11 == 80) goto L58;
        if (r11 == 83) goto L58;
        if (r11 < 89) goto L45;
        if (r11 <= 90) goto L58;
    L45:
        if (r11 == 98) goto L58;
        if (r11 == 100) goto L58;
        if (r10 < 1) goto L52;
        match(this.input, 3, null);
        boolean r13 = this.state.failed;
        return;
    L52:
        RecognizerSharedState r14 = this.state;
        if (r14.backtracking <= 0) goto L57;
        r14.failed = true;
        return;
    L57:
        throw new EarlyExitException(32, this.input);
    }

    public final void atom() throws RecognitionException {
        int r5 = this.input.LA(1);
        if (r5 == 20) goto L140;
        if (r5 == 57) goto L139;
        char r10 = 4;
        if (r5 == 62) goto L98;
        if (r5 == 66) goto L56;
        if (r5 == 100) goto L15;
        RecognizerSharedState r11 = this.state;
        if (r11.backtracking <= 0) goto L14;
        r11.failed = true;
        return;
    L14:
        throw new NoViableAltException("", 35, 0, this.input);
    L15:
        int r12 = this.input.LA(2);
        if (r12 != 2) goto L18;
        char r13 = 6;
    L142:
        switch(r13) {
            case 1: goto L197;
            case 2: goto L186;
            case 3: goto L184;
            case 4: goto L173;
            case 5: goto L171;
            case 6: goto L160;
            case 7: goto L158;
            case 8: goto L144;
            default: goto L224;
        };
    L144:
        match(this.input, 20, FOLLOW_DOT_in_atom1286);
        if (this.state.failed == false) goto L147;
        return;
    L147:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L150;
        return;
    L150:
        match(this.input, 28, FOLLOW_ID_in_atom1288);
        if (this.state.failed == false) goto L153;
        return;
    L153:
        pushFollow(FOLLOW_element_in_atom1290);
        element();
        RecognizerSharedState r14 = this.state;
        r14._fsp--;
        if (r14.failed == false) goto L156;
        return;
    L156:
        match(this.input, 3, null);
        boolean r15 = this.state.failed;
        return;
    L158:
        match(this.input, 100, FOLLOW_WILDCARD_in_atom1280);
        boolean r16 = this.state.failed;
        return;
    L160:
        match(this.input, 100, FOLLOW_WILDCARD_in_atom1272);
        if (this.state.failed == false) goto L163;
        return;
    L163:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L166;
        return;
    L166:
        pushFollow(FOLLOW_elementOptions_in_atom1274);
        elementOptions();
        RecognizerSharedState r17 = this.state;
        r17._fsp--;
        if (r17.failed == false) goto L169;
        return;
    L169:
        match(this.input, 3, null);
        boolean r18 = this.state.failed;
        return;
    L171:
        match(this.input, 66, FOLLOW_TOKEN_REF_in_atom1263);
        boolean r19 = this.state.failed;
        return;
    L173:
        match(this.input, 66, FOLLOW_TOKEN_REF_in_atom1255);
        if (this.state.failed == false) goto L176;
        return;
    L176:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L179;
        return;
    L179:
        pushFollow(FOLLOW_elementOptions_in_atom1257);
        elementOptions();
        RecognizerSharedState r20 = this.state;
        r20._fsp--;
        if (r20.failed == false) goto L182;
        return;
    L182:
        match(this.input, 3, null);
        boolean r21 = this.state.failed;
        return;
    L184:
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_atom1246);
        boolean r22 = this.state.failed;
        return;
    L186:
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_atom1238);
        if (this.state.failed == false) goto L189;
        return;
    L189:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L192;
        return;
    L192:
        pushFollow(FOLLOW_elementOptions_in_atom1240);
        elementOptions();
        RecognizerSharedState r23 = this.state;
        r23._fsp--;
        if (r23.failed == false) goto L195;
        return;
    L195:
        match(this.input, 3, null);
        boolean r24 = this.state.failed;
        return;
    L197:
        match(this.input, 57, FOLLOW_RULE_REF_in_atom1221);
        if (this.state.failed == false) goto L201;
        return;
    L201:
        if (this.input.LA(1) != 2) goto L223;
        match(this.input, 2, null);
        if (this.state.failed == false) goto L206;
        return;
    L206:
        if (this.input.LA(1) != 8) goto L211;
        match(this.input, 8, FOLLOW_ARG_ACTION_in_atom1223);
        if (this.state.failed == false) goto L211;
        return;
    L211:
        if (this.input.LA(1) != 82) goto L215;
        pushFollow(FOLLOW_elementOptions_in_atom1226);
        elementOptions();
        RecognizerSharedState r25 = this.state;
        r25._fsp--;
        if (r25.failed == false) goto L215;
        return;
    L215:
        match(this.input, 3, null);
        boolean r26 = this.state.failed;
        return;
    L223:
        return;
    L224:
        return;
    L18:
        if (r12 < 3) goto L20;
        if (r12 > 4) goto L20;
    L55:
        r13 = 7;
    L20:
        if (r12 == 10) goto L55;
        if (r12 == 20) goto L55;
        if (r12 == 39) goto L55;
        if (r12 == 46) goto L55;
        if (r12 == 52) goto L55;
        if (r12 == 57) goto L55;
        if (r12 == 59) goto L55;
        if (r12 == 62) goto L55;
        if (r12 == 66) goto L55;
        if (r12 == 78) goto L55;
        if (r12 == 80) goto L55;
        if (r12 == 83) goto L55;
        if (r12 < 89) goto L42;
        if (r12 <= 90) goto L55;
    L42:
        if (r12 == 98) goto L55;
        if (r12 == 100) goto L55;
        RecognizerSharedState r27 = this.state;
        if (r27.backtracking <= 0) goto L49;
        r27.failed = true;
        return;
    L49:
        int r28 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L52
        throw new NoViableAltException("", 35, 4, this.input);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        this.input.rewind(r28);
        throw th;
    L56:
        int r29 = this.input.LA(2);
        if (r29 == 2) goto L97;
        if (r29 < 3) goto L61;
        if (r29 > 4) goto L61;
    L96:
        r10 = 5;
    L61:
        if (r29 == 10) goto L96;
        if (r29 == 20) goto L96;
        if (r29 == 39) goto L96;
        if (r29 == 46) goto L96;
        if (r29 == 52) goto L96;
        if (r29 == 57) goto L96;
        if (r29 == 59) goto L96;
        if (r29 == 62) goto L96;
        if (r29 == 66) goto L96;
        if (r29 == 78) goto L96;
        if (r29 == 80) goto L96;
        if (r29 == 83) goto L96;
        if (r29 < 89) goto L83;
        if (r29 <= 90) goto L96;
    L83:
        if (r29 == 98) goto L96;
        if (r29 == 100) goto L96;
        RecognizerSharedState r30 = this.state;
        if (r30.backtracking <= 0) goto L90;
        r30.failed = true;
        return;
    L90:
        int r31 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L93
        throw new NoViableAltException("", 35, 3, this.input);     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        this.input.rewind(r31);
        throw th;
    L97:
        r13 = r10;
        goto L142
    L98:
        int r32 = this.input.LA(2);
        if (r32 != 2) goto L101;
        r13 = 2;
        goto L142
    L101:
        if (r32 < 3) goto L103;
        if (r32 > 4) goto L103;
    L138:
        r13 = 3;
    L103:
        if (r32 == 10) goto L138;
        if (r32 == 20) goto L138;
        if (r32 == 39) goto L138;
        if (r32 == 46) goto L138;
        if (r32 == 52) goto L138;
        if (r32 == 57) goto L138;
        if (r32 == 59) goto L138;
        if (r32 == 62) goto L138;
        if (r32 == 66) goto L138;
        if (r32 == 78) goto L138;
        if (r32 == 80) goto L138;
        if (r32 == 83) goto L138;
        if (r32 < 89) goto L125;
        if (r32 <= 90) goto L138;
    L125:
        if (r32 == 98) goto L138;
        if (r32 == 100) goto L138;
        RecognizerSharedState r33 = this.state;
        if (r33.backtracking <= 0) goto L132;
        r33.failed = true;
        return;
    L132:
        int r34 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L135
        throw new NoViableAltException("", 35, 2, this.input);     // Catch: Throwable -> L135
    L135:
        th = move-exception;
        this.input.rewind(r34);
        throw th;
    L139:
        r13 = 1;
        goto L142
    L140:
        r13 = '\b';
        goto L142
    }

    public final void binary() throws RecognitionException {
        GrammarAST r5 = (GrammarAST) match(this.input, 74, FOLLOW_ALT_in_binary541);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L9;
        return;
    L9:
        if (this.input.LA(1) != 82) goto L13;
        pushFollow(FOLLOW_elementOptions_in_binary543);
        elementOptions();
        RecognizerSharedState r10 = this.state;
        r10._fsp--;
        if (r10.failed == false) goto L13;
        return;
    L13:
        pushFollow(FOLLOW_recurse_in_binary546);
        recurse();
        RecognizerSharedState r11 = this.state;
        r11._fsp--;
        if (r11.failed == false) goto L17;
        return;
    L17:
        if (this.dfa11.predict(this.input) != 1) goto L18;
        pushFollow(FOLLOW_element_in_binary548);
        element();
        RecognizerSharedState r12 = this.state;
        r12._fsp--;
        if (r12.failed == false) goto L17;
        return;
    L18:
        pushFollow(FOLLOW_recurse_in_binary551);
        recurse();
        RecognizerSharedState r13 = this.state;
        r13._fsp--;
        if (r13.failed == false) goto L21;
        return;
    L21:
        int r14 = this.input.LA(1);
        if (r14 != 4) goto L24;
    L35:
        pushFollow(FOLLOW_epsilonElement_in_binary553);
        epsilonElement();
        RecognizerSharedState r15 = this.state;
        r15._fsp--;
        if (r15.failed == false) goto L21;
        return;
    L24:
        if (r14 == 59) goto L35;
        if (r14 == 83) goto L35;
        match(this.input, 3, null);
        RecognizerSharedState r16 = this.state;
        if (r16.failed == false) goto L32;
        return;
    L32:
        if (r16.backtracking != 0) goto L47;
        setAltAssoc((AltAST) r5, this.currentOuterAltNumber);
        return;
    }

    public void binaryAlt(AltAST r5, int r10) {
    }

    public final void block() throws RecognitionException {
        match(this.input, 78, FOLLOW_BLOCK_in_block1177);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L9;
        return;
    L9:
        if (this.input.LA(1) != 4) goto L13;
        match(this.input, 4, FOLLOW_ACTION_in_block1179);
        if (this.state.failed == false) goto L13;
        return;
    L13:
        int r5 = 0;
    L15:
        if (this.input.LA(1) != 74) goto L20;
        pushFollow(FOLLOW_alternative_in_block1182);
        alternative();
        RecognizerSharedState r10 = this.state;
        r10._fsp--;
        if (r10.failed == true) goto L18;
        r5 = r5 + 1;
        goto L15
    L18:
        return;
    L20:
        if (r5 < 1) goto L23;
        match(this.input, 3, null);
        boolean r11 = this.state.failed;
        return;
    L23:
        RecognizerSharedState r12 = this.state;
        if (r12.backtracking <= 0) goto L28;
        r12.failed = true;
        return;
    L28:
        throw new EarlyExitException(30, this.input);
    }

    public final void ebnf() throws RecognitionException {
        int r5 = this.input.LA(1);
        if (r5 == 78) goto L16;
        if (r5 == 80) goto L15;
        if (r5 == 89) goto L14;
        if (r5 == 90) goto L13;
        RecognizerSharedState r10 = this.state;
        if (r10.backtracking <= 0) goto L12;
        r10.failed = true;
        return;
    L12:
        throw new NoViableAltException("", 28, 0, this.input);
    L13:
        char r11 = 4;
    L17:
        if (r11 != 1) goto L19;
        pushFollow(FOLLOW_block_in_ebnf1111);
        block();
        RecognizerSharedState r12 = this.state;
        r12._fsp--;
        boolean r13 = r12.failed;
        return;
    L19:
        if (r11 == 2) goto L45;
        if (r11 == 3) goto L34;
        if (r11 == 4) goto L23;
        return;
    L23:
        match(this.input, 90, FOLLOW_POSITIVE_CLOSURE_in_ebnf1155);
        if (this.state.failed == false) goto L26;
        return;
    L26:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L29;
        return;
    L29:
        pushFollow(FOLLOW_block_in_ebnf1157);
        block();
        RecognizerSharedState r14 = this.state;
        r14._fsp--;
        if (r14.failed == false) goto L32;
        return;
    L32:
        match(this.input, 3, null);
        boolean r15 = this.state.failed;
        return;
    L34:
        match(this.input, 80, FOLLOW_CLOSURE_in_ebnf1139);
        if (this.state.failed == false) goto L37;
        return;
    L37:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L40;
        return;
    L40:
        pushFollow(FOLLOW_block_in_ebnf1141);
        block();
        RecognizerSharedState r16 = this.state;
        r16._fsp--;
        if (r16.failed == false) goto L43;
        return;
    L43:
        match(this.input, 3, null);
        boolean r17 = this.state.failed;
        return;
    L45:
        match(this.input, 89, FOLLOW_OPTIONAL_in_ebnf1123);
        if (this.state.failed == false) goto L48;
        return;
    L48:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L51;
        return;
    L51:
        pushFollow(FOLLOW_block_in_ebnf1125);
        block();
        RecognizerSharedState r18 = this.state;
        r18._fsp--;
        if (r18.failed == false) goto L54;
        return;
    L54:
        match(this.input, 3, null);
        boolean r19 = this.state.failed;
        return;
    L14:
        r11 = 2;
        goto L17
    L15:
        r11 = 3;
        goto L17
    L16:
        r11 = 1;
        goto L17
    }

    public final void element() throws RecognitionException {
        int r5 = 0;
        char r14 = 4;
        switch(this.input.LA(1)) {
            case 4: goto L58;
            case 10: goto L60;
            case 20: goto L57;
            case 39: goto L56;
            case 46: goto L55;
            case 52: goto L54;
            case 57: goto L12;
            case 59: goto L58;
            case 62: goto L57;
            case 66: goto L57;
            case 78: goto L11;
            case 80: goto L11;
            case 83: goto L58;
            case 89: goto L11;
            case 90: goto L11;
            case 98: goto L10;
            case 100: goto L57;
            default: goto L4;
        };
    L4:
        RecognizerSharedState r10 = this.state;
        if (r10.backtracking <= 0) goto L9;
        r10.failed = true;
        return;
    L9:
        throw new NoViableAltException("", 25, 0, this.input);
    L10:
        r14 = 6;
        goto L60
    L11:
        r14 = '\b';
        goto L60
    L12:
        int r11 = this.input.LA(2);
        if (r11 == 2) goto L57;
        if (r11 < 3) goto L17;
        if (r11 > 4) goto L17;
    L53:
        r14 = 7;
    L17:
        if (r11 == 10) goto L53;
        if (r11 == 20) goto L53;
        if (r11 == 39) goto L53;
        if (r11 == 46) goto L53;
        if (r11 == 52) goto L53;
        if (r11 == 57) goto L53;
        if (r11 == 59) goto L53;
        if (r11 == 62) goto L53;
        if (r11 == 66) goto L53;
        if (r11 == 78) goto L53;
        if (r11 == 80) goto L53;
        if (r11 == 83) goto L53;
        if (r11 < 89) goto L39;
        if (r11 <= 90) goto L53;
    L39:
        if (r11 == 98) goto L53;
        if (r11 == 100) goto L53;
        RecognizerSharedState r12 = this.state;
        if (r12.backtracking <= 0) goto L47;
        r12.failed = true;
        return;
    L47:
        int r13 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L50
        throw new NoViableAltException("", 25, 1, this.input);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        this.input.rewind(r13);
        throw th;
    L54:
        r14 = 3;
        goto L60
    L55:
        r14 = 5;
        goto L60
    L56:
        r14 = 2;
    L57:
        r14 = 1;
        goto L60
    L58:
        r14 = '\t';
    L60:
        switch(r14) {
            case 1: goto L144;
            case 2: goto L133;
            case 3: goto L119;
            case 4: goto L105;
            case 5: goto L91;
            case 6: goto L68;
            case 7: goto L66;
            case 8: goto L64;
            case 9: goto L62;
            default: goto L61;
        };
    L61:
        return;
    L62:
        pushFollow(FOLLOW_epsilonElement_in_element1027);
        epsilonElement();
        RecognizerSharedState r15 = this.state;
        r15._fsp--;
        boolean r16 = r15.failed;
        return;
    L64:
        pushFollow(FOLLOW_ebnf_in_element1022);
        ebnf();
        RecognizerSharedState r17 = this.state;
        r17._fsp--;
        boolean r18 = r17.failed;
        return;
    L66:
        match(this.input, 57, FOLLOW_RULE_REF_in_element1017);
        boolean r19 = this.state.failed;
        return;
    L68:
        match(this.input, 98, FOLLOW_SET_in_element1003);
        if (this.state.failed == false) goto L71;
        return;
    L71:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L74;
        return;
    L74:
        int r20 = this.input.LA(1);
        if (r20 == 62) goto L87;
        if (r20 == 66) goto L87;
        if (r5 < 1) goto L81;
        match(this.input, 3, null);
        boolean r21 = this.state.failed;
        return;
    L81:
        RecognizerSharedState r22 = this.state;
        if (r22.backtracking <= 0) goto L86;
        r22.failed = true;
        return;
    L86:
        throw new EarlyExitException(24, this.input);
    L87:
        pushFollow(FOLLOW_setElement_in_element1005);
        setElement();
        RecognizerSharedState r23 = this.state;
        r23._fsp--;
        if (r23.failed == true) goto L89;
        r5 = r5 + 1;
        goto L74
    L89:
        return;
    L91:
        match(this.input, 46, FOLLOW_PLUS_ASSIGN_in_element989);
        if (this.state.failed == false) goto L94;
        return;
    L94:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L97;
        return;
    L97:
        match(this.input, 28, FOLLOW_ID_in_element991);
        if (this.state.failed == false) goto L100;
        return;
    L100:
        pushFollow(FOLLOW_element_in_element993);
        element();
        RecognizerSharedState r24 = this.state;
        r24._fsp--;
        if (r24.failed == false) goto L103;
        return;
    L103:
        match(this.input, 3, null);
        boolean r25 = this.state.failed;
        return;
    L105:
        match(this.input, 10, FOLLOW_ASSIGN_in_element978);
        if (this.state.failed == false) goto L108;
        return;
    L108:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L111;
        return;
    L111:
        match(this.input, 28, FOLLOW_ID_in_element980);
        if (this.state.failed == false) goto L114;
        return;
    L114:
        pushFollow(FOLLOW_element_in_element982);
        element();
        RecognizerSharedState r26 = this.state;
        r26._fsp--;
        if (r26.failed == false) goto L117;
        return;
    L117:
        match(this.input, 3, null);
        boolean r27 = this.state.failed;
        return;
    L119:
        match(this.input, 52, FOLLOW_RANGE_in_element967);
        if (this.state.failed == false) goto L122;
        return;
    L122:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L125;
        return;
    L125:
        pushFollow(FOLLOW_atom_in_element969);
        atom();
        RecognizerSharedState r28 = this.state;
        r28._fsp--;
        if (r28.failed == false) goto L128;
        return;
    L128:
        pushFollow(FOLLOW_atom_in_element971);
        atom();
        RecognizerSharedState r29 = this.state;
        r29._fsp--;
        if (r29.failed == false) goto L131;
        return;
    L131:
        match(this.input, 3, null);
        boolean r30 = this.state.failed;
        return;
    L133:
        match(this.input, 39, FOLLOW_NOT_in_element958);
        if (this.state.failed == false) goto L136;
        return;
    L136:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L139;
        return;
    L139:
        pushFollow(FOLLOW_element_in_element960);
        element();
        RecognizerSharedState r31 = this.state;
        r31._fsp--;
        if (r31.failed == false) goto L142;
        return;
    L142:
        match(this.input, 3, null);
        boolean r32 = this.state.failed;
        return;
    L144:
        pushFollow(FOLLOW_atom_in_element952);
        atom();
        RecognizerSharedState r33 = this.state;
        r33._fsp--;
        boolean r34 = r33.failed;
    }

    public final void elementOption() throws RecognitionException {
        int r5 = this.input.LA(1);
        if (r5 != 28) goto L5;
        char r10 = 1;
    L33:
        if (r10 != 1) goto L35;
        match(this.input, 28, FOLLOW_ID_in_elementOption874);
        boolean r13 = this.state.failed;
        return;
    L35:
        if (r10 == 2) goto L82;
        if (r10 == 3) goto L68;
        if (r10 == 4) goto L54;
        if (r10 == 5) goto L40;
        return;
    L40:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption933);
        if (this.state.failed == false) goto L43;
        return;
    L43:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L46;
        return;
    L46:
        match(this.input, 28, FOLLOW_ID_in_elementOption935);
        if (this.state.failed == false) goto L49;
        return;
    L49:
        match(this.input, 30, FOLLOW_INT_in_elementOption937);
        if (this.state.failed == false) goto L52;
        return;
    L52:
        match(this.input, 3, null);
        boolean r14 = this.state.failed;
        return;
    L54:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption917);
        if (this.state.failed == false) goto L57;
        return;
    L57:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L60;
        return;
    L60:
        match(this.input, 28, FOLLOW_ID_in_elementOption919);
        if (this.state.failed == false) goto L63;
        return;
    L63:
        match(this.input, 4, FOLLOW_ACTION_in_elementOption921);
        if (this.state.failed == false) goto L66;
        return;
    L66:
        match(this.input, 3, null);
        boolean r15 = this.state.failed;
        return;
    L68:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption901);
        if (this.state.failed == false) goto L71;
        return;
    L71:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L74;
        return;
    L74:
        match(this.input, 28, FOLLOW_ID_in_elementOption903);
        if (this.state.failed == false) goto L77;
        return;
    L77:
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_elementOption905);
        if (this.state.failed == false) goto L80;
        return;
    L80:
        match(this.input, 3, null);
        boolean r16 = this.state.failed;
        return;
    L82:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption885);
        if (this.state.failed == false) goto L85;
        return;
    L85:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L88;
        return;
    L88:
        match(this.input, 28, FOLLOW_ID_in_elementOption887);
        if (this.state.failed == false) goto L91;
        return;
    L91:
        match(this.input, 28, FOLLOW_ID_in_elementOption889);
        if (this.state.failed == false) goto L94;
        return;
    L94:
        match(this.input, 3, null);
        boolean r17 = this.state.failed;
        return;
    L5:
        int r11 = 0;
        if (r5 == 10) goto L8;
        RecognizerSharedState r12 = this.state;
        if (r12.backtracking <= 0) goto L126;
        r12.failed = true;
        return;
    L126:
        throw new NoViableAltException("", 23, 0, this.input);
    L8:
        if (this.input.LA(2) == 2) goto L10;
        RecognizerSharedState r18 = this.state;
        if (r18.backtracking <= 0) goto L115;
        r18.failed = true;
        return;
    L115:
        int r19 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L118
        throw new NoViableAltException("", 23, 2, this.input);     // Catch: Throwable -> L118
    L118:
        th = move-exception;
        this.input.rewind(r19);
        throw th;
    L10:
        if (this.input.LA(3) != 28) goto L98;
        int r20 = this.input.LA(4);
        if (r20 == 4) goto L32;
        if (r20 == 28) goto L31;
        if (r20 == 30) goto L30;
        if (r20 == 62) goto L29;
        RecognizerSharedState r21 = this.state;
        if (r21.backtracking <= 0) goto L20;
        r21.failed = true;
        return;
    L20:
        int r22 = this.input.mark();
    L21:
        if (r11 >= 3) goto L26;
        this.input.consume();     // Catch: Throwable -> L23
        r11 = r11 + 1;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        this.input.rewind(r22);
        throw th;
    L26:
        throw new NoViableAltException("", 23, 4, this.input);     // Catch: Throwable -> L23
    L29:
        r10 = 3;
        goto L33
    L30:
        r10 = 5;
        goto L33
    L31:
        r10 = 2;
        goto L33
    L32:
        r10 = 4;
        goto L33
    L98:
        RecognizerSharedState r23 = this.state;
        if (r23.backtracking <= 0) goto L102;
        r23.failed = true;
        return;
    L102:
        int r24 = this.input.mark();
    L103:
        if (r11 >= 2) goto L108;
        this.input.consume();     // Catch: Throwable -> L105
        r11 = r11 + 1;     // Catch: Throwable -> L105
    L105:
        th = move-exception;
        this.input.rewind(r24);
        throw th;
    L108:
        throw new NoViableAltException("", 23, 3, this.input);     // Catch: Throwable -> L105
    }

    public final void elementOptions() throws RecognitionException {
        match(this.input, 82, FOLLOW_ELEMENT_OPTIONS_in_elementOptions853);
        if (this.state.failed == false) goto L6;
        return;
    L6:
        if (this.input.LA(1) != 2) goto L19;
        match(this.input, 2, null);
        if (this.state.failed == false) goto L10;
        return;
    L10:
        int r5 = this.input.LA(1);
        if (r5 != 10) goto L13;
    L17:
        pushFollow(FOLLOW_elementOption_in_elementOptions855);
        elementOption();
        RecognizerSharedState r10 = this.state;
        r10._fsp--;
        if (r10.failed == false) goto L10;
        return;
    L13:
        if (r5 == 28) goto L17;
        match(this.input, 3, null);
        boolean r11 = this.state.failed;
        return;
    }

    public final void epsilonElement() throws RecognitionException {
        int r5 = this.input.LA(1);
        if (r5 == 4) goto L54;
        if (r5 == 59) goto L13;
        if (r5 == 83) goto L12;
        RecognizerSharedState r10 = this.state;
        if (r10.backtracking <= 0) goto L11;
        r10.failed = true;
        return;
    L11:
        throw new NoViableAltException("", 26, 0, this.input);
    L12:
        char r11 = 3;
    L95:
        if (r11 == 1) goto L129;
        if (r11 == 2) goto L127;
        if (r11 != 3) goto L99;
        match(this.input, 83, FOLLOW_EPSILON_in_epsilonElement1048);
        boolean r12 = this.state.failed;
        return;
    L99:
        if (r11 != 4) goto L101;
        match(this.input, 4, FOLLOW_ACTION_in_epsilonElement1054);
        if (this.state.failed == false) goto L117;
        return;
    L117:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L120;
        return;
    L120:
        pushFollow(FOLLOW_elementOptions_in_epsilonElement1056);
        elementOptions();
        RecognizerSharedState r13 = this.state;
        r13._fsp--;
        if (r13.failed == false) goto L123;
        return;
    L123:
        match(this.input, 3, null);
        boolean r14 = this.state.failed;
        return;
    L101:
        if (r11 == 5) goto L103;
        return;
    L103:
        match(this.input, 59, FOLLOW_SEMPRED_in_epsilonElement1063);
        if (this.state.failed == false) goto L106;
        return;
    L106:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L109;
        return;
    L109:
        pushFollow(FOLLOW_elementOptions_in_epsilonElement1065);
        elementOptions();
        RecognizerSharedState r15 = this.state;
        r15._fsp--;
        if (r15.failed == false) goto L112;
        return;
    L112:
        match(this.input, 3, null);
        boolean r16 = this.state.failed;
        return;
    L127:
        match(this.input, 59, FOLLOW_SEMPRED_in_epsilonElement1043);
        boolean r17 = this.state.failed;
        return;
    L129:
        match(this.input, 4, FOLLOW_ACTION_in_epsilonElement1038);
        boolean r18 = this.state.failed;
        return;
    L13:
        int r19 = this.input.LA(2);
        if (r19 != 2) goto L16;
        r11 = 5;
        goto L95
    L16:
        if (r19 < 3) goto L18;
        if (r19 > 4) goto L18;
    L53:
        r11 = 2;
    L18:
        if (r19 == 10) goto L53;
        if (r19 == 20) goto L53;
        if (r19 == 39) goto L53;
        if (r19 == 46) goto L53;
        if (r19 == 52) goto L53;
        if (r19 == 57) goto L53;
        if (r19 == 59) goto L53;
        if (r19 == 62) goto L53;
        if (r19 == 66) goto L53;
        if (r19 == 78) goto L53;
        if (r19 == 80) goto L53;
        if (r19 == 83) goto L53;
        if (r19 < 89) goto L39;
        if (r19 <= 90) goto L53;
    L39:
        if (r19 == 98) goto L53;
        if (r19 == 100) goto L53;
        RecognizerSharedState r20 = this.state;
        if (r20.backtracking <= 0) goto L47;
        r20.failed = true;
        return;
    L47:
        int r21 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L50
        throw new NoViableAltException("", 26, 2, this.input);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        this.input.rewind(r21);
        throw th;
    L54:
        int r22 = this.input.LA(2);
        if (r22 != 2) goto L57;
        r11 = 4;
        goto L95
    L57:
        if (r22 < 3) goto L59;
        if (r22 > 4) goto L59;
    L94:
        r11 = 1;
    L59:
        if (r22 == 10) goto L94;
        if (r22 == 20) goto L94;
        if (r22 == 39) goto L94;
        if (r22 == 46) goto L94;
        if (r22 == 52) goto L94;
        if (r22 == 57) goto L94;
        if (r22 == 59) goto L94;
        if (r22 == 62) goto L94;
        if (r22 == 66) goto L94;
        if (r22 == 78) goto L94;
        if (r22 == 80) goto L94;
        if (r22 == 83) goto L94;
        if (r22 < 89) goto L80;
        if (r22 <= 90) goto L94;
    L80:
        if (r22 == 98) goto L94;
        if (r22 == 100) goto L94;
        RecognizerSharedState r23 = this.state;
        if (r23.backtracking <= 0) goto L88;
        r23.failed = true;
        return;
    L88:
        int r24 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L91
        throw new NoViableAltException("", 26, 1, this.input);     // Catch: Throwable -> L91
    L91:
        th = move-exception;
        this.input.rewind(r24);
        throw th;
    }

    public final void exceptionGroup() throws RecognitionException {
    L3:
        if (this.input.LA(1) != 12) goto L8;
        pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup197);
        exceptionHandler();
        RecognizerSharedState r5 = this.state;
        r5._fsp--;
        if (r5.failed == false) goto L3;
        return;
    L8:
        if (this.input.LA(1) != 23) goto L14;
        pushFollow(FOLLOW_finallyClause_in_exceptionGroup200);
        finallyClause();
        RecognizerSharedState r10 = this.state;
        r10._fsp--;
        boolean r11 = r10.failed;
        return;
    }

    public final void exceptionHandler() throws RecognitionException {
        match(this.input, 12, FOLLOW_CATCH_in_exceptionHandler216);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L8;
        return;
    L8:
        match(this.input, 8, FOLLOW_ARG_ACTION_in_exceptionHandler218);
        if (this.state.failed == false) goto L11;
        return;
    L11:
        match(this.input, 4, FOLLOW_ACTION_in_exceptionHandler220);
        if (this.state.failed == false) goto L14;
        return;
    L14:
        match(this.input, 3, null);
        boolean r5 = this.state.failed;
    }

    public final void finallyClause() throws RecognitionException {
        match(this.input, 23, FOLLOW_FINALLY_in_finallyClause233);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L8;
        return;
    L8:
        match(this.input, 4, FOLLOW_ACTION_in_finallyClause235);
        if (this.state.failed == false) goto L11;
        return;
    L11:
        match(this.input, 3, null);
        boolean r5 = this.state.failed;
    }

    public TreeParser[] getDelegates() {
        return new TreeParser[0];
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getGrammarFileName() {
        return "androidx/room/jarjarred/org/antlr/v4/parse/LeftRecursiveRuleWalker.g";
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String[] getTokenNames() {
        return tokenNames;
    }

    public final void nonLeftRecur() throws RecognitionException {
        match(this.input, 74, FOLLOW_ALT_in_nonLeftRecur671);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L9;
        return;
    L9:
        if (this.input.LA(1) != 82) goto L13;
        pushFollow(FOLLOW_elementOptions_in_nonLeftRecur673);
        elementOptions();
        RecognizerSharedState r5 = this.state;
        r5._fsp--;
        if (r5.failed == false) goto L13;
        return;
    L13:
        int r10 = 0;
    L14:
        int r11 = this.input.LA(1);
        if (r11 != 4) goto L17;
    L58:
        pushFollow(FOLLOW_element_in_nonLeftRecur676);
        element();
        RecognizerSharedState r12 = this.state;
        r12._fsp--;
        if (r12.failed == true) goto L60;
        r10 = r10 + 1;
        goto L14
    L60:
        return;
    L17:
        if (r11 == 10) goto L58;
        if (r11 == 20) goto L58;
        if (r11 == 39) goto L58;
        if (r11 == 46) goto L58;
        if (r11 == 52) goto L58;
        if (r11 == 57) goto L58;
        if (r11 == 59) goto L58;
        if (r11 == 62) goto L58;
        if (r11 == 66) goto L58;
        if (r11 == 78) goto L58;
        if (r11 == 80) goto L58;
        if (r11 == 83) goto L58;
        if (r11 < 89) goto L45;
        if (r11 <= 90) goto L58;
    L45:
        if (r11 == 98) goto L58;
        if (r11 == 100) goto L58;
        if (r10 < 1) goto L52;
        match(this.input, 3, null);
        boolean r13 = this.state.failed;
        return;
    L52:
        RecognizerSharedState r14 = this.state;
        if (r14.backtracking <= 0) goto L57;
        r14.failed = true;
        return;
    L57:
        throw new EarlyExitException(19, this.input);
    }

    public void otherAlt(AltAST r5, int r10) {
    }

    public final outerAlternative_return outerAlternative() throws RecognitionException {
        outerAlternative_return r5 = new outerAlternative_return();
        r5.start = this.input.LT(1);
        if (this.input.LA(1) != 74) goto L44;
        this.input.LA(2);
        if (synpred1_LeftRecursiveRuleWalker() == false) goto L8;
        char r10 = 1;
    L14:
        if (r10 == 1) goto L37;
        if (r10 == 2) goto L31;
        if (r10 == 3) goto L25;
        if (r10 != 4) goto L43;
        pushFollow(FOLLOW_nonLeftRecur_in_outerAlternative515);
        nonLeftRecur();
        RecognizerSharedState r11 = this.state;
        r11._fsp--;
        if (r11.failed == false) goto L23;
        return r5;
    L23:
        if (r11.backtracking != 0) goto L43;
        otherAlt((AltAST) ((GrammarAST) r5.start), this.currentOuterAltNumber);
    L43:
        return r5;
    L25:
        pushFollow(FOLLOW_suffix_in_outerAlternative474);
        suffix();
        RecognizerSharedState r12 = this.state;
        r12._fsp--;
        if (r12.failed == false) goto L29;
        return r5;
    L29:
        if (r12.backtracking != 0) goto L43;
        suffixAlt((AltAST) ((GrammarAST) r5.start), this.currentOuterAltNumber);
        r5.isLeftRec = true;
        goto L43
    L31:
        pushFollow(FOLLOW_prefix_in_outerAlternative418);
        prefix();
        RecognizerSharedState r13 = this.state;
        r13._fsp--;
        if (r13.failed == false) goto L35;
        return r5;
    L35:
        if (r13.backtracking != 0) goto L43;
        prefixAlt((AltAST) ((GrammarAST) r5.start), this.currentOuterAltNumber);
        goto L43
    L37:
        pushFollow(FOLLOW_binary_in_outerAlternative362);
        binary();
        RecognizerSharedState r14 = this.state;
        r14._fsp--;
        if (r14.failed == false) goto L41;
        return r5;
    L41:
        if (r14.backtracking != 0) goto L43;
        binaryAlt((AltAST) ((GrammarAST) r5.start), this.currentOuterAltNumber);
        r5.isLeftRec = true;
        goto L43
    L8:
        if (synpred2_LeftRecursiveRuleWalker() == false) goto L11;
        r10 = 2;
        goto L14
    L11:
        if (synpred3_LeftRecursiveRuleWalker() == false) goto L13;
        r10 = 3;
        goto L14
    L13:
        r10 = 4;
        goto L14
    L44:
        RecognizerSharedState r15 = this.state;
        if (r15.backtracking <= 0) goto L49;
        r15.failed = true;
        return r5;
    L49:
        throw new NoViableAltException("", 9, 0, this.input);
    }

    public final void prefix() throws RecognitionException {
        GrammarAST r5 = (GrammarAST) match(this.input, 74, FOLLOW_ALT_in_prefix579);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L9;
        return;
    L9:
        if (this.input.LA(1) != 82) goto L13;
        pushFollow(FOLLOW_elementOptions_in_prefix581);
        elementOptions();
        RecognizerSharedState r10 = this.state;
        r10._fsp--;
        if (r10.failed == false) goto L13;
        return;
    L13:
        int r11 = 0;
    L15:
        if (this.dfa14.predict(this.input) != 1) goto L16;
        pushFollow(FOLLOW_element_in_prefix587);
        element();
        RecognizerSharedState r12 = this.state;
        r12._fsp--;
        if (r12.failed == true) goto L45;
        r11 = r11 + 1;
        goto L15
    L45:
        return;
    L16:
        if (r11 < 1) goto L37;
        pushFollow(FOLLOW_recurse_in_prefix593);
        recurse();
        RecognizerSharedState r13 = this.state;
        r13._fsp--;
        if (r13.failed == false) goto L20;
        return;
    L20:
        int r14 = this.input.LA(1);
        if (r14 != 4) goto L23;
    L34:
        pushFollow(FOLLOW_epsilonElement_in_prefix595);
        epsilonElement();
        RecognizerSharedState r15 = this.state;
        r15._fsp--;
        if (r15.failed == false) goto L20;
        return;
    L23:
        if (r14 == 59) goto L34;
        if (r14 == 83) goto L34;
        match(this.input, 3, null);
        RecognizerSharedState r16 = this.state;
        if (r16.failed == false) goto L31;
        return;
    L31:
        if (r16.backtracking != 0) goto L52;
        setAltAssoc((AltAST) r5, this.currentOuterAltNumber);
        return;
    L52:
        return;
    L37:
        RecognizerSharedState r17 = this.state;
        if (r17.backtracking <= 0) goto L42;
        r17.failed = true;
        return;
    L42:
        throw new EarlyExitException(14, this.input);
    }

    public void prefixAlt(AltAST r5, int r10) {
    }

    public final boolean rec_rule() throws RecognitionException {
        this.currentOuterAltNumber = 1;
        GrammarAST r5 = (GrammarAST) match(this.input, 94, FOLLOW_RULE_in_rec_rule72);
        boolean r10 = false;
        if (this.state.failed == false) goto L5;
        return false;
    L5:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L8;
        return false;
    L8:
        GrammarAST r11 = (GrammarAST) match(this.input, 57, FOLLOW_RULE_REF_in_rec_rule76);
        RecognizerSharedState r12 = this.state;
        if (r12.failed == false) goto L12;
        return false;
    L12:
        if (r12.backtracking != 0) goto L14;
        this.ruleName = r11.getText();
    L14:
        int r13 = this.input.LA(1);
        if (r13 < 48) goto L22;
        if (r13 > 50) goto L22;
        pushFollow(FOLLOW_ruleModifier_in_rec_rule83);
        ruleModifier();
        RecognizerSharedState r14 = this.state;
        r14._fsp--;
        if (r14.failed == false) goto L22;
        return false;
    L22:
        if (this.input.LA(1) != 55) goto L39;
        match(this.input, 55, FOLLOW_RETURNS_in_rec_rule92);
        if (this.state.failed == false) goto L26;
        return false;
    L26:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L29;
        return false;
    L29:
        GrammarAST r15 = (GrammarAST) match(this.input, 8, FOLLOW_ARG_ACTION_in_rec_rule96);
        RecognizerSharedState r16 = this.state;
        if (r16.failed == false) goto L33;
        return false;
    L33:
        if (r16.backtracking != 0) goto L35;
        setReturnValues(r15);
    L35:
        match(this.input, 3, null);
        if (this.state.failed == false) goto L39;
        return false;
    L39:
        if (this.input.LA(1) != 33) goto L52;
        match(this.input, 33, FOLLOW_LOCALS_in_rec_rule115);
        if (this.state.failed == false) goto L43;
        return false;
    L43:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L46;
        return false;
    L46:
        match(this.input, 8, FOLLOW_ARG_ACTION_in_rec_rule117);
        if (this.state.failed == false) goto L49;
        return false;
    L49:
        match(this.input, 3, null);
        if (this.state.failed == false) goto L52;
        return false;
    L52:
        int r17 = this.input.LA(1);
        if (r17 != 42) goto L55;
        char r18 = 1;
    L59:
        if (r18 != 1) goto L60;
        match(this.input, 42, FOLLOW_OPTIONS_in_rec_rule135);
        if (this.state.failed == true) goto L90;
        if (this.input.LA(1) != 2) goto L52;
        match(this.input, 2, null);
        if (this.state.failed == true) goto L95;
    L96:
        int r19 = this.input.LA(1);
        if (r19 < 4) goto L103;
        if (r19 > 100) goto L103;
        matchAny(this.input);
        if (this.state.failed == false) goto L96;
        return false;
    L103:
        match(this.input, 3, null);
        if (this.state.failed == false) goto L52;
        return false;
    L95:
        return false;
    L90:
        return false;
    L60:
        if (r18 != 2) goto L61;
        match(this.input, 11, FOLLOW_AT_in_rec_rule152);
        if (this.state.failed == true) goto L75;
        match(this.input, 2, null);
        if (this.state.failed == true) goto L78;
        match(this.input, 28, FOLLOW_ID_in_rec_rule154);
        if (this.state.failed == true) goto L81;
        match(this.input, 4, FOLLOW_ACTION_in_rec_rule156);
        if (this.state.failed == true) goto L84;
        match(this.input, 3, null);
        if (this.state.failed == false) goto L52;
        return false;
    L84:
        return false;
    L81:
        return false;
    L78:
        return false;
    L75:
        return false;
    L61:
        pushFollow(FOLLOW_ruleBlock_in_rec_rule172);
        ruleBlock_return r20 = ruleBlock();
        RecognizerSharedState r21 = this.state;
        r21._fsp--;
        if (r21.failed == false) goto L65;
        return false;
    L65:
        if (r21.backtracking != 0) goto L68;
        if (r20 == null) goto L68;
        r10 = r20.isLeftRec;
    L68:
        pushFollow(FOLLOW_exceptionGroup_in_rec_rule179);
        exceptionGroup();
        RecognizerSharedState r22 = this.state;
        r22._fsp--;
        if (r22.failed == false) goto L71;
        return r10;
    L71:
        match(this.input, 3, null);
        boolean r23 = this.state.failed;
        return r10;
    L55:
        if (r17 != 11) goto L57;
        r18 = 2;
        goto L59
    L57:
        r18 = 3;
        goto L59
    }

    public final void recurse() throws RecognitionException {
        int r5 = this.input.LA(1);
        if (r5 == 10) goto L15;
        if (r5 != 46) goto L6;
        char r10 = 2;
    L17:
        if (r10 == 1) goto L37;
        if (r10 == 2) goto L23;
        if (r10 == 3) goto L21;
        return;
    L21:
        pushFollow(FOLLOW_recurseNoLabel_in_recurse714);
        recurseNoLabel();
        RecognizerSharedState r11 = this.state;
        r11._fsp--;
        boolean r12 = r11.failed;
        return;
    L23:
        match(this.input, 46, FOLLOW_PLUS_ASSIGN_in_recurse704);
        if (this.state.failed == false) goto L26;
        return;
    L26:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L29;
        return;
    L29:
        match(this.input, 28, FOLLOW_ID_in_recurse706);
        if (this.state.failed == false) goto L32;
        return;
    L32:
        pushFollow(FOLLOW_recurseNoLabel_in_recurse708);
        recurseNoLabel();
        RecognizerSharedState r13 = this.state;
        r13._fsp--;
        if (r13.failed == false) goto L35;
        return;
    L35:
        match(this.input, 3, null);
        boolean r14 = this.state.failed;
        return;
    L37:
        match(this.input, 10, FOLLOW_ASSIGN_in_recurse693);
        if (this.state.failed == false) goto L40;
        return;
    L40:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L43;
        return;
    L43:
        match(this.input, 28, FOLLOW_ID_in_recurse695);
        if (this.state.failed == false) goto L46;
        return;
    L46:
        pushFollow(FOLLOW_recurseNoLabel_in_recurse697);
        recurseNoLabel();
        RecognizerSharedState r15 = this.state;
        r15._fsp--;
        if (r15.failed == false) goto L49;
        return;
    L49:
        match(this.input, 3, null);
        boolean r16 = this.state.failed;
        return;
    L6:
        if (r5 == 57) goto L13;
        RecognizerSharedState r17 = this.state;
        if (r17.backtracking <= 0) goto L12;
        r17.failed = true;
        return;
    L12:
        throw new NoViableAltException("", 20, 0, this.input);
    L13:
        r10 = 3;
        goto L17
    L15:
        r10 = 1;
        goto L17
    }

    public final void recurseNoLabel() throws RecognitionException {
        if (((CommonTree) this.input.LT(1)).getText().equals(this.ruleName) == true) goto L10;
        RecognizerSharedState r5 = this.state;
        if (r5.backtracking <= 0) goto L9;
        r5.failed = true;
        return;
    L9:
        throw new FailedPredicateException(this.input, "recurseNoLabel", "((CommonTree)input.LT(1)).getText().equals(ruleName)");
    L10:
        match(this.input, 57, FOLLOW_RULE_REF_in_recurseNoLabel726);
        boolean r10 = this.state.failed;
    }

    public final ruleBlock_return ruleBlock() throws RecognitionException {
        ruleBlock_return r5 = new ruleBlock_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        this.numAlts = ((GrammarAST) r10).getChildCount();
        match(this.input, 78, FOLLOW_BLOCK_in_ruleBlock290);
        if (this.state.failed == false) goto L5;
        return r5;
    L5:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L8;
        return r5;
    L8:
        int r11 = 0;
    L10:
        if (this.input.LA(1) != 74) goto L23;
        pushFollow(FOLLOW_outerAlternative_in_ruleBlock303);
        outerAlternative_return r12 = outerAlternative();
        RecognizerSharedState r13 = this.state;
        r13._fsp--;
        if (r13.failed == true) goto L13;
        int r14 = r13.backtracking;
        if (r14 != 0) goto L20;
        if (r12 == null) goto L20;
        if (r12.isLeftRec == false) goto L20;
        r5.isLeftRec = true;
    L20:
        if (r14 != 0) goto L22;
        this.currentOuterAltNumber++;
    L22:
        r11 = r11 + 1;
        goto L10
    L13:
        return r5;
    L23:
        if (r11 < 1) goto L26;
        match(this.input, 3, null);
        boolean r15 = this.state.failed;
        return r5;
    L26:
        RecognizerSharedState r16 = this.state;
        if (r16.backtracking <= 0) goto L31;
        r16.failed = true;
        return r5;
    L31:
        throw new EarlyExitException(8, this.input);
    }

    public final void ruleModifier() throws RecognitionException {
        if (this.input.LA(1) >= 48) goto L5;
    L8:
        RecognizerSharedState r5 = this.state;
        if (r5.backtracking <= 0) goto L13;
        r5.failed = true;
        return;
    L13:
        throw new MismatchedSetException(null, this.input);
    L5:
        if (this.input.LA(1) > 50) goto L8;
        this.input.consume();
        RecognizerSharedState r10 = this.state;
        r10.errorRecovery = false;
        r10.failed = false;
    }

    public void setAltAssoc(AltAST r5, int r10) {
    }

    public final void setElement() throws RecognitionException {
        int r5 = this.input.LA(1);
        if (r5 != 62) goto L22;
        int r10 = this.input.LA(2);
        if (r10 != 2) goto L7;
        char r11 = 1;
    L42:
        if (r11 == 1) goto L62;
        if (r11 == 2) goto L51;
        if (r11 == 3) goto L49;
        if (r11 == 4) goto L47;
        return;
    L47:
        match(this.input, 66, FOLLOW_TOKEN_REF_in_setElement1100);
        boolean r12 = this.state.failed;
        return;
    L49:
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement1095);
        boolean r13 = this.state.failed;
        return;
    L51:
        match(this.input, 66, FOLLOW_TOKEN_REF_in_setElement1087);
        if (this.state.failed == false) goto L54;
        return;
    L54:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L57;
        return;
    L57:
        pushFollow(FOLLOW_elementOptions_in_setElement1089);
        elementOptions();
        RecognizerSharedState r14 = this.state;
        r14._fsp--;
        if (r14.failed == false) goto L60;
        return;
    L60:
        match(this.input, 3, null);
        boolean r15 = this.state.failed;
        return;
    L62:
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement1078);
        if (this.state.failed == false) goto L65;
        return;
    L65:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L68;
        return;
    L68:
        pushFollow(FOLLOW_elementOptions_in_setElement1080);
        elementOptions();
        RecognizerSharedState r16 = this.state;
        r16._fsp--;
        if (r16.failed == false) goto L71;
        return;
    L71:
        match(this.input, 3, null);
        boolean r17 = this.state.failed;
        return;
    L7:
        if (r10 == 3) goto L21;
        if (r10 == 62) goto L21;
        if (r10 == 66) goto L21;
        RecognizerSharedState r18 = this.state;
        if (r18.backtracking <= 0) goto L15;
        r18.failed = true;
        return;
    L15:
        int r19 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L18
        throw new NoViableAltException("", 27, 1, this.input);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        this.input.rewind(r19);
        throw th;
    L21:
        r11 = 3;
        goto L42
    L22:
        if (r5 != 66) goto L73;
        int r20 = this.input.LA(2);
        if (r20 != 2) goto L26;
        r11 = 2;
        goto L42
    L26:
        if (r20 == 3) goto L40;
        if (r20 == 62) goto L40;
        if (r20 == 66) goto L40;
        RecognizerSharedState r21 = this.state;
        if (r21.backtracking <= 0) goto L34;
        r21.failed = true;
        return;
    L34:
        int r22 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L37
        throw new NoViableAltException("", 27, 2, this.input);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        this.input.rewind(r22);
        throw th;
    L40:
        r11 = 4;
        goto L42
    L73:
        RecognizerSharedState r23 = this.state;
        if (r23.backtracking <= 0) goto L78;
        r23.failed = true;
        return;
    L78:
        throw new NoViableAltException("", 27, 0, this.input);
    }

    public void setReturnValues(GrammarAST r5) {
    }

    public final void suffix() throws RecognitionException {
        GrammarAST r5 = (GrammarAST) match(this.input, 74, FOLLOW_ALT_in_suffix630);
        if (this.state.failed == false) goto L5;
        return;
    L5:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L9;
        return;
    L9:
        if (this.input.LA(1) != 82) goto L13;
        pushFollow(FOLLOW_elementOptions_in_suffix632);
        elementOptions();
        RecognizerSharedState r10 = this.state;
        r10._fsp--;
        if (r10.failed == false) goto L13;
        return;
    L13:
        pushFollow(FOLLOW_recurse_in_suffix635);
        recurse();
        RecognizerSharedState r11 = this.state;
        r11._fsp--;
        if (r11.failed == false) goto L16;
        return;
    L16:
        int r12 = 0;
    L17:
        int r13 = this.input.LA(1);
        if (r13 != 4) goto L20;
    L66:
        pushFollow(FOLLOW_element_in_suffix637);
        element();
        RecognizerSharedState r14 = this.state;
        r14._fsp--;
        if (r14.failed == true) goto L68;
        r12 = r12 + 1;
        goto L17
    L68:
        return;
    L20:
        if (r13 == 10) goto L66;
        if (r13 == 20) goto L66;
        if (r13 == 39) goto L66;
        if (r13 == 46) goto L66;
        if (r13 == 52) goto L66;
        if (r13 == 57) goto L66;
        if (r13 == 59) goto L66;
        if (r13 == 62) goto L66;
        if (r13 == 66) goto L66;
        if (r13 == 78) goto L66;
        if (r13 == 80) goto L66;
        if (r13 == 83) goto L66;
        if (r13 < 89) goto L48;
        if (r13 <= 90) goto L66;
    L48:
        if (r13 == 98) goto L66;
        if (r13 == 100) goto L66;
        if (r12 < 1) goto L60;
        match(this.input, 3, null);
        RecognizerSharedState r15 = this.state;
        if (r15.failed == false) goto L57;
        return;
    L57:
        if (r15.backtracking != 0) goto L72;
        setAltAssoc((AltAST) r5, this.currentOuterAltNumber);
        return;
    L72:
        return;
    L60:
        RecognizerSharedState r16 = this.state;
        if (r16.backtracking <= 0) goto L65;
        r16.failed = true;
        return;
    L65:
        throw new EarlyExitException(17, this.input);
    }

    public void suffixAlt(AltAST r5, int r10) {
    }

    public final boolean synpred1_LeftRecursiveRuleWalker() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred1_LeftRecursiveRuleWalker_fragment();     // Catch: RecognitionException -> L5
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

    public final void synpred1_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        pushFollow(FOLLOW_binary_in_synpred1_LeftRecursiveRuleWalker348);
        binary();
        RecognizerSharedState r5 = this.state;
        r5._fsp--;
        boolean r10 = r5.failed;
    }

    public final boolean synpred2_LeftRecursiveRuleWalker() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred2_LeftRecursiveRuleWalker_fragment();     // Catch: RecognitionException -> L5
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

    public final void synpred2_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        pushFollow(FOLLOW_prefix_in_synpred2_LeftRecursiveRuleWalker404);
        prefix();
        RecognizerSharedState r5 = this.state;
        r5._fsp--;
        boolean r10 = r5.failed;
    }

    public final boolean synpred3_LeftRecursiveRuleWalker() {
        this.state.backtracking++;
        int r5 = this.input.mark();
        synpred3_LeftRecursiveRuleWalker_fragment();     // Catch: RecognitionException -> L5
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

    public final void synpred3_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        pushFollow(FOLLOW_suffix_in_synpred3_LeftRecursiveRuleWalker460);
        suffix();
        RecognizerSharedState r5 = this.state;
        r5._fsp--;
        boolean r10 = r5.failed;
    }

    public final GrammarAST token() throws RecognitionException {
        int r5 = this.input.LA(1);
        if (r5 == 10) goto L46;
        if (r5 == 46) goto L45;
        char r10 = 4;
        if (r5 == 62) goto L29;
        if (r5 == 66) goto L14;
        RecognizerSharedState r11 = this.state;
        if (r11.backtracking <= 0) goto L13;
        r11.failed = true;
        return null;
    L13:
        throw new NoViableAltException("", 21, 0, this.input);
    L14:
        int r12 = this.input.LA(2);
        if (r12 != 2) goto L17;
        char r13 = 5;
    L48:
        switch(r13) {
            case 1: goto L111;
            case 2: goto L92;
            case 3: goto L86;
            case 4: goto L71;
            case 5: goto L56;
            case 6: goto L50;
            default: goto L139;
        };
    L50:
        GrammarAST r14 = (GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_token823);
        RecognizerSharedState r15 = this.state;
        if (r15.failed == false) goto L54;
        return null;
    L54:
        if (r15.backtracking == 0) goto L135;
        return null;
    L135:
        return r14;
    L56:
        r14 = (GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_token809);
        if (this.state.failed == false) goto L59;
        return null;
    L59:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L62;
        return null;
    L62:
        pushFollow(FOLLOW_elementOptions_in_token811);
        elementOptions();
        RecognizerSharedState r16 = this.state;
        r16._fsp--;
        if (r16.failed == false) goto L65;
        return null;
    L65:
        match(this.input, 3, null);
        RecognizerSharedState r17 = this.state;
        if (r17.failed == false) goto L69;
        return null;
    L69:
        if (r17.backtracking == 0) goto L135;
        return null;
    L71:
        r14 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_token792);
        if (this.state.failed == false) goto L74;
        return null;
    L74:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L77;
        return null;
    L77:
        pushFollow(FOLLOW_elementOptions_in_token794);
        elementOptions();
        RecognizerSharedState r18 = this.state;
        r18._fsp--;
        if (r18.failed == false) goto L80;
        return null;
    L80:
        match(this.input, 3, null);
        RecognizerSharedState r19 = this.state;
        if (r19.failed == false) goto L84;
        return null;
    L84:
        if (r19.backtracking == 0) goto L135;
        return null;
    L86:
        r14 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_token771);
        RecognizerSharedState r110 = this.state;
        if (r110.failed == false) goto L90;
        return null;
    L90:
        if (r110.backtracking == 0) goto L135;
        return null;
    L92:
        match(this.input, 46, FOLLOW_PLUS_ASSIGN_in_token755);
        if (this.state.failed == false) goto L95;
        return null;
    L95:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L98;
        return null;
    L98:
        match(this.input, 28, FOLLOW_ID_in_token757);
        if (this.state.failed == false) goto L101;
        return null;
    L101:
        pushFollow(FOLLOW_token_in_token761);
        r14 = token();
        RecognizerSharedState r20 = this.state;
        r20._fsp--;
        if (r20.failed == false) goto L105;
        return null;
    L105:
        if (r20.backtracking == 0) goto L108;
        r14 = null;
    L108:
        match(this.input, 3, null);
        if (this.state.failed == false) goto L135;
        return r14;
    L111:
        match(this.input, 10, FOLLOW_ASSIGN_in_token740);
        if (this.state.failed == false) goto L114;
        return null;
    L114:
        match(this.input, 2, null);
        if (this.state.failed == false) goto L117;
        return null;
    L117:
        match(this.input, 28, FOLLOW_ID_in_token742);
        if (this.state.failed == false) goto L120;
        return null;
    L120:
        pushFollow(FOLLOW_token_in_token746);
        r14 = token();
        RecognizerSharedState r21 = this.state;
        r21._fsp--;
        if (r21.failed == false) goto L124;
        return null;
    L124:
        if (r21.backtracking == 0) goto L127;
        r14 = null;
    L127:
        match(this.input, 3, null);
        if (this.state.failed == false) goto L135;
        return r14;
    L139:
        return null;
    L17:
        if (r12 != 3) goto L19;
        r13 = 6;
        goto L48
    L19:
        RecognizerSharedState r22 = this.state;
        if (r22.backtracking <= 0) goto L23;
        r22.failed = true;
        return null;
    L23:
        int r23 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L26
        throw new NoViableAltException("", 21, 4, this.input);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        this.input.rewind(r23);
        throw th;
    L29:
        int r24 = this.input.LA(2);
        if (r24 == 2) goto L34;
        if (r24 != 3) goto L35;
        r10 = 3;
        goto L34
    L35:
        RecognizerSharedState r25 = this.state;
        if (r25.backtracking <= 0) goto L39;
        r25.failed = true;
        return null;
    L39:
        int r26 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L42
        throw new NoViableAltException("", 21, 3, this.input);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        this.input.rewind(r26);
        throw th;
    L34:
        r13 = r10;
        goto L48
    L45:
        r13 = 2;
        goto L48
    L46:
        r13 = 1;
        goto L48
    }

    public LeftRecursiveRuleWalker(TreeNodeStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.dfa11 = new DFA11(this, this);
        this.dfa14 = new DFA14(this, this);
    }
}
