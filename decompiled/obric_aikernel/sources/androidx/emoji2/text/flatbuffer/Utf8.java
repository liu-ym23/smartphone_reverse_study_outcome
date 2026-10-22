package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class Utf8 {
    private static Utf8 DEFAULT;

    static class DecodeUtil {
        DecodeUtil() {
        }

        static void handleFourBytes(byte r10, byte r11, byte r12, byte r13, char[] r14, int r15) {
            if (isNotTrailingByte(r11) == true) goto L13;
            if ((((r10 << 28) + (r11 + 112)) >> 30) != 0) goto L13;
            if (isNotTrailingByte(r12) == true) goto L13;
            if (isNotTrailingByte(r13) == true) goto L13;
            int r16 = ((((r10 & 7) << 18) | (trailingByteValue(r11) << 12)) | (trailingByteValue(r12) << 6)) | trailingByteValue(r13);
            r14[r15] = highSurrogate(r16);
            r14[r15 + 1] = lowSurrogate(r16);
            return;
        L13:
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        static void handleOneByte(byte r10, char[] r11, int r12) {
            r11[r12] = (char) r10;
        }

        static void handleThreeBytes(byte r10, byte r11, byte r12, char[] r13, int r14) {
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
            throw new IllegalArgumentException("Invalid UTF-8");
        }

        static void handleTwoBytes(byte r10, byte r11, char[] r12, int r13) {
            if (r10 < (-62)) goto L11;
            if (isNotTrailingByte(r11) == true) goto L9;
            r12[r13] = (char) (((r10 & 31) << 6) | trailingByteValue(r11));
            return;
        L9:
            throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
        L11:
            throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
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

        static boolean isOneByte(byte r10) {
            if (r10 < 0) goto L4;
            return true;
        L4:
            return false;
        }

        static boolean isThreeBytes(byte r10) {
            if (r10 >= (-16)) goto L5;
            return true;
        L5:
            return false;
        }

        static boolean isTwoBytes(byte r10) {
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

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int r10, int r11) {
            super("Unpaired surrogate at index " + r10 + " of " + r11);
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

    public static void setDefault(Utf8 r10) {
        DEFAULT = r10;
    }

    public abstract String decodeUtf8(ByteBuffer r10, int r11, int r12);

    public abstract void encodeUtf8(CharSequence r10, ByteBuffer r11);

    public abstract int encodedLength(CharSequence r10);
}
