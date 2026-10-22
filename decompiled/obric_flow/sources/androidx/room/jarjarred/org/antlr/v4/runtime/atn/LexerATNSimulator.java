package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.Lexer;
import androidx.room.jarjarred.org.antlr.v4.runtime.LexerNoViableAltException;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFAState;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LexerATNSimulator extends ATNSimulator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_DFA_EDGE = 127;
    public static final int MIN_DFA_EDGE = 0;
    public static final boolean debug = false;
    public static final boolean dfa_debug = false;
    public static int match_calls;
    protected int charPositionInLine;
    public final DFA[] decisionToDFA;
    protected int line;
    protected int mode;
    protected final SimState prevAccept;
    protected final Lexer recog;
    protected int startIndex;

    public static class SimState {
        protected int charPos;
        protected DFAState dfaState;
        protected int index;
        protected int line;

        public SimState() {
            this.index = -1;
            this.line = 0;
            this.charPos = -1;
        }

        public void reset() {
            this.index = -1;
            this.line = 0;
            this.charPos = -1;
            this.dfaState = null;
        }
    }

    public LexerATNSimulator(ATN r5, DFA[] r10, PredictionContextCache r11) {
        this(null, r5, r10, r11);
    }

    public void accept(CharStream r5, LexerActionExecutor r10, int r11, int r12, int r13, int r14) {
        r5.seek(r12);
        this.line = r13;
        this.charPositionInLine = r14;
        if (r10 == null) goto L8;
        Lexer r15 = this.recog;
        if (r15 == null) goto L9;
        r10.execute(r15, r5, r11);
        return;
    L9:
        return;
    }

    public DFAState addDFAEdge(DFAState r5, int r10, ATNConfigSet r11) {
        boolean r12 = r11.hasSemanticContext;
        r11.hasSemanticContext = false;
        DFAState r13 = addDFAState(r11);
        if (r12 == false) goto L5;
        return r13;
    L5:
        addDFAEdge(r5, r10, r13);
        return r13;
    }

    public DFAState addDFAState(ATNConfigSet r5) {
        DFAState r10 = new DFAState(r5);
        Iterator<ATNConfig> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ATNConfig r12 = r11.next();
        if ((r12.state instanceof RuleStopState) == false) goto L4;
    L10:
        if (r12 == null) goto L12;
        r10.isAcceptState = true;
        r10.lexerActionExecutor = ((LexerATNConfig) r12).getLexerActionExecutor();
        r10.prediction = this.atn.ruleToTokenType[r12.state.ruleIndex];
    L12:
        DFA r13 = this.decisionToDFA[this.mode];
        Map<DFAState, DFAState> r14 = r13.states;
        monitor-enter(r14);
        DFAState r15 = r13.states.get(r10);     // Catch: Throwable -> L18
        if (r15 == null) goto L20;
        monitor-exit(r14);     // Catch: Throwable -> L18
        return r15;
    L20:
        r10.stateNumber = r13.states.size();     // Catch: Throwable -> L18
        r5.setReadonly(true);     // Catch: Throwable -> L18
        r10.configs = r5;     // Catch: Throwable -> L18
        r13.states.put(r10, r10);     // Catch: Throwable -> L18
        monitor-exit(r14);     // Catch: Throwable -> L18
        return r10;
    L18:
        th = move-exception;
        throw th;
    L8:
        r12 = null;
        goto L10
    }

    public void captureSimState(SimState r5, CharStream r10, DFAState r11) {
        r5.index = r10.index();
        r5.line = this.line;
        r5.charPos = this.charPositionInLine;
        r5.dfaState = r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNSimulator
    public void clearDFA() {
        int r5 = 0;
    L3:
        DFA[] r10 = this.decisionToDFA;
        if (r5 >= r10.length) goto L6;
        r10[r5] = new DFA(this.atn.getDecisionState(r5), r5);
        r5 = r5 + 1;
        goto L3
    }

    public boolean closure(CharStream r14, LexerATNConfig r15, ATNConfigSet r16, boolean r17, boolean r18, boolean r19) {
        ATNState r5 = r15.state;
        if ((r5 instanceof RuleStopState) == false) goto L33;
        PredictionContext r10 = r15.context;
        if (r10 != null) goto L7;
    L10:
        PredictionContext r11 = r15.context;
        boolean r12 = true;
        if (r11 != null) goto L13;
    L30:
        r16.add(r15);
        return true;
    L13:
        if (r11.isEmpty() == true) goto L30;
        r16.add(new LexerATNConfig(r15, r15.state, PredictionContext.EMPTY));
    L16:
        PredictionContext r13 = r15.context;
        if (r13 != null) goto L19;
        return r12;
    L19:
        if (r13.isEmpty() == true) goto L53;
        boolean r20 = r12;
        int r21 = 0;
    L22:
        if (r21 >= r15.context.size()) goto L29;
        if (r15.context.getReturnState(r21) == Integer.MAX_VALUE) goto L27;
        r20 = closure(r14, new LexerATNConfig(r15, this.atn.states.get(r15.context.getReturnState(r21)), r15.context.getParent(r21)), r16, r20, r18, r19);
    L27:
        r21 = r21 + 1;
        goto L22
    L29:
        return r20;
    L53:
        return r12;
    L7:
        if (r10.hasEmptyPath() == true) goto L10;
        r12 = r17;
        goto L16
    L33:
        if (r5.onlyHasEpsilonTransitions() == true) goto L38;
        if (r17 == true) goto L36;
    L37:
        r16.add(r15);
        goto L38
    L36:
        if (r15.hasPassedThroughNonGreedyDecision() == false) goto L37;
    L38:
        ATNState r22 = r15.state;
        boolean r110 = r17;
        int r111 = 0;
    L40:
        if (r111 >= r22.getNumberOfTransitions()) goto L45;
        LexerATNConfig r23 = getEpsilonTarget(r14, r15, r22.transition(r111), r16, r18, r19);
        if (r23 == null) goto L44;
        r110 = closure(r14, r23, r16, r110, r18, r19);
    L44:
        r111 = r111 + 1;
        goto L40
    L45:
        return r110;
    }

    public ATNConfigSet computeStartState(CharStream r11, ATNState r12) {
        EmptyPredictionContext r5 = PredictionContext.EMPTY;
        OrderedATNConfigSet r10 = new OrderedATNConfigSet();
        int r13 = 0;
    L4:
        if (r13 >= r12.getNumberOfTransitions()) goto L6;
        int r14 = r13 + 1;
        closure(r11, new LexerATNConfig(r12.transition(r13).target, r14, r5), r10, false, false, false);
        r13 = r14;
        goto L4
    L6:
        return r10;
    }

    public DFAState computeTargetState(CharStream r5, DFAState r10, int r11) {
        OrderedATNConfigSet r12 = new OrderedATNConfigSet();
        getReachableConfigSet(r5, r10.configs, r12, r11);
        if (r12.isEmpty() == false) goto L10;
        if (r12.hasSemanticContext == true) goto L8;
        addDFAEdge(r10, r11, ATNSimulator.ERROR);
    L8:
        return ATNSimulator.ERROR;
    L10:
        return addDFAEdge(r10, r11, r12);
    }

    public void consume(CharStream r5) {
        if (r5.LA(1) != 10) goto L5;
        this.line++;
        this.charPositionInLine = 0;
    L6:
        r5.consume();
        return;
    L5:
        this.charPositionInLine++;
        goto L6
    }

    public void copyState(LexerATNSimulator r5) {
        this.charPositionInLine = r5.charPositionInLine;
        this.line = r5.line;
        this.mode = r5.mode;
        this.startIndex = r5.startIndex;
    }

    public boolean evaluatePredicate(CharStream r10, int r11, int r12, boolean r13) {
        Lexer r5 = this.recog;
        if (r5 != null) goto L7;
        return true;
    L7:
        if (r13 == false) goto L9;
        int r14 = this.charPositionInLine;
        int r15 = this.line;
        int r16 = r10.index();
        int r17 = r10.mark();
        consume(r10);     // Catch: Throwable -> L14
        boolean r18 = this.recog.sempred(null, r11, r12);     // Catch: Throwable -> L14
        this.charPositionInLine = r14;
        this.line = r15;
        r10.seek(r16);
        r10.release(r17);
        return r18;
    L14:
        th = move-exception;
        this.charPositionInLine = r14;
        this.line = r15;
        r10.seek(r16);
        r10.release(r17);
        throw th;
    L9:
        return r5.sempred(null, r11, r12);
    }

    public int execATN(CharStream r10, DFAState r11) {
        if (r11.isAcceptState == false) goto L5;
        captureSimState(this.prevAccept, r10, r11);
    L5:
        int r5 = r10.LA(1);
    L6:
        DFAState r12 = getExistingTargetState(r11, r5);
        if (r12 != null) goto L10;
        r12 = computeTargetState(r10, r11, r5);
    L10:
        if (r12 == ATNSimulator.ERROR) goto L20;
        if (r5 == (-1)) goto L16;
        consume(r10);
    L16:
        if (r12.isAcceptState == false) goto L21;
        captureSimState(this.prevAccept, r10, r12);
        if (r5 == (-1)) goto L20;
    L21:
        r5 = r10.LA(1);
        r11 = r12;
    L20:
        return failOrAccept(this.prevAccept, r10, r11.configs, r5);
    }

    public int failOrAccept(SimState r10, CharStream r11, ATNConfigSet r12, int r13) {
        DFAState r5 = r10.dfaState;
        if (r5 == null) goto L7;
        accept(r11, r5.lexerActionExecutor, this.startIndex, r10.index, r10.line, r10.charPos);
        return r10.dfaState.prediction;
    L7:
        if (r13 != (-1)) goto L12;
        if (r11.index() != this.startIndex) goto L12;
        return -1;
    L12:
        throw new LexerNoViableAltException(this.recog, r11, this.startIndex, r12);
    }

    public int getCharPositionInLine() {
        return this.charPositionInLine;
    }

    public final DFA getDFA(int r5) {
        return this.decisionToDFA[r5];
    }

    public LexerATNConfig getEpsilonTarget(CharStream r5, LexerATNConfig r10, Transition r11, ATNConfigSet r12, boolean r13, boolean r14) {
        int r15 = r11.getSerializationType();
        if (r15 == 10) goto L26;
        switch(r15) {
            case 1: goto L24;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L14;
            case 5: goto L18;
            case 6: goto L6;
            case 7: goto L18;
            default: goto L22;
        };
    L6:
        PredictionContext r16 = r10.context;
        if (r16 != null) goto L9;
    L12:
        LexerActionExecutor r17 = LexerActionExecutor.append(r10.getLexerActionExecutor(), this.atn.lexerActions[((ActionTransition) r11).actionIndex]);
        LexerATNConfig r18 = new LexerATNConfig(r10, r11.target, r17);
    L28:
        return r18;
    L9:
        if (r16.hasEmptyPath() == true) goto L12;
        return new LexerATNConfig(r10, r11.target);
    L14:
        PredicateTransition r19 = (PredicateTransition) r11;
        r12.hasSemanticContext = true;
        if (evaluatePredicate(r5, r19.ruleIndex, r19.predIndex, r13) == false) goto L22;
        return new LexerATNConfig(r10, r11.target);
    L17:
        SingletonPredictionContext r20 = SingletonPredictionContext.create(r10.context, ((RuleTransition) r11).followState.stateNumber);
        r18 = new LexerATNConfig(r10, r11.target, r20);
        goto L28
    L18:
        if (r14 == false) goto L22;
        if (r11.matches(-1, 0, Lexer.MAX_CHAR_VALUE) == false) goto L22;
        return new LexerATNConfig(r10, r11.target);
    L22:
        return null;
    L24:
        return new LexerATNConfig(r10, r11.target);
    L26:
        throw new UnsupportedOperationException("Precedence predicates are not supported in lexers.");
    }

    public DFAState getExistingTargetState(DFAState r5, int r10) {
        DFAState[] r11 = r5.edges;
        if (r11 == null) goto L10;
        if (r10 >= 0) goto L6;
        return null;
    L6:
        if (r10 <= 127) goto L9;
        return null;
    L9:
        return r11[r10];
    L10:
        return null;
    }

    public int getLine() {
        return this.line;
    }

    public void getReachableConfigSet(CharStream r19, ATNConfigSet r20, ATNConfigSet r21, int r22) {
        Iterator<ATNConfig> r10 = r20.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L29;
        ATNConfig r12 = r10.next();
        if (r12.alt != r11) goto L8;
        boolean r14 = true;
    L9:
        if (r14 == false) goto L13;
        if (((LexerATNConfig) r12).hasPassedThroughNonGreedyDecision() == true) goto L4;
    L13:
        int r15 = r12.state.getNumberOfTransitions();
        int r13 = 0;
    L14:
        if (r13 >= r15) goto L4;
        ATNState r5 = getReachableTarget(r12.state.transition(r13), r22);
        if (r5 == null) goto L28;
        LexerATNConfig r16 = (LexerATNConfig) r12;
        LexerActionExecutor r17 = r16.getLexerActionExecutor();
        if (r17 == null) goto L21;
        r17 = r17.fixOffsetBeforeMatch(r19.index() - this.startIndex);
    L21:
        if (r22 != (-1)) goto L23;
        boolean r18 = true;
    L25:
        if (closure(r19, new LexerATNConfig(r16, r5, r17), r21, r14, true, r18) == false) goto L28;
        r11 = r12.alt;
        goto L4
    L23:
        r18 = false;
    L28:
        r13 = r13 + 1;
        goto L14
    L8:
        r14 = false;
        goto L9
    }

    public ATNState getReachableTarget(Transition r5, int r10) {
        if (r5.matches(r10, 0, Lexer.MAX_CHAR_VALUE) == true) goto L5;
        return null;
    L5:
        return r5.target;
    }

    public String getText(CharStream r5) {
        return r5.getText(Interval.of(this.startIndex, r5.index() - 1));
    }

    public String getTokenName(int r5) {
        if (r5 != (-1)) goto L7;
        return "EOF";
    L7:
        return "'" + ((char) r5) + "'";
    }

    public int match(CharStream r5, int r10) {
        match_calls++;
        this.mode = r10;
        int r11 = r5.mark();
        this.startIndex = r5.index();     // Catch: Throwable -> L8
        this.prevAccept.reset();     // Catch: Throwable -> L8
        DFA r12 = this.decisionToDFA[r10];     // Catch: Throwable -> L8
        if (r12.f662s0 != null) goto L10;
        int r13 = matchATN(r5);     // Catch: Throwable -> L8
        r5.release(r11);
        return r13;
    L10:
        int r14 = execATN(r5, r12.f662s0);     // Catch: Throwable -> L8
        r5.release(r11);
        return r14;
    L8:
        th = move-exception;
        r5.release(r11);
        throw th;
    }

    public int matchATN(CharStream r5) {
        ATNConfigSet r10 = computeStartState(r5, this.atn.modeToStartState.get(this.mode));
        boolean r11 = r10.hasSemanticContext;
        r10.hasSemanticContext = false;
        DFAState r12 = addDFAState(r10);
        if (r11 == true) goto L6;
        this.decisionToDFA[this.mode].f662s0 = r12;
    L6:
        return execATN(r5, r12);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNSimulator
    public void reset() {
        this.prevAccept.reset();
        this.startIndex = -1;
        this.line = 1;
        this.charPositionInLine = 0;
        this.mode = 0;
    }

    public void setCharPositionInLine(int r5) {
        this.charPositionInLine = r5;
    }

    public void setLine(int r5) {
        this.line = r5;
    }

    public LexerATNSimulator(Lexer r5, ATN r10, DFA[] r11, PredictionContextCache r12) {
        super(r10, r12);
        this.startIndex = -1;
        this.line = 1;
        this.charPositionInLine = 0;
        this.mode = 0;
        this.prevAccept = new SimState();
        this.decisionToDFA = r11;
        this.recog = r5;
    }

    public void addDFAEdge(DFAState r5, int r10, DFAState r11) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (r10 > 127) goto L20;
        monitor-enter(r5);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (r5.edges != null) goto L12;
        r5.edges = new DFAState[128];     // Catch: Throwable -> L10
    L12:
        r5.edges[r10] = r11;     // Catch: Throwable -> L10
        monitor-exit(r5);     // Catch: Throwable -> L10
        return;
    }
}
