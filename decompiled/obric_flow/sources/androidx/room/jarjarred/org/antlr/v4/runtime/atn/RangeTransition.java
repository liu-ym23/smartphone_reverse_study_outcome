package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;

/* JADX INFO: loaded from: classes.dex */
public final class RangeTransition extends Transition {
    public final int from;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    public final int f661to;

    public RangeTransition(ATNState r5, int r10, int r11) {
        super(r5);
        this.from = r10;
        this.f661to = r11;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public int getSerializationType() {
        return 2;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public IntervalSet label() {
        return IntervalSet.of(this.from, this.f661to);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.runtime.atn.Transition
    public boolean matches(int r5, int r10, int r11) {
        if (r5 >= this.from) goto L5;
    L7:
        return false;
    L5:
        if (r5 > this.f661to) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("'").appendCodePoint(this.from);
        r5.append("'..'");
        StringBuilder r10 = r5.appendCodePoint(this.f661to);
        r10.append("'");
        return r10.toString();
    }
}
