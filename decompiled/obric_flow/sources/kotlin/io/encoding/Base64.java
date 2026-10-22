package kotlin.io.encoding;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
@ExperimentalEncodingApi
@SinceKotlin(version = "1.8")
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 22\u00020\u0001:\u00012B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ%\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0013J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J%\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u001bJ\"\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J\"\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J0\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J4\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J4\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J \u0010 \u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\"\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J4\u0010\"\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J5\u0010#\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b$J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J=\u0010&\u001a\u0002H'\"\f\b\u0000\u0010'*\u00060(j\u0002`)2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u0002H'2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0002\u0010*J\"\u0010+\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J%\u0010,\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b-J(\u0010.\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0002J \u00101\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u00063"}, d2 = {"Lkotlin/io/encoding/Base64;", "", "isUrlSafe", "", "isMimeScheme", "(ZZ)V", "isMimeScheme$kotlin_stdlib", "()Z", "isUrlSafe$kotlin_stdlib", "bytesToStringImpl", "", "source", "", "bytesToStringImpl$kotlin_stdlib", "charsToBytesImpl", "", "startIndex", "", "endIndex", "charsToBytesImpl$kotlin_stdlib", "checkDestinationBounds", "", "destinationSize", "destinationOffset", "capacityNeeded", "checkSourceBounds", "sourceSize", "checkSourceBounds$kotlin_stdlib", "decode", "decodeImpl", "destination", "decodeIntoByteArray", "decodeSize", "encode", "encodeIntoByteArray", "encodeIntoByteArrayImpl", "encodeIntoByteArrayImpl$kotlin_stdlib", "encodeSize", "encodeToAppendable", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "([BLjava/lang/Appendable;II)Ljava/lang/Appendable;", "encodeToByteArray", "encodeToByteArrayImpl", "encodeToByteArrayImpl$kotlin_stdlib", "handlePaddingSymbol", "padIndex", "byteStart", "skipIllegalSymbolsIfMime", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/io/encoding/Base64$Default;", "Lkotlin/io/encoding/Base64;", "()V", "Mime", "getMime", "()Lkotlin/io/encoding/Base64;", "UrlSafe", "getUrlSafe", "bitsPerByte", "", "bitsPerSymbol", "bytesPerGroup", "mimeGroupsPerLine", "mimeLineLength", "mimeLineSeparatorSymbols", "", "getMimeLineSeparatorSymbols$kotlin_stdlib", "()[B", "padSymbol", "", "symbolsPerGroup", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default extends Base64 {
        public /* synthetic */ Default(DefaultConstructorMarker r5) {
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

        private Default() {
            boolean r5 = false;
            super(r5, r5, null);
        }
    }

    static {
        Default = new Default(null);
        mimeLineSeparatorSymbols = new byte[]{13, 10};
        UrlSafe = new Base64(true, false);
        Mime = new Base64(false, true);
    }

    public /* synthetic */ Base64(boolean r5, boolean r10, DefaultConstructorMarker r11) {
        this(r5, r10);
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

    private final void checkDestinationBounds(int r5, int r10, int r11) {
        if (r10 < 0) goto L12;
        if (r10 > r5) goto L12;
        int r12 = r10 + r11;
        if (r12 < 0) goto L9;
        if (r12 > r5) goto L9;
        return;
    L9:
        StringBuilder r13 = j0.v("The destination array does not have enough capacity, destination offset: ", r10, r5, ", destination size: ", ", capacity needed: ");
        r13.append(r11);
        throw new IndexOutOfBoundsException(r13.toString());
    L12:
        throw new IndexOutOfBoundsException(j0.f(r10, r5, "destination offset: ", ", destination size: "));
    }

    public static /* synthetic */ byte[] decode$default(Base64 r5, byte[] r10, int r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L12;
        if ((r13 & 2) == 0) goto L7;
        r11 = 0;
    L7:
        if ((r13 & 4) == 0) goto L10;
        r12 = r10.length;
    L10:
        return r5.decode(r10, r11, r12);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    private final int decodeImpl(byte[] r19, byte[] r20, int r21, int r22, int r23) {
        if (this.isUrlSafe == false) goto L5;
        int[] r5 = Base64Kt.access$getBase64UrlDecodeMap$p();
    L6:
        int r10 = -8;
        int r11 = r21;
        int r12 = -8;
        int r13 = 0;
        int r14 = r22;
    L8:
        if (r14 >= r23) goto L29;
        if (r12 == r10) goto L11;
    L16:
        int r15 = r19[r14] & UByte.MAX_VALUE;
        int r16 = r5[r15];
        if (r16 >= 0) goto L25;
        if (r16 == (-2)) goto L19;
        if (this.isMimeScheme == false) goto L24;
        r14 = r14 + 1;
    L15:
        r10 = -8;
        goto L8
    L24:
        throw new IllegalArgumentException("Invalid symbol '" + ((char) r15) + "'(" + Integer.toString(r15, CharsKt.checkRadix(8)) + ") at index " + r14);
    L19:
        r14 = handlePaddingSymbol(r19, r14, r23, r12);
        goto L29
    L25:
        r14 = r14 + 1;
        r13 = (r13 << 6) | r16;
        int r17 = r12 + 6;
        if (r17 < 0) goto L28;
        r20[r11] = (byte) (r13 >>> r17);
        r13 = r13 & ((1 << r17) - 1);
        r12 = r12 - 2;
        r11 = r11 + 1;
        goto L15
    L28:
        r12 = r17;
        goto L15
    L11:
        if ((r14 + 3) >= r23) goto L16;
        int r18 = r5[r19[r14] & UByte.MAX_VALUE];
        int r110 = r5[r19[r14 + 1] & UByte.MAX_VALUE];
        int r111 = r14 + 4;
        int r24 = r5[r19[r14 + 2] & UByte.MAX_VALUE] << 6;
        int r25 = (r24 | ((r110 << 12) | (r18 << 18))) | r5[r19[r14 + 3] & UByte.MAX_VALUE];
        if (r25 < 0) goto L16;
        r20[r11] = (byte) (r25 >> 16);
        int r26 = r11 + 2;
        r20[r11 + 1] = (byte) (r25 >> 8);
        r11 = r11 + 3;
        r20[r26] = (byte) r25;
        r14 = r111;
    L29:
        if (r12 == (-2)) goto L37;
        int r27 = skipIllegalSymbolsIfMime(r19, r14, r23);
        if (r27 >= r23) goto L33;
        int r28 = r19[r27] & UByte.MAX_VALUE;
        throw new IllegalArgumentException("Symbol '" + ((char) r28) + "'(" + Integer.toString(r28, CharsKt.checkRadix(8)) + ") at index " + (r27 - 1) + " is prohibited after the pad character");
    L33:
        return r11 - r21;
    L37:
        throw new IllegalArgumentException("The last unit of input does not have enough bits");
    L5:
        r5 = Base64Kt.access$getBase64DecodeMap$p();
        goto L6
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 r10, byte[] r11, byte[] r12, int r13, int r14, int r15, int r16, Object r17) {
        if (r17 != null) goto L17;
        if ((r16 & 4) == 0) goto L6;
        int r5 = 0;
    L8:
        if ((r16 & 8) == 0) goto L10;
        int r18 = 0;
    L12:
        if ((r16 & 16) == 0) goto L15;
        r15 = r11.length;
    L15:
        return r10.decodeIntoByteArray(r11, r12, r5, r18, r15);
    L10:
        r18 = r14;
        goto L12
    L6:
        r5 = r13;
        goto L8
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    private final int decodeSize(byte[] r5, int r10, int r11) {
        int r12 = r11 - r10;
        if (r12 != 0) goto L7;
        return 0;
    L7:
        if (r12 == 1) goto L27;
        if (this.isMimeScheme == false) goto L19;
    L10:
        if (r10 >= r11) goto L25;
        int r13 = Base64Kt.access$getBase64DecodeMap$p()[r5[r10] & UByte.MAX_VALUE];
        if (r13 >= 0) goto L17;
        if (r13 == (-2)) goto L15;
        r12 = r12 - 1;
        goto L17
    L15:
        r12 = r12 - (r11 - r10);
    L17:
        r10 = r10 + 1;
    L25:
        return (int) ((((long) r12) * ((long) 6)) / ((long) 8));
    L19:
        if (r5[r11 - 1] != 61) goto L25;
        int r14 = r12 - 1;
        if (r5[r11 - 2] != 61) goto L23;
        r12 = r12 - 2;
        goto L25
    L23:
        r12 = r14;
        goto L25
    L27:
        throw new IllegalArgumentException(j0.f(r10, r11, "Input should have at list 2 symbols for Base64 decoding, startIndex: ", ", endIndex: "));
    }

    public static /* synthetic */ String encode$default(Base64 r5, byte[] r10, int r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L12;
        if ((r13 & 2) == 0) goto L7;
        r11 = 0;
    L7:
        if ((r13 & 4) == 0) goto L10;
        r12 = r10.length;
    L10:
        return r5.encode(r10, r11, r12);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
    }

    public static /* synthetic */ int encodeIntoByteArray$default(Base64 r10, byte[] r11, byte[] r12, int r13, int r14, int r15, int r16, Object r17) {
        if (r17 != null) goto L17;
        if ((r16 & 4) == 0) goto L6;
        int r5 = 0;
    L8:
        if ((r16 & 8) == 0) goto L10;
        int r18 = 0;
    L12:
        if ((r16 & 16) == 0) goto L15;
        r15 = r11.length;
    L15:
        return r10.encodeIntoByteArray(r11, r12, r5, r18, r15);
    L10:
        r18 = r14;
        goto L12
    L6:
        r5 = r13;
        goto L8
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
    }

    private final int encodeSize(int r5) {
        int r10 = (r5 + 2) / 3;
        if (this.isMimeScheme == false) goto L5;
        int r11 = (r10 - 1) / 19;
    L6:
        int r12 = (r11 * 2) + (r10 * 4);
        if (r12 < 0) goto L10;
        return r12;
    L10:
        throw new IllegalArgumentException("Input is too big");
    L5:
        r11 = 0;
        goto L6
    }

    public static /* synthetic */ Appendable encodeToAppendable$default(Base64 r5, byte[] r10, Appendable r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 4) == 0) goto L7;
        r12 = 0;
    L7:
        if ((r14 & 8) == 0) goto L10;
        r13 = r10.length;
    L10:
        return r5.encodeToAppendable(r10, r11, r12, r13);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(Base64 r5, byte[] r10, int r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L12;
        if ((r13 & 2) == 0) goto L7;
        r11 = 0;
    L7:
        if ((r13 & 4) == 0) goto L10;
        r12 = r10.length;
    L10:
        return r5.encodeToByteArray(r10, r11, r12);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
    }

    private final int handlePaddingSymbol(byte[] r5, int r10, int r11, int r12) {
        if (r12 == (-8)) goto L22;
        if (r12 == (-6)) goto L20;
        if (r12 != (-4)) goto L9;
        int r13 = skipIllegalSymbolsIfMime(r5, r10 + 1, r11);
        if (r13 == r11) goto L19;
        if (r5[r13] != 61) goto L19;
        return r13 + 1;
    L19:
        throw new IllegalArgumentException(j0.g(r13, "Missing one pad character at index "));
    L9:
        if (r12 == (-2)) goto L20;
        throw new IllegalStateException("Unreachable");
    L20:
        return r10 + 1;
    L22:
        throw new IllegalArgumentException(j0.g(r10, "Redundant pad character at index "));
    }

    private final int skipIllegalSymbolsIfMime(byte[] r5, int r10, int r11) {
        if (this.isMimeScheme == true) goto L5;
        return r10;
    L5:
        if (r10 >= r11) goto L10;
        int r12 = r5[r10] & UByte.MAX_VALUE;
        if (Base64Kt.access$getBase64DecodeMap$p()[r12] != (-1)) goto L8;
        r10 = r10 + 1;
        goto L5
    L8:
        return r10;
    L10:
        return r10;
    }

    public final String bytesToStringImpl$kotlin_stdlib(byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        StringBuilder r10 = new StringBuilder(r5.length);
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.append((char) r5[r12]);
        r12 = r12 + 1;
        goto L3
    L6:
        return r10.toString();
    }

    public final byte[] charsToBytesImpl$kotlin_stdlib(CharSequence r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "source");
        checkSourceBounds$kotlin_stdlib(r5.length(), r10, r11);
        byte[] r12 = new byte[r11 - r10];
        int r13 = 0;
    L3:
        if (r10 >= r11) goto L9;
        char r14 = r5.charAt(r10);
        if (r14 > 255) goto L7;
        r12[r13] = (byte) r14;
        r13 = r13 + 1;
    L8:
        r10 = r10 + 1;
        goto L3
    L7:
        r12[r13] = 63;
        r13 = r13 + 1;
        goto L8
    L9:
        return r12;
    }

    public final void checkSourceBounds$kotlin_stdlib(int r5, int r10, int r11) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r10, r11, r5);
    }

    public final byte[] decode(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        checkSourceBounds$kotlin_stdlib(r10.length, r11, r12);
        int r5 = decodeSize(r10, r11, r12);
        byte[] r13 = new byte[r5];
        if (decodeImpl(r10, r13, 0, r11, r12) != r5) goto L6;
        return r13;
    L6:
        throw new IllegalStateException("Check failed.");
    }

    public final int decodeIntoByteArray(byte[] r5, byte[] r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r10, "destination");
        checkSourceBounds$kotlin_stdlib(r5.length, r12, r13);
        checkDestinationBounds(r10.length, r11, decodeSize(r5, r12, r13));
        return decodeImpl(r5, r10, r11, r12, r13);
    }

    public final String encode(byte[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "source");
        return new String(encodeToByteArrayImpl$kotlin_stdlib(r5, r10, r11), Charsets.ISO_8859_1);
    }

    public final int encodeIntoByteArray(byte[] r5, byte[] r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r10, "destination");
        return encodeIntoByteArrayImpl$kotlin_stdlib(r5, r10, r11, r12, r13);
    }

    public final int encodeIntoByteArrayImpl$kotlin_stdlib(byte[] r11, byte[] r12, int r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r12, "destination");
        checkSourceBounds$kotlin_stdlib(r11.length, r14, r15);
        checkDestinationBounds(r12.length, r13, encodeSize(r15 - r14));
        if (this.isUrlSafe == false) goto L5;
        byte[] r5 = Base64Kt.access$getBase64UrlEncodeMap$p();
    L7:
        if (this.isMimeScheme == false) goto L9;
        int r10 = 19;
    L10:
        int r16 = r13;
    L12:
        if ((r14 + 2) >= r15) goto L19;
        int r17 = Math.min((r15 - r14) / 3, r10);
        int r18 = 0;
    L14:
        if (r18 >= r17) goto L16;
        int r19 = r11[r14] & UByte.MAX_VALUE;
        int r20 = r14 + 2;
        int r21 = r11[r14 + 1] & UByte.MAX_VALUE;
        r14 = r14 + 3;
        int r22 = ((r21 << 8) | (r19 << 16)) | (r11[r20] & UByte.MAX_VALUE);
        r12[r16] = r5[r22 >>> 18];
        r12[r16 + 1] = r5[(r22 >>> 12) & 63];
        int r23 = r16 + 3;
        r12[r16 + 2] = r5[(r22 >>> 6) & 63];
        r16 = r16 + 4;
        r12[r23] = r5[r22 & 63];
        r18 = r18 + 1;
        goto L14
    L16:
        if (r17 != r10) goto L12;
        if (r14 == r15) goto L12;
        int r24 = r16 + 1;
        byte[] r25 = mimeLineSeparatorSymbols;
        r12[r16] = r25[0];
        r16 = r16 + 2;
        r12[r24] = r25[1];
        goto L12
    L19:
        int r110 = r15 - r14;
        if (r110 != 1) goto L22;
        int r111 = (r11[r14] & UByte.MAX_VALUE) << 4;
        r12[r16] = r5[r111 >>> 6];
        r12[r16 + 1] = r5[r111 & 63];
        int r112 = r16 + 3;
        r12[r16 + 2] = padSymbol;
        r16 = r16 + 4;
        r12[r112] = padSymbol;
        r14 = r14 + 1;
    L26:
        if (r14 != r15) goto L30;
        return r16 - r13;
    L30:
        throw new IllegalStateException("Check failed.");
    L22:
        if (r110 != 2) goto L26;
        int r113 = r14 + 1;
        int r26 = r11[r14] & UByte.MAX_VALUE;
        r14 = r14 + 2;
        int r114 = ((r11[r113] & UByte.MAX_VALUE) << 2) | (r26 << 10);
        r12[r16] = r5[r114 >>> 12];
        r12[r16 + 1] = r5[(r114 >>> 6) & 63];
        int r115 = r16 + 3;
        r12[r16 + 2] = r5[r114 & 63];
        r16 = r16 + 4;
        r12[r115] = padSymbol;
        goto L26
    L9:
        r10 = Integer.MAX_VALUE;
        goto L10
    L5:
        r5 = Base64Kt.access$getBase64EncodeMap$p();
        goto L7
    }

    public final <A extends Appendable> A encodeToAppendable(byte[] r5, A r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r10, "destination");
        r10.append(new String(encodeToByteArrayImpl$kotlin_stdlib(r5, r11, r12), Charsets.ISO_8859_1));
        return r10;
    }

    public final byte[] encodeToByteArray(byte[] r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "source");
        return encodeToByteArrayImpl$kotlin_stdlib(r5, r10, r11);
    }

    public final byte[] encodeToByteArrayImpl$kotlin_stdlib(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        checkSourceBounds$kotlin_stdlib(r10.length, r11, r12);
        byte[] r5 = new byte[encodeSize(r12 - r11)];
        encodeIntoByteArrayImpl$kotlin_stdlib(r10, r5, 0, r11, r12);
        return r5;
    }

    public final boolean isMimeScheme$kotlin_stdlib() {
        return this.isMimeScheme;
    }

    public final boolean isUrlSafe$kotlin_stdlib() {
        return this.isUrlSafe;
    }

    private Base64(boolean r5, boolean r10) {
        this.isUrlSafe = r5;
        this.isMimeScheme = r10;
        if (r5 == false) goto L8;
        if (r10 == true) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Failed requirement.");
    }

    public static /* synthetic */ byte[] decode$default(Base64 r5, CharSequence r10, int r11, int r12, int r13, Object r14) {
        if (r14 != null) goto L12;
        if ((r13 & 2) == 0) goto L7;
        r11 = 0;
    L7:
        if ((r13 & 4) == 0) goto L10;
        r12 = r10.length();
    L10:
        return r5.decode(r10, r11, r12);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 r10, CharSequence r11, byte[] r12, int r13, int r14, int r15, int r16, Object r17) {
        if (r17 != null) goto L17;
        if ((r16 & 4) == 0) goto L6;
        int r5 = 0;
    L8:
        if ((r16 & 8) == 0) goto L10;
        int r18 = 0;
    L12:
        if ((r16 & 16) == 0) goto L15;
        r15 = r11.length();
    L15:
        return r10.decodeIntoByteArray(r11, r12, r5, r18, r15);
    L10:
        r18 = r14;
        goto L12
    L6:
        r5 = r13;
        goto L8
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    public final int decodeIntoByteArray(CharSequence r10, byte[] r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "destination");
        if ((r10 instanceof String) == false) goto L6;
        checkSourceBounds$kotlin_stdlib(((String) r10).length(), r13, r14);
        String r15 = ((String) r10).substring(r13, r14);
        Charset r16 = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type java.lang.String");
        byte[] r17 = r15.getBytes(r16);
    L8:
        return decodeIntoByteArray$default(this, r17, r11, r12, 0, 0, 24, null);
    L6:
        r17 = charsToBytesImpl$kotlin_stdlib(r10, r13, r14);
        goto L8
    }

    public final byte[] decode(CharSequence r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if ((r10 instanceof String) == false) goto L6;
        checkSourceBounds$kotlin_stdlib(((String) r10).length(), r11, r12);
        String r13 = ((String) r10).substring(r11, r12);
        Charset r14 = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.lang.String");
        byte[] r15 = r13.getBytes(r14);
    L8:
        return decode$default(this, r15, 0, 0, 6, null);
    L6:
        r15 = charsToBytesImpl$kotlin_stdlib(r10, r11, r12);
        goto L8
    }
}
