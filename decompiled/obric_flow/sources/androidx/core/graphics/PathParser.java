package androidx.core.graphics;

import ai.j0;
import android.graphics.Path;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        public ExtractFloatResult() {
        }
    }

    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public PathDataNode(char r5, float[] r10) {
            this.mType = r5;
            this.mParams = r10;
        }

        public static /* synthetic */ char access$000(PathDataNode r5) {
            return r5.mType;
        }

        public static /* synthetic */ char access$002(PathDataNode r5, char r10) {
            r5.mType = r10;
            return r10;
        }

        public static /* synthetic */ float[] access$100(PathDataNode r5) {
            return r5.mParams;
        }

        public static /* synthetic */ void access$200(Path r5, float[] r10, char r11, char r12, float[] r13) {
            addCommand(r5, r10, r11, r12, r13);
        }

        private static void addCommand(Path r25, float[] r26, char r27, char r28, float[] r29) {
            char r11 = r28;
            boolean r13 = false;
            float r5 = r26[0];
            float r10 = r26[1];
            float r12 = r26[2];
            float r14 = r26[3];
            float r15 = r26[4];
            float r16 = r26[5];
            switch(r11) {
                case 65: goto L10;
                case 67: goto L8;
                case 72: goto L7;
                case 76: goto L4;
                case 77: goto L4;
                case 81: goto L6;
                case 83: goto L6;
                case 84: goto L4;
                case 86: goto L7;
                case 90: goto L5;
                case 97: goto L10;
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
            float r17 = r5;
            float r18 = r10;
            float r20 = r15;
            float r21 = r16;
            int r22 = 0;
            char r23 = r27;
        L13:
            if (r22 >= r29.length) goto L125;
            if (r11 != 'A') goto L17;
            int r24 = r22;
            float r110 = r18;
            float r111 = r17;
            int r112 = r24 + 5;
            float r30 = r29[r112];
            int r113 = r24 + 6;
            float r31 = r29[r113];
            float r32 = r29[r24];
            float r33 = r29[r24 + 1];
            float r34 = r29[r24 + 2];
            if (r29[r24 + 3] == 0.0f) goto L118;
            boolean r35 = true;
        L120:
            if (r29[r24 + 4] == 0.0f) goto L122;
            boolean r36 = true;
        L123:
            drawArc(r25, r111, r110, r30, r31, r32, r33, r34, r35, r36);
            r17 = r29[r112];
            r18 = r29[r113];
        L110:
            r14 = r18;
            r12 = r17;
        L124:
            r22 = r24 + r19;
            r23 = r28;
            r11 = r23;
            r13 = false;
            goto L13
        L122:
            r36 = false;
            goto L123
        L118:
            r35 = false;
            goto L120
        L17:
            if (r11 != 'C') goto L19;
            r24 = r22;
            int r37 = r24 + 2;
            int r38 = r24 + 3;
            int r39 = r24 + 4;
            int r114 = r24 + 5;
            r25.cubicTo(r29[r24], r29[r24 + 1], r29[r37], r29[r38], r29[r39], r29[r114]);
            r17 = r29[r39];
            float r40 = r29[r114];
            float r41 = r29[r37];
            float r42 = r29[r38];
            r18 = r40;
            r14 = r42;
            r12 = r41;
            goto L124
        L19:
            if (r11 != 'H') goto L21;
            r24 = r22;
            r25.lineTo(r29[r24], r18);
            r17 = r29[r24];
            goto L124
        L21:
            if (r11 != 'Q') goto L23;
            r24 = r22;
            int r43 = r24 + 1;
            int r44 = r24 + 2;
            int r45 = r24 + 3;
            r25.quadTo(r29[r24], r29[r43], r29[r44], r29[r45]);
            float r46 = r29[r24];
            float r47 = r29[r43];
            r17 = r29[r44];
            r18 = r29[r45];
            r12 = r46;
            r14 = r47;
            goto L124
        L23:
            if (r11 != 'V') goto L25;
            r24 = r22;
            r25.lineTo(r17, r29[r24]);
            r18 = r29[r24];
            goto L124
        L25:
            if (r11 != 'a') goto L27;
            int r115 = r22 + 5;
            float r48 = r29[r115] + r17;
            int r116 = r22 + 6;
            float r49 = r29[r116] + r18;
            float r50 = r29[r22];
            float r51 = r29[r22 + 1];
            float r117 = r29[r22 + 2];
            if (r29[r22 + 3] == 0.0f) goto L104;
            boolean r210 = true;
        L106:
            if (r29[r22 + 4] == 0.0f) goto L108;
            boolean r211 = true;
        L109:
            r24 = r22;
            drawArc(r25, r17, r18, r48, r49, r50, r51, r117, r210, r211);
            r17 = r17 + r29[r115];
            r18 = r18 + r29[r116];
            goto L110
        L108:
            r211 = false;
            goto L109
        L104:
            r210 = false;
            goto L106
        L27:
            if (r11 != 'c') goto L29;
            int r118 = r22 + 2;
            int r119 = r22 + 3;
            int r120 = r22 + 4;
            int r212 = r22 + 5;
            r25.rCubicTo(r29[r22], r29[r22 + 1], r29[r118], r29[r119], r29[r120], r29[r212]);
            float r52 = r29[r118] + r17;
            float r53 = r29[r119] + r18;
            r17 = r17 + r29[r120];
            float r54 = r29[r212];
        L67:
            r18 = r18 + r54;
        L68:
            r12 = r52;
            r14 = r53;
        L48:
            r24 = r22;
            goto L124
        L29:
            if (r11 != 'h') goto L31;
            r25.rLineTo(r29[r22], 0.0f);
            r17 = r17 + r29[r22];
            goto L48
        L31:
            if (r11 != 'q') goto L33;
            int r55 = r22 + 1;
            int r56 = r22 + 2;
            int r57 = r22 + 3;
            r25.rQuadTo(r29[r22], r29[r55], r29[r56], r29[r57]);
            r52 = r29[r22] + r17;
            r53 = r29[r55] + r18;
            r17 = r17 + r29[r56];
            r54 = r29[r57];
            goto L67
        L33:
            if (r11 != 'v') goto L35;
            r25.rLineTo(0.0f, r29[r22]);
            float r58 = r29[r22];
        L75:
            r18 = r18 + r58;
            goto L48
        L35:
            if (r11 != 'L') goto L37;
            int r59 = r22 + 1;
            r25.lineTo(r29[r22], r29[r59]);
            r17 = r29[r22];
            r18 = r29[r59];
            goto L48
        L37:
            if (r11 != 'M') goto L39;
            r17 = r29[r22];
            r18 = r29[r22 + 1];
            if (r22 <= 0) goto L95;
            r25.lineTo(r17, r18);
            goto L48
        L95:
            r25.moveTo(r17, r18);
        L73:
            r24 = r22;
            r21 = r18;
            r20 = r17;
            goto L124
        L39:
            if (r11 != 'S') goto L41;
            if (r23 == 'c') goto L90;
            if (r23 == 's') goto L90;
            if (r23 == 'C') goto L90;
            if (r23 == 'S') goto L90;
        L89:
            float r60 = r18;
            float r61 = r17;
            int r62 = r22 + 1;
            int r63 = r22 + 2;
            int r121 = r22 + 3;
            r25.cubicTo(r61, r60, r29[r22], r29[r62], r29[r63], r29[r121]);
            r52 = r29[r22];
            r53 = r29[r62];
            r17 = r29[r63];
            r18 = r29[r121];
        L90:
            r17 = (r17 * 2.0f) - r12;
            r18 = (r18 * 2.0f) - r14;
            goto L89
        L41:
            if (r11 != 'T') goto L43;
            if (r23 == 'q') goto L80;
            if (r23 == 't') goto L80;
            if (r23 == 'Q') goto L80;
            if (r23 == 'T') goto L80;
        L81:
            int r64 = r22 + 1;
            r25.quadTo(r17, r18, r29[r22], r29[r64]);
            r24 = r22;
            r14 = r18;
            r12 = r17;
            r17 = r29[r22];
            r18 = r29[r64];
        L80:
            r17 = (r17 * 2.0f) - r12;
            r18 = (r18 * 2.0f) - r14;
            goto L81
        L43:
            if (r11 != 'l') goto L45;
            int r65 = r22 + 1;
            r25.rLineTo(r29[r22], r29[r65]);
            r17 = r17 + r29[r22];
            r58 = r29[r65];
            goto L75
        L45:
            if (r11 == 'm') goto L69;
            if (r11 == 's') goto L57;
            if (r11 != 't') goto L48;
            if (r23 == 'q') goto L55;
            if (r23 == 't') goto L55;
            if (r23 == 'Q') goto L55;
            if (r23 == 'T') goto L55;
            float r66 = 0.0f;
            float r67 = 0.0f;
        L56:
            int r68 = r22 + 1;
            r25.rQuadTo(r67, r66, r29[r22], r29[r68]);
            float r69 = r67 + r17;
            float r70 = r66 + r18;
            r17 = r17 + r29[r22];
            r18 = r18 + r29[r68];
            r14 = r70;
            r12 = r69;
        L55:
            r67 = r17 - r12;
            r66 = r18 - r14;
            goto L56
        L57:
            if (r23 == 'c') goto L65;
            if (r23 == 's') goto L65;
            if (r23 == 'C') goto L65;
            if (r23 == 'S') goto L65;
            float r71 = 0.0f;
            float r72 = 0.0f;
        L66:
            int r122 = r22 + 1;
            int r123 = r22 + 2;
            int r124 = r22 + 3;
            r25.rCubicTo(r71, r72, r29[r22], r29[r122], r29[r123], r29[r124]);
            r52 = r29[r22] + r17;
            r53 = r29[r122] + r18;
            r17 = r17 + r29[r123];
            r54 = r29[r124];
        L65:
            float r73 = r17 - r12;
            r72 = r18 - r14;
            r71 = r73;
            goto L66
        L69:
            float r74 = r29[r22];
            r17 = r17 + r74;
            float r75 = r29[r22 + 1];
            r18 = r18 + r75;
            if (r22 <= 0) goto L72;
            r25.rLineTo(r74, r75);
            goto L48
        L72:
            r25.rMoveTo(r74, r75);
            goto L73
        L125:
            r26[r13 ? 1 : 0] = r17;
            r26[1] = r18;
            r26[2] = r12;
            r26[3] = r14;
            r26[4] = r20;
            r26[5] = r21;
            return;
        L5:
            r25.close();
            r25.moveTo(r15, r16);
            r5 = r15;
            r12 = r5;
            r10 = r16;
            r14 = r10;
            goto L4
        L6:
            r19 = 4;
            goto L11
        L7:
            r19 = 1;
            goto L11
        L8:
            int r76 = 6;
        L9:
            r19 = r76;
            goto L11
        L10:
            r76 = 7;
            goto L9
        }

        private static void arcToBezier(Path r51, double r52, double r54, double r56, double r58, double r60, double r62, double r64, double r66, double r68) {
            int r5 = (int) Math.ceil(Math.abs((r68 * 4.0d) / 3.141592653589793d));
            double r10 = Math.cos(r64);
            double r11 = Math.sin(r64);
            double r12 = Math.cos(r66);
            double r13 = Math.sin(r66);
            double r14 = -r56;
            double r15 = r14 * r10;
            double r19 = r58 * r11;
            double r17 = (r15 * r13) - (r19 * r12);
            double r16 = r14 * r11;
            double r21 = r58 * r10;
            double r18 = (r12 * r21) + (r13 * r16);
            double r20 = r68 / ((double) r5);
            double r25 = r18;
            double r27 = r17;
            int r22 = 0;
            double r23 = r60;
            double r110 = r62;
            double r24 = r66;
        L3:
            if (r22 >= r5) goto L5;
            double r31 = r24 + r20;
            double r33 = Math.sin(r31);
            double r35 = Math.cos(r31);
            double r26 = j0.B(r56, r10, r35, r52) - (r19 * r33);
            double r42 = r10;
            double r28 = (r21 * r33) + j0.B(r56, r11, r35, r54);
            double r37 = (r15 * r33) - (r19 * r35);
            double r34 = (r35 * r21) + (r33 * r16);
            double r29 = r31 - r24;
            double r36 = Math.tan(r29 / 2.0d);
            double r38 = ((Math.sqrt(j0.B(r36, 3.0d, r36, 4.0d)) - 1.0d) * Math.sin(r29)) / 3.0d;
            double r65 = r11;
            double r59 = r20;
            r51.rLineTo(0.0f, 0.0f);
            r51.cubicTo((float) ((r27 * r38) + r23), (float) ((r25 * r38) + r110), (float) (r26 - (r38 * r37)), (float) (r28 - (r38 * r34)), (float) r26, (float) r28);
            r22 = r22 + 1;
            r20 = r59;
            r11 = r65;
            r23 = r26;
            r16 = r16;
            r24 = r31;
            r25 = r34;
            r27 = r37;
            r5 = r5;
            r110 = r28;
            r10 = r42;
            goto L3
        }

        private static void drawArc(Path r41, float r42, float r43, float r44, float r45, float r46, float r47, float r48, boolean r49, boolean r50) {
            double r19 = Math.toRadians(r48);
            double r5 = Math.cos(r19);
            double r10 = Math.sin(r19);
            double r13 = r42;
            double r15 = r13 * r5;
            double r14 = r43;
            double r11 = r46;
            double r21 = ((r14 * r10) + r15) / r11;
            double r12 = r47;
            double r16 = ((r14 * r5) + (((double) (-r42)) * r10)) / r12;
            double r17 = r45;
            double r25 = ((r17 * r10) + (((double) r44) * r5)) / r11;
            double r18 = ((r17 * r5) + (((double) (-r44)) * r10)) / r12;
            double r110 = r21 - r25;
            double r27 = r16 - r18;
            double r29 = (r21 + r25) / 2.0d;
            double r33 = (r16 + r18) / 2.0d;
            double r111 = (r27 * r27) + (r110 * r110);
            if (r111 != 0.0d) goto L6;
            Log.w(PathParser.LOGTAG, " Points are coincident");
            return;
        L6:
            double r35 = (1.0d / r111) - 0.25d;
            if (r35 >= 0.0d) goto L10;
            Log.w(PathParser.LOGTAG, "Points are too far apart " + r111);
            float r20 = (float) (Math.sqrt(r111) / 1.99999d);
            drawArc(r41, r42, r43, r44, r45, r46 * r20, r47 * r20, r48, r49, r50);
            return;
        L10:
            double r112 = Math.sqrt(r35);
            double r113 = r110 * r112;
            double r114 = r112 * r27;
            if (r49 != r50) goto L13;
            double r210 = r29 - r114;
            double r34 = r33 + r113;
        L14:
            double r22 = Math.atan2(r16 - r34, r21 - r210);
            double r23 = Math.atan2(r18 - r34, r25 - r210) - r22;
            if (r23 < 0.0d) goto L17;
            boolean r115 = true;
        L18:
            if (r50 != r115) goto L20;
        L23:
            double r211 = r210 * r11;
            double r36 = r34 * r12;
            arcToBezier(r41, (r211 * r5) - (r36 * r10), (r36 * r5) + (r211 * r10), r11, r12, r13, r14, r19, r22, r23);
            return;
        L20:
            if (r23 <= 0.0d) goto L22;
            r23 = r23 - 6.283185307179586d;
            goto L23
        L22:
            r23 = r23 + 6.283185307179586d;
            goto L23
        L17:
            r115 = false;
            goto L18
        L13:
            r210 = r29 + r114;
            r34 = r33 - r113;
            goto L14
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static void nodesToPath(@NonNull PathDataNode[] r5, @NonNull Path r10) {
            PathParser.nodesToPath(r5, r10);
        }

        @NonNull
        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(@NonNull PathDataNode r5, @NonNull PathDataNode r10, float r11) {
            this.mType = r5.mType;
            int r12 = 0;
        L3:
            float[] r13 = r5.mParams;
            if (r12 >= r13.length) goto L6;
            float[] r14 = this.mParams;
            float r15 = 1.0f - r11;
            float r16 = r15 * r13[r12];
            r14[r12] = (r10.mParams[r12] * r11) + r16;
            r12 = r12 + 1;
            goto L3
        }

        public PathDataNode(PathDataNode r5) {
            this.mType = r5.mType;
            float[] r10 = r5.mParams;
            this.mParams = PathParser.copyOfRange(r10, 0, r10.length);
        }
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> r5, char r10, float[] r11) {
        r5.add(new PathDataNode(r10, r11));
    }

    public static boolean canMorph(@Nullable PathDataNode[] r5, @Nullable PathDataNode[] r10) {
        if (r5 == null) goto L21;
        if (r10 == null) goto L21;
        if (r5.length == r10.length) goto L9;
        return false;
    L9:
        int r11 = 0;
    L11:
        if (r11 >= r5.length) goto L19;
        if (PathDataNode.access$000(r5[r11]) != PathDataNode.access$000(r10[r11])) goto L18;
        if (PathDataNode.access$100(r5[r11]).length != PathDataNode.access$100(r10[r11]).length) goto L18;
        r11 = r11 + 1;
    L18:
        return false;
    L19:
        return true;
    L21:
        return false;
    }

    public static float[] copyOfRange(float[] r5, int r10, int r11) {
        if (r10 > r11) goto L11;
        int r12 = r5.length;
        if (r10 < 0) goto L9;
        if (r10 > r12) goto L9;
        int r13 = r11 - r10;
        int r14 = Math.min(r13, r12 - r10);
        float[] r15 = new float[r13];
        System.arraycopy(r5, r10, r15, 0, r14);
        return r15;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException();
    }

    @NonNull
    public static PathDataNode[] createNodesFromPathData(@NonNull String r10) {
        ArrayList r5 = new ArrayList();
        int r11 = 0;
        int r12 = 1;
    L4:
        if (r12 >= r10.length()) goto L10;
        int r13 = nextStart(r10, r12);
        String r14 = r10.substring(r11, r13).trim();
        if (r14.isEmpty() == true) goto L8;
        addNode(r5, r14.charAt(0), getFloats(r14));
    L8:
        r11 = r13;
        r12 = r13 + 1;
        goto L4
    L10:
        if ((r12 - r11) != 1) goto L15;
        if (r11 >= r10.length()) goto L15;
        addNode(r5, r10.charAt(r11), new float[0]);
    L15:
        return (PathDataNode[]) r5.toArray(new PathDataNode[0]);
    }

    @NonNull
    public static Path createPathFromPathData(@NonNull String r5) {
        Path r10 = new Path();
        PathDataNode.nodesToPath(createNodesFromPathData(r5), r10);     // Catch: RuntimeException -> L5
        return r10;
    L5:
        e = move-exception;
        throw new RuntimeException(j0.C("Error in parsing ", r5), e);
    }

    @NonNull
    public static PathDataNode[] deepCopyNodes(@NonNull PathDataNode[] r5) {
        PathDataNode[] r10 = new PathDataNode[r5.length];
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L6;
        r10[r11] = new PathDataNode(r5[r11]);
        r11 = r11 + 1;
        goto L4
    L6:
        return r10;
    }

    private static void extract(String r10, int r11, ExtractFloatResult r12) {
        r12.mEndWithNegOrDot = false;
        int r5 = r11;
        boolean r13 = false;
        boolean r14 = false;
        boolean r15 = false;
    L4:
        if (r5 >= r10.length()) goto L25;
        char r16 = r10.charAt(r5);
        if (r16 != ' ') goto L8;
    L16:
        r13 = false;
        r15 = true;
    L22:
        if (r15 == true) goto L25;
        r5 = r5 + 1;
        goto L4
    L8:
        if (r16 != 'E') goto L10;
    L21:
        r13 = true;
        goto L22
    L10:
        if (r16 == 'e') goto L21;
        switch(r16) {
            case 44: goto L16;
            case 45: goto L17;
            case 46: goto L13;
            default: goto L30;
        };
    L13:
        if (r14 == true) goto L15;
        r13 = false;
        r14 = true;
        goto L22
    L15:
        r12.mEndWithNegOrDot = true;
        goto L16
    L17:
        if (r5 == r11) goto L20;
        if (r13 == true) goto L29;
        r12.mEndWithNegOrDot = true;
        goto L16
    L29:
        r13 = false;
        goto L22
    L20:
        r13 = false;
        goto L22
    L30:
        r13 = false;
    L25:
        r12.mEndPosition = r5;
    }

    private static float[] getFloats(String r10) {
        if (r10.charAt(0) == 'z') goto L23;
        if (r10.charAt(0) == 'Z') goto L23;
        float[] r5 = new float[r10.length()];     // Catch: NumberFormatException -> L12
        ExtractFloatResult r11 = new ExtractFloatResult();     // Catch: NumberFormatException -> L12
        int r12 = r10.length();     // Catch: NumberFormatException -> L12
        int r13 = 1;
        int r14 = 0;
    L8:
        if (r13 >= r12) goto L18;
        extract(r10, r13, r11);     // Catch: NumberFormatException -> L12
        int r15 = r11.mEndPosition;     // Catch: NumberFormatException -> L12
        if (r13 >= r15) goto L15;
        r5[r14] = Float.parseFloat(r10.substring(r13, r15));     // Catch: NumberFormatException -> L12
        r14 = r14 + 1;     // Catch: NumberFormatException -> L12
    L15:
        if (r11.mEndWithNegOrDot == true) goto L16;
        r13 = r15 + 1;     // Catch: NumberFormatException -> L12
        goto L8
    L16:
        r13 = r15;
        goto L8
    L18:
        return copyOfRange(r5, 0, r14);
    L12:
        e = move-exception;
        throw new RuntimeException(j0.k("error in parsing \"", r10, "\""), e);
    L23:
        return new float[0];
    }

    public static void interpolatePathDataNodes(@NonNull PathDataNode[] r5, float r10, @NonNull PathDataNode[] r11, @NonNull PathDataNode[] r12) {
        if (interpolatePathDataNodes(r5, r11, r12, r10) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }

    private static int nextStart(String r5, int r10) {
    L3:
        if (r10 >= r5.length()) goto L14;
        char r11 = r5.charAt(r10);
        if (((r11 - 'Z') * (r11 - 'A')) <= 0) goto L9;
        if (((r11 - 'z') * (r11 - 'a')) <= 0) goto L9;
    L13:
        r10 = r10 + 1;
    L9:
        if (r11 == 'e') goto L13;
        if (r11 == 'E') goto L13;
        return r10;
    L14:
        return r10;
    }

    public static void nodesToPath(@NonNull PathDataNode[] r10, @NonNull Path r11) {
        float[] r5 = new float[6];
        int r12 = r10.length;
        char r13 = 'm';
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L5;
        PathDataNode r15 = r10[r14];
        PathDataNode.access$200(r11, r5, r13, PathDataNode.access$000(r15), PathDataNode.access$100(r15));
        r13 = PathDataNode.access$000(r15);
        r14 = r14 + 1;
        goto L3
    }

    public static void updateNodes(@NonNull PathDataNode[] r5, @NonNull PathDataNode[] r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L10;
        PathDataNode.access$002(r5[r11], PathDataNode.access$000(r10[r11]));
        int r12 = 0;
    L7:
        if (r12 >= PathDataNode.access$100(r10[r11]).length) goto L9;
        PathDataNode.access$100(r5[r11])[r12] = PathDataNode.access$100(r10[r11])[r12];
        r12 = r12 + 1;
        goto L7
    L9:
        r11 = r11 + 1;
        goto L4
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static boolean interpolatePathDataNodes(@NonNull PathDataNode[] r5, @NonNull PathDataNode[] r10, @NonNull PathDataNode[] r11, float r12) {
        if (r5.length != r10.length) goto L15;
        if (r10.length != r11.length) goto L15;
        int r13 = 0;
        if (canMorph(r10, r11) == true) goto L10;
        return false;
    L10:
        if (r13 >= r5.length) goto L12;
        r5[r13].interpolatePathDataNode(r10[r13], r11[r13], r12);
        r13 = r13 + 1;
        goto L10
    L12:
        return true;
    L15:
        throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
    }
}
