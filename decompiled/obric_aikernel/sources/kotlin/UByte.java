package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.5")
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = null;
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

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
    private /* synthetic */ UByte(byte r10) {
        this.data = r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: and-7apg3OU, reason: not valid java name */
    private static final byte m43and7apg3OU(byte r10, byte r11) {
        return m50constructorimpl((byte) (r10 & r11));
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByte m44boximpl(byte r10) {
        return new UByte(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private int m45compareTo7apg3OU(byte r10) {
        return Intrinsics.compare(m100unboximpl() & 255, r10 & 255);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static int m46compareTo7apg3OU(byte r10, byte r11) {
        return Intrinsics.compare(r10 & 255, r11 & 255);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m47compareToVKZWuLQ(byte r10, long r11) {
        return Long.compareUnsigned(ULong.m206constructorimpl(((long) r10) & 255), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m48compareToWZ4Q5Ns(byte r10, int r11) {
        return Integer.compareUnsigned(UInt.m127constructorimpl(r10 & 255), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m49compareToxj2QHRw(byte r10, short r11) {
        return Intrinsics.compare(r10 & 255, r11 & UShort.MAX_VALUE);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte m50constructorimpl(byte r10) {
        return r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: dec-w2LRezQ, reason: not valid java name */
    private static final byte m51decw2LRezQ(byte r10) {
        return m50constructorimpl((byte) (r10 - 1));
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m52div7apg3OU(byte r10, byte r11) {
        return Integer.divideUnsigned(UInt.m127constructorimpl(r10 & 255), UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m53divVKZWuLQ(byte r10, long r11) {
        return Long.divideUnsigned(ULong.m206constructorimpl(((long) r10) & 255), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m54divWZ4Q5Ns(byte r10, int r11) {
        return Integer.divideUnsigned(UInt.m127constructorimpl(r10 & 255), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m55divxj2QHRw(byte r10, short r11) {
        return Integer.divideUnsigned(UInt.m127constructorimpl(r10 & 255), UInt.m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m56equalsimpl(byte r10, Object r11) {
        if ((r11 instanceof UByte) == true) goto L6;
        return false;
    L6:
        if (r10 == ((UByte) r11).m100unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m57equalsimpl0(byte r10, byte r11) {
        if (r10 != r11) goto L4;
        return true;
    L4:
        return false;
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m58floorDiv7apg3OU(byte r10, byte r11) {
        return Integer.divideUnsigned(UInt.m127constructorimpl(r10 & 255), UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m59floorDivVKZWuLQ(byte r10, long r11) {
        return Long.divideUnsigned(ULong.m206constructorimpl(((long) r10) & 255), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m60floorDivWZ4Q5Ns(byte r10, int r11) {
        return Integer.divideUnsigned(UInt.m127constructorimpl(r10 & 255), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m61floorDivxj2QHRw(byte r10, short r11) {
        return Integer.divideUnsigned(UInt.m127constructorimpl(r10 & 255), UInt.m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m62hashCodeimpl(byte r10) {
        return Byte.hashCode(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: inc-w2LRezQ, reason: not valid java name */
    private static final byte m63incw2LRezQ(byte r10) {
        return m50constructorimpl((byte) (r10 + 1));
    }

    @InlineOnly
    /* JADX INFO: renamed from: inv-w2LRezQ, reason: not valid java name */
    private static final byte m64invw2LRezQ(byte r10) {
        return m50constructorimpl((byte) (~r10));
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m65minus7apg3OU(byte r10, byte r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & 255) - UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m66minusVKZWuLQ(byte r10, long r11) {
        return ULong.m206constructorimpl(ULong.m206constructorimpl(((long) r10) & 255) - r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m67minusWZ4Q5Ns(byte r10, int r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & 255) - r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m68minusxj2QHRw(byte r10, short r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & 255) - UInt.m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m69mod7apg3OU(byte r10, byte r11) {
        return m50constructorimpl((byte) Integer.remainderUnsigned(UInt.m127constructorimpl(r10 & 255), UInt.m127constructorimpl(r11 & 255)));
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m70modVKZWuLQ(byte r10, long r11) {
        return Long.remainderUnsigned(ULong.m206constructorimpl(((long) r10) & 255), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m71modWZ4Q5Ns(byte r10, int r11) {
        return Integer.remainderUnsigned(UInt.m127constructorimpl(r10 & 255), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m72modxj2QHRw(byte r10, short r11) {
        return UShort.m313constructorimpl((short) Integer.remainderUnsigned(UInt.m127constructorimpl(r10 & 255), UInt.m127constructorimpl(r11 & UShort.MAX_VALUE)));
    }

    @InlineOnly
    /* JADX INFO: renamed from: or-7apg3OU, reason: not valid java name */
    private static final byte m73or7apg3OU(byte r10, byte r11) {
        return m50constructorimpl((byte) (r10 | r11));
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m74plus7apg3OU(byte r10, byte r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & 255) + UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m75plusVKZWuLQ(byte r10, long r11) {
        return ULong.m206constructorimpl(ULong.m206constructorimpl(((long) r10) & 255) + r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m76plusWZ4Q5Ns(byte r10, int r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & 255) + r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m77plusxj2QHRw(byte r10, short r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & 255) + UInt.m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: rangeTo-7apg3OU, reason: not valid java name */
    private static final UIntRange m78rangeTo7apg3OU(byte r10, byte r11) {
        return new UIntRange(UInt.m127constructorimpl(r10 & 255), UInt.m127constructorimpl(r11 & 255), null);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* JADX INFO: renamed from: rangeUntil-7apg3OU, reason: not valid java name */
    private static final UIntRange m79rangeUntil7apg3OU(byte r10, byte r11) {
        return URangesKt.m1283untilJ1ME1BU(UInt.m127constructorimpl(r10 & 255), UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m80rem7apg3OU(byte r10, byte r11) {
        return Integer.remainderUnsigned(UInt.m127constructorimpl(r10 & 255), UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m81remVKZWuLQ(byte r10, long r11) {
        return Long.remainderUnsigned(ULong.m206constructorimpl(((long) r10) & 255), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m82remWZ4Q5Ns(byte r10, int r11) {
        return Integer.remainderUnsigned(UInt.m127constructorimpl(r10 & 255), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m83remxj2QHRw(byte r10, short r11) {
        return Integer.remainderUnsigned(UInt.m127constructorimpl(r10 & 255), UInt.m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m84times7apg3OU(byte r10, byte r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & 255) * UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m85timesVKZWuLQ(byte r10, long r11) {
        return ULong.m206constructorimpl(ULong.m206constructorimpl(((long) r10) & 255) * r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m86timesWZ4Q5Ns(byte r10, int r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & 255) * r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m87timesxj2QHRw(byte r10, short r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & 255) * UInt.m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m88toByteimpl(byte r10) {
        return r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m89toDoubleimpl(byte r10) {
        return r10 & 255;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m90toFloatimpl(byte r10) {
        return r10 & 255;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m91toIntimpl(byte r10) {
        return r10 & 255;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m92toLongimpl(byte r10) {
        return ((long) r10) & 255;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m93toShortimpl(byte r10) {
        return (short) (r10 & 255);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m94toStringimpl(byte r10) {
        return String.valueOf(r10 & 255);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m95toUBytew2LRezQ(byte r10) {
        return r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m96toUIntpVg5ArA(byte r10) {
        return UInt.m127constructorimpl(r10 & 255);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m97toULongsVKNKU(byte r10) {
        return ULong.m206constructorimpl(((long) r10) & 255);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m98toUShortMh2AYeg(byte r10) {
        return UShort.m313constructorimpl((short) (r10 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: xor-7apg3OU, reason: not valid java name */
    private static final byte m99xor7apg3OU(byte r10, byte r11) {
        return m50constructorimpl((byte) (r10 ^ r11));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte r10) {
        byte r11 = r10.m100unboximpl();
        return Intrinsics.compare(m100unboximpl() & 255, r11 & 255);
    }

    public boolean equals(Object r10) {
        return m56equalsimpl(this.data, r10);
    }

    public int hashCode() {
        return m62hashCodeimpl(this.data);
    }

    public String toString() {
        return m94toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ byte m100unboximpl() {
        return this.data;
    }
}
