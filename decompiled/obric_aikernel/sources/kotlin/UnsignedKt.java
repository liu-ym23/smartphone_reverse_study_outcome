package kotlin;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes2.dex */
@JvmName(name = "UnsignedKt")
public final class UnsignedKt {
    @PublishedApi
    public static final int doubleToUInt(double r10) {
        if (Double.isNaN(r10) == false) goto L6;
    L17:
        return 0;
    L6:
        if (r10 <= uintToDouble(0)) goto L17;
        if (r10 < uintToDouble(-1)) goto L12;
        return -1;
    L12:
        if (r10 > 2.147483647E9d) goto L14;
        int r11 = (int) r10;
    L16:
        return UInt.m127constructorimpl(r11);
    L14:
        r11 = UInt.m127constructorimpl((int) (r10 - ((double) Integer.MAX_VALUE))) + UInt.m127constructorimpl(Integer.MAX_VALUE);
        goto L16
    }

    @PublishedApi
    public static final long doubleToULong(double r10) {
        if (Double.isNaN(r10) == false) goto L6;
    L17:
        return 0;
    L6:
        if (r10 <= ulongToDouble(0)) goto L17;
        if (r10 < ulongToDouble(-1)) goto L12;
        return -1;
    L12:
        if (r10 >= 9.223372036854776E18d) goto L14;
        long r11 = (long) r10;
    L16:
        return ULong.m206constructorimpl(r11);
    L14:
        r11 = ULong.m206constructorimpl((long) (r10 - 9.223372036854776E18d)) - Long.MIN_VALUE;
        goto L16
    }

    @PublishedApi
    public static final int uintCompare(int r10, int r11) {
        return Intrinsics.compare(r10 ^ Integer.MIN_VALUE, r11 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* JADX INFO: renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m383uintDivideJ1ME1BU(int r10, int r11) {
        return UInt.m127constructorimpl((int) ((((long) r10) & 4294967295L) / (((long) r11) & 4294967295L)));
    }

    @PublishedApi
    /* JADX INFO: renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m384uintRemainderJ1ME1BU(int r10, int r11) {
        return UInt.m127constructorimpl((int) ((((long) r10) & 4294967295L) % (((long) r11) & 4294967295L)));
    }

    @PublishedApi
    public static final double uintToDouble(int r10) {
        return ((double) (Integer.MAX_VALUE & r10)) + (((double) ((r10 >>> 31) << 30)) * ((double) 2));
    }

    @PublishedApi
    public static final int ulongCompare(long r10, long r11) {
        return Intrinsics.compare(r10 ^ Long.MIN_VALUE, r11 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    /* JADX INFO: renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m385ulongDivideeb3DHEI(long r10, long r11) {
        if (r11 >= 0) goto L10;
        if (Long.compareUnsigned(r10, r11) >= 0) goto L8;
        return ULong.m206constructorimpl(0);
    L8:
        return ULong.m206constructorimpl(1);
    L10:
        if (r10 >= 0) goto L12;
        int r12 = 1;
        long r13 = ((r10 >>> 1) / r11) << 1;
        if (Long.compareUnsigned(ULong.m206constructorimpl(r10 - (r13 * r11)), ULong.m206constructorimpl(r11)) >= 0) goto L18;
        r12 = 0;
    L18:
        return ULong.m206constructorimpl(r13 + ((long) r12));
    L12:
        return ULong.m206constructorimpl(r10 / r11);
    }

    @PublishedApi
    /* JADX INFO: renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m386ulongRemaindereb3DHEI(long r10, long r11) {
        if (r11 >= 0) goto L10;
        if (Long.compareUnsigned(r10, r11) >= 0) goto L8;
        return r10;
    L8:
        return ULong.m206constructorimpl(r10 - r11);
    L10:
        if (r10 < 0) goto L14;
        long r12 = r10 % r11;
    L13:
        return ULong.m206constructorimpl(r12);
    L14:
        long r13 = r10 - ((((r10 >>> 1) / r11) << 1) * r11);
        if (Long.compareUnsigned(ULong.m206constructorimpl(r13), ULong.m206constructorimpl(r11)) >= 0) goto L18;
        r11 = 0;
    L18:
        r12 = r13 - r11;
        goto L13
    }

    @PublishedApi
    public static final double ulongToDouble(long r10) {
        return ((r10 >>> 11) * ((double) 2048)) + (r10 & 2047);
    }

    public static final String ulongToString(long r10) {
        return ulongToString(r10, 10);
    }

    public static final String ulongToString(long r10, int r11) {
        if (r10 < 0) goto L6;
        String r12 = Long.toString(r10, CharsKt.checkRadix(r11));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(this, checkRadix(radix))");
        return r12;
    L6:
        long r13 = r11;
        long r14 = ((r10 >>> 1) / r13) << 1;
        long r15 = r10 - (r14 * r13);
        if (r15 < r13) goto L9;
        r15 = r15 - r13;
        r14 = r14 + 1;
    L9:
        StringBuilder r16 = new StringBuilder();
        String r17 = Long.toString(r14, CharsKt.checkRadix(r11));
        Intrinsics.checkNotNullExpressionValue(r17, "toString(this, checkRadix(radix))");
        r16.append(r17);
        String r18 = Long.toString(r15, CharsKt.checkRadix(r11));
        Intrinsics.checkNotNullExpressionValue(r18, "toString(this, checkRadix(radix))");
        r16.append(r18);
        return r16.toString();
    }
}
