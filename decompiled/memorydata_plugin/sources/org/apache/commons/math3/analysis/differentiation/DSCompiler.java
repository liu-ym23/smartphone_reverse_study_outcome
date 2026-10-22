package org.apache.commons.math3.analysis.differentiation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class DSCompiler {
    private static AtomicReference<DSCompiler[][]> compilers;
    private final int[][][] compIndirection;
    private final int[][] derivativesIndirection;
    private final int[] lowerIndirection;
    private final int[][][] multIndirection;
    private final int order;
    private final int parameters;
    private final int[][] sizes;

    static {
        compilers = new AtomicReference(null);
    }

    private DSCompiler(int r7, int r8, DSCompiler r9, DSCompiler r10) {
        this.parameters = r7;
        this.order = r8;
        int[][] r4 = compileSizes(r7, r8, r9);
        this.sizes = r4;
        int[][] r5 = compileDerivativesIndirection(r7, r8, r9, r10);
        this.derivativesIndirection = r5;
        int[] r0 = compileLowerIndirection(r7, r8, r9, r10);
        this.lowerIndirection = r0;
        this.multIndirection = compileMultiplicationIndirection(r7, r8, r9, r10, r0);
        this.compIndirection = compileCompositionIndirection(r7, r8, r9, r10, r4, r5);
    }

    private static int[][][] compileCompositionIndirection(int r26, int r27, DSCompiler r28, DSCompiler r29, int[][] r30, int[][] r31) {
        DSCompiler r8 = r29;
        int r12 = 0;
        int r13 = 1;
        if (r26 == 0) goto L56;
        if (r27 == 0) goto L56;
        int[][][] r0 = r28.compIndirection;
        int r14 = r0.length;
        int r15 = r8.compIndirection.length;
        int[][][] r5 = new int[r14 + r15][][];
        System.arraycopy(r0, 0, r5, 0, r14);
        int r4 = 0;
    L7:
        if (r4 >= r15) goto L54;
        ArrayList r3 = new ArrayList();
        int[][] r2 = r8.compIndirection[r4];
        int r1 = r2.length;
        int r6 = r12;
    L9:
        if (r6 >= r1) goto L26;
        int[] r11 = r2[r6];
        int r16 = r11.length + r13;
        int[] r17 = new int[r16];
        r17[0] = r11[0];
        r17[1] = r11[1] + 1;
        int r18 = r15;
        int[] r19 = new int[r26];
        int r110 = r26 - 1;
        r19[r110] = 1;
        int r210 = r6;
        r17[r11.length] = getPartialDerivativeIndex(r26, r27, r30, r19);
        int r20 = r1;
        int r7 = 2;
    L12:
        if (r7 >= r11.length) goto L14;
        int r23 = r7;
        r17[r23] = convertIndex(r11[r7], r26, r8.derivativesIndirection, r26, r27, r30);
        r7 = r23 + 1;
        r3 = r3;
        r2 = r2;
        r4 = r4;
        r5 = r5;
        r14 = r14;
        r210 = r210;
        goto L12
    L14:
        int r22 = r210;
        int[][] r21 = r2;
        int r24 = r4;
        int[][][] r25 = r5;
        int r211 = r14;
        ArrayList r111 = r3;
        Arrays.sort(r17, 2, r16);
        r111.add(r17);
        int r112 = 2;
    L16:
        if (r112 >= r11.length) goto L25;
        int r113 = r11.length;
        int[] r9 = new int[r113];
        r9[0] = r11[0];
        r9[1] = r11[1];
        int r10 = 2;
    L19:
        if (r10 >= r11.length) goto L24;
        int r32 = r11[r10];
        int[][] r33 = r8.derivativesIndirection;
        int r34 = r10;
        int[] r212 = r11;
        int[] r114 = r9;
        r114[r34] = convertIndex(r32, r26, r33, r26, r27, r30);
        if (r34 != r112) goto L23;
        System.arraycopy(r31[r114[r34]], 0, r19, 0, r26);
        r19[r110] = r19[r110] + 1;
        r114[r34] = getPartialDerivativeIndex(r26, r27, r30, r19);
    L23:
        r10 = r34 + 1;
        r8 = r29;
        r9 = r114;
        r11 = r212;
        goto L19
    L24:
        int[] r213 = r11;
        int[] r115 = r9;
        Arrays.sort(r115, 2, r113);
        r111.add(r115);
        r112 = r112 + 1;
        r8 = r29;
        r11 = r213;
        goto L16
    L25:
        r6 = r22 + 1;
        r8 = r29;
        r3 = r111;
        r15 = r18;
        r1 = r20;
        r2 = r21;
        r4 = r24;
        r5 = r25;
        r13 = 1;
        r14 = r211;
        goto L9
    L26:
        int r214 = r4;
        int[][][] r215 = r5;
        int r216 = r14;
        int r116 = r15;
        ArrayList r117 = r3;
        ArrayList r35 = new ArrayList(r117.size());
        int r36 = 0;
    L28:
        if (r36 >= r117.size()) goto L52;
        int[] r37 = (int[]) ZeusTransformUtils.preCheckCast(r117.get(r36), int[].class, "com.obric.memorydata.plugin");
        if (r37[0] <= 0) goto L51;
        int r38 = r36 + 1;
    L33:
        if (r38 >= r117.size()) goto L50;
        int[] r39 = (int[]) ZeusTransformUtils.preCheckCast(r117.get(r38), int[].class, "com.obric.memorydata.plugin");
        if (r37.length != r39.length) goto L37;
        boolean r40 = true;
    L38:
        int r118 = 1;
    L39:
        if (r40 == false) goto L47;
        if (r118 >= r37.length) goto L47;
        if (r37[r118] != r39[r118]) goto L45;
        boolean r119 = true;
    L46:
        r40 = r40 & r119;
        r118 = r118 + 1;
        goto L39
    L45:
        r119 = false;
    L47:
        if (r40 == false) goto L49;
        r37[0] = r37[0] + r39[0];
        r39[0] = 0;
    L49:
        r38 = r38 + 1;
        goto L33
    L37:
        r40 = false;
        goto L38
    L50:
        r35.add(r37);
    L51:
        r36 = r36 + 1;
        goto L28
    L52:
        r215[r216 + r214] = (int[][]) ZeusTransformUtils.preCheckCast(r35.toArray(new int[r35.size()][]), int[][].class, "com.obric.memorydata.plugin");
        r4 = r214 + 1;
        r14 = r216;
        r8 = r29;
        r15 = r116;
        r5 = r215;
        r12 = 0;
        r13 = 1;
        goto L7
    L54:
        return r5;
    L56:
        return new int[][][]{new int[][]{new int[]{1, 0}}};
    }

    private static int[][] compileDerivativesIndirection(int r8, int r9, DSCompiler r10, DSCompiler r11) {
        if (r8 == 0) goto L14;
        if (r9 == 0) goto L14;
        int r12 = r10.derivativesIndirection.length;
        int r4 = r11.derivativesIndirection.length;
        int[][] r0 = (int[][]) Array.newInstance(int.class, new int[]{r12 + r4, r8});
        int r1 = 0;
    L7:
        if (r1 >= r12) goto L9;
        System.arraycopy(r10.derivativesIndirection[r1], 0, r0[r1], 0, r8 - 1);
        r1 = r1 + 1;
        goto L7
    L9:
        int r13 = 0;
    L10:
        if (r13 >= r4) goto L12;
        int r5 = r12 + r13;
        System.arraycopy(r11.derivativesIndirection[r13], 0, r0[r5], 0, r8);
        int[] r2 = r0[r5];
        int r6 = r8 - 1;
        r2[r6] = r2[r6] + 1;
        r13 = r13 + 1;
        goto L10
    L12:
        return r0;
    L14:
        return (int[][]) Array.newInstance(int.class, new int[]{1, r8});
    }

    private static int[] compileLowerIndirection(int r5, int r6, DSCompiler r7, DSCompiler r8) {
        int r1 = 0;
        if (r5 == 0) goto L11;
        if (r6 <= 1) goto L11;
        int[] r9 = r7.lowerIndirection;
        int r10 = r9.length;
        int r0 = r8.lowerIndirection.length;
        int[] r2 = new int[r10 + r0];
        System.arraycopy(r9, 0, r2, 0, r10);
    L7:
        if (r1 >= r0) goto L9;
        r2[r10 + r1] = r7.getSize() + r8.lowerIndirection[r1];
        r1 = r1 + 1;
        goto L7
    L9:
        return r2;
    L11:
        return new int[]{0};
    }

    private static int[][][] compileMultiplicationIndirection(int r17, int r18, DSCompiler r19, DSCompiler r20, int[] r21) {
        DSCompiler r0 = r20;
        int r2 = 3;
        int r4 = 0;
        if (r17 == 0) goto L31;
        if (r18 == 0) goto L31;
        int[][][] r5 = r19.multIndirection;
        int r6 = r5.length;
        int r7 = r0.multIndirection.length;
        int[][][] r8 = new int[r6 + r7][][];
        System.arraycopy(r5, 0, r8, 0, r6);
        int r9 = 0;
    L7:
        if (r9 >= r7) goto L29;
        int[][] r10 = r0.multIndirection[r9];
        ArrayList r11 = new ArrayList(r10.length * 2);
        int r12 = r4;
    L10:
        if (r12 >= r10.length) goto L12;
        int[] r13 = new int[r2];
        r13[r4] = r10[r12][r4];
        r13[1] = r21[r10[r12][1]];
        r13[2] = r10[r12][2] + r6;
        r11.add(r13);
        int[] r14 = new int[r2];
        r14[r4] = r10[r12][r4];
        r14[1] = r10[r12][1] + r6;
        r14[2] = r21[r10[r12][2]];
        r11.add(r14);
        r12 = r12 + 1;
        goto L10
    L12:
        ArrayList r15 = new ArrayList(r11.size());
        int r16 = r4;
    L14:
        if (r16 >= r11.size()) goto L28;
        int[] r110 = (int[]) ZeusTransformUtils.preCheckCast(r11.get(r16), int[].class, "com.obric.memorydata.plugin");
        if (r110[r4] <= 0) goto L27;
        int r111 = r16 + 1;
    L19:
        if (r111 >= r11.size()) goto L26;
        int[] r3 = (int[]) ZeusTransformUtils.preCheckCast(r11.get(r111), int[].class, "com.obric.memorydata.plugin");
        if (r110[1] != r3[1]) goto L25;
        if (r110[2] != r3[2]) goto L25;
        r110[0] = r110[0] + r3[0];
        r3[0] = 0;
    L25:
        r111 = r111 + 1;
        goto L19
    L26:
        r15.add(r110);
    L27:
        r16 = r16 + 1;
        r4 = 0;
        goto L14
    L28:
        r8[r6 + r9] = (int[][]) ZeusTransformUtils.preCheckCast(r15.toArray(new int[r15.size()][]), int[][].class, "com.obric.memorydata.plugin");
        r9 = r9 + 1;
        r0 = r20;
        r2 = 3;
        r4 = 0;
        goto L7
    L29:
        return r8;
    L31:
        return new int[][][]{new int[][]{new int[]{1, 0, 0}}};
    }

    private static int[][] compileSizes(int r5, int r6, DSCompiler r7) {
        int r1 = 0;
        int[][] r0 = (int[][]) Array.newInstance(int.class, new int[]{r5 + 1, r6 + 1});
        if (r5 != 0) goto L5;
        Arrays.fill(r0[0], 1);
    L8:
        return r0;
    L5:
        System.arraycopy(r7.sizes, 0, r0, 0, r5);
        r0[r5][0] = 1;
    L6:
        if (r1 >= r6) goto L8;
        int r2 = r1 + 1;
        r0[r5][r2] = r0[r5][r1] + r0[r5 - 1][r2];
        r1 = r2;
        goto L6
    }

    private static int convertIndex(int r1, int r2, int[][] r3, int r4, int r5, int[][] r6) {
        int[] r0 = new int[r4];
        System.arraycopy(r3[r1], 0, r0, 0, FastMath.min(r2, r4));
        return getPartialDerivativeIndex(r4, r5, r6, r0);
    }

    public static DSCompiler getCompiler(int r10, int r11) {
        DSCompiler[][] r0 = (DSCompiler[][]) ZeusTransformUtils.preCheckCast(compilers.get(), DSCompiler[][].class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L13;
        if (r0.length <= r10) goto L13;
        if (r0[r10].length <= r11) goto L13;
        if (r0[r10][r11] == null) goto L13;
        return r0[r10][r11];
    L13:
        if (r0 != null) goto L15;
        int r2 = 0;
    L16:
        int r3 = FastMath.max(r10, r2);
        if (r0 != null) goto L19;
        int r4 = 0;
    L20:
        DSCompiler[][] r5 = (DSCompiler[][]) Array.newInstance(DSCompiler.class, new int[]{r3 + 1, FastMath.max(r11, r4) + 1});
        if (r0 == null) goto L26;
        int r6 = 0;
    L24:
        if (r6 >= r0.length) goto L26;
        System.arraycopy(r0[r6], 0, r5[r6], 0, r0[r6].length);
        r6 = r6 + 1;
    L26:
        int r7 = 0;
    L28:
        if (r7 > (r10 + r11)) goto L44;
        int r8 = FastMath.max(0, r7 - r10);
    L31:
        if (r8 > FastMath.min(r11, r7)) goto L43;
        int r9 = r7 - r8;
        if (r5[r9][r8] != null) goto L42;
        DSCompiler r12 = null;
        if (r9 != 0) goto L37;
        DSCompiler r13 = null;
    L38:
        if (r8 == 0) goto L41;
        r12 = r5[r9][r8 - 1];
    L41:
        r5[r9][r8] = new DSCompiler(r9, r8, r13, r12);
        goto L42
    L37:
        r13 = r5[r9 - 1][r8];
    L42:
        r8 = r8 + 1;
        goto L31
    L43:
        r7 = r7 + 1;
        goto L28
    L44:
        compilers.compareAndSet(r0, r5);
        return r5[r10][r11];
    L19:
        r4 = r0[0].length;
        goto L20
    L15:
        r2 = r0.length;
        goto L16
    }

    private static int getPartialDerivativeIndex(int r7, int r8, int[][] r9, int... r10) {
        int r11 = r7 - 1;
        int r1 = 0;
        int r3 = r8;
        int r2 = 0;
    L3:
        if (r11 < 0) goto L12;
        int r4 = r10[r11];
        r2 = r2 + r4;
        if (r2 > r8) goto L11;
    L6:
        int r5 = r4 - 1;
        if (r4 <= 0) goto L9;
        r1 = r1 + r9[r11][r3];
        r4 = r5;
        r3 = r3 - 1;
        goto L6
    L9:
        r11 = r11 - 1;
        goto L3
    L11:
        throw new NumberIsTooLargeException(Integer.valueOf(r2), Integer.valueOf(r8), true);
    L12:
        return r1;
    }

    public void acos(double[] r26, int r27, double[] r28, int r29) {
        double[] r3 = new double[this.order + 1];
        double r4 = r26[r27];
        r3[0] = FastMath.acos(r4);
        int r6 = this.order;
        if (r6 <= 0) goto L21;
        double[] r7 = new double[r6];
        r7[0] = -1.0d;
        double r8 = r4 * r4;
        double r9 = 1.0d / (1.0d - r8);
        double r11 = FastMath.sqrt(r9);
        r3[1] = r7[0] * r11;
        int r13 = 2;
        int r14 = 2;
    L6:
        if (r14 > this.order) goto L21;
        int r15 = r14 - 1;
        r7[r15] = ((double) r15) * r7[r14 - 2];
        double r16 = 0.0d;
    L8:
        if (r15 < 0) goto L17;
        r16 = (r16 * r8) + r7[r15];
        if (r15 <= r13) goto L12;
        int r2 = r15 - 1;
        int r19 = r14;
        double r20 = r8;
        r7[r15 - 2] = (((double) r2) * r7[r2]) + (((double) ((r19 * 2) - r15)) * r7[r15 - 3]);
        int r1 = 2;
    L16:
        r15 = r15 - 2;
        r13 = r1;
        r14 = r19;
        r8 = r20;
        goto L8
    L12:
        r20 = r8;
        r1 = r13;
        r19 = r14;
        if (r15 != r1) goto L16;
        r7[0] = r7[1];
        goto L16
    L17:
        double r21 = r8;
        int r5 = r13;
        int r110 = r14;
        if ((r110 & 1) != 0) goto L20;
        r16 = r16 * r4;
    L20:
        r11 = r11 * r9;
        r3[r110] = r16 * r11;
        r14 = r110 + 1;
        r8 = r21;
        r13 = r5;
    L21:
        compose(r26, r27, r3, r28, r29);
    }

    public void acosh(double[] r25, int r26, double[] r27, int r28) {
        double[] r3 = new double[this.order + 1];
        double r4 = r25[r26];
        r3[0] = FastMath.acosh(r4);
        int r6 = this.order;
        if (r6 <= 0) goto L21;
        double[] r7 = new double[r6];
        r7[0] = 1.0d;
        double r9 = r4 * r4;
        double r8 = 1.0d / (r9 - 1.0d);
        double r11 = FastMath.sqrt(r8);
        r3[1] = r7[0] * r11;
        int r13 = 2;
        int r14 = 2;
    L6:
        if (r14 > this.order) goto L21;
        int r16 = r14 - 1;
        r7[r16] = ((double) (1 - r14)) * r7[r14 - 2];
        int r1 = r16;
        double r17 = 0.0d;
    L8:
        if (r1 < 0) goto L17;
        r17 = (r17 * r9) + r7[r1];
        if (r1 <= r13) goto L12;
        int r19 = r14;
        double r20 = r9;
        r7[r1 - 2] = (((double) (1 - r1)) * r7[r1 - 1]) + (((double) (r1 - (r19 * 2))) * r7[r1 - 3]);
        int r2 = 2;
    L16:
        r1 = r1 - 2;
        r13 = r2;
        r14 = r19;
        r9 = r20;
        goto L8
    L12:
        r20 = r9;
        r2 = r13;
        r19 = r14;
        if (r1 != r2) goto L16;
        r7[0] = -r7[1];
        goto L16
    L17:
        double r21 = r9;
        int r5 = r13;
        int r110 = r14;
        if ((r110 & 1) != 0) goto L20;
        r17 = r17 * r4;
    L20:
        r11 = r11 * r8;
        r3[r110] = r17 * r11;
        r14 = r110 + 1;
        r13 = r5;
        r9 = r21;
    L21:
        compose(r25, r26, r3, r27, r28);
    }

    public void add(double[] r7, int r8, double[] r9, int r10, double[] r11, int r12) {
        int r0 = 0;
    L4:
        if (r0 >= getSize()) goto L6;
        r11[r12 + r0] = r7[r8 + r0] + r9[r10 + r0];
        r0 = r0 + 1;
        goto L4
    }

    public void asin(double[] r26, int r27, double[] r28, int r29) {
        double[] r3 = new double[this.order + 1];
        double r4 = r26[r27];
        r3[0] = FastMath.asin(r4);
        int r6 = this.order;
        if (r6 <= 0) goto L21;
        double[] r7 = new double[r6];
        r7[0] = 1.0d;
        double r9 = r4 * r4;
        double r8 = 1.0d / (1.0d - r9);
        double r11 = FastMath.sqrt(r8);
        r3[1] = r7[0] * r11;
        int r13 = 2;
        int r14 = 2;
    L6:
        if (r14 > this.order) goto L21;
        int r15 = r14 - 1;
        r7[r15] = ((double) r15) * r7[r14 - 2];
        double r16 = 0.0d;
    L8:
        if (r15 < 0) goto L17;
        r16 = (r16 * r9) + r7[r15];
        if (r15 <= r13) goto L12;
        int r2 = r15 - 1;
        int r19 = r14;
        double r20 = r9;
        r7[r15 - 2] = (((double) r2) * r7[r2]) + (((double) ((r19 * 2) - r15)) * r7[r15 - 3]);
        int r1 = 2;
    L16:
        r15 = r15 - 2;
        r13 = r1;
        r14 = r19;
        r9 = r20;
        goto L8
    L12:
        r20 = r9;
        r1 = r13;
        r19 = r14;
        if (r15 != r1) goto L16;
        r7[0] = r7[1];
        goto L16
    L17:
        double r21 = r9;
        int r5 = r13;
        int r110 = r14;
        if ((r110 & 1) != 0) goto L20;
        r16 = r16 * r4;
    L20:
        r11 = r11 * r8;
        r3[r110] = r16 * r11;
        r14 = r110 + 1;
        r9 = r21;
        r13 = r5;
    L21:
        compose(r26, r27, r3, r28, r29);
    }

    public void asinh(double[] r25, int r26, double[] r27, int r28) {
        double[] r3 = new double[this.order + 1];
        double r4 = r25[r26];
        r3[0] = FastMath.asinh(r4);
        int r6 = this.order;
        if (r6 <= 0) goto L21;
        double[] r7 = new double[r6];
        r7[0] = 1.0d;
        double r9 = r4 * r4;
        double r8 = 1.0d / (r9 + 1.0d);
        double r11 = FastMath.sqrt(r8);
        r3[1] = r7[0] * r11;
        int r13 = 2;
        int r14 = 2;
    L6:
        if (r14 > this.order) goto L21;
        int r16 = r14 - 1;
        r7[r16] = ((double) (1 - r14)) * r7[r14 - 2];
        int r1 = r16;
        double r17 = 0.0d;
    L8:
        if (r1 < 0) goto L17;
        r17 = (r17 * r9) + r7[r1];
        if (r1 <= r13) goto L12;
        int r15 = r1 - 1;
        int r19 = r14;
        double r20 = r9;
        r7[r1 - 2] = (((double) r15) * r7[r15]) + (((double) (r1 - (r19 * 2))) * r7[r1 - 3]);
        int r2 = 2;
    L16:
        r1 = r1 - 2;
        r13 = r2;
        r14 = r19;
        r9 = r20;
        goto L8
    L12:
        r20 = r9;
        r2 = r13;
        r19 = r14;
        if (r1 != r2) goto L16;
        r7[0] = r7[1];
        goto L16
    L17:
        double r21 = r9;
        int r5 = r13;
        int r110 = r14;
        if ((r110 & 1) != 0) goto L20;
        r17 = r17 * r4;
    L20:
        r11 = r11 * r8;
        r3[r110] = r17 * r11;
        r14 = r110 + 1;
        r13 = r5;
        r9 = r21;
    L21:
        compose(r25, r26, r3, r27, r28);
    }

    public void atan(double[] r26, int r27, double[] r28, int r29) {
        double[] r3 = new double[this.order + 1];
        double r4 = r26[r27];
        r3[0] = FastMath.atan(r4);
        int r6 = this.order;
        if (r6 <= 0) goto L21;
        double[] r7 = new double[r6];
        r7[0] = 1.0d;
        double r9 = r4 * r4;
        double r8 = 1.0d / (r9 + 1.0d);
        r3[1] = r7[0] * r8;
        int r11 = 2;
        double r13 = r8;
        int r12 = 2;
    L6:
        if (r12 > this.order) goto L21;
        int r16 = r12 - 1;
        r7[r16] = ((double) (-r12)) * r7[r12 - 2];
        int r1 = r16;
        double r17 = 0.0d;
    L8:
        if (r1 < 0) goto L17;
        r17 = (r17 * r9) + r7[r1];
        if (r1 <= r11) goto L12;
        int r15 = r1 - 1;
        int r19 = r12;
        double r20 = r9;
        r7[r1 - 2] = (((double) r15) * r7[r15]) + (((double) (r15 - (r19 * 2))) * r7[r1 - 3]);
        int r2 = 2;
    L16:
        r1 = r1 - 2;
        r11 = r2;
        r12 = r19;
        r9 = r20;
        goto L8
    L12:
        r20 = r9;
        r2 = r11;
        r19 = r12;
        if (r1 != r2) goto L16;
        r7[0] = r7[1];
        goto L16
    L17:
        double r21 = r9;
        int r5 = r11;
        int r110 = r12;
        if ((r110 & 1) != 0) goto L20;
        r17 = r17 * r4;
    L20:
        r13 = r13 * r8;
        r3[r110] = r17 * r13;
        r11 = r5;
        r9 = r21;
        r12 = r110 + 1;
    L21:
        compose(r26, r27, r3, r28, r29);
    }

    public void atan2(double[] r17, int r18, double[] r19, int r20, double[] r21, int r22) {
        double[] r8 = new double[getSize()];
        multiply(r19, r20, r19, r20, r8, 0);
        int r9 = getSize();
        double[] r10 = new double[r9];
        multiply(r17, r18, r17, r18, r10, 0);
        add(r8, 0, r10, 0, r10, 0);
        rootN(r10, 0, 2, r8, 0);
        int r15 = 0;
        if (r19[r20] < 0.0d) goto L7;
        add(r8, 0, r19, r20, r10, 0);
        divide(r17, r18, r10, 0, r8, 0);
        atan(r8, 0, r10, 0);
    L5:
        if (r15 >= r9) goto L14;
        r21[r22 + r15] = r10[r15] * 2.0d;
        r15 = r15 + 1;
    L14:
        r21[r22] = FastMath.atan2(r17[r18], r19[r20]);
        return;
    L7:
        subtract(r8, 0, r19, r20, r10, 0);
        divide(r17, r18, r10, 0, r8, 0);
        atan(r8, 0, r10, 0);
        if (r10[0] > 0.0d) goto L10;
        double r0 = -3.141592653589793d;
    L11:
        r21[r22] = r0 - (r10[0] * 2.0d);
        int r1 = 1;
    L12:
        if (r1 >= r9) goto L14;
        r21[r22 + r1] = r10[r1] * (-2.0d);
        r1 = r1 + 1;
        goto L12
    L10:
        r0 = 3.141592653589793d;
        goto L11
    }

    public void atanh(double[] r26, int r27, double[] r28, int r29) {
        double[] r3 = new double[this.order + 1];
        double r4 = r26[r27];
        r3[0] = FastMath.atanh(r4);
        int r6 = this.order;
        if (r6 <= 0) goto L21;
        double[] r7 = new double[r6];
        r7[0] = 1.0d;
        double r9 = r4 * r4;
        double r8 = 1.0d / (1.0d - r9);
        r3[1] = r7[0] * r8;
        int r11 = 2;
        double r13 = r8;
        int r12 = 2;
    L6:
        if (r12 > this.order) goto L21;
        double r15 = 0.0d;
        int r17 = r12 - 1;
        r7[r17] = ((double) r12) * r7[r12 - 2];
        int r1 = r17;
    L8:
        if (r1 < 0) goto L17;
        r15 = (r15 * r9) + r7[r1];
        if (r1 <= r11) goto L12;
        int r14 = r1 - 1;
        double r19 = r9;
        double r21 = r8;
        r7[r1 - 2] = (((double) r14) * r7[r14]) + (((double) (((r12 * 2) - r1) + 1)) * r7[r1 - 3]);
        int r2 = 2;
    L16:
        r1 = r1 - 2;
        r11 = r2;
        r9 = r19;
        r8 = r21;
        goto L8
    L12:
        r21 = r8;
        r19 = r9;
        r2 = r11;
        if (r1 != r2) goto L16;
        r7[0] = r7[1];
        goto L16
    L17:
        double r22 = r8;
        double r110 = r9;
        int r5 = r11;
        if ((r12 & 1) != 0) goto L20;
        r15 = r15 * r4;
    L20:
        r13 = r13 * r22;
        r3[r12] = r15 * r13;
        r12 = r12 + 1;
        r11 = r5;
        r9 = r110;
        r8 = r22;
    L21:
        compose(r26, r27, r3, r28, r29);
    }

    public void checkCompatibility(DSCompiler r3) {
        if (this.parameters != r3.parameters) goto L10;
        if (this.order != r3.order) goto L8;
        return;
    L8:
        throw new DimensionMismatchException(this.order, r3.order);
    L10:
        throw new DimensionMismatchException(this.parameters, r3.parameters);
    }

    public void compose(double[] r14, int r15, double[] r16, double[] r17, int r18) {
        int r2 = 0;
    L3:
        int[][][] r3 = this.compIndirection;
        if (r2 >= r3.length) goto L14;
        int[][] r4 = r3[r2];
        double r5 = 0.0d;
        int r6 = 0;
    L7:
        if (r6 >= r4.length) goto L13;
        int[] r7 = r4[r6];
        double r8 = ((double) r7[0]) * r16[r7[1]];
        int r10 = 2;
    L10:
        if (r10 >= r7.length) goto L12;
        r8 = r8 * r14[r7[r10] + r15];
        r10 = r10 + 1;
        goto L10
    L12:
        r5 = r5 + r8;
        r6 = r6 + 1;
        goto L7
    L13:
        r17[r18 + r2] = r5;
        r2 = r2 + 1;
        goto L3
    }

    public void cos(double[] r9, int r10, double[] r11, int r12) {
        double[] r5 = new double[this.order + 1];
        r5[0] = FastMath.cos(r9[r10]);
        if (this.order <= 0) goto L8;
        r5[1] = -FastMath.sin(r9[r10]);
        int r0 = 2;
    L6:
        if (r0 > this.order) goto L8;
        r5[r0] = -r5[r0 - 2];
        r0 = r0 + 1;
    L8:
        compose(r9, r10, r5, r11, r12);
    }

    public void cosh(double[] r9, int r10, double[] r11, int r12) {
        double[] r5 = new double[this.order + 1];
        r5[0] = FastMath.cosh(r9[r10]);
        if (this.order <= 0) goto L8;
        r5[1] = FastMath.sinh(r9[r10]);
        int r0 = 2;
    L6:
        if (r0 > this.order) goto L8;
        r5[r0] = r5[r0 - 2];
        r0 = r0 + 1;
    L8:
        compose(r9, r10, r5, r11, r12);
    }

    public void divide(double[] r8, int r9, double[] r10, int r11, double[] r12, int r13) {
        double[] r14 = new double[getSize()];
        pow(r10, r9, -1, r14, 0);
        multiply(r8, r9, r14, 0, r12, r13);
    }

    public void exp(double[] r8, int r9, double[] r10, int r11) {
        double[] r4 = new double[this.order + 1];
        Arrays.fill(r4, FastMath.exp(r8[r9]));
        compose(r8, r9, r4, r10, r11);
    }

    public void expm1(double[] r9, int r10, double[] r11, int r12) {
        double[] r5 = new double[this.order + 1];
        r5[0] = FastMath.expm1(r9[r10]);
        Arrays.fill(r5, 1, this.order + 1, FastMath.exp(r9[r10]));
        compose(r9, r10, r5, r11, r12);
    }

    public int getFreeParameters() {
        return this.parameters;
    }

    public int getOrder() {
        return this.order;
    }

    public int getPartialDerivativeIndex(int... r3) {
        if (r3.length != getFreeParameters()) goto L7;
        return getPartialDerivativeIndex(this.parameters, this.order, this.sizes, r3);
    L7:
        throw new DimensionMismatchException(r3.length, getFreeParameters());
    }

    public int[] getPartialDerivativeOrders(int r1) {
        return this.derivativesIndirection[r1];
    }

    public int getSize() {
        return this.sizes[this.parameters][this.order];
    }

    public void linearCombination(double r20, double[] r22, int r23, double r24, double[] r26, int r27, double r28, double[] r30, int r31, double r32, double[] r34, int r35, double[] r36, int r37) {
        int r0 = 0;
    L4:
        if (r0 >= getSize()) goto L6;
        r36[r37 + r0] = MathArrays.linearCombination(r20, r22[r23 + r0], r24, r26[r27 + r0], r28, r30[r31 + r0], r32, r34[r35 + r0]);
        r0 = r0 + 1;
        goto L4
    }

    public void linearCombination(double r16, double[] r18, int r19, double r20, double[] r22, int r23, double r24, double[] r26, int r27, double[] r28, int r29) {
        int r0 = 0;
    L4:
        if (r0 >= getSize()) goto L6;
        r28[r29 + r0] = MathArrays.linearCombination(r16, r18[r19 + r0], r20, r22[r23 + r0], r24, r26[r27 + r0]);
        r0 = r0 + 1;
        goto L4
    }

    public void linearCombination(double r12, double[] r14, int r15, double r16, double[] r18, int r19, double[] r20, int r21) {
        int r0 = 0;
    L4:
        if (r0 >= getSize()) goto L6;
        r20[r21 + r0] = MathArrays.linearCombination(r12, r14[r15 + r0], r16, r18[r19 + r0]);
        r0 = r0 + 1;
        goto L4
    }

    public void log(double[] r11, int r12, double[] r13, int r14) {
        int r1 = 1;
        double[] r5 = new double[this.order + 1];
        r5[0] = FastMath.log(r11[r12]);
        if (this.order <= 0) goto L8;
        double r2 = 1.0d / r11[r12];
        double r6 = r2;
    L6:
        if (r1 > this.order) goto L8;
        r5[r1] = r6;
        r6 = r6 * (((double) (-r1)) * r2);
        r1 = r1 + 1;
    L8:
        compose(r11, r12, r5, r13, r14);
    }

    public void log10(double[] r11, int r12, double[] r13, int r14) {
        int r1 = 1;
        double[] r5 = new double[this.order + 1];
        r5[0] = FastMath.log10(r11[r12]);
        if (this.order <= 0) goto L8;
        double r2 = 1.0d / r11[r12];
        double r6 = r2 / FastMath.log(10.0d);
    L6:
        if (r1 > this.order) goto L8;
        r5[r1] = r6;
        r6 = r6 * (((double) (-r1)) * r2);
        r1 = r1 + 1;
    L8:
        compose(r11, r12, r5, r13, r14);
    }

    public void log1p(double[] r11, int r12, double[] r13, int r14) {
        int r1 = 1;
        double[] r5 = new double[this.order + 1];
        r5[0] = FastMath.log1p(r11[r12]);
        if (this.order <= 0) goto L8;
        double r6 = 1.0d / (r11[r12] + 1.0d);
        double r2 = r6;
    L6:
        if (r1 > this.order) goto L8;
        r5[r1] = r2;
        r2 = r2 * (((double) (-r1)) * r6);
        r1 = r1 + 1;
    L8:
        compose(r11, r12, r5, r13, r14);
    }

    public void multiply(double[] r12, int r13, double[] r14, int r15, double[] r16, int r17) {
        int r2 = 0;
    L3:
        int[][][] r3 = this.multIndirection;
        if (r2 >= r3.length) goto L10;
        int[][] r4 = r3[r2];
        double r5 = 0.0d;
        int r6 = 0;
    L7:
        if (r6 >= r4.length) goto L9;
        r5 = r5 + ((((double) r4[r6][0]) * r12[r4[r6][1] + r13]) * r14[r4[r6][2] + r15]);
        r6 = r6 + 1;
        goto L7
    L9:
        r16[r17 + r2] = r5;
        r2 = r2 + 1;
        goto L3
    }

    public void pow(double r9, double[] r11, int r12, double[] r13, int r14) {
        int r1 = 1;
        int r0 = this.order + 1;
        double[] r5 = new double[r0];
        if (r9 == 0.0d) goto L5;
        r5[0] = FastMath.pow(r9, r11[r12]);
        double r10 = FastMath.log(r9);
    L13:
        if (r1 >= r0) goto L15;
        r5[r1] = r5[r1 - 1] * r10;
        r1 = r1 + 1;
    L15:
        compose(r11, r12, r5, r13, r14);
        return;
    L5:
        if (r11[r12] != 0.0d) goto L10;
        r5[0] = 1.0d;
        double r15 = Double.POSITIVE_INFINITY;
    L7:
        if (r1 >= r0) goto L15;
        r15 = -r15;
        r5[r1] = r15;
        r1 = r1 + 1;
        goto L7
    L10:
        if (r11[r12] >= 0.0d) goto L15;
        Arrays.fill(r5, Double.NaN);
        goto L15
    }

    public void pow(double[] r9, int r10, double r11, double[] r13, int r14) {
        int r0 = this.order;
        double[] r5 = new double[r0 + 1];
        double r1 = FastMath.pow(r9[r10], r11 - ((double) r0));
        int r2 = this.order;
    L3:
        if (r2 <= 0) goto L5;
        r5[r2] = r1;
        r1 = r1 * r9[r10];
        r2 = r2 - 1;
        goto L3
    L5:
        r5[0] = r1;
        int r3 = 1;
        double r4 = r11;
    L7:
        if (r3 > this.order) goto L9;
        r5[r3] = r5[r3] * r4;
        r4 = r4 * (r11 - ((double) r3));
        r3 = r3 + 1;
        goto L7
    L9:
        compose(r9, r10, r5, r13, r14);
    }

    public void pow(double[] r11, int r12, int r13, double[] r14, int r15) {
        if (r13 != 0) goto L6;
        r14[r15] = 1.0d;
        Arrays.fill(r14, r15 + 1, r15 + getSize(), 0.0d);
        return;
    L6:
        int r2 = this.order;
        double[] r7 = new double[r2 + 1];
        int r3 = 0;
        if (r13 <= 0) goto L12;
        int r0 = FastMath.min(r2, r13);
        double r1 = FastMath.pow(r11[r12], r13 - r0);
    L9:
        if (r0 <= 0) goto L11;
        r7[r0] = r1;
        r1 = r1 * r11[r12];
        r0 = r0 - 1;
        goto L9
    L11:
        r7[0] = r1;
    L16:
        double r4 = r13;
        int r5 = 1;
    L18:
        if (r5 > this.order) goto L20;
        r7[r5] = r7[r5] * r4;
        r4 = r4 * ((double) (r13 - r5));
        r5 = r5 + 1;
        goto L18
    L20:
        compose(r11, r12, r7, r14, r15);
        return;
    L12:
        double r6 = 1.0d / r11[r12];
        double r8 = FastMath.pow(r6, -r13);
    L14:
        if (r3 > this.order) goto L16;
        r7[r3] = r8;
        r8 = r8 * r6;
        r3 = r3 + 1;
        goto L14
    }

    public void pow(double[] r9, int r10, double[] r11, int r12, double[] r13, int r14) {
        double[] r2 = new double[getSize()];
        log(r9, r10, r2, 0);
        double[] r15 = new double[getSize()];
        multiply(r2, 0, r11, r12, r15, 0);
        exp(r15, 0, r13, r14);
    }

    public void remainder(double[] r9, int r10, double[] r11, int r12, double[] r13, int r14) {
        double r0 = FastMath.IEEEremainder(r9[r10], r11[r12]);
        double r2 = FastMath.rint((r9[r10] - r0) / r11[r12]);
        r13[r14] = r0;
        int r1 = 1;
    L4:
        if (r1 >= getSize()) goto L6;
        r13[r14 + r1] = r9[r10 + r1] - (r11[r12 + r1] * r2);
        r1 = r1 + 1;
        goto L4
    }

    public void rootN(double[] r14, int r15, int r16, double[] r17, int r18) {
        int r3 = 1;
        double[] r4 = new double[this.order + 1];
        if (r16 != 2) goto L6;
        r4[0] = FastMath.sqrt(r14[r15]);
        double r7 = 0.5d / r4[0];
    L10:
        double r1 = 1.0d / ((double) r16);
        double r5 = 1.0d / r14[r15];
    L12:
        if (r3 > this.order) goto L14;
        r4[r3] = r7;
        r7 = r7 * ((r1 - ((double) r3)) * r5);
        r3 = r3 + 1;
        goto L12
    L14:
        compose(r14, r15, r4, r17, r18);
        return;
    L6:
        if (r16 != 3) goto L8;
        r4[0] = FastMath.cbrt(r14[r15]);
        double r9 = r4[0] * 3.0d;
        double r8 = r4[0];
    L9:
        r7 = 1.0d / (r9 * r8);
        goto L10
    L8:
        r9 = r16;
        r4[0] = FastMath.pow(r14[r15], 1.0d / r9);
        r8 = FastMath.pow(r4[0], r16 - 1);
        goto L9
    }

    public void sin(double[] r9, int r10, double[] r11, int r12) {
        double[] r5 = new double[this.order + 1];
        r5[0] = FastMath.sin(r9[r10]);
        if (this.order <= 0) goto L8;
        r5[1] = FastMath.cos(r9[r10]);
        int r0 = 2;
    L6:
        if (r0 > this.order) goto L8;
        r5[r0] = -r5[r0 - 2];
        r0 = r0 + 1;
    L8:
        compose(r9, r10, r5, r11, r12);
    }

    public void sinh(double[] r9, int r10, double[] r11, int r12) {
        double[] r5 = new double[this.order + 1];
        r5[0] = FastMath.sinh(r9[r10]);
        if (this.order <= 0) goto L8;
        r5[1] = FastMath.cosh(r9[r10]);
        int r0 = 2;
    L6:
        if (r0 > this.order) goto L8;
        r5[r0] = r5[r0 - 2];
        r0 = r0 + 1;
    L8:
        compose(r9, r10, r5, r11, r12);
    }

    public void subtract(double[] r7, int r8, double[] r9, int r10, double[] r11, int r12) {
        int r0 = 0;
    L4:
        if (r0 >= getSize()) goto L6;
        r11[r12 + r0] = r7[r8 + r0] - r9[r10 + r0];
        r0 = r0 + 1;
        goto L4
    }

    public void tan(double[] r25, int r26, double[] r27, int r28) {
        double[] r3 = new double[this.order + 1];
        double r4 = FastMath.tan(r25[r26]);
        boolean r1 = false;
        r3[0] = r4;
        int r6 = this.order;
        if (r6 <= 0) goto L21;
        int r7 = 2;
        double[] r8 = new double[r6 + 2];
        r8[1] = 1.0d;
        double r9 = r4 * r4;
        int r10 = 1;
    L6:
        if (r10 > this.order) goto L21;
        double r11 = 0.0d;
        int r13 = r10 + 1;
        r8[r13] = ((double) r10) * r8[r10];
        int r14 = r13;
    L8:
        if (r14 < 0) goto L17;
        r11 = (r11 * r9) + r8[r14];
        if (r14 <= r7) goto L12;
        int r2 = r14 - 1;
        double[] r18 = r3;
        double r5 = ((double) r2) * r8[r2];
        int r12 = r14 - 3;
        double r20 = r9;
        r8[r14 - 2] = r5 + (((double) r12) * r8[r12]);
        int r15 = 2;
    L15:
        boolean r16 = false;
    L16:
        r14 = r14 - 2;
        r7 = r15;
        r1 = r16;
        r3 = r18;
        r9 = r20;
        goto L8
    L12:
        r18 = r3;
        r15 = r7;
        r20 = r9;
        if (r14 != r15) goto L15;
        r16 = false;
        r8[0] = r8[1];
        goto L16
    L17:
        double[] r19 = r3;
        double r21 = r9;
        boolean r17 = r1;
        int r22 = r7;
        if ((r10 & 1) != 0) goto L20;
        r11 = r11 * r4;
    L20:
        r19[r10] = r11;
        r7 = r22;
        r1 = r17;
        r10 = r13;
        r3 = r19;
        r9 = r21;
    L21:
        compose(r25, r26, r3, r27, r28);
    }

    public void tanh(double[] r25, int r26, double[] r27, int r28) {
        double[] r3 = new double[this.order + 1];
        double r4 = FastMath.tanh(r25[r26]);
        boolean r1 = false;
        r3[0] = r4;
        int r6 = this.order;
        if (r6 <= 0) goto L21;
        int r7 = 2;
        double[] r8 = new double[r6 + 2];
        r8[1] = 1.0d;
        double r9 = r4 * r4;
        int r10 = 1;
    L6:
        if (r10 > this.order) goto L21;
        double r11 = 0.0d;
        int r13 = r10 + 1;
        r8[r13] = ((double) (-r10)) * r8[r10];
        int r14 = r13;
    L8:
        if (r14 < 0) goto L17;
        r11 = (r11 * r9) + r8[r14];
        if (r14 <= r7) goto L12;
        int r2 = r14 - 1;
        double[] r18 = r3;
        double r5 = ((double) r2) * r8[r2];
        int r12 = r14 - 3;
        double r20 = r9;
        r8[r14 - 2] = r5 - (((double) r12) * r8[r12]);
        int r15 = 2;
    L15:
        boolean r16 = false;
    L16:
        r14 = r14 - 2;
        r7 = r15;
        r1 = r16;
        r3 = r18;
        r9 = r20;
        goto L8
    L12:
        r18 = r3;
        r15 = r7;
        r20 = r9;
        if (r14 != r15) goto L15;
        r16 = false;
        r8[0] = r8[1];
        goto L16
    L17:
        double[] r19 = r3;
        double r21 = r9;
        boolean r17 = r1;
        int r22 = r7;
        if ((r10 & 1) != 0) goto L20;
        r11 = r11 * r4;
    L20:
        r19[r10] = r11;
        r7 = r22;
        r1 = r17;
        r10 = r13;
        r3 = r19;
        r9 = r21;
    L21:
        compose(r25, r26, r3, r27, r28);
    }

    public double taylor(double[] r12, int r13, double... r14) {
        int r0 = getSize() - 1;
        double r1 = 0.0d;
    L3:
        if (r0 < 0) goto L16;
        int[] r3 = getPartialDerivativeOrders(r0);
        double r4 = r12[r13 + r0];
        int r6 = 0;
    L6:
        if (r6 >= r3.length) goto L15;
        if (r3[r6] <= 0) goto L14;
        r4 = r4 * (FastMath.pow(r14[r6], r3[r6]) / CombinatoricsUtils.factorial(r3[r6]));
    L11:
        e = move-exception;
        throw new MathInternalError(e);
    L14:
        r6 = r6 + 1;
        goto L6
    L15:
        r1 = r1 + r4;
        r0 = r0 - 1;
        goto L3
    L16:
        return r1;
    }
}
