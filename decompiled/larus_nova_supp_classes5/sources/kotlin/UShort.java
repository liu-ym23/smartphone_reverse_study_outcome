package kotlin;

import com.obric.assistant.interaction.api.service.IInteractionStateService;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u001c\u0010\u0010J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u001d\u0010\u0013J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b'\u0010\u0010J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b(\u0010\u0013J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b)\u0010\u001fJ\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0013\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b3\u0010\u0010J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b4\u0010\u0013J\u0018\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b5\u0010\u001fJ\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b6\u0010\u0018J\u0018\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b8\u00109J\u0018\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b:\u0010\u0013J\u0018\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b;\u0010\u001fJ\u0018\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b<\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b>\u0010\u000bJ\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b@\u0010\u0010J\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bA\u0010\u0013J\u0018\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bB\u0010\u001fJ\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bC\u0010\u0018J\u0018\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bF\u0010GJ\u0018\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bI\u0010GJ\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bK\u0010\u0010J\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bL\u0010\u0013J\u0018\u0010J\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bM\u0010\u001fJ\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bN\u0010\u0018J\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bP\u0010\u0010J\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bQ\u0010\u0013J\u0018\u0010O\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bR\u0010\u001fJ\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\rH\u0087\b¢\u0006\u0004\ba\u0010-J\u0010\u0010b\u001a\u00020cH\u0087\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bg\u0010\u0005J\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\bm\u0010WJ\u0013\u0010n\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\bo\u0010-J\u0013\u0010p\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\bq\u0010eJ\u0013\u0010r\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bs\u0010\u0005J\u0018\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\b!¨\u0006w"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = null;
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", "S", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    public static final /* synthetic */ UShort m277boximpl(short r1) {
        return new UShort(r1);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m283constructorimpl(short r0) {
        return r0;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m289equalsimpl(short r2, Object r3) {
        if ((r3 instanceof UShort) == true) goto L6;
        return false;
    L6:
        if (r2 == ((UShort) r3).m333unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m290equalsimpl0(short r0, short r1) {
        if (r0 != r1) goto L4;
        return true;
    L4:
        return false;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m295hashCodeimpl(short r0) {
        return r0;
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m321toByteimpl(short r0) {
        return (byte) r0;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m324toIntimpl(short r1) {
        return r1 & MAX_VALUE;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m325toLongimpl(short r4) {
        return ((long) r4) & 65535;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m326toShortimpl(short r0) {
        return r0;
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m331toUShortMh2AYeg(short r0) {
        return r0;
    }

    public boolean equals(Object r2) {
        return m289equalsimpl(this.data, r2);
    }

    public int hashCode() {
        return m295hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m333unboximpl() {
        return this.data;
    }

    public String toString() {
        return m327toStringimpl(this.data);
    }

    private /* synthetic */ UShort(short r1) {
        this.data = r1;
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private int m281compareToxj2QHRw(short r3) {
        return Intrinsics.compare(m333unboximpl() & MAX_VALUE, r3 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: dec-Mh2AYeg, reason: not valid java name */
    private static final short m284decMh2AYeg(short r0) {
        return m283constructorimpl((short) (r0 - 1));
    }

    /* JADX INFO: renamed from: inc-Mh2AYeg, reason: not valid java name */
    private static final short m296incMh2AYeg(short r0) {
        return m283constructorimpl((short) (r0 + 1));
    }

    /* JADX INFO: renamed from: inv-Mh2AYeg, reason: not valid java name */
    private static final short m297invMh2AYeg(short r0) {
        return m283constructorimpl((short) (~r0));
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m322toDoubleimpl(short r2) {
        return UnsignedKt.uintToDouble(r2 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m323toFloatimpl(short r2) {
        return (float) UnsignedKt.uintToDouble(r2 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m327toStringimpl(short r1) {
        return String.valueOf(r1 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m328toUBytew2LRezQ(short r0) {
        return UByte.m54constructorimpl((byte) r0);
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m329toUIntpVg5ArA(short r1) {
        return UInt.m129constructorimpl(r1 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m330toULongsVKNKU(short r4) {
        return ULong.m206constructorimpl(((long) r4) & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort r3) {
        short r4 = r3.m333unboximpl();
        return Intrinsics.compare(m333unboximpl() & MAX_VALUE, r4 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: and-xj2QHRw, reason: not valid java name */
    private static final short m276andxj2QHRw(short r0, short r1) {
        return m283constructorimpl((short) (r0 & r1));
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m278compareTo7apg3OU(short r1, byte r2) {
        return Intrinsics.compare(r1 & MAX_VALUE, r2 & UByte.MAX_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m279compareToVKZWuLQ(short r4, long r5) {
        return Long.compare(ULong.m206constructorimpl(((long) r4) & 65535) ^ Long.MIN_VALUE, r5 ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m280compareToWZ4Q5Ns(short r1, int r2) {
        return Integer.compare(UInt.m129constructorimpl(r1 & MAX_VALUE) ^ IntCompanionObject.MIN_VALUE, r2 ^ IntCompanionObject.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static int m282compareToxj2QHRw(short r1, short r2) {
        return Intrinsics.compare(r1 & MAX_VALUE, r2 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m285div7apg3OU(short r4, byte r5) {
        int r6 = UInt.m129constructorimpl(r4 & MAX_VALUE);
        return (int) ((((long) r6) & 4294967295L) / (((long) UInt.m129constructorimpl(r5 & UByte.MAX_VALUE)) & 4294967295L));
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m286divVKZWuLQ(short r8, long r9) {
        long r0 = ULong.m206constructorimpl(((long) r8) & 65535);
        if (r9 >= 0) goto L9;
        if ((r0 ^ Long.MIN_VALUE) < (r9 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r0 >= 0) goto L18;
        int r10 = 1;
        long r4 = ((r0 >>> 1) / r9) << 1;
        if (((r0 - (r4 * r9)) ^ Long.MIN_VALUE) >= (r9 ^ Long.MIN_VALUE)) goto L16;
        r10 = 0;
    L16:
        return r4 + ((long) r10);
    L18:
        return r0 / r9;
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m287divWZ4Q5Ns(short r4, int r5) {
        return (int) ((((long) UInt.m129constructorimpl(r4 & MAX_VALUE)) & 4294967295L) / (((long) r5) & 4294967295L));
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m288divxj2QHRw(short r4, short r5) {
        int r6 = UInt.m129constructorimpl(r4 & MAX_VALUE);
        return (int) ((((long) r6) & 4294967295L) / (((long) UInt.m129constructorimpl(r5 & MAX_VALUE)) & 4294967295L));
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m291floorDiv7apg3OU(short r4, byte r5) {
        int r6 = UInt.m129constructorimpl(r4 & MAX_VALUE);
        return (int) ((((long) r6) & 4294967295L) / (((long) UInt.m129constructorimpl(r5 & UByte.MAX_VALUE)) & 4294967295L));
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m292floorDivVKZWuLQ(short r8, long r9) {
        long r0 = ULong.m206constructorimpl(((long) r8) & 65535);
        if (r9 >= 0) goto L9;
        if ((r0 ^ Long.MIN_VALUE) < (r9 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r0 >= 0) goto L18;
        int r10 = 1;
        long r4 = ((r0 >>> 1) / r9) << 1;
        if (((r0 - (r4 * r9)) ^ Long.MIN_VALUE) >= (r9 ^ Long.MIN_VALUE)) goto L16;
        r10 = 0;
    L16:
        return r4 + ((long) r10);
    L18:
        return r0 / r9;
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m293floorDivWZ4Q5Ns(short r4, int r5) {
        return (int) ((((long) UInt.m129constructorimpl(r4 & MAX_VALUE)) & 4294967295L) / (((long) r5) & 4294967295L));
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m294floorDivxj2QHRw(short r4, short r5) {
        int r6 = UInt.m129constructorimpl(r4 & MAX_VALUE);
        return (int) ((((long) r6) & 4294967295L) / (((long) UInt.m129constructorimpl(r5 & MAX_VALUE)) & 4294967295L));
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m298minus7apg3OU(short r1, byte r2) {
        return UInt.m129constructorimpl(UInt.m129constructorimpl(r1 & MAX_VALUE) - UInt.m129constructorimpl(r2 & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m299minusVKZWuLQ(short r4, long r5) {
        return ULong.m206constructorimpl(ULong.m206constructorimpl(((long) r4) & 65535) - r5);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m300minusWZ4Q5Ns(short r1, int r2) {
        return UInt.m129constructorimpl(UInt.m129constructorimpl(r1 & MAX_VALUE) - r2);
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m301minusxj2QHRw(short r1, short r2) {
        return UInt.m129constructorimpl(UInt.m129constructorimpl(r1 & MAX_VALUE) - UInt.m129constructorimpl(r2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m302mod7apg3OU(short r4, byte r5) {
        return UByte.m54constructorimpl((byte) ((((long) UInt.m129constructorimpl(r4 & MAX_VALUE)) & 4294967295L) % (((long) UInt.m129constructorimpl(r5 & UByte.MAX_VALUE)) & 4294967295L)));
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m303modVKZWuLQ(short r8, long r9) {
        long r0 = ULong.m206constructorimpl(((long) r8) & 65535);
        if (r9 >= 0) goto L9;
        if ((r0 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r9)) goto L15;
        return r0;
    L15:
        return r0 - r9;
    L9:
        if (r0 >= 0) goto L16;
        r0 = r0 - ((((r0 >>> 1) / r9) << 1) * r9);
        if ((r0 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r9)) goto L15;
        r9 = 0;
        goto L15
    L16:
        return r0 % r9;
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m304modWZ4Q5Ns(short r4, int r5) {
        return (int) ((((long) UInt.m129constructorimpl(r4 & MAX_VALUE)) & 4294967295L) % (((long) r5) & 4294967295L));
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m305modxj2QHRw(short r4, short r5) {
        return m283constructorimpl((short) ((((long) UInt.m129constructorimpl(r4 & MAX_VALUE)) & 4294967295L) % (((long) UInt.m129constructorimpl(r5 & MAX_VALUE)) & 4294967295L)));
    }

    /* JADX INFO: renamed from: or-xj2QHRw, reason: not valid java name */
    private static final short m306orxj2QHRw(short r0, short r1) {
        return m283constructorimpl((short) (r0 | r1));
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m307plus7apg3OU(short r1, byte r2) {
        return UInt.m129constructorimpl(UInt.m129constructorimpl(r1 & MAX_VALUE) + UInt.m129constructorimpl(r2 & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m308plusVKZWuLQ(short r4, long r5) {
        return ULong.m206constructorimpl(ULong.m206constructorimpl(((long) r4) & 65535) + r5);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m309plusWZ4Q5Ns(short r1, int r2) {
        return UInt.m129constructorimpl(UInt.m129constructorimpl(r1 & MAX_VALUE) + r2);
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m310plusxj2QHRw(short r1, short r2) {
        return UInt.m129constructorimpl(UInt.m129constructorimpl(r1 & MAX_VALUE) + UInt.m129constructorimpl(r2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: rangeTo-xj2QHRw, reason: not valid java name */
    private static final UIntRange m311rangeToxj2QHRw(short r2, short r3) {
        return new UIntRange(UInt.m129constructorimpl(r2 & MAX_VALUE), UInt.m129constructorimpl(r3 & MAX_VALUE), null);
    }

    /* JADX INFO: renamed from: rangeUntil-xj2QHRw, reason: not valid java name */
    private static final UIntRange m312rangeUntilxj2QHRw(short r1, short r2) {
        return URangesKt.until-J1ME1BU(UInt.m129constructorimpl(r1 & MAX_VALUE), UInt.m129constructorimpl(r2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m313rem7apg3OU(short r4, byte r5) {
        int r6 = UInt.m129constructorimpl(r4 & MAX_VALUE);
        return (int) ((((long) r6) & 4294967295L) % (((long) UInt.m129constructorimpl(r5 & UByte.MAX_VALUE)) & 4294967295L));
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m314remVKZWuLQ(short r8, long r9) {
        long r0 = ULong.m206constructorimpl(((long) r8) & 65535);
        if (r9 >= 0) goto L9;
        if ((r0 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r9)) goto L15;
        return r0;
    L15:
        return r0 - r9;
    L9:
        if (r0 >= 0) goto L16;
        r0 = r0 - ((((r0 >>> 1) / r9) << 1) * r9);
        if ((r0 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r9)) goto L15;
        r9 = 0;
        goto L15
    L16:
        return r0 % r9;
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m315remWZ4Q5Ns(short r4, int r5) {
        return (int) ((((long) UInt.m129constructorimpl(r4 & MAX_VALUE)) & 4294967295L) % (((long) r5) & 4294967295L));
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m316remxj2QHRw(short r4, short r5) {
        int r6 = UInt.m129constructorimpl(r4 & MAX_VALUE);
        return (int) ((((long) r6) & 4294967295L) % (((long) UInt.m129constructorimpl(r5 & MAX_VALUE)) & 4294967295L));
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m317times7apg3OU(short r1, byte r2) {
        return UInt.m129constructorimpl(UInt.m129constructorimpl(r1 & MAX_VALUE) * UInt.m129constructorimpl(r2 & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m318timesVKZWuLQ(short r4, long r5) {
        return ULong.m206constructorimpl(ULong.m206constructorimpl(((long) r4) & 65535) * r5);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m319timesWZ4Q5Ns(short r1, int r2) {
        return UInt.m129constructorimpl(UInt.m129constructorimpl(r1 & MAX_VALUE) * r2);
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m320timesxj2QHRw(short r1, short r2) {
        return UInt.m129constructorimpl(UInt.m129constructorimpl(r1 & MAX_VALUE) * UInt.m129constructorimpl(r2 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: xor-xj2QHRw, reason: not valid java name */
    private static final short m332xorxj2QHRw(short r0, short r1) {
        return m283constructorimpl((short) (r0 ^ r1));
    }
}
