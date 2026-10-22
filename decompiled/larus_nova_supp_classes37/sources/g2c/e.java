package g2c;

import com.ss.android.lark.profile.v2.entity.BaseField;
import com.ss.android.lark.qrcode.zxing.WriterException;
import com.ss.android.lark.qrcode.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final int[][] a = null;
    public static final int[][] b = null;
    public static final int[][] c = null;
    public static final int[][] d = null;

    static {
        a = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
        b = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
        c = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, BaseField.FIELD_TYPE_S_FRIEND_LINK, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, BaseField.FIELD_TYPE_S_FRIEND_LINK, 126, -1}, new int[]{6, 26, 52, 78, BaseField.FIELD_TYPE_ALIAS_AND_MEMO, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, BaseField.FIELD_TYPE_S_FRIEND_LINK, 126, 150}, new int[]{6, 24, 50, 76, BaseField.FIELD_TYPE_S_FRIEND_LINK, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};
        d = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    }

    public static boolean f(int r1) {
        if (r1 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static int b(int r2, int r3) {
        if (r3 == 0) goto L9;
        int r0 = 32 - Integer.numberOfLeadingZeros(r3);
        int r4 = r2 << (r0 - 1);
    L5:
        if ((32 - Integer.numberOfLeadingZeros(r4)) < r0) goto L7;
        r4 = r4 ^ (r3 << ((32 - Integer.numberOfLeadingZeros(r4)) - r0));
        goto L5
    L7:
        return r4;
    L9:
        throw new IllegalArgumentException("0 polynomial");
    }

    public static void c(int r4, int r5, b r6) throws WriterException {
        int r1 = 0;
    L4:
        if (r1 >= 8) goto L10;
        int r2 = r4 + r1;
        if (f(r6.a(r2, r5)) == false) goto L9;
        r6.b(r2, r5, 0);
        r1 = r1 + 1;
        goto L4
    L9:
        throw new WriterException();
    }

    public static void d(int r8, int r9, b r10) {
        int r1 = 0;
    L4:
        if (r1 >= 7) goto L9;
        int[] r3 = a[r1];
        int r4 = 0;
    L6:
        if (r4 >= 7) goto L8;
        r10.b(r8 + r4, r9 + r1, r3[r4]);
        r4 = r4 + 1;
        goto L6
    L8:
        r1 = r1 + 1;
        goto L4
    }

    public static void e(int r4, int r5, b r6) throws WriterException {
        int r1 = 0;
    L4:
        if (r1 >= 7) goto L10;
        int r2 = r5 + r1;
        if (f(r6.a(r4, r2)) == false) goto L9;
        r6.b(r4, r2, 0);
        r1 = r1 + 1;
        goto L4
    L9:
        throw new WriterException();
    }

    public static void a(d2c.a r20, ErrorCorrectionLevel r21, com.ss.android.lark.qrcode.zxing.qrcode.decoder.a r22, int r23, b r24) throws WriterException {
        byte[][] r4 = r24.a;
        int r5 = r4.length;
        int r7 = 0;
    L4:
        if (r7 >= r5) goto L6;
        Arrays.fill(r4[r7], (byte) -1);
        r7 = r7 + 1;
        goto L4
    L6:
        int r6 = a[0].length;
        d(0, 0, r24);
        d(r24.b - r6, 0, r24);
        d(0, r24.b - r6, r24);
        c(0, 7, r24);
        c(r24.b - 8, 7, r24);
        c(0, r24.b - 8, r24);
        e(7, 0, r24);
        e((r24.c - 7) - 1, 0, r24);
        e(7, r24.c - 7, r24);
        if (r24.a(8, r24.c - 8) == 0) goto L129;
        r24.b(8, r24.c - 8, 1);
        int r8 = r22.a;
        int r10 = 5;
        if (r8 < 2) goto L29;
        int[] r9 = c[r8 - 1];
        int r12 = r9.length;
        int r13 = 0;
    L12:
        if (r13 >= r12) goto L29;
        int r14 = r9[r13];
        if (r14 < 0) goto L28;
        int r15 = r9.length;
        int r11 = 0;
    L16:
        if (r11 >= r15) goto L28;
        int r16 = r9[r11];
        if (r16 < 0) goto L27;
        if (f(r24.a(r16, r14)) == false) goto L27;
        int r17 = r16 - 2;
        int r18 = r14 - 2;
        int r19 = 0;
    L22:
        if (r19 >= r10) goto L27;
        int[] r110 = b[r19];
        int r25 = 0;
    L24:
        if (r25 >= r10) goto L26;
        r24.b(r17 + r25, r18 + r19, r110[r25]);
        r25 = r25 + 1;
        r10 = 5;
        goto L24
    L26:
        r19 = r19 + 1;
        r10 = 5;
    L27:
        r11 = r11 + 1;
        r10 = 5;
    L28:
        r13 = r13 + 1;
        r10 = 5;
    L29:
        int r26 = 8;
    L31:
        if (r26 >= (r24.b - 8)) goto L39;
        int r27 = r26 + 1;
        int r28 = r27 % 2;
        if (f(r24.a(r26, 6)) == false) goto L36;
        r24.b(r26, 6, r28);
    L36:
        if (f(r24.a(6, r26)) == false) goto L38;
        r24.b(6, r26, r28);
    L38:
        r26 = r27;
        goto L31
    L39:
        d2c.a r29 = new d2c.a();
        if (r23 >= 0) goto L42;
    L44:
        boolean r30 = false;
    L45:
        if (r30 == false) goto L127;
        int r31 = (r21.getBits() << 3) | r23;
        r29.b(r31, 5);
        r29.b(b(r31, 1335), 10);
        d2c.a r32 = new d2c.a();
        r32.b(21522, 15);
        if (r29.b != r32.b) goto L125;
        int r33 = 0;
    L49:
        int[] r111 = r29.a;
        if (r33 >= r111.length) goto L53;
        r111[r33] = r111[r33] ^ r32.a[r33];
        r33 = r33 + 1;
        goto L49
    L53:
        if (r29.b != 15) goto L123;
        int r34 = 0;
    L55:
        int r35 = r29.b;
        if (r34 >= r35) goto L63;
        boolean r36 = r29.d((r35 - 1) - r34);
        int[] r112 = d[r34];
        r24.c(r112[0], r112[1], r36);
        if (r34 >= 8) goto L60;
        r24.c((r24.b - r34) - 1, 8, r36);
    L61:
        r34 = r34 + 1;
        goto L55
    L60:
        r24.c(8, (r24.c - 7) + (r34 - 8), r36);
        goto L61
    L63:
        if (r22.a < 7) goto L73;
        d2c.a r37 = new d2c.a();
        r37.b(r22.a, 6);
        r37.b(b(r22.a, 7973), 12);
        if (r37.b != 18) goto L121;
        int r1 = 17;
        int r38 = 0;
    L68:
        if (r38 >= 6) goto L73;
        int r39 = 0;
    L70:
        if (r39 >= 3) goto L72;
        boolean r40 = r37.d(r1);
        r1 = r1 - 1;
        r24.c(r38, (r24.c - 11) + r39, r40);
        r24.c((r24.c - 11) + r39, r38, r40);
        r39 = r39 + 1;
        goto L70
    L72:
        r38 = r38 + 1;
        goto L68
    L121:
        throw new WriterException("should not happen but we got: " + r37.b);
    L73:
        int r2 = r24.b - 1;
        int r41 = r24.c - 1;
        int r42 = 0;
        int r43 = -1;
    L74:
        if (r2 <= 0) goto L116;
        if (r2 != 6) goto L77;
        r2 = r2 - 1;
    L77:
        if (r41 < 0) goto L114;
        if (r41 >= r24.c) goto L114;
        int r44 = 0;
    L81:
        if (r44 >= 2) goto L113;
        int r113 = r2 - r44;
        if (f(r24.a(r113, r41)) == true) goto L86;
    L112:
        r44 = r44 + 1;
        goto L81
    L86:
        if (r42 >= r20.b) goto L88;
        boolean r114 = r20.d(r42);
        r42 = r42 + 1;
    L90:
        if (r23 == (-1)) goto L111;
        switch(r23) {
            case 0: goto L102;
            case 1: goto L101;
            case 2: goto L99;
            case 3: goto L98;
            case 4: goto L97;
            case 5: goto L96;
            case 6: goto L95;
            case 7: goto L94;
            default: goto L93;
        };
    L94:
        int r115 = (r41 * r113) % 3;
        int r116 = (r41 + r113) & 1;
    L103:
        int r117 = r115 + r116;
    L104:
        int r118 = r117 & 1;
    L105:
        if (r118 != 0) goto L107;
        boolean r119 = true;
    L108:
        if (r119 == false) goto L111;
        r114 = !r114;
        goto L111
    L107:
        r119 = false;
        goto L108
    L95:
        int r120 = r41 * r113;
        r116 = r120 & 1;
        r115 = r120 % 3;
        goto L103
    L96:
        int r121 = r41 * r113;
        r118 = (r121 % 3) + (r121 & 1);
        goto L105
    L97:
        r115 = r41 / 2;
        r116 = r113 / 3;
        goto L103
    L98:
        r118 = (r41 + r113) % 3;
        goto L105
    L99:
        r118 = r113 % 3;
        goto L105
    L101:
        r117 = r41;
        goto L104
    L102:
        r115 = r41;
        r116 = r113;
        goto L103
    L93:
        throw new IllegalArgumentException("Invalid mask pattern: " + r23);
    L111:
        r24.c(r113, r41, r114);
        goto L112
    L88:
        r114 = false;
        goto L90
    L113:
        r41 = r41 + r43;
    L114:
        r43 = -r43;
        r41 = r41 + r43;
        r2 = r2 - 2;
        goto L74
    L116:
        if (r42 != r20.b) goto L119;
        return;
    L119:
        throw new WriterException("Not all bits consumed: " + r42 + '/' + r20.b);
    L123:
        throw new WriterException("should not happen but we got: " + r29.b);
    L125:
        throw new IllegalArgumentException("Sizes don't match");
    L127:
        throw new WriterException("Invalid mask pattern");
    L42:
        if (r23 >= 8) goto L44;
        r30 = true;
        goto L45
    L129:
        throw new WriterException();
    }
}
