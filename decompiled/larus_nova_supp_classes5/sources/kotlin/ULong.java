package kotlin;

import com.obric.assistant.interaction.api.service.IInteractionStateService;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 ~2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001~B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b \u0010\u000bJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b)\u0010\u001dJ\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b*\u0010\u001fJ\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b+\u0010\u000bJ\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\b¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u0013\u00102\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b3\u0010\u0005J\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b5\u0010\u001dJ\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b6\u0010\u001fJ\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b7\u0010\u000bJ\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b8\u0010\"J\u0018\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b:\u0010;J\u0018\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b<\u0010\u0013J\u0018\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b=\u0010\u000bJ\u0018\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\b¢\u0006\u0004\b>\u0010?J\u0018\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bA\u0010\u000bJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bC\u0010\u001dJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bD\u0010\u001fJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bE\u0010\u000bJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\bF\u0010\"J\u0018\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bI\u0010JJ\u0018\u0010K\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bL\u0010JJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bN\u0010\u001dJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bO\u0010\u001fJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bP\u0010\u000bJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\bQ\u0010\"J\u001b\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\u0087\fø\u0001\u0000¢\u0006\u0004\bT\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\u0087\fø\u0001\u0000¢\u0006\u0004\bV\u0010\u001fJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bX\u0010\u001dJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bY\u0010\u001fJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bZ\u0010\u000bJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b[\u0010\"J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020aH\u0087\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\u0087\b¢\u0006\u0004\bf\u0010gJ\u0010\u0010h\u001a\u00020\rH\u0087\b¢\u0006\u0004\bi\u0010/J\u0010\u0010j\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bk\u0010\u0005J\u0010\u0010l\u001a\u00020mH\u0087\b¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020qH\u0016¢\u0006\u0004\br\u0010sJ\u0013\u0010t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\bu\u0010_J\u0013\u0010v\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\bw\u0010/J\u0013\u0010x\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\by\u0010\u0005J\u0013\u0010z\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b{\u0010oJ\u0018\u0010|\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b}\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\b!¨\u0006\u007f"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = null;
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULong m200boximpl(long r1) {
        return new ULong(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m206constructorimpl(long r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m212equalsimpl(long r4, Object r6) {
        if ((r6 instanceof ULong) == true) goto L6;
        return false;
    L6:
        if (r4 == ((ULong) r6).m258unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m213equalsimpl0(long r1, long r3) {
        if (r1 != r3) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m218hashCodeimpl(long r2) {
        return (int) (r2 ^ (r2 >>> 32));
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m246toByteimpl(long r0) {
        return (byte) r0;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m249toIntimpl(long r0) {
        return (int) r0;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m250toLongimpl(long r0) {
        return r0;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m251toShortimpl(long r0) {
        return (short) r0;
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m255toULongsVKNKU(long r0) {
        return r0;
    }

    public boolean equals(Object r3) {
        return m212equalsimpl(this.data, r3);
    }

    public int hashCode() {
        return m218hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m258unboximpl() {
        return this.data;
    }

    public String toString() {
        return m252toStringimpl(this.data);
    }

    private /* synthetic */ ULong(long r1) {
        this.data = r1;
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private int m202compareToVKZWuLQ(long r3) {
        return UnsignedKt.ulongCompare(m258unboximpl(), r3);
    }

    /* JADX INFO: renamed from: dec-s-VKNKU, reason: not valid java name */
    private static final long m207decsVKNKU(long r2) {
        return m206constructorimpl(r2 - 1);
    }

    /* JADX INFO: renamed from: inc-s-VKNKU, reason: not valid java name */
    private static final long m219incsVKNKU(long r2) {
        return m206constructorimpl(r2 + 1);
    }

    /* JADX INFO: renamed from: inv-s-VKNKU, reason: not valid java name */
    private static final long m220invsVKNKU(long r0) {
        return m206constructorimpl(~r0);
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m247toDoubleimpl(long r0) {
        return UnsignedKt.ulongToDouble(r0);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m248toFloatimpl(long r0) {
        return (float) UnsignedKt.ulongToDouble(r0);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m252toStringimpl(long r1) {
        return UnsignedKt.ulongToString(r1, 10);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m253toUBytew2LRezQ(long r0) {
        return UByte.m54constructorimpl((byte) r0);
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m254toUIntpVg5ArA(long r0) {
        return UInt.m129constructorimpl((int) r0);
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m256toUShortMh2AYeg(long r0) {
        return UShort.m283constructorimpl((short) r0);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong r5) {
        long r0 = r5.m258unboximpl();
        return UnsignedKt.ulongCompare(m258unboximpl(), r0);
    }

    /* JADX INFO: renamed from: and-VKZWuLQ, reason: not valid java name */
    private static final long m199andVKZWuLQ(long r0, long r2) {
        return m206constructorimpl(r0 & r2);
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m201compareTo7apg3OU(long r4, byte r6) {
        return Long.compare(r4 ^ Long.MIN_VALUE, m206constructorimpl(((long) r6) & 255) ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static int m203compareToVKZWuLQ(long r0, long r2) {
        return UnsignedKt.ulongCompare(r0, r2);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m204compareToWZ4Q5Ns(long r4, int r6) {
        return Long.compare(r4 ^ Long.MIN_VALUE, m206constructorimpl(((long) r6) & 4294967295L) ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m205compareToxj2QHRw(long r4, short r6) {
        return Long.compare(r4 ^ Long.MIN_VALUE, m206constructorimpl(((long) r6) & 65535) ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final long m208div7apg3OU(long r8, byte r10) {
        long r0 = m206constructorimpl(((long) r10) & 255);
        if (r0 >= 0) goto L9;
        if ((r8 ^ Long.MIN_VALUE) < (r0 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r8 >= 0) goto L18;
        int r11 = 1;
        long r4 = ((r8 >>> 1) / r0) << 1;
        if (((r8 - (r4 * r0)) ^ Long.MIN_VALUE) >= (r0 ^ Long.MIN_VALUE)) goto L16;
        r11 = 0;
    L16:
        return r4 + ((long) r11);
    L18:
        return r8 / r0;
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m209divVKZWuLQ(long r0, long r2) {
        return UnsignedKt.m353ulongDivideeb3DHEI(r0, r2);
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final long m210divWZ4Q5Ns(long r8, int r10) {
        long r0 = m206constructorimpl(((long) r10) & 4294967295L);
        if (r0 >= 0) goto L9;
        if ((r8 ^ Long.MIN_VALUE) < (r0 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r8 >= 0) goto L18;
        int r11 = 1;
        long r4 = ((r8 >>> 1) / r0) << 1;
        if (((r8 - (r4 * r0)) ^ Long.MIN_VALUE) >= (r0 ^ Long.MIN_VALUE)) goto L16;
        r11 = 0;
    L16:
        return r4 + ((long) r11);
    L18:
        return r8 / r0;
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final long m211divxj2QHRw(long r8, short r10) {
        long r0 = m206constructorimpl(((long) r10) & 65535);
        if (r0 >= 0) goto L9;
        if ((r8 ^ Long.MIN_VALUE) < (r0 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r8 >= 0) goto L18;
        int r11 = 1;
        long r4 = ((r8 >>> 1) / r0) << 1;
        if (((r8 - (r4 * r0)) ^ Long.MIN_VALUE) >= (r0 ^ Long.MIN_VALUE)) goto L16;
        r11 = 0;
    L16:
        return r4 + ((long) r11);
    L18:
        return r8 / r0;
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final long m214floorDiv7apg3OU(long r8, byte r10) {
        long r0 = m206constructorimpl(((long) r10) & 255);
        if (r0 >= 0) goto L9;
        if ((r8 ^ Long.MIN_VALUE) < (r0 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r8 >= 0) goto L18;
        int r11 = 1;
        long r4 = ((r8 >>> 1) / r0) << 1;
        if (((r8 - (r4 * r0)) ^ Long.MIN_VALUE) >= (r0 ^ Long.MIN_VALUE)) goto L16;
        r11 = 0;
    L16:
        return r4 + ((long) r11);
    L18:
        return r8 / r0;
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m215floorDivVKZWuLQ(long r7, long r9) {
        if (r9 >= 0) goto L9;
        if ((r7 ^ Long.MIN_VALUE) < (r9 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r7 >= 0) goto L18;
        int r2 = 1;
        long r3 = ((r7 >>> 1) / r9) << 1;
        if (((r7 - (r3 * r9)) ^ Long.MIN_VALUE) >= (r9 ^ Long.MIN_VALUE)) goto L16;
        r2 = 0;
    L16:
        return r3 + ((long) r2);
    L18:
        return r7 / r9;
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final long m216floorDivWZ4Q5Ns(long r8, int r10) {
        long r0 = m206constructorimpl(((long) r10) & 4294967295L);
        if (r0 >= 0) goto L9;
        if ((r8 ^ Long.MIN_VALUE) < (r0 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r8 >= 0) goto L18;
        int r11 = 1;
        long r4 = ((r8 >>> 1) / r0) << 1;
        if (((r8 - (r4 * r0)) ^ Long.MIN_VALUE) >= (r0 ^ Long.MIN_VALUE)) goto L16;
        r11 = 0;
    L16:
        return r4 + ((long) r11);
    L18:
        return r8 / r0;
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final long m217floorDivxj2QHRw(long r8, short r10) {
        long r0 = m206constructorimpl(((long) r10) & 65535);
        if (r0 >= 0) goto L9;
        if ((r8 ^ Long.MIN_VALUE) < (r0 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r8 >= 0) goto L18;
        int r11 = 1;
        long r4 = ((r8 >>> 1) / r0) << 1;
        if (((r8 - (r4 * r0)) ^ Long.MIN_VALUE) >= (r0 ^ Long.MIN_VALUE)) goto L16;
        r11 = 0;
    L16:
        return r4 + ((long) r11);
    L18:
        return r8 / r0;
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final long m221minus7apg3OU(long r4, byte r6) {
        return m206constructorimpl(r4 - m206constructorimpl(((long) r6) & 255));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m222minusVKZWuLQ(long r0, long r2) {
        return m206constructorimpl(r0 - r2);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final long m223minusWZ4Q5Ns(long r4, int r6) {
        return m206constructorimpl(r4 - m206constructorimpl(((long) r6) & 4294967295L));
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final long m224minusxj2QHRw(long r4, short r6) {
        return m206constructorimpl(r4 - m206constructorimpl(((long) r6) & 65535));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m225mod7apg3OU(long r8, byte r10) {
        long r0 = m206constructorimpl(((long) r10) & 255);
        if (r0 >= 0) goto L9;
        if ((r8 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ r0)) goto L16;
    L7:
        r8 = r8 - r0;
    L16:
        return UByte.m54constructorimpl((byte) r8);
    L9:
        if (r8 < 0) goto L11;
        r8 = r8 % r0;
        goto L16
    L11:
        r8 = r8 - ((((r8 >>> 1) / r0) << 1) * r0);
        if ((r8 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r0)) goto L7;
        r0 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m226modVKZWuLQ(long r7, long r9) {
        if (r9 >= 0) goto L9;
        if ((r7 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r9)) goto L15;
        return r7;
    L15:
        return r7 - r9;
    L9:
        if (r7 >= 0) goto L16;
        r7 = r7 - ((((r7 >>> 1) / r9) << 1) * r9);
        if ((r7 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r9)) goto L15;
        r9 = 0;
        goto L15
    L16:
        return r7 % r9;
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m227modWZ4Q5Ns(long r8, int r10) {
        long r0 = m206constructorimpl(((long) r10) & 4294967295L);
        if (r0 >= 0) goto L9;
        if ((r8 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ r0)) goto L16;
    L7:
        r8 = r8 - r0;
    L16:
        return UInt.m129constructorimpl((int) r8);
    L9:
        if (r8 < 0) goto L11;
        r8 = r8 % r0;
        goto L16
    L11:
        r8 = r8 - ((((r8 >>> 1) / r0) << 1) * r0);
        if ((r8 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r0)) goto L7;
        r0 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m228modxj2QHRw(long r8, short r10) {
        long r0 = m206constructorimpl(((long) r10) & 65535);
        if (r0 >= 0) goto L9;
        if ((r8 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ r0)) goto L16;
    L7:
        r8 = r8 - r0;
    L16:
        return UShort.m283constructorimpl((short) r8);
    L9:
        if (r8 < 0) goto L11;
        r8 = r8 % r0;
        goto L16
    L11:
        r8 = r8 - ((((r8 >>> 1) / r0) << 1) * r0);
        if ((r8 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r0)) goto L7;
        r0 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: or-VKZWuLQ, reason: not valid java name */
    private static final long m229orVKZWuLQ(long r0, long r2) {
        return m206constructorimpl(r0 | r2);
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final long m230plus7apg3OU(long r4, byte r6) {
        return m206constructorimpl(r4 + m206constructorimpl(((long) r6) & 255));
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m231plusVKZWuLQ(long r0, long r2) {
        return m206constructorimpl(r0 + r2);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final long m232plusWZ4Q5Ns(long r4, int r6) {
        return m206constructorimpl(r4 + m206constructorimpl(((long) r6) & 4294967295L));
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final long m233plusxj2QHRw(long r4, short r6) {
        return m206constructorimpl(r4 + m206constructorimpl(((long) r6) & 65535));
    }

    /* JADX INFO: renamed from: rangeTo-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m234rangeToVKZWuLQ(long r7, long r9) {
        return new ULongRange(r7, r9, null);
    }

    /* JADX INFO: renamed from: rangeUntil-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m235rangeUntilVKZWuLQ(long r0, long r2) {
        return URangesKt.until-eb3DHEI(r0, r2);
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final long m236rem7apg3OU(long r8, byte r10) {
        long r0 = m206constructorimpl(((long) r10) & 255);
        if (r0 >= 0) goto L9;
        if ((r8 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r0)) goto L15;
        return r8;
    L15:
        return r8 - r0;
    L9:
        if (r8 >= 0) goto L16;
        r8 = r8 - ((((r8 >>> 1) / r0) << 1) * r0);
        if ((r8 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r0)) goto L15;
        r0 = 0;
        goto L15
    L16:
        return r8 % r0;
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m237remVKZWuLQ(long r0, long r2) {
        return UnsignedKt.m354ulongRemaindereb3DHEI(r0, r2);
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final long m238remWZ4Q5Ns(long r8, int r10) {
        long r0 = m206constructorimpl(((long) r10) & 4294967295L);
        if (r0 >= 0) goto L9;
        if ((r8 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r0)) goto L15;
        return r8;
    L15:
        return r8 - r0;
    L9:
        if (r8 >= 0) goto L16;
        r8 = r8 - ((((r8 >>> 1) / r0) << 1) * r0);
        if ((r8 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r0)) goto L15;
        r0 = 0;
        goto L15
    L16:
        return r8 % r0;
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final long m239remxj2QHRw(long r8, short r10) {
        long r0 = m206constructorimpl(((long) r10) & 65535);
        if (r0 >= 0) goto L9;
        if ((r8 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r0)) goto L15;
        return r8;
    L15:
        return r8 - r0;
    L9:
        if (r8 >= 0) goto L16;
        r8 = r8 - ((((r8 >>> 1) / r0) << 1) * r0);
        if ((r8 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r0)) goto L15;
        r0 = 0;
        goto L15
    L16:
        return r8 % r0;
    }

    /* JADX INFO: renamed from: shl-s-VKNKU, reason: not valid java name */
    private static final long m240shlsVKNKU(long r0, int r2) {
        return m206constructorimpl(r0 << r2);
    }

    /* JADX INFO: renamed from: shr-s-VKNKU, reason: not valid java name */
    private static final long m241shrsVKNKU(long r0, int r2) {
        return m206constructorimpl(r0 >>> r2);
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final long m242times7apg3OU(long r4, byte r6) {
        return m206constructorimpl(r4 * m206constructorimpl(((long) r6) & 255));
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m243timesVKZWuLQ(long r0, long r2) {
        return m206constructorimpl(r0 * r2);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final long m244timesWZ4Q5Ns(long r4, int r6) {
        return m206constructorimpl(r4 * m206constructorimpl(((long) r6) & 4294967295L));
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final long m245timesxj2QHRw(long r4, short r6) {
        return m206constructorimpl(r4 * m206constructorimpl(((long) r6) & 65535));
    }

    /* JADX INFO: renamed from: xor-VKZWuLQ, reason: not valid java name */
    private static final long m257xorVKZWuLQ(long r0, long r2) {
        return m206constructorimpl(r0 ^ r2);
    }
}
