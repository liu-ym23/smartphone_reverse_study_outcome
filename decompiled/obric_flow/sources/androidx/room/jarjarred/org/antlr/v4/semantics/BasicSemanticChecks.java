package androidx.room.jarjarred.org.antlr.v4.semantics;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.v4.misc.Utils;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorManager;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarRootAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleRefAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.MultiMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BasicSemanticChecks extends GrammarTreeVisitor {
    public static MultiMap<Integer, Integer> validImportTypes;
    public boolean checkAssocElementOption;
    public ErrorManager errMgr;
    public Grammar g;
    private boolean inFragmentRule;
    protected int nonFragmentRuleCount;
    public RuleCollector ruleCollector;

    static {
        validImportTypes = new AnonymousClass1();
    }

    public BasicSemanticChecks(Grammar r5, RuleCollector r10) {
        this.checkAssocElementOption = true;
        this.g = r5;
        this.ruleCollector = r10;
        this.errMgr = r5.tool.errMgr;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void actionInAlt(ActionAST r5) {
        if (this.inFragmentRule == false) goto L6;
        String r10 = r5.token.getInputStream().getSourceName();
        String r11 = this.currentRuleName;
        this.g.tool.errMgr.grammarError(ErrorType.FRAGMENT_ACTION_IGNORED, r10, r5.token, new Object[]{r11});
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void blockOption(GrammarAST r5, GrammarAST r10) {
        checkOptions((GrammarAST) r5.getAncestor(78), r5.token, r10);
    }

    public void checkChannelDefinition(Token r5) {
    }

    public void checkElementIsOuterMostInSingleAlt(GrammarAST r10) {
        CommonTree r5 = r10.parent.parent;
        if (r5.parent.getType() != 94) goto L5;
        boolean r11 = true;
    L6:
        Tree r12 = r10.getAncestor(94);
        String r13 = r10.getToken().getInputStream().getSourceName();
        if (r11 == true) goto L9;
    L10:
        this.g.tool.errMgr.grammarError(ErrorType.LEXER_COMMAND_PLACEMENT_ISSUE, r13, r10.getToken(), new Object[]{r12.getChild(0).getText()});
        return;
    L9:
        if (r5.getChildCount() > 1) goto L10;
        return;
    L5:
        r11 = false;
        goto L6
    }

    public boolean checkElementOptions(GrammarASTWithOptions r10, GrammarAST r11, GrammarAST r12) {
        if (this.checkAssocElementOption == false) goto L11;
        if (r11 == null) goto L11;
        if ("assoc".equals(r11.getText()) == false) goto L11;
        if (r10.getType() == 74) goto L11;
        Token r5 = r11.token;
        String r13 = r5.getInputStream().getSourceName();
        this.g.tool.errMgr.grammarError(ErrorType.UNRECOGNIZED_ASSOC_OPTION, r13, r5, new Object[]{this.currentRuleName});
    L11:
        if ((r10 instanceof RuleRefAST) == false) goto L15;
        return checkRuleRefOptions((RuleRefAST) r10, r11, r12);
    L15:
        if ((r10 instanceof TerminalAST) == false) goto L19;
        return checkTokenOptions((TerminalAST) r10, r11, r12);
    L19:
        if (r10.getType() != 4) goto L22;
        return false;
    L22:
        if (r10.getType() != 59) goto L28;
        Token r14 = r11.token;
        String r15 = r14.getInputStream().getSourceName();
        if (r12 == null) goto L28;
        if (Grammar.semPredOptions.contains(r14.getText()) == true) goto L28;
        this.g.tool.errMgr.grammarError(ErrorType.ILLEGAL_OPTION, r15, r14, new Object[]{r14.getText()});
    L28:
        return false;
    }

    public void checkGrammarName(Token r5) {
        String r10 = r5.getInputStream().getSourceName();
        if (r10 != null) goto L5;
        return;
    L5:
        String r11 = new File(r10).getName();
        if (this.g.originalGrammar == null) goto L9;
        return;
    L9:
        if (Utils.stripFileExtension(r11).equals(r5.getText()) == false) goto L11;
        return;
    L11:
        if (r11.equals(Grammar.GRAMMAR_FROM_STRING_NAME) == true) goto L15;
        this.g.tool.errMgr.grammarError(ErrorType.FILE_AND_GRAMMAR_NAME_DIFFER, r11, r5, new Object[]{r5.getText(), r11});
        return;
    }

    public void checkImport(Token r10) {
        Grammar r5 = this.g.getImportedGrammar(r10.getText());
        if (r5 != null) goto L5;
        return;
    L5:
        List r11 = (List) validImportTypes.get(Integer.valueOf(r5.getType()));
        if (r11 == null) goto L11;
        if (r11.contains(Integer.valueOf(this.g.getType())) == true) goto L11;
        Grammar r12 = this.g;
        r12.tool.errMgr.grammarError(ErrorType.INVALID_IMPORT, r12.fileName, r10, new Object[]{r12, r5});
    L11:
        if (this.g.isCombined() == true) goto L13;
        return;
    L13:
        if (r5.name.equals(this.g.name + Grammar.getGrammarTypeToFileNameSuffix(31)) == false) goto L15;
    L16:
        Grammar r13 = this.g;
        r13.tool.errMgr.grammarError(ErrorType.IMPORT_NAME_CLASH, r13.fileName, r10, new Object[]{r13, r5});
        return;
    L15:
        if (r5.name.equals(this.g.name + Grammar.getGrammarTypeToFileNameSuffix(44)) == true) goto L16;
    }

    public void checkInvalidRuleDef(Token r5) {
        if (r5.getInputStream() == null) goto L5;
        String r10 = r5.getInputStream().getSourceName();
    L7:
        if (this.g.isLexer() == false) goto L12;
        if (Character.isLowerCase(r5.getText().charAt(0)) == false) goto L12;
        this.g.tool.errMgr.grammarError(ErrorType.PARSER_RULES_NOT_ALLOWED, r10, r5, new Object[]{r5.getText()});
    L12:
        if (this.g.isParser() == true) goto L14;
        return;
    L14:
        if (Grammar.isTokenName(r5.getText()) == false) goto L18;
        this.g.tool.errMgr.grammarError(ErrorType.LEXER_RULES_NOT_ALLOWED, r10, r5, new Object[]{r5.getText()});
        return;
    L18:
        return;
    L5:
        r10 = null;
        goto L7
    }

    public void checkInvalidRuleRef(Token r5) {
        String r10 = r5.getInputStream().getSourceName();
        if (this.g.isLexer() == true) goto L5;
        return;
    L5:
        if (Character.isLowerCase(r5.getText().charAt(0)) == false) goto L9;
        this.g.tool.errMgr.grammarError(ErrorType.PARSER_RULE_REF_IN_LEXER_RULE, r10, r5, new Object[]{r5.getText(), this.currentRuleName});
        return;
    }

    public void checkNumPrequels(List<GrammarAST> r5, List<GrammarAST> r10, List<GrammarAST> r11) {
        ArrayList r12 = new ArrayList();
        if (r5 != null) goto L5;
    L7:
        if (r10 != null) goto L9;
    L11:
        if (r11 != null) goto L13;
    L15:
        Iterator r13 = r12.iterator();
    L17:
        if (r13.hasNext() == false) goto L19;
        Token r14 = (Token) r13.next();
        String r15 = r14.getInputStream().getSourceName();
        this.g.tool.errMgr.grammarError(ErrorType.REPEATED_PREQUEL, r15, r14, new Object[0]);
        goto L17
    L19:
        return;
    L13:
        if (r11.size() <= 1) goto L15;
        r12.add(r11.get(1).token);
        goto L15
    L9:
        if (r10.size() <= 1) goto L11;
        r12.add(r10.get(1).token);
        goto L11
    L5:
        if (r5.size() <= 1) goto L7;
        r12.add(r5.get(1).token);
        goto L7
    }

    public void checkNumRules(GrammarAST r5) {
        if (r5.getChildCount() != 0) goto L6;
        GrammarAST r10 = (GrammarAST) ((GrammarAST) r5.getParent()).getChild(0);
        Grammar r11 = this.g;
        r11.tool.errMgr.grammarError(ErrorType.NO_RULES, r11.fileName, null, new Object[]{r10.getText(), this.g});
        return;
    }

    public boolean checkOptions(GrammarAST r5, Token r10, GrammarAST r11) {
        boolean r12 = true;
        if (r5.getType() != 78) goto L16;
        if (this.g.isLexer() == false) goto L10;
        if (Grammar.LexerBlockOptions.contains(r10.getText()) == true) goto L10;
        Grammar r13 = this.g;
        r13.tool.errMgr.grammarError(ErrorType.ILLEGAL_OPTION, r13.fileName, r10, new Object[]{r10.getText()});
        r12 = false;
    L10:
        if (this.g.isLexer() == true) goto L27;
        if (Grammar.ParserBlockOptions.contains(r10.getText()) == true) goto L27;
        Grammar r14 = this.g;
        r14.tool.errMgr.grammarError(ErrorType.ILLEGAL_OPTION, r14.fileName, r10, new Object[]{r10.getText()});
        return false;
    L27:
        return r12;
    L16:
        if (r5.getType() != 94) goto L21;
        if (Grammar.ruleOptions.contains(r10.getText()) == true) goto L27;
        Grammar r15 = this.g;
        r15.tool.errMgr.grammarError(ErrorType.ILLEGAL_OPTION, r15.fileName, r10, new Object[]{r10.getText()});
        return false;
    L21:
        if (r5.getType() != 25) goto L27;
        if (legalGrammarOption(r10.getText()) == true) goto L27;
        Grammar r16 = this.g;
        r16.tool.errMgr.grammarError(ErrorType.ILLEGAL_OPTION, r16.fileName, r10, new Object[]{r10.getText()});
        return false;
    }

    public boolean checkRuleRefOptions(RuleRefAST r5, GrammarAST r10, GrammarAST r11) {
        Token r12 = r10.token;
        String r13 = r12.getInputStream().getSourceName();
        if (r11 != null) goto L5;
        return true;
    L5:
        if (Grammar.ruleRefOptions.contains(r12.getText()) == true) goto L10;
        this.g.tool.errMgr.grammarError(ErrorType.ILLEGAL_OPTION, r13, r12, new Object[]{r12.getText()});
        return false;
    L10:
        return true;
    }

    public void checkTokenDefinition(Token r5) {
        String r10 = r5.getInputStream().getSourceName();
        if (Grammar.isTokenName(r5.getText()) == true) goto L6;
        this.g.tool.errMgr.grammarError(ErrorType.TOKEN_NAMES_MUST_START_UPPER, r10, r5, new Object[]{r5.getText()});
        return;
    }

    public boolean checkTokenOptions(TerminalAST r5, GrammarAST r10, GrammarAST r11) {
        Token r12 = r10.token;
        String r13 = r12.getInputStream().getSourceName();
        if (r11 != null) goto L5;
        return true;
    L5:
        if (Grammar.tokenOptions.contains(r12.getText()) == true) goto L10;
        this.g.tool.errMgr.grammarError(ErrorType.ILLEGAL_OPTION, r13, r12, new Object[]{r12.getText()});
        return false;
    L10:
        return true;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void defineChannel(GrammarAST r5) {
        checkChannelDefinition(r5.token);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void defineToken(GrammarAST r5) {
        checkTokenDefinition(r5.token);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void discoverGrammar(GrammarRootAST r5, GrammarAST r10) {
        checkGrammarName(r10.token);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void discoverLexerRule(RuleAST r5, GrammarAST r10, List<GrammarAST> r11, GrammarAST r12) {
        checkInvalidRuleDef(r10.token);
        if (r11 == null) goto L11;
        Iterator<GrammarAST> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        if (r13.next().getType() != 24) goto L6;
        this.inFragmentRule = true;
    L11:
        if (this.inFragmentRule == true) goto L19;
        this.nonFragmentRuleCount++;
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void discoverRule(RuleAST r5, GrammarAST r10, List<GrammarAST> r11, ActionAST r12, ActionAST r13, GrammarAST r14, GrammarAST r15, ActionAST r16, List<GrammarAST> r17, GrammarAST r18) {
        checkInvalidRuleDef(r10.token);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void discoverRules(GrammarAST r5) {
        checkNumRules(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void elementOption(GrammarASTWithOptions r5, GrammarAST r10, GrammarAST r11) {
        checkElementOptions(r5, r10, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void enterChannelsSpec(GrammarAST r5) {
        if (this.g.isParser() == false) goto L6;
        Grammar r10 = this.g;
        r10.tool.errMgr.grammarError(ErrorType.CHANNELS_BLOCK_IN_PARSER_GRAMMAR, r10.fileName, r5.token, new Object[0]);
        return;
    L6:
        if (this.g.isCombined() == false) goto L10;
        Grammar r11 = this.g;
        r11.tool.errMgr.grammarError(ErrorType.CHANNELS_BLOCK_IN_COMBINED_GRAMMAR, r11.fileName, r5.token, new Object[0]);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void enterLabeledLexerElement(GrammarAST r5) {
        Token r10 = ((GrammarAST) r5.getChild(0)).getToken();
        Grammar r11 = this.g;
        r11.tool.errMgr.grammarError(ErrorType.V3_LEXER_LABEL, r11.fileName, r10, new Object[]{r10.getText()});
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void enterLexerCommand(GrammarAST r5) {
        checkElementIsOuterMostInSingleAlt(r5);
        if (this.inFragmentRule == false) goto L6;
        String r10 = r5.token.getInputStream().getSourceName();
        String r11 = this.currentRuleName;
        this.g.tool.errMgr.grammarError(ErrorType.FRAGMENT_ACTION_IGNORED, r10, r5.token, new Object[]{r11});
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void enterLexerElement(GrammarAST r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void enterMode(GrammarAST r5) {
        this.nonFragmentRuleCount = 0;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void enterTerminal(GrammarAST r5) {
        if (r5.getText().equals("''") == false) goto L6;
        Grammar r10 = this.g;
        r10.tool.errMgr.grammarError(ErrorType.EMPTY_STRINGS_AND_SETS_NOT_ALLOWED, r10.fileName, r5.token, new Object[]{"''"});
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void exitLexerRule(GrammarAST r5) {
        this.inFragmentRule = false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void exitMode(GrammarAST r5) {
        if (this.nonFragmentRuleCount != 0) goto L15;
        Token r10 = r5.getToken();
        String r11 = "?";
        if (r5.getChildCount() <= 0) goto L13;
        String r12 = r5.getChild(0).getText();
        if (r12 != null) goto L9;
    L12:
        r10 = ((GrammarAST) r5.getChild(0)).getToken();
        goto L13
    L9:
        if (r12.isEmpty() == true) goto L12;
        r11 = r12;
    L13:
        Grammar r13 = this.g;
        r13.tool.errMgr.grammarError(ErrorType.MODE_WITHOUT_RULES, r13.fileName, r10, new Object[]{r11, r13});
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void finishPrequels(GrammarAST r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        GrammarAST r10 = (GrammarAST) r5.parent;
        checkNumPrequels(r10.getAllChildrenWithType(42), r10.getAllChildrenWithType(29), r10.getAllChildrenWithType(65));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void finishRule(RuleAST r11, GrammarAST r12, GrammarAST r13) {
        if (r11.isLexerRule() == false) goto L5;
        return;
    L5:
        BlockAST r14 = (BlockAST) r11.getFirstChildWithType(78);
        int r15 = r14.getChildCount();
        int r5 = 0;
        GrammarAST r10 = (GrammarAST) r11.getChild(0);
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L18;
        AltAST r17 = (AltAST) r14.getChild(r16);
        GrammarAST r18 = r17.altLabel;
        if (r18 == null) goto L17;
        String r19 = r18.getText();
        Rule r20 = this.ruleCollector.rules.get(Utils.decapitalize(r19));
        if (r20 == null) goto L12;
        Grammar r21 = this.g;
        r21.tool.errMgr.grammarError(ErrorType.ALT_LABEL_CONFLICTS_WITH_RULE, r21.fileName, r17.altLabel.token, new Object[]{r19, r20.name});
    L12:
        String r22 = this.ruleCollector.altLabelToRuleName.get(r19);
        if (r22 == null) goto L17;
        if (r22.equals(r11.getRuleName()) == true) goto L17;
        Grammar r23 = this.g;
        r23.tool.errMgr.grammarError(ErrorType.ALT_LABEL_REDEF, r23.fileName, r17.altLabel.token, new Object[]{r19, r11.getRuleName(), r22});
    L17:
        r16 = r16 + 1;
        goto L6
    L18:
        List r110 = (List) this.ruleCollector.ruleToAltLabels.get(r11.getRuleName());
        if (r110 == null) goto L21;
        r5 = r110.size();
    L21:
        if (r5 <= 0) goto L30;
        if (r15 == r5) goto L31;
        Grammar r111 = this.g;
        r111.tool.errMgr.grammarError(ErrorType.RULE_WITH_TOO_FEW_ALT_LABELS, r111.fileName, r10.token, new Object[]{r11.getRuleName()});
        return;
    L31:
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public ErrorManager getErrorManager() {
        return this.errMgr;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void grammarOption(GrammarAST r5, GrammarAST r10) {
        checkOptions(this.g.ast, r5.token, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void importGrammar(GrammarAST r5, GrammarAST r10) {
        checkImport(r10.token);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void label(GrammarAST r5, GrammarAST r10, GrammarAST r11) {
        int r12 = r11.getType();
        if (r12 != 39) goto L5;
        return;
    L5:
        if (r12 != 52) goto L7;
        return;
    L7:
        if (r12 != 57) goto L9;
        return;
    L9:
        if (r12 != 62) goto L11;
        return;
    L11:
        if (r12 != 66) goto L13;
        return;
    L13:
        if (r12 != 98) goto L15;
        return;
    L15:
        if (r12 == 100) goto L24;
        String r13 = r10.token.getInputStream().getSourceName();
        this.g.tool.errMgr.grammarError(ErrorType.LABEL_BLOCK_NOT_A_SET, r13, r10.token, new Object[]{r10.getText()});
        return;
    }

    public boolean legalGrammarOption(String r5) {
        int r10 = this.g.getType();
        if (r10 == 31) goto L11;
        if (r10 == 44) goto L9;
        return Grammar.parserOptions.contains(r5);
    L9:
        return Grammar.parserOptions.contains(r5);
    L11:
        return Grammar.lexerOptions.contains(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void modeDef(GrammarAST r5, GrammarAST r10) {
        if (this.g.isLexer() == true) goto L6;
        Grammar r11 = this.g;
        ErrorManager r12 = r11.tool.errMgr;
        ErrorType r13 = ErrorType.MODE_NOT_IN_LEXER;
        String r14 = r11.fileName;
        Token r15 = r10.token;
        r12.grammarError(r13, r14, r15, new Object[]{r15.getText(), this.g});
        return;
    }

    public void process() {
        visitGrammar(this.g.ast);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void ruleOption(GrammarAST r5, GrammarAST r10) {
        checkOptions((GrammarAST) r5.getAncestor(94), r5.token, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void ruleRef(GrammarAST r5, ActionAST r10) {
        checkInvalidRuleRef(r5.token);
    }
}
