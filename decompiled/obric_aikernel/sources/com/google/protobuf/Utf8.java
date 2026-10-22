package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor = null;

    private static class DecodeUtil {
        private DecodeUtil() {
        }

        static /* synthetic */ void access$1000(byte r10, byte r11, byte r12, byte r13, char[] r14, int r15) {
            handleFourBytes(r10, r11, r12, r13, r14, r15);
        }

        static /* synthetic */ boolean access$400(byte r10) {
            return isOneByte(r10);
        }

        static /* synthetic */ void access$500(byte r10, char[] r11, int r12) {
            handleOneByte(r10, r11, r12);
        }

        static /* synthetic */ boolean access$600(byte r10) {
            return isTwoBytes(r10);
        }

        static /* synthetic */ void access$700(byte r10, byte r11, char[] r12, int r13) {
            handleTwoBytes(r10, r11, r12, r13);
        }

        static /* synthetic */ boolean access$800(byte r10) {
            return isThreeBytes(r10);
        }

        static /* synthetic */ void access$900(byte r10, byte r11, byte r12, char[] r13, int r14) {
            handleThreeBytes(r10, r11, r12, r13, r14);
        }

        private static void handleFourBytes(byte r10, byte r11, byte r12, byte r13, char[] r14, int r15) {
            if (isNotTrailingByte(r11) == true) goto L13;
            if ((((r10 << 28) + (r11 + 112)) >> 30) != 0) goto L13;
            if (isNotTrailingByte(r12) == true) goto L13;
            if (isNotTrailingByte(r13) == true) goto L13;
            int r16 = ((((r10 & 7) << 18) | (trailingByteValue(r11) << 12)) | (trailingByteValue(r12) << 6)) | trailingByteValue(r13);
            r14[r15] = highSurrogate(r16);
            r14[r15 + 1] = lowSurrogate(r16);
            return;
        L13:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void handleOneByte(byte r10, char[] r11, int r12) {
            r11[r12] = (char) r10;
        }

        private static void handleThreeBytes(byte r10, byte r11, byte r12, char[] r13, int r14) {
            if (isNotTrailingByte(r11) == true) goto L15;
            if (r10 != (-32)) goto L8;
            if (r11 < (-96)) goto L15;
        L8:
            if (r10 != (-19)) goto L11;
            if (r11 >= (-96)) goto L15;
        L11:
            if (isNotTrailingByte(r12) == true) goto L15;
            r13[r14] = (char) ((((r10 & 15) << 12) | (trailingByteValue(r11) << 6)) | trailingByteValue(r12));
            return;
        L15:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void handleTwoBytes(byte r10, byte r11, char[] r12, int r13) {
            if (r10 < (-62)) goto L9;
            if (isNotTrailingByte(r11) == true) goto L9;
            r12[r13] = (char) (((r10 & 31) << 6) | trailingByteValue(r11));
            return;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static char highSurrogate(int r10) {
            return (char) ((r10 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte r10) {
            if (r10 <= (-65)) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isOneByte(byte r10) {
            if (r10 < 0) goto L4;
            return true;
        L4:
            return false;
        }

        private static boolean isThreeBytes(byte r10) {
            if (r10 >= (-16)) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isTwoBytes(byte r10) {
            if (r10 >= (-32)) goto L5;
            return true;
        L5:
            return false;
        }

        private static char lowSurrogate(int r10) {
            return (char) ((r10 & 1023) + 56320);
        }

        private static int trailingByteValue(byte r10) {
            return r10 & 63;
        }
    }

    static abstract class Processor {
        Processor() {
        }

        private static int partialIsValidUtf8(ByteBuffer r10, int r11, int r12) {
            int r13 = r11 + Utf8.access$200(r10, r11, r12);
        L3:
            if (r13 >= r12) goto L4;
            int r14 = r13 + 1;
            byte r15 = r10.get(r13);
            if (r15 >= 0) goto L50;
            if (r15 < (-32)) goto L10;
            if (r15 < (-16)) goto L22;
            if (r14 >= (r12 - 2)) goto L24;
            int r16 = r14 + 1;
            byte r17 = r10.get(r14);
            if (r17 > (-65)) goto L49;
            if ((((r15 << 28) + (r17 + 112)) >> 30) != 0) goto L49;
            int r18 = r16 + 1;
            if (r10.get(r16) > (-65)) goto L49;
            r14 = r18 + 1;
            if (r10.get(r18) <= (-65)) goto L50;
        L49:
            return -1;
        L24:
            return Utf8.access$300(r10, r15, r14, r12 - r14);
        L22:
            if (r14 >= (r12 - 1)) goto L24;
            int r19 = r14 + 1;
            byte r20 = r10.get(r14);
            if (r20 > (-65)) goto L37;
            if (r15 != (-32)) goto L31;
            if (r20 < (-96)) goto L37;
        L31:
            if (r15 != (-19)) goto L34;
            if (r20 >= (-96)) goto L37;
        L34:
            if (r10.get(r19) > (-65)) goto L37;
            r13 = r19 + 1;
        L37:
            return -1;
        L10:
            if (r14 >= r12) goto L11;
            if (r15 < (-62)) goto L18;
            if (r10.get(r14) > (-65)) goto L18;
            r14 = r14 + 1;
        L18:
            return -1;
        L11:
            return r15;
        L50:
            r13 = r14;
            goto L3
        L4:
            return 0;
        }

        final String decodeUtf8(ByteBuffer r10, int r11, int r12) {
            if (r10.hasArray() == false) goto L7;
            int r13 = r10.arrayOffset();
            return decodeUtf8(r10.array(), r13 + r11, r12);
        L7:
            if (r10.isDirect() == false) goto L11;
            return decodeUtf8Direct(r10, r11, r12);
        L11:
            return decodeUtf8Default(r10, r11, r12);
        }

        abstract String decodeUtf8(byte[] r10, int r11, int r12);

        final String decodeUtf8Default(ByteBuffer r11, int r12, int r13) {
            if (((r12 | r13) | ((r11.limit() - r12) - r13)) < 0) goto L42;
            int r10 = r12 + r13;
            char[] r14 = new char[r13];
            int r15 = 0;
        L5:
            if (r12 >= r10) goto L10;
            byte r16 = r11.get(r12);
            if (DecodeUtil.access$400(r16) == false) goto L10;
            r12 = r12 + 1;
            DecodeUtil.access$500(r16, r14, r15);
            r15 = r15 + 1;
        L10:
            int r17 = r15;
        L11:
            if (r12 >= r10) goto L40;
            int r18 = r12 + 1;
            byte r19 = r11.get(r12);
            if (DecodeUtil.access$400(r19) == true) goto L14;
            if (DecodeUtil.access$600(r19) == true) goto L23;
            if (DecodeUtil.access$800(r19) == true) goto L30;
            if (r18 >= (r10 - 2)) goto L38;
            int r20 = r18 + 1;
            byte r21 = r11.get(r18);
            int r22 = r20 + 1;
            DecodeUtil.access$1000(r19, r21, r11.get(r20), r11.get(r22), r14, r17);
            r12 = r22 + 1;
            r17 = (r17 + 1) + 1;
            goto L11
        L38:
            throw InvalidProtocolBufferException.invalidUtf8();
        L30:
            if (r18 >= (r10 - 1)) goto L33;
            int r23 = r18 + 1;
            DecodeUtil.access$900(r19, r11.get(r18), r11.get(r23), r14, r17);
            r12 = r23 + 1;
            r17 = r17 + 1;
            goto L11
        L33:
            throw InvalidProtocolBufferException.invalidUtf8();
        L23:
            if (r18 >= r10) goto L26;
            DecodeUtil.access$700(r19, r11.get(r18), r14, r17);
            r12 = r18 + 1;
            r17 = r17 + 1;
            goto L11
        L26:
            throw InvalidProtocolBufferException.invalidUtf8();
        L14:
            int r24 = r17 + 1;
            DecodeUtil.access$500(r19, r14, r17);
        L15:
            if (r18 >= r10) goto L20;
            byte r110 = r11.get(r18);
            if (DecodeUtil.access$400(r110) == false) goto L20;
            r18 = r18 + 1;
            DecodeUtil.access$500(r110, r14, r24);
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

        abstract String decodeUtf8Direct(ByteBuffer r10, int r11, int r12);

        abstract int encodeUtf8(String r10, byte[] r11, int r12, int r13);

        final void encodeUtf8(String r10, ByteBuffer r11) {
            if (r11.hasArray() == false) goto L6;
            int r12 = r11.arrayOffset();
            Java8Compatibility.position(r11, Utf8.encode(r10, r11.array(), r11.position() + r12, r11.remaining()) - r12);
            return;
        L6:
            if (r11.isDirect() == false) goto L8;
            encodeUtf8Direct(r10, r11);
            return;
        L8:
            encodeUtf8Default(r10, r11);
        }

        final void encodeUtf8Default(String r10, ByteBuffer r11) {
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
            Java8Compatibility.position(r11, r13 + r14);     // Catch: IndexOutOfBoundsException -> L55
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
            Java8Compatibility.position(r11, r13);     // Catch: IndexOutOfBoundsException -> L55
        }

        abstract void encodeUtf8Direct(String r10, ByteBuffer r11);

        final boolean isValidUtf8(ByteBuffer r10, int r11, int r12) {
            if (partialIsValidUtf8(0, r10, r11, r12) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        final boolean isValidUtf8(byte[] r10, int r11, int r12) {
            if (partialIsValidUtf8(0, r10, r11, r12) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        final int partialIsValidUtf8(int r10, ByteBuffer r11, int r12, int r13) {
            if (r11.hasArray() == false) goto L7;
            int r14 = r11.arrayOffset();
            return partialIsValidUtf8(r10, r11.array(), r12 + r14, r14 + r13);
        L7:
            if (r11.isDirect() == false) goto L11;
            return partialIsValidUtf8Direct(r10, r11, r12, r13);
        L11:
            return partialIsValidUtf8Default(r10, r11, r12, r13);
        }

        abstract int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13);

        final int partialIsValidUtf8Default(int r10, ByteBuffer r11, int r12, int r13) {
            if (r10 == 0) goto L55;
            if (r12 < r13) goto L5;
            return r10;
        L5:
            byte r14 = (byte) r10;
            if (r14 >= (-32)) goto L15;
            if (r14 < (-62)) goto L13;
            int r15 = r12 + 1;
            if (r11.get(r12) > (-65)) goto L13;
        L12:
            r12 = r15;
        L13:
            return -1;
        L15:
            if (r14 >= (-16)) goto L33;
            byte r16 = (byte) (~(r10 >> 8));
            if (r16 != 0) goto L23;
            int r17 = r12 + 1;
            byte r18 = r11.get(r12);
            if (r17 >= r13) goto L21;
            r12 = r17;
            r16 = r18;
            goto L23
        L21:
            return Utf8.access$000(r14, r18);
        L23:
            if (r16 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r14 != (-32)) goto L28;
            if (r16 < (-96)) goto L32;
        L28:
            if (r14 != (-19)) goto L30;
            if (r16 >= (-96)) goto L32;
        L30:
            r15 = r12 + 1;
            if (r11.get(r12) <= (-65)) goto L12;
        L33:
            byte r19 = (byte) (~(r10 >> 8));
            byte r20 = 0;
            if (r19 != 0) goto L40;
            int r21 = r12 + 1;
            r19 = r11.get(r12);
            if (r21 >= r13) goto L38;
            r12 = r21;
        L41:
            if (r20 != 0) goto L47;
            int r22 = r12 + 1;
            r20 = r11.get(r12);
            if (r22 >= r13) goto L45;
            r12 = r22;
            goto L47
        L45:
            return Utf8.access$100(r14, r19, r20);
        L47:
            if (r19 <= (-65)) goto L49;
        L53:
            return -1;
        L49:
            if ((((r14 << 28) + (r19 + 112)) >> 30) != 0) goto L53;
            if (r20 > (-65)) goto L53;
            r15 = r12 + 1;
            if (r11.get(r12) <= (-65)) goto L12;
        L38:
            return Utf8.access$000(r14, r19);
        L40:
            r20 = (byte) (r10 >> 16);
        L55:
            return partialIsValidUtf8(r11, r12, r13);
        }

        abstract int partialIsValidUtf8Direct(int r10, ByteBuffer r11, int r12, int r13);
    }

    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        private static int partialIsValidUtf8(byte[] r10, int r11, int r12) {
        L2:
            if (r11 >= r12) goto L6;
            if (r10[r11] < 0) goto L6;
            r11 = r11 + 1;
        L6:
            if (r11 < r12) goto L9;
            return 0;
        L9:
            return partialIsValidUtf8NonAscii(r10, r11, r12);
        }

        private static int partialIsValidUtf8NonAscii(byte[] r10, int r11, int r12) {
        L2:
            if (r11 >= r12) goto L3;
            int r13 = r11 + 1;
            byte r14 = r10[r11];
            if (r14 >= 0) goto L46;
            if (r14 < (-32)) goto L9;
            if (r14 < (-16)) goto L19;
            if (r13 >= (r12 - 2)) goto L36;
            int r15 = r13 + 1;
            byte r16 = r10[r13];
            if (r16 > (-65)) goto L45;
            if ((((r14 << 28) + (r16 + 112)) >> 30) != 0) goto L45;
            int r17 = r15 + 1;
            if (r10[r15] > (-65)) goto L45;
            r13 = r17 + 1;
            if (r10[r17] <= (-65)) goto L46;
        L45:
            return -1;
        L36:
            return Utf8.access$1100(r10, r13, r12);
        L19:
            if (r13 >= (r12 - 1)) goto L21;
            int r18 = r13 + 1;
            byte r19 = r10[r13];
            if (r19 > (-65)) goto L32;
            if (r14 != (-32)) goto L28;
            if (r19 < (-96)) goto L32;
        L28:
            if (r14 != (-19)) goto L30;
            if (r19 >= (-96)) goto L32;
        L30:
            r11 = r18 + 1;
            if (r10[r18] <= (-65)) goto L2;
        L32:
            return -1;
        L21:
            return Utf8.access$1100(r10, r13, r12);
        L9:
            if (r13 >= r12) goto L10;
            if (r14 < (-62)) goto L15;
            r11 = r13 + 1;
            if (r10[r13] <= (-65)) goto L2;
        L15:
            return -1;
        L10:
            return r14;
        L46:
            r11 = r13;
            goto L2
        L3:
            return 0;
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8(byte[] r11, int r12, int r13) {
            if (((r12 | r13) | ((r11.length - r12) - r13)) < 0) goto L42;
            int r10 = r12 + r13;
            char[] r14 = new char[r13];
            int r15 = 0;
        L5:
            if (r12 >= r10) goto L10;
            byte r16 = r11[r12];
            if (DecodeUtil.access$400(r16) == false) goto L10;
            r12 = r12 + 1;
            DecodeUtil.access$500(r16, r14, r15);
            r15 = r15 + 1;
        L10:
            int r17 = r15;
        L11:
            if (r12 >= r10) goto L40;
            int r18 = r12 + 1;
            byte r19 = r11[r12];
            if (DecodeUtil.access$400(r19) == true) goto L14;
            if (DecodeUtil.access$600(r19) == true) goto L23;
            if (DecodeUtil.access$800(r19) == true) goto L30;
            if (r18 >= (r10 - 2)) goto L38;
            int r20 = r18 + 1;
            byte r21 = r11[r18];
            int r22 = r20 + 1;
            DecodeUtil.access$1000(r19, r21, r11[r20], r11[r22], r14, r17);
            r12 = r22 + 1;
            r17 = (r17 + 1) + 1;
            goto L11
        L38:
            throw InvalidProtocolBufferException.invalidUtf8();
        L30:
            if (r18 >= (r10 - 1)) goto L33;
            int r23 = r18 + 1;
            DecodeUtil.access$900(r19, r11[r18], r11[r23], r14, r17);
            r12 = r23 + 1;
            r17 = r17 + 1;
            goto L11
        L33:
            throw InvalidProtocolBufferException.invalidUtf8();
        L23:
            if (r18 >= r10) goto L26;
            DecodeUtil.access$700(r19, r11[r18], r14, r17);
            r12 = r18 + 1;
            r17 = r17 + 1;
            goto L11
        L26:
            throw InvalidProtocolBufferException.invalidUtf8();
        L14:
            int r24 = r17 + 1;
            DecodeUtil.access$500(r19, r14, r17);
        L15:
            if (r18 >= r10) goto L20;
            byte r110 = r11[r18];
            if (DecodeUtil.access$400(r110) == false) goto L20;
            r18 = r18 + 1;
            DecodeUtil.access$500(r110, r14, r24);
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

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer r10, int r11, int r12) {
            return decodeUtf8Default(r10, r11, r12);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int encodeUtf8(String r10, byte[] r11, int r12, int r13) {
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

        @Override // com.google.protobuf.Utf8.Processor
        void encodeUtf8Direct(String r10, ByteBuffer r11) {
            encodeUtf8Default(r10, r11);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13) {
            if (r10 == 0) goto L55;
            if (r12 < r13) goto L5;
            return r10;
        L5:
            byte r14 = (byte) r10;
            if (r14 >= (-32)) goto L15;
            if (r14 < (-62)) goto L13;
            int r15 = r12 + 1;
            if (r11[r12] > (-65)) goto L13;
        L12:
            r12 = r15;
        L13:
            return -1;
        L15:
            if (r14 >= (-16)) goto L33;
            byte r16 = (byte) (~(r10 >> 8));
            if (r16 != 0) goto L23;
            int r17 = r12 + 1;
            byte r18 = r11[r12];
            if (r17 >= r13) goto L21;
            r12 = r17;
            r16 = r18;
            goto L23
        L21:
            return Utf8.access$000(r14, r18);
        L23:
            if (r16 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r14 != (-32)) goto L28;
            if (r16 < (-96)) goto L32;
        L28:
            if (r14 != (-19)) goto L30;
            if (r16 >= (-96)) goto L32;
        L30:
            r15 = r12 + 1;
            if (r11[r12] <= (-65)) goto L12;
        L33:
            byte r19 = (byte) (~(r10 >> 8));
            byte r20 = 0;
            if (r19 != 0) goto L40;
            int r21 = r12 + 1;
            r19 = r11[r12];
            if (r21 >= r13) goto L38;
            r12 = r21;
        L41:
            if (r20 != 0) goto L47;
            int r22 = r12 + 1;
            r20 = r11[r12];
            if (r22 >= r13) goto L45;
            r12 = r22;
            goto L47
        L45:
            return Utf8.access$100(r14, r19, r20);
        L47:
            if (r19 <= (-65)) goto L49;
        L53:
            return -1;
        L49:
            if ((((r14 << 28) + (r19 + 112)) >> 30) != 0) goto L53;
            if (r20 > (-65)) goto L53;
            r15 = r12 + 1;
            if (r11[r12] <= (-65)) goto L12;
        L38:
            return Utf8.access$000(r14, r19);
        L40:
            r20 = (byte) (r10 >> 16);
        L55:
            return partialIsValidUtf8(r11, r12, r13);
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int r10, ByteBuffer r11, int r12, int r13) {
            return partialIsValidUtf8Default(r10, r11, r12, r13);
        }
    }

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int r10, int r11) {
            super("Unpaired surrogate at index " + r10 + " of " + r11);
        }
    }

    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            if (UnsafeUtil.hasUnsafeArrayOperations() == true) goto L5;
        L7:
            return false;
        L5:
            if (UnsafeUtil.hasUnsafeByteBufferOperations() == false) goto L7;
            return true;
        }

        private static int partialIsValidUtf8(long r10, int r11) {
            int r12 = unsafeEstimateConsecutiveAscii(r10, r11);
            long r13 = r10 + ((long) r12);
            int r14 = r11 - r12;
        L3:
            byte r15 = 0;
        L5:
            if (r14 <= 0) goto L10;
            long r16 = r13 + 1;
            r15 = UnsafeUtil.getByte(r13);
            if (r15 < 0) goto L9;
            r14 = r14 - 1;
            r13 = r16;
            goto L5
        L9:
            r13 = r16;
        L10:
            if (r14 == 0) goto L11;
            int r17 = r14 - 1;
            if (r15 >= (-32)) goto L24;
            if (r17 == 0) goto L15;
            r14 = r17 - 1;
            if (r15 < (-62)) goto L22;
            long r18 = 1 + r13;
            if (UnsafeUtil.getByte(r13) > (-65)) goto L22;
        L21:
            r13 = r18;
        L22:
            return -1;
        L15:
            return r15;
        L24:
            if (r15 >= (-16)) goto L41;
            if (r17 < 2) goto L28;
            r14 = r17 - 2;
            long r19 = r13 + 1;
            byte r20 = UnsafeUtil.getByte(r13);
            if (r20 > (-65)) goto L39;
            if (r15 != (-32)) goto L35;
            if (r20 < (-96)) goto L39;
        L35:
            if (r15 != (-19)) goto L37;
            if (r20 >= (-96)) goto L39;
        L37:
            r18 = 1 + r19;
            if (UnsafeUtil.getByte(r19) <= (-65)) goto L21;
        L39:
            return -1;
        L28:
            return unsafeIncompleteStateFor(r13, r15, r17);
        L41:
            if (r17 < 3) goto L43;
            r14 = r17 - 3;
            long r21 = r13 + 1;
            byte r22 = UnsafeUtil.getByte(r13);
            if (r22 > (-65)) goto L52;
            if ((((r15 << 28) + (r22 + 112)) >> 30) != 0) goto L52;
            long r23 = r21 + 1;
            if (UnsafeUtil.getByte(r21) > (-65)) goto L52;
            r18 = 1 + r23;
            if (UnsafeUtil.getByte(r23) <= (-65)) goto L21;
        L52:
            return -1;
        L43:
            return unsafeIncompleteStateFor(r13, r15, r17);
        L11:
            return 0;
        }

        private static int partialIsValidUtf8(byte[] r10, long r11, int r12) {
            int r13 = unsafeEstimateConsecutiveAscii(r10, r11, r12);
            int r14 = r12 - r13;
            long r15 = r11 + ((long) r13);
        L3:
            byte r16 = 0;
        L5:
            if (r14 <= 0) goto L10;
            long r17 = r15 + 1;
            r16 = UnsafeUtil.getByte(r10, r15);
            if (r16 < 0) goto L9;
            r14 = r14 - 1;
            r15 = r17;
            goto L5
        L9:
            r15 = r17;
        L10:
            if (r14 == 0) goto L11;
            int r18 = r14 - 1;
            if (r16 >= (-32)) goto L24;
            if (r18 == 0) goto L15;
            r14 = r18 - 1;
            if (r16 < (-62)) goto L22;
            long r19 = 1 + r15;
            if (UnsafeUtil.getByte(r10, r15) > (-65)) goto L22;
        L21:
            r15 = r19;
        L22:
            return -1;
        L15:
            return r16;
        L24:
            if (r16 >= (-16)) goto L41;
            if (r18 < 2) goto L28;
            r14 = r18 - 2;
            long r20 = r15 + 1;
            byte r21 = UnsafeUtil.getByte(r10, r15);
            if (r21 > (-65)) goto L39;
            if (r16 != (-32)) goto L35;
            if (r21 < (-96)) goto L39;
        L35:
            if (r16 != (-19)) goto L37;
            if (r21 >= (-96)) goto L39;
        L37:
            r19 = 1 + r20;
            if (UnsafeUtil.getByte(r10, r20) <= (-65)) goto L21;
        L39:
            return -1;
        L28:
            return unsafeIncompleteStateFor(r10, r16, r15, r18);
        L41:
            if (r18 < 3) goto L43;
            r14 = r18 - 3;
            long r22 = r15 + 1;
            byte r23 = UnsafeUtil.getByte(r10, r15);
            if (r23 > (-65)) goto L52;
            if ((((r16 << 28) + (r23 + 112)) >> 30) != 0) goto L52;
            long r24 = r22 + 1;
            if (UnsafeUtil.getByte(r10, r22) > (-65)) goto L52;
            r19 = 1 + r24;
            if (UnsafeUtil.getByte(r10, r24) <= (-65)) goto L21;
        L52:
            return -1;
        L43:
            return unsafeIncompleteStateFor(r10, r16, r15, r18);
        L11:
            return 0;
        }

        private static int unsafeEstimateConsecutiveAscii(long r10, int r11) {
            if (r11 >= 16) goto L6;
            return 0;
        L6:
            int r12 = (int) ((-r10) & 7);
            int r13 = r12;
        L7:
            if (r13 <= 0) goto L13;
            long r14 = 1 + r10;
            if (UnsafeUtil.getByte(r10) < 0) goto L11;
            r13 = r13 - 1;
            r10 = r14;
            goto L7
        L11:
            return r12 - r13;
        L13:
            int r15 = r11 - r12;
        L15:
            if (r15 < 8) goto L20;
            if ((UnsafeUtil.getLong(r10) & Utf8.ASCII_MASK_LONG) != 0) goto L20;
            r10 = r10 + 8;
            r15 = r15 - 8;
        L20:
            return r11 - r15;
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] r10, long r11, int r12) {
            int r13 = 0;
            if (r12 >= 16) goto L5;
            return 0;
        L5:
            int r14 = 8 - (((int) r11) & 7);
        L7:
            if (r13 >= r14) goto L12;
            long r15 = 1 + r11;
            if (UnsafeUtil.getByte(r10, r11) < 0) goto L10;
            r13 = r13 + 1;
            r11 = r15;
            goto L7
        L10:
            return r13;
        L12:
            int r16 = r13 + 8;
            if (r16 > r12) goto L18;
            if ((UnsafeUtil.getLong(r10, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + r11) & Utf8.ASCII_MASK_LONG) != 0) goto L18;
            r11 = r11 + 8;
            r13 = r16;
        L18:
            if (r13 >= r12) goto L23;
            long r17 = r11 + 1;
            if (UnsafeUtil.getByte(r10, r11) < 0) goto L21;
            r13 = r13 + 1;
            r11 = r17;
            goto L18
        L21:
            return r13;
        L23:
            return r12;
        }

        private static int unsafeIncompleteStateFor(long r10, int r11, int r12) {
            if (r12 == 0) goto L14;
            if (r12 == 1) goto L12;
            if (r12 != 2) goto L10;
            return Utf8.access$100(r11, UnsafeUtil.getByte(r10), UnsafeUtil.getByte(r10 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.access$000(r11, UnsafeUtil.getByte(r10));
        L14:
            return Utf8.access$1200(r11);
        }

        private static int unsafeIncompleteStateFor(byte[] r10, int r11, long r12, int r13) {
            if (r13 == 0) goto L14;
            if (r13 == 1) goto L12;
            if (r13 != 2) goto L10;
            return Utf8.access$100(r11, UnsafeUtil.getByte(r10, r12), UnsafeUtil.getByte(r10, r12 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.access$000(r11, UnsafeUtil.getByte(r10, r12));
        L14:
            return Utf8.access$1200(r11);
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8(byte[] r10, int r11, int r12) {
            Charset r13 = Internal.UTF_8;
            String r14 = new String(r10, r11, r12, r13);
            if (r14.indexOf(65533) >= 0) goto L6;
            return r14;
        L6:
            if (Arrays.equals(r14.getBytes(r13), Arrays.copyOfRange(r10, r11, r12 + r11)) == false) goto L9;
            return r14;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.google.protobuf.Utf8.Processor
        String decodeUtf8Direct(ByteBuffer r18, int r19, int r20) {
            if (((r19 | r20) | ((r18.limit() - r19) - r20)) < 0) goto L46;
            long r10 = UnsafeUtil.addressOffset(r18) + ((long) r19);
            long r11 = ((long) r20) + r10;
            char[] r12 = new char[r20];
            int r13 = 0;
        L6:
            if (r10 >= r11) goto L11;
            byte r14 = UnsafeUtil.getByte(r10);
            if (DecodeUtil.access$400(r14) == false) goto L11;
            r10 = r10 + 1;
            DecodeUtil.access$500(r14, r12, r13);
            r13 = r13 + 1;
        L11:
            int r15 = r13;
        L13:
            if (r10 >= r11) goto L44;
            long r16 = r10 + 1;
            byte r17 = UnsafeUtil.getByte(r10);
            if (DecodeUtil.access$400(r17) == true) goto L16;
            if (DecodeUtil.access$600(r17) == true) goto L27;
            if (DecodeUtil.access$800(r17) == false) goto L39;
            if (r16 >= (r11 - 1)) goto L37;
            long r21 = r16 + 1;
            DecodeUtil.access$900(r17, UnsafeUtil.getByte(r16), UnsafeUtil.getByte(r21), r12, r15);
            r15 = r15 + 1;
            r10 = r21 + 1;
            goto L13
        L37:
            throw InvalidProtocolBufferException.invalidUtf8();
        L39:
            if (r16 >= (r11 - 2)) goto L42;
            long r22 = r16 + 1;
            byte r110 = UnsafeUtil.getByte(r16);
            long r23 = r22 + 1;
            byte r111 = UnsafeUtil.getByte(r22);
            r10 = r23 + 1;
            DecodeUtil.access$1000(r17, r110, r111, UnsafeUtil.getByte(r23), r12, r15);
            r13 = (r15 + 1) + 1;
            goto L11
        L42:
            throw InvalidProtocolBufferException.invalidUtf8();
        L27:
            if (r16 >= r11) goto L30;
            r10 = r16 + 1;
            DecodeUtil.access$700(r17, UnsafeUtil.getByte(r16), r12, r15);
            r15 = r15 + 1;
            goto L13
        L30:
            throw InvalidProtocolBufferException.invalidUtf8();
        L16:
            int r24 = r15 + 1;
            DecodeUtil.access$500(r17, r12, r15);
        L18:
            if (r16 >= r11) goto L23;
            byte r25 = UnsafeUtil.getByte(r16);
            if (DecodeUtil.access$400(r25) == false) goto L23;
            r16 = r16 + 1;
            DecodeUtil.access$500(r25, r12, r24);
            r24 = r24 + 1;
        L23:
            r15 = r24;
            r10 = r16;
            goto L13
        L44:
            return new String(r12, 0, r15);
        L46:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r18.limit()), Integer.valueOf(r19), Integer.valueOf(r20)}));
        }

        @Override // com.google.protobuf.Utf8.Processor
        int encodeUtf8(String r21, byte[] r22, int r23, int r24) {
            long r10 = r23;
            long r11 = ((long) r24) + r10;
            int r12 = r21.length();
            if (r12 > r24) goto L56;
            if ((r22.length - r24) < r23) goto L56;
            int r13 = 0;
        L7:
            char r14 = 128;
            long r15 = 1;
            if (r13 >= r12) goto L12;
            char r16 = r21.charAt(r13);
            if (r16 >= 128) goto L12;
            UnsafeUtil.putByte(r22, r10, (byte) r16);
            r13 = r13 + 1;
            r10 = 1 + r10;
        L12:
            if (r13 == r12) goto L14;
        L15:
            if (r13 >= r12) goto L54;
            char r17 = r21.charAt(r13);
            if (r17 >= r14) goto L22;
            if (r10 >= r11) goto L22;
            long r18 = r10 + r15;
            UnsafeUtil.putByte(r22, r10, (byte) r17);
            long r19 = r15;
            long r110 = r18;
            char r111 = r14;
        L39:
            r13 = r13 + 1;
            r14 = r111;
            long r112 = r19;
            r10 = r110;
            r15 = r112;
        L22:
            if (r17 >= 2048) goto L27;
            if (r10 > (r11 - 2)) goto L27;
            long r113 = r10 + r15;
            UnsafeUtil.putByte(r22, r10, (byte) ((r17 >>> 6) | 960));
            long r20 = r113 + r15;
            UnsafeUtil.putByte(r22, r113, (byte) ((r17 & '?') | 128));
            long r114 = r15;
            r111 = 128;
            r110 = r20;
            r19 = r114;
        L27:
            if (r17 < 55296) goto L30;
            if (57343 < r17) goto L30;
        L33:
            if (r10 > (r11 - 4)) goto L43;
            int r25 = r13 + 1;
            if (r25 == r12) goto L42;
            char r26 = r21.charAt(r25);
            if (Character.isSurrogatePair(r17, r26) == false) goto L40;
            int r27 = Character.toCodePoint(r17, r26);
            long r115 = r10 + 1;
            UnsafeUtil.putByte(r22, r10, (byte) ((r27 >>> 18) | 240));
            long r28 = r115 + 1;
            r111 = 128;
            UnsafeUtil.putByte(r22, r115, (byte) (((r27 >>> 12) & 63) | 128));
            long r116 = r28 + 1;
            UnsafeUtil.putByte(r22, r28, (byte) (((r27 >>> 6) & 63) | 128));
            r19 = 1;
            r110 = r116 + 1;
            UnsafeUtil.putByte(r22, r116, (byte) ((r27 & 63) | 128));
            r13 = r25;
            goto L39
        L40:
            r13 = r25;
        L42:
            throw new UnpairedSurrogateException(r13 - 1, r12);
        L43:
            if (55296 > r17) goto L52;
            if (r17 > 57343) goto L52;
            int r29 = r13 + 1;
            if (r29 == r12) goto L50;
            if (Character.isSurrogatePair(r17, r21.charAt(r29)) == true) goto L52;
        L50:
            throw new UnpairedSurrogateException(r13, r12);
        L52:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r17 + " at index " + r10);
        L30:
            if (r10 > (r11 - 3)) goto L33;
            long r117 = r10 + r15;
            UnsafeUtil.putByte(r22, r10, (byte) ((r17 >>> '\f') | 480));
            long r30 = r117 + r15;
            UnsafeUtil.putByte(r22, r117, (byte) (((r17 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(r22, r30, (byte) ((r17 & '?') | 128));
            r110 = r30 + 1;
            r19 = 1;
            r111 = 128;
            goto L39
        L54:
            return (int) r10;
        L14:
            return (int) r10;
        L56:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r21.charAt(r12 - 1) + " at index " + (r23 + r24));
        }

        @Override // com.google.protobuf.Utf8.Processor
        void encodeUtf8Direct(String r21, ByteBuffer r22) {
            long r10 = UnsafeUtil.addressOffset(r22);
            long r11 = ((long) r22.position()) + r10;
            long r12 = ((long) r22.limit()) + r10;
            int r13 = r21.length();
            if (r13 > (r12 - r11)) goto L55;
            int r14 = 0;
        L5:
            char r15 = 128;
            if (r14 >= r13) goto L10;
            char r16 = r21.charAt(r14);
            if (r16 >= 128) goto L10;
            UnsafeUtil.putByte(r11, (byte) r16);
            r14 = r14 + 1;
            r11 = r11 + 1;
        L10:
            if (r14 != r13) goto L14;
            int r17 = (int) (r11 - r10);
        L12:
            Java8Compatibility.position(r22, r17);
            return;
        L14:
            if (r14 >= r13) goto L53;
            char r18 = r21.charAt(r14);
            if (r18 >= r15) goto L21;
            if (r11 >= r12) goto L21;
            UnsafeUtil.putByte(r11, (byte) r18);
            int r19 = r14;
            char r20 = r15;
            r11 = r11 + 1;
            long r110 = r10;
        L39:
            r15 = r20;
            r10 = r110;
            r12 = r12;
            r14 = r19 + 1;
        L21:
            if (r18 < 2048) goto L23;
        L26:
            r110 = r10;
            if (r18 < 55296) goto L30;
            if (57343 < r18) goto L30;
        L33:
            if (r11 > (r12 - 4)) goto L43;
            r19 = r14 + 1;
            if (r19 == r13) goto L42;
            char r23 = r21.charAt(r19);
            if (Character.isSurrogatePair(r18, r23) == false) goto L40;
            int r24 = Character.toCodePoint(r18, r23);
            long r25 = r11 + 1;
            UnsafeUtil.putByte(r11, (byte) ((r24 >>> 18) | 240));
            long r26 = r25 + 1;
            r20 = 128;
            UnsafeUtil.putByte(r25, (byte) (((r24 >>> 12) & 63) | 128));
            long r27 = r26 + 1;
            UnsafeUtil.putByte(r26, (byte) (((r24 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(r27, (byte) ((r24 & 63) | 128));
            r11 = r27 + 1;
            goto L39
        L40:
            r14 = r19;
        L42:
            throw new UnpairedSurrogateException(r14 - 1, r13);
        L43:
            if (55296 > r18) goto L52;
            if (r18 > 57343) goto L52;
            int r28 = r14 + 1;
            if (r28 == r13) goto L50;
            if (Character.isSurrogatePair(r18, r21.charAt(r28)) == true) goto L52;
        L50:
            throw new UnpairedSurrogateException(r14, r13);
        L52:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r18 + " at index " + r11);
        L30:
            if (r11 > (r12 - 3)) goto L33;
            long r29 = r11 + 1;
            UnsafeUtil.putByte(r11, (byte) ((r18 >>> '\f') | 480));
            long r30 = r29 + 1;
            UnsafeUtil.putByte(r29, (byte) (((r18 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(r30, (byte) ((r18 & '?') | 128));
            r11 = r30 + 1;
        L25:
            r19 = r14;
            r20 = 128;
            goto L39
        L23:
            if (r11 > (r12 - 2)) goto L26;
            r110 = r10;
            long r31 = r11 + 1;
            UnsafeUtil.putByte(r11, (byte) ((r18 >>> 6) | 960));
            UnsafeUtil.putByte(r31, (byte) ((r18 & '?') | 128));
            r11 = r31 + 1;
            goto L25
        L53:
            r17 = (int) (r11 - r10);
            goto L12
        L55:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r21.charAt(r13 - 1) + " at index " + r22.limit());
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8(int r11, byte[] r12, int r13, int r14) {
            byte r10 = 0;
            if (((r13 | r14) | (r12.length - r14)) < 0) goto L63;
            long r15 = r13;
            long r16 = r14;
            if (r11 == 0) goto L61;
            if (r15 < r16) goto L9;
            return r11;
        L9:
            byte r17 = (byte) r11;
            if (r17 >= (-32)) goto L19;
            if (r17 < (-62)) goto L17;
            long r18 = 1 + r15;
            if (UnsafeUtil.getByte(r12, r15) > (-65)) goto L17;
            r15 = r18;
        L17:
            return -1;
        L19:
            if (r17 >= (-16)) goto L39;
            byte r19 = (byte) (~(r11 >> 8));
            if (r19 != 0) goto L27;
            long r20 = r15 + 1;
            r19 = UnsafeUtil.getByte(r12, r15);
            if (r20 >= r16) goto L25;
            r15 = r20;
            goto L27
        L25:
            return Utf8.access$000(r17, r19);
        L27:
            if (r19 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r17 != (-32)) goto L32;
            if (r19 < (-96)) goto L38;
        L32:
            if (r17 != (-19)) goto L34;
            if (r19 >= (-96)) goto L38;
        L34:
            long r110 = r15 + 1;
            if (UnsafeUtil.getByte(r12, r15) > (-65)) goto L38;
        L37:
            r15 = r110;
            goto L61
        L39:
            byte r21 = (byte) (~(r11 >> 8));
            if (r21 != 0) goto L46;
            long r22 = r15 + 1;
            r21 = UnsafeUtil.getByte(r12, r15);
            if (r22 >= r16) goto L44;
            r15 = r22;
        L47:
            if (r10 != 0) goto L53;
            long r23 = r15 + 1;
            r10 = UnsafeUtil.getByte(r12, r15);
            if (r23 >= r16) goto L51;
            r15 = r23;
            goto L53
        L51:
            return Utf8.access$100(r17, r21, r10);
        L53:
            if (r21 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r17 << 28) + (r21 + 112)) >> 30) != 0) goto L59;
            if (r10 > (-65)) goto L59;
            r110 = r15 + 1;
            if (UnsafeUtil.getByte(r12, r15) <= (-65)) goto L37;
        L44:
            return Utf8.access$000(r17, r21);
        L46:
            r10 = (byte) (r11 >> 16);
        L61:
            return partialIsValidUtf8(r12, r15, (int) (r16 - r15));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r12.length), Integer.valueOf(r13), Integer.valueOf(r14)}));
        }

        @Override // com.google.protobuf.Utf8.Processor
        int partialIsValidUtf8Direct(int r10, ByteBuffer r11, int r12, int r13) {
            byte r14 = 0;
            if (((r12 | r13) | (r11.limit() - r13)) < 0) goto L63;
            long r15 = UnsafeUtil.addressOffset(r11) + ((long) r12);
            long r16 = ((long) (r13 - r12)) + r15;
            if (r10 == 0) goto L61;
            if (r15 < r16) goto L9;
            return r10;
        L9:
            byte r17 = (byte) r10;
            if (r17 >= (-32)) goto L19;
            if (r17 < (-62)) goto L17;
            long r18 = 1 + r15;
            if (UnsafeUtil.getByte(r15) > (-65)) goto L17;
            r15 = r18;
        L17:
            return -1;
        L19:
            if (r17 >= (-16)) goto L39;
            byte r19 = (byte) (~(r10 >> 8));
            if (r19 != 0) goto L27;
            long r20 = r15 + 1;
            r19 = UnsafeUtil.getByte(r15);
            if (r20 >= r16) goto L25;
            r15 = r20;
            goto L27
        L25:
            return Utf8.access$000(r17, r19);
        L27:
            if (r19 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r17 != (-32)) goto L32;
            if (r19 < (-96)) goto L38;
        L32:
            if (r17 != (-19)) goto L34;
            if (r19 >= (-96)) goto L38;
        L34:
            long r21 = r15 + 1;
            if (UnsafeUtil.getByte(r15) > (-65)) goto L38;
        L37:
            r15 = r21;
            goto L61
        L39:
            byte r110 = (byte) (~(r10 >> 8));
            if (r110 != 0) goto L46;
            long r22 = r15 + 1;
            r110 = UnsafeUtil.getByte(r15);
            if (r22 >= r16) goto L44;
            r15 = r22;
        L47:
            if (r14 != 0) goto L53;
            long r23 = r15 + 1;
            r14 = UnsafeUtil.getByte(r15);
            if (r23 >= r16) goto L51;
            r15 = r23;
            goto L53
        L51:
            return Utf8.access$100(r17, r110, r14);
        L53:
            if (r110 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r17 << 28) + (r110 + 112)) >> 30) != 0) goto L59;
            if (r14 > (-65)) goto L59;
            r21 = r15 + 1;
            if (UnsafeUtil.getByte(r15) <= (-65)) goto L37;
        L44:
            return Utf8.access$000(r17, r110);
        L46:
            r14 = (byte) (r10 >> 16);
        L61:
            return partialIsValidUtf8(r15, (int) (r16 - r15));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r11.limit()), Integer.valueOf(r12), Integer.valueOf(r13)}));
        }
    }

    static {
        if (UnsafeProcessor.isAvailable() == true) goto L5;
    L7:
        Processor r10 = new SafeProcessor();
    L8:
        processor = r10;
        return;
    L5:
        if (Android.isOnAndroidDevice() == true) goto L7;
        r10 = new UnsafeProcessor();
        goto L8
    }

    private Utf8() {
    }

    static /* synthetic */ int access$000(int r10, int r11) {
        return incompleteStateFor(r10, r11);
    }

    static /* synthetic */ int access$100(int r10, int r11, int r12) {
        return incompleteStateFor(r10, r11, r12);
    }

    static /* synthetic */ int access$1100(byte[] r10, int r11, int r12) {
        return incompleteStateFor(r10, r11, r12);
    }

    static /* synthetic */ int access$1200(int r10) {
        return incompleteStateFor(r10);
    }

    static /* synthetic */ int access$200(ByteBuffer r10, int r11, int r12) {
        return estimateConsecutiveAscii(r10, r11, r12);
    }

    static /* synthetic */ int access$300(ByteBuffer r10, int r11, int r12, int r13) {
        return incompleteStateFor(r10, r11, r12, r13);
    }

    static String decodeUtf8(ByteBuffer r10, int r11, int r12) {
        return processor.decodeUtf8(r10, r11, r12);
    }

    static String decodeUtf8(byte[] r10, int r11, int r12) {
        return processor.decodeUtf8(r10, r11, r12);
    }

    static int encode(String r10, byte[] r11, int r12, int r13) {
        return processor.encodeUtf8(r10, r11, r12, r13);
    }

    static void encodeUtf8(String r10, ByteBuffer r11) {
        processor.encodeUtf8(r10, r11);
    }

    static int encodedLength(String r10) {
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

    private static int encodedLengthGeneral(String r10, int r11) {
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

    private static int estimateConsecutiveAscii(ByteBuffer r10, int r11, int r12) {
        int r13 = r12 - 7;
        int r14 = r11;
    L3:
        if (r14 >= r13) goto L8;
        if ((r10.getLong(r14) & ASCII_MASK_LONG) != 0) goto L8;
        r14 = r14 + 8;
    L8:
        return r14 - r11;
    }

    private static int incompleteStateFor(int r10) {
        if (r10 <= (-12)) goto L6;
        return -1;
    L6:
        return r10;
    }

    private static int incompleteStateFor(int r10, int r11) {
        if (r10 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (r11 > (-65)) goto L8;
        return r10 ^ (r11 << 8);
    }

    private static int incompleteStateFor(int r10, int r11, int r12) {
        if (r10 <= (-12)) goto L5;
    L9:
        return -1;
    L5:
        if (r11 > (-65)) goto L9;
        if (r12 > (-65)) goto L9;
        return (r10 ^ (r11 << 8)) ^ (r12 << 16);
    }

    private static int incompleteStateFor(ByteBuffer r10, int r11, int r12, int r13) {
        if (r13 == 0) goto L14;
        if (r13 == 1) goto L12;
        if (r13 != 2) goto L10;
        return incompleteStateFor(r11, r10.get(r12), r10.get(r12 + 1));
    L10:
        throw new AssertionError();
    L12:
        return incompleteStateFor(r11, r10.get(r12));
    L14:
        return incompleteStateFor(r11);
    }

    private static int incompleteStateFor(byte[] r10, int r11, int r12) {
        byte r13 = r10[r11 - 1];
        int r14 = r12 - r11;
        if (r14 == 0) goto L15;
        if (r14 == 1) goto L13;
        if (r14 != 2) goto L11;
        return incompleteStateFor(r13, r10[r11], r10[r11 + 1]);
    L11:
        throw new AssertionError();
    L13:
        return incompleteStateFor(r13, r10[r11]);
    L15:
        return incompleteStateFor(r13);
    }

    static boolean isValidUtf8(ByteBuffer r10) {
        return processor.isValidUtf8(r10, r10.position(), r10.remaining());
    }

    static boolean isValidUtf8(byte[] r10) {
        return processor.isValidUtf8(r10, 0, r10.length);
    }

    static boolean isValidUtf8(byte[] r10, int r11, int r12) {
        return processor.isValidUtf8(r10, r11, r12);
    }

    static int partialIsValidUtf8(int r10, ByteBuffer r11, int r12, int r13) {
        return processor.partialIsValidUtf8(r10, r11, r12, r13);
    }

    static int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13) {
        return processor.partialIsValidUtf8(r10, r11, r12, r13);
    }
}
