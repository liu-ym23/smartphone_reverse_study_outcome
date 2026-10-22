package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\t*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\tH\u0087\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\tH\u0087\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\tH\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0002*\u00020\u0006H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\tH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0006H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\tH\u0087\b¨\u0006\u0016"}, d2 = {"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__NumbersJVMKt extends NumbersKt__FloorDivModKt {
    public NumbersKt__NumbersJVMKt() {
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int countLeadingZeroBits(int r5) {
        return Integer.numberOfLeadingZeros(r5);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int countOneBits(int r5) {
        return Integer.bitCount(r5);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int countTrailingZeroBits(int r5) {
        return Integer.numberOfTrailingZeros(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double fromBits(DoubleCompanionObject r5, long r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Double.longBitsToDouble(r10);
    }

    @InlineOnly
    private static final boolean isFinite(double r5) {
        if (Double.isInfinite(r5) == false) goto L5;
    L7:
        return false;
    L5:
        if (Double.isNaN(r5) == true) goto L7;
        return true;
    }

    @InlineOnly
    private static final boolean isInfinite(double r5) {
        return Double.isInfinite(r5);
    }

    @InlineOnly
    private static final boolean isNaN(double r5) {
        return Double.isNaN(r5);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int rotateLeft(int r5, int r10) {
        return Integer.rotateLeft(r5, r10);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int rotateRight(int r5, int r10) {
        return Integer.rotateRight(r5, r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int takeHighestOneBit(int r5) {
        return Integer.highestOneBit(r5);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int takeLowestOneBit(int r5) {
        return Integer.lowestOneBit(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long toBits(double r5) {
        return Double.doubleToLongBits(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long toRawBits(double r5) {
        return Double.doubleToRawLongBits(r5);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int countLeadingZeroBits(long r5) {
        return Long.numberOfLeadingZeros(r5);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int countOneBits(long r5) {
        return Long.bitCount(r5);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final int countTrailingZeroBits(long r5) {
        return Long.numberOfTrailingZeros(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float fromBits(FloatCompanionObject r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Float.intBitsToFloat(r10);
    }

    @InlineOnly
    private static final boolean isFinite(float r5) {
        if (Float.isInfinite(r5) == false) goto L5;
    L7:
        return false;
    L5:
        if (Float.isNaN(r5) == true) goto L7;
        return true;
    }

    @InlineOnly
    private static final boolean isInfinite(float r5) {
        return Float.isInfinite(r5);
    }

    @InlineOnly
    private static final boolean isNaN(float r5) {
        return Float.isNaN(r5);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long rotateLeft(long r5, int r10) {
        return Long.rotateLeft(r5, r10);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long rotateRight(long r5, int r10) {
        return Long.rotateRight(r5, r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final long takeHighestOneBit(long r5) {
        return Long.highestOneBit(r5);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final long takeLowestOneBit(long r5) {
        return Long.lowestOneBit(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int toBits(float r5) {
        return Float.floatToIntBits(r5);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int toRawBits(float r5) {
        return Float.floatToRawIntBits(r5);
    }
}
