package org.apache.commons.math3.dfp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class DfpField implements Field<Dfp> {
    private int ieeeFlags;
    private final Dfp one;
    private final Dfp pi;
    private final Dfp[] piSplit;
    private RoundingMode rMode;
    private final int radixDigits;
    private final Dfp[] sqr2Split;
    private final Dfp two;
    private final Dfp zero;

    public static final enum RoundingMode extends Enum<RoundingMode> {
        private static final /* synthetic */ RoundingMode[] $VALUES = null;
        public static final RoundingMode ROUND_CEIL = null;
        public static final RoundingMode ROUND_DOWN = null;
        public static final RoundingMode ROUND_FLOOR = null;
        public static final RoundingMode ROUND_HALF_DOWN = null;
        public static final RoundingMode ROUND_HALF_EVEN = null;
        public static final RoundingMode ROUND_HALF_ODD = null;
        public static final RoundingMode ROUND_HALF_UP = null;
        public static final RoundingMode ROUND_UP = null;

        static {
            RoundingMode r0 = new RoundingMode("ROUND_DOWN", 0);
            ROUND_DOWN = r0;
            RoundingMode r1 = new RoundingMode("ROUND_UP", 1);
            ROUND_UP = r1;
            RoundingMode r3 = new RoundingMode("ROUND_HALF_UP", 2);
            ROUND_HALF_UP = r3;
            RoundingMode r5 = new RoundingMode("ROUND_HALF_DOWN", 3);
            ROUND_HALF_DOWN = r5;
            RoundingMode r7 = new RoundingMode("ROUND_HALF_EVEN", 4);
            ROUND_HALF_EVEN = r7;
            RoundingMode r9 = new RoundingMode("ROUND_HALF_ODD", 5);
            ROUND_HALF_ODD = r9;
            RoundingMode r11 = new RoundingMode("ROUND_CEIL", 6);
            ROUND_CEIL = r11;
            RoundingMode r13 = new RoundingMode("ROUND_FLOOR", 7);
            ROUND_FLOOR = r13;
            $VALUES = new RoundingMode[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private RoundingMode(String r1, int r2) {
            super(r1, r2);
        }

        public static RoundingMode valueOf(String r2) {
            return (RoundingMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(RoundingMode.class, r2), RoundingMode.class, "com.obric.memorydata.plugin");
        }

        public static RoundingMode[] values() {
            return (RoundingMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RoundingMode[].class, "com.obric.memorydata.plugin");
        }
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ Dfp getOne() {
        return getOne2();
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getOne, reason: avoid collision after fix types in other method */
    public Dfp getOne2() {
        return this.one;
    }

    public Dfp getPi() {
        return this.pi;
    }

    public Dfp[] getPiSplit() {
        return (Dfp[]) ZeusTransformUtils.preCheckCast(this.piSplit.clone(), Dfp[].class, "com.obric.memorydata.plugin");
    }

    public int getRadixDigits() {
        return this.radixDigits;
    }

    public RoundingMode getRoundingMode() {
        return this.rMode;
    }

    @Override // org.apache.commons.math3.Field
    public Class<? extends FieldElement<Dfp>> getRuntimeClass() {
        return Dfp.class;
    }

    public Dfp[] getSqr2Split() {
        return (Dfp[]) ZeusTransformUtils.preCheckCast(this.sqr2Split.clone(), Dfp[].class, "com.obric.memorydata.plugin");
    }

    public Dfp getTwo() {
        return this.two;
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ Dfp getZero() {
        return getZero2();
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getZero, reason: avoid collision after fix types in other method */
    public Dfp getZero2() {
        return this.zero;
    }

    public void setIEEEFlagsBits(int r2) {
        int r3 = r2 & 31;
        this.ieeeFlags = r3 | this.ieeeFlags;
    }
}
