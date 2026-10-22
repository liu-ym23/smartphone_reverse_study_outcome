package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public Triple(A r10, B r11, C r12) {
        this.first = r10;
        this.second = r11;
        this.third = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Triple copy$default(Triple r10, Object r11, Object r12, Object r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.first;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.second;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.third;
    L12:
        return r10.copy(r11, r12, r13);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final Triple<A, B, C> copy(A r10, B r11, C r12) {
        return new Triple(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Triple) == true) goto L8;
        return false;
    L8:
        Triple r11 = (Triple) r10;
        if (Intrinsics.areEqual(this.first, r11.first) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.second, r11.second) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.third, r11.third) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A r10 = this.first;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        B r14 = this.second;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        C r17 = this.third;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ", " + this.third + ')';
    }
}
