package androidx.room.jarjarred.org.antlr.v4.semantics;

import androidx.room.jarjarred.org.antlr.runtime.ANTLRStringStream;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitter;
import androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;
import androidx.room.jarjarred.org.antlr.v4.tool.AttributeDict;
import androidx.room.jarjarred.org.antlr.v4.tool.AttributeResolver;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorManager;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LabelElementPair;
import androidx.room.jarjarred.org.antlr.v4.tool.LabelType;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AttributeChecks implements ActionSplitterListener {
    public Token actionToken;
    public Alternative alt;
    public ErrorManager errMgr;
    public Grammar g;
    public ActionAST node;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Rule f673r;

    public AttributeChecks(Grammar r5, Rule r10, Alternative r11, ActionAST r12, Token r13) {
        this.g = r5;
        this.f673r = r10;
        this.alt = r11;
        this.node = r12;
        this.actionToken = r13;
        this.errMgr = r5.tool.errMgr;
    }

    public static void checkAllAttributeExpressions(Grammar r13) {
        Iterator<ActionAST> r5 = r13.namedActions.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ActionAST r10 = r5.next();
        new AttributeChecks(r13, null, null, r10, r10.token).examineAction();
        goto L4
    L6:
        Iterator<Rule> r11 = r13.rules.values().iterator();
    L8:
        if (r11.hasNext() == false) goto L28;
        Rule r12 = r11.next();
        Iterator<ActionAST> r14 = r12.namedActions.values().iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        ActionAST r15 = r14.next();
        new AttributeChecks(r13, r12, null, r15, r15.token).examineAction();
        goto L11
    L13:
        int r16 = 1;
    L15:
        if (r16 > r12.numberOfAlts) goto L21;
        Alternative r17 = r12.alt[r16];
        Iterator<ActionAST> r18 = r17.actions.iterator();
    L18:
        if (r18.hasNext() == false) goto L20;
        ActionAST r19 = r18.next();
        new AttributeChecks(r13, r12, r17, r19, r19.token).examineAction();
        goto L18
    L20:
        r16 = r16 + 1;
        goto L15
    L21:
        Iterator<GrammarAST> r20 = r12.exceptions.iterator();
    L23:
        if (r20.hasNext() == false) goto L25;
        ActionAST r21 = (ActionAST) r20.next().getChild(1);
        new AttributeChecks(r13, r12, null, r21, r21.token).examineAction();
        goto L23
    L25:
        ActionAST r22 = r12.finallyAction;
        if (r22 == null) goto L8;
        new AttributeChecks(r13, r12, null, r22, r22.token).examineAction();
        goto L8
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void attr(String r5, Token r10) {
        if (this.g.isLexer() == false) goto L7;
        this.errMgr.grammarError(ErrorType.ATTRIBUTE_IN_LEXER_ACTION, this.g.fileName, r10, new Object[]{r10.getText(), r5});
        return;
    L7:
        if (this.node.resolver.resolveToAttribute(r10.getText(), this.node) == null) goto L9;
        return;
    L9:
        if (this.node.resolver.resolvesToToken(r10.getText(), this.node) == false) goto L12;
        return;
    L12:
        if (this.node.resolver.resolvesToListLabel(r10.getText(), this.node) == false) goto L15;
        return;
    L15:
        if (isolatedRuleRef(r10.getText()) == null) goto L18;
        this.errMgr.grammarError(ErrorType.ISOLATED_RULE_REF, this.g.fileName, r10, new Object[]{r10.getText(), r5});
        return;
    L18:
        this.errMgr.grammarError(ErrorType.UNKNOWN_SIMPLE_ATTRIBUTE, this.g.fileName, r10, new Object[]{r10.getText(), r5});
    }

    public void examineAction() {
        ANTLRStringStream r5 = new ANTLRStringStream(this.actionToken.getText());
        r5.setLine(this.actionToken.getLine());
        r5.setCharPositionInLine(this.actionToken.getCharPositionInLine());
        ActionSplitter r10 = new ActionSplitter(r5, this);
        ActionAST r11 = this.node;
        r11.chunks = r10.getActionTokens();
    }

    public void indirectTemplateInstance(String r5) {
    }

    public Rule isolatedRuleRef(String r5) {
        if ((this.node.resolver instanceof Grammar) == false) goto L6;
        return null;
    L6:
        if (r5.equals(this.f673r.name) == true) goto L8;
        AttributeResolver r10 = this.node.resolver;
        if ((r10 instanceof Rule) == false) goto L13;
        List r11 = (List) this.f673r.getElementLabelDefs().get(r5);
    L16:
        if (r11 == null) goto L21;
        LabelElementPair r12 = (LabelElementPair) r11.get(0);
        if (r12.type != LabelType.RULE_LABEL) goto L21;
        return this.g.getRule(r12.element.getText());
    L21:
        AttributeResolver r13 = this.node.resolver;
        if ((r13 instanceof Alternative) == true) goto L24;
    L27:
        return null;
    L24:
        if (((Alternative) r13).ruleRefs.get(r5) == null) goto L27;
        return this.g.getRule(r5);
    L13:
        if ((r10 instanceof Alternative) == false) goto L15;
        r11 = (List) ((Alternative) r10).labelDefs.get(r5);
        goto L16
    L15:
        r11 = null;
        goto L16
    L8:
        return this.f673r;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void nonLocalAttr(String r5, Token r10, Token r11) {
        Rule r12 = this.g.getRule(r10.getText());
        if (r12 != null) goto L6;
        this.errMgr.grammarError(ErrorType.UNDEFINED_RULE_IN_NONLOCAL_REF, this.g.fileName, r10, new Object[]{r10.getText(), r11.getText(), r5});
        return;
    L6:
        if (r12.resolveToAttribute(r11.getText(), null) != null) goto L10;
        this.errMgr.grammarError(ErrorType.UNKNOWN_RULE_ATTRIBUTE, this.g.fileName, r11, new Object[]{r11.getText(), r10.getText(), r5});
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void qualifiedAttr(String r5, Token r10, Token r11) {
        if (this.g.isLexer() == false) goto L7;
        this.errMgr.grammarError(ErrorType.ATTRIBUTE_IN_LEXER_ACTION, this.g.fileName, r10, new Object[]{r10.getText() + "." + r11.getText(), r5});
        return;
    L7:
        if (this.node.resolver.resolveToAttribute(r10.getText(), this.node) == null) goto L11;
        attr(r5, r10);
        return;
    L11:
        if (this.node.resolver.resolveToAttribute(r10.getText(), r11.getText(), this.node) != null) goto L25;
        Rule r12 = isolatedRuleRef(r10.getText());
        if (r12 == null) goto L21;
        AttributeDict r13 = r12.args;
        if (r13 != null) goto L17;
    L19:
        this.errMgr.grammarError(ErrorType.UNKNOWN_RULE_ATTRIBUTE, this.g.fileName, r11, new Object[]{r11.getText(), r12.name, r5});
        return;
    L17:
        if (r13.get(r11.getText()) == null) goto L19;
        Grammar r14 = this.g;
        r14.tool.errMgr.grammarError(ErrorType.INVALID_RULE_PARAMETER_REF, r14.fileName, r11, new Object[]{r11.getText(), r12.name, r5});
        return;
    L21:
        if (this.node.resolver.resolvesToAttributeDict(r10.getText(), this.node) == true) goto L23;
        this.errMgr.grammarError(ErrorType.UNKNOWN_SIMPLE_ATTRIBUTE, this.g.fileName, r10, new Object[]{r10.getText(), r5});
        return;
    L23:
        this.errMgr.grammarError(ErrorType.UNKNOWN_ATTRIBUTE_IN_SCOPE, this.g.fileName, r11, new Object[]{r11.getText(), r5});
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void setAttr(String r10, Token r11, Token r12) {
        if (this.g.isLexer() == false) goto L7;
        this.errMgr.grammarError(ErrorType.ATTRIBUTE_IN_LEXER_ACTION, this.g.fileName, r11, new Object[]{r11.getText(), r10});
        return;
    L7:
        if (this.node.resolver.resolveToAttribute(r11.getText(), this.node) != null) goto L12;
        ErrorType r5 = ErrorType.UNKNOWN_SIMPLE_ATTRIBUTE;
        if (this.node.resolver.resolvesToListLabel(r11.getText(), this.node) == false) goto L11;
        r5 = ErrorType.ASSIGNMENT_TO_LIST_LABEL;
    L11:
        this.errMgr.grammarError(r5, this.g.fileName, r11, new Object[]{r11.getText(), r10});
    L12:
        new AttributeChecks(this.g, this.f673r, this.alt, this.node, r12).examineAction();
    }

    public void setExprAttribute(String r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void setNonLocalAttr(String r5, Token r10, Token r11, Token r12) {
        Rule r13 = this.g.getRule(r10.getText());
        if (r13 != null) goto L6;
        this.errMgr.grammarError(ErrorType.UNDEFINED_RULE_IN_NONLOCAL_REF, this.g.fileName, r10, new Object[]{r10.getText(), r11.getText(), r5});
        return;
    L6:
        if (r13.resolveToAttribute(r11.getText(), null) != null) goto L10;
        this.errMgr.grammarError(ErrorType.UNKNOWN_RULE_ATTRIBUTE, this.g.fileName, r11, new Object[]{r11.getText(), r10.getText(), r5});
        return;
    }

    public void setSTAttribute(String r5) {
    }

    public void templateExpr(String r5) {
    }

    public void templateInstance(String r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void text(String r5) {
    }
}
