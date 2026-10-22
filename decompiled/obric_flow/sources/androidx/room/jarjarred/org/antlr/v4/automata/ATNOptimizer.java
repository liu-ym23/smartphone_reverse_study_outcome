package androidx.room.jarjarred.org.antlr.v4.automata;

import androidx.room.jarjarred.org.antlr.v4.misc.CharSupport;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.AtomTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.BlockEndState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.CodePointTransitions;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.DecisionState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.EpsilonTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.NotSetTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RangeTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.SetTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Interval;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ATNOptimizer {
    private ATNOptimizer() {
    }

    public static void optimize(Grammar r5, ATN r10) {
        optimizeSets(r5, r10);
        optimizeStates(r10);
    }

    private static void optimizeSets(Grammar r19, ATN r20) {
        Grammar r5 = r19;
        if (r19.isParser() == false) goto L5;
        return;
    L5:
        Iterator<DecisionState> r10 = r20.decisionToState.iterator();
    L7:
        if (r10.hasNext() == false) goto L74;
        DecisionState r11 = r10.next();
        int r12 = r11.ruleIndex;
        int r13 = 0;
        if (r12 < 0) goto L13;
        if (Character.isLowerCase(r5.getRule(r12).name.charAt(0)) == true) goto L7;
    L13:
        IntervalSet r14 = new IntervalSet(new int[0]);
        int r15 = 0;
    L14:
        int r16 = 1;
        if (r15 >= r11.getNumberOfTransitions()) goto L36;
        Transition r17 = r11.transition(r15);
        if ((r17 instanceof EpsilonTransition) == false) goto L35;
        if (r17.target.getNumberOfTransitions() != 1) goto L35;
        Transition r18 = r17.target.transition(0);
        if ((r18.target instanceof BlockEndState) == false) goto L35;
        if ((r18 instanceof NotSetTransition) == true) goto L35;
        if ((r18 instanceof AtomTransition) == false) goto L31;
    L34:
        r14.add(r15);
        goto L35
    L31:
        if ((r18 instanceof RangeTransition) == true) goto L34;
        if ((r18 instanceof SetTransition) == true) goto L34;
    L35:
        r15 = r15 + 1;
        goto L14
    L36:
        int r21 = r14.getIntervals().size() - 1;
    L37:
        if (r21 < 0) goto L73;
        Interval r22 = r14.getIntervals().get(r21);
        if (r22.length() > r16) goto L41;
        Iterator<DecisionState> r110 = r10;
        IntervalSet r111 = r14;
        int r23 = r13;
        int r24 = r16;
    L72:
        r21 = r21 - 1;
        r5 = r19;
        r16 = r24;
        r13 = r23;
        r10 = r110;
        r14 = r111;
        goto L37
    L41:
        ATNState r25 = r11.transition(r22.f665a).target.transition(r13).target;
        IntervalSet r112 = new IntervalSet(new int[r13]);
        int r113 = r22.f665a;
    L43:
        if (r113 > r22.f666b) goto L61;
        Transition r114 = r11.transition(r113).target.transition(r13);
        if ((r114 instanceof NotSetTransition) == true) goto L60;
        IntervalSet r115 = r114.label();
        List<Interval> r116 = r115.getIntervals();
        int r117 = r116.size();
        int r118 = r13;
    L47:
        if (r118 >= r117) goto L58;
        Interval r26 = r116.get(r118);
        int r27 = r26.f665a;
        int r28 = r26.f666b;
        Iterator<DecisionState> r119 = r10;
        if (r27 == (-1)) goto L57;
        if (r28 == (-1)) goto L57;
    L51:
        if (r27 > r28) goto L57;
        if (r112.contains(r27) == true) goto L54;
        r27 = r27 + 1;
        r5 = r19;
        goto L51
    L54:
        r5.tool.errMgr.grammarError(ErrorType.CHARACTERS_COLLISION_IN_SET, r5.fileName, null, new Object[]{CharSupport.getANTLRCharLiteralForChar(r27), CharSupport.getIntervalSetEscapedString(r112)});
    L57:
        r118 = r118 + 1;
        r5 = r19;
        r10 = r119;
        r14 = r14;
        goto L47
    L58:
        r112.addAll(r115);
        r113 = r113 + 1;
        r13 = 0;
        r5 = r19;
        goto L43
    L60:
        throw new UnsupportedOperationException("Not yet implemented.");
    L61:
        r110 = r10;
        r111 = r14;
        if (r112.getIntervals().size() == 1) goto L64;
        Transition r29 = new SetTransition(r25, r112);
    L68:
        r23 = 0;
        r11.transition(r22.f665a).target.setTransition(0, r29);
        r24 = 1;
        int r30 = r22.f665a + 1;
    L70:
        if (r30 > r22.f666b) goto L72;
        r20.removeState(r11.removeTransition(r22.f665a + 1).target);
        r30 = r30 + 1;
        goto L70
    L64:
        if (r112.size() != 1) goto L66;
        r29 = CodePointTransitions.createWithCodePoint(r25, r112.getMinElement());
        goto L68
    L66:
        Interval r31 = r112.getIntervals().get(0);
        r29 = CodePointTransitions.createWithCodePointRange(r25, r31.f665a, r31.f666b);
        goto L68
    L73:
        r5 = r19;
        goto L7
    }

    private static void optimizeStates(ATN r5) {
        ArrayList r10 = new ArrayList();
        Iterator<ATNState> r11 = r5.states.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        ATNState r13 = r11.next();
        if (r13 == null) goto L4;
        r10.add(r13);
        r13.stateNumber = r12;
        r12 = r12 + 1;
        goto L4
    L8:
        r5.states.clear();
        r5.states.addAll(r10);
    }
}
