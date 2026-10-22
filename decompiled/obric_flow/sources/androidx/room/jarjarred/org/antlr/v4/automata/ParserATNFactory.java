package androidx.room.jarjarred.org.antlr.v4.automata;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeNodeStream;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import androidx.room.jarjarred.org.antlr.v4.misc.CharSupport;
import androidx.room.jarjarred.org.antlr.v4.parse.ATNBuilder;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarASTAdaptor;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNType;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ActionTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.AtomTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.BasicBlockStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.BasicState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.BlockEndState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.BlockStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.EpsilonTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LL1Analyzer;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LoopEndState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.NotSetTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PlusBlockStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PlusLoopbackState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PrecedencePredicateTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredicateTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleStopState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.SetTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarBlockStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopEntryState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopbackState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.WildcardTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Triple;
import androidx.room.jarjarred.org.antlr.v4.semantics.UseDefAnalyzer;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorManager;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.LeftRecursiveRule;
import androidx.room.jarjarred.org.antlr.v4.tool.LexerGrammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.PredAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.QuantifierAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParserATNFactory implements ATNFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final ATN atn;
    public int currentOuterAlt;
    public Rule currentRule;
    public final Grammar g;
    protected final List<Triple<Rule, ATNState, ATNState>> preventEpsilonClosureBlocks;
    protected final List<Triple<Rule, ATNState, ATNState>> preventEpsilonOptionalBlocks;

    public ParserATNFactory(Grammar r5) {
        this.preventEpsilonClosureBlocks = new ArrayList();
        this.preventEpsilonOptionalBlocks = new ArrayList();
        if (r5 == null) goto L11;
        this.g = r5;
        if ((r5 instanceof LexerGrammar) == false) goto L7;
        ATNType r10 = ATNType.LEXER;
    L8:
        this.atn = new ATN(r10, r5.getMaxTokenType());
        return;
    L7:
        r10 = ATNType.PARSER;
        goto L8
    L11:
        throw new NullPointerException("g");
    }

    public static boolean blockHasWildcardAlt(GrammarAST r5) {
        Iterator<? extends Object> r10 = r5.getChildren().iterator();
    L4:
        if (r10.hasNext() == false) goto L17;
        Object r11 = r10.next();
        if ((r11 instanceof AltAST) == false) goto L4;
        AltAST r12 = (AltAST) r11;
        if (r12.getChildCount() == 1) goto L15;
        if (r12.getChildCount() != 2) goto L4;
        if (r12.getChild(0).getType() != 82) goto L4;
    L15:
        if (r12.getChild(r12.getChildCount() - 1).getType() != 100) goto L4;
        return true;
    L17:
        return false;
    }

    public void _createATN(Collection<Rule> r5) {
        createRuleStartAndStopATNStates();
        GrammarASTAdaptor r10 = new GrammarASTAdaptor();
        Iterator<Rule> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Rule r12 = r11.next();
        ATNBuilder r13 = new ATNBuilder(new CommonTreeNodeStream(r10, (GrammarAST) r12.ast.getFirstChildWithType(78)), this);
        setCurrentRuleName(r12.name);     // Catch: RecognitionException -> L8
        ATNFactory.Handle r14 = r13.ruleBlock(null);     // Catch: RecognitionException -> L8
        rule(r12.ast, r12.name, r14);     // Catch: RecognitionException -> L8
    L8:
        e = move-exception;
        ErrorManager.fatalInternalError("bad grammar AST structure", e);
        goto L4
    }

    public ATNFactory.Handle _ruleRef(GrammarAST r10) {
        Rule r5 = this.g.getRule(r10.getText());
        if (r5 != null) goto L6;
        Grammar r11 = this.g;
        r11.tool.errMgr.grammarError(ErrorType.INTERNAL_ERROR, r11.fileName, r10.getToken(), new Object[]{"Rule " + r10.getText() + " undefined"});
        return null;
    L6:
        RuleStartState r12 = this.atn.ruleToStartState[r5.index];
        ATNState r13 = newState(r10);
        ATNState r14 = newState(r10);
        GrammarASTWithOptions r15 = (GrammarASTWithOptions) r10;
        if (r15.getOptionString(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME) == null) goto L9;
        int r16 = Integer.parseInt(r15.getOptionString(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME));
    L10:
        r13.addTransition(new RuleTransition(r12, r5.index, r16, r14));
        r10.atnState = r13;
        return new ATNFactory.Handle(r13, r14);
    L9:
        r16 = 0;
        goto L10
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle action(ActionAST r5) {
        ATNState r10 = newState(r5);
        ATNState r11 = newState(r5);
        r10.addTransition(new ActionTransition(r11, this.currentRule.index));
        r5.atnState = r10;
        return new ATNFactory.Handle(r10, r11);
    }

    public int addEOFTransitionToStartRules() {
        ATNState r5 = newState(null);
        Iterator<Rule> r10 = this.g.rules.values().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L9;
        Rule r12 = r10.next();
        RuleStopState r13 = this.atn.ruleToStopState[r12.index];
        if (r13.getNumberOfTransitions() > 0) goto L4;
        r11 = r11 + 1;
        r13.addTransition(new AtomTransition(r5, -1));
        goto L4
    L9:
        return r11;
    }

    public void addFollowLink(int r5, ATNState r10) {
        epsilon(this.atn.ruleToStopState[r5], r10);
    }

    public void addRuleFollowLinks() {
        Iterator<ATNState> r5 = this.atn.states.iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        ATNState r10 = r5.next();
        if (r10 == null) goto L4;
        if (r10.getStateType() != 1) goto L4;
        if (r10.getNumberOfTransitions() != 1) goto L4;
        if ((r10.transition(0) instanceof RuleTransition) == false) goto L4;
        RuleTransition r11 = (RuleTransition) r10.transition(0);
        addFollowLink(r11.ruleIndex, r11.followState);
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle alt(List<ATNFactory.Handle> r5) {
        return elemList(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle block(BlockAST r5, GrammarAST r10, List<ATNFactory.Handle> r11) {
        if (r10 == null) goto L5;
        int r12 = r10.getType();
        if (r12 != 80) goto L16;
        BlockStartState r13 = (BlockStartState) newState(StarBlockStartState.class, r10);
        if (r11.size() <= 1) goto L32;
        this.atn.defineDecisionState(r13);
    L32:
        return star(r10, makeBlock(r13, r5, r11));
    L16:
        if (r12 != 89) goto L18;
        BlockStartState r14 = (BlockStartState) newState(BasicBlockStartState.class, r5);
        this.atn.defineDecisionState(r14);
        return optional(r10, makeBlock(r14, r5, r11));
    L18:
        if (r12 == 90) goto L21;
        return null;
    L21:
        PlusBlockStartState r15 = (PlusBlockStartState) newState(PlusBlockStartState.class, r10);
        if (r11.size() <= 1) goto L25;
        this.atn.defineDecisionState(r15);
    L25:
        return plus(r10, makeBlock(r15, r5, r11));
    L5:
        if (r11.size() != 1) goto L8;
        ATNFactory.Handle r16 = r11.get(0);
        r5.atnState = r16.left;
        return r16;
    L8:
        BlockStartState r17 = (BlockStartState) newState(BasicBlockStartState.class, r5);
        if (r11.size() <= 1) goto L12;
        this.atn.defineDecisionState(r17);
    L12:
        return makeBlock(r17, r5, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle charSetLiteral(GrammarAST r5) {
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATN createATN() {
        _createATN(this.g.rules.values());
        addRuleFollowLinks();
        addEOFTransitionToStartRules();
        ATNOptimizer.optimize(this.g, this.atn);
        Iterator<Triple<Rule, ATNState, ATNState>> r5 = this.preventEpsilonClosureBlocks.iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Triple<Rule, ATNState, ATNState> r10 = r5.next();
        if (new LL1Analyzer(this.atn).LOOK(r10.f670b, r10.f671c, null).contains(-2) == false) goto L4;
        Rule r11 = r10.f669a;
        if ((r11 instanceof LeftRecursiveRule) == false) goto L10;
        ErrorType r12 = ErrorType.EPSILON_LR_FOLLOW;
    L11:
        Grammar r13 = this.g;
        r13.tool.errMgr.grammarError(r12, r13.fileName, ((GrammarAST) r11.ast.getChild(0)).getToken(), new Object[]{r10.f669a.name});
        goto L4
    L10:
        r12 = ErrorType.EPSILON_CLOSURE;
        goto L11
    L12:
        Iterator<Triple<Rule, ATNState, ATNState>> r14 = this.preventEpsilonOptionalBlocks.iterator();
    L14:
        if (r14.hasNext() == false) goto L31;
        Triple<Rule, ATNState, ATNState> r15 = r14.next();
        int r16 = 0;
        int r17 = 0;
    L17:
        if (r16 >= r15.f670b.getNumberOfTransitions()) goto L26;
        ATNState r18 = r15.f670b.transition(r16).target;
        if (r18 != r15.f671c) goto L22;
        r17 = r17 + 1;
    L24:
        r16 = r16 + 1;
        goto L17
    L22:
        if (new LL1Analyzer(this.atn).LOOK(r18, r15.f671c, null).contains(-2) == false) goto L24;
        Grammar r19 = this.g;
        r19.tool.errMgr.grammarError(ErrorType.EPSILON_OPTIONAL, r19.fileName, ((GrammarAST) r15.f669a.ast.getChild(0)).getToken(), new Object[]{r15.f669a.name});
        goto L14
    L26:
        if (r17 == 1) goto L14;
        throw new UnsupportedOperationException("Expected optional block with exactly 1 bypass alternative.");
    L31:
        return this.atn;
    }

    public void createRuleStartAndStopATNStates() {
        ATN r5 = this.atn;
        r5.ruleToStartState = new RuleStartState[this.g.rules.size()];
        ATN r10 = this.atn;
        r10.ruleToStopState = new RuleStopState[this.g.rules.size()];
        Iterator<Rule> r11 = this.g.rules.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Rule r12 = r11.next();
        RuleStartState r13 = (RuleStartState) newState(RuleStartState.class, r12.ast);
        RuleStopState r14 = (RuleStopState) newState(RuleStopState.class, r12.ast);
        r13.stopState = r14;
        r13.isLeftRecursiveRule = r12 instanceof LeftRecursiveRule;
        r13.setRuleIndex(r12.index);
        r14.setRuleIndex(r12.index);
        ATN r15 = this.atn;
        RuleStartState[] r16 = r15.ruleToStartState;
        int r17 = r12.index;
        r16[r17] = r13;
        r15.ruleToStopState[r17] = r14;
        goto L4
    }

    public ATNFactory.Handle elemList(List<ATNFactory.Handle> r10) {
        int r5 = r10.size();
        int r11 = 0;
    L3:
        int r12 = r5 - 1;
        if (r11 >= r12) goto L25;
        ATNFactory.Handle r13 = r10.get(r11);
        if (r13.left.getNumberOfTransitions() != 1) goto L8;
        Transition r14 = r13.left.transition(0);
    L9:
        boolean r15 = r14 instanceof RuleTransition;
        if (r13.left.getStateType() == 1) goto L12;
    L23:
        epsilon(r13.right, r10.get(r11 + 1).left);
    L24:
        r11 = r11 + 1;
        goto L3
    L12:
        if (r13.right.getStateType() != 1) goto L23;
        if (r14 == null) goto L23;
        if (r15 == false) goto L18;
        if (((RuleTransition) r14).followState != r13.right) goto L18;
    L19:
        if (r15 == false) goto L21;
        ((RuleTransition) r14).followState = r10.get(r11 + 1).left;
    L22:
        this.atn.removeState(r13.right);
        goto L24
    L21:
        r14.target = r10.get(r11 + 1).left;
    L18:
        if (r14.target != r13.right) goto L23;
    L8:
        r14 = null;
        goto L9
    L25:
        ATNFactory.Handle r16 = r10.get(0);
        ATNFactory.Handle r17 = r10.get(r12);
        if (r16 == null) goto L28;
        if (r17 == null) goto L28;
    L30:
        return new ATNFactory.Handle(r16.left, r17.right);
    L28:
        this.g.tool.errMgr.toolError(ErrorType.INTERNAL_ERROR, new Object[]{"element list has first|last == null"});
        goto L30
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle epsilon(GrammarAST r5) {
        ATNState r10 = newState(r5);
        ATNState r11 = newState(r5);
        epsilon(r10, r11);
        r5.atnState = r10;
        return new ATNFactory.Handle(r10, r11);
    }

    public boolean expectNonGreedy(BlockAST r5) {
        if (blockHasWildcardAlt(r5) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public int getTokenType(GrammarAST r5) {
        if (this.g.isLexer() == false) goto L6;
        return CharSupport.getCharValueFromGrammarCharLiteral(r5.getText());
    L6:
        return this.g.getTokenType(r5.getText());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle label(ATNFactory.Handle r5) {
        return r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle lexerAltCommands(ATNFactory.Handle r5, ATNFactory.Handle r10) {
        throw new UnsupportedOperationException("This element is not allowed in parsers.");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle lexerCallCommand(GrammarAST r5, GrammarAST r10) {
        throw new UnsupportedOperationException("This element is not allowed in parsers.");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle lexerCommand(GrammarAST r5) {
        throw new UnsupportedOperationException("This element is not allowed in parsers.");
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle listLabel(ATNFactory.Handle r5) {
        return r5;
    }

    public ATNFactory.Handle makeBlock(BlockStartState r5, BlockAST r10, List<ATNFactory.Handle> r11) {
        BlockEndState r12 = (BlockEndState) newState(BlockEndState.class, r10);
        r5.endState = r12;
        Iterator<ATNFactory.Handle> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ATNFactory.Handle r14 = r13.next();
        epsilon(r5, r14.left);
        epsilon(r14.right, r12);
        new TailEpsilonRemover(this.atn).visit(r14.left);
        goto L4
    L6:
        ATNFactory.Handle r15 = new ATNFactory.Handle(r5, r12);
        r10.atnState = r5;
        return r15;
    }

    public <T extends ATNState> T newState(Class<T> r5, GrammarAST r10) {
        T r11 = r5.getConstructor(null).newInstance(null);     // Catch: Throwable -> L6
        Rule r12 = this.currentRule;     // Catch: Throwable -> L6
        if (r12 != null) goto L8;
        r11.setRuleIndex(-1);     // Catch: Throwable -> L6
    L9:
        this.atn.addState(r11);     // Catch: Throwable -> L6
        return r11;
    L8:
        r11.setRuleIndex(r12.index);     // Catch: Throwable -> L6
    L6:
        e = move-exception;
        throw new UnsupportedOperationException(j0.l("Could not create ", ATNState.class.getName(), " of type ", r5.getName(), "."), e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle optional(GrammarAST r10, ATNFactory.Handle r11) {
        BlockStartState r5 = (BlockStartState) r11.left;
        this.preventEpsilonOptionalBlocks.add(new Triple(this.currentRule, r5, r11.right));
        boolean r12 = ((QuantifierAST) r10).isGreedy();
        r5.nonGreedy = !r12;
        epsilon(r5, r11.right, !r12);
        r10.atnState = r11.left;
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle plus(GrammarAST r10, ATNFactory.Handle r11) {
        PlusBlockStartState r5 = (PlusBlockStartState) r11.left;
        ATNState r12 = (BlockEndState) r11.right;
        this.preventEpsilonClosureBlocks.add(new Triple(this.currentRule, r5, r12));
        PlusLoopbackState r13 = (PlusLoopbackState) newState(PlusLoopbackState.class, r10);
        r13.nonGreedy = !((QuantifierAST) r10).isGreedy();
        this.atn.defineDecisionState(r13);
        LoopEndState r14 = (LoopEndState) newState(LoopEndState.class, r10);
        r5.loopBackState = r13;
        r14.loopBackState = r13;
        r10.atnState = r13;
        epsilon(r12, r13);
        BlockAST r15 = (BlockAST) r10.getChild(0);
        if (((QuantifierAST) r10).isGreedy() == true) goto L5;
        epsilon(r13, r14);
        epsilon(r13, r5);
    L10:
        return new ATNFactory.Handle(r5, r14);
    L5:
        if (expectNonGreedy(r15) == false) goto L7;
        Grammar r16 = this.g;
        r16.tool.errMgr.grammarError(ErrorType.EXPECTED_NON_GREEDY_WILDCARD_BLOCK, r16.fileName, r10.getToken(), new Object[]{r10.getToken().getText()});
    L7:
        epsilon(r13, r5);
        epsilon(r13, r14);
        goto L10
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle range(GrammarAST r10, GrammarAST r11) {
        Grammar r5 = this.g;
        r5.tool.errMgr.grammarError(ErrorType.TOKEN_RANGE_IN_PARSER, r5.fileName, r10.getToken(), new Object[]{r10.getToken().getText(), r11.getToken().getText()});
        return tokenRef((TerminalAST) r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle rule(GrammarAST r5, String r10, ATNFactory.Handle r11) {
        Rule r12 = this.g.getRule(r10);
        RuleStartState r13 = this.atn.ruleToStartState[r12.index];
        epsilon(r13, r11.left);
        RuleStopState r14 = this.atn.ruleToStopState[r12.index];
        epsilon(r11.right, r14);
        ATNFactory.Handle r15 = new ATNFactory.Handle(r13, r14);
        r5.atnState = r13;
        return r15;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle ruleRef(GrammarAST r5) {
        return _ruleRef(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle sempred(PredAST r10) {
        ATNState r5 = newState(r10);
        ATNState r11 = newState(r10);
        if (r10.getOptionString(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME) == null) goto L5;
        Transition r12 = new PrecedencePredicateTransition(r11, Integer.parseInt(r10.getOptionString(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME)));
    L6:
        r5.addTransition(r12);
        r10.atnState = r5;
        return new ATNFactory.Handle(r5, r11);
    L5:
        boolean r13 = UseDefAnalyzer.actionIsContextDependent(r10);
        r12 = new PredicateTransition(r11, this.currentRule.index, this.g.sempreds.get(r10).intValue(), r13);
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle set(GrammarAST r10, List<GrammarAST> r11, boolean r12) {
        ATNState r5 = newState(r10);
        ATNState r13 = newState(r10);
        IntervalSet r14 = new IntervalSet(new int[0]);
        Iterator<GrammarAST> r15 = r11.iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        GrammarAST r16 = r15.next();
        r14.add(this.g.getTokenType(r16.getText()));
        goto L4
    L6:
        if (r12 == false) goto L8;
        r5.addTransition(new NotSetTransition(r13, r14));
    L9:
        r10.atnState = r5;
        return new ATNFactory.Handle(r5, r13);
    L8:
        r5.addTransition(new SetTransition(r13, r14));
        goto L9
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public void setCurrentOuterAlt(int r5) {
        this.currentOuterAlt = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public void setCurrentRuleName(String r5) {
        this.currentRule = this.g.getRule(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle star(GrammarAST r10, ATNFactory.Handle r11) {
        ATNState r5 = (StarBlockStartState) r11.left;
        ATNState r12 = (BlockEndState) r11.right;
        this.preventEpsilonClosureBlocks.add(new Triple(this.currentRule, r5, r12));
        StarLoopEntryState r13 = (StarLoopEntryState) newState(StarLoopEntryState.class, r10);
        r13.nonGreedy = !((QuantifierAST) r10).isGreedy();
        this.atn.defineDecisionState(r13);
        LoopEndState r14 = (LoopEndState) newState(LoopEndState.class, r10);
        StarLoopbackState r15 = (StarLoopbackState) newState(StarLoopbackState.class, r10);
        r13.loopBackState = r15;
        r14.loopBackState = r15;
        BlockAST r16 = (BlockAST) r10.getChild(0);
        if (((QuantifierAST) r10).isGreedy() == true) goto L5;
        epsilon(r13, r14);
        epsilon(r13, r5);
    L9:
        epsilon(r12, r15);
        epsilon(r15, r13);
        r10.atnState = r13;
        return new ATNFactory.Handle(r13, r14);
    L5:
        if (expectNonGreedy(r16) == false) goto L7;
        Grammar r17 = this.g;
        r17.tool.errMgr.grammarError(ErrorType.EXPECTED_NON_GREEDY_WILDCARD_BLOCK, r17.fileName, r10.getToken(), new Object[]{r10.getToken().getText()});
    L7:
        epsilon(r13, r5);
        epsilon(r13, r14);
        goto L9
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle stringLiteral(TerminalAST r5) {
        return tokenRef(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle tokenRef(TerminalAST r5) {
        ATNState r10 = newState(r5);
        ATNState r11 = newState(r5);
        r10.addTransition(new AtomTransition(r11, this.g.getTokenType(r5.getText())));
        r5.atnState = r10;
        return new ATNFactory.Handle(r10, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle wildcard(GrammarAST r5) {
        ATNState r10 = newState(r5);
        ATNState r11 = newState(r5);
        r10.addTransition(new WildcardTransition(r11));
        r5.atnState = r10;
        return new ATNFactory.Handle(r10, r11);
    }

    public void epsilon(ATNState r5, ATNState r10) {
        epsilon(r5, r10, false);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNFactory.Handle action(String r5) {
        throw new UnsupportedOperationException("This element is not valid in parsers.");
    }

    public void epsilon(ATNState r5, ATNState r10, boolean r11) {
        if (r5 == null) goto L8;
        if (r11 == false) goto L5;
        int r12 = 0;
    L6:
        r5.addTransition(r12, new EpsilonTransition(r10));
        return;
    L5:
        r12 = r5.getNumberOfTransitions();
        goto L6
    }

    public ATNState newState(GrammarAST r5) {
        BasicState r10 = new BasicState();
        r10.setRuleIndex(this.currentRule.index);
        this.atn.addState(r10);
        return r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNFactory
    public ATNState newState() {
        return newState(null);
    }
}
