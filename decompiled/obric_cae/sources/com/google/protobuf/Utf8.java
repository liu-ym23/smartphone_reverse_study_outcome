package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    static final int COMPLETE = 0;
    static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor = null;

    public static class DecodeUtil {
        private DecodeUtil() {
        }

        public static /* synthetic */ void access$1000(byte r8, byte r10, byte r11, byte r12, char[] r13, int r14) {
            handleFourBytes(r8, r10, r11, r12, r13, r14);
        }

        public static /* synthetic */ boolean access$400(byte r8) {
            return isOneByte(r8);
        }

        public static /* synthetic */ void access$500(byte r8, char[] r10, int r11) {
            handleOneByte(r8, r10, r11);
        }

        public static /* synthetic */ boolean access$600(byte r8) {
            return isTwoBytes(r8);
        }

        public static /* synthetic */ void access$700(byte r8, byte r10, char[] r11, int r12) {
            handleTwoBytes(r8, r10, r11, r12);
        }

        public static /* synthetic */ boolean access$800(byte r8) {
            return isThreeBytes(r8);
        }

        public static /* synthetic */ void access$900(byte r8, byte r10, byte r11, char[] r12, int r13) {
            handleThreeBytes(r8, r10, r11, r12, r13);
        }

        private static void handleFourBytes(byte r8, byte r10, byte r11, byte r12, char[] r13, int r14) {
            if (isNotTrailingByte(r10) == true) goto L13;
            int r15 = r10 + 112;
            if (((r15 + (r8 << 28)) >> 30) != 0) goto L13;
            if (isNotTrailingByte(r11) == true) goto L13;
            if (isNotTrailingByte(r12) == true) goto L13;
            int r16 = ((((r8 & 7) << 18) | (trailingByteValue(r10) << 12)) | (trailingByteValue(r11) << 6)) | trailingByteValue(r12);
            r13[r14] = highSurrogate(r16);
            r13[r14 + 1] = lowSurrogate(r16);
            return;
        L13:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void handleOneByte(byte r8, char[] r10, int r11) {
            r10[r11] = (char) r8;
        }

        private static void handleThreeBytes(byte r8, byte r10, byte r11, char[] r12, int r13) {
            if (isNotTrailingByte(r10) == true) goto L15;
            if (r8 != (-32)) goto L8;
            if (r10 < (-96)) goto L15;
        L8:
            if (r8 != (-19)) goto L11;
            if (r10 >= (-96)) goto L15;
        L11:
            if (isNotTrailingByte(r11) == true) goto L15;
            r12[r13] = (char) ((((r8 & 15) << 12) | (trailingByteValue(r10) << 6)) | trailingByteValue(r11));
            return;
        L15:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void handleTwoBytes(byte r8, byte r10, char[] r11, int r12) {
            if (r8 < (-62)) goto L9;
            if (isNotTrailingByte(r10) == true) goto L9;
            r11[r12] = (char) (((r8 & 31) << 6) | trailingByteValue(r10));
            return;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static char highSurrogate(int r8) {
            return (char) ((r8 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte r8) {
            if (r8 <= (-65)) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isOneByte(byte r8) {
            if (r8 < 0) goto L4;
            return true;
        L4:
            return false;
        }

        private static boolean isThreeBytes(byte r8) {
            if (r8 >= (-16)) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean isTwoBytes(byte r8) {
            if (r8 >= (-32)) goto L5;
            return true;
        L5:
            return false;
        }

        private static char lowSurrogate(int r8) {
            return (char) ((r8 & 1023) + 56320);
        }

        private static int trailingByteValue(byte r8) {
            return r8 & 63;
        }
    }

    public static abstract class Processor {
        public Processor() {
        }

        public final String decodeUtf8(ByteBuffer r8, int r10, int r11) {
            if (r8.hasArray() == false) goto L7;
            int r12 = r8.arrayOffset();
            return decodeUtf8(r8.array(), r12 + r10, r11);
        L7:
            if (r8.isDirect() == false) goto L11;
            return decodeUtf8Direct(r8, r10, r11);
        L11:
            return decodeUtf8Default(r8, r10, r11);
        }

        public abstract String decodeUtf8(byte[] r8, int r10, int r11);

        public final String decodeUtf8Default(ByteBuffer r10, int r11, int r12) {
            if (((r11 | r12) | ((r10.limit() - r11) - r12)) < 0) goto L42;
            int r13 = r11 + r12;
            char[] r14 = new char[r12];
            int r8 = 0;
        L5:
            if (r11 >= r13) goto L10;
            byte r15 = r10.get(r11);
            if (DecodeUtil.access$400(r15) == false) goto L10;
            r11 = r11 + 1;
            DecodeUtil.access$500(r15, r14, r8);
            r8 = r8 + 1;
        L10:
            int r16 = r8;
        L11:
            if (r11 >= r13) goto L40;
            int r17 = r11 + 1;
            byte r18 = r10.get(r11);
            if (DecodeUtil.access$400(r18) == true) goto L14;
            if (DecodeUtil.access$600(r18) == true) goto L23;
            if (DecodeUtil.access$800(r18) == true) goto L30;
            if (r17 >= (r13 - 2)) goto L38;
            int r19 = r17 + 1;
            byte r20 = r10.get(r17);
            int r21 = r19 + 1;
            DecodeUtil.access$1000(r18, r20, r10.get(r19), r10.get(r21), r14, r16);
            r11 = r21 + 1;
            r16 = (r16 + 1) + 1;
            goto L11
        L38:
            throw InvalidProtocolBufferException.invalidUtf8();
        L30:
            if (r17 >= (r13 - 1)) goto L33;
            int r22 = r17 + 1;
            DecodeUtil.access$900(r18, r10.get(r17), r10.get(r22), r14, r16);
            r11 = r22 + 1;
            r16 = r16 + 1;
            goto L11
        L33:
            throw InvalidProtocolBufferException.invalidUtf8();
        L23:
            if (r17 >= r13) goto L26;
            DecodeUtil.access$700(r18, r10.get(r17), r14, r16);
            r11 = r17 + 1;
            r16 = r16 + 1;
            goto L11
        L26:
            throw InvalidProtocolBufferException.invalidUtf8();
        L14:
            int r23 = r16 + 1;
            DecodeUtil.access$500(r18, r14, r16);
        L15:
            if (r17 >= r13) goto L20;
            byte r110 = r10.get(r17);
            if (DecodeUtil.access$400(r110) == false) goto L20;
            r17 = r17 + 1;
            DecodeUtil.access$500(r110, r14, r23);
            r23 = r23 + 1;
        L20:
            r11 = r17;
            r16 = r23;
            goto L11
        L40:
            return new String(r14, 0, r16);
        L42:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r10.limit()), Integer.valueOf(r11), Integer.valueOf(r12)}));
        }

        public abstract String decodeUtf8Direct(ByteBuffer r8, int r10, int r11);

        public abstract int encodeUtf8(String r8, byte[] r10, int r11, int r12);

        public final void encodeUtf8(String r8, ByteBuffer r10) {
            if (r10.hasArray() == false) goto L6;
            int r11 = r10.arrayOffset();
            Java8Compatibility.position(r10, Utf8.encode(r8, r10.array(), r10.position() + r11, r10.remaining()) - r11);
            return;
        L6:
            if (r10.isDirect() == false) goto L8;
            encodeUtf8Direct(r8, r10);
            return;
        L8:
            encodeUtf8Default(r8, r10);
        }

        public final void encodeUtf8Default(String r8, ByteBuffer r10) {
            int r11 = r8.length();
            int r12 = r10.position();
            int r13 = 0;
        L4:
            if (r13 >= r11) goto L8;
            char r14 = r8.charAt(r13);     // Catch: IndexOutOfBoundsException -> L36
            if (r14 >= 128) goto L8;
            r10.put(r12 + r13, (byte) r14);     // Catch: IndexOutOfBoundsException -> L36
            r13 = r13 + 1;     // Catch: IndexOutOfBoundsException -> L36
            goto L4
        L37:
            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
        L8:
            if (r13 != r11) goto L11;
            Java8Compatibility.position(r10, r12 + r13);     // Catch: IndexOutOfBoundsException -> L36
            return;
        L11:
            int r15 = r12 + r13;     // Catch: IndexOutOfBoundsException -> L36
        L12:
            if (r13 >= r11) goto L34;
            char r16 = r8.charAt(r13);     // Catch: IndexOutOfBoundsException -> L36
            if (r16 >= 128) goto L17;
            r10.put(r15, (byte) r16);     // Catch: IndexOutOfBoundsException -> L36
        L33:
            r13 = r13 + 1;     // Catch: IndexOutOfBoundsException -> L36
            r15 = r15 + 1;     // Catch: IndexOutOfBoundsException -> L36
            goto L12
        L17:
            if (r16 >= 2048) goto L20;
            int r17 = r15 + 1;     // Catch: IndexOutOfBoundsException -> L36
            r10.put(r15, (byte) ((r16 >>> 6) | 192));     // Catch: IndexOutOfBoundsException -> L36
            r10.put(r17, (byte) ((r16 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L36
            r15 = r17;
            goto L33
        L20:
            if (r16 >= 55296) goto L22;
        L32:
            int r18 = r15 + 1;     // Catch: IndexOutOfBoundsException -> L36
            r10.put(r15, (byte) ((r16 >>> '\f') | 224));     // Catch: IndexOutOfBoundsException -> L36
            r15 = r18 + 1;     // Catch: IndexOutOfBoundsException -> L36
            r10.put(r18, (byte) (((r16 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L36
            r10.put(r15, (byte) ((r16 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L36
            goto L33
        L22:
            if (57343 < r16) goto L32;
            int r19 = r13 + 1;     // Catch: IndexOutOfBoundsException -> L36
            if (r19 == r11) goto L31;
            char r20 = r8.charAt(r19);     // Catch: IndexOutOfBoundsException -> L36
            if (Character.isSurrogatePair(r16, r20) == false) goto L29;
            int r21 = Character.toCodePoint(r16, r20);     // Catch: IndexOutOfBoundsException -> L36
            int r22 = r15 + 1;     // Catch: IndexOutOfBoundsException -> L36
            r10.put(r15, (byte) ((r21 >>> 18) | 240));     // Catch: IndexOutOfBoundsException -> L36
            int r23 = r22 + 1;     // Catch: IndexOutOfBoundsException -> L36
            r10.put(r22, (byte) (((r21 >>> 12) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L36
            int r24 = r23 + 1;     // Catch: IndexOutOfBoundsException -> L36
            r10.put(r23, (byte) (((r21 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L36
            r10.put(r24, (byte) ((r21 & 63) | 128));     // Catch: IndexOutOfBoundsException -> L36
            r15 = r24;
            r13 = r19;
            goto L33
        L29:
            r13 = r19;
        L31:
            throw new UnpairedSurrogateException(r13, r11);     // Catch: IndexOutOfBoundsException -> L36
        L34:
            Java8Compatibility.position(r10, r15);     // Catch: IndexOutOfBoundsException -> L36
        }

        public abstract void encodeUtf8Direct(String r8, ByteBuffer r10);

        public final boolean isValidUtf8(ByteBuffer r8, int r10, int r11) {
            if (partialIsValidUtf8(0, r8, r10, r11) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        public final int partialIsValidUtf8(int r8, ByteBuffer r10, int r11, int r12) {
            if (r10.hasArray() == false) goto L7;
            int r13 = r10.arrayOffset();
            return partialIsValidUtf8(r8, r10.array(), r11 + r13, r13 + r12);
        L7:
            if (r10.isDirect() == false) goto L11;
            return partialIsValidUtf8Direct(r8, r10, r11, r12);
        L11:
            return partialIsValidUtf8Default(r8, r10, r11, r12);
        }

        public abstract int partialIsValidUtf8(int r8, byte[] r10, int r11, int r12);

        public final int partialIsValidUtf8Default(int r8, ByteBuffer r10, int r11, int r12) {
            if (r8 == 0) goto L55;
            if (r11 < r12) goto L5;
            return r8;
        L5:
            byte r13 = (byte) r8;
            if (r13 >= (-32)) goto L15;
            if (r13 < (-62)) goto L13;
            int r14 = r11 + 1;
            if (r10.get(r11) > (-65)) goto L13;
        L12:
            r11 = r14;
        L13:
            return -1;
        L15:
            if (r13 >= (-16)) goto L33;
            byte r15 = (byte) (~(r8 >> 8));
            if (r15 != 0) goto L23;
            int r16 = r11 + 1;
            byte r17 = r10.get(r11);
            if (r16 >= r12) goto L21;
            r11 = r16;
            r15 = r17;
            goto L23
        L21:
            return Utf8.access$000(r13, r17);
        L23:
            if (r15 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r13 != (-32)) goto L28;
            if (r15 < (-96)) goto L32;
        L28:
            if (r13 != (-19)) goto L30;
            if (r15 >= (-96)) goto L32;
        L30:
            r14 = r11 + 1;
            if (r10.get(r11) <= (-65)) goto L12;
        L33:
            byte r18 = (byte) (~(r8 >> 8));
            if (r18 != 0) goto L40;
            int r19 = r11 + 1;
            r18 = r10.get(r11);
            if (r19 >= r12) goto L38;
            byte r20 = 0;
        L41:
            if (r20 != 0) goto L47;
            int r21 = r19 + 1;
            byte r22 = r10.get(r19);
            if (r21 >= r12) goto L45;
            r20 = r22;
            r19 = r21;
            goto L47
        L45:
            return Utf8.access$100(r13, r18, r22);
        L47:
            if (r18 > (-65)) goto L53;
            int r23 = r18 + 112;
            if (((r23 + (r13 << 28)) >> 30) != 0) goto L53;
            if (r20 > (-65)) goto L53;
            r11 = r19 + 1;
            if (r10.get(r19) <= (-65)) goto L55;
        L53:
            return -1;
        L38:
            return Utf8.access$000(r13, r18);
        L40:
            r20 = (byte) (r8 >> 16);
            r19 = r11;
        L55:
            return partialIsValidUtf8(r10, r11, r12);
        }

        public abstract int partialIsValidUtf8Direct(int r8, ByteBuffer r10, int r11, int r12);

        private static int partialIsValidUtf8(ByteBuffer r8, int r10, int r11) {
            int r12 = r10 + Utf8.access$200(r8, r10, r11);
        L3:
            if (r12 >= r11) goto L4;
            int r13 = r12 + 1;
            byte r14 = r8.get(r12);
            if (r14 >= 0) goto L50;
            if (r14 < (-32)) goto L10;
            if (r14 < (-16)) goto L22;
            if (r13 >= (r11 - 2)) goto L24;
            int r15 = r13 + 1;
            byte r16 = r8.get(r13);
            if (r16 > (-65)) goto L49;
            if ((((r16 + 112) + (r14 << 28)) >> 30) != 0) goto L49;
            int r17 = r15 + 1;
            if (r8.get(r15) > (-65)) goto L49;
            r13 = r17 + 1;
            if (r8.get(r17) <= (-65)) goto L50;
        L49:
            return -1;
        L24:
            return Utf8.access$300(r8, r14, r13, r11 - r13);
        L22:
            if (r13 >= (r11 - 1)) goto L24;
            int r18 = r13 + 1;
            byte r19 = r8.get(r13);
            if (r19 > (-65)) goto L37;
            if (r14 != (-32)) goto L31;
            if (r19 < (-96)) goto L37;
        L31:
            if (r14 != (-19)) goto L34;
            if (r19 >= (-96)) goto L37;
        L34:
            if (r8.get(r18) > (-65)) goto L37;
            r12 = r18 + 1;
        L37:
            return -1;
        L10:
            if (r13 >= r11) goto L11;
            if (r14 < (-62)) goto L18;
            if (r8.get(r13) > (-65)) goto L18;
            r13 = r13 + 1;
        L18:
            return -1;
        L11:
            return r14;
        L50:
            r12 = r13;
            goto L3
        L4:
            return 0;
        }

        public final boolean isValidUtf8(byte[] r8, int r10, int r11) {
            if (partialIsValidUtf8(0, r8, r10, r11) != 0) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public static final class SafeProcessor extends Processor {
        public SafeProcessor() {
        }

        private static int partialIsValidUtf8NonAscii(byte[] r8, int r10, int r11) {
        L2:
            if (r10 >= r11) goto L3;
            int r12 = r10 + 1;
            byte r13 = r8[r10];
            if (r13 >= 0) goto L46;
            if (r13 < (-32)) goto L9;
            if (r13 < (-16)) goto L19;
            if (r12 >= (r11 - 2)) goto L36;
            int r14 = r12 + 1;
            byte r15 = r8[r12];
            if (r15 > (-65)) goto L45;
            if ((((r15 + 112) + (r13 << 28)) >> 30) != 0) goto L45;
            int r16 = r14 + 1;
            if (r8[r14] > (-65)) goto L45;
            r12 = r16 + 1;
            if (r8[r16] <= (-65)) goto L46;
        L45:
            return -1;
        L36:
            return Utf8.access$1100(r8, r12, r11);
        L19:
            if (r12 >= (r11 - 1)) goto L21;
            int r17 = r12 + 1;
            byte r18 = r8[r12];
            if (r18 > (-65)) goto L32;
            if (r13 != (-32)) goto L28;
            if (r18 < (-96)) goto L32;
        L28:
            if (r13 != (-19)) goto L30;
            if (r18 >= (-96)) goto L32;
        L30:
            r10 = r17 + 1;
            if (r8[r17] <= (-65)) goto L2;
        L32:
            return -1;
        L21:
            return Utf8.access$1100(r8, r12, r11);
        L9:
            if (r12 >= r11) goto L10;
            if (r13 < (-62)) goto L15;
            r10 = r12 + 1;
            if (r8[r12] <= (-65)) goto L2;
        L15:
            return -1;
        L10:
            return r13;
        L46:
            r10 = r12;
            goto L2
        L3:
            return 0;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] r10, int r11, int r12) {
            if (((r11 | r12) | ((r10.length - r11) - r12)) < 0) goto L42;
            int r13 = r11 + r12;
            char[] r14 = new char[r12];
            int r8 = 0;
        L5:
            if (r11 >= r13) goto L10;
            byte r15 = r10[r11];
            if (DecodeUtil.access$400(r15) == false) goto L10;
            r11 = r11 + 1;
            DecodeUtil.access$500(r15, r14, r8);
            r8 = r8 + 1;
        L10:
            int r16 = r8;
        L11:
            if (r11 >= r13) goto L40;
            int r17 = r11 + 1;
            byte r18 = r10[r11];
            if (DecodeUtil.access$400(r18) == true) goto L14;
            if (DecodeUtil.access$600(r18) == true) goto L23;
            if (DecodeUtil.access$800(r18) == true) goto L30;
            if (r17 >= (r13 - 2)) goto L38;
            int r19 = r17 + 1;
            byte r20 = r10[r17];
            int r21 = r19 + 1;
            DecodeUtil.access$1000(r18, r20, r10[r19], r10[r21], r14, r16);
            r11 = r21 + 1;
            r16 = (r16 + 1) + 1;
            goto L11
        L38:
            throw InvalidProtocolBufferException.invalidUtf8();
        L30:
            if (r17 >= (r13 - 1)) goto L33;
            int r22 = r17 + 1;
            DecodeUtil.access$900(r18, r10[r17], r10[r22], r14, r16);
            r11 = r22 + 1;
            r16 = r16 + 1;
            goto L11
        L33:
            throw InvalidProtocolBufferException.invalidUtf8();
        L23:
            if (r17 >= r13) goto L26;
            DecodeUtil.access$700(r18, r10[r17], r14, r16);
            r11 = r17 + 1;
            r16 = r16 + 1;
            goto L11
        L26:
            throw InvalidProtocolBufferException.invalidUtf8();
        L14:
            int r23 = r16 + 1;
            DecodeUtil.access$500(r18, r14, r16);
        L15:
            if (r17 >= r13) goto L20;
            byte r110 = r10[r17];
            if (DecodeUtil.access$400(r110) == false) goto L20;
            r17 = r17 + 1;
            DecodeUtil.access$500(r110, r14, r23);
            r23 = r23 + 1;
        L20:
            r11 = r17;
            r16 = r23;
            goto L11
        L40:
            return new String(r14, 0, r16);
        L42:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(r10.length), Integer.valueOf(r11), Integer.valueOf(r12)}));
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer r8, int r10, int r11) {
            return decodeUtf8Default(r8, r10, r11);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(String r8, byte[] r10, int r11, int r12) {
            int r13 = r8.length();
            int r14 = r12 + r11;
            int r15 = 0;
        L4:
            if (r15 >= r13) goto L10;
            int r16 = r15 + r11;
            if (r16 >= r14) goto L10;
            char r17 = r8.charAt(r15);
            if (r17 >= 128) goto L10;
            r10[r16] = (byte) r17;
            r15 = r15 + 1;
        L10:
            if (r15 == r13) goto L12;
            int r18 = r11 + r15;
        L14:
            if (r15 >= r13) goto L52;
            char r19 = r8.charAt(r15);
            if (r19 >= 128) goto L21;
            if (r18 >= r14) goto L21;
            int r20 = r18 + 1;
            r10[r18] = (byte) r19;
        L19:
            r18 = r20;
        L38:
            r15 = r15 + 1;
        L21:
            if (r19 >= 2048) goto L26;
            if (r18 > (r14 - 2)) goto L26;
            int r21 = r18 + 1;
            r10[r18] = (byte) ((r19 >>> 6) | 960);
            r18 = r21 + 1;
            r10[r21] = (byte) ((r19 & '?') | 128);
        L26:
            if (r19 < 55296) goto L29;
            if (57343 < r19) goto L29;
        L32:
            if (r18 > (r14 - 4)) goto L42;
            int r22 = r15 + 1;
            if (r22 == r8.length()) goto L41;
            char r23 = r8.charAt(r22);
            if (Character.isSurrogatePair(r19, r23) == false) goto L39;
            int r24 = Character.toCodePoint(r19, r23);
            int r25 = r18 + 1;
            r10[r18] = (byte) ((r24 >>> 18) | 240);
            int r26 = r25 + 1;
            r10[r25] = (byte) (((r24 >>> 12) & 63) | 128);
            int r27 = r26 + 1;
            r10[r26] = (byte) (((r24 >>> 6) & 63) | 128);
            r18 = r27 + 1;
            r10[r27] = (byte) ((r24 & 63) | 128);
            r15 = r22;
            goto L38
        L39:
            r15 = r22;
        L41:
            throw new UnpairedSurrogateException(r15 - 1, r13);
        L42:
            if (55296 > r19) goto L51;
            if (r19 > 57343) goto L51;
            int r28 = r15 + 1;
            if (r28 == r8.length()) goto L49;
            if (Character.isSurrogatePair(r19, r8.charAt(r28)) == true) goto L51;
        L49:
            throw new UnpairedSurrogateException(r15, r13);
        L51:
            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
        L29:
            if (r18 > (r14 - 3)) goto L32;
            int r29 = r18 + 1;
            r10[r18] = (byte) ((r19 >>> '\f') | 480);
            int r30 = r29 + 1;
            r10[r29] = (byte) (((r19 >>> 6) & 63) | 128);
            r20 = r30 + 1;
            r10[r30] = (byte) ((r19 & '?') | 128);
            goto L19
        L52:
            return r18;
        L12:
            return r11 + r13;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(String r8, ByteBuffer r10) {
            encodeUtf8Default(r8, r10);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8(int r8, byte[] r10, int r11, int r12) {
            if (r8 == 0) goto L55;
            if (r11 < r12) goto L5;
            return r8;
        L5:
            byte r13 = (byte) r8;
            if (r13 >= (-32)) goto L15;
            if (r13 < (-62)) goto L13;
            int r14 = r11 + 1;
            if (r10[r11] > (-65)) goto L13;
        L12:
            r11 = r14;
        L13:
            return -1;
        L15:
            if (r13 >= (-16)) goto L33;
            byte r15 = (byte) (~(r8 >> 8));
            if (r15 != 0) goto L23;
            int r16 = r11 + 1;
            byte r17 = r10[r11];
            if (r16 >= r12) goto L21;
            r11 = r16;
            r15 = r17;
            goto L23
        L21:
            return Utf8.access$000(r13, r17);
        L23:
            if (r15 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r13 != (-32)) goto L28;
            if (r15 < (-96)) goto L32;
        L28:
            if (r13 != (-19)) goto L30;
            if (r15 >= (-96)) goto L32;
        L30:
            r14 = r11 + 1;
            if (r10[r11] <= (-65)) goto L12;
        L33:
            byte r18 = (byte) (~(r8 >> 8));
            if (r18 != 0) goto L40;
            int r19 = r11 + 1;
            r18 = r10[r11];
            if (r19 >= r12) goto L38;
            byte r20 = 0;
        L41:
            if (r20 != 0) goto L47;
            int r21 = r19 + 1;
            byte r22 = r10[r19];
            if (r21 >= r12) goto L45;
            r20 = r22;
            r19 = r21;
            goto L47
        L45:
            return Utf8.access$100(r13, r18, r22);
        L47:
            if (r18 > (-65)) goto L53;
            int r23 = r18 + 112;
            if (((r23 + (r13 << 28)) >> 30) != 0) goto L53;
            if (r20 > (-65)) goto L53;
            r11 = r19 + 1;
            if (r10[r19] <= (-65)) goto L55;
        L53:
            return -1;
        L38:
            return Utf8.access$000(r13, r18);
        L40:
            r20 = (byte) (r8 >> 16);
            r19 = r11;
        L55:
            return partialIsValidUtf8(r10, r11, r12);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int r8, ByteBuffer r10, int r11, int r12) {
            return partialIsValidUtf8Default(r8, r10, r11, r12);
        }

        private static int partialIsValidUtf8(byte[] r8, int r10, int r11) {
        L2:
            if (r10 >= r11) goto L6;
            if (r8[r10] < 0) goto L6;
            r10 = r10 + 1;
        L6:
            if (r10 < r11) goto L9;
            return 0;
        L9:
            return partialIsValidUtf8NonAscii(r8, r10, r11);
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int r8, int r10) {
            super("Unpaired surrogate at index " + r8 + " of " + r10);
        }
    }

    public static final class UnsafeProcessor extends Processor {
        public UnsafeProcessor() {
        }

        public static boolean isAvailable() {
            if (UnsafeUtil.hasUnsafeArrayOperations() == true) goto L5;
        L7:
            return false;
        L5:
            if (UnsafeUtil.hasUnsafeByteBufferOperations() == false) goto L7;
            return true;
        }

        private static int unsafeEstimateConsecutiveAscii(long r8, int r10) {
            if (r10 >= 16) goto L6;
            return 0;
        L6:
            int r11 = (int) ((-r8) & 7);
            int r12 = r11;
        L7:
            if (r12 <= 0) goto L13;
            long r13 = 1 + r8;
            if (UnsafeUtil.getByte(r8) < 0) goto L11;
            r12 = r12 - 1;
            r8 = r13;
            goto L7
        L11:
            return r11 - r12;
        L13:
            int r14 = r10 - r11;
        L15:
            if (r14 < 8) goto L20;
            if ((UnsafeUtil.getLong(r8) & Utf8.ASCII_MASK_LONG) != 0) goto L20;
            r8 = r8 + 8;
            r14 = r14 - 8;
        L20:
            return r10 - r14;
        }

        private static int unsafeIncompleteStateFor(long r8, int r10, int r11) {
            if (r11 == 0) goto L14;
            if (r11 == 1) goto L12;
            if (r11 != 2) goto L10;
            return Utf8.access$100(r10, UnsafeUtil.getByte(r8), UnsafeUtil.getByte(r8 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.access$000(r10, UnsafeUtil.getByte(r8));
        L14:
            return Utf8.access$1200(r10);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] r8, int r10, int r11) {
            Charset r12 = Internal.UTF_8;
            String r13 = new String(r8, r10, r11, r12);
            if (r13.indexOf(65533) >= 0) goto L6;
            return r13;
        L6:
            if (Arrays.equals(r13.getBytes(r12), Arrays.copyOfRange(r8, r10, r11 + r10)) == false) goto L9;
            return r13;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer r19, int r20, int r21) {
            if (((r20 | r21) | ((r19.limit() - r20) - r21)) < 0) goto L46;
            long r8 = UnsafeUtil.addressOffset(r19) + ((long) r20);
            long r10 = ((long) r21) + r8;
            char[] r11 = new char[r21];
            int r12 = 0;
        L6:
            if (r8 >= r10) goto L11;
            byte r13 = UnsafeUtil.getByte(r8);
            if (DecodeUtil.access$400(r13) == false) goto L11;
            r8 = r8 + 1;
            DecodeUtil.access$500(r13, r11, r12);
            r12 = r12 + 1;
        L11:
            int r14 = r12;
        L13:
            if (r8 >= r10) goto L44;
            long r15 = r8 + 1;
            byte r16 = UnsafeUtil.getByte(r8);
            if (DecodeUtil.access$400(r16) == true) goto L16;
            if (DecodeUtil.access$600(r16) == true) goto L27;
            if (DecodeUtil.access$800(r16) == true) goto L34;
            if (r15 >= (r10 - 2)) goto L42;
            long r17 = r15 + 1;
            long r18 = r17 + 1;
            DecodeUtil.access$1000(r16, UnsafeUtil.getByte(r15), UnsafeUtil.getByte(r17), UnsafeUtil.getByte(r18), r11, r14);
            r14 = (r14 + 1) + 1;
            r8 = r18 + 1;
            goto L13
        L42:
            throw InvalidProtocolBufferException.invalidUtf8();
        L34:
            if (r15 >= (r10 - 1)) goto L37;
            long r22 = r15 + 1;
            byte r23 = UnsafeUtil.getByte(r15);
            DecodeUtil.access$900(r16, r23, UnsafeUtil.getByte(r22), r11, r14);
            r8 = r22 + 1;
            r14 = r14 + 1;
            goto L13
        L37:
            throw InvalidProtocolBufferException.invalidUtf8();
        L27:
            if (r15 >= r10) goto L30;
            DecodeUtil.access$700(r16, UnsafeUtil.getByte(r15), r11, r14);
            r14 = r14 + 1;
            r8 = r15 + 1;
            goto L13
        L30:
            throw InvalidProtocolBufferException.invalidUtf8();
        L16:
            int r24 = r14 + 1;
            DecodeUtil.access$500(r16, r11, r14);
        L18:
            if (r15 >= r10) goto L23;
            byte r25 = UnsafeUtil.getByte(r15);
            if (DecodeUtil.access$400(r25) == false) goto L23;
            r15 = r15 + 1;
            DecodeUtil.access$500(r25, r11, r24);
            r24 = r24 + 1;
        L23:
            r14 = r24;
            r8 = r15;
            goto L13
        L44:
            return new String(r11, 0, r14);
        L46:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r19.limit()), Integer.valueOf(r20), Integer.valueOf(r21)}));
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(String r18, byte[] r19, int r20, int r21) {
            long r8 = r20;
            long r10 = ((long) r21) + r8;
            int r11 = r18.length();
            if (r11 > r21) goto L57;
            if ((r19.length - r21) < r20) goto L57;
            int r12 = 0;
        L8:
            if (r12 >= r11) goto L12;
            char r13 = r18.charAt(r12);
            if (r13 >= 128) goto L12;
            UnsafeUtil.putByte(r19, r8, (byte) r13);
            r12 = r12 + 1;
            r8 = 1 + r8;
        L12:
            if (r12 == r11) goto L14;
        L15:
            if (r12 >= r11) goto L55;
            char r14 = r18.charAt(r12);
            if (r14 >= 128) goto L23;
            if (r8 >= r10) goto L23;
            long r15 = r8 + 1;
            int r16 = r14;
        L21:
            UnsafeUtil.putByte(r19, r8, (byte) r16);
            r8 = r15;
        L40:
            r12 = r12 + 1;
        L23:
            if (r14 >= 2048) goto L28;
            if (r8 > (r10 - 2)) goto L28;
            long r17 = r8 + 1;
            UnsafeUtil.putByte(r19, r8, (byte) ((r14 >>> 6) | 960));
            r8 = r17 + 1;
            UnsafeUtil.putByte(r19, r17, (byte) ((r14 & '?') | 128));
        L28:
            if (r14 < 55296) goto L31;
            if (57343 < r14) goto L31;
        L34:
            if (r8 > (r10 - 4)) goto L44;
            int r110 = r12 + 1;
            if (r110 == r11) goto L43;
            char r22 = r18.charAt(r110);
            if (Character.isSurrogatePair(r14, r22) == false) goto L41;
            int r23 = Character.toCodePoint(r14, r22);
            long r111 = r8 + 1;
            UnsafeUtil.putByte(r19, r8, (byte) ((r23 >>> 18) | 240));
            long r24 = r111 + 1;
            UnsafeUtil.putByte(r19, r111, (byte) (((r23 >>> 12) & 63) | 128));
            long r112 = r24 + 1;
            UnsafeUtil.putByte(r19, r24, (byte) (((r23 >>> 6) & 63) | 128));
            r8 = r112 + 1;
            UnsafeUtil.putByte(r19, r112, (byte) ((r23 & 63) | 128));
            r12 = r110;
            goto L40
        L41:
            r12 = r110;
        L43:
            throw new UnpairedSurrogateException(r12 - 1, r11);
        L44:
            if (55296 > r14) goto L53;
            if (r14 > 57343) goto L53;
            int r25 = r12 + 1;
            if (r25 == r11) goto L51;
            if (Character.isSurrogatePair(r14, r18.charAt(r25)) == true) goto L53;
        L51:
            throw new UnpairedSurrogateException(r12, r11);
        L53:
            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
        L31:
            if (r8 > (r10 - 3)) goto L34;
            long r113 = r8 + 1;
            UnsafeUtil.putByte(r19, r8, (byte) ((r14 >>> '\f') | 480));
            r8 = r113 + 1;
            UnsafeUtil.putByte(r19, r113, (byte) (((r14 >>> 6) & 63) | 128));
            r15 = r8 + 1;
            r16 = (r14 & '?') | 128;
            goto L21
        L55:
            return (int) r8;
        L14:
            return (int) r8;
        L57:
            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(String r20, ByteBuffer r21) {
            long r8 = UnsafeUtil.addressOffset(r21);
            long r10 = ((long) r21.position()) + r8;
            long r11 = ((long) r21.limit()) + r8;
            int r12 = r20.length();
            if (r12 > (r11 - r10)) goto L55;
            int r13 = 0;
        L6:
            if (r13 >= r12) goto L10;
            char r14 = r20.charAt(r13);
            if (r14 >= 128) goto L10;
            UnsafeUtil.putByte(r10, (byte) r14);
            r13 = r13 + 1;
            r10 = r10 + 1;
        L10:
            if (r13 != r12) goto L14;
            int r15 = (int) (r10 - r8);
        L12:
            Java8Compatibility.position(r21, r15);
            return;
        L14:
            if (r13 >= r12) goto L53;
            char r16 = r20.charAt(r13);
            if (r16 >= 128) goto L21;
            if (r10 >= r11) goto L21;
            UnsafeUtil.putByte(r10, (byte) r16);
            r10 = r10 + 1;
            long r17 = r8;
        L39:
            r13 = r13 + 1;
            r8 = r17;
            r11 = r11;
        L21:
            if (r16 < 2048) goto L23;
        L26:
            r17 = r8;
            if (r16 < 55296) goto L30;
            if (57343 < r16) goto L30;
        L33:
            if (r10 > (r11 - 4)) goto L43;
            int r18 = r13 + 1;
            if (r18 == r12) goto L42;
            char r19 = r20.charAt(r18);
            if (Character.isSurrogatePair(r16, r19) == false) goto L40;
            int r22 = Character.toCodePoint(r16, r19);
            long r23 = r10 + 1;
            UnsafeUtil.putByte(r10, (byte) ((r22 >>> 18) | 240));
            long r24 = r23 + 1;
            UnsafeUtil.putByte(r23, (byte) (((r22 >>> 12) & 63) | 128));
            long r25 = r24 + 1;
            UnsafeUtil.putByte(r24, (byte) (((r22 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(r25, (byte) ((r22 & 63) | 128));
            r13 = r18;
            r10 = r25 + 1;
            goto L39
        L40:
            r13 = r18;
        L42:
            throw new UnpairedSurrogateException(r13 - 1, r12);
        L43:
            if (55296 > r16) goto L52;
            if (r16 > 57343) goto L52;
            int r26 = r13 + 1;
            if (r26 == r12) goto L50;
            if (Character.isSurrogatePair(r16, r20.charAt(r26)) == true) goto L52;
        L50:
            throw new UnpairedSurrogateException(r13, r12);
        L52:
            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
        L30:
            if (r10 > (r11 - 3)) goto L33;
            long r27 = r10 + 1;
            UnsafeUtil.putByte(r10, (byte) ((r16 >>> '\f') | 480));
            long r28 = r27 + 1;
            UnsafeUtil.putByte(r27, (byte) (((r16 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(r28, (byte) ((r16 & '?') | 128));
            r10 = r28 + 1;
            goto L39
        L23:
            if (r10 > (r11 - 2)) goto L26;
            r17 = r8;
            long r29 = r10 + 1;
            UnsafeUtil.putByte(r10, (byte) ((r16 >>> 6) | 960));
            UnsafeUtil.putByte(r29, (byte) ((r16 & '?') | 128));
            r10 = r29 + 1;
            goto L39
        L53:
            r15 = (int) (r10 - r8);
            goto L12
        L55:
            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13) {
            if (((r12 | r13) | (r11.length - r13)) < 0) goto L63;
            long r8 = r12;
            long r14 = r13;
            if (r10 == 0) goto L61;
            if (r8 < r14) goto L9;
            return r10;
        L9:
            byte r15 = (byte) r10;
            if (r15 >= (-32)) goto L19;
            if (r15 < (-62)) goto L17;
            long r16 = 1 + r8;
            if (UnsafeUtil.getByte(r11, r8) > (-65)) goto L17;
            r8 = r16;
        L17:
            return -1;
        L19:
            if (r15 >= (-16)) goto L39;
            byte r17 = (byte) (~(r10 >> 8));
            if (r17 != 0) goto L27;
            long r18 = r8 + 1;
            r17 = UnsafeUtil.getByte(r11, r8);
            if (r18 >= r14) goto L25;
            r8 = r18;
            goto L27
        L25:
            return Utf8.access$000(r15, r17);
        L27:
            if (r17 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r15 != (-32)) goto L32;
            if (r17 < (-96)) goto L38;
        L32:
            if (r15 != (-19)) goto L34;
            if (r17 >= (-96)) goto L38;
        L34:
            long r19 = r8 + 1;
            if (UnsafeUtil.getByte(r11, r8) > (-65)) goto L38;
        L37:
            r8 = r19;
            goto L61
        L39:
            byte r20 = (byte) (~(r10 >> 8));
            if (r20 != 0) goto L46;
            long r21 = r8 + 1;
            r20 = UnsafeUtil.getByte(r11, r8);
            if (r21 >= r14) goto L44;
            byte r110 = 0;
            r8 = r21;
        L47:
            if (r110 != 0) goto L53;
            long r22 = r8 + 1;
            r110 = UnsafeUtil.getByte(r11, r8);
            if (r22 >= r14) goto L51;
            r8 = r22;
            goto L53
        L51:
            return Utf8.access$100(r15, r20, r110);
        L53:
            if (r20 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r20 + 112) + (r15 << 28)) >> 30) != 0) goto L59;
            if (r110 > (-65)) goto L59;
            r19 = r8 + 1;
            if (UnsafeUtil.getByte(r11, r8) <= (-65)) goto L37;
        L44:
            return Utf8.access$000(r15, r20);
        L46:
            r110 = (byte) (r10 >> 16);
        L61:
            return partialIsValidUtf8(r11, r8, (int) (r14 - r8));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r11.length), Integer.valueOf(r12), Integer.valueOf(r13)}));
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int r10, ByteBuffer r11, int r12, int r13) {
            if (((r12 | r13) | (r11.limit() - r13)) < 0) goto L63;
            long r8 = UnsafeUtil.addressOffset(r11) + ((long) r12);
            long r14 = ((long) (r13 - r12)) + r8;
            if (r10 == 0) goto L61;
            if (r8 < r14) goto L9;
            return r10;
        L9:
            byte r15 = (byte) r10;
            if (r15 >= (-32)) goto L19;
            if (r15 < (-62)) goto L17;
            long r16 = 1 + r8;
            if (UnsafeUtil.getByte(r8) > (-65)) goto L17;
            r8 = r16;
        L17:
            return -1;
        L19:
            if (r15 >= (-16)) goto L39;
            byte r17 = (byte) (~(r10 >> 8));
            if (r17 != 0) goto L27;
            long r18 = r8 + 1;
            r17 = UnsafeUtil.getByte(r8);
            if (r18 >= r14) goto L25;
            r8 = r18;
            goto L27
        L25:
            return Utf8.access$000(r15, r17);
        L27:
            if (r17 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r15 != (-32)) goto L32;
            if (r17 < (-96)) goto L38;
        L32:
            if (r15 != (-19)) goto L34;
            if (r17 >= (-96)) goto L38;
        L34:
            long r19 = r8 + 1;
            if (UnsafeUtil.getByte(r8) > (-65)) goto L38;
        L37:
            r8 = r19;
            goto L61
        L39:
            byte r110 = (byte) (~(r10 >> 8));
            if (r110 != 0) goto L46;
            long r20 = r8 + 1;
            r110 = UnsafeUtil.getByte(r8);
            if (r20 >= r14) goto L44;
            byte r21 = 0;
            r8 = r20;
        L47:
            if (r21 != 0) goto L53;
            long r22 = r8 + 1;
            r21 = UnsafeUtil.getByte(r8);
            if (r22 >= r14) goto L51;
            r8 = r22;
            goto L53
        L51:
            return Utf8.access$100(r15, r110, r21);
        L53:
            if (r110 > (-65)) goto L59;
            int r111 = r110 + 112;
            if (((r111 + (r15 << 28)) >> 30) != 0) goto L59;
            if (r21 > (-65)) goto L59;
            r19 = r8 + 1;
            if (UnsafeUtil.getByte(r8) <= (-65)) goto L37;
        L59:
            return -1;
        L44:
            return Utf8.access$000(r15, r110);
        L46:
            r21 = (byte) (r10 >> 16);
        L61:
            return partialIsValidUtf8(r8, (int) (r14 - r8));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r11.limit()), Integer.valueOf(r12), Integer.valueOf(r13)}));
        }

        private static int partialIsValidUtf8(long r8, int r10) {
            int r11 = unsafeEstimateConsecutiveAscii(r8, r10);
            long r12 = r8 + ((long) r11);
            int r13 = r10 - r11;
        L3:
            byte r14 = 0;
        L5:
            if (r13 <= 0) goto L10;
            long r15 = r12 + 1;
            r14 = UnsafeUtil.getByte(r12);
            if (r14 < 0) goto L9;
            r13 = r13 - 1;
            r12 = r15;
            goto L5
        L9:
            r12 = r15;
        L10:
            if (r13 == 0) goto L11;
            int r16 = r13 - 1;
            if (r14 >= (-32)) goto L24;
            if (r16 == 0) goto L15;
            r13 = r16 - 1;
            if (r14 < (-62)) goto L22;
            long r17 = 1 + r12;
            if (UnsafeUtil.getByte(r12) > (-65)) goto L22;
        L21:
            r12 = r17;
        L22:
            return -1;
        L15:
            return r14;
        L24:
            if (r14 >= (-16)) goto L41;
            if (r16 < 2) goto L28;
            r13 = r16 - 2;
            long r18 = r12 + 1;
            byte r19 = UnsafeUtil.getByte(r12);
            if (r19 > (-65)) goto L39;
            if (r14 != (-32)) goto L35;
            if (r19 < (-96)) goto L39;
        L35:
            if (r14 != (-19)) goto L37;
            if (r19 >= (-96)) goto L39;
        L37:
            r17 = 1 + r18;
            if (UnsafeUtil.getByte(r18) <= (-65)) goto L21;
        L39:
            return -1;
        L28:
            return unsafeIncompleteStateFor(r12, r14, r16);
        L41:
            if (r16 < 3) goto L43;
            r13 = r16 - 3;
            long r20 = r12 + 1;
            byte r21 = UnsafeUtil.getByte(r12);
            if (r21 > (-65)) goto L52;
            if ((((r21 + 112) + (r14 << 28)) >> 30) != 0) goto L52;
            long r22 = r20 + 1;
            if (UnsafeUtil.getByte(r20) > (-65)) goto L52;
            r17 = 1 + r22;
            if (UnsafeUtil.getByte(r22) <= (-65)) goto L21;
        L52:
            return -1;
        L43:
            return unsafeIncompleteStateFor(r12, r14, r16);
        L11:
            return 0;
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] r8, long r10, int r11) {
            int r12 = 0;
            if (r11 >= 16) goto L5;
            return 0;
        L5:
            int r13 = 8 - (((int) r10) & 7);
        L7:
            if (r12 >= r13) goto L12;
            long r14 = 1 + r10;
            if (UnsafeUtil.getByte(r8, r10) < 0) goto L10;
            r12 = r12 + 1;
            r10 = r14;
            goto L7
        L10:
            return r12;
        L12:
            int r15 = r12 + 8;
            if (r15 > r11) goto L18;
            if ((UnsafeUtil.getLong(r8, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + r10) & Utf8.ASCII_MASK_LONG) != 0) goto L18;
            r10 = r10 + 8;
            r12 = r15;
        L18:
            if (r12 >= r11) goto L23;
            long r16 = r10 + 1;
            if (UnsafeUtil.getByte(r8, r10) < 0) goto L21;
            r12 = r12 + 1;
            r10 = r16;
            goto L18
        L21:
            return r12;
        L23:
            return r11;
        }

        private static int unsafeIncompleteStateFor(byte[] r8, int r10, long r11, int r12) {
            if (r12 == 0) goto L14;
            if (r12 == 1) goto L12;
            if (r12 != 2) goto L10;
            return Utf8.access$100(r10, UnsafeUtil.getByte(r8, r11), UnsafeUtil.getByte(r8, r11 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.access$000(r10, UnsafeUtil.getByte(r8, r11));
        L14:
            return Utf8.access$1200(r10);
        }

        private static int partialIsValidUtf8(byte[] r8, long r10, int r11) {
            int r12 = unsafeEstimateConsecutiveAscii(r8, r10, r11);
            int r13 = r11 - r12;
            long r14 = r10 + ((long) r12);
        L3:
            byte r15 = 0;
        L5:
            if (r13 <= 0) goto L10;
            long r16 = r14 + 1;
            r15 = UnsafeUtil.getByte(r8, r14);
            if (r15 < 0) goto L9;
            r13 = r13 - 1;
            r14 = r16;
            goto L5
        L9:
            r14 = r16;
        L10:
            if (r13 == 0) goto L11;
            int r17 = r13 - 1;
            if (r15 >= (-32)) goto L24;
            if (r17 == 0) goto L15;
            r13 = r17 - 1;
            if (r15 < (-62)) goto L22;
            long r18 = 1 + r14;
            if (UnsafeUtil.getByte(r8, r14) > (-65)) goto L22;
        L21:
            r14 = r18;
        L22:
            return -1;
        L15:
            return r15;
        L24:
            if (r15 >= (-16)) goto L41;
            if (r17 < 2) goto L28;
            r13 = r17 - 2;
            long r19 = r14 + 1;
            byte r20 = UnsafeUtil.getByte(r8, r14);
            if (r20 > (-65)) goto L39;
            if (r15 != (-32)) goto L35;
            if (r20 < (-96)) goto L39;
        L35:
            if (r15 != (-19)) goto L37;
            if (r20 >= (-96)) goto L39;
        L37:
            r18 = 1 + r19;
            if (UnsafeUtil.getByte(r8, r19) <= (-65)) goto L21;
        L39:
            return -1;
        L28:
            return unsafeIncompleteStateFor(r8, r15, r14, r17);
        L41:
            if (r17 < 3) goto L43;
            r13 = r17 - 3;
            long r21 = r14 + 1;
            byte r22 = UnsafeUtil.getByte(r8, r14);
            if (r22 > (-65)) goto L52;
            if ((((r22 + 112) + (r15 << 28)) >> 30) != 0) goto L52;
            long r23 = r21 + 1;
            if (UnsafeUtil.getByte(r8, r21) > (-65)) goto L52;
            r18 = 1 + r23;
            if (UnsafeUtil.getByte(r8, r23) <= (-65)) goto L21;
        L52:
            return -1;
        L43:
            return unsafeIncompleteStateFor(r8, r15, r14, r17);
        L11:
            return 0;
        }
    }

    static {
        if (UnsafeProcessor.isAvailable() == true) goto L5;
    L7:
        Processor r8 = new SafeProcessor();
    L8:
        processor = r8;
        return;
    L5:
        if (Android.isOnAndroidDevice() == true) goto L7;
        r8 = new UnsafeProcessor();
        goto L8
    }

    private Utf8() {
    }

    public static /* synthetic */ int access$000(int r8, int r10) {
        return incompleteStateFor(r8, r10);
    }

    public static /* synthetic */ int access$100(int r8, int r10, int r11) {
        return incompleteStateFor(r8, r10, r11);
    }

    public static /* synthetic */ int access$1100(byte[] r8, int r10, int r11) {
        return incompleteStateFor(r8, r10, r11);
    }

    public static /* synthetic */ int access$1200(int r8) {
        return incompleteStateFor(r8);
    }

    public static /* synthetic */ int access$200(ByteBuffer r8, int r10, int r11) {
        return estimateConsecutiveAscii(r8, r10, r11);
    }

    public static /* synthetic */ int access$300(ByteBuffer r8, int r10, int r11, int r12) {
        return incompleteStateFor(r8, r10, r11, r12);
    }

    public static String decodeUtf8(ByteBuffer r8, int r10, int r11) {
        return processor.decodeUtf8(r8, r10, r11);
    }

    public static int encode(String r8, byte[] r10, int r11, int r12) {
        return processor.encodeUtf8(r8, r10, r11, r12);
    }

    public static void encodeUtf8(String r8, ByteBuffer r10) {
        processor.encodeUtf8(r8, r10);
    }

    public static int encodedLength(String r8) {
        int r10 = r8.length();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L7;
        if (r8.charAt(r11) >= 128) goto L7;
        r11 = r11 + 1;
    L7:
        int r12 = r10;
    L8:
        if (r11 >= r10) goto L13;
        char r13 = r8.charAt(r11);
        if (r13 >= 2048) goto L12;
        r12 = r12 + ((127 - r13) >>> 31);
        r11 = r11 + 1;
        goto L8
    L12:
        r12 = r12 + encodedLengthGeneral(r8, r11);
    L13:
        if (r12 < r10) goto L16;
        return r12;
    L16:
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) r12) + 4294967296L));
    }

    private static int encodedLengthGeneral(String r8, int r10) {
        int r11 = r8.length();
        int r12 = 0;
    L3:
        if (r10 >= r11) goto L17;
        char r13 = r8.charAt(r10);
        if (r13 >= 2048) goto L7;
        r12 = r12 + ((127 - r13) >>> 31);
    L16:
        r10 = r10 + 1;
        goto L3
    L7:
        r12 = r12 + 2;
        if (55296 > r13) goto L16;
        if (r13 > 57343) goto L16;
        if (Character.codePointAt(r8, r10) < 65536) goto L15;
        r10 = r10 + 1;
        goto L16
    L15:
        throw new UnpairedSurrogateException(r10, r11);
    L17:
        return r12;
    }

    private static int estimateConsecutiveAscii(ByteBuffer r8, int r10, int r11) {
        int r12 = r11 - 7;
        int r13 = r10;
    L3:
        if (r13 >= r12) goto L8;
        if ((r8.getLong(r13) & ASCII_MASK_LONG) != 0) goto L8;
        r13 = r13 + 8;
    L8:
        return r13 - r10;
    }

    private static int incompleteStateFor(int r8) {
        if (r8 <= (-12)) goto L6;
        return -1;
    L6:
        return r8;
    }

    public static boolean isValidUtf8(ByteBuffer r8) {
        return processor.isValidUtf8(r8, r8.position(), r8.remaining());
    }

    public static int partialIsValidUtf8(int r8, ByteBuffer r10, int r11, int r12) {
        return processor.partialIsValidUtf8(r8, r10, r11, r12);
    }

    public static String decodeUtf8(byte[] r8, int r10, int r11) {
        return processor.decodeUtf8(r8, r10, r11);
    }

    private static int incompleteStateFor(int r8, int r10) {
        if (r8 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (r10 > (-65)) goto L8;
        return r8 ^ (r10 << 8);
    }

    public static boolean isValidUtf8(byte[] r8) {
        return processor.isValidUtf8(r8, 0, r8.length);
    }

    public static int partialIsValidUtf8(int r8, byte[] r10, int r11, int r12) {
        return processor.partialIsValidUtf8(r8, r10, r11, r12);
    }

    private static int incompleteStateFor(int r8, int r10, int r11) {
        if (r8 <= (-12)) goto L5;
    L9:
        return -1;
    L5:
        if (r10 > (-65)) goto L9;
        if (r11 > (-65)) goto L9;
        return (r8 ^ (r10 << 8)) ^ (r11 << 16);
    }

    public static boolean isValidUtf8(byte[] r8, int r10, int r11) {
        return processor.isValidUtf8(r8, r10, r11);
    }

    private static int incompleteStateFor(ByteBuffer r8, int r10, int r11, int r12) {
        if (r12 == 0) goto L14;
        if (r12 == 1) goto L12;
        if (r12 != 2) goto L10;
        return incompleteStateFor(r10, r8.get(r11), r8.get(r11 + 1));
    L10:
        throw new AssertionError();
    L12:
        return incompleteStateFor(r10, r8.get(r11));
    L14:
        return incompleteStateFor(r10);
    }

    private static int incompleteStateFor(byte[] r8, int r10, int r11) {
        byte r12 = r8[r10 - 1];
        int r13 = r11 - r10;
        if (r13 == 0) goto L15;
        if (r13 == 1) goto L13;
        if (r13 != 2) goto L11;
        return incompleteStateFor(r12, r8[r10], r8[r10 + 1]);
    L11:
        throw new AssertionError();
    L13:
        return incompleteStateFor(r12, r8[r10]);
    L15:
        return incompleteStateFor(r12);
    }
}
