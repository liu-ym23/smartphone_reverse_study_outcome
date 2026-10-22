package org.apache.poi.sl.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface PaintStyle {

    public static final enum FlipMode extends Enum<FlipMode> {
        private static final /* synthetic */ FlipMode[] $VALUES = null;
        public static final FlipMode NONE = null;
        public static final FlipMode X = null;
        public static final FlipMode XY = null;
        public static final FlipMode Y = null;

        static {
            FlipMode r0 = new FlipMode("NONE", 0);
            NONE = r0;
            FlipMode r1 = new FlipMode("X", 1);
            X = r1;
            FlipMode r3 = new FlipMode("Y", 2);
            Y = r3;
            FlipMode r5 = new FlipMode("XY", 3);
            XY = r5;
            $VALUES = new FlipMode[]{r0, r1, r3, r5};
        }

        private FlipMode(String r1, int r2) {
            super(r1, r2);
        }

        public static FlipMode valueOf(String r2) {
            return (FlipMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(FlipMode.class, r2), FlipMode.class, "com.obric.memorydata.plugin");
        }

        public static FlipMode[] values() {
            return (FlipMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FlipMode[].class, "com.obric.memorydata.plugin");
        }
    }

    public interface GradientPaint extends PaintStyle {

        public static final enum GradientType extends Enum<GradientType> {
            private static final /* synthetic */ GradientType[] $VALUES = null;
            public static final GradientType circular = null;
            public static final GradientType linear = null;
            public static final GradientType rectangular = null;
            public static final GradientType shape = null;

            static {
                GradientType r0 = new GradientType("linear", 0);
                linear = r0;
                GradientType r1 = new GradientType("circular", 1);
                circular = r1;
                GradientType r3 = new GradientType("rectangular", 2);
                rectangular = r3;
                GradientType r5 = new GradientType("shape", 3);
                shape = r5;
                $VALUES = new GradientType[]{r0, r1, r3, r5};
            }

            private GradientType(String r1, int r2) {
                super(r1, r2);
            }

            public static GradientType valueOf(String r2) {
                return (GradientType) ZeusTransformUtils.preCheckCast(Enum.valueOf(GradientType.class, r2), GradientType.class, "com.obric.memorydata.plugin");
            }

            public static GradientType[] values() {
                return (GradientType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GradientType[].class, "com.obric.memorydata.plugin");
            }
        }
    }

    public static final enum PaintModifier extends Enum<PaintModifier> {
        private static final /* synthetic */ PaintModifier[] $VALUES = null;
        public static final PaintModifier DARKEN = null;
        public static final PaintModifier DARKEN_LESS = null;
        public static final PaintModifier LIGHTEN = null;
        public static final PaintModifier LIGHTEN_LESS = null;
        public static final PaintModifier NONE = null;
        public static final PaintModifier NORM = null;

        static {
            PaintModifier r0 = new PaintModifier("NONE", 0);
            NONE = r0;
            PaintModifier r1 = new PaintModifier("NORM", 1);
            NORM = r1;
            PaintModifier r3 = new PaintModifier("LIGHTEN", 2);
            LIGHTEN = r3;
            PaintModifier r5 = new PaintModifier("LIGHTEN_LESS", 3);
            LIGHTEN_LESS = r5;
            PaintModifier r7 = new PaintModifier("DARKEN", 4);
            DARKEN = r7;
            PaintModifier r9 = new PaintModifier("DARKEN_LESS", 5);
            DARKEN_LESS = r9;
            $VALUES = new PaintModifier[]{r0, r1, r3, r5, r7, r9};
        }

        private PaintModifier(String r1, int r2) {
            super(r1, r2);
        }

        public static PaintModifier valueOf(String r2) {
            return (PaintModifier) ZeusTransformUtils.preCheckCast(Enum.valueOf(PaintModifier.class, r2), PaintModifier.class, "com.obric.memorydata.plugin");
        }

        public static PaintModifier[] values() {
            return (PaintModifier[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PaintModifier[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum TextureAlignment extends Enum<TextureAlignment> {
        private static final /* synthetic */ TextureAlignment[] $VALUES = null;
        public static final TextureAlignment BOTTOM = null;
        public static final TextureAlignment BOTTOM_LEFT = null;
        public static final TextureAlignment BOTTOM_RIGHT = null;
        public static final TextureAlignment CENTER = null;
        public static final TextureAlignment LEFT = null;
        public static final TextureAlignment RIGHT = null;
        public static final TextureAlignment TOP = null;
        public static final TextureAlignment TOP_LEFT = null;
        public static final TextureAlignment TOP_RIGHT = null;
        private final String ooxmlId;

        static {
            TextureAlignment r0 = new TextureAlignment("BOTTOM", 0, "b");
            BOTTOM = r0;
            TextureAlignment r1 = new TextureAlignment("BOTTOM_LEFT", 1, "bl");
            BOTTOM_LEFT = r1;
            TextureAlignment r3 = new TextureAlignment("BOTTOM_RIGHT", 2, "br");
            BOTTOM_RIGHT = r3;
            TextureAlignment r5 = new TextureAlignment("CENTER", 3, "ctr");
            CENTER = r5;
            TextureAlignment r7 = new TextureAlignment("LEFT", 4, "l");
            LEFT = r7;
            TextureAlignment r9 = new TextureAlignment("RIGHT", 5, "r");
            RIGHT = r9;
            TextureAlignment r11 = new TextureAlignment("TOP", 6, "t");
            TOP = r11;
            TextureAlignment r13 = new TextureAlignment("TOP_LEFT", 7, "tl");
            TOP_LEFT = r13;
            TextureAlignment r12 = new TextureAlignment("TOP_RIGHT", 8, "tr");
            TOP_RIGHT = r12;
            $VALUES = new TextureAlignment[]{r0, r1, r3, r5, r7, r9, r11, r13, r12};
        }

        private TextureAlignment(String r1, int r2, String r3) {
            super(r1, r2);
            this.ooxmlId = r3;
        }

        public static TextureAlignment fromOoxmlId(String r5) {
            TextureAlignment[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            TextureAlignment r3 = r0[r2];
            if (r3.ooxmlId.equals(r5) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static TextureAlignment valueOf(String r2) {
            return (TextureAlignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextureAlignment.class, r2), TextureAlignment.class, "com.obric.memorydata.plugin");
        }

        public static TextureAlignment[] values() {
            return (TextureAlignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextureAlignment[].class, "com.obric.memorydata.plugin");
        }
    }
}
