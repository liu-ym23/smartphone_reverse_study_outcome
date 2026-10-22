package androidx.room.jarjarred.org.antlr.v4.codegen.model;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeNodeStream;
import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.AltLabelStructDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.AttributeDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.ContextRuleGetterDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.ContextRuleListGetterDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.ContextRuleListIndexedGetterDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.ContextTokenGetterDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.ContextTokenListGetterDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.ContextTokenListIndexedGetterDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.Decl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.StructDecl;
import androidx.room.jarjarred.org.antlr.v4.misc.FrequencySet;
import androidx.room.jarjarred.org.antlr.v4.misc.Utils;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarASTAdaptor;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.OrderedHashSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import androidx.room.jarjarred.org.antlr.v4.tool.Attribute;
import androidx.room.jarjarred.org.antlr.v4.tool.AttributeDict;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class RuleFunction extends OutputModelObject {

    @ModelElement
    public Map<String, AltLabelStructDecl> altLabelCtxs;
    public AltLabelStructDecl[] altToContext;

    @ModelElement
    public Collection<AttributeDecl> args;

    @ModelElement
    public List<SrcOp> code;
    public String ctxType;

    @ModelElement
    public List<ExceptionClause> exceptions;

    @ModelElement
    public Action finallyAction;
    public boolean hasLookaheadBlock;
    public int index;

    @ModelElement
    public OrderedHashSet<Decl> locals;
    public List<String> modifiers;
    public String name;

    @ModelElement
    public Map<String, Action> namedActions;

    @ModelElement
    public List<SrcOp> postamble;
    public Rule rule;

    @ModelElement
    public StructDecl ruleCtx;
    public Collection<String> ruleLabels;
    public ATNState startState;
    public Collection<String> tokenLabels;

    public RuleFunction(OutputModelFactory r10, Rule r11) {
        super(r10);
        this.args = null;
        this.name = r11.name;
        this.rule = r11;
        List<GrammarAST> r5 = r11.modifiers;
        if (r5 != null) goto L5;
    L10:
        this.modifiers = Utils.nodesToStrings(r11.modifiers);
        this.index = r11.index;
        this.ruleCtx = new StructDecl(r10, r11);
        this.altToContext = new AltLabelStructDecl[r11.getOriginalNumberOfAlts() + 1];
        addContextGetters(r10, r11);
        AttributeDict r12 = r11.args;
        if (r12 == null) goto L19;
        Collection<Attribute> r13 = r12.attributes.values();
        if (r13.size() <= 0) goto L19;
        this.args = new ArrayList();
        this.ruleCtx.addDecls(r13);
        Iterator<Attribute> r14 = r13.iterator();
    L16:
        if (r14.hasNext() == false) goto L18;
        Attribute r15 = r14.next();
        this.args.add(new AttributeDecl(r10, r15));
        goto L16
    L18:
        StructDecl r16 = this.ruleCtx;
        r16.ctorAttrs = this.args;
    L19:
        AttributeDict r17 = r11.retvals;
        if (r17 == null) goto L22;
        this.ruleCtx.addDecls(r17.attributes.values());
    L22:
        AttributeDict r18 = r11.locals;
        if (r18 == null) goto L25;
        this.ruleCtx.addDecls(r18.attributes.values());
    L25:
        this.ruleLabels = r11.getElementLabelNames();
        this.tokenLabels = r11.getTokenRefs();
        if (r11.exceptions == null) goto L31;
        this.exceptions = new ArrayList();
        Iterator<GrammarAST> r19 = r11.exceptions.iterator();
    L29:
        if (r19.hasNext() == false) goto L31;
        GrammarAST r20 = r19.next();
        ActionAST r21 = (ActionAST) r20.getChild(0);
        ActionAST r22 = (ActionAST) r20.getChild(1);
        this.exceptions.add(new ExceptionClause(r10, r21, r22));
    L31:
        this.startState = r10.getGrammar().atn.ruleToStartState[r11.index];
        return;
    L5:
        if (r5.isEmpty() == true) goto L10;
        this.modifiers = new ArrayList();
        Iterator<GrammarAST> r23 = r11.modifiers.iterator();
    L8:
        if (r23.hasNext() == false) goto L10;
        GrammarAST r24 = r23.next();
        this.modifiers.add(r24.getText());
        goto L8
    }

    public void addContextDecl(String r5, Decl r10) {
        if (r10.getOuterMostAltCodeBlock() == null) goto L10;
        Map<String, AltLabelStructDecl> r11 = this.altLabelCtxs;
        if (r11 == null) goto L10;
        AltLabelStructDecl r12 = r11.get(r5);
        if (r12 == null) goto L10;
        r12.addDecl(r10);
        return;
    L10:
        this.ruleCtx.addDecl(r10);
    }

    public void addContextGetters(OutputModelFactory r10, Rule r11) {
        List<AltAST> r5 = r11.getUnlabeledAltASTs();
        if (r5 == null) goto L8;
        Iterator<Decl> r12 = getDeclsForAllElements(r5).iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        Decl r13 = r12.next();
        this.ruleCtx.addDecl(r13);
    L8:
        this.altLabelCtxs = new HashMap();
        Map<String, List<Pair<Integer, AltAST>>> r14 = r11.getAltLabels();
        if (r14 == null) goto L27;
        Iterator<Map.Entry<String, List<Pair<Integer, AltAST>>>> r15 = r14.entrySet().iterator();
    L12:
        if (r15.hasNext() == false) goto L33;
        Map.Entry<String, List<Pair<Integer, AltAST>>> r16 = r15.next();
        String r17 = r16.getKey();
        ArrayList r18 = new ArrayList();
        Iterator<Pair<Integer, AltAST>> r19 = r16.getValue().iterator();
    L15:
        if (r19.hasNext() == false) goto L17;
        r18.add(r19.next().f668b);
        goto L15
    L17:
        Set<Decl> r20 = getDeclsForAllElements(r18);
        Iterator<Pair<Integer, AltAST>> r21 = r16.getValue().iterator();
    L19:
        if (r21.hasNext() == false) goto L12;
        Integer r22 = r21.next().f667a;
        this.altToContext[r22.intValue()] = new AltLabelStructDecl(r10, r11, r22.intValue(), r17);
        if (this.altLabelCtxs.containsKey(r17) == true) goto L23;
        this.altLabelCtxs.put(r17, this.altToContext[r22.intValue()]);
    L23:
        Iterator<Decl> r23 = r20.iterator();
    L25:
        if (r23.hasNext() == false) goto L19;
        Decl r24 = r23.next();
        this.altToContext[r22.intValue()].addDecl(r24);
        goto L25
    L33:
        return;
    }

    public void addLocalDecl(Decl r5) {
        if (this.locals != null) goto L5;
        this.locals = new OrderedHashSet();
    L5:
        this.locals.add(r5);
        r5.isLocal = true;
    }

    public void fillNamedActions(OutputModelFactory r10, Rule r11) {
        ActionAST r5 = r11.finallyAction;
        if (r5 == null) goto L5;
        this.finallyAction = new Action(r10, r5);
    L5:
        this.namedActions = new HashMap();
        Iterator<String> r12 = r11.namedActions.keySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        String r13 = r12.next();
        ActionAST r14 = r11.namedActions.get(r13);
        this.namedActions.put(r13, new Action(r10, r14));
        goto L7
    }

    public List<Decl> getDeclForAltElement(GrammarAST r5, String r10, boolean r11, boolean r12) {
        ArrayList r13 = new ArrayList();
        if (r5.getType() != 57) goto L11;
        Rule r14 = this.factory.getGrammar().getRule(r5.getText());
        String r15 = this.factory.getGenerator().getTarget().getRuleFunctionContextStructName(r14);
        if (r11 == true) goto L7;
        r13.add(new ContextRuleGetterDecl(this.factory, r10, r15, r12));
    L17:
        return r13;
    L7:
        if (this.factory.getGenerator().getTarget().supportsOverloadedMethods() == false) goto L9;
        r13.add(new ContextRuleListGetterDecl(this.factory, r10, r15));
    L9:
        r13.add(new ContextRuleListIndexedGetterDecl(this.factory, r10, r15));
        goto L17
    L11:
        if (r11 == true) goto L13;
        r13.add(new ContextTokenGetterDecl(this.factory, r10, r12));
        goto L17
    L13:
        if (this.factory.getGenerator().getTarget().supportsOverloadedMethods() == false) goto L15;
        r13.add(new ContextTokenListGetterDecl(this.factory, r10));
    L15:
        r13.add(new ContextTokenListIndexedGetterDecl(this.factory, r10));
        goto L17
    }

    public Set<Decl> getDeclsForAllElements(List<AltAST> r12) {
        HashSet r5 = new HashSet();
        HashSet r10 = new HashSet();
        ArrayList r11 = new ArrayList();
        Iterator<AltAST> r13 = r12.iterator();
        boolean r14 = true;
    L4:
        if (r13.hasNext() == false) goto L22;
        AltAST r15 = r13.next();
        List<GrammarAST> r16 = r15.getNodesWithType(new IntervalSet(new int[]{57, 66}));
        r11.addAll(r16);
        Pair<FrequencySet<String>, FrequencySet<String>> r17 = getElementFrequenciesForAlt(r15);
        FrequencySet<String> r18 = r17.f667a;
        FrequencySet<String> r19 = r17.f668b;
        Iterator<GrammarAST> r20 = r16.iterator();
    L7:
        if (r20.hasNext() == false) goto L15;
        String r21 = r20.next().getText();
        if (r19.count(r21) <= 1) goto L11;
        r5.add(r21);
    L11:
        if (r14 == false) goto L7;
        if (r18.count(r21) == 0) goto L7;
        r10.add(r21);
        goto L7
    L15:
        String[] r22 = (String[]) r10.toArray(new String[r10.size()]);
        int r23 = r22.length;
        int r24 = 0;
    L16:
        if (r24 >= r23) goto L21;
        String r25 = r22[r24];
        if (r18.count(r25) != 0) goto L20;
        r10.remove(r25);
    L20:
        r24 = r24 + 1;
        goto L16
    L21:
        r14 = false;
        goto L4
    L22:
        LinkedHashSet r110 = new LinkedHashSet();
        Iterator r26 = r11.iterator();
    L24:
        if (r26.hasNext() == false) goto L26;
        GrammarAST r27 = (GrammarAST) r26.next();
        String r28 = r27.getText();
        r110.addAll(getDeclForAltElement(r27, r28, r5.contains(r28), !r10.contains(r28)));
        goto L24
    L26:
        return r110;
    }

    public Pair<FrequencySet<String>, FrequencySet<String>> getElementFrequenciesForAlt(AltAST r5) {
        ElementFrequenciesVisitor r10 = new ElementFrequenciesVisitor(new CommonTreeNodeStream(new GrammarASTAdaptor(), r5));     // Catch: RecognitionException -> L7
        r10.outerAlternative();     // Catch: RecognitionException -> L7
        if (r10.frequencies.size() == 1) goto L10;
        this.factory.getGrammar().tool.errMgr.toolError(ErrorType.INTERNAL_ERROR, new Object[0]);     // Catch: RecognitionException -> L7
        return new Pair(new FrequencySet(), new FrequencySet());
    L10:
        return new Pair(r10.getMinFrequencies(), r10.frequencies.peek());
    L7:
        e = move-exception;
        this.factory.getGrammar().tool.errMgr.toolError(ErrorType.INTERNAL_ERROR, e, new Object[0]);
        return new Pair(new FrequencySet(), new FrequencySet());
    }
}
