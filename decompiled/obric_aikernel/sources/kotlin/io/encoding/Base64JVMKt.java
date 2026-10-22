package kotlin.io.encoding;

import java.nio.charset.Charset;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
public final class Base64JVMKt {
    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    @InlineOnly
    private static final byte[] platformCharsToBytes(Base64 r10, CharSequence r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "source");
        if ((r11 instanceof String) == false) goto L6;
        r10.checkSourceBounds$kotlin_stdlib(r11.length(), r12, r13);
        String r14 = ((String) r11).substring(r12, r13);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String…ing(startIndex, endIndex)");
        Charset r15 = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type java.lang.String");
        byte[] r16 = r14.getBytes(r15);
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).getBytes(charset)");
        return r16;
    L6:
        return r10.charsToBytesImpl$kotlin_stdlib(r11, r12, r13);
    }

    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    @InlineOnly
    private static final int platformEncodeIntoByteArray(Base64 r10, byte[] r11, byte[] r12, int r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r12, "destination");
        return r10.encodeIntoByteArrayImpl$kotlin_stdlib(r11, r12, r13, r14, r15);
    }

    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    @InlineOnly
    private static final byte[] platformEncodeToByteArray(Base64 r10, byte[] r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "source");
        return r10.encodeToByteArrayImpl$kotlin_stdlib(r11, r12, r13);
    }

    @ExperimentalEncodingApi
    @SinceKotlin(version = "1.8")
    @InlineOnly
    private static final String platformEncodeToString(Base64 r10, byte[] r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "source");
        return new String(r10.encodeToByteArrayImpl$kotlin_stdlib(r11, r12, r13), Charsets.ISO_8859_1);
    }
}
