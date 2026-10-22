package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFChart {
    private HSSFChartType type;

    /* JADX INFO: renamed from: org.apache.poi.hssf.usermodel.HSSFChart$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract enum HSSFChartType extends Enum<HSSFChartType> {
        private static final /* synthetic */ HSSFChartType[] $VALUES = null;
        public static final HSSFChartType Area = null;
        public static final HSSFChartType Bar = null;
        public static final HSSFChartType Line = null;
        public static final HSSFChartType Pie = null;
        public static final HSSFChartType Scatter = null;
        public static final HSSFChartType Unknown = null;

        static {
            final String r1 = "Area";
            final int r2 = 0;
            HSSFChartType r0 = new AnonymousClass1(r1, r2);
            Area = r0;
            final String r3 = "Bar";
            final int r4 = 1;
            HSSFChartType r5 = new AnonymousClass2(r3, r4);
            Bar = r5;
            final String r6 = "Line";
            final int r7 = 2;
            HSSFChartType r8 = new AnonymousClass3(r6, r7);
            Line = r8;
            final String r9 = "Pie";
            final int r10 = 3;
            HSSFChartType r11 = new AnonymousClass4(r9, r10);
            Pie = r11;
            final String r12 = "Scatter";
            final int r13 = 4;
            HSSFChartType r14 = new AnonymousClass5(r12, r13);
            Scatter = r14;
            final String r15 = "Unknown";
            final int r16 = 5;
            HSSFChartType r17 = new AnonymousClass6(r15, r16);
            Unknown = r17;
            $VALUES = new HSSFChartType[]{r0, r5, r8, r11, r14, r17};
        }

        private HSSFChartType(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ HSSFChartType(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static HSSFChartType valueOf(String r2) {
            return (HSSFChartType) ZeusTransformUtils.preCheckCast(Enum.valueOf(HSSFChartType.class, r2), HSSFChartType.class, "com.obric.memorydata.plugin");
        }

        public static HSSFChartType[] values() {
            return (HSSFChartType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HSSFChartType[].class, "com.obric.memorydata.plugin");
        }

        public abstract short getSid();
    }

    public HSSFChartType getType() {
        return this.type;
    }
}
