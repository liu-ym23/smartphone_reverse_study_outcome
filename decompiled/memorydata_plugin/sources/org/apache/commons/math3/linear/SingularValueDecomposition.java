package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class SingularValueDecomposition {
    private final RealMatrix cachedU;
    private RealMatrix cachedUt;
    private final RealMatrix cachedV;
    private final int m;
    private final int n;
    private final double[] singularValues;
    private final double tol;
    private final boolean transposed;

    /* JADX INFO: renamed from: org.apache.commons.math3.linear.SingularValueDecomposition$1, reason: invalid class name */
    class AnonymousClass1 extends DefaultRealMatrixPreservingVisitor {
        final /* synthetic */ SingularValueDecomposition this$0;
        final /* synthetic */ double[][] val$data;

        @Override // org.apache.commons.math3.linear.DefaultRealMatrixPreservingVisitor, org.apache.commons.math3.linear.RealMatrixPreservingVisitor
        public void visit(int r2, int r3, double r4) {
            this.val$data[r2][r3] = r4 / SingularValueDecomposition.access$000(this.this$0)[r2];
        }
    }

    private static class Solver implements DecompositionSolver {
        private boolean nonSingular;
        private final RealMatrix pseudoInverse;

        private Solver(double[] r9, RealMatrix r10, RealMatrix r11, boolean r12, double r13) {
            RealMatrix r14 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r10, RealMatrix.class, "com.obric.memorydata.plugin");
            RealMatrix r15 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r11, RealMatrix.class, "com.obric.memorydata.plugin");
            double[][] r16 = r14.getData();
            int r1 = 0;
        L4:
            if (r1 >= r9.length) goto L14;
            if (r9[r1] <= r13) goto L8;
            double r2 = 1.0d / r9[r1];
        L9:
            double[] r4 = r16[r1];
            int r5 = 0;
        L11:
            if (r5 >= r4.length) goto L13;
            r4[r5] = r4[r5] * r2;
            r5 = r5 + 1;
            goto L11
        L13:
            r1 = r1 + 1;
            goto L4
        L8:
            r2 = 0.0d;
            goto L9
        L14:
            this.pseudoInverse = r15.multiply(new Array2DRowRealMatrix(r16, false));
            this.nonSingular = r12;
        }

        /* synthetic */ Solver(double[] r9, RealMatrix r10, RealMatrix r11, boolean r12, double r13, AnonymousClass1 r15) {
            this(r9, (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r10, RealMatrix.class, "com.obric.memorydata.plugin"), (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r11, RealMatrix.class, "com.obric.memorydata.plugin"), r12, r13);
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealMatrix getInverse() {
            return this.pseudoInverse;
        }

        @Override // org.apache.commons.math3.linear.DecompositionSolver
        public RealVector solve(RealVector r1) {
            return this.pseudoInverse.operate(r1);
        }
    }

    public SingularValueDecomposition(RealMatrix r33) {
        SingularValueDecomposition r0 = this;
        RealMatrix r2 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r33, RealMatrix.class, "com.obric.memorydata.plugin");
        if (r2.getRowDimension() >= r2.getColumnDimension()) goto L5;
        r0.transposed = true;
        double[][] r3 = r2.transpose().getData();
        r0.m = r2.getColumnDimension();
        int r4 = r2.getRowDimension();
    L6:
        r0.n = r4;
        int r5 = r0.n;
        r0.singularValues = new double[r5];
        double[][] r6 = (double[][]) Array.newInstance(double.class, new int[]{r0.m, r5});
        int r7 = r0.n;
        double[][] r1 = (double[][]) Array.newInstance(double.class, new int[]{r7, r7});
        int r8 = r0.n;
        double[] r9 = new double[r8];
        int r10 = r0.m;
        double[] r11 = new double[r10];
        int r12 = FastMath.min(r10 - 1, r8);
        int r13 = FastMath.max(0, r0.n - 2);
        int r14 = 0;
    L7:
        double r15 = 0.0d;
        if (r14 >= FastMath.max(r12, r13)) goto L90;
        if (r14 >= r12) goto L25;
        r0.singularValues[r14] = 0.0d;
        int r16 = r14;
    L12:
        if (r16 >= r0.m) goto L14;
        double[] r17 = r0.singularValues;
        r17[r14] = FastMath.hypot(r17[r14], r3[r16][r14]);
        r16 = r16 + 1;
        goto L12
    L14:
        double[] r18 = r0.singularValues;
        if (r18[r14] != 0.0d) goto L17;
    L24:
        double[] r19 = r0.singularValues;
        r19[r14] = -r19[r14];
        goto L25
    L17:
        if (r3[r14][r14] >= 0.0d) goto L19;
        r18[r14] = -r18[r14];
    L19:
        int r20 = r14;
    L21:
        if (r20 >= r0.m) goto L23;
        double[] r21 = r3[r20];
        r21[r14] = r21[r14] / r0.singularValues[r14];
        r20 = r20 + 1;
        goto L21
    L23:
        double[] r22 = r3[r14];
        r22[r14] = r22[r14] + 1.0d;
    L25:
        int r23 = r14 + 1;
        int r24 = r23;
    L27:
        if (r24 >= r0.n) goto L40;
        if (r14 >= r12) goto L39;
        if (r0.singularValues[r14] == 0.0d) goto L39;
        int r25 = r14;
        double r110 = 0.0d;
    L33:
        if (r25 >= r0.m) goto L35;
        r110 = r110 + (r3[r25][r14] * r3[r25][r24]);
        r25 = r25 + 1;
        goto L33
    L35:
        double r111 = (-r110) / r3[r14][r14];
        int r26 = r14;
    L37:
        if (r26 >= r0.m) goto L39;
        double[] r112 = r3[r26];
        r112[r24] = r112[r24] + (r3[r26][r14] * r111);
        r26 = r26 + 1;
    L39:
        r9[r24] = r3[r14][r24];
        r24 = r24 + 1;
        goto L27
    L40:
        if (r14 >= r12) goto L45;
        int r27 = r14;
    L43:
        if (r27 >= r0.m) goto L45;
        r6[r27][r14] = r3[r27][r14];
        r27 = r27 + 1;
    L45:
        if (r14 >= r13) goto L88;
        r9[r14] = 0.0d;
        int r28 = r23;
    L48:
        if (r28 >= r0.n) goto L50;
        r9[r14] = FastMath.hypot(r9[r14], r9[r28]);
        r28 = r28 + 1;
        r6 = r6;
        r1 = r1;
        goto L48
    L50:
        double[][] r113 = r1;
        double[][] r29 = r6;
        if (r9[r14] != 0.0d) goto L53;
    L60:
        r9[r14] = -r9[r14];
        if (r23 < r0.m) goto L63;
    L84:
        int r30 = r23;
    L86:
        if (r30 >= r0.n) goto L89;
        r113[r30][r14] = r9[r30];
        r30 = r30 + 1;
    L89:
        r14 = r23;
        r6 = r29;
        r1 = r113;
        goto L7
    L63:
        if (r9[r14] == 0.0d) goto L84;
        int r31 = r23;
    L66:
        if (r31 >= r0.m) goto L68;
        r11[r31] = 0.0d;
        r31 = r31 + 1;
        goto L66
    L68:
        int r32 = r23;
    L70:
        if (r32 >= r0.n) goto L76;
        int r34 = r23;
    L73:
        if (r34 >= r0.m) goto L75;
        r11[r34] = r11[r34] + (r9[r32] * r3[r34][r32]);
        r34 = r34 + 1;
        goto L73
    L75:
        r32 = r32 + 1;
        goto L70
    L76:
        int r35 = r23;
    L78:
        if (r35 >= r0.n) goto L84;
        double r114 = (-r9[r35]) / r9[r23];
        int r36 = r23;
    L81:
        if (r36 >= r0.m) goto L83;
        double[] r37 = r3[r36];
        r37[r35] = r37[r35] + (r11[r36] * r114);
        r36 = r36 + 1;
        goto L81
    L83:
        r35 = r35 + 1;
        goto L78
    L53:
        if (r9[r23] >= 0.0d) goto L55;
        r9[r14] = -r9[r14];
    L55:
        int r38 = r23;
    L57:
        if (r38 >= r0.n) goto L59;
        r9[r38] = r9[r38] / r9[r14];
        r38 = r38 + 1;
        goto L57
    L59:
        r9[r23] = r9[r23] + 1.0d;
        goto L60
    L88:
        r113 = r1;
        r29 = r6;
        goto L89
    L90:
        double[][] r115 = r1;
        double[][] r39 = r6;
        int r40 = r0.n;
        if (r12 >= r40) goto L94;
        r0.singularValues[r12] = r3[r12][r12];
    L94:
        if (r0.m >= r40) goto L97;
        r0.singularValues[r40 - 1] = 0.0d;
    L97:
        if ((r13 + 1) >= r40) goto L99;
        r9[r13] = r3[r13][r40 - 1];
    L99:
        int r41 = r40 - 1;
        r9[r41] = 0.0d;
        int r42 = r12;
    L101:
        if (r42 >= r0.n) goto L107;
        int r43 = 0;
    L104:
        if (r43 >= r0.m) goto L106;
        r39[r43][r42] = 0.0d;
        r43 = r43 + 1;
        goto L104
    L106:
        r39[r42][r42] = 1.0d;
        r42 = r42 + 1;
        goto L101
    L107:
        int r44 = r12 - 1;
    L108:
        if (r44 < 0) goto L137;
        if (r0.singularValues[r44] == 0.0d) goto L131;
        int r45 = r44 + 1;
    L113:
        if (r45 >= r0.n) goto L123;
        int r46 = r44;
        double r116 = 0.0d;
    L116:
        if (r46 >= r0.m) goto L118;
        r116 = r116 + (r39[r46][r44] * r39[r46][r45]);
        r46 = r46 + 1;
        goto L116
    L118:
        double r47 = (-r116) / r39[r44][r44];
        int r117 = r44;
    L120:
        if (r117 >= r0.m) goto L122;
        double[] r118 = r39[r117];
        r118[r45] = r118[r45] + (r39[r117][r44] * r47);
        r117 = r117 + 1;
        goto L120
    L122:
        r45 = r45 + 1;
        goto L113
    L123:
        int r48 = r44;
    L125:
        if (r48 >= r0.m) goto L127;
        r39[r48][r44] = -r39[r48][r44];
        r48 = r48 + 1;
        goto L125
    L127:
        r39[r44][r44] = r39[r44][r44] + 1.0d;
        int r49 = 0;
    L129:
        if (r49 >= (r44 - 1)) goto L136;
        r39[r49][r44] = 0.0d;
        r49 = r49 + 1;
    L136:
        r44 = r44 - 1;
        goto L108
    L131:
        int r50 = 0;
    L133:
        if (r50 >= r0.m) goto L135;
        r39[r50][r44] = 0.0d;
        r50 = r50 + 1;
        goto L133
    L135:
        r39[r44][r44] = 1.0d;
        goto L136
    L137:
        int r51 = r0.n - 1;
    L138:
        if (r51 < 0) goto L160;
        if (r51 < r13) goto L141;
    L154:
        int r52 = 0;
    L156:
        if (r52 >= r0.n) goto L158;
        r115[r52][r51] = 0.0d;
        r52 = r52 + 1;
        goto L156
    L158:
        r115[r51][r51] = 1.0d;
        r51 = r51 - 1;
        goto L138
    L141:
        if (r9[r51] == 0.0d) goto L154;
        int r53 = r51 + 1;
        int r54 = r53;
    L144:
        if (r54 >= r0.n) goto L154;
        int r55 = r53;
        double r119 = 0.0d;
    L147:
        if (r55 >= r0.n) goto L149;
        r119 = r119 + (r115[r55][r51] * r115[r55][r54]);
        r55 = r55 + 1;
        goto L147
    L149:
        double r120 = (-r119) / r115[r53][r51];
        int r56 = r53;
    L151:
        if (r56 >= r0.n) goto L153;
        double[] r121 = r115[r56];
        r121[r54] = r121[r54] + (r115[r56][r51] * r120);
        r56 = r56 + 1;
        goto L151
    L153:
        r54 = r54 + 1;
    L160:
        if (r40 <= 0) goto L270;
        int r57 = r40 - 2;
        int r58 = r57;
    L163:
        if (r58 < 0) goto L168;
        if (FastMath.abs(r9[r58]) <= (((FastMath.abs(r0.singularValues[r58]) + FastMath.abs(r0.singularValues[r58 + 1])) * 2.220446049250313E-16d) + 1.6033346880071782E-291d)) goto L166;
        r58 = r58 - 1;
        goto L163
    L166:
        r9[r58] = r15;
    L168:
        if (r58 != r57) goto L171;
        char r59 = 4;
    L191:
        int r60 = r58 + 1;
        if (r59 != 1) goto L194;
        int r61 = r40;
        r41 = r41;
        double[][] r210 = r39;
        SingularValueDecomposition r62 = r0;
        double r63 = r9[r57];
        r9[r57] = 0.0d;
    L259:
        if (r57 < r60) goto L268;
        double r122 = FastMath.hypot(r62.singularValues[r57], r63);
        double[] r64 = r62.singularValues;
        double r123 = r64[r57] / r122;
        double r65 = r63 / r122;
        r64[r57] = r122;
        if (r57 == r60) goto L263;
        int r66 = r57 - 1;
        r63 = (-r65) * r9[r66];
        r9[r66] = r9[r66] * r123;
    L263:
        int r67 = 0;
    L265:
        if (r67 >= r62.n) goto L267;
        int r124 = r61 - 1;
        double r125 = (r115[r67][r57] * r123) + (r115[r67][r124] * r65);
        r115[r67][r124] = ((-r65) * r115[r67][r57]) + (r115[r67][r124] * r123);
        r115[r67][r57] = r125;
        r67 = r67 + 1;
        r63 = r63;
        goto L265
    L267:
        r57 = r57 - 1;
    L268:
        r40 = r61;
    L269:
        r0 = r62;
        r41 = r41;
        r39 = r210;
        r15 = 0.0d;
        goto L160
    L194:
        if (r59 != 2) goto L196;
        int r211 = r40;
        r41 = r41;
        r210 = r39;
        r62 = r0;
        int r68 = r60 - 1;
        double r69 = r9[r68];
        r9[r68] = 0.0d;
        r61 = r211;
        int r70 = r60;
    L252:
        if (r70 >= r61) goto L268;
        double r71 = FastMath.hypot(r62.singularValues[r70], r69);
        double[] r72 = r62.singularValues;
        double r126 = r72[r70] / r71;
        double r73 = r69 / r71;
        r72[r70] = r71;
        double r74 = -r73;
        double r127 = r9[r70] * r74;
        r9[r70] = r9[r70] * r126;
        int r75 = 0;
    L255:
        if (r75 >= r62.m) goto L257;
        double r128 = (r210[r75][r70] * r126) + (r210[r75][r68] * r73);
        r210[r75][r68] = (r210[r75][r70] * r74) + (r210[r75][r68] * r126);
        r210[r75][r70] = r128;
        r75 = r75 + 1;
        goto L255
    L257:
        r70 = r70 + 1;
        r69 = r127;
        goto L252
    L196:
        if (r59 == 3) goto L224;
        double[] r76 = r0.singularValues;
        if (r76[r60] > r15) goto L206;
        if (r76[r60] >= r15) goto L202;
        double r77 = -r76[r60];
    L203:
        r76[r60] = r77;
        int r78 = 0;
    L204:
        if (r78 > r41) goto L206;
        r115[r78][r60] = -r115[r78][r60];
        r78 = r78 + 1;
        goto L204
    L202:
        r77 = r15;
    L206:
        if (r60 >= r41) goto L223;
        double[] r79 = r0.singularValues;
        int r129 = r60 + 1;
        if (r79[r60] >= r79[r129]) goto L223;
        double r80 = r79[r60];
        r79[r60] = r79[r129];
        r79[r129] = r80;
        if (r60 >= (r0.n - 1)) goto L217;
        int r81 = 0;
    L214:
        if (r81 >= r0.n) goto L217;
        double r82 = r115[r81][r129];
        r115[r81][r129] = r115[r81][r60];
        r115[r81][r60] = r82;
        r81 = r81 + 1;
    L217:
        if (r60 >= (r0.m - 1)) goto L222;
        int r83 = 0;
    L220:
        if (r83 >= r0.m) goto L222;
        double r84 = r39[r83][r129];
        r39[r83][r129] = r39[r83][r60];
        r39[r83][r60] = r84;
        r83 = r83 + 1;
    L222:
        r60 = r129;
    L223:
        r40 = r40 - 1;
        r62 = r0;
        r41 = r41;
        r210 = r39;
        goto L269
    L224:
        int r85 = r40 - 1;
        double r130 = FastMath.max(FastMath.max(FastMath.max(FastMath.max(FastMath.abs(r0.singularValues[r85]), FastMath.abs(r0.singularValues[r57])), FastMath.abs(r9[r57])), FastMath.abs(r0.singularValues[r60])), FastMath.abs(r9[r60]));
        double[] r86 = r0.singularValues;
        double r131 = r86[r85] / r130;
        double r132 = r86[r57] / r130;
        double r133 = r9[r57] / r130;
        double r212 = r86[r60] / r130;
        double r213 = r9[r60] / r130;
        double r134 = (((r132 + r131) * (r132 - r131)) + (r133 * r133)) / 2.0d;
        double r135 = r133 * r131;
        double r136 = r135 * r135;
        if (r134 == r15) goto L227;
    L230:
        double r87 = FastMath.sqrt((r134 * r134) + r136);
        if (r134 >= r15) goto L233;
        r87 = -r87;
    L233:
        double r137 = r136 / (r134 + r87);
    L234:
        double r88 = ((r212 + r131) * (r212 - r131)) + r137;
        int r138 = r60;
        double r139 = r212 * r213;
    L235:
        if (r138 >= r85) goto L250;
        double r140 = FastMath.hypot(r88, r139);
        double r89 = r88 / r140;
        double r141 = r139 / r140;
        if (r138 == r60) goto L239;
        r9[r138 - 1] = r140;
    L239:
        double[] r142 = r0.singularValues;
        double r214 = r141;
        double r90 = (r142[r138] * r89) + (r9[r138] * r141);
        r9[r138] = (r9[r138] * r89) - (r142[r138] * r214);
        int r143 = r138 + 1;
        int r215 = r85;
        int r144 = r57;
        double r91 = r214 * r142[r143];
        r142[r143] = r142[r143] * r89;
        int r145 = 0;
    L241:
        if (r145 >= r0.n) goto L243;
        double r146 = (r115[r145][r138] * r89) + (r115[r145][r143] * r214);
        int r216 = r60;
        double r92 = r214;
        r115[r145][r143] = ((-r92) * r115[r145][r138]) + (r115[r145][r143] * r89);
        r115[r145][r138] = r146;
        r145 = r145 + 1;
        r0 = this;
        r40 = r40;
        r214 = r92;
        r39 = r39;
        r60 = r216;
        goto L241
    L243:
        int r217 = r40;
        int r218 = r60;
        double[][] r219 = r39;
        double r93 = FastMath.hypot(r90, r91);
        double r94 = r90 / r93;
        double r95 = r91 / r93;
        double[] r96 = this.singularValues;
        r96[r138] = r93;
        double r97 = (r9[r138] * r94) + (r96[r143] * r95);
        double r98 = -r95;
        r96[r143] = (r9[r138] * r98) + (r96[r143] * r94);
        double r99 = r9[r143] * r95;
        r9[r143] = r9[r143] * r94;
        if (r138 >= (this.m - 1)) goto L249;
        int r100 = 0;
    L247:
        if (r100 >= this.m) goto L249;
        double r220 = (r219[r100][r138] * r94) + (r219[r100][r143] * r95);
        r219[r100][r143] = (r219[r100][r138] * r98) + (r219[r100][r143] * r94);
        r219[r100][r138] = r220;
        r100 = r100 + 1;
    L249:
        r0 = this;
        r138 = r143;
        r57 = r144;
        r85 = r215;
        r40 = r217;
        r39 = r219;
        r60 = r218;
        r139 = r99;
        r88 = r97;
        goto L235
    L250:
        r62 = r0;
        r210 = r39;
        r9[r57] = r88;
        r61 = r40;
        goto L268
    L227:
        if (r136 != r15) goto L230;
        r137 = r15;
        goto L234
    L171:
        int r147 = r40 - 1;
        int r148 = r147;
    L172:
        if (r148 < r58) goto L186;
        if (r148 == r58) goto L186;
        if (r148 == r40) goto L177;
        double r149 = FastMath.abs(r9[r148]);
    L179:
        if (r148 == (r58 + 1)) goto L181;
        double r221 = FastMath.abs(r9[r148 - 1]);
    L183:
        if (FastMath.abs(r0.singularValues[r148]) <= (((r149 + r221) * 2.220446049250313E-16d) + 1.6033346880071782E-291d)) goto L184;
        r148 = r148 - 1;
        goto L172
    L184:
        r0.singularValues[r148] = r15;
        goto L186
    L181:
        r221 = r15;
        goto L183
    L177:
        r149 = r15;
    L186:
        if (r148 != r58) goto L188;
        r59 = 3;
        goto L191
    L188:
        if (r148 != r147) goto L190;
        r59 = 1;
        goto L191
    L190:
        r58 = r148;
        r59 = 2;
        goto L191
    L270:
        SingularValueDecomposition r101 = r0;
        double[][] r222 = r39;
        r101.tol = FastMath.max((((double) r101.m) * r101.singularValues[0]) * 2.220446049250313E-16d, FastMath.sqrt(Precision.SAFE_MIN));
        if (r101.transposed == true) goto L273;
        r101.cachedU = MatrixUtils.createRealMatrix(r222);
        RealMatrix r102 = MatrixUtils.createRealMatrix(r115);
    L274:
        r101.cachedV = r102;
        return;
    L273:
        r101.cachedU = MatrixUtils.createRealMatrix(r115);
        r102 = MatrixUtils.createRealMatrix(r222);
        goto L274
    L5:
        r0.transposed = false;
        r3 = r2.getData();
        r0.m = r2.getRowDimension();
        r4 = r2.getColumnDimension();
        goto L6
    }

    static /* synthetic */ double[] access$000(SingularValueDecomposition r0) {
        return r0.singularValues;
    }

    public int getRank() {
        int r0 = 0;
        int r1 = 0;
    L3:
        double[] r2 = this.singularValues;
        if (r0 >= r2.length) goto L9;
        if (r2[r0] <= this.tol) goto L8;
        r1 = r1 + 1;
    L8:
        r0 = r0 + 1;
        goto L3
    L9:
        return r1;
    }

    public DecompositionSolver getSolver() {
        double[] r1 = this.singularValues;
        RealMatrix r2 = getUT();
        RealMatrix r3 = getV();
        if (getRank() != this.m) goto L5;
        boolean r0 = true;
    L7:
        return new Solver(r1, r2, r3, r0, this.tol, null);
    L5:
        r0 = false;
        goto L7
    }

    public RealMatrix getU() {
        return this.cachedU;
    }

    public RealMatrix getUT() {
        if (this.cachedUt != null) goto L6;
        this.cachedUt = getU().transpose();
    L6:
        return this.cachedUt;
    }

    public RealMatrix getV() {
        return this.cachedV;
    }
}
