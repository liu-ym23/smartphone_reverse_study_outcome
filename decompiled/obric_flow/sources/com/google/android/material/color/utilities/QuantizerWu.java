package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWu implements Quantizer {
    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 35937;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    /* JADX INFO: renamed from: com.google.android.material.color.utilities.QuantizerWu$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction = null;

        static {
            int[] r5 = new int[Direction.values().length];
            $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction = r5;
            r5[Direction.RED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[Direction.GREEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[Direction.BLUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final class Box {

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        int f8530b0;
        int b1;
        int g0;

        /* JADX INFO: renamed from: g1, reason: collision with root package name */
        int f8531g1;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        int f8532r0;

        /* JADX INFO: renamed from: r1, reason: collision with root package name */
        int f8533r1;
        int vol;

        private Box() {
            this.f8532r0 = 0;
            this.f8533r1 = 0;
            this.g0 = 0;
            this.f8531g1 = 0;
            this.f8530b0 = 0;
            this.b1 = 0;
            this.vol = 0;
        }

        public /* synthetic */ Box(AnonymousClass1 r5) {
            this();
        }
    }

    public static final class CreateBoxesResult {
        int resultCount;

        public CreateBoxesResult(int r5, int r10) {
            this.resultCount = r10;
        }
    }

    public static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction BLUE = null;
        public static final Direction GREEN = null;
        public static final Direction RED = null;

        static {
            Direction r5 = new Direction("RED", 0);
            RED = r5;
            Direction r10 = new Direction("GREEN", 1);
            GREEN = r10;
            Direction r11 = new Direction("BLUE", 2);
            BLUE = r11;
            $VALUES = new Direction[]{r5, r10, r11};
        }

        private Direction(String r5, int r10) {
            super(r5, r10);
        }

        public static Direction valueOf(String r5) {
            return (Direction) Enum.valueOf(Direction.class, r5);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }
    }

    public static final class MaximizeResult {
        int cutLocation;
        double maximum;

        public MaximizeResult(int r5, double r10) {
            this.cutLocation = r5;
            this.maximum = r10;
        }
    }

    public QuantizerWu() {
    }

    public static int bottom(Box r5, Direction r10, int[] r11) {
        int r12 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[r10.ordinal()];
        if (r12 != 1) goto L5;
        int r13 = ((-r11[getIndex(r5.f8532r0, r5.f8531g1, r5.b1)]) + r11[getIndex(r5.f8532r0, r5.f8531g1, r5.f8530b0)]) + r11[getIndex(r5.f8532r0, r5.g0, r5.b1)];
        int r14 = r11[getIndex(r5.f8532r0, r5.g0, r5.f8530b0)];
    L10:
        return r13 - r14;
    L5:
        if (r12 != 2) goto L7;
        r13 = ((-r11[getIndex(r5.f8533r1, r5.g0, r5.b1)]) + r11[getIndex(r5.f8533r1, r5.g0, r5.f8530b0)]) + r11[getIndex(r5.f8532r0, r5.g0, r5.b1)];
        r14 = r11[getIndex(r5.f8532r0, r5.g0, r5.f8530b0)];
        goto L10
    L7:
        if (r12 != 3) goto L12;
        r13 = ((-r11[getIndex(r5.f8533r1, r5.f8531g1, r5.f8530b0)]) + r11[getIndex(r5.f8533r1, r5.g0, r5.f8530b0)]) + r11[getIndex(r5.f8532r0, r5.f8531g1, r5.f8530b0)];
        r14 = r11[getIndex(r5.f8532r0, r5.g0, r5.f8530b0)];
        goto L10
    L12:
        throw new IllegalArgumentException("unexpected direction " + r10);
    }

    public static int getIndex(int r5, int r10, int r11) {
        return (((((r5 << 10) + (r5 << 6)) + r5) + (r10 << 5)) + r10) + r11;
    }

    public static int top(Box r5, Direction r10, int r11, int[] r12) {
        int r13 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[r10.ordinal()];
        if (r13 != 1) goto L5;
        int r14 = (r12[getIndex(r11, r5.f8531g1, r5.b1)] - r12[getIndex(r11, r5.f8531g1, r5.f8530b0)]) - r12[getIndex(r11, r5.g0, r5.b1)];
        int r15 = r12[getIndex(r11, r5.g0, r5.f8530b0)];
    L10:
        return r14 + r15;
    L5:
        if (r13 != 2) goto L7;
        r14 = (r12[getIndex(r5.f8533r1, r11, r5.b1)] - r12[getIndex(r5.f8533r1, r11, r5.f8530b0)]) - r12[getIndex(r5.f8532r0, r11, r5.b1)];
        r15 = r12[getIndex(r5.f8532r0, r11, r5.f8530b0)];
        goto L10
    L7:
        if (r13 != 3) goto L12;
        r14 = (r12[getIndex(r5.f8533r1, r5.f8531g1, r11)] - r12[getIndex(r5.f8533r1, r5.g0, r11)]) - r12[getIndex(r5.f8532r0, r5.f8531g1, r11)];
        r15 = r12[getIndex(r5.f8532r0, r5.g0, r11)];
        goto L10
    L12:
        throw new IllegalArgumentException("unexpected direction " + r10);
    }

    public static int volume(Box r5, int[] r10) {
        return ((((((r10[getIndex(r5.f8533r1, r5.f8531g1, r5.b1)] - r10[getIndex(r5.f8533r1, r5.f8531g1, r5.f8530b0)]) - r10[getIndex(r5.f8533r1, r5.g0, r5.b1)]) + r10[getIndex(r5.f8533r1, r5.g0, r5.f8530b0)]) - r10[getIndex(r5.f8532r0, r5.f8531g1, r5.b1)]) + r10[getIndex(r5.f8532r0, r5.f8531g1, r5.f8530b0)]) + r10[getIndex(r5.f8532r0, r5.g0, r5.b1)]) - r10[getIndex(r5.f8532r0, r5.g0, r5.f8530b0)];
    }

    public void constructHistogram(Map<Integer, Integer> r10) {
        this.weights = new int[TOTAL_SIZE];
        this.momentsR = new int[TOTAL_SIZE];
        this.momentsG = new int[TOTAL_SIZE];
        this.momentsB = new int[TOTAL_SIZE];
        this.moments = new double[TOTAL_SIZE];
        Iterator<Map.Entry<Integer, Integer>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<Integer, Integer> r5 = r11.next();
        int r12 = r5.getKey().intValue();
        int r13 = r5.getValue().intValue();
        int r14 = ColorUtils.redFromArgb(r12);
        int r15 = ColorUtils.greenFromArgb(r12);
        int r16 = ColorUtils.blueFromArgb(r12);
        int r17 = getIndex((r14 >> 3) + 1, (r15 >> 3) + 1, (r16 >> 3) + 1);
        int[] r18 = this.weights;
        r18[r17] = r18[r17] + r13;
        int[] r19 = this.momentsR;
        int r20 = r14 * r13;
        r19[r17] = r20 + r19[r17];
        int[] r21 = this.momentsG;
        int r22 = r15 * r13;
        r21[r17] = r22 + r21[r17];
        int[] r23 = this.momentsB;
        int r24 = r16 * r13;
        r23[r17] = r24 + r23[r17];
        double[] r25 = this.moments;
        int r26 = r15 * r15;
        int r27 = r16 * r16;
        r25[r17] = r25[r17] + ((double) ((r27 + (r26 + (r14 * r14))) * r13));
        goto L4
    }

    public CreateBoxesResult createBoxes(int r14) {
        this.cubes = new Box[r14];
        int r5 = 0;
    L3:
        if (r5 >= r14) goto L5;
        this.cubes[r5] = new Box(null);
        r5 = r5 + 1;
        goto L3
    L5:
        double[] r10 = new double[r14];
        Box r11 = this.cubes[0];
        r11.f8533r1 = 32;
        r11.f8531g1 = 32;
        r11.b1 = 32;
        int r12 = 0;
        int r13 = 1;
    L6:
        if (r13 >= r14) goto L29;
        Box[] r15 = this.cubes;
        if (cut(r15[r12], r15[r13]).booleanValue() == false) goto L18;
        Box r16 = this.cubes[r12];
        if (r16.vol <= 1) goto L12;
        double r17 = variance(r16);
    L13:
        r10[r12] = r17;
        Box r18 = this.cubes[r13];
        if (r18.vol <= 1) goto L16;
        double r19 = variance(r18);
    L17:
        r10[r13] = r19;
    L19:
        double r20 = r10[0];
        int r21 = 0;
        int r22 = 1;
    L20:
        if (r22 > r13) goto L26;
        double r110 = r10[r22];
        if (r110 <= r20) goto L24;
        r21 = r22;
        r20 = r110;
    L24:
        r22 = r22 + 1;
        goto L20
    L26:
        if (r20 <= 0.0d) goto L27;
        r13 = r13 + 1;
        r12 = r21;
        goto L6
    L27:
        int r23 = r13 + 1;
    L31:
        return new CreateBoxesResult(r14, r23);
    L16:
        r19 = 0.0d;
        goto L17
    L12:
        r17 = 0.0d;
        goto L13
    L18:
        r10[r12] = 0.0d;
        r13 = r13 - 1;
        goto L19
    L29:
        r23 = r14;
        goto L31
    }

    public void createMoments() {
        int r5 = 1;
    L3:
        int r10 = 33;
        if (r5 >= 33) goto L12;
        int[] r11 = new int[33];
        int[] r12 = new int[33];
        int[] r13 = new int[33];
        int[] r14 = new int[33];
        double[] r15 = new double[33];
        int r16 = 1;
    L6:
        if (r16 >= r10) goto L11;
        int r17 = 0;
        int r18 = 0;
        double r19 = 0.0d;
        int r20 = 1;
        int r110 = 0;
        int r111 = 0;
    L8:
        if (r20 >= r10) goto L10;
        int r112 = getIndex(r5, r16, r20);
        int r113 = r17 + this.weights[r112];
        r110 = r110 + this.momentsR[r112];
        r111 = r111 + this.momentsG[r112];
        r18 = r18 + this.momentsB[r112];
        r19 = r19 + this.moments[r112];
        r11[r20] = r11[r20] + r113;
        r12[r20] = r12[r20] + r110;
        r13[r20] = r13[r20] + r111;
        r14[r20] = r14[r20] + r18;
        r15[r20] = r15[r20] + r19;
        int r21 = getIndex(r5 - 1, r16, r20);
        int[] r114 = this.weights;
        r114[r112] = r114[r21] + r11[r20];
        int[] r115 = this.momentsR;
        r115[r112] = r115[r21] + r12[r20];
        int[] r116 = this.momentsG;
        r116[r112] = r116[r21] + r13[r20];
        int[] r117 = this.momentsB;
        r117[r112] = r117[r21] + r14[r20];
        double[] r118 = this.moments;
        r118[r112] = r118[r21] + r15[r20];
        r20 = r20 + 1;
        r17 = r113;
        r10 = 33;
        goto L8
    L10:
        r16 = r16 + 1;
        r10 = 33;
        goto L6
    L11:
        r5 = r5 + 1;
        goto L3
    }

    public List<Integer> createResult(int r10) {
        ArrayList r5 = new ArrayList();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        Box r12 = this.cubes[r11];
        int r13 = volume(r12, this.weights);
        if (r13 <= 0) goto L7;
        int r14 = volume(r12, this.momentsR) / r13;
        int r15 = volume(r12, this.momentsG) / r13;
        int r16 = volume(r12, this.momentsB) / r13;
        int r17 = r16 & 255;
        r5.add(Integer.valueOf(r17 | ((((r14 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK) | ((r15 & 255) << 8))));
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        return r5;
    }

    public Boolean cut(Box r21, Box r22) {
        int r12 = volume(r21, this.momentsR);
        int r13 = volume(r21, this.momentsG);
        int r14 = volume(r21, this.momentsB);
        int r15 = volume(r21, this.weights);
        Direction r16 = Direction.RED;
        MaximizeResult r10 = maximize(r21, r16, r21.f8532r0 + 1, r21.f8533r1, r12, r13, r14, r15);
        Direction r17 = Direction.GREEN;
        MaximizeResult r11 = maximize(r21, r17, r21.g0 + 1, r21.f8531g1, r12, r13, r14, r15);
        Direction r19 = Direction.BLUE;
        MaximizeResult r5 = maximize(r21, r19, r21.f8530b0 + 1, r21.b1, r12, r13, r14, r15);
        double r18 = r10.maximum;
        double r20 = r11.maximum;
        double r23 = r5.maximum;
        if (r18 < r20) goto L11;
        if (r18 < r23) goto L11;
        if (r10.cutLocation < 0) goto L9;
    L16:
        r22.f8533r1 = r21.f8533r1;
        r22.f8531g1 = r21.f8531g1;
        r22.b1 = r21.b1;
        int r24 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[r16.ordinal()];
        if (r24 != 1) goto L19;
        int r25 = r10.cutLocation;
        r21.f8533r1 = r25;
        r22.f8532r0 = r25;
        r22.g0 = r21.g0;
        r22.f8530b0 = r21.f8530b0;
    L26:
        int r26 = r21.f8533r1 - r21.f8532r0;
        int r27 = (r21.f8531g1 - r21.g0) * r26;
        r21.vol = (r21.b1 - r21.f8530b0) * r27;
        int r28 = r22.f8533r1 - r22.f8532r0;
        int r29 = (r22.f8531g1 - r22.g0) * r28;
        r22.vol = (r22.b1 - r22.f8530b0) * r29;
        return Boolean.TRUE;
    L19:
        if (r24 != 2) goto L21;
        int r30 = r11.cutLocation;
        r21.f8531g1 = r30;
        r22.f8532r0 = r21.f8532r0;
        r22.g0 = r30;
        r22.f8530b0 = r21.f8530b0;
        goto L26
    L21:
        if (r24 != 3) goto L26;
        int r31 = r5.cutLocation;
        r21.b1 = r31;
        r22.f8532r0 = r21.f8532r0;
        r22.g0 = r21.g0;
        r22.f8530b0 = r31;
        goto L26
    L9:
        return Boolean.FALSE;
    L11:
        if (r20 >= r18) goto L13;
    L15:
        r16 = r19;
        goto L16
    L13:
        if (r20 < r23) goto L15;
        r16 = r17;
        goto L16
    }

    public MaximizeResult maximize(Box r19, Direction r20, int r21, int r22, int r23, int r24, int r25, int r26) {
        QuantizerWu r5 = this;
        Box r10 = r19;
        Direction r11 = r20;
        int r12 = bottom(r10, r11, r5.momentsR);
        int r13 = bottom(r10, r11, r5.momentsG);
        int r14 = bottom(r10, r11, r5.momentsB);
        int r15 = bottom(r10, r11, r5.weights);
        int r16 = -1;
        double r17 = 0.0d;
        int r18 = r21;
    L3:
        if (r18 >= r22) goto L15;
        int r110 = top(r10, r11, r18, r5.momentsR) + r12;
        int r111 = top(r10, r11, r18, r5.momentsG) + r13;
        int r112 = top(r10, r11, r18, r5.momentsB) + r14;
        int r113 = top(r10, r11, r18, r5.weights) + r15;
        if (r113 != 0) goto L7;
        int r114 = r12;
    L13:
        r18 = r18 + 1;
        r5 = this;
        r10 = r19;
        r11 = r20;
        r12 = r114;
        goto L3
    L7:
        r114 = r12;
        double r27 = ((r112 * r112) + ((r111 * r111) + (r110 * r110))) / ((double) r113);
        int r28 = r23 - r110;
        int r29 = r24 - r111;
        int r115 = r25 - r112;
        int r116 = r26 - r113;
        if (r116 == 0) goto L13;
        int r117 = r115 * r115;
        double r30 = (((double) (r117 + ((r29 * r29) + (r28 * r28)))) / ((double) r116)) + r27;
        if (r30 <= r17) goto L13;
        r17 = r30;
        r16 = r18;
        goto L13
    L15:
        return new MaximizeResult(r16, r17);
    }

    @Override // com.google.android.material.color.utilities.Quantizer
    public QuantizerResult quantize(int[] r5, int r10) {
        constructHistogram(new QuantizerMap().quantize(r5, r10).colorToCount);
        createMoments();
        List<Integer> r11 = createResult(createBoxes(r10).resultCount);
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<Integer> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        Integer r14 = r13.next();
        r14.intValue();
        r12.put(r14, 0);
        goto L4
    L7:
        return new QuantizerResult(r12);
    }

    public double variance(Box r10) {
        int r5 = volume(r10, this.momentsR);
        int r11 = volume(r10, this.momentsG);
        int r12 = volume(r10, this.momentsB);
        int r13 = r11 * r11;
        int r14 = r12 * r12;
        return (((((((this.moments[getIndex(r10.f8533r1, r10.f8531g1, r10.b1)] - this.moments[getIndex(r10.f8533r1, r10.f8531g1, r10.f8530b0)]) - this.moments[getIndex(r10.f8533r1, r10.g0, r10.b1)]) + this.moments[getIndex(r10.f8533r1, r10.g0, r10.f8530b0)]) - this.moments[getIndex(r10.f8532r0, r10.f8531g1, r10.b1)]) + this.moments[getIndex(r10.f8532r0, r10.f8531g1, r10.f8530b0)]) + this.moments[getIndex(r10.f8532r0, r10.g0, r10.b1)]) - this.moments[getIndex(r10.f8532r0, r10.g0, r10.f8530b0)]) - (((double) (r14 + (r13 + (r5 * r5)))) / ((double) volume(r10, this.weights)));
    }
}
