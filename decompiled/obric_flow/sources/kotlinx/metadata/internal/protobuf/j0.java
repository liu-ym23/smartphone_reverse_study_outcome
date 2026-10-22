package kotlinx.metadata.internal.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f19178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i0 f19179b = null;

    static {
        f19178a = new h0();
        f19179b = new i0();
    }

    public static int a(int r5, int r10) {
        if (r5 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (r10 > (-65)) goto L8;
        return r5 ^ (r10 << 8);
    }

    public static int b(byte[] r5, int r10, int r11) {
        byte r12 = r5[r10 - 1];
        int r13 = r11 - r10;
        if (r13 != 0) goto L5;
        if (r12 > (-12)) goto L22;
        return r12;
    L22:
        return -1;
    L5:
        if (r13 == 1) goto L19;
        if (r13 != 2) goto L17;
        byte r14 = r5[r10];
        byte r15 = r5[r10 + 1];
        if (r12 <= (-12)) goto L11;
        return -1;
    L11:
        if (r14 > (-65)) goto L24;
        if (r15 <= (-65)) goto L15;
        return -1;
    L15:
        return ((r14 << 8) ^ r12) ^ (r15 << 16);
    L24:
        return -1;
    L17:
        throw new AssertionError();
    L19:
        return a(r12, r5[r10]);
    }

    public static int c(byte[] r10, int r11, int r12) {
    L2:
        if (r11 >= r12) goto L7;
        if (r10[r11] < 0) goto L7;
        r11 = r11 + 1;
    L7:
        if (r11 >= r12) goto L82;
    L9:
        if (r11 >= r12) goto L83;
        int r5 = r11 + 1;
        byte r13 = r10[r11];
        if (r13 < 0) goto L14;
        r11 = r5;
        goto L9
    L14:
        if (r13 < (-32)) goto L15;
        if (r13 < (-16)) goto L25;
        if (r5 >= (r12 - 2)) goto L81;
        int r14 = r11 + 2;
        byte r15 = r10[r5];
        if (r15 > (-65)) goto L79;
        if ((((r15 + 112) + (r13 << 28)) >> 30) != 0) goto L79;
        int r16 = r11 + 3;
        if (r10[r14] > (-65)) goto L79;
        r11 = r11 + 4;
        if (r10[r16] <= (-65)) goto L9;
    L79:
        return -1;
    L81:
        return b(r10, r5, r12);
    L25:
        if (r5 >= (r12 - 1)) goto L80;
        int r17 = r11 + 2;
        byte r18 = r10[r5];
        if (r18 > (-65)) goto L79;
        if (r13 != (-32)) goto L33;
        if (r18 < (-96)) goto L79;
    L33:
        if (r13 != (-19)) goto L35;
        if (r18 >= (-96)) goto L79;
    L35:
        r11 = r11 + 3;
        if (r10[r17] <= (-65)) goto L9;
    L80:
        return b(r10, r5, r12);
    L15:
        if (r5 >= r12) goto L50;
        if (r13 < (-62)) goto L79;
        r11 = r11 + 2;
        if (r10[r5] <= (-65)) goto L9;
    L50:
        return r13;
    L83:
        return 0;
    L82:
        return 0;
    }
}
