package com.loc;

import androidx.core.view.MotionEventCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f5474a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f5475b = null;
    private static final byte[] c = null;
    private static final byte[] d = null;
    private static final byte[] e = null;
    private static final byte[] f = null;
    private static final byte[] g = null;

    static {
        f5475b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        c = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        d = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        e = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        g = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    private e() {
    }

    public static String a(byte[] r1) {
        String r2 = a(r1, r1.length);     // Catch: IOException -> L4
    L9:
        if (f5474a == true) goto L14;
        if (r2 != null) goto L14;
        throw new AssertionError();
    L14:
        return r2;
    L4:
        e = move-exception;
        if (f5474a == false) goto L16;
        r2 = null;
        goto L9
    L16:
        throw new AssertionError(e.getMessage());
    }

    private static String a(byte[] r9, int r10) {
        Objects.requireNonNull(r9, "Cannot serialize a null array.");
        if (r10 < 0) goto L25;
        if ((r10 + 0) > r9.length) goto L23;
        int r1 = 4;
        int r0 = (r10 / 3) * 4;
        if ((r10 % 3) > 0) goto L10;
        r1 = 0;
    L10:
        int r2 = r0 + r1;
        byte[] r3 = new byte[r2];
        int r5 = r10 - 2;
        int r6 = 0;
        int r7 = 0;
    L11:
        if (r6 >= r5) goto L13;
        a(r9, r6 + 0, 3, r3, r7);
        r6 = r6 + 3;
        r7 = r7 + 4;
        goto L11
    L13:
        if (r6 >= r10) goto L16;
        a(r9, r6 + 0, r10 - r6, r3, r7);
        r7 = r7 + 4;
    L16:
        if (r7 > (r2 - 1)) goto L26;
        byte[] r11 = new byte[r7];
        System.arraycopy(r3, 0, r11, 0, r7);
        r3 = r11;
    L26:
        return new String(r3, "US-ASCII");
    L21:
        return new String(r3);
    L23:
        throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[]{0, Integer.valueOf(r10), Integer.valueOf(r9.length)}));
    L25:
        throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(r10)));
    }

    public static byte[] a(String r0) {
        return b(r0);
    }

    private static byte[] a(byte[] r5, int r6, int r7, byte[] r8, int r9) {
        byte[] r0 = f5475b;
        int r1 = 0;
        if (r7 <= 0) goto L5;
        int r2 = (r5[r6] << 24) >>> 8;
    L7:
        if (r7 <= 1) goto L9;
        int r4 = (r5[r6 + 1] << 24) >>> 16;
    L10:
        int r3 = r2 | r4;
        if (r7 <= 2) goto L13;
        r1 = (r5[r6 + 2] << 24) >>> 24;
    L13:
        int r10 = r3 | r1;
        if (r7 == 1) goto L22;
        if (r7 == 2) goto L20;
        if (r7 == 3) goto L18;
        return r8;
    L18:
        r8[r9] = r0[r10 >>> 18];
        r8[r9 + 1] = r0[(r10 >>> 12) & 63];
        r8[r9 + 2] = r0[(r10 >>> 6) & 63];
        r8[r9 + 3] = r0[r10 & 63];
        return r8;
    L20:
        r8[r9] = r0[r10 >>> 18];
        r8[r9 + 1] = r0[(r10 >>> 12) & 63];
        r8[r9 + 2] = r0[(r10 >>> 6) & 63];
        r8[r9 + 3] = Base64.padSymbol;
        return r8;
    L22:
        r8[r9] = r0[r10 >>> 18];
        r8[r9 + 1] = r0[(r10 >>> 12) & 63];
        r8[r9 + 2] = Base64.padSymbol;
        r8[r9 + 3] = Base64.padSymbol;
        return r8;
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L7
    }

    private static byte[] b(String r6) {
        Objects.requireNonNull(r6, "Input string was null.");
        byte[] r7 = r6.getBytes("US-ASCII");     // Catch: UnsupportedEncodingException -> L5
    L6:
        byte[] r8 = b(r7, r7.length);
        if (r8.length >= 4) goto L9;
    L48:
        return r8;
    L9:
        if (35615 != ((r8[0] & 255) | ((r8[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) goto L48;
        byte[] r1 = new byte[2048];
        ByteArrayOutputStream r2 = null;
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: Throwable -> L36 IOException -> L38
        ByteArrayInputStream r4 = new ByteArrayInputStream(r8);     // Catch: Throwable -> L30 IOException -> L33
    L75:
        GZIPInputStream r5 = new GZIPInputStream(r4);     // Catch: Throwable -> L26 IOException -> L28
    L73:
        int r9 = r5.read(r1);     // Catch: Throwable -> L22 IOException -> L24
        if (r9 < 0) goto L17;
        r3.write(r1, 0, r9);     // Catch: Throwable -> L22 IOException -> L24
        goto L73
    L17:
        r8 = r3.toByteArray();     // Catch: Throwable -> L22 IOException -> L24
        r3.close();     // Catch: Exception -> L49
        goto L57
    L24:
        e = e;
    L35:
        r2 = r3;
    L64:
        e.printStackTrace();     // Catch: Throwable -> L43
        r2.close();     // Catch: Exception -> L49
    L43:
        th = th;
    L60:
        r2.close();     // Catch: Exception -> L51
    L68:
        r5.close();     // Catch: Exception -> L52
    L66:
        r4.close();     // Catch: Exception -> L53
        throw th;
    L80:
        throw th;
    L22:
        th = th;
    L32:
        r2 = r3;
        goto L60
    L28:
        e = e;
        r5 = null;
    L26:
        th = th;
        r5 = null;
    L33:
        e = e;
        r4 = null;
        r5 = null;
    L30:
        th = th;
        r4 = null;
        r5 = null;
        goto L32
    L38:
        e = e;
        r4 = null;
        r5 = null;
    L36:
        th = th;
        r4 = null;
        r5 = null;
    L57:
        r5.close();     // Catch: Exception -> L50
    L62:
        r4.close();     // Catch: Exception -> L54
    L5:
        r7 = r6.getBytes();
        goto L6
    }

    private static byte[] b(byte[] r17, int r18) {
        Objects.requireNonNull(r17, "Cannot decode null source array.");
        int r2 = r18 + 0;
        int r6 = 1;
        if (r2 > r17.length) goto L42;
        if (r18 != 0) goto L8;
        return new byte[0];
    L8:
        if (r18 < 4) goto L40;
        byte[] r8 = c;
        int r1 = (r18 * 3) / 4;
        byte[] r9 = new byte[r1];
        byte[] r3 = new byte[4];
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L10:
        if (r10 >= r2) goto L37;
        byte r13 = r8[r17[r10] & 255];
        if (r13 < (-5)) goto L36;
        if (r13 < (-1)) goto L34;
        int r14 = r11 + 1;
        r3[r11] = r17[r10];
        if (r14 <= 3) goto L33;
        if (r12 < 0) goto L32;
        int r15 = r12 + 2;
        if (r15 >= r1) goto L32;
        byte[] r16 = c;
        if (r3[2] != 61) goto L24;
        r9[r12] = (byte) ((((r16[r3[0]] & 255) << 18) | ((r16[r3[r6]] & 255) << 12)) >>> 16);
    L27:
        r12 = r12 + r6;
        if (r17[r10] == 61) goto L37;
        r11 = 0;
        goto L34
    L24:
        if (r3[3] != 61) goto L26;
        int r19 = (((r16[r3[0]] & 255) << 18) | ((r16[r3[r6]] & 255) << 12)) | ((r16[r3[2]] & 255) << 6);
        r9[r12] = (byte) (r19 >>> 16);
        r9[r12 + 1] = (byte) (r19 >>> 8);
        r6 = 2;
        goto L27
    L26:
        int r7 = ((((r16[r3[r6]] & 255) << 12) | ((r16[r3[0]] & 255) << 18)) | ((r16[r3[2]] & 255) << 6)) | (r16[r3[3]] & 255);
        r9[r12] = (byte) (r7 >> 16);
        r9[r12 + 1] = (byte) (r7 >> 8);
        r9[r15] = (byte) r7;
        r6 = 3;
    L32:
        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(r1), Integer.valueOf(r12)}));
    L33:
        r11 = r14;
    L34:
        r10 = r10 + 1;
        r6 = 1;
        goto L10
    L36:
        throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", new Object[]{Integer.valueOf(r17[r10] & 255), Integer.valueOf(r10)}));
    L37:
        byte[] r0 = new byte[r12];
        System.arraycopy(r9, 0, r0, 0, r12);
        return r0;
    L40:
        throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(r18)));
    L42:
        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[]{Integer.valueOf(r17.length), 0, Integer.valueOf(r18)}));
    }
}
