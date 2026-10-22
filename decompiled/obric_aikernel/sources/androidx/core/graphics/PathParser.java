package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PathParser {
    private static final String LOGTAG = "PathParser";

    private static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        PathDataNode(char r10, float[] r11) {
            this.mType = r10;
            this.mParams = r11;
        }

        PathDataNode(PathDataNode r10) {
            this.mType = r10.mType;
            float[] r11 = r10.mParams;
            this.mParams = PathParser.copyOfRange(r11, 0, r11.length);
        }

        private static void addCommand(Path r25, float[] r26, char r27, char r28, float[] r29) {
            char r11 = r28;
            boolean r13 = false;
            float r10 = r26[0];
            float r12 = r26[1];
            float r14 = r26[2];
            float r15 = r26[3];
            float r16 = r26[4];
            float r17 = r26[5];
            switch(r11) {
                case 65: goto L9;
                case 67: goto L8;
                case 72: goto L7;
                case 76: goto L4;
                case 77: goto L4;
                case 81: goto L6;
                case 83: goto L6;
                case 84: goto L4;
                case 86: goto L7;
                case 90: goto L5;
                case 97: goto L9;
                case 99: goto L8;
                case 104: goto L7;
                case 108: goto L4;
                case 109: goto L4;
                case 113: goto L6;
                case 115: goto L6;
                case 116: goto L4;
                case 118: goto L7;
                case 122: goto L5;
                default: goto L4;
            };
        L4:
            int r19 = 2;
        L11:
            float r18 = r10;
            float r20 = r12;
            float r21 = r16;
            float r22 = r17;
            int r23 = 0;
            char r24 = r27;
        L13:
            if (r23 >= r29.length) goto L123;
            if (r11 != 'A') goto L17;
            int r210 = r23;
            float r110 = r20;
            float r111 = r18;
            int r112 = r210 + 5;
            float r30 = r29[r112];
            int r113 = r210 + 6;
            float r31 = r29[r113];
            float r32 = r29[r210 + 0];
            float r33 = r29[r210 + 1];
            float r34 = r29[r210 + 2];
            if (r29[r210 + 3] == 0.0f) goto L115;
            boolean r35 = true;
        L117:
            if (r29[r210 + 4] == 0.0f) goto L119;
            boolean r36 = true;
        L120:
            drawArc(r25, r111, r110, r30, r31, r32, r33, r34, r35, r36);
            r18 = r29[r112];
            r20 = r29[r113];
        L121:
            r15 = r20;
            r14 = r18;
        L122:
            r23 = r210 + r19;
            r24 = r28;
            r11 = r24;
            r13 = false;
            goto L13
        L119:
            r36 = false;
            goto L120
        L115:
            r35 = false;
            goto L117
        L17:
            if (r11 != 'C') goto L19;
            r210 = r23;
            int r37 = r210 + 2;
            int r38 = r210 + 3;
            int r39 = r210 + 4;
            int r114 = r210 + 5;
            r25.cubicTo(r29[r210 + 0], r29[r210 + 1], r29[r37], r29[r38], r29[r39], r29[r114]);
            r18 = r29[r39];
            float r40 = r29[r114];
            float r41 = r29[r37];
            float r42 = r29[r38];
            r20 = r40;
            r15 = r42;
            r14 = r41;
            goto L122
        L19:
            if (r11 != 'H') goto L21;
            r210 = r23;
            int r43 = r210 + 0;
            r25.lineTo(r29[r43], r20);
            r18 = r29[r43];
            goto L122
        L21:
            if (r11 != 'Q') goto L23;
            r210 = r23;
            int r44 = r210 + 0;
            int r45 = r210 + 1;
            int r46 = r210 + 2;
            int r47 = r210 + 3;
            r25.quadTo(r29[r44], r29[r45], r29[r46], r29[r47]);
            float r48 = r29[r44];
            float r49 = r29[r45];
            r18 = r29[r46];
            r20 = r29[r47];
            r14 = r48;
            r15 = r49;
            goto L122
        L23:
            if (r11 != 'V') goto L25;
            r210 = r23;
            int r50 = r210 + 0;
            r25.lineTo(r18, r29[r50]);
            r20 = r29[r50];
            goto L122
        L25:
            if (r11 != 'a') goto L27;
            int r115 = r23 + 5;
            float r51 = r29[r115] + r18;
            int r116 = r23 + 6;
            float r52 = r29[r116] + r20;
            float r53 = r29[r23 + 0];
            float r54 = r29[r23 + 1];
            float r117 = r29[r23 + 2];
            if (r29[r23 + 3] == 0.0f) goto L102;
            boolean r211 = true;
        L104:
            if (r29[r23 + 4] == 0.0f) goto L106;
            boolean r212 = true;
        L107:
            r210 = r23;
            drawArc(r25, r18, r20, r51, r52, r53, r54, r117, r211, r212);
            r18 = r18 + r29[r115];
            r20 = r20 + r29[r116];
            goto L121
        L106:
            r212 = false;
            goto L107
        L102:
            r211 = false;
            goto L104
        L27:
            if (r11 != 'c') goto L29;
            int r118 = r23 + 2;
            int r119 = r23 + 3;
            int r120 = r23 + 4;
            int r213 = r23 + 5;
            r25.rCubicTo(r29[r23 + 0], r29[r23 + 1], r29[r118], r29[r119], r29[r120], r29[r213]);
            float r55 = r29[r118] + r18;
            float r56 = r29[r119] + r20;
            r18 = r18 + r29[r120];
            float r57 = r29[r213];
        L97:
            r20 = r20 + r57;
        L98:
            r14 = r55;
            r15 = r56;
        L48:
            r210 = r23;
            goto L122
        L29:
            if (r11 != 'h') goto L31;
            int r58 = r23 + 0;
            r25.rLineTo(r29[r58], 0.0f);
            r18 = r18 + r29[r58];
            goto L48
        L31:
            if (r11 != 'q') goto L33;
            int r59 = r23 + 0;
            int r60 = r23 + 1;
            int r61 = r23 + 2;
            int r62 = r23 + 3;
            r25.rQuadTo(r29[r59], r29[r60], r29[r61], r29[r62]);
            r55 = r29[r59] + r18;
            r56 = r29[r60] + r20;
            r18 = r18 + r29[r61];
            r57 = r29[r62];
            goto L97
        L33:
            if (r11 != 'v') goto L35;
            int r63 = r23 + 0;
            r25.rLineTo(0.0f, r29[r63]);
            float r64 = r29[r63];
        L72:
            r20 = r20 + r64;
            goto L48
        L35:
            if (r11 != 'L') goto L37;
            int r65 = r23 + 0;
            int r66 = r23 + 1;
            r25.lineTo(r29[r65], r29[r66]);
            r18 = r29[r65];
            r20 = r29[r66];
            goto L48
        L37:
            if (r11 != 'M') goto L39;
            int r67 = r23 + 0;
            r18 = r29[r67];
            int r68 = r23 + 1;
            r20 = r29[r68];
            if (r23 <= 0) goto L90;
            r25.lineTo(r29[r67], r29[r68]);
            goto L48
        L90:
            r25.moveTo(r29[r67], r29[r68]);
        L91:
            r210 = r23;
            r22 = r20;
            r21 = r18;
            goto L122
        L39:
            if (r11 != 'S') goto L41;
            if (r24 == 'c') goto L85;
            if (r24 == 's') goto L85;
            if (r24 == 'C') goto L85;
            if (r24 == 'S') goto L85;
        L86:
            float r69 = r20;
            int r70 = r23 + 0;
            int r71 = r23 + 1;
            int r121 = r23 + 2;
            int r122 = r23 + 3;
            r25.cubicTo(r18, r69, r29[r70], r29[r71], r29[r121], r29[r122]);
            r55 = r29[r70];
            r56 = r29[r71];
            r18 = r29[r121];
            r20 = r29[r122];
        L85:
            r18 = (r18 * 2.0f) - r14;
            r20 = (r20 * 2.0f) - r15;
            goto L86
        L41:
            if (r11 != 'T') goto L43;
            if (r24 == 'q') goto L77;
            if (r24 == 't') goto L77;
            if (r24 == 'Q') goto L77;
            if (r24 == 'T') goto L77;
        L78:
            int r72 = r23 + 0;
            int r73 = r23 + 1;
            r25.quadTo(r18, r20, r29[r72], r29[r73]);
            float r74 = r29[r72];
            float r75 = r29[r73];
            r210 = r23;
            r15 = r20;
            r14 = r18;
            r18 = r74;
            r20 = r75;
        L77:
            r18 = (r18 * 2.0f) - r14;
            r20 = (r20 * 2.0f) - r15;
            goto L78
        L43:
            if (r11 != 'l') goto L45;
            int r76 = r23 + 0;
            int r77 = r23 + 1;
            r25.rLineTo(r29[r76], r29[r77]);
            r18 = r18 + r29[r76];
            r64 = r29[r77];
            goto L72
        L45:
            if (r11 == 'm') goto L67;
            if (r11 == 's') goto L57;
            if (r11 != 't') goto L48;
            if (r24 == 'q') goto L55;
            if (r24 == 't') goto L55;
            if (r24 == 'Q') goto L55;
            if (r24 == 'T') goto L55;
            float r78 = 0.0f;
            float r79 = 0.0f;
        L56:
            int r80 = r23 + 0;
            int r81 = r23 + 1;
            r25.rQuadTo(r79, r78, r29[r80], r29[r81]);
            float r82 = r79 + r18;
            float r83 = r78 + r20;
            r18 = r18 + r29[r80];
            r20 = r20 + r29[r81];
            r15 = r83;
            r14 = r82;
        L55:
            r79 = r18 - r14;
            r78 = r20 - r15;
            goto L56
        L57:
            if (r24 == 'c') goto L65;
            if (r24 == 's') goto L65;
            if (r24 == 'C') goto L65;
            if (r24 == 'S') goto L65;
            float r84 = 0.0f;
            float r85 = 0.0f;
        L66:
            int r123 = r23 + 0;
            int r124 = r23 + 1;
            int r125 = r23 + 2;
            int r214 = r23 + 3;
            r25.rCubicTo(r84, r85, r29[r123], r29[r124], r29[r125], r29[r214]);
            r55 = r29[r123] + r18;
            r56 = r29[r124] + r20;
            r18 = r18 + r29[r125];
            r57 = r29[r214];
        L65:
            float r86 = r18 - r14;
            r85 = r20 - r15;
            r84 = r86;
            goto L66
        L67:
            int r87 = r23 + 0;
            r18 = r18 + r29[r87];
            int r88 = r23 + 1;
            r20 = r20 + r29[r88];
            if (r23 <= 0) goto L70;
            r25.rLineTo(r29[r87], r29[r88]);
            goto L48
        L70:
            r25.rMoveTo(r29[r87], r29[r88]);
            goto L91
        L123:
            r26[r13 ? 1 : 0] = r18;
            r26[1] = r20;
            r26[2] = r14;
            r26[3] = r15;
            r26[4] = r21;
            r26[5] = r22;
            return;
        L5:
            r25.close();
            r25.moveTo(r16, r17);
            r10 = r16;
            r14 = r10;
            r12 = r17;
            r15 = r12;
            goto L4
        L6:
            r19 = 4;
            goto L11
        L7:
            r19 = 1;
            goto L11
        L8:
            int r89 = 6;
        L10:
            r19 = r89;
            goto L11
        L9:
            r89 = 7;
            goto L10
        }

        private static void arcToBezier(Path r49, double r50, double r52, double r54, double r56, double r58, double r60, double r62, double r64, double r66) {
            double r10 = r54;
            int r11 = (int) Math.ceil(Math.abs((r66 * 4.0d) / 3.141592653589793d));
            double r12 = Math.cos(r62);
            double r13 = Math.sin(r62);
            double r14 = Math.cos(r64);
            double r15 = Math.sin(r64);
            double r16 = -r10;
            double r17 = r16 * r12;
            double r19 = r56 * r13;
            double r18 = (r17 * r15) - (r19 * r14);
            double r110 = r16 * r13;
            double r21 = r56 * r12;
            double r111 = (r15 * r110) + (r14 * r21);
            double r20 = r66 / ((double) r11);
            double r25 = r111;
            double r27 = r18;
            int r22 = 0;
            double r112 = r58;
            double r113 = r60;
            double r23 = r64;
        L3:
            if (r22 >= r11) goto L5;
            double r31 = r23 + r20;
            double r33 = Math.sin(r31);
            double r35 = Math.cos(r31);
            double r24 = (r50 + ((r10 * r12) * r35)) - (r19 * r33);
            double r26 = (r52 + ((r10 * r13) * r35)) + (r21 * r33);
            double r37 = (r17 * r33) - (r19 * r35);
            double r34 = (r33 * r110) + (r35 * r21);
            double r28 = r31 - r23;
            double r36 = Math.tan(r28 / 2.0d);
            double r29 = (Math.sin(r28) * (Math.sqrt(((r36 * 3.0d) * r36) + 4.0d) - 1.0d)) / 3.0d;
            double r114 = r112 + (r27 * r29);
            double r210 = r12;
            double r63 = r13;
            r49.rLineTo(0.0f, 0.0f);
            r49.cubicTo((float) r114, (float) (r113 + (r25 * r29)), (float) (r24 - (r29 * r37)), (float) (r26 - (r29 * r34)), (float) r24, (float) r26);
            r22 = r22 + 1;
            r20 = r20;
            r13 = r63;
            r112 = r24;
            r110 = r110;
            r12 = r210;
            r23 = r31;
            r25 = r34;
            r27 = r37;
            r11 = r11;
            r113 = r26;
            r10 = r54;
            goto L3
        }

        private static void drawArc(Path r41, float r42, float r43, float r44, float r45, float r46, float r47, float r48, boolean r49, boolean r50) {
            double r19 = Math.toRadians(r48);
            double r10 = Math.cos(r19);
            double r11 = Math.sin(r19);
            double r13 = r42;
            double r15 = r13 * r10;
            double r14 = r43;
            double r12 = r46;
            double r16 = (r15 + (r14 * r11)) / r12;
            double r17 = (((double) (-r42)) * r11) + (r14 * r10);
            double r18 = r47;
            double r20 = r17 / r18;
            double r21 = r45;
            double r22 = ((((double) r44) * r10) + (r21 * r11)) / r12;
            double r23 = ((((double) (-r44)) * r11) + (r21 * r10)) / r18;
            double r24 = r16 - r22;
            double r27 = r20 - r23;
            double r29 = (r16 + r22) / 2.0d;
            double r33 = (r20 + r23) / 2.0d;
            double r110 = (r24 * r24) + (r27 * r27);
            if (r110 != 0.0d) goto L6;
            Log.w(PathParser.LOGTAG, " Points are coincident");
            return;
        L6:
            double r35 = (1.0d / r110) - 0.25d;
            if (r35 >= 0.0d) goto L10;
            Log.w(PathParser.LOGTAG, "Points are too far apart " + r110);
            float r25 = (float) (Math.sqrt(r110) / 1.99999d);
            drawArc(r41, r42, r43, r44, r45, r46 * r25, r47 * r25, r48, r49, r50);
            return;
        L10:
            double r111 = Math.sqrt(r35);
            double r26 = r24 * r111;
            double r112 = r111 * r27;
            if (r49 != r50) goto L13;
            double r210 = r29 - r112;
            double r34 = r33 + r26;
        L14:
            double r28 = Math.atan2(r20 - r34, r16 - r210);
            double r30 = Math.atan2(r23 - r34, r22 - r210) - r28;
            if (r30 < 0.0d) goto L17;
            boolean r31 = true;
        L18:
            if (r50 != r31) goto L20;
        L23:
            double r211 = r210 * r12;
            double r36 = r34 * r18;
            arcToBezier(r41, (r211 * r10) - (r36 * r11), (r211 * r11) + (r36 * r10), r12, r18, r13, r14, r19, r28, r30);
            return;
        L20:
            if (r30 <= 0.0d) goto L22;
            r30 = r30 - 6.283185307179586d;
            goto L23
        L22:
            r30 = r30 + 6.283185307179586d;
            goto L23
        L17:
            r31 = false;
            goto L18
        L13:
            r210 = r29 + r112;
            r34 = r33 - r26;
            goto L14
        }

        public static void nodesToPath(PathDataNode[] r10, Path r11) {
            float[] r12 = new float[6];
            char r13 = 'm';
            int r14 = 0;
        L4:
            if (r14 >= r10.length) goto L6;
            addCommand(r11, r12, r13, r10[r14].mType, r10[r14].mParams);
            r13 = r10[r14].mType;
            r14 = r14 + 1;
            goto L4
        }

        public void interpolatePathDataNode(PathDataNode r10, PathDataNode r11, float r12) {
            this.mType = r10.mType;
            int r13 = 0;
        L3:
            float[] r14 = r10.mParams;
            if (r13 >= r14.length) goto L6;
            this.mParams[r13] = (r14[r13] * (1.0f - r12)) + (r11.mParams[r13] * r12);
            r13 = r13 + 1;
            goto L3
        }
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> r10, char r11, float[] r12) {
        r10.add(new PathDataNode(r11, r12));
    }

    public static boolean canMorph(@Nullable PathDataNode[] r10, @Nullable PathDataNode[] r11) {
        if (r10 == null) goto L21;
        if (r11 == null) goto L21;
        if (r10.length == r11.length) goto L9;
        return false;
    L9:
        int r12 = 0;
    L11:
        if (r12 >= r10.length) goto L19;
        if (r10[r12].mType != r11[r12].mType) goto L18;
        if (r10[r12].mParams.length != r11[r12].mParams.length) goto L18;
        r12 = r12 + 1;
    L18:
        return false;
    L19:
        return true;
    L21:
        return false;
    }

    static float[] copyOfRange(float[] r10, int r11, int r12) {
        if (r11 > r12) goto L11;
        int r13 = r10.length;
        if (r11 < 0) goto L9;
        if (r11 > r13) goto L9;
        int r14 = r12 - r11;
        int r15 = Math.min(r14, r13 - r11);
        float[] r16 = new float[r14];
        System.arraycopy(r10, r11, r16, 0, r15);
        return r16;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException();
    }

    public static PathDataNode[] createNodesFromPathData(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
        int r12 = 1;
        int r13 = 0;
    L7:
        if (r12 >= r10.length()) goto L13;
        int r14 = nextStart(r10, r12);
        String r15 = r10.substring(r13, r14).trim();
        if (r15.length() <= 0) goto L11;
        addNode(r11, r15.charAt(0), getFloats(r15));
    L11:
        r13 = r14;
        r12 = r14 + 1;
        goto L7
    L13:
        if ((r12 - r13) != 1) goto L18;
        if (r13 >= r10.length()) goto L18;
        addNode(r11, r10.charAt(r13), new float[0]);
    L18:
        return (PathDataNode[]) r11.toArray(new PathDataNode[r11.size()]);
    }

    public static Path createPathFromPathData(String r10) {
        Path r11 = new Path();
        PathDataNode[] r12 = createNodesFromPathData(r10);
        if (r12 != null) goto L11;
        return null;
    L11:
        PathDataNode.nodesToPath(r12, r11);     // Catch: RuntimeException -> L6
        return r11;
    L6:
        e = move-exception;
        throw new RuntimeException("Error in parsing " + r10, e);
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        PathDataNode[] r11 = new PathDataNode[r10.length];
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L9;
        r11[r12] = new PathDataNode(r10[r12]);
        r12 = r12 + 1;
        goto L7
    L9:
        return r11;
    }

    private static void extract(String r10, int r11, ExtractFloatResult r12) {
        r12.mEndWithNegOrDot = false;
        int r13 = r11;
        boolean r14 = false;
        boolean r15 = false;
        boolean r16 = false;
    L4:
        if (r13 >= r10.length()) goto L25;
        char r17 = r10.charAt(r13);
        if (r17 != ' ') goto L8;
    L21:
        r14 = false;
        r16 = true;
    L22:
        if (r16 == true) goto L25;
        r13 = r13 + 1;
        goto L4
    L8:
        if (r17 != 'E') goto L10;
    L20:
        r14 = true;
        goto L22
    L10:
        if (r17 == 'e') goto L20;
        switch(r17) {
            case 44: goto L21;
            case 45: goto L16;
            case 46: goto L13;
            default: goto L30;
        };
    L13:
        if (r15 == true) goto L15;
        r14 = false;
        r15 = true;
    L15:
        r12.mEndWithNegOrDot = true;
        goto L21
    L16:
        if (r13 == r11) goto L19;
        if (r14 == false) goto L15;
        r14 = false;
        goto L22
    L19:
        r14 = false;
        goto L22
    L30:
        r14 = false;
    L25:
        r12.mEndPosition = r13;
    }

    private static float[] getFloats(String r10) {
        if (r10.charAt(0) == 'z') goto L22;
        if (r10.charAt(0) == 'Z') goto L22;
        float[] r11 = new float[r10.length()];     // Catch: NumberFormatException -> L18
        ExtractFloatResult r12 = new ExtractFloatResult();     // Catch: NumberFormatException -> L18
        int r13 = r10.length();     // Catch: NumberFormatException -> L18
        int r14 = 1;
        int r15 = 0;
    L8:
        if (r14 >= r13) goto L16;
        extract(r10, r14, r12);     // Catch: NumberFormatException -> L18
        int r16 = r12.mEndPosition;     // Catch: NumberFormatException -> L18
        if (r14 >= r16) goto L13;
        r11[r15] = Float.parseFloat(r10.substring(r14, r16));     // Catch: NumberFormatException -> L18
        r15 = r15 + 1;     // Catch: NumberFormatException -> L18
    L13:
        if (r12.mEndWithNegOrDot == true) goto L14;
        r14 = r16 + 1;     // Catch: NumberFormatException -> L18
        goto L8
    L14:
        r14 = r16;
        goto L8
    L16:
        return copyOfRange(r11, 0, r15);
    L18:
        e = move-exception;
        throw new RuntimeException("error in parsing \"" + r10 + "\"", e);
    L22:
        return new float[0];
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] r10, PathDataNode[] r11, PathDataNode[] r12, float r13) {
        if (r10 == null) goto L20;
        if (r11 == null) goto L20;
        if (r12 == null) goto L20;
        if (r10.length != r11.length) goto L18;
        if (r11.length != r12.length) goto L18;
        int r14 = 0;
        if (canMorph(r11, r12) == true) goto L13;
        return false;
    L13:
        if (r14 >= r10.length) goto L15;
        r10[r14].interpolatePathDataNode(r11[r14], r12[r14], r13);
        r14 = r14 + 1;
        goto L13
    L15:
        return true;
    L18:
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    L20:
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
    }

    private static int nextStart(String r10, int r11) {
    L3:
        if (r11 >= r10.length()) goto L14;
        char r12 = r10.charAt(r11);
        if (((r12 - 'A') * (r12 - 'Z')) <= 0) goto L9;
        if (((r12 - 'a') * (r12 - 'z')) <= 0) goto L9;
    L13:
        r11 = r11 + 1;
    L9:
        if (r12 == 'e') goto L13;
        if (r12 == 'E') goto L13;
        return r11;
    L14:
        return r11;
    }

    public static void updateNodes(PathDataNode[] r10, PathDataNode[] r11) {
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L10;
        r10[r12].mType = r11[r12].mType;
        int r13 = 0;
    L7:
        if (r13 >= r11[r12].mParams.length) goto L9;
        r10[r12].mParams[r13] = r11[r12].mParams[r13];
        r13 = r13 + 1;
        goto L7
    L9:
        r12 = r12 + 1;
        goto L4
    }
}
