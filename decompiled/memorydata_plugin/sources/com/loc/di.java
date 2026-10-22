package com.loc;

/* JADX INFO: loaded from: classes3.dex */
public class di {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f5436a = true;

    static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f5437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5438b;

        a() {
        }
    }

    static class b extends a {
        private static final int[] c = null;
        private static final int[] d = null;
        private int e;
        private int f;
        private final int[] g;

        static {
            c = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            d = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public b(byte[] r1) {
            this.f5437a = r1;
            this.g = c;
            this.e = 0;
            this.f = 0;
        }

        public final boolean a(byte[] r18, int r19) {
            int r1 = this.e;
            if (r1 != 6) goto L5;
            return false;
        L5:
            int r4 = r19 + 0;
            int r5 = this.f;
            byte[] r6 = this.f5437a;
            int[] r7 = this.g;
            int r10 = 0;
            int r11 = 0;
        L7:
            if (r10 >= r4) goto L62;
            if (r1 != 0) goto L15;
        L9:
            int r15 = r10 + 4;
            if (r15 > r4) goto L14;
            r5 = r7[r18[r10 + 3] & 255] | (((r7[r18[r10 + 1] & 255] << 12) | (r7[r18[r10] & 255] << 18)) | (r7[r18[r10 + 2] & 255] << 6));
            if (r5 < 0) goto L14;
            r6[r11 + 2] = (byte) r5;
            r6[r11 + 1] = (byte) (r5 >> 8);
            r6[r11] = (byte) (r5 >> 16);
            r11 = r11 + 3;
            r10 = r15;
        L14:
            if (r10 >= r4) goto L62;
        L15:
            r10 = r10 + 1;
            int r12 = r7[r18[r10] & 255];
            if (r1 == 0) goto L53;
            if (r1 != 1) goto L19;
            boolean r13 = false;
            if (r12 < 0) goto L50;
            r5 = (r5 << 6) | r12;
        L49:
            r1 = r1 + 1;
        L56:
            r10 = r10;
            goto L7
        L50:
            if (r12 == (-1)) goto L7;
            this.e = 6;
            return false;
        L19:
            if (r1 == 2) goto L40;
            if (r1 == 3) goto L33;
            if (r1 != 4) goto L22;
            r13 = false;
            if (r12 == (-2)) goto L49;
            if (r12 == (-1)) goto L7;
            this.e = 6;
            return false;
        L22:
            if (r1 != 5) goto L7;
            if (r12 == (-1)) goto L7;
        L25:
            this.e = 6;
            return false;
        L33:
            if (r12 < 0) goto L35;
            r5 = (r5 << 6) | r12;
            r6[r11 + 2] = (byte) r5;
            r6[r11 + 1] = (byte) (r5 >> 8);
            r6[r11] = (byte) (r5 >> 16);
            r11 = r11 + 3;
            r1 = 0;
            goto L7
        L35:
            if (r12 != (-2)) goto L37;
            r6[r11 + 1] = (byte) (r5 >> 2);
            r6[r11] = (byte) (r5 >> 10);
            r11 = r11 + 2;
            r1 = 5;
            goto L7
        L37:
            if (r12 == (-1)) goto L7;
        L38:
            this.e = 6;
            return false;
        L40:
            if (r12 < 0) goto L42;
            r5 = (r5 << 6) | r12;
            r1 = r1 + 1;
            goto L7
        L42:
            if (r12 != (-2)) goto L44;
            r6[r11] = (byte) (r5 >> 4);
            r11 = r11 + 1;
            r1 = 4;
            goto L7
        L44:
            if (r12 == (-1)) goto L7;
        L53:
            r13 = false;
            if (r12 < 0) goto L57;
            r1 = r1 + 1;
            r5 = r12;
            goto L56
        L57:
            if (r12 == (-1)) goto L7;
            this.e = 6;
            return false;
        L62:
            if (r1 == 1) goto L38;
            if (r1 == 2) goto L68;
            if (r1 == 3) goto L67;
            if (r1 == 4) goto L38;
        L69:
            this.e = r1;
            this.f5438b = r11;
            return true;
        L67:
            int r2 = r11 + 1;
            r6[r11] = (byte) (r5 >> 10);
            r11 = r2 + 1;
            r6[r2] = (byte) (r5 >> 2);
            goto L69
        L68:
            r6[r11] = (byte) (r5 >> 4);
            r11 = r11 + 1;
            goto L69
        }
    }

    static {
    }

    private di() {
    }

    public static byte[] a(byte[] r1) {
        return a(r1, r1.length);
    }

    private static byte[] a(byte[] r2, int r3) {
        b r0 = new b(new byte[(r3 * 3) / 4]);
        if (r0.a(r2, r3) == false) goto L11;
        if (r0.f5438b == r0.f5437a.length) goto L7;
        byte[] r4 = new byte[r0.f5438b];
        System.arraycopy(r0.f5437a, 0, r4, 0, r0.f5438b);
        return r4;
    L7:
        return r0.f5437a;
    L11:
        throw new IllegalArgumentException("bad base-64");
    }
}
