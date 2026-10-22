package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
class NumbersKt__NumbersJVMKt extends NumbersKt__FloorDivModKt {
    public NumbersKt__NumbersJVMKt() {
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countLeadingZeroBits(int r10) {
        return Integer.numberOfLeadingZeros(r10);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countLeadingZeroBits(long r10) {
        return Long.numberOfLeadingZeros(r10);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countOneBits(int r10) {
        return Integer.bitCount(r10);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countOneBits(long r10) {
        return Long.bitCount(r10);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countTrailingZeroBits(int r10) {
        return Integer.numberOfTrailingZeros(r10);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countTrailingZeroBits(long r10) {
        return Long.numberOfTrailingZeros(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double fromBits(DoubleCompanionObject r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Double.longBitsToDouble(r11);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float fromBits(FloatCompanionObject r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Float.intBitsToFloat(r11);
    }

    @InlineOnly
    private static final boolean isFinite(double r10) {
        if (Double.isInfinite(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (Double.isNaN(r10) == true) goto L7;
        return true;
    }

    @InlineOnly
    private static final boolean isFinite(float r10) {
        if (Float.isInfinite(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (Float.isNaN(r10) == true) goto L7;
        return true;
    }

    @InlineOnly
    private static final boolean isInfinite(double r10) {
        return Double.isInfinite(r10);
    }

    @InlineOnly
    private static final boolean isInfinite(float r10) {
        return Float.isInfinite(r10);
    }

    @InlineOnly
    private static final boolean isNaN(double r10) {
        return Double.isNaN(r10);
    }

    @InlineOnly
    private static final boolean isNaN(float r10) {
        return Float.isNaN(r10);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int rotateLeft(int r10, int r11) {
        return Integer.rotateLeft(r10, r11);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long rotateLeft(long r10, int r11) {
        return Long.rotateLeft(r10, r11);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int rotateRight(int r10, int r11) {
        return Integer.rotateRight(r10, r11);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long rotateRight(long r10, int r11) {
        return Long.rotateRight(r10, r11);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int takeHighestOneBit(int r10) {
        return Integer.highestOneBit(r10);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long takeHighestOneBit(long r10) {
        return Long.highestOneBit(r10);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int takeLowestOneBit(int r10) {
        return Integer.lowestOneBit(r10);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final long takeLowestOneBit(long r10) {
        return Long.lowestOneBit(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int toBits(float r10) {
        return Float.floatToIntBits(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long toBits(double r10) {
        return Double.doubleToLongBits(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int toRawBits(float r10) {
        return Float.floatToRawIntBits(r10);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long toRawBits(double r10) {
        return Double.doubleToRawLongBits(r10);
    }
}
