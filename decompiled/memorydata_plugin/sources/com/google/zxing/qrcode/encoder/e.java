package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[][] f5115a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[][] f5116b = null;
    private static final int[][] c = null;
    private static final int[][] d = null;

    static {
        f5115a = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
        f5116b = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
        c = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, WebSocketProtocol.PAYLOAD_SHORT, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, WebSocketProtocol.PAYLOAD_SHORT, AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
        d = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    }

    static int a(int r0) {
        return 32 - Integer.numberOfLeadingZeros(r0);
    }

    static int a(int r2, int r3) {
        if (r3 == 0) goto L9;
        int r0 = a(r3);
        int r4 = r2 << (r0 - 1);
    L5:
        if (a(r4) < r0) goto L7;
        r4 = r4 ^ (r3 << (a(r4) - r0));
        goto L5
    L7:
        return r4;
    L9:
        throw new IllegalArgumentException("0 polynomial");
    }

    private static void a(int r4, int r5, b r6) {
        int r1 = 0;
    L4:
        if (r1 >= 8) goto L10;
        int r2 = r4 + r1;
        if (b(r6.a(r2, r5)) == false) goto L9;
        r6.a(r2, r5, 0);
        r1 = r1 + 1;
        goto L4
    L9:
        throw new WriterException();
    }

    static void a(com.google.zxing.common.a r10, int r11, b r12) {
        int r0 = r12.b() - 1;
        int r1 = r12.a() - 1;
        int r5 = -1;
        int r4 = 0;
    L3:
        if (r0 <= 0) goto L29;
        if (r0 != 6) goto L7;
        r0 = r0 - 1;
    L7:
        if (r1 < 0) goto L27;
        if (r1 >= r12.a()) goto L27;
        int r6 = 0;
    L12:
        if (r6 >= 2) goto L26;
        int r7 = r0 - r6;
        if (b(r12.a(r7, r1)) == false) goto L25;
        if (r4 >= r10.a()) goto L19;
        boolean r8 = r10.a(r4);
        r4 = r4 + 1;
    L20:
        if (r11 != (-1)) goto L22;
    L24:
        r12.a(r7, r1, r8);
        goto L25
    L22:
        if (d.a(r11, r7, r1) == false) goto L24;
        r8 = !r8;
        goto L24
    L19:
        r8 = false;
    L25:
        r6 = r6 + 1;
        goto L12
    L26:
        r1 = r1 + r5;
    L27:
        r5 = -r5;
        r1 = r1 + r5;
        r0 = r0 - 2;
        goto L3
    L29:
        if (r4 != r10.a()) goto L32;
        return;
    L32:
        throw new WriterException("Not all bits consumed: " + r4 + '/' + r10.a());
    }

    static void a(com.google.zxing.common.a r0, ErrorCorrectionLevel r1, com.google.zxing.qrcode.decoder.a r2, int r3, b r4) {
        a(r4);
        a(r2, r4);
        a(r1, r3, r4);
        b(r2, r4);
        a(r0, r3, r4);
    }

    static void a(ErrorCorrectionLevel r1, int r2, com.google.zxing.common.a r3) {
        if (f.b(r2) == false) goto L10;
        int r4 = (r1.getBits() << 3) | r2;
        r3.a(r4, 5);
        r3.a(a(r4, 1335), 10);
        com.google.zxing.common.a r5 = new com.google.zxing.common.a();
        r5.a(21522, 15);
        r3.b(r5);
        if (r3.a() != 15) goto L8;
        return;
    L8:
        throw new WriterException("should not happen but we got: " + r3.a());
    L10:
        throw new WriterException("Invalid mask pattern");
    }

    static void a(ErrorCorrectionLevel r5, int r6, b r7) {
        com.google.zxing.common.a r0 = new com.google.zxing.common.a();
        a(r5, r6, r0);
        int r8 = 0;
    L4:
        if (r8 >= r0.a()) goto L10;
        boolean r1 = r0.a((r0.a() - 1) - r8);
        int[] r3 = d[r8];
        r7.a(r3[0], r3[1], r1);
        int r4 = 8;
        if (r8 >= 8) goto L8;
        int r2 = 8;
        r4 = (r7.b() - r8) - 1;
    L9:
        r7.a(r4, r2, r1);
        r8 = r8 + 1;
        goto L4
    L8:
        r2 = (r7.a() - 7) + (r8 - 8);
        goto L9
    }

    static void a(com.google.zxing.qrcode.decoder.a r2, com.google.zxing.common.a r3) {
        r3.a(r2.a(), 6);
        r3.a(a(r2.a(), 7973), 12);
        if (r3.a() != 18) goto L6;
        return;
    L6:
        throw new WriterException("should not happen but we got: " + r3.a());
    }

    static void a(com.google.zxing.qrcode.decoder.a r0, b r1) {
        d(r1);
        c(r1);
        c(r0, r1);
        b(r1);
    }

    static void a(b r1) {
        r1.a((byte) -1);
    }

    private static void b(int r4, int r5, b r6) {
        int r1 = 0;
    L4:
        if (r1 >= 7) goto L10;
        int r2 = r5 + r1;
        if (b(r6.a(r4, r2)) == false) goto L9;
        r6.a(r4, r2, 0);
        r1 = r1 + 1;
        goto L4
    L9:
        throw new WriterException();
    }

    static void b(com.google.zxing.qrcode.decoder.a r6, b r7) {
        if (r6.a() >= 7) goto L5;
        return;
    L5:
        com.google.zxing.common.a r0 = new com.google.zxing.common.a();
        a(r6, r0);
        int r8 = 17;
        int r2 = 0;
    L7:
        if (r2 >= 6) goto L13;
        int r3 = 0;
    L10:
        if (r3 >= 3) goto L12;
        boolean r4 = r0.a(r8);
        r8 = r8 - 1;
        r7.a(r2, (r7.a() - 11) + r3, r4);
        r7.a((r7.a() - 11) + r3, r2, r4);
        r3 = r3 + 1;
        goto L10
    L12:
        r2 = r2 + 1;
        goto L7
    }

    private static void b(b r6) {
        int r1 = 8;
    L4:
        if (r1 >= (r6.b() - 8)) goto L12;
        int r2 = r1 + 1;
        int r3 = r2 % 2;
        if (b(r6.a(r1, 6)) == false) goto L9;
        r6.a(r1, 6, r3);
    L9:
        if (b(r6.a(6, r1)) == false) goto L11;
        r6.a(6, r1, r3);
    L11:
        r1 = r2;
        goto L4
    }

    private static boolean b(int r1) {
        if (r1 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private static void c(int r8, int r9, b r10) {
        int r1 = 0;
    L4:
        if (r1 >= 5) goto L9;
        int[] r3 = f5116b[r1];
        int r4 = 0;
    L6:
        if (r4 >= 5) goto L8;
        r10.a(r8 + r4, r9 + r1, r3[r4]);
        r4 = r4 + 1;
        goto L6
    L8:
        r1 = r1 + 1;
        goto L4
    }

    private static void c(com.google.zxing.qrcode.decoder.a r8, b r9) {
        if (r8.a() >= 2) goto L5;
        return;
    L5:
        int[] r10 = c[r8.a() - 1];
        int r0 = r10.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L18;
        int r3 = r10[r2];
        if (r3 < 0) goto L17;
        int r4 = r10.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L17;
        int r6 = r10[r5];
        if (r6 < 0) goto L16;
        if (b(r9.a(r6, r3)) == false) goto L16;
        c(r6 - 2, r3 - 2, r9);
    L16:
        r5 = r5 + 1;
    L17:
        r2 = r2 + 1;
        goto L6
    }

    private static void c(b r3) {
        if (r3.a(8, r3.a() - 8) == 0) goto L7;
        r3.a(8, r3.a() - 8, 1);
        return;
    L7:
        throw new WriterException();
    }

    private static void d(int r8, int r9, b r10) {
        int r1 = 0;
    L4:
        if (r1 >= 7) goto L9;
        int[] r3 = f5115a[r1];
        int r4 = 0;
    L6:
        if (r4 >= 7) goto L8;
        r10.a(r8 + r4, r9 + r1, r3[r4]);
        r4 = r4 + 1;
        goto L6
    L8:
        r1 = r1 + 1;
        goto L4
    }

    private static void d(b r3) {
        int r0 = f5115a[0].length;
        d(0, 0, r3);
        d(r3.b() - r0, 0, r3);
        d(0, r3.b() - r0, r3);
        a(0, 7, r3);
        a(r3.b() - 8, 7, r3);
        a(0, r3.b() - 8, r3);
        b(7, 0, r3);
        b((r3.a() - 7) - 1, 0, r3);
        b(7, r3.a() - 7, r3);
    }
}
