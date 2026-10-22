package kotlin;

import androidx.core.internal.view.SupportMenu;
import kotlin.internal.InlineOnly;

/* JADX INFO: loaded from: classes2.dex */
class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    public NumbersKt__NumbersKt() {
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countLeadingZeroBits(byte r10) {
        return Integer.numberOfLeadingZeros(r10 & 255) - 24;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countLeadingZeroBits(short r10) {
        return Integer.numberOfLeadingZeros(r10 & UShort.MAX_VALUE) - 16;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countOneBits(byte r10) {
        return Integer.bitCount(r10 & 255);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countOneBits(short r10) {
        return Integer.bitCount(r10 & UShort.MAX_VALUE);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countTrailingZeroBits(byte r10) {
        return Integer.numberOfTrailingZeros(r10 | 256);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final int countTrailingZeroBits(short r10) {
        return Integer.numberOfTrailingZeros(r10 | UShort.MIN_VALUE);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte rotateLeft(byte r10, int r11) {
        int r12 = r11 & 7;
        int r13 = r10 << r12;
        return (byte) (((r10 & 255) >>> (8 - r12)) | r13);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final short rotateLeft(short r10, int r11) {
        int r12 = r11 & 15;
        int r13 = r10 << r12;
        return (short) (((r10 & SupportMenu.USER_MASK) >>> (16 - r12)) | r13);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte rotateRight(byte r10, int r11) {
        int r12 = r11 & 7;
        int r13 = r10 << (8 - r12);
        return (byte) (((r10 & 255) >>> r12) | r13);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final short rotateRight(short r10, int r11) {
        int r12 = r11 & 15;
        int r13 = r10 << (16 - r12);
        return (short) (((r10 & SupportMenu.USER_MASK) >>> r12) | r13);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final byte takeHighestOneBit(byte r10) {
        return (byte) Integer.highestOneBit(r10 & 255);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final short takeHighestOneBit(short r10) {
        return (short) Integer.highestOneBit(r10 & UShort.MAX_VALUE);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final byte takeLowestOneBit(byte r10) {
        return (byte) Integer.lowestOneBit(r10);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final short takeLowestOneBit(short r10) {
        return (short) Integer.lowestOneBit(r10);
    }
}
