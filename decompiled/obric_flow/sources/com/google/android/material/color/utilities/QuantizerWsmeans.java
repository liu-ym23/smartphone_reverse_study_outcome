package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWsmeans {
    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3.0d;

    public static final class Distance implements Comparable<Distance> {
        double distance;
        int index;

        public Distance() {
            this.index = -1;
            this.distance = -1.0d;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Distance r5) {
            return compareTo2(r5);
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Distance r5) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(r5.distance));
        }
    }

    private QuantizerWsmeans() {
    }

    public static Map<Integer, Integer> quantize(int[] r25, int[] r26, int r27) {
        int r5 = 1;
        Random r10 = new Random(272008);
        LinkedHashMap r11 = new LinkedHashMap();
        double[][] r12 = new double[r25.length][];
        int[] r13 = new int[r25.length];
        PointProviderLab r14 = new PointProviderLab();
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r15 >= r25.length) goto L10;
        int r17 = r25[r15];
        Integer r18 = (Integer) r11.get(Integer.valueOf(r17));
        if (r18 != null) goto L8;
        r12[r16] = r14.fromInt(r17);
        r13[r16] = r17;
        r16 = r16 + 1;
        r11.put(Integer.valueOf(r17), 1);
    L9:
        r15 = r15 + 1;
        goto L4
    L8:
        r11.put(Integer.valueOf(r17), Integer.valueOf(r18.intValue() + 1));
        goto L9
    L10:
        int[] r19 = new int[r16];
        int r20 = 0;
    L11:
        if (r20 >= r16) goto L13;
        r19[r20] = ((Integer) r11.get(Integer.valueOf(r13[r20]))).intValue();
        r20 = r20 + 1;
        goto L11
    L13:
        int r21 = Math.min(r27, r16);
        if (r26.length == 0) goto L16;
        r21 = Math.min(r21, r26.length);
    L16:
        double[][] r22 = new double[r21][];
        int r23 = 0;
        int r110 = 0;
    L18:
        if (r23 >= r26.length) goto L20;
        r22[r23] = r14.fromInt(r26[r23]);
        r110 = r110 + 1;
        r23 = r23 + 1;
        goto L18
    L20:
        int r24 = r21 - r110;
        if (r24 <= 0) goto L25;
        int r28 = 0;
    L23:
        if (r28 >= r24) goto L25;
        r28 = r28 + 1;
    L25:
        int[] r29 = new int[r16];
        int r30 = 0;
    L26:
        if (r30 >= r16) goto L28;
        r29[r30] = r10.nextInt(r21);
        r30 = r30 + 1;
        goto L26
    L28:
        int[][] r31 = new int[r21][];
        int r32 = 0;
    L29:
        if (r32 >= r21) goto L31;
        r31[r32] = new int[r21];
        r32 = r32 + 1;
        goto L29
    L31:
        Distance[][] r33 = new Distance[r21][];
        int r111 = 0;
    L32:
        if (r111 >= r21) goto L37;
        r33[r111] = new Distance[r21];
        int r112 = 0;
    L34:
        if (r112 >= r21) goto L36;
        r33[r111][r112] = new Distance();
        r112 = r112 + 1;
        goto L34
    L36:
        r111 = r111 + 1;
        goto L32
    L37:
        int[] r113 = new int[r21];
        int r114 = 0;
    L39:
        if (r114 >= 10) goto L82;
        int r115 = 0;
    L41:
        if (r115 >= r21) goto L49;
        int r116 = r115 + 1;
        int r117 = r116;
    L43:
        if (r117 >= r21) goto L45;
        int[] r210 = r113;
        double r118 = r14.distance(r22[r115], r22[r117]);
        Distance r34 = r33[r117][r115];
        r34.distance = r118;
        r34.index = r115;
        Distance r35 = r33[r115][r117];
        r35.distance = r118;
        r35.index = r117;
        r5 = 1;
        r117 = r117 + 1;
        r113 = r210;
        r114 = r114;
        goto L43
    L45:
        int[] r211 = r113;
        int r212 = r114;
        Arrays.sort(r33[r115]);
        int r36 = 0;
    L46:
        if (r36 >= r21) goto L48;
        r31[r115][r36] = r33[r115][r36].index;
        r36 = r36 + r5;
        goto L46
    L48:
        r113 = r211;
        r114 = r212;
        r115 = r116;
        goto L41
    L49:
        int[] r213 = r113;
        int r214 = r114;
        int r37 = 0;
        int r38 = 0;
    L50:
        if (r37 >= r16) goto L66;
        double[] r119 = r12[r37];
        int r120 = r29[r37];
        double r121 = r14.distance(r119, r22[r120]);
        int[][] r122 = r31;
        double r123 = r121;
        int r39 = -1;
        int r124 = 0;
    L52:
        if (r124 >= r21) goto L60;
        Distance[][] r215 = r33;
        int r216 = r16;
        if (r33[r120][r124].distance >= (4.0d * r121)) goto L59;
        double r40 = r14.distance(r119, r22[r124]);
        if (r40 >= r123) goto L59;
        r123 = r40;
        r39 = r124;
    L59:
        r124 = r124 + 1;
        r16 = r216;
        r33 = r215;
        goto L52
    L60:
        Distance[][] r217 = r33;
        int r218 = r16;
        if (r39 == (-1)) goto L65;
        if (Math.abs(Math.sqrt(r123) - Math.sqrt(r121)) <= 3.0d) goto L65;
        r38 = r38 + 1;
        r29[r37] = r39;
    L65:
        r37 = r37 + 1;
        r31 = r122;
        r16 = r218;
        r33 = r217;
        goto L50
    L66:
        int[][] r125 = r31;
        Distance[][] r219 = r33;
        int r220 = r16;
        if (r38 != 0) goto L70;
        if (r214 == 0) goto L70;
        int r126 = 0;
        int[] r127 = r213;
    L83:
        LinkedHashMap r41 = new LinkedHashMap();
        int r42 = r126;
    L84:
        if (r42 >= r21) goto L93;
        int r43 = r127[r42];
        if (r43 == 0) goto L92;
        int r44 = r14.toInt(r22[r42]);
        if (r41.containsKey(Integer.valueOf(r44)) == true) goto L92;
        r41.put(Integer.valueOf(r44), Integer.valueOf(r43));
    L92:
        r42 = r42 + 1;
        goto L84
    L93:
        return r41;
    L70:
        double[] r45 = new double[r21];
        double[] r46 = new double[r21];
        double[] r47 = new double[r21];
        char r48 = 0;
        Arrays.fill(r213, 0);
        int r128 = 0;
    L71:
        int r129 = r220;
        if (r128 >= r129) goto L74;
        int r130 = r29[r128];
        double[] r131 = r12[r128];
        int r132 = r19[r128];
        r213[r130] = r213[r130] + r132;
        double r133 = r45[r130];
        double r221 = r131[r48];
        int[] r49 = r19;
        double r50 = r132;
        r45[r130] = (r221 * r50) + r133;
        r46[r130] = (r131[1] * r50) + r46[r130];
        r47[r130] = (r131[2] * r50) + r47[r130];
        r128 = r128 + 1;
        r19 = r49;
        r29 = r29;
        r48 = 0;
        r220 = r129;
        goto L71
    L74:
        int[] r51 = r19;
        int[] r222 = r29;
        int r52 = 0;
    L75:
        if (r52 >= r21) goto L81;
        int r53 = r213[r52];
        if (r53 != 0) goto L79;
        r22[r52] = new double[]{0.0d, 0.0d, 0.0d};
        int r134 = 1;
    L80:
        r52 = r52 + r134;
        goto L75
    L79:
        double r135 = r53;
        double r136 = r45[r52] / r135;
        double r137 = r46[r52] / r135;
        double r223 = r47[r52] / r135;
        double[] r54 = r22[r52];
        r54[0] = r136;
        r134 = 1;
        r54[1] = r137;
        r54[2] = r223;
        goto L80
    L81:
        r114 = r214 + 1;
        r19 = r51;
        r5 = 1;
        r31 = r125;
        r29 = r222;
        r33 = r219;
        r113 = r213;
        r16 = r129;
        goto L39
    L82:
        r127 = r113;
        r126 = 0;
        goto L83
    }
}
