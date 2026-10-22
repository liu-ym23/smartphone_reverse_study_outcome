package a0;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f9a;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public char f10a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f11b;

        public b(char r8, float[] r10) {
            this.f10a = r8;
            this.f11b = r10;
        }

        public static void a(Path r51, float r52, float r53, float r54, float r55, float r56, float r57, float r58, boolean r59, boolean r60) {
            double r8 = Math.toRadians(r58);
            double r10 = Math.cos(r8);
            double r12 = Math.sin(r8);
            double r14 = r52;
            double r11 = r53;
            double r18 = (r11 * r12) + (r14 * r10);
            double r16 = r14;
            double r15 = r56;
            double r19 = r18 / r15;
            double r13 = r57;
            double r22 = ((r11 * r10) + (((double) (-r52)) * r12)) / r13;
            double r24 = r11;
            double r17 = r55;
            double r26 = ((r17 * r12) + (((double) r54) * r10)) / r15;
            double r20 = ((r17 * r10) + (((double) (-r54)) * r12)) / r13;
            double r21 = r19 - r26;
            double r28 = r22 - r20;
            double r30 = (r19 + r26) / 2.0d;
            double r34 = (r22 + r20) / 2.0d;
            double r110 = (r28 * r28) + (r21 * r21);
            if (r110 != 0.0d) goto L6;
            Log.w("PathParser", " Points are coincident");
            return;
        L6:
            double r42 = (1.0d / r110) - 0.25d;
            if (r42 >= 0.0d) goto L10;
            Log.w("PathParser", "Points are too far apart " + r110);
            float r23 = (float) (Math.sqrt(r110) / 1.99999d);
            a(r51, r52, r53, r54, r55, r56 * r23, r57 * r23, r58, r59, r60);
            return;
        L10:
            double r111 = Math.sqrt(r42);
            double r25 = r21 * r111;
            double r112 = r111 * r28;
            if (r59 != r60) goto L13;
            double r31 = r30 - r112;
            double r35 = r34 + r25;
        L14:
            double r27 = Math.atan2(r22 - r35, r19 - r31);
            double r29 = Math.atan2(r20 - r35, r26 - r31) - r27;
            if (r29 < 0.0d) goto L17;
            boolean r32 = true;
        L18:
            if (r60 != r32) goto L20;
        L23:
            double r33 = r31 * r15;
            double r36 = r35 * r13;
            double r37 = (r33 * r10) - (r36 * r12);
            double r38 = (r36 * r10) + (r33 * r12);
            int r39 = (int) Math.ceil(Math.abs((r29 * 4.0d) / 3.141592653589793d));
            double r113 = Math.cos(r8);
            double r114 = Math.sin(r8);
            double r210 = Math.cos(r27);
            double r211 = Math.sin(r27);
            double r115 = -r15;
            double r212 = r115 * r113;
            double r310 = r13 * r114;
            double r213 = (r212 * r211) - (r310 * r210);
            double r116 = r115 * r114;
            double r40 = r13 * r113;
            double r214 = (r210 * r40) + (r211 * r116);
            double r510 = r40;
            double r41 = r29 / ((double) r39);
            int r43 = 0;
        L24:
            if (r43 >= r39) goto L26;
            double r44 = r27 + r41;
            double r215 = Math.sin(r44);
            double r311 = Math.cos(r44);
            double r511 = r41;
            double r45 = (((r15 * r113) * r311) + r37) - (r310 * r215);
            double r46 = r510;
            double r512 = r37;
            double r47 = (r46 * r215) + (((r15 * r114) * r311) + r38);
            double r48 = (r212 * r215) - (r310 * r311);
            double r216 = (r311 * r46) + (r215 * r116);
            double r49 = r44 - r27;
            double r312 = Math.tan(r49 / 2.0d);
            double r410 = ((Math.sqrt(((r312 * 3.0d) * r312) + 4.0d) - 1.0d) * Math.sin(r49)) / 3.0d;
            double r513 = r116;
            r51.rLineTo(0.0f, 0.0f);
            r51.cubicTo((float) ((r213 * r410) + r16), (float) ((r214 * r410) + r24), (float) (r45 - (r410 * r48)), (float) (r47 - (r410 * r216)), (float) r45, (float) r47);
            r43 = r43 + 1;
            r27 = r44;
            r116 = r513;
            r113 = r113;
            r39 = r39;
            r214 = r216;
            r15 = r15;
            r213 = r48;
            r16 = r45;
            r24 = r47;
            r37 = r512;
            r41 = r511;
            r510 = r46;
            goto L24
        L26:
            return;
        L20:
            if (r29 <= 0.0d) goto L22;
            r29 = r29 - 6.283185307179586d;
            goto L23
        L22:
            r29 = r29 + 6.283185307179586d;
            goto L23
        L17:
            r32 = false;
            goto L18
        L13:
            r31 = r30 + r112;
            r35 = r34 - r25;
            goto L14
        }

        public static void b(b[] r31, Path r32) {
            int r12 = 6;
            float[] r13 = new float[6];
            char r14 = 'm';
            int r15 = 0;
            char r8 = 'm';
            int r10 = 0;
        L4:
            if (r10 >= r31.length) goto L145;
            b r11 = r31[r10];
            char r16 = r11.f10a;
            float r17 = r13[r15];
            float r18 = r13[1];
            float r19 = r13[2];
            float r20 = r13[3];
            float r21 = r13[4];
            float r22 = r13[5];
            switch(r16) {
                case 65: goto L12;
                case 67: goto L11;
                case 72: goto L10;
                case 81: goto L9;
                case 83: goto L9;
                case 86: goto L10;
                case 90: goto L8;
                case 97: goto L12;
                case 99: goto L11;
                case 104: goto L10;
                case 113: goto L9;
                case 115: goto L9;
                case 118: goto L10;
                case 122: goto L8;
                default: goto L13;
            };
        L8:
            r32.close();
            r32.moveTo(r21, r22);
            r17 = r21;
            r19 = r17;
            r18 = r22;
            r20 = r18;
            goto L13
        L9:
            int r23 = 4;
        L14:
            float r24 = r21;
            float r25 = r22;
            float r26 = r17;
            float r27 = r18;
            int r28 = r15;
        L15:
            float[] r29 = r11.f11b;
            if (r28 >= r29.length) goto L144;
            if (r16 != 'A') goto L20;
            int r30 = r28;
            float r110 = r27;
            float r33 = r26;
            int r111 = r30 + 5;
            float r34 = r29[r111];
            int r112 = r30 + 6;
            float r35 = r29[r112];
            float r36 = r29[r30 + 0];
            float r37 = r29[r30 + 1];
            float r38 = r29[r30 + 2];
            if (r29[r30 + 3] == 0.0f) goto L136;
            boolean r39 = true;
        L138:
            if (r29[r30 + 4] == 0.0f) goto L140;
            boolean r113 = true;
        L141:
            a(r32, r33, r110, r34, r35, r36, r37, r38, r39, r113);
            r26 = r29[r111];
            r27 = r29[r112];
        L142:
            r20 = r27;
            r19 = r26;
        L143:
            r28 = r30 + r23;
            r11 = r11;
            r8 = r16;
            r16 = r8;
            r10 = r10;
            r14 = 'm';
            r15 = 0;
            goto L15
        L140:
            r113 = false;
            goto L141
        L136:
            r39 = false;
            goto L138
        L20:
            if (r16 != 'C') goto L22;
            r30 = r28;
            int r40 = r30 + 2;
            int r41 = r30 + 3;
            int r42 = r30 + 4;
            int r114 = r30 + 5;
            r32.cubicTo(r29[r30 + 0], r29[r30 + 1], r29[r40], r29[r41], r29[r42], r29[r114]);
            float r43 = r29[r42];
            float r44 = r29[r114];
            float r45 = r29[r40];
            r26 = r43;
            r27 = r44;
            float r46 = r29[r41];
        L132:
            r19 = r45;
            r20 = r46;
            goto L143
        L22:
            if (r16 != 'H') goto L24;
            r30 = r28;
            r16 = r16;
            r11 = r11;
            r10 = r10;
            int r47 = r30 + 0;
            r32.lineTo(r29[r47], r27);
            r26 = r29[r47];
            goto L143
        L24:
            if (r16 != 'Q') goto L26;
            r30 = r28;
            int r48 = r30 + 0;
            int r49 = r30 + 1;
            int r50 = r30 + 2;
            int r51 = r30 + 3;
            r32.quadTo(r29[r48], r29[r49], r29[r50], r29[r51]);
            r45 = r29[r48];
            r46 = r29[r49];
            r26 = r29[r50];
            r27 = r29[r51];
            goto L132
        L26:
            if (r16 != 'V') goto L28;
            r30 = r28;
            r16 = r16;
            r11 = r11;
            r10 = r10;
            int r52 = r30 + 0;
            r32.lineTo(r26, r29[r52]);
            r27 = r29[r52];
            goto L143
        L28:
            if (r16 != 'a') goto L30;
            r30 = r28;
            float r115 = r27;
            float r53 = r26;
            int r116 = r30 + 5;
            float r54 = r29[r116] + r53;
            int r117 = r30 + 6;
            float r55 = r29[r117] + r115;
            float r56 = r29[r30 + 0];
            float r57 = r29[r30 + 1];
            float r210 = r29[r30 + 2];
            if (r29[r30 + 3] == 0.0f) goto L122;
            boolean r211 = true;
        L124:
            if (r29[r30 + 4] == 0.0f) goto L126;
            boolean r212 = true;
        L127:
            a(r32, r53, r115, r54, r55, r56, r57, r210, r211, r212);
            r26 = r53 + r29[r116];
            r27 = r115 + r29[r117];
            goto L142
        L126:
            r212 = false;
            goto L127
        L122:
            r211 = false;
            goto L124
        L30:
            if (r16 != 'c') goto L32;
            r30 = r28;
            float r118 = r27;
            float r58 = r26;
            int r119 = r30 + 2;
            int r120 = r30 + 3;
            int r213 = r30 + 4;
            int r214 = r30 + 5;
            r32.rCubicTo(r29[r30 + 0], r29[r30 + 1], r29[r119], r29[r120], r29[r213], r29[r214]);
            float r59 = r29[r119] + r58;
            float r60 = r29[r120] + r118;
            float r61 = r58 + r29[r213];
            float r62 = r29[r214];
        L116:
            float r63 = r118 + r62;
            r19 = r59;
            r20 = r60;
            float r64 = r61;
        L117:
            r26 = r64;
            r27 = r63;
        L118:
            r16 = r16;
            r11 = r11;
            r10 = r10;
            goto L143
        L32:
            if (r16 != 'h') goto L34;
            r30 = r28;
            int r65 = r30 + 0;
            r32.rLineTo(r29[r65], 0.0f);
            r26 = r26 + r29[r65];
            goto L118
        L34:
            if (r16 != 'q') goto L36;
            r30 = r28;
            r118 = r27;
            float r66 = r26;
            int r67 = r30 + 0;
            float r68 = r29[r67];
            int r69 = r30 + 1;
            int r70 = r30 + 2;
            int r71 = r30 + 3;
            r32.rQuadTo(r68, r29[r69], r29[r70], r29[r71]);
            r59 = r29[r67] + r66;
            r60 = r29[r69] + r118;
            float r72 = r66 + r29[r70];
            float r73 = r29[r71];
            r61 = r72;
            r62 = r73;
            goto L116
        L36:
            if (r16 != 'v') goto L38;
            r30 = r28;
            int r74 = r30 + 0;
            r32.rLineTo(0.0f, r29[r74]);
            float r75 = r29[r74];
        L112:
            r27 = r27 + r75;
            goto L118
        L38:
            if (r16 != 'L') goto L40;
            r30 = r28;
            int r76 = r30 + 0;
            int r77 = r30 + 1;
            r32.lineTo(r29[r76], r29[r77]);
            float r78 = r29[r76];
            float r79 = r29[r77];
        L110:
            r26 = r78;
            r27 = r79;
            goto L118
        L40:
            if (r16 != 'M') goto L42;
            r30 = r28;
            r78 = r29[r30 + 0];
            r79 = r29[r30 + 1];
            if (r30 <= 0) goto L107;
            r32.lineTo(r78, r79);
            goto L110
        L107:
            r32.moveTo(r78, r79);
            r24 = r78;
            r25 = r79;
        L108:
            r26 = r24;
            r27 = r25;
            goto L118
        L42:
            if (r16 != 'S') goto L44;
            r30 = r28;
            float r121 = r27;
            float r80 = r26;
            if (r8 != 'c') goto L95;
        L102:
            float r81 = (r121 * 2.0f) - r20;
            float r82 = (r80 * 2.0f) - r19;
        L103:
            int r83 = r30 + 0;
            int r122 = r30 + 1;
            int r123 = r30 + 2;
            int r124 = r30 + 3;
            r32.cubicTo(r82, r81, r29[r83], r29[r122], r29[r123], r29[r124]);
            float r84 = r29[r83];
            float r85 = r29[r122];
            r64 = r29[r123];
            r63 = r29[r124];
            r19 = r84;
            r20 = r85;
            goto L117
        L95:
            if (r8 == 's') goto L102;
            if (r8 == 'C') goto L102;
            if (r8 == 'S') goto L102;
            r82 = r80;
            r81 = r121;
            goto L103
        L44:
            if (r16 != 'T') goto L46;
            r30 = r28;
            float r125 = r27;
            float r86 = r26;
            if (r8 == 'q') goto L90;
            if (r8 == 't') goto L90;
            if (r8 == 'Q') goto L90;
            if (r8 == 'T') goto L90;
            float r87 = r86;
            float r88 = r125;
        L91:
            int r89 = r30 + 0;
            int r90 = r30 + 1;
            r32.quadTo(r87, r88, r29[r89], r29[r90]);
            r20 = r88;
            r19 = r87;
            r16 = r16;
            r11 = r11;
            r10 = r10;
            r26 = r29[r89];
            r27 = r29[r90];
        L90:
            r87 = (r86 * 2.0f) - r19;
            r88 = (r125 * 2.0f) - r20;
            goto L91
        L46:
            if (r16 == 'l') goto L80;
            if (r16 != r14) goto L49;
            r30 = r28;
            float r91 = r29[r30 + 0];
            r26 = r26 + r91;
            float r92 = r29[r30 + 1];
            r27 = r27 + r92;
            if (r30 <= 0) goto L79;
            r32.rLineTo(r91, r92);
            goto L118
        L79:
            r32.rMoveTo(r91, r92);
            r25 = r27;
            r24 = r26;
            goto L108
        L49:
            if (r16 == 's') goto L65;
            if (r16 == 't') goto L53;
        L63:
            r30 = r28;
            goto L118
        L53:
            if (r8 == 'q') goto L61;
            if (r8 == 't') goto L61;
            if (r8 == 'Q') goto L61;
            if (r8 == 'T') goto L61;
            float r93 = 0.0f;
            float r126 = 0.0f;
        L62:
            int r94 = r28 + 0;
            int r127 = r28 + 1;
            r32.rQuadTo(r126, r93, r29[r94], r29[r127]);
            float r128 = r126 + r26;
            float r95 = r93 + r27;
            r26 = r26 + r29[r94];
            r27 = r27 + r29[r127];
            r20 = r95;
            r19 = r128;
        L61:
            r126 = r26 - r19;
            r93 = r27 - r20;
            goto L62
        L65:
            if (r8 != 'c') goto L67;
        L74:
            float r96 = r26 - r19;
            float r97 = r27 - r20;
            float r215 = r96;
        L75:
            int r129 = r28 + 0;
            int r130 = r28 + 1;
            int r216 = r28 + 2;
            int r217 = r28 + 3;
            r30 = r28;
            r118 = r27;
            float r98 = r26;
            r32.rCubicTo(r215, r97, r29[r129], r29[r130], r29[r216], r29[r217]);
            r59 = r29[r129] + r98;
            r60 = r29[r130] + r118;
            r61 = r98 + r29[r216];
            r62 = r29[r217];
            goto L116
        L67:
            if (r8 == 's') goto L74;
            if (r8 == 'C') goto L74;
            if (r8 == 'S') goto L74;
            r97 = 0.0f;
            r215 = 0.0f;
            goto L75
        L80:
            r30 = r28;
            int r99 = r30 + 0;
            float r100 = r29[r99];
            int r101 = r30 + 1;
            r32.rLineTo(r100, r29[r101]);
            r26 = r26 + r29[r99];
            r75 = r29[r101];
            goto L112
        L144:
            int r218 = r10;
            int r102 = r15;
            r13[r102] = r26;
            r13[1] = r27;
            r13[2] = r19;
            r13[3] = r20;
            r13[4] = r24;
            r13[5] = r25;
            r10 = r218 + 1;
            r12 = 6;
            r14 = 'm';
            r15 = r102;
            r8 = r31[r218].f10a;
            goto L4
        L10:
            r23 = 1;
            goto L14
        L11:
            r23 = r12;
            goto L14
        L12:
            r23 = 7;
        L13:
            r23 = 2;
            goto L14
        }

        public b(b r8) {
            this.f10a = r8.f10a;
            float[] r10 = r8.f11b;
            this.f11b = d.b(r10, r10.length);
        }
    }

    public static boolean a(b[] r8, b[] r10) {
        if (r8 == null) goto L21;
        if (r10 == null) goto L21;
        if (r8.length == r10.length) goto L9;
        return false;
    L9:
        int r11 = 0;
    L11:
        if (r11 >= r8.length) goto L19;
        b r12 = r8[r11];
        char r13 = r12.f10a;
        b r14 = r10[r11];
        if (r13 != r14.f10a) goto L18;
        if (r12.f11b.length != r14.f11b.length) goto L18;
        r11 = r11 + 1;
    L18:
        return false;
    L19:
        return true;
    L21:
        return false;
    }

    public static float[] b(float[] r8, int r10) {
        if (r10 < 0) goto L10;
        int r11 = r8.length;
        if (r11 < 0) goto L8;
        int r12 = r10 - 0;
        int r13 = Math.min(r12, r11 - 0);
        float[] r14 = new float[r12];
        System.arraycopy(r8, 0, r14, 0, r13);
        return r14;
    L8:
        throw new ArrayIndexOutOfBoundsException();
    L10:
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    public static b[] c(String r17) {
        if (r17 != null) goto L6;
        return null;
    L6:
        ArrayList r8 = new ArrayList();
        int r10 = 0;
        int r11 = 1;
        int r12 = 0;
    L8:
        if (r11 >= r17.length()) goto L66;
    L10:
        if (r11 >= r17.length()) goto L19;
        char r13 = r17.charAt(r11);
        if (((r13 - 'Z') * (r13 - 'A')) > 0) goto L14;
    L15:
        if (r13 == 'e') goto L18;
        if (r13 != 'E') goto L19;
    L18:
        r11 = r11 + 1;
        goto L10
    L14:
        if (((r13 - 'z') * (r13 - 'a')) > 0) goto L18;
    L19:
        String r14 = r17.substring(r10, r11).trim();
        if (r14.length() <= 0) goto L64;
        if (r14.charAt(r12) != 'z') goto L24;
    L62:
        float[] r15 = new float[r12];
    L63:
        r8.add(new b(r14.charAt(r12), r15));
        goto L64
    L24:
        if (r14.charAt(r12) == 'Z') goto L62;
        float[] r16 = new float[r14.length()];     // Catch: NumberFormatException -> L59
        a r18 = new a();     // Catch: NumberFormatException -> L59
        int r19 = r14.length();     // Catch: NumberFormatException -> L59
        int r110 = 1;
        ?? r111 = r12;
    L27:
        if (r110 >= r19) goto L58;
        r18.f9a = r111;     // Catch: NumberFormatException -> L59
        ?? r112 = r111;
        boolean r113 = r112 == true ? 1 : 0;
        int r114 = r110;
        ?? r115 = r111;
        ?? r116 = r112;
    L30:
        if (r114 >= r14.length()) goto L50;
        char r117 = r14.charAt(r114);     // Catch: NumberFormatException -> L59
        if (r117 == ' ') goto L45;
        ?? r118 = r115;
        r118 = r115;
        ?? r119 = r116;
        r119 = r116;
        if (r117 == 'E') goto L43;
        if (r117 == 'e') goto L43;
        switch(r117) {
            case 44: goto L45;
            case 45: goto L40;
            case 46: goto L38;
            default: goto L37;
        };     // Catch: NumberFormatException -> L59
    L37:
        r118 = r115;
        r119 = r116;
    L46:
        boolean r120 = false;
        ?? r121 = r118;
        ?? r122 = r119;
    L47:
        if (r121 != 0) goto L50;
        r114 = r114 + 1;     // Catch: NumberFormatException -> L59
        r115 = r121;
        r116 = r122;
        r113 = r120;
        goto L30
    L38:
        if (r116 != 0) goto L42;
        r119 = 1;
        r118 = r115;
    L42:
        r18.f9a = true;     // Catch: NumberFormatException -> L59
        goto L45
    L40:
        if (r114 == r110) goto L46;
        if (r113 == true) goto L46;
    L43:
        r120 = true;
        r121 = r115;
        r122 = r116;
    L45:
        r118 = 1;
        r119 = r116;
    L50:
        if (r110 >= r114) goto L53;
        r16[r12] = Float.parseFloat(r14.substring(r110, r114));     // Catch: NumberFormatException -> L59
        r12 = r12 + 1;     // Catch: NumberFormatException -> L59
    L53:
        if (r18.f9a == true) goto L56;
        r114 = r114 + 1;     // Catch: NumberFormatException -> L59
    L56:
        r110 = r114;
        r111 = 0;
        goto L27
    L58:
        r15 = b(r16, r12);     // Catch: NumberFormatException -> L59
        r12 = 0;
    L59:
        e = move-exception;
        throw new RuntimeException(defpackage.b.d("error in parsing \"", r14, "\""), e);
    L64:
        r12 = 0;
        int r123 = r11;
        r11 = r11 + 1;
        r10 = r123;
        goto L8
    L66:
        if ((r11 - r10) != 1) goto L71;
        if (r10 >= r17.length()) goto L71;
        r8.add(new b(r17.charAt(r10), new float[0]));
    L71:
        return (b[]) r8.toArray(new b[r8.size()]);
    }

    public static Path d(String r8) {
        Path r10 = new Path();
        b[] r11 = c(r8);
        if (r11 != null) goto L11;
        return null;
    L11:
        b.b(r11, r10);     // Catch: RuntimeException -> L6
        return r10;
    L6:
        e = move-exception;
        throw new RuntimeException(defpackage.b.c("Error in parsing ", r8), e);
    }

    public static b[] e(b[] r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        b[] r10 = new b[r8.length];
        int r11 = 0;
    L7:
        if (r11 >= r8.length) goto L9;
        r10[r11] = new b(r8[r11]);
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }
}
