package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

/* JADX INFO: loaded from: classes.dex */
public final class PredicateTransition extends AbstractPredicateTransition {
    public final boolean isCtxDependent;
    public final int predIndex;
    public final int ruleIndex;

    public PredicateTransition(ATNState r5, int r10, int r11, boolean r12) {
        super(r5);
        this.ruleIndex = r10;
        this.predIndex = r11;
        this.isCtxDependent = r12;
    }

    public SemanticContext.Predicate getPredicate() {
        return new SemanticContext.Predicate(this.ruleIndex, this.predIndex, this.isCtxDependent);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public int getSerializationType() {
        return 4;
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
        return "pred_" + this.ruleIndex + ":" + this.predIndex;
    }
}
