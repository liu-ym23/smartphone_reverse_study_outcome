package androidx.room.jarjarred.org.antlr.v4.codegen;

import androidx.room.jarjarred.org.antlr.v4.analysis.AnalysisPipeline;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Action;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.AddToLabelList;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.AltBlock;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Choice;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.CodeBlockForAlt;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.CodeBlockForOuterMostAlt;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.InvokeRule;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LL1AltBlock;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LL1OptionalBlock;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LL1OptionalBlockSingleAlt;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LL1PlusBlockSingleAlt;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LL1StarBlockSingleAlt;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LabeledOp;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.LeftRecursiveRuleFunction;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.MatchNotSet;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.MatchSet;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.MatchToken;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.OptionalBlock;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Parser;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.ParserFile;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.PlusBlock;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.RuleFunction;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.SemPred;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.SrcOp;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.StarBlock;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.TestSetInline;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.Wildcard;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.Decl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.RuleContextDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.TokenDecl;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.TokenListDecl;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.DecisionState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PlusLoopbackState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopEntryState;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.Alternative;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LeftRecursiveRule;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParserFactory extends DefaultOutputModelFactory {
    public ParserFactory(CodeGenerator r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> action(ActionAST r5) {
        return DefaultOutputModelFactory.list(new SrcOp[]{new Action(this, r5)});
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public CodeBlockForAlt alternative(Alternative r5, boolean r10) {
        if (r10 == false) goto L6;
        return new CodeBlockForOuterMostAlt(this, r5);
    L6:
        return new CodeBlockForAlt(this);
    }

    public void defineImplicitLabel(GrammarAST r5, LabeledOp r10) {
        if (r5.getType() != 98) goto L5;
    L11:
        Decl r11 = getTokenLabelDecl(this.gen.getTarget().getImplicitSetLabel(String.valueOf(r5.token.getTokenIndex())));
        ((TokenDecl) r11).isImplicit = true;
        Decl r12 = r11;
    L12:
        r10.getLabels().add(r12);
        getCurrentRuleFunction().addContextDecl(r5.getAltLabel(), r12);
        return;
    L5:
        if (r5.getType() == 100) goto L11;
        if (r5.getType() != 57) goto L10;
        Rule r13 = this.g.getRule(r5.getText());
        RuleContextDecl r14 = new RuleContextDecl(this, this.gen.getTarget().getImplicitRuleLabel(r5.getText()), this.gen.getTarget().getRuleFunctionContextStructName(r13));
        r14.isImplicit = true;
        r12 = r14;
        goto L12
    L10:
        Decl r15 = getTokenLabelDecl(this.gen.getTarget().getImplicitTokenLabel(r5.getText()));
        ((TokenDecl) r15).isImplicit = true;
        r12 = r15;
        goto L12
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public CodeBlockForAlt epsilon(Alternative r5, boolean r10) {
        return alternative(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public CodeBlockForAlt finishAlternative(CodeBlockForAlt r5, List<SrcOp> r10) {
        r5.ops = r10;
        return r5;
    }

    public AddToLabelList getAddToListOpIfListLabelPresent(LabeledOp r5, GrammarAST r10) {
        if (r10 != null) goto L4;
    L6:
        return null;
    L4:
        if (r10.parent.getType() != 46) goto L6;
        return new AddToLabelList(this, this.gen.getTarget().getListLabel(r10.getText()), r5.getLabels().get(0));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Choice getChoiceBlock(BlockAST r5, List<CodeBlockForAlt> r10, GrammarAST r11) {
        int r12 = ((DecisionState) r5.atnState).decision;
        Grammar r13 = this.g;
        if (r13.tool.force_atn == false) goto L5;
    L7:
        Choice r14 = getComplexChoiceBlock(r5, r10);
    L8:
        if (r11 == null) goto L12;
        String r15 = r11.getText();
        Decl r16 = getTokenLabelDecl(r15);
        r14.label = r16;
        getCurrentRuleFunction().addContextDecl(r11.getAltLabel(), r16);
        if (r11.parent.getType() != 46) goto L12;
        TokenListDecl r17 = new TokenListDecl(this, this.gen.getTarget().getListLabel(r15));
        getCurrentRuleFunction().addContextDecl(r11.getAltLabel(), r17);
    L12:
        return r14;
    L5:
        if (AnalysisPipeline.disjoint(r13.decisionLOOK.get(r12)) == false) goto L7;
        r14 = getLL1ChoiceBlock(r5, r10);
        goto L8
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Choice getComplexChoiceBlock(BlockAST r5, List<CodeBlockForAlt> r10) {
        return new AltBlock(this, r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Choice getComplexEBNFBlock(GrammarAST r5, List<CodeBlockForAlt> r10) {
        if (r5 == null) goto L4;
        int r11 = r5.getType();
    L6:
        if (r11 != 80) goto L8;
        Choice r12 = new StarBlock(this, r5, r10);
    L17:
        return r12;
    L8:
        if (r11 != 89) goto L10;
        r12 = new OptionalBlock(this, r5, r10);
        goto L17
    L10:
        if (r11 == 90) goto L12;
        return null;
    L12:
        r12 = new PlusBlock(this, r5, r10);
        goto L17
    L4:
        r11 = 0;
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Choice getEBNFBlock(GrammarAST r5, List<CodeBlockForAlt> r10) {
        if (this.g.tool.force_atn == true) goto L16;
        if (r5.getType() != 90) goto L8;
        int r11 = ((PlusLoopbackState) r5.atnState).decision;
    L12:
        if (AnalysisPipeline.disjoint(this.g.decisionLOOK.get(r11)) == false) goto L16;
        return getLL1EBNFBlock(r5, r10);
    L8:
        if (r5.getType() != 80) goto L10;
        r11 = ((StarLoopEntryState) r5.atnState).decision;
        goto L12
    L10:
        r11 = ((DecisionState) r5.atnState).decision;
    L16:
        return getComplexEBNFBlock(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Choice getLL1ChoiceBlock(BlockAST r5, List<CodeBlockForAlt> r10) {
        return new LL1AltBlock(this, r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Choice getLL1EBNFBlock(GrammarAST r5, List<CodeBlockForAlt> r10) {
        if (r5 == null) goto L4;
        int r11 = r5.getType();
    L6:
        if (r11 == 80) goto L22;
        if (r11 == 89) goto L18;
        if (r11 == 90) goto L13;
        return null;
    L13:
        if (r10.size() != 1) goto L28;
        Choice r12 = new LL1PlusBlockSingleAlt(this, r5, r10);
    L27:
        return r12;
    L28:
        return getComplexEBNFBlock(r5, r10);
    L18:
        if (r10.size() != 1) goto L20;
        r12 = new LL1OptionalBlockSingleAlt(this, r5, r10);
        goto L27
    L20:
        r12 = new LL1OptionalBlock(this, r5, r10);
        goto L27
    L22:
        if (r10.size() != 1) goto L25;
        r12 = new LL1StarBlockSingleAlt(this, r5, r10);
        goto L27
    L25:
        return getComplexEBNFBlock(r5, r10);
    L4:
        r11 = 0;
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> getLL1Test(IntervalSet r5, GrammarAST r10) {
        return DefaultOutputModelFactory.list(new SrcOp[]{new TestSetInline(this, r10, r5, this.gen.getTarget().getInlineTestSetWordSize())});
    }

    public Decl getTokenLabelDecl(String r5) {
        return new TokenDecl(this, r5);
    }

    public TokenListDecl getTokenListLabelDecl(String r5) {
        return new TokenListDecl(this, this.gen.getTarget().getListLabel(r5));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public boolean needsImplicitLabel(GrammarAST r5, LabeledOp r10) {
        Alternative r11 = getCurrentOuterMostAlt();
        boolean r12 = r11.tokenRefsInActions.containsKey(r5.getText());
        boolean r13 = r11.ruleRefsInActions.containsKey(r5.getText());
        if (r10.getLabels().isEmpty() == false) goto L7;
        if (r12 == true) goto L6;
        if (r13 == false) goto L7;
    L6:
        return true;
    L7:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public Parser parser(ParserFile r5) {
        return new Parser(this, r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public ParserFile parserFile(String r5) {
        return new ParserFile(this, r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public RuleFunction rule(Rule r5) {
        if ((r5 instanceof LeftRecursiveRule) == false) goto L7;
        return new LeftRecursiveRuleFunction(this, (LeftRecursiveRule) r5);
    L7:
        return new RuleFunction(this, r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> ruleRef(GrammarAST r5, GrammarAST r10, GrammarAST r11) {
        InvokeRule r12 = new InvokeRule(this, r5, r10);
        if (this.controller.needsImplicitLabel(r5, r12) == false) goto L6;
        defineImplicitLabel(r5, r12);
    L6:
        return DefaultOutputModelFactory.list(new SrcOp[]{r12, getAddToListOpIfListLabelPresent(r12, r10)});
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> sempred(ActionAST r5) {
        return DefaultOutputModelFactory.list(new SrcOp[]{new SemPred(this, r5)});
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> set(GrammarAST r5, GrammarAST r10, boolean r11) {
        if (r11 == false) goto L4;
        MatchToken r12 = new MatchNotSet(this, r5);
    L5:
        if (r10 == null) goto L11;
        String r13 = r10.getText();
        RuleFunction r14 = getCurrentRuleFunction();
        if (r10.parent.getType() != 46) goto L9;
        defineImplicitLabel(r5, r12);
        r14.addContextDecl(r5.getAltLabel(), getTokenListLabelDecl(r13));
        goto L11
    L9:
        Decl r15 = getTokenLabelDecl(r13);
        r12.labels.add(r15);
        r14.addContextDecl(r5.getAltLabel(), r15);
    L11:
        if (this.controller.needsImplicitLabel(r5, r12) == false) goto L14;
        defineImplicitLabel(r5, r12);
    L14:
        return DefaultOutputModelFactory.list(new SrcOp[]{r12, getAddToListOpIfListLabelPresent(r12, r10)});
    L4:
        r12 = new MatchSet(this, r5);
        goto L5
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> tokenRef(GrammarAST r5, GrammarAST r10, GrammarAST r11) {
        MatchToken r12 = new MatchToken(this, (TerminalAST) r5);
        if (r10 == null) goto L9;
        String r13 = r10.getText();
        RuleFunction r14 = getCurrentRuleFunction();
        if (r10.parent.getType() != 46) goto L7;
        defineImplicitLabel(r5, r12);
        r14.addContextDecl(r5.getAltLabel(), getTokenListLabelDecl(r13));
        goto L9
    L7:
        Decl r15 = getTokenLabelDecl(r13);
        r12.labels.add(r15);
        r14.addContextDecl(r5.getAltLabel(), r15);
    L9:
        if (this.controller.needsImplicitLabel(r5, r12) == false) goto L12;
        defineImplicitLabel(r5, r12);
    L12:
        return DefaultOutputModelFactory.list(new SrcOp[]{r12, getAddToListOpIfListLabelPresent(r12, r10)});
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.codegen.BlankOutputModelFactory, androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory
    public List<SrcOp> wildcard(GrammarAST r10, GrammarAST r11) {
        Wildcard r5 = new Wildcard(this, r10);
        if (r11 == null) goto L8;
        String r12 = r11.getText();
        Decl r13 = getTokenLabelDecl(r12);
        r5.labels.add(r13);
        getCurrentRuleFunction().addContextDecl(r10.getAltLabel(), r13);
        if (r11.parent.getType() != 46) goto L8;
        getCurrentRuleFunction().addContextDecl(r10.getAltLabel(), getTokenListLabelDecl(r12));
    L8:
        if (this.controller.needsImplicitLabel(r10, r5) == false) goto L11;
        defineImplicitLabel(r10, r5);
    L11:
        return DefaultOutputModelFactory.list(new SrcOp[]{r5, getAddToListOpIfListLabelPresent(r5, r11)});
    }
}
