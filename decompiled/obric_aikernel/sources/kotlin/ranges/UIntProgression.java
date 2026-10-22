package kotlin.ranges;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.5")
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public class UIntProgression implements Iterable<UInt>, KMappedMarker {
    public static final Companion Companion = null;
    private final int first;
    private final int last;
    private final int step;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        /* JADX INFO: renamed from: fromClosedRange-Nkh28Cs, reason: not valid java name */
        public final UIntProgression m1267fromClosedRangeNkh28Cs(int r10, int r11, int r12) {
            return new UIntProgression(r10, r11, r12, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private UIntProgression(int r10, int r11, int r12) {
        if (r12 == 0) goto L11;
        if (r12 == Integer.MIN_VALUE) goto L9;
        this.first = r10;
        this.last = UProgressionUtilKt.m1251getProgressionLastElementNkh28Cs(r10, r11, r12);
        this.step = r12;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public /* synthetic */ UIntProgression(int r10, int r11, int r12, DefaultConstructorMarker r13) {
        this(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof UIntProgression) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        UIntProgression r11 = (UIntProgression) r10;
        if (this.first != r11.first) goto L15;
        if (this.last != r11.last) goto L15;
        if (this.step != r11.step) goto L15;
    L14:
        return true;
    L7:
        if (((UIntProgression) r10).isEmpty() == true) goto L14;
        goto L8
    }

    /* JADX INFO: renamed from: getFirst-pVg5ArA, reason: not valid java name */
    public final int m1265getFirstpVg5ArA() {
        return this.first;
    }

    /* JADX INFO: renamed from: getLast-pVg5ArA, reason: not valid java name */
    public final int m1266getLastpVg5ArA() {
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
        if (Integer.compareUnsigned(this.first, this.last) <= 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        if (Integer.compareUnsigned(this.first, this.last) >= 0) goto L11;
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator<UInt> iterator() {
        return new UIntProgressionIterator(this.first, this.last, this.step, null);
    }

    public String toString() {
        if (this.step <= 0) goto L5;
        StringBuilder r10 = new StringBuilder();
        r10.append(UInt.m173toStringimpl(this.first));
        r10.append("..");
        r10.append(UInt.m173toStringimpl(this.last));
        r10.append(" step ");
        int r11 = this.step;
    L6:
        r10.append(r11);
        return r10.toString();
    L5:
        r10 = new StringBuilder();
        r10.append(UInt.m173toStringimpl(this.first));
        r10.append(" downTo ");
        r10.append(UInt.m173toStringimpl(this.last));
        r10.append(" step ");
        r11 = -this.step;
        goto L6
    }
}
