package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.constraintlayout.motion.widget.a;

/* JADX INFO: loaded from: classes.dex */
public final class PrecedencePredicateTransition extends AbstractPredicateTransition {
    public final int precedence;

    public PrecedencePredicateTransition(ATNState r5, int r10) {
        super(r5);
        this.precedence = r10;
    }

    public SemanticContext.PrecedencePredicate getPredicate() {
        return new SemanticContext.PrecedencePredicate(this.precedence);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public int getSerializationType() {
        return 10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public boolean isEpsilon() {
        return true;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public boolean matches(int r5, int r10, int r11) {
        return false;
    }

    public String toString() {
        return a.s(new StringBuilder(), this.precedence, " >= _p");
    }
}
