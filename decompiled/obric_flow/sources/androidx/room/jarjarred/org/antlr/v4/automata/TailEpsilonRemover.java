package androidx.room.jarjarred.org.antlr.v4.automata;

import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.BlockEndState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.EpsilonTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.PlusLoopbackState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.RuleTransition;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.StarLoopbackState;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition;

/* JADX INFO: loaded from: classes.dex */
public class TailEpsilonRemover extends ATNVisitor {
    private final ATN _atn;

    public TailEpsilonRemover(ATN r5) {
        this._atn = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.automata.ATNVisitor
    public void visitState(ATNState r10) {
        if (r10.getStateType() == 1) goto L5;
        return;
    L5:
        if (r10.getNumberOfTransitions() != 1) goto L28;
        ATNState r5 = r10.transition(0).target;
        if ((r10.transition(0) instanceof RuleTransition) == false) goto L10;
        r5 = ((RuleTransition) r10.transition(0)).followState;
    L10:
        if (r5.getStateType() != 1) goto L29;
        Transition r11 = r5.transition(0);
        if (r5.getNumberOfTransitions() == 1) goto L14;
        return;
    L14:
        if ((r11 instanceof EpsilonTransition) == false) goto L31;
        ATNState r12 = r11.target;
        if ((r12 instanceof BlockEndState) == true) goto L22;
        if ((r12 instanceof PlusLoopbackState) == true) goto L22;
        if ((r12 instanceof StarLoopbackState) == true) goto L22;
        return;
    L22:
        if ((r10.transition(0) instanceof RuleTransition) == false) goto L24;
        ((RuleTransition) r10.transition(0)).followState = r12;
    L25:
        this._atn.removeState(r5);
        return;
    L24:
        r10.transition(0).target = r12;
        goto L25
    L31:
        return;
    L29:
        return;
    }
}
