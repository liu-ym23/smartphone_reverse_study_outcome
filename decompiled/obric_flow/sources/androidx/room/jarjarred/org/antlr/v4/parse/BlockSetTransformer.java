package androidx.room.jarjarred.org.antlr.v4.parse;

import androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer;
import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.runtime.DFA;
import androidx.room.jarjarred.org.antlr.runtime.EarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.FailedPredicateException;
import androidx.room.jarjarred.org.antlr.runtime.IntStream;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedSetException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeAdaptor;
import androidx.room.jarjarred.org.antlr.runtime.tree.RewriteEarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.tree.RewriteRuleNodeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeRewriter;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeRuleReturnScope;
import androidx.room.jarjarred.org.antlr.v4.misc.CharSupport;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.GrammarTransformPipeline;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;

/* JADX INFO: loaded from: classes.dex */
public class BlockSetTransformer extends TreeRewriter {
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
    static final String DFA10_acceptS = "F\uffff\u0001\u0001\u0001\u00024\uffff";
    static final short[] DFA10_eof = null;
    static final String DFA10_eofS = "|\uffff";
    static final short[] DFA10_eot = null;
    static final String DFA10_eotS = "|\uffff";
    static final char[] DFA10_max = null;
    static final String DFA10_maxS = "\u0001N\u0001\u0002\u0001J\u0001\u0002\u0001R\u0001\u0002\u0002\u0003\u0001\u0002\u0001\u001c\u0001R\u0001J\u0001R\u0001>\u0001\u001c\u0001\u0002\u0001B\u0003\u0002\u0001>\u0002\u001c\u0001R\u0001\u001c\u0001\u0003\u0001>\u0001\u001c\u0001\u0002\u0001\u0003\u0001\u0002\u0002\u0003\u0001\u0002\u0001\u001c\u0001\u0002\u0006\u0003\u0001\u001c\u0001\u0003\u0001\u001c\u0001R\u0001J\u0001R\u0001>\u0001\u001c\u0001\u0003\u0004\u001c\u0001>\u0001\u001c\u0001\u0002\u0001B\u0001\u0002\u0001\u0000\u0001\u0002\u0002>\u0004\u0003\u0002\u001c\u0002\uffff\u0001\u001c\u0005\u0003\u0004\u001c\u0001>\u0001\u001c\u0001\u0002\u0001\u0003\u0001\u001c\u0001\u0002\u0002\u0003\u0004\u001c\u0004\u0003\u0001\u001c\u0001\u0003\u0001\u001c\u0001\u0003\u0004\u001c\u0002>\b\u0003\b\u001c";
    static final char[] DFA10_min = null;
    static final String DFA10_minS = "\u0001N\u0001\u0002\u0001J\u0001\u0002\u00014\u0004\u0002\u0001\u0003\u0001R\u0001J\u0001R\u0001>\u0001\u0003\u0001\u0002\u00014\u0003\u0002\u0001>\u0001\u001c\u0001\u0003\u00014\u0002\u0003\u0001\u0004\u0001\u0003\u0001\u0002\u0001\u0003\u0004\u0002\u0001\u0003\u0001\u0002\u0006\u0003\u0001\u001c\u0002\u0003\u0001R\u0001\u0003\u0001R\u0001>\u0001\u001c\u0005\u0003\u0001\u0004\u0001\u0003\u0001\u0002\u00014\u0001\u0002\u0001\u0000\u0001\u0002\u0001>\u0001\u0004\u0004\u0003\u0001\u001c\u0001\u0003\u0002\uffff\n\u0003\u0001\u0004\u0001\u0003\u0001\u0002\u0002\u0003\u0001\u0002\n\u0003\u0001\u001c\u0001\u0003\u0001\u001c\u0005\u0003\u0002\u0004\u0010\u0003";
    static final short[] DFA10_special = null;
    static final String DFA10_specialS = "<\uffff\u0001\u0000?\uffff}>";
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
    public static final BitSet FOLLOW_ACTION_in_elementOption510 = null;
    public static final BitSet FOLLOW_ALT_in_blockSet249 = null;
    public static final BitSet FOLLOW_ALT_in_blockSet263 = null;
    public static final BitSet FOLLOW_ALT_in_blockSet316 = null;
    public static final BitSet FOLLOW_ALT_in_blockSet328 = null;
    public static final BitSet FOLLOW_ALT_in_setAlt141 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption476 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption491 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption504 = null;
    public static final BitSet FOLLOW_ASSIGN_in_elementOption517 = null;
    public static final BitSet FOLLOW_BLOCK_in_blockSet244 = null;
    public static final BitSet FOLLOW_BLOCK_in_blockSet313 = null;
    public static final BitSet FOLLOW_ELEMENT_OPTIONS_in_elementOptions455 = null;
    public static final BitSet FOLLOW_ID_in_elementOption470 = null;
    public static final BitSet FOLLOW_ID_in_elementOption480 = null;
    public static final BitSet FOLLOW_ID_in_elementOption484 = null;
    public static final BitSet FOLLOW_ID_in_elementOption493 = null;
    public static final BitSet FOLLOW_ID_in_elementOption506 = null;
    public static final BitSet FOLLOW_ID_in_elementOption519 = null;
    public static final BitSet FOLLOW_INT_in_elementOption523 = null;
    public static final BitSet FOLLOW_RANGE_in_setElement425 = null;
    public static final BitSet FOLLOW_RULE_REF_in_topdown95 = null;
    public static final BitSet FOLLOW_RULE_in_topdown86 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_elementOption497 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement373 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement388 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement429 = null;
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement433 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement400 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement414 = null;
    public static final BitSet FOLLOW_TOKEN_REF_in_topdown91 = null;
    public static final BitSet FOLLOW_blockSet_in_ebnfBlockSet163 = null;
    public static final BitSet FOLLOW_blockSet_in_topdown126 = null;
    public static final BitSet FOLLOW_ebnfBlockSet_in_topdown118 = null;
    public static final BitSet FOLLOW_ebnfSuffix_in_ebnfBlockSet161 = null;
    public static final BitSet FOLLOW_elementOption_in_elementOptions457 = null;
    public static final BitSet FOLLOW_elementOptions_in_blockSet251 = null;
    public static final BitSet FOLLOW_elementOptions_in_blockSet265 = null;
    public static final BitSet FOLLOW_elementOptions_in_blockSet318 = null;
    public static final BitSet FOLLOW_elementOptions_in_blockSet330 = null;
    public static final BitSet FOLLOW_elementOptions_in_setElement375 = null;
    public static final BitSet FOLLOW_elementOptions_in_setElement402 = null;
    public static final BitSet FOLLOW_setAlt_in_topdown110 = null;
    public static final BitSet FOLLOW_setElement_in_blockSet256 = null;
    public static final BitSet FOLLOW_setElement_in_blockSet268 = null;
    public static final BitSet FOLLOW_setElement_in_blockSet321 = null;
    public static final BitSet FOLLOW_setElement_in_blockSet333 = null;
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
    public GrammarAST currentAlt;
    public String currentRuleName;
    protected DFA10 dfa10;
    public Grammar g;

    public class DFA10 extends DFA {
        final /* synthetic */ BlockSetTransformer this$0;

        public DFA10(BlockSetTransformer r5, BaseRecognizer r10) {
            this.this$0 = r5;
            this.recognizer = r10;
            this.decisionNumber = 10;
            this.eot = BlockSetTransformer.DFA10_eot;
            this.eof = BlockSetTransformer.DFA10_eof;
            this.min = BlockSetTransformer.DFA10_min;
            this.max = BlockSetTransformer.DFA10_max;
            this.accept = BlockSetTransformer.DFA10_accept;
            this.special = BlockSetTransformer.DFA10_special;
            this.transition = BlockSetTransformer.DFA10_transition;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.DFA
        public String getDescription() {
            return "90:1: blockSet : ({...}? ^( BLOCK ^(alt= ALT ( elementOptions )? {...}? setElement[inLexer] ) ( ^( ALT ( elementOptions )? setElement[inLexer] ) )+ ) -> ^( BLOCK[$BLOCK.token] ^( ALT[$BLOCK.token,\"ALT\"] ^( SET[$BLOCK.token, \"SET\"] ( setElement )+ ) ) ) |{...}? ^( BLOCK ^( ALT ( elementOptions )? setElement[inLexer] ) ( ^( ALT ( elementOptions )? setElement[inLexer] ) )+ ) -> ^( SET[$BLOCK.token, \"SET\"] ( setElement )+ ) );";
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.DFA
        public int specialStateTransition(int r10, IntStream r11) throws NoViableAltException {
            TreeNodeStream r12 = (TreeNodeStream) r11;
            if (r10 != 0) goto L16;
            r12.LA(1);
            int r5 = r12.index();
            r12.rewind();
            if (this.this$0.inContext("RULE") == false) goto L9;
            int r13 = 70;
        L12:
            r12.seek(r5);
            if (r13 < 0) goto L16;
            return r13;
        L9:
            if (this.this$0.inContext("RULE") == true) goto L11;
            r13 = 71;
            goto L12
        L11:
            r13 = -1;
        L16:
            if (BlockSetTransformer.access$000(this.this$0).backtracking <= 0) goto L19;
            BlockSetTransformer.access$100(this.this$0).failed = true;
            return -1;
        L19:
            NoViableAltException r14 = new NoViableAltException(getDescription(), 10, r10, r12);
            error(r14);
            throw r14;
        }
    }

    public static class blockSet_return extends TreeRuleReturnScope {
        GrammarAST tree;

        public blockSet_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class ebnfBlockSet_return extends TreeRuleReturnScope {
        GrammarAST tree;

        public ebnfBlockSet_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class ebnfSuffix_return extends TreeRuleReturnScope {
        GrammarAST tree;

        public ebnfSuffix_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class elementOption_return extends TreeRuleReturnScope {
        GrammarAST tree;

        public elementOption_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class elementOptions_return extends TreeRuleReturnScope {
        GrammarAST tree;

        public elementOptions_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class setAlt_return extends TreeRuleReturnScope {
        GrammarAST tree;

        public setAlt_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class setElement_return extends TreeRuleReturnScope {
        GrammarAST tree;

        public setElement_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    public static class topdown_return extends TreeRuleReturnScope {
        GrammarAST tree;

        public topdown_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public GrammarAST getTree() {
            return this.tree;
        }
    }

    static {
        tokenNames = new String[]{Grammar.INVALID_RULE_NAME, "<EOR>", "<DOWN>", "<UP>", "ACTION", "ACTION_CHAR_LITERAL", "ACTION_ESC", "ACTION_STRING_LITERAL", "ARG_ACTION", "ARG_OR_CHARSET", "ASSIGN", "AT", "CATCH", "CHANNELS", "COLON", "COLONCOLON", "COMMA", "COMMENT", "DOC_COMMENT", "DOLLAR", "DOT", "ERRCHAR", "ESC_SEQ", "FINALLY", "FRAGMENT", "GRAMMAR", "GT", "HEX_DIGIT", "ID", "IMPORT", "INT", "LEXER", "LEXER_CHAR_SET", "LOCALS", "LPAREN", "LT", "MODE", "NESTED_ACTION", "NLCHARS", "NOT", "NameChar", "NameStartChar", "OPTIONS", "OR", "PARSER", "PLUS", "PLUS_ASSIGN", "POUND", "PRIVATE", "PROTECTED", "PUBLIC", "QUESTION", "RANGE", "RARROW", "RBRACE", "RETURNS", "RPAREN", "RULE_REF", "SEMI", "SEMPRED", "SRC", "STAR", "STRING_LITERAL", "SYNPRED", "THROWS", "TOKENS_SPEC", "TOKEN_REF", "TREE_GRAMMAR", "UNICODE_ESC", "UNICODE_EXTENDED_ESC", "UnicodeBOM", "WS", "WSCHARS", "WSNLCHARS", "ALT", "ALTLIST", "ARG", "ARGLIST", "BLOCK", "CHAR_RANGE", "CLOSURE", "COMBINED", "ELEMENT_OPTIONS", "EPSILON", "INITACTION", "LABEL", "LEXER_ACTION_CALL", "LEXER_ALT_ACTION", "LIST", "OPTIONAL", "POSITIVE_CLOSURE", "PREC_RULE", "RESULT", "RET", "RULE", "RULEACTIONS", "RULEMODIFIERS", "RULES", "SET", "TEMPLATE", "WILDCARD"};
        String[] r5 = {"\u0001\u0001", "\u0001\u0002", "\u0001\u0003", "\u0001\u0004", "\u0001\b\t\uffff\u0001\u0006\u0003\uffff\u0001\u0007\u000f\uffff\u0001\u0005", "\u0001\t", "\u0001\n\u0001\u000b", "\u0001\f\u0001\u000b", "\u0001\r", "\u0001\u0010\u0006\uffff\u0001\u000f\u0011\uffff\u0001\u000e", "\u0001\u0011", "\u0001\u0012", "\u0001\u0013", "\u0001\u0014", "\u0001\u0010\u0006\uffff\u0001\u000f\u0011\uffff\u0001\u000e", "\u0001\u0015", "\u0001\b\t\uffff\u0001\u0006\u0003\uffff\u0001\u0007", "\u0001\u0016", "\u0001\u0017", "\u0001\u0018", "\u0001\u0019", "\u0001\u001a", "\u0001\u001d\u0006\uffff\u0001\u001c\u0011\uffff\u0001\u001b", "\u0001!\t\uffff\u0001\u001f\u0003\uffff\u0001 \u000f\uffff\u0001\u001e", "\u0001$\u0006\uffff\u0001#\u0011\uffff\u0001\"", "\u0001%", "\u0001(\u0017\uffff\u0001&\u0001\uffff\u0001)\u001f\uffff\u0001'", "\u0001\u001d\u0006\uffff\u0001\u001c\u0011\uffff\u0001\u001b", "\u0001*", "\u0001+", "\u0001,", "\u0001-\u0001.", "\u0001/\u0001.", "\u00010", "\u0001$\u0006\uffff\u0001#\u0011\uffff\u0001\"", "\u00011", "\u00012", "\u0001\u000b", "\u00013", "\u00014", "\u00015", "\u00016", "\u00017", "\u0001\u000b", "\u0001:\u0006\uffff\u00019\u0011\uffff\u00018", "\u0001;", "\u0001<F\uffff\u0001\u0012", "\u0001=", "\u0001>", "\u0001?", "\u0001\u000b", "\u0001\u0010\u0006\uffff\u0001\u000f\u0011\uffff\u0001\u000e", "\u0001\u0010\u0006\uffff\u0001\u000f\u0011\uffff\u0001\u000e", "\u0001\u0010\u0006\uffff\u0001\u000f\u0011\uffff\u0001\u000e", "\u0001\u0010\u0006\uffff\u0001\u000f\u0011\uffff\u0001\u000e", "\u0001B\u0017\uffff\u0001@\u0001\uffff\u0001C\u001f\uffff\u0001A", "\u0001:\u0006\uffff\u00019\u0011\uffff\u00018", "\u0001D", "\u0001!\t\uffff\u0001\u001f\u0003\uffff\u0001 ", "\u0001E", "\u0001\uffff", "\u0001H", "\u0001I", "\u0001L\u0017\uffff\u0001J\u0001\uffff\u0001M\u001f\uffff\u0001K", "\u0001N", "\u0001O", "\u0001P", "\u0001Q", "\u0001R", "\u0001U\u0006\uffff\u0001T\u0011\uffff\u0001S", "", "", "\u0001X\u0006\uffff\u0001W\u0011\uffff\u0001V", "\u0001Y", "\u0001Z", "\u0001[", "\u0001\\", "\u0001]", "\u0001\u001d\u0006\uffff\u0001\u001c\u0011\uffff\u0001\u001b", "\u0001\u001d\u0006\uffff\u0001\u001c\u0011\uffff\u0001\u001b", "\u0001\u001d\u0006\uffff\u0001\u001c\u0011\uffff\u0001\u001b", "\u0001\u001d\u0006\uffff\u0001\u001c\u0011\uffff\u0001\u001b", "\u0001`\u0017\uffff\u0001^\u0001\uffff\u0001a\u001f\uffff\u0001_", "\u0001U\u0006\uffff\u0001T\u0011\uffff\u0001S", "\u0001b", "\u0001c", "\u0001X\u0006\uffff\u0001W\u0011\uffff\u0001V", "\u0001d", "\u0001e", "\u0001.", "\u0001$\u0006\uffff\u0001#\u0011\uffff\u0001\"", "\u0001$\u0006\uffff\u0001#\u0011\uffff\u0001\"", "\u0001$\u0006\uffff\u0001#\u0011\uffff\u0001\"", "\u0001$\u0006\uffff\u0001#\u0011\uffff\u0001\"", "\u0001f", "\u0001g", "\u0001h", "\u0001i", "\u0001j", "\u0001.", "\u0001k", "\u0001.", "\u0001:\u0006\uffff\u00019\u0011\uffff\u00018", "\u0001:\u0006\uffff\u00019\u0011\uffff\u00018", "\u0001:\u0006\uffff\u00019\u0011\uffff\u00018", "\u0001:\u0006\uffff\u00019\u0011\uffff\u00018", "\u0001n\u0017\uffff\u0001l\u0001\uffff\u0001o\u001f\uffff\u0001m", "\u0001r\u0017\uffff\u0001p\u0001\uffff\u0001s\u001f\uffff\u0001q", "\u0001t", "\u0001u", "\u0001v", "\u0001w", "\u0001x", "\u0001y", "\u0001z", "\u0001{", "\u0001U\u0006\uffff\u0001T\u0011\uffff\u0001S", "\u0001U\u0006\uffff\u0001T\u0011\uffff\u0001S", "\u0001U\u0006\uffff\u0001T\u0011\uffff\u0001S", "\u0001U\u0006\uffff\u0001T\u0011\uffff\u0001S", "\u0001X\u0006\uffff\u0001W\u0011\uffff\u0001V", "\u0001X\u0006\uffff\u0001W\u0011\uffff\u0001V", "\u0001X\u0006\uffff\u0001W\u0011\uffff\u0001V", "\u0001X\u0006\uffff\u0001W\u0011\uffff\u0001V"};
        DFA10_transitionS = r5;
        DFA10_eot = DFA.unpackEncodedString("|\uffff");
        DFA10_eof = DFA.unpackEncodedString("|\uffff");
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
        FOLLOW_RULE_in_topdown86 = new BitSet(new long[]{4});
        FOLLOW_TOKEN_REF_in_topdown91 = new BitSet(new long[]{-16, 137438953471L});
        FOLLOW_RULE_REF_in_topdown95 = new BitSet(new long[]{-16, 137438953471L});
        FOLLOW_setAlt_in_topdown110 = new BitSet(new long[]{2});
        FOLLOW_ebnfBlockSet_in_topdown118 = new BitSet(new long[]{2});
        FOLLOW_blockSet_in_topdown126 = new BitSet(new long[]{2});
        FOLLOW_ALT_in_setAlt141 = new BitSet(new long[]{2});
        FOLLOW_ebnfSuffix_in_ebnfBlockSet161 = new BitSet(new long[]{4});
        FOLLOW_blockSet_in_ebnfBlockSet163 = new BitSet(new long[]{8});
        FOLLOW_BLOCK_in_blockSet244 = new BitSet(new long[]{4});
        FOLLOW_ALT_in_blockSet249 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_blockSet251 = new BitSet(new long[]{4616189618054758400L, 4});
        FOLLOW_setElement_in_blockSet256 = new BitSet(new long[]{8});
        FOLLOW_ALT_in_blockSet263 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_blockSet265 = new BitSet(new long[]{4616189618054758400L, 4});
        FOLLOW_setElement_in_blockSet268 = new BitSet(new long[]{8});
        FOLLOW_BLOCK_in_blockSet313 = new BitSet(new long[]{4});
        FOLLOW_ALT_in_blockSet316 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_blockSet318 = new BitSet(new long[]{4616189618054758400L, 4});
        FOLLOW_setElement_in_blockSet321 = new BitSet(new long[]{8});
        FOLLOW_ALT_in_blockSet328 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_blockSet330 = new BitSet(new long[]{4616189618054758400L, 4});
        FOLLOW_setElement_in_blockSet333 = new BitSet(new long[]{8});
        FOLLOW_STRING_LITERAL_in_setElement373 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_setElement375 = new BitSet(new long[]{8});
        FOLLOW_STRING_LITERAL_in_setElement388 = new BitSet(new long[]{2});
        FOLLOW_TOKEN_REF_in_setElement400 = new BitSet(new long[]{4});
        FOLLOW_elementOptions_in_setElement402 = new BitSet(new long[]{8});
        FOLLOW_TOKEN_REF_in_setElement414 = new BitSet(new long[]{2});
        FOLLOW_RANGE_in_setElement425 = new BitSet(new long[]{4});
        FOLLOW_STRING_LITERAL_in_setElement429 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_setElement433 = new BitSet(new long[]{8});
        FOLLOW_ELEMENT_OPTIONS_in_elementOptions455 = new BitSet(new long[]{4});
        FOLLOW_elementOption_in_elementOptions457 = new BitSet(new long[]{268436488});
        FOLLOW_ID_in_elementOption470 = new BitSet(new long[]{2});
        FOLLOW_ASSIGN_in_elementOption476 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption480 = new BitSet(new long[]{268435456});
        FOLLOW_ID_in_elementOption484 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption491 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption493 = new BitSet(new long[]{4611686018427387904L});
        FOLLOW_STRING_LITERAL_in_elementOption497 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption504 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption506 = new BitSet(new long[]{16});
        FOLLOW_ACTION_in_elementOption510 = new BitSet(new long[]{8});
        FOLLOW_ASSIGN_in_elementOption517 = new BitSet(new long[]{4});
        FOLLOW_ID_in_elementOption519 = new BitSet(new long[]{1073741824});
        FOLLOW_INT_in_elementOption523 = new BitSet(new long[]{8});
    }

    public BlockSetTransformer(TreeNodeStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public static /* synthetic */ RecognizerSharedState access$000(BlockSetTransformer r5) {
        return r5.state;
    }

    public static /* synthetic */ RecognizerSharedState access$100(BlockSetTransformer r5) {
        return r5.state;
    }

    public final blockSet_return blockSet() throws RecognitionException {
        blockSet_return r5 = new blockSet_return();
        r5.start = this.input.LT(1);
        RewriteRuleNodeStream r10 = new RewriteRuleNodeStream(this.adaptor, "token BLOCK");
        RewriteRuleNodeStream r11 = new RewriteRuleNodeStream(this.adaptor, "token ALT");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule elementOptions");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule setElement");
        boolean r14 = Grammar.isTokenName(this.currentRuleName);
        int r15 = this.dfa10.predict(this.input);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r15 == 1) goto L142;
        if (r15 != 2) goto L273;
        if (inContext("RULE") == false) goto L20;
        RecognizerSharedState r16 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r16.backtracking <= 0) goto L19;
        r16.failed = true;     // Catch: Throwable -> L14 RecognitionException -> L16
        return r5;
    L19:
        throw new FailedPredicateException(this.input, "blockSet", "!inContext(\"RULE\")");     // Catch: Throwable -> L14 RecognitionException -> L16
    L20:
        GrammarAST r17 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r18 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r19 = (GrammarAST) match(this.input, 78, FOLLOW_BLOCK_in_blockSet313);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r110 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r110.failed == false) goto L24;
        return r5;
    L24:
        if (r110.backtracking != 1) goto L27;
        r10.add(r19);     // Catch: Throwable -> L14 RecognitionException -> L16
    L27:
        if (this.state.backtracking != 1) goto L29;
        GrammarAST r20 = r19;
    L30:
        match(this.input, 2, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == false) goto L33;
        return r5;
    L33:
        GrammarAST r111 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r112 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r113 = (GrammarAST) match(this.input, 74, FOLLOW_ALT_in_blockSet316);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r114 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r114.failed == false) goto L37;
        return r5;
    L37:
        if (r114.backtracking != 1) goto L40;
        r11.add(r113);     // Catch: Throwable -> L14 RecognitionException -> L16
    L40:
        if (this.state.backtracking == 1) goto L43;
        r113 = null;
    L43:
        match(this.input, 2, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == false) goto L47;
        return r5;
    L47:
        if (this.input.LA(1) != 82) goto L61;
        GrammarAST r21 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_elementOptions_in_blockSet318);     // Catch: Throwable -> L14 RecognitionException -> L16
        elementOptions_return r22 = elementOptions();     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r115 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r116 = r113;
        r115._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r115.failed == false) goto L52;
        return r5;
    L52:
        if (r115.backtracking != 1) goto L55;
        r12.add(r22.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
    L55:
        if (this.state.backtracking != 1) goto L62;
        r5.tree = r20;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.adaptor.getParent(r20) == null) goto L62;
        TreeAdaptor r23 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r23.isNil(r23.getParent(r5.tree)) == false) goto L62;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
    L62:
        GrammarAST r24 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_setElement_in_blockSet321);     // Catch: Throwable -> L14 RecognitionException -> L16
        setElement_return r25 = setElement(r14);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r117 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        r117._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r117.failed == false) goto L66;
        return r5;
    L66:
        if (r117.backtracking != 1) goto L68;
        r13.add(r25.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
    L68:
        match(this.input, 3, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == false) goto L71;
        return r5;
    L71:
        int r118 = 0;
    L73:
        if (this.input.LA(1) != 74) goto L121;
        GrammarAST r26 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r27 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r28 = (GrammarAST) match(this.input, 74, FOLLOW_ALT_in_blockSet328);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r119 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r119.failed == true) goto L76;
        if (r119.backtracking != 1) goto L81;
        r11.add(r28);     // Catch: Throwable -> L14 RecognitionException -> L16
    L81:
        if (this.state.backtracking != 1) goto L84;
        if (r116 != null) goto L84;
        r116 = r28;
    L84:
        match(this.input, 2, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == true) goto L86;
        if (this.input.LA(1) != 82) goto L102;
        GrammarAST r29 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_elementOptions_in_blockSet330);     // Catch: Throwable -> L14 RecognitionException -> L16
        elementOptions_return r30 = elementOptions();     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r120 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        RewriteRuleNodeStream r121 = r11;
        r120._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r120.failed == true) goto L91;
        if (r120.backtracking != 1) goto L96;
        r12.add(r30.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
    L96:
        if (this.state.backtracking != 1) goto L103;
        r5.tree = r20;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.adaptor.getParent(r20) == null) goto L103;
        TreeAdaptor r31 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r31.isNil(r31.getParent(r5.tree)) == false) goto L103;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
    L103:
        GrammarAST r32 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_setElement_in_blockSet333);     // Catch: Throwable -> L14 RecognitionException -> L16
        setElement_return r33 = setElement(r14);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r34 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        r34._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r34.failed == true) goto L105;
        if (r34.backtracking != 1) goto L109;
        r13.add(r33.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
    L109:
        match(this.input, 3, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r35 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r35.failed == true) goto L111;
        if (r35.backtracking != 1) goto L119;
        r5.tree = r20;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.adaptor.getParent(r20) == null) goto L119;
        TreeAdaptor r36 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r36.isNil(r36.getParent(r5.tree)) == false) goto L119;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
    L119:
        r118 = r118 + 1;     // Catch: Throwable -> L14 RecognitionException -> L16
        r11 = r121;
        goto L73
    L111:
        return r5;
    L105:
        return r5;
    L91:
        return r5;
    L102:
        r121 = r11;
        goto L103
    L86:
        return r5;
    L76:
        return r5;
    L121:
        if (r118 < 1) goto L135;
        match(this.input, 3, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r37 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r37.failed == false) goto L126;
        return r5;
    L126:
        if (r37.backtracking != 1) goto L273;
        r5.tree = null;     // Catch: Throwable -> L14 RecognitionException -> L16
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r38 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r39 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        TreeAdaptor r40 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r41 = (GrammarAST) r40.becomeRoot((GrammarAST) r40.create(98, r19.token, "SET"), r39);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r13.hasNext() == false) goto L134;
    L130:
        if (r13.hasNext() == false) goto L132;
        this.adaptor.addChild(r41, r13.nextTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L130
    L132:
        r13.reset();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r38, r41);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = (GrammarAST) this.adaptor.rulePostProcessing(r38);     // Catch: Throwable -> L14 RecognitionException -> L16
        this.input.replaceChildren(this.adaptor.getParent(r5.start), this.adaptor.getChildIndex(r5.start), this.adaptor.getChildIndex(r17), r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L273
    L134:
        throw new RewriteEarlyExitException();     // Catch: Throwable -> L14 RecognitionException -> L16
    L135:
        RecognizerSharedState r42 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r42.backtracking <= 0) goto L140;
        r42.failed = true;     // Catch: Throwable -> L14 RecognitionException -> L16
        return r5;
    L140:
        throw new EarlyExitException(9, this.input);     // Catch: Throwable -> L14 RecognitionException -> L16
    L61:
        r116 = r113;
        goto L62
    L29:
        r20 = null;
    L273:
        if (this.state.backtracking != 1) goto L283;
        GrammarTransformPipeline.setGrammarPtr(this.g, r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
    L283:
        return r5;
    L142:
        if (inContext("RULE") == true) goto L149;
        RecognizerSharedState r43 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r43.backtracking <= 0) goto L148;
        r43.failed = true;     // Catch: Throwable -> L14 RecognitionException -> L16
        return r5;
    L148:
        throw new FailedPredicateException(this.input, "blockSet", "inContext(\"RULE\")");     // Catch: Throwable -> L14 RecognitionException -> L16
    L149:
        GrammarAST r44 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r45 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r46 = (GrammarAST) match(this.input, 78, FOLLOW_BLOCK_in_blockSet244);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r47 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r47.failed == false) goto L153;
        return r5;
    L153:
        if (r47.backtracking != 1) goto L156;
        r10.add(r46);     // Catch: Throwable -> L14 RecognitionException -> L16
    L156:
        if (this.state.backtracking != 1) goto L158;
        GrammarAST r48 = r46;
    L159:
        match(this.input, 2, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == false) goto L162;
        return r5;
    L162:
        GrammarAST r49 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r50 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r51 = (GrammarAST) match(this.input, 74, FOLLOW_ALT_in_blockSet249);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r122 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r122.failed == false) goto L166;
        return r5;
    L166:
        if (r122.backtracking != 1) goto L168;
        RewriteRuleNodeStream r123 = r11;
        r123.add(r51);     // Catch: Throwable -> L14 RecognitionException -> L16
    L170:
        if (this.state.backtracking != 1) goto L172;
        GrammarAST r124 = r51;
    L173:
        GrammarAST r125 = r124;
        match(this.input, 2, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == false) goto L177;
        return r5;
    L177:
        if (this.input.LA(1) != 82) goto L191;
        GrammarAST r52 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_elementOptions_in_blockSet251);     // Catch: Throwable -> L14 RecognitionException -> L16
        elementOptions_return r53 = elementOptions();     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r126 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        String r127 = "SET";
        r126._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r126.failed == false) goto L182;
        return r5;
    L182:
        if (r126.backtracking != 1) goto L185;
        r12.add(r53.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
    L185:
        if (this.state.backtracking != 1) goto L193;
        r5.tree = r48;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.adaptor.getParent(r48) == null) goto L193;
        TreeAdaptor r54 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r54.isNil(r54.getParent(r5.tree)) == false) goto L193;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
    L193:
        if (((AltAST) r51).altLabel == null) goto L200;
        RecognizerSharedState r55 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r55.backtracking <= 0) goto L199;
        r55.failed = true;     // Catch: Throwable -> L14 RecognitionException -> L16
        return r5;
    L199:
        throw new FailedPredicateException(this.input, "blockSet", "((AltAST)$alt).altLabel==null");     // Catch: Throwable -> L14 RecognitionException -> L16
    L200:
        GrammarAST r56 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_setElement_in_blockSet256);     // Catch: Throwable -> L14 RecognitionException -> L16
        setElement_return r57 = setElement(r14);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r58 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        r58._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r58.failed == false) goto L204;
        return r5;
    L204:
        if (r58.backtracking != 1) goto L206;
        r13.add(r57.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
    L206:
        match(this.input, 3, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == false) goto L209;
        return r5;
    L209:
        GrammarAST r128 = r125;
        int r129 = 0;
    L211:
        if (this.input.LA(1) != 74) goto L258;
        GrammarAST r59 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r60 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r61 = (GrammarAST) match(this.input, 74, FOLLOW_ALT_in_blockSet263);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r62 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r62.failed == true) goto L214;
        if (r62.backtracking != 1) goto L219;
        r123.add(r61);     // Catch: Throwable -> L14 RecognitionException -> L16
    L219:
        if (this.state.backtracking != 1) goto L222;
        if (r128 != null) goto L222;
        r128 = r61;
    L222:
        match(this.input, 2, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == true) goto L224;
        if (this.input.LA(1) != 82) goto L240;
        GrammarAST r63 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_elementOptions_in_blockSet265);     // Catch: Throwable -> L14 RecognitionException -> L16
        elementOptions_return r64 = elementOptions();     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r130 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        r130._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r130.failed == true) goto L229;
        if (r130.backtracking != 1) goto L234;
        r12.add(r64.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
    L234:
        if (this.state.backtracking != 1) goto L240;
        r5.tree = r48;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.adaptor.getParent(r48) == null) goto L240;
        TreeAdaptor r65 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r65.isNil(r65.getParent(r5.tree)) == false) goto L240;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L240
    L229:
        return r5;
    L240:
        GrammarAST r66 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_setElement_in_blockSet268);     // Catch: Throwable -> L14 RecognitionException -> L16
        setElement_return r67 = setElement(r14);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r68 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        r68._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r68.failed == true) goto L242;
        if (r68.backtracking != 1) goto L246;
        r13.add(r67.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
    L246:
        match(this.input, 3, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r69 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r69.failed == true) goto L248;
        if (r69.backtracking != 1) goto L256;
        r5.tree = r48;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.adaptor.getParent(r48) == null) goto L256;
        TreeAdaptor r70 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r70.isNil(r70.getParent(r5.tree)) == false) goto L256;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
    L256:
        r129 = r129 + 1;     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L211
    L248:
        return r5;
    L242:
        return r5;
    L224:
        return r5;
    L214:
        return r5;
    L258:
        if (r129 < 1) goto L275;
        match(this.input, 3, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r71 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r71.failed == false) goto L263;
        return r5;
    L263:
        if (r71.backtracking != 1) goto L273;
        r5.tree = null;     // Catch: Throwable -> L14 RecognitionException -> L16
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r72 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r73 = (GrammarAST) this.adaptor.becomeRoot(new BlockAST(78, r46.token), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r74 = (GrammarAST) this.adaptor.becomeRoot(new AltAST(74, r46.token, "ALT"), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r75 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L14 RecognitionException -> L16
        TreeAdaptor r76 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r77 = (GrammarAST) r76.becomeRoot((GrammarAST) r76.create(98, r46.token, r127), r75);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r13.hasNext() == false) goto L271;
    L267:
        if (r13.hasNext() == false) goto L269;
        this.adaptor.addChild(r77, r13.nextTree());     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L267
    L269:
        r13.reset();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r74, r77);     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r73, r74);     // Catch: Throwable -> L14 RecognitionException -> L16
        this.adaptor.addChild(r72, r73);     // Catch: Throwable -> L14 RecognitionException -> L16
        r5.tree = (GrammarAST) this.adaptor.rulePostProcessing(r72);     // Catch: Throwable -> L14 RecognitionException -> L16
        this.input.replaceChildren(this.adaptor.getParent(r5.start), this.adaptor.getChildIndex(r5.start), this.adaptor.getChildIndex(r44), r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L273
    L271:
        throw new RewriteEarlyExitException();     // Catch: Throwable -> L14 RecognitionException -> L16
    L275:
        RecognizerSharedState r78 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r78.backtracking <= 0) goto L280;
        r78.failed = true;     // Catch: Throwable -> L14 RecognitionException -> L16
        return r5;
    L280:
        throw new EarlyExitException(6, this.input);     // Catch: Throwable -> L14 RecognitionException -> L16
    L191:
        r127 = "SET";
        goto L193
    L172:
        r124 = null;
        goto L173
    L168:
        r123 = r11;
        goto L170
    L158:
        r48 = null;
    L16:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L14:
        th = move-exception;
        throw th;
    }

    public final ebnfBlockSet_return ebnfBlockSet() throws RecognitionException {
        ebnfBlockSet_return r5 = new ebnfBlockSet_return();
        r5.start = this.input.LT(1);
        RewriteRuleSubtreeStream r10 = new RewriteRuleSubtreeStream(this.adaptor, "rule blockSet");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule ebnfSuffix");
        GrammarAST r12 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L9 RecognitionException -> L11
        GrammarAST r13 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L9 RecognitionException -> L11
        pushFollow(FOLLOW_ebnfSuffix_in_ebnfBlockSet161);     // Catch: Throwable -> L9 RecognitionException -> L11
        ebnfSuffix_return r14 = ebnfSuffix();     // Catch: Throwable -> L9 RecognitionException -> L11
        RecognizerSharedState r15 = this.state;     // Catch: Throwable -> L9 RecognitionException -> L11
        r15._fsp--;     // Catch: Throwable -> L9 RecognitionException -> L11
        if (r15.failed == false) goto L7;
        return r5;
    L7:
        if (r15.backtracking != 1) goto L14;
        r11.add(r14.getTree());     // Catch: Throwable -> L9 RecognitionException -> L11
    L14:
        if (this.state.backtracking != 1) goto L16;
        GrammarAST r16 = (GrammarAST) r14.getTree();     // Catch: Throwable -> L9 RecognitionException -> L11
    L16:
        match(this.input, 2, null);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (this.state.failed == false) goto L19;
        return r5;
    L19:
        GrammarAST r17 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L9 RecognitionException -> L11
        pushFollow(FOLLOW_blockSet_in_ebnfBlockSet163);     // Catch: Throwable -> L9 RecognitionException -> L11
        blockSet_return r18 = blockSet();     // Catch: Throwable -> L9 RecognitionException -> L11
        RecognizerSharedState r19 = this.state;     // Catch: Throwable -> L9 RecognitionException -> L11
        r19._fsp--;     // Catch: Throwable -> L9 RecognitionException -> L11
        if (r19.failed == false) goto L23;
        return r5;
    L23:
        if (r19.backtracking != 1) goto L25;
        r10.add(r18.getTree());     // Catch: Throwable -> L9 RecognitionException -> L11
    L25:
        match(this.input, 3, null);     // Catch: Throwable -> L9 RecognitionException -> L11
        RecognizerSharedState r20 = this.state;     // Catch: Throwable -> L9 RecognitionException -> L11
        if (r20.failed == false) goto L29;
        return r5;
    L29:
        if (r20.backtracking != 1) goto L32;
        r5.tree = null;     // Catch: Throwable -> L9 RecognitionException -> L11
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());     // Catch: Throwable -> L9 RecognitionException -> L11
        GrammarAST r21 = (GrammarAST) this.adaptor.nil();     // Catch: Throwable -> L9 RecognitionException -> L11
        GrammarAST r22 = (GrammarAST) this.adaptor.becomeRoot(r11.nextNode(), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L9 RecognitionException -> L11
        GrammarAST r23 = (GrammarAST) this.adaptor.becomeRoot(new BlockAST(78), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L9 RecognitionException -> L11
        GrammarAST r24 = (GrammarAST) this.adaptor.becomeRoot(new AltAST(74), (GrammarAST) this.adaptor.nil());     // Catch: Throwable -> L9 RecognitionException -> L11
        this.adaptor.addChild(r24, r10.nextTree());     // Catch: Throwable -> L9 RecognitionException -> L11
        this.adaptor.addChild(r23, r24);     // Catch: Throwable -> L9 RecognitionException -> L11
        this.adaptor.addChild(r22, r23);     // Catch: Throwable -> L9 RecognitionException -> L11
        this.adaptor.addChild(r21, r22);     // Catch: Throwable -> L9 RecognitionException -> L11
        r5.tree = (GrammarAST) this.adaptor.rulePostProcessing(r21);     // Catch: Throwable -> L9 RecognitionException -> L11
        this.input.replaceChildren(this.adaptor.getParent(r5.start), this.adaptor.getChildIndex(r5.start), this.adaptor.getChildIndex(r12), r5.tree);     // Catch: Throwable -> L9 RecognitionException -> L11
    L32:
        if (this.state.backtracking != 1) goto L37;
        GrammarTransformPipeline.setGrammarPtr(this.g, r5.tree);     // Catch: Throwable -> L9 RecognitionException -> L11
    L37:
        return r5;
    L11:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L9:
        th = move-exception;
        throw th;
    }

    public final ebnfSuffix_return ebnfSuffix() throws RecognitionException {
        ebnfSuffix_return r5 = new ebnfSuffix_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        GrammarAST r11 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this.input.LA(1) != 80) goto L6;
    L20:
        this.input.consume();     // Catch: Throwable -> L10 RecognitionException -> L12
        RecognizerSharedState r12 = this.state;     // Catch: Throwable -> L10 RecognitionException -> L12
        r12.errorRecovery = false;     // Catch: Throwable -> L10 RecognitionException -> L12
        r12.failed = false;     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r12.backtracking != 1) goto L28;
        r5.tree = null;     // Catch: Throwable -> L10 RecognitionException -> L12
        if (this.adaptor.getParent(null) == null) goto L28;
        TreeAdaptor r13 = this.adaptor;     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r13.isNil(r13.getParent(r5.tree)) == false) goto L28;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L10 RecognitionException -> L12
    L28:
        if (this.state.backtracking != 1) goto L33;
        r5.tree = (GrammarAST) this.adaptor.dupNode((GrammarAST) r5.start);     // Catch: Throwable -> L10 RecognitionException -> L12
    L33:
        return r5;
    L6:
        if (this.input.LA(1) >= 89) goto L8;
    L14:
        RecognizerSharedState r14 = this.state;     // Catch: Throwable -> L10 RecognitionException -> L12
        if (r14.backtracking <= 0) goto L19;
        r14.failed = true;     // Catch: Throwable -> L10 RecognitionException -> L12
        return r5;
    L19:
        throw new MismatchedSetException(null, this.input);     // Catch: Throwable -> L10 RecognitionException -> L12
    L8:
        if (this.input.LA(1) > 90) goto L14;
    L12:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L10:
        th = move-exception;
        throw th;
    }

    public final elementOption_return elementOption() throws RecognitionException {
        elementOption_return r5 = new elementOption_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r10 != 28) goto L7;
        char r11 = 1;
    L39:
        GrammarAST r12 = null;
        if (r11 == 1) goto L150;
        if (r11 == 2) goto L124;
        if (r11 == 3) goto L98;
        if (r11 == 4) goto L72;
        if (r11 != 5) goto L193;
        GrammarAST r13 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r14 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r15 = (GrammarAST) match(this.input, 10, FOLLOW_ASSIGN_in_elementOption517);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r16 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r16.failed == false) goto L50;
        return r5;
    L50:
        if (r16.backtracking == 1) goto L53;
        r15 = null;
    L53:
        match(this.input, 2, null);     // Catch: Throwable -> L22 RecognitionException -> L24
        if (this.state.failed == false) goto L56;
        return r5;
    L56:
        GrammarAST r17 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r18 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_elementOption519);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r19 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r19.failed == false) goto L59;
        return r5;
    L59:
        int r20 = r19.backtracking;     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r21 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r22 = (GrammarAST) match(this.input, 30, FOLLOW_INT_in_elementOption523);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r23 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r23.failed == false) goto L62;
        return r5;
    L62:
        int r24 = r23.backtracking;     // Catch: Throwable -> L22 RecognitionException -> L24
        match(this.input, 3, null);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r25 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r25.failed == false) goto L66;
        return r5;
    L66:
        if (r25.backtracking != 1) goto L193;
        r5.tree = r15;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (this.adaptor.getParent(r15) == null) goto L193;
        TreeAdaptor r26 = this.adaptor;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r26.isNil(r26.getParent(r5.tree)) == false) goto L193;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L22 RecognitionException -> L24
    L193:
        return r5;
    L72:
        GrammarAST r27 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r28 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r29 = (GrammarAST) match(this.input, 10, FOLLOW_ASSIGN_in_elementOption504);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r30 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r30.failed == false) goto L76;
        return r5;
    L76:
        if (r30.backtracking == 1) goto L79;
        r29 = null;
    L79:
        match(this.input, 2, null);     // Catch: Throwable -> L22 RecognitionException -> L24
        if (this.state.failed == false) goto L82;
        return r5;
    L82:
        GrammarAST r31 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r32 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_elementOption506);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r33 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r33.failed == false) goto L85;
        return r5;
    L85:
        int r34 = r33.backtracking;     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r35 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r36 = (GrammarAST) match(this.input, 4, FOLLOW_ACTION_in_elementOption510);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r37 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r37.failed == false) goto L88;
        return r5;
    L88:
        int r38 = r37.backtracking;     // Catch: Throwable -> L22 RecognitionException -> L24
        match(this.input, 3, null);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r39 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r39.failed == false) goto L92;
        return r5;
    L92:
        if (r39.backtracking != 1) goto L193;
        r5.tree = r29;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (this.adaptor.getParent(r29) == null) goto L193;
        TreeAdaptor r40 = this.adaptor;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r40.isNil(r40.getParent(r5.tree)) == false) goto L193;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L22 RecognitionException -> L24
        goto L193
    L98:
        GrammarAST r41 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r42 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r43 = (GrammarAST) match(this.input, 10, FOLLOW_ASSIGN_in_elementOption491);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r44 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r44.failed == false) goto L102;
        return r5;
    L102:
        if (r44.backtracking == 1) goto L105;
        r43 = null;
    L105:
        match(this.input, 2, null);     // Catch: Throwable -> L22 RecognitionException -> L24
        if (this.state.failed == false) goto L108;
        return r5;
    L108:
        GrammarAST r45 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r46 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_elementOption493);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r47 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r47.failed == false) goto L111;
        return r5;
    L111:
        int r48 = r47.backtracking;     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r49 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r50 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_elementOption497);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r51 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r51.failed == false) goto L114;
        return r5;
    L114:
        int r52 = r51.backtracking;     // Catch: Throwable -> L22 RecognitionException -> L24
        match(this.input, 3, null);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r53 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r53.failed == false) goto L118;
        return r5;
    L118:
        if (r53.backtracking != 1) goto L193;
        r5.tree = r43;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (this.adaptor.getParent(r43) == null) goto L193;
        TreeAdaptor r54 = this.adaptor;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r54.isNil(r54.getParent(r5.tree)) == false) goto L193;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L22 RecognitionException -> L24
        goto L193
    L124:
        GrammarAST r55 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r56 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r57 = (GrammarAST) match(this.input, 10, FOLLOW_ASSIGN_in_elementOption476);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r58 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r58.failed == false) goto L128;
        return r5;
    L128:
        if (r58.backtracking == 1) goto L131;
        r57 = null;
    L131:
        match(this.input, 2, null);     // Catch: Throwable -> L22 RecognitionException -> L24
        if (this.state.failed == false) goto L134;
        return r5;
    L134:
        GrammarAST r59 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r60 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_elementOption480);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r61 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r61.failed == false) goto L137;
        return r5;
    L137:
        int r62 = r61.backtracking;     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r63 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r64 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_elementOption484);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r65 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r65.failed == false) goto L140;
        return r5;
    L140:
        int r66 = r65.backtracking;     // Catch: Throwable -> L22 RecognitionException -> L24
        match(this.input, 3, null);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r67 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r67.failed == false) goto L144;
        return r5;
    L144:
        if (r67.backtracking != 1) goto L193;
        r5.tree = r57;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (this.adaptor.getParent(r57) == null) goto L193;
        TreeAdaptor r68 = this.adaptor;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r68.isNil(r68.getParent(r5.tree)) == false) goto L193;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L22 RecognitionException -> L24
        goto L193
    L150:
        GrammarAST r69 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L22 RecognitionException -> L24
        GrammarAST r70 = (GrammarAST) match(this.input, 28, FOLLOW_ID_in_elementOption470);     // Catch: Throwable -> L22 RecognitionException -> L24
        RecognizerSharedState r71 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r71.failed == false) goto L153;
        return r5;
    L153:
        int r72 = r71.backtracking;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r72 != 1) goto L156;
        r12 = r70;
    L156:
        if (r72 != 1) goto L193;
        r5.tree = r12;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (this.adaptor.getParent(r12) == null) goto L193;
        TreeAdaptor r73 = this.adaptor;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r73.isNil(r73.getParent(r5.tree)) == false) goto L193;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L22 RecognitionException -> L24
        goto L193
    L7:
        int r110 = 0;
        if (r10 == 10) goto L10;
        RecognizerSharedState r74 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r74.backtracking <= 0) goto L190;
        r74.failed = true;     // Catch: Throwable -> L22 RecognitionException -> L24
        return r5;
    L190:
        throw new NoViableAltException("", 13, 0, this.input);     // Catch: Throwable -> L22 RecognitionException -> L24
    L10:
        if (this.input.LA(2) == 2) goto L12;
        RecognizerSharedState r75 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r75.backtracking <= 0) goto L179;
        r75.failed = true;     // Catch: Throwable -> L22 RecognitionException -> L24
        return r5;
    L179:
        int r76 = this.input.mark();     // Catch: Throwable -> L22 RecognitionException -> L24
        this.input.consume();     // Catch: Throwable -> L182
        throw new NoViableAltException("", 13, 2, this.input);     // Catch: Throwable -> L182
    L182:
        th = move-exception;
        this.input.rewind(r76);     // Catch: Throwable -> L22 RecognitionException -> L24
        throw th;     // Catch: Throwable -> L22 RecognitionException -> L24
    L12:
        if (this.input.LA(3) != 28) goto L162;
        int r77 = this.input.LA(4);     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r77 == 4) goto L38;
        if (r77 == 28) goto L37;
        if (r77 == 30) goto L36;
        if (r77 == 62) goto L35;
        RecognizerSharedState r78 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r78.backtracking <= 0) goto L26;
        r78.failed = true;     // Catch: Throwable -> L22 RecognitionException -> L24
        return r5;
    L26:
        int r79 = this.input.mark();     // Catch: Throwable -> L22 RecognitionException -> L24
    L27:
        if (r110 >= 3) goto L32;
        this.input.consume();     // Catch: Throwable -> L29
        r110 = r110 + 1;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        this.input.rewind(r79);     // Catch: Throwable -> L22 RecognitionException -> L24
        throw th;     // Catch: Throwable -> L22 RecognitionException -> L24
    L32:
        throw new NoViableAltException("", 13, 4, this.input);     // Catch: Throwable -> L29
    L35:
        r11 = 3;
        goto L39
    L36:
        r11 = 5;
        goto L39
    L37:
        r11 = 2;
        goto L39
    L38:
        r11 = 4;
        goto L39
    L162:
        RecognizerSharedState r80 = this.state;     // Catch: Throwable -> L22 RecognitionException -> L24
        if (r80.backtracking <= 0) goto L166;
        r80.failed = true;     // Catch: Throwable -> L22 RecognitionException -> L24
        return r5;
    L166:
        int r81 = this.input.mark();     // Catch: Throwable -> L22 RecognitionException -> L24
    L167:
        if (r110 >= 2) goto L172;
        this.input.consume();     // Catch: Throwable -> L169
        r110 = r110 + 1;     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        this.input.rewind(r81);     // Catch: Throwable -> L22 RecognitionException -> L24
        throw th;     // Catch: Throwable -> L22 RecognitionException -> L24
    L172:
        throw new NoViableAltException("", 13, 3, this.input);     // Catch: Throwable -> L169
    L24:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L22:
        th = move-exception;
        throw th;
    }

    public final elementOptions_return elementOptions() throws RecognitionException {
        elementOptions_return r5 = new elementOptions_return();
        r5.start = this.input.LT(1);
        GrammarAST r10 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L24 RecognitionException -> L26
        GrammarAST r11 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L24 RecognitionException -> L26
        GrammarAST r12 = (GrammarAST) match(this.input, 82, FOLLOW_ELEMENT_OPTIONS_in_elementOptions455);     // Catch: Throwable -> L24 RecognitionException -> L26
        RecognizerSharedState r13 = this.state;     // Catch: Throwable -> L24 RecognitionException -> L26
        if (r13.failed == false) goto L7;
        return r5;
    L7:
        if (r13.backtracking == 1) goto L11;
        r12 = null;
    L11:
        if (this.input.LA(1) != 2) goto L43;
        match(this.input, 2, null);     // Catch: Throwable -> L24 RecognitionException -> L26
        if (this.state.failed == false) goto L15;
        return r5;
    L15:
        GrammarAST r14 = null;
    L16:
        int r15 = this.input.LA(1);     // Catch: Throwable -> L24 RecognitionException -> L26
        if (r15 != 10) goto L19;
    L28:
        GrammarAST r16 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L24 RecognitionException -> L26
        pushFollow(FOLLOW_elementOption_in_elementOptions457);     // Catch: Throwable -> L24 RecognitionException -> L26
        elementOption_return r17 = elementOption();     // Catch: Throwable -> L24 RecognitionException -> L26
        RecognizerSharedState r18 = this.state;     // Catch: Throwable -> L24 RecognitionException -> L26
        r18._fsp--;     // Catch: Throwable -> L24 RecognitionException -> L26
        if (r18.failed == true) goto L30;
        if (r18.backtracking != 1) goto L36;
        if (r14 != null) goto L36;
        r14 = (GrammarAST) r17.getTree();     // Catch: Throwable -> L24 RecognitionException -> L26
    L36:
        if (this.state.backtracking != 1) goto L16;
        r5.tree = r12;     // Catch: Throwable -> L24 RecognitionException -> L26
        if (this.adaptor.getParent(r12) == null) goto L16;
        TreeAdaptor r19 = this.adaptor;     // Catch: Throwable -> L24 RecognitionException -> L26
        if (r19.isNil(r19.getParent(r5.tree)) == false) goto L16;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L24 RecognitionException -> L26
        goto L16
    L30:
        return r5;
    L19:
        if (r15 == 28) goto L28;
        match(this.input, 3, null);     // Catch: Throwable -> L24 RecognitionException -> L26
        if (this.state.failed == false) goto L43;
        return r5;
    L43:
        if (this.state.backtracking != 1) goto L52;
        r5.tree = r12;     // Catch: Throwable -> L24 RecognitionException -> L26
        if (this.adaptor.getParent(r12) == null) goto L52;
        TreeAdaptor r20 = this.adaptor;     // Catch: Throwable -> L24 RecognitionException -> L26
        if (r20.isNil(r20.getParent(r5.tree)) == false) goto L52;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L24 RecognitionException -> L26
    L52:
        return r5;
    L26:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L24:
        th = move-exception;
        throw th;
    }

    public TreeRewriter[] getDelegates() {
        return new TreeRewriter[0];
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getGrammarFileName() {
        return "androidx/room/jarjarred/org/antlr/v4/parse/BlockSetTransformer.g";
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String[] getTokenNames() {
        return tokenNames;
    }

    public TreeAdaptor getTreeAdaptor() {
        return this.adaptor;
    }

    public final setAlt_return setAlt() throws RecognitionException {
        setAlt_return r5 = new setAlt_return();
        r5.start = this.input.LT(1);
    L11:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L33:
        return r5;
    L9:
        th = move-exception;
        throw th;
    L4:
        if (inContext("RULE BLOCK") == true) goto L15;
        RecognizerSharedState r10 = this.state;     // Catch: Throwable -> L9 RecognitionException -> L11
        if (r10.backtracking <= 0) goto L14;
        r10.failed = true;     // Catch: Throwable -> L9 RecognitionException -> L11
        return r5;
    L14:
        throw new FailedPredicateException(this.input, "setAlt", "inContext(\"RULE BLOCK\")");     // Catch: Throwable -> L9 RecognitionException -> L11
    L15:
        GrammarAST r11 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L9 RecognitionException -> L11
        GrammarAST r12 = (GrammarAST) match(this.input, 74, FOLLOW_ALT_in_setAlt141);     // Catch: Throwable -> L9 RecognitionException -> L11
        RecognizerSharedState r13 = this.state;     // Catch: Throwable -> L9 RecognitionException -> L11
        if (r13.failed == false) goto L18;
        return r5;
    L18:
        int r14 = r13.backtracking;     // Catch: Throwable -> L9 RecognitionException -> L11
        if (r14 == 1) goto L22;
        r12 = null;
    L22:
        if (r14 != 1) goto L24;
        this.currentAlt = (GrammarAST) r5.start;     // Catch: Throwable -> L9 RecognitionException -> L11
    L24:
        if (r14 != 1) goto L33;
        r5.tree = r12;     // Catch: Throwable -> L9 RecognitionException -> L11
        if (this.adaptor.getParent(r12) == null) goto L33;
        TreeAdaptor r15 = this.adaptor;     // Catch: Throwable -> L9 RecognitionException -> L11
        if (r15.isNil(r15.getParent(r5.tree)) == false) goto L33;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L9 RecognitionException -> L11
        goto L33
    }

    public final setElement_return setElement(boolean r15) throws RecognitionException {
        setElement_return r5 = new setElement_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r10 != 62) goto L24;
        int r11 = this.input.LA(2);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r11 != 2) goto L8;
        char r12 = 1;
    L34:
        GrammarAST r13 = null;
        if (r12 == 1) goto L161;
        if (r12 != 2) goto L38;
        GrammarAST r14 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r16 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement388);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r17 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r17.failed == false) goto L143;
        return r5;
    L143:
        if (r17.backtracking != 1) goto L145;
        r13 = r16;
    L145:
        if (r15 == false) goto L155;
        if (CharSupport.getCharValueFromGrammarCharLiteral(r16.getText()) != (-1)) goto L155;
        RecognizerSharedState r18 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r18.backtracking <= 0) goto L153;
        r18.failed = true;     // Catch: Throwable -> L14 RecognitionException -> L16
        return r5;
    L153:
        throw new FailedPredicateException(this.input, "setElement", "!inLexer || CharSupport.getCharValueFromGrammarCharLiteral($a.getText())!=-1");     // Catch: Throwable -> L14 RecognitionException -> L16
    L155:
        if (this.state.backtracking != 1) goto L198;
        r5.tree = r13;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.adaptor.getParent(r13) == null) goto L198;
        TreeAdaptor r19 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r19.isNil(r19.getParent(r5.tree)) == false) goto L198;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
    L198:
        if (this.state.backtracking != 1) goto L205;
        r5.tree = r13;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.adaptor.getParent(r13) == null) goto L205;
        TreeAdaptor r110 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r110.isNil(r110.getParent(r5.tree)) == false) goto L205;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
    L205:
        if (this.state.backtracking != 1) goto L210;
        GrammarTransformPipeline.setGrammarPtr(this.g, r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
    L210:
        return r5;
    L38:
        if (r12 == 3) goto L106;
        if (r12 == 4) goto L87;
        if (r12 != 5) goto L198;
        if (r15 == true) goto L49;
        RecognizerSharedState r111 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r111.backtracking <= 0) goto L48;
        r111.failed = true;     // Catch: Throwable -> L14 RecognitionException -> L16
        return r5;
    L48:
        throw new FailedPredicateException(this.input, "setElement", "inLexer");     // Catch: Throwable -> L14 RecognitionException -> L16
    L49:
        GrammarAST r112 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r113 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r114 = (GrammarAST) match(this.input, 52, FOLLOW_RANGE_in_setElement425);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r20 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r20.failed == false) goto L53;
        return r5;
    L53:
        if (r20.backtracking == 1) goto L56;
        r114 = null;
    L56:
        match(this.input, 2, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == false) goto L59;
        return r5;
    L59:
        GrammarAST r21 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r22 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement429);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r23 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r23.failed == false) goto L62;
        return r5;
    L62:
        int r24 = r23.backtracking;     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r25 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r26 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement433);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r27 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r27.failed == false) goto L65;
        return r5;
    L65:
        int r28 = r27.backtracking;     // Catch: Throwable -> L14 RecognitionException -> L16
        match(this.input, 3, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == false) goto L69;
        return r5;
    L69:
        if (CharSupport.getCharValueFromGrammarCharLiteral(r22.getText()) != (-1)) goto L71;
    L81:
        RecognizerSharedState r115 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r115.backtracking <= 0) goto L86;
        r115.failed = true;     // Catch: Throwable -> L14 RecognitionException -> L16
        return r5;
    L86:
        throw new FailedPredicateException(this.input, "setElement", "CharSupport.getCharValueFromGrammarCharLiteral($a.getText())!=-1 &&\n\t\t\t CharSupport.getCharValueFromGrammarCharLiteral($b.getText())!=-1");     // Catch: Throwable -> L14 RecognitionException -> L16
    L71:
        if (CharSupport.getCharValueFromGrammarCharLiteral(r26.getText()) == (-1)) goto L81;
        if (this.state.backtracking != 1) goto L80;
        r5.tree = r114;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.adaptor.getParent(r114) == null) goto L80;
        TreeAdaptor r29 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r29.isNil(r29.getParent(r5.tree)) == false) goto L80;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
    L80:
        r13 = r114;
        goto L198
    L87:
        if (r15 == false) goto L94;
        RecognizerSharedState r116 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r116.backtracking <= 0) goto L93;
        r116.failed = true;     // Catch: Throwable -> L14 RecognitionException -> L16
        return r5;
    L93:
        throw new FailedPredicateException(this.input, "setElement", "!inLexer");     // Catch: Throwable -> L14 RecognitionException -> L16
    L94:
        GrammarAST r117 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r118 = (GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_setElement414);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r30 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r30.failed == false) goto L97;
        return r5;
    L97:
        int r31 = r30.backtracking;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r31 != 1) goto L100;
        r13 = r118;
    L100:
        if (r31 != 1) goto L198;
        r5.tree = r13;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.adaptor.getParent(r13) == null) goto L198;
        TreeAdaptor r119 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r119.isNil(r119.getParent(r5.tree)) == false) goto L198;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L198
    L106:
        if (r15 == false) goto L113;
        RecognizerSharedState r120 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r120.backtracking <= 0) goto L112;
        r120.failed = true;     // Catch: Throwable -> L14 RecognitionException -> L16
        return r5;
    L112:
        throw new FailedPredicateException(this.input, "setElement", "!inLexer");     // Catch: Throwable -> L14 RecognitionException -> L16
    L113:
        GrammarAST r121 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r122 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        r114 = (GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_setElement400);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r32 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r32.failed == false) goto L117;
        return r5;
    L117:
        if (r32.backtracking == 1) goto L120;
        r114 = null;
    L120:
        match(this.input, 2, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == false) goto L123;
        return r5;
    L123:
        GrammarAST r33 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_elementOptions_in_setElement402);     // Catch: Throwable -> L14 RecognitionException -> L16
        elementOptions_return r34 = elementOptions();     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r35 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        r35._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r35.failed == false) goto L127;
        return r5;
    L127:
        if (r35.backtracking != 1) goto L129;
        GrammarAST r36 = (GrammarAST) r34.getTree();     // Catch: Throwable -> L14 RecognitionException -> L16
    L129:
        match(this.input, 3, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r37 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r37.failed == false) goto L133;
        return r5;
    L133:
        if (r37.backtracking != 1) goto L80;
        r5.tree = r114;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.adaptor.getParent(r114) == null) goto L80;
        TreeAdaptor r38 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r38.isNil(r38.getParent(r5.tree)) == false) goto L80;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
        goto L80
    L161:
        GrammarAST r39 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r40 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        GrammarAST r41 = (GrammarAST) match(this.input, 62, FOLLOW_STRING_LITERAL_in_setElement373);     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r42 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r42.failed == false) goto L165;
        return r5;
    L165:
        if (r42.backtracking != 1) goto L167;
        GrammarAST r43 = r41;
    L168:
        match(this.input, 2, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == false) goto L171;
        return r5;
    L171:
        GrammarAST r44 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L14 RecognitionException -> L16
        pushFollow(FOLLOW_elementOptions_in_setElement375);     // Catch: Throwable -> L14 RecognitionException -> L16
        elementOptions_return r45 = elementOptions();     // Catch: Throwable -> L14 RecognitionException -> L16
        RecognizerSharedState r46 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        r46._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r46.failed == false) goto L175;
        return r5;
    L175:
        if (r46.backtracking != 1) goto L177;
        GrammarAST r47 = (GrammarAST) r45.getTree();     // Catch: Throwable -> L14 RecognitionException -> L16
    L177:
        match(this.input, 3, null);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.state.failed == false) goto L180;
        return r5;
    L180:
        if (r15 == false) goto L190;
        if (CharSupport.getCharValueFromGrammarCharLiteral(r41.getText()) != (-1)) goto L190;
        RecognizerSharedState r123 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r123.backtracking <= 0) goto L188;
        r123.failed = true;     // Catch: Throwable -> L14 RecognitionException -> L16
        return r5;
    L188:
        throw new FailedPredicateException(this.input, "setElement", "!inLexer || CharSupport.getCharValueFromGrammarCharLiteral($a.getText())!=-1");     // Catch: Throwable -> L14 RecognitionException -> L16
    L190:
        if (this.state.backtracking != 1) goto L196;
        r5.tree = r43;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.adaptor.getParent(r43) == null) goto L196;
        TreeAdaptor r124 = this.adaptor;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r124.isNil(r124.getParent(r5.tree)) == false) goto L196;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L14 RecognitionException -> L16
    L196:
        r13 = r43;
        goto L198
    L167:
        r43 = null;
        goto L168
    L8:
        if (r11 != 3) goto L10;
        r12 = 2;
        goto L34
    L10:
        RecognizerSharedState r125 = this.state;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r125.backtracking <= 0) goto L18;
        r125.failed = true;     // Catch: Throwable -> L14 RecognitionException -> L16
        return r5;
    L18:
        int r126 = this.input.mark();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.input.consume();     // Catch: Throwable -> L21
        throw new NoViableAltException("", 11, 1, this.input);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        this.input.rewind(r126);     // Catch: Throwable -> L14 RecognitionException -> L16
        throw th;     // Catch: Throwable -> L14 RecognitionException -> L16
    L24:
        if (r10 != 66) goto L33;
        if (r15 == true) goto L33;
        int r48 = this.input.LA(2);     // Catch: Throwable -> L14 RecognitionException -> L16
        if (r48 != 2) goto L30;
        if (r15 == true) goto L30;
        r12 = 3;
    L30:
        if (r48 != 3) goto L33;
        if (r15 == true) goto L33;
        r12 = 4;
    L33:
        r12 = 5;
    L16:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L14:
        th = move-exception;
        throw th;
    }

    public void setTreeAdaptor(TreeAdaptor r5) {
        this.adaptor = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeRewriter
    public /* bridge */ /* synthetic */ Object topdown() throws RecognitionException {
        return topdown();
    }

    public BlockSetTransformer(TreeNodeStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.adaptor = new CommonTreeAdaptor();
        this.dfa10 = new DFA10(this, this);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.tree.TreeRewriter
    public final topdown_return topdown() throws RecognitionException {
        topdown_return r5 = new topdown_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        int r11 = 0;
        if (r10 != 74) goto L7;
        char r12 = 2;
    L29:
        GrammarAST r13 = null;
        if (r12 == 1) goto L74;
        if (r12 == 2) goto L61;
        if (r12 == 3) goto L48;
        if (r12 != 4) goto L167;
        GrammarAST r14 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        pushFollow(FOLLOW_blockSet_in_topdown126);     // Catch: Throwable -> L19 RecognitionException -> L21
        blockSet_return r15 = blockSet();     // Catch: Throwable -> L19 RecognitionException -> L21
        RecognizerSharedState r16 = this.state;     // Catch: Throwable -> L19 RecognitionException -> L21
        r16._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r16.failed == false) goto L39;
        return r5;
    L39:
        if (r16.backtracking != 1) goto L42;
        r13 = (GrammarAST) r15.getTree();     // Catch: Throwable -> L19 RecognitionException -> L21
    L42:
        if (this.state.backtracking != 1) goto L167;
        r5.tree = r13;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (this.adaptor.getParent(r13) == null) goto L167;
        TreeAdaptor r17 = this.adaptor;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r17.isNil(r17.getParent(r5.tree)) == false) goto L167;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L19 RecognitionException -> L21
    L167:
        return r5;
    L48:
        GrammarAST r18 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        pushFollow(FOLLOW_ebnfBlockSet_in_topdown118);     // Catch: Throwable -> L19 RecognitionException -> L21
        ebnfBlockSet_return r19 = ebnfBlockSet();     // Catch: Throwable -> L19 RecognitionException -> L21
        RecognizerSharedState r20 = this.state;     // Catch: Throwable -> L19 RecognitionException -> L21
        r20._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r20.failed == false) goto L52;
        return r5;
    L52:
        if (r20.backtracking != 1) goto L55;
        r13 = (GrammarAST) r19.getTree();     // Catch: Throwable -> L19 RecognitionException -> L21
    L55:
        if (this.state.backtracking != 1) goto L167;
        r5.tree = r13;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (this.adaptor.getParent(r13) == null) goto L167;
        TreeAdaptor r21 = this.adaptor;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r21.isNil(r21.getParent(r5.tree)) == false) goto L167;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L167
    L61:
        GrammarAST r22 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        pushFollow(FOLLOW_setAlt_in_topdown110);     // Catch: Throwable -> L19 RecognitionException -> L21
        setAlt_return r23 = setAlt();     // Catch: Throwable -> L19 RecognitionException -> L21
        RecognizerSharedState r24 = this.state;     // Catch: Throwable -> L19 RecognitionException -> L21
        r24._fsp--;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r24.failed == false) goto L65;
        return r5;
    L65:
        if (r24.backtracking != 1) goto L68;
        r13 = (GrammarAST) r23.getTree();     // Catch: Throwable -> L19 RecognitionException -> L21
    L68:
        if (this.state.backtracking != 1) goto L167;
        r5.tree = r13;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (this.adaptor.getParent(r13) == null) goto L167;
        TreeAdaptor r25 = this.adaptor;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r25.isNil(r25.getParent(r5.tree)) == false) goto L167;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L167
    L74:
        GrammarAST r26 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        GrammarAST r27 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        GrammarAST r28 = (GrammarAST) match(this.input, 94, FOLLOW_RULE_in_topdown86);     // Catch: Throwable -> L19 RecognitionException -> L21
        RecognizerSharedState r29 = this.state;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r29.failed == false) goto L78;
        return r5;
    L78:
        if (r29.backtracking == 1) goto L81;
        r28 = null;
    L81:
        match(this.input, 2, null);     // Catch: Throwable -> L19 RecognitionException -> L21
        if (this.state.failed == false) goto L84;
        return r5;
    L84:
        int r30 = this.input.LA(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r30 != 66) goto L87;
        char r31 = 1;
    L89:
        if (r31 == 1) goto L105;
        if (r31 == 2) goto L92;
        GrammarAST r32 = null;
        GrammarAST r110 = null;
    L119:
        if (this.state.backtracking != 1) goto L124;
        if (r32 == null) goto L122;
        String r33 = r32.getText();     // Catch: Throwable -> L19 RecognitionException -> L21
    L123:
        this.currentRuleName = r33;     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L124
    L122:
        r33 = null;
    L124:
        int r34 = this.input.LA(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r34 < 4) goto L142;
        if (r34 > 100) goto L142;
        GrammarAST r35 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        GrammarAST r36 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        matchAny(this.input);     // Catch: Throwable -> L19 RecognitionException -> L21
        RecognizerSharedState r37 = this.state;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r37.failed == true) goto L130;
        int r38 = r37.backtracking;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r38 != 1) goto L135;
        if (r110 != null) goto L135;
        r110 = r36;
    L135:
        if (r38 != 1) goto L141;
        r5.tree = r28;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (this.adaptor.getParent(r28) == null) goto L141;
        TreeAdaptor r39 = this.adaptor;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r39.isNil(r39.getParent(r5.tree)) == false) goto L141;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L19 RecognitionException -> L21
    L141:
        r11 = r11 + 1;     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L124
    L130:
        return r5;
    L142:
        if (r11 < 1) goto L153;
        match(this.input, 3, null);     // Catch: Throwable -> L19 RecognitionException -> L21
        RecognizerSharedState r40 = this.state;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r40.failed == false) goto L147;
        return r5;
    L147:
        if (r40.backtracking != 1) goto L167;
        r5.tree = r28;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (this.adaptor.getParent(r28) == null) goto L167;
        TreeAdaptor r41 = this.adaptor;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r41.isNil(r41.getParent(r5.tree)) == false) goto L167;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L167
    L153:
        RecognizerSharedState r42 = this.state;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r42.backtracking <= 0) goto L158;
        r42.failed = true;     // Catch: Throwable -> L19 RecognitionException -> L21
        return r5;
    L158:
        throw new EarlyExitException(2, this.input);     // Catch: Throwable -> L19 RecognitionException -> L21
    L92:
        GrammarAST r43 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        r32 = (GrammarAST) match(this.input, 57, FOLLOW_RULE_REF_in_topdown95);     // Catch: Throwable -> L19 RecognitionException -> L21
        RecognizerSharedState r44 = this.state;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r44.failed == false) goto L95;
        return r5;
    L95:
        int r45 = r44.backtracking;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r45 != 1) goto L98;
        r110 = r32;
    L99:
        if (r45 != 1) goto L119;
        r5.tree = r28;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (this.adaptor.getParent(r28) == null) goto L119;
        TreeAdaptor r46 = this.adaptor;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r46.isNil(r46.getParent(r5.tree)) == false) goto L119;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L119
    L98:
        r110 = null;
        goto L99
    L105:
        GrammarAST r47 = (GrammarAST) this.input.LT(1);     // Catch: Throwable -> L19 RecognitionException -> L21
        r32 = (GrammarAST) match(this.input, 66, FOLLOW_TOKEN_REF_in_topdown91);     // Catch: Throwable -> L19 RecognitionException -> L21
        RecognizerSharedState r48 = this.state;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r48.failed == false) goto L108;
        return r5;
    L108:
        int r49 = r48.backtracking;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r49 != 1) goto L111;
        r110 = r32;
    L112:
        if (r49 != 1) goto L119;
        r5.tree = r28;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (this.adaptor.getParent(r28) == null) goto L119;
        TreeAdaptor r50 = this.adaptor;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r50.isNil(r50.getParent(r5.tree)) == false) goto L119;
        r5.tree = (GrammarAST) this.adaptor.getParent(r5.tree);     // Catch: Throwable -> L19 RecognitionException -> L21
        goto L119
    L111:
        r110 = null;
        goto L112
    L87:
        if (r30 != 57) goto L159;
        r31 = 2;
        goto L89
    L159:
        RecognizerSharedState r51 = this.state;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r51.backtracking <= 0) goto L164;
        r51.failed = true;     // Catch: Throwable -> L19 RecognitionException -> L21
        return r5;
    L164:
        throw new NoViableAltException("", 1, 0, this.input);     // Catch: Throwable -> L19 RecognitionException -> L21
    L7:
        if (r10 != 78) goto L9;
        r12 = 4;
        goto L29
    L9:
        if (r10 == 80) goto L26;
        if (r10 != 94) goto L12;
        r12 = 1;
        goto L29
    L12:
        if (r10 == 89) goto L26;
        if (r10 == 90) goto L26;
        RecognizerSharedState r52 = this.state;     // Catch: Throwable -> L19 RecognitionException -> L21
        if (r52.backtracking <= 0) goto L24;
        r52.failed = true;     // Catch: Throwable -> L19 RecognitionException -> L21
        return r5;
    L24:
        throw new NoViableAltException("", 3, 0, this.input);     // Catch: Throwable -> L19 RecognitionException -> L21
    L26:
        r12 = 3;
    L21:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L19:
        th = move-exception;
        throw th;
    }

    public BlockSetTransformer(TreeNodeStream r5, Grammar r10) {
        this(r5, new RecognizerSharedState());
        this.g = r10;
    }
}
