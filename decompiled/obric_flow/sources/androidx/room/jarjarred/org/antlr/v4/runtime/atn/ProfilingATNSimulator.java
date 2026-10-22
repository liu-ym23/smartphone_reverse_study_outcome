package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.Parser;
import androidx.room.jarjarred.org.antlr.v4.runtime.ParserRuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFA;
import androidx.room.jarjarred.org.antlr.v4.runtime.dfa.DFAState;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class ProfilingATNSimulator extends ParserATNSimulator {
    protected int _llStopIndex;
    protected int _sllStopIndex;
    protected int conflictingAltResolvedBySLL;
    protected int currentDecision;
    protected DFAState currentState;
    protected final DecisionInfo[] decisions;
    protected int numDecisions;

    public ProfilingATNSimulator(Parser r5) {
        super(r5, r5.getInterpreter().atn, r5.getInterpreter().decisionToDFA, r5.getInterpreter().sharedContextCache);
        int r10 = this.atn.decisionToState.size();
        this.numDecisions = r10;
        this.decisions = new DecisionInfo[r10];
        int r11 = 0;
    L4:
        if (r11 >= this.numDecisions) goto L6;
        this.decisions[r11] = new DecisionInfo(r11);
        r11 = r11 + 1;
        goto L4
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParserATNSimulator
    public int adaptivePredict(TokenStream r17, int r18, ParserRuleContext r19) {
        this._sllStopIndex = -1;     // Catch: Throwable -> L10
        this._llStopIndex = -1;     // Catch: Throwable -> L10
        this.currentDecision = r18;     // Catch: Throwable -> L10
        long r5 = System.nanoTime();     // Catch: Throwable -> L10
        int r11 = super.adaptivePredict(r17, r18, r19);     // Catch: Throwable -> L10
        long r10 = System.nanoTime();     // Catch: Throwable -> L10
        DecisionInfo r12 = this.decisions[r18];     // Catch: Throwable -> L10
        r12.timeInPrediction = (r10 - r5) + r12.timeInPrediction;     // Catch: Throwable -> L10
        r12.invocations++;     // Catch: Throwable -> L10
        long r13 = (this._sllStopIndex - this._startIndex) + 1;     // Catch: Throwable -> L10
        r12.SLL_TotalLook += r13;     // Catch: Throwable -> L10
        long r14 = r12.SLL_MinLook;     // Catch: Throwable -> L10
        if (r14 != 0) goto L6;
        long r15 = r13;
    L7:
        r12.SLL_MinLook = r15;     // Catch: Throwable -> L10
        DecisionInfo r16 = this.decisions[r18];     // Catch: Throwable -> L10
        if (r13 <= r16.SLL_MaxLook) goto L12;
        r16.SLL_MaxLook = r13;     // Catch: Throwable -> L10
        r16.SLL_MaxLookEvent = new LookaheadEventInfo(r18, null, r11, r17, this._startIndex, this._sllStopIndex, false);     // Catch: Throwable -> L10
    L12:
        int r20 = this._llStopIndex;     // Catch: Throwable -> L10
        if (r20 < 0) goto L21;
        int r21 = (r20 - this._startIndex) + 1;     // Catch: Throwable -> L10
        DecisionInfo r22 = this.decisions[r18];     // Catch: Throwable -> L10
        long r23 = r21;
        r22.LL_TotalLook += r23;     // Catch: Throwable -> L10
        long r24 = r22.LL_MinLook;     // Catch: Throwable -> L10
        if (r24 != 0) goto L17;
        long r25 = r23;
    L18:
        r22.LL_MinLook = r25;     // Catch: Throwable -> L10
        DecisionInfo r110 = this.decisions[r18];     // Catch: Throwable -> L10
        if (r23 <= r110.LL_MaxLook) goto L21;
        r110.LL_MaxLook = r23;     // Catch: Throwable -> L10
        r110.LL_MaxLookEvent = new LookaheadEventInfo(r18, null, r11, r17, this._startIndex, this._llStopIndex, true);     // Catch: Throwable -> L10
        goto L21
    L17:
        r25 = Math.min(r24, r23);     // Catch: Throwable -> L10
    L21:
        this.currentDecision = -1;
        return r11;
    L6:
        r15 = Math.min(r14, r13);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.currentDecision = -1;
        throw th;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParserATNSimulator
    public ATNConfigSet computeReachSet(ATNConfigSet r10, int r11, boolean r12) {
        if (r12 == false) goto L4;
        this._llStopIndex = this._input.index();
    L4:
        ATNConfigSet r13 = super.computeReachSet(r10, r11, r12);
        if (r12 == false) goto L10;
        DecisionInfo[] r14 = this.decisions;
        int r5 = this.currentDecision;
        DecisionInfo r15 = r14[r5];
        r15.LL_ATNTransitions++;
        if (r13 != null) goto L14;
        r15.errors.add(new ErrorInfo(r5, r10, this._input, this._startIndex, this._llStopIndex, true));
    L14:
        return r13;
    L10:
        DecisionInfo[] r16 = this.decisions;
        int r17 = this.currentDecision;
        DecisionInfo r18 = r16[r17];
        r18.SLL_ATNTransitions++;
        if (r13 != null) goto L14;
        r18.errors.add(new ErrorInfo(r17, r10, this._input, this._startIndex, this._sllStopIndex, false));
        goto L14
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParserATNSimulator
    public DFAState computeTargetState(DFA r5, DFAState r10, int r11) {
        DFAState r12 = super.computeTargetState(r5, r10, r11);
        this.currentState = r12;
        return r12;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParserATNSimulator
    public boolean evalSemanticContext(SemanticContext r12, ParserRuleContext r13, int r14, boolean r15) {
        boolean r16 = super.evalSemanticContext(r12, r13, r14, r15);
        if ((r12 instanceof SemanticContext.PrecedencePredicate) == true) goto L9;
        int r5 = this._llStopIndex;
        if (r5 < 0) goto L7;
    L6:
        int r10 = r5;
        DecisionInfo[] r11 = this.decisions;
        int r17 = this.currentDecision;
        r11[r17].predicateEvals.add(new PredicateEvalInfo(r17, this._input, this._startIndex, r10, r12, r16, r14, r15));
        goto L9
    L7:
        r5 = this._sllStopIndex;
    L9:
        return r16;
    }

    public DFAState getCurrentState() {
        return this.currentState;
    }

    public DecisionInfo[] getDecisionInfo() {
        return this.decisions;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParserATNSimulator
    public DFAState getExistingTargetState(DFAState r10, int r11) {
        this._sllStopIndex = this._input.index();
        DFAState r12 = super.getExistingTargetState(r10, r11);
        if (r12 == null) goto L7;
        DecisionInfo[] r5 = this.decisions;
        int r13 = this.currentDecision;
        DecisionInfo r14 = r5[r13];
        r14.SLL_DFATransitions++;
        if (r12 != ATNSimulator.ERROR) goto L7;
        r14.errors.add(new ErrorInfo(r13, r10.configs, this._input, this._startIndex, this._sllStopIndex, false));
    L7:
        this.currentState = r12;
        return r12;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParserATNSimulator
    public void reportAmbiguity(DFA r14, DFAState r15, int r16, int r17, boolean r18, BitSet r19, ATNConfigSet r20) {
        if (r19 == null) goto L5;
        int r5 = r19.nextSetBit(0);
    L7:
        if (r20.fullCtx == true) goto L9;
    L11:
        DecisionInfo[] r10 = this.decisions;
        int r11 = this.currentDecision;
        r10[r11].ambiguities.add(new AmbiguityInfo(r11, r20, r19, this._input, r16, r17, r20.fullCtx));
        super.reportAmbiguity(r14, r15, r16, r17, r18, r19, r20);
        return;
    L9:
        if (r5 == this.conflictingAltResolvedBySLL) goto L11;
        DecisionInfo[] r12 = this.decisions;
        int r13 = this.currentDecision;
        r12[r13].contextSensitivities.add(new ContextSensitivityInfo(r13, r20, this._input, r16, r17));
        goto L11
    L5:
        r5 = r20.getAlts().nextSetBit(0);
        goto L7
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParserATNSimulator
    public void reportAttemptingFullContext(DFA r10, BitSet r11, ATNConfigSet r12, int r13, int r14) {
        if (r11 == null) goto L5;
        this.conflictingAltResolvedBySLL = r11.nextSetBit(0);
    L6:
        this.decisions[this.currentDecision].LL_Fallback++;
        super.reportAttemptingFullContext(r10, r11, r12, r13, r14);
        return;
    L5:
        this.conflictingAltResolvedBySLL = r12.getAlts().nextSetBit(0);
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParserATNSimulator
    public void reportContextSensitivity(DFA r10, int r11, ATNConfigSet r12, int r13, int r14) {
        if (r11 == this.conflictingAltResolvedBySLL) goto L5;
        DecisionInfo[] r5 = this.decisions;
        int r15 = this.currentDecision;
        r5[r15].contextSensitivities.add(new ContextSensitivityInfo(r15, r12, this._input, r13, r14));
    L5:
        super.reportContextSensitivity(r10, r11, r12, r13, r14);
    }
}
