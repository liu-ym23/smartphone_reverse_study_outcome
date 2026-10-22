package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
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
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\n\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u001b\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001b\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\n\u001a\u001b\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0013\u0010\r\u001a#\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a!\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a#\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a!\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b!\u0010\"\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0087\n¢\u0006\u0002\b*\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0087\u0002¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b-\u0010.\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\b0\u00101\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b2\u00103\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0087\n¢\u0006\u0002\b4\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b5\u00106\u001a\u001c\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004¢\u0006\u0004\b:\u0010;\u001a\u001c\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004¢\u0006\u0004\b<\u0010=\u001a\u001c\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004¢\u0006\u0004\b?\u0010@\u001a\u001c\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004¢\u0006\u0004\bA\u0010B\u001a\u0011\u0010C\u001a\u00020\u0005*\u000208H\u0007¢\u0006\u0002\u0010D\u001a\u0011\u0010C\u001a\u00020\b*\u00020>H\u0007¢\u0006\u0002\u0010E\u001a\u000e\u0010F\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007\u001a\u000e\u0010F\u001a\u0004\u0018\u00010\b*\u00020>H\u0007\u001a\u0011\u0010G\u001a\u00020\u0005*\u000208H\u0007¢\u0006\u0002\u0010D\u001a\u0011\u0010G\u001a\u00020\b*\u00020>H\u0007¢\u0006\u0002\u0010E\u001a\u000e\u0010H\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007\u001a\u000e\u0010H\u001a\u0004\u0018\u00010\b*\u00020>H\u0007\u001a\u0012\u0010I\u001a\u00020\u0005*\u00020%H\u0087\b¢\u0006\u0002\u0010J\u001a\u0019\u0010I\u001a\u00020\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007¢\u0006\u0002\u0010L\u001a\u0012\u0010I\u001a\u00020\b*\u00020/H\u0087\b¢\u0006\u0002\u0010M\u001a\u0019\u0010I\u001a\u00020\b*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007¢\u0006\u0002\u0010N\u001a\u000f\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%H\u0087\b\u001a\u0016\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007\u001a\u000f\u0010O\u001a\u0004\u0018\u00010\b*\u00020/H\u0087\b\u001a\u0016\u0010O\u001a\u0004\u0018\u00010\b*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007\u001a\f\u0010P\u001a\u000208*\u000208H\u0007\u001a\f\u0010P\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010Q\u001a\u000208*\u0002082\u0006\u0010Q\u001a\u00020RH\u0087\u0004\u001a\u0015\u0010Q\u001a\u00020>*\u00020>2\u0006\u0010Q\u001a\u00020SH\u0087\u0004\u001a\u001c\u0010T\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004¢\u0006\u0004\bU\u0010V\u001a\u001c\u0010T\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004¢\u0006\u0004\bW\u0010X\u001a\u001c\u0010T\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004¢\u0006\u0004\bY\u0010Z\u001a\u001c\u0010T\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004¢\u0006\u0004\b[\u0010\\¨\u0006]"}, d2 = {"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "first", "(Lkotlin/ranges/UIntProgression;)I", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/ranges/URangesKt")
class URangesKt___URangesKt {
    public URangesKt___URangesKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtLeast-5PvTz6A, reason: not valid java name */
    public static final short m1364coerceAtLeast5PvTz6A(short r5, short r10) {
        if (Intrinsics.compare(r5 & UShort.MAX_VALUE, 65535 & r10) < 0) goto L5;
        return r5;
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtLeast-J1ME1BU, reason: not valid java name */
    public static final int m1365coerceAtLeastJ1ME1BU(int r5, int r10) {
        if (Integer.compareUnsigned(r5, r10) < 0) goto L5;
        return r5;
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtLeast-Kr8caGY, reason: not valid java name */
    public static final byte m1366coerceAtLeastKr8caGY(byte r5, byte r10) {
        if (Intrinsics.compare(r5 & UByte.MAX_VALUE, r10 & UByte.MAX_VALUE) < 0) goto L5;
        return r5;
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtLeast-eb3DHEI, reason: not valid java name */
    public static final long m1367coerceAtLeasteb3DHEI(long r5, long r10) {
        if (Long.compareUnsigned(r5, r10) < 0) goto L5;
        return r5;
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtMost-5PvTz6A, reason: not valid java name */
    public static final short m1368coerceAtMost5PvTz6A(short r5, short r10) {
        if (Intrinsics.compare(r5 & UShort.MAX_VALUE, 65535 & r10) > 0) goto L5;
        return r5;
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtMost-J1ME1BU, reason: not valid java name */
    public static final int m1369coerceAtMostJ1ME1BU(int r5, int r10) {
        if (Integer.compareUnsigned(r5, r10) > 0) goto L5;
        return r5;
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtMost-Kr8caGY, reason: not valid java name */
    public static final byte m1370coerceAtMostKr8caGY(byte r5, byte r10) {
        if (Intrinsics.compare(r5 & UByte.MAX_VALUE, r10 & UByte.MAX_VALUE) > 0) goto L5;
        return r5;
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceAtMost-eb3DHEI, reason: not valid java name */
    public static final long m1371coerceAtMosteb3DHEI(long r5, long r10) {
        if (Long.compareUnsigned(r5, r10) > 0) goto L5;
        return r5;
    L5:
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceIn-JPwROB0, reason: not valid java name */
    public static final long m1372coerceInJPwROB0(long r5, ClosedRange<ULong> r10) {
        Intrinsics.checkNotNullParameter(r10, "range");
        if ((r10 instanceof ClosedFloatingPointRange) == false) goto L7;
        return ((ULong) RangesKt___RangesKt.coerceIn(ULong.m292boximpl(r5), (ClosedFloatingPointRange) r10)).m350unboximpl();
    L7:
        if (r10.isEmpty() == true) goto L16;
        if (Long.compareUnsigned(r5, ((ULong) r10.getStart()).m350unboximpl()) >= 0) goto L12;
        return ((ULong) r10.getStart()).m350unboximpl();
    L12:
        if (Long.compareUnsigned(r5, ((ULong) r10.getEndInclusive()).m350unboximpl()) > 0) goto L14;
        return r5;
    L14:
        return ((ULong) r10.getEndInclusive()).m350unboximpl();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r10 + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceIn-VKSA0NQ, reason: not valid java name */
    public static final short m1373coerceInVKSA0NQ(short r5, short r10, short r11) {
        int r12 = r10 & UShort.MAX_VALUE;
        int r13 = r11 & UShort.MAX_VALUE;
        if (Intrinsics.compare(r12, r13) > 0) goto L12;
        int r14 = 65535 & r5;
        if (Intrinsics.compare(r14, r12) >= 0) goto L8;
        return r10;
    L8:
        if (Intrinsics.compare(r14, r13) <= 0) goto L10;
        return r11;
    L10:
        return r5;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.m449toStringimpl(r11) + " is less than minimum " + UShort.m449toStringimpl(r10) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceIn-WZ9TVnA, reason: not valid java name */
    public static final int m1374coerceInWZ9TVnA(int r5, int r10, int r11) {
        if (Integer.compareUnsigned(r10, r11) > 0) goto L12;
        if (Integer.compareUnsigned(r5, r10) >= 0) goto L8;
        return r10;
    L8:
        if (Integer.compareUnsigned(r5, r11) <= 0) goto L10;
        return r11;
    L10:
        return r5;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.m265toStringimpl(r11) + " is less than minimum " + UInt.m265toStringimpl(r10) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceIn-b33U2AM, reason: not valid java name */
    public static final byte m1375coerceInb33U2AM(byte r5, byte r10, byte r11) {
        int r12 = r10 & UByte.MAX_VALUE;
        int r13 = r11 & UByte.MAX_VALUE;
        if (Intrinsics.compare(r12, r13) > 0) goto L12;
        int r14 = r5 & UByte.MAX_VALUE;
        if (Intrinsics.compare(r14, r12) >= 0) goto L8;
        return r10;
    L8:
        if (Intrinsics.compare(r14, r13) <= 0) goto L10;
        return r11;
    L10:
        return r5;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.m186toStringimpl(r11) + " is less than minimum " + UByte.m186toStringimpl(r10) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceIn-sambcqE, reason: not valid java name */
    public static final long m1376coerceInsambcqE(long r5, long r10, long r11) {
        if (Long.compareUnsigned(r10, r11) > 0) goto L12;
        if (Long.compareUnsigned(r5, r10) >= 0) goto L8;
        return r10;
    L8:
        if (Long.compareUnsigned(r5, r11) <= 0) goto L10;
        return r11;
    L10:
        return r5;
    L12:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.m344toStringimpl(r11) + " is less than minimum " + ULong.m344toStringimpl(r10) + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: coerceIn-wuiCnnA, reason: not valid java name */
    public static final int m1377coerceInwuiCnnA(int r5, ClosedRange<UInt> r10) {
        Intrinsics.checkNotNullParameter(r10, "range");
        if ((r10 instanceof ClosedFloatingPointRange) == false) goto L7;
        return ((UInt) RangesKt___RangesKt.coerceIn(UInt.m213boximpl(r5), (ClosedFloatingPointRange) r10)).m271unboximpl();
    L7:
        if (r10.isEmpty() == true) goto L16;
        if (Integer.compareUnsigned(r5, ((UInt) r10.getStart()).m271unboximpl()) >= 0) goto L12;
        return ((UInt) r10.getStart()).m271unboximpl();
    L12:
        if (Integer.compareUnsigned(r5, ((UInt) r10.getEndInclusive()).m271unboximpl()) > 0) goto L14;
        return r5;
    L14:
        return ((UInt) r10.getEndInclusive()).m271unboximpl();
    L16:
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + r10 + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: contains-68kG9v0, reason: not valid java name */
    public static final boolean m1378contains68kG9v0(UIntRange r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$contains");
        return r5.m1351containsWZ4Q5Ns(UInt.m219constructorimpl(r10 & UByte.MAX_VALUE));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: contains-GYNo2lE, reason: not valid java name */
    private static final boolean m1379containsGYNo2lE(ULongRange r5, ULong r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$contains");
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.m1360containsVKZWuLQ(r10.m350unboximpl()) == false) goto L7;
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: contains-Gab390E, reason: not valid java name */
    public static final boolean m1380containsGab390E(ULongRange r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$contains");
        return r5.m1360containsVKZWuLQ(ULong.m298constructorimpl(((long) r10) & 4294967295L));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: contains-ULb-yJY, reason: not valid java name */
    public static final boolean m1381containsULbyJY(ULongRange r5, byte r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$contains");
        return r5.m1360containsVKZWuLQ(ULong.m298constructorimpl(((long) r10) & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: contains-ZsK3CEQ, reason: not valid java name */
    public static final boolean m1382containsZsK3CEQ(UIntRange r5, short r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$contains");
        return r5.m1351containsWZ4Q5Ns(UInt.m219constructorimpl(r10 & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* JADX INFO: renamed from: contains-biwQdVI, reason: not valid java name */
    private static final boolean m1383containsbiwQdVI(UIntRange r5, UInt r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$contains");
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.m1351containsWZ4Q5Ns(r10.m271unboximpl()) == false) goto L7;
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: contains-fz5IDCE, reason: not valid java name */
    public static final boolean m1384containsfz5IDCE(UIntRange r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$contains");
        if (ULong.m298constructorimpl(r10 >>> 32) == 0) goto L5;
    L7:
        return false;
    L5:
        if (r5.m1351containsWZ4Q5Ns(UInt.m219constructorimpl((int) r10)) == false) goto L7;
        return true;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: contains-uhHAxoY, reason: not valid java name */
    public static final boolean m1385containsuhHAxoY(ULongRange r5, short r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$contains");
        return r5.m1360containsVKZWuLQ(ULong.m298constructorimpl(((long) r10) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: downTo-5PvTz6A, reason: not valid java name */
    public static final UIntProgression m1386downTo5PvTz6A(short r5, short r10) {
        return UIntProgression.Companion.m1348fromClosedRangeNkh28Cs(UInt.m219constructorimpl(r5 & UShort.MAX_VALUE), UInt.m219constructorimpl(r10 & UShort.MAX_VALUE), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: downTo-J1ME1BU, reason: not valid java name */
    public static final UIntProgression m1387downToJ1ME1BU(int r5, int r10) {
        return UIntProgression.Companion.m1348fromClosedRangeNkh28Cs(r5, r10, -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: downTo-Kr8caGY, reason: not valid java name */
    public static final UIntProgression m1388downToKr8caGY(byte r5, byte r10) {
        return UIntProgression.Companion.m1348fromClosedRangeNkh28Cs(UInt.m219constructorimpl(r5 & UByte.MAX_VALUE), UInt.m219constructorimpl(r10 & UByte.MAX_VALUE), -1);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: downTo-eb3DHEI, reason: not valid java name */
    public static final ULongProgression m1389downToeb3DHEI(long r10, long r11) {
        return ULongProgression.Companion.m1357fromClosedRange7ftBX0g(r10, r11, -1);
    }

    @SinceKotlin(version = "1.7")
    public static final int first(UIntProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == true) goto L7;
        return r5.m1346getFirstpVg5ArA();
    L7:
        throw new NoSuchElementException("Progression " + r5 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final UInt firstOrNull(UIntProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        return UInt.m213boximpl(r5.m1346getFirstpVg5ArA());
    }

    @SinceKotlin(version = "1.7")
    public static final int last(UIntProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == true) goto L7;
        return r5.m1347getLastpVg5ArA();
    L7:
        throw new NoSuchElementException("Progression " + r5 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final UInt lastOrNull(UIntProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        return UInt.m213boximpl(r5.m1347getLastpVg5ArA());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final int random(UIntRange r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return random(r5, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final UInt randomOrNull(UIntRange r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return randomOrNull(r5, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntProgression reversed(UIntProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return UIntProgression.Companion.m1348fromClosedRangeNkh28Cs(r5.m1347getLastpVg5ArA(), r5.m1346getFirstpVg5ArA(), -r5.getStep());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntProgression step(UIntProgression r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        RangesKt__RangesKt.checkStepIsPositive(r11, Integer.valueOf(r10));
        UIntProgression.Companion r12 = UIntProgression.Companion;
        int r13 = r5.m1346getFirstpVg5ArA();
        int r14 = r5.m1347getLastpVg5ArA();
        if (r5.getStep() > 0) goto L11;
        r10 = -r10;
    L11:
        return r12.m1348fromClosedRangeNkh28Cs(r13, r14, r10);
    L5:
        r11 = false;
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: until-5PvTz6A, reason: not valid java name */
    public static final UIntRange m1390until5PvTz6A(short r5, short r10) {
        int r11 = r10 & UShort.MAX_VALUE;
        if (Intrinsics.compare(r11, 0) > 0) goto L7;
        return UIntRange.Companion.getEMPTY();
    L7:
        return new UIntRange(UInt.m219constructorimpl(r5 & UShort.MAX_VALUE), UInt.m219constructorimpl(UInt.m219constructorimpl(r11) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: until-J1ME1BU, reason: not valid java name */
    public static UIntRange m1391untilJ1ME1BU(int r5, int r10) {
        if (Integer.compareUnsigned(r10, 0) > 0) goto L7;
        return UIntRange.Companion.getEMPTY();
    L7:
        return new UIntRange(r5, UInt.m219constructorimpl(r10 - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: until-Kr8caGY, reason: not valid java name */
    public static final UIntRange m1392untilKr8caGY(byte r5, byte r10) {
        int r11 = r10 & UByte.MAX_VALUE;
        if (Intrinsics.compare(r11, 0) > 0) goto L7;
        return UIntRange.Companion.getEMPTY();
    L7:
        return new UIntRange(UInt.m219constructorimpl(r5 & UByte.MAX_VALUE), UInt.m219constructorimpl(UInt.m219constructorimpl(r11) - 1), null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: until-eb3DHEI, reason: not valid java name */
    public static ULongRange m1393untileb3DHEI(long r10, long r11) {
        if (Long.compareUnsigned(r11, 0) > 0) goto L7;
        return ULongRange.Companion.getEMPTY();
    L7:
        return new ULongRange(r10, ULong.m298constructorimpl(r11 - ULong.m298constructorimpl(((long) 1) & 4294967295L)), null);
    }

    @SinceKotlin(version = "1.7")
    public static final ULong firstOrNull(ULongProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        return ULong.m292boximpl(r5.m1355getFirstsVKNKU());
    }

    @SinceKotlin(version = "1.7")
    public static final ULong lastOrNull(ULongProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == false) goto L6;
        return null;
    L6:
        return ULong.m292boximpl(r5.m1356getLastsVKNKU());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final long random(ULongRange r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return random(r5, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final ULong randomOrNull(ULongRange r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return randomOrNull(r5, Random.Default);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULongProgression reversed(ULongProgression r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ULongProgression.Companion.m1357fromClosedRange7ftBX0g(r10.m1356getLastsVKNKU(), r10.m1355getFirstsVKNKU(), -r10.getStep());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int random(UIntRange r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        return URandomKt.nextUInt(r10, r5);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    public static final UInt randomOrNull(UIntRange r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        if (r5.isEmpty() == false) goto L7;
        return null;
    L7:
        return UInt.m213boximpl(URandomKt.nextUInt(r10, r5));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULongProgression step(ULongProgression r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (r12 <= 0) goto L5;
        boolean r5 = true;
    L6:
        RangesKt__RangesKt.checkStepIsPositive(r5, Long.valueOf(r12));
        ULongProgression.Companion r10 = ULongProgression.Companion;
        long r13 = r11.m1355getFirstsVKNKU();
        long r14 = r11.m1356getLastsVKNKU();
        if (r11.getStep() > 0) goto L11;
        r12 = -r12;
    L11:
        return r10.m1357fromClosedRange7ftBX0g(r13, r14, r12);
    L5:
        r5 = false;
        goto L6
    }

    @SinceKotlin(version = "1.7")
    public static final long first(ULongProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == true) goto L7;
        return r5.m1355getFirstsVKNKU();
    L7:
        throw new NoSuchElementException("Progression " + r5 + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final long last(ULongProgression r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isEmpty() == true) goto L7;
        return r5.m1356getLastsVKNKU();
    L7:
        throw new NoSuchElementException("Progression " + r5 + " is empty.");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long random(ULongRange r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        return URandomKt.nextULong(r10, r5);
    L5:
        e = move-exception;
        throw new NoSuchElementException(e.getMessage());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    public static final ULong randomOrNull(ULongRange r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        if (r5.isEmpty() == false) goto L7;
        return null;
    L7:
        return ULong.m292boximpl(URandomKt.nextULong(r10, r5));
    }
}
