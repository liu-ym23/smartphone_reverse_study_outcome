package kotlin.ranges;

import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.5")
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public class ULongProgression implements Iterable<ULong>, KMappedMarker {
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

        /* JADX INFO: renamed from: fromClosedRange-7ftBX0g, reason: not valid java name */
        public final ULongProgression m1276fromClosedRange7ftBX0g(long r10, long r11, long r13) {
            return new ULongProgression(r10, r11, r13, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private ULongProgression(long r10, long r11, long r12) {
        if (r12 == 0) goto L11;
        if (r12 == Long.MIN_VALUE) goto L9;
        this.first = r10;
        this.last = UProgressionUtilKt.m1250getProgressionLastElement7ftBX0g(r10, r11, r12);
        this.step = r12;
        return;
    L9:
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    L11:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public /* synthetic */ ULongProgression(long r10, long r11, long r12, DefaultConstructorMarker r13) {
        this(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof ULongProgression) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        ULongProgression r11 = (ULongProgression) r10;
        if (this.first != r11.first) goto L15;
        if (this.last != r11.last) goto L15;
        if (this.step != r11.step) goto L15;
    L14:
        return true;
    L7:
        if (((ULongProgression) r10).isEmpty() == true) goto L14;
        goto L8
    }

    /* JADX INFO: renamed from: getFirst-s-VKNKU, reason: not valid java name */
    public final long m1274getFirstsVKNKU() {
        return this.first;
    }

    /* JADX INFO: renamed from: getLast-s-VKNKU, reason: not valid java name */
    public final long m1275getLastsVKNKU() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        long r10 = this.first;
        int r11 = ((int) ULong.m206constructorimpl(r10 ^ ULong.m206constructorimpl(r10 >>> 32))) * 31;
        long r12 = this.last;
        int r13 = (r11 + ((int) ULong.m206constructorimpl(r12 ^ ULong.m206constructorimpl(r12 >>> 32)))) * 31;
        long r14 = this.step;
        return ((int) ((r14 >>> 32) ^ r14)) + r13;
    }

    public boolean isEmpty() {
        long r10 = this.step;
        int r11 = Long.compareUnsigned(this.first, this.last);
        if (r10 <= 0) goto L6;
        if (r11 <= 0) goto L9;
        return true;
    L9:
        return false;
    L6:
        if (r11 >= 0) goto L9;
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator<ULong> iterator() {
        return new ULongProgressionIterator(this.first, this.last, this.step, null);
    }

    public String toString() {
        if (this.step <= 0) goto L5;
        StringBuilder r10 = new StringBuilder();
        r10.append(ULong.m252toStringimpl(this.first));
        r10.append("..");
        r10.append(ULong.m252toStringimpl(this.last));
        r10.append(" step ");
        long r11 = this.step;
    L6:
        r10.append(r11);
        return r10.toString();
    L5:
        r10 = new StringBuilder();
        r10.append(ULong.m252toStringimpl(this.first));
        r10.append(" downTo ");
        r10.append(ULong.m252toStringimpl(this.last));
        r10.append(" step ");
        r11 = -this.step;
        goto L6
    }
}
