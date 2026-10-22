package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.PredAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.MultiMap;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class Rule implements AttributeResolver {
    public static final AttributeDict predefinedRulePropertiesDict = null;
    public static final Set<String> validLexerCommands = null;
    public int actionIndex;
    public List<ActionAST> actions;
    public Alternative[] alt;
    public AttributeDict args;
    public RuleAST ast;
    public List<GrammarAST> exceptions;
    public ActionAST finallyAction;
    public Grammar g;
    public int index;
    public boolean isStartRule;
    public AttributeDict locals;
    public String mode;
    public List<GrammarAST> modifiers;
    public String name;
    public Map<String, ActionAST> namedActions;
    public int numberOfAlts;
    public AttributeDict retvals;

    static {
        AttributeDict r5 = new AttributeDict(AttributeDict.DictType.PREDEFINED_RULE);
        predefinedRulePropertiesDict = r5;
        r5.add(new Attribute("parser"));
        r5.add(new Attribute(MessageIndication.CONTENT_TYPE_TEXT));
        r5.add(new Attribute("start"));
        r5.add(new Attribute("stop"));
        r5.add(new Attribute("ctx"));
        HashSet r10 = new HashSet();
        validLexerCommands = r10;
        r10.add("mode");
        r10.add("pushMode");
        r10.add("type");
        r10.add(LynxMonitorService.KEY_CHANNEL);
        r10.add("popMode");
        r10.add("skip");
        r10.add("more");
    }

    public Rule(Grammar r5, String r10, RuleAST r11, int r12) {
        this.namedActions = new HashMap();
        this.exceptions = new ArrayList();
        this.actions = new ArrayList();
        int r13 = 1;
        this.isStartRule = true;
        this.actionIndex = -1;
        this.g = r5;
        this.name = r10;
        this.ast = r11;
        this.numberOfAlts = r12;
        this.alt = new Alternative[r12 + 1];
    L3:
        if (r13 > r12) goto L5;
        this.alt[r13] = new Alternative(this, r13);
        r13 = r13 + 1;
        goto L3
    }

    public void defineActionInAlt(int r5, ActionAST r10) {
        this.actions.add(r10);
        this.alt[r5].actions.add(r10);
        if (this.g.isLexer() == false) goto L6;
        defineLexerAction(r10);
        return;
    }

    public void defineLexerAction(ActionAST r5) {
        this.actionIndex = this.g.lexerActions.size();
        if (this.g.lexerActions.get(r5) != null) goto L6;
        this.g.lexerActions.put(r5, Integer.valueOf(this.actionIndex));
        return;
    }

    public void definePredicateInAlt(int r5, PredAST r10) {
        this.actions.add(r10);
        this.alt[r5].actions.add(r10);
        if (this.g.sempreds.get(r10) != null) goto L6;
        LinkedHashMap<PredAST, Integer> r11 = this.g.sempreds;
        r11.put(r10, Integer.valueOf(r11.size()));
        return;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Rule) == true) goto L10;
        return false;
    L10:
        return this.name.equals(((Rule) r5).name);
    }

    public Map<String, List<Pair<Integer, AltAST>>> getAltLabels() {
        LinkedHashMap r5 = new LinkedHashMap();
        int r10 = 1;
    L4:
        if (r10 > this.numberOfAlts) goto L13;
        GrammarAST r11 = this.alt[r10].ast.altLabel;
        if (r11 == null) goto L11;
        List r12 = (List) r5.get(r11.getText());
        if (r12 != null) goto L10;
        r12 = new ArrayList();
        r5.put(r11.getText(), r12);
    L10:
        r12.add(new Pair(Integer.valueOf(r10), this.alt[r10].ast));
    L11:
        r10 = r10 + 1;
        goto L4
    L13:
        if (r5.isEmpty() == false) goto L16;
        return null;
    L16:
        return r5;
    }

    public LabelElementPair getAnyLabelDef(String r5) {
        List r10 = (List) getElementLabelDefs().get(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        return (LabelElementPair) r10.get(0);
    }

    public MultiMap<String, LabelElementPair> getElementLabelDefs() {
        MultiMap<String, LabelElementPair> r5 = new MultiMap();
        int r10 = 1;
    L4:
        if (r10 > this.numberOfAlts) goto L13;
        Iterator<LabelElementPair> r11 = this.alt[r10].labelDefs.values().iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        Iterator r12 = ((List) r11.next()).iterator();
    L10:
        if (r12.hasNext() == false) goto L7;
        LabelElementPair r13 = (LabelElementPair) r12.next();
        r5.map(r13.label.getText(), r13);
        goto L10
    L12:
        r10 = r10 + 1;
        goto L4
    L13:
        return r5;
    }

    public Set<String> getElementLabelNames() {
        HashSet r5 = new HashSet();
        int r10 = 1;
    L4:
        if (r10 > this.numberOfAlts) goto L7;
        r5.addAll(this.alt[r10].labelDefs.keySet());
        r10 = r10 + 1;
        goto L4
    L7:
        if (r5.isEmpty() == false) goto L10;
        return null;
    L10:
        return r5;
    }

    public int getOriginalNumberOfAlts() {
        return this.numberOfAlts;
    }

    public AttributeDict getPredefinedScope(LabelType r5) {
        return Grammar.grammarAndLabelRefTypeToScope.get(this.g.getTypeString() + ":" + r5);
    }

    public Set<String> getTokenRefs() {
        HashSet r5 = new HashSet();
        int r10 = 1;
    L4:
        if (r10 > this.numberOfAlts) goto L6;
        r5.addAll(this.alt[r10].tokenRefs.keySet());
        r10 = r10 + 1;
        goto L4
    L6:
        return r5;
    }

    public List<AltAST> getUnlabeledAltASTs() {
        ArrayList r5 = new ArrayList();
        int r10 = 1;
    L4:
        if (r10 > this.numberOfAlts) goto L10;
        AltAST r11 = this.alt[r10].ast;
        if (r11.altLabel != null) goto L8;
        r5.add(r11);
    L8:
        r10 = r10 + 1;
        goto L4
    L10:
        if (r5.isEmpty() == false) goto L13;
        return null;
    L13:
        return r5;
    }

    public boolean hasAltSpecificContexts() {
        if (getAltLabels() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean isFragment() {
        List<GrammarAST> r5 = this.modifiers;
        if (r5 != null) goto L5;
        return false;
    L5:
        Iterator<GrammarAST> r10 = r5.iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        if (r10.next().getText().equals("fragment") == false) goto L7;
        return true;
    L12:
        return false;
    }

    public Attribute resolveRetvalOrProperty(String r5) {
        AttributeDict r10 = this.retvals;
        if (r10 == null) goto L8;
        Attribute r11 = r10.get(r5);
        if (r11 == null) goto L8;
        return r11;
    L8:
        return getPredefinedScope(LabelType.RULE_LABEL).get(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public Attribute resolveToAttribute(String r5, ActionAST r10) {
        AttributeDict r11 = this.args;
        if (r11 == null) goto L7;
        Attribute r12 = r11.get(r5);
        if (r12 == null) goto L7;
        return r12;
    L7:
        AttributeDict r13 = this.retvals;
        if (r13 == null) goto L12;
        Attribute r14 = r13.get(r5);
        if (r14 == null) goto L12;
        return r14;
    L12:
        AttributeDict r15 = this.locals;
        if (r15 == null) goto L18;
        Attribute r16 = r15.get(r5);
        if (r16 == null) goto L18;
        return r16;
    L18:
        return getPredefinedScope(LabelType.RULE_LABEL).get(r5);
    }

    public Rule resolveToRule(String r5) {
        if (r5.equals(this.name) == false) goto L5;
        return this;
    L5:
        LabelElementPair r10 = getAnyLabelDef(r5);
        if (r10 == null) goto L12;
        if (r10.type != LabelType.RULE_LABEL) goto L12;
        return this.g.getRule(r10.element.getText());
    L12:
        return this.g.getRule(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public boolean resolvesToAttributeDict(String r5, ActionAST r10) {
        if (resolvesToToken(r5, r10) == false) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public boolean resolvesToLabel(String r5, ActionAST r10) {
        LabelElementPair r11 = getAnyLabelDef(r5);
        if (r11 == null) goto L9;
        LabelType r12 = r11.type;
        if (r12 != LabelType.RULE_LABEL) goto L7;
    L8:
        return true;
    L7:
        if (r12 == LabelType.TOKEN_LABEL) goto L8;
    L9:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public boolean resolvesToListLabel(String r5, ActionAST r10) {
        LabelElementPair r11 = getAnyLabelDef(r5);
        if (r11 == null) goto L9;
        LabelType r12 = r11.type;
        if (r12 != LabelType.RULE_LIST_LABEL) goto L7;
    L8:
        return true;
    L7:
        if (r12 == LabelType.TOKEN_LIST_LABEL) goto L8;
    L9:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public boolean resolvesToToken(String r5, ActionAST r10) {
        LabelElementPair r11 = getAnyLabelDef(r5);
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.type != LabelType.TOKEN_LABEL) goto L10;
        return true;
    L10:
        return false;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("Rule{name=");
        r5.append(this.name);
        if (this.args == null) goto L6;
        r5.append(", args=");
        r5.append(this.args);
    L6:
        if (this.retvals == null) goto L8;
        r5.append(", retvals=");
        r5.append(this.retvals);
    L8:
        r5.append("}");
        return r5.toString();
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public Attribute resolveToAttribute(String r5, String r10, ActionAST r11) {
        LabelElementPair r12 = getAnyLabelDef(r5);
        if (r12 == null) goto L13;
        LabelType r13 = r12.type;
        if (r13 == LabelType.RULE_LABEL) goto L7;
        AttributeDict r14 = getPredefinedScope(r13);
        if (r14 != null) goto L12;
        return null;
    L12:
        return r14.get(r10);
    L7:
        return this.g.getRule(r12.element.getText()).resolveRetvalOrProperty(r10);
    L13:
        return null;
    }
}
