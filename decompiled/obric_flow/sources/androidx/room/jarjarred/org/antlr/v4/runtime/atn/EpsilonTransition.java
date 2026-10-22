package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

/* JADX INFO: loaded from: classes.dex */
public final class EpsilonTransition extends Transition {
    private final int outermostPrecedenceReturn;

    public EpsilonTransition(ATNState r5) {
        this(r5, -1);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public int getSerializationType() {
        return 1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public boolean isEpsilon() {
        return true;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public boolean matches(int r5, int r10, int r11) {
        return false;
    }

    public int outermostPrecedenceReturn() {
        return this.outermostPrecedenceReturn;
    }

    public String toString() {
        return "epsilon";
    }

    public EpsilonTransition(ATNState r5, int r10) {
        super(r5);
        this.outermostPrecedenceReturn = r10;
    }
}
