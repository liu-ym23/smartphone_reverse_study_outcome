package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.runtime.NoViableAltException;
import androidx.room.jarjarred.org.antlr.v4.runtime.Parser;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.Vocabulary;
import androidx.room.jarjarred.org.antlr.v4.runtime.VocabularyImpl;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFAState;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.DoubleKeyMap;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ParserATNSimulator extends ATNSimulator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean TURN_OFF_LR_LOOP_ENTRY_BRANCH_OPT = false;
    public static final boolean debug = false;
    public static final boolean debug_list_atn_decisions = false;
    public static final boolean dfa_debug = false;
    public static final boolean retry_debug = false;
    protected DFA _dfa;
    protected TokenStream _input;
    protected ParserRuleContext _outerContext;
    protected int _startIndex;
    public final DFA[] decisionToDFA;
    protected DoubleKeyMap<PredictionContext, PredictionContext, PredictionContext> mergeCache;
    private PredictionMode mode;
    protected final Parser parser;

    static {
        TURN_OFF_LR_LOOP_ENTRY_BRANCH_OPT = Boolean.parseBoolean(getSafeEnv("TURN_OFF_LR_LOOP_ENTRY_BRANCH_OPT"));
    }

    public ParserATNSimulator(ATN r5, DFA[] r10, PredictionContextCache r11) {
        this(null, r5, r10, r11);
    }

    public static String getSafeEnv(String r5) {
        return System.getenv(r5);
    L4:
        return null;
    }

    public static int getUniqueAlt(ATNConfigSet r5) {
        Iterator<ATNConfig> r10 = r5.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L11;
        ATNConfig r12 = r10.next();
        if (r11 == 0) goto L7;
        if (r12.alt == r11) goto L4;
        return 0;
    L7:
        r11 = r12.alt;
        goto L4
    L11:
        return r11;
    }

    public ATNConfig actionTransition(ATNConfig r5, ActionTransition r10) {
        return new ATNConfig(r5, r10.target);
    }

    public int adaptivePredict(TokenStream r10, int r11, ParserRuleContext r12) {
        this._input = r10;
        this._startIndex = r10.index();
        this._outerContext = r12;
        DFA r5 = this.decisionToDFA[r11];
        this._dfa = r5;
        int r13 = r10.mark();
        int r14 = this._startIndex;
    L6:
        th = move-exception;
        this.mergeCache = null;
        this._dfa = null;
        r10.seek(r14);
        r10.release(r13);
        throw th;
    L4:
        if (r5.isPrecedenceDfa() == false) goto L8;
        DFAState r15 = r5.getPrecedenceStartState(this.parser.getPrecedence());     // Catch: Throwable -> L6
    L9:
        if (r15 != null) goto L17;
        if (r12 != null) goto L12;
        r12 = RuleContext.EMPTY;     // Catch: Throwable -> L6
    L12:
        ATNConfigSet r16 = computeStartState(r5.atnStartState, RuleContext.EMPTY, false);     // Catch: Throwable -> L6
        if (r5.isPrecedenceDfa() == false) goto L16;
        r5.f662s0.configs = r16;     // Catch: Throwable -> L6
        r15 = addDFAState(r5, new DFAState(applyPrecedenceFilter(r16)));     // Catch: Throwable -> L6
        r5.setPrecedenceStartState(this.parser.getPrecedence(), r15);     // Catch: Throwable -> L6
        goto L17
    L16:
        r15 = addDFAState(r5, new DFAState(r16));     // Catch: Throwable -> L6
        r5.f662s0 = r15;     // Catch: Throwable -> L6
    L17:
        int r17 = execATN(r5, r15, r10, r14, r12);     // Catch: Throwable -> L6
        this.mergeCache = null;
        this._dfa = null;
        r10.seek(r14);
        r10.release(r13);
        return r17;
    L8:
        r15 = r5.f662s0;     // Catch: Throwable -> L6
        goto L9
    }

    public DFAState addDFAEdge(DFA r5, DFAState r10, int r11, DFAState r12) {
        if (r12 != null) goto L5;
        return null;
    L5:
        DFAState r13 = addDFAState(r5, r12);
        if (r10 != null) goto L8;
    L23:
        return r13;
    L8:
        if (r11 < (-1)) goto L23;
        if (r11 > this.atn.maxTokenType) goto L23;
        monitor-enter(r10);
    L16:
        th = move-exception;
        throw th;
    L14:
        if (r10.edges != null) goto L18;
        r10.edges = new DFAState[this.atn.maxTokenType + 2];     // Catch: Throwable -> L16
    L18:
        r10.edges[r11 + 1] = r13;     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        return r13;
    }

    public DFAState addDFAState(DFA r5, DFAState r10) {
        if (r10 != ATNSimulator.ERROR) goto L5;
        return r10;
    L5:
        Map<DFAState, DFAState> r11 = r5.states;
        monitor-enter(r11);
        DFAState r12 = r5.states.get(r10);     // Catch: Throwable -> L11
        if (r12 == null) goto L13;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return r12;
    L13:
        r10.stateNumber = r5.states.size();     // Catch: Throwable -> L11
        if (r10.configs.isReadonly() == true) goto L16;
        r10.configs.optimizeConfigs(this);     // Catch: Throwable -> L11
        r10.configs.setReadonly(true);     // Catch: Throwable -> L11
    L16:
        r5.states.put(r10, r10);     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return r10;
    L11:
        th = move-exception;
        throw th;
    }

    public ATNConfigSet applyPrecedenceFilter(ATNConfigSet r10) {
        HashMap r5 = new HashMap();
        ATNConfigSet r11 = new ATNConfigSet(r10.fullCtx);
        Iterator<ATNConfig> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L15;
        ATNConfig r13 = r12.next();
        if (r13.alt != 1) goto L4;
        SemanticContext r14 = r13.semanticContext.evalPrecedence(this.parser, this._outerContext);
        if (r14 == null) goto L4;
        r5.put(Integer.valueOf(r13.state.stateNumber), r13.context);
        if (r14 != r13.semanticContext) goto L13;
        r11.add(r13, this.mergeCache);
        goto L4
    L13:
        r11.add(new ATNConfig(r13, r14), this.mergeCache);
        goto L4
    L15:
        Iterator<ATNConfig> r15 = r10.iterator();
    L17:
        if (r15.hasNext() == false) goto L29;
        ATNConfig r16 = r15.next();
        if (r16.alt == 1) goto L17;
        if (r16.isPrecedenceFilterSuppressed() == true) goto L28;
        PredictionContext r17 = (PredictionContext) r5.get(Integer.valueOf(r16.state.stateNumber));
        if (r17 == null) goto L28;
        if (r17.equals(r16.context) == true) goto L17;
    L28:
        r11.add(r16, this.mergeCache);
        goto L17
    L29:
        return r11;
    }

    public boolean canDropLoopEntryEdgeInLeftRecursiveRule(ATNConfig r11) {
        if (TURN_OFF_LR_LOOP_ENTRY_BRANCH_OPT == false) goto L5;
        return false;
    L5:
        ATNState r5 = r11.state;
        if (r5.getStateType() == 10) goto L8;
    L47:
        return false;
    L8:
        if (((StarLoopEntryState) r5).isPrecedenceDecision == false) goto L47;
        if (r11.context.isEmpty() == true) goto L47;
        if (r11.context.hasEmptyPath() == true) goto L47;
        int r10 = r11.context.size();
        int r12 = 0;
    L15:
        if (r12 >= r10) goto L20;
        if (this.atn.states.get(r11.context.getReturnState(r12)).ruleIndex != r5.ruleIndex) goto L18;
        r12 = r12 + 1;
        goto L15
    L18:
        return false;
    L20:
        BlockEndState r13 = (BlockEndState) this.atn.states.get(((BlockStartState) r5.transition(0).target).endState.stateNumber);
        int r14 = 0;
    L22:
        if (r14 >= r10) goto L46;
        ATNState r15 = this.atn.states.get(r11.context.getReturnState(r14));
        if (r15.getNumberOfTransitions() != 1) goto L45;
        if (r15.transition(0).isEpsilon() == false) goto L45;
        ATNState r16 = r15.transition(0).target;
        if (r15.getStateType() != 8) goto L32;
        if (r16 != r5) goto L32;
    L44:
        r14 = r14 + 1;
    L32:
        if (r15 == r13) goto L44;
        if (r16 == r13) goto L44;
        if (r16.getStateType() != 8) goto L45;
        if (r16.getNumberOfTransitions() != 1) goto L45;
        if (r16.transition(0).isEpsilon() == false) goto L45;
        if (r16.transition(0).target == r5) goto L44;
    L45:
        return false;
    L46:
        return true;
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

    public void closure(ATNConfig r10, ATNConfigSet r11, Set<ATNConfig> r12, boolean r13, boolean r14, boolean r15) {
        closureCheckingStopState(r10, r11, r12, r13, r14, 0, r15);
    }

    public void closureCheckingStopState(ATNConfig r13, ATNConfigSet r14, Set<ATNConfig> r15, boolean r16, boolean r17, int r18, boolean r19) {
        if ((r13.state instanceof RuleStopState) == true) goto L5;
    L20:
        closure_(r13, r14, r15, r16, r17, r18, r19);
        return;
    L5:
        if (r13.context.isEmpty() == true) goto L17;
        int r11 = 0;
    L8:
        if (r11 >= r13.context.size()) goto L16;
        if (r13.context.getReturnState(r11) != Integer.MAX_VALUE) goto L14;
        if (r17 == false) goto L13;
        r14.add(new ATNConfig(r13, r13.state, PredictionContext.EMPTY), this.mergeCache);
    L15:
        r11 = r11 + 1;
        goto L8
    L13:
        closure_(r13, r14, r15, r16, r17, r18, r19);
        goto L15
    L14:
        ATNConfig r5 = new ATNConfig(this.atn.states.get(r13.context.getReturnState(r11)), r13.alt, r13.context.getParent(r11), r13.semanticContext);
        r5.reachesIntoOuterContext = r13.reachesIntoOuterContext;
        closureCheckingStopState(r5, r14, r15, r16, r17, r18 - 1, r19);
        goto L15
    L16:
        return;
    L17:
        if (r17 == false) goto L20;
        r14.add(r13, this.mergeCache);
    }

    public void closure_(ATNConfig r18, ATNConfigSet r19, Set<ATNConfig> r20, boolean r21, boolean r22, int r23, boolean r24) {
        ATNState r12 = r18.state;
        if (r12.onlyHasEpsilonTransitions() == true) goto L5;
        r19.add(r18, this.mergeCache);
    L5:
        int r14 = 0;
    L7:
        if (r14 >= r12.getNumberOfTransitions()) goto L48;
        if (r14 == 0) goto L10;
    L12:
        Transition r10 = r12.transition(r14);
        if ((r10 instanceof ActionTransition) == true) goto L16;
        if (r21 == false) goto L16;
        boolean r16 = true;
    L17:
        if (r23 != 0) goto L19;
        boolean r5 = true;
    L20:
        ATNConfig r11 = getEpsilonTarget(r18, r10, r16, r5, r22, r24);
        if (r11 == null) goto L47;
        if ((r18.state instanceof RuleStopState) == false) goto L37;
        DFA r13 = this._dfa;
        if (r13 != null) goto L27;
    L31:
        r11.reachesIntoOuterContext++;
        if (r20.add(r11) == false) goto L47;
        r19.dipsIntoOuterContext = true;
        int r15 = r23 - 1;
    L35:
        int r17 = r15;
    L46:
        closureCheckingStopState(r11, r19, r20, r16, r22, r17, r24);
        goto L47
    L27:
        if (r13.isPrecedenceDfa() == false) goto L31;
        if (((EpsilonTransition) r10).outermostPrecedenceReturn() != this._dfa.atnStartState.ruleIndex) goto L31;
        r11.setPrecedenceFilterSuppressed(true);
        goto L31
    L37:
        if (r10.isEpsilon() == true) goto L42;
        if (r20.add(r11) == false) goto L47;
    L42:
        if ((r10 instanceof RuleTransition) == false) goto L45;
        if (r23 < 0) goto L45;
        r15 = r23 + 1;
    L45:
        r17 = r23;
    L47:
        r14 = r14 + 1;
        goto L7
    L19:
        r5 = false;
    L16:
        r16 = false;
        goto L17
    L10:
        if (canDropLoopEntryEdgeInLeftRecursiveRule(r18) == false) goto L12;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public ATNConfigSet computeReachSet(ATNConfigSet r21, int r22, boolean r23) {
        if (this.mergeCache != null) goto L5;
        this.mergeCache = new DoubleKeyMap();
    L5:
        ATNConfigSet r10 = new ATNConfigSet(r23);
        Iterator<ATNConfig> r5 = r21.iterator();
        ArrayList r12 = null;
    L6:
        boolean r13 = false;
        int r14 = 0;
        if (r5.hasNext() == false) goto L22;
        ATNConfig r11 = r5.next();
        ATNState r15 = r11.state;
        if ((r15 instanceof RuleStopState) == true) goto L10;
        int r16 = r15.getNumberOfTransitions();
    L16:
        if (r14 >= r16) goto L6;
        ATNState r17 = getReachableTarget(r11.state.transition(r14), r22);
        if (r17 == null) goto L20;
        r10.add(new ATNConfig(r11, r17), this.mergeCache);
    L20:
        r14 = r14 + 1;
        goto L16
    L10:
        if (r23 == true) goto L12;
        if (r22 != (-1)) goto L6;
    L12:
        if (r12 != null) goto L14;
        r12 = new ArrayList();
    L14:
        r12.add(r11);
        goto L6
    L22:
        if (r12 != null) goto L30;
        if (r22 == (-1)) goto L30;
        if (r10.size() != 1) goto L28;
    L29:
        ATNConfigSet r18 = r10;
    L31:
        if (r18 != null) goto L41;
        ATNConfigSet r19 = new ATNConfigSet(r23);
        HashSet r110 = new HashSet();
        if (r22 != (-1)) goto L35;
        boolean r111 = true;
    L36:
        Iterator<ATNConfig> r112 = r10.iterator();
    L38:
        if (r112.hasNext() == false) goto L40;
        closure(r112.next(), r19, r110, false, r23, r111);
        r19 = r19;
        goto L38
    L40:
        r18 = r19;
        goto L41
    L35:
        r111 = false;
    L41:
        if (r22 != (-1)) goto L45;
        if (r18 != r10) goto L44;
        r13 = true;
    L44:
        r18 = removeAllConfigsNotInRuleStopState(r18, r13);
    L45:
        if (r12 == null) goto L54;
        if (r23 == true) goto L48;
    L49:
        Iterator r20 = r12.iterator();
    L51:
        if (r20.hasNext() == false) goto L54;
        r18.add((ATNConfig) r20.next(), this.mergeCache);
        goto L51
    L48:
        if (PredictionMode.hasConfigInRuleStopState(r18) == false) goto L49;
    L54:
        if (r18.isEmpty() == false) goto L56;
        return null;
    L56:
        return r18;
    L28:
        if (getUniqueAlt(r10) != 0) goto L29;
    L30:
        r18 = null;
        goto L31
    }

    public ATNConfigSet computeStartState(ATNState r10, RuleContext r11, boolean r12) {
        PredictionContext r13 = PredictionContext.fromRuleContext(this.atn, r11);
        ATNConfigSet r14 = new ATNConfigSet(r12);
        int r5 = 0;
    L4:
        if (r5 >= r10.getNumberOfTransitions()) goto L6;
        int r15 = r5 + 1;
        closure(new ATNConfig(r10.transition(r5).target, r15, r13), r14, new HashSet(), true, r12, false);
        r5 = r15;
        goto L4
    L6:
        return r14;
    }

    public DFAState computeTargetState(DFA r10, DFAState r11, int r12) {
        ATNConfigSet r5 = computeReachSet(r11.configs, r12, false);
        if (r5 != null) goto L6;
        DFAState r13 = ATNSimulator.ERROR;
        addDFAEdge(r10, r11, r12, r13);
        return r13;
    L6:
        DFAState r14 = new DFAState(r5);
        int r15 = getUniqueAlt(r5);
        if (r15 == 0) goto L10;
        r14.isAcceptState = true;
        r14.configs.uniqueAlt = r15;
        r14.prediction = r15;
    L13:
        if (r14.isAcceptState == false) goto L20;
        if (r14.configs.hasSemanticContext == false) goto L20;
        predicateDFAState(r14, this.atn.getDecisionState(r10.decision));
        if (r14.predicates == null) goto L20;
        r14.prediction = 0;
    L20:
        return addDFAEdge(r10, r11, r12, r14);
    L10:
        if (PredictionMode.hasSLLConflictTerminatingPrediction(this.mode, r5) == false) goto L13;
        ATNConfigSet r16 = r14.configs;
        r16.conflictingAlts = getConflictingAlts(r5);
        r14.requiresFullContext = true;
        r14.isAcceptState = true;
        r14.prediction = r14.configs.conflictingAlts.nextSetBit(0);
        goto L13
    }

    public void dumpDeadEndConfigs(NoViableAltException r10) {
        System.err.println("dead end configs: ");
        Iterator<ATNConfig> r11 = r10.getDeadEndConfigs().iterator();
    L4:
        if (r11.hasNext() == false) goto L19;
        ATNConfig r5 = r11.next();
        if (r5.state.getNumberOfTransitions() <= 0) goto L17;
        Transition r12 = r5.state.transition(0);
        if ((r12 instanceof AtomTransition) == false) goto L11;
        String r13 = "Atom " + getTokenName(((AtomTransition) r12).label);
    L18:
        System.err.println(r5.toString(this.parser, true) + ":" + r13);
        goto L4
    L11:
        if ((r12 instanceof SetTransition) == false) goto L17;
        SetTransition r14 = (SetTransition) r12;
        boolean r15 = r14 instanceof NotSetTransition;
        StringBuilder r16 = new StringBuilder();
        if (r15 == false) goto L15;
        String r17 = "~";
    L16:
        r16.append(r17);
        r16.append("Set ");
        r16.append(r14.set.toString());
        r13 = r16.toString();
        goto L18
    L15:
        r17 = "";
    L17:
        r13 = "no edges";
        goto L18
    }

    public BitSet evalSemanticContext(DFAState.PredPrediction[] r10, ParserRuleContext r11, boolean r12) {
        BitSet r5 = new BitSet();
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L15;
        DFAState.PredPrediction r15 = r10[r14];
        SemanticContext r16 = r15.pred;
        if (r16 != SemanticContext.NONE) goto L10;
        r5.set(r15.alt);
        if (r12 == false) goto L15;
    L14:
        r14 = r14 + 1;
        goto L3
    L10:
        if (evalSemanticContext(r16, r11, r15.alt, false) == false) goto L14;
        r5.set(r15.alt);
        if (r12 == true) goto L14;
    L15:
        return r5;
    }

    public int execATN(DFA r15, DFAState r16, TokenStream r17, int r18, ParserRuleContext r19) {
        int r5 = r17.LA(1);
        DFAState r10 = r16;
    L3:
        DFAState r11 = getExistingTargetState(r10, r5);
        if (r11 != null) goto L6;
        r11 = computeTargetState(r15, r10, r5);
    L6:
        DFAState r12 = r11;
        if (r12 == ATNSimulator.ERROR) goto L8;
        if (r12.requiresFullContext == false) goto L31;
        if (this.mode == PredictionMode.SLL) goto L31;
        BitSet r13 = r12.configs.conflictingAlts;
        if (r12.predicates == null) goto L27;
        int r14 = r17.index();
        if (r14 == r18) goto L21;
        r17.seek(r18);
    L21:
        BitSet r20 = evalSemanticContext(r12.predicates, r19, true);
        if (r20.cardinality() == 1) goto L24;
        if (r14 == r18) goto L28;
        r17.seek(r14);
    L28:
        ATNConfigSet r110 = computeStartState(r15.atnStartState, r19, true);
        reportAttemptingFullContext(r15, r20, r12.configs, r18, r17.index());
        return execATNWithFullContext(r15, r12, r110, r17, r18, r19);
    L24:
        return r20.nextSetBit(0);
    L27:
        r20 = r13;
    L31:
        if (r12.isAcceptState == true) goto L33;
        if (r5 == (-1)) goto L48;
        r17.consume();
        r5 = r17.LA(1);
    L48:
        r10 = r12;
        goto L3
    L33:
        if (r12.predicates == null) goto L35;
        int r21 = r17.index();
        r17.seek(r18);
        BitSet r111 = evalSemanticContext(r12.predicates, r19, true);
        int r22 = r111.cardinality();
        if (r22 == 0) goto L44;
        if (r22 == 1) goto L42;
        reportAmbiguity(r15, r12, r18, r21, false, r111, r12.configs);
        return r111.nextSetBit(0);
    L42:
        return r111.nextSetBit(0);
    L44:
        throw noViableAlt(r17, r19, r12.configs, r18);
    L35:
        return r12.prediction;
    L8:
        NoViableAltException r23 = noViableAlt(r17, r19, r10.configs, r18);
        r17.seek(r18);
        int r24 = getSynValidOrSemInvalidAltThatFinishedDecisionEntryRule(r10.configs, r19);
        if (r24 == 0) goto L11;
        return r24;
    L11:
        throw r23;
    }

    public int execATNWithFullContext(DFA r12, DFAState r13, ATNConfigSet r14, TokenStream r15, int r16, ParserRuleContext r17) {
        r15.seek(r16);
        int r5 = r15.LA(1);
        ATNConfigSet r10 = r14;
    L3:
        ATNConfigSet r11 = computeReachSet(r10, r5, true);
        if (r11 == null) goto L5;
        Collection<BitSet> r18 = PredictionMode.getConflictingAltSubsets(r11);
        int r19 = getUniqueAlt(r11);
        r11.uniqueAlt = r19;
        if (r19 != 0) goto L11;
        if (this.mode == PredictionMode.LL_EXACT_AMBIG_DETECTION) goto L18;
        r19 = PredictionMode.resolvesToJustOneViableAlt(r18);
        if (r19 != 0) goto L11;
    L29:
        if (r5 == (-1)) goto L31;
        r15.consume();
        r5 = r15.LA(1);
    L31:
        r10 = r11;
        goto L3
    L18:
        if (PredictionMode.allSubsetsConflict(r18) == false) goto L29;
        if (PredictionMode.allSubsetsEqual(r18) == false) goto L29;
        r19 = PredictionMode.getSingleViableAlt(r18);
        boolean r20 = true;
    L23:
        if (r11.uniqueAlt == 0) goto L26;
        reportContextSensitivity(r12, r19, r11, r16, r15.index());
        return r19;
    L26:
        reportAmbiguity(r12, r13, r16, r15.index(), r20, r11.getAlts(), r11);
        return r19;
    L11:
        r20 = false;
        goto L23
    L5:
        NoViableAltException r21 = noViableAlt(r15, r17, r10, r16);
        r15.seek(r16);
        int r22 = getSynValidOrSemInvalidAltThatFinishedDecisionEntryRule(r10, r17);
        if (r22 == 0) goto L8;
        return r22;
    L8:
        throw r21;
    }

    public int getAltThatFinishedDecisionEntryRule(ATNConfigSet r5) {
        IntervalSet r10 = new IntervalSet(new int[0]);
        Iterator<ATNConfig> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        ATNConfig r12 = r11.next();
        if (r12.getOuterContextDepth() > 0) goto L11;
        if ((r12.state instanceof RuleStopState) == false) goto L4;
        if (r12.context.hasEmptyPath() == false) goto L4;
    L11:
        r10.add(r12.alt);
        goto L4
    L13:
        if (r10.size() != 0) goto L16;
        return 0;
    L16:
        return r10.getMinElement();
    }

    public BitSet getConflictingAlts(ATNConfigSet r5) {
        return PredictionMode.getAlts(PredictionMode.getConflictingAltSubsets(r5));
    }

    public BitSet getConflictingAltsOrUniqueAlt(ATNConfigSet r5) {
        if (r5.uniqueAlt == 0) goto L6;
        BitSet r10 = new BitSet();
        r10.set(r5.uniqueAlt);
        return r10;
    L6:
        return r5.conflictingAlts;
    }

    public ATNConfig getEpsilonTarget(ATNConfig r10, Transition r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        int r5 = r11.getSerializationType();
        if (r5 == 10) goto L22;
        switch(r5) {
            case 1: goto L20;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L13;
            case 6: goto L8;
            case 7: goto L13;
            default: goto L6;
        };
    L6:
        return null;
    L13:
        if (r15 == true) goto L15;
    L18:
        return null;
    L15:
        if (r11.matches(-1, 0, 1) == false) goto L18;
        return new ATNConfig(r10, r11.target);
    L8:
        return actionTransition(r10, (ActionTransition) r11);
    L10:
        return predTransition(r10, (PredicateTransition) r11, r12, r13, r14);
    L12:
        return ruleTransition(r10, (RuleTransition) r11);
    L20:
        return new ATNConfig(r10, r11.target);
    L22:
        return precedenceTransition(r10, (PrecedencePredicateTransition) r11, r12, r13, r14);
    }

    public DFAState getExistingTargetState(DFAState r5, int r10) {
        DFAState[] r11 = r5.edges;
        if (r11 == null) goto L11;
        int r12 = r10 + 1;
        if (r12 >= 0) goto L7;
        return null;
    L7:
        if (r12 < r11.length) goto L10;
        return null;
    L10:
        return r11[r12];
    L11:
        return null;
    }

    public String getLookaheadName(TokenStream r5) {
        return getTokenName(r5.LA(1));
    }

    public Parser getParser() {
        return this.parser;
    }

    public DFAState.PredPrediction[] getPredicatePredictions(BitSet r10, SemanticContext[] r11) {
        ArrayList r5 = new ArrayList();
        boolean r12 = false;
        int r13 = 1;
    L4:
        if (r13 >= r11.length) goto L14;
        SemanticContext r14 = r11[r13];
        if (r10 == null) goto L11;
        if (r10.get(r13) == false) goto L11;
        r5.add(new DFAState.PredPrediction(r14, r13));
    L11:
        if (r14 == SemanticContext.NONE) goto L13;
        r12 = true;
    L13:
        r13 = r13 + 1;
        goto L4
    L14:
        if (r12 == true) goto L18;
        return null;
    L18:
        return (DFAState.PredPrediction[]) r5.toArray(new DFAState.PredPrediction[r5.size()]);
    }

    public final PredictionMode getPredictionMode() {
        return this.mode;
    }

    public SemanticContext[] getPredsForAmbigAlts(BitSet r5, ATNConfigSet r10, int r11) {
        SemanticContext[] r12 = new SemanticContext[r11 + 1];
        Iterator<ATNConfig> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        ATNConfig r14 = r13.next();
        if (r5.get(r14.alt) == false) goto L4;
        int r15 = r14.alt;
        r12[r15] = SemanticContext.or(r12[r15], r14.semanticContext);
        goto L4
    L8:
        int r16 = 1;
        int r17 = 0;
    L9:
        if (r16 > r11) goto L17;
        SemanticContext r18 = r12[r16];
        if (r18 != null) goto L14;
        r12[r16] = SemanticContext.NONE;
    L16:
        r16 = r16 + 1;
        goto L9
    L14:
        if (r18 == SemanticContext.NONE) goto L16;
        r17 = r17 + 1;
        goto L16
    L17:
        if (r17 != 0) goto L29;
        return null;
    L29:
        return r12;
    }

    public ATNState getReachableTarget(Transition r5, int r10) {
        if (r5.matches(r10, 0, this.atn.maxTokenType) == true) goto L5;
        return null;
    L5:
        return r5.target;
    }

    public String getRuleName(int r5) {
        Parser r10 = this.parser;
        if (r10 == null) goto L8;
        if (r5 < 0) goto L8;
        return r10.getRuleNames()[r5];
    L8:
        return j0.h(r5, "<rule ", ">");
    }

    public int getSynValidOrSemInvalidAltThatFinishedDecisionEntryRule(ATNConfigSet r5, ParserRuleContext r10) {
        Pair<ATNConfigSet, ATNConfigSet> r11 = splitAccordingToSemanticValidity(r5, r10);
        ATNConfigSet r12 = r11.f667a;
        ATNConfigSet r13 = r11.f668b;
        int r14 = getAltThatFinishedDecisionEntryRule(r12);
        if (r14 == 0) goto L6;
        return r14;
    L6:
        if (r13.size() <= 0) goto L10;
        int r15 = getAltThatFinishedDecisionEntryRule(r13);
        if (r15 == 0) goto L12;
        return r15;
    L12:
        return 0;
    L10:
        return 0;
    }

    public String getTokenName(int r5) {
        if (r5 != (-1)) goto L6;
        return "EOF";
    L6:
        Parser r10 = this.parser;
        if (r10 == null) goto L9;
        Vocabulary r11 = r10.getVocabulary();
    L10:
        String r12 = r11.getDisplayName(r5);
        if (r12.equals(Integer.toString(r5)) == false) goto L14;
        return r12;
    L14:
        return r12 + "<" + r5 + ">";
    L9:
        r11 = VocabularyImpl.EMPTY_VOCABULARY;
        goto L10
    }

    public NoViableAltException noViableAlt(TokenStream r10, ParserRuleContext r11, ATNConfigSet r12, int r13) {
        return new NoViableAltException(this.parser, r10, r10.get(r13), r10.LT(1), r12, r11);
    }

    public ATNConfig precedenceTransition(ATNConfig r5, PrecedencePredicateTransition r10, boolean r11, boolean r12, boolean r13) {
        if (r11 == false) goto L11;
        if (r12 == false) goto L11;
        if (r13 == false) goto L9;
        int r14 = this._input.index();
        this._input.seek(this._startIndex);
        boolean r15 = evalSemanticContext(r10.getPredicate(), this._outerContext, r5.alt, r13);
        this._input.seek(r14);
        if (r15 == true) goto L12;
        return null;
    L12:
        return new ATNConfig(r5, r10.target);
    L9:
        SemanticContext r16 = SemanticContext.and(r5.semanticContext, r10.getPredicate());
        return new ATNConfig(r5, r10.target, r16);
    L11:
        return new ATNConfig(r5, r10.target);
    }

    public ATNConfig predTransition(ATNConfig r5, PredicateTransition r10, boolean r11, boolean r12, boolean r13) {
        if (r11 == false) goto L14;
        boolean r14 = r10.isCtxDependent;
        if (r14 == false) goto L7;
        if (r14 == false) goto L14;
        if (r12 == false) goto L14;
    L7:
        if (r13 == false) goto L12;
        int r15 = this._input.index();
        this._input.seek(this._startIndex);
        boolean r16 = evalSemanticContext(r10.getPredicate(), this._outerContext, r5.alt, r13);
        this._input.seek(r15);
        if (r16 == true) goto L15;
        return null;
    L15:
        return new ATNConfig(r5, r10.target);
    L12:
        SemanticContext r17 = SemanticContext.and(r5.semanticContext, r10.getPredicate());
        return new ATNConfig(r5, r10.target, r17);
    L14:
        return new ATNConfig(r5, r10.target);
    }

    public void predicateDFAState(DFAState r5, DecisionState r10) {
        int r11 = r10.getNumberOfTransitions();
        BitSet r12 = getConflictingAltsOrUniqueAlt(r5.configs);
        SemanticContext[] r13 = getPredsForAmbigAlts(r12, r5.configs, r11);
        if (r13 == null) goto L5;
        r5.predicates = getPredicatePredictions(r12, r13);
        r5.prediction = 0;
        return;
    L5:
        r5.prediction = r12.nextSetBit(0);
    }

    public ATNConfigSet removeAllConfigsNotInRuleStopState(ATNConfigSet r5, boolean r10) {
        if (PredictionMode.allConfigsInRuleStopStates(r5) == false) goto L5;
        return r5;
    L5:
        ATNConfigSet r11 = new ATNConfigSet(r5.fullCtx);
        Iterator<ATNConfig> r12 = r5.iterator();
    L7:
        if (r12.hasNext() == false) goto L17;
        ATNConfig r13 = r12.next();
        ATNState r14 = r13.state;
        if ((r14 instanceof RuleStopState) == true) goto L10;
        if (r10 == false) goto L7;
        if (r14.onlyHasEpsilonTransitions() == false) goto L7;
        if (this.atn.nextTokens(r13.state).contains(-2) == false) goto L7;
        r11.add(new ATNConfig(r13, this.atn.ruleToStopState[r13.state.ruleIndex]), this.mergeCache);
        goto L7
    L10:
        r11.add(r13, this.mergeCache);
        goto L7
    L17:
        return r11;
    }

    public void reportAmbiguity(DFA r10, DFAState r11, int r12, int r13, boolean r14, BitSet r15, ATNConfigSet r16) {
        Parser r17 = this.parser;
        if (r17 == null) goto L6;
        r17.getErrorListenerDispatch().reportAmbiguity(this.parser, r10, r12, r13, r14, r15, r16);
        return;
    }

    public void reportAttemptingFullContext(DFA r10, BitSet r11, ATNConfigSet r12, int r13, int r14) {
        Parser r5 = this.parser;
        if (r5 == null) goto L6;
        r5.getErrorListenerDispatch().reportAttemptingFullContext(this.parser, r10, r13, r14, r11, r12);
        return;
    }

    public void reportContextSensitivity(DFA r10, int r11, ATNConfigSet r12, int r13, int r14) {
        Parser r5 = this.parser;
        if (r5 == null) goto L6;
        r5.getErrorListenerDispatch().reportContextSensitivity(this.parser, r10, r13, r14, r11, r12);
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNSimulator
    public void reset() {
    }

    public ATNConfig ruleTransition(ATNConfig r5, RuleTransition r10) {
        ATNState r11 = r10.followState;
        SingletonPredictionContext r12 = SingletonPredictionContext.create(r5.context, r11.stateNumber);
        return new ATNConfig(r5, r10.target, r12);
    }

    public final void setPredictionMode(PredictionMode r5) {
        this.mode = r5;
    }

    public Pair<ATNConfigSet, ATNConfigSet> splitAccordingToSemanticValidity(ATNConfigSet r10, ParserRuleContext r11) {
        ATNConfigSet r5 = new ATNConfigSet(r10.fullCtx);
        ATNConfigSet r12 = new ATNConfigSet(r10.fullCtx);
        Iterator<ATNConfig> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        ATNConfig r14 = r13.next();
        SemanticContext r15 = r14.semanticContext;
        if (r15 != SemanticContext.NONE) goto L8;
        r5.add(r14);
        goto L4
    L8:
        if (evalSemanticContext(r15, r11, r14.alt, r10.fullCtx) == true) goto L9;
        r12.add(r14);
        goto L4
    L9:
        r5.add(r14);
        goto L4
    L13:
        return new Pair(r5, r12);
    }

    public ParserATNSimulator(Parser r5, ATN r10, DFA[] r11, PredictionContextCache r12) {
        super(r10, r12);
        this.mode = PredictionMode.LL;
        this.parser = r5;
        this.decisionToDFA = r11;
    }

    public boolean evalSemanticContext(SemanticContext r5, ParserRuleContext r10, int r11, boolean r12) {
        return r5.eval(this.parser, r10);
    }
}
