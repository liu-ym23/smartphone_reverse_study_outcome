package org.apache.commons.math3.util;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.distribution.UniformIntegerDistribution;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;

/* JADX INFO: loaded from: classes6.dex */
public class MathArrays {

    /* JADX INFO: renamed from: org.apache.commons.math3.util.MathArrays$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection = null;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$util$MathArrays$Position = null;

        static {
            int[] r0 = new int[Position.values().length];
            $SwitchMap$org$apache$commons$math3$util$MathArrays$Position = r0;
            r0[Position.TAIL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L14:
            $SwitchMap$org$apache$commons$math3$util$MathArrays$Position[Position.HEAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L6:
            int[] r2 = new int[OrderDirection.values().length];
            $SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection = r2;
            r2[OrderDirection.INCREASING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L18:
            $SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection[OrderDirection.DECREASING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public interface Function {
        double evaluate(double[] r1, int r2, int r3);
    }

    public static final enum OrderDirection extends Enum<OrderDirection> {
        private static final /* synthetic */ OrderDirection[] $VALUES = null;
        public static final OrderDirection DECREASING = null;
        public static final OrderDirection INCREASING = null;

        static {
            OrderDirection r0 = new OrderDirection("INCREASING", 0);
            INCREASING = r0;
            OrderDirection r1 = new OrderDirection("DECREASING", 1);
            DECREASING = r1;
            $VALUES = new OrderDirection[]{r0, r1};
        }

        private OrderDirection(String r1, int r2) {
            super(r1, r2);
        }

        public static OrderDirection valueOf(String r2) {
            return (OrderDirection) ZeusTransformUtils.preCheckCast(Enum.valueOf(OrderDirection.class, r2), OrderDirection.class, "com.obric.memorydata.plugin");
        }

        public static OrderDirection[] values() {
            return (OrderDirection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), OrderDirection[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class PairDoubleInteger {
        private final double key;
        private final int value;

        PairDoubleInteger(double r1, int r3) {
            this.key = r1;
            this.value = r3;
        }

        public double getKey() {
            return this.key;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum Position extends Enum<Position> {
        private static final /* synthetic */ Position[] $VALUES = null;
        public static final Position HEAD = null;
        public static final Position TAIL = null;

        static {
            Position r0 = new Position(HttpMethodContrants.HEAD, 0);
            HEAD = r0;
            Position r1 = new Position("TAIL", 1);
            TAIL = r1;
            $VALUES = new Position[]{r0, r1};
        }

        private Position(String r1, int r2) {
            super(r1, r2);
        }

        public static Position valueOf(String r2) {
            return (Position) ZeusTransformUtils.preCheckCast(Enum.valueOf(Position.class, r2), Position.class, "com.obric.memorydata.plugin");
        }

        public static Position[] values() {
            return (Position[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Position[].class, "com.obric.memorydata.plugin");
        }
    }

    public static <T> T[] buildArray(Field<T> r2, int r3) {
        Field r4 = (Field) ZeusTransformUtils.wrapperContextForParams(r2, Field.class, "com.obric.memorydata.plugin");
        T[] r5 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r4.getRuntimeClass(), r3), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin"));
        Arrays.fill(r5, r4.getZero());
        return r5;
    }

    public static <T> T[][] buildArray(Field<T> r5, int r6, int r7) {
        Field r8 = (Field) ZeusTransformUtils.wrapperContextForParams(r5, Field.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if (r7 < 0) goto L11;
        T[][] r9 = (T[][]) ((Object[][]) ZeusTransformUtils.preCheckCast((Object[][]) ZeusTransformUtils.preCheckCast(Array.newInstance(r8.getRuntimeClass(), new int[]{r6, r7}), Object[][].class, "com.obric.memorydata.plugin"), Object[][].class, "com.obric.memorydata.plugin"));
    L6:
        if (r0 >= r6) goto L9;
        Arrays.fill(r9[r0], r8.getZero());
        r0 = r0 + 1;
        goto L6
    L9:
        return r9;
    L11:
        return (T[][]) ((Object[][]) ZeusTransformUtils.preCheckCast((Object[][]) ZeusTransformUtils.preCheckCast(Array.newInstance(buildArray(r8, 0).getClass(), r6), Object[][].class, "com.obric.memorydata.plugin"), Object[][].class, "com.obric.memorydata.plugin"));
    }

    public static void checkEqualLength(double[] r1, double[] r2) {
        checkEqualLength(r1, r2, true);
    }

    public static void checkEqualLength(int[] r1, int[] r2) {
        checkEqualLength(r1, r2, true);
    }

    public static boolean checkEqualLength(double[] r2, double[] r3, boolean r4) {
        if (r2.length != r3.length) goto L6;
        return true;
    L6:
        if (r4 == true) goto L10;
        return false;
    L10:
        throw new DimensionMismatchException(r2.length, r3.length);
    }

    public static boolean checkEqualLength(int[] r2, int[] r3, boolean r4) {
        if (r2.length != r3.length) goto L6;
        return true;
    L6:
        if (r4 == true) goto L10;
        return false;
    L10:
        throw new DimensionMismatchException(r2.length, r3.length);
    }

    public static void checkNotNaN(double[] r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L10;
        if (Double.isNaN(r3[r0]) == true) goto L9;
        r0 = r0 + 1;
        goto L4
    L9:
        throw new NotANumberException();
    }

    public static void checkOrder(double[] r2) {
        checkOrder(r2, OrderDirection.INCREASING, true);
    }

    public static void checkOrder(double[] r1, OrderDirection r2, boolean r3) {
        checkOrder(r1, r2, r3, true);
    }

    public static boolean checkOrder(double[] r11, OrderDirection r12, boolean r13, boolean r14) {
        double r1 = r11[0];
        int r3 = r11.length;
        int r8 = 1;
    L3:
        if (r8 >= r3) goto L25;
        int r5 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$util$MathArrays$OrderDirection[r12.ordinal()];
        if (r5 != 1) goto L7;
        if (r13 == false) goto L22;
        if (r11[r8] <= r1) goto L25;
    L24:
        r1 = r11[r8];
        r8 = r8 + 1;
        goto L3
    L22:
        if (r11[r8] >= r1) goto L24;
    L7:
        if (r5 != 2) goto L16;
        if (r13 == false) goto L13;
        if (r11[r8] < r1) goto L24;
    L13:
        if (r11[r8] <= r1) goto L24;
    L16:
        throw new MathInternalError();
    L25:
        if (r8 != r3) goto L27;
        return true;
    L27:
        if (r14 == true) goto L30;
        return false;
    L30:
        throw new NonMonotonicSequenceException(Double.valueOf(r11[r8]), Double.valueOf(r1), r8, r12, r13);
    }

    public static double[] copyOf(double[] r1) {
        return copyOf(r1, r1.length);
    }

    public static double[] copyOf(double[] r2, int r3) {
        double[] r0 = new double[r3];
        System.arraycopy(r2, 0, r0, 0, FastMath.min(r3, r2.length));
        return r0;
    }

    public static int[] copyOf(int[] r1) {
        return copyOf(r1, r1.length);
    }

    public static int[] copyOf(int[] r2, int r3) {
        int[] r0 = new int[r3];
        System.arraycopy(r2, 0, r0, 0, FastMath.min(r3, r2.length));
        return r0;
    }

    public static double[] copyOfRange(double[] r2, int r3, int r4) {
        int r5 = r4 - r3;
        double[] r0 = new double[r5];
        System.arraycopy(r2, r3, r0, 0, FastMath.min(r5, r2.length - r3));
        return r0;
    }

    public static double distance(double[] r7, double[] r8) {
        checkEqualLength(r7, r8);
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L7;
        double r3 = r7[r2] - r8[r2];
        r0 = r0 + (r3 * r3);
        r2 = r2 + 1;
        goto L4
    L7:
        return FastMath.sqrt(r0);
    }

    public static double distance(int[] r5, int[] r6) {
        checkEqualLength(r5, r6);
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= r5.length) goto L7;
        double r3 = r5[r2] - r6[r2];
        r0 = r0 + (r3 * r3);
        r2 = r2 + 1;
        goto L4
    L7:
        return FastMath.sqrt(r0);
    }

    public static double distance1(double[] r7, double[] r8) {
        checkEqualLength(r7, r8);
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L6;
        r0 = r0 + FastMath.abs(r7[r2] - r8[r2]);
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static double distanceInf(double[] r7, double[] r8) {
        checkEqualLength(r7, r8);
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L6;
        r0 = FastMath.max(r0, FastMath.abs(r7[r2] - r8[r2]));
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public static boolean equals(double[] r7, double[] r8) {
        boolean r1 = false;
        if (r7 == null) goto L17;
        if (r8 == null) goto L17;
        if (r7.length == r8.length) goto L9;
        return false;
    L9:
        int r2 = 0;
    L11:
        if (r2 >= r7.length) goto L16;
        if (Precision.equals(r7[r2], r8[r2]) == false) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L17:
        if (r7 != null) goto L19;
        boolean r9 = true;
    L20:
        if (r8 != null) goto L23;
        r1 = true;
    L23:
        return !(r9 ^ r1);
    L19:
        r9 = false;
        goto L20
    }

    public static boolean equalsIncludingNaN(double[] r7, double[] r8) {
        boolean r1 = false;
        if (r7 == null) goto L17;
        if (r8 == null) goto L17;
        if (r7.length == r8.length) goto L9;
        return false;
    L9:
        int r2 = 0;
    L11:
        if (r2 >= r7.length) goto L16;
        if (Precision.equalsIncludingNaN(r7[r2], r8[r2]) == false) goto L14;
        r2 = r2 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L17:
        if (r7 != null) goto L19;
        boolean r9 = true;
    L20:
        if (r8 != null) goto L23;
        r1 = true;
    L23:
        return !(r9 ^ r1);
    L19:
        r9 = false;
        goto L20
    }

    public static double linearCombination(double r18, double r20, double r22, double r24) {
        double r0 = Double.longBitsToDouble(Double.doubleToRawLongBits(r18) & (-134217728));
        double r4 = r18 - r0;
        double r6 = Double.longBitsToDouble(Double.doubleToRawLongBits(r20) & (-134217728));
        double r8 = r20 - r6;
        double r10 = r18 * r20;
        double r12 = (r4 * r8) - (((r10 - (r0 * r6)) - (r4 * r6)) - (r0 * r8));
        double r1 = Double.longBitsToDouble(Double.doubleToRawLongBits(r22) & (-134217728));
        double r5 = r22 - r1;
        double r2 = Double.longBitsToDouble((-134217728) & Double.doubleToRawLongBits(r24));
        double r7 = r24 - r2;
        double r9 = r22 * r24;
        double r14 = (r5 * r7) - (((r9 - (r1 * r2)) - (r5 * r2)) - (r1 * r7));
        double r3 = r10 + r9;
        double r11 = r3 - r9;
        double r13 = r12 + r14;
        double r15 = (r13 + ((r9 - (r3 - r11)) + (r10 - r11))) + r3;
        if (Double.isNaN(r15) == false) goto L6;
        return r3;
    L6:
        return r15;
    }

    public static double linearCombination(double r22, double r24, double r26, double r28, double r30, double r32) {
        double r0 = Double.longBitsToDouble(Double.doubleToRawLongBits(r22) & (-134217728));
        double r4 = r22 - r0;
        double r6 = Double.longBitsToDouble(Double.doubleToRawLongBits(r24) & (-134217728));
        double r8 = r24 - r6;
        double r10 = r22 * r24;
        double r12 = (r4 * r8) - (((r10 - (r0 * r6)) - (r4 * r6)) - (r0 * r8));
        double r1 = Double.longBitsToDouble(Double.doubleToRawLongBits(r26) & (-134217728));
        double r5 = r26 - r1;
        double r7 = Double.longBitsToDouble(Double.doubleToRawLongBits(r28) & (-134217728));
        double r9 = r28 - r7;
        double r14 = r26 * r28;
        double r16 = (r5 * r9) - (((r14 - (r1 * r7)) - (r5 * r7)) - (r1 * r9));
        double r2 = Double.longBitsToDouble(Double.doubleToRawLongBits(r30) & (-134217728));
        double r11 = r30 - r2;
        double r3 = Double.longBitsToDouble((-134217728) & Double.doubleToRawLongBits(r32));
        double r13 = r32 - r3;
        double r15 = r30 * r32;
        double r18 = (r11 * r13) - (((r15 - (r2 * r3)) - (r11 * r3)) - (r2 * r13));
        double r17 = r10 + r14;
        double r19 = r17 - r14;
        double r110 = (r14 - (r17 - r19)) + (r10 - r19);
        double r20 = r17 + r15;
        double r21 = r20 - r15;
        double r111 = ((r12 + r16) + r18) + r110;
        double r112 = (r111 + ((r15 - (r20 - r21)) + (r17 - r21))) + r20;
        if (Double.isNaN(r112) == false) goto L6;
        return r20;
    L6:
        return r112;
    }

    public static double linearCombination(double r26, double r28, double r30, double r32, double r34, double r36, double r38, double r40) {
        double r0 = Double.longBitsToDouble(Double.doubleToRawLongBits(r26) & (-134217728));
        double r4 = r26 - r0;
        double r6 = Double.longBitsToDouble(Double.doubleToRawLongBits(r28) & (-134217728));
        double r8 = r28 - r6;
        double r10 = r26 * r28;
        double r12 = (r4 * r8) - (((r10 - (r0 * r6)) - (r4 * r6)) - (r0 * r8));
        double r1 = Double.longBitsToDouble(Double.doubleToRawLongBits(r30) & (-134217728));
        double r5 = r30 - r1;
        double r7 = Double.longBitsToDouble(Double.doubleToRawLongBits(r32) & (-134217728));
        double r9 = r32 - r7;
        double r14 = r30 * r32;
        double r16 = (r5 * r9) - (((r14 - (r1 * r7)) - (r5 * r7)) - (r1 * r9));
        double r2 = Double.longBitsToDouble(Double.doubleToRawLongBits(r34) & (-134217728));
        double r11 = r34 - r2;
        double r13 = Double.longBitsToDouble(Double.doubleToRawLongBits(r36) & (-134217728));
        double r15 = r36 - r13;
        double r18 = r34 * r36;
        double r20 = (r11 * r15) - (((r18 - (r2 * r13)) - (r11 * r13)) - (r2 * r15));
        double r3 = Double.longBitsToDouble(Double.doubleToRawLongBits(r38) & (-134217728));
        double r17 = r38 - r3;
        double r19 = Double.longBitsToDouble((-134217728) & Double.doubleToRawLongBits(r40));
        double r21 = r40 - r19;
        double r22 = r38 * r40;
        double r23 = (r17 * r21) - (((r22 - (r3 * r19)) - (r17 * r19)) - (r3 * r21));
        double r24 = r10 + r14;
        double r25 = r24 - r14;
        double r110 = (r14 - (r24 - r25)) + (r10 - r25);
        double r27 = r24 + r18;
        double r29 = r27 - r18;
        double r111 = (r18 - (r27 - r29)) + (r24 - r29);
        double r31 = r27 + r22;
        double r33 = r31 - r22;
        double r112 = ((((r12 + r16) + r20) + r23) + r110) + r111;
        double r113 = (r112 + ((r22 - (r31 - r33)) + (r27 - r33))) + r31;
        if (Double.isNaN(r113) == false) goto L6;
        return r31;
    L6:
        return r113;
    }

    public static double linearCombination(double[] r24, double[] r25) {
        checkEqualLength(r24, r25);
        int r1 = r24.length;
        int r2 = 0;
        int r3 = 1;
        if (r1 == 1) goto L5;
        double[] r4 = new double[r1];
        double r5 = 0.0d;
        int r7 = 0;
        double r8 = 0.0d;
    L7:
        if (r7 >= r1) goto L9;
        double r10 = r24[r7];
        double r12 = Double.longBitsToDouble(Double.doubleToRawLongBits(r10) & (-134217728));
        double r16 = r10 - r12;
        double r18 = r25[r7];
        double r14 = Double.longBitsToDouble(Double.doubleToRawLongBits(r18) & (-134217728));
        double r20 = r18 - r14;
        r4[r7] = r10 * r18;
        r8 = r8 + ((r16 * r20) - (((r4[r7] - (r12 * r14)) - (r16 * r14)) - (r12 * r20)));
        r7 = r7 + 1;
        goto L7
    L9:
        double r11 = r4[0];
        double r13 = r4[1];
        double r15 = r11 + r13;
        double r17 = r15 - r13;
        double r19 = (r13 - (r15 - r17)) + (r11 - r17);
        int r9 = r1 - 1;
    L10:
        if (r3 >= r9) goto L12;
        r3 = r3 + 1;
        double r110 = r4[r3];
        double r111 = r15 + r110;
        double r112 = r111 - r110;
        r19 = r19 + ((r110 - (r111 - r112)) + (r15 - r112));
        r15 = r111;
        goto L10
    L12:
        double r113 = r15 + (r8 + r19);
        if (Double.isNaN(r113) == false) goto L21;
    L14:
        if (r2 >= r1) goto L17;
        r5 = r5 + (r24[r2] * r25[r2]);
        r2 = r2 + 1;
        goto L14
    L17:
        return r5;
    L21:
        return r113;
    L5:
        return r24[0] * r25[0];
    }

    public static int[] natural(int r2) {
        return sequence(r2, 0, 1);
    }

    public static double[] normalizeArray(double[] r10, double r11) {
        int r1 = 0;
        if (Double.isInfinite(r11) == true) goto L30;
        if (Double.isNaN(r11) == true) goto L28;
        int r0 = r10.length;
        double[] r2 = new double[r0];
        int r5 = 0;
        double r6 = 0.0d;
    L7:
        if (r5 >= r0) goto L17;
        if (Double.isInfinite(r10[r5]) == true) goto L15;
        if (Double.isNaN(r10[r5]) == true) goto L13;
        r6 = r6 + r10[r5];
    L13:
        r5 = r5 + 1;
        goto L7
    L15:
        throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_ARRAY_ELEMENT, new Object[]{Double.valueOf(r10[r5]), Integer.valueOf(r5)});
    L17:
        if (r6 == 0.0d) goto L26;
    L18:
        if (r1 >= r0) goto L24;
        if (Double.isNaN(r10[r1]) == false) goto L22;
        r2[r1] = Double.NaN;
    L23:
        r1 = r1 + 1;
        goto L18
    L22:
        r2[r1] = (r10[r1] * r11) / r6;
        goto L23
    L24:
        return r2;
    L26:
        throw new MathArithmeticException(LocalizedFormats.ARRAY_SUMS_TO_ZERO, new Object[0]);
    L28:
        throw new MathIllegalArgumentException(LocalizedFormats.NORMALIZE_NAN, new Object[0]);
    L30:
        throw new MathIllegalArgumentException(LocalizedFormats.NORMALIZE_INFINITE, new Object[0]);
    }

    public static int[] sequence(int r3, int r4, int r5) {
        int[] r0 = new int[r3];
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r0[r1] = (r1 * r5) + r4;
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public static void shuffle(int[] r3, int r4, Position r5, RandomGenerator r6) {
        RandomGenerator r7 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r6, RandomGenerator.class, "com.obric.memorydata.plugin");
        int r8 = AnonymousClass3.$SwitchMap$org$apache$commons$math3$util$MathArrays$Position[r5.ordinal()];
        if (r8 != 1) goto L5;
        int r9 = r3.length - 1;
    L15:
        if (r9 < r4) goto L27;
        if (r9 != r4) goto L18;
        int r0 = r4;
    L19:
        int r1 = r3[r0];
        r3[r0] = r3[r9];
        r3[r9] = r1;
        r9 = r9 - 1;
        goto L15
    L18:
        r0 = new UniformIntegerDistribution(r7, r4, r9).sample();
        goto L19
    L27:
        return;
    L5:
        if (r8 != 2) goto L13;
        int r10 = 0;
    L7:
        if (r10 > r4) goto L20;
        if (r10 != r4) goto L10;
        int r2 = r4;
    L11:
        int r11 = r3[r2];
        r3[r2] = r3[r10];
        r3[r10] = r11;
        r10 = r10 + 1;
        goto L7
    L10:
        r2 = new UniformIntegerDistribution(r7, r10, r4).sample();
        goto L11
    L20:
        return;
    L13:
        throw new MathInternalError();
    }

    public static void shuffle(int[] r2, RandomGenerator r3) {
        RandomGenerator r4 = (RandomGenerator) ZeusTransformUtils.wrapperContextForParams(r3, RandomGenerator.class, "com.obric.memorydata.plugin");
        shuffle(r2, 0, Position.TAIL, r4);
    }

    public static void sortInPlace(double[] r9, OrderDirection r10, double[]... r11) {
        if (r9 == null) goto L33;
        int r0 = r11.length;
        int r1 = r9.length;
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L14;
        double[] r4 = r11[r3];
        if (r4 == null) goto L13;
        if (r4.length != r1) goto L11;
        r3 = r3 + 1;
        goto L4
    L11:
        throw new DimensionMismatchException(r4.length, r1);
    L13:
        throw new NullArgumentException();
    L14:
        ArrayList r5 = new ArrayList(r1);
        int r6 = 0;
    L15:
        if (r6 >= r1) goto L18;
        r5.add(new PairDoubleInteger(r9[r6], r6));
        r6 = r6 + 1;
        goto L15
    L18:
        if (r10 != OrderDirection.INCREASING) goto L20;
        Comparator<PairDoubleInteger> r12 = new AnonymousClass1();
    L21:
        Collections.sort(r5, r12);
        int[] r13 = new int[r1];
        int r7 = 0;
    L23:
        if (r7 >= r1) goto L25;
        PairDoubleInteger r8 = (PairDoubleInteger) ZeusTransformUtils.preCheckCast(r5.get(r7), PairDoubleInteger.class, "com.obric.memorydata.plugin");
        r9[r7] = r8.getKey();
        r13[r7] = r8.getValue();
        r7 = r7 + 1;
        goto L23
    L25:
        int r14 = 0;
    L26:
        if (r14 >= r0) goto L31;
        double[] r15 = r11[r14];
        double[] r16 = (double[]) ZeusTransformUtils.preCheckCast(r15.clone(), double[].class, "com.obric.memorydata.plugin");
        int r17 = 0;
    L28:
        if (r17 >= r1) goto L30;
        r15[r17] = r16[r13[r17]];
        r17 = r17 + 1;
        goto L28
    L30:
        r14 = r14 + 1;
        goto L26
    L31:
        return;
    L20:
        r12 = new AnonymousClass2();
        goto L21
    L33:
        throw new NullArgumentException();
    }

    public static void sortInPlace(double[] r1, double[]... r2) {
        sortInPlace(r1, OrderDirection.INCREASING, r2);
    }

    public static boolean verifyValues(double[] r1, int r2, int r3) {
        return verifyValues(r1, r2, r3, false);
    }

    public static boolean verifyValues(double[] r3, int r4, int r5, boolean r6) {
        if (r3 == null) goto L19;
        if (r4 < 0) goto L17;
        if (r5 < 0) goto L15;
        int r7 = r4 + r5;
        if (r7 > r3.length) goto L13;
        if (r5 != 0) goto L11;
        if (r6 == true) goto L11;
        return false;
    L11:
        return true;
    L13:
        throw new NumberIsTooLargeException(LocalizedFormats.SUBARRAY_ENDS_AFTER_ARRAY_END, Integer.valueOf(r7), Integer.valueOf(r3.length), true);
    L15:
        throw new NotPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(r5));
    L17:
        throw new NotPositiveException(LocalizedFormats.START_POSITION, Integer.valueOf(r4));
    L19:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    public static boolean verifyValues(double[] r10, double[] r11, int r12, int r13, boolean r14) {
        if (r11 == null) goto L31;
        if (r10 == null) goto L31;
        checkEqualLength(r11, r10);
        int r1 = r12;
        boolean r2 = false;
    L7:
        if (r1 >= (r12 + r13)) goto L25;
        double r3 = r11[r1];
        if (Double.isNaN(r3) == true) goto L24;
        if (Double.isInfinite(r3) == true) goto L22;
        if (r3 < 0.0d) goto L20;
        if (r2 == true) goto L18;
        if (r3 <= 0.0d) goto L18;
        r2 = true;
    L18:
        r1 = r1 + 1;
        goto L7
    L20:
        throw new MathIllegalArgumentException(LocalizedFormats.NEGATIVE_ELEMENT_AT_INDEX, new Object[]{Integer.valueOf(r1), Double.valueOf(r3)});
    L22:
        throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_ARRAY_ELEMENT, new Object[]{Double.valueOf(r3), Integer.valueOf(r1)});
    L24:
        throw new MathIllegalArgumentException(LocalizedFormats.NAN_ELEMENT_AT_INDEX, new Object[]{Integer.valueOf(r1)});
    L25:
        if (r2 == false) goto L29;
        return verifyValues(r10, r12, r13, r14);
    L29:
        throw new MathIllegalArgumentException(LocalizedFormats.WEIGHT_AT_LEAST_ONE_NON_ZERO, new Object[0]);
    L31:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }
}
