package androidx.room.jarjarred.org.antlr.v4.codegen;

import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeNodeStream;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleAltInfo;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Action;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.AltBlock;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.BaseListenerFile;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.BaseVisitorFile;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Choice;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.CodeBlockForAlt;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.CodeBlockForOuterMostAlt;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LabeledOp;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LeftRecursiveRuleFunction;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Lexer;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LexerFile;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.ListenerFile;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.OutputModelObject;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Parser;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.ParserFile;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.RuleActionFunction;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.RuleFunction;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.RuleSempredFunction;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.SrcOp;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.StarBlock;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.VisitorFile;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.CodeBlock;
import androidx.room.jarjarred.org.antlr.v4.misc.Utils;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarASTAdaptor;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LeftRecursiveRule;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.PredAST;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class OutputModelController {
    public int codeBlockLevel;
    public CodeBlock currentBlock;
    public Alternative currentOuterMostAlt;
    public CodeBlockForOuterMostAlt currentOuterMostAlternativeBlock;
    public Stack<RuleFunction> currentRule;
    public OutputModelFactory delegate;
    public List<CodeGeneratorExtension> extensions;
    public OutputModelObject root;
    public int treeLevel;
    public SourceGenTriggers walker;

    public OutputModelController(OutputModelFactory r5) {
        this.extensions = new ArrayList();
        this.codeBlockLevel = -1;
        this.treeLevel = -1;
        this.currentRule = new Stack();
        this.delegate = r5;
    }

    public List<SrcOp> action(ActionAST r5) {
        List<SrcOp> r10 = this.delegate.action(r5);
        Iterator<CodeGeneratorExtension> r11 = this.extensions.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10 = r11.next().action(r10);
        goto L4
    L6:
        return r10;
    }

    public void addExtension(CodeGeneratorExtension r5) {
        this.extensions.add(r5);
    }

    public CodeBlockForAlt alternative(Alternative r5, boolean r10) {
        CodeBlockForAlt r11 = this.delegate.alternative(r5, r10);
        if (r10 == false) goto L5;
        this.currentOuterMostAlternativeBlock = (CodeBlockForOuterMostAlt) r11;
    L5:
        Iterator<CodeGeneratorExtension> r12 = this.extensions.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r11 = r12.next().alternative(r11, r10);
        goto L7
    L9:
        return r11;
    }

    public OutputModelObject buildBaseListenerOutputModel(boolean r5) {
        CodeGenerator r10 = this.delegate.getGenerator();
        return new BaseListenerFile(this.delegate, r10.getBaseListenerFileName(r5));
    }

    public OutputModelObject buildBaseVisitorOutputModel(boolean r5) {
        CodeGenerator r10 = this.delegate.getGenerator();
        return new BaseVisitorFile(this.delegate, r10.getBaseVisitorFileName(r5));
    }

    public void buildLeftRecursiveRuleFunction(LeftRecursiveRule r14, LeftRecursiveRuleFunction r15) {
        buildNormalRuleFunction(r14, r15);
        STGroup r5 = this.delegate.getGenerator().getTemplates();
        CodeBlockForOuterMostAlt r10 = (CodeBlockForOuterMostAlt) r15.code.get(0);
        ArrayList r11 = new ArrayList();
        SrcOp r12 = r10.ops.get(0);
        if ((r12 instanceof Choice) == false) goto L5;
        r11.addAll(((Choice) r12).alts);
    L6:
        StarBlock r13 = (StarBlock) r10.ops.get(1);
        CodeBlockForAlt r16 = r13.alts.get(0);
        ArrayList r17 = new ArrayList();
        SrcOp r18 = r16.ops.get(0);
        if ((r18 instanceof AltBlock) == false) goto L9;
        r17.addAll(((AltBlock) r18).alts);
    L10:
        int r19 = 0;
    L12:
        if (r19 >= r11.size()) goto L18;
        LeftRecursiveRuleAltInfo r20 = r14.recPrimaryAlts.get(r19);
        if (r20.altLabel == null) goto L17;
        ST r110 = r5.getInstanceOf("recRuleReplaceContext");
        r110.add("ctxName", Utils.capitalize(r20.altLabel));
        ((CodeBlockForAlt) r11.get(r19)).insertOp(0, new Action(this.delegate, r15.altLabelCtxs.get(r20.altLabel), r110));
    L17:
        r19 = r19 + 1;
        goto L12
    L18:
        r10.insertOp(1, new Action(this.delegate, r15.ruleCtx, r5.getInstanceOf("recRuleSetStopToken")));
        r13.addIterationOp(new Action(this.delegate, r15.ruleCtx, r5.getInstanceOf("recRuleSetPrevCtx")));
        int r21 = 0;
    L20:
        if (r21 >= r17.size()) goto L32;
        LeftRecursiveRuleAltInfo r22 = r14.recOpAlts.getElement(r21);
        if (r22.altLabel == null) goto L24;
        String r23 = "recRuleLabeledAltStartAction";
        ST r24 = r5.getInstanceOf("recRuleLabeledAltStartAction");
        r24.add("currentAltLabel", r22.altLabel);
    L25:
        r24.add("ruleName", r14.name);
        r24.add("label", r22.leftRecursiveRuleRefLabel);
        if (r24.impl.formalArguments.containsKey("isListLabel") == false) goto L29;
        r24.add("isListLabel", Boolean.valueOf(r22.isListLabel));
    L31:
        ((CodeBlockForAlt) r17.get(r21)).insertOp(0, new Action(this.delegate, r15.altLabelCtxs.get(r22.altLabel), r24));
        r21 = r21 + 1;
        goto L20
    L29:
        if (r22.isListLabel == false) goto L31;
        this.delegate.getGenerator().tool.errMgr.toolError(ErrorType.CODE_TEMPLATE_ARG_ISSUE, new Object[]{r23, "isListLabel"});
        goto L31
    L24:
        r23 = "recRuleAltStartAction";
        r24 = r5.getInstanceOf("recRuleAltStartAction");
        r24.add("ctxName", Utils.capitalize(r14.name));
        goto L25
    L32:
        return;
    L9:
        r17.add((CodeBlockForAlt) r18);
        goto L10
    L5:
        r11.add((CodeBlockForAlt) r12);
        goto L6
    }

    public OutputModelObject buildLexerOutputModel(boolean r5) {
        LexerFile r10 = lexerFile(this.delegate.getGenerator().getRecognizerFileName(r5));
        setRoot(r10);
        r10.lexer = lexer(r10);
        Iterator<Rule> r11 = this.delegate.getGrammar().rules.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Rule r12 = r11.next();
        buildLexerRuleActions(r10.lexer, r12);
        goto L4
    L6:
        return r10;
    }

    public void buildLexerRuleActions(Lexer r10, Rule r11) {
        if (r11.actions.isEmpty() == false) goto L5;
        return;
    L5:
        CodeGenerator r5 = this.delegate.getGenerator();
        Grammar r12 = this.delegate.getGrammar();
        String r13 = r5.getTarget().getRuleFunctionContextStructName(r11);
        RuleActionFunction r14 = r10.actionFuncs.get(r11);
        if (r14 != null) goto L8;
        r14 = new RuleActionFunction(this.delegate, r11, r13);
    L8:
        Iterator<ActionAST> r15 = r11.actions.iterator();
    L10:
        if (r15.hasNext() == false) goto L21;
        ActionAST r16 = r15.next();
        if ((r16 instanceof PredAST) == true) goto L13;
        if (r16.getType() != 4) goto L10;
        r14.actions.put(r12.lexerActions.get(r16), new Action(this.delegate, r16));
        goto L10
    L13:
        PredAST r17 = (PredAST) r16;
        RuleSempredFunction r18 = r10.sempredFuncs.get(r11);
        if (r18 != null) goto L16;
        r18 = new RuleSempredFunction(this.delegate, r11, r13);
        r10.sempredFuncs.put(r11, r18);
    L16:
        r18.actions.put(r12.sempreds.get(r17), new Action(this.delegate, r17));
        goto L10
    L21:
        if (r14.actions.isEmpty() == false) goto L23;
        return;
    L23:
        if (r10.actionFuncs.containsKey(r11) == true) goto L35;
        r10.actionFuncs.put(r11, r14);
        return;
    }

    public OutputModelObject buildListenerOutputModel(boolean r5) {
        CodeGenerator r10 = this.delegate.getGenerator();
        return new ListenerFile(this.delegate, r10.getListenerFileName(r5));
    }

    public void buildNormalRuleFunction(Rule r5, RuleFunction r10) {
        CodeGenerator r11 = this.delegate.getGenerator();
        SourceGenTriggers r12 = new SourceGenTriggers(new CommonTreeNodeStream(new GrammarASTAdaptor(r5.ast.token.getInputStream()), (GrammarAST) r5.ast.getFirstChildWithType(78)), this);
        this.walker = r12;
        r10.code = DefaultOutputModelFactory.list(r12.block(null, null));     // Catch: RecognitionException -> L5
        r10.hasLookaheadBlock = this.walker.hasLookaheadBlock;     // Catch: RecognitionException -> L5
    L7:
        r10.ctxType = r11.getTarget().getRuleFunctionContextStructName(r10);
        r10.postamble = rulePostamble(r10, r5);
        return;
    L5:
        e = move-exception;
        e.printStackTrace(System.err);
        goto L7
    }

    public OutputModelObject buildParserOutputModel(boolean r5) {
        ParserFile r10 = parserFile(this.delegate.getGenerator().getRecognizerFileName(r5));
        setRoot(r10);
        r10.parser = parser(r10);
        Iterator<Rule> r11 = this.delegate.getGrammar().rules.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Rule r12 = r11.next();
        buildRuleFunction(r10.parser, r12);
        goto L4
    L6:
        return r10;
    }

    public void buildRuleFunction(Parser r10, Rule r11) {
        RuleFunction r5 = rule(r11);
        r10.funcs.add(r5);
        pushCurrentRule(r5);
        r5.fillNamedActions(this.delegate, r11);
        if ((r11 instanceof LeftRecursiveRule) == false) goto L5;
        buildLeftRecursiveRuleFunction((LeftRecursiveRule) r11, (LeftRecursiveRuleFunction) r5);
    L6:
        Grammar r12 = getGrammar();
        Iterator<ActionAST> r13 = r11.actions.iterator();
    L8:
        if (r13.hasNext() == false) goto L15;
        ActionAST r14 = r13.next();
        if ((r14 instanceof PredAST) == false) goto L8;
        PredAST r15 = (PredAST) r14;
        RuleSempredFunction r16 = r10.sempredFuncs.get(r11);
        if (r16 != null) goto L14;
        r16 = new RuleSempredFunction(this.delegate, r11, r5.ctxType);
        r10.sempredFuncs.put(r11, r16);
    L14:
        r16.actions.put(r12.sempreds.get(r15), new Action(this.delegate, r15));
        goto L8
    L15:
        popCurrentRule();
        return;
    L5:
        buildNormalRuleFunction(r11, r5);
        goto L6
    }

    public OutputModelObject buildVisitorOutputModel(boolean r5) {
        CodeGenerator r10 = this.delegate.getGenerator();
        return new VisitorFile(this.delegate, r10.getVisitorFileName(r5));
    }

    public CodeBlockForAlt epsilon(Alternative r5, boolean r10) {
        CodeBlockForAlt r11 = this.delegate.epsilon(r5, r10);
        Iterator<CodeGeneratorExtension> r12 = this.extensions.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11 = r12.next().epsilon(r11);
        goto L4
    L6:
        return r11;
    }

    public CodeBlockForAlt finishAlternative(CodeBlockForAlt r5, List<SrcOp> r10, boolean r11) {
        CodeBlockForAlt r12 = this.delegate.finishAlternative(r5, r10);
        Iterator<CodeGeneratorExtension> r13 = this.extensions.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12 = r13.next().finishAlternative(r12, r11);
        goto L4
    L6:
        return r12;
    }

    public Choice getChoiceBlock(BlockAST r5, List<CodeBlockForAlt> r10, GrammarAST r11) {
        Choice r12 = this.delegate.getChoiceBlock(r5, r10, r11);
        Iterator<CodeGeneratorExtension> r13 = this.extensions.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12 = r13.next().getChoiceBlock(r12);
        goto L4
    L6:
        return r12;
    }

    public int getCodeBlockLevel() {
        return this.codeBlockLevel;
    }

    public CodeBlock getCurrentBlock() {
        return this.currentBlock;
    }

    public Alternative getCurrentOuterMostAlt() {
        return this.currentOuterMostAlt;
    }

    public CodeBlockForOuterMostAlt getCurrentOuterMostAlternativeBlock() {
        return this.currentOuterMostAlternativeBlock;
    }

    public RuleFunction getCurrentRuleFunction() {
        if (this.currentRule.isEmpty() == false) goto L5;
        return null;
    L5:
        return this.currentRule.peek();
    }

    public Choice getEBNFBlock(GrammarAST r5, List<CodeBlockForAlt> r10) {
        Choice r11 = this.delegate.getEBNFBlock(r5, r10);
        Iterator<CodeGeneratorExtension> r12 = this.extensions.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11 = r12.next().getEBNFBlock(r11);
        goto L4
    L6:
        return r11;
    }

    public CodeGenerator getGenerator() {
        return this.delegate.getGenerator();
    }

    public Grammar getGrammar() {
        return this.delegate.getGrammar();
    }

    public OutputModelObject getRoot() {
        return this.root;
    }

    public Lexer lexer(LexerFile r5) {
        return new Lexer(this.delegate, r5);
    }

    public LexerFile lexerFile(String r5) {
        return new LexerFile(this.delegate, r5);
    }

    public boolean needsImplicitLabel(GrammarAST r5, LabeledOp r10) {
        boolean r11 = this.delegate.needsImplicitLabel(r5, r10);
        Iterator<CodeGeneratorExtension> r12 = this.extensions.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11 = r11 | r12.next().needsImplicitLabel(r5, r10);
        goto L4
    L6:
        return r11;
    }

    public Parser parser(ParserFile r5) {
        Parser r10 = this.delegate.parser(r5);
        Iterator<CodeGeneratorExtension> r11 = this.extensions.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10 = r11.next().parser(r10);
        goto L4
    L6:
        return r10;
    }

    public ParserFile parserFile(String r5) {
        ParserFile r10 = this.delegate.parserFile(r5);
        Iterator<CodeGeneratorExtension> r11 = this.extensions.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10 = r11.next().parserFile(r10);
        goto L4
    L6:
        return r10;
    }

    public RuleFunction popCurrentRule() {
        if (this.currentRule.isEmpty() == false) goto L5;
        return null;
    L5:
        return this.currentRule.pop();
    }

    public void pushCurrentRule(RuleFunction r5) {
        this.currentRule.push(r5);
    }

    public RuleFunction rule(Rule r5) {
        RuleFunction r10 = this.delegate.rule(r5);
        Iterator<CodeGeneratorExtension> r11 = this.extensions.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10 = r11.next().rule(r10);
        goto L4
    L6:
        return r10;
    }

    public List<SrcOp> rulePostamble(RuleFunction r5, Rule r10) {
        List<SrcOp> r11 = this.delegate.rulePostamble(r5, r10);
        Iterator<CodeGeneratorExtension> r12 = this.extensions.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11 = r12.next().rulePostamble(r11);
        goto L4
    L6:
        return r11;
    }

    public List<SrcOp> ruleRef(GrammarAST r5, GrammarAST r10, GrammarAST r11) {
        List<SrcOp> r12 = this.delegate.ruleRef(r5, r10, r11);
        Iterator<CodeGeneratorExtension> r13 = this.extensions.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12 = r13.next().ruleRef(r12);
        goto L4
    L6:
        return r12;
    }

    public List<SrcOp> sempred(ActionAST r5) {
        List<SrcOp> r10 = this.delegate.sempred(r5);
        Iterator<CodeGeneratorExtension> r11 = this.extensions.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10 = r11.next().sempred(r10);
        goto L4
    L6:
        return r10;
    }

    public List<SrcOp> set(GrammarAST r5, GrammarAST r10, boolean r11) {
        List<SrcOp> r12 = this.delegate.set(r5, r10, r11);
        Iterator<CodeGeneratorExtension> r13 = this.extensions.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12 = r13.next().set(r12);
        goto L4
    L6:
        return r12;
    }

    public void setCurrentBlock(CodeBlock r5) {
        this.currentBlock = r5;
    }

    public void setCurrentOuterMostAlt(Alternative r5) {
        this.currentOuterMostAlt = r5;
    }

    public void setCurrentOuterMostAlternativeBlock(CodeBlockForOuterMostAlt r5) {
        this.currentOuterMostAlternativeBlock = r5;
    }

    public void setRoot(OutputModelObject r5) {
        this.root = r5;
    }

    public List<SrcOp> stringRef(GrammarAST r5, GrammarAST r10) {
        List<SrcOp> r11 = this.delegate.stringRef(r5, r10);
        Iterator<CodeGeneratorExtension> r12 = this.extensions.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11 = r12.next().stringRef(r11);
        goto L4
    L6:
        return r11;
    }

    public List<SrcOp> tokenRef(GrammarAST r5, GrammarAST r10, GrammarAST r11) {
        List<SrcOp> r12 = this.delegate.tokenRef(r5, r10, r11);
        Iterator<CodeGeneratorExtension> r13 = this.extensions.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12 = r13.next().tokenRef(r12);
        goto L4
    L6:
        return r12;
    }

    public List<SrcOp> wildcard(GrammarAST r5, GrammarAST r10) {
        List<SrcOp> r11 = this.delegate.wildcard(r5, r10);
        Iterator<CodeGeneratorExtension> r12 = this.extensions.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11 = r12.next().wildcard(r11);
        goto L4
    L6:
        return r11;
    }
}
