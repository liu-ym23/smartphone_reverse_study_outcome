package kotlin.io.encoding;

import java.nio.charset.Charset;
import kotlin.SinceKotlin;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
@ExperimentalEncodingApi
@SinceKotlin(version = "1.8")
public class Base64 {
    public static final Default Default = null;
    private static final Base64 Mime = null;
    private static final Base64 UrlSafe = null;
    private static final int bitsPerByte = 8;
    private static final int bitsPerSymbol = 6;
    public static final int bytesPerGroup = 3;
    private static final int mimeGroupsPerLine = 19;
    public static final int mimeLineLength = 76;
    private static final byte[] mimeLineSeparatorSymbols = null;
    public static final byte padSymbol = 61;
    public static final int symbolsPerGroup = 4;
    private final boolean isMimeScheme;
    private final boolean isUrlSafe;

    public static final class Default extends Base64 {
        private Default() {
            boolean r10 = false;
            super(r10, r10, null);
        }

        public /* synthetic */ Default(DefaultConstructorMarker r10) {
            this();
        }

        public final Base64 getMime() {
            return Base64.access$getMime$cp();
        }

        public final byte[] getMimeLineSeparatorSymbols$kotlin_stdlib() {
            return Base64.access$getMimeLineSeparatorSymbols$cp();
        }

        public final Base64 getUrlSafe() {
            return Base64.access$getUrlSafe$cp();
        }
    }

    static {
        Default = new Default(null);
        mimeLineSeparatorSymbols = new byte[]{13, 10};
        UrlSafe = new Base64(true, false);
        Mime = new Base64(false, true);
    }

    private Base64(boolean r10, boolean r11) {
        this.isUrlSafe = r10;
        this.isMimeScheme = r11;
        if (r10 == false) goto L7;
        if (r11 == false) goto L7;
        boolean r12 = false;
    L8:
        if (r12 == false) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L7:
        r12 = true;
        goto L8
    }

    public /* synthetic */ Base64(boolean r10, boolean r11, DefaultConstructorMarker r12) {
        this(r10, r11);
    }

    public static final /* synthetic */ Base64 access$getMime$cp() {
        return Mime;
    }

    public static final /* synthetic */ byte[] access$getMimeLineSeparatorSymbols$cp() {
        return mimeLineSeparatorSymbols;
    }

    public static final /* synthetic */ Base64 access$getUrlSafe$cp() {
        return UrlSafe;
    }

    private final void checkDestinationBounds(int r10, int r11, int r12) {
        if (r11 < 0) goto L12;
        if (r11 > r10) goto L12;
        int r13 = r11 + r12;
        if (r13 < 0) goto L10;
        if (r13 > r10) goto L10;
        return;
    L10:
        throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + r11 + ", destination size: " + r10 + ", capacity needed: " + r12);
    L12:
        throw new IndexOutOfBoundsException("destination offset: " + r11 + ", destination size: " + r10);
    }

    public static /* synthetic */ byte[] decode$default(Base64 r10, CharSequence r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        if ((r14 & 4) == 0) goto L10;
        r13 = r11.length();
    L10:
        return r10.decode(r11, r12, r13);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public static /* synthetic */ byte[] decode$default(Base64 r10, byte[] r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        if ((r14 & 4) == 0) goto L10;
        r13 = r11.length;
    L10:
        return r10.decode(r11, r12, r13);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    private final int decodeImpl(byte[] r19, byte[] r20, int r21, int r22, int r23) {
        if (this.isUrlSafe == false) goto L5;
        int[] r10 = Base64Kt.access$getBase64UrlDecodeMap$p();
    L6:
        int r11 = -8;
        int r12 = r21;
        int r13 = 0;
        int r14 = -8;
        int r15 = r22;
    L8:
        if (r15 >= r23) goto L29;
        if (r14 == r11) goto L11;
    L16:
        int r16 = r19[r15] & 255;
        int r17 = r10[r16];
        if (r17 >= 0) goto L25;
        if (r17 == (-2)) goto L19;
        if (this.isMimeScheme == false) goto L23;
        r15 = r15 + 1;
    L28:
        r11 = -8;
        goto L8
    L23:
        StringBuilder r18 = new StringBuilder();
        r18.append("Invalid symbol '");
        r18.append((char) r16);
        r18.append("'(");
        String r24 = Integer.toString(r16, CharsKt.checkRadix(8));
        Intrinsics.checkNotNullExpressionValue(r24, "toString(this, checkRadix(radix))");
        r18.append(r24);
        r18.append(") at index ");
        r18.append(r15);
        throw new IllegalArgumentException(r18.toString());
    L19:
        r15 = handlePaddingSymbol(r19, r15, r23, r14);
        goto L29
    L25:
        r15 = r15 + 1;
        r13 = (r13 << 6) | r17;
        r14 = r14 + 6;
        if (r14 < 0) goto L28;
        r20[r12] = (byte) (r13 >>> r14);
        r13 = r13 & ((1 << r14) - 1);
        r14 = r14 - 8;
        r12 = r12 + 1;
        goto L28
    L11:
        if ((r15 + 3) >= r23) goto L16;
        int r110 = r15 + 1;
        int r25 = r10[r19[r15] & 255];
        int r111 = r110 + 1;
        int r112 = r10[r19[r110] & 255];
        int r113 = r111 + 1;
        int r26 = r10[r19[r111] & 255];
        int r114 = r113 + 1;
        int r27 = (((r25 << 18) | (r112 << 12)) | (r26 << 6)) | r10[r19[r113] & 255];
        if (r27 < 0) goto L15;
        int r28 = r12 + 1;
        r20[r12] = (byte) (r27 >> 16);
        int r29 = r28 + 1;
        r20[r28] = (byte) (r27 >> 8);
        r20[r29] = (byte) r27;
        r12 = r29 + 1;
        r15 = r114;
        goto L28
    L15:
        r15 = r114 - 4;
    L29:
        if (r14 == (-2)) goto L37;
        int r30 = skipIllegalSymbolsIfMime(r19, r15, r23);
        if (r30 >= r23) goto L33;
        int r31 = r19[r30] & 255;
        StringBuilder r32 = new StringBuilder();
        r32.append("Symbol '");
        r32.append((char) r31);
        r32.append("'(");
        String r33 = Integer.toString(r31, CharsKt.checkRadix(8));
        Intrinsics.checkNotNullExpressionValue(r33, "toString(this, checkRadix(radix))");
        r32.append(r33);
        r32.append(") at index ");
        r32.append(r30 - 1);
        r32.append(" is prohibited after the pad character");
        throw new IllegalArgumentException(r32.toString());
    L33:
        return r12 - r21;
    L37:
        throw new IllegalArgumentException("The last unit of input does not have enough bits");
    L5:
        r10 = Base64Kt.access$getBase64DecodeMap$p();
        goto L6
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 r10, CharSequence r11, byte[] r12, int r13, int r14, int r15, int r16, Object r17) {
        if (r17 != null) goto L17;
        if ((r16 & 4) == 0) goto L6;
        int r18 = 0;
    L8:
        if ((r16 & 8) == 0) goto L10;
        int r19 = 0;
    L12:
        if ((r16 & 16) == 0) goto L15;
        r15 = r11.length();
    L15:
        return r10.decodeIntoByteArray(r11, r12, r18, r19, r15);
    L10:
        r19 = r14;
        goto L12
    L6:
        r18 = r13;
        goto L8
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 r10, byte[] r11, byte[] r12, int r13, int r14, int r15, int r16, Object r17) {
        if (r17 != null) goto L17;
        if ((r16 & 4) == 0) goto L6;
        int r18 = 0;
    L8:
        if ((r16 & 8) == 0) goto L10;
        int r19 = 0;
    L12:
        if ((r16 & 16) == 0) goto L15;
        r15 = r11.length;
    L15:
        return r10.decodeIntoByteArray(r11, r12, r18, r19, r15);
    L10:
        r19 = r14;
        goto L12
    L6:
        r18 = r13;
        goto L8
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    private final int decodeSize(byte[] r10, int r11, int r12) {
        int r13 = r12 - r11;
        if (r13 != 0) goto L7;
        return 0;
    L7:
        if (r13 == 1) goto L26;
        if (this.isMimeScheme == false) goto L19;
    L10:
        if (r11 >= r12) goto L24;
        int r14 = Base64Kt.access$getBase64DecodeMap$p()[r10[r11] & 255];
        if (r14 >= 0) goto L17;
        if (r14 == (-2)) goto L15;
        r13 = r13 - 1;
        goto L17
    L15:
        r13 = r13 - (r12 - r11);
    L17:
        r11 = r11 + 1;
    L24:
        return (int) ((((long) r13) * ((long) 6)) / ((long) 8));
    L19:
        if (r10[r12 - 1] != 61) goto L24;
        r13 = r13 - 1;
        if (r10[r12 - 2] != 61) goto L24;
        r13 = r13 - 1;
        goto L24
    L26:
        throw new IllegalArgumentException("Input should have at list 2 symbols for Base64 decoding, startIndex: " + r11 + ", endIndex: " + r12);
    }

    public static /* synthetic */ String encode$default(Base64 r10, byte[] r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        if ((r14 & 4) == 0) goto L10;
        r13 = r11.length;
    L10:
        return r10.encode(r11, r12, r13);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
    }

    public static /* synthetic */ int encodeIntoByteArray$default(Base64 r10, byte[] r11, byte[] r12, int r13, int r14, int r15, int r16, Object r17) {
        if (r17 != null) goto L17;
        if ((r16 & 4) == 0) goto L6;
        int r18 = 0;
    L8:
        if ((r16 & 8) == 0) goto L10;
        int r19 = 0;
    L12:
        if ((r16 & 16) == 0) goto L15;
        r15 = r11.length;
    L15:
        return r10.encodeIntoByteArray(r11, r12, r18, r19, r15);
    L10:
        r19 = r14;
        goto L12
    L6:
        r18 = r13;
        goto L8
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
    }

    private final int encodeSize(int r10) {
        int r11 = ((r10 + 3) - 1) / 3;
        if (this.isMimeScheme == false) goto L5;
        int r12 = (r11 - 1) / 19;
    L6:
        int r13 = (r11 * 4) + (r12 * 2);
        if (r13 < 0) goto L10;
        return r13;
    L10:
        throw new IllegalArgumentException("Input is too big");
    L5:
        r12 = 0;
        goto L6
    }

    public static /* synthetic */ Appendable encodeToAppendable$default(Base64 r10, byte[] r11, Appendable r12, int r13, int r14, int r15, Object r16) {
        if (r16 != null) goto L12;
        if ((r15 & 4) == 0) goto L7;
        r13 = 0;
    L7:
        if ((r15 & 8) == 0) goto L10;
        r14 = r11.length;
    L10:
        return r10.encodeToAppendable(r11, r12, r13, r14);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(Base64 r10, byte[] r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        if ((r14 & 4) == 0) goto L10;
        r13 = r11.length;
    L10:
        return r10.encodeToByteArray(r11, r12, r13);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
    }

    private final int handlePaddingSymbol(byte[] r10, int r11, int r12, int r13) {
        if (r13 == (-8)) goto L23;
        if (r13 == (-6)) goto L21;
        if (r13 != (-4)) goto L9;
        int r14 = skipIllegalSymbolsIfMime(r10, r11 + 1, r12);
        if (r14 == r12) goto L19;
        if (r10[r14] != 61) goto L19;
        return r14 + 1;
    L19:
        throw new IllegalArgumentException("Missing one pad character at index " + r14);
    L9:
        if (r13 == (-2)) goto L21;
        throw new IllegalStateException("Unreachable".toString());
    L21:
        return r11 + 1;
    L23:
        throw new IllegalArgumentException("Redundant pad character at index " + r11);
    }

    private final int skipIllegalSymbolsIfMime(byte[] r10, int r11, int r12) {
        if (this.isMimeScheme == true) goto L5;
        return r11;
    L5:
        if (r11 >= r12) goto L10;
        int r13 = r10[r11] & 255;
        if (Base64Kt.access$getBase64DecodeMap$p()[r13] != (-1)) goto L8;
        r11 = r11 + 1;
        goto L5
    L8:
        return r11;
    L10:
        return r11;
    }

    public final String bytesToStringImpl$kotlin_stdlib(byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        StringBuilder r11 = new StringBuilder(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.append((char) r10[r13]);
        r13 = r13 + 1;
        goto L3
    L5:
        String r14 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r14, "stringBuilder.toString()");
        return r14;
    }

    public final byte[] charsToBytesImpl$kotlin_stdlib(CharSequence r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        checkSourceBounds$kotlin_stdlib(r10.length(), r11, r12);
        byte[] r13 = new byte[r12 - r11];
        int r14 = 0;
    L3:
        if (r11 >= r12) goto L9;
        char r15 = r10.charAt(r11);
        if (r15 > 255) goto L7;
        r13[r14] = (byte) r15;
        r14 = r14 + 1;
    L8:
        r11 = r11 + 1;
        goto L3
    L7:
        r13[r14] = 63;
        r14 = r14 + 1;
        goto L8
    L9:
        return r13;
    }

    public final void checkSourceBounds$kotlin_stdlib(int r10, int r11, int r12) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r11, r12, r10);
    }

    public final byte[] decode(CharSequence r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if ((r10 instanceof String) == false) goto L5;
        checkSourceBounds$kotlin_stdlib(r10.length(), r11, r12);
        String r13 = ((String) r10).substring(r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        Charset r14 = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.lang.String");
        byte[] r15 = r13.getBytes(r14);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).getBytes(charset)");
    L7:
        return decode$default(this, r15, 0, 0, 6, null);
    L5:
        r15 = charsToBytesImpl$kotlin_stdlib(r10, r11, r12);
        goto L7
    }

    public final byte[] decode(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        checkSourceBounds$kotlin_stdlib(r10.length, r11, r12);
        int r13 = decodeSize(r10, r11, r12);
        byte[] r14 = new byte[r13];
        if (decodeImpl(r10, r14, 0, r11, r12) != r13) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L9;
        return r14;
    L9:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r15 = false;
        goto L6
    }

    public final int decodeIntoByteArray(CharSequence r10, byte[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "destination");
        if ((r10 instanceof String) == false) goto L5;
        checkSourceBounds$kotlin_stdlib(r10.length(), r13, r14);
        String r15 = ((String) r10).substring(r13, r14);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String…ing(startIndex, endIndex)");
        Charset r16 = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type java.lang.String");
        byte[] r17 = r15.getBytes(r16);
        Intrinsics.checkNotNullExpressionValue(r17, "this as java.lang.String).getBytes(charset)");
    L7:
        return decodeIntoByteArray$default(this, r17, r11, r12, 0, 0, 24, null);
    L5:
        r17 = charsToBytesImpl$kotlin_stdlib(r10, r13, r14);
        goto L7
    }

    public final int decodeIntoByteArray(byte[] r10, byte[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "destination");
        checkSourceBounds$kotlin_stdlib(r10.length, r13, r14);
        checkDestinationBounds(r11.length, r12, decodeSize(r10, r13, r14));
        return decodeImpl(r10, r11, r12, r13, r14);
    }

    public final String encode(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        return new String(encodeToByteArrayImpl$kotlin_stdlib(r10, r11, r12), Charsets.ISO_8859_1);
    }

    public final int encodeIntoByteArray(byte[] r10, byte[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "destination");
        return encodeIntoByteArrayImpl$kotlin_stdlib(r10, r11, r12, r13, r14);
    }

    public final int encodeIntoByteArrayImpl$kotlin_stdlib(byte[] r10, byte[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "destination");
        checkSourceBounds$kotlin_stdlib(r10.length, r13, r14);
        checkDestinationBounds(r11.length, r12, encodeSize(r14 - r13));
        if (this.isUrlSafe == false) goto L5;
        byte[] r15 = Base64Kt.access$getBase64UrlEncodeMap$p();
    L7:
        if (this.isMimeScheme == false) goto L9;
        int r16 = 19;
    L10:
        int r17 = r12;
    L11:
        boolean r18 = false;
        if ((r13 + 2) >= r14) goto L19;
        int r19 = Math.min((r14 - r13) / 3, r16);
        int r20 = 0;
    L14:
        if (r20 >= r19) goto L16;
        int r21 = r13 + 1;
        int r22 = r21 + 1;
        int r110 = (((r10[r13] & 255) << 16) | ((r10[r21] & 255) << 8)) | (r10[r22] & 255);
        int r23 = r17 + 1;
        r11[r17] = r15[r110 >>> 18];
        int r24 = r23 + 1;
        r11[r23] = r15[(r110 >>> 12) & 63];
        int r25 = r24 + 1;
        r11[r24] = r15[(r110 >>> 6) & 63];
        r17 = r25 + 1;
        r11[r25] = r15[r110 & 63];
        r20 = r20 + 1;
        r13 = r22 + 1;
        goto L14
    L16:
        if (r19 != r16) goto L11;
        if (r13 == r14) goto L11;
        int r26 = r17 + 1;
        byte[] r27 = mimeLineSeparatorSymbols;
        r11[r17] = r27[0];
        r17 = r26 + 1;
        r11[r26] = r27[1];
        goto L11
    L19:
        int r28 = r14 - r13;
        if (r28 != 1) goto L22;
        int r29 = r13 + 1;
        int r111 = (r10[r13] & 255) << 4;
        int r112 = r17 + 1;
        r11[r17] = r15[r111 >>> 6];
        int r30 = r112 + 1;
        r11[r112] = r15[r111 & 63];
        int r113 = r30 + 1;
        r11[r30] = padSymbol;
        r17 = r113 + 1;
        r11[r113] = padSymbol;
        r13 = r29;
    L26:
        if (r13 != r14) goto L28;
        r18 = true;
    L28:
        if (r18 == false) goto L32;
        return r17 - r12;
    L32:
        throw new IllegalStateException("Check failed.".toString());
    L22:
        if (r28 != 2) goto L26;
        int r31 = r13 + 1;
        int r114 = r10[r13] & 255;
        int r32 = r31 + 1;
        int r33 = ((r10[r31] & 255) << 2) | (r114 << 10);
        int r115 = r17 + 1;
        r11[r17] = r15[r33 >>> 12];
        int r116 = r115 + 1;
        r11[r115] = r15[(r33 >>> 6) & 63];
        int r117 = r116 + 1;
        r11[r116] = r15[r33 & 63];
        r17 = r117 + 1;
        r11[r117] = padSymbol;
        r13 = r32;
        goto L26
    L9:
        r16 = Integer.MAX_VALUE;
        goto L10
    L5:
        r15 = Base64Kt.access$getBase64EncodeMap$p();
        goto L7
    }

    public final <A extends Appendable> A encodeToAppendable(byte[] r10, A r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "destination");
        r11.append(new String(encodeToByteArrayImpl$kotlin_stdlib(r10, r12, r13), Charsets.ISO_8859_1));
        return r11;
    }

    public final byte[] encodeToByteArray(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        return encodeToByteArrayImpl$kotlin_stdlib(r10, r11, r12);
    }

    public final byte[] encodeToByteArrayImpl$kotlin_stdlib(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        checkSourceBounds$kotlin_stdlib(r10.length, r11, r12);
        byte[] r13 = new byte[encodeSize(r12 - r11)];
        encodeIntoByteArrayImpl$kotlin_stdlib(r10, r13, 0, r11, r12);
        return r13;
    }

    public final boolean isMimeScheme$kotlin_stdlib() {
        return this.isMimeScheme;
    }

    public final boolean isUrlSafe$kotlin_stdlib() {
        return this.isUrlSafe;
    }
}
