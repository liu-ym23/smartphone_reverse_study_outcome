package androidx.room.jarjarred.org.antlr.v4.semantics;

import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleAnalyzer;
import androidx.room.jarjarred.org.antlr.v4.misc.OrderedHashMap;
import androidx.room.jarjarred.org.antlr.v4.misc.Utils;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor;
import androidx.room.jarjarred.org.antlr.v4.parse.ScopeParser;
import androidx.room.jarjarred.org.antlr.v4.tool.AttributeDict;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorManager;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LeftRecursiveRule;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.MultiMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RuleCollector extends GrammarTreeVisitor {
    public Map<String, String> altLabelToRuleName;
    public ErrorManager errMgr;
    public Grammar g;
    public MultiMap<String, GrammarAST> ruleToAltLabels;
    public OrderedHashMap<String, Rule> rules;

    public RuleCollector(Grammar r5) {
        this.rules = new OrderedHashMap();
        this.ruleToAltLabels = new MultiMap();
        this.altLabelToRuleName = new HashMap();
        this.g = r5;
        this.errMgr = r5.tool.errMgr;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void discoverLexerRule(RuleAST r5, GrammarAST r10, List<GrammarAST> r11, GrammarAST r12) {
        int r13 = r12.getChildCount();
        Rule r14 = new Rule(this.g, r10.getText(), r5, r13);
        r14.mode = this.currentModeName;
        if (r11.isEmpty() == true) goto L5;
        r14.modifiers = r11;
    L5:
        this.rules.put(r14.name, r14);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void discoverOuterAlt(AltAST r5) {
        GrammarAST r10 = r5.altLabel;
        if (r10 == null) goto L6;
        this.ruleToAltLabels.map(this.currentRuleName, r10);
        String r11 = r5.altLabel.getText();
        this.altLabelToRuleName.put(Utils.capitalize(r11), this.currentRuleName);
        this.altLabelToRuleName.put(Utils.decapitalize(r11), this.currentRuleName);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public void discoverRule(RuleAST r5, GrammarAST r10, List<GrammarAST> r11, ActionAST r12, ActionAST r13, GrammarAST r14, GrammarAST r15, ActionAST r16, List<GrammarAST> r17, GrammarAST r18) {
        int r19 = r18.getChildCount();
        if (LeftRecursiveRuleAnalyzer.hasImmediateRecursiveRuleRefs(r5, r10.getText()) == false) goto L5;
        Rule r20 = new LeftRecursiveRule(this.g, r10.getText(), r5);
    L6:
        this.rules.put(r20.name, r20);
        if (r12 == null) goto L9;
        AttributeDict r21 = ScopeParser.parseTypedArgList(r12, r12.getText(), this.g);
        r20.args = r21;
        r21.type = AttributeDict.DictType.ARG;
        r21.ast = r12;
        r12.resolver = r20.alt[this.currentOuterAltNumber];
    L9:
        if (r13 == null) goto L11;
        AttributeDict r22 = ScopeParser.parseTypedArgList(r13, r13.getText(), this.g);
        r20.retvals = r22;
        r22.type = AttributeDict.DictType.RET;
        r22.ast = r13;
    L11:
        if (r16 == null) goto L13;
        AttributeDict r23 = ScopeParser.parseTypedArgList(r16, r16.getText(), this.g);
        r20.locals = r23;
        r23.type = AttributeDict.DictType.LOCAL;
        r23.ast = r16;
    L13:
        Iterator<GrammarAST> r24 = r17.iterator();
    L15:
        if (r24.hasNext() == false) goto L17;
        GrammarAST r25 = r24.next();
        ActionAST r26 = (ActionAST) r25.getChild(1);
        r20.namedActions.put(r25.getChild(0).getText(), r26);
        r26.resolver = r20;
        goto L15
    L17:
        return;
    L5:
        r20 = new Rule(this.g, r10.getText(), r5, r19);
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.GrammarTreeVisitor
    public ErrorManager getErrorManager() {
        return this.errMgr;
    }

    public void process(GrammarAST r5) {
        visitGrammar(r5);
    }
}
