package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;

/* JADX INFO: loaded from: classes.dex */
public final class NotSetTransition extends SetTransition {
    public NotSetTransition(ATNState r5, IntervalSet r10) {
        super(r5, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SetTransition, androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public int getSerializationType() {
        return 8;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SetTransition, androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public boolean matches(int r5, int r10, int r11) {
        if (r5 < r10) goto L7;
        if (r5 > r11) goto L7;
        if (super.matches(r5, r10, r11) == true) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.SetTransition
    public String toString() {
        return "~" + super.toString();
    }
}
