package org.apache.poi.sl.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface LineDecoration {

    public static final enum DecorationShape extends Enum<DecorationShape> {
        private static final /* synthetic */ DecorationShape[] $VALUES = null;
        public static final DecorationShape ARROW = null;
        public static final DecorationShape DIAMOND = null;
        public static final DecorationShape NONE = null;
        public static final DecorationShape OVAL = null;
        public static final DecorationShape STEALTH = null;
        public static final DecorationShape TRIANGLE = null;
        public final int nativeId;
        public final int ooxmlId;

        static {
            DecorationShape r0 = new DecorationShape("NONE", 0, 0, 1);
            NONE = r0;
            DecorationShape r1 = new DecorationShape("TRIANGLE", 1, 1, 2);
            TRIANGLE = r1;
            DecorationShape r4 = new DecorationShape("STEALTH", 2, 2, 3);
            STEALTH = r4;
            DecorationShape r6 = new DecorationShape("DIAMOND", 3, 3, 4);
            DIAMOND = r6;
            DecorationShape r8 = new DecorationShape("OVAL", 4, 4, 5);
            OVAL = r8;
            DecorationShape r10 = new DecorationShape("ARROW", 5, 5, 6);
            ARROW = r10;
            $VALUES = new DecorationShape[]{r0, r1, r4, r6, r8, r10};
        }

        private DecorationShape(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.nativeId = r3;
            this.ooxmlId = r4;
        }

        public static DecorationShape fromNativeId(int r5) {
            DecorationShape[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            DecorationShape r3 = r0[r2];
            if (r3.nativeId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static DecorationShape fromOoxmlId(int r5) {
            DecorationShape[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            DecorationShape r3 = r0[r2];
            if (r3.ooxmlId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static DecorationShape valueOf(String r2) {
            return (DecorationShape) ZeusTransformUtils.preCheckCast(Enum.valueOf(DecorationShape.class, r2), DecorationShape.class, "com.obric.memorydata.plugin");
        }

        public static DecorationShape[] values() {
            return (DecorationShape[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DecorationShape[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum DecorationSize extends Enum<DecorationSize> {
        private static final /* synthetic */ DecorationSize[] $VALUES = null;
        public static final DecorationSize LARGE = null;
        public static final DecorationSize MEDIUM = null;
        public static final DecorationSize SMALL = null;
        public final int nativeId;
        public final int ooxmlId;

        static {
            DecorationSize r0 = new DecorationSize("SMALL", 0, 0, 1);
            SMALL = r0;
            DecorationSize r1 = new DecorationSize("MEDIUM", 1, 1, 2);
            MEDIUM = r1;
            DecorationSize r4 = new DecorationSize("LARGE", 2, 2, 3);
            LARGE = r4;
            $VALUES = new DecorationSize[]{r0, r1, r4};
        }

        private DecorationSize(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.nativeId = r3;
            this.ooxmlId = r4;
        }

        public static DecorationSize fromNativeId(int r5) {
            DecorationSize[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            DecorationSize r3 = r0[r2];
            if (r3.nativeId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static DecorationSize fromOoxmlId(int r5) {
            DecorationSize[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            DecorationSize r3 = r0[r2];
            if (r3.ooxmlId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static DecorationSize valueOf(String r2) {
            return (DecorationSize) ZeusTransformUtils.preCheckCast(Enum.valueOf(DecorationSize.class, r2), DecorationSize.class, "com.obric.memorydata.plugin");
        }

        public static DecorationSize[] values() {
            return (DecorationSize[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DecorationSize[].class, "com.obric.memorydata.plugin");
        }
    }
}
