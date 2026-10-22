package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface ConditionalFormattingThreshold {

    public static final enum RangeType extends Enum<RangeType> {
        private static final /* synthetic */ RangeType[] $VALUES = null;
        public static final RangeType FORMULA = null;
        public static final RangeType MAX = null;
        public static final RangeType MIN = null;
        public static final RangeType NUMBER = null;
        public static final RangeType PERCENT = null;
        public static final RangeType PERCENTILE = null;
        public static final RangeType UNALLOCATED = null;
        public final int id;
        public final String name;

        static {
            RangeType r0 = new RangeType("NUMBER", 0, 1, "num");
            NUMBER = r0;
            RangeType r1 = new RangeType("MIN", 1, 2, "min");
            MIN = r1;
            RangeType r4 = new RangeType("MAX", 2, 3, "max");
            MAX = r4;
            RangeType r6 = new RangeType("PERCENT", 3, 4, "percent");
            PERCENT = r6;
            RangeType r8 = new RangeType("PERCENTILE", 4, 5, "percentile");
            PERCENTILE = r8;
            RangeType r10 = new RangeType("UNALLOCATED", 5, 6, null);
            UNALLOCATED = r10;
            RangeType r12 = new RangeType("FORMULA", 6, 7, "formula");
            FORMULA = r12;
            $VALUES = new RangeType[]{r0, r1, r4, r6, r8, r10, r12};
        }

        private RangeType(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.id = r3;
            this.name = r4;
        }

        public static RangeType byId(int r1) {
            if (r1 > 0) goto L4;
            return null;
        L4:
            if (r1 <= values().length) goto L7;
            return null;
        L7:
            return values()[r1 - 1];
        }

        public static RangeType byName(String r5) {
            RangeType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L13;
            RangeType r3 = r0[r2];
            String r4 = r3.name;
            if (r4 != null) goto L8;
            if (r5 != null) goto L8;
            return r3;
        L8:
            if (r4 == null) goto L12;
            if (r4.equals(r5) == false) goto L12;
            return r3;
        L12:
            r2 = r2 + 1;
            goto L3
        L13:
            return null;
        }

        public static RangeType valueOf(String r2) {
            return (RangeType) ZeusTransformUtils.preCheckCast(Enum.valueOf(RangeType.class, r2), RangeType.class, "com.obric.memorydata.plugin");
        }

        public static RangeType[] values() {
            return (RangeType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RangeType[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.id + " - " + this.name;
        }
    }
}
