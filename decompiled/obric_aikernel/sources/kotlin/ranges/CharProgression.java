package kotlin.ranges;

import java.util.Iterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public class CharProgression implements Iterable<Character>, KMappedMarker {
    public static final Companion Companion = null;
    private final char first;
    private final char last;
    private final int step;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final CharProgression fromClosedRange(char r10, char r11, int r12) {
            return new CharProgression(r10, r11, r12);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CharProgression(char r10, char r11, int r12) {
        if (r12 == 0) goto L11;
        if (r12 == Integer.MIN_VALUE) goto L9;
        this.first = r10;
        this.last = (char) ProgressionUtilKt.getProgressionLastElement(r10, r11, r12);
        this.step = r12;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof CharProgression) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        CharProgression r11 = (CharProgression) r10;
        if (this.first != r11.first) goto L15;
        if (this.last != r11.last) goto L15;
        if (this.step != r11.step) goto L15;
    L14:
        return true;
    L7:
        if (((CharProgression) r10).isEmpty() == true) goto L14;
        goto L8
    }

    public final char getFirst() {
        return this.first;
    }

    public final char getLast() {
        return this.last;
    }

    public final int getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r10 = ((this.first * 31) + this.last) * 31;
        return this.step + r10;
    }

    public boolean isEmpty() {
        if (this.step <= 0) goto L8;
        if (Intrinsics.compare(this.first, this.last) <= 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (Intrinsics.compare(this.first, this.last) >= 0) goto L11;
        return true;
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Character> iterator() {
        return iterator2();
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Character> iterator2() {
        return new CharProgressionIterator(this.first, this.last, this.step);
    }

    public String toString() {
        if (this.step <= 0) goto L5;
        StringBuilder r10 = new StringBuilder();
        r10.append(this.first);
        r10.append("..");
        r10.append(this.last);
        r10.append(" step ");
        int r11 = this.step;
    L6:
        r10.append(r11);
        return r10.toString();
    L5:
        r10 = new StringBuilder();
        r10.append(this.first);
        r10.append(" downTo ");
        r10.append(this.last);
        r10.append(" step ");
        r11 = -this.step;
        goto L6
    }
}
