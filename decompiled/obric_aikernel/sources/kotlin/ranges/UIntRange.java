package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.WasExperimental;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@SinceKotlin(version = "1.5")
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class UIntRange extends UIntProgression implements ClosedRange<UInt>, OpenEndRange<UInt> {
    public static final Companion Companion = null;
    private static final UIntRange EMPTY = null;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final UIntRange getEMPTY() {
            return UIntRange.access$getEMPTY$cp();
        }
    }

    static {
        DefaultConstructorMarker r10 = null;
        Companion = new Companion(r10);
        EMPTY = new UIntRange(-1, 0, r10);
    }

    private UIntRange(int r10, int r11) {
        super(r10, r11, 1, null);
    }

    public /* synthetic */ UIntRange(int r10, int r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public static final /* synthetic */ UIntRange access$getEMPTY$cp() {
        return EMPTY;
    }

    @Deprecated(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    /* JADX INFO: renamed from: getEndExclusive-pVg5ArA$annotations, reason: not valid java name */
    public static /* synthetic */ void m1269getEndExclusivepVg5ArA$annotations() {
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable r10) {
        return m1270containsWZ4Q5Ns(((UInt) r10).m179unboximpl());
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m1270containsWZ4Q5Ns(int r10) {
        if (Integer.compareUnsigned(m1265getFirstpVg5ArA(), r10) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (Integer.compareUnsigned(r10, m1266getLastpVg5ArA()) > 0) goto L7;
        return true;
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean equals(Object r10) {
        if ((r10 instanceof UIntRange) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        UIntRange r11 = (UIntRange) r10;
        if (m1265getFirstpVg5ArA() != r11.m1265getFirstpVg5ArA()) goto L13;
        if (m1266getLastpVg5ArA() != r11.m1266getLastpVg5ArA()) goto L13;
    L12:
        return true;
    L7:
        if (((UIntRange) r10).isEmpty() == true) goto L12;
        goto L8
    }

    @Override // kotlin.ranges.OpenEndRange
    public /* bridge */ /* synthetic */ Comparable getEndExclusive() {
        return UInt.m121boximpl(m1271getEndExclusivepVg5ArA());
    }

    /* JADX INFO: renamed from: getEndExclusive-pVg5ArA, reason: not valid java name */
    public int m1271getEndExclusivepVg5ArA() {
        if (m1266getLastpVg5ArA() == (-1)) goto L7;
        return UInt.m127constructorimpl(m1266getLastpVg5ArA() + 1);
    L7:
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getEndInclusive() {
        return UInt.m121boximpl(m1272getEndInclusivepVg5ArA());
    }

    /* JADX INFO: renamed from: getEndInclusive-pVg5ArA, reason: not valid java name */
    public int m1272getEndInclusivepVg5ArA() {
        return m1266getLastpVg5ArA();
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return UInt.m121boximpl(m1273getStartpVg5ArA());
    }

    /* JADX INFO: renamed from: getStart-pVg5ArA, reason: not valid java name */
    public int m1273getStartpVg5ArA() {
        return m1265getFirstpVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression
    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r10 = m1265getFirstpVg5ArA() * 31;
        return m1266getLastpVg5ArA() + r10;
    }

    @Override // kotlin.ranges.UIntProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (Integer.compareUnsigned(m1265getFirstpVg5ArA(), m1266getLastpVg5ArA()) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.ranges.UIntProgression
    public String toString() {
        return UInt.m173toStringimpl(m1265getFirstpVg5ArA()) + ".." + UInt.m173toStringimpl(m1266getLastpVg5ArA());
    }
}
