package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

/* JADX INFO: loaded from: classes.dex */
public final class RuleTransition extends Transition {
    public ATNState followState;
    public final int precedence;
    public final int ruleIndex;

    @Deprecated
    public RuleTransition(RuleStartState r5, int r10, ATNState r11) {
        this(r5, r10, 0, r11);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public int getSerializationType() {
        return 3;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public boolean isEpsilon() {
        return true;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public boolean matches(int r5, int r10, int r11) {
        return false;
    }

    public RuleTransition(RuleStartState r5, int r10, int r11, ATNState r12) {
        super(r5);
        this.ruleIndex = r10;
        this.precedence = r11;
        this.followState = r12;
    }
}
