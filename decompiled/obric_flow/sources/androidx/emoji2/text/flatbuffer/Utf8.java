package androidx.emoji2.text.flatbuffer;

import ai.j0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class Utf8 {
    private static Utf8 DEFAULT;

    public static class DecodeUtil {
        public DecodeUtil() {
        }

        public static void handleFourBytes(byte r5, byte r10, byte r11, byte r12, char[] r13, int r14) throws IllegalArgumentException {
            if (isNotTrailingByte(r10) == true) goto L13;
            int r15 = r10 + 112;
            if (((r15 + (r5 << 28)) >> 30) != 0) goto L13;
            if (isNotTrailingByte(r11) == true) goto L13;
            if (isNotTrailingByte(r12) == true) goto L13;
            int r16 = ((((r5 & 7) << 18) | (trailingByteValue(r10) << 12)) | (trailingByteValue(r11) << 6)) | trailingByteValue(r12);
            r13[r14] = highSurrogate(r16);
            r13[r14 + 1] = lowSurrogate(r16);
            return;
        L13:
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        public static void handleOneByte(byte r5, char[] r10, int r11) {
            r10[r11] = (char) r5;
        }

        public static void handleThreeBytes(byte r5, byte r10, byte r11, char[] r12, int r13) throws IllegalArgumentException {
            if (isNotTrailingByte(r10) == true) goto L15;
            if (r5 != (-32)) goto L8;
            if (r10 < (-96)) goto L15;
        L8:
            if (r5 != (-19)) goto L11;
            if (r10 >= (-96)) goto L15;
        L11:
            if (isNotTrailingByte(r11) == true) goto L15;
            r12[r13] = (char) ((((r5 & 15) << 12) | (trailingByteValue(r10) << 6)) | trailingByteValue(r11));
            return;
        L15:
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        public static void handleTwoBytes(byte r5, byte r10, char[] r11, int r12) throws IllegalArgumentException {
            if (r5 < (-62)) goto L11;
            if (isNotTrailingByte(r10) == true) goto L9;
            r11[r12] = (char) (((r5 & 31) << 6) | trailingByteValue(r10));
            return;
        L9:
            throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
        L11:
            throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
        }

        private static char highSurrogate(int r5) {
            return (char) ((r5 >>> 10) + 55232);
        }

        private static boolean isNotTrailingByte(byte r5) {
            if (r5 <= (-65)) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean isOneByte(byte r5) {
            if (r5 < 0) goto L4;
            return true;
        L4:
            return false;
        }

        public static boolean isThreeBytes(byte r5) {
            if (r5 >= (-16)) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean isTwoBytes(byte r5) {
            if (r5 >= (-32)) goto L5;
            return true;
        L5:
            return false;
        }

        private static char lowSurrogate(int r5) {
            return (char) ((r5 & 1023) + 56320);
        }

        private static int trailingByteValue(byte r5) {
            return r5 & 63;
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int r5, int r10) {
            super(j0.f(r5, r10, "Unpaired surrogate at index ", " of "));
        }
    }

    public Utf8() {
    }

    public static Utf8 getDefault() {
        if (DEFAULT != null) goto L6;
        DEFAULT = new Utf8Safe();
    L6:
        return DEFAULT;
    }

    public static void setDefault(Utf8 r5) {
        DEFAULT = r5;
    }

    public abstract String decodeUtf8(ByteBuffer r5, int r10, int r11);

    public abstract void encodeUtf8(CharSequence r5, ByteBuffer r10);

    public abstract int encodedLength(CharSequence r5);
}
