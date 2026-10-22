package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.v4.codegen.ActionTranslator;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.codegen.ParserFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ActionChunk;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.Decl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.RuleContextDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.RuleContextListDecl;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.OrderedHashSet;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InvokeRule extends RuleElement implements LabeledOp {

    @ModelElement
    public List<ActionChunk> argExprsChunks;
    public String ctxName;
    public OrderedHashSet<Decl> labels;
    public String name;

    public InvokeRule(ParserFactory r5, GrammarAST r10, GrammarAST r11) {
        super(r5, r10);
        this.labels = new OrderedHashSet();
        ATNState r12 = r10.atnState;
        if (r12 == null) goto L5;
        RuleTransition r13 = (RuleTransition) r12.transition(0);
        this.stateNumber = r10.atnState.stateNumber;
    L5:
        this.name = r10.getText();
        CodeGenerator r14 = r5.getGenerator();
        Rule r15 = r5.getGrammar().getRule(this.name);
        this.ctxName = r14.getTarget().getRuleFunctionContextStructName(r15);
        RuleFunction r16 = r5.getCurrentRuleFunction();
        if (r11 == null) goto L11;
        String r17 = r11.getText();
        if (r11.parent.getType() != 46) goto L10;
        r5.defineImplicitLabel(r10, this);
        RuleContextListDecl r18 = new RuleContextListDecl(r5, r14.getTarget().getListLabel(r17), this.ctxName);
        r16.addContextDecl(r10.getAltLabel(), r18);
        goto L11
    L10:
        RuleContextDecl r19 = new RuleContextDecl(r5, r17, this.ctxName);
        this.labels.add(r19);
        r16.addContextDecl(r10.getAltLabel(), r19);
    L11:
        ActionAST r20 = (ActionAST) r10.getFirstChildWithType(8);
        if (r20 == null) goto L15;
        this.argExprsChunks = ActionTranslator.translateAction(r5, r16, r20.token, r20);
    L15:
        if (r5.getCurrentOuterMostAlt().ruleRefsInActions.containsKey(r10.getText()) == false) goto L18;
        RuleContextDecl r21 = new RuleContextDecl(r5, r14.getTarget().getImplicitRuleLabel(r10.getText()), this.ctxName);
        this.labels.add(r21);
        r16.addContextDecl(r10.getAltLabel(), r21);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.model.LabeledOp
    public List<Decl> getLabels() {
        return this.labels.elements();
    }
}
