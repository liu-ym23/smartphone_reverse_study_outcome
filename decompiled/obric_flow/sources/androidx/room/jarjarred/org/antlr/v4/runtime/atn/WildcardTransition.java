package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

/* JADX INFO: loaded from: classes.dex */
public final class WildcardTransition extends Transition {
    public WildcardTransition(ATNState r5) {
        super(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public int getSerializationType() {
        return 9;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public boolean matches(int r5, int r10, int r11) {
        if (r5 < r10) goto L5;
        if (r5 > r11) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return ".";
    }
}
