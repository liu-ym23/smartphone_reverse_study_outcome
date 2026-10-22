package kotlin.random;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007¢\u0006\u0002\u0010\u0019\u001a\u001b\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a\u0011\u0010!\u001a\u00020\b*\u00020\rH\u0007¢\u0006\u0002\u0010\"\u001a\u001b\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010$\u001a#\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007¢\u0006\u0004\b%\u0010&\u001a\u0019\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007¢\u0006\u0002\u0010(¨\u0006)"}, d2 = {"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nURandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URandom.kt\nkotlin/random/URandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
public final class URandomKt {
    /* JADX INFO: renamed from: checkUIntRangeBounds-J1ME1BU, reason: not valid java name */
    public static final void m1337checkUIntRangeBoundsJ1ME1BU(int r5, int r10) {
        if (Integer.compareUnsigned(r10, r5) <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m213boximpl(r5), UInt.m213boximpl(r10)).toString());
    }

    /* JADX INFO: renamed from: checkULongRangeBounds-eb3DHEI, reason: not valid java name */
    public static final void m1338checkULongRangeBoundseb3DHEI(long r5, long r10) {
        if (Long.compareUnsigned(r10, r5) <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m292boximpl(r5), ULong.m292boximpl(r10)).toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] nextUBytes(Random r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return UByteArray.m195constructorimpl(r5.nextBytes(r10));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: nextUBytes-EVgfTAA, reason: not valid java name */
    public static final byte[] m1339nextUBytesEVgfTAA(Random r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(r10, "array");
        r5.nextBytes(r10);
        return r10;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4, reason: not valid java name */
    public static final byte[] m1340nextUBytesWvrt4B4(Random r5, byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(r10, "array");
        r5.nextBytes(r10, r11, r12);
        return r10;
    }

    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4$default, reason: not valid java name */
    public static /* synthetic */ byte[] m1341nextUBytesWvrt4B4$default(Random r5, byte[] r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = 0;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = UByteArray.m201getSizeimpl(r10);
    L9:
        return m1340nextUBytesWvrt4B4(r5, r10, r11, r12);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int nextUInt(Random r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return UInt.m219constructorimpl(r5.nextInt());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: nextUInt-a8DCA5k, reason: not valid java name */
    public static final int m1342nextUInta8DCA5k(Random r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "$this$nextUInt");
        m1337checkUIntRangeBoundsJ1ME1BU(r10, r11);
        return UInt.m219constructorimpl(r5.nextInt(r10 ^ Integer.MIN_VALUE, r11 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: nextUInt-qCasIEU, reason: not valid java name */
    public static final int m1343nextUIntqCasIEU(Random r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$nextUInt");
        return m1342nextUInta8DCA5k(r5, 0, r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long nextULong(Random r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return ULong.m298constructorimpl(r5.nextLong());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: nextULong-V1Xi4fY, reason: not valid java name */
    public static final long m1344nextULongV1Xi4fY(Random r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "$this$nextULong");
        return m1345nextULongjmpaWc(r5, 0, r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: nextULong-jmpaW-c, reason: not valid java name */
    public static final long m1345nextULongjmpaWc(Random r5, long r10, long r11) {
        Intrinsics.checkNotNullParameter(r5, "$this$nextULong");
        m1338checkULongRangeBoundseb3DHEI(r10, r11);
        return ULong.m298constructorimpl(r5.nextLong(r10 ^ Long.MIN_VALUE, r11 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int nextUInt(Random r5, UIntRange r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "range");
        if (r10.isEmpty() == true) goto L13;
        if (Integer.compareUnsigned(r10.m1347getLastpVg5ArA(), -1) >= 0) goto L8;
        return m1342nextUInta8DCA5k(r5, r10.m1346getFirstpVg5ArA(), UInt.m219constructorimpl(r10.m1347getLastpVg5ArA() + 1));
    L8:
        if (Integer.compareUnsigned(r10.m1346getFirstpVg5ArA(), 0) <= 0) goto L11;
        return UInt.m219constructorimpl(m1342nextUInta8DCA5k(r5, UInt.m219constructorimpl(r10.m1346getFirstpVg5ArA() - 1), r10.m1347getLastpVg5ArA()) + 1);
    L11:
        return nextUInt(r5);
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long nextULong(Random r10, ULongRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        if (r11.isEmpty() == true) goto L13;
        if (Long.compareUnsigned(r11.m1356getLastsVKNKU(), -1) >= 0) goto L8;
        return m1345nextULongjmpaWc(r10, r11.m1355getFirstsVKNKU(), ULong.m298constructorimpl(ULong.m298constructorimpl(((long) 1) & 4294967295L) + r11.m1356getLastsVKNKU()));
    L8:
        if (Long.compareUnsigned(r11.m1355getFirstsVKNKU(), 0) <= 0) goto L11;
        long r5 = ((long) 1) & 4294967295L;
        return ULong.m298constructorimpl(ULong.m298constructorimpl(r5) + m1345nextULongjmpaWc(r10, ULong.m298constructorimpl(r11.m1355getFirstsVKNKU() - ULong.m298constructorimpl(r5)), r11.m1356getLastsVKNKU()));
    L11:
        return nextULong(r10);
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r11);
    }
}
