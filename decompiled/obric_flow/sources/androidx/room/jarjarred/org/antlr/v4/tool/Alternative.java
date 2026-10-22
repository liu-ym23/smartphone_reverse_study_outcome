package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.MultiMap;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Alternative implements AttributeResolver {
    public List<ActionAST> actions;
    public int altNum;
    public AltAST ast;
    public MultiMap<String, LabelElementPair> labelDefs;
    public Rule rule;
    public MultiMap<String, GrammarAST> ruleRefs;
    public MultiMap<String, GrammarAST> ruleRefsInActions;
    public MultiMap<String, TerminalAST> tokenRefs;
    public MultiMap<String, GrammarAST> tokenRefsInActions;

    public Alternative(Rule r5, int r10) {
        this.tokenRefs = new MultiMap();
        this.tokenRefsInActions = new MultiMap();
        this.ruleRefs = new MultiMap();
        this.ruleRefsInActions = new MultiMap();
        this.labelDefs = new MultiMap();
        this.actions = new ArrayList();
        this.rule = r5;
        this.altNum = r10;
    }

    public LabelElementPair getAnyLabelDef(String r5) {
        List r10 = (List) this.labelDefs.get(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        return (LabelElementPair) r10.get(0);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public Attribute resolveToAttribute(String r5, ActionAST r10) {
        return this.rule.resolveToAttribute(r5, r10);
    }

    public Rule resolveToRule(String r5) {
        if (this.ruleRefs.get(r5) != null) goto L5;
        LabelElementPair r10 = getAnyLabelDef(r5);
        if (r10 != null) goto L9;
        return null;
    L9:
        if (r10.type == LabelType.RULE_LABEL) goto L11;
        return null;
    L11:
        return this.rule.g.getRule(r10.element.getText());
    L5:
        return this.rule.g.getRule(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public boolean resolvesToAttributeDict(String r5, ActionAST r10) {
        if (resolvesToToken(r5, r10) == false) goto L6;
        return true;
    L6:
        if (this.ruleRefs.get(r5) == null) goto L8;
        return true;
    L8:
        LabelElementPair r11 = getAnyLabelDef(r5);
        if (r11 != null) goto L11;
        return false;
    L11:
        if (r11.type != LabelType.RULE_LABEL) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public boolean resolvesToLabel(String r5, ActionAST r10) {
        LabelElementPair r11 = getAnyLabelDef(r5);
        if (r11 == null) goto L9;
        LabelType r12 = r11.type;
        if (r12 != LabelType.TOKEN_LABEL) goto L7;
    L8:
        return true;
    L7:
        if (r12 == LabelType.RULE_LABEL) goto L8;
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
        if (this.tokenRefs.get(r5) == null) goto L5;
        return true;
    L5:
        LabelElementPair r11 = getAnyLabelDef(r5);
        if (r11 != null) goto L8;
        return false;
    L8:
        if (r11.type != LabelType.TOKEN_LABEL) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver
    public Attribute resolveToAttribute(String r5, String r10, ActionAST r11) {
        if (this.tokenRefs.get(r5) == null) goto L7;
        return this.rule.getPredefinedScope(LabelType.TOKEN_LABEL).get(r10);
    L7:
        if (this.ruleRefs.get(r5) != null) goto L9;
        LabelElementPair r12 = getAnyLabelDef(r5);
        if (r12 == null) goto L17;
        if (r12.type != LabelType.RULE_LABEL) goto L17;
        return this.rule.g.getRule(r12.element.getText()).resolveRetvalOrProperty(r10);
    L17:
        if (r12 == null) goto L23;
        AttributeDict r13 = this.rule.getPredefinedScope(r12.type);
        if (r13 != null) goto L22;
        return null;
    L22:
        return r13.get(r10);
    L23:
        return null;
    L9:
        return this.rule.g.getRule(r5).resolveRetvalOrProperty(r10);
    }
}
