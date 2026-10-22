package androidx.emoji2.text.flatbuffer;

import ai.j0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class Utf8Safe extends Utf8 {

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int r5, int r10) {
            super(j0.f(r5, r10, "Unpaired surrogate at index ", " of "));
        }
    }

    public Utf8Safe() {
    }

    private static int computeEncodedLength(CharSequence r5) {
        int r10 = r5.length();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L7;
        if (r5.charAt(r11) >= 128) goto L7;
        r11 = r11 + 1;
    L7:
        int r12 = r10;
    L8:
        if (r11 >= r10) goto L13;
        char r13 = r5.charAt(r11);
        if (r13 >= 2048) goto L12;
        r12 = r12 + ((127 - r13) >>> 31);
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = r12 + encodedLengthGeneral(r5, r11);
    L13:
        if (r12 < r10) goto L16;
        return r12;
    L16:
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) r12) + 4294967296L));
    }

    public static String decodeUtf8Array(byte[] r10, int r11, int r12) {
        if (((r11 | r12) | ((r10.length - r11) - r12)) < 0) goto L42;
        int r5 = r11 + r12;
        char[] r13 = new char[r12];
        int r14 = 0;
    L5:
        if (r11 >= r5) goto L10;
        byte r15 = r10[r11];
        if (Utf8.DecodeUtil.isOneByte(r15) == false) goto L10;
        r11 = r11 + 1;
        Utf8.DecodeUtil.handleOneByte(r15, r13, r14);
        r14 = r14 + 1;
    L10:
        int r16 = r14;
    L11:
        if (r11 >= r5) goto L40;
        int r17 = r11 + 1;
        byte r18 = r10[r11];
        if (Utf8.DecodeUtil.isOneByte(r18) == true) goto L14;
        if (Utf8.DecodeUtil.isTwoBytes(r18) == true) goto L23;
        if (Utf8.DecodeUtil.isThreeBytes(r18) == true) goto L30;
        if (r17 >= (r5 - 2)) goto L38;
        byte r19 = r10[r17];
        int r20 = r11 + 3;
        byte r21 = r10[r11 + 2];
        r11 = r11 + 4;
        Utf8.DecodeUtil.handleFourBytes(r18, r19, r21, r10[r20], r13, r16);
        r16 = r16 + 2;
        goto L11
    L38:
        throw new IllegalArgumentException("Invalid UTF-8");
    L30:
        if (r17 >= (r5 - 1)) goto L33;
        int r22 = r11 + 2;
        r11 = r11 + 3;
        Utf8.DecodeUtil.handleThreeBytes(r18, r10[r17], r10[r22], r13, r16);
        r16 = r16 + 1;
        goto L11
    L33:
        throw new IllegalArgumentException("Invalid UTF-8");
    L23:
        if (r17 >= r5) goto L26;
        r11 = r11 + 2;
        Utf8.DecodeUtil.handleTwoBytes(r18, r10[r17], r13, r16);
        r16 = r16 + 1;
        goto L11
    L26:
        throw new IllegalArgumentException("Invalid UTF-8");
    L14:
        int r110 = r16 + 1;
        Utf8.DecodeUtil.handleOneByte(r18, r13, r16);
    L15:
        if (r17 >= r5) goto L20;
        byte r23 = r10[r17];
        if (Utf8.DecodeUtil.isOneByte(r23) == false) goto L20;
        r17 = r17 + 1;
        Utf8.DecodeUtil.handleOneByte(r23, r13, r110);
        r110 = r110 + 1;
    L20:
        r16 = r110;
        r11 = r17;
        goto L11
    L40:
        return new String(r13, 0, r16);
    L42:
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(r10.length), Integer.valueOf(r11), Integer.valueOf(r12)}));
    }

    public static String decodeUtf8Buffer(ByteBuffer r10, int r11, int r12) {
        if (((r11 | r12) | ((r10.limit() - r11) - r12)) < 0) goto L42;
        int r5 = r11 + r12;
        char[] r13 = new char[r12];
        int r14 = 0;
    L5:
        if (r11 >= r5) goto L10;
        byte r15 = r10.get(r11);
        if (Utf8.DecodeUtil.isOneByte(r15) == false) goto L10;
        r11 = r11 + 1;
        Utf8.DecodeUtil.handleOneByte(r15, r13, r14);
        r14 = r14 + 1;
    L10:
        int r16 = r14;
    L11:
        if (r11 >= r5) goto L40;
        int r17 = r11 + 1;
        byte r18 = r10.get(r11);
        if (Utf8.DecodeUtil.isOneByte(r18) == true) goto L14;
        if (Utf8.DecodeUtil.isTwoBytes(r18) == true) goto L23;
        if (Utf8.DecodeUtil.isThreeBytes(r18) == true) goto L30;
        if (r17 >= (r5 - 2)) goto L38;
        byte r19 = r10.get(r17);
        int r20 = r11 + 3;
        byte r21 = r10.get(r11 + 2);
        r11 = r11 + 4;
        Utf8.DecodeUtil.handleFourBytes(r18, r19, r21, r10.get(r20), r13, r16);
        r16 = r16 + 2;
        goto L11
    L38:
        throw new IllegalArgumentException("Invalid UTF-8");
    L30:
        if (r17 >= (r5 - 1)) goto L33;
        int r22 = r11 + 2;
        r11 = r11 + 3;
        Utf8.DecodeUtil.handleThreeBytes(r18, r10.get(r17), r10.get(r22), r13, r16);
        r16 = r16 + 1;
        goto L11
    L33:
        throw new IllegalArgumentException("Invalid UTF-8");
    L23:
        if (r17 >= r5) goto L26;
        r11 = r11 + 2;
        Utf8.DecodeUtil.handleTwoBytes(r18, r10.get(r17), r13, r16);
        r16 = r16 + 1;
        goto L11
    L26:
        throw new IllegalArgumentException("Invalid UTF-8");
    L14:
        int r110 = r16 + 1;
        Utf8.DecodeUtil.handleOneByte(r18, r13, r16);
    L15:
        if (r17 >= r5) goto L20;
        byte r23 = r10.get(r17);
        if (Utf8.DecodeUtil.isOneByte(r23) == false) goto L20;
        r17 = r17 + 1;
        Utf8.DecodeUtil.handleOneByte(r23, r13, r110);
        r110 = r110 + 1;
    L20:
        r16 = r110;
        r11 = r17;
        goto L11
    L40:
        return new String(r13, 0, r16);
    L42:
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r10.limit()), Integer.valueOf(r11), Integer.valueOf(r12)}));
    }

    private static int encodeUtf8Array(CharSequence r10, byte[] r11, int r12, int r13) {
        int r5 = r10.length();
        int r14 = r13 + r12;
        int r15 = 0;
    L4:
        if (r15 >= r5) goto L10;
        int r16 = r15 + r12;
        if (r16 >= r14) goto L10;
        char r17 = r10.charAt(r15);
        if (r17 >= 128) goto L10;
        r11[r16] = (byte) r17;
        r15 = r15 + 1;
    L10:
        if (r15 == r5) goto L12;
        int r18 = r12 + r15;
    L14:
        if (r15 >= r5) goto L51;
        char r19 = r10.charAt(r15);
        if (r19 >= 128) goto L20;
        if (r18 >= r14) goto L20;
        r11[r18] = (byte) r19;
        r18 = r18 + 1;
    L37:
        r15 = r15 + 1;
    L20:
        if (r19 >= 2048) goto L25;
        if (r18 > (r14 - 2)) goto L25;
        int r20 = r18 + 1;
        r11[r18] = (byte) ((r19 >>> 6) | 960);
        r18 = r18 + 2;
        r11[r20] = (byte) ((r19 & '?') | 128);
    L25:
        if (r19 < 55296) goto L28;
        if (57343 < r19) goto L28;
    L31:
        if (r18 > (r14 - 4)) goto L41;
        int r21 = r15 + 1;
        if (r21 == r10.length()) goto L40;
        char r22 = r10.charAt(r21);
        if (Character.isSurrogatePair(r19, r22) == false) goto L38;
        int r23 = Character.toCodePoint(r19, r22);
        r11[r18] = (byte) ((r23 >>> 18) | 240);
        r11[r18 + 1] = (byte) (((r23 >>> 12) & 63) | 128);
        int r24 = r18 + 3;
        r11[r18 + 2] = (byte) (((r23 >>> 6) & 63) | 128);
        r18 = r18 + 4;
        r11[r24] = (byte) ((r23 & 63) | 128);
        r15 = r21;
        goto L37
    L38:
        r15 = r21;
    L40:
        throw new UnpairedSurrogateException(r15 - 1, r5);
    L41:
        if (55296 > r19) goto L50;
        if (r19 > 57343) goto L50;
        int r25 = r15 + 1;
        if (r25 == r10.length()) goto L48;
        if (Character.isSurrogatePair(r19, r10.charAt(r25)) == true) goto L50;
    L48:
        throw new UnpairedSurrogateException(r15, r5);
    L50:
        throw new ArrayIndexOutOfBoundsException("Failed writing " + r19 + " at index " + r18);
    L28:
        if (r18 > (r14 - 3)) goto L31;
        r11[r18] = (byte) ((r19 >>> '\f') | 480);
        int r26 = r18 + 2;
        r11[r18 + 1] = (byte) (((r19 >>> 6) & 63) | 128);
        r18 = r18 + 3;
        r11[r26] = (byte) ((r19 & '?') | 128);
        goto L37
    L51:
        return r18;
    L12:
        return r12 + r5;
    }

    private static void encodeUtf8Buffer(CharSequence r10, ByteBuffer r11) {
        int r5 = r10.length();
        int r12 = r11.position();
        int r13 = 0;
    L4:
        if (r13 >= r5) goto L8;
        char r14 = r10.charAt(r13);     // Catch: IndexOutOfBoundsException -> L56
        if (r14 >= 128) goto L8;
        r11.put(r12 + r13, (byte) r14);     // Catch: IndexOutOfBoundsException -> L56
        r13 = r13 + 1;     // Catch: IndexOutOfBoundsException -> L56
    L54:
        throw new ArrayIndexOutOfBoundsException("Failed writing " + r10.charAt(r13) + " at index " + (Math.max(r13, (r12 - r11.position()) + 1) + r11.position()));
    L8:
        if (r13 != r5) goto L11;
        r11.position(r12 + r13);     // Catch: IndexOutOfBoundsException -> L56
        return;
    L11:
        r12 = r12 + r13;     // Catch: IndexOutOfBoundsException -> L56
    L12:
        if (r13 >= r5) goto L51;
        char r15 = r10.charAt(r13);     // Catch: IndexOutOfBoundsException -> L56
        if (r15 >= 128) goto L18;
        r11.put(r12, (byte) r15);     // Catch: IndexOutOfBoundsException -> L56
    L50:
        r13 = r13 + 1;     // Catch: IndexOutOfBoundsException -> L56
        r12 = r12 + 1;     // Catch: IndexOutOfBoundsException -> L56
        goto L12
    L18:
        if (r15 >= 2048) goto L24;
        int r16 = r12 + 1;
        r11.put(r12, (byte) ((r15 >>> 6) | 192));     // Catch: IndexOutOfBoundsException -> L22
        r11.put(r16, (byte) ((r15 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L22
        r12 = r16;
    L22:
        r12 = r16;
        goto L54
    L24:
        if (r15 >= 55296) goto L26;
    L46:
        int r17 = r12 + 1;
        r11.put(r12, (byte) ((r15 >>> '\f') | 224));     // Catch: IndexOutOfBoundsException -> L22
        r12 = r12 + 2;
        r11.put(r17, (byte) (((r15 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L56
        r11.put(r12, (byte) ((r15 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L56
        goto L50
    L26:
        if (57343 < r15) goto L46;
        int r18 = r13 + 1;
        if (r18 == r5) goto L45;
        char r19 = r10.charAt(r18);     // Catch: IndexOutOfBoundsException -> L55
        if (Character.isSurrogatePair(r15, r19) == false) goto L43;
        int r20 = Character.toCodePoint(r15, r19);     // Catch: IndexOutOfBoundsException -> L55
        int r21 = r12 + 1;
        r11.put(r12, (byte) ((r20 >>> 18) | 240));     // Catch: IndexOutOfBoundsException -> L42
        int r22 = r12 + 2;
        r11.put(r21, (byte) (((r20 >>> 12) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L41
        r12 = r12 + 3;
        r11.put(r22, (byte) (((r20 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L55
        r11.put(r12, (byte) ((r20 & 63) | 128));     // Catch: IndexOutOfBoundsException -> L55
        r13 = r18;
    L41:
        r13 = r18;
        r12 = r22;
    L42:
        r12 = r21;
        goto L40
    L43:
        r13 = r18;
    L40:
        r13 = r18;
    L45:
        throw new UnpairedSurrogateException(r13, r5);     // Catch: IndexOutOfBoundsException -> L56
    L51:
        r11.position(r12);     // Catch: IndexOutOfBoundsException -> L56
    }

    private static int encodedLengthGeneral(CharSequence r5, int r10) {
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r10 >= r11) goto L17;
        char r13 = r5.charAt(r10);
        if (r13 >= 2048) goto L7;
        r12 = r12 + ((127 - r13) >>> 31);
    L16:
        r10 = r10 + 1;
        goto L3
    L7:
        r12 = r12 + 2;
        if (55296 > r13) goto L16;
        if (r13 > 57343) goto L16;
        if (Character.codePointAt(r5, r10) < 65536) goto L15;
        r10 = r10 + 1;
        goto L16
    L15:
        throw new UnpairedSurrogateException(r10, r11);
    L17:
        return r12;
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer r5, int r10, int r11) throws IllegalArgumentException {
        if (r5.hasArray() == false) goto L7;
        return decodeUtf8Array(r5.array(), r5.arrayOffset() + r10, r11);
    L7:
        return decodeUtf8Buffer(r5, r10, r11);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence r5, ByteBuffer r10) {
        if (r10.hasArray() == false) goto L5;
        int r11 = r10.arrayOffset();
        r10.position(encodeUtf8Array(r5, r10.array(), r10.position() + r11, r10.remaining()) - r11);
        return;
    L5:
        encodeUtf8Buffer(r5, r10);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence r5) {
        return computeEncodedLength(r5);
    }
}
