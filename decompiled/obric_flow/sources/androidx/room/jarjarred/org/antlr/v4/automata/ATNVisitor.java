package androidx.room.jarjarred.org.antlr.v4.automata;

import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNState;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ATNVisitor {
    public ATNVisitor() {
    }

    public void visit(ATNState r5) {
        visit_(r5, new HashSet());
    }

    public void visitState(ATNState r5) {
    }

    public void visit_(ATNState r5, Set<Integer> r10) {
        if (r10.add(Integer.valueOf(r5.stateNumber)) == true) goto L5;
        return;
    L5:
        r10.add(Integer.valueOf(r5.stateNumber));
        visitState(r5);
        int r11 = r5.getNumberOfTransitions();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L8;
        visit_(r5.transition(r12).target, r10);
        r12 = r12 + 1;
        goto L6
    }
}
