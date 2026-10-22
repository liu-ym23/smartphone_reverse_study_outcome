package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class Utf8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f4929a = null;

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int r3, int r4) {
            super("Unpaired surrogate at index " + r3 + " of " + r4);
        }
    }

    private static class a {
        private static char a(int r1) {
            return (char) ((r1 >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        static /* synthetic */ void a(byte r0, byte r1, byte r2, byte r3, char[] r4, int r5) {
            b(r0, r1, r2, r3, r4, r5);
        }

        static /* synthetic */ void a(byte r0, byte r1, byte r2, char[] r3, int r4) {
            b(r0, r1, r2, r3, r4);
        }

        static /* synthetic */ void a(byte r0, byte r1, char[] r2, int r3) {
            b(r0, r1, r2, r3);
        }

        static /* synthetic */ void a(byte r0, char[] r1, int r2) {
            b(r0, r1, r2);
        }

        static /* synthetic */ boolean a(byte r0) {
            return d(r0);
        }

        private static char b(int r1) {
            return (char) ((r1 & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        private static void b(byte r2, byte r3, byte r4, byte r5, char[] r6, int r7) {
            if (g(r3) == true) goto L13;
            if ((((r2 << 28) + (r3 + 112)) >> 30) != 0) goto L13;
            if (g(r4) == true) goto L13;
            if (g(r5) == true) goto L13;
            int r8 = ((((r2 & 7) << 18) | (h(r3) << 12)) | (h(r4) << 6)) | h(r5);
            r6[r7] = a(r8);
            r6[r7 + 1] = b(r8);
            return;
        L13:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void b(byte r2, byte r3, byte r4, char[] r5, int r6) {
            if (g(r3) == true) goto L15;
            if (r2 != (-32)) goto L8;
            if (r3 < (-96)) goto L15;
        L8:
            if (r2 != (-19)) goto L11;
            if (r3 >= (-96)) goto L15;
        L11:
            if (g(r4) == true) goto L15;
            r5[r6] = (char) ((((r2 & 15) << 12) | (h(r3) << 6)) | h(r4));
            return;
        L15:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void b(byte r1, byte r2, char[] r3, int r4) {
            if (r1 < (-62)) goto L9;
            if (g(r2) == true) goto L9;
            r3[r4] = (char) (((r1 & 31) << 6) | h(r2));
            return;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static void b(byte r0, char[] r1, int r2) {
            r1[r2] = (char) r0;
        }

        static /* synthetic */ boolean b(byte r0) {
            return e(r0);
        }

        static /* synthetic */ boolean c(byte r0) {
            return f(r0);
        }

        private static boolean d(byte r0) {
            if (r0 < 0) goto L4;
            return true;
        L4:
            return false;
        }

        private static boolean e(byte r1) {
            if (r1 >= (-32)) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean f(byte r1) {
            if (r1 >= (-16)) goto L5;
            return true;
        L5:
            return false;
        }

        private static boolean g(byte r1) {
            if (r1 <= (-65)) goto L5;
            return true;
        L5:
            return false;
        }

        private static int h(byte r0) {
            return r0 & okio.Utf8.REPLACEMENT_BYTE;
        }
    }

    static abstract class b {
        b() {
        }

        private static int e(ByteBuffer r6, int r7, int r8) {
            int r9 = r7 + Utf8.b(r6, r7, r8);
        L3:
            if (r9 >= r8) goto L4;
            int r0 = r9 + 1;
            byte r10 = r6.get(r9);
            if (r10 >= 0) goto L50;
            if (r10 < (-32)) goto L10;
            if (r10 < (-16)) goto L22;
            if (r0 >= (r8 - 2)) goto L24;
            int r1 = r0 + 1;
            byte r2 = r6.get(r0);
            if (r2 > (-65)) goto L49;
            if ((((r10 << 28) + (r2 + 112)) >> 30) != 0) goto L49;
            int r11 = r1 + 1;
            if (r6.get(r1) > (-65)) goto L49;
            r0 = r11 + 1;
            if (r6.get(r11) <= (-65)) goto L50;
        L49:
            return -1;
        L24:
            return Utf8.a(r6, r10, r0, r8 - r0);
        L22:
            if (r0 >= (r8 - 1)) goto L24;
            int r4 = r0 + 1;
            byte r3 = r6.get(r0);
            if (r3 > (-65)) goto L37;
            if (r10 != (-32)) goto L31;
            if (r3 < (-96)) goto L37;
        L31:
            if (r10 != (-19)) goto L34;
            if (r3 >= (-96)) goto L37;
        L34:
            if (r6.get(r4) > (-65)) goto L37;
            r9 = r4 + 1;
        L37:
            return -1;
        L10:
            if (r0 >= r8) goto L11;
            if (r10 < (-62)) goto L18;
            if (r6.get(r0) > (-65)) goto L18;
            r0 = r0 + 1;
        L18:
            return -1;
        L11:
            return r10;
        L50:
            r9 = r0;
            goto L3
        L4:
            return 0;
        }

        final int a(int r2, ByteBuffer r3, int r4, int r5) {
            if (r3.hasArray() == false) goto L7;
            int r0 = r3.arrayOffset();
            return a(r2, r3.array(), r4 + r0, r0 + r5);
        L7:
            if (r3.isDirect() == false) goto L11;
            return b(r2, r3, r4, r5);
        L11:
            return c(r2, r3, r4, r5);
        }

        abstract int a(int r1, byte[] r2, int r3, int r4);

        abstract int a(CharSequence r1, byte[] r2, int r3, int r4);

        final boolean a(ByteBuffer r2, int r3, int r4) {
            if (a(0, r2, r3, r4) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        final boolean a(byte[] r2, int r3, int r4) {
            if (a(0, r2, r3, r4) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        abstract int b(int r1, ByteBuffer r2, int r3, int r4);

        final String b(ByteBuffer r2, int r3, int r4) {
            if (r2.hasArray() == false) goto L7;
            int r0 = r2.arrayOffset();
            return b(r2.array(), r0 + r3, r4);
        L7:
            if (r2.isDirect() == false) goto L11;
            return c(r2, r3, r4);
        L11:
            return d(r2, r3, r4);
        }

        abstract String b(byte[] r1, int r2, int r3);

        final int c(int r6, ByteBuffer r7, int r8, int r9) {
            if (r6 == 0) goto L55;
            if (r8 < r9) goto L5;
            return r6;
        L5:
            byte r5 = (byte) r6;
            if (r5 >= (-32)) goto L15;
            if (r5 < (-62)) goto L13;
            int r10 = r8 + 1;
            if (r7.get(r8) > (-65)) goto L13;
        L12:
            r8 = r10;
        L13:
            return -1;
        L15:
            if (r5 >= (-16)) goto L33;
            byte r11 = (byte) (~(r6 >> 8));
            if (r11 != 0) goto L23;
            int r12 = r8 + 1;
            byte r13 = r7.get(r8);
            if (r12 >= r9) goto L21;
            r8 = r12;
            r11 = r13;
            goto L23
        L21:
            return Utf8.a(r5, r13);
        L23:
            if (r11 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r5 != (-32)) goto L28;
            if (r11 < (-96)) goto L32;
        L28:
            if (r5 != (-19)) goto L30;
            if (r11 >= (-96)) goto L32;
        L30:
            r10 = r8 + 1;
            if (r7.get(r8) <= (-65)) goto L12;
        L33:
            byte r0 = (byte) (~(r6 >> 8));
            byte r3 = 0;
            if (r0 != 0) goto L40;
            int r14 = r8 + 1;
            r0 = r7.get(r8);
            if (r14 >= r9) goto L38;
            r8 = r14;
        L41:
            if (r3 != 0) goto L47;
            int r15 = r8 + 1;
            r3 = r7.get(r8);
            if (r15 >= r9) goto L45;
            r8 = r15;
            goto L47
        L45:
            return Utf8.a(r5, r0, r3);
        L47:
            if (r0 <= (-65)) goto L49;
        L53:
            return -1;
        L49:
            if ((((r5 << 28) + (r0 + 112)) >> 30) != 0) goto L53;
            if (r3 > (-65)) goto L53;
            r10 = r8 + 1;
            if (r7.get(r8) <= (-65)) goto L12;
        L38:
            return Utf8.a(r5, r0);
        L40:
            r3 = (byte) (r6 >> 16);
        L55:
            return e(r7, r8, r9);
        }

        abstract String c(ByteBuffer r1, int r2, int r3);

        final String d(ByteBuffer r11, int r12, int r13) {
            if (((r12 | r13) | ((r11.limit() - r12) - r13)) < 0) goto L42;
            int r10 = r12 + r13;
            char[] r14 = new char[r13];
            int r2 = 0;
        L5:
            if (r12 >= r10) goto L10;
            byte r3 = r11.get(r12);
            if (a.a(r3) == false) goto L10;
            r12 = r12 + 1;
            a.a(r3, r14, r2);
            r2 = r2 + 1;
        L10:
            int r7 = r2;
        L11:
            if (r12 >= r10) goto L40;
            int r4 = r12 + 1;
            byte r15 = r11.get(r12);
            if (a.a(r15) == true) goto L14;
            if (a.b(r15) == true) goto L23;
            if (a.c(r15) == true) goto L30;
            if (r4 >= (r10 - 2)) goto L38;
            int r5 = r4 + 1;
            byte r6 = r11.get(r4);
            int r8 = r5 + 1;
            a.a(r15, r6, r11.get(r5), r11.get(r8), r14, r7);
            r12 = r8 + 1;
            r7 = (r7 + 1) + 1;
            goto L11
        L38:
            throw InvalidProtocolBufferException.invalidUtf8();
        L30:
            if (r4 >= (r10 - 1)) goto L33;
            int r9 = r4 + 1;
            a.a(r15, r11.get(r4), r11.get(r9), r14, r7);
            r12 = r9 + 1;
            r7 = r7 + 1;
            goto L11
        L33:
            throw InvalidProtocolBufferException.invalidUtf8();
        L23:
            if (r4 >= r10) goto L26;
            a.a(r15, r11.get(r4), r14, r7);
            r12 = r4 + 1;
            r7 = r7 + 1;
            goto L11
        L26:
            throw InvalidProtocolBufferException.invalidUtf8();
        L14:
            int r16 = r7 + 1;
            a.a(r15, r14, r7);
        L15:
            if (r4 >= r10) goto L20;
            byte r17 = r11.get(r4);
            if (a.a(r17) == false) goto L20;
            r4 = r4 + 1;
            a.a(r17, r14, r16);
            r16 = r16 + 1;
        L20:
            r12 = r4;
            r7 = r16;
            goto L11
        L40:
            return new String(r14, 0, r7);
        L42:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r11.limit()), Integer.valueOf(r12), Integer.valueOf(r13)}));
        }
    }

    static final class c extends b {
        c() {
        }

        private static int c(byte[] r1, int r2, int r3) {
        L2:
            if (r2 >= r3) goto L6;
            if (r1[r2] < 0) goto L6;
            r2 = r2 + 1;
        L6:
            if (r2 < r3) goto L9;
            return 0;
        L9:
            return d(r1, r2, r3);
        }

        private static int d(byte[] r6, int r7, int r8) {
        L2:
            if (r7 >= r8) goto L3;
            int r0 = r7 + 1;
            byte r9 = r6[r7];
            if (r9 >= 0) goto L46;
            if (r9 < (-32)) goto L9;
            if (r9 < (-16)) goto L19;
            if (r0 >= (r8 - 2)) goto L36;
            int r1 = r0 + 1;
            byte r2 = r6[r0];
            if (r2 > (-65)) goto L45;
            if ((((r9 << 28) + (r2 + 112)) >> 30) != 0) goto L45;
            int r10 = r1 + 1;
            if (r6[r1] > (-65)) goto L45;
            r0 = r10 + 1;
            if (r6[r10] <= (-65)) goto L46;
        L45:
            return -1;
        L36:
            return Utf8.c(r6, r0, r8);
        L19:
            if (r0 >= (r8 - 1)) goto L21;
            int r4 = r0 + 1;
            byte r3 = r6[r0];
            if (r3 > (-65)) goto L32;
            if (r9 != (-32)) goto L28;
            if (r3 < (-96)) goto L32;
        L28:
            if (r9 != (-19)) goto L30;
            if (r3 >= (-96)) goto L32;
        L30:
            r7 = r4 + 1;
            if (r6[r4] <= (-65)) goto L2;
        L32:
            return -1;
        L21:
            return Utf8.c(r6, r0, r8);
        L9:
            if (r0 >= r8) goto L10;
            if (r9 < (-62)) goto L15;
            r7 = r0 + 1;
            if (r6[r0] <= (-65)) goto L2;
        L15:
            return -1;
        L10:
            return r9;
        L46:
            r7 = r0;
            goto L2
        L3:
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        int a(int r6, byte[] r7, int r8, int r9) {
            if (r6 == 0) goto L55;
            if (r8 < r9) goto L5;
            return r6;
        L5:
            byte r5 = (byte) r6;
            if (r5 >= (-32)) goto L15;
            if (r5 < (-62)) goto L13;
            int r10 = r8 + 1;
            if (r7[r8] > (-65)) goto L13;
        L12:
            r8 = r10;
        L13:
            return -1;
        L15:
            if (r5 >= (-16)) goto L33;
            byte r11 = (byte) (~(r6 >> 8));
            if (r11 != 0) goto L23;
            int r12 = r8 + 1;
            byte r13 = r7[r8];
            if (r12 >= r9) goto L21;
            r8 = r12;
            r11 = r13;
            goto L23
        L21:
            return Utf8.a(r5, r13);
        L23:
            if (r11 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r5 != (-32)) goto L28;
            if (r11 < (-96)) goto L32;
        L28:
            if (r5 != (-19)) goto L30;
            if (r11 >= (-96)) goto L32;
        L30:
            r10 = r8 + 1;
            if (r7[r8] <= (-65)) goto L12;
        L33:
            byte r0 = (byte) (~(r6 >> 8));
            byte r3 = 0;
            if (r0 != 0) goto L40;
            int r14 = r8 + 1;
            r0 = r7[r8];
            if (r14 >= r9) goto L38;
            r8 = r14;
        L41:
            if (r3 != 0) goto L47;
            int r15 = r8 + 1;
            r3 = r7[r8];
            if (r15 >= r9) goto L45;
            r8 = r15;
            goto L47
        L45:
            return Utf8.a(r5, r0, r3);
        L47:
            if (r0 <= (-65)) goto L49;
        L53:
            return -1;
        L49:
            if ((((r5 << 28) + (r0 + 112)) >> 30) != 0) goto L53;
            if (r3 > (-65)) goto L53;
            r10 = r8 + 1;
            if (r7[r8] <= (-65)) goto L12;
        L38:
            return Utf8.a(r5, r0);
        L40:
            r3 = (byte) (r6 >> 16);
        L55:
            return c(r7, r8, r9);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        int a(CharSequence r7, byte[] r8, int r9, int r10) {
            CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.memorydata.plugin");
            int r11 = r6.length();
            int r12 = r10 + r9;
            int r0 = 0;
        L4:
            if (r0 >= r11) goto L10;
            int r2 = r0 + r9;
            if (r2 >= r12) goto L10;
            char r3 = r6.charAt(r0);
            if (r3 >= 128) goto L10;
            r8[r2] = (byte) r3;
            r0 = r0 + 1;
        L10:
            if (r0 == r11) goto L12;
            int r13 = r9 + r0;
        L14:
            if (r0 >= r11) goto L52;
            char r4 = r6.charAt(r0);
            if (r4 >= 128) goto L21;
            if (r13 >= r12) goto L21;
            int r5 = r13 + 1;
            r8[r13] = (byte) r4;
        L19:
            r13 = r5;
        L38:
            r0 = r0 + 1;
        L21:
            if (r4 >= 2048) goto L26;
            if (r13 > (r12 - 2)) goto L26;
            int r14 = r13 + 1;
            r8[r13] = (byte) ((r4 >>> 6) | 960);
            r13 = r14 + 1;
            r8[r14] = (byte) ((r4 & '?') | 128);
        L26:
            if (r4 < 55296) goto L29;
            if (57343 < r4) goto L29;
        L32:
            if (r13 > (r12 - 4)) goto L42;
            int r15 = r0 + 1;
            if (r15 == r6.length()) goto L41;
            char r1 = r6.charAt(r15);
            if (Character.isSurrogatePair(r4, r1) == false) goto L39;
            int r16 = Character.toCodePoint(r4, r1);
            int r17 = r13 + 1;
            r8[r13] = (byte) ((r16 >>> 18) | 240);
            int r18 = r17 + 1;
            r8[r17] = (byte) (((r16 >>> 12) & 63) | 128);
            int r19 = r18 + 1;
            r8[r18] = (byte) (((r16 >>> 6) & 63) | 128);
            r13 = r19 + 1;
            r8[r19] = (byte) ((r16 & 63) | 128);
            r0 = r15;
            goto L38
        L39:
            r0 = r15;
        L41:
            throw new UnpairedSurrogateException(r0 - 1, r11);
        L42:
            if (55296 > r4) goto L51;
            if (r4 > 57343) goto L51;
            int r20 = r0 + 1;
            if (r20 == r6.length()) goto L49;
            if (Character.isSurrogatePair(r4, r6.charAt(r20)) == true) goto L51;
        L49:
            throw new UnpairedSurrogateException(r0, r11);
        L51:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r4 + " at index " + r13);
        L29:
            if (r13 > (r12 - 3)) goto L32;
            int r21 = r13 + 1;
            r8[r13] = (byte) ((r4 >>> '\f') | 480);
            int r22 = r21 + 1;
            r8[r21] = (byte) (((r4 >>> 6) & 63) | 128);
            r5 = r22 + 1;
            r8[r22] = (byte) ((r4 & '?') | 128);
            goto L19
        L52:
            return r13;
        L12:
            return r9 + r11;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        int b(int r1, ByteBuffer r2, int r3, int r4) {
            return c(r1, r2, r3, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        String b(byte[] r11, int r12, int r13) {
            if (((r12 | r13) | ((r11.length - r12) - r13)) < 0) goto L42;
            int r10 = r12 + r13;
            char[] r14 = new char[r13];
            int r2 = 0;
        L5:
            if (r12 >= r10) goto L10;
            byte r3 = r11[r12];
            if (a.a(r3) == false) goto L10;
            r12 = r12 + 1;
            a.a(r3, r14, r2);
            r2 = r2 + 1;
        L10:
            int r7 = r2;
        L11:
            if (r12 >= r10) goto L40;
            int r4 = r12 + 1;
            byte r15 = r11[r12];
            if (a.a(r15) == true) goto L14;
            if (a.b(r15) == true) goto L23;
            if (a.c(r15) == true) goto L30;
            if (r4 >= (r10 - 2)) goto L38;
            int r5 = r4 + 1;
            byte r6 = r11[r4];
            int r8 = r5 + 1;
            a.a(r15, r6, r11[r5], r11[r8], r14, r7);
            r12 = r8 + 1;
            r7 = (r7 + 1) + 1;
            goto L11
        L38:
            throw InvalidProtocolBufferException.invalidUtf8();
        L30:
            if (r4 >= (r10 - 1)) goto L33;
            int r9 = r4 + 1;
            a.a(r15, r11[r4], r11[r9], r14, r7);
            r12 = r9 + 1;
            r7 = r7 + 1;
            goto L11
        L33:
            throw InvalidProtocolBufferException.invalidUtf8();
        L23:
            if (r4 >= r10) goto L26;
            a.a(r15, r11[r4], r14, r7);
            r12 = r4 + 1;
            r7 = r7 + 1;
            goto L11
        L26:
            throw InvalidProtocolBufferException.invalidUtf8();
        L14:
            int r16 = r7 + 1;
            a.a(r15, r14, r7);
        L15:
            if (r4 >= r10) goto L20;
            byte r17 = r11[r4];
            if (a.a(r17) == false) goto L20;
            r4 = r4 + 1;
            a.a(r17, r14, r16);
            r16 = r16 + 1;
        L20:
            r12 = r4;
            r7 = r16;
            goto L11
        L40:
            return new String(r14, 0, r7);
        L42:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(r11.length), Integer.valueOf(r12), Integer.valueOf(r13)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        String c(ByteBuffer r1, int r2, int r3) {
            return d(r1, r2, r3);
        }
    }

    static final class d extends b {
        d() {
        }

        private static int a(long r5, int r7) {
            if (r7 >= 16) goto L6;
            return 0;
        L6:
            int r0 = (int) ((-r5) & 7);
            int r1 = r0;
        L7:
            if (r1 <= 0) goto L13;
            long r2 = 1 + r5;
            if (bx.a(r5) < 0) goto L11;
            r1 = r1 - 1;
            r5 = r2;
            goto L7
        L11:
            return r0 - r1;
        L13:
            int r3 = r7 - r0;
        L15:
            if (r3 < 8) goto L20;
            if ((bx.b(r5) & (-9187201950435737472L)) != 0) goto L20;
            r5 = r5 + 8;
            r3 = r3 - 8;
        L20:
            return r7 - r3;
        }

        private static int a(long r2, int r4, int r5) {
            if (r5 == 0) goto L14;
            if (r5 == 1) goto L12;
            if (r5 != 2) goto L10;
            return Utf8.a(r4, bx.a(r2), bx.a(r2 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.a(r4, bx.a(r2));
        L14:
            return Utf8.a(r4);
        }

        private static int a(byte[] r2, int r3, long r4, int r6) {
            if (r6 == 0) goto L14;
            if (r6 == 1) goto L12;
            if (r6 != 2) goto L10;
            return Utf8.a(r3, bx.a(r2, r4), bx.a(r2, r4 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.a(r3, bx.a(r2, r4));
        L14:
            return Utf8.a(r3);
        }

        private static int a(byte[] r8, long r9, int r11) {
            int r0 = 0;
            if (r11 >= 16) goto L5;
            return 0;
        L5:
            int r1 = 8 - (((int) r9) & 7);
        L7:
            if (r0 >= r1) goto L12;
            long r2 = 1 + r9;
            if (bx.a(r8, r9) < 0) goto L10;
            r0 = r0 + 1;
            r9 = r2;
            goto L7
        L10:
            return r0;
        L12:
            int r3 = r0 + 8;
            if (r3 > r11) goto L18;
            if ((bx.b(r8, bx.f5008a + r9) & (-9187201950435737472L)) != 0) goto L18;
            r9 = r9 + 8;
            r0 = r3;
        L18:
            if (r0 >= r11) goto L23;
            long r4 = r9 + 1;
            if (bx.a(r8, r9) < 0) goto L21;
            r0 = r0 + 1;
            r9 = r4;
            goto L18
        L21:
            return r0;
        L23:
            return r11;
        }

        static boolean a() {
            if (bx.a() == true) goto L5;
        L7:
            return false;
        L5:
            if (bx.b() == false) goto L7;
            return true;
        }

        private static int b(long r8, int r10) {
            int r0 = a(r8, r10);
            long r9 = r8 + ((long) r0);
            int r11 = r10 - r0;
        L3:
            byte r1 = 0;
        L5:
            if (r11 <= 0) goto L10;
            long r4 = r9 + 1;
            r1 = bx.a(r9);
            if (r1 < 0) goto L9;
            r11 = r11 - 1;
            r9 = r4;
            goto L5
        L9:
            r9 = r4;
        L10:
            if (r11 == 0) goto L11;
            int r12 = r11 - 1;
            if (r1 >= (-32)) goto L24;
            if (r12 == 0) goto L15;
            r11 = r12 - 1;
            if (r1 < (-62)) goto L22;
            long r2 = 1 + r9;
            if (bx.a(r9) > (-65)) goto L22;
        L21:
            r9 = r2;
        L22:
            return -1;
        L15:
            return r1;
        L24:
            if (r1 >= (-16)) goto L41;
            if (r12 < 2) goto L28;
            r11 = r12 - 2;
            long r6 = r9 + 1;
            byte r13 = bx.a(r9);
            if (r13 > (-65)) goto L39;
            if (r1 != (-32)) goto L35;
            if (r13 < (-96)) goto L39;
        L35:
            if (r1 != (-19)) goto L37;
            if (r13 >= (-96)) goto L39;
        L37:
            r2 = 1 + r6;
            if (bx.a(r6) <= (-65)) goto L21;
        L39:
            return -1;
        L28:
            return a(r9, r1, r12);
        L41:
            if (r12 < 3) goto L43;
            r11 = r12 - 3;
            long r7 = r9 + 1;
            byte r14 = bx.a(r9);
            if (r14 > (-65)) goto L52;
            if ((((r1 << 28) + (r14 + 112)) >> 30) != 0) goto L52;
            long r15 = r7 + 1;
            if (bx.a(r7) > (-65)) goto L52;
            r2 = 1 + r15;
            if (bx.a(r15) <= (-65)) goto L21;
        L52:
            return -1;
        L43:
            return a(r9, r1, r12);
        L11:
            return 0;
        }

        private static int b(byte[] r8, long r9, int r11) {
            int r0 = a(r8, r9, r11);
            int r12 = r11 - r0;
            long r10 = r9 + ((long) r0);
        L3:
            byte r1 = 0;
        L5:
            if (r12 <= 0) goto L10;
            long r4 = r10 + 1;
            r1 = bx.a(r8, r10);
            if (r1 < 0) goto L9;
            r12 = r12 - 1;
            r10 = r4;
            goto L5
        L9:
            r10 = r4;
        L10:
            if (r12 == 0) goto L11;
            int r13 = r12 - 1;
            if (r1 >= (-32)) goto L24;
            if (r13 == 0) goto L15;
            r12 = r13 - 1;
            if (r1 < (-62)) goto L22;
            long r2 = 1 + r10;
            if (bx.a(r8, r10) > (-65)) goto L22;
        L21:
            r10 = r2;
        L22:
            return -1;
        L15:
            return r1;
        L24:
            if (r1 >= (-16)) goto L41;
            if (r13 < 2) goto L28;
            r12 = r13 - 2;
            long r6 = r10 + 1;
            byte r14 = bx.a(r8, r10);
            if (r14 > (-65)) goto L39;
            if (r1 != (-32)) goto L35;
            if (r14 < (-96)) goto L39;
        L35:
            if (r1 != (-19)) goto L37;
            if (r14 >= (-96)) goto L39;
        L37:
            r2 = 1 + r6;
            if (bx.a(r8, r6) <= (-65)) goto L21;
        L39:
            return -1;
        L28:
            return a(r8, r1, r10, r13);
        L41:
            if (r13 < 3) goto L43;
            r12 = r13 - 3;
            long r7 = r10 + 1;
            byte r15 = bx.a(r8, r10);
            if (r15 > (-65)) goto L52;
            if ((((r1 << 28) + (r15 + 112)) >> 30) != 0) goto L52;
            long r16 = r7 + 1;
            if (bx.a(r8, r7) > (-65)) goto L52;
            r2 = 1 + r16;
            if (bx.a(r8, r16) <= (-65)) goto L21;
        L52:
            return -1;
        L43:
            return a(r8, r1, r10, r13);
        L11:
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        int a(int r11, byte[] r12, int r13, int r14) {
            byte r0 = 0;
            if (((r13 | r14) | (r12.length - r14)) < 0) goto L63;
            long r1 = r13;
            long r15 = r14;
            if (r11 == 0) goto L61;
            if (r1 < r15) goto L9;
            return r11;
        L9:
            byte r10 = (byte) r11;
            if (r10 >= (-32)) goto L19;
            if (r10 < (-62)) goto L17;
            long r6 = 1 + r1;
            if (bx.a(r12, r1) > (-65)) goto L17;
            r1 = r6;
        L17:
            return -1;
        L19:
            if (r10 >= (-16)) goto L39;
            byte r16 = (byte) (~(r11 >> 8));
            if (r16 != 0) goto L27;
            long r8 = r1 + 1;
            r16 = bx.a(r12, r1);
            if (r8 >= r15) goto L25;
            r1 = r8;
            goto L27
        L25:
            return Utf8.a(r10, r16);
        L27:
            if (r16 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r10 != (-32)) goto L32;
            if (r16 < (-96)) goto L38;
        L32:
            if (r10 != (-19)) goto L34;
            if (r16 >= (-96)) goto L38;
        L34:
            long r17 = r1 + 1;
            if (bx.a(r12, r1) > (-65)) goto L38;
        L37:
            r1 = r17;
            goto L61
        L39:
            byte r3 = (byte) (~(r11 >> 8));
            if (r3 != 0) goto L46;
            long r9 = r1 + 1;
            r3 = bx.a(r12, r1);
            if (r9 >= r15) goto L44;
            r1 = r9;
        L47:
            if (r0 != 0) goto L53;
            long r18 = r1 + 1;
            r0 = bx.a(r12, r1);
            if (r18 >= r15) goto L51;
            r1 = r18;
            goto L53
        L51:
            return Utf8.a(r10, r3, r0);
        L53:
            if (r3 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r10 << 28) + (r3 + 112)) >> 30) != 0) goto L59;
            if (r0 > (-65)) goto L59;
            r17 = r1 + 1;
            if (bx.a(r12, r1) <= (-65)) goto L37;
        L44:
            return Utf8.a(r10, r3);
        L46:
            r0 = (byte) (r11 >> 16);
        L61:
            return b(r12, r1, (int) (r15 - r1));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r12.length), Integer.valueOf(r13), Integer.valueOf(r14)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        int a(CharSequence r21, byte[] r22, int r23, int r24) {
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
            long r4 = r23;
            long r6 = ((long) r24) + r4;
            int r8 = r3.length();
            if (r8 > r24) goto L56;
            if ((r22.length - r24) < r23) goto L56;
            int r1 = 0;
        L7:
            char r2 = 128;
            long r11 = 1;
            if (r1 >= r8) goto L12;
            char r13 = r3.charAt(r1);
            if (r13 >= 128) goto L12;
            bx.a(r22, r4, (byte) r13);
            r1 = r1 + 1;
            r4 = 1 + r4;
        L12:
            if (r1 == r8) goto L14;
        L15:
            if (r1 >= r8) goto L54;
            char r14 = r3.charAt(r1);
            if (r14 >= r2) goto L22;
            if (r4 >= r6) goto L22;
            long r15 = r4 + r11;
            bx.a(r22, r4, (byte) r14);
            long r5 = r11;
            long r12 = r15;
            char r16 = r2;
        L39:
            r1 = r1 + 1;
            r2 = r16;
            long r18 = r5;
            r4 = r12;
            r11 = r18;
        L22:
            if (r14 >= 2048) goto L27;
            if (r4 > (r6 - 2)) goto L27;
            long r17 = r4 + r11;
            bx.a(r22, r4, (byte) ((r14 >>> 6) | 960));
            long r7 = r17 + r11;
            bx.a(r22, r17, (byte) ((r14 & '?') | 128));
            long r19 = r11;
            r16 = 128;
            r12 = r7;
            r5 = r19;
        L27:
            if (r14 < 55296) goto L30;
            if (57343 < r14) goto L30;
        L33:
            if (r4 > (r6 - 4)) goto L43;
            int r9 = r1 + 1;
            if (r9 == r8) goto L42;
            char r10 = r3.charAt(r9);
            if (Character.isSurrogatePair(r14, r10) == false) goto L40;
            int r20 = Character.toCodePoint(r14, r10);
            long r110 = r4 + 1;
            bx.a(r22, r4, (byte) ((r20 >>> 18) | 240));
            long r25 = r110 + 1;
            r16 = 128;
            bx.a(r22, r110, (byte) (((r20 >>> 12) & 63) | 128));
            long r111 = r25 + 1;
            bx.a(r22, r25, (byte) (((r20 >>> 6) & 63) | 128));
            r5 = 1;
            r12 = r111 + 1;
            bx.a(r22, r111, (byte) ((r20 & 63) | 128));
            r1 = r9;
            goto L39
        L40:
            r1 = r9;
        L42:
            throw new UnpairedSurrogateException(r1 - 1, r8);
        L43:
            if (55296 > r14) goto L52;
            if (r14 > 57343) goto L52;
            int r0 = r1 + 1;
            if (r0 == r8) goto L50;
            if (Character.isSurrogatePair(r14, r3.charAt(r0)) == true) goto L52;
        L50:
            throw new UnpairedSurrogateException(r1, r8);
        L52:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r14 + " at index " + r4);
        L30:
            if (r4 > (r6 - 3)) goto L33;
            long r112 = r4 + r11;
            bx.a(r22, r4, (byte) ((r14 >>> '\f') | 480));
            long r26 = r112 + r11;
            bx.a(r22, r112, (byte) (((r14 >>> 6) & 63) | 128));
            bx.a(r22, r26, (byte) ((r14 & '?') | 128));
            r12 = r26 + 1;
            r5 = 1;
            r16 = 128;
            goto L39
        L54:
            return (int) r4;
        L14:
            return (int) r4;
        L56:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r3.charAt(r8 - 1) + " at index " + (r23 + r24));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        int b(int r10, ByteBuffer r11, int r12, int r13) {
            byte r0 = 0;
            if (((r12 | r13) | (r11.limit() - r13)) < 0) goto L63;
            long r1 = bx.a(r11) + ((long) r12);
            long r14 = ((long) (r13 - r12)) + r1;
            if (r10 == 0) goto L61;
            if (r1 < r14) goto L9;
            return r10;
        L9:
            byte r9 = (byte) r10;
            if (r9 >= (-32)) goto L19;
            if (r9 < (-62)) goto L17;
            long r5 = 1 + r1;
            if (bx.a(r1) > (-65)) goto L17;
            r1 = r5;
        L17:
            return -1;
        L19:
            if (r9 >= (-16)) goto L39;
            byte r15 = (byte) (~(r10 >> 8));
            if (r15 != 0) goto L27;
            long r7 = r1 + 1;
            r15 = bx.a(r1);
            if (r7 >= r14) goto L25;
            r1 = r7;
            goto L27
        L25:
            return Utf8.a(r9, r15);
        L27:
            if (r15 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r9 != (-32)) goto L32;
            if (r15 < (-96)) goto L38;
        L32:
            if (r9 != (-19)) goto L34;
            if (r15 >= (-96)) goto L38;
        L34:
            long r16 = r1 + 1;
            if (bx.a(r1) > (-65)) goto L38;
        L37:
            r1 = r16;
            goto L61
        L39:
            byte r17 = (byte) (~(r10 >> 8));
            if (r17 != 0) goto L46;
            long r8 = r1 + 1;
            r17 = bx.a(r1);
            if (r8 >= r14) goto L44;
            r1 = r8;
        L47:
            if (r0 != 0) goto L53;
            long r18 = r1 + 1;
            r0 = bx.a(r1);
            if (r18 >= r14) goto L51;
            r1 = r18;
            goto L53
        L51:
            return Utf8.a(r9, r17, r0);
        L53:
            if (r17 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r9 << 28) + (r17 + 112)) >> 30) != 0) goto L59;
            if (r0 > (-65)) goto L59;
            r16 = r1 + 1;
            if (bx.a(r1) <= (-65)) goto L37;
        L44:
            return Utf8.a(r9, r17);
        L46:
            r0 = (byte) (r10 >> 16);
        L61:
            return b(r1, (int) (r14 - r1));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r11.limit()), Integer.valueOf(r12), Integer.valueOf(r13)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        String b(byte[] r2, int r3, int r4) {
            String r1 = new String(r2, r3, r4, ab.f4938b);
            if (r1.contains("�") == true) goto L6;
            return r1;
        L6:
            if (Arrays.equals(r1.getBytes(ab.f4938b), Arrays.copyOfRange(r2, r3, r4 + r3)) == false) goto L9;
            return r1;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        String c(ByteBuffer r18, int r19, int r20) {
            if (((r19 | r20) | ((r18.limit() - r19) - r20)) < 0) goto L46;
            long r5 = bx.a(r18) + ((long) r19);
            long r7 = ((long) r20) + r5;
            char[] r0 = new char[r20];
            int r1 = 0;
        L6:
            if (r5 >= r7) goto L11;
            byte r2 = bx.a(r5);
            if (a.a(r2) == false) goto L11;
            r5 = r5 + 1;
            a.a(r2, r0, r1);
            r1 = r1 + 1;
        L11:
            int r14 = r1;
        L13:
            if (r5 >= r7) goto L44;
            long r3 = r5 + 1;
            byte r9 = bx.a(r5);
            if (a.a(r9) == true) goto L16;
            if (a.b(r9) == true) goto L27;
            if (a.c(r9) == false) goto L39;
            if (r3 >= (r7 - 1)) goto L37;
            long r6 = r3 + 1;
            a.a(r9, bx.a(r3), bx.a(r6), r0, r14);
            r14 = r14 + 1;
            r5 = r6 + 1;
            goto L13
        L37:
            throw InvalidProtocolBufferException.invalidUtf8();
        L39:
            if (r3 >= (r7 - 2)) goto L42;
            long r8 = r3 + 1;
            byte r10 = bx.a(r3);
            long r4 = r8 + 1;
            byte r11 = bx.a(r8);
            r5 = r4 + 1;
            a.a(r9, r10, r11, bx.a(r4), r0, r14);
            r1 = (r14 + 1) + 1;
            goto L11
        L42:
            throw InvalidProtocolBufferException.invalidUtf8();
        L27:
            if (r3 >= r7) goto L30;
            r5 = r3 + 1;
            a.a(r9, bx.a(r3), r0, r14);
            r14 = r14 + 1;
            goto L13
        L30:
            throw InvalidProtocolBufferException.invalidUtf8();
        L16:
            int r12 = r14 + 1;
            a.a(r9, r0, r14);
        L18:
            if (r3 >= r7) goto L23;
            byte r13 = bx.a(r3);
            if (a.a(r13) == false) goto L23;
            r3 = r3 + 1;
            a.a(r13, r0, r12);
            r12 = r12 + 1;
        L23:
            r14 = r12;
            r5 = r3;
            goto L13
        L44:
            return new String(r0, 0, r14);
        L46:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r18.limit()), Integer.valueOf(r19), Integer.valueOf(r20)}));
        }
    }

    static {
        if (d.a() == true) goto L5;
    L7:
        b r0 = new c();
    L8:
        f4929a = r0;
        return;
    L5:
        if (com.google.crypto.tink.shaded.protobuf.d.a() == true) goto L7;
        r0 = new d();
        goto L8
    }

    static /* synthetic */ int a(int r0) {
        return b(r0);
    }

    static /* synthetic */ int a(int r0, int r1) {
        return b(r0, r1);
    }

    static /* synthetic */ int a(int r0, int r1, int r2) {
        return b(r0, r1, r2);
    }

    static int a(int r1, ByteBuffer r2, int r3, int r4) {
        return f4929a.a(r1, r2, r3, r4);
    }

    static int a(int r1, byte[] r2, int r3, int r4) {
        return f4929a.a(r1, r2, r3, r4);
    }

    static int a(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r6.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L7;
        if (r6.charAt(r1) >= 128) goto L7;
        r1 = r1 + 1;
    L7:
        int r2 = r0;
    L8:
        if (r1 >= r0) goto L13;
        char r3 = r6.charAt(r1);
        if (r3 >= 2048) goto L12;
        r2 = r2 + ((127 - r3) >>> 31);
        r1 = r1 + 1;
        goto L8
    L12:
        r2 = r2 + a(r6, r1);
    L13:
        if (r2 < r0) goto L16;
        return r2;
    L16:
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) r2) + 4294967296L));
    }

    private static int a(CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
        int r0 = r6.length();
        int r1 = 0;
    L3:
        if (r5 >= r0) goto L17;
        char r2 = r6.charAt(r5);
        if (r2 >= 2048) goto L7;
        r1 = r1 + ((127 - r2) >>> 31);
    L16:
        r5 = r5 + 1;
        goto L3
    L7:
        r1 = r1 + 2;
        if (55296 > r2) goto L16;
        if (r2 > 57343) goto L16;
        if (Character.codePointAt(r6, r5) < 65536) goto L15;
        r5 = r5 + 1;
        goto L16
    L15:
        throw new UnpairedSurrogateException(r5, r0);
    L17:
        return r1;
    }

    static int a(CharSequence r2, byte[] r3, int r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        return f4929a.a(r6, r3, r4, r5);
    }

    static /* synthetic */ int a(ByteBuffer r0, int r1, int r2, int r3) {
        return b(r0, r1, r2, r3);
    }

    static String a(ByteBuffer r1, int r2, int r3) {
        return f4929a.b(r1, r2, r3);
    }

    static boolean a(ByteBuffer r3) {
        return f4929a.a(r3, r3.position(), r3.remaining());
    }

    static boolean a(byte[] r3) {
        return f4929a.a(r3, 0, r3.length);
    }

    static boolean a(byte[] r1, int r2, int r3) {
        return f4929a.a(r1, r2, r3);
    }

    private static int b(int r1) {
        if (r1 <= (-12)) goto L6;
        return -1;
    L6:
        return r1;
    }

    private static int b(int r1, int r2) {
        if (r1 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (r2 > (-65)) goto L8;
        return r1 ^ (r2 << 8);
    }

    private static int b(int r1, int r2, int r3) {
        if (r1 <= (-12)) goto L5;
    L9:
        return -1;
    L5:
        if (r2 > (-65)) goto L9;
        if (r3 > (-65)) goto L9;
        return (r1 ^ (r2 << 8)) ^ (r3 << 16);
    }

    static /* synthetic */ int b(ByteBuffer r0, int r1, int r2) {
        return c(r0, r1, r2);
    }

    private static int b(ByteBuffer r2, int r3, int r4, int r5) {
        if (r5 == 0) goto L14;
        if (r5 == 1) goto L12;
        if (r5 != 2) goto L10;
        return b(r3, r2.get(r4), r2.get(r4 + 1));
    L10:
        throw new AssertionError();
    L12:
        return b(r3, r2.get(r4));
    L14:
        return b(r3);
    }

    static String b(byte[] r1, int r2, int r3) {
        return f4929a.b(r1, r2, r3);
    }

    private static int c(ByteBuffer r5, int r6, int r7) {
        int r8 = r7 - 7;
        int r0 = r6;
    L3:
        if (r0 >= r8) goto L8;
        if ((r5.getLong(r0) & (-9187201950435737472L)) != 0) goto L8;
        r0 = r0 + 8;
    L8:
        return r0 - r6;
    }

    static /* synthetic */ int c(byte[] r0, int r1, int r2) {
        return d(r0, r1, r2);
    }

    private static int d(byte[] r3, int r4, int r5) {
        byte r0 = r3[r4 - 1];
        int r6 = r5 - r4;
        if (r6 == 0) goto L15;
        if (r6 == 1) goto L13;
        if (r6 != 2) goto L11;
        return b(r0, r3[r4], r3[r4 + 1]);
    L11:
        throw new AssertionError();
    L13:
        return b(r0, r3[r4]);
    L15:
        return b(r0);
    }
}
