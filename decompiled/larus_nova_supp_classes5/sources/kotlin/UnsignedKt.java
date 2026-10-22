package kotlin;

import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0081\b¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\tH\u0081\b¢\u0006\u0002\u0010\f\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0001\u001a\u001f\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0015\u0010\u0013\u001a\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u000eH\u0001\u001a\u0011\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b\u001a\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b\u001a\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b\u001a\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0081\b\u001a\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b¢\u0006\u0002\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0019H\u0001\u001a\u001f\u0010 \u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\b$\u0010\"\u001a\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0019H\u0001\u001a\u0011\u0010&\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0019H\u0081\b\u001a\u0011\u0010'\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0019H\u0081\b\u001a\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000eH\u0000¨\u0006("}, d2 = {"doubleToUInt", "Lkotlin/UInt;", "value", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "floatToUInt", "", "(F)I", "floatToULong", "(F)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "uintToFloat", "uintToLong", "", "uintToString", "", "base", "uintToULong", "(I)J", "ulongCompare", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToFloat", "ulongToString", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UnsignedKt {
    public static final double uintToDouble(int r6) {
        return ((double) (Integer.MAX_VALUE & r6)) + (((double) ((r6 >>> 31) << 30)) * ((double) 2));
    }

    private static final long uintToLong(int r4) {
        return ((long) r4) & 4294967295L;
    }

    public static final double ulongToDouble(long r4) {
        return ((r4 >>> 11) * ((double) 2048)) + (r4 & 2047);
    }

    public static final int doubleToUInt(double r4) {
        if (Double.isNaN(r4) == false) goto L6;
        return 0;
    L6:
        if (r4 > uintToDouble(0)) goto L9;
        return 0;
    L9:
        if (r4 < uintToDouble(-1)) goto L12;
        return -1;
    L12:
        if (r4 > 2.147483647E9d) goto L15;
        return UInt.m129constructorimpl((int) r4);
    L15:
        return UInt.m129constructorimpl(UInt.m129constructorimpl((int) (r4 - ((double) Integer.MAX_VALUE))) + UInt.m129constructorimpl(Integer.MAX_VALUE));
    }

    public static final long doubleToULong(double r5) {
        if (Double.isNaN(r5) == false) goto L6;
        return 0;
    L6:
        if (r5 > ulongToDouble(0)) goto L9;
        return 0;
    L9:
        if (r5 < ulongToDouble(-1)) goto L12;
        return -1;
    L12:
        if (r5 >= 9.223372036854776E18d) goto L15;
        return ULong.m206constructorimpl((long) r5);
    L15:
        return ULong.m206constructorimpl(ULong.m206constructorimpl((long) (r5 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    private static final int floatToUInt(float r2) {
        return doubleToUInt(r2);
    }

    private static final long floatToULong(float r2) {
        return doubleToULong(r2);
    }

    private static final float uintToFloat(int r2) {
        return (float) uintToDouble(r2);
    }

    private static final String uintToString(int r4) {
        return String.valueOf(((long) r4) & 4294967295L);
    }

    private static final long uintToULong(int r4) {
        return ULong.m206constructorimpl(((long) r4) & 4294967295L);
    }

    private static final float ulongToFloat(long r0) {
        return (float) ulongToDouble(r0);
    }

    private static final String ulongToString(long r1) {
        return ulongToString(r1, 10);
    }

    public static final int uintCompare(int r1, int r2) {
        return Intrinsics.compare(r1 ^ IntCompanionObject.MIN_VALUE, r2 ^ IntCompanionObject.MIN_VALUE);
    }

    /* JADX INFO: renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m351uintDivideJ1ME1BU(int r4, int r5) {
        return UInt.m129constructorimpl((int) ((((long) r4) & 4294967295L) / (((long) r5) & 4294967295L)));
    }

    /* JADX INFO: renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m352uintRemainderJ1ME1BU(int r4, int r5) {
        return UInt.m129constructorimpl((int) ((((long) r4) & 4294967295L) % (((long) r5) & 4294967295L)));
    }

    private static final String uintToString(int r4, int r5) {
        return ulongToString(((long) r4) & 4294967295L, r5);
    }

    public static final int ulongCompare(long r2, long r4) {
        return Intrinsics.compare(r2 ^ Long.MIN_VALUE, r4 ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m353ulongDivideeb3DHEI(long r7, long r9) {
        if (r9 >= 0) goto L10;
        if (Long.compare(r7 ^ Long.MIN_VALUE, r9 ^ Long.MIN_VALUE) >= 0) goto L8;
        return ULong.m206constructorimpl(0);
    L8:
        return ULong.m206constructorimpl(1);
    L10:
        if (r7 >= 0) goto L12;
        int r2 = 1;
        long r3 = ((r7 >>> 1) / r9) << 1;
        long r8 = ULong.m206constructorimpl(r7 - (r3 * r9));
        if (Long.compare(r8 ^ Long.MIN_VALUE, ULong.m206constructorimpl(r9) ^ Long.MIN_VALUE) >= 0) goto L18;
        r2 = 0;
    L18:
        return ULong.m206constructorimpl(r3 + ((long) r2));
    L12:
        return ULong.m206constructorimpl(r7 / r9);
    }

    /* JADX INFO: renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m354ulongRemaindereb3DHEI(long r8, long r10) {
        if (r10 >= 0) goto L10;
        if (Long.compare(r8 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ r10) >= 0) goto L8;
        return r8;
    L8:
        return ULong.m206constructorimpl(r8 - r10);
    L10:
        if (r8 >= 0) goto L12;
        long r9 = r8 - ((((r8 >>> 1) / r10) << 1) * r10);
        if (Long.compare(ULong.m206constructorimpl(r9) ^ Long.MIN_VALUE, Long.MIN_VALUE ^ ULong.m206constructorimpl(r10)) >= 0) goto L18;
        r10 = 0;
    L18:
        return ULong.m206constructorimpl(r9 - r10);
    L12:
        return ULong.m206constructorimpl(r8 % r10);
    }

    public static final String ulongToString(long r7, int r9) {
        if (r7 >= 0) goto L5;
        long r3 = r9;
        long r0 = ((r7 >>> 1) / r3) << 1;
        long r8 = r7 - (r0 * r3);
        if (r8 < r3) goto L10;
        r8 = r8 - r3;
        r0 = r0 + 1;
    L10:
        return Long.toString(r0, CharsKt.checkRadix(r9)) + Long.toString(r8, CharsKt.checkRadix(r9));
    L5:
        return Long.toString(r7, CharsKt.checkRadix(r9));
    }
}
