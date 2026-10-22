package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Charset f5112a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f5113b = null;

    /* JADX INFO: renamed from: com.google.zxing.qrcode.encoder.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5114a = null;

        static {
            int[] r0 = new int[Mode.values().length];
            f5114a = r0;
            r0[Mode.NUMERIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f5114a[Mode.ALPHANUMERIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f5114a[Mode.BYTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f5114a[Mode.KANJI.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        f5113b = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
        f5112a = StandardCharsets.ISO_8859_1;
    }

    static int a(int r2) {
        int[] r0 = f5113b;
        if (r2 < r0.length) goto L5;
        return -1;
    L5:
        return r0[r2];
    }

    private static int a(com.google.zxing.common.a r4, ErrorCorrectionLevel r5, com.google.zxing.qrcode.decoder.a r6, b r7) {
        int r0 = Integer.MAX_VALUE;
        int r1 = -1;
        int r2 = 0;
    L4:
        if (r2 >= 8) goto L9;
        e.a(r4, r5, r6, r2, r7);
        int r3 = a(r7);
        if (r3 >= r0) goto L8;
        r1 = r2;
        r0 = r3;
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        return r1;
    }

    private static int a(Mode r0, com.google.zxing.common.a r1, com.google.zxing.common.a r2, com.google.zxing.qrcode.decoder.a r3) {
        return (r1.a() + r0.getCharacterCountBits(r3)) + r2.a();
    }

    private static int a(b r2) {
        return ((d.a(r2) + d.b(r2)) + d.c(r2)) + d.d(r2);
    }

    static com.google.zxing.common.a a(com.google.zxing.common.a r17, int r18, int r19, int r20) {
        if (r17.b() != r19) goto L34;
        ArrayList r9 = new ArrayList(r20);
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L5:
        if (r11 >= r20) goto L7;
        int[] r15 = new int[1];
        int[] r5 = new int[1];
        a(r18, r19, r20, r11, r15, r5);
        int r0 = r15[0];
        byte[] r1 = new byte[r0];
        r17.a(r12 * 8, r1, 0, r0);
        byte[] r2 = a(r1, r5[0]);
        r9.add(new a(r1, r2));
        r13 = Math.max(r13, r0);
        r14 = Math.max(r14, r2.length);
        r12 = r12 + r15[0];
        r11 = r11 + 1;
        goto L5
    L7:
        if (r19 != r12) goto L32;
        com.google.zxing.common.a r3 = new com.google.zxing.common.a();
        int r4 = 0;
    L10:
        if (r4 >= r13) goto L18;
        Iterator r6 = r9.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        byte[] r7 = ((a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.memorydata.plugin")).a();
        if (r4 >= r7.length) goto L13;
        r3.a(r7[r4], 8);
        goto L13
    L17:
        r4 = r4 + 1;
    L18:
        if (r10 >= r14) goto L27;
        Iterator r8 = r9.iterator();
    L21:
        if (r8.hasNext() == false) goto L25;
        byte[] r16 = ((a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin")).b();
        if (r10 >= r16.length) goto L21;
        r3.a(r16[r10], 8);
        goto L21
    L25:
        r10 = r10 + 1;
        goto L18
    L27:
        if (r18 != r3.b()) goto L30;
        return r3;
    L30:
        throw new WriterException("Interleaving error: " + r18 + " and " + r3.b() + " differ.");
    L32:
        throw new WriterException("Data bytes does not match offset");
    L34:
        throw new WriterException("Number of bits and data bytes does not match");
    }

    private static Mode a(String r5, Charset r6) {
        if (com.google.zxing.common.d.f5070a != null) goto L5;
    L10:
        int r7 = 0;
        boolean r0 = false;
        boolean r1 = false;
    L12:
        if (r7 >= r5.length()) goto L24;
        char r2 = r5.charAt(r7);
        if (r2 < '0') goto L19;
        if (r2 > '9') goto L19;
        r1 = true;
    L21:
        r7 = r7 + 1;
    L19:
        if (a(r2) == (-1)) goto L23;
        r0 = true;
        goto L21
    L23:
        return Mode.BYTE;
    L24:
        if (r0 == true) goto L26;
        if (r1 == false) goto L31;
        return Mode.NUMERIC;
    L31:
        return Mode.BYTE;
    L26:
        return Mode.ALPHANUMERIC;
    L5:
        if (com.google.zxing.common.d.f5070a.equals(r6) == false) goto L10;
        if (a(r5) == false) goto L10;
        return Mode.KANJI;
    }

    private static com.google.zxing.qrcode.decoder.a a(int r3, ErrorCorrectionLevel r4) {
        int r0 = 1;
    L4:
        if (r0 > 40) goto L10;
        com.google.zxing.qrcode.decoder.a r1 = com.google.zxing.qrcode.decoder.a.a(r0);
        if (a(r3, r1, r4) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L10:
        throw new WriterException("Data too big");
    }

    private static com.google.zxing.qrcode.decoder.a a(ErrorCorrectionLevel r1, Mode r2, com.google.zxing.common.a r3, com.google.zxing.common.a r4) {
        return a(a(r2, r3, r4, a(a(r2, r3, r4, com.google.zxing.qrcode.decoder.a.a(1)), r1)), r1);
    }

    public static f a(String r6, ErrorCorrectionLevel r7, Map<EncodeHintType, ?> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        boolean r0 = true;
        if (r9 != null) goto L5;
    L9:
        boolean r2 = false;
    L10:
        if (r9 != null) goto L12;
    L16:
        boolean r3 = false;
    L17:
        Charset r4 = f5112a;
        if (r9 != null) goto L20;
    L22:
        r0 = false;
    L23:
        if (r0 == true) goto L66;
    L25:
        if (r3 == false) goto L30;
        Mode r1 = Mode.BYTE;
        if (r4.equals(f5112a) == false) goto L29;
        r4 = null;
    L29:
        MinimalEncoder.b r10 = MinimalEncoder.a(r6, null, r4, r2, r7);
        com.google.zxing.common.a r5 = new com.google.zxing.common.a();
        r10.a(r5);
        com.google.zxing.qrcode.decoder.a r11 = r10.b();
    L53:
        com.google.zxing.qrcode.decoder.a.b r12 = r11.a(r7);
        int r13 = r11.b() - r12.c();
        a(r13, r5);
        com.google.zxing.common.a r14 = a(r5, r11.b(), r13, r12.b());
        f r15 = new f();
        r15.a(r7);
        r15.a(r1);
        r15.a(r11);
        int r16 = r11.c();
        b r17 = new b(r16, r16);
        if (r9 != null) goto L56;
    L60:
        int r18 = -1;
    L61:
        if (r18 != (-1)) goto L63;
        r18 = a(r14, r7, r11, r17);
    L63:
        r15.a(r18);
        e.a(r14, r7, r11, r18, r17);
        r15.a(r17);
        return r15;
    L56:
        if (r9.containsKey(EncodeHintType.QR_MASK_PATTERN) == false) goto L60;
        r18 = Integer.parseInt(r9.get(EncodeHintType.QR_MASK_PATTERN).toString());
        if (f.b(r18) == false) goto L60;
    L30:
        Mode r19 = a(r6, r4);
        com.google.zxing.common.a r20 = new com.google.zxing.common.a();
        if (r19 != Mode.BYTE) goto L36;
        if (r0 == false) goto L36;
        CharacterSetECI r21 = CharacterSetECI.getCharacterSetECI(r4);
        if (r21 == null) goto L36;
        a(r21, r20);
    L36:
        if (r2 == false) goto L38;
        a(Mode.FNC1_FIRST_POSITION, r20);
    L38:
        a(r19, r20);
        com.google.zxing.common.a r22 = new com.google.zxing.common.a();
        a(r6, r19, r22, r4);
        if (r9 != null) goto L41;
    L47:
        com.google.zxing.qrcode.decoder.a r23 = a(r7, r19, r20, r22);
    L48:
        com.google.zxing.common.a r24 = new com.google.zxing.common.a();
        r24.a(r20);
        if (r19 != Mode.BYTE) goto L51;
        int r25 = r22.b();
    L52:
        a(r25, r23, r19, r24);
        r24.a(r22);
        r1 = r19;
        r11 = r23;
        r5 = r24;
        goto L53
    L51:
        r25 = r6.length();
        goto L52
    L41:
        if (r9.containsKey(EncodeHintType.QR_VERSION) == false) goto L47;
        r23 = com.google.zxing.qrcode.decoder.a.a(Integer.parseInt(r9.get(EncodeHintType.QR_VERSION).toString()));
        if (a(a(r19, r20, r22, r23), r23, r7) == true) goto L48;
        throw new WriterException("Data too big for requested version");
    L66:
        r4 = Charset.forName(r9.get(EncodeHintType.CHARACTER_SET).toString());     // Catch: UnsupportedCharsetException -> L65
        goto L25
    L20:
        if (r9.containsKey(EncodeHintType.CHARACTER_SET) == false) goto L22;
    L12:
        if (r9.containsKey(EncodeHintType.QR_COMPACT) == false) goto L16;
        if (Boolean.parseBoolean(r9.get(EncodeHintType.QR_COMPACT).toString()) == false) goto L16;
        r3 = true;
        goto L17
    L5:
        if (r9.containsKey(EncodeHintType.GS1_FORMAT) == false) goto L9;
        if (Boolean.parseBoolean(r9.get(EncodeHintType.GS1_FORMAT).toString()) == false) goto L9;
        r2 = true;
        goto L10
    }

    static void a(int r6, int r7, int r8, int r9, int[] r10, int[] r11) {
        if (r9 >= r8) goto L21;
        int r0 = r6 % r8;
        int r1 = r8 - r0;
        int r2 = r6 / r8;
        int r3 = r2 + 1;
        int r12 = r7 / r8;
        int r4 = r12 + 1;
        int r5 = r2 - r12;
        int r13 = r3 - r4;
        if (r5 != r13) goto L19;
        if (r8 != (r1 + r0)) goto L17;
        if (r6 != (((r12 + r5) * r1) + ((r4 + r13) * r0))) goto L15;
        if (r9 >= r1) goto L12;
        r10[0] = r12;
        r11[0] = r5;
        return;
    L12:
        r10[0] = r4;
        r11[0] = r13;
        return;
    L15:
        throw new WriterException("Total bytes mismatch");
    L17:
        throw new WriterException("RS blocks mismatch");
    L19:
        throw new WriterException("EC bytes mismatch");
    L21:
        throw new WriterException("Block ID too large");
    }

    static void a(int r4, com.google.zxing.common.a r5) {
        int r0 = r4 * 8;
        if (r5.a() > r0) goto L27;
        int r1 = 0;
        int r2 = 0;
    L6:
        if (r2 >= 4) goto L10;
        if (r5.a() >= r0) goto L10;
        r5.a(false);
        r2 = r2 + 1;
    L10:
        int r3 = r5.a() & 7;
        if (r3 <= 0) goto L14;
    L12:
        if (r3 >= 8) goto L14;
        r5.a(false);
        r3 = r3 + 1;
    L14:
        int r6 = r4 - r5.b();
    L15:
        if (r1 >= r6) goto L22;
        if ((r1 & 1) != 0) goto L19;
        int r7 = 236;
    L20:
        r5.a(r7, 8);
        r1 = r1 + 1;
        goto L15
    L19:
        r7 = 17;
        goto L20
    L22:
        if (r5.a() != r0) goto L25;
        return;
    L25:
        throw new WriterException("Bits size does not equal capacity");
    L27:
        throw new WriterException("data bits cannot fit in the QR Code" + r5.a() + " > " + r0);
    }

    static void a(int r1, com.google.zxing.qrcode.decoder.a r2, Mode r3, com.google.zxing.common.a r4) {
        int r5 = r3.getCharacterCountBits(r2);
        int r0 = 1 << r5;
        if (r1 >= r0) goto L7;
        r4.a(r1, r5);
        return;
    L7:
        throw new WriterException(r1 + " is bigger than " + (r0 - 1));
    }

    private static void a(CharacterSetECI r2, com.google.zxing.common.a r3) {
        r3.a(Mode.ECI.getBits(), 4);
        r3.a(r2.getValue(), 8);
    }

    static void a(Mode r1, com.google.zxing.common.a r2) {
        r2.a(r1.getBits(), 4);
    }

    static void a(CharSequence r6, com.google.zxing.common.a r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r6, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r8.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        int r2 = r8.charAt(r1) - '0';
        int r3 = r1 + 2;
        if (r3 < r0) goto L6;
        r1 = r1 + 1;
        if (r1 < r0) goto L9;
        r7.a(r2, 4);
        goto L3
    L9:
        r7.a((r2 * 10) + (r8.charAt(r1) - '0'), 7);
        r1 = r3;
        goto L3
    L6:
        r7.a(((r2 * 100) + ((r8.charAt(r1 + 1) - '0') * 10)) + (r8.charAt(r3) - '0'), 10);
        r1 = r1 + 3;
        goto L3
    }

    static void a(String r6, com.google.zxing.common.a r7) {
        if (com.google.zxing.common.d.f5070a == null) goto L27;
        byte[] r8 = r6.getBytes(com.google.zxing.common.d.f5070a);
        if ((r8.length % 2) != 0) goto L25;
        int r0 = r8.length - 1;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L23;
        int r2 = ((r8[r1] & 255) << 8) | (r8[r1 + 1] & 255);
        int r3 = 33088;
        if (r2 < 33088) goto L14;
        if (r2 > 40956) goto L14;
    L12:
        int r4 = r2 - r3;
    L19:
        if (r4 == (-1)) goto L22;
        r7.a(((r4 >> 8) * 192) + (r4 & 255), 13);
        r1 = r1 + 2;
        goto L7
    L22:
        throw new WriterException("Invalid byte sequence");
    L14:
        if (r2 >= 57408) goto L16;
    L18:
        r4 = -1;
        goto L19
    L16:
        if (r2 > 60351) goto L18;
        r3 = 49472;
        goto L12
    L23:
        return;
    L25:
        throw new WriterException("Kanji byte size not even");
    L27:
        throw new WriterException("SJIS Charset not supported on this platform");
    }

    static void a(String r3, com.google.zxing.common.a r4, Charset r5) {
        byte[] r6 = r3.getBytes(r5);
        int r7 = r6.length;
        int r0 = 0;
    L3:
        if (r0 >= r7) goto L5;
        r4.a(r6[r0], 8);
        r0 = r0 + 1;
        goto L3
    }

    static void a(String r2, Mode r3, com.google.zxing.common.a r4, Charset r5) {
        int r0 = AnonymousClass1.f5114a[r3.ordinal()];
        if (r0 != 1) goto L5;
        a(r2, r4);
        return;
    L5:
        if (r0 != 2) goto L7;
        b(r2, r4);
        return;
    L7:
        if (r0 != 3) goto L9;
        a(r2, r4, r5);
        return;
    L9:
        if (r0 != 4) goto L12;
        a(r2, r4);
        return;
    L12:
        throw new WriterException("Invalid mode: " + r3);
    }

    static boolean a(int r1, com.google.zxing.qrcode.decoder.a r2, ErrorCorrectionLevel r3) {
        if ((r2.b() - r2.a(r3).c()) < ((r1 + 7) / 8)) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean a(String r5) {
        byte[] r6 = r5.getBytes(com.google.zxing.common.d.f5070a);
        int r0 = r6.length;
        if ((r0 % 2) == 0) goto L5;
        return false;
    L5:
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L18;
        int r3 = r6[r1] & 255;
        if (r3 < 129) goto L12;
        if (r3 > 159) goto L12;
    L16:
        r1 = r1 + 2;
    L12:
        if (r3 < 224) goto L17;
        if (r3 <= 235) goto L16;
    L17:
        return false;
    L18:
        return true;
    }

    static byte[] a(byte[] r5, int r6) {
        int r0 = r5.length;
        int[] r1 = new int[r0 + r6];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = r5[r3] & 255;
        r3 = r3 + 1;
        goto L3
    L5:
        new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.e).a(r1, r6);
        byte[] r7 = new byte[r6];
    L6:
        if (r2 >= r6) goto L8;
        r7[r2] = (byte) r1[r0 + r2];
        r2 = r2 + 1;
        goto L6
    L8:
        return r7;
    }

    static void b(CharSequence r5, com.google.zxing.common.a r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r7.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L16;
        int r2 = a(r7.charAt(r1));
        if (r2 == (-1)) goto L15;
        int r4 = r1 + 1;
        if (r4 < r0) goto L8;
        r6.a(r2, 6);
        r1 = r4;
        goto L3
    L8:
        int r8 = a(r7.charAt(r4));
        if (r8 == (-1)) goto L12;
        r6.a((r2 * 45) + r8, 11);
        r1 = r1 + 2;
        goto L3
    L12:
        throw new WriterException();
    L15:
        throw new WriterException();
    }
}
