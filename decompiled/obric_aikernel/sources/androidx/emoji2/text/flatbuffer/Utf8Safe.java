package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class Utf8Safe extends Utf8 {

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int r10, int r11) {
            super("Unpaired surrogate at index " + r10 + " of " + r11);
        }
    }

    public Utf8Safe() {
    }

    private static int computeEncodedLength(CharSequence r10) {
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L7;
        if (r10.charAt(r12) >= 128) goto L7;
        r12 = r12 + 1;
    L7:
        int r13 = r11;
    L8:
        if (r12 >= r11) goto L13;
        char r14 = r10.charAt(r12);
        if (r14 >= 2048) goto L12;
        r13 = r13 + ((127 - r14) >>> 31);
        r12 = r12 + 1;
        goto L8
    L12:
        r13 = r13 + encodedLengthGeneral(r10, r12);
    L13:
        if (r13 < r11) goto L16;
        return r13;
    L16:
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) r13) + 4294967296L));
    }

    public static String decodeUtf8Array(byte[] r11, int r12, int r13) {
        if (((r12 | r13) | ((r11.length - r12) - r13)) < 0) goto L42;
        int r10 = r12 + r13;
        char[] r14 = new char[r13];
        int r15 = 0;
    L5:
        if (r12 >= r10) goto L10;
        byte r16 = r11[r12];
        if (Utf8.DecodeUtil.isOneByte(r16) == false) goto L10;
        r12 = r12 + 1;
        Utf8.DecodeUtil.handleOneByte(r16, r14, r15);
        r15 = r15 + 1;
    L10:
        int r17 = r15;
    L11:
        if (r12 >= r10) goto L40;
        int r18 = r12 + 1;
        byte r19 = r11[r12];
        if (Utf8.DecodeUtil.isOneByte(r19) == true) goto L14;
        if (Utf8.DecodeUtil.isTwoBytes(r19) == true) goto L23;
        if (Utf8.DecodeUtil.isThreeBytes(r19) == true) goto L30;
        if (r18 >= (r10 - 2)) goto L38;
        int r20 = r18 + 1;
        byte r21 = r11[r18];
        int r22 = r20 + 1;
        Utf8.DecodeUtil.handleFourBytes(r19, r21, r11[r20], r11[r22], r14, r17);
        r12 = r22 + 1;
        r17 = (r17 + 1) + 1;
        goto L11
    L38:
        throw new IllegalArgumentException("Invalid UTF-8");
    L30:
        if (r18 >= (r10 - 1)) goto L33;
        int r23 = r18 + 1;
        Utf8.DecodeUtil.handleThreeBytes(r19, r11[r18], r11[r23], r14, r17);
        r12 = r23 + 1;
        r17 = r17 + 1;
        goto L11
    L33:
        throw new IllegalArgumentException("Invalid UTF-8");
    L23:
        if (r18 >= r10) goto L26;
        Utf8.DecodeUtil.handleTwoBytes(r19, r11[r18], r14, r17);
        r12 = r18 + 1;
        r17 = r17 + 1;
        goto L11
    L26:
        throw new IllegalArgumentException("Invalid UTF-8");
    L14:
        int r24 = r17 + 1;
        Utf8.DecodeUtil.handleOneByte(r19, r14, r17);
    L15:
        if (r18 >= r10) goto L20;
        byte r110 = r11[r18];
        if (Utf8.DecodeUtil.isOneByte(r110) == false) goto L20;
        r18 = r18 + 1;
        Utf8.DecodeUtil.handleOneByte(r110, r14, r24);
        r24 = r24 + 1;
    L20:
        r12 = r18;
        r17 = r24;
        goto L11
    L40:
        return new String(r14, 0, r17);
    L42:
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(r11.length), Integer.valueOf(r12), Integer.valueOf(r13)}));
    }

    public static String decodeUtf8Buffer(ByteBuffer r11, int r12, int r13) {
        if (((r12 | r13) | ((r11.limit() - r12) - r13)) < 0) goto L42;
        int r10 = r12 + r13;
        char[] r14 = new char[r13];
        int r15 = 0;
    L5:
        if (r12 >= r10) goto L10;
        byte r16 = r11.get(r12);
        if (Utf8.DecodeUtil.isOneByte(r16) == false) goto L10;
        r12 = r12 + 1;
        Utf8.DecodeUtil.handleOneByte(r16, r14, r15);
        r15 = r15 + 1;
    L10:
        int r17 = r15;
    L11:
        if (r12 >= r10) goto L40;
        int r18 = r12 + 1;
        byte r19 = r11.get(r12);
        if (Utf8.DecodeUtil.isOneByte(r19) == true) goto L14;
        if (Utf8.DecodeUtil.isTwoBytes(r19) == true) goto L23;
        if (Utf8.DecodeUtil.isThreeBytes(r19) == true) goto L30;
        if (r18 >= (r10 - 2)) goto L38;
        int r20 = r18 + 1;
        byte r21 = r11.get(r18);
        int r22 = r20 + 1;
        Utf8.DecodeUtil.handleFourBytes(r19, r21, r11.get(r20), r11.get(r22), r14, r17);
        r12 = r22 + 1;
        r17 = (r17 + 1) + 1;
        goto L11
    L38:
        throw new IllegalArgumentException("Invalid UTF-8");
    L30:
        if (r18 >= (r10 - 1)) goto L33;
        int r23 = r18 + 1;
        Utf8.DecodeUtil.handleThreeBytes(r19, r11.get(r18), r11.get(r23), r14, r17);
        r12 = r23 + 1;
        r17 = r17 + 1;
        goto L11
    L33:
        throw new IllegalArgumentException("Invalid UTF-8");
    L23:
        if (r18 >= r10) goto L26;
        Utf8.DecodeUtil.handleTwoBytes(r19, r11.get(r18), r14, r17);
        r12 = r18 + 1;
        r17 = r17 + 1;
        goto L11
    L26:
        throw new IllegalArgumentException("Invalid UTF-8");
    L14:
        int r24 = r17 + 1;
        Utf8.DecodeUtil.handleOneByte(r19, r14, r17);
    L15:
        if (r18 >= r10) goto L20;
        byte r110 = r11.get(r18);
        if (Utf8.DecodeUtil.isOneByte(r110) == false) goto L20;
        r18 = r18 + 1;
        Utf8.DecodeUtil.handleOneByte(r110, r14, r24);
        r24 = r24 + 1;
    L20:
        r12 = r18;
        r17 = r24;
        goto L11
    L40:
        return new String(r14, 0, r17);
    L42:
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r11.limit()), Integer.valueOf(r12), Integer.valueOf(r13)}));
    }

    private static int encodeUtf8Array(CharSequence r10, byte[] r11, int r12, int r13) {
        int r14 = r10.length();
        int r15 = r13 + r12;
        int r16 = 0;
    L4:
        if (r16 >= r14) goto L10;
        int r17 = r16 + r12;
        if (r17 >= r15) goto L10;
        char r18 = r10.charAt(r16);
        if (r18 >= 128) goto L10;
        r11[r17] = (byte) r18;
        r16 = r16 + 1;
    L10:
        if (r16 == r14) goto L12;
        int r19 = r12 + r16;
    L14:
        if (r16 >= r14) goto L52;
        char r20 = r10.charAt(r16);
        if (r20 >= 128) goto L21;
        if (r19 >= r15) goto L21;
        int r21 = r19 + 1;
        r11[r19] = (byte) r20;
    L19:
        r19 = r21;
    L38:
        r16 = r16 + 1;
    L21:
        if (r20 >= 2048) goto L26;
        if (r19 > (r15 - 2)) goto L26;
        int r22 = r19 + 1;
        r11[r19] = (byte) ((r20 >>> 6) | 960);
        r19 = r22 + 1;
        r11[r22] = (byte) ((r20 & '?') | 128);
    L26:
        if (r20 < 55296) goto L29;
        if (57343 < r20) goto L29;
    L32:
        if (r19 > (r15 - 4)) goto L42;
        int r23 = r16 + 1;
        if (r23 == r10.length()) goto L41;
        char r24 = r10.charAt(r23);
        if (Character.isSurrogatePair(r20, r24) == false) goto L39;
        int r25 = Character.toCodePoint(r20, r24);
        int r26 = r19 + 1;
        r11[r19] = (byte) ((r25 >>> 18) | 240);
        int r27 = r26 + 1;
        r11[r26] = (byte) (((r25 >>> 12) & 63) | 128);
        int r28 = r27 + 1;
        r11[r27] = (byte) (((r25 >>> 6) & 63) | 128);
        r19 = r28 + 1;
        r11[r28] = (byte) ((r25 & 63) | 128);
        r16 = r23;
        goto L38
    L39:
        r16 = r23;
    L41:
        throw new UnpairedSurrogateException(r16 - 1, r14);
    L42:
        if (55296 > r20) goto L51;
        if (r20 > 57343) goto L51;
        int r29 = r16 + 1;
        if (r29 == r10.length()) goto L49;
        if (Character.isSurrogatePair(r20, r10.charAt(r29)) == true) goto L51;
    L49:
        throw new UnpairedSurrogateException(r16, r14);
    L51:
        throw new ArrayIndexOutOfBoundsException("Failed writing " + r20 + " at index " + r19);
    L29:
        if (r19 > (r15 - 3)) goto L32;
        int r30 = r19 + 1;
        r11[r19] = (byte) ((r20 >>> '\f') | 480);
        int r31 = r30 + 1;
        r11[r30] = (byte) (((r20 >>> 6) & 63) | 128);
        r21 = r31 + 1;
        r11[r31] = (byte) ((r20 & '?') | 128);
        goto L19
    L52:
        return r19;
    L12:
        return r12 + r14;
    }

    private static void encodeUtf8Buffer(CharSequence r10, ByteBuffer r11) {
        int r12 = r10.length();
        int r13 = r11.position();
        int r14 = 0;
    L4:
        if (r14 >= r12) goto L8;
        char r15 = r10.charAt(r14);     // Catch: IndexOutOfBoundsException -> L55
        if (r15 >= 128) goto L8;
        r11.put(r13 + r14, (byte) r15);     // Catch: IndexOutOfBoundsException -> L55
        r14 = r14 + 1;     // Catch: IndexOutOfBoundsException -> L55
    L53:
        throw new ArrayIndexOutOfBoundsException("Failed writing " + r10.charAt(r14) + " at index " + (r11.position() + Math.max(r14, (r13 - r11.position()) + 1)));
    L8:
        if (r14 != r12) goto L11;
        r11.position(r13 + r14);     // Catch: IndexOutOfBoundsException -> L55
        return;
    L11:
        r13 = r13 + r14;     // Catch: IndexOutOfBoundsException -> L55
    L12:
        if (r14 >= r12) goto L50;
        char r16 = r10.charAt(r14);     // Catch: IndexOutOfBoundsException -> L55
        if (r16 >= 128) goto L18;
        r11.put(r13, (byte) r16);     // Catch: IndexOutOfBoundsException -> L55
    L49:
        r14 = r14 + 1;     // Catch: IndexOutOfBoundsException -> L55
        r13 = r13 + 1;     // Catch: IndexOutOfBoundsException -> L55
        goto L12
    L18:
        if (r16 >= 2048) goto L24;
        int r17 = r13 + 1;
        r11.put(r13, (byte) ((r16 >>> 6) | 192));     // Catch: IndexOutOfBoundsException -> L22
        r11.put(r17, (byte) ((r16 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L22
        r13 = r17;
    L22:
        r13 = r17;
        goto L53
    L24:
        if (r16 >= 55296) goto L26;
    L45:
        int r18 = r13 + 1;
        r11.put(r13, (byte) ((r16 >>> '\f') | 224));     // Catch: IndexOutOfBoundsException -> L22
        r13 = r18 + 1;
        r11.put(r18, (byte) (((r16 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L55
        r11.put(r13, (byte) ((r16 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L55
        goto L49
    L26:
        if (57343 < r16) goto L45;
        int r19 = r14 + 1;
        if (r19 == r12) goto L44;
        char r20 = r10.charAt(r19);     // Catch: IndexOutOfBoundsException -> L54
        if (Character.isSurrogatePair(r16, r20) == false) goto L41;
        int r21 = Character.toCodePoint(r16, r20);     // Catch: IndexOutOfBoundsException -> L54
        int r22 = r13 + 1;
        r11.put(r13, (byte) ((r21 >>> 18) | 240));     // Catch: IndexOutOfBoundsException -> L40
        r13 = r22 + 1;
        r11.put(r22, (byte) (((r21 >>> 12) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L54
        r22 = r13 + 1;
        r11.put(r13, (byte) (((r21 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L40
        r11.put(r22, (byte) ((r21 & 63) | 128));     // Catch: IndexOutOfBoundsException -> L40
        r13 = r22;
        r14 = r19;
    L40:
        r13 = r22;
        goto L42
    L41:
        r14 = r19;
    L42:
        r14 = r19;
    L44:
        throw new UnpairedSurrogateException(r14, r12);     // Catch: IndexOutOfBoundsException -> L55
    L50:
        r11.position(r13);     // Catch: IndexOutOfBoundsException -> L55
    }

    private static int encodedLengthGeneral(CharSequence r10, int r11) {
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r11 >= r12) goto L17;
        char r14 = r10.charAt(r11);
        if (r14 >= 2048) goto L7;
        r13 = r13 + ((127 - r14) >>> 31);
    L16:
        r11 = r11 + 1;
        goto L3
    L7:
        r13 = r13 + 2;
        if (55296 > r14) goto L16;
        if (r14 > 57343) goto L16;
        if (Character.codePointAt(r10, r11) < 65536) goto L15;
        r11 = r11 + 1;
        goto L16
    L15:
        throw new UnpairedSurrogateException(r11, r12);
    L17:
        return r13;
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer r10, int r11, int r12) {
        if (r10.hasArray() == false) goto L7;
        return decodeUtf8Array(r10.array(), r10.arrayOffset() + r11, r12);
    L7:
        return decodeUtf8Buffer(r10, r11, r12);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence r10, ByteBuffer r11) {
        if (r11.hasArray() == false) goto L5;
        int r12 = r11.arrayOffset();
        r11.position(encodeUtf8Array(r10, r11.array(), r11.position() + r12, r11.remaining()) - r12);
        return;
    L5:
        encodeUtf8Buffer(r10, r11);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence r10) {
        return computeEncodedLength(r10);
    }
}
