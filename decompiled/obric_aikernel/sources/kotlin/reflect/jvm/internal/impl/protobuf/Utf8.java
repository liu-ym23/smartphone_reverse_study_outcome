package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX INFO: loaded from: classes3.dex */
final class Utf8 {
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

    public static boolean isValidUtf8(byte[] r10) {
        return isValidUtf8(r10, 0, r10.length);
    }

    public static boolean isValidUtf8(byte[] r10, int r11, int r12) {
        if (partialIsValidUtf8(r10, r11, r12) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13) {
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
        return incompleteStateFor(r14, r18);
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
        return incompleteStateFor(r14, r19, r20);
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
        return incompleteStateFor(r14, r19);
    L40:
        r20 = (byte) (r10 >> 16);
    L55:
        return partialIsValidUtf8(r11, r12, r13);
    }

    public static int partialIsValidUtf8(byte[] r10, int r11, int r12) {
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
        return incompleteStateFor(r10, r13, r12);
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
        return incompleteStateFor(r10, r13, r12);
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
}
