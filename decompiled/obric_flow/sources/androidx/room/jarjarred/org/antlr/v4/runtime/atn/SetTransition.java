package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;

/* JADX INFO: loaded from: classes.dex */
public class SetTransition extends Transition {
    public final IntervalSet set;

    public SetTransition(ATNState r5, IntervalSet r10) {
        super(r5);
        if (r10 != null) goto L5;
        r10 = IntervalSet.of(0);
    L5:
        this.set = r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public int getSerializationType() {
        return 7;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public IntervalSet label() {
        return this.set;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public boolean matches(int r5, int r10, int r11) {
        return this.set.contains(r5);
    }

    public String toString() {
        return this.set.toString();
    }
}
