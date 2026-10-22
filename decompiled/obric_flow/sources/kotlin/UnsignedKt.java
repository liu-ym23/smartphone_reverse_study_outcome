package kotlin;

import androidx.room.jarjarred.org.antlr.runtime.a;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0007\u001a\u0016\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0081\b¢\u0006\u0002\u0010\n\u001a\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\tH\u0081\b¢\u0006\u0002\u0010\f\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0001\u001a\u001f\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0015\u0010\u0013\u001a\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u000eH\u0001\u001a\u0011\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b\u001a\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b\u001a\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b\u001a\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0081\b\u001a\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u000eH\u0081\b¢\u0006\u0002\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0019H\u0001\u001a\u001f\u0010 \u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0001¢\u0006\u0004\b$\u0010\"\u001a\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0019H\u0001\u001a\u0011\u0010&\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0019H\u0081\b\u001a\u0011\u0010'\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0019H\u0081\b\u001a\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000eH\u0000¨\u0006("}, d2 = {"doubleToUInt", "Lkotlin/UInt;", "value", "", "(D)I", "doubleToULong", "Lkotlin/ULong;", "(D)J", "floatToUInt", "", "(F)I", "floatToULong", "(F)J", "uintCompare", "", "v1", "v2", "uintDivide", "uintDivide-J1ME1BU", "(II)I", "uintRemainder", "uintRemainder-J1ME1BU", "uintToDouble", "uintToFloat", "uintToLong", "", "uintToString", "", "base", "uintToULong", "(I)J", "ulongCompare", "ulongDivide", "ulongDivide-eb3DHEI", "(JJ)J", "ulongRemainder", "ulongRemainder-eb3DHEI", "ulongToDouble", "ulongToFloat", "ulongToString", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "UnsignedKt")
public final class UnsignedKt {
    @PublishedApi
    public static final int doubleToUInt(double r5) {
        if (Double.isNaN(r5) == false) goto L6;
        return 0;
    L6:
        if (r5 > uintToDouble(0)) goto L9;
        return 0;
    L9:
        if (r5 < uintToDouble(-1)) goto L12;
        return -1;
    L12:
        if (r5 > 2.147483647E9d) goto L15;
        return UInt.m219constructorimpl((int) r5);
    L15:
        return a.b(Integer.MAX_VALUE, UInt.m219constructorimpl((int) (r5 - ((double) Integer.MAX_VALUE))));
    }

    @PublishedApi
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
        return ULong.m298constructorimpl((long) r5);
    L15:
        return ULong.m298constructorimpl(ULong.m298constructorimpl((long) (r5 - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    @InlineOnly
    private static final int floatToUInt(float r5) {
        return doubleToUInt(r5);
    }

    @PublishedApi
    @InlineOnly
    private static final long floatToULong(float r5) {
        return doubleToULong(r5);
    }

    @PublishedApi
    public static final int uintCompare(int r5, int r10) {
        return Intrinsics.compare(r5 ^ Integer.MIN_VALUE, r10 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* JADX INFO: renamed from: uintDivide-J1ME1BU, reason: not valid java name */
    public static final int m475uintDivideJ1ME1BU(int r5, int r10) {
        return UInt.m219constructorimpl((int) ((((long) r5) & 4294967295L) / (((long) r10) & 4294967295L)));
    }

    @PublishedApi
    /* JADX INFO: renamed from: uintRemainder-J1ME1BU, reason: not valid java name */
    public static final int m476uintRemainderJ1ME1BU(int r5, int r10) {
        return UInt.m219constructorimpl((int) ((((long) r5) & 4294967295L) % (((long) r10) & 4294967295L)));
    }

    @PublishedApi
    public static final double uintToDouble(int r10) {
        return (((double) ((r10 >>> 31) << 30)) * ((double) 2)) + (Integer.MAX_VALUE & r10);
    }

    @PublishedApi
    @InlineOnly
    private static final float uintToFloat(int r5) {
        return (float) uintToDouble(r5);
    }

    @PublishedApi
    @InlineOnly
    private static final long uintToLong(int r5) {
        return ((long) r5) & 4294967295L;
    }

    @InlineOnly
    private static final String uintToString(int r5) {
        return String.valueOf(((long) r5) & 4294967295L);
    }

    @PublishedApi
    @InlineOnly
    private static final long uintToULong(int r5) {
        return ULong.m298constructorimpl(((long) r5) & 4294967295L);
    }

    @PublishedApi
    public static final int ulongCompare(long r5, long r10) {
        return Intrinsics.compare(r5 ^ Long.MIN_VALUE, r10 ^ Long.MIN_VALUE);
    }

    @PublishedApi
    /* JADX INFO: renamed from: ulongDivide-eb3DHEI, reason: not valid java name */
    public static final long m477ulongDivideeb3DHEI(long r5, long r10) {
        if (r10 >= 0) goto L10;
        if (Long.compareUnsigned(r5, r10) >= 0) goto L8;
        return ULong.m298constructorimpl(0);
    L8:
        return ULong.m298constructorimpl(1);
    L10:
        if (r5 >= 0) goto L12;
        int r11 = 1;
        long r12 = ((r5 >>> 1) / r10) << 1;
        if (Long.compareUnsigned(ULong.m298constructorimpl(r5 - (r12 * r10)), ULong.m298constructorimpl(r10)) >= 0) goto L18;
        r11 = 0;
    L18:
        return ULong.m298constructorimpl(r12 + ((long) r11));
    L12:
        return ULong.m298constructorimpl(r5 / r10);
    }

    @PublishedApi
    /* JADX INFO: renamed from: ulongRemainder-eb3DHEI, reason: not valid java name */
    public static final long m478ulongRemaindereb3DHEI(long r10, long r11) {
        if (r11 >= 0) goto L10;
        if (Long.compareUnsigned(r10, r11) >= 0) goto L8;
        return r10;
    L8:
        return ULong.m298constructorimpl(r10 - r11);
    L10:
        if (r10 >= 0) goto L12;
        long r12 = r10 - ((((r10 >>> 1) / r11) << 1) * r11);
        if (Long.compareUnsigned(ULong.m298constructorimpl(r12), ULong.m298constructorimpl(r11)) >= 0) goto L18;
        r11 = 0;
    L18:
        return ULong.m298constructorimpl(r12 - r11);
    L12:
        return ULong.m298constructorimpl(r10 % r11);
    }

    @PublishedApi
    public static final double ulongToDouble(long r5) {
        return ((r5 >>> 11) * ((double) 2048)) + (r5 & 2047);
    }

    @PublishedApi
    @InlineOnly
    private static final float ulongToFloat(long r5) {
        return (float) ulongToDouble(r5);
    }

    @InlineOnly
    private static final String ulongToString(long r5) {
        return ulongToString(r5, 10);
    }

    @InlineOnly
    private static final String uintToString(int r5, int r10) {
        return ulongToString(((long) r5) & 4294967295L, r10);
    }

    public static final String ulongToString(long r10, int r11) {
        if (r10 >= 0) goto L5;
        long r5 = r11;
        long r12 = ((r10 >>> 1) / r5) << 1;
        long r13 = r10 - (r12 * r5);
        if (r13 < r5) goto L10;
        r13 = r13 - r5;
        r12 = r12 + 1;
    L10:
        return Long.toString(r12, CharsKt.checkRadix(r11)) + Long.toString(r13, CharsKt.checkRadix(r11));
    L5:
        return Long.toString(r10, CharsKt.checkRadix(r11));
    }
}
