package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A r10, B r11) {
        this.first = r10;
        this.second = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair copy$default(Pair r10, Object r11, Object r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.first;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.second;
    L9:
        return r10.copy(r11, r12);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final Pair<A, B> copy(A r10, B r11) {
        return new Pair(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Pair) == true) goto L8;
        return false;
    L8:
        Pair r11 = (Pair) r10;
        if (Intrinsics.areEqual(this.first, r11.first) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.second, r11.second) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A r10 = this.first;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        B r14 = this.second;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
