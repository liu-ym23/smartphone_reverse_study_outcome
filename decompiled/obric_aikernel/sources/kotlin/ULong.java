package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin(version = "1.5")
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = null;
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

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
    private /* synthetic */ ULong(long r10) {
        this.data = r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: and-VKZWuLQ, reason: not valid java name */
    private static final long m199andVKZWuLQ(long r10, long r11) {
        return m206constructorimpl(r10 & r11);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULong m200boximpl(long r10) {
        return new ULong(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m201compareTo7apg3OU(long r10, byte r11) {
        return Long.compareUnsigned(r10, m206constructorimpl(((long) r11) & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private int m202compareToVKZWuLQ(long r10) {
        return UnsignedKt.ulongCompare(m258unboximpl(), r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static int m203compareToVKZWuLQ(long r10, long r11) {
        return UnsignedKt.ulongCompare(r10, r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m204compareToWZ4Q5Ns(long r10, int r11) {
        return Long.compareUnsigned(r10, m206constructorimpl(((long) r11) & 4294967295L));
    }

    @InlineOnly
    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m205compareToxj2QHRw(long r10, short r11) {
        return Long.compareUnsigned(r10, m206constructorimpl(((long) r11) & 65535));
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m206constructorimpl(long r10) {
        return r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: dec-s-VKNKU, reason: not valid java name */
    private static final long m207decsVKNKU(long r10) {
        return m206constructorimpl(r10 - 1);
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final long m208div7apg3OU(long r10, byte r11) {
        return Long.divideUnsigned(r10, m206constructorimpl(((long) r11) & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m209divVKZWuLQ(long r10, long r11) {
        return UnsignedKt.m385ulongDivideeb3DHEI(r10, r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final long m210divWZ4Q5Ns(long r10, int r11) {
        return Long.divideUnsigned(r10, m206constructorimpl(((long) r11) & 4294967295L));
    }

    @InlineOnly
    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final long m211divxj2QHRw(long r10, short r11) {
        return Long.divideUnsigned(r10, m206constructorimpl(((long) r11) & 65535));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m212equalsimpl(long r10, Object r11) {
        if ((r11 instanceof ULong) == true) goto L6;
        return false;
    L6:
        if (r10 == ((ULong) r11).m258unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m213equalsimpl0(long r10, long r11) {
        if (r10 != r11) goto L5;
        return true;
    L5:
        return false;
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final long m214floorDiv7apg3OU(long r10, byte r11) {
        return Long.divideUnsigned(r10, m206constructorimpl(((long) r11) & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m215floorDivVKZWuLQ(long r10, long r11) {
        return Long.divideUnsigned(r10, r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final long m216floorDivWZ4Q5Ns(long r10, int r11) {
        return Long.divideUnsigned(r10, m206constructorimpl(((long) r11) & 4294967295L));
    }

    @InlineOnly
    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final long m217floorDivxj2QHRw(long r10, short r11) {
        return Long.divideUnsigned(r10, m206constructorimpl(((long) r11) & 65535));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m218hashCodeimpl(long r10) {
        return Long.hashCode(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: inc-s-VKNKU, reason: not valid java name */
    private static final long m219incsVKNKU(long r10) {
        return m206constructorimpl(r10 + 1);
    }

    @InlineOnly
    /* JADX INFO: renamed from: inv-s-VKNKU, reason: not valid java name */
    private static final long m220invsVKNKU(long r10) {
        return m206constructorimpl(~r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final long m221minus7apg3OU(long r10, byte r11) {
        return m206constructorimpl(r10 - m206constructorimpl(((long) r11) & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m222minusVKZWuLQ(long r10, long r11) {
        return m206constructorimpl(r10 - r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final long m223minusWZ4Q5Ns(long r10, int r11) {
        return m206constructorimpl(r10 - m206constructorimpl(((long) r11) & 4294967295L));
    }

    @InlineOnly
    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final long m224minusxj2QHRw(long r10, short r11) {
        return m206constructorimpl(r10 - m206constructorimpl(((long) r11) & 65535));
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m225mod7apg3OU(long r10, byte r11) {
        return UByte.m50constructorimpl((byte) Long.remainderUnsigned(r10, m206constructorimpl(((long) r11) & 255)));
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m226modVKZWuLQ(long r10, long r11) {
        return Long.remainderUnsigned(r10, r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m227modWZ4Q5Ns(long r10, int r11) {
        return UInt.m127constructorimpl((int) Long.remainderUnsigned(r10, m206constructorimpl(((long) r11) & 4294967295L)));
    }

    @InlineOnly
    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m228modxj2QHRw(long r10, short r11) {
        return UShort.m313constructorimpl((short) Long.remainderUnsigned(r10, m206constructorimpl(((long) r11) & 65535)));
    }

    @InlineOnly
    /* JADX INFO: renamed from: or-VKZWuLQ, reason: not valid java name */
    private static final long m229orVKZWuLQ(long r10, long r11) {
        return m206constructorimpl(r10 | r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final long m230plus7apg3OU(long r10, byte r11) {
        return m206constructorimpl(r10 + m206constructorimpl(((long) r11) & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m231plusVKZWuLQ(long r10, long r11) {
        return m206constructorimpl(r10 + r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final long m232plusWZ4Q5Ns(long r10, int r11) {
        return m206constructorimpl(r10 + m206constructorimpl(((long) r11) & 4294967295L));
    }

    @InlineOnly
    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final long m233plusxj2QHRw(long r10, short r11) {
        return m206constructorimpl(r10 + m206constructorimpl(((long) r11) & 65535));
    }

    @InlineOnly
    /* JADX INFO: renamed from: rangeTo-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m234rangeToVKZWuLQ(long r10, long r11) {
        return new ULongRange(r10, r11, null);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* JADX INFO: renamed from: rangeUntil-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m235rangeUntilVKZWuLQ(long r10, long r11) {
        return URangesKt.m1284untileb3DHEI(r10, r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final long m236rem7apg3OU(long r10, byte r11) {
        return Long.remainderUnsigned(r10, m206constructorimpl(((long) r11) & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m237remVKZWuLQ(long r10, long r11) {
        return UnsignedKt.m386ulongRemaindereb3DHEI(r10, r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final long m238remWZ4Q5Ns(long r10, int r11) {
        return Long.remainderUnsigned(r10, m206constructorimpl(((long) r11) & 4294967295L));
    }

    @InlineOnly
    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final long m239remxj2QHRw(long r10, short r11) {
        return Long.remainderUnsigned(r10, m206constructorimpl(((long) r11) & 65535));
    }

    @InlineOnly
    /* JADX INFO: renamed from: shl-s-VKNKU, reason: not valid java name */
    private static final long m240shlsVKNKU(long r10, int r11) {
        return m206constructorimpl(r10 << r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: shr-s-VKNKU, reason: not valid java name */
    private static final long m241shrsVKNKU(long r10, int r11) {
        return m206constructorimpl(r10 >>> r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final long m242times7apg3OU(long r10, byte r11) {
        return m206constructorimpl(r10 * m206constructorimpl(((long) r11) & 255));
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m243timesVKZWuLQ(long r10, long r11) {
        return m206constructorimpl(r10 * r11);
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final long m244timesWZ4Q5Ns(long r10, int r11) {
        return m206constructorimpl(r10 * m206constructorimpl(((long) r11) & 4294967295L));
    }

    @InlineOnly
    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final long m245timesxj2QHRw(long r10, short r11) {
        return m206constructorimpl(r10 * m206constructorimpl(((long) r11) & 65535));
    }

    @InlineOnly
    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m246toByteimpl(long r10) {
        return (byte) r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m247toDoubleimpl(long r10) {
        return UnsignedKt.ulongToDouble(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m248toFloatimpl(long r10) {
        return (float) UnsignedKt.ulongToDouble(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m249toIntimpl(long r10) {
        return (int) r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m250toLongimpl(long r10) {
        return r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m251toShortimpl(long r10) {
        return (short) r10;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m252toStringimpl(long r10) {
        return UnsignedKt.ulongToString(r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m253toUBytew2LRezQ(long r10) {
        return UByte.m50constructorimpl((byte) r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m254toUIntpVg5ArA(long r10) {
        return UInt.m127constructorimpl((int) r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m255toULongsVKNKU(long r10) {
        return r10;
    }

    @InlineOnly
    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m256toUShortMh2AYeg(long r10) {
        return UShort.m313constructorimpl((short) r10);
    }

    @InlineOnly
    /* JADX INFO: renamed from: xor-VKZWuLQ, reason: not valid java name */
    private static final long m257xorVKZWuLQ(long r10, long r11) {
        return m206constructorimpl(r10 ^ r11);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong r10) {
        long r11 = r10.m258unboximpl();
        return UnsignedKt.ulongCompare(m258unboximpl(), r11);
    }

    public boolean equals(Object r10) {
        return m212equalsimpl(this.data, r10);
    }

    public int hashCode() {
        return m218hashCodeimpl(this.data);
    }

    public String toString() {
        return m252toStringimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m258unboximpl() {
        return this.data;
    }
}
