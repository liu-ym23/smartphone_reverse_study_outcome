package androidx.room.jarjarred.org.antlr.v4.parse;

import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.runtime.EarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.Parser;
import androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeAdaptor;
import androidx.room.jarjarred.org.antlr.runtime.tree.RewriteEarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.RewriteRuleTokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarRootAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.NotAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.OptionalBlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.PlusBlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.PredAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RangeAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleRefAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.SetAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.StarBlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes.dex */
public class ANTLRParser extends Parser {
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
    public static final int DOC_COMMENT = 18;
    public static final int DOLLAR = 19;
    public static final int DOT = 20;
    public static final int ELEMENT_OPTIONS = 82;
    public static final int EOF = -1;
    public static final int EPSILON = 83;
    public static final int ERRCHAR = 21;
    public static final int ESC_SEQ = 22;
    public static final int FINALLY = 23;
    public static final BitSet FOLLOW_ACTION_in_action1299 = null;
    public static final BitSet FOLLOW_ACTION_in_actionElement3103 = null;
    public static final BitSet FOLLOW_ACTION_in_actionElement3113 = null;
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler1776 = null;
    public static final BitSet FOLLOW_ACTION_in_finallyClause1805 = null;
    public static final BitSet FOLLOW_ACTION_in_optionValue1016 = null;
    public static final BitSet FOLLOW_ACTION_in_ruleAction1987 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler1774 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_localsSpec1960 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_parserRule1560 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleReturns1897 = null;
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleref3864 = null;
    public static final BitSet FOLLOW_ASSIGN_in_delegateGrammar1083 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption4086 = null;
    public static final BitSet FOLLOW_ASSIGN_in_labeledElement3172 = null;
    public static final BitSet FOLLOW_ASSIGN_in_labeledLexerElement2538 = null;
    public static final BitSet FOLLOW_ASSIGN_in_option957 = null;
    public static final BitSet FOLLOW_ASSIGN_in_v3tokenSpec1182 = null;
    public static final BitSet FOLLOW_AT_in_action1288 = null;
    public static final BitSet FOLLOW_AT_in_ruleAction1983 = null;
    public static final BitSet FOLLOW_CATCH_in_exceptionHandler1772 = null;
    public static final BitSet FOLLOW_CHANNELS_in_channelsSpec1258 = null;
    public static final BitSet FOLLOW_COLONCOLON_in_action1293 = null;
    public static final BitSet FOLLOW_COLON_in_block3791 = null;
    public static final BitSet FOLLOW_COLON_in_lexerBlock2613 = null;
    public static final BitSet FOLLOW_COLON_in_lexerRule2133 = null;
    public static final BitSet FOLLOW_COLON_in_parserRule1628 = null;
    public static final BitSet FOLLOW_COMMA_in_channelsSpec1264 = null;
    public static final BitSet FOLLOW_COMMA_in_delegateGrammars1048 = null;
    public static final BitSet FOLLOW_COMMA_in_elementOptions4020 = null;
    public static final BitSet FOLLOW_COMMA_in_lexerCommands2678 = null;
    public static final BitSet FOLLOW_COMMA_in_throwsSpec1930 = null;
    public static final BitSet FOLLOW_COMMA_in_tokensSpec1115 = null;
    public static final BitSet FOLLOW_DOT_in_qid4164 = null;
    public static final BitSet FOLLOW_DOT_in_wildcard3565 = null;
    public static final BitSet FOLLOW_EOF_in_alternativeEntry4185 = null;
    public static final BitSet FOLLOW_EOF_in_blockEntry4216 = null;
    public static final BitSet FOLLOW_EOF_in_elementEntry4196 = null;
    public static final BitSet FOLLOW_EOF_in_grammarSpec513 = null;
    public static final BitSet FOLLOW_EOF_in_ruleEntry4206 = null;
    public static final BitSet FOLLOW_FINALLY_in_finallyClause1803 = null;
    public static final BitSet FOLLOW_FRAGMENT_in_lexerRule2125 = null;
    public static final BitSet FOLLOW_GRAMMAR_in_grammarType687 = null;
    public static final BitSet FOLLOW_GRAMMAR_in_grammarType714 = null;
    public static final BitSet FOLLOW_GRAMMAR_in_grammarType735 = null;
    public static final BitSet FOLLOW_GT_in_elementOptions4028 = null;
    public static final BitSet FOLLOW_IMPORT_in_delegateGrammars1043 = null;
    public static final BitSet FOLLOW_INT_in_lexerCommandExpr2735 = null;
    public static final BitSet FOLLOW_INT_in_optionValue1027 = null;
    public static final BitSet FOLLOW_LEXER_CHAR_SET_in_lexerAtom3439 = null;
    public static final BitSet FOLLOW_LEXER_CHAR_SET_in_setElement3747 = null;
    public static final BitSet FOLLOW_LEXER_in_actionScopeName1333 = null;
    public static final BitSet FOLLOW_LEXER_in_grammarType683 = null;
    public static final BitSet FOLLOW_LOCALS_in_localsSpec1957 = null;
    public static final BitSet FOLLOW_LPAREN_in_block3771 = null;
    public static final BitSet FOLLOW_LPAREN_in_blockSet3672 = null;
    public static final BitSet FOLLOW_LPAREN_in_lexerBlock2599 = null;
    public static final BitSet FOLLOW_LPAREN_in_lexerCommand2700 = null;
    public static final BitSet FOLLOW_LT_in_elementOptions4014 = null;
    public static final BitSet FOLLOW_MODE_in_lexerCommandName2777 = null;
    public static final BitSet FOLLOW_MODE_in_modeSpec1367 = null;
    public static final BitSet FOLLOW_NOT_in_notSet3605 = null;
    public static final BitSet FOLLOW_NOT_in_notSet3635 = null;
    public static final BitSet FOLLOW_OPTIONS_in_optionsSpec917 = null;
    public static final BitSet FOLLOW_OR_in_altList2808 = null;
    public static final BitSet FOLLOW_OR_in_blockSet3677 = null;
    public static final BitSet FOLLOW_OR_in_lexerAltList2240 = null;
    public static final BitSet FOLLOW_OR_in_ruleAltList2064 = null;
    public static final BitSet FOLLOW_PARSER_in_actionScopeName1348 = null;
    public static final BitSet FOLLOW_PARSER_in_grammarType710 = null;
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_labeledElement3176 = null;
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_labeledLexerElement2542 = null;
    public static final BitSet FOLLOW_PLUS_in_ebnfSuffix3372 = null;
    public static final BitSet FOLLOW_POUND_in_labeledAlt2090 = null;
    public static final BitSet FOLLOW_QUESTION_in_ebnfSuffix3330 = null;
    public static final BitSet FOLLOW_QUESTION_in_ebnfSuffix3334 = null;
    public static final BitSet FOLLOW_QUESTION_in_ebnfSuffix3354 = null;
    public static final BitSet FOLLOW_QUESTION_in_ebnfSuffix3376 = null;
    public static final BitSet FOLLOW_RANGE_in_range3928 = null;
    public static final BitSet FOLLOW_RARROW_in_lexerCommands2673 = null;
    public static final BitSet FOLLOW_RBRACE_in_channelsSpec1271 = null;
    public static final BitSet FOLLOW_RBRACE_in_optionsSpec926 = null;
    public static final BitSet FOLLOW_RBRACE_in_tokensSpec1121 = null;
    public static final BitSet FOLLOW_RBRACE_in_tokensSpec1140 = null;
    public static final BitSet FOLLOW_RBRACE_in_tokensSpec1156 = null;
    public static final BitSet FOLLOW_RETURNS_in_ruleReturns1894 = null;
    public static final BitSet FOLLOW_RPAREN_in_block3808 = null;
    public static final BitSet FOLLOW_RPAREN_in_blockSet3683 = null;
    public static final BitSet FOLLOW_RPAREN_in_lexerBlock2636 = null;
    public static final BitSet FOLLOW_RPAREN_in_lexerCommand2704 = null;
    public static final BitSet FOLLOW_RULE_REF_in_id4120 = null;
    public static final BitSet FOLLOW_RULE_REF_in_lexerAtom3412 = null;
    public static final BitSet FOLLOW_RULE_REF_in_parserRule1530 = null;
    public static final BitSet FOLLOW_RULE_REF_in_ruleref3862 = null;
    public static final BitSet FOLLOW_SEMI_in_delegateGrammars1054 = null;
    public static final BitSet FOLLOW_SEMI_in_grammarSpec400 = null;
    public static final BitSet FOLLOW_SEMI_in_lexerRule2137 = null;
    public static final BitSet FOLLOW_SEMI_in_modeSpec1371 = null;
    public static final BitSet FOLLOW_SEMI_in_optionsSpec922 = null;
    public static final BitSet FOLLOW_SEMI_in_parserRule1660 = null;
    public static final BitSet FOLLOW_SEMI_in_v3tokenSpec1247 = null;
    public static final BitSet FOLLOW_SEMPRED_in_actionElement3133 = null;
    public static final BitSet FOLLOW_SEMPRED_in_actionElement3143 = null;
    public static final BitSet FOLLOW_STAR_in_ebnfSuffix3350 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_optionValue1011 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_range3923 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_range3934 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement3725 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal3981 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_v3tokenSpec1186 = null;
    public static final BitSet FOLLOW_THROWS_in_throwsSpec1925 = null;
    public static final BitSet FOLLOW_TOKENS_SPEC_in_tokensSpec1110 = null;
    public static final BitSet FOLLOW_TOKENS_SPEC_in_tokensSpec1138 = null;
    public static final BitSet FOLLOW_TOKENS_SPEC_in_tokensSpec1150 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_id4133 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_lexerRule2131 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement3713 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal3958 = null;
    public static final BitSet FOLLOW_TREE_GRAMMAR_in_grammarType762 = null;
    public static final BitSet FOLLOW_actionElement_in_element3077 = null;
    public static final BitSet FOLLOW_actionElement_in_lexerElement2503 = null;
    public static final BitSet FOLLOW_actionScopeName_in_action1291 = null;
    public static final BitSet FOLLOW_action_in_prequelConstruct902 = null;
    public static final BitSet FOLLOW_altList_in_block3804 = null;
    public static final BitSet FOLLOW_alternative_in_altList2805 = null;
    public static final BitSet FOLLOW_alternative_in_altList2810 = null;
    public static final BitSet FOLLOW_alternative_in_alternativeEntry4183 = null;
    public static final BitSet FOLLOW_alternative_in_labeledAlt2084 = null;
    public static final BitSet FOLLOW_atom_in_element3020 = null;
    public static final BitSet FOLLOW_atom_in_labeledElement3183 = null;
    public static final BitSet FOLLOW_blockSet_in_notSet3637 = null;
    public static final BitSet FOLLOW_blockSuffix_in_ebnf3265 = null;
    public static final BitSet FOLLOW_block_in_blockEntry4214 = null;
    public static final BitSet FOLLOW_block_in_ebnf3241 = null;
    public static final BitSet FOLLOW_block_in_labeledElement3205 = null;
    public static final BitSet FOLLOW_channelsSpec_in_prequelConstruct865 = null;
    public static final BitSet FOLLOW_delegateGrammar_in_delegateGrammars1045 = null;
    public static final BitSet FOLLOW_delegateGrammar_in_delegateGrammars1050 = null;
    public static final BitSet FOLLOW_delegateGrammars_in_prequelConstruct811 = null;
    public static final BitSet FOLLOW_ebnfSuffix_in_blockSuffix3315 = null;
    public static final BitSet FOLLOW_ebnfSuffix_in_element2974 = null;
    public static final BitSet FOLLOW_ebnfSuffix_in_element3026 = null;
    public static final BitSet FOLLOW_ebnfSuffix_in_lexerElement2371 = null;
    public static final BitSet FOLLOW_ebnfSuffix_in_lexerElement2423 = null;
    public static final BitSet FOLLOW_ebnfSuffix_in_lexerElement2475 = null;
    public static final BitSet FOLLOW_ebnf_in_element3072 = null;
    public static final BitSet FOLLOW_elementOption_in_elementOptions4017 = null;
    public static final BitSet FOLLOW_elementOption_in_elementOptions4022 = null;
    public static final BitSet FOLLOW_elementOptions_in_actionElement3115 = null;
    public static final BitSet FOLLOW_elementOptions_in_actionElement3145 = null;
    public static final BitSet FOLLOW_elementOptions_in_alternative2844 = null;
    public static final BitSet FOLLOW_elementOptions_in_ruleref3867 = null;
    public static final BitSet FOLLOW_elementOptions_in_setElement3719 = null;
    public static final BitSet FOLLOW_elementOptions_in_setElement3731 = null;
    public static final BitSet FOLLOW_elementOptions_in_terminal3960 = null;
    public static final BitSet FOLLOW_elementOptions_in_terminal3983 = null;
    public static final BitSet FOLLOW_elementOptions_in_wildcard3567 = null;
    public static final BitSet FOLLOW_element_in_alternative2853 = null;
    public static final BitSet FOLLOW_element_in_elementEntry4194 = null;
    public static final BitSet FOLLOW_exceptionGroup_in_parserRule1669 = null;
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup1752 = null;
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1755 = null;
    public static final BitSet FOLLOW_grammarType_in_grammarSpec396 = null;
    public static final BitSet FOLLOW_id_in_action1297 = null;
    public static final BitSet FOLLOW_id_in_actionScopeName1328 = null;
    public static final BitSet FOLLOW_id_in_channelsSpec1261 = null;
    public static final BitSet FOLLOW_id_in_channelsSpec1267 = null;
    public static final BitSet FOLLOW_id_in_delegateGrammar1081 = null;
    public static final BitSet FOLLOW_id_in_delegateGrammar1086 = null;
    public static final BitSet FOLLOW_id_in_delegateGrammar1096 = null;
    public static final BitSet FOLLOW_id_in_elementOption4084 = null;
    public static final BitSet FOLLOW_id_in_grammarSpec398 = null;
    public static final BitSet FOLLOW_id_in_labeledAlt2093 = null;
    public static final BitSet FOLLOW_id_in_labeledElement3167 = null;
    public static final BitSet FOLLOW_id_in_labeledLexerElement2533 = null;
    public static final BitSet FOLLOW_id_in_lexerCommandExpr2730 = null;
    public static final BitSet FOLLOW_id_in_lexerCommandName2759 = null;
    public static final BitSet FOLLOW_id_in_modeSpec1369 = null;
    public static final BitSet FOLLOW_id_in_option955 = null;
    public static final BitSet FOLLOW_id_in_qid4161 = null;
    public static final BitSet FOLLOW_id_in_qid4166 = null;
    public static final BitSet FOLLOW_id_in_ruleAction1985 = null;
    public static final BitSet FOLLOW_id_in_tokensSpec1112 = null;
    public static final BitSet FOLLOW_id_in_tokensSpec1117 = null;
    public static final BitSet FOLLOW_id_in_v3tokenSpec1176 = null;
    public static final BitSet FOLLOW_labeledAlt_in_ruleAltList2061 = null;
    public static final BitSet FOLLOW_labeledAlt_in_ruleAltList2066 = null;
    public static final BitSet FOLLOW_labeledElement_in_element2968 = null;
    public static final BitSet FOLLOW_labeledLexerElement_in_lexerElement2365 = null;
    public static final BitSet FOLLOW_lexerAltList_in_lexerBlock2626 = null;
    public static final BitSet FOLLOW_lexerAltList_in_lexerRuleBlock2201 = null;
    public static final BitSet FOLLOW_lexerAlt_in_lexerAltList2237 = null;
    public static final BitSet FOLLOW_lexerAlt_in_lexerAltList2242 = null;
    public static final BitSet FOLLOW_lexerAtom_in_labeledLexerElement2549 = null;
    public static final BitSet FOLLOW_lexerAtom_in_lexerElement2417 = null;
    public static final BitSet FOLLOW_lexerBlock_in_labeledLexerElement2566 = null;
    public static final BitSet FOLLOW_lexerBlock_in_lexerElement2469 = null;
    public static final BitSet FOLLOW_lexerCommandExpr_in_lexerCommand2702 = null;
    public static final BitSet FOLLOW_lexerCommandName_in_lexerCommand2698 = null;
    public static final BitSet FOLLOW_lexerCommandName_in_lexerCommand2719 = null;
    public static final BitSet FOLLOW_lexerCommand_in_lexerCommands2675 = null;
    public static final BitSet FOLLOW_lexerCommand_in_lexerCommands2680 = null;
    public static final BitSet FOLLOW_lexerCommands_in_lexerAlt2266 = null;
    public static final BitSet FOLLOW_lexerElement_in_lexerElements2309 = null;
    public static final BitSet FOLLOW_lexerElements_in_lexerAlt2260 = null;
    public static final BitSet FOLLOW_lexerRuleBlock_in_lexerRule2135 = null;
    public static final BitSet FOLLOW_lexerRule_in_modeSpec1376 = null;
    public static final BitSet FOLLOW_lexerRule_in_rule1481 = null;
    public static final BitSet FOLLOW_localsSpec_in_parserRule1581 = null;
    public static final BitSet FOLLOW_modeSpec_in_grammarSpec475 = null;
    public static final BitSet FOLLOW_notSet_in_atom3509 = null;
    public static final BitSet FOLLOW_notSet_in_lexerAtom3423 = null;
    public static final BitSet FOLLOW_optionValue_in_elementOption4089 = null;
    public static final BitSet FOLLOW_optionValue_in_option960 = null;
    public static final BitSet FOLLOW_option_in_optionsSpec920 = null;
    public static final BitSet FOLLOW_optionsSpec_in_block3783 = null;
    public static final BitSet FOLLOW_optionsSpec_in_lexerBlock2611 = null;
    public static final BitSet FOLLOW_optionsSpec_in_prequelConstruct788 = null;
    public static final BitSet FOLLOW_optionsSpec_in_rulePrequel1866 = null;
    public static final BitSet FOLLOW_parserRule_in_rule1476 = null;
    public static final BitSet FOLLOW_prequelConstruct_in_grammarSpec442 = null;
    public static final BitSet FOLLOW_qid_in_elementOption4076 = null;
    public static final BitSet FOLLOW_qid_in_optionValue1003 = null;
    public static final BitSet FOLLOW_qid_in_throwsSpec1927 = null;
    public static final BitSet FOLLOW_qid_in_throwsSpec1932 = null;
    public static final BitSet FOLLOW_range_in_atom3484 = null;
    public static final BitSet FOLLOW_range_in_lexerAtom3397 = null;
    public static final BitSet FOLLOW_range_in_setElement3737 = null;
    public static final BitSet FOLLOW_ruleAction_in_block3788 = null;
    public static final BitSet FOLLOW_ruleAction_in_rulePrequel1874 = null;
    public static final BitSet FOLLOW_ruleAltList_in_ruleBlock2025 = null;
    public static final BitSet FOLLOW_ruleBlock_in_parserRule1651 = null;
    public static final BitSet FOLLOW_rulePrequel_in_rulePrequels1840 = null;
    public static final BitSet FOLLOW_rulePrequels_in_parserRule1619 = null;
    public static final BitSet FOLLOW_ruleReturns_in_parserRule1567 = null;
    public static final BitSet FOLLOW_rule_in_ruleEntry4204 = null;
    public static final BitSet FOLLOW_rule_in_rules1412 = null;
    public static final BitSet FOLLOW_ruleref_in_atom3501 = null;
    public static final BitSet FOLLOW_rules_in_grammarSpec469 = null;
    public static final BitSet FOLLOW_setElement_in_blockSet3674 = null;
    public static final BitSet FOLLOW_setElement_in_blockSet3679 = null;
    public static final BitSet FOLLOW_setElement_in_notSet3607 = null;
    public static final BitSet FOLLOW_sync_in_grammarSpec438 = null;
    public static final BitSet FOLLOW_sync_in_grammarSpec444 = null;
    public static final BitSet FOLLOW_sync_in_modeSpec1373 = null;
    public static final BitSet FOLLOW_sync_in_modeSpec1378 = null;
    public static final BitSet FOLLOW_sync_in_rulePrequels1837 = null;
    public static final BitSet FOLLOW_sync_in_rulePrequels1842 = null;
    public static final BitSet FOLLOW_sync_in_rules1409 = null;
    public static final BitSet FOLLOW_sync_in_rules1414 = null;
    public static final BitSet FOLLOW_terminal_in_atom3491 = null;
    public static final BitSet FOLLOW_terminal_in_lexerAtom3402 = null;
    public static final BitSet FOLLOW_throwsSpec_in_parserRule1574 = null;
    public static final BitSet FOLLOW_tokensSpec_in_prequelConstruct855 = null;
    public static final BitSet FOLLOW_v3tokenSpec_in_tokensSpec1153 = null;
    public static final BitSet FOLLOW_wildcard_in_atom3517 = null;
    public static final BitSet FOLLOW_wildcard_in_lexerAtom3431 = null;
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
    protected TreeAdaptor adaptor;
    Deque<String> paraphrases;

    public static class actionElement_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public actionElement_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class actionScopeName_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public actionScopeName_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class action_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public action_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class altList_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public altList_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class alternativeEntry_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public alternativeEntry_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class alternative_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public alternative_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class atom_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public atom_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class blockEntry_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public blockEntry_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class blockSet_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public blockSet_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class blockSuffix_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public blockSuffix_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class block_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public block_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class channelsSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public channelsSpec_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class delegateGrammar_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public delegateGrammar_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class delegateGrammars_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public delegateGrammars_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class ebnfSuffix_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public ebnfSuffix_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class ebnf_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public ebnf_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class elementEntry_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public elementEntry_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class elementOption_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public elementOption_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class elementOptions_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public elementOptions_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class element_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public element_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class exceptionGroup_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public exceptionGroup_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class exceptionHandler_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public exceptionHandler_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class finallyClause_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public finallyClause_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class grammarSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public grammarSpec_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class grammarType_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public grammarType_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class id_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public id_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class labeledAlt_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public labeledAlt_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class labeledElement_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public labeledElement_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class labeledLexerElement_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public labeledLexerElement_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class lexerAltList_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public lexerAltList_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class lexerAlt_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public lexerAlt_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class lexerAtom_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public lexerAtom_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class lexerBlock_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public lexerBlock_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class lexerCommandExpr_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public lexerCommandExpr_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class lexerCommandName_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public lexerCommandName_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class lexerCommand_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public lexerCommand_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class lexerCommands_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public lexerCommands_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class lexerElement_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public lexerElement_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class lexerElements_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public lexerElements_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class lexerRuleBlock_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public lexerRuleBlock_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class lexerRule_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public lexerRule_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class localsSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public localsSpec_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class modeSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public modeSpec_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class notSet_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public notSet_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class optionValue_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public optionValue_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class option_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public option_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class optionsSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public optionsSpec_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class parserRule_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public parserRule_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class prequelConstruct_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public prequelConstruct_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class qid_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public qid_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class range_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public range_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class ruleAction_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public ruleAction_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class ruleAltList_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public ruleAltList_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class ruleBlock_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public ruleBlock_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class ruleEntry_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public ruleEntry_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class rulePrequel_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public rulePrequel_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class rulePrequels_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public rulePrequels_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class ruleReturns_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public ruleReturns_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class rule_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public rule_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class ruleref_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public ruleref_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class rules_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public rules_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class setElement_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public setElement_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class sync_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public sync_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class terminal_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public terminal_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class throwsSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public throwsSpec_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class tokensSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public tokensSpec_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class v3tokenSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public v3tokenSpec_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class wildcard_return extends ParserRuleReturnScope {
        GrammarAST tree;

        public wildcard_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    static {
        tokenNames = new String[]{Grammar.INVALID_RULE_NAME, "<EOR>", "<DOWN>", "<UP>", "ACTION", "ACTION_CHAR_LITERAL", "ACTION_ESC", "ACTION_STRING_LITERAL", "ARG_ACTION", "ARG_OR_CHARSET", "ASSIGN", "AT", "CATCH", "CHANNELS", "COLON", "COLONCOLON", "COMMA", "COMMENT", "DOC_COMMENT", "DOLLAR", "DOT", "ERRCHAR", "ESC_SEQ", "FINALLY", "FRAGMENT", "GRAMMAR", "GT", "HEX_DIGIT", "ID", "IMPORT", "INT", "LEXER", "LEXER_CHAR_SET", "LOCALS", "LPAREN", "LT", "MODE", "NESTED_ACTION", "NLCHARS", "NOT", "NameChar", "NameStartChar", "OPTIONS", "OR", "PARSER", "PLUS", "PLUS_ASSIGN", "POUND", "PRIVATE", "PROTECTED", "PUBLIC", "QUESTION", "RANGE", "RARROW", "RBRACE", "RETURNS", "RPAREN", "RULE_REF", "SEMI", "SEMPRED", "SRC", "STAR", "STRING_LITERAL", "SYNPRED", "THROWS", "TOKENS_SPEC", "TOKEN_REF", "TREE_GRAMMAR", "UNICODE_ESC", "UNICODE_EXTENDED_ESC", "UnicodeBOM", "WS", "WSCHARS", "WSNLCHARS", "ALT", "ALTLIST", "ARG", "ARGLIST", "BLOCK", "CHAR_RANGE", "CLOSURE", "COMBINED", "ELEMENT_OPTIONS", "EPSILON", "INITACTION", "LABEL", "LEXER_ACTION_CALL", "LEXER_ALT_ACTION", "LIST", "OPTIONAL", "POSITIVE_CLOSURE", "PREC_RULE", "RESULT", "RET", "RULE", "RULEACTIONS", "RULEMODIFIERS", "RULES", "SET", "TEMPLATE", "WILDCARD"};
        FOLLOW_grammarType_in_grammarSpec396 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_id_in_grammarSpec398 = new BitSet(new long[]{288230376151711744L});
        FOLLOW_SEMI_in_grammarSpec400 = new BitSet(new long[]{144119586676025344L, 6});
        FOLLOW_sync_in_grammarSpec438 = new BitSet(new long[]{144119586676025344L, 6});
        FOLLOW_prequelConstruct_in_grammarSpec442 = new BitSet(new long[]{144119586676025344L, 6});
        FOLLOW_sync_in_grammarSpec444 = new BitSet(new long[]{144119586676025344L, 6});
        FOLLOW_rules_in_grammarSpec469 = new BitSet(new long[]{68719476736L});
        FOLLOW_modeSpec_in_grammarSpec475 = new BitSet(new long[]{68719476736L});
        FOLLOW_EOF_in_grammarSpec513 = new BitSet(new long[]{2});
        FOLLOW_LEXER_in_grammarType683 = new BitSet(new long[]{33554432});
        FOLLOW_GRAMMAR_in_grammarType687 = new BitSet(new long[]{2});
        FOLLOW_PARSER_in_grammarType710 = new BitSet(new long[]{33554432});
        FOLLOW_GRAMMAR_in_grammarType714 = new BitSet(new long[]{2});
        FOLLOW_GRAMMAR_in_grammarType735 = new BitSet(new long[]{2});
        FOLLOW_TREE_GRAMMAR_in_grammarType762 = new BitSet(new long[]{2});
        FOLLOW_optionsSpec_in_prequelConstruct788 = new BitSet(new long[]{2});
        FOLLOW_delegateGrammars_in_prequelConstruct811 = new BitSet(new long[]{2});
        FOLLOW_tokensSpec_in_prequelConstruct855 = new BitSet(new long[]{2});
        FOLLOW_channelsSpec_in_prequelConstruct865 = new BitSet(new long[]{2});
        FOLLOW_action_in_prequelConstruct902 = new BitSet(new long[]{2});
        FOLLOW_OPTIONS_in_optionsSpec917 = new BitSet(new long[]{162129586585337856L, 4});
        FOLLOW_option_in_optionsSpec920 = new BitSet(new long[]{288230376151711744L});
        FOLLOW_SEMI_in_optionsSpec922 = new BitSet(new long[]{162129586585337856L, 4});
        FOLLOW_RBRACE_in_optionsSpec926 = new BitSet(new long[]{2});
        FOLLOW_id_in_option955 = new BitSet(new long[]{RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_ASSIGN_in_option957 = new BitSet(new long[]{4755801207576985616L, 4});
        FOLLOW_optionValue_in_option960 = new BitSet(new long[]{2});
        FOLLOW_qid_in_optionValue1003 = new BitSet(new long[]{2});
        FOLLOW_STRING_LITERAL_in_optionValue1011 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_optionValue1016 = new BitSet(new long[]{2});
        FOLLOW_INT_in_optionValue1027 = new BitSet(new long[]{2});
        FOLLOW_IMPORT_in_delegateGrammars1043 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_delegateGrammar_in_delegateGrammars1045 = new BitSet(new long[]{288230376151777280L});
        FOLLOW_COMMA_in_delegateGrammars1048 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_delegateGrammar_in_delegateGrammars1050 = new BitSet(new long[]{288230376151777280L});
        FOLLOW_SEMI_in_delegateGrammars1054 = new BitSet(new long[]{2});
        FOLLOW_id_in_delegateGrammar1081 = new BitSet(new long[]{RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_ASSIGN_in_delegateGrammar1083 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_id_in_delegateGrammar1086 = new BitSet(new long[]{2});
        FOLLOW_id_in_delegateGrammar1096 = new BitSet(new long[]{2});
        FOLLOW_TOKENS_SPEC_in_tokensSpec1110 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_id_in_tokensSpec1112 = new BitSet(new long[]{18014398509547520L});
        FOLLOW_COMMA_in_tokensSpec1115 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_id_in_tokensSpec1117 = new BitSet(new long[]{18014398509547520L});
        FOLLOW_RBRACE_in_tokensSpec1121 = new BitSet(new long[]{2});
        FOLLOW_TOKENS_SPEC_in_tokensSpec1138 = new BitSet(new long[]{18014398509481984L});
        FOLLOW_RBRACE_in_tokensSpec1140 = new BitSet(new long[]{2});
        FOLLOW_TOKENS_SPEC_in_tokensSpec1150 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_v3tokenSpec_in_tokensSpec1153 = new BitSet(new long[]{162129586585337856L, 4});
        FOLLOW_RBRACE_in_tokensSpec1156 = new BitSet(new long[]{2});
        FOLLOW_id_in_v3tokenSpec1176 = new BitSet(new long[]{288230376151712768L});
        FOLLOW_ASSIGN_in_v3tokenSpec1182 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_v3tokenSpec1186 = new BitSet(new long[]{288230376151711744L});
        FOLLOW_SEMI_in_v3tokenSpec1247 = new BitSet(new long[]{2});
        FOLLOW_CHANNELS_in_channelsSpec1258 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_id_in_channelsSpec1261 = new BitSet(new long[]{18014398509547520L});
        FOLLOW_COMMA_in_channelsSpec1264 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_id_in_channelsSpec1267 = new BitSet(new long[]{18014398509547520L});
        FOLLOW_RBRACE_in_channelsSpec1271 = new BitSet(new long[]{2});
        FOLLOW_AT_in_action1288 = new BitSet(new long[]{144132782409383936L, 4});
        FOLLOW_actionScopeName_in_action1291 = new BitSet(new long[]{32768});
        FOLLOW_COLONCOLON_in_action1293 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_id_in_action1297 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_action1299 = new BitSet(new long[]{2});
        FOLLOW_id_in_actionScopeName1328 = new BitSet(new long[]{2});
        FOLLOW_LEXER_in_actionScopeName1333 = new BitSet(new long[]{2});
        FOLLOW_PARSER_in_actionScopeName1348 = new BitSet(new long[]{2});
        FOLLOW_MODE_in_modeSpec1367 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_id_in_modeSpec1369 = new BitSet(new long[]{288230376151711744L});
        FOLLOW_SEMI_in_modeSpec1371 = new BitSet(new long[]{16777216, 4});
        FOLLOW_sync_in_modeSpec1373 = new BitSet(new long[]{16777218, 4});
        FOLLOW_lexerRule_in_modeSpec1376 = new BitSet(new long[]{16777216, 4});
        FOLLOW_sync_in_modeSpec1378 = new BitSet(new long[]{16777218, 4});
        FOLLOW_sync_in_rules1409 = new BitSet(new long[]{144115188092633090L, 4});
        FOLLOW_rule_in_rules1412 = new BitSet(new long[]{144115188092633088L, 4});
        FOLLOW_sync_in_rules1414 = new BitSet(new long[]{144115188092633090L, 4});
        FOLLOW_parserRule_in_rule1476 = new BitSet(new long[]{2});
        FOLLOW_lexerRule_in_rule1481 = new BitSet(new long[]{2});
        FOLLOW_RULE_REF_in_parserRule1530 = new BitSet(new long[]{36033203655411968L, 1});
        FOLLOW_ARG_ACTION_in_parserRule1560 = new BitSet(new long[]{36033203655411712L, 1});
        FOLLOW_ruleReturns_in_parserRule1567 = new BitSet(new long[]{4406636447744L, 1});
        FOLLOW_throwsSpec_in_parserRule1574 = new BitSet(new long[]{4406636447744L});
        FOLLOW_localsSpec_in_parserRule1581 = new BitSet(new long[]{4398046513152L});
        FOLLOW_rulePrequels_in_parserRule1619 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_COLON_in_parserRule1628 = new BitSet(new long[]{5332403297591492624L, 4});
        FOLLOW_ruleBlock_in_parserRule1651 = new BitSet(new long[]{288230376151711744L});
        FOLLOW_SEMI_in_parserRule1660 = new BitSet(new long[]{8392704});
        FOLLOW_exceptionGroup_in_parserRule1669 = new BitSet(new long[]{2});
        FOLLOW_exceptionHandler_in_exceptionGroup1752 = new BitSet(new long[]{8392706});
        FOLLOW_finallyClause_in_exceptionGroup1755 = new BitSet(new long[]{2});
        FOLLOW_CATCH_in_exceptionHandler1772 = new BitSet(new long[]{256});
        FOLLOW_ARG_ACTION_in_exceptionHandler1774 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_exceptionHandler1776 = new BitSet(new long[]{2});
        FOLLOW_FINALLY_in_finallyClause1803 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_finallyClause1805 = new BitSet(new long[]{2});
        FOLLOW_sync_in_rulePrequels1837 = new BitSet(new long[]{4398046513154L});
        FOLLOW_rulePrequel_in_rulePrequels1840 = new BitSet(new long[]{4398046513152L});
        FOLLOW_sync_in_rulePrequels1842 = new BitSet(new long[]{4398046513154L});
        FOLLOW_optionsSpec_in_rulePrequel1866 = new BitSet(new long[]{2});
        FOLLOW_ruleAction_in_rulePrequel1874 = new BitSet(new long[]{2});
        FOLLOW_RETURNS_in_ruleReturns1894 = new BitSet(new long[]{256});
        FOLLOW_ARG_ACTION_in_ruleReturns1897 = new BitSet(new long[]{2});
        FOLLOW_THROWS_in_throwsSpec1925 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_qid_in_throwsSpec1927 = new BitSet(new long[]{65538});
        FOLLOW_COMMA_in_throwsSpec1930 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_qid_in_throwsSpec1932 = new BitSet(new long[]{65538});
        FOLLOW_LOCALS_in_localsSpec1957 = new BitSet(new long[]{256});
        FOLLOW_ARG_ACTION_in_localsSpec1960 = new BitSet(new long[]{2});
        FOLLOW_AT_in_ruleAction1983 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_id_in_ruleAction1985 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_ruleAction1987 = new BitSet(new long[]{2});
        FOLLOW_ruleAltList_in_ruleBlock2025 = new BitSet(new long[]{2});
        FOLLOW_labeledAlt_in_ruleAltList2061 = new BitSet(new long[]{8796093022210L});
        FOLLOW_OR_in_ruleAltList2064 = new BitSet(new long[]{5332403297591492624L, 4});
        FOLLOW_labeledAlt_in_ruleAltList2066 = new BitSet(new long[]{8796093022210L});
        FOLLOW_alternative_in_labeledAlt2084 = new BitSet(new long[]{140737488355330L});
        FOLLOW_POUND_in_labeledAlt2090 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_id_in_labeledAlt2093 = new BitSet(new long[]{2});
        FOLLOW_FRAGMENT_in_lexerRule2125 = new BitSet(new long[]{0, 4});
        FOLLOW_TOKEN_REF_in_lexerRule2131 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_COLON_in_lexerRule2133 = new BitSet(new long[]{5341269729293107216L, 4});
        FOLLOW_lexerRuleBlock_in_lexerRule2135 = new BitSet(new long[]{288230376151711744L});
        FOLLOW_SEMI_in_lexerRule2137 = new BitSet(new long[]{2});
        FOLLOW_lexerAltList_in_lexerRuleBlock2201 = new BitSet(new long[]{2});
        FOLLOW_lexerAlt_in_lexerAltList2237 = new BitSet(new long[]{8796093022210L});
        FOLLOW_OR_in_lexerAltList2240 = new BitSet(new long[]{5341269729293107216L, 4});
        FOLLOW_lexerAlt_in_lexerAltList2242 = new BitSet(new long[]{8796093022210L});
        FOLLOW_lexerElements_in_lexerAlt2260 = new BitSet(new long[]{9007199254740994L});
        FOLLOW_lexerCommands_in_lexerAlt2266 = new BitSet(new long[]{2});
        FOLLOW_lexerElement_in_lexerElements2309 = new BitSet(new long[]{5332262530038366226L, 4});
        FOLLOW_labeledLexerElement_in_lexerElement2365 = new BitSet(new long[]{2308129993399468034L});
        FOLLOW_ebnfSuffix_in_lexerElement2371 = new BitSet(new long[]{2});
        FOLLOW_lexerAtom_in_lexerElement2417 = new BitSet(new long[]{2308129993399468034L});
        FOLLOW_ebnfSuffix_in_lexerElement2423 = new BitSet(new long[]{2});
        FOLLOW_lexerBlock_in_lexerElement2469 = new BitSet(new long[]{2308129993399468034L});
        FOLLOW_ebnfSuffix_in_lexerElement2475 = new BitSet(new long[]{2});
        FOLLOW_actionElement_in_lexerElement2503 = new BitSet(new long[]{2});
        FOLLOW_id_in_labeledLexerElement2533 = new BitSet(new long[]{70368744178688L});
        FOLLOW_ASSIGN_in_labeledLexerElement2538 = new BitSet(new long[]{4755801777734942720L, 4});
        FOLLOW_PLUS_ASSIGN_in_labeledLexerElement2542 = new BitSet(new long[]{4755801777734942720L, 4});
        FOLLOW_lexerAtom_in_labeledLexerElement2549 = new BitSet(new long[]{2});
        FOLLOW_lexerBlock_in_labeledLexerElement2566 = new BitSet(new long[]{2});
        FOLLOW_LPAREN_in_lexerBlock2599 = new BitSet(new long[]{5341274127339618320L, 4});
        FOLLOW_optionsSpec_in_lexerBlock2611 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_COLON_in_lexerBlock2613 = new BitSet(new long[]{5341269729293107216L, 4});
        FOLLOW_lexerAltList_in_lexerBlock2626 = new BitSet(new long[]{72057594037927936L});
        FOLLOW_RPAREN_in_lexerBlock2636 = new BitSet(new long[]{2});
        FOLLOW_RARROW_in_lexerCommands2673 = new BitSet(new long[]{144115256795332608L, 4});
        FOLLOW_lexerCommand_in_lexerCommands2675 = new BitSet(new long[]{65538});
        FOLLOW_COMMA_in_lexerCommands2678 = new BitSet(new long[]{144115256795332608L, 4});
        FOLLOW_lexerCommand_in_lexerCommands2680 = new BitSet(new long[]{65538});
        FOLLOW_lexerCommandName_in_lexerCommand2698 = new BitSet(new long[]{17179869184L});
        FOLLOW_LPAREN_in_lexerCommand2700 = new BitSet(new long[]{144115189149597696L, 4});
        FOLLOW_lexerCommandExpr_in_lexerCommand2702 = new BitSet(new long[]{72057594037927936L});
        FOLLOW_RPAREN_in_lexerCommand2704 = new BitSet(new long[]{2});
        FOLLOW_lexerCommandName_in_lexerCommand2719 = new BitSet(new long[]{2});
        FOLLOW_id_in_lexerCommandExpr2730 = new BitSet(new long[]{2});
        FOLLOW_INT_in_lexerCommandExpr2735 = new BitSet(new long[]{2});
        FOLLOW_id_in_lexerCommandName2759 = new BitSet(new long[]{2});
        FOLLOW_MODE_in_lexerCommandName2777 = new BitSet(new long[]{2});
        FOLLOW_alternative_in_altList2805 = new BitSet(new long[]{8796093022210L});
        FOLLOW_OR_in_altList2808 = new BitSet(new long[]{5332271356196159504L, 4});
        FOLLOW_alternative_in_altList2810 = new BitSet(new long[]{8796093022210L});
        FOLLOW_elementOptions_in_alternative2844 = new BitSet(new long[]{5332262525743398930L, 4});
        FOLLOW_element_in_alternative2853 = new BitSet(new long[]{5332262525743398930L, 4});
        FOLLOW_labeledElement_in_element2968 = new BitSet(new long[]{2308129993399468034L});
        FOLLOW_ebnfSuffix_in_element2974 = new BitSet(new long[]{2});
        FOLLOW_atom_in_element3020 = new BitSet(new long[]{2308129993399468034L});
        FOLLOW_ebnfSuffix_in_element3026 = new BitSet(new long[]{2});
        FOLLOW_ebnf_in_element3072 = new BitSet(new long[]{2});
        FOLLOW_actionElement_in_element3077 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_actionElement3103 = new BitSet(new long[]{2});
        FOLLOW_ACTION_in_actionElement3113 = new BitSet(new long[]{34359738368L});
        FOLLOW_elementOptions_in_actionElement3115 = new BitSet(new long[]{2});
        FOLLOW_SEMPRED_in_actionElement3133 = new BitSet(new long[]{2});
        FOLLOW_SEMPRED_in_actionElement3143 = new BitSet(new long[]{34359738368L});
        FOLLOW_elementOptions_in_actionElement3145 = new BitSet(new long[]{2});
        FOLLOW_id_in_labeledElement3167 = new BitSet(new long[]{70368744178688L});
        FOLLOW_ASSIGN_in_labeledElement3172 = new BitSet(new long[]{4755801773439975424L, 4});
        FOLLOW_PLUS_ASSIGN_in_labeledElement3176 = new BitSet(new long[]{4755801773439975424L, 4});
        FOLLOW_atom_in_labeledElement3183 = new BitSet(new long[]{2});
        FOLLOW_block_in_labeledElement3205 = new BitSet(new long[]{2});
        FOLLOW_block_in_ebnf3241 = new BitSet(new long[]{2308129993399468034L});
        FOLLOW_blockSuffix_in_ebnf3265 = new BitSet(new long[]{2});
        FOLLOW_ebnfSuffix_in_blockSuffix3315 = new BitSet(new long[]{2});
        FOLLOW_QUESTION_in_ebnfSuffix3330 = new BitSet(new long[]{2251799813685250L});
        FOLLOW_QUESTION_in_ebnfSuffix3334 = new BitSet(new long[]{2});
        FOLLOW_STAR_in_ebnfSuffix3350 = new BitSet(new long[]{2251799813685250L});
        FOLLOW_QUESTION_in_ebnfSuffix3354 = new BitSet(new long[]{2});
        FOLLOW_PLUS_in_ebnfSuffix3372 = new BitSet(new long[]{2251799813685250L});
        FOLLOW_QUESTION_in_ebnfSuffix3376 = new BitSet(new long[]{2});
        FOLLOW_range_in_lexerAtom3397 = new BitSet(new long[]{2});
        FOLLOW_terminal_in_lexerAtom3402 = new BitSet(new long[]{2});
        FOLLOW_RULE_REF_in_lexerAtom3412 = new BitSet(new long[]{2});
        FOLLOW_notSet_in_lexerAtom3423 = new BitSet(new long[]{2});
        FOLLOW_wildcard_in_lexerAtom3431 = new BitSet(new long[]{2});
        FOLLOW_LEXER_CHAR_SET_in_lexerAtom3439 = new BitSet(new long[]{2});
        FOLLOW_range_in_atom3484 = new BitSet(new long[]{2});
        FOLLOW_terminal_in_atom3491 = new BitSet(new long[]{2});
        FOLLOW_ruleref_in_atom3501 = new BitSet(new long[]{2});
        FOLLOW_notSet_in_atom3509 = new BitSet(new long[]{2});
        FOLLOW_wildcard_in_atom3517 = new BitSet(new long[]{2});
        FOLLOW_DOT_in_wildcard3565 = new BitSet(new long[]{34359738370L});
        FOLLOW_elementOptions_in_wildcard3567 = new BitSet(new long[]{2});
        FOLLOW_NOT_in_notSet3605 = new BitSet(new long[]{4611686022722355200L, 4});
        FOLLOW_setElement_in_notSet3607 = new BitSet(new long[]{2});
        FOLLOW_NOT_in_notSet3635 = new BitSet(new long[]{17179869184L});
        FOLLOW_blockSet_in_notSet3637 = new BitSet(new long[]{2});
        FOLLOW_LPAREN_in_blockSet3672 = new BitSet(new long[]{4611686022722355200L, 4});
        FOLLOW_setElement_in_blockSet3674 = new BitSet(new long[]{72066390130950144L});
        FOLLOW_OR_in_blockSet3677 = new BitSet(new long[]{4611686022722355200L, 4});
        FOLLOW_setElement_in_blockSet3679 = new BitSet(new long[]{72066390130950144L});
        FOLLOW_RPAREN_in_blockSet3683 = new BitSet(new long[]{2});
        FOLLOW_TOKEN_REF_in_setElement3713 = new BitSet(new long[]{34359738370L});
        FOLLOW_elementOptions_in_setElement3719 = new BitSet(new long[]{2});
        FOLLOW_STRING_LITERAL_in_setElement3725 = new BitSet(new long[]{34359738370L});
        FOLLOW_elementOptions_in_setElement3731 = new BitSet(new long[]{2});
        FOLLOW_range_in_setElement3737 = new BitSet(new long[]{2});
        FOLLOW_LEXER_CHAR_SET_in_setElement3747 = new BitSet(new long[]{2});
        FOLLOW_LPAREN_in_block3771 = new BitSet(new long[]{5332275754242689040L, 4});
        FOLLOW_optionsSpec_in_block3783 = new BitSet(new long[]{18432});
        FOLLOW_ruleAction_in_block3788 = new BitSet(new long[]{18432});
        FOLLOW_COLON_in_block3791 = new BitSet(new long[]{5332271356196159504L, 4});
        FOLLOW_altList_in_block3804 = new BitSet(new long[]{72057594037927936L});
        FOLLOW_RPAREN_in_block3808 = new BitSet(new long[]{2});
        FOLLOW_RULE_REF_in_ruleref3862 = new BitSet(new long[]{34359738626L});
        FOLLOW_ARG_ACTION_in_ruleref3864 = new BitSet(new long[]{34359738370L});
        FOLLOW_elementOptions_in_ruleref3867 = new BitSet(new long[]{2});
        FOLLOW_STRING_LITERAL_in_range3923 = new BitSet(new long[]{4503599627370496L});
        FOLLOW_RANGE_in_range3928 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_range3934 = new BitSet(new long[]{2});
        FOLLOW_TOKEN_REF_in_terminal3958 = new BitSet(new long[]{34359738370L});
        FOLLOW_elementOptions_in_terminal3960 = new BitSet(new long[]{2});
        FOLLOW_STRING_LITERAL_in_terminal3981 = new BitSet(new long[]{34359738370L});
        FOLLOW_elementOptions_in_terminal3983 = new BitSet(new long[]{2});
        FOLLOW_LT_in_elementOptions4014 = new BitSet(new long[]{144115188142964736L, 4});
        FOLLOW_elementOption_in_elementOptions4017 = new BitSet(new long[]{67174400});
        FOLLOW_COMMA_in_elementOptions4020 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_elementOption_in_elementOptions4022 = new BitSet(new long[]{67174400});
        FOLLOW_GT_in_elementOptions4028 = new BitSet(new long[]{2});
        FOLLOW_qid_in_elementOption4076 = new BitSet(new long[]{2});
        FOLLOW_id_in_elementOption4084 = new BitSet(new long[]{RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE});
        FOLLOW_ASSIGN_in_elementOption4086 = new BitSet(new long[]{4755801207576985616L, 4});
        FOLLOW_optionValue_in_elementOption4089 = new BitSet(new long[]{2});
        FOLLOW_RULE_REF_in_id4120 = new BitSet(new long[]{2});
        FOLLOW_TOKEN_REF_in_id4133 = new BitSet(new long[]{2});
        FOLLOW_id_in_qid4161 = new BitSet(new long[]{1048578});
        FOLLOW_DOT_in_qid4164 = new BitSet(new long[]{144115188075855872L, 4});
        FOLLOW_id_in_qid4166 = new BitSet(new long[]{1048578});
        FOLLOW_alternative_in_alternativeEntry4183 = new BitSet(new long[]{0});
        FOLLOW_EOF_in_alternativeEntry4185 = new BitSet(new long[]{2});
        FOLLOW_element_in_elementEntry4194 = new BitSet(new long[]{0});
        FOLLOW_EOF_in_elementEntry4196 = new BitSet(new long[]{2});
        FOLLOW_rule_in_ruleEntry4204 = new BitSet(new long[]{0});
        FOLLOW_EOF_in_ruleEntry4206 = new BitSet(new long[]{2});
        FOLLOW_block_in_blockEntry4214 = new BitSet(new long[]{0});
        FOLLOW_EOF_in_blockEntry4216 = new BitSet(new long[]{2});
    }

    public ANTLRParser(TokenStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public final action_return action() throws RecognitionException {
        action_return r5 = new action_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token AT");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token ACTION");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token COLONCOLON");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule id");
        RewriteRuleSubtreeStream r14 = new RewriteRuleSubtreeStream(this.adaptor, "rule actionScopeName");
        r10.add((Token) match(this.input, 11, FOLLOW_AT_in_action1288));     // Catch: Throwable -> L15 RecognitionException -> L17
        int r15 = this.input.LA(1);     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r15 != 31) goto L6;
    L21:
        pushFollow(FOLLOW_actionScopeName_in_action1291);     // Catch: Throwable -> L15 RecognitionException -> L17
        actionScopeName_return r16 = actionScopeName();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        r14.add(r16.getTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        r12.add((Token) match(this.input, 15, FOLLOW_COLONCOLON_in_action1293));     // Catch: Throwable -> L15 RecognitionException -> L17
    L22:
        pushFollow(FOLLOW_id_in_action1297);     // Catch: Throwable -> L15 RecognitionException -> L17
        id_return r17 = id();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        r13.add(r17.getTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        r11.add((Token) match(this.input, 4, FOLLOW_ACTION_in_action1299));     // Catch: Throwable -> L15 RecognitionException -> L17
        r5.tree = null;     // Catch: Throwable -> L15 RecognitionException -> L17
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        GrammarAST r18 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L15 RecognitionException -> L17
        GrammarAST r19 = (GrammarAST) this.adaptor.becomeRoot(r10.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r14.hasNext() == false) goto L25;
        this.adaptor.addChild(r19, r14.nextTree());     // Catch: Throwable -> L15 RecognitionException -> L17
    L25:
        r14.reset();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.adaptor.addChild(r19, r13.nextTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        this.adaptor.addChild(r19, new ActionAST(r11.nextToken()));     // Catch: Throwable -> L15 RecognitionException -> L17
        this.adaptor.addChild(r18, r19);     // Catch: Throwable -> L15 RecognitionException -> L17
        r5.tree = r18;     // Catch: Throwable -> L15 RecognitionException -> L17
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L15 RecognitionException -> L17
        GrammarAST r20 = (GrammarAST) this.adaptor.rulePostProcessing(r18);     // Catch: Throwable -> L15 RecognitionException -> L17
        r5.tree = r20;     // Catch: Throwable -> L15 RecognitionException -> L17
        this.adaptor.setTokenBoundaries(r20, r5.start, r5.stop);     // Catch: Throwable -> L15 RecognitionException -> L17
    L29:
        return r5;
    L6:
        if (r15 == 44) goto L21;
        if (r15 == 57) goto L20;
        if (r15 != 66) goto L22;
        if (this.input.LA(2) != 15) goto L22;
    L20:
        if (this.input.LA(2) != 15) goto L22;
    L17:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r21 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r21.errorNode(r110, r5.start, r110.LT(-1), e);
    L15:
        th = move-exception;
        throw th;
    }

    public final actionElement_return actionElement() throws RecognitionException {
        actionElement_return r5 = new actionElement_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token ACTION");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token SEMPRED");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule elementOptions");
        int r13 = this.input.LA(1);     // Catch: Throwable -> L35 RecognitionException -> L37
        if (r13 != 4) goto L42;
        int r14 = this.input.LA(2);     // Catch: Throwable -> L35 RecognitionException -> L37
        if (r14 == (-1)) goto L39;
        if (r14 == 4) goto L39;
        if (r14 == 20) goto L39;
        if (r14 == 32) goto L39;
        if (r14 == 34) goto L39;
        if (r14 == 39) goto L39;
        if (r14 == 43) goto L39;
        if (r14 == 47) goto L39;
        if (r14 == 53) goto L39;
        if (r14 < 56) goto L22;
        if (r14 <= 59) goto L39;
    L22:
        if (r14 == 62) goto L39;
        if (r14 == 66) goto L39;
        if (r14 != 35) goto L29;
        char r15 = 2;
    L74:
        if (r15 == 1) goto L84;
        GrammarAST r16 = null;
        if (r15 != 2) goto L78;
        r10.add((Token) match(this.input, 4, FOLLOW_ACTION_in_actionElement3113));     // Catch: Throwable -> L35 RecognitionException -> L37
        pushFollow(FOLLOW_elementOptions_in_actionElement3115);     // Catch: Throwable -> L35 RecognitionException -> L37
        elementOptions_return r17 = elementOptions();     // Catch: Throwable -> L35 RecognitionException -> L37
        this.state._fsp--;     // Catch: Throwable -> L35 RecognitionException -> L37
        r12.add(r17.getTree());     // Catch: Throwable -> L35 RecognitionException -> L37
        r5.tree = null;     // Catch: Throwable -> L35 RecognitionException -> L37
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L35 RecognitionException -> L37
        r16 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L35 RecognitionException -> L37
        GrammarAST r18 = (GrammarAST) this.adaptor.becomeRoot(new ActionAST(r10.nextToken()), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L35 RecognitionException -> L37
        this.adaptor.addChild(r18, r12.nextTree());     // Catch: Throwable -> L35 RecognitionException -> L37
        this.adaptor.addChild(r16, r18);     // Catch: Throwable -> L35 RecognitionException -> L37
        r5.tree = r16;     // Catch: Throwable -> L35 RecognitionException -> L37
    L85:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L35 RecognitionException -> L37
        GrammarAST r19 = (GrammarAST) this.adaptor.rulePostProcessing(r16);     // Catch: Throwable -> L35 RecognitionException -> L37
        r5.tree = r19;     // Catch: Throwable -> L35 RecognitionException -> L37
        this.adaptor.setTokenBoundaries(r19, r5.start, r5.stop);     // Catch: Throwable -> L35 RecognitionException -> L37
        GrammarAST r20 = (GrammarAST) r5.tree.getFirstChildWithType(82);     // Catch: Throwable -> L35 RecognitionException -> L37
        if (r20 == null) goto L92;
        Grammar.setNodeOptions(r5.tree, r20);     // Catch: Throwable -> L35 RecognitionException -> L37
    L92:
        return r5;
    L78:
        if (r15 == 3) goto L82;
        if (r15 != 4) goto L85;
        r11.add((Token) match(this.input, 59, FOLLOW_SEMPRED_in_actionElement3143));     // Catch: Throwable -> L35 RecognitionException -> L37
        pushFollow(FOLLOW_elementOptions_in_actionElement3145);     // Catch: Throwable -> L35 RecognitionException -> L37
        elementOptions_return r21 = elementOptions();     // Catch: Throwable -> L35 RecognitionException -> L37
        this.state._fsp--;     // Catch: Throwable -> L35 RecognitionException -> L37
        r12.add(r21.getTree());     // Catch: Throwable -> L35 RecognitionException -> L37
        r5.tree = null;     // Catch: Throwable -> L35 RecognitionException -> L37
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L35 RecognitionException -> L37
        r16 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L35 RecognitionException -> L37
        GrammarAST r22 = (GrammarAST) this.adaptor.becomeRoot(new PredAST(r11.nextToken()), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L35 RecognitionException -> L37
        this.adaptor.addChild(r22, r12.nextTree());     // Catch: Throwable -> L35 RecognitionException -> L37
        this.adaptor.addChild(r16, r22);     // Catch: Throwable -> L35 RecognitionException -> L37
        r5.tree = r16;     // Catch: Throwable -> L35 RecognitionException -> L37
        goto L85
    L82:
        r16 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L35 RecognitionException -> L37
        this.adaptor.addChild(r16, new PredAST((Token) match(this.input, 59, FOLLOW_SEMPRED_in_actionElement3133)));     // Catch: Throwable -> L35 RecognitionException -> L37
        goto L85
    L84:
        r16 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L35 RecognitionException -> L37
        this.adaptor.addChild(r16, new ActionAST((Token) match(this.input, 4, FOLLOW_ACTION_in_actionElement3103)));     // Catch: Throwable -> L35 RecognitionException -> L37
        goto L85
    L29:
        int r23 = this.input.mark();     // Catch: Throwable -> L35 RecognitionException -> L37
        this.input.consume();     // Catch: Throwable -> L32
        throw new NoViableAltException("", 53, 1, this.input);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        this.input.rewind(r23);     // Catch: Throwable -> L35 RecognitionException -> L37
        throw th;     // Catch: Throwable -> L35 RecognitionException -> L37
    L39:
        r15 = 1;
        goto L74
    L42:
        if (r13 != 59) goto L89;
        int r24 = this.input.LA(2);     // Catch: Throwable -> L35 RecognitionException -> L37
        if (r24 == (-1)) goto L73;
        if (r24 == 4) goto L73;
        if (r24 == 20) goto L73;
        if (r24 == 32) goto L73;
        if (r24 == 34) goto L73;
        if (r24 == 39) goto L73;
        if (r24 == 43) goto L73;
        if (r24 == 47) goto L73;
        if (r24 == 53) goto L73;
        if (r24 < 56) goto L60;
        if (r24 <= 59) goto L73;
    L60:
        if (r24 == 62) goto L73;
        if (r24 == 66) goto L73;
        if (r24 != 35) goto L67;
        r15 = 4;
        goto L74
    L67:
        int r25 = this.input.mark();     // Catch: Throwable -> L35 RecognitionException -> L37
        this.input.consume();     // Catch: Throwable -> L70
        throw new NoViableAltException("", 53, 2, this.input);     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        this.input.rewind(r25);     // Catch: Throwable -> L35 RecognitionException -> L37
        throw th;     // Catch: Throwable -> L35 RecognitionException -> L37
    L73:
        r15 = 3;
        goto L74
    L89:
        throw new NoViableAltException("", 53, 0, this.input);     // Catch: Throwable -> L35 RecognitionException -> L37
    L37:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r26 = this.adaptor;
        TokenStream r27 = this.input;
        r5.tree = (GrammarAST) r26.errorNode(r27, r5.start, r27.LT(-1), e);
    L35:
        th = move-exception;
        throw th;
    }

    public final actionScopeName_return actionScopeName() throws RecognitionException {
        actionScopeName_return r5 = new actionScopeName_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token PARSER");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token LEXER");
        int r12 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r12 == 31) goto L19;
        if (r12 != 44) goto L7;
        char r13 = 3;
    L20:
        if (r13 == 1) goto L27;
        GrammarAST r14 = null;
        if (r13 == 2) goto L26;
        if (r13 != 3) goto L28;
        Token r15 = (Token) match(this.input, 44, FOLLOW_PARSER_in_actionScopeName1348);     // Catch: Throwable -> L13 RecognitionException -> L15
        r10.add(r15);     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = null;     // Catch: Throwable -> L13 RecognitionException -> L15
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L13 RecognitionException -> L15
        TreeAdaptor r16 = this.adaptor;     // Catch: Throwable -> L13 RecognitionException -> L15
        r16.addChild(r14, (GrammarAST) r16.create(28, r15));     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = r14;     // Catch: Throwable -> L13 RecognitionException -> L15
    L28:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r17 = (GrammarAST) this.adaptor.rulePostProcessing(r14);     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = r17;     // Catch: Throwable -> L13 RecognitionException -> L15
        this.adaptor.setTokenBoundaries(r17, r5.start, r5.stop);     // Catch: Throwable -> L13 RecognitionException -> L15
    L32:
        return r5;
    L26:
        Token r18 = (Token) match(this.input, 31, FOLLOW_LEXER_in_actionScopeName1333);     // Catch: Throwable -> L13 RecognitionException -> L15
        r11.add(r18);     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = null;     // Catch: Throwable -> L13 RecognitionException -> L15
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L13 RecognitionException -> L15
        TreeAdaptor r19 = this.adaptor;     // Catch: Throwable -> L13 RecognitionException -> L15
        r19.addChild(r14, (GrammarAST) r19.create(28, r18));     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = r14;     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L28
    L27:
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L13 RecognitionException -> L15
        pushFollow(FOLLOW_id_in_actionScopeName1328);     // Catch: Throwable -> L13 RecognitionException -> L15
        id_return r20 = id();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        this.adaptor.addChild(r14, r20.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L28
    L7:
        if (r12 != 57) goto L9;
    L17:
        r13 = 1;
        goto L20
    L9:
        if (r12 == 66) goto L17;
        throw new NoViableAltException("", 15, 0, this.input);     // Catch: Throwable -> L13 RecognitionException -> L15
    L19:
        r13 = 2;
    L15:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r21 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r21.errorNode(r110, r5.start, r110.LT(-1), e);
    L13:
        th = move-exception;
        throw th;
    }

    public final altList_return altList() throws RecognitionException {
        altList_return r5 = new altList_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token OR");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule alternative");
        pushFollow(FOLLOW_alternative_in_altList2805);     // Catch: Throwable -> L7 RecognitionException -> L9
        alternative_return r12 = alternative();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r11.add(r12.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
    L5:
        if (this.input.LA(1) != 43) goto L11;
        r10.add((Token) match(this.input, 43, FOLLOW_OR_in_altList2808));     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_alternative_in_altList2810);     // Catch: Throwable -> L7 RecognitionException -> L9
        alternative_return r13 = alternative();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r11.add(r13.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        r5.tree = null;     // Catch: Throwable -> L7 RecognitionException -> L9
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L7 RecognitionException -> L9
        if (r11.hasNext() == false) goto L18;
    L14:
        if (r11.hasNext() == false) goto L16;
        this.adaptor.addChild(r14, r11.nextTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L14
    L16:
        r11.reset();     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r14;     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r15 = (GrammarAST) this.adaptor.rulePostProcessing(r14);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r15;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.setTokenBoundaries(r15, r5.start, r5.stop);     // Catch: Throwable -> L7 RecognitionException -> L9
    L21:
        return r5;
    L18:
        throw new RewriteEarlyExitException();     // Catch: Throwable -> L7 RecognitionException -> L9
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r16 = this.adaptor;
        TokenStream r17 = this.input;
        r5.tree = (GrammarAST) r16.errorNode(r17, r5.start, r17.LT(-1), e);
    L7:
        th = move-exception;
        throw th;
    }

    public final alternative_return alternative() throws RecognitionException {
        alternative_return r5 = new alternative_return();
        r5.start = this.input.LT(1);
        RewriteRuleSubtreeStream r10 = new RewriteRuleSubtreeStream(this.adaptor, "rule elementOptions");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule element");
        this.paraphrases.push("matching alternative");
    L8:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r12 = this.adaptor;
        TokenStream r13 = this.input;
        r5.tree = (GrammarAST) r12.errorNode(r13, r5.start, r13.LT(-1), e);
    L85:
        return r5;
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.input.LA(1) != 35) goto L10;
        pushFollow(FOLLOW_elementOptions_in_alternative2844);     // Catch: Throwable -> L6 RecognitionException -> L8
        elementOptions_return r14 = elementOptions();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r10.add(r14.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L11:
        int r15 = this.input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        int r16 = 34;
        int r17 = 4;
        if (r15 == 4) goto L34;
        if (r15 == 20) goto L34;
        if (r15 == 34) goto L34;
        if (r15 == 39) goto L34;
        if (r15 == 57) goto L34;
        if (r15 == 59) goto L34;
        if (r15 == 62) goto L34;
        if (r15 == 66) goto L34;
        if (r15 != (-1)) goto L23;
    L33:
        char r18 = 2;
    L36:
        if (r18 != 1) goto L38;
        ArrayList r19 = null;
        int r110 = 0;
    L47:
        int r20 = this.input.LA(1);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r20 == r17) goto L78;
        if (r20 == 20) goto L78;
        if (r20 == r16) goto L78;
        if (r20 == 39) goto L78;
        if (r20 == 57) goto L78;
        if (r20 == 59) goto L78;
        if (r20 == 62) goto L78;
        if (r20 == 66) goto L78;
        if (r110 < 1) goto L77;
        GrammarAST r21 = null;
        r5.tree = null;     // Catch: Throwable -> L6 RecognitionException -> L8
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        RewriteRuleSubtreeStream r22 = new RewriteRuleSubtreeStream(this.adaptor, "token e", r19);     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r23 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r24 = (GrammarAST) this.adaptor.becomeRoot(new AltAST(74), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r10.hasNext() == false) goto L63;
        this.adaptor.addChild(r24, r10.nextTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L63:
        r10.reset();     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r22.hasNext() == false) goto L75;
    L66:
        if (r22.hasNext() == false) goto L68;
        this.adaptor.addChild(r24, r22.nextTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L66
    L68:
        r22.reset();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.adaptor.addChild(r23, r24);     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.tree = r23;     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r25 = r23;
    L69:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r26 = (GrammarAST) this.adaptor.rulePostProcessing(r25);     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.tree = r26;     // Catch: Throwable -> L6 RecognitionException -> L8
        this.adaptor.setTokenBoundaries(r26, r5.start, r5.stop);     // Catch: Throwable -> L6 RecognitionException -> L8
        this.paraphrases.pop();     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r27 = r5.tree;     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r14 == null) goto L72;
        GrammarAST r28 = (GrammarAST) r14.getTree();     // Catch: Throwable -> L6 RecognitionException -> L8
    L73:
        Grammar.setNodeOptions(r27, r28);     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L85
    L72:
        r28 = r21;
        goto L73
    L75:
        throw new RewriteEarlyExitException();     // Catch: Throwable -> L6 RecognitionException -> L8
    L77:
        throw new EarlyExitException(48, this.input);     // Catch: Throwable -> L6 RecognitionException -> L8
    L78:
        pushFollow(FOLLOW_element_in_alternative2853);     // Catch: Throwable -> L6 RecognitionException -> L8
        element_return r29 = element();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r11.add(r29.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r19 != null) goto L81;
        r19 = new ArrayList();     // Catch: Throwable -> L6 RecognitionException -> L8
    L81:
        r19.add(r29.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        r110 = r110 + 1;
        r17 = 4;
        r16 = 34;
        goto L47
    L38:
        if (r18 == 2) goto L42;
        r25 = null;
    L40:
        r21 = null;
        goto L69
    L42:
        r5.tree = null;     // Catch: Throwable -> L6 RecognitionException -> L8
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        r25 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r30 = (GrammarAST) this.adaptor.becomeRoot(new AltAST(74), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r10.hasNext() == false) goto L45;
        this.adaptor.addChild(r30, r10.nextTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L45:
        r10.reset();     // Catch: Throwable -> L6 RecognitionException -> L8
        TreeAdaptor r31 = this.adaptor;     // Catch: Throwable -> L6 RecognitionException -> L8
        r31.addChild(r30, (GrammarAST) r31.create(83, "EPSILON"));     // Catch: Throwable -> L6 RecognitionException -> L8
        this.adaptor.addChild(r25, r30);     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.tree = r25;     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L40
    L23:
        if (r15 == 43) goto L33;
        if (r15 == 47) goto L33;
        if (r15 == 56) goto L33;
        if (r15 == 58) goto L33;
        throw new NoViableAltException("", 49, 0, this.input);     // Catch: Throwable -> L6 RecognitionException -> L8
    L34:
        r18 = 1;
        goto L36
    L10:
        r14 = null;
        goto L11
    }

    public final alternativeEntry_return alternativeEntry() throws RecognitionException {
        alternativeEntry_return r5 = new alternativeEntry_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        pushFollow(FOLLOW_alternative_in_alternativeEntry4183);     // Catch: Throwable -> L5 RecognitionException -> L7
        alternative_return r11 = alternative();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r10, r11.getTree());     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r10, (GrammarAST) this.adaptor.create((Token) match(this.input, -1, FOLLOW_EOF_in_alternativeEntry4185)));     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r12 = (GrammarAST) this.adaptor.rulePostProcessing(r10);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r12;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.setTokenBoundaries(r12, r5.start, r5.stop);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r13 = this.adaptor;
        TokenStream r14 = this.input;
        r5.tree = (GrammarAST) r13.errorNode(r14, r5.start, r14.LT(-1), e);
    L5:
        th = move-exception;
        throw th;
    }

    public final atom_return atom() throws RecognitionException {
        atom_return r5 = new atom_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);
        if (r10 != 20) goto L5;
        char r11 = 5;
    L51:
        if (r11 == 1) goto L61;
        if (r11 == 2) goto L60;
        if (r11 == 3) goto L59;
        if (r11 == 4) goto L58;
        if (r11 == 5) goto L57;
        GrammarAST r12 = null;
    L62:
        r5.stop = this.input.LT(-1);
        GrammarAST r13 = (GrammarAST) this.adaptor.rulePostProcessing(r12);
        r5.tree = r13;
        this.adaptor.setTokenBoundaries(r13, r5.start, r5.stop);
        return r5;
    L57:
        r12 = (GrammarAST) this.adaptor.nil();
        pushFollow(FOLLOW_wildcard_in_atom3517);
        wildcard_return r14 = wildcard();
        this.state._fsp--;
        this.adaptor.addChild(r12, r14.getTree());
        goto L62
    L58:
        r12 = (GrammarAST) this.adaptor.nil();
        pushFollow(FOLLOW_notSet_in_atom3509);
        notSet_return r15 = notSet();
        this.state._fsp--;
        this.adaptor.addChild(r12, r15.getTree());
        goto L62
    L59:
        r12 = (GrammarAST) this.adaptor.nil();
        pushFollow(FOLLOW_ruleref_in_atom3501);
        ruleref_return r16 = ruleref();
        this.state._fsp--;
        this.adaptor.addChild(r12, r16.getTree());
        goto L62
    L60:
        r12 = (GrammarAST) this.adaptor.nil();
        pushFollow(FOLLOW_terminal_in_atom3491);
        terminal_return r17 = terminal();
        this.state._fsp--;
        this.adaptor.addChild(r12, r17.getTree());
        goto L62
    L61:
        r12 = (GrammarAST) this.adaptor.nil();
        pushFollow(FOLLOW_range_in_atom3484);
        range_return r18 = range();
        this.state._fsp--;
        this.adaptor.addChild(r12, r18.getTree());
        goto L62
    L5:
        if (r10 != 39) goto L7;
        r11 = 4;
        goto L51
    L7:
        if (r10 != 57) goto L9;
        r11 = 3;
        goto L51
    L9:
        if (r10 == 62) goto L14;
        if (r10 != 66) goto L13;
    L11:
        r11 = 2;
        goto L51
    L13:
        throw new NoViableAltException("", 62, 0, this.input);
    L14:
        int r19 = this.input.LA(2);
        if (r19 != 52) goto L17;
        r11 = 1;
        goto L51
    L17:
        if (r19 == (-1)) goto L11;
        if (r19 == 4) goto L11;
        if (r19 == 20) goto L11;
        if (r19 >= 34) goto L23;
    L24:
        if (r19 == 39) goto L11;
        if (r19 == 43) goto L11;
        if (r19 == 45) goto L11;
        if (r19 == 47) goto L11;
        if (r19 == 51) goto L11;
        if (r19 < 56) goto L38;
        if (r19 <= 59) goto L11;
    L38:
        if (r19 < 61) goto L40;
        if (r19 <= 62) goto L11;
    L40:
        if (r19 == 66) goto L11;
        int r20 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L45
        throw new NoViableAltException("", 62, 1, this.input);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        this.input.rewind(r20);
        throw th;
    L23:
        if (r19 <= 35) goto L11;
        goto L11
    }

    public final block_return block() throws RecognitionException {
        block_return r5 = new block_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token LPAREN");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token COLON");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token RPAREN");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule ruleAction");
        RewriteRuleSubtreeStream r14 = new RewriteRuleSubtreeStream(this.adaptor, "rule optionsSpec");
        RewriteRuleSubtreeStream r15 = new RewriteRuleSubtreeStream(this.adaptor, "rule altList");
        Token r16 = (Token) match(this.input, 34, FOLLOW_LPAREN_in_block3771);     // Catch: Throwable -> L12 RecognitionException -> L14
        r10.add(r16);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r17 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        int r18 = 11;
        if (r17 == 11) goto L10;
        if (r17 == 14) goto L10;
        if (r17 == 42) goto L10;
        ArrayList r19 = null;
    L24:
        pushFollow(FOLLOW_altList_in_block3804);     // Catch: Throwable -> L12 RecognitionException -> L14
        altList_return r20 = altList();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        r15.add(r20.getTree());     // Catch: Throwable -> L12 RecognitionException -> L14
        r12.add((Token) match(this.input, 56, FOLLOW_RPAREN_in_block3808));     // Catch: Throwable -> L12 RecognitionException -> L14
        r5.tree = null;     // Catch: Throwable -> L12 RecognitionException -> L14
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L12 RecognitionException -> L14
        RewriteRuleSubtreeStream r21 = new RewriteRuleSubtreeStream(this.adaptor, "token ra", r19);     // Catch: Throwable -> L12 RecognitionException -> L14
        GrammarAST r22 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L12 RecognitionException -> L14
        GrammarAST r23 = (GrammarAST) this.adaptor.becomeRoot(new BlockAST(78, r16, "BLOCK"), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r14.hasNext() == false) goto L27;
        this.adaptor.addChild(r23, r14.nextTree());     // Catch: Throwable -> L12 RecognitionException -> L14
    L27:
        r14.reset();     // Catch: Throwable -> L12 RecognitionException -> L14
    L29:
        if (r21.hasNext() == false) goto L31;
        this.adaptor.addChild(r23, r21.nextTree());     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L29
    L31:
        r21.reset();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.addChild(r23, r15.nextTree());     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.addChild(r22, r23);     // Catch: Throwable -> L12 RecognitionException -> L14
        r5.tree = r22;     // Catch: Throwable -> L12 RecognitionException -> L14
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L12 RecognitionException -> L14
        GrammarAST r24 = (GrammarAST) this.adaptor.rulePostProcessing(r22);     // Catch: Throwable -> L12 RecognitionException -> L14
        r5.tree = r24;     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.setTokenBoundaries(r24, r5.start, r5.stop);     // Catch: Throwable -> L12 RecognitionException -> L14
        GrammarAST r25 = (GrammarAST) r5.tree.getFirstChildWithType(42);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r25 == null) goto L37;
        Grammar.setNodeOptions(r5.tree, r25);     // Catch: Throwable -> L12 RecognitionException -> L14
    L37:
        return r5;
    L10:
        if (this.input.LA(1) != 42) goto L16;
        pushFollow(FOLLOW_optionsSpec_in_block3783);     // Catch: Throwable -> L12 RecognitionException -> L14
        optionsSpec_return r26 = optionsSpec();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        r14.add(r26.getTree());     // Catch: Throwable -> L12 RecognitionException -> L14
    L16:
        r19 = null;
    L18:
        if (this.input.LA(1) != r18) goto L23;
        pushFollow(FOLLOW_ruleAction_in_block3788);     // Catch: Throwable -> L12 RecognitionException -> L14
        ruleAction_return r110 = ruleAction();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        r13.add(r110.getTree());     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r19 != null) goto L22;
        r19 = new ArrayList();     // Catch: Throwable -> L12 RecognitionException -> L14
    L22:
        r19.add(r110.getTree());     // Catch: Throwable -> L12 RecognitionException -> L14
        r18 = 11;
        goto L18
    L23:
        r11.add((Token) match(this.input, 14, FOLLOW_COLON_in_block3791));     // Catch: Throwable -> L12 RecognitionException -> L14
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r27 = this.adaptor;
        TokenStream r28 = this.input;
        r5.tree = (GrammarAST) r27.errorNode(r28, r5.start, r28.LT(-1), e);
    L12:
        th = move-exception;
        throw th;
    }

    public final blockEntry_return blockEntry() throws RecognitionException {
        blockEntry_return r5 = new blockEntry_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        pushFollow(FOLLOW_block_in_blockEntry4214);     // Catch: Throwable -> L5 RecognitionException -> L7
        block_return r11 = block();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r10, r11.getTree());     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r10, (GrammarAST) this.adaptor.create((Token) match(this.input, -1, FOLLOW_EOF_in_blockEntry4216)));     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r12 = (GrammarAST) this.adaptor.rulePostProcessing(r10);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r12;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.setTokenBoundaries(r12, r5.start, r5.stop);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r13 = this.adaptor;
        TokenStream r14 = this.input;
        r5.tree = (GrammarAST) r13.errorNode(r14, r5.start, r14.LT(-1), e);
    L5:
        th = move-exception;
        throw th;
    }

    public final blockSet_return blockSet() throws RecognitionException {
        blockSet_return r5 = new blockSet_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token OR");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token LPAREN");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token RPAREN");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule setElement");
        Token r14 = (Token) match(this.input, 34, FOLLOW_LPAREN_in_blockSet3672);     // Catch: Throwable -> L7 RecognitionException -> L9
        r11.add(r14);     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_setElement_in_blockSet3674);     // Catch: Throwable -> L7 RecognitionException -> L9
        setElement_return r15 = setElement();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r13.add(r15.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
    L5:
        if (this.input.LA(1) != 43) goto L11;
        r10.add((Token) match(this.input, 43, FOLLOW_OR_in_blockSet3677));     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_setElement_in_blockSet3679);     // Catch: Throwable -> L7 RecognitionException -> L9
        setElement_return r16 = setElement();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r13.add(r16.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        r12.add((Token) match(this.input, 56, FOLLOW_RPAREN_in_blockSet3683));     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = null;     // Catch: Throwable -> L7 RecognitionException -> L9
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r17 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r18 = (GrammarAST) this.adaptor.becomeRoot(new SetAST(98, r14, "SET"), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L7 RecognitionException -> L9
        if (r13.hasNext() == false) goto L18;
    L14:
        if (r13.hasNext() == false) goto L16;
        this.adaptor.addChild(r18, r13.nextTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L14
    L16:
        r13.reset();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.addChild(r17, r18);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r17;     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r19 = (GrammarAST) this.adaptor.rulePostProcessing(r17);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r19;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.setTokenBoundaries(r19, r5.start, r5.stop);     // Catch: Throwable -> L7 RecognitionException -> L9
    L21:
        return r5;
    L18:
        throw new RewriteEarlyExitException();     // Catch: Throwable -> L7 RecognitionException -> L9
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r20 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r20.errorNode(r110, r5.start, r110.LT(-1), e);
    L7:
        th = move-exception;
        throw th;
    }

    public final blockSuffix_return blockSuffix() throws RecognitionException {
        blockSuffix_return r5 = new blockSuffix_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        pushFollow(FOLLOW_ebnfSuffix_in_blockSuffix3315);     // Catch: Throwable -> L5 RecognitionException -> L7
        ebnfSuffix_return r11 = ebnfSuffix();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r10, r11.getTree());     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r12 = (GrammarAST) this.adaptor.rulePostProcessing(r10);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r12;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.setTokenBoundaries(r12, r5.start, r5.stop);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r13 = this.adaptor;
        TokenStream r14 = this.input;
        r5.tree = (GrammarAST) r13.errorNode(r14, r5.start, r14.LT(-1), e);
    L5:
        th = move-exception;
        throw th;
    }

    public final channelsSpec_return channelsSpec() throws RecognitionException {
        channelsSpec_return r5 = new channelsSpec_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r11 = (GrammarAST) this.adaptor.becomeRoot((GrammarAST) this.adaptor.create((Token) match(this.input, 13, FOLLOW_CHANNELS_in_channelsSpec1258)), r10);     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_id_in_channelsSpec1261);     // Catch: Throwable -> L7 RecognitionException -> L9
        id_return r12 = id();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.addChild(r11, r12.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
    L5:
        if (this.input.LA(1) != 16) goto L11;
        Token r13 = (Token) match(this.input, 16, FOLLOW_COMMA_in_channelsSpec1264);     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_id_in_channelsSpec1267);     // Catch: Throwable -> L7 RecognitionException -> L9
        id_return r14 = id();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.addChild(r11, r14.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        Token r15 = (Token) match(this.input, 54, FOLLOW_RBRACE_in_channelsSpec1271);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r16 = (GrammarAST) this.adaptor.rulePostProcessing(r11);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r16;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.setTokenBoundaries(r16, r5.start, r5.stop);     // Catch: Throwable -> L7 RecognitionException -> L9
    L15:
        return r5;
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r17 = this.adaptor;
        TokenStream r18 = this.input;
        r5.tree = (GrammarAST) r17.errorNode(r18, r5.start, r18.LT(-1), e);
    L7:
        th = move-exception;
        throw th;
    }

    public final delegateGrammar_return delegateGrammar() throws RecognitionException {
        delegateGrammar_return r5 = new delegateGrammar_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (r10 != 57) goto L24;
        int r11 = this.input.LA(2);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (r11 != 10) goto L9;
    L8:
        char r12 = 1;
    L37:
        if (r12 == 1) goto L42;
        if (r12 == 2) goto L40;
        GrammarAST r13 = null;
    L43:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L18 RecognitionException -> L20
        GrammarAST r14 = (GrammarAST) this.adaptor.rulePostProcessing(r13);     // Catch: Throwable -> L18 RecognitionException -> L20
        r5.tree = r14;     // Catch: Throwable -> L18 RecognitionException -> L20
        this.adaptor.setTokenBoundaries(r14, r5.start, r5.stop);     // Catch: Throwable -> L18 RecognitionException -> L20
    L48:
        return r5;
    L40:
        GrammarAST r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L18 RecognitionException -> L20
        pushFollow(FOLLOW_id_in_delegateGrammar1096);     // Catch: Throwable -> L18 RecognitionException -> L20
        id_return r16 = id();     // Catch: Throwable -> L18 RecognitionException -> L20
        this.state._fsp--;     // Catch: Throwable -> L18 RecognitionException -> L20
        this.adaptor.addChild(r15, r16.getTree());     // Catch: Throwable -> L18 RecognitionException -> L20
    L41:
        r13 = r15;
        goto L43
    L42:
        GrammarAST r17 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L18 RecognitionException -> L20
        pushFollow(FOLLOW_id_in_delegateGrammar1081);     // Catch: Throwable -> L18 RecognitionException -> L20
        id_return r18 = id();     // Catch: Throwable -> L18 RecognitionException -> L20
        this.state._fsp--;     // Catch: Throwable -> L18 RecognitionException -> L20
        this.adaptor.addChild(r17, r18.getTree());     // Catch: Throwable -> L18 RecognitionException -> L20
        r15 = (GrammarAST) this.adaptor.becomeRoot((GrammarAST) this.adaptor.create((Token) match(this.input, 10, FOLLOW_ASSIGN_in_delegateGrammar1083)), r17);     // Catch: Throwable -> L18 RecognitionException -> L20
        pushFollow(FOLLOW_id_in_delegateGrammar1086);     // Catch: Throwable -> L18 RecognitionException -> L20
        id_return r19 = id();     // Catch: Throwable -> L18 RecognitionException -> L20
        this.state._fsp--;     // Catch: Throwable -> L18 RecognitionException -> L20
        this.adaptor.addChild(r15, r19.getTree());     // Catch: Throwable -> L18 RecognitionException -> L20
        goto L41
    L9:
        if (r11 == 16) goto L22;
        if (r11 == 58) goto L22;
        int r20 = this.input.mark();     // Catch: Throwable -> L18 RecognitionException -> L20
        this.input.consume();     // Catch: Throwable -> L15
        throw new NoViableAltException("", 8, 1, this.input);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.input.rewind(r20);     // Catch: Throwable -> L18 RecognitionException -> L20
        throw th;     // Catch: Throwable -> L18 RecognitionException -> L20
    L22:
        r12 = 2;
        goto L37
    L24:
        if (r10 != 66) goto L45;
        int r21 = this.input.LA(2);     // Catch: Throwable -> L18 RecognitionException -> L20
        if (r21 == 10) goto L8;
        if (r21 == 16) goto L22;
        if (r21 == 58) goto L22;
        int r22 = this.input.mark();     // Catch: Throwable -> L18 RecognitionException -> L20
        this.input.consume();     // Catch: Throwable -> L34
        throw new NoViableAltException("", 8, 2, this.input);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        this.input.rewind(r22);     // Catch: Throwable -> L18 RecognitionException -> L20
        throw th;     // Catch: Throwable -> L18 RecognitionException -> L20
    L45:
        throw new NoViableAltException("", 8, 0, this.input);     // Catch: Throwable -> L18 RecognitionException -> L20
    L20:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r23 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r23.errorNode(r110, r5.start, r110.LT(-1), e);
    L18:
        th = move-exception;
        throw th;
    }

    public final delegateGrammars_return delegateGrammars() throws RecognitionException {
        delegateGrammars_return r5 = new delegateGrammars_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token COMMA");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token IMPORT");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token SEMI");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule delegateGrammar");
        r11.add((Token) match(this.input, 29, FOLLOW_IMPORT_in_delegateGrammars1043));     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_delegateGrammar_in_delegateGrammars1045);     // Catch: Throwable -> L7 RecognitionException -> L9
        delegateGrammar_return r14 = delegateGrammar();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r13.add(r14.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
    L5:
        if (this.input.LA(1) != 16) goto L11;
        r10.add((Token) match(this.input, 16, FOLLOW_COMMA_in_delegateGrammars1048));     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_delegateGrammar_in_delegateGrammars1050);     // Catch: Throwable -> L7 RecognitionException -> L9
        delegateGrammar_return r15 = delegateGrammar();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r13.add(r15.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        r12.add((Token) match(this.input, 58, FOLLOW_SEMI_in_delegateGrammars1054));     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = null;     // Catch: Throwable -> L7 RecognitionException -> L9
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r16 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r17 = (GrammarAST) this.adaptor.becomeRoot(r11.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L7 RecognitionException -> L9
        if (r13.hasNext() == false) goto L18;
    L14:
        if (r13.hasNext() == false) goto L16;
        this.adaptor.addChild(r17, r13.nextTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L14
    L16:
        r13.reset();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.addChild(r16, r17);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r16;     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r18 = (GrammarAST) this.adaptor.rulePostProcessing(r16);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r18;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.setTokenBoundaries(r18, r5.start, r5.stop);     // Catch: Throwable -> L7 RecognitionException -> L9
    L21:
        return r5;
    L18:
        throw new RewriteEarlyExitException();     // Catch: Throwable -> L7 RecognitionException -> L9
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r19 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r19.errorNode(r110, r5.start, r110.LT(-1), e);
    L7:
        th = move-exception;
        throw th;
    }

    public final ebnf_return ebnf() throws RecognitionException {
        ebnf_return r5 = new ebnf_return();
        r5.start = this.input.LT(1);
        RewriteRuleSubtreeStream r10 = new RewriteRuleSubtreeStream(this.adaptor, "rule blockSuffix");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule block");
        pushFollow(FOLLOW_block_in_ebnf3241);     // Catch: Throwable -> L34 RecognitionException -> L36
        block_return r12 = block();     // Catch: Throwable -> L34 RecognitionException -> L36
        this.state._fsp--;     // Catch: Throwable -> L34 RecognitionException -> L36
        r11.add(r12.getTree());     // Catch: Throwable -> L34 RecognitionException -> L36
        int r13 = this.input.LA(1);     // Catch: Throwable -> L34 RecognitionException -> L36
        if (r13 != 45) goto L6;
    L39:
        char r14 = 1;
    L40:
        GrammarAST r15 = null;
        if (r14 == 1) goto L45;
        if (r14 != 2) goto L46;
        r5.tree = null;     // Catch: Throwable -> L34 RecognitionException -> L36
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L34 RecognitionException -> L36
        r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L34 RecognitionException -> L36
        this.adaptor.addChild(r15, r11.nextTree());     // Catch: Throwable -> L34 RecognitionException -> L36
        r5.tree = r15;     // Catch: Throwable -> L34 RecognitionException -> L36
    L46:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L34 RecognitionException -> L36
        GrammarAST r16 = (GrammarAST) this.adaptor.rulePostProcessing(r15);     // Catch: Throwable -> L34 RecognitionException -> L36
        r5.tree = r16;     // Catch: Throwable -> L34 RecognitionException -> L36
        this.adaptor.setTokenBoundaries(r16, r5.start, r5.stop);     // Catch: Throwable -> L34 RecognitionException -> L36
    L50:
        return r5;
    L45:
        pushFollow(FOLLOW_blockSuffix_in_ebnf3265);     // Catch: Throwable -> L34 RecognitionException -> L36
        blockSuffix_return r17 = blockSuffix();     // Catch: Throwable -> L34 RecognitionException -> L36
        this.state._fsp--;     // Catch: Throwable -> L34 RecognitionException -> L36
        r10.add(r17.getTree());     // Catch: Throwable -> L34 RecognitionException -> L36
        r5.tree = null;     // Catch: Throwable -> L34 RecognitionException -> L36
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L34 RecognitionException -> L36
        r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L34 RecognitionException -> L36
        GrammarAST r18 = (GrammarAST) this.adaptor.becomeRoot(r10.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L34 RecognitionException -> L36
        this.adaptor.addChild(r18, r11.nextTree());     // Catch: Throwable -> L34 RecognitionException -> L36
        this.adaptor.addChild(r15, r18);     // Catch: Throwable -> L34 RecognitionException -> L36
        r5.tree = r15;     // Catch: Throwable -> L34 RecognitionException -> L36
        goto L46
    L6:
        if (r13 == 51) goto L39;
        if (r13 == 61) goto L39;
        if (r13 != (-1)) goto L12;
    L38:
        r14 = 2;
        goto L40
    L12:
        if (r13 == 4) goto L38;
        if (r13 == 20) goto L38;
        if (r13 == 34) goto L38;
        if (r13 == 39) goto L38;
        if (r13 == 43) goto L38;
        if (r13 == 47) goto L38;
        if (r13 < 56) goto L28;
        if (r13 <= 59) goto L38;
    L28:
        if (r13 == 62) goto L38;
        if (r13 == 66) goto L38;
        throw new NoViableAltException("", 56, 0, this.input);     // Catch: Throwable -> L34 RecognitionException -> L36
    L36:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r19 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r19.errorNode(r110, r5.start, r110.LT(-1), e);
    L34:
        th = move-exception;
        throw th;
    }

    public final ebnfSuffix_return ebnfSuffix() throws RecognitionException {
        ebnfSuffix_return r5 = new ebnfSuffix_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token STAR");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token QUESTION");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token PLUS");
        int r13 = this.input.LA(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r13 == 45) goto L15;
        if (r13 == 51) goto L14;
        if (r13 != 61) goto L9;
        char r14 = 2;
    L16:
        GrammarAST r15 = null;
        if (r14 == 1) goto L31;
        if (r14 == 2) goto L26;
        if (r14 != 3) goto L36;
        r12.add((Token) match(this.input, 45, FOLLOW_PLUS_in_ebnfSuffix3372));     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this.input.LA(1) != 51) goto L24;
        Token r16 = (Token) match(this.input, 51, FOLLOW_QUESTION_in_ebnfSuffix3376);     // Catch: Throwable -> L10 RecognitionException -> L12
        r11.add(r16);     // Catch: Throwable -> L10 RecognitionException -> L12
    L25:
        r5.tree = null;     // Catch: Throwable -> L10 RecognitionException -> L12
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L10 RecognitionException -> L12
        r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.adaptor.addChild(r15, new PlusBlockAST(90, r5.start, r16));     // Catch: Throwable -> L10 RecognitionException -> L12
        r5.tree = r15;     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L36
    L24:
        r16 = null;
    L36:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L10 RecognitionException -> L12
        GrammarAST r17 = (GrammarAST) this.adaptor.rulePostProcessing(r15);     // Catch: Throwable -> L10 RecognitionException -> L12
        r5.tree = r17;     // Catch: Throwable -> L10 RecognitionException -> L12
        this.adaptor.setTokenBoundaries(r17, r5.start, r5.stop);     // Catch: Throwable -> L10 RecognitionException -> L12
    L40:
        return r5;
    L26:
        r10.add((Token) match(this.input, 61, FOLLOW_STAR_in_ebnfSuffix3350));     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this.input.LA(1) != 51) goto L29;
        Token r18 = (Token) match(this.input, 51, FOLLOW_QUESTION_in_ebnfSuffix3354);     // Catch: Throwable -> L10 RecognitionException -> L12
        r11.add(r18);     // Catch: Throwable -> L10 RecognitionException -> L12
    L30:
        r5.tree = null;     // Catch: Throwable -> L10 RecognitionException -> L12
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L10 RecognitionException -> L12
        r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.adaptor.addChild(r15, new StarBlockAST(80, r5.start, r18));     // Catch: Throwable -> L10 RecognitionException -> L12
        r5.tree = r15;     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L36
    L29:
        r18 = null;
        goto L30
    L31:
        r11.add((Token) match(this.input, 51, FOLLOW_QUESTION_in_ebnfSuffix3330));     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this.input.LA(1) != 51) goto L34;
        Token r19 = (Token) match(this.input, 51, FOLLOW_QUESTION_in_ebnfSuffix3334);     // Catch: Throwable -> L10 RecognitionException -> L12
        r11.add(r19);     // Catch: Throwable -> L10 RecognitionException -> L12
    L35:
        r5.tree = null;     // Catch: Throwable -> L10 RecognitionException -> L12
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L10 RecognitionException -> L12
        r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L10 RecognitionException -> L12
        this.adaptor.addChild(r15, new OptionalBlockAST(89, r5.start, r19));     // Catch: Throwable -> L10 RecognitionException -> L12
        r5.tree = r15;     // Catch: Throwable -> L10 RecognitionException -> L12
        goto L36
    L34:
        r19 = null;
        goto L35
    L9:
        throw new NoViableAltException("", 60, 0, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    L14:
        r14 = 1;
        goto L16
    L15:
        r14 = 3;
    L12:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r20 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r20.errorNode(r110, r5.start, r110.LT(-1), e);
    L10:
        th = move-exception;
        throw th;
    }

    public final element_return element() throws RecognitionException {
        element_return r5 = new element_return();
        r5.start = this.input.LT(1);
        RewriteRuleSubtreeStream r10 = new RewriteRuleSubtreeStream(this.adaptor, "rule labeledElement");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule atom");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule ebnfSuffix");
        this.paraphrases.push("looking for rule element");
        this.input.mark();
        int r13 = this.input.LA(1);     // Catch: Throwable -> L51 RecognitionException -> L53
        if (r13 == 4) goto L99;
        if (r13 == 20) goto L98;
        if (r13 == 34) goto L97;
        if (r13 == 39) goto L98;
        if (r13 == 57) goto L58;
        if (r13 == 59) goto L99;
        if (r13 == 62) goto L98;
        if (r13 != 66) goto L57;
        int r14 = this.input.LA(2);     // Catch: Throwable -> L51 RecognitionException -> L53
        if (r14 != 10) goto L17;
    L55:
        char r15 = 1;
    L101:
        if (r15 != 1) goto L103;
        pushFollow(FOLLOW_labeledElement_in_element2968);     // Catch: Throwable -> L51 RecognitionException -> L53
        labeledElement_return r16 = labeledElement();     // Catch: Throwable -> L51 RecognitionException -> L53
        this.state._fsp--;     // Catch: Throwable -> L51 RecognitionException -> L53
        r10.add(r16.getTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        int r17 = this.input.LA(1);     // Catch: Throwable -> L51 RecognitionException -> L53
        if (r17 != 45) goto L149;
    L175:
        char r18 = 1;
    L176:
        if (r18 != 1) goto L178;
        pushFollow(FOLLOW_ebnfSuffix_in_element2974);     // Catch: Throwable -> L51 RecognitionException -> L53
        ebnfSuffix_return r19 = ebnfSuffix();     // Catch: Throwable -> L51 RecognitionException -> L53
        this.state._fsp--;     // Catch: Throwable -> L51 RecognitionException -> L53
        r12.add(r19.getTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        r5.tree = null;     // Catch: Throwable -> L51 RecognitionException -> L53
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        GrammarAST r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L51 RecognitionException -> L53
        GrammarAST r20 = (GrammarAST) this.adaptor.becomeRoot(r12.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L51 RecognitionException -> L53
        GrammarAST r21 = (GrammarAST) this.adaptor.becomeRoot(new BlockAST(78, r16.start, "BLOCK"), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L51 RecognitionException -> L53
        GrammarAST r22 = (GrammarAST) this.adaptor.becomeRoot(new AltAST(74), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.addChild(r22, r10.nextTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.addChild(r21, r22);     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.addChild(r20, r21);     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.addChild(r110, r20);     // Catch: Throwable -> L51 RecognitionException -> L53
        r5.tree = r110;     // Catch: Throwable -> L51 RecognitionException -> L53
    L182:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L51 RecognitionException -> L53
        GrammarAST r23 = (GrammarAST) this.adaptor.rulePostProcessing(r110);     // Catch: Throwable -> L51 RecognitionException -> L53
        r5.tree = r23;     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.setTokenBoundaries(r23, r5.start, r5.stop);     // Catch: Throwable -> L51 RecognitionException -> L53
        this.paraphrases.pop();     // Catch: Throwable -> L51 RecognitionException -> L53
    L197:
        return r5;
    L178:
        if (r18 != 2) goto L107;
        r5.tree = null;     // Catch: Throwable -> L51 RecognitionException -> L53
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.addChild(r110, r10.nextTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        r5.tree = r110;     // Catch: Throwable -> L51 RecognitionException -> L53
    L107:
        r110 = null;
        goto L182
    L149:
        if (r17 == 51) goto L175;
        if (r17 == 61) goto L175;
        if (r17 == (-1)) goto L173;
        if (r17 == 4) goto L173;
        if (r17 == 20) goto L173;
        if (r17 == 34) goto L173;
        if (r17 == 39) goto L173;
        if (r17 == 43) goto L173;
        if (r17 == 47) goto L173;
        if (r17 < 56) goto L168;
        if (r17 <= 59) goto L173;
    L168:
        if (r17 == 62) goto L173;
        if (r17 == 66) goto L173;
        throw new NoViableAltException("", 50, 0, this.input);     // Catch: Throwable -> L51 RecognitionException -> L53
    L173:
        r18 = 2;
        goto L176
    L103:
        if (r15 != 2) goto L105;
        pushFollow(FOLLOW_atom_in_element3020);     // Catch: Throwable -> L51 RecognitionException -> L53
        atom_return r24 = atom();     // Catch: Throwable -> L51 RecognitionException -> L53
        this.state._fsp--;     // Catch: Throwable -> L51 RecognitionException -> L53
        r11.add(r24.getTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        int r25 = this.input.LA(1);     // Catch: Throwable -> L51 RecognitionException -> L53
        if (r25 != 45) goto L113;
    L139:
        char r26 = 1;
    L140:
        if (r26 != 1) goto L142;
        pushFollow(FOLLOW_ebnfSuffix_in_element3026);     // Catch: Throwable -> L51 RecognitionException -> L53
        ebnfSuffix_return r27 = ebnfSuffix();     // Catch: Throwable -> L51 RecognitionException -> L53
        this.state._fsp--;     // Catch: Throwable -> L51 RecognitionException -> L53
        r12.add(r27.getTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        r5.tree = null;     // Catch: Throwable -> L51 RecognitionException -> L53
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L51 RecognitionException -> L53
        GrammarAST r28 = (GrammarAST) this.adaptor.becomeRoot(r12.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L51 RecognitionException -> L53
        GrammarAST r29 = (GrammarAST) this.adaptor.becomeRoot(new BlockAST(78, r24.start, "BLOCK"), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L51 RecognitionException -> L53
        GrammarAST r30 = (GrammarAST) this.adaptor.becomeRoot(new AltAST(74), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.addChild(r30, r11.nextTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.addChild(r29, r30);     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.addChild(r28, r29);     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.addChild(r110, r28);     // Catch: Throwable -> L51 RecognitionException -> L53
        r5.tree = r110;     // Catch: Throwable -> L51 RecognitionException -> L53
        goto L182
    L142:
        if (r26 != 2) goto L107;
        r5.tree = null;     // Catch: Throwable -> L51 RecognitionException -> L53
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.addChild(r110, r11.nextTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        r5.tree = r110;     // Catch: Throwable -> L51 RecognitionException -> L53
        goto L182
    L113:
        if (r25 == 51) goto L139;
        if (r25 == 61) goto L139;
        if (r25 == (-1)) goto L137;
        if (r25 == 4) goto L137;
        if (r25 == 20) goto L137;
        if (r25 == 34) goto L137;
        if (r25 == 39) goto L137;
        if (r25 == 43) goto L137;
        if (r25 == 47) goto L137;
        if (r25 < 56) goto L132;
        if (r25 <= 59) goto L137;
    L132:
        if (r25 == 62) goto L137;
        if (r25 == 66) goto L137;
        throw new NoViableAltException("", 51, 0, this.input);     // Catch: Throwable -> L51 RecognitionException -> L53
    L137:
        r26 = 2;
        goto L140
    L105:
        if (r15 == 3) goto L109;
        if (r15 != 4) goto L107;
        r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L51 RecognitionException -> L53
        pushFollow(FOLLOW_actionElement_in_element3077);     // Catch: Throwable -> L51 RecognitionException -> L53
        actionElement_return r31 = actionElement();     // Catch: Throwable -> L51 RecognitionException -> L53
        this.state._fsp--;     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.addChild(r110, r31.getTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        goto L182
    L109:
        r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L51 RecognitionException -> L53
        pushFollow(FOLLOW_ebnf_in_element3072);     // Catch: Throwable -> L51 RecognitionException -> L53
        ebnf_return r32 = ebnf();     // Catch: Throwable -> L51 RecognitionException -> L53
        this.state._fsp--;     // Catch: Throwable -> L51 RecognitionException -> L53
        this.adaptor.addChild(r110, r32.getTree());     // Catch: Throwable -> L51 RecognitionException -> L53
        goto L182
    L17:
        if (r14 == 46) goto L55;
        if (r14 == (-1)) goto L98;
        if (r14 == 4) goto L98;
        if (r14 == 20) goto L98;
        if (r14 < 34) goto L28;
        if (r14 <= 35) goto L98;
    L28:
        if (r14 == 39) goto L98;
        if (r14 == 43) goto L98;
        if (r14 == 45) goto L98;
        if (r14 == 47) goto L98;
        if (r14 == 51) goto L98;
        if (r14 < 56) goto L41;
        if (r14 <= 59) goto L98;
    L41:
        if (r14 < 61) goto L43;
        if (r14 <= 62) goto L98;
    L43:
        if (r14 == 66) goto L98;
        int r33 = this.input.mark();     // Catch: Throwable -> L51 RecognitionException -> L53
        this.input.consume();     // Catch: Throwable -> L48
        throw new NoViableAltException("", 52, 2, this.input);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        this.input.rewind(r33);     // Catch: Throwable -> L51 RecognitionException -> L53
        throw th;     // Catch: Throwable -> L51 RecognitionException -> L53
    L57:
        throw new NoViableAltException("", 52, 0, this.input);     // Catch: Throwable -> L51 RecognitionException -> L53
    L58:
        int r34 = this.input.LA(2);     // Catch: Throwable -> L51 RecognitionException -> L53
        if (r34 == 10) goto L55;
        if (r34 == 46) goto L55;
        if (r34 == (-1)) goto L98;
        if (r34 == 4) goto L98;
        if (r34 == 8) goto L98;
        if (r34 == 20) goto L98;
        if (r34 < 34) goto L74;
        if (r34 <= 35) goto L98;
    L74:
        if (r34 == 39) goto L98;
        if (r34 == 43) goto L98;
        if (r34 == 45) goto L98;
        if (r34 == 47) goto L98;
        if (r34 == 51) goto L98;
        if (r34 < 56) goto L87;
        if (r34 <= 59) goto L98;
    L87:
        if (r34 < 61) goto L89;
        if (r34 <= 62) goto L98;
    L89:
        if (r34 == 66) goto L98;
        int r35 = this.input.mark();     // Catch: Throwable -> L51 RecognitionException -> L53
        this.input.consume();     // Catch: Throwable -> L94
        throw new NoViableAltException("", 52, 1, this.input);     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        this.input.rewind(r35);     // Catch: Throwable -> L51 RecognitionException -> L53
        throw th;     // Catch: Throwable -> L51 RecognitionException -> L53
    L97:
        r15 = 3;
    L98:
        r15 = 2;
    L99:
        r15 = 4;
    L53:
        e = move-exception;
        TreeAdaptor r36 = this.adaptor;
        TokenStream r37 = this.input;
        r5.tree = (GrammarAST) r36.errorNode(r37, r5.start, r37.LT(-1), e);
        TokenStream r38 = this.input;
        int r39 = r38.get(r38.range()).getType();
        if (r39 != 14) goto L188;
    L198:
        reportError(new v4ParserException("unterminated rule (missing ';') detected at '" + this.input.LT(1).getText() + " " + this.input.LT(2).getText() + "'", this.input));
        if (r39 != 12) goto L201;
    L202:
        TokenStream r40 = this.input;
        r40.seek(r40.range());
    L204:
        if (r39 != 55) goto L206;
    L207:
        int r41 = this.input.index();
        Token r42 = this.input.get(r41);
    L209:
        if (r42.getType() == 57) goto L213;
        if (r42.getType() == 66) goto L213;
        r41 = r41 - 1;
        r42 = this.input.get(r41);
    L213:
        this.input.seek(r41);
    L215:
        throw new ResyncToEndOfRuleBlock();
    L206:
        if (r39 != 11) goto L215;
    L201:
        if (r39 != 23) goto L204;
    L188:
        if (r39 == 55) goto L198;
        if (r39 == 12) goto L198;
        if (r39 == 23) goto L198;
        if (r39 == 11) goto L198;
        reportError(e);
        recover(this.input, e);
    L51:
        th = move-exception;
        throw th;
    }

    public final elementEntry_return elementEntry() throws RecognitionException {
        elementEntry_return r5 = new elementEntry_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        pushFollow(FOLLOW_element_in_elementEntry4194);     // Catch: Throwable -> L5 RecognitionException -> L7
        element_return r11 = element();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r10, r11.getTree());     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r10, (GrammarAST) this.adaptor.create((Token) match(this.input, -1, FOLLOW_EOF_in_elementEntry4196)));     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r12 = (GrammarAST) this.adaptor.rulePostProcessing(r10);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r12;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.setTokenBoundaries(r12, r5.start, r5.stop);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r13 = this.adaptor;
        TokenStream r14 = this.input;
        r5.tree = (GrammarAST) r13.errorNode(r14, r5.start, r14.LT(-1), e);
    L5:
        th = move-exception;
        throw th;
    }

    public final elementOption_return elementOption() throws RecognitionException {
        elementOption_return r5 = new elementOption_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r10 != 57) goto L25;
        int r11 = this.input.LA(2);     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r11 == 16) goto L23;
        if (r11 == 20) goto L23;
        if (r11 == 26) goto L23;
        if (r11 != 10) goto L13;
    L12:
        char r12 = 2;
    L39:
        if (r12 == 1) goto L44;
        if (r12 == 2) goto L42;
        GrammarAST r13 = null;
    L45:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L19 RecognitionException -> L21
        GrammarAST r14 = (GrammarAST) this.adaptor.rulePostProcessing(r13);     // Catch: Throwable -> L19 RecognitionException -> L21
        r5.tree = r14;     // Catch: Throwable -> L19 RecognitionException -> L21
        this.adaptor.setTokenBoundaries(r14, r5.start, r5.stop);     // Catch: Throwable -> L19 RecognitionException -> L21
    L50:
        return r5;
    L42:
        GrammarAST r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L19 RecognitionException -> L21
        pushFollow(FOLLOW_id_in_elementOption4084);     // Catch: Throwable -> L19 RecognitionException -> L21
        id_return r16 = id();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.state._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        this.adaptor.addChild(r15, r16.getTree());     // Catch: Throwable -> L19 RecognitionException -> L21
        GrammarAST r17 = (GrammarAST) this.adaptor.becomeRoot((GrammarAST) this.adaptor.create((Token) match(this.input, 10, FOLLOW_ASSIGN_in_elementOption4086)), r15);     // Catch: Throwable -> L19 RecognitionException -> L21
        pushFollow(FOLLOW_optionValue_in_elementOption4089);     // Catch: Throwable -> L19 RecognitionException -> L21
        optionValue_return r18 = optionValue();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.state._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        this.adaptor.addChild(r17, r18.getTree());     // Catch: Throwable -> L19 RecognitionException -> L21
    L43:
        r13 = r17;
        goto L45
    L44:
        r17 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L19 RecognitionException -> L21
        pushFollow(FOLLOW_qid_in_elementOption4076);     // Catch: Throwable -> L19 RecognitionException -> L21
        qid_return r19 = qid();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.state._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        this.adaptor.addChild(r17, r19.getTree());     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L43
    L13:
        int r20 = this.input.mark();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.input.consume();     // Catch: Throwable -> L16
        throw new NoViableAltException("", 79, 1, this.input);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.input.rewind(r20);     // Catch: Throwable -> L19 RecognitionException -> L21
        throw th;     // Catch: Throwable -> L19 RecognitionException -> L21
    L23:
        r12 = 1;
        goto L39
    L25:
        if (r10 != 66) goto L47;
        int r21 = this.input.LA(2);     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r21 == 16) goto L23;
        if (r21 == 20) goto L23;
        if (r21 == 26) goto L23;
        if (r21 == 10) goto L12;
        int r22 = this.input.mark();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.input.consume();     // Catch: Throwable -> L36
        throw new NoViableAltException("", 79, 2, this.input);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        this.input.rewind(r22);     // Catch: Throwable -> L19 RecognitionException -> L21
        throw th;     // Catch: Throwable -> L19 RecognitionException -> L21
    L47:
        throw new NoViableAltException("", 79, 0, this.input);     // Catch: Throwable -> L19 RecognitionException -> L21
    L21:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r23 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r23.errorNode(r110, r5.start, r110.LT(-1), e);
    L19:
        th = move-exception;
        throw th;
    }

    public final elementOptions_return elementOptions() throws RecognitionException {
        elementOptions_return r5 = new elementOptions_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token COMMA");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token LT");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token GT");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule elementOption");
        Token r14 = (Token) match(this.input, 35, FOLLOW_LT_in_elementOptions4014);     // Catch: Throwable -> L11 RecognitionException -> L13
        r11.add(r14);     // Catch: Throwable -> L11 RecognitionException -> L13
        int r15 = this.input.LA(1);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r15 != 57) goto L6;
    L7:
        pushFollow(FOLLOW_elementOption_in_elementOptions4017);     // Catch: Throwable -> L11 RecognitionException -> L13
        elementOption_return r16 = elementOption();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        r13.add(r16.getTree());     // Catch: Throwable -> L11 RecognitionException -> L13
    L9:
        if (this.input.LA(1) != 16) goto L15;
        r10.add((Token) match(this.input, 16, FOLLOW_COMMA_in_elementOptions4020));     // Catch: Throwable -> L11 RecognitionException -> L13
        pushFollow(FOLLOW_elementOption_in_elementOptions4022);     // Catch: Throwable -> L11 RecognitionException -> L13
        elementOption_return r17 = elementOption();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        r13.add(r17.getTree());     // Catch: Throwable -> L11 RecognitionException -> L13
    L15:
        r12.add((Token) match(this.input, 26, FOLLOW_GT_in_elementOptions4028));     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.tree = null;     // Catch: Throwable -> L11 RecognitionException -> L13
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L11 RecognitionException -> L13
        GrammarAST r18 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L11 RecognitionException -> L13
        GrammarAST r19 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L11 RecognitionException -> L13
        TreeAdaptor r20 = this.adaptor;     // Catch: Throwable -> L11 RecognitionException -> L13
        GrammarAST r21 = (GrammarAST) r20.becomeRoot((GrammarAST) r20.create(82, r14, "ELEMENT_OPTIONS"), r19);     // Catch: Throwable -> L11 RecognitionException -> L13
    L17:
        if (r13.hasNext() == false) goto L19;
        this.adaptor.addChild(r21, r13.nextTree());     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L17
    L19:
        r13.reset();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.adaptor.addChild(r18, r21);     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.tree = r18;     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L11 RecognitionException -> L13
        GrammarAST r22 = (GrammarAST) this.adaptor.rulePostProcessing(r18);     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.tree = r22;     // Catch: Throwable -> L11 RecognitionException -> L13
        this.adaptor.setTokenBoundaries(r22, r5.start, r5.stop);     // Catch: Throwable -> L11 RecognitionException -> L13
    L23:
        return r5;
    L6:
        if (r15 != 66) goto L15;
    L13:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r23 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r23.errorNode(r110, r5.start, r110.LT(-1), e);
    L11:
        th = move-exception;
        throw th;
    }

    public final exceptionGroup_return exceptionGroup() throws RecognitionException {
        exceptionGroup_return r5 = new exceptionGroup_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L7 RecognitionException -> L9
    L5:
        if (this.input.LA(1) != 12) goto L12;
        pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup1752);     // Catch: Throwable -> L7 RecognitionException -> L9
        exceptionHandler_return r11 = exceptionHandler();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.addChild(r10, r11.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L12:
        if (this.input.LA(1) != 23) goto L14;
        pushFollow(FOLLOW_finallyClause_in_exceptionGroup1755);     // Catch: Throwable -> L7 RecognitionException -> L9
        finallyClause_return r12 = finallyClause();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.addChild(r10, r12.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
    L14:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r13 = (GrammarAST) this.adaptor.rulePostProcessing(r10);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r13;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.setTokenBoundaries(r13, r5.start, r5.stop);     // Catch: Throwable -> L7 RecognitionException -> L9
    L18:
        return r5;
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r14 = this.adaptor;
        TokenStream r15 = this.input;
        r5.tree = (GrammarAST) r14.errorNode(r15, r5.start, r15.LT(-1), e);
    L7:
        th = move-exception;
        throw th;
    }

    public final exceptionHandler_return exceptionHandler() throws RecognitionException {
        exceptionHandler_return r5 = new exceptionHandler_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token ACTION");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token CATCH");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token ARG_ACTION");
        r11.add((Token) match(this.input, 12, FOLLOW_CATCH_in_exceptionHandler1772));     // Catch: Throwable -> L5 RecognitionException -> L7
        r12.add((Token) match(this.input, 8, FOLLOW_ARG_ACTION_in_exceptionHandler1774));     // Catch: Throwable -> L5 RecognitionException -> L7
        r10.add((Token) match(this.input, 4, FOLLOW_ACTION_in_exceptionHandler1776));     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = null;     // Catch: Throwable -> L5 RecognitionException -> L7
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r13 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r15 = (GrammarAST) this.adaptor.becomeRoot(r11.nextNode(), r14);     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r15, new ActionAST(r12.nextToken()));     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r15, new ActionAST(r10.nextToken()));     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r13, r15);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r13;     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r16 = (GrammarAST) this.adaptor.rulePostProcessing(r13);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r16;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.setTokenBoundaries(r16, r5.start, r5.stop);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r17 = this.adaptor;
        TokenStream r18 = this.input;
        r5.tree = (GrammarAST) r17.errorNode(r18, r5.start, r18.LT(-1), e);
    L5:
        th = move-exception;
        throw th;
    }

    public final finallyClause_return finallyClause() throws RecognitionException {
        finallyClause_return r5 = new finallyClause_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token ACTION");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token FINALLY");
        r11.add((Token) match(this.input, 23, FOLLOW_FINALLY_in_finallyClause1803));     // Catch: Throwable -> L5 RecognitionException -> L7
        r10.add((Token) match(this.input, 4, FOLLOW_ACTION_in_finallyClause1805));     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = null;     // Catch: Throwable -> L5 RecognitionException -> L7
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r12 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r13 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r14 = (GrammarAST) this.adaptor.becomeRoot(r11.nextNode(), r13);     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r14, new ActionAST(r10.nextToken()));     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r12, r14);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r12;     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r15 = (GrammarAST) this.adaptor.rulePostProcessing(r12);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r15;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.setTokenBoundaries(r15, r5.start, r5.stop);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r16 = this.adaptor;
        TokenStream r17 = this.input;
        r5.tree = (GrammarAST) r16.errorNode(r17, r5.start, r17.LT(-1), e);
    L5:
        th = move-exception;
        throw th;
    }

    public Parser[] getDelegates() {
        return new Parser[0];
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getGrammarFileName() {
        return "androidx/room/jarjarred/org/antlr/v4/parse/ANTLRParser.g";
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String[] getTokenNames() {
        return tokenNames;
    }

    public TreeAdaptor getTreeAdaptor() {
        return this.adaptor;
    }

    public void grammarError(ErrorType r5, Token r10, Object... r11) {
    }

    public final grammarSpec_return grammarSpec() throws RecognitionException {
        grammarSpec_return r5 = new grammarSpec_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token SEMI");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token EOF");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule modeSpec");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule grammarType");
        RewriteRuleSubtreeStream r14 = new RewriteRuleSubtreeStream(this.adaptor, "rule rules");
        RewriteRuleSubtreeStream r15 = new RewriteRuleSubtreeStream(this.adaptor, "rule id");
        RewriteRuleSubtreeStream r16 = new RewriteRuleSubtreeStream(this.adaptor, "rule prequelConstruct");
        RewriteRuleSubtreeStream r17 = new RewriteRuleSubtreeStream(this.adaptor, "rule sync");
        pushFollow(FOLLOW_grammarType_in_grammarSpec396);     // Catch: Throwable -> L19 RecognitionException -> L21
        grammarType_return r18 = grammarType();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.state._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        r13.add(r18.getTree());     // Catch: Throwable -> L19 RecognitionException -> L21
        pushFollow(FOLLOW_id_in_grammarSpec398);     // Catch: Throwable -> L19 RecognitionException -> L21
        id_return r19 = id();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.state._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        r15.add(r19.getTree());     // Catch: Throwable -> L19 RecognitionException -> L21
        r10.add((Token) match(this.input, 58, FOLLOW_SEMI_in_grammarSpec400));     // Catch: Throwable -> L19 RecognitionException -> L21
        pushFollow(FOLLOW_sync_in_grammarSpec438);     // Catch: Throwable -> L19 RecognitionException -> L21
        sync_return r20 = sync();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.state._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        r17.add(r20.getTree());     // Catch: Throwable -> L19 RecognitionException -> L21
    L4:
        int r21 = this.input.LA(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r21 == 11) goto L34;
        if (r21 == 13) goto L34;
        if (r21 == 29) goto L34;
        if (r21 == 42) goto L34;
        if (r21 == 65) goto L34;
        pushFollow(FOLLOW_rules_in_grammarSpec469);     // Catch: Throwable -> L19 RecognitionException -> L21
        rules_return r22 = rules();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.state._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        r14.add(r22.getTree());     // Catch: Throwable -> L19 RecognitionException -> L21
    L17:
        if (this.input.LA(1) != 36) goto L23;
        pushFollow(FOLLOW_modeSpec_in_grammarSpec475);     // Catch: Throwable -> L19 RecognitionException -> L21
        modeSpec_return r23 = modeSpec();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.state._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        r12.add(r23.getTree());     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L17
    L23:
        r11.add((Token) match(this.input, -1, FOLLOW_EOF_in_grammarSpec513));     // Catch: Throwable -> L19 RecognitionException -> L21
        r5.tree = null;     // Catch: Throwable -> L19 RecognitionException -> L21
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L19 RecognitionException -> L21
        GrammarAST r24 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L19 RecognitionException -> L21
        GrammarAST r25 = (GrammarAST) this.adaptor.becomeRoot(r13.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L19 RecognitionException -> L21
        this.adaptor.addChild(r25, r15.nextTree());     // Catch: Throwable -> L19 RecognitionException -> L21
    L25:
        if (r16.hasNext() == false) goto L27;
        this.adaptor.addChild(r25, r16.nextTree());     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L25
    L27:
        r16.reset();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.adaptor.addChild(r25, r14.nextTree());     // Catch: Throwable -> L19 RecognitionException -> L21
    L29:
        if (r12.hasNext() == false) goto L31;
        this.adaptor.addChild(r25, r12.nextTree());     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L29
    L31:
        r12.reset();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.adaptor.addChild(r24, r25);     // Catch: Throwable -> L19 RecognitionException -> L21
        r5.tree = r24;     // Catch: Throwable -> L19 RecognitionException -> L21
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L19 RecognitionException -> L21
        GrammarAST r26 = (GrammarAST) this.adaptor.rulePostProcessing(r24);     // Catch: Throwable -> L19 RecognitionException -> L21
        r5.tree = r26;     // Catch: Throwable -> L19 RecognitionException -> L21
        this.adaptor.setTokenBoundaries(r26, r5.start, r5.stop);     // Catch: Throwable -> L19 RecognitionException -> L21
        GrammarAST r27 = (GrammarAST) r5.tree.getFirstChildWithType(42);     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r27 == null) goto L38;
        Grammar.setNodeOptions(r5.tree, r27);     // Catch: Throwable -> L19 RecognitionException -> L21
    L38:
        return r5;
    L34:
        pushFollow(FOLLOW_prequelConstruct_in_grammarSpec442);     // Catch: Throwable -> L19 RecognitionException -> L21
        prequelConstruct_return r28 = prequelConstruct();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.state._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        r16.add(r28.getTree());     // Catch: Throwable -> L19 RecognitionException -> L21
        pushFollow(FOLLOW_sync_in_grammarSpec444);     // Catch: Throwable -> L19 RecognitionException -> L21
        sync_return r29 = sync();     // Catch: Throwable -> L19 RecognitionException -> L21
        this.state._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        r17.add(r29.getTree());     // Catch: Throwable -> L19 RecognitionException -> L21
    L21:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r30 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r30.errorNode(r110, r5.start, r110.LT(-1), e);
    L19:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v9, types: [androidx.room.jarjarred.org.antlr.runtime.Token] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final grammarType_return grammarType() throws RecognitionException {
        grammarType_return r5 = new grammarType_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token PARSER");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token LEXER");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token GRAMMAR");
        RewriteRuleTokenStream r13 = new RewriteRuleTokenStream(this.adaptor, "token TREE_GRAMMAR");
        int r14 = this.input.LA(1);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r14 == 25) goto L17;
        if (r14 == 31) goto L16;
        if (r14 == 44) goto L15;
        if (r14 != 67) goto L10;
        char r15 = 4;
    L18:
        GrammarAST r16 = null;
        Token r17 = null;
        r16 = null;
        if (r15 == 1) goto L29;
        if (r15 == 2) goto L27;
        if (r15 == 3) goto L26;
        if (r15 != 4) goto L24;
        r17 = (Token) match(this.input, 67, FOLLOW_TREE_GRAMMAR_in_grammarType762);     // Catch: Throwable -> L11 RecognitionException -> L13
        r13.add(r17);     // Catch: Throwable -> L11 RecognitionException -> L13
        ?? r18 = 0;
    L30:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L11 RecognitionException -> L13
        GrammarAST r19 = (GrammarAST) this.adaptor.rulePostProcessing(r16);     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.tree = r19;     // Catch: Throwable -> L11 RecognitionException -> L13
        this.adaptor.setTokenBoundaries(r19, r5.start, r5.stop);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r17 != null) goto L36;
        if (r18 == 0) goto L34;
        ((GrammarRootAST) r5.tree).grammarType = r18.getType();     // Catch: Throwable -> L11 RecognitionException -> L13
    L39:
        return r5;
    L34:
        ((GrammarRootAST) r5.tree).grammarType = 81;     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L39
    L36:
        throw new v3TreeGrammarException(r17);     // Catch: Throwable -> L11 RecognitionException -> L13
    L24:
        r18 = r16;
        goto L30
    L26:
        Token r20 = (Token) match(this.input, 25, FOLLOW_GRAMMAR_in_grammarType735);     // Catch: Throwable -> L11 RecognitionException -> L13
        r12.add(r20);     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.tree = null;     // Catch: Throwable -> L11 RecognitionException -> L13
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L11 RecognitionException -> L13
        GrammarAST r21 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.adaptor.addChild(r21, new GrammarRootAST(25, r20, "COMBINED_GRAMMAR", getTokenStream()));     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.tree = r21;     // Catch: Throwable -> L11 RecognitionException -> L13
        r16 = r21;
        goto L24
    L27:
        Token r22 = (Token) match(this.input, 44, FOLLOW_PARSER_in_grammarType710);     // Catch: Throwable -> L11 RecognitionException -> L13
        r10.add(r22);     // Catch: Throwable -> L11 RecognitionException -> L13
        Token r23 = (Token) match(this.input, 25, FOLLOW_GRAMMAR_in_grammarType714);     // Catch: Throwable -> L11 RecognitionException -> L13
        r12.add(r23);     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.tree = null;     // Catch: Throwable -> L11 RecognitionException -> L13
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L11 RecognitionException -> L13
        GrammarAST r24 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.adaptor.addChild(r24, new GrammarRootAST(25, r23, "PARSER_GRAMMAR", getTokenStream()));     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.tree = r24;     // Catch: Throwable -> L11 RecognitionException -> L13
        Token r25 = r22;
    L28:
        r17 = null;
        r16 = r24;
        r18 = r25;
        goto L30
    L29:
        Token r26 = (Token) match(this.input, 31, FOLLOW_LEXER_in_grammarType683);     // Catch: Throwable -> L11 RecognitionException -> L13
        r11.add(r26);     // Catch: Throwable -> L11 RecognitionException -> L13
        Token r27 = (Token) match(this.input, 25, FOLLOW_GRAMMAR_in_grammarType687);     // Catch: Throwable -> L11 RecognitionException -> L13
        r12.add(r27);     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.tree = null;     // Catch: Throwable -> L11 RecognitionException -> L13
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L11 RecognitionException -> L13
        r24 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.adaptor.addChild(r24, new GrammarRootAST(25, r27, "LEXER_GRAMMAR", getTokenStream()));     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.tree = r24;     // Catch: Throwable -> L11 RecognitionException -> L13
        r25 = r26;
        goto L28
    L10:
        throw new NoViableAltException("", 3, 0, this.input);     // Catch: Throwable -> L11 RecognitionException -> L13
    L15:
        r15 = 2;
        goto L18
    L16:
        r15 = 1;
        goto L18
    L17:
        r15 = 3;
    L13:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r28 = this.adaptor;
        TokenStream r29 = this.input;
        r5.tree = (GrammarAST) r28.errorNode(r29, r5.start, r29.LT(-1), e);
    L11:
        th = move-exception;
        throw th;
    }

    public final id_return id() throws RecognitionException {
        id_return r5 = new id_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token TOKEN_REF");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token RULE_REF");
        this.paraphrases.push("looking for an identifier");
        int r12 = this.input.LA(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r12 != 57) goto L7;
        char r13 = 1;
    L9:
        GrammarAST r14 = null;
        if (r13 == 1) goto L18;
        if (r13 != 2) goto L19;
        Token r15 = (Token) match(this.input, 66, FOLLOW_TOKEN_REF_in_id4133);     // Catch: Throwable -> L14 RecognitionException -> L16
        r10.add(r15);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = null;     // Catch: Throwable -> L14 RecognitionException -> L16
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        TreeAdaptor r16 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        r16.addChild(r14, (GrammarAST) r16.create(28, r15));     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r14;     // Catch: Throwable -> L14 RecognitionException -> L16
    L19:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r17 = (GrammarAST) this.adaptor.rulePostProcessing(r14);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r17;     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.setTokenBoundaries(r17, r5.start, r5.stop);     // Catch: Throwable -> L14 RecognitionException -> L16
        this.paraphrases.pop();     // Catch: Throwable -> L14 RecognitionException -> L16
    L24:
        return r5;
    L18:
        Token r18 = (Token) match(this.input, 57, FOLLOW_RULE_REF_in_id4120);     // Catch: Throwable -> L14 RecognitionException -> L16
        r11.add(r18);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = null;     // Catch: Throwable -> L14 RecognitionException -> L16
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        TreeAdaptor r19 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        r19.addChild(r14, (GrammarAST) r19.create(28, r18));     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r14;     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L19
    L7:
        if (r12 != 66) goto L21;
        r13 = 2;
        goto L9
    L21:
        throw new NoViableAltException("", 80, 0, this.input);     // Catch: Throwable -> L14 RecognitionException -> L16
    L16:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r20 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r20.errorNode(r110, r5.start, r110.LT(-1), e);
    L14:
        th = move-exception;
        throw th;
    }

    public final labeledAlt_return labeledAlt() throws RecognitionException {
        labeledAlt_return r5 = new labeledAlt_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L8 RecognitionException -> L10
        pushFollow(FOLLOW_alternative_in_labeledAlt2084);     // Catch: Throwable -> L8 RecognitionException -> L10
        alternative_return r11 = alternative();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        this.adaptor.addChild(r10, r11.getTree());     // Catch: Throwable -> L8 RecognitionException -> L10
        if (this.input.LA(1) != 47) goto L14;
        Token r12 = (Token) match(this.input, 47, FOLLOW_POUND_in_labeledAlt2090);     // Catch: Throwable -> L8 RecognitionException -> L10
        pushFollow(FOLLOW_id_in_labeledAlt2093);     // Catch: Throwable -> L8 RecognitionException -> L10
        id_return r13 = id();     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        AltAST r14 = (AltAST) ((GrammarAST) r11.getTree());     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r13 == null) goto L12;
        GrammarAST r15 = (GrammarAST) r13.getTree();     // Catch: Throwable -> L8 RecognitionException -> L10
    L13:
        r14.altLabel = r15;     // Catch: Throwable -> L8 RecognitionException -> L10
        goto L14
    L12:
        r15 = null;
    L14:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L8 RecognitionException -> L10
        GrammarAST r16 = (GrammarAST) this.adaptor.rulePostProcessing(r10);     // Catch: Throwable -> L8 RecognitionException -> L10
        r5.tree = r16;     // Catch: Throwable -> L8 RecognitionException -> L10
        this.adaptor.setTokenBoundaries(r16, r5.start, r5.stop);     // Catch: Throwable -> L8 RecognitionException -> L10
    L18:
        return r5;
    L10:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r17 = this.adaptor;
        TokenStream r18 = this.input;
        r5.tree = (GrammarAST) r17.errorNode(r18, r5.start, r18.LT(-1), e);
    L8:
        th = move-exception;
        throw th;
    }

    public final labeledElement_return labeledElement() throws RecognitionException {
        labeledElement_return r5 = new labeledElement_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token PLUS_ASSIGN");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token ASSIGN");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule block");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule id");
        RewriteRuleSubtreeStream r14 = new RewriteRuleSubtreeStream(this.adaptor, "rule atom");
        pushFollow(FOLLOW_id_in_labeledElement3167);     // Catch: Throwable -> L14 RecognitionException -> L16
        id_return r15 = id();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.state._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        r13.add(r15.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        int r16 = this.input.LA(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r16 != 10) goto L7;
        char r17 = 1;
    L9:
        GrammarAST r18 = null;
        if (r17 == 1) goto L18;
        if (r17 == 2) goto L13;
        Token r19 = null;
    L19:
        int r20 = this.input.LA(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r20 != 20) goto L22;
    L35:
        char r21 = 1;
    L37:
        if (r21 == 1) goto L41;
        if (r21 != 2) goto L42;
        pushFollow(FOLLOW_block_in_labeledElement3205);     // Catch: Throwable -> L14 RecognitionException -> L16
        block_return r22 = block();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.state._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        r12.add(r22.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = null;     // Catch: Throwable -> L14 RecognitionException -> L16
        RewriteRuleTokenStream r23 = new RewriteRuleTokenStream(this.adaptor, "token ass", r19);     // Catch: Throwable -> L14 RecognitionException -> L16
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r18 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r24 = (GrammarAST) this.adaptor.becomeRoot(r23.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r24, r13.nextTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r24, r12.nextTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r18, r24);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r18;     // Catch: Throwable -> L14 RecognitionException -> L16
    L42:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r25 = (GrammarAST) this.adaptor.rulePostProcessing(r18);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r25;     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.setTokenBoundaries(r25, r5.start, r5.stop);     // Catch: Throwable -> L14 RecognitionException -> L16
    L47:
        return r5;
    L41:
        pushFollow(FOLLOW_atom_in_labeledElement3183);     // Catch: Throwable -> L14 RecognitionException -> L16
        atom_return r26 = atom();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.state._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        r14.add(r26.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = null;     // Catch: Throwable -> L14 RecognitionException -> L16
        RewriteRuleTokenStream r27 = new RewriteRuleTokenStream(this.adaptor, "token ass", r19);     // Catch: Throwable -> L14 RecognitionException -> L16
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r18 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r28 = (GrammarAST) this.adaptor.becomeRoot(r27.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r28, r13.nextTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r28, r14.nextTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r18, r28);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r18;     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L42
    L22:
        if (r20 == 39) goto L35;
        if (r20 == 57) goto L35;
        if (r20 == 62) goto L35;
        if (r20 == 66) goto L35;
        if (r20 != 34) goto L34;
        r21 = 2;
        goto L37
    L34:
        throw new NoViableAltException("", 55, 0, this.input);     // Catch: Throwable -> L14 RecognitionException -> L16
    L13:
        r19 = (Token) match(this.input, 46, FOLLOW_PLUS_ASSIGN_in_labeledElement3176);     // Catch: Throwable -> L14 RecognitionException -> L16
        r10.add(r19);     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L19
    L18:
        Token r29 = (Token) match(this.input, 10, FOLLOW_ASSIGN_in_labeledElement3172);     // Catch: Throwable -> L14 RecognitionException -> L16
        r11.add(r29);     // Catch: Throwable -> L14 RecognitionException -> L16
        r19 = r29;
        goto L19
    L7:
        if (r16 != 46) goto L44;
        r17 = 2;
        goto L9
    L44:
        throw new NoViableAltException("", 54, 0, this.input);     // Catch: Throwable -> L14 RecognitionException -> L16
    L16:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r30 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r30.errorNode(r110, r5.start, r110.LT(-1), e);
    L14:
        th = move-exception;
        throw th;
    }

    public final labeledLexerElement_return labeledLexerElement() throws RecognitionException {
        labeledLexerElement_return r5 = new labeledLexerElement_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token PLUS_ASSIGN");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token ASSIGN");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerBlock");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule id");
        RewriteRuleSubtreeStream r14 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerAtom");
        pushFollow(FOLLOW_id_in_labeledLexerElement2533);     // Catch: Throwable -> L14 RecognitionException -> L16
        id_return r15 = id();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.state._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        r13.add(r15.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        int r16 = this.input.LA(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r16 != 10) goto L7;
        char r17 = 1;
    L9:
        GrammarAST r18 = null;
        if (r17 == 1) goto L18;
        if (r17 == 2) goto L13;
        Token r19 = null;
    L19:
        int r20 = this.input.LA(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r20 != 20) goto L22;
    L36:
        char r21 = 1;
    L38:
        if (r21 == 1) goto L42;
        if (r21 != 2) goto L43;
        pushFollow(FOLLOW_lexerBlock_in_labeledLexerElement2566);     // Catch: Throwable -> L14 RecognitionException -> L16
        lexerBlock_return r22 = lexerBlock();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.state._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        r12.add(r22.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = null;     // Catch: Throwable -> L14 RecognitionException -> L16
        RewriteRuleTokenStream r23 = new RewriteRuleTokenStream(this.adaptor, "token ass", r19);     // Catch: Throwable -> L14 RecognitionException -> L16
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r18 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r24 = (GrammarAST) this.adaptor.becomeRoot(r23.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r24, r13.nextTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r24, r12.nextTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r18, r24);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r18;     // Catch: Throwable -> L14 RecognitionException -> L16
    L43:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r25 = (GrammarAST) this.adaptor.rulePostProcessing(r18);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r25;     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.setTokenBoundaries(r25, r5.start, r5.stop);     // Catch: Throwable -> L14 RecognitionException -> L16
    L48:
        return r5;
    L42:
        pushFollow(FOLLOW_lexerAtom_in_labeledLexerElement2549);     // Catch: Throwable -> L14 RecognitionException -> L16
        lexerAtom_return r26 = lexerAtom();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.state._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        r14.add(r26.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = null;     // Catch: Throwable -> L14 RecognitionException -> L16
        RewriteRuleTokenStream r27 = new RewriteRuleTokenStream(this.adaptor, "token ass", r19);     // Catch: Throwable -> L14 RecognitionException -> L16
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r18 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r28 = (GrammarAST) this.adaptor.becomeRoot(r27.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r28, r13.nextTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r28, r14.nextTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r18, r28);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r18;     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L43
    L22:
        if (r20 == 32) goto L36;
        if (r20 == 39) goto L36;
        if (r20 == 57) goto L36;
        if (r20 == 62) goto L36;
        if (r20 == 66) goto L36;
        if (r20 != 34) goto L35;
        r21 = 2;
        goto L38
    L35:
        throw new NoViableAltException("", 40, 0, this.input);     // Catch: Throwable -> L14 RecognitionException -> L16
    L13:
        r19 = (Token) match(this.input, 46, FOLLOW_PLUS_ASSIGN_in_labeledLexerElement2542);     // Catch: Throwable -> L14 RecognitionException -> L16
        r10.add(r19);     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L19
    L18:
        Token r29 = (Token) match(this.input, 10, FOLLOW_ASSIGN_in_labeledLexerElement2538);     // Catch: Throwable -> L14 RecognitionException -> L16
        r11.add(r29);     // Catch: Throwable -> L14 RecognitionException -> L16
        r19 = r29;
        goto L19
    L7:
        if (r16 != 46) goto L45;
        r17 = 2;
        goto L9
    L45:
        throw new NoViableAltException("", 39, 0, this.input);     // Catch: Throwable -> L14 RecognitionException -> L16
    L16:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r30 = this.adaptor;
        TokenStream r31 = this.input;
        r5.tree = (GrammarAST) r30.errorNode(r31, r5.start, r31.LT(-1), e);
    L14:
        th = move-exception;
        throw th;
    }

    public final lexerAlt_return lexerAlt() throws RecognitionException {
        lexerAlt_return r5 = new lexerAlt_return();
        r5.start = this.input.LT(1);
        RewriteRuleSubtreeStream r10 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerCommands");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerElements");
        pushFollow(FOLLOW_lexerElements_in_lexerAlt2260);     // Catch: Throwable -> L15 RecognitionException -> L17
        lexerElements_return r12 = lexerElements();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        r11.add(r12.getTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        int r13 = this.input.LA(1);     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r13 != 53) goto L7;
        char r14 = 1;
    L20:
        GrammarAST r15 = null;
        if (r14 == 1) goto L25;
        if (r14 != 2) goto L26;
        r5.tree = null;     // Catch: Throwable -> L15 RecognitionException -> L17
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.adaptor.addChild(r15, r11.nextTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        r5.tree = r15;     // Catch: Throwable -> L15 RecognitionException -> L17
    L26:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L15 RecognitionException -> L17
        GrammarAST r16 = (GrammarAST) this.adaptor.rulePostProcessing(r15);     // Catch: Throwable -> L15 RecognitionException -> L17
        r5.tree = r16;     // Catch: Throwable -> L15 RecognitionException -> L17
        this.adaptor.setTokenBoundaries(r16, r5.start, r5.stop);     // Catch: Throwable -> L15 RecognitionException -> L17
    L30:
        return r5;
    L25:
        pushFollow(FOLLOW_lexerCommands_in_lexerAlt2266);     // Catch: Throwable -> L15 RecognitionException -> L17
        lexerCommands_return r17 = lexerCommands();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        r10.add(r17.getTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        r5.tree = null;     // Catch: Throwable -> L15 RecognitionException -> L17
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L15 RecognitionException -> L17
        GrammarAST r18 = (GrammarAST) this.adaptor.becomeRoot(new AltAST(87), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L15 RecognitionException -> L17
        this.adaptor.addChild(r18, r11.nextTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        this.adaptor.addChild(r18, r10.nextTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        this.adaptor.addChild(r15, r18);     // Catch: Throwable -> L15 RecognitionException -> L17
        r5.tree = r15;     // Catch: Throwable -> L15 RecognitionException -> L17
        goto L26
    L7:
        if (r13 != 43) goto L9;
    L19:
        r14 = 2;
        goto L20
    L9:
        if (r13 == 56) goto L19;
        if (r13 == 58) goto L19;
        throw new NoViableAltException("", 32, 0, this.input);     // Catch: Throwable -> L15 RecognitionException -> L17
    L17:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r19 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r19.errorNode(r110, r5.start, r110.LT(-1), e);
    L15:
        th = move-exception;
        throw th;
    }

    public final lexerAltList_return lexerAltList() throws RecognitionException {
        lexerAltList_return r5 = new lexerAltList_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token OR");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerAlt");
        pushFollow(FOLLOW_lexerAlt_in_lexerAltList2237);     // Catch: Throwable -> L7 RecognitionException -> L9
        lexerAlt_return r12 = lexerAlt();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r11.add(r12.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
    L5:
        if (this.input.LA(1) != 43) goto L11;
        r10.add((Token) match(this.input, 43, FOLLOW_OR_in_lexerAltList2240));     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_lexerAlt_in_lexerAltList2242);     // Catch: Throwable -> L7 RecognitionException -> L9
        lexerAlt_return r13 = lexerAlt();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r11.add(r13.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        r5.tree = null;     // Catch: Throwable -> L7 RecognitionException -> L9
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L7 RecognitionException -> L9
        if (r11.hasNext() == false) goto L18;
    L14:
        if (r11.hasNext() == false) goto L16;
        this.adaptor.addChild(r14, r11.nextTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L14
    L16:
        r11.reset();     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r14;     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r15 = (GrammarAST) this.adaptor.rulePostProcessing(r14);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r15;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.setTokenBoundaries(r15, r5.start, r5.stop);     // Catch: Throwable -> L7 RecognitionException -> L9
    L21:
        return r5;
    L18:
        throw new RewriteEarlyExitException();     // Catch: Throwable -> L7 RecognitionException -> L9
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r16 = this.adaptor;
        TokenStream r17 = this.input;
        r5.tree = (GrammarAST) r16.errorNode(r17, r5.start, r17.LT(-1), e);
    L7:
        th = move-exception;
        throw th;
    }

    public final lexerAtom_return lexerAtom() throws RecognitionException {
        lexerAtom_return r5 = new lexerAtom_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r10 == 20) goto L55;
        if (r10 == 32) goto L54;
        char r11 = 4;
        if (r10 == 39) goto L56;
        if (r10 != 57) goto L11;
        r11 = 3;
        goto L56
    L11:
        if (r10 == 62) goto L20;
        if (r10 != 66) goto L15;
    L13:
        r11 = 2;
        goto L56
    L15:
        throw new NoViableAltException("", 61, 0, this.input);     // Catch: Throwable -> L16 RecognitionException -> L18
    L20:
        int r12 = this.input.LA(2);     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r12 != 52) goto L23;
        r11 = 1;
        goto L56
    L23:
        if (r12 == 4) goto L13;
        if (r12 == 20) goto L13;
        if (r12 == 32) goto L13;
        if (r12 >= 34) goto L29;
    L30:
        if (r12 == 39) goto L13;
        if (r12 == 43) goto L13;
        if (r12 == 45) goto L13;
        if (r12 == 51) goto L13;
        if (r12 == 53) goto L13;
        if (r12 >= 56) goto L42;
    L43:
        if (r12 < 61) goto L45;
        if (r12 <= 62) goto L13;
    L45:
        if (r12 == 66) goto L13;
        int r13 = this.input.mark();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.input.consume();     // Catch: Throwable -> L50
        throw new NoViableAltException("", 61, 1, this.input);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        this.input.rewind(r13);     // Catch: Throwable -> L16 RecognitionException -> L18
        throw th;     // Catch: Throwable -> L16 RecognitionException -> L18
    L42:
        if (r12 <= 59) goto L13;
    L29:
        if (r12 <= 35) goto L13;
    L56:
        switch(r11) {
            case 1: goto L64;
            case 2: goto L63;
            case 3: goto L62;
            case 4: goto L61;
            case 5: goto L59;
            case 6: goto L58;
            default: goto L57;
        };     // Catch: Throwable -> L16 RecognitionException -> L18
    L57:
        GrammarAST r14 = null;
    L65:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L16 RecognitionException -> L18
        GrammarAST r15 = (GrammarAST) this.adaptor.rulePostProcessing(r14);     // Catch: Throwable -> L16 RecognitionException -> L18
        r5.tree = r15;     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.setTokenBoundaries(r15, r5.start, r5.stop);     // Catch: Throwable -> L16 RecognitionException -> L18
    L69:
        return r5;
    L58:
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r14, (GrammarAST) this.adaptor.create((Token) match(this.input, 32, FOLLOW_LEXER_CHAR_SET_in_lexerAtom3439)));     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L65
    L59:
        GrammarAST r16 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        pushFollow(FOLLOW_wildcard_in_lexerAtom3431);     // Catch: Throwable -> L16 RecognitionException -> L18
        wildcard_return r17 = wildcard();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r16, r17.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
    L60:
        r14 = r16;
        goto L65
    L61:
        r16 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        pushFollow(FOLLOW_notSet_in_lexerAtom3423);     // Catch: Throwable -> L16 RecognitionException -> L18
        notSet_return r18 = notSet();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r16, r18.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L60
    L62:
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r14, new RuleRefAST((Token) match(this.input, 57, FOLLOW_RULE_REF_in_lexerAtom3412)));     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L65
    L63:
        r16 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        pushFollow(FOLLOW_terminal_in_lexerAtom3402);     // Catch: Throwable -> L16 RecognitionException -> L18
        terminal_return r19 = terminal();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r16, r19.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L60
    L64:
        r16 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        pushFollow(FOLLOW_range_in_lexerAtom3397);     // Catch: Throwable -> L16 RecognitionException -> L18
        range_return r20 = range();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r16, r20.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L60
    L54:
        r11 = 6;
        goto L56
    L55:
        r11 = 5;
    L18:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r21 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r21.errorNode(r110, r5.start, r110.LT(-1), e);
    L16:
        th = move-exception;
        throw th;
    }

    public final lexerBlock_return lexerBlock() throws RecognitionException {
        lexerBlock_return r5 = new lexerBlock_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token LPAREN");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token COLON");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token RPAREN");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule optionsSpec");
        RewriteRuleSubtreeStream r14 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerAltList");
        Token r15 = (Token) match(this.input, 34, FOLLOW_LPAREN_in_lexerBlock2599);     // Catch: Throwable -> L6 RecognitionException -> L8
        r10.add(r15);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this.input.LA(1) != 42) goto L10;
        pushFollow(FOLLOW_optionsSpec_in_lexerBlock2611);     // Catch: Throwable -> L6 RecognitionException -> L8
        optionsSpec_return r16 = optionsSpec();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r13.add(r16.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        r11.add((Token) match(this.input, 14, FOLLOW_COLON_in_lexerBlock2613));     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        pushFollow(FOLLOW_lexerAltList_in_lexerBlock2626);     // Catch: Throwable -> L6 RecognitionException -> L8
        lexerAltList_return r17 = lexerAltList();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r14.add(r17.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        r12.add((Token) match(this.input, 56, FOLLOW_RPAREN_in_lexerBlock2636));     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.tree = null;     // Catch: Throwable -> L6 RecognitionException -> L8
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r18 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r19 = (GrammarAST) this.adaptor.becomeRoot(new BlockAST(78, r15, "BLOCK"), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r13.hasNext() == false) goto L13;
        this.adaptor.addChild(r19, r13.nextTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L13:
        r13.reset();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.adaptor.addChild(r19, r14.nextTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        this.adaptor.addChild(r18, r19);     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.tree = r18;     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r20 = (GrammarAST) this.adaptor.rulePostProcessing(r18);     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.tree = r20;     // Catch: Throwable -> L6 RecognitionException -> L8
        this.adaptor.setTokenBoundaries(r20, r5.start, r5.stop);     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r21 = (GrammarAST) r5.tree.getFirstChildWithType(42);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r21 == null) goto L19;
        Grammar.setNodeOptions(r5.tree, r21);     // Catch: Throwable -> L6 RecognitionException -> L8
    L19:
        return r5;
    L8:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r22 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r22.errorNode(r110, r5.start, r110.LT(-1), e);
    L6:
        th = move-exception;
        throw th;
    }

    public final lexerCommand_return lexerCommand() throws RecognitionException {
        lexerCommand_return r5 = new lexerCommand_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token LPAREN");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token RPAREN");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerCommandName");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerCommandExpr");
        int r14 = this.input.LA(1);     // Catch: Throwable -> L24 RecognitionException -> L26
        if (r14 != 36) goto L7;
        int r15 = this.input.LA(2);     // Catch: Throwable -> L24 RecognitionException -> L26
        if (r15 == 34) goto L12;
        if (r15 != 16) goto L49;
    L28:
        char r16 = 2;
    L59:
        GrammarAST r17 = null;
        if (r16 == 1) goto L64;
        if (r16 != 2) goto L65;
        r17 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L24 RecognitionException -> L26
        pushFollow(FOLLOW_lexerCommandName_in_lexerCommand2719);     // Catch: Throwable -> L24 RecognitionException -> L26
        lexerCommandName_return r18 = lexerCommandName();     // Catch: Throwable -> L24 RecognitionException -> L26
        this.state._fsp--;     // Catch: Throwable -> L24 RecognitionException -> L26
        this.adaptor.addChild(r17, r18.getTree());     // Catch: Throwable -> L24 RecognitionException -> L26
    L65:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L24 RecognitionException -> L26
        GrammarAST r19 = (GrammarAST) this.adaptor.rulePostProcessing(r17);     // Catch: Throwable -> L24 RecognitionException -> L26
        r5.tree = r19;     // Catch: Throwable -> L24 RecognitionException -> L26
        this.adaptor.setTokenBoundaries(r19, r5.start, r5.stop);     // Catch: Throwable -> L24 RecognitionException -> L26
    L69:
        return r5;
    L64:
        pushFollow(FOLLOW_lexerCommandName_in_lexerCommand2698);     // Catch: Throwable -> L24 RecognitionException -> L26
        lexerCommandName_return r20 = lexerCommandName();     // Catch: Throwable -> L24 RecognitionException -> L26
        this.state._fsp--;     // Catch: Throwable -> L24 RecognitionException -> L26
        r12.add(r20.getTree());     // Catch: Throwable -> L24 RecognitionException -> L26
        r10.add((Token) match(this.input, 34, FOLLOW_LPAREN_in_lexerCommand2700));     // Catch: Throwable -> L24 RecognitionException -> L26
        pushFollow(FOLLOW_lexerCommandExpr_in_lexerCommand2702);     // Catch: Throwable -> L24 RecognitionException -> L26
        lexerCommandExpr_return r21 = lexerCommandExpr();     // Catch: Throwable -> L24 RecognitionException -> L26
        this.state._fsp--;     // Catch: Throwable -> L24 RecognitionException -> L26
        r13.add(r21.getTree());     // Catch: Throwable -> L24 RecognitionException -> L26
        r11.add((Token) match(this.input, 56, FOLLOW_RPAREN_in_lexerCommand2704));     // Catch: Throwable -> L24 RecognitionException -> L26
        r5.tree = null;     // Catch: Throwable -> L24 RecognitionException -> L26
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L24 RecognitionException -> L26
        r17 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L24 RecognitionException -> L26
        GrammarAST r22 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L24 RecognitionException -> L26
        TreeAdaptor r23 = this.adaptor;     // Catch: Throwable -> L24 RecognitionException -> L26
        GrammarAST r24 = (GrammarAST) r23.becomeRoot((GrammarAST) r23.create(86, "LEXER_ACTION_CALL"), r22);     // Catch: Throwable -> L24 RecognitionException -> L26
        this.adaptor.addChild(r24, r12.nextTree());     // Catch: Throwable -> L24 RecognitionException -> L26
        this.adaptor.addChild(r24, r13.nextTree());     // Catch: Throwable -> L24 RecognitionException -> L26
        this.adaptor.addChild(r17, r24);     // Catch: Throwable -> L24 RecognitionException -> L26
        r5.tree = r17;     // Catch: Throwable -> L24 RecognitionException -> L26
        goto L65
    L49:
        if (r15 == 43) goto L28;
        if (r15 == 56) goto L28;
        if (r15 == 58) goto L28;
        int r25 = this.input.mark();     // Catch: Throwable -> L24 RecognitionException -> L26
        this.input.consume();     // Catch: Throwable -> L56
        throw new NoViableAltException("", 43, 3, this.input);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        this.input.rewind(r25);     // Catch: Throwable -> L24 RecognitionException -> L26
        throw th;     // Catch: Throwable -> L24 RecognitionException -> L26
    L12:
        r16 = 1;
        goto L59
    L7:
        if (r14 != 57) goto L9;
        int r26 = this.input.LA(2);     // Catch: Throwable -> L24 RecognitionException -> L26
        if (r26 == 34) goto L12;
        if (r26 == 16) goto L28;
        if (r26 == 43) goto L28;
        if (r26 == 56) goto L28;
        if (r26 == 58) goto L28;
        int r27 = this.input.mark();     // Catch: Throwable -> L24 RecognitionException -> L26
        this.input.consume();     // Catch: Throwable -> L42
        throw new NoViableAltException("", 43, 1, this.input);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        this.input.rewind(r27);     // Catch: Throwable -> L24 RecognitionException -> L26
        throw th;     // Catch: Throwable -> L24 RecognitionException -> L26
    L9:
        if (r14 != 66) goto L30;
        int r28 = this.input.LA(2);     // Catch: Throwable -> L24 RecognitionException -> L26
        if (r28 == 34) goto L12;
        if (r28 == 16) goto L28;
        if (r28 == 43) goto L28;
        if (r28 == 56) goto L28;
        if (r28 == 58) goto L28;
        int r29 = this.input.mark();     // Catch: Throwable -> L24 RecognitionException -> L26
        this.input.consume();     // Catch: Throwable -> L21
        throw new NoViableAltException("", 43, 2, this.input);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        this.input.rewind(r29);     // Catch: Throwable -> L24 RecognitionException -> L26
        throw th;     // Catch: Throwable -> L24 RecognitionException -> L26
    L30:
        throw new NoViableAltException("", 43, 0, this.input);     // Catch: Throwable -> L24 RecognitionException -> L26
    L26:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r30 = this.adaptor;
        TokenStream r31 = this.input;
        r5.tree = (GrammarAST) r30.errorNode(r31, r5.start, r31.LT(-1), e);
    L24:
        th = move-exception;
        throw th;
    }

    public final lexerCommandExpr_return lexerCommandExpr() throws RecognitionException {
        lexerCommandExpr_return r5 = new lexerCommandExpr_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r10 != 57) goto L6;
    L16:
        char r11 = 1;
    L17:
        if (r11 == 1) goto L21;
        if (r11 == 2) goto L20;
        GrammarAST r12 = null;
    L22:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L12 RecognitionException -> L14
        GrammarAST r13 = (GrammarAST) this.adaptor.rulePostProcessing(r12);     // Catch: Throwable -> L12 RecognitionException -> L14
        r5.tree = r13;     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.setTokenBoundaries(r13, r5.start, r5.stop);     // Catch: Throwable -> L12 RecognitionException -> L14
    L26:
        return r5;
    L20:
        r12 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.addChild(r12, (GrammarAST) this.adaptor.create((Token) match(this.input, 30, FOLLOW_INT_in_lexerCommandExpr2735)));     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L22
    L21:
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_id_in_lexerCommandExpr2730);     // Catch: Throwable -> L12 RecognitionException -> L14
        id_return r15 = id();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.addChild(r14, r15.getTree());     // Catch: Throwable -> L12 RecognitionException -> L14
        r12 = r14;
        goto L22
    L6:
        if (r10 == 66) goto L16;
        if (r10 != 30) goto L11;
        r11 = 2;
        goto L17
    L11:
        throw new NoViableAltException("", 44, 0, this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r16 = this.adaptor;
        TokenStream r17 = this.input;
        r5.tree = (GrammarAST) r16.errorNode(r17, r5.start, r17.LT(-1), e);
    L12:
        th = move-exception;
        throw th;
    }

    public final lexerCommandName_return lexerCommandName() throws RecognitionException {
        lexerCommandName_return r5 = new lexerCommandName_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token MODE");
        int r11 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r11 != 57) goto L6;
    L16:
        char r12 = 1;
    L17:
        if (r12 == 1) goto L22;
        GrammarAST r13 = null;
        if (r12 != 2) goto L23;
        Token r14 = (Token) match(this.input, 36, FOLLOW_MODE_in_lexerCommandName2777);     // Catch: Throwable -> L12 RecognitionException -> L14
        r10.add(r14);     // Catch: Throwable -> L12 RecognitionException -> L14
        r5.tree = null;     // Catch: Throwable -> L12 RecognitionException -> L14
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L12 RecognitionException -> L14
        r13 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L12 RecognitionException -> L14
        TreeAdaptor r15 = this.adaptor;     // Catch: Throwable -> L12 RecognitionException -> L14
        r15.addChild(r13, (GrammarAST) r15.create(28, r14));     // Catch: Throwable -> L12 RecognitionException -> L14
        r5.tree = r13;     // Catch: Throwable -> L12 RecognitionException -> L14
    L23:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L12 RecognitionException -> L14
        GrammarAST r16 = (GrammarAST) this.adaptor.rulePostProcessing(r13);     // Catch: Throwable -> L12 RecognitionException -> L14
        r5.tree = r16;     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.setTokenBoundaries(r16, r5.start, r5.stop);     // Catch: Throwable -> L12 RecognitionException -> L14
    L27:
        return r5;
    L22:
        GrammarAST r17 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_id_in_lexerCommandName2759);     // Catch: Throwable -> L12 RecognitionException -> L14
        id_return r18 = id();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.addChild(r17, r18.getTree());     // Catch: Throwable -> L12 RecognitionException -> L14
        r13 = r17;
        goto L23
    L6:
        if (r11 == 66) goto L16;
        if (r11 != 36) goto L11;
        r12 = 2;
        goto L17
    L11:
        throw new NoViableAltException("", 45, 0, this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r19 = this.adaptor;
        TokenStream r20 = this.input;
        r5.tree = (GrammarAST) r19.errorNode(r20, r5.start, r20.LT(-1), e);
    L12:
        th = move-exception;
        throw th;
    }

    public final lexerCommands_return lexerCommands() throws RecognitionException {
        lexerCommands_return r5 = new lexerCommands_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token RARROW");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token COMMA");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerCommand");
        r10.add((Token) match(this.input, 53, FOLLOW_RARROW_in_lexerCommands2673));     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_lexerCommand_in_lexerCommands2675);     // Catch: Throwable -> L7 RecognitionException -> L9
        lexerCommand_return r13 = lexerCommand();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r12.add(r13.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
    L5:
        if (this.input.LA(1) != 16) goto L11;
        r11.add((Token) match(this.input, 16, FOLLOW_COMMA_in_lexerCommands2678));     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_lexerCommand_in_lexerCommands2680);     // Catch: Throwable -> L7 RecognitionException -> L9
        lexerCommand_return r14 = lexerCommand();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r12.add(r14.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        r5.tree = null;     // Catch: Throwable -> L7 RecognitionException -> L9
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L7 RecognitionException -> L9
        if (r12.hasNext() == false) goto L18;
    L14:
        if (r12.hasNext() == false) goto L16;
        this.adaptor.addChild(r15, r12.nextTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L14
    L16:
        r12.reset();     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r15;     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r16 = (GrammarAST) this.adaptor.rulePostProcessing(r15);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r16;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.setTokenBoundaries(r16, r5.start, r5.stop);     // Catch: Throwable -> L7 RecognitionException -> L9
    L21:
        return r5;
    L18:
        throw new RewriteEarlyExitException();     // Catch: Throwable -> L7 RecognitionException -> L9
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r17 = this.adaptor;
        TokenStream r18 = this.input;
        r5.tree = (GrammarAST) r17.errorNode(r18, r5.start, r18.LT(-1), e);
    L7:
        th = move-exception;
        throw th;
    }

    public final lexerElement_return lexerElement() throws RecognitionException {
        lexerElement_return r5 = new lexerElement_return();
        r5.start = this.input.LT(1);
        RewriteRuleSubtreeStream r10 = new RewriteRuleSubtreeStream(this.adaptor, "rule labeledLexerElement");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerBlock");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule ebnfSuffix");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerAtom");
        this.paraphrases.push("looking for lexer rule element");
        this.input.mark();
        int r14 = this.input.LA(1);     // Catch: Throwable -> L57 RecognitionException -> L59
        if (r14 == 4) goto L103;
        if (r14 == 20) goto L102;
        if (r14 == 32) goto L102;
        if (r14 == 34) goto L101;
        if (r14 == 39) goto L102;
        if (r14 != 57) goto L13;
        int r15 = this.input.LA(2);     // Catch: Throwable -> L57 RecognitionException -> L59
        if (r15 != 10) goto L67;
    L61:
        char r16 = 1;
    L105:
        if (r16 != 1) goto L107;
        pushFollow(FOLLOW_labeledLexerElement_in_lexerElement2365);     // Catch: Throwable -> L57 RecognitionException -> L59
        labeledLexerElement_return r17 = labeledLexerElement();     // Catch: Throwable -> L57 RecognitionException -> L59
        this.state._fsp--;     // Catch: Throwable -> L57 RecognitionException -> L59
        r10.add(r17.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        int r18 = this.input.LA(1);     // Catch: Throwable -> L57 RecognitionException -> L59
        if (r18 != 45) goto L190;
    L217:
        char r19 = 1;
    L218:
        if (r19 != 1) goto L220;
        pushFollow(FOLLOW_ebnfSuffix_in_lexerElement2371);     // Catch: Throwable -> L57 RecognitionException -> L59
        ebnfSuffix_return r20 = ebnfSuffix();     // Catch: Throwable -> L57 RecognitionException -> L59
        this.state._fsp--;     // Catch: Throwable -> L57 RecognitionException -> L59
        r12.add(r20.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        r5.tree = null;     // Catch: Throwable -> L57 RecognitionException -> L59
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        GrammarAST r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L57 RecognitionException -> L59
        GrammarAST r21 = (GrammarAST) this.adaptor.becomeRoot(r12.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L57 RecognitionException -> L59
        GrammarAST r22 = (GrammarAST) this.adaptor.becomeRoot(new BlockAST(78, r17.start, "BLOCK"), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L57 RecognitionException -> L59
        GrammarAST r23 = (GrammarAST) this.adaptor.becomeRoot(new AltAST(74), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r23, r10.nextTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r22, r23);     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r21, r22);     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r110, r21);     // Catch: Throwable -> L57 RecognitionException -> L59
        r5.tree = r110;     // Catch: Throwable -> L57 RecognitionException -> L59
    L224:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L57 RecognitionException -> L59
        GrammarAST r24 = (GrammarAST) this.adaptor.rulePostProcessing(r110);     // Catch: Throwable -> L57 RecognitionException -> L59
        r5.tree = r24;     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.setTokenBoundaries(r24, r5.start, r5.stop);     // Catch: Throwable -> L57 RecognitionException -> L59
        this.paraphrases.pop();     // Catch: Throwable -> L57 RecognitionException -> L59
    L241:
        return r5;
    L220:
        if (r19 != 2) goto L111;
        r5.tree = null;     // Catch: Throwable -> L57 RecognitionException -> L59
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r110, r10.nextTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        r5.tree = r110;     // Catch: Throwable -> L57 RecognitionException -> L59
    L111:
        r110 = null;
        goto L224
    L190:
        if (r18 == 51) goto L217;
        if (r18 == 61) goto L217;
        if (r18 == 4) goto L215;
        if (r18 == 20) goto L215;
        if (r18 == 32) goto L215;
        if (r18 == 34) goto L215;
        if (r18 == 39) goto L215;
        if (r18 == 43) goto L215;
        if (r18 == 53) goto L215;
        if (r18 < 56) goto L209;
        if (r18 <= 59) goto L215;
    L209:
        if (r18 == 62) goto L215;
        if (r18 == 66) goto L215;
        throw new NoViableAltException("", 35, 0, this.input);     // Catch: Throwable -> L57 RecognitionException -> L59
    L215:
        r19 = 2;
        goto L218
    L107:
        if (r16 != 2) goto L109;
        pushFollow(FOLLOW_lexerAtom_in_lexerElement2417);     // Catch: Throwable -> L57 RecognitionException -> L59
        lexerAtom_return r25 = lexerAtom();     // Catch: Throwable -> L57 RecognitionException -> L59
        this.state._fsp--;     // Catch: Throwable -> L57 RecognitionException -> L59
        r13.add(r25.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        int r26 = this.input.LA(1);     // Catch: Throwable -> L57 RecognitionException -> L59
        if (r26 != 45) goto L153;
    L180:
        char r27 = 1;
    L181:
        if (r27 != 1) goto L183;
        pushFollow(FOLLOW_ebnfSuffix_in_lexerElement2423);     // Catch: Throwable -> L57 RecognitionException -> L59
        ebnfSuffix_return r28 = ebnfSuffix();     // Catch: Throwable -> L57 RecognitionException -> L59
        this.state._fsp--;     // Catch: Throwable -> L57 RecognitionException -> L59
        r12.add(r28.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        r5.tree = null;     // Catch: Throwable -> L57 RecognitionException -> L59
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L57 RecognitionException -> L59
        GrammarAST r29 = (GrammarAST) this.adaptor.becomeRoot(r12.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L57 RecognitionException -> L59
        GrammarAST r30 = (GrammarAST) this.adaptor.becomeRoot(new BlockAST(78, r25.start, "BLOCK"), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L57 RecognitionException -> L59
        GrammarAST r31 = (GrammarAST) this.adaptor.becomeRoot(new AltAST(74), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r31, r13.nextTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r30, r31);     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r29, r30);     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r110, r29);     // Catch: Throwable -> L57 RecognitionException -> L59
        r5.tree = r110;     // Catch: Throwable -> L57 RecognitionException -> L59
        goto L224
    L183:
        if (r27 != 2) goto L111;
        r5.tree = null;     // Catch: Throwable -> L57 RecognitionException -> L59
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r110, r13.nextTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        r5.tree = r110;     // Catch: Throwable -> L57 RecognitionException -> L59
        goto L224
    L153:
        if (r26 == 51) goto L180;
        if (r26 == 61) goto L180;
        if (r26 == 4) goto L178;
        if (r26 == 20) goto L178;
        if (r26 == 32) goto L178;
        if (r26 == 34) goto L178;
        if (r26 == 39) goto L178;
        if (r26 == 43) goto L178;
        if (r26 == 53) goto L178;
        if (r26 < 56) goto L172;
        if (r26 <= 59) goto L178;
    L172:
        if (r26 == 62) goto L178;
        if (r26 == 66) goto L178;
        throw new NoViableAltException("", 36, 0, this.input);     // Catch: Throwable -> L57 RecognitionException -> L59
    L178:
        r27 = 2;
        goto L181
    L109:
        if (r16 == 3) goto L113;
        if (r16 != 4) goto L111;
        r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L57 RecognitionException -> L59
        pushFollow(FOLLOW_actionElement_in_lexerElement2503);     // Catch: Throwable -> L57 RecognitionException -> L59
        actionElement_return r32 = actionElement();     // Catch: Throwable -> L57 RecognitionException -> L59
        this.state._fsp--;     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r110, r32.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        goto L224
    L113:
        pushFollow(FOLLOW_lexerBlock_in_lexerElement2469);     // Catch: Throwable -> L57 RecognitionException -> L59
        lexerBlock_return r33 = lexerBlock();     // Catch: Throwable -> L57 RecognitionException -> L59
        this.state._fsp--;     // Catch: Throwable -> L57 RecognitionException -> L59
        r11.add(r33.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        int r34 = this.input.LA(1);     // Catch: Throwable -> L57 RecognitionException -> L59
        if (r34 != 45) goto L116;
    L143:
        char r35 = 1;
    L144:
        if (r35 != 1) goto L146;
        pushFollow(FOLLOW_ebnfSuffix_in_lexerElement2475);     // Catch: Throwable -> L57 RecognitionException -> L59
        ebnfSuffix_return r36 = ebnfSuffix();     // Catch: Throwable -> L57 RecognitionException -> L59
        this.state._fsp--;     // Catch: Throwable -> L57 RecognitionException -> L59
        r12.add(r36.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        r5.tree = null;     // Catch: Throwable -> L57 RecognitionException -> L59
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L57 RecognitionException -> L59
        GrammarAST r37 = (GrammarAST) this.adaptor.becomeRoot(r12.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r37, r11.nextTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r110, r37);     // Catch: Throwable -> L57 RecognitionException -> L59
        r5.tree = r110;     // Catch: Throwable -> L57 RecognitionException -> L59
        goto L224
    L146:
        if (r35 != 2) goto L111;
        r5.tree = null;     // Catch: Throwable -> L57 RecognitionException -> L59
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        r110 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L57 RecognitionException -> L59
        this.adaptor.addChild(r110, r11.nextTree());     // Catch: Throwable -> L57 RecognitionException -> L59
        r5.tree = r110;     // Catch: Throwable -> L57 RecognitionException -> L59
        goto L224
    L116:
        if (r34 == 51) goto L143;
        if (r34 == 61) goto L143;
        if (r34 == 4) goto L141;
        if (r34 == 20) goto L141;
        if (r34 == 32) goto L141;
        if (r34 == 34) goto L141;
        if (r34 == 39) goto L141;
        if (r34 == 43) goto L141;
        if (r34 == 53) goto L141;
        if (r34 < 56) goto L135;
        if (r34 <= 59) goto L141;
    L135:
        if (r34 == 62) goto L141;
        if (r34 == 66) goto L141;
        throw new NoViableAltException("", 37, 0, this.input);     // Catch: Throwable -> L57 RecognitionException -> L59
    L141:
        r35 = 2;
        goto L144
    L67:
        if (r15 == 46) goto L61;
        if (r15 == 4) goto L102;
        if (r15 == 20) goto L102;
        if (r15 == 32) goto L102;
        if (r15 == 34) goto L102;
        if (r15 == 39) goto L102;
        if (r15 == 43) goto L102;
        if (r15 == 45) goto L102;
        if (r15 == 51) goto L102;
        if (r15 == 53) goto L102;
        if (r15 < 56) goto L88;
        if (r15 <= 59) goto L102;
    L88:
        if (r15 < 61) goto L92;
        if (r15 <= 62) goto L102;
    L92:
        if (r15 == 66) goto L102;
        int r38 = this.input.mark();     // Catch: Throwable -> L57 RecognitionException -> L59
        this.input.consume();     // Catch: Throwable -> L97
        throw new NoViableAltException("", 38, 1, this.input);     // Catch: Throwable -> L97
    L97:
        th = move-exception;
        this.input.rewind(r38);     // Catch: Throwable -> L57 RecognitionException -> L59
        throw th;     // Catch: Throwable -> L57 RecognitionException -> L59
    L13:
        if (r14 == 59) goto L103;
        if (r14 == 62) goto L102;
        if (r14 != 66) goto L63;
        int r39 = this.input.LA(2);     // Catch: Throwable -> L57 RecognitionException -> L59
        if (r39 == 10) goto L61;
        if (r39 == 46) goto L61;
        if (r39 == 4) goto L102;
        if (r39 == 20) goto L102;
        if (r39 == 32) goto L102;
        if (r39 < 34) goto L30;
        if (r39 <= 35) goto L102;
    L30:
        if (r39 == 39) goto L102;
        if (r39 == 43) goto L102;
        if (r39 == 45) goto L102;
        if (r39 == 51) goto L102;
        if (r39 == 53) goto L102;
        if (r39 < 56) goto L44;
        if (r39 <= 59) goto L102;
    L44:
        if (r39 < 61) goto L48;
        if (r39 <= 62) goto L102;
    L48:
        if (r39 == 66) goto L102;
        int r40 = this.input.mark();     // Catch: Throwable -> L57 RecognitionException -> L59
        this.input.consume();     // Catch: Throwable -> L53
        throw new NoViableAltException("", 38, 2, this.input);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        this.input.rewind(r40);     // Catch: Throwable -> L57 RecognitionException -> L59
        throw th;     // Catch: Throwable -> L57 RecognitionException -> L59
    L63:
        throw new NoViableAltException("", 38, 0, this.input);     // Catch: Throwable -> L57 RecognitionException -> L59
    L101:
        r16 = 3;
    L102:
        r16 = 2;
    L103:
        r16 = 4;
    L59:
        e = move-exception;
        TreeAdaptor r41 = this.adaptor;
        TokenStream r42 = this.input;
        r5.tree = (GrammarAST) r41.errorNode(r42, r5.start, r42.LT(-1), e);
        TokenStream r43 = this.input;
        int r44 = r43.get(r43.range()).getType();
        if (r44 != 14) goto L230;
    L242:
        reportError(new v4ParserException("unterminated rule (missing ';') detected at '" + this.input.LT(1).getText() + " " + this.input.LT(2).getText() + "'", this.input));
        if (r44 != (-1)) goto L245;
        TokenStream r45 = this.input;
        r45.seek(r45.index() + 1);
    L262:
        throw new ResyncToEndOfRuleBlock();
    L245:
        if (r44 != 12) goto L247;
    L259:
        TokenStream r46 = this.input;
        r46.seek(r46.range());
        goto L262
    L247:
        if (r44 == 23) goto L259;
        if (r44 != 55) goto L251;
    L252:
        int r47 = this.input.index();
        Token r48 = this.input.get(r47);
    L254:
        if (r48.getType() == 57) goto L258;
        if (r48.getType() == 66) goto L258;
        r47 = r47 - 1;
        r48 = this.input.get(r47);
    L258:
        this.input.seek(r47);
        goto L262
    L251:
        if (r44 != 11) goto L262;
    L230:
        if (r44 == 55) goto L242;
        if (r44 == 12) goto L242;
        if (r44 == 23) goto L242;
        if (r44 == 11) goto L242;
        if (r44 == (-1)) goto L242;
        reportError(e);
        recover(this.input, e);
    L57:
        th = move-exception;
        throw th;
    }

    public final lexerElements_return lexerElements() throws RecognitionException {
        lexerElements_return r5 = new lexerElements_return();
        r5.start = this.input.LT(1);
        RewriteRuleSubtreeStream r10 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerElement");
        int r11 = this.input.LA(1);     // Catch: Throwable -> L25 RecognitionException -> L27
        int r12 = 34;
        if (r11 == 4) goto L30;
        if (r11 == 20) goto L30;
        if (r11 == 32) goto L30;
        if (r11 == 34) goto L30;
        if (r11 == 39) goto L30;
        if (r11 == 57) goto L30;
        if (r11 == 59) goto L30;
        if (r11 == 62) goto L30;
        if (r11 == 66) goto L30;
        if (r11 != 43) goto L17;
    L29:
        char r13 = 2;
    L31:
        int r14 = 74;
        GrammarAST r15 = null;
        if (r13 == 1) goto L36;
        if (r13 != 2) goto L57;
        r5.tree = null;     // Catch: Throwable -> L25 RecognitionException -> L27
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L25 RecognitionException -> L27
        r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L25 RecognitionException -> L27
        GrammarAST r16 = (GrammarAST) this.adaptor.becomeRoot(new AltAST(74), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L25 RecognitionException -> L27
        TreeAdaptor r17 = this.adaptor;     // Catch: Throwable -> L25 RecognitionException -> L27
        r17.addChild(r16, (GrammarAST) r17.create(83, "EPSILON"));     // Catch: Throwable -> L25 RecognitionException -> L27
        this.adaptor.addChild(r15, r16);     // Catch: Throwable -> L25 RecognitionException -> L27
        r5.tree = r15;     // Catch: Throwable -> L25 RecognitionException -> L27
    L57:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L25 RecognitionException -> L27
        GrammarAST r18 = (GrammarAST) this.adaptor.rulePostProcessing(r15);     // Catch: Throwable -> L25 RecognitionException -> L27
        r5.tree = r18;     // Catch: Throwable -> L25 RecognitionException -> L27
        this.adaptor.setTokenBoundaries(r18, r5.start, r5.stop);     // Catch: Throwable -> L25 RecognitionException -> L27
    L67:
        return r5;
    L36:
        int r19 = 0;
    L37:
        int r20 = this.input.LA(1);     // Catch: Throwable -> L25 RecognitionException -> L27
        if (r20 == 4) goto L63;
        if (r20 == 20) goto L63;
        if (r20 == 32) goto L63;
        if (r20 == r12) goto L63;
        if (r20 == 39) goto L63;
        if (r20 == 57) goto L63;
        if (r20 == 59) goto L63;
        if (r20 == 62) goto L63;
        if (r20 == 66) goto L63;
        if (r19 < 1) goto L61;
        r5.tree = null;     // Catch: Throwable -> L25 RecognitionException -> L27
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L25 RecognitionException -> L27
        r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L25 RecognitionException -> L27
        GrammarAST r21 = (GrammarAST) this.adaptor.becomeRoot(new AltAST(r14), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L25 RecognitionException -> L27
        if (r10.hasNext() == false) goto L59;
    L54:
        if (r10.hasNext() == false) goto L56;
        this.adaptor.addChild(r21, r10.nextTree());     // Catch: Throwable -> L25 RecognitionException -> L27
        goto L54
    L56:
        r10.reset();     // Catch: Throwable -> L25 RecognitionException -> L27
        this.adaptor.addChild(r15, r21);     // Catch: Throwable -> L25 RecognitionException -> L27
        r5.tree = r15;     // Catch: Throwable -> L25 RecognitionException -> L27
        goto L57
    L59:
        throw new RewriteEarlyExitException();     // Catch: Throwable -> L25 RecognitionException -> L27
    L61:
        throw new EarlyExitException(33, this.input);     // Catch: Throwable -> L25 RecognitionException -> L27
    L63:
        pushFollow(FOLLOW_lexerElement_in_lexerElements2309);     // Catch: Throwable -> L25 RecognitionException -> L27
        lexerElement_return r22 = lexerElement();     // Catch: Throwable -> L25 RecognitionException -> L27
        this.state._fsp--;     // Catch: Throwable -> L25 RecognitionException -> L27
        r10.add(r22.getTree());     // Catch: Throwable -> L25 RecognitionException -> L27
        r19 = r19 + 1;
        r12 = 34;
        r14 = 74;
        goto L37
    L17:
        if (r11 == 53) goto L29;
        if (r11 == 56) goto L29;
        if (r11 == 58) goto L29;
        throw new NoViableAltException("", 34, 0, this.input);     // Catch: Throwable -> L25 RecognitionException -> L27
    L30:
        r13 = 1;
    L27:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r23 = this.adaptor;
        TokenStream r24 = this.input;
        r5.tree = (GrammarAST) r23.errorNode(r24, r5.start, r24.LT(-1), e);
    L25:
        th = move-exception;
        throw th;
    }

    public final lexerRule_return lexerRule() throws RecognitionException {
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
            Method dump skipped, instruction units count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.jarjarred.org.antlr.v4.parse.ANTLRParser.lexerRule():androidx.room.jarjarred.org.antlr.v4.parse.ANTLRParser$lexerRule_return");
    }

    public final lexerRuleBlock_return lexerRuleBlock() throws RecognitionException {
        lexerRuleBlock_return r5 = new lexerRuleBlock_return();
        r5.start = this.input.LT(1);
        RewriteRuleSubtreeStream r10 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerAltList");
        Token r11 = this.input.LT(-1);
        pushFollow(FOLLOW_lexerAltList_in_lexerRuleBlock2201);     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        lexerAltList_return r12 = lexerAltList();     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        r10.add(r12.getTree());     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        r5.tree = null;     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        GrammarAST r13 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        GrammarAST r14 = (GrammarAST) this.adaptor.becomeRoot(new BlockAST(78, r11, "BLOCK"), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        this.adaptor.addChild(r14, r10.nextTree());     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        this.adaptor.addChild(r13, r14);     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        r5.tree = r13;     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        GrammarAST r15 = (GrammarAST) this.adaptor.rulePostProcessing(r13);     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        r5.tree = r15;     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        this.adaptor.setTokenBoundaries(r15, r5.start, r5.stop);     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
    L8:
        return r5;
    L7:
        TreeAdaptor r16 = this.adaptor;
        TokenStream r17 = this.input;
        r5.tree = (GrammarAST) r16.errorNode(r17, r5.start, r17.LT(-1), null);
    L5:
        th = move-exception;
        throw th;
    }

    public final localsSpec_return localsSpec() throws RecognitionException {
        localsSpec_return r5 = new localsSpec_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        Token r11 = (Token) match(this.input, 33, FOLLOW_LOCALS_in_localsSpec1957);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r12 = (GrammarAST) this.adaptor.create(r11);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r13 = (GrammarAST) this.adaptor.becomeRoot(r12, r10);     // Catch: Throwable -> L5 RecognitionException -> L7
        ActionAST r14 = new ActionAST((Token) match(this.input, 8, FOLLOW_ARG_ACTION_in_localsSpec1960));     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r13, r14);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r15 = (GrammarAST) this.adaptor.rulePostProcessing(r13);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r15;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.setTokenBoundaries(r15, r5.start, r5.stop);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r16 = this.adaptor;
        TokenStream r17 = this.input;
        r5.tree = (GrammarAST) r16.errorNode(r17, r5.start, r17.LT(-1), e);
    L5:
        th = move-exception;
        throw th;
    }

    public final modeSpec_return modeSpec() throws RecognitionException {
        modeSpec_return r5 = new modeSpec_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token MODE");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token SEMI");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule lexerRule");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule id");
        RewriteRuleSubtreeStream r14 = new RewriteRuleSubtreeStream(this.adaptor, "rule sync");
        r10.add((Token) match(this.input, 36, FOLLOW_MODE_in_modeSpec1367));     // Catch: Throwable -> L13 RecognitionException -> L15
        pushFollow(FOLLOW_id_in_modeSpec1369);     // Catch: Throwable -> L13 RecognitionException -> L15
        id_return r15 = id();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        r13.add(r15.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        r11.add((Token) match(this.input, 58, FOLLOW_SEMI_in_modeSpec1371));     // Catch: Throwable -> L13 RecognitionException -> L15
        pushFollow(FOLLOW_sync_in_modeSpec1373);     // Catch: Throwable -> L13 RecognitionException -> L15
        sync_return r16 = sync();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        r14.add(r16.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
    L4:
        int r17 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r17 == 24) goto L18;
        if (r17 == 66) goto L18;
        r5.tree = null;     // Catch: Throwable -> L13 RecognitionException -> L15
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r18 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r19 = (GrammarAST) this.adaptor.becomeRoot(r10.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L13 RecognitionException -> L15
        this.adaptor.addChild(r19, r13.nextTree());     // Catch: Throwable -> L13 RecognitionException -> L15
    L11:
        if (r12.hasNext() == false) goto L17;
        this.adaptor.addChild(r19, r12.nextTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L11
    L17:
        r12.reset();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.adaptor.addChild(r18, r19);     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = r18;     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r20 = (GrammarAST) this.adaptor.rulePostProcessing(r18);     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = r20;     // Catch: Throwable -> L13 RecognitionException -> L15
        this.adaptor.setTokenBoundaries(r20, r5.start, r5.stop);     // Catch: Throwable -> L13 RecognitionException -> L15
    L22:
        return r5;
    L18:
        pushFollow(FOLLOW_lexerRule_in_modeSpec1376);     // Catch: Throwable -> L13 RecognitionException -> L15
        lexerRule_return r21 = lexerRule();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        r12.add(r21.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        pushFollow(FOLLOW_sync_in_modeSpec1378);     // Catch: Throwable -> L13 RecognitionException -> L15
        sync_return r22 = sync();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        r14.add(r22.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
    L15:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r23 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r23.errorNode(r110, r5.start, r110.LT(-1), e);
    L13:
        th = move-exception;
        throw th;
    }

    public final notSet_return notSet() throws RecognitionException {
        notSet_return r5 = new notSet_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token NOT");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule blockSet");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule setElement");
    L24:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r13 = this.adaptor;
        TokenStream r14 = this.input;
        r5.tree = (GrammarAST) r13.errorNode(r14, r5.start, r14.LT(-1), e);
    L38:
        return r5;
    L22:
        th = move-exception;
        throw th;
    L5:
        if (this.input.LA(1) != 39) goto L35;
        int r15 = this.input.LA(2);     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r15 != 32) goto L9;
    L26:
        char r16 = 1;
    L27:
        GrammarAST r17 = null;
        if (r16 == 1) goto L32;
        if (r16 != 2) goto L33;
        Token r18 = (Token) match(this.input, 39, FOLLOW_NOT_in_notSet3635);     // Catch: Throwable -> L22 RecognitionException -> L24
        r10.add(r18);     // Catch: Throwable -> L22 RecognitionException -> L24
        pushFollow(FOLLOW_blockSet_in_notSet3637);     // Catch: Throwable -> L22 RecognitionException -> L24
        blockSet_return r19 = blockSet();     // Catch: Throwable -> L22 RecognitionException -> L24
        this.state._fsp--;     // Catch: Throwable -> L22 RecognitionException -> L24
        r11.add(r19.getTree());     // Catch: Throwable -> L22 RecognitionException -> L24
        r5.tree = null;     // Catch: Throwable -> L22 RecognitionException -> L24
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L22 RecognitionException -> L24
        r17 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r20 = (GrammarAST) this.adaptor.becomeRoot(new NotAST(39, r18), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L22 RecognitionException -> L24
        this.adaptor.addChild(r20, r11.nextTree());     // Catch: Throwable -> L22 RecognitionException -> L24
        this.adaptor.addChild(r17, r20);     // Catch: Throwable -> L22 RecognitionException -> L24
        r5.tree = r17;     // Catch: Throwable -> L22 RecognitionException -> L24
    L33:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r21 = (GrammarAST) this.adaptor.rulePostProcessing(r17);     // Catch: Throwable -> L22 RecognitionException -> L24
        r5.tree = r21;     // Catch: Throwable -> L22 RecognitionException -> L24
        this.adaptor.setTokenBoundaries(r21, r5.start, r5.stop);     // Catch: Throwable -> L22 RecognitionException -> L24
        goto L38
    L32:
        Token r22 = (Token) match(this.input, 39, FOLLOW_NOT_in_notSet3605);     // Catch: Throwable -> L22 RecognitionException -> L24
        r10.add(r22);     // Catch: Throwable -> L22 RecognitionException -> L24
        pushFollow(FOLLOW_setElement_in_notSet3607);     // Catch: Throwable -> L22 RecognitionException -> L24
        setElement_return r23 = setElement();     // Catch: Throwable -> L22 RecognitionException -> L24
        this.state._fsp--;     // Catch: Throwable -> L22 RecognitionException -> L24
        r12.add(r23.getTree());     // Catch: Throwable -> L22 RecognitionException -> L24
        r5.tree = null;     // Catch: Throwable -> L22 RecognitionException -> L24
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L22 RecognitionException -> L24
        r17 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r24 = (GrammarAST) this.adaptor.becomeRoot(new NotAST(39, r22), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r25 = (GrammarAST) this.adaptor.becomeRoot(new SetAST(98, r23.start, "SET"), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L22 RecognitionException -> L24
        this.adaptor.addChild(r25, r12.nextTree());     // Catch: Throwable -> L22 RecognitionException -> L24
        this.adaptor.addChild(r24, r25);     // Catch: Throwable -> L22 RecognitionException -> L24
        this.adaptor.addChild(r17, r24);     // Catch: Throwable -> L22 RecognitionException -> L24
        r5.tree = r17;     // Catch: Throwable -> L22 RecognitionException -> L24
        goto L33
    L9:
        if (r15 == 62) goto L26;
        if (r15 == 66) goto L26;
        if (r15 != 34) goto L16;
        r16 = 2;
        goto L27
    L16:
        int r26 = this.input.mark();     // Catch: Throwable -> L22 RecognitionException -> L24
        this.input.consume();     // Catch: Throwable -> L19
        throw new NoViableAltException("", 64, 1, this.input);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.input.rewind(r26);     // Catch: Throwable -> L22 RecognitionException -> L24
        throw th;     // Catch: Throwable -> L22 RecognitionException -> L24
    L35:
        throw new NoViableAltException("", 64, 0, this.input);     // Catch: Throwable -> L22 RecognitionException -> L24
    }

    public final option_return option() throws RecognitionException {
        option_return r5 = new option_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        pushFollow(FOLLOW_id_in_option955);     // Catch: Throwable -> L5 RecognitionException -> L7
        id_return r11 = id();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r10, r11.getTree());     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r12 = (GrammarAST) this.adaptor.becomeRoot((GrammarAST) this.adaptor.create((Token) match(this.input, 10, FOLLOW_ASSIGN_in_option957)), r10);     // Catch: Throwable -> L5 RecognitionException -> L7
        pushFollow(FOLLOW_optionValue_in_option960);     // Catch: Throwable -> L5 RecognitionException -> L7
        optionValue_return r13 = optionValue();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r12, r13.getTree());     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r14 = (GrammarAST) this.adaptor.rulePostProcessing(r12);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r14;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.setTokenBoundaries(r14, r5.start, r5.stop);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r15 = this.adaptor;
        TokenStream r16 = this.input;
        r5.tree = (GrammarAST) r15.errorNode(r16, r5.start, r16.LT(-1), e);
    L5:
        th = move-exception;
        throw th;
    }

    public final optionValue_return optionValue() throws RecognitionException {
        optionValue_return r5 = new optionValue_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r10 == 4) goto L21;
        if (r10 != 30) goto L7;
        char r11 = 4;
    L22:
        if (r11 == 1) goto L30;
        if (r11 == 2) goto L29;
        if (r11 == 3) goto L28;
        if (r11 == 4) goto L27;
        GrammarAST r12 = null;
    L31:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r13 = (GrammarAST) this.adaptor.rulePostProcessing(r12);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r13;     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.setTokenBoundaries(r13, r5.start, r5.stop);     // Catch: Throwable -> L14 RecognitionException -> L16
    L35:
        return r5;
    L27:
        r12 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r12, (GrammarAST) this.adaptor.create((Token) match(this.input, 30, FOLLOW_INT_in_optionValue1027)));     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L31
    L28:
        r12 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r12, new ActionAST((Token) match(this.input, 4, FOLLOW_ACTION_in_optionValue1016)));     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L31
    L29:
        r12 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r12, (GrammarAST) this.adaptor.create((Token) match(this.input, 62, FOLLOW_STRING_LITERAL_in_optionValue1011)));     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L31
    L30:
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_qid_in_optionValue1003);     // Catch: Throwable -> L14 RecognitionException -> L16
        qid_return r15 = qid();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.state._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r14, r15.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r12 = r14;
        goto L31
    L7:
        if (r10 == 57) goto L19;
        if (r10 != 62) goto L10;
        r11 = 2;
        goto L22
    L10:
        if (r10 == 66) goto L19;
        throw new NoViableAltException("", 6, 0, this.input);     // Catch: Throwable -> L14 RecognitionException -> L16
    L19:
        r11 = 1;
        goto L22
    L21:
        r11 = 3;
    L16:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r16 = this.adaptor;
        TokenStream r17 = this.input;
        r5.tree = (GrammarAST) r16.errorNode(r17, r5.start, r17.LT(-1), e);
    L14:
        th = move-exception;
        throw th;
    }

    public final optionsSpec_return optionsSpec() throws RecognitionException {
        optionsSpec_return r5 = new optionsSpec_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token RBRACE");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token SEMI");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token OPTIONS");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule option");
        Token r14 = (Token) match(this.input, 42, FOLLOW_OPTIONS_in_optionsSpec917);     // Catch: Throwable -> L13 RecognitionException -> L15
        r12.add(r14);     // Catch: Throwable -> L13 RecognitionException -> L15
    L4:
        int r15 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r15 == 57) goto L18;
        if (r15 == 66) goto L18;
        r10.add((Token) match(this.input, 54, FOLLOW_RBRACE_in_optionsSpec926));     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = null;     // Catch: Throwable -> L13 RecognitionException -> L15
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r16 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r17 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L13 RecognitionException -> L15
        TreeAdaptor r18 = this.adaptor;     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r19 = (GrammarAST) r18.becomeRoot((GrammarAST) r18.create(42, r14, "OPTIONS"), r17);     // Catch: Throwable -> L13 RecognitionException -> L15
    L11:
        if (r13.hasNext() == false) goto L17;
        this.adaptor.addChild(r19, r13.nextTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L11
    L17:
        r13.reset();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.adaptor.addChild(r16, r19);     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = r16;     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r20 = (GrammarAST) this.adaptor.rulePostProcessing(r16);     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = r20;     // Catch: Throwable -> L13 RecognitionException -> L15
        this.adaptor.setTokenBoundaries(r20, r5.start, r5.stop);     // Catch: Throwable -> L13 RecognitionException -> L15
    L22:
        return r5;
    L18:
        pushFollow(FOLLOW_option_in_optionsSpec920);     // Catch: Throwable -> L13 RecognitionException -> L15
        option_return r21 = option();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        r13.add(r21.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        r11.add((Token) match(this.input, 58, FOLLOW_SEMI_in_optionsSpec922));     // Catch: Throwable -> L13 RecognitionException -> L15
    L15:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r22 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r22.errorNode(r110, r5.start, r110.LT(-1), e);
    L13:
        th = move-exception;
        throw th;
    }

    public final parserRule_return parserRule() throws RecognitionException {
        parserRule_return r5 = new parserRule_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token ARG_ACTION");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token SEMI");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token COLON");
        RewriteRuleTokenStream r13 = new RewriteRuleTokenStream(this.adaptor, "token RULE_REF");
        RewriteRuleSubtreeStream r14 = new RewriteRuleSubtreeStream(this.adaptor, "rule throwsSpec");
        RewriteRuleSubtreeStream r15 = new RewriteRuleSubtreeStream(this.adaptor, "rule localsSpec");
        RewriteRuleSubtreeStream r16 = new RewriteRuleSubtreeStream(this.adaptor, "rule ruleBlock");
        RewriteRuleSubtreeStream r17 = new RewriteRuleSubtreeStream(this.adaptor, "rule ruleReturns");
        RewriteRuleSubtreeStream r18 = new RewriteRuleSubtreeStream(this.adaptor, "rule rulePrequels");
        RewriteRuleSubtreeStream r19 = new RewriteRuleSubtreeStream(this.adaptor, "rule exceptionGroup");
        this.paraphrases.push("matching a rule");
        r13.add((Token) match(this.input, 57, FOLLOW_RULE_REF_in_parserRule1530));     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this.input.LA(1) != 8) goto L11;
        r10.add((Token) match(this.input, 8, FOLLOW_ARG_ACTION_in_parserRule1560));     // Catch: Throwable -> L6 RecognitionException -> L8
    L11:
        if (this.input.LA(1) != 55) goto L14;
        pushFollow(FOLLOW_ruleReturns_in_parserRule1567);     // Catch: Throwable -> L6 RecognitionException -> L8
        ruleReturns_return r110 = ruleReturns();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r17.add(r110.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L14:
        if (this.input.LA(1) != 64) goto L17;
        pushFollow(FOLLOW_throwsSpec_in_parserRule1574);     // Catch: Throwable -> L6 RecognitionException -> L8
        throwsSpec_return r111 = throwsSpec();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r14.add(r111.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L17:
        if (this.input.LA(1) != 33) goto L19;
        pushFollow(FOLLOW_localsSpec_in_parserRule1581);     // Catch: Throwable -> L6 RecognitionException -> L8
        localsSpec_return r112 = localsSpec();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r15.add(r112.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L19:
        pushFollow(FOLLOW_rulePrequels_in_parserRule1619);     // Catch: Throwable -> L6 RecognitionException -> L8
        rulePrequels_return r113 = rulePrequels();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r18.add(r113.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        r12.add((Token) match(this.input, 14, FOLLOW_COLON_in_parserRule1628));     // Catch: Throwable -> L6 RecognitionException -> L8
        pushFollow(FOLLOW_ruleBlock_in_parserRule1651);     // Catch: Throwable -> L6 RecognitionException -> L8
        ruleBlock_return r20 = ruleBlock();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r16.add(r20.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        r11.add((Token) match(this.input, 58, FOLLOW_SEMI_in_parserRule1660));     // Catch: Throwable -> L6 RecognitionException -> L8
        pushFollow(FOLLOW_exceptionGroup_in_parserRule1669);     // Catch: Throwable -> L6 RecognitionException -> L8
        exceptionGroup_return r21 = exceptionGroup();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r19.add(r21.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.tree = null;     // Catch: Throwable -> L6 RecognitionException -> L8
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r22 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r23 = (GrammarAST) this.adaptor.becomeRoot(new RuleAST(94), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L6 RecognitionException -> L8
        this.adaptor.addChild(r23, r13.nextNode());     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r10.hasNext() == false) goto L22;
        this.adaptor.addChild(r23, new ActionAST(r10.nextToken()));     // Catch: Throwable -> L6 RecognitionException -> L8
    L22:
        r10.reset();     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r17.hasNext() == false) goto L25;
        this.adaptor.addChild(r23, r17.nextTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L25:
        r17.reset();     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r14.hasNext() == false) goto L28;
        this.adaptor.addChild(r23, r14.nextTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L28:
        r14.reset();     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r15.hasNext() == false) goto L31;
        this.adaptor.addChild(r23, r15.nextTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L31:
        r15.reset();     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r18.hasNext() == false) goto L34;
        this.adaptor.addChild(r23, r18.nextTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L34:
        r18.reset();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.adaptor.addChild(r23, r16.nextTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L36:
        if (r19.hasNext() == false) goto L38;
        this.adaptor.addChild(r23, r19.nextTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        goto L36
    L38:
        r19.reset();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.adaptor.addChild(r22, r23);     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.tree = r22;     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r24 = (GrammarAST) this.adaptor.rulePostProcessing(r22);     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.tree = r24;     // Catch: Throwable -> L6 RecognitionException -> L8
        this.adaptor.setTokenBoundaries(r24, r5.start, r5.stop);     // Catch: Throwable -> L6 RecognitionException -> L8
        this.paraphrases.pop();     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r25 = (GrammarAST) r5.tree.getFirstChildWithType(42);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r25 == null) goto L44;
        Grammar.setNodeOptions(r5.tree, r25);     // Catch: Throwable -> L6 RecognitionException -> L8
    L44:
        return r5;
    L8:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r26 = this.adaptor;
        TokenStream r27 = this.input;
        r5.tree = (GrammarAST) r26.errorNode(r27, r5.start, r27.LT(-1), e);
    L6:
        th = move-exception;
        throw th;
    }

    public final prequelConstruct_return prequelConstruct() throws RecognitionException {
        prequelConstruct_return r5 = new prequelConstruct_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r10 != 11) goto L6;
        char r11 = 5;
    L24:
        if (r11 == 1) goto L35;
        if (r11 == 2) goto L34;
        if (r11 == 3) goto L33;
        if (r11 == 4) goto L32;
        if (r11 == 5) goto L30;
        GrammarAST r12 = null;
    L36:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L16 RecognitionException -> L18
        GrammarAST r13 = (GrammarAST) this.adaptor.rulePostProcessing(r12);     // Catch: Throwable -> L16 RecognitionException -> L18
        r5.tree = r13;     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.setTokenBoundaries(r13, r5.start, r5.stop);     // Catch: Throwable -> L16 RecognitionException -> L18
    L40:
        return r5;
    L30:
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        pushFollow(FOLLOW_action_in_prequelConstruct902);     // Catch: Throwable -> L16 RecognitionException -> L18
        action_return r15 = action();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r14, r15.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
    L31:
        r12 = r14;
        goto L36
    L32:
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        pushFollow(FOLLOW_channelsSpec_in_prequelConstruct865);     // Catch: Throwable -> L16 RecognitionException -> L18
        channelsSpec_return r16 = channelsSpec();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r14, r16.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L31
    L33:
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        pushFollow(FOLLOW_tokensSpec_in_prequelConstruct855);     // Catch: Throwable -> L16 RecognitionException -> L18
        tokensSpec_return r17 = tokensSpec();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r14, r17.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L31
    L34:
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        pushFollow(FOLLOW_delegateGrammars_in_prequelConstruct811);     // Catch: Throwable -> L16 RecognitionException -> L18
        delegateGrammars_return r18 = delegateGrammars();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r14, r18.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L31
    L35:
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        pushFollow(FOLLOW_optionsSpec_in_prequelConstruct788);     // Catch: Throwable -> L16 RecognitionException -> L18
        optionsSpec_return r19 = optionsSpec();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r14, r19.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L31
    L6:
        if (r10 != 13) goto L8;
        r11 = 4;
        goto L24
    L8:
        if (r10 != 29) goto L10;
        r11 = 2;
        goto L24
    L10:
        if (r10 != 42) goto L12;
        r11 = 1;
        goto L24
    L12:
        if (r10 != 65) goto L15;
        r11 = 3;
        goto L24
    L15:
        throw new NoViableAltException("", 4, 0, this.input);     // Catch: Throwable -> L16 RecognitionException -> L18
    L18:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r20 = this.adaptor;
        TokenStream r21 = this.input;
        r5.tree = (GrammarAST) r20.errorNode(r21, r5.start, r21.LT(-1), e);
    L16:
        th = move-exception;
        throw th;
    }

    public final qid_return qid() throws RecognitionException {
        qid_return r5 = new qid_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token DOT");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule id");
        this.paraphrases.push("looking for a qualified identifier");
        pushFollow(FOLLOW_id_in_qid4161);     // Catch: Throwable -> L7 RecognitionException -> L9
        id_return r12 = id();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r11.add(r12.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
    L5:
        if (this.input.LA(1) != 20) goto L11;
        r10.add((Token) match(this.input, 20, FOLLOW_DOT_in_qid4164));     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_id_in_qid4166);     // Catch: Throwable -> L7 RecognitionException -> L9
        id_return r13 = id();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r11.add(r13.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        r5.tree = null;     // Catch: Throwable -> L7 RecognitionException -> L9
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L7 RecognitionException -> L9
        TreeAdaptor r15 = this.adaptor;     // Catch: Throwable -> L7 RecognitionException -> L9
        Token r16 = r5.start;     // Catch: Throwable -> L7 RecognitionException -> L9
        TokenStream r17 = this.input;     // Catch: Throwable -> L7 RecognitionException -> L9
        r15.addChild(r14, (GrammarAST) r15.create(28, r16, r17.toString(r16, r17.LT(-1))));     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r14;     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r18 = (GrammarAST) this.adaptor.rulePostProcessing(r14);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r18;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.setTokenBoundaries(r18, r5.start, r5.stop);     // Catch: Throwable -> L7 RecognitionException -> L9
        this.paraphrases.pop();     // Catch: Throwable -> L7 RecognitionException -> L9
    L15:
        return r5;
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r19 = this.adaptor;
        TokenStream r20 = this.input;
        r5.tree = (GrammarAST) r19.errorNode(r20, r5.start, r20.LT(-1), e);
    L7:
        th = move-exception;
        throw th;
    }

    public final range_return range() throws RecognitionException {
        range_return r5 = new range_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        TerminalAST r11 = new TerminalAST((Token) match(this.input, 62, FOLLOW_STRING_LITERAL_in_range3923));     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r10, r11);     // Catch: Throwable -> L5 RecognitionException -> L7
        RangeAST r12 = new RangeAST((Token) match(this.input, 52, FOLLOW_RANGE_in_range3928));     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r13 = (GrammarAST) this.adaptor.becomeRoot(r12, r10);     // Catch: Throwable -> L5 RecognitionException -> L7
        TerminalAST r14 = new TerminalAST((Token) match(this.input, 62, FOLLOW_STRING_LITERAL_in_range3934));     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r13, r14);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r15 = (GrammarAST) this.adaptor.rulePostProcessing(r13);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r15;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.setTokenBoundaries(r15, r5.start, r5.stop);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r16 = this.adaptor;
        TokenStream r17 = this.input;
        r5.tree = (GrammarAST) r16.errorNode(r17, r5.start, r17.LT(-1), e);
    L5:
        th = move-exception;
        throw th;
    }

    public final rule_return rule() throws RecognitionException {
        rule_return r5 = new rule_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r10 != 57) goto L7;
        char r11 = 1;
    L18:
        if (r11 == 1) goto L23;
        if (r11 == 2) goto L21;
        GrammarAST r12 = null;
    L24:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r13 = (GrammarAST) this.adaptor.rulePostProcessing(r12);     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = r13;     // Catch: Throwable -> L13 RecognitionException -> L15
        this.adaptor.setTokenBoundaries(r13, r5.start, r5.stop);     // Catch: Throwable -> L13 RecognitionException -> L15
    L28:
        return r5;
    L21:
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L13 RecognitionException -> L15
        pushFollow(FOLLOW_lexerRule_in_rule1481);     // Catch: Throwable -> L13 RecognitionException -> L15
        lexerRule_return r15 = lexerRule();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        this.adaptor.addChild(r14, r15.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
    L22:
        r12 = r14;
        goto L24
    L23:
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L13 RecognitionException -> L15
        pushFollow(FOLLOW_parserRule_in_rule1476);     // Catch: Throwable -> L13 RecognitionException -> L15
        parserRule_return r16 = parserRule();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        this.adaptor.addChild(r14, r16.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L22
    L7:
        if (r10 != 24) goto L9;
    L17:
        r11 = 2;
        goto L18
    L9:
        if (r10 == 66) goto L17;
        throw new NoViableAltException("", 18, 0, this.input);     // Catch: Throwable -> L13 RecognitionException -> L15
    L15:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r17 = this.adaptor;
        TokenStream r18 = this.input;
        r5.tree = (GrammarAST) r17.errorNode(r18, r5.start, r18.LT(-1), e);
    L13:
        th = move-exception;
        throw th;
    }

    public final ruleAction_return ruleAction() throws RecognitionException {
        ruleAction_return r5 = new ruleAction_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token AT");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token ACTION");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule id");
        r10.add((Token) match(this.input, 11, FOLLOW_AT_in_ruleAction1983));     // Catch: Throwable -> L5 RecognitionException -> L7
        pushFollow(FOLLOW_id_in_ruleAction1985);     // Catch: Throwable -> L5 RecognitionException -> L7
        id_return r13 = id();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        r12.add(r13.getTree());     // Catch: Throwable -> L5 RecognitionException -> L7
        r11.add((Token) match(this.input, 4, FOLLOW_ACTION_in_ruleAction1987));     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = null;     // Catch: Throwable -> L5 RecognitionException -> L7
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r15 = (GrammarAST) this.adaptor.becomeRoot(r10.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r15, r12.nextTree());     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r15, new ActionAST(r11.nextToken()));     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r14, r15);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r14;     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r16 = (GrammarAST) this.adaptor.rulePostProcessing(r14);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r16;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.setTokenBoundaries(r16, r5.start, r5.stop);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r17 = this.adaptor;
        TokenStream r18 = this.input;
        r5.tree = (GrammarAST) r17.errorNode(r18, r5.start, r18.LT(-1), e);
    L5:
        th = move-exception;
        throw th;
    }

    public final ruleAltList_return ruleAltList() throws RecognitionException {
        ruleAltList_return r5 = new ruleAltList_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token OR");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule labeledAlt");
        pushFollow(FOLLOW_labeledAlt_in_ruleAltList2061);     // Catch: Throwable -> L7 RecognitionException -> L9
        labeledAlt_return r12 = labeledAlt();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r11.add(r12.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
    L5:
        if (this.input.LA(1) != 43) goto L11;
        r10.add((Token) match(this.input, 43, FOLLOW_OR_in_ruleAltList2064));     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_labeledAlt_in_ruleAltList2066);     // Catch: Throwable -> L7 RecognitionException -> L9
        labeledAlt_return r13 = labeledAlt();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r11.add(r13.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        r5.tree = null;     // Catch: Throwable -> L7 RecognitionException -> L9
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L7 RecognitionException -> L9
        if (r11.hasNext() == false) goto L18;
    L14:
        if (r11.hasNext() == false) goto L16;
        this.adaptor.addChild(r14, r11.nextTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L14
    L16:
        r11.reset();     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r14;     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r15 = (GrammarAST) this.adaptor.rulePostProcessing(r14);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r15;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.setTokenBoundaries(r15, r5.start, r5.stop);     // Catch: Throwable -> L7 RecognitionException -> L9
    L21:
        return r5;
    L18:
        throw new RewriteEarlyExitException();     // Catch: Throwable -> L7 RecognitionException -> L9
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r16 = this.adaptor;
        TokenStream r17 = this.input;
        r5.tree = (GrammarAST) r16.errorNode(r17, r5.start, r17.LT(-1), e);
    L7:
        th = move-exception;
        throw th;
    }

    public final ruleBlock_return ruleBlock() throws RecognitionException {
        ruleBlock_return r5 = new ruleBlock_return();
        r5.start = this.input.LT(1);
        RewriteRuleSubtreeStream r10 = new RewriteRuleSubtreeStream(this.adaptor, "rule ruleAltList");
        Token r11 = this.input.LT(-1);
        pushFollow(FOLLOW_ruleAltList_in_ruleBlock2025);     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        ruleAltList_return r12 = ruleAltList();     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        r10.add(r12.getTree());     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        r5.tree = null;     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        GrammarAST r13 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        GrammarAST r14 = (GrammarAST) this.adaptor.becomeRoot(new BlockAST(78, r11, "BLOCK"), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        this.adaptor.addChild(r14, r10.nextTree());     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        this.adaptor.addChild(r13, r14);     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        r5.tree = r13;     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        GrammarAST r15 = (GrammarAST) this.adaptor.rulePostProcessing(r13);     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        r5.tree = r15;     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
        this.adaptor.setTokenBoundaries(r15, r5.start, r5.stop);     // Catch: Throwable -> L5 ResyncToEndOfRuleBlock -> L7
    L8:
        return r5;
    L7:
        TreeAdaptor r16 = this.adaptor;
        TokenStream r17 = this.input;
        r5.tree = (GrammarAST) r16.errorNode(r17, r5.start, r17.LT(-1), null);
    L5:
        th = move-exception;
        throw th;
    }

    public final ruleEntry_return ruleEntry() throws RecognitionException {
        ruleEntry_return r5 = new ruleEntry_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        pushFollow(FOLLOW_rule_in_ruleEntry4204);     // Catch: Throwable -> L5 RecognitionException -> L7
        rule_return r11 = rule();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r10, r11.getTree());     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r10, (GrammarAST) this.adaptor.create((Token) match(this.input, -1, FOLLOW_EOF_in_ruleEntry4206)));     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r12 = (GrammarAST) this.adaptor.rulePostProcessing(r10);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r12;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.setTokenBoundaries(r12, r5.start, r5.stop);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r13 = this.adaptor;
        TokenStream r14 = this.input;
        r5.tree = (GrammarAST) r13.errorNode(r14, r5.start, r14.LT(-1), e);
    L5:
        th = move-exception;
        throw th;
    }

    public final rulePrequel_return rulePrequel() throws RecognitionException {
        rulePrequel_return r5 = new rulePrequel_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r10 != 42) goto L7;
        char r11 = 1;
    L9:
        if (r11 == 1) goto L18;
        if (r11 == 2) goto L12;
        GrammarAST r12 = null;
    L19:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r13 = (GrammarAST) this.adaptor.rulePostProcessing(r12);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r13;     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.setTokenBoundaries(r13, r5.start, r5.stop);     // Catch: Throwable -> L14 RecognitionException -> L16
    L24:
        return r5;
    L12:
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_ruleAction_in_rulePrequel1874);     // Catch: Throwable -> L14 RecognitionException -> L16
        ruleAction_return r15 = ruleAction();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.state._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r14, r15.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
    L13:
        r12 = r14;
        goto L19
    L18:
        r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_optionsSpec_in_rulePrequel1866);     // Catch: Throwable -> L14 RecognitionException -> L16
        optionsSpec_return r16 = optionsSpec();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.state._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r14, r16.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L13
    L7:
        if (r10 != 11) goto L21;
        r11 = 2;
        goto L9
    L21:
        throw new NoViableAltException("", 26, 0, this.input);     // Catch: Throwable -> L14 RecognitionException -> L16
    L16:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r17 = this.adaptor;
        TokenStream r18 = this.input;
        r5.tree = (GrammarAST) r17.errorNode(r18, r5.start, r18.LT(-1), e);
    L14:
        th = move-exception;
        throw th;
    }

    public final rulePrequels_return rulePrequels() throws RecognitionException {
        rulePrequels_return r5 = new rulePrequels_return();
        r5.start = this.input.LT(1);
        RewriteRuleSubtreeStream r10 = new RewriteRuleSubtreeStream(this.adaptor, "rule sync");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule rulePrequel");
        this.paraphrases.push("matching rule preamble");
        pushFollow(FOLLOW_sync_in_rulePrequels1837);     // Catch: Throwable -> L13 RecognitionException -> L15
        sync_return r12 = sync();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        r10.add(r12.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
    L4:
        int r13 = this.input.LA(1);     // Catch: Throwable -> L13 RecognitionException -> L15
        if (r13 == 11) goto L18;
        if (r13 == 42) goto L18;
        r5.tree = null;     // Catch: Throwable -> L13 RecognitionException -> L15
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L13 RecognitionException -> L15
    L11:
        if (r11.hasNext() == false) goto L17;
        this.adaptor.addChild(r14, r11.nextTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        goto L11
    L17:
        r11.reset();     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = r14;     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L13 RecognitionException -> L15
        GrammarAST r15 = (GrammarAST) this.adaptor.rulePostProcessing(r14);     // Catch: Throwable -> L13 RecognitionException -> L15
        r5.tree = r15;     // Catch: Throwable -> L13 RecognitionException -> L15
        this.adaptor.setTokenBoundaries(r15, r5.start, r5.stop);     // Catch: Throwable -> L13 RecognitionException -> L15
        this.paraphrases.pop();     // Catch: Throwable -> L13 RecognitionException -> L15
    L22:
        return r5;
    L18:
        pushFollow(FOLLOW_rulePrequel_in_rulePrequels1840);     // Catch: Throwable -> L13 RecognitionException -> L15
        rulePrequel_return r16 = rulePrequel();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        r11.add(r16.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
        pushFollow(FOLLOW_sync_in_rulePrequels1842);     // Catch: Throwable -> L13 RecognitionException -> L15
        sync_return r17 = sync();     // Catch: Throwable -> L13 RecognitionException -> L15
        this.state._fsp--;     // Catch: Throwable -> L13 RecognitionException -> L15
        r10.add(r17.getTree());     // Catch: Throwable -> L13 RecognitionException -> L15
    L15:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r18 = this.adaptor;
        TokenStream r19 = this.input;
        r5.tree = (GrammarAST) r18.errorNode(r19, r5.start, r19.LT(-1), e);
    L13:
        th = move-exception;
        throw th;
    }

    public final ruleReturns_return ruleReturns() throws RecognitionException {
        ruleReturns_return r5 = new ruleReturns_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L5 RecognitionException -> L7
        Token r11 = (Token) match(this.input, 55, FOLLOW_RETURNS_in_ruleReturns1894);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r12 = (GrammarAST) this.adaptor.create(r11);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r13 = (GrammarAST) this.adaptor.becomeRoot(r12, r10);     // Catch: Throwable -> L5 RecognitionException -> L7
        ActionAST r14 = new ActionAST((Token) match(this.input, 8, FOLLOW_ARG_ACTION_in_ruleReturns1897));     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.addChild(r13, r14);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L5 RecognitionException -> L7
        GrammarAST r15 = (GrammarAST) this.adaptor.rulePostProcessing(r13);     // Catch: Throwable -> L5 RecognitionException -> L7
        r5.tree = r15;     // Catch: Throwable -> L5 RecognitionException -> L7
        this.adaptor.setTokenBoundaries(r15, r5.start, r5.stop);     // Catch: Throwable -> L5 RecognitionException -> L7
    L11:
        return r5;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r16 = this.adaptor;
        TokenStream r17 = this.input;
        r5.tree = (GrammarAST) r16.errorNode(r17, r5.start, r17.LT(-1), e);
    L5:
        th = move-exception;
        throw th;
    }

    public final ruleref_return ruleref() throws RecognitionException {
        ruleref_return r5 = new ruleref_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token ARG_ACTION");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token RULE_REF");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule elementOptions");
        r11.add((Token) match(this.input, 57, FOLLOW_RULE_REF_in_ruleref3862));
        if (this.input.LA(1) != 8) goto L6;
        r10.add((Token) match(this.input, 8, FOLLOW_ARG_ACTION_in_ruleref3864));
    L6:
        if (this.input.LA(1) != 35) goto L8;
        pushFollow(FOLLOW_elementOptions_in_ruleref3867);
        elementOptions_return r13 = elementOptions();
        this.state._fsp--;
        r12.add(r13.getTree());
    L8:
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();
        GrammarAST r15 = (GrammarAST) this.adaptor.becomeRoot(new RuleRefAST(r11.nextToken()), (GrammarAST) this.adaptor.nil());
        if (r10.hasNext() == false) goto L11;
        this.adaptor.addChild(r15, new ActionAST(r10.nextToken()));
    L11:
        r10.reset();
        if (r12.hasNext() == false) goto L14;
        this.adaptor.addChild(r15, r12.nextTree());
    L14:
        r12.reset();
        this.adaptor.addChild(r14, r15);
        r5.tree = r14;
        r5.stop = this.input.LT(-1);
        GrammarAST r16 = (GrammarAST) this.adaptor.rulePostProcessing(r14);
        r5.tree = r16;
        this.adaptor.setTokenBoundaries(r16, r5.start, r5.stop);
        GrammarAST r17 = (GrammarAST) r5.tree.getFirstChildWithType(82);
        if (r17 == null) goto L17;
        Grammar.setNodeOptions(r5.tree, r17);
    L17:
        return r5;
    }

    public final rules_return rules() throws RecognitionException {
        rules_return r5 = new rules_return();
        r5.start = this.input.LT(1);
        RewriteRuleSubtreeStream r10 = new RewriteRuleSubtreeStream(this.adaptor, "rule rule");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule sync");
        pushFollow(FOLLOW_sync_in_rules1409);     // Catch: Throwable -> L15 RecognitionException -> L17
        sync_return r12 = sync();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        r11.add(r12.getTree());     // Catch: Throwable -> L15 RecognitionException -> L17
    L4:
        int r13 = this.input.LA(1);     // Catch: Throwable -> L15 RecognitionException -> L17
        if (r13 == 24) goto L20;
        if (r13 == 57) goto L20;
        if (r13 == 66) goto L20;
        r5.tree = null;     // Catch: Throwable -> L15 RecognitionException -> L17
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L15 RecognitionException -> L17
        GrammarAST r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L15 RecognitionException -> L17
        TreeAdaptor r16 = this.adaptor;     // Catch: Throwable -> L15 RecognitionException -> L17
        GrammarAST r17 = (GrammarAST) r16.becomeRoot((GrammarAST) r16.create(97, "RULES"), r15);     // Catch: Throwable -> L15 RecognitionException -> L17
    L13:
        if (r10.hasNext() == false) goto L19;
        this.adaptor.addChild(r17, r10.nextTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        goto L13
    L19:
        r10.reset();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.adaptor.addChild(r14, r17);     // Catch: Throwable -> L15 RecognitionException -> L17
        r5.tree = r14;     // Catch: Throwable -> L15 RecognitionException -> L17
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L15 RecognitionException -> L17
        GrammarAST r18 = (GrammarAST) this.adaptor.rulePostProcessing(r14);     // Catch: Throwable -> L15 RecognitionException -> L17
        r5.tree = r18;     // Catch: Throwable -> L15 RecognitionException -> L17
        this.adaptor.setTokenBoundaries(r18, r5.start, r5.stop);     // Catch: Throwable -> L15 RecognitionException -> L17
    L24:
        return r5;
    L20:
        pushFollow(FOLLOW_rule_in_rules1412);     // Catch: Throwable -> L15 RecognitionException -> L17
        rule_return r19 = rule();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        r10.add(r19.getTree());     // Catch: Throwable -> L15 RecognitionException -> L17
        pushFollow(FOLLOW_sync_in_rules1414);     // Catch: Throwable -> L15 RecognitionException -> L17
        sync_return r20 = sync();     // Catch: Throwable -> L15 RecognitionException -> L17
        this.state._fsp--;     // Catch: Throwable -> L15 RecognitionException -> L17
        r11.add(r20.getTree());     // Catch: Throwable -> L15 RecognitionException -> L17
    L17:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r21 = this.adaptor;
        TokenStream r22 = this.input;
        r5.tree = (GrammarAST) r21.errorNode(r22, r5.start, r22.LT(-1), e);
    L15:
        th = move-exception;
        throw th;
    }

    public final setElement_return setElement() throws RecognitionException {
        setElement_return r5 = new setElement_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r10 != 32) goto L7;
        char r11 = 4;
    L56:
        if (r11 == 1) goto L67;
        if (r11 == 2) goto L64;
        if (r11 == 3) goto L62;
        if (r11 == 4) goto L61;
        GrammarAST r12 = null;
    L70:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L12 RecognitionException -> L14
        GrammarAST r13 = (GrammarAST) this.adaptor.rulePostProcessing(r12);     // Catch: Throwable -> L12 RecognitionException -> L14
        r5.tree = r13;     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.setTokenBoundaries(r13, r5.start, r5.stop);     // Catch: Throwable -> L12 RecognitionException -> L14
    L74:
        return r5;
    L61:
        r12 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.addChild(r12, (GrammarAST) this.adaptor.create((Token) match(this.input, 32, FOLLOW_LEXER_CHAR_SET_in_setElement3747)));     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L70
    L62:
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_range_in_setElement3737);     // Catch: Throwable -> L12 RecognitionException -> L14
        range_return r15 = range();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.addChild(r14, r15.getTree());     // Catch: Throwable -> L12 RecognitionException -> L14
    L63:
        r12 = r14;
        goto L70
    L64:
        GrammarAST r16 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L12 RecognitionException -> L14
        r14 = (GrammarAST) this.adaptor.becomeRoot(new TerminalAST((Token) match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement3725)), r16);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (this.input.LA(1) != 35) goto L63;
        pushFollow(FOLLOW_elementOptions_in_setElement3731);     // Catch: Throwable -> L12 RecognitionException -> L14
        elementOptions_return r17 = elementOptions();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.addChild(r14, r17.getTree());     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L63
    L67:
        GrammarAST r18 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L12 RecognitionException -> L14
        r14 = (GrammarAST) this.adaptor.becomeRoot(new TerminalAST((Token) match(this.input, 66, FOLLOW_TOKEN_REF_in_setElement3713)), r18);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (this.input.LA(1) != 35) goto L63;
        pushFollow(FOLLOW_elementOptions_in_setElement3719);     // Catch: Throwable -> L12 RecognitionException -> L14
        elementOptions_return r19 = elementOptions();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        this.adaptor.addChild(r14, r19.getTree());     // Catch: Throwable -> L12 RecognitionException -> L14
        goto L63
    L7:
        if (r10 == 62) goto L16;
        if (r10 != 66) goto L11;
        r11 = 1;
        goto L56
    L11:
        throw new NoViableAltException("", 68, 0, this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
    L16:
        int r20 = this.input.LA(2);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r20 != 52) goto L19;
        r11 = 3;
        goto L56
    L19:
        if (r20 == (-1)) goto L54;
        if (r20 == 4) goto L54;
        if (r20 == 20) goto L54;
        if (r20 == 32) goto L54;
        if (r20 < 34) goto L28;
        if (r20 <= 35) goto L54;
    L28:
        if (r20 == 39) goto L54;
        if (r20 == 43) goto L54;
        if (r20 == 45) goto L54;
        if (r20 == 47) goto L54;
        if (r20 == 51) goto L54;
        if (r20 == 53) goto L54;
        if (r20 < 56) goto L44;
        if (r20 <= 59) goto L54;
    L44:
        if (r20 < 61) goto L46;
        if (r20 <= 62) goto L54;
    L46:
        if (r20 == 66) goto L54;
        int r21 = this.input.mark();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.input.consume();     // Catch: Throwable -> L51
        throw new NoViableAltException("", 68, 2, this.input);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        this.input.rewind(r21);     // Catch: Throwable -> L12 RecognitionException -> L14
        throw th;     // Catch: Throwable -> L12 RecognitionException -> L14
    L54:
        r11 = 2;
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r22 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r22.errorNode(r110, r5.start, r110.LT(-1), e);
    L12:
        th = move-exception;
        throw th;
    }

    public void setTreeAdaptor(TreeAdaptor r5) {
        this.adaptor = r5;
    }

    public final sync_return sync() throws RecognitionException {
        sync_return r5 = new sync_return();
        r5.start = this.input.LT(1);
        BitSet r10 = computeErrorRecoverySet();
        if (this.input.LA(1) != (-1)) goto L5;
    L7:
        GrammarAST r11 = (GrammarAST) this.adaptor.nil();
        r5.stop = this.input.LT(-1);
        GrammarAST r12 = (GrammarAST) this.adaptor.rulePostProcessing(r11);
        r5.tree = r12;
        this.adaptor.setTokenBoundaries(r12, r5.start, r5.stop);
        return r5;
    L5:
        if (r10.member(this.input.LA(1)) == true) goto L7;
        reportError(new NoViableAltException("", 0, 0, this.input));
        beginResync();
        consumeUntil(this.input, r10);
        endResync();
        goto L7
    }

    public final terminal_return terminal() throws RecognitionException {
        terminal_return r5 = new terminal_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token TOKEN_REF");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token STRING_LITERAL");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule elementOptions");
        int r13 = this.input.LA(1);     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r13 != 66) goto L7;
        char r14 = 1;
    L9:
        GrammarAST r15 = null;
        if (r14 == 1) goto L24;
        if (r14 != 2) goto L31;
        r11.add((Token) match(this.input, 62, FOLLOW_STRING_LITERAL_in_terminal3981));     // Catch: Throwable -> L16 RecognitionException -> L18
        if (this.input.LA(1) != 35) goto L20;
        pushFollow(FOLLOW_elementOptions_in_terminal3983);     // Catch: Throwable -> L16 RecognitionException -> L18
        elementOptions_return r16 = elementOptions();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        r12.add(r16.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
    L20:
        r5.tree = null;     // Catch: Throwable -> L16 RecognitionException -> L18
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
        r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        GrammarAST r17 = (GrammarAST) this.adaptor.becomeRoot(new TerminalAST(r11.nextToken()), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r12.hasNext() == false) goto L23;
        this.adaptor.addChild(r17, r12.nextTree());     // Catch: Throwable -> L16 RecognitionException -> L18
    L23:
        r12.reset();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r15, r17);     // Catch: Throwable -> L16 RecognitionException -> L18
        r5.tree = r15;     // Catch: Throwable -> L16 RecognitionException -> L18
    L31:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L16 RecognitionException -> L18
        GrammarAST r18 = (GrammarAST) this.adaptor.rulePostProcessing(r15);     // Catch: Throwable -> L16 RecognitionException -> L18
        r5.tree = r18;     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.setTokenBoundaries(r18, r5.start, r5.stop);     // Catch: Throwable -> L16 RecognitionException -> L18
        GrammarAST r19 = (GrammarAST) r5.tree.getFirstChildWithType(82);     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r19 == null) goto L38;
        Grammar.setNodeOptions(r5.tree, r19);     // Catch: Throwable -> L16 RecognitionException -> L18
    L38:
        return r5;
    L24:
        r10.add((Token) match(this.input, 66, FOLLOW_TOKEN_REF_in_terminal3958));     // Catch: Throwable -> L16 RecognitionException -> L18
        if (this.input.LA(1) != 35) goto L27;
        pushFollow(FOLLOW_elementOptions_in_terminal3960);     // Catch: Throwable -> L16 RecognitionException -> L18
        elementOptions_return r20 = elementOptions();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        r12.add(r20.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
    L27:
        r5.tree = null;     // Catch: Throwable -> L16 RecognitionException -> L18
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L16 RecognitionException -> L18
        r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L16 RecognitionException -> L18
        GrammarAST r21 = (GrammarAST) this.adaptor.becomeRoot(new TerminalAST(r10.nextToken()), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r12.hasNext() == false) goto L30;
        this.adaptor.addChild(r21, r12.nextTree());     // Catch: Throwable -> L16 RecognitionException -> L18
    L30:
        r12.reset();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.adaptor.addChild(r15, r21);     // Catch: Throwable -> L16 RecognitionException -> L18
        r5.tree = r15;     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L31
    L7:
        if (r13 != 62) goto L35;
        r14 = 2;
        goto L9
    L35:
        throw new NoViableAltException("", 76, 0, this.input);     // Catch: Throwable -> L16 RecognitionException -> L18
    L18:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r22 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r22.errorNode(r110, r5.start, r110.LT(-1), e);
    L16:
        th = move-exception;
        throw th;
    }

    public final throwsSpec_return throwsSpec() throws RecognitionException {
        throwsSpec_return r5 = new throwsSpec_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token COMMA");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token THROWS");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule qid");
        r11.add((Token) match(this.input, 64, FOLLOW_THROWS_in_throwsSpec1925));     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_qid_in_throwsSpec1927);     // Catch: Throwable -> L7 RecognitionException -> L9
        qid_return r13 = qid();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r12.add(r13.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
    L5:
        if (this.input.LA(1) != 16) goto L11;
        r10.add((Token) match(this.input, 16, FOLLOW_COMMA_in_throwsSpec1930));     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_qid_in_throwsSpec1932);     // Catch: Throwable -> L7 RecognitionException -> L9
        qid_return r14 = qid();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        r12.add(r14.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        r5.tree = null;     // Catch: Throwable -> L7 RecognitionException -> L9
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r15 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r16 = (GrammarAST) this.adaptor.becomeRoot(r11.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L7 RecognitionException -> L9
        if (r12.hasNext() == false) goto L18;
    L14:
        if (r12.hasNext() == false) goto L16;
        this.adaptor.addChild(r16, r12.nextTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L14
    L16:
        r12.reset();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.addChild(r15, r16);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r15;     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L7 RecognitionException -> L9
        GrammarAST r17 = (GrammarAST) this.adaptor.rulePostProcessing(r15);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r17;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.setTokenBoundaries(r17, r5.start, r5.stop);     // Catch: Throwable -> L7 RecognitionException -> L9
    L21:
        return r5;
    L18:
        throw new RewriteEarlyExitException();     // Catch: Throwable -> L7 RecognitionException -> L9
    L9:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r18 = this.adaptor;
        TokenStream r19 = this.input;
        r5.tree = (GrammarAST) r18.errorNode(r19, r5.start, r19.LT(-1), e);
    L7:
        th = move-exception;
        throw th;
    }

    public final tokensSpec_return tokensSpec() throws RecognitionException {
        tokensSpec_return r5 = new tokensSpec_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token COMMA");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token RBRACE");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token TOKENS_SPEC");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule id");
    L30:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r14 = this.adaptor;
        TokenStream r15 = this.input;
        r5.tree = (GrammarAST) r14.errorNode(r15, r5.start, r15.LT(-1), e);
    L91:
        return r5;
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.input.LA(1) != 65) goto L88;
        int r16 = this.input.LA(2);     // Catch: Throwable -> L28 RecognitionException -> L30
        if (r16 != 54) goto L9;
        char r17 = 2;
    L58:
        GrammarAST r18 = null;
        if (r17 == 1) goto L74;
        if (r17 == 2) goto L73;
        if (r17 != 3) goto L84;
        GrammarAST r19 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L28 RecognitionException -> L30
        Token r20 = (Token) match(this.input, 65, FOLLOW_TOKENS_SPEC_in_tokensSpec1150);     // Catch: Throwable -> L28 RecognitionException -> L30
        r18 = (GrammarAST) this.adaptor.becomeRoot((GrammarAST) this.adaptor.create(r20), r19);     // Catch: Throwable -> L28 RecognitionException -> L30
        int r21 = 0;
    L64:
        int r22 = this.input.LA(1);     // Catch: Throwable -> L28 RecognitionException -> L30
        if (r22 == 57) goto L72;
        if (r22 == 66) goto L72;
        if (r21 < 1) goto L71;
        Token r23 = (Token) match(this.input, 54, FOLLOW_RBRACE_in_tokensSpec1156);     // Catch: Throwable -> L28 RecognitionException -> L30
        grammarError(ErrorType.V3_TOKENS_SYNTAX, r20, new Object[0]);     // Catch: Throwable -> L28 RecognitionException -> L30
        goto L84
    L71:
        throw new EarlyExitException(10, this.input);     // Catch: Throwable -> L28 RecognitionException -> L30
    L72:
        pushFollow(FOLLOW_v3tokenSpec_in_tokensSpec1153);     // Catch: Throwable -> L28 RecognitionException -> L30
        v3tokenSpec_return r24 = v3tokenSpec();     // Catch: Throwable -> L28 RecognitionException -> L30
        this.state._fsp--;     // Catch: Throwable -> L28 RecognitionException -> L30
        this.adaptor.addChild(r18, r24.getTree());     // Catch: Throwable -> L28 RecognitionException -> L30
        r21 = r21 + 1;     // Catch: Throwable -> L28 RecognitionException -> L30
    L84:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L28 RecognitionException -> L30
        GrammarAST r25 = (GrammarAST) this.adaptor.rulePostProcessing(r18);     // Catch: Throwable -> L28 RecognitionException -> L30
        r5.tree = r25;     // Catch: Throwable -> L28 RecognitionException -> L30
        this.adaptor.setTokenBoundaries(r25, r5.start, r5.stop);     // Catch: Throwable -> L28 RecognitionException -> L30
        goto L91
    L73:
        r12.add((Token) match(this.input, 65, FOLLOW_TOKENS_SPEC_in_tokensSpec1138));     // Catch: Throwable -> L28 RecognitionException -> L30
        r11.add((Token) match(this.input, 54, FOLLOW_RBRACE_in_tokensSpec1140));     // Catch: Throwable -> L28 RecognitionException -> L30
        r5.tree = null;     // Catch: Throwable -> L28 RecognitionException -> L30
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L28 RecognitionException -> L30
        GrammarAST r26 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L28 RecognitionException -> L30
        r5.tree = null;     // Catch: Throwable -> L28 RecognitionException -> L30
        goto L84
    L74:
        r12.add((Token) match(this.input, 65, FOLLOW_TOKENS_SPEC_in_tokensSpec1110));     // Catch: Throwable -> L28 RecognitionException -> L30
        pushFollow(FOLLOW_id_in_tokensSpec1112);     // Catch: Throwable -> L28 RecognitionException -> L30
        id_return r27 = id();     // Catch: Throwable -> L28 RecognitionException -> L30
        int r110 = 1;
        this.state._fsp--;     // Catch: Throwable -> L28 RecognitionException -> L30
        r13.add(r27.getTree());     // Catch: Throwable -> L28 RecognitionException -> L30
    L76:
        if (this.input.LA(r110) != 16) goto L78;
        r10.add((Token) match(this.input, 16, FOLLOW_COMMA_in_tokensSpec1115));     // Catch: Throwable -> L28 RecognitionException -> L30
        pushFollow(FOLLOW_id_in_tokensSpec1117);     // Catch: Throwable -> L28 RecognitionException -> L30
        id_return r28 = id();     // Catch: Throwable -> L28 RecognitionException -> L30
        this.state._fsp--;     // Catch: Throwable -> L28 RecognitionException -> L30
        r13.add(r28.getTree());     // Catch: Throwable -> L28 RecognitionException -> L30
        r110 = 1;
        goto L76
    L78:
        r11.add((Token) match(this.input, 54, FOLLOW_RBRACE_in_tokensSpec1121));     // Catch: Throwable -> L28 RecognitionException -> L30
        r5.tree = null;     // Catch: Throwable -> L28 RecognitionException -> L30
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L28 RecognitionException -> L30
        r18 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L28 RecognitionException -> L30
        GrammarAST r29 = (GrammarAST) this.adaptor.becomeRoot(r12.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L28 RecognitionException -> L30
        if (r13.hasNext() == false) goto L86;
    L81:
        if (r13.hasNext() == false) goto L83;
        this.adaptor.addChild(r29, r13.nextTree());     // Catch: Throwable -> L28 RecognitionException -> L30
        goto L81
    L83:
        r13.reset();     // Catch: Throwable -> L28 RecognitionException -> L30
        this.adaptor.addChild(r18, r29);     // Catch: Throwable -> L28 RecognitionException -> L30
        r5.tree = r18;     // Catch: Throwable -> L28 RecognitionException -> L30
        goto L84
    L86:
        throw new RewriteEarlyExitException();     // Catch: Throwable -> L28 RecognitionException -> L30
    L9:
        if (r16 == 57) goto L40;
        if (r16 != 66) goto L34;
        int r30 = this.input.LA(3);     // Catch: Throwable -> L28 RecognitionException -> L30
        if (r30 == 16) goto L33;
        if (r30 == 54) goto L33;
        if (r30 == 10) goto L32;
        if (r30 == 58) goto L32;
        int r31 = this.input.mark();     // Catch: Throwable -> L28 RecognitionException -> L30
        int r111 = 0;
    L20:
        if (r111 >= 2) goto L25;
        this.input.consume();     // Catch: Throwable -> L22
        r111 = r111 + 1;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        this.input.rewind(r31);     // Catch: Throwable -> L28 RecognitionException -> L30
        throw th;     // Catch: Throwable -> L28 RecognitionException -> L30
    L25:
        throw new NoViableAltException("", 11, 4, this.input);     // Catch: Throwable -> L22
    L32:
        r17 = 3;
    L33:
        r17 = 1;
        goto L58
    L34:
        int r32 = this.input.mark();     // Catch: Throwable -> L28 RecognitionException -> L30
        this.input.consume();     // Catch: Throwable -> L37
        throw new NoViableAltException("", 11, 1, this.input);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        this.input.rewind(r32);     // Catch: Throwable -> L28 RecognitionException -> L30
        throw th;     // Catch: Throwable -> L28 RecognitionException -> L30
    L40:
        int r33 = this.input.LA(3);     // Catch: Throwable -> L28 RecognitionException -> L30
        if (r33 == 16) goto L33;
        if (r33 == 54) goto L33;
        if (r33 == 10) goto L32;
        if (r33 == 58) goto L32;
        int r34 = this.input.mark();     // Catch: Throwable -> L28 RecognitionException -> L30
        int r112 = 0;
    L49:
        if (r112 >= 2) goto L54;
        this.input.consume();     // Catch: Throwable -> L51
        r112 = r112 + 1;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        this.input.rewind(r34);     // Catch: Throwable -> L28 RecognitionException -> L30
        throw th;     // Catch: Throwable -> L28 RecognitionException -> L30
    L54:
        throw new NoViableAltException("", 11, 3, this.input);     // Catch: Throwable -> L51
    L88:
        throw new NoViableAltException("", 11, 0, this.input);     // Catch: Throwable -> L28 RecognitionException -> L30
    }

    public final v3tokenSpec_return v3tokenSpec() throws RecognitionException {
        v3tokenSpec_return r5 = new v3tokenSpec_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token SEMI");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token STRING_LITERAL");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token ASSIGN");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule id");
        pushFollow(FOLLOW_id_in_v3tokenSpec1176);     // Catch: Throwable -> L14 RecognitionException -> L16
        id_return r14 = id();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.state._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        r13.add(r14.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        int r15 = this.input.LA(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r15 != 10) goto L7;
        char r16 = 1;
    L9:
        GrammarAST r17 = null;
        if (r16 == 1) goto L18;
        if (r16 != 2) goto L19;
        r5.tree = null;     // Catch: Throwable -> L14 RecognitionException -> L16
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r17 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r17, r13.nextTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r17;     // Catch: Throwable -> L14 RecognitionException -> L16
    L19:
        r10.add((Token) match(this.input, 58, FOLLOW_SEMI_in_v3tokenSpec1247));     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r18 = (GrammarAST) this.adaptor.rulePostProcessing(r17);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r18;     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.setTokenBoundaries(r18, r5.start, r5.stop);     // Catch: Throwable -> L14 RecognitionException -> L16
    L24:
        return r5;
    L18:
        r12.add((Token) match(this.input, 10, FOLLOW_ASSIGN_in_v3tokenSpec1182));     // Catch: Throwable -> L14 RecognitionException -> L16
        Token r19 = (Token) match(this.input, 62, FOLLOW_STRING_LITERAL_in_v3tokenSpec1186);     // Catch: Throwable -> L14 RecognitionException -> L16
        r11.add(r19);     // Catch: Throwable -> L14 RecognitionException -> L16
        ErrorType r20 = ErrorType.V3_ASSIGN_IN_TOKENS;     // Catch: Throwable -> L14 RecognitionException -> L16
        Token r21 = r14.start;     // Catch: Throwable -> L14 RecognitionException -> L16
        grammarError(r20, r21, new Object[]{this.input.toString(r21, r14.stop), r19.getText()});     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = null;     // Catch: Throwable -> L14 RecognitionException -> L16
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r17 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r17, r13.nextTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = r17;     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L19
    L7:
        if (r15 != 58) goto L21;
        r16 = 2;
        goto L9
    L21:
        throw new NoViableAltException("", 12, 0, this.input);     // Catch: Throwable -> L14 RecognitionException -> L16
    L16:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r22 = this.adaptor;
        TokenStream r110 = this.input;
        r5.tree = (GrammarAST) r22.errorNode(r110, r5.start, r110.LT(-1), e);
    L14:
        th = move-exception;
        throw th;
    }

    public final wildcard_return wildcard() throws RecognitionException {
        wildcard_return r5 = new wildcard_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token DOT");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule elementOptions");
        Token r12 = (Token) match(this.input, 20, FOLLOW_DOT_in_wildcard3565);     // Catch: Throwable -> L6 RecognitionException -> L8
        r10.add(r12);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (this.input.LA(1) != 35) goto L10;
        pushFollow(FOLLOW_elementOptions_in_wildcard3567);     // Catch: Throwable -> L6 RecognitionException -> L8
        elementOptions_return r13 = elementOptions();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.state._fsp--;     // Catch: Throwable -> L6 RecognitionException -> L8
        r11.add(r13.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L10:
        r5.tree = null;     // Catch: Throwable -> L6 RecognitionException -> L8
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r14 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r15 = (GrammarAST) this.adaptor.becomeRoot(new TerminalAST(100, r12), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r11.hasNext() == false) goto L13;
        this.adaptor.addChild(r15, r11.nextTree());     // Catch: Throwable -> L6 RecognitionException -> L8
    L13:
        r11.reset();     // Catch: Throwable -> L6 RecognitionException -> L8
        this.adaptor.addChild(r14, r15);     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.tree = r14;     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r16 = (GrammarAST) this.adaptor.rulePostProcessing(r14);     // Catch: Throwable -> L6 RecognitionException -> L8
        r5.tree = r16;     // Catch: Throwable -> L6 RecognitionException -> L8
        this.adaptor.setTokenBoundaries(r16, r5.start, r5.stop);     // Catch: Throwable -> L6 RecognitionException -> L8
        GrammarAST r17 = (GrammarAST) r5.tree.getFirstChildWithType(82);     // Catch: Throwable -> L6 RecognitionException -> L8
        if (r17 == null) goto L19;
        Grammar.setNodeOptions(r5.tree, r17);     // Catch: Throwable -> L6 RecognitionException -> L8
    L19:
        return r5;
    L8:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        TreeAdaptor r18 = this.adaptor;
        TokenStream r19 = this.input;
        r5.tree = (GrammarAST) r18.errorNode(r19, r5.start, r19.LT(-1), e);
    L6:
        th = move-exception;
        throw th;
    }

    public ANTLRParser(TokenStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.adaptor = new CommonTreeAdaptor();
        this.paraphrases = new ArrayDeque();
    }
}
