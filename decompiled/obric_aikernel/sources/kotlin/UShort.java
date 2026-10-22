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
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = null;
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

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
    private /* synthetic */ UShort(short r10) {
        this.data = r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: and-xj2QHRw, reason: not valid java name */
    private static final short m306andxj2QHRw(short r10, short r11) {
        return m313constructorimpl((short) (r10 & r11));
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UShort m307boximpl(short r10) {
        return new UShort(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m308compareTo7apg3OU(short r10, byte r11) {
        return Intrinsics.compare(r10 & MAX_VALUE, r11 & 255);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m309compareToVKZWuLQ(short r10, long r11) {
        return Long.compareUnsigned(ULong.m206constructorimpl(((long) r10) & 65535), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m310compareToWZ4Q5Ns(short r10, int r11) {
        return Integer.compareUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private int m311compareToxj2QHRw(short r10) {
        return Intrinsics.compare(m363unboximpl() & MAX_VALUE, r10 & MAX_VALUE);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static int m312compareToxj2QHRw(short r10, short r11) {
        return Intrinsics.compare(r10 & MAX_VALUE, r11 & MAX_VALUE);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m313constructorimpl(short r10) {
        return r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: dec-Mh2AYeg, reason: not valid java name */
    private static final short m314decMh2AYeg(short r10) {
        return m313constructorimpl((short) (r10 - 1));
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m315div7apg3OU(short r10, byte r11) {
        return Integer.divideUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m316divVKZWuLQ(short r10, long r11) {
        return Long.divideUnsigned(ULong.m206constructorimpl(((long) r10) & 65535), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m317divWZ4Q5Ns(short r10, int r11) {
        return Integer.divideUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m318divxj2QHRw(short r10, short r11) {
        return Integer.divideUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), UInt.m127constructorimpl(r11 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m319equalsimpl(short r10, Object r11) {
        if ((r11 instanceof UShort) == true) goto L6;
        return false;
    L6:
        if (r10 == ((UShort) r11).m363unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m320equalsimpl0(short r10, short r11) {
        if (r10 != r11) goto L4;
        return true;
    L4:
        return false;
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m321floorDiv7apg3OU(short r10, byte r11) {
        return Integer.divideUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m322floorDivVKZWuLQ(short r10, long r11) {
        return Long.divideUnsigned(ULong.m206constructorimpl(((long) r10) & 65535), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m323floorDivWZ4Q5Ns(short r10, int r11) {
        return Integer.divideUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m324floorDivxj2QHRw(short r10, short r11) {
        return Integer.divideUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), UInt.m127constructorimpl(r11 & MAX_VALUE));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m325hashCodeimpl(short r10) {
        return Short.hashCode(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: inc-Mh2AYeg, reason: not valid java name */
    private static final short m326incMh2AYeg(short r10) {
        return m313constructorimpl((short) (r10 + 1));
    }

    @InlineOnly
    /* JADX INFO: renamed from: inv-Mh2AYeg, reason: not valid java name */
    private static final short m327invMh2AYeg(short r10) {
        return m313constructorimpl((short) (~r10));
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m328minus7apg3OU(short r10, byte r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & MAX_VALUE) - UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m329minusVKZWuLQ(short r10, long r11) {
        return ULong.m206constructorimpl(ULong.m206constructorimpl(((long) r10) & 65535) - r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m330minusWZ4Q5Ns(short r10, int r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & MAX_VALUE) - r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m331minusxj2QHRw(short r10, short r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & MAX_VALUE) - UInt.m127constructorimpl(r11 & MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m332mod7apg3OU(short r10, byte r11) {
        return UByte.m50constructorimpl((byte) Integer.remainderUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), UInt.m127constructorimpl(r11 & 255)));
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m333modVKZWuLQ(short r10, long r11) {
        return Long.remainderUnsigned(ULong.m206constructorimpl(((long) r10) & 65535), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m334modWZ4Q5Ns(short r10, int r11) {
        return Integer.remainderUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m335modxj2QHRw(short r10, short r11) {
        return m313constructorimpl((short) Integer.remainderUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), UInt.m127constructorimpl(r11 & MAX_VALUE)));
    }

    @InlineOnly
    /* JADX INFO: renamed from: or-xj2QHRw, reason: not valid java name */
    private static final short m336orxj2QHRw(short r10, short r11) {
        return m313constructorimpl((short) (r10 | r11));
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m337plus7apg3OU(short r10, byte r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & MAX_VALUE) + UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m338plusVKZWuLQ(short r10, long r11) {
        return ULong.m206constructorimpl(ULong.m206constructorimpl(((long) r10) & 65535) + r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m339plusWZ4Q5Ns(short r10, int r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & MAX_VALUE) + r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m340plusxj2QHRw(short r10, short r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & MAX_VALUE) + UInt.m127constructorimpl(r11 & MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: rangeTo-xj2QHRw, reason: not valid java name */
    private static final UIntRange m341rangeToxj2QHRw(short r10, short r11) {
        return new UIntRange(UInt.m127constructorimpl(r10 & MAX_VALUE), UInt.m127constructorimpl(r11 & MAX_VALUE), null);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* JADX INFO: renamed from: rangeUntil-xj2QHRw, reason: not valid java name */
    private static final UIntRange m342rangeUntilxj2QHRw(short r10, short r11) {
        return URangesKt.m1283untilJ1ME1BU(UInt.m127constructorimpl(r10 & MAX_VALUE), UInt.m127constructorimpl(r11 & MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m343rem7apg3OU(short r10, byte r11) {
        return Integer.remainderUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m344remVKZWuLQ(short r10, long r11) {
        return Long.remainderUnsigned(ULong.m206constructorimpl(((long) r10) & 65535), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m345remWZ4Q5Ns(short r10, int r11) {
        return Integer.remainderUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m346remxj2QHRw(short r10, short r11) {
        return Integer.remainderUnsigned(UInt.m127constructorimpl(r10 & MAX_VALUE), UInt.m127constructorimpl(r11 & MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m347times7apg3OU(short r10, byte r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & MAX_VALUE) * UInt.m127constructorimpl(r11 & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m348timesVKZWuLQ(short r10, long r11) {
        return ULong.m206constructorimpl(ULong.m206constructorimpl(((long) r10) & 65535) * r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m349timesWZ4Q5Ns(short r10, int r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & MAX_VALUE) * r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m350timesxj2QHRw(short r10, short r11) {
        return UInt.m127constructorimpl(UInt.m127constructorimpl(r10 & MAX_VALUE) * UInt.m127constructorimpl(r11 & MAX_VALUE));
    }

    @InlineOnly
    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m351toByteimpl(short r10) {
        return (byte) r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m352toDoubleimpl(short r10) {
        return r10 & MAX_VALUE;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m353toFloatimpl(short r10) {
        return r10 & MAX_VALUE;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m354toIntimpl(short r10) {
        return r10 & MAX_VALUE;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m355toLongimpl(short r10) {
        return ((long) r10) & 65535;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m356toShortimpl(short r10) {
        return r10;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m357toStringimpl(short r10) {
        return String.valueOf(r10 & MAX_VALUE);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m358toUBytew2LRezQ(short r10) {
        return UByte.m50constructorimpl((byte) r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m359toUIntpVg5ArA(short r10) {
        return UInt.m127constructorimpl(r10 & MAX_VALUE);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m360toULongsVKNKU(short r10) {
        return ULong.m206constructorimpl(((long) r10) & 65535);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m361toUShortMh2AYeg(short r10) {
        return r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: xor-xj2QHRw, reason: not valid java name */
    private static final short m362xorxj2QHRw(short r10, short r11) {
        return m313constructorimpl((short) (r10 ^ r11));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort r10) {
        short r11 = r10.m363unboximpl();
        return Intrinsics.compare(m363unboximpl() & MAX_VALUE, r11 & MAX_VALUE);
    }

    public boolean equals(Object r10) {
        return m319equalsimpl(this.data, r10);
    }

    public int hashCode() {
        return m325hashCodeimpl(this.data);
    }

    public String toString() {
        return m357toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m363unboximpl() {
        return this.data;
    }
}
