package androidx.room.jarjarred.org.antlr.v4.semantics;

import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleAltInfo;
import androidx.room.jarjarred.org.antlr.v4.automata.LexerATNFactory;
import androidx.room.jarjarred.org.antlr.v4.misc.OrderedHashMap;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;
import androidx.room.jarjarred.org.antlr.v4.tool.Attribute;
import androidx.room.jarjarred.org.antlr.v4.tool.AttributeDict;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorManager;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LabelElementPair;
import androidx.room.jarjarred.org.antlr.v4.tool.LabelType;
import androidx.room.jarjarred.org.antlr.v4.tool.LeftRecursiveRule;
import androidx.room.jarjarred.org.antlr.v4.tool.LexerGrammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SymbolChecks {
    Map<String, Set<String>> actionScopeToActionNames;
    SymbolCollector collector;
    public ErrorManager errMgr;
    Grammar g;
    Map<String, Rule> nameToRuleMap;
    protected final Set<String> reservedNames;
    Set<String> tokenIDs;

    public SymbolChecks(Grammar r5, SymbolCollector r10) {
        this.nameToRuleMap = new HashMap();
        this.tokenIDs = new HashSet();
        this.actionScopeToActionNames = new HashMap();
        HashSet r11 = new HashSet();
        this.reservedNames = r11;
        r11.addAll(LexerATNFactory.getCommonConstants());
        this.g = r5;
        this.collector = r10;
        this.errMgr = r5.tool.errMgr;
        Iterator<GrammarAST> r12 = r10.tokenIDRefs.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        GrammarAST r13 = r12.next();
        this.tokenIDs.add(r13.getText());
        goto L4
    }

    private void checkForOverlap(Grammar r17, Rule r18, Rule r19, List<String> r20, List<String> r21) {
        int r5 = 0;
        int r10 = 0;
    L4:
        if (r10 >= r20.size()) goto L17;
        if (r18 != r19) goto L7;
        int r11 = r10 + 1;
    L8:
        String r12 = r20.get(r10);
    L10:
        if (r11 >= r21.size()) goto L16;
        String r13 = r21.get(r11);
        if (r12.equals(r13) == false) goto L15;
        this.errMgr.grammarError(ErrorType.TOKEN_UNREACHABLE, r17.fileName, ((GrammarAST) r19.ast.getChild(r5)).token, new Object[]{r19.name, r13, r18.name});
    L15:
        r11 = r11 + 1;
        r5 = 0;
        goto L10
    L16:
        r10 = r10 + 1;
        r5 = 0;
        goto L4
    L7:
        r11 = r5;
        goto L8
    }

    private void checkForTypeMismatch(Rule r10, LabelElementPair r11, LabelElementPair r12) {
        if (r11.type == r12.type) goto L10;
        if ((r10 instanceof LeftRecursiveRule) == false) goto L7;
        Token r5 = ((GrammarAST) r10.ast.getChild(0)).getToken();
    L8:
        this.errMgr.grammarError(ErrorType.LABEL_TYPE_CONFLICT, this.g.fileName, r5, new Object[]{r12.label.getText(), r12.type + "!=" + r11.type});
        goto L10
    L7:
        r5 = r12.label.token;
    L10:
        if (r11.element.getText().equals(r12.element.getText()) == true) goto L32;
        LabelType r13 = r11.type;
        LabelType r14 = LabelType.RULE_LABEL;
        if (r13.equals(r14) == true) goto L16;
        if (r11.type.equals(LabelType.RULE_LIST_LABEL) == true) goto L16;
        return;
    L16:
        if (r12.type.equals(r14) == true) goto L20;
        if (r12.type.equals(LabelType.RULE_LIST_LABEL) == true) goto L20;
        return;
    L20:
        if ((r10 instanceof LeftRecursiveRule) == false) goto L22;
        Token r15 = ((GrammarAST) r10.ast.getChild(0)).getToken();
    L23:
        LabelType r16 = r11.type;
        LabelType r17 = LabelType.RULE_LIST_LABEL;
        String r18 = "=";
        if (r16.equals(r17) == false) goto L26;
        String r19 = "+=";
    L28:
        if (r12.type.equals(r17) == false) goto L30;
        r18 = "+=";
    L30:
        this.errMgr.grammarError(ErrorType.LABEL_TYPE_CONFLICT, this.g.fileName, r15, new Object[]{r12.label.getText() + r18 + r12.element.getText(), r11.label.getText() + r19 + r11.element.getText()});
        return;
    L26:
        r19 = "=";
        goto L28
    L22:
        r15 = r12.label.token;
        goto L23
    }

    private void checkLabelPairs(Rule r5, Map<String, LabelElementPair> r10, List<LabelElementPair> r11) {
        Iterator<LabelElementPair> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        LabelElementPair r13 = r12.next();
        checkForLabelConflict(r5, r13.label);
        String r14 = r13.label.getText();
        LabelElementPair r15 = r10.get(r14);
        if (r15 == null) goto L7;
        checkForTypeMismatch(r5, r15, r13);
        goto L4
    L7:
        r10.put(r14, r13);
        goto L4
    }

    private String findAltLabelName(CommonTree r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if ((r5 instanceof AltAST) == false) goto L18;
        AltAST r10 = (AltAST) r5;
        GrammarAST r11 = r10.altLabel;
        if (r11 != null) goto L10;
        LeftRecursiveRuleAltInfo r12 = r10.leftRecursiveAltInfo;
        if (r12 == null) goto L16;
        return r12.altLabel.toString();
    L16:
        return findAltLabelName(r5.parent);
    L10:
        return r11.toString();
    L18:
        return findAltLabelName(r5.parent);
    }

    private List<String> getSingleTokenValues(Rule r11) {
        ArrayList r10 = new ArrayList();
        Alternative[] r12 = r11.alt;
        int r5 = r12.length;
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L29;
        Alternative r14 = r12[r13];
        if (r14 == null) goto L28;
        if (r14.ast.getChildCount() == 2) goto L9;
    L13:
        Tree r15 = r14.ast;
    L15:
        if (r15.getTokenStartIndex() == (-1)) goto L28;
        StringBuilder r16 = new StringBuilder();
        int r17 = 0;
    L19:
        if (r17 >= r15.getChildCount()) goto L27;
        Tree r18 = r15.getChild(r17);
        if ((r18 instanceof TerminalAST) == false) goto L28;
        TerminalAST r19 = (TerminalAST) r18;
        if (r19.token.getType() != 62) goto L28;
        String r20 = r19.token.getText();
        r16.append(r20.substring(1, r20.length() - 1));
        r17 = r17 + 1;
        goto L19
    L27:
        r10.add(r16.toString());
        goto L28
    L9:
        if ((r14.ast.getChild(0) instanceof AltAST) == false) goto L13;
        if ((r14.ast.getChild(1) instanceof GrammarAST) == false) goto L13;
        r15 = r14.ast.getChild(0);
    L28:
        r13 = r13 + 1;
        goto L3
    L29:
        return r10;
    }

    public void checkActionRedefinitions(List<GrammarAST> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r5 = this.g.getDefaultActionScope();
        Iterator<GrammarAST> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L18;
        GrammarAST r12 = r11.next();
        GrammarAST r13 = (GrammarAST) r12.getChild(0);
        if (r12.getChildCount() != 2) goto L10;
        String r14 = r13.getText();
    L11:
        Set<String> r15 = this.actionScopeToActionNames.get(r5);
        if (r15 != null) goto L15;
        r15 = new HashSet();
        this.actionScopeToActionNames.put(r5, r15);
    L15:
        if (r15.contains(r14) == false) goto L16;
        this.errMgr.grammarError(ErrorType.ACTION_REDEFINITION, this.g.fileName, r13.token, new Object[]{r14});
        goto L6
    L16:
        r15.add(r14);
        goto L6
    L10:
        r5 = r13.getText();
        r14 = r12.getChild(1).getText();
        goto L11
    }

    public void checkDeclarationRuleConflicts(Rule r10, AttributeDict r11, Set<String> r12, ErrorType r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        Iterator<Attribute> r14 = r11.attributes.values().iterator();
    L6:
        if (r14.hasNext() == false) goto L14;
        Attribute r5 = r14.next();
        if (r12.contains(r5.name) == false) goto L6;
        ErrorManager r15 = this.errMgr;
        String r16 = this.g.fileName;
        Token r17 = r5.token;
        if (r17 != null) goto L13;
        r17 = ((GrammarAST) r10.ast.getChild(0)).token;
    L13:
        r15.grammarError(r13, r16, r17, new Object[]{r5.name, r10.name});
        goto L6
    }

    public void checkForAttributeConflicts(Rule r5) {
        checkDeclarationRuleConflicts(r5, r5.args, this.nameToRuleMap.keySet(), ErrorType.ARG_CONFLICTS_WITH_RULE);
        checkDeclarationRuleConflicts(r5, r5.args, this.tokenIDs, ErrorType.ARG_CONFLICTS_WITH_TOKEN);
        checkDeclarationRuleConflicts(r5, r5.retvals, this.nameToRuleMap.keySet(), ErrorType.RETVAL_CONFLICTS_WITH_RULE);
        checkDeclarationRuleConflicts(r5, r5.retvals, this.tokenIDs, ErrorType.RETVAL_CONFLICTS_WITH_TOKEN);
        checkDeclarationRuleConflicts(r5, r5.locals, this.nameToRuleMap.keySet(), ErrorType.LOCAL_CONFLICTS_WITH_RULE);
        checkDeclarationRuleConflicts(r5, r5.locals, this.tokenIDs, ErrorType.LOCAL_CONFLICTS_WITH_TOKEN);
        checkLocalConflictingDeclarations(r5, r5.retvals, r5.args, ErrorType.RETVAL_CONFLICTS_WITH_ARG);
        checkLocalConflictingDeclarations(r5, r5.locals, r5.args, ErrorType.LOCAL_CONFLICTS_WITH_ARG);
        checkLocalConflictingDeclarations(r5, r5.locals, r5.retvals, ErrorType.LOCAL_CONFLICTS_WITH_RETVAL);
    }

    public void checkForLabelConflict(Rule r10, GrammarAST r11) {
        String r5 = r11.getText();
        if (this.nameToRuleMap.containsKey(r5) == false) goto L6;
        ErrorType r12 = ErrorType.LABEL_CONFLICTS_WITH_RULE;
        this.errMgr.grammarError(r12, this.g.fileName, r11.token, new Object[]{r5, r10.name});
    L6:
        if (this.tokenIDs.contains(r5) == false) goto L8;
        ErrorType r13 = ErrorType.LABEL_CONFLICTS_WITH_TOKEN;
        this.errMgr.grammarError(r13, this.g.fileName, r11.token, new Object[]{r5, r10.name});
    L8:
        AttributeDict r14 = r10.args;
        if (r14 != null) goto L11;
    L13:
        AttributeDict r15 = r10.retvals;
        if (r15 != null) goto L16;
    L18:
        AttributeDict r16 = r10.locals;
        if (r16 != null) goto L21;
        return;
    L21:
        if (r16.get(r5) == null) goto L25;
        ErrorType r17 = ErrorType.LABEL_CONFLICTS_WITH_LOCAL;
        this.errMgr.grammarError(r17, this.g.fileName, r11.token, new Object[]{r5, r10.name});
        return;
    L25:
        return;
    L16:
        if (r15.get(r5) == null) goto L18;
        ErrorType r18 = ErrorType.LABEL_CONFLICTS_WITH_RETVAL;
        this.errMgr.grammarError(r18, this.g.fileName, r11.token, new Object[]{r5, r10.name});
        goto L18
    L11:
        if (r14.get(r5) == null) goto L13;
        ErrorType r19 = ErrorType.LABEL_CONFLICTS_WITH_ARG;
        this.errMgr.grammarError(r19, this.g.fileName, r11.token, new Object[]{r5, r10.name});
        goto L13
    }

    public void checkForLabelConflicts(Collection<Rule> r10) {
        Iterator<Rule> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L29;
        Rule r5 = r11.next();
        checkForAttributeConflicts(r5);
        HashMap r12 = new HashMap();
        int r13 = 1;
    L7:
        if (r13 > r5.numberOfAlts) goto L4;
        Iterator<LabelElementPair> r14 = r5.alt[r13].labelDefs.values().iterator();
    L10:
        if (r14.hasNext() == false) goto L28;
        List<LabelElementPair> r15 = (List) r14.next();
        if (r5.hasAltSpecificContexts() == true) goto L13;
        checkLabelPairs(r5, r12, r15);
        goto L10
    L13:
        HashMap r16 = new HashMap();
        Iterator<LabelElementPair> r17 = r15.iterator();
    L15:
        if (r17.hasNext() == false) goto L23;
        LabelElementPair r18 = r17.next();
        String r19 = findAltLabelName(r18.label);
        if (r19 == null) goto L15;
        if (r16.containsKey(r19) == false) goto L21;
        List r20 = (List) r16.get(r19);
    L22:
        r20.add(r18);
        goto L15
    L21:
        ArrayList r21 = new ArrayList();
        r16.put(r19, r21);
        r20 = r21;
        goto L22
    L23:
        Iterator r22 = r16.values().iterator();
    L25:
        if (r22.hasNext() == false) goto L10;
        List<LabelElementPair> r23 = (List) r22.next();
        r12.clear();
        checkLabelPairs(r5, r12, r23);
        goto L25
    L28:
        r13 = r13 + 1;
        goto L7
    }

    public void checkForModeConflicts(Grammar r10) {
        if (r10.isLexer() == false) goto L15;
        LexerGrammar r5 = (LexerGrammar) r10;
        Iterator<String> r11 = r5.modes.keySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L21;
        String r12 = r11.next();
        if (r12.equals(LexerGrammar.DEFAULT_MODE_NAME) == true) goto L13;
        if (this.reservedNames.contains(r12) == false) goto L13;
        Rule r13 = (Rule) ((List) r5.modes.get(r12)).iterator().next();
        r10.tool.errMgr.grammarError(ErrorType.MODE_CONFLICTS_WITH_COMMON_CONSTANTS, r10.fileName, r13.ast.parent.getToken(), new Object[]{r12});
    L13:
        if (r10.getTokenType(r12) == 0) goto L6;
        Rule r14 = (Rule) ((List) r5.modes.get(r12)).iterator().next();
        r10.tool.errMgr.grammarError(ErrorType.MODE_CONFLICTS_WITH_TOKEN, r10.fileName, r14.ast.parent.getToken(), new Object[]{r12});
        goto L6
    L21:
        return;
    }

    public void checkForQualifiedRuleIssues(Grammar r10, List<GrammarAST> r11) {
        Iterator<GrammarAST> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        GrammarAST r5 = r12.next();
        GrammarAST r13 = (GrammarAST) r5.getChild(0);
        GrammarAST r14 = (GrammarAST) r5.getChild(1);
        r10.tool.log("semantics", r13.getText() + "." + r14.getText());
        if (r10.getImportedGrammar(r13.getText()) == null) goto L7;
        if (r10.getRule(r13.getText(), r14.getText()) != null) goto L4;
        this.errMgr.grammarError(ErrorType.NO_SUCH_RULE_IN_SCOPE, r10.fileName, r14.token, new Object[]{r13.getText(), r14.getText()});
        goto L4
    L7:
        this.errMgr.grammarError(ErrorType.NO_SUCH_GRAMMAR_SCOPE, r10.fileName, r13.token, new Object[]{r13.getText(), r14.getText()});
        goto L4
    }

    public void checkForUnreachableTokens(Grammar r14) {
        if (r14.isLexer() == false) goto L28;
        Iterator<Rule> r5 = ((LexerGrammar) r14).modes.values().iterator();
    L6:
        if (r5.hasNext() == false) goto L39;
        List r10 = (List) r5.next();
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        int r15 = 0;
    L9:
        if (r15 >= r10.size()) goto L17;
        Rule r16 = (Rule) r10.get(r15);
        List<String> r17 = getSingleTokenValues(r16);
        if (r17 == null) goto L15;
        if (r17.size() <= 0) goto L15;
        r11.add(r16);
        r12.add(r17);
    L15:
        r15 = r15 + 1;
    L17:
        if (r13 >= r11.size()) goto L6;
        List<String> r18 = (List) r12.get(r13);
        Rule r19 = (Rule) r11.get(r13);
        checkForOverlap(r14, r19, r19, r18, (List) r12.get(r13));
        if (r19.isFragment() == true) goto L27;
        int r110 = r13 + 1;
    L22:
        if (r110 >= r11.size()) goto L27;
        if (((Rule) r11.get(r110)).isFragment() == true) goto L26;
        checkForOverlap(r14, r19, (Rule) r11.get(r110), r18, (List) r12.get(r110));
    L26:
        r110 = r110 + 1;
    L27:
        r13 = r13 + 1;
        goto L17
    L39:
        return;
    }

    public void checkLocalConflictingDeclarations(Rule r10, AttributeDict r11, AttributeDict r12, ErrorType r13) {
        if (r11 == null) goto L13;
        if (r12 == null) goto L17;
        Iterator<String> r14 = r11.intersection(r12).iterator();
    L7:
        if (r14.hasNext() == false) goto L18;
        String r5 = r14.next();
        ErrorManager r15 = this.errMgr;
        String r16 = this.g.fileName;
        if (r11.get(r5).token == null) goto L11;
        Token r17 = r11.get(r5).token;
    L12:
        r15.grammarError(r13, r16, r17, new Object[]{r5, r10.name});
        goto L7
    L11:
        r17 = ((GrammarAST) r10.ast.getChild(0)).token;
        goto L12
    L18:
        return;
    L17:
        return;
    }

    public void checkReservedNames(Collection<Rule> r10) {
        Iterator<Rule> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Rule r5 = r11.next();
        if (this.reservedNames.contains(r5.name) == false) goto L4;
        this.errMgr.grammarError(ErrorType.RESERVED_RULE_NAME, this.g.fileName, ((GrammarAST) r5.ast.getChild(0)).getToken(), new Object[]{r5.name});
        goto L4
    }

    public void checkRuleArgs(Grammar r10, List<GrammarAST> r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        Iterator<GrammarAST> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L18;
        GrammarAST r5 = r12.next();
        String r13 = r5.getText();
        Rule r14 = r10.getRule(r13);
        GrammarAST r15 = (GrammarAST) r5.getFirstChildWithType(8);
        if (r15 == null) goto L13;
        if (r14 == null) goto L12;
        if (r14.args != null) goto L13;
    L12:
        this.errMgr.grammarError(ErrorType.RULE_HAS_NO_ARGS, r10.fileName, r5.token, new Object[]{r13});
    L13:
        if (r15 != null) goto L6;
        if (r14 == null) goto L6;
        if (r14.args == null) goto L6;
        this.errMgr.grammarError(ErrorType.MISSING_RULE_ARGS, r10.fileName, r5.token, new Object[]{r13});
        goto L6
    }

    public void process() {
        OrderedHashMap<String, Rule> r5 = this.g.rules;
        if (r5 == null) goto L8;
        Iterator<Rule> r10 = r5.values().iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        Rule r11 = r10.next();
        this.nameToRuleMap.put(r11.name, r11);
    L8:
        checkReservedNames(this.g.rules.values());
        checkActionRedefinitions(this.collector.namedActions);
        checkForLabelConflicts(this.g.rules.values());
    }
}
