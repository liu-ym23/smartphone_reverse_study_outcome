package kotlin.random;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nURandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 URandom.kt\nkotlin/random/URandomKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
public final class URandomKt {
    /* JADX INFO: renamed from: checkUIntRangeBounds-J1ME1BU, reason: not valid java name */
    public static final void m1256checkUIntRangeBoundsJ1ME1BU(int r10, int r11) {
        if (Integer.compareUnsigned(r11, r10) <= 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m121boximpl(r10), UInt.m121boximpl(r11)).toString());
    L5:
        r12 = false;
        goto L6
    }

    /* JADX INFO: renamed from: checkULongRangeBounds-eb3DHEI, reason: not valid java name */
    public static final void m1257checkULongRangeBoundseb3DHEI(long r10, long r11) {
        if (Long.compareUnsigned(r11, r10) <= 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m200boximpl(r10), ULong.m200boximpl(r11)).toString());
    L5:
        r12 = false;
        goto L6
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final byte[] nextUBytes(Random r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return UByteArray.m103constructorimpl(r10.nextBytes(r11));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: nextUBytes-EVgfTAA, reason: not valid java name */
    public static final byte[] m1258nextUBytesEVgfTAA(Random r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(r11, "array");
        r10.nextBytes(r11);
        return r11;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4, reason: not valid java name */
    public static final byte[] m1259nextUBytesWvrt4B4(Random r10, byte[] r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(r11, "array");
        r10.nextBytes(r11, r12, r13);
        return r11;
    }

    /* JADX INFO: renamed from: nextUBytes-Wvrt4B4$default, reason: not valid java name */
    public static /* synthetic */ byte[] m1260nextUBytesWvrt4B4$default(Random r10, byte[] r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 0;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = UByteArray.m109getSizeimpl(r11);
    L9:
        return m1259nextUBytesWvrt4B4(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int nextUInt(Random r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return UInt.m127constructorimpl(r10.nextInt());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int nextUInt(Random r10, UIntRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        if (r11.isEmpty() == true) goto L13;
        if (Integer.compareUnsigned(r11.m1266getLastpVg5ArA(), -1) >= 0) goto L8;
        return m1261nextUInta8DCA5k(r10, r11.m1265getFirstpVg5ArA(), UInt.m127constructorimpl(r11.m1266getLastpVg5ArA() + 1));
    L8:
        if (Integer.compareUnsigned(r11.m1265getFirstpVg5ArA(), 0) <= 0) goto L11;
        return UInt.m127constructorimpl(m1261nextUInta8DCA5k(r10, UInt.m127constructorimpl(r11.m1265getFirstpVg5ArA() - 1), r11.m1266getLastpVg5ArA()) + 1);
    L11:
        return nextUInt(r10);
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: nextUInt-a8DCA5k, reason: not valid java name */
    public static final int m1261nextUInta8DCA5k(Random r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$nextUInt");
        m1256checkUIntRangeBoundsJ1ME1BU(r11, r12);
        return UInt.m127constructorimpl(r10.nextInt(r11 ^ Integer.MIN_VALUE, r12 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: nextUInt-qCasIEU, reason: not valid java name */
    public static final int m1262nextUIntqCasIEU(Random r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$nextUInt");
        return m1261nextUInta8DCA5k(r10, 0, r11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long nextULong(Random r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return ULong.m206constructorimpl(r10.nextLong());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long nextULong(Random r10, ULongRange r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "range");
        if (r11.isEmpty() == true) goto L13;
        int r12 = Long.compareUnsigned(r11.m1275getLastsVKNKU(), -1);
        long r13 = r11.m1274getFirstsVKNKU();
        if (r12 >= 0) goto L8;
        return m1264nextULongjmpaWc(r10, r13, ULong.m206constructorimpl(r11.m1275getLastsVKNKU() + ULong.m206constructorimpl(((long) 1) & 4294967295L)));
    L8:
        if (Long.compareUnsigned(r13, 0) <= 0) goto L11;
        long r14 = ((long) 1) & 4294967295L;
        return ULong.m206constructorimpl(m1264nextULongjmpaWc(r10, ULong.m206constructorimpl(r11.m1274getFirstsVKNKU() - ULong.m206constructorimpl(r14)), r11.m1275getLastsVKNKU()) + ULong.m206constructorimpl(r14));
    L11:
        return nextULong(r10);
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: nextULong-V1Xi4fY, reason: not valid java name */
    public static final long m1263nextULongV1Xi4fY(Random r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$nextULong");
        return m1264nextULongjmpaWc(r10, 0, r11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* JADX INFO: renamed from: nextULong-jmpaW-c, reason: not valid java name */
    public static final long m1264nextULongjmpaWc(Random r10, long r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$nextULong");
        m1257checkULongRangeBoundseb3DHEI(r11, r12);
        return ULong.m206constructorimpl(r10.nextLong(r11 ^ Long.MIN_VALUE, r12 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }
}
