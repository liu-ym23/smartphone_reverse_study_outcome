package androidx.room.jarjarred.org.stringtemplate.v4.compiler;

import androidx.room.jarjarred.org.antlr.runtime.BitSet;
import androidx.room.jarjarred.org.antlr.runtime.EarlyExitException;
import androidx.room.jarjarred.org.antlr.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.RecognizerSharedState;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeNodeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeParser;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeRuleReturnScope;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorManager;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorType;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class CodeGenerator extends TreeParser {
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
    public static final BitSet FOLLOW_AND_in_conditional499 = null;
    public static final BitSet FOLLOW_ARGS_in_subtemplate298 = null;
    public static final BitSet FOLLOW_BANG_in_conditional513 = null;
    public static final BitSet FOLLOW_ELEMENTS_in_expr581 = null;
    public static final BitSet FOLLOW_ELLIPSIS_in_args1005 = null;
    public static final BitSet FOLLOW_ELLIPSIS_in_args1020 = null;
    public static final BitSet FOLLOW_ELSEIF_in_ifstat388 = null;
    public static final BitSet FOLLOW_ELSE_in_ifstat437 = null;
    public static final BitSet FOLLOW_EOF_in_templateAndEOF53 = null;
    public static final BitSet FOLLOW_EQUALS_in_args984 = null;
    public static final BitSet FOLLOW_EQUALS_in_option555 = null;
    public static final BitSet FOLLOW_EXEC_FUNC_in_includeExpr751 = null;
    public static final BitSet FOLLOW_EXPR_in_exprElement203 = null;
    public static final BitSet FOLLOW_FALSE_in_primary857 = null;
    public static final BitSet FOLLOW_ID_in_args986 = null;
    public static final BitSet FOLLOW_ID_in_includeExpr753 = null;
    public static final BitSet FOLLOW_ID_in_includeExpr768 = null;
    public static final BitSet FOLLOW_ID_in_includeExpr783 = null;
    public static final BitSet FOLLOW_ID_in_includeExpr798 = null;
    public static final BitSet FOLLOW_ID_in_includeExpr810 = null;
    public static final BitSet FOLLOW_ID_in_mapTemplateRef682 = null;
    public static final BitSet FOLLOW_ID_in_option557 = null;
    public static final BitSet FOLLOW_ID_in_primary829 = null;
    public static final BitSet FOLLOW_ID_in_prop642 = null;
    public static final BitSet FOLLOW_ID_in_region248 = null;
    public static final BitSet FOLLOW_ID_in_subtemplate301 = null;
    public static final BitSet FOLLOW_IF_in_ifstat366 = null;
    public static final BitSet FOLLOW_INCLUDE_IND_in_mapTemplateRef717 = null;
    public static final BitSet FOLLOW_INCLUDE_IND_in_primary900 = null;
    public static final BitSet FOLLOW_INCLUDE_REGION_in_includeExpr796 = null;
    public static final BitSet FOLLOW_INCLUDE_SUPER_REGION_in_includeExpr808 = null;
    public static final BitSet FOLLOW_INCLUDE_SUPER_in_includeExpr781 = null;
    public static final BitSet FOLLOW_INCLUDE_in_includeExpr766 = null;
    public static final BitSet FOLLOW_INCLUDE_in_mapTemplateRef680 = null;
    public static final BitSet FOLLOW_INDENTED_EXPR_in_element105 = null;
    public static final BitSet FOLLOW_INDENTED_EXPR_in_element124 = null;
    public static final BitSet FOLLOW_INDENT_in_element107 = null;
    public static final BitSet FOLLOW_INDENT_in_element126 = null;
    public static final BitSet FOLLOW_LIST_in_list1040 = null;
    public static final BitSet FOLLOW_MAP_in_expr603 = null;
    public static final BitSet FOLLOW_NEWLINE_in_singleElement164 = null;
    public static final BitSet FOLLOW_NULL_in_listElement1063 = null;
    public static final BitSet FOLLOW_OPTIONS_in_exprOptions541 = null;
    public static final BitSet FOLLOW_OR_in_conditional485 = null;
    public static final BitSet FOLLOW_PROP_IND_in_prop656 = null;
    public static final BitSet FOLLOW_PROP_in_prop638 = null;
    public static final BitSet FOLLOW_REGION_in_region246 = null;
    public static final BitSet FOLLOW_STRING_in_primary839 = null;
    public static final BitSet FOLLOW_SUBTEMPLATE_in_subtemplate291 = null;
    public static final BitSet FOLLOW_SUBTEMPLATE_in_subtemplate334 = null;
    public static final BitSet FOLLOW_TEXT_in_singleElement154 = null;
    public static final BitSet FOLLOW_TO_STR_in_primary934 = null;
    public static final BitSet FOLLOW_TRUE_in_primary848 = null;
    public static final BitSet FOLLOW_ZIP_in_expr578 = null;
    public static final BitSet FOLLOW_arg_in_args965 = null;
    public static final BitSet FOLLOW_args_in_includeExpr770 = null;
    public static final BitSet FOLLOW_args_in_includeExpr785 = null;
    public static final BitSet FOLLOW_args_in_mapTemplateRef692 = null;
    public static final BitSet FOLLOW_args_in_mapTemplateRef729 = null;
    public static final BitSet FOLLOW_args_in_primary914 = null;
    public static final BitSet FOLLOW_chunk_in_ifstat378 = null;
    public static final BitSet FOLLOW_chunk_in_ifstat414 = null;
    public static final BitSet FOLLOW_chunk_in_ifstat451 = null;
    public static final BitSet FOLLOW_chunk_in_template77 = null;
    public static final BitSet FOLLOW_compoundElement_in_element109 = null;
    public static final BitSet FOLLOW_compoundElement_in_element117 = null;
    public static final BitSet FOLLOW_conditional_in_conditional487 = null;
    public static final BitSet FOLLOW_conditional_in_conditional489 = null;
    public static final BitSet FOLLOW_conditional_in_conditional501 = null;
    public static final BitSet FOLLOW_conditional_in_conditional503 = null;
    public static final BitSet FOLLOW_conditional_in_conditional515 = null;
    public static final BitSet FOLLOW_conditional_in_ifstat368 = null;
    public static final BitSet FOLLOW_conditional_in_ifstat402 = null;
    public static final BitSet FOLLOW_element_in_chunk92 = null;
    public static final BitSet FOLLOW_exprElement_in_singleElement149 = null;
    public static final BitSet FOLLOW_exprOptions_in_exprElement208 = null;
    public static final BitSet FOLLOW_expr_in_arg949 = null;
    public static final BitSet FOLLOW_expr_in_args988 = null;
    public static final BitSet FOLLOW_expr_in_conditional527 = null;
    public static final BitSet FOLLOW_expr_in_expr584 = null;
    public static final BitSet FOLLOW_expr_in_expr605 = null;
    public static final BitSet FOLLOW_expr_in_exprElement205 = null;
    public static final BitSet FOLLOW_expr_in_includeExpr755 = null;
    public static final BitSet FOLLOW_expr_in_listElement1059 = null;
    public static final BitSet FOLLOW_expr_in_mapTemplateRef719 = null;
    public static final BitSet FOLLOW_expr_in_option559 = null;
    public static final BitSet FOLLOW_expr_in_primary905 = null;
    public static final BitSet FOLLOW_expr_in_primary936 = null;
    public static final BitSet FOLLOW_expr_in_prop640 = null;
    public static final BitSet FOLLOW_expr_in_prop658 = null;
    public static final BitSet FOLLOW_expr_in_prop660 = null;
    public static final BitSet FOLLOW_ifstat_in_compoundElement178 = null;
    public static final BitSet FOLLOW_includeExpr_in_expr628 = null;
    public static final BitSet FOLLOW_listElement_in_list1043 = null;
    public static final BitSet FOLLOW_list_in_primary893 = null;
    public static final BitSet FOLLOW_mapTemplateRef_in_expr591 = null;
    public static final BitSet FOLLOW_mapTemplateRef_in_expr608 = null;
    public static final BitSet FOLLOW_option_in_exprOptions543 = null;
    public static final BitSet FOLLOW_primary_in_includeExpr818 = null;
    public static final BitSet FOLLOW_prop_in_expr623 = null;
    public static final BitSet FOLLOW_region_in_compoundElement184 = null;
    public static final BitSet FOLLOW_singleElement_in_element130 = null;
    public static final BitSet FOLLOW_singleElement_in_element138 = null;
    public static final BitSet FOLLOW_subtemplate_in_mapTemplateRef705 = null;
    public static final BitSet FOLLOW_subtemplate_in_primary866 = null;
    public static final BitSet FOLLOW_template_in_region258 = null;
    public static final BitSet FOLLOW_template_in_subtemplate318 = null;
    public static final BitSet FOLLOW_template_in_templateAndEOF50 = null;
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
    ErrorManager errMgr;
    CompiledST outermostImpl;
    String outermostTemplateName;
    String template;
    Token templateToken;
    protected Stack<template_scope> template_stack;

    public static class args_return extends TreeRuleReturnScope {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f677n;
        public boolean namedArgs;
        public boolean passThru;

        public args_return() {
            this.f677n = 0;
            this.namedArgs = false;
        }
    }

    public static class conditional_return extends TreeRuleReturnScope {
        public conditional_return() {
        }
    }

    public static class exprOptions_return extends TreeRuleReturnScope {
        public exprOptions_return() {
        }
    }

    public static class includeExpr_return extends TreeRuleReturnScope {
        public includeExpr_return() {
        }
    }

    public static class listElement_return extends TreeRuleReturnScope {
        public listElement_return() {
        }
    }

    public static class list_return extends TreeRuleReturnScope {
        public list_return() {
        }
    }

    public static class mapTemplateRef_return extends TreeRuleReturnScope {
        public mapTemplateRef_return() {
        }
    }

    public static class primary_return extends TreeRuleReturnScope {
        public primary_return() {
        }
    }

    public static class region_return extends TreeRuleReturnScope {
        public String name;

        public region_return() {
        }
    }

    public static class subtemplate_return extends TreeRuleReturnScope {
        public String name;
        public int nargs;

        public subtemplate_return() {
        }
    }

    public static class template_scope {
        CompilationState state;

        public template_scope() {
        }
    }

    static {
        tokenNames = new String[]{Grammar.INVALID_RULE_NAME, "<EOR>", "<DOWN>", "<UP>", "IF", "ELSE", "ELSEIF", "ENDIF", "SUPER", "SEMI", "BANG", "ELLIPSIS", "EQUALS", "COLON", "LPAREN", "RPAREN", "LBRACK", "RBRACK", "COMMA", "DOT", "LCURLY", "RCURLY", "TEXT", "LDELIM", "RDELIM", "ID", "STRING", "WS", "PIPE", "OR", "AND", "INDENT", "NEWLINE", "AT", "END", "TRUE", "FALSE", "COMMENT", "ARGS", "ELEMENTS", "EXEC_FUNC", "EXPR", "INCLUDE", "INCLUDE_IND", "INCLUDE_REGION", "INCLUDE_SUPER", "INCLUDE_SUPER_REGION", "INDENTED_EXPR", "LIST", "MAP", "NULL", "OPTIONS", "PROP", "PROP_IND", "REGION", "SUBTEMPLATE", "TO_STR", "ZIP"};
        FOLLOW_template_in_templateAndEOF50 = new BitSet(new long[]{0});
        FOLLOW_EOF_in_templateAndEOF53 = new BitSet(new long[]{2});
        FOLLOW_chunk_in_template77 = new BitSet(new long[]{2});
        FOLLOW_element_in_chunk92 = new BitSet(new long[]{18157339320254482L});
        FOLLOW_INDENTED_EXPR_in_element105 = new BitSet(new long[]{4});
        FOLLOW_INDENT_in_element107 = new BitSet(new long[]{18014398509482000L});
        FOLLOW_compoundElement_in_element109 = new BitSet(new long[]{8});
        FOLLOW_compoundElement_in_element117 = new BitSet(new long[]{2});
        FOLLOW_INDENTED_EXPR_in_element124 = new BitSet(new long[]{4});
        FOLLOW_INDENT_in_element126 = new BitSet(new long[]{2203322417152L});
        FOLLOW_singleElement_in_element130 = new BitSet(new long[]{8});
        FOLLOW_singleElement_in_element138 = new BitSet(new long[]{2});
        FOLLOW_exprElement_in_singleElement149 = new BitSet(new long[]{2});
        FOLLOW_TEXT_in_singleElement154 = new BitSet(new long[]{2});
        FOLLOW_NEWLINE_in_singleElement164 = new BitSet(new long[]{2});
        FOLLOW_ifstat_in_compoundElement178 = new BitSet(new long[]{2});
        FOLLOW_region_in_compoundElement184 = new BitSet(new long[]{2});
        FOLLOW_EXPR_in_exprElement203 = new BitSet(new long[]{4});
        FOLLOW_expr_in_exprElement205 = new BitSet(new long[]{2251799813685256L});
        FOLLOW_exprOptions_in_exprElement208 = new BitSet(new long[]{8});
        FOLLOW_REGION_in_region246 = new BitSet(new long[]{4});
        FOLLOW_ID_in_region248 = new BitSet(new long[]{18157339320254480L});
        FOLLOW_template_in_region258 = new BitSet(new long[]{8});
        FOLLOW_SUBTEMPLATE_in_subtemplate291 = new BitSet(new long[]{4});
        FOLLOW_ARGS_in_subtemplate298 = new BitSet(new long[]{4});
        FOLLOW_ID_in_subtemplate301 = new BitSet(new long[]{33554440});
        FOLLOW_template_in_subtemplate318 = new BitSet(new long[]{8});
        FOLLOW_SUBTEMPLATE_in_subtemplate334 = new BitSet(new long[]{2});
        FOLLOW_IF_in_ifstat366 = new BitSet(new long[]{4});
        FOLLOW_conditional_in_ifstat368 = new BitSet(new long[]{18157339320254584L});
        FOLLOW_chunk_in_ifstat378 = new BitSet(new long[]{104});
        FOLLOW_ELSEIF_in_ifstat388 = new BitSet(new long[]{4});
        FOLLOW_conditional_in_ifstat402 = new BitSet(new long[]{18157339320254488L});
        FOLLOW_chunk_in_ifstat414 = new BitSet(new long[]{8});
        FOLLOW_ELSE_in_ifstat437 = new BitSet(new long[]{4});
        FOLLOW_chunk_in_ifstat451 = new BitSet(new long[]{8});
        FOLLOW_OR_in_conditional485 = new BitSet(new long[]{4});
        FOLLOW_conditional_in_conditional487 = new BitSet(new long[]{266694346688955392L});
        FOLLOW_conditional_in_conditional489 = new BitSet(new long[]{8});
        FOLLOW_AND_in_conditional499 = new BitSet(new long[]{4});
        FOLLOW_conditional_in_conditional501 = new BitSet(new long[]{266694346688955392L});
        FOLLOW_conditional_in_conditional503 = new BitSet(new long[]{8});
        FOLLOW_BANG_in_conditional513 = new BitSet(new long[]{4});
        FOLLOW_conditional_in_conditional515 = new BitSet(new long[]{8});
        FOLLOW_expr_in_conditional527 = new BitSet(new long[]{2});
        FOLLOW_OPTIONS_in_exprOptions541 = new BitSet(new long[]{4});
        FOLLOW_option_in_exprOptions543 = new BitSet(new long[]{4104});
        FOLLOW_EQUALS_in_option555 = new BitSet(new long[]{4});
        FOLLOW_ID_in_option557 = new BitSet(new long[]{266694345078341632L});
        FOLLOW_expr_in_option559 = new BitSet(new long[]{8});
        FOLLOW_ZIP_in_expr578 = new BitSet(new long[]{4});
        FOLLOW_ELEMENTS_in_expr581 = new BitSet(new long[]{4});
        FOLLOW_expr_in_expr584 = new BitSet(new long[]{266694345078341640L});
        FOLLOW_mapTemplateRef_in_expr591 = new BitSet(new long[]{8});
        FOLLOW_MAP_in_expr603 = new BitSet(new long[]{4});
        FOLLOW_expr_in_expr605 = new BitSet(new long[]{36041991158497280L});
        FOLLOW_mapTemplateRef_in_expr608 = new BitSet(new long[]{36041991158497288L});
        FOLLOW_prop_in_expr623 = new BitSet(new long[]{2});
        FOLLOW_includeExpr_in_expr628 = new BitSet(new long[]{2});
        FOLLOW_PROP_in_prop638 = new BitSet(new long[]{4});
        FOLLOW_expr_in_prop640 = new BitSet(new long[]{33554432});
        FOLLOW_ID_in_prop642 = new BitSet(new long[]{8});
        FOLLOW_PROP_IND_in_prop656 = new BitSet(new long[]{4});
        FOLLOW_expr_in_prop658 = new BitSet(new long[]{266694345078341632L});
        FOLLOW_expr_in_prop660 = new BitSet(new long[]{8});
        FOLLOW_INCLUDE_in_mapTemplateRef680 = new BitSet(new long[]{4});
        FOLLOW_ID_in_mapTemplateRef682 = new BitSet(new long[]{266694345078347784L});
        FOLLOW_args_in_mapTemplateRef692 = new BitSet(new long[]{8});
        FOLLOW_subtemplate_in_mapTemplateRef705 = new BitSet(new long[]{2});
        FOLLOW_INCLUDE_IND_in_mapTemplateRef717 = new BitSet(new long[]{4});
        FOLLOW_expr_in_mapTemplateRef719 = new BitSet(new long[]{266694345078347784L});
        FOLLOW_args_in_mapTemplateRef729 = new BitSet(new long[]{8});
        FOLLOW_EXEC_FUNC_in_includeExpr751 = new BitSet(new long[]{4});
        FOLLOW_ID_in_includeExpr753 = new BitSet(new long[]{266694345078341640L});
        FOLLOW_expr_in_includeExpr755 = new BitSet(new long[]{8});
        FOLLOW_INCLUDE_in_includeExpr766 = new BitSet(new long[]{4});
        FOLLOW_ID_in_includeExpr768 = new BitSet(new long[]{266694345078347784L});
        FOLLOW_args_in_includeExpr770 = new BitSet(new long[]{8});
        FOLLOW_INCLUDE_SUPER_in_includeExpr781 = new BitSet(new long[]{4});
        FOLLOW_ID_in_includeExpr783 = new BitSet(new long[]{266694345078347784L});
        FOLLOW_args_in_includeExpr785 = new BitSet(new long[]{8});
        FOLLOW_INCLUDE_REGION_in_includeExpr796 = new BitSet(new long[]{4});
        FOLLOW_ID_in_includeExpr798 = new BitSet(new long[]{8});
        FOLLOW_INCLUDE_SUPER_REGION_in_includeExpr808 = new BitSet(new long[]{4});
        FOLLOW_ID_in_includeExpr810 = new BitSet(new long[]{8});
        FOLLOW_primary_in_includeExpr818 = new BitSet(new long[]{2});
        FOLLOW_ID_in_primary829 = new BitSet(new long[]{2});
        FOLLOW_STRING_in_primary839 = new BitSet(new long[]{2});
        FOLLOW_TRUE_in_primary848 = new BitSet(new long[]{2});
        FOLLOW_FALSE_in_primary857 = new BitSet(new long[]{2});
        FOLLOW_subtemplate_in_primary866 = new BitSet(new long[]{2});
        FOLLOW_list_in_primary893 = new BitSet(new long[]{2});
        FOLLOW_INCLUDE_IND_in_primary900 = new BitSet(new long[]{4});
        FOLLOW_expr_in_primary905 = new BitSet(new long[]{266694345078347784L});
        FOLLOW_args_in_primary914 = new BitSet(new long[]{8});
        FOLLOW_TO_STR_in_primary934 = new BitSet(new long[]{4});
        FOLLOW_expr_in_primary936 = new BitSet(new long[]{8});
        FOLLOW_expr_in_arg949 = new BitSet(new long[]{2});
        FOLLOW_arg_in_args965 = new BitSet(new long[]{266694345078341634L});
        FOLLOW_EQUALS_in_args984 = new BitSet(new long[]{4});
        FOLLOW_ID_in_args986 = new BitSet(new long[]{266694345078341632L});
        FOLLOW_expr_in_args988 = new BitSet(new long[]{8});
        FOLLOW_ELLIPSIS_in_args1005 = new BitSet(new long[]{2});
        FOLLOW_ELLIPSIS_in_args1020 = new BitSet(new long[]{2});
        FOLLOW_LIST_in_list1040 = new BitSet(new long[]{4});
        FOLLOW_listElement_in_list1043 = new BitSet(new long[]{267820244985184264L});
        FOLLOW_expr_in_listElement1059 = new BitSet(new long[]{2});
        FOLLOW_NULL_in_listElement1063 = new BitSet(new long[]{2});
    }

    public CodeGenerator(TreeNodeStream r5) {
        this(r5, new RecognizerSharedState());
    }

    public int address() {
        return this.template_stack.peek().state.f678ip;
    }

    public final void arg() throws RecognitionException {
        pushFollow(FOLLOW_expr_in_arg949);     // Catch: Throwable -> L4 RecognitionException -> L6
        expr();     // Catch: Throwable -> L4 RecognitionException -> L6
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

    public final args_return args() throws RecognitionException {
        args_return r5 = new args_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L20 RecognitionException -> L22
        if (r10 == 3) goto L27;
        if (r10 == 40) goto L26;
        if (r10 == 11) goto L25;
        if (r10 == 12) goto L24;
        if (r10 == 25) goto L26;
        if (r10 == 26) goto L26;
        if (r10 == 35) goto L26;
        if (r10 == 36) goto L26;
        if (r10 == 48) goto L26;
        if (r10 == 49) goto L26;
        if (r10 == 52) goto L26;
        if (r10 == 53) goto L26;
        switch(r10) {
            case 42: goto L26;
            case 43: goto L26;
            case 44: goto L26;
            case 45: goto L26;
            case 46: goto L26;
            default: goto L17;
        };     // Catch: Throwable -> L20 RecognitionException -> L22
    L17:
        switch(r10) {
            case 55: goto L26;
            case 56: goto L26;
            case 57: goto L26;
            default: goto L19;
        };     // Catch: Throwable -> L20 RecognitionException -> L22
    L19:
        throw new NoViableAltException("", 24, 0, this.input);     // Catch: Throwable -> L20 RecognitionException -> L22
    L24:
        char r11 = 2;
    L29:
        if (r11 != 1) goto L31;
        int r12 = 0;
    L50:
        int r13 = this.input.LA(1);     // Catch: Throwable -> L20 RecognitionException -> L22
        if (r13 < 25) goto L55;
        if (r13 > 26) goto L55;
    L77:
        pushFollow(FOLLOW_arg_in_args965);     // Catch: Throwable -> L20 RecognitionException -> L22
        arg();     // Catch: Throwable -> L20 RecognitionException -> L22
        this.state._fsp--;     // Catch: Throwable -> L20 RecognitionException -> L22
        r5.f677n++;     // Catch: Throwable -> L20 RecognitionException -> L22
        r12 = r12 + 1;
    L55:
        if (r13 < 35) goto L57;
        if (r13 <= 36) goto L77;
    L57:
        if (r13 == 40) goto L77;
        if (r13 >= 42) goto L61;
    L62:
        if (r13 < 48) goto L65;
        if (r13 <= 49) goto L77;
    L65:
        if (r13 < 52) goto L68;
        if (r13 <= 53) goto L77;
    L68:
        if (r13 < 55) goto L73;
        if (r13 <= 57) goto L77;
    L73:
        if (r12 < 1) goto L76;
    L81:
        return r5;
    L76:
        throw new EarlyExitException(21, this.input);     // Catch: Throwable -> L20 RecognitionException -> L22
    L61:
        if (r13 <= 46) goto L77;
    L31:
        if (r11 == 2) goto L35;
        if (r11 != 3) goto L81;
        match(this.input, 11, FOLLOW_ELLIPSIS_in_args1020);     // Catch: Throwable -> L20 RecognitionException -> L22
        r5.passThru = true;     // Catch: Throwable -> L20 RecognitionException -> L22
        emit((CommonTree) r5.start, 21);     // Catch: Throwable -> L20 RecognitionException -> L22
        r5.namedArgs = true;     // Catch: Throwable -> L20 RecognitionException -> L22
        goto L81
    L35:
        emit((CommonTree) r5.start, 21);     // Catch: Throwable -> L20 RecognitionException -> L22
        int r14 = 1;
        r5.namedArgs = true;     // Catch: Throwable -> L20 RecognitionException -> L22
        int r15 = 0;
    L37:
        if (this.input.LA(r14) != 12) goto L43;
        CommonTree r16 = (CommonTree) match(this.input, 12, FOLLOW_EQUALS_in_args984);     // Catch: Throwable -> L20 RecognitionException -> L22
        String r17 = null;
        match(this.input, 2, null);     // Catch: Throwable -> L20 RecognitionException -> L22
        CommonTree r18 = (CommonTree) match(this.input, 25, FOLLOW_ID_in_args986);     // Catch: Throwable -> L20 RecognitionException -> L22
        pushFollow(FOLLOW_expr_in_args988);     // Catch: Throwable -> L20 RecognitionException -> L22
        expr();     // Catch: Throwable -> L20 RecognitionException -> L22
        this.state._fsp--;     // Catch: Throwable -> L20 RecognitionException -> L22
        match(this.input, 3, null);     // Catch: Throwable -> L20 RecognitionException -> L22
        r5.f677n++;     // Catch: Throwable -> L20 RecognitionException -> L22
        if (r18 == null) goto L41;
        r17 = r18.getText();     // Catch: Throwable -> L20 RecognitionException -> L22
    L41:
        emit1(r16, 7, defineString(r17));     // Catch: Throwable -> L20 RecognitionException -> L22
        r15 = r15 + 1;     // Catch: Throwable -> L20 RecognitionException -> L22
        r14 = 1;
        goto L37
    L43:
        if (r15 < 1) goto L48;
        if (this.input.LA(1) != 11) goto L81;
        match(this.input, 11, FOLLOW_ELLIPSIS_in_args1005);     // Catch: Throwable -> L20 RecognitionException -> L22
        r5.passThru = true;     // Catch: Throwable -> L20 RecognitionException -> L22
        goto L81
    L48:
        throw new EarlyExitException(22, this.input);     // Catch: Throwable -> L20 RecognitionException -> L22
    L25:
        r11 = 3;
    L26:
        r11 = 1;
        goto L29
    L27:
        r11 = 4;
    L22:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L20:
        th = move-exception;
        throw th;
    }

    public final void chunk() throws RecognitionException {
    L23:
        int r5 = this.input.LA(1);     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r5 == 4) goto L14;
        if (r5 == 22) goto L14;
        if (r5 == 32) goto L14;
        if (r5 == 41) goto L14;
        if (r5 == 47) goto L14;
        if (r5 == 54) goto L14;
        return;
    L14:
        pushFollow(FOLLOW_element_in_chunk92);     // Catch: Throwable -> L16 RecognitionException -> L18
        element();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
    L18:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void compoundElement(CommonTree r10) throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r5 != 4) goto L6;
        char r11 = 1;
    L8:
        if (r11 == 1) goto L16;
        if (r11 != 2) goto L23;
        pushFollow(FOLLOW_region_in_compoundElement184);     // Catch: Throwable -> L12 RecognitionException -> L14
        region(r10);     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        return;
    L23:
        return;
    L16:
        pushFollow(FOLLOW_ifstat_in_compoundElement178);     // Catch: Throwable -> L12 RecognitionException -> L14
        ifstat(r10);     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        return;
    L6:
        if (r5 != 54) goto L18;
        r11 = 2;
        goto L8
    L18:
        throw new NoViableAltException("", 4, 0, this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final conditional_return conditional() throws RecognitionException {
        conditional_return r5 = new conditional_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L28 RecognitionException -> L30
        if (r10 != 10) goto L6;
        char r11 = 3;
    L37:
        if (r11 == 1) goto L45;
        if (r11 == 2) goto L44;
        if (r11 == 3) goto L43;
        if (r11 != 4) goto L49;
        pushFollow(FOLLOW_expr_in_conditional527);     // Catch: Throwable -> L28 RecognitionException -> L30
        expr();     // Catch: Throwable -> L28 RecognitionException -> L30
        this.state._fsp--;     // Catch: Throwable -> L28 RecognitionException -> L30
    L49:
        return r5;
    L43:
        CommonTree r12 = (CommonTree) match(this.input, 10, FOLLOW_BANG_in_conditional513);     // Catch: Throwable -> L28 RecognitionException -> L30
        match(this.input, 2, null);     // Catch: Throwable -> L28 RecognitionException -> L30
        pushFollow(FOLLOW_conditional_in_conditional515);     // Catch: Throwable -> L28 RecognitionException -> L30
        conditional();     // Catch: Throwable -> L28 RecognitionException -> L30
        this.state._fsp--;     // Catch: Throwable -> L28 RecognitionException -> L30
        match(this.input, 3, null);     // Catch: Throwable -> L28 RecognitionException -> L30
        emit(r12, 36);     // Catch: Throwable -> L28 RecognitionException -> L30
        goto L49
    L44:
        CommonTree r13 = (CommonTree) match(this.input, 30, FOLLOW_AND_in_conditional499);     // Catch: Throwable -> L28 RecognitionException -> L30
        match(this.input, 2, null);     // Catch: Throwable -> L28 RecognitionException -> L30
        pushFollow(FOLLOW_conditional_in_conditional501);     // Catch: Throwable -> L28 RecognitionException -> L30
        conditional();     // Catch: Throwable -> L28 RecognitionException -> L30
        this.state._fsp--;     // Catch: Throwable -> L28 RecognitionException -> L30
        pushFollow(FOLLOW_conditional_in_conditional503);     // Catch: Throwable -> L28 RecognitionException -> L30
        conditional();     // Catch: Throwable -> L28 RecognitionException -> L30
        this.state._fsp--;     // Catch: Throwable -> L28 RecognitionException -> L30
        match(this.input, 3, null);     // Catch: Throwable -> L28 RecognitionException -> L30
        emit(r13, 38);     // Catch: Throwable -> L28 RecognitionException -> L30
        goto L49
    L45:
        CommonTree r14 = (CommonTree) match(this.input, 29, FOLLOW_OR_in_conditional485);     // Catch: Throwable -> L28 RecognitionException -> L30
        match(this.input, 2, null);     // Catch: Throwable -> L28 RecognitionException -> L30
        pushFollow(FOLLOW_conditional_in_conditional487);     // Catch: Throwable -> L28 RecognitionException -> L30
        conditional();     // Catch: Throwable -> L28 RecognitionException -> L30
        this.state._fsp--;     // Catch: Throwable -> L28 RecognitionException -> L30
        pushFollow(FOLLOW_conditional_in_conditional489);     // Catch: Throwable -> L28 RecognitionException -> L30
        conditional();     // Catch: Throwable -> L28 RecognitionException -> L30
        this.state._fsp--;     // Catch: Throwable -> L28 RecognitionException -> L30
        match(this.input, 3, null);     // Catch: Throwable -> L28 RecognitionException -> L30
        emit(r14, 37);     // Catch: Throwable -> L28 RecognitionException -> L30
        goto L49
    L6:
        if (r10 != 40) goto L8;
    L34:
        r11 = 4;
        goto L37
    L8:
        if (r10 == 25) goto L34;
        if (r10 == 26) goto L34;
        if (r10 == 29) goto L33;
        if (r10 != 30) goto L14;
        r11 = 2;
        goto L37
    L14:
        if (r10 == 35) goto L34;
        if (r10 == 36) goto L34;
        if (r10 == 48) goto L34;
        if (r10 == 49) goto L34;
        if (r10 == 52) goto L34;
        if (r10 == 53) goto L34;
        switch(r10) {
            case 42: goto L34;
            case 43: goto L34;
            case 44: goto L34;
            case 45: goto L34;
            case 46: goto L34;
            default: goto L25;
        };     // Catch: Throwable -> L28 RecognitionException -> L30
    L25:
        switch(r10) {
            case 55: goto L34;
            case 56: goto L34;
            case 57: goto L34;
            default: goto L27;
        };     // Catch: Throwable -> L28 RecognitionException -> L30
    L27:
        throw new NoViableAltException("", 11, 0, this.input);     // Catch: Throwable -> L28 RecognitionException -> L30
    L33:
        r11 = 1;
    L30:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L28:
        th = move-exception;
        throw th;
    }

    public int defineString(String r5) {
        return this.template_stack.peek().state.defineString(r5);
    }

    public final void element() throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r5 != 4) goto L6;
    L60:
        char r10 = 2;
    L62:
        if (r10 == 1) goto L70;
        if (r10 == 2) goto L69;
        if (r10 == 3) goto L68;
        if (r10 != 4) goto L84;
        pushFollow(FOLLOW_singleElement_in_element138);     // Catch: Throwable -> L17 RecognitionException -> L19
        singleElement();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        return;
    L84:
        return;
    L68:
        match(this.input, 47, FOLLOW_INDENTED_EXPR_in_element124);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 2, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        this.template_stack.peek().state.indent((CommonTree) match(this.input, 31, FOLLOW_INDENT_in_element126));     // Catch: Throwable -> L17 RecognitionException -> L19
        pushFollow(FOLLOW_singleElement_in_element130);     // Catch: Throwable -> L17 RecognitionException -> L19
        singleElement();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        this.template_stack.peek().state.emit(40);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 3, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        return;
    L69:
        pushFollow(FOLLOW_compoundElement_in_element117);     // Catch: Throwable -> L17 RecognitionException -> L19
        compoundElement(null);     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        return;
    L70:
        match(this.input, 47, FOLLOW_INDENTED_EXPR_in_element105);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 2, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        CommonTree r11 = (CommonTree) match(this.input, 31, FOLLOW_INDENT_in_element107);     // Catch: Throwable -> L17 RecognitionException -> L19
        pushFollow(FOLLOW_compoundElement_in_element109);     // Catch: Throwable -> L17 RecognitionException -> L19
        compoundElement(r11);     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 3, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        return;
    L6:
        if (r5 != 22) goto L8;
    L59:
        r10 = 4;
        goto L62
    L8:
        if (r5 == 32) goto L59;
        if (r5 == 41) goto L59;
        int r12 = 0;
        if (r5 == 47) goto L22;
        if (r5 == 54) goto L60;
        throw new NoViableAltException("", 2, 0, this.input);     // Catch: Throwable -> L17 RecognitionException -> L19
    L22:
        if (this.input.LA(2) == 2) goto L24;
        int r13 = this.input.mark();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.input.consume();     // Catch: Throwable -> L56
        throw new NoViableAltException("", 2, 1, this.input);     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        this.input.rewind(r13);     // Catch: Throwable -> L17 RecognitionException -> L19
        throw th;     // Catch: Throwable -> L17 RecognitionException -> L19
    L24:
        if (this.input.LA(3) != 31) goto L44;
        int r14 = this.input.LA(4);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r14 == 4) goto L43;
        if (r14 == 54) goto L43;
        if (r14 == 22) goto L42;
        if (r14 == 32) goto L42;
        if (r14 == 41) goto L42;
        int r15 = this.input.mark();     // Catch: Throwable -> L17 RecognitionException -> L19
    L34:
        if (r12 >= 3) goto L39;
        this.input.consume();     // Catch: Throwable -> L36
        r12 = r12 + 1;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        this.input.rewind(r15);     // Catch: Throwable -> L17 RecognitionException -> L19
        throw th;     // Catch: Throwable -> L17 RecognitionException -> L19
    L39:
        throw new NoViableAltException("", 2, 5, this.input);     // Catch: Throwable -> L36
    L42:
        r10 = 3;
    L43:
        r10 = 1;
        goto L62
    L44:
        int r16 = this.input.mark();     // Catch: Throwable -> L17 RecognitionException -> L19
    L45:
        if (r12 >= 2) goto L50;
        this.input.consume();     // Catch: Throwable -> L47
        r12 = r12 + 1;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        this.input.rewind(r16);     // Catch: Throwable -> L17 RecognitionException -> L19
        throw th;     // Catch: Throwable -> L17 RecognitionException -> L19
    L50:
        throw new NoViableAltException("", 2, 4, this.input);     // Catch: Throwable -> L47
    L19:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public void emit(CommonTree r5, short r10) {
        this.template_stack.peek().state.emit(r5, r10);
    }

    public void emit1(CommonTree r5, short r10, int r11) {
        this.template_stack.peek().state.emit1(r5, r10, r11);
    }

    public void emit2(CommonTree r5, short r10, int r11, int r12) {
        this.template_stack.peek().state.emit2(r5, r10, r11, r12);
    }

    public final void expr() throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
        short r12 = 15;
        if (r5 == 25) goto L24;
        if (r5 == 26) goto L24;
        if (r5 == 35) goto L24;
        if (r5 == 36) goto L24;
        if (r5 == 40) goto L24;
        if (r5 == 48) goto L24;
        if (r5 == 49) goto L23;
        if (r5 == 52) goto L22;
        if (r5 == 53) goto L22;
        switch(r5) {
            case 42: goto L24;
            case 43: goto L24;
            case 44: goto L24;
            case 45: goto L24;
            case 46: goto L24;
            default: goto L14;
        };     // Catch: Throwable -> L17 RecognitionException -> L19
    L14:
        switch(r5) {
            case 55: goto L24;
            case 56: goto L24;
            case 57: goto L21;
            default: goto L16;
        };     // Catch: Throwable -> L17 RecognitionException -> L19
    L21:
        char r10 = 1;
    L25:
        int r11 = 42;
        BitSet r13 = null;
        if (r10 == 1) goto L50;
        if (r10 == 2) goto L34;
        if (r10 != 3) goto L30;
        pushFollow(FOLLOW_prop_in_expr623);     // Catch: Throwable -> L17 RecognitionException -> L19
        prop();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        return;
    L30:
        if (r10 != 4) goto L89;
        pushFollow(FOLLOW_includeExpr_in_expr628);     // Catch: Throwable -> L17 RecognitionException -> L19
        includeExpr();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        return;
    L89:
        return;
    L34:
        CommonTree r14 = (CommonTree) match(this.input, 49, FOLLOW_MAP_in_expr603);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 2, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        pushFollow(FOLLOW_expr_in_expr605);     // Catch: Throwable -> L17 RecognitionException -> L19
        expr();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        int r15 = 0;
        int r16 = 0;
    L35:
        int r17 = this.input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r17 >= 42) goto L38;
    L39:
        if (r17 == 55) goto L40;
        if (r15 < 1) goto L49;
        match(this.input, 3, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r16 <= 1) goto L47;
        if (r16 <= 1) goto L46;
        r12 = 16;
    L46:
        emit1(r14, r12, r16);     // Catch: Throwable -> L17 RecognitionException -> L19
        return;
    L47:
        emit(r14, 15);     // Catch: Throwable -> L17 RecognitionException -> L19
        return;
    L49:
        throw new EarlyExitException(14, this.input);     // Catch: Throwable -> L17 RecognitionException -> L19
    L40:
        pushFollow(FOLLOW_mapTemplateRef_in_expr608);     // Catch: Throwable -> L17 RecognitionException -> L19
        mapTemplateRef(1);     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        r16 = r16 + 1;     // Catch: Throwable -> L17 RecognitionException -> L19
        r15 = r15 + 1;     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L35
    L38:
        if (r17 <= 43) goto L40;
    L50:
        CommonTree r18 = (CommonTree) match(this.input, 57, FOLLOW_ZIP_in_expr578);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 2, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 39, FOLLOW_ELEMENTS_in_expr581);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 2, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        int r19 = 0;
        int r110 = 0;
    L51:
        int r111 = this.input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r111 < 25) goto L56;
        if (r111 > 26) goto L56;
    L78:
        pushFollow(FOLLOW_expr_in_expr584);     // Catch: Throwable -> L17 RecognitionException -> L19
        expr();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        r110 = r110 + 1;
        r19 = r19 + 1;
        r11 = 42;
        r13 = null;
    L56:
        if (r111 < 35) goto L58;
        if (r111 <= 36) goto L78;
    L58:
        if (r111 == 40) goto L78;
        if (r111 >= r11) goto L61;
    L62:
        if (r111 < 48) goto L65;
        if (r111 <= 49) goto L78;
    L65:
        if (r111 < 52) goto L70;
        if (r111 <= 53) goto L78;
    L70:
        if (r111 < 55) goto L74;
        if (r111 <= 57) goto L78;
    L74:
        if (r19 < 1) goto L77;
        match(this.input, 3, r13);     // Catch: Throwable -> L17 RecognitionException -> L19
        pushFollow(FOLLOW_mapTemplateRef_in_expr591);     // Catch: Throwable -> L17 RecognitionException -> L19
        mapTemplateRef(r110);     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 3, r13);     // Catch: Throwable -> L17 RecognitionException -> L19
        emit1(r18, 17, r110);     // Catch: Throwable -> L17 RecognitionException -> L19
        return;
    L77:
        throw new EarlyExitException(13, this.input);     // Catch: Throwable -> L17 RecognitionException -> L19
    L61:
        if (r111 <= 46) goto L78;
    L16:
        throw new NoViableAltException("", 15, 0, this.input);     // Catch: Throwable -> L17 RecognitionException -> L19
    L22:
        r10 = 3;
        goto L25
    L23:
        r10 = 2;
    L24:
        r10 = 4;
    L19:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final void exprElement() throws RecognitionException {
        CommonTree r5 = (CommonTree) match(this.input, 41, FOLLOW_EXPR_in_exprElement203);     // Catch: Throwable -> L5 RecognitionException -> L7
        match(this.input, 2, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        pushFollow(FOLLOW_expr_in_exprElement205);     // Catch: Throwable -> L5 RecognitionException -> L7
        expr();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        if (this.input.LA(1) != 51) goto L9;
        pushFollow(FOLLOW_exprOptions_in_exprElement208);     // Catch: Throwable -> L5 RecognitionException -> L7
        exprOptions();     // Catch: Throwable -> L5 RecognitionException -> L7
        this.state._fsp--;     // Catch: Throwable -> L5 RecognitionException -> L7
        short r10 = 14;
    L10:
        match(this.input, 3, null);     // Catch: Throwable -> L5 RecognitionException -> L7
        emit(r5, r10);     // Catch: Throwable -> L5 RecognitionException -> L7
    L17:
        return;
    L9:
        r10 = 13;
    L7:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L5:
        th = move-exception;
        throw th;
    }

    public final exprOptions_return exprOptions() throws RecognitionException {
        exprOptions_return r5 = new exprOptions_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        emit((CommonTree) r10, 20);     // Catch: Throwable -> L9 RecognitionException -> L11
        match(this.input, 51, FOLLOW_OPTIONS_in_exprOptions541);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (this.input.LA(1) != 2) goto L17;
        match(this.input, 2, null);     // Catch: Throwable -> L9 RecognitionException -> L11
    L7:
        if (this.input.LA(1) != 12) goto L13;
        pushFollow(FOLLOW_option_in_exprOptions543);     // Catch: Throwable -> L9 RecognitionException -> L11
        option();     // Catch: Throwable -> L9 RecognitionException -> L11
        this.state._fsp--;     // Catch: Throwable -> L9 RecognitionException -> L11
        goto L7
    L13:
        match(this.input, 3, null);     // Catch: Throwable -> L9 RecognitionException -> L11
    L17:
        return r5;
    L11:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L9:
        th = move-exception;
        throw th;
    }

    public void func(CommonTree r5) {
        this.template_stack.peek().state.func(this.templateToken, r5);
    }

    public TreeParser[] getDelegates() {
        return new TreeParser[0];
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String getGrammarFileName() {
        return "org\\stringtemplate\\v4\\compiler\\CodeGenerator.g";
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer
    public String[] getTokenNames() {
        return tokenNames;
    }

    public final void ifstat(CommonTree r13) throws RecognitionException {
        ArrayList r5 = new ArrayList();
        if (r13 == null) goto L36;
        this.template_stack.peek().state.indent(r13);
    L36:
        CommonTree r10 = (CommonTree) match(this.input, 4, FOLLOW_IF_in_ifstat366);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        pushFollow(FOLLOW_conditional_in_ifstat368);     // Catch: Throwable -> L11 RecognitionException -> L13
        conditional();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        int r11 = address() + 1;     // Catch: Throwable -> L11 RecognitionException -> L13
        int r12 = -1;
        emit1(r10, 19, -1);     // Catch: Throwable -> L11 RecognitionException -> L13
        pushFollow(FOLLOW_chunk_in_ifstat378);     // Catch: Throwable -> L11 RecognitionException -> L13
        chunk();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
    L7:
        if (this.input.LA(1) != 6) goto L18;
        CommonTree r14 = (CommonTree) match(this.input, 6, FOLLOW_ELSEIF_in_ifstat388);     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.add(Integer.valueOf(address() + 1));     // Catch: Throwable -> L11 RecognitionException -> L13
        emit1(r14, 18, -1);     // Catch: Throwable -> L11 RecognitionException -> L13
        write(r11, (short) address());     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        pushFollow(FOLLOW_conditional_in_ifstat402);     // Catch: Throwable -> L11 RecognitionException -> L13
        conditional_return r15 = conditional();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        r11 = address() + 1;     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r15 == null) goto L15;
        CommonTree r16 = (CommonTree) r15.start;     // Catch: Throwable -> L11 RecognitionException -> L13
    L16:
        emit1(r16, 19, -1);     // Catch: Throwable -> L11 RecognitionException -> L13
        pushFollow(FOLLOW_chunk_in_ifstat414);     // Catch: Throwable -> L11 RecognitionException -> L13
        chunk();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L7
    L15:
        r16 = null;
        goto L16
    L18:
        if (this.input.LA(1) != 5) goto L22;
        CommonTree r17 = (CommonTree) match(this.input, 5, FOLLOW_ELSE_in_ifstat437);     // Catch: Throwable -> L11 RecognitionException -> L13
        r5.add(Integer.valueOf(address() + 1));     // Catch: Throwable -> L11 RecognitionException -> L13
        emit1(r17, 18, -1);     // Catch: Throwable -> L11 RecognitionException -> L13
        write(r11, (short) address());     // Catch: Throwable -> L11 RecognitionException -> L13
        if (this.input.LA(1) != 2) goto L23;
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        pushFollow(FOLLOW_chunk_in_ifstat451);     // Catch: Throwable -> L11 RecognitionException -> L13
        chunk();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
    L23:
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r12 < 0) goto L26;
        write(r12, (short) address());     // Catch: Throwable -> L11 RecognitionException -> L13
    L26:
        Iterator r18 = r5.iterator();     // Catch: Throwable -> L11 RecognitionException -> L13
    L28:
        if (r18.hasNext() == false) goto L30;
        write(((Integer) r18.next()).intValue(), (short) address());     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L28
    L30:
        if (r13 == null) goto L42;
        this.template_stack.peek().state.emit(40);     // Catch: Throwable -> L11 RecognitionException -> L13
    L43:
        return;
    L42:
        return;
    L22:
        r12 = r11;
    L13:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final includeExpr_return includeExpr() throws RecognitionException {
        includeExpr_return r5 = new includeExpr_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L16 RecognitionException -> L18
        int r11 = 0;
        if (r10 == 25) goto L25;
        if (r10 == 26) goto L25;
        if (r10 == 35) goto L25;
        if (r10 == 36) goto L25;
        if (r10 == 40) goto L24;
        if (r10 == 48) goto L25;
        if (r10 == 55) goto L25;
        if (r10 == 56) goto L25;
        switch(r10) {
            case 42: goto L23;
            case 43: goto L25;
            case 44: goto L22;
            case 45: goto L21;
            case 46: goto L20;
            default: goto L15;
        };     // Catch: Throwable -> L16 RecognitionException -> L18
    L20:
        char r12 = 5;
    L26:
        String r13 = null;
        switch(r12) {
            case 1: goto L75;
            case 2: goto L55;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L30;
            case 6: goto L29;
            default: goto L102;
        };     // Catch: Throwable -> L16 RecognitionException -> L18
    L29:
        pushFollow(FOLLOW_primary_in_includeExpr818);     // Catch: Throwable -> L16 RecognitionException -> L18
        primary();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L102
    L30:
        CommonTree r14 = (CommonTree) match(this.input, 46, FOLLOW_INCLUDE_SUPER_REGION_in_includeExpr808);     // Catch: Throwable -> L16 RecognitionException -> L18
        match(this.input, 2, null);     // Catch: Throwable -> L16 RecognitionException -> L18
        CommonTree r15 = (CommonTree) match(this.input, 25, FOLLOW_ID_in_includeExpr810);     // Catch: Throwable -> L16 RecognitionException -> L18
        match(this.input, 3, null);     // Catch: Throwable -> L16 RecognitionException -> L18
        String r16 = this.outermostImpl.name;     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r15 == null) goto L33;
        r13 = r15.getText();     // Catch: Throwable -> L16 RecognitionException -> L18
    L33:
        emit2(r14, 11, STGroup.getMangledRegionName(r16, r13), 0);     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L102
    L34:
        CommonTree r17 = (CommonTree) match(this.input, 44, FOLLOW_INCLUDE_REGION_in_includeExpr796);     // Catch: Throwable -> L16 RecognitionException -> L18
        match(this.input, 2, null);     // Catch: Throwable -> L16 RecognitionException -> L18
        CommonTree r18 = (CommonTree) match(this.input, 25, FOLLOW_ID_in_includeExpr798);     // Catch: Throwable -> L16 RecognitionException -> L18
        match(this.input, 3, null);     // Catch: Throwable -> L16 RecognitionException -> L18
        emit2(r17, 8, Compiler.defineBlankRegion(this.outermostImpl, r18.token).name, 0);     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L102
    L35:
        CommonTree r19 = (CommonTree) match(this.input, 45, FOLLOW_INCLUDE_SUPER_in_includeExpr781);     // Catch: Throwable -> L16 RecognitionException -> L18
        match(this.input, 2, null);     // Catch: Throwable -> L16 RecognitionException -> L18
        CommonTree r20 = (CommonTree) match(this.input, 25, FOLLOW_ID_in_includeExpr783);     // Catch: Throwable -> L16 RecognitionException -> L18
        pushFollow(FOLLOW_args_in_includeExpr785);     // Catch: Throwable -> L16 RecognitionException -> L18
        args_return r21 = args();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        match(this.input, 3, null);     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r21 != null) goto L38;
    L44:
        if (r21 != null) goto L46;
    L50:
        if (r20 == null) goto L52;
        r13 = r20.getText();     // Catch: Throwable -> L16 RecognitionException -> L18
    L52:
        if (r21 == null) goto L54;
        r11 = r21.f677n;     // Catch: Throwable -> L16 RecognitionException -> L18
    L54:
        emit2(r19, 11, r13, r11);     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L102
    L46:
        if (r21.namedArgs == false) goto L50;
        if (r20 == null) goto L49;
        r13 = r20.getText();     // Catch: Throwable -> L16 RecognitionException -> L18
    L49:
        emit1(r19, 12, r13);     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L102
    L38:
        if (r21.passThru == false) goto L44;
        CommonTree r22 = (CommonTree) r5.start;     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r20 == null) goto L42;
        String r23 = r20.getText();     // Catch: Throwable -> L16 RecognitionException -> L18
    L43:
        emit1(r22, 22, r23);     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L44
    L42:
        r23 = null;
        goto L43
    L55:
        CommonTree r24 = (CommonTree) match(this.input, 42, FOLLOW_INCLUDE_in_includeExpr766);     // Catch: Throwable -> L16 RecognitionException -> L18
        match(this.input, 2, null);     // Catch: Throwable -> L16 RecognitionException -> L18
        CommonTree r25 = (CommonTree) match(this.input, 25, FOLLOW_ID_in_includeExpr768);     // Catch: Throwable -> L16 RecognitionException -> L18
        pushFollow(FOLLOW_args_in_includeExpr770);     // Catch: Throwable -> L16 RecognitionException -> L18
        args_return r26 = args();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
        match(this.input, 3, null);     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r26 != null) goto L58;
    L64:
        if (r26 != null) goto L66;
    L70:
        if (r25 == null) goto L72;
        r13 = r25.getText();     // Catch: Throwable -> L16 RecognitionException -> L18
    L72:
        if (r26 == null) goto L74;
        r11 = r26.f677n;     // Catch: Throwable -> L16 RecognitionException -> L18
    L74:
        emit2(r24, 8, r13, r11);     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L102
    L66:
        if (r26.namedArgs == false) goto L70;
        if (r25 == null) goto L69;
        r13 = r25.getText();     // Catch: Throwable -> L16 RecognitionException -> L18
    L69:
        emit1(r24, 10, r13);     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L102
    L58:
        if (r26.passThru == false) goto L64;
        CommonTree r27 = (CommonTree) r5.start;     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r25 == null) goto L62;
        String r28 = r25.getText();     // Catch: Throwable -> L16 RecognitionException -> L18
    L63:
        emit1(r27, 22, r28);     // Catch: Throwable -> L16 RecognitionException -> L18
        goto L64
    L62:
        r28 = null;
        goto L63
    L75:
        match(this.input, 40, FOLLOW_EXEC_FUNC_in_includeExpr751);     // Catch: Throwable -> L16 RecognitionException -> L18
        match(this.input, 2, null);     // Catch: Throwable -> L16 RecognitionException -> L18
        CommonTree r29 = (CommonTree) match(this.input, 25, FOLLOW_ID_in_includeExpr753);     // Catch: Throwable -> L16 RecognitionException -> L18
        int r30 = this.input.LA(1);     // Catch: Throwable -> L16 RecognitionException -> L18
        if (r30 < 25) goto L79;
        if (r30 > 26) goto L79;
    L97:
        pushFollow(FOLLOW_expr_in_includeExpr755);     // Catch: Throwable -> L16 RecognitionException -> L18
        expr();     // Catch: Throwable -> L16 RecognitionException -> L18
        this.state._fsp--;     // Catch: Throwable -> L16 RecognitionException -> L18
    L98:
        match(this.input, 3, null);     // Catch: Throwable -> L16 RecognitionException -> L18
        func(r29);     // Catch: Throwable -> L16 RecognitionException -> L18
    L79:
        if (r30 >= 35) goto L81;
    L82:
        if (r30 == 40) goto L97;
        if (r30 < 42) goto L86;
        if (r30 <= 46) goto L97;
    L86:
        if (r30 < 48) goto L90;
        if (r30 <= 49) goto L97;
    L90:
        if (r30 < 52) goto L94;
        if (r30 <= 53) goto L97;
    L94:
        if (r30 < 55) goto L98;
        if (r30 > 57) goto L98;
    L81:
        if (r30 <= 36) goto L97;
    L102:
        return r5;
    L21:
        r12 = 3;
        goto L26
    L22:
        r12 = 4;
        goto L26
    L23:
        r12 = 2;
        goto L26
    L15:
        throw new NoViableAltException("", 19, 0, this.input);     // Catch: Throwable -> L16 RecognitionException -> L18
    L24:
        r12 = 1;
    L25:
        r12 = 6;
    L18:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L16:
        th = move-exception;
        throw th;
    }

    public void insert(int r5, short r10, String r11) {
        this.template_stack.peek().state.insert(r5, r10, r11);
    }

    public final list_return list() throws RecognitionException {
        list_return r5 = new list_return();
        Object r10 = this.input.LT(1);
        r5.start = r10;
        emit((CommonTree) r10, 24);     // Catch: Throwable -> L33 RecognitionException -> L35
        match(this.input, 48, FOLLOW_LIST_in_list1040);     // Catch: Throwable -> L33 RecognitionException -> L35
        if (this.input.LA(1) != 2) goto L45;
        match(this.input, 2, null);     // Catch: Throwable -> L33 RecognitionException -> L35
    L6:
        int r11 = this.input.LA(1);     // Catch: Throwable -> L33 RecognitionException -> L35
        if (r11 < 25) goto L11;
        if (r11 > 26) goto L11;
    L37:
        pushFollow(FOLLOW_listElement_in_list1043);     // Catch: Throwable -> L33 RecognitionException -> L35
        listElement_return r12 = listElement();     // Catch: Throwable -> L33 RecognitionException -> L35
        this.state._fsp--;     // Catch: Throwable -> L33 RecognitionException -> L35
        if (r12 == null) goto L40;
        CommonTree r13 = (CommonTree) r12.start;     // Catch: Throwable -> L33 RecognitionException -> L35
    L41:
        emit(r13, 25);     // Catch: Throwable -> L33 RecognitionException -> L35
        goto L6
    L40:
        r13 = null;
    L11:
        if (r11 < 35) goto L15;
        if (r11 <= 36) goto L37;
    L15:
        if (r11 == 40) goto L37;
        if (r11 >= 42) goto L19;
    L20:
        if (r11 < 48) goto L24;
        if (r11 <= 50) goto L37;
    L24:
        if (r11 < 52) goto L28;
        if (r11 <= 53) goto L37;
    L28:
        if (r11 < 55) goto L32;
        if (r11 <= 57) goto L37;
    L32:
        match(this.input, 3, null);     // Catch: Throwable -> L33 RecognitionException -> L35
    L19:
        if (r11 <= 46) goto L37;
    L45:
        return r5;
    L35:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L33:
        th = move-exception;
        throw th;
    }

    public final listElement_return listElement() throws RecognitionException {
        listElement_return r5 = new listElement_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L33 RecognitionException -> L35
        if (r10 < 25) goto L7;
        if (r10 > 26) goto L7;
    L37:
        char r11 = 1;
    L38:
        if (r11 == 1) goto L42;
        if (r11 != 2) goto L46;
        emit((CommonTree) match(this.input, 50, FOLLOW_NULL_in_listElement1063), 44);     // Catch: Throwable -> L33 RecognitionException -> L35
    L46:
        return r5;
    L42:
        pushFollow(FOLLOW_expr_in_listElement1059);     // Catch: Throwable -> L33 RecognitionException -> L35
        expr();     // Catch: Throwable -> L33 RecognitionException -> L35
        this.state._fsp--;     // Catch: Throwable -> L33 RecognitionException -> L35
    L7:
        if (r10 < 35) goto L11;
        if (r10 <= 36) goto L37;
    L11:
        if (r10 == 40) goto L37;
        if (r10 < 42) goto L17;
        if (r10 <= 46) goto L37;
    L17:
        if (r10 < 48) goto L21;
        if (r10 <= 49) goto L37;
    L21:
        if (r10 < 52) goto L25;
        if (r10 <= 53) goto L37;
    L25:
        if (r10 >= 55) goto L27;
    L29:
        if (r10 != 50) goto L32;
        r11 = 2;
        goto L38
    L32:
        throw new NoViableAltException("", 26, 0, this.input);     // Catch: Throwable -> L33 RecognitionException -> L35
    L27:
        if (r10 > 57) goto L29;
    L35:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L33:
        th = move-exception;
        throw th;
    }

    public final mapTemplateRef_return mapTemplateRef(int r20) throws RecognitionException {
        mapTemplateRef_return r5 = new mapTemplateRef_return();
        int r10 = 1;
        r5.start = this.input.LT(1);
        int r11 = this.input.LA(1);     // Catch: Throwable -> L11 RecognitionException -> L13
        int r12 = 0;
        if (r11 == 42) goto L16;
        if (r11 != 43) goto L7;
        char r13 = 3;
    L17:
        String r14 = null;
        if (r13 == 1) goto L53;
        if (r13 == 2) goto L29;
        if (r13 != 3) goto L79;
        CommonTree r15 = (CommonTree) match(this.input, 43, FOLLOW_INCLUDE_IND_in_mapTemplateRef717);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        pushFollow(FOLLOW_expr_in_mapTemplateRef719);     // Catch: Throwable -> L11 RecognitionException -> L13
        expr();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        emit(r15, 26);     // Catch: Throwable -> L11 RecognitionException -> L13
        int r16 = 1;
    L23:
        if (r16 > r20) goto L25;
        emit(r15, 44);     // Catch: Throwable -> L11 RecognitionException -> L13
        r16 = r16 + 1;     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L23
    L25:
        pushFollow(FOLLOW_args_in_mapTemplateRef729);     // Catch: Throwable -> L11 RecognitionException -> L13
        args_return r17 = args();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r17 == null) goto L28;
        r12 = r17.f677n;     // Catch: Throwable -> L11 RecognitionException -> L13
    L28:
        emit1(r15, 9, r12 + r20);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
    L79:
        return r5;
    L29:
        pushFollow(FOLLOW_subtemplate_in_mapTemplateRef705);     // Catch: Throwable -> L11 RecognitionException -> L13
        subtemplate_return r18 = subtemplate();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r18 == null) goto L32;
        int r19 = r18.nargs;     // Catch: Throwable -> L11 RecognitionException -> L13
    L33:
        if (r19 == r20) goto L42;
        ErrorManager r110 = this.errMgr;     // Catch: Throwable -> L11 RecognitionException -> L13
        ErrorType r111 = ErrorType.ANON_ARGUMENT_MISMATCH;     // Catch: Throwable -> L11 RecognitionException -> L13
        Token r112 = this.templateToken;     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r18 == null) goto L37;
        CommonTree r21 = (CommonTree) r18.start;     // Catch: Throwable -> L11 RecognitionException -> L13
    L38:
        Token r22 = r21.token;     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r18 == null) goto L41;
        r12 = r18.nargs;     // Catch: Throwable -> L11 RecognitionException -> L13
    L41:
        r110.compileTimeError(r111, r112, r22, Integer.valueOf(r12), Integer.valueOf(r20));     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L42
    L37:
        r21 = null;
    L42:
        if (r10 > r20) goto L47;
        if (r18 == null) goto L45;
        CommonTree r23 = (CommonTree) r18.start;     // Catch: Throwable -> L11 RecognitionException -> L13
    L46:
        emit(r23, 44);     // Catch: Throwable -> L11 RecognitionException -> L13
        r10 = r10 + 1;     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L42
    L45:
        r23 = null;
        goto L46
    L47:
        if (r18 == null) goto L49;
        CommonTree r24 = (CommonTree) r18.start;     // Catch: Throwable -> L11 RecognitionException -> L13
    L50:
        if (r18 == null) goto L52;
        r14 = r18.name;     // Catch: Throwable -> L11 RecognitionException -> L13
    L52:
        emit2(r24, 8, r14, r20);     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L79
    L49:
        r24 = null;
        goto L50
    L32:
        r19 = 0;
        goto L33
    L53:
        CommonTree r25 = (CommonTree) match(this.input, 42, FOLLOW_INCLUDE_in_mapTemplateRef680);     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 2, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        CommonTree r26 = (CommonTree) match(this.input, 25, FOLLOW_ID_in_mapTemplateRef682);     // Catch: Throwable -> L11 RecognitionException -> L13
        int r27 = 1;
    L54:
        if (r27 > r20) goto L56;
        emit(r25, 44);     // Catch: Throwable -> L11 RecognitionException -> L13
        r27 = r27 + 1;     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L54
    L56:
        pushFollow(FOLLOW_args_in_mapTemplateRef692);     // Catch: Throwable -> L11 RecognitionException -> L13
        args_return r28 = args();     // Catch: Throwable -> L11 RecognitionException -> L13
        this.state._fsp--;     // Catch: Throwable -> L11 RecognitionException -> L13
        match(this.input, 3, null);     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r28 != null) goto L59;
    L65:
        if (r28 != null) goto L67;
    L71:
        if (r26 == null) goto L73;
        r14 = r26.getText();     // Catch: Throwable -> L11 RecognitionException -> L13
    L73:
        if (r28 == null) goto L75;
        r12 = r28.f677n;     // Catch: Throwable -> L11 RecognitionException -> L13
    L75:
        emit2(r25, 8, r14, r12 + r20);     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L79
    L67:
        if (r28.namedArgs == false) goto L71;
        if (r26 == null) goto L70;
        r14 = r26.getText();     // Catch: Throwable -> L11 RecognitionException -> L13
    L70:
        emit1(r25, 10, r14);     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L79
    L59:
        if (r28.passThru == false) goto L65;
        CommonTree r29 = (CommonTree) r5.start;     // Catch: Throwable -> L11 RecognitionException -> L13
        if (r26 == null) goto L63;
        String r30 = r26.getText();     // Catch: Throwable -> L11 RecognitionException -> L13
    L64:
        emit1(r29, 22, r30);     // Catch: Throwable -> L11 RecognitionException -> L13
        goto L65
    L63:
        r30 = null;
        goto L64
    L7:
        if (r11 != 55) goto L10;
        r13 = 2;
        goto L17
    L10:
        throw new NoViableAltException("", 17, 0, this.input);     // Catch: Throwable -> L11 RecognitionException -> L13
    L16:
        r13 = 1;
    L13:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L11:
        th = move-exception;
        throw th;
    }

    public final void option() throws RecognitionException {
        match(this.input, 12, FOLLOW_EQUALS_in_option555);     // Catch: Throwable -> L4 RecognitionException -> L6
        match(this.input, 2, null);     // Catch: Throwable -> L4 RecognitionException -> L6
        CommonTree r5 = (CommonTree) match(this.input, 25, FOLLOW_ID_in_option557);     // Catch: Throwable -> L4 RecognitionException -> L6
        pushFollow(FOLLOW_expr_in_option559);     // Catch: Throwable -> L4 RecognitionException -> L6
        expr();     // Catch: Throwable -> L4 RecognitionException -> L6
        this.state._fsp--;     // Catch: Throwable -> L4 RecognitionException -> L6
        match(this.input, 3, null);     // Catch: Throwable -> L4 RecognitionException -> L6
        setOption(r5);     // Catch: Throwable -> L4 RecognitionException -> L6
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

    public final primary_return primary() throws RecognitionException {
        primary_return r5 = new primary_return();
        r5.start = this.input.LT(1);
        int r10 = this.input.LA(1);     // Catch: Throwable -> L17 RecognitionException -> L19
        int r11 = 0;
        if (r10 == 25) goto L27;
        if (r10 == 26) goto L26;
        if (r10 == 35) goto L25;
        if (r10 == 36) goto L24;
        if (r10 != 43) goto L10;
        char r12 = 7;
    L28:
        String r13 = null;
        switch(r12) {
            case 1: goto L47;
            case 2: goto L43;
            case 3: goto L42;
            case 4: goto L41;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L32;
            case 8: goto L31;
            default: goto L51;
        };     // Catch: Throwable -> L17 RecognitionException -> L19
    L31:
        CommonTree r14 = (CommonTree) match(this.input, 56, FOLLOW_TO_STR_in_primary934);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 2, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        pushFollow(FOLLOW_expr_in_primary936);     // Catch: Throwable -> L17 RecognitionException -> L19
        expr();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 3, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        emit(r14, 26);     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L51
    L32:
        CommonTree r15 = (CommonTree) match(this.input, 43, FOLLOW_INCLUDE_IND_in_primary900);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 2, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        pushFollow(FOLLOW_expr_in_primary905);     // Catch: Throwable -> L17 RecognitionException -> L19
        expr();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        emit(r15, 26);     // Catch: Throwable -> L17 RecognitionException -> L19
        pushFollow(FOLLOW_args_in_primary914);     // Catch: Throwable -> L17 RecognitionException -> L19
        args_return r16 = args();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r16 == null) goto L35;
        r11 = r16.f677n;     // Catch: Throwable -> L17 RecognitionException -> L19
    L35:
        emit1(r15, 9, r11);     // Catch: Throwable -> L17 RecognitionException -> L19
        match(this.input, 3, null);     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L51
    L36:
        pushFollow(FOLLOW_list_in_primary893);     // Catch: Throwable -> L17 RecognitionException -> L19
        list();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L51
    L37:
        pushFollow(FOLLOW_subtemplate_in_primary866);     // Catch: Throwable -> L17 RecognitionException -> L19
        subtemplate_return r17 = subtemplate();     // Catch: Throwable -> L17 RecognitionException -> L19
        this.state._fsp--;     // Catch: Throwable -> L17 RecognitionException -> L19
        CommonTree r18 = (CommonTree) r5.start;     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r17 == null) goto L40;
        r13 = r17.name;     // Catch: Throwable -> L17 RecognitionException -> L19
    L40:
        emit2(r18, 8, r13, 0);     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L51
    L41:
        emit((CommonTree) match(this.input, 36, FOLLOW_FALSE_in_primary857), 46);     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L51
    L42:
        emit((CommonTree) match(this.input, 35, FOLLOW_TRUE_in_primary848), 45);     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L51
    L43:
        CommonTree r19 = (CommonTree) match(this.input, 26, FOLLOW_STRING_in_primary839);     // Catch: Throwable -> L17 RecognitionException -> L19
        if (r19 == null) goto L46;
        r13 = r19.getText();     // Catch: Throwable -> L17 RecognitionException -> L19
    L46:
        emit1(r19, 1, Misc.strip(r13, 1));     // Catch: Throwable -> L17 RecognitionException -> L19
        goto L51
    L47:
        refAttr((CommonTree) match(this.input, 25, FOLLOW_ID_in_primary829));     // Catch: Throwable -> L17 RecognitionException -> L19
    L51:
        return r5;
    L10:
        if (r10 != 48) goto L12;
        r12 = 6;
        goto L28
    L12:
        if (r10 == 55) goto L21;
        if (r10 != 56) goto L16;
        r12 = '\b';
        goto L28
    L16:
        throw new NoViableAltException("", 20, 0, this.input);     // Catch: Throwable -> L17 RecognitionException -> L19
    L21:
        r12 = 5;
        goto L28
    L24:
        r12 = 4;
        goto L28
    L25:
        r12 = 3;
        goto L28
    L26:
        r12 = 2;
        goto L28
    L27:
        r12 = 1;
    L19:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L17:
        th = move-exception;
        throw th;
    }

    public final void prop() throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r5 != 52) goto L5;
        char r10 = 1;
    L7:
        String r11 = null;
        if (r10 == 1) goto L16;
        if (r10 != 2) goto L26;
        CommonTree r12 = (CommonTree) match(this.input, 53, FOLLOW_PROP_IND_in_prop656);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_expr_in_prop658);     // Catch: Throwable -> L12 RecognitionException -> L14
        expr();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_expr_in_prop660);     // Catch: Throwable -> L12 RecognitionException -> L14
        expr();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        emit(r12, 5);     // Catch: Throwable -> L12 RecognitionException -> L14
        return;
    L26:
        return;
    L16:
        CommonTree r13 = (CommonTree) match(this.input, 52, FOLLOW_PROP_in_prop638);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 2, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        pushFollow(FOLLOW_expr_in_prop640);     // Catch: Throwable -> L12 RecognitionException -> L14
        expr();     // Catch: Throwable -> L12 RecognitionException -> L14
        this.state._fsp--;     // Catch: Throwable -> L12 RecognitionException -> L14
        CommonTree r14 = (CommonTree) match(this.input, 25, FOLLOW_ID_in_prop642);     // Catch: Throwable -> L12 RecognitionException -> L14
        match(this.input, 3, null);     // Catch: Throwable -> L12 RecognitionException -> L14
        if (r14 == null) goto L19;
        r11 = r14.getText();     // Catch: Throwable -> L12 RecognitionException -> L14
    L19:
        emit1(r13, 4, r11);     // Catch: Throwable -> L12 RecognitionException -> L14
        return;
    L5:
        if (r5 != 53) goto L21;
        r10 = 2;
        goto L7
    L21:
        throw new NoViableAltException("", 16, 0, this.input);     // Catch: Throwable -> L12 RecognitionException -> L14
    L14:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void refAttr(CommonTree r5) {
        this.template_stack.peek().state.refAttr(this.templateToken, r5);
    }

    public final region_return region(CommonTree r10) throws RecognitionException {
        region_return r5 = new region_return();
        r5.start = this.input.LT(1);
        if (r10 == null) goto L20;
        this.template_stack.peek().state.indent(r10);
    L20:
        match(this.input, 54, FOLLOW_REGION_in_region246);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 2, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        CommonTree r11 = (CommonTree) match(this.input, 25, FOLLOW_ID_in_region248);     // Catch: Throwable -> L8 RecognitionException -> L10
        String r12 = this.outermostTemplateName;     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r11 == null) goto L12;
        String r13 = r11.getText();     // Catch: Throwable -> L8 RecognitionException -> L10
    L13:
        r5.name = STGroup.getMangledRegionName(r12, r13);     // Catch: Throwable -> L8 RecognitionException -> L10
        pushFollow(FOLLOW_template_in_region258);     // Catch: Throwable -> L8 RecognitionException -> L10
        CompiledST r14 = template(r5.name, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        this.state._fsp--;     // Catch: Throwable -> L8 RecognitionException -> L10
        r14.isRegion = true;     // Catch: Throwable -> L8 RecognitionException -> L10
        r14.regionDefType = ST.RegionType.EMBEDDED;     // Catch: Throwable -> L8 RecognitionException -> L10
        r14.templateDefStartToken = r11.token;     // Catch: Throwable -> L8 RecognitionException -> L10
        this.outermostImpl.addImplicitlyDefinedTemplate(r14);     // Catch: Throwable -> L8 RecognitionException -> L10
        emit2((CommonTree) r5.start, 8, r5.name, 0);     // Catch: Throwable -> L8 RecognitionException -> L10
        emit((CommonTree) r5.start, 13);     // Catch: Throwable -> L8 RecognitionException -> L10
        match(this.input, 3, null);     // Catch: Throwable -> L8 RecognitionException -> L10
        if (r10 == null) goto L19;
        this.template_stack.peek().state.emit(40);     // Catch: Throwable -> L8 RecognitionException -> L10
    L19:
        return r5;
    L12:
        r13 = null;
    L10:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L8:
        th = move-exception;
        throw th;
    }

    public void setOption(CommonTree r5) {
        this.template_stack.peek().state.setOption(r5);
    }

    public final void singleElement() throws RecognitionException {
        int r5 = this.input.LA(1);     // Catch: Throwable -> L9 RecognitionException -> L11
        if (r5 == 22) goto L14;
        if (r5 == 32) goto L13;
        if (r5 != 41) goto L8;
        char r10 = 1;
    L15:
        if (r10 == 1) goto L29;
        if (r10 == 2) goto L20;
        if (r10 != 3) goto L35;
        emit((CommonTree) match(this.input, 32, FOLLOW_NEWLINE_in_singleElement164), 41);     // Catch: Throwable -> L9 RecognitionException -> L11
        return;
    L35:
        return;
    L20:
        CommonTree r11 = (CommonTree) match(this.input, 22, FOLLOW_TEXT_in_singleElement154);     // Catch: Throwable -> L9 RecognitionException -> L11
        String r12 = null;
        if (r11 == null) goto L23;
        String r13 = r11.getText();     // Catch: Throwable -> L9 RecognitionException -> L11
    L25:
        if (r13.length() <= 0) goto L37;
        if (r11 == null) goto L28;
        r12 = r11.getText();     // Catch: Throwable -> L9 RecognitionException -> L11
    L28:
        emit1(r11, 47, r12);     // Catch: Throwable -> L9 RecognitionException -> L11
        return;
    L37:
        return;
    L23:
        r13 = null;
        goto L25
    L29:
        pushFollow(FOLLOW_exprElement_in_singleElement149);     // Catch: Throwable -> L9 RecognitionException -> L11
        exprElement();     // Catch: Throwable -> L9 RecognitionException -> L11
        this.state._fsp--;     // Catch: Throwable -> L9 RecognitionException -> L11
        return;
    L8:
        throw new NoViableAltException("", 3, 0, this.input);     // Catch: Throwable -> L9 RecognitionException -> L11
    L13:
        r10 = 3;
        goto L15
    L14:
        r10 = 2;
    L11:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final subtemplate_return subtemplate() throws RecognitionException {
        subtemplate_return r5 = new subtemplate_return();
        r5.start = this.input.LT(1);
        r5.name = Compiler.getNewSubtemplateName();
        ArrayList r10 = new ArrayList();
    L43:
        e = move-exception;
        reportError(e);
        recover(this.input, e);
    L72:
        return r5;
    L41:
        th = move-exception;
        throw th;
    L5:
        if (this.input.LA(1) != 55) goto L69;
        int r11 = this.input.LA(2);     // Catch: Throwable -> L41 RecognitionException -> L43
        if (r11 != 2) goto L9;
        char r12 = 1;
    L46:
        if (r12 == 1) goto L50;
        if (r12 != 2) goto L72;
        CommonTree r13 = (CommonTree) match(this.input, 55, FOLLOW_SUBTEMPLATE_in_subtemplate334);     // Catch: Throwable -> L41 RecognitionException -> L43
        CompiledST r14 = new CompiledST();     // Catch: Throwable -> L41 RecognitionException -> L43
        r14.name = r5.name;     // Catch: Throwable -> L41 RecognitionException -> L43
        r14.template = "";     // Catch: Throwable -> L41 RecognitionException -> L43
        r14.addArg(new FormalArgument("i"));     // Catch: Throwable -> L41 RecognitionException -> L43
        r14.addArg(new FormalArgument("i0"));     // Catch: Throwable -> L41 RecognitionException -> L43
        r14.isAnonSubtemplate = true;     // Catch: Throwable -> L41 RecognitionException -> L43
        r14.templateDefStartToken = r13.token;     // Catch: Throwable -> L41 RecognitionException -> L43
        r14.ast = r13;     // Catch: Throwable -> L41 RecognitionException -> L43
        r13.setUnknownTokenBoundaries();     // Catch: Throwable -> L41 RecognitionException -> L43
        r14.tokens = this.input.getTokenStream();     // Catch: Throwable -> L41 RecognitionException -> L43
        this.outermostImpl.addImplicitlyDefinedTemplate(r14);     // Catch: Throwable -> L41 RecognitionException -> L43
        goto L72
    L50:
        CommonTree r15 = (CommonTree) match(this.input, 55, FOLLOW_SUBTEMPLATE_in_subtemplate291);     // Catch: Throwable -> L41 RecognitionException -> L43
        if (this.input.LA(1) != 2) goto L72;
        match(this.input, 2, null);     // Catch: Throwable -> L41 RecognitionException -> L43
    L54:
        if (this.input.LA(1) != 38) goto L67;
        match(this.input, 38, FOLLOW_ARGS_in_subtemplate298);     // Catch: Throwable -> L41 RecognitionException -> L43
        match(this.input, 2, null);     // Catch: Throwable -> L41 RecognitionException -> L43
        int r16 = 0;
    L57:
        if (this.input.LA(1) != 25) goto L63;
        CommonTree r17 = (CommonTree) match(this.input, 25, FOLLOW_ID_in_subtemplate301);     // Catch: Throwable -> L41 RecognitionException -> L43
        if (r17 == null) goto L61;
        String r18 = r17.getText();     // Catch: Throwable -> L41 RecognitionException -> L43
    L62:
        r10.add(new FormalArgument(r18));     // Catch: Throwable -> L41 RecognitionException -> L43
        r16 = r16 + 1;     // Catch: Throwable -> L41 RecognitionException -> L43
        goto L57
    L61:
        r18 = null;
        goto L62
    L63:
        if (r16 < 1) goto L66;
        match(this.input, 3, null);     // Catch: Throwable -> L41 RecognitionException -> L43
        goto L54
    L66:
        throw new EarlyExitException(6, this.input);     // Catch: Throwable -> L41 RecognitionException -> L43
    L67:
        r5.nargs = r10.size();     // Catch: Throwable -> L41 RecognitionException -> L43
        pushFollow(FOLLOW_template_in_subtemplate318);     // Catch: Throwable -> L41 RecognitionException -> L43
        CompiledST r19 = template(r5.name, r10);     // Catch: Throwable -> L41 RecognitionException -> L43
        this.state._fsp--;     // Catch: Throwable -> L41 RecognitionException -> L43
        r19.isAnonSubtemplate = true;     // Catch: Throwable -> L41 RecognitionException -> L43
        r19.templateDefStartToken = r15.token;     // Catch: Throwable -> L41 RecognitionException -> L43
        r19.ast = r15;     // Catch: Throwable -> L41 RecognitionException -> L43
        r15.setUnknownTokenBoundaries();     // Catch: Throwable -> L41 RecognitionException -> L43
        r19.tokens = this.input.getTokenStream();     // Catch: Throwable -> L41 RecognitionException -> L43
        this.outermostImpl.addImplicitlyDefinedTemplate(r19);     // Catch: Throwable -> L41 RecognitionException -> L43
        match(this.input, 3, null);     // Catch: Throwable -> L41 RecognitionException -> L43
        goto L72
    L9:
        if (r11 < 3) goto L12;
        if (r11 > 6) goto L12;
    L45:
        r12 = 2;
    L12:
        if (r11 < 10) goto L16;
        if (r11 <= 12) goto L45;
    L16:
        if (r11 == 22) goto L45;
        if (r11 < 25) goto L21;
        if (r11 <= 26) goto L45;
    L21:
        if (r11 < 29) goto L25;
        if (r11 <= 30) goto L45;
    L25:
        if (r11 == 32) goto L45;
        if (r11 < 35) goto L31;
        if (r11 <= 36) goto L45;
    L31:
        if (r11 >= 40) goto L33;
    L35:
        int r20 = this.input.mark();     // Catch: Throwable -> L41 RecognitionException -> L43
        this.input.consume();     // Catch: Throwable -> L38
        throw new NoViableAltException("", 8, 1, this.input);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        this.input.rewind(r20);     // Catch: Throwable -> L41 RecognitionException -> L43
        throw th;     // Catch: Throwable -> L41 RecognitionException -> L43
    L33:
        if (r11 > 57) goto L35;
    L69:
        throw new NoViableAltException("", 8, 0, this.input);     // Catch: Throwable -> L41 RecognitionException -> L43
    }

    public final CompiledST template(String r5, List<FormalArgument> r10) throws RecognitionException {
        this.template_stack.push(new template_scope());
        this.template_stack.peek().state = new CompilationState(this.errMgr, r5, this.input.getTokenStream());
        CompiledST r11 = this.template_stack.peek().state.impl;
        if (this.template_stack.size() != 1) goto L5;
        this.outermostImpl = r11;
    L5:
        r11.defineFormalArgs(r10);
        if (r5 != null) goto L8;
    L10:
        r11.template = this.template;
        pushFollow(FOLLOW_chunk_in_template77);     // Catch: Throwable -> L14 RecognitionException -> L16
        chunk();     // Catch: Throwable -> L14 RecognitionException -> L16
        this.state._fsp--;     // Catch: Throwable -> L14 RecognitionException -> L16
        if (this.template_stack.peek().state.stringtable == null) goto L18;
        r11.strings = this.template_stack.peek().state.stringtable.toArray();     // Catch: Throwable -> L14 RecognitionException -> L16
    L18:
        r11.codeSize = this.template_stack.peek().state.f678ip;     // Catch: Throwable -> L14 RecognitionException -> L16
    L19:
        this.template_stack.pop();
        return r11;
    L16:
        e = move-exception;
        reportError(e);     // Catch: Throwable -> L14
        recover(this.input, e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.template_stack.pop();
        throw th;
    L8:
        if (r5.startsWith(Compiler.SUBTEMPLATE_PREFIX) == false) goto L10;
        r11.addArg(new FormalArgument("i"));
        r11.addArg(new FormalArgument("i0"));
        goto L10
    }

    public final void templateAndEOF() throws RecognitionException {
        pushFollow(FOLLOW_template_in_templateAndEOF50);     // Catch: Throwable -> L4 RecognitionException -> L6
        template(null, null);     // Catch: Throwable -> L4 RecognitionException -> L6
        this.state._fsp--;     // Catch: Throwable -> L4 RecognitionException -> L6
        match(this.input, -1, FOLLOW_EOF_in_templateAndEOF53);     // Catch: Throwable -> L4 RecognitionException -> L6
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

    public void write(int r5, short r10) {
        this.template_stack.peek().state.write(r5, r10);
    }

    public CodeGenerator(TreeNodeStream r5, RecognizerSharedState r10) {
        super(r5, r10);
        this.template_stack = new Stack();
    }

    public void emit1(CommonTree r5, short r10, String r11) {
        this.template_stack.peek().state.emit1(r5, r10, r11);
    }

    public void emit2(CommonTree r5, short r10, String r11, int r12) {
        this.template_stack.peek().state.emit2(r5, r10, r11, r12);
    }

    public CodeGenerator(TreeNodeStream r5, ErrorManager r10, String r11, String r12, Token r13) {
        this(r5, new RecognizerSharedState());
        this.errMgr = r10;
        this.outermostTemplateName = r11;
        this.template = r12;
        this.templateToken = r13;
    }
}
