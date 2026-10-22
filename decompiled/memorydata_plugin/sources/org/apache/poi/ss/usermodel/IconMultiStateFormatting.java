package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface IconMultiStateFormatting {

    public static final enum IconSet extends Enum<IconSet> {
        private static final /* synthetic */ IconSet[] $VALUES = null;
        public static final IconSet GREY_3_ARROWS = null;
        public static final IconSet GREY_4_ARROWS = null;
        public static final IconSet GREY_5_ARROWS = null;
        public static final IconSet GYRB_4_TRAFFIC_LIGHTS = null;
        public static final IconSet GYR_3_ARROW = null;
        public static final IconSet GYR_3_FLAGS = null;
        public static final IconSet GYR_3_SHAPES = null;
        public static final IconSet GYR_3_SYMBOLS = null;
        public static final IconSet GYR_3_SYMBOLS_CIRCLE = null;
        public static final IconSet GYR_3_TRAFFIC_LIGHTS = null;
        public static final IconSet GYR_3_TRAFFIC_LIGHTS_BOX = null;
        public static final IconSet GYR_4_ARROWS = null;
        public static final IconSet GYYYR_5_ARROWS = null;
        public static final IconSet QUARTERS_5 = null;
        public static final IconSet RATINGS_4 = null;
        public static final IconSet RATINGS_5 = null;
        public static final IconSet RB_4_TRAFFIC_LIGHTS = null;
        public final int id;
        public final String name;
        public final int num;

        static {
            IconSet r6 = new IconSet("GYR_3_ARROW", 0, 0, 3, "3Arrows");
            GYR_3_ARROW = r6;
            IconSet r0 = new IconSet("GREY_3_ARROWS", 1, 1, 3, "3ArrowsGray");
            GREY_3_ARROWS = r0;
            IconSet r1 = new IconSet("GYR_3_FLAGS", 2, 2, 3, "3Flags");
            GYR_3_FLAGS = r1;
            IconSet r2 = new IconSet("GYR_3_TRAFFIC_LIGHTS", 3, 3, 3, "3TrafficLights1");
            GYR_3_TRAFFIC_LIGHTS = r2;
            IconSet r3 = new IconSet("GYR_3_TRAFFIC_LIGHTS_BOX", 4, 4, 3, "3TrafficLights2");
            GYR_3_TRAFFIC_LIGHTS_BOX = r3;
            IconSet r4 = new IconSet("GYR_3_SHAPES", 5, 5, 3, "3Signs");
            GYR_3_SHAPES = r4;
            IconSet r5 = new IconSet("GYR_3_SYMBOLS_CIRCLE", 6, 6, 3, "3Symbols");
            GYR_3_SYMBOLS_CIRCLE = r5;
            IconSet r13 = new IconSet("GYR_3_SYMBOLS", 7, 7, 3, "3Symbols2");
            GYR_3_SYMBOLS = r13;
            IconSet r7 = new IconSet("GYR_4_ARROWS", 8, 8, 4, "4Arrows");
            GYR_4_ARROWS = r7;
            IconSet r8 = new IconSet("GREY_4_ARROWS", 9, 9, 4, "4ArrowsGray");
            GREY_4_ARROWS = r8;
            IconSet r9 = new IconSet("RB_4_TRAFFIC_LIGHTS", 10, 10, 4, "4RedToBlack");
            RB_4_TRAFFIC_LIGHTS = r9;
            IconSet r10 = new IconSet("RATINGS_4", 11, 11, 4, "4Rating");
            RATINGS_4 = r10;
            IconSet r11 = new IconSet("GYRB_4_TRAFFIC_LIGHTS", 12, 12, 4, "4TrafficLights");
            GYRB_4_TRAFFIC_LIGHTS = r11;
            IconSet r12 = new IconSet("GYYYR_5_ARROWS", 13, 13, 5, "5Arrows");
            GYYYR_5_ARROWS = r12;
            IconSet r20 = new IconSet("GREY_5_ARROWS", 14, 14, 5, "5ArrowsGray");
            GREY_5_ARROWS = r20;
            IconSet r14 = new IconSet("RATINGS_5", 15, 15, 5, "5Rating");
            RATINGS_5 = r14;
            IconSet r15 = new IconSet("QUARTERS_5", 16, 16, 5, "5Quarters");
            QUARTERS_5 = r15;
            $VALUES = new IconSet[]{r6, r0, r1, r2, r3, r4, r5, r13, r7, r8, r9, r10, r11, r12, r20, r14, r15};
        }

        private IconSet(String r1, int r2, int r3, int r4, String r5) {
            super(r1, r2);
            this.id = r3;
            this.num = r4;
            this.name = r5;
        }

        public static IconSet byId(int r1) {
            return values()[r1];
        }

        public static IconSet byName(String r5) {
            IconSet[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            IconSet r3 = r0[r2];
            if (r3.name.equals(r5) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static IconSet valueOf(String r2) {
            return (IconSet) ZeusTransformUtils.preCheckCast(Enum.valueOf(IconSet.class, r2), IconSet.class, "com.obric.memorydata.plugin");
        }

        public static IconSet[] values() {
            return (IconSet[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IconSet[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.id + " - " + this.name;
        }
    }
}
