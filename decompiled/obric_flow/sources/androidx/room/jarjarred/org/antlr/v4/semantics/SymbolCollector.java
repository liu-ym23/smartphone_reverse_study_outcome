package androidx.room.jarjarred.org.antlr.v4.semantics;

import androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorManager;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LabelElementPair;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.PredAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SymbolCollector extends GrammarTreeVisitor {
    public List<GrammarAST> channelDefs;
    public Rule currentRule;
    public ErrorManager errMgr;
    public Grammar g;
    List<GrammarAST> namedActions;
    public List<GrammarAST> qualifiedRulerefs;
    public List<GrammarAST> rulerefs;
    public Set<String> strings;
    public List<GrammarAST> terminals;
    public List<GrammarAST> tokenIDRefs;
    public List<GrammarAST> tokensDefs;

    public SymbolCollector(Grammar r5) {
        this.rulerefs = new ArrayList();
        this.qualifiedRulerefs = new ArrayList();
        this.terminals = new ArrayList();
        this.tokenIDRefs = new ArrayList();
        this.strings = new HashSet();
        this.tokensDefs = new ArrayList();
        this.channelDefs = new ArrayList();
        this.namedActions = new ArrayList();
        this.g = r5;
        this.errMgr = r5.tool.errMgr;
    }

    private void setActionResolver(GrammarAST r5) {
        if ((r5 instanceof ActionAST) == false) goto L6;
        Alternative r10 = this.currentRule.alt[this.currentOuterAltNumber];
        ((ActionAST) r5).resolver = r10;
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void actionInAlt(ActionAST r5) {
        this.currentRule.defineActionInAlt(this.currentOuterAltNumber, r5);
        r5.resolver = this.currentRule.alt[this.currentOuterAltNumber];
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void blockOption(GrammarAST r5, GrammarAST r10) {
        setActionResolver(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void defineChannel(GrammarAST r5) {
        this.channelDefs.add(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void defineToken(GrammarAST r5) {
        this.terminals.add(r5);
        this.tokenIDRefs.add(r5);
        this.tokensDefs.add(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void discoverLexerRule(RuleAST r5, GrammarAST r10, List<GrammarAST> r11, GrammarAST r12) {
        this.currentRule = this.g.getRule(r10.getText());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void discoverOuterAlt(AltAST r5) {
        this.currentRule.alt[this.currentOuterAltNumber].ast = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void discoverRule(RuleAST r5, GrammarAST r10, List<GrammarAST> r11, ActionAST r12, ActionAST r13, GrammarAST r14, GrammarAST r15, ActionAST r16, List<GrammarAST> r17, GrammarAST r18) {
        this.currentRule = this.g.getRule(r10.getText());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void elementOption(GrammarASTWithOptions r5, GrammarAST r10, GrammarAST r11) {
        setActionResolver(r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void finallyAction(ActionAST r5) {
        Rule r10 = this.currentRule;
        r10.finallyAction = r5;
        r5.resolver = r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public ErrorManager getErrorManager() {
        return this.errMgr;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void globalNamedAction(GrammarAST r5, GrammarAST r10, ActionAST r11) {
        this.namedActions.add((GrammarAST) r10.getParent());
        r11.resolver = this.g;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void grammarOption(GrammarAST r5, GrammarAST r10) {
        setActionResolver(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void label(GrammarAST r5, GrammarAST r10, GrammarAST r11) {
        LabelElementPair r12 = new LabelElementPair(this.g, r10, r11, r5.getType());
        this.currentRule.alt[this.currentOuterAltNumber].labelDefs.map(r10.getText(), r12);
    }

    public void process(GrammarAST r5) {
        visitGrammar(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void ruleCatch(GrammarAST r5, ActionAST r10) {
        GrammarAST r11 = (GrammarAST) r10.getParent();
        this.currentRule.exceptions.add(r11);
        r10.resolver = this.currentRule;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void ruleOption(GrammarAST r5, GrammarAST r10) {
        setActionResolver(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void ruleRef(GrammarAST r5, ActionAST r10) {
        this.rulerefs.add(r5);
        Rule r11 = this.currentRule;
        if (r11 == null) goto L6;
        r11.alt[this.currentOuterAltNumber].ruleRefs.map(r5.getText(), r5);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void sempredInAlt(PredAST r5) {
        this.currentRule.definePredicateInAlt(this.currentOuterAltNumber, r5);
        r5.resolver = this.currentRule.alt[this.currentOuterAltNumber];
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void stringRef(TerminalAST r5) {
        this.terminals.add(r5);
        this.strings.add(r5.getText());
        Rule r10 = this.currentRule;
        if (r10 == null) goto L6;
        r10.alt[this.currentOuterAltNumber].tokenRefs.map(r5.getText(), r5);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void tokenRef(TerminalAST r5) {
        this.terminals.add(r5);
        this.tokenIDRefs.add(r5);
        Rule r10 = this.currentRule;
        if (r10 == null) goto L6;
        r10.alt[this.currentOuterAltNumber].tokenRefs.map(r5.getText(), r5);
        return;
    }
}
