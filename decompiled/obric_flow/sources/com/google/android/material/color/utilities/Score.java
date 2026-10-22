package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Score {
    private static final int BLUE_500 = -12417548;
    private static final double CUTOFF_CHROMA = 5.0d;
    private static final double CUTOFF_EXCITED_PROPORTION = 0.01d;
    private static final int MAX_COLOR_COUNT = 4;
    private static final double TARGET_CHROMA = 48.0d;
    private static final double WEIGHT_CHROMA_ABOVE = 0.3d;
    private static final double WEIGHT_CHROMA_BELOW = 0.1d;
    private static final double WEIGHT_PROPORTION = 0.7d;

    public static class ScoredComparator implements Comparator<ScoredHCT> {
        public ScoredComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ScoredHCT r5, ScoredHCT r10) {
            return compare2(r5, r10);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(ScoredHCT r5, ScoredHCT r10) {
            return Double.compare(r10.score, r5.score);
        }
    }

    public static class ScoredHCT {
        public final Hct hct;
        public final double score;

        public ScoredHCT(Hct r5, double r10) {
            this.hct = r5;
            this.score = r10;
        }
    }

    private Score() {
    }

    public static List<Integer> score(Map<Integer, Integer> r5) {
        return score(r5, 4, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> r5, int r10) {
        return score(r5, r10, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> r5, int r10, int r11) {
        return score(r5, r10, r11, true);
    }

    public static List<Integer> score(Map<Integer, Integer> r12, int r13, int r14, boolean r15) {
        ArrayList r5 = new ArrayList();
        int[] r10 = new int[360];
        Iterator<Map.Entry<Integer, Integer>> r16 = r12.entrySet().iterator();
        double r11 = 0.0d;
    L4:
        if (r16.hasNext() == false) goto L6;
        Map.Entry<Integer, Integer> r17 = r16.next();
        Hct r18 = Hct.fromInt(r17.getKey().intValue());
        r5.add(r18);
        int r19 = (int) Math.floor(r18.getHue());
        int r20 = r17.getValue().intValue();
        r10[r19] = r10[r19] + r20;
        r11 = r11 + ((double) r20);
        goto L4
    L6:
        double[] r110 = new double[360];
        int r21 = 0;
    L7:
        if (r21 >= 360) goto L13;
        double r22 = ((double) r10[r21]) / r11;
        int r23 = r21 - 14;
    L10:
        if (r23 >= (r21 + 16)) goto L12;
        int r24 = MathUtils.sanitizeDegreesInt(r23);
        r110[r24] = r110[r24] + r22;
        r23 = r23 + 1;
        goto L10
    L12:
        r21 = r21 + 1;
        goto L7
    L13:
        ArrayList r25 = new ArrayList();
        Iterator r26 = r5.iterator();
    L15:
        if (r26.hasNext() == false) goto L28;
        Hct r27 = (Hct) r26.next();
        double r28 = r110[MathUtils.sanitizeDegreesInt((int) Math.round(r27.getHue()))];
        if (r15 == false) goto L23;
        if (r27.getChroma() < CUTOFF_CHROMA) goto L15;
        if (r28 <= CUTOFF_EXCITED_PROPORTION) goto L15;
    L23:
        double r29 = (r28 * 100.0d) * WEIGHT_PROPORTION;
        if (r27.getChroma() >= TARGET_CHROMA) goto L26;
        double r30 = WEIGHT_CHROMA_BELOW;
    L27:
        r25.add(new ScoredHCT(r27, ((r27.getChroma() - TARGET_CHROMA) * r30) + r29));
        goto L15
    L26:
        r30 = WEIGHT_CHROMA_ABOVE;
        goto L27
    L28:
        Collections.sort(r25, new ScoredComparator());
        ArrayList r111 = new ArrayList();
        int r112 = 90;
    L30:
        if (r112 < 15) goto L47;
        r111.clear();
        Iterator r31 = r25.iterator();
    L33:
        if (r31.hasNext() == false) goto L44;
        Hct r32 = ((ScoredHCT) r31.next()).hct;
        Iterator r33 = r111.iterator();
    L36:
        if (r33.hasNext() == false) goto L40;
        if (MathUtils.differenceDegrees(r32.getHue(), ((Hct) r33.next()).getHue()) >= r112) goto L36;
    L42:
        if (r111.size() < r13) goto L33;
    L40:
        r111.add(r32);
    L44:
        if (r111.size() >= r13) goto L47;
        r112 = r112 - 1;
    L47:
        ArrayList r113 = new ArrayList();
        if (r111.isEmpty() == false) goto L51;
        r113.add(Integer.valueOf(r14));
        return r113;
    L51:
        Iterator r114 = r111.iterator();
    L53:
        if (r114.hasNext() == false) goto L55;
        r113.add(Integer.valueOf(((Hct) r114.next()).toInt()));
        goto L53
    L55:
        return r113;
    }
}
