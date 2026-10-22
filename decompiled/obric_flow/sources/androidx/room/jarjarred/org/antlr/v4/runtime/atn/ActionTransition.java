package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

/* JADX INFO: loaded from: classes.dex */
public final class ActionTransition extends Transition {
    public final int actionIndex;
    public final boolean isCtxDependent;
    public final int ruleIndex;

    public ActionTransition(ATNState r5, int r10) {
        this(r5, r10, -1, false);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public int getSerializationType() {
        return 6;
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
        return "action_" + this.ruleIndex + ":" + this.actionIndex;
    }

    public ActionTransition(ATNState r5, int r10, int r11, boolean r12) {
        super(r5);
        this.ruleIndex = r10;
        this.actionIndex = r11;
        this.isCtxDependent = r12;
    }
}
