package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;

/* JADX INFO: loaded from: classes.dex */
public final class AtomTransition extends Transition {
    public final int label;

    public AtomTransition(ATNState r5, int r10) {
        super(r5);
        this.label = r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public int getSerializationType() {
        return 5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public IntervalSet label() {
        return IntervalSet.of(this.label);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public boolean matches(int r5, int r10, int r11) {
        if (this.label != r5) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return String.valueOf(this.label);
    }
}
