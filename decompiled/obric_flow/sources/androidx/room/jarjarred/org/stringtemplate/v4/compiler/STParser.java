package androidx.room.jarjarred.org.stringtemplate.v4.compiler;

import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.EarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.FailedPredicateException;
import androidx.room.jarjarred.org.antlr.runtime.IntStream;
import androidx.room.jarjarred.org.antlr.runtime.MismatchedTokenException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.Parser;
import androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeAdaptor;
import androidx.room.jarjarred.org.antlr.runtime.tree.RewriteEarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.RewriteRuleTokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorManager;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorType;
import java.util.ArrayList;
import java.util.Stack;
import kotlin.text.Typography;
import okhttp3.internal.http2.Http2Stream;

/* JADX INFO: loaded from: classes.dex */
public class STParser extends Parser {
    public static final int AND = 30;
    public static final int ARGS = 38;
    public static final int AT = 33;
    public static final int BANG = 10;
    public static final int COLON = 13;
    public static final int COMMA = 18;
    public static final int COMMENT = 37;
    public static final int DOT = 19;
    public static final int ELEMENTS = 39;
    public static final int ELLIPSIS = 11;
    public static final int ELSE = 5;
    public static final int ELSEIF = 6;
    public static final int END = 34;
    public static final int ENDIF = 7;
    public static final int EOF = -1;
    public static final int EQUALS = 12;
    public static final int EXEC_FUNC = 40;
    public static final int EXPR = 41;
    public static final int FALSE = 36;
    public static final BitSet FOLLOW_AND_in_andConditional737 = null;
    public static final BitSet FOLLOW_AT_in_includeExpr1455 = null;
    public static final BitSet FOLLOW_AT_in_includeExpr1482 = null;
    public static final BitSet FOLLOW_AT_in_region312 = null;
    public static final BitSet FOLLOW_BANG_in_notConditional753 = null;
    public static final BitSet FOLLOW_COLON_in_exprNoComma1008 = null;
    public static final BitSet FOLLOW_COLON_in_mapExpr1084 = null;
    public static final BitSet FOLLOW_COLON_in_mapExpr1149 = null;
    public static final BitSet FOLLOW_COMMA_in_argExprList1696 = null;
    public static final BitSet FOLLOW_COMMA_in_args1649 = null;
    public static final BitSet FOLLOW_COMMA_in_args1657 = null;
    public static final BitSet FOLLOW_COMMA_in_exprOptions854 = null;
    public static final BitSet FOLLOW_COMMA_in_list1773 = null;
    public static final BitSet FOLLOW_COMMA_in_mapExpr1076 = null;
    public static final BitSet FOLLOW_COMMA_in_mapExpr1159 = null;
    public static final BitSet FOLLOW_COMMA_in_subtemplate430 = null;
    public static final BitSet FOLLOW_COMMENT_in_element171 = null;
    public static final BitSet FOLLOW_COMMENT_in_singleElement231 = null;
    public static final BitSet FOLLOW_DOT_in_includeExpr1400 = null;
    public static final BitSet FOLLOW_DOT_in_includeExpr1459 = null;
    public static final BitSet FOLLOW_DOT_in_memberExpr1292 = null;
    public static final BitSet FOLLOW_DOT_in_memberExpr1320 = null;
    public static final BitSet FOLLOW_DOT_in_notConditionalExpr784 = null;
    public static final BitSet FOLLOW_DOT_in_notConditionalExpr814 = null;
    public static final BitSet FOLLOW_ELLIPSIS_in_args1659 = null;
    public static final BitSet FOLLOW_ELLIPSIS_in_args1679 = null;
    public static final BitSet FOLLOW_ELSEIF_in_ifstat527 = null;
    public static final BitSet FOLLOW_ELSE_in_ifstat556 = null;
    public static final BitSet FOLLOW_ENDIF_in_ifstat578 = null;
    public static final BitSet FOLLOW_END_in_region331 = null;
    public static final BitSet FOLLOW_EOF_in_templateAndEOF141 = null;
    public static final BitSet FOLLOW_EQUALS_in_namedArg1726 = null;
    public static final BitSet FOLLOW_EQUALS_in_option893 = null;
    public static final BitSet FOLLOW_FALSE_in_primary1534 = null;
    public static final BitSet FOLLOW_ID_in_includeExpr1370 = null;
    public static final BitSet FOLLOW_ID_in_includeExpr1402 = null;
    public static final BitSet FOLLOW_ID_in_includeExpr1427 = null;
    public static final BitSet FOLLOW_ID_in_includeExpr1461 = null;
    public static final BitSet FOLLOW_ID_in_includeExpr1484 = null;
    public static final BitSet FOLLOW_ID_in_mapTemplateRef1210 = null;
    public static final BitSet FOLLOW_ID_in_memberExpr1294 = null;
    public static final BitSet FOLLOW_ID_in_namedArg1724 = null;
    public static final BitSet FOLLOW_ID_in_notConditionalExpr773 = null;
    public static final BitSet FOLLOW_ID_in_notConditionalExpr788 = null;
    public static final BitSet FOLLOW_ID_in_option883 = null;
    public static final BitSet FOLLOW_ID_in_primary1519 = null;
    public static final BitSet FOLLOW_ID_in_region314 = null;
    public static final BitSet FOLLOW_ID_in_subtemplate426 = null;
    public static final BitSet FOLLOW_ID_in_subtemplate435 = null;
    public static final BitSet FOLLOW_IF_in_ifstat496 = null;
    public static final BitSet FOLLOW_INDENT_in_element168 = null;
    public static final BitSet FOLLOW_INDENT_in_element181 = null;
    public static final BitSet FOLLOW_INDENT_in_ifstat491 = null;
    public static final BitSet FOLLOW_INDENT_in_ifstat522 = null;
    public static final BitSet FOLLOW_INDENT_in_ifstat551 = null;
    public static final BitSet FOLLOW_INDENT_in_ifstat570 = null;
    public static final BitSet FOLLOW_INDENT_in_region305 = null;
    public static final BitSet FOLLOW_INDENT_in_region326 = null;
    public static final BitSet FOLLOW_INDENT_in_subtemplate447 = null;
    public static final BitSet FOLLOW_LBRACK_in_list1753 = null;
    public static final BitSet FOLLOW_LBRACK_in_list1767 = null;
    public static final BitSet FOLLOW_LCURLY_in_subtemplate420 = null;
    public static final BitSet FOLLOW_LDELIM_in_exprTag260 = null;
    public static final BitSet FOLLOW_LDELIM_in_ifstat494 = null;
    public static final BitSet FOLLOW_LDELIM_in_ifstat525 = null;
    public static final BitSet FOLLOW_LDELIM_in_ifstat554 = null;
    public static final BitSet FOLLOW_LDELIM_in_ifstat576 = null;
    public static final BitSet FOLLOW_LDELIM_in_region310 = null;
    public static final BitSet FOLLOW_LDELIM_in_region329 = null;
    public static final BitSet FOLLOW_LPAREN_in_ifstat498 = null;
    public static final BitSet FOLLOW_LPAREN_in_ifstat529 = null;
    public static final BitSet FOLLOW_LPAREN_in_includeExpr1372 = null;
    public static final BitSet FOLLOW_LPAREN_in_includeExpr1404 = null;
    public static final BitSet FOLLOW_LPAREN_in_includeExpr1429 = null;
    public static final BitSet FOLLOW_LPAREN_in_includeExpr1463 = null;
    public static final BitSet FOLLOW_LPAREN_in_includeExpr1486 = null;
    public static final BitSet FOLLOW_LPAREN_in_mapTemplateRef1212 = null;
    public static final BitSet FOLLOW_LPAREN_in_mapTemplateRef1245 = null;
    public static final BitSet FOLLOW_LPAREN_in_mapTemplateRef1253 = null;
    public static final BitSet FOLLOW_LPAREN_in_memberExpr1322 = null;
    public static final BitSet FOLLOW_LPAREN_in_notConditionalExpr816 = null;
    public static final BitSet FOLLOW_LPAREN_in_primary1553 = null;
    public static final BitSet FOLLOW_LPAREN_in_primary1569 = null;
    public static final BitSet FOLLOW_LPAREN_in_primary1579 = null;
    public static final BitSet FOLLOW_NEWLINE_in_element173 = null;
    public static final BitSet FOLLOW_NEWLINE_in_ifstat593 = null;
    public static final BitSet FOLLOW_NEWLINE_in_region344 = null;
    public static final BitSet FOLLOW_NEWLINE_in_singleElement226 = null;
    public static final BitSet FOLLOW_OR_in_conditional717 = null;
    public static final BitSet FOLLOW_PIPE_in_subtemplate440 = null;
    public static final BitSet FOLLOW_RBRACK_in_list1755 = null;
    public static final BitSet FOLLOW_RBRACK_in_list1780 = null;
    public static final BitSet FOLLOW_RCURLY_in_subtemplate450 = null;
    public static final BitSet FOLLOW_RDELIM_in_exprTag273 = null;
    public static final BitSet FOLLOW_RDELIM_in_ifstat506 = null;
    public static final BitSet FOLLOW_RDELIM_in_ifstat537 = null;
    public static final BitSet FOLLOW_RDELIM_in_ifstat558 = null;
    public static final BitSet FOLLOW_RDELIM_in_ifstat582 = null;
    public static final BitSet FOLLOW_RDELIM_in_region316 = null;
    public static final BitSet FOLLOW_RDELIM_in_region333 = null;
    public static final BitSet FOLLOW_RPAREN_in_ifstat504 = null;
    public static final BitSet FOLLOW_RPAREN_in_ifstat535 = null;
    public static final BitSet FOLLOW_RPAREN_in_includeExpr1377 = null;
    public static final BitSet FOLLOW_RPAREN_in_includeExpr1408 = null;
    public static final BitSet FOLLOW_RPAREN_in_includeExpr1433 = null;
    public static final BitSet FOLLOW_RPAREN_in_includeExpr1467 = null;
    public static final BitSet FOLLOW_RPAREN_in_includeExpr1490 = null;
    public static final BitSet FOLLOW_RPAREN_in_mapTemplateRef1216 = null;
    public static final BitSet FOLLOW_RPAREN_in_mapTemplateRef1251 = null;
    public static final BitSet FOLLOW_RPAREN_in_mapTemplateRef1258 = null;
    public static final BitSet FOLLOW_RPAREN_in_memberExpr1326 = null;
    public static final BitSet FOLLOW_RPAREN_in_notConditionalExpr820 = null;
    public static final BitSet FOLLOW_RPAREN_in_primary1558 = null;
    public static final BitSet FOLLOW_RPAREN_in_primary1573 = null;
    public static final BitSet FOLLOW_RPAREN_in_primary1584 = null;
    public static final BitSet FOLLOW_SEMI_in_exprTag266 = null;
    public static final BitSet FOLLOW_STRING_in_primary1524 = null;
    public static final BitSet FOLLOW_SUPER_in_includeExpr1398 = null;
    public static final BitSet FOLLOW_SUPER_in_includeExpr1457 = null;
    public static final BitSet FOLLOW_TEXT_in_singleElement221 = null;
    public static final BitSet FOLLOW_TRUE_in_primary1529 = null;
    public static final BitSet FOLLOW_andConditional_in_conditional713 = null;
    public static final BitSet FOLLOW_andConditional_in_conditional720 = null;
    public static final BitSet FOLLOW_argExprList_in_args1640 = null;
    public static final BitSet FOLLOW_argExprList_in_mapTemplateRef1255 = null;
    public static final BitSet FOLLOW_argExprList_in_primary1581 = null;
    public static final BitSet FOLLOW_arg_in_argExprList1692 = null;
    public static final BitSet FOLLOW_arg_in_argExprList1698 = null;
    public static final BitSet FOLLOW_arg_in_namedArg1728 = null;
    public static final BitSet FOLLOW_args_in_includeExpr1406 = null;
    public static final BitSet FOLLOW_args_in_includeExpr1431 = null;
    public static final BitSet FOLLOW_args_in_mapTemplateRef1214 = null;
    public static final BitSet FOLLOW_compoundElement_in_element205 = null;
    public static final BitSet FOLLOW_conditional_in_ifstat502 = null;
    public static final BitSet FOLLOW_conditional_in_ifstat533 = null;
    public static final BitSet FOLLOW_conditional_in_primary1556 = null;
    public static final BitSet FOLLOW_element_in_template155 = null;
    public static final BitSet FOLLOW_exprNoComma_in_arg1715 = null;
    public static final BitSet FOLLOW_exprNoComma_in_listElement1800 = null;
    public static final BitSet FOLLOW_exprNoComma_in_option895 = null;
    public static final BitSet FOLLOW_exprOptions_in_exprTag268 = null;
    public static final BitSet FOLLOW_exprTag_in_singleElement216 = null;
    public static final BitSet FOLLOW_expr_in_exprTag262 = null;
    public static final BitSet FOLLOW_expr_in_includeExpr1374 = null;
    public static final BitSet FOLLOW_expr_in_primary1571 = null;
    public static final BitSet FOLLOW_ifstat_in_compoundElement244 = null;
    public static final BitSet FOLLOW_includeExpr_in_memberExpr1281 = null;
    public static final BitSet FOLLOW_listElement_in_list1769 = null;
    public static final BitSet FOLLOW_listElement_in_list1775 = null;
    public static final BitSet FOLLOW_list_in_primary1544 = null;
    public static final BitSet FOLLOW_mapExpr_in_expr1055 = null;
    public static final BitSet FOLLOW_mapExpr_in_mapTemplateRef1247 = null;
    public static final BitSet FOLLOW_mapExpr_in_memberExpr1324 = null;
    public static final BitSet FOLLOW_mapExpr_in_notConditionalExpr818 = null;
    public static final BitSet FOLLOW_mapTemplateRef_in_exprNoComma1010 = null;
    public static final BitSet FOLLOW_mapTemplateRef_in_mapExpr1086 = null;
    public static final BitSet FOLLOW_mapTemplateRef_in_mapExpr1153 = null;
    public static final BitSet FOLLOW_mapTemplateRef_in_mapExpr1163 = null;
    public static final BitSet FOLLOW_memberExpr_in_exprNoComma1002 = null;
    public static final BitSet FOLLOW_memberExpr_in_mapExpr1067 = null;
    public static final BitSet FOLLOW_memberExpr_in_mapExpr1078 = null;
    public static final BitSet FOLLOW_memberExpr_in_notConditional761 = null;
    public static final BitSet FOLLOW_namedArg_in_args1645 = null;
    public static final BitSet FOLLOW_namedArg_in_args1651 = null;
    public static final BitSet FOLLOW_notConditional_in_andConditional733 = null;
    public static final BitSet FOLLOW_notConditional_in_andConditional740 = null;
    public static final BitSet FOLLOW_notConditional_in_notConditional756 = null;
    public static final BitSet FOLLOW_option_in_exprOptions850 = null;
    public static final BitSet FOLLOW_option_in_exprOptions856 = null;
    public static final BitSet FOLLOW_primary_in_includeExpr1508 = null;
    public static final BitSet FOLLOW_region_in_compoundElement249 = null;
    public static final BitSet FOLLOW_singleElement_in_element183 = null;
    public static final BitSet FOLLOW_singleElement_in_element200 = null;
    public static final BitSet FOLLOW_subtemplate_in_mapTemplateRef1238 = null;
    public static final BitSet FOLLOW_subtemplate_in_primary1539 = null;
    public static final BitSet FOLLOW_template_in_ifstat515 = null;
    public static final BitSet FOLLOW_template_in_ifstat541 = null;
    public static final BitSet FOLLOW_template_in_ifstat562 = null;
    public static final BitSet FOLLOW_template_in_region322 = null;
    public static final BitSet FOLLOW_template_in_subtemplate445 = null;
    public static final BitSet FOLLOW_template_in_templateAndEOF139 = null;
    public static final int ID = 25;
    public static final int IF = 4;
    public static final int INCLUDE = 42;
    public static final int INCLUDE_IND = 43;
    public static final int INCLUDE_REGION = 44;
    public static final int INCLUDE_SUPER = 45;
    public static final int INCLUDE_SUPER_REGION = 46;
    public static final int INDENT = 31;
    public static final int INDENTED_EXPR = 47;
    public static final int LBRACK = 16;
    public static final int LCURLY = 20;
    public static final int LDELIM = 23;
    public static final int LIST = 48;
    public static final int LPAREN = 14;
    public static final int MAP = 49;
    public static final int NEWLINE = 32;
    public static final int NULL = 50;
    public static final int OPTIONS = 51;
    public static final int OR = 29;
    public static final int PIPE = 28;
    public static final int PROP = 52;
    public static final int PROP_IND = 53;
    public static final int RBRACK = 17;
    public static final int RCURLY = 21;
    public static final int RDELIM = 24;
    public static final int REGION = 54;
    public static final int RPAREN = 15;
    public static final int SEMI = 9;
    public static final int STRING = 26;
    public static final int SUBTEMPLATE = 55;
    public static final int SUPER = 8;
    public static final int TEXT = 22;
    public static final int TO_STR = 56;
    public static final int TRUE = 35;
    public static final int WS = 27;
    public static final int ZIP = 57;
    public static final String[] tokenNames = null;
    protected TreeAdaptor adaptor;
    protected Stack<conditional_scope> conditional_stack;
    ErrorManager errMgr;
    Token templateToken;

    public static class andConditional_return extends ParserRuleReturnScope {
        CommonTree tree;

        public andConditional_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class argExprList_return extends ParserRuleReturnScope {
        CommonTree tree;

        public argExprList_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class arg_return extends ParserRuleReturnScope {
        CommonTree tree;

        public arg_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class args_return extends ParserRuleReturnScope {
        CommonTree tree;

        public args_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class compoundElement_return extends ParserRuleReturnScope {
        CommonTree tree;

        public compoundElement_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class conditional_return extends ParserRuleReturnScope {
        CommonTree tree;

        public conditional_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class conditional_scope {
        boolean inside;

        public conditional_scope() {
        }
    }

    public static class element_return extends ParserRuleReturnScope {
        CommonTree tree;

        public element_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class exprNoComma_return extends ParserRuleReturnScope {
        CommonTree tree;

        public exprNoComma_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class exprOptions_return extends ParserRuleReturnScope {
        CommonTree tree;

        public exprOptions_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class exprTag_return extends ParserRuleReturnScope {
        CommonTree tree;

        public exprTag_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;

        public expr_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class ifstat_return extends ParserRuleReturnScope {
        CommonTree tree;

        public ifstat_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class includeExpr_return extends ParserRuleReturnScope {
        CommonTree tree;

        public includeExpr_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class listElement_return extends ParserRuleReturnScope {
        CommonTree tree;

        public listElement_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class list_return extends ParserRuleReturnScope {
        CommonTree tree;

        public list_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class mapExpr_return extends ParserRuleReturnScope {
        CommonTree tree;

        public mapExpr_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class mapTemplateRef_return extends ParserRuleReturnScope {
        CommonTree tree;

        public mapTemplateRef_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class memberExpr_return extends ParserRuleReturnScope {
        CommonTree tree;

        public memberExpr_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class namedArg_return extends ParserRuleReturnScope {
        CommonTree tree;

        public namedArg_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class notConditionalExpr_return extends ParserRuleReturnScope {
        CommonTree tree;

        public notConditionalExpr_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class notConditional_return extends ParserRuleReturnScope {
        CommonTree tree;

        public notConditional_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class option_return extends ParserRuleReturnScope {
        CommonTree tree;

        public option_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class primary_return extends ParserRuleReturnScope {
        CommonTree tree;

        public primary_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class region_return extends ParserRuleReturnScope {
        CommonTree tree;

        public region_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class singleElement_return extends ParserRuleReturnScope {
        CommonTree tree;

        public singleElement_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class subtemplate_return extends ParserRuleReturnScope {
        CommonTree tree;

        public subtemplate_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class templateAndEOF_return extends ParserRuleReturnScope {
        CommonTree tree;

        public templateAndEOF_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    public static class template_return extends ParserRuleReturnScope {
        CommonTree tree;

        public template_return() {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public /* bridge */ /* synthetic */ Object getTree() {
            return getTree();
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.ParserRuleReturnScope, androidx.room.jarjarred.org.antlr.runtime.RuleReturnScope
        public CommonTree getTree() {
            return this.tree;
        }
    }

    static {
        tokenNames = new String[]{Grammar.INVALID_RULE_NAME, "<EOR>", "<DOWN>", "<UP>", "IF", "ELSE", "ELSEIF", "ENDIF", "SUPER", "SEMI", "BANG", "ELLIPSIS", "EQUALS", "COLON", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "COMMA", "DOT", "LCURLY", "RCURLY", "TEXT", "LDELIM", "RDELIM", "ID", "STRING", "WS", "PIPE", "OR", "AND", "INDENT", "NEWLINE", "AT", "END", "TRUE", "FALSE", "COMMENT", "ARGS", "ELEMENTS", "EXEC_FUNC", "EXPR", "INCLUDE", "INCLUDE_IND", "INCLUDE_REGION", "INCLUDE_SUPER", "INCLUDE_SUPER_REGION", "INDENTED_EXPR", "LIST", "MAP", "NULL", "OPTIONS", "PROP", "PROP_IND", "REGION", "SUBTEMPLATE", "TO_STR", "ZIP"};
        FOLLOW_template_in_templateAndEOF139 = new BitSet(new long[]{0});
        FOLLOW_EOF_in_templateAndEOF141 = new BitSet(new long[]{2});
        FOLLOW_element_in_template155 = new BitSet(new long[]{143893987330L});
        FOLLOW_INDENT_in_element168 = new BitSet(new long[]{137438953472L});
        FOLLOW_COMMENT_in_element171 = new BitSet(new long[]{4294967296L});
        FOLLOW_NEWLINE_in_element173 = new BitSet(new long[]{2});
        FOLLOW_INDENT_in_element181 = new BitSet(new long[]{141746503680L});
        FOLLOW_singleElement_in_element183 = new BitSet(new long[]{2});
        FOLLOW_singleElement_in_element200 = new BitSet(new long[]{2});
        FOLLOW_compoundElement_in_element205 = new BitSet(new long[]{2});
        FOLLOW_exprTag_in_singleElement216 = new BitSet(new long[]{2});
        FOLLOW_TEXT_in_singleElement221 = new BitSet(new long[]{2});
        FOLLOW_NEWLINE_in_singleElement226 = new BitSet(new long[]{2});
        FOLLOW_COMMENT_in_singleElement231 = new BitSet(new long[]{2});
        FOLLOW_ifstat_in_compoundElement244 = new BitSet(new long[]{2});
        FOLLOW_region_in_compoundElement249 = new BitSet(new long[]{2});
        FOLLOW_LDELIM_in_exprTag260 = new BitSet(new long[]{111770943744L});
        FOLLOW_expr_in_exprTag262 = new BitSet(new long[]{16777728});
        FOLLOW_SEMI_in_exprTag266 = new BitSet(new long[]{33554432});
        FOLLOW_exprOptions_in_exprTag268 = new BitSet(new long[]{16777216});
        FOLLOW_RDELIM_in_exprTag273 = new BitSet(new long[]{2});
        FOLLOW_INDENT_in_region305 = new BitSet(new long[]{8388608});
        FOLLOW_LDELIM_in_region310 = new BitSet(new long[]{8589934592L});
        FOLLOW_AT_in_region312 = new BitSet(new long[]{33554432});
        FOLLOW_ID_in_region314 = new BitSet(new long[]{16777216});
        FOLLOW_RDELIM_in_region316 = new BitSet(new long[]{143893987328L});
        FOLLOW_template_in_region322 = new BitSet(new long[]{2155872256L});
        FOLLOW_INDENT_in_region326 = new BitSet(new long[]{8388608});
        FOLLOW_LDELIM_in_region329 = new BitSet(new long[]{17179869184L});
        FOLLOW_END_in_region331 = new BitSet(new long[]{16777216});
        FOLLOW_RDELIM_in_region333 = new BitSet(new long[]{4294967298L});
        FOLLOW_NEWLINE_in_region344 = new BitSet(new long[]{2});
        FOLLOW_LCURLY_in_subtemplate420 = new BitSet(new long[]{143929638912L});
        FOLLOW_ID_in_subtemplate426 = new BitSet(new long[]{268697600});
        FOLLOW_COMMA_in_subtemplate430 = new BitSet(new long[]{33554432});
        FOLLOW_ID_in_subtemplate435 = new BitSet(new long[]{268697600});
        FOLLOW_PIPE_in_subtemplate440 = new BitSet(new long[]{143896084480L});
        FOLLOW_template_in_subtemplate445 = new BitSet(new long[]{2149580800L});
        FOLLOW_INDENT_in_subtemplate447 = new BitSet(new long[]{2097152});
        FOLLOW_RCURLY_in_subtemplate450 = new BitSet(new long[]{2});
        FOLLOW_INDENT_in_ifstat491 = new BitSet(new long[]{8388608});
        FOLLOW_LDELIM_in_ifstat494 = new BitSet(new long[]{16});
        FOLLOW_IF_in_ifstat496 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_LPAREN_in_ifstat498 = new BitSet(new long[]{111770944768L});
        FOLLOW_conditional_in_ifstat502 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_ifstat504 = new BitSet(new long[]{16777216});
        FOLLOW_RDELIM_in_ifstat506 = new BitSet(new long[]{143893987328L});
        FOLLOW_template_in_ifstat515 = new BitSet(new long[]{2155872256L});
        FOLLOW_INDENT_in_ifstat522 = new BitSet(new long[]{8388608});
        FOLLOW_LDELIM_in_ifstat525 = new BitSet(new long[]{64});
        FOLLOW_ELSEIF_in_ifstat527 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_LPAREN_in_ifstat529 = new BitSet(new long[]{111770944768L});
        FOLLOW_conditional_in_ifstat533 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_ifstat535 = new BitSet(new long[]{16777216});
        FOLLOW_RDELIM_in_ifstat537 = new BitSet(new long[]{143893987328L});
        FOLLOW_template_in_ifstat541 = new BitSet(new long[]{2155872256L});
        FOLLOW_INDENT_in_ifstat551 = new BitSet(new long[]{8388608});
        FOLLOW_LDELIM_in_ifstat554 = new BitSet(new long[]{32});
        FOLLOW_ELSE_in_ifstat556 = new BitSet(new long[]{16777216});
        FOLLOW_RDELIM_in_ifstat558 = new BitSet(new long[]{143893987328L});
        FOLLOW_template_in_ifstat562 = new BitSet(new long[]{2155872256L});
        FOLLOW_INDENT_in_ifstat570 = new BitSet(new long[]{8388608});
        FOLLOW_LDELIM_in_ifstat576 = new BitSet(new long[]{128});
        FOLLOW_ENDIF_in_ifstat578 = new BitSet(new long[]{16777216});
        FOLLOW_RDELIM_in_ifstat582 = new BitSet(new long[]{4294967298L});
        FOLLOW_NEWLINE_in_ifstat593 = new BitSet(new long[]{2});
        FOLLOW_andConditional_in_conditional713 = new BitSet(new long[]{536870914});
        FOLLOW_OR_in_conditional717 = new BitSet(new long[]{111770944768L});
        FOLLOW_andConditional_in_conditional720 = new BitSet(new long[]{536870914});
        FOLLOW_notConditional_in_andConditional733 = new BitSet(new long[]{1073741826});
        FOLLOW_AND_in_andConditional737 = new BitSet(new long[]{111770944768L});
        FOLLOW_notConditional_in_andConditional740 = new BitSet(new long[]{1073741826});
        FOLLOW_BANG_in_notConditional753 = new BitSet(new long[]{111770944768L});
        FOLLOW_notConditional_in_notConditional756 = new BitSet(new long[]{2});
        FOLLOW_memberExpr_in_notConditional761 = new BitSet(new long[]{2});
        FOLLOW_ID_in_notConditionalExpr773 = new BitSet(new long[]{524290});
        FOLLOW_DOT_in_notConditionalExpr784 = new BitSet(new long[]{33554432});
        FOLLOW_ID_in_notConditionalExpr788 = new BitSet(new long[]{524290});
        FOLLOW_DOT_in_notConditionalExpr814 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_LPAREN_in_notConditionalExpr816 = new BitSet(new long[]{111770943744L});
        FOLLOW_mapExpr_in_notConditionalExpr818 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_notConditionalExpr820 = new BitSet(new long[]{524290});
        FOLLOW_option_in_exprOptions850 = new BitSet(new long[]{262146});
        FOLLOW_COMMA_in_exprOptions854 = new BitSet(new long[]{33554432});
        FOLLOW_option_in_exprOptions856 = new BitSet(new long[]{262146});
        FOLLOW_ID_in_option883 = new BitSet(new long[]{4098});
        FOLLOW_EQUALS_in_option893 = new BitSet(new long[]{111770943744L});
        FOLLOW_exprNoComma_in_option895 = new BitSet(new long[]{2});
        FOLLOW_memberExpr_in_exprNoComma1002 = new BitSet(new long[]{8194});
        FOLLOW_COLON_in_exprNoComma1008 = new BitSet(new long[]{34619392});
        FOLLOW_mapTemplateRef_in_exprNoComma1010 = new BitSet(new long[]{2});
        FOLLOW_mapExpr_in_expr1055 = new BitSet(new long[]{2});
        FOLLOW_memberExpr_in_mapExpr1067 = new BitSet(new long[]{270338});
        FOLLOW_COMMA_in_mapExpr1076 = new BitSet(new long[]{111770943744L});
        FOLLOW_memberExpr_in_mapExpr1078 = new BitSet(new long[]{270336});
        FOLLOW_COLON_in_mapExpr1084 = new BitSet(new long[]{34619392});
        FOLLOW_mapTemplateRef_in_mapExpr1086 = new BitSet(new long[]{8194});
        FOLLOW_COLON_in_mapExpr1149 = new BitSet(new long[]{34619392});
        FOLLOW_mapTemplateRef_in_mapExpr1153 = new BitSet(new long[]{270338});
        FOLLOW_COMMA_in_mapExpr1159 = new BitSet(new long[]{34619392});
        FOLLOW_mapTemplateRef_in_mapExpr1163 = new BitSet(new long[]{270338});
        FOLLOW_ID_in_mapTemplateRef1210 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_LPAREN_in_mapTemplateRef1212 = new BitSet(new long[]{111770978560L});
        FOLLOW_args_in_mapTemplateRef1214 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_mapTemplateRef1216 = new BitSet(new long[]{2});
        FOLLOW_subtemplate_in_mapTemplateRef1238 = new BitSet(new long[]{2});
        FOLLOW_LPAREN_in_mapTemplateRef1245 = new BitSet(new long[]{111770943744L});
        FOLLOW_mapExpr_in_mapTemplateRef1247 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_mapTemplateRef1251 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_LPAREN_in_mapTemplateRef1253 = new BitSet(new long[]{111770976512L});
        FOLLOW_argExprList_in_mapTemplateRef1255 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_mapTemplateRef1258 = new BitSet(new long[]{2});
        FOLLOW_includeExpr_in_memberExpr1281 = new BitSet(new long[]{524290});
        FOLLOW_DOT_in_memberExpr1292 = new BitSet(new long[]{33554432});
        FOLLOW_ID_in_memberExpr1294 = new BitSet(new long[]{524290});
        FOLLOW_DOT_in_memberExpr1320 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_LPAREN_in_memberExpr1322 = new BitSet(new long[]{111770943744L});
        FOLLOW_mapExpr_in_memberExpr1324 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_memberExpr1326 = new BitSet(new long[]{524290});
        FOLLOW_ID_in_includeExpr1370 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_LPAREN_in_includeExpr1372 = new BitSet(new long[]{111770976512L});
        FOLLOW_expr_in_includeExpr1374 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_includeExpr1377 = new BitSet(new long[]{2});
        FOLLOW_SUPER_in_includeExpr1398 = new BitSet(new long[]{524288});
        FOLLOW_DOT_in_includeExpr1400 = new BitSet(new long[]{33554432});
        FOLLOW_ID_in_includeExpr1402 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_LPAREN_in_includeExpr1404 = new BitSet(new long[]{111770978560L});
        FOLLOW_args_in_includeExpr1406 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_includeExpr1408 = new BitSet(new long[]{2});
        FOLLOW_ID_in_includeExpr1427 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_LPAREN_in_includeExpr1429 = new BitSet(new long[]{111770978560L});
        FOLLOW_args_in_includeExpr1431 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_includeExpr1433 = new BitSet(new long[]{2});
        FOLLOW_AT_in_includeExpr1455 = new BitSet(new long[]{256});
        FOLLOW_SUPER_in_includeExpr1457 = new BitSet(new long[]{524288});
        FOLLOW_DOT_in_includeExpr1459 = new BitSet(new long[]{33554432});
        FOLLOW_ID_in_includeExpr1461 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_LPAREN_in_includeExpr1463 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_includeExpr1467 = new BitSet(new long[]{2});
        FOLLOW_AT_in_includeExpr1482 = new BitSet(new long[]{33554432});
        FOLLOW_ID_in_includeExpr1484 = new BitSet(new long[]{Http2Stream.EMIT_BUFFER_SIZE});
        FOLLOW_LPAREN_in_includeExpr1486 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_includeExpr1490 = new BitSet(new long[]{2});
        FOLLOW_primary_in_includeExpr1508 = new BitSet(new long[]{2});
        FOLLOW_ID_in_primary1519 = new BitSet(new long[]{2});
        FOLLOW_STRING_in_primary1524 = new BitSet(new long[]{2});
        FOLLOW_TRUE_in_primary1529 = new BitSet(new long[]{2});
        FOLLOW_FALSE_in_primary1534 = new BitSet(new long[]{2});
        FOLLOW_subtemplate_in_primary1539 = new BitSet(new long[]{2});
        FOLLOW_list_in_primary1544 = new BitSet(new long[]{2});
        FOLLOW_LPAREN_in_primary1553 = new BitSet(new long[]{111770944768L});
        FOLLOW_conditional_in_primary1556 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_primary1558 = new BitSet(new long[]{2});
        FOLLOW_LPAREN_in_primary1569 = new BitSet(new long[]{111770943744L});
        FOLLOW_expr_in_primary1571 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_primary1573 = new BitSet(new long[]{16386});
        FOLLOW_LPAREN_in_primary1579 = new BitSet(new long[]{111770976512L});
        FOLLOW_argExprList_in_primary1581 = new BitSet(new long[]{32768});
        FOLLOW_RPAREN_in_primary1584 = new BitSet(new long[]{2});
        FOLLOW_argExprList_in_args1640 = new BitSet(new long[]{2});
        FOLLOW_namedArg_in_args1645 = new BitSet(new long[]{262146});
        FOLLOW_COMMA_in_args1649 = new BitSet(new long[]{33554432});
        FOLLOW_namedArg_in_args1651 = new BitSet(new long[]{262146});
        FOLLOW_COMMA_in_args1657 = new BitSet(new long[]{2048});
        FOLLOW_ELLIPSIS_in_args1659 = new BitSet(new long[]{2});
        FOLLOW_ELLIPSIS_in_args1679 = new BitSet(new long[]{2});
        FOLLOW_arg_in_argExprList1692 = new BitSet(new long[]{262146});
        FOLLOW_COMMA_in_argExprList1696 = new BitSet(new long[]{111770943744L});
        FOLLOW_arg_in_argExprList1698 = new BitSet(new long[]{262146});
        FOLLOW_exprNoComma_in_arg1715 = new BitSet(new long[]{2});
        FOLLOW_ID_in_namedArg1724 = new BitSet(new long[]{4096});
        FOLLOW_EQUALS_in_namedArg1726 = new BitSet(new long[]{111770943744L});
        FOLLOW_arg_in_namedArg1728 = new BitSet(new long[]{2});
        FOLLOW_LBRACK_in_list1753 = new BitSet(new long[]{131072});
        FOLLOW_RBRACK_in_list1755 = new BitSet(new long[]{2});
        FOLLOW_LBRACK_in_list1767 = new BitSet(new long[]{111771336960L});
        FOLLOW_listElement_in_list1769 = new BitSet(new long[]{393216});
        FOLLOW_COMMA_in_list1773 = new BitSet(new long[]{111771336960L});
        FOLLOW_listElement_in_list1775 = new BitSet(new long[]{393216});
        FOLLOW_RBRACK_in_list1780 = new BitSet(new long[]{2});
        FOLLOW_exprNoComma_in_listElement1800 = new BitSet(new long[]{2});
    }

    public STParser(TokenStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public final andConditional_return andConditional() throws RecognitionException {
        andConditional_return r5 = new andConditional_return();
        r5.start = this.input.LT(1);
        CommonTree r10 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_notConditional_in_andConditional733);
        notConditional_return r11 = notConditional();
        this.state._fsp--;
        this.adaptor.addChild(r10, r11.getTree());
    L4:
        if (this.input.LA(1) != 30) goto L6;
        r10 = (CommonTree) this.adaptor.becomeRoot((CommonTree) this.adaptor.create((CommonToken) match(this.input, 30, FOLLOW_AND_in_andConditional737)), r10);
        pushFollow(FOLLOW_notConditional_in_andConditional740);
        notConditional_return r12 = notConditional();
        this.state._fsp--;
        this.adaptor.addChild(r10, r12.getTree());
        goto L4
    L6:
        r5.stop = this.input.LT(-1);
        CommonTree r13 = (CommonTree) this.adaptor.rulePostProcessing(r10);
        r5.tree = r13;
        this.adaptor.setTokenBoundaries(r13, r5.start, r5.stop);
        return r5;
    }

    public final arg_return arg() throws RecognitionException {
        arg_return r5 = new arg_return();
        r5.start = this.input.LT(1);
        CommonTree r10 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_exprNoComma_in_arg1715);
        exprNoComma_return r11 = exprNoComma();
        this.state._fsp--;
        this.adaptor.addChild(r10, r11.getTree());
        r5.stop = this.input.LT(-1);
        CommonTree r12 = (CommonTree) this.adaptor.rulePostProcessing(r10);
        r5.tree = r12;
        this.adaptor.setTokenBoundaries(r12, r5.start, r5.stop);
        return r5;
    }

    public final argExprList_return argExprList() throws RecognitionException {
        argExprList_return r5 = new argExprList_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token COMMA");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule arg");
        pushFollow(FOLLOW_arg_in_argExprList1692);
        arg_return r12 = arg();
        this.state._fsp--;
        r11.add(r12.getTree());
    L4:
        if (this.input.LA(1) != 18) goto L6;
        r10.add((CommonToken) match(this.input, 18, FOLLOW_COMMA_in_argExprList1696));
        pushFollow(FOLLOW_arg_in_argExprList1698);
        arg_return r13 = arg();
        this.state._fsp--;
        r11.add(r13.getTree());
        goto L4
    L6:
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r14 = (CommonTree) this.adaptor.nil();
        if (r11.hasNext() == false) goto L14;
    L9:
        if (r11.hasNext() == false) goto L11;
        this.adaptor.addChild(r14, r11.nextTree());
        goto L9
    L11:
        r11.reset();
        r5.tree = r14;
        r5.stop = this.input.LT(-1);
        CommonTree r15 = (CommonTree) this.adaptor.rulePostProcessing(r14);
        r5.tree = r15;
        this.adaptor.setTokenBoundaries(r15, r5.start, r5.stop);
        return r5;
    L14:
        throw new RewriteEarlyExitException();
    }

    public final args_return args() throws RecognitionException {
        args_return r5 = new args_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token COMMA");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token ELLIPSIS");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule namedArg");
        int r13 = this.input.LA(1);
        if (r13 != 25) goto L21;
        int r14 = this.input.LA(2);
        if (r14 < 13) goto L7;
        if (r14 > 15) goto L7;
    L41:
        char r15 = 1;
    L48:
        if (r15 == 1) goto L76;
        CommonTree r16 = null;
        if (r15 == 2) goto L56;
        if (r15 == 3) goto L55;
        if (r15 != 4) goto L77;
        r16 = (CommonTree) this.adaptor.nil();
    L77:
        r5.stop = this.input.LT(-1);
        CommonTree r17 = (CommonTree) this.adaptor.rulePostProcessing(r16);
        r5.tree = r17;
        this.adaptor.setTokenBoundaries(r17, r5.start, r5.stop);
        return r5;
    L55:
        r16 = (CommonTree) this.adaptor.nil();
        this.adaptor.addChild(r16, (CommonTree) this.adaptor.create((CommonToken) match(this.input, 11, FOLLOW_ELLIPSIS_in_args1679)));
        goto L77
    L56:
        pushFollow(FOLLOW_namedArg_in_args1645);
        namedArg_return r18 = namedArg();
        this.state._fsp--;
        r12.add(r18.getTree());
    L58:
        if (this.input.LA(1) != 18) goto L63;
        if (this.input.LA(2) != 25) goto L63;
        r10.add((CommonToken) match(this.input, 18, FOLLOW_COMMA_in_args1649));
        pushFollow(FOLLOW_namedArg_in_args1651);
        namedArg_return r19 = namedArg();
        this.state._fsp--;
        r12.add(r19.getTree());
    L63:
        if (this.input.LA(1) != 18) goto L65;
        r10.add((CommonToken) match(this.input, 18, FOLLOW_COMMA_in_args1657));
        r11.add((CommonToken) match(this.input, 11, FOLLOW_ELLIPSIS_in_args1659));
    L65:
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r16 = (CommonTree) this.adaptor.nil();
        if (r12.hasNext() == false) goto L75;
    L68:
        if (r12.hasNext() == false) goto L70;
        this.adaptor.addChild(r16, r12.nextTree());
        goto L68
    L70:
        r12.reset();
        if (r11.hasNext() == false) goto L73;
        this.adaptor.addChild(r16, r11.nextNode());
    L73:
        r11.reset();
        r5.tree = r16;
        goto L77
    L75:
        throw new RewriteEarlyExitException();
    L76:
        r16 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_argExprList_in_args1640);
        argExprList_return r20 = argExprList();
        this.state._fsp--;
        this.adaptor.addChild(r16, r20.getTree());
    L7:
        if (r14 < 18) goto L12;
        if (r14 <= 19) goto L41;
    L12:
        if (r14 != 12) goto L14;
        r15 = 2;
        goto L48
    L14:
        int r21 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L17
        throw new NoViableAltException("", 41, 1, this.input);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        this.input.rewind(r21);
        throw th;
    L21:
        if (r13 == 8) goto L41;
        if (r13 == 16) goto L41;
        if (r13 == 20) goto L41;
        if (r13 == 26) goto L41;
        if (r13 == 33) goto L41;
        if (r13 < 35) goto L36;
        if (r13 <= 36) goto L41;
    L36:
        if (r13 == 14) goto L38;
    L42:
        if (r13 != 11) goto L44;
        r15 = 3;
        goto L48
    L44:
        if (r13 != 15) goto L47;
        r15 = 4;
        goto L48
    L47:
        throw new NoViableAltException("", 41, 0, this.input);
    L38:
        if (this.conditional_stack.size() > 0) goto L41;
        if (this.conditional_stack.size() != 0) goto L42;
        goto L41
    }

    public final compoundElement_return compoundElement() throws RecognitionException {
        compoundElement_return r5 = new compoundElement_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);
        int r11 = 0;
        if (r10 == 31) goto L5;
        if (r10 != 23) goto L46;
        int r12 = this.input.LA(2);
        if (r12 == 4) goto L8;
        if (r12 == 33) goto L10;
        int r13 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L42
        throw new NoViableAltException("", 5, 2, this.input);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        this.input.rewind(r13);
        throw th;
    L10:
        char r14 = 2;
    L32:
        if (r14 == 1) goto L36;
        if (r14 == 2) goto L35;
        CommonTree r15 = null;
    L37:
        r5.stop = this.input.LT(-1);
        CommonTree r16 = (CommonTree) this.adaptor.rulePostProcessing(r15);
        r5.tree = r16;
        this.adaptor.setTokenBoundaries(r16, r5.start, r5.stop);
        return r5;
    L35:
        r15 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_region_in_compoundElement249);
        region_return r17 = region();
        this.state._fsp--;
        this.adaptor.addChild(r15, r17.getTree());
        goto L37
    L36:
        r15 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_ifstat_in_compoundElement244);
        ifstat_return r18 = ifstat();
        this.state._fsp--;
        this.adaptor.addChild(r15, r18.getTree());
    L8:
        r14 = 1;
        goto L32
    L46:
        throw new NoViableAltException("", 5, 0, this.input);
    L5:
        if (this.input.LA(2) != 23) goto L20;
        int r19 = this.input.LA(3);
        if (r19 == 4) goto L8;
        if (r19 == 33) goto L10;
        int r20 = this.input.mark();
    L12:
        if (r11 >= 2) goto L17;
        this.input.consume();     // Catch: Throwable -> L14
        r11 = r11 + 1;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.input.rewind(r20);
        throw th;
    L17:
        throw new NoViableAltException("", 5, 2, this.input);     // Catch: Throwable -> L14
    L20:
        int r21 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L23
        throw new NoViableAltException("", 5, 1, this.input);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        this.input.rewind(r21);
        throw th;
    }

    public final conditional_return conditional() throws RecognitionException {
        this.conditional_stack.push(new conditional_scope());
        conditional_return r5 = new conditional_return();
        r5.start = this.input.LT(1);
        CommonTree r10 = (CommonTree) this.adaptor.nil();     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_andConditional_in_conditional713);     // Catch: Throwable -> L7 RecognitionException -> L9
        andConditional_return r11 = andConditional();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.addChild(r10, r11.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
    L5:
        if (this.input.LA(1) != 29) goto L11;
        r10 = (CommonTree) this.adaptor.becomeRoot((CommonTree) this.adaptor.create((CommonToken) match(this.input, 29, FOLLOW_OR_in_conditional717)), r10);     // Catch: Throwable -> L7 RecognitionException -> L9
        pushFollow(FOLLOW_andConditional_in_conditional720);     // Catch: Throwable -> L7 RecognitionException -> L9
        andConditional_return r12 = andConditional();     // Catch: Throwable -> L7 RecognitionException -> L9
        this.state._fsp--;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.addChild(r10, r12.getTree());     // Catch: Throwable -> L7 RecognitionException -> L9
        goto L5
    L11:
        r5.stop = this.input.LT(-1);     // Catch: Throwable -> L7 RecognitionException -> L9
        CommonTree r13 = (CommonTree) this.adaptor.rulePostProcessing(r10);     // Catch: Throwable -> L7 RecognitionException -> L9
        r5.tree = r13;     // Catch: Throwable -> L7 RecognitionException -> L9
        this.adaptor.setTokenBoundaries(r13, r5.start, r5.stop);     // Catch: Throwable -> L7 RecognitionException -> L9
        this.conditional_stack.pop();
        return r5;
    L7:
        th = move-exception;
        this.conditional_stack.pop();
        throw th;
    L9:
        e = move-exception;
        throw e;     // Catch: Throwable -> L7
    }

    public final element_return element() throws RecognitionException {
        element_return r5 = new element_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token INDENT");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token NEWLINE");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token COMMENT");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule singleElement");
        int r14 = this.input.LA(1);
        if (r14 != 22) goto L5;
    L183:
        char r15 = 3;
    L184:
        CommonTree r16 = null;
        if (r15 == 1) goto L199;
        if (r15 == 2) goto L194;
        if (r15 != 3) goto L190;
        r16 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_singleElement_in_element200);
        singleElement_return r17 = singleElement();
        this.state._fsp--;
        this.adaptor.addChild(r16, r17.getTree());
    L204:
        r5.stop = this.input.LT(-1);
        CommonTree r18 = (CommonTree) this.adaptor.rulePostProcessing(r16);
        r5.tree = r18;
        this.adaptor.setTokenBoundaries(r18, r5.start, r5.stop);
        return r5;
    L190:
        if (r15 != 4) goto L204;
        r16 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_compoundElement_in_element205);
        compoundElement_return r19 = compoundElement();
        this.state._fsp--;
        this.adaptor.addChild(r16, r19.getTree());
        goto L204
    L194:
        r10.add((CommonToken) match(this.input, 31, FOLLOW_INDENT_in_element181));
        pushFollow(FOLLOW_singleElement_in_element183);
        singleElement_return r20 = singleElement();
        this.state._fsp--;
        r13.add(r20.getTree());
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r16 = (CommonTree) this.adaptor.nil();
        CommonTree r21 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r22 = this.adaptor;
        CommonTree r23 = (CommonTree) r22.becomeRoot((CommonTree) r22.create(47, "INDENTED_EXPR"), r21);
        this.adaptor.addChild(r23, r10.nextNode());
        if (r13.hasNext() == false) goto L197;
        this.adaptor.addChild(r23, r13.nextTree());
    L197:
        r13.reset();
        this.adaptor.addChild(r16, r23);
        r5.tree = r16;
        goto L204
    L199:
        if (this.input.LT(1).getCharPositionInLine() != 0) goto L207;
        if (this.input.LA(1) != 31) goto L203;
        r10.add((CommonToken) match(this.input, 31, FOLLOW_INDENT_in_element168));
    L203:
        r12.add((CommonToken) match(this.input, 37, FOLLOW_COMMENT_in_element171));
        r11.add((CommonToken) match(this.input, 32, FOLLOW_NEWLINE_in_element173));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r24 = (CommonTree) this.adaptor.nil();
        r5.tree = null;
        goto L204
    L207:
        throw new FailedPredicateException(this.input, "element", "input.LT(1).getCharPositionInLine()==0");
    L5:
        if (r14 != 23) goto L7;
        int r25 = this.input.LA(2);
        if (r25 != 4) goto L128;
    L99:
        r15 = 4;
        goto L184
    L128:
        if (r25 == 8) goto L183;
        if (r25 == 14) goto L183;
        if (r25 == 16) goto L183;
        if (r25 == 20) goto L183;
        if (r25 != 33) goto L138;
        int r26 = this.input.LA(3);
        if (r26 != 25) goto L170;
        int r27 = this.input.LA(4);
        if (r27 != 24) goto L158;
        char r28 = 4;
    L172:
        r15 = r28;
        goto L184
    L158:
        if (r27 == 14) goto L171;
        int r29 = this.input.mark();
        int r30 = 0;
    L161:
        if (r30 >= 3) goto L166;
        this.input.consume();     // Catch: Throwable -> L163
        r30 = r30 + 1;     // Catch: Throwable -> L163
    L163:
        th = move-exception;
        this.input.rewind(r29);
        throw th;
    L166:
        throw new NoViableAltException("", 3, 14, this.input);     // Catch: Throwable -> L163
    L171:
        r28 = 3;
        goto L172
    L170:
        if (r26 == 8) goto L171;
        int r31 = this.input.mark();
        int r32 = 0;
    L175:
        if (r32 >= 2) goto L180;
        this.input.consume();     // Catch: Throwable -> L177
        r32 = r32 + 1;     // Catch: Throwable -> L177
    L177:
        th = move-exception;
        this.input.rewind(r31);
        throw th;
    L180:
        throw new NoViableAltException("", 3, 10, this.input);     // Catch: Throwable -> L177
    L138:
        if (r25 == 25) goto L183;
        if (r25 == 26) goto L183;
        if (r25 == 35) goto L183;
        if (r25 == 36) goto L183;
        int r33 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L149
        throw new NoViableAltException("", 3, 3, this.input);     // Catch: Throwable -> L149
    L149:
        th = move-exception;
        this.input.rewind(r33);
        throw th;
    L7:
        if (r14 == 31) goto L30;
        if (r14 == 32) goto L183;
        if (r14 != 37) goto L29;
        int r34 = this.input.LA(2);
        if (r34 != 32) goto L15;
        this.input.LA(3);
        if (this.input.LT(1).getCharPositionInLine() != 0) goto L183;
    L14:
        r15 = 1;
        goto L184
    L15:
        if (r34 == (-1)) goto L183;
        if (r34 >= 21) goto L18;
    L19:
        if (r34 == 31) goto L183;
        if (r34 == 37) goto L183;
        int r35 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L25
        throw new NoViableAltException("", 3, 2, this.input);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        this.input.rewind(r35);
        throw th;
    L18:
        if (r34 <= 23) goto L183;
    L29:
        throw new NoViableAltException("", 3, 0, this.input);
    L30:
        int r36 = this.input.LA(2);
        if (r36 != 22) goto L33;
    L41:
        r15 = 2;
        goto L184
    L33:
        if (r36 == 23) goto L65;
        if (r36 == 32) goto L41;
        if (r36 != 37) goto L59;
        int r37 = this.input.LA(3);
        if (r37 != 32) goto L42;
        this.input.LA(4);
        if (this.input.LT(1).getCharPositionInLine() != 0) goto L41;
    L42:
        if (r37 == (-1)) goto L41;
        if (r37 >= 21) goto L45;
    L46:
        if (r37 == 31) goto L41;
        if (r37 == 37) goto L41;
        int r38 = this.input.mark();
        int r39 = 0;
    L51:
        if (r39 >= 2) goto L56;
        this.input.consume();     // Catch: Throwable -> L53
        r39 = r39 + 1;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        this.input.rewind(r38);
        throw th;
    L56:
        throw new NoViableAltException("", 3, 5, this.input);     // Catch: Throwable -> L53
    L45:
        if (r37 <= 23) goto L41;
    L59:
        int r40 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L62
        throw new NoViableAltException("", 3, 1, this.input);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        this.input.rewind(r40);
        throw th;
    L65:
        int r41 = this.input.LA(3);
        if (r41 == 4) goto L99;
        if (r41 == 8) goto L41;
        if (r41 == 14) goto L41;
        if (r41 == 16) goto L41;
        if (r41 == 20) goto L41;
        if (r41 != 33) goto L78;
        int r42 = this.input.LA(4);
        if (r42 != 25) goto L114;
        int r43 = this.input.LA(5);
        if (r43 == 24) goto L99;
        if (r43 == 14) goto L41;
        int r44 = this.input.mark();
        int r45 = 0;
    L105:
        if (r45 >= 4) goto L110;
        this.input.consume();     // Catch: Throwable -> L107
        r45 = r45 + 1;     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        this.input.rewind(r44);
        throw th;
    L110:
        throw new NoViableAltException("", 3, 15, this.input);     // Catch: Throwable -> L107
    L114:
        if (r42 == 8) goto L41;
        int r46 = this.input.mark();
        int r47 = 0;
    L117:
        if (r47 >= 3) goto L122;
        this.input.consume();     // Catch: Throwable -> L119
        r47 = r47 + 1;     // Catch: Throwable -> L119
    L119:
        th = move-exception;
        this.input.rewind(r46);
        throw th;
    L122:
        throw new NoViableAltException("", 3, 12, this.input);     // Catch: Throwable -> L119
    L78:
        if (r41 == 25) goto L41;
        if (r41 == 26) goto L41;
        if (r41 == 35) goto L41;
        if (r41 == 36) goto L41;
        int r48 = this.input.mark();
        int r49 = 0;
    L87:
        if (r49 >= 2) goto L92;
        this.input.consume();     // Catch: Throwable -> L89
        r49 = r49 + 1;     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        this.input.rewind(r48);
        throw th;
    L92:
        throw new NoViableAltException("", 3, 6, this.input);     // Catch: Throwable -> L89
    }

    public final expr_return expr() throws RecognitionException {
        expr_return r5 = new expr_return();
        r5.start = this.input.LT(1);
        CommonTree r10 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_mapExpr_in_expr1055);
        mapExpr_return r11 = mapExpr();
        this.state._fsp--;
        this.adaptor.addChild(r10, r11.getTree());
        r5.stop = this.input.LT(-1);
        CommonTree r12 = (CommonTree) this.adaptor.rulePostProcessing(r10);
        r5.tree = r12;
        this.adaptor.setTokenBoundaries(r12, r5.start, r5.stop);
        return r5;
    }

    public final exprNoComma_return exprNoComma() throws RecognitionException {
        exprNoComma_return r5 = new exprNoComma_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token COLON");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule memberExpr");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule mapTemplateRef");
        pushFollow(FOLLOW_memberExpr_in_exprNoComma1002);
        memberExpr_return r13 = memberExpr();
        this.state._fsp--;
        r11.add(r13.getTree());
        int r14 = this.input.LA(1);
        if (r14 != 13) goto L6;
        char r15 = 1;
    L17:
        CommonTree r16 = null;
        if (r15 == 1) goto L22;
        if (r15 != 2) goto L23;
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r16 = (CommonTree) this.adaptor.nil();
        this.adaptor.addChild(r16, r11.nextTree());
        r5.tree = r16;
    L23:
        r5.stop = this.input.LT(-1);
        CommonTree r17 = (CommonTree) this.adaptor.rulePostProcessing(r16);
        r5.tree = r17;
        this.adaptor.setTokenBoundaries(r17, r5.start, r5.stop);
        return r5;
    L22:
        r10.add((CommonToken) match(this.input, 13, FOLLOW_COLON_in_exprNoComma1008));
        pushFollow(FOLLOW_mapTemplateRef_in_exprNoComma1010);
        mapTemplateRef_return r18 = mapTemplateRef();
        this.state._fsp--;
        r12.add(r18.getTree());
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r16 = (CommonTree) this.adaptor.nil();
        CommonTree r19 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r20 = this.adaptor;
        CommonTree r21 = (CommonTree) r20.becomeRoot((CommonTree) r20.create(49, "MAP"), r19);
        this.adaptor.addChild(r21, r11.nextTree());
        this.adaptor.addChild(r21, r12.nextTree());
        this.adaptor.addChild(r16, r21);
        r5.tree = r16;
        goto L23
    L6:
        if (r14 != 15) goto L8;
    L16:
        r15 = 2;
        goto L17
    L8:
        if (r14 < 17) goto L12;
        if (r14 <= 18) goto L16;
    L12:
        if (r14 == 24) goto L16;
        throw new NoViableAltException("", 26, 0, this.input);
    }

    public final exprOptions_return exprOptions() throws RecognitionException {
        exprOptions_return r5 = new exprOptions_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token COMMA");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule option");
        pushFollow(FOLLOW_option_in_exprOptions850);
        option_return r12 = option();
        this.state._fsp--;
        r11.add(r12.getTree());
    L4:
        if (this.input.LA(1) != 18) goto L6;
        r10.add((CommonToken) match(this.input, 18, FOLLOW_COMMA_in_exprOptions854));
        pushFollow(FOLLOW_option_in_exprOptions856);
        option_return r13 = option();
        this.state._fsp--;
        r11.add(r13.getTree());
        goto L4
    L6:
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r14 = (CommonTree) this.adaptor.nil();
        CommonTree r15 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r16 = this.adaptor;
        CommonTree r17 = (CommonTree) r16.becomeRoot((CommonTree) r16.create(51, "OPTIONS"), r15);
    L8:
        if (r11.hasNext() == false) goto L10;
        this.adaptor.addChild(r17, r11.nextTree());
        goto L8
    L10:
        r11.reset();
        this.adaptor.addChild(r14, r17);
        r5.tree = r14;
        r5.stop = this.input.LT(-1);
        CommonTree r18 = (CommonTree) this.adaptor.rulePostProcessing(r14);
        r5.tree = r18;
        this.adaptor.setTokenBoundaries(r18, r5.start, r5.stop);
        return r5;
    }

    public final exprTag_return exprTag() throws RecognitionException {
        exprTag_return r5 = new exprTag_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token RDELIM");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token SEMI");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token LDELIM");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule exprOptions");
        RewriteRuleSubtreeStream r14 = new RewriteRuleSubtreeStream(this.adaptor, "rule expr");
        CommonToken r15 = (CommonToken) match(this.input, 23, FOLLOW_LDELIM_in_exprTag260);
        r12.add(r15);
        pushFollow(FOLLOW_expr_in_exprTag262);
        expr_return r16 = expr();
        this.state._fsp--;
        r14.add(r16.getTree());
        if (this.input.LA(1) != 9) goto L5;
        r11.add((CommonToken) match(this.input, 9, FOLLOW_SEMI_in_exprTag266));
        pushFollow(FOLLOW_exprOptions_in_exprTag268);
        exprOptions_return r17 = exprOptions();
        this.state._fsp--;
        r13.add(r17.getTree());
    L5:
        r10.add((CommonToken) match(this.input, 24, FOLLOW_RDELIM_in_exprTag273));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r18 = (CommonTree) this.adaptor.nil();
        CommonTree r19 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r20 = this.adaptor;
        CommonTree r21 = (CommonTree) r20.becomeRoot((CommonTree) r20.create(41, r15, "EXPR"), r19);
        this.adaptor.addChild(r21, r14.nextTree());
        if (r13.hasNext() == false) goto L8;
        this.adaptor.addChild(r21, r13.nextTree());
    L8:
        r13.reset();
        this.adaptor.addChild(r18, r21);
        r5.tree = r18;
        r5.stop = this.input.LT(-1);
        CommonTree r22 = (CommonTree) this.adaptor.rulePostProcessing(r18);
        r5.tree = r22;
        this.adaptor.setTokenBoundaries(r22, r5.start, r5.stop);
        return r5;
    }

    public Parser[] getDelegates() {
        return new Parser[0];
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getGrammarFileName() {
        return "org\\stringtemplate\\v4\\compiler\\STParser.g";
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String[] getTokenNames() {
        return tokenNames;
    }

    public TreeAdaptor getTreeAdaptor() {
        return this.adaptor;
    }

    public final ifstat_return ifstat() throws RecognitionException {
        ifstat_return r5 = new ifstat_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token INDENT");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token RDELIM");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token ELSEIF");
        RewriteRuleTokenStream r13 = new RewriteRuleTokenStream(this.adaptor, "token NEWLINE");
        RewriteRuleTokenStream r14 = new RewriteRuleTokenStream(this.adaptor, "token LPAREN");
        RewriteRuleTokenStream r15 = new RewriteRuleTokenStream(this.adaptor, "token ENDIF");
        RewriteRuleTokenStream r16 = new RewriteRuleTokenStream(this.adaptor, "token ELSE");
        RewriteRuleTokenStream r17 = new RewriteRuleTokenStream(this.adaptor, "token RPAREN");
        RewriteRuleTokenStream r18 = new RewriteRuleTokenStream(this.adaptor, "token LDELIM");
        RewriteRuleTokenStream r19 = new RewriteRuleTokenStream(this.adaptor, "token IF");
        RewriteRuleSubtreeStream r110 = new RewriteRuleSubtreeStream(this.adaptor, "rule template");
        RewriteRuleSubtreeStream r111 = new RewriteRuleSubtreeStream(this.adaptor, "rule conditional");
        if (this.input.LA(1) != 31) goto L5;
        CommonToken r20 = (CommonToken) match(this.input, 31, FOLLOW_INDENT_in_ifstat491);
        r10.add(r20);
    L6:
        CommonToken r112 = r20;
        r18.add((CommonToken) match(this.input, 23, FOLLOW_LDELIM_in_ifstat494));
        r19.add((CommonToken) match(this.input, 4, FOLLOW_IF_in_ifstat496));
        r14.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_ifstat498));
        pushFollow(FOLLOW_conditional_in_ifstat502);
        conditional_return r21 = conditional();
        this.state._fsp--;
        r111.add(r21.getTree());
        r17.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_ifstat504));
        r11.add((CommonToken) match(this.input, 24, FOLLOW_RDELIM_in_ifstat506));
        if (this.input.LA(1) == 32) goto L9;
        CommonToken r22 = r112;
    L10:
        pushFollow(FOLLOW_template_in_ifstat515);
        template_return r113 = template();
        CommonToken r23 = r22;
        int r24 = 1;
        this.state._fsp--;
        r110.add(r113.getTree());
        ArrayList r25 = null;
        ArrayList r114 = null;
    L11:
        int r115 = this.input.LA(r24);
        if (r115 == 31) goto L14;
        ifstat_return r26 = r5;
        if (r115 != 23) goto L33;
        if (this.input.LA(2) != 6) goto L33;
    L24:
        if (this.input.LA(1) != 31) goto L26;
        r10.add((CommonToken) match(this.input, 31, FOLLOW_INDENT_in_ifstat522));
    L26:
        r18.add((CommonToken) match(this.input, 23, FOLLOW_LDELIM_in_ifstat525));
        r12.add((CommonToken) match(this.input, 6, FOLLOW_ELSEIF_in_ifstat527));
        r14.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_ifstat529));
        pushFollow(FOLLOW_conditional_in_ifstat533);
        conditional_return r27 = conditional();
        this.state._fsp--;
        r111.add(r27.getTree());
        if (r25 != null) goto L29;
        r25 = new ArrayList();
    L29:
        r25.add(r27.getTree());
        r17.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_ifstat535));
        r11.add((CommonToken) match(this.input, 24, FOLLOW_RDELIM_in_ifstat537));
        pushFollow(FOLLOW_template_in_ifstat541);
        template_return r28 = template();
        this.state._fsp--;
        r110.add(r28.getTree());
        if (r114 != null) goto L32;
        r114 = new ArrayList();
    L32:
        r114.add(r28.getTree());
        r5 = r26;
        r24 = 1;
    L33:
        int r29 = this.input.LA(1);
        if (r29 != 31) goto L41;
        if (this.input.LA(2) == 23) goto L38;
    L48:
        template_return r30 = null;
    L50:
        if (this.input.LA(1) != 31) goto L52;
        r10.add((CommonToken) match(this.input, 31, FOLLOW_INDENT_in_ifstat570));
    L52:
        r18.add((CommonToken) match(this.input, 23, FOLLOW_LDELIM_in_ifstat576));
        r15.add((CommonToken) match(this.input, 7, FOLLOW_ENDIF_in_ifstat578));
        r11.add((CommonToken) match(this.input, 24, FOLLOW_RDELIM_in_ifstat582));
        if (this.input.LA(1) != 32) goto L62;
        this.input.LA(2);
        ifstat_return r31 = r26;
        if (((CommonToken) r31.start).getLine() == this.input.LT(1).getLine()) goto L63;
        if (((CommonToken) r31.start).getLine() == this.input.LT(1).getLine()) goto L61;
        r13.add((CommonToken) match(this.input, 32, FOLLOW_NEWLINE_in_ifstat593));
        goto L63
    L61:
        throw new FailedPredicateException(this.input, "ifstat", "$ifstat.start.getLine()!=input.LT(1).getLine()");
    L63:
        r31.tree = null;
        RewriteRuleTokenStream r32 = new RewriteRuleTokenStream(this.adaptor, "token i", r112);
        RewriteRuleSubtreeStream r33 = new RewriteRuleSubtreeStream(this.adaptor, "rule t1", r113.getTree());
        RewriteRuleSubtreeStream r34 = new RewriteRuleSubtreeStream(this.adaptor, "rule c1", r21.getTree());
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r31.getTree());
        TreeAdaptor r116 = this.adaptor;
        if (r30 == null) goto L66;
        Object r35 = r30.getTree();
    L67:
        RewriteRuleSubtreeStream r117 = new RewriteRuleSubtreeStream(r116, "rule t3", r35);
        RewriteRuleSubtreeStream r36 = new RewriteRuleSubtreeStream(this.adaptor, "token t2", r114);
        RewriteRuleSubtreeStream r37 = new RewriteRuleSubtreeStream(this.adaptor, "token c2", r25);
        CommonTree r38 = (CommonTree) this.adaptor.nil();
        if (r23 == null) goto L90;
        CommonTree r118 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r119 = this.adaptor;
        CommonTree r120 = (CommonTree) r119.becomeRoot((CommonTree) r119.create(47, "INDENTED_EXPR"), r118);
        this.adaptor.addChild(r120, r32.nextNode());
        CommonTree r39 = (CommonTree) this.adaptor.becomeRoot(r19.nextNode(), (CommonTree) this.adaptor.nil());
        this.adaptor.addChild(r39, r34.nextTree());
        if (r33.hasNext() == false) goto L72;
        this.adaptor.addChild(r39, r33.nextTree());
    L72:
        r33.reset();
    L74:
        if (r12.hasNext() == true) goto L89;
        if (r37.hasNext() == true) goto L89;
        if (r36.hasNext() == true) goto L89;
        r12.reset();
        r37.reset();
        r36.reset();
        if (r117.hasNext() == false) goto L83;
    L84:
        CommonTree r40 = (CommonTree) this.adaptor.becomeRoot(r16.nextNode(), (CommonTree) this.adaptor.nil());
        if (r117.hasNext() == false) goto L87;
        this.adaptor.addChild(r40, r117.nextTree());
    L87:
        r117.reset();
        this.adaptor.addChild(r39, r40);
    L88:
        r117.reset();
        r16.reset();
        this.adaptor.addChild(r120, r39);
        this.adaptor.addChild(r38, r120);
    L110:
        r31.tree = r38;
        r31.stop = this.input.LT(-1);
        CommonTree r41 = (CommonTree) this.adaptor.rulePostProcessing(r38);
        r31.tree = r41;
        this.adaptor.setTokenBoundaries(r41, r31.start, r31.stop);
        return r31;
    L83:
        if (r16.hasNext() == false) goto L88;
    L89:
        CommonTree r42 = (CommonTree) this.adaptor.becomeRoot(r12.nextNode(), (CommonTree) this.adaptor.nil());
        this.adaptor.addChild(r42, r37.nextTree());
        this.adaptor.addChild(r42, r36.nextTree());
        this.adaptor.addChild(r39, r42);
        goto L74
    L90:
        CommonTree r43 = (CommonTree) this.adaptor.becomeRoot(r19.nextNode(), (CommonTree) this.adaptor.nil());
        this.adaptor.addChild(r43, r34.nextTree());
        if (r33.hasNext() == false) goto L93;
        this.adaptor.addChild(r43, r33.nextTree());
    L93:
        r33.reset();
    L95:
        if (r36.hasNext() == true) goto L112;
        if (r12.hasNext() == true) goto L112;
        if (r37.hasNext() == true) goto L112;
        r36.reset();
        r12.reset();
        r37.reset();
        if (r16.hasNext() == false) goto L104;
    L105:
        CommonTree r44 = (CommonTree) this.adaptor.becomeRoot(r16.nextNode(), (CommonTree) this.adaptor.nil());
        if (r117.hasNext() == false) goto L108;
        this.adaptor.addChild(r44, r117.nextTree());
    L108:
        r117.reset();
        this.adaptor.addChild(r43, r44);
    L109:
        r16.reset();
        r117.reset();
        this.adaptor.addChild(r38, r43);
        goto L110
    L104:
        if (r117.hasNext() == false) goto L109;
    L112:
        CommonTree r45 = (CommonTree) this.adaptor.becomeRoot(r12.nextNode(), (CommonTree) this.adaptor.nil());
        this.adaptor.addChild(r45, r37.nextTree());
        this.adaptor.addChild(r45, r36.nextTree());
        this.adaptor.addChild(r43, r45);
        goto L95
    L66:
        r35 = null;
        goto L67
    L62:
        r31 = r26;
        goto L63
    L38:
        if (this.input.LA(3) != 5) goto L48;
    L45:
        if (this.input.LA(1) != 31) goto L47;
        r10.add((CommonToken) match(this.input, 31, FOLLOW_INDENT_in_ifstat551));
    L47:
        r18.add((CommonToken) match(this.input, 23, FOLLOW_LDELIM_in_ifstat554));
        r16.add((CommonToken) match(this.input, 5, FOLLOW_ELSE_in_ifstat556));
        r11.add((CommonToken) match(this.input, 24, FOLLOW_RDELIM_in_ifstat558));
        pushFollow(FOLLOW_template_in_ifstat562);
        r30 = template();
        this.state._fsp--;
        r110.add(r30.getTree());
        goto L50
    L41:
        if (r29 != 23) goto L48;
        if (this.input.LA(2) != 5) goto L48;
    L14:
        if (this.input.LA(2) != 23) goto L18;
        if (this.input.LA(3) != 6) goto L18;
        r26 = r5;
    L18:
        r26 = r5;
        goto L33
    L9:
        r22 = null;
        goto L10
    L5:
        r20 = null;
        goto L6
    }

    public final includeExpr_return includeExpr() throws RecognitionException {
        includeExpr_return r5 = new includeExpr_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token SUPER");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token AT");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token LPAREN");
        RewriteRuleTokenStream r13 = new RewriteRuleTokenStream(this.adaptor, "token DOT");
        RewriteRuleTokenStream r14 = new RewriteRuleTokenStream(this.adaptor, "token RPAREN");
        RewriteRuleTokenStream r15 = new RewriteRuleTokenStream(this.adaptor, "token ID");
        RewriteRuleSubtreeStream r16 = new RewriteRuleSubtreeStream(this.adaptor, "rule args");
        RewriteRuleSubtreeStream r17 = new RewriteRuleSubtreeStream(this.adaptor, "rule expr");
        int r18 = this.input.LA(1);
        char r19 = 3;
        char r110 = 2;
        if (r18 != 25) goto L34;
        int r111 = this.input.LA(2);
        if (r111 != 14) goto L11;
        this.input.LA(3);
        if (Compiler.funcs.containsKey(this.input.LT(1).getText()) == false) goto L9;
        r19 = 1;
    L9:
        r110 = r19;
    L67:
        CommonTree r112 = null;
        switch(r110) {
            case 1: goto L82;
            case 2: goto L77;
            case 3: goto L73;
            case 4: goto L72;
            case 5: goto L71;
            case 6: goto L70;
            default: goto L110;
        };
    L70:
        r112 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_primary_in_includeExpr1508);
        primary_return r20 = primary();
        this.state._fsp--;
        this.adaptor.addChild(r112, r20.getTree());
        goto L110
    L71:
        r11.add((CommonToken) match(this.input, 33, FOLLOW_AT_in_includeExpr1482));
        r15.add((CommonToken) match(this.input, 25, FOLLOW_ID_in_includeExpr1484));
        r12.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_includeExpr1486));
        r14.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_includeExpr1490));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r112 = (CommonTree) this.adaptor.nil();
        CommonTree r21 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r22 = this.adaptor;
        CommonTree r23 = (CommonTree) r22.becomeRoot((CommonTree) r22.create(44, "INCLUDE_REGION"), r21);
        this.adaptor.addChild(r23, r15.nextNode());
        this.adaptor.addChild(r112, r23);
        r5.tree = r112;
        goto L110
    L72:
        r11.add((CommonToken) match(this.input, 33, FOLLOW_AT_in_includeExpr1455));
        r10.add((CommonToken) match(this.input, 8, FOLLOW_SUPER_in_includeExpr1457));
        r13.add((CommonToken) match(this.input, 19, FOLLOW_DOT_in_includeExpr1459));
        r15.add((CommonToken) match(this.input, 25, FOLLOW_ID_in_includeExpr1461));
        r12.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_includeExpr1463));
        r14.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_includeExpr1467));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r112 = (CommonTree) this.adaptor.nil();
        CommonTree r24 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r25 = this.adaptor;
        CommonTree r26 = (CommonTree) r25.becomeRoot((CommonTree) r25.create(46, "INCLUDE_SUPER_REGION"), r24);
        this.adaptor.addChild(r26, r15.nextNode());
        this.adaptor.addChild(r112, r26);
        r5.tree = r112;
        goto L110
    L73:
        r15.add((CommonToken) match(this.input, 25, FOLLOW_ID_in_includeExpr1427));
        r12.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_includeExpr1429));
        pushFollow(FOLLOW_args_in_includeExpr1431);
        args_return r27 = args();
        this.state._fsp--;
        r16.add(r27.getTree());
        r14.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_includeExpr1433));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r112 = (CommonTree) this.adaptor.nil();
        CommonTree r28 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r29 = this.adaptor;
        CommonTree r30 = (CommonTree) r29.becomeRoot((CommonTree) r29.create(42, "INCLUDE"), r28);
        this.adaptor.addChild(r30, r15.nextNode());
        if (r16.hasNext() == false) goto L76;
        this.adaptor.addChild(r30, r16.nextTree());
    L76:
        r16.reset();
        this.adaptor.addChild(r112, r30);
        r5.tree = r112;
        goto L110
    L77:
        r10.add((CommonToken) match(this.input, 8, FOLLOW_SUPER_in_includeExpr1398));
        r13.add((CommonToken) match(this.input, 19, FOLLOW_DOT_in_includeExpr1400));
        r15.add((CommonToken) match(this.input, 25, FOLLOW_ID_in_includeExpr1402));
        r12.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_includeExpr1404));
        pushFollow(FOLLOW_args_in_includeExpr1406);
        args_return r31 = args();
        this.state._fsp--;
        r16.add(r31.getTree());
        r14.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_includeExpr1408));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r112 = (CommonTree) this.adaptor.nil();
        CommonTree r32 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r33 = this.adaptor;
        CommonTree r34 = (CommonTree) r33.becomeRoot((CommonTree) r33.create(45, "INCLUDE_SUPER"), r32);
        this.adaptor.addChild(r34, r15.nextNode());
        if (r16.hasNext() == false) goto L80;
        this.adaptor.addChild(r34, r16.nextTree());
    L80:
        r16.reset();
        this.adaptor.addChild(r112, r34);
        r5.tree = r112;
    L110:
        r5.stop = this.input.LT(-1);
        CommonTree r35 = (CommonTree) this.adaptor.rulePostProcessing(r112);
        r5.tree = r35;
        this.adaptor.setTokenBoundaries(r35, r5.start, r5.stop);
        return r5;
    L82:
        if (Compiler.funcs.containsKey(this.input.LT(1).getText()) == false) goto L113;
        r15.add((CommonToken) match(this.input, 25, FOLLOW_ID_in_includeExpr1370));
        r12.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_includeExpr1372));
        int r36 = this.input.LA(1);
        if (r36 != 8) goto L86;
    L105:
        pushFollow(FOLLOW_expr_in_includeExpr1374);
        expr_return r37 = expr();
        this.state._fsp--;
        r17.add(r37.getTree());
    L106:
        r14.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_includeExpr1377));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r112 = (CommonTree) this.adaptor.nil();
        CommonTree r38 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r39 = this.adaptor;
        CommonTree r40 = (CommonTree) r39.becomeRoot((CommonTree) r39.create(40, "EXEC_FUNC"), r38);
        this.adaptor.addChild(r40, r15.nextNode());
        if (r17.hasNext() == false) goto L109;
        this.adaptor.addChild(r40, r17.nextTree());
    L109:
        r17.reset();
        this.adaptor.addChild(r112, r40);
        r5.tree = r112;
        goto L110
    L86:
        if (r36 == 16) goto L105;
        if (r36 == 20) goto L105;
        if (r36 < 25) goto L93;
        if (r36 <= 26) goto L105;
    L93:
        if (r36 == 33) goto L105;
        if (r36 < 35) goto L100;
        if (r36 <= 36) goto L105;
    L100:
        if (r36 != 14) goto L106;
        if (this.conditional_stack.size() > 0) goto L105;
        if (this.conditional_stack.size() != 0) goto L106;
    L113:
        throw new FailedPredicateException(this.input, "includeExpr", "Compiler.funcs.containsKey(input.LT(1).getText())");
    L11:
        if (r111 != 9) goto L13;
    L66:
        r110 = 6;
        goto L67
    L13:
        if (r111 == 13) goto L66;
        if (r111 == 15) goto L66;
        if (r111 < 17) goto L21;
        if (r111 <= 19) goto L66;
    L21:
        if (r111 == 24) goto L66;
        if (r111 >= 29) goto L25;
    L27:
        int r41 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L30
        throw new NoViableAltException("", 35, 1, this.input);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        this.input.rewind(r41);
        throw th;
    L25:
        if (r111 > 30) goto L27;
    L34:
        if (r18 == 8) goto L67;
        if (r18 != 33) goto L51;
        int r113 = this.input.LA(2);
        if (r113 != 8) goto L42;
        char r114 = 4;
    L41:
        r110 = r114;
        goto L67
    L42:
        if (r113 != 25) goto L44;
        r114 = 5;
        goto L41
    L44:
        int r42 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L47
        throw new NoViableAltException("", 35, 3, this.input);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        this.input.rewind(r42);
        throw th;
    L51:
        if (r18 == 16) goto L66;
        if (r18 == 20) goto L66;
        if (r18 == 26) goto L66;
        if (r18 < 35) goto L62;
        if (r18 <= 36) goto L66;
    L62:
        if (r18 != 14) goto L66;
        if (this.conditional_stack.size() > 0) goto L66;
        this.conditional_stack.size();
        goto L66
    }

    public final list_return list() throws RecognitionException {
        list_return r5 = new list_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token COMMA");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token RBRACK");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token LBRACK");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule listElement");
        if (this.input.LA(1) != 16) goto L56;
        int r14 = this.input.LA(2);
        if (r14 != 17) goto L10;
        this.input.LA(3);
        if (this.input.LA(2) != 17) goto L34;
        char r15 = 1;
    L35:
        CommonTree r16 = null;
        if (r15 == 1) goto L49;
        if (r15 != 2) goto L51;
        CommonToken r17 = (CommonToken) match(this.input, 16, FOLLOW_LBRACK_in_list1767);
        r12.add(r17);
        pushFollow(FOLLOW_listElement_in_list1769);
        listElement_return r18 = listElement();
        this.state._fsp--;
        r13.add(r18.getTree());
    L41:
        if (this.input.LA(1) != 18) goto L43;
        r10.add((CommonToken) match(this.input, 18, FOLLOW_COMMA_in_list1773));
        pushFollow(FOLLOW_listElement_in_list1775);
        listElement_return r19 = listElement();
        this.state._fsp--;
        r13.add(r19.getTree());
        goto L41
    L43:
        r11.add((CommonToken) match(this.input, 17, FOLLOW_RBRACK_in_list1780));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r16 = (CommonTree) this.adaptor.nil();
        CommonTree r20 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r21 = this.adaptor;
        CommonTree r22 = (CommonTree) r21.becomeRoot((CommonTree) r21.create(48, r17), r20);
    L45:
        if (r13.hasNext() == false) goto L47;
        this.adaptor.addChild(r22, r13.nextTree());
        goto L45
    L47:
        r13.reset();
        this.adaptor.addChild(r16, r22);
        r5.tree = r16;
    L51:
        r5.stop = this.input.LT(-1);
        CommonTree r23 = (CommonTree) this.adaptor.rulePostProcessing(r16);
        r5.tree = r23;
        this.adaptor.setTokenBoundaries(r23, r5.start, r5.stop);
        return r5;
    L49:
        if (this.input.LA(2) != 17) goto L54;
        CommonToken r24 = (CommonToken) match(this.input, 16, FOLLOW_LBRACK_in_list1753);
        r12.add(r24);
        r11.add((CommonToken) match(this.input, 17, FOLLOW_RBRACK_in_list1755));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r16 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r25 = this.adaptor;
        r25.addChild(r16, (CommonTree) r25.create(48, r24));
        r5.tree = r16;
        goto L51
    L54:
        throw new FailedPredicateException(this.input, "list", "input.LA(2)==RBRACK");
    L34:
        r15 = 2;
        goto L35
    L10:
        if (r14 == 8) goto L34;
        if (r14 == 14) goto L34;
        if (r14 == 16) goto L34;
        if (r14 == 18) goto L34;
        if (r14 == 20) goto L34;
        if (r14 < 25) goto L22;
        if (r14 <= 26) goto L34;
    L22:
        if (r14 == 33) goto L34;
        if (r14 >= 35) goto L26;
    L28:
        int r26 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L31
        throw new NoViableAltException("", 44, 1, this.input);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        this.input.rewind(r26);
        throw th;
    L26:
        if (r14 > 36) goto L28;
    L56:
        throw new NoViableAltException("", 44, 0, this.input);
    }

    public final listElement_return listElement() throws RecognitionException {
        listElement_return r5 = new listElement_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);
        if (r10 != 8) goto L5;
    L25:
        char r11 = 1;
    L33:
        if (r11 == 1) goto L38;
        CommonTree r12 = null;
        if (r11 != 2) goto L39;
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r12 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r13 = this.adaptor;
        r13.addChild(r12, (CommonTree) r13.create(50, "NULL"));
        r5.tree = r12;
    L39:
        r5.stop = this.input.LT(-1);
        CommonTree r14 = (CommonTree) this.adaptor.rulePostProcessing(r12);
        r5.tree = r14;
        this.adaptor.setTokenBoundaries(r14, r5.start, r5.stop);
        return r5;
    L38:
        CommonTree r15 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_exprNoComma_in_listElement1800);
        exprNoComma_return r16 = exprNoComma();
        this.state._fsp--;
        this.adaptor.addChild(r15, r16.getTree());
        r12 = r15;
        goto L39
    L5:
        if (r10 == 16) goto L25;
        if (r10 == 20) goto L25;
        if (r10 < 25) goto L13;
        if (r10 <= 26) goto L25;
    L13:
        if (r10 == 33) goto L25;
        if (r10 < 35) goto L20;
        if (r10 <= 36) goto L25;
    L20:
        if (r10 != 14) goto L27;
        if (this.conditional_stack.size() > 0) goto L25;
        if (this.conditional_stack.size() == 0) goto L25;
    L27:
        if (r10 < 17) goto L32;
        if (r10 > 18) goto L32;
        r11 = 2;
    L32:
        throw new NoViableAltException("", 45, 0, this.input);
    }

    public final mapExpr_return mapExpr() throws RecognitionException {
        mapExpr_return r5 = new mapExpr_return();
        int r10 = 1;
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token COMMA");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token COLON");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule memberExpr");
        RewriteRuleSubtreeStream r14 = new RewriteRuleSubtreeStream(this.adaptor, "rule mapTemplateRef");
        pushFollow(FOLLOW_memberExpr_in_mapExpr1067);
        memberExpr_return r15 = memberExpr();
        this.state._fsp--;
        r13.add(r15.getTree());
        int r16 = this.input.LA(1);
        int r17 = 0;
        int r18 = 13;
        if (r16 != 18) goto L6;
        char r19 = 1;
    L16:
        ArrayList r110 = null;
        if (r19 == 1) goto L21;
        if (r19 == 2) goto L20;
        CommonToken r20 = null;
        CommonTree r21 = null;
    L33:
        if (this.input.LA(r10) != r18) goto L55;
        if (r110 == null) goto L36;
        r110.clear();
    L36:
        CommonToken r22 = (CommonToken) match(this.input, r18, FOLLOW_COLON_in_mapExpr1149);
        r12.add(r22);
        pushFollow(FOLLOW_mapTemplateRef_in_mapExpr1153);
        mapTemplateRef_return r23 = mapTemplateRef();
        this.state._fsp -= r10;
        r14.add(r23.getTree());
        if (r110 != null) goto L39;
        r110 = new ArrayList();
    L39:
        r110.add(r23.getTree());
    L41:
        if (this.input.LA(r10) != 18) goto L47;
        if (r20 != null) goto L47;
        if (r20 != null) goto L46;
        r11.add((CommonToken) match(this.input, 18, FOLLOW_COMMA_in_mapExpr1159));
        pushFollow(FOLLOW_mapTemplateRef_in_mapExpr1163);
        mapTemplateRef_return r24 = mapTemplateRef();
        this.state._fsp -= r10;
        r14.add(r24.getTree());
        r110.add(r24.getTree());
        goto L41
    L46:
        throw new FailedPredicateException(this.input, "mapExpr", "$c==null");
    L47:
        r5.tree = r21;
        RewriteRuleSubtreeStream r25 = new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        RewriteRuleSubtreeStream r26 = new RewriteRuleSubtreeStream(this.adaptor, "token x", r110);
        CommonTree r111 = (CommonTree) this.adaptor.nil();
        CommonTree r112 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r27 = this.adaptor;
        CommonTree r28 = (CommonTree) r27.becomeRoot((CommonTree) r27.create(49, r22), r112);
        this.adaptor.addChild(r28, r25.nextTree());
        if (r26.hasNext() == false) goto L54;
    L50:
        if (r26.hasNext() == false) goto L52;
        this.adaptor.addChild(r28, r26.nextTree());
        goto L50
    L52:
        r26.reset();
        this.adaptor.addChild(r111, r28);
        r5.tree = r111;
        r21 = r111;
        r10 = 1;
        r18 = 13;
        goto L33
    L54:
        throw new RewriteEarlyExitException();
    L55:
        r5.stop = this.input.LT(-1);
        CommonTree r29 = (CommonTree) this.adaptor.rulePostProcessing(r21);
        r5.tree = r29;
        this.adaptor.setTokenBoundaries(r29, r5.start, r5.stop);
        return r5;
    L20:
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r21 = (CommonTree) this.adaptor.nil();
        this.adaptor.addChild(r21, r13.nextTree());
        r5.tree = r21;
        r20 = null;
        goto L33
    L21:
        CommonToken r30 = null;
    L23:
        if (this.input.LA(1) != 18) goto L25;
        r30 = (CommonToken) match(this.input, 18, FOLLOW_COMMA_in_mapExpr1076);
        r11.add(r30);
        pushFollow(FOLLOW_memberExpr_in_mapExpr1078);
        memberExpr_return r31 = memberExpr();
        this.state._fsp--;
        r13.add(r31.getTree());
        r17 = r17 + 1;
        goto L23
    L25:
        if (r17 < 1) goto L60;
        CommonToken r32 = (CommonToken) match(this.input, 13, FOLLOW_COLON_in_mapExpr1084);
        r12.add(r32);
        pushFollow(FOLLOW_mapTemplateRef_in_mapExpr1086);
        mapTemplateRef_return r33 = mapTemplateRef();
        this.state._fsp--;
        r14.add(r33.getTree());
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r34 = (CommonTree) this.adaptor.nil();
        CommonTree r113 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r114 = this.adaptor;
        CommonTree r35 = (CommonTree) r114.becomeRoot((CommonTree) r114.create(57, r32), r113);
        CommonTree r115 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r116 = this.adaptor;
        CommonTree r117 = (CommonTree) r116.becomeRoot((CommonTree) r116.create(39, "ELEMENTS"), r115);
        if (r13.hasNext() == false) goto L58;
    L29:
        if (r13.hasNext() == false) goto L31;
        this.adaptor.addChild(r117, r13.nextTree());
        goto L29
    L31:
        r13.reset();
        this.adaptor.addChild(r35, r117);
        this.adaptor.addChild(r35, r14.nextTree());
        this.adaptor.addChild(r34, r35);
        r5.tree = r34;
        r20 = r30;
        r21 = r34;
        r110 = null;
        goto L33
    L58:
        throw new RewriteEarlyExitException();
    L60:
        throw new EarlyExitException(27, this.input);
    L6:
        if (r16 == 9) goto L15;
        if (r16 == 13) goto L15;
        if (r16 == 15) goto L15;
        if (r16 == 24) goto L15;
        throw new NoViableAltException("", 28, 0, this.input);
    L15:
        r19 = 2;
        goto L16
    }

    public final mapTemplateRef_return mapTemplateRef() throws RecognitionException {
        mapTemplateRef_return r5 = new mapTemplateRef_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token LPAREN");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token RPAREN");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token ID");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule args");
        RewriteRuleSubtreeStream r14 = new RewriteRuleSubtreeStream(this.adaptor, "rule argExprList");
        RewriteRuleSubtreeStream r15 = new RewriteRuleSubtreeStream(this.adaptor, "rule mapExpr");
        int r16 = this.input.LA(1);
        if (r16 == 14) goto L10;
        if (r16 == 20) goto L9;
        if (r16 != 25) goto L8;
        char r17 = 1;
    L11:
        CommonTree r18 = null;
        if (r17 == 1) goto L44;
        if (r17 == 2) goto L43;
        if (r17 != 3) goto L48;
        r10.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_mapTemplateRef1245));
        pushFollow(FOLLOW_mapExpr_in_mapTemplateRef1247);
        mapExpr_return r19 = mapExpr();
        this.state._fsp--;
        r15.add(r19.getTree());
        r11.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_mapTemplateRef1251));
        r10.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_mapTemplateRef1253));
        int r20 = this.input.LA(1);
        if (r20 != 8) goto L19;
    L38:
        pushFollow(FOLLOW_argExprList_in_mapTemplateRef1255);
        argExprList_return r21 = argExprList();
        this.state._fsp--;
        r14.add(r21.getTree());
    L39:
        r11.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_mapTemplateRef1258));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r18 = (CommonTree) this.adaptor.nil();
        CommonTree r22 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r23 = this.adaptor;
        CommonTree r24 = (CommonTree) r23.becomeRoot((CommonTree) r23.create(43, "INCLUDE_IND"), r22);
        this.adaptor.addChild(r24, r15.nextTree());
        if (r14.hasNext() == false) goto L42;
        this.adaptor.addChild(r24, r14.nextTree());
    L42:
        r14.reset();
        this.adaptor.addChild(r18, r24);
        r5.tree = r18;
        goto L48
    L19:
        if (r20 == 16) goto L38;
        if (r20 == 20) goto L38;
        if (r20 < 25) goto L27;
        if (r20 <= 26) goto L38;
    L27:
        if (r20 == 33) goto L38;
        if (r20 >= 35) goto L31;
    L33:
        if (r20 != 14) goto L39;
        if (this.conditional_stack.size() > 0) goto L38;
        if (this.conditional_stack.size() != 0) goto L39;
    L31:
        if (r20 > 36) goto L33;
    L48:
        r5.stop = this.input.LT(-1);
        CommonTree r25 = (CommonTree) this.adaptor.rulePostProcessing(r18);
        r5.tree = r25;
        this.adaptor.setTokenBoundaries(r25, r5.start, r5.stop);
        return r5;
    L43:
        r18 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_subtemplate_in_mapTemplateRef1238);
        subtemplate_return r26 = subtemplate();
        this.state._fsp--;
        this.adaptor.addChild(r18, r26.getTree());
        goto L48
    L44:
        r12.add((CommonToken) match(this.input, 25, FOLLOW_ID_in_mapTemplateRef1210));
        r10.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_mapTemplateRef1212));
        pushFollow(FOLLOW_args_in_mapTemplateRef1214);
        args_return r27 = args();
        this.state._fsp--;
        r13.add(r27.getTree());
        r11.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_mapTemplateRef1216));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r18 = (CommonTree) this.adaptor.nil();
        CommonTree r28 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r29 = this.adaptor;
        CommonTree r30 = (CommonTree) r29.becomeRoot((CommonTree) r29.create(42, "INCLUDE"), r28);
        this.adaptor.addChild(r30, r12.nextNode());
        if (r13.hasNext() == false) goto L47;
        this.adaptor.addChild(r30, r13.nextTree());
    L47:
        r13.reset();
        this.adaptor.addChild(r18, r30);
        r5.tree = r18;
        goto L48
    L8:
        throw new NoViableAltException("", 32, 0, this.input);
    L9:
        r17 = 2;
        goto L11
    L10:
        r17 = 3;
        goto L11
    }

    public final memberExpr_return memberExpr() throws RecognitionException {
        memberExpr_return r5 = new memberExpr_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token DOT");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token LPAREN");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token RPAREN");
        RewriteRuleTokenStream r13 = new RewriteRuleTokenStream(this.adaptor, "token ID");
        RewriteRuleSubtreeStream r14 = new RewriteRuleSubtreeStream(this.adaptor, "rule includeExpr");
        RewriteRuleSubtreeStream r15 = new RewriteRuleSubtreeStream(this.adaptor, "rule mapExpr");
        pushFollow(FOLLOW_includeExpr_in_memberExpr1281);
        includeExpr_return r16 = includeExpr();
        this.state._fsp--;
        r14.add(r16.getTree());
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r17 = (CommonTree) this.adaptor.nil();
        this.adaptor.addChild(r17, r14.nextTree());
        r5.tree = r17;
    L4:
        if (this.input.LA(1) != 19) goto L10;
        int r18 = this.input.LA(2);
        if (r18 != 25) goto L8;
        char r19 = 1;
    L11:
        if (r19 == 1) goto L17;
        if (r19 != 2) goto L13;
        CommonToken r20 = (CommonToken) match(this.input, 19, FOLLOW_DOT_in_memberExpr1320);
        r10.add(r20);
        r11.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_memberExpr1322));
        pushFollow(FOLLOW_mapExpr_in_memberExpr1324);
        mapExpr_return r110 = mapExpr();
        this.state._fsp--;
        r15.add(r110.getTree());
        r12.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_memberExpr1326));
        r5.tree = r17;
        RewriteRuleSubtreeStream r21 = new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r111 = (CommonTree) this.adaptor.nil();
        CommonTree r112 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r113 = this.adaptor;
        CommonTree r22 = (CommonTree) r113.becomeRoot((CommonTree) r113.create(53, r20, "PROP_IND"), r112);
        this.adaptor.addChild(r22, r21.nextTree());
        this.adaptor.addChild(r22, r15.nextTree());
        this.adaptor.addChild(r111, r22);
        r5.tree = r111;
    L16:
        r17 = r111;
        goto L4
    L13:
        r5.stop = this.input.LT(-1);
        CommonTree r23 = (CommonTree) this.adaptor.rulePostProcessing(r17);
        r5.tree = r23;
        this.adaptor.setTokenBoundaries(r23, r5.start, r5.stop);
        return r5;
    L17:
        CommonToken r24 = (CommonToken) match(this.input, 19, FOLLOW_DOT_in_memberExpr1292);
        r10.add(r24);
        r13.add((CommonToken) match(this.input, 25, FOLLOW_ID_in_memberExpr1294));
        r5.tree = r17;
        RewriteRuleSubtreeStream r25 = new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r111 = (CommonTree) this.adaptor.nil();
        CommonTree r114 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r115 = this.adaptor;
        CommonTree r26 = (CommonTree) r115.becomeRoot((CommonTree) r115.create(52, r24, "PROP"), r114);
        this.adaptor.addChild(r26, r25.nextTree());
        this.adaptor.addChild(r26, r13.nextNode());
        this.adaptor.addChild(r111, r26);
        r5.tree = r111;
        goto L16
    L8:
        if (r18 != 14) goto L10;
        r19 = 2;
    L10:
        r19 = 3;
        goto L11
    }

    public final namedArg_return namedArg() throws RecognitionException {
        namedArg_return r5 = new namedArg_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token EQUALS");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token ID");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule arg");
        r11.add((CommonToken) match(this.input, 25, FOLLOW_ID_in_namedArg1724));
        r10.add((CommonToken) match(this.input, 12, FOLLOW_EQUALS_in_namedArg1726));
        pushFollow(FOLLOW_arg_in_namedArg1728);
        arg_return r13 = arg();
        this.state._fsp--;
        r12.add(r13.getTree());
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r14 = (CommonTree) this.adaptor.nil();
        CommonTree r15 = (CommonTree) this.adaptor.becomeRoot(r10.nextNode(), (CommonTree) this.adaptor.nil());
        this.adaptor.addChild(r15, r11.nextNode());
        this.adaptor.addChild(r15, r12.nextTree());
        this.adaptor.addChild(r14, r15);
        r5.tree = r14;
        r5.stop = this.input.LT(-1);
        CommonTree r16 = (CommonTree) this.adaptor.rulePostProcessing(r14);
        r5.tree = r16;
        this.adaptor.setTokenBoundaries(r16, r5.start, r5.stop);
        return r5;
    }

    public final notConditional_return notConditional() throws RecognitionException {
        notConditional_return r5 = new notConditional_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);
        if (r10 != 10) goto L6;
        char r11 = 1;
    L28:
        if (r11 == 1) goto L32;
        if (r11 == 2) goto L31;
        CommonTree r12 = null;
    L33:
        r5.stop = this.input.LT(-1);
        CommonTree r13 = (CommonTree) this.adaptor.rulePostProcessing(r12);
        r5.tree = r13;
        this.adaptor.setTokenBoundaries(r13, r5.start, r5.stop);
        return r5;
    L31:
        r12 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_memberExpr_in_notConditional761);
        memberExpr_return r14 = memberExpr();
        this.state._fsp--;
        this.adaptor.addChild(r12, r14.getTree());
        goto L33
    L32:
        CommonTree r15 = (CommonTree) this.adaptor.nil();
        r12 = (CommonTree) this.adaptor.becomeRoot((CommonTree) this.adaptor.create((CommonToken) match(this.input, 10, FOLLOW_BANG_in_notConditional753)), r15);
        pushFollow(FOLLOW_notConditional_in_notConditional756);
        notConditional_return r16 = notConditional();
        this.state._fsp--;
        this.adaptor.addChild(r12, r16.getTree());
        goto L33
    L6:
        if (r10 != 8) goto L8;
    L27:
        r11 = 2;
        goto L28
    L8:
        if (r10 == 16) goto L27;
        if (r10 == 20) goto L27;
        if (r10 < 25) goto L16;
        if (r10 <= 26) goto L27;
    L16:
        if (r10 == 33) goto L27;
        if (r10 < 35) goto L23;
        if (r10 <= 36) goto L27;
    L23:
        if (r10 != 14) goto L27;
        if (this.conditional_stack.size() > 0) goto L27;
        this.conditional_stack.size();
        goto L27
    }

    public final notConditionalExpr_return notConditionalExpr() throws RecognitionException {
        notConditionalExpr_return r5 = new notConditionalExpr_return();
        int r10 = 1;
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token DOT");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token LPAREN");
        RewriteRuleTokenStream r13 = new RewriteRuleTokenStream(this.adaptor, "token RPAREN");
        RewriteRuleTokenStream r14 = new RewriteRuleTokenStream(this.adaptor, "token ID");
        RewriteRuleSubtreeStream r15 = new RewriteRuleSubtreeStream(this.adaptor, "rule mapExpr");
        int r16 = 25;
        r14.add((CommonToken) match(this.input, 25, FOLLOW_ID_in_notConditionalExpr773));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r17 = (CommonTree) this.adaptor.nil();
        this.adaptor.addChild(r17, r14.nextNode());
        r5.tree = r17;
    L4:
        if (this.input.LA(r10) != 19) goto L10;
        int r18 = this.input.LA(2);
        if (r18 != r16) goto L8;
        int r19 = r10;
    L11:
        if (r19 == r10) goto L17;
        if (r19 != 2) goto L13;
        CommonToken r110 = (CommonToken) match(this.input, 19, FOLLOW_DOT_in_notConditionalExpr814);
        r11.add(r110);
        r12.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_notConditionalExpr816));
        pushFollow(FOLLOW_mapExpr_in_notConditionalExpr818);
        mapExpr_return r111 = mapExpr();
        this.state._fsp -= r10;
        r15.add(r111.getTree());
        r13.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_notConditionalExpr820));
        r5.tree = r17;
        RewriteRuleSubtreeStream r20 = new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r112 = (CommonTree) this.adaptor.nil();
        CommonTree r113 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r114 = this.adaptor;
        CommonTree r21 = (CommonTree) r114.becomeRoot((CommonTree) r114.create(53, r110, "PROP_IND"), r113);
        this.adaptor.addChild(r21, r20.nextTree());
        this.adaptor.addChild(r21, r15.nextTree());
        this.adaptor.addChild(r112, r21);
        r5.tree = r112;
    L16:
        r17 = r112;
        r10 = 1;
        r16 = 25;
        goto L4
    L13:
        r5.stop = this.input.LT(-1);
        CommonTree r22 = (CommonTree) this.adaptor.rulePostProcessing(r17);
        r5.tree = r22;
        this.adaptor.setTokenBoundaries(r22, r5.start, r5.stop);
        return r5;
    L17:
        CommonToken r23 = (CommonToken) match(this.input, 19, FOLLOW_DOT_in_notConditionalExpr784);
        r11.add(r23);
        CommonToken r115 = (CommonToken) match(this.input, r16, FOLLOW_ID_in_notConditionalExpr788);
        r14.add(r115);
        r5.tree = r17;
        RewriteRuleTokenStream r24 = new RewriteRuleTokenStream(this.adaptor, "token prop", r115);
        RewriteRuleSubtreeStream r116 = new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r112 = (CommonTree) this.adaptor.nil();
        CommonTree r117 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r118 = this.adaptor;
        CommonTree r25 = (CommonTree) r118.becomeRoot((CommonTree) r118.create(52, r23, "PROP"), r117);
        this.adaptor.addChild(r25, r116.nextTree());
        this.adaptor.addChild(r25, r24.nextNode());
        this.adaptor.addChild(r112, r25);
        r5.tree = r112;
        goto L16
    L8:
        if (r18 != 14) goto L10;
        r19 = 2;
    L10:
        r19 = 3;
        goto L11
    }

    public final option_return option() throws RecognitionException {
        option_return r5 = new option_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token EQUALS");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token ID");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule exprNoComma");
        String r13 = this.input.LT(1).getText();
        String r14 = Compiler.defaultOptionValues.get(r13);
        if (Compiler.supportedOptions.get(r13) == null) goto L5;
        boolean r15 = true;
    L6:
        CommonToken r16 = (CommonToken) match(this.input, 25, FOLLOW_ID_in_option883);
        r11.add(r16);
        if (r15 == true) goto L13;
        ErrorManager r17 = this.errMgr;
        ErrorType r18 = ErrorType.NO_SUCH_OPTION;
        Token r19 = this.templateToken;
        if (r16 == null) goto L11;
        String r110 = r16.getText();
    L12:
        r17.compileTimeError(r18, r19, r16, r110);
        goto L13
    L11:
        r110 = null;
    L13:
        int r111 = this.input.LA(1);
        if (r111 != 12) goto L17;
        char r20 = 1;
    L25:
        if (r20 == 1) goto L36;
        if (r20 == 2) goto L28;
        CommonTree r112 = null;
    L41:
        r5.stop = this.input.LT(-1);
        CommonTree r21 = (CommonTree) this.adaptor.rulePostProcessing(r112);
        r5.tree = r21;
        this.adaptor.setTokenBoundaries(r21, r5.start, r5.stop);
        return r5;
    L28:
        if (r14 != null) goto L30;
        this.errMgr.compileTimeError(ErrorType.NO_DEFAULT_VALUE, this.templateToken, r16);
    L30:
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r22 = (CommonTree) this.adaptor.nil();
        if (r15 == false) goto L34;
        if (r14 == null) goto L34;
        CommonTree r23 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r24 = this.adaptor;
        CommonTree r25 = (CommonTree) r24.becomeRoot((CommonTree) r24.create(12, "="), r23);
        this.adaptor.addChild(r25, r11.nextNode());
        TreeAdaptor r26 = this.adaptor;
        r26.addChild(r25, (CommonTree) r26.create(26, r16, "\"" + r14 + Typography.quote));
        this.adaptor.addChild(r22, r25);
        r112 = r22;
    L35:
        r5.tree = r112;
    L34:
        r112 = null;
        goto L35
    L36:
        r10.add((CommonToken) match(this.input, 12, FOLLOW_EQUALS_in_option893));
        pushFollow(FOLLOW_exprNoComma_in_option895);
        exprNoComma_return r27 = exprNoComma();
        this.state._fsp--;
        r12.add(r27.getTree());
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r28 = (CommonTree) this.adaptor.nil();
        if (r15 == false) goto L39;
        CommonTree r29 = (CommonTree) this.adaptor.becomeRoot(r10.nextNode(), (CommonTree) this.adaptor.nil());
        this.adaptor.addChild(r29, r11.nextNode());
        this.adaptor.addChild(r29, r12.nextTree());
        this.adaptor.addChild(r28, r29);
        r112 = r28;
    L40:
        r5.tree = r112;
        goto L41
    L39:
        r112 = null;
        goto L40
    L17:
        if (r111 != 18) goto L19;
    L23:
        r20 = 2;
        goto L25
    L19:
        if (r111 == 24) goto L23;
        throw new NoViableAltException("", 25, 0, this.input);
    L5:
        r15 = false;
        goto L6
    }

    public final primary_return primary() throws RecognitionException {
        primary_return r5 = new primary_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token LPAREN");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token RPAREN");
        RewriteRuleSubtreeStream r12 = new RewriteRuleSubtreeStream(this.adaptor, "rule argExprList");
        RewriteRuleSubtreeStream r13 = new RewriteRuleSubtreeStream(this.adaptor, "rule expr");
        int r14 = this.input.LA(1);
        if (r14 != 25) goto L5;
        char r15 = 1;
    L32:
        CommonTree r16 = null;
        switch(r15) {
            case 1: goto L102;
            case 2: goto L101;
            case 3: goto L100;
            case 4: goto L99;
            case 5: goto L98;
            case 6: goto L97;
            case 7: goto L92;
            case 8: goto L36;
            default: goto L103;
        };
    L92:
        r16 = (CommonTree) this.adaptor.nil();
        if (this.conditional_stack.size() <= 0) goto L96;
        CommonToken r17 = (CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_primary1553);
        pushFollow(FOLLOW_conditional_in_primary1556);
        conditional_return r18 = conditional();
        this.state._fsp--;
        this.adaptor.addChild(r16, r18.getTree());
        CommonToken r19 = (CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_primary1558);
        goto L103
    L96:
        throw new FailedPredicateException(this.input, "primary", "$conditional.size()>0");
    L97:
        r16 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_list_in_primary1544);
        list_return r20 = list();
        this.state._fsp--;
        this.adaptor.addChild(r16, r20.getTree());
        goto L103
    L98:
        r16 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_subtemplate_in_primary1539);
        subtemplate_return r21 = subtemplate();
        this.state._fsp--;
        this.adaptor.addChild(r16, r21.getTree());
        goto L103
    L99:
        r16 = (CommonTree) this.adaptor.nil();
        this.adaptor.addChild(r16, (CommonTree) this.adaptor.create((CommonToken) match(this.input, 36, FOLLOW_FALSE_in_primary1534)));
        goto L103
    L100:
        r16 = (CommonTree) this.adaptor.nil();
        this.adaptor.addChild(r16, (CommonTree) this.adaptor.create((CommonToken) match(this.input, 35, FOLLOW_TRUE_in_primary1529)));
        goto L103
    L101:
        r16 = (CommonTree) this.adaptor.nil();
        this.adaptor.addChild(r16, (CommonTree) this.adaptor.create((CommonToken) match(this.input, 26, FOLLOW_STRING_in_primary1524)));
        goto L103
    L102:
        r16 = (CommonTree) this.adaptor.nil();
        this.adaptor.addChild(r16, (CommonTree) this.adaptor.create((CommonToken) match(this.input, 25, FOLLOW_ID_in_primary1519)));
    L103:
        r5.stop = this.input.LT(-1);
        CommonTree r22 = (CommonTree) this.adaptor.rulePostProcessing(r16);
        r5.tree = r22;
        this.adaptor.setTokenBoundaries(r22, r5.start, r5.stop);
        return r5;
    L36:
        if (this.conditional_stack.size() != 0) goto L91;
        CommonToken r23 = (CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_primary1569);
        r10.add(r23);
        pushFollow(FOLLOW_expr_in_primary1571);
        expr_return r110 = expr();
        this.state._fsp--;
        r13.add(r110.getTree());
        r11.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_primary1573));
        int r111 = this.input.LA(1);
        if (r111 != 14) goto L41;
        char r24 = 1;
    L60:
        if (r24 == 1) goto L64;
        if (r24 != 2) goto L103;
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r16 = (CommonTree) this.adaptor.nil();
        CommonTree r25 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r26 = this.adaptor;
        CommonTree r27 = (CommonTree) r26.becomeRoot((CommonTree) r26.create(56, r23), r25);
        this.adaptor.addChild(r27, r13.nextTree());
        this.adaptor.addChild(r16, r27);
        r5.tree = r16;
        goto L103
    L64:
        r10.add((CommonToken) match(this.input, 14, FOLLOW_LPAREN_in_primary1579));
        int r28 = this.input.LA(1);
        if (r28 == 8) goto L85;
        if (r28 == 16) goto L85;
        if (r28 == 20) goto L85;
        if (r28 < 25) goto L74;
        if (r28 <= 26) goto L85;
    L74:
        if (r28 == 33) goto L85;
        if (r28 >= 35) goto L78;
    L80:
        if (r28 == 14) goto L82;
    L86:
        r11.add((CommonToken) match(this.input, 15, FOLLOW_RPAREN_in_primary1584));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        r16 = (CommonTree) this.adaptor.nil();
        CommonTree r29 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r30 = this.adaptor;
        CommonTree r31 = (CommonTree) r30.becomeRoot((CommonTree) r30.create(43, r23), r29);
        this.adaptor.addChild(r31, r13.nextTree());
        if (r12.hasNext() == false) goto L89;
        this.adaptor.addChild(r31, r12.nextTree());
    L89:
        r12.reset();
        this.adaptor.addChild(r16, r31);
        r5.tree = r16;
        goto L103
    L82:
        if (this.conditional_stack.size() > 0) goto L85;
        if (this.conditional_stack.size() != 0) goto L86;
    L78:
        if (r28 > 36) goto L80;
    L85:
        pushFollow(FOLLOW_argExprList_in_primary1581);
        argExprList_return r32 = argExprList();
        this.state._fsp--;
        r12.add(r32.getTree());
        goto L86
    L41:
        if (r111 != 9) goto L43;
    L58:
        r24 = 2;
        goto L60
    L43:
        if (r111 == 13) goto L58;
        if (r111 == 15) goto L58;
        if (r111 < 17) goto L50;
        if (r111 <= 19) goto L58;
    L50:
        if (r111 == 24) goto L58;
        if (r111 < 29) goto L57;
        if (r111 <= 30) goto L58;
    L57:
        throw new NoViableAltException("", 37, 0, this.input);
    L91:
        throw new FailedPredicateException(this.input, "primary", "$conditional.size()==0");
    L5:
        if (r14 != 26) goto L7;
        r15 = 2;
        goto L32
    L7:
        if (r14 != 35) goto L9;
        r15 = 3;
        goto L32
    L9:
        if (r14 != 36) goto L11;
        r15 = 4;
        goto L32
    L11:
        if (r14 != 20) goto L13;
        r15 = 5;
        goto L32
    L13:
        if (r14 != 16) goto L15;
        r15 = 6;
        goto L32
    L15:
        if (r14 == 14) goto L17;
    L25:
        r15 = '\b';
        goto L32
    L17:
        if (this.conditional_stack.size() <= 0) goto L19;
    L20:
        this.input.LA(2);
        if (this.conditional_stack.size() <= 0) goto L24;
        r15 = 7;
        goto L32
    L24:
        if (this.conditional_stack.size() == 0) goto L25;
        int r33 = this.input.mark();
        this.input.consume();     // Catch: Throwable -> L29
        throw new NoViableAltException("", 38, 7, this.input);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        this.input.rewind(r33);
        throw th;
    L19:
        if (this.conditional_stack.size() != 0) goto L25;
        goto L20
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public Object recoverFromMismatchedToken(IntStream r5, int r10, BitSet r11) throws RecognitionException {
        throw new MismatchedTokenException(r10, r5);
    }

    public final region_return region() throws RecognitionException {
        region_return r5 = new region_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token INDENT");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token RDELIM");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token AT");
        RewriteRuleTokenStream r13 = new RewriteRuleTokenStream(this.adaptor, "token NEWLINE");
        RewriteRuleTokenStream r14 = new RewriteRuleTokenStream(this.adaptor, "token END");
        RewriteRuleTokenStream r15 = new RewriteRuleTokenStream(this.adaptor, "token ID");
        RewriteRuleTokenStream r16 = new RewriteRuleTokenStream(this.adaptor, "token LDELIM");
        RewriteRuleSubtreeStream r17 = new RewriteRuleSubtreeStream(this.adaptor, "rule template");
        if (this.input.LA(1) != 31) goto L5;
        CommonToken r18 = (CommonToken) match(this.input, 31, FOLLOW_INDENT_in_region305);
        r10.add(r18);
    L6:
        CommonToken r19 = (CommonToken) match(this.input, 23, FOLLOW_LDELIM_in_region310);
        r16.add(r19);
        r12.add((CommonToken) match(this.input, 33, FOLLOW_AT_in_region312));
        r15.add((CommonToken) match(this.input, 25, FOLLOW_ID_in_region314));
        r11.add((CommonToken) match(this.input, 24, FOLLOW_RDELIM_in_region316));
        if (this.input.LA(1) == 32) goto L9;
        CommonToken r20 = r18;
    L10:
        pushFollow(FOLLOW_template_in_region322);
        template_return r110 = template();
        this.state._fsp--;
        r17.add(r110.getTree());
        if (this.input.LA(1) != 31) goto L13;
        r10.add((CommonToken) match(this.input, 31, FOLLOW_INDENT_in_region326));
    L13:
        r16.add((CommonToken) match(this.input, 23, FOLLOW_LDELIM_in_region329));
        r14.add((CommonToken) match(this.input, 34, FOLLOW_END_in_region331));
        r11.add((CommonToken) match(this.input, 24, FOLLOW_RDELIM_in_region333));
        if (this.input.LA(1) != 32) goto L23;
        this.input.LA(2);
        if (((CommonToken) r5.start).getLine() == this.input.LT(1).getLine()) goto L23;
        if (((CommonToken) r5.start).getLine() == this.input.LT(1).getLine()) goto L22;
        r13.add((CommonToken) match(this.input, 32, FOLLOW_NEWLINE_in_region344));
        goto L23
    L22:
        throw new FailedPredicateException(this.input, "region", "$region.start.getLine()!=input.LT(1).getLine()");
    L23:
        r5.tree = null;
        RewriteRuleTokenStream r21 = new RewriteRuleTokenStream(this.adaptor, "token i", r18);
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r22 = (CommonTree) this.adaptor.nil();
        if (r20 == null) goto L29;
        CommonTree r23 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r24 = this.adaptor;
        CommonTree r25 = (CommonTree) r24.becomeRoot((CommonTree) r24.create(47, "INDENTED_EXPR"), r23);
        this.adaptor.addChild(r25, r21.nextNode());
        CommonTree r26 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r27 = this.adaptor;
        CommonTree r28 = (CommonTree) r27.becomeRoot((CommonTree) r27.create(54, r19), r26);
        this.adaptor.addChild(r28, r15.nextNode());
        if (r17.hasNext() == false) goto L28;
        this.adaptor.addChild(r28, r17.nextTree());
    L28:
        r17.reset();
        this.adaptor.addChild(r25, r28);
        this.adaptor.addChild(r22, r25);
    L33:
        r5.tree = r22;
        r5.stop = this.input.LT(-1);
        CommonTree r29 = (CommonTree) this.adaptor.rulePostProcessing(r22);
        r5.tree = r29;
        this.adaptor.setTokenBoundaries(r29, r5.start, r5.stop);
        return r5;
    L29:
        CommonTree r30 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r31 = this.adaptor;
        CommonTree r32 = (CommonTree) r31.becomeRoot((CommonTree) r31.create(54, r19), r30);
        this.adaptor.addChild(r32, r15.nextNode());
        if (r17.hasNext() == false) goto L32;
        this.adaptor.addChild(r32, r17.nextTree());
    L32:
        r17.reset();
        this.adaptor.addChild(r22, r32);
        goto L33
    L9:
        r20 = null;
        goto L10
    L5:
        r18 = null;
        goto L6
    }

    public void setTreeAdaptor(TreeAdaptor r5) {
        this.adaptor = r5;
    }

    public final singleElement_return singleElement() throws RecognitionException {
        singleElement_return r5 = new singleElement_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);
        if (r10 != 22) goto L5;
        char r11 = 2;
    L14:
        if (r11 == 1) goto L22;
        if (r11 == 2) goto L21;
        if (r11 == 3) goto L20;
        if (r11 == 4) goto L19;
        CommonTree r12 = null;
    L23:
        r5.stop = this.input.LT(-1);
        CommonTree r13 = (CommonTree) this.adaptor.rulePostProcessing(r12);
        r5.tree = r13;
        this.adaptor.setTokenBoundaries(r13, r5.start, r5.stop);
        return r5;
    L19:
        r12 = (CommonTree) this.adaptor.nil();
        CommonToken r14 = (CommonToken) match(this.input, 37, FOLLOW_COMMENT_in_singleElement231);
        goto L23
    L20:
        r12 = (CommonTree) this.adaptor.nil();
        this.adaptor.addChild(r12, (CommonTree) this.adaptor.create((CommonToken) match(this.input, 32, FOLLOW_NEWLINE_in_singleElement226)));
        goto L23
    L21:
        r12 = (CommonTree) this.adaptor.nil();
        this.adaptor.addChild(r12, (CommonTree) this.adaptor.create((CommonToken) match(this.input, 22, FOLLOW_TEXT_in_singleElement221)));
        goto L23
    L22:
        r12 = (CommonTree) this.adaptor.nil();
        pushFollow(FOLLOW_exprTag_in_singleElement216);
        exprTag_return r15 = exprTag();
        this.state._fsp--;
        this.adaptor.addChild(r12, r15.getTree());
        goto L23
    L5:
        if (r10 == 23) goto L12;
        if (r10 == 32) goto L11;
        if (r10 != 37) goto L10;
        r11 = 4;
        goto L14
    L10:
        throw new NoViableAltException("", 4, 0, this.input);
    L11:
        r11 = 3;
        goto L14
    L12:
        r11 = 1;
        goto L14
    }

    public final subtemplate_return subtemplate() throws RecognitionException {
        subtemplate_return r5 = new subtemplate_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token INDENT");
        RewriteRuleTokenStream r11 = new RewriteRuleTokenStream(this.adaptor, "token COMMA");
        RewriteRuleTokenStream r12 = new RewriteRuleTokenStream(this.adaptor, "token LCURLY");
        RewriteRuleTokenStream r13 = new RewriteRuleTokenStream(this.adaptor, "token PIPE");
        RewriteRuleTokenStream r14 = new RewriteRuleTokenStream(this.adaptor, "token ID");
        RewriteRuleTokenStream r15 = new RewriteRuleTokenStream(this.adaptor, "token RCURLY");
        RewriteRuleSubtreeStream r16 = new RewriteRuleSubtreeStream(this.adaptor, "rule template");
        CommonToken r17 = (CommonToken) match(this.input, 20, FOLLOW_LCURLY_in_subtemplate420);
        r12.add(r17);
        if (this.input.LA(1) != 25) goto L9;
        CommonToken r18 = (CommonToken) match(this.input, 25, FOLLOW_ID_in_subtemplate426);
        r14.add(r18);
        ArrayList r19 = new ArrayList();
        r19.add(r18);
    L6:
        if (this.input.LA(1) != 18) goto L8;
        r11.add((CommonToken) match(this.input, 18, FOLLOW_COMMA_in_subtemplate430));
        CommonToken r20 = (CommonToken) match(this.input, 25, FOLLOW_ID_in_subtemplate435);
        r14.add(r20);
        r19.add(r20);
        goto L6
    L8:
        r13.add((CommonToken) match(this.input, 28, FOLLOW_PIPE_in_subtemplate440));
    L10:
        pushFollow(FOLLOW_template_in_subtemplate445);
        template_return r21 = template();
        this.state._fsp--;
        r16.add(r21.getTree());
        if (this.input.LA(1) != 31) goto L13;
        r10.add((CommonToken) match(this.input, 31, FOLLOW_INDENT_in_subtemplate447));
    L13:
        r15.add((CommonToken) match(this.input, 21, FOLLOW_RCURLY_in_subtemplate450));
        r5.tree = null;
        RewriteRuleTokenStream r22 = new RewriteRuleTokenStream(this.adaptor, "token ids", r19);
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r23 = (CommonTree) this.adaptor.nil();
        CommonTree r24 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r25 = this.adaptor;
        CommonTree r26 = (CommonTree) r25.becomeRoot((CommonTree) r25.create(55, r17, "SUBTEMPLATE"), r24);
    L15:
        if (r22.hasNext() == false) goto L17;
        CommonTree r27 = (CommonTree) this.adaptor.nil();
        TreeAdaptor r28 = this.adaptor;
        CommonTree r29 = (CommonTree) r28.becomeRoot((CommonTree) r28.create(38, "ARGS"), r27);
        this.adaptor.addChild(r29, r22.nextNode());
        this.adaptor.addChild(r26, r29);
        goto L15
    L17:
        r22.reset();
        if (r16.hasNext() == false) goto L20;
        this.adaptor.addChild(r26, r16.nextTree());
    L20:
        r16.reset();
        this.adaptor.addChild(r23, r26);
        r5.tree = r23;
        r5.stop = this.input.LT(-1);
        CommonTree r30 = (CommonTree) this.adaptor.rulePostProcessing(r23);
        r5.tree = r30;
        this.adaptor.setTokenBoundaries(r30, r5.start, r5.stop);
        return r5;
    L9:
        r19 = null;
        goto L10
    }

    public final template_return template() throws RecognitionException {
        template_return r5 = new template_return();
        int r10 = 1;
        r5.start = this.input.LT(1);
        CommonTree r11 = (CommonTree) this.adaptor.nil();
    L3:
        int r12 = this.input.LA(r10);
        if (r12 == 22) goto L51;
        if (r12 != 23) goto L8;
        int r13 = this.input.LA(2);
        if (r13 == 4) goto L51;
        if (r13 == 8) goto L51;
        if (r13 == 14) goto L51;
        if (r13 == 16) goto L51;
        if (r13 == 20) goto L51;
        if (r13 < 25) goto L43;
        if (r13 <= 26) goto L51;
    L43:
        if (r13 == 33) goto L51;
        if (r13 < 35) goto L49;
        if (r13 <= 36) goto L51;
    L49:
        r5.stop = this.input.LT(-1);
        CommonTree r14 = (CommonTree) this.adaptor.rulePostProcessing(r11);
        r5.tree = r14;
        this.adaptor.setTokenBoundaries(r14, r5.start, r5.stop);
        return r5;
    L8:
        if (r12 == 31) goto L12;
        if (r12 == 32) goto L51;
        if (r12 == 37) goto L51;
    L12:
        int r15 = this.input.LA(2);
        if (r15 != 23) goto L30;
        int r16 = this.input.LA(3);
        if (r16 == 4) goto L51;
        if (r16 == 8) goto L51;
        if (r16 == 14) goto L51;
        if (r16 == 16) goto L51;
        if (r16 == 20) goto L51;
        if (r16 < 25) goto L23;
        if (r16 <= 26) goto L51;
    L23:
        if (r16 == 33) goto L51;
        if (r16 < 35) goto L49;
        if (r16 > 36) goto L49;
    L30:
        if (r15 == 22) goto L51;
        if (r15 == 32) goto L51;
        if (r15 != 37) goto L49;
    L51:
        pushFollow(FOLLOW_element_in_template155);
        element_return r17 = element();
        this.state._fsp--;
        this.adaptor.addChild(r11, r17.getTree());
        r10 = 1;
        goto L3
    }

    public final templateAndEOF_return templateAndEOF() throws RecognitionException {
        templateAndEOF_return r5 = new templateAndEOF_return();
        r5.start = this.input.LT(1);
        RewriteRuleTokenStream r10 = new RewriteRuleTokenStream(this.adaptor, "token EOF");
        RewriteRuleSubtreeStream r11 = new RewriteRuleSubtreeStream(this.adaptor, "rule template");
        pushFollow(FOLLOW_template_in_templateAndEOF139);
        template_return r12 = template();
        this.state._fsp--;
        r11.add(r12.getTree());
        r10.add((CommonToken) match(this.input, -1, FOLLOW_EOF_in_templateAndEOF141));
        r5.tree = null;
        new RewriteRuleSubtreeStream(this.adaptor, "rule retval", r5.getTree());
        CommonTree r13 = (CommonTree) this.adaptor.nil();
        if (r11.hasNext() == false) goto L5;
        this.adaptor.addChild(r13, r11.nextTree());
    L5:
        r11.reset();
        r5.tree = r13;
        r5.stop = this.input.LT(-1);
        CommonTree r14 = (CommonTree) this.adaptor.rulePostProcessing(r13);
        r5.tree = r14;
        this.adaptor.setTokenBoundaries(r14, r5.start, r5.stop);
        return r5;
    }

    public STParser(TokenStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.adaptor = new CommonTreeAdaptor();
        this.conditional_stack = new Stack();
    }

    public STParser(TokenStream r5, ErrorManager r10, Token r11) {
        this(r5);
        this.errMgr = r10;
        this.templateToken = r11;
    }
}
