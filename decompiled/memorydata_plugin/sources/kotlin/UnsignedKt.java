package kotlin;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crash.entity.EventBody;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0081\b¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\tH\u0081\b¢\u0006\u0002\u0010\f\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0001\u001a\u001f\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0015\u0010\u0013\u001a\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u000eH\u0001\u001a\u0011\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b\u001a\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b\u001a\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b\u001a\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0081\b\u001a\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b¢\u0006\u0002\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0019H\u0001\u001a\u001f\u0010 \u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\b$\u0010\"\u001a\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0019H\u0001\u001a\u0011\u0010&\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0019H\u0081\b\u001a\u0011\u0010'\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0019H\u0081\b\u001a\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000eH\u0000¨\u0006("}, d2 = {"doubleToUInt", "Lkotlin/UInt;", EventBody.KEY_VALUE, "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "floatToUInt", "", "(F)I", "floatToULong", "(F)J", "uintCompare", "", LocationInfoConst.LIBRA_PARAM_V1, LocationInfoConst.LIBRA_PARAM_V2, "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "uintToFloat", "uintToLong", "", "uintToString", "", "base", "uintToULong", "(I)J", "ulongCompare", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToFloat", "ulongToString", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UnsignedKt {
    public static final int doubleToUInt(double r5) {
        if (Double.isNaN(r5) == false) goto L6;
    L17:
        return 0;
    L6:
        if (r5 <= uintToDouble(0)) goto L17;
        if (r5 < uintToDouble(-1)) goto L12;
        return -1;
    L12:
        if (r5 > 2.147483647E9d) goto L14;
        int r6 = (int) r5;
    L16:
        return UInt.m1516constructorimpl(r6);
    L14:
        r6 = UInt.m1516constructorimpl((int) (r5 - ((double) Integer.MAX_VALUE))) + UInt.m1516constructorimpl(Integer.MAX_VALUE);
        goto L16
    }

    public static final long doubleToULong(double r7) {
        if (Double.isNaN(r7) == false) goto L6;
    L17:
        return 0;
    L6:
        if (r7 <= ulongToDouble(0)) goto L17;
        if (r7 < ulongToDouble(-1)) goto L12;
        return -1;
    L12:
        if (r7 >= 9.223372036854776E18d) goto L14;
        long r8 = (long) r7;
    L16:
        return ULong.m1595constructorimpl(r8);
    L14:
        r8 = ULong.m1595constructorimpl((long) (r7 - 9.223372036854776E18d)) - Long.MIN_VALUE;
        goto L16
    }

    private static final int floatToUInt(float r2) {
        return doubleToUInt(r2);
    }

    private static final long floatToULong(float r2) {
        return doubleToULong(r2);
    }

    public static final int uintCompare(int r1, int r2) {
        return Intrinsics.compare(r1 ^ Integer.MIN_VALUE, r2 ^ Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m1772uintDivideJ1ME1BU(int r4, int r5) {
        return UInt.m1516constructorimpl((int) ((((long) r4) & 4294967295L) / (((long) r5) & 4294967295L)));
    }

    /* JADX INFO: renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m1773uintRemainderJ1ME1BU(int r4, int r5) {
        return UInt.m1516constructorimpl((int) ((((long) r4) & 4294967295L) % (((long) r5) & 4294967295L)));
    }

    public static final double uintToDouble(int r6) {
        return ((double) (Integer.MAX_VALUE & r6)) + (((double) ((r6 >>> 31) << 30)) * ((double) 2));
    }

    private static final float uintToFloat(int r2) {
        return (float) uintToDouble(r2);
    }

    private static final long uintToLong(int r4) {
        return ((long) r4) & 4294967295L;
    }

    private static final String uintToString(int r4) {
        return String.valueOf(((long) r4) & 4294967295L);
    }

    private static final String uintToString(int r4, int r5) {
        return ulongToString(((long) r4) & 4294967295L, r5);
    }

    private static final long uintToULong(int r4) {
        return ULong.m1595constructorimpl(((long) r4) & 4294967295L);
    }

    public static final int ulongCompare(long r2, long r4) {
        return Intrinsics.compare(r2 ^ Long.MIN_VALUE, r4 ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m1774ulongDivideeb3DHEI(long r5, long r7) {
        if (r7 >= 0) goto L10;
        if (Long.compareUnsigned(r5, r7) >= 0) goto L8;
        return ULong.m1595constructorimpl(0);
    L8:
        return ULong.m1595constructorimpl(1);
    L10:
        if (r5 >= 0) goto L12;
        int r0 = 1;
        long r1 = ((r5 >>> 1) / r7) << 1;
        if (Long.compareUnsigned(ULong.m1595constructorimpl(r5 - (r1 * r7)), ULong.m1595constructorimpl(r7)) >= 0) goto L18;
        r0 = 0;
    L18:
        return ULong.m1595constructorimpl(r1 + ((long) r0));
    L12:
        return ULong.m1595constructorimpl(r5 / r7);
    }

    /* JADX INFO: renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m1775ulongRemaindereb3DHEI(long r6, long r8) {
        if (r8 >= 0) goto L10;
        if (Long.compareUnsigned(r6, r8) >= 0) goto L8;
        return r6;
    L8:
        return ULong.m1595constructorimpl(r6 - r8);
    L10:
        if (r6 < 0) goto L14;
        long r7 = r6 % r8;
    L13:
        return ULong.m1595constructorimpl(r7);
    L14:
        long r9 = r6 - ((((r6 >>> 1) / r8) << 1) * r8);
        if (Long.compareUnsigned(ULong.m1595constructorimpl(r9), ULong.m1595constructorimpl(r8)) >= 0) goto L18;
        r8 = 0;
    L18:
        r7 = r9 - r8;
        goto L13
    }

    public static final double ulongToDouble(long r4) {
        return ((r4 >>> 11) * ((double) 2048)) + (r4 & 2047);
    }

    private static final float ulongToFloat(long r0) {
        return (float) ulongToDouble(r0);
    }

    private static final String ulongToString(long r1) {
        return ulongToString(r1, 10);
    }

    public static final String ulongToString(long r8, int r10) {
        if (r8 < 0) goto L6;
        String r9 = Long.toString(r8, CharsKt.checkRadix(r10));
        Intrinsics.checkNotNullExpressionValue(r9, "toString(...)");
        return r9;
    L6:
        long r4 = r10;
        long r2 = ((r8 >>> 1) / r4) << 1;
        long r11 = r8 - (r2 * r4);
        if (r11 < r4) goto L9;
        r11 = r11 - r4;
        r2 = r2 + 1;
    L9:
        StringBuilder r0 = new StringBuilder();
        String r3 = Long.toString(r2, CharsKt.checkRadix(r10));
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        StringBuilder r1 = r0.append(r3);
        String r12 = Long.toString(r11, CharsKt.checkRadix(r10));
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        return r1.append(r12).toString();
    }
}
