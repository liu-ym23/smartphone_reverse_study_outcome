package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;

/* JADX INFO: loaded from: classes3.dex */
class URangesKt___URangesKt {
    public URangesKt___URangesKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtLeast-5PvTz6A, reason: not valid java name */
    public static final short m1285coerceAtLeast5PvTz6A(short r10, short r11) {
        if (Intrinsics.compare(r10 & UShort.MAX_VALUE, 65535 & r11) < 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtLeast-J1ME1BU, reason: not valid java name */
    public static final int m1286coerceAtLeastJ1ME1BU(int r10, int r11) {
        if (Integer.compareUnsigned(r10, r11) < 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtLeast-Kr8caGY, reason: not valid java name */
    public static final byte m1287coerceAtLeastKr8caGY(byte r10, byte r11) {
        if (Intrinsics.compare(r10 & 255, r11 & 255) < 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtLeast-eb3DHEI, reason: not valid java name */
    public static final long m1288coerceAtLeasteb3DHEI(long r10, long r11) {
        if (Long.compareUnsigned(r10, r11) < 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtMost-5PvTz6A, reason: not valid java name */
    public static final short m1289coerceAtMost5PvTz6A(short r10, short r11) {
        if (Intrinsics.compare(r10 & UShort.MAX_VALUE, 65535 & r11) > 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtMost-J1ME1BU, reason: not valid java name */
    public static final int m1290coerceAtMostJ1ME1BU(int r10, int r11) {
        if (Integer.compareUnsigned(r10, r11) > 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtMost-Kr8caGY, reason: not valid java name */
    public static final byte m1291coerceAtMostKr8caGY(byte r10, byte r11) {
        if (Intrinsics.compare(r10 & 255, r11 & 255) > 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtMost-eb3DHEI, reason: not valid java name */
    public static final long m1292coerceAtMosteb3DHEI(long r10, long r11) {
        if (Long.compareUnsigned(r10, r11) > 0) goto L5;
        return r10;
    L5:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceIn-JPwROB0, reason: not valid java name */
    public static final long m1293coerceInJPwROB0(long r10, ClosedRange<ULong> r11) {
        Intrinsics.checkNotNullParameter(r11, "range");
        if ((r11 instanceof ClosedFloatingPointRange) == false) goto L7;
        return ((ULong) RangesKt___RangesKt.coerceIn(ULong.m200boximpl(r10), (ClosedFloatingPointRange) r11)).m258unboximpl();
    L7:
        if (r11.isEmpty() == true) goto L17;
        if (Long.compareUnsigned(r10, ((ULong) r11.getStart()).m258unboximpl()) >= 0) goto L13;
        Comparable r12 = r11.getStart();
    L15:
        return ((ULong) r12).m258unboximpl();
    L13:
        if (Long.compareUnsigned(r10, ((ULong) r11.getEndInclusive()).m258unboximpl()) <= 0) goto L18;
        r12 = r11.getEndInclusive();
        goto L15
    L18:
        return r10;
    L17:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r11 + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceIn-VKSA0NQ, reason: not valid java name */
    public static final short m1294coerceInVKSA0NQ(short r10, short r11, short r12) {
        int r13 = r11 & UShort.MAX_VALUE;
        int r14 = r12 & UShort.MAX_VALUE;
        if (Intrinsics.compare(r13, r14) > 0) goto L12;
        int r15 = 65535 & r10;
        if (Intrinsics.compare(r15, r13) >= 0) goto L8;
        return r11;
    L8:
        if (Intrinsics.compare(r15, r14) <= 0) goto L10;
        return r12;
    L10:
        return r10;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.m357toStringimpl(r12) + " is less than minimum " + UShort.m357toStringimpl(r11) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceIn-WZ9TVnA, reason: not valid java name */
    public static final int m1295coerceInWZ9TVnA(int r10, int r11, int r12) {
        if (Integer.compareUnsigned(r11, r12) > 0) goto L12;
        if (Integer.compareUnsigned(r10, r11) >= 0) goto L8;
        return r11;
    L8:
        if (Integer.compareUnsigned(r10, r12) <= 0) goto L10;
        return r12;
    L10:
        return r10;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.m173toStringimpl(r12) + " is less than minimum " + UInt.m173toStringimpl(r11) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceIn-b33U2AM, reason: not valid java name */
    public static final byte m1296coerceInb33U2AM(byte r10, byte r11, byte r12) {
        int r13 = r11 & 255;
        int r14 = r12 & 255;
        if (Intrinsics.compare(r13, r14) > 0) goto L12;
        int r15 = r10 & 255;
        if (Intrinsics.compare(r15, r13) >= 0) goto L8;
        return r11;
    L8:
        if (Intrinsics.compare(r15, r14) <= 0) goto L10;
        return r12;
    L10:
        return r10;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.m94toStringimpl(r12) + " is less than minimum " + UByte.m94toStringimpl(r11) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceIn-sambcqE, reason: not valid java name */
    public static final long m1297coerceInsambcqE(long r10, long r11, long r12) {
        if (Long.compareUnsigned(r11, r12) > 0) goto L12;
        if (Long.compareUnsigned(r10, r11) >= 0) goto L8;
        return r11;
    L8:
        if (Long.compareUnsigned(r10, r12) <= 0) goto L10;
        return r12;
    L10:
        return r10;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.m252toStringimpl(r12) + " is less than minimum " + ULong.m252toStringimpl(r11) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceIn-wuiCnnA, reason: not valid java name */
    public static final int m1298coerceInwuiCnnA(int r10, ClosedRange<UInt> r11) {
        Intrinsics.checkNotNullParameter(r11, "range");
        if ((r11 instanceof ClosedFloatingPointRange) == false) goto L7;
        return ((UInt) RangesKt___RangesKt.coerceIn(UInt.m121boximpl(r10), (ClosedFloatingPointRange) r11)).m179unboximpl();
    L7:
        if (r11.isEmpty() == true) goto L17;
        if (Integer.compareUnsigned(r10, ((UInt) r11.getStart()).m179unboximpl()) >= 0) goto L13;
        Comparable r12 = r11.getStart();
    L15:
        return ((UInt) r12).m179unboximpl();
    L13:
        if (Integer.compareUnsigned(r10, ((UInt) r11.getEndInclusive()).m179unboximpl()) <= 0) goto L18;
        r12 = r11.getEndInclusive();
        goto L15
    L18:
        return r10;
    L17:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r11 + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: contains-68kG9v0, reason: not valid java name */
    public static final boolean m1299contains68kG9v0(UIntRange r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$contains");
        return r10.m1270containsWZ4Q5Ns(UInt.m127constructorimpl(r11 & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: contains-GYNo2lE, reason: not valid java name */
    private static final boolean m1300containsGYNo2lE(ULongRange r10, ULong r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$contains");
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.m1279containsVKZWuLQ(r11.m258unboximpl()) == false) goto L7;
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: contains-Gab390E, reason: not valid java name */
    public static final boolean m1301containsGab390E(ULongRange r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$contains");
        return r10.m1279containsVKZWuLQ(ULong.m206constructorimpl(((long) r11) & 4294967295L));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: contains-ULb-yJY, reason: not valid java name */
    public static final boolean m1302containsULbyJY(ULongRange r10, byte r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$contains");
        return r10.m1279containsVKZWuLQ(ULong.m206constructorimpl(((long) r11) & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: contains-ZsK3CEQ, reason: not valid java name */
    public static final boolean m1303containsZsK3CEQ(UIntRange r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$contains");
        return r10.m1270containsWZ4Q5Ns(UInt.m127constructorimpl(r11 & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: contains-biwQdVI, reason: not valid java name */
    private static final boolean m1304containsbiwQdVI(UIntRange r10, UInt r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$contains");
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.m1270containsWZ4Q5Ns(r11.m179unboximpl()) == false) goto L7;
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: contains-fz5IDCE, reason: not valid java name */
    public static final boolean m1305containsfz5IDCE(UIntRange r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$contains");
        if (ULong.m206constructorimpl(r11 >>> 32) == 0) goto L5;
    L7:
        return false;
    L5:
        if (r10.m1270containsWZ4Q5Ns(UInt.m127constructorimpl((int) r11)) == false) goto L7;
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: contains-uhHAxoY, reason: not valid java name */
    public static final boolean m1306containsuhHAxoY(ULongRange r10, short r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$contains");
        return r10.m1279containsVKZWuLQ(ULong.m206constructorimpl(((long) r11) & 65535));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: downTo-5PvTz6A, reason: not valid java name */
    public static final UIntProgression m1307downTo5PvTz6A(short r10, short r11) {
        return UIntProgression.Companion.m1267fromClosedRangeNkh28Cs(UInt.m127constructorimpl(r10 & UShort.MAX_VALUE), UInt.m127constructorimpl(r11 & UShort.MAX_VALUE), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: downTo-J1ME1BU, reason: not valid java name */
    public static final UIntProgression m1308downToJ1ME1BU(int r10, int r11) {
        return UIntProgression.Companion.m1267fromClosedRangeNkh28Cs(r10, r11, -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: downTo-Kr8caGY, reason: not valid java name */
    public static final UIntProgression m1309downToKr8caGY(byte r10, byte r11) {
        return UIntProgression.Companion.m1267fromClosedRangeNkh28Cs(UInt.m127constructorimpl(r10 & 255), UInt.m127constructorimpl(r11 & 255), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: downTo-eb3DHEI, reason: not valid java name */
    public static final ULongProgression m1310downToeb3DHEI(long r10, long r11) {
        return ULongProgression.Companion.m1276fromClosedRange7ftBX0g(r10, r11, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final int first(UIntProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.m1265getFirstpVg5ArA();
    L7:
        throw new NoSuchElementException("Progression " + r10 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final long first(ULongProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.m1274getFirstsVKNKU();
    L7:
        throw new NoSuchElementException("Progression " + r10 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final UInt firstOrNull(UIntProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return UInt.m121boximpl(r10.m1265getFirstpVg5ArA());
    }

    @SinceKotlin(version = "1.7")
    public static final ULong firstOrNull(ULongProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return ULong.m200boximpl(r10.m1274getFirstsVKNKU());
    }

    @SinceKotlin(version = "1.7")
    public static final int last(UIntProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.m1266getLastpVg5ArA();
    L7:
        throw new NoSuchElementException("Progression " + r10 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final long last(ULongProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == true) goto L7;
        return r10.m1275getLastsVKNKU();
    L7:
        throw new NoSuchElementException("Progression " + r10 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final UInt lastOrNull(UIntProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return UInt.m121boximpl(r10.m1266getLastpVg5ArA());
    }

    @SinceKotlin(version = "1.7")
    public static final ULong lastOrNull(ULongProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.isEmpty() == false) goto L6;
        return null;
    L6:
        return ULong.m200boximpl(r10.m1275getLastsVKNKU());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int random(UIntRange r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return random(r10, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int random(UIntRange r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        return URandomKt.nextUInt(r11, r10);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final long random(ULongRange r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return random(r10, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long random(ULongRange r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        return URandomKt.nextULong(r11, r10);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final UInt randomOrNull(UIntRange r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return randomOrNull(r10, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    public static final UInt randomOrNull(UIntRange r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        return UInt.m121boximpl(URandomKt.nextUInt(r11, r10));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final ULong randomOrNull(ULongRange r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return randomOrNull(r10, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    public static final ULong randomOrNull(ULongRange r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        if (r10.isEmpty() == false) goto L7;
        return null;
    L7:
        return ULong.m200boximpl(URandomKt.nextULong(r11, r10));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntProgression reversed(UIntProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return UIntProgression.Companion.m1267fromClosedRangeNkh28Cs(r10.m1266getLastpVg5ArA(), r10.m1265getFirstpVg5ArA(), -r10.getStep());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULongProgression reversed(ULongProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ULongProgression.Companion.m1276fromClosedRange7ftBX0g(r10.m1275getLastsVKNKU(), r10.m1274getFirstsVKNKU(), -r10.getStep());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntProgression step(UIntProgression r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        RangesKt__RangesKt.checkStepIsPositive(r12, Integer.valueOf(r11));
        UIntProgression.Companion r13 = UIntProgression.Companion;
        int r14 = r10.m1265getFirstpVg5ArA();
        int r15 = r10.m1266getLastpVg5ArA();
        if (r10.getStep() > 0) goto L11;
        r11 = -r11;
    L11:
        return r13.m1267fromClosedRangeNkh28Cs(r14, r15, r11);
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULongProgression step(ULongProgression r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (r12 <= 0) goto L5;
        boolean r10 = true;
    L6:
        RangesKt__RangesKt.checkStepIsPositive(r10, Long.valueOf(r12));
        ULongProgression.Companion r13 = ULongProgression.Companion;
        long r14 = r11.m1274getFirstsVKNKU();
        long r15 = r11.m1275getLastsVKNKU();
        if (r11.getStep() > 0) goto L11;
        r12 = -r12;
    L11:
        return r13.m1276fromClosedRange7ftBX0g(r14, r15, r12);
    L5:
        r10 = false;
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: until-5PvTz6A, reason: not valid java name */
    public static final UIntRange m1311until5PvTz6A(short r10, short r11) {
        int r12 = r11 & UShort.MAX_VALUE;
        if (Intrinsics.compare(r12, 0) > 0) goto L7;
        return UIntRange.Companion.getEMPTY();
    L7:
        return new UIntRange(UInt.m127constructorimpl(r10 & UShort.MAX_VALUE), UInt.m127constructorimpl(UInt.m127constructorimpl(r12) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: until-J1ME1BU, reason: not valid java name */
    public static UIntRange m1312untilJ1ME1BU(int r10, int r11) {
        if (Integer.compareUnsigned(r11, 0) > 0) goto L7;
        return UIntRange.Companion.getEMPTY();
    L7:
        return new UIntRange(r10, UInt.m127constructorimpl(r11 - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: until-Kr8caGY, reason: not valid java name */
    public static final UIntRange m1313untilKr8caGY(byte r10, byte r11) {
        int r12 = r11 & 255;
        if (Intrinsics.compare(r12, 0) > 0) goto L7;
        return UIntRange.Companion.getEMPTY();
    L7:
        return new UIntRange(UInt.m127constructorimpl(r10 & 255), UInt.m127constructorimpl(UInt.m127constructorimpl(r12) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: until-eb3DHEI, reason: not valid java name */
    public static ULongRange m1314untileb3DHEI(long r10, long r11) {
        if (Long.compareUnsigned(r11, 0) > 0) goto L7;
        return ULongRange.Companion.getEMPTY();
    L7:
        return new ULongRange(r10, ULong.m206constructorimpl(r11 - ULong.m206constructorimpl(((long) 1) & 4294967295L)), null);
    }
}
