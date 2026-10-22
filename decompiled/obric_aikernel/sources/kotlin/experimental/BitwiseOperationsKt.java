package kotlin.experimental;

import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

/* JADX INFO: loaded from: classes2.dex */
public final class BitwiseOperationsKt {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte and(byte r10, byte r11) {
        return (byte) (r10 & r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short and(short r10, short r11) {
        return (short) (r10 & r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte inv(byte r10) {
        return (byte) (~r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short inv(short r10) {
        return (short) (~r10);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte or(byte r10, byte r11) {
        return (byte) (r10 | r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short or(short r10, short r11) {
        return (short) (r10 | r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte xor(byte r10, byte r11) {
        return (byte) (r10 ^ r11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short xor(short r10, short r11) {
        return (short) (r10 ^ r11);
    }
}
