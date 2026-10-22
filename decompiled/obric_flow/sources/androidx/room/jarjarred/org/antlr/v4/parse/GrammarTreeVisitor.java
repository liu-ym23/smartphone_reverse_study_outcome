package androidx.room.jarjarred.org.antlr.v4.parse;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer;
import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.runtime.DFA;
import androidx.room.jarjarred.org.antlr.runtime.EarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedSetException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeNodeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeParser;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeRuleReturnScope;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorManager;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LexerGrammar;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarRootAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.PredAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes.dex */
public class GrammarTreeVisitor extends TreeParser {
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
    static final short[] DFA38_accept = null;
    static final String DFA38_acceptS = "\u0004\uffff\u0001\u0001\u0001\u0002\u000e\uffff";
    static final short[] DFA38_eof = null;
    static final String DFA38_eofS = "\u0014\uffff";
    static final short[] DFA38_eot = null;
    static final String DFA38_eotS = "\u0014\uffff";
    static final char[] DFA38_max = null;
    static final String DFA38_maxS = "\u0001J\u0001\u0002\u0001d\u0001\u0002\u0002\uffff\u0002\u001c\u0001\u0002\u0001d\u0001\u001c\u0001>\u0004\u0003\u0004\u001c";
    static final char[] DFA38_min = null;
    static final String DFA38_minS = "\u0001J\u0001\u0002\u0001\u0004\u0001\u0002\u0002\uffff\u0002\u0003\u0001\u0002\u0001\u0004\u0001\u001c\u0001\u0004\b\u0003";
    static final short[] DFA38_special = null;
    static final String DFA38_specialS = "\u0014\uffff}>";
    static final short[][] DFA38_transition = null;
    static final String[] DFA38_transitionS = null;
    public static final int DOC_COMMENT = 18;
    public static final int DOLLAR = 19;
    public static final int DOT = 20;
    public static final int ELEMENT_OPTIONS = 82;
    public static final int EOF = -1;
    public static final int EPSILON = 83;
    public static final int ERRCHAR = 21;
    public static final int ESC_SEQ = 22;
    public static final int FINALLY = 23;
    public static final BitSet FOLLOW_ACTION_in_action596 = null;
    public static final BitSet FOLLOW_ACTION_in_actionElement1716 = null;
    public static final BitSet FOLLOW_ACTION_in_actionElement1724 = null;
    public static final BitSet FOLLOW_ACTION_in_block2467 = null;
    public static final BitSet FOLLOW_ACTION_in_element1905 = null;
    public static final BitSet FOLLOW_ACTION_in_element1934 = null;
    public static final BitSet FOLLOW_ACTION_in_elementOption2770 = null;
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler990 = null;
    public static final BitSet FOLLOW_ACTION_in_finallyClause1017 = null;
    public static final BitSet FOLLOW_ACTION_in_lexerElement1465 = null;
    public static final BitSet FOLLOW_ACTION_in_lexerElement1494 = null;
    public static final BitSet FOLLOW_ACTION_in_ruleAction1131 = null;
    public static final BitSet FOLLOW_ALT_in_alternative1767 = null;
    public static final BitSet FOLLOW_ALT_in_alternative1780 = null;
    public static final BitSet FOLLOW_ALT_in_lexerElements1420 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler988 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_locals1047 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_rule809 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleReturns1072 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleref2504 = null;
    public static final BitSet FOLLOW_ASSIGN_in_delegateGrammar420 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption2720 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption2744 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption2764 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption2786 = null;
    public static final BitSet FOLLOW_ASSIGN_in_option295 = null;
    public static final BitSet FOLLOW_AT_in_action585 = null;
    public static final BitSet FOLLOW_AT_in_ruleAction1127 = null;
    public static final BitSet FOLLOW_BLOCK_in_block2459 = null;
    public static final BitSet FOLLOW_BLOCK_in_lexerBlock1580 = null;
    public static final BitSet FOLLOW_BLOCK_in_lexerRuleBlock1209 = null;
    public static final BitSet FOLLOW_BLOCK_in_ruleBlock1273 = null;
    public static final BitSet FOLLOW_CATCH_in_exceptionHandler986 = null;
    public static final BitSet FOLLOW_CHANNELS_in_channelsSpec532 = null;
    public static final BitSet FOLLOW_DOT_in_atom2200 = null;
    public static final BitSet FOLLOW_DOT_in_atom2211 = null;
    public static final BitSet FOLLOW_ELEMENT_OPTIONS_in_elementOptions2667 = null;
    public static final BitSet FOLLOW_EPSILON_in_alternative1785 = null;
    public static final BitSet FOLLOW_EPSILON_in_lexerElement1517 = null;
    public static final BitSet FOLLOW_FINALLY_in_finallyClause1015 = null;
    public static final BitSet FOLLOW_FRAGMENT_in_lexerRule712 = null;
    public static final BitSet FOLLOW_GRAMMAR_in_grammarSpec85 = null;
    public static final BitSet FOLLOW_ID_in_action589 = null;
    public static final BitSet FOLLOW_ID_in_action594 = null;
    public static final BitSet FOLLOW_ID_in_atom2202 = null;
    public static final BitSet FOLLOW_ID_in_atom2213 = null;
    public static final BitSet FOLLOW_ID_in_channelSpec557 = null;
    public static final BitSet FOLLOW_ID_in_delegateGrammar424 = null;
    public static final BitSet FOLLOW_ID_in_delegateGrammar428 = null;
    public static final BitSet FOLLOW_ID_in_delegateGrammar443 = null;
    public static final BitSet FOLLOW_ID_in_elementOption2700 = null;
    public static final BitSet FOLLOW_ID_in_elementOption2724 = null;
    public static final BitSet FOLLOW_ID_in_elementOption2728 = null;
    public static final BitSet FOLLOW_ID_in_elementOption2746 = null;
    public static final BitSet FOLLOW_ID_in_elementOption2766 = null;
    public static final BitSet FOLLOW_ID_in_elementOption2788 = null;
    public static final BitSet FOLLOW_ID_in_grammarSpec87 = null;
    public static final BitSet FOLLOW_ID_in_labeledElement2042 = null;
    public static final BitSet FOLLOW_ID_in_labeledLexerElement1550 = null;
    public static final BitSet FOLLOW_ID_in_lexerCommand1813 = null;
    public static final BitSet FOLLOW_ID_in_lexerCommand1831 = null;
    public static final BitSet FOLLOW_ID_in_mode664 = null;
    public static final BitSet FOLLOW_ID_in_option297 = null;
    public static final BitSet FOLLOW_ID_in_ruleAction1129 = null;
    public static final BitSet FOLLOW_ID_in_throwsSpec1100 = null;
    public static final BitSet FOLLOW_ID_in_tokenSpec502 = null;
    public static final BitSet FOLLOW_IMPORT_in_delegateGrammars389 = null;
    public static final BitSet FOLLOW_INT_in_elementOption2792 = null;
    public static final BitSet FOLLOW_LEXER_ACTION_CALL_in_lexerCommand1811 = null;
    public static final BitSet FOLLOW_LEXER_ALT_ACTION_in_lexerAlternative1376 = null;
    public static final BitSet FOLLOW_LEXER_CHAR_SET_in_lexerAtom1672 = null;
    public static final BitSet FOLLOW_LEXER_CHAR_SET_in_setElement2434 = null;
    public static final BitSet FOLLOW_LOCALS_in_locals1045 = null;
    public static final BitSet FOLLOW_MODE_in_mode662 = null;
    public static final BitSet FOLLOW_NOT_in_astOperand2002 = null;
    public static final BitSet FOLLOW_NOT_in_astOperand2011 = null;
    public static final BitSet FOLLOW_NOT_in_element1963 = null;
    public static final BitSet FOLLOW_NOT_in_element1972 = null;
    public static final BitSet FOLLOW_NOT_in_lexerAtom1627 = null;
    public static final BitSet FOLLOW_OPTIONS_in_optionsSpec259 = null;
    public static final BitSet FOLLOW_RANGE_in_range2544 = null;
    public static final BitSet FOLLOW_RANGE_in_setElement2403 = null;
    public static final BitSet FOLLOW_RETURNS_in_ruleReturns1070 = null;
    public static final BitSet FOLLOW_RULEMODIFIERS_in_lexerRule708 = null;
    public static final BitSet FOLLOW_RULEMODIFIERS_in_rule793 = null;
    public static final BitSet FOLLOW_RULES_in_rules624 = null;
    public static final BitSet FOLLOW_RULE_REF_in_rule784 = null;
    public static final BitSet FOLLOW_RULE_REF_in_ruleref2500 = null;
    public static final BitSet FOLLOW_RULE_in_lexerRule694 = null;
    public static final BitSet FOLLOW_RULE_in_rule782 = null;
    public static final BitSet FOLLOW_SEMPRED_in_actionElement1734 = null;
    public static final BitSet FOLLOW_SEMPRED_in_actionElement1742 = null;
    public static final BitSet FOLLOW_SEMPRED_in_element1919 = null;
    public static final BitSet FOLLOW_SEMPRED_in_element1947 = null;
    public static final BitSet FOLLOW_SEMPRED_in_lexerElement1479 = null;
    public static final BitSet FOLLOW_SEMPRED_in_lexerElement1507 = null;
    public static final BitSet FOLLOW_SET_in_blockSet2297 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_elementOption2750 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_range2546 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_range2548 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement2323 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement2349 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement2407 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement2411 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal2578 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal2603 = null;
    public static final BitSet FOLLOW_THROWS_in_throwsSpec1098 = null;
    public static final BitSet FOLLOW_TOKENS_SPEC_in_tokensSpec477 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_lexerRule696 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement2337 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement2374 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal2617 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal2630 = null;
    public static final BitSet FOLLOW_WILDCARD_in_atom2225 = null;
    public static final BitSet FOLLOW_WILDCARD_in_atom2238 = null;
    public static final BitSet FOLLOW_WILDCARD_in_lexerAtom1651 = null;
    public static final BitSet FOLLOW_WILDCARD_in_lexerAtom1664 = null;
    public static final BitSet FOLLOW_action_in_prequelConstruct234 = null;
    public static final BitSet FOLLOW_alternative_in_block2470 = null;
    public static final BitSet FOLLOW_alternative_in_outerAlternative1354 = null;
    public static final BitSet FOLLOW_atom_in_astOperand1996 = null;
    public static final BitSet FOLLOW_atom_in_element1893 = null;
    public static final BitSet FOLLOW_blockSet_in_astOperand2004 = null;
    public static final BitSet FOLLOW_blockSet_in_atom2262 = null;
    public static final BitSet FOLLOW_blockSet_in_element1965 = null;
    public static final BitSet FOLLOW_blockSet_in_lexerAtom1629 = null;
    public static final BitSet FOLLOW_blockSet_in_lexerAtom1640 = null;
    public static final BitSet FOLLOW_blockSuffix_in_lexerSubrule2103 = null;
    public static final BitSet FOLLOW_blockSuffix_in_subrule2069 = null;
    public static final BitSet FOLLOW_block_in_astOperand2013 = null;
    public static final BitSet FOLLOW_block_in_element1974 = null;
    public static final BitSet FOLLOW_block_in_labeledLexerElement1555 = null;
    public static final BitSet FOLLOW_block_in_subrule2071 = null;
    public static final BitSet FOLLOW_block_in_subrule2078 = null;
    public static final BitSet FOLLOW_channelSpec_in_channelsSpec534 = null;
    public static final BitSet FOLLOW_channelsSpec_in_prequelConstruct224 = null;
    public static final BitSet FOLLOW_delegateGrammar_in_delegateGrammars391 = null;
    public static final BitSet FOLLOW_delegateGrammars_in_prequelConstruct204 = null;
    public static final BitSet FOLLOW_ebnfSuffix_in_blockSuffix2139 = null;
    public static final BitSet FOLLOW_elementOption_in_elementOptions2669 = null;
    public static final BitSet FOLLOW_elementOptions_in_actionElement1726 = null;
    public static final BitSet FOLLOW_elementOptions_in_actionElement1744 = null;
    public static final BitSet FOLLOW_elementOptions_in_alternative1769 = null;
    public static final BitSet FOLLOW_elementOptions_in_alternative1782 = null;
    public static final BitSet FOLLOW_elementOptions_in_atom2227 = null;
    public static final BitSet FOLLOW_elementOptions_in_element1936 = null;
    public static final BitSet FOLLOW_elementOptions_in_element1949 = null;
    public static final BitSet FOLLOW_elementOptions_in_lexerAtom1653 = null;
    public static final BitSet FOLLOW_elementOptions_in_lexerElement1496 = null;
    public static final BitSet FOLLOW_elementOptions_in_lexerElement1509 = null;
    public static final BitSet FOLLOW_elementOptions_in_ruleref2507 = null;
    public static final BitSet FOLLOW_elementOptions_in_setElement2325 = null;
    public static final BitSet FOLLOW_elementOptions_in_setElement2339 = null;
    public static final BitSet FOLLOW_elementOptions_in_terminal2580 = null;
    public static final BitSet FOLLOW_elementOptions_in_terminal2619 = null;
    public static final BitSet FOLLOW_element_in_alternative1772 = null;
    public static final BitSet FOLLOW_element_in_labeledElement2044 = null;
    public static final BitSet FOLLOW_exceptionGroup_in_rule910 = null;
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup957 = null;
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup960 = null;
    public static final BitSet FOLLOW_labeledElement_in_element1888 = null;
    public static final BitSet FOLLOW_labeledLexerElement_in_lexerElement1448 = null;
    public static final BitSet FOLLOW_lexerAlternative_in_lexerBlock1585 = null;
    public static final BitSet FOLLOW_lexerAlternative_in_lexerOuterAlternative1332 = null;
    public static final BitSet FOLLOW_lexerAtom_in_labeledLexerElement1553 = null;
    public static final BitSet FOLLOW_lexerAtom_in_lexerElement1453 = null;
    public static final BitSet FOLLOW_lexerBlock_in_lexerSubrule2105 = null;
    public static final BitSet FOLLOW_lexerBlock_in_lexerSubrule2112 = null;
    public static final BitSet FOLLOW_lexerCommandExpr_in_lexerCommand1815 = null;
    public static final BitSet FOLLOW_lexerCommand_in_lexerAlternative1380 = null;
    public static final BitSet FOLLOW_lexerElement_in_lexerElements1422 = null;
    public static final BitSet FOLLOW_lexerElements_in_lexerAlternative1378 = null;
    public static final BitSet FOLLOW_lexerElements_in_lexerAlternative1392 = null;
    public static final BitSet FOLLOW_lexerOuterAlternative_in_lexerRuleBlock1228 = null;
    public static final BitSet FOLLOW_lexerRuleBlock_in_lexerRule737 = null;
    public static final BitSet FOLLOW_lexerRule_in_mode668 = null;
    public static final BitSet FOLLOW_lexerRule_in_rules631 = null;
    public static final BitSet FOLLOW_lexerSubrule_in_lexerElement1458 = null;
    public static final BitSet FOLLOW_locals_in_rule848 = null;
    public static final BitSet FOLLOW_mode_in_grammarSpec125 = null;
    public static final BitSet FOLLOW_optionValue_in_option301 = null;
    public static final BitSet FOLLOW_option_in_optionsSpec261 = null;
    public static final BitSet FOLLOW_optionsSpec_in_block2461 = null;
    public static final BitSet FOLLOW_optionsSpec_in_lexerBlock1582 = null;
    public static final BitSet FOLLOW_optionsSpec_in_prequelConstruct194 = null;
    public static final BitSet FOLLOW_optionsSpec_in_rule863 = null;
    public static final BitSet FOLLOW_outerAlternative_in_ruleBlock1292 = null;
    public static final BitSet FOLLOW_prequelConstruct_in_prequelConstructs167 = null;
    public static final BitSet FOLLOW_prequelConstructs_in_grammarSpec106 = null;
    public static final BitSet FOLLOW_range_in_element1957 = null;
    public static final BitSet FOLLOW_range_in_lexerAtom1682 = null;
    public static final BitSet FOLLOW_ruleAction_in_block2464 = null;
    public static final BitSet FOLLOW_ruleAction_in_rule877 = null;
    public static final BitSet FOLLOW_ruleBlock_in_rule908 = null;
    public static final BitSet FOLLOW_ruleModifier_in_rule798 = null;
    public static final BitSet FOLLOW_ruleReturns_in_rule822 = null;
    public static final BitSet FOLLOW_rule_in_rules629 = null;
    public static final BitSet FOLLOW_ruleref_in_atom2215 = null;
    public static final BitSet FOLLOW_ruleref_in_atom2272 = null;
    public static final BitSet FOLLOW_ruleref_in_lexerAtom1692 = null;
    public static final BitSet FOLLOW_rules_in_grammarSpec123 = null;
    public static final BitSet FOLLOW_setElement_in_blockSet2299 = null;
    public static final BitSet FOLLOW_set_in_labeledElement2036 = null;
    public static final BitSet FOLLOW_set_in_labeledLexerElement1544 = null;
    public static final BitSet FOLLOW_subrule_in_element1898 = null;
    public static final BitSet FOLLOW_terminal_in_atom2204 = null;
    public static final BitSet FOLLOW_terminal_in_atom2254 = null;
    public static final BitSet FOLLOW_terminal_in_lexerAtom1616 = null;
    public static final BitSet FOLLOW_throwsSpec_in_rule835 = null;
    public static final BitSet FOLLOW_tokenSpec_in_tokensSpec479 = null;
    public static final BitSet FOLLOW_tokensSpec_in_prequelConstruct214 = null;
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
    public String currentModeName;
    public int currentOuterAltNumber;
    public GrammarAST currentOuterAltRoot;
    public GrammarAST currentRuleAST;
    public String currentRuleName;
    protected DFA38 dfa38;
    public String grammarName;
    public int rewriteEBNFLevel;

    public class DFA38 extends DFA {
        final /* synthetic */ GrammarTreeVisitor this$0;

        public DFA38(GrammarTreeVisitor r5, BaseRecognizer r10) {
            this.this$0 = r5;
            this.recognizer = r10;
            this.decisionNumber = 38;
            this.eot = GrammarTreeVisitor.DFA38_eot;
            this.eof = GrammarTreeVisitor.DFA38_eof;
            this.min = GrammarTreeVisitor.DFA38_min;
            this.max = GrammarTreeVisitor.DFA38_max;
            this.accept = GrammarTreeVisitor.DFA38_accept;
            this.special = GrammarTreeVisitor.DFA38_special;
            this.transition = GrammarTreeVisitor.DFA38_transition;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.DFA
        public String getDescription() {
            return "796:1: alternative : ( ^( ALT ( elementOptions )? ( element )+ ) | ^( ALT ( elementOptions )? EPSILON ) );";
        }
    }

    public static class actionElement_return extends TreeRuleReturnScope {
        public actionElement_return() {
        }
    }

    public static class action_return extends TreeRuleReturnScope {
        public action_return() {
        }
    }

    public static class alternative_return extends TreeRuleReturnScope {
        public alternative_return() {
        }
    }

    public static class astOperand_return extends TreeRuleReturnScope {
        public astOperand_return() {
        }
    }

    public static class atom_return extends TreeRuleReturnScope {
        public atom_return() {
        }
    }

    public static class blockSet_return extends TreeRuleReturnScope {
        public blockSet_return() {
        }
    }

    public static class blockSuffix_return extends TreeRuleReturnScope {
        public blockSuffix_return() {
        }
    }

    public static class block_return extends TreeRuleReturnScope {
        public block_return() {
        }
    }

    public static class channelSpec_return extends TreeRuleReturnScope {
        public channelSpec_return() {
        }
    }

    public static class channelsSpec_return extends TreeRuleReturnScope {
        public channelsSpec_return() {
        }
    }

    public static class delegateGrammar_return extends TreeRuleReturnScope {
        public delegateGrammar_return() {
        }
    }

    public static class delegateGrammars_return extends TreeRuleReturnScope {
        public delegateGrammars_return() {
        }
    }

    public static class ebnfSuffix_return extends TreeRuleReturnScope {
        public ebnfSuffix_return() {
        }
    }

    public static class elementOption_return extends TreeRuleReturnScope {
        public elementOption_return() {
        }
    }

    public static class elementOptions_return extends TreeRuleReturnScope {
        public elementOptions_return() {
        }
    }

    public static class element_return extends TreeRuleReturnScope {
        public element_return() {
        }
    }

    public static class exceptionGroup_return extends TreeRuleReturnScope {
        public exceptionGroup_return() {
        }
    }

    public static class exceptionHandler_return extends TreeRuleReturnScope {
        public exceptionHandler_return() {
        }
    }

    public static class finallyClause_return extends TreeRuleReturnScope {
        public finallyClause_return() {
        }
    }

    public static class grammarSpec_return extends TreeRuleReturnScope {
        public grammarSpec_return() {
        }
    }

    public static class labeledElement_return extends TreeRuleReturnScope {
        public labeledElement_return() {
        }
    }

    public static class labeledLexerElement_return extends TreeRuleReturnScope {
        public labeledLexerElement_return() {
        }
    }

    public static class lexerAlternative_return extends TreeRuleReturnScope {
        public lexerAlternative_return() {
        }
    }

    public static class lexerAtom_return extends TreeRuleReturnScope {
        public lexerAtom_return() {
        }
    }

    public static class lexerBlock_return extends TreeRuleReturnScope {
        public lexerBlock_return() {
        }
    }

    public static class lexerCommandExpr_return extends TreeRuleReturnScope {
        public lexerCommandExpr_return() {
        }
    }

    public static class lexerCommand_return extends TreeRuleReturnScope {
        public lexerCommand_return() {
        }
    }

    public static class lexerElement_return extends TreeRuleReturnScope {
        public lexerElement_return() {
        }
    }

    public static class lexerElements_return extends TreeRuleReturnScope {
        public lexerElements_return() {
        }
    }

    public static class lexerOuterAlternative_return extends TreeRuleReturnScope {
        public lexerOuterAlternative_return() {
        }
    }

    public static class lexerRuleBlock_return extends TreeRuleReturnScope {
        public lexerRuleBlock_return() {
        }
    }

    public static class lexerRule_return extends TreeRuleReturnScope {
        public lexerRule_return() {
        }
    }

    public static class lexerSubrule_return extends TreeRuleReturnScope {
        public lexerSubrule_return() {
        }
    }

    public static class locals_return extends TreeRuleReturnScope {
        public locals_return() {
        }
    }

    public static class mode_return extends TreeRuleReturnScope {
        public mode_return() {
        }
    }

    public static class optionValue_return extends TreeRuleReturnScope {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f651v;

        public optionValue_return() {
        }
    }

    public static class option_return extends TreeRuleReturnScope {
        public option_return() {
        }
    }

    public static class optionsSpec_return extends TreeRuleReturnScope {
        public optionsSpec_return() {
        }
    }

    public static class outerAlternative_return extends TreeRuleReturnScope {
        public outerAlternative_return() {
        }
    }

    public static class prequelConstruct_return extends TreeRuleReturnScope {
        public prequelConstruct_return() {
        }
    }

    public static class prequelConstructs_return extends TreeRuleReturnScope {
        public GrammarAST firstOne;

        public prequelConstructs_return() {
            this.firstOne = null;
        }
    }

    public static class range_return extends TreeRuleReturnScope {
        public range_return() {
        }
    }

    public static class ruleAction_return extends TreeRuleReturnScope {
        public ruleAction_return() {
        }
    }

    public static class ruleBlock_return extends TreeRuleReturnScope {
        public ruleBlock_return() {
        }
    }

    public static class ruleModifier_return extends TreeRuleReturnScope {
        public ruleModifier_return() {
        }
    }

    public static class ruleReturns_return extends TreeRuleReturnScope {
        public ruleReturns_return() {
        }
    }

    public static class rule_return extends TreeRuleReturnScope {
        public rule_return() {
        }
    }

    public static class ruleref_return extends TreeRuleReturnScope {
        public ruleref_return() {
        }
    }

    public static class rules_return extends TreeRuleReturnScope {
        public rules_return() {
        }
    }

    public static class setElement_return extends TreeRuleReturnScope {
        public setElement_return() {
        }
    }

    public static class subrule_return extends TreeRuleReturnScope {
        public subrule_return() {
        }
    }

    public static class terminal_return extends TreeRuleReturnScope {
        public terminal_return() {
        }
    }

    public static class throwsSpec_return extends TreeRuleReturnScope {
        public throwsSpec_return() {
        }
    }

    public static class tokenSpec_return extends TreeRuleReturnScope {
        public tokenSpec_return() {
        }
    }

    public static class tokensSpec_return extends TreeRuleReturnScope {
        public tokensSpec_return() {
        }
    }

    static {
        tokenNames = new String[]{Grammar.INVALID_RULE_NAME, "<EOR>", "<DOWN>", "<UP>", "ACTION", "ACTION_CHAR_LITERAL", "ACTION_ESC", "ACTION_STRING_LITERAL", "ARG_ACTION", "ARG_OR_CHARSET", "ASSIGN", "AT", "CATCH", "CHANNELS", "COLON", "COLONCOLON", "COMMA", "COMMENT", "DOC_COMMENT", "DOLLAR", "DOT", "ERRCHAR", "ESC_SEQ", "FINALLY", "FRAGMENT", "GRAMMAR", "GT", "HEX_DIGIT", "ID", "IMPORT", "INT", "LEXER", "LEXER_CHAR_SET", "LOCALS", "LPAREN", "LT", "MODE", "NESTED_ACTION", "NLCHARS", "NOT", "NameChar", "NameStartChar", "OPTIONS", "OR", "PARSER", "PLUS", "PLUS_ASSIGN", "POUND", "PRIVATE", "PROTECTED", "PUBLIC", "QUESTION", "RANGE", "RARROW", "RBRACE", "RETURNS", "RPAREN", "RULE_REF", "SEMI", "SEMPRED", "SRC", "STAR", "STRING_LITERAL", "SYNPRED", "THROWS", "TOKENS_SPEC", "TOKEN_REF", "TREE_GRAMMAR", "UNICODE_ESC", "UNICODE_EXTENDED_ESC", "UnicodeBOM", "WS", "WSCHARS", "WSNLCHARS", "ALT", "ALTLIST", "ARG", "ARGLIST", "BLOCK", "CHAR_RANGE", "CLOSURE", "COMBINED", "ELEMENT_OPTIONS", "EPSILON", "INITACTION", "LABEL", "LEXER_ACTION_CALL", "LEXER_ALT_ACTION", "LIST", "OPTIONAL", "POSITIVE_CLOSURE", "PREC_RULE", "RESULT", "RET", "RULE", "RULEACTIONS", "RULEMODIFIERS", "RULES", "SET", "TEMPLATE", "WILDCARD"};
        String[] r5 = {"\u0001\u0001", "\u0001\u0002", "\u0001\u0004\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0001\uffff\u0001\u0003\u0001\u0005\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u0006", "", "", "\u0001\t\u0006\uffff\u0001\b\u0011\uffff\u0001\u0007", "\u0001\t\u0006\uffff\u0001\b\u0011\uffff\u0001\u0007", "\u0001\n", "\u0001\u0004\u0005\uffff\u0001\u0004\t\uffff\u0001\u0004\u0012\uffff\u0001\u0004\u0006\uffff\u0001\u0004\u0005\uffff\u0001\u0004\u0004\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0004\u0003\uffff\u0001\u0004\u000b\uffff\u0001\u0004\u0001\uffff\u0001\u0004\u0002\uffff\u0001\u0005\u0005\uffff\u0002\u0004\u0007\uffff\u0001\u0004\u0001\uffff\u0001\u0004", "\u0001\u000b", "\u0001\u000e\u0017\uffff\u0001\f\u0001\uffff\u0001\u000f\u001f\uffff\u0001\r", "\u0001\u0010", "\u0001\u0011", "\u0001\u0012", "\u0001\u0013", "\u0001\t\u0006\uffff\u0001\b\u0011\uffff\u0001\u0007", "\u0001\t\u0006\uffff\u0001\b\u0011\uffff\u0001\u0007", "\u0001\t\u0006\uffff\u0001\b\u0011\uffff\u0001\u0007", "\u0001\t\u0006\uffff\u0001\b\u0011\uffff\u0001\u0007"};
        DFA38_transitionS = r5;
        DFA38_eot = DFA.unpackEncodedString("\u0014\uffff");
        DFA38_eof = DFA.unpackEncodedString("\u0014\uffff");
        DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
        DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
        DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
        DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
        int r10 = r5.length;
        DFA38_transition = new short[r10][];
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        DFA38_transition[r11] = DFA.unpackEncodedString(DFA38_transitionS[r11]);
        r11 = r11 + 1;
        goto L3
    L5:
        FOLLOW_GRAMMAR_in_grammarSpec85 = new BitSet(new long[]{4});
        FOLLOW_ID_in_grammarSpec87 = new BitSet(new long[]{4398583392256L, 8589934594L});
        FOLLOW_prequelConstructs_in_grammarSpec106 = new BitSet(new long[]{0, 8589934592L});
        FOLLOW_rules_in_grammarSpec123 = new BitSet(new long[]{68719476744L});
        FOLLOW_mode_in_grammarSpec125 = new BitSet(new long[]{68719476744L});
        FOLLOW_prequelConstruct_in_prequelConstructs167 = new BitSet(new long[]{4398583392258L, 2});
        FOLLOW_optionsSpec_in_prequelConstruct194 = new BitSet(new long[]{2});
        FOLLOW_delegateGrammars_in_prequelConstruct204 = new BitSet(new long[]{2});
        FOLLOW_tokensSpec_in_prequelConstruct214 = new BitSet(new long[]{2});
        FOLLOW_channelsSpec_in_prequelConstruct224 = new BitSet(new long[]{2});
        FOLLOW_action_in_prequelConstruct234 = new BitSet(new long[]{2});
        FOLLOW_OPTIONS_in_optionsSpec259 = new BitSet(new long[]{4});
        FOLLOW_option_in_optionsSpec261 = new BitSet(new long[]{1032});
        FOLLOW_ASSIGN_in_option295 = new BitSet(new long[]{4});
        FOLLOW_ID_in_option297 = new BitSet(new long[]{4611686019769565184L});
        FOLLOW_optionValue_in_option301 = new BitSet(new long[]{8});
        FOLLOW_IMPORT_in_delegateGrammars389 = new BitSet(new long[]{4});
        FOLLOW_delegateGrammar_in_delegateGrammars391 = new BitSet(new long[]{268436488});
        FOLLOW_ASSIGN_in_delegateGrammar420 = new BitSet(new long[]{4});
        FOLLOW_ID_in_delegateGrammar424 = new BitSet(new long[]{268435456});
        FOLLOW_ID_in_delegateGrammar428 = new BitSet(new long[]{8});
        FOLLOW_ID_in_delegateGrammar443 = new BitSet(new long[]{2});
        FOLLOW_TOKENS_SPEC_in_tokensSpec477 = new BitSet(new long[]{4});
        FOLLOW_tokenSpec_in_tokensSpec479 = new BitSet(new long[]{268435464});
        FOLLOW_ID_in_tokenSpec502 = new BitSet(new long[]{2});
        FOLLOW_CHANNELS_in_channelsSpec532 = new BitSet(new long[]{4});
        FOLLOW_channelSpec_in_channelsSpec534 = new BitSet(new long[]{268435464});
        FOLLOW_ID_in_channelSpec557 = new BitSet(new long[]{2});
        FOLLOW_AT_in_action585 = new BitSet(new long[]{4});
        FOLLOW_ID_in_action589 = new BitSet(new long[]{268435456});
        FOLLOW_ID_in_action594 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_action596 = new BitSet(new long[]{8});
        FOLLOW_RULES_in_rules624 = new BitSet(new long[]{4});
        FOLLOW_rule_in_rules629 = new BitSet(new long[]{8, 1073741824});
        FOLLOW_lexerRule_in_rules631 = new BitSet(new long[]{8, 1073741824});
        FOLLOW_MODE_in_mode662 = new BitSet(new long[]{4});
        FOLLOW_ID_in_mode664 = new BitSet(new long[]{8, 1073741824});
        FOLLOW_lexerRule_in_mode668 = new BitSet(new long[]{8, 1073741824});
        FOLLOW_RULE_in_lexerRule694 = new BitSet(new long[]{4});
        FOLLOW_TOKEN_REF_in_lexerRule696 = new BitSet(new long[]{0, 4294983680L});
        FOLLOW_RULEMODIFIERS_in_lexerRule708 = new BitSet(new long[]{4});
        FOLLOW_FRAGMENT_in_lexerRule712 = new BitSet(new long[]{8});
        FOLLOW_lexerRuleBlock_in_lexerRule737 = new BitSet(new long[]{8});
        FOLLOW_RULE_in_rule782 = new BitSet(new long[]{4});
        FOLLOW_RULE_REF_in_rule784 = new BitSet(new long[]{36033203655411968L, 4294983681L});
        FOLLOW_RULEMODIFIERS_in_rule793 = new BitSet(new long[]{4});
        FOLLOW_ruleModifier_in_rule798 = new BitSet(new long[]{1970324853751816L});
        FOLLOW_ARG_ACTION_in_rule809 = new BitSet(new long[]{36033203655411712L, 16385});
        FOLLOW_ruleReturns_in_rule822 = new BitSet(new long[]{4406636447744L, 16385});
        FOLLOW_throwsSpec_in_rule835 = new BitSet(new long[]{4406636447744L, Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_locals_in_rule848 = new BitSet(new long[]{4398046513152L, Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_optionsSpec_in_rule863 = new BitSet(new long[]{4398046513152L, Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_ruleAction_in_rule877 = new BitSet(new long[]{4398046513152L, Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_ruleBlock_in_rule908 = new BitSet(new long[]{8392712});
        FOLLOW_exceptionGroup_in_rule910 = new BitSet(new long[]{8});
        FOLLOW_exceptionHandler_in_exceptionGroup957 = new BitSet(new long[]{8392706});
        FOLLOW_finallyClause_in_exceptionGroup960 = new BitSet(new long[]{2});
        FOLLOW_CATCH_in_exceptionHandler986 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_exceptionHandler988 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_exceptionHandler990 = new BitSet(new long[]{8});
        FOLLOW_FINALLY_in_finallyClause1015 = new BitSet(new long[]{4});
        FOLLOW_ACTION_in_finallyClause1017 = new BitSet(new long[]{8});
        FOLLOW_LOCALS_in_locals1045 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_locals1047 = new BitSet(new long[]{8});
        FOLLOW_RETURNS_in_ruleReturns1070 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_ruleReturns1072 = new BitSet(new long[]{8});
        FOLLOW_THROWS_in_throwsSpec1098 = new BitSet(new long[]{4});
        FOLLOW_ID_in_throwsSpec1100 = new BitSet(new long[]{268435464});
        FOLLOW_AT_in_ruleAction1127 = new BitSet(new long[]{4});
        FOLLOW_ID_in_ruleAction1129 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_ruleAction1131 = new BitSet(new long[]{8});
        FOLLOW_BLOCK_in_lexerRuleBlock1209 = new BitSet(new long[]{4});
        FOLLOW_lexerOuterAlternative_in_lexerRuleBlock1228 = new BitSet(new long[]{8, 8389632});
        FOLLOW_BLOCK_in_ruleBlock1273 = new BitSet(new long[]{4});
        FOLLOW_outerAlternative_in_ruleBlock1292 = new BitSet(new long[]{8, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_lexerAlternative_in_lexerOuterAlternative1332 = new BitSet(new long[]{2});
        FOLLOW_alternative_in_outerAlternative1354 = new BitSet(new long[]{2});
        FOLLOW_LEXER_ALT_ACTION_in_lexerAlternative1376 = new BitSet(new long[]{4});
        FOLLOW_lexerElements_in_lexerAlternative1378 = new BitSet(new long[]{268435456, 4194304});
        FOLLOW_lexerCommand_in_lexerAlternative1380 = new BitSet(new long[]{268435464, 4194304});
        FOLLOW_lexerElements_in_lexerAlternative1392 = new BitSet(new long[]{2});
        FOLLOW_ALT_in_lexerElements1420 = new BitSet(new long[]{4});
        FOLLOW_lexerElement_in_lexerElements1422 = new BitSet(new long[]{5336836481228997656L, 86000615428L});
        FOLLOW_labeledLexerElement_in_lexerElement1448 = new BitSet(new long[]{2});
        FOLLOW_lexerAtom_in_lexerElement1453 = new BitSet(new long[]{2});
        FOLLOW_lexerSubrule_in_lexerElement1458 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_lexerElement1465 = new BitSet(new long[]{2});
        FOLLOW_SEMPRED_in_lexerElement1479 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_lexerElement1494 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_lexerElement1496 = new BitSet(new long[]{8});
        FOLLOW_SEMPRED_in_lexerElement1507 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_lexerElement1509 = new BitSet(new long[]{8});
        FOLLOW_EPSILON_in_lexerElement1517 = new BitSet(new long[]{2});
        FOLLOW_set_in_labeledLexerElement1544 = new BitSet(new long[]{4});
        FOLLOW_ID_in_labeledLexerElement1550 = new BitSet(new long[]{4760305360181395456L, 85899362308L});
        FOLLOW_lexerAtom_in_labeledLexerElement1553 = new BitSet(new long[]{8});
        FOLLOW_block_in_labeledLexerElement1555 = new BitSet(new long[]{8});
        FOLLOW_BLOCK_in_lexerBlock1580 = new BitSet(new long[]{4});
        FOLLOW_optionsSpec_in_lexerBlock1582 = new BitSet(new long[]{0, 8389632});
        FOLLOW_lexerAlternative_in_lexerBlock1585 = new BitSet(new long[]{8, 8389632});
        FOLLOW_terminal_in_lexerAtom1616 = new BitSet(new long[]{2});
        FOLLOW_NOT_in_lexerAtom1627 = new BitSet(new long[]{4});
        FOLLOW_blockSet_in_lexerAtom1629 = new BitSet(new long[]{8});
        FOLLOW_blockSet_in_lexerAtom1640 = new BitSet(new long[]{2});
        FOLLOW_WILDCARD_in_lexerAtom1651 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_lexerAtom1653 = new BitSet(new long[]{8});
        FOLLOW_WILDCARD_in_lexerAtom1664 = new BitSet(new long[]{2});
        FOLLOW_LEXER_CHAR_SET_in_lexerAtom1672 = new BitSet(new long[]{2});
        FOLLOW_range_in_lexerAtom1682 = new BitSet(new long[]{2});
        FOLLOW_ruleref_in_lexerAtom1692 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_actionElement1716 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_actionElement1724 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_actionElement1726 = new BitSet(new long[]{8});
        FOLLOW_SEMPRED_in_actionElement1734 = new BitSet(new long[]{2});
        FOLLOW_SEMPRED_in_actionElement1742 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_actionElement1744 = new BitSet(new long[]{8});
        FOLLOW_ALT_in_alternative1767 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_alternative1769 = new BitSet(new long[]{5336836476935078928L, 86000091140L});
        FOLLOW_element_in_alternative1772 = new BitSet(new long[]{5336836476935078936L, 86000091140L});
        FOLLOW_ALT_in_alternative1780 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_alternative1782 = new BitSet(new long[]{0, 524288});
        FOLLOW_EPSILON_in_alternative1785 = new BitSet(new long[]{8});
        FOLLOW_LEXER_ACTION_CALL_in_lexerCommand1811 = new BitSet(new long[]{4});
        FOLLOW_ID_in_lexerCommand1813 = new BitSet(new long[]{1342177280});
        FOLLOW_lexerCommandExpr_in_lexerCommand1815 = new BitSet(new long[]{8});
        FOLLOW_ID_in_lexerCommand1831 = new BitSet(new long[]{2});
        FOLLOW_labeledElement_in_element1888 = new BitSet(new long[]{2});
        FOLLOW_atom_in_element1893 = new BitSet(new long[]{2});
        FOLLOW_subrule_in_element1898 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_element1905 = new BitSet(new long[]{2});
        FOLLOW_SEMPRED_in_element1919 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_element1934 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_element1936 = new BitSet(new long[]{8});
        FOLLOW_SEMPRED_in_element1947 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_element1949 = new BitSet(new long[]{8});
        FOLLOW_range_in_element1957 = new BitSet(new long[]{2});
        FOLLOW_NOT_in_element1963 = new BitSet(new long[]{4});
        FOLLOW_blockSet_in_element1965 = new BitSet(new long[]{8});
        FOLLOW_NOT_in_element1972 = new BitSet(new long[]{4});
        FOLLOW_block_in_element1974 = new BitSet(new long[]{8});
        FOLLOW_atom_in_astOperand1996 = new BitSet(new long[]{2});
        FOLLOW_NOT_in_astOperand2002 = new BitSet(new long[]{4});
        FOLLOW_blockSet_in_astOperand2004 = new BitSet(new long[]{8});
        FOLLOW_NOT_in_astOperand2011 = new BitSet(new long[]{4});
        FOLLOW_block_in_astOperand2013 = new BitSet(new long[]{8});
        FOLLOW_set_in_labeledElement2036 = new BitSet(new long[]{4});
        FOLLOW_ID_in_labeledElement2042 = new BitSet(new long[]{5336836476935078928L, 86000091140L});
        FOLLOW_element_in_labeledElement2044 = new BitSet(new long[]{8});
        FOLLOW_blockSuffix_in_subrule2069 = new BitSet(new long[]{4});
        FOLLOW_block_in_subrule2071 = new BitSet(new long[]{8});
        FOLLOW_block_in_subrule2078 = new BitSet(new long[]{2});
        FOLLOW_blockSuffix_in_lexerSubrule2103 = new BitSet(new long[]{4});
        FOLLOW_lexerBlock_in_lexerSubrule2105 = new BitSet(new long[]{8});
        FOLLOW_lexerBlock_in_lexerSubrule2112 = new BitSet(new long[]{2});
        FOLLOW_ebnfSuffix_in_blockSuffix2139 = new BitSet(new long[]{2});
        FOLLOW_DOT_in_atom2200 = new BitSet(new long[]{4});
        FOLLOW_ID_in_atom2202 = new BitSet(new long[]{4611686018427387904L, 4});
        FOLLOW_terminal_in_atom2204 = new BitSet(new long[]{8});
        FOLLOW_DOT_in_atom2211 = new BitSet(new long[]{4});
        FOLLOW_ID_in_atom2213 = new BitSet(new long[]{144115188075855872L});
        FOLLOW_ruleref_in_atom2215 = new BitSet(new long[]{8});
        FOLLOW_WILDCARD_in_atom2225 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_atom2227 = new BitSet(new long[]{8});
        FOLLOW_WILDCARD_in_atom2238 = new BitSet(new long[]{2});
        FOLLOW_terminal_in_atom2254 = new BitSet(new long[]{2});
        FOLLOW_blockSet_in_atom2262 = new BitSet(new long[]{2});
        FOLLOW_ruleref_in_atom2272 = new BitSet(new long[]{2});
        FOLLOW_SET_in_blockSet2297 = new BitSet(new long[]{4});
        FOLLOW_setElement_in_blockSet2299 = new BitSet(new long[]{4616189622349725704L, 4});
        FOLLOW_STRING_LITERAL_in_setElement2323 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_setElement2325 = new BitSet(new long[]{8});
        FOLLOW_TOKEN_REF_in_setElement2337 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_setElement2339 = new BitSet(new long[]{8});
        FOLLOW_STRING_LITERAL_in_setElement2349 = new BitSet(new long[]{2});
        FOLLOW_TOKEN_REF_in_setElement2374 = new BitSet(new long[]{2});
        FOLLOW_RANGE_in_setElement2403 = new BitSet(new long[]{4});
        FOLLOW_STRING_LITERAL_in_setElement2407 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_setElement2411 = new BitSet(new long[]{8});
        FOLLOW_LEXER_CHAR_SET_in_setElement2434 = new BitSet(new long[]{2});
        FOLLOW_BLOCK_in_block2459 = new BitSet(new long[]{4});
        FOLLOW_optionsSpec_in_block2461 = new BitSet(new long[]{2064, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_ruleAction_in_block2464 = new BitSet(new long[]{2064, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_ACTION_in_block2467 = new BitSet(new long[]{0, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_alternative_in_block2470 = new BitSet(new long[]{8, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_RULE_REF_in_ruleref2500 = new BitSet(new long[]{4});
        FOLLOW_ARG_ACTION_in_ruleref2504 = new BitSet(new long[]{8, 262144});
        FOLLOW_elementOptions_in_ruleref2507 = new BitSet(new long[]{8});
        FOLLOW_RANGE_in_range2544 = new BitSet(new long[]{4});
        FOLLOW_STRING_LITERAL_in_range2546 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_range2548 = new BitSet(new long[]{8});
        FOLLOW_STRING_LITERAL_in_terminal2578 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_terminal2580 = new BitSet(new long[]{8});
        FOLLOW_STRING_LITERAL_in_terminal2603 = new BitSet(new long[]{2});
        FOLLOW_TOKEN_REF_in_terminal2617 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_terminal2619 = new BitSet(new long[]{8});
        FOLLOW_TOKEN_REF_in_terminal2630 = new BitSet(new long[]{2});
        FOLLOW_ELEMENT_OPTIONS_in_elementOptions2667 = new BitSet(new long[]{4});
        FOLLOW_elementOption_in_elementOptions2669 = new BitSet(new long[]{268436488});
        FOLLOW_ID_in_elementOption2700 = new BitSet(new long[]{2});
        FOLLOW_ASSIGN_in_elementOption2720 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption2724 = new BitSet(new long[]{268435456});
        FOLLOW_ID_in_elementOption2728 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption2744 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption2746 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_elementOption2750 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption2764 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption2766 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_elementOption2770 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption2786 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption2788 = new BitSet(new long[]{1073741824});
        FOLLOW_INT_in_elementOption2792 = new BitSet(new long[]{8});
    }

    public GrammarTreeVisitor(TreeNodeStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public final action_return action() throws RecognitionException {
        action_return r5 = new action_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterAction((GrammarAST) r10);
        match(this.input, 11, FOLLOW_AT_in_action585);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this.input.LA(1) == 28) goto L6;
    L12:
        GrammarAST r11 = null;
    L13:
        GrammarAST r12 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_action594);     // Catch: Throwable -> L8 RecognitionException -> L10
        GrammarAST r13 = (GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_action596);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        globalNamedAction(r11, r12, (ActionAST) r13);     // Catch: Throwable -> L8 RecognitionException -> L10
        exitAction((GrammarAST) r5.start);     // Catch: Throwable -> L8 RecognitionException -> L10
    L17:
        return r5;
    L6:
        if (this.input.LA(2) != 28) goto L12;
        r11 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_action589);     // Catch: Throwable -> L8 RecognitionException -> L10
    L10:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L8:
        th = move-exception;
        throw th;
    }

    public final actionElement_return actionElement() throws RecognitionException {
        actionElement_return r5 = new actionElement_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterActionElement((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r11 != 4) goto L21;
        int r12 = this.input.LA(2);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r12 != 2) goto L9;
        char r13 = 2;
    L27:
        if (r13 != 1) goto L29;
        match(this.input, 4, FOLLOW_ACTION_in_actionElement1716);     // Catch: Throwable -> L17 RecognitionException -> L19
    L37:
        exitActionElement((GrammarAST) r5.start);     // Catch: Throwable -> L17 RecognitionException -> L19
    L48:
        return r5;
    L29:
        if (r13 == 2) goto L35;
        if (r13 == 3) goto L34;
        if (r13 != 4) goto L37;
        match(this.input, 59, FOLLOW_SEMPRED_in_actionElement1742);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 2, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        pushFollow(FOLLOW_elementOptions_in_actionElement1744);     // Catch: Throwable -> L17 RecognitionException -> L19
        elementOptions();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 3, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L37
    L34:
        match(this.input, 59, FOLLOW_SEMPRED_in_actionElement1734);     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L37
    L35:
        match(this.input, 4, FOLLOW_ACTION_in_actionElement1724);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 2, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        pushFollow(FOLLOW_elementOptions_in_actionElement1726);     // Catch: Throwable -> L17 RecognitionException -> L19
        elementOptions();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 3, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L37
    L9:
        if (r12 != (-1)) goto L11;
        r13 = 1;
        goto L27
    L11:
        int r14 = this.input.mark();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.input.consume();     // Catch: Throwable -> L14
        throw new NoViableAltException("", 34, 1, this.input);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.input.rewind(r14);     // Catch: Throwable -> L17 RecognitionException -> L19
        throw th;     // Catch: Throwable -> L17 RecognitionException -> L19
    L21:
        if (r11 != 59) goto L45;
        int r15 = this.input.LA(2);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r15 != 2) goto L25;
        r13 = 4;
        goto L27
    L25:
        if (r15 != (-1)) goto L38;
        r13 = 3;
        goto L27
    L38:
        int r16 = this.input.mark();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.input.consume();     // Catch: Throwable -> L41
        throw new NoViableAltException("", 34, 2, this.input);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        this.input.rewind(r16);     // Catch: Throwable -> L17 RecognitionException -> L19
        throw th;     // Catch: Throwable -> L17 RecognitionException -> L19
    L45:
        throw new NoViableAltException("", 34, 0, this.input);     // Catch: Throwable -> L17 RecognitionException -> L19
    L19:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L17:
        th = move-exception;
        throw th;
    }

    public void actionInAlt(ActionAST r5) {
    }

    public final alternative_return alternative() throws RecognitionException {
        alternative_return r5 = new alternative_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterAlternative((AltAST) ((GrammarAST) r10));
        discoverAlt((AltAST) ((GrammarAST) r5.start));
        int r11 = this.dfa38.predict(this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r11 == 1) goto L15;
        if (r11 != 2) goto L54;
        match(this.input, 74, FOLLOW_ALT_in_alternative1780);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(this.input, 2, null);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this.input.LA(1) != 82) goto L14;
        pushFollow(FOLLOW_elementOptions_in_alternative1782);     // Catch: Throwable -> L10 RecognitionException -> L12
        elementOptions();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state._fsp--;     // Catch: Throwable -> L10 RecognitionException -> L12
    L14:
        match(this.input, 83, FOLLOW_EPSILON_in_alternative1785);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(this.input, 3, null);     // Catch: Throwable -> L10 RecognitionException -> L12
    L54:
        finishAlt((AltAST) ((GrammarAST) r5.start));     // Catch: Throwable -> L10 RecognitionException -> L12
        exitAlternative((AltAST) ((GrammarAST) r5.start));     // Catch: Throwable -> L10 RecognitionException -> L12
    L61:
        return r5;
    L15:
        match(this.input, 74, FOLLOW_ALT_in_alternative1767);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(this.input, 2, null);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this.input.LA(1) != 82) goto L18;
        pushFollow(FOLLOW_elementOptions_in_alternative1769);     // Catch: Throwable -> L10 RecognitionException -> L12
        elementOptions();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state._fsp--;     // Catch: Throwable -> L10 RecognitionException -> L12
    L18:
        int r12 = 0;
    L19:
        int r13 = this.input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r13 != 4) goto L22;
    L57:
        pushFollow(FOLLOW_element_in_alternative1772);     // Catch: Throwable -> L10 RecognitionException -> L12
        element();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state._fsp--;     // Catch: Throwable -> L10 RecognitionException -> L12
        r12 = r12 + 1;
        goto L19
    L22:
        if (r13 == 10) goto L57;
        if (r13 == 20) goto L57;
        if (r13 == 39) goto L57;
        if (r13 == 46) goto L57;
        if (r13 == 52) goto L57;
        if (r13 == 57) goto L57;
        if (r13 == 59) goto L57;
        if (r13 == 62) goto L57;
        if (r13 == 66) goto L57;
        if (r13 == 78) goto L57;
        if (r13 == 80) goto L57;
        if (r13 < 89) goto L48;
        if (r13 <= 90) goto L57;
    L48:
        if (r13 == 98) goto L57;
        if (r13 == 100) goto L57;
        if (r12 < 1) goto L56;
        match(this.input, 3, null);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L54
    L56:
        throw new EarlyExitException(36, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    L12:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L10:
        th = move-exception;
        throw th;
    }

    public final astOperand_return astOperand() throws RecognitionException {
        astOperand_return r5 = new astOperand_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterAstOperand((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L36 RecognitionException -> L38
        if (r11 != 20) goto L7;
    L48:
        char r12 = 1;
    L49:
        if (r12 != 1) goto L51;
        pushFollow(FOLLOW_atom_in_astOperand1996);     // Catch: Throwable -> L36 RecognitionException -> L38
        atom();     // Catch: Throwable -> L36 RecognitionException -> L38
        this.state._fsp--;     // Catch: Throwable -> L36 RecognitionException -> L38
    L57:
        exitAstOperand((GrammarAST) r5.start);     // Catch: Throwable -> L36 RecognitionException -> L38
    L61:
        return r5;
    L51:
        if (r12 == 2) goto L55;
        if (r12 != 3) goto L57;
        match(this.input, 39, FOLLOW_NOT_in_astOperand2011);     // Catch: Throwable -> L36 RecognitionException -> L38
        match(this.input, 2, null);     // Catch: Throwable -> L36 RecognitionException -> L38
        pushFollow(FOLLOW_block_in_astOperand2013);     // Catch: Throwable -> L36 RecognitionException -> L38
        block();     // Catch: Throwable -> L36 RecognitionException -> L38
        this.state._fsp--;     // Catch: Throwable -> L36 RecognitionException -> L38
        match(this.input, 3, null);     // Catch: Throwable -> L36 RecognitionException -> L38
        goto L57
    L55:
        match(this.input, 39, FOLLOW_NOT_in_astOperand2002);     // Catch: Throwable -> L36 RecognitionException -> L38
        match(this.input, 2, null);     // Catch: Throwable -> L36 RecognitionException -> L38
        pushFollow(FOLLOW_blockSet_in_astOperand2004);     // Catch: Throwable -> L36 RecognitionException -> L38
        blockSet();     // Catch: Throwable -> L36 RecognitionException -> L38
        this.state._fsp--;     // Catch: Throwable -> L36 RecognitionException -> L38
        match(this.input, 3, null);     // Catch: Throwable -> L36 RecognitionException -> L38
        goto L57
    L7:
        if (r11 == 57) goto L48;
        if (r11 == 62) goto L48;
        if (r11 == 66) goto L48;
        if (r11 == 98) goto L48;
        if (r11 == 100) goto L48;
        int r13 = 0;
        if (r11 != 39) goto L47;
        if (this.input.LA(2) != 2) goto L40;
        int r14 = this.input.LA(3);     // Catch: Throwable -> L36 RecognitionException -> L38
        if (r14 != 98) goto L25;
        r12 = 2;
        goto L49
    L25:
        if (r14 != 78) goto L27;
        r12 = 3;
        goto L49
    L27:
        int r15 = this.input.mark();     // Catch: Throwable -> L36 RecognitionException -> L38
    L28:
        if (r13 >= 2) goto L33;
        this.input.consume();     // Catch: Throwable -> L30
        r13 = r13 + 1;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        this.input.rewind(r15);     // Catch: Throwable -> L36 RecognitionException -> L38
        throw th;     // Catch: Throwable -> L36 RecognitionException -> L38
    L33:
        throw new NoViableAltException("", 41, 3, this.input);     // Catch: Throwable -> L30
    L40:
        int r16 = this.input.mark();     // Catch: Throwable -> L36 RecognitionException -> L38
        this.input.consume();     // Catch: Throwable -> L43
        throw new NoViableAltException("", 41, 2, this.input);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        this.input.rewind(r16);     // Catch: Throwable -> L36 RecognitionException -> L38
        throw th;     // Catch: Throwable -> L36 RecognitionException -> L38
    L47:
        throw new NoViableAltException("", 41, 0, this.input);     // Catch: Throwable -> L36 RecognitionException -> L38
    L38:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L36:
        th = move-exception;
        throw th;
    }

    public final atom_return atom() throws RecognitionException {
        atom_return r5 = new atom_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterAtom((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L50 RecognitionException -> L52
        int r12 = 0;
        char r13 = 4;
        if (r11 == 20) goto L61;
        if (r11 == 57) goto L59;
        if (r11 == 62) goto L58;
        if (r11 == 66) goto L58;
        if (r11 == 98) goto L57;
        if (r11 != 100) goto L56;
        int r14 = this.input.LA(2);     // Catch: Throwable -> L50 RecognitionException -> L52
        if (r14 != 2) goto L16;
        r13 = 3;
    L54:
        char r15 = r13;
    L81:
        switch(r15) {
            case 1: goto L89;
            case 2: goto L88;
            case 3: goto L87;
            case 4: goto L86;
            case 5: goto L85;
            case 6: goto L84;
            case 7: goto L83;
            default: goto L90;
        };     // Catch: Throwable -> L50 RecognitionException -> L52
    L83:
        pushFollow(FOLLOW_ruleref_in_atom2272);     // Catch: Throwable -> L50 RecognitionException -> L52
        ruleref();     // Catch: Throwable -> L50 RecognitionException -> L52
        this.state._fsp--;     // Catch: Throwable -> L50 RecognitionException -> L52
        goto L90
    L84:
        pushFollow(FOLLOW_blockSet_in_atom2262);     // Catch: Throwable -> L50 RecognitionException -> L52
        blockSet();     // Catch: Throwable -> L50 RecognitionException -> L52
        this.state._fsp--;     // Catch: Throwable -> L50 RecognitionException -> L52
        goto L90
    L85:
        pushFollow(FOLLOW_terminal_in_atom2254);     // Catch: Throwable -> L50 RecognitionException -> L52
        terminal();     // Catch: Throwable -> L50 RecognitionException -> L52
        this.state._fsp--;     // Catch: Throwable -> L50 RecognitionException -> L52
        goto L90
    L86:
        wildcardRef((GrammarAST) match(this.input, 100, FOLLOW_WILDCARD_in_atom2238));     // Catch: Throwable -> L50 RecognitionException -> L52
        goto L90
    L87:
        GrammarAST r16 = (GrammarAST) match(this.input, 100, FOLLOW_WILDCARD_in_atom2225);     // Catch: Throwable -> L50 RecognitionException -> L52
        match(this.input, 2, null);     // Catch: Throwable -> L50 RecognitionException -> L52
        pushFollow(FOLLOW_elementOptions_in_atom2227);     // Catch: Throwable -> L50 RecognitionException -> L52
        elementOptions();     // Catch: Throwable -> L50 RecognitionException -> L52
        this.state._fsp--;     // Catch: Throwable -> L50 RecognitionException -> L52
        match(this.input, 3, null);     // Catch: Throwable -> L50 RecognitionException -> L52
        wildcardRef(r16);     // Catch: Throwable -> L50 RecognitionException -> L52
        goto L90
    L88:
        match(this.input, 20, FOLLOW_DOT_in_atom2211);     // Catch: Throwable -> L50 RecognitionException -> L52
        match(this.input, 2, null);     // Catch: Throwable -> L50 RecognitionException -> L52
        match(this.input, 28, FOLLOW_ID_in_atom2213);     // Catch: Throwable -> L50 RecognitionException -> L52
        pushFollow(FOLLOW_ruleref_in_atom2215);     // Catch: Throwable -> L50 RecognitionException -> L52
        ruleref();     // Catch: Throwable -> L50 RecognitionException -> L52
        this.state._fsp--;     // Catch: Throwable -> L50 RecognitionException -> L52
        match(this.input, 3, null);     // Catch: Throwable -> L50 RecognitionException -> L52
        goto L90
    L89:
        match(this.input, 20, FOLLOW_DOT_in_atom2200);     // Catch: Throwable -> L50 RecognitionException -> L52
        match(this.input, 2, null);     // Catch: Throwable -> L50 RecognitionException -> L52
        match(this.input, 28, FOLLOW_ID_in_atom2202);     // Catch: Throwable -> L50 RecognitionException -> L52
        pushFollow(FOLLOW_terminal_in_atom2204);     // Catch: Throwable -> L50 RecognitionException -> L52
        terminal();     // Catch: Throwable -> L50 RecognitionException -> L52
        this.state._fsp--;     // Catch: Throwable -> L50 RecognitionException -> L52
        match(this.input, 3, null);     // Catch: Throwable -> L50 RecognitionException -> L52
    L90:
        exitAtom((GrammarAST) r5.start);     // Catch: Throwable -> L50 RecognitionException -> L52
    L108:
        return r5;
    L16:
        if (r14 == (-1)) goto L54;
        if (r14 < 3) goto L20;
        if (r14 <= 4) goto L54;
    L20:
        if (r14 == 10) goto L54;
        if (r14 == 20) goto L54;
        if (r14 == 39) goto L54;
        if (r14 == 46) goto L54;
        if (r14 == 52) goto L54;
        if (r14 == 57) goto L54;
        if (r14 == 59) goto L54;
        if (r14 == 62) goto L54;
        if (r14 == 66) goto L54;
        if (r14 == 78) goto L54;
        if (r14 == 80) goto L54;
        if (r14 >= 89) goto L40;
    L41:
        if (r14 == 98) goto L54;
        if (r14 == 100) goto L54;
        int r17 = this.input.mark();     // Catch: Throwable -> L50 RecognitionException -> L52
        this.input.consume();     // Catch: Throwable -> L47
        throw new NoViableAltException("", 44, 2, this.input);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        this.input.rewind(r17);     // Catch: Throwable -> L50 RecognitionException -> L52
        throw th;     // Catch: Throwable -> L50 RecognitionException -> L52
    L40:
        if (r14 <= 90) goto L54;
    L56:
        throw new NoViableAltException("", 44, 0, this.input);     // Catch: Throwable -> L50 RecognitionException -> L52
    L57:
        r15 = 6;
    L58:
        r15 = 5;
        goto L81
    L59:
        r15 = 7;
        goto L81
    L61:
        if (this.input.LA(2) == 2) goto L63;
        int r18 = this.input.mark();     // Catch: Throwable -> L50 RecognitionException -> L52
        this.input.consume();     // Catch: Throwable -> L103
        throw new NoViableAltException("", 44, 1, this.input);     // Catch: Throwable -> L103
    L103:
        th = move-exception;
        this.input.rewind(r18);     // Catch: Throwable -> L50 RecognitionException -> L52
        throw th;     // Catch: Throwable -> L50 RecognitionException -> L52
    L63:
        if (this.input.LA(3) != 28) goto L91;
        int r19 = this.input.LA(4);     // Catch: Throwable -> L50 RecognitionException -> L52
        if (r19 == 62) goto L79;
        if (r19 == 66) goto L79;
        if (r19 != 57) goto L70;
        r15 = 2;
        goto L81
    L70:
        int r20 = this.input.mark();     // Catch: Throwable -> L50 RecognitionException -> L52
    L71:
        if (r12 >= 3) goto L76;
        this.input.consume();     // Catch: Throwable -> L73
        r12 = r12 + 1;     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        this.input.rewind(r20);     // Catch: Throwable -> L50 RecognitionException -> L52
        throw th;     // Catch: Throwable -> L50 RecognitionException -> L52
    L76:
        throw new NoViableAltException("", 44, 9, this.input);     // Catch: Throwable -> L73
    L79:
        r15 = 1;
        goto L81
    L91:
        int r21 = this.input.mark();     // Catch: Throwable -> L50 RecognitionException -> L52
    L92:
        if (r12 >= 2) goto L97;
        this.input.consume();     // Catch: Throwable -> L94
        r12 = r12 + 1;     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        this.input.rewind(r21);     // Catch: Throwable -> L50 RecognitionException -> L52
        throw th;     // Catch: Throwable -> L50 RecognitionException -> L52
    L97:
        throw new NoViableAltException("", 44, 6, this.input);     // Catch: Throwable -> L94
    L52:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L50:
        th = move-exception;
        throw th;
    }

    public final block_return block() throws RecognitionException {
        block_return r5 = new block_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterBlock((GrammarAST) r10);
        match(this.input, 78, FOLLOW_BLOCK_in_block2459);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 2, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this.input.LA(1) != 42) goto L11;
        pushFollow(FOLLOW_optionsSpec_in_block2461);     // Catch: Throwable -> L6 RecognitionException -> L8
        optionsSpec();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
    L11:
        if (this.input.LA(1) != 11) goto L14;
        pushFollow(FOLLOW_ruleAction_in_block2464);     // Catch: Throwable -> L6 RecognitionException -> L8
        ruleAction();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L11
    L14:
        if (this.input.LA(1) != 4) goto L16;
        match(this.input, 4, FOLLOW_ACTION_in_block2467);     // Catch: Throwable -> L6 RecognitionException -> L8
    L16:
        int r11 = 0;
    L18:
        if (this.input.LA(1) != 74) goto L20;
        pushFollow(FOLLOW_alternative_in_block2470);     // Catch: Throwable -> L6 RecognitionException -> L8
        alternative();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r11 = r11 + 1;     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L18
    L20:
        if (r11 < 1) goto L23;
        match(this.input, 3, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        exitBlock((GrammarAST) r5.start);     // Catch: Throwable -> L6 RecognitionException -> L8
    L26:
        return r5;
    L23:
        throw new EarlyExitException(50, this.input);     // Catch: Throwable -> L6 RecognitionException -> L8
    L8:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L6:
        th = move-exception;
        throw th;
    }

    public void blockOption(GrammarAST r5, GrammarAST r10) {
    }

    public final blockSet_return blockSet() throws RecognitionException {
        blockSet_return r5 = new blockSet_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterBlockSet((GrammarAST) r10);
        match(this.input, 98, FOLLOW_SET_in_blockSet2297);     // Catch: Throwable -> L15 RecognitionException -> L17
        match(this.input, 2, null);     // Catch: Throwable -> L15 RecognitionException -> L17
        int r11 = 0;
    L4:
        int r12 = this.input.LA(1);     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r12 != 32) goto L7;
    L21:
        pushFollow(FOLLOW_setElement_in_blockSet2299);     // Catch: Throwable -> L15 RecognitionException -> L17
        setElement();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        r11 = r11 + 1;
        goto L4
    L7:
        if (r12 == 52) goto L21;
        if (r12 == 62) goto L21;
        if (r12 == 66) goto L21;
        if (r11 < 1) goto L20;
        match(this.input, 3, null);     // Catch: Throwable -> L15 RecognitionException -> L17
        exitBlockSet((GrammarAST) r5.start);     // Catch: Throwable -> L15 RecognitionException -> L17
    L25:
        return r5;
    L20:
        throw new EarlyExitException(45, this.input);     // Catch: Throwable -> L15 RecognitionException -> L17
    L17:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L15:
        th = move-exception;
        throw th;
    }

    public final blockSuffix_return blockSuffix() throws RecognitionException {
        blockSuffix_return r5 = new blockSuffix_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterBlockSuffix((GrammarAST) r10);
        pushFollow(FOLLOW_ebnfSuffix_in_blockSuffix2139);     // Catch: Throwable -> L5 RecognitionException -> L7
        ebnfSuffix();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        exitBlockSuffix((GrammarAST) r5.start);     // Catch: Throwable -> L5 RecognitionException -> L7
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

    public final channelSpec_return channelSpec() throws RecognitionException {
        channelSpec_return r5 = new channelSpec_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterChannelSpec((GrammarAST) r10);
        defineChannel((GrammarAST) match(this.input, 28, FOLLOW_ID_in_channelSpec557));     // Catch: Throwable -> L5 RecognitionException -> L7
        exitChannelSpec((GrammarAST) r5.start);     // Catch: Throwable -> L5 RecognitionException -> L7
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

    public final channelsSpec_return channelsSpec() throws RecognitionException {
        channelsSpec_return r5 = new channelsSpec_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterChannelsSpec((GrammarAST) r10);
        match(this.input, 13, FOLLOW_CHANNELS_in_channelsSpec532);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(this.input, 2, null);     // Catch: Throwable -> L7 RecognitionException -> L9
        int r11 = 0;
    L5:
        if (this.input.LA(1) != 28) goto L11;
        pushFollow(FOLLOW_channelSpec_in_channelsSpec534);     // Catch: Throwable -> L7 RecognitionException -> L9
        channelSpec();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r11 = r11 + 1;     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        if (r11 < 1) goto L14;
        match(this.input, 3, null);     // Catch: Throwable -> L7 RecognitionException -> L9
        exitChannelsSpec((GrammarAST) r5.start);     // Catch: Throwable -> L7 RecognitionException -> L9
    L17:
        return r5;
    L14:
        throw new EarlyExitException(9, this.input);     // Catch: Throwable -> L7 RecognitionException -> L9
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L7:
        th = move-exception;
        throw th;
    }

    public void defineChannel(GrammarAST r5) {
    }

    public void defineToken(GrammarAST r5) {
    }

    public final delegateGrammar_return delegateGrammar() throws RecognitionException {
        delegateGrammar_return r5 = new delegateGrammar_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterDelegateGrammar((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r11 != 10) goto L6;
        char r12 = 1;
    L9:
        if (r12 == 1) goto L17;
        if (r12 != 2) goto L18;
        importGrammar(null, (GrammarAST) match(this.input, 28, FOLLOW_ID_in_delegateGrammar443));     // Catch: Throwable -> L13 RecognitionException -> L15
    L18:
        exitDelegateGrammar((GrammarAST) r5.start);     // Catch: Throwable -> L13 RecognitionException -> L15
    L23:
        return r5;
    L17:
        match(this.input, 10, FOLLOW_ASSIGN_in_delegateGrammar420);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(this.input, 2, null);     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r13 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_delegateGrammar424);     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r14 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_delegateGrammar428);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(this.input, 3, null);     // Catch: Throwable -> L13 RecognitionException -> L15
        importGrammar(r13, r14);     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L18
    L6:
        if (r11 != 28) goto L20;
        r12 = 2;
        goto L9
    L20:
        throw new NoViableAltException("", 7, 0, this.input);     // Catch: Throwable -> L13 RecognitionException -> L15
    L15:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L13:
        th = move-exception;
        throw th;
    }

    public final delegateGrammars_return delegateGrammars() throws RecognitionException {
        delegateGrammars_return r5 = new delegateGrammars_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterDelegateGrammars((GrammarAST) r10);
        match(this.input, 29, FOLLOW_IMPORT_in_delegateGrammars389);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        int r11 = 0;
    L4:
        int r12 = this.input.LA(1);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r12 != 10) goto L7;
    L17:
        pushFollow(FOLLOW_delegateGrammar_in_delegateGrammars391);     // Catch: Throwable -> L11 RecognitionException -> L13
        delegateGrammar();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        r11 = r11 + 1;
        goto L4
    L7:
        if (r12 == 28) goto L17;
        if (r11 < 1) goto L16;
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        exitDelegateGrammars((GrammarAST) r5.start);     // Catch: Throwable -> L11 RecognitionException -> L13
    L21:
        return r5;
    L16:
        throw new EarlyExitException(6, this.input);     // Catch: Throwable -> L11 RecognitionException -> L13
    L13:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L11:
        th = move-exception;
        throw th;
    }

    public void discoverAlt(AltAST r5) {
    }

    public void discoverGrammar(GrammarRootAST r5, GrammarAST r10) {
    }

    public void discoverLexerRule(RuleAST r5, GrammarAST r10, List<GrammarAST> r11, GrammarAST r12) {
    }

    public void discoverOuterAlt(AltAST r5) {
    }

    public void discoverRule(RuleAST r5, GrammarAST r10, List<GrammarAST> r11, ActionAST r12, ActionAST r13, GrammarAST r14, GrammarAST r15, ActionAST r16, List<GrammarAST> r17, GrammarAST r18) {
    }

    public void discoverRules(GrammarAST r5) {
    }

    public final ebnfSuffix_return ebnfSuffix() throws RecognitionException {
        ebnfSuffix_return r5 = new ebnfSuffix_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterEbnfSuffix((GrammarAST) r10);
    L12:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L20:
        return r5;
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.input.LA(1) != 80) goto L6;
    L16:
        this.input.consume();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state.errorRecovery = false;     // Catch: Throwable -> L10 RecognitionException -> L12
        exitEbnfSuffix((GrammarAST) r5.start);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L20
    L6:
        if (this.input.LA(1) < 89) goto L15;
        if (this.input.LA(1) <= 90) goto L16;
    L15:
        throw new MismatchedSetException(null, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    }

    public final element_return element() throws RecognitionException {
        element_return r5 = new element_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterElement((GrammarAST) r10);
    L10:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L127:
        return r5;
    L8:
        th = move-exception;
        throw th;
    L5:
        switch(this.input.LA(1)) {
            case 4: goto L75;
            case 10: goto L74;
            case 20: goto L73;
            case 39: goto L50;
            case 46: goto L74;
            case 52: goto L48;
            case 57: goto L73;
            case 59: goto L13;
            case 62: goto L73;
            case 66: goto L73;
            case 78: goto L12;
            case 80: goto L12;
            case 89: goto L12;
            case 90: goto L12;
            case 98: goto L73;
            case 100: goto L73;
            default: goto L7;
        };
    L12:
        char r11 = 3;
    L111:
        switch(r11) {
            case 1: goto L122;
            case 2: goto L121;
            case 3: goto L120;
            case 4: goto L119;
            case 5: goto L118;
            case 6: goto L117;
            case 7: goto L116;
            case 8: goto L115;
            case 9: goto L114;
            case 10: goto L113;
            default: goto L123;
        };     // Catch: Throwable -> L8 RecognitionException -> L10
    L113:
        match(this.input, 39, FOLLOW_NOT_in_element1972);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        pushFollow(FOLLOW_block_in_element1974);     // Catch: Throwable -> L8 RecognitionException -> L10
        block();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L123
    L114:
        match(this.input, 39, FOLLOW_NOT_in_element1963);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        pushFollow(FOLLOW_blockSet_in_element1965);     // Catch: Throwable -> L8 RecognitionException -> L10
        blockSet();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L123
    L115:
        pushFollow(FOLLOW_range_in_element1957);     // Catch: Throwable -> L8 RecognitionException -> L10
        range();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L123
    L116:
        GrammarAST r12 = (GrammarAST) match(this.input, 59, FOLLOW_SEMPRED_in_element1947);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        pushFollow(FOLLOW_elementOptions_in_element1949);     // Catch: Throwable -> L8 RecognitionException -> L10
        elementOptions();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        sempredInAlt((PredAST) r12);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L123
    L117:
        GrammarAST r13 = (GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_element1934);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        pushFollow(FOLLOW_elementOptions_in_element1936);     // Catch: Throwable -> L8 RecognitionException -> L10
        elementOptions();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        actionInAlt((ActionAST) r13);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L123
    L118:
        sempredInAlt((PredAST) ((GrammarAST) match(this.input, 59, FOLLOW_SEMPRED_in_element1919)));     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L123
    L119:
        actionInAlt((ActionAST) ((GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_element1905)));     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L123
    L120:
        pushFollow(FOLLOW_subrule_in_element1898);     // Catch: Throwable -> L8 RecognitionException -> L10
        subrule();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L123
    L121:
        pushFollow(FOLLOW_atom_in_element1893);     // Catch: Throwable -> L8 RecognitionException -> L10
        atom();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L123
    L122:
        pushFollow(FOLLOW_labeledElement_in_element1888);     // Catch: Throwable -> L8 RecognitionException -> L10
        labeledElement();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
    L123:
        exitElement((GrammarAST) r5.start);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L127
    L13:
        int r14 = this.input.LA(2);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r14 != 2) goto L16;
        r11 = 7;
        goto L111
    L16:
        if (r14 < 3) goto L18;
        if (r14 > 4) goto L18;
    L47:
        r11 = 5;
    L18:
        if (r14 == 10) goto L47;
        if (r14 == 20) goto L47;
        if (r14 == 39) goto L47;
        if (r14 == 46) goto L47;
        if (r14 == 52) goto L47;
        if (r14 == 57) goto L47;
        if (r14 == 59) goto L47;
        if (r14 == 62) goto L47;
        if (r14 == 66) goto L47;
        if (r14 == 78) goto L47;
        if (r14 == 80) goto L47;
        if (r14 < 89) goto L37;
        if (r14 <= 90) goto L47;
    L37:
        if (r14 == 98) goto L47;
        if (r14 == 100) goto L47;
        int r15 = this.input.mark();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.input.consume();     // Catch: Throwable -> L44
        throw new NoViableAltException("", 40, 5, this.input);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        this.input.rewind(r15);     // Catch: Throwable -> L8 RecognitionException -> L10
        throw th;     // Catch: Throwable -> L8 RecognitionException -> L10
    L48:
        r11 = '\b';
        goto L111
    L73:
        r11 = 2;
        goto L111
    L74:
        r11 = 1;
        goto L111
    L75:
        int r16 = this.input.LA(2);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r16 != 2) goto L78;
        r11 = 6;
        goto L111
    L78:
        if (r16 < 3) goto L80;
        if (r16 > 4) goto L80;
    L109:
        r11 = 4;
    L80:
        if (r16 == 10) goto L109;
        if (r16 == 20) goto L109;
        if (r16 == 39) goto L109;
        if (r16 == 46) goto L109;
        if (r16 == 52) goto L109;
        if (r16 == 57) goto L109;
        if (r16 == 59) goto L109;
        if (r16 == 62) goto L109;
        if (r16 == 66) goto L109;
        if (r16 == 78) goto L109;
        if (r16 == 80) goto L109;
        if (r16 < 89) goto L99;
        if (r16 <= 90) goto L109;
    L99:
        if (r16 == 98) goto L109;
        if (r16 == 100) goto L109;
        int r17 = this.input.mark();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.input.consume();     // Catch: Throwable -> L106
        throw new NoViableAltException("", 40, 4, this.input);     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        this.input.rewind(r17);     // Catch: Throwable -> L8 RecognitionException -> L10
        throw th;     // Catch: Throwable -> L8 RecognitionException -> L10
    L7:
        throw new NoViableAltException("", 40, 0, this.input);     // Catch: Throwable -> L8 RecognitionException -> L10
    L50:
        if (this.input.LA(2) != 2) goto L67;
        int r18 = this.input.LA(3);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r18 != 98) goto L55;
        r11 = '\t';
        goto L111
    L55:
        if (r18 != 78) goto L57;
        r11 = '\n';
        goto L111
    L57:
        int r19 = this.input.mark();     // Catch: Throwable -> L8 RecognitionException -> L10
        int r20 = 0;
    L59:
        if (r20 >= 2) goto L64;
        this.input.consume();     // Catch: Throwable -> L61
        r20 = r20 + 1;     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        this.input.rewind(r19);     // Catch: Throwable -> L8 RecognitionException -> L10
        throw th;     // Catch: Throwable -> L8 RecognitionException -> L10
    L64:
        throw new NoViableAltException("", 40, 12, this.input);     // Catch: Throwable -> L61
    L67:
        int r21 = this.input.mark();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.input.consume();     // Catch: Throwable -> L70
        throw new NoViableAltException("", 40, 7, this.input);     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        this.input.rewind(r21);     // Catch: Throwable -> L8 RecognitionException -> L10
        throw th;     // Catch: Throwable -> L8 RecognitionException -> L10
    }

    public void elementOption(GrammarASTWithOptions r5, GrammarAST r10, GrammarAST r11) {
    }

    public final elementOptions_return elementOptions() throws RecognitionException {
        elementOptions_return r5 = new elementOptions_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterElementOptions((GrammarAST) r10);
        match(this.input, 82, FOLLOW_ELEMENT_OPTIONS_in_elementOptions2667);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (this.input.LA(1) != 2) goto L17;
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
    L6:
        int r11 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r11 == 10) goto L16;
        if (r11 == 28) goto L16;
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
    L16:
        pushFollow(FOLLOW_elementOption_in_elementOptions2669);     // Catch: Throwable -> L12 RecognitionException -> L14
        elementOption((GrammarASTWithOptions) ((GrammarAST) r5.start).getParent());     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
    L17:
        exitElementOptions((GrammarAST) r5.start);     // Catch: Throwable -> L12 RecognitionException -> L14
    L21:
        return r5;
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L12:
        th = move-exception;
        throw th;
    }

    public void enterAction(GrammarAST r5) {
    }

    public void enterActionElement(GrammarAST r5) {
    }

    public void enterAlternative(AltAST r5) {
    }

    public void enterAstOperand(GrammarAST r5) {
    }

    public void enterAtom(GrammarAST r5) {
    }

    public void enterBlock(GrammarAST r5) {
    }

    public void enterBlockSet(GrammarAST r5) {
    }

    public void enterBlockSuffix(GrammarAST r5) {
    }

    public void enterChannelSpec(GrammarAST r5) {
    }

    public void enterChannelsSpec(GrammarAST r5) {
    }

    public void enterDelegateGrammar(GrammarAST r5) {
    }

    public void enterDelegateGrammars(GrammarAST r5) {
    }

    public void enterEbnfSuffix(GrammarAST r5) {
    }

    public void enterElement(GrammarAST r5) {
    }

    public void enterElementOption(GrammarAST r5) {
    }

    public void enterElementOptions(GrammarAST r5) {
    }

    public void enterExceptionGroup(GrammarAST r5) {
    }

    public void enterExceptionHandler(GrammarAST r5) {
    }

    public void enterFinallyClause(GrammarAST r5) {
    }

    public void enterGrammarSpec(GrammarAST r5) {
    }

    public void enterLabeledElement(GrammarAST r5) {
    }

    public void enterLabeledLexerElement(GrammarAST r5) {
    }

    public void enterLexerAlternative(GrammarAST r5) {
    }

    public void enterLexerAtom(GrammarAST r5) {
    }

    public void enterLexerBlock(GrammarAST r5) {
    }

    public void enterLexerCommand(GrammarAST r5) {
    }

    public void enterLexerCommandExpr(GrammarAST r5) {
    }

    public void enterLexerElement(GrammarAST r5) {
    }

    public void enterLexerElements(GrammarAST r5) {
    }

    public void enterLexerOuterAlternative(AltAST r5) {
    }

    public void enterLexerRule(GrammarAST r5) {
    }

    public void enterLexerRuleBlock(GrammarAST r5) {
    }

    public void enterLexerSubrule(GrammarAST r5) {
    }

    public void enterLocals(GrammarAST r5) {
    }

    public void enterMode(GrammarAST r5) {
    }

    public void enterOption(GrammarAST r5) {
    }

    public void enterOptionValue(GrammarAST r5) {
    }

    public void enterOptionsSpec(GrammarAST r5) {
    }

    public void enterOuterAlternative(AltAST r5) {
    }

    public void enterPrequelConstruct(GrammarAST r5) {
    }

    public void enterPrequelConstructs(GrammarAST r5) {
    }

    public void enterRange(GrammarAST r5) {
    }

    public void enterRule(GrammarAST r5) {
    }

    public void enterRuleAction(GrammarAST r5) {
    }

    public void enterRuleBlock(GrammarAST r5) {
    }

    public void enterRuleModifier(GrammarAST r5) {
    }

    public void enterRuleReturns(GrammarAST r5) {
    }

    public void enterRuleref(GrammarAST r5) {
    }

    public void enterRules(GrammarAST r5) {
    }

    public void enterSetElement(GrammarAST r5) {
    }

    public void enterSubrule(GrammarAST r5) {
    }

    public void enterTerminal(GrammarAST r5) {
    }

    public void enterThrowsSpec(GrammarAST r5) {
    }

    public void enterTokenSpec(GrammarAST r5) {
    }

    public void enterTokensSpec(GrammarAST r5) {
    }

    public final exceptionGroup_return exceptionGroup() throws RecognitionException {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor$exceptionGroup_return r0 = new androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor$exceptionGroup_return
            r0.<init>()
            androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream r1 = r4.input
            r2 = 1
            java.lang.Object r1 = r1.LT(r2)
            r0.start = r1
            androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST r1 = (androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST) r1
            r4.enterExceptionGroup(r1)
        L13:
            androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream r1 = r4.input     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            int r1 = r1.LA(r2)     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            r3 = 12
            if (r1 != r3) goto L31
            androidx.room.jarjarred.org.antlr.runtime.BitSet r1 = androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor.FOLLOW_exceptionHandler_in_exceptionGroup957     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            r4.pushFollow(r1)     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            r4.exceptionHandler()     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState r1 = r4.state     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            int r3 = r1._fsp     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            int r3 = r3 - r2
            r1._fsp = r3     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            goto L13
        L2d:
            r4 = move-exception
            goto L52
        L2f:
            r1 = move-exception
            goto L53
        L31:
            androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream r1 = r4.input     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            int r1 = r1.LA(r2)     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            r3 = 23
            if (r1 != r3) goto L4a
            androidx.room.jarjarred.org.antlr.runtime.BitSet r1 = androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor.FOLLOW_finallyClause_in_exceptionGroup960     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            r4.pushFollow(r1)     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            r4.finallyClause()     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState r1 = r4.state     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            int r3 = r1._fsp     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            int r3 = r3 - r2
            r1._fsp = r3     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
        L4a:
            java.lang.Object r1 = r0.start     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST r1 = (androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST) r1     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            r4.exitExceptionGroup(r1)     // Catch: java.lang.Throwable -> L2d androidx.room.jarjarred.org.antlr.runtime.RecognitionException -> L2f
            goto L5b
        L52:
            throw r4
        L53:
            r4.reportError(r1)
            androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream r2 = r4.input
            r4.recover(r2, r1)
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor.exceptionGroup():androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor$exceptionGroup_return");
    }

    public final exceptionHandler_return exceptionHandler() throws RecognitionException {
        exceptionHandler_return r5 = new exceptionHandler_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterExceptionHandler((GrammarAST) r10);
        match(this.input, 12, FOLLOW_CATCH_in_exceptionHandler986);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 2, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r11 = (GrammarAST) match(this.input, 8, FOLLOW_ARG_ACTION_in_exceptionHandler988);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r12 = (GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_exceptionHandler990);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 3, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        ruleCatch(r11, (ActionAST) r12);     // Catch: Throwable -> L5 RecognitionException -> L7
        exitExceptionHandler((GrammarAST) r5.start);     // Catch: Throwable -> L5 RecognitionException -> L7
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

    public void exitAction(GrammarAST r5) {
    }

    public void exitActionElement(GrammarAST r5) {
    }

    public void exitAlternative(AltAST r5) {
    }

    public void exitAstOperand(GrammarAST r5) {
    }

    public void exitAtom(GrammarAST r5) {
    }

    public void exitBlock(GrammarAST r5) {
    }

    public void exitBlockSet(GrammarAST r5) {
    }

    public void exitBlockSuffix(GrammarAST r5) {
    }

    public void exitChannelSpec(GrammarAST r5) {
    }

    public void exitChannelsSpec(GrammarAST r5) {
    }

    public void exitDelegateGrammar(GrammarAST r5) {
    }

    public void exitDelegateGrammars(GrammarAST r5) {
    }

    public void exitEbnfSuffix(GrammarAST r5) {
    }

    public void exitElement(GrammarAST r5) {
    }

    public void exitElementOption(GrammarAST r5) {
    }

    public void exitElementOptions(GrammarAST r5) {
    }

    public void exitExceptionGroup(GrammarAST r5) {
    }

    public void exitExceptionHandler(GrammarAST r5) {
    }

    public void exitFinallyClause(GrammarAST r5) {
    }

    public void exitGrammarSpec(GrammarAST r5) {
    }

    public void exitLabeledElement(GrammarAST r5) {
    }

    public void exitLabeledLexerElement(GrammarAST r5) {
    }

    public void exitLexerAlternative(GrammarAST r5) {
    }

    public void exitLexerAtom(GrammarAST r5) {
    }

    public void exitLexerBlock(GrammarAST r5) {
    }

    public void exitLexerCommand(GrammarAST r5) {
    }

    public void exitLexerCommandExpr(GrammarAST r5) {
    }

    public void exitLexerElement(GrammarAST r5) {
    }

    public void exitLexerElements(GrammarAST r5) {
    }

    public void exitLexerOuterAlternative(AltAST r5) {
    }

    public void exitLexerRule(GrammarAST r5) {
    }

    public void exitLexerRuleBlock(GrammarAST r5) {
    }

    public void exitLexerSubrule(GrammarAST r5) {
    }

    public void exitLocals(GrammarAST r5) {
    }

    public void exitMode(GrammarAST r5) {
    }

    public void exitOption(GrammarAST r5) {
    }

    public void exitOptionValue(GrammarAST r5) {
    }

    public void exitOptionsSpec(GrammarAST r5) {
    }

    public void exitOuterAlternative(AltAST r5) {
    }

    public void exitPrequelConstruct(GrammarAST r5) {
    }

    public void exitPrequelConstructs(GrammarAST r5) {
    }

    public void exitRange(GrammarAST r5) {
    }

    public void exitRule(GrammarAST r5) {
    }

    public void exitRuleAction(GrammarAST r5) {
    }

    public void exitRuleBlock(GrammarAST r5) {
    }

    public void exitRuleModifier(GrammarAST r5) {
    }

    public void exitRuleReturns(GrammarAST r5) {
    }

    public void exitRuleref(GrammarAST r5) {
    }

    public void exitRules(GrammarAST r5) {
    }

    public void exitSetElement(GrammarAST r5) {
    }

    public void exitSubrule(GrammarAST r5) {
    }

    public void exitTerminal(GrammarAST r5) {
    }

    public void exitThrowsSpec(GrammarAST r5) {
    }

    public void exitTokenSpec(GrammarAST r5) {
    }

    public void exitTokensSpec(GrammarAST r5) {
    }

    public void finallyAction(ActionAST r5) {
    }

    public final finallyClause_return finallyClause() throws RecognitionException {
        finallyClause_return r5 = new finallyClause_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterFinallyClause((GrammarAST) r10);
        match(this.input, 23, FOLLOW_FINALLY_in_finallyClause1015);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 2, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r11 = (GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_finallyClause1017);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 3, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        finallyAction((ActionAST) r11);     // Catch: Throwable -> L5 RecognitionException -> L7
        exitFinallyClause((GrammarAST) r5.start);     // Catch: Throwable -> L5 RecognitionException -> L7
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

    public void finishAlt(AltAST r5) {
    }

    public void finishGrammar(GrammarRootAST r5, GrammarAST r10) {
    }

    public void finishLexerRule(RuleAST r5, GrammarAST r10, GrammarAST r11) {
    }

    public void finishOuterAlt(AltAST r5) {
    }

    public void finishPrequels(GrammarAST r5) {
    }

    public void finishRule(RuleAST r5, GrammarAST r10, GrammarAST r11) {
    }

    public void finishRules(GrammarAST r5) {
    }

    public TreeParser[] getDelegates() {
        return new TreeParser[0];
    }

    public ErrorManager getErrorManager() {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getGrammarFileName() {
        return "androidx/room/jarjarred/org/antlr/v4/parse/GrammarTreeVisitor.g";
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String[] getTokenNames() {
        return tokenNames;
    }

    public void globalNamedAction(GrammarAST r5, GrammarAST r10, ActionAST r11) {
    }

    public void grammarOption(GrammarAST r5, GrammarAST r10) {
    }

    public final grammarSpec_return grammarSpec() throws RecognitionException {
        grammarSpec_return r5 = new grammarSpec_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterGrammarSpec((GrammarAST) r10);
        GrammarAST r11 = (GrammarAST) match(this.input, 25, FOLLOW_GRAMMAR_in_grammarSpec85);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 2, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r12 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_grammarSpec87);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r12 == null) goto L10;
        String r13 = r12.getText();     // Catch: Throwable -> L6 RecognitionException -> L8
    L11:
        this.grammarName = r13;     // Catch: Throwable -> L6 RecognitionException -> L8
        discoverGrammar((GrammarRootAST) r11, r12);     // Catch: Throwable -> L6 RecognitionException -> L8
        pushFollow(FOLLOW_prequelConstructs_in_grammarSpec106);     // Catch: Throwable -> L6 RecognitionException -> L8
        prequelConstructs_return r14 = prequelConstructs();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r14 == null) goto L14;
        GrammarAST r15 = r14.firstOne;     // Catch: Throwable -> L6 RecognitionException -> L8
    L15:
        finishPrequels(r15);     // Catch: Throwable -> L6 RecognitionException -> L8
        pushFollow(FOLLOW_rules_in_grammarSpec123);     // Catch: Throwable -> L6 RecognitionException -> L8
        rules();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
    L17:
        if (this.input.LA(1) != 36) goto L19;
        pushFollow(FOLLOW_mode_in_grammarSpec125);     // Catch: Throwable -> L6 RecognitionException -> L8
        mode();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L17
    L19:
        finishGrammar((GrammarRootAST) r11, r12);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 3, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        exitGrammarSpec((GrammarAST) r5.start);     // Catch: Throwable -> L6 RecognitionException -> L8
    L23:
        return r5;
    L14:
        r15 = null;
        goto L15
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

    public void importGrammar(GrammarAST r5, GrammarAST r10) {
    }

    public void label(GrammarAST r5, GrammarAST r10, GrammarAST r11) {
    }

    public final labeledElement_return labeledElement() throws RecognitionException {
        labeledElement_return r5 = new labeledElement_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLabeledElement((GrammarAST) r10);
        GrammarAST r11 = null;
        if (this.input.LA(1) != 10) goto L6;
    L14:
        this.input.consume();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state.errorRecovery = false;     // Catch: Throwable -> L10 RecognitionException -> L12
        match(this.input, 2, null);     // Catch: Throwable -> L10 RecognitionException -> L12
        GrammarAST r12 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_labeledElement2042);     // Catch: Throwable -> L10 RecognitionException -> L12
        pushFollow(FOLLOW_element_in_labeledElement2044);     // Catch: Throwable -> L10 RecognitionException -> L12
        element_return r13 = element();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state._fsp--;     // Catch: Throwable -> L10 RecognitionException -> L12
        match(this.input, 3, null);     // Catch: Throwable -> L10 RecognitionException -> L12
        GrammarAST r14 = (GrammarAST) r5.start;     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r13 == null) goto L17;
        r11 = (GrammarAST) r13.start;     // Catch: Throwable -> L10 RecognitionException -> L12
    L17:
        label(r14, r12, r11);     // Catch: Throwable -> L10 RecognitionException -> L12
        exitLabeledElement((GrammarAST) r5.start);     // Catch: Throwable -> L10 RecognitionException -> L12
    L21:
        return r5;
    L6:
        if (this.input.LA(1) == 46) goto L14;
        throw new MismatchedSetException(null, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    L12:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L10:
        th = move-exception;
        throw th;
    }

    public final labeledLexerElement_return labeledLexerElement() throws RecognitionException {
        labeledLexerElement_return r5 = new labeledLexerElement_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLabeledLexerElement((GrammarAST) r10);
    L12:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L46:
        return r5;
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.input.LA(1) != 10) goto L6;
    L14:
        this.input.consume();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state.errorRecovery = false;     // Catch: Throwable -> L10 RecognitionException -> L12
        match(this.input, 2, null);     // Catch: Throwable -> L10 RecognitionException -> L12
        match(this.input, 28, FOLLOW_ID_in_labeledLexerElement1550);     // Catch: Throwable -> L10 RecognitionException -> L12
        int r11 = this.input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r11 != 32) goto L17;
    L36:
        char r12 = 1;
    L37:
        if (r12 == 1) goto L41;
        if (r12 != 2) goto L42;
        pushFollow(FOLLOW_block_in_labeledLexerElement1555);     // Catch: Throwable -> L10 RecognitionException -> L12
        block();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state._fsp--;     // Catch: Throwable -> L10 RecognitionException -> L12
    L42:
        match(this.input, 3, null);     // Catch: Throwable -> L10 RecognitionException -> L12
        exitLabeledLexerElement((GrammarAST) r5.start);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L46
    L41:
        pushFollow(FOLLOW_lexerAtom_in_labeledLexerElement1553);     // Catch: Throwable -> L10 RecognitionException -> L12
        lexerAtom();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state._fsp--;     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L42
    L17:
        if (r11 == 39) goto L36;
        if (r11 == 52) goto L36;
        if (r11 == 57) goto L36;
        if (r11 == 62) goto L36;
        if (r11 == 66) goto L36;
        if (r11 == 98) goto L36;
        if (r11 == 100) goto L36;
        if (r11 != 78) goto L35;
        r12 = 2;
        goto L37
    L35:
        throw new NoViableAltException("", 30, 0, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    L6:
        if (this.input.LA(1) == 46) goto L14;
        throw new MismatchedSetException(null, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    }

    public final lexerAlternative_return lexerAlternative() throws RecognitionException {
        lexerAlternative_return r5 = new lexerAlternative_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLexerAlternative((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        int r12 = 0;
        if (r11 != 87) goto L7;
        char r13 = 1;
    L9:
        if (r13 == 1) goto L17;
        if (r13 != 2) goto L25;
        pushFollow(FOLLOW_lexerElements_in_lexerAlternative1392);     // Catch: Throwable -> L13 RecognitionException -> L15
        lexerElements();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
    L25:
        exitLexerAlternative((GrammarAST) r5.start);     // Catch: Throwable -> L13 RecognitionException -> L15
    L33:
        return r5;
    L17:
        match(this.input, 87, FOLLOW_LEXER_ALT_ACTION_in_lexerAlternative1376);     // Catch: Throwable -> L13 RecognitionException -> L15
        match(this.input, 2, null);     // Catch: Throwable -> L13 RecognitionException -> L15
        pushFollow(FOLLOW_lexerElements_in_lexerAlternative1378);     // Catch: Throwable -> L13 RecognitionException -> L15
        lexerElements();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
    L18:
        int r14 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r14 == 28) goto L28;
        if (r14 == 86) goto L28;
        if (r12 < 1) goto L27;
        match(this.input, 3, null);     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L25
    L27:
        throw new EarlyExitException(26, this.input);     // Catch: Throwable -> L13 RecognitionException -> L15
    L28:
        pushFollow(FOLLOW_lexerCommand_in_lexerAlternative1380);     // Catch: Throwable -> L13 RecognitionException -> L15
        lexerCommand();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        r12 = r12 + 1;     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L18
    L7:
        if (r11 != 74) goto L30;
        r13 = 2;
        goto L9
    L30:
        throw new NoViableAltException("", 27, 0, this.input);     // Catch: Throwable -> L13 RecognitionException -> L15
    L15:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L13:
        th = move-exception;
        throw th;
    }

    public final lexerAtom_return lexerAtom() throws RecognitionException {
        lexerAtom_return r5 = new lexerAtom_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLexerAtom((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L55 RecognitionException -> L57
        if (r11 == 32) goto L67;
        if (r11 != 39) goto L8;
        char r12 = 2;
    L69:
        switch(r12) {
            case 1: goto L78;
            case 2: goto L77;
            case 3: goto L76;
            case 4: goto L75;
            case 5: goto L74;
            case 6: goto L73;
            case 7: goto L72;
            case 8: goto L71;
            default: goto L79;
        };     // Catch: Throwable -> L55 RecognitionException -> L57
    L71:
        pushFollow(FOLLOW_ruleref_in_lexerAtom1692);     // Catch: Throwable -> L55 RecognitionException -> L57
        ruleref();     // Catch: Throwable -> L55 RecognitionException -> L57
        this.state._fsp--;     // Catch: Throwable -> L55 RecognitionException -> L57
        goto L79
    L72:
        pushFollow(FOLLOW_range_in_lexerAtom1682);     // Catch: Throwable -> L55 RecognitionException -> L57
        range();     // Catch: Throwable -> L55 RecognitionException -> L57
        this.state._fsp--;     // Catch: Throwable -> L55 RecognitionException -> L57
        goto L79
    L73:
        match(this.input, 32, FOLLOW_LEXER_CHAR_SET_in_lexerAtom1672);     // Catch: Throwable -> L55 RecognitionException -> L57
        goto L79
    L74:
        match(this.input, 100, FOLLOW_WILDCARD_in_lexerAtom1664);     // Catch: Throwable -> L55 RecognitionException -> L57
        goto L79
    L75:
        match(this.input, 100, FOLLOW_WILDCARD_in_lexerAtom1651);     // Catch: Throwable -> L55 RecognitionException -> L57
        match(this.input, 2, null);     // Catch: Throwable -> L55 RecognitionException -> L57
        pushFollow(FOLLOW_elementOptions_in_lexerAtom1653);     // Catch: Throwable -> L55 RecognitionException -> L57
        elementOptions();     // Catch: Throwable -> L55 RecognitionException -> L57
        this.state._fsp--;     // Catch: Throwable -> L55 RecognitionException -> L57
        match(this.input, 3, null);     // Catch: Throwable -> L55 RecognitionException -> L57
        goto L79
    L76:
        pushFollow(FOLLOW_blockSet_in_lexerAtom1640);     // Catch: Throwable -> L55 RecognitionException -> L57
        blockSet();     // Catch: Throwable -> L55 RecognitionException -> L57
        this.state._fsp--;     // Catch: Throwable -> L55 RecognitionException -> L57
        goto L79
    L77:
        match(this.input, 39, FOLLOW_NOT_in_lexerAtom1627);     // Catch: Throwable -> L55 RecognitionException -> L57
        match(this.input, 2, null);     // Catch: Throwable -> L55 RecognitionException -> L57
        pushFollow(FOLLOW_blockSet_in_lexerAtom1629);     // Catch: Throwable -> L55 RecognitionException -> L57
        blockSet();     // Catch: Throwable -> L55 RecognitionException -> L57
        this.state._fsp--;     // Catch: Throwable -> L55 RecognitionException -> L57
        match(this.input, 3, null);     // Catch: Throwable -> L55 RecognitionException -> L57
        goto L79
    L78:
        pushFollow(FOLLOW_terminal_in_lexerAtom1616);     // Catch: Throwable -> L55 RecognitionException -> L57
        terminal();     // Catch: Throwable -> L55 RecognitionException -> L57
        this.state._fsp--;     // Catch: Throwable -> L55 RecognitionException -> L57
    L79:
        exitLexerAtom((GrammarAST) r5.start);     // Catch: Throwable -> L55 RecognitionException -> L57
    L83:
        return r5;
    L8:
        if (r11 != 52) goto L10;
        r12 = 7;
        goto L69
    L10:
        if (r11 != 57) goto L12;
        r12 = '\b';
        goto L69
    L12:
        if (r11 != 62) goto L14;
    L63:
        r12 = 1;
        goto L69
    L14:
        if (r11 == 66) goto L63;
        if (r11 != 98) goto L18;
        r12 = 3;
        goto L69
    L18:
        if (r11 != 100) goto L61;
        int r13 = this.input.LA(2);     // Catch: Throwable -> L55 RecognitionException -> L57
        if (r13 != 2) goto L22;
        r12 = 4;
        goto L69
    L22:
        if (r13 < 3) goto L25;
        if (r13 > 4) goto L25;
    L59:
        r12 = 5;
    L25:
        if (r13 == 10) goto L59;
        if (r13 == 32) goto L59;
        if (r13 == 39) goto L59;
        if (r13 == 46) goto L59;
        if (r13 == 52) goto L59;
        if (r13 == 57) goto L59;
        if (r13 == 59) goto L59;
        if (r13 == 62) goto L59;
        if (r13 == 66) goto L59;
        if (r13 == 78) goto L59;
        if (r13 == 80) goto L59;
        if (r13 == 83) goto L59;
        if (r13 >= 89) goto L45;
    L46:
        if (r13 == 98) goto L59;
        if (r13 == 100) goto L59;
        int r14 = this.input.mark();     // Catch: Throwable -> L55 RecognitionException -> L57
        this.input.consume();     // Catch: Throwable -> L52
        throw new NoViableAltException("", 33, 4, this.input);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        this.input.rewind(r14);     // Catch: Throwable -> L55 RecognitionException -> L57
        throw th;     // Catch: Throwable -> L55 RecognitionException -> L57
    L45:
        if (r13 <= 90) goto L59;
    L61:
        throw new NoViableAltException("", 33, 0, this.input);     // Catch: Throwable -> L55 RecognitionException -> L57
    L67:
        r12 = 6;
    L57:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L55:
        th = move-exception;
        throw th;
    }

    public final lexerBlock_return lexerBlock() throws RecognitionException {
        lexerBlock_return r5 = new lexerBlock_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLexerBlock((GrammarAST) r10);
        match(this.input, 78, FOLLOW_BLOCK_in_lexerBlock1580);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 2, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this.input.LA(1) != 42) goto L10;
        pushFollow(FOLLOW_optionsSpec_in_lexerBlock1582);     // Catch: Throwable -> L6 RecognitionException -> L8
        optionsSpec();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        int r11 = 0;
    L11:
        int r12 = this.input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r12 != 74) goto L14;
    L20:
        pushFollow(FOLLOW_lexerAlternative_in_lexerBlock1585);     // Catch: Throwable -> L6 RecognitionException -> L8
        lexerAlternative();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r11 = r11 + 1;
        goto L11
    L14:
        if (r12 == 87) goto L20;
        if (r11 < 1) goto L19;
        match(this.input, 3, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        exitLexerBlock((GrammarAST) r5.start);     // Catch: Throwable -> L6 RecognitionException -> L8
    L24:
        return r5;
    L19:
        throw new EarlyExitException(32, this.input);     // Catch: Throwable -> L6 RecognitionException -> L8
    L8:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L6:
        th = move-exception;
        throw th;
    }

    public void lexerCallCommand(int r5, GrammarAST r10, GrammarAST r11) {
    }

    public void lexerCommand(int r5, GrammarAST r10) {
    }

    public final lexerCommandExpr_return lexerCommandExpr() throws RecognitionException {
        lexerCommandExpr_return r5 = new lexerCommandExpr_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLexerCommandExpr((GrammarAST) r10);
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
        exitLexerCommandExpr((GrammarAST) r5.start);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L18
    L6:
        if (this.input.LA(1) == 30) goto L14;
        throw new MismatchedSetException(null, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    }

    public final lexerElement_return lexerElement() throws RecognitionException {
        lexerElement_return r5 = new lexerElement_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLexerElement((GrammarAST) r10);
    L10:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L105:
        return r5;
    L8:
        th = move-exception;
        throw th;
    L5:
        switch(this.input.LA(1)) {
            case 4: goto L53;
            case 10: goto L52;
            case 32: goto L51;
            case 39: goto L51;
            case 46: goto L52;
            case 52: goto L51;
            case 57: goto L51;
            case 59: goto L14;
            case 62: goto L51;
            case 66: goto L51;
            case 78: goto L13;
            case 80: goto L13;
            case 83: goto L12;
            case 89: goto L13;
            case 90: goto L13;
            case 98: goto L51;
            case 100: goto L51;
            default: goto L7;
        };
    L12:
        char r11 = '\b';
    L91:
        switch(r11) {
            case 1: goto L100;
            case 2: goto L99;
            case 3: goto L98;
            case 4: goto L97;
            case 5: goto L96;
            case 6: goto L95;
            case 7: goto L94;
            case 8: goto L93;
            default: goto L101;
        };     // Catch: Throwable -> L8 RecognitionException -> L10
    L93:
        match(this.input, 83, FOLLOW_EPSILON_in_lexerElement1517);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L101
    L94:
        GrammarAST r12 = (GrammarAST) match(this.input, 59, FOLLOW_SEMPRED_in_lexerElement1507);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        pushFollow(FOLLOW_elementOptions_in_lexerElement1509);     // Catch: Throwable -> L8 RecognitionException -> L10
        elementOptions();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        sempredInAlt((PredAST) r12);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L101
    L95:
        GrammarAST r13 = (GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_lexerElement1494);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        pushFollow(FOLLOW_elementOptions_in_lexerElement1496);     // Catch: Throwable -> L8 RecognitionException -> L10
        elementOptions();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        actionInAlt((ActionAST) r13);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L101
    L96:
        sempredInAlt((PredAST) ((GrammarAST) match(this.input, 59, FOLLOW_SEMPRED_in_lexerElement1479)));     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L101
    L97:
        actionInAlt((ActionAST) ((GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_lexerElement1465)));     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L101
    L98:
        pushFollow(FOLLOW_lexerSubrule_in_lexerElement1458);     // Catch: Throwable -> L8 RecognitionException -> L10
        lexerSubrule();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L101
    L99:
        pushFollow(FOLLOW_lexerAtom_in_lexerElement1453);     // Catch: Throwable -> L8 RecognitionException -> L10
        lexerAtom();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L101
    L100:
        pushFollow(FOLLOW_labeledLexerElement_in_lexerElement1448);     // Catch: Throwable -> L8 RecognitionException -> L10
        labeledLexerElement();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
    L101:
        exitLexerElement((GrammarAST) r5.start);     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L105
    L13:
        r11 = 3;
        goto L91
    L14:
        int r14 = this.input.LA(2);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r14 != 2) goto L17;
        r11 = 7;
        goto L91
    L17:
        if (r14 < 3) goto L19;
        if (r14 > 4) goto L19;
    L50:
        r11 = 5;
    L19:
        if (r14 == 10) goto L50;
        if (r14 == 32) goto L50;
        if (r14 == 39) goto L50;
        if (r14 == 46) goto L50;
        if (r14 == 52) goto L50;
        if (r14 == 57) goto L50;
        if (r14 == 59) goto L50;
        if (r14 == 62) goto L50;
        if (r14 == 66) goto L50;
        if (r14 == 78) goto L50;
        if (r14 == 80) goto L50;
        if (r14 == 83) goto L50;
        if (r14 < 89) goto L40;
        if (r14 <= 90) goto L50;
    L40:
        if (r14 == 98) goto L50;
        if (r14 == 100) goto L50;
        int r15 = this.input.mark();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.input.consume();     // Catch: Throwable -> L47
        throw new NoViableAltException("", 29, 5, this.input);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        this.input.rewind(r15);     // Catch: Throwable -> L8 RecognitionException -> L10
        throw th;     // Catch: Throwable -> L8 RecognitionException -> L10
    L51:
        r11 = 2;
        goto L91
    L52:
        r11 = 1;
        goto L91
    L53:
        int r16 = this.input.LA(2);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r16 != 2) goto L56;
        r11 = 6;
        goto L91
    L56:
        if (r16 < 3) goto L58;
        if (r16 > 4) goto L58;
    L89:
        r11 = 4;
    L58:
        if (r16 == 10) goto L89;
        if (r16 == 32) goto L89;
        if (r16 == 39) goto L89;
        if (r16 == 46) goto L89;
        if (r16 == 52) goto L89;
        if (r16 == 57) goto L89;
        if (r16 == 59) goto L89;
        if (r16 == 62) goto L89;
        if (r16 == 66) goto L89;
        if (r16 == 78) goto L89;
        if (r16 == 80) goto L89;
        if (r16 == 83) goto L89;
        if (r16 < 89) goto L79;
        if (r16 <= 90) goto L89;
    L79:
        if (r16 == 98) goto L89;
        if (r16 == 100) goto L89;
        int r17 = this.input.mark();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.input.consume();     // Catch: Throwable -> L86
        throw new NoViableAltException("", 29, 4, this.input);     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        this.input.rewind(r17);     // Catch: Throwable -> L8 RecognitionException -> L10
        throw th;     // Catch: Throwable -> L8 RecognitionException -> L10
    L7:
        throw new NoViableAltException("", 29, 0, this.input);     // Catch: Throwable -> L8 RecognitionException -> L10
    }

    public final lexerElements_return lexerElements() throws RecognitionException {
        lexerElements_return r5 = new lexerElements_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLexerElements((GrammarAST) r10);
        match(this.input, 74, FOLLOW_ALT_in_lexerElements1420);     // Catch: Throwable -> L41 RecognitionException -> L43
        match(this.input, 2, null);     // Catch: Throwable -> L41 RecognitionException -> L43
        int r11 = 0;
    L4:
        int r12 = this.input.LA(1);     // Catch: Throwable -> L41 RecognitionException -> L43
        if (r12 != 4) goto L7;
    L47:
        pushFollow(FOLLOW_lexerElement_in_lexerElements1422);     // Catch: Throwable -> L41 RecognitionException -> L43
        lexerElement();     // Catch: Throwable -> L41 RecognitionException -> L43
        this.state._fsp--;     // Catch: Throwable -> L41 RecognitionException -> L43
        r11 = r11 + 1;
        goto L4
    L7:
        if (r12 == 10) goto L47;
        if (r12 == 32) goto L47;
        if (r12 == 39) goto L47;
        if (r12 == 46) goto L47;
        if (r12 == 52) goto L47;
        if (r12 == 57) goto L47;
        if (r12 == 59) goto L47;
        if (r12 == 62) goto L47;
        if (r12 == 66) goto L47;
        if (r12 == 78) goto L47;
        if (r12 == 80) goto L47;
        if (r12 == 83) goto L47;
        if (r12 < 89) goto L35;
        if (r12 <= 90) goto L47;
    L35:
        if (r12 == 98) goto L47;
        if (r12 == 100) goto L47;
        if (r11 < 1) goto L46;
        match(this.input, 3, null);     // Catch: Throwable -> L41 RecognitionException -> L43
        exitLexerElements((GrammarAST) r5.start);     // Catch: Throwable -> L41 RecognitionException -> L43
    L51:
        return r5;
    L46:
        throw new EarlyExitException(28, this.input);     // Catch: Throwable -> L41 RecognitionException -> L43
    L43:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L41:
        th = move-exception;
        throw th;
    }

    public final lexerOuterAlternative_return lexerOuterAlternative() throws RecognitionException {
        lexerOuterAlternative_return r5 = new lexerOuterAlternative_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLexerOuterAlternative((AltAST) ((GrammarAST) r10));
        discoverOuterAlt((AltAST) ((GrammarAST) r5.start));
        pushFollow(FOLLOW_lexerAlternative_in_lexerOuterAlternative1332);     // Catch: Throwable -> L5 RecognitionException -> L7
        lexerAlternative();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        finishOuterAlt((AltAST) ((GrammarAST) r5.start));     // Catch: Throwable -> L5 RecognitionException -> L7
        exitLexerOuterAlternative((AltAST) ((GrammarAST) r5.start));     // Catch: Throwable -> L5 RecognitionException -> L7
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

    public final lexerRule_return lexerRule() throws RecognitionException {
        lexerRule_return r5 = new lexerRule_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLexerRule((GrammarAST) r10);
        ArrayList r11 = new ArrayList();
        this.currentOuterAltNumber = 0;
        GrammarAST r12 = (GrammarAST) match(this.input, 94, FOLLOW_RULE_in_lexerRule694);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 2, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r13 = (GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_lexerRule696);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r13 == null) goto L10;
        String r14 = r13.getText();     // Catch: Throwable -> L6 RecognitionException -> L8
    L11:
        this.currentRuleName = r14;     // Catch: Throwable -> L6 RecognitionException -> L8
        this.currentRuleAST = r12;     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this.input.LA(1) != 96) goto L14;
        match(this.input, 96, FOLLOW_RULEMODIFIERS_in_lexerRule708);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 2, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        r11.add((GrammarAST) match(this.input, 24, FOLLOW_FRAGMENT_in_lexerRule712));     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 3, null);     // Catch: Throwable -> L6 RecognitionException -> L8
    L14:
        discoverLexerRule((RuleAST) r12, r13, r11, (GrammarAST) this.input.LT(1));     // Catch: Throwable -> L6 RecognitionException -> L8
        pushFollow(FOLLOW_lexerRuleBlock_in_lexerRule737);     // Catch: Throwable -> L6 RecognitionException -> L8
        lexerRuleBlock_return r15 = lexerRuleBlock();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        RuleAST r16 = (RuleAST) r12;     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r15 == null) goto L17;
        GrammarAST r17 = (GrammarAST) r15.start;     // Catch: Throwable -> L6 RecognitionException -> L8
    L18:
        finishLexerRule(r16, r13, r17);     // Catch: Throwable -> L6 RecognitionException -> L8
        this.currentRuleName = null;     // Catch: Throwable -> L6 RecognitionException -> L8
        this.currentRuleAST = null;     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 3, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        exitLexerRule((GrammarAST) r5.start);     // Catch: Throwable -> L6 RecognitionException -> L8
    L22:
        return r5;
    L17:
        r17 = null;
        goto L18
    L10:
        r14 = null;
    L8:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L6:
        th = move-exception;
        throw th;
    }

    public final lexerRuleBlock_return lexerRuleBlock() throws RecognitionException {
        lexerRuleBlock_return r5 = new lexerRuleBlock_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLexerRuleBlock((GrammarAST) r10);
        match(this.input, 78, FOLLOW_BLOCK_in_lexerRuleBlock1209);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        int r11 = 0;
    L4:
        int r12 = this.input.LA(1);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r12 != 74) goto L7;
    L17:
        this.currentOuterAltRoot = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L11 RecognitionException -> L13
        this.currentOuterAltNumber++;     // Catch: Throwable -> L11 RecognitionException -> L13
        pushFollow(FOLLOW_lexerOuterAlternative_in_lexerRuleBlock1228);     // Catch: Throwable -> L11 RecognitionException -> L13
        lexerOuterAlternative();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        r11 = r11 + 1;
        goto L4
    L7:
        if (r12 == 87) goto L17;
        if (r11 < 1) goto L16;
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        exitLexerRuleBlock((GrammarAST) r5.start);     // Catch: Throwable -> L11 RecognitionException -> L13
    L21:
        return r5;
    L16:
        throw new EarlyExitException(24, this.input);     // Catch: Throwable -> L11 RecognitionException -> L13
    L13:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L11:
        th = move-exception;
        throw th;
    }

    public final lexerSubrule_return lexerSubrule() throws RecognitionException {
        lexerSubrule_return r5 = new lexerSubrule_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLexerSubrule((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r11 != 80) goto L6;
    L19:
        char r12 = 1;
    L20:
        if (r12 == 1) goto L24;
        if (r12 != 2) goto L25;
        pushFollow(FOLLOW_lexerBlock_in_lexerSubrule2112);     // Catch: Throwable -> L15 RecognitionException -> L17
        lexerBlock();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
    L25:
        exitLexerSubrule((GrammarAST) r5.start);     // Catch: Throwable -> L15 RecognitionException -> L17
    L29:
        return r5;
    L24:
        pushFollow(FOLLOW_blockSuffix_in_lexerSubrule2103);     // Catch: Throwable -> L15 RecognitionException -> L17
        blockSuffix();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        match(this.input, 2, null);     // Catch: Throwable -> L15 RecognitionException -> L17
        pushFollow(FOLLOW_lexerBlock_in_lexerSubrule2105);     // Catch: Throwable -> L15 RecognitionException -> L17
        lexerBlock();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        match(this.input, 3, null);     // Catch: Throwable -> L15 RecognitionException -> L17
        goto L25
    L6:
        if (r11 < 89) goto L11;
        if (r11 <= 90) goto L19;
    L11:
        if (r11 != 78) goto L14;
        r12 = 2;
        goto L20
    L14:
        throw new NoViableAltException("", 43, 0, this.input);     // Catch: Throwable -> L15 RecognitionException -> L17
    L17:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L15:
        th = move-exception;
        throw th;
    }

    public final locals_return locals() throws RecognitionException {
        locals_return r5 = new locals_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLocals((GrammarAST) r10);
        match(this.input, 33, FOLLOW_LOCALS_in_locals1045);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 2, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 8, FOLLOW_ARG_ACTION_in_locals1047);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 3, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        exitLocals((GrammarAST) r5.start);     // Catch: Throwable -> L5 RecognitionException -> L7
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

    public final mode_return mode() throws RecognitionException {
        mode_return r5 = new mode_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterMode((GrammarAST) r10);
        GrammarAST r11 = (GrammarAST) match(this.input, 36, FOLLOW_MODE_in_mode662);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 2, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r12 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_mode664);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r12 == null) goto L10;
        String r13 = r12.getText();     // Catch: Throwable -> L6 RecognitionException -> L8
    L11:
        this.currentModeName = r13;     // Catch: Throwable -> L6 RecognitionException -> L8
        modeDef(r11, r12);     // Catch: Throwable -> L6 RecognitionException -> L8
    L13:
        if (this.input.LA(1) != 94) goto L15;
        pushFollow(FOLLOW_lexerRule_in_mode668);     // Catch: Throwable -> L6 RecognitionException -> L8
        lexerRule();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L13
    L15:
        match(this.input, 3, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        exitMode((GrammarAST) r5.start);     // Catch: Throwable -> L6 RecognitionException -> L8
    L19:
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

    public void modeDef(GrammarAST r5, GrammarAST r10) {
    }

    public final option_return option() throws RecognitionException {
        option_return r5 = new option_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterOption((GrammarAST) r10);
        boolean r11 = inContext("RULE ...");
        boolean r12 = inContext("BLOCK ...");
        GrammarAST r13 = (GrammarAST) match(this.input, 10, FOLLOW_ASSIGN_in_option295);     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r14 = null;
        match(this.input, 2, null);     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r15 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_option297);     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_optionValue_in_option301);     // Catch: Throwable -> L7 RecognitionException -> L9
        optionValue_return r16 = optionValue();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        match(this.input, 3, null);     // Catch: Throwable -> L7 RecognitionException -> L9
        if (r12 == false) goto L12;
        if (r16 == null) goto L11;
        r14 = (GrammarAST) r16.start;     // Catch: Throwable -> L7 RecognitionException -> L9
    L11:
        blockOption(r15, r14);     // Catch: Throwable -> L7 RecognitionException -> L9
    L19:
        exitOption((GrammarAST) r5.start);     // Catch: Throwable -> L7 RecognitionException -> L9
    L23:
        return r5;
    L12:
        if (r11 == false) goto L16;
        if (r16 == null) goto L15;
        r14 = (GrammarAST) r16.start;     // Catch: Throwable -> L7 RecognitionException -> L9
    L15:
        ruleOption(r15, r14);     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L19
    L16:
        if (r16 == null) goto L18;
        r14 = (GrammarAST) r16.start;     // Catch: Throwable -> L7 RecognitionException -> L9
    L18:
        grammarOption(r15, r14);     // Catch: Throwable -> L7 RecognitionException -> L9
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L7:
        th = move-exception;
        throw th;
    }

    public final optionValue_return optionValue() throws RecognitionException {
        optionValue_return r5 = new optionValue_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterOptionValue((GrammarAST) r10);
        r5.f651v = ((GrammarAST) r5.start).token.getText();
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L20:
        return r5;
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.input.LA(1) != 28) goto L6;
    L16:
        this.input.consume();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state.errorRecovery = false;     // Catch: Throwable -> L12 RecognitionException -> L14
        exitOptionValue((GrammarAST) r5.start);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L20
    L6:
        if (this.input.LA(1) == 30) goto L16;
        if (this.input.LA(1) == 62) goto L16;
        throw new MismatchedSetException(null, this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
    }

    public final optionsSpec_return optionsSpec() throws RecognitionException {
        optionsSpec_return r5 = new optionsSpec_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterOptionsSpec((GrammarAST) r10);
        match(this.input, 42, FOLLOW_OPTIONS_in_optionsSpec259);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (this.input.LA(1) != 2) goto L14;
        match(this.input, 2, null);     // Catch: Throwable -> L9 RecognitionException -> L11
    L7:
        if (this.input.LA(1) != 10) goto L13;
        pushFollow(FOLLOW_option_in_optionsSpec261);     // Catch: Throwable -> L9 RecognitionException -> L11
        option();     // Catch: Throwable -> L9 RecognitionException -> L11
        this.state._fsp--;     // Catch: Throwable -> L9 RecognitionException -> L11
        goto L7
    L13:
        match(this.input, 3, null);     // Catch: Throwable -> L9 RecognitionException -> L11
    L14:
        exitOptionsSpec((GrammarAST) r5.start);     // Catch: Throwable -> L9 RecognitionException -> L11
    L18:
        return r5;
    L11:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L9:
        th = move-exception;
        throw th;
    }

    public final outerAlternative_return outerAlternative() throws RecognitionException {
        outerAlternative_return r5 = new outerAlternative_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterOuterAlternative((AltAST) ((GrammarAST) r10));
        discoverOuterAlt((AltAST) ((GrammarAST) r5.start));
        pushFollow(FOLLOW_alternative_in_outerAlternative1354);     // Catch: Throwable -> L5 RecognitionException -> L7
        alternative();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        finishOuterAlt((AltAST) ((GrammarAST) r5.start));     // Catch: Throwable -> L5 RecognitionException -> L7
        exitOuterAlternative((AltAST) ((GrammarAST) r5.start));     // Catch: Throwable -> L5 RecognitionException -> L7
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

    public final prequelConstruct_return prequelConstruct() throws RecognitionException {
        prequelConstruct_return r5 = new prequelConstruct_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterPrequelConstructs((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r11 != 11) goto L6;
        char r12 = 5;
    L24:
        if (r12 == 1) goto L34;
        if (r12 == 2) goto L33;
        if (r12 == 3) goto L32;
        if (r12 == 4) goto L31;
        if (r12 != 5) goto L35;
        pushFollow(FOLLOW_action_in_prequelConstruct234);     // Catch: Throwable -> L16 RecognitionException -> L18
        action();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
    L35:
        exitPrequelConstructs((GrammarAST) r5.start);     // Catch: Throwable -> L16 RecognitionException -> L18
    L39:
        return r5;
    L31:
        pushFollow(FOLLOW_channelsSpec_in_prequelConstruct224);     // Catch: Throwable -> L16 RecognitionException -> L18
        channelsSpec();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L35
    L32:
        pushFollow(FOLLOW_tokensSpec_in_prequelConstruct214);     // Catch: Throwable -> L16 RecognitionException -> L18
        tokensSpec();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L35
    L33:
        pushFollow(FOLLOW_delegateGrammars_in_prequelConstruct204);     // Catch: Throwable -> L16 RecognitionException -> L18
        delegateGrammars();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L35
    L34:
        pushFollow(FOLLOW_optionsSpec_in_prequelConstruct194);     // Catch: Throwable -> L16 RecognitionException -> L18
        optionsSpec();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L35
    L6:
        if (r11 != 13) goto L8;
        r12 = 4;
        goto L24
    L8:
        if (r11 != 29) goto L10;
        r12 = 2;
        goto L24
    L10:
        if (r11 != 42) goto L12;
        r12 = 1;
        goto L24
    L12:
        if (r11 != 65) goto L15;
        r12 = 3;
        goto L24
    L15:
        throw new NoViableAltException("", 4, 0, this.input);     // Catch: Throwable -> L16 RecognitionException -> L18
    L18:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L16:
        th = move-exception;
        throw th;
    }

    public final prequelConstructs_return prequelConstructs() throws RecognitionException {
        prequelConstructs_return r5 = new prequelConstructs_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterPrequelConstructs((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L15 RecognitionException -> L17
        int r12 = 0;
        if (r11 == 11) goto L19;
        if (r11 == 13) goto L19;
        if (r11 == 29) goto L19;
        if (r11 == 42) goto L19;
        if (r11 == 65) goto L19;
        if (r11 != 97) goto L14;
    L28:
        exitPrequelConstructs((GrammarAST) r5.start);     // Catch: Throwable -> L15 RecognitionException -> L17
    L35:
        return r5;
    L14:
        throw new NoViableAltException("", 3, 0, this.input);     // Catch: Throwable -> L15 RecognitionException -> L17
    L19:
        r5.firstOne = (GrammarAST) r5.start;     // Catch: Throwable -> L15 RecognitionException -> L17
    L20:
        int r13 = this.input.LA(1);     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r13 == 11) goto L31;
        if (r13 == 13) goto L31;
        if (r13 == 29) goto L31;
        if (r13 == 42) goto L31;
        if (r13 == 65) goto L31;
        if (r12 >= 1) goto L28;
        throw new EarlyExitException(2, this.input);     // Catch: Throwable -> L15 RecognitionException -> L17
    L31:
        pushFollow(FOLLOW_prequelConstruct_in_prequelConstructs167);     // Catch: Throwable -> L15 RecognitionException -> L17
        prequelConstruct();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        r12 = r12 + 1;
    L17:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L15:
        th = move-exception;
        throw th;
    }

    public final range_return range() throws RecognitionException {
        range_return r5 = new range_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterRange((GrammarAST) r10);
        match(this.input, 52, FOLLOW_RANGE_in_range2544);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 2, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_range2546);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 62, FOLLOW_STRING_LITERAL_in_range2548);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 3, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        exitRange((GrammarAST) r5.start);     // Catch: Throwable -> L5 RecognitionException -> L7
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

    public final rule_return rule() throws RecognitionException {
        rule_return r13 = new rule_return();
        Object r5 = this.input.LT(1);
        r13.start = r5;
        enterRule((GrammarAST) r5);
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        int r12 = 0;
        this.currentOuterAltNumber = 0;
        GrammarAST r15 = (GrammarAST) match(this.input, 94, FOLLOW_RULE_in_rule782);     // Catch: Throwable -> L6 RecognitionException -> L8
        char r14 = 2;
        match(this.input, 2, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r16 = (GrammarAST) match(this.input, 57, FOLLOW_RULE_REF_in_rule784);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r16 == null) goto L10;
        String r17 = r16.getText();     // Catch: Throwable -> L6 RecognitionException -> L8
    L11:
        this.currentRuleName = r17;     // Catch: Throwable -> L6 RecognitionException -> L8
        this.currentRuleAST = r15;     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this.input.LA(1) != 96) goto L31;
        match(this.input, 96, FOLLOW_RULEMODIFIERS_in_rule793);     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 2, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r18 = 0;
    L14:
        int r19 = this.input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r19 != 24) goto L17;
    L25:
        pushFollow(FOLLOW_ruleModifier_in_rule798);     // Catch: Throwable -> L6 RecognitionException -> L8
        ruleModifier_return r20 = ruleModifier();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r20 == null) goto L28;
        GrammarAST r21 = (GrammarAST) r20.start;     // Catch: Throwable -> L6 RecognitionException -> L8
    L29:
        r10.add(r21);     // Catch: Throwable -> L6 RecognitionException -> L8
        r18 = r18 + 1;     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L14
    L28:
        r21 = null;
        goto L29
    L17:
        if (r19 < 48) goto L21;
        if (r19 <= 50) goto L25;
    L21:
        if (r18 < 1) goto L24;
        match(this.input, 3, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L31
    L24:
        throw new EarlyExitException(14, this.input);     // Catch: Throwable -> L6 RecognitionException -> L8
    L31:
        if (this.input.LA(1) != 8) goto L33;
        GrammarAST r22 = (GrammarAST) match(this.input, 8, FOLLOW_ARG_ACTION_in_rule809);     // Catch: Throwable -> L6 RecognitionException -> L8
    L35:
        if (this.input.LA(1) != 55) goto L37;
        pushFollow(FOLLOW_ruleReturns_in_rule822);     // Catch: Throwable -> L6 RecognitionException -> L8
        ruleReturns_return r23 = ruleReturns();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
    L39:
        if (this.input.LA(1) != 64) goto L41;
        pushFollow(FOLLOW_throwsSpec_in_rule835);     // Catch: Throwable -> L6 RecognitionException -> L8
        throwsSpec_return r24 = throwsSpec();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
    L43:
        if (this.input.LA(1) != 33) goto L45;
        pushFollow(FOLLOW_locals_in_rule848);     // Catch: Throwable -> L6 RecognitionException -> L8
        locals_return r25 = locals();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        optionsSpec_return r26 = null;
    L46:
        int r27 = this.input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r27 != 42) goto L50;
        char r28 = 1;
    L53:
        if (r28 == 1) goto L91;
        if (r28 != r14) goto L55;
        pushFollow(FOLLOW_ruleAction_in_rule877);     // Catch: Throwable -> L6 RecognitionException -> L8
        ruleAction_return r29 = ruleAction();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r29 == null) goto L89;
        GrammarAST r30 = (GrammarAST) r29.start;     // Catch: Throwable -> L6 RecognitionException -> L8
    L90:
        r11.add(r30);     // Catch: Throwable -> L6 RecognitionException -> L8
    L93:
        r16 = r16;
        r12 = 0;
        r14 = 2;
        goto L46
    L89:
        r30 = null;
        goto L90
    L55:
        RuleAST r31 = (RuleAST) r15;     // Catch: Throwable -> L6 RecognitionException -> L8
        ActionAST r32 = (ActionAST) r22;     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r23 == null) goto L58;
        GrammarAST r33 = (GrammarAST) r23.start;     // Catch: Throwable -> L6 RecognitionException -> L8
    L59:
        if (r33 == null) goto L64;
        if (r23 == null) goto L62;
        GrammarAST r34 = (GrammarAST) r23.start;     // Catch: Throwable -> L6 RecognitionException -> L8
    L63:
        ActionAST r110 = (ActionAST) r34.getChild(r12);     // Catch: Throwable -> L6 RecognitionException -> L8
    L65:
        if (r24 == null) goto L67;
        GrammarAST r111 = (GrammarAST) r24.start;     // Catch: Throwable -> L6 RecognitionException -> L8
    L68:
        if (r26 == null) goto L70;
        GrammarAST r112 = (GrammarAST) r26.start;     // Catch: Throwable -> L6 RecognitionException -> L8
    L71:
        if (r25 == null) goto L73;
        GrammarAST r35 = (GrammarAST) r25.start;     // Catch: Throwable -> L6 RecognitionException -> L8
    L74:
        if (r35 == null) goto L79;
        if (r25 == null) goto L77;
        GrammarAST r36 = (GrammarAST) r25.start;     // Catch: Throwable -> L6 RecognitionException -> L8
    L78:
        ActionAST r37 = (ActionAST) r36.getChild(r12);     // Catch: Throwable -> L6 RecognitionException -> L8
    L80:
        GrammarAST r113 = r16;
        discoverRule(r31, r16, r10, r32, r110, r111, r112, r37, r11, (GrammarAST) this.input.LT(1));     // Catch: Throwable -> L6 RecognitionException -> L8
        pushFollow(FOLLOW_ruleBlock_in_rule908);     // Catch: Throwable -> L6 RecognitionException -> L8
        ruleBlock_return r38 = ruleBlock();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        pushFollow(FOLLOW_exceptionGroup_in_rule910);     // Catch: Throwable -> L6 RecognitionException -> L8
        exceptionGroup();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        RuleAST r114 = (RuleAST) r15;     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r38 == null) goto L84;
        GrammarAST r115 = (GrammarAST) r38.start;     // Catch: Throwable -> L6 RecognitionException -> L8
    L85:
        finishRule(r114, r113, r115);     // Catch: Throwable -> L6 RecognitionException -> L8
        this.currentRuleName = null;     // Catch: Throwable -> L6 RecognitionException -> L8
        this.currentRuleAST = null;     // Catch: Throwable -> L6 RecognitionException -> L8
        match(this.input, 3, null);     // Catch: Throwable -> L6 RecognitionException -> L8
        exitRule((GrammarAST) r13.start);     // Catch: Throwable -> L6 RecognitionException -> L8
    L96:
        return r13;
    L84:
        r115 = null;
        goto L85
    L77:
        r36 = null;
        goto L78
    L79:
        r37 = null;
        goto L80
    L73:
        r35 = null;
        goto L74
    L70:
        r112 = null;
        goto L71
    L67:
        r111 = null;
        goto L68
    L62:
        r34 = null;
        goto L63
    L64:
        r110 = null;
        goto L65
    L58:
        r33 = null;
        goto L59
    L91:
        pushFollow(FOLLOW_optionsSpec_in_rule863);     // Catch: Throwable -> L6 RecognitionException -> L8
        optionsSpec_return r39 = optionsSpec();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r26 = r39;
        goto L93
    L50:
        if (r27 != 11) goto L52;
        r28 = r14;
        goto L53
    L52:
        r28 = 3;
        goto L53
    L45:
        r25 = null;
        r26 = null;
        goto L46
    L41:
        r24 = null;
        goto L43
    L37:
        r23 = null;
        goto L39
    L33:
        r22 = null;
        goto L35
    L10:
        r17 = null;
    L8:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L6:
        th = move-exception;
        throw th;
    }

    public final ruleAction_return ruleAction() throws RecognitionException {
        ruleAction_return r5 = new ruleAction_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterRuleAction((GrammarAST) r10);
        match(this.input, 11, FOLLOW_AT_in_ruleAction1127);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 2, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 28, FOLLOW_ID_in_ruleAction1129);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 4, FOLLOW_ACTION_in_ruleAction1131);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 3, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        exitRuleAction((GrammarAST) r5.start);     // Catch: Throwable -> L5 RecognitionException -> L7
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

    public final ruleBlock_return ruleBlock() throws RecognitionException {
        ruleBlock_return r5 = new ruleBlock_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterRuleBlock((GrammarAST) r10);
        match(this.input, 78, FOLLOW_BLOCK_in_ruleBlock1273);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(this.input, 2, null);     // Catch: Throwable -> L7 RecognitionException -> L9
        int r11 = 0;
    L5:
        if (this.input.LA(1) != 74) goto L11;
        this.currentOuterAltRoot = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L7 RecognitionException -> L9
        this.currentOuterAltNumber++;     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_outerAlternative_in_ruleBlock1292);     // Catch: Throwable -> L7 RecognitionException -> L9
        outerAlternative();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r11 = r11 + 1;     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        if (r11 < 1) goto L14;
        match(this.input, 3, null);     // Catch: Throwable -> L7 RecognitionException -> L9
        exitRuleBlock((GrammarAST) r5.start);     // Catch: Throwable -> L7 RecognitionException -> L9
    L17:
        return r5;
    L14:
        throw new EarlyExitException(25, this.input);     // Catch: Throwable -> L7 RecognitionException -> L9
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L7:
        th = move-exception;
        throw th;
    }

    public void ruleCatch(GrammarAST r5, ActionAST r10) {
    }

    public final ruleModifier_return ruleModifier() throws RecognitionException {
        ruleModifier_return r5 = new ruleModifier_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterRuleModifier((GrammarAST) r10);
    L12:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L20:
        return r5;
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.input.LA(1) != 24) goto L6;
    L16:
        this.input.consume();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.state.errorRecovery = false;     // Catch: Throwable -> L10 RecognitionException -> L12
        exitRuleModifier((GrammarAST) r5.start);     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L20
    L6:
        if (this.input.LA(1) < 48) goto L15;
        if (this.input.LA(1) <= 50) goto L16;
    L15:
        throw new MismatchedSetException(null, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    }

    public void ruleOption(GrammarAST r5, GrammarAST r10) {
    }

    public void ruleRef(GrammarAST r5, ActionAST r10) {
    }

    public final ruleReturns_return ruleReturns() throws RecognitionException {
        ruleReturns_return r5 = new ruleReturns_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterRuleReturns((GrammarAST) r10);
        match(this.input, 55, FOLLOW_RETURNS_in_ruleReturns1070);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 2, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 8, FOLLOW_ARG_ACTION_in_ruleReturns1072);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 3, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        exitRuleReturns((GrammarAST) r5.start);     // Catch: Throwable -> L5 RecognitionException -> L7
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

    public final ruleref_return ruleref() throws RecognitionException {
        ruleref_return r5 = new ruleref_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterRuleref((GrammarAST) r10);
        GrammarAST r11 = (GrammarAST) match(this.input, 57, FOLLOW_RULE_REF_in_ruleref2500);     // Catch: Throwable -> L8 RecognitionException -> L10
        GrammarAST r12 = null;
        if (this.input.LA(1) != 2) goto L17;
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this.input.LA(1) != 8) goto L12;
        GrammarAST r13 = (GrammarAST) match(this.input, 8, FOLLOW_ARG_ACTION_in_ruleref2504);     // Catch: Throwable -> L8 RecognitionException -> L10
    L14:
        if (this.input.LA(1) != 82) goto L16;
        pushFollow(FOLLOW_elementOptions_in_ruleref2507);     // Catch: Throwable -> L8 RecognitionException -> L10
        elementOptions();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
    L16:
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        r12 = r13;
        goto L17
    L12:
        r13 = null;
    L17:
        ruleRef(r11, (ActionAST) r12);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r12 == null) goto L20;
        actionInAlt((ActionAST) r12);     // Catch: Throwable -> L8 RecognitionException -> L10
    L20:
        exitRuleref((GrammarAST) r5.start);     // Catch: Throwable -> L8 RecognitionException -> L10
    L24:
        return r5;
    L10:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L8:
        th = move-exception;
        throw th;
    }

    public final rules_return rules() throws RecognitionException {
        rules_return r5 = new rules_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterRules((GrammarAST) r10);
        GrammarAST r11 = (GrammarAST) match(this.input, 97, FOLLOW_RULES_in_rules624);     // Catch: Throwable -> L16 RecognitionException -> L18
        discoverRules(r11);     // Catch: Throwable -> L16 RecognitionException -> L18
        if (this.input.LA(1) != 2) goto L26;
        match(this.input, 2, null);     // Catch: Throwable -> L16 RecognitionException -> L18
    L7:
        if (this.input.LA(1) == 94) goto L9;
    L20:
        char r12 = 3;
    L21:
        if (r12 != 1) goto L22;
        pushFollow(FOLLOW_rule_in_rules629);     // Catch: Throwable -> L16 RecognitionException -> L18
        rule();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L7
    L22:
        if (r12 != 2) goto L23;
        pushFollow(FOLLOW_lexerRule_in_rules631);     // Catch: Throwable -> L16 RecognitionException -> L18
        lexerRule();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L7
    L23:
        finishRules(r11);     // Catch: Throwable -> L16 RecognitionException -> L18
        match(this.input, 3, null);     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L26
    L9:
        if (this.input.LA(2) != 2) goto L20;
        int r13 = this.input.LA(3);     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r13 != 57) goto L14;
        r12 = 1;
        goto L21
    L14:
        if (r13 != 66) goto L20;
        r12 = 2;
    L26:
        exitRules((GrammarAST) r5.start);     // Catch: Throwable -> L16 RecognitionException -> L18
    L30:
        return r5;
    L18:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L16:
        th = move-exception;
        throw th;
    }

    public void sempredInAlt(PredAST r5) {
    }

    public final setElement_return setElement() throws RecognitionException {
        setElement_return r5 = new setElement_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterSetElement((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L25 RecognitionException -> L27
        if (r11 == 32) goto L49;
        if (r11 != 52) goto L8;
        char r12 = 5;
    L51:
        switch(r12) {
            case 1: goto L58;
            case 2: goto L57;
            case 3: goto L56;
            case 4: goto L55;
            case 5: goto L54;
            case 6: goto L53;
            default: goto L59;
        };     // Catch: Throwable -> L25 RecognitionException -> L27
    L53:
        match(this.input, 32, FOLLOW_LEXER_CHAR_SET_in_setElement2434);     // Catch: Throwable -> L25 RecognitionException -> L27
        goto L59
    L54:
        match(this.input, 52, FOLLOW_RANGE_in_setElement2403);     // Catch: Throwable -> L25 RecognitionException -> L27
        match(this.input, 2, null);     // Catch: Throwable -> L25 RecognitionException -> L27
        GrammarAST r13 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement2407);     // Catch: Throwable -> L25 RecognitionException -> L27
        GrammarAST r14 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement2411);     // Catch: Throwable -> L25 RecognitionException -> L27
        match(this.input, 3, null);     // Catch: Throwable -> L25 RecognitionException -> L27
        stringRef((TerminalAST) r13);     // Catch: Throwable -> L25 RecognitionException -> L27
        stringRef((TerminalAST) r14);     // Catch: Throwable -> L25 RecognitionException -> L27
        goto L59
    L55:
        tokenRef((TerminalAST) ((GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_setElement2374)));     // Catch: Throwable -> L25 RecognitionException -> L27
        goto L59
    L56:
        stringRef((TerminalAST) ((GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement2349)));     // Catch: Throwable -> L25 RecognitionException -> L27
        goto L59
    L57:
        GrammarAST r15 = (GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_setElement2337);     // Catch: Throwable -> L25 RecognitionException -> L27
        match(this.input, 2, null);     // Catch: Throwable -> L25 RecognitionException -> L27
        pushFollow(FOLLOW_elementOptions_in_setElement2339);     // Catch: Throwable -> L25 RecognitionException -> L27
        elementOptions();     // Catch: Throwable -> L25 RecognitionException -> L27
        this.state._fsp--;     // Catch: Throwable -> L25 RecognitionException -> L27
        match(this.input, 3, null);     // Catch: Throwable -> L25 RecognitionException -> L27
        tokenRef((TerminalAST) r15);     // Catch: Throwable -> L25 RecognitionException -> L27
        goto L59
    L58:
        GrammarAST r16 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement2323);     // Catch: Throwable -> L25 RecognitionException -> L27
        match(this.input, 2, null);     // Catch: Throwable -> L25 RecognitionException -> L27
        pushFollow(FOLLOW_elementOptions_in_setElement2325);     // Catch: Throwable -> L25 RecognitionException -> L27
        elementOptions();     // Catch: Throwable -> L25 RecognitionException -> L27
        this.state._fsp--;     // Catch: Throwable -> L25 RecognitionException -> L27
        match(this.input, 3, null);     // Catch: Throwable -> L25 RecognitionException -> L27
        stringRef((TerminalAST) r16);     // Catch: Throwable -> L25 RecognitionException -> L27
    L59:
        exitSetElement((GrammarAST) r5.start);     // Catch: Throwable -> L25 RecognitionException -> L27
    L63:
        return r5;
    L8:
        if (r11 == 62) goto L32;
        if (r11 != 66) goto L31;
        int r17 = this.input.LA(2);     // Catch: Throwable -> L25 RecognitionException -> L27
        if (r17 != 2) goto L13;
        r12 = 2;
        goto L51
    L13:
        if (r17 == 3) goto L29;
        if (r17 == 32) goto L29;
        if (r17 == 52) goto L29;
        if (r17 == 62) goto L29;
        if (r17 == 66) goto L29;
        int r18 = this.input.mark();     // Catch: Throwable -> L25 RecognitionException -> L27
        this.input.consume();     // Catch: Throwable -> L22
        throw new NoViableAltException("", 46, 2, this.input);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.input.rewind(r18);     // Catch: Throwable -> L25 RecognitionException -> L27
        throw th;     // Catch: Throwable -> L25 RecognitionException -> L27
    L29:
        r12 = 4;
        goto L51
    L31:
        throw new NoViableAltException("", 46, 0, this.input);     // Catch: Throwable -> L25 RecognitionException -> L27
    L32:
        int r19 = this.input.LA(2);     // Catch: Throwable -> L25 RecognitionException -> L27
        if (r19 != 2) goto L35;
        r12 = 1;
        goto L51
    L35:
        if (r19 == 3) goto L47;
        if (r19 == 32) goto L47;
        if (r19 == 52) goto L47;
        if (r19 == 62) goto L47;
        if (r19 == 66) goto L47;
        int r20 = this.input.mark();     // Catch: Throwable -> L25 RecognitionException -> L27
        this.input.consume();     // Catch: Throwable -> L44
        throw new NoViableAltException("", 46, 1, this.input);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        this.input.rewind(r20);     // Catch: Throwable -> L25 RecognitionException -> L27
        throw th;     // Catch: Throwable -> L25 RecognitionException -> L27
    L47:
        r12 = 3;
        goto L51
    L49:
        r12 = 6;
    L27:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L25:
        th = move-exception;
        throw th;
    }

    public void stringRef(TerminalAST r5) {
    }

    public final subrule_return subrule() throws RecognitionException {
        subrule_return r5 = new subrule_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterSubrule((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r11 != 80) goto L6;
    L19:
        char r12 = 1;
    L20:
        if (r12 == 1) goto L24;
        if (r12 != 2) goto L25;
        pushFollow(FOLLOW_block_in_subrule2078);     // Catch: Throwable -> L15 RecognitionException -> L17
        block();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
    L25:
        exitSubrule((GrammarAST) r5.start);     // Catch: Throwable -> L15 RecognitionException -> L17
    L29:
        return r5;
    L24:
        pushFollow(FOLLOW_blockSuffix_in_subrule2069);     // Catch: Throwable -> L15 RecognitionException -> L17
        blockSuffix();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        match(this.input, 2, null);     // Catch: Throwable -> L15 RecognitionException -> L17
        pushFollow(FOLLOW_block_in_subrule2071);     // Catch: Throwable -> L15 RecognitionException -> L17
        block();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        match(this.input, 3, null);     // Catch: Throwable -> L15 RecognitionException -> L17
        goto L25
    L6:
        if (r11 < 89) goto L11;
        if (r11 <= 90) goto L19;
    L11:
        if (r11 != 78) goto L14;
        r12 = 2;
        goto L20
    L14:
        throw new NoViableAltException("", 42, 0, this.input);     // Catch: Throwable -> L15 RecognitionException -> L17
    L17:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L15:
        th = move-exception;
        throw th;
    }

    public final terminal_return terminal() throws RecognitionException {
        terminal_return r5 = new terminal_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterTerminal((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L45 RecognitionException -> L47
        if (r11 != 62) goto L51;
        int r12 = this.input.LA(2);     // Catch: Throwable -> L45 RecognitionException -> L47
        if (r12 != 2) goto L9;
        char r13 = 1;
    L94:
        if (r13 == 1) goto L102;
        if (r13 == 2) goto L101;
        if (r13 == 3) goto L100;
        if (r13 != 4) goto L103;
        tokenRef((TerminalAST) ((GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_terminal2630)));     // Catch: Throwable -> L45 RecognitionException -> L47
    L103:
        exitTerminal((GrammarAST) r5.start);     // Catch: Throwable -> L45 RecognitionException -> L47
    L108:
        return r5;
    L100:
        GrammarAST r14 = (GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_terminal2617);     // Catch: Throwable -> L45 RecognitionException -> L47
        match(this.input, 2, null);     // Catch: Throwable -> L45 RecognitionException -> L47
        pushFollow(FOLLOW_elementOptions_in_terminal2619);     // Catch: Throwable -> L45 RecognitionException -> L47
        elementOptions();     // Catch: Throwable -> L45 RecognitionException -> L47
        this.state._fsp--;     // Catch: Throwable -> L45 RecognitionException -> L47
        match(this.input, 3, null);     // Catch: Throwable -> L45 RecognitionException -> L47
        tokenRef((TerminalAST) r14);     // Catch: Throwable -> L45 RecognitionException -> L47
        goto L103
    L101:
        stringRef((TerminalAST) ((GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_terminal2603)));     // Catch: Throwable -> L45 RecognitionException -> L47
        goto L103
    L102:
        GrammarAST r15 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_terminal2578);     // Catch: Throwable -> L45 RecognitionException -> L47
        match(this.input, 2, null);     // Catch: Throwable -> L45 RecognitionException -> L47
        pushFollow(FOLLOW_elementOptions_in_terminal2580);     // Catch: Throwable -> L45 RecognitionException -> L47
        elementOptions();     // Catch: Throwable -> L45 RecognitionException -> L47
        this.state._fsp--;     // Catch: Throwable -> L45 RecognitionException -> L47
        match(this.input, 3, null);     // Catch: Throwable -> L45 RecognitionException -> L47
        stringRef((TerminalAST) r15);     // Catch: Throwable -> L45 RecognitionException -> L47
        goto L103
    L9:
        if (r12 == (-1)) goto L49;
        if (r12 < 3) goto L12;
        if (r12 <= 4) goto L49;
    L12:
        if (r12 == 10) goto L49;
        if (r12 == 20) goto L49;
        if (r12 == 32) goto L49;
        if (r12 == 39) goto L49;
        if (r12 == 46) goto L49;
        if (r12 == 52) goto L49;
        if (r12 == 57) goto L49;
        if (r12 == 59) goto L49;
        if (r12 == 62) goto L49;
        if (r12 == 66) goto L49;
        if (r12 == 78) goto L49;
        if (r12 == 80) goto L49;
        if (r12 == 83) goto L49;
        if (r12 < 89) goto L35;
        if (r12 <= 90) goto L49;
    L35:
        if (r12 == 98) goto L49;
        if (r12 == 100) goto L49;
        int r16 = this.input.mark();     // Catch: Throwable -> L45 RecognitionException -> L47
        this.input.consume();     // Catch: Throwable -> L42
        throw new NoViableAltException("", 53, 1, this.input);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        this.input.rewind(r16);     // Catch: Throwable -> L45 RecognitionException -> L47
        throw th;     // Catch: Throwable -> L45 RecognitionException -> L47
    L49:
        r13 = 2;
        goto L94
    L51:
        if (r11 != 66) goto L105;
        int r17 = this.input.LA(2);     // Catch: Throwable -> L45 RecognitionException -> L47
        if (r17 != 2) goto L55;
        r13 = 3;
        goto L94
    L55:
        if (r17 == (-1)) goto L92;
        if (r17 < 3) goto L58;
        if (r17 <= 4) goto L92;
    L58:
        if (r17 == 10) goto L92;
        if (r17 == 20) goto L92;
        if (r17 == 32) goto L92;
        if (r17 == 39) goto L92;
        if (r17 == 46) goto L92;
        if (r17 == 52) goto L92;
        if (r17 == 57) goto L92;
        if (r17 == 59) goto L92;
        if (r17 == 62) goto L92;
        if (r17 == 66) goto L92;
        if (r17 == 78) goto L92;
        if (r17 == 80) goto L92;
        if (r17 == 83) goto L92;
        if (r17 < 89) goto L82;
        if (r17 <= 90) goto L92;
    L82:
        if (r17 == 98) goto L92;
        if (r17 == 100) goto L92;
        int r18 = this.input.mark();     // Catch: Throwable -> L45 RecognitionException -> L47
        this.input.consume();     // Catch: Throwable -> L89
        throw new NoViableAltException("", 53, 2, this.input);     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        this.input.rewind(r18);     // Catch: Throwable -> L45 RecognitionException -> L47
        throw th;     // Catch: Throwable -> L45 RecognitionException -> L47
    L92:
        r13 = 4;
        goto L94
    L105:
        throw new NoViableAltException("", 53, 0, this.input);     // Catch: Throwable -> L45 RecognitionException -> L47
    L47:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L45:
        th = move-exception;
        throw th;
    }

    public final throwsSpec_return throwsSpec() throws RecognitionException {
        throwsSpec_return r5 = new throwsSpec_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterThrowsSpec((GrammarAST) r10);
        match(this.input, 64, FOLLOW_THROWS_in_throwsSpec1098);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(this.input, 2, null);     // Catch: Throwable -> L7 RecognitionException -> L9
        int r11 = 0;
    L5:
        if (this.input.LA(1) != 28) goto L11;
        match(this.input, 28, FOLLOW_ID_in_throwsSpec1100);     // Catch: Throwable -> L7 RecognitionException -> L9
        r11 = r11 + 1;     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        if (r11 < 1) goto L14;
        match(this.input, 3, null);     // Catch: Throwable -> L7 RecognitionException -> L9
        exitThrowsSpec((GrammarAST) r5.start);     // Catch: Throwable -> L7 RecognitionException -> L9
    L17:
        return r5;
    L14:
        throw new EarlyExitException(23, this.input);     // Catch: Throwable -> L7 RecognitionException -> L9
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L7:
        th = move-exception;
        throw th;
    }

    public void tokenRef(TerminalAST r5) {
    }

    public final tokenSpec_return tokenSpec() throws RecognitionException {
        tokenSpec_return r5 = new tokenSpec_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterTokenSpec((GrammarAST) r10);
        defineToken((GrammarAST) match(this.input, 28, FOLLOW_ID_in_tokenSpec502));     // Catch: Throwable -> L5 RecognitionException -> L7
        exitTokenSpec((GrammarAST) r5.start);     // Catch: Throwable -> L5 RecognitionException -> L7
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

    public final tokensSpec_return tokensSpec() throws RecognitionException {
        tokensSpec_return r5 = new tokensSpec_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterTokensSpec((GrammarAST) r10);
        match(this.input, 65, FOLLOW_TOKENS_SPEC_in_tokensSpec477);     // Catch: Throwable -> L7 RecognitionException -> L9
        match(this.input, 2, null);     // Catch: Throwable -> L7 RecognitionException -> L9
        int r11 = 0;
    L5:
        if (this.input.LA(1) != 28) goto L11;
        pushFollow(FOLLOW_tokenSpec_in_tokensSpec479);     // Catch: Throwable -> L7 RecognitionException -> L9
        tokenSpec();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r11 = r11 + 1;     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        if (r11 < 1) goto L14;
        match(this.input, 3, null);     // Catch: Throwable -> L7 RecognitionException -> L9
        exitTokensSpec((GrammarAST) r5.start);     // Catch: Throwable -> L7 RecognitionException -> L9
    L17:
        return r5;
    L14:
        throw new EarlyExitException(8, this.input);     // Catch: Throwable -> L7 RecognitionException -> L9
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeParser
    public void traceIn(String r5, int r10) {
        PrintStream r11 = System.err;
        StringBuilder r12 = j0.x("enter ", r5, ": ");
        r12.append(this.input.LT(1));
        r11.println(r12.toString());
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeParser
    public void traceOut(String r5, int r10) {
        PrintStream r11 = System.err;
        StringBuilder r12 = j0.x("exit ", r5, ": ");
        r12.append(this.input.LT(1));
        r11.println(r12.toString());
    }

    public void visit(GrammarAST r5, String r10) {
        setTreeNodeStream(new CommonTreeNodeStream(new GrammarASTAdaptor(), r5));
        getClass().getMethod(r10, null).invoke(this, null);     // Catch: Throwable -> L5
        return;
    L5:
        th = th;
        ErrorManager r11 = getErrorManager();
        if ((th instanceof InvocationTargetException) == false) goto L9;
        th = th.getCause();
    L9:
        if (r11 != null) goto L11;
        PrintStream r12 = System.err;
        StringBuilder r13 = j0.x("can't find rule ", r10, " or tree structure error: ");
        r13.append(r5.toStringTree());
        r12.println(r13.toString());
        th.printStackTrace(r12);
        return;
    L11:
        r11.toolError(ErrorType.INTERNAL_ERROR, th, new Object[0]);
    }

    public void visitGrammar(GrammarAST r5) {
        visit(r5, "grammarSpec");
    }

    public void wildcardRef(GrammarAST r5) {
    }

    public GrammarTreeVisitor(TreeNodeStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.currentModeName = LexerGrammar.DEFAULT_MODE_NAME;
        this.currentOuterAltNumber = 1;
        this.rewriteEBNFLevel = 0;
        this.dfa38 = new DFA38(this, this);
    }

    public final elementOption_return elementOption(GrammarASTWithOptions r15) throws RecognitionException {
        elementOption_return r5 = new elementOption_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterElementOption((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L27 RecognitionException -> L29
        if (r11 != 28) goto L7;
        char r12 = 1;
    L36:
        if (r12 == 1) goto L46;
        if (r12 == 2) goto L45;
        if (r12 == 3) goto L44;
        if (r12 == 4) goto L43;
        if (r12 != 5) goto L47;
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption2786);     // Catch: Throwable -> L27 RecognitionException -> L29
        match(this.input, 2, null);     // Catch: Throwable -> L27 RecognitionException -> L29
        GrammarAST r13 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_elementOption2788);     // Catch: Throwable -> L27 RecognitionException -> L29
        GrammarAST r14 = (GrammarAST) match(this.input, 30, FOLLOW_INT_in_elementOption2792);     // Catch: Throwable -> L27 RecognitionException -> L29
        match(this.input, 3, null);     // Catch: Throwable -> L27 RecognitionException -> L29
        elementOption(r15, r13, r14);     // Catch: Throwable -> L27 RecognitionException -> L29
    L47:
        exitElementOption((GrammarAST) r5.start);     // Catch: Throwable -> L27 RecognitionException -> L29
    L67:
        return r5;
    L43:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption2764);     // Catch: Throwable -> L27 RecognitionException -> L29
        match(this.input, 2, null);     // Catch: Throwable -> L27 RecognitionException -> L29
        GrammarAST r16 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_elementOption2766);     // Catch: Throwable -> L27 RecognitionException -> L29
        GrammarAST r17 = (GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_elementOption2770);     // Catch: Throwable -> L27 RecognitionException -> L29
        match(this.input, 3, null);     // Catch: Throwable -> L27 RecognitionException -> L29
        elementOption(r15, r16, r17);     // Catch: Throwable -> L27 RecognitionException -> L29
        goto L47
    L44:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption2744);     // Catch: Throwable -> L27 RecognitionException -> L29
        match(this.input, 2, null);     // Catch: Throwable -> L27 RecognitionException -> L29
        GrammarAST r18 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_elementOption2746);     // Catch: Throwable -> L27 RecognitionException -> L29
        GrammarAST r19 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_elementOption2750);     // Catch: Throwable -> L27 RecognitionException -> L29
        match(this.input, 3, null);     // Catch: Throwable -> L27 RecognitionException -> L29
        elementOption(r15, r18, r19);     // Catch: Throwable -> L27 RecognitionException -> L29
        goto L47
    L45:
        match(this.input, 10, FOLLOW_ASSIGN_in_elementOption2720);     // Catch: Throwable -> L27 RecognitionException -> L29
        match(this.input, 2, null);     // Catch: Throwable -> L27 RecognitionException -> L29
        GrammarAST r20 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_elementOption2724);     // Catch: Throwable -> L27 RecognitionException -> L29
        GrammarAST r21 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_elementOption2728);     // Catch: Throwable -> L27 RecognitionException -> L29
        match(this.input, 3, null);     // Catch: Throwable -> L27 RecognitionException -> L29
        elementOption(r15, r20, r21);     // Catch: Throwable -> L27 RecognitionException -> L29
        goto L47
    L46:
        elementOption(r15, (GrammarAST) match(this.input, 28, FOLLOW_ID_in_elementOption2700), null);     // Catch: Throwable -> L27 RecognitionException -> L29
        goto L47
    L7:
        int r110 = 0;
        if (r11 != 10) goto L64;
        if (this.input.LA(2) == 2) goto L12;
        int r111 = this.input.mark();     // Catch: Throwable -> L27 RecognitionException -> L29
        this.input.consume();     // Catch: Throwable -> L60
        throw new NoViableAltException("", 55, 2, this.input);     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        this.input.rewind(r111);     // Catch: Throwable -> L27 RecognitionException -> L29
        throw th;     // Catch: Throwable -> L27 RecognitionException -> L29
    L12:
        if (this.input.LA(3) != 28) goto L48;
        int r22 = this.input.LA(4);     // Catch: Throwable -> L27 RecognitionException -> L29
        if (r22 == 4) goto L34;
        if (r22 == 28) goto L33;
        if (r22 == 30) goto L32;
        if (r22 == 62) goto L31;
        int r112 = this.input.mark();     // Catch: Throwable -> L27 RecognitionException -> L29
    L19:
        if (r110 >= 3) goto L24;
        this.input.consume();     // Catch: Throwable -> L21
        r110 = r110 + 1;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        this.input.rewind(r112);     // Catch: Throwable -> L27 RecognitionException -> L29
        throw th;     // Catch: Throwable -> L27 RecognitionException -> L29
    L24:
        throw new NoViableAltException("", 55, 4, this.input);     // Catch: Throwable -> L21
    L31:
        r12 = 3;
        goto L36
    L32:
        r12 = 5;
        goto L36
    L33:
        r12 = 2;
        goto L36
    L34:
        r12 = 4;
        goto L36
    L48:
        int r113 = this.input.mark();     // Catch: Throwable -> L27 RecognitionException -> L29
    L49:
        if (r110 >= 2) goto L54;
        this.input.consume();     // Catch: Throwable -> L51
        r110 = r110 + 1;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        this.input.rewind(r113);     // Catch: Throwable -> L27 RecognitionException -> L29
        throw th;     // Catch: Throwable -> L27 RecognitionException -> L29
    L54:
        throw new NoViableAltException("", 55, 3, this.input);     // Catch: Throwable -> L51
    L64:
        throw new NoViableAltException("", 55, 0, this.input);     // Catch: Throwable -> L27 RecognitionException -> L29
    L29:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L27:
        th = move-exception;
        throw th;
    }

    public final lexerCommand_return lexerCommand() throws RecognitionException {
        lexerCommand_return r5 = new lexerCommand_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        enterLexerCommand((GrammarAST) r10);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r11 != 86) goto L6;
        char r12 = 1;
    L8:
        if (r12 == 1) goto L16;
        if (r12 != 2) goto L20;
        lexerCommand(this.currentOuterAltNumber, (GrammarAST) match(this.input, 28, FOLLOW_ID_in_lexerCommand1831));     // Catch: Throwable -> L12 RecognitionException -> L14
    L20:
        exitLexerCommand((GrammarAST) r5.start);     // Catch: Throwable -> L12 RecognitionException -> L14
    L25:
        return r5;
    L16:
        match(this.input, 86, FOLLOW_LEXER_ACTION_CALL_in_lexerCommand1811);     // Catch: Throwable -> L12 RecognitionException -> L14
        GrammarAST r13 = null;
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        GrammarAST r14 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_lexerCommand1813);     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_lexerCommandExpr_in_lexerCommand1815);     // Catch: Throwable -> L12 RecognitionException -> L14
        lexerCommandExpr_return r15 = lexerCommandExpr();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r16 = this.currentOuterAltNumber;     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r15 == null) goto L19;
        r13 = (GrammarAST) r15.start;     // Catch: Throwable -> L12 RecognitionException -> L14
    L19:
        lexerCallCommand(r16, r14, r13);     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L20
    L6:
        if (r11 != 28) goto L22;
        r12 = 2;
        goto L8
    L22:
        throw new NoViableAltException("", 39, 0, this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L12:
        th = move-exception;
        throw th;
    }

    public GrammarTreeVisitor() {
        this(null);
    }
}
