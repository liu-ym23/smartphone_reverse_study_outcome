package androidx.room.jarjarred.org.antlr.v4.runtime;

import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ActionTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.AtomTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.DecisionState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.LoopEndState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParserATNSimulator;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PrecedencePredicateTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredicateTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PredictionContextCache;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleStartState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopEntryState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
public class ParserInterpreter extends Parser {
    protected final Deque<Pair<ParserRuleContext, Integer>> _parentContextStack;
    protected final ATN atn;
    protected final DFA[] decisionToDFA;
    protected final String grammarFileName;
    protected int overrideDecision;
    protected int overrideDecisionAlt;
    protected int overrideDecisionInputIndex;
    protected boolean overrideDecisionReached;
    protected InterpreterRuleContext overrideDecisionRoot;
    protected InterpreterRuleContext rootContext;
    protected final String[] ruleNames;
    protected final PredictionContextCache sharedContextCache;

    @Deprecated
    protected final String[] tokenNames;
    private final Vocabulary vocabulary;

    @Deprecated
    public ParserInterpreter(String r10, Collection<String> r11, Collection<String> r12, ATN r13, TokenStream r14) {
        this(r10, VocabularyImpl.fromTokenNames((String[]) r11.toArray(new String[r11.size()])), r12, r13, r14);
    }

    public void addDecisionOverride(int r5, int r10, int r11) {
        this.overrideDecision = r5;
        this.overrideDecisionInputIndex = r10;
        this.overrideDecisionAlt = r11;
    }

    public InterpreterRuleContext createInterpreterRuleContext(ParserRuleContext r5, int r10, int r11) {
        return new InterpreterRuleContext(r5, r10, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Parser
    public void enterRecursionRule(ParserRuleContext r5, int r10, int r11, int r12) {
        Pair<ParserRuleContext, Integer> r13 = new Pair(this._ctx, Integer.valueOf(r5.invokingState));
        this._parentContextStack.push(r13);
        super.enterRecursionRule(r5, r10, r11, r12);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public ATN getATN() {
        return this.atn;
    }

    public ATNState getATNState() {
        return this.atn.states.get(getState());
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public String getGrammarFileName() {
        return this.grammarFileName;
    }

    public InterpreterRuleContext getOverrideDecisionRoot() {
        return this.overrideDecisionRoot;
    }

    public InterpreterRuleContext getRootContext() {
        return this.rootContext;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public String[] getRuleNames() {
        return this.ruleNames;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    @Deprecated
    public String[] getTokenNames() {
        return this.tokenNames;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Recognizer
    public Vocabulary getVocabulary() {
        return this.vocabulary;
    }

    public ParserRuleContext parse(int r5) {
        RuleStartState r10 = this.atn.ruleToStartState[r5];
        InterpreterRuleContext r11 = createInterpreterRuleContext(null, -1, r5);
        this.rootContext = r11;
        if (r10.isLeftRecursiveRule == false) goto L5;
        enterRecursionRule(r11, r10.stateNumber, r5, 0);
    L6:
        ATNState r12 = getATNState();
        if (r12.getStateType() == 7) goto L13;
        visitState(r12);     // Catch: RecognitionException -> L10
    L10:
        e = move-exception;
        setState(this.atn.ruleToStopState[r12.ruleIndex].stateNumber);
        getContext().exception = e;
        getErrorHandler().reportError(this, e);
        recover(e);
        goto L6
    L13:
        if (this._ctx.isEmpty() == true) goto L15;
        visitRuleStopState(r12);
        goto L6
    L15:
        if (r10.isLeftRecursiveRule == false) goto L18;
        ParserRuleContext r13 = this._ctx;
        unrollRecursionContexts(this._parentContextStack.pop().f667a);
        return r13;
    L18:
        exitRule();
        return this.rootContext;
    L5:
        enterRule(r11, r10.stateNumber, r5);
        goto L6
    }

    public void recover(RecognitionException r11) {
        int r5 = this._input.index();
        getErrorHandler().recover(this, r11);
        if (this._input.index() == r5) goto L5;
        return;
    L5:
        if ((r11 instanceof InputMismatchException) == false) goto L12;
        InputMismatchException r10 = (InputMismatchException) r11;
        Token r12 = r11.getOffendingToken();
        if (r10.getExpectedTokens().isNil() == true) goto L10;
        int r13 = r10.getExpectedTokens().getMinElement();
    L9:
        int r14 = r13;
        Token r15 = getTokenFactory().create(new Pair(r12.getTokenSource(), r12.getTokenSource().getInputStream()), r14, r12.getText(), 0, -1, -1, r12.getLine(), r12.getCharPositionInLine());
        ParserRuleContext r16 = this._ctx;
        r16.addErrorNode(createErrorNode(r16, r15));
        return;
    L10:
        r13 = 0;
        goto L9
    L12:
        Token r17 = r11.getOffendingToken();
        Token r18 = getTokenFactory().create(new Pair(r17.getTokenSource(), r17.getTokenSource().getInputStream()), 0, r17.getText(), 0, -1, -1, r17.getLine(), r17.getCharPositionInLine());
        ParserRuleContext r19 = this._ctx;
        r19.addErrorNode(createErrorNode(r19, r18));
    }

    public Token recoverInline() {
        return this._errHandler.recoverInline(this);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.Parser
    public void reset() {
        super.reset();
        this.overrideDecisionReached = false;
        this.overrideDecisionRoot = null;
    }

    public int visitDecisionState(DecisionState r5) {
        if (r5.getNumberOfTransitions() <= 1) goto L13;
        getErrorHandler().sync(this);
        int r10 = r5.decision;
        if (r10 != this.overrideDecision) goto L12;
        if (this._input.index() != this.overrideDecisionInputIndex) goto L12;
        if (this.overrideDecisionReached == true) goto L12;
        int r11 = this.overrideDecisionAlt;
        this.overrideDecisionReached = true;
        return r11;
    L12:
        return getInterpreter().adaptivePredict(this._input, r10, this._ctx);
    L13:
        return 1;
    }

    public void visitRuleStopState(ATNState r5) {
        if (this.atn.ruleToStartState[r5.ruleIndex].isLeftRecursiveRule == false) goto L5;
        Pair<ParserRuleContext, Integer> r10 = this._parentContextStack.pop();
        unrollRecursionContexts(r10.f667a);
        setState(r10.f668b.intValue());
    L6:
        setState(((RuleTransition) this.atn.states.get(getState()).transition(0)).followState.stateNumber);
        return;
    L5:
        exitRule();
        goto L6
    }

    public void visitState(ATNState r5) {
        if ((r5 instanceof DecisionState) == false) goto L5;
        int r10 = visitDecisionState((DecisionState) r5);
    L6:
        Transition r11 = r5.transition(r10 - 1);
        switch(r11.getSerializationType()) {
            case 1: goto L32;
            case 2: goto L28;
            case 3: goto L23;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L28;
            case 8: goto L28;
            case 9: goto L15;
            case 10: goto L10;
            default: goto L9;
        };
    L10:
        PrecedencePredicateTransition r12 = (PrecedencePredicateTransition) r11;
        if (precpred(this._ctx, r12.precedence) == false) goto L14;
    L38:
        setState(r11.target.stateNumber);
        return;
    L14:
        throw new FailedPredicateException(this, String.format("precpred(_ctx, %d)", new Object[]{Integer.valueOf(r12.precedence)}));
    L15:
        matchWildcard();
        goto L38
    L16:
        ActionTransition r13 = (ActionTransition) r11;
        action(this._ctx, r13.ruleIndex, r13.actionIndex);
        goto L38
    L17:
        match(((AtomTransition) r11).label);
        goto L38
    L18:
        PredicateTransition r14 = (PredicateTransition) r11;
        if (sempred(this._ctx, r14.ruleIndex, r14.predIndex) == true) goto L38;
        throw new FailedPredicateException(this);
    L23:
        RuleStartState r15 = (RuleStartState) r11.target;
        int r16 = r15.ruleIndex;
        InterpreterRuleContext r17 = createInterpreterRuleContext(this._ctx, r5.stateNumber, r16);
        if (r15.isLeftRecursiveRule == false) goto L26;
        enterRecursionRule(r17, r15.stateNumber, r16, ((RuleTransition) r11).precedence);
        goto L38
    L26:
        enterRule(r17, r11.target.stateNumber, r16);
        goto L38
    L9:
        throw new UnsupportedOperationException("Unrecognized ATN transition type.");
    L28:
        if (r11.matches(this._input.LA(1), 1, 65535) == true) goto L30;
        recoverInline();
    L30:
        matchWildcard();
        goto L38
    L32:
        if (r5.getStateType() != 10) goto L38;
        if (((StarLoopEntryState) r5).isPrecedenceDecision == false) goto L38;
        if ((r11.target instanceof LoopEndState) == true) goto L38;
        pushNewRecursionContext(createInterpreterRuleContext(this._parentContextStack.peek().f667a, this._parentContextStack.peek().f668b.intValue(), this._ctx.getRuleIndex()), this.atn.ruleToStartState[r5.ruleIndex].stateNumber, this._ctx.getRuleIndex());
        goto L38
    L5:
        r10 = 1;
        goto L6
    }

    public ParserInterpreter(String r5, Vocabulary r10, Collection<String> r11, ATN r12, TokenStream r13) {
        super(r13);
        this.sharedContextCache = new PredictionContextCache();
        this._parentContextStack = new ArrayDeque();
        this.overrideDecision = -1;
        this.overrideDecisionInputIndex = -1;
        this.overrideDecisionAlt = -1;
        int r14 = 0;
        this.overrideDecisionReached = false;
        this.overrideDecisionRoot = null;
        this.grammarFileName = r5;
        this.atn = r12;
        this.tokenNames = new String[r12.maxTokenType];
        int r15 = 0;
    L3:
        String[] r16 = this.tokenNames;
        if (r15 >= r16.length) goto L6;
        r16[r15] = r10.getDisplayName(r15);
        r15 = r15 + 1;
        goto L3
    L6:
        this.ruleNames = (String[]) r11.toArray(new String[r11.size()]);
        this.vocabulary = r10;
        int r17 = r12.getNumberOfDecisions();
        this.decisionToDFA = new DFA[r17];
    L7:
        if (r14 >= r17) goto L9;
        this.decisionToDFA[r14] = new DFA(r12.getDecisionState(r14), r14);
        r14 = r14 + 1;
        goto L7
    L9:
        setInterpreter(new ParserATNSimulator(this, r12, this.decisionToDFA, this.sharedContextCache));
    }
}
