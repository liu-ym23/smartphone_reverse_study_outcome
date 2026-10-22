package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;

/* JADX INFO: loaded from: classes2.dex */
public final class CharCodeKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char Char(int r10) {
        if (r10 < 0) goto L8;
        if (r10 > 65535) goto L8;
        return (char) r10;
    L8:
        throw new IllegalArgumentException("Invalid Char code: " + r10);
    }

    private static final int getCode(char r10) {
        return r10;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static /* synthetic */ void getCode$annotations(char r10) {
    }
}
