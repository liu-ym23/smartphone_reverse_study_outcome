package kotlin.random;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007¢\u0006\u0002\u0010\u0019\u001a\u001b\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010 \u001a\u0011\u0010!\u001a\u00020\b*\u00020\rH\u0007¢\u0006\u0002\u0010\"\u001a\u001b\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010$\u001a#\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007¢\u0006\u0004\b%\u0010&\u001a\u0019\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007¢\u0006\u0002\u0010(¨\u0006)"}, d2 = {"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class URandomKt {
    public static final int nextUInt(Random r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return UInt.m129constructorimpl(r1.nextInt());
    }

    public static final long nextULong(Random r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return ULong.m206constructorimpl(r2.nextLong());
    }

    /* JADX INFO: renamed from: checkUIntRangeBounds-J1ME1BU, reason: not valid java name */
    public static final void m359checkUIntRangeBoundsJ1ME1BU(int r2, int r3) {
        if (Integer.compare(r3 ^ IntCompanionObject.MIN_VALUE, Integer.MIN_VALUE ^ r2) <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m123boximpl(r2), UInt.m123boximpl(r3)).toString());
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: checkULongRangeBounds-eb3DHEI, reason: not valid java name */
    public static final void m360checkULongRangeBoundseb3DHEI(long r4, long r6) {
        if (Long.compare(r6 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ r4) <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m200boximpl(r4), ULong.m200boximpl(r6)).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final byte[] nextUBytes(Random r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return UByteArray.m107constructorimpl(r1.nextBytes(r2));
    }

    /* JADX INFO: renamed from: nextUBytes-EVgfTAA, reason: not valid java name */
    public static final byte[] m361nextUBytesEVgfTAA(Random r1, byte[] r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(r2, "array");
        r1.nextBytes(r2);
        return r2;
    }

    public static final int nextUInt(Random r3, UIntRange r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "range");
        if (r4.isEmpty() == true) goto L13;
        if (Integer.compare(r4.getLast-pVg5ArA() ^ IntCompanionObject.MIN_VALUE, Integer.MAX_VALUE) >= 0) goto L8;
        return m364nextUInta8DCA5k(r3, r4.getFirst-pVg5ArA(), UInt.m129constructorimpl(r4.getLast-pVg5ArA() + 1));
    L8:
        if (Integer.compare(r4.getFirst-pVg5ArA() ^ IntCompanionObject.MIN_VALUE, IntCompanionObject.MIN_VALUE) <= 0) goto L11;
        return UInt.m129constructorimpl(m364nextUInta8DCA5k(r3, UInt.m129constructorimpl(r4.getFirst-pVg5ArA() - 1), r4.getLast-pVg5ArA()) + 1);
    L11:
        return nextUInt(r3);
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r4);
    }

    /* JADX INFO: renamed from: nextUInt-qCasIEU, reason: not valid java name */
    public static final int m365nextUIntqCasIEU(Random r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$nextUInt");
        return m364nextUInta8DCA5k(r1, 0, r2);
    }

    public static final long nextULong(Random r8, ULongRange r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "range");
        if (r9.isEmpty() == true) goto L13;
        if (Long.compare(r9.getLast-s-VKNKU() ^ Long.MIN_VALUE, LongCompanionObject.MAX_VALUE) >= 0) goto L8;
        return m367nextULongjmpaWc(r8, r9.getFirst-s-VKNKU(), ULong.m206constructorimpl(r9.getLast-s-VKNKU() + ULong.m206constructorimpl(((long) 1) & 4294967295L)));
    L8:
        if (Long.compare(r9.getFirst-s-VKNKU() ^ Long.MIN_VALUE, Long.MIN_VALUE) <= 0) goto L11;
        long r0 = ((long) 1) & 4294967295L;
        return ULong.m206constructorimpl(m367nextULongjmpaWc(r8, ULong.m206constructorimpl(r9.getFirst-s-VKNKU() - ULong.m206constructorimpl(r0)), r9.getLast-s-VKNKU()) + ULong.m206constructorimpl(r0));
    L11:
        return nextULong(r8);
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r9);
    }

    /* JADX INFO: renamed from: nextULong-V1Xi4fY, reason: not valid java name */
    public static final long m366nextULongV1Xi4fY(Random r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$nextULong");
        return m367nextULongjmpaWc(r2, 0, r3);
    }

    /* JADX INFO: renamed from: nextUInt-a8DCA5k, reason: not valid java name */
    public static final int m364nextUInta8DCA5k(Random r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$nextUInt");
        m359checkUIntRangeBoundsJ1ME1BU(r2, r3);
        return UInt.m129constructorimpl(r1.nextInt(r2 ^ IntCompanionObject.MIN_VALUE, r3 ^ IntCompanionObject.MIN_VALUE) ^ IntCompanionObject.MIN_VALUE);
    }

    /* JADX INFO: renamed from: nextULong-jmpaW-c, reason: not valid java name */
    public static final long m367nextULongjmpaWc(Random r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$nextULong");
        m360checkULongRangeBoundseb3DHEI(r3, r5);
        return ULong.m206constructorimpl(r2.nextLong(r3 ^ Long.MIN_VALUE, r5 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4, reason: not valid java name */
    public static final byte[] m362nextUBytesWvrt4B4(Random r1, byte[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(r2, "array");
        r1.nextBytes(r2, r3, r4);
        return r2;
    }

    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4$default, reason: not valid java name */
    public static /* synthetic */ byte[] m363nextUBytesWvrt4B4$default(Random r0, byte[] r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = UByteArray.m113getSizeimpl(r1);
    L9:
        return m362nextUBytesWvrt4B4(r0, r1, r2, r3);
    }
}
