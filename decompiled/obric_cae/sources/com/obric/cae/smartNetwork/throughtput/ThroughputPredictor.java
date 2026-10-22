package com.obric.cae.smartNetwork.throughtput;

import com.obric.cae.log.CaeLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ThroughputPredictor {
    private static final String TAG = "ThroughputPredictor";
    private static List<Segment> segments2G;
    private static List<Segment> segments5G;
    private static SplitStrategy strategy2G;
    private static SplitStrategy strategy5G;

    public static final enum Band extends Enum<Band> {
        private static final /* synthetic */ Band[] $VALUES = null;
        public static final Band BAND_2G = null;
        public static final Band BAND_5G = null;

        private static /* synthetic */ Band[] $values() {
            return new Band[]{BAND_2G, BAND_5G};
        }

        static {
            BAND_2G = new Band("BAND_2G", 0);
            BAND_5G = new Band("BAND_5G", 1);
            $VALUES = $values();
        }

        private Band(String r8, int r10) {
            super(r8, r10);
        }

        public static Band valueOf(String r8) {
            return (Band) Enum.valueOf(Band.class, r8);
        }

        public static Band[] values() {
            return (Band[]) $VALUES.clone();
        }
    }

    public static class Segment {
        public double[] coeffs;
        public double max;
        public double min;

        public Segment(double r8, double r10, double[] r11) {
            this.min = r8;
            this.max = r10;
            this.coeffs = r11;
        }

        public boolean inRange(double r8) {
            if (r8 >= this.min) goto L5;
        L7:
            return false;
        L5:
            if (r8 >= this.max) goto L7;
            return true;
        }
    }

    public static final enum SplitStrategy extends Enum<SplitStrategy> {
        private static final /* synthetic */ SplitStrategy[] $VALUES = null;
        public static final SplitStrategy BY_CCA_BUSY_RATE = null;
        public static final SplitStrategy BY_PER_RATE = null;
        public static final SplitStrategy BY_RX_LINK_SPEED = null;

        private static /* synthetic */ SplitStrategy[] $values() {
            return new SplitStrategy[]{BY_PER_RATE, BY_RX_LINK_SPEED, BY_CCA_BUSY_RATE};
        }

        static {
            BY_PER_RATE = new SplitStrategy("BY_PER_RATE", 0);
            BY_RX_LINK_SPEED = new SplitStrategy("BY_RX_LINK_SPEED", 1);
            BY_CCA_BUSY_RATE = new SplitStrategy("BY_CCA_BUSY_RATE", 2);
            $VALUES = $values();
        }

        private SplitStrategy(String r8, int r10) {
            super(r8, r10);
        }

        public static SplitStrategy valueOf(String r8) {
            return (SplitStrategy) Enum.valueOf(SplitStrategy.class, r8);
        }

        public static SplitStrategy[] values() {
            return (SplitStrategy[]) $VALUES.clone();
        }
    }

    static {
        segments5G = new ArrayList();
        segments2G = new ArrayList();
    }

    public ThroughputPredictor() {
    }

    private static double applyFormula(double[] r8, double r10, double r11, double r12) {
        double r13 = r8[0];
        double r14 = (r8[1] * r10) + r13;
        double r15 = (r8[2] * r11) + r14;
        double r16 = (r8[3] * r12) + r15;
        double r17 = ((r8[4] * r10) * r10) + r16;
        double r18 = ((r8[5] * r10) * r11) + r17;
        double r19 = ((r8[6] * r10) * r12) + r18;
        double r20 = ((r8[7] * r11) * r11) + r19;
        double r21 = ((r8[8] * r11) * r12) + r20;
        return ((r8[9] * r12) * r12) + r21;
    }

    public static double predict(Band r12, double r13, double r15, double r17) {
        Band r8 = Band.BAND_5G;
        if (r12 != r8) goto L11;
        if (strategy5G != SplitStrategy.BY_PER_RATE) goto L8;
    L12:
        double r10 = r13;
    L17:
        if (r12 != r8) goto L19;
        List<Segment> r11 = segments5G;
    L20:
        Iterator<Segment> r14 = r11.iterator();
    L22:
        if (r14.hasNext() == false) goto L27;
        Segment r16 = r14.next();
        if (r16.inRange(r10) == false) goto L22;
        return applyFormula(r16.coeffs, r13, r15, r17);
    L27:
        CaeLog.e(TAG, "predict: no segment found");
        return 0.0d;
    L19:
        r11 = segments2G;
        goto L20
    L8:
        if (strategy5G == SplitStrategy.BY_RX_LINK_SPEED) goto L15;
    L16:
        r10 = r17;
    L15:
        r10 = r15;
        goto L17
    L11:
        if (strategy2G == SplitStrategy.BY_PER_RATE) goto L12;
        if (strategy2G != SplitStrategy.BY_RX_LINK_SPEED) goto L16;
        goto L15
    }

    public static void setSegments(Band r8, List<Segment> r10) {
        if (r8 != Band.BAND_5G) goto L5;
        segments5G = r10;
        return;
    L5:
        segments2G = r10;
    }

    public static void setStrategy(Band r8, SplitStrategy r10) {
        if (r8 != Band.BAND_5G) goto L5;
        strategy5G = r10;
        return;
    L5:
        strategy2G = r10;
    }
}
