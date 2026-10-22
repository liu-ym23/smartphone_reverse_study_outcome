package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.5")
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class UInt implements Comparable<UInt> {
    public static final Companion Companion = null;
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ UInt(int r10) {
        this.data = r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: and-WZ4Q5Ns, reason: not valid java name */
    private static final int m120andWZ4Q5Ns(int r10, int r11) {
        return m127constructorimpl(r10 & r11);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UInt m121boximpl(int r10) {
        return new UInt(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m122compareTo7apg3OU(int r10, byte r11) {
        return Integer.compareUnsigned(r10, m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m123compareToVKZWuLQ(int r10, long r11) {
        return Long.compareUnsigned(ULong.m206constructorimpl(((long) r10) & 4294967295L), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private int m124compareToWZ4Q5Ns(int r10) {
        return UnsignedKt.uintCompare(m179unboximpl(), r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static int m125compareToWZ4Q5Ns(int r10, int r11) {
        return UnsignedKt.uintCompare(r10, r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m126compareToxj2QHRw(int r10, short r11) {
        return Integer.compareUnsigned(r10, m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m127constructorimpl(int r10) {
        return r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: dec-pVg5ArA, reason: not valid java name */
    private static final int m128decpVg5ArA(int r10) {
        return m127constructorimpl(r10 - 1);
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m129div7apg3OU(int r10, byte r11) {
        return Integer.divideUnsigned(r10, m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m130divVKZWuLQ(int r10, long r11) {
        return Long.divideUnsigned(ULong.m206constructorimpl(((long) r10) & 4294967295L), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m131divWZ4Q5Ns(int r10, int r11) {
        return UnsignedKt.m383uintDivideJ1ME1BU(r10, r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m132divxj2QHRw(int r10, short r11) {
        return Integer.divideUnsigned(r10, m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m133equalsimpl(int r10, Object r11) {
        if ((r11 instanceof UInt) == true) goto L6;
        return false;
    L6:
        if (r10 == ((UInt) r11).m179unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m134equalsimpl0(int r10, int r11) {
        if (r10 != r11) goto L4;
        return true;
    L4:
        return false;
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m135floorDiv7apg3OU(int r10, byte r11) {
        return Integer.divideUnsigned(r10, m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m136floorDivVKZWuLQ(int r10, long r11) {
        return Long.divideUnsigned(ULong.m206constructorimpl(((long) r10) & 4294967295L), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m137floorDivWZ4Q5Ns(int r10, int r11) {
        return Integer.divideUnsigned(r10, r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m138floorDivxj2QHRw(int r10, short r11) {
        return Integer.divideUnsigned(r10, m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m139hashCodeimpl(int r10) {
        return Integer.hashCode(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: inc-pVg5ArA, reason: not valid java name */
    private static final int m140incpVg5ArA(int r10) {
        return m127constructorimpl(r10 + 1);
    }

    @InlineOnly
    /* JADX INFO: renamed from: inv-pVg5ArA, reason: not valid java name */
    private static final int m141invpVg5ArA(int r10) {
        return m127constructorimpl(~r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m142minus7apg3OU(int r10, byte r11) {
        return m127constructorimpl(r10 - m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m143minusVKZWuLQ(int r10, long r11) {
        return ULong.m206constructorimpl(ULong.m206constructorimpl(((long) r10) & 4294967295L) - r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m144minusWZ4Q5Ns(int r10, int r11) {
        return m127constructorimpl(r10 - r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m145minusxj2QHRw(int r10, short r11) {
        return m127constructorimpl(r10 - m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m146mod7apg3OU(int r10, byte r11) {
        return UByte.m50constructorimpl((byte) Integer.remainderUnsigned(r10, m127constructorimpl(r11 & 255)));
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m147modVKZWuLQ(int r10, long r11) {
        return Long.remainderUnsigned(ULong.m206constructorimpl(((long) r10) & 4294967295L), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m148modWZ4Q5Ns(int r10, int r11) {
        return Integer.remainderUnsigned(r10, r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m149modxj2QHRw(int r10, short r11) {
        return UShort.m313constructorimpl((short) Integer.remainderUnsigned(r10, m127constructorimpl(r11 & UShort.MAX_VALUE)));
    }

    @InlineOnly
    /* JADX INFO: renamed from: or-WZ4Q5Ns, reason: not valid java name */
    private static final int m150orWZ4Q5Ns(int r10, int r11) {
        return m127constructorimpl(r10 | r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m151plus7apg3OU(int r10, byte r11) {
        return m127constructorimpl(r10 + m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m152plusVKZWuLQ(int r10, long r11) {
        return ULong.m206constructorimpl(ULong.m206constructorimpl(((long) r10) & 4294967295L) + r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m153plusWZ4Q5Ns(int r10, int r11) {
        return m127constructorimpl(r10 + r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m154plusxj2QHRw(int r10, short r11) {
        return m127constructorimpl(r10 + m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: rangeTo-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m155rangeToWZ4Q5Ns(int r10, int r11) {
        return new UIntRange(r10, r11, null);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* JADX INFO: renamed from: rangeUntil-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m156rangeUntilWZ4Q5Ns(int r10, int r11) {
        return URangesKt.m1283untilJ1ME1BU(r10, r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m157rem7apg3OU(int r10, byte r11) {
        return Integer.remainderUnsigned(r10, m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m158remVKZWuLQ(int r10, long r11) {
        return Long.remainderUnsigned(ULong.m206constructorimpl(((long) r10) & 4294967295L), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m159remWZ4Q5Ns(int r10, int r11) {
        return UnsignedKt.m384uintRemainderJ1ME1BU(r10, r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m160remxj2QHRw(int r10, short r11) {
        return Integer.remainderUnsigned(r10, m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: shl-pVg5ArA, reason: not valid java name */
    private static final int m161shlpVg5ArA(int r10, int r11) {
        return m127constructorimpl(r10 << r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: shr-pVg5ArA, reason: not valid java name */
    private static final int m162shrpVg5ArA(int r10, int r11) {
        return m127constructorimpl(r10 >>> r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m163times7apg3OU(int r10, byte r11) {
        return m127constructorimpl(r10 * m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m164timesVKZWuLQ(int r10, long r11) {
        return ULong.m206constructorimpl(ULong.m206constructorimpl(((long) r10) & 4294967295L) * r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m165timesWZ4Q5Ns(int r10, int r11) {
        return m127constructorimpl(r10 * r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m166timesxj2QHRw(int r10, short r11) {
        return m127constructorimpl(r10 * m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m167toByteimpl(int r10) {
        return (byte) r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m168toDoubleimpl(int r10) {
        return UnsignedKt.uintToDouble(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m169toFloatimpl(int r10) {
        return (float) UnsignedKt.uintToDouble(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m170toIntimpl(int r10) {
        return r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m171toLongimpl(int r10) {
        return ((long) r10) & 4294967295L;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m172toShortimpl(int r10) {
        return (short) r10;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m173toStringimpl(int r10) {
        return String.valueOf(((long) r10) & 4294967295L);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m174toUBytew2LRezQ(int r10) {
        return UByte.m50constructorimpl((byte) r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m175toUIntpVg5ArA(int r10) {
        return r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m176toULongsVKNKU(int r10) {
        return ULong.m206constructorimpl(((long) r10) & 4294967295L);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m177toUShortMh2AYeg(int r10) {
        return UShort.m313constructorimpl((short) r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: xor-WZ4Q5Ns, reason: not valid java name */
    private static final int m178xorWZ4Q5Ns(int r10, int r11) {
        return m127constructorimpl(r10 ^ r11);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt r10) {
        int r11 = r10.m179unboximpl();
        return UnsignedKt.uintCompare(m179unboximpl(), r11);
    }

    public boolean equals(Object r10) {
        return m133equalsimpl(this.data, r10);
    }

    public int hashCode() {
        return m139hashCodeimpl(this.data);
    }

    public String toString() {
        return m173toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m179unboximpl() {
        return this.data;
    }
}
