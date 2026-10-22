package n4a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final byte[] a = null;
    public static final byte[] b = null;

    static {
        a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        b = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    public f() {
    }

    public static String a(byte[] r9, int r10) throws IOException {
        if (r9 == null) goto L27;
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
        b(r9, r6 + 0, 3, r3, r7);
        r6 = r6 + 3;
        r7 = r7 + 4;
        goto L11
    L13:
        if (r6 >= r10) goto L16;
        b(r9, r6 + 0, r10 - r6, r3, r7);
        r7 = r7 + 4;
    L16:
        if (r7 > (r2 - 1)) goto L28;
        byte[] r11 = new byte[r7];
        System.arraycopy(r3, 0, r11, 0, r7);
        r3 = r11;
    L28:
        return new String(r3, "US-ASCII");
    L21:
        return new String(r3);
    L23:
        throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[]{0, Integer.valueOf(r10), Integer.valueOf(r9.length)}));
    L25:
        throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(r10)));
    L27:
        throw new NullPointerException("Cannot serialize a null array.");
    }

    public static void b(byte[] r5, int r6, int r7, byte[] r8, int r9) {
        byte[] r0 = a;
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
        return;
    L18:
        r8[r9] = r0[r10 >>> 18];
        r8[r9 + 1] = r0[(r10 >>> 12) & 63];
        r8[r9 + 2] = r0[(r10 >>> 6) & 63];
        r8[r9 + 3] = r0[r10 & 63];
        return;
    L20:
        r8[r9] = r0[r10 >>> 18];
        r8[r9 + 1] = r0[(r10 >>> 12) & 63];
        r8[r9 + 2] = r0[(r10 >>> 6) & 63];
        r8[r9 + 3] = 61;
        return;
    L22:
        r8[r9] = r0[r10 >>> 18];
        r8[r9 + 1] = r0[(r10 >>> 12) & 63];
        r8[r9 + 2] = 61;
        r8[r9 + 3] = 61;
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] c(String r18) throws IOException {
        if (r18 == null) goto L94;
        byte[] r0 = r18.getBytes("US-ASCII");     // Catch: UnsupportedEncodingException -> L6
    L7:
        int r1 = r0.length;
        int r2 = r1 + 0;
        int r5 = 3;
        int r7 = 1;
        if (r2 > r0.length) goto L92;
        if (r1 != 0) goto L13;
        byte[] r3 = new byte[0];
    L12:
        byte[] r4 = r3;
        if (r4.length >= 4) goto L46;
    L88:
        return r4;
    L46:
        if (35615 != ((r4[0] & 255) | ((r4[1] << 8) & 65280))) goto L88;
        byte[] r6 = new byte[2048];
        ByteArrayOutputStream r8 = null;
        ByteArrayInputStream r9 = null;
        ByteArrayInputStream r10 = null;
        r8 = null;
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();     // Catch: Throwable -> L73 IOException -> L75
    L126:
        ByteArrayInputStream r12 = new ByteArrayInputStream(r4);     // Catch: Throwable -> L67 IOException -> L70
        GZIPInputStream r13 = new GZIPInputStream(r12);     // Catch: Throwable -> L61 IOException -> L64
    L124:
        int r14 = r13.read(r6);     // Catch: Throwable -> L57 IOException -> L59
        if (r14 < 0) goto L54;
        r11.write(r6, 0, r14);     // Catch: Throwable -> L57 IOException -> L59
        goto L124
    L54:
        byte[] r15 = r11.toByteArray();     // Catch: Throwable -> L57 IOException -> L59
        r11.close();     // Catch: Exception -> L95
    L56:
        r4 = r15;
    L108:
        r13.close();     // Catch: Exception -> L96
    L110:
        r12.close();     // Catch: Exception -> L101
        goto L88
    L59:
        e = e;
    L66:
        r9 = r12;
    L72:
        ByteArrayInputStream r16 = r9;
        r8 = r11;
    L116:
        e.printStackTrace();     // Catch: Throwable -> L83
        r8.close();     // Catch: Exception -> L100
    L79:
        r12 = r16;
    L83:
        th = th;
    L118:
        r8.close();     // Catch: Exception -> L97
    L114:
        r13.close();     // Catch: Exception -> L98
    L112:
        r16.close();     // Catch: Exception -> L99
        throw th;
    L137:
        throw th;
    L57:
        th = th;
    L63:
        r10 = r12;
    L69:
        r16 = r10;
        r8 = r11;
    L64:
        e = e;
        r13 = null;
    L61:
        th = th;
        r13 = null;
        goto L63
    L70:
        e = e;
        r13 = null;
    L67:
        th = th;
        r13 = null;
    L75:
        e = e;
        r16 = null;
        r13 = null;
    L73:
        th = th;
        r16 = null;
        r13 = null;
        goto L118
    L13:
        if (r1 < 4) goto L90;
        byte[] r17 = b;
        int r19 = (r1 * 3) / 4;
        byte[] r20 = new byte[r19];
        byte[] r110 = new byte[4];
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
    L15:
        if (r111 >= r2) goto L42;
        byte r114 = r0[r111];
        byte r115 = r17[r114 & 255 ? 1 : 0];
        if (r115 < (-5)) goto L41;
        if (r115 < (-1)) goto L39;
        int r21 = r112 + 1;
        r110[r112] = r114;
        if (r21 <= r5) goto L38;
        if (r113 < 0) goto L37;
        int r22 = r113 + 2;
        if (r22 >= r19) goto L37;
        byte r116 = r110[2];
        if (r116 != 61) goto L28;
        r20[r113] = (byte) ((((r17[r110[0]] & 255) << 18) | ((r17[r110[r7]] & 255) << 12)) >>> 16);
    L32:
        r113 = r113 + r7;
        if (r0[r111] == 61) goto L42;
        r112 = 0;
        goto L39
    L28:
        byte r117 = r110[r5];
        if (r117 != 61) goto L31;
        int r23 = (((r17[r110[0]] & 255) << 18) | ((r17[r110[r7]] & 255) << 12)) | ((r17[r116] & 255) << 6);
        r20[r113] = (byte) (r23 >>> 16);
        r20[r113 + 1] = (byte) (r23 >>> 8);
        r7 = 2;
        goto L32
    L31:
        int r24 = ((((r17[r110[0]] & 255) << 18) | ((r17[r110[r7]] & 255) << 12)) | ((r17[r116] & 255) << 6)) | (r17[r117] & 255);
        r20[r113] = (byte) (r24 >> 16);
        r20[r113 + 1] = (byte) (r24 >> 8);
        r20[r22] = (byte) r24;
        r7 = 3;
    L37:
        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(r19), Integer.valueOf(r113)}));
    L38:
        r112 = r21;
    L39:
        r111 = r111 + 1;
        r5 = 3;
        r7 = 1;
        goto L15
    L41:
        throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", new Object[]{Integer.valueOf(r0[r111] & 255), Integer.valueOf(r111)}));
    L42:
        r3 = new byte[r113];
        System.arraycopy(r20, 0, r3, 0, r113);
        goto L12
    L90:
        throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(r1)));
    L92:
        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[]{Integer.valueOf(r0.length), 0, Integer.valueOf(r1)}));
    L6:
        r0 = r18.getBytes();
        goto L7
    L94:
        throw new NullPointerException("Input string was null.");
    }
}
