package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class CodePointTransitions {
    public CodePointTransitions() {
    }

    public static Transition createWithCodePoint(ATNState r5, int r10) {
        if (Character.isSupplementaryCodePoint(r10) == false) goto L7;
        return new SetTransition(r5, IntervalSet.of(r10));
    L7:
        return new AtomTransition(r5, r10);
    }

    public static Transition createWithCodePointRange(ATNState r5, int r10, int r11) {
        if (Character.isSupplementaryCodePoint(r10) == true) goto L10;
        if (Character.isSupplementaryCodePoint(r11) == true) goto L10;
        return new RangeTransition(r5, r10, r11);
    L10:
        return new SetTransition(r5, IntervalSet.of(r10, r11));
    }
}
