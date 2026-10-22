package kotlin.reflect.jvm.internal.impl.protobuf;

/* JADX INFO: loaded from: classes3.dex */
final class Utf8 {
    private static int incompleteStateFor(int r5) {
        if (r5 <= (-12)) goto L6;
        return -1;
    L6:
        return r5;
    }

    public static boolean isValidUtf8(byte[] r5) {
        return isValidUtf8(r5, 0, r5.length);
    }

    public static int partialIsValidUtf8(int r10, byte[] r11, int r12, int r13) {
        if (r10 == 0) goto L55;
        if (r12 < r13) goto L5;
        return r10;
    L5:
        byte r5 = (byte) r10;
        if (r5 >= (-32)) goto L15;
        if (r5 < (-62)) goto L13;
        int r14 = r12 + 1;
        if (r11[r12] > (-65)) goto L13;
    L12:
        r12 = r14;
    L13:
        return -1;
    L15:
        if (r5 >= (-16)) goto L33;
        byte r15 = (byte) (~(r10 >> 8));
        if (r15 != 0) goto L23;
        int r16 = r12 + 1;
        byte r17 = r11[r12];
        if (r16 >= r13) goto L21;
        r12 = r16;
        r15 = r17;
        goto L23
    L21:
        return incompleteStateFor(r5, r17);
    L23:
        if (r15 <= (-65)) goto L25;
    L32:
        return -1;
    L25:
        if (r5 != (-32)) goto L28;
        if (r15 < (-96)) goto L32;
    L28:
        if (r5 != (-19)) goto L30;
        if (r15 >= (-96)) goto L32;
    L30:
        r14 = r12 + 1;
        if (r11[r12] <= (-65)) goto L12;
    L33:
        byte r18 = (byte) (~(r10 >> 8));
        if (r18 != 0) goto L40;
        int r19 = r12 + 1;
        r18 = r11[r12];
        if (r19 >= r13) goto L38;
        byte r20 = 0;
    L41:
        if (r20 != 0) goto L47;
        int r21 = r19 + 1;
        byte r22 = r11[r19];
        if (r21 >= r13) goto L45;
        r20 = r22;
        r19 = r21;
        goto L47
    L45:
        return incompleteStateFor(r5, r18, r22);
    L47:
        if (r18 > (-65)) goto L53;
        int r23 = r18 + 112;
        if (((r23 + (r5 << 28)) >> 30) != 0) goto L53;
        if (r20 > (-65)) goto L53;
        r12 = r19 + 1;
        if (r11[r19] <= (-65)) goto L55;
    L53:
        return -1;
    L38:
        return incompleteStateFor(r5, r18);
    L40:
        r20 = (byte) (r10 >> 16);
        r19 = r12;
    L55:
        return partialIsValidUtf8(r11, r12, r13);
    }

    private static int partialIsValidUtf8NonAscii(byte[] r10, int r11, int r12) {
    L2:
        if (r11 >= r12) goto L3;
        int r5 = r11 + 1;
        byte r13 = r10[r11];
        if (r13 < 0) goto L8;
        r11 = r5;
        goto L2
    L8:
        if (r13 < (-32)) goto L9;
        if (r13 < (-16)) goto L19;
        if (r5 >= (r12 - 2)) goto L36;
        int r14 = r11 + 2;
        byte r15 = r10[r5];
        if (r15 > (-65)) goto L45;
        if ((((r15 + 112) + (r13 << 28)) >> 30) != 0) goto L45;
        int r16 = r11 + 3;
        if (r10[r14] > (-65)) goto L45;
        r11 = r11 + 4;
        if (r10[r16] <= (-65)) goto L2;
    L45:
        return -1;
    L36:
        return incompleteStateFor(r10, r5, r12);
    L19:
        if (r5 >= (r12 - 1)) goto L21;
        int r17 = r11 + 2;
        byte r18 = r10[r5];
        if (r18 > (-65)) goto L32;
        if (r13 != (-32)) goto L28;
        if (r18 < (-96)) goto L32;
    L28:
        if (r13 != (-19)) goto L30;
        if (r18 >= (-96)) goto L32;
    L30:
        r11 = r11 + 3;
        if (r10[r17] <= (-65)) goto L2;
    L32:
        return -1;
    L21:
        return incompleteStateFor(r10, r5, r12);
    L9:
        if (r5 >= r12) goto L10;
        if (r13 < (-62)) goto L15;
        r11 = r11 + 2;
        if (r10[r5] <= (-65)) goto L2;
    L15:
        return -1;
    L10:
        return r13;
    L3:
        return 0;
    }

    private static int incompleteStateFor(int r5, int r10) {
        if (r5 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (r10 > (-65)) goto L8;
        return r5 ^ (r10 << 8);
    }

    public static boolean isValidUtf8(byte[] r5, int r10, int r11) {
        if (partialIsValidUtf8(r5, r10, r11) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static int incompleteStateFor(int r5, int r10, int r11) {
        if (r5 <= (-12)) goto L5;
    L9:
        return -1;
    L5:
        if (r10 > (-65)) goto L9;
        if (r11 > (-65)) goto L9;
        return (r5 ^ (r10 << 8)) ^ (r11 << 16);
    }

    private static int incompleteStateFor(byte[] r5, int r10, int r11) {
        byte r12 = r5[r10 - 1];
        int r13 = r11 - r10;
        if (r13 == 0) goto L15;
        if (r13 == 1) goto L13;
        if (r13 != 2) goto L11;
        return incompleteStateFor(r12, r5[r10], r5[r10 + 1]);
    L11:
        throw new AssertionError();
    L13:
        return incompleteStateFor(r12, r5[r10]);
    L15:
        return incompleteStateFor(r12);
    }

    public static int partialIsValidUtf8(byte[] r5, int r10, int r11) {
    L2:
        if (r10 >= r11) goto L6;
        if (r5[r10] < 0) goto L6;
        r10 = r10 + 1;
    L6:
        if (r10 < r11) goto L9;
        return 0;
    L9:
        return partialIsValidUtf8NonAscii(r5, r10, r11);
    }
}
