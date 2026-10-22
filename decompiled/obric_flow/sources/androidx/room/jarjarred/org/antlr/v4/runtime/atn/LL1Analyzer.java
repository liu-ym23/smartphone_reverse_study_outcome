package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.RuleContext;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LL1Analyzer {
    public static final int HIT_PRED = 0;
    public final ATN atn;

    public LL1Analyzer(ATN r5) {
        this.atn = r5;
    }

    public IntervalSet LOOK(ATNState r5, RuleContext r10) {
        return LOOK(r5, null, r10);
    }

    public void _LOOK(ATNState r20, ATNState r21, PredictionContext r22, IntervalSet r23, Set<ATNConfig> r24, BitSet r25, boolean r26, boolean r27) {
        int r14 = 0;
        if (r24.add(new ATNConfig(r20, 0, r22)) == true) goto L6;
        return;
    L6:
        if (r20 != r21) goto L16;
        if (r22 != null) goto L11;
        r23.add(-2);
        return;
    L11:
        if (r22.isEmpty() == false) goto L16;
        if (r27 == false) goto L16;
        r23.add(-1);
        return;
    L16:
        if ((r20 instanceof RuleStopState) == false) goto L41;
        if (r22 != null) goto L21;
        r23.add(-2);
        return;
    L21:
        if (r22.isEmpty() == false) goto L26;
        if (r27 == false) goto L26;
        r23.add(-1);
        return;
    L26:
        if (r22 == PredictionContext.EMPTY) goto L41;
        boolean r16 = r25.get(r20.ruleIndex);
        r25.clear(r20.ruleIndex);     // Catch: Throwable -> L33
    L30:
        if (r14 >= r22.size()) goto L35;
        _LOOK(this.atn.states.get(r22.getReturnState(r14)), r21, r22.getParent(r14), r23, r24, r25, r26, r27);     // Catch: Throwable -> L33
        r14 = r14 + 1;
        goto L30
    L35:
        if (r16 == false) goto L94;
        r25.set(r20.ruleIndex);
        return;
    L94:
        return;
    L33:
        th = move-exception;
        if (r16 == false) goto L40;
        r25.set(r20.ruleIndex);
    L40:
        throw th;
    L41:
        int r10 = r20.getNumberOfTransitions();
        int r11 = 0;
    L42:
        if (r11 >= r10) goto L78;
        Transition r5 = r20.transition(r11);
        if (r5.getClass() != RuleTransition.class) goto L60;
        RuleTransition r12 = (RuleTransition) r5;
        if (r25.get(r12.target.ruleIndex) == false) goto L48;
        int r17 = r11;
        int r18 = r10;
    L77:
        r11 = r17 + 1;
        r10 = r18;
        goto L42
    L48:
        SingletonPredictionContext r13 = SingletonPredictionContext.create(r22, r12.followState.stateNumber);
        r25.set(((RuleTransition) r5).target.ruleIndex);     // Catch: Throwable -> L56
        RuleTransition r15 = r12;
        r17 = r11;
        r18 = r10;
        _LOOK(r5.target, r21, r13, r23, r24, r25, r26, r27);     // Catch: Throwable -> L54
        r25.clear(r15.target.ruleIndex);
    L54:
        th = th;
    L58:
        r25.clear(r15.target.ruleIndex);
        throw th;
    L56:
        th = th;
        r15 = r12;
        goto L58
    L60:
        r17 = r11;
        r18 = r10;
        if ((r5 instanceof AbstractPredicateTransition) == false) goto L66;
        if (r26 == false) goto L64;
        _LOOK(r5.target, r21, r22, r23, r24, r25, r26, r27);
        goto L77
    L64:
        r23.add(0);
        goto L77
    L66:
        if (r5.isEpsilon() == false) goto L69;
        _LOOK(r5.target, r21, r22, r23, r24, r25, r26, r27);
        goto L77
    L69:
        if (r5.getClass() != WildcardTransition.class) goto L71;
        r23.addAll(IntervalSet.of(1, this.atn.maxTokenType));
        goto L77
    L71:
        IntervalSet r19 = r5.label();
        if (r19 == null) goto L77;
        if ((r5 instanceof NotSetTransition) == false) goto L76;
        r19 = r19.complement(IntervalSet.of(1, this.atn.maxTokenType));
    L76:
        r23.addAll(r19);
        goto L77
    }

    public IntervalSet[] getDecisionLookahead(ATNState r17) {
        if (r17 != null) goto L5;
        return null;
    L5:
        IntervalSet[] r5 = new IntervalSet[r17.getNumberOfTransitions()];
        int r10 = 0;
    L7:
        if (r10 >= r17.getNumberOfTransitions()) goto L14;
        r5[r10] = new IntervalSet(new int[0]);
        _LOOK(r17.transition(r10).target, null, PredictionContext.EMPTY, r5[r10], new HashSet(), new BitSet(), false, false);
        if (r5[r10].size() != 0) goto L11;
    L12:
        r5[r10] = null;
    L13:
        r10 = r10 + 1;
        goto L7
    L11:
        if (r5[r10].contains(0) == false) goto L13;
    L14:
        return r5;
    }

    public IntervalSet LOOK(ATNState r11, ATNState r12, RuleContext r13) {
        IntervalSet r10 = new IntervalSet(new int[0]);
        if (r13 == null) goto L6;
        PredictionContext r14 = PredictionContext.fromRuleContext(r11.atn, r13);
    L5:
        PredictionContext r5 = r14;
        _LOOK(r11, r12, r5, r10, new HashSet(), new BitSet(), true, true);
        return r10;
    L6:
        r14 = null;
        goto L5
    }
}
