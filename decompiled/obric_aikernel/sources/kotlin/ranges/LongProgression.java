package kotlin.ranges;

import java.util.Iterator;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public class LongProgression implements Iterable<Long>, KMappedMarker {
    public static final Companion Companion = null;
    private final long first;
    private final long last;
    private final long step;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final LongProgression fromClosedRange(long r10, long r11, long r12) {
            return new LongProgression(r10, r11, r12);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LongProgression(long r10, long r11, long r12) {
        if (r12 == 0) goto L11;
        if (r12 == Long.MIN_VALUE) goto L9;
        this.first = r10;
        this.last = ProgressionUtilKt.getProgressionLastElement(r10, r11, r12);
        this.step = r12;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof LongProgression) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        LongProgression r11 = (LongProgression) r10;
        if (this.first != r11.first) goto L15;
        if (this.last != r11.last) goto L15;
        if (this.step != r11.step) goto L15;
    L14:
        return true;
    L7:
        if (((LongProgression) r10).isEmpty() == true) goto L14;
        goto L8
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getLast() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        long r10 = 31;
        long r11 = this.first;
        long r12 = this.last;
        long r13 = r10 * (((r11 ^ (r11 >>> 32)) * r10) + (r12 ^ (r12 >>> 32)));
        long r14 = this.step;
        return (int) (r13 + (r14 ^ (r14 >>> 32)));
    }

    public boolean isEmpty() {
        long r10 = this.step;
        long r11 = this.first;
        long r12 = this.last;
        if (r10 <= 0) goto L6;
        if (r11 <= r12) goto L9;
        return true;
    L9:
        return false;
    L6:
        if (r11 >= r12) goto L9;
        return true;
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Long> iterator() {
        return iterator2();
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public Iterator<Long> iterator2() {
        return new LongProgressionIterator(this.first, this.last, this.step);
    }

    public String toString() {
        if (this.step <= 0) goto L5;
        StringBuilder r10 = new StringBuilder();
        r10.append(this.first);
        r10.append("..");
        r10.append(this.last);
        r10.append(" step ");
        long r11 = this.step;
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
