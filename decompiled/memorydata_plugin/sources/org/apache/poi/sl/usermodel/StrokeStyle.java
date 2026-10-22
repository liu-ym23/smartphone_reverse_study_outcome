package org.apache.poi.sl.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface StrokeStyle {

    public static final enum LineCap extends Enum<LineCap> {
        private static final /* synthetic */ LineCap[] $VALUES = null;
        public static final LineCap FLAT = null;
        public static final LineCap ROUND = null;
        public static final LineCap SQUARE = null;
        public final int nativeId;
        public final int ooxmlId;

        static {
            LineCap r0 = new LineCap("ROUND", 0, 0, 1);
            ROUND = r0;
            LineCap r1 = new LineCap("SQUARE", 1, 1, 2);
            SQUARE = r1;
            LineCap r4 = new LineCap("FLAT", 2, 2, 3);
            FLAT = r4;
            $VALUES = new LineCap[]{r0, r1, r4};
        }

        private LineCap(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.nativeId = r3;
            this.ooxmlId = r4;
        }

        public static LineCap fromNativeId(int r5) {
            LineCap[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            LineCap r3 = r0[r2];
            if (r3.nativeId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static LineCap fromOoxmlId(int r5) {
            LineCap[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            LineCap r3 = r0[r2];
            if (r3.ooxmlId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static LineCap valueOf(String r2) {
            return (LineCap) ZeusTransformUtils.preCheckCast(Enum.valueOf(LineCap.class, r2), LineCap.class, "com.obric.memorydata.plugin");
        }

        public static LineCap[] values() {
            return (LineCap[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LineCap[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum LineCompound extends Enum<LineCompound> {
        private static final /* synthetic */ LineCompound[] $VALUES = null;
        public static final LineCompound DOUBLE = null;
        public static final LineCompound SINGLE = null;
        public static final LineCompound THICK_THIN = null;
        public static final LineCompound THIN_THICK = null;
        public static final LineCompound TRIPLE = null;
        public final int nativeId;
        public final int ooxmlId;

        static {
            LineCompound r0 = new LineCompound("SINGLE", 0, 0, 1);
            SINGLE = r0;
            LineCompound r1 = new LineCompound("DOUBLE", 1, 1, 2);
            DOUBLE = r1;
            LineCompound r4 = new LineCompound("THICK_THIN", 2, 2, 3);
            THICK_THIN = r4;
            LineCompound r6 = new LineCompound("THIN_THICK", 3, 3, 4);
            THIN_THICK = r6;
            LineCompound r8 = new LineCompound("TRIPLE", 4, 4, 5);
            TRIPLE = r8;
            $VALUES = new LineCompound[]{r0, r1, r4, r6, r8};
        }

        private LineCompound(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.nativeId = r3;
            this.ooxmlId = r4;
        }

        public static LineCompound fromNativeId(int r5) {
            LineCompound[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            LineCompound r3 = r0[r2];
            if (r3.nativeId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static LineCompound fromOoxmlId(int r5) {
            LineCompound[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            LineCompound r3 = r0[r2];
            if (r3.ooxmlId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static LineCompound valueOf(String r2) {
            return (LineCompound) ZeusTransformUtils.preCheckCast(Enum.valueOf(LineCompound.class, r2), LineCompound.class, "com.obric.memorydata.plugin");
        }

        public static LineCompound[] values() {
            return (LineCompound[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LineCompound[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum LineDash extends Enum<LineDash> {
        private static final /* synthetic */ LineDash[] $VALUES = null;
        public static final LineDash DASH = null;
        public static final LineDash DASH_DOT = null;
        public static final LineDash DOT = null;
        public static final LineDash LG_DASH = null;
        public static final LineDash LG_DASH_DOT = null;
        public static final LineDash LG_DASH_DOT_DOT = null;
        public static final LineDash SOLID = null;
        public static final LineDash SYS_DASH = null;
        public static final LineDash SYS_DASH_DOT = null;
        public static final LineDash SYS_DASH_DOT_DOT = null;
        public static final LineDash SYS_DOT = null;
        public final int nativeId;
        public final int ooxmlId;
        public final int[] pattern;

        static {
            LineDash r6 = new LineDash("SOLID", 0, 1, 1, null);
            SOLID = r6;
            LineDash r0 = new LineDash("DOT", 1, 6, 2, new int[]{1, 1});
            DOT = r0;
            LineDash r2 = new LineDash("DASH", 2, 7, 3, new int[]{3, 4});
            DASH = r2;
            LineDash r3 = new LineDash("DASH_DOT", 3, 9, 5, new int[]{4, 3, 1, 3});
            DASH_DOT = r3;
            LineDash r5 = new LineDash("LG_DASH", 4, 8, 4, new int[]{8, 3});
            LG_DASH = r5;
            LineDash r7 = new LineDash("LG_DASH_DOT", 5, 10, 6, new int[]{8, 3, 1, 3});
            LG_DASH_DOT = r7;
            LineDash r8 = new LineDash("LG_DASH_DOT_DOT", 6, 11, 7, new int[]{8, 3, 1, 3, 1, 3});
            LG_DASH_DOT_DOT = r8;
            LineDash r10 = new LineDash("SYS_DASH", 7, 2, 8, new int[]{2, 2});
            SYS_DASH = r10;
            LineDash r11 = new LineDash("SYS_DOT", 8, 3, 9, new int[]{1, 1});
            SYS_DOT = r11;
            LineDash r12 = new LineDash("SYS_DASH_DOT", 9, 4, 10, new int[]{2, 2, 1, 1});
            SYS_DASH_DOT = r12;
            LineDash r13 = new LineDash("SYS_DASH_DOT_DOT", 10, 5, 11, new int[]{2, 2, 1, 1, 1, 1});
            SYS_DASH_DOT_DOT = r13;
            $VALUES = new LineDash[]{r6, r0, r2, r3, r5, r7, r8, r10, r11, r12, r13};
        }

        private LineDash(String r1, int r2, int r3, int r4, int... r5) {
            super(r1, r2);
            this.nativeId = r3;
            this.ooxmlId = r4;
            if (r5 != null) goto L5;
        L6:
            r5 = null;
        L7:
            this.pattern = r5;
            return;
        L5:
            if (r5.length != 0) goto L7;
            goto L6
        }

        public static LineDash fromNativeId(int r5) {
            LineDash[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            LineDash r3 = r0[r2];
            if (r3.nativeId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static LineDash fromOoxmlId(int r5) {
            LineDash[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            LineDash r3 = r0[r2];
            if (r3.ooxmlId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static LineDash valueOf(String r2) {
            return (LineDash) ZeusTransformUtils.preCheckCast(Enum.valueOf(LineDash.class, r2), LineDash.class, "com.obric.memorydata.plugin");
        }

        public static LineDash[] values() {
            return (LineDash[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LineDash[].class, "com.obric.memorydata.plugin");
        }
    }
}
