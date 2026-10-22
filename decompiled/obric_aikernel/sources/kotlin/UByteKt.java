package kotlin;

import kotlin.internal.InlineOnly;

/* JADX INFO: loaded from: classes2.dex */
public final class UByteKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final byte toUByte(byte r10) {
        return UByte.m50constructorimpl(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final byte toUByte(int r10) {
        return UByte.m50constructorimpl((byte) r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final byte toUByte(long r10) {
        return UByte.m50constructorimpl((byte) r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    private static final byte toUByte(short r10) {
        return UByte.m50constructorimpl((byte) r10);
    }
}
